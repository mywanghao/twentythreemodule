package com.example.hao.twenty_three_module;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ListView;

import java.io.ByteArrayOutputStream;
import java.io.File;

/**
 * Created by 浩 on 2015/9/16.
 */
public class Utils {


    private static final int BLACK = 0xff000000;

    private static final String ac = "" ;



    private static final float DENSITY ;

    static{
        DENSITY = Resources.getSystem().getDisplayMetrics().density;


    }



    public static void log(String log) {
        Log.v("TAA", log);
    }

    public static void log3(String log) {
        Log.e("崩溃", log);
    }

    public static void log2(String log) {
        Log.e("TAG", log);
    }

    /**
     * 得到图片的byte数组
     */
    public static byte[] getImageBytes(Bitmap bit) {

        byte[] byteArray = null;
        ByteArrayOutputStream bytestream = null;
        try {
            bytestream = new ByteArrayOutputStream();

            bit.compress(Bitmap.CompressFormat.PNG, 100, bytestream);

            byteArray = bytestream.toByteArray();


        } catch (Exception e) {

        }

        if (byteArray == null) {
            throw new RuntimeException(" NetMode getImageBytes  Error  byteArray  null");
        }

        return byteArray;
    }

    /**
     * 调用系统的裁剪
     *
     * @param uri
     */
    public static void cropPhoto(Uri uri, Activity ac) {
        Intent intent = new Intent("com.android.camera.action.CROP");
        intent.setDataAndType(uri, "image/*");
        intent.putExtra("crop", "true");
        // aspectX aspectY 是宽高的比例
        intent.putExtra("aspectX", 2);
        intent.putExtra("aspectY", 1);
        // outputX outputY 是裁剪图片宽高
        intent.putExtra("outputX", 150);
        intent.putExtra("outputY", 150);
        intent.putExtra("return-data", true);
        ac.startActivityForResult(intent, 3);
    }

    ;

    public static Bitmap resultMethod(int requestCode, int resultCode, Intent data, Activity ac) {

        Bitmap bit = null;
        switch (requestCode) {

            case 1:
                if (resultCode == ac.RESULT_OK) {

                    cropPhoto(data.getData(), ac);// 裁剪图片

                }

                break;
            case 2:
                if (resultCode == ac.RESULT_OK) {
                    File temp = new File(Environment.getExternalStorageDirectory()
                            + "/head.jpg");
                    cropPhoto(Uri.fromFile(temp), ac);// 裁剪图片
                }

                break;
            case 3:
                if (data != null) {
                    Bundle extras = data.getExtras();
                    Bitmap head = extras.getParcelable("data");
                    if (head != null) {
                        /**
                         * 上传服务器代码
                         */

                        bit = head;
                    }
                }
                break;
            default:
                break;

        }

        return bit;
    }

    ;

    /**
     * 检测网络是否链接
     *
     * @param context
     * @return
     */
    public static boolean isConnected(Context context) {
        boolean connected = false;

        ConnectivityManager manager = (ConnectivityManager) context
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = manager.getActiveNetworkInfo();
        if (networkInfo != null) {

            connected = networkInfo.isConnected();
        }
        return connected;
    }


    /**
     * 获得listview1的高度
     * 解决在Scrollview 里面嵌套 listview的bug
     *
     * @param lv
     * @param adapter
     */
    public static int setListViewHeight(ListView lv, BaseAdapter adapter) {

        int totalHeight = 0;
        for (int i = 0; i < adapter.getCount(); i++) {
            View listItem = adapter.getView(i, null, lv);
            listItem.measure(0, 0);
            totalHeight += listItem.getMeasuredHeight();
        }
        ViewGroup.LayoutParams params = lv.getLayoutParams();
        params.height = (totalHeight + (lv.getDividerHeight() * (adapter.getCount() - 1)));
        lv.setLayoutParams(params);

        return params.height;

    }

    /**
     * 获得listview1的高度
     * 新参数 自定义增加多少高度
     * 解决在Scrollview 里面嵌套 listview的bug
     *
     * @param lv
     * @param adapter
     */
    public static int setListViewHeight(ListView lv, BaseAdapter adapter, int height) {

        int totalHeight = 0;
        for (int i = 0; i < adapter.getCount(); i++) {
            View listItem = adapter.getView(i, null, lv);
            listItem.measure(0, 0);
            totalHeight += listItem.getMeasuredHeight();
        }
        ViewGroup.LayoutParams params = lv.getLayoutParams();
        params.height = (totalHeight + (lv.getDividerHeight() * (adapter.getCount() - 1)) + height);
        lv.setLayoutParams(params);

        return params.height;

    }



    public static int setViewHeight(View lv, BaseAdapter adapter, int height) {

//        int totalHeight = 0;
//        for (int i = 0; i < adapter.getCount(); i++) {
//            View listItem = adapter.getView(i, null, lv);
//            listItem.measure(0, 0);
//            totalHeight += listItem.getMeasuredHeight();
//        }
       ViewGroup.LayoutParams params = lv.getLayoutParams();
        params.height = (height + (lv.getHeight() * (adapter.getCount() - 1)) + height);
        lv.setLayoutParams(params);

        return params.height;

    }


    /**
     * 获得Gridview1的高度
     *
     * @param lv
     * @param adapter
     */
    public static void setGridViewHeight(GridView lv, BaseAdapter adapter) {

        int totalHeight = 0;
        for (int i = 0; i < adapter.getCount(); i++) {
            View listItem = adapter.getView(i, null, lv);
            listItem.measure(0, 0);
            totalHeight += listItem.getMeasuredHeight();
        }
        ViewGroup.LayoutParams params = lv.getLayoutParams();
        params.height = (int) (totalHeight / 2.5);
        lv.setLayoutParams(params);

    }


    public static void setGridViewHeight(GridView lv, BaseAdapter adapter,int height) {

        int totalHeight = 0;
        for (int i = 0; i < adapter.getCount(); i++) {
            View listItem = adapter.getView(i, null, lv);
            listItem.measure(0, 0);
            totalHeight += listItem.getMeasuredHeight();
        }
        ViewGroup.LayoutParams params = lv.getLayoutParams();
        params.height = (int) (totalHeight / 2.5)+height;
        lv.setLayoutParams(params);

    }



    /**
     * 获得当前dp的实际px
     */
    public static int dp2px(int dip){
        return Math.round(dip * DENSITY);
    }


}
