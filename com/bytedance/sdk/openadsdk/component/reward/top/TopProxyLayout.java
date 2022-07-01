package com.bytedance.sdk.openadsdk.component.reward.top;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.bytedance.sdk.openadsdk.core.d.k;
import com.bytedance.sdk.openadsdk.utils.t;

public class TopProxyLayout extends View implements a<TopProxyLayout> {
  private a a;
  
  public TopProxyLayout(Context paramContext) {
    this(paramContext, (AttributeSet)null);
  }
  
  public TopProxyLayout(Context paramContext, AttributeSet paramAttributeSet) {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public TopProxyLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
    setVisibility(8);
    setWillNotDraw(true);
  }
  
  private void a(View paramView, ViewGroup paramViewGroup) {
    int i = paramViewGroup.indexOfChild(this);
    paramViewGroup.removeViewInLayout(this);
    ViewGroup.LayoutParams layoutParams = getLayoutParams();
    if (layoutParams != null) {
      paramViewGroup.addView(paramView, i, layoutParams);
      return;
    } 
    paramViewGroup.addView(paramView, i);
  }
  
  public TopProxyLayout a(boolean paramBoolean, k paramk) {
    TopLayoutDislike2 topLayoutDislike2;
    TopLayout1 topLayout1;
    boolean bool1 = paramk.q();
    boolean bool = true;
    if (!bool1 || paramk.c() != 1)
      bool = false; 
    if (paramk.ac() && !bool) {
      topLayoutDislike2 = (new TopLayoutDislike2(getContext())).a(paramBoolean, paramk);
    } else {
      topLayout1 = (new TopLayout1(getContext())).a(paramBoolean, (k)topLayoutDislike2);
    } 
    if (topLayout1 instanceof a) {
      this.a = topLayout1;
      ViewParent viewParent = getParent();
      if (viewParent != null && viewParent instanceof ViewGroup)
        a((View)topLayout1, (ViewGroup)viewParent); 
      return this;
    } 
    t.e("TopProxyLayout", "view not implements ITopLayout interface");
    return this;
  }
  
  public void a() {
    a a1 = this.a;
    if (a1 != null)
      a1.a(); 
  }
  
  public void a(CharSequence paramCharSequence1, CharSequence paramCharSequence2) {
    a a1 = this.a;
    if (a1 != null)
      a1.a(paramCharSequence1, paramCharSequence2); 
  }
  
  public void b() {
    a a1 = this.a;
    if (a1 != null)
      a1.b(); 
  }
  
  protected void dispatchDraw(Canvas paramCanvas) {}
  
  public void draw(Canvas paramCanvas) {}
  
  protected void onMeasure(int paramInt1, int paramInt2) {
    setMeasuredDimension(0, 0);
  }
  
  public void setListener(b paramb) {
    a a1 = this.a;
    if (a1 != null)
      a1.setListener(paramb); 
  }
  
  public void setShowCountDown(boolean paramBoolean) {
    a a1 = this.a;
    if (a1 != null)
      a1.setShowCountDown(paramBoolean); 
  }
  
  public void setShowDislike(boolean paramBoolean) {
    a a1 = this.a;
    if (a1 != null)
      a1.setShowDislike(paramBoolean); 
  }
  
  public void setShowSkip(boolean paramBoolean) {
    a a1 = this.a;
    if (a1 != null)
      a1.setShowSkip(paramBoolean); 
  }
  
  public void setShowSound(boolean paramBoolean) {
    a a1 = this.a;
    if (a1 != null)
      a1.setShowSound(paramBoolean); 
  }
  
  public void setSkipEnable(boolean paramBoolean) {
    a a1 = this.a;
    if (a1 != null)
      a1.setSkipEnable(paramBoolean); 
  }
  
  public void setSoundMute(boolean paramBoolean) {
    a a1 = this.a;
    if (a1 != null)
      a1.setSoundMute(paramBoolean); 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\openadsdk\component\reward\top\TopProxyLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */