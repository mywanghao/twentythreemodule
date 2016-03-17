package com.example.imagecachedemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.imagecachedemo.cache.ImageCacheProxy;

/**
 * this is imagecache demo
 * project author 王浩
 * need help contact QQ 1520777821
 */
public class MainActivity extends AppCompatActivity {

    private ImageCacheProxy imageCacheProxy;

    private String remoteImageUrl  = "http://c.hiphotos.baidu.com/image/pic/item/faedab64034f78f0ede17a957e310a55b2191ce9.jpg";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageCacheProxy = new ImageCacheProxy();

        final ImageView image = (ImageView) findViewById(R.id.image_instance);
        imageCacheProxy.imageLoader(image,remoteImageUrl,0,0,this);


        findViewById(R.id.download_img_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageCacheProxy.imageLoader(image,remoteImageUrl,0,0,MainActivity.this);
            }
        });

    }
}
