package androidx.viewpager.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import androidx.core.content.ContextCompat;

public class PagerTabStrip extends PagerTitleStrip {
  private int g = this.f;
  
  private int h;
  
  private int i;
  
  private int j;
  
  private int k;
  
  private int l;
  
  private final Paint m = new Paint();
  
  private final Rect n = new Rect();
  
  private int o = 255;
  
  private boolean p = false;
  
  private boolean q = false;
  
  private int r;
  
  private boolean s;
  
  private float t;
  
  private float u;
  
  private int v;
  
  public PagerTabStrip(Context paramContext) {
    this(paramContext, (AttributeSet)null);
  }
  
  public PagerTabStrip(Context paramContext, AttributeSet paramAttributeSet) {
    super(paramContext, paramAttributeSet);
    this.m.setColor(this.g);
    float f = (paramContext.getResources().getDisplayMetrics()).density;
    this.h = (int)(3.0F * f + 0.5F);
    this.i = (int)(6.0F * f + 0.5F);
    this.j = (int)(64.0F * f);
    this.l = (int)(16.0F * f + 0.5F);
    this.r = (int)(1.0F * f + 0.5F);
    this.k = (int)(f * 32.0F + 0.5F);
    this.v = ViewConfiguration.get(paramContext).getScaledTouchSlop();
    setPadding(getPaddingLeft(), getPaddingTop(), getPaddingRight(), getPaddingBottom());
    setTextSpacing(getTextSpacing());
    setWillNotDraw(false);
    this.b.setFocusable(true);
    this.b.setOnClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            this.a.a.setCurrentItem(this.a.a.getCurrentItem() - 1);
          }
        });
    this.d.setFocusable(true);
    this.d.setOnClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            this.a.a.setCurrentItem(this.a.a.getCurrentItem() + 1);
          }
        });
    if (getBackground() == null)
      this.p = true; 
  }
  
  void a(int paramInt, float paramFloat, boolean paramBoolean) {
    Rect rect = this.n;
    int i = getHeight();
    int j = this.c.getLeft();
    int k = this.l;
    int m = this.c.getRight();
    int n = this.l;
    int i1 = i - this.h;
    rect.set(j - k, i1, m + n, i);
    super.a(paramInt, paramFloat, paramBoolean);
    this.o = (int)(Math.abs(paramFloat - 0.5F) * 2.0F * 255.0F);
    rect.union(this.c.getLeft() - this.l, i1, this.c.getRight() + this.l, i);
    invalidate(rect);
  }
  
  public boolean getDrawFullUnderline() {
    return this.p;
  }
  
  int getMinHeight() {
    return Math.max(super.getMinHeight(), this.k);
  }
  
  public int getTabIndicatorColor() {
    return this.g;
  }
  
  protected void onDraw(Canvas paramCanvas) {
    super.onDraw(paramCanvas);
    int i = getHeight();
    int j = this.c.getLeft();
    int k = this.l;
    int m = this.c.getRight();
    int n = this.l;
    int i1 = this.h;
    this.m.setColor(this.o << 24 | this.g & 0xFFFFFF);
    float f1 = (j - k);
    float f2 = (i - i1);
    float f3 = (m + n);
    float f4 = i;
    paramCanvas.drawRect(f1, f2, f3, f4, this.m);
    if (this.p) {
      this.m.setColor(0xFF000000 | this.g & 0xFFFFFF);
      paramCanvas.drawRect(getPaddingLeft(), (i - this.r), (getWidth() - getPaddingRight()), f4, this.m);
    } 
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent) {
    int i = paramMotionEvent.getAction();
    if (i != 0 && this.s)
      return false; 
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    if (i != 0) {
      if (i != 1) {
        if (i != 2)
          return true; 
        if (Math.abs(f1 - this.t) > this.v || Math.abs(f2 - this.u) > this.v) {
          this.s = true;
          return true;
        } 
      } else {
        if (f1 < (this.c.getLeft() - this.l)) {
          this.a.setCurrentItem(this.a.getCurrentItem() - 1);
          return true;
        } 
        if (f1 > (this.c.getRight() + this.l)) {
          this.a.setCurrentItem(this.a.getCurrentItem() + 1);
          return true;
        } 
      } 
    } else {
      this.t = f1;
      this.u = f2;
      this.s = false;
    } 
    return true;
  }
  
  public void setBackgroundColor(int paramInt) {
    super.setBackgroundColor(paramInt);
    if (!this.q) {
      boolean bool;
      if ((paramInt & 0xFF000000) == 0) {
        bool = true;
      } else {
        bool = false;
      } 
      this.p = bool;
    } 
  }
  
  public void setBackgroundDrawable(Drawable paramDrawable) {
    super.setBackgroundDrawable(paramDrawable);
    if (!this.q) {
      boolean bool;
      if (paramDrawable == null) {
        bool = true;
      } else {
        bool = false;
      } 
      this.p = bool;
    } 
  }
  
  public void setBackgroundResource(int paramInt) {
    super.setBackgroundResource(paramInt);
    if (!this.q) {
      boolean bool;
      if (paramInt == 0) {
        bool = true;
      } else {
        bool = false;
      } 
      this.p = bool;
    } 
  }
  
  public void setDrawFullUnderline(boolean paramBoolean) {
    this.p = paramBoolean;
    this.q = true;
    invalidate();
  }
  
  public void setPadding(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    int j = this.i;
    int i = paramInt4;
    if (paramInt4 < j)
      i = j; 
    super.setPadding(paramInt1, paramInt2, paramInt3, i);
  }
  
  public void setTabIndicatorColor(int paramInt) {
    this.g = paramInt;
    this.m.setColor(this.g);
    invalidate();
  }
  
  public void setTabIndicatorColorResource(int paramInt) {
    setTabIndicatorColor(ContextCompat.getColor(getContext(), paramInt));
  }
  
  public void setTextSpacing(int paramInt) {
    int j = this.j;
    int i = paramInt;
    if (paramInt < j)
      i = j; 
    super.setTextSpacing(i);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\androidx\viewpager\widget\PagerTabStrip.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */