package com.huawei.hms.framework.network.grs.c;

import android.content.Context;
import android.net.Uri;
import com.huawei.hms.framework.network.grs.GrsBaseInfo;
import java.util.concurrent.Callable;

public class b {
  protected e a;
  
  private String b;
  
  private a c;
  
  private int d;
  
  private Context e;
  
  private String f;
  
  private GrsBaseInfo g;
  
  public b(String paramString1, int paramInt, a parama, Context paramContext, String paramString2, GrsBaseInfo paramGrsBaseInfo) {
    this.b = paramString1;
    this.c = parama;
    this.d = paramInt;
    this.e = paramContext;
    this.f = paramString2;
    this.g = paramGrsBaseInfo;
  }
  
  private String a(String paramString) {
    return Uri.parse(paramString).getPath();
  }
  
  private a g() {
    if (this.b.isEmpty())
      return a.c; 
    String str = a(this.b);
    return str.contains("1.0") ? a.b : (str.contains("2.0") ? a.a : a.c);
  }
  
  public a a() {
    return this.c;
  }
  
  public Context b() {
    return this.e;
  }
  
  public String c() {
    return this.b;
  }
  
  public int d() {
    return this.d;
  }
  
  public String e() {
    return this.f;
  }
  
  public Callable<e> f() {
    return (Callable<e>)(a.c.equals(g()) ? null : (a.b.equals(g()) ? new h(this.b, this.d, this.c, this.e, this.f, this.g) : new i(this.b, this.d, this.c, this.e, this.f, this.g)));
  }
  
  enum a {
    a, b, c;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\hms\framework\network\grs\c\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */