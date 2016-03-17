package com.example.imagecachedemo.cache;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.widget.ImageView;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class LocalCacheUtils {
	/**
	 * 本地缓存工具类
	 * 
	 * @author 王浩
	 *
	 */

	private static final String ATGUIT_DIR = "/mnt/sdcard/beijingnews/";

	/**
	 * 根据Bitmap保存图片到本地
	 * 
	 * @param url
	 * @param bitmap
	 */
	public void putBitmap2Local(String url, Bitmap bitmap) {
		// TODO Auto-generated method stub
		try {
			// String name = MD5Encoder.encode(url);
			// /mnt/sdcard/beijingnews/lskkskklllkk（md5加密）
			File file = new File(ATGUIT_DIR, url);
			// mnt/sdcard/beijingnews/创建
			File parentFile = file.getParentFile();
			if (!parentFile.exists()) {
				parentFile.mkdirs();
			}

			// 图片就保存到sdcard了
			FileOutputStream stream = new FileOutputStream(file);

			bitmap.compress(CompressFormat.JPEG, 100, stream);

			stream.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * 根据uri取对应的图片
	 * 
	 * @param url
	 * @return
	 */
	public Bitmap getBitmapFromUrl(String url, ImageView imageView, int tag) {
		try {
			File file = new File(ATGUIT_DIR, url);
			if (file.isFile()) {
				Bitmap bitmap = null ;
				FileInputStream fis = new FileInputStream(file);
				fis.close();
				return bitmap;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
