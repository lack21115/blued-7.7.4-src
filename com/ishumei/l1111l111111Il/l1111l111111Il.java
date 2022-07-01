package com.ishumei.l1111l111111Il;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import com.ishumei.l111l11111lIl.l111l11111lIl;
import com.ishumei.l111l1111llIl.l111l1111lI1l;
import com.ishumei.l111l1111llIl.l111l1111lIl;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class l1111l111111Il {
  private static int l1111l111111Il = 1;
  
  private static String l111l11111I1l;
  
  private static String l111l11111Il;
  
  private static int l111l11111lIl = 2;
  
  private static String l111l1111l1Il;
  
  private static String l111l1111lI1l;
  
  private static String l111l1111lIl;
  
  private static String l111l1111llIl;
  
  private static String l11l1111I11l;
  
  private static String l11l1111I1l;
  
  private static String l11l1111I1ll;
  
  private static String l11l1111Il;
  
  private static String l11l1111Il1l;
  
  private static String l11l1111Ill;
  
  private static String l11l1111lIIl;
  
  private static String l11l111l11Il;
  
  private static l1111l111111Il l11l111l1lll = null;
  
  private static String l11l11IlIIll;
  
  private String l111l11IlIlIl;
  
  public static l1111l111111Il l1111l111111Il() {
    // Byte code:
    //   0: getstatic com/ishumei/l1111l111111Il/l1111l111111Il.l11l111l1lll : Lcom/ishumei/l1111l111111Il/l1111l111111Il;
    //   3: ifnonnull -> 37
    //   6: ldc com/ishumei/l1111l111111Il/l1111l111111Il
    //   8: monitorenter
    //   9: getstatic com/ishumei/l1111l111111Il/l1111l111111Il.l11l111l1lll : Lcom/ishumei/l1111l111111Il/l1111l111111Il;
    //   12: ifnonnull -> 25
    //   15: new com/ishumei/l1111l111111Il/l1111l111111Il
    //   18: dup
    //   19: invokespecial <init> : ()V
    //   22: putstatic com/ishumei/l1111l111111Il/l1111l111111Il.l11l111l1lll : Lcom/ishumei/l1111l111111Il/l1111l111111Il;
    //   25: ldc com/ishumei/l1111l111111Il/l1111l111111Il
    //   27: monitorexit
    //   28: goto -> 37
    //   31: astore_0
    //   32: ldc com/ishumei/l1111l111111Il/l1111l111111Il
    //   34: monitorexit
    //   35: aload_0
    //   36: athrow
    //   37: getstatic com/ishumei/l1111l111111Il/l1111l111111Il.l11l111l1lll : Lcom/ishumei/l1111l111111Il/l1111l111111Il;
    //   40: areturn
    // Exception table:
    //   from	to	target	type
    //   9	25	31	finally
    //   25	28	31	finally
    //   32	35	31	finally
  }
  
  private static Map<String, Object> l1111l111111Il(Map<String, l111l11111lIl.l111l11111lIl> paramMap) {
    HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
    if (paramMap != null) {
      if (paramMap.size() == 0)
        return (Map)hashMap; 
      if (l111l1111llIl.l1111l111111Il.l111l11111Il == null)
        return (Map)hashMap; 
      PackageManager packageManager = l111l1111llIl.l1111l111111Il.l111l11111Il.getPackageManager();
      HashMap<Object, Object> hashMap1 = new HashMap<Object, Object>();
      Iterator<Map.Entry> iterator = paramMap.entrySet().iterator();
      while (true) {
        if (iterator.hasNext()) {
          Map.Entry entry = iterator.next();
          String str = (String)entry.getKey();
          l111l11111lIl.l111l11111lIl l111l11111lIl = (l111l11111lIl.l111l11111lIl)entry.getValue();
          hashMap1.put(l111l11111lIl.l111l11111lIl(), str);
          try {
            if (packageManager.getLaunchIntentForPackage(l111l11111lIl.l111l11111lIl()) != null)
              hashMap.put(str, Integer.valueOf(1)); 
            if (packageManager.getPackageInfo(l111l11111lIl.l111l11111lIl(), 0) != null)
              hashMap.put(str, Integer.valueOf(1)); 
            if (Build.VERSION.SDK_INT < 26) {
              Integer integer;
              StringBuilder stringBuilder = new StringBuilder("/data/app/");
              stringBuilder.append(l111l11111lIl.l111l11111lIl());
              stringBuilder.append("-1/");
              if ((new File(stringBuilder.toString())).exists()) {
                integer = Integer.valueOf(1);
              } else {
                stringBuilder = new StringBuilder("/data/app/");
                stringBuilder.append(integer.l111l11111lIl());
                stringBuilder.append("-2/");
                if ((new File(stringBuilder.toString())).exists()) {
                  integer = Integer.valueOf(1);
                } else {
                  continue;
                } 
              } 
              hashMap.put(str, integer);
            } 
          } catch (Exception exception) {}
          continue;
        } 
        try {
          List list = packageManager.getInstalledPackages(0);
          for (ApplicationInfo applicationInfo : packageManager.getInstalledApplications(0)) {
            if (hashMap1.containsKey(applicationInfo.packageName))
              hashMap.put(hashMap1.get(applicationInfo.packageName), Integer.valueOf(1)); 
          } 
          for (PackageInfo packageInfo : list) {
            if (hashMap1.containsKey(packageInfo.packageName))
              hashMap.put(hashMap1.get(packageInfo.packageName), Integer.valueOf(1)); 
          } 
          return (Map)hashMap;
        } catch (Exception exception) {
          return (Map)hashMap;
        } 
      } 
    } 
    return (Map)hashMap;
  }
  
  private static Map<String, Object> l111l11111lIl(Map<String, l111l11111lIl.l111l11111I1l> paramMap) {
    HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
    if (paramMap != null) {
      if (paramMap.size() == 0)
        return (Map)hashMap; 
      Iterator<Map.Entry> iterator = paramMap.entrySet().iterator();
      while (true) {
        if (iterator.hasNext()) {
          Map.Entry entry = iterator.next();
          try {
            Integer integer;
            String str = (String)entry.getKey();
            l111l11111lIl.l111l11111I1l l111l11111I1l = (l111l11111lIl.l111l11111I1l)entry.getValue();
            if (l111l11111I1l.l111l11111I1l() == 0) {
              if (l111l1111lIl.l1111l111111Il(l111l11111I1l.l111l11111lIl())) {
                integer = Integer.valueOf(1);
              } else {
                continue;
              } 
            } else if (1 == integer.l111l11111I1l() && l111l1111lIl.l111l11111lIl(integer.l111l11111lIl())) {
              integer = Integer.valueOf(1);
            } else {
              continue;
            } 
            hashMap.put(str, integer);
          } catch (Exception exception) {}
          continue;
        } 
        return (Map)hashMap;
      } 
    } 
    return (Map)hashMap;
  }
  
  final String l1111l111111Il(int paramInt) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: new com/ishumei/l1111l111111Il/l111l11111lIl
    //   5: dup
    //   6: invokespecial <init> : ()V
    //   9: astore #12
    //   11: aload #12
    //   13: getstatic com/ishumei/l1111l111111Il/l111l1111llIl$l1111l111111Il.l111l1111l1Il : Ljava/lang/String;
    //   16: invokevirtual l11l1111I1ll : (Ljava/lang/String;)V
    //   19: invokestatic l1111l111111Il : ()Lcom/ishumei/l111l11111lIl/l1111l111111Il;
    //   22: invokevirtual l111l11111lIl : ()Lcom/ishumei/l111l11111lIl/l111l11111lIl;
    //   25: astore #11
    //   27: getstatic com/ishumei/smantifraud/SmAntiFraud.l1111l111111Il : Lcom/ishumei/smantifraud/SmAntiFraud$SmOption;
    //   30: astore #10
    //   32: aconst_null
    //   33: astore #9
    //   35: aload #10
    //   37: invokevirtual l11l1111Ill : ()Ljava/util/Set;
    //   40: astore #7
    //   42: aload #7
    //   44: astore #6
    //   46: aload #7
    //   48: ifnonnull -> 56
    //   51: invokestatic emptySet : ()Ljava/util/Set;
    //   54: astore #6
    //   56: aload #12
    //   58: aload #6
    //   60: invokevirtual l1111l111111Il : (Ljava/util/Set;)V
    //   63: aload #12
    //   65: aload #10
    //   67: invokevirtual l1111l111111Il : ()Ljava/lang/String;
    //   70: invokevirtual l11l1111lIIl : (Ljava/lang/String;)V
    //   73: aload #11
    //   75: ifnonnull -> 84
    //   78: aconst_null
    //   79: astore #7
    //   81: goto -> 91
    //   84: aload #11
    //   86: invokevirtual l111l11IlIlIl : ()Ljava/util/Set;
    //   89: astore #7
    //   91: aload #12
    //   93: ldc_w 'all'
    //   96: invokevirtual l11l1111Il : (Ljava/lang/String;)V
    //   99: aload #12
    //   101: aload #10
    //   103: invokevirtual l11l1111I1ll : ()Ljava/lang/String;
    //   106: invokevirtual l111l11111Il : (Ljava/lang/String;)V
    //   109: invokestatic l1111l111111Il : ()Lcom/ishumei/l1111l111111Il/l11l1111I1l;
    //   112: aload #12
    //   114: invokevirtual l1111l111111Il : (Lcom/ishumei/l1111l111111Il/l111l11111lIl;)V
    //   117: aload #12
    //   119: invokestatic l11l1111Il : ()Ljava/util/List;
    //   122: invokevirtual l1111l111111Il : (Ljava/util/List;)V
    //   125: iload_1
    //   126: iconst_1
    //   127: iand
    //   128: istore_1
    //   129: iload_1
    //   130: iconst_1
    //   131: if_icmpne -> 1806
    //   134: ldc_w 'md5'
    //   137: astore #8
    //   139: goto -> 142
    //   142: aload #12
    //   144: aload #8
    //   146: invokevirtual l11l1111Ill : (Ljava/lang/String;)V
    //   149: aload #12
    //   151: invokestatic l1111l111111Il : ()Lcom/ishumei/l1111l111111Il/l111l1111l1Il;
    //   154: invokevirtual l111l11111lIl : ()Ljava/lang/String;
    //   157: invokevirtual l11l11IlIIll : (Ljava/lang/String;)V
    //   160: aload #12
    //   162: aload #10
    //   164: invokevirtual l11l1111Il : ()Ljava/lang/String;
    //   167: invokevirtual l11l111l11Il : (Ljava/lang/String;)V
    //   170: aload #12
    //   172: ldc_w 'android'
    //   175: invokevirtual l11l111l1lll : (Ljava/lang/String;)V
    //   178: aload #12
    //   180: ldc_w '3.0.6'
    //   183: invokevirtual l111l11IlIlIl : (Ljava/lang/String;)V
    //   186: aload #12
    //   188: ldc_w ''
    //   191: invokevirtual l11l111l1I1l : (Ljava/lang/String;)V
    //   194: aload #12
    //   196: invokestatic currentTimeMillis : ()J
    //   199: invokestatic valueOf : (J)Ljava/lang/Long;
    //   202: invokevirtual l1111l111111Il : (Ljava/lang/Long;)V
    //   205: aload #12
    //   207: invokestatic l1111l111111Il : ()I
    //   210: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   213: invokevirtual l1111l111111Il : (Ljava/lang/Integer;)V
    //   216: aload #12
    //   218: getstatic android/os/Build$VERSION.RELEASE : Ljava/lang/String;
    //   221: invokevirtual l11l111l1Il : (Ljava/lang/String;)V
    //   224: aload #12
    //   226: aload #10
    //   228: invokevirtual l11l11IlIIll : ()Ljava/lang/String;
    //   231: invokevirtual l11l111ll11l : (Ljava/lang/String;)V
    //   234: aload #7
    //   236: ifnull -> 280
    //   239: aload #7
    //   241: getstatic com/ishumei/l1111l111111Il/l1111l111111Il.l11l11IlIIll : Ljava/lang/String;
    //   244: invokeinterface contains : (Ljava/lang/Object;)Z
    //   249: ifeq -> 280
    //   252: new java/lang/StringBuilder
    //   255: dup
    //   256: invokespecial <init> : ()V
    //   259: astore #8
    //   261: aload #8
    //   263: invokestatic l111l11111I1l : ()Z
    //   266: invokevirtual append : (Z)Ljava/lang/StringBuilder;
    //   269: pop
    //   270: aload #12
    //   272: aload #8
    //   274: invokevirtual toString : ()Ljava/lang/String;
    //   277: invokevirtual l11l111ll1Il : (Ljava/lang/String;)V
    //   280: new com/ishumei/l111l11111Il/l11l1111I1ll
    //   283: dup
    //   284: invokespecial <init> : ()V
    //   287: astore #13
    //   289: aload #6
    //   291: getstatic com/ishumei/l1111l111111Il/l1111l111111Il.l111l1111lIl : Ljava/lang/String;
    //   294: invokeinterface contains : (Ljava/lang/Object;)Z
    //   299: ifne -> 411
    //   302: iload_1
    //   303: iconst_1
    //   304: if_icmpne -> 327
    //   307: aload #13
    //   309: invokevirtual l1111l111111Il : ()Ljava/lang/String;
    //   312: invokestatic l111l1111l1Il : (Ljava/lang/String;)Ljava/lang/String;
    //   315: astore #8
    //   317: aload #12
    //   319: aload #8
    //   321: invokevirtual l11l111lllIl : (Ljava/lang/String;)V
    //   324: goto -> 337
    //   327: aload #13
    //   329: invokevirtual l1111l111111Il : ()Ljava/lang/String;
    //   332: astore #8
    //   334: goto -> 317
    //   337: iload_1
    //   338: iconst_1
    //   339: if_icmpne -> 363
    //   342: aload #13
    //   344: iconst_1
    //   345: invokevirtual l1111l111111Il : (I)Ljava/lang/String;
    //   348: invokestatic l111l1111l1Il : (Ljava/lang/String;)Ljava/lang/String;
    //   351: astore #8
    //   353: aload #12
    //   355: aload #8
    //   357: invokevirtual l11l111llI1l : (Ljava/lang/String;)V
    //   360: goto -> 374
    //   363: aload #13
    //   365: iconst_1
    //   366: invokevirtual l1111l111111Il : (I)Ljava/lang/String;
    //   369: astore #8
    //   371: goto -> 353
    //   374: iload_1
    //   375: iconst_1
    //   376: if_icmpne -> 400
    //   379: aload #13
    //   381: iconst_2
    //   382: invokevirtual l1111l111111Il : (I)Ljava/lang/String;
    //   385: invokestatic l111l1111l1Il : (Ljava/lang/String;)Ljava/lang/String;
    //   388: astore #8
    //   390: aload #12
    //   392: aload #8
    //   394: invokevirtual l111l111llIl : (Ljava/lang/String;)V
    //   397: goto -> 411
    //   400: aload #13
    //   402: iconst_2
    //   403: invokevirtual l1111l111111Il : (I)Ljava/lang/String;
    //   406: astore #8
    //   408: goto -> 390
    //   411: aload #7
    //   413: ifnull -> 477
    //   416: aload #7
    //   418: getstatic com/ishumei/l1111l111111Il/l1111l111111Il.l11l1111lIIl : Ljava/lang/String;
    //   421: invokeinterface contains : (Ljava/lang/Object;)Z
    //   426: ifeq -> 477
    //   429: aload #6
    //   431: getstatic com/ishumei/l1111l111111Il/l1111l111111Il.l11l1111lIIl : Ljava/lang/String;
    //   434: invokeinterface contains : (Ljava/lang/Object;)Z
    //   439: ifne -> 477
    //   442: iload_1
    //   443: iconst_1
    //   444: if_icmpne -> 467
    //   447: aload #13
    //   449: invokevirtual l111l11111I1l : ()Ljava/lang/String;
    //   452: invokestatic l111l1111l1Il : (Ljava/lang/String;)Ljava/lang/String;
    //   455: astore #8
    //   457: aload #12
    //   459: aload #8
    //   461: invokevirtual l11l11l1lIl : (Ljava/lang/String;)V
    //   464: goto -> 477
    //   467: aload #13
    //   469: invokevirtual l111l11111I1l : ()Ljava/lang/String;
    //   472: astore #8
    //   474: goto -> 457
    //   477: aload #6
    //   479: getstatic com/ishumei/l1111l111111Il/l1111l111111Il.l111l11111Il : Ljava/lang/String;
    //   482: invokeinterface contains : (Ljava/lang/Object;)Z
    //   487: ifne -> 500
    //   490: aload #12
    //   492: aload #13
    //   494: invokevirtual l111l11111lIl : ()Ljava/lang/String;
    //   497: invokevirtual l11IIIlIll : (Ljava/lang/String;)V
    //   500: aload #7
    //   502: ifnull -> 541
    //   505: aload #7
    //   507: getstatic com/ishumei/l1111l111111Il/l1111l111111Il.l11l1111I11l : Ljava/lang/String;
    //   510: invokeinterface contains : (Ljava/lang/Object;)Z
    //   515: ifeq -> 541
    //   518: aload #6
    //   520: getstatic com/ishumei/l1111l111111Il/l1111l111111Il.l11l1111I11l : Ljava/lang/String;
    //   523: invokeinterface contains : (Ljava/lang/Object;)Z
    //   528: ifne -> 541
    //   531: aload #12
    //   533: aload #13
    //   535: invokevirtual l111l11111Il : ()Ljava/lang/String;
    //   538: invokevirtual l11l11l111Il : (Ljava/lang/String;)V
    //   541: aload #7
    //   543: ifnull -> 582
    //   546: aload #7
    //   548: getstatic com/ishumei/l1111l111111Il/l1111l111111Il.l11l1111I1ll : Ljava/lang/String;
    //   551: invokeinterface contains : (Ljava/lang/Object;)Z
    //   556: ifeq -> 582
    //   559: aload #6
    //   561: getstatic com/ishumei/l1111l111111Il/l1111l111111Il.l11l1111I1ll : Ljava/lang/String;
    //   564: invokeinterface contains : (Ljava/lang/Object;)Z
    //   569: ifne -> 582
    //   572: aload #12
    //   574: aload #13
    //   576: invokevirtual l111l1111l1Il : ()Ljava/util/HashMap;
    //   579: invokevirtual l111l11111I1l : (Ljava/util/Map;)V
    //   582: new com/ishumei/l111l11111Il/l111l1111lIl
    //   585: dup
    //   586: invokespecial <init> : ()V
    //   589: astore #13
    //   591: aload #6
    //   593: getstatic com/ishumei/l1111l111111Il/l1111l111111Il.l11l1111Il1l : Ljava/lang/String;
    //   596: invokeinterface contains : (Ljava/lang/Object;)Z
    //   601: ifne -> 690
    //   604: invokestatic l111l1111l1Il : ()Ljava/util/List;
    //   607: astore #14
    //   609: iload_1
    //   610: iconst_1
    //   611: if_icmpne -> 683
    //   614: new java/util/ArrayList
    //   617: dup
    //   618: aload #14
    //   620: invokeinterface size : ()I
    //   625: invokespecial <init> : (I)V
    //   628: astore #8
    //   630: aload #14
    //   632: invokeinterface iterator : ()Ljava/util/Iterator;
    //   637: astore #14
    //   639: aload #14
    //   641: invokeinterface hasNext : ()Z
    //   646: ifeq -> 673
    //   649: aload #8
    //   651: aload #14
    //   653: invokeinterface next : ()Ljava/lang/Object;
    //   658: checkcast java/lang/String
    //   661: invokestatic l111l1111l1Il : (Ljava/lang/String;)Ljava/lang/String;
    //   664: invokeinterface add : (Ljava/lang/Object;)Z
    //   669: pop
    //   670: goto -> 639
    //   673: aload #12
    //   675: aload #8
    //   677: invokevirtual l111l11111lIl : (Ljava/util/List;)V
    //   680: goto -> 690
    //   683: aload #12
    //   685: aload #14
    //   687: invokevirtual l111l11111lIl : (Ljava/util/List;)V
    //   690: aload #7
    //   692: ifnull -> 756
    //   695: aload #7
    //   697: getstatic com/ishumei/l1111l111111Il/l1111l111111Il.l111l1111llIl : Ljava/lang/String;
    //   700: invokeinterface contains : (Ljava/lang/Object;)Z
    //   705: ifeq -> 756
    //   708: aload #6
    //   710: getstatic com/ishumei/l1111l111111Il/l1111l111111Il.l111l1111llIl : Ljava/lang/String;
    //   713: invokeinterface contains : (Ljava/lang/Object;)Z
    //   718: ifne -> 756
    //   721: iload_1
    //   722: iconst_1
    //   723: if_icmpne -> 746
    //   726: aload #13
    //   728: invokevirtual l111l11111lIl : ()Ljava/lang/String;
    //   731: invokestatic l111l1111l1Il : (Ljava/lang/String;)Ljava/lang/String;
    //   734: astore #8
    //   736: aload #12
    //   738: aload #8
    //   740: invokevirtual l11l111lll : (Ljava/lang/String;)V
    //   743: goto -> 756
    //   746: aload #13
    //   748: invokevirtual l111l11111lIl : ()Ljava/lang/String;
    //   751: astore #8
    //   753: goto -> 736
    //   756: aload #7
    //   758: ifnull -> 797
    //   761: aload #7
    //   763: getstatic com/ishumei/l1111l111111Il/l1111l111111Il.l111l1111l1Il : Ljava/lang/String;
    //   766: invokeinterface contains : (Ljava/lang/Object;)Z
    //   771: ifeq -> 797
    //   774: aload #6
    //   776: getstatic com/ishumei/l1111l111111Il/l1111l111111Il.l111l1111l1Il : Ljava/lang/String;
    //   779: invokeinterface contains : (Ljava/lang/Object;)Z
    //   784: ifne -> 797
    //   787: aload #12
    //   789: aload #13
    //   791: invokevirtual l1111l111111Il : ()Ljava/lang/String;
    //   794: invokevirtual l111l111lIlll : (Ljava/lang/String;)V
    //   797: aload #6
    //   799: getstatic com/ishumei/l1111l111111Il/l1111l111111Il.l111l1111lI1l : Ljava/lang/String;
    //   802: invokeinterface contains : (Ljava/lang/Object;)Z
    //   807: ifne -> 820
    //   810: aload #12
    //   812: aload #13
    //   814: invokevirtual l111l11111I1l : ()Ljava/lang/String;
    //   817: invokevirtual l11l111I111l : (Ljava/lang/String;)V
    //   820: aload #6
    //   822: getstatic com/ishumei/l1111l111111Il/l1111l111111Il.l111l11111I1l : Ljava/lang/String;
    //   825: invokeinterface contains : (Ljava/lang/Object;)Z
    //   830: ifne -> 843
    //   833: aload #12
    //   835: aload #13
    //   837: invokevirtual l111l11111Il : ()Ljava/lang/String;
    //   840: invokevirtual l111l111III1l : (Ljava/lang/String;)V
    //   843: aload #12
    //   845: invokestatic l1111l111111Il : ()Ljava/util/HashMap;
    //   848: invokevirtual l1111l111111Il : (Ljava/util/Map;)V
    //   851: aload #6
    //   853: getstatic com/ishumei/l1111l111111Il/l1111l111111Il.l11l1111I1l : Ljava/lang/String;
    //   856: invokeinterface contains : (Ljava/lang/Object;)Z
    //   861: ifne -> 895
    //   864: iload_1
    //   865: iconst_1
    //   866: if_icmpne -> 887
    //   869: invokestatic l1111l111111Il : ()Ljava/lang/String;
    //   872: invokestatic l111l1111l1Il : (Ljava/lang/String;)Ljava/lang/String;
    //   875: astore #8
    //   877: aload #12
    //   879: aload #8
    //   881: invokevirtual l11l111lI1l : (Ljava/lang/String;)V
    //   884: goto -> 895
    //   887: invokestatic l1111l111111Il : ()Ljava/lang/String;
    //   890: astore #8
    //   892: goto -> 877
    //   895: aload #7
    //   897: ifnull -> 952
    //   900: aload #7
    //   902: getstatic com/ishumei/l1111l111111Il/l1111l111111Il.l11l1111Il : Ljava/lang/String;
    //   905: invokeinterface contains : (Ljava/lang/Object;)Z
    //   910: ifeq -> 952
    //   913: aload #6
    //   915: getstatic com/ishumei/l1111l111111Il/l1111l111111Il.l11l1111Il : Ljava/lang/String;
    //   918: invokeinterface contains : (Ljava/lang/Object;)Z
    //   923: ifne -> 952
    //   926: aload #12
    //   928: aload #11
    //   930: invokevirtual l11l111l1lll : ()Ljava/util/Map;
    //   933: aload #11
    //   935: invokevirtual l11l1111I1ll : ()I
    //   938: aload #11
    //   940: invokevirtual l11l1111I1l : ()I
    //   943: invokestatic l1111l111111Il : (Ljava/util/Map;II)Lcom/ishumei/l111l11111Il/l111l11111lIl$l1111l111111Il;
    //   946: getfield l111l11111I1l : Ljava/util/List;
    //   949: invokevirtual l111l11111I1l : (Ljava/util/List;)V
    //   952: aload #12
    //   954: invokestatic getRadioVersion : ()Ljava/lang/String;
    //   957: invokevirtual l11l111lIll : (Ljava/lang/String;)V
    //   960: aload #12
    //   962: invokestatic l111l1111lIl : ()Ljava/lang/String;
    //   965: invokevirtual l11l1111I11l : (Ljava/lang/String;)V
    //   968: aload #12
    //   970: invokestatic l11l1111lIIl : ()Ljava/lang/String;
    //   973: invokevirtual l111l1111lIl : (Ljava/lang/String;)V
    //   976: aload #12
    //   978: invokestatic l1111l111111Il : ()Lcom/ishumei/l111l11111Il/l111l1111l1Il$l1111l111111Il;
    //   981: getfield l1111l111111Il : Ljava/lang/String;
    //   984: invokevirtual l11l111I11l : (Ljava/lang/String;)V
    //   987: aload #12
    //   989: invokestatic l111l11111lIl : ()I
    //   992: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   995: invokevirtual l111l11111Il : (Ljava/lang/Integer;)V
    //   998: aload #12
    //   1000: invokestatic l111l11111I1l : ()I
    //   1003: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   1006: invokevirtual l111l1111l1Il : (Ljava/lang/Integer;)V
    //   1009: aload #12
    //   1011: invokestatic l111l11111Il : ()J
    //   1014: invokestatic valueOf : (J)Ljava/lang/Long;
    //   1017: invokevirtual l111l11111I1l : (Ljava/lang/Long;)V
    //   1020: aload #12
    //   1022: invokestatic l1111l111111Il : ()Ljava/lang/String;
    //   1025: invokevirtual l111l111I1l : (Ljava/lang/String;)V
    //   1028: aload #12
    //   1030: invokestatic l111l11111I1l : ()I
    //   1033: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   1036: invokevirtual l111l11111lIl : (Ljava/lang/Integer;)V
    //   1039: aload #12
    //   1041: invokestatic l111l11111lIl : ()Ljava/lang/String;
    //   1044: invokevirtual l111l1111lI1l : (Ljava/lang/String;)V
    //   1047: aload #12
    //   1049: invokestatic l111l11111I1l : ()I
    //   1052: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   1055: invokevirtual l111l1111llIl : (Ljava/lang/Integer;)V
    //   1058: aload #12
    //   1060: invokestatic l111l11111lIl : ()Ljava/lang/String;
    //   1063: invokevirtual l11l111Il : (Ljava/lang/String;)V
    //   1066: aload #12
    //   1068: invokestatic l111l11111I1l : ()Ljava/lang/String;
    //   1071: invokevirtual l111l111Il1l : (Ljava/lang/String;)V
    //   1074: aload #12
    //   1076: invokestatic l111l11111lIl : ()J
    //   1079: invokestatic valueOf : (J)Ljava/lang/Long;
    //   1082: invokevirtual l111l11111lIl : (Ljava/lang/Long;)V
    //   1085: aload #6
    //   1087: ldc_w 'sn'
    //   1090: invokeinterface contains : (Ljava/lang/Object;)Z
    //   1095: istore_3
    //   1096: iconst_0
    //   1097: istore_2
    //   1098: iload_3
    //   1099: ifne -> 1814
    //   1102: iconst_1
    //   1103: istore_3
    //   1104: goto -> 1107
    //   1107: aload #12
    //   1109: iload_3
    //   1110: invokestatic l1111l111111Il : (Z)Ljava/util/HashMap;
    //   1113: invokevirtual l111l11111lIl : (Ljava/util/Map;)V
    //   1116: aload #6
    //   1118: getstatic com/ishumei/l1111l111111Il/l1111l111111Il.l11l1111Ill : Ljava/lang/String;
    //   1121: invokeinterface contains : (Ljava/lang/Object;)Z
    //   1126: ifne -> 1137
    //   1129: aload #12
    //   1131: invokestatic l1111l111111Il : ()Ljava/util/List;
    //   1134: invokevirtual l111l11111Il : (Ljava/util/List;)V
    //   1137: aload #6
    //   1139: getstatic com/ishumei/l1111l111111Il/l1111l111111Il.l11l111l11Il : Ljava/lang/String;
    //   1142: invokeinterface contains : (Ljava/lang/Object;)Z
    //   1147: ifne -> 1819
    //   1150: aload #11
    //   1152: ifnonnull -> 1161
    //   1155: aconst_null
    //   1156: astore #6
    //   1158: goto -> 1168
    //   1161: aload #11
    //   1163: invokevirtual l11l11IlIIll : ()Ljava/util/Map;
    //   1166: astore #6
    //   1168: aload #12
    //   1170: aload #6
    //   1172: invokestatic l1111l111111Il : (Ljava/util/Map;)Ljava/util/Map;
    //   1175: invokevirtual l111l11111Il : (Ljava/util/Map;)V
    //   1178: goto -> 1819
    //   1181: aload #11
    //   1183: invokevirtual l11l111l11Il : ()Ljava/util/Map;
    //   1186: astore #6
    //   1188: aload #12
    //   1190: aload #6
    //   1192: invokestatic l111l11111lIl : (Ljava/util/Map;)Ljava/util/Map;
    //   1195: invokevirtual l111l1111l1Il : (Ljava/util/Map;)V
    //   1198: aload #12
    //   1200: invokestatic l1111l111111Il : ()Ljava/lang/String;
    //   1203: invokevirtual l11l11l11lIl : (Ljava/lang/String;)V
    //   1206: aload #11
    //   1208: ifnull -> 1221
    //   1211: aload #12
    //   1213: aload #11
    //   1215: invokevirtual l11l1111Il1l : ()Ljava/lang/String;
    //   1218: invokevirtual l11l11l11I1l : (Ljava/lang/String;)V
    //   1221: invokestatic l111l11111Il : ()Ljava/lang/Object;
    //   1224: astore #6
    //   1226: aload #6
    //   1228: ifnull -> 1254
    //   1231: aload #12
    //   1233: aload #6
    //   1235: invokestatic l1111l111111Il : (Ljava/lang/Object;)Ljava/lang/String;
    //   1238: invokevirtual l11l11l11Il : (Ljava/lang/String;)V
    //   1241: aload #12
    //   1243: aload #6
    //   1245: invokevirtual hashCode : ()I
    //   1248: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   1251: invokevirtual l111l1111lI1l : (Ljava/lang/Integer;)V
    //   1254: aload #12
    //   1256: invokestatic l111l1111l1Il : ()Ljava/util/Map;
    //   1259: invokevirtual l11l1111I1ll : (Ljava/util/Map;)V
    //   1262: aload #12
    //   1264: invokestatic l1111l111111Il : (Lcom/ishumei/l1111l111111Il/l111l11111lIl;)V
    //   1267: getstatic com/ishumei/l1111l111111Il/l111l1111llIl$l1111l111111Il.l111l11111Il : Landroid/content/Context;
    //   1270: ifnull -> 1287
    //   1273: aload #12
    //   1275: getstatic com/ishumei/l1111l111111Il/l111l1111llIl$l1111l111111Il.l111l11111Il : Landroid/content/Context;
    //   1278: invokevirtual getFilesDir : ()Ljava/io/File;
    //   1281: invokevirtual toString : ()Ljava/lang/String;
    //   1284: invokevirtual l11l11l1l1Il : (Ljava/lang/String;)V
    //   1287: aload #12
    //   1289: invokestatic l111l11111lIl : ()Ljava/util/List;
    //   1292: invokevirtual l111l1111l1Il : (Ljava/util/List;)V
    //   1295: aload #12
    //   1297: invokestatic l111l1111llIl : ()Ljava/util/Map;
    //   1300: invokevirtual l111l1111llIl : (Ljava/util/Map;)V
    //   1303: invokestatic l1111l111111Il : ()Lcom/ishumei/l111l1111llIl/l111l11111lIl;
    //   1306: invokevirtual l111l11111Il : ()J
    //   1309: lstore #4
    //   1311: lload #4
    //   1313: ldc2_w -1
    //   1316: lcmp
    //   1317: ifeq -> 1330
    //   1320: aload #12
    //   1322: lload #4
    //   1324: invokestatic valueOf : (J)Ljava/lang/Long;
    //   1327: invokevirtual l111l11111Il : (Ljava/lang/Long;)V
    //   1330: aload #12
    //   1332: invokestatic l1111l111111Il : ()Lcom/ishumei/l111l11111lIl/l1111l111111Il/l1111l111111Il;
    //   1335: invokevirtual l111l11111lIl : ()Ljava/util/Map;
    //   1338: invokevirtual l111l1111lI1l : (Ljava/util/Map;)V
    //   1341: aload #12
    //   1343: invokestatic l1111l111111Il : ()Lcom/ishumei/l111l11111lIl/l111l11111lIl/l1111l111111Il;
    //   1346: invokevirtual l111l11111I1l : ()Ljava/util/List;
    //   1349: invokevirtual l111l1111llIl : (Ljava/util/List;)V
    //   1352: getstatic android/os/Build$VERSION.SDK_INT : I
    //   1355: bipush #18
    //   1357: if_icmplt -> 1414
    //   1360: new android/os/StatFs
    //   1363: dup
    //   1364: invokestatic getExternalStorageDirectory : ()Ljava/io/File;
    //   1367: invokevirtual getPath : ()Ljava/lang/String;
    //   1370: invokespecial <init> : (Ljava/lang/String;)V
    //   1373: astore #6
    //   1375: aload #12
    //   1377: aload #6
    //   1379: invokevirtual getAvailableBytes : ()J
    //   1382: invokestatic valueOf : (J)Ljava/lang/Long;
    //   1385: invokevirtual l111l1111l1Il : (Ljava/lang/Long;)V
    //   1388: aload #12
    //   1390: aload #6
    //   1392: invokevirtual getFreeBytes : ()J
    //   1395: invokestatic valueOf : (J)Ljava/lang/Long;
    //   1398: invokevirtual l111l1111llIl : (Ljava/lang/Long;)V
    //   1401: aload #12
    //   1403: aload #6
    //   1405: invokevirtual getTotalBytes : ()J
    //   1408: invokestatic valueOf : (J)Ljava/lang/Long;
    //   1411: invokevirtual l111l1111lI1l : (Ljava/lang/Long;)V
    //   1414: aload #12
    //   1416: invokestatic l111l11111lIl : ()Ljava/util/Map;
    //   1419: invokevirtual l111l1111lIl : (Ljava/util/Map;)V
    //   1422: getstatic com/ishumei/l1111l111111Il/l111l1111llIl$l1111l111111Il.l111l11111Il : Landroid/content/Context;
    //   1425: astore #6
    //   1427: aload #6
    //   1429: ifnull -> 1841
    //   1432: aload #6
    //   1434: invokevirtual getContentResolver : ()Landroid/content/ContentResolver;
    //   1437: ldc_w 'mock_location'
    //   1440: iconst_0
    //   1441: invokestatic getInt : (Landroid/content/ContentResolver;Ljava/lang/String;I)I
    //   1444: ifeq -> 1830
    //   1447: iconst_1
    //   1448: istore_1
    //   1449: goto -> 1832
    //   1452: aload #12
    //   1454: iload_1
    //   1455: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   1458: invokevirtual l111l1111lIl : (Ljava/lang/Integer;)V
    //   1461: aload #12
    //   1463: invokestatic l111l1111l1Il : ()I
    //   1466: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   1469: invokevirtual l111l11111I1l : (Ljava/lang/Integer;)V
    //   1472: iload_2
    //   1473: istore_1
    //   1474: invokestatic isDebuggerConnected : ()Z
    //   1477: ifeq -> 1482
    //   1480: iconst_1
    //   1481: istore_1
    //   1482: aload #12
    //   1484: iload_1
    //   1485: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   1488: invokevirtual l11l1111lIIl : (Ljava/lang/Integer;)V
    //   1491: aload #12
    //   1493: invokestatic l111l1111llIl : ()I
    //   1496: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   1499: invokevirtual l11l1111I11l : (Ljava/lang/Integer;)V
    //   1502: aload #12
    //   1504: invokestatic l111l1111llIl : ()Ljava/lang/String;
    //   1507: invokevirtual l11l11l1llIl : (Ljava/lang/String;)V
    //   1510: aload #12
    //   1512: invokestatic l111l1111l1Il : ()Ljava/util/Map;
    //   1515: invokevirtual l11l1111lIIl : (Ljava/util/Map;)V
    //   1518: aload #12
    //   1520: invokestatic l111l11111Il : ()Ljava/util/Set;
    //   1523: invokevirtual l111l11111lIl : (Ljava/util/Set;)V
    //   1526: aload #12
    //   1528: invokestatic l111l1111lI1l : ()Ljava/lang/String;
    //   1531: invokevirtual l11l1111I1l : (Ljava/lang/String;)V
    //   1534: aload #12
    //   1536: invokestatic l11l1111I11l : ()Ljava/lang/String;
    //   1539: invokevirtual l1111l111111Il : (Ljava/lang/String;)V
    //   1542: aload #12
    //   1544: invokestatic l11l1111I1l : ()Ljava/lang/String;
    //   1547: invokevirtual l111l11111lIl : (Ljava/lang/String;)V
    //   1550: aload #12
    //   1552: invokestatic l11l1111I1ll : ()Ljava/lang/String;
    //   1555: invokevirtual l111l11111I1l : (Ljava/lang/String;)V
    //   1558: aload #12
    //   1560: new com/ishumei/l111l11111Il/l1111l111111Il/l111l1111llIl
    //   1563: dup
    //   1564: getstatic com/ishumei/l1111l111111Il/l111l1111llIl$l1111l111111Il.l111l11111Il : Landroid/content/Context;
    //   1567: invokespecial <init> : (Landroid/content/Context;)V
    //   1570: invokevirtual l1111l111111Il : ()Ljava/lang/String;
    //   1573: invokevirtual l11l11l1I11l : (Ljava/lang/String;)V
    //   1576: aload #12
    //   1578: invokestatic l11l1111Il1l : ()Ljava/util/Map;
    //   1581: invokevirtual l11l1111I11l : (Ljava/util/Map;)V
    //   1584: invokestatic l11l1111Ill : ()I
    //   1587: iconst_1
    //   1588: if_icmpne -> 1597
    //   1591: aload #12
    //   1593: iconst_1
    //   1594: invokevirtual l1111l111111Il : (I)V
    //   1597: aload #11
    //   1599: ifnull -> 1633
    //   1602: aload #11
    //   1604: invokevirtual l111l1111lIl : ()Z
    //   1607: ifeq -> 1633
    //   1610: aload #12
    //   1612: invokestatic l1111l111111Il : ()Ljava/util/Map;
    //   1615: invokevirtual l11l1111I1l : (Ljava/util/Map;)V
    //   1618: goto -> 1633
    //   1621: astore #6
    //   1623: aload #12
    //   1625: aload #6
    //   1627: invokestatic getStackTraceString : (Ljava/lang/Throwable;)Ljava/lang/String;
    //   1630: invokevirtual l11l11l1lI1l : (Ljava/lang/String;)V
    //   1633: aload #12
    //   1635: invokestatic l1111l111111Il : (Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1638: astore #6
    //   1640: getstatic com/ishumei/l1111l111111Il/l111l1111llIl$l1111l111111Il.l111l11111Il : Landroid/content/Context;
    //   1643: astore #7
    //   1645: aload #6
    //   1647: invokevirtual toString : ()Ljava/lang/String;
    //   1650: astore #8
    //   1652: aload #9
    //   1654: astore #6
    //   1656: aload #11
    //   1658: ifnull -> 1680
    //   1661: aload #9
    //   1663: astore #6
    //   1665: aload #11
    //   1667: invokevirtual l11l1111I11l : ()Z
    //   1670: ifeq -> 1680
    //   1673: aload #11
    //   1675: invokevirtual l11l1111Ill : ()Ljava/lang/String;
    //   1678: astore #6
    //   1680: aload #7
    //   1682: aload #8
    //   1684: aload #6
    //   1686: aload #10
    //   1688: invokevirtual l111l1111llIl : ()Ljava/lang/String;
    //   1691: aload #10
    //   1693: invokevirtual l11l1111I1ll : ()Ljava/lang/String;
    //   1696: aload #10
    //   1698: invokevirtual l11l11IlIIll : ()Ljava/lang/String;
    //   1701: invokestatic v1 : (Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   1704: astore #6
    //   1706: aload_0
    //   1707: aload #6
    //   1709: invokevirtual getBytes : ()[B
    //   1712: invokestatic l111l11111lIl : ([B)Ljava/lang/String;
    //   1715: putfield l111l11IlIlIl : Ljava/lang/String;
    //   1718: aload #6
    //   1720: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   1723: ifne -> 1744
    //   1726: aload #6
    //   1728: ldc_w '{'
    //   1731: invokevirtual startsWith : (Ljava/lang/String;)Z
    //   1734: istore_3
    //   1735: iload_3
    //   1736: ifeq -> 1744
    //   1739: aload_0
    //   1740: monitorexit
    //   1741: aload #6
    //   1743: areturn
    //   1744: new java/lang/StringBuilder
    //   1747: dup
    //   1748: ldc_w 'error ret: '
    //   1751: invokespecial <init> : (Ljava/lang/String;)V
    //   1754: astore #7
    //   1756: aload #7
    //   1758: aload #6
    //   1760: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1763: pop
    //   1764: new java/lang/Exception
    //   1767: dup
    //   1768: aload #7
    //   1770: invokevirtual toString : ()Ljava/lang/String;
    //   1773: invokespecial <init> : (Ljava/lang/String;)V
    //   1776: athrow
    //   1777: astore #6
    //   1779: invokestatic l1111l111111Il : ()Lcom/ishumei/l111l11111lIl/l111l11111I1l;
    //   1782: aload #6
    //   1784: invokevirtual l1111l111111Il : (Ljava/lang/Throwable;)Ljava/lang/String;
    //   1787: astore #6
    //   1789: aload_0
    //   1790: monitorexit
    //   1791: aload #6
    //   1793: areturn
    //   1794: astore #6
    //   1796: aload_0
    //   1797: monitorexit
    //   1798: aload #6
    //   1800: athrow
    //   1801: astore #6
    //   1803: goto -> 1414
    //   1806: ldc_w 'none'
    //   1809: astore #8
    //   1811: goto -> 142
    //   1814: iconst_0
    //   1815: istore_3
    //   1816: goto -> 1107
    //   1819: aload #11
    //   1821: ifnonnull -> 1181
    //   1824: aconst_null
    //   1825: astore #6
    //   1827: goto -> 1188
    //   1830: iconst_0
    //   1831: istore_1
    //   1832: iload_1
    //   1833: ifeq -> 1841
    //   1836: iconst_1
    //   1837: istore_1
    //   1838: goto -> 1452
    //   1841: iconst_0
    //   1842: istore_1
    //   1843: goto -> 1452
    // Exception table:
    //   from	to	target	type
    //   2	32	1794	finally
    //   35	42	1621	finally
    //   51	56	1621	finally
    //   56	73	1621	finally
    //   84	91	1621	finally
    //   91	125	1621	finally
    //   142	234	1621	finally
    //   239	280	1621	finally
    //   280	302	1621	finally
    //   307	317	1621	finally
    //   317	324	1621	finally
    //   327	334	1621	finally
    //   342	353	1621	finally
    //   353	360	1621	finally
    //   363	371	1621	finally
    //   379	390	1621	finally
    //   390	397	1621	finally
    //   400	408	1621	finally
    //   416	442	1621	finally
    //   447	457	1621	finally
    //   457	464	1621	finally
    //   467	474	1621	finally
    //   477	500	1621	finally
    //   505	541	1621	finally
    //   546	582	1621	finally
    //   582	609	1621	finally
    //   614	639	1621	finally
    //   639	670	1621	finally
    //   673	680	1621	finally
    //   683	690	1621	finally
    //   695	721	1621	finally
    //   726	736	1621	finally
    //   736	743	1621	finally
    //   746	753	1621	finally
    //   761	797	1621	finally
    //   797	820	1621	finally
    //   820	843	1621	finally
    //   843	864	1621	finally
    //   869	877	1621	finally
    //   877	884	1621	finally
    //   887	892	1621	finally
    //   900	952	1621	finally
    //   952	1096	1621	finally
    //   1107	1137	1621	finally
    //   1137	1150	1621	finally
    //   1161	1168	1621	finally
    //   1168	1178	1621	finally
    //   1181	1188	1621	finally
    //   1188	1206	1621	finally
    //   1211	1221	1621	finally
    //   1221	1226	1621	finally
    //   1231	1254	1621	finally
    //   1254	1287	1621	finally
    //   1287	1311	1621	finally
    //   1320	1330	1621	finally
    //   1330	1352	1621	finally
    //   1352	1414	1801	java/lang/Exception
    //   1352	1414	1621	finally
    //   1414	1427	1621	finally
    //   1432	1447	1621	finally
    //   1452	1472	1621	finally
    //   1474	1480	1621	finally
    //   1482	1597	1621	finally
    //   1602	1618	1621	finally
    //   1623	1633	1794	finally
    //   1633	1652	1777	finally
    //   1665	1680	1777	finally
    //   1680	1735	1777	finally
    //   1744	1777	1777	finally
    //   1779	1789	1794	finally
  }
  
  final String l111l11111lIl() {
    return this.l111l11IlIlIl;
  }
  
  static {
    try {
      l111l11111I1l = l111l1111lI1l.l111l11111Il("919a8b88908d94");
      l111l11111Il = l111l1111lI1l.l111l11111Il("908f9a8d9e8b908d");
      l111l1111l1Il = l111l1111lI1l.l111l11111Il("8c8c969b");
      l111l1111llIl = l111l1111lI1l.l111l11111Il("9d8c8c969b");
      l111l1111lI1l = l111l1111lI1l.l111l11111Il("88969996968f");
      l111l1111lIl = l111l1111lI1l.l111l11111Il("96929a96");
      l11l1111lIIl = l111l1111lI1l.l111l11111Il("96928c96");
      l11l1111I11l = l111l1111lI1l.l111l11111Il("969c9c969b");
      l11l1111I1l = l111l1111lI1l.l111l11111Il("9e9b969b");
      l11l1111I1ll = l111l1111lI1l.l111l11111Il("9c9a9393");
      l11l1111Il = l111l1111lI1l.l111l11111Il("9e8f8f8c");
      l11l1111Il1l = l111l1111lI1l.l111l11111Il("919a8b");
      l11l1111Ill = l111l1111lI1l.l111l11111Il("8c9a918c908d");
      l11l11IlIIll = l111l1111lI1l.l111l11111Il("9e96919990");
      l11l111l11Il = l111l1111lI1l.l111l11111Il("8d968c949e8f8f");
    } catch (Exception exception) {}
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\ishumei\l1111l111111Il\l1111l111111Il.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */