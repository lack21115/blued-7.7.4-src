package com.bytedance.sdk.openadsdk.utils;

import android.os.Build;
import android.webkit.WebView;

public class s {
  private static final a a = new a();
  
  public static void a(WebView paramWebView, String paramString) {
    a.a(paramWebView, paramString);
  }
  
  static {
    if (Build.VERSION.SDK_INT >= 19) {
      a = new b();
      return;
    } 
  }
  
  static class a {
    private a() {}
    
    public void a(WebView param1WebView, String param1String) {
      if (param1WebView == null)
        return; 
      try {
        return;
      } finally {
        param1WebView = null;
      } 
    }
  }
  
  static class b extends a {
    private b() {}
    
    public void a(WebView param1WebView, String param1String) {
      if (param1WebView == null)
        return; 
      boolean bool2 = false;
      boolean bool1 = bool2;
      if (param1String != null) {
        bool1 = bool2;
        if (param1String.startsWith("javascript:"))
          try {
          
          } finally {
            Exception exception = null;
            boolean bool = exception instanceof IllegalStateException;
          }  
      } 
      if (!bool1)
        try {
          return;
        } finally {
          param1WebView = null;
        }  
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\openadsd\\utils\s.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */