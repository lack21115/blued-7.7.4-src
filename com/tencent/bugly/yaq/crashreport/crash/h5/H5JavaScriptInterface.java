package com.tencent.bugly.yaq.crashreport.crash.h5;

import android.webkit.JavascriptInterface;
import com.tencent.bugly.yaq.crashreport.CrashReport;
import com.tencent.bugly.yaq.proguard.x;
import java.util.HashSet;
import java.util.Map;

public class H5JavaScriptInterface {
  private static HashSet<Integer> a = new HashSet<Integer>();
  
  private String b;
  
  private Thread c;
  
  private String d;
  
  private Map<String, String> e;
  
  static {
    throw new VerifyError("bad dex opcode");
  }
  
  private H5JavaScriptInterface() {
    throw new VerifyError("bad dex opcode");
  }
  
  private static a a(String paramString) {
    if (paramString != null)
      throw new VerifyError("bad dex opcode"); 
    return null;
  }
  
  public static H5JavaScriptInterface getInstance(CrashReport.WebViewInterface paramWebViewInterface) {
    if (paramWebViewInterface != null) {
      HashSet<Integer> hashSet = a;
      throw new VerifyError("bad dex opcode");
    } 
    return null;
  }
  
  @JavascriptInterface
  public void printLog(String paramString) {
    x.d("Log from js: %s", new Object[] { paramString });
    throw new VerifyError("bad dex opcode");
  }
  
  @JavascriptInterface
  public void reportJSException(String paramString) {
    if (paramString == null) {
      x.d("Payload from JS is null.", new Object[0]);
      throw new VerifyError("bad dex opcode");
    } 
    throw new VerifyError("bad dex opcode");
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued555128-dex2jar.jar!\com\tencent\bugly\yaq\crashreport\crash\h5\H5JavaScriptInterface.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */