package com.bytedance.sdk.a.b;

import com.bytedance.sdk.a.b.a.c;
import com.bytedance.sdk.a.b.a.c.d;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class l {
  private static final Pattern a = Pattern.compile("(\\d{2,4})[^\\d]*");
  
  private static final Pattern b = Pattern.compile("(?i)(jan|feb|mar|apr|may|jun|jul|aug|sep|oct|nov|dec).*");
  
  private static final Pattern c = Pattern.compile("(\\d{1,2})[^\\d]*");
  
  private static final Pattern d = Pattern.compile("(\\d{1,2}):(\\d{1,2}):(\\d{1,2})[^\\d]*");
  
  private final String e;
  
  private final String f;
  
  private final long g;
  
  private final String h;
  
  private final String i;
  
  private final boolean j;
  
  private final boolean k;
  
  private final boolean l;
  
  private final boolean m;
  
  private l(String paramString1, String paramString2, long paramLong, String paramString3, String paramString4, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4) {
    this.e = paramString1;
    this.f = paramString2;
    this.g = paramLong;
    this.h = paramString3;
    this.i = paramString4;
    this.j = paramBoolean1;
    this.k = paramBoolean2;
    this.m = paramBoolean3;
    this.l = paramBoolean4;
  }
  
  private static int a(String paramString, int paramInt1, int paramInt2, boolean paramBoolean) {
    while (paramInt1 < paramInt2) {
      char c = paramString.charAt(paramInt1);
      if ((c < ' ' && c != '\t') || c >= '' || (c >= '0' && c <= '9') || (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || c == ':') {
        c = '\001';
      } else {
        c = Character.MIN_VALUE;
      } 
      if (c == (paramBoolean ^ true))
        return paramInt1; 
      paramInt1++;
    } 
    return paramInt2;
  }
  
  private static long a(String paramString) {
    try {
      long l1 = Long.parseLong(paramString);
      return (l1 <= 0L) ? Long.MIN_VALUE : l1;
    } catch (NumberFormatException numberFormatException) {
      if (paramString.matches("-?\\d+"))
        return paramString.startsWith("-") ? Long.MIN_VALUE : Long.MAX_VALUE; 
      throw numberFormatException;
    } 
  }
  
  private static long a(String paramString, int paramInt1, int paramInt2) {
    int i = a(paramString, paramInt1, paramInt2, false);
    Matcher matcher = d.matcher(paramString);
    paramInt1 = -1;
    byte b5 = -1;
    byte b2 = -1;
    byte b1 = -1;
    byte b4 = -1;
    byte b3 = -1;
    while (i < paramInt2) {
      byte b6;
      byte b7;
      byte b8;
      byte b9;
      byte b10;
      int j = a(paramString, i + 1, paramInt2, true);
      matcher.region(i, j);
      if (b5 == -1 && matcher.usePattern(d).matches()) {
        b6 = Integer.parseInt(matcher.group(1));
        b9 = Integer.parseInt(matcher.group(2));
        b10 = Integer.parseInt(matcher.group(3));
        i = paramInt1;
        b7 = b2;
        b8 = b1;
      } else if (b2 == -1 && matcher.usePattern(c).matches()) {
        b7 = Integer.parseInt(matcher.group(1));
        i = paramInt1;
        b6 = b5;
        b8 = b1;
        b9 = b4;
        b10 = b3;
      } else if (b1 == -1 && matcher.usePattern(b).matches()) {
        String str = matcher.group(1).toLowerCase(Locale.US);
        b8 = b.pattern().indexOf(str) / 4;
        i = paramInt1;
        b6 = b5;
        b7 = b2;
        b9 = b4;
        b10 = b3;
      } else {
        i = paramInt1;
        b6 = b5;
        b7 = b2;
        b8 = b1;
        b9 = b4;
        b10 = b3;
        if (paramInt1 == -1) {
          i = paramInt1;
          b6 = b5;
          b7 = b2;
          b8 = b1;
          b9 = b4;
          b10 = b3;
          if (matcher.usePattern(a).matches()) {
            i = Integer.parseInt(matcher.group(1));
            b10 = b3;
            b9 = b4;
            b8 = b1;
            b7 = b2;
            b6 = b5;
          } 
        } 
      } 
      j = a(paramString, j + 1, paramInt2, false);
      paramInt1 = i;
      b5 = b6;
      b2 = b7;
      b1 = b8;
      b4 = b9;
      b3 = b10;
      i = j;
    } 
    paramInt2 = paramInt1;
    if (paramInt1 >= 70) {
      paramInt2 = paramInt1;
      if (paramInt1 <= 99)
        paramInt2 = paramInt1 + 1900; 
    } 
    paramInt1 = paramInt2;
    if (paramInt2 >= 0) {
      paramInt1 = paramInt2;
      if (paramInt2 <= 69)
        paramInt1 = paramInt2 + 2000; 
    } 
    if (paramInt1 >= 1601) {
      if (b1 != -1) {
        if (b2 >= 1 && b2 <= 31) {
          if (b5 >= 0 && b5 <= 23) {
            if (b4 >= 0 && b4 <= 59) {
              if (b3 >= 0 && b3 <= 59) {
                GregorianCalendar gregorianCalendar = new GregorianCalendar(c.g);
                gregorianCalendar.setLenient(false);
                gregorianCalendar.set(1, paramInt1);
                gregorianCalendar.set(2, b1 - 1);
                gregorianCalendar.set(5, b2);
                gregorianCalendar.set(11, b5);
                gregorianCalendar.set(12, b4);
                gregorianCalendar.set(13, b3);
                gregorianCalendar.set(14, 0);
                return gregorianCalendar.getTimeInMillis();
              } 
              throw new IllegalArgumentException();
            } 
            throw new IllegalArgumentException();
          } 
          throw new IllegalArgumentException();
        } 
        throw new IllegalArgumentException();
      } 
      throw new IllegalArgumentException();
    } 
    throw new IllegalArgumentException();
  }
  
  static l a(long paramLong, s params, String paramString) {
    // Byte code:
    //   0: aload_3
    //   1: invokevirtual length : ()I
    //   4: istore #5
    //   6: aload_3
    //   7: iconst_0
    //   8: iload #5
    //   10: bipush #59
    //   12: invokestatic a : (Ljava/lang/String;IIC)I
    //   15: istore #4
    //   17: aload_3
    //   18: iconst_0
    //   19: iload #4
    //   21: bipush #61
    //   23: invokestatic a : (Ljava/lang/String;IIC)I
    //   26: istore #6
    //   28: iload #6
    //   30: iload #4
    //   32: if_icmpne -> 37
    //   35: aconst_null
    //   36: areturn
    //   37: aload_3
    //   38: iconst_0
    //   39: iload #6
    //   41: invokestatic c : (Ljava/lang/String;II)Ljava/lang/String;
    //   44: astore #27
    //   46: aload #27
    //   48: invokevirtual isEmpty : ()Z
    //   51: ifne -> 730
    //   54: aload #27
    //   56: invokestatic b : (Ljava/lang/String;)I
    //   59: iconst_m1
    //   60: if_icmpeq -> 66
    //   63: goto -> 730
    //   66: aload_3
    //   67: iload #6
    //   69: iconst_1
    //   70: iadd
    //   71: iload #4
    //   73: invokestatic c : (Ljava/lang/String;II)Ljava/lang/String;
    //   76: astore #28
    //   78: aload #28
    //   80: invokestatic b : (Ljava/lang/String;)I
    //   83: iconst_m1
    //   84: if_icmpeq -> 89
    //   87: aconst_null
    //   88: areturn
    //   89: iload #4
    //   91: iconst_1
    //   92: iadd
    //   93: istore #4
    //   95: aconst_null
    //   96: astore #24
    //   98: aload #24
    //   100: astore #23
    //   102: ldc2_w -1
    //   105: lstore #10
    //   107: ldc2_w 253402300799999
    //   110: lstore #8
    //   112: iconst_0
    //   113: istore #18
    //   115: iconst_0
    //   116: istore #19
    //   118: iconst_1
    //   119: istore #17
    //   121: iconst_0
    //   122: istore #16
    //   124: iload #4
    //   126: iload #5
    //   128: if_icmpge -> 502
    //   131: aload_3
    //   132: iload #4
    //   134: iload #5
    //   136: bipush #59
    //   138: invokestatic a : (Ljava/lang/String;IIC)I
    //   141: istore #6
    //   143: aload_3
    //   144: iload #4
    //   146: iload #6
    //   148: bipush #61
    //   150: invokestatic a : (Ljava/lang/String;IIC)I
    //   153: istore #7
    //   155: aload_3
    //   156: iload #4
    //   158: iload #7
    //   160: invokestatic c : (Ljava/lang/String;II)Ljava/lang/String;
    //   163: astore #29
    //   165: iload #7
    //   167: iload #6
    //   169: if_icmpge -> 187
    //   172: aload_3
    //   173: iload #7
    //   175: iconst_1
    //   176: iadd
    //   177: iload #6
    //   179: invokestatic c : (Ljava/lang/String;II)Ljava/lang/String;
    //   182: astore #25
    //   184: goto -> 191
    //   187: ldc ''
    //   189: astore #25
    //   191: aload #29
    //   193: ldc 'expires'
    //   195: invokevirtual equalsIgnoreCase : (Ljava/lang/String;)Z
    //   198: ifeq -> 221
    //   201: aload #25
    //   203: iconst_0
    //   204: aload #25
    //   206: invokevirtual length : ()I
    //   209: invokestatic a : (Ljava/lang/String;II)J
    //   212: lstore #12
    //   214: lload #12
    //   216: lstore #8
    //   218: goto -> 242
    //   221: aload #29
    //   223: ldc 'max-age'
    //   225: invokevirtual equalsIgnoreCase : (Ljava/lang/String;)Z
    //   228: ifeq -> 272
    //   231: aload #25
    //   233: invokestatic a : (Ljava/lang/String;)J
    //   236: lstore #12
    //   238: lload #12
    //   240: lstore #10
    //   242: iconst_1
    //   243: istore #22
    //   245: aload #24
    //   247: astore #25
    //   249: lload #10
    //   251: lstore #12
    //   253: iload #18
    //   255: istore #20
    //   257: aload #23
    //   259: astore #26
    //   261: iload #17
    //   263: istore #21
    //   265: lload #8
    //   267: lstore #14
    //   269: goto -> 465
    //   272: aload #29
    //   274: ldc 'domain'
    //   276: invokevirtual equalsIgnoreCase : (Ljava/lang/String;)Z
    //   279: ifeq -> 315
    //   282: aload #25
    //   284: invokestatic b : (Ljava/lang/String;)Ljava/lang/String;
    //   287: astore #25
    //   289: iconst_0
    //   290: istore #21
    //   292: lload #10
    //   294: lstore #12
    //   296: iload #18
    //   298: istore #20
    //   300: aload #23
    //   302: astore #26
    //   304: lload #8
    //   306: lstore #14
    //   308: iload #16
    //   310: istore #22
    //   312: goto -> 465
    //   315: aload #29
    //   317: ldc 'path'
    //   319: invokevirtual equalsIgnoreCase : (Ljava/lang/String;)Z
    //   322: ifeq -> 356
    //   325: aload #25
    //   327: astore #26
    //   329: aload #24
    //   331: astore #25
    //   333: lload #10
    //   335: lstore #12
    //   337: iload #18
    //   339: istore #20
    //   341: iload #17
    //   343: istore #21
    //   345: lload #8
    //   347: lstore #14
    //   349: iload #16
    //   351: istore #22
    //   353: goto -> 465
    //   356: aload #29
    //   358: ldc 'secure'
    //   360: invokevirtual equalsIgnoreCase : (Ljava/lang/String;)Z
    //   363: ifeq -> 396
    //   366: iconst_1
    //   367: istore #20
    //   369: aload #24
    //   371: astore #25
    //   373: lload #10
    //   375: lstore #12
    //   377: aload #23
    //   379: astore #26
    //   381: iload #17
    //   383: istore #21
    //   385: lload #8
    //   387: lstore #14
    //   389: iload #16
    //   391: istore #22
    //   393: goto -> 465
    //   396: aload #24
    //   398: astore #25
    //   400: lload #10
    //   402: lstore #12
    //   404: iload #18
    //   406: istore #20
    //   408: aload #23
    //   410: astore #26
    //   412: iload #17
    //   414: istore #21
    //   416: lload #8
    //   418: lstore #14
    //   420: iload #16
    //   422: istore #22
    //   424: aload #29
    //   426: ldc 'httponly'
    //   428: invokevirtual equalsIgnoreCase : (Ljava/lang/String;)Z
    //   431: ifeq -> 465
    //   434: iconst_1
    //   435: istore #19
    //   437: iload #16
    //   439: istore #22
    //   441: lload #8
    //   443: lstore #14
    //   445: iload #17
    //   447: istore #21
    //   449: aload #23
    //   451: astore #26
    //   453: iload #18
    //   455: istore #20
    //   457: lload #10
    //   459: lstore #12
    //   461: aload #24
    //   463: astore #25
    //   465: iload #6
    //   467: iconst_1
    //   468: iadd
    //   469: istore #4
    //   471: aload #25
    //   473: astore #24
    //   475: lload #12
    //   477: lstore #10
    //   479: iload #20
    //   481: istore #18
    //   483: aload #26
    //   485: astore #23
    //   487: iload #21
    //   489: istore #17
    //   491: lload #14
    //   493: lstore #8
    //   495: iload #22
    //   497: istore #16
    //   499: goto -> 124
    //   502: ldc2_w -9223372036854775808
    //   505: lstore #12
    //   507: lload #10
    //   509: ldc2_w -9223372036854775808
    //   512: lcmp
    //   513: ifne -> 522
    //   516: lload #12
    //   518: lstore_0
    //   519: goto -> 591
    //   522: lload #10
    //   524: ldc2_w -1
    //   527: lcmp
    //   528: ifeq -> 588
    //   531: lload #10
    //   533: ldc2_w 9223372036854775
    //   536: lcmp
    //   537: ifgt -> 551
    //   540: lload #10
    //   542: ldc2_w 1000
    //   545: lmul
    //   546: lstore #8
    //   548: goto -> 556
    //   551: ldc2_w 9223372036854775807
    //   554: lstore #8
    //   556: lload_0
    //   557: lload #8
    //   559: ladd
    //   560: lstore #8
    //   562: lload #8
    //   564: lload_0
    //   565: lcmp
    //   566: iflt -> 581
    //   569: lload #8
    //   571: lstore_0
    //   572: lload #8
    //   574: ldc2_w 253402300799999
    //   577: lcmp
    //   578: ifle -> 519
    //   581: ldc2_w 253402300799999
    //   584: lstore_0
    //   585: goto -> 591
    //   588: lload #8
    //   590: lstore_0
    //   591: aload_2
    //   592: invokevirtual f : ()Ljava/lang/String;
    //   595: astore #25
    //   597: aload #24
    //   599: ifnonnull -> 608
    //   602: aload #25
    //   604: astore_3
    //   605: goto -> 623
    //   608: aload #25
    //   610: aload #24
    //   612: invokestatic a : (Ljava/lang/String;Ljava/lang/String;)Z
    //   615: ifne -> 620
    //   618: aconst_null
    //   619: areturn
    //   620: aload #24
    //   622: astore_3
    //   623: aload #25
    //   625: invokevirtual length : ()I
    //   628: aload_3
    //   629: invokevirtual length : ()I
    //   632: if_icmpeq -> 647
    //   635: invokestatic a : ()Lcom/bytedance/sdk/a/b/a/h/a;
    //   638: aload_3
    //   639: invokevirtual a : (Ljava/lang/String;)Ljava/lang/String;
    //   642: ifnonnull -> 647
    //   645: aconst_null
    //   646: areturn
    //   647: ldc '/'
    //   649: astore #24
    //   651: aload #23
    //   653: ifnull -> 675
    //   656: aload #23
    //   658: ldc '/'
    //   660: invokevirtual startsWith : (Ljava/lang/String;)Z
    //   663: ifne -> 669
    //   666: goto -> 675
    //   669: aload #23
    //   671: astore_2
    //   672: goto -> 707
    //   675: aload_2
    //   676: invokevirtual h : ()Ljava/lang/String;
    //   679: astore #23
    //   681: aload #23
    //   683: bipush #47
    //   685: invokevirtual lastIndexOf : (I)I
    //   688: istore #4
    //   690: aload #24
    //   692: astore_2
    //   693: iload #4
    //   695: ifeq -> 707
    //   698: aload #23
    //   700: iconst_0
    //   701: iload #4
    //   703: invokevirtual substring : (II)Ljava/lang/String;
    //   706: astore_2
    //   707: new com/bytedance/sdk/a/b/l
    //   710: dup
    //   711: aload #27
    //   713: aload #28
    //   715: lload_0
    //   716: aload_3
    //   717: aload_2
    //   718: iload #18
    //   720: iload #19
    //   722: iload #17
    //   724: iload #16
    //   726: invokespecial <init> : (Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;ZZZZ)V
    //   729: areturn
    //   730: aconst_null
    //   731: areturn
    //   732: astore #25
    //   734: aload #24
    //   736: astore #25
    //   738: lload #10
    //   740: lstore #12
    //   742: iload #18
    //   744: istore #20
    //   746: aload #23
    //   748: astore #26
    //   750: iload #17
    //   752: istore #21
    //   754: lload #8
    //   756: lstore #14
    //   758: iload #16
    //   760: istore #22
    //   762: goto -> 465
    // Exception table:
    //   from	to	target	type
    //   201	214	732	java/lang/IllegalArgumentException
    //   231	238	732	java/lang/NumberFormatException
    //   282	289	732	java/lang/IllegalArgumentException
  }
  
  public static l a(s params, String paramString) {
    return a(System.currentTimeMillis(), params, paramString);
  }
  
  public static List<l> a(s params, r paramr) {
    ArrayList<l> arrayList;
    List<String> list = paramr.b("Set-Cookie");
    int j = list.size();
    paramr = null;
    for (int i = 0; i < j; i++) {
      l l1 = a(params, list.get(i));
      if (l1 != null) {
        ArrayList<l> arrayList1;
        r r1 = paramr;
        if (paramr == null)
          arrayList1 = new ArrayList(); 
        arrayList1.add(l1);
        arrayList = arrayList1;
      } 
    } 
    return (arrayList != null) ? Collections.unmodifiableList(arrayList) : Collections.emptyList();
  }
  
  private static boolean a(String paramString1, String paramString2) {
    return paramString1.equals(paramString2) ? true : ((paramString1.endsWith(paramString2) && paramString1.charAt(paramString1.length() - paramString2.length() - 1) == '.' && !c.c(paramString1)));
  }
  
  private static String b(String paramString) {
    if (!paramString.endsWith(".")) {
      String str = paramString;
      if (paramString.startsWith("."))
        str = paramString.substring(1); 
      paramString = c.a(str);
      if (paramString != null)
        return paramString; 
      throw new IllegalArgumentException();
    } 
    throw new IllegalArgumentException();
  }
  
  public String a() {
    return this.e;
  }
  
  String a(boolean paramBoolean) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(this.e);
    stringBuilder.append('=');
    stringBuilder.append(this.f);
    if (this.l)
      if (this.g == Long.MIN_VALUE) {
        stringBuilder.append("; max-age=0");
      } else {
        stringBuilder.append("; expires=");
        stringBuilder.append(d.a(new Date(this.g)));
      }  
    if (!this.m) {
      stringBuilder.append("; domain=");
      if (paramBoolean)
        stringBuilder.append("."); 
      stringBuilder.append(this.h);
    } 
    stringBuilder.append("; path=");
    stringBuilder.append(this.i);
    if (this.j)
      stringBuilder.append("; secure"); 
    if (this.k)
      stringBuilder.append("; httponly"); 
    return stringBuilder.toString();
  }
  
  public String b() {
    return this.f;
  }
  
  public boolean equals(Object paramObject) {
    boolean bool = paramObject instanceof l;
    boolean bool1 = false;
    if (!bool)
      return false; 
    paramObject = paramObject;
    bool = bool1;
    if (((l)paramObject).e.equals(this.e)) {
      bool = bool1;
      if (((l)paramObject).f.equals(this.f)) {
        bool = bool1;
        if (((l)paramObject).h.equals(this.h)) {
          bool = bool1;
          if (((l)paramObject).i.equals(this.i)) {
            bool = bool1;
            if (((l)paramObject).g == this.g) {
              bool = bool1;
              if (((l)paramObject).j == this.j) {
                bool = bool1;
                if (((l)paramObject).k == this.k) {
                  bool = bool1;
                  if (((l)paramObject).l == this.l) {
                    bool = bool1;
                    if (((l)paramObject).m == this.m)
                      bool = true; 
                  } 
                } 
              } 
            } 
          } 
        } 
      } 
    } 
    return bool;
  }
  
  public int hashCode() {
    int i = this.e.hashCode();
    int j = this.f.hashCode();
    int k = this.h.hashCode();
    int m = this.i.hashCode();
    long l1 = this.g;
    return ((((((((527 + i) * 31 + j) * 31 + k) * 31 + m) * 31 + (int)(l1 ^ l1 >>> 32L)) * 31 + (this.j ^ true)) * 31 + (this.k ^ true)) * 31 + (this.l ^ true)) * 31 + (this.m ^ true);
  }
  
  public String toString() {
    return a(false);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\a\b\l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */