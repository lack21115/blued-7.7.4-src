package com.blued.android.module.live_china.view;

import android.app.Activity;
import android.content.Context;
import android.media.AudioManager;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import com.blued.android.core.AppInfo;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.module.live_china.R;

public class VolumeBrightnessView extends FrameLayout {
  public View a;
  
  public Context b;
  
  public LayoutInflater c;
  
  public AudioManager d;
  
  public DismissWindow e;
  
  private ImageView f;
  
  private ProgressBar g;
  
  private int h;
  
  private int i;
  
  private float j = -1.0F;
  
  private boolean k;
  
  private int l;
  
  private int m = 1;
  
  private int n = 2;
  
  public VolumeBrightnessView(Context paramContext) {
    this(paramContext, null);
  }
  
  public VolumeBrightnessView(Context paramContext, AttributeSet paramAttributeSet) {
    super(paramContext, paramAttributeSet);
    this.b = paramContext;
    d();
    c();
  }
  
  private void c() {
    this.c = LayoutInflater.from(this.b);
    this.a = this.c.inflate(R.layout.live_volume_brightness_layout, (ViewGroup)this);
    this.f = (ImageView)this.a.findViewById(R.id.function_icon);
    this.g = (ProgressBar)this.a.findViewById(R.id.function_progress);
  }
  
  private void d() {
    this.e = new DismissWindow(this);
    this.d = (AudioManager)this.b.getSystemService("audio");
  }
  
  public void a() {
    this.k = true;
    this.h = this.d.getStreamMaxVolume(3);
  }
  
  public void a(Activity paramActivity, MotionEvent paramMotionEvent, float paramFloat1, float paramFloat2) {
    float f = paramMotionEvent.getX();
    if (this.k)
      if (f > (AppInfo.m / 2)) {
        this.l = this.m;
      } else if (f < (AppInfo.m / 2)) {
        this.l = this.n;
      }  
    int i = this.l;
    if (i == this.m) {
      this.i = this.d.getStreamVolume(3);
      if (Math.abs(paramFloat2) > Math.abs(paramFloat1)) {
        if (paramFloat2 >= DensityUtils.a(this.b, 2.0F)) {
          i = this.i;
          if (i < this.h)
            this.i = i + 1; 
        } else if (paramFloat2 <= -DensityUtils.a(this.b, 2.0F)) {
          i = this.i;
          if (i > 0) {
            this.i = i - 1;
            i = this.i;
          } 
        } 
        this.d.setStreamVolume(3, this.i, 0);
        i = this.i * 100 / this.h;
        this.a.setVisibility(0);
        this.f.setImageResource(R.drawable.live_volume_icon);
        this.g.setProgress(i);
      } 
    } else if (i == this.n) {
      if (this.j < 0.0F) {
        this.j = (paramActivity.getWindow().getAttributes()).screenBrightness;
        if (this.j <= 0.0F)
          this.j = 0.5F; 
        if (this.j < 0.01F)
          this.j = 0.01F; 
      } 
      WindowManager.LayoutParams layoutParams = paramActivity.getWindow().getAttributes();
      this.j = layoutParams.screenBrightness;
      if (Math.abs(paramFloat2) > Math.abs(paramFloat1))
        if (paramFloat2 >= DensityUtils.a(this.b, 2.0F)) {
          paramFloat1 = this.j;
          if (paramFloat1 < 1.0F)
            this.j = (float)(paramFloat1 + 0.05D); 
        } else if (paramFloat2 <= -DensityUtils.a(this.b, 2.0F)) {
          paramFloat1 = this.j;
          if (paramFloat1 > 0.0F)
            this.j = (float)(paramFloat1 - 0.05D); 
        }  
      layoutParams.screenBrightness = this.j;
      if (layoutParams.screenBrightness > 1.0F) {
        layoutParams.screenBrightness = 1.0F;
      } else if (layoutParams.screenBrightness < 0.01F) {
        layoutParams.screenBrightness = 0.01F;
      } 
      paramActivity.getWindow().setAttributes(layoutParams);
      this.a.setVisibility(0);
      this.f.setImageResource(R.drawable.live_brightness_icon);
      this.g.setProgress((int)(layoutParams.screenBrightness * 100.0F));
    } 
    this.k = false;
    b();
  }
  
  public void b() {
    AppInfo.n().removeCallbacks(this.e);
    AppInfo.n().postDelayed(this.e, 3000L);
  }
  
  public class DismissWindow implements Runnable {
    public DismissWindow(VolumeBrightnessView this$0) {}
    
    public void run() {
      this.a.a.setVisibility(8);
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\live_china\view\VolumeBrightnessView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */