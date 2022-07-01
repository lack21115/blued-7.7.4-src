package com.huawei.hms.opendevice;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.agconnect.config.AGConnectServicesConfig;
import com.huawei.hms.support.log.HMSLog;
import java.util.Map;

public final class m extends Thread {
  public m(Context paramContext, String paramString) {}
  
  public void run() {
    if (!p.a()) {
      HMSLog.d("ReportAaidToken", "Not HW Phone.");
      return;
    } 
    if (n.a(this.a))
      return; 
    String str1 = o.a(this.a);
    if (TextUtils.isEmpty(str1)) {
      HMSLog.w("ReportAaidToken", "AAID is empty.");
      return;
    } 
    if (!n.a(this.a, str1, this.b)) {
      HMSLog.d("ReportAaidToken", "This time need not report.");
      return;
    } 
    String str2 = AGConnectServicesConfig.a(this.a).a("region");
    if (TextUtils.isEmpty(str2)) {
      HMSLog.i("ReportAaidToken", "The data storage region is empty.");
      return;
    } 
    str2 = e.a(this.a, "com.huawei.hms.opendevicesdk", "ROOT", null, str2);
    if (TextUtils.isEmpty(str2))
      return; 
    String str3 = n.b(this.a, str1, this.b);
    Context context = this.a;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(str2);
    stringBuilder.append("/rest/appdata/v1/aaid/report");
    str2 = d.a(context, stringBuilder.toString(), str3, (Map<String, String>)null);
    n.a(this.a, str2, str1, this.b);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\hms\opendevice\m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */