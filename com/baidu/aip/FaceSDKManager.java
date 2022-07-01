package com.baidu.aip;

import android.content.Context;
import com.baidu.idl.facesdk.FaceRecognize;
import com.baidu.idl.facesdk.FaceSDK;
import com.baidu.idl.facesdk.FaceTracker;

public class FaceSDKManager {
  private FaceRecognize faceRecognize;
  
  private FaceTracker faceTracker;
  
  private FaceSDKManager() {}
  
  public static FaceSDKManager getInstance() {
    return HolderClass.instance;
  }
  
  public FaceRecognize getFaceRecognize(Context paramContext) {
    if (this.faceRecognize == null)
      this.faceRecognize = new FaceRecognize(paramContext); 
    return this.faceRecognize;
  }
  
  public FaceTracker getFaceTracker(Context paramContext) {
    FaceTracker faceTracker = this.faceTracker;
    if (faceTracker == null) {
      this.faceTracker = new FaceTracker(paramContext);
      this.faceTracker.set_isFineAlign(false);
      this.faceTracker.set_isFineAlign(false);
      this.faceTracker.set_isVerifyLive(true);
      this.faceTracker.set_DetectMethodType(1);
      this.faceTracker.set_isCheckQuality(true);
      this.faceTracker.set_notFace_thr(0.6F);
      this.faceTracker.set_min_face_size(200);
      this.faceTracker.set_cropFaceSize(400);
      this.faceTracker.set_illum_thr(40.0F);
      this.faceTracker.set_blur_thr(0.7F);
      this.faceTracker.set_occlu_thr(0.5F);
      this.faceTracker.set_max_reg_img_num(1);
      this.faceTracker.set_eulur_angle_thr(10, 10, 10);
      this.faceTracker.set_track_by_detection_interval(800);
      return this.faceTracker;
    } 
    return faceTracker;
  }
  
  public void init(Context paramContext, String paramString1, String paramString2) {
    FaceSDK.initLicense(paramContext, paramString1, paramString2, true);
    FaceSDK.initModel(paramContext);
    getFaceTracker(paramContext);
    getFaceRecognize(paramContext);
  }
  
  static class HolderClass {
    private static final FaceSDKManager instance = new FaceSDKManager();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\baidu\aip\FaceSDKManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */