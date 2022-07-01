package com.bytedance.sdk.openadsdk.component.splash;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView;
import com.bytedance.sdk.openadsdk.core.widget.TTCountdownView;
import com.bytedance.sdk.openadsdk.core.widget.gif.GifView;
import com.bytedance.sdk.openadsdk.utils.ab;
import com.bytedance.sdk.openadsdk.utils.ai;
import com.bytedance.sdk.openadsdk.utils.y;

public class TsView extends FrameLayout {
  private final Context a;
  
  private GifView b;
  
  private TTCountdownView c;
  
  private ImageView d;
  
  private FrameLayout e;
  
  private FrameLayout f;
  
  private TextView g;
  
  private NativeExpressView h;
  
  public TsView(Context paramContext) {
    super(paramContext);
    this.a = paramContext;
    a();
  }
  
  private void a() {
    setLayoutParams((ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, -1));
    Context context = this.a;
    View view = inflate(context, ab.f(context, "tt_splash_view"), (ViewGroup)this);
    this.b = (GifView)view.findViewById(ab.e(this.a, "tt_splash_ad_gif"));
    this.c = (TTCountdownView)view.findViewById(ab.e(this.a, "tt_splash_skip_btn"));
    this.d = (ImageView)view.findViewById(ab.e(this.a, "tt_splash_video_ad_mute"));
    this.e = (FrameLayout)view.findViewById(ab.e(this.a, "tt_splash_video_container"));
    this.f = (FrameLayout)view.findViewById(ab.e(this.a, "tt_splash_express_container"));
    this.g = (TextView)view.findViewById(ab.e(this.a, "tt_ad_logo"));
  }
  
  TTCountdownView getCountDownView() {
    return this.c;
  }
  
  View getDislikeView() {
    return (View)this.c;
  }
  
  FrameLayout getVideoContainer() {
    return this.e;
  }
  
  void setAdlogoViewVisibility(int paramInt) {
    ai.a((View)this.g, paramInt);
  }
  
  void setCountDownTime(int paramInt) {
    TTCountdownView tTCountdownView = this.c;
    if (tTCountdownView != null)
      tTCountdownView.setCountDownTime(paramInt); 
  }
  
  void setDrawable(Drawable paramDrawable) {
    this.b.setScaleType(ImageView.ScaleType.FIT_XY);
    this.b.setImageDrawable(paramDrawable);
  }
  
  void setExpressView(NativeExpressView paramNativeExpressView) {
    if (paramNativeExpressView == null)
      return; 
    this.h = paramNativeExpressView;
    this.f.addView((View)this.h);
    setExpressViewVisibility(0);
    setVideoViewVisibility(8);
    setImageViewVisibility(8);
  }
  
  void setExpressViewVisibility(int paramInt) {
    ai.a((View)this.f, paramInt);
  }
  
  void setGifView(byte[] paramArrayOfbyte) {
    this.b.setScaleType(ImageView.ScaleType.CENTER_CROP);
    this.b.a(paramArrayOfbyte, false);
  }
  
  void setImageViewVisibility(int paramInt) {
    ai.a((View)this.b, paramInt);
  }
  
  public final void setOnClickListener(View.OnClickListener paramOnClickListener) {
    y.a("不允许在Splash广告中注册OnClickListener");
  }
  
  final void setOnClickListenerInternal(View.OnClickListener paramOnClickListener) {
    super.setOnClickListener(paramOnClickListener);
  }
  
  public final void setOnTouchListener(View.OnTouchListener paramOnTouchListener) {
    y.a("不允许在Splash广告中注册OnTouchListener");
  }
  
  final void setOnTouchListenerInternal(View.OnTouchListener paramOnTouchListener) {
    super.setOnTouchListener(paramOnTouchListener);
  }
  
  void setSkipIconVisibility(int paramInt) {
    ai.a((View)this.c, paramInt);
  }
  
  final void setSkipListener(View.OnClickListener paramOnClickListener) {
    TTCountdownView tTCountdownView = this.c;
    if (tTCountdownView != null)
      tTCountdownView.setOnClickListener(paramOnClickListener); 
  }
  
  void setVideoViewVisibility(int paramInt) {
    ai.a((View)this.e, paramInt);
    ai.a((View)this.d, paramInt);
  }
  
  final void setVoiceViewImageResource(int paramInt) {
    ImageView imageView = this.d;
    if (imageView != null)
      imageView.setImageResource(paramInt); 
  }
  
  final void setVoiceViewListener(View.OnClickListener paramOnClickListener) {
    ImageView imageView = this.d;
    if (imageView != null)
      imageView.setOnClickListener(paramOnClickListener); 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\openadsdk\component\splash\TsView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */