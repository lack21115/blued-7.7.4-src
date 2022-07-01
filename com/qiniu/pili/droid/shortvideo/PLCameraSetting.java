package com.qiniu.pili.droid.shortvideo;

import com.qiniu.pili.droid.shortvideo.a.a.a;
import org.json.JSONException;
import org.json.JSONObject;

public class PLCameraSetting {
  private static final String CAM_FACING_ID = "cameraFacingId";
  
  private static final String CAM_PREVIEW_SIZE_LEVEL = "cameraPreviewSizeLevel";
  
  private static final String CAM_PREVIEW_SIZE_RATIO = "cameraPreviewSizeRatio";
  
  private static final int[] PREVIEW_SIZE_LEVEL_ARRAY = new int[] { 120, 240, 360, 480, 720, 960, 1080, 1200 };
  
  public static final String TAG = "PLCameraSetting";
  
  private CAMERA_FACING_ID mCameraFacingId = CAMERA_FACING_ID.CAMERA_FACING_BACK;
  
  private CAMERA_PREVIEW_SIZE_LEVEL mPreviewSizeLevel = CAMERA_PREVIEW_SIZE_LEVEL.PREVIEW_SIZE_LEVEL_480P;
  
  private CAMERA_PREVIEW_SIZE_RATIO mPreviewSizeRatio = CAMERA_PREVIEW_SIZE_RATIO.RATIO_16_9;
  
  public static int calcCameraPreviewSizeLevel(CAMERA_PREVIEW_SIZE_LEVEL paramCAMERA_PREVIEW_SIZE_LEVEL) {
    return PREVIEW_SIZE_LEVEL_ARRAY[paramCAMERA_PREVIEW_SIZE_LEVEL.ordinal()];
  }
  
  public static double calcCameraPreviewSizeRatio(CAMERA_PREVIEW_SIZE_RATIO paramCAMERA_PREVIEW_SIZE_RATIO) {
    int i = null.a[paramCAMERA_PREVIEW_SIZE_RATIO.ordinal()];
    if (i != 1) {
      if (i == 2)
        return 1.7777777777777777D; 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("cannot support ratio:");
      stringBuilder.append(paramCAMERA_PREVIEW_SIZE_RATIO);
      throw new IllegalArgumentException(stringBuilder.toString());
    } 
    return 1.3333333333333333D;
  }
  
  public static PLCameraSetting fromJSON(JSONObject paramJSONObject) {
    PLCameraSetting pLCameraSetting = new PLCameraSetting();
    pLCameraSetting.setCameraId(CAMERA_FACING_ID.valueOf(paramJSONObject.optString("cameraFacingId", CAMERA_FACING_ID.CAMERA_FACING_BACK.name())));
    pLCameraSetting.setCameraPreviewSizeRatio(CAMERA_PREVIEW_SIZE_RATIO.valueOf(paramJSONObject.optString("cameraPreviewSizeRatio", CAMERA_PREVIEW_SIZE_RATIO.RATIO_16_9.name())));
    pLCameraSetting.setCameraPreviewSizeLevel(CAMERA_PREVIEW_SIZE_LEVEL.valueOf(paramJSONObject.optString("cameraPreviewSizeLevel", CAMERA_PREVIEW_SIZE_LEVEL.PREVIEW_SIZE_LEVEL_480P.name())));
    return pLCameraSetting;
  }
  
  public static boolean hasCameraFacing(CAMERA_FACING_ID paramCAMERA_FACING_ID) {
    return a.e(paramCAMERA_FACING_ID.ordinal());
  }
  
  public CAMERA_FACING_ID getCameraId() {
    return this.mCameraFacingId;
  }
  
  public CAMERA_PREVIEW_SIZE_LEVEL getCameraPreviewSizeLevel() {
    return this.mPreviewSizeLevel;
  }
  
  public CAMERA_PREVIEW_SIZE_RATIO getCameraPreviewSizeRatio() {
    return this.mPreviewSizeRatio;
  }
  
  public PLCameraSetting setCameraId(CAMERA_FACING_ID paramCAMERA_FACING_ID) {
    this.mCameraFacingId = paramCAMERA_FACING_ID;
    return this;
  }
  
  public PLCameraSetting setCameraPreviewSizeLevel(CAMERA_PREVIEW_SIZE_LEVEL paramCAMERA_PREVIEW_SIZE_LEVEL) {
    this.mPreviewSizeLevel = paramCAMERA_PREVIEW_SIZE_LEVEL;
    return this;
  }
  
  public PLCameraSetting setCameraPreviewSizeRatio(CAMERA_PREVIEW_SIZE_RATIO paramCAMERA_PREVIEW_SIZE_RATIO) {
    this.mPreviewSizeRatio = paramCAMERA_PREVIEW_SIZE_RATIO;
    return this;
  }
  
  public JSONObject toJSON() {
    JSONObject jSONObject = new JSONObject();
    try {
      jSONObject.put("cameraFacingId", this.mCameraFacingId.name());
      jSONObject.put("cameraPreviewSizeRatio", this.mPreviewSizeRatio.name());
      jSONObject.put("cameraPreviewSizeLevel", this.mPreviewSizeLevel.name());
      return jSONObject;
    } catch (JSONException jSONException) {
      return null;
    } 
  }
  
  public enum CAMERA_FACING_ID {
    CAMERA_FACING_3RD, CAMERA_FACING_BACK, CAMERA_FACING_FRONT;
    
    static {
      $VALUES = new CAMERA_FACING_ID[] { CAMERA_FACING_BACK, CAMERA_FACING_FRONT, CAMERA_FACING_3RD };
    }
  }
  
  public enum CAMERA_PREVIEW_SIZE_LEVEL {
    PREVIEW_SIZE_LEVEL_120P, PREVIEW_SIZE_LEVEL_1080P, PREVIEW_SIZE_LEVEL_1200P, PREVIEW_SIZE_LEVEL_240P, PREVIEW_SIZE_LEVEL_360P, PREVIEW_SIZE_LEVEL_480P, PREVIEW_SIZE_LEVEL_720P, PREVIEW_SIZE_LEVEL_960P;
    
    static {
      $VALUES = new CAMERA_PREVIEW_SIZE_LEVEL[] { PREVIEW_SIZE_LEVEL_120P, PREVIEW_SIZE_LEVEL_240P, PREVIEW_SIZE_LEVEL_360P, PREVIEW_SIZE_LEVEL_480P, PREVIEW_SIZE_LEVEL_720P, PREVIEW_SIZE_LEVEL_960P, PREVIEW_SIZE_LEVEL_1080P, PREVIEW_SIZE_LEVEL_1200P };
    }
  }
  
  public enum CAMERA_PREVIEW_SIZE_RATIO {
    RATIO_4_3, RATIO_16_9;
    
    static {
      $VALUES = new CAMERA_PREVIEW_SIZE_RATIO[] { RATIO_4_3, RATIO_16_9 };
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\qiniu\pili\droid\shortvideo\PLCameraSetting.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */