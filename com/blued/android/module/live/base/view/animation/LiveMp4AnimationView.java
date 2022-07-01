package com.blued.android.module.live.base.view.animation;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.module.video_gift.AlphaVideoGiftView;
import com.blued.android.module.video_gift.FitViewHelper;

public class LiveMp4AnimationView extends BaseLiveAnimationView {
  private String b;
  
  private Context c;
  
  private AlphaVideoGiftView d;
  
  public LiveMp4AnimationView(Context paramContext, String paramString, LiveAnimationViewFactory.ScaleType paramScaleType) {
    this.b = paramString;
    this.c = paramContext;
    this.d = new AlphaVideoGiftView(this.c, null);
    if (paramScaleType == LiveAnimationViewFactory.ScaleType.b) {
      this.d.setScaleType(FitViewHelper.ScaleType.a);
      return;
    } 
    if (paramScaleType == LiveAnimationViewFactory.ScaleType.c) {
      this.d.setScaleType(FitViewHelper.ScaleType.b);
      return;
    } 
    this.d.setScaleType(FitViewHelper.ScaleType.d);
  }
  
  public View a() {
    return (View)this.d;
  }
  
  public void a(IRequestHost paramIRequestHost) {
    Log.v("drb", "调用mp4播放接口 start()");
    this.d.setOnVideoStateChangedListener(new AlphaVideoGiftView.OnVideoStateChangedListener(this) {
          public void a() {
            Log.v("drb", "AlphaVideoGiftView onLoadingStarted");
            if (this.a.a != null)
              this.a.a.a(); 
          }
          
          public void b() {
            Log.v("drb", "AlphaVideoGiftView onEnded");
            if (this.a.a != null)
              this.a.a.b(); 
          }
        });
    if (!TextUtils.isEmpty(this.b) && this.b.contains("http")) {
      this.d.a(this.c, paramIRequestHost, this.b);
      return;
    } 
    this.d.a(this.c, this.b);
  }
  
  public void a(String paramString) {
    this.b = paramString;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\live\base\view\animation\LiveMp4AnimationView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */