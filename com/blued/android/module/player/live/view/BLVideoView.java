package com.blued.android.module.player.live.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.blued.android.module.player.media.model.VideoPlayConfig;

@Deprecated
public class BLVideoView extends FrameLayout {
  public static boolean a = false;
  
  private AbsVideoView b;
  
  private Context c;
  
  public BLVideoView(Context paramContext) {
    super(paramContext);
    a(paramContext);
  }
  
  public BLVideoView(Context paramContext, AttributeSet paramAttributeSet) {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  public BLVideoView(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext);
  }
  
  public BLVideoView(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2) {
    super(paramContext, paramAttributeSet, paramInt1, paramInt2);
    a(paramContext);
  }
  
  private void d() {
    if (this.b == null) {
      if (VideoPlayConfig.c() == 1)
        this.b = new BLVideoViewTX(this.c); 
      FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
      this.b.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
      if (getChildCount() > 0)
        removeAllViews(); 
      addView((View)this.b);
    } 
  }
  
  public void a() {
    AbsVideoView absVideoView = this.b;
    if (absVideoView != null)
      absVideoView.a(); 
  }
  
  public void a(int paramInt1, int paramInt2) {
    AbsVideoView absVideoView = this.b;
    if (absVideoView != null)
      absVideoView.a(paramInt1, paramInt2); 
  }
  
  public void a(Context paramContext) {
    this.c = paramContext;
  }
  
  public void a(View paramView) {
    d();
    AbsVideoView absVideoView = this.b;
    if (absVideoView != null)
      absVideoView.a(paramView); 
  }
  
  public void b() {
    AbsVideoView absVideoView = this.b;
    if (absVideoView != null)
      absVideoView.b(); 
  }
  
  public void c() {
    AbsVideoView absVideoView = this.b;
    if (absVideoView != null) {
      absVideoView.c();
      this.b = null;
    } 
  }
  
  public void setVideoPath(String paramString) {
    AbsVideoView absVideoView = this.b;
    if (absVideoView != null)
      absVideoView.setVideoPath(paramString); 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\player\live\view\BLVideoView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */