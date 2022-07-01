package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.drawable.ResourceDrawableDecoder;
import java.io.IOException;

public class ResourceBitmapDecoder implements ResourceDecoder<Uri, Bitmap> {
  private final ResourceDrawableDecoder a;
  
  private final BitmapPool b;
  
  public ResourceBitmapDecoder(ResourceDrawableDecoder paramResourceDrawableDecoder, BitmapPool paramBitmapPool) {
    this.a = paramResourceDrawableDecoder;
    this.b = paramBitmapPool;
  }
  
  public Resource<Bitmap> a(Uri paramUri, int paramInt1, int paramInt2, Options paramOptions) {
    Resource resource = this.a.a(paramUri, paramInt1, paramInt2, paramOptions);
    if (resource == null)
      return null; 
    Drawable drawable = (Drawable)resource.f();
    return DrawableToBitmapConverter.a(this.b, drawable, paramInt1, paramInt2);
  }
  
  public boolean a(Uri paramUri, Options paramOptions) {
    return "android.resource".equals(paramUri.getScheme());
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bumptech\glide\load\resource\bitmap\ResourceBitmapDecoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */