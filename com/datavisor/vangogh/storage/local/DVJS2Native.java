package com.datavisor.vangogh.storage.local;

import android.content.Context;
import android.webkit.JavascriptInterface;
import com.datavisor.vangogh.bridge.crypto;
import com.datavisor.vangogh.bridge.storage;
import com.datavisor.vangogh.d.e;
import com.datavisor.vangogh.e.b.a;
import com.datavisor.vangogh.f.f;

public class DVJS2Native {
  private Context a;
  
  @JavascriptInterface
  public String getJSCacheData(String paramString) {
    try {
      if (f.a(paramString))
        return ""; 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("DVJSCACHEKEYPREFIX_");
      stringBuilder.append(paramString);
      paramString = storage.globalGet(stringBuilder.toString());
      boolean bool = f.a(paramString);
      return paramString;
    } finally {
      paramString = null;
    } 
  }
  
  @JavascriptInterface
  public String getJSLocalData(String paramString) {
    try {
      if (f.a(paramString))
        return ""; 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("DVJSSPKEYPREFIX_");
      stringBuilder.append(paramString);
      paramString = stringBuilder.toString();
      paramString = a.a(this.a, paramString);
      boolean bool = f.a(paramString);
      return paramString;
    } finally {
      paramString = null;
    } 
  }
  
  @JavascriptInterface
  public String getJSToken() {
    try {
      String str = e.a(this.a).a(crypto.convert("H6iqxnPZqQ=="));
      boolean bool = f.a(str);
      return str;
    } finally {
      Exception exception = null;
    } 
  }
  
  @JavascriptInterface
  public void removeJSCacheData(String paramString) {
    try {
      if (f.a(paramString))
        return; 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("DVJSCACHEKEYPREFIX_");
      stringBuilder.append(paramString);
      return;
    } finally {
      paramString = null;
    } 
  }
  
  @JavascriptInterface
  public void setJSCacheData(String paramString1, String paramString2) {
    try {
      return;
    } finally {
      paramString1 = null;
    } 
  }
  
  @JavascriptInterface
  public void setJSLocalData(String paramString1, String paramString2) {
    try {
      return;
    } finally {
      paramString1 = null;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\datavisor\vangogh\storage\local\DVJS2Native.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */