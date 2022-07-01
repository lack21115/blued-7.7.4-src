package com.soft.blued.customview.capricorn;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.soft.blued.R;

public class ArcMenu extends RelativeLayout {
  private ArcLayout a;
  
  private ViewGroup b;
  
  private ImageView c;
  
  public ArcMenu(Context paramContext, AttributeSet paramAttributeSet) {
    super(paramContext, paramAttributeSet);
    a(paramContext);
    a(paramAttributeSet);
  }
  
  private static Animation a(long paramLong, boolean paramBoolean) {
    float f1;
    float f2;
    AnimationSet animationSet = new AnimationSet(true);
    if (paramBoolean) {
      f1 = 2.0F;
    } else {
      f1 = 0.0F;
    } 
    if (paramBoolean) {
      f2 = 2.0F;
    } else {
      f2 = 0.0F;
    } 
    animationSet.addAnimation((Animation)new ScaleAnimation(1.0F, f1, 1.0F, f2, 1, 0.5F, 1, 0.5F));
    animationSet.addAnimation((Animation)new AlphaAnimation(1.0F, 0.0F));
    animationSet.setDuration(paramLong);
    animationSet.setInterpolator((Interpolator)new DecelerateInterpolator());
    animationSet.setFillAfter(true);
    return (Animation)animationSet;
  }
  
  private Animation a(View paramView, boolean paramBoolean, long paramLong) {
    Animation animation = a(paramLong, paramBoolean);
    paramView.setAnimation(animation);
    return animation;
  }
  
  private void a() {
    int j = this.a.getChildCount();
    for (int i = 0; i < j; i++)
      this.a.getChildAt(i).clearAnimation(); 
    this.a.a(false);
  }
  
  private void a(Context paramContext) {
    ((LayoutInflater)paramContext.getSystemService("layout_inflater")).inflate(2131492926, (ViewGroup)this);
    this.a = (ArcLayout)findViewById(2131297626);
    this.b = (ViewGroup)findViewById(2131296840);
    this.b.setClickable(true);
    this.b.setOnTouchListener(new View.OnTouchListener(this) {
          public boolean onTouch(View param1View, MotionEvent param1MotionEvent) {
            if (param1MotionEvent.getAction() == 0)
              ArcMenu.a(this.a).a(true); 
            return false;
          }
        });
    this.c = (ImageView)findViewById(2131296839);
  }
  
  private void a(AttributeSet paramAttributeSet) {
    if (paramAttributeSet != null) {
      TypedArray typedArray = getContext().obtainStyledAttributes(paramAttributeSet, R.styleable.ArcLayout, 0, 0);
      float f1 = typedArray.getFloat(1, 270.0F);
      float f2 = typedArray.getFloat(2, 360.0F);
      this.a.a(f1, f2);
      int i = typedArray.getDimensionPixelSize(0, this.a.getChildSize());
      this.a.setChildSize(i);
      typedArray.recycle();
    } 
  }
  
  public void a(boolean paramBoolean) {
    ArcLayout arcLayout = this.a;
    if (arcLayout != null)
      arcLayout.b(paramBoolean); 
  }
  
  public void setOnExpandListener(ArcLayout.OnExpandListener paramOnExpandListener) {
    this.a.a(paramOnExpandListener, (View)this.b);
  }
  
  public static interface OnItemDisappearListener {
    void a();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blued\customview\capricorn\ArcMenu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */