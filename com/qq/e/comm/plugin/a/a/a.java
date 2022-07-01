package com.qq.e.comm.plugin.a.a;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.ViewGroup;
import com.qq.e.comm.pi.ACTD;
import com.qq.e.comm.plugin.a.l;
import com.qq.e.comm.plugin.ab.a.b;
import com.qq.e.comm.plugin.ab.a.c;
import com.qq.e.comm.plugin.ab.c;
import com.qq.e.comm.plugin.ab.c.i;
import com.qq.e.comm.plugin.ab.c.j;
import com.qq.e.comm.plugin.ab.c.l;
import com.qq.e.comm.plugin.ab.c.m;
import com.qq.e.comm.plugin.ab.c.o;
import com.qq.e.comm.plugin.ab.c.p;
import com.qq.e.comm.plugin.ab.e;
import com.qq.e.comm.plugin.ab.h;
import com.qq.e.comm.plugin.ad.e;
import com.qq.e.comm.util.GDTLogger;
import java.util.ArrayList;

public class a implements ACTD, b, c {
  private h a;
  
  private Activity b;
  
  public a(Activity paramActivity) {
    this.b = paramActivity;
  }
  
  private void d() {
    this.b.finish();
  }
  
  private void e() {
    this.a.a(f());
  }
  
  private String f() {
    StringBuilder stringBuilder1 = new StringBuilder("http://qzonestyle.gtimg.cn/qzone/biz/gdt/mob/sdk/v2/android01/download.html");
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append("DownloadURL=");
    stringBuilder2.append(stringBuilder1);
    GDTLogger.d(stringBuilder2.toString());
    return stringBuilder1.toString();
  }
  
  private void g() {
    this.a = (new e(this.b.getApplicationContext(), this)).a(this).a();
    ArrayList<i> arrayList = new ArrayList();
    arrayList.add(i.a());
    arrayList.add(m.a());
    arrayList.add(j.a());
    arrayList.add(l.a());
    arrayList.add(o.a());
    arrayList.add(p.a());
    this.a.a(arrayList);
  }
  
  public String a() {
    return "";
  }
  
  public void a(com.qq.e.comm.plugin.ab.a.a parama) {
    if (null.a[parama.a().ordinal()] != 1)
      return; 
    d();
  }
  
  public String b() {
    return "";
  }
  
  public e c() {
    return null;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public void onAfterCreate(Bundle paramBundle) {
    g();
    if (this.a.a().getParent() != null)
      ((ViewGroup)this.a.a().getParent()).removeView(this.a.a()); 
    this.b.setContentView(this.a.a());
    e();
  }
  
  public void onBackPressed() {
    d();
  }
  
  public void onBeforeCreate(Bundle paramBundle) {
    l.a().c();
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration) {}
  
  public void onDestroy() {
    h h1 = this.a;
    if (h1 != null)
      h1.c(); 
  }
  
  public void onPause() {}
  
  public void onResume() {}
  
  public void onStop() {}
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\plugin\a\a\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */