package com.bytedance.sdk.a.b.a.e;

import com.bytedance.sdk.a.a.c;
import com.bytedance.sdk.a.a.e;
import com.bytedance.sdk.a.a.f;
import com.bytedance.sdk.a.a.l;
import com.bytedance.sdk.a.a.s;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

final class d {
  static final c[] a = new c[] { 
      new c(c.f, ""), new c(c.c, "GET"), new c(c.c, "POST"), new c(c.d, "/"), new c(c.d, "/index.html"), new c(c.e, "http"), new c(c.e, "https"), new c(c.b, "200"), new c(c.b, "204"), new c(c.b, "206"), 
      new c(c.b, "304"), new c(c.b, "400"), new c(c.b, "404"), new c(c.b, "500"), new c("accept-charset", ""), new c("accept-encoding", "gzip, deflate"), new c("accept-language", ""), new c("accept-ranges", ""), new c("accept", ""), new c("access-control-allow-origin", ""), 
      new c("age", ""), new c("allow", ""), new c("authorization", ""), new c("cache-control", ""), new c("content-disposition", ""), new c("content-encoding", ""), new c("content-language", ""), new c("content-length", ""), new c("content-location", ""), new c("content-range", ""), 
      new c("content-type", ""), new c("cookie", ""), new c("date", ""), new c("etag", ""), new c("expect", ""), new c("expires", ""), new c("from", ""), new c("host", ""), new c("if-match", ""), new c("if-modified-since", ""), 
      new c("if-none-match", ""), new c("if-range", ""), new c("if-unmodified-since", ""), new c("last-modified", ""), new c("link", ""), new c("location", ""), new c("max-forwards", ""), new c("proxy-authenticate", ""), new c("proxy-authorization", ""), new c("range", ""), 
      new c("referer", ""), new c("refresh", ""), new c("retry-after", ""), new c("server", ""), new c("set-cookie", ""), new c("strict-transport-security", ""), new c("transfer-encoding", ""), new c("user-agent", ""), new c("vary", ""), new c("via", ""), 
      new c("www-authenticate", "") };
  
  static final Map<f, Integer> b = a();
  
  static f a(f paramf) throws IOException {
    int j = paramf.g();
    int i = 0;
    while (i < j) {
      byte b = paramf.a(i);
      if (b < 65 || b > 90) {
        i++;
        continue;
      } 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("PROTOCOL_ERROR response malformed: mixed case name: ");
      stringBuilder.append(paramf.a());
      throw new IOException(stringBuilder.toString());
    } 
    return paramf;
  }
  
  private static Map<f, Integer> a() {
    LinkedHashMap<Object, Object> linkedHashMap = new LinkedHashMap<Object, Object>(a.length);
    int i = 0;
    while (true) {
      c[] arrayOfC = a;
      if (i < arrayOfC.length) {
        if (!linkedHashMap.containsKey((arrayOfC[i]).g))
          linkedHashMap.put((a[i]).g, Integer.valueOf(i)); 
        i++;
        continue;
      } 
      return (Map)Collections.unmodifiableMap(linkedHashMap);
    } 
  }
  
  static final class a {
    c[] a = new c[8];
    
    int b = this.a.length - 1;
    
    int c = 0;
    
    int d = 0;
    
    private final List<c> e = new ArrayList<c>();
    
    private final e f;
    
    private final int g;
    
    private int h;
    
    a(int param1Int1, int param1Int2, s param1s) {
      this.g = param1Int1;
      this.h = param1Int2;
      this.f = l.a(param1s);
    }
    
    a(int param1Int, s param1s) {
      this(param1Int, param1Int, param1s);
    }
    
    private int a(int param1Int) {
      int i = 0;
      boolean bool = false;
      if (param1Int > 0) {
        i = this.a.length - 1;
        int j = param1Int;
        param1Int = bool;
        while (i >= this.b && j > 0) {
          j -= (this.a[i]).i;
          this.d -= (this.a[i]).i;
          this.c--;
          param1Int++;
          i--;
        } 
        c[] arrayOfC = this.a;
        i = this.b;
        System.arraycopy(arrayOfC, i + 1, arrayOfC, i + 1 + param1Int, this.c);
        this.b += param1Int;
        i = param1Int;
      } 
      return i;
    }
    
    private void a(int param1Int, c param1c) {
      this.e.add(param1c);
      int j = param1c.i;
      int i = j;
      if (param1Int != -1)
        i = j - (this.a[c(param1Int)]).i; 
      j = this.h;
      if (i > j) {
        e();
        return;
      } 
      j = a(this.d + i - j);
      if (param1Int == -1) {
        param1Int = this.c;
        c[] arrayOfC = this.a;
        if (param1Int + 1 > arrayOfC.length) {
          c[] arrayOfC1 = new c[arrayOfC.length * 2];
          System.arraycopy(arrayOfC, 0, arrayOfC1, arrayOfC.length, arrayOfC.length);
          this.b = this.a.length - 1;
          this.a = arrayOfC1;
        } 
        param1Int = this.b;
        this.b = param1Int - 1;
        this.a[param1Int] = param1c;
        this.c++;
      } else {
        int k = c(param1Int);
        this.a[param1Int + k + j] = param1c;
      } 
      this.d += i;
    }
    
    private void b(int param1Int) throws IOException {
      if (g(param1Int)) {
        c c1 = d.a[param1Int];
        this.e.add(c1);
        return;
      } 
      int i = c(param1Int - d.a.length);
      if (i >= 0) {
        c[] arrayOfC = this.a;
        if (i <= arrayOfC.length - 1) {
          this.e.add(arrayOfC[i]);
          return;
        } 
      } 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Header index too large ");
      stringBuilder.append(param1Int + 1);
      throw new IOException(stringBuilder.toString());
    }
    
    private int c(int param1Int) {
      return this.b + 1 + param1Int;
    }
    
    private void d() {
      int i = this.h;
      int j = this.d;
      if (i < j) {
        if (i == 0) {
          e();
          return;
        } 
        a(j - i);
      } 
    }
    
    private void d(int param1Int) throws IOException {
      f f1 = f(param1Int);
      f f2 = c();
      this.e.add(new c(f1, f2));
    }
    
    private void e() {
      Arrays.fill((Object[])this.a, (Object)null);
      this.b = this.a.length - 1;
      this.c = 0;
      this.d = 0;
    }
    
    private void e(int param1Int) throws IOException {
      a(-1, new c(f(param1Int), c()));
    }
    
    private f f(int param1Int) {
      return g(param1Int) ? (d.a[param1Int]).g : (this.a[c(param1Int - d.a.length)]).g;
    }
    
    private void f() throws IOException {
      f f1 = d.a(c());
      f f2 = c();
      this.e.add(new c(f1, f2));
    }
    
    private void g() throws IOException {
      a(-1, new c(d.a(c()), c()));
    }
    
    private boolean g(int param1Int) {
      return (param1Int >= 0 && param1Int <= d.a.length - 1);
    }
    
    private int h() throws IOException {
      return this.f.h() & 0xFF;
    }
    
    int a(int param1Int1, int param1Int2) throws IOException {
      param1Int1 &= param1Int2;
      if (param1Int1 < param1Int2)
        return param1Int1; 
      param1Int1 = 0;
      while (true) {
        int i = h();
        if ((i & 0x80) != 0) {
          param1Int2 += (i & 0x7F) << param1Int1;
          param1Int1 += 7;
          continue;
        } 
        return param1Int2 + (i << param1Int1);
      } 
    }
    
    void a() throws IOException {
      while (!this.f.e()) {
        int i = this.f.h() & 0xFF;
        if (i != 128) {
          if ((i & 0x80) == 128) {
            b(a(i, 127) - 1);
            continue;
          } 
          if (i == 64) {
            g();
            continue;
          } 
          if ((i & 0x40) == 64) {
            e(a(i, 63) - 1);
            continue;
          } 
          if ((i & 0x20) == 32) {
            this.h = a(i, 31);
            i = this.h;
            if (i >= 0 && i <= this.g) {
              d();
              continue;
            } 
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Invalid dynamic table size update ");
            stringBuilder.append(this.h);
            throw new IOException(stringBuilder.toString());
          } 
          if (i == 16 || i == 0) {
            f();
            continue;
          } 
          d(a(i, 15) - 1);
          continue;
        } 
        throw new IOException("index == 0");
      } 
    }
    
    public List<c> b() {
      ArrayList<c> arrayList = new ArrayList<c>(this.e);
      this.e.clear();
      return arrayList;
    }
    
    f c() throws IOException {
      boolean bool;
      int i = h();
      if ((i & 0x80) == 128) {
        bool = true;
      } else {
        bool = false;
      } 
      i = a(i, 127);
      return bool ? f.a(k.a().a(this.f.g(i))) : this.f.c(i);
    }
  }
  
  static final class b {
    int a;
    
    int b;
    
    c[] c = new c[8];
    
    int d = this.c.length - 1;
    
    int e = 0;
    
    int f = 0;
    
    private final c g;
    
    private final boolean h;
    
    private int i = Integer.MAX_VALUE;
    
    private boolean j;
    
    b(int param1Int, boolean param1Boolean, c param1c) {
      this.a = param1Int;
      this.b = param1Int;
      this.h = param1Boolean;
      this.g = param1c;
    }
    
    b(c param1c) {
      this(4096, true, param1c);
    }
    
    private void a() {
      Arrays.fill((Object[])this.c, (Object)null);
      this.d = this.c.length - 1;
      this.e = 0;
      this.f = 0;
    }
    
    private void a(c param1c) {
      int i = param1c.i;
      int j = this.b;
      if (i > j) {
        a();
        return;
      } 
      b(this.f + i - j);
      j = this.e;
      c[] arrayOfC = this.c;
      if (j + 1 > arrayOfC.length) {
        c[] arrayOfC1 = new c[arrayOfC.length * 2];
        System.arraycopy(arrayOfC, 0, arrayOfC1, arrayOfC.length, arrayOfC.length);
        this.d = this.c.length - 1;
        this.c = arrayOfC1;
      } 
      j = this.d;
      this.d = j - 1;
      this.c[j] = param1c;
      this.e++;
      this.f += i;
    }
    
    private int b(int param1Int) {
      int i = 0;
      boolean bool = false;
      if (param1Int > 0) {
        i = this.c.length - 1;
        int j = param1Int;
        param1Int = bool;
        while (i >= this.d && j > 0) {
          j -= (this.c[i]).i;
          this.f -= (this.c[i]).i;
          this.e--;
          param1Int++;
          i--;
        } 
        c[] arrayOfC = this.c;
        i = this.d;
        System.arraycopy(arrayOfC, i + 1, arrayOfC, i + 1 + param1Int, this.e);
        arrayOfC = this.c;
        i = this.d;
        Arrays.fill((Object[])arrayOfC, i + 1, i + 1 + param1Int, (Object)null);
        this.d += param1Int;
        i = param1Int;
      } 
      return i;
    }
    
    private void b() {
      int i = this.b;
      int j = this.f;
      if (i < j) {
        if (i == 0) {
          a();
          return;
        } 
        b(j - i);
      } 
    }
    
    void a(int param1Int) {
      this.a = param1Int;
      param1Int = Math.min(param1Int, 16384);
      int i = this.b;
      if (i == param1Int)
        return; 
      if (param1Int < i)
        this.i = Math.min(this.i, param1Int); 
      this.j = true;
      this.b = param1Int;
      b();
    }
    
    void a(int param1Int1, int param1Int2, int param1Int3) {
      if (param1Int1 < param1Int2) {
        this.g.b(param1Int1 | param1Int3);
        return;
      } 
      this.g.b(param1Int3 | param1Int2);
      for (param1Int1 -= param1Int2; param1Int1 >= 128; param1Int1 >>>= 7)
        this.g.b(0x80 | param1Int1 & 0x7F); 
      this.g.b(param1Int1);
    }
    
    void a(f param1f) throws IOException {
      if (this.h && k.a().a(param1f) < param1f.g()) {
        c c1 = new c();
        k.a().a(param1f, (com.bytedance.sdk.a.a.d)c1);
        param1f = c1.n();
        a(param1f.g(), 127, 128);
        this.g.a(param1f);
        return;
      } 
      a(param1f.g(), 127, 0);
      this.g.a(param1f);
    }
    
    void a(List<c> param1List) throws IOException {
      // Byte code:
      //   0: aload_0
      //   1: getfield j : Z
      //   4: ifeq -> 52
      //   7: aload_0
      //   8: getfield i : I
      //   11: istore_2
      //   12: iload_2
      //   13: aload_0
      //   14: getfield b : I
      //   17: if_icmpge -> 29
      //   20: aload_0
      //   21: iload_2
      //   22: bipush #31
      //   24: bipush #32
      //   26: invokevirtual a : (III)V
      //   29: aload_0
      //   30: iconst_0
      //   31: putfield j : Z
      //   34: aload_0
      //   35: ldc 2147483647
      //   37: putfield i : I
      //   40: aload_0
      //   41: aload_0
      //   42: getfield b : I
      //   45: bipush #31
      //   47: bipush #32
      //   49: invokevirtual a : (III)V
      //   52: aload_1
      //   53: invokeinterface size : ()I
      //   58: istore #8
      //   60: iconst_0
      //   61: istore #4
      //   63: iload #4
      //   65: iload #8
      //   67: if_icmpge -> 460
      //   70: aload_1
      //   71: iload #4
      //   73: invokeinterface get : (I)Ljava/lang/Object;
      //   78: checkcast com/bytedance/sdk/a/b/a/e/c
      //   81: astore #10
      //   83: aload #10
      //   85: getfield g : Lcom/bytedance/sdk/a/a/f;
      //   88: invokevirtual f : ()Lcom/bytedance/sdk/a/a/f;
      //   91: astore #11
      //   93: aload #10
      //   95: getfield h : Lcom/bytedance/sdk/a/a/f;
      //   98: astore #12
      //   100: getstatic com/bytedance/sdk/a/b/a/e/d.b : Ljava/util/Map;
      //   103: aload #11
      //   105: invokeinterface get : (Ljava/lang/Object;)Ljava/lang/Object;
      //   110: checkcast java/lang/Integer
      //   113: astore #13
      //   115: aload #13
      //   117: ifnull -> 194
      //   120: aload #13
      //   122: invokevirtual intValue : ()I
      //   125: iconst_1
      //   126: iadd
      //   127: istore_3
      //   128: iload_3
      //   129: iconst_1
      //   130: if_icmple -> 187
      //   133: iload_3
      //   134: bipush #8
      //   136: if_icmpge -> 187
      //   139: getstatic com/bytedance/sdk/a/b/a/e/d.a : [Lcom/bytedance/sdk/a/b/a/e/c;
      //   142: iload_3
      //   143: iconst_1
      //   144: isub
      //   145: aaload
      //   146: getfield h : Lcom/bytedance/sdk/a/a/f;
      //   149: aload #12
      //   151: invokestatic a : (Ljava/lang/Object;Ljava/lang/Object;)Z
      //   154: ifeq -> 162
      //   157: iload_3
      //   158: istore_2
      //   159: goto -> 198
      //   162: getstatic com/bytedance/sdk/a/b/a/e/d.a : [Lcom/bytedance/sdk/a/b/a/e/c;
      //   165: iload_3
      //   166: aaload
      //   167: getfield h : Lcom/bytedance/sdk/a/a/f;
      //   170: aload #12
      //   172: invokestatic a : (Ljava/lang/Object;Ljava/lang/Object;)Z
      //   175: ifeq -> 187
      //   178: iload_3
      //   179: istore_2
      //   180: iload_3
      //   181: iconst_1
      //   182: iadd
      //   183: istore_3
      //   184: goto -> 198
      //   187: iload_3
      //   188: istore_2
      //   189: iconst_m1
      //   190: istore_3
      //   191: goto -> 198
      //   194: iconst_m1
      //   195: istore_3
      //   196: iconst_m1
      //   197: istore_2
      //   198: iload_3
      //   199: istore #6
      //   201: iload_2
      //   202: istore #7
      //   204: iload_3
      //   205: iconst_m1
      //   206: if_icmpne -> 332
      //   209: aload_0
      //   210: getfield d : I
      //   213: iconst_1
      //   214: iadd
      //   215: istore #5
      //   217: aload_0
      //   218: getfield c : [Lcom/bytedance/sdk/a/b/a/e/c;
      //   221: arraylength
      //   222: istore #9
      //   224: iload_3
      //   225: istore #6
      //   227: iload_2
      //   228: istore #7
      //   230: iload #5
      //   232: iload #9
      //   234: if_icmpge -> 332
      //   237: iload_2
      //   238: istore #6
      //   240: aload_0
      //   241: getfield c : [Lcom/bytedance/sdk/a/b/a/e/c;
      //   244: iload #5
      //   246: aaload
      //   247: getfield g : Lcom/bytedance/sdk/a/a/f;
      //   250: aload #11
      //   252: invokestatic a : (Ljava/lang/Object;Ljava/lang/Object;)Z
      //   255: ifeq -> 320
      //   258: aload_0
      //   259: getfield c : [Lcom/bytedance/sdk/a/b/a/e/c;
      //   262: iload #5
      //   264: aaload
      //   265: getfield h : Lcom/bytedance/sdk/a/a/f;
      //   268: aload #12
      //   270: invokestatic a : (Ljava/lang/Object;Ljava/lang/Object;)Z
      //   273: ifeq -> 298
      //   276: aload_0
      //   277: getfield d : I
      //   280: istore_3
      //   281: getstatic com/bytedance/sdk/a/b/a/e/d.a : [Lcom/bytedance/sdk/a/b/a/e/c;
      //   284: arraylength
      //   285: iload #5
      //   287: iload_3
      //   288: isub
      //   289: iadd
      //   290: istore #6
      //   292: iload_2
      //   293: istore #7
      //   295: goto -> 332
      //   298: iload_2
      //   299: istore #6
      //   301: iload_2
      //   302: iconst_m1
      //   303: if_icmpne -> 320
      //   306: iload #5
      //   308: aload_0
      //   309: getfield d : I
      //   312: isub
      //   313: getstatic com/bytedance/sdk/a/b/a/e/d.a : [Lcom/bytedance/sdk/a/b/a/e/c;
      //   316: arraylength
      //   317: iadd
      //   318: istore #6
      //   320: iload #5
      //   322: iconst_1
      //   323: iadd
      //   324: istore #5
      //   326: iload #6
      //   328: istore_2
      //   329: goto -> 224
      //   332: iload #6
      //   334: iconst_m1
      //   335: if_icmpeq -> 352
      //   338: aload_0
      //   339: iload #6
      //   341: bipush #127
      //   343: sipush #128
      //   346: invokevirtual a : (III)V
      //   349: goto -> 451
      //   352: iload #7
      //   354: iconst_m1
      //   355: if_icmpne -> 389
      //   358: aload_0
      //   359: getfield g : Lcom/bytedance/sdk/a/a/c;
      //   362: bipush #64
      //   364: invokevirtual b : (I)Lcom/bytedance/sdk/a/a/c;
      //   367: pop
      //   368: aload_0
      //   369: aload #11
      //   371: invokevirtual a : (Lcom/bytedance/sdk/a/a/f;)V
      //   374: aload_0
      //   375: aload #12
      //   377: invokevirtual a : (Lcom/bytedance/sdk/a/a/f;)V
      //   380: aload_0
      //   381: aload #10
      //   383: invokespecial a : (Lcom/bytedance/sdk/a/b/a/e/c;)V
      //   386: goto -> 451
      //   389: aload #11
      //   391: getstatic com/bytedance/sdk/a/b/a/e/c.a : Lcom/bytedance/sdk/a/a/f;
      //   394: invokevirtual a : (Lcom/bytedance/sdk/a/a/f;)Z
      //   397: ifeq -> 429
      //   400: getstatic com/bytedance/sdk/a/b/a/e/c.f : Lcom/bytedance/sdk/a/a/f;
      //   403: aload #11
      //   405: invokevirtual equals : (Ljava/lang/Object;)Z
      //   408: ifne -> 429
      //   411: aload_0
      //   412: iload #7
      //   414: bipush #15
      //   416: iconst_0
      //   417: invokevirtual a : (III)V
      //   420: aload_0
      //   421: aload #12
      //   423: invokevirtual a : (Lcom/bytedance/sdk/a/a/f;)V
      //   426: goto -> 451
      //   429: aload_0
      //   430: iload #7
      //   432: bipush #63
      //   434: bipush #64
      //   436: invokevirtual a : (III)V
      //   439: aload_0
      //   440: aload #12
      //   442: invokevirtual a : (Lcom/bytedance/sdk/a/a/f;)V
      //   445: aload_0
      //   446: aload #10
      //   448: invokespecial a : (Lcom/bytedance/sdk/a/b/a/e/c;)V
      //   451: iload #4
      //   453: iconst_1
      //   454: iadd
      //   455: istore #4
      //   457: goto -> 63
      //   460: return
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\a\b\a\e\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */