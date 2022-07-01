package com.ss.android.socialbase.downloader.h;

import com.ss.android.socialbase.downloader.d.x;
import com.ss.android.socialbase.downloader.g.c;
import org.json.JSONObject;

public class a {
  private static JSONObject a(String paramString, c paramc, com.ss.android.socialbase.downloader.e.a parama, int paramInt) {
    // Byte code:
    //   0: new org/json/JSONObject
    //   3: dup
    //   4: invokespecial <init> : ()V
    //   7: astore #7
    //   9: invokestatic i : ()Lcom/ss/android/socialbase/downloader/downloader/q;
    //   12: astore #11
    //   14: ldc ''
    //   16: astore #10
    //   18: aload #11
    //   20: ifnull -> 713
    //   23: aload #11
    //   25: invokeinterface b : ()Ljava/lang/String;
    //   30: astore #8
    //   32: aload #8
    //   34: invokestatic isDigitsOnly : (Ljava/lang/CharSequence;)Z
    //   37: ifeq -> 706
    //   40: aload #8
    //   42: invokestatic valueOf : (Ljava/lang/String;)Ljava/lang/Long;
    //   45: invokevirtual longValue : ()J
    //   48: ldc2_w 100
    //   51: lrem
    //   52: invokestatic valueOf : (J)Ljava/lang/String;
    //   55: astore #6
    //   57: goto -> 70
    //   60: astore #6
    //   62: aload #6
    //   64: invokevirtual printStackTrace : ()V
    //   67: goto -> 706
    //   70: aload #11
    //   72: invokeinterface a : ()Ljava/lang/String;
    //   77: astore #9
    //   79: aload #11
    //   81: invokeinterface c : ()I
    //   86: istore #4
    //   88: goto -> 91
    //   91: aload #7
    //   93: ldc 'event_page'
    //   95: aload_0
    //   96: invokevirtual put : (Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   99: pop
    //   100: aload #7
    //   102: ldc 'app_id'
    //   104: aload #9
    //   106: invokevirtual put : (Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   109: pop
    //   110: aload #7
    //   112: ldc 'device_id'
    //   114: aload #8
    //   116: invokevirtual put : (Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   119: pop
    //   120: aload #7
    //   122: ldc 'device_id_postfix'
    //   124: aload #6
    //   126: invokevirtual put : (Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   129: pop
    //   130: aload #7
    //   132: ldc 'update_version'
    //   134: iload #4
    //   136: invokevirtual put : (Ljava/lang/String;I)Lorg/json/JSONObject;
    //   139: pop
    //   140: aload #7
    //   142: ldc 'download_status'
    //   144: iload_3
    //   145: invokevirtual put : (Ljava/lang/String;I)Lorg/json/JSONObject;
    //   148: pop
    //   149: aload_1
    //   150: ifnull -> 654
    //   153: aload #7
    //   155: ldc 'download_id'
    //   157: aload_1
    //   158: invokevirtual g : ()I
    //   161: invokevirtual put : (Ljava/lang/String;I)Lorg/json/JSONObject;
    //   164: pop
    //   165: aload #7
    //   167: ldc 'name'
    //   169: aload_1
    //   170: invokevirtual h : ()Ljava/lang/String;
    //   173: invokevirtual put : (Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   176: pop
    //   177: aload #7
    //   179: ldc 'url'
    //   181: aload_1
    //   182: invokevirtual j : ()Ljava/lang/String;
    //   185: invokevirtual put : (Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   188: pop
    //   189: aload #7
    //   191: ldc 'download_time'
    //   193: aload_1
    //   194: invokevirtual aw : ()J
    //   197: invokevirtual put : (Ljava/lang/String;J)Lorg/json/JSONObject;
    //   200: pop
    //   201: aload #7
    //   203: ldc 'cur_bytes'
    //   205: aload_1
    //   206: invokevirtual Z : ()J
    //   209: invokevirtual put : (Ljava/lang/String;J)Lorg/json/JSONObject;
    //   212: pop
    //   213: aload #7
    //   215: ldc 'total_bytes'
    //   217: aload_1
    //   218: invokevirtual ab : ()J
    //   221: invokevirtual put : (Ljava/lang/String;J)Lorg/json/JSONObject;
    //   224: pop
    //   225: aload #7
    //   227: ldc 'network_quality'
    //   229: aload_1
    //   230: invokevirtual ad : ()Ljava/lang/String;
    //   233: invokevirtual put : (Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   236: pop
    //   237: aload_1
    //   238: invokevirtual x : ()Z
    //   241: istore #5
    //   243: iconst_1
    //   244: istore #4
    //   246: iload #5
    //   248: ifeq -> 731
    //   251: iconst_1
    //   252: istore_3
    //   253: goto -> 256
    //   256: aload #7
    //   258: ldc 'only_wifi'
    //   260: iload_3
    //   261: invokevirtual put : (Ljava/lang/String;I)Lorg/json/JSONObject;
    //   264: pop
    //   265: aload_1
    //   266: invokevirtual ai : ()Z
    //   269: ifeq -> 736
    //   272: iconst_1
    //   273: istore_3
    //   274: goto -> 277
    //   277: aload #7
    //   279: ldc 'need_https_degrade'
    //   281: iload_3
    //   282: invokevirtual put : (Ljava/lang/String;I)Lorg/json/JSONObject;
    //   285: pop
    //   286: aload_1
    //   287: invokevirtual t : ()Z
    //   290: ifeq -> 741
    //   293: iconst_1
    //   294: istore_3
    //   295: goto -> 298
    //   298: aload #7
    //   300: ldc 'https_degrade_retry_used'
    //   302: iload_3
    //   303: invokevirtual put : (Ljava/lang/String;I)Lorg/json/JSONObject;
    //   306: pop
    //   307: aload #7
    //   309: ldc 'md5'
    //   311: aload_1
    //   312: invokevirtual A : ()Ljava/lang/String;
    //   315: invokevirtual put : (Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   318: pop
    //   319: aload #7
    //   321: ldc 'chunk_count'
    //   323: aload_1
    //   324: invokevirtual aV : ()I
    //   327: invokevirtual put : (Ljava/lang/String;I)Lorg/json/JSONObject;
    //   330: pop
    //   331: aload_1
    //   332: invokevirtual Y : ()Z
    //   335: ifeq -> 746
    //   338: iconst_1
    //   339: istore_3
    //   340: goto -> 343
    //   343: aload #7
    //   345: ldc 'is_force'
    //   347: iload_3
    //   348: invokevirtual put : (Ljava/lang/String;I)Lorg/json/JSONObject;
    //   351: pop
    //   352: aload #7
    //   354: ldc 'retry_count'
    //   356: aload_1
    //   357: invokevirtual D : ()I
    //   360: invokevirtual put : (Ljava/lang/String;I)Lorg/json/JSONObject;
    //   363: pop
    //   364: aload #7
    //   366: ldc 'cur_retry_time'
    //   368: aload_1
    //   369: invokevirtual al : ()I
    //   372: invokevirtual put : (Ljava/lang/String;I)Lorg/json/JSONObject;
    //   375: pop
    //   376: aload_1
    //   377: invokevirtual aj : ()Z
    //   380: ifeq -> 751
    //   383: iconst_1
    //   384: istore_3
    //   385: goto -> 388
    //   388: aload #7
    //   390: ldc 'need_retry_delay'
    //   392: iload_3
    //   393: invokevirtual put : (Ljava/lang/String;I)Lorg/json/JSONObject;
    //   396: pop
    //   397: aload_1
    //   398: invokevirtual S : ()Z
    //   401: ifeq -> 756
    //   404: iconst_1
    //   405: istore_3
    //   406: goto -> 409
    //   409: aload #7
    //   411: ldc 'need_reuse_first_connection'
    //   413: iload_3
    //   414: invokevirtual put : (Ljava/lang/String;I)Lorg/json/JSONObject;
    //   417: pop
    //   418: aload_1
    //   419: invokevirtual o : ()Z
    //   422: ifeq -> 761
    //   425: iconst_1
    //   426: istore_3
    //   427: goto -> 430
    //   430: aload #7
    //   432: ldc 'default_http_service_backup'
    //   434: iload_3
    //   435: invokevirtual put : (Ljava/lang/String;I)Lorg/json/JSONObject;
    //   438: pop
    //   439: aload #7
    //   441: ldc 'retry_delay_status'
    //   443: aload_1
    //   444: invokevirtual aq : ()Lcom/ss/android/socialbase/downloader/b/j;
    //   447: invokevirtual ordinal : ()I
    //   450: invokevirtual put : (Ljava/lang/String;I)Lorg/json/JSONObject;
    //   453: pop
    //   454: aload_1
    //   455: invokevirtual J : ()Z
    //   458: ifeq -> 766
    //   461: iconst_1
    //   462: istore_3
    //   463: goto -> 466
    //   466: aload #7
    //   468: ldc 'backup_url_used'
    //   470: iload_3
    //   471: invokevirtual put : (Ljava/lang/String;I)Lorg/json/JSONObject;
    //   474: pop
    //   475: aload #7
    //   477: ldc 'download_byte_error_retry_status'
    //   479: aload_1
    //   480: invokevirtual aa : ()Lcom/ss/android/socialbase/downloader/b/b;
    //   483: invokevirtual ordinal : ()I
    //   486: invokevirtual put : (Ljava/lang/String;I)Lorg/json/JSONObject;
    //   489: pop
    //   490: aload #7
    //   492: ldc 'forbidden_handler_status'
    //   494: aload_1
    //   495: invokevirtual ar : ()Lcom/ss/android/socialbase/downloader/b/a;
    //   498: invokevirtual ordinal : ()I
    //   501: invokevirtual put : (Ljava/lang/String;I)Lorg/json/JSONObject;
    //   504: pop
    //   505: aload_1
    //   506: invokevirtual T : ()Z
    //   509: ifeq -> 771
    //   512: iconst_1
    //   513: istore_3
    //   514: goto -> 517
    //   517: aload #7
    //   519: ldc 'need_independent_process'
    //   521: iload_3
    //   522: invokevirtual put : (Ljava/lang/String;I)Lorg/json/JSONObject;
    //   525: pop
    //   526: aload_1
    //   527: invokevirtual c : ()Ljava/lang/String;
    //   530: ifnull -> 776
    //   533: aload_1
    //   534: invokevirtual c : ()Ljava/lang/String;
    //   537: astore_0
    //   538: goto -> 541
    //   541: aload #7
    //   543: ldc 'head_connection_error_msg'
    //   545: aload_0
    //   546: invokevirtual put : (Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   549: pop
    //   550: aload #10
    //   552: astore_0
    //   553: aload_1
    //   554: invokevirtual y : ()Ljava/lang/String;
    //   557: ifnull -> 565
    //   560: aload_1
    //   561: invokevirtual y : ()Ljava/lang/String;
    //   564: astore_0
    //   565: aload #7
    //   567: ldc 'extra'
    //   569: aload_0
    //   570: invokevirtual put : (Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   573: pop
    //   574: aload_1
    //   575: invokevirtual X : ()Z
    //   578: ifeq -> 782
    //   581: iload #4
    //   583: istore_3
    //   584: goto -> 587
    //   587: aload #7
    //   589: ldc 'add_listener_to_same_task'
    //   591: iload_3
    //   592: invokevirtual put : (Ljava/lang/String;I)Lorg/json/JSONObject;
    //   595: pop
    //   596: aload_1
    //   597: invokevirtual aC : ()Ljava/util/List;
    //   600: ifnull -> 632
    //   603: aload #7
    //   605: ldc 'backup_url_count'
    //   607: aload_1
    //   608: invokevirtual aC : ()Ljava/util/List;
    //   611: invokeinterface size : ()I
    //   616: invokevirtual put : (Ljava/lang/String;I)Lorg/json/JSONObject;
    //   619: pop
    //   620: aload #7
    //   622: ldc 'cur_backup_url_index'
    //   624: aload_1
    //   625: invokevirtual s : ()I
    //   628: invokevirtual put : (Ljava/lang/String;I)Lorg/json/JSONObject;
    //   631: pop
    //   632: aload_1
    //   633: invokevirtual H : ()Ljava/util/List;
    //   636: ifnull -> 654
    //   639: aload #7
    //   641: ldc 'forbidden_urls'
    //   643: aload_1
    //   644: invokevirtual H : ()Ljava/util/List;
    //   647: invokevirtual toString : ()Ljava/lang/String;
    //   650: invokevirtual put : (Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   653: pop
    //   654: aload #7
    //   656: astore_0
    //   657: aload_2
    //   658: ifnull -> 704
    //   661: aload #7
    //   663: ldc_w 'error_code'
    //   666: aload_2
    //   667: invokevirtual a : ()I
    //   670: invokevirtual put : (Ljava/lang/String;I)Lorg/json/JSONObject;
    //   673: pop
    //   674: aload #7
    //   676: ldc_w 'error_msg'
    //   679: aload_2
    //   680: invokevirtual b : ()Ljava/lang/String;
    //   683: invokevirtual put : (Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   686: pop
    //   687: aload #7
    //   689: areturn
    //   690: astore_1
    //   691: aload #7
    //   693: astore_0
    //   694: goto -> 700
    //   697: astore_1
    //   698: aconst_null
    //   699: astore_0
    //   700: aload_1
    //   701: invokevirtual printStackTrace : ()V
    //   704: aload_0
    //   705: areturn
    //   706: ldc ''
    //   708: astore #6
    //   710: goto -> 70
    //   713: ldc ''
    //   715: astore #8
    //   717: aload #8
    //   719: astore #6
    //   721: aload #6
    //   723: astore #9
    //   725: iconst_0
    //   726: istore #4
    //   728: goto -> 91
    //   731: iconst_0
    //   732: istore_3
    //   733: goto -> 256
    //   736: iconst_0
    //   737: istore_3
    //   738: goto -> 277
    //   741: iconst_0
    //   742: istore_3
    //   743: goto -> 298
    //   746: iconst_0
    //   747: istore_3
    //   748: goto -> 343
    //   751: iconst_0
    //   752: istore_3
    //   753: goto -> 388
    //   756: iconst_0
    //   757: istore_3
    //   758: goto -> 409
    //   761: iconst_0
    //   762: istore_3
    //   763: goto -> 430
    //   766: iconst_0
    //   767: istore_3
    //   768: goto -> 466
    //   771: iconst_0
    //   772: istore_3
    //   773: goto -> 517
    //   776: ldc ''
    //   778: astore_0
    //   779: goto -> 541
    //   782: iconst_0
    //   783: istore_3
    //   784: goto -> 587
    // Exception table:
    //   from	to	target	type
    //   0	9	697	org/json/JSONException
    //   9	14	690	org/json/JSONException
    //   23	32	690	org/json/JSONException
    //   32	57	60	java/lang/Exception
    //   32	57	690	org/json/JSONException
    //   62	67	690	org/json/JSONException
    //   70	88	690	org/json/JSONException
    //   91	149	690	org/json/JSONException
    //   153	243	690	org/json/JSONException
    //   256	272	690	org/json/JSONException
    //   277	293	690	org/json/JSONException
    //   298	338	690	org/json/JSONException
    //   343	383	690	org/json/JSONException
    //   388	404	690	org/json/JSONException
    //   409	425	690	org/json/JSONException
    //   430	461	690	org/json/JSONException
    //   466	512	690	org/json/JSONException
    //   517	538	690	org/json/JSONException
    //   541	550	690	org/json/JSONException
    //   553	565	690	org/json/JSONException
    //   565	581	690	org/json/JSONException
    //   587	632	690	org/json/JSONException
    //   632	654	690	org/json/JSONException
    //   661	687	690	org/json/JSONException
  }
  
  public static void a(x paramx, c paramc, com.ss.android.socialbase.downloader.e.a parama, int paramInt) {
    if (paramx == null)
      return; 
    try {
      JSONObject jSONObject2 = a(paramx.b(), paramc, parama, paramInt);
      JSONObject jSONObject1 = jSONObject2;
      if (jSONObject2 == null)
        jSONObject1 = new JSONObject(); 
      return;
    } finally {
      paramx = null;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\ss\android\socialbase\downloader\h\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */