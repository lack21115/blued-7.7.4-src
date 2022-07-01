package com.blued.android.module.player.media.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.blued.android.core.utils.Log;
import com.blued.android.module.player.media.manager.BLVideoViewCache;
import com.blued.android.module.player.media.model.VideoPlayConfig;
import com.blued.android.module.player.media.utils.Utils;

public class AbsPlayerView extends LinearLayout {
  protected Context a;
  
  protected LayoutInflater b;
  
  protected View c;
  
  protected AbBaseVideoView d;
  
  protected View e;
  
  protected ImageView f;
  
  protected ImageView g;
  
  protected View h;
  
  protected FrameLayout i;
  
  protected VideoPlayConfig j;
  
  protected String k;
  
  protected BLVideoViewCache l;
  
  public AbsPlayerView(Context paramContext) {
    this(paramContext, null);
  }
  
  public AbsPlayerView(Context paramContext, AttributeSet paramAttributeSet) {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public AbsPlayerView(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
    this.a = paramContext;
    this.l = new BLVideoViewCache();
    this.l.a(Utils.a(paramContext));
  }
  
  private boolean b(VideoPlayConfig paramVideoPlayConfig) {
    boolean bool;
    if (paramVideoPlayConfig == null) {
      Log.c("AbsPlayerView", "  initPlayData mVideoPlayConfig == null!!!");
      return false;
    } 
    if (TextUtils.isEmpty(paramVideoPlayConfig.b)) {
      Log.c("AbsPlayerView", "  initPlayData videoUrl == null!!!");
      bool = false;
    } else {
      bool = true;
    } 
    null = bool;
    if (!paramVideoPlayConfig.j) {
      if (paramVideoPlayConfig.e != 0) {
        null = bool;
        return (paramVideoPlayConfig.f == 0) ? false : null;
      } 
    } else {
      return null;
    } 
    return false;
  }
  
  protected void a(AbBaseVideoView paramAbBaseVideoView) {
    if (paramAbBaseVideoView == null)
      return; 
    ViewParent viewParent = paramAbBaseVideoView.getParent();
    if (viewParent != null && viewParent instanceof ViewGroup) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("removeVideoView: ");
      stringBuilder.append(viewParent);
      Log.c("AbsPlayerView", stringBuilder.toString());
      ((ViewGroup)viewParent).removeView((View)paramAbBaseVideoView);
    } 
    this.f.setVisibility(0);
    Log.b("AbsPlayerView", "removeVideoView");
  }
  
  public void a(String paramString) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("preloadVideo: url = ");
    stringBuilder.append(paramString);
    Log.c("AbsPlayerView", stringBuilder.toString());
    if (this.j == null || TextUtils.isEmpty(paramString)) {
      Log.d("AbsPlayerView", "preloadVideo discard, mPlayConfig is null!");
      return;
    } 
    AbBaseVideoView abBaseVideoView = b(paramString);
    VideoPlayConfig videoPlayConfig = new VideoPlayConfig();
    videoPlayConfig.a(this.j);
    videoPlayConfig.b = paramString;
    abBaseVideoView.a(videoPlayConfig);
    abBaseVideoView.a(true);
    abBaseVideoView.a();
  }
  
  public boolean a() {
    return (b() && this.d.e());
  }
  
  protected boolean a(VideoPlayConfig paramVideoPlayConfig) {
    if (b(paramVideoPlayConfig)) {
      this.j = paramVideoPlayConfig;
      this.k = this.j.i;
      return true;
    } 
    return false;
  }
  
  protected AbBaseVideoView b(String paramString) {
    AbBaseVideoView abBaseVideoView2 = this.l.a(paramString);
    AbBaseVideoView abBaseVideoView1 = abBaseVideoView2;
    if (abBaseVideoView2 == null)
      abBaseVideoView1 = this.l.a(paramString, getContext()); 
    if (abBaseVideoView1.getParent() != null)
      ((ViewGroup)abBaseVideoView1.getParent()).removeView((View)abBaseVideoView1); 
    return abBaseVideoView1;
  }
  
  protected boolean b() {
    if (this.i.getChildCount() > 0) {
      AbBaseVideoView abBaseVideoView = this.d;
      if (abBaseVideoView != null && abBaseVideoView.getParent() != null && this.d.getParent().equals(this.i))
        return true; 
    } 
    return false;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\player\media\view\AbsPlayerView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */