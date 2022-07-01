package com.soft.blued.customview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class RotateLayout extends LinearLayout {
  private Bitmap a;
  
  private View b;
  
  private ImageView c;
  
  private float d = 0.0F;
  
  private boolean e = false;
  
  private boolean f = false;
  
  public RotateLayout(Context paramContext) {
    super(paramContext);
    a();
  }
  
  public RotateLayout(Context paramContext, AttributeSet paramAttributeSet) {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  void a() {
    this.b = LayoutInflater.from(getContext()).inflate(2131494100, (ViewGroup)this);
    this.a = BitmapFactory.decodeResource(getResources(), 2131232791);
    this.c = (ImageView)this.b.findViewById(2131297836);
    this.c.setImageBitmap(this.a);
  }
  
  public void a(float paramFloat) {
    int i = this.a.getWidth();
    int j = this.a.getHeight();
    Matrix matrix = new Matrix();
    paramFloat = this.d + paramFloat;
    this.d = paramFloat;
    matrix.setRotate(paramFloat, (i / 2), (j / 2));
    Bitmap bitmap = Bitmap.createBitmap(this.a, 0, 0, i, j, matrix, true);
    this.c.setScaleType(ImageView.ScaleType.CENTER);
    this.c.setImageBitmap(bitmap);
    boolean bool = this.f;
  }
  
  public void b() {
    RotateAnimation rotateAnimation = new RotateAnimation(0.0F, 360.0F, 1, 0.5F, 1, 0.5F);
    rotateAnimation.setInterpolator((Interpolator)new LinearInterpolator());
    rotateAnimation.setDuration(500L);
    rotateAnimation.setRepeatCount(-1);
    rotateAnimation.setFillAfter(true);
    this.c.startAnimation((Animation)rotateAnimation);
  }
  
  public void c() {
    this.c.clearAnimation();
  }
  
  public void d() {
    if (this.e)
      return; 
    this.e = true;
    Animation animation = AnimationUtils.loadAnimation(getContext(), 2130772059);
    animation.setDuration(500L);
    animation.setFillAfter(true);
    this.c.setVisibility(0);
    this.c.startAnimation(animation);
    animation.setAnimationListener(new Animation.AnimationListener(this) {
          public void onAnimationEnd(Animation param1Animation) {
            RotateLayout.a(this.a, true);
          }
          
          public void onAnimationRepeat(Animation param1Animation) {}
          
          public void onAnimationStart(Animation param1Animation) {
            RotateLayout.a(this.a, false);
          }
        });
  }
  
  public void e() {
    c();
    this.e = false;
    Animation animation = AnimationUtils.loadAnimation(getContext(), 2130772060);
    animation.setDuration(500L);
    animation.setFillAfter(true);
    this.c.startAnimation(animation);
    animation.setAnimationListener(new Animation.AnimationListener(this) {
          public void onAnimationEnd(Animation param1Animation) {
            this.a.scrollTo(0, 0);
          }
          
          public void onAnimationRepeat(Animation param1Animation) {}
          
          public void onAnimationStart(Animation param1Animation) {}
        });
  }
  
  public void setRefreshingBM(int paramInt) {
    this.a = BitmapFactory.decodeResource(getResources(), paramInt);
  }
  
  public class baseAnimationListener implements Animation.AnimationListener {
    public void onAnimationEnd(Animation param1Animation) {}
    
    public void onAnimationRepeat(Animation param1Animation) {}
    
    public void onAnimationStart(Animation param1Animation) {}
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blued\customview\RotateLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */