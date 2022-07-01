package com.qq.e.comm.plugin.w.a;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.plugin.util.ak;
import com.qq.e.comm.plugin.util.at;
import com.qq.e.comm.plugin.y.c;
import com.qq.e.comm.plugin.y.u;
import com.qq.e.comm.util.GDTLogger;

public class a {
  public static String a(Context paramContext, String paramString, d.a parama, d.e parame) {
    Intent intent = new Intent();
    intent.setClassName(paramContext, at.a());
    intent.putExtra("gdt_activity_delegate_name", "innerBrowser");
    intent.putExtra("url", paramString);
    intent.putExtra("appid", GDTADManager.getInstance().getAppStatus().getAPPID());
    intent.putExtra("clickStartTime", System.currentTimeMillis());
    intent.putExtra("adinfo", parama.a.toString());
    intent.putExtra("posId", parame.c);
    intent.putExtra("adType", parame.b.b());
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("get url, ");
    stringBuilder.append(paramString);
    ak.a("gdt_tag_net", stringBuilder.toString());
    if (parama.c != null && !TextUtils.isEmpty(parama.c.A()))
      intent.putExtra("reportUrl", parama.c.A()); 
    intent.addFlags(268435456);
    paramContext.startActivity(intent);
    GDTLogger.d("Browse with sdk browser");
    u.a(100002, 1, (new c()).a(parame.c).b(parama.a.optString("cl")).c(parama.a.optString("traceid")));
    return "InnerBrowser";
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\plugin\w\a\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */