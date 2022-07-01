package com.blued.android.module.shortvideo.view;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import androidx.appcompat.widget.AppCompatTextView;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.module.shortvideo.R;
import com.blued.android.module.shortvideo.manager.ObserverMgr;
import com.blued.android.module.shortvideo.model.EventType;
import com.blued.android.module.shortvideo.observer.EventObserver;
import com.blued.android.module.shortvideo.presenter.ShinePresenter;
import java.lang.ref.WeakReference;

public class TimeDownView extends AppCompatTextView implements EventObserver {
  private Handler a = new MsgHandler(this);
  
  private int b = 3;
  
  private ShinePresenter c;
  
  public TimeDownView(Context paramContext) {
    super(paramContext);
  }
  
  public TimeDownView(Context paramContext, AttributeSet paramAttributeSet) {
    super(paramContext, paramAttributeSet);
  }
  
  public TimeDownView(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private void g() {
    AlphaAnimation alphaAnimation = new AlphaAnimation(0.3F, 1.0F);
    alphaAnimation.setDuration(1000L);
    startAnimation((Animation)alphaAnimation);
    ScaleAnimation scaleAnimation = new ScaleAnimation(0.5F, 1.0F, 0.5F, 1.0F, 1, 0.5F, 1, 0.5F);
    scaleAnimation.setDuration(1000L);
    startAnimation((Animation)scaleAnimation);
  }
  
  public void a() {
    ShinePresenter shinePresenter = this.c;
    if (shinePresenter != null)
      shinePresenter.a(5); 
    setVisibility(0);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("");
    stringBuilder.append(this.b);
    setText(stringBuilder.toString());
    g();
  }
  
  public void a(Message paramMessage) {
    if (this.b == 0) {
      ObserverMgr.a().a(EventType.VALUE.g);
      b();
      return;
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("");
    stringBuilder.append(this.b);
    setText(stringBuilder.toString());
    g();
    this.a.sendEmptyMessageDelayed(0, 1000L);
    this.b--;
  }
  
  public void a(EventType.VALUE paramVALUE) {
    if (paramVALUE == EventType.VALUE.m) {
      a();
      this.a.sendEmptyMessage(0);
    } 
  }
  
  public void a(ShinePresenter paramShinePresenter) {
    this.c = paramShinePresenter;
    setTextColor(getResources().getColor(R.color.nafio_b));
    setShadowLayer(1.0F, 0.0F, 1.0F, getResources().getColor(R.color.stv_tv_shadow_color));
    setTextSize(DensityUtils.c(getContext(), 200.0F));
    getPaint().setFakeBoldText(true);
  }
  
  public void b() {
    this.a.removeMessages(0);
    this.b = 3;
    ShinePresenter shinePresenter = this.c;
    if (shinePresenter != null)
      shinePresenter.a(0); 
    setVisibility(8);
  }
  
  public void c() {
    ObserverMgr.a().a(this);
  }
  
  public void d() {
    if (getVisibility() == 0)
      ObserverMgr.a().a(EventType.VALUE.x); 
    b();
  }
  
  public void e() {
    ObserverMgr.a().b(this);
  }
  
  public void f() {
    this.a.removeMessages(0);
  }
  
  public static class MsgHandler extends Handler {
    private WeakReference<TimeDownView> a;
    
    public MsgHandler(TimeDownView param1TimeDownView) {
      this.a = new WeakReference<TimeDownView>(param1TimeDownView);
    }
    
    public void handleMessage(Message param1Message) {
      TimeDownView timeDownView = this.a.get();
      if (timeDownView != null)
        timeDownView.a(param1Message); 
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\blued\android\module\shortvideo\view\TimeDownView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */