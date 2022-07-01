package com.loc;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClientOption;
import java.util.ArrayList;
import java.util.Hashtable;
import org.json.JSONObject;

public final class dz {
  Hashtable<String, ArrayList<a>> a = new Hashtable<String, ArrayList<a>>();
  
  boolean b = true;
  
  long c = 0L;
  
  String d = null;
  
  dv e = null;
  
  boolean f = true;
  
  boolean g = true;
  
  String h = String.valueOf(AMapLocationClientOption.GeoLanguage.DEFAULT);
  
  private long i = 0L;
  
  private boolean j = false;
  
  private String k = "2.0.201501131131".replace(".", "");
  
  private String l = null;
  
  private String m = null;
  
  private long n = 0L;
  
  private ds a(String paramString, StringBuilder paramStringBuilder) {
    // Byte code:
    //   0: ldc '#'
    //   2: astore #13
    //   4: ldc ',access'
    //   6: astore #12
    //   8: aload_1
    //   9: ldc 'cgiwifi'
    //   11: invokevirtual contains : (Ljava/lang/CharSequence;)Z
    //   14: ifne -> 88
    //   17: aload_1
    //   18: ldc 'wifi'
    //   20: invokevirtual contains : (Ljava/lang/CharSequence;)Z
    //   23: ifeq -> 29
    //   26: goto -> 88
    //   29: aload_1
    //   30: ldc 'cgi'
    //   32: invokevirtual contains : (Ljava/lang/CharSequence;)Z
    //   35: ifeq -> 812
    //   38: aload_0
    //   39: getfield a : Ljava/util/Hashtable;
    //   42: aload_1
    //   43: invokevirtual containsKey : (Ljava/lang/Object;)Z
    //   46: ifeq -> 812
    //   49: aload_0
    //   50: getfield a : Ljava/util/Hashtable;
    //   53: aload_1
    //   54: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   57: checkcast java/util/ArrayList
    //   60: invokevirtual size : ()I
    //   63: ifle -> 812
    //   66: aload_0
    //   67: getfield a : Ljava/util/Hashtable;
    //   70: aload_1
    //   71: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   74: checkcast java/util/ArrayList
    //   77: iconst_0
    //   78: invokevirtual get : (I)Ljava/lang/Object;
    //   81: checkcast com/loc/dz$a
    //   84: astore_2
    //   85: goto -> 695
    //   88: aload_0
    //   89: getfield a : Ljava/util/Hashtable;
    //   92: invokevirtual isEmpty : ()Z
    //   95: ifne -> 812
    //   98: aload_2
    //   99: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   102: ifeq -> 108
    //   105: goto -> 812
    //   108: aload_0
    //   109: getfield a : Ljava/util/Hashtable;
    //   112: aload_1
    //   113: invokevirtual containsKey : (Ljava/lang/Object;)Z
    //   116: ifne -> 122
    //   119: goto -> 812
    //   122: new java/util/Hashtable
    //   125: dup
    //   126: invokespecial <init> : ()V
    //   129: astore #11
    //   131: new java/util/Hashtable
    //   134: dup
    //   135: invokespecial <init> : ()V
    //   138: astore #16
    //   140: new java/util/Hashtable
    //   143: dup
    //   144: invokespecial <init> : ()V
    //   147: astore #17
    //   149: aload_0
    //   150: getfield a : Ljava/util/Hashtable;
    //   153: aload_1
    //   154: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   157: checkcast java/util/ArrayList
    //   160: astore #18
    //   162: aload #18
    //   164: invokevirtual size : ()I
    //   167: iconst_1
    //   168: isub
    //   169: istore #7
    //   171: iload #7
    //   173: iflt -> 881
    //   176: aload #18
    //   178: iload #7
    //   180: invokevirtual get : (I)Ljava/lang/Object;
    //   183: checkcast com/loc/dz$a
    //   186: astore #14
    //   188: aload #14
    //   190: invokevirtual b : ()Ljava/lang/String;
    //   193: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   196: ifne -> 872
    //   199: aload #14
    //   201: invokevirtual b : ()Ljava/lang/String;
    //   204: astore #15
    //   206: aload #15
    //   208: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   211: ifne -> 826
    //   214: aload_2
    //   215: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   218: ifeq -> 224
    //   221: goto -> 826
    //   224: aload #15
    //   226: aload #12
    //   228: invokevirtual contains : (Ljava/lang/CharSequence;)Z
    //   231: ifeq -> 826
    //   234: aload_2
    //   235: aload #12
    //   237: invokevirtual indexOf : (Ljava/lang/String;)I
    //   240: iconst_m1
    //   241: if_icmpne -> 247
    //   244: goto -> 826
    //   247: aload #15
    //   249: aload #12
    //   251: invokevirtual split : (Ljava/lang/String;)[Ljava/lang/String;
    //   254: astore #15
    //   256: aload #15
    //   258: iconst_0
    //   259: aaload
    //   260: aload #13
    //   262: invokevirtual contains : (Ljava/lang/CharSequence;)Z
    //   265: ifeq -> 817
    //   268: aload #15
    //   270: iconst_0
    //   271: aaload
    //   272: aload #15
    //   274: iconst_0
    //   275: aaload
    //   276: aload #13
    //   278: invokevirtual lastIndexOf : (Ljava/lang/String;)I
    //   281: iconst_1
    //   282: iadd
    //   283: invokevirtual substring : (I)Ljava/lang/String;
    //   286: astore #15
    //   288: goto -> 291
    //   291: aload #15
    //   293: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   296: ifeq -> 302
    //   299: goto -> 826
    //   302: aload_2
    //   303: invokevirtual toString : ()Ljava/lang/String;
    //   306: astore #19
    //   308: new java/lang/StringBuilder
    //   311: dup
    //   312: invokespecial <init> : ()V
    //   315: astore #20
    //   317: aload #20
    //   319: aload #15
    //   321: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   324: pop
    //   325: aload #20
    //   327: aload #12
    //   329: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   332: pop
    //   333: aload #19
    //   335: aload #20
    //   337: invokevirtual toString : ()Ljava/lang/String;
    //   340: invokevirtual contains : (Ljava/lang/CharSequence;)Z
    //   343: istore #10
    //   345: goto -> 348
    //   348: iload #10
    //   350: ifeq -> 844
    //   353: aload #14
    //   355: invokevirtual b : ()Ljava/lang/String;
    //   358: aload_2
    //   359: invokevirtual toString : ()Ljava/lang/String;
    //   362: invokestatic a : (Ljava/lang/String;Ljava/lang/String;)Z
    //   365: ifeq -> 838
    //   368: goto -> 832
    //   371: aload #14
    //   373: invokevirtual b : ()Ljava/lang/String;
    //   376: aload #11
    //   378: invokestatic a : (Ljava/lang/String;Ljava/util/Hashtable;)V
    //   381: aload_2
    //   382: invokevirtual toString : ()Ljava/lang/String;
    //   385: aload #16
    //   387: invokestatic a : (Ljava/lang/String;Ljava/util/Hashtable;)V
    //   390: aload #17
    //   392: invokevirtual clear : ()V
    //   395: aload #11
    //   397: invokevirtual keySet : ()Ljava/util/Set;
    //   400: invokeinterface iterator : ()Ljava/util/Iterator;
    //   405: astore #15
    //   407: aload #15
    //   409: invokeinterface hasNext : ()Z
    //   414: istore #10
    //   416: iload #10
    //   418: ifeq -> 442
    //   421: aload #17
    //   423: aload #15
    //   425: invokeinterface next : ()Ljava/lang/Object;
    //   430: checkcast java/lang/String
    //   433: ldc ''
    //   435: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   438: pop
    //   439: goto -> 407
    //   442: aload #16
    //   444: invokevirtual keySet : ()Ljava/util/Set;
    //   447: invokeinterface iterator : ()Ljava/util/Iterator;
    //   452: astore #15
    //   454: aload #15
    //   456: invokeinterface hasNext : ()Z
    //   461: ifeq -> 485
    //   464: aload #17
    //   466: aload #15
    //   468: invokeinterface next : ()Ljava/lang/Object;
    //   473: checkcast java/lang/String
    //   476: ldc ''
    //   478: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   481: pop
    //   482: goto -> 454
    //   485: aload #17
    //   487: invokevirtual keySet : ()Ljava/util/Set;
    //   490: astore #15
    //   492: aload #15
    //   494: invokeinterface size : ()I
    //   499: newarray double
    //   501: astore #19
    //   503: aload #15
    //   505: invokeinterface size : ()I
    //   510: newarray double
    //   512: astore #20
    //   514: aload #15
    //   516: invokeinterface iterator : ()Ljava/util/Iterator;
    //   521: astore #21
    //   523: iconst_0
    //   524: istore #9
    //   526: aload #21
    //   528: ifnull -> 597
    //   531: aload #21
    //   533: invokeinterface hasNext : ()Z
    //   538: ifeq -> 597
    //   541: aload #21
    //   543: invokeinterface next : ()Ljava/lang/Object;
    //   548: checkcast java/lang/String
    //   551: astore #22
    //   553: aload #11
    //   555: aload #22
    //   557: invokevirtual containsKey : (Ljava/lang/Object;)Z
    //   560: istore #10
    //   562: dconst_1
    //   563: dstore #5
    //   565: iload #10
    //   567: ifeq -> 850
    //   570: dconst_1
    //   571: dstore_3
    //   572: goto -> 575
    //   575: aload #19
    //   577: iload #9
    //   579: dload_3
    //   580: dastore
    //   581: aload #16
    //   583: aload #22
    //   585: invokevirtual containsKey : (Ljava/lang/Object;)Z
    //   588: ifeq -> 855
    //   591: dload #5
    //   593: dstore_3
    //   594: goto -> 857
    //   597: aload #15
    //   599: invokeinterface clear : ()V
    //   604: aload #19
    //   606: aload #20
    //   608: invokestatic a : ([D[D)[D
    //   611: astore #15
    //   613: aload #15
    //   615: iconst_0
    //   616: daload
    //   617: ldc2_w 0.800000011920929
    //   620: dcmpl
    //   621: iflt -> 627
    //   624: goto -> 832
    //   627: aload #15
    //   629: iconst_1
    //   630: daload
    //   631: dstore_3
    //   632: dload_3
    //   633: invokestatic g : ()D
    //   636: ldc2_w 0.618
    //   639: invokestatic min : (DD)D
    //   642: dcmpl
    //   643: iflt -> 652
    //   646: aload #14
    //   648: astore_2
    //   649: goto -> 680
    //   652: iload #8
    //   654: ifeq -> 872
    //   657: aload #15
    //   659: iconst_0
    //   660: daload
    //   661: invokestatic g : ()D
    //   664: ldc2_w 0.618
    //   667: invokestatic min : (DD)D
    //   670: dcmpl
    //   671: iflt -> 872
    //   674: aload #14
    //   676: astore_2
    //   677: goto -> 680
    //   680: aload #11
    //   682: invokevirtual clear : ()V
    //   685: aload #16
    //   687: invokevirtual clear : ()V
    //   690: aload #17
    //   692: invokevirtual clear : ()V
    //   695: aload_2
    //   696: ifnull -> 810
    //   699: aload_2
    //   700: invokevirtual a : ()Lcom/loc/ds;
    //   703: invokestatic a : (Lcom/loc/ds;)Z
    //   706: ifeq -> 810
    //   709: aload_2
    //   710: invokevirtual a : ()Lcom/loc/ds;
    //   713: astore #11
    //   715: aload #11
    //   717: ldc 'mem'
    //   719: invokevirtual e : (Ljava/lang/String;)V
    //   722: aload #11
    //   724: aload_2
    //   725: invokevirtual b : ()Ljava/lang/String;
    //   728: invokevirtual h : (Ljava/lang/String;)V
    //   731: aload #11
    //   733: invokevirtual getTime : ()J
    //   736: invokestatic a : (J)Z
    //   739: ifeq -> 764
    //   742: aload #11
    //   744: invokestatic a : (Lcom/loc/ds;)Z
    //   747: ifeq -> 755
    //   750: aload_0
    //   751: lconst_0
    //   752: putfield c : J
    //   755: aload #11
    //   757: iconst_4
    //   758: invokevirtual setLocationType : (I)V
    //   761: aload #11
    //   763: areturn
    //   764: aload_0
    //   765: getfield a : Ljava/util/Hashtable;
    //   768: ifnull -> 810
    //   771: aload_0
    //   772: getfield a : Ljava/util/Hashtable;
    //   775: aload_1
    //   776: invokevirtual containsKey : (Ljava/lang/Object;)Z
    //   779: ifeq -> 810
    //   782: aload_0
    //   783: getfield a : Ljava/util/Hashtable;
    //   786: aload_1
    //   787: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   790: checkcast java/util/ArrayList
    //   793: aload_2
    //   794: invokevirtual remove : (Ljava/lang/Object;)Z
    //   797: pop
    //   798: goto -> 810
    //   801: astore_1
    //   802: aload_1
    //   803: ldc 'Cache'
    //   805: ldc 'get1'
    //   807: invokestatic a : (Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   810: aconst_null
    //   811: areturn
    //   812: aconst_null
    //   813: astore_2
    //   814: goto -> 695
    //   817: aload #15
    //   819: iconst_0
    //   820: aaload
    //   821: astore #15
    //   823: goto -> 291
    //   826: iconst_0
    //   827: istore #10
    //   829: goto -> 348
    //   832: aload #14
    //   834: astore_2
    //   835: goto -> 680
    //   838: iconst_1
    //   839: istore #8
    //   841: goto -> 371
    //   844: iconst_0
    //   845: istore #8
    //   847: goto -> 371
    //   850: dconst_0
    //   851: dstore_3
    //   852: goto -> 575
    //   855: dconst_0
    //   856: dstore_3
    //   857: aload #20
    //   859: iload #9
    //   861: dload_3
    //   862: dastore
    //   863: iload #9
    //   865: iconst_1
    //   866: iadd
    //   867: istore #9
    //   869: goto -> 526
    //   872: iload #7
    //   874: iconst_1
    //   875: isub
    //   876: istore #7
    //   878: goto -> 171
    //   881: aconst_null
    //   882: astore_2
    //   883: goto -> 680
    // Exception table:
    //   from	to	target	type
    //   8	26	801	finally
    //   29	85	801	finally
    //   88	105	801	finally
    //   108	119	801	finally
    //   122	171	801	finally
    //   176	221	801	finally
    //   224	244	801	finally
    //   247	288	801	finally
    //   291	299	801	finally
    //   302	345	801	finally
    //   353	368	801	finally
    //   371	407	801	finally
    //   407	416	801	finally
    //   421	439	801	finally
    //   442	454	801	finally
    //   454	482	801	finally
    //   485	523	801	finally
    //   531	562	801	finally
    //   581	591	801	finally
    //   597	613	801	finally
    //   632	646	801	finally
    //   657	674	801	finally
    //   680	695	801	finally
    //   699	755	801	finally
    //   755	761	801	finally
    //   764	798	801	finally
  }
  
  private String a(String paramString, StringBuilder paramStringBuilder, Context paramContext) {
    if (paramContext == null)
      return null; 
    JSONObject jSONObject = new JSONObject();
    try {
      if (this.l == null)
        this.l = dy.a("MD5", k.c(paramContext)); 
      String str = paramString;
      if (paramString.contains("&"))
        str = paramString.substring(0, paramString.indexOf("&")); 
      paramString = str.substring(str.lastIndexOf("#") + 1);
      if (paramString.equals("cgi")) {
        jSONObject.put("cgi", str.substring(0, str.length() - 12));
      } else if (!TextUtils.isEmpty(paramStringBuilder) && paramStringBuilder.indexOf(",access") != -1) {
        String str1;
        int i = paramString.length();
        jSONObject.put("cgi", str.substring(0, str.length() - i + 9));
        String[] arrayOfString = paramStringBuilder.toString().split(",access");
        if (arrayOfString[0].contains("#")) {
          str1 = arrayOfString[0].substring(arrayOfString[0].lastIndexOf("#") + 1);
        } else {
          str1 = str1[0];
        } 
        jSONObject.put("mmac", str1);
      } 
      return o.b(arrayOfByte);
    } finally {
      paramString = null;
    } 
  }
  
  private void a(Context paramContext, String paramString) throws Exception {
    // Byte code:
    //   0: invokestatic e : ()Z
    //   3: ifne -> 7
    //   6: return
    //   7: aload_1
    //   8: ifnonnull -> 12
    //   11: return
    //   12: aload_1
    //   13: ldc_w 'hmdb'
    //   16: iconst_0
    //   17: aconst_null
    //   18: invokevirtual openOrCreateDatabase : (Ljava/lang/String;ILandroid/database/sqlite/SQLiteDatabase$CursorFactory;)Landroid/database/sqlite/SQLiteDatabase;
    //   21: astore #8
    //   23: aload #8
    //   25: ldc_w 'hist'
    //   28: invokestatic a : (Landroid/database/sqlite/SQLiteDatabase;Ljava/lang/String;)Z
    //   31: istore_3
    //   32: iload_3
    //   33: ifne -> 62
    //   36: aload #8
    //   38: ifnull -> 61
    //   41: aload #8
    //   43: invokevirtual isOpen : ()Z
    //   46: ifeq -> 61
    //   49: aload #8
    //   51: invokevirtual close : ()V
    //   54: return
    //   55: astore_1
    //   56: aconst_null
    //   57: astore_2
    //   58: goto -> 1282
    //   61: return
    //   62: invokestatic a : ()J
    //   65: lstore #4
    //   67: invokestatic d : ()J
    //   70: lstore #6
    //   72: new java/lang/StringBuilder
    //   75: dup
    //   76: invokespecial <init> : ()V
    //   79: astore #10
    //   81: aload #10
    //   83: ldc_w 'time >'
    //   86: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   89: pop
    //   90: aload #10
    //   92: lload #4
    //   94: lload #6
    //   96: lsub
    //   97: invokevirtual append : (J)Ljava/lang/StringBuilder;
    //   100: pop
    //   101: aload_2
    //   102: ifnull -> 150
    //   105: aload #10
    //   107: ldc_w ' and feature = ''
    //   110: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   113: pop
    //   114: new java/lang/StringBuilder
    //   117: dup
    //   118: invokespecial <init> : ()V
    //   121: astore #9
    //   123: aload #9
    //   125: aload_2
    //   126: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   129: pop
    //   130: aload #9
    //   132: ldc_w '''
    //   135: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   138: pop
    //   139: aload #10
    //   141: aload #9
    //   143: invokevirtual toString : ()Ljava/lang/String;
    //   146: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   149: pop
    //   150: new java/lang/StringBuilder
    //   153: dup
    //   154: ldc_w 'hist'
    //   157: invokespecial <init> : (Ljava/lang/String;)V
    //   160: astore_2
    //   161: aload_2
    //   162: aload_0
    //   163: getfield k : Ljava/lang/String;
    //   166: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   169: pop
    //   170: aload_2
    //   171: invokevirtual toString : ()Ljava/lang/String;
    //   174: astore_2
    //   175: aload #10
    //   177: invokevirtual toString : ()Ljava/lang/String;
    //   180: astore #9
    //   182: aload #8
    //   184: aload_2
    //   185: iconst_3
    //   186: anewarray java/lang/String
    //   189: dup
    //   190: iconst_0
    //   191: ldc_w 'feature'
    //   194: aastore
    //   195: dup
    //   196: iconst_1
    //   197: ldc_w ' nb'
    //   200: aastore
    //   201: dup
    //   202: iconst_2
    //   203: ldc_w 'loc'
    //   206: aastore
    //   207: aload #9
    //   209: aconst_null
    //   210: aconst_null
    //   211: aconst_null
    //   212: ldc_w 'time ASC'
    //   215: aconst_null
    //   216: invokevirtual query : (Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   219: astore #11
    //   221: aload #8
    //   223: astore #9
    //   225: new java/lang/StringBuilder
    //   228: dup
    //   229: invokespecial <init> : ()V
    //   232: astore #15
    //   234: aload #8
    //   236: astore #9
    //   238: aload_0
    //   239: getfield l : Ljava/lang/String;
    //   242: ifnonnull -> 262
    //   245: aload #8
    //   247: astore #9
    //   249: aload_0
    //   250: ldc 'MD5'
    //   252: aload_1
    //   253: invokestatic c : (Landroid/content/Context;)Ljava/lang/String;
    //   256: invokestatic a : (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   259: putfield l : Ljava/lang/String;
    //   262: aload #11
    //   264: ifnull -> 1228
    //   267: aload #8
    //   269: astore #9
    //   271: aload #11
    //   273: invokeinterface moveToFirst : ()Z
    //   278: ifeq -> 1228
    //   281: aload #8
    //   283: astore_2
    //   284: aload #10
    //   286: astore #8
    //   288: aload_2
    //   289: astore #9
    //   291: aload #11
    //   293: iconst_0
    //   294: invokeinterface getString : (I)Ljava/lang/String;
    //   299: ldc_w '{'
    //   302: invokevirtual startsWith : (Ljava/lang/String;)Z
    //   305: istore_3
    //   306: ldc ',access'
    //   308: astore #10
    //   310: iload_3
    //   311: ifeq -> 506
    //   314: aload_2
    //   315: astore #9
    //   317: new org/json/JSONObject
    //   320: dup
    //   321: aload #11
    //   323: iconst_0
    //   324: invokeinterface getString : (I)Ljava/lang/String;
    //   329: invokespecial <init> : (Ljava/lang/String;)V
    //   332: astore #13
    //   334: aload_2
    //   335: astore #9
    //   337: aload #15
    //   339: iconst_0
    //   340: aload #15
    //   342: invokevirtual length : ()I
    //   345: invokevirtual delete : (II)Ljava/lang/StringBuilder;
    //   348: pop
    //   349: aload_2
    //   350: astore #9
    //   352: aload #11
    //   354: iconst_1
    //   355: invokeinterface getString : (I)Ljava/lang/String;
    //   360: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   363: ifne -> 393
    //   366: aload_2
    //   367: astore #9
    //   369: aload #11
    //   371: iconst_1
    //   372: invokeinterface getString : (I)Ljava/lang/String;
    //   377: astore #10
    //   379: aload_2
    //   380: astore #9
    //   382: aload #15
    //   384: aload #10
    //   386: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   389: pop
    //   390: goto -> 438
    //   393: aload_2
    //   394: astore #9
    //   396: aload #13
    //   398: ldc_w 'mmac'
    //   401: invokestatic a : (Lorg/json/JSONObject;Ljava/lang/String;)Z
    //   404: ifeq -> 438
    //   407: aload_2
    //   408: astore #9
    //   410: aload #15
    //   412: ldc '#'
    //   414: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   417: pop
    //   418: aload_2
    //   419: astore #9
    //   421: aload #15
    //   423: aload #13
    //   425: ldc_w 'mmac'
    //   428: invokevirtual getString : (Ljava/lang/String;)Ljava/lang/String;
    //   431: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   434: pop
    //   435: goto -> 379
    //   438: aload_2
    //   439: astore #9
    //   441: new org/json/JSONObject
    //   444: dup
    //   445: aload #11
    //   447: iconst_2
    //   448: invokeinterface getString : (I)Ljava/lang/String;
    //   453: invokespecial <init> : (Ljava/lang/String;)V
    //   456: astore #14
    //   458: aload #13
    //   460: astore #10
    //   462: aload #14
    //   464: astore #12
    //   466: aload_2
    //   467: astore #9
    //   469: aload #14
    //   471: ldc_w 'type'
    //   474: invokestatic a : (Lorg/json/JSONObject;Ljava/lang/String;)Z
    //   477: ifeq -> 742
    //   480: aload_2
    //   481: astore #9
    //   483: aload #14
    //   485: ldc_w 'type'
    //   488: ldc_w 'new'
    //   491: invokevirtual put : (Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   494: pop
    //   495: aload #13
    //   497: astore #10
    //   499: aload #14
    //   501: astore #12
    //   503: goto -> 742
    //   506: aload_2
    //   507: astore #9
    //   509: new org/json/JSONObject
    //   512: dup
    //   513: new java/lang/String
    //   516: dup
    //   517: aload #11
    //   519: iconst_0
    //   520: invokeinterface getString : (I)Ljava/lang/String;
    //   525: invokestatic b : (Ljava/lang/String;)[B
    //   528: aload_0
    //   529: getfield l : Ljava/lang/String;
    //   532: invokestatic b : ([BLjava/lang/String;)[B
    //   535: ldc_w 'UTF-8'
    //   538: invokespecial <init> : ([BLjava/lang/String;)V
    //   541: invokespecial <init> : (Ljava/lang/String;)V
    //   544: astore #12
    //   546: aload_2
    //   547: astore #9
    //   549: aload #15
    //   551: iconst_0
    //   552: aload #15
    //   554: invokevirtual length : ()I
    //   557: invokevirtual delete : (II)Ljava/lang/StringBuilder;
    //   560: pop
    //   561: aload_2
    //   562: astore #9
    //   564: aload #11
    //   566: iconst_1
    //   567: invokeinterface getString : (I)Ljava/lang/String;
    //   572: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   575: ifne -> 625
    //   578: aload_2
    //   579: astore #9
    //   581: new java/lang/String
    //   584: dup
    //   585: aload #11
    //   587: iconst_1
    //   588: invokeinterface getString : (I)Ljava/lang/String;
    //   593: invokestatic b : (Ljava/lang/String;)[B
    //   596: aload_0
    //   597: getfield l : Ljava/lang/String;
    //   600: invokestatic b : ([BLjava/lang/String;)[B
    //   603: ldc_w 'UTF-8'
    //   606: invokespecial <init> : ([BLjava/lang/String;)V
    //   609: astore #10
    //   611: aload_2
    //   612: astore #9
    //   614: aload #15
    //   616: aload #10
    //   618: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   621: pop
    //   622: goto -> 670
    //   625: aload_2
    //   626: astore #9
    //   628: aload #12
    //   630: ldc_w 'mmac'
    //   633: invokestatic a : (Lorg/json/JSONObject;Ljava/lang/String;)Z
    //   636: ifeq -> 670
    //   639: aload_2
    //   640: astore #9
    //   642: aload #15
    //   644: ldc '#'
    //   646: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   649: pop
    //   650: aload_2
    //   651: astore #9
    //   653: aload #15
    //   655: aload #12
    //   657: ldc_w 'mmac'
    //   660: invokevirtual getString : (Ljava/lang/String;)Ljava/lang/String;
    //   663: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   666: pop
    //   667: goto -> 611
    //   670: aload_2
    //   671: astore #9
    //   673: new org/json/JSONObject
    //   676: dup
    //   677: new java/lang/String
    //   680: dup
    //   681: aload #11
    //   683: iconst_2
    //   684: invokeinterface getString : (I)Ljava/lang/String;
    //   689: invokestatic b : (Ljava/lang/String;)[B
    //   692: aload_0
    //   693: getfield l : Ljava/lang/String;
    //   696: invokestatic b : ([BLjava/lang/String;)[B
    //   699: ldc_w 'UTF-8'
    //   702: invokespecial <init> : ([BLjava/lang/String;)V
    //   705: invokespecial <init> : (Ljava/lang/String;)V
    //   708: astore #13
    //   710: aload_2
    //   711: astore #9
    //   713: aload #13
    //   715: ldc_w 'type'
    //   718: invokestatic a : (Lorg/json/JSONObject;Ljava/lang/String;)Z
    //   721: ifeq -> 1352
    //   724: aload_2
    //   725: astore #9
    //   727: aload #13
    //   729: ldc_w 'type'
    //   732: ldc_w 'new'
    //   735: invokevirtual put : (Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   738: pop
    //   739: goto -> 1352
    //   742: aload_2
    //   743: astore #9
    //   745: new com/loc/ds
    //   748: dup
    //   749: ldc ''
    //   751: invokespecial <init> : (Ljava/lang/String;)V
    //   754: astore #13
    //   756: aload_2
    //   757: astore #9
    //   759: aload #13
    //   761: aload #12
    //   763: invokevirtual b : (Lorg/json/JSONObject;)V
    //   766: aload_2
    //   767: astore #9
    //   769: aload #10
    //   771: ldc_w 'mmac'
    //   774: invokestatic a : (Lorg/json/JSONObject;Ljava/lang/String;)Z
    //   777: istore_3
    //   778: iload_3
    //   779: ifeq -> 991
    //   782: aload_2
    //   783: astore #9
    //   785: aload #10
    //   787: ldc 'cgi'
    //   789: invokestatic a : (Lorg/json/JSONObject;Ljava/lang/String;)Z
    //   792: ifeq -> 991
    //   795: aload_2
    //   796: astore #9
    //   798: new java/lang/StringBuilder
    //   801: dup
    //   802: invokespecial <init> : ()V
    //   805: astore #12
    //   807: aload_2
    //   808: astore #9
    //   810: aload #12
    //   812: aload #10
    //   814: ldc 'cgi'
    //   816: invokevirtual getString : (Ljava/lang/String;)Ljava/lang/String;
    //   819: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   822: pop
    //   823: aload_2
    //   824: astore #9
    //   826: aload #12
    //   828: ldc '#'
    //   830: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   833: pop
    //   834: aload_2
    //   835: astore #9
    //   837: aload #12
    //   839: invokevirtual toString : ()Ljava/lang/String;
    //   842: astore #12
    //   844: aload_2
    //   845: astore #9
    //   847: new java/lang/StringBuilder
    //   850: dup
    //   851: invokespecial <init> : ()V
    //   854: astore #14
    //   856: aload_2
    //   857: astore #9
    //   859: aload #14
    //   861: aload #12
    //   863: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   866: pop
    //   867: aload_2
    //   868: astore #9
    //   870: aload #14
    //   872: ldc_w 'network#'
    //   875: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   878: pop
    //   879: aload_2
    //   880: astore #9
    //   882: aload #14
    //   884: invokevirtual toString : ()Ljava/lang/String;
    //   887: astore #12
    //   889: aload_2
    //   890: astore #9
    //   892: aload #10
    //   894: ldc 'cgi'
    //   896: invokevirtual getString : (Ljava/lang/String;)Ljava/lang/String;
    //   899: ldc '#'
    //   901: invokevirtual contains : (Ljava/lang/CharSequence;)Z
    //   904: ifeq -> 944
    //   907: aload_2
    //   908: astore #9
    //   910: new java/lang/StringBuilder
    //   913: dup
    //   914: invokespecial <init> : ()V
    //   917: astore #10
    //   919: aload_2
    //   920: astore #9
    //   922: aload #10
    //   924: aload #12
    //   926: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   929: pop
    //   930: aload_2
    //   931: astore #9
    //   933: aload #10
    //   935: ldc 'cgiwifi'
    //   937: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   940: pop
    //   941: goto -> 978
    //   944: aload_2
    //   945: astore #9
    //   947: new java/lang/StringBuilder
    //   950: dup
    //   951: invokespecial <init> : ()V
    //   954: astore #10
    //   956: aload_2
    //   957: astore #9
    //   959: aload #10
    //   961: aload #12
    //   963: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   966: pop
    //   967: aload_2
    //   968: astore #9
    //   970: aload #10
    //   972: ldc 'wifi'
    //   974: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   977: pop
    //   978: aload_2
    //   979: astore #9
    //   981: aload #10
    //   983: invokevirtual toString : ()Ljava/lang/String;
    //   986: astore #10
    //   988: goto -> 1153
    //   991: aload_2
    //   992: astore #9
    //   994: aload #10
    //   996: ldc 'cgi'
    //   998: invokestatic a : (Lorg/json/JSONObject;Ljava/lang/String;)Z
    //   1001: ifeq -> 1363
    //   1004: aload_2
    //   1005: astore #9
    //   1007: new java/lang/StringBuilder
    //   1010: dup
    //   1011: invokespecial <init> : ()V
    //   1014: astore #12
    //   1016: aload_2
    //   1017: astore #9
    //   1019: aload #12
    //   1021: aload #10
    //   1023: ldc 'cgi'
    //   1025: invokevirtual getString : (Ljava/lang/String;)Ljava/lang/String;
    //   1028: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1031: pop
    //   1032: aload_2
    //   1033: astore #9
    //   1035: aload #12
    //   1037: ldc '#'
    //   1039: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1042: pop
    //   1043: aload_2
    //   1044: astore #9
    //   1046: aload #12
    //   1048: invokevirtual toString : ()Ljava/lang/String;
    //   1051: astore #12
    //   1053: aload_2
    //   1054: astore #9
    //   1056: new java/lang/StringBuilder
    //   1059: dup
    //   1060: invokespecial <init> : ()V
    //   1063: astore #14
    //   1065: aload_2
    //   1066: astore #9
    //   1068: aload #14
    //   1070: aload #12
    //   1072: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1075: pop
    //   1076: aload_2
    //   1077: astore #9
    //   1079: aload #14
    //   1081: ldc_w 'network#'
    //   1084: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1087: pop
    //   1088: aload_2
    //   1089: astore #9
    //   1091: aload #14
    //   1093: invokevirtual toString : ()Ljava/lang/String;
    //   1096: astore #12
    //   1098: aload_2
    //   1099: astore #9
    //   1101: aload #10
    //   1103: ldc 'cgi'
    //   1105: invokevirtual getString : (Ljava/lang/String;)Ljava/lang/String;
    //   1108: ldc '#'
    //   1110: invokevirtual contains : (Ljava/lang/CharSequence;)Z
    //   1113: ifeq -> 1363
    //   1116: aload_2
    //   1117: astore #9
    //   1119: new java/lang/StringBuilder
    //   1122: dup
    //   1123: invokespecial <init> : ()V
    //   1126: astore #10
    //   1128: aload_2
    //   1129: astore #9
    //   1131: aload #10
    //   1133: aload #12
    //   1135: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1138: pop
    //   1139: aload_2
    //   1140: astore #9
    //   1142: aload #10
    //   1144: ldc 'cgi'
    //   1146: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1149: pop
    //   1150: goto -> 978
    //   1153: aload_0
    //   1154: aload #10
    //   1156: aload #15
    //   1158: aload #13
    //   1160: aload_1
    //   1161: iconst_0
    //   1162: invokevirtual a : (Ljava/lang/String;Ljava/lang/StringBuilder;Lcom/loc/ds;Landroid/content/Context;Z)V
    //   1165: goto -> 1168
    //   1168: aload_2
    //   1169: astore #9
    //   1171: aload #11
    //   1173: invokeinterface moveToNext : ()Z
    //   1178: ifne -> 1212
    //   1181: aload #15
    //   1183: iconst_0
    //   1184: aload #15
    //   1186: invokevirtual length : ()I
    //   1189: invokevirtual delete : (II)Ljava/lang/StringBuilder;
    //   1192: pop
    //   1193: aload #8
    //   1195: iconst_0
    //   1196: aload #8
    //   1198: invokevirtual length : ()I
    //   1201: invokevirtual delete : (II)Ljava/lang/StringBuilder;
    //   1204: pop
    //   1205: aload #9
    //   1207: astore #8
    //   1209: goto -> 1228
    //   1212: aload #9
    //   1214: astore_2
    //   1215: goto -> 288
    //   1218: aload_2
    //   1219: astore #8
    //   1221: astore_1
    //   1222: aload #11
    //   1224: astore_2
    //   1225: goto -> 1282
    //   1228: aload #11
    //   1230: ifnull -> 1240
    //   1233: aload #11
    //   1235: invokeinterface close : ()V
    //   1240: aload #8
    //   1242: ifnull -> 1258
    //   1245: aload #8
    //   1247: invokevirtual isOpen : ()Z
    //   1250: ifeq -> 1258
    //   1253: aload #8
    //   1255: invokevirtual close : ()V
    //   1258: return
    //   1259: astore_1
    //   1260: aload #9
    //   1262: astore #8
    //   1264: aload #11
    //   1266: astore_2
    //   1267: goto -> 58
    //   1270: astore_1
    //   1271: aconst_null
    //   1272: astore_2
    //   1273: goto -> 1282
    //   1276: astore_1
    //   1277: aconst_null
    //   1278: astore_2
    //   1279: aload_2
    //   1280: astore #8
    //   1282: aload_1
    //   1283: ldc_w 'DB'
    //   1286: ldc_w 'fetchHist p2'
    //   1289: invokestatic a : (Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   1292: aload_2
    //   1293: ifnull -> 1302
    //   1296: aload_2
    //   1297: invokeinterface close : ()V
    //   1302: aload #8
    //   1304: ifnull -> 1320
    //   1307: aload #8
    //   1309: invokevirtual isOpen : ()Z
    //   1312: ifeq -> 1320
    //   1315: aload #8
    //   1317: invokevirtual close : ()V
    //   1320: return
    //   1321: astore_1
    //   1322: aload_2
    //   1323: ifnull -> 1332
    //   1326: aload_2
    //   1327: invokeinterface close : ()V
    //   1332: aload #8
    //   1334: ifnull -> 1350
    //   1337: aload #8
    //   1339: invokevirtual isOpen : ()Z
    //   1342: ifeq -> 1350
    //   1345: aload #8
    //   1347: invokevirtual close : ()V
    //   1350: aload_1
    //   1351: athrow
    //   1352: aload #12
    //   1354: astore #10
    //   1356: aload #13
    //   1358: astore #12
    //   1360: goto -> 742
    //   1363: goto -> 1168
    // Exception table:
    //   from	to	target	type
    //   12	23	1276	finally
    //   23	32	1270	finally
    //   41	54	55	finally
    //   62	101	1270	finally
    //   105	150	55	finally
    //   150	182	1270	finally
    //   182	221	1270	finally
    //   225	234	1259	finally
    //   238	245	1259	finally
    //   249	262	1259	finally
    //   271	281	1259	finally
    //   291	306	1259	finally
    //   317	334	1259	finally
    //   337	349	1259	finally
    //   352	366	1259	finally
    //   369	379	1259	finally
    //   382	390	1259	finally
    //   396	407	1259	finally
    //   410	418	1259	finally
    //   421	435	1259	finally
    //   441	458	1259	finally
    //   469	480	1259	finally
    //   483	495	1259	finally
    //   509	546	1259	finally
    //   549	561	1259	finally
    //   564	578	1259	finally
    //   581	611	1259	finally
    //   614	622	1259	finally
    //   628	639	1259	finally
    //   642	650	1259	finally
    //   653	667	1259	finally
    //   673	710	1259	finally
    //   713	724	1259	finally
    //   727	739	1259	finally
    //   745	756	1259	finally
    //   759	766	1259	finally
    //   769	778	1259	finally
    //   785	795	1259	finally
    //   798	807	1259	finally
    //   810	823	1259	finally
    //   826	834	1259	finally
    //   837	844	1259	finally
    //   847	856	1259	finally
    //   859	867	1259	finally
    //   870	879	1259	finally
    //   882	889	1259	finally
    //   892	907	1259	finally
    //   910	919	1259	finally
    //   922	930	1259	finally
    //   933	941	1259	finally
    //   947	956	1259	finally
    //   959	967	1259	finally
    //   970	978	1259	finally
    //   981	988	1259	finally
    //   994	1004	1259	finally
    //   1007	1016	1259	finally
    //   1019	1032	1259	finally
    //   1035	1043	1259	finally
    //   1046	1053	1259	finally
    //   1056	1065	1259	finally
    //   1068	1076	1259	finally
    //   1079	1088	1259	finally
    //   1091	1098	1259	finally
    //   1101	1116	1259	finally
    //   1119	1128	1259	finally
    //   1131	1139	1259	finally
    //   1142	1150	1259	finally
    //   1153	1165	1218	finally
    //   1171	1205	1218	finally
    //   1282	1292	1321	finally
  }
  
  private void a(String paramString, AMapLocation paramAMapLocation, StringBuilder paramStringBuilder, Context paramContext) throws Exception {
    SQLiteDatabase sQLiteDatabase;
    if (paramContext == null)
      return; 
    if (this.l == null)
      this.l = dy.a("MD5", k.c(paramContext)); 
    String str = a(paramString, paramStringBuilder, paramContext);
    StringBuilder stringBuilder = new StringBuilder();
    paramString = null;
    try {
      SQLiteDatabase sQLiteDatabase1 = paramContext.openOrCreateDatabase("hmdb", 0, null);
      sQLiteDatabase = sQLiteDatabase1;
      stringBuilder.append("CREATE TABLE IF NOT EXISTS hist");
      sQLiteDatabase = sQLiteDatabase1;
      stringBuilder.append(this.k);
      sQLiteDatabase = sQLiteDatabase1;
      stringBuilder.append(" (feature VARCHAR PRIMARY KEY, nb VARCHAR, loc VARCHAR, time VARCHAR);");
      sQLiteDatabase = sQLiteDatabase1;
      sQLiteDatabase1.execSQL(stringBuilder.toString());
      sQLiteDatabase = sQLiteDatabase1;
      stringBuilder.delete(0, stringBuilder.length());
      sQLiteDatabase = sQLiteDatabase1;
      stringBuilder.append("REPLACE INTO ");
      sQLiteDatabase = sQLiteDatabase1;
      stringBuilder.append("hist");
      sQLiteDatabase = sQLiteDatabase1;
      stringBuilder.append(this.k);
      sQLiteDatabase = sQLiteDatabase1;
      stringBuilder.append(" VALUES (?, ?, ?, ?)");
      sQLiteDatabase = sQLiteDatabase1;
      Object[] arrayOfObject = new Object[4];
      arrayOfObject[0] = str;
      sQLiteDatabase = sQLiteDatabase1;
      byte[] arrayOfByte = dy.a(paramStringBuilder.toString().getBytes("UTF-8"), this.l);
      int i = 1;
      arrayOfObject[1] = arrayOfByte;
      sQLiteDatabase = sQLiteDatabase1;
      arrayOfObject[2] = dy.a(paramAMapLocation.toStr().getBytes("UTF-8"), this.l);
      sQLiteDatabase = sQLiteDatabase1;
      arrayOfObject[3] = Long.valueOf(paramAMapLocation.getTime());
      while (i < 3) {
        sQLiteDatabase = sQLiteDatabase1;
        arrayOfObject[i] = o.b((byte[])arrayOfObject[i]);
        i++;
      } 
      sQLiteDatabase = sQLiteDatabase1;
      sQLiteDatabase1.execSQL(stringBuilder.toString(), arrayOfObject);
      sQLiteDatabase = sQLiteDatabase1;
      stringBuilder.delete(0, stringBuilder.length());
      stringBuilder.delete(0, stringBuilder.length());
      return;
    } finally {
      paramAMapLocation = null;
    } 
  }
  
  private static void a(String paramString, Hashtable<String, String> paramHashtable) {
    if (TextUtils.isEmpty(paramString))
      return; 
    paramHashtable.clear();
    for (String str : paramString.split("#")) {
      if (!TextUtils.isEmpty(str) && !str.contains("|"))
        paramHashtable.put(str, ""); 
    } 
  }
  
  private static double[] a(double[] paramArrayOfdouble1, double[] paramArrayOfdouble2) {
    double[] arrayOfDouble = new double[3];
    byte b = 0;
    double d3 = 0.0D;
    double d1 = d3;
    double d2 = d1;
    int j = 0;
    int k = 0;
    int m;
    for (m = 0; j < paramArrayOfdouble1.length; m = n) {
      d1 += paramArrayOfdouble1[j] * paramArrayOfdouble1[j];
      d2 += paramArrayOfdouble2[j] * paramArrayOfdouble2[j];
      d3 += paramArrayOfdouble1[j] * paramArrayOfdouble2[j];
      int i1 = k;
      int n = m;
      if (paramArrayOfdouble2[j] == 1.0D) {
        m++;
        i1 = k;
        n = m;
        if (paramArrayOfdouble1[j] == 1.0D) {
          i1 = k + 1;
          n = m;
        } 
      } 
      j++;
      k = i1;
    } 
    arrayOfDouble[0] = d3 / Math.sqrt(d1) * Math.sqrt(d2);
    d1 = k;
    arrayOfDouble[1] = d1 * 1.0D / m;
    arrayOfDouble[2] = d1;
    int i;
    for (i = b; i < 2; i++) {
      if (arrayOfDouble[i] > 1.0D)
        arrayOfDouble[i] = 1.0D; 
    } 
    return arrayOfDouble;
  }
  
  private boolean b() {
    long l1 = ep.b();
    long l2 = this.i;
    boolean bool = false;
    if (l2 == 0L)
      return false; 
    if (this.a.size() > 360 || l1 - l2 > 36000000L)
      bool = true; 
    return bool;
  }
  
  private void c() {
    this.i = 0L;
    if (!this.a.isEmpty())
      this.a.clear(); 
    this.j = false;
  }
  
  public final ds a(Context paramContext, String paramString, StringBuilder paramStringBuilder, boolean paramBoolean) {
    if (TextUtils.isEmpty(paramString))
      return null; 
    if (!ei.e())
      return null; 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramString);
    stringBuilder.append("&");
    stringBuilder.append(this.f);
    stringBuilder.append("&");
    stringBuilder.append(this.g);
    stringBuilder.append("&");
    stringBuilder.append(this.h);
    paramString = stringBuilder.toString();
    if (!paramString.contains("gps") && ei.e()) {
      if (paramStringBuilder == null)
        return null; 
      if (b()) {
        c();
        return null;
      } 
      if (paramBoolean && !this.j)
        try {
          String str = a(paramString, paramStringBuilder, paramContext);
          c();
          a(paramContext, str);
        } finally {} 
      return this.a.isEmpty() ? null : a(paramString, paramStringBuilder);
    } 
    return null;
  }
  
  public final ds a(dw paramdw, boolean paramBoolean1, ds paramds, dx paramdx, StringBuilder paramStringBuilder, String paramString, Context paramContext, boolean paramBoolean2) {
    // Byte code:
    //   0: invokestatic e : ()Z
    //   3: istore #12
    //   5: iconst_1
    //   6: istore #11
    //   8: iload #12
    //   10: ifne -> 18
    //   13: iload #8
    //   15: ifeq -> 39
    //   18: aload_0
    //   19: getfield b : Z
    //   22: ifne -> 45
    //   25: invokestatic f : ()Z
    //   28: ifne -> 45
    //   31: iload #8
    //   33: ifeq -> 39
    //   36: goto -> 45
    //   39: iconst_0
    //   40: istore #9
    //   42: goto -> 48
    //   45: iconst_1
    //   46: istore #9
    //   48: iload #9
    //   50: ifne -> 59
    //   53: iconst_0
    //   54: istore #9
    //   56: goto -> 84
    //   59: aload_3
    //   60: ifnull -> 81
    //   63: aload_3
    //   64: invokevirtual getTime : ()J
    //   67: invokestatic a : (J)Z
    //   70: ifne -> 81
    //   73: iload #8
    //   75: ifne -> 81
    //   78: goto -> 53
    //   81: iconst_1
    //   82: istore #9
    //   84: iload #9
    //   86: ifne -> 91
    //   89: aconst_null
    //   90: areturn
    //   91: aload_1
    //   92: invokevirtual d : ()Lcom/loc/dv;
    //   95: astore_1
    //   96: aload_1
    //   97: ifnonnull -> 107
    //   100: aload_0
    //   101: getfield e : Lcom/loc/dv;
    //   104: ifnull -> 419
    //   107: aload_0
    //   108: getfield e : Lcom/loc/dv;
    //   111: ifnull -> 425
    //   114: aload_0
    //   115: getfield e : Lcom/loc/dv;
    //   118: aload_1
    //   119: invokevirtual equals : (Ljava/lang/Object;)Z
    //   122: ifne -> 419
    //   125: goto -> 425
    //   128: aload_3
    //   129: ifnull -> 431
    //   132: aload #4
    //   134: invokevirtual e : ()Ljava/util/ArrayList;
    //   137: invokevirtual size : ()I
    //   140: istore #9
    //   142: aload_3
    //   143: invokevirtual getAccuracy : ()F
    //   146: ldc_w 299.0
    //   149: fcmpl
    //   150: ifle -> 431
    //   153: iload #9
    //   155: iconst_5
    //   156: if_icmple -> 431
    //   159: iconst_1
    //   160: istore #9
    //   162: goto -> 165
    //   165: aload_3
    //   166: ifnull -> 457
    //   169: aload_0
    //   170: getfield d : Ljava/lang/String;
    //   173: ifnull -> 457
    //   176: iload #9
    //   178: ifne -> 457
    //   181: iload #10
    //   183: ifne -> 457
    //   186: aload_0
    //   187: getfield d : Ljava/lang/String;
    //   190: aload #5
    //   192: invokevirtual toString : ()Ljava/lang/String;
    //   195: invokestatic a : (Ljava/lang/String;Ljava/lang/String;)Z
    //   198: istore #12
    //   200: aload_0
    //   201: getfield c : J
    //   204: lconst_0
    //   205: lcmp
    //   206: ifeq -> 437
    //   209: invokestatic b : ()J
    //   212: aload_0
    //   213: getfield c : J
    //   216: lsub
    //   217: ldc2_w 3000
    //   220: lcmp
    //   221: ifge -> 437
    //   224: iconst_1
    //   225: istore #10
    //   227: goto -> 440
    //   230: iload #12
    //   232: istore #8
    //   234: aload_3
    //   235: invokestatic a : (Lcom/loc/ds;)Z
    //   238: ifeq -> 254
    //   241: aload_3
    //   242: ldc 'mem'
    //   244: invokevirtual e : (Ljava/lang/String;)V
    //   247: aload_3
    //   248: iconst_2
    //   249: invokevirtual setLocationType : (I)V
    //   252: aload_3
    //   253: areturn
    //   254: iload #8
    //   256: ifne -> 269
    //   259: aload_0
    //   260: invokestatic b : ()J
    //   263: putfield c : J
    //   266: goto -> 274
    //   269: aload_0
    //   270: lconst_0
    //   271: putfield c : J
    //   274: aload_0
    //   275: getfield m : Ljava/lang/String;
    //   278: ifnull -> 336
    //   281: aload #6
    //   283: aload_0
    //   284: getfield m : Ljava/lang/String;
    //   287: invokevirtual equals : (Ljava/lang/Object;)Z
    //   290: ifne -> 336
    //   293: invokestatic a : ()J
    //   296: aload_0
    //   297: getfield n : J
    //   300: lsub
    //   301: ldc2_w 3000
    //   304: lcmp
    //   305: ifge -> 316
    //   308: aload_0
    //   309: getfield m : Ljava/lang/String;
    //   312: astore_1
    //   313: goto -> 361
    //   316: invokestatic a : ()J
    //   319: lstore #13
    //   321: aload_0
    //   322: lload #13
    //   324: putfield n : J
    //   327: aload_0
    //   328: aload #6
    //   330: putfield m : Ljava/lang/String;
    //   333: goto -> 463
    //   336: aload_0
    //   337: getfield m : Ljava/lang/String;
    //   340: ifnonnull -> 351
    //   343: invokestatic a : ()J
    //   346: lstore #13
    //   348: goto -> 321
    //   351: aload_0
    //   352: invokestatic a : ()J
    //   355: putfield n : J
    //   358: goto -> 463
    //   361: iload #9
    //   363: ifne -> 469
    //   366: iload_2
    //   367: ifne -> 469
    //   370: aload_0
    //   371: aload #7
    //   373: aload_1
    //   374: aload #5
    //   376: iconst_0
    //   377: invokevirtual a : (Landroid/content/Context;Ljava/lang/String;Ljava/lang/StringBuilder;Z)Lcom/loc/ds;
    //   380: astore_1
    //   381: goto -> 384
    //   384: iload_2
    //   385: ifne -> 474
    //   388: aload_1
    //   389: invokestatic a : (Lcom/loc/ds;)Z
    //   392: ifne -> 474
    //   395: iload #11
    //   397: istore #10
    //   399: goto -> 477
    //   402: aload_0
    //   403: lconst_0
    //   404: putfield c : J
    //   407: aload_1
    //   408: iconst_4
    //   409: invokevirtual setLocationType : (I)V
    //   412: aload_1
    //   413: areturn
    //   414: aconst_null
    //   415: areturn
    //   416: astore_1
    //   417: aconst_null
    //   418: areturn
    //   419: iconst_0
    //   420: istore #10
    //   422: goto -> 128
    //   425: iconst_1
    //   426: istore #10
    //   428: goto -> 128
    //   431: iconst_0
    //   432: istore #9
    //   434: goto -> 165
    //   437: iconst_0
    //   438: istore #10
    //   440: iload #12
    //   442: ifne -> 230
    //   445: iload #12
    //   447: istore #8
    //   449: iload #10
    //   451: ifeq -> 254
    //   454: goto -> 230
    //   457: iconst_0
    //   458: istore #8
    //   460: goto -> 254
    //   463: aload #6
    //   465: astore_1
    //   466: goto -> 361
    //   469: aconst_null
    //   470: astore_1
    //   471: goto -> 384
    //   474: iconst_0
    //   475: istore #10
    //   477: iload #10
    //   479: ifne -> 414
    //   482: iload #9
    //   484: ifeq -> 489
    //   487: aconst_null
    //   488: areturn
    //   489: iload_2
    //   490: ifeq -> 402
    //   493: aconst_null
    //   494: areturn
    // Exception table:
    //   from	to	target	type
    //   91	96	416	finally
    //   100	107	416	finally
    //   107	125	416	finally
    //   132	153	416	finally
    //   169	176	416	finally
    //   186	224	416	finally
    //   234	252	416	finally
    //   259	266	416	finally
    //   269	274	416	finally
    //   274	313	416	finally
    //   316	321	416	finally
    //   321	333	416	finally
    //   336	348	416	finally
    //   351	358	416	finally
    //   370	381	416	finally
    //   388	395	416	finally
    //   402	412	416	finally
  }
  
  public final void a() {
    this.c = 0L;
    this.d = null;
  }
  
  public final void a(Context paramContext) {
    if (this.j)
      return; 
    try {
      c();
      a(paramContext, (String)null);
    } finally {
      paramContext = null;
    } 
  }
  
  public final void a(AMapLocationClientOption paramAMapLocationClientOption) {
    this.g = paramAMapLocationClientOption.isNeedAddress();
    this.f = paramAMapLocationClientOption.isOffset();
    this.b = paramAMapLocationClientOption.isLocationCacheEnable();
    this.h = String.valueOf(paramAMapLocationClientOption.getGeoLanguage());
  }
  
  public final void a(dv paramdv) {
    this.e = paramdv;
  }
  
  public final void a(String paramString) {
    this.d = paramString;
  }
  
  public final void a(String paramString, StringBuilder paramStringBuilder, ds paramds, Context paramContext, boolean paramBoolean) {
    // Byte code:
    //   0: aload_3
    //   1: invokestatic a : (Lcom/loc/ds;)Z
    //   4: ifne -> 8
    //   7: return
    //   8: new java/lang/StringBuilder
    //   11: dup
    //   12: invokespecial <init> : ()V
    //   15: astore #11
    //   17: aload #11
    //   19: aload_1
    //   20: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: pop
    //   24: aload #11
    //   26: ldc_w '&'
    //   29: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   32: pop
    //   33: aload #11
    //   35: aload_3
    //   36: invokevirtual isOffset : ()Z
    //   39: invokevirtual append : (Z)Ljava/lang/StringBuilder;
    //   42: pop
    //   43: aload #11
    //   45: ldc_w '&'
    //   48: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   51: pop
    //   52: aload #11
    //   54: aload_3
    //   55: invokevirtual i : ()Z
    //   58: invokevirtual append : (Z)Ljava/lang/StringBuilder;
    //   61: pop
    //   62: aload #11
    //   64: ldc_w '&'
    //   67: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   70: pop
    //   71: aload #11
    //   73: aload_3
    //   74: invokevirtual j : ()Ljava/lang/String;
    //   77: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   80: pop
    //   81: aload #11
    //   83: invokevirtual toString : ()Ljava/lang/String;
    //   86: astore #11
    //   88: aload #11
    //   90: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   93: istore #10
    //   95: iconst_0
    //   96: istore #6
    //   98: iload #10
    //   100: ifne -> 603
    //   103: aload_3
    //   104: invokestatic a : (Lcom/loc/ds;)Z
    //   107: ifne -> 113
    //   110: goto -> 603
    //   113: aload #11
    //   115: ldc '#'
    //   117: invokevirtual startsWith : (Ljava/lang/String;)Z
    //   120: ifeq -> 126
    //   123: goto -> 603
    //   126: aload #11
    //   128: ldc_w 'network'
    //   131: invokevirtual contains : (Ljava/lang/CharSequence;)Z
    //   134: istore #10
    //   136: goto -> 606
    //   139: aload_3
    //   140: invokevirtual e : ()Ljava/lang/String;
    //   143: ldc 'mem'
    //   145: invokevirtual equals : (Ljava/lang/Object;)Z
    //   148: ifne -> 591
    //   151: aload_3
    //   152: invokevirtual e : ()Ljava/lang/String;
    //   155: ldc_w 'file'
    //   158: invokevirtual equals : (Ljava/lang/Object;)Z
    //   161: ifne -> 591
    //   164: aload_3
    //   165: invokevirtual e : ()Ljava/lang/String;
    //   168: ldc_w 'wifioff'
    //   171: invokevirtual equals : (Ljava/lang/Object;)Z
    //   174: ifeq -> 178
    //   177: return
    //   178: ldc_w '-3'
    //   181: aload_3
    //   182: invokevirtual d : ()Ljava/lang/String;
    //   185: invokevirtual equals : (Ljava/lang/Object;)Z
    //   188: ifeq -> 192
    //   191: return
    //   192: aload_0
    //   193: invokespecial b : ()Z
    //   196: ifeq -> 203
    //   199: aload_0
    //   200: invokespecial c : ()V
    //   203: aload_3
    //   204: invokevirtual f : ()Lorg/json/JSONObject;
    //   207: astore_1
    //   208: aload_1
    //   209: ldc_w 'offpct'
    //   212: invokestatic a : (Lorg/json/JSONObject;Ljava/lang/String;)Z
    //   215: ifeq -> 231
    //   218: aload_1
    //   219: ldc_w 'offpct'
    //   222: invokevirtual remove : (Ljava/lang/String;)Ljava/lang/Object;
    //   225: pop
    //   226: aload_3
    //   227: aload_1
    //   228: invokevirtual a : (Lorg/json/JSONObject;)V
    //   231: aload #11
    //   233: ldc 'wifi'
    //   235: invokevirtual contains : (Ljava/lang/CharSequence;)Z
    //   238: istore #10
    //   240: iload #10
    //   242: ifeq -> 390
    //   245: aload_2
    //   246: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   249: ifeq -> 253
    //   252: return
    //   253: aload_3
    //   254: invokevirtual getAccuracy : ()F
    //   257: ldc_w 300.0
    //   260: fcmpl
    //   261: iflt -> 314
    //   264: aload_2
    //   265: invokevirtual toString : ()Ljava/lang/String;
    //   268: ldc '#'
    //   270: invokevirtual split : (Ljava/lang/String;)[Ljava/lang/String;
    //   273: astore_1
    //   274: aload_1
    //   275: arraylength
    //   276: istore #9
    //   278: iconst_0
    //   279: istore #7
    //   281: iload #6
    //   283: iload #9
    //   285: if_icmpge -> 625
    //   288: iload #7
    //   290: istore #8
    //   292: aload_1
    //   293: iload #6
    //   295: aaload
    //   296: ldc_w ','
    //   299: invokevirtual contains : (Ljava/lang/CharSequence;)Z
    //   302: ifeq -> 612
    //   305: iload #7
    //   307: iconst_1
    //   308: iadd
    //   309: istore #8
    //   311: goto -> 612
    //   314: aload_3
    //   315: invokevirtual getAccuracy : ()F
    //   318: ldc_w 3.0
    //   321: fcmpg
    //   322: ifgt -> 326
    //   325: return
    //   326: aload #11
    //   328: ldc 'cgiwifi'
    //   330: invokevirtual contains : (Ljava/lang/CharSequence;)Z
    //   333: ifeq -> 430
    //   336: aload_3
    //   337: invokevirtual g : ()Ljava/lang/String;
    //   340: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   343: ifne -> 430
    //   346: aload #11
    //   348: ldc 'cgiwifi'
    //   350: ldc 'cgi'
    //   352: invokevirtual replace : (Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   355: astore_1
    //   356: aload_3
    //   357: invokevirtual h : ()Lcom/loc/ds;
    //   360: astore #12
    //   362: aload #12
    //   364: invokestatic a : (Lcom/loc/ds;)Z
    //   367: ifeq -> 430
    //   370: aload_0
    //   371: aload_1
    //   372: new java/lang/StringBuilder
    //   375: dup
    //   376: invokespecial <init> : ()V
    //   379: aload #12
    //   381: aload #4
    //   383: iconst_1
    //   384: invokevirtual a : (Ljava/lang/String;Ljava/lang/StringBuilder;Lcom/loc/ds;Landroid/content/Context;Z)V
    //   387: goto -> 430
    //   390: aload #11
    //   392: ldc 'cgi'
    //   394: invokevirtual contains : (Ljava/lang/CharSequence;)Z
    //   397: ifeq -> 430
    //   400: aload_2
    //   401: ifnull -> 416
    //   404: aload_2
    //   405: ldc_w ','
    //   408: invokevirtual indexOf : (Ljava/lang/String;)I
    //   411: iconst_m1
    //   412: if_icmpeq -> 416
    //   415: return
    //   416: ldc_w '4'
    //   419: aload_3
    //   420: invokevirtual d : ()Ljava/lang/String;
    //   423: invokevirtual equals : (Ljava/lang/Object;)Z
    //   426: ifeq -> 430
    //   429: return
    //   430: aload_0
    //   431: aload #11
    //   433: aload_2
    //   434: invokespecial a : (Ljava/lang/String;Ljava/lang/StringBuilder;)Lcom/loc/ds;
    //   437: astore_1
    //   438: aload_1
    //   439: invokestatic a : (Lcom/loc/ds;)Z
    //   442: ifeq -> 461
    //   445: aload_1
    //   446: invokevirtual toStr : ()Ljava/lang/String;
    //   449: aload_3
    //   450: iconst_3
    //   451: invokevirtual toStr : (I)Ljava/lang/String;
    //   454: invokevirtual equals : (Ljava/lang/Object;)Z
    //   457: ifeq -> 461
    //   460: return
    //   461: aload_0
    //   462: invokestatic b : ()J
    //   465: putfield i : J
    //   468: new com/loc/dz$a
    //   471: dup
    //   472: invokespecial <init> : ()V
    //   475: astore #12
    //   477: aload #12
    //   479: aload_3
    //   480: invokevirtual a : (Lcom/loc/ds;)V
    //   483: aload_2
    //   484: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   487: ifeq -> 495
    //   490: aconst_null
    //   491: astore_1
    //   492: goto -> 500
    //   495: aload_2
    //   496: invokevirtual toString : ()Ljava/lang/String;
    //   499: astore_1
    //   500: aload #12
    //   502: aload_1
    //   503: invokevirtual a : (Ljava/lang/String;)V
    //   506: aload_0
    //   507: getfield a : Ljava/util/Hashtable;
    //   510: aload #11
    //   512: invokevirtual containsKey : (Ljava/lang/Object;)Z
    //   515: ifeq -> 539
    //   518: aload_0
    //   519: getfield a : Ljava/util/Hashtable;
    //   522: aload #11
    //   524: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   527: checkcast java/util/ArrayList
    //   530: aload #12
    //   532: invokevirtual add : (Ljava/lang/Object;)Z
    //   535: pop
    //   536: goto -> 565
    //   539: new java/util/ArrayList
    //   542: dup
    //   543: invokespecial <init> : ()V
    //   546: astore_1
    //   547: aload_1
    //   548: aload #12
    //   550: invokevirtual add : (Ljava/lang/Object;)Z
    //   553: pop
    //   554: aload_0
    //   555: getfield a : Ljava/util/Hashtable;
    //   558: aload #11
    //   560: aload_1
    //   561: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   564: pop
    //   565: iload #5
    //   567: ifeq -> 591
    //   570: aload_0
    //   571: aload #11
    //   573: aload_3
    //   574: aload_2
    //   575: aload #4
    //   577: invokespecial a : (Ljava/lang/String;Lcom/amap/api/location/AMapLocation;Ljava/lang/StringBuilder;Landroid/content/Context;)V
    //   580: return
    //   581: astore_1
    //   582: aload_1
    //   583: ldc 'Cache'
    //   585: ldc_w 'add'
    //   588: invokestatic a : (Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   591: return
    //   592: astore_1
    //   593: aload_1
    //   594: ldc 'Cache'
    //   596: ldc_w 'add'
    //   599: invokestatic a : (Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   602: return
    //   603: iconst_0
    //   604: istore #10
    //   606: iload #10
    //   608: ifne -> 139
    //   611: return
    //   612: iload #6
    //   614: iconst_1
    //   615: iadd
    //   616: istore #6
    //   618: iload #8
    //   620: istore #7
    //   622: goto -> 281
    //   625: iload #7
    //   627: bipush #8
    //   629: if_icmplt -> 326
    //   632: return
    // Exception table:
    //   from	to	target	type
    //   0	7	592	finally
    //   8	95	592	finally
    //   103	110	592	finally
    //   113	123	592	finally
    //   126	136	592	finally
    //   139	177	592	finally
    //   178	191	592	finally
    //   192	203	592	finally
    //   203	231	592	finally
    //   231	240	592	finally
    //   245	252	592	finally
    //   253	278	592	finally
    //   292	305	592	finally
    //   314	325	592	finally
    //   326	387	592	finally
    //   390	400	592	finally
    //   404	415	592	finally
    //   416	429	592	finally
    //   430	460	592	finally
    //   461	490	592	finally
    //   495	500	592	finally
    //   500	536	592	finally
    //   539	565	592	finally
    //   570	580	581	finally
    //   582	591	592	finally
  }
  
  public final void b(Context paramContext) {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial c : ()V
    //   4: aload_1
    //   5: ifnull -> 212
    //   8: aload_1
    //   9: ldc_w 'hmdb'
    //   12: iconst_0
    //   13: aconst_null
    //   14: invokevirtual openOrCreateDatabase : (Ljava/lang/String;ILandroid/database/sqlite/SQLiteDatabase$CursorFactory;)Landroid/database/sqlite/SQLiteDatabase;
    //   17: astore_1
    //   18: aload_1
    //   19: ldc_w 'hist'
    //   22: invokestatic a : (Landroid/database/sqlite/SQLiteDatabase;Ljava/lang/String;)Z
    //   25: ifne -> 46
    //   28: aload_1
    //   29: ifnull -> 212
    //   32: aload_1
    //   33: invokevirtual isOpen : ()Z
    //   36: ifeq -> 212
    //   39: aload_1
    //   40: invokevirtual close : ()V
    //   43: goto -> 212
    //   46: invokestatic a : ()J
    //   49: lstore_2
    //   50: new java/lang/StringBuilder
    //   53: dup
    //   54: ldc_w 'hist'
    //   57: invokespecial <init> : (Ljava/lang/String;)V
    //   60: astore #4
    //   62: aload #4
    //   64: aload_0
    //   65: getfield k : Ljava/lang/String;
    //   68: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   71: pop
    //   72: aload_1
    //   73: aload #4
    //   75: invokevirtual toString : ()Ljava/lang/String;
    //   78: ldc_w 'time<?'
    //   81: iconst_1
    //   82: anewarray java/lang/String
    //   85: dup
    //   86: iconst_0
    //   87: lload_2
    //   88: ldc2_w 86400000
    //   91: lsub
    //   92: invokestatic valueOf : (J)Ljava/lang/String;
    //   95: aastore
    //   96: invokevirtual delete : (Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    //   99: pop
    //   100: goto -> 140
    //   103: astore #4
    //   105: aload #4
    //   107: ldc_w 'DB'
    //   110: ldc_w 'clearHist'
    //   113: invokestatic a : (Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   116: aload #4
    //   118: invokevirtual getMessage : ()Ljava/lang/String;
    //   121: astore #4
    //   123: aload #4
    //   125: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   128: ifne -> 140
    //   131: aload #4
    //   133: ldc_w 'no such table'
    //   136: invokevirtual contains : (Ljava/lang/CharSequence;)Z
    //   139: pop
    //   140: aload_1
    //   141: ifnull -> 212
    //   144: aload_1
    //   145: invokevirtual isOpen : ()Z
    //   148: ifeq -> 212
    //   151: aload_1
    //   152: invokevirtual close : ()V
    //   155: goto -> 212
    //   158: astore #4
    //   160: goto -> 167
    //   163: astore #4
    //   165: aconst_null
    //   166: astore_1
    //   167: aload #4
    //   169: ldc_w 'DB'
    //   172: ldc_w 'clearHist p2'
    //   175: invokestatic a : (Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   178: aload_1
    //   179: ifnull -> 212
    //   182: aload_1
    //   183: invokevirtual isOpen : ()Z
    //   186: ifeq -> 212
    //   189: goto -> 151
    //   192: astore #4
    //   194: aload_1
    //   195: ifnull -> 209
    //   198: aload_1
    //   199: invokevirtual isOpen : ()Z
    //   202: ifeq -> 209
    //   205: aload_1
    //   206: invokevirtual close : ()V
    //   209: aload #4
    //   211: athrow
    //   212: aload_0
    //   213: iconst_0
    //   214: putfield j : Z
    //   217: aload_0
    //   218: aconst_null
    //   219: putfield d : Ljava/lang/String;
    //   222: aload_0
    //   223: lconst_0
    //   224: putfield n : J
    //   227: return
    //   228: astore_1
    //   229: aload_1
    //   230: ldc 'Cache'
    //   232: ldc_w 'destroy part'
    //   235: invokestatic a : (Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   238: return
    // Exception table:
    //   from	to	target	type
    //   0	4	228	finally
    //   8	18	163	finally
    //   18	28	158	finally
    //   32	43	158	finally
    //   46	50	158	finally
    //   50	100	103	finally
    //   105	140	158	finally
    //   144	151	228	finally
    //   151	155	228	finally
    //   167	178	192	finally
    //   182	189	228	finally
    //   198	209	228	finally
    //   209	212	228	finally
    //   212	227	228	finally
  }
  
  static final class a {
    private ds a = null;
    
    private String b = null;
    
    public final ds a() {
      return this.a;
    }
    
    public final void a(ds param1ds) {
      this.a = param1ds;
    }
    
    public final void a(String param1String) {
      if (TextUtils.isEmpty(param1String)) {
        param1String = null;
      } else {
        param1String = param1String.replace("##", "#");
      } 
      this.b = param1String;
    }
    
    public final String b() {
      return this.b;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\loc\dz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */