package com.bytedance.sdk.a.b.a.c;

import com.bytedance.sdk.a.a.j;
import com.bytedance.sdk.a.a.l;
import com.bytedance.sdk.a.a.s;
import com.bytedance.sdk.a.b.a.c;
import com.bytedance.sdk.a.b.a.d;
import com.bytedance.sdk.a.b.aa;
import com.bytedance.sdk.a.b.l;
import com.bytedance.sdk.a.b.m;
import com.bytedance.sdk.a.b.t;
import com.bytedance.sdk.a.b.u;
import com.bytedance.sdk.a.b.y;
import com.bytedance.sdk.a.b.z;
import java.io.IOException;
import java.util.List;

public final class a implements t {
  private final m a;
  
  public a(m paramm) {
    this.a = paramm;
  }
  
  private String a(List<l> paramList) {
    StringBuilder stringBuilder = new StringBuilder();
    int j = paramList.size();
    for (int i = 0; i < j; i++) {
      if (i > 0)
        stringBuilder.append("; "); 
      l l = paramList.get(i);
      stringBuilder.append(l.a());
      stringBuilder.append('=');
      stringBuilder.append(l.b());
    } 
    return stringBuilder.toString();
  }
  
  public aa a(t.a parama) throws IOException {
    y y = parama.i();
    y.a a2 = y.e();
    z z = y.d();
    if (z != null) {
      u u = z.a();
      if (u != null)
        a2.a("Content-Type", u.toString()); 
      long l = z.b();
      if (l != -1L) {
        a2.a("Content-Length", Long.toString(l));
        a2.a("Transfer-Encoding");
      } else {
        a2.a("Transfer-Encoding", "chunked");
        a2.a("Content-Length");
      } 
    } 
    String str = y.a("Host");
    boolean bool2 = false;
    if (str == null)
      a2.a("Host", c.a(y.a(), false)); 
    if (y.a("Connection") == null)
      a2.a("Connection", "Keep-Alive"); 
    boolean bool1 = bool2;
    if (y.a("Accept-Encoding") == null) {
      bool1 = bool2;
      if (y.a("Range") == null) {
        bool1 = true;
        a2.a("Accept-Encoding", "gzip");
      } 
    } 
    List<l> list = this.a.a(y.a());
    if (!list.isEmpty())
      a2.a("Cookie", a(list)); 
    if (y.a("User-Agent") == null)
      a2.a("User-Agent", d.a()); 
    aa aa = parama.a(a2.d());
    e.a(this.a, y.a(), aa.f());
    aa.a a1 = aa.h().a(y);
    if (bool1 && "gzip".equalsIgnoreCase(aa.a("Content-Encoding")) && e.b(aa)) {
      j j = new j((s)aa.g().b());
      a1.a(aa.f().b().b("Content-Encoding").b("Content-Length").a());
      a1.a(new h(aa.a("Content-Type"), -1L, l.a((s)j)));
    } 
    return a1.a();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\a\b\a\c\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */