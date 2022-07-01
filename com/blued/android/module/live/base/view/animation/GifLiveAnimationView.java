package com.blued.android.module.live.base.view.animation;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;

public class GifLiveAnimationView extends BaseLiveAnimationView {
  private String b;
  
  private Context c;
  
  private ImageView d;
  
  public GifLiveAnimationView(Context paramContext, String paramString, boolean paramBoolean) {
    ImageView.ScaleType scaleType;
    this.b = paramString;
    this.c = paramContext;
    this.d = new ImageView(this.c);
    ImageView imageView = this.d;
    if (paramBoolean) {
      scaleType = ImageView.ScaleType.CENTER_CROP;
    } else {
      scaleType = ImageView.ScaleType.FIT_CENTER;
    } 
    imageView.setScaleType(scaleType);
  }
  
  public View a() {
    return (View)this.d;
  }
  
  public void a(IRequestHost paramIRequestHost) {
    Log.v("drb", "调用gif播放接口 start()");
    ImageLoader.a(paramIRequestHost, this.b).h().a(new ImageLoader.OnAnimationStateListener(this) {
          public void a() {
            Log.v("drb", "GifLiveAnimationView onLoadingStarted");
            if (this.a.a != null)
              this.a.a.a(); 
          }
          
          public void b() {
            Log.v("drb", "GifLiveAnimationView onLoadingFailed");
            if (this.a.a != null)
              this.a.a.b(); 
          }
        }).a(this.d);
  }
  
  public void a(String paramString) {
    this.b = paramString;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\live\base\view\animation\GifLiveAnimationView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */