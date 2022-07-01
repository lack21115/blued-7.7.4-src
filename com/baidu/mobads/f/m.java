package com.baidu.mobads.f;

import com.baidu.mobads.constants.XAdSDKProxyVersion;
import com.baidu.mobads.interfaces.utils.IXAdLogger;
import com.baidu.mobads.openad.interfaces.event.IOAdEvent;
import com.baidu.mobads.openad.interfaces.event.IOAdEventListener;

class m implements IOAdEventListener {
  m(l paraml, double paramDouble) {}
  
  public void run(IOAdEvent paramIOAdEvent) {
    g.f(this.b.a.b);
    if ("URLLoader.Load.Complete".equals(paramIOAdEvent.getType())) {
      boolean bool2;
      g.a(this.b.a.b, new e((String)paramIOAdEvent.getData().get("message")));
      double d = XAdSDKProxyVersion.getVersion();
      float f1 = g.g(this.b.a.b).getFloat("__badApkVersion__8.8283", 0.0F);
      float f2 = (float)g.h(this.b.a.b).b();
      boolean bool3 = true;
      if (f2 == f1) {
        bool2 = true;
      } else {
        bool2 = false;
      } 
      Boolean bool1 = Boolean.valueOf(bool2);
      if (d <= g.h(this.b.a.b).b() && Math.floor(d) == Math.floor(g.h(this.b.a.b).b())) {
        bool2 = bool3;
      } else {
        bool2 = false;
      } 
      Boolean bool4 = Boolean.valueOf(bool2);
      IXAdLogger iXAdLogger = g.e(this.b.a.b);
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("try to download apk badVer=");
      stringBuilder.append(f1);
      stringBuilder.append(", isBad=");
      stringBuilder.append(bool1);
      stringBuilder.append(", compatible=");
      stringBuilder.append(bool4);
      iXAdLogger.d("XAdApkLoader", stringBuilder.toString());
      if (this.a < g.h(this.b.a.b).b() && g.h(this.b.a.b) != null && g.h(this.b.a.b).a().booleanValue() && bool4.booleanValue() && !bool1.booleanValue()) {
        g.b(this.b.a.b, g.h(this.b.a.b));
        return;
      } 
      if (g.c(this.b.a.b)) {
        g.a(this.b.a.b, false);
        g.a(this.b.a.b, false, "Refused to download remote for version...");
        return;
      } 
    } else if (g.c(this.b.a.b)) {
      g.a(this.b.a.b, false);
      g.a(this.b.a.b, false, "remote update Network access failed");
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\baidu\mobads\f\m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */