package com.scwang.smartrefresh.layout.internal;

import android.animation.TimeInterpolator;
import android.content.Context;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.scwang.smartrefresh.layout.api.RefreshInternal;
import com.scwang.smartrefresh.layout.api.RefreshKernel;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.util.DensityUtil;

public abstract class InternalClassics<T extends InternalClassics> extends InternalAbstract implements RefreshInternal {
  protected int A;
  
  protected int B = 500;
  
  protected int C = 20;
  
  protected int D = 20;
  
  protected TextView o;
  
  protected ImageView p;
  
  protected ImageView q;
  
  protected LinearLayout r;
  
  protected RefreshKernel s;
  
  protected ArrowDrawable t;
  
  protected ProgressDrawable u;
  
  protected Integer y;
  
  protected Integer z;
  
  public InternalClassics(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
    this.p = new ImageView(paramContext);
    this.q = new ImageView(paramContext);
    this.o = new TextView(paramContext);
    this.o.setTextColor(-10066330);
    this.r = new LinearLayout(paramContext);
    this.r.setGravity(1);
    this.r.setOrientation(1);
    ImageView imageView1 = this.p;
    TextView textView = this.o;
    ImageView imageView2 = this.q;
    LinearLayout linearLayout = this.r;
    DensityUtil densityUtil = new DensityUtil();
    textView.setId(1);
    imageView1.setId(2);
    imageView2.setId(3);
    linearLayout.setId(16908312);
    linearLayout.addView((View)textView, (ViewGroup.LayoutParams)new LinearLayout.LayoutParams(-2, -2));
    RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
    layoutParams2.addRule(13);
    addView((View)linearLayout, (ViewGroup.LayoutParams)layoutParams2);
    RelativeLayout.LayoutParams layoutParams1 = new RelativeLayout.LayoutParams(densityUtil.b(20.0F), densityUtil.b(20.0F));
    layoutParams1.addRule(15);
    layoutParams1.addRule(0, 16908312);
    addView((View)imageView1, (ViewGroup.LayoutParams)layoutParams1);
    layoutParams1 = new RelativeLayout.LayoutParams((ViewGroup.LayoutParams)layoutParams1);
    layoutParams1.addRule(15);
    layoutParams1.addRule(0, 16908312);
    imageView2.animate().setInterpolator((TimeInterpolator)new LinearInterpolator());
    addView((View)imageView2, (ViewGroup.LayoutParams)layoutParams1);
    if (getPaddingTop() == 0) {
      if (getPaddingBottom() == 0) {
        paramInt = getPaddingLeft();
        int i = densityUtil.b(20.0F);
        this.C = i;
        int j = getPaddingRight();
        int k = densityUtil.b(20.0F);
        this.D = k;
        setPadding(paramInt, i, j, k);
      } else {
        paramInt = getPaddingLeft();
        int i = densityUtil.b(20.0F);
        this.C = i;
        int j = getPaddingRight();
        int k = getPaddingBottom();
        this.D = k;
        setPadding(paramInt, i, j, k);
      } 
    } else if (getPaddingBottom() == 0) {
      paramInt = getPaddingLeft();
      int i = getPaddingTop();
      this.C = i;
      int j = getPaddingRight();
      int k = densityUtil.b(20.0F);
      this.D = k;
      setPadding(paramInt, i, j, k);
    } else {
      this.C = getPaddingTop();
      this.D = getPaddingBottom();
    } 
    if (isInEditMode()) {
      imageView1.setVisibility(8);
      return;
    } 
    imageView2.setVisibility(8);
  }
  
  public int a(RefreshLayout paramRefreshLayout, boolean paramBoolean) {
    ImageView imageView = this.q;
    Drawable drawable = imageView.getDrawable();
    if (drawable instanceof Animatable) {
      Animatable animatable = (Animatable)drawable;
      if (animatable.isRunning())
        animatable.stop(); 
    } else {
      imageView.animate().rotation(0.0F).setDuration(0L);
    } 
    imageView.setVisibility(8);
    return this.B;
  }
  
  public void a(RefreshKernel paramRefreshKernel, int paramInt1, int paramInt2) {
    this.s = paramRefreshKernel;
    this.s.a(this, this.A);
  }
  
  public void a(RefreshLayout paramRefreshLayout, int paramInt1, int paramInt2) {
    b(paramRefreshLayout, paramInt1, paramInt2);
  }
  
  protected T b() {
    return (T)this;
  }
  
  public T b(int paramInt) {
    this.y = Integer.valueOf(paramInt);
    this.o.setTextColor(paramInt);
    ArrowDrawable arrowDrawable = this.t;
    if (arrowDrawable != null)
      arrowDrawable.a(paramInt); 
    ProgressDrawable progressDrawable = this.u;
    if (progressDrawable != null)
      progressDrawable.a(paramInt); 
    return b();
  }
  
  public void b(RefreshLayout paramRefreshLayout, int paramInt1, int paramInt2) {
    ImageView imageView = this.q;
    if (imageView.getVisibility() != 0) {
      imageView.setVisibility(0);
      Drawable drawable = this.q.getDrawable();
      if (drawable instanceof Animatable) {
        ((Animatable)drawable).start();
        return;
      } 
      imageView.animate().rotation(36000.0F).setDuration(100000L);
    } 
  }
  
  public T c(int paramInt) {
    Integer integer = Integer.valueOf(paramInt);
    this.z = integer;
    this.A = integer.intValue();
    RefreshKernel refreshKernel = this.s;
    if (refreshKernel != null)
      refreshKernel.a(this, this.z.intValue()); 
    return b();
  }
  
  protected void onDetachedFromWindow() {
    super.onDetachedFromWindow();
    if (Build.VERSION.SDK_INT >= 14) {
      ImageView imageView1 = this.p;
      ImageView imageView2 = this.q;
      imageView1.animate().cancel();
      imageView2.animate().cancel();
    } 
    Drawable drawable = this.q.getDrawable();
    if (drawable instanceof Animatable) {
      Animatable animatable = (Animatable)drawable;
      if (animatable.isRunning())
        animatable.stop(); 
    } 
  }
  
  protected void onMeasure(int paramInt1, int paramInt2) {
    if (View.MeasureSpec.getMode(paramInt2) == 1073741824) {
      setPadding(getPaddingLeft(), 0, getPaddingRight(), 0);
    } else {
      setPadding(getPaddingLeft(), this.C, getPaddingRight(), this.D);
    } 
    super.onMeasure(paramInt1, paramInt2);
  }
  
  @Deprecated
  public void setPrimaryColors(int... paramVarArgs) {
    if (paramVarArgs.length > 0) {
      if (!(getBackground() instanceof android.graphics.drawable.BitmapDrawable) && this.z == null) {
        c(paramVarArgs[0]);
        this.z = null;
      } 
      if (this.y == null) {
        if (paramVarArgs.length > 1)
          b(paramVarArgs[1]); 
        this.y = null;
      } 
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\scwang\smartrefresh\layout\internal\InternalClassics.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */