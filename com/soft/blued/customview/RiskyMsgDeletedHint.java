package com.soft.blued.customview;

import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.das.message.MessageProtos;
import com.soft.blued.log.trackUtils.EventTrackMessage;

public class RiskyMsgDeletedHint extends LinearLayout {
  private Context a;
  
  private View b;
  
  private boolean c;
  
  private ValueAnimator d;
  
  private LinearLayout.LayoutParams e;
  
  private TextView f;
  
  public RiskyMsgDeletedHint(Context paramContext) {
    super(paramContext);
    a(paramContext);
  }
  
  public RiskyMsgDeletedHint(Context paramContext, AttributeSet paramAttributeSet) {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  public RiskyMsgDeletedHint(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext);
  }
  
  private void a(Context paramContext) {
    this.a = paramContext;
    this.b = LayoutInflater.from(this.a).inflate(2131493772, (ViewGroup)this);
    this.f = (TextView)this.b.findViewById(2131300890);
    new ValueAnimator();
    this.d = ValueAnimator.ofInt(new int[] { -DensityUtils.a(this.a, 36.0F), 0 });
    this.e = (LinearLayout.LayoutParams)this.f.getLayoutParams();
    this.d.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(this) {
          public void onAnimationUpdate(ValueAnimator param1ValueAnimator) {
            int i = ((Integer)param1ValueAnimator.getAnimatedValue()).intValue();
            (RiskyMsgDeletedHint.a(this.a)).topMargin = i;
            RiskyMsgDeletedHint.b(this.a).setLayoutParams((ViewGroup.LayoutParams)RiskyMsgDeletedHint.a(this.a));
          }
        });
    this.d.setInterpolator((TimeInterpolator)new AccelerateDecelerateInterpolator());
    this.d.setDuration(100L);
  }
  
  public boolean a() {
    return this.c;
  }
  
  public void b() {
    if (!isEnabled())
      return; 
    if (!this.c) {
      this.c = true;
      EventTrackMessage.a(MessageProtos.Event.MSG_DELETE_POINT_SHOW);
      this.d.start();
      postDelayed(new Runnable(this) {
            public void run() {
              this.a.c();
            }
          },  5000L);
    } 
  }
  
  public void c() {
    if (!this.c)
      return; 
    this.c = false;
    this.d.reverse();
  }
  
  public void setHint(String paramString) {
    this.f.setText(paramString);
  }
  
  public void setHintTipsHeight(int paramInt) {
    TextView textView = this.f;
    if (textView == null)
      return; 
    if (this.e == null)
      this.e = (LinearLayout.LayoutParams)textView.getLayoutParams(); 
    LinearLayout.LayoutParams layoutParams = this.e;
    Context context = this.a;
    float f = paramInt;
    layoutParams.height = DensityUtils.a(context, f);
    this.e.topMargin = -DensityUtils.a(this.a, f);
    if (this.d == null) {
      new ValueAnimator();
      this.d = ValueAnimator.ofInt(new int[] { -DensityUtils.a(this.a, (paramInt + 1)), 0 });
    } 
    this.d.setIntValues(new int[] { -DensityUtils.a(this.a, (paramInt + 1)), 0 });
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blued\customview\RiskyMsgDeletedHint.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */