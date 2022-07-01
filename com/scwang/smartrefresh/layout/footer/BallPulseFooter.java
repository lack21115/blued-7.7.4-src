package com.scwang.smartrefresh.layout.footer;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import androidx.core.graphics.ColorUtils;
import com.scwang.smartrefresh.layout.R;
import com.scwang.smartrefresh.layout.api.RefreshFooter;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.constant.SpinnerStyle;
import com.scwang.smartrefresh.layout.internal.InternalAbstract;
import com.scwang.smartrefresh.layout.util.DensityUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class BallPulseFooter extends InternalAbstract implements RefreshFooter {
  protected boolean a;
  
  protected boolean b;
  
  protected Paint c;
  
  protected int d = -1118482;
  
  protected int e = -1615546;
  
  protected float f;
  
  protected float[] g = new float[] { 1.0F, 1.0F, 1.0F };
  
  protected boolean h;
  
  protected ArrayList<ValueAnimator> i;
  
  protected Map<ValueAnimator, ValueAnimator.AnimatorUpdateListener> j;
  
  public BallPulseFooter(Context paramContext) {
    this(paramContext, null);
  }
  
  public BallPulseFooter(Context paramContext, AttributeSet paramAttributeSet) {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public BallPulseFooter(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
    paramInt = 0;
    this.h = false;
    this.j = new HashMap<ValueAnimator, ValueAnimator.AnimatorUpdateListener>();
    setMinimumHeight(DensityUtil.a(60.0F));
    TypedArray typedArray = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.BallPulseFooter);
    this.c = new Paint();
    this.c.setColor(-1);
    this.c.setStyle(Paint.Style.FILL);
    this.c.setAntiAlias(true);
    this.w = SpinnerStyle.a;
    this.w = SpinnerStyle.values()[typedArray.getInt(R.styleable.BallPulseFooter_srlClassicsSpinnerStyle, this.w.ordinal())];
    if (typedArray.hasValue(R.styleable.BallPulseFooter_srlNormalColor))
      a(typedArray.getColor(R.styleable.BallPulseFooter_srlNormalColor, 0)); 
    if (typedArray.hasValue(R.styleable.BallPulseFooter_srlAnimatingColor))
      b(typedArray.getColor(R.styleable.BallPulseFooter_srlAnimatingColor, 0)); 
    typedArray.recycle();
    this.f = DensityUtil.a(4.0F);
    this.i = new ArrayList<ValueAnimator>();
    while (paramInt < 3) {
      ValueAnimator valueAnimator = ValueAnimator.ofFloat(new float[] { 1.0F, 0.3F, 1.0F });
      valueAnimator.setDuration(750L);
      valueAnimator.setRepeatCount(-1);
      valueAnimator.setTarget(Integer.valueOf(paramInt));
      (new int[3])[0] = 120;
      (new int[3])[1] = 240;
      (new int[3])[2] = 360;
      valueAnimator.setStartDelay((new int[3])[paramInt]);
      this.j.put(valueAnimator, new ValueAnimator.AnimatorUpdateListener(this, paramInt, (View)this) {
            public void onAnimationUpdate(ValueAnimator param1ValueAnimator) {
              this.c.g[this.a] = ((Float)param1ValueAnimator.getAnimatedValue()).floatValue();
              this.b.postInvalidate();
            }
          });
      this.i.add(valueAnimator);
      paramInt++;
    } 
  }
  
  public int a(RefreshLayout paramRefreshLayout, boolean paramBoolean) {
    ArrayList<ValueAnimator> arrayList = this.i;
    if (arrayList != null && this.h) {
      this.h = false;
      this.g = new float[] { 1.0F, 1.0F, 1.0F };
      for (ValueAnimator valueAnimator : arrayList) {
        if (valueAnimator != null) {
          valueAnimator.removeAllUpdateListeners();
          valueAnimator.end();
        } 
      } 
    } 
    this.c.setColor(this.d);
    return 0;
  }
  
  public BallPulseFooter a(int paramInt) {
    this.d = paramInt;
    this.a = true;
    if (!this.h)
      this.c.setColor(paramInt); 
    return this;
  }
  
  public boolean a(boolean paramBoolean) {
    return false;
  }
  
  public BallPulseFooter b(int paramInt) {
    this.e = paramInt;
    this.b = true;
    if (this.h)
      this.c.setColor(paramInt); 
    return this;
  }
  
  public void b(RefreshLayout paramRefreshLayout, int paramInt1, int paramInt2) {
    if (this.h)
      return; 
    for (paramInt1 = 0; paramInt1 < this.i.size(); paramInt1++) {
      ValueAnimator valueAnimator = this.i.get(paramInt1);
      ValueAnimator.AnimatorUpdateListener animatorUpdateListener = this.j.get(valueAnimator);
      if (animatorUpdateListener != null)
        valueAnimator.addUpdateListener(animatorUpdateListener); 
      valueAnimator.start();
    } 
    this.h = true;
    this.c.setColor(this.e);
  }
  
  protected void dispatchDraw(Canvas paramCanvas) {
    int i = getWidth();
    int j = getHeight();
    float f2 = Math.min(i, j);
    float f1 = this.f;
    f2 = (f2 - f1 * 2.0F) / 6.0F;
    float f3 = (i / 2);
    float f4 = 2.0F * f2;
    float f5 = (j / 2);
    for (i = 0; i < 3; i++) {
      paramCanvas.save();
      float f = i;
      paramCanvas.translate(f4 * f + f3 - f1 + f4 + this.f * f, f5);
      float[] arrayOfFloat = this.g;
      paramCanvas.scale(arrayOfFloat[i], arrayOfFloat[i]);
      paramCanvas.drawCircle(0.0F, 0.0F, f2, this.c);
      paramCanvas.restore();
    } 
    super.dispatchDraw(paramCanvas);
  }
  
  protected void onDetachedFromWindow() {
    super.onDetachedFromWindow();
    if (this.i != null)
      for (int i = 0; i < this.i.size(); i++) {
        ((ValueAnimator)this.i.get(i)).cancel();
        ((ValueAnimator)this.i.get(i)).removeAllListeners();
        ((ValueAnimator)this.i.get(i)).removeAllUpdateListeners();
      }  
  }
  
  @Deprecated
  public void setPrimaryColors(int... paramVarArgs) {
    if (!this.b && paramVarArgs.length > 1) {
      b(paramVarArgs[0]);
      this.b = false;
    } 
    if (!this.a) {
      if (paramVarArgs.length > 1) {
        a(paramVarArgs[1]);
      } else if (paramVarArgs.length > 0) {
        a(ColorUtils.compositeColors(-1711276033, paramVarArgs[0]));
      } 
      this.a = false;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\scwang\smartrefresh\layout\footer\BallPulseFooter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */