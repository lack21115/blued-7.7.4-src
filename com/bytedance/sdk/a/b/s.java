package com.bytedance.sdk.a.b;

import com.bytedance.sdk.a.a.c;
import com.bytedance.sdk.a.b.a.c;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class s {
  private static final char[] d = new char[] { 
      '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 
      'A', 'B', 'C', 'D', 'E', 'F' };
  
  final String a;
  
  final String b;
  
  final int c;
  
  private final String e;
  
  private final String f;
  
  private final List<String> g;
  
  private final List<String> h;
  
  private final String i;
  
  private final String j;
  
  s(a parama) {
    String str;
    this.a = parama.a;
    this.e = a(parama.b, false);
    this.f = a(parama.c, false);
    this.b = parama.d;
    this.c = parama.a();
    this.g = a(parama.f, false);
    List<String> list = parama.g;
    List list1 = null;
    if (list != null) {
      list = a(parama.g, true);
    } else {
      list = null;
    } 
    this.h = list;
    list = list1;
    if (parama.h != null)
      str = a(parama.h, false); 
    this.i = str;
    this.j = parama.toString();
  }
  
  public static int a(String paramString) {
    return paramString.equals("http") ? 80 : (paramString.equals("https") ? 443 : -1);
  }
  
  public static s a(URL paramURL) {
    return e(paramURL.toString());
  }
  
  static String a(String paramString1, int paramInt1, int paramInt2, String paramString2, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, Charset paramCharset) {
    for (int i = paramInt1; i < paramInt2; i += Character.charCount(j)) {
      int j = paramString1.codePointAt(i);
      if (j < 32 || j == 127 || (j >= 128 && paramBoolean4) || paramString2.indexOf(j) != -1 || (j == 37 && (!paramBoolean1 || (paramBoolean2 && !a(paramString1, i, paramInt2)))) || (j == 43 && paramBoolean3)) {
        c c = new c();
        c.a(paramString1, paramInt1, i);
        a(c, paramString1, i, paramInt2, paramString2, paramBoolean1, paramBoolean2, paramBoolean3, paramBoolean4, paramCharset);
        return c.o();
      } 
    } 
    return paramString1.substring(paramInt1, paramInt2);
  }
  
  static String a(String paramString, int paramInt1, int paramInt2, boolean paramBoolean) {
    for (int i = paramInt1; i < paramInt2; i++) {
      char c = paramString.charAt(i);
      if (c == '%' || (c == '+' && paramBoolean)) {
        c c1 = new c();
        c1.a(paramString, paramInt1, i);
        a(c1, paramString, i, paramInt2, paramBoolean);
        return c1.o();
      } 
    } 
    return paramString.substring(paramInt1, paramInt2);
  }
  
  static String a(String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4) {
    return a(paramString1, 0, paramString1.length(), paramString2, paramBoolean1, paramBoolean2, paramBoolean3, paramBoolean4, null);
  }
  
  static String a(String paramString, boolean paramBoolean) {
    return a(paramString, 0, paramString.length(), paramBoolean);
  }
  
  private List<String> a(List<String> paramList, boolean paramBoolean) {
    int j = paramList.size();
    ArrayList<String> arrayList = new ArrayList(j);
    for (int i = 0; i < j; i++) {
      String str = paramList.get(i);
      if (str != null) {
        str = a(str, paramBoolean);
      } else {
        str = null;
      } 
      arrayList.add(str);
    } 
    return Collections.unmodifiableList(arrayList);
  }
  
  static void a(c paramc, String paramString1, int paramInt1, int paramInt2, String paramString2, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, Charset paramCharset) {
    for (Object object = null; paramInt1 < paramInt2; object = SYNTHETIC_LOCAL_VARIABLE_14) {
      int i = paramString1.codePointAt(paramInt1);
      if (paramBoolean1) {
        Object object1 = object;
        if (i != 9) {
          object1 = object;
          if (i != 10) {
            object1 = object;
            if (i != 12) {
              if (i == 13) {
                object1 = object;
                continue;
              } 
            } else {
              continue;
            } 
          } else {
            continue;
          } 
        } else {
          continue;
        } 
      } 
      if (i == 43 && paramBoolean3) {
        String str;
        if (paramBoolean1) {
          str = "+";
        } else {
          str = "%2B";
        } 
        paramc.a(str);
        Object object1 = object;
      } else if (i < 32 || i == 127 || (i >= 128 && paramBoolean4) || paramString2.indexOf(i) != -1 || (i == 37 && (!paramBoolean1 || (paramBoolean2 && !a(paramString1, paramInt1, paramInt2))))) {
        Object object1 = object;
        if (object == null)
          object1 = new c(); 
        if (paramCharset == null || paramCharset.equals(c.e)) {
          object1.a(i);
        } else {
          object1.a(paramString1, paramInt1, Character.charCount(i) + paramInt1, paramCharset);
        } 
        while (true) {
          Object object2 = object1;
          if (!object1.e()) {
            int j = object1.h() & 0xFF;
            paramc.b(37);
            paramc.b(d[j >> 4 & 0xF]);
            paramc.b(d[j & 0xF]);
            continue;
          } 
          break;
        } 
      } else {
        paramc.a(i);
        Object object1 = object;
      } 
      continue;
      paramInt1 += Character.charCount(SYNTHETIC_LOCAL_VARIABLE_10);
    } 
  }
  
  static void a(c paramc, String paramString, int paramInt1, int paramInt2, boolean paramBoolean) {
    // Byte code:
    //   0: iload_2
    //   1: iload_3
    //   2: if_icmpge -> 123
    //   5: aload_1
    //   6: iload_2
    //   7: invokevirtual codePointAt : (I)I
    //   10: istore #6
    //   12: iload #6
    //   14: bipush #37
    //   16: if_icmpne -> 83
    //   19: iload_2
    //   20: iconst_2
    //   21: iadd
    //   22: istore #5
    //   24: iload #5
    //   26: iload_3
    //   27: if_icmpge -> 83
    //   30: aload_1
    //   31: iload_2
    //   32: iconst_1
    //   33: iadd
    //   34: invokevirtual charAt : (I)C
    //   37: invokestatic a : (C)I
    //   40: istore #7
    //   42: aload_1
    //   43: iload #5
    //   45: invokevirtual charAt : (I)C
    //   48: invokestatic a : (C)I
    //   51: istore #8
    //   53: iload #7
    //   55: iconst_m1
    //   56: if_icmpeq -> 105
    //   59: iload #8
    //   61: iconst_m1
    //   62: if_icmpeq -> 105
    //   65: aload_0
    //   66: iload #7
    //   68: iconst_4
    //   69: ishl
    //   70: iload #8
    //   72: iadd
    //   73: invokevirtual b : (I)Lcom/bytedance/sdk/a/a/c;
    //   76: pop
    //   77: iload #5
    //   79: istore_2
    //   80: goto -> 112
    //   83: iload #6
    //   85: bipush #43
    //   87: if_icmpne -> 105
    //   90: iload #4
    //   92: ifeq -> 105
    //   95: aload_0
    //   96: bipush #32
    //   98: invokevirtual b : (I)Lcom/bytedance/sdk/a/a/c;
    //   101: pop
    //   102: goto -> 112
    //   105: aload_0
    //   106: iload #6
    //   108: invokevirtual a : (I)Lcom/bytedance/sdk/a/a/c;
    //   111: pop
    //   112: iload_2
    //   113: iload #6
    //   115: invokestatic charCount : (I)I
    //   118: iadd
    //   119: istore_2
    //   120: goto -> 0
    //   123: return
  }
  
  static void a(StringBuilder paramStringBuilder, List<String> paramList) {
    int j = paramList.size();
    for (int i = 0; i < j; i++) {
      paramStringBuilder.append('/');
      paramStringBuilder.append(paramList.get(i));
    } 
  }
  
  static boolean a(String paramString, int paramInt1, int paramInt2) {
    int i = paramInt1 + 2;
    return (i < paramInt2 && paramString.charAt(paramInt1) == '%' && c.a(paramString.charAt(paramInt1 + 1)) != -1 && c.a(paramString.charAt(i)) != -1);
  }
  
  static List<String> b(String paramString) {
    ArrayList<String> arrayList = new ArrayList();
    for (int i = 0; i <= paramString.length(); i = j + 1) {
      int k = paramString.indexOf('&', i);
      int j = k;
      if (k == -1)
        j = paramString.length(); 
      k = paramString.indexOf('=', i);
      if (k == -1 || k > j) {
        arrayList.add(paramString.substring(i, j));
        arrayList.add(null);
      } else {
        arrayList.add(paramString.substring(i, k));
        arrayList.add(paramString.substring(k + 1, j));
      } 
    } 
    return arrayList;
  }
  
  static void b(StringBuilder paramStringBuilder, List<String> paramList) {
    int j = paramList.size();
    for (int i = 0; i < j; i += 2) {
      String str1 = paramList.get(i);
      String str2 = paramList.get(i + 1);
      if (i > 0)
        paramStringBuilder.append('&'); 
      paramStringBuilder.append(str1);
      if (str2 != null) {
        paramStringBuilder.append('=');
        paramStringBuilder.append(str2);
      } 
    } 
  }
  
  public static s e(String paramString) {
    a a = new a();
    s s1 = null;
    if (a.a(null, paramString) == a.a.a)
      s1 = a.c(); 
    return s1;
  }
  
  public URI a() {
    String str = n().b().toString();
    try {
      return new URI(str);
    } catch (URISyntaxException uRISyntaxException) {
      try {
        return URI.create(str.replaceAll("[\\u0000-\\u001F\\u007F-\\u009F\\p{javaWhitespace}]", ""));
      } catch (Exception exception) {
        throw new RuntimeException(uRISyntaxException);
      } 
    } 
  }
  
  public String b() {
    return this.a;
  }
  
  public s c(String paramString) {
    a a = d(paramString);
    return (a != null) ? a.c() : null;
  }
  
  public boolean c() {
    return this.a.equals("https");
  }
  
  public a d(String paramString) {
    a a = new a();
    return (a.a(this, paramString) == a.a.a) ? a : null;
  }
  
  public String d() {
    if (this.e.isEmpty())
      return ""; 
    int i = this.a.length() + 3;
    String str = this.j;
    int j = c.a(str, i, str.length(), ":@");
    return this.j.substring(i, j);
  }
  
  public String e() {
    if (this.f.isEmpty())
      return ""; 
    int i = this.j.indexOf(':', this.a.length() + 3);
    int j = this.j.indexOf('@');
    return this.j.substring(i + 1, j);
  }
  
  public boolean equals(Object paramObject) {
    return (paramObject instanceof s && ((s)paramObject).j.equals(this.j));
  }
  
  public String f() {
    return this.b;
  }
  
  public int g() {
    return this.c;
  }
  
  public String h() {
    int i = this.j.indexOf('/', this.a.length() + 3);
    String str = this.j;
    int j = c.a(str, i, str.length(), "?#");
    return this.j.substring(i, j);
  }
  
  public int hashCode() {
    return this.j.hashCode();
  }
  
  public List<String> i() {
    int i = this.j.indexOf('/', this.a.length() + 3);
    String str = this.j;
    int j = c.a(str, i, str.length(), "?#");
    ArrayList<String> arrayList = new ArrayList();
    while (i < j) {
      int k = i + 1;
      i = c.a(this.j, k, j, '/');
      arrayList.add(this.j.substring(k, i));
    } 
    return arrayList;
  }
  
  public String j() {
    if (this.h == null)
      return null; 
    int i = this.j.indexOf('?') + 1;
    String str = this.j;
    int j = c.a(str, i, str.length(), '#');
    return this.j.substring(i, j);
  }
  
  public String k() {
    if (this.h == null)
      return null; 
    StringBuilder stringBuilder = new StringBuilder();
    b(stringBuilder, this.h);
    return stringBuilder.toString();
  }
  
  public String l() {
    if (this.i == null)
      return null; 
    int i = this.j.indexOf('#');
    return this.j.substring(i + 1);
  }
  
  public String m() {
    return d("/...").b("").c("").c().toString();
  }
  
  public a n() {
    byte b;
    a a = new a();
    a.a = this.a;
    a.b = d();
    a.c = e();
    a.d = this.b;
    if (this.c != a(this.a)) {
      b = this.c;
    } else {
      b = -1;
    } 
    a.e = b;
    a.f.clear();
    a.f.addAll(i());
    a.e(j());
    a.h = l();
    return a;
  }
  
  public String toString() {
    return this.j;
  }
  
  public static final class a {
    String a;
    
    String b = "";
    
    String c = "";
    
    String d;
    
    int e = -1;
    
    final List<String> f = new ArrayList<String>();
    
    List<String> g;
    
    String h;
    
    public a() {
      this.f.add("");
    }
    
    private void a(String param1String, int param1Int1, int param1Int2) {
      if (param1Int1 == param1Int2)
        return; 
      char c = param1String.charAt(param1Int1);
      if (c == '/' || c == '\\') {
        this.f.clear();
        this.f.add("");
      } else {
        List<String> list = this.f;
        list.set(list.size() - 1, "");
        while (true) {
          if (param1Int1 < param1Int2) {
            boolean bool;
            int i = c.a(param1String, param1Int1, param1Int2, "/\\");
            if (i < param1Int2) {
              bool = true;
            } else {
              bool = false;
            } 
            a(param1String, param1Int1, i, bool, true);
            param1Int1 = i;
            if (bool) {
              param1Int1 = i;
            } else {
              continue;
            } 
          } else {
            break;
          } 
          param1Int1++;
        } 
        return;
      } 
      param1Int1++;
      continue;
    }
    
    private void a(String param1String, int param1Int1, int param1Int2, boolean param1Boolean1, boolean param1Boolean2) {
      param1String = s.a(param1String, param1Int1, param1Int2, " \"<>^`{}|/\\?#", param1Boolean2, false, false, true, null);
      if (f(param1String))
        return; 
      if (g(param1String)) {
        d();
        return;
      } 
      List<String> list = this.f;
      if (((String)list.get(list.size() - 1)).isEmpty()) {
        list = this.f;
        list.set(list.size() - 1, param1String);
      } else {
        this.f.add(param1String);
      } 
      if (param1Boolean1)
        this.f.add(""); 
    }
    
    private static int b(String param1String, int param1Int1, int param1Int2) {
      // Byte code:
      //   0: iload_2
      //   1: iload_1
      //   2: isub
      //   3: iconst_2
      //   4: if_icmpge -> 9
      //   7: iconst_m1
      //   8: ireturn
      //   9: aload_0
      //   10: iload_1
      //   11: invokevirtual charAt : (I)C
      //   14: istore #4
      //   16: iload #4
      //   18: bipush #97
      //   20: if_icmplt -> 32
      //   23: iload_1
      //   24: istore_3
      //   25: iload #4
      //   27: bipush #122
      //   29: if_icmple -> 50
      //   32: iload #4
      //   34: bipush #65
      //   36: if_icmplt -> 153
      //   39: iload_1
      //   40: istore_3
      //   41: iload #4
      //   43: bipush #90
      //   45: if_icmple -> 50
      //   48: iconst_m1
      //   49: ireturn
      //   50: iload_3
      //   51: iconst_1
      //   52: iadd
      //   53: istore_1
      //   54: iload_1
      //   55: iload_2
      //   56: if_icmpge -> 153
      //   59: aload_0
      //   60: iload_1
      //   61: invokevirtual charAt : (I)C
      //   64: istore #4
      //   66: iload #4
      //   68: bipush #97
      //   70: if_icmplt -> 82
      //   73: iload_1
      //   74: istore_3
      //   75: iload #4
      //   77: bipush #122
      //   79: if_icmple -> 50
      //   82: iload #4
      //   84: bipush #65
      //   86: if_icmplt -> 98
      //   89: iload_1
      //   90: istore_3
      //   91: iload #4
      //   93: bipush #90
      //   95: if_icmple -> 50
      //   98: iload #4
      //   100: bipush #48
      //   102: if_icmplt -> 114
      //   105: iload_1
      //   106: istore_3
      //   107: iload #4
      //   109: bipush #57
      //   111: if_icmple -> 50
      //   114: iload_1
      //   115: istore_3
      //   116: iload #4
      //   118: bipush #43
      //   120: if_icmpeq -> 50
      //   123: iload_1
      //   124: istore_3
      //   125: iload #4
      //   127: bipush #45
      //   129: if_icmpeq -> 50
      //   132: iload #4
      //   134: bipush #46
      //   136: if_icmpne -> 144
      //   139: iload_1
      //   140: istore_3
      //   141: goto -> 50
      //   144: iload #4
      //   146: bipush #58
      //   148: if_icmpne -> 153
      //   151: iload_1
      //   152: ireturn
      //   153: iconst_m1
      //   154: ireturn
    }
    
    private static int c(String param1String, int param1Int1, int param1Int2) {
      int i = 0;
      while (param1Int1 < param1Int2) {
        char c = param1String.charAt(param1Int1);
        if (c == '\\' || c == '/') {
          i++;
          param1Int1++;
        } 
      } 
      return i;
    }
    
    private static int d(String param1String, int param1Int1, int param1Int2) {
      while (param1Int1 < param1Int2) {
        char c = param1String.charAt(param1Int1);
        if (c != ':') {
          int i = param1Int1;
          if (c != '[') {
            i = param1Int1;
          } else {
            while (true) {
              param1Int1 = i + 1;
              i = param1Int1;
              if (param1Int1 < param1Int2) {
                i = param1Int1;
                if (param1String.charAt(param1Int1) == ']') {
                  i = param1Int1;
                  break;
                } 
                continue;
              } 
              break;
            } 
          } 
          param1Int1 = i + 1;
          continue;
        } 
        return param1Int1;
      } 
      return param1Int2;
    }
    
    private void d() {
      List<String> list = this.f;
      if (((String)list.remove(list.size() - 1)).isEmpty() && !this.f.isEmpty()) {
        list = this.f;
        list.set(list.size() - 1, "");
        return;
      } 
      this.f.add("");
    }
    
    private static String e(String param1String, int param1Int1, int param1Int2) {
      return c.a(s.a(param1String, param1Int1, param1Int2, false));
    }
    
    private static int f(String param1String, int param1Int1, int param1Int2) {
      try {
        param1Int1 = Integer.parseInt(s.a(param1String, param1Int1, param1Int2, "", false, false, false, true, null));
        return (param1Int1 > 0 && param1Int1 <= 65535) ? param1Int1 : -1;
      } catch (NumberFormatException numberFormatException) {
        return -1;
      } 
    }
    
    private boolean f(String param1String) {
      return (param1String.equals(".") || param1String.equalsIgnoreCase("%2e"));
    }
    
    private boolean g(String param1String) {
      return (param1String.equals("..") || param1String.equalsIgnoreCase("%2e.") || param1String.equalsIgnoreCase(".%2e") || param1String.equalsIgnoreCase("%2e%2e"));
    }
    
    int a() {
      int i = this.e;
      return (i != -1) ? i : s.a(this.a);
    }
    
    a a(s param1s, String param1String) {
      StringBuilder stringBuilder;
      int k;
      int i = c.a(param1String, 0, param1String.length());
      int m = c.b(param1String, i, param1String.length());
      if (b(param1String, i, m) != -1) {
        if (param1String.regionMatches(true, i, "https:", 0, 6)) {
          this.a = "https";
          i += 6;
        } else if (param1String.regionMatches(true, i, "http:", 0, 5)) {
          this.a = "http";
          i += 5;
        } else {
          return a.c;
        } 
      } else if (param1s != null) {
        this.a = param1s.a;
      } else {
        return a.b;
      } 
      int j = c(param1String, i, m);
      if (j >= 2 || param1s == null || !param1s.a.equals(this.a)) {
        int n = i + j;
        i = 0;
        j = 0;
        while (true) {
          int i1;
          k = c.a(param1String, n, m, "@/\\?#");
          if (k != m) {
            i1 = param1String.charAt(k);
          } else {
            i1 = -1;
          } 
          if (i1 != -1 && i1 != 35 && i1 != 47 && i1 != 92 && i1 != 63) {
            if (i1 != 64)
              continue; 
            if (i == 0) {
              int i2 = c.a(param1String, n, k, ':');
              i1 = k;
              String str2 = s.a(param1String, n, i2, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true, null);
              String str1 = str2;
              if (j != 0) {
                stringBuilder = new StringBuilder();
                stringBuilder.append(this.b);
                stringBuilder.append("%40");
                stringBuilder.append(str2);
                str1 = stringBuilder.toString();
              } 
              this.b = str1;
              if (i2 != i1) {
                this.c = s.a(param1String, i2 + 1, i1, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true, null);
                i = 1;
              } 
              j = 1;
            } else {
              stringBuilder = new StringBuilder();
              stringBuilder.append(this.c);
              stringBuilder.append("%40");
              stringBuilder.append(s.a(param1String, n, k, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true, null));
              this.c = stringBuilder.toString();
            } 
            n = k + 1;
            continue;
          } 
          break;
        } 
        i = d(param1String, n, k);
        j = i + 1;
        if (j < k) {
          this.d = e(param1String, n, i);
          this.e = f(param1String, j, k);
          if (this.e == -1)
            return a.d; 
        } else {
          this.d = e(param1String, n, i);
          this.e = s.a(this.a);
        } 
        if (this.d == null)
          return a.e; 
      } else {
        this.b = stringBuilder.d();
        this.c = stringBuilder.e();
        this.d = ((s)stringBuilder).b;
        this.e = ((s)stringBuilder).c;
        this.f.clear();
        this.f.addAll(stringBuilder.i());
        if (i == m || param1String.charAt(i) == '#')
          e(stringBuilder.j()); 
        k = i;
      } 
      j = c.a(param1String, k, m, "?#");
      a(param1String, k, j);
      i = j;
      if (j < m) {
        i = j;
        if (param1String.charAt(j) == '?') {
          i = c.a(param1String, j, m, '#');
          this.g = s.b(s.a(param1String, j + 1, i, " \"'<>#", true, false, true, true, null));
        } 
      } 
      if (i < m && param1String.charAt(i) == '#')
        this.h = s.a(param1String, 1 + i, m, "", true, false, false, false, null); 
      return a.a;
    }
    
    public a a(int param1Int) {
      if (param1Int > 0 && param1Int <= 65535) {
        this.e = param1Int;
        return this;
      } 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("unexpected port: ");
      stringBuilder.append(param1Int);
      throw new IllegalArgumentException(stringBuilder.toString());
    }
    
    public a a(String param1String) {
      if (param1String != null) {
        if (param1String.equalsIgnoreCase("http")) {
          this.a = "http";
          return this;
        } 
        if (param1String.equalsIgnoreCase("https")) {
          this.a = "https";
          return this;
        } 
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("unexpected scheme: ");
        stringBuilder.append(param1String);
        throw new IllegalArgumentException(stringBuilder.toString());
      } 
      throw new NullPointerException("scheme == null");
    }
    
    a b() {
      int j = this.f.size();
      boolean bool = false;
      int i;
      for (i = 0; i < j; i++) {
        String str1 = this.f.get(i);
        this.f.set(i, s.a(str1, "[]", true, true, false, true));
      } 
      List<String> list = this.g;
      if (list != null) {
        j = list.size();
        for (i = bool; i < j; i++) {
          String str1 = this.g.get(i);
          if (str1 != null)
            this.g.set(i, s.a(str1, "\\^`{|}", true, true, true, true)); 
        } 
      } 
      String str = this.h;
      if (str != null)
        this.h = s.a(str, " \"#<>\\^`{|}", true, true, false, false); 
      return this;
    }
    
    public a b(String param1String) {
      if (param1String != null) {
        this.b = s.a(param1String, " \"':;<=>@[]^`{}|/\\?#", false, false, false, true);
        return this;
      } 
      throw new NullPointerException("username == null");
    }
    
    public a c(String param1String) {
      if (param1String != null) {
        this.c = s.a(param1String, " \"':;<=>@[]^`{}|/\\?#", false, false, false, true);
        return this;
      } 
      throw new NullPointerException("password == null");
    }
    
    public s c() {
      if (this.a != null) {
        if (this.d != null)
          return new s(this); 
        throw new IllegalStateException("host == null");
      } 
      throw new IllegalStateException("scheme == null");
    }
    
    public a d(String param1String) {
      if (param1String != null) {
        String str = e(param1String, 0, param1String.length());
        if (str != null) {
          this.d = str;
          return this;
        } 
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("unexpected host: ");
        stringBuilder.append(param1String);
        throw new IllegalArgumentException(stringBuilder.toString());
      } 
      throw new NullPointerException("host == null");
    }
    
    public a e(String param1String) {
      if (param1String != null) {
        List<String> list = s.b(s.a(param1String, " \"'<>#", true, false, true, true));
      } else {
        param1String = null;
      } 
      this.g = (List<String>)param1String;
      return this;
    }
    
    public String toString() {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(this.a);
      stringBuilder.append("://");
      if (!this.b.isEmpty() || !this.c.isEmpty()) {
        stringBuilder.append(this.b);
        if (!this.c.isEmpty()) {
          stringBuilder.append(':');
          stringBuilder.append(this.c);
        } 
        stringBuilder.append('@');
      } 
      if (this.d.indexOf(':') != -1) {
        stringBuilder.append('[');
        stringBuilder.append(this.d);
        stringBuilder.append(']');
      } else {
        stringBuilder.append(this.d);
      } 
      int i = a();
      if (i != s.a(this.a)) {
        stringBuilder.append(':');
        stringBuilder.append(i);
      } 
      s.a(stringBuilder, this.f);
      if (this.g != null) {
        stringBuilder.append('?');
        s.b(stringBuilder, this.g);
      } 
      if (this.h != null) {
        stringBuilder.append('#');
        stringBuilder.append(this.h);
      } 
      return stringBuilder.toString();
    }
    
    enum a {
      a, b, c, d, e;
    }
  }
  
  enum a {
    a, b, c, d, e;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\a\b\s.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */