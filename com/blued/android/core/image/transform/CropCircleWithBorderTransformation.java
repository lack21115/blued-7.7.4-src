package com.blued.android.core.image.transform;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.bitmap.BitmapTransformation;
import com.bumptech.glide.load.resource.bitmap.TransformationUtils;
import java.security.MessageDigest;

public class CropCircleWithBorderTransformation extends BitmapTransformation {
  private int b = (int)(Resources.getSystem().getDisplayMetrics()).density * 4;
  
  private int c = -16777216;
  
  public CropCircleWithBorderTransformation() {}
  
  public CropCircleWithBorderTransformation(int paramInt1, int paramInt2) {}
  
  public Bitmap a(BitmapPool paramBitmapPool, Bitmap paramBitmap, int paramInt1, int paramInt2) {
    Bitmap bitmap = TransformationUtils.d(paramBitmapPool, paramBitmap, paramInt1, paramInt2);
    bitmap.setDensity(paramBitmap.getDensity());
    Paint paint = new Paint();
    paint.setColor(this.c);
    paint.setStyle(Paint.Style.STROKE);
    paint.setStrokeWidth(this.b);
    paint.setAntiAlias(true);
    (new Canvas(bitmap)).drawCircle(paramInt1 / 2.0F, paramInt2 / 2.0F, ((Math.max(paramInt1, paramInt2) - this.b) + 0.8F) / 2.0F, paint);
    return bitmap;
  }
  
  public void a(MessageDigest paramMessageDigest) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("com.blued.android.core.transform.CropCircleWithBorderTransformation.1");
    stringBuilder.append(this.b);
    stringBuilder.append(this.c);
    paramMessageDigest.update(stringBuilder.toString().getBytes(a));
  }
  
  public boolean equals(Object paramObject) {
    if (paramObject instanceof CropCircleWithBorderTransformation) {
      paramObject = paramObject;
      if (((CropCircleWithBorderTransformation)paramObject).b == this.b && ((CropCircleWithBorderTransformation)paramObject).c == this.c)
        return true; 
    } 
    return false;
  }
  
  public int hashCode() {
    return "com.blued.android.core.transform.CropCircleWithBorderTransformation.1".hashCode() + this.b * 100 + this.c + 10;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\blued\android\core\image\transform\CropCircleWithBorderTransformation.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */