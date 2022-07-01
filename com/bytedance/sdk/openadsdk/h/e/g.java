package com.bytedance.sdk.openadsdk.h.e;

import com.bytedance.sdk.adnet.core.Header;
import com.bytedance.sdk.adnet.core.HttpResponse;
import com.bytedance.sdk.openadsdk.h.i;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class g extends a {
  private HttpResponse c;
  
  public g(HttpResponse paramHttpResponse, f paramf) {
    this.c = paramHttpResponse;
    this.a = new ArrayList<i.b>();
    for (int i = 0; i < this.c.b().size(); i++) {
      Header header = this.c.b().get(i);
      if (header != null)
        this.a.add(new i.b(header.a(), header.b())); 
    } 
    this.b = paramf;
  }
  
  public int a() {
    return this.c.a();
  }
  
  public String a(String paramString1, String paramString2) {
    return (a(paramString1) != null) ? (a(paramString1)).b : paramString2;
  }
  
  public boolean b() {
    return (this.c.a() >= 200 && this.c.a() < 300);
  }
  
  public List<i.b> c() {
    return this.a;
  }
  
  public InputStream d() {
    return this.c.d();
  }
  
  public String e() {
    return "http/1.1";
  }
  
  public String f() {
    return a(this.c.a());
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\openadsdk\h\e\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */