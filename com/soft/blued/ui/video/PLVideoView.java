package com.soft.blued.ui.video;

import android.content.Context;
import android.media.MediaPlayer;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.VideoView;
import com.soft.blued.utils.Logger;
import java.lang.ref.WeakReference;

public class PLVideoView extends LinearLayout implements PLViewInterface {
  public static WeakReference<PLVideoView> b;
  
  public String a = "PLVideoView";
  
  private Context c;
  
  private LayoutInflater d;
  
  private View e;
  
  private VideoView f;
  
  public PLVideoView(Context paramContext, AttributeSet paramAttributeSet) {
    super(paramContext, paramAttributeSet);
    this.c = paramContext;
    b();
  }
  
  private void b() {
    this.d = LayoutInflater.from(this.c);
    this.e = this.d.inflate(2131494026, (ViewGroup)this);
    this.f = (VideoView)this.e.findViewById(2131299485);
  }
  
  public void a() {
    Logger.b(this.a, new Object[] { "start" });
    VideoView videoView = this.f;
    if (videoView != null)
      videoView.start(); 
  }
  
  protected void onFinishInflate() {
    super.onFinishInflate();
  }
  
  public void setAutoPlay(boolean paramBoolean) {}
  
  public void setPauseDrop(boolean paramBoolean) {}
  
  public void setVolumeProgress(int paramInt) {}
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\video\PLVideoView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */