package com.blued.android.module.live_china.view;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.ui.ActivityFragmentActive;
import com.blued.android.module.live.base.utils.LiveTimeAndDateUtils;
import com.blued.android.module.live_china.R;

public class PKDoubleAnimView extends FrameLayout {
  public static int a;
  
  long b = 0L;
  
  long c = 0L;
  
  Runnable d = new Runnable(this) {
      public void run() {
        if (this.a.b <= 0L) {
          this.a.a();
          return;
        } 
        int i = (int)((float)this.a.b * 1.0F / (float)this.a.c * 10000.0F);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("value:");
        stringBuilder.append(i);
        Log.i("xpm====", stringBuilder.toString());
        PKDoubleAnimView.d(this.a).setLevel(i);
        PKDoubleAnimView.a(this.a).setText(LiveTimeAndDateUtils.a(this.a.b, false));
        PKDoubleAnimView pKDoubleAnimView = this.a;
        pKDoubleAnimView.b--;
        pKDoubleAnimView = this.a;
        pKDoubleAnimView.postDelayed(pKDoubleAnimView.d, 1000L);
      }
    };
  
  ScaleAnimation e = null;
  
  private ImageView f;
  
  private TextView g;
  
  private View h;
  
  private View i;
  
  private ImageView j;
  
  private WaveDrawable k;
  
  public PKDoubleAnimView(Context paramContext) {
    this(paramContext, (AttributeSet)null);
  }
  
  public PKDoubleAnimView(Context paramContext, AttributeSet paramAttributeSet) {
    super(paramContext, paramAttributeSet);
    b();
  }
  
  private void b() {
    LayoutInflater.from(getContext()).inflate(R.layout.live_pk_double_anim_view, (ViewGroup)this);
    this.h = findViewById(R.id.fl_anim);
    this.f = (ImageView)findViewById(R.id.iv_pk);
    this.g = (TextView)findViewById(R.id.tv_time);
    this.g.setVisibility(8);
    this.i = findViewById(R.id.cardview);
    this.i.setVisibility(8);
    this.j = (ImageView)findViewById(R.id.iv_wave);
    this.k = new WaveDrawable(getContext(), R.drawable.live_pk_double_anim_bg);
    this.j.setImageDrawable(this.k);
    this.k.setLevel(10000);
  }
  
  private void c() {
    this.i.setVisibility(8);
    AlphaAnimation alphaAnimation = new AlphaAnimation(0.0F, 1.0F);
    alphaAnimation.setDuration(300L);
    alphaAnimation.setFillAfter(false);
    this.i.clearAnimation();
    this.i.startAnimation((Animation)alphaAnimation);
    this.i.setVisibility(0);
  }
  
  private void d() {
    this.e = new ScaleAnimation(1.0F, 1.1F, 1.0F, 1.1F, 1, 0.5F, 1, 0.5F);
    this.e.setDuration(600L);
    this.e.setFillAfter(false);
    this.e.setRepeatMode(2);
    this.e.setRepeatCount(-1);
    this.h.clearAnimation();
    this.h.startAnimation((Animation)this.e);
  }
  
  public void a() {
    this.g.setVisibility(8);
    this.h.clearAnimation();
    this.b = 0L;
    this.c = 0L;
    ScaleAnimation scaleAnimation = this.e;
    if (scaleAnimation != null)
      scaleAnimation.cancel(); 
    removeCallbacks(this.d);
    setVisibility(8);
  }
  
  public void a(ActivityFragmentActive paramActivityFragmentActive, long paramLong) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("countDown:");
    stringBuilder.append(paramLong);
    Log.i("xpm====", stringBuilder.toString());
    if (getVisibility() == 0)
      return; 
    setVisibility(0);
    a++;
    ImageLoader.c((IRequestHost)paramActivityFragmentActive, "live_pk_count_down.png").a(new ImageLoader.OnAnimationStateListener(this) {
          public void a() {}
          
          public void b() {
            PKDoubleAnimView.a(this.a).setVisibility(0);
            PKDoubleAnimView.b(this.a);
            PKDoubleAnimView.c(this.a);
          }
        }).d(a).a(this.f);
    this.c = paramLong;
    this.b = paramLong;
    post(this.d);
  }
  
  protected void onDetachedFromWindow() {
    super.onDetachedFromWindow();
    a();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\live_china\view\PKDoubleAnimView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */