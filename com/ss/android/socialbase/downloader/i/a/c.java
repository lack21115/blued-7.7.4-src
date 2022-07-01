package com.ss.android.socialbase.downloader.i.a;

import com.ss.android.socialbase.downloader.g.e;
import com.ss.android.socialbase.downloader.i.c;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class c implements c {
  private static final ArrayList<String> c = new ArrayList<String>(6);
  
  protected List<e> a;
  
  protected final Object b;
  
  private Map<String, String> d;
  
  private int e;
  
  private long f;
  
  private boolean g;
  
  private boolean h;
  
  private c i;
  
  static {
    c.add("Content-Length");
    c.add("Content-Range");
    c.add("Transfer-Encoding");
    c.add("Accept-Ranges");
    c.add("Etag");
    c.add("Content-Disposition");
  }
  
  public String a(String paramString) {
    Map<String, String> map = this.d;
    if (map != null)
      return map.get(paramString); 
    c c1 = this.i;
    return (c1 != null) ? c1.a(paramString) : null;
  }
  
  public void a() throws InterruptedException {
    synchronized (this.b) {
      if (this.h && this.d == null)
        this.b.wait(); 
      return;
    } 
  }
  
  public int b() throws IOException {
    return this.e;
  }
  
  public void c() {
    c c1 = this.i;
    if (c1 != null)
      c1.c(); 
  }
  
  public boolean d() {
    return this.g;
  }
  
  public boolean e() {
    return (System.currentTimeMillis() - this.f < b.b);
  }
  
  public List<e> f() {
    return this.a;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\ss\android\socialbase\downloader\i\a\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */