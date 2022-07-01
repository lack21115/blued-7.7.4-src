package com.soft.blued.customview.emoji.manager;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.text.style.DynamicDrawableSpan;
import java.lang.ref.WeakReference;

class EmojiconSpan extends DynamicDrawableSpan {
  private final Context a;
  
  private final int b;
  
  private final int c;
  
  private final int d;
  
  private int e;
  
  private int f;
  
  private int g;
  
  private Drawable h;
  
  private WeakReference<Drawable> i;
  
  public EmojiconSpan(Context paramContext, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    super(paramInt3);
    this.a = paramContext;
    this.b = paramInt1;
    this.c = paramInt2;
    this.e = paramInt2;
    this.f = paramInt2;
    this.d = paramInt4;
  }
  
  private Drawable a() {
    WeakReference<Drawable> weakReference = this.i;
    if (weakReference == null || weakReference.get() == null)
      this.i = new WeakReference<Drawable>(getDrawable()); 
    return this.i.get();
  }
  
  public void draw(Canvas paramCanvas, CharSequence paramCharSequence, int paramInt1, int paramInt2, float paramFloat, int paramInt3, int paramInt4, int paramInt5, Paint paramPaint) {
    Drawable drawable = a();
    paramCanvas.save();
    paramInt1 = paramInt5 - (drawable.getBounds()).bottom;
    if (this.mVerticalAlignment == 1)
      paramInt1 = paramInt3 + (paramInt5 - paramInt3) / 2 - ((drawable.getBounds()).bottom - (drawable.getBounds()).top) / 2 - this.g; 
    paramCanvas.translate(paramFloat, paramInt1);
    drawable.draw(paramCanvas);
    paramCanvas.restore();
  }
  
  public Drawable getDrawable() {
    if (this.h == null)
      try {
        this.h = this.a.getResources().getDrawable(this.b);
        this.e = this.c;
        this.f = this.e * this.h.getIntrinsicWidth() / this.h.getIntrinsicHeight();
        this.g = (this.d - this.e) / 2;
        this.h.setBounds(0, this.g, this.f, this.g + this.e);
      } catch (Exception exception) {} 
    return this.h;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blued\customview\emoji\manager\EmojiconSpan.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */