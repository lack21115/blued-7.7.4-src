package com.ss.android.socialbase.appdownloader;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Build;
import android.text.TextUtils;
import android.widget.RemoteViews;
import androidx.core.app.NotificationCompat;
import com.ss.android.socialbase.downloader.e.a;
import com.ss.android.socialbase.downloader.g.c;
import com.ss.android.socialbase.downloader.k.a;
import com.ss.android.socialbase.downloader.notification.a;

public class e extends a {
  private final Context a;
  
  private final Resources b;
  
  private String c;
  
  private String d;
  
  private String e;
  
  public e(Context paramContext, int paramInt, String paramString1, String paramString2, String paramString3, String paramString4) {
    super(paramInt, paramString1);
    this.d = paramString2;
    this.c = paramString3;
    this.e = paramString4;
    this.a = paramContext.getApplicationContext();
    this.b = this.a.getResources();
  }
  
  private int a(int paramInt) {
    return (paramInt == 1 || paramInt == 4) ? f.r() : ((paramInt == 2) ? f.s() : ((paramInt == 3) ? f.t() : 0));
  }
  
  private PendingIntent a(String paramString, int paramInt1, int paramInt2) {
    Intent intent = new Intent(this.a, DownloadHandlerService.class);
    intent.setAction(paramString);
    intent.putExtra("extra_click_download_ids", paramInt2);
    intent.putExtra("extra_click_download_type", paramInt1);
    intent.putExtra("extra_from_notification", true);
    return PendingIntent.getService(this.a, paramInt2, intent, 134217728);
  }
  
  private boolean a(a parama, a parama1, c paramc) {
    return (parama != null && (parama.a() == 1013 || parama.a() == 1049) && paramc != null && "application/vnd.android.package-archive".contains(paramc.ah()) && parama1.a("notification_text_opt", 0) == 1);
  }
  
  private Notification b(a parama, boolean paramBoolean) {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual e : ()I
    //   4: istore_3
    //   5: iload_3
    //   6: invokestatic a : (I)I
    //   9: istore #6
    //   11: iload #6
    //   13: ifne -> 18
    //   16: aconst_null
    //   17: areturn
    //   18: aload_0
    //   19: invokespecial k : ()Landroidx/core/app/NotificationCompat$Builder;
    //   22: astore #16
    //   24: aload #16
    //   26: aload_0
    //   27: invokevirtual f : ()J
    //   30: invokevirtual setWhen : (J)Landroidx/core/app/NotificationCompat$Builder;
    //   33: pop
    //   34: aload_0
    //   35: invokevirtual a : ()I
    //   38: istore #5
    //   40: iload #5
    //   42: invokestatic a : (I)Lcom/ss/android/socialbase/downloader/k/a;
    //   45: astore #18
    //   47: getstatic android/os/Build$VERSION.SDK_INT : I
    //   50: bipush #24
    //   52: if_icmplt -> 82
    //   55: aload #18
    //   57: ldc 'set_notification_group'
    //   59: iconst_0
    //   60: invokevirtual a : (Ljava/lang/String;I)I
    //   63: iconst_1
    //   64: if_icmpne -> 82
    //   67: aload #16
    //   69: ldc 'com.ss.android.socialbase.APP_DOWNLOADER'
    //   71: invokevirtual setGroup : (Ljava/lang/String;)Landroidx/core/app/NotificationCompat$Builder;
    //   74: pop
    //   75: aload #16
    //   77: iconst_0
    //   78: invokevirtual setGroupSummary : (Z)Landroidx/core/app/NotificationCompat$Builder;
    //   81: pop
    //   82: aload_0
    //   83: iload #6
    //   85: invokespecial a : (I)I
    //   88: istore #7
    //   90: iload #7
    //   92: ifne -> 97
    //   95: aconst_null
    //   96: areturn
    //   97: aload #16
    //   99: iload #7
    //   101: invokevirtual setSmallIcon : (I)Landroidx/core/app/NotificationCompat$Builder;
    //   104: pop
    //   105: ldc 'android.ss.intent.action.DOWNLOAD_DELETE'
    //   107: astore #15
    //   109: iload #6
    //   111: iconst_1
    //   112: if_icmpeq -> 270
    //   115: iload #6
    //   117: iconst_4
    //   118: if_icmpeq -> 270
    //   121: iload #6
    //   123: iconst_2
    //   124: if_icmpne -> 130
    //   127: goto -> 270
    //   130: iload #6
    //   132: iconst_3
    //   133: if_icmpne -> 325
    //   136: aload #16
    //   138: iconst_0
    //   139: invokevirtual setOngoing : (Z)Landroidx/core/app/NotificationCompat$Builder;
    //   142: pop
    //   143: aload #16
    //   145: iconst_1
    //   146: invokevirtual setAutoCancel : (Z)Landroidx/core/app/NotificationCompat$Builder;
    //   149: pop
    //   150: aload #15
    //   152: astore #14
    //   154: iload_3
    //   155: iconst_m1
    //   156: if_icmpeq -> 230
    //   159: iload_3
    //   160: bipush #-4
    //   162: if_icmpne -> 172
    //   165: aload #15
    //   167: astore #14
    //   169: goto -> 230
    //   172: iload_3
    //   173: bipush #-3
    //   175: if_icmpne -> 226
    //   178: aload #18
    //   180: ldc 'notification_click_install_auto_cancel'
    //   182: iconst_1
    //   183: invokevirtual a : (Ljava/lang/String;I)I
    //   186: ifne -> 226
    //   189: aload #16
    //   191: iconst_0
    //   192: invokevirtual setAutoCancel : (Z)Landroidx/core/app/NotificationCompat$Builder;
    //   195: pop
    //   196: aload_0
    //   197: invokevirtual h : ()I
    //   200: ifle -> 219
    //   203: aload #16
    //   205: iconst_0
    //   206: invokevirtual setOngoing : (Z)Landroidx/core/app/NotificationCompat$Builder;
    //   209: pop
    //   210: ldc 'android.ss.intent.action.DOWNLOAD_OPEN'
    //   212: astore #14
    //   214: iconst_0
    //   215: istore_3
    //   216: goto -> 232
    //   219: aload #16
    //   221: iconst_1
    //   222: invokevirtual setOngoing : (Z)Landroidx/core/app/NotificationCompat$Builder;
    //   225: pop
    //   226: ldc 'android.ss.intent.action.DOWNLOAD_OPEN'
    //   228: astore #14
    //   230: iconst_1
    //   231: istore_3
    //   232: aload #16
    //   234: aload_0
    //   235: aload #14
    //   237: iload #6
    //   239: iload #5
    //   241: invokespecial a : (Ljava/lang/String;II)Landroid/app/PendingIntent;
    //   244: invokevirtual setContentIntent : (Landroid/app/PendingIntent;)Landroidx/core/app/NotificationCompat$Builder;
    //   247: pop
    //   248: aload #16
    //   250: aload_0
    //   251: ldc 'android.ss.intent.action.DOWNLOAD_HIDE'
    //   253: iload #6
    //   255: iload #5
    //   257: invokespecial a : (Ljava/lang/String;II)Landroid/app/PendingIntent;
    //   260: invokevirtual setDeleteIntent : (Landroid/app/PendingIntent;)Landroidx/core/app/NotificationCompat$Builder;
    //   263: pop
    //   264: iload_3
    //   265: istore #4
    //   267: goto -> 328
    //   270: aload #16
    //   272: aload_0
    //   273: ldc 'android.ss.intent.action.DOWNLOAD_DELETE'
    //   275: iload #6
    //   277: iload #5
    //   279: invokespecial a : (Ljava/lang/String;II)Landroid/app/PendingIntent;
    //   282: invokevirtual setContentIntent : (Landroid/app/PendingIntent;)Landroidx/core/app/NotificationCompat$Builder;
    //   285: pop
    //   286: iload #6
    //   288: iconst_1
    //   289: if_icmpeq -> 307
    //   292: iload #6
    //   294: iconst_4
    //   295: if_icmpne -> 301
    //   298: goto -> 307
    //   301: iconst_0
    //   302: istore #9
    //   304: goto -> 310
    //   307: iconst_1
    //   308: istore #9
    //   310: aload #16
    //   312: iload #9
    //   314: invokevirtual setOngoing : (Z)Landroidx/core/app/NotificationCompat$Builder;
    //   317: pop
    //   318: aload #16
    //   320: iconst_0
    //   321: invokevirtual setAutoCancel : (Z)Landroidx/core/app/NotificationCompat$Builder;
    //   324: pop
    //   325: iconst_1
    //   326: istore #4
    //   328: aload_0
    //   329: invokevirtual b : ()J
    //   332: lstore #10
    //   334: aload_0
    //   335: invokevirtual c : ()J
    //   338: lstore #12
    //   340: iload #6
    //   342: iconst_1
    //   343: if_icmpeq -> 360
    //   346: iload #6
    //   348: iconst_4
    //   349: if_icmpne -> 355
    //   352: goto -> 360
    //   355: iconst_0
    //   356: istore_3
    //   357: goto -> 378
    //   360: lload #12
    //   362: lconst_0
    //   363: lcmp
    //   364: ifle -> 355
    //   367: lload #10
    //   369: ldc2_w 100
    //   372: lmul
    //   373: lload #12
    //   375: ldiv
    //   376: l2i
    //   377: istore_3
    //   378: aload_0
    //   379: invokevirtual d : ()Ljava/lang/String;
    //   382: astore #15
    //   384: aload #15
    //   386: astore #14
    //   388: aload #15
    //   390: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   393: ifeq -> 414
    //   396: ldc 'appdownloader_download_unknown_title'
    //   398: invokestatic b : (Ljava/lang/String;)I
    //   401: istore #8
    //   403: aload_0
    //   404: getfield b : Landroid/content/res/Resources;
    //   407: iload #8
    //   409: invokevirtual getString : (I)Ljava/lang/String;
    //   412: astore #14
    //   414: aload_0
    //   415: invokespecial j : ()Landroid/widget/RemoteViews;
    //   418: astore #17
    //   420: new android/content/Intent
    //   423: dup
    //   424: aload_0
    //   425: getfield a : Landroid/content/Context;
    //   428: ldc com/ss/android/socialbase/appdownloader/DownloadHandlerService
    //   430: invokespecial <init> : (Landroid/content/Context;Ljava/lang/Class;)V
    //   433: astore #15
    //   435: aload #15
    //   437: ldc 'android.ss.intent.action.DOWNLOAD_CLICK'
    //   439: invokevirtual setAction : (Ljava/lang/String;)Landroid/content/Intent;
    //   442: pop
    //   443: aload #15
    //   445: ldc 'notification_name'
    //   447: aload_0
    //   448: invokevirtual d : ()Ljava/lang/String;
    //   451: invokevirtual putExtra : (Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   454: pop
    //   455: aload #15
    //   457: ldc 'extra_click_download_ids'
    //   459: iload #5
    //   461: invokevirtual putExtra : (Ljava/lang/String;I)Landroid/content/Intent;
    //   464: pop
    //   465: aload #15
    //   467: ldc 'extra_click_download_type'
    //   469: iload #6
    //   471: invokevirtual putExtra : (Ljava/lang/String;I)Landroid/content/Intent;
    //   474: pop
    //   475: aload #17
    //   477: invokestatic j : ()I
    //   480: aload_0
    //   481: getfield a : Landroid/content/Context;
    //   484: iload #5
    //   486: aload #15
    //   488: ldc 134217728
    //   490: invokestatic getService : (Landroid/content/Context;ILandroid/content/Intent;I)Landroid/app/PendingIntent;
    //   493: invokevirtual setOnClickPendingIntent : (ILandroid/app/PendingIntent;)V
    //   496: aload #17
    //   498: invokestatic l : ()I
    //   501: aload #14
    //   503: invokevirtual setTextViewText : (ILjava/lang/CharSequence;)V
    //   506: aload #17
    //   508: invokestatic g : ()I
    //   511: bipush #100
    //   513: iload_3
    //   514: iload_2
    //   515: invokevirtual setProgressBar : (IIIZ)V
    //   518: aload #17
    //   520: invokestatic k : ()I
    //   523: iload #7
    //   525: invokevirtual setImageViewResource : (II)V
    //   528: ldc ''
    //   530: astore #15
    //   532: iload #6
    //   534: iconst_1
    //   535: if_icmpeq -> 1177
    //   538: iload #6
    //   540: iconst_4
    //   541: if_icmpne -> 547
    //   544: goto -> 1177
    //   547: iload #6
    //   549: iconst_2
    //   550: if_icmpne -> 702
    //   553: new java/lang/StringBuilder
    //   556: dup
    //   557: invokespecial <init> : ()V
    //   560: astore_1
    //   561: aload_1
    //   562: aload_0
    //   563: invokevirtual b : ()J
    //   566: invokestatic a : (J)Ljava/lang/String;
    //   569: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   572: pop
    //   573: aload_1
    //   574: ldc_w '/'
    //   577: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   580: pop
    //   581: aload_1
    //   582: aload_0
    //   583: invokevirtual c : ()J
    //   586: invokestatic a : (J)Ljava/lang/String;
    //   589: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   592: pop
    //   593: aload_1
    //   594: invokevirtual toString : ()Ljava/lang/String;
    //   597: astore #15
    //   599: ldc_w 'appdownloader_notification_download_pause'
    //   602: invokestatic b : (Ljava/lang/String;)I
    //   605: istore_3
    //   606: aload_0
    //   607: getfield a : Landroid/content/Context;
    //   610: invokevirtual getResources : ()Landroid/content/res/Resources;
    //   613: iload_3
    //   614: invokevirtual getString : (I)Ljava/lang/String;
    //   617: astore_1
    //   618: ldc_w 'appdownloader_notification_download_resume'
    //   621: invokestatic b : (Ljava/lang/String;)I
    //   624: istore_3
    //   625: aload_0
    //   626: getfield a : Landroid/content/Context;
    //   629: invokevirtual getResources : ()Landroid/content/res/Resources;
    //   632: iload_3
    //   633: invokevirtual getString : (I)Ljava/lang/String;
    //   636: astore #14
    //   638: aload #17
    //   640: invokestatic g : ()I
    //   643: bipush #8
    //   645: invokevirtual setViewVisibility : (II)V
    //   648: aload #17
    //   650: invokestatic h : ()I
    //   653: bipush #8
    //   655: invokevirtual setViewVisibility : (II)V
    //   658: aload #17
    //   660: invokestatic i : ()I
    //   663: iconst_0
    //   664: invokevirtual setViewVisibility : (II)V
    //   667: invokestatic j : ()I
    //   670: istore_3
    //   671: aload_0
    //   672: getfield e : Ljava/lang/String;
    //   675: invokestatic a : (Ljava/lang/String;)Z
    //   678: ifeq -> 692
    //   681: aload #17
    //   683: iload_3
    //   684: bipush #8
    //   686: invokevirtual setViewVisibility : (II)V
    //   689: goto -> 1338
    //   692: aload #17
    //   694: iload_3
    //   695: iconst_0
    //   696: invokevirtual setViewVisibility : (II)V
    //   699: goto -> 1338
    //   702: iload #6
    //   704: iconst_3
    //   705: if_icmpne -> 1168
    //   708: invokestatic B : ()Landroid/content/Context;
    //   711: invokestatic a : (Landroid/content/Context;)Lcom/ss/android/socialbase/downloader/downloader/f;
    //   714: iload #5
    //   716: invokevirtual h : (I)Lcom/ss/android/socialbase/downloader/g/c;
    //   719: astore #14
    //   721: aload_0
    //   722: invokevirtual e : ()I
    //   725: iconst_m1
    //   726: if_icmpeq -> 973
    //   729: aload_0
    //   730: invokevirtual e : ()I
    //   733: bipush #-4
    //   735: if_icmpne -> 741
    //   738: goto -> 973
    //   741: aload_0
    //   742: invokevirtual e : ()I
    //   745: bipush #-3
    //   747: if_icmpne -> 964
    //   750: aload_0
    //   751: invokevirtual c : ()J
    //   754: invokestatic a : (J)Ljava/lang/String;
    //   757: astore #15
    //   759: aload #14
    //   761: ifnull -> 904
    //   764: aload #14
    //   766: invokevirtual ah : ()Ljava/lang/String;
    //   769: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   772: ifne -> 904
    //   775: aload #14
    //   777: invokevirtual ah : ()Ljava/lang/String;
    //   780: ldc 'application/vnd.android.package-archive'
    //   782: invokevirtual equals : (Ljava/lang/Object;)Z
    //   785: ifeq -> 904
    //   788: aload_0
    //   789: getfield a : Landroid/content/Context;
    //   792: astore_1
    //   793: aload_0
    //   794: getfield d : Ljava/lang/String;
    //   797: astore #18
    //   799: aload_0
    //   800: getfield c : Ljava/lang/String;
    //   803: astore #19
    //   805: new java/lang/StringBuilder
    //   808: dup
    //   809: invokespecial <init> : ()V
    //   812: astore #20
    //   814: aload #20
    //   816: ldc_w 'url: '
    //   819: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   822: pop
    //   823: aload #20
    //   825: aload #14
    //   827: invokevirtual j : ()Ljava/lang/String;
    //   830: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   833: pop
    //   834: aload #20
    //   836: ldc_w ', backupUrl: '
    //   839: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   842: pop
    //   843: aload #20
    //   845: aload #14
    //   847: invokevirtual K : ()Ljava/lang/String;
    //   850: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   853: pop
    //   854: aload_1
    //   855: aload #18
    //   857: aload #19
    //   859: aload #20
    //   861: invokevirtual toString : ()Ljava/lang/String;
    //   864: invokestatic a : (Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Z
    //   867: ifeq -> 880
    //   870: ldc_w 'appdownloader_notification_download_complete_open'
    //   873: invokestatic b : (Ljava/lang/String;)I
    //   876: istore_3
    //   877: goto -> 929
    //   880: ldc_w 'appdownloader_notification_download_complete_with_install'
    //   883: invokestatic b : (Ljava/lang/String;)I
    //   886: istore_3
    //   887: aload #16
    //   889: aload_0
    //   890: getfield b : Landroid/content/res/Resources;
    //   893: iload_3
    //   894: invokevirtual getString : (I)Ljava/lang/String;
    //   897: invokevirtual setContentText : (Ljava/lang/CharSequence;)Landroidx/core/app/NotificationCompat$Builder;
    //   900: pop
    //   901: goto -> 929
    //   904: ldc_w 'appdownloader_notification_download_complete_without_install'
    //   907: invokestatic b : (Ljava/lang/String;)I
    //   910: istore_3
    //   911: invokestatic a : ()Lcom/ss/android/socialbase/downloader/downloader/c;
    //   914: iload #5
    //   916: invokevirtual l : (I)Lcom/ss/android/socialbase/downloader/d/ac;
    //   919: ifnull -> 929
    //   922: ldc_w 'appdownloader_notification_download_complete_open'
    //   925: invokestatic b : (Ljava/lang/String;)I
    //   928: istore_3
    //   929: aload_0
    //   930: getfield a : Landroid/content/Context;
    //   933: invokevirtual getResources : ()Landroid/content/res/Resources;
    //   936: iload_3
    //   937: invokevirtual getString : (I)Ljava/lang/String;
    //   940: astore_1
    //   941: ldc_w 'appdownloader_notification_download_install'
    //   944: invokestatic b : (Ljava/lang/String;)I
    //   947: istore_3
    //   948: aload_0
    //   949: getfield a : Landroid/content/Context;
    //   952: invokevirtual getResources : ()Landroid/content/res/Resources;
    //   955: iload_3
    //   956: invokevirtual getString : (I)Ljava/lang/String;
    //   959: astore #14
    //   961: goto -> 1126
    //   964: ldc ''
    //   966: astore_1
    //   967: aload_1
    //   968: astore #14
    //   970: goto -> 1126
    //   973: aload #17
    //   975: invokestatic n : ()I
    //   978: bipush #8
    //   980: invokevirtual setViewVisibility : (II)V
    //   983: aload_1
    //   984: ifnull -> 1019
    //   987: aload_1
    //   988: invokevirtual a : ()I
    //   991: sipush #1006
    //   994: if_icmpne -> 1019
    //   997: ldc_w 'appdownloader_notification_download_space_failed'
    //   1000: invokestatic b : (Ljava/lang/String;)I
    //   1003: istore_3
    //   1004: aload_0
    //   1005: getfield a : Landroid/content/Context;
    //   1008: invokevirtual getResources : ()Landroid/content/res/Resources;
    //   1011: iload_3
    //   1012: invokevirtual getString : (I)Ljava/lang/String;
    //   1015: astore_1
    //   1016: goto -> 1106
    //   1019: aload_0
    //   1020: aload_1
    //   1021: aload #18
    //   1023: aload #14
    //   1025: invokespecial a : (Lcom/ss/android/socialbase/downloader/e/a;Lcom/ss/android/socialbase/downloader/k/a;Lcom/ss/android/socialbase/downloader/g/c;)Z
    //   1028: ifeq -> 1087
    //   1031: aload #14
    //   1033: ifnull -> 1049
    //   1036: aload #14
    //   1038: invokevirtual x : ()Z
    //   1041: ifeq -> 1049
    //   1044: iconst_1
    //   1045: istore_3
    //   1046: goto -> 1051
    //   1049: iconst_0
    //   1050: istore_3
    //   1051: iload_3
    //   1052: ifeq -> 1065
    //   1055: ldc_w 'appdownloader_notification_download_waiting_wifi'
    //   1058: invokestatic b : (Ljava/lang/String;)I
    //   1061: istore_3
    //   1062: goto -> 1072
    //   1065: ldc_w 'appdownloader_notification_download_waiting_net'
    //   1068: invokestatic b : (Ljava/lang/String;)I
    //   1071: istore_3
    //   1072: aload_0
    //   1073: getfield a : Landroid/content/Context;
    //   1076: invokevirtual getResources : ()Landroid/content/res/Resources;
    //   1079: iload_3
    //   1080: invokevirtual getString : (I)Ljava/lang/String;
    //   1083: astore_1
    //   1084: goto -> 1106
    //   1087: ldc_w 'appdownloader_notification_download_failed'
    //   1090: invokestatic b : (Ljava/lang/String;)I
    //   1093: istore_3
    //   1094: aload_0
    //   1095: getfield a : Landroid/content/Context;
    //   1098: invokevirtual getResources : ()Landroid/content/res/Resources;
    //   1101: iload_3
    //   1102: invokevirtual getString : (I)Ljava/lang/String;
    //   1105: astore_1
    //   1106: ldc_w 'appdownloader_notification_download_restart'
    //   1109: invokestatic b : (Ljava/lang/String;)I
    //   1112: istore_3
    //   1113: aload_0
    //   1114: getfield a : Landroid/content/Context;
    //   1117: invokevirtual getResources : ()Landroid/content/res/Resources;
    //   1120: iload_3
    //   1121: invokevirtual getString : (I)Ljava/lang/String;
    //   1124: astore #14
    //   1126: aload #17
    //   1128: invokestatic g : ()I
    //   1131: bipush #8
    //   1133: invokevirtual setViewVisibility : (II)V
    //   1136: aload #17
    //   1138: invokestatic h : ()I
    //   1141: iconst_0
    //   1142: invokevirtual setViewVisibility : (II)V
    //   1145: aload #17
    //   1147: invokestatic i : ()I
    //   1150: bipush #8
    //   1152: invokevirtual setViewVisibility : (II)V
    //   1155: aload #17
    //   1157: invokestatic j : ()I
    //   1160: bipush #8
    //   1162: invokevirtual setViewVisibility : (II)V
    //   1165: goto -> 1338
    //   1168: ldc ''
    //   1170: astore_1
    //   1171: aload_1
    //   1172: astore #14
    //   1174: goto -> 1338
    //   1177: new java/lang/StringBuilder
    //   1180: dup
    //   1181: invokespecial <init> : ()V
    //   1184: astore_1
    //   1185: aload_1
    //   1186: aload_0
    //   1187: invokevirtual b : ()J
    //   1190: invokestatic a : (J)Ljava/lang/String;
    //   1193: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1196: pop
    //   1197: aload_1
    //   1198: ldc_w '/'
    //   1201: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1204: pop
    //   1205: aload_1
    //   1206: aload_0
    //   1207: invokevirtual c : ()J
    //   1210: invokestatic a : (J)Ljava/lang/String;
    //   1213: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1216: pop
    //   1217: aload_1
    //   1218: invokevirtual toString : ()Ljava/lang/String;
    //   1221: astore #15
    //   1223: iload #6
    //   1225: iconst_1
    //   1226: if_icmpne -> 1239
    //   1229: ldc_w 'appdownloader_notification_downloading'
    //   1232: invokestatic b : (Ljava/lang/String;)I
    //   1235: istore_3
    //   1236: goto -> 1246
    //   1239: ldc_w 'appdownloader_notification_prepare'
    //   1242: invokestatic b : (Ljava/lang/String;)I
    //   1245: istore_3
    //   1246: aload_0
    //   1247: getfield a : Landroid/content/Context;
    //   1250: invokevirtual getResources : ()Landroid/content/res/Resources;
    //   1253: iload_3
    //   1254: invokevirtual getString : (I)Ljava/lang/String;
    //   1257: astore_1
    //   1258: ldc_w 'appdownloader_notification_download_pause'
    //   1261: invokestatic b : (Ljava/lang/String;)I
    //   1264: istore_3
    //   1265: aload_0
    //   1266: getfield a : Landroid/content/Context;
    //   1269: invokevirtual getResources : ()Landroid/content/res/Resources;
    //   1272: iload_3
    //   1273: invokevirtual getString : (I)Ljava/lang/String;
    //   1276: astore #14
    //   1278: aload #17
    //   1280: invokestatic g : ()I
    //   1283: iconst_0
    //   1284: invokevirtual setViewVisibility : (II)V
    //   1287: aload #17
    //   1289: invokestatic h : ()I
    //   1292: bipush #8
    //   1294: invokevirtual setViewVisibility : (II)V
    //   1297: aload #17
    //   1299: invokestatic i : ()I
    //   1302: iconst_0
    //   1303: invokevirtual setViewVisibility : (II)V
    //   1306: invokestatic j : ()I
    //   1309: istore_3
    //   1310: aload_0
    //   1311: getfield e : Ljava/lang/String;
    //   1314: invokestatic a : (Ljava/lang/String;)Z
    //   1317: ifeq -> 1331
    //   1320: aload #17
    //   1322: iload_3
    //   1323: bipush #8
    //   1325: invokevirtual setViewVisibility : (II)V
    //   1328: goto -> 1338
    //   1331: aload #17
    //   1333: iload_3
    //   1334: iconst_0
    //   1335: invokevirtual setViewVisibility : (II)V
    //   1338: aload #17
    //   1340: invokestatic m : ()I
    //   1343: aload #15
    //   1345: invokevirtual setTextViewText : (ILjava/lang/CharSequence;)V
    //   1348: aload #17
    //   1350: invokestatic o : ()I
    //   1353: aload_1
    //   1354: invokevirtual setTextViewText : (ILjava/lang/CharSequence;)V
    //   1357: aload #17
    //   1359: invokestatic n : ()I
    //   1362: aload #15
    //   1364: invokevirtual setTextViewText : (ILjava/lang/CharSequence;)V
    //   1367: aload #17
    //   1369: invokestatic p : ()I
    //   1372: aload_1
    //   1373: invokevirtual setTextViewText : (ILjava/lang/CharSequence;)V
    //   1376: aload #17
    //   1378: invokestatic j : ()I
    //   1381: aload #14
    //   1383: invokevirtual setTextViewText : (ILjava/lang/CharSequence;)V
    //   1386: aload #16
    //   1388: invokevirtual build : ()Landroid/app/Notification;
    //   1391: astore_1
    //   1392: iload #4
    //   1394: ifeq -> 1415
    //   1397: aload_1
    //   1398: aload_1
    //   1399: getfield flags : I
    //   1402: iconst_2
    //   1403: ior
    //   1404: putfield flags : I
    //   1407: aload_0
    //   1408: iconst_1
    //   1409: invokevirtual a : (Z)V
    //   1412: goto -> 1420
    //   1415: aload_0
    //   1416: iconst_0
    //   1417: invokevirtual a : (Z)V
    //   1420: aload_1
    //   1421: aload #17
    //   1423: putfield contentView : Landroid/widget/RemoteViews;
    //   1426: aload_1
    //   1427: areturn
  }
  
  private RemoteViews j() {
    int i = f.a();
    RemoteViews remoteViews = new RemoteViews(this.a.getPackageName(), i);
    if (Build.VERSION.SDK_INT > 20)
      try {
        return remoteViews;
      } finally {
        Exception exception = null;
      }  
    return remoteViews;
  }
  
  private NotificationCompat.Builder k() {
    String str2 = d.h().g();
    if (Build.VERSION.SDK_INT < 26)
      return new NotificationCompat.Builder(this.a); 
    String str1 = str2;
    if (TextUtils.isEmpty(str2))
      str1 = c.c(this.a); 
    try {
      return (d.h().i() != null) ? d.h().i().a(this.a, str1) : new NotificationCompat.Builder(this.a, str1);
    } catch (NoSuchMethodError noSuchMethodError) {
      return new NotificationCompat.Builder(this.a);
    } 
  }
  
  public void a(a parama, boolean paramBoolean) {
    if (this.a == null)
      return; 
    try {
      a(b(parama, paramBoolean));
      return;
    } catch (Exception exception) {
      exception.printStackTrace();
      return;
    } 
  }
  
  public void a(c paramc) {
    super.a(paramc);
    this.d = paramc.k();
    this.c = paramc.h();
    this.e = paramc.y();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\ss\android\socialbase\appdownloader\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */