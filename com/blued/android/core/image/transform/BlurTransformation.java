package com.blued.android.core.image.transform;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import com.blued.android.core.image.util.FastBlur;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.bitmap.BitmapTransformation;
import java.security.MessageDigest;

public class BlurTransformation extends BitmapTransformation {
  private static int b = 25;
  
  private static int c = 1;
  
  private int d;
  
  private int e;
  
  public BlurTransformation() {
    this(b, c);
  }
  
  public BlurTransformation(int paramInt) {
    this(paramInt, c);
  }
  
  public BlurTransformation(int paramInt1, int paramInt2) {
    this.d = paramInt1;
    this.e = paramInt2;
  }
  
  public Bitmap a(BitmapPool paramBitmapPool, Bitmap paramBitmap, int paramInt1, int paramInt2) {
    paramInt1 = paramBitmap.getWidth();
    paramInt2 = paramBitmap.getHeight();
    int i = this.e;
    Bitmap bitmap = paramBitmapPool.a(paramInt1 / i, paramInt2 / i, Bitmap.Config.ARGB_8888);
    bitmap.setDensity(paramBitmap.getDensity());
    Canvas canvas = new Canvas(bitmap);
    paramInt1 = this.e;
    canvas.scale(1.0F / paramInt1, 1.0F / paramInt1);
    Paint paint = new Paint();
    paint.setFlags(2);
    canvas.drawBitmap(paramBitmap, 0.0F, 0.0F, paint);
    return FastBlur.a(bitmap, this.d, true);
  }
  
  public void a(MessageDigest paramMessageDigest) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("com.blued.android.core.transform.BlurTransformation.1");
    stringBuilder.append(this.d);
    stringBuilder.append(this.e);
    paramMessageDigest.update(stringBuilder.toString().getBytes(a));
  }
  
  public boolean equals(Object paramObject) {
    if (paramObject instanceof BlurTransformation) {
      paramObject = paramObject;
      if (((BlurTransformation)paramObject).d == this.d && ((BlurTransformation)paramObject).e == this.e)
        return true; 
    } 
    return false;
  }
  
  public int hashCode() {
    return "com.blued.android.core.transform.BlurTransformation.1".hashCode() + this.d * 1000 + this.e * 10;
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("BlurTransformation(radius=");
    stringBuilder.append(this.d);
    stringBuilder.append(", sampling=");
    stringBuilder.append(this.e);
    stringBuilder.append(")");
    return stringBuilder.toString();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\blued\android\core\image\transform\BlurTransformation.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */