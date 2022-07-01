package com.qq.e.comm.plugin.w;

import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.plugin.ad.g;
import com.qq.e.comm.plugin.s.a;
import com.qq.e.comm.plugin.t.b;
import com.qq.e.comm.plugin.t.h;
import com.qq.e.comm.plugin.util.ad;
import com.qq.e.comm.plugin.util.ah;
import com.qq.e.comm.plugin.util.u;
import com.qq.e.comm.plugin.w.a.d;
import com.qq.e.comm.util.GDTLogger;
import com.qq.e.comm.util.StringUtil;

public class i {
  public static d.a a(a parama) {
    return (parama == null) ? null : new d.a(parama.E(), null, parama);
  }
  
  public static String a(String paramString) {
    String str = paramString;
    if (!StringUtil.isEmpty(paramString)) {
      int k = GDTADManager.getInstance().getDeviceStatus().getNetworkType().getConnValue();
      str = ad.a();
      String[] arrayOfString1 = new String[2];
      arrayOfString1[0] = "__CONN__";
      arrayOfString1[1] = "__CELL_NATIVE__";
      String[] arrayOfString2 = new String[2];
      int j = 0;
      arrayOfString2[0] = String.valueOf(k);
      arrayOfString2[1] = str;
      while (true) {
        str = paramString;
        if (j < arrayOfString1.length) {
          str = paramString;
          if (!StringUtil.isEmpty(arrayOfString2[j]))
            str = paramString.replace(arrayOfString1[j], arrayOfString2[j]); 
          j++;
          paramString = str;
          continue;
        } 
        break;
      } 
    } 
    return str;
  }
  
  public static void a(String paramString1, int paramInt, a parama, b paramb, String paramString2, d.b paramb1) {
    if (parama == null)
      return; 
    d.a(paramString1, paramInt, paramString2, paramb, paramb1);
  }
  
  public static void a(String paramString, int paramInt, a parama, d.b paramb) {
    if (parama == null)
      return; 
    paramString = u.b(parama.N(), g.a(paramString, paramInt));
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("append mu_p key and value, modified url( ccr )  = ");
    stringBuilder.append(paramString);
    GDTLogger.d(stringBuilder.toString());
    ah.a(paramString, (b)new h(paramb));
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\plugin\w\i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */