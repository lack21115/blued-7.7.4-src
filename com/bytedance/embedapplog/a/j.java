package com.bytedance.embedapplog.a;

import android.content.Context;
import com.bytedance.embedapplog.b.h;
import com.bytedance.embedapplog.b.i;
import com.bytedance.embedapplog.c.a;
import com.bytedance.embedapplog.c.b;
import com.bytedance.embedapplog.d.b;
import com.bytedance.embedapplog.d.f;
import com.bytedance.embedapplog.d.g;
import com.bytedance.embedapplog.util.h;
import java.util.ArrayList;
import org.json.JSONObject;

class j extends c {
  private static final long[] b = new long[] { 60000L };
  
  private final h c;
  
  private final b d;
  
  private final i e;
  
  private long f;
  
  private long g;
  
  j(Context paramContext, b paramb, h paramh, i parami) {
    super(paramContext);
    this.d = paramb;
    this.c = paramh;
    this.e = parami;
  }
  
  boolean a() {
    return true;
  }
  
  long b() {
    long l1 = this.c.B();
    long l2 = 60000L;
    if (l1 > 60000L) {
      l1 = l2;
    } else if (l1 <= 0L) {
      l1 = l2;
    } 
    b[0] = l1;
    return this.f + l1;
  }
  
  long[] c() {
    return b;
  }
  
  public boolean d() {
    if (System.currentTimeMillis() > this.g + this.c.B()) {
      JSONObject jSONObject = this.e.b();
      k k = e.d();
      if (k != null && jSONObject != null) {
        f f = k.a();
        if (f != null) {
          this.d.a(jSONObject, f, k.b());
          this.g = System.currentTimeMillis();
        } 
      } 
    } 
    ArrayList arrayList = this.d.a();
    ArrayList<g> arrayList1 = new ArrayList(arrayList.size());
    ArrayList<g> arrayList2 = new ArrayList(arrayList.size());
    this.d.a(this.a, this.e.a());
    this.d.a(this.a);
    String[] arrayOfString = b.a(this.a, this.e.a());
    for (g g : arrayList) {
      int k = a.a(arrayOfString, g.h, this.c);
      if (k == 200) {
        arrayList1.add(g);
        continue;
      } 
      g.j = k;
      arrayList2.add(g);
    } 
    if (arrayList1.size() > 0 || arrayList2.size() > 0)
      this.d.a(arrayList1, arrayList2); 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(e());
    stringBuilder.append(arrayList1.size());
    stringBuilder.append(" ");
    stringBuilder.append(arrayList.size());
    h.d(stringBuilder.toString(), null);
    if (arrayList1.size() == arrayList.size()) {
      this.f = System.currentTimeMillis();
      return true;
    } 
    return false;
  }
  
  String e() {
    return "s";
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\embedapplog\a\j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */