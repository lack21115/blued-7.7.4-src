package org.chromium.media;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaCodecInfo;
import android.media.MediaCrypto;
import android.os.Build;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Locale;
import org.chromium.base.Log;
import org.chromium.base.annotations.CalledByNative;

class MediaCodecUtil {
  private static final String[] H264_ENCODER_MODEL_BLACKLIST;
  
  static {
    throw new VerifyError("bad dex opcode");
  }
  
  @CalledByNative
  private static boolean canDecode(String paramString, boolean paramBoolean) {
    throw new RuntimeException("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  @TargetApi(19)
  private static boolean codecSupportsAdaptivePlayback(MediaCodec paramMediaCodec, String paramString) {
    boolean bool;
    if (Build.VERSION.SDK_INT >= 19) {
      if (paramMediaCodec == null)
        return false; 
      try {
        MediaCodecInfo mediaCodecInfo = paramMediaCodec.getCodecInfo();
        if (mediaCodecInfo.isEncoder())
          return false; 
        if ((paramString.equals("video/avc") || paramString.equals("video/avc1")) && Build.VERSION.RELEASE.equals("4.4.2") && Build.MANUFACTURER.toLowerCase(Locale.getDefault()).equals("samsung") && (Build.MODEL.startsWith("GT-I9300") || Build.MODEL.startsWith("SCH-I535"))) {
          bool = true;
        } else {
          bool = false;
        } 
      } catch (IllegalArgumentException illegalArgumentException) {
        Log.e("cr_MediaCodecUtil", "Cannot retrieve codec information", new Object[] { illegalArgumentException });
        return false;
      } 
    } else {
      return false;
    } 
    if (bool)
      return false; 
    MediaCodecInfo.CodecCapabilities codecCapabilities = illegalArgumentException.getCapabilitiesForType(paramString);
    if (codecCapabilities != null) {
      boolean bool1 = codecCapabilities.isFeatureSupported("adaptive-playback");
      if (bool1)
        return true; 
    } 
    return false;
  }
  
  static MediaCodecUtil$CodecCreationInfo createDecoder(String paramString, int paramInt, MediaCrypto paramMediaCrypto) {
    MediaCodecUtil$CodecCreationInfo mediaCodecUtil$CodecCreationInfo = new MediaCodecUtil$CodecCreationInfo();
    assert false;
    throw new AssertionError();
  }
  
  static MediaCodecUtil$CodecCreationInfo createEncoder(String paramString) {
    MediaCodecUtil$CodecCreationInfo mediaCodecUtil$CodecCreationInfo = new MediaCodecUtil$CodecCreationInfo();
    MediaCodecUtil$HWEncoderProperties mediaCodecUtil$HWEncoderProperties = findHWEncoder(paramString);
    if (mediaCodecUtil$HWEncoderProperties == null)
      return mediaCodecUtil$CodecCreationInfo; 
    try {
      mediaCodecUtil$CodecCreationInfo.mediaCodec = MediaCodec.createEncoderByType(paramString);
      mediaCodecUtil$CodecCreationInfo.supportsAdaptivePlayback = false;
      mediaCodecUtil$CodecCreationInfo.bitrateAdjuster = mediaCodecUtil$HWEncoderProperties.mBitrateAdjuster;
      return mediaCodecUtil$CodecCreationInfo;
    } catch (Exception exception) {
      Log.e("cr_MediaCodecUtil", "Failed to create MediaCodec: %s", new Object[] { paramString, exception });
      return mediaCodecUtil$CodecCreationInfo;
    } 
  }
  
  private static MediaCodecUtil$HWEncoderProperties findHWEncoder(String paramString) {
    Iterator<MediaCodecInfo> iterator = (new MediaCodecUtil$MediaCodecListHelper()).iterator();
    while (true) {
      boolean bool = iterator.hasNext();
      String str = null;
      if (bool) {
        MediaCodecInfo mediaCodecInfo = iterator.next();
        if (mediaCodecInfo.isEncoder() && !isSoftwareCodec(mediaCodecInfo.getName())) {
          String str1;
          String[] arrayOfString = mediaCodecInfo.getSupportedTypes();
          int j = arrayOfString.length;
          int i = 0;
          while (true) {
            str1 = str;
            if (i < j) {
              if (arrayOfString[i].equalsIgnoreCase(paramString)) {
                str1 = mediaCodecInfo.getName();
                break;
              } 
              i++;
              continue;
            } 
            break;
          } 
          if (str1 != null)
            for (MediaCodecUtil$HWEncoderProperties mediaCodecUtil$HWEncoderProperties : MediaCodecUtil$HWEncoderProperties.values()) {
              if (paramString.equalsIgnoreCase(mediaCodecUtil$HWEncoderProperties.mMime) && str1.startsWith(mediaCodecUtil$HWEncoderProperties.mPrefix)) {
                StringBuilder stringBuilder1;
                if (Build.VERSION.SDK_INT < mediaCodecUtil$HWEncoderProperties.mMinSDK) {
                  stringBuilder1 = new StringBuilder("Codec ");
                  stringBuilder1.append(str1);
                  stringBuilder1.append(" is disabled due to SDK version ");
                  stringBuilder1.append(Build.VERSION.SDK_INT);
                  Log.w("cr_MediaCodecUtil", stringBuilder1.toString(), new Object[0]);
                } else {
                  StringBuilder stringBuilder2 = new StringBuilder("Found target encoder for mime ");
                  stringBuilder2.append(paramString);
                  stringBuilder2.append(" : ");
                  stringBuilder2.append(str1);
                  return (MediaCodecUtil$HWEncoderProperties)stringBuilder1;
                } 
              } 
            }  
        } 
        continue;
      } 
      StringBuilder stringBuilder = new StringBuilder("HW encoder for ");
      stringBuilder.append(paramString);
      stringBuilder.append(" is not available on this device.");
      Log.w("cr_MediaCodecUtil", stringBuilder.toString(), new Object[0]);
      return null;
    } 
  }
  
  @CalledByNative
  private static String getDefaultCodecName(String paramString, int paramInt, boolean paramBoolean) {
    throw new RuntimeException("d2j fail translate: java.lang.RuntimeException: can not merge Z and I\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:322)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  @CalledByNative
  private static int[] getEncoderColorFormatsForMime(String paramString) {
    for (MediaCodecInfo mediaCodecInfo : new MediaCodecUtil$MediaCodecListHelper()) {
      if (mediaCodecInfo.isEncoder())
        for (String str : mediaCodecInfo.getSupportedTypes()) {
          if (str.equalsIgnoreCase(paramString))
            return (mediaCodecInfo.getCapabilitiesForType(str)).colorFormats; 
        }  
    } 
    return null;
  }
  
  @CalledByNative
  private static Object[] getSupportedCodecProfileLevels() {
    CodecProfileLevelList codecProfileLevelList = new CodecProfileLevelList();
    for (MediaCodecInfo mediaCodecInfo : new MediaCodecUtil$MediaCodecListHelper()) {
      for (String str : mediaCodecInfo.getSupportedTypes()) {
        if (!isDecoderSupportedForDevice(str)) {
          Log.w("cr_MediaCodecUtil", "Decoder for type %s disabled on this device", new Object[] { str });
        } else {
          int[] arrayOfInt;
          MediaCodecInfo.VideoCapabilities videoCapabilities;
          MediaCodecInfo.CodecCapabilities codecCapabilities = mediaCodecInfo.getCapabilitiesForType(str);
          if (str.endsWith("vp9") && 21 <= Build.VERSION.SDK_INT && Build.VERSION.SDK_INT <= 23) {
            arrayOfInt = new int[] { 200, 10 };
            int[] arrayOfInt1 = { 1800, 20 };
            int[] arrayOfInt2 = { 30000, 41 };
            videoCapabilities = codecCapabilities.getVideoCapabilities();
            for (int i = 0; i < 11; i++) {
              (new int[11][])[0] = arrayOfInt;
              (new int[2])[0] = 800;
              (new int[2])[1] = 11;
              (new int[11][])[1] = new int[2];
              (new int[11][])[2] = arrayOfInt1;
              (new int[2])[0] = 3600;
              (new int[2])[1] = 21;
              (new int[11][])[3] = new int[2];
              (new int[2])[0] = 7200;
              (new int[2])[1] = 30;
              (new int[11][])[4] = new int[2];
              (new int[2])[0] = 12000;
              (new int[2])[1] = 31;
              (new int[11][])[5] = new int[2];
              (new int[2])[0] = 18000;
              (new int[2])[1] = 40;
              (new int[11][])[6] = new int[2];
              (new int[11][])[7] = arrayOfInt2;
              (new int[2])[0] = 60000;
              (new int[2])[1] = 50;
              (new int[11][])[8] = new int[2];
              (new int[2])[0] = 120000;
              (new int[2])[1] = 51;
              (new int[11][])[9] = new int[2];
              (new int[2])[0] = 180000;
              (new int[2])[1] = 52;
              (new int[11][])[10] = new int[2];
              int[] arrayOfInt3 = (new int[11][])[i];
              int j = arrayOfInt3[0];
              int k = arrayOfInt3[1];
              if (videoCapabilities.getBitrateRange().contains(Integer.valueOf(j)))
                codecProfileLevelList.mList.add(new CodecProfileLevelList$CodecProfileLevelAdapter(7, 12, k)); 
            } 
          } else {
            MediaCodecInfo.CodecProfileLevel[] arrayOfCodecProfileLevel = ((MediaCodecInfo.CodecCapabilities)videoCapabilities).profileLevels;
            int j = arrayOfCodecProfileLevel.length;
            for (int i = 0; i < j; i++)
              codecProfileLevelList.addCodecProfileLevel((String)arrayOfInt, arrayOfCodecProfileLevel[i]); 
          } 
        } 
      } 
    } 
    return codecProfileLevelList.mList.toArray();
  }
  
  @CalledByNative
  static boolean isDecoderSupportedForDevice(String paramString) {
    if (paramString.equals("video/x-vnd.on2.vp8")) {
      if (Build.VERSION.SDK_INT < 18)
        return false; 
      if (Build.MANUFACTURER.toLowerCase(Locale.getDefault()).equals("samsung")) {
        if (Build.VERSION.SDK_INT < 21 && (Build.MODEL.startsWith("GT-I9505") || Build.MODEL.startsWith("GT-I9500")))
          return false; 
        if (!Build.MODEL.startsWith("GT-I9190")) {
          if (Build.MODEL.startsWith("GT-I9195"))
            return false; 
          if (Build.VERSION.SDK_INT <= 19) {
            if (Build.MODEL.startsWith("GT-"))
              return false; 
            if (Build.MODEL.startsWith("SCH-"))
              return false; 
            if (Build.MODEL.startsWith("SM-T"))
              return false; 
            if (Build.MODEL.startsWith("SM-G"))
              return false; 
          } 
        } else {
          return false;
        } 
      } 
      if (Build.HARDWARE.startsWith("mt"))
        return false; 
      if (Build.VERSION.SDK_INT <= 19 && Build.MODEL.startsWith("Lenovo A6000"))
        return false; 
    } else if (paramString.equals("video/x-vnd.on2.vp9")) {
      if (Build.VERSION.SDK_INT < 19)
        return false; 
      if (Build.VERSION.SDK_INT < 21 && Build.HARDWARE.startsWith("mt"))
        return false; 
      if (Build.MODEL.equals("Nexus Player"))
        return false; 
    } else if (paramString.equals("audio/opus") && Build.VERSION.SDK_INT < 21) {
      return false;
    } 
    return true;
  }
  
  @CalledByNative
  static boolean isEncoderSupportedByDevice(String paramString) {
    StringBuilder stringBuilder;
    if (Build.VERSION.SDK_INT < 19)
      return false; 
    if (paramString.equals("video/avc") && Arrays.<String>asList(H264_ENCODER_MODEL_BLACKLIST).contains(Build.MODEL)) {
      stringBuilder = new StringBuilder("Model: ");
      stringBuilder.append(Build.MODEL);
      stringBuilder.append(" has blacklisted H.264 encoder.");
      Log.w("cr_MediaCodecUtil", stringBuilder.toString(), new Object[0]);
      return false;
    } 
    return !(findHWEncoder((String)stringBuilder) == null);
  }
  
  @CalledByNative
  static boolean isSetOutputSurfaceSupported() {
    return (Build.VERSION.SDK_INT >= 23 && !Build.HARDWARE.equalsIgnoreCase("hi6210sft") && !Build.HARDWARE.equalsIgnoreCase("hi6250"));
  }
  
  private static boolean isSoftwareCodec(String paramString) {
    return paramString.startsWith("OMX.google.") ? true : (!paramString.startsWith("OMX."));
  }
  
  @CalledByNative
  static boolean platformSupportsCbcsEncryption(int paramInt) {
    return (paramInt >= 25);
  }
  
  static void setPatternIfSupported(MediaCodec.CryptoInfo paramCryptoInfo, int paramInt1, int paramInt2) {
    if (Build.VERSION.SDK_INT >= 24)
      paramCryptoInfo.setPattern(new MediaCodec.CryptoInfo.Pattern(paramInt1, paramInt2)); 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\media\MediaCodecUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */