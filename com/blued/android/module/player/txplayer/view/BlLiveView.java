package com.blued.android.module.player.txplayer.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.blued.android.module.player.media.model.VideoPlayConfig;
import com.tencent.rtmp.ui.TXCloudVideoView;

public class BlLiveView extends FrameLayout {
  private Context a;
  
  public BlLiveView(Context paramContext) {
    super(paramContext);
    this.a = paramContext;
  }
  
  public BlLiveView(Context paramContext, AttributeSet paramAttributeSet) {
    super(paramContext, paramAttributeSet);
    this.a = paramContext;
  }
  
  public BlLiveView(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
    this.a = paramContext;
  }
  
  public BlLiveView(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2) {
    super(paramContext, paramAttributeSet, paramInt1, paramInt2);
    this.a = paramContext;
  }
  
  public void a() {
    if (getChildCount() > 0) {
      View view = getChildAt(0);
      if (VideoPlayConfig.c() == 1 && view instanceof SurfaceView) {
        removeAllViews();
      } else {
        return;
      } 
    } 
    if (VideoPlayConfig.c() == 1) {
      TXCloudVideoView tXCloudVideoView = new TXCloudVideoView(this.a);
      tXCloudVideoView.setLayoutParams((ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, -1));
      addView((View)tXCloudVideoView);
      return;
    } 
    SurfaceView surfaceView = new SurfaceView(this.a);
    surfaceView.setLayoutParams((ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, -1));
    addView((View)surfaceView);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\player\txplayer\view\BlLiveView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */