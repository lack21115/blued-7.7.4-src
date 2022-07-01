package com.qq.e.comm.plugin.util;

import android.text.TextUtils;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.plugin.ad.g;
import com.qq.e.comm.plugin.s.a;
import com.qq.e.comm.plugin.w.a.d;
import com.qq.e.comm.plugin.y.c;
import com.qq.e.comm.plugin.y.d;
import com.qq.e.comm.plugin.y.g;
import com.qq.e.comm.plugin.y.u;
import com.qq.e.comm.util.GDTLogger;
import java.util.HashMap;

public class s {
  public static void a(String paramString1, String paramString2, int paramInt, long paramLong, String paramString3, String paramString4, c paramc) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("trackWebViewEvent, adType : ");
    stringBuilder.append(paramString1);
    stringBuilder.append(" area : ");
    stringBuilder.append(paramString2);
    stringBuilder.append(" endCardType : ");
    stringBuilder.append(paramInt);
    stringBuilder.append(" costTime : ");
    stringBuilder.append(paramLong);
    stringBuilder.append(" url : ");
    stringBuilder.append(paramString3);
    GDTLogger.d(stringBuilder.toString());
    if (paramInt == 1) {
      paramInt = 2020031;
    } else if (paramInt == 2) {
      paramInt = 2020034;
    } else {
      paramInt = 2020030;
    } 
    g g = (new g(paramInt)).b(paramLong);
    g.a(paramc);
    paramInt = GDTADManager.getInstance().getDeviceStatus().getNetworkType().getConnValue();
    d d = new d();
    d.a("adType", paramString1);
    d.a("area", paramString2);
    d.a("nt", Integer.valueOf(paramInt));
    d.a("wu", paramString3);
    if (!TextUtils.isEmpty(paramString4))
      d.a("errorMsg", paramString4); 
    g.a(d);
    u.a(g);
    if (paramLong > 3000L)
      u.a(100352, (int)paramLong / 50, paramc, d); 
  }
  
  public static boolean a(int paramInt) {
    return (paramInt == 10);
  }
  
  public static boolean a(a parama, int paramInt1, int paramInt2, String paramString1, d.e parame, d.b paramb, String paramString2) {
    String str1 = parama.M();
    if (TextUtils.isEmpty(str1))
      return true; 
    String str2 = bb.a(str1, "s", paramString1);
    str1 = str2;
    if (u.a(str2)) {
      ak.b("gdt_tag_p", "endCard landingPage click, url = %s", new Object[] { str2 });
      str1 = u.a(str2, g.a(paramString1, paramInt1, "click"));
    } 
    d.a(bb.c(str1, "click_area", String.valueOf(paramInt2)), parama, null);
    HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
    hashMap.put("code", "InnerBrowser");
    d.a(parama.M(), parama.E(), parame, paramb, hashMap);
    ac.a(paramString2);
    return false;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\plugi\\util\s.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */