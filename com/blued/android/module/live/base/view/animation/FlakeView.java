package com.blued.android.module.live.base.view.animation;

import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import com.blued.android.core.AppInfo;
import com.blued.android.module.live.base.R;
import java.util.ArrayList;
import java.util.Iterator;

public class FlakeView extends View {
  private Context a;
  
  private int b;
  
  private float c;
  
  private float d;
  
  private float e;
  
  private float f;
  
  private float g;
  
  private float h;
  
  private long i;
  
  private long j;
  
  private int k;
  
  private LiveAnimationListener l;
  
  private Bitmap m;
  
  private ArrayList<FlakeConfig> n = new ArrayList<FlakeConfig>();
  
  private ValueAnimator o;
  
  private Matrix p;
  
  public FlakeView(Context paramContext) {
    this(paramContext, (AttributeSet)null);
  }
  
  public FlakeView(Context paramContext, AttributeSet paramAttributeSet) {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public FlakeView(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
    this.a = paramContext;
    TypedArray typedArray = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.FlakeView, paramInt, 0);
    paramInt = typedArray.getResourceId(R.styleable.FlakeView_flake_pic, R.drawable.icon_money_gift);
    this.b = typedArray.getInt(R.styleable.FlakeView_flake_count, 0);
    this.c = typedArray.getDimension(R.styleable.FlakeView_drop_speed_low_limit, 1300.0F);
    this.d = typedArray.getDimension(R.styleable.FlakeView_drop_speed_high_limit, 1800.0F);
    this.e = typedArray.getDimension(R.styleable.FlakeView_rotation_speed_low_limit, -45.0F);
    this.f = typedArray.getDimension(R.styleable.FlakeView_rotation_speed_high_limit, 45.0F);
    this.g = typedArray.getDimension(R.styleable.FlakeView_rotation_degree_low_limit, -90.0F);
    this.h = typedArray.getDimension(R.styleable.FlakeView_rotation_degree_high_limit, 90.0F);
    this.m = BitmapFactory.decodeResource(getResources(), paramInt);
    a();
    typedArray.recycle();
  }
  
  private void a(FlakeConfig paramFlakeConfig) {
    paramFlakeConfig.a(this.c, this.d);
    paramFlakeConfig.b(this.g, this.h);
    paramFlakeConfig.c(this.e, this.f);
    paramFlakeConfig.a();
  }
  
  private void c() {
    this.n.clear();
    this.o.cancel();
    setVisibility(8);
  }
  
  private void d() {
    c();
    LiveAnimationListener liveAnimationListener = this.l;
    if (liveAnimationListener != null)
      liveAnimationListener.b(); 
  }
  
  protected void a() {
    this.p = new Matrix();
    this.o = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    this.o.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(this) {
          public void onAnimationUpdate(ValueAnimator param1ValueAnimator) {
            long l = System.currentTimeMillis();
            float f = (float)(l - FlakeView.a(this.a)) / 1000.0F;
            FlakeView.a(this.a, l);
            l -= FlakeView.b(this.a);
            Iterator<FlakeConfig> iterator = FlakeView.c(this.a).iterator();
            while (iterator.hasNext()) {
              FlakeConfig flakeConfig = iterator.next();
              flakeConfig.d += flakeConfig.f * f;
              flakeConfig.e += flakeConfig.g * f;
              if (flakeConfig.d >= this.a.getHeight() && l <= 2500L)
                flakeConfig.a(); 
              if (flakeConfig.d >= this.a.getHeight() && l > 2500L)
                iterator.remove(); 
            } 
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("totalTime = ");
            stringBuilder.append(l);
            Log.v("drb", stringBuilder.toString());
            if (FlakeView.c(this.a).size() == 0)
              FlakeView.d(this.a); 
            this.a.invalidate();
          }
        });
    this.o.setRepeatCount(-1);
    this.o.setDuration(2500L);
  }
  
  public void a(int paramInt) {
    int i;
    int j;
    if (((Activity)this.a).getRequestedOrientation() == 1) {
      i = AppInfo.l;
      j = AppInfo.m;
    } else {
      i = AppInfo.m;
      j = AppInfo.l;
    } 
    int k;
    for (k = 0; k < paramInt; k++) {
      FlakeConfig flakeConfig = new FlakeConfig(this.a, i, j, this.m);
      a(flakeConfig);
      this.n.add(flakeConfig);
    } 
  }
  
  public void b() {
    LiveAnimationListener liveAnimationListener = this.l;
    if (liveAnimationListener != null)
      liveAnimationListener.a(); 
    c();
    this.k = 0;
    this.i = System.currentTimeMillis();
    this.j = this.i;
    setVisibility(0);
    a(this.b);
    this.o.start();
  }
  
  protected void onDraw(Canvas paramCanvas) {
    super.onDraw(paramCanvas);
    for (int i = 0; i < this.n.size(); i++) {
      FlakeConfig flakeConfig = this.n.get(i);
      this.p.setTranslate((-flakeConfig.a / 2), (-flakeConfig.b / 2));
      this.p.postRotate(flakeConfig.e);
      this.p.postTranslate((flakeConfig.a / 2) + flakeConfig.c, (flakeConfig.b / 2) + flakeConfig.d);
      paramCanvas.drawBitmap(flakeConfig.h, this.p, null);
    } 
  }
  
  public void setAnimationListener(LiveAnimationListener paramLiveAnimationListener) {
    this.l = paramLiveAnimationListener;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\live\base\view\animation\FlakeView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */