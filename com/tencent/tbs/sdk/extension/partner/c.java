package com.tencent.tbs.sdk.extension.partner;

import android.content.Context;
import com.tencent.tbs.sdk.extension.TbsSDKExtension;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class c {
  private static c a;
  
  private long b;
  
  private boolean c;
  
  private boolean d;
  
  private int e;
  
  private int f;
  
  private String g;
  
  private int h;
  
  private String i;
  
  private int j;
  
  private int k;
  
  private String l;
  
  private int m = -1;
  
  private String n = null;
  
  private int o = 0;
  
  private boolean p = false;
  
  private Context q;
  
  private int r = 0;
  
  private long s = 0L;
  
  private int t = 0;
  
  private c(Context paramContext) {
    this.q = paramContext.getApplicationContext();
    if (this.q == null)
      this.q = paramContext; 
    s();
  }
  
  public static c a(Context paramContext) {
    // Byte code:
    //   0: ldc com/tencent/tbs/sdk/extension/partner/c
    //   2: monitorenter
    //   3: getstatic com/tencent/tbs/sdk/extension/partner/c.a : Lcom/tencent/tbs/sdk/extension/partner/c;
    //   6: ifnonnull -> 20
    //   9: new com/tencent/tbs/sdk/extension/partner/c
    //   12: dup
    //   13: aload_0
    //   14: invokespecial <init> : (Landroid/content/Context;)V
    //   17: putstatic com/tencent/tbs/sdk/extension/partner/c.a : Lcom/tencent/tbs/sdk/extension/partner/c;
    //   20: getstatic com/tencent/tbs/sdk/extension/partner/c.a : Lcom/tencent/tbs/sdk/extension/partner/c;
    //   23: astore_0
    //   24: ldc com/tencent/tbs/sdk/extension/partner/c
    //   26: monitorexit
    //   27: aload_0
    //   28: areturn
    //   29: astore_0
    //   30: ldc com/tencent/tbs/sdk/extension/partner/c
    //   32: monitorexit
    //   33: aload_0
    //   34: athrow
    // Exception table:
    //   from	to	target	type
    //   3	20	29	finally
    //   20	24	29	finally
  }
  
  private void f(int paramInt) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: iload_1
    //   4: putfield e : I
    //   7: aload_0
    //   8: monitorexit
    //   9: return
    //   10: astore_2
    //   11: aload_0
    //   12: monitorexit
    //   13: aload_2
    //   14: athrow
    // Exception table:
    //   from	to	target	type
    //   2	7	10	finally
  }
  
  private void s() {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: aconst_null
    //   3: astore_3
    //   4: new java/io/File
    //   7: dup
    //   8: aload_0
    //   9: getfield q : Landroid/content/Context;
    //   12: invokestatic getTbsFolderDir : (Landroid/content/Context;)Ljava/io/File;
    //   15: ldc 'core_private'
    //   17: invokespecial <init> : (Ljava/io/File;Ljava/lang/String;)V
    //   20: astore #4
    //   22: aload #4
    //   24: invokevirtual exists : ()Z
    //   27: ifne -> 39
    //   30: aload #4
    //   32: invokevirtual mkdir : ()Z
    //   35: pop
    //   36: goto -> 56
    //   39: aload #4
    //   41: invokevirtual isFile : ()Z
    //   44: ifeq -> 56
    //   47: aload #4
    //   49: invokevirtual delete : ()Z
    //   52: pop
    //   53: goto -> 30
    //   56: aload #4
    //   58: invokevirtual isDirectory : ()Z
    //   61: ifeq -> 618
    //   64: new java/io/File
    //   67: dup
    //   68: aload #4
    //   70: ldc 'tbs_extension.conf'
    //   72: invokespecial <init> : (Ljava/io/File;Ljava/lang/String;)V
    //   75: astore_2
    //   76: aload_2
    //   77: invokevirtual exists : ()Z
    //   80: ifne -> 140
    //   83: aload_0
    //   84: invokestatic a : ()I
    //   87: putfield k : I
    //   90: aload_0
    //   91: aload_0
    //   92: invokevirtual p : ()Ljava/lang/String;
    //   95: putfield l : Ljava/lang/String;
    //   98: new java/lang/StringBuilder
    //   101: dup
    //   102: invokespecial <init> : ()V
    //   105: astore_2
    //   106: aload_2
    //   107: ldc 'extensionConfig - mTotalRam1:'
    //   109: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   112: pop
    //   113: aload_2
    //   114: aload_0
    //   115: getfield k : I
    //   118: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   121: pop
    //   122: ldc 'TbsSDKExtensionConfig'
    //   124: aload_2
    //   125: invokevirtual toString : ()Ljava/lang/String;
    //   128: invokestatic b : (Ljava/lang/String;Ljava/lang/String;)V
    //   131: aload_0
    //   132: invokevirtual o : ()V
    //   135: aconst_null
    //   136: astore_2
    //   137: goto -> 510
    //   140: new java/io/FileInputStream
    //   143: dup
    //   144: aload_2
    //   145: invokespecial <init> : (Ljava/io/File;)V
    //   148: astore_2
    //   149: new java/io/BufferedInputStream
    //   152: dup
    //   153: aload_2
    //   154: invokespecial <init> : (Ljava/io/InputStream;)V
    //   157: astore_3
    //   158: new java/util/Properties
    //   161: dup
    //   162: invokespecial <init> : ()V
    //   165: astore #4
    //   167: aload #4
    //   169: aload_3
    //   170: invokevirtual load : (Ljava/io/InputStream;)V
    //   173: aload_0
    //   174: aload #4
    //   176: ldc 'last_check'
    //   178: invokevirtual getProperty : (Ljava/lang/String;)Ljava/lang/String;
    //   181: invokestatic parseLong : (Ljava/lang/String;)J
    //   184: putfield b : J
    //   187: aload_0
    //   188: aload #4
    //   190: ldc 'x5_disabled'
    //   192: invokevirtual getProperty : (Ljava/lang/String;)Ljava/lang/String;
    //   195: invokestatic parseBoolean : (Ljava/lang/String;)Z
    //   198: putfield c : Z
    //   201: aload_0
    //   202: aload #4
    //   204: ldc 'video_disabled'
    //   206: invokevirtual getProperty : (Ljava/lang/String;)Ljava/lang/String;
    //   209: invokestatic parseBoolean : (Ljava/lang/String;)Z
    //   212: putfield d : Z
    //   215: aload_0
    //   216: aload #4
    //   218: ldc 'tbs_local_version'
    //   220: invokevirtual getProperty : (Ljava/lang/String;)Ljava/lang/String;
    //   223: invokestatic parseInt : (Ljava/lang/String;)I
    //   226: putfield e : I
    //   229: aload_0
    //   230: aload #4
    //   232: ldc 'tbs_download_version'
    //   234: invokevirtual getProperty : (Ljava/lang/String;)Ljava/lang/String;
    //   237: invokestatic parseInt : (Ljava/lang/String;)I
    //   240: putfield f : I
    //   243: aload_0
    //   244: aload #4
    //   246: ldc 'app_versionname'
    //   248: invokevirtual getProperty : (Ljava/lang/String;)Ljava/lang/String;
    //   251: putfield g : Ljava/lang/String;
    //   254: aload_0
    //   255: aload #4
    //   257: ldc 'app_versioncode'
    //   259: invokevirtual getProperty : (Ljava/lang/String;)Ljava/lang/String;
    //   262: invokestatic parseInt : (Ljava/lang/String;)I
    //   265: putfield h : I
    //   268: aload_0
    //   269: aload #4
    //   271: ldc 'app_metadata'
    //   273: invokevirtual getProperty : (Ljava/lang/String;)Ljava/lang/String;
    //   276: putfield i : Ljava/lang/String;
    //   279: aload_0
    //   280: aload #4
    //   282: ldc 'app_versioncode_for_switch'
    //   284: invokevirtual getProperty : (Ljava/lang/String;)Ljava/lang/String;
    //   287: invokestatic parseInt : (Ljava/lang/String;)I
    //   290: putfield j : I
    //   293: aload_0
    //   294: aload #4
    //   296: ldc 'device_total_ram'
    //   298: invokevirtual getProperty : (Ljava/lang/String;)Ljava/lang/String;
    //   301: invokestatic parseInt : (Ljava/lang/String;)I
    //   304: putfield k : I
    //   307: aload_0
    //   308: aload #4
    //   310: ldc 'tbscore_version_string'
    //   312: invokevirtual getProperty : (Ljava/lang/String;)Ljava/lang/String;
    //   315: putfield l : Ljava/lang/String;
    //   318: aload_0
    //   319: aload #4
    //   321: ldc 'tbs_last_disabled_time'
    //   323: ldc '0'
    //   325: invokevirtual getProperty : (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   328: invokestatic parseLong : (Ljava/lang/String;)J
    //   331: putfield s : J
    //   334: aload_0
    //   335: aload #4
    //   337: ldc 'tbs_last_disabled_version'
    //   339: ldc '0'
    //   341: invokevirtual getProperty : (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   344: invokestatic parseInt : (Ljava/lang/String;)I
    //   347: putfield r : I
    //   350: aload_0
    //   351: aload #4
    //   353: ldc 'tbs_exception_info_retry_times'
    //   355: ldc '0'
    //   357: invokevirtual getProperty : (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   360: invokestatic parseInt : (Ljava/lang/String;)I
    //   363: putfield t : I
    //   366: new java/lang/StringBuilder
    //   369: dup
    //   370: invokespecial <init> : ()V
    //   373: astore #5
    //   375: aload #5
    //   377: ldc 'extensionConfig - mTotalRam2:'
    //   379: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   382: pop
    //   383: aload #5
    //   385: aload_0
    //   386: getfield k : I
    //   389: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   392: pop
    //   393: ldc 'TbsSDKExtensionConfig'
    //   395: aload #5
    //   397: invokevirtual toString : ()Ljava/lang/String;
    //   400: invokestatic b : (Ljava/lang/String;Ljava/lang/String;)V
    //   403: aload_0
    //   404: getfield l : Ljava/lang/String;
    //   407: invokestatic parseInt : (Ljava/lang/String;)I
    //   410: ldc 88888888
    //   412: if_icmpeq -> 439
    //   415: ldc '044800'
    //   417: aload_0
    //   418: getfield l : Ljava/lang/String;
    //   421: invokevirtual equals : (Ljava/lang/Object;)Z
    //   424: ifne -> 439
    //   427: aload_0
    //   428: aload_0
    //   429: invokevirtual p : ()Ljava/lang/String;
    //   432: putfield l : Ljava/lang/String;
    //   435: aload_0
    //   436: invokevirtual o : ()V
    //   439: aload_0
    //   440: aload #4
    //   442: ldc 'tbs_commands'
    //   444: invokevirtual getProperty : (Ljava/lang/String;)Ljava/lang/String;
    //   447: invokestatic parseInt : (Ljava/lang/String;)I
    //   450: putfield m : I
    //   453: aload_0
    //   454: aload #4
    //   456: ldc 'tbs_cmd_args'
    //   458: invokevirtual getProperty : (Ljava/lang/String;)Ljava/lang/String;
    //   461: putfield n : Ljava/lang/String;
    //   464: aload_0
    //   465: aload #4
    //   467: ldc 'tbs_cmd_start_index'
    //   469: invokevirtual getProperty : (Ljava/lang/String;)Ljava/lang/String;
    //   472: invokestatic parseInt : (Ljava/lang/String;)I
    //   475: putfield o : I
    //   478: aload_0
    //   479: aload #4
    //   481: ldc 'tbs_cmd_file_replace'
    //   483: invokevirtual getProperty : (Ljava/lang/String;)Ljava/lang/String;
    //   486: invokestatic parseBoolean : (Ljava/lang/String;)Z
    //   489: putfield p : Z
    //   492: goto -> 502
    //   495: astore #4
    //   497: aload #4
    //   499: invokevirtual printStackTrace : ()V
    //   502: aload_2
    //   503: astore #4
    //   505: aload_3
    //   506: astore_2
    //   507: aload #4
    //   509: astore_3
    //   510: aload_0
    //   511: getfield k : I
    //   514: ifne -> 524
    //   517: invokestatic a : ()I
    //   520: istore_1
    //   521: goto -> 529
    //   524: aload_0
    //   525: getfield k : I
    //   528: istore_1
    //   529: aload_0
    //   530: iload_1
    //   531: putfield k : I
    //   534: new java/lang/StringBuilder
    //   537: dup
    //   538: invokespecial <init> : ()V
    //   541: astore #4
    //   543: aload #4
    //   545: ldc 'extensionConfig - mTotalRam3:'
    //   547: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   550: pop
    //   551: aload #4
    //   553: aload_0
    //   554: getfield k : I
    //   557: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   560: pop
    //   561: ldc 'TbsSDKExtensionConfig'
    //   563: aload #4
    //   565: invokevirtual toString : ()Ljava/lang/String;
    //   568: invokestatic b : (Ljava/lang/String;Ljava/lang/String;)V
    //   571: goto -> 692
    //   574: astore #4
    //   576: aload_3
    //   577: astore #5
    //   579: aload_2
    //   580: astore_3
    //   581: aload #5
    //   583: astore_2
    //   584: goto -> 610
    //   587: aload_3
    //   588: astore #4
    //   590: aload_2
    //   591: astore_3
    //   592: aload #4
    //   594: astore_2
    //   595: goto -> 788
    //   598: astore #4
    //   600: goto -> 736
    //   603: goto -> 788
    //   606: astore #4
    //   608: aconst_null
    //   609: astore_3
    //   610: goto -> 736
    //   613: aconst_null
    //   614: astore_3
    //   615: goto -> 788
    //   618: aload_0
    //   619: invokestatic a : ()I
    //   622: putfield k : I
    //   625: new java/lang/StringBuilder
    //   628: dup
    //   629: invokespecial <init> : ()V
    //   632: astore_3
    //   633: aload_3
    //   634: ldc 'extensionConfig - mTotalRam4:'
    //   636: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   639: pop
    //   640: aload_3
    //   641: aload_0
    //   642: getfield k : I
    //   645: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   648: pop
    //   649: aload_3
    //   650: ldc '; configPath: '
    //   652: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   655: pop
    //   656: aload_3
    //   657: aload #4
    //   659: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   662: pop
    //   663: aload_3
    //   664: ldc_w '; pathExists: '
    //   667: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   670: pop
    //   671: aload_3
    //   672: aload #4
    //   674: invokevirtual exists : ()Z
    //   677: invokevirtual append : (Z)Ljava/lang/StringBuilder;
    //   680: pop
    //   681: ldc 'TbsSDKExtensionConfig'
    //   683: aload_3
    //   684: invokevirtual toString : ()Ljava/lang/String;
    //   687: invokestatic b : (Ljava/lang/String;Ljava/lang/String;)V
    //   690: aconst_null
    //   691: astore_3
    //   692: aload_0
    //   693: getfield k : I
    //   696: ifne -> 710
    //   699: aload_0
    //   700: invokestatic a : ()I
    //   703: putfield k : I
    //   706: aload_0
    //   707: invokevirtual o : ()V
    //   710: aload_2
    //   711: ifnull -> 721
    //   714: aload_2
    //   715: invokevirtual close : ()V
    //   718: goto -> 721
    //   721: aload_3
    //   722: ifnull -> 831
    //   725: aload_3
    //   726: invokevirtual close : ()V
    //   729: return
    //   730: astore #4
    //   732: aconst_null
    //   733: astore_2
    //   734: aload_2
    //   735: astore_3
    //   736: aload_0
    //   737: getfield k : I
    //   740: ifne -> 754
    //   743: aload_0
    //   744: invokestatic a : ()I
    //   747: putfield k : I
    //   750: aload_0
    //   751: invokevirtual o : ()V
    //   754: aload_3
    //   755: ifnull -> 765
    //   758: aload_3
    //   759: invokevirtual close : ()V
    //   762: goto -> 765
    //   765: aload_2
    //   766: ifnull -> 781
    //   769: aload_2
    //   770: invokevirtual close : ()V
    //   773: goto -> 781
    //   776: astore_2
    //   777: aload_2
    //   778: invokevirtual printStackTrace : ()V
    //   781: aload #4
    //   783: athrow
    //   784: aconst_null
    //   785: astore_3
    //   786: aload_3
    //   787: astore_2
    //   788: aload_0
    //   789: getfield k : I
    //   792: ifne -> 806
    //   795: aload_0
    //   796: invokestatic a : ()I
    //   799: putfield k : I
    //   802: aload_0
    //   803: invokevirtual o : ()V
    //   806: aload_3
    //   807: ifnull -> 817
    //   810: aload_3
    //   811: invokevirtual close : ()V
    //   814: goto -> 817
    //   817: aload_2
    //   818: ifnull -> 831
    //   821: aload_2
    //   822: invokevirtual close : ()V
    //   825: return
    //   826: astore_2
    //   827: aload_2
    //   828: invokevirtual printStackTrace : ()V
    //   831: return
    //   832: astore_2
    //   833: goto -> 784
    //   836: astore_3
    //   837: goto -> 613
    //   840: astore #4
    //   842: goto -> 603
    //   845: astore #4
    //   847: goto -> 587
    //   850: astore_2
    //   851: goto -> 721
    //   854: astore_3
    //   855: goto -> 765
    //   858: astore_3
    //   859: goto -> 817
    // Exception table:
    //   from	to	target	type
    //   4	30	832	java/lang/Exception
    //   4	30	730	finally
    //   30	36	832	java/lang/Exception
    //   30	36	730	finally
    //   39	53	832	java/lang/Exception
    //   39	53	730	finally
    //   56	135	832	java/lang/Exception
    //   56	135	730	finally
    //   140	149	832	java/lang/Exception
    //   140	149	730	finally
    //   149	158	836	java/lang/Exception
    //   149	158	606	finally
    //   158	439	840	java/lang/Exception
    //   158	439	598	finally
    //   439	492	495	java/lang/Exception
    //   439	492	598	finally
    //   497	502	840	java/lang/Exception
    //   497	502	598	finally
    //   510	521	845	java/lang/Exception
    //   510	521	574	finally
    //   524	529	845	java/lang/Exception
    //   524	529	574	finally
    //   529	571	845	java/lang/Exception
    //   529	571	574	finally
    //   618	690	832	java/lang/Exception
    //   618	690	730	finally
    //   714	718	850	java/io/IOException
    //   725	729	826	java/io/IOException
    //   758	762	854	java/io/IOException
    //   769	773	776	java/io/IOException
    //   810	814	858	java/io/IOException
    //   821	825	826	java/io/IOException
  }
  
  private int t() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield e : I
    //   6: istore_1
    //   7: aload_0
    //   8: monitorexit
    //   9: iload_1
    //   10: ireturn
    //   11: astore_2
    //   12: aload_0
    //   13: monitorexit
    //   14: aload_2
    //   15: athrow
    // Exception table:
    //   from	to	target	type
    //   2	7	11	finally
  }
  
  public int a() {
    return this.m;
  }
  
  public void a(int paramInt) {
    this.m = paramInt;
  }
  
  public void a(int paramInt, Boolean paramBoolean) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: aload_0
    //   4: invokevirtual k : ()I
    //   7: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   10: invokevirtual b : (Ljava/lang/Integer;)V
    //   13: aload_0
    //   14: iload_1
    //   15: invokespecial f : (I)V
    //   18: aload_0
    //   19: aload_2
    //   20: invokevirtual booleanValue : ()Z
    //   23: putfield c : Z
    //   26: aload_0
    //   27: monitorexit
    //   28: return
    //   29: astore_2
    //   30: aload_0
    //   31: monitorexit
    //   32: aload_2
    //   33: athrow
    // Exception table:
    //   from	to	target	type
    //   2	26	29	finally
  }
  
  public void a(long paramLong) {
    this.s = paramLong;
  }
  
  public void a(Boolean paramBoolean) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: aload_1
    //   4: invokevirtual booleanValue : ()Z
    //   7: putfield d : Z
    //   10: aload_0
    //   11: monitorexit
    //   12: return
    //   13: astore_1
    //   14: aload_0
    //   15: monitorexit
    //   16: aload_1
    //   17: athrow
    // Exception table:
    //   from	to	target	type
    //   2	10	13	finally
  }
  
  public void a(Integer paramInteger) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: aload_1
    //   4: invokevirtual intValue : ()I
    //   7: putfield h : I
    //   10: aload_0
    //   11: monitorexit
    //   12: return
    //   13: astore_1
    //   14: aload_0
    //   15: monitorexit
    //   16: aload_1
    //   17: athrow
    // Exception table:
    //   from	to	target	type
    //   2	10	13	finally
  }
  
  public void a(Long paramLong) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: aload_1
    //   4: invokevirtual longValue : ()J
    //   7: putfield b : J
    //   10: aload_0
    //   11: monitorexit
    //   12: return
    //   13: astore_1
    //   14: aload_0
    //   15: monitorexit
    //   16: aload_1
    //   17: athrow
    // Exception table:
    //   from	to	target	type
    //   2	10	13	finally
  }
  
  public void a(String paramString) {
    this.n = paramString;
  }
  
  public void a(boolean paramBoolean) {
    this.p = paramBoolean;
  }
  
  public String b() {
    return this.n;
  }
  
  public void b(int paramInt) {
    this.o = paramInt;
  }
  
  public void b(Integer paramInteger) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: aload_1
    //   4: invokevirtual intValue : ()I
    //   7: putfield j : I
    //   10: aload_0
    //   11: monitorexit
    //   12: return
    //   13: astore_1
    //   14: aload_0
    //   15: monitorexit
    //   16: aload_1
    //   17: athrow
    // Exception table:
    //   from	to	target	type
    //   2	10	13	finally
  }
  
  public void b(String paramString) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: aload_1
    //   4: putfield g : Ljava/lang/String;
    //   7: aload_0
    //   8: monitorexit
    //   9: return
    //   10: astore_1
    //   11: aload_0
    //   12: monitorexit
    //   13: aload_1
    //   14: athrow
    // Exception table:
    //   from	to	target	type
    //   2	7	10	finally
  }
  
  public int c() {
    return this.o;
  }
  
  public void c(int paramInt) {
    this.r = paramInt;
  }
  
  public void c(String paramString) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: aload_1
    //   4: putfield i : Ljava/lang/String;
    //   7: aload_0
    //   8: monitorexit
    //   9: return
    //   10: astore_1
    //   11: aload_0
    //   12: monitorexit
    //   13: aload_1
    //   14: athrow
    // Exception table:
    //   from	to	target	type
    //   2	7	10	finally
  }
  
  public String d(String paramString) {
    String str = null;
    Exception exception2 = null;
    try {
      null = new File(TbsSDKExtension.getTbsFolderDir(this.q), paramString);
      if (!null.exists() || !null.isDirectory())
        return "0"; 
      null = new File(null, "tbs.conf");
      if (!null.exists())
        return "0"; 
    } catch (Exception exception) {
    
    } finally {
      FileInputStream fileInputStream = null;
      if (exception1 != null)
        try {
          exception1.close();
        } catch (IOException iOException1) {} 
      if (fileInputStream != null)
        try {
          fileInputStream.close();
        } catch (IOException iOException) {
          iOException.printStackTrace();
        }  
    } 
    if (paramString != null)
      try {
        paramString.close();
      } catch (IOException iOException1) {} 
    if (iOException != null)
      try {
        iOException.close();
        return "0";
      } catch (IOException iOException1) {
        iOException1.printStackTrace();
      }  
    return "0";
  }
  
  public boolean d() {
    return this.p;
  }
  
  public boolean d(int paramInt) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokespecial t : ()I
    //   6: istore_2
    //   7: iconst_0
    //   8: istore #4
    //   10: iload #4
    //   12: istore_3
    //   13: iload_1
    //   14: ldc 88888888
    //   16: if_icmpeq -> 73
    //   19: iload_2
    //   20: ldc 88888888
    //   22: if_icmpne -> 84
    //   25: iload #4
    //   27: istore_3
    //   28: goto -> 73
    //   31: iload_1
    //   32: iload_2
    //   33: if_icmpne -> 71
    //   36: aload_0
    //   37: getfield j : I
    //   40: ifle -> 63
    //   43: aload_0
    //   44: getfield j : I
    //   47: aload_0
    //   48: getfield q : Landroid/content/Context;
    //   51: invokestatic b : (Landroid/content/Context;)I
    //   54: if_icmpeq -> 63
    //   57: iload #4
    //   59: istore_3
    //   60: goto -> 73
    //   63: aload_0
    //   64: getfield c : Z
    //   67: istore_3
    //   68: goto -> 73
    //   71: iconst_1
    //   72: istore_3
    //   73: aload_0
    //   74: monitorexit
    //   75: iload_3
    //   76: ireturn
    //   77: astore #5
    //   79: aload_0
    //   80: monitorexit
    //   81: aload #5
    //   83: athrow
    //   84: iload_1
    //   85: iload_2
    //   86: if_icmple -> 31
    //   89: iload #4
    //   91: istore_3
    //   92: goto -> 73
    // Exception table:
    //   from	to	target	type
    //   2	7	77	finally
    //   36	57	77	finally
    //   63	68	77	finally
  }
  
  public int e() {
    return this.r;
  }
  
  public void e(int paramInt) {
    this.t = paramInt;
  }
  
  public long f() {
    return this.s;
  }
  
  public boolean g() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield d : Z
    //   6: istore_1
    //   7: aload_0
    //   8: monitorexit
    //   9: iload_1
    //   10: ireturn
    //   11: astore_2
    //   12: aload_0
    //   13: monitorexit
    //   14: aload_2
    //   15: athrow
    // Exception table:
    //   from	to	target	type
    //   2	7	11	finally
  }
  
  public int h() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield f : I
    //   6: istore_1
    //   7: aload_0
    //   8: monitorexit
    //   9: iload_1
    //   10: ireturn
    //   11: astore_2
    //   12: aload_0
    //   13: monitorexit
    //   14: aload_2
    //   15: athrow
    // Exception table:
    //   from	to	target	type
    //   2	7	11	finally
  }
  
  public long i() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield b : J
    //   6: lstore_1
    //   7: aload_0
    //   8: monitorexit
    //   9: lload_1
    //   10: lreturn
    //   11: astore_3
    //   12: aload_0
    //   13: monitorexit
    //   14: aload_3
    //   15: athrow
    // Exception table:
    //   from	to	target	type
    //   2	7	11	finally
  }
  
  public String j() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield g : Ljava/lang/String;
    //   6: astore_1
    //   7: aload_0
    //   8: monitorexit
    //   9: aload_1
    //   10: areturn
    //   11: astore_1
    //   12: aload_0
    //   13: monitorexit
    //   14: aload_1
    //   15: athrow
    // Exception table:
    //   from	to	target	type
    //   2	7	11	finally
  }
  
  public int k() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield h : I
    //   6: istore_1
    //   7: aload_0
    //   8: monitorexit
    //   9: iload_1
    //   10: ireturn
    //   11: astore_2
    //   12: aload_0
    //   13: monitorexit
    //   14: aload_2
    //   15: athrow
    // Exception table:
    //   from	to	target	type
    //   2	7	11	finally
  }
  
  public String l() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield i : Ljava/lang/String;
    //   6: astore_1
    //   7: aload_0
    //   8: monitorexit
    //   9: aload_1
    //   10: areturn
    //   11: astore_1
    //   12: aload_0
    //   13: monitorexit
    //   14: aload_1
    //   15: athrow
    // Exception table:
    //   from	to	target	type
    //   2	7	11	finally
  }
  
  public int m() {
    return this.k;
  }
  
  public String n() {
    return this.l;
  }
  
  public void o() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aconst_null
    //   3: astore #6
    //   5: aconst_null
    //   6: astore_3
    //   7: aconst_null
    //   8: astore_2
    //   9: aconst_null
    //   10: astore #4
    //   12: new java/io/File
    //   15: dup
    //   16: aload_0
    //   17: getfield q : Landroid/content/Context;
    //   20: invokestatic getTbsFolderDir : (Landroid/content/Context;)Ljava/io/File;
    //   23: ldc 'core_private'
    //   25: invokespecial <init> : (Ljava/io/File;Ljava/lang/String;)V
    //   28: astore_1
    //   29: aload_1
    //   30: invokevirtual isDirectory : ()Z
    //   33: ifeq -> 451
    //   36: new java/io/File
    //   39: dup
    //   40: aload_1
    //   41: ldc 'tbs_extension.conf'
    //   43: invokespecial <init> : (Ljava/io/File;Ljava/lang/String;)V
    //   46: astore #4
    //   48: aload #4
    //   50: invokevirtual exists : ()Z
    //   53: ifne -> 62
    //   56: aload #4
    //   58: invokevirtual createNewFile : ()Z
    //   61: pop
    //   62: new java/util/Properties
    //   65: dup
    //   66: invokespecial <init> : ()V
    //   69: astore #5
    //   71: aload #5
    //   73: ldc 'last_check'
    //   75: aload_0
    //   76: getfield b : J
    //   79: invokestatic valueOf : (J)Ljava/lang/String;
    //   82: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   85: pop
    //   86: aload #5
    //   88: ldc 'x5_disabled'
    //   90: aload_0
    //   91: getfield c : Z
    //   94: invokestatic valueOf : (Z)Ljava/lang/String;
    //   97: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   100: pop
    //   101: aload #5
    //   103: ldc 'video_disabled'
    //   105: aload_0
    //   106: getfield d : Z
    //   109: invokestatic valueOf : (Z)Ljava/lang/String;
    //   112: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   115: pop
    //   116: aload #5
    //   118: ldc 'tbs_local_version'
    //   120: aload_0
    //   121: getfield e : I
    //   124: invokestatic valueOf : (I)Ljava/lang/String;
    //   127: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   130: pop
    //   131: aload #5
    //   133: ldc 'tbs_download_version'
    //   135: aload_0
    //   136: getfield f : I
    //   139: invokestatic valueOf : (I)Ljava/lang/String;
    //   142: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   145: pop
    //   146: aload_0
    //   147: getfield g : Ljava/lang/String;
    //   150: ifnonnull -> 160
    //   153: ldc_w ''
    //   156: astore_1
    //   157: goto -> 165
    //   160: aload_0
    //   161: getfield g : Ljava/lang/String;
    //   164: astore_1
    //   165: aload #5
    //   167: ldc 'app_versionname'
    //   169: aload_1
    //   170: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   173: pop
    //   174: aload #5
    //   176: ldc 'app_versioncode'
    //   178: aload_0
    //   179: getfield h : I
    //   182: invokestatic valueOf : (I)Ljava/lang/String;
    //   185: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   188: pop
    //   189: aload_0
    //   190: getfield i : Ljava/lang/String;
    //   193: ifnonnull -> 203
    //   196: ldc_w ''
    //   199: astore_1
    //   200: goto -> 208
    //   203: aload_0
    //   204: getfield i : Ljava/lang/String;
    //   207: astore_1
    //   208: aload #5
    //   210: ldc 'app_metadata'
    //   212: aload_1
    //   213: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   216: pop
    //   217: aload #5
    //   219: ldc 'app_versioncode_for_switch'
    //   221: aload_0
    //   222: getfield j : I
    //   225: invokestatic valueOf : (I)Ljava/lang/String;
    //   228: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   231: pop
    //   232: aload #5
    //   234: ldc 'device_total_ram'
    //   236: aload_0
    //   237: getfield k : I
    //   240: invokestatic valueOf : (I)Ljava/lang/String;
    //   243: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   246: pop
    //   247: aload_0
    //   248: getfield l : Ljava/lang/String;
    //   251: ifnonnull -> 260
    //   254: ldc '0'
    //   256: astore_1
    //   257: goto -> 265
    //   260: aload_0
    //   261: getfield l : Ljava/lang/String;
    //   264: astore_1
    //   265: aload #5
    //   267: ldc 'tbscore_version_string'
    //   269: aload_1
    //   270: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   273: pop
    //   274: aload #5
    //   276: ldc 'tbs_commands'
    //   278: aload_0
    //   279: getfield m : I
    //   282: invokestatic valueOf : (I)Ljava/lang/String;
    //   285: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   288: pop
    //   289: aload_0
    //   290: getfield n : Ljava/lang/String;
    //   293: ifnonnull -> 303
    //   296: ldc_w ''
    //   299: astore_1
    //   300: goto -> 308
    //   303: aload_0
    //   304: getfield n : Ljava/lang/String;
    //   307: astore_1
    //   308: aload #5
    //   310: ldc 'tbs_cmd_args'
    //   312: aload_1
    //   313: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   316: pop
    //   317: aload #5
    //   319: ldc 'tbs_cmd_start_index'
    //   321: aload_0
    //   322: getfield o : I
    //   325: invokestatic valueOf : (I)Ljava/lang/String;
    //   328: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   331: pop
    //   332: aload #5
    //   334: ldc 'tbs_cmd_file_replace'
    //   336: aload_0
    //   337: getfield p : Z
    //   340: invokestatic valueOf : (Z)Ljava/lang/String;
    //   343: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   346: pop
    //   347: aload #5
    //   349: ldc 'tbs_last_disabled_time'
    //   351: aload_0
    //   352: getfield s : J
    //   355: invokestatic valueOf : (J)Ljava/lang/String;
    //   358: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   361: pop
    //   362: aload #5
    //   364: ldc 'tbs_last_disabled_version'
    //   366: aload_0
    //   367: getfield r : I
    //   370: invokestatic valueOf : (I)Ljava/lang/String;
    //   373: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   376: pop
    //   377: aload #5
    //   379: ldc 'tbs_exception_info_retry_times'
    //   381: aload_0
    //   382: getfield t : I
    //   385: invokestatic valueOf : (I)Ljava/lang/String;
    //   388: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   391: pop
    //   392: new java/io/FileOutputStream
    //   395: dup
    //   396: aload #4
    //   398: invokespecial <init> : (Ljava/io/File;)V
    //   401: astore_1
    //   402: aload_3
    //   403: astore_2
    //   404: aload_1
    //   405: astore #4
    //   407: new java/io/BufferedOutputStream
    //   410: dup
    //   411: aload_1
    //   412: invokespecial <init> : (Ljava/io/OutputStream;)V
    //   415: astore_3
    //   416: aload #5
    //   418: aload_3
    //   419: aconst_null
    //   420: invokevirtual store : (Ljava/io/OutputStream;Ljava/lang/String;)V
    //   423: aload_3
    //   424: astore_2
    //   425: goto -> 456
    //   428: astore #4
    //   430: aload_3
    //   431: astore_2
    //   432: aload #4
    //   434: astore_3
    //   435: goto -> 543
    //   438: astore #5
    //   440: goto -> 496
    //   443: astore #5
    //   445: aload #6
    //   447: astore_3
    //   448: goto -> 496
    //   451: aconst_null
    //   452: astore_1
    //   453: aload #4
    //   455: astore_2
    //   456: aload_2
    //   457: ifnull -> 464
    //   460: aload_2
    //   461: invokevirtual close : ()V
    //   464: aload_1
    //   465: ifnull -> 536
    //   468: aload_1
    //   469: invokevirtual close : ()V
    //   472: goto -> 536
    //   475: astore_1
    //   476: aload_1
    //   477: invokevirtual printStackTrace : ()V
    //   480: goto -> 536
    //   483: astore_3
    //   484: aconst_null
    //   485: astore_1
    //   486: goto -> 543
    //   489: astore #5
    //   491: aconst_null
    //   492: astore_1
    //   493: aload #6
    //   495: astore_3
    //   496: aload_3
    //   497: astore_2
    //   498: aload_1
    //   499: astore #4
    //   501: aload #5
    //   503: invokevirtual printStackTrace : ()V
    //   506: aload_3
    //   507: ifnull -> 521
    //   510: aload_3
    //   511: invokevirtual close : ()V
    //   514: goto -> 521
    //   517: astore_1
    //   518: goto -> 569
    //   521: aload_1
    //   522: ifnull -> 536
    //   525: aload_1
    //   526: invokevirtual close : ()V
    //   529: goto -> 536
    //   532: astore_1
    //   533: goto -> 476
    //   536: aload_0
    //   537: monitorexit
    //   538: return
    //   539: astore_3
    //   540: aload #4
    //   542: astore_1
    //   543: aload_2
    //   544: ifnull -> 551
    //   547: aload_2
    //   548: invokevirtual close : ()V
    //   551: aload_1
    //   552: ifnull -> 567
    //   555: aload_1
    //   556: invokevirtual close : ()V
    //   559: goto -> 567
    //   562: astore_1
    //   563: aload_1
    //   564: invokevirtual printStackTrace : ()V
    //   567: aload_3
    //   568: athrow
    //   569: aload_0
    //   570: monitorexit
    //   571: aload_1
    //   572: athrow
    //   573: astore_2
    //   574: goto -> 464
    //   577: astore_2
    //   578: goto -> 521
    //   581: astore_2
    //   582: goto -> 551
    // Exception table:
    //   from	to	target	type
    //   12	62	489	java/lang/Exception
    //   12	62	483	finally
    //   62	153	489	java/lang/Exception
    //   62	153	483	finally
    //   160	165	489	java/lang/Exception
    //   160	165	483	finally
    //   165	196	489	java/lang/Exception
    //   165	196	483	finally
    //   203	208	489	java/lang/Exception
    //   203	208	483	finally
    //   208	254	489	java/lang/Exception
    //   208	254	483	finally
    //   260	265	489	java/lang/Exception
    //   260	265	483	finally
    //   265	296	489	java/lang/Exception
    //   265	296	483	finally
    //   303	308	489	java/lang/Exception
    //   303	308	483	finally
    //   308	402	489	java/lang/Exception
    //   308	402	483	finally
    //   407	416	443	java/lang/Exception
    //   407	416	539	finally
    //   416	423	438	java/lang/Exception
    //   416	423	428	finally
    //   460	464	573	java/io/IOException
    //   460	464	517	finally
    //   468	472	475	java/io/IOException
    //   468	472	517	finally
    //   476	480	517	finally
    //   501	506	539	finally
    //   510	514	577	java/io/IOException
    //   510	514	517	finally
    //   525	529	532	java/io/IOException
    //   525	529	517	finally
    //   547	551	581	java/io/IOException
    //   547	551	517	finally
    //   555	559	562	java/io/IOException
    //   555	559	517	finally
    //   563	567	517	finally
    //   567	569	517	finally
  }
  
  public String p() {
    return d("core_share");
  }
  
  public long q() {
    return 73400320L;
  }
  
  public int r() {
    return this.t;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued209820-dex2jar.jar!\com\tencent\tbs\sdk\extension\partner\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */