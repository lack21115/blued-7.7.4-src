package com.blued.android.module.live_china.view.shimmer;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.widget.AppCompatButton;

public class ShimmerButton extends AppCompatButton implements ShimmerViewBase {
  private ShimmerViewHelper a;
  
  public ShimmerButton(Context paramContext, AttributeSet paramAttributeSet) {
    super(paramContext, paramAttributeSet);
    this.a = new ShimmerViewHelper((View)this, (Paint)getPaint(), paramAttributeSet);
    this.a.a(getCurrentTextColor());
  }
  
  public ShimmerButton(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
    this.a = new ShimmerViewHelper((View)this, (Paint)getPaint(), paramAttributeSet);
    this.a.a(getCurrentTextColor());
  }
  
  public boolean a() {
    return this.a.b();
  }
  
  public float getGradientX() {
    return this.a.a();
  }
  
  public int getPrimaryColor() {
    return this.a.c();
  }
  
  public int getReflectionColor() {
    return this.a.d();
  }
  
  public void onDraw(Canvas paramCanvas) {
    ShimmerViewHelper shimmerViewHelper = this.a;
    if (shimmerViewHelper != null)
      shimmerViewHelper.f(); 
    super.onDraw(paramCanvas);
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    ShimmerViewHelper shimmerViewHelper = this.a;
    if (shimmerViewHelper != null)
      shimmerViewHelper.e(); 
  }
  
  public void setAnimationSetupCallback(ShimmerViewHelper.AnimationSetupCallback paramAnimationSetupCallback) {
    this.a.a(paramAnimationSetupCallback);
  }
  
  public void setGradientX(float paramFloat) {
    this.a.a(paramFloat);
  }
  
  public void setPrimaryColor(int paramInt) {
    this.a.a(paramInt);
  }
  
  public void setReflectionColor(int paramInt) {
    this.a.b(paramInt);
  }
  
  public void setShimmering(boolean paramBoolean) {
    this.a.a(paramBoolean);
  }
  
  public void setTextColor(int paramInt) {
    super.setTextColor(paramInt);
    ShimmerViewHelper shimmerViewHelper = this.a;
    if (shimmerViewHelper != null)
      shimmerViewHelper.a(getCurrentTextColor()); 
  }
  
  public void setTextColor(ColorStateList paramColorStateList) {
    super.setTextColor(paramColorStateList);
    ShimmerViewHelper shimmerViewHelper = this.a;
    if (shimmerViewHelper != null)
      shimmerViewHelper.a(getCurrentTextColor()); 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\live_china\view\shimmer\ShimmerButton.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */