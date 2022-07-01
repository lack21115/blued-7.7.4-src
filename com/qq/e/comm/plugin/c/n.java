package com.qq.e.comm.plugin.c;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import com.qq.e.comm.plugin.c.a.a;
import com.qq.e.comm.plugin.c.a.b;
import yaq.gdtadv;

class n implements b, k {
  private f a;
  
  private a b;
  
  private Intent c;
  
  private String a(PackageManager paramPackageManager, ResolveInfo paramResolveInfo) {
    return (String)gdtadv.getobjresult(274, 0, new Object[] { this, paramPackageManager, paramResolveInfo });
  }
  
  private void a(int paramInt) {
    gdtadv.getVresult(275, 0, new Object[] { this, Integer.valueOf(paramInt) });
  }
  
  private void a(PackageManager paramPackageManager, ResolveInfo paramResolveInfo, a parama) {
    gdtadv.getVresult(276, 0, new Object[] { this, paramPackageManager, paramResolveInfo, parama });
  }
  
  private Intent b(f paramf) {
    return (Intent)gdtadv.getobjresult(277, 0, new Object[] { this, paramf });
  }
  
  private String c(f paramf) {
    return (String)gdtadv.getobjresult(278, 0, new Object[] { this, paramf });
  }
  
  private void d() {
    gdtadv.getVresult(279, 0, new Object[] { this });
  }
  
  private String e() {
    return (String)gdtadv.getobjresult(280, 0, new Object[] { this });
  }
  
  public void a() {
    gdtadv.getVresult(281, 0, new Object[] { this });
  }
  
  public boolean a(f paramf) {
    return gdtadv.getZresult(282, 0, new Object[] { this, paramf });
  }
  
  public boolean a(f paramf, a parama) {
    return gdtadv.getZresult(283, 0, new Object[] { this, paramf, parama });
  }
  
  public void b() {
    gdtadv.getVresult(284, 0, new Object[] { this });
  }
  
  public void c() {
    gdtadv.getVresult(285, 0, new Object[] { this });
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\plugin\c\n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */