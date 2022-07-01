package com.blued.android.module.shortvideo.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.blued.android.module.shortvideo.contract.ICoverSlideListener;
import com.blued.android.module.shortvideo.utils.StvLogUtils;

public class CoverSlideView extends FrameLayout {
  private static final String i = CoverSlideView.class.getSimpleName();
  
  protected int a;
  
  int b;
  
  int c;
  
  int d;
  
  int e;
  
  int f;
  
  int g;
  
  int h;
  
  private ICoverSlideListener j;
  
  public CoverSlideView(Context paramContext) {
    this(paramContext, (AttributeSet)null);
  }
  
  public CoverSlideView(Context paramContext, AttributeSet paramAttributeSet) {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public CoverSlideView(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
    post(new Runnable(this) {
          public void run() {
            CoverSlideView coverSlideView = this.a;
            coverSlideView.h = coverSlideView.getMeasuredWidth();
            coverSlideView = this.a;
            coverSlideView.f = coverSlideView.getTop();
            coverSlideView = this.a;
            coverSlideView.g = coverSlideView.getBottom();
          }
        });
  }
  
  public void a() {}
  
  public void a(int paramInt, ICoverSlideListener paramICoverSlideListener) {
    this.a = paramInt;
    this.j = paramICoverSlideListener;
  }
  
  public void b() {}
  
  public void c() {}
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent) {
    FrameLayout.LayoutParams layoutParams;
    int i = (int)paramMotionEvent.getRawX();
    int j = paramMotionEvent.getAction();
    if (j != 0) {
      if (j != 1) {
        if (j != 2)
          return true; 
        if (this.h == 0)
          this.h = getMeasuredWidth(); 
        if (this.f == 0)
          this.f = getTop(); 
        if (this.g == 0)
          this.g = getBottom(); 
        this.d = i - this.c;
        if (this.d < 0)
          this.d = 0; 
        j = this.d;
        i = this.h;
        this.e = j + i;
        j = this.e;
        int k = this.a;
        if (j >= k) {
          this.e = k;
          this.d = this.e - i;
        } 
        ICoverSlideListener iCoverSlideListener1 = this.j;
        if (iCoverSlideListener1 != null && iCoverSlideListener1.getPresenter() != null) {
          this.j.getPresenter().c(this.d + this.h / 2);
          this.j.getPresenter().g(this.d);
          iCoverSlideListener1 = this.j;
          if (iCoverSlideListener1 != null)
            iCoverSlideListener1.b((int)iCoverSlideListener1.getPresenter().v()); 
        } 
        layout(this.d, this.f, this.e, this.g);
        return true;
      } 
      ICoverSlideListener iCoverSlideListener = this.j;
      if (iCoverSlideListener != null && iCoverSlideListener.getPresenter() != null) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(i);
        stringBuilder.append("cover action_up left:");
        stringBuilder.append(this.d);
        stringBuilder.append(" | currentCoverTime:");
        stringBuilder.append(this.j.getPresenter().v());
        StvLogUtils.a(stringBuilder.toString(), new Object[0]);
      } 
      layoutParams = (FrameLayout.LayoutParams)getLayoutParams();
      layoutParams.leftMargin = getLeft();
      setLayoutParams((ViewGroup.LayoutParams)layoutParams);
      return true;
    } 
    if (i <= this.a) {
      this.b = i;
      this.c = (int)layoutParams.getX();
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(i);
      stringBuilder.append(" cover slidev down rawx:");
      stringBuilder.append(i);
      stringBuilder.append(" | x:");
      stringBuilder.append(this.c);
      StvLogUtils.a(stringBuilder.toString(), new Object[0]);
      return true;
    } 
    return false;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\blued\android\module\shortvideo\widget\CoverSlideView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */