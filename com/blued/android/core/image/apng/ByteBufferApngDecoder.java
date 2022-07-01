package com.blued.android.core.image.apng;

import android.graphics.drawable.Drawable;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.image.ImageLoaderOptions;
import com.blued.android.core.image.apng.decode.APNGParser;
import com.blued.android.core.image.apng.drawable.APNGDrawable;
import com.blued.android.core.image.apng.io.ByteBufferReader;
import com.blued.android.core.image.apng.io.Reader;
import com.blued.android.core.image.apng.loader.ByteBufferLoader;
import com.blued.android.core.utils.Log;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.resource.drawable.DrawableResource;
import java.io.IOException;
import java.nio.ByteBuffer;

public class ByteBufferApngDecoder implements ResourceDecoder<ByteBuffer, APNGDrawable> {
  public Resource<APNGDrawable> a(ByteBuffer paramByteBuffer, int paramInt1, int paramInt2, Options paramOptions) {
    if (ImageLoader.a())
      Log.e("IMAGE", "ApngStreamDecoder -- decode "); 
    APNGDrawable aPNGDrawable = new APNGDrawable(new ByteBufferLoader(this, paramByteBuffer) {
          public ByteBuffer a() {
            this.a.position(0);
            return this.a;
          }
        });
    return (Resource<APNGDrawable>)new DrawableResource<APNGDrawable>(this, aPNGDrawable, paramByteBuffer, aPNGDrawable) {
        public Class<APNGDrawable> a() {
          return APNGDrawable.class;
        }
        
        public int b() {
          if (ImageLoader.a()) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("ApngStreamDecoder -- decode size : ");
            stringBuilder.append(this.a.limit());
            Log.e("IMAGE", stringBuilder.toString());
          } 
          return this.a.limit();
        }
        
        public void c() {
          if (ImageLoader.a())
            Log.e("IMAGE", "ApngStreamDecoder -- apngDrawable -- recycle "); 
          this.b.c();
        }
      };
  }
  
  public boolean a(ByteBuffer paramByteBuffer, Options paramOptions) {
    if (ImageLoader.a()) {
      boolean bool = ((Boolean)paramOptions.a(ImageLoaderOptions.b)).booleanValue();
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("ByteBufferApngDecoder -- OPTION_IMAGE_LOADER_FROMAT_APNG = ");
      stringBuilder.append(bool);
      stringBuilder.append(" source.length=");
      stringBuilder.append(paramByteBuffer.capacity());
      Log.e("IMAGE", stringBuilder.toString());
      if (bool) {
        stringBuilder = new StringBuilder();
        stringBuilder.append("ByteBufferApngDecoder -- isApng = ");
        stringBuilder.append(APNGParser.a((Reader)new ByteBufferReader(paramByteBuffer)));
        Log.e("IMAGE", stringBuilder.toString());
      } 
    } 
    return (((Boolean)paramOptions.a(ImageLoaderOptions.b)).booleanValue() && APNGParser.a((Reader)new ByteBufferReader(paramByteBuffer)));
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\blued\android\core\image\apng\ByteBufferApngDecoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */