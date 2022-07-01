package com.google.android.material.internal;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.google.android.material.R;

public class ScrimInsetsFrameLayout extends FrameLayout {
  Drawable a;
  
  Rect b;
  
  private Rect c = new Rect();
  
  private boolean d = true;
  
  private boolean e = true;
  
  public ScrimInsetsFrameLayout(Context paramContext, AttributeSet paramAttributeSet) {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ScrimInsetsFrameLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
    TypedArray typedArray = ThemeEnforcement.a(paramContext, paramAttributeSet, R.styleable.ScrimInsetsFrameLayout, paramInt, R.style.Widget_Design_ScrimInsetsFrameLayout, new int[0]);
    this.a = typedArray.getDrawable(R.styleable.ScrimInsetsFrameLayout_insetForeground);
    typedArray.recycle();
    setWillNotDraw(true);
    ViewCompat.setOnApplyWindowInsetsListener((View)this, new OnApplyWindowInsetsListener(this) {
          public WindowInsetsCompat onApplyWindowInsets(View param1View, WindowInsetsCompat param1WindowInsetsCompat) {
            if (this.a.b == null)
              this.a.b = new Rect(); 
            this.a.b.set(param1WindowInsetsCompat.getSystemWindowInsetLeft(), param1WindowInsetsCompat.getSystemWindowInsetTop(), param1WindowInsetsCompat.getSystemWindowInsetRight(), param1WindowInsetsCompat.getSystemWindowInsetBottom());
            this.a.a(param1WindowInsetsCompat);
            ScrimInsetsFrameLayout scrimInsetsFrameLayout = this.a;
            if (!param1WindowInsetsCompat.hasSystemWindowInsets() || this.a.a == null) {
              boolean bool1 = true;
              scrimInsetsFrameLayout.setWillNotDraw(bool1);
              ViewCompat.postInvalidateOnAnimation((View)this.a);
              return param1WindowInsetsCompat.consumeSystemWindowInsets();
            } 
            boolean bool = false;
            scrimInsetsFrameLayout.setWillNotDraw(bool);
            ViewCompat.postInvalidateOnAnimation((View)this.a);
            return param1WindowInsetsCompat.consumeSystemWindowInsets();
          }
        });
  }
  
  protected void a(WindowInsetsCompat paramWindowInsetsCompat) {}
  
  public void draw(Canvas paramCanvas) {
    super.draw(paramCanvas);
    int i = getWidth();
    int j = getHeight();
    if (this.b != null && this.a != null) {
      int k = paramCanvas.save();
      paramCanvas.translate(getScrollX(), getScrollY());
      if (this.d) {
        this.c.set(0, 0, i, this.b.top);
        this.a.setBounds(this.c);
        this.a.draw(paramCanvas);
      } 
      if (this.e) {
        this.c.set(0, j - this.b.bottom, i, j);
        this.a.setBounds(this.c);
        this.a.draw(paramCanvas);
      } 
      this.c.set(0, this.b.top, this.b.left, j - this.b.bottom);
      this.a.setBounds(this.c);
      this.a.draw(paramCanvas);
      this.c.set(i - this.b.right, this.b.top, i, j - this.b.bottom);
      this.a.setBounds(this.c);
      this.a.draw(paramCanvas);
      paramCanvas.restoreToCount(k);
    } 
  }
  
  public void onAttachedToWindow() {
    super.onAttachedToWindow();
    Drawable drawable = this.a;
    if (drawable != null)
      drawable.setCallback((Drawable.Callback)this); 
  }
  
  public void onDetachedFromWindow() {
    super.onDetachedFromWindow();
    Drawable drawable = this.a;
    if (drawable != null)
      drawable.setCallback(null); 
  }
  
  public void setDrawBottomInsetForeground(boolean paramBoolean) {
    this.e = paramBoolean;
  }
  
  public void setDrawTopInsetForeground(boolean paramBoolean) {
    this.d = paramBoolean;
  }
  
  public void setScrimInsetForeground(Drawable paramDrawable) {
    this.a = paramDrawable;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\google\android\material\internal\ScrimInsetsFrameLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */