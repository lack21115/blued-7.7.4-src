package com.blued.android.core.image;

import android.content.Context;
import com.blued.android.core.image.apng.ByteBufferApngDecoder;
import com.blued.android.core.image.apng.StreamApngDecoder;
import com.blued.android.core.image.apng.drawable.APNGDrawable;
import com.blued.android.core.image.http.HttpModelLoader;
import com.blued.android.core.utils.Log;
import com.bumptech.glide.Glide;
import com.bumptech.glide.Registry;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.model.GlideUrl;
import com.bumptech.glide.load.model.ModelLoaderFactory;
import com.bumptech.glide.module.LibraryGlideModule;
import java.io.InputStream;
import java.nio.ByteBuffer;

public class ImageLoaderLibrarySetting extends LibraryGlideModule {
  public void a(Context paramContext, Glide paramGlide, Registry paramRegistry) {
    if (ImageLoader.a())
      Log.e("IMAGE", "registerComponents "); 
    paramRegistry.b(GlideUrl.class, InputStream.class, (ModelLoaderFactory)new HttpModelLoader.Factory());
    ByteBufferApngDecoder byteBufferApngDecoder = new ByteBufferApngDecoder();
    paramRegistry.b(InputStream.class, APNGDrawable.class, (ResourceDecoder)new StreamApngDecoder((ResourceDecoder)byteBufferApngDecoder));
    paramRegistry.b(ByteBuffer.class, APNGDrawable.class, (ResourceDecoder)byteBufferApngDecoder);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\blued\android\core\image\ImageLoaderLibrarySetting.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */