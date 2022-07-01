package com.alibaba.fastjson.serializer;

import java.io.IOException;
import java.lang.reflect.Type;

public class MapSerializer implements ObjectSerializer {
  public static MapSerializer instance = new MapSerializer();
  
  public void write(JSONSerializer paramJSONSerializer, Object paramObject1, Object paramObject2, Type paramType, int paramInt) throws IOException {
    // Byte code:
    //   0: aload_1
    //   1: getfield out : Lcom/alibaba/fastjson/serializer/SerializeWriter;
    //   4: astore #10
    //   6: aload_2
    //   7: ifnonnull -> 16
    //   10: aload #10
    //   12: invokevirtual writeNull : ()V
    //   15: return
    //   16: aload_2
    //   17: checkcast java/util/Map
    //   20: astore #11
    //   22: aload_1
    //   23: aload_2
    //   24: invokevirtual containsReference : (Ljava/lang/Object;)Z
    //   27: ifeq -> 36
    //   30: aload_1
    //   31: aload_2
    //   32: invokevirtual writeReference : (Ljava/lang/Object;)V
    //   35: return
    //   36: aload_1
    //   37: getfield context : Lcom/alibaba/fastjson/serializer/SerialContext;
    //   40: astore #9
    //   42: aload_1
    //   43: aload #9
    //   45: aload_2
    //   46: aload_3
    //   47: iconst_0
    //   48: invokevirtual setContext : (Lcom/alibaba/fastjson/serializer/SerialContext;Ljava/lang/Object;Ljava/lang/Object;I)V
    //   51: aload #10
    //   53: bipush #123
    //   55: invokevirtual write : (I)V
    //   58: aload_1
    //   59: invokevirtual incrementIndent : ()V
    //   62: aload #10
    //   64: getstatic com/alibaba/fastjson/serializer/SerializerFeature.WriteClassName : Lcom/alibaba/fastjson/serializer/SerializerFeature;
    //   67: invokevirtual isEnabled : (Lcom/alibaba/fastjson/serializer/SerializerFeature;)Z
    //   70: ifeq -> 871
    //   73: aload #11
    //   75: invokevirtual getClass : ()Ljava/lang/Class;
    //   78: astore_3
    //   79: aload_3
    //   80: ldc com/alibaba/fastjson/JSONObject
    //   82: if_acmpeq -> 97
    //   85: aload_3
    //   86: ldc java/util/HashMap
    //   88: if_acmpeq -> 97
    //   91: aload_3
    //   92: ldc java/util/LinkedHashMap
    //   94: if_acmpne -> 865
    //   97: aload #11
    //   99: getstatic com/alibaba/fastjson/JSON.DEFAULT_TYPE_KEY : Ljava/lang/String;
    //   102: invokeinterface containsKey : (Ljava/lang/Object;)Z
    //   107: ifeq -> 865
    //   110: iconst_1
    //   111: istore #5
    //   113: goto -> 116
    //   116: iload #5
    //   118: ifne -> 871
    //   121: aload #10
    //   123: getstatic com/alibaba/fastjson/JSON.DEFAULT_TYPE_KEY : Ljava/lang/String;
    //   126: invokevirtual writeFieldName : (Ljava/lang/String;)V
    //   129: aload #10
    //   131: aload_2
    //   132: invokevirtual getClass : ()Ljava/lang/Class;
    //   135: invokevirtual getName : ()Ljava/lang/String;
    //   138: invokevirtual writeString : (Ljava/lang/String;)V
    //   141: iconst_0
    //   142: istore #5
    //   144: goto -> 147
    //   147: aload #11
    //   149: invokeinterface entrySet : ()Ljava/util/Set;
    //   154: invokeinterface iterator : ()Ljava/util/Iterator;
    //   159: astore #12
    //   161: aconst_null
    //   162: astore #7
    //   164: aload #7
    //   166: astore #6
    //   168: aload #12
    //   170: invokeinterface hasNext : ()Z
    //   175: ifeq -> 813
    //   178: aload #12
    //   180: invokeinterface next : ()Ljava/lang/Object;
    //   185: checkcast java/util/Map$Entry
    //   188: astore_3
    //   189: aload_3
    //   190: invokeinterface getValue : ()Ljava/lang/Object;
    //   195: astore #8
    //   197: aload_3
    //   198: invokeinterface getKey : ()Ljava/lang/Object;
    //   203: astore #4
    //   205: aload_1
    //   206: getfield propertyPreFilters : Ljava/util/List;
    //   209: astore_3
    //   210: aload_3
    //   211: ifnull -> 290
    //   214: aload_3
    //   215: invokeinterface size : ()I
    //   220: ifle -> 290
    //   223: aload #4
    //   225: ifnull -> 274
    //   228: aload #4
    //   230: instanceof java/lang/String
    //   233: ifeq -> 239
    //   236: goto -> 274
    //   239: aload #4
    //   241: invokevirtual getClass : ()Ljava/lang/Class;
    //   244: invokevirtual isPrimitive : ()Z
    //   247: ifne -> 258
    //   250: aload #4
    //   252: instanceof java/lang/Number
    //   255: ifeq -> 290
    //   258: aload_1
    //   259: aload_2
    //   260: aload #4
    //   262: invokestatic toJSONString : (Ljava/lang/Object;)Ljava/lang/String;
    //   265: invokevirtual applyName : (Ljava/lang/Object;Ljava/lang/String;)Z
    //   268: ifne -> 290
    //   271: goto -> 168
    //   274: aload_1
    //   275: aload_2
    //   276: aload #4
    //   278: checkcast java/lang/String
    //   281: invokevirtual applyName : (Ljava/lang/Object;Ljava/lang/String;)Z
    //   284: ifne -> 290
    //   287: goto -> 168
    //   290: aload_1
    //   291: getfield propertyFilters : Ljava/util/List;
    //   294: astore_3
    //   295: aload_3
    //   296: ifnull -> 379
    //   299: aload_3
    //   300: invokeinterface size : ()I
    //   305: ifle -> 379
    //   308: aload #4
    //   310: ifnull -> 361
    //   313: aload #4
    //   315: instanceof java/lang/String
    //   318: ifeq -> 324
    //   321: goto -> 361
    //   324: aload #4
    //   326: invokevirtual getClass : ()Ljava/lang/Class;
    //   329: invokevirtual isPrimitive : ()Z
    //   332: ifne -> 343
    //   335: aload #4
    //   337: instanceof java/lang/Number
    //   340: ifeq -> 379
    //   343: aload_1
    //   344: aload_2
    //   345: aload #4
    //   347: invokestatic toJSONString : (Ljava/lang/Object;)Ljava/lang/String;
    //   350: aload #8
    //   352: invokevirtual apply : (Ljava/lang/Object;Ljava/lang/String;Ljava/lang/Object;)Z
    //   355: ifne -> 379
    //   358: goto -> 168
    //   361: aload_1
    //   362: aload_2
    //   363: aload #4
    //   365: checkcast java/lang/String
    //   368: aload #8
    //   370: invokevirtual apply : (Ljava/lang/Object;Ljava/lang/String;Ljava/lang/Object;)Z
    //   373: ifne -> 379
    //   376: goto -> 168
    //   379: aload_1
    //   380: getfield nameFilters : Ljava/util/List;
    //   383: astore #13
    //   385: aload #4
    //   387: astore_3
    //   388: aload #13
    //   390: ifnull -> 473
    //   393: aload #4
    //   395: astore_3
    //   396: aload #13
    //   398: invokeinterface size : ()I
    //   403: ifle -> 473
    //   406: aload #4
    //   408: ifnull -> 460
    //   411: aload #4
    //   413: instanceof java/lang/String
    //   416: ifeq -> 422
    //   419: goto -> 460
    //   422: aload #4
    //   424: invokevirtual getClass : ()Ljava/lang/Class;
    //   427: invokevirtual isPrimitive : ()Z
    //   430: ifne -> 444
    //   433: aload #4
    //   435: astore_3
    //   436: aload #4
    //   438: instanceof java/lang/Number
    //   441: ifeq -> 473
    //   444: aload_1
    //   445: aload_2
    //   446: aload #4
    //   448: invokestatic toJSONString : (Ljava/lang/Object;)Ljava/lang/String;
    //   451: aload #8
    //   453: invokevirtual processKey : (Ljava/lang/Object;Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/String;
    //   456: astore_3
    //   457: goto -> 473
    //   460: aload_1
    //   461: aload_2
    //   462: aload #4
    //   464: checkcast java/lang/String
    //   467: aload #8
    //   469: invokevirtual processKey : (Ljava/lang/Object;Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/String;
    //   472: astore_3
    //   473: aload_1
    //   474: getfield valueFilters : Ljava/util/List;
    //   477: astore #4
    //   479: aload_1
    //   480: getfield contextValueFilters : Ljava/util/List;
    //   483: astore #13
    //   485: aload #4
    //   487: ifnull -> 500
    //   490: aload #4
    //   492: invokeinterface size : ()I
    //   497: ifgt -> 523
    //   500: aload #8
    //   502: astore #4
    //   504: aload #13
    //   506: ifnull -> 592
    //   509: aload #8
    //   511: astore #4
    //   513: aload #13
    //   515: invokeinterface size : ()I
    //   520: ifle -> 592
    //   523: aload_3
    //   524: ifnull -> 575
    //   527: aload_3
    //   528: instanceof java/lang/String
    //   531: ifeq -> 537
    //   534: goto -> 575
    //   537: aload_3
    //   538: invokevirtual getClass : ()Ljava/lang/Class;
    //   541: invokevirtual isPrimitive : ()Z
    //   544: ifne -> 558
    //   547: aload #8
    //   549: astore #4
    //   551: aload_3
    //   552: instanceof java/lang/Number
    //   555: ifeq -> 592
    //   558: aload_1
    //   559: aconst_null
    //   560: aload_2
    //   561: aload_3
    //   562: invokestatic toJSONString : (Ljava/lang/Object;)Ljava/lang/String;
    //   565: aload #8
    //   567: invokevirtual processValue : (Lcom/alibaba/fastjson/serializer/JavaBeanSerializer;Ljava/lang/Object;Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
    //   570: astore #4
    //   572: goto -> 877
    //   575: aload_1
    //   576: aconst_null
    //   577: aload_2
    //   578: aload_3
    //   579: checkcast java/lang/String
    //   582: aload #8
    //   584: invokevirtual processValue : (Lcom/alibaba/fastjson/serializer/JavaBeanSerializer;Ljava/lang/Object;Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
    //   587: astore #4
    //   589: goto -> 877
    //   592: aload #4
    //   594: ifnonnull -> 611
    //   597: aload #10
    //   599: getstatic com/alibaba/fastjson/serializer/SerializerFeature.WriteMapNullValue : Lcom/alibaba/fastjson/serializer/SerializerFeature;
    //   602: invokevirtual isEnabled : (Lcom/alibaba/fastjson/serializer/SerializerFeature;)Z
    //   605: ifne -> 611
    //   608: goto -> 168
    //   611: aload_3
    //   612: instanceof java/lang/String
    //   615: ifeq -> 662
    //   618: aload_3
    //   619: checkcast java/lang/String
    //   622: astore #8
    //   624: iload #5
    //   626: ifne -> 636
    //   629: aload #10
    //   631: bipush #44
    //   633: invokevirtual write : (I)V
    //   636: aload #10
    //   638: getstatic com/alibaba/fastjson/serializer/SerializerFeature.PrettyFormat : Lcom/alibaba/fastjson/serializer/SerializerFeature;
    //   641: invokevirtual isEnabled : (Lcom/alibaba/fastjson/serializer/SerializerFeature;)Z
    //   644: ifeq -> 651
    //   647: aload_1
    //   648: invokevirtual println : ()V
    //   651: aload #10
    //   653: aload #8
    //   655: iconst_1
    //   656: invokevirtual writeFieldName : (Ljava/lang/String;Z)V
    //   659: goto -> 733
    //   662: iload #5
    //   664: ifne -> 674
    //   667: aload #10
    //   669: bipush #44
    //   671: invokevirtual write : (I)V
    //   674: aload #10
    //   676: getstatic com/alibaba/fastjson/serializer/SerializerFeature.BrowserCompatible : Lcom/alibaba/fastjson/serializer/SerializerFeature;
    //   679: invokevirtual isEnabled : (Lcom/alibaba/fastjson/serializer/SerializerFeature;)Z
    //   682: ifne -> 718
    //   685: aload #10
    //   687: getstatic com/alibaba/fastjson/serializer/SerializerFeature.WriteNonStringKeyAsString : Lcom/alibaba/fastjson/serializer/SerializerFeature;
    //   690: invokevirtual isEnabled : (Lcom/alibaba/fastjson/serializer/SerializerFeature;)Z
    //   693: ifne -> 718
    //   696: aload #10
    //   698: getstatic com/alibaba/fastjson/serializer/SerializerFeature.BrowserSecure : Lcom/alibaba/fastjson/serializer/SerializerFeature;
    //   701: invokevirtual isEnabled : (Lcom/alibaba/fastjson/serializer/SerializerFeature;)Z
    //   704: ifeq -> 710
    //   707: goto -> 718
    //   710: aload_1
    //   711: aload_3
    //   712: invokevirtual write : (Ljava/lang/Object;)V
    //   715: goto -> 726
    //   718: aload_1
    //   719: aload_3
    //   720: invokestatic toJSONString : (Ljava/lang/Object;)Ljava/lang/String;
    //   723: invokevirtual write : (Ljava/lang/String;)V
    //   726: aload #10
    //   728: bipush #58
    //   730: invokevirtual write : (I)V
    //   733: aload #4
    //   735: ifnonnull -> 749
    //   738: aload #10
    //   740: invokevirtual writeNull : ()V
    //   743: aload #6
    //   745: astore_3
    //   746: goto -> 880
    //   749: aload #4
    //   751: invokevirtual getClass : ()Ljava/lang/Class;
    //   754: astore #8
    //   756: aload #8
    //   758: aload #7
    //   760: if_acmpne -> 782
    //   763: aload #6
    //   765: aload_1
    //   766: aload #4
    //   768: aload_3
    //   769: aconst_null
    //   770: iconst_0
    //   771: invokeinterface write : (Lcom/alibaba/fastjson/serializer/JSONSerializer;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/reflect/Type;I)V
    //   776: aload #6
    //   778: astore_3
    //   779: goto -> 880
    //   782: aload_1
    //   783: aload #8
    //   785: invokevirtual getObjectWriter : (Ljava/lang/Class;)Lcom/alibaba/fastjson/serializer/ObjectSerializer;
    //   788: astore #6
    //   790: aload #6
    //   792: aload_1
    //   793: aload #4
    //   795: aload_3
    //   796: aconst_null
    //   797: iconst_0
    //   798: invokeinterface write : (Lcom/alibaba/fastjson/serializer/JSONSerializer;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/reflect/Type;I)V
    //   803: aload #6
    //   805: astore_3
    //   806: aload #8
    //   808: astore #7
    //   810: goto -> 880
    //   813: aload_1
    //   814: aload #9
    //   816: putfield context : Lcom/alibaba/fastjson/serializer/SerialContext;
    //   819: aload_1
    //   820: invokevirtual decrementIdent : ()V
    //   823: aload #10
    //   825: getstatic com/alibaba/fastjson/serializer/SerializerFeature.PrettyFormat : Lcom/alibaba/fastjson/serializer/SerializerFeature;
    //   828: invokevirtual isEnabled : (Lcom/alibaba/fastjson/serializer/SerializerFeature;)Z
    //   831: ifeq -> 848
    //   834: aload #11
    //   836: invokeinterface size : ()I
    //   841: ifle -> 848
    //   844: aload_1
    //   845: invokevirtual println : ()V
    //   848: aload #10
    //   850: bipush #125
    //   852: invokevirtual write : (I)V
    //   855: return
    //   856: astore_2
    //   857: aload_1
    //   858: aload #9
    //   860: putfield context : Lcom/alibaba/fastjson/serializer/SerialContext;
    //   863: aload_2
    //   864: athrow
    //   865: iconst_0
    //   866: istore #5
    //   868: goto -> 116
    //   871: iconst_1
    //   872: istore #5
    //   874: goto -> 147
    //   877: goto -> 592
    //   880: iconst_0
    //   881: istore #5
    //   883: aload_3
    //   884: astore #6
    //   886: goto -> 168
    // Exception table:
    //   from	to	target	type
    //   51	79	856	finally
    //   97	110	856	finally
    //   121	141	856	finally
    //   147	161	856	finally
    //   168	210	856	finally
    //   214	223	856	finally
    //   228	236	856	finally
    //   239	258	856	finally
    //   258	271	856	finally
    //   274	287	856	finally
    //   290	295	856	finally
    //   299	308	856	finally
    //   313	321	856	finally
    //   324	343	856	finally
    //   343	358	856	finally
    //   361	376	856	finally
    //   379	385	856	finally
    //   396	406	856	finally
    //   411	419	856	finally
    //   422	433	856	finally
    //   436	444	856	finally
    //   444	457	856	finally
    //   460	473	856	finally
    //   473	485	856	finally
    //   490	500	856	finally
    //   513	523	856	finally
    //   527	534	856	finally
    //   537	547	856	finally
    //   551	558	856	finally
    //   558	572	856	finally
    //   575	589	856	finally
    //   597	608	856	finally
    //   611	624	856	finally
    //   629	636	856	finally
    //   636	651	856	finally
    //   651	659	856	finally
    //   667	674	856	finally
    //   674	707	856	finally
    //   710	715	856	finally
    //   718	726	856	finally
    //   726	733	856	finally
    //   738	743	856	finally
    //   749	756	856	finally
    //   763	776	856	finally
    //   782	803	856	finally
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\alibaba\fastjson\serializer\MapSerializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */