package com.ss.android.socialbase.downloader.i.a;

import com.ss.android.socialbase.downloader.g.e;
import com.ss.android.socialbase.downloader.i.e;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class d implements e {
  protected final Object a;
  
  private final List<e> b;
  
  private e c;
  
  private boolean d;
  
  private long e;
  
  private InputStream f;
  
  public InputStream a() throws IOException {
    InputStream inputStream = this.f;
    return (inputStream != null) ? inputStream : null;
  }
  
  public String a(String paramString) {
    e e1 = this.c;
    return (e1 != null) ? e1.a(paramString) : null;
  }
  
  public boolean a(int paramInt) {
    return (paramInt >= 200 && paramInt < 300);
  }
  
  public int b() throws IOException {
    e e1 = this.c;
    return (e1 != null) ? e1.b() : 0;
  }
  
  public void c() {
    e e1 = this.c;
    if (e1 != null)
      e1.c(); 
  }
  
  public void d() {
    e e1 = this.c;
    if (e1 != null)
      e1.d(); 
  }
  
  public void e() throws InterruptedException {
    synchronized (this.a) {
      if (this.d && this.c == null)
        this.a.wait(); 
      return;
    } 
  }
  
  public List<e> f() {
    return this.b;
  }
  
  public boolean g() {
    boolean bool2 = false;
    boolean bool1 = bool2;
    try {
      if (this.c != null) {
        boolean bool = a(this.c.b());
        bool1 = bool2;
        if (bool)
          bool1 = true; 
      } 
      return bool1;
    } catch (IOException iOException) {
      iOException.printStackTrace();
      return false;
    } 
  }
  
  public boolean h() {
    return (System.currentTimeMillis() - this.e < b.a);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\ss\android\socialbase\downloader\i\a\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */