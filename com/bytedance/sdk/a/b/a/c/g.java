package com.bytedance.sdk.a.b.a.c;

import com.bytedance.sdk.a.b.a.b.c;
import com.bytedance.sdk.a.b.aa;
import com.bytedance.sdk.a.b.e;
import com.bytedance.sdk.a.b.i;
import com.bytedance.sdk.a.b.p;
import com.bytedance.sdk.a.b.t;
import com.bytedance.sdk.a.b.y;
import java.io.IOException;
import java.util.List;

public final class g implements t.a {
  private final List<t> a;
  
  private final com.bytedance.sdk.a.b.a.b.g b;
  
  private final c c;
  
  private final c d;
  
  private final int e;
  
  private final y f;
  
  private final e g;
  
  private final p h;
  
  private final int i;
  
  private final int j;
  
  private final int k;
  
  private int l;
  
  public g(List<t> paramList, com.bytedance.sdk.a.b.a.b.g paramg, c paramc, c paramc1, int paramInt1, y paramy, e parame, p paramp, int paramInt2, int paramInt3, int paramInt4) {
    this.a = paramList;
    this.d = paramc1;
    this.b = paramg;
    this.c = paramc;
    this.e = paramInt1;
    this.f = paramy;
    this.g = parame;
    this.h = paramp;
    this.i = paramInt2;
    this.j = paramInt3;
    this.k = paramInt4;
  }
  
  public aa a(y paramy) throws IOException {
    return a(paramy, this.b, this.c, this.d);
  }
  
  public aa a(y paramy, com.bytedance.sdk.a.b.a.b.g paramg, c paramc, c paramc1) throws IOException {
    if (this.e < this.a.size()) {
      this.l++;
      if (this.c == null || this.d.a(paramy.a())) {
        if (this.c == null || this.l <= 1) {
          g g1 = new g(this.a, paramg, paramc, paramc1, this.e + 1, paramy, this.g, this.h, this.i, this.j, this.k);
          t t = this.a.get(this.e);
          aa aa = t.a(g1);
          if (paramc == null || this.e + 1 >= this.a.size() || g1.l == 1) {
            if (aa != null) {
              if (aa.g() != null)
                return aa; 
              StringBuilder stringBuilder4 = new StringBuilder();
              stringBuilder4.append("interceptor ");
              stringBuilder4.append(t);
              stringBuilder4.append(" returned a response with no body");
              throw new IllegalStateException(stringBuilder4.toString());
            } 
            StringBuilder stringBuilder3 = new StringBuilder();
            stringBuilder3.append("interceptor ");
            stringBuilder3.append(t);
            stringBuilder3.append(" returned null");
            throw new NullPointerException(stringBuilder3.toString());
          } 
          StringBuilder stringBuilder2 = new StringBuilder();
          stringBuilder2.append("network interceptor ");
          stringBuilder2.append(t);
          stringBuilder2.append(" must call proceed() exactly once");
          throw new IllegalStateException(stringBuilder2.toString());
        } 
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append("network interceptor ");
        stringBuilder1.append(this.a.get(this.e - 1));
        stringBuilder1.append(" must call proceed() exactly once");
        throw new IllegalStateException(stringBuilder1.toString());
      } 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("network interceptor ");
      stringBuilder.append(this.a.get(this.e - 1));
      stringBuilder.append(" must retain the same host and port");
      throw new IllegalStateException(stringBuilder.toString());
    } 
    throw new AssertionError();
  }
  
  public i a() {
    return (i)this.d;
  }
  
  public int b() {
    return this.i;
  }
  
  public int c() {
    return this.j;
  }
  
  public int d() {
    return this.k;
  }
  
  public com.bytedance.sdk.a.b.a.b.g e() {
    return this.b;
  }
  
  public c f() {
    return this.c;
  }
  
  public e g() {
    return this.g;
  }
  
  public p h() {
    return this.h;
  }
  
  public y i() {
    return this.f;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\a\b\a\c\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */