package com.qq.e.comm.plugin.j.a;

import com.qq.e.comm.plugin.j.e;
import com.qq.e.comm.plugin.j.f;

public class a implements e {
  private final e a;
  
  private final c b;
  
  private long c = -1L;
  
  private int d;
  
  private String e = "";
  
  public a(e parame, c paramc) {
    this.a = parame;
    this.b = paramc;
  }
  
  public int a() {
    return this.a.a() | this.d;
  }
  
  public void a(f paramf) {
    e e1 = this.a;
    if (e1 != null)
      e1.a(paramf); 
  }
  
  public String b() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(this.a.b());
    stringBuilder.append("\t");
    stringBuilder.append(this.e);
    return stringBuilder.toString();
  }
  
  public boolean c() {
    long l = System.currentTimeMillis();
    boolean bool1 = false;
    boolean bool = false;
    while (true) {
      try {
        boolean bool2 = this.a.c();
        bool = bool2;
        boolean bool3 = this.b.a(a());
        if (!bool3) {
          bool = bool1;
        } else {
          bool = bool2;
          try {
            Thread.sleep(this.b.a());
          } catch (InterruptedException interruptedException) {}
          bool = bool2;
          if (this.b.b()) {
            bool = bool2;
            this.d = 67108864;
            bool = bool2;
            this.e = "NetworkChangedAndPauseDownloadTask";
            bool = bool1;
          } else {
            bool = bool2;
            if (bool2) {
              this.c = System.currentTimeMillis() - l;
              return bool2;
            } 
            continue;
          } 
        } 
      } finally {
        Exception exception;
      } 
      this.c = System.currentTimeMillis() - l;
      return bool;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\plugin\j\a\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */