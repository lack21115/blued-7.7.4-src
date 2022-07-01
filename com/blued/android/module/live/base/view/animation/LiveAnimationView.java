package com.blued.android.module.live.base.view.animation;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.blued.android.core.net.IRequestHost;

public class LiveAnimationView extends FrameLayout {
  private Context a;
  
  private LiveAnimationViewFactory b;
  
  private LiveAnimationListener c;
  
  public LiveAnimationView(Context paramContext) {
    this(paramContext, (AttributeSet)null);
  }
  
  public LiveAnimationView(Context paramContext, AttributeSet paramAttributeSet) {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public LiveAnimationView(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
    this.a = paramContext;
  }
  
  private void a(View paramView) {
    removeAllViews();
    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
    layoutParams.gravity = 17;
    addView(paramView, (ViewGroup.LayoutParams)layoutParams);
  }
  
  private void b(View paramView) {
    removeView(paramView);
  }
  
  public void a(IRequestHost paramIRequestHost, String paramString1, String paramString2, String paramString3, String paramString4, LiveAnimationListener paramLiveAnimationListener) {
    a(paramIRequestHost, paramString1, paramString2, paramString3, paramString4, LiveAnimationViewFactory.ScaleType.b, paramLiveAnimationListener);
  }
  
  public void a(IRequestHost paramIRequestHost, String paramString1, String paramString2, String paramString3, String paramString4, LiveAnimationViewFactory.ScaleType paramScaleType, LiveAnimationListener paramLiveAnimationListener) {
    if (TextUtils.isEmpty(paramString1) && TextUtils.isEmpty(paramString2) && TextUtils.isEmpty(paramString4) && TextUtils.isEmpty(paramString3)) {
      if (paramLiveAnimationListener != null)
        paramLiveAnimationListener.b(); 
      return;
    } 
    this.c = paramLiveAnimationListener;
    if (this.b == null)
      this.b = new LiveAnimationViewFactory(); 
    BaseLiveAnimationView baseLiveAnimationView = this.b.a(this.a, paramString1, paramString2, paramString3, paramString4, paramScaleType);
    baseLiveAnimationView.a(new LiveAnimationListener(this, baseLiveAnimationView) {
          public void a() {
            if (LiveAnimationView.a(this.b) != null)
              LiveAnimationView.a(this.b).a(); 
          }
          
          public void b() {
            LiveAnimationView.a(this.b, this.a.a());
            if (LiveAnimationView.a(this.b) != null)
              LiveAnimationView.a(this.b).b(); 
          }
        });
    a(baseLiveAnimationView.a());
    baseLiveAnimationView.a(paramIRequestHost);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\live\base\view\animation\LiveAnimationView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */