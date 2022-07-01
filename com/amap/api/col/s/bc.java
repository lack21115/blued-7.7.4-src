package com.amap.api.col.s;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.PoiItem;
import com.amap.api.services.interfaces.IPoiSearch;
import com.amap.api.services.poisearch.PoiResult;
import com.amap.api.services.poisearch.PoiSearch;
import java.util.HashMap;

public final class bc implements IPoiSearch {
  private static HashMap<Integer, PoiResult> i;
  
  private PoiSearch.SearchBound a;
  
  private PoiSearch.Query b;
  
  private Context c;
  
  private PoiSearch.OnPoiSearchListener d;
  
  private String e = "zh-CN";
  
  private PoiSearch.Query f;
  
  private PoiSearch.SearchBound g;
  
  private int h;
  
  private Handler j = null;
  
  public bc(Context paramContext, PoiSearch.Query paramQuery) {
    this.c = paramContext.getApplicationContext();
    setQuery(paramQuery);
    this.j = s.a();
  }
  
  public final PoiSearch.SearchBound getBound() {
    return this.a;
  }
  
  public final String getLanguage() {
    return this.e;
  }
  
  public final PoiSearch.Query getQuery() {
    return this.b;
  }
  
  public final PoiResult searchPOI() throws AMapException {
    // Byte code:
    //   0: aload_0
    //   1: getfield c : Landroid/content/Context;
    //   4: invokestatic a : (Landroid/content/Context;)Lcom/amap/api/col/s/q;
    //   7: pop
    //   8: aload_0
    //   9: invokevirtual getBound : ()Lcom/amap/api/services/poisearch/PoiSearch$SearchBound;
    //   12: astore #5
    //   14: iconst_1
    //   15: istore_2
    //   16: aload #5
    //   18: ifnull -> 43
    //   21: aload #5
    //   23: invokevirtual getShape : ()Ljava/lang/String;
    //   26: ldc 'Bound'
    //   28: invokevirtual equals : (Ljava/lang/Object;)Z
    //   31: istore #4
    //   33: iload #4
    //   35: ifeq -> 43
    //   38: iconst_1
    //   39: istore_1
    //   40: goto -> 45
    //   43: iconst_0
    //   44: istore_1
    //   45: iload_1
    //   46: ifne -> 95
    //   49: aload_0
    //   50: getfield b : Lcom/amap/api/services/poisearch/PoiSearch$Query;
    //   53: ifnull -> 729
    //   56: aload_0
    //   57: getfield b : Lcom/amap/api/services/poisearch/PoiSearch$Query;
    //   60: invokevirtual getQueryString : ()Ljava/lang/String;
    //   63: invokestatic a : (Ljava/lang/String;)Z
    //   66: ifeq -> 724
    //   69: aload_0
    //   70: getfield b : Lcom/amap/api/services/poisearch/PoiSearch$Query;
    //   73: invokevirtual getCategory : ()Ljava/lang/String;
    //   76: invokestatic a : (Ljava/lang/String;)Z
    //   79: ifne -> 729
    //   82: goto -> 724
    //   85: new com/amap/api/services/core/AMapException
    //   88: dup
    //   89: ldc '无效的参数 - IllegalArgumentException'
    //   91: invokespecial <init> : (Ljava/lang/String;)V
    //   94: athrow
    //   95: aload_0
    //   96: invokevirtual getBound : ()Lcom/amap/api/services/poisearch/PoiSearch$SearchBound;
    //   99: astore #6
    //   101: aload #6
    //   103: ifnull -> 755
    //   106: aload #6
    //   108: invokevirtual getShape : ()Ljava/lang/String;
    //   111: ldc 'Bound'
    //   113: invokevirtual equals : (Ljava/lang/Object;)Z
    //   116: ifeq -> 130
    //   119: aload #6
    //   121: invokevirtual getCenter : ()Lcom/amap/api/services/core/LatLonPoint;
    //   124: ifnonnull -> 755
    //   127: goto -> 738
    //   130: aload #6
    //   132: invokevirtual getShape : ()Ljava/lang/String;
    //   135: ldc 'Polygon'
    //   137: invokevirtual equals : (Ljava/lang/Object;)Z
    //   140: ifeq -> 193
    //   143: aload #6
    //   145: invokevirtual getPolyGonList : ()Ljava/util/List;
    //   148: astore #5
    //   150: aload #5
    //   152: ifnull -> 738
    //   155: aload #5
    //   157: invokeinterface size : ()I
    //   162: ifne -> 743
    //   165: goto -> 738
    //   168: iload_1
    //   169: aload #5
    //   171: invokeinterface size : ()I
    //   176: if_icmpge -> 755
    //   179: aload #5
    //   181: iload_1
    //   182: invokeinterface get : (I)Ljava/lang/Object;
    //   187: ifnonnull -> 748
    //   190: goto -> 738
    //   193: aload #6
    //   195: invokevirtual getShape : ()Ljava/lang/String;
    //   198: ldc 'Rectangle'
    //   200: invokevirtual equals : (Ljava/lang/Object;)Z
    //   203: ifeq -> 755
    //   206: aload #6
    //   208: invokevirtual getLowerLeft : ()Lcom/amap/api/services/core/LatLonPoint;
    //   211: astore #5
    //   213: aload #6
    //   215: invokevirtual getUpperRight : ()Lcom/amap/api/services/core/LatLonPoint;
    //   218: astore #6
    //   220: aload #5
    //   222: ifnull -> 738
    //   225: aload #6
    //   227: ifnonnull -> 233
    //   230: goto -> 738
    //   233: aload #5
    //   235: invokevirtual getLatitude : ()D
    //   238: aload #6
    //   240: invokevirtual getLatitude : ()D
    //   243: dcmpl
    //   244: ifge -> 738
    //   247: aload #5
    //   249: invokevirtual getLongitude : ()D
    //   252: aload #6
    //   254: invokevirtual getLongitude : ()D
    //   257: dcmpl
    //   258: iflt -> 755
    //   261: goto -> 738
    //   264: iload_1
    //   265: ifeq -> 690
    //   268: aload_0
    //   269: getfield b : Lcom/amap/api/services/poisearch/PoiSearch$Query;
    //   272: ifnull -> 680
    //   275: aload_0
    //   276: getfield b : Lcom/amap/api/services/poisearch/PoiSearch$Query;
    //   279: aload_0
    //   280: getfield f : Lcom/amap/api/services/poisearch/PoiSearch$Query;
    //   283: invokevirtual queryEquals : (Lcom/amap/api/services/poisearch/PoiSearch$Query;)Z
    //   286: ifne -> 296
    //   289: aload_0
    //   290: getfield a : Lcom/amap/api/services/poisearch/PoiSearch$SearchBound;
    //   293: ifnull -> 324
    //   296: aload_0
    //   297: getfield b : Lcom/amap/api/services/poisearch/PoiSearch$Query;
    //   300: aload_0
    //   301: getfield f : Lcom/amap/api/services/poisearch/PoiSearch$Query;
    //   304: invokevirtual queryEquals : (Lcom/amap/api/services/poisearch/PoiSearch$Query;)Z
    //   307: ifne -> 370
    //   310: aload_0
    //   311: getfield a : Lcom/amap/api/services/poisearch/PoiSearch$SearchBound;
    //   314: aload_0
    //   315: getfield g : Lcom/amap/api/services/poisearch/PoiSearch$SearchBound;
    //   318: invokevirtual equals : (Ljava/lang/Object;)Z
    //   321: ifne -> 370
    //   324: aload_0
    //   325: iconst_0
    //   326: putfield h : I
    //   329: aload_0
    //   330: aload_0
    //   331: getfield b : Lcom/amap/api/services/poisearch/PoiSearch$Query;
    //   334: invokevirtual clone : ()Lcom/amap/api/services/poisearch/PoiSearch$Query;
    //   337: putfield f : Lcom/amap/api/services/poisearch/PoiSearch$Query;
    //   340: aload_0
    //   341: getfield a : Lcom/amap/api/services/poisearch/PoiSearch$SearchBound;
    //   344: ifnull -> 358
    //   347: aload_0
    //   348: aload_0
    //   349: getfield a : Lcom/amap/api/services/poisearch/PoiSearch$SearchBound;
    //   352: invokevirtual clone : ()Lcom/amap/api/services/poisearch/PoiSearch$SearchBound;
    //   355: putfield g : Lcom/amap/api/services/poisearch/PoiSearch$SearchBound;
    //   358: getstatic com/amap/api/col/s/bc.i : Ljava/util/HashMap;
    //   361: ifnull -> 370
    //   364: getstatic com/amap/api/col/s/bc.i : Ljava/util/HashMap;
    //   367: invokevirtual clear : ()V
    //   370: aconst_null
    //   371: astore #5
    //   373: aload_0
    //   374: getfield a : Lcom/amap/api/services/poisearch/PoiSearch$SearchBound;
    //   377: ifnull -> 389
    //   380: aload_0
    //   381: getfield a : Lcom/amap/api/services/poisearch/PoiSearch$SearchBound;
    //   384: invokevirtual clone : ()Lcom/amap/api/services/poisearch/PoiSearch$SearchBound;
    //   387: astore #5
    //   389: invokestatic a : ()Lcom/amap/api/col/s/ag;
    //   392: aload_0
    //   393: getfield b : Lcom/amap/api/services/poisearch/PoiSearch$Query;
    //   396: invokevirtual getQueryString : ()Ljava/lang/String;
    //   399: invokevirtual a : (Ljava/lang/String;)V
    //   402: aload_0
    //   403: getfield b : Lcom/amap/api/services/poisearch/PoiSearch$Query;
    //   406: invokestatic a : ()Lcom/amap/api/col/s/ag;
    //   409: aload_0
    //   410: getfield b : Lcom/amap/api/services/poisearch/PoiSearch$Query;
    //   413: invokevirtual getPageNum : ()I
    //   416: invokevirtual a : (I)I
    //   419: invokevirtual setPageNum : (I)V
    //   422: aload_0
    //   423: getfield b : Lcom/amap/api/services/poisearch/PoiSearch$Query;
    //   426: invokestatic a : ()Lcom/amap/api/col/s/ag;
    //   429: aload_0
    //   430: getfield b : Lcom/amap/api/services/poisearch/PoiSearch$Query;
    //   433: invokevirtual getPageSize : ()I
    //   436: invokevirtual b : (I)I
    //   439: invokevirtual setPageSize : (I)V
    //   442: aload_0
    //   443: getfield h : I
    //   446: ifne -> 564
    //   449: new com/amap/api/col/s/y
    //   452: dup
    //   453: aload_0
    //   454: getfield c : Landroid/content/Context;
    //   457: new com/amap/api/col/s/ab
    //   460: dup
    //   461: aload_0
    //   462: getfield b : Lcom/amap/api/services/poisearch/PoiSearch$Query;
    //   465: invokevirtual clone : ()Lcom/amap/api/services/poisearch/PoiSearch$Query;
    //   468: aload #5
    //   470: invokespecial <init> : (Lcom/amap/api/services/poisearch/PoiSearch$Query;Lcom/amap/api/services/poisearch/PoiSearch$SearchBound;)V
    //   473: invokespecial <init> : (Landroid/content/Context;Lcom/amap/api/col/s/ab;)V
    //   476: invokevirtual n_ : ()Ljava/lang/Object;
    //   479: checkcast com/amap/api/services/poisearch/PoiResult
    //   482: astore #6
    //   484: new java/util/HashMap
    //   487: dup
    //   488: invokespecial <init> : ()V
    //   491: putstatic com/amap/api/col/s/bc.i : Ljava/util/HashMap;
    //   494: aload #6
    //   496: astore #5
    //   498: aload_0
    //   499: getfield b : Lcom/amap/api/services/poisearch/PoiSearch$Query;
    //   502: ifnull -> 769
    //   505: aload #6
    //   507: ifnonnull -> 513
    //   510: aload #6
    //   512: areturn
    //   513: aload #6
    //   515: astore #5
    //   517: aload_0
    //   518: getfield h : I
    //   521: ifle -> 769
    //   524: aload #6
    //   526: astore #5
    //   528: aload_0
    //   529: getfield h : I
    //   532: aload_0
    //   533: getfield b : Lcom/amap/api/services/poisearch/PoiSearch$Query;
    //   536: invokevirtual getPageNum : ()I
    //   539: if_icmple -> 769
    //   542: getstatic com/amap/api/col/s/bc.i : Ljava/util/HashMap;
    //   545: aload_0
    //   546: getfield b : Lcom/amap/api/services/poisearch/PoiSearch$Query;
    //   549: invokevirtual getPageNum : ()I
    //   552: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   555: aload #6
    //   557: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   560: pop
    //   561: aload #6
    //   563: areturn
    //   564: aload_0
    //   565: getfield b : Lcom/amap/api/services/poisearch/PoiSearch$Query;
    //   568: invokevirtual getPageNum : ()I
    //   571: istore_3
    //   572: iload_3
    //   573: aload_0
    //   574: getfield h : I
    //   577: if_icmpgt -> 760
    //   580: iload_3
    //   581: iflt -> 760
    //   584: iload_2
    //   585: istore_1
    //   586: goto -> 589
    //   589: iload_1
    //   590: ifeq -> 670
    //   593: getstatic com/amap/api/col/s/bc.i : Ljava/util/HashMap;
    //   596: iload_3
    //   597: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   600: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   603: checkcast com/amap/api/services/poisearch/PoiResult
    //   606: astore #6
    //   608: aload #6
    //   610: ifnonnull -> 765
    //   613: new com/amap/api/col/s/y
    //   616: dup
    //   617: aload_0
    //   618: getfield c : Landroid/content/Context;
    //   621: new com/amap/api/col/s/ab
    //   624: dup
    //   625: aload_0
    //   626: getfield b : Lcom/amap/api/services/poisearch/PoiSearch$Query;
    //   629: invokevirtual clone : ()Lcom/amap/api/services/poisearch/PoiSearch$Query;
    //   632: aload #5
    //   634: invokespecial <init> : (Lcom/amap/api/services/poisearch/PoiSearch$Query;Lcom/amap/api/services/poisearch/PoiSearch$SearchBound;)V
    //   637: invokespecial <init> : (Landroid/content/Context;Lcom/amap/api/col/s/ab;)V
    //   640: invokevirtual n_ : ()Ljava/lang/Object;
    //   643: checkcast com/amap/api/services/poisearch/PoiResult
    //   646: astore #5
    //   648: getstatic com/amap/api/col/s/bc.i : Ljava/util/HashMap;
    //   651: aload_0
    //   652: getfield b : Lcom/amap/api/services/poisearch/PoiSearch$Query;
    //   655: invokevirtual getPageNum : ()I
    //   658: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   661: aload #5
    //   663: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   666: pop
    //   667: aload #5
    //   669: areturn
    //   670: new java/lang/IllegalArgumentException
    //   673: dup
    //   674: ldc 'page out of range'
    //   676: invokespecial <init> : (Ljava/lang/String;)V
    //   679: athrow
    //   680: new com/amap/api/services/core/AMapException
    //   683: dup
    //   684: ldc '无效的参数 - IllegalArgumentException'
    //   686: invokespecial <init> : (Ljava/lang/String;)V
    //   689: athrow
    //   690: new com/amap/api/services/core/AMapException
    //   693: dup
    //   694: ldc '无效的参数 - IllegalArgumentException'
    //   696: invokespecial <init> : (Ljava/lang/String;)V
    //   699: athrow
    //   700: astore #5
    //   702: aload #5
    //   704: ldc 'PoiSearch'
    //   706: ldc 'searchPOI'
    //   708: invokestatic a : (Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   711: new com/amap/api/services/core/AMapException
    //   714: dup
    //   715: aload #5
    //   717: invokevirtual getErrorMessage : ()Ljava/lang/String;
    //   720: invokespecial <init> : (Ljava/lang/String;)V
    //   723: athrow
    //   724: iconst_1
    //   725: istore_1
    //   726: goto -> 731
    //   729: iconst_0
    //   730: istore_1
    //   731: iload_1
    //   732: ifeq -> 85
    //   735: goto -> 95
    //   738: iconst_0
    //   739: istore_1
    //   740: goto -> 264
    //   743: iconst_0
    //   744: istore_1
    //   745: goto -> 168
    //   748: iload_1
    //   749: iconst_1
    //   750: iadd
    //   751: istore_1
    //   752: goto -> 168
    //   755: iconst_1
    //   756: istore_1
    //   757: goto -> 264
    //   760: iconst_0
    //   761: istore_1
    //   762: goto -> 589
    //   765: aload #6
    //   767: astore #5
    //   769: aload #5
    //   771: areturn
    // Exception table:
    //   from	to	target	type
    //   0	14	700	com/amap/api/services/core/AMapException
    //   21	33	700	com/amap/api/services/core/AMapException
    //   49	82	700	com/amap/api/services/core/AMapException
    //   85	95	700	com/amap/api/services/core/AMapException
    //   95	101	700	com/amap/api/services/core/AMapException
    //   106	127	700	com/amap/api/services/core/AMapException
    //   130	150	700	com/amap/api/services/core/AMapException
    //   155	165	700	com/amap/api/services/core/AMapException
    //   168	190	700	com/amap/api/services/core/AMapException
    //   193	220	700	com/amap/api/services/core/AMapException
    //   233	261	700	com/amap/api/services/core/AMapException
    //   268	296	700	com/amap/api/services/core/AMapException
    //   296	324	700	com/amap/api/services/core/AMapException
    //   324	358	700	com/amap/api/services/core/AMapException
    //   358	370	700	com/amap/api/services/core/AMapException
    //   373	389	700	com/amap/api/services/core/AMapException
    //   389	494	700	com/amap/api/services/core/AMapException
    //   498	505	700	com/amap/api/services/core/AMapException
    //   517	524	700	com/amap/api/services/core/AMapException
    //   528	561	700	com/amap/api/services/core/AMapException
    //   564	580	700	com/amap/api/services/core/AMapException
    //   593	608	700	com/amap/api/services/core/AMapException
    //   613	667	700	com/amap/api/services/core/AMapException
    //   670	680	700	com/amap/api/services/core/AMapException
    //   680	690	700	com/amap/api/services/core/AMapException
    //   690	700	700	com/amap/api/services/core/AMapException
  }
  
  public final void searchPOIAsyn() {
    try {
      return;
    } finally {
      Exception exception = null;
      exception.printStackTrace();
    } 
  }
  
  public final PoiItem searchPOIId(String paramString) throws AMapException {
    q.a(this.c);
    PoiSearch.Query query = this.b;
    if (query != null) {
      query = query.clone();
    } else {
      query = null;
    } 
    return (new x(this.c, paramString, query)).n_();
  }
  
  public final void searchPOIIdAsyn(String paramString) {
    an.a().a(new Runnable(this, paramString) {
          public final void run() {
            Message message = s.a().obtainMessage();
            message.arg1 = 6;
            message.what = 602;
            Bundle bundle = new Bundle();
            PoiItem poiItem1 = null;
            PoiItem poiItem2 = null;
            try {
              PoiItem poiItem = this.b.searchPOIId(this.a);
              poiItem2 = poiItem;
              poiItem1 = poiItem;
              bundle.putInt("errorCode", 1000);
              s.g g = new s.g();
              poiItem1 = poiItem;
            } catch (AMapException aMapException) {
              poiItem2 = poiItem1;
            } finally {}
            ((s.g)poiItem2).b = bc.b(this.b);
            ((s.g)poiItem2).a = poiItem1;
            message.obj = poiItem2;
            message.setData(bundle);
            bc.a(this.b).sendMessage(message);
          }
        });
  }
  
  public final void setBound(PoiSearch.SearchBound paramSearchBound) {
    this.a = paramSearchBound;
  }
  
  public final void setLanguage(String paramString) {
    if ("en".equals(paramString)) {
      this.e = "en";
      return;
    } 
    this.e = "zh-CN";
  }
  
  public final void setOnPoiSearchListener(PoiSearch.OnPoiSearchListener paramOnPoiSearchListener) {
    this.d = paramOnPoiSearchListener;
  }
  
  public final void setQuery(PoiSearch.Query paramQuery) {
    this.b = paramQuery;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\col\s\bc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */