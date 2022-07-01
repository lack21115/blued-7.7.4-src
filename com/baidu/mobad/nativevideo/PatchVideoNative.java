package com.baidu.mobad.nativevideo;

import android.content.Context;
import android.widget.RelativeLayout;
import com.baidu.mobad.feeds.NativeErrorCode;
import com.baidu.mobad.feeds.RequestParameters;
import com.baidu.mobads.h.b;
import com.baidu.mobads.utils.XAdSDKFoundationFacade;

public class PatchVideoNative {
  private Context a;
  
  private String b;
  
  private RelativeLayout c;
  
  private IPatchVideoNativeListener d;
  
  private a e;
  
  private b f;
  
  private e g;
  
  private boolean h;
  
  public PatchVideoNative(Context paramContext, String paramString, RelativeLayout paramRelativeLayout, IPatchVideoNativeListener paramIPatchVideoNativeListener) {
    this.a = paramContext;
    this.b = paramString;
    this.c = paramRelativeLayout;
    this.d = paramIPatchVideoNativeListener;
    this.e = new a(this.a, this.b, new b(this));
  }
  
  private void a() {
    XAdSDKFoundationFacade.getInstance().getCommonUtils().a(new c(this));
  }
  
  private void a(NativeErrorCode paramNativeErrorCode) {
    IPatchVideoNativeListener iPatchVideoNativeListener = this.d;
    if (iPatchVideoNativeListener != null)
      iPatchVideoNativeListener.onAdFailed(paramNativeErrorCode); 
  }
  
  private void b() {
    IPatchVideoNativeListener iPatchVideoNativeListener = this.d;
    if (iPatchVideoNativeListener != null)
      iPatchVideoNativeListener.playCompletion(); 
  }
  
  private void c() {
    IPatchVideoNativeListener iPatchVideoNativeListener = this.d;
    if (iPatchVideoNativeListener != null)
      iPatchVideoNativeListener.playError(); 
  }
  
  private void d() {
    IPatchVideoNativeListener iPatchVideoNativeListener = this.d;
    if (iPatchVideoNativeListener != null)
      iPatchVideoNativeListener.onAdShow(); 
  }
  
  public long getCurrentPosition() {
    b b1 = this.f;
    return (b1 != null) ? b1.a() : 0L;
  }
  
  public long getDuration() {
    b b1 = this.f;
    return (b1 != null) ? b1.b() : 0L;
  }
  
  public void requestAd(RequestParameters paramRequestParameters) {
    a a1 = this.e;
    if (a1 != null)
      a1.a(paramRequestParameters); 
  }
  
  public void setVideoMute(boolean paramBoolean) {
    this.h = paramBoolean;
    b b1 = this.f;
    if (b1 != null)
      b1.a(this.h); 
  }
  
  public static interface IPatchVideoNativeListener {
    void onAdClick();
    
    void onAdFailed(NativeErrorCode param1NativeErrorCode);
    
    void onAdLoad(String param1String);
    
    void onAdShow();
    
    void playCompletion();
    
    void playError();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\baidu\mobad\nativevideo\PatchVideoNative.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */