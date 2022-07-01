package com.qq.e.comm.plugin.y;

import android.os.Build;
import android.util.Pair;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.managers.setting.SM;
import com.qq.e.comm.managers.status.SDKStatus;
import com.qq.e.comm.plugin.util.ad;
import com.qq.e.comm.plugin.util.al;
import com.qq.e.comm.plugin.util.an;
import com.qq.e.comm.plugin.util.ax;
import com.qq.e.comm.plugin.util.o;
import com.qq.e.comm.plugin.util.w;
import com.qq.e.comm.util.StringUtil;
import java.util.Iterator;
import java.util.Locale;
import java.util.TimeZone;
import java.util.UUID;
import org.json.JSONObject;
import yaq.gdtadv;

class j {
  private static final String a = UUID.randomUUID().toString();
  
  public static w a() {
    return (w)gdtadv.getobjresult(7, 1, new Object[0]);
  }
  
  static final class a {
    private JSONObject a;
    
    a() {
      w w = new w();
      w.a("pkg", GDTADManager.getInstance().getAppStatus().getAPPName());
      w.a("av", GDTADManager.getInstance().getAppStatus().getAPPVersion());
      w.a("sv", SDKStatus.getSDKVersion());
      w.a("plv", GDTADManager.getInstance().getPM().getPluginVersion());
      w.a("sdk_st", al.a());
      w.a("sdk_pt", 1);
      SM sM = GDTADManager.getInstance().getSM();
      if (sM != null && 1 == sM.getInteger("support_servers_upload_qadid", 0))
        w.a("qaid", an.a(GDTADManager.getInstance().getAppContext())); 
      w.a("ov", Build.VERSION.RELEASE);
      w.a("al", Build.VERSION.SDK_INT);
      w.a("os", 2);
      w.a("imei", com.qq.e.comm.plugin.h.b.a.a().a(GDTADManager.getInstance().getAppContext()));
      w.a("st", 2);
      w.a("muid", o.l());
      w.a("md", Build.MODEL);
      w.a("pl", Build.FINGERPRINT);
      w.a("mn", Build.PRODUCT);
      Object object = o.a();
      if (((Integer)((Pair)object).first).intValue() > ((Integer)((Pair)object).second).intValue()) {
        w.a("w", ((Pair)object).second);
        object = ((Pair)object).first;
      } else {
        w.a("w", ((Pair)object).first);
        object = ((Pair)object).second;
      } 
      w.a("h", object);
      w.a("lid", j.b());
      this.a = w.a();
    }
    
    w a() {
      w w = new w();
      w.a("ts", System.currentTimeMillis());
      w.a("app", GDTADManager.getInstance().getAppStatus().getAPPID());
      w.a("ct", GDTADManager.getInstance().getDeviceStatus().getNetworkType().getConnValue());
      String str = ad.a();
      if (!StringUtil.isEmpty(str))
        w.a("cell_native", str); 
      w.a("lg", Locale.getDefault().getLanguage());
      w.a("tz", TimeZone.getDefault().getID());
      w.a("ca", o.e(GDTADManager.getInstance().getAppContext()));
      Iterator<String> iterator = this.a.keys();
      while (iterator.hasNext()) {
        String str1 = iterator.next();
        w.a(str1, this.a.opt(str1));
      } 
      ax.a(w, "/log or /event");
      return w;
    }
  }
  
  static final class b {
    private static final j.a a = new j.a();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\plugin\y\j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */