package com.example.imagecachedemo.cache;

import android.app.Activity;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.util.DisplayMetrics;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;


public class ImageUtils {

	/**
	   * 计算图片的缩放比例
	   * @return
	   */
	  public static int getScare(String imageUrl,Activity ac) {
	    try {
			HttpURLConnection con = (HttpURLConnection) new
					URL(imageUrl).openConnection();

	      int code = con.getResponseCode();

	      if (200 == code) {
	        InputStream is = con.getInputStream();
	        Options opts = new Options();
	        opts.inJustDecodeBounds = true;
	        BitmapFactory.decodeStream(is, null, opts);

	        int imageWidth = opts.outWidth;
	        int imageHeight = opts.outHeight;

	        int[] screen = measureScreen(ac);
	        int screenWidth = screen[0];
	        int screenHeight = screen[1];

	        int widthscale = imageWidth / screenWidth;
	        int heightscale = imageHeight / screenHeight;
	        int scale = widthscale > heightscale ? widthscale : heightscale;

	        return scale;
	      }
	    } catch (Exception e) {
	      e.printStackTrace();
	    }
	    return 1;//网络连接失败时默认返回1
	  }


	/**
	 * 测量当前应用的宽高 并存到 全局变量
	 * 初始化方法
	 * getScrean 自动实现 此方法
	 */
	public static int[] measureScreen(Activity ac) {
		DisplayMetrics dm = new DisplayMetrics();
		dm = ac.getResources().getDisplayMetrics();
		ac.getWindowManager().getDefaultDisplay().getMetrics(dm);

		return new int[]{dm.widthPixels,dm.heightPixels} ;
	}

	
}
