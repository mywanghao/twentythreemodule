package com.example.imagecachedemo.cache;

import android.graphics.Bitmap;
import android.support.v4.util.LruCache;
/**
 * LruCache工具类
 * @author 浩
 *
 */
public class MemoryCacheUtils {

	private LruCache<String, Bitmap> lruCache;//集合

	public MemoryCacheUtils() {
		int maxSize = (int) Runtime.getRuntime().maxMemory();
		lruCache = new LruCache<String, Bitmap>(maxSize){

			@Override
			protected int sizeOf(String key, Bitmap value) {
				// TODO Auto-generated method stub
				return value.getRowBytes() * value.getHeight();
			}

		
			
		};
	}

	/**
	 * 根据url从内存中得到缓存图片
	 * @param url
	 * @return
	 */
	public Bitmap getBitmapFromUril(String url) {
		// TODO Auto-generated method stub
		return lruCache.get(url);
	}

	/**
	 * 根据url，和bitmp在内存中保存一份bitmap
	 * @param url
	 * @param bitmap
	 */
	public void putBitmap2Memory(String url, Bitmap bitmap) {
		//每个应用占多少内存：16MB
		lruCache.put(url, bitmap);
		
	}

}

