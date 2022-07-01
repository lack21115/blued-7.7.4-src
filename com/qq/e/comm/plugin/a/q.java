package com.qq.e.comm.plugin.a;

import android.content.Context;
import android.content.Intent;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.plugin.util.ah;
import com.qq.e.comm.plugin.util.ak;
import com.qq.e.comm.plugin.util.bb;
import com.qq.e.comm.plugin.util.t;
import com.qq.e.comm.plugin.w.a;
import com.qq.e.comm.plugin.w.a.c;
import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;

class q implements d.a, f.a {
  private final f a;
  
  private final d b;
  
  private final c c;
  
  public q(d paramd, f paramf, c paramc) {
    this.a = paramf;
    this.b = paramd;
    this.c = paramc;
    paramd.a(this);
    paramf.a(this);
  }
  
  private void a(Context paramContext, Intent paramIntent, c paramc) {
    paramContext.startActivity(paramIntent);
    if (a(paramc) && !b(4))
      a.b(paramc.k()); 
  }
  
  private void a(Context paramContext, c paramc) {
    Intent intent = n.a(paramContext, paramc);
    if (intent != null)
      try {
        return;
      } finally {
        intent = null;
        intent = c.a(paramContext, paramc.h(), null);
      }  
  }
  
  private boolean a(c paramc) {
    return (paramc == null) ? false : bb.b(paramc.t());
  }
  
  private boolean b(int paramInt) {
    String str = this.c.a("launchParam");
    if (str != null)
      try {
        Object object = (new JSONObject(str)).optJSONObject("reportUrl").remove(String.valueOf(paramInt));
        if (object != null) {
          ah.a(object.toString());
          return true;
        } 
      } catch (JSONException jSONException) {
        ak.a(jSONException.getMessage(), (Exception)jSONException);
      }  
    return false;
  }
  
  public void a(int paramInt) {
    if (paramInt == 3)
      b(0); 
  }
  
  public void a(int paramInt, String paramString) {}
  
  public void a(int paramInt, String paramString, File paramFile) {
    if (paramInt == 0)
      b(1); 
    if (paramInt == 9 || (paramInt == 0 && this.c.d("autoInstall")))
      this.a.a(paramFile); 
    a(paramInt, paramString);
  }
  
  public void a(int paramInt, String paramString, boolean paramBoolean) {
    if (paramInt == 0) {
      if (!paramBoolean)
        b(2); 
      if (a(this.c))
        b(3); 
      a(GDTADManager.getInstance().getAppContext(), this.c);
    } 
    a(paramInt, paramString);
  }
  
  public void a(long paramLong1, long paramLong2) {}
  
  public boolean a() {
    return false;
  }
  
  public void b() {
    t.a.submit(this.b);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\plugin\a\q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */