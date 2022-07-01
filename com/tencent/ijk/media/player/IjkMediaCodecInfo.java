package com.tencent.ijk.media.player;

import android.media.MediaCodecInfo;
import android.os.Build;
import android.util.Log;
import java.util.Locale;
import java.util.Map;

public class IjkMediaCodecInfo {
  public static final int RANK_ACCEPTABLE = 700;
  
  public static final int RANK_LAST_CHANCE = 600;
  
  public static final int RANK_MAX = 1000;
  
  public static final int RANK_NON_STANDARD = 100;
  
  public static final int RANK_NO_SENSE = 0;
  
  public static final int RANK_SECURE = 300;
  
  public static final int RANK_SOFTWARE = 200;
  
  public static final int RANK_TESTED = 800;
  
  private static final String TAG = "IjkMediaCodecInfo";
  
  private static Map<String, Integer> sKnownCodecList;
  
  public MediaCodecInfo mCodecInfo;
  
  public String mMimeType;
  
  public int mRank = 0;
  
  private static Map<String, Integer> getKnownCodecList() {
    // Byte code:
    //   0: ldc com/tencent/ijk/media/player/IjkMediaCodecInfo
    //   2: monitorenter
    //   3: getstatic com/tencent/ijk/media/player/IjkMediaCodecInfo.sKnownCodecList : Ljava/util/Map;
    //   6: ifnull -> 18
    //   9: getstatic com/tencent/ijk/media/player/IjkMediaCodecInfo.sKnownCodecList : Ljava/util/Map;
    //   12: astore_0
    //   13: ldc com/tencent/ijk/media/player/IjkMediaCodecInfo
    //   15: monitorexit
    //   16: aload_0
    //   17: areturn
    //   18: new java/util/TreeMap
    //   21: dup
    //   22: getstatic java/lang/String.CASE_INSENSITIVE_ORDER : Ljava/util/Comparator;
    //   25: invokespecial <init> : (Ljava/util/Comparator;)V
    //   28: putstatic com/tencent/ijk/media/player/IjkMediaCodecInfo.sKnownCodecList : Ljava/util/Map;
    //   31: getstatic com/tencent/ijk/media/player/IjkMediaCodecInfo.sKnownCodecList : Ljava/util/Map;
    //   34: ldc 'OMX.Nvidia.h264.decode'
    //   36: sipush #800
    //   39: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   42: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   47: pop
    //   48: getstatic com/tencent/ijk/media/player/IjkMediaCodecInfo.sKnownCodecList : Ljava/util/Map;
    //   51: ldc 'OMX.Nvidia.h264.decode.secure'
    //   53: sipush #300
    //   56: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   59: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   64: pop
    //   65: getstatic com/tencent/ijk/media/player/IjkMediaCodecInfo.sKnownCodecList : Ljava/util/Map;
    //   68: ldc 'OMX.Intel.hw_vd.h264'
    //   70: sipush #801
    //   73: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   76: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   81: pop
    //   82: getstatic com/tencent/ijk/media/player/IjkMediaCodecInfo.sKnownCodecList : Ljava/util/Map;
    //   85: ldc 'OMX.Intel.VideoDecoder.AVC'
    //   87: sipush #800
    //   90: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   93: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   98: pop
    //   99: getstatic com/tencent/ijk/media/player/IjkMediaCodecInfo.sKnownCodecList : Ljava/util/Map;
    //   102: ldc 'OMX.qcom.video.decoder.avc'
    //   104: sipush #800
    //   107: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   110: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   115: pop
    //   116: getstatic com/tencent/ijk/media/player/IjkMediaCodecInfo.sKnownCodecList : Ljava/util/Map;
    //   119: ldc 'OMX.ittiam.video.decoder.avc'
    //   121: iconst_0
    //   122: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   125: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   130: pop
    //   131: getstatic com/tencent/ijk/media/player/IjkMediaCodecInfo.sKnownCodecList : Ljava/util/Map;
    //   134: ldc 'OMX.SEC.avc.dec'
    //   136: sipush #800
    //   139: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   142: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   147: pop
    //   148: getstatic com/tencent/ijk/media/player/IjkMediaCodecInfo.sKnownCodecList : Ljava/util/Map;
    //   151: ldc 'OMX.SEC.AVC.Decoder'
    //   153: sipush #799
    //   156: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   159: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   164: pop
    //   165: getstatic com/tencent/ijk/media/player/IjkMediaCodecInfo.sKnownCodecList : Ljava/util/Map;
    //   168: ldc 'OMX.SEC.avcdec'
    //   170: sipush #798
    //   173: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   176: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   181: pop
    //   182: getstatic com/tencent/ijk/media/player/IjkMediaCodecInfo.sKnownCodecList : Ljava/util/Map;
    //   185: ldc 'OMX.SEC.avc.sw.dec'
    //   187: sipush #200
    //   190: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   193: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   198: pop
    //   199: getstatic com/tencent/ijk/media/player/IjkMediaCodecInfo.sKnownCodecList : Ljava/util/Map;
    //   202: ldc 'OMX.Exynos.avc.dec'
    //   204: sipush #800
    //   207: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   210: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   215: pop
    //   216: getstatic com/tencent/ijk/media/player/IjkMediaCodecInfo.sKnownCodecList : Ljava/util/Map;
    //   219: ldc 'OMX.Exynos.AVC.Decoder'
    //   221: sipush #799
    //   224: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   227: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   232: pop
    //   233: getstatic com/tencent/ijk/media/player/IjkMediaCodecInfo.sKnownCodecList : Ljava/util/Map;
    //   236: ldc 'OMX.k3.video.decoder.avc'
    //   238: sipush #800
    //   241: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   244: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   249: pop
    //   250: getstatic com/tencent/ijk/media/player/IjkMediaCodecInfo.sKnownCodecList : Ljava/util/Map;
    //   253: ldc 'OMX.IMG.MSVDX.Decoder.AVC'
    //   255: sipush #800
    //   258: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   261: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   266: pop
    //   267: getstatic com/tencent/ijk/media/player/IjkMediaCodecInfo.sKnownCodecList : Ljava/util/Map;
    //   270: ldc 'OMX.TI.DUCATI1.VIDEO.DECODER'
    //   272: sipush #800
    //   275: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   278: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   283: pop
    //   284: getstatic com/tencent/ijk/media/player/IjkMediaCodecInfo.sKnownCodecList : Ljava/util/Map;
    //   287: ldc 'OMX.rk.video_decoder.avc'
    //   289: sipush #800
    //   292: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   295: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   300: pop
    //   301: getstatic com/tencent/ijk/media/player/IjkMediaCodecInfo.sKnownCodecList : Ljava/util/Map;
    //   304: ldc 'OMX.amlogic.avc.decoder.awesome'
    //   306: sipush #800
    //   309: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   312: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   317: pop
    //   318: getstatic com/tencent/ijk/media/player/IjkMediaCodecInfo.sKnownCodecList : Ljava/util/Map;
    //   321: ldc 'OMX.MARVELL.VIDEO.HW.CODA7542DECODER'
    //   323: sipush #800
    //   326: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   329: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   334: pop
    //   335: getstatic com/tencent/ijk/media/player/IjkMediaCodecInfo.sKnownCodecList : Ljava/util/Map;
    //   338: ldc 'OMX.MARVELL.VIDEO.H264DECODER'
    //   340: sipush #200
    //   343: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   346: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   351: pop
    //   352: getstatic com/tencent/ijk/media/player/IjkMediaCodecInfo.sKnownCodecList : Ljava/util/Map;
    //   355: ldc 'OMX.Action.Video.Decoder'
    //   357: invokeinterface remove : (Ljava/lang/Object;)Ljava/lang/Object;
    //   362: pop
    //   363: getstatic com/tencent/ijk/media/player/IjkMediaCodecInfo.sKnownCodecList : Ljava/util/Map;
    //   366: ldc 'OMX.allwinner.video.decoder.avc'
    //   368: invokeinterface remove : (Ljava/lang/Object;)Ljava/lang/Object;
    //   373: pop
    //   374: getstatic com/tencent/ijk/media/player/IjkMediaCodecInfo.sKnownCodecList : Ljava/util/Map;
    //   377: ldc 'OMX.BRCM.vc4.decoder.avc'
    //   379: invokeinterface remove : (Ljava/lang/Object;)Ljava/lang/Object;
    //   384: pop
    //   385: getstatic com/tencent/ijk/media/player/IjkMediaCodecInfo.sKnownCodecList : Ljava/util/Map;
    //   388: ldc 'OMX.brcm.video.h264.hw.decoder'
    //   390: invokeinterface remove : (Ljava/lang/Object;)Ljava/lang/Object;
    //   395: pop
    //   396: getstatic com/tencent/ijk/media/player/IjkMediaCodecInfo.sKnownCodecList : Ljava/util/Map;
    //   399: ldc 'OMX.brcm.video.h264.decoder'
    //   401: invokeinterface remove : (Ljava/lang/Object;)Ljava/lang/Object;
    //   406: pop
    //   407: getstatic com/tencent/ijk/media/player/IjkMediaCodecInfo.sKnownCodecList : Ljava/util/Map;
    //   410: ldc 'OMX.cosmo.video.decoder.avc'
    //   412: invokeinterface remove : (Ljava/lang/Object;)Ljava/lang/Object;
    //   417: pop
    //   418: getstatic com/tencent/ijk/media/player/IjkMediaCodecInfo.sKnownCodecList : Ljava/util/Map;
    //   421: ldc 'OMX.duos.h264.decoder'
    //   423: invokeinterface remove : (Ljava/lang/Object;)Ljava/lang/Object;
    //   428: pop
    //   429: getstatic com/tencent/ijk/media/player/IjkMediaCodecInfo.sKnownCodecList : Ljava/util/Map;
    //   432: ldc 'OMX.hantro.81x0.video.decoder'
    //   434: invokeinterface remove : (Ljava/lang/Object;)Ljava/lang/Object;
    //   439: pop
    //   440: getstatic com/tencent/ijk/media/player/IjkMediaCodecInfo.sKnownCodecList : Ljava/util/Map;
    //   443: ldc 'OMX.hantro.G1.video.decoder'
    //   445: invokeinterface remove : (Ljava/lang/Object;)Ljava/lang/Object;
    //   450: pop
    //   451: getstatic com/tencent/ijk/media/player/IjkMediaCodecInfo.sKnownCodecList : Ljava/util/Map;
    //   454: ldc 'OMX.hisi.video.decoder'
    //   456: invokeinterface remove : (Ljava/lang/Object;)Ljava/lang/Object;
    //   461: pop
    //   462: getstatic com/tencent/ijk/media/player/IjkMediaCodecInfo.sKnownCodecList : Ljava/util/Map;
    //   465: ldc 'OMX.LG.decoder.video.avc'
    //   467: invokeinterface remove : (Ljava/lang/Object;)Ljava/lang/Object;
    //   472: pop
    //   473: getstatic com/tencent/ijk/media/player/IjkMediaCodecInfo.sKnownCodecList : Ljava/util/Map;
    //   476: ldc 'OMX.MS.AVC.Decoder'
    //   478: invokeinterface remove : (Ljava/lang/Object;)Ljava/lang/Object;
    //   483: pop
    //   484: getstatic com/tencent/ijk/media/player/IjkMediaCodecInfo.sKnownCodecList : Ljava/util/Map;
    //   487: ldc 'OMX.RENESAS.VIDEO.DECODER.H264'
    //   489: invokeinterface remove : (Ljava/lang/Object;)Ljava/lang/Object;
    //   494: pop
    //   495: getstatic com/tencent/ijk/media/player/IjkMediaCodecInfo.sKnownCodecList : Ljava/util/Map;
    //   498: ldc 'OMX.RTK.video.decoder'
    //   500: invokeinterface remove : (Ljava/lang/Object;)Ljava/lang/Object;
    //   505: pop
    //   506: getstatic com/tencent/ijk/media/player/IjkMediaCodecInfo.sKnownCodecList : Ljava/util/Map;
    //   509: ldc 'OMX.sprd.h264.decoder'
    //   511: invokeinterface remove : (Ljava/lang/Object;)Ljava/lang/Object;
    //   516: pop
    //   517: getstatic com/tencent/ijk/media/player/IjkMediaCodecInfo.sKnownCodecList : Ljava/util/Map;
    //   520: ldc 'OMX.ST.VFM.H264Dec'
    //   522: invokeinterface remove : (Ljava/lang/Object;)Ljava/lang/Object;
    //   527: pop
    //   528: getstatic com/tencent/ijk/media/player/IjkMediaCodecInfo.sKnownCodecList : Ljava/util/Map;
    //   531: ldc 'OMX.vpu.video_decoder.avc'
    //   533: invokeinterface remove : (Ljava/lang/Object;)Ljava/lang/Object;
    //   538: pop
    //   539: getstatic com/tencent/ijk/media/player/IjkMediaCodecInfo.sKnownCodecList : Ljava/util/Map;
    //   542: ldc 'OMX.WMT.decoder.avc'
    //   544: invokeinterface remove : (Ljava/lang/Object;)Ljava/lang/Object;
    //   549: pop
    //   550: getstatic com/tencent/ijk/media/player/IjkMediaCodecInfo.sKnownCodecList : Ljava/util/Map;
    //   553: ldc 'OMX.bluestacks.hw.decoder'
    //   555: invokeinterface remove : (Ljava/lang/Object;)Ljava/lang/Object;
    //   560: pop
    //   561: getstatic com/tencent/ijk/media/player/IjkMediaCodecInfo.sKnownCodecList : Ljava/util/Map;
    //   564: ldc 'OMX.google.h264.decoder'
    //   566: sipush #200
    //   569: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   572: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   577: pop
    //   578: getstatic com/tencent/ijk/media/player/IjkMediaCodecInfo.sKnownCodecList : Ljava/util/Map;
    //   581: ldc 'OMX.google.h264.lc.decoder'
    //   583: sipush #200
    //   586: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   589: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   594: pop
    //   595: getstatic com/tencent/ijk/media/player/IjkMediaCodecInfo.sKnownCodecList : Ljava/util/Map;
    //   598: ldc 'OMX.k3.ffmpeg.decoder'
    //   600: sipush #200
    //   603: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   606: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   611: pop
    //   612: getstatic com/tencent/ijk/media/player/IjkMediaCodecInfo.sKnownCodecList : Ljava/util/Map;
    //   615: ldc 'OMX.ffmpeg.video.decoder'
    //   617: sipush #200
    //   620: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   623: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   628: pop
    //   629: getstatic com/tencent/ijk/media/player/IjkMediaCodecInfo.sKnownCodecList : Ljava/util/Map;
    //   632: ldc 'OMX.sprd.soft.h264.decoder'
    //   634: sipush #200
    //   637: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   640: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   645: pop
    //   646: getstatic com/tencent/ijk/media/player/IjkMediaCodecInfo.sKnownCodecList : Ljava/util/Map;
    //   649: astore_0
    //   650: ldc com/tencent/ijk/media/player/IjkMediaCodecInfo
    //   652: monitorexit
    //   653: aload_0
    //   654: areturn
    //   655: astore_0
    //   656: ldc com/tencent/ijk/media/player/IjkMediaCodecInfo
    //   658: monitorexit
    //   659: aload_0
    //   660: athrow
    // Exception table:
    //   from	to	target	type
    //   3	13	655	finally
    //   18	650	655	finally
  }
  
  public static String getLevelName(int paramInt) {
    if (paramInt != 1) {
      if (paramInt != 2) {
        switch (paramInt) {
          default:
            return "0";
          case 65536:
            return "52";
          case 32768:
            return "51";
          case 16384:
            return "5";
          case 8192:
            return "42";
          case 4096:
            return "41";
          case 2048:
            return "4";
          case 1024:
            return "32";
          case 512:
            return "31";
          case 256:
            return "3";
          case 128:
            return "22";
          case 64:
            return "21";
          case 32:
            return "2";
          case 16:
            return "13";
          case 8:
            return "12";
          case 4:
            break;
        } 
        return "11";
      } 
      return "1b";
    } 
    return "1";
  }
  
  public static String getProfileLevelName(int paramInt1, int paramInt2) {
    return String.format(Locale.US, " %s Profile Level %s (%d,%d)", new Object[] { getProfileName(paramInt1), getLevelName(paramInt2), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
  }
  
  public static String getProfileName(int paramInt) {
    return (paramInt != 1) ? ((paramInt != 2) ? ((paramInt != 4) ? ((paramInt != 8) ? ((paramInt != 16) ? ((paramInt != 32) ? ((paramInt != 64) ? "Unknown" : "High444") : "High422") : "High10") : "High") : "Extends") : "Main") : "Baseline";
  }
  
  public static IjkMediaCodecInfo setupCandidate(MediaCodecInfo paramMediaCodecInfo, String paramString) {
    // Byte code:
    //   0: aconst_null
    //   1: astore #4
    //   3: aload_0
    //   4: ifnull -> 257
    //   7: getstatic android/os/Build$VERSION.SDK_INT : I
    //   10: bipush #16
    //   12: if_icmpge -> 17
    //   15: aconst_null
    //   16: areturn
    //   17: aload_0
    //   18: invokevirtual getName : ()Ljava/lang/String;
    //   21: astore #4
    //   23: aload #4
    //   25: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   28: ifeq -> 33
    //   31: aconst_null
    //   32: areturn
    //   33: aload #4
    //   35: getstatic java/util/Locale.US : Ljava/util/Locale;
    //   38: invokevirtual toLowerCase : (Ljava/util/Locale;)Ljava/lang/String;
    //   41: astore #4
    //   43: aload #4
    //   45: ldc_w 'omx.'
    //   48: invokevirtual startsWith : (Ljava/lang/String;)Z
    //   51: istore_3
    //   52: sipush #600
    //   55: istore_2
    //   56: iload_3
    //   57: ifne -> 66
    //   60: bipush #100
    //   62: istore_2
    //   63: goto -> 230
    //   66: aload #4
    //   68: ldc_w 'omx.pv'
    //   71: invokevirtual startsWith : (Ljava/lang/String;)Z
    //   74: ifeq -> 84
    //   77: sipush #200
    //   80: istore_2
    //   81: goto -> 230
    //   84: aload #4
    //   86: ldc_w 'omx.google.'
    //   89: invokevirtual startsWith : (Ljava/lang/String;)Z
    //   92: ifeq -> 98
    //   95: goto -> 77
    //   98: aload #4
    //   100: ldc_w 'omx.ffmpeg.'
    //   103: invokevirtual startsWith : (Ljava/lang/String;)Z
    //   106: ifeq -> 112
    //   109: goto -> 77
    //   112: aload #4
    //   114: ldc_w 'omx.k3.ffmpeg.'
    //   117: invokevirtual startsWith : (Ljava/lang/String;)Z
    //   120: ifeq -> 126
    //   123: goto -> 77
    //   126: aload #4
    //   128: ldc_w 'omx.avcodec.'
    //   131: invokevirtual startsWith : (Ljava/lang/String;)Z
    //   134: ifeq -> 140
    //   137: goto -> 77
    //   140: aload #4
    //   142: ldc_w 'omx.ittiam.'
    //   145: invokevirtual startsWith : (Ljava/lang/String;)Z
    //   148: ifeq -> 156
    //   151: iconst_0
    //   152: istore_2
    //   153: goto -> 230
    //   156: aload #4
    //   158: ldc_w 'omx.mtk.'
    //   161: invokevirtual startsWith : (Ljava/lang/String;)Z
    //   164: ifeq -> 185
    //   167: getstatic android/os/Build$VERSION.SDK_INT : I
    //   170: bipush #18
    //   172: if_icmpge -> 178
    //   175: goto -> 151
    //   178: sipush #800
    //   181: istore_2
    //   182: goto -> 230
    //   185: invokestatic getKnownCodecList : ()Ljava/util/Map;
    //   188: aload #4
    //   190: invokeinterface get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   195: checkcast java/lang/Integer
    //   198: astore #4
    //   200: aload #4
    //   202: ifnull -> 214
    //   205: aload #4
    //   207: invokevirtual intValue : ()I
    //   210: istore_2
    //   211: goto -> 230
    //   214: aload_0
    //   215: aload_1
    //   216: invokevirtual getCapabilitiesForType : (Ljava/lang/String;)Landroid/media/MediaCodecInfo$CodecCapabilities;
    //   219: astore #4
    //   221: aload #4
    //   223: ifnull -> 230
    //   226: sipush #700
    //   229: istore_2
    //   230: new com/tencent/ijk/media/player/IjkMediaCodecInfo
    //   233: dup
    //   234: invokespecial <init> : ()V
    //   237: astore #4
    //   239: aload #4
    //   241: aload_0
    //   242: putfield mCodecInfo : Landroid/media/MediaCodecInfo;
    //   245: aload #4
    //   247: iload_2
    //   248: putfield mRank : I
    //   251: aload #4
    //   253: aload_1
    //   254: putfield mMimeType : Ljava/lang/String;
    //   257: aload #4
    //   259: areturn
    //   260: astore #4
    //   262: goto -> 230
    // Exception table:
    //   from	to	target	type
    //   214	221	260	finally
  }
  
  public void dumpProfileLevels(String paramString) {
    if (Build.VERSION.SDK_INT < 16)
      return; 
    try {
    
    } finally {
      paramString = null;
      Log.i("IjkMediaCodecInfo", "profile-level: exception");
    } 
    boolean bool1 = false;
    boolean bool2 = false;
    Log.i("IjkMediaCodecInfo", String.format(Locale.US, "%s", new Object[] { getProfileLevelName(bool1, bool2) }));
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\tencent\ijk\media\player\IjkMediaCodecInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */