package com.qiniu.pili.droid.streaming;

import a.a.a.a.a.b.b;
import a.a.a.a.a.e.e;
import org.json.JSONException;
import org.json.JSONObject;

public class CameraStreamingSetting {
  public static final String FOCUS_MODE_AUTO = "auto";
  
  public static final String FOCUS_MODE_CONTINUOUS_PICTURE = "continuous-picture";
  
  public static final String FOCUS_MODE_CONTINUOUS_VIDEO = "continuous-video";
  
  public FaceBeautySetting a = new FaceBeautySetting(1.0F, 0.5F, 0.5F);
  
  public int b;
  
  public int c;
  
  public boolean d;
  
  public int e = -1;
  
  public int f = -1;
  
  public boolean g;
  
  public PREVIEW_SIZE_LEVEL h;
  
  public PREVIEW_SIZE_RATIO i;
  
  public boolean j;
  
  public CAMERA_FACING_ID k = CAMERA_FACING_ID.CAMERA_FACING_BACK;
  
  public boolean l = false;
  
  public boolean m = false;
  
  public String n = "continuous-video";
  
  public int o = 3000;
  
  public boolean p;
  
  public boolean q;
  
  public VIDEO_FILTER_TYPE r = VIDEO_FILTER_TYPE.VIDEO_FILTER_NONE;
  
  public boolean s = false;
  
  public boolean t = false;
  
  public int u;
  
  public int v = -1;
  
  public boolean w = true;
  
  public static int getNumberOfCameras() {
    return b.a().d();
  }
  
  public static boolean hasCameraFacing(CAMERA_FACING_ID paramCAMERA_FACING_ID) {
    b.a();
    return b.a(paramCAMERA_FACING_ID.ordinal());
  }
  
  public CameraStreamingSetting a(int paramInt1, int paramInt2) {
    if (paramInt1 > 0 && paramInt2 > 0) {
      this.b = paramInt1;
      this.c = paramInt2;
      return this;
    } 
    throw new RuntimeException("Illegal width or height!!!");
  }
  
  public CameraStreamingSetting a(boolean paramBoolean) {
    this.d = paramBoolean;
    return this;
  }
  
  public void a(int paramInt) {
    this.u = paramInt;
  }
  
  public void a(PREVIEW_SIZE_RATIO paramPREVIEW_SIZE_RATIO) {
    this.i = paramPREVIEW_SIZE_RATIO;
  }
  
  public boolean a() {
    return this.m;
  }
  
  public int b() {
    return this.c;
  }
  
  public CameraStreamingSetting b(int paramInt1, int paramInt2) {
    if (paramInt1 > 0 && paramInt2 > 0) {
      this.e = paramInt1;
      this.f = paramInt2;
      return this;
    } 
    throw new RuntimeException("Illegal width or height!!!");
  }
  
  public void b(int paramInt) {
    this.v = paramInt;
  }
  
  public int c() {
    return this.b;
  }
  
  public boolean d() {
    return this.d;
  }
  
  public boolean e() {
    return this.s;
  }
  
  public boolean f() {
    return this.t;
  }
  
  public boolean g() {
    return this.l;
  }
  
  public int getCameraDisplayOrientation() {
    return this.u;
  }
  
  public CAMERA_FACING_ID getCameraFacingId() {
    return this.k;
  }
  
  public int getCameraPreviewHeight() {
    return this.f;
  }
  
  public int getCameraPreviewWidth() {
    return this.e;
  }
  
  public FaceBeautySetting getFaceBeautySetting() {
    return this.a;
  }
  
  public String getFocusMode() {
    return this.n;
  }
  
  public PREVIEW_SIZE_LEVEL getPrvSizeLevel() {
    return this.h;
  }
  
  public PREVIEW_SIZE_RATIO getPrvSizeRatio() {
    return this.i;
  }
  
  public int getReqCameraId() {
    return this.k.ordinal();
  }
  
  public int getResetTouchFocusDelay() {
    return this.o;
  }
  
  public int getStreamingPreviewCallbackFormat() {
    return this.v;
  }
  
  public VIDEO_FILTER_TYPE getVideoFilterType() {
    return this.r;
  }
  
  public boolean isCAFEnabled() {
    return this.g;
  }
  
  public boolean isFrontCameraMirror() {
    return this.p;
  }
  
  public boolean isFrontCameraPreviewMirror() {
    return this.q;
  }
  
  public boolean isPreviewAdaptToEncodingSize() {
    return this.w;
  }
  
  public boolean isPreviewSizeOptimize() {
    return this.j;
  }
  
  public CameraStreamingSetting setBuiltInFaceBeautyEnabled(boolean paramBoolean) {
    boolean bool = true;
    if (paramBoolean && SharedLibraryNameHelper.d(true)) {
      paramBoolean = bool;
    } else {
      paramBoolean = false;
    } 
    this.s = paramBoolean;
    return this;
  }
  
  public CameraStreamingSetting setCameraFacingId(CAMERA_FACING_ID paramCAMERA_FACING_ID) {
    this.k = paramCAMERA_FACING_ID;
    return this;
  }
  
  public CameraStreamingSetting setCameraId(int paramInt) {
    if (paramInt == 0) {
      this.k = CAMERA_FACING_ID.CAMERA_FACING_BACK;
      return this;
    } 
    if (paramInt == 1) {
      this.k = CAMERA_FACING_ID.CAMERA_FACING_FRONT;
      return this;
    } 
    this.k = CAMERA_FACING_ID.CAMERA_FACING_3RD;
    return this;
  }
  
  public CameraStreamingSetting setCameraPrvSizeLevel(PREVIEW_SIZE_LEVEL paramPREVIEW_SIZE_LEVEL) {
    this.h = paramPREVIEW_SIZE_LEVEL;
    return this;
  }
  
  public CameraStreamingSetting setCameraPrvSizeRatio(PREVIEW_SIZE_RATIO paramPREVIEW_SIZE_RATIO) {
    this.i = paramPREVIEW_SIZE_RATIO;
    if (paramPREVIEW_SIZE_RATIO != null)
      this.l = true; 
    return this;
  }
  
  public CameraStreamingSetting setCaptureCameraFrameOnly(boolean paramBoolean) {
    this.t = paramBoolean;
    return this;
  }
  
  public CameraStreamingSetting setContinuousFocusModeEnabled(boolean paramBoolean) {
    this.g = paramBoolean;
    return this;
  }
  
  public CameraStreamingSetting setFaceBeautySetting(FaceBeautySetting paramFaceBeautySetting) {
    this.a = paramFaceBeautySetting;
    return this;
  }
  
  public CameraStreamingSetting setFocusMode(String paramString) {
    this.n = paramString;
    if ("continuous-picture".equals(paramString) || "continuous-video".equals(paramString)) {
      boolean bool1 = true;
      this.g = bool1;
      e e1 = e.c;
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append("ContinuousFocusModeEnabled had been forced to:");
      stringBuilder1.append(this.g);
      e1.d("CameraStreamingSetting", stringBuilder1.toString());
      return this;
    } 
    boolean bool = false;
    this.g = bool;
    e e = e.c;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("ContinuousFocusModeEnabled had been forced to:");
    stringBuilder.append(this.g);
    e.d("CameraStreamingSetting", stringBuilder.toString());
    return this;
  }
  
  public CameraStreamingSetting setFrontCameraMirror(boolean paramBoolean) {
    this.p = paramBoolean;
    return this;
  }
  
  public CameraStreamingSetting setFrontCameraPreviewMirror(boolean paramBoolean) {
    this.q = paramBoolean;
    return this;
  }
  
  public CameraStreamingSetting setPreviewAdaptToEncodingSize(boolean paramBoolean) {
    this.w = paramBoolean;
    return this;
  }
  
  public CameraStreamingSetting setPreviewSizeOptimize(boolean paramBoolean) {
    this.j = paramBoolean;
    return this;
  }
  
  public CameraStreamingSetting setRecordingHint(boolean paramBoolean) {
    this.m = paramBoolean;
    return this;
  }
  
  public CameraStreamingSetting setResetTouchFocusDelayInMs(int paramInt) {
    this.o = paramInt;
    return this;
  }
  
  public CameraStreamingSetting setVideoFilter(VIDEO_FILTER_TYPE paramVIDEO_FILTER_TYPE) {
    if (paramVIDEO_FILTER_TYPE != null) {
      this.r = paramVIDEO_FILTER_TYPE;
      return this;
    } 
    this.r = VIDEO_FILTER_TYPE.VIDEO_FILTER_NONE;
    return this;
  }
  
  public String toString() {
    JSONObject jSONObject = new JSONObject();
    try {
      jSONObject.put("PrvSizeLevel", this.h);
      jSONObject.put("PrvSizeRatio", this.i);
      jSONObject.put("BuiltInFBEnabled", this.s);
      jSONObject.put("FBSetting", this.a.toString());
      jSONObject.put("VideoFilterType", this.r);
      jSONObject.put("CameraFacingId", this.k);
      jSONObject.put("ContinuousFocusMode", this.g);
      jSONObject.put("PreviewSizeOptimize", this.j);
      jSONObject.put("RecordingHint", this.m);
      jSONObject.put("FocusMode", this.n);
      jSONObject.put("EncodingMirror", this.p);
      jSONObject.put("PreviewMirror", this.q);
      return jSONObject.toString();
    } catch (JSONException jSONException) {
      jSONException.printStackTrace();
      return jSONException.toString();
    } 
  }
  
  public enum CAMERA_FACING_ID {
    CAMERA_FACING_3RD, CAMERA_FACING_BACK, CAMERA_FACING_FRONT;
    
    static {
      CAMERA_FACING_ID cAMERA_FACING_ID = new CAMERA_FACING_ID("CAMERA_FACING_3RD", 2);
      CAMERA_FACING_3RD = cAMERA_FACING_ID;
      $VALUES = new CAMERA_FACING_ID[] { CAMERA_FACING_BACK, CAMERA_FACING_FRONT, cAMERA_FACING_ID };
    }
  }
  
  public static final class FaceBeautySetting {
    public float beautyLevel;
    
    public float redden;
    
    public float whiten;
    
    public FaceBeautySetting(float param1Float1, float param1Float2, float param1Float3) {
      this.beautyLevel = param1Float1;
      this.redden = param1Float3;
      this.whiten = param1Float2;
    }
    
    public String toString() {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("[");
      stringBuilder.append(this.beautyLevel);
      stringBuilder.append(",");
      stringBuilder.append(this.whiten);
      stringBuilder.append(",");
      stringBuilder.append(this.redden);
      stringBuilder.append("]");
      return stringBuilder.toString();
    }
  }
  
  public enum PREVIEW_SIZE_LEVEL {
    SMALL, LARGE, MEDIUM;
    
    static {
      PREVIEW_SIZE_LEVEL pREVIEW_SIZE_LEVEL = new PREVIEW_SIZE_LEVEL("LARGE", 2);
      LARGE = pREVIEW_SIZE_LEVEL;
      $VALUES = new PREVIEW_SIZE_LEVEL[] { SMALL, MEDIUM, pREVIEW_SIZE_LEVEL };
    }
  }
  
  public enum PREVIEW_SIZE_RATIO {
    RATIO_16_9, RATIO_4_3;
    
    static {
      PREVIEW_SIZE_RATIO pREVIEW_SIZE_RATIO = new PREVIEW_SIZE_RATIO("RATIO_16_9", 1);
      RATIO_16_9 = pREVIEW_SIZE_RATIO;
      $VALUES = new PREVIEW_SIZE_RATIO[] { RATIO_4_3, pREVIEW_SIZE_RATIO };
    }
  }
  
  public enum VIDEO_FILTER_TYPE {
    VIDEO_FILTER_BEAUTY, VIDEO_FILTER_NONE;
    
    static {
      VIDEO_FILTER_TYPE vIDEO_FILTER_TYPE = new VIDEO_FILTER_TYPE("VIDEO_FILTER_BEAUTY", 1);
      VIDEO_FILTER_BEAUTY = vIDEO_FILTER_TYPE;
      $VALUES = new VIDEO_FILTER_TYPE[] { VIDEO_FILTER_NONE, vIDEO_FILTER_TYPE };
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qiniu\pili\droid\streaming\CameraStreamingSetting.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */