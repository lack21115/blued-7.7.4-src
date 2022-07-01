package com.blued.android.module.live_china.view.shimmer;

import android.content.res.TypedArray;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;
import com.blued.android.module.live_china.R;

public class ShimmerViewHelper {
  private View a;
  
  private Paint b;
  
  private float c;
  
  private LinearGradient d;
  
  private Matrix e;
  
  private int f;
  
  private int g;
  
  private boolean h;
  
  private boolean i;
  
  private AnimationSetupCallback j;
  
  public ShimmerViewHelper(View paramView, Paint paramPaint, AttributeSet paramAttributeSet) {
    this.a = paramView;
    this.b = paramPaint;
    a(paramAttributeSet);
  }
  
  private void a(AttributeSet paramAttributeSet) {
    this.g = -1;
    if (paramAttributeSet != null) {
      TypedArray typedArray = this.a.getContext().obtainStyledAttributes(paramAttributeSet, R.styleable.ShimmerView, 0, 0);
      if (typedArray != null) {
        try {
          this.g = typedArray.getColor(R.styleable.ShimmerView_reflectionColor, -1);
        } catch (Exception exception) {
          exception.printStackTrace();
        } finally {
          Exception exception;
        } 
        typedArray.recycle();
      } 
    } 
    this.e = new Matrix();
  }
  
  private void g() {
    float f = -this.a.getWidth();
    int i = this.f;
    int j = this.g;
    Shader.TileMode tileMode = Shader.TileMode.CLAMP;
    this.d = new LinearGradient(f, 0.0F, 0.0F, 0.0F, new int[] { i, j, i }, new float[] { 0.0F, 0.5F, 1.0F }, tileMode);
    this.b.setShader((Shader)this.d);
  }
  
  public float a() {
    return this.c;
  }
  
  public void a(float paramFloat) {
    this.c = paramFloat;
    this.a.invalidate();
  }
  
  public void a(int paramInt) {
    this.f = paramInt;
    if (this.i)
      g(); 
  }
  
  public void a(AnimationSetupCallback paramAnimationSetupCallback) {
    this.j = paramAnimationSetupCallback;
  }
  
  public void a(boolean paramBoolean) {
    this.h = paramBoolean;
  }
  
  public void b(int paramInt) {
    this.g = paramInt;
    if (this.i)
      g(); 
  }
  
  public boolean b() {
    return this.i;
  }
  
  public int c() {
    return this.f;
  }
  
  public int d() {
    return this.g;
  }
  
  protected void e() {
    g();
    if (!this.i) {
      this.i = true;
      AnimationSetupCallback animationSetupCallback = this.j;
      if (animationSetupCallback != null)
        animationSetupCallback.a(this.a); 
    } 
  }
  
  public void f() {
    if (this.h) {
      if (this.b.getShader() == null)
        this.b.setShader((Shader)this.d); 
      this.e.setTranslate(this.c * 2.0F, 0.0F);
      this.d.setLocalMatrix(this.e);
      return;
    } 
    this.b.setShader(null);
  }
  
  public static interface AnimationSetupCallback {
    void a(View param1View);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\live_china\view\shimmer\ShimmerViewHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */