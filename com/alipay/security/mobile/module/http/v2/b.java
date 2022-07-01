package com.alipay.security.mobile.module.http.v2;

import android.content.Context;
import com.alipay.security.mobile.module.http.a;
import com.alipay.security.mobile.module.http.d;
import com.alipay.security.mobile.module.http.model.c;
import com.alipay.security.mobile.module.http.model.d;
import com.alipay.tscenter.biz.rpc.report.general.model.DataReportRequest;

public class b implements a {
  private static a a;
  
  private static a b;
  
  public static a a(Context paramContext, String paramString) {
    if (paramContext == null)
      return null; 
    if (a == null) {
      b = d.a(paramContext, paramString);
      a = new b();
    } 
    return a;
  }
  
  public c a(d paramd) {
    DataReportRequest dataReportRequest = com.alipay.security.mobile.module.http.model.b.a(paramd);
    return com.alipay.security.mobile.module.http.model.b.a(b.a(dataReportRequest));
  }
  
  public boolean a(String paramString) {
    return b.a(paramString);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\alipay\security\mobile\module\http\v2\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */