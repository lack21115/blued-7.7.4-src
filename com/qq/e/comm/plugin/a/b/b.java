package com.qq.e.comm.plugin.a.b;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.managers.setting.SM;
import com.qq.e.comm.plugin.a.c;
import com.qq.e.comm.plugin.a.j;
import com.qq.e.comm.plugin.util.at;

public class b implements d {
  private static final boolean f;
  
  private final c a;
  
  private final Context b;
  
  private final Intent c;
  
  private Intent d;
  
  private Intent e;
  
  static {
    SM sM = GDTADManager.getInstance().getSM();
    boolean bool = false;
    if (sM.getInteger("download_pause", 0) == 1)
      bool = true; 
    f = bool;
  }
  
  public b(Intent paramIntent, c paramc, Context paramContext) {
    this.c = paramIntent;
    this.a = paramc;
    this.b = paramContext;
  }
  
  private PendingIntent a(boolean paramBoolean) {
    if (f && paramBoolean) {
      if (this.d == null) {
        this.d = new Intent();
        this.d.setClassName(this.b, at.a());
        this.d.putExtra("gdt_activity_delegate_name", "downloadManage");
        this.d.putExtra("appid", GDTADManager.getInstance().getAppStatus().getAPPID());
      } 
      return PendingIntent.getActivity(this.b, 0, this.d, 134217728);
    } 
    if (this.e == null) {
      this.e = new Intent(this.c);
      j.a(this.e, true);
    } 
    return PendingIntent.getService(this.b, this.a.m(), this.e, 134217728);
  }
  
  public PendingIntent a() {
    return a(true);
  }
  
  public PendingIntent b() {
    return a(false);
  }
  
  public PendingIntent c() {
    return a(false);
  }
  
  public PendingIntent d() {
    return PendingIntent.getActivity(this.b, this.a.m(), this.c, 0);
  }
  
  public PendingIntent e() {
    return a(true);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\plugin\a\b\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */