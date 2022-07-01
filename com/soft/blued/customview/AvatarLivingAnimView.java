package com.soft.blued.customview;

import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.LinearLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.blued.android.framework.utils.DensityUtils;
import com.soft.blued.R;

public class AvatarLivingAnimView extends LinearLayout {
  private View a;
  
  private View b;
  
  private int c = 42;
  
  private int d = 6;
  
  private final long e = 1500L;
  
  private ConstraintLayout.LayoutParams f;
  
  private ConstraintLayout.LayoutParams g;
  
  private ValueAnimator h;
  
  public AvatarLivingAnimView(Context paramContext) {
    super(paramContext);
    a(paramContext, null, 0);
  }
  
  public AvatarLivingAnimView(Context paramContext, AttributeSet paramAttributeSet) {
    super(paramContext, paramAttributeSet);
    a(paramContext, paramAttributeSet, 0);
  }
  
  public AvatarLivingAnimView(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext, paramAttributeSet, paramInt);
  }
  
  public void a() {
    ValueAnimator valueAnimator = this.h;
    if (valueAnimator != null)
      valueAnimator.cancel(); 
  }
  
  public void a(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    View view = LayoutInflater.from(paramContext).inflate(2131494224, (ViewGroup)this);
    this.a = view.findViewById(2131300917);
    this.b = view.findViewById(2131301155);
    view = view.findViewById(2131299752);
    this.c = DensityUtils.a(paramContext, this.c);
    this.d = DensityUtils.a(paramContext, this.d);
    if (paramAttributeSet != null) {
      TypedArray typedArray = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.AvatarLivingAnimView, paramInt, 0);
      this.c = (int)typedArray.getDimension(0, this.c);
      typedArray.recycle();
    } 
    paramInt = this.c + DensityUtils.a(paramContext, 0.5F);
    ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
    layoutParams.width = this.d + paramInt;
    layoutParams.height = layoutParams.width;
    view.setLayoutParams(layoutParams);
    this.f = (ConstraintLayout.LayoutParams)this.a.getLayoutParams();
    this.g = (ConstraintLayout.LayoutParams)this.b.getLayoutParams();
    this.h = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    this.h.setDuration(1500L);
    this.h.addUpdateListener(new -$$Lambda$AvatarLivingAnimView$uvfYhcuP7xUAMLxx3Vzfy7JoH6c(this, paramInt));
    this.h.setInterpolator((TimeInterpolator)new LinearInterpolator());
    this.h.setRepeatCount(-1);
    this.h.start();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blued\customview\AvatarLivingAnimView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */