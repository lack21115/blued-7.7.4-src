package com.geetest.onelogin.g.b;

import android.text.TextUtils;
import cn.com.chinatelecom.account.api.TraceLogger;
import com.geetest.onelogin.j.h;

public class b implements TraceLogger {
  public void debug(String paramString1, String paramString2) {
    if (!TextUtils.isEmpty(paramString1) && !TextUtils.isEmpty(paramString2))
      h.a(paramString1, paramString2); 
  }
  
  public void info(String paramString1, String paramString2) {
    if (!TextUtils.isEmpty(paramString1) && !TextUtils.isEmpty(paramString2))
      h.a(paramString1, paramString2); 
  }
  
  public void warn(String paramString1, String paramString2, Throwable paramThrowable) {
    if (!TextUtils.isEmpty(paramString1) && !TextUtils.isEmpty(paramString2))
      h.a(paramString1, paramString2); 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\geetest\onelogin\g\b\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */