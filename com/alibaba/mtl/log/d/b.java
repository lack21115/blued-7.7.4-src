package com.alibaba.mtl.log.d;

import com.alibaba.mtl.log.a.a;
import com.alibaba.mtl.log.e.a;
import com.alibaba.mtl.log.e.e;
import com.alibaba.mtl.log.e.i;
import com.alibaba.mtl.log.e.l;
import com.alibaba.mtl.log.e.n;
import com.alibaba.mtl.log.model.a;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.GZIPOutputStream;

public abstract class b implements Runnable {
  static int A = 0;
  
  private static volatile boolean E = false;
  
  private static boolean F = false;
  
  int B = -1;
  
  int C = 0;
  
  float a = 200.0F;
  
  private void M() {
    // Byte code:
    //   0: invokestatic isConnected : ()Z
    //   3: ifne -> 7
    //   6: return
    //   7: getstatic com/alibaba/mtl/log/d/b.F : Z
    //   10: ifeq -> 14
    //   13: return
    //   14: getstatic com/alibaba/mtl/log/d/b.E : Z
    //   17: ifne -> 759
    //   20: iconst_1
    //   21: putstatic com/alibaba/mtl/log/d/b.E : Z
    //   24: invokestatic a : ()Lcom/alibaba/mtl/log/a/d;
    //   27: invokevirtual b : ()Ljava/util/Map;
    //   30: astore #16
    //   32: iconst_0
    //   33: istore_1
    //   34: iconst_0
    //   35: istore_2
    //   36: iload_2
    //   37: iconst_3
    //   38: if_icmpge -> 752
    //   41: invokestatic getContext : ()Landroid/content/Context;
    //   44: invokestatic c : (Landroid/content/Context;)Z
    //   47: ifne -> 67
    //   50: ldc 'UploadTask'
    //   52: iconst_1
    //   53: anewarray java/lang/Object
    //   56: dup
    //   57: iconst_0
    //   58: ldc 'Other Process is Uploading, break'
    //   60: aastore
    //   61: invokestatic a : (Ljava/lang/String;[Ljava/lang/Object;)V
    //   64: goto -> 752
    //   67: invokestatic a : ()Lcom/alibaba/mtl/log/c/c;
    //   70: invokevirtual G : ()V
    //   73: aload #16
    //   75: ifnull -> 306
    //   78: aload #16
    //   80: invokeinterface size : ()I
    //   85: ifle -> 306
    //   88: aconst_null
    //   89: astore #13
    //   91: iload_1
    //   92: aload #16
    //   94: invokeinterface size : ()I
    //   99: if_icmpge -> 300
    //   102: new java/lang/StringBuilder
    //   105: dup
    //   106: invokespecial <init> : ()V
    //   109: astore #13
    //   111: aload #13
    //   113: iload_1
    //   114: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   117: pop
    //   118: aload #13
    //   120: ldc ''
    //   122: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   125: pop
    //   126: aload #16
    //   128: aload #13
    //   130: invokevirtual toString : ()Ljava/lang/String;
    //   133: invokeinterface get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   138: checkcast com/alibaba/mtl/log/a/c
    //   141: astore #14
    //   143: aload #14
    //   145: getfield a : Ljava/util/ArrayList;
    //   148: ifnull -> 256
    //   151: aload #14
    //   153: getfield a : Ljava/util/ArrayList;
    //   156: invokevirtual size : ()I
    //   159: ifle -> 256
    //   162: new java/lang/StringBuilder
    //   165: dup
    //   166: invokespecial <init> : ()V
    //   169: astore #13
    //   171: aload #13
    //   173: ldc 'eventId'
    //   175: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   178: pop
    //   179: aload #13
    //   181: ldc ' in ('
    //   183: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   186: pop
    //   187: iconst_0
    //   188: istore_3
    //   189: iload_3
    //   190: aload #14
    //   192: getfield a : Ljava/util/ArrayList;
    //   195: invokevirtual size : ()I
    //   198: if_icmpge -> 238
    //   201: iload_3
    //   202: ifeq -> 213
    //   205: aload #13
    //   207: ldc ' , '
    //   209: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   212: pop
    //   213: aload #13
    //   215: aload #14
    //   217: getfield a : Ljava/util/ArrayList;
    //   220: iload_3
    //   221: invokevirtual get : (I)Ljava/lang/Object;
    //   224: checkcast java/lang/String
    //   227: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   230: pop
    //   231: iload_3
    //   232: iconst_1
    //   233: iadd
    //   234: istore_3
    //   235: goto -> 189
    //   238: aload #13
    //   240: ldc ' ) '
    //   242: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   245: pop
    //   246: aload #13
    //   248: invokevirtual toString : ()Ljava/lang/String;
    //   251: astore #13
    //   253: goto -> 259
    //   256: aconst_null
    //   257: astore #13
    //   259: invokestatic a : ()Lcom/alibaba/mtl/log/c/c;
    //   262: aload #13
    //   264: aload_0
    //   265: invokespecial h : ()I
    //   268: invokevirtual a : (Ljava/lang/String;I)Ljava/util/List;
    //   271: astore #13
    //   273: aload #13
    //   275: invokeinterface size : ()I
    //   280: ifle -> 293
    //   283: aload #14
    //   285: getfield Q : Ljava/lang/String;
    //   288: astore #14
    //   290: goto -> 313
    //   293: iload_1
    //   294: iconst_1
    //   295: iadd
    //   296: istore_1
    //   297: goto -> 91
    //   300: aconst_null
    //   301: astore #14
    //   303: goto -> 313
    //   306: aconst_null
    //   307: astore #14
    //   309: aload #14
    //   311: astore #13
    //   313: aload #13
    //   315: ifnull -> 341
    //   318: aload #13
    //   320: astore #15
    //   322: aload #13
    //   324: ifnull -> 354
    //   327: aload #13
    //   329: astore #15
    //   331: aload #13
    //   333: invokeinterface size : ()I
    //   338: ifne -> 354
    //   341: invokestatic a : ()Lcom/alibaba/mtl/log/c/c;
    //   344: aconst_null
    //   345: aload_0
    //   346: invokespecial h : ()I
    //   349: invokevirtual a : (Ljava/lang/String;I)Ljava/util/List;
    //   352: astore #15
    //   354: aload #15
    //   356: ifnull -> 748
    //   359: aload #15
    //   361: invokeinterface size : ()I
    //   366: ifne -> 372
    //   369: goto -> 748
    //   372: aload_0
    //   373: aload #15
    //   375: invokespecial b : (Ljava/util/List;)I
    //   378: istore_3
    //   379: aload_0
    //   380: aload #15
    //   382: invokespecial a : (Ljava/util/List;)Ljava/util/Map;
    //   385: astore #17
    //   387: aload #17
    //   389: ifnull -> 741
    //   392: aload #17
    //   394: invokeinterface size : ()I
    //   399: ifne -> 405
    //   402: goto -> 741
    //   405: invokestatic elapsedRealtime : ()J
    //   408: lstore #7
    //   410: getstatic com/alibaba/mtl/log/a/a.M : Ljava/lang/String;
    //   413: astore #13
    //   415: aload #14
    //   417: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   420: ifne -> 463
    //   423: new java/lang/StringBuilder
    //   426: dup
    //   427: invokespecial <init> : ()V
    //   430: astore #13
    //   432: aload #13
    //   434: ldc 'http://'
    //   436: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   439: pop
    //   440: aload #13
    //   442: aload #14
    //   444: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   447: pop
    //   448: aload #13
    //   450: ldc '/rest/sur'
    //   452: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   455: pop
    //   456: aload #13
    //   458: invokevirtual toString : ()Ljava/lang/String;
    //   461: astore #13
    //   463: aload_0
    //   464: aload #13
    //   466: aconst_null
    //   467: aload #17
    //   469: invokestatic a : (Ljava/lang/String;Ljava/util/Map;Ljava/util/Map;)Ljava/lang/String;
    //   472: aload #17
    //   474: invokespecial a : (Ljava/lang/String;Ljava/util/Map;)Lcom/alibaba/mtl/log/e/a$a;
    //   477: astore #13
    //   479: aload #13
    //   481: getfield G : Z
    //   484: istore #11
    //   486: invokestatic elapsedRealtime : ()J
    //   489: lstore #5
    //   491: lload #5
    //   493: lload #7
    //   495: lsub
    //   496: lstore #7
    //   498: aload_0
    //   499: iload #11
    //   501: invokestatic valueOf : (Z)Ljava/lang/Boolean;
    //   504: lload #7
    //   506: invokespecial a : (Ljava/lang/Boolean;J)I
    //   509: pop
    //   510: iload #11
    //   512: ifeq -> 556
    //   515: invokestatic a : ()Lcom/alibaba/mtl/log/c/c;
    //   518: aload #15
    //   520: invokevirtual a : (Ljava/util/List;)I
    //   523: istore #4
    //   525: iload #4
    //   527: aload #15
    //   529: invokeinterface size : ()I
    //   534: iload_3
    //   535: isub
    //   536: if_icmpge -> 543
    //   539: aload_0
    //   540: invokevirtual L : ()V
    //   543: aload #15
    //   545: iload #4
    //   547: invokestatic a : (Ljava/util/List;I)V
    //   550: invokestatic t : ()V
    //   553: goto -> 604
    //   556: aload #15
    //   558: invokeinterface size : ()I
    //   563: iload_3
    //   564: isub
    //   565: invokestatic d : (I)V
    //   568: invokestatic u : ()V
    //   571: aload #13
    //   573: invokevirtual i : ()Z
    //   576: istore #12
    //   578: iload #12
    //   580: ifeq -> 589
    //   583: invokestatic release : ()V
    //   586: goto -> 752
    //   589: aload #13
    //   591: invokevirtual j : ()Z
    //   594: ifeq -> 604
    //   597: iconst_1
    //   598: putstatic com/alibaba/mtl/log/d/b.F : Z
    //   601: goto -> 583
    //   604: invokestatic elapsedRealtime : ()J
    //   607: lstore #9
    //   609: ldc 'UploadTask'
    //   611: iconst_4
    //   612: anewarray java/lang/Object
    //   615: dup
    //   616: iconst_0
    //   617: ldc 'logs.size():'
    //   619: aastore
    //   620: dup
    //   621: iconst_1
    //   622: aload #15
    //   624: invokeinterface size : ()I
    //   629: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   632: aastore
    //   633: dup
    //   634: iconst_2
    //   635: ldc ' selfMonitorLogCount:'
    //   637: aastore
    //   638: dup
    //   639: iconst_3
    //   640: iload_3
    //   641: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   644: aastore
    //   645: invokestatic a : (Ljava/lang/String;[Ljava/lang/Object;)V
    //   648: ldc 'UploadTask'
    //   650: bipush #6
    //   652: anewarray java/lang/Object
    //   655: dup
    //   656: iconst_0
    //   657: ldc 'upload isSendSuccess:'
    //   659: aastore
    //   660: dup
    //   661: iconst_1
    //   662: iload #11
    //   664: invokestatic valueOf : (Z)Ljava/lang/Boolean;
    //   667: aastore
    //   668: dup
    //   669: iconst_2
    //   670: ldc ' consume:'
    //   672: aastore
    //   673: dup
    //   674: iconst_3
    //   675: lload #7
    //   677: invokestatic valueOf : (J)Ljava/lang/Long;
    //   680: aastore
    //   681: dup
    //   682: iconst_4
    //   683: ldc ' delete consume:'
    //   685: aastore
    //   686: dup
    //   687: iconst_5
    //   688: lload #9
    //   690: lload #5
    //   692: lsub
    //   693: invokestatic valueOf : (J)Ljava/lang/Long;
    //   696: aastore
    //   697: invokestatic a : (Ljava/lang/String;[Ljava/lang/Object;)V
    //   700: new java/util/Random
    //   703: dup
    //   704: invokespecial <init> : ()V
    //   707: sipush #5000
    //   710: invokevirtual nextInt : (I)I
    //   713: i2l
    //   714: invokestatic sleep : (J)V
    //   717: goto -> 731
    //   720: astore #13
    //   722: ldc 'UploadTask'
    //   724: ldc 'thread sleep interrupted'
    //   726: aload #13
    //   728: invokestatic a : (Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Throwable;)V
    //   731: invokestatic release : ()V
    //   734: iload_2
    //   735: iconst_1
    //   736: iadd
    //   737: istore_2
    //   738: goto -> 36
    //   741: iconst_0
    //   742: putstatic com/alibaba/mtl/log/d/b.E : Z
    //   745: goto -> 752
    //   748: iconst_0
    //   749: putstatic com/alibaba/mtl/log/d/b.E : Z
    //   752: iconst_0
    //   753: putstatic com/alibaba/mtl/log/d/b.E : Z
    //   756: invokestatic release : ()V
    //   759: return
    //   760: astore #13
    //   762: goto -> 731
    // Exception table:
    //   from	to	target	type
    //   405	415	760	finally
    //   415	463	760	finally
    //   463	491	760	finally
    //   498	510	760	finally
    //   515	543	760	finally
    //   543	553	760	finally
    //   556	578	760	finally
    //   589	601	760	finally
    //   604	700	760	finally
    //   700	717	720	finally
    //   722	731	760	finally
  }
  
  private int a(Boolean paramBoolean, long paramLong) {
    if (paramLong < 0L)
      return this.B; 
    float f = this.C / (float)paramLong;
    if (paramBoolean.booleanValue()) {
      if (paramLong > 45000L)
        return this.B; 
      this.B = (int)((f * 45000.0F) / this.a - A);
    } else {
      this.B /= 2;
      A++;
    } 
    int i = this.B;
    if (i < 1) {
      this.B = 1;
      A = 0;
    } else if (i > 350) {
      this.B = 350;
    } 
    i.a("UploadTask", new Object[] { "winsize:", Integer.valueOf(this.B) });
    return this.B;
  }
  
  private a.a a(String paramString, Map<String, Object> paramMap) {
    if (paramString != null) {
      byte[] arrayOfByte = (e.a(2, paramString, paramMap, false)).e;
      i.a("UploadTask", new Object[] { "url:", paramString });
      if (arrayOfByte != null) {
        paramString = null;
        try {
          String str = new String(arrayOfByte, "UTF-8");
          paramString = str;
        } catch (UnsupportedEncodingException unsupportedEncodingException) {
          unsupportedEncodingException.printStackTrace();
        } 
        if (paramString != null) {
          i.a("UploadTask", new Object[] { "result:", paramString });
          return a.a(paramString);
        } 
      } 
    } 
    return a.a.a;
  }
  
  private List<String> a(a parama) {
    return a.a(parama.T);
  }
  
  private Map<String, Object> a(List<a> paramList) {
    if (paramList == null || paramList.size() == 0)
      return null; 
    HashMap<Object, Object> hashMap2 = new HashMap<Object, Object>();
    for (int i = 0; i < paramList.size(); i++) {
      List<String> list = a(paramList.get(i));
      if (list != null)
        for (int j = 0; j < list.size(); j++) {
          StringBuilder stringBuilder = (StringBuilder)hashMap2.get(list.get(j));
          if (stringBuilder == null) {
            stringBuilder = new StringBuilder();
            hashMap2.put(list.get(j), stringBuilder);
          } else {
            stringBuilder.append("\n");
          } 
          stringBuilder.append(((a)paramList.get(i)).h());
        }  
    } 
    HashMap<Object, Object> hashMap1 = new HashMap<Object, Object>();
    this.C = 0;
    for (String str : hashMap2.keySet()) {
      byte[] arrayOfByte = a(((StringBuilder)hashMap2.get(str)).toString());
      hashMap1.put(str, arrayOfByte);
      this.C += arrayOfByte.length;
    } 
    this.a = this.C / paramList.size();
    i.a("UploadTask", new Object[] { "averagePackageSize:", Float.valueOf(this.a) });
    return (Map)hashMap1;
  }
  
  private byte[] a(String paramString) {
    IOException iOException2;
    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
    String str2 = null;
    iOException1 = null;
    try {
      GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
    } catch (IOException null) {
    
    } finally {
      paramString = null;
    } 
    String str1 = paramString;
    iOException2.printStackTrace();
    if (paramString != null)
      paramString.close(); 
    byte[] arrayOfByte = n.a(byteArrayOutputStream.toByteArray(), "QrMgt8GGYI6T52ZY5AnhtxkLzb8egpFn3j5JELI8H6wtACbUnZ5cc3aYTsTRbmkAkRJeYbtx92LPBWm7nBO9UIl7y5i5MQNmUZNf5QENurR5tGyo7yJ2G0MBjWvy6iAtlAbacKP0SwOUeUWx5dsBdyhxa7Id1APtybSdDgicBDuNjI0mlZFUzZSS9dmN8lBD0WTVOMz0pRZbR3cysomRXOO1ghqjJdTcyDIxzpNAEszN8RMGjrzyU7Hjbmwi6YNK");
    try {
      byteArrayOutputStream.close();
      return arrayOfByte;
    } catch (Exception exception) {
      return arrayOfByte;
    } 
  }
  
  private int b(List<a> paramList) {
    int i = 0;
    if (paramList == null)
      return 0; 
    int j;
    for (j = 0; i < paramList.size(); j = k) {
      String str = ((a)paramList.get(i)).T;
      int k = j;
      if (str != null) {
        k = j;
        if ("6005".equalsIgnoreCase(str.toString()))
          k = j + 1; 
      } 
      i++;
    } 
    return j;
  }
  
  private int h() {
    if (this.B == -1) {
      String str = l.u();
      if ("wifi".equalsIgnoreCase(str)) {
        this.B = 20;
      } else if ("4G".equalsIgnoreCase(str)) {
        this.B = 16;
      } else if ("3G".equalsIgnoreCase(str)) {
        this.B = 12;
      } else {
        this.B = 8;
      } 
    } 
    return this.B;
  }
  
  public static boolean isRunning() {
    return E;
  }
  
  public abstract void K();
  
  public abstract void L();
  
  public void run() {
    try {
      M();
      return;
    } finally {
      Exception exception = null;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\alibaba\mtl\log\d\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */