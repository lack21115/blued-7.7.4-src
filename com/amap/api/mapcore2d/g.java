package com.amap.api.mapcore2d;

import android.content.Context;
import android.os.Message;
import com.amap.api.maps2d.MapsInitializer;
import org.json.JSONObject;

public class g extends Thread {
  private Context a;
  
  private y b;
  
  public g(Context paramContext, y paramy) {
    this.a = paramContext;
    this.b = paramy;
  }
  
  public void run() {
    try {
      if (!MapsInitializer.getNetworkEnable())
        return; 
      cw.a().a(this.a);
      da da = cm.a();
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("002");
      stringBuilder.append(";");
      stringBuilder.append("11K");
      stringBuilder.append(";");
      stringBuilder.append("001");
      stringBuilder.append(";");
      stringBuilder.append("145");
      String str = stringBuilder.toString();
      cr.a a = cr.a(this.a, da, str, null);
      if (cr.a != 1) {
        Message message = this.b.getMainHandler().obtainMessage();
        message.what = 2;
        if (a.a != null)
          message.obj = a.a; 
        this.b.getMainHandler().sendMessage(message);
      } 
      if (a != null) {
        if (a.x != null)
          cm.a().a(a.x.a); 
        if (!db.b(this.a) && a.A != null)
          (new cz(this.a, "2dmap", a.A.a, a.A.b)).a(); 
        if (a.t != null) {
          JSONObject jSONObject = a.t;
          int i = q.q;
          if (jSONObject.has("t"))
            i = jSONObject.getInt("t"); 
          bg.a().b("period_day", i);
          if (jSONObject.has("able")) {
            boolean bool = cr.a(jSONObject.getString("able"), false);
            bg.a();
            bg.b("UpdateDataActiveEnable", bool);
            MapsInitializer.setUpdateDataActiveEnable(bool);
          } 
          if (jSONObject.has("oi"))
            q.a(cr.a(jSONObject.getString("oi"), false)); 
        } 
      } 
      return;
    } finally {
      Exception exception = null;
      interrupt();
      do.c(exception, "AMapDelegateImpGLSurfaceView", "mVerfy");
      exception.printStackTrace();
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\mapcore2d\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */