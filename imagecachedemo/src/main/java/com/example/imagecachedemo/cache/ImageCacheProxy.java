package com.example.imagecachedemo.cache;


import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Handler;
import android.widget.ImageView;

/**
 * 三级缓存工具类
 * 
 * @author wanghao
 *
 */
public class ImageCacheProxy {

	public static final int LARGE_PHOTO = -11 ;
	/**
	 * 一级本地缓存
	 */
	LocalCacheUtils localCacheUtils;
	/**
	 * 二级内存缓存
	 */
	private MemoryCacheUtils memoryCacheUtils;
	/**
	 * 三级网络获取图片
	 */
	private NetCatchUtils netUtils ;
	/**
	 * 初始化三级缓存
	 * @param handler
	 */
	public ImageCacheProxy() {
		localCacheUtils = new LocalCacheUtils();
		memoryCacheUtils = new MemoryCacheUtils();
		netUtils = new NetCatchUtils(null, localCacheUtils, memoryCacheUtils);
	}
	


		/**
		 * @param tv_image 要把bit替换成image的image
		 * @param url 请求图片的地址
		 * @param position 给图片做的tag  方便 handler ,里面 去取
		 * @param tag arg1的标记
		 */
	public void imageLoader(ImageView tv_image, String url, int position, int tag ,Activity ac) {
		Bitmap bit;

		bit = localCacheUtils.getBitmapFromUrl(url,tv_image,tag);
		if (bit != null) {
			tv_image.setImageBitmap(bit);
			return;
		}
		bit = memoryCacheUtils.getBitmapFromUril(url);
		if (bit != null) {
			tv_image.setImageBitmap(bit);
			return;
		}
		netUtils.getBitmapFromUrl(url, position, tag ,ac,tv_image);
	}


}
