package com.geetest.onelogin.g;

import com.geetest.onelogin.a.d;
import com.geetest.onelogin.a.f;
import com.geetest.onelogin.g.a.b;
import com.geetest.onelogin.g.b.a;
import com.geetest.onelogin.g.c.b;
import com.geetest.onelogin.g.c.c;
import com.geetest.onelogin.g.c.d;
import com.geetest.onelogin.j.a;
import com.geetest.onelogin.j.c;
import com.geetest.onelogin.j.h;

public class b {
  private static final String[] a = new String[] { "com.unicom.xiaowo.login.UniAuthHelper", "com.unicom.xiaowo.account.shield.UniAccountHelper" };
  
  private static int b = -1;
  
  private static boolean c = false;
  
  private static int a() {
    int j = a.length;
    for (int i = 0; i < j; i++) {
      if (a.a(a[i]))
        return i; 
    } 
    return -1;
  }
  
  public static a a(d paramd) {
    StringBuilder stringBuilder1;
    a a;
    b b1;
    String str = paramd.getOperator();
    str.toLowerCase();
    f f = com.geetest.onelogin.f.b.w().m();
    if (f.c(str.toLowerCase()) == null) {
      stringBuilder1 = new StringBuilder();
      stringBuilder1.append("运营商 ");
      stringBuilder1.append(str);
      stringBuilder1.append(" 参数未配置");
      h.b(stringBuilder1.toString());
      return null;
    } 
    byte b2 = -1;
    int i = str.hashCode();
    if (i != 2154) {
      if (i != 2161) {
        if (i == 2162 && str.equals("CU"))
          b2 = 1; 
      } else if (str.equals("CT")) {
        b2 = 2;
      } 
    } else if (str.equals("CM")) {
      b2 = 0;
    } 
    if (b2 != 0) {
      a a1;
      if (b2 != 1) {
        if (b2 != 2)
          return null; 
        stringBuilder1.setOpBean(f.c(str.toLowerCase()));
        a1 = new a((d)stringBuilder1);
      } else {
        a = a((d)a1, f);
      } 
    } else {
      a.setOpBean(f.c(str.toLowerCase()));
      b1 = new b((d)a);
    } 
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append("build operator: ");
    stringBuilder2.append(b1);
    c.a(stringBuilder2.toString());
    return (a)b1;
  }
  
  private static a a(d paramd, f paramf) {
    if (b < 0)
      b = a(); 
    if (!c)
      c = a.a("com.unicom.online.account.yjyz.YJYZ"); 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("init unisdk, sdkIndex: ");
    stringBuilder.append(b);
    stringBuilder.append(", state: ");
    stringBuilder.append(c);
    h.b(stringBuilder.toString());
    if ("cucc".equals(paramf.d()) && c) {
      paramd.setOpBean(paramf.c(paramf.d()));
      return (a)d.a(paramd);
    } 
    paramd.setOpBean(paramf.c("cu"));
    int i = b;
    return (a)((i == 0) ? c.a(paramd) : ((i == 1) ? b.a(paramd) : null));
  }
  
  public static boolean a(String paramString) {
    return ("CM".equals(paramString) || "CU".equals(paramString) || "CT".equals(paramString));
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\geetest\onelogin\g\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */