package com.qq.e.comm.plugin.ab.f;

import com.qq.e.comm.plugin.ab.c.f;
import com.qq.e.comm.plugin.y.d;
import com.qq.e.comm.plugin.y.u;
import com.qq.e.comm.util.GDTLogger;
import com.tencent.smtt.export.external.interfaces.GeolocationPermissionsCallback;
import com.tencent.smtt.export.external.interfaces.JsPromptResult;
import com.tencent.smtt.sdk.WebChromeClient;
import com.tencent.smtt.sdk.WebView;

public class h extends WebChromeClient {
  private e a;
  
  public void a(e parame) {
    this.a = parame;
  }
  
  public void onGeolocationPermissionsShowPrompt(String paramString, GeolocationPermissionsCallback paramGeolocationPermissionsCallback) {
    super.onGeolocationPermissionsShowPrompt(paramString, paramGeolocationPermissionsCallback);
    paramGeolocationPermissionsCallback.invoke(paramString, true, false);
  }
  
  public boolean onJsPrompt(WebView paramWebView, String paramString1, String paramString2, String paramString3, JsPromptResult paramJsPromptResult) {
    e e1 = this.a;
    if (e1 == null) {
      u.a(100292, 2, null, (new d()).a("msg", paramString2));
    } else {
      f<String> f = e1.a(paramString2);
      if (f.d()) {
        paramJsPromptResult.confirm((String)f.a());
        return true;
      } 
      if (f.c() == 1000) {
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append("message:");
        stringBuilder1.append(f.b());
        stringBuilder1.append(",code:");
        stringBuilder1.append(f.c());
        paramJsPromptResult.confirm(stringBuilder1.toString());
        GDTLogger.i(String.format("failed message: %s --> (%d,%s)", new Object[] { paramString2, Integer.valueOf(f.c()), f.b() }));
        return true;
      } 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("message:");
      stringBuilder.append(f.b());
      stringBuilder.append(",code:");
      stringBuilder.append(f.c());
      paramJsPromptResult.confirm(stringBuilder.toString());
      GDTLogger.d(String.format("failed message: %s --> (%d,%s)", new Object[] { paramString2, Integer.valueOf(f.c()), f.b() }));
    } 
    return false;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\plugin\ab\f\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */