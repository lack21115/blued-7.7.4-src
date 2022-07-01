package com.bytedance.sdk.openadsdk.core.widget.webview;

import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebViewClient;
import com.bytedance.sdk.openadsdk.core.aa;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.utils.t;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class d {
  private static final byte[] c = new byte[0];
  
  private static int d = 10;
  
  private static int e = 3;
  
  private static volatile d g;
  
  private List<WeakReference<SSWebView>> a = new ArrayList<WeakReference<SSWebView>>();
  
  private List<WeakReference<SSWebView>> b = new ArrayList<WeakReference<SSWebView>>();
  
  private final AtomicBoolean f = new AtomicBoolean(false);
  
  private d() {
    this.a = new ArrayList<WeakReference<SSWebView>>();
    this.b = new ArrayList<WeakReference<SSWebView>>();
  }
  
  public static d a() {
    // Byte code:
    //   0: getstatic com/bytedance/sdk/openadsdk/core/widget/webview/d.g : Lcom/bytedance/sdk/openadsdk/core/widget/webview/d;
    //   3: ifnonnull -> 37
    //   6: ldc com/bytedance/sdk/openadsdk/core/widget/webview/d
    //   8: monitorenter
    //   9: getstatic com/bytedance/sdk/openadsdk/core/widget/webview/d.g : Lcom/bytedance/sdk/openadsdk/core/widget/webview/d;
    //   12: ifnonnull -> 25
    //   15: new com/bytedance/sdk/openadsdk/core/widget/webview/d
    //   18: dup
    //   19: invokespecial <init> : ()V
    //   22: putstatic com/bytedance/sdk/openadsdk/core/widget/webview/d.g : Lcom/bytedance/sdk/openadsdk/core/widget/webview/d;
    //   25: ldc com/bytedance/sdk/openadsdk/core/widget/webview/d
    //   27: monitorexit
    //   28: goto -> 37
    //   31: astore_0
    //   32: ldc com/bytedance/sdk/openadsdk/core/widget/webview/d
    //   34: monitorexit
    //   35: aload_0
    //   36: athrow
    //   37: getstatic com/bytedance/sdk/openadsdk/core/widget/webview/d.g : Lcom/bytedance/sdk/openadsdk/core/widget/webview/d;
    //   40: areturn
    // Exception table:
    //   from	to	target	type
    //   9	25	31	finally
    //   25	28	31	finally
    //   32	35	31	finally
  }
  
  private void d() {
    for (int i = 0; i < e; i++) {
      SSWebView sSWebView = new SSWebView(o.a());
      sSWebView.loadUrl("about:blank");
      this.a.add(new WeakReference<SSWebView>(sSWebView));
    } 
  }
  
  public void a(ViewGroup paramViewGroup, WeakReference<SSWebView> paramWeakReference, boolean paramBoolean) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("===start removeWebView available:");
    stringBuilder.append(this.a.size());
    stringBuilder.append(" ,inuse:");
    stringBuilder.append(this.b.size());
    t.e("webviewpool", stringBuilder.toString());
    if (paramBoolean && paramWeakReference != null) {
      if (paramWeakReference.get() == null)
        return; 
      try {
        SSWebView sSWebView = paramWeakReference.get();
        paramViewGroup.removeView((View)sSWebView);
        sSWebView.loadUrl("");
        sSWebView.stopLoading();
        sSWebView.setWebChromeClient((WebChromeClient)null);
        sSWebView.setWebViewClient((WebViewClient)null);
        sSWebView.clearCache(true);
        sSWebView.clearHistory();
        sSWebView.getSettings().setJavaScriptEnabled(true);
        sSWebView.getSettings().setCacheMode(2);
        sSWebView.getSettings().setAppCacheEnabled(false);
        sSWebView.getSettings().setSupportZoom(false);
        sSWebView.getSettings().setUseWideViewPort(true);
        sSWebView.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        sSWebView.getSettings().setDomStorageEnabled(true);
        sSWebView.getSettings().setBuiltInZoomControls(false);
        sSWebView.getSettings().setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NORMAL);
        sSWebView.getSettings().setLoadWithOverviewMode(false);
        sSWebView.getSettings().setUserAgentString("android_client");
        sSWebView.getSettings().setDefaultTextEncodingName("UTF-8");
        sSWebView.getSettings().setDefaultFontSize(16);
        aa.a(o.a(), sSWebView);
        aa.a(sSWebView);
        synchronized (c) {
          this.b.remove(paramWeakReference);
          if (this.a.size() < e) {
            SSWebView sSWebView1 = new SSWebView(o.a());
            sSWebView1.loadUrl("about:blank");
            WeakReference<SSWebView> weakReference = new WeakReference<SSWebView>(sSWebView1);
            this.a.add(weakReference);
          } 
        } 
      } catch (Exception exception) {}
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append("===end removeWebView available:");
      stringBuilder1.append(this.a.size());
      stringBuilder1.append(" ,inuse:");
      stringBuilder1.append(this.b.size());
      t.e("webviewpool", stringBuilder1.toString());
    } 
  }
  
  public void b() {
    if (this.f.getAndSet(true))
      return; 
    if (Looper.myLooper() == Looper.getMainLooper()) {
      d();
      return;
    } 
    (new Handler(Looper.getMainLooper())).post(new Runnable(this) {
          public void run() {
            d.a(this.a);
          }
        });
  }
  
  public WeakReference<SSWebView> c() {
    null = new StringBuilder();
    null.append("===start getWebView available:");
    null.append(this.a.size());
    null.append(" ,inuse:");
    null.append(this.b.size());
    t.e("webviewpool", null.toString());
    synchronized (c) {
      WeakReference<SSWebView> weakReference;
      if (this.a.size() > 0 && this.a.get(0) != null) {
        weakReference = this.a.get(0);
        if (weakReference.get() != null) {
          this.a.remove(0);
          this.b.add(weakReference);
        } else {
          this.a.remove(0);
          weakReference = new WeakReference<SSWebView>(new SSWebView(o.a()));
          this.b.add(weakReference);
        } 
      } else {
        weakReference = new WeakReference<SSWebView>(new SSWebView(o.a()));
        this.b.add(weakReference);
      } 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("===end getWebView available:");
      stringBuilder.append(this.a.size());
      stringBuilder.append(" ,inuse:");
      stringBuilder.append(this.b.size());
      t.e("webviewpool", stringBuilder.toString());
      ((SSWebView)weakReference.get()).loadUrl("about:blank");
    } 
    /* monitor exit ClassFileLocalVariableReferenceExpression{type=ObjectType{java/lang/Object}, name=SYNTHETIC_LOCAL_VARIABLE_2} */
    return (WeakReference<SSWebView>)SYNTHETIC_LOCAL_VARIABLE_1;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\openadsdk\core\widget\webview\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */