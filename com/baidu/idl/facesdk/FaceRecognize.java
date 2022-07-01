package com.baidu.idl.facesdk;

import android.content.Context;
import android.content.res.AssetManager;
import android.util.Log;
import java.util.HashMap;
import java.util.Map;

public class FaceRecognize {
  private static final String TAG = "FaceRecognize";
  
  private Map<FaceSDK.RecognizeType, Boolean> abilities = new HashMap<FaceSDK.RecognizeType, Boolean>();
  
  private Context context;
  
  private boolean isInitModel = false;
  
  public FaceRecognize(Context paramContext) {
    this.context = paramContext;
  }
  
  private native int extractFeature(int[] paramArrayOfint1, int paramInt1, int paramInt2, int paramInt3, byte[] paramArrayOfbyte, int[] paramArrayOfint2, int paramInt4, int paramInt5);
  
  private native float getConsineDistance(byte[] paramArrayOfbyte1, byte[] paramArrayOfbyte2);
  
  private native float getFaceSimilarity(byte[] paramArrayOfbyte1, byte[] paramArrayOfbyte2, int paramInt1, int paramInt2);
  
  private native int recognizeModelInit(AssetManager paramAssetManager, String paramString, int paramInt);
  
  private native int scoreMapInit(AssetManager paramAssetManager, String paramString, int paramInt);
  
  public int extractFeature(int[] paramArrayOfint, int paramInt1, int paramInt2, FaceSDK.ImgType paramImgType, int paramInt3, byte[] paramArrayOfbyte, FaceSDK.RecognizeType paramRecognizeType) {
    // Byte code:
    //   0: aload_0
    //   1: getfield abilities : Ljava/util/Map;
    //   4: aload #7
    //   6: invokeinterface containsKey : (Ljava/lang/Object;)Z
    //   11: ifne -> 48
    //   14: new java/lang/StringBuilder
    //   17: dup
    //   18: invokespecial <init> : ()V
    //   21: astore_1
    //   22: aload_1
    //   23: ldc 'not success init '
    //   25: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   28: pop
    //   29: aload_1
    //   30: aload #7
    //   32: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   35: pop
    //   36: ldc 'FaceRecognize'
    //   38: aload_1
    //   39: invokevirtual toString : ()Ljava/lang/String;
    //   42: invokestatic e : (Ljava/lang/String;Ljava/lang/String;)I
    //   45: pop
    //   46: iconst_m1
    //   47: ireturn
    //   48: aload_1
    //   49: iload_2
    //   50: iload_3
    //   51: invokestatic checkParameter : (Ljava/lang/Object;II)Z
    //   54: ifne -> 59
    //   57: iconst_m1
    //   58: ireturn
    //   59: aload #6
    //   61: ifnull -> 664
    //   64: aload #6
    //   66: arraylength
    //   67: sipush #2048
    //   70: if_icmpeq -> 76
    //   73: goto -> 664
    //   76: aload_0
    //   77: getfield isInitModel : Z
    //   80: ifne -> 106
    //   83: aload_0
    //   84: getfield context : Landroid/content/Context;
    //   87: astore #15
    //   89: aload #15
    //   91: ifnonnull -> 96
    //   94: iconst_m1
    //   95: ireturn
    //   96: aload #15
    //   98: invokestatic initModel : (Landroid/content/Context;)V
    //   101: aload_0
    //   102: iconst_1
    //   103: putfield isInitModel : Z
    //   106: aconst_null
    //   107: astore #16
    //   109: invokestatic currentTimeMillis : ()J
    //   112: lstore #11
    //   114: invokestatic currentTimeMillis : ()J
    //   117: lstore #13
    //   119: iload #5
    //   121: ifne -> 131
    //   124: bipush #100
    //   126: istore #5
    //   128: goto -> 131
    //   131: aload #16
    //   133: astore #15
    //   135: ldc 'FaceRecognize'
    //   137: ldc 'detect start'
    //   139: invokestatic e : (Ljava/lang/String;Ljava/lang/String;)I
    //   142: pop
    //   143: aload #16
    //   145: astore #15
    //   147: aload #7
    //   149: getstatic com/baidu/idl/facesdk/FaceSDK$RecognizeType.RECOGNIZE_LIVE : Lcom/baidu/idl/facesdk/FaceSDK$RecognizeType;
    //   152: if_acmpeq -> 192
    //   155: aload #16
    //   157: astore #15
    //   159: aload #7
    //   161: getstatic com/baidu/idl/facesdk/FaceSDK$RecognizeType.RECOGNIZE_ID_PHOTO : Lcom/baidu/idl/facesdk/FaceSDK$RecognizeType;
    //   164: if_acmpne -> 170
    //   167: goto -> 192
    //   170: aload #16
    //   172: astore #15
    //   174: aload_1
    //   175: iload_2
    //   176: iload_3
    //   177: aload #4
    //   179: getstatic com/baidu/idl/facesdk/FaceSDK$DetectMethodType.NIR : Lcom/baidu/idl/facesdk/FaceSDK$DetectMethodType;
    //   182: iload #5
    //   184: invokestatic run_detect : ([IIILcom/baidu/idl/facesdk/FaceSDK$ImgType;Lcom/baidu/idl/facesdk/FaceSDK$DetectMethodType;I)[Lcom/baidu/idl/facesdk/FaceInfo;
    //   187: astore #16
    //   189: goto -> 211
    //   192: aload #16
    //   194: astore #15
    //   196: aload_1
    //   197: iload_2
    //   198: iload_3
    //   199: aload #4
    //   201: getstatic com/baidu/idl/facesdk/FaceSDK$DetectMethodType.CNN : Lcom/baidu/idl/facesdk/FaceSDK$DetectMethodType;
    //   204: iload #5
    //   206: invokestatic run_detect : ([IIILcom/baidu/idl/facesdk/FaceSDK$ImgType;Lcom/baidu/idl/facesdk/FaceSDK$DetectMethodType;I)[Lcom/baidu/idl/facesdk/FaceInfo;
    //   209: astore #16
    //   211: aload #16
    //   213: astore #15
    //   215: new java/lang/StringBuilder
    //   218: dup
    //   219: invokespecial <init> : ()V
    //   222: astore #17
    //   224: aload #16
    //   226: astore #15
    //   228: aload #17
    //   230: ldc 'detect end '
    //   232: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   235: pop
    //   236: aload #16
    //   238: astore #15
    //   240: aload #17
    //   242: invokestatic currentTimeMillis : ()J
    //   245: lload #13
    //   247: lsub
    //   248: invokevirtual append : (J)Ljava/lang/StringBuilder;
    //   251: pop
    //   252: aload #16
    //   254: astore #15
    //   256: ldc 'FaceRecognize'
    //   258: aload #17
    //   260: invokevirtual toString : ()Ljava/lang/String;
    //   263: invokestatic e : (Ljava/lang/String;Ljava/lang/String;)I
    //   266: pop
    //   267: aload #16
    //   269: astore #15
    //   271: goto -> 289
    //   274: astore #16
    //   276: ldc 'FaceRecognize'
    //   278: ldc 'FaceSDK: You need to apply for the authorization to use the facesdk'
    //   280: invokestatic i : (Ljava/lang/String;Ljava/lang/String;)I
    //   283: pop
    //   284: aload #16
    //   286: invokevirtual printStackTrace : ()V
    //   289: aload #15
    //   291: ifnull -> 662
    //   294: aload #15
    //   296: arraylength
    //   297: ifle -> 662
    //   300: invokestatic currentTimeMillis : ()J
    //   303: lstore #13
    //   305: iconst_0
    //   306: istore #5
    //   308: iconst_0
    //   309: istore #8
    //   311: iconst_0
    //   312: istore #9
    //   314: iload #5
    //   316: aload #15
    //   318: arraylength
    //   319: if_icmpge -> 366
    //   322: iload #9
    //   324: istore #10
    //   326: aload #15
    //   328: iload #5
    //   330: aaload
    //   331: getfield mWidth : I
    //   334: iload #9
    //   336: if_icmple -> 353
    //   339: aload #15
    //   341: iload #5
    //   343: aaload
    //   344: getfield mWidth : I
    //   347: istore #10
    //   349: iload #5
    //   351: istore #8
    //   353: iload #5
    //   355: iconst_1
    //   356: iadd
    //   357: istore #5
    //   359: iload #10
    //   361: istore #9
    //   363: goto -> 314
    //   366: aload #15
    //   368: iload #8
    //   370: aaload
    //   371: getfield mCenter_x : I
    //   374: istore #5
    //   376: aload #15
    //   378: iload #8
    //   380: aaload
    //   381: getfield mCenter_y : I
    //   384: istore #9
    //   386: aload #15
    //   388: iload #8
    //   390: aaload
    //   391: getfield mWidth : I
    //   394: istore #10
    //   396: aload #15
    //   398: iload #8
    //   400: aaload
    //   401: getfield mAngle : I
    //   404: istore #8
    //   406: sipush #144
    //   409: newarray int
    //   411: astore #15
    //   413: ldc 'FaceRecognize'
    //   415: ldc 'align start'
    //   417: invokestatic e : (Ljava/lang/String;Ljava/lang/String;)I
    //   420: pop
    //   421: aload_1
    //   422: iload_2
    //   423: iload_3
    //   424: aload #4
    //   426: getstatic com/baidu/idl/facesdk/FaceSDK$AlignMethodType.CDNN : Lcom/baidu/idl/facesdk/FaceSDK$AlignMethodType;
    //   429: iconst_4
    //   430: newarray int
    //   432: dup
    //   433: iconst_0
    //   434: iload #5
    //   436: iastore
    //   437: dup
    //   438: iconst_1
    //   439: iload #9
    //   441: iastore
    //   442: dup
    //   443: iconst_2
    //   444: iload #10
    //   446: iastore
    //   447: dup
    //   448: iconst_3
    //   449: iload #8
    //   451: iastore
    //   452: aload #15
    //   454: iconst_1
    //   455: newarray int
    //   457: dup
    //   458: iconst_0
    //   459: iconst_0
    //   460: iastore
    //   461: iconst_1
    //   462: newarray float
    //   464: dup
    //   465: iconst_0
    //   466: fconst_0
    //   467: fastore
    //   468: invokestatic run_align : ([IIILcom/baidu/idl/facesdk/FaceSDK$ImgType;Lcom/baidu/idl/facesdk/FaceSDK$AlignMethodType;[I[I[I[F)I
    //   471: pop
    //   472: new java/lang/StringBuilder
    //   475: dup
    //   476: invokespecial <init> : ()V
    //   479: astore #16
    //   481: aload #16
    //   483: ldc 'align end '
    //   485: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   488: pop
    //   489: aload #16
    //   491: invokestatic currentTimeMillis : ()J
    //   494: lload #13
    //   496: lsub
    //   497: invokevirtual append : (J)Ljava/lang/StringBuilder;
    //   500: pop
    //   501: ldc 'FaceRecognize'
    //   503: aload #16
    //   505: invokevirtual toString : ()Ljava/lang/String;
    //   508: invokestatic e : (Ljava/lang/String;Ljava/lang/String;)I
    //   511: pop
    //   512: goto -> 530
    //   515: astore #16
    //   517: ldc 'FaceRecognize'
    //   519: ldc 'You need to apply for the authorization to use the facesdk'
    //   521: invokestatic i : (Ljava/lang/String;Ljava/lang/String;)I
    //   524: pop
    //   525: aload #16
    //   527: invokevirtual printStackTrace : ()V
    //   530: invokestatic currentTimeMillis : ()J
    //   533: lstore #13
    //   535: ldc 'FaceRecognize'
    //   537: ldc 'feature start'
    //   539: invokestatic e : (Ljava/lang/String;Ljava/lang/String;)I
    //   542: pop
    //   543: aload_0
    //   544: aload_1
    //   545: iload_2
    //   546: iload_3
    //   547: aload #4
    //   549: invokevirtual ordinal : ()I
    //   552: aload #6
    //   554: aload #15
    //   556: iconst_1
    //   557: aload #7
    //   559: invokevirtual ordinal : ()I
    //   562: invokespecial extractFeature : ([IIII[B[III)I
    //   565: istore_2
    //   566: new java/lang/StringBuilder
    //   569: dup
    //   570: invokespecial <init> : ()V
    //   573: astore_1
    //   574: aload_1
    //   575: ldc 'feature end '
    //   577: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   580: pop
    //   581: aload_1
    //   582: invokestatic currentTimeMillis : ()J
    //   585: lload #13
    //   587: lsub
    //   588: invokevirtual append : (J)Ljava/lang/StringBuilder;
    //   591: pop
    //   592: ldc 'FaceRecognize'
    //   594: aload_1
    //   595: invokevirtual toString : ()Ljava/lang/String;
    //   598: invokestatic e : (Ljava/lang/String;Ljava/lang/String;)I
    //   601: pop
    //   602: goto -> 624
    //   605: astore_1
    //   606: goto -> 612
    //   609: astore_1
    //   610: iconst_m1
    //   611: istore_2
    //   612: ldc 'FaceRecognize'
    //   614: ldc 'You need to apply for the authorization to use the facesdk'
    //   616: invokestatic i : (Ljava/lang/String;Ljava/lang/String;)I
    //   619: pop
    //   620: aload_1
    //   621: invokevirtual printStackTrace : ()V
    //   624: new java/lang/StringBuilder
    //   627: dup
    //   628: invokespecial <init> : ()V
    //   631: astore_1
    //   632: aload_1
    //   633: ldc 'all time '
    //   635: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   638: pop
    //   639: aload_1
    //   640: invokestatic currentTimeMillis : ()J
    //   643: lload #11
    //   645: lsub
    //   646: invokevirtual append : (J)Ljava/lang/StringBuilder;
    //   649: pop
    //   650: ldc 'FaceRecognize'
    //   652: aload_1
    //   653: invokevirtual toString : ()Ljava/lang/String;
    //   656: invokestatic e : (Ljava/lang/String;Ljava/lang/String;)I
    //   659: pop
    //   660: iload_2
    //   661: ireturn
    //   662: iconst_m1
    //   663: ireturn
    //   664: iconst_m1
    //   665: ireturn
    // Exception table:
    //   from	to	target	type
    //   135	143	274	java/lang/Exception
    //   147	155	274	java/lang/Exception
    //   159	167	274	java/lang/Exception
    //   174	189	274	java/lang/Exception
    //   196	211	274	java/lang/Exception
    //   215	224	274	java/lang/Exception
    //   228	236	274	java/lang/Exception
    //   240	252	274	java/lang/Exception
    //   256	267	274	java/lang/Exception
    //   413	512	515	java/lang/Exception
    //   535	566	609	java/lang/Exception
    //   566	602	605	java/lang/Exception
  }
  
  public int extractFeature(int[] paramArrayOfint1, int paramInt1, int paramInt2, FaceSDK.ImgType paramImgType, byte[] paramArrayOfbyte, int[] paramArrayOfint2, FaceSDK.RecognizeType paramRecognizeType) {
    StringBuilder stringBuilder;
    if (!this.abilities.containsKey(paramRecognizeType)) {
      stringBuilder = new StringBuilder();
      stringBuilder.append("not success init ");
      stringBuilder.append(paramRecognizeType);
      Log.e("FaceRecognize", stringBuilder.toString());
      return -1;
    } 
    return !FaceSDK.checkParameter(stringBuilder, paramInt1, paramInt2) ? -1 : ((paramArrayOfint2 == null) ? -1 : ((paramArrayOfbyte != null) ? ((paramArrayOfbyte.length != 2048) ? -1 : extractFeature((int[])stringBuilder, paramInt1, paramInt2, paramImgType.ordinal(), paramArrayOfbyte, paramArrayOfint2, 1, paramRecognizeType.ordinal())) : -1));
  }
  
  public float getFaceFeatureDistance(byte[] paramArrayOfbyte1, byte[] paramArrayOfbyte2) {
    if (paramArrayOfbyte1 != null) {
      if (paramArrayOfbyte2 == null)
        return -1.0F; 
      if (paramArrayOfbyte1.length != paramArrayOfbyte2.length)
        return -1.0F; 
      float f = getConsineDistance(paramArrayOfbyte1, paramArrayOfbyte2);
      return Float.isNaN(f) ? -1.0F : f;
    } 
    return -1.0F;
  }
  
  public float getFaceSimilarity(byte[] paramArrayOfbyte1, byte[] paramArrayOfbyte2, FaceSDK.RecognizeType paramRecognizeType) {
    if (paramRecognizeType == FaceSDK.RecognizeType.RECOGNIZE_ID_PHOTO || paramRecognizeType == FaceSDK.RecognizeType.RECOGNIZE_NIR) {
      if (BDFaceUtils.hasModel(this.context, "finance_rec_1p-compare.cfg")) {
        scoreMapInit(this.context.getAssets(), "finance_rec_1p-compare.cfg", paramRecognizeType.ordinal());
        return getFaceSimilarity(paramArrayOfbyte1, paramArrayOfbyte2, 0, paramRecognizeType.ordinal());
      } 
      return 0.0F;
    } 
    if (paramRecognizeType == FaceSDK.RecognizeType.RECOGNIZE_LIVE && BDFaceUtils.hasModel(this.context, "recognize_model-compare.cfg")) {
      scoreMapInit(this.context.getAssets(), "recognize_model-compare.cfg", paramRecognizeType.ordinal());
      return getFaceSimilarity(paramArrayOfbyte1, paramArrayOfbyte2, 0, paramRecognizeType.ordinal());
    } 
    return 0.0F;
  }
  
  public void initModel(FaceSDK.RecognizeType paramRecognizeType) {
    if (this.context != null) {
      if (paramRecognizeType == FaceSDK.RecognizeType.RECOGNIZE_ID_PHOTO && BDFaceUtils.hasModel(this.context, "finance_rec_1p.dat_fix")) {
        recognizeModelInit(this.context.getAssets(), "finance_rec_1p.dat_fix", FaceSDK.RecognizeType.RECOGNIZE_ID_PHOTO.ordinal());
        this.abilities.put(FaceSDK.RecognizeType.RECOGNIZE_ID_PHOTO, Boolean.valueOf(true));
      } 
      if (paramRecognizeType == FaceSDK.RecognizeType.RECOGNIZE_LIVE && BDFaceUtils.hasModel(this.context, "recognize_model.dat")) {
        recognizeModelInit(this.context.getAssets(), "recognize_model.dat", FaceSDK.RecognizeType.RECOGNIZE_LIVE.ordinal());
        this.abilities.put(FaceSDK.RecognizeType.RECOGNIZE_LIVE, Boolean.valueOf(true));
      } 
      if (paramRecognizeType == FaceSDK.RecognizeType.RECOGNIZE_NIR && BDFaceUtils.hasModel(this.context, "safe_1pfc1_nobn_100_32bit.kv")) {
        recognizeModelInit(this.context.getAssets(), "safe_1pfc1_nobn_100_32bit.kv", FaceSDK.RecognizeType.RECOGNIZE_NIR.ordinal());
        this.abilities.put(FaceSDK.RecognizeType.RECOGNIZE_NIR, Boolean.valueOf(true));
      } 
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\baidu\idl\facesdk\FaceRecognize.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */