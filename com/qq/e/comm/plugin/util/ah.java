package com.qq.e.comm.plugin.util;

import android.text.TextUtils;
import com.qq.e.comm.plugin.t.b;
import com.qq.e.comm.plugin.t.b.c;
import com.qq.e.comm.plugin.t.b.e;
import com.qq.e.comm.plugin.t.b.f;
import com.qq.e.comm.plugin.t.c;
import com.qq.e.comm.plugin.t.d;
import com.qq.e.comm.util.GDTLogger;

public class ah {
  public static void a(String paramString) {
    a(paramString, true, null);
  }
  
  public static void a(String paramString, b paramb) {
    a(paramString, true, paramb);
  }
  
  public static void a(String paramString, boolean paramBoolean) {
    a(paramString, paramBoolean, null);
  }
  
  public static void a(String paramString, boolean paramBoolean, b paramb) {
    c.a a;
    if (TextUtils.isEmpty(paramString)) {
      GDTLogger.d("ping url null!");
      return;
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("PingUrlUtil        ping, url : ");
    stringBuilder.append(paramString);
    GDTLogger.d(stringBuilder.toString());
    c c = new c(paramString, e.a.a, null);
    ak.a("gdt_tag_net", ak.a((e)c));
    c c1 = d.a();
    if (paramBoolean) {
      a = c.a.a;
    } else {
      a = c.a.c;
    } 
    if (paramb == null)
      paramb = new b(paramString) {
          public void a(e param1e, f param1f) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("PingUrlUtil  onResponse, url : ");
            stringBuilder.append(this.a);
            stringBuilder.append(" responseStatus : ");
            stringBuilder.append(param1f.e());
            GDTLogger.d(stringBuilder.toString());
          }
          
          public void a(Exception param1Exception) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("PingUrlUtil onException, url:");
            stringBuilder.append(this.a);
            stringBuilder.append(" errMsg : ");
            stringBuilder.append(param1Exception.getMessage());
            GDTLogger.e(stringBuilder.toString());
          }
        }; 
    c1.a((e)c, a, paramb);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\plugi\\util\ah.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */