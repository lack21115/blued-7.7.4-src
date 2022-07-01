package com.ta.utdid2.b.a;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Environment;
import com.ta.utdid2.a.a.g;
import java.io.File;
import java.util.Map;

public class c {
  private SharedPreferences.Editor a;
  
  private SharedPreferences a;
  
  private b.a a;
  
  private b a;
  
  private d a;
  
  private String b;
  
  private String c;
  
  private boolean f;
  
  private boolean g;
  
  private boolean h;
  
  private boolean i;
  
  private Context mContext;
  
  public c(Context paramContext, String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2) {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial <init> : ()V
    //   4: aload_0
    //   5: ldc ''
    //   7: putfield b : Ljava/lang/String;
    //   10: aload_0
    //   11: ldc ''
    //   13: putfield c : Ljava/lang/String;
    //   16: aload_0
    //   17: iconst_0
    //   18: putfield f : Z
    //   21: aload_0
    //   22: iconst_0
    //   23: putfield g : Z
    //   26: aload_0
    //   27: iconst_0
    //   28: putfield h : Z
    //   31: aconst_null
    //   32: astore #16
    //   34: aload_0
    //   35: aconst_null
    //   36: putfield a : Landroid/content/SharedPreferences;
    //   39: aload_0
    //   40: aconst_null
    //   41: putfield a : Lcom/ta/utdid2/b/a/b;
    //   44: aload_0
    //   45: aconst_null
    //   46: putfield a : Landroid/content/SharedPreferences$Editor;
    //   49: aload_0
    //   50: aconst_null
    //   51: putfield a : Lcom/ta/utdid2/b/a/b$a;
    //   54: aload_0
    //   55: aconst_null
    //   56: putfield mContext : Landroid/content/Context;
    //   59: aload_0
    //   60: aconst_null
    //   61: putfield a : Lcom/ta/utdid2/b/a/d;
    //   64: aload_0
    //   65: iconst_0
    //   66: putfield i : Z
    //   69: aload_0
    //   70: iload #4
    //   72: putfield f : Z
    //   75: aload_0
    //   76: iload #5
    //   78: putfield i : Z
    //   81: aload_0
    //   82: aload_3
    //   83: putfield b : Ljava/lang/String;
    //   86: aload_0
    //   87: aload_2
    //   88: putfield c : Ljava/lang/String;
    //   91: aload_0
    //   92: aload_1
    //   93: putfield mContext : Landroid/content/Context;
    //   96: aload_1
    //   97: ifnull -> 127
    //   100: aload_0
    //   101: aload_1
    //   102: aload_3
    //   103: iconst_0
    //   104: invokevirtual getSharedPreferences : (Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   107: putfield a : Landroid/content/SharedPreferences;
    //   110: aload_0
    //   111: getfield a : Landroid/content/SharedPreferences;
    //   114: ldc 't'
    //   116: lconst_0
    //   117: invokeinterface getLong : (Ljava/lang/String;J)J
    //   122: lstore #8
    //   124: goto -> 130
    //   127: lconst_0
    //   128: lstore #8
    //   130: invokestatic getExternalStorageState : ()Ljava/lang/String;
    //   133: astore #17
    //   135: aload #17
    //   137: astore #16
    //   139: goto -> 149
    //   142: astore #17
    //   144: aload #17
    //   146: invokevirtual printStackTrace : ()V
    //   149: aload #16
    //   151: invokestatic a : (Ljava/lang/String;)Z
    //   154: ifeq -> 170
    //   157: aload_0
    //   158: iconst_0
    //   159: putfield h : Z
    //   162: aload_0
    //   163: iconst_0
    //   164: putfield g : Z
    //   167: goto -> 226
    //   170: aload #16
    //   172: ldc 'mounted'
    //   174: invokevirtual equals : (Ljava/lang/Object;)Z
    //   177: ifeq -> 193
    //   180: aload_0
    //   181: iconst_1
    //   182: putfield h : Z
    //   185: aload_0
    //   186: iconst_1
    //   187: putfield g : Z
    //   190: goto -> 226
    //   193: aload #16
    //   195: ldc 'mounted_ro'
    //   197: invokevirtual equals : (Ljava/lang/Object;)Z
    //   200: ifeq -> 216
    //   203: aload_0
    //   204: iconst_1
    //   205: putfield g : Z
    //   208: aload_0
    //   209: iconst_0
    //   210: putfield h : Z
    //   213: goto -> 226
    //   216: aload_0
    //   217: iconst_0
    //   218: putfield h : Z
    //   221: aload_0
    //   222: iconst_0
    //   223: putfield g : Z
    //   226: aload_0
    //   227: getfield g : Z
    //   230: ifne -> 240
    //   233: aload_0
    //   234: getfield h : Z
    //   237: ifeq -> 672
    //   240: aload_1
    //   241: ifnull -> 672
    //   244: aload_2
    //   245: invokestatic a : (Ljava/lang/String;)Z
    //   248: ifne -> 672
    //   251: aload_0
    //   252: aload_0
    //   253: aload_2
    //   254: invokespecial a : (Ljava/lang/String;)Lcom/ta/utdid2/b/a/d;
    //   257: putfield a : Lcom/ta/utdid2/b/a/d;
    //   260: aload_0
    //   261: getfield a : Lcom/ta/utdid2/b/a/d;
    //   264: astore_2
    //   265: aload_2
    //   266: ifnull -> 672
    //   269: aload_0
    //   270: aload_2
    //   271: aload_3
    //   272: iconst_0
    //   273: invokevirtual a : (Ljava/lang/String;I)Lcom/ta/utdid2/b/a/b;
    //   276: putfield a : Lcom/ta/utdid2/b/a/b;
    //   279: aload_0
    //   280: getfield a : Lcom/ta/utdid2/b/a/b;
    //   283: ldc 't'
    //   285: lconst_0
    //   286: invokeinterface getLong : (Ljava/lang/String;J)J
    //   291: lstore #12
    //   293: iload #5
    //   295: ifne -> 433
    //   298: lload #8
    //   300: lload #12
    //   302: lcmp
    //   303: istore #6
    //   305: iload #6
    //   307: ifle -> 346
    //   310: aload_0
    //   311: aload_0
    //   312: getfield a : Landroid/content/SharedPreferences;
    //   315: aload_0
    //   316: getfield a : Lcom/ta/utdid2/b/a/b;
    //   319: invokespecial a : (Landroid/content/SharedPreferences;Lcom/ta/utdid2/b/a/b;)V
    //   322: aload_0
    //   323: aload_0
    //   324: getfield a : Lcom/ta/utdid2/b/a/d;
    //   327: aload_3
    //   328: iconst_0
    //   329: invokevirtual a : (Ljava/lang/String;I)Lcom/ta/utdid2/b/a/b;
    //   332: putfield a : Lcom/ta/utdid2/b/a/b;
    //   335: lload #8
    //   337: lstore #14
    //   339: lload #12
    //   341: lstore #10
    //   343: goto -> 679
    //   346: iload #6
    //   348: ifge -> 384
    //   351: aload_0
    //   352: aload_0
    //   353: getfield a : Lcom/ta/utdid2/b/a/b;
    //   356: aload_0
    //   357: getfield a : Landroid/content/SharedPreferences;
    //   360: invokespecial a : (Lcom/ta/utdid2/b/a/b;Landroid/content/SharedPreferences;)V
    //   363: aload_0
    //   364: aload_1
    //   365: aload_3
    //   366: iconst_0
    //   367: invokevirtual getSharedPreferences : (Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   370: putfield a : Landroid/content/SharedPreferences;
    //   373: lload #8
    //   375: lstore #14
    //   377: lload #12
    //   379: lstore #10
    //   381: goto -> 679
    //   384: lload #8
    //   386: lstore #14
    //   388: lload #12
    //   390: lstore #10
    //   392: iload #6
    //   394: ifne -> 679
    //   397: aload_0
    //   398: aload_0
    //   399: getfield a : Landroid/content/SharedPreferences;
    //   402: aload_0
    //   403: getfield a : Lcom/ta/utdid2/b/a/b;
    //   406: invokespecial a : (Landroid/content/SharedPreferences;Lcom/ta/utdid2/b/a/b;)V
    //   409: aload_0
    //   410: aload_0
    //   411: getfield a : Lcom/ta/utdid2/b/a/d;
    //   414: aload_3
    //   415: iconst_0
    //   416: invokevirtual a : (Ljava/lang/String;I)Lcom/ta/utdid2/b/a/b;
    //   419: putfield a : Lcom/ta/utdid2/b/a/b;
    //   422: lload #8
    //   424: lstore #14
    //   426: lload #12
    //   428: lstore #10
    //   430: goto -> 679
    //   433: aload_0
    //   434: getfield a : Landroid/content/SharedPreferences;
    //   437: ldc 't2'
    //   439: lconst_0
    //   440: invokeinterface getLong : (Ljava/lang/String;J)J
    //   445: lstore #14
    //   447: aload_0
    //   448: getfield a : Lcom/ta/utdid2/b/a/b;
    //   451: ldc 't2'
    //   453: lconst_0
    //   454: invokeinterface getLong : (Ljava/lang/String;J)J
    //   459: lstore #10
    //   461: lload #14
    //   463: lload #10
    //   465: lcmp
    //   466: istore #6
    //   468: iload #6
    //   470: ifge -> 508
    //   473: lload #14
    //   475: lconst_0
    //   476: lcmp
    //   477: ifle -> 508
    //   480: aload_0
    //   481: aload_0
    //   482: getfield a : Landroid/content/SharedPreferences;
    //   485: aload_0
    //   486: getfield a : Lcom/ta/utdid2/b/a/b;
    //   489: invokespecial a : (Landroid/content/SharedPreferences;Lcom/ta/utdid2/b/a/b;)V
    //   492: aload_0
    //   493: aload_0
    //   494: getfield a : Lcom/ta/utdid2/b/a/d;
    //   497: aload_3
    //   498: iconst_0
    //   499: invokevirtual a : (Ljava/lang/String;I)Lcom/ta/utdid2/b/a/b;
    //   502: putfield a : Lcom/ta/utdid2/b/a/b;
    //   505: goto -> 658
    //   508: iload #6
    //   510: ifle -> 545
    //   513: lload #10
    //   515: lconst_0
    //   516: lcmp
    //   517: ifle -> 545
    //   520: aload_0
    //   521: aload_0
    //   522: getfield a : Lcom/ta/utdid2/b/a/b;
    //   525: aload_0
    //   526: getfield a : Landroid/content/SharedPreferences;
    //   529: invokespecial a : (Lcom/ta/utdid2/b/a/b;Landroid/content/SharedPreferences;)V
    //   532: aload_0
    //   533: aload_1
    //   534: aload_3
    //   535: iconst_0
    //   536: invokevirtual getSharedPreferences : (Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   539: putfield a : Landroid/content/SharedPreferences;
    //   542: goto -> 658
    //   545: lload #14
    //   547: lconst_0
    //   548: lcmp
    //   549: istore #7
    //   551: iload #7
    //   553: ifne -> 588
    //   556: lload #10
    //   558: lconst_0
    //   559: lcmp
    //   560: ifle -> 588
    //   563: aload_0
    //   564: aload_0
    //   565: getfield a : Lcom/ta/utdid2/b/a/b;
    //   568: aload_0
    //   569: getfield a : Landroid/content/SharedPreferences;
    //   572: invokespecial a : (Lcom/ta/utdid2/b/a/b;Landroid/content/SharedPreferences;)V
    //   575: aload_0
    //   576: aload_1
    //   577: aload_3
    //   578: iconst_0
    //   579: invokevirtual getSharedPreferences : (Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   582: putfield a : Landroid/content/SharedPreferences;
    //   585: goto -> 658
    //   588: lload #10
    //   590: lconst_0
    //   591: lcmp
    //   592: ifne -> 628
    //   595: iload #7
    //   597: ifle -> 628
    //   600: aload_0
    //   601: aload_0
    //   602: getfield a : Landroid/content/SharedPreferences;
    //   605: aload_0
    //   606: getfield a : Lcom/ta/utdid2/b/a/b;
    //   609: invokespecial a : (Landroid/content/SharedPreferences;Lcom/ta/utdid2/b/a/b;)V
    //   612: aload_0
    //   613: aload_0
    //   614: getfield a : Lcom/ta/utdid2/b/a/d;
    //   617: aload_3
    //   618: iconst_0
    //   619: invokevirtual a : (Ljava/lang/String;I)Lcom/ta/utdid2/b/a/b;
    //   622: putfield a : Lcom/ta/utdid2/b/a/b;
    //   625: goto -> 658
    //   628: iload #6
    //   630: ifne -> 658
    //   633: aload_0
    //   634: aload_0
    //   635: getfield a : Landroid/content/SharedPreferences;
    //   638: aload_0
    //   639: getfield a : Lcom/ta/utdid2/b/a/b;
    //   642: invokespecial a : (Landroid/content/SharedPreferences;Lcom/ta/utdid2/b/a/b;)V
    //   645: aload_0
    //   646: aload_0
    //   647: getfield a : Lcom/ta/utdid2/b/a/d;
    //   650: aload_3
    //   651: iconst_0
    //   652: invokevirtual a : (Ljava/lang/String;I)Lcom/ta/utdid2/b/a/b;
    //   655: putfield a : Lcom/ta/utdid2/b/a/b;
    //   658: goto -> 679
    //   661: lload #8
    //   663: lstore #14
    //   665: lload #12
    //   667: lstore #10
    //   669: goto -> 679
    //   672: lconst_0
    //   673: lstore #10
    //   675: lload #8
    //   677: lstore #14
    //   679: lload #14
    //   681: lload #10
    //   683: lcmp
    //   684: ifne -> 701
    //   687: lload #14
    //   689: lconst_0
    //   690: lcmp
    //   691: ifne -> 805
    //   694: lload #10
    //   696: lconst_0
    //   697: lcmp
    //   698: ifne -> 805
    //   701: invokestatic currentTimeMillis : ()J
    //   704: lstore #8
    //   706: aload_0
    //   707: getfield i : Z
    //   710: istore #4
    //   712: iload #4
    //   714: ifeq -> 736
    //   717: iload #4
    //   719: ifeq -> 805
    //   722: lload #14
    //   724: lconst_0
    //   725: lcmp
    //   726: ifne -> 805
    //   729: lload #10
    //   731: lconst_0
    //   732: lcmp
    //   733: ifne -> 805
    //   736: aload_0
    //   737: getfield a : Landroid/content/SharedPreferences;
    //   740: astore_1
    //   741: aload_1
    //   742: ifnull -> 770
    //   745: aload_1
    //   746: invokeinterface edit : ()Landroid/content/SharedPreferences$Editor;
    //   751: astore_1
    //   752: aload_1
    //   753: ldc 't2'
    //   755: lload #8
    //   757: invokeinterface putLong : (Ljava/lang/String;J)Landroid/content/SharedPreferences$Editor;
    //   762: pop
    //   763: aload_1
    //   764: invokeinterface commit : ()Z
    //   769: pop
    //   770: aload_0
    //   771: getfield a : Lcom/ta/utdid2/b/a/b;
    //   774: ifnull -> 805
    //   777: aload_0
    //   778: getfield a : Lcom/ta/utdid2/b/a/b;
    //   781: invokeinterface a : ()Lcom/ta/utdid2/b/a/b$a;
    //   786: astore_1
    //   787: aload_1
    //   788: ldc 't2'
    //   790: lload #8
    //   792: invokeinterface a : (Ljava/lang/String;J)Lcom/ta/utdid2/b/a/b$a;
    //   797: pop
    //   798: aload_1
    //   799: invokeinterface commit : ()Z
    //   804: pop
    //   805: return
    //   806: astore_1
    //   807: goto -> 672
    //   810: astore_1
    //   811: goto -> 661
    //   814: astore_1
    //   815: lload #12
    //   817: lstore #10
    //   819: goto -> 658
    //   822: astore_1
    //   823: goto -> 658
    //   826: astore_1
    //   827: return
    // Exception table:
    //   from	to	target	type
    //   130	135	142	java/lang/Exception
    //   269	293	806	java/lang/Exception
    //   310	335	810	java/lang/Exception
    //   351	373	810	java/lang/Exception
    //   397	422	810	java/lang/Exception
    //   433	447	810	java/lang/Exception
    //   447	461	814	java/lang/Exception
    //   480	505	822	java/lang/Exception
    //   520	542	822	java/lang/Exception
    //   563	585	822	java/lang/Exception
    //   600	625	822	java/lang/Exception
    //   633	658	822	java/lang/Exception
    //   770	805	826	java/lang/Exception
  }
  
  private d a(String paramString) {
    File file = a(paramString);
    if (file != null) {
      this.a = new d(file.getAbsolutePath());
      return this.a;
    } 
    return null;
  }
  
  private File a(String paramString) {
    File file = Environment.getExternalStorageDirectory();
    if (file != null) {
      File file1 = new File(String.format("%s%s%s", new Object[] { file.getAbsolutePath(), File.separator, paramString }));
      if (!file1.exists())
        file1.mkdirs(); 
      return file1;
    } 
    return null;
  }
  
  private void a(SharedPreferences paramSharedPreferences, b paramb) {
    if (paramSharedPreferences != null && paramb != null) {
      b.a a1 = paramb.a();
      if (a1 != null) {
        a1.b();
        for (Map.Entry entry : paramSharedPreferences.getAll().entrySet()) {
          String str = (String)entry.getKey();
          entry = (Map.Entry)entry.getValue();
          if (entry instanceof String) {
            a1.a(str, (String)entry);
            continue;
          } 
          if (entry instanceof Integer) {
            a1.a(str, ((Integer)entry).intValue());
            continue;
          } 
          if (entry instanceof Long) {
            a1.a(str, ((Long)entry).longValue());
            continue;
          } 
          if (entry instanceof Float) {
            a1.a(str, ((Float)entry).floatValue());
            continue;
          } 
          if (entry instanceof Boolean)
            a1.a(str, ((Boolean)entry).booleanValue()); 
        } 
        try {
          a1.commit();
          return;
        } catch (Exception exception) {
          return;
        } 
      } 
    } 
  }
  
  private void a(b paramb, SharedPreferences paramSharedPreferences) {
    if (paramb != null && paramSharedPreferences != null) {
      SharedPreferences.Editor editor = paramSharedPreferences.edit();
      if (editor != null) {
        editor.clear();
        for (Map.Entry<String, ?> entry : paramb.getAll().entrySet()) {
          String str = (String)entry.getKey();
          entry = (Map.Entry<String, ?>)entry.getValue();
          if (entry instanceof String) {
            editor.putString(str, (String)entry);
            continue;
          } 
          if (entry instanceof Integer) {
            editor.putInt(str, ((Integer)entry).intValue());
            continue;
          } 
          if (entry instanceof Long) {
            editor.putLong(str, ((Long)entry).longValue());
            continue;
          } 
          if (entry instanceof Float) {
            editor.putFloat(str, ((Float)entry).floatValue());
            continue;
          } 
          if (entry instanceof Boolean)
            editor.putBoolean(str, ((Boolean)entry).booleanValue()); 
        } 
        editor.commit();
      } 
    } 
  }
  
  private void b() {
    if (this.a == null) {
      d d1 = this.a;
      if (d1 != null)
        this.a = (d)d1.edit(); 
    } 
    if (this.h && this.a == null) {
      d d1 = this.a;
      if (d1 != null)
        this.a = (d)d1.a(); 
    } 
    c();
  }
  
  private boolean c() {
    d d1 = this.a;
    if (d1 != null) {
      boolean bool = d1.b();
      if (!bool)
        commit(); 
      return bool;
    } 
    return false;
  }
  
  public boolean commit() {
    // Byte code:
    //   0: invokestatic currentTimeMillis : ()J
    //   3: lstore_1
    //   4: aload_0
    //   5: getfield a : Landroid/content/SharedPreferences$Editor;
    //   8: astore #6
    //   10: aload #6
    //   12: ifnull -> 57
    //   15: aload_0
    //   16: getfield i : Z
    //   19: ifne -> 40
    //   22: aload_0
    //   23: getfield a : Landroid/content/SharedPreferences;
    //   26: ifnull -> 40
    //   29: aload #6
    //   31: ldc 't'
    //   33: lload_1
    //   34: invokeinterface putLong : (Ljava/lang/String;J)Landroid/content/SharedPreferences$Editor;
    //   39: pop
    //   40: aload_0
    //   41: getfield a : Landroid/content/SharedPreferences$Editor;
    //   44: invokeinterface commit : ()Z
    //   49: ifne -> 57
    //   52: iconst_0
    //   53: istore_3
    //   54: goto -> 59
    //   57: iconst_1
    //   58: istore_3
    //   59: aload_0
    //   60: getfield a : Landroid/content/SharedPreferences;
    //   63: ifnull -> 91
    //   66: aload_0
    //   67: getfield mContext : Landroid/content/Context;
    //   70: astore #6
    //   72: aload #6
    //   74: ifnull -> 91
    //   77: aload_0
    //   78: aload #6
    //   80: aload_0
    //   81: getfield b : Ljava/lang/String;
    //   84: iconst_0
    //   85: invokevirtual getSharedPreferences : (Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   88: putfield a : Landroid/content/SharedPreferences;
    //   91: aconst_null
    //   92: astore #6
    //   94: invokestatic getExternalStorageState : ()Ljava/lang/String;
    //   97: astore #7
    //   99: aload #7
    //   101: astore #6
    //   103: goto -> 113
    //   106: astore #7
    //   108: aload #7
    //   110: invokevirtual printStackTrace : ()V
    //   113: iload_3
    //   114: istore #5
    //   116: aload #6
    //   118: invokestatic a : (Ljava/lang/String;)Z
    //   121: ifne -> 327
    //   124: iload_3
    //   125: istore #4
    //   127: aload #6
    //   129: ldc 'mounted'
    //   131: invokevirtual equals : (Ljava/lang/Object;)Z
    //   134: ifeq -> 261
    //   137: aload_0
    //   138: getfield a : Lcom/ta/utdid2/b/a/b;
    //   141: ifnonnull -> 229
    //   144: aload_0
    //   145: aload_0
    //   146: getfield c : Ljava/lang/String;
    //   149: invokespecial a : (Ljava/lang/String;)Lcom/ta/utdid2/b/a/d;
    //   152: astore #7
    //   154: iload_3
    //   155: istore #4
    //   157: aload #7
    //   159: ifnull -> 261
    //   162: aload_0
    //   163: aload #7
    //   165: aload_0
    //   166: getfield b : Ljava/lang/String;
    //   169: iconst_0
    //   170: invokevirtual a : (Ljava/lang/String;I)Lcom/ta/utdid2/b/a/b;
    //   173: putfield a : Lcom/ta/utdid2/b/a/b;
    //   176: aload_0
    //   177: getfield i : Z
    //   180: ifne -> 198
    //   183: aload_0
    //   184: aload_0
    //   185: getfield a : Landroid/content/SharedPreferences;
    //   188: aload_0
    //   189: getfield a : Lcom/ta/utdid2/b/a/b;
    //   192: invokespecial a : (Landroid/content/SharedPreferences;Lcom/ta/utdid2/b/a/b;)V
    //   195: goto -> 210
    //   198: aload_0
    //   199: aload_0
    //   200: getfield a : Lcom/ta/utdid2/b/a/b;
    //   203: aload_0
    //   204: getfield a : Landroid/content/SharedPreferences;
    //   207: invokespecial a : (Lcom/ta/utdid2/b/a/b;Landroid/content/SharedPreferences;)V
    //   210: aload_0
    //   211: aload_0
    //   212: getfield a : Lcom/ta/utdid2/b/a/b;
    //   215: invokeinterface a : ()Lcom/ta/utdid2/b/a/b$a;
    //   220: putfield a : Lcom/ta/utdid2/b/a/b$a;
    //   223: iload_3
    //   224: istore #4
    //   226: goto -> 261
    //   229: iload_3
    //   230: istore #4
    //   232: aload_0
    //   233: getfield a : Lcom/ta/utdid2/b/a/b$a;
    //   236: ifnull -> 261
    //   239: aload_0
    //   240: getfield a : Lcom/ta/utdid2/b/a/b$a;
    //   243: invokeinterface commit : ()Z
    //   248: istore #5
    //   250: iload_3
    //   251: istore #4
    //   253: iload #5
    //   255: ifne -> 261
    //   258: iconst_0
    //   259: istore #4
    //   261: aload #6
    //   263: ldc 'mounted'
    //   265: invokevirtual equals : (Ljava/lang/Object;)Z
    //   268: ifne -> 296
    //   271: iload #4
    //   273: istore #5
    //   275: aload #6
    //   277: ldc 'mounted_ro'
    //   279: invokevirtual equals : (Ljava/lang/Object;)Z
    //   282: ifeq -> 327
    //   285: iload #4
    //   287: istore #5
    //   289: aload_0
    //   290: getfield a : Lcom/ta/utdid2/b/a/b;
    //   293: ifnull -> 327
    //   296: iload #4
    //   298: istore #5
    //   300: aload_0
    //   301: getfield a : Lcom/ta/utdid2/b/a/d;
    //   304: ifnull -> 327
    //   307: aload_0
    //   308: aload_0
    //   309: getfield a : Lcom/ta/utdid2/b/a/d;
    //   312: aload_0
    //   313: getfield b : Ljava/lang/String;
    //   316: iconst_0
    //   317: invokevirtual a : (Ljava/lang/String;I)Lcom/ta/utdid2/b/a/b;
    //   320: putfield a : Lcom/ta/utdid2/b/a/b;
    //   323: iload #4
    //   325: istore #5
    //   327: iload #5
    //   329: ireturn
    //   330: astore #7
    //   332: goto -> 258
    //   335: astore #6
    //   337: iload #4
    //   339: ireturn
    // Exception table:
    //   from	to	target	type
    //   94	99	106	java/lang/Exception
    //   232	250	330	java/lang/Exception
    //   300	323	335	java/lang/Exception
  }
  
  public String getString(String paramString) {
    c();
    d d1 = this.a;
    if (d1 != null) {
      String str = d1.getString(paramString, "");
      if (!g.a(str))
        return str; 
    } 
    d1 = this.a;
    return (d1 != null) ? d1.getString(paramString, "") : "";
  }
  
  public void putString(String paramString1, String paramString2) {
    if (!g.a(paramString1) && !paramString1.equals("t")) {
      b();
      d d1 = this.a;
      if (d1 != null)
        d1.putString(paramString1, paramString2); 
      d1 = this.a;
      if (d1 != null)
        d1.a(paramString1, paramString2); 
    } 
  }
  
  public void remove(String paramString) {
    if (!g.a(paramString) && !paramString.equals("t")) {
      b();
      d d1 = this.a;
      if (d1 != null)
        d1.remove(paramString); 
      d1 = this.a;
      if (d1 != null)
        d1.a(paramString); 
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\t\\utdid2\b\a\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */