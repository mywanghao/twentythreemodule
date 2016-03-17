package com.example.imagecachedemo.cache;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.os.Handler;
import android.os.Message;
import android.widget.ImageView;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * 网络缓存图片的工具类
 *
 * @author 王浩
 */
public class NetCatchUtils {

    /**
     * 网络请求图片成功
     */
    public static final int SUCESS = 0;
    /**
     * 网络请求图片失败
     */
    public static final int FAIL = 1;
    private Handler handler;
    /**
     * 本地缓存工具类
     */
    private LocalCacheUtils localCacheUtils;
    /**
     * 内存缓存工具
     */
    private MemoryCacheUtils memoryCacheUtils;

    public NetCatchUtils(Handler handler, LocalCacheUtils localCacheUtils,
                         MemoryCacheUtils memoryCacheUtils) {
        // TODO Auto-generated constructor stub
        this.handler = handler;
        this.localCacheUtils = localCacheUtils;
        this.memoryCacheUtils = memoryCacheUtils;
    }

    /**
     * 根据图片路径，请求网络图片
     *
     * @param url
     * @param position
     * @return
     */
    public Bitmap getBitmapFromUrl(String url, int position, int tag,
                                   Activity ac, ImageView tv_image) {
        new Thread(new MyRunnable(url, position, tag, ac, tv_image)).start();

        return null;
    }

    class MyRunnable implements Runnable {

        private String url;
        private int position;
        private int tag;
        private Activity ac;
        private ImageView tv_image;

        public MyRunnable(String url, int position, int tag, Activity ac,
                          ImageView tv_image) {



            this.url = url;
            this.position = position;
            this.tag = tag;
            this.ac = ac;
            this.tv_image = tv_image;
        }


        /**
         * 处理大图片加载问题
         */
        @Override
        public void run() {
            HttpURLConnection con = null;
            try {

                  con = (HttpURLConnection) new
                        URL(url).openConnection();

                int code = con.getResponseCode();


                if (200 == code) {
                    InputStream is = con.getInputStream();

                    Options opts = new Options();

                    // 根据计算出的比例进行缩放
                    int scale = ImageUtils.getScare(url, ac);
                    opts.inSampleSize = scale;

                    Bitmap bm = BitmapFactory.decodeStream(is, null, opts);

                    // 将bm发生给主线程用于显示图片，更新UI
                    Message msg = Message.obtain();
                    msg.obj = bm;
                    msg.arg1 = tag;
                    msg.arg2 = position;



                    tv_image.post(new Action(bm, tv_image));
//                    if(handler!=null) {
//                        tv_image.post(new Action(bm, tv_image));
//                        //handler.sendMessage(msg);
//                    } else {
//                        Utils.log2("tv_image:" + bm + "————tv_image:" + tv_image);
//                        //tv_image.setImageBitmap(bm);
//
//
//                    }

                    // 保存一份在内存
                    memoryCacheUtils.putBitmap2Memory(url, bm);
                    // 保存一份在本地（Sdcard）
                    localCacheUtils.putBitmap2Local(url, bm);

                }
            } catch (Exception e) {
//                e.printStackTrace();
            }

        }

    }


    /**
     * 在主线程更新UI
     */
    class Action implements Runnable{

        private Bitmap  bit ;
        private ImageView img  ;

        public Action(Bitmap bit,ImageView img) {
            this.bit  = bit;
            this.img  = img;
        }


        @Override
        public void run() {

            img.setImageBitmap(bit);
        }
    }

}
