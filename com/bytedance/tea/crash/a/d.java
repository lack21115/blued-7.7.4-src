package com.bytedance.tea.crash.a;

import com.bytedance.tea.crash.e.f;
import com.bytedance.tea.crash.e.g;
import java.io.File;

public class d implements Runnable {
  private long a;
  
  private final c b;
  
  private volatile boolean c = false;
  
  private Runnable d = new Runnable(this) {
      public void run() {
        d.a(this.a, false);
      }
    };
  
  d(c paramc) {
    this.b = paramc;
    this.a = a();
    g.a(2L);
    f.a().a(4500L, this.d);
    f.a().a(5000L, this, 40, 5000L);
  }
  
  private long a() {
    File file = new File("/data/anr/traces.txt");
    return file.exists() ? file.lastModified() : 0L;
  }
  
  private boolean b() {
    File file = new File("/data/anr/traces.txt");
    return (file.exists() && file.canRead());
  }
  
  public void run() {
    if (!this.c) {
      byte b;
      String str;
      if (b()) {
        b = 200;
        str = "/data/anr/traces.txt";
      } else {
        str = null;
        b = 100;
      } 
      if (this.b.a(b, str, 25))
        this.c = true; 
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\tea\crash\a\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */