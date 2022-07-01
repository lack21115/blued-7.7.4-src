package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.util.Util;
import java.nio.ByteBuffer;
import java.security.MessageDigest;

public final class GranularRoundedCorners extends BitmapTransformation {
  private static final byte[] b = "com.bumptech.glide.load.resource.bitmap.GranularRoundedCorners".getBytes(a);
  
  private final float c;
  
  private final float d;
  
  private final float e;
  
  private final float f;
  
  public GranularRoundedCorners(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4) {
    this.c = paramFloat1;
    this.d = paramFloat2;
    this.e = paramFloat3;
    this.f = paramFloat4;
  }
  
  protected Bitmap a(BitmapPool paramBitmapPool, Bitmap paramBitmap, int paramInt1, int paramInt2) {
    return TransformationUtils.a(paramBitmapPool, paramBitmap, this.c, this.d, this.e, this.f);
  }
  
  public void a(MessageDigest paramMessageDigest) {
    paramMessageDigest.update(b);
    paramMessageDigest.update(ByteBuffer.allocate(16).putFloat(this.c).putFloat(this.d).putFloat(this.e).putFloat(this.f).array());
  }
  
  public boolean equals(Object paramObject) {
    boolean bool = paramObject instanceof GranularRoundedCorners;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (bool) {
      paramObject = paramObject;
      bool1 = bool2;
      if (this.c == ((GranularRoundedCorners)paramObject).c) {
        bool1 = bool2;
        if (this.d == ((GranularRoundedCorners)paramObject).d) {
          bool1 = bool2;
          if (this.e == ((GranularRoundedCorners)paramObject).e) {
            bool1 = bool2;
            if (this.f == ((GranularRoundedCorners)paramObject).f)
              bool1 = true; 
          } 
        } 
      } 
    } 
    return bool1;
  }
  
  public int hashCode() {
    int i = Util.b("com.bumptech.glide.load.resource.bitmap.GranularRoundedCorners".hashCode(), Util.a(this.c));
    i = Util.a(this.d, i);
    i = Util.a(this.e, i);
    return Util.a(this.f, i);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bumptech\glide\load\resource\bitmap\GranularRoundedCorners.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */