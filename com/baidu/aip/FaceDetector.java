package com.baidu.aip;

import android.content.Context;
import com.baidu.idl.facesdk.FaceInfo;
import com.baidu.idl.facesdk.FaceSDK;
import com.baidu.idl.facesdk.FaceTracker;

public class FaceDetector {
  public static final float DEFAULT_BLURRINESS_THRESHOLD = 0.3F;
  
  public static final int DEFAULT_HEAD_ANGLE = 45;
  
  public static final float DEFAULT_ILLUMINATION_THRESHOLD = 40.0F;
  
  public static final int DEFAULT_MIN_FACE_SIZE = 80;
  
  public static final float DEFAULT_NOT_FACE_THRESHOLD = 0.8F;
  
  public static final float DEFAULT_OCCULTATION_THRESHOLD = 0.5F;
  
  public static final int DETECT_CODE_FACE_NOT_DETECTED;
  
  public static final int DETECT_CODE_NO_FACE_DETECTED;
  
  public static final int DETECT_CODE_OK = FaceTracker.ErrCode.OK.ordinal();
  
  public static final int DETECT_CODE_PITCH_OUT_OF_DOWN_MAX_RANGE = FaceTracker.ErrCode.PITCH_OUT_OF_DOWN_MAX_RANGE.ordinal();
  
  public static final int DETECT_CODE_PITCH_OUT_OF_UP_MAX_RANGE = FaceTracker.ErrCode.PITCH_OUT_OF_UP_MAX_RANGE.ordinal();
  
  public static final int DETECT_CODE_POOR_ILLUMINATION;
  
  public static final int DETECT_CODE_YAW_OUT_OF_LEFT_MAX_RANGE = FaceTracker.ErrCode.YAW_OUT_OF_LEFT_MAX_RANGE.ordinal();
  
  public static final int DETECT_CODE_YAW_OUT_OF_RIGHT_MAX_RANGE = FaceTracker.ErrCode.YAW_OUT_OF_RIGHT_MAX_RANGE.ordinal();
  
  private static FaceDetector sInstance;
  
  private FaceTracker mFaceTracker;
  
  static {
    DETECT_CODE_POOR_ILLUMINATION = FaceTracker.ErrCode.POOR_ILLUMINATION.ordinal();
    DETECT_CODE_FACE_NOT_DETECTED = FaceTracker.ErrCode.NO_FACE_DETECTED.ordinal();
    DETECT_CODE_NO_FACE_DETECTED = FaceTracker.ErrCode.NO_FACE_DETECTED.ordinal();
  }
  
  private FaceDetector(Context paramContext, String paramString1, String paramString2) {
    this.mFaceTracker = FaceSDKManager.getInstance().getFaceTracker(paramContext);
    this.mFaceTracker.set_isFineAlign(false);
    this.mFaceTracker.set_isVerifyLive(false);
    this.mFaceTracker.set_isCheckQuality(false);
    this.mFaceTracker.set_notFace_thr(0.8F);
    this.mFaceTracker.set_min_face_size(80);
    this.mFaceTracker.set_cropFaceSize(80);
    this.mFaceTracker.set_illum_thr(40.0F);
    this.mFaceTracker.set_blur_thr(0.3F);
    this.mFaceTracker.set_occlu_thr(0.5F);
    this.mFaceTracker.set_max_reg_img_num(1);
    this.mFaceTracker.set_eulur_angle_thr(45, 45, 45);
    FaceSDK.setNumberOfThreads(4);
  }
  
  public static FaceDetector getInstance() {
    return sInstance;
  }
  
  public static void init(Context paramContext, String paramString1, String paramString2) {
    if (sInstance == null)
      sInstance = new FaceDetector(paramContext, paramString1, paramString2); 
  }
  
  public static void yuvToARGB(byte[] paramArrayOfbyte, int paramInt1, int paramInt2, int[] paramArrayOfint, int paramInt3, int paramInt4) {
    FaceSDK.getARGBFromYUVimg(paramArrayOfbyte, paramArrayOfint, paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void clearTrackedFaces() {
    this.mFaceTracker.clearTrackedFaces();
  }
  
  public int detect(ImageFrame paramImageFrame) {
    return detect(paramImageFrame.getArgb(), paramImageFrame.getWidth(), paramImageFrame.getHeight());
  }
  
  public int detect(int[] paramArrayOfint, int paramInt1, int paramInt2) {
    return this.mFaceTracker.prepare_max_face_data_for_verify(paramArrayOfint, paramInt2, paramInt1, FaceSDK.ImgType.ARGB.ordinal(), FaceTracker.ActionType.RECOGNIZE.ordinal());
  }
  
  public FaceInfo getTrackedFace() {
    FaceInfo[] arrayOfFaceInfo = this.mFaceTracker.get_TrackedFaceInfo();
    return (arrayOfFaceInfo != null && arrayOfFaceInfo.length > 0) ? this.mFaceTracker.get_TrackedFaceInfo()[0] : null;
  }
  
  public FaceInfo[] getTrackedFaces() {
    return this.mFaceTracker.get_TrackedFaceInfo();
  }
  
  public void setBlurrinessThreshold(float paramFloat) {
    this.mFaceTracker.set_blur_thr(paramFloat);
  }
  
  public void setCheckQuality(boolean paramBoolean) {
    this.mFaceTracker.set_isCheckQuality(paramBoolean);
  }
  
  public void setDetectInterval(int paramInt) {
    this.mFaceTracker.set_detection_frame_interval(paramInt);
  }
  
  public void setEulerAngleThreshold(int paramInt1, int paramInt2, int paramInt3) {
    this.mFaceTracker.set_eulur_angle_thr(paramInt1, paramInt2, paramInt3);
  }
  
  public void setIlluminationThreshold(float paramFloat) {
    this.mFaceTracker.set_illum_thr(paramFloat);
  }
  
  public void setMinFaceSize(int paramInt) {
    this.mFaceTracker.set_min_face_size(paramInt);
  }
  
  public void setNotFaceThreshold(float paramFloat) {
    this.mFaceTracker.set_notFace_thr(paramFloat);
  }
  
  public void setNumberOfThreads(int paramInt) {
    FaceSDK.setNumberOfThreads(paramInt);
  }
  
  public void setOcclulationThreshold(float paramFloat) {
    this.mFaceTracker.set_occlu_thr(paramFloat);
  }
  
  public void setTrackInterval(int paramInt) {
    this.mFaceTracker.set_intervalTime(paramInt);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\baidu\aip\FaceDetector.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */