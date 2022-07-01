package com.ishumei.l111l11111Il;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Build;
import android.text.TextUtils;
import com.ishumei.l1111l111111Il.l111l1111llIl;
import com.ishumei.l111l1111llIl.l111l1111l1Il;
import com.ishumei.l111l1111llIl.l111l1111lI1l;
import java.io.ByteArrayInputStream;
import java.io.RandomAccessFile;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class l111l11111lIl {
  private static final String l1111l111111Il = l111l1111lI1l.l111l11111Il("9a878f");
  
  private static final String l111l11111I1l;
  
  private static final String l111l11111Il;
  
  private static final String l111l11111lIl = l111l1111lI1l.l111l11111Il("9e8f94ac969891b79e8c97bc909b9a");
  
  static {
    l111l11111I1l = l111l1111lI1l.l111l11111Il("9e8f94af9e8b97");
    l111l11111Il = l111l1111lI1l.l111l11111Il("8c969891969198b6919990");
  }
  
  public static int l1111l111111Il() {
    Context context = l111l1111llIl.l1111l111111Il.l111l11111Il;
    return (context == null) ? 0 : (context.getApplicationInfo()).targetSdkVersion;
  }
  
  public static l1111l111111Il l1111l111111Il(Map<String, com.ishumei.l111l11111lIl.l111l11111lIl.l111l11111Il> paramMap, int paramInt1, int paramInt2) {
    // Byte code:
    //   0: new com/ishumei/l111l11111Il/l111l11111lIl$l1111l111111Il
    //   3: dup
    //   4: invokespecial <init> : ()V
    //   7: astore #15
    //   9: getstatic com/ishumei/l1111l111111Il/l111l1111llIl$l1111l111111Il.l111l11111Il : Landroid/content/Context;
    //   12: astore #12
    //   14: aload #12
    //   16: ifnonnull -> 22
    //   19: aload #15
    //   21: areturn
    //   22: new java/util/ArrayList
    //   25: dup
    //   26: invokespecial <init> : ()V
    //   29: astore #16
    //   31: new java/util/HashMap
    //   34: dup
    //   35: invokespecial <init> : ()V
    //   38: astore #17
    //   40: new java/util/HashMap
    //   43: dup
    //   44: invokespecial <init> : ()V
    //   47: astore #13
    //   49: aload_0
    //   50: ifnull -> 123
    //   53: aload_0
    //   54: invokeinterface entrySet : ()Ljava/util/Set;
    //   59: invokeinterface iterator : ()Ljava/util/Iterator;
    //   64: astore_0
    //   65: aload_0
    //   66: invokeinterface hasNext : ()Z
    //   71: ifeq -> 123
    //   74: aload_0
    //   75: invokeinterface next : ()Ljava/lang/Object;
    //   80: checkcast java/util/Map$Entry
    //   83: astore #14
    //   85: aload #14
    //   87: invokeinterface getKey : ()Ljava/lang/Object;
    //   92: checkcast java/lang/String
    //   95: astore #18
    //   97: aload #13
    //   99: aload #14
    //   101: invokeinterface getValue : ()Ljava/lang/Object;
    //   106: checkcast com/ishumei/l111l11111lIl/l111l11111lIl$l111l11111Il
    //   109: invokevirtual l111l11111lIl : ()Ljava/lang/String;
    //   112: aload #18
    //   114: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   119: pop
    //   120: goto -> 65
    //   123: aload #12
    //   125: invokevirtual getPackageManager : ()Landroid/content/pm/PackageManager;
    //   128: astore #12
    //   130: aload #12
    //   132: ifnull -> 549
    //   135: aload #12
    //   137: ldc '989a8bb6918c8b9e93939a9baf9e9c949e989a8c'
    //   139: invokestatic l111l11111Il : (Ljava/lang/String;)Ljava/lang/String;
    //   142: iconst_1
    //   143: anewarray java/lang/Class
    //   146: dup
    //   147: iconst_0
    //   148: getstatic java/lang/Integer.TYPE : Ljava/lang/Class;
    //   151: aastore
    //   152: iconst_1
    //   153: anewarray java/lang/Object
    //   156: dup
    //   157: iconst_0
    //   158: iconst_0
    //   159: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   162: aastore
    //   163: invokestatic l1111l111111Il : (Ljava/lang/Object;Ljava/lang/String;[Ljava/lang/Class;[Ljava/lang/Object;)Ljava/lang/Object;
    //   166: checkcast java/util/List
    //   169: astore_0
    //   170: aload_0
    //   171: new com/ishumei/l111l11111Il/l111l11111lIl$1
    //   174: dup
    //   175: invokespecial <init> : ()V
    //   178: invokestatic sort : (Ljava/util/List;Ljava/util/Comparator;)V
    //   181: iconst_0
    //   182: istore #5
    //   184: iconst_0
    //   185: istore_3
    //   186: iconst_0
    //   187: istore #6
    //   189: iload #5
    //   191: aload_0
    //   192: invokeinterface size : ()I
    //   197: if_icmpge -> 532
    //   200: aload_0
    //   201: iload #5
    //   203: invokeinterface get : (I)Ljava/lang/Object;
    //   208: checkcast android/content/pm/PackageInfo
    //   211: astore #19
    //   213: aload #19
    //   215: getfield packageName : Ljava/lang/String;
    //   218: astore #18
    //   220: aload #19
    //   222: getfield applicationInfo : Landroid/content/pm/ApplicationInfo;
    //   225: astore #14
    //   227: aload #14
    //   229: getfield flags : I
    //   232: istore #4
    //   234: iload #4
    //   236: iconst_1
    //   237: iand
    //   238: ifgt -> 570
    //   241: iload #4
    //   243: sipush #128
    //   246: iand
    //   247: istore #4
    //   249: iload #4
    //   251: ifgt -> 570
    //   254: iload #4
    //   256: ifne -> 570
    //   259: iconst_1
    //   260: istore #7
    //   262: goto -> 265
    //   265: iload #7
    //   267: iconst_1
    //   268: if_icmpne -> 286
    //   271: aload #15
    //   273: aload #15
    //   275: getfield l111l11111lIl : I
    //   278: iconst_1
    //   279: iadd
    //   280: putfield l111l11111lIl : I
    //   283: goto -> 298
    //   286: aload #15
    //   288: aload #15
    //   290: getfield l1111l111111Il : I
    //   293: iconst_1
    //   294: iadd
    //   295: putfield l1111l111111Il : I
    //   298: aload #13
    //   300: aload #18
    //   302: invokeinterface containsKey : (Ljava/lang/Object;)Z
    //   307: ifeq -> 576
    //   310: aload #17
    //   312: aload #13
    //   314: aload #18
    //   316: invokeinterface get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   321: checkcast java/lang/String
    //   324: iconst_1
    //   325: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   328: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   333: pop
    //   334: iload_3
    //   335: istore #4
    //   337: goto -> 592
    //   340: iload #6
    //   342: iconst_1
    //   343: iadd
    //   344: istore #6
    //   346: getstatic android/os/Build$VERSION.SDK_INT : I
    //   349: bipush #29
    //   351: if_icmplt -> 361
    //   354: ldc ''
    //   356: astore #14
    //   358: goto -> 375
    //   361: aload #14
    //   363: aload #12
    //   365: invokevirtual loadLabel : (Landroid/content/pm/PackageManager;)Ljava/lang/CharSequence;
    //   368: invokeinterface toString : ()Ljava/lang/String;
    //   373: astore #14
    //   375: aload #19
    //   377: getfield firstInstallTime : J
    //   380: lstore #8
    //   382: aload #19
    //   384: getfield versionName : Ljava/lang/String;
    //   387: astore #20
    //   389: aload #19
    //   391: getfield versionCode : I
    //   394: istore #4
    //   396: aload #19
    //   398: getfield lastUpdateTime : J
    //   401: lstore #10
    //   403: new java/lang/StringBuilder
    //   406: dup
    //   407: invokespecial <init> : ()V
    //   410: astore #19
    //   412: aload #19
    //   414: lload #8
    //   416: invokevirtual append : (J)Ljava/lang/StringBuilder;
    //   419: pop
    //   420: aload #19
    //   422: ldc ','
    //   424: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   427: pop
    //   428: aload #19
    //   430: aload #18
    //   432: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   435: pop
    //   436: aload #19
    //   438: ldc ','
    //   440: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   443: pop
    //   444: aload #19
    //   446: aload #14
    //   448: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   451: pop
    //   452: aload #19
    //   454: ldc ','
    //   456: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   459: pop
    //   460: aload #19
    //   462: iload #7
    //   464: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   467: pop
    //   468: aload #19
    //   470: ldc ','
    //   472: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   475: pop
    //   476: aload #19
    //   478: iload #4
    //   480: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   483: pop
    //   484: aload #19
    //   486: ldc ','
    //   488: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   491: pop
    //   492: aload #19
    //   494: aload #20
    //   496: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   499: pop
    //   500: aload #19
    //   502: ldc ','
    //   504: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   507: pop
    //   508: aload #19
    //   510: lload #10
    //   512: invokevirtual append : (J)Ljava/lang/StringBuilder;
    //   515: pop
    //   516: aload #16
    //   518: aload #19
    //   520: invokevirtual toString : ()Ljava/lang/String;
    //   523: invokeinterface add : (Ljava/lang/Object;)Z
    //   528: pop
    //   529: goto -> 623
    //   532: aload #15
    //   534: aload #16
    //   536: putfield l111l11111I1l : Ljava/util/List;
    //   539: aload #15
    //   541: aload #17
    //   543: putfield l111l11111Il : Ljava/util/Map;
    //   546: aload #15
    //   548: areturn
    //   549: new java/lang/Exception
    //   552: dup
    //   553: invokespecial <init> : ()V
    //   556: athrow
    //   557: astore_0
    //   558: aload #15
    //   560: aload_0
    //   561: invokestatic getStackTraceString : (Ljava/lang/Throwable;)Ljava/lang/String;
    //   564: putfield l111l1111l1Il : Ljava/lang/String;
    //   567: aload #15
    //   569: areturn
    //   570: iconst_0
    //   571: istore #7
    //   573: goto -> 265
    //   576: iload #7
    //   578: ifne -> 598
    //   581: iload_3
    //   582: istore #4
    //   584: iload_3
    //   585: iload_1
    //   586: if_icmpge -> 592
    //   589: goto -> 598
    //   592: iload #4
    //   594: istore_3
    //   595: goto -> 623
    //   598: iload_3
    //   599: iconst_1
    //   600: iadd
    //   601: istore_3
    //   602: iload #7
    //   604: iconst_1
    //   605: if_icmpne -> 620
    //   608: iload_3
    //   609: istore #4
    //   611: iload #6
    //   613: iload_2
    //   614: if_icmpge -> 592
    //   617: goto -> 340
    //   620: goto -> 340
    //   623: iload #5
    //   625: iconst_1
    //   626: iadd
    //   627: istore #5
    //   629: goto -> 189
    // Exception table:
    //   from	to	target	type
    //   123	130	557	java/lang/Exception
    //   135	181	557	java/lang/Exception
    //   189	234	557	java/lang/Exception
    //   271	283	557	java/lang/Exception
    //   286	298	557	java/lang/Exception
    //   298	334	557	java/lang/Exception
    //   346	354	557	java/lang/Exception
    //   361	375	557	java/lang/Exception
    //   375	529	557	java/lang/Exception
    //   532	546	557	java/lang/Exception
    //   549	557	557	java/lang/Exception
  }
  
  public static String l1111l111111Il(Object paramObject) {
    if (paramObject == null)
      return ""; 
    try {
      paramObject = l111l1111l1Il.l1111l111111Il(paramObject, l111l1111lI1l.l111l11111Il("8b90bd868b9abe8d8d9e86"));
      return ((X509Certificate)CertificateFactory.getInstance("X.509").generateCertificate(new ByteArrayInputStream((byte[])paramObject))).getSubjectDN().toString();
    } catch (Exception exception) {
      return "";
    } 
  }
  
  private static void l1111l111111Il(Map<String, Object> paramMap) {
    Context context = l111l1111llIl.l1111l111111Il.l111l11111Il;
    if (context == null)
      return; 
    try {
      if (Build.VERSION.SDK_INT >= 28) {
        Signature[] arrayOfSignature = (context.getPackageManager().getPackageInfo(context.getPackageName(), 134217728)).signingInfo.getApkContentsSigners();
        ArrayList<Integer> arrayList = new ArrayList();
        int j = arrayOfSignature.length;
        for (int i = 0; i < j; i++)
          arrayList.add(Integer.valueOf(arrayOfSignature[i].hashCode())); 
        paramMap.put(l111l11111Il, arrayList);
      } 
      return;
    } catch (android.content.pm.PackageManager.NameNotFoundException nameNotFoundException) {
      nameNotFoundException.printStackTrace();
      return;
    } 
  }
  
  private static void l1111l111111Il(Map<String, Object> paramMap, String paramString) {
    if (TextUtils.isEmpty(paramString)) {
      paramMap.put(l1111l111111Il, l111l1111lI1l.l111l11111Il("9e8f94af9e8b97df968cdf918a9393"));
      return;
    } 
    paramMap.put(l111l11111I1l, paramString);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(l111l1111lI1l.l111l11111Il("d09b9e8b9ed09e8f8fd0"));
    stringBuilder.append(l111l11111I1l());
    if (!paramString.startsWith(stringBuilder.toString())) {
      String str = l1111l111111Il;
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append(l111l1111lI1l.l111l11111Il("9e8f94af9e8b97df968cdf91908bdf8c8b9e8d8bdf88968b97dfd8d09b9e8b9ed09e8f8fd0"));
      stringBuilder1.append(l111l11111I1l());
      stringBuilder1.append("'");
      paramMap.put(str, stringBuilder1.toString());
    } 
    try {
      RandomAccessFile randomAccessFile = new RandomAccessFile(paramString, "r");
      return;
    } finally {
      paramString = null;
      paramMap.put(l1111l111111Il, paramString.getMessage());
    } 
  }
  
  private static Object[] l1111l111111Il(String paramString) {
    Context context = l111l1111llIl.l1111l111111Il.l111l11111Il;
    if (context == null)
      return null; 
    try {
      Object object = l111l1111l1Il.l1111l111111Il(context.getPackageManager(), l111l1111lI1l.l111l11111Il("989a8baf9e9c949e989ab6919990"), new Class[] { String.class, int.class }, new Object[] { paramString, Integer.valueOf(64) });
      if (object == null)
        return null; 
      object = l111l1111l1Il.l111l11111lIl(object, l111l1111lI1l.l111l11111Il("8c9698919e8b8a8d9a8c"));
      return null;
    } finally {
      paramString = null;
    } 
  }
  
  public static String l111l11111I1l() {
    Context context = l111l1111llIl.l1111l111111Il.l111l11111Il;
    if (context == null)
      return ""; 
    try {
      return (String)l111l1111l1Il.l1111l111111Il(context, l111l1111lI1l.l111l11111Il("989a8baf9e9c949e989ab19e929a"));
    } catch (Exception exception) {
      return "";
    } 
  }
  
  private static String l111l11111I1l(Object paramObject) {
    if (paramObject == null)
      return ""; 
    try {
      StringBuilder stringBuilder = new StringBuilder();
      paramObject = l111l1111l1Il.l1111l111111Il(paramObject, l111l1111lI1l.l111l11111Il("8b90bd868b9abe8d8d9e86"));
      String str1 = l111l1111lI1l.l111l11111Il("959e899ed18c9a9c8a8d968b86d1b29a8c8c9e989abb96989a8c8b");
      String str2 = l111l1111lI1l.l111l11111Il("989a8bb6918c8b9e919c9a");
      int i = 0;
      String str3 = l111l1111lI1l.l111l11111Il("b2bbca");
      Object object = l111l1111l1Il.l1111l111111Il(str1, str2, new Class[] { String.class }, (Object[])new String[] { str3 });
      l111l1111l1Il.l1111l111111Il(object, l111l1111lI1l.l111l11111Il("8d9a8c9a8b"));
      l111l1111l1Il.l1111l111111Il(object, l111l1111lI1l.l111l11111Il("8a8f9b9e8b9a"), new Class[] { byte[].class }, new Object[] { paramObject });
      paramObject = l111l1111l1Il.l1111l111111Il(object, l111l1111lI1l.l111l11111Il("9b96989a8c8b"));
      int j = paramObject.length;
      return stringBuilder.toString();
    } finally {
      paramObject = null;
    } 
  }
  
  public static Object l111l11111Il() {
    Context context = l111l1111llIl.l1111l111111Il.l111l11111Il;
    if (context == null)
      return null; 
    Object[] arrayOfObject = l1111l111111Il(context.getPackageName());
    return (arrayOfObject != null) ? ((arrayOfObject.length <= 0) ? null : arrayOfObject[0]) : null;
  }
  
  public static String l111l11111lIl() {
    Context context = l111l1111llIl.l1111l111111Il.l111l11111Il;
    if (context == null)
      return ""; 
    try {
      String str = (context.getPackageManager().getPackageInfo(l111l11111I1l(), 0)).versionName;
      return (str == null) ? "" : str;
    } catch (Exception exception) {
      return "";
    } 
  }
  
  private static String l111l11111lIl(String paramString) {
    return l111l1111lI1l.l111l11111Il(paramString);
  }
  
  private static List l111l11111lIl(Object paramObject) {
    return (List)l111l1111l1Il.l1111l111111Il(paramObject, l111l1111lI1l.l111l11111Il("989a8bb6918c8b9e93939a9baf9e9c949e989a8c"), new Class[] { int.class }, new Object[] { Integer.valueOf(0) });
  }
  
  public static Map<String, Object> l111l1111l1Il() {
    HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
    Context context = l111l1111llIl.l1111l111111Il.l111l11111Il;
    if (context == null) {
      hashMap.put(l1111l111111Il, l111l1111lI1l.l111l11111Il("9c8b87df968cdf918a9393"));
      return (Map)hashMap;
    } 
    String str = (context.getApplicationInfo()).sourceDir;
    if (TextUtils.isEmpty(str)) {
      hashMap.put(l1111l111111Il, l111l1111lI1l.l111l11111Il("9e8f94af9e8b97df968cdf918a9393"));
    } else {
      hashMap.put(l111l11111I1l, str);
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(l111l1111lI1l.l111l11111Il("d09b9e8b9ed09e8f8fd0"));
      stringBuilder.append(l111l11111I1l());
      if (!str.startsWith(stringBuilder.toString())) {
        String str1 = l1111l111111Il;
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append(l111l1111lI1l.l111l11111Il("9e8f94af9e8b97df968cdf91908bdf8c8b9e8d8bdf88968b97dfd8d09b9e8b9ed09e8f8fd0"));
        stringBuilder1.append(l111l11111I1l());
        stringBuilder1.append("'");
      } 
    } 
    l1111l111111Il((Map)hashMap);
    return (Map)hashMap;
  }
  
  public static int l111l1111llIl() {
    return (((l111l1111llIl.l1111l111111Il.l111l11111Il.getApplicationInfo()).flags & 0x2) > 0) ? 1 : 0;
  }
  
  public static final class l1111l111111Il {
    int l1111l111111Il = 0;
    
    public List<String> l111l11111I1l;
    
    Map<String, Object> l111l11111Il;
    
    int l111l11111lIl = 0;
    
    public String l111l1111l1Il;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\ishumei\l111l11111Il\l111l11111lIl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */