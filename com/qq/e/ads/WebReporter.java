package com.qq.e.ads;

import android.content.Context;
import com.qq.e.comm.managers.plugin.a;
import com.qq.e.comm.pi.WRI;
import com.qq.e.comm.util.GDTLogger;
import com.qq.e.comm.util.StringUtil;

public class WebReporter {
  private WRI a;
  
  public WebReporter(Context paramContext, String paramString1, String paramString2, long paramLong) {
    String str;
    if (StringUtil.isEmpty(paramString1)) {
      str = "init web reporter fail with error params";
    } else {
      try {
        return;
      } catch (a a) {
      
      } finally {
        str = null;
        str.printStackTrace();
      } 
    } 
    GDTLogger.e(str);
  }
  
  public void report(String paramString, int paramInt) {
    WRI wRI = this.a;
    if (wRI != null)
      wRI.report(paramString, paramInt); 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\ads\WebReporter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */