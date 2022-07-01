package com.bytedance.sdk.adnet.d;

import com.bytedance.sdk.adnet.core.Header;
import com.bytedance.sdk.adnet.core.j;
import com.bytedance.sdk.adnet.core.p;
import com.bytedance.sdk.adnet.face.a;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.TreeMap;

public class c {
  public static long a(String paramString) {
    try {
      return a().parse(paramString).getTime();
    } finally {
      Exception exception = null;
      p.a(exception, "Unable to parse dateStr: %s, falling back to 0", new Object[] { paramString });
    } 
  }
  
  public static a.a a(j paramj) {
    // Byte code:
    //   0: invokestatic currentTimeMillis : ()J
    //   3: lstore #13
    //   5: aload_0
    //   6: getfield c : Ljava/util/Map;
    //   9: astore #15
    //   11: aload #15
    //   13: ldc 'Date'
    //   15: invokeinterface get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   20: checkcast java/lang/String
    //   23: astore #16
    //   25: aload #16
    //   27: ifnull -> 40
    //   30: aload #16
    //   32: invokestatic a : (Ljava/lang/String;)J
    //   35: lstore #7
    //   37: goto -> 43
    //   40: lconst_0
    //   41: lstore #7
    //   43: aload #15
    //   45: ldc 'Cache-Control'
    //   47: invokeinterface get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   52: checkcast java/lang/String
    //   55: astore #16
    //   57: iconst_0
    //   58: istore_1
    //   59: iconst_0
    //   60: istore_2
    //   61: aload #16
    //   63: ifnull -> 236
    //   66: aload #16
    //   68: ldc ','
    //   70: iconst_0
    //   71: invokevirtual split : (Ljava/lang/String;I)[Ljava/lang/String;
    //   74: astore #16
    //   76: lconst_0
    //   77: lstore #5
    //   79: iconst_0
    //   80: istore_1
    //   81: lconst_0
    //   82: lstore_3
    //   83: iload_2
    //   84: aload #16
    //   86: arraylength
    //   87: if_icmpge -> 231
    //   90: aload #16
    //   92: iload_2
    //   93: aaload
    //   94: invokevirtual trim : ()Ljava/lang/String;
    //   97: astore #17
    //   99: aload #17
    //   101: ldc 'no-cache'
    //   103: invokevirtual equals : (Ljava/lang/Object;)Z
    //   106: ifne -> 229
    //   109: aload #17
    //   111: ldc 'no-store'
    //   113: invokevirtual equals : (Ljava/lang/Object;)Z
    //   116: ifeq -> 122
    //   119: goto -> 229
    //   122: aload #17
    //   124: ldc 'max-age='
    //   126: invokevirtual startsWith : (Ljava/lang/String;)Z
    //   129: ifeq -> 150
    //   132: aload #17
    //   134: bipush #8
    //   136: invokevirtual substring : (I)Ljava/lang/String;
    //   139: invokestatic parseLong : (Ljava/lang/String;)J
    //   142: lstore #9
    //   144: lload_3
    //   145: lstore #11
    //   147: goto -> 215
    //   150: aload #17
    //   152: ldc 'stale-while-revalidate='
    //   154: invokevirtual startsWith : (Ljava/lang/String;)Z
    //   157: ifeq -> 179
    //   160: aload #17
    //   162: bipush #23
    //   164: invokevirtual substring : (I)Ljava/lang/String;
    //   167: invokestatic parseLong : (Ljava/lang/String;)J
    //   170: lstore #11
    //   172: lload #5
    //   174: lstore #9
    //   176: goto -> 215
    //   179: aload #17
    //   181: ldc 'must-revalidate'
    //   183: invokevirtual equals : (Ljava/lang/Object;)Z
    //   186: ifne -> 206
    //   189: lload #5
    //   191: lstore #9
    //   193: lload_3
    //   194: lstore #11
    //   196: aload #17
    //   198: ldc 'proxy-revalidate'
    //   200: invokevirtual equals : (Ljava/lang/Object;)Z
    //   203: ifeq -> 215
    //   206: iconst_1
    //   207: istore_1
    //   208: lload_3
    //   209: lstore #11
    //   211: lload #5
    //   213: lstore #9
    //   215: iload_2
    //   216: iconst_1
    //   217: iadd
    //   218: istore_2
    //   219: lload #9
    //   221: lstore #5
    //   223: lload #11
    //   225: lstore_3
    //   226: goto -> 83
    //   229: aconst_null
    //   230: areturn
    //   231: iconst_1
    //   232: istore_2
    //   233: goto -> 243
    //   236: lconst_0
    //   237: lstore #5
    //   239: lconst_0
    //   240: lstore_3
    //   241: iconst_0
    //   242: istore_2
    //   243: aload #15
    //   245: ldc 'Expires'
    //   247: invokeinterface get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   252: checkcast java/lang/String
    //   255: astore #16
    //   257: aload #16
    //   259: ifnull -> 272
    //   262: aload #16
    //   264: invokestatic a : (Ljava/lang/String;)J
    //   267: lstore #11
    //   269: goto -> 275
    //   272: lconst_0
    //   273: lstore #11
    //   275: aload #15
    //   277: ldc 'Last-Modified'
    //   279: invokeinterface get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   284: checkcast java/lang/String
    //   287: astore #16
    //   289: aload #16
    //   291: ifnull -> 304
    //   294: aload #16
    //   296: invokestatic a : (Ljava/lang/String;)J
    //   299: lstore #9
    //   301: goto -> 307
    //   304: lconst_0
    //   305: lstore #9
    //   307: aload #15
    //   309: ldc 'ETag'
    //   311: invokeinterface get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   316: checkcast java/lang/String
    //   319: astore #16
    //   321: iload_2
    //   322: ifeq -> 371
    //   325: lload #13
    //   327: lload #5
    //   329: ldc2_w 1000
    //   332: lmul
    //   333: ladd
    //   334: lstore #5
    //   336: iload_1
    //   337: ifeq -> 346
    //   340: lload #5
    //   342: lstore_3
    //   343: goto -> 404
    //   346: lload_3
    //   347: invokestatic signum : (J)I
    //   350: pop
    //   351: lload_3
    //   352: ldc2_w 1000
    //   355: lmul
    //   356: lload #5
    //   358: ladd
    //   359: lstore #11
    //   361: lload #5
    //   363: lstore_3
    //   364: lload #11
    //   366: lstore #5
    //   368: goto -> 407
    //   371: lload #7
    //   373: lconst_0
    //   374: lcmp
    //   375: ifle -> 402
    //   378: lload #11
    //   380: lload #7
    //   382: lcmp
    //   383: iflt -> 402
    //   386: lload #11
    //   388: lload #7
    //   390: lsub
    //   391: lload #13
    //   393: ladd
    //   394: lstore #5
    //   396: lload #5
    //   398: lstore_3
    //   399: goto -> 407
    //   402: lconst_0
    //   403: lstore_3
    //   404: lload_3
    //   405: lstore #5
    //   407: new com/bytedance/sdk/adnet/face/a$a
    //   410: dup
    //   411: invokespecial <init> : ()V
    //   414: astore #17
    //   416: aload #17
    //   418: aload_0
    //   419: getfield a : I
    //   422: putfield a : I
    //   425: aload #17
    //   427: aload_0
    //   428: getfield b : [B
    //   431: putfield b : [B
    //   434: aload #17
    //   436: aload #16
    //   438: putfield c : Ljava/lang/String;
    //   441: aload #17
    //   443: lload_3
    //   444: putfield g : J
    //   447: aload #17
    //   449: lload #5
    //   451: putfield f : J
    //   454: aload #17
    //   456: lload #7
    //   458: putfield d : J
    //   461: aload #17
    //   463: lload #9
    //   465: putfield e : J
    //   468: aload #17
    //   470: aload #15
    //   472: putfield h : Ljava/util/Map;
    //   475: aload #17
    //   477: aload_0
    //   478: getfield d : Ljava/util/List;
    //   481: putfield i : Ljava/util/List;
    //   484: aload #17
    //   486: areturn
    //   487: astore #17
    //   489: lload #5
    //   491: lstore #9
    //   493: lload_3
    //   494: lstore #11
    //   496: goto -> 215
    // Exception table:
    //   from	to	target	type
    //   132	144	487	java/lang/Exception
    //   160	172	487	java/lang/Exception
  }
  
  public static String a(long paramLong) {
    return a().format(new Date(paramLong));
  }
  
  public static String a(Map<String, String> paramMap) {
    return a(paramMap, "UTF-8");
  }
  
  public static String a(Map<String, String> paramMap, String paramString) {
    String str = paramMap.get("Content-Type");
    if (str != null) {
      String[] arrayOfString = str.split(";", 0);
      for (int i = 1; i < arrayOfString.length; i++) {
        String[] arrayOfString1 = arrayOfString[i].trim().split("=", 0);
        if (arrayOfString1.length == 2 && arrayOfString1[0].equals("charset"))
          return arrayOfString1[1]; 
      } 
    } 
    return paramString;
  }
  
  private static SimpleDateFormat a() {
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss zzz", Locale.US);
    simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
    return simpleDateFormat;
  }
  
  public static Map<String, String> a(List<Header> paramList) {
    TreeMap<String, Object> treeMap = new TreeMap<String, Object>(String.CASE_INSENSITIVE_ORDER);
    if (paramList != null)
      for (Header header : paramList)
        treeMap.put(header.a(), header.b());  
    return (Map)treeMap;
  }
  
  public static List<Header> b(Map<String, String> paramMap) {
    if (paramMap == null)
      return new ArrayList<Header>(); 
    ArrayList<Header> arrayList = new ArrayList(paramMap.size());
    for (Map.Entry<String, String> entry : paramMap.entrySet())
      arrayList.add(new Header((String)entry.getKey(), (String)entry.getValue())); 
    return arrayList;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\adnet\d\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */