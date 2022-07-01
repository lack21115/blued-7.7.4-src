package com.baidu.idl.facesdk;

import android.content.Context;
import android.content.res.AssetManager;
import android.util.Log;
import com.baidu.idl.license.AndroidLicenser;
import java.io.File;
import java.io.FileFilter;
import java.util.regex.Pattern;

public class FaceSDK {
  private static final String TAG = FaceSDK.class.getSimpleName();
  
  private static int mAuthorityStatus = AndroidLicenser.ErrorCode.LICENSE_INIT_ERROR.ordinal();
  
  private static native int AlignModelInit(AssetManager paramAssetManager, String paramString1, String paramString2, int paramInt);
  
  private static native int DetectModelInit(AssetManager paramAssetManager, String paramString, int paramInt);
  
  private static native int ParsingModelInit(AssetManager paramAssetManager, String paramString1, String paramString2, int paramInt);
  
  private static native int ScoreModelInit(AssetManager paramAssetManager, String paramString1, String paramString2, int paramInt);
  
  private static native int align(int[] paramArrayOfint1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int[] paramArrayOfint2, int[] paramArrayOfint3, int[] paramArrayOfint4, float[] paramArrayOffloat);
  
  public static boolean checkParameter(Object paramObject, int paramInt1, int paramInt2) {
    return (paramObject != null && paramInt1 > 0 && paramInt2 > 0);
  }
  
  private static native int cropFaceImg(int[] paramArrayOfint1, int paramInt1, int paramInt2, int paramInt3, int[] paramArrayOfint2, int paramInt4, int paramInt5, int paramInt6, int[] paramArrayOfint3, int[] paramArrayOfint4);
  
  private static native FaceInfo[] detect(int[] paramArrayOfint, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5);
  
  private static native int fineAlign(int[] paramArrayOfint1, int paramInt1, int paramInt2, int paramInt3, int[] paramArrayOfint2, int[] paramArrayOfint3);
  
  public static native int getARGBFromYUVimg(byte[] paramArrayOfbyte, int[] paramArrayOfint, int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  public static int getAuthorityStatus() {
    return mAuthorityStatus;
  }
  
  private static int getNumCores() {
    try {
      class CpuFilter implements FileFilter {
        public boolean accept(File param1File) {
          return Pattern.matches("cpu[0-9]+", param1File.getName());
        }
      };
      return ((new File("/sys/devices/system/cpu/")).listFiles(new CpuFilter())).length;
    } catch (Exception exception) {
      return 1;
    } 
  }
  
  public static String getVersion() {
    return "3.2.2.0";
  }
  
  private static native int headPoseEstimation(int[] paramArrayOfint, int paramInt, double[] paramArrayOfdouble);
  
  public static native int imgQuality(int[] paramArrayOfint1, int paramInt1, int paramInt2, int paramInt3, int[] paramArrayOfint2, int paramInt4, float[] paramArrayOffloat1, int[] paramArrayOfint3, float[] paramArrayOffloat2, int[] paramArrayOfint4);
  
  private static native int imgQualityModelInit(AssetManager paramAssetManager, String paramString1, String paramString2, int paramInt);
  
  public static void initLicense(Context paramContext, String paramString1, String paramString2, boolean paramBoolean) {
    // Byte code:
    //   0: ldc com/baidu/idl/facesdk/FaceSDK
    //   2: monitorenter
    //   3: aload_0
    //   4: ifnull -> 255
    //   7: aload_0
    //   8: ldc 'FaceSDKLibs'
    //   10: iconst_0
    //   11: invokevirtual getDir : (Ljava/lang/String;I)Ljava/io/File;
    //   14: astore #6
    //   16: new java/lang/StringBuilder
    //   19: dup
    //   20: invokespecial <init> : ()V
    //   23: astore #7
    //   25: aload #7
    //   27: aload #6
    //   29: invokevirtual getAbsolutePath : ()Ljava/lang/String;
    //   32: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   35: pop
    //   36: aload #7
    //   38: getstatic java/io/File.separator : Ljava/lang/String;
    //   41: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   44: pop
    //   45: aload #7
    //   47: ldc 'libFaceSDK.so'
    //   49: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   52: pop
    //   53: new java/io/File
    //   56: dup
    //   57: aload #7
    //   59: invokevirtual toString : ()Ljava/lang/String;
    //   62: invokespecial <init> : (Ljava/lang/String;)V
    //   65: astore #7
    //   67: new java/lang/StringBuilder
    //   70: dup
    //   71: invokespecial <init> : ()V
    //   74: astore #8
    //   76: aload #8
    //   78: aload #6
    //   80: invokevirtual getAbsolutePath : ()Ljava/lang/String;
    //   83: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   86: pop
    //   87: aload #8
    //   89: getstatic java/io/File.separator : Ljava/lang/String;
    //   92: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   95: pop
    //   96: aload #8
    //   98: ldc 'libbaidu_license.so'
    //   100: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   103: pop
    //   104: new java/io/File
    //   107: dup
    //   108: aload #8
    //   110: invokevirtual toString : ()Ljava/lang/String;
    //   113: invokespecial <init> : (Ljava/lang/String;)V
    //   116: astore #6
    //   118: aload #7
    //   120: invokevirtual exists : ()Z
    //   123: ifeq -> 171
    //   126: aload #6
    //   128: invokevirtual exists : ()Z
    //   131: ifeq -> 171
    //   134: getstatic com/baidu/idl/facesdk/FaceSDK.TAG : Ljava/lang/String;
    //   137: ldc 'Load library from private space'
    //   139: invokestatic e : (Ljava/lang/String;Ljava/lang/String;)I
    //   142: pop
    //   143: aload #6
    //   145: invokevirtual getAbsolutePath : ()Ljava/lang/String;
    //   148: invokestatic load : (Ljava/lang/String;)V
    //   151: aload #7
    //   153: invokevirtual getAbsolutePath : ()Ljava/lang/String;
    //   156: invokestatic load : (Ljava/lang/String;)V
    //   159: getstatic com/baidu/idl/facesdk/FaceSDK.TAG : Ljava/lang/String;
    //   162: ldc 'Load facesdk library from private space succeed'
    //   164: invokestatic e : (Ljava/lang/String;Ljava/lang/String;)I
    //   167: pop
    //   168: goto -> 199
    //   171: getstatic com/baidu/idl/facesdk/FaceSDK.TAG : Ljava/lang/String;
    //   174: ldc 'Load library from assets space'
    //   176: invokestatic e : (Ljava/lang/String;Ljava/lang/String;)I
    //   179: pop
    //   180: ldc 'baidu_license'
    //   182: invokestatic loadLibrary : (Ljava/lang/String;)V
    //   185: ldc 'FaceSDK'
    //   187: invokestatic loadLibrary : (Ljava/lang/String;)V
    //   190: getstatic com/baidu/idl/facesdk/FaceSDK.TAG : Ljava/lang/String;
    //   193: ldc 'Load facesdk library from assets space succeed'
    //   195: invokestatic e : (Ljava/lang/String;Ljava/lang/String;)I
    //   198: pop
    //   199: new java/lang/Thread
    //   202: dup
    //   203: new com/baidu/idl/facesdk/FaceSDK$1
    //   206: dup
    //   207: aload_1
    //   208: aload_2
    //   209: aload_0
    //   210: iload_3
    //   211: invokespecial <init> : (Ljava/lang/String;Ljava/lang/String;Landroid/content/Context;Z)V
    //   214: invokespecial <init> : (Ljava/lang/Runnable;)V
    //   217: invokevirtual start : ()V
    //   220: invokestatic getNumCores : ()I
    //   223: istore #5
    //   225: iconst_1
    //   226: istore #4
    //   228: iload #5
    //   230: iconst_1
    //   231: if_icmple -> 240
    //   234: iload #5
    //   236: iconst_2
    //   237: idiv
    //   238: istore #4
    //   240: iload #4
    //   242: invokestatic setNumberOfThreads : (I)I
    //   245: pop
    //   246: goto -> 255
    //   249: astore_0
    //   250: ldc com/baidu/idl/facesdk/FaceSDK
    //   252: monitorexit
    //   253: aload_0
    //   254: athrow
    //   255: ldc com/baidu/idl/facesdk/FaceSDK
    //   257: monitorexit
    //   258: return
    // Exception table:
    //   from	to	target	type
    //   7	168	249	finally
    //   171	199	249	finally
    //   199	225	249	finally
    //   234	240	249	finally
    //   240	246	249	finally
  }
  
  public static void initModel(Context paramContext) {
    // Byte code:
    //   0: ldc com/baidu/idl/facesdk/FaceSDK
    //   2: monitorenter
    //   3: aload_0
    //   4: ifnull -> 174
    //   7: aload_0
    //   8: ldc 'align_model.binary'
    //   10: invokestatic hasModel : (Landroid/content/Context;Ljava/lang/String;)Z
    //   13: ifeq -> 34
    //   16: aload_0
    //   17: invokevirtual getAssets : ()Landroid/content/res/AssetManager;
    //   20: ldc 'align_model.binary'
    //   22: ldc ''
    //   24: getstatic com/baidu/idl/facesdk/FaceSDK$AlignMethodType.CDNN : Lcom/baidu/idl/facesdk/FaceSDK$AlignMethodType;
    //   27: invokevirtual ordinal : ()I
    //   30: invokestatic AlignModelInit : (Landroid/content/res/AssetManager;Ljava/lang/String;Ljava/lang/String;I)I
    //   33: pop
    //   34: aload_0
    //   35: ldc 'facedetect.binary'
    //   37: invokestatic hasModel : (Landroid/content/Context;Ljava/lang/String;)Z
    //   40: ifeq -> 59
    //   43: aload_0
    //   44: invokevirtual getAssets : ()Landroid/content/res/AssetManager;
    //   47: ldc 'facedetect.binary'
    //   49: getstatic com/baidu/idl/facesdk/FaceSDK$DetectMethodType.CNN : Lcom/baidu/idl/facesdk/FaceSDK$DetectMethodType;
    //   52: invokevirtual ordinal : ()I
    //   55: invokestatic DetectModelInit : (Landroid/content/res/AssetManager;Ljava/lang/String;I)I
    //   58: pop
    //   59: aload_0
    //   60: ldc 'small_detect.model'
    //   62: invokestatic hasModel : (Landroid/content/Context;Ljava/lang/String;)Z
    //   65: ifeq -> 84
    //   68: aload_0
    //   69: invokevirtual getAssets : ()Landroid/content/res/AssetManager;
    //   72: ldc 'small_detect.model'
    //   74: getstatic com/baidu/idl/facesdk/FaceSDK$DetectMethodType.NIR : Lcom/baidu/idl/facesdk/FaceSDK$DetectMethodType;
    //   77: invokevirtual ordinal : ()I
    //   80: invokestatic DetectModelInit : (Landroid/content/res/AssetManager;Ljava/lang/String;I)I
    //   83: pop
    //   84: aload_0
    //   85: ldc 'score.binary'
    //   87: invokestatic hasModel : (Landroid/content/Context;Ljava/lang/String;)Z
    //   90: ifeq -> 111
    //   93: aload_0
    //   94: invokevirtual getAssets : ()Landroid/content/res/AssetManager;
    //   97: ldc 'score.binary'
    //   99: ldc ''
    //   101: getstatic com/baidu/idl/facesdk/FaceSDK$DetectMethodType.CNN : Lcom/baidu/idl/facesdk/FaceSDK$DetectMethodType;
    //   104: invokevirtual ordinal : ()I
    //   107: invokestatic ScoreModelInit : (Landroid/content/res/AssetManager;Ljava/lang/String;Ljava/lang/String;I)I
    //   110: pop
    //   111: aload_0
    //   112: ldc 'blur.binary'
    //   114: invokestatic hasModel : (Landroid/content/Context;Ljava/lang/String;)Z
    //   117: ifeq -> 138
    //   120: aload_0
    //   121: invokevirtual getAssets : ()Landroid/content/res/AssetManager;
    //   124: ldc 'blur.binary'
    //   126: ldc ''
    //   128: getstatic com/baidu/idl/facesdk/FaceSDK$QualityModelType.QUALITY_BLUR : Lcom/baidu/idl/facesdk/FaceSDK$QualityModelType;
    //   131: invokevirtual ordinal : ()I
    //   134: invokestatic imgQualityModelInit : (Landroid/content/res/AssetManager;Ljava/lang/String;Ljava/lang/String;I)I
    //   137: pop
    //   138: aload_0
    //   139: ldc 'occlu.binary'
    //   141: invokestatic hasModel : (Landroid/content/Context;Ljava/lang/String;)Z
    //   144: ifeq -> 174
    //   147: aload_0
    //   148: invokevirtual getAssets : ()Landroid/content/res/AssetManager;
    //   151: ldc 'occlu.binary'
    //   153: ldc ''
    //   155: getstatic com/baidu/idl/facesdk/FaceSDK$QualityModelType.QUALITY_OCCLUSION : Lcom/baidu/idl/facesdk/FaceSDK$QualityModelType;
    //   158: invokevirtual ordinal : ()I
    //   161: invokestatic imgQualityModelInit : (Landroid/content/res/AssetManager;Ljava/lang/String;Ljava/lang/String;I)I
    //   164: pop
    //   165: goto -> 174
    //   168: astore_0
    //   169: ldc com/baidu/idl/facesdk/FaceSDK
    //   171: monitorexit
    //   172: aload_0
    //   173: athrow
    //   174: ldc com/baidu/idl/facesdk/FaceSDK
    //   176: monitorexit
    //   177: return
    // Exception table:
    //   from	to	target	type
    //   7	34	168	finally
    //   34	59	168	finally
    //   59	84	168	finally
    //   84	111	168	finally
    //   111	138	168	finally
    //   138	165	168	finally
  }
  
  private static native int liveness(int[] paramArrayOfint1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int[] paramArrayOfint2, int[] paramArrayOfint3, int paramInt5, int[] paramArrayOfint4);
  
  public static int livenessSilentInit(Context paramContext, LivenessTypeId paramLivenessTypeId) {
    byte b = -1;
    if (paramContext == null)
      return -1; 
    if (paramLivenessTypeId == LivenessTypeId.LIVEID_IR && BDFaceUtils.hasModel(paramContext, "liveness_nir_82-20180211.model"))
      return livenessSilentInit(paramContext.getAssets(), paramLivenessTypeId.ordinal(), "liveness_nir_82-20180211.model"); 
    if (paramLivenessTypeId == LivenessTypeId.LIVEID_DEPTH && BDFaceUtils.hasModel(paramContext, "liveness_depth_96-15_1_5.model"))
      return livenessSilentInit(paramContext.getAssets(), paramLivenessTypeId.ordinal(), "liveness_depth_96-15_1_5.model"); 
    int i = b;
    if (paramLivenessTypeId == LivenessTypeId.LIVEID_VIS) {
      i = b;
      if (BDFaceUtils.hasModel(paramContext, "liveness_vis_101.model"))
        i = livenessSilentInit(paramContext.getAssets(), paramLivenessTypeId.ordinal(), "liveness_vis_101.model"); 
    } 
    return i;
  }
  
  private static native int livenessSilentInit(AssetManager paramAssetManager, int paramInt, String paramString);
  
  private static native float livenessSilentPredict(int paramInt1, int[] paramArrayOfint1, int paramInt2, int paramInt3, int paramInt4, int[] paramArrayOfint2);
  
  private static native float livenessSilentPredictByte(int paramInt1, byte[] paramArrayOfbyte, int paramInt2, int paramInt3, int paramInt4, int[] paramArrayOfint);
  
  private static native int parsing(int[] paramArrayOfint1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int[] paramArrayOfint2, int paramInt5, byte[] paramArrayOfbyte);
  
  private static native FaceVerifyData removeTexture(int[] paramArrayOfint, int paramInt1, int paramInt2, int paramInt3);
  
  public static FaceVerifyData removeTexture(int[] paramArrayOfint, int paramInt1, int paramInt2, ImgType paramImgType) {
    return !checkParameter(paramArrayOfint, paramInt1, paramInt2) ? null : removeTexture(paramArrayOfint, paramInt1, paramInt2, paramImgType.ordinal());
  }
  
  public static int removeTextureModelInit(Context paramContext) {
    return (paramContext == null || !BDFaceUtils.hasModel(paramContext, "remove_texture.model_fix")) ? -1 : removeTextureModelInit(paramContext.getAssets(), "remove_texture.model_fix");
  }
  
  private static native int removeTextureModelInit(AssetManager paramAssetManager, String paramString);
  
  public static int run_align(int[] paramArrayOfint1, int paramInt1, int paramInt2, ImgType paramImgType, AlignMethodType paramAlignMethodType, int[] paramArrayOfint2, int[] paramArrayOfint3, int[] paramArrayOfint4, float[] paramArrayOffloat) {
    return !checkParameter(paramArrayOfint1, paramInt1, paramInt2) ? -1 : align(paramArrayOfint1, paramInt1, paramInt2, paramImgType.ordinal(), paramAlignMethodType.ordinal(), paramArrayOfint2, paramArrayOfint3, paramArrayOfint4, paramArrayOffloat);
  }
  
  public static int run_cropFaceImg(int[] paramArrayOfint1, int paramInt1, int paramInt2, ImgType paramImgType, int[] paramArrayOfint2, int paramInt3, int paramInt4, int paramInt5, int[] paramArrayOfint3, int[] paramArrayOfint4) {
    return !checkParameter(paramArrayOfint1, paramInt1, paramInt2) ? -1 : cropFaceImg(paramArrayOfint1, paramInt1, paramInt2, paramImgType.ordinal(), paramArrayOfint2, paramInt3, paramInt4, paramInt5, paramArrayOfint3, paramArrayOfint4);
  }
  
  public static FaceInfo[] run_detect(int[] paramArrayOfint, int paramInt1, int paramInt2, ImgType paramImgType, DetectMethodType paramDetectMethodType, int paramInt3) {
    return detect(paramArrayOfint, paramInt1, paramInt2, paramImgType.ordinal(), paramDetectMethodType.ordinal(), paramInt3);
  }
  
  public static int run_fineAlign(int[] paramArrayOfint1, int paramInt1, int paramInt2, ImgType paramImgType, int[] paramArrayOfint2, int[] paramArrayOfint3) {
    return !checkParameter(paramArrayOfint1, paramInt1, paramInt2) ? -1 : fineAlign(paramArrayOfint1, paramInt1, paramInt2, paramImgType.ordinal(), paramArrayOfint2, paramArrayOfint3);
  }
  
  public static int run_headPoseEstimation(int[] paramArrayOfint1, int[] paramArrayOfint2, double[] paramArrayOfdouble) {
    return headPoseEstimation(paramArrayOfint1, paramArrayOfint2[0], paramArrayOfdouble);
  }
  
  public static int run_imgQuality(int[] paramArrayOfint1, int paramInt1, int paramInt2, int paramInt3, int[] paramArrayOfint2, int paramInt4, float[] paramArrayOffloat1, int[] paramArrayOfint3, float[] paramArrayOffloat2, int[] paramArrayOfint4) {
    return !checkParameter(paramArrayOfint1, paramInt1, paramInt2) ? -1 : imgQuality(paramArrayOfint1, paramInt1, paramInt2, paramInt3, paramArrayOfint2, paramInt4, paramArrayOffloat1, paramArrayOfint3, paramArrayOffloat2, paramArrayOfint4);
  }
  
  public static int run_liveness(int[] paramArrayOfint1, int paramInt1, int paramInt2, ImgType paramImgType, LivenessMethodType paramLivenessMethodType, int[] paramArrayOfint2, int[] paramArrayOfint3, LivenessAction paramLivenessAction, int[] paramArrayOfint4) {
    return !checkParameter(paramArrayOfint1, paramInt1, paramInt2) ? -1 : liveness(paramArrayOfint1, paramInt1, paramInt2, paramImgType.ordinal(), paramLivenessMethodType.ordinal(), paramArrayOfint2, paramArrayOfint3, paramLivenessAction.ordinal(), paramArrayOfint4);
  }
  
  public static float run_livenessSilentPredict(LivenessTypeId paramLivenessTypeId, int[] paramArrayOfint1, int paramInt1, int paramInt2, int paramInt3, int[] paramArrayOfint2) {
    return !checkParameter(paramArrayOfint1, paramInt1, paramInt2) ? -1.0F : livenessSilentPredict(paramLivenessTypeId.ordinal(), paramArrayOfint1, paramInt1, paramInt2, paramInt3, paramArrayOfint2);
  }
  
  public static float run_livenessSilentPredictByte(LivenessTypeId paramLivenessTypeId, byte[] paramArrayOfbyte, int paramInt1, int paramInt2, int paramInt3, int[] paramArrayOfint) {
    return !checkParameter(paramArrayOfbyte, paramInt1, paramInt2) ? -1.0F : livenessSilentPredictByte(paramLivenessTypeId.ordinal(), paramArrayOfbyte, paramInt1, paramInt2, paramInt3, paramArrayOfint);
  }
  
  public static int run_parsing(int[] paramArrayOfint1, int paramInt1, int paramInt2, ImgType paramImgType, ParsMethodType paramParsMethodType, int[] paramArrayOfint2, int paramInt3, byte[] paramArrayOfbyte) {
    return !checkParameter(paramArrayOfint1, paramInt1, paramInt2) ? -1 : parsing(paramArrayOfint1, paramInt1, paramInt2, paramImgType.ordinal(), paramParsMethodType.ordinal(), paramArrayOfint2, paramInt3, paramArrayOfbyte);
  }
  
  private static int run_tracking(int[] paramArrayOfint1, int paramInt1, int paramInt2, ImgType paramImgType, AlignMethodType paramAlignMethodType, int[] paramArrayOfint2, int[] paramArrayOfint3, float[] paramArrayOffloat) {
    return !checkParameter(paramArrayOfint1, paramInt1, paramInt2) ? -1 : tracking(paramArrayOfint1, paramInt1, paramInt2, paramImgType.ordinal(), paramAlignMethodType.ordinal(), paramArrayOfint2, paramArrayOfint3, paramArrayOffloat);
  }
  
  public static native int setNumberOfThreads(int paramInt);
  
  public static native int setPerfLogFlag(int paramInt);
  
  public static native int setValueLogFlag(int paramInt);
  
  private static native FaceVerifyData superResolution(int[] paramArrayOfint, int paramInt1, int paramInt2, int paramInt3);
  
  public static FaceVerifyData superResolution(int[] paramArrayOfint, int paramInt1, int paramInt2, ImgType paramImgType) {
    return !checkParameter(paramArrayOfint, paramInt1, paramInt2) ? null : superResolution(paramArrayOfint, paramInt1, paramInt2, paramImgType.ordinal());
  }
  
  public static int superResolutionMoelInit(Context paramContext) {
    return (paramContext == null || !BDFaceUtils.hasModel(paramContext, "super_resolution.model_fix")) ? -1 : superResolutionMoelInit(paramContext.getAssets(), "super_resolution.model_fix");
  }
  
  private static native int superResolutionMoelInit(AssetManager paramAssetManager, String paramString);
  
  private static native int tracking(int[] paramArrayOfint1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int[] paramArrayOfint2, int[] paramArrayOfint3, float[] paramArrayOffloat);
  
  public enum AlignMethodType {
    CDNN, SDM, SDM_15PTS, SDM_7PTS;
    
    static {
      SDM_15PTS = new AlignMethodType("SDM_15PTS", 3);
      $VALUES = new AlignMethodType[] { SDM, CDNN, SDM_7PTS, SDM_15PTS };
    }
  }
  
  public enum DetectMethodType {
    BOOST, CNN, NIR;
    
    static {
    
    }
  }
  
  public enum ImgType {
    ARGB;
    
    static {
    
    }
  }
  
  public enum LivenessAction {
    ADD_ONE_FRAME, RESET;
    
    static {
      $VALUES = new LivenessAction[] { RESET, ADD_ONE_FRAME };
    }
  }
  
  public enum LivenessMethodType {
    ALL, EYE_BLINK, HEAD_POSE, MOUTH_MOTION;
    
    static {
      ALL = new LivenessMethodType("ALL", 3);
      $VALUES = new LivenessMethodType[] { EYE_BLINK, MOUTH_MOTION, HEAD_POSE, ALL };
    }
  }
  
  public enum LivenessTypeId {
    LIVEID_IR, LIVEID_VIS, LIVEID_DEPTH;
    
    static {
      $VALUES = new LivenessTypeId[] { LIVEID_IR, LIVEID_DEPTH, LIVEID_VIS };
    }
  }
  
  public enum ParsMethodType {
    CLASS_NUM_10, CLASS_NUM_3, CLASS_NUM_7, NOT_USE;
    
    static {
      CLASS_NUM_10 = new ParsMethodType("CLASS_NUM_10", 3);
      $VALUES = new ParsMethodType[] { NOT_USE, CLASS_NUM_3, CLASS_NUM_7, CLASS_NUM_10 };
    }
  }
  
  public enum QualityModelType {
    QUALITY_BLUR, QUALITY_NOT_USE, QUALITY_OCCLUSION;
    
    static {
      $VALUES = new QualityModelType[] { QUALITY_NOT_USE, QUALITY_BLUR, QUALITY_OCCLUSION };
    }
  }
  
  public enum RecognizeType {
    RECOGNIZE_ID_PHOTO, RECOGNIZE_LIVE, RECOGNIZE_NIR;
    
    static {
    
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\baidu\idl\facesdk\FaceSDK.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */