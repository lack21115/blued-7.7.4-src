package com.bumptech.glide.load.resource.gif;

import android.util.Log;
import com.bumptech.glide.load.EncodeStrategy;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceEncoder;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.util.ByteBufferUtil;
import java.io.File;
import java.io.IOException;

public class GifDrawableEncoder implements ResourceEncoder<GifDrawable> {
  public EncodeStrategy a(Options paramOptions) {
    return EncodeStrategy.a;
  }
  
  public boolean a(Resource<GifDrawable> paramResource, File paramFile, Options paramOptions) {
    GifDrawable gifDrawable = (GifDrawable)paramResource.f();
    try {
      ByteBufferUtil.a(gifDrawable.c(), paramFile);
      return true;
    } catch (IOException iOException) {
      if (Log.isLoggable("GifEncoder", 5))
        Log.w("GifEncoder", "Failed to encode GIF drawable data", iOException); 
      return false;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bumptech\glide\load\resource\gif\GifDrawableEncoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */