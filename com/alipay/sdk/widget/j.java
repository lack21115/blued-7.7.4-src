package com.alipay.sdk.widget;

import android.app.Activity;
import android.content.Context;
import android.net.http.SslError;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.webkit.JsPromptResult;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.widget.ImageView;
import com.alipay.sdk.util.n;
import java.util.Map;
import org.json.JSONObject;

public class j extends g implements p.a, p.b, p.c {
  public static final String b = "alipayjsbridge://";
  
  public static final String c = "onBack";
  
  public static final String d = "setTitle";
  
  public static final String e = "onRefresh";
  
  public static final String f = "showBackButton";
  
  public static final String g = "onExit";
  
  public static final String h = "onLoadJs";
  
  public static final String i = "callNativeFunc";
  
  public static final String j = "back";
  
  public static final String k = "title";
  
  public static final String l = "refresh";
  
  public static final String m = "backButton";
  
  public static final String n = "refreshButton";
  
  public static final String o = "exit";
  
  public static final String p = "action";
  
  public static final String q = "pushWindow";
  
  public static final String r = "h5JsFuncCallback";
  
  private static final String s = "sdk_result_code:";
  
  private boolean t = true;
  
  private String u = "GET";
  
  private boolean v = false;
  
  private final com.alipay.sdk.sys.a w;
  
  private p x = null;
  
  private u y = new u();
  
  public j(Activity paramActivity, com.alipay.sdk.sys.a parama) {
    super(paramActivity);
    this.w = parama;
    c();
  }
  
  private void a(String paramString1, String paramString2, String paramString3) {
    ImageView imageView;
    JSONObject jSONObject = n.c(paramString3);
    if ("title".equals(paramString1) && jSONObject.has("title")) {
      this.x.getTitle().setText(jSONObject.optString("title", ""));
      return;
    } 
    if ("refresh".equals(paramString1)) {
      this.x.getWebView().reload();
      return;
    } 
    if ("back".equals(paramString1)) {
      e();
      return;
    } 
    boolean bool1 = "exit".equals(paramString1);
    boolean bool = false;
    byte b1 = 0;
    if (bool1) {
      com.alipay.sdk.app.j.a(jSONObject.optString("result", null));
      a(jSONObject.optBoolean("success", false));
      return;
    } 
    if ("backButton".equals(paramString1)) {
      bool1 = jSONObject.optBoolean("show", true);
      imageView = this.x.getBackButton();
      if (!bool1)
        b1 = 4; 
      imageView.setVisibility(b1);
      return;
    } 
    if ("refreshButton".equals(imageView)) {
      bool1 = jSONObject.optBoolean("show", true);
      imageView = this.x.getRefreshButton();
      if (bool1) {
        b1 = bool;
      } else {
        b1 = 4;
      } 
      imageView.setVisibility(b1);
      return;
    } 
    if ("pushWindow".equals(imageView) && jSONObject.optString("url", null) != null)
      b(jSONObject.optString("url"), jSONObject.optString("title", "")); 
  }
  
  private void a(boolean paramBoolean) {
    com.alipay.sdk.app.j.a(paramBoolean);
    this.a.finish();
  }
  
  private void b(String paramString) {
    ImageView imageView;
    Map map = n.a(this.w, paramString);
    if (paramString.startsWith("callNativeFunc")) {
      a((String)map.get("func"), (String)map.get("cbId"), (String)map.get("data"));
      return;
    } 
    if (paramString.startsWith("onBack")) {
      e();
      return;
    } 
    if (paramString.startsWith("setTitle") && map.containsKey("title")) {
      this.x.getTitle().setText((CharSequence)map.get("title"));
      return;
    } 
    if (paramString.startsWith("onRefresh")) {
      this.x.getWebView().reload();
      return;
    } 
    if (paramString.startsWith("showBackButton") && map.containsKey("bshow")) {
      byte b1;
      boolean bool = TextUtils.equals("true", (CharSequence)map.get("bshow"));
      imageView = this.x.getBackButton();
      if (bool) {
        b1 = 0;
      } else {
        b1 = 4;
      } 
      imageView.setVisibility(b1);
      return;
    } 
    if (imageView.startsWith("onExit")) {
      com.alipay.sdk.app.j.a((String)map.get("result"));
      a(TextUtils.equals("true", (CharSequence)map.get("bsucc")));
      return;
    } 
    if (imageView.startsWith("onLoadJs"))
      this.x.a("javascript:(function() {\n    if (window.AlipayJSBridge) {\n        return\n    }\n\n    function alipayjsbridgeFunc(url) {\n        var iframe = document.createElement(\"iframe\");\n        iframe.style.width = \"1px\";\n        iframe.style.height = \"1px\";\n        iframe.style.display = \"none\";\n        iframe.src = url;\n        document.body.appendChild(iframe);\n        setTimeout(function() {\n            document.body.removeChild(iframe)\n        }, 100)\n    }\n    window.alipayjsbridgeSetTitle = function(title) {\n        document.title = title;\n        alipayjsbridgeFunc(\"alipayjsbridge://setTitle?title=\" + encodeURIComponent(title))\n    };\n    window.alipayjsbridgeRefresh = function() {\n        alipayjsbridgeFunc(\"alipayjsbridge://onRefresh?\")\n    };\n    window.alipayjsbridgeBack = function() {\n        alipayjsbridgeFunc(\"alipayjsbridge://onBack?\")\n    };\n    window.alipayjsbridgeExit = function(bsucc) {\n        alipayjsbridgeFunc(\"alipayjsbridge://onExit?bsucc=\" + bsucc)\n    };\n    window.alipayjsbridgeShowBackButton = function(bshow) {\n        alipayjsbridgeFunc(\"alipayjsbridge://showBackButton?bshow=\" + bshow)\n    };\n    window.AlipayJSBridge = {\n        version: \"2.0\",\n        addListener: addListener,\n        hasListener: hasListener,\n        callListener: callListener,\n        callNativeFunc: callNativeFunc,\n        callBackFromNativeFunc: callBackFromNativeFunc\n    };\n    var uniqueId = 1;\n    var h5JsCallbackMap = {};\n\n    function iframeCall(paramStr) {\n        setTimeout(function() {\n        \tvar iframe = document.createElement(\"iframe\");\n        \tiframe.style.width = \"1px\";\n        \tiframe.style.height = \"1px\";\n        \tiframe.style.display = \"none\";\n        \tiframe.src = \"alipayjsbridge://callNativeFunc?\" + paramStr;\n        \tvar parent = document.body || document.documentElement;\n        \tparent.appendChild(iframe);\n        \tsetTimeout(function() {\n            \tparent.removeChild(iframe)\n        \t}, 0)\n        }, 0)\n    }\n\n    function callNativeFunc(nativeFuncName, data, h5JsCallback) {\n        var h5JsCallbackId = \"\";\n        if (h5JsCallback) {\n            h5JsCallbackId = \"cb_\" + (uniqueId++) + \"_\" + new Date().getTime();\n            h5JsCallbackMap[h5JsCallbackId] = h5JsCallback\n        }\n        var dataStr = \"\";\n        if (data) {\n            dataStr = encodeURIComponent(JSON.stringify(data))\n        }\n        var paramStr = \"func=\" + nativeFuncName + \"&cbId=\" + h5JsCallbackId + \"&data=\" + dataStr;\n        iframeCall(paramStr)\n    }\n\n    function callBackFromNativeFunc(h5JsCallbackId, data) {\n        var h5JsCallback = h5JsCallbackMap[h5JsCallbackId];\n        if (h5JsCallback) {\n            h5JsCallback(data);\n            delete h5JsCallbackMap[h5JsCallbackId]\n        }\n    }\n    var h5ListenerMap = {};\n\n    function addListener(jsFuncName, jsFunc) {\n        h5ListenerMap[jsFuncName] = jsFunc\n    }\n\n    function hasListener(jsFuncName) {\n        var jsFunc = h5ListenerMap[jsFuncName];\n        if (!jsFunc) {\n            return false\n        }\n        return true\n    }\n\n    function callListener(h5JsFuncName, data, nativeCallbackId) {\n        var responseCallback;\n        if (nativeCallbackId) {\n            responseCallback = function(responseData) {\n                var dataStr = \"\";\n                if (responseData) {\n                    dataStr = encodeURIComponent(JSON.stringify(responseData))\n                }\n                var paramStr = \"func=h5JsFuncCallback\" + \"&cbId=\" + nativeCallbackId + \"&data=\" + dataStr;\n                iframeCall(paramStr)\n            }\n        }\n        var h5JsFunc = h5ListenerMap[h5JsFuncName];\n        if (h5JsFunc) {\n            h5JsFunc(data, responseCallback)\n        } else if (h5JsFuncName == \"h5BackAction\") {\n            if (!window.alipayjsbridgeH5BackAction || !alipayjsbridgeH5BackAction()) {\n                var paramStr = \"func=back\";\n                iframeCall(paramStr)\n            }\n        } else {\n            console.log(\"AlipayJSBridge: no h5JsFunc \" + h5JsFuncName + data)\n        }\n    }\n    var event;\n    if (window.CustomEvent) {\n        event = new CustomEvent(\"alipayjsbridgeready\")\n    } else {\n        event = document.createEvent(\"Event\");\n        event.initEvent(\"alipayjsbridgeready\", true, true)\n    }\n    document.dispatchEvent(event);\n    setTimeout(excuteH5InitFuncs, 0);\n\n    function excuteH5InitFuncs() {\n        if (window.AlipayJSBridgeInitArray) {\n            var h5InitFuncs = window.AlipayJSBridgeInitArray;\n            delete window.AlipayJSBridgeInitArray;\n            for (var i = 0; i < h5InitFuncs.length; i++) {\n                try {\n                    h5InitFuncs[i](AlipayJSBridge)\n                } catch (e) {\n                    setTimeout(function() {\n                        throw e\n                    })\n                }\n            }\n        }\n    }\n})();\n"); 
  }
  
  private boolean b(String paramString1, String paramString2) {
    p p1 = this.x;
    try {
      this.x = new p((Context)this.a, this.w);
      this.x.setChromeProxy(this);
      this.x.setWebClientProxy(this);
      this.x.setWebEventProxy(this);
      if (!TextUtils.isEmpty(paramString2))
        this.x.getTitle().setText(paramString2); 
      this.v = true;
      this.y.a(p1);
      TranslateAnimation translateAnimation = new TranslateAnimation(1, 1.0F, 1, 0.0F, 1, 0.0F, 1, 0.0F);
      translateAnimation.setDuration(400L);
      translateAnimation.setFillAfter(false);
      translateAnimation.setAnimationListener(new m(this, p1, paramString1));
      this.x.setAnimation((Animation)translateAnimation);
      return true;
    } finally {
      paramString1 = null;
    } 
  }
  
  private boolean c() {
    try {
      this.x = new p((Context)this.a, this.w);
      this.x.setChromeProxy(this);
      this.x.setWebClientProxy(this);
      this.x.setWebEventProxy(this);
      addView((View)this.x);
      return true;
    } catch (Exception exception) {
      return false;
    } 
  }
  
  private void d() {
    if (this.t) {
      this.a.finish();
      return;
    } 
    this.x.a("javascript:window.AlipayJSBridge.callListener('h5BackAction');");
  }
  
  private void e() {
    WebView webView = this.x.getWebView();
    if (webView.canGoBack()) {
      webView.goBack();
      return;
    } 
    u u1 = this.y;
    if (u1 != null && !u1.b()) {
      f();
      return;
    } 
    a(false);
  }
  
  private boolean f() {
    if (this.y.b()) {
      this.a.finish();
      return true;
    } 
    this.v = true;
    p p1 = this.x;
    this.x = this.y.a();
    TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0F, 1, 1.0F, 1, 0.0F, 1, 0.0F);
    translateAnimation.setDuration(400L);
    translateAnimation.setFillAfter(false);
    translateAnimation.setAnimationListener(new l(this, p1));
    p1.setAnimation((Animation)translateAnimation);
    removeView((View)p1);
    addView((View)this.x);
    return true;
  }
  
  public void a() {
    this.x.a();
    this.y.c();
  }
  
  public void a(p paramp) {
    d();
  }
  
  public void a(p paramp, String paramString) {
    if (!paramString.startsWith("http") && !paramp.getUrl().endsWith(paramString))
      this.x.getTitle().setText(paramString); 
  }
  
  public void a(String paramString) {
    if ("POST".equals(this.u)) {
      this.x.a(paramString, (byte[])null);
      return;
    } 
    this.x.a(paramString);
  }
  
  public void a(String paramString1, String paramString2, boolean paramBoolean) {
    this.u = paramString2;
    this.x.getTitle().setText(paramString1);
    this.t = paramBoolean;
  }
  
  public boolean a(p paramp, int paramInt, String paramString1, String paramString2) {
    com.alipay.sdk.sys.a a1 = this.w;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("onReceivedError:");
    stringBuilder.append(paramString2);
    com.alipay.sdk.app.statistic.a.a(a1, "net", "SSLError", stringBuilder.toString());
    paramp.getRefreshButton().setVisibility(0);
    return false;
  }
  
  public boolean a(p paramp, SslErrorHandler paramSslErrorHandler, SslError paramSslError) {
    com.alipay.sdk.sys.a a1 = this.w;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("2-");
    stringBuilder.append(paramSslError);
    com.alipay.sdk.app.statistic.a.a(a1, "net", "SSLError", stringBuilder.toString());
    this.a.runOnUiThread(new n(this, paramSslErrorHandler));
    return true;
  }
  
  public boolean a(p paramp, String paramString1, String paramString2, String paramString3, JsPromptResult paramJsPromptResult) {
    if (paramString2.startsWith("<head>") && paramString2.contains("sdk_result_code:")) {
      k k = new k(this);
      this.a.runOnUiThread(k);
    } 
    paramJsPromptResult.cancel();
    return true;
  }
  
  public void b(p paramp) {
    paramp.getWebView().reload();
    paramp.getRefreshButton().setVisibility(4);
  }
  
  public boolean b() {
    if (!this.v)
      d(); 
    return true;
  }
  
  public boolean b(p paramp, String paramString) {
    if (TextUtils.isEmpty(paramString))
      return false; 
    if (paramString.startsWith("alipayjsbridge://")) {
      b(paramString.substring(17));
    } else if (TextUtils.equals(paramString, "sdklite://h5quit")) {
      a(false);
    } else if (paramString.startsWith("http://") || paramString.startsWith("https://")) {
      this.x.a(paramString);
      return true;
    } 
    return true;
  }
  
  public boolean c(p paramp, String paramString) {
    paramp.a("javascript:window.prompt('<head>'+document.getElementsByTagName('html')[0].innerHTML+'</head>');(function() {\n    if (window.AlipayJSBridge) {\n        return\n    }\n\n    function alipayjsbridgeFunc(url) {\n        var iframe = document.createElement(\"iframe\");\n        iframe.style.width = \"1px\";\n        iframe.style.height = \"1px\";\n        iframe.style.display = \"none\";\n        iframe.src = url;\n        document.body.appendChild(iframe);\n        setTimeout(function() {\n            document.body.removeChild(iframe)\n        }, 100)\n    }\n    window.alipayjsbridgeSetTitle = function(title) {\n        document.title = title;\n        alipayjsbridgeFunc(\"alipayjsbridge://setTitle?title=\" + encodeURIComponent(title))\n    };\n    window.alipayjsbridgeRefresh = function() {\n        alipayjsbridgeFunc(\"alipayjsbridge://onRefresh?\")\n    };\n    window.alipayjsbridgeBack = function() {\n        alipayjsbridgeFunc(\"alipayjsbridge://onBack?\")\n    };\n    window.alipayjsbridgeExit = function(bsucc) {\n        alipayjsbridgeFunc(\"alipayjsbridge://onExit?bsucc=\" + bsucc)\n    };\n    window.alipayjsbridgeShowBackButton = function(bshow) {\n        alipayjsbridgeFunc(\"alipayjsbridge://showBackButton?bshow=\" + bshow)\n    };\n    window.AlipayJSBridge = {\n        version: \"2.0\",\n        addListener: addListener,\n        hasListener: hasListener,\n        callListener: callListener,\n        callNativeFunc: callNativeFunc,\n        callBackFromNativeFunc: callBackFromNativeFunc\n    };\n    var uniqueId = 1;\n    var h5JsCallbackMap = {};\n\n    function iframeCall(paramStr) {\n        setTimeout(function() {\n        \tvar iframe = document.createElement(\"iframe\");\n        \tiframe.style.width = \"1px\";\n        \tiframe.style.height = \"1px\";\n        \tiframe.style.display = \"none\";\n        \tiframe.src = \"alipayjsbridge://callNativeFunc?\" + paramStr;\n        \tvar parent = document.body || document.documentElement;\n        \tparent.appendChild(iframe);\n        \tsetTimeout(function() {\n            \tparent.removeChild(iframe)\n        \t}, 0)\n        }, 0)\n    }\n\n    function callNativeFunc(nativeFuncName, data, h5JsCallback) {\n        var h5JsCallbackId = \"\";\n        if (h5JsCallback) {\n            h5JsCallbackId = \"cb_\" + (uniqueId++) + \"_\" + new Date().getTime();\n            h5JsCallbackMap[h5JsCallbackId] = h5JsCallback\n        }\n        var dataStr = \"\";\n        if (data) {\n            dataStr = encodeURIComponent(JSON.stringify(data))\n        }\n        var paramStr = \"func=\" + nativeFuncName + \"&cbId=\" + h5JsCallbackId + \"&data=\" + dataStr;\n        iframeCall(paramStr)\n    }\n\n    function callBackFromNativeFunc(h5JsCallbackId, data) {\n        var h5JsCallback = h5JsCallbackMap[h5JsCallbackId];\n        if (h5JsCallback) {\n            h5JsCallback(data);\n            delete h5JsCallbackMap[h5JsCallbackId]\n        }\n    }\n    var h5ListenerMap = {};\n\n    function addListener(jsFuncName, jsFunc) {\n        h5ListenerMap[jsFuncName] = jsFunc\n    }\n\n    function hasListener(jsFuncName) {\n        var jsFunc = h5ListenerMap[jsFuncName];\n        if (!jsFunc) {\n            return false\n        }\n        return true\n    }\n\n    function callListener(h5JsFuncName, data, nativeCallbackId) {\n        var responseCallback;\n        if (nativeCallbackId) {\n            responseCallback = function(responseData) {\n                var dataStr = \"\";\n                if (responseData) {\n                    dataStr = encodeURIComponent(JSON.stringify(responseData))\n                }\n                var paramStr = \"func=h5JsFuncCallback\" + \"&cbId=\" + nativeCallbackId + \"&data=\" + dataStr;\n                iframeCall(paramStr)\n            }\n        }\n        var h5JsFunc = h5ListenerMap[h5JsFuncName];\n        if (h5JsFunc) {\n            h5JsFunc(data, responseCallback)\n        } else if (h5JsFuncName == \"h5BackAction\") {\n            if (!window.alipayjsbridgeH5BackAction || !alipayjsbridgeH5BackAction()) {\n                var paramStr = \"func=back\";\n                iframeCall(paramStr)\n            }\n        } else {\n            console.log(\"AlipayJSBridge: no h5JsFunc \" + h5JsFuncName + data)\n        }\n    }\n    var event;\n    if (window.CustomEvent) {\n        event = new CustomEvent(\"alipayjsbridgeready\")\n    } else {\n        event = document.createEvent(\"Event\");\n        event.initEvent(\"alipayjsbridgeready\", true, true)\n    }\n    document.dispatchEvent(event);\n    setTimeout(excuteH5InitFuncs, 0);\n\n    function excuteH5InitFuncs() {\n        if (window.AlipayJSBridgeInitArray) {\n            var h5InitFuncs = window.AlipayJSBridgeInitArray;\n            delete window.AlipayJSBridgeInitArray;\n            for (var i = 0; i < h5InitFuncs.length; i++) {\n                try {\n                    h5InitFuncs[i](AlipayJSBridge)\n                } catch (e) {\n                    setTimeout(function() {\n                        throw e\n                    })\n                }\n            }\n        }\n    }\n})();\n;window.AlipayJSBridge.callListener('h5PageFinished');");
    paramp.getRefreshButton().setVisibility(0);
    return true;
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent) {
    return this.v ? true : super.onInterceptTouchEvent(paramMotionEvent);
  }
  
  abstract class a implements Animation.AnimationListener {
    private a(j this$0) {}
    
    public void onAnimationEnd(Animation param1Animation) {}
    
    public void onAnimationRepeat(Animation param1Animation) {}
    
    public void onAnimationStart(Animation param1Animation) {}
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\alipay\sdk\widget\j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */