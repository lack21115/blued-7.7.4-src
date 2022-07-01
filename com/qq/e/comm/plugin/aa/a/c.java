package com.qq.e.comm.plugin.aa.a;

import android.text.TextUtils;
import com.qq.e.comm.plugin.j.b;
import com.qq.e.comm.plugin.j.b.f;
import com.qq.e.comm.util.GDTLogger;
import java.io.File;

class c implements Runnable {
  private final b a;
  
  private com.qq.e.comm.plugin.j.a b;
  
  private volatile boolean c;
  
  private a d;
  
  private final String e;
  
  private volatile f f;
  
  private final b g;
  
  c(String paramString, b paramb, com.qq.e.comm.plugin.j.a parama, b paramb1) {
    this.a = paramb;
    this.b = parama;
    this.e = paramString;
    this.g = paramb1;
  }
  
  private void b() {
    boolean bool;
    File file;
    if (this.a.a() != null && !TextUtils.isEmpty(this.a.b())) {
      file = new File(this.a.a(), this.a.b());
    } else {
      file = null;
    } 
    if (this.a.d()) {
      bool = true;
    } else {
      bool = true;
    } 
    this.f = new f(this.a.c(), file, bool, this.g);
    this.f.a(this.b);
    this.f.c();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("download result");
    stringBuilder.append(this.f.a());
    stringBuilder.append(" ");
    stringBuilder.append(this.f.b());
    GDTLogger.d(stringBuilder.toString());
  }
  
  void a(a parama) {
    this.d = parama;
  }
  
  public void a(com.qq.e.comm.plugin.j.a parama) {
    if (parama != null) {
      this.b = parama;
      if (this.f != null)
        this.f.a(parama); 
    } 
  }
  
  boolean a() {
    return this.c;
  }
  
  public void run() {
    this.c = true;
    b();
    a a1 = this.d;
    if (a1 != null)
      a1.a(this.e); 
    this.c = false;
  }
  
  static interface a {
    void a(String param1String);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\plugin\aa\a\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */