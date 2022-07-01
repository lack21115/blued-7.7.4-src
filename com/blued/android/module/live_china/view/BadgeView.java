package com.blued.android.module.live_china.view;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.graphics.drawable.shapes.Shape;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import com.blued.android.module.live_china.same.Logger;

public class BadgeView extends AppCompatTextView {
  private boolean a = true;
  
  public BadgeView(Context paramContext) {
    this(paramContext, (AttributeSet)null);
  }
  
  public BadgeView(Context paramContext, AttributeSet paramAttributeSet) {
    this(paramContext, paramAttributeSet, 16842884);
  }
  
  public BadgeView(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
    b();
  }
  
  private int a(float paramFloat) {
    return (int)(paramFloat * (getContext().getResources().getDisplayMetrics()).density + 0.5F);
  }
  
  private void b() {
    if (!(getLayoutParams() instanceof FrameLayout.LayoutParams))
      setLayoutParams((ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-2, -2, 53)); 
    setPadding(a(5.0F), a(0.0F), a(5.0F), a(1.0F));
    a(9, Color.parseColor("#f66161"));
    setGravity(17);
    setHideOnNull(true);
    setBadgeCount(0);
  }
  
  public void a(int paramInt1, int paramInt2) {
    float f = a(paramInt1);
    ShapeDrawable shapeDrawable = new ShapeDrawable((Shape)new RoundRectShape(new float[] { f, f, f, f, f, f, f, f }, null, null));
    shapeDrawable.getPaint().setColor(paramInt2);
    setBackgroundDrawable((Drawable)shapeDrawable);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams)getLayoutParams();
    layoutParams.leftMargin = a(paramInt1);
    layoutParams.topMargin = a(paramInt2);
    layoutParams.rightMargin = a(paramInt3);
    layoutParams.bottomMargin = a(paramInt4);
    setLayoutParams((ViewGroup.LayoutParams)layoutParams);
  }
  
  public boolean a() {
    return this.a;
  }
  
  public Integer getBadgeCount() {
    if (getText() == null)
      return null; 
    String str = getText().toString();
    try {
      int i = Integer.parseInt(str);
      return Integer.valueOf(i);
    } catch (NumberFormatException numberFormatException) {
      return null;
    } 
  }
  
  public int getBadgeGravity() {
    return ((FrameLayout.LayoutParams)getLayoutParams()).gravity;
  }
  
  public int[] getBadgeMargin() {
    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams)getLayoutParams();
    return new int[] { layoutParams.leftMargin, layoutParams.topMargin, layoutParams.rightMargin, layoutParams.bottomMargin };
  }
  
  public void setBadgeCount(int paramInt) {
    setText(String.valueOf(paramInt));
  }
  
  public void setBadgeCount(String paramString) {
    setText(paramString);
  }
  
  public void setBadgeGravity(int paramInt) {
    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams)getLayoutParams();
    layoutParams.gravity = paramInt;
    setLayoutParams((ViewGroup.LayoutParams)layoutParams);
  }
  
  public void setBadgeMargin(int paramInt) {
    a(paramInt, paramInt, paramInt, paramInt);
  }
  
  public void setHideOnNull(boolean paramBoolean) {
    this.a = paramBoolean;
    setText(getText());
  }
  
  public void setTargetView(View paramView) {
    if (getParent() != null)
      ((ViewGroup)getParent()).removeView((View)this); 
    if (paramView == null)
      return; 
    if (paramView.getParent() instanceof FrameLayout) {
      ((FrameLayout)paramView.getParent()).addView((View)this);
      return;
    } 
    if (paramView.getParent() instanceof ViewGroup) {
      ViewGroup viewGroup = (ViewGroup)paramView.getParent();
      int i = viewGroup.indexOfChild(paramView);
      viewGroup.removeView(paramView);
      FrameLayout frameLayout = new FrameLayout(getContext());
      ViewGroup.LayoutParams layoutParams = paramView.getLayoutParams();
      frameLayout.setLayoutParams(layoutParams);
      paramView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
      viewGroup.addView((View)frameLayout, i, layoutParams);
      frameLayout.addView(paramView);
      frameLayout.addView((View)this);
      return;
    } 
    if (paramView.getParent() == null)
      Logger.d(getClass().getSimpleName(), new Object[] { "ParentView is needed" }); 
  }
  
  public void setText(CharSequence paramCharSequence, TextView.BufferType paramBufferType) {
    if (a() && (paramCharSequence == null || paramCharSequence.toString().equalsIgnoreCase("0"))) {
      setVisibility(8);
    } else {
      setVisibility(0);
    } 
    super.setText(paramCharSequence, paramBufferType);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\live_china\view\BadgeView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */