package com.ss.android.socialbase.downloader.impls;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.SparseArray;
import com.ss.android.socialbase.downloader.b.f;
import com.ss.android.socialbase.downloader.b.g;
import com.ss.android.socialbase.downloader.b.h;
import com.ss.android.socialbase.downloader.d.ac;
import com.ss.android.socialbase.downloader.d.q;
import com.ss.android.socialbase.downloader.d.w;
import com.ss.android.socialbase.downloader.d.z;
import com.ss.android.socialbase.downloader.downloader.b;
import com.ss.android.socialbase.downloader.downloader.e;
import com.ss.android.socialbase.downloader.downloader.k;
import com.ss.android.socialbase.downloader.g.c;
import com.ss.android.socialbase.downloader.g.d;
import com.ss.android.socialbase.downloader.l.c;
import com.ss.android.socialbase.downloader.l.f;
import com.ss.android.socialbase.downloader.m.c;
import com.ss.android.socialbase.downloader.m.e;
import com.ss.android.socialbase.downloader.m.f;
import com.ss.android.socialbase.downloader.m.h;
import com.ss.android.socialbase.downloader.notification.b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingDeque;

public abstract class a implements f.a {
  protected final f a = new f(Looper.getMainLooper(), this);
  
  private final SparseArray<d> b = new SparseArray();
  
  private final SparseArray<d> c = new SparseArray();
  
  private final SparseArray<d> d = new SparseArray();
  
  private final SparseArray<d> e = new SparseArray();
  
  private final SparseArray<d> f = new SparseArray();
  
  private final h<Integer, d> g = new h();
  
  private final SparseArray<Long> h = new SparseArray();
  
  private final LinkedBlockingDeque<d> i = new LinkedBlockingDeque<d>();
  
  private final k j = b.p();
  
  private void a(int paramInt, com.ss.android.socialbase.downloader.e.a parama, d paramd) {
    if (paramd != null) {
      c c = paramd.a();
      SparseArray sparseArray1 = paramd.a(h.a);
      SparseArray sparseArray2 = paramd.a(h.c);
      boolean bool = paramd.m();
      e.a(paramInt, sparseArray1, true, c, parama);
      e.a(paramInt, sparseArray2, bool, c, parama);
    } 
  }
  
  private void a(c paramc) {
    if (paramc != null)
      try {
      
      } finally {
        paramc = null;
      }  
  }
  
  private void a(d paramd, boolean paramBoolean) {
    // Byte code:
    //   0: aload_1
    //   1: ifnonnull -> 5
    //   4: return
    //   5: aload_1
    //   6: invokevirtual a : ()Lcom/ss/android/socialbase/downloader/g/c;
    //   9: astore #13
    //   11: aload #13
    //   13: ifnonnull -> 17
    //   16: return
    //   17: aload #13
    //   19: invokevirtual aH : ()Z
    //   22: istore #8
    //   24: iconst_0
    //   25: istore_3
    //   26: iconst_0
    //   27: istore #5
    //   29: iconst_0
    //   30: istore #4
    //   32: iload #8
    //   34: ifeq -> 149
    //   37: aload_1
    //   38: invokevirtual e : ()Lcom/ss/android/socialbase/downloader/d/x;
    //   41: astore_1
    //   42: new java/lang/StringBuilder
    //   45: dup
    //   46: invokespecial <init> : ()V
    //   49: astore #14
    //   51: aload #14
    //   53: ldc 'downloadInfo is Invalid, url is '
    //   55: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   58: pop
    //   59: aload #14
    //   61: aload #13
    //   63: invokevirtual j : ()Ljava/lang/String;
    //   66: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   69: pop
    //   70: aload #14
    //   72: ldc ' name is '
    //   74: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   77: pop
    //   78: aload #14
    //   80: aload #13
    //   82: invokevirtual h : ()Ljava/lang/String;
    //   85: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   88: pop
    //   89: aload #14
    //   91: ldc ' savePath is '
    //   93: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   96: pop
    //   97: aload #14
    //   99: aload #13
    //   101: invokevirtual k : ()Ljava/lang/String;
    //   104: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   107: pop
    //   108: new com/ss/android/socialbase/downloader/e/a
    //   111: dup
    //   112: sipush #1003
    //   115: aload #14
    //   117: invokevirtual toString : ()Ljava/lang/String;
    //   120: invokespecial <init> : (ILjava/lang/String;)V
    //   123: astore #14
    //   125: iload #4
    //   127: istore_3
    //   128: aload #13
    //   130: ifnull -> 139
    //   133: aload #13
    //   135: invokevirtual q : ()I
    //   138: istore_3
    //   139: aload_1
    //   140: aload #13
    //   142: aload #14
    //   144: iload_3
    //   145: invokestatic a : (Lcom/ss/android/socialbase/downloader/d/x;Lcom/ss/android/socialbase/downloader/g/c;Lcom/ss/android/socialbase/downloader/e/a;I)V
    //   148: return
    //   149: aload #13
    //   151: invokevirtual g : ()I
    //   154: istore #7
    //   156: iload_2
    //   157: ifeq -> 166
    //   160: aload_0
    //   161: aload #13
    //   163: invokespecial a : (Lcom/ss/android/socialbase/downloader/g/c;)V
    //   166: aload_0
    //   167: getfield d : Landroid/util/SparseArray;
    //   170: astore #14
    //   172: aload #14
    //   174: monitorenter
    //   175: aload_0
    //   176: getfield d : Landroid/util/SparseArray;
    //   179: iload #7
    //   181: invokevirtual get : (I)Ljava/lang/Object;
    //   184: ifnull -> 196
    //   187: aload_0
    //   188: getfield d : Landroid/util/SparseArray;
    //   191: iload #7
    //   193: invokevirtual remove : (I)V
    //   196: aload #14
    //   198: monitorexit
    //   199: aload_0
    //   200: getfield c : Landroid/util/SparseArray;
    //   203: astore #14
    //   205: aload #14
    //   207: monitorenter
    //   208: aload_0
    //   209: getfield c : Landroid/util/SparseArray;
    //   212: iload #7
    //   214: invokevirtual get : (I)Ljava/lang/Object;
    //   217: ifnull -> 229
    //   220: aload_0
    //   221: getfield c : Landroid/util/SparseArray;
    //   224: iload #7
    //   226: invokevirtual remove : (I)V
    //   229: aload #14
    //   231: monitorexit
    //   232: aload_0
    //   233: getfield e : Landroid/util/SparseArray;
    //   236: astore #14
    //   238: aload #14
    //   240: monitorenter
    //   241: aload_0
    //   242: getfield e : Landroid/util/SparseArray;
    //   245: iload #7
    //   247: invokevirtual get : (I)Ljava/lang/Object;
    //   250: ifnull -> 262
    //   253: aload_0
    //   254: getfield e : Landroid/util/SparseArray;
    //   257: iload #7
    //   259: invokevirtual remove : (I)V
    //   262: aload #14
    //   264: monitorexit
    //   265: aload_0
    //   266: getfield f : Landroid/util/SparseArray;
    //   269: astore #14
    //   271: aload #14
    //   273: monitorenter
    //   274: aload_0
    //   275: getfield f : Landroid/util/SparseArray;
    //   278: iload #7
    //   280: invokevirtual get : (I)Ljava/lang/Object;
    //   283: ifnull -> 295
    //   286: aload_0
    //   287: getfield f : Landroid/util/SparseArray;
    //   290: iload #7
    //   292: invokevirtual remove : (I)V
    //   295: aload #14
    //   297: monitorexit
    //   298: sipush #512
    //   301: invokestatic a : (I)Z
    //   304: ifeq -> 375
    //   307: aload_0
    //   308: iload #7
    //   310: invokevirtual a : (I)Z
    //   313: ifeq -> 375
    //   316: aload_0
    //   317: getfield b : Landroid/util/SparseArray;
    //   320: astore #14
    //   322: aload #14
    //   324: monitorenter
    //   325: aload_0
    //   326: getfield b : Landroid/util/SparseArray;
    //   329: iload #7
    //   331: invokevirtual get : (I)Ljava/lang/Object;
    //   334: checkcast com/ss/android/socialbase/downloader/g/d
    //   337: astore #15
    //   339: aload #15
    //   341: ifnull -> 353
    //   344: aload #15
    //   346: aload_1
    //   347: invokevirtual a : (Lcom/ss/android/socialbase/downloader/g/d;)V
    //   350: goto -> 363
    //   353: aload_0
    //   354: getfield b : Landroid/util/SparseArray;
    //   357: iload #7
    //   359: aload_1
    //   360: invokevirtual put : (ILjava/lang/Object;)V
    //   363: aload #14
    //   365: monitorexit
    //   366: goto -> 375
    //   369: astore_1
    //   370: aload #14
    //   372: monitorexit
    //   373: aload_1
    //   374: athrow
    //   375: aload_0
    //   376: iload #7
    //   378: invokevirtual a : (I)Z
    //   381: ifeq -> 452
    //   384: aload #13
    //   386: invokevirtual av : ()Z
    //   389: ifne -> 452
    //   392: ldc 'AbsDownloadEngine'
    //   394: ldc 'another task with same id is downloading when tryDownload'
    //   396: invokestatic b : (Ljava/lang/String;Ljava/lang/String;)V
    //   399: aload #13
    //   401: invokevirtual X : ()Z
    //   404: ifeq -> 411
    //   407: aload_1
    //   408: invokevirtual p : ()V
    //   411: aload_1
    //   412: invokevirtual e : ()Lcom/ss/android/socialbase/downloader/d/x;
    //   415: astore_1
    //   416: new com/ss/android/socialbase/downloader/e/a
    //   419: dup
    //   420: sipush #1003
    //   423: ldc_w 'downloadInfo is isDownloading and addListenerToSameTask is false'
    //   426: invokespecial <init> : (ILjava/lang/String;)V
    //   429: astore #14
    //   431: aload #13
    //   433: ifnull -> 442
    //   436: aload #13
    //   438: invokevirtual q : ()I
    //   441: istore_3
    //   442: aload_1
    //   443: aload #13
    //   445: aload #14
    //   447: iload_3
    //   448: invokestatic a : (Lcom/ss/android/socialbase/downloader/d/x;Lcom/ss/android/socialbase/downloader/g/c;Lcom/ss/android/socialbase/downloader/e/a;I)V
    //   451: return
    //   452: aload #13
    //   454: invokevirtual av : ()Z
    //   457: ifeq -> 468
    //   460: aload #13
    //   462: getstatic com/ss/android/socialbase/downloader/b/a.c : Lcom/ss/android/socialbase/downloader/b/a;
    //   465: invokevirtual a : (Lcom/ss/android/socialbase/downloader/b/a;)V
    //   468: ldc_w 32768
    //   471: invokestatic a : (I)Z
    //   474: ifeq -> 526
    //   477: aload_0
    //   478: getfield g : Lcom/ss/android/socialbase/downloader/m/h;
    //   481: astore #14
    //   483: aload #14
    //   485: monitorenter
    //   486: aload_0
    //   487: getfield g : Lcom/ss/android/socialbase/downloader/m/h;
    //   490: iload #7
    //   492: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   495: invokevirtual remove : (Ljava/lang/Object;)Ljava/lang/Object;
    //   498: checkcast com/ss/android/socialbase/downloader/g/d
    //   501: astore #15
    //   503: aload #14
    //   505: monitorexit
    //   506: aload #15
    //   508: ifnull -> 526
    //   511: aload_1
    //   512: aload #15
    //   514: invokevirtual b : (Lcom/ss/android/socialbase/downloader/g/d;)V
    //   517: goto -> 526
    //   520: astore_1
    //   521: aload #14
    //   523: monitorexit
    //   524: aload_1
    //   525: athrow
    //   526: aload_0
    //   527: getfield b : Landroid/util/SparseArray;
    //   530: astore #14
    //   532: aload #14
    //   534: monitorenter
    //   535: aload_0
    //   536: getfield h : Landroid/util/SparseArray;
    //   539: iload #7
    //   541: invokevirtual get : (I)Ljava/lang/Object;
    //   544: checkcast java/lang/Long
    //   547: astore #15
    //   549: aload #15
    //   551: ifnull -> 900
    //   554: aload #15
    //   556: invokevirtual longValue : ()J
    //   559: lstore #9
    //   561: goto -> 564
    //   564: invokestatic uptimeMillis : ()J
    //   567: lstore #11
    //   569: lload #11
    //   571: lload #9
    //   573: lsub
    //   574: ldc2_w 50
    //   577: lcmp
    //   578: ifge -> 835
    //   581: aload_0
    //   582: getfield b : Landroid/util/SparseArray;
    //   585: iload #7
    //   587: invokevirtual get : (I)Ljava/lang/Object;
    //   590: checkcast com/ss/android/socialbase/downloader/g/d
    //   593: astore #15
    //   595: aload #15
    //   597: ifnull -> 906
    //   600: aload #15
    //   602: invokevirtual a : ()Lcom/ss/android/socialbase/downloader/g/c;
    //   605: astore #15
    //   607: aload #15
    //   609: ifnull -> 906
    //   612: aload #15
    //   614: invokevirtual q : ()I
    //   617: istore #4
    //   619: iload #4
    //   621: istore_3
    //   622: iload #4
    //   624: ifne -> 908
    //   627: iload #4
    //   629: istore_3
    //   630: iload #4
    //   632: invokestatic b : (I)Z
    //   635: ifeq -> 908
    //   638: iconst_1
    //   639: istore #6
    //   641: iload #4
    //   643: istore_3
    //   644: iload #6
    //   646: istore #4
    //   648: goto -> 651
    //   651: iload #4
    //   653: ifeq -> 801
    //   656: new java/lang/StringBuilder
    //   659: dup
    //   660: invokespecial <init> : ()V
    //   663: astore #15
    //   665: aload #15
    //   667: ldc_w 'can add listener, oldTaskStatus is :'
    //   670: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   673: pop
    //   674: aload #15
    //   676: iload_3
    //   677: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   680: pop
    //   681: ldc 'AbsDownloadEngine'
    //   683: aload #15
    //   685: invokevirtual toString : ()Ljava/lang/String;
    //   688: invokestatic b : (Ljava/lang/String;Ljava/lang/String;)V
    //   691: iload_3
    //   692: iflt -> 707
    //   695: iload_3
    //   696: iconst_2
    //   697: if_icmpge -> 707
    //   700: aload_1
    //   701: invokevirtual p : ()V
    //   704: goto -> 866
    //   707: aload #13
    //   709: invokevirtual X : ()Z
    //   712: ifeq -> 722
    //   715: aload_1
    //   716: invokevirtual p : ()V
    //   719: goto -> 866
    //   722: aload_1
    //   723: invokevirtual e : ()Lcom/ss/android/socialbase/downloader/d/x;
    //   726: astore #15
    //   728: new com/ss/android/socialbase/downloader/e/a
    //   731: dup
    //   732: sipush #1003
    //   735: ldc_w 'has another same task within 50 milliseconds and addListenerToSameTask is false'
    //   738: invokespecial <init> : (ILjava/lang/String;)V
    //   741: astore #16
    //   743: iload #5
    //   745: istore_3
    //   746: aload #13
    //   748: ifnull -> 757
    //   751: aload #13
    //   753: invokevirtual q : ()I
    //   756: istore_3
    //   757: aload #15
    //   759: aload #13
    //   761: aload #16
    //   763: iload_3
    //   764: invokestatic a : (Lcom/ss/android/socialbase/downloader/d/x;Lcom/ss/android/socialbase/downloader/g/c;Lcom/ss/android/socialbase/downloader/e/a;I)V
    //   767: aload_0
    //   768: getfield b : Landroid/util/SparseArray;
    //   771: iload #7
    //   773: aload_1
    //   774: invokevirtual put : (ILjava/lang/Object;)V
    //   777: aload_0
    //   778: getfield h : Landroid/util/SparseArray;
    //   781: iload #7
    //   783: lload #11
    //   785: invokestatic valueOf : (J)Ljava/lang/Long;
    //   788: invokevirtual put : (ILjava/lang/Object;)V
    //   791: aload_0
    //   792: iload #7
    //   794: aload_1
    //   795: invokevirtual a : (ILcom/ss/android/socialbase/downloader/g/d;)V
    //   798: goto -> 866
    //   801: aload_0
    //   802: getfield b : Landroid/util/SparseArray;
    //   805: iload #7
    //   807: aload_1
    //   808: invokevirtual put : (ILjava/lang/Object;)V
    //   811: aload_0
    //   812: getfield h : Landroid/util/SparseArray;
    //   815: iload #7
    //   817: lload #11
    //   819: invokestatic valueOf : (J)Ljava/lang/Long;
    //   822: invokevirtual put : (ILjava/lang/Object;)V
    //   825: aload_0
    //   826: iload #7
    //   828: aload_1
    //   829: invokevirtual a : (ILcom/ss/android/socialbase/downloader/g/d;)V
    //   832: goto -> 866
    //   835: aload_0
    //   836: getfield b : Landroid/util/SparseArray;
    //   839: iload #7
    //   841: aload_1
    //   842: invokevirtual put : (ILjava/lang/Object;)V
    //   845: aload_0
    //   846: getfield h : Landroid/util/SparseArray;
    //   849: iload #7
    //   851: lload #11
    //   853: invokestatic valueOf : (J)Ljava/lang/Long;
    //   856: invokevirtual put : (ILjava/lang/Object;)V
    //   859: aload_0
    //   860: iload #7
    //   862: aload_1
    //   863: invokevirtual a : (ILcom/ss/android/socialbase/downloader/g/d;)V
    //   866: aload #14
    //   868: monitorexit
    //   869: return
    //   870: astore_1
    //   871: aload #14
    //   873: monitorexit
    //   874: aload_1
    //   875: athrow
    //   876: astore_1
    //   877: aload #14
    //   879: monitorexit
    //   880: aload_1
    //   881: athrow
    //   882: astore_1
    //   883: aload #14
    //   885: monitorexit
    //   886: aload_1
    //   887: athrow
    //   888: astore_1
    //   889: aload #14
    //   891: monitorexit
    //   892: aload_1
    //   893: athrow
    //   894: astore_1
    //   895: aload #14
    //   897: monitorexit
    //   898: aload_1
    //   899: athrow
    //   900: lconst_0
    //   901: lstore #9
    //   903: goto -> 564
    //   906: iconst_0
    //   907: istore_3
    //   908: iconst_0
    //   909: istore #4
    //   911: goto -> 651
    // Exception table:
    //   from	to	target	type
    //   175	196	894	finally
    //   196	199	894	finally
    //   208	229	888	finally
    //   229	232	888	finally
    //   241	262	882	finally
    //   262	265	882	finally
    //   274	295	876	finally
    //   295	298	876	finally
    //   325	339	369	finally
    //   344	350	369	finally
    //   353	363	369	finally
    //   363	366	369	finally
    //   370	373	369	finally
    //   486	506	520	finally
    //   521	524	520	finally
    //   535	549	870	finally
    //   554	561	870	finally
    //   564	569	870	finally
    //   581	595	870	finally
    //   600	607	870	finally
    //   612	619	870	finally
    //   630	638	870	finally
    //   656	691	870	finally
    //   700	704	870	finally
    //   707	719	870	finally
    //   722	743	870	finally
    //   751	757	870	finally
    //   757	798	870	finally
    //   801	832	870	finally
    //   835	866	870	finally
    //   866	869	870	finally
    //   871	874	870	finally
    //   877	880	876	finally
    //   883	886	882	finally
    //   889	892	888	finally
    //   895	898	894	finally
  }
  
  private void b(d paramd) {
    if (paramd == null)
      return; 
    c c = paramd.a();
    if (c == null)
      return; 
    try {
      synchronized (this.i) {
        if (this.i.isEmpty()) {
          a(paramd, true);
          this.i.put(paramd);
        } else if (c.r() == g.c) {
          if (((d)this.i.getFirst()).o() == paramd.o() && a(paramd.o()))
            return; 
          Iterator<d> iterator = this.i.iterator();
          while (iterator.hasNext()) {
            d d1 = iterator.next();
            if (d1 != null && d1.o() == paramd.o()) {
              iterator.remove();
              break;
            } 
          } 
          this.i.put(paramd);
          (new e(paramd, (Handler)this.a)).a();
        } else {
          d d1 = this.i.getFirst();
          if (d1.o() == paramd.o() && a(paramd.o()))
            return; 
          e(d1.o());
          a(paramd, true);
          if (d1.o() != paramd.o())
            this.i.putFirst(paramd); 
        } 
        return;
      } 
    } catch (InterruptedException interruptedException) {
      return;
    } 
  }
  
  private void c(int paramInt, boolean paramBoolean) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield j : Lcom/ss/android/socialbase/downloader/downloader/k;
    //   6: iload_1
    //   7: invokeinterface b : (I)Lcom/ss/android/socialbase/downloader/g/c;
    //   12: astore_3
    //   13: aload_3
    //   14: ifnull -> 47
    //   17: iload_2
    //   18: ifeq -> 32
    //   21: aload_3
    //   22: invokevirtual k : ()Ljava/lang/String;
    //   25: aload_3
    //   26: invokevirtual h : ()Ljava/lang/String;
    //   29: invokestatic c : (Ljava/lang/String;Ljava/lang/String;)V
    //   32: aload_3
    //   33: invokevirtual l : ()Ljava/lang/String;
    //   36: aload_3
    //   37: invokevirtual m : ()Ljava/lang/String;
    //   40: invokestatic c : (Ljava/lang/String;Ljava/lang/String;)V
    //   43: aload_3
    //   44: invokevirtual aY : ()V
    //   47: aload_0
    //   48: getfield j : Lcom/ss/android/socialbase/downloader/downloader/k;
    //   51: iload_1
    //   52: invokeinterface f : (I)Z
    //   57: pop
    //   58: goto -> 66
    //   61: astore_3
    //   62: aload_3
    //   63: invokevirtual printStackTrace : ()V
    //   66: aload_0
    //   67: iload_1
    //   68: bipush #-4
    //   70: invokevirtual a : (II)V
    //   73: aload_0
    //   74: getfield d : Landroid/util/SparseArray;
    //   77: iload_1
    //   78: invokevirtual get : (I)Ljava/lang/Object;
    //   81: ifnull -> 92
    //   84: aload_0
    //   85: getfield d : Landroid/util/SparseArray;
    //   88: iload_1
    //   89: invokevirtual remove : (I)V
    //   92: aload_0
    //   93: getfield c : Landroid/util/SparseArray;
    //   96: iload_1
    //   97: invokevirtual get : (I)Ljava/lang/Object;
    //   100: ifnull -> 111
    //   103: aload_0
    //   104: getfield c : Landroid/util/SparseArray;
    //   107: iload_1
    //   108: invokevirtual remove : (I)V
    //   111: aload_0
    //   112: getfield g : Lcom/ss/android/socialbase/downloader/m/h;
    //   115: astore_3
    //   116: aload_3
    //   117: monitorenter
    //   118: aload_0
    //   119: getfield g : Lcom/ss/android/socialbase/downloader/m/h;
    //   122: iload_1
    //   123: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   126: invokevirtual remove : (Ljava/lang/Object;)Ljava/lang/Object;
    //   129: pop
    //   130: aload_3
    //   131: monitorexit
    //   132: iload_1
    //   133: invokestatic b : (I)V
    //   136: goto -> 151
    //   139: astore #4
    //   141: aload_3
    //   142: monitorexit
    //   143: aload #4
    //   145: athrow
    //   146: astore_3
    //   147: aload_3
    //   148: invokevirtual printStackTrace : ()V
    //   151: aload_0
    //   152: monitorexit
    //   153: return
    //   154: astore_3
    //   155: aload_0
    //   156: monitorexit
    //   157: aload_3
    //   158: athrow
    // Exception table:
    //   from	to	target	type
    //   2	13	146	finally
    //   21	32	146	finally
    //   32	47	146	finally
    //   47	58	61	android/database/sqlite/SQLiteException
    //   47	58	146	finally
    //   62	66	146	finally
    //   66	92	146	finally
    //   92	111	146	finally
    //   111	118	146	finally
    //   118	132	139	finally
    //   132	136	146	finally
    //   141	143	139	finally
    //   143	146	146	finally
    //   147	151	154	finally
  }
  
  private d o(int paramInt) {
    d d2 = (d)this.b.get(paramInt);
    d d1 = d2;
    if (d2 == null) {
      d2 = (d)this.d.get(paramInt);
      d1 = d2;
      if (d2 == null) {
        d2 = (d)this.c.get(paramInt);
        d1 = d2;
        if (d2 == null) {
          d2 = (d)this.e.get(paramInt);
          d1 = d2;
          if (d2 == null)
            d1 = (d)this.f.get(paramInt); 
        } 
      } 
    } 
    return d1;
  }
  
  private void p(int paramInt) {
    if (this.i.isEmpty())
      return; 
    synchronized (this.i) {
      d d = this.i.getFirst();
      if (d != null && d.o() == paramInt)
        this.i.poll(); 
      if (this.i.isEmpty())
        return; 
      d = this.i.getFirst();
      if (d != null)
        a(d, true); 
      return;
    } 
  }
  
  protected abstract List<Integer> a();
  
  public List<c> a(String paramString) {
    if (TextUtils.isEmpty(paramString))
      return null; 
    List<c> list = this.j.a(paramString);
    if (list == null || list.isEmpty())
      synchronized (this.b) {
        ArrayList<c> arrayList = new ArrayList();
        int j = this.b.size();
        for (int i = 0;; i++) {
          if (i < j) {
            d d = (d)this.b.valueAt(i);
            if (d != null && d.a() != null && paramString.equals(d.a().j()))
              arrayList.add(d.a()); 
          } else {
            return arrayList;
          } 
        } 
      }  
    return list;
  }
  
  public void a(int paramInt1, int paramInt2) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: iload_2
    //   3: bipush #-7
    //   5: if_icmpeq -> 227
    //   8: iload_2
    //   9: bipush #-6
    //   11: if_icmpeq -> 195
    //   14: iload_2
    //   15: bipush #-4
    //   17: if_icmpeq -> 179
    //   20: iload_2
    //   21: bipush #-3
    //   23: if_icmpeq -> 142
    //   26: iload_2
    //   27: iconst_m1
    //   28: if_icmpeq -> 227
    //   31: iload_2
    //   32: bipush #7
    //   34: if_icmpeq -> 90
    //   37: iload_2
    //   38: bipush #8
    //   40: if_icmpeq -> 46
    //   43: goto -> 276
    //   46: aload_0
    //   47: getfield b : Landroid/util/SparseArray;
    //   50: iload_1
    //   51: invokevirtual get : (I)Ljava/lang/Object;
    //   54: checkcast com/ss/android/socialbase/downloader/g/d
    //   57: astore_3
    //   58: aload_3
    //   59: ifnull -> 82
    //   62: aload_0
    //   63: getfield f : Landroid/util/SparseArray;
    //   66: iload_1
    //   67: invokevirtual get : (I)Ljava/lang/Object;
    //   70: ifnonnull -> 82
    //   73: aload_0
    //   74: getfield f : Landroid/util/SparseArray;
    //   77: iload_1
    //   78: aload_3
    //   79: invokevirtual put : (ILjava/lang/Object;)V
    //   82: aload_0
    //   83: iload_1
    //   84: invokespecial p : (I)V
    //   87: goto -> 276
    //   90: aload_0
    //   91: getfield b : Landroid/util/SparseArray;
    //   94: iload_1
    //   95: invokevirtual get : (I)Ljava/lang/Object;
    //   98: checkcast com/ss/android/socialbase/downloader/g/d
    //   101: astore_3
    //   102: aload_3
    //   103: ifnull -> 134
    //   106: aload_0
    //   107: getfield e : Landroid/util/SparseArray;
    //   110: iload_1
    //   111: invokevirtual get : (I)Ljava/lang/Object;
    //   114: ifnonnull -> 126
    //   117: aload_0
    //   118: getfield e : Landroid/util/SparseArray;
    //   121: iload_1
    //   122: aload_3
    //   123: invokevirtual put : (ILjava/lang/Object;)V
    //   126: aload_0
    //   127: getfield b : Landroid/util/SparseArray;
    //   130: iload_1
    //   131: invokevirtual remove : (I)V
    //   134: aload_0
    //   135: iload_1
    //   136: invokespecial p : (I)V
    //   139: goto -> 276
    //   142: aload_0
    //   143: getfield b : Landroid/util/SparseArray;
    //   146: iload_1
    //   147: invokevirtual get : (I)Ljava/lang/Object;
    //   150: checkcast com/ss/android/socialbase/downloader/g/d
    //   153: astore_3
    //   154: aload_0
    //   155: getfield c : Landroid/util/SparseArray;
    //   158: iload_1
    //   159: aload_3
    //   160: invokevirtual put : (ILjava/lang/Object;)V
    //   163: aload_0
    //   164: getfield b : Landroid/util/SparseArray;
    //   167: iload_1
    //   168: invokevirtual remove : (I)V
    //   171: aload_0
    //   172: iload_1
    //   173: invokespecial p : (I)V
    //   176: goto -> 276
    //   179: aload_0
    //   180: getfield b : Landroid/util/SparseArray;
    //   183: iload_1
    //   184: invokevirtual remove : (I)V
    //   187: aload_0
    //   188: iload_1
    //   189: invokespecial p : (I)V
    //   192: goto -> 276
    //   195: aload_0
    //   196: getfield b : Landroid/util/SparseArray;
    //   199: iload_1
    //   200: invokevirtual get : (I)Ljava/lang/Object;
    //   203: checkcast com/ss/android/socialbase/downloader/g/d
    //   206: astore_3
    //   207: aload_0
    //   208: getfield c : Landroid/util/SparseArray;
    //   211: iload_1
    //   212: aload_3
    //   213: invokevirtual put : (ILjava/lang/Object;)V
    //   216: aload_0
    //   217: getfield b : Landroid/util/SparseArray;
    //   220: iload_1
    //   221: invokevirtual remove : (I)V
    //   224: goto -> 276
    //   227: aload_0
    //   228: getfield b : Landroid/util/SparseArray;
    //   231: iload_1
    //   232: invokevirtual get : (I)Ljava/lang/Object;
    //   235: checkcast com/ss/android/socialbase/downloader/g/d
    //   238: astore_3
    //   239: aload_3
    //   240: ifnull -> 271
    //   243: aload_0
    //   244: getfield d : Landroid/util/SparseArray;
    //   247: iload_1
    //   248: invokevirtual get : (I)Ljava/lang/Object;
    //   251: ifnonnull -> 263
    //   254: aload_0
    //   255: getfield d : Landroid/util/SparseArray;
    //   258: iload_1
    //   259: aload_3
    //   260: invokevirtual put : (ILjava/lang/Object;)V
    //   263: aload_0
    //   264: getfield b : Landroid/util/SparseArray;
    //   267: iload_1
    //   268: invokevirtual remove : (I)V
    //   271: aload_0
    //   272: iload_1
    //   273: invokespecial p : (I)V
    //   276: aload_0
    //   277: monitorexit
    //   278: return
    //   279: astore_3
    //   280: aload_0
    //   281: monitorexit
    //   282: aload_3
    //   283: athrow
    // Exception table:
    //   from	to	target	type
    //   46	58	279	finally
    //   62	82	279	finally
    //   82	87	279	finally
    //   90	102	279	finally
    //   106	126	279	finally
    //   126	134	279	finally
    //   134	139	279	finally
    //   142	176	279	finally
    //   179	192	279	finally
    //   195	224	279	finally
    //   227	239	279	finally
    //   243	263	279	finally
    //   263	271	279	finally
    //   271	276	279	finally
  }
  
  public void a(int paramInt1, int paramInt2, w paramw, h paramh, boolean paramBoolean) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: iload_1
    //   4: invokespecial o : (I)Lcom/ss/android/socialbase/downloader/g/d;
    //   7: astore #7
    //   9: aload #7
    //   11: astore #6
    //   13: aload #7
    //   15: ifnonnull -> 34
    //   18: aload_0
    //   19: getfield g : Lcom/ss/android/socialbase/downloader/m/h;
    //   22: iload_1
    //   23: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   26: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   29: checkcast com/ss/android/socialbase/downloader/g/d
    //   32: astore #6
    //   34: aload #6
    //   36: ifnull -> 50
    //   39: aload #6
    //   41: iload_2
    //   42: aload_3
    //   43: aload #4
    //   45: iload #5
    //   47: invokevirtual a : (ILcom/ss/android/socialbase/downloader/d/w;Lcom/ss/android/socialbase/downloader/b/h;Z)V
    //   50: aload_0
    //   51: monitorexit
    //   52: return
    //   53: astore_3
    //   54: aload_0
    //   55: monitorexit
    //   56: aload_3
    //   57: athrow
    // Exception table:
    //   from	to	target	type
    //   2	9	53	finally
    //   18	34	53	finally
    //   39	50	53	finally
  }
  
  public void a(int paramInt, z paramz) {
    synchronized (this.b) {
      d d = (d)this.b.get(paramInt);
      if (d != null)
        d.b(paramz); 
      return;
    } 
  }
  
  protected abstract void a(int paramInt, d paramd);
  
  public void a(Message paramMessage) {
    // Byte code:
    //   0: aload_1
    //   1: getfield arg1 : I
    //   4: istore_2
    //   5: aload_1
    //   6: getfield obj : Ljava/lang/Object;
    //   9: instanceof java/lang/Exception
    //   12: ifeq -> 26
    //   15: aload_1
    //   16: getfield obj : Ljava/lang/Object;
    //   19: checkcast com/ss/android/socialbase/downloader/e/a
    //   22: astore_3
    //   23: goto -> 28
    //   26: aconst_null
    //   27: astore_3
    //   28: ldc com/ss/android/socialbase/downloader/impls/a
    //   30: monitorenter
    //   31: aload_0
    //   32: getfield b : Landroid/util/SparseArray;
    //   35: iload_2
    //   36: invokevirtual get : (I)Ljava/lang/Object;
    //   39: checkcast com/ss/android/socialbase/downloader/g/d
    //   42: astore #4
    //   44: aload #4
    //   46: ifnonnull -> 53
    //   49: ldc com/ss/android/socialbase/downloader/impls/a
    //   51: monitorexit
    //   52: return
    //   53: aload_0
    //   54: aload_1
    //   55: getfield what : I
    //   58: aload_3
    //   59: aload #4
    //   61: invokespecial a : (ILcom/ss/android/socialbase/downloader/e/a;Lcom/ss/android/socialbase/downloader/g/d;)V
    //   64: aload_0
    //   65: iload_2
    //   66: aload_1
    //   67: getfield what : I
    //   70: invokevirtual a : (II)V
    //   73: ldc com/ss/android/socialbase/downloader/impls/a
    //   75: monitorexit
    //   76: return
    //   77: astore_1
    //   78: ldc com/ss/android/socialbase/downloader/impls/a
    //   80: monitorexit
    //   81: aload_1
    //   82: athrow
    // Exception table:
    //   from	to	target	type
    //   31	44	77	finally
    //   49	52	77	finally
    //   53	76	77	finally
    //   78	81	77	finally
  }
  
  public void a(d paramd) {
    if (paramd == null)
      return; 
    c c = paramd.a();
    if (c == null)
      return; 
    if (c.r() != g.a) {
      b(paramd);
      return;
    } 
    a(paramd, true);
  }
  
  public abstract void a(c paramc);
  
  public void a(List<String> paramList) {
    boolean bool;
    /* monitor enter ThisExpression{ObjectType{com/ss/android/socialbase/downloader/impls/a}} */
    try {
      if (c.a(1048576)) {
        bool = f.a(b.B());
      } else {
        bool = true;
      } 
    } catch (Exception exception) {
      exception.printStackTrace();
      /* monitor exit ThisExpression{ObjectType{com/ss/android/socialbase/downloader/impls/a}} */
      return;
    } finally {}
    int i;
    for (i = 0; i < this.d.size(); i++) {
      int j = this.d.keyAt(i);
      d d = (d)this.d.get(j);
      if (d != null) {
        c c = d.a();
        if (c != null && paramList.contains(c.ah()) && (!c.x() || bool)) {
          c.a(true);
          c.b(true);
          a(d);
        } 
      } 
    } 
    /* monitor exit ThisExpression{ObjectType{com/ss/android/socialbase/downloader/impls/a}} */
  }
  
  public abstract boolean a(int paramInt);
  
  public boolean a(int paramInt, boolean paramBoolean) {
    d d2 = (d)this.b.get(paramInt);
    d d1 = d2;
    if (d2 == null) {
      d1 = d2;
      if (c.a(65536))
        d1 = o(paramInt); 
    } 
    if (d1 != null) {
      (new e(d1, (Handler)this.a)).c();
      c c1 = d1.a();
      SparseArray sparseArray2 = d1.a(h.a);
      SparseArray sparseArray1 = d1.a(h.c);
      this.a.post(new Runnable(this, sparseArray2, c1, sparseArray1) {
            public void run() {
              // Byte code:
              //   0: aload_0
              //   1: getfield a : Landroid/util/SparseArray;
              //   4: astore #4
              //   6: iconst_0
              //   7: istore_2
              //   8: aload #4
              //   10: ifnull -> 84
              //   13: aload #4
              //   15: monitorenter
              //   16: iconst_0
              //   17: istore_1
              //   18: iload_1
              //   19: aload_0
              //   20: getfield a : Landroid/util/SparseArray;
              //   23: invokevirtual size : ()I
              //   26: if_icmpge -> 70
              //   29: aload_0
              //   30: getfield a : Landroid/util/SparseArray;
              //   33: iload_1
              //   34: invokevirtual keyAt : (I)I
              //   37: istore_3
              //   38: aload_0
              //   39: getfield a : Landroid/util/SparseArray;
              //   42: iload_3
              //   43: invokevirtual get : (I)Ljava/lang/Object;
              //   46: checkcast com/ss/android/socialbase/downloader/d/w
              //   49: astore #5
              //   51: aload #5
              //   53: ifnull -> 184
              //   56: aload #5
              //   58: aload_0
              //   59: getfield b : Lcom/ss/android/socialbase/downloader/g/c;
              //   62: invokeinterface f : (Lcom/ss/android/socialbase/downloader/g/c;)V
              //   67: goto -> 184
              //   70: aload #4
              //   72: monitorexit
              //   73: goto -> 84
              //   76: astore #5
              //   78: aload #4
              //   80: monitorexit
              //   81: aload #5
              //   83: athrow
              //   84: aload_0
              //   85: getfield b : Lcom/ss/android/socialbase/downloader/g/c;
              //   88: astore #4
              //   90: aload #4
              //   92: ifnull -> 183
              //   95: aload #4
              //   97: invokevirtual af : ()Z
              //   100: ifeq -> 183
              //   103: aload_0
              //   104: getfield c : Landroid/util/SparseArray;
              //   107: astore #4
              //   109: aload #4
              //   111: ifnull -> 183
              //   114: aload #4
              //   116: monitorenter
              //   117: iload_2
              //   118: istore_1
              //   119: iload_1
              //   120: aload_0
              //   121: getfield c : Landroid/util/SparseArray;
              //   124: invokevirtual size : ()I
              //   127: if_icmpge -> 171
              //   130: aload_0
              //   131: getfield c : Landroid/util/SparseArray;
              //   134: iload_1
              //   135: invokevirtual keyAt : (I)I
              //   138: istore_2
              //   139: aload_0
              //   140: getfield c : Landroid/util/SparseArray;
              //   143: iload_2
              //   144: invokevirtual get : (I)Ljava/lang/Object;
              //   147: checkcast com/ss/android/socialbase/downloader/d/w
              //   150: astore #5
              //   152: aload #5
              //   154: ifnull -> 191
              //   157: aload #5
              //   159: aload_0
              //   160: getfield b : Lcom/ss/android/socialbase/downloader/g/c;
              //   163: invokeinterface f : (Lcom/ss/android/socialbase/downloader/g/c;)V
              //   168: goto -> 191
              //   171: aload #4
              //   173: monitorexit
              //   174: return
              //   175: astore #5
              //   177: aload #4
              //   179: monitorexit
              //   180: aload #5
              //   182: athrow
              //   183: return
              //   184: iload_1
              //   185: iconst_1
              //   186: iadd
              //   187: istore_1
              //   188: goto -> 18
              //   191: iload_1
              //   192: iconst_1
              //   193: iadd
              //   194: istore_1
              //   195: goto -> 119
              // Exception table:
              //   from	to	target	type
              //   18	51	76	finally
              //   56	67	76	finally
              //   70	73	76	finally
              //   78	81	76	finally
              //   119	152	175	finally
              //   157	168	175	finally
              //   171	174	175	finally
              //   177	180	175	finally
            }
          });
    } 
    c c = this.j.b(paramInt);
    if (c.a(65536)) {
      if (c != null)
        c.b(-4); 
    } else if (c != null && f.b(c.q())) {
      c.b(-4);
    } 
    b(paramInt, paramBoolean);
    return true;
  }
  
  public List<c> b(String paramString) {
    if (TextUtils.isEmpty(paramString))
      return null; 
    Iterator<Integer> iterator = a().iterator();
    ArrayList<c> arrayList = new ArrayList();
    while (iterator.hasNext()) {
      c c = d(((Integer)iterator.next()).intValue());
      if (c != null && paramString.equals(c.ah()))
        arrayList.add(c); 
    } 
    return arrayList;
  }
  
  public void b() {
    List<Integer> list = a();
    if (list == null)
      return; 
    Iterator<Integer> iterator = list.iterator();
    while (iterator.hasNext())
      e(((Integer)iterator.next()).intValue()); 
  }
  
  protected abstract void b(int paramInt);
  
  public void b(int paramInt1, int paramInt2, w paramw, h paramh, boolean paramBoolean) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: iload_1
    //   4: invokespecial o : (I)Lcom/ss/android/socialbase/downloader/g/d;
    //   7: astore #6
    //   9: aload #6
    //   11: ifnull -> 111
    //   14: aload #6
    //   16: iload_2
    //   17: aload_3
    //   18: aload #4
    //   20: iload #5
    //   22: invokevirtual b : (ILcom/ss/android/socialbase/downloader/d/w;Lcom/ss/android/socialbase/downloader/b/h;Z)V
    //   25: aload #6
    //   27: invokevirtual a : ()Lcom/ss/android/socialbase/downloader/g/c;
    //   30: astore #6
    //   32: aload #6
    //   34: ifnull -> 229
    //   37: aload_0
    //   38: iload_1
    //   39: invokevirtual a : (I)Z
    //   42: ifne -> 229
    //   45: aload #4
    //   47: getstatic com/ss/android/socialbase/downloader/b/h.a : Lcom/ss/android/socialbase/downloader/b/h;
    //   50: if_acmpeq -> 61
    //   53: aload #4
    //   55: getstatic com/ss/android/socialbase/downloader/b/h.c : Lcom/ss/android/socialbase/downloader/b/h;
    //   58: if_acmpne -> 229
    //   61: iconst_1
    //   62: istore_2
    //   63: iload_2
    //   64: istore_1
    //   65: aload #4
    //   67: getstatic com/ss/android/socialbase/downloader/b/h.c : Lcom/ss/android/socialbase/downloader/b/h;
    //   70: if_acmpne -> 85
    //   73: iload_2
    //   74: istore_1
    //   75: aload #6
    //   77: invokevirtual af : ()Z
    //   80: ifne -> 85
    //   83: iconst_0
    //   84: istore_1
    //   85: iload_1
    //   86: ifeq -> 229
    //   89: aload_0
    //   90: getfield a : Lcom/ss/android/socialbase/downloader/l/f;
    //   93: new com/ss/android/socialbase/downloader/impls/a$4
    //   96: dup
    //   97: aload_0
    //   98: aload #6
    //   100: aload_3
    //   101: invokespecial <init> : (Lcom/ss/android/socialbase/downloader/impls/a;Lcom/ss/android/socialbase/downloader/g/c;Lcom/ss/android/socialbase/downloader/d/w;)V
    //   104: invokevirtual post : (Ljava/lang/Runnable;)Z
    //   107: pop
    //   108: goto -> 229
    //   111: ldc_w 32768
    //   114: invokestatic a : (I)Z
    //   117: ifeq -> 229
    //   120: aload_0
    //   121: getfield j : Lcom/ss/android/socialbase/downloader/downloader/k;
    //   124: iload_1
    //   125: invokeinterface b : (I)Lcom/ss/android/socialbase/downloader/g/c;
    //   130: astore #8
    //   132: aload #8
    //   134: ifnull -> 229
    //   137: aload #8
    //   139: invokevirtual q : ()I
    //   142: bipush #-3
    //   144: if_icmpeq -> 229
    //   147: aload_0
    //   148: getfield g : Lcom/ss/android/socialbase/downloader/m/h;
    //   151: iload_1
    //   152: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   155: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   158: checkcast com/ss/android/socialbase/downloader/g/d
    //   161: astore #7
    //   163: aload #7
    //   165: astore #6
    //   167: aload #7
    //   169: ifnonnull -> 218
    //   172: new com/ss/android/socialbase/downloader/g/d
    //   175: dup
    //   176: aload #8
    //   178: invokespecial <init> : (Lcom/ss/android/socialbase/downloader/g/c;)V
    //   181: astore #6
    //   183: aload_0
    //   184: getfield g : Lcom/ss/android/socialbase/downloader/m/h;
    //   187: astore #7
    //   189: aload #7
    //   191: monitorenter
    //   192: aload_0
    //   193: getfield g : Lcom/ss/android/socialbase/downloader/m/h;
    //   196: iload_1
    //   197: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   200: aload #6
    //   202: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   205: pop
    //   206: aload #7
    //   208: monitorexit
    //   209: goto -> 218
    //   212: astore_3
    //   213: aload #7
    //   215: monitorexit
    //   216: aload_3
    //   217: athrow
    //   218: aload #6
    //   220: iload_2
    //   221: aload_3
    //   222: aload #4
    //   224: iload #5
    //   226: invokevirtual b : (ILcom/ss/android/socialbase/downloader/d/w;Lcom/ss/android/socialbase/downloader/b/h;Z)V
    //   229: aload_0
    //   230: monitorexit
    //   231: return
    //   232: astore_3
    //   233: aload_0
    //   234: monitorexit
    //   235: aload_3
    //   236: athrow
    // Exception table:
    //   from	to	target	type
    //   2	9	232	finally
    //   14	32	232	finally
    //   37	61	232	finally
    //   65	73	232	finally
    //   75	83	232	finally
    //   89	108	232	finally
    //   111	132	232	finally
    //   137	163	232	finally
    //   172	192	232	finally
    //   192	209	212	finally
    //   213	216	212	finally
    //   216	218	232	finally
    //   218	229	232	finally
  }
  
  public void b(int paramInt, boolean paramBoolean) {
    c c = this.j.b(paramInt);
    if (c != null)
      a(c); 
    c(paramInt);
    this.a.post(new Runnable(this, paramInt) {
          public void run() {
            b.a().f(this.a);
          }
        });
    if (f.d()) {
      Runnable runnable = new Runnable(this, paramInt, paramBoolean) {
          public void run() {
            a.a(this.c, this.a, this.b);
          }
        };
      ExecutorService executorService = b.k();
      if (executorService != null) {
        executorService.execute(runnable);
        return;
      } 
    } else {
      c(paramInt, paramBoolean);
    } 
  }
  
  protected abstract c c(int paramInt);
  
  public c d(int paramInt) {
    c c = this.j.b(paramInt);
    if (c == null)
      synchronized (this.b) {
        d d = (d)this.b.get(paramInt);
        if (d != null)
          c = d.a(); 
        return c;
      }  
    return c;
  }
  
  public boolean e(int paramInt) {
    com.ss.android.socialbase.downloader.f.a.b("AbsDownloadEngine", "pause id");
    b(paramInt);
    c c = this.j.b(paramInt);
    if (c == null) {
      synchronized (this.b) {
        d d = (d)this.b.get(paramInt);
        if (d != null) {
          (new e(d, (Handler)this.a)).d();
          return true;
        } 
      } 
    } else {
      a(c);
      if (c.q() == 1) {
        synchronized (this.b) {
          d d = (d)this.b.get(paramInt);
          if (d != null) {
            (new e(d, (Handler)this.a)).d();
            return true;
          } 
        } 
      } else if (f.b(c.q())) {
        c.b(-2);
        return true;
      } 
    } 
    return false;
  }
  
  public boolean f(int paramInt) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield b : Landroid/util/SparseArray;
    //   6: iload_1
    //   7: invokevirtual get : (I)Ljava/lang/Object;
    //   10: checkcast com/ss/android/socialbase/downloader/g/d
    //   13: astore_2
    //   14: aload_2
    //   15: ifnull -> 26
    //   18: aload_0
    //   19: aload_2
    //   20: invokevirtual a : (Lcom/ss/android/socialbase/downloader/g/d;)V
    //   23: goto -> 32
    //   26: aload_0
    //   27: iload_1
    //   28: invokevirtual g : (I)Z
    //   31: pop
    //   32: aload_0
    //   33: monitorexit
    //   34: iconst_1
    //   35: ireturn
    //   36: astore_2
    //   37: aload_0
    //   38: monitorexit
    //   39: aload_2
    //   40: athrow
    // Exception table:
    //   from	to	target	type
    //   2	14	36	finally
    //   18	23	36	finally
    //   26	32	36	finally
  }
  
  public boolean g(int paramInt) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield d : Landroid/util/SparseArray;
    //   6: iload_1
    //   7: invokevirtual get : (I)Ljava/lang/Object;
    //   10: checkcast com/ss/android/socialbase/downloader/g/d
    //   13: astore_2
    //   14: aload_2
    //   15: ifnull -> 26
    //   18: aload_0
    //   19: aload_2
    //   20: invokevirtual a : (Lcom/ss/android/socialbase/downloader/g/d;)V
    //   23: goto -> 47
    //   26: aload_0
    //   27: getfield e : Landroid/util/SparseArray;
    //   30: iload_1
    //   31: invokevirtual get : (I)Ljava/lang/Object;
    //   34: checkcast com/ss/android/socialbase/downloader/g/d
    //   37: astore_2
    //   38: aload_2
    //   39: ifnull -> 51
    //   42: aload_0
    //   43: aload_2
    //   44: invokevirtual a : (Lcom/ss/android/socialbase/downloader/g/d;)V
    //   47: aload_0
    //   48: monitorexit
    //   49: iconst_1
    //   50: ireturn
    //   51: aload_0
    //   52: monitorexit
    //   53: iconst_0
    //   54: ireturn
    //   55: astore_2
    //   56: aload_0
    //   57: monitorexit
    //   58: aload_2
    //   59: athrow
    // Exception table:
    //   from	to	target	type
    //   2	14	55	finally
    //   18	23	55	finally
    //   26	38	55	finally
    //   42	47	55	finally
  }
  
  public ac h(int paramInt) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield b : Landroid/util/SparseArray;
    //   6: iload_1
    //   7: invokevirtual get : (I)Ljava/lang/Object;
    //   10: checkcast com/ss/android/socialbase/downloader/g/d
    //   13: astore_2
    //   14: aload_2
    //   15: ifnull -> 27
    //   18: aload_2
    //   19: invokevirtual k : ()Lcom/ss/android/socialbase/downloader/d/ac;
    //   22: astore_2
    //   23: aload_0
    //   24: monitorexit
    //   25: aload_2
    //   26: areturn
    //   27: aload_0
    //   28: getfield c : Landroid/util/SparseArray;
    //   31: iload_1
    //   32: invokevirtual get : (I)Ljava/lang/Object;
    //   35: checkcast com/ss/android/socialbase/downloader/g/d
    //   38: astore_2
    //   39: aload_2
    //   40: ifnull -> 52
    //   43: aload_2
    //   44: invokevirtual k : ()Lcom/ss/android/socialbase/downloader/d/ac;
    //   47: astore_2
    //   48: aload_0
    //   49: monitorexit
    //   50: aload_2
    //   51: areturn
    //   52: aload_0
    //   53: getfield d : Landroid/util/SparseArray;
    //   56: iload_1
    //   57: invokevirtual get : (I)Ljava/lang/Object;
    //   60: checkcast com/ss/android/socialbase/downloader/g/d
    //   63: astore_2
    //   64: aload_2
    //   65: ifnull -> 77
    //   68: aload_2
    //   69: invokevirtual k : ()Lcom/ss/android/socialbase/downloader/d/ac;
    //   72: astore_2
    //   73: aload_0
    //   74: monitorexit
    //   75: aload_2
    //   76: areturn
    //   77: aload_0
    //   78: getfield e : Landroid/util/SparseArray;
    //   81: iload_1
    //   82: invokevirtual get : (I)Ljava/lang/Object;
    //   85: checkcast com/ss/android/socialbase/downloader/g/d
    //   88: astore_2
    //   89: aload_2
    //   90: ifnull -> 102
    //   93: aload_2
    //   94: invokevirtual k : ()Lcom/ss/android/socialbase/downloader/d/ac;
    //   97: astore_2
    //   98: aload_0
    //   99: monitorexit
    //   100: aload_2
    //   101: areturn
    //   102: aload_0
    //   103: getfield f : Landroid/util/SparseArray;
    //   106: iload_1
    //   107: invokevirtual get : (I)Ljava/lang/Object;
    //   110: checkcast com/ss/android/socialbase/downloader/g/d
    //   113: astore_2
    //   114: aload_2
    //   115: ifnull -> 127
    //   118: aload_2
    //   119: invokevirtual k : ()Lcom/ss/android/socialbase/downloader/d/ac;
    //   122: astore_2
    //   123: aload_0
    //   124: monitorexit
    //   125: aload_2
    //   126: areturn
    //   127: aload_0
    //   128: monitorexit
    //   129: aconst_null
    //   130: areturn
    //   131: astore_2
    //   132: aload_0
    //   133: monitorexit
    //   134: aload_2
    //   135: athrow
    // Exception table:
    //   from	to	target	type
    //   2	14	131	finally
    //   18	23	131	finally
    //   27	39	131	finally
    //   43	48	131	finally
    //   52	64	131	finally
    //   68	73	131	finally
    //   77	89	131	finally
    //   93	98	131	finally
    //   102	114	131	finally
    //   118	123	131	finally
  }
  
  public z i(int paramInt) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield b : Landroid/util/SparseArray;
    //   6: iload_1
    //   7: invokevirtual get : (I)Ljava/lang/Object;
    //   10: checkcast com/ss/android/socialbase/downloader/g/d
    //   13: astore_2
    //   14: aload_2
    //   15: ifnull -> 27
    //   18: aload_2
    //   19: invokevirtual j : ()Lcom/ss/android/socialbase/downloader/d/z;
    //   22: astore_2
    //   23: aload_0
    //   24: monitorexit
    //   25: aload_2
    //   26: areturn
    //   27: aload_0
    //   28: getfield c : Landroid/util/SparseArray;
    //   31: iload_1
    //   32: invokevirtual get : (I)Ljava/lang/Object;
    //   35: checkcast com/ss/android/socialbase/downloader/g/d
    //   38: astore_2
    //   39: aload_2
    //   40: ifnull -> 52
    //   43: aload_2
    //   44: invokevirtual j : ()Lcom/ss/android/socialbase/downloader/d/z;
    //   47: astore_2
    //   48: aload_0
    //   49: monitorexit
    //   50: aload_2
    //   51: areturn
    //   52: aload_0
    //   53: getfield d : Landroid/util/SparseArray;
    //   56: iload_1
    //   57: invokevirtual get : (I)Ljava/lang/Object;
    //   60: checkcast com/ss/android/socialbase/downloader/g/d
    //   63: astore_2
    //   64: aload_2
    //   65: ifnull -> 77
    //   68: aload_2
    //   69: invokevirtual j : ()Lcom/ss/android/socialbase/downloader/d/z;
    //   72: astore_2
    //   73: aload_0
    //   74: monitorexit
    //   75: aload_2
    //   76: areturn
    //   77: aload_0
    //   78: getfield e : Landroid/util/SparseArray;
    //   81: iload_1
    //   82: invokevirtual get : (I)Ljava/lang/Object;
    //   85: checkcast com/ss/android/socialbase/downloader/g/d
    //   88: astore_2
    //   89: aload_2
    //   90: ifnull -> 102
    //   93: aload_2
    //   94: invokevirtual j : ()Lcom/ss/android/socialbase/downloader/d/z;
    //   97: astore_2
    //   98: aload_0
    //   99: monitorexit
    //   100: aload_2
    //   101: areturn
    //   102: aload_0
    //   103: getfield f : Landroid/util/SparseArray;
    //   106: iload_1
    //   107: invokevirtual get : (I)Ljava/lang/Object;
    //   110: checkcast com/ss/android/socialbase/downloader/g/d
    //   113: astore_2
    //   114: aload_2
    //   115: ifnull -> 127
    //   118: aload_2
    //   119: invokevirtual j : ()Lcom/ss/android/socialbase/downloader/d/z;
    //   122: astore_2
    //   123: aload_0
    //   124: monitorexit
    //   125: aload_2
    //   126: areturn
    //   127: aload_0
    //   128: monitorexit
    //   129: aconst_null
    //   130: areturn
    //   131: astore_2
    //   132: aload_0
    //   133: monitorexit
    //   134: aload_2
    //   135: athrow
    // Exception table:
    //   from	to	target	type
    //   2	14	131	finally
    //   18	23	131	finally
    //   27	39	131	finally
    //   43	48	131	finally
    //   52	64	131	finally
    //   68	73	131	finally
    //   77	89	131	finally
    //   93	98	131	finally
    //   102	114	131	finally
    //   118	123	131	finally
  }
  
  public q j(int paramInt) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield b : Landroid/util/SparseArray;
    //   6: iload_1
    //   7: invokevirtual get : (I)Ljava/lang/Object;
    //   10: checkcast com/ss/android/socialbase/downloader/g/d
    //   13: astore_2
    //   14: aload_2
    //   15: ifnull -> 27
    //   18: aload_2
    //   19: invokevirtual l : ()Lcom/ss/android/socialbase/downloader/d/q;
    //   22: astore_2
    //   23: aload_0
    //   24: monitorexit
    //   25: aload_2
    //   26: areturn
    //   27: aload_0
    //   28: getfield c : Landroid/util/SparseArray;
    //   31: iload_1
    //   32: invokevirtual get : (I)Ljava/lang/Object;
    //   35: checkcast com/ss/android/socialbase/downloader/g/d
    //   38: astore_2
    //   39: aload_2
    //   40: ifnull -> 52
    //   43: aload_2
    //   44: invokevirtual l : ()Lcom/ss/android/socialbase/downloader/d/q;
    //   47: astore_2
    //   48: aload_0
    //   49: monitorexit
    //   50: aload_2
    //   51: areturn
    //   52: aload_0
    //   53: getfield d : Landroid/util/SparseArray;
    //   56: iload_1
    //   57: invokevirtual get : (I)Ljava/lang/Object;
    //   60: checkcast com/ss/android/socialbase/downloader/g/d
    //   63: astore_2
    //   64: aload_2
    //   65: ifnull -> 77
    //   68: aload_2
    //   69: invokevirtual l : ()Lcom/ss/android/socialbase/downloader/d/q;
    //   72: astore_2
    //   73: aload_0
    //   74: monitorexit
    //   75: aload_2
    //   76: areturn
    //   77: aload_0
    //   78: getfield e : Landroid/util/SparseArray;
    //   81: iload_1
    //   82: invokevirtual get : (I)Ljava/lang/Object;
    //   85: checkcast com/ss/android/socialbase/downloader/g/d
    //   88: astore_2
    //   89: aload_2
    //   90: ifnull -> 102
    //   93: aload_2
    //   94: invokevirtual l : ()Lcom/ss/android/socialbase/downloader/d/q;
    //   97: astore_2
    //   98: aload_0
    //   99: monitorexit
    //   100: aload_2
    //   101: areturn
    //   102: aload_0
    //   103: getfield f : Landroid/util/SparseArray;
    //   106: iload_1
    //   107: invokevirtual get : (I)Ljava/lang/Object;
    //   110: checkcast com/ss/android/socialbase/downloader/g/d
    //   113: astore_2
    //   114: aload_2
    //   115: ifnull -> 127
    //   118: aload_2
    //   119: invokevirtual l : ()Lcom/ss/android/socialbase/downloader/d/q;
    //   122: astore_2
    //   123: aload_0
    //   124: monitorexit
    //   125: aload_2
    //   126: areturn
    //   127: aload_0
    //   128: monitorexit
    //   129: aconst_null
    //   130: areturn
    //   131: astore_2
    //   132: aload_0
    //   133: monitorexit
    //   134: aload_2
    //   135: athrow
    // Exception table:
    //   from	to	target	type
    //   2	14	131	finally
    //   18	23	131	finally
    //   27	39	131	finally
    //   43	48	131	finally
    //   52	64	131	finally
    //   68	73	131	finally
    //   77	89	131	finally
    //   93	98	131	finally
    //   102	114	131	finally
    //   118	123	131	finally
  }
  
  public boolean k(int paramInt) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield e : Landroid/util/SparseArray;
    //   6: iload_1
    //   7: invokevirtual get : (I)Ljava/lang/Object;
    //   10: checkcast com/ss/android/socialbase/downloader/g/d
    //   13: astore_2
    //   14: aload_2
    //   15: ifnull -> 44
    //   18: aload_2
    //   19: invokevirtual a : ()Lcom/ss/android/socialbase/downloader/g/c;
    //   22: astore_3
    //   23: aload_3
    //   24: ifnull -> 44
    //   27: aload_3
    //   28: invokevirtual au : ()Z
    //   31: ifeq -> 40
    //   34: aload_0
    //   35: aload_2
    //   36: iconst_0
    //   37: invokespecial a : (Lcom/ss/android/socialbase/downloader/g/d;Z)V
    //   40: aload_0
    //   41: monitorexit
    //   42: iconst_1
    //   43: ireturn
    //   44: aload_0
    //   45: getfield j : Lcom/ss/android/socialbase/downloader/downloader/k;
    //   48: iload_1
    //   49: invokeinterface b : (I)Lcom/ss/android/socialbase/downloader/g/c;
    //   54: astore_2
    //   55: aload_2
    //   56: ifnull -> 79
    //   59: aload_2
    //   60: invokevirtual au : ()Z
    //   63: ifeq -> 79
    //   66: aload_0
    //   67: new com/ss/android/socialbase/downloader/g/d
    //   70: dup
    //   71: aload_2
    //   72: invokespecial <init> : (Lcom/ss/android/socialbase/downloader/g/c;)V
    //   75: iconst_0
    //   76: invokespecial a : (Lcom/ss/android/socialbase/downloader/g/d;Z)V
    //   79: aload_0
    //   80: monitorexit
    //   81: iconst_0
    //   82: ireturn
    //   83: astore_2
    //   84: aload_0
    //   85: monitorexit
    //   86: aload_2
    //   87: athrow
    // Exception table:
    //   from	to	target	type
    //   2	14	83	finally
    //   18	23	83	finally
    //   27	40	83	finally
    //   44	55	83	finally
    //   59	79	83	finally
  }
  
  public boolean l(int paramInt) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield f : Landroid/util/SparseArray;
    //   6: iload_1
    //   7: invokevirtual get : (I)Ljava/lang/Object;
    //   10: checkcast com/ss/android/socialbase/downloader/g/d
    //   13: astore_2
    //   14: aload_2
    //   15: ifnull -> 43
    //   18: aload_2
    //   19: invokevirtual a : ()Lcom/ss/android/socialbase/downloader/g/c;
    //   22: astore_3
    //   23: aload_3
    //   24: ifnull -> 43
    //   27: aload_3
    //   28: invokevirtual av : ()Z
    //   31: ifeq -> 39
    //   34: aload_0
    //   35: aload_2
    //   36: invokevirtual a : (Lcom/ss/android/socialbase/downloader/g/d;)V
    //   39: aload_0
    //   40: monitorexit
    //   41: iconst_1
    //   42: ireturn
    //   43: aload_0
    //   44: monitorexit
    //   45: iconst_0
    //   46: ireturn
    //   47: astore_2
    //   48: aload_0
    //   49: monitorexit
    //   50: aload_2
    //   51: athrow
    // Exception table:
    //   from	to	target	type
    //   2	14	47	finally
    //   18	23	47	finally
    //   27	39	47	finally
  }
  
  public void m(int paramInt) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield b : Landroid/util/SparseArray;
    //   6: iload_1
    //   7: invokevirtual get : (I)Ljava/lang/Object;
    //   10: checkcast com/ss/android/socialbase/downloader/g/d
    //   13: astore_2
    //   14: aload_2
    //   15: ifnull -> 37
    //   18: aload_2
    //   19: invokevirtual a : ()Lcom/ss/android/socialbase/downloader/g/c;
    //   22: astore_3
    //   23: aload_3
    //   24: ifnull -> 37
    //   27: aload_3
    //   28: iconst_1
    //   29: invokevirtual i : (Z)V
    //   32: aload_0
    //   33: aload_2
    //   34: invokevirtual a : (Lcom/ss/android/socialbase/downloader/g/d;)V
    //   37: aload_0
    //   38: monitorexit
    //   39: return
    //   40: astore_2
    //   41: aload_0
    //   42: monitorexit
    //   43: aload_2
    //   44: athrow
    // Exception table:
    //   from	to	target	type
    //   2	14	40	finally
    //   18	23	40	finally
    //   27	37	40	finally
  }
  
  public boolean n(int paramInt) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: iload_1
    //   3: ifeq -> 54
    //   6: aload_0
    //   7: getfield b : Landroid/util/SparseArray;
    //   10: ifnull -> 24
    //   13: aload_0
    //   14: getfield b : Landroid/util/SparseArray;
    //   17: iload_1
    //   18: invokevirtual get : (I)Ljava/lang/Object;
    //   21: ifnonnull -> 44
    //   24: aload_0
    //   25: getfield d : Landroid/util/SparseArray;
    //   28: ifnull -> 54
    //   31: aload_0
    //   32: getfield d : Landroid/util/SparseArray;
    //   35: iload_1
    //   36: invokevirtual get : (I)Ljava/lang/Object;
    //   39: astore_3
    //   40: aload_3
    //   41: ifnull -> 54
    //   44: iconst_1
    //   45: istore_2
    //   46: goto -> 56
    //   49: astore_3
    //   50: aload_0
    //   51: monitorexit
    //   52: aload_3
    //   53: athrow
    //   54: iconst_0
    //   55: istore_2
    //   56: aload_0
    //   57: monitorexit
    //   58: iload_2
    //   59: ireturn
    // Exception table:
    //   from	to	target	type
    //   6	24	49	finally
    //   24	40	49	finally
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\ss\android\socialbase\downloader\impls\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */