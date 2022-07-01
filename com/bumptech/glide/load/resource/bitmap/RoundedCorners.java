package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.util.Preconditions;
import com.bumptech.glide.util.Util;
import java.nio.ByteBuffer;
import java.security.MessageDigest;

public final class RoundedCorners extends BitmapTransformation {
  private static final byte[] b = "com.bumptech.glide.load.resource.bitmap.RoundedCorners".getBytes(a);
  
  private final int c;
  
  public RoundedCorners(int paramInt) {
    boolean bool;
    if (paramInt > 0) {
      bool = true;
    } else {
      bool = false;
    } 
    Preconditions.a(bool, "roundingRadius must be greater than 0.");
    this.c = paramInt;
  }
  
  protected Bitmap a(BitmapPool paramBitmapPool, Bitmap paramBitmap, int paramInt1, int paramInt2) {
    return TransformationUtils.b(paramBitmapPool, paramBitmap, this.c);
  }
  
  public void a(MessageDigest paramMessageDigest) {
    paramMessageDigest.update(b);
    paramMessageDigest.update(ByteBuffer.allocate(4).putInt(this.c).array());
  }
  
  public boolean equals(Object paramObject) {
    boolean bool = paramObject instanceof RoundedCorners;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (bool) {
      paramObject = paramObject;
      bool1 = bool2;
      if (this.c == ((RoundedCorners)paramObject).c)
        bool1 = true; 
    } 
    return bool1;
  }
  
  public int hashCode() {
    return Util.b("com.bumptech.glide.load.resource.bitmap.RoundedCorners".hashCode(), Util.b(this.c));
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bumptech\glide\load\resource\bitmap\RoundedCorners.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */