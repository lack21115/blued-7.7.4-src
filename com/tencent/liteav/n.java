package com.tencent.liteav;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import com.tencent.liteav.basic.datareport.TXCDRApi;
import com.tencent.liteav.basic.datareport.a;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.util.TXCCommonUtil;
import com.tencent.liteav.basic.util.g;

public class n {
  private int A = -1;
  
  private int B = 0;
  
  private int C = 0;
  
  private int D = 0;
  
  private int E;
  
  private float F = 1.0F;
  
  private int G;
  
  private String H;
  
  private String I;
  
  private String J;
  
  private String K = "";
  
  private final String a = "TXCVodPlayCollection";
  
  private final String b = "1";
  
  private Context c;
  
  private String d = null;
  
  private long e = 0L;
  
  private long f = 0L;
  
  private long g = 0L;
  
  private boolean h = false;
  
  private boolean i = true;
  
  private int j = 0;
  
  private int k = 0;
  
  private int l = 0;
  
  private long m = 0L;
  
  private int n = 0;
  
  private int o = 0;
  
  private int p = 0;
  
  private int q;
  
  private String r;
  
  private boolean s = false;
  
  private boolean t = false;
  
  private int u = 0;
  
  private int v = 0;
  
  private String w = "0";
  
  private String x = "";
  
  private int y;
  
  private String z = "";
  
  public n(Context paramContext) {
    this.c = paramContext;
    this.r = TXCCommonUtil.getAppVersion();
    this.J = g.e();
  }
  
  private void m() {
    // Byte code:
    //   0: new com/tencent/liteav/basic/datareport/TXCDRExtInfo
    //   3: dup
    //   4: invokespecial <init> : ()V
    //   7: astore #6
    //   9: aload #6
    //   11: iconst_0
    //   12: putfield report_common : Z
    //   15: aload #6
    //   17: iconst_0
    //   18: putfield report_status : Z
    //   21: aload #6
    //   23: aload_0
    //   24: getfield d : Ljava/lang/String;
    //   27: putfield url : Ljava/lang/String;
    //   30: aload_0
    //   31: getfield c : Landroid/content/Context;
    //   34: aload_0
    //   35: getfield J : Ljava/lang/String;
    //   38: getstatic com/tencent/liteav/basic/datareport/a.ad : I
    //   41: getstatic com/tencent/liteav/basic/datareport/a.at : I
    //   44: aload #6
    //   46: invokestatic InitEvent : (Landroid/content/Context;Ljava/lang/String;IILcom/tencent/liteav/basic/datareport/TXCDRExtInfo;)V
    //   49: invokestatic c : ()Ljava/lang/String;
    //   52: astore #8
    //   54: aload_0
    //   55: getfield J : Ljava/lang/String;
    //   58: getstatic com/tencent/liteav/basic/datareport/a.ad : I
    //   61: ldc 'str_device_type'
    //   63: aload #8
    //   65: invokestatic txSetEventValue : (Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V
    //   68: aload_0
    //   69: getfield c : Landroid/content/Context;
    //   72: invokestatic e : (Landroid/content/Context;)I
    //   75: istore_1
    //   76: aload_0
    //   77: getfield J : Ljava/lang/String;
    //   80: getstatic com/tencent/liteav/basic/datareport/a.ad : I
    //   83: ldc 'u32_network_type'
    //   85: iload_1
    //   86: i2l
    //   87: invokestatic txSetEventIntValue : (Ljava/lang/String;ILjava/lang/String;J)V
    //   90: aload_0
    //   91: getfield c : Landroid/content/Context;
    //   94: invokestatic f : (Landroid/content/Context;)Ljava/lang/String;
    //   97: astore #10
    //   99: aload_0
    //   100: getfield J : Ljava/lang/String;
    //   103: getstatic com/tencent/liteav/basic/datareport/a.ad : I
    //   106: ldc 'dev_uuid'
    //   108: aload #10
    //   110: invokestatic txSetEventValue : (Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V
    //   113: aload_0
    //   114: getfield J : Ljava/lang/String;
    //   117: getstatic com/tencent/liteav/basic/datareport/a.ad : I
    //   120: ldc 'str_app_version'
    //   122: aload_0
    //   123: getfield r : Ljava/lang/String;
    //   126: invokestatic txSetEventValue : (Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V
    //   129: aload_0
    //   130: invokevirtual a : ()Ljava/lang/String;
    //   133: astore #9
    //   135: aload_0
    //   136: getfield J : Ljava/lang/String;
    //   139: getstatic com/tencent/liteav/basic/datareport/a.ad : I
    //   142: ldc 'str_app_name'
    //   144: aload #9
    //   146: invokestatic txSetEventValue : (Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V
    //   149: aload_0
    //   150: getfield J : Ljava/lang/String;
    //   153: getstatic com/tencent/liteav/basic/datareport/a.ad : I
    //   156: getstatic com/tencent/liteav/basic/datareport/a.l : Ljava/lang/String;
    //   159: getstatic android/os/Build$VERSION.SDK_INT : I
    //   162: invokestatic valueOf : (I)Ljava/lang/String;
    //   165: invokestatic txSetEventValue : (Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V
    //   168: aload_0
    //   169: getfield J : Ljava/lang/String;
    //   172: getstatic com/tencent/liteav/basic/datareport/a.ad : I
    //   175: ldc 'str_stream_url'
    //   177: aload_0
    //   178: getfield d : Ljava/lang/String;
    //   181: invokestatic txSetEventValue : (Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V
    //   184: aload_0
    //   185: getfield J : Ljava/lang/String;
    //   188: getstatic com/tencent/liteav/basic/datareport/a.ad : I
    //   191: ldc 'token'
    //   193: aload_0
    //   194: getfield J : Ljava/lang/String;
    //   197: invokestatic txSetEventValue : (Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V
    //   200: invokestatic getUserId : ()Ljava/lang/String;
    //   203: astore #7
    //   205: aload #7
    //   207: ifnull -> 222
    //   210: aload #7
    //   212: astore #6
    //   214: aload #7
    //   216: invokevirtual isEmpty : ()Z
    //   219: ifeq -> 254
    //   222: new java/lang/StringBuilder
    //   225: dup
    //   226: invokespecial <init> : ()V
    //   229: astore #6
    //   231: aload #6
    //   233: ldc '_'
    //   235: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   238: pop
    //   239: aload #6
    //   241: aload #10
    //   243: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   246: pop
    //   247: aload #6
    //   249: invokevirtual toString : ()Ljava/lang/String;
    //   252: astore #6
    //   254: aload_0
    //   255: getfield J : Ljava/lang/String;
    //   258: getstatic com/tencent/liteav/basic/datareport/a.ad : I
    //   261: ldc 'str_user_id'
    //   263: aload #6
    //   265: invokestatic txSetEventValue : (Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V
    //   268: aload_0
    //   269: getfield c : Landroid/content/Context;
    //   272: invokestatic c : (Landroid/content/Context;)Ljava/lang/String;
    //   275: astore #7
    //   277: aload_0
    //   278: getfield J : Ljava/lang/String;
    //   281: getstatic com/tencent/liteav/basic/datareport/a.ad : I
    //   284: ldc 'str_package_name'
    //   286: aload #7
    //   288: invokestatic txSetEventValue : (Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V
    //   291: aload_0
    //   292: getfield J : Ljava/lang/String;
    //   295: getstatic com/tencent/liteav/basic/datareport/a.ad : I
    //   298: ldc 'u32_app_id'
    //   300: aload_0
    //   301: getfield K : Ljava/lang/String;
    //   304: invokestatic txSetEventValue : (Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V
    //   307: aload_0
    //   308: getfield J : Ljava/lang/String;
    //   311: getstatic com/tencent/liteav/basic/datareport/a.ad : I
    //   314: ldc 'u32_timeuse'
    //   316: aload_0
    //   317: getfield l : I
    //   320: i2l
    //   321: invokestatic txSetEventIntValue : (Ljava/lang/String;ILjava/lang/String;J)V
    //   324: aload_0
    //   325: getfield J : Ljava/lang/String;
    //   328: getstatic com/tencent/liteav/basic/datareport/a.ad : I
    //   331: ldc 'u32_videotime'
    //   333: aload_0
    //   334: getfield j : I
    //   337: i2l
    //   338: invokestatic txSetEventIntValue : (Ljava/lang/String;ILjava/lang/String;J)V
    //   341: aload_0
    //   342: getfield J : Ljava/lang/String;
    //   345: astore #10
    //   347: getstatic com/tencent/liteav/basic/datareport/a.ad : I
    //   350: istore_2
    //   351: aload_0
    //   352: getfield o : I
    //   355: istore_3
    //   356: iload_3
    //   357: ifne -> 366
    //   360: lconst_0
    //   361: lstore #4
    //   363: goto -> 375
    //   366: aload_0
    //   367: getfield p : I
    //   370: iload_3
    //   371: idiv
    //   372: i2l
    //   373: lstore #4
    //   375: aload #10
    //   377: iload_2
    //   378: ldc 'u32_avg_load'
    //   380: lload #4
    //   382: invokestatic txSetEventIntValue : (Ljava/lang/String;ILjava/lang/String;J)V
    //   385: aload_0
    //   386: getfield J : Ljava/lang/String;
    //   389: getstatic com/tencent/liteav/basic/datareport/a.ad : I
    //   392: ldc 'u32_load_cnt'
    //   394: aload_0
    //   395: getfield o : I
    //   398: i2l
    //   399: invokestatic txSetEventIntValue : (Ljava/lang/String;ILjava/lang/String;J)V
    //   402: aload_0
    //   403: getfield J : Ljava/lang/String;
    //   406: getstatic com/tencent/liteav/basic/datareport/a.ad : I
    //   409: ldc 'u32_max_load'
    //   411: aload_0
    //   412: getfield q : I
    //   415: i2l
    //   416: invokestatic txSetEventIntValue : (Ljava/lang/String;ILjava/lang/String;J)V
    //   419: aload_0
    //   420: getfield J : Ljava/lang/String;
    //   423: getstatic com/tencent/liteav/basic/datareport/a.ad : I
    //   426: ldc 'u32_avg_block_time'
    //   428: aload_0
    //   429: getfield p : I
    //   432: i2l
    //   433: invokestatic txSetEventIntValue : (Ljava/lang/String;ILjava/lang/String;J)V
    //   436: aload_0
    //   437: getfield J : Ljava/lang/String;
    //   440: getstatic com/tencent/liteav/basic/datareport/a.ad : I
    //   443: ldc 'u32_player_type'
    //   445: aload_0
    //   446: getfield v : I
    //   449: i2l
    //   450: invokestatic txSetEventIntValue : (Ljava/lang/String;ILjava/lang/String;J)V
    //   453: aload_0
    //   454: getfield J : Ljava/lang/String;
    //   457: astore #10
    //   459: getstatic com/tencent/liteav/basic/datareport/a.ad : I
    //   462: istore_2
    //   463: aload_0
    //   464: getfield C : I
    //   467: istore_3
    //   468: iload_3
    //   469: ifle -> 479
    //   472: iload_3
    //   473: i2l
    //   474: lstore #4
    //   476: goto -> 484
    //   479: ldc2_w -1
    //   482: lstore #4
    //   484: aload #10
    //   486: iload_2
    //   487: ldc 'u32_dns_time'
    //   489: lload #4
    //   491: invokestatic txSetEventIntValue : (Ljava/lang/String;ILjava/lang/String;J)V
    //   494: aload_0
    //   495: getfield J : Ljava/lang/String;
    //   498: astore #10
    //   500: getstatic com/tencent/liteav/basic/datareport/a.ad : I
    //   503: istore_2
    //   504: aload_0
    //   505: getfield B : I
    //   508: istore_3
    //   509: iload_3
    //   510: ifle -> 520
    //   513: iload_3
    //   514: i2l
    //   515: lstore #4
    //   517: goto -> 525
    //   520: ldc2_w -1
    //   523: lstore #4
    //   525: aload #10
    //   527: iload_2
    //   528: ldc 'u32_tcp_did_connect'
    //   530: lload #4
    //   532: invokestatic txSetEventIntValue : (Ljava/lang/String;ILjava/lang/String;J)V
    //   535: aload_0
    //   536: getfield J : Ljava/lang/String;
    //   539: astore #10
    //   541: getstatic com/tencent/liteav/basic/datareport/a.ad : I
    //   544: istore_2
    //   545: aload_0
    //   546: getfield D : I
    //   549: istore_3
    //   550: iload_3
    //   551: ifle -> 561
    //   554: iload_3
    //   555: i2l
    //   556: lstore #4
    //   558: goto -> 566
    //   561: ldc2_w -1
    //   564: lstore #4
    //   566: aload #10
    //   568: iload_2
    //   569: ldc 'u32_first_video_packet'
    //   571: lload #4
    //   573: invokestatic txSetEventIntValue : (Ljava/lang/String;ILjava/lang/String;J)V
    //   576: aload_0
    //   577: getfield J : Ljava/lang/String;
    //   580: astore #10
    //   582: getstatic com/tencent/liteav/basic/datareport/a.ad : I
    //   585: istore_2
    //   586: aload_0
    //   587: getfield n : I
    //   590: istore_3
    //   591: iload_3
    //   592: ifle -> 602
    //   595: iload_3
    //   596: i2l
    //   597: lstore #4
    //   599: goto -> 607
    //   602: ldc2_w -1
    //   605: lstore #4
    //   607: aload #10
    //   609: iload_2
    //   610: ldc 'u32_first_i_frame'
    //   612: lload #4
    //   614: invokestatic txSetEventIntValue : (Ljava/lang/String;ILjava/lang/String;J)V
    //   617: aload_0
    //   618: getfield J : Ljava/lang/String;
    //   621: getstatic com/tencent/liteav/basic/datareport/a.ad : I
    //   624: ldc_w 'u32_server_ip'
    //   627: aload_0
    //   628: getfield H : Ljava/lang/String;
    //   631: invokestatic txSetEventValue : (Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V
    //   634: aload_0
    //   635: getfield J : Ljava/lang/String;
    //   638: getstatic com/tencent/liteav/basic/datareport/a.ad : I
    //   641: ldc_w 'u32_drm_type'
    //   644: aload_0
    //   645: getfield I : Ljava/lang/String;
    //   648: invokestatic txSetEventValue : (Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V
    //   651: aload_0
    //   652: getfield J : Ljava/lang/String;
    //   655: getstatic com/tencent/liteav/basic/datareport/a.ad : I
    //   658: ldc_w 'str_fileid'
    //   661: aload_0
    //   662: getfield x : Ljava/lang/String;
    //   665: invokestatic txSetEventValue : (Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V
    //   668: aload_0
    //   669: getfield J : Ljava/lang/String;
    //   672: getstatic com/tencent/liteav/basic/datareport/a.ad : I
    //   675: ldc_w 'u32_playmode'
    //   678: aload_0
    //   679: getfield w : Ljava/lang/String;
    //   682: invokestatic txSetEventValue : (Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V
    //   685: aload_0
    //   686: getfield J : Ljava/lang/String;
    //   689: getstatic com/tencent/liteav/basic/datareport/a.ad : I
    //   692: ldc_w 'u64_err_code'
    //   695: aload_0
    //   696: getfield y : I
    //   699: i2l
    //   700: invokestatic txSetEventIntValue : (Ljava/lang/String;ILjava/lang/String;J)V
    //   703: aload_0
    //   704: getfield J : Ljava/lang/String;
    //   707: getstatic com/tencent/liteav/basic/datareport/a.ad : I
    //   710: ldc_w 'str_err_info'
    //   713: aload_0
    //   714: getfield z : Ljava/lang/String;
    //   717: invokestatic txSetEventValue : (Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V
    //   720: aload_0
    //   721: getfield J : Ljava/lang/String;
    //   724: getstatic com/tencent/liteav/basic/datareport/a.ad : I
    //   727: ldc_w 'u32_video_decode_type'
    //   730: aload_0
    //   731: getfield A : I
    //   734: i2l
    //   735: invokestatic txSetEventIntValue : (Ljava/lang/String;ILjava/lang/String;J)V
    //   738: aload_0
    //   739: getfield J : Ljava/lang/String;
    //   742: getstatic com/tencent/liteav/basic/datareport/a.ad : I
    //   745: ldc_w 'u32_speed'
    //   748: aload_0
    //   749: getfield F : F
    //   752: ldc_w 100.0
    //   755: fmul
    //   756: f2i
    //   757: i2l
    //   758: invokestatic txSetEventIntValue : (Ljava/lang/String;ILjava/lang/String;J)V
    //   761: aload_0
    //   762: getfield J : Ljava/lang/String;
    //   765: getstatic com/tencent/liteav/basic/datareport/a.ad : I
    //   768: invokestatic nativeReportEvent : (Ljava/lang/String;I)V
    //   771: new java/lang/StringBuilder
    //   774: dup
    //   775: invokespecial <init> : ()V
    //   778: astore #10
    //   780: aload #10
    //   782: ldc_w 'report evt 40301: token='
    //   785: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   788: pop
    //   789: aload #10
    //   791: aload_0
    //   792: getfield J : Ljava/lang/String;
    //   795: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   798: pop
    //   799: aload #10
    //   801: ldc_w ' ,'
    //   804: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   807: pop
    //   808: aload #10
    //   810: ldc 'str_device_type'
    //   812: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   815: pop
    //   816: aload #10
    //   818: ldc_w '='
    //   821: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   824: pop
    //   825: aload #10
    //   827: aload #8
    //   829: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   832: pop
    //   833: aload #10
    //   835: ldc_w ' ,'
    //   838: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   841: pop
    //   842: aload #10
    //   844: ldc 'u32_network_type'
    //   846: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   849: pop
    //   850: aload #10
    //   852: ldc_w '='
    //   855: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   858: pop
    //   859: aload #10
    //   861: iload_1
    //   862: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   865: pop
    //   866: aload #10
    //   868: ldc_w ' ,'
    //   871: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   874: pop
    //   875: aload #10
    //   877: ldc 'dev_uuid'
    //   879: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   882: pop
    //   883: aload #10
    //   885: ldc_w '='
    //   888: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   891: pop
    //   892: aload #10
    //   894: aload_0
    //   895: getfield c : Landroid/content/Context;
    //   898: invokestatic f : (Landroid/content/Context;)Ljava/lang/String;
    //   901: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   904: pop
    //   905: aload #10
    //   907: ldc_w ' ,'
    //   910: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   913: pop
    //   914: aload #10
    //   916: ldc 'str_app_version'
    //   918: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   921: pop
    //   922: aload #10
    //   924: ldc_w '='
    //   927: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   930: pop
    //   931: aload #10
    //   933: aload_0
    //   934: getfield r : Ljava/lang/String;
    //   937: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   940: pop
    //   941: aload #10
    //   943: ldc_w ' ,'
    //   946: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   949: pop
    //   950: aload #10
    //   952: ldc 'str_app_name'
    //   954: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   957: pop
    //   958: aload #10
    //   960: ldc_w '='
    //   963: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   966: pop
    //   967: aload #10
    //   969: aload #9
    //   971: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   974: pop
    //   975: aload #10
    //   977: ldc_w ' ,'
    //   980: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   983: pop
    //   984: aload #10
    //   986: getstatic com/tencent/liteav/basic/datareport/a.l : Ljava/lang/String;
    //   989: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   992: pop
    //   993: aload #10
    //   995: ldc_w '='
    //   998: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1001: pop
    //   1002: aload #10
    //   1004: getstatic android/os/Build$VERSION.SDK_INT : I
    //   1007: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   1010: pop
    //   1011: aload #10
    //   1013: ldc_w ' ,'
    //   1016: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1019: pop
    //   1020: aload #10
    //   1022: ldc 'str_stream_url'
    //   1024: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1027: pop
    //   1028: aload #10
    //   1030: ldc_w '='
    //   1033: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1036: pop
    //   1037: aload #10
    //   1039: aload_0
    //   1040: getfield d : Ljava/lang/String;
    //   1043: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1046: pop
    //   1047: aload #10
    //   1049: ldc_w ' ,'
    //   1052: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1055: pop
    //   1056: aload #10
    //   1058: ldc 'str_user_id'
    //   1060: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1063: pop
    //   1064: aload #10
    //   1066: ldc_w '='
    //   1069: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1072: pop
    //   1073: aload #10
    //   1075: aload #6
    //   1077: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1080: pop
    //   1081: aload #10
    //   1083: ldc_w ' ,'
    //   1086: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1089: pop
    //   1090: aload #10
    //   1092: ldc 'str_package_name'
    //   1094: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1097: pop
    //   1098: aload #10
    //   1100: ldc_w '='
    //   1103: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1106: pop
    //   1107: aload #10
    //   1109: aload #7
    //   1111: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1114: pop
    //   1115: aload #10
    //   1117: ldc_w ' ,'
    //   1120: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1123: pop
    //   1124: aload #10
    //   1126: ldc 'u32_timeuse'
    //   1128: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1131: pop
    //   1132: aload #10
    //   1134: ldc_w '='
    //   1137: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1140: pop
    //   1141: aload #10
    //   1143: aload_0
    //   1144: getfield l : I
    //   1147: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   1150: pop
    //   1151: aload #10
    //   1153: ldc_w ' ,'
    //   1156: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1159: pop
    //   1160: aload #10
    //   1162: ldc 'u32_videotime'
    //   1164: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1167: pop
    //   1168: aload #10
    //   1170: ldc_w '='
    //   1173: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1176: pop
    //   1177: aload #10
    //   1179: aload_0
    //   1180: getfield j : I
    //   1183: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   1186: pop
    //   1187: aload #10
    //   1189: ldc_w ' ,'
    //   1192: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1195: pop
    //   1196: aload #10
    //   1198: ldc 'u32_avg_load'
    //   1200: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1203: pop
    //   1204: aload #10
    //   1206: ldc_w '='
    //   1209: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1212: pop
    //   1213: aload_0
    //   1214: getfield o : I
    //   1217: istore_1
    //   1218: iload_1
    //   1219: ifne -> 1227
    //   1222: iconst_0
    //   1223: istore_1
    //   1224: goto -> 1234
    //   1227: aload_0
    //   1228: getfield p : I
    //   1231: iload_1
    //   1232: idiv
    //   1233: istore_1
    //   1234: aload #10
    //   1236: iload_1
    //   1237: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   1240: pop
    //   1241: aload #10
    //   1243: ldc_w ' ,'
    //   1246: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1249: pop
    //   1250: aload #10
    //   1252: ldc 'u32_load_cnt'
    //   1254: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1257: pop
    //   1258: aload #10
    //   1260: ldc_w '='
    //   1263: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1266: pop
    //   1267: aload #10
    //   1269: aload_0
    //   1270: getfield o : I
    //   1273: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   1276: pop
    //   1277: aload #10
    //   1279: ldc_w ' ,'
    //   1282: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1285: pop
    //   1286: aload #10
    //   1288: ldc 'u32_max_load'
    //   1290: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1293: pop
    //   1294: aload #10
    //   1296: ldc_w '='
    //   1299: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1302: pop
    //   1303: aload #10
    //   1305: aload_0
    //   1306: getfield q : I
    //   1309: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   1312: pop
    //   1313: aload #10
    //   1315: ldc_w ' ,'
    //   1318: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1321: pop
    //   1322: aload #10
    //   1324: ldc 'u32_avg_block_time'
    //   1326: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1329: pop
    //   1330: aload #10
    //   1332: ldc_w '='
    //   1335: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1338: pop
    //   1339: aload #10
    //   1341: aload_0
    //   1342: getfield p : I
    //   1345: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   1348: pop
    //   1349: aload #10
    //   1351: ldc_w ' ,'
    //   1354: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1357: pop
    //   1358: aload #10
    //   1360: ldc 'u32_player_type'
    //   1362: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1365: pop
    //   1366: aload #10
    //   1368: ldc_w '='
    //   1371: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1374: pop
    //   1375: aload #10
    //   1377: aload_0
    //   1378: getfield v : I
    //   1381: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   1384: pop
    //   1385: aload #10
    //   1387: ldc_w ' ,'
    //   1390: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1393: pop
    //   1394: aload #10
    //   1396: ldc 'u32_dns_time'
    //   1398: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1401: pop
    //   1402: aload #10
    //   1404: ldc_w '='
    //   1407: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1410: pop
    //   1411: aload #10
    //   1413: aload_0
    //   1414: getfield C : I
    //   1417: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   1420: pop
    //   1421: aload #10
    //   1423: ldc_w ' ,'
    //   1426: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1429: pop
    //   1430: aload #10
    //   1432: ldc 'u32_tcp_did_connect'
    //   1434: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1437: pop
    //   1438: aload #10
    //   1440: ldc_w '='
    //   1443: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1446: pop
    //   1447: aload_0
    //   1448: getfield B : I
    //   1451: istore_1
    //   1452: iload_1
    //   1453: ifle -> 1459
    //   1456: goto -> 1461
    //   1459: iconst_m1
    //   1460: istore_1
    //   1461: aload #10
    //   1463: iload_1
    //   1464: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   1467: pop
    //   1468: aload #10
    //   1470: ldc_w ' ,'
    //   1473: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1476: pop
    //   1477: aload #10
    //   1479: ldc 'u32_first_video_packet'
    //   1481: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1484: pop
    //   1485: aload #10
    //   1487: ldc_w '='
    //   1490: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1493: pop
    //   1494: aload_0
    //   1495: getfield D : I
    //   1498: istore_1
    //   1499: iload_1
    //   1500: ifle -> 1506
    //   1503: goto -> 1508
    //   1506: iconst_m1
    //   1507: istore_1
    //   1508: aload #10
    //   1510: iload_1
    //   1511: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   1514: pop
    //   1515: aload #10
    //   1517: ldc_w ' ,'
    //   1520: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1523: pop
    //   1524: aload #10
    //   1526: ldc 'u32_first_i_frame'
    //   1528: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1531: pop
    //   1532: aload #10
    //   1534: ldc_w '='
    //   1537: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1540: pop
    //   1541: aload #10
    //   1543: aload_0
    //   1544: getfield n : I
    //   1547: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   1550: pop
    //   1551: aload #10
    //   1553: ldc_w ' ,'
    //   1556: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1559: pop
    //   1560: aload #10
    //   1562: ldc_w 'u32_server_ip'
    //   1565: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1568: pop
    //   1569: aload #10
    //   1571: ldc_w '='
    //   1574: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1577: pop
    //   1578: aload #10
    //   1580: aload_0
    //   1581: getfield H : Ljava/lang/String;
    //   1584: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1587: pop
    //   1588: aload #10
    //   1590: ldc_w ' ,'
    //   1593: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1596: pop
    //   1597: aload #10
    //   1599: ldc_w 'u32_drm_type'
    //   1602: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1605: pop
    //   1606: aload #10
    //   1608: ldc_w '='
    //   1611: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1614: pop
    //   1615: aload #10
    //   1617: aload_0
    //   1618: getfield I : Ljava/lang/String;
    //   1621: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1624: pop
    //   1625: aload #10
    //   1627: ldc_w ' ,'
    //   1630: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1633: pop
    //   1634: aload #10
    //   1636: ldc_w 'str_fileid'
    //   1639: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1642: pop
    //   1643: aload #10
    //   1645: ldc_w '='
    //   1648: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1651: pop
    //   1652: aload #10
    //   1654: aload_0
    //   1655: getfield x : Ljava/lang/String;
    //   1658: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1661: pop
    //   1662: aload #10
    //   1664: ldc_w ' ,'
    //   1667: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1670: pop
    //   1671: aload #10
    //   1673: ldc_w 'u32_playmode'
    //   1676: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1679: pop
    //   1680: aload #10
    //   1682: ldc_w '='
    //   1685: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1688: pop
    //   1689: aload #10
    //   1691: aload_0
    //   1692: getfield w : Ljava/lang/String;
    //   1695: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1698: pop
    //   1699: aload #10
    //   1701: ldc_w ' ,'
    //   1704: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1707: pop
    //   1708: aload #10
    //   1710: ldc_w 'u64_err_code'
    //   1713: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1716: pop
    //   1717: aload #10
    //   1719: ldc_w '='
    //   1722: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1725: pop
    //   1726: aload #10
    //   1728: aload_0
    //   1729: getfield y : I
    //   1732: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   1735: pop
    //   1736: aload #10
    //   1738: ldc_w ' ,'
    //   1741: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1744: pop
    //   1745: aload #10
    //   1747: ldc_w 'str_err_info'
    //   1750: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1753: pop
    //   1754: aload #10
    //   1756: ldc_w '='
    //   1759: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1762: pop
    //   1763: aload #10
    //   1765: aload_0
    //   1766: getfield z : Ljava/lang/String;
    //   1769: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1772: pop
    //   1773: aload #10
    //   1775: ldc_w ' ,'
    //   1778: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1781: pop
    //   1782: aload #10
    //   1784: ldc_w 'u32_speed'
    //   1787: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1790: pop
    //   1791: aload #10
    //   1793: ldc_w '='
    //   1796: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1799: pop
    //   1800: aload #10
    //   1802: aload_0
    //   1803: getfield F : F
    //   1806: ldc_w 100.0
    //   1809: fmul
    //   1810: invokevirtual append : (F)Ljava/lang/StringBuilder;
    //   1813: pop
    //   1814: aload #10
    //   1816: ldc_w ' ,'
    //   1819: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1822: pop
    //   1823: aload #10
    //   1825: ldc 'u32_app_id'
    //   1827: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1830: pop
    //   1831: aload #10
    //   1833: ldc_w '='
    //   1836: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1839: pop
    //   1840: aload #10
    //   1842: invokestatic getAppID : ()Ljava/lang/String;
    //   1845: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1848: pop
    //   1849: aload #10
    //   1851: ldc_w ' ,'
    //   1854: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1857: pop
    //   1858: aload #10
    //   1860: ldc_w 'u32_video_decode_type'
    //   1863: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1866: pop
    //   1867: aload #10
    //   1869: ldc_w '='
    //   1872: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1875: pop
    //   1876: aload #10
    //   1878: aload_0
    //   1879: getfield A : I
    //   1882: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   1885: pop
    //   1886: ldc 'TXCVodPlayCollection'
    //   1888: aload #10
    //   1890: invokevirtual toString : ()Ljava/lang/String;
    //   1893: invokestatic i : (Ljava/lang/String;Ljava/lang/String;)V
    //   1896: return
  }
  
  private void n() {
    if (0L == this.f) {
      TXCLog.i("TXCVodPlayCollection", "calculateSegmentPlayTime mBeginPlayTS == 0");
      return;
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("calculateSegmentPlayTime mCurIndexPlayTime= ");
    stringBuilder.append(this.m);
    stringBuilder.append(", mBeginPlayTS=");
    stringBuilder.append(this.f);
    TXCLog.i("TXCVodPlayCollection", stringBuilder.toString());
    this.m += (int)(System.currentTimeMillis() - this.f);
    this.f = System.currentTimeMillis();
    if (this.w.equals("1")) {
      boolean bool = o.a(this.c).b(this.K);
      if (!bool)
        o.a(this.c).c(this.K); 
      if (this.h && bool)
        o(); 
      long l1 = this.l;
      long l2 = this.m;
      this.l = (int)(l1 + l2 / 1000L);
      this.m = l2 % 1000L;
    } 
  }
  
  private void o() {
    // Byte code:
    //   0: ldc 'TXCVodPlayCollection'
    //   2: ldc_w 'onSegmentReport'
    //   5: invokestatic i : (Ljava/lang/String;Ljava/lang/String;)V
    //   8: new com/tencent/liteav/basic/datareport/TXCDRExtInfo
    //   11: dup
    //   12: invokespecial <init> : ()V
    //   15: astore_2
    //   16: aload_2
    //   17: iconst_0
    //   18: putfield report_common : Z
    //   21: aload_2
    //   22: iconst_0
    //   23: putfield report_status : Z
    //   26: aload_2
    //   27: aload_0
    //   28: getfield d : Ljava/lang/String;
    //   31: putfield url : Ljava/lang/String;
    //   34: aload_0
    //   35: getfield c : Landroid/content/Context;
    //   38: aload_0
    //   39: getfield J : Ljava/lang/String;
    //   42: getstatic com/tencent/liteav/basic/datareport/a.ae : I
    //   45: getstatic com/tencent/liteav/basic/datareport/a.at : I
    //   48: aload_2
    //   49: invokestatic InitEvent : (Landroid/content/Context;Ljava/lang/String;IILcom/tencent/liteav/basic/datareport/TXCDRExtInfo;)V
    //   52: invokestatic c : ()Ljava/lang/String;
    //   55: astore #4
    //   57: aload_0
    //   58: getfield J : Ljava/lang/String;
    //   61: getstatic com/tencent/liteav/basic/datareport/a.ae : I
    //   64: ldc 'str_device_type'
    //   66: aload #4
    //   68: invokestatic txSetEventValue : (Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V
    //   71: aload_0
    //   72: getfield c : Landroid/content/Context;
    //   75: invokestatic e : (Landroid/content/Context;)I
    //   78: istore_1
    //   79: aload_0
    //   80: getfield J : Ljava/lang/String;
    //   83: getstatic com/tencent/liteav/basic/datareport/a.ae : I
    //   86: ldc 'u32_network_type'
    //   88: iload_1
    //   89: i2l
    //   90: invokestatic txSetEventIntValue : (Ljava/lang/String;ILjava/lang/String;J)V
    //   93: aload_0
    //   94: getfield c : Landroid/content/Context;
    //   97: invokestatic f : (Landroid/content/Context;)Ljava/lang/String;
    //   100: astore #6
    //   102: aload_0
    //   103: getfield J : Ljava/lang/String;
    //   106: getstatic com/tencent/liteav/basic/datareport/a.ae : I
    //   109: ldc 'dev_uuid'
    //   111: aload #6
    //   113: invokestatic txSetEventValue : (Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V
    //   116: aload_0
    //   117: getfield J : Ljava/lang/String;
    //   120: getstatic com/tencent/liteav/basic/datareport/a.ae : I
    //   123: ldc 'str_app_version'
    //   125: aload_0
    //   126: getfield r : Ljava/lang/String;
    //   129: invokestatic txSetEventValue : (Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V
    //   132: aload_0
    //   133: invokevirtual a : ()Ljava/lang/String;
    //   136: astore #5
    //   138: aload_0
    //   139: getfield J : Ljava/lang/String;
    //   142: getstatic com/tencent/liteav/basic/datareport/a.ae : I
    //   145: ldc 'str_app_name'
    //   147: aload #5
    //   149: invokestatic txSetEventValue : (Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V
    //   152: aload_0
    //   153: getfield J : Ljava/lang/String;
    //   156: getstatic com/tencent/liteav/basic/datareport/a.ae : I
    //   159: getstatic com/tencent/liteav/basic/datareport/a.l : Ljava/lang/String;
    //   162: getstatic android/os/Build$VERSION.SDK_INT : I
    //   165: invokestatic valueOf : (I)Ljava/lang/String;
    //   168: invokestatic txSetEventValue : (Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V
    //   171: aload_0
    //   172: getfield J : Ljava/lang/String;
    //   175: getstatic com/tencent/liteav/basic/datareport/a.ae : I
    //   178: ldc 'str_stream_url'
    //   180: aload_0
    //   181: getfield d : Ljava/lang/String;
    //   184: invokestatic txSetEventValue : (Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V
    //   187: aload_0
    //   188: getfield J : Ljava/lang/String;
    //   191: getstatic com/tencent/liteav/basic/datareport/a.ae : I
    //   194: ldc 'token'
    //   196: aload_0
    //   197: getfield J : Ljava/lang/String;
    //   200: invokestatic txSetEventValue : (Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V
    //   203: invokestatic getUserId : ()Ljava/lang/String;
    //   206: astore_3
    //   207: aload_3
    //   208: ifnull -> 220
    //   211: aload_3
    //   212: astore_2
    //   213: aload_3
    //   214: invokevirtual isEmpty : ()Z
    //   217: ifeq -> 247
    //   220: new java/lang/StringBuilder
    //   223: dup
    //   224: invokespecial <init> : ()V
    //   227: astore_2
    //   228: aload_2
    //   229: ldc '_'
    //   231: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   234: pop
    //   235: aload_2
    //   236: aload #6
    //   238: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   241: pop
    //   242: aload_2
    //   243: invokevirtual toString : ()Ljava/lang/String;
    //   246: astore_2
    //   247: aload_0
    //   248: getfield J : Ljava/lang/String;
    //   251: getstatic com/tencent/liteav/basic/datareport/a.ae : I
    //   254: ldc 'str_user_id'
    //   256: aload_2
    //   257: invokestatic txSetEventValue : (Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V
    //   260: aload_0
    //   261: getfield c : Landroid/content/Context;
    //   264: invokestatic c : (Landroid/content/Context;)Ljava/lang/String;
    //   267: astore_3
    //   268: aload_0
    //   269: getfield J : Ljava/lang/String;
    //   272: getstatic com/tencent/liteav/basic/datareport/a.ae : I
    //   275: ldc 'str_package_name'
    //   277: aload_3
    //   278: invokestatic txSetEventValue : (Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V
    //   281: aload_0
    //   282: getfield J : Ljava/lang/String;
    //   285: getstatic com/tencent/liteav/basic/datareport/a.ad : I
    //   288: ldc 'u32_app_id'
    //   290: aload_0
    //   291: getfield K : Ljava/lang/String;
    //   294: invokestatic txSetEventValue : (Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V
    //   297: aload_0
    //   298: getfield J : Ljava/lang/String;
    //   301: getstatic com/tencent/liteav/basic/datareport/a.ae : I
    //   304: ldc 'u32_videotime'
    //   306: aload_0
    //   307: getfield j : I
    //   310: i2l
    //   311: invokestatic txSetEventIntValue : (Ljava/lang/String;ILjava/lang/String;J)V
    //   314: aload_0
    //   315: getfield J : Ljava/lang/String;
    //   318: getstatic com/tencent/liteav/basic/datareport/a.ae : I
    //   321: ldc 'u32_player_type'
    //   323: aload_0
    //   324: getfield v : I
    //   327: i2l
    //   328: invokestatic txSetEventIntValue : (Ljava/lang/String;ILjava/lang/String;J)V
    //   331: aload_0
    //   332: getfield J : Ljava/lang/String;
    //   335: getstatic com/tencent/liteav/basic/datareport/a.ae : I
    //   338: ldc_w 'u32_server_ip'
    //   341: aload_0
    //   342: getfield H : Ljava/lang/String;
    //   345: invokestatic txSetEventValue : (Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V
    //   348: aload_0
    //   349: getfield J : Ljava/lang/String;
    //   352: getstatic com/tencent/liteav/basic/datareport/a.ae : I
    //   355: ldc_w 'u32_drm_type'
    //   358: aload_0
    //   359: getfield I : Ljava/lang/String;
    //   362: invokestatic txSetEventValue : (Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V
    //   365: aload_0
    //   366: getfield J : Ljava/lang/String;
    //   369: getstatic com/tencent/liteav/basic/datareport/a.ae : I
    //   372: ldc_w 'str_fileid'
    //   375: aload_0
    //   376: getfield x : Ljava/lang/String;
    //   379: invokestatic txSetEventValue : (Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V
    //   382: aload_0
    //   383: getfield J : Ljava/lang/String;
    //   386: getstatic com/tencent/liteav/basic/datareport/a.ae : I
    //   389: ldc_w 'u32_playmode'
    //   392: aload_0
    //   393: getfield w : Ljava/lang/String;
    //   396: invokestatic txSetEventValue : (Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V
    //   399: aload_0
    //   400: getfield J : Ljava/lang/String;
    //   403: getstatic com/tencent/liteav/basic/datareport/a.ae : I
    //   406: ldc_w 'u32_videoindex'
    //   409: aload_0
    //   410: getfield k : I
    //   413: i2l
    //   414: invokestatic txSetEventIntValue : (Ljava/lang/String;ILjava/lang/String;J)V
    //   417: aload_0
    //   418: getfield J : Ljava/lang/String;
    //   421: getstatic com/tencent/liteav/basic/datareport/a.ae : I
    //   424: ldc_w 'u32_realplaytime'
    //   427: aload_0
    //   428: getfield m : J
    //   431: ldc2_w 1000
    //   434: ldiv
    //   435: invokestatic txSetEventIntValue : (Ljava/lang/String;ILjava/lang/String;J)V
    //   438: aload_0
    //   439: getfield J : Ljava/lang/String;
    //   442: getstatic com/tencent/liteav/basic/datareport/a.ae : I
    //   445: ldc_w 'u64_timestamp'
    //   448: invokestatic currentTimeMillis : ()J
    //   451: invokestatic txSetEventIntValue : (Ljava/lang/String;ILjava/lang/String;J)V
    //   454: aload_0
    //   455: getfield J : Ljava/lang/String;
    //   458: getstatic com/tencent/liteav/basic/datareport/a.ae : I
    //   461: ldc_w 'u32_speed'
    //   464: aload_0
    //   465: getfield F : F
    //   468: ldc_w 100.0
    //   471: fmul
    //   472: f2i
    //   473: i2l
    //   474: invokestatic txSetEventIntValue : (Ljava/lang/String;ILjava/lang/String;J)V
    //   477: aload_0
    //   478: getfield J : Ljava/lang/String;
    //   481: getstatic com/tencent/liteav/basic/datareport/a.ae : I
    //   484: ldc_w 'u32_segment_duration'
    //   487: aload_0
    //   488: getfield c : Landroid/content/Context;
    //   491: invokestatic a : (Landroid/content/Context;)Lcom/tencent/liteav/o;
    //   494: aload_0
    //   495: getfield K : Ljava/lang/String;
    //   498: invokevirtual a : (Ljava/lang/String;)I
    //   501: i2l
    //   502: invokestatic txSetEventIntValue : (Ljava/lang/String;ILjava/lang/String;J)V
    //   505: aload_0
    //   506: getfield J : Ljava/lang/String;
    //   509: getstatic com/tencent/liteav/basic/datareport/a.ae : I
    //   512: invokestatic nativeReportEvent : (Ljava/lang/String;I)V
    //   515: new java/lang/StringBuilder
    //   518: dup
    //   519: invokespecial <init> : ()V
    //   522: astore #6
    //   524: aload #6
    //   526: ldc_w 'report evt 40302: token='
    //   529: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   532: pop
    //   533: aload #6
    //   535: aload_0
    //   536: getfield J : Ljava/lang/String;
    //   539: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   542: pop
    //   543: aload #6
    //   545: ldc_w ' ,'
    //   548: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   551: pop
    //   552: aload #6
    //   554: ldc 'str_device_type'
    //   556: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   559: pop
    //   560: aload #6
    //   562: ldc_w '='
    //   565: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   568: pop
    //   569: aload #6
    //   571: aload #4
    //   573: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   576: pop
    //   577: aload #6
    //   579: ldc_w ' ,'
    //   582: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   585: pop
    //   586: aload #6
    //   588: ldc 'u32_network_type'
    //   590: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   593: pop
    //   594: aload #6
    //   596: ldc_w '='
    //   599: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   602: pop
    //   603: aload #6
    //   605: iload_1
    //   606: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   609: pop
    //   610: aload #6
    //   612: ldc_w ' ,'
    //   615: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   618: pop
    //   619: aload #6
    //   621: ldc 'dev_uuid'
    //   623: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   626: pop
    //   627: aload #6
    //   629: ldc_w '='
    //   632: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   635: pop
    //   636: aload #6
    //   638: aload_0
    //   639: getfield c : Landroid/content/Context;
    //   642: invokestatic f : (Landroid/content/Context;)Ljava/lang/String;
    //   645: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   648: pop
    //   649: aload #6
    //   651: ldc_w ' ,'
    //   654: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   657: pop
    //   658: aload #6
    //   660: ldc 'str_app_version'
    //   662: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   665: pop
    //   666: aload #6
    //   668: ldc_w '='
    //   671: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   674: pop
    //   675: aload #6
    //   677: aload_0
    //   678: getfield r : Ljava/lang/String;
    //   681: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   684: pop
    //   685: aload #6
    //   687: ldc_w ' ,'
    //   690: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   693: pop
    //   694: aload #6
    //   696: ldc 'str_app_name'
    //   698: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   701: pop
    //   702: aload #6
    //   704: ldc_w '='
    //   707: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   710: pop
    //   711: aload #6
    //   713: aload #5
    //   715: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   718: pop
    //   719: aload #6
    //   721: ldc_w ' ,'
    //   724: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   727: pop
    //   728: aload #6
    //   730: getstatic com/tencent/liteav/basic/datareport/a.l : Ljava/lang/String;
    //   733: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   736: pop
    //   737: aload #6
    //   739: ldc_w '='
    //   742: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   745: pop
    //   746: aload #6
    //   748: getstatic android/os/Build$VERSION.SDK_INT : I
    //   751: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   754: pop
    //   755: aload #6
    //   757: ldc_w ' ,'
    //   760: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   763: pop
    //   764: aload #6
    //   766: ldc 'str_stream_url'
    //   768: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   771: pop
    //   772: aload #6
    //   774: ldc_w '='
    //   777: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   780: pop
    //   781: aload #6
    //   783: aload_0
    //   784: getfield d : Ljava/lang/String;
    //   787: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   790: pop
    //   791: aload #6
    //   793: ldc_w ' ,'
    //   796: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   799: pop
    //   800: aload #6
    //   802: ldc 'str_user_id'
    //   804: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   807: pop
    //   808: aload #6
    //   810: ldc_w '='
    //   813: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   816: pop
    //   817: aload #6
    //   819: aload_2
    //   820: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   823: pop
    //   824: aload #6
    //   826: ldc_w ' ,'
    //   829: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   832: pop
    //   833: aload #6
    //   835: ldc 'str_package_name'
    //   837: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   840: pop
    //   841: aload #6
    //   843: ldc_w '='
    //   846: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   849: pop
    //   850: aload #6
    //   852: aload_3
    //   853: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   856: pop
    //   857: aload #6
    //   859: ldc_w ' ,'
    //   862: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   865: pop
    //   866: aload #6
    //   868: ldc 'u32_videotime'
    //   870: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   873: pop
    //   874: aload #6
    //   876: ldc_w '='
    //   879: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   882: pop
    //   883: aload #6
    //   885: aload_0
    //   886: getfield j : I
    //   889: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   892: pop
    //   893: aload #6
    //   895: ldc_w ' ,'
    //   898: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   901: pop
    //   902: aload #6
    //   904: ldc 'u32_player_type'
    //   906: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   909: pop
    //   910: aload #6
    //   912: ldc_w '='
    //   915: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   918: pop
    //   919: aload #6
    //   921: aload_0
    //   922: getfield v : I
    //   925: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   928: pop
    //   929: aload #6
    //   931: ldc_w ' ,'
    //   934: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   937: pop
    //   938: aload #6
    //   940: ldc_w 'u32_server_ip'
    //   943: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   946: pop
    //   947: aload #6
    //   949: ldc_w '='
    //   952: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   955: pop
    //   956: aload #6
    //   958: aload_0
    //   959: getfield H : Ljava/lang/String;
    //   962: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   965: pop
    //   966: aload #6
    //   968: ldc_w ' ,'
    //   971: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   974: pop
    //   975: aload #6
    //   977: ldc_w 'u32_drm_type'
    //   980: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   983: pop
    //   984: aload #6
    //   986: ldc_w '='
    //   989: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   992: pop
    //   993: aload #6
    //   995: aload_0
    //   996: getfield I : Ljava/lang/String;
    //   999: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1002: pop
    //   1003: aload #6
    //   1005: ldc_w ' ,'
    //   1008: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1011: pop
    //   1012: aload #6
    //   1014: ldc_w 'str_fileid'
    //   1017: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1020: pop
    //   1021: aload #6
    //   1023: ldc_w '='
    //   1026: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1029: pop
    //   1030: aload #6
    //   1032: aload_0
    //   1033: getfield x : Ljava/lang/String;
    //   1036: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1039: pop
    //   1040: aload #6
    //   1042: ldc_w ' ,'
    //   1045: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1048: pop
    //   1049: aload #6
    //   1051: ldc_w 'u32_playmode'
    //   1054: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1057: pop
    //   1058: aload #6
    //   1060: ldc_w '='
    //   1063: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1066: pop
    //   1067: aload #6
    //   1069: aload_0
    //   1070: getfield w : Ljava/lang/String;
    //   1073: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1076: pop
    //   1077: aload #6
    //   1079: ldc_w ' ,'
    //   1082: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1085: pop
    //   1086: aload #6
    //   1088: ldc_w 'u32_videoindex'
    //   1091: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1094: pop
    //   1095: aload #6
    //   1097: ldc_w '='
    //   1100: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1103: pop
    //   1104: aload #6
    //   1106: aload_0
    //   1107: getfield k : I
    //   1110: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   1113: pop
    //   1114: aload #6
    //   1116: ldc_w ' ,'
    //   1119: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1122: pop
    //   1123: aload #6
    //   1125: ldc_w 'u32_realplaytime'
    //   1128: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1131: pop
    //   1132: aload #6
    //   1134: ldc_w '='
    //   1137: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1140: pop
    //   1141: aload #6
    //   1143: aload_0
    //   1144: getfield m : J
    //   1147: ldc2_w 1000
    //   1150: ldiv
    //   1151: invokevirtual append : (J)Ljava/lang/StringBuilder;
    //   1154: pop
    //   1155: aload #6
    //   1157: ldc_w ' ,'
    //   1160: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1163: pop
    //   1164: aload #6
    //   1166: ldc_w 'u32_speed'
    //   1169: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1172: pop
    //   1173: aload #6
    //   1175: ldc_w '='
    //   1178: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1181: pop
    //   1182: aload #6
    //   1184: aload_0
    //   1185: getfield F : F
    //   1188: ldc_w 100.0
    //   1191: fmul
    //   1192: invokevirtual append : (F)Ljava/lang/StringBuilder;
    //   1195: pop
    //   1196: aload #6
    //   1198: ldc_w ' ,'
    //   1201: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1204: pop
    //   1205: aload #6
    //   1207: ldc 'u32_app_id'
    //   1209: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1212: pop
    //   1213: aload #6
    //   1215: ldc_w '='
    //   1218: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1221: pop
    //   1222: aload #6
    //   1224: invokestatic getAppID : ()Ljava/lang/String;
    //   1227: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1230: pop
    //   1231: aload #6
    //   1233: ldc_w ' ,'
    //   1236: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1239: pop
    //   1240: aload #6
    //   1242: ldc_w 'u64_timestamp'
    //   1245: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1248: pop
    //   1249: aload #6
    //   1251: ldc_w '='
    //   1254: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1257: pop
    //   1258: aload #6
    //   1260: invokestatic currentTimeMillis : ()J
    //   1263: invokevirtual append : (J)Ljava/lang/StringBuilder;
    //   1266: pop
    //   1267: ldc 'TXCVodPlayCollection'
    //   1269: aload #6
    //   1271: invokevirtual toString : ()Ljava/lang/String;
    //   1274: invokestatic i : (Ljava/lang/String;Ljava/lang/String;)V
    //   1277: return
  }
  
  public String a() {
    Context context = this.c;
    ApplicationInfo applicationInfo = context.getApplicationInfo();
    int i = applicationInfo.labelRes;
    return (i == 0) ? applicationInfo.nonLocalizedLabel.toString() : context.getString(i);
  }
  
  public void a(float paramFloat) {
    this.F = paramFloat;
    TXCDRApi.txReportDAU(this.c, a.bA);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("mSpeed = ");
    stringBuilder.append(this.F);
    TXCLog.i("TXCVodPlayCollection", stringBuilder.toString());
  }
  
  public void a(int paramInt) {
    this.v = paramInt;
  }
  
  public void a(int paramInt1, int paramInt2) {
    this.j = paramInt1;
    paramInt1 = paramInt2 / o.a(this.c).a(this.K);
    if (paramInt1 != this.k) {
      this.k = paramInt1;
      n();
    } 
  }
  
  public void a(int paramInt, String paramString) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("errorCode= ");
    stringBuilder.append(paramInt);
    stringBuilder.append(" ，errorInfo= ");
    stringBuilder.append(paramString);
    TXCLog.i("TXCVodPlayCollection", stringBuilder.toString());
    if (this.n == 0) {
      this.y = paramInt;
      this.z = paramString;
      if (this.z == null)
        this.z = ""; 
    } 
  }
  
  public void a(String paramString) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("setUrl: ");
    stringBuilder.append(paramString);
    TXCLog.i("TXCVodPlayCollection", stringBuilder.toString());
    this.d = paramString;
  }
  
  public void a(boolean paramBoolean) {
    this.h = true;
    long l = System.currentTimeMillis();
    this.f = l;
    this.e = l;
    this.l = 0;
    this.m = 0L;
    this.k = 0;
    this.g = 0L;
    this.o = 0;
    this.p = 0;
    this.q = 0;
    if (paramBoolean)
      this.i = false; 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("start ");
    stringBuilder.append(this.f);
    stringBuilder.append(", mIsPaused = ");
    stringBuilder.append(this.i);
    TXCLog.i("TXCVodPlayCollection", stringBuilder.toString());
  }
  
  public void b() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("stop ");
    stringBuilder.append(this.m);
    TXCLog.i("TXCVodPlayCollection", stringBuilder.toString());
    if (this.i)
      this.f = System.currentTimeMillis(); 
    if (this.h) {
      n();
      this.l = (int)(this.l + this.m / 1000L);
      this.m = 0L;
      m();
      this.h = false;
    } 
    this.s = false;
    this.t = false;
    this.i = false;
  }
  
  public void b(int paramInt) {
    this.A = paramInt;
  }
  
  public void b(String paramString) {
    this.w = paramString;
  }
  
  public void b(boolean paramBoolean) {
    if (paramBoolean) {
      this.E = 1;
      TXCDRApi.txReportDAU(this.c, a.bB);
    } else {
      this.E = 0;
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("mIsMirror= ");
    stringBuilder.append(this.E);
    TXCLog.i("TXCVodPlayCollection", stringBuilder.toString());
  }
  
  public void c() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("pause ");
    stringBuilder.append(this.m);
    TXCLog.i("TXCVodPlayCollection", stringBuilder.toString());
    if (!this.i)
      this.m += System.currentTimeMillis() - this.f; 
    this.i = true;
    this.f = System.currentTimeMillis();
  }
  
  public void c(String paramString) {
    this.I = paramString;
  }
  
  public void d() {
    this.f = System.currentTimeMillis();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("resume ");
    stringBuilder.append(this.f);
    TXCLog.i("TXCVodPlayCollection", stringBuilder.toString());
    this.i = false;
  }
  
  public void d(String paramString) {
    this.x = paramString;
  }
  
  public void e() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("setLoadEnd mFirstFrame=");
    stringBuilder.append(this.n);
    stringBuilder.append(" , mIsLoading = ");
    stringBuilder.append(this.t);
    stringBuilder.append(",mBeginLoadTS = ");
    stringBuilder.append(this.g);
    TXCLog.i("TXCVodPlayCollection", stringBuilder.toString());
    if (this.n != 0 && this.t) {
      int i = (int)(System.currentTimeMillis() - this.g);
      this.p += i;
      this.o++;
      if (this.q < i)
        this.q = i; 
      this.t = false;
    } 
    if (this.s)
      this.s = false; 
  }
  
  public void e(String paramString) {
    this.H = paramString;
    if (this.H == null)
      this.H = ""; 
  }
  
  public void f() {
    TXCLog.i("TXCVodPlayCollection", "renderStart");
    if (this.n == 0)
      this.n = (int)(System.currentTimeMillis() - this.e); 
  }
  
  public void f(String paramString) {
    this.K = paramString;
  }
  
  public void g() {
    if (this.B == 0) {
      this.B = (int)(System.currentTimeMillis() - this.e);
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("mTcpConnectTS = ");
      stringBuilder.append(this.B);
      stringBuilder.append(", mOriginBeginPlayTS = ");
      stringBuilder.append(this.e);
      stringBuilder.append(", ");
      stringBuilder.append(System.currentTimeMillis());
      TXCLog.i("TXCVodPlayCollection", stringBuilder.toString());
    } 
  }
  
  public void h() {
    if (this.C == 0)
      this.C = (int)(System.currentTimeMillis() - this.e); 
  }
  
  public void i() {
    if (this.D == 0)
      this.D = (int)(System.currentTimeMillis() - this.e); 
  }
  
  public void j() {
    this.g = System.currentTimeMillis();
    this.t = true;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("setLoadBegin mBeginLoadTS= ");
    stringBuilder.append(this.g);
    TXCLog.i("TXCVodPlayCollection", stringBuilder.toString());
  }
  
  public void k() {
    this.s = true;
    this.u++;
    TXCDRApi.txReportDAU(this.c, a.bz);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("mSeekCnt= ");
    stringBuilder.append(this.u);
    TXCLog.d("TXCVodPlayCollection", stringBuilder.toString());
  }
  
  public void l() {
    this.G++;
    TXCDRApi.txReportDAU(this.c, a.bC);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("mSetBitrateIndexCnt= ");
    stringBuilder.append(this.G);
    TXCLog.d("TXCVodPlayCollection", stringBuilder.toString());
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\tencent\liteav\n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */