package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.util.Util;
import java.io.IOException;

public final class UnitBitmapDecoder implements ResourceDecoder<Bitmap, Bitmap> {
  public Resource<Bitmap> a(Bitmap paramBitmap, int paramInt1, int paramInt2, Options paramOptions) {
    return new NonOwnedBitmapResource(paramBitmap);
  }
  
  public boolean a(Bitmap paramBitmap, Options paramOptions) {
    return true;
  }
  
  static final class NonOwnedBitmapResource implements Resource<Bitmap> {
    private final Bitmap a;
    
    NonOwnedBitmapResource(Bitmap param1Bitmap) {
      this.a = param1Bitmap;
    }
    
    public Class<Bitmap> a() {
      return Bitmap.class;
    }
    
    public int b() {
      return Util.a(this.a);
    }
    
    public void c() {}
    
    public Bitmap d() {
      return this.a;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bumptech\glide\load\resource\bitmap\UnitBitmapDecoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */