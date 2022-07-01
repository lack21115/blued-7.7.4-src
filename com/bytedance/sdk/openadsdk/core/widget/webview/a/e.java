package com.bytedance.sdk.openadsdk.core.widget.webview.a;

import android.net.Uri;
import android.text.TextUtils;

public class e {
  public static a a(String paramString) {
    a a2 = a.a;
    a a1 = a2;
    if (!TextUtils.isEmpty(paramString))
      try {
        paramString = Uri.parse(paramString).getPath();
        a1 = a2;
        return a.d;
      } finally {
        paramString = null;
      }  
    return a1;
  }
  
  public enum a {
    a("text/html"),
    b("text/css"),
    c("application/x-javascript"),
    d("image/*");
    
    private String e;
    
    a(String param1String1) {
      this.e = param1String1;
    }
    
    public String a() {
      return this.e;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\openadsdk\core\widget\webview\a\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */