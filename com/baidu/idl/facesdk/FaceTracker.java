package com.baidu.idl.facesdk;

import android.content.Context;
import android.content.res.AssetManager;
import java.util.HashMap;
import java.util.Map;

public class FaceTracker {
  private static final String TAG = FaceTracker.class.getSimpleName();
  
  private Map<String, Boolean> abilities = new HashMap<String, Boolean>();
  
  private Context context;
  
  private long index = 1L;
  
  public FaceTracker(Context paramContext) {
    if (paramContext != null) {
      create();
      if (BDFaceUtils.hasModel(paramContext, "align_model.binary")) {
        AlignModelInit(paramContext.getAssets(), "align_model.binary", "", FaceSDK.AlignMethodType.CDNN.ordinal());
        this.abilities.put("align_model.binary", Boolean.valueOf(true));
      } 
      if (BDFaceUtils.hasModel(paramContext, "facedetect.binary")) {
        DetectModelInit(paramContext.getAssets(), "facedetect.binary", FaceSDK.DetectMethodType.CNN.ordinal());
        this.abilities.put("facedetect.binary", Boolean.valueOf(true));
      } 
      if (BDFaceUtils.hasModel(paramContext, "small_detect.model")) {
        DetectModelInit(paramContext.getAssets(), "small_detect.model", FaceSDK.DetectMethodType.NIR.ordinal());
        this.abilities.put("small_detect.model", Boolean.valueOf(true));
      } 
      if (BDFaceUtils.hasModel(paramContext, "score.binary")) {
        ScoreModelInit(paramContext.getAssets(), "score.binary", "", FaceSDK.DetectMethodType.CNN.ordinal());
        this.abilities.put("score.binary", Boolean.valueOf(true));
      } 
      if (BDFaceUtils.hasModel(paramContext, "blur.binary")) {
        imgQualityModelInit(paramContext.getAssets(), "blur.binary", "", FaceSDK.QualityModelType.QUALITY_BLUR.ordinal());
        this.abilities.put("blur.binary", Boolean.valueOf(true));
      } 
      if (BDFaceUtils.hasModel(paramContext, "occlu.binary")) {
        imgQualityModelInit(paramContext.getAssets(), "occlu.binary", "", FaceSDK.QualityModelType.QUALITY_OCCLUSION.ordinal());
        this.abilities.put("occlu.binary", Boolean.valueOf(true));
      } 
    } 
  }
  
  private native int AlignModelInit(AssetManager paramAssetManager, String paramString1, String paramString2, int paramInt);
  
  private native int DetectModelInit(AssetManager paramAssetManager, String paramString, int paramInt);
  
  private native int ParsingModelInit(AssetManager paramAssetManager, String paramString1, String paramString2, int paramInt);
  
  private native int ScoreModelInit(AssetManager paramAssetManager, String paramString1, String paramString2, int paramInt);
  
  private native int create();
  
  private native int imgQualityModelInit(AssetManager paramAssetManager, String paramString1, String paramString2, int paramInt);
  
  private native void tracking(int[] paramArrayOfint, int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  public native int clearTrackedFaces();
  
  public ErrCode faceVerification(int[] paramArrayOfint, int paramInt1, int paramInt2, FaceSDK.ImgType paramImgType, ActionType paramActionType) {
    if (!FaceSDK.checkParameter(paramArrayOfint, paramInt1, paramInt2))
      return ErrCode.UNKNOW_TYPE; 
    paramInt1 = prepare_data_for_verify(paramArrayOfint, paramInt1, paramInt2, paramImgType.ordinal(), paramActionType.ordinal());
    return (paramInt1 == ErrCode.OK.ordinal()) ? ErrCode.OK : ((paramInt1 > 0) ? ErrCode.values()[paramInt1] : ErrCode.UNKNOW_TYPE);
  }
  
  public native FaceVerifyData[] get_FaceVerifyData(int paramInt);
  
  public native FaceInfo[] get_TrackedFaceInfo();
  
  public native FaceSleepnessInfo[] get_sleepnessInfo();
  
  public ErrCode maxFaceVerification(int[] paramArrayOfint, int paramInt1, int paramInt2, FaceSDK.ImgType paramImgType, ActionType paramActionType) {
    if (!FaceSDK.checkParameter(paramArrayOfint, paramInt1, paramInt2))
      return ErrCode.UNKNOW_TYPE; 
    paramInt1 = prepare_max_face_data_for_verify(paramArrayOfint, paramInt1, paramInt2, paramImgType.ordinal(), paramActionType.ordinal());
    return (paramInt1 == ErrCode.OK.ordinal()) ? ErrCode.OK : ((paramInt1 > 0) ? ErrCode.values()[paramInt1] : ErrCode.UNKNOW_TYPE);
  }
  
  public native int prepare_data_for_verify(int[] paramArrayOfint, int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  public native int prepare_max_face_data_for_verify(int[] paramArrayOfint, int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  public native int re_collect_reg_imgs();
  
  public native int setAppType(int paramInt);
  
  public native int set_AlignMethodType(int paramInt);
  
  public native int set_DetectMethodType(int paramInt);
  
  public native int set_blur_thr(float paramFloat);
  
  public native int set_cropFaceEnlargeRatio(float paramFloat);
  
  public native int set_cropFaceSize(int paramInt);
  
  public native int set_detect_in_video_interval(int paramInt);
  
  @Deprecated
  public native int set_detection_frame_interval(int paramInt);
  
  public native int set_eulur_angle_thr(int paramInt1, int paramInt2, int paramInt3);
  
  public native int set_illum_thr(float paramFloat);
  
  @Deprecated
  public native int set_intervalTime(long paramLong);
  
  public native int set_isCheckQuality(boolean paramBoolean);
  
  public native int set_isFineAlign(boolean paramBoolean);
  
  public native int set_isVerifyLive(boolean paramBoolean);
  
  public native int set_max_reg_img_num(int paramInt);
  
  public native int set_min_face_size(int paramInt);
  
  public native int set_notFace_thr(float paramFloat);
  
  public native int set_occlu_thr(float paramFloat);
  
  public native int set_track_by_detection_interval(int paramInt);
  
  public void track(int[] paramArrayOfint, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    if (!FaceSDK.checkParameter(paramArrayOfint, paramInt1, paramInt2))
      return; 
    tracking(paramArrayOfint, paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public enum ActionType {
    DELETE, RECOGNIZE, REGIST, VERIFY;
    
    static {
      $VALUES = new ActionType[] { DELETE, REGIST, VERIFY, RECOGNIZE };
    }
  }
  
  public enum ErrCode {
    OK, PITCH_OUT_OF_DOWN_MAX_RANGE, DATA_HIT_LAST, DATA_HIT_ONE, DATA_NOT_READY, FACE_NOT_COMPLETE, IMG_BLURED, NO_FACE_DETECTED, OCCLUSION_CHIN_CONTOUR, OCCLUSION_LEFT_CONTOUR, OCCLUSION_LEFT_EYE, OCCLUSION_MOUTH, OCCLUSION_NOSE, OCCLUSION_RIGHT_CONTOUR, OCCLUSION_RIGHT_EYE, PITCH_OUT_OF_UP_MAX_RANGE, POOR_ILLUMINATION, UNKNOW_TYPE, YAW_OUT_OF_LEFT_MAX_RANGE, YAW_OUT_OF_RIGHT_MAX_RANGE;
    
    static {
      NO_FACE_DETECTED = new ErrCode("NO_FACE_DETECTED", 6);
      DATA_NOT_READY = new ErrCode("DATA_NOT_READY", 7);
      DATA_HIT_ONE = new ErrCode("DATA_HIT_ONE", 8);
      DATA_HIT_LAST = new ErrCode("DATA_HIT_LAST", 9);
      IMG_BLURED = new ErrCode("IMG_BLURED", 10);
      OCCLUSION_LEFT_EYE = new ErrCode("OCCLUSION_LEFT_EYE", 11);
      OCCLUSION_RIGHT_EYE = new ErrCode("OCCLUSION_RIGHT_EYE", 12);
      OCCLUSION_NOSE = new ErrCode("OCCLUSION_NOSE", 13);
      OCCLUSION_MOUTH = new ErrCode("OCCLUSION_MOUTH", 14);
      OCCLUSION_LEFT_CONTOUR = new ErrCode("OCCLUSION_LEFT_CONTOUR", 15);
      OCCLUSION_RIGHT_CONTOUR = new ErrCode("OCCLUSION_RIGHT_CONTOUR", 16);
      OCCLUSION_CHIN_CONTOUR = new ErrCode("OCCLUSION_CHIN_CONTOUR", 17);
      FACE_NOT_COMPLETE = new ErrCode("FACE_NOT_COMPLETE", 18);
      UNKNOW_TYPE = new ErrCode("UNKNOW_TYPE", 19);
      $VALUES = new ErrCode[] { 
          OK, PITCH_OUT_OF_DOWN_MAX_RANGE, PITCH_OUT_OF_UP_MAX_RANGE, YAW_OUT_OF_LEFT_MAX_RANGE, YAW_OUT_OF_RIGHT_MAX_RANGE, POOR_ILLUMINATION, NO_FACE_DETECTED, DATA_NOT_READY, DATA_HIT_ONE, DATA_HIT_LAST, 
          IMG_BLURED, OCCLUSION_LEFT_EYE, OCCLUSION_RIGHT_EYE, OCCLUSION_NOSE, OCCLUSION_MOUTH, OCCLUSION_LEFT_CONTOUR, OCCLUSION_RIGHT_CONTOUR, OCCLUSION_CHIN_CONTOUR, FACE_NOT_COMPLETE, UNKNOW_TYPE };
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\baidu\idl\facesdk\FaceTracker.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */