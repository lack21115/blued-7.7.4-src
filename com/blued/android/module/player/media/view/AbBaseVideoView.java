package com.blued.android.module.player.media.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.blued.android.core.AppInfo;
import com.blued.android.core.utils.Log;
import com.blued.android.module.player.media.model.VideoPlayConfig;
import com.blued.android.module.player.media.utils.Utils;

public abstract class AbBaseVideoView extends FrameLayout {
  public static String a = "PLVideoPageView";
  
  protected String b;
  
  protected VideoPlayConfig c;
  
  protected String d;
  
  protected OnVideoStatusListener e;
  
  protected PLVideoPageView.OnSeekListener f;
  
  public AbBaseVideoView(Context paramContext, AttributeSet paramAttributeSet) {
    super(paramContext, paramAttributeSet);
  }
  
  public AbBaseVideoView(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public abstract void a();
  
  public void a(float paramFloat1, float paramFloat2) {}
  
  protected void a(int paramInt1, int paramInt2, View paramView) {
    AppInfo.n().post(new Runnable(this, paramInt1, paramInt2, paramView) {
          public void run() {
            if (this.d.c == null)
              return; 
            String str = AbBaseVideoView.a;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("onVideoSizeChanged: width = ");
            stringBuilder.append(this.a);
            stringBuilder.append(", height = ");
            stringBuilder.append(this.b);
            Log.c(str, stringBuilder.toString());
            str = AbBaseVideoView.a;
            stringBuilder = new StringBuilder();
            stringBuilder.append("onVideoSizeChanged: mwidth = ");
            stringBuilder.append(this.d.c.e);
            stringBuilder.append(", mHeight = ");
            stringBuilder.append(this.d.c.f);
            Log.c(str, stringBuilder.toString());
            if (this.a != 0)
              this.d.c.a(this.a); 
            if (this.b != 0)
              this.d.c.b(this.b); 
            if (this.d.c.e == 0)
              this.d.c.e = this.d.c.a(); 
            if (this.d.c.f == 0)
              this.d.c.f = this.d.c.b(); 
            if (this.d.c.j) {
              Utils.a(this.d.c);
            } else {
              Utils.b(this.d.c);
            } 
            if (this.a != 0 && this.b != 0 && this.d.c.e != 0 && this.d.c.f != 0) {
              str = AbBaseVideoView.a;
              stringBuilder = new StringBuilder();
              stringBuilder.append("onVideoSizeChanged: mwidth = ");
              stringBuilder.append(this.d.c.e);
              stringBuilder.append(", mHeight = ");
              stringBuilder.append(this.d.c.f);
              Log.c(str, stringBuilder.toString());
              FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.d.c.e, this.d.c.f);
              layoutParams.gravity = 17;
              this.c.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
              if (this.d.e != null)
                this.d.e.a(this.d.c.e, this.d.c.f); 
            } 
          }
        });
  }
  
  public abstract void a(long paramLong);
  
  public void a(VideoPlayConfig paramVideoPlayConfig) {
    this.c = paramVideoPlayConfig;
  }
  
  public abstract void a(boolean paramBoolean);
  
  public abstract void b();
  
  public void c() {
    if (this.e != null)
      this.e = null; 
    if (this.f != null)
      this.f = null; 
  }
  
  public abstract void d();
  
  public boolean e() {
    return false;
  }
  
  public abstract void f();
  
  public long getCurrentPosition() {
    return -1L;
  }
  
  public long getDuration() {
    return -1L;
  }
  
  public String getPlayUrl() {
    return this.d;
  }
  
  public String getSetUrl() {
    VideoPlayConfig videoPlayConfig = this.c;
    return (videoPlayConfig != null) ? videoPlayConfig.b : "";
  }
  
  public abstract void setMute(boolean paramBoolean);
  
  public void setOnVideoStatusListener(OnVideoStatusListener paramOnVideoStatusListener) {
    this.e = paramOnVideoStatusListener;
  }
  
  public void setSeekListener(PLVideoPageView.OnSeekListener paramOnSeekListener) {
    this.f = paramOnSeekListener;
  }
  
  public static interface OnVideoStatusListener {
    void a();
    
    void a(int param1Int1, int param1Int2);
    
    void b();
    
    void c();
    
    void d();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\player\media\view\AbBaseVideoView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */