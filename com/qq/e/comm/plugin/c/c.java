package com.qq.e.comm.plugin.c;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.qq.e.ads.cfg.BrowserType;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.plugin.s.a;
import com.qq.e.comm.plugin.util.at;
import com.qq.e.comm.util.GDTLogger;
import com.qq.e.comm.util.StringUtil;

public class c {
  public static BrowserType a(String paramString) {
    if (!StringUtil.isEmpty(paramString)) {
      StringBuilder stringBuilder;
      Intent intent = new Intent();
      intent.setAction("android.intent.action.VIEW");
      intent.setData(Uri.parse(paramString));
      intent.addFlags(268435456);
      Context context = GDTADManager.getInstance().getAppContext();
      if (intent.resolveActivity(context.getPackageManager()) == null) {
        stringBuilder = new StringBuilder();
        stringBuilder.append("openWithSystemBrowser fail, can't resolve intent: ");
        stringBuilder.append(intent);
        GDTLogger.w(stringBuilder.toString());
        return null;
      } 
      stringBuilder.startActivity(intent);
      GDTLogger.d("Browse with system browser");
      return BrowserType.Sys;
    } 
    return null;
  }
  
  public static BrowserType a(String paramString, a parama) {
    if (StringUtil.isEmpty(paramString))
      return null; 
    Context context = GDTADManager.getInstance().getAppContext();
    Intent intent = new Intent();
    intent.setClassName(context, at.a());
    intent.putExtra("gdt_activity_delegate_name", "innerBrowser");
    intent.putExtra("url", paramString);
    intent.putExtra("appid", GDTADManager.getInstance().getAppStatus().getAPPID());
    if (parama != null) {
      intent.putExtra("clickStartTime", System.currentTimeMillis());
      intent.putExtra("adinfo", parama.E().toString());
      intent.putExtra("posId", parama.B());
      intent.putExtra("adType", parama.C().b());
    } 
    intent.addFlags(268435456);
    context.startActivity(intent);
    GDTLogger.d("Browse with sdk browser");
    return BrowserType.Inner;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\plugin\c\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */