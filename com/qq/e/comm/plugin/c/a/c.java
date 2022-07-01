package com.qq.e.comm.plugin.c.a;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.qq.e.ads.cfg.BrowserType;
import com.qq.e.comm.plugin.a.d.d;
import com.qq.e.comm.plugin.ac.d;
import com.qq.e.comm.plugin.ac.e;
import com.qq.e.comm.plugin.s.a;
import com.qq.e.comm.plugin.util.ba;
import com.qq.e.comm.plugin.util.f;

public class c implements a {
  protected Context a;
  
  public c(Context paramContext) {
    this.a = paramContext;
  }
  
  public void a() {
    ba.a("未知异常，稍后重试");
  }
  
  public void a(int paramInt, b paramb) {
    Activity activity = f.a(this.a);
    if (activity == null)
      return; 
    (new d(activity, paramInt, paramb)).a();
  }
  
  public void a(a parama) {}
  
  public void a(String paramString) {
    Context context = this.a;
    if (context instanceof Activity)
      (new e(context)).a(paramString); 
  }
  
  public void a(String paramString, int paramInt) {
    if (d.b(paramInt)) {
      paramString = "正在努力下载，请耐心等待";
    } else {
      String str;
      StringBuilder stringBuilder;
      if (d.c(paramInt)) {
        stringBuilder = new StringBuilder();
        str = "开始安装";
      } else if (paramInt == 0) {
        stringBuilder = new StringBuilder();
        str = "开始下载";
      } else {
        return;
      } 
      stringBuilder.append(str);
      stringBuilder.append(paramString);
      paramString = stringBuilder.toString();
    } 
    ba.a(paramString);
  }
  
  public void a(String paramString, b paramb) {}
  
  public void a(String paramString, a parama) {
    com.qq.e.comm.plugin.c.c.a(paramString, parama);
  }
  
  public void a(boolean paramBoolean) {
    if (!paramBoolean)
      ba.a("跳转失败，可能未安装应用。"); 
  }
  
  public BrowserType b(String paramString, a parama) {
    return com.qq.e.comm.plugin.c.c.a(paramString, parama);
  }
  
  public void b(a parama) {}
  
  public void b(String paramString) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("tel:");
    stringBuilder.append(paramString);
    Intent intent = new Intent("android.intent.action.DIAL", Uri.parse(stringBuilder.toString()));
    if (!(this.a instanceof Activity))
      intent.setFlags(268435456); 
    this.a.startActivity(intent);
  }
  
  public void c(String paramString) {}
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\plugin\c\a\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */