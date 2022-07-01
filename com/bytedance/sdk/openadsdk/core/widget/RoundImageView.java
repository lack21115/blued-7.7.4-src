package com.bytedance.sdk.openadsdk.core.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.Xfermode;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.NinePatchDrawable;
import android.util.AttributeSet;
import android.widget.ImageView;

public class RoundImageView extends ImageView {
  private int a = 0;
  
  private int b = 0;
  
  public RoundImageView(Context paramContext) {
    super(paramContext);
  }
  
  public RoundImageView(Context paramContext, AttributeSet paramAttributeSet) {
    super(paramContext, paramAttributeSet);
  }
  
  public RoundImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private Bitmap a(Bitmap paramBitmap, int paramInt) {
    paramInt *= 2;
    int i = paramBitmap.getWidth();
    int j = paramBitmap.getHeight();
    if (j > i) {
      bitmap = Bitmap.createBitmap(paramBitmap, 0, (j - i) / 2, i, i);
    } else if (j < i) {
      bitmap = Bitmap.createBitmap(paramBitmap, (i - j) / 2, 0, j, j);
    } else {
      bitmap = null;
    } 
    if (bitmap != null)
      paramBitmap = bitmap; 
    if (paramBitmap.getWidth() == paramInt) {
      bitmap = paramBitmap;
      if (paramBitmap.getHeight() != paramInt) {
        bitmap = Bitmap.createScaledBitmap(paramBitmap, paramInt, paramInt, true);
        paramBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas2 = new Canvas(paramBitmap);
        Paint paint2 = new Paint();
        Rect rect2 = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
        paint2.setAntiAlias(true);
        paint2.setFilterBitmap(true);
        paint2.setDither(true);
        canvas2.drawARGB(0, 0, 0, 0);
        canvas2.drawCircle((bitmap.getWidth() / 2), (bitmap.getHeight() / 2), (bitmap.getWidth() / 2), paint2);
        paint2.setXfermode((Xfermode)new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas2.drawBitmap(bitmap, rect2, rect2, paint2);
        return paramBitmap;
      } 
      paramBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
      Canvas canvas1 = new Canvas(paramBitmap);
      Paint paint1 = new Paint();
      Rect rect1 = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
      paint1.setAntiAlias(true);
      paint1.setFilterBitmap(true);
      paint1.setDither(true);
      canvas1.drawARGB(0, 0, 0, 0);
      canvas1.drawCircle((bitmap.getWidth() / 2), (bitmap.getHeight() / 2), (bitmap.getWidth() / 2), paint1);
      paint1.setXfermode((Xfermode)new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
      canvas1.drawBitmap(bitmap, rect1, rect1, paint1);
      return paramBitmap;
    } 
    Bitmap bitmap = Bitmap.createScaledBitmap(paramBitmap, paramInt, paramInt, true);
    paramBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
    Canvas canvas = new Canvas(paramBitmap);
    Paint paint = new Paint();
    Rect rect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
    paint.setAntiAlias(true);
    paint.setFilterBitmap(true);
    paint.setDither(true);
    canvas.drawARGB(0, 0, 0, 0);
    canvas.drawCircle((bitmap.getWidth() / 2), (bitmap.getHeight() / 2), (bitmap.getWidth() / 2), paint);
    paint.setXfermode((Xfermode)new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
    canvas.drawBitmap(bitmap, rect, rect, paint);
    return paramBitmap;
  }
  
  protected void onDraw(Canvas paramCanvas) {
    Drawable drawable = getDrawable();
    if (drawable == null)
      return; 
    if (getWidth() != 0) {
      if (getHeight() == 0)
        return; 
      measure(0, 0);
      if (drawable.getClass() == NinePatchDrawable.class)
        return; 
      Bitmap bitmap = ((BitmapDrawable)drawable).getBitmap();
      if (bitmap == null)
        return; 
      try {
        bitmap = bitmap.copy(Bitmap.Config.ARGB_8888, true);
      } finally {
        bitmap = null;
      } 
      if (this.a == 0)
        this.a = getWidth(); 
      if (this.b == 0)
        this.b = getHeight(); 
      int i = this.a;
      int j = this.b;
      if (i >= j)
        i = j; 
      i /= 2;
      try {
        bitmap = a(bitmap, i);
      } finally {
        bitmap = null;
      } 
      paramCanvas.drawBitmap(bitmap, (this.a / 2 - i), (this.b / 2 - i), null);
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\openadsdk\core\widget\RoundImageView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */