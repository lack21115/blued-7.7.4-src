package com.baidu.mobads.component;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.baidu.mobad.feeds.XAdNativeResponse;
import com.baidu.mobads.f.b;
import com.baidu.mobads.q;
import com.baidu.mobads.utils.d;
import dalvik.system.DexClassLoader;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class FeedPortraitVideoView extends RelativeLayout {
  private static final String PLAY_END = "playCompletion";
  
  private static final String PLAY_ERROR = "playError";
  
  private static final String PLAY_START = "playRenderingStart";
  
  private static final String TAG = "FeedPortraitVideoView";
  
  private View mAdView;
  
  private IFeedPortraitListener mFeedVideoListener;
  
  private DexClassLoader mLoader;
  
  private String mRemoteClassName = "KsFUVkW3hvh15S0DYx76RpROGGQW+8runZ3lnHDrYi9hfV1Uns7ZF3eKbMRKGO2s";
  
  private Context mViewContext;
  
  public FeedPortraitVideoView(Context paramContext) {
    super(paramContext);
    init(paramContext);
  }
  
  public FeedPortraitVideoView(Context paramContext, AttributeSet paramAttributeSet) {
    super(paramContext, paramAttributeSet);
    init(paramContext);
  }
  
  public FeedPortraitVideoView(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
    init(paramContext);
  }
  
  private void init(Context paramContext) {
    this.mViewContext = paramContext;
    paramContext = this.mViewContext;
    this.mLoader = b.d();
    if (this.mLoader == null)
      this.mLoader = q.a(this.mViewContext); 
    this.mAdView = (View)q.a(d.a(this.mRemoteClassName), (ClassLoader)this.mLoader, new Class[] { Context.class }, new Object[] { paramContext });
    View view = this.mAdView;
    if (view != null)
      addView(view, (ViewGroup.LayoutParams)new RelativeLayout.LayoutParams(-1, -1)); 
  }
  
  public long getCurrentPosition() {
    return (this.mAdView != null) ? ((Long)q.a(d.a(this.mRemoteClassName), this.mAdView, (ClassLoader)this.mLoader, "getCurrentPosition", new Class[0], new Object[0])).longValue() : 0L;
  }
  
  public long getDuration() {
    return (this.mAdView != null) ? ((Long)q.a(d.a(this.mRemoteClassName), this.mAdView, (ClassLoader)this.mLoader, "getDuration", new Class[0], new Object[0])).longValue() : 0L;
  }
  
  public boolean isPlaying() {
    return (this.mAdView != null) ? ((Boolean)q.a(d.a(this.mRemoteClassName), this.mAdView, (ClassLoader)this.mLoader, "isPlaying", new Class[0], new Object[0])).booleanValue() : false;
  }
  
  public boolean isShowEndFrame() {
    return (this.mAdView != null) ? ((Boolean)q.a(d.a(this.mRemoteClassName), this.mAdView, (ClassLoader)this.mLoader, "isShowEndFrame", new Class[0], new Object[0])).booleanValue() : false;
  }
  
  public void pause() {
    if (this.mAdView != null)
      q.a(d.a(this.mRemoteClassName), this.mAdView, (ClassLoader)this.mLoader, "pause", new Class[0], new Object[0]); 
  }
  
  public void play() {
    if (this.mAdView != null)
      q.a(d.a(this.mRemoteClassName), this.mAdView, (ClassLoader)this.mLoader, "play", new Class[0], new Object[0]); 
  }
  
  public void resume() {
    if (this.mAdView != null)
      q.a(d.a(this.mRemoteClassName), this.mAdView, (ClassLoader)this.mLoader, "resume", new Class[0], new Object[0]); 
  }
  
  public void setAdData(XAdNativeResponse paramXAdNativeResponse) {
    if (paramXAdNativeResponse == null)
      return; 
    if (this.mAdView != null)
      q.a(d.a(this.mRemoteClassName), this.mAdView, (ClassLoader)this.mLoader, "setAdData", new Class[] { Object.class }, new Object[] { paramXAdNativeResponse }); 
    showNormalPic(paramXAdNativeResponse);
  }
  
  public void setCanClickVideo(boolean paramBoolean) {
    if (this.mAdView != null)
      q.a(d.a(this.mRemoteClassName), this.mAdView, (ClassLoader)this.mLoader, "setCanClickVideo", new Class[] { boolean.class }, new Object[] { Boolean.valueOf(paramBoolean) }); 
  }
  
  public void setFeedPortraitListener(IFeedPortraitListener paramIFeedPortraitListener) {
    this.mFeedVideoListener = paramIFeedPortraitListener;
    try {
      Class clazz = q.a("com.component.feed.IFeedPortraitListener", (ClassLoader)this.mLoader);
      ClassLoader classLoader = clazz.getClassLoader();
      a a = new a(this);
      Object object = Proxy.newProxyInstance(classLoader, new Class[] { clazz }, a);
      return;
    } finally {
      paramIFeedPortraitListener = null;
    } 
  }
  
  public void setVideoMute(boolean paramBoolean) {
    if (this.mAdView != null)
      q.a(d.a(this.mRemoteClassName), this.mAdView, (ClassLoader)this.mLoader, "setVideoMute", new Class[] { boolean.class }, new Object[] { Boolean.valueOf(paramBoolean) }); 
  }
  
  public void showNormalPic(XAdNativeResponse paramXAdNativeResponse) {
    if (paramXAdNativeResponse == null)
      return; 
    if (this.mAdView != null)
      q.a(d.a(this.mRemoteClassName), this.mAdView, (ClassLoader)this.mLoader, "showNormalPic", new Class[] { Object.class }, new Object[] { paramXAdNativeResponse }); 
  }
  
  public void stop() {
    if (this.mAdView != null)
      q.a(d.a(this.mRemoteClassName), this.mAdView, (ClassLoader)this.mLoader, "stop", new Class[0], new Object[0]); 
  }
  
  class a implements InvocationHandler {
    a(FeedPortraitVideoView this$0) {}
    
    public Object invoke(Object param1Object, Method param1Method, Object[] param1ArrayOfObject) {
      param1Object = param1Method.getName();
      if (TextUtils.isEmpty((CharSequence)param1Object))
        return null; 
      if (param1Object.equals("playCompletion")) {
        if (this.a.mFeedVideoListener != null) {
          this.a.mFeedVideoListener.playCompletion();
          return null;
        } 
      } else if (param1Object.equals("playError")) {
        if (this.a.mFeedVideoListener != null) {
          this.a.mFeedVideoListener.playError();
          return null;
        } 
      } else if (param1Object.equals("playRenderingStart") && this.a.mFeedVideoListener != null) {
        this.a.mFeedVideoListener.playRenderingStart();
      } 
      return null;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\baidu\mobads\component\FeedPortraitVideoView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */