package com.amap.api.col.s;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import com.amap.api.services.cloud.CloudItemDetail;
import com.amap.api.services.cloud.CloudResult;
import com.amap.api.services.cloud.CloudSearch;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.interfaces.ICloudSearch;
import java.util.HashMap;

public final class aw implements ICloudSearch {
  private Context a;
  
  private CloudSearch.OnCloudSearchListener b;
  
  private CloudSearch.Query c;
  
  private int d;
  
  private HashMap<Integer, CloudResult> e;
  
  private Handler f;
  
  public aw(Context paramContext) {
    this.a = paramContext.getApplicationContext();
    this.f = s.a();
  }
  
  private CloudItemDetail a(String paramString1, String paramString2) throws AMapException {
    if (paramString1 != null && !paramString1.trim().equals("")) {
      if (paramString2 != null && !paramString2.trim().equals(""))
        try {
          return (new f(this.a, aa)).n_();
        } finally {
          paramString1 = null;
          i.a((Throwable)paramString1, "CloudSearch", "searchCloudDetail");
          if (!(paramString1 instanceof AMapException)) {
            paramString1.printStackTrace();
            return null;
          } 
        }  
      throw new AMapException("无效的参数 - IllegalArgumentException");
    } 
    throw new AMapException("无效的参数 - IllegalArgumentException");
  }
  
  private CloudResult a(CloudSearch.Query paramQuery) throws AMapException {
    // Byte code:
    //   0: iconst_1
    //   1: istore_3
    //   2: aconst_null
    //   3: astore #6
    //   5: aload_1
    //   6: ifnonnull -> 14
    //   9: iconst_0
    //   10: istore_2
    //   11: goto -> 275
    //   14: aload #6
    //   16: astore #5
    //   18: aload_1
    //   19: invokevirtual getTableID : ()Ljava/lang/String;
    //   22: invokestatic a : (Ljava/lang/String;)Z
    //   25: ifne -> 9
    //   28: aload #6
    //   30: astore #5
    //   32: aload_1
    //   33: invokevirtual getBound : ()Lcom/amap/api/services/cloud/CloudSearch$SearchBound;
    //   36: ifnonnull -> 42
    //   39: goto -> 9
    //   42: aload #6
    //   44: astore #5
    //   46: aload_1
    //   47: invokevirtual getBound : ()Lcom/amap/api/services/cloud/CloudSearch$SearchBound;
    //   50: ifnull -> 89
    //   53: aload #6
    //   55: astore #5
    //   57: aload_1
    //   58: invokevirtual getBound : ()Lcom/amap/api/services/cloud/CloudSearch$SearchBound;
    //   61: invokevirtual getShape : ()Ljava/lang/String;
    //   64: ldc 'Bound'
    //   66: invokevirtual equals : (Ljava/lang/Object;)Z
    //   69: ifeq -> 89
    //   72: aload #6
    //   74: astore #5
    //   76: aload_1
    //   77: invokevirtual getBound : ()Lcom/amap/api/services/cloud/CloudSearch$SearchBound;
    //   80: invokevirtual getCenter : ()Lcom/amap/api/services/core/LatLonPoint;
    //   83: ifnonnull -> 89
    //   86: goto -> 9
    //   89: aload #6
    //   91: astore #5
    //   93: aload_1
    //   94: invokevirtual getBound : ()Lcom/amap/api/services/cloud/CloudSearch$SearchBound;
    //   97: ifnull -> 197
    //   100: aload #6
    //   102: astore #5
    //   104: aload_1
    //   105: invokevirtual getBound : ()Lcom/amap/api/services/cloud/CloudSearch$SearchBound;
    //   108: invokevirtual getShape : ()Ljava/lang/String;
    //   111: ldc 'Rectangle'
    //   113: invokevirtual equals : (Ljava/lang/Object;)Z
    //   116: ifeq -> 197
    //   119: aload #6
    //   121: astore #5
    //   123: aload_1
    //   124: invokevirtual getBound : ()Lcom/amap/api/services/cloud/CloudSearch$SearchBound;
    //   127: invokevirtual getLowerLeft : ()Lcom/amap/api/services/core/LatLonPoint;
    //   130: astore #7
    //   132: aload #6
    //   134: astore #5
    //   136: aload_1
    //   137: invokevirtual getBound : ()Lcom/amap/api/services/cloud/CloudSearch$SearchBound;
    //   140: invokevirtual getUpperRight : ()Lcom/amap/api/services/core/LatLonPoint;
    //   143: astore #8
    //   145: aload #7
    //   147: ifnull -> 9
    //   150: aload #8
    //   152: ifnonnull -> 158
    //   155: goto -> 9
    //   158: aload #6
    //   160: astore #5
    //   162: aload #7
    //   164: invokevirtual getLatitude : ()D
    //   167: aload #8
    //   169: invokevirtual getLatitude : ()D
    //   172: dcmpl
    //   173: ifge -> 9
    //   176: aload #6
    //   178: astore #5
    //   180: aload #7
    //   182: invokevirtual getLongitude : ()D
    //   185: aload #8
    //   187: invokevirtual getLongitude : ()D
    //   190: dcmpl
    //   191: iflt -> 197
    //   194: goto -> 9
    //   197: aload #6
    //   199: astore #5
    //   201: aload_1
    //   202: invokevirtual getBound : ()Lcom/amap/api/services/cloud/CloudSearch$SearchBound;
    //   205: ifnull -> 612
    //   208: aload #6
    //   210: astore #5
    //   212: aload_1
    //   213: invokevirtual getBound : ()Lcom/amap/api/services/cloud/CloudSearch$SearchBound;
    //   216: invokevirtual getShape : ()Ljava/lang/String;
    //   219: ldc 'Polygon'
    //   221: invokevirtual equals : (Ljava/lang/Object;)Z
    //   224: ifeq -> 612
    //   227: aload #6
    //   229: astore #5
    //   231: aload_1
    //   232: invokevirtual getBound : ()Lcom/amap/api/services/cloud/CloudSearch$SearchBound;
    //   235: invokevirtual getPolyGonList : ()Ljava/util/List;
    //   238: astore #7
    //   240: iconst_0
    //   241: istore_2
    //   242: aload #6
    //   244: astore #5
    //   246: iload_2
    //   247: aload #7
    //   249: invokeinterface size : ()I
    //   254: if_icmpge -> 612
    //   257: aload #6
    //   259: astore #5
    //   261: aload #7
    //   263: iload_2
    //   264: invokeinterface get : (I)Ljava/lang/Object;
    //   269: ifnonnull -> 605
    //   272: goto -> 9
    //   275: iload_2
    //   276: ifeq -> 559
    //   279: aload #6
    //   281: astore #5
    //   283: aload_1
    //   284: aload_0
    //   285: getfield c : Lcom/amap/api/services/cloud/CloudSearch$Query;
    //   288: invokevirtual queryEquals : (Lcom/amap/api/services/cloud/CloudSearch$Query;)Z
    //   291: ifne -> 337
    //   294: aload #6
    //   296: astore #5
    //   298: aload_0
    //   299: iconst_0
    //   300: putfield d : I
    //   303: aload #6
    //   305: astore #5
    //   307: aload_0
    //   308: aload_1
    //   309: invokevirtual clone : ()Lcom/amap/api/services/cloud/CloudSearch$Query;
    //   312: putfield c : Lcom/amap/api/services/cloud/CloudSearch$Query;
    //   315: aload #6
    //   317: astore #5
    //   319: aload_0
    //   320: getfield e : Ljava/util/HashMap;
    //   323: ifnull -> 337
    //   326: aload #6
    //   328: astore #5
    //   330: aload_0
    //   331: getfield e : Ljava/util/HashMap;
    //   334: invokevirtual clear : ()V
    //   337: aload #6
    //   339: astore #5
    //   341: aload_0
    //   342: getfield d : I
    //   345: ifne -> 430
    //   348: aload #6
    //   350: astore #5
    //   352: new com/amap/api/col/s/g
    //   355: dup
    //   356: aload_0
    //   357: getfield a : Landroid/content/Context;
    //   360: aload_1
    //   361: invokespecial <init> : (Landroid/content/Context;Lcom/amap/api/services/cloud/CloudSearch$Query;)V
    //   364: invokevirtual n_ : ()Ljava/lang/Object;
    //   367: checkcast com/amap/api/services/cloud/CloudResult
    //   370: astore #7
    //   372: aload #7
    //   374: astore #5
    //   376: aload_0
    //   377: new java/util/HashMap
    //   380: dup
    //   381: invokespecial <init> : ()V
    //   384: putfield e : Ljava/util/HashMap;
    //   387: aload #7
    //   389: astore #5
    //   391: aload #7
    //   393: astore #6
    //   395: aload_0
    //   396: getfield d : I
    //   399: ifle -> 597
    //   402: aload #7
    //   404: astore #5
    //   406: aload_0
    //   407: getfield e : Ljava/util/HashMap;
    //   410: aload_1
    //   411: invokevirtual getPageNum : ()I
    //   414: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   417: aload #7
    //   419: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   422: pop
    //   423: aload #7
    //   425: areturn
    //   426: astore_1
    //   427: goto -> 574
    //   430: aload #6
    //   432: astore #5
    //   434: aload_1
    //   435: invokevirtual getPageNum : ()I
    //   438: istore #4
    //   440: aload #6
    //   442: astore #5
    //   444: iload #4
    //   446: aload_0
    //   447: getfield d : I
    //   450: if_icmpgt -> 617
    //   453: iload #4
    //   455: ifle -> 617
    //   458: iload_3
    //   459: istore_2
    //   460: goto -> 463
    //   463: iload_2
    //   464: ifeq -> 545
    //   467: aload #6
    //   469: astore #5
    //   471: aload_0
    //   472: getfield e : Ljava/util/HashMap;
    //   475: iload #4
    //   477: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   480: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   483: checkcast com/amap/api/services/cloud/CloudResult
    //   486: astore #7
    //   488: aload #7
    //   490: astore #6
    //   492: aload #7
    //   494: ifnonnull -> 597
    //   497: aload #7
    //   499: astore #5
    //   501: new com/amap/api/col/s/g
    //   504: dup
    //   505: aload_0
    //   506: getfield a : Landroid/content/Context;
    //   509: aload_1
    //   510: invokespecial <init> : (Landroid/content/Context;Lcom/amap/api/services/cloud/CloudSearch$Query;)V
    //   513: invokevirtual n_ : ()Ljava/lang/Object;
    //   516: checkcast com/amap/api/services/cloud/CloudResult
    //   519: astore #6
    //   521: aload #6
    //   523: astore #5
    //   525: aload_0
    //   526: getfield e : Ljava/util/HashMap;
    //   529: aload_1
    //   530: invokevirtual getPageNum : ()I
    //   533: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   536: aload #6
    //   538: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   541: pop
    //   542: aload #6
    //   544: areturn
    //   545: aload #6
    //   547: astore #5
    //   549: new java/lang/IllegalArgumentException
    //   552: dup
    //   553: ldc 'page out of range'
    //   555: invokespecial <init> : (Ljava/lang/String;)V
    //   558: athrow
    //   559: aload #6
    //   561: astore #5
    //   563: new com/amap/api/services/core/AMapException
    //   566: dup
    //   567: ldc '无效的参数 - IllegalArgumentException'
    //   569: invokespecial <init> : (Ljava/lang/String;)V
    //   572: athrow
    //   573: astore_1
    //   574: aload_1
    //   575: ldc 'CloudSearch'
    //   577: ldc 'searchCloud'
    //   579: invokestatic a : (Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   582: aload_1
    //   583: instanceof com/amap/api/services/core/AMapException
    //   586: ifne -> 600
    //   589: aload_1
    //   590: invokevirtual printStackTrace : ()V
    //   593: aload #5
    //   595: astore #6
    //   597: aload #6
    //   599: areturn
    //   600: aload_1
    //   601: checkcast com/amap/api/services/core/AMapException
    //   604: athrow
    //   605: iload_2
    //   606: iconst_1
    //   607: iadd
    //   608: istore_2
    //   609: goto -> 242
    //   612: iconst_1
    //   613: istore_2
    //   614: goto -> 275
    //   617: iconst_0
    //   618: istore_2
    //   619: goto -> 463
    // Exception table:
    //   from	to	target	type
    //   18	28	573	finally
    //   32	39	573	finally
    //   46	53	573	finally
    //   57	72	573	finally
    //   76	86	573	finally
    //   93	100	573	finally
    //   104	119	573	finally
    //   123	132	573	finally
    //   136	145	573	finally
    //   162	176	573	finally
    //   180	194	573	finally
    //   201	208	573	finally
    //   212	227	573	finally
    //   231	240	573	finally
    //   246	257	573	finally
    //   261	272	573	finally
    //   283	294	573	finally
    //   298	303	573	finally
    //   307	315	573	finally
    //   319	326	573	finally
    //   330	337	573	finally
    //   341	348	573	finally
    //   352	372	573	finally
    //   376	387	426	finally
    //   395	402	426	finally
    //   406	423	426	finally
    //   434	440	573	finally
    //   444	453	573	finally
    //   471	488	573	finally
    //   501	521	426	finally
    //   525	542	573	finally
    //   549	559	573	finally
    //   563	573	573	finally
  }
  
  public final void searchCloudAsyn(CloudSearch.Query paramQuery) {
    try {
      return;
    } finally {
      paramQuery = null;
      paramQuery.printStackTrace();
    } 
  }
  
  public final void searchCloudDetailAsyn(String paramString1, String paramString2) {
    try {
      return;
    } finally {
      paramString1 = null;
      paramString1.printStackTrace();
    } 
  }
  
  public final void setOnCloudSearchListener(CloudSearch.OnCloudSearchListener paramOnCloudSearchListener) {
    this.b = paramOnCloudSearchListener;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\col\s\aw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */