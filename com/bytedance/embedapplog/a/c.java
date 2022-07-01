package com.bytedance.embedapplog.a;

import android.content.Context;
import com.bytedance.embedapplog.util.d;
import com.bytedance.embedapplog.util.h;

abstract class c {
  final Context a;
  
  private int b = 0;
  
  private boolean c;
  
  c(Context paramContext) {
    this.a = paramContext;
  }
  
  abstract boolean a();
  
  abstract long b();
  
  abstract long[] c();
  
  abstract boolean d();
  
  abstract String e();
  
  void f() {
    this.c = true;
  }
  
  boolean g() {
    return this.c;
  }
  
  final long h() {
    int i;
    if (!a() || d.a(this.a)) {
      i = 1;
    } else {
      i = 0;
    } 
    if (!i)
      return 60000L; 
    long l1 = b();
    long l2 = System.currentTimeMillis();
    if (l1 <= 1000L + l2) {
      boolean bool;
      try {
        bool = d();
      } catch (Exception exception) {
        h.a(exception);
        bool = false;
      } 
      if (bool) {
        this.b = 0;
        l1 = b() - System.currentTimeMillis();
      } else {
        long[] arrayOfLong = c();
        i = this.b;
        this.b = i + 1;
        l1 = arrayOfLong[i % arrayOfLong.length];
      } 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(e());
      stringBuilder.append(" worked:");
      stringBuilder.append(bool);
      stringBuilder.append(" ");
      stringBuilder.append(l1);
      h.d(stringBuilder.toString(), null);
      return l1;
    } 
    return l1 - l2;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\embedapplog\a\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */