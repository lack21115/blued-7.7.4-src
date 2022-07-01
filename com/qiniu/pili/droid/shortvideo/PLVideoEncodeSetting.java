package com.qiniu.pili.droid.shortvideo;

import android.content.Context;
import com.qiniu.pili.droid.shortvideo.f.e;
import com.qiniu.pili.droid.shortvideo.f.g;
import com.qiniu.pili.droid.shortvideo.f.j;
import org.json.JSONException;
import org.json.JSONObject;

public class PLVideoEncodeSetting {
  private static final String BITRATE_MODE = "bitrateMode";
  
  private static final String ENCODING_BITRATE = "encodingBitrate";
  
  private static final String ENCODING_FPS = "encodingFps";
  
  private static final String ENCODING_SIZE_LEVEL = "encodingSizeLevel";
  
  private static final String IS_HW_CODEC_ENABLED = "isHWCodecEnabled";
  
  private static final String I_FRAME_INTERVAL = "iFrameInterval";
  
  private static final String PREFERRED_ENCODING_HEIGHT = "preferredEncodingHeight";
  
  private static final String PREFERRED_ENCODING_WIDTH = "preferredEncodingWidth";
  
  public static final String TAG = "PLVideoEncodeSetting";
  
  private static final int[][] VIDEO_ENCODING_SIZE_ARRAY;
  
  private BitrateMode mBitrateMode = BitrateMode.QUALITY_PRIORITY;
  
  private Context mContext;
  
  private int mEncodingBitrateInBps = 1000000;
  
  private int mEncodingFps = 30;
  
  private VIDEO_ENCODING_SIZE_LEVEL mEncodingSizeLevel = VIDEO_ENCODING_SIZE_LEVEL.VIDEO_ENCODING_SIZE_LEVEL_480P_1;
  
  private int mIFrameInterval = 30;
  
  private boolean mIsConstFrameRateEnabled = false;
  
  private boolean mIsHWCodecEnabled = true;
  
  private int mPreferredEncodingHeight = 0;
  
  private int mPreferredEncodingWidth = 0;
  
  private ProfileMode mProfileMode = ProfileMode.BASELINE;
  
  private int mRotationInMetadata;
  
  static {
    int[] arrayOfInt1 = { 240, 240 };
    int[] arrayOfInt2 = { 848, 480 };
    int[] arrayOfInt3 = { 544, 544 };
    VIDEO_ENCODING_SIZE_ARRAY = new int[][] { 
        arrayOfInt1, { 320, 240 }, { 352, 352 }, { 640, 352 }, { 360, 360 }, { 480, 360 }, { 640, 360 }, { 480, 480 }, { 640, 480 }, arrayOfInt2, 
        arrayOfInt3, { 720, 544 }, { 720, 720 }, { 960, 720 }, { 1280, 720 }, { 1088, 1088 }, { 1440, 1088 } };
  }
  
  public PLVideoEncodeSetting(Context paramContext) {
    this.mContext = paramContext;
  }
  
  public static PLVideoEncodeSetting fromJSON(Context paramContext, JSONObject paramJSONObject) {
    PLVideoEncodeSetting pLVideoEncodeSetting = new PLVideoEncodeSetting(paramContext);
    pLVideoEncodeSetting.setPreferredEncodingSize(paramJSONObject.optInt("preferredEncodingWidth", 0), paramJSONObject.optInt("preferredEncodingHeight", 0));
    pLVideoEncodeSetting.setEncodingFps(paramJSONObject.optInt("encodingFps", 30));
    pLVideoEncodeSetting.setEncodingBitrate(paramJSONObject.optInt("encodingBitrate", 1000000));
    pLVideoEncodeSetting.setIFrameInterval(paramJSONObject.optInt("iFrameInterval", 30));
    pLVideoEncodeSetting.setEncodingBitrateMode(BitrateMode.valueOf(paramJSONObject.optString("bitrateMode", BitrateMode.QUALITY_PRIORITY.name())));
    pLVideoEncodeSetting.setEncodingSizeLevel(VIDEO_ENCODING_SIZE_LEVEL.valueOf(paramJSONObject.optString("encodingSizeLevel", VIDEO_ENCODING_SIZE_LEVEL.VIDEO_ENCODING_SIZE_LEVEL_480P_1.name())));
    pLVideoEncodeSetting.setHWCodecEnabled(paramJSONObject.optBoolean("isHWCodecEnabled", true));
    return pLVideoEncodeSetting;
  }
  
  public static PLVideoEncodeSetting fromSetting(PLVideoEncodeSetting paramPLVideoEncodeSetting) {
    PLVideoEncodeSetting pLVideoEncodeSetting = new PLVideoEncodeSetting(paramPLVideoEncodeSetting.mContext);
    pLVideoEncodeSetting.setPreferredEncodingSize(paramPLVideoEncodeSetting.mPreferredEncodingWidth, paramPLVideoEncodeSetting.mPreferredEncodingHeight);
    pLVideoEncodeSetting.setEncodingFps(paramPLVideoEncodeSetting.mEncodingFps);
    pLVideoEncodeSetting.setEncodingBitrate(paramPLVideoEncodeSetting.mEncodingBitrateInBps);
    pLVideoEncodeSetting.setIFrameInterval(paramPLVideoEncodeSetting.mIFrameInterval);
    pLVideoEncodeSetting.setEncodingBitrateMode(paramPLVideoEncodeSetting.mBitrateMode);
    pLVideoEncodeSetting.setEncodingSizeLevel(paramPLVideoEncodeSetting.mEncodingSizeLevel);
    pLVideoEncodeSetting.setHWCodecEnabled(paramPLVideoEncodeSetting.mIsHWCodecEnabled);
    pLVideoEncodeSetting.setConstFrameRateEnabled(paramPLVideoEncodeSetting.mIsConstFrameRateEnabled);
    pLVideoEncodeSetting.setRotationInMetadata(paramPLVideoEncodeSetting.mRotationInMetadata);
    pLVideoEncodeSetting.setProfileMode(paramPLVideoEncodeSetting.mProfileMode);
    return pLVideoEncodeSetting;
  }
  
  public boolean IsConstFrameRateEnabled() {
    return this.mIsConstFrameRateEnabled;
  }
  
  public BitrateMode getBitrateMode() {
    return this.mBitrateMode;
  }
  
  public int getEncodingBitrate() {
    return this.mEncodingBitrateInBps;
  }
  
  public int getIFrameInterval() {
    return this.mIFrameInterval;
  }
  
  public ProfileMode getProfileMode() {
    return this.mProfileMode;
  }
  
  public int getRotationInMetadata() {
    return this.mRotationInMetadata;
  }
  
  public int getVideoEncodingFps() {
    return this.mEncodingFps;
  }
  
  public int getVideoEncodingHeight() {
    int i = this.mPreferredEncodingHeight;
    return (i != 0) ? i : (((this.mContext.getResources().getConfiguration()).orientation == 1) ? VIDEO_ENCODING_SIZE_ARRAY[this.mEncodingSizeLevel.ordinal()][0] : VIDEO_ENCODING_SIZE_ARRAY[this.mEncodingSizeLevel.ordinal()][1]);
  }
  
  public int getVideoEncodingWidth() {
    int i = this.mPreferredEncodingWidth;
    return (i != 0) ? i : (((this.mContext.getResources().getConfiguration()).orientation == 1) ? VIDEO_ENCODING_SIZE_ARRAY[this.mEncodingSizeLevel.ordinal()][1] : VIDEO_ENCODING_SIZE_ARRAY[this.mEncodingSizeLevel.ordinal()][0]);
  }
  
  public boolean isHWCodecEnabled() {
    return this.mIsHWCodecEnabled;
  }
  
  public PLVideoEncodeSetting setConstFrameRateEnabled(boolean paramBoolean) {
    e e = e.h;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("setConstFrameRateEnabled: ");
    stringBuilder.append(paramBoolean);
    e.c("PLVideoEncodeSetting", stringBuilder.toString());
    this.mIsConstFrameRateEnabled = paramBoolean;
    return this;
  }
  
  public PLVideoEncodeSetting setEncodingBitrate(int paramInt) {
    e e = e.h;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("setEncodingBitrate: ");
    stringBuilder.append(paramInt);
    e.c("PLVideoEncodeSetting", stringBuilder.toString());
    this.mEncodingBitrateInBps = paramInt;
    return this;
  }
  
  public PLVideoEncodeSetting setEncodingBitrateMode(BitrateMode paramBitrateMode) {
    e e = e.h;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("setEncodingBitrateMode: ");
    stringBuilder.append(paramBitrateMode);
    e.c("PLVideoEncodeSetting", stringBuilder.toString());
    this.mBitrateMode = paramBitrateMode;
    return this;
  }
  
  public PLVideoEncodeSetting setEncodingFps(int paramInt) {
    e e = e.h;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("setEncodingFps: ");
    stringBuilder.append(paramInt);
    e.c("PLVideoEncodeSetting", stringBuilder.toString());
    this.mEncodingFps = paramInt;
    return this;
  }
  
  public PLVideoEncodeSetting setEncodingSizeLevel(VIDEO_ENCODING_SIZE_LEVEL paramVIDEO_ENCODING_SIZE_LEVEL) {
    e e = e.h;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("setEncodingSizeLevel: ");
    stringBuilder.append(paramVIDEO_ENCODING_SIZE_LEVEL);
    e.c("PLVideoEncodeSetting", stringBuilder.toString());
    this.mEncodingSizeLevel = paramVIDEO_ENCODING_SIZE_LEVEL;
    return this;
  }
  
  public PLVideoEncodeSetting setHWCodecEnabled(boolean paramBoolean) {
    e e = e.h;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("setHWCodecEnabled: ");
    stringBuilder.append(paramBoolean);
    e.c("PLVideoEncodeSetting", stringBuilder.toString());
    this.mIsHWCodecEnabled = paramBoolean;
    return this;
  }
  
  public PLVideoEncodeSetting setIFrameInterval(int paramInt) {
    e e = e.h;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("setIFrameInterval: ");
    stringBuilder.append(paramInt);
    e.c("PLVideoEncodeSetting", stringBuilder.toString());
    this.mIFrameInterval = paramInt;
    return this;
  }
  
  public PLVideoEncodeSetting setPreferredEncodingSize(int paramInt1, int paramInt2) {
    paramInt1 = g.b(paramInt1);
    paramInt2 = g.b(paramInt2);
    e e = e.h;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("setPreferredEncodingSize: ");
    stringBuilder.append(paramInt1);
    stringBuilder.append("x");
    stringBuilder.append(paramInt2);
    e.c("PLVideoEncodeSetting", stringBuilder.toString());
    this.mPreferredEncodingWidth = paramInt1;
    this.mPreferredEncodingHeight = paramInt2;
    return this;
  }
  
  public PLVideoEncodeSetting setProfileMode(ProfileMode paramProfileMode) {
    e e = e.h;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("setProfileMode: ");
    stringBuilder.append(paramProfileMode);
    e.c("PLVideoEncodeSetting", stringBuilder.toString());
    this.mProfileMode = paramProfileMode;
    return this;
  }
  
  public PLVideoEncodeSetting setRotationInMetadata(int paramInt) {
    e e = e.h;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("setRotationInMetadata: ");
    stringBuilder.append(paramInt);
    e.c("PLVideoEncodeSetting", stringBuilder.toString());
    this.mRotationInMetadata = j.b(paramInt);
    return this;
  }
  
  public JSONObject toJSON() {
    JSONObject jSONObject = new JSONObject();
    try {
      jSONObject.put("preferredEncodingWidth", this.mPreferredEncodingWidth);
      jSONObject.put("preferredEncodingHeight", this.mPreferredEncodingHeight);
      jSONObject.put("encodingFps", this.mEncodingFps);
      jSONObject.put("encodingBitrate", this.mEncodingBitrateInBps);
      jSONObject.put("iFrameInterval", this.mIFrameInterval);
      jSONObject.put("bitrateMode", this.mBitrateMode.name());
      jSONObject.put("encodingSizeLevel", this.mEncodingSizeLevel.name());
      jSONObject.put("isHWCodecEnabled", this.mIsHWCodecEnabled);
      return jSONObject;
    } catch (JSONException jSONException) {
      return null;
    } 
  }
  
  public enum BitrateMode {
    BITRATE_PRIORITY, CONSTANT_QUALITY_PRIORITY, QUALITY_PRIORITY;
    
    static {
      $VALUES = new BitrateMode[] { QUALITY_PRIORITY, BITRATE_PRIORITY, CONSTANT_QUALITY_PRIORITY };
    }
  }
  
  public enum ProfileMode {
    BASELINE, HIGH, MAIN;
    
    static {
      $VALUES = new ProfileMode[] { BASELINE, MAIN, HIGH };
    }
  }
  
  public enum VIDEO_ENCODING_SIZE_LEVEL {
    VIDEO_ENCODING_SIZE_LEVEL_240P_1, VIDEO_ENCODING_SIZE_LEVEL_1088P_1, VIDEO_ENCODING_SIZE_LEVEL_1088P_2, VIDEO_ENCODING_SIZE_LEVEL_240P_2, VIDEO_ENCODING_SIZE_LEVEL_352P_1, VIDEO_ENCODING_SIZE_LEVEL_352P_2, VIDEO_ENCODING_SIZE_LEVEL_360P_1, VIDEO_ENCODING_SIZE_LEVEL_360P_2, VIDEO_ENCODING_SIZE_LEVEL_360P_3, VIDEO_ENCODING_SIZE_LEVEL_480P_1, VIDEO_ENCODING_SIZE_LEVEL_480P_2, VIDEO_ENCODING_SIZE_LEVEL_480P_3, VIDEO_ENCODING_SIZE_LEVEL_544P_1, VIDEO_ENCODING_SIZE_LEVEL_544P_2, VIDEO_ENCODING_SIZE_LEVEL_720P_1, VIDEO_ENCODING_SIZE_LEVEL_720P_2, VIDEO_ENCODING_SIZE_LEVEL_720P_3;
    
    static {
      $VALUES = new VIDEO_ENCODING_SIZE_LEVEL[] { 
          VIDEO_ENCODING_SIZE_LEVEL_240P_1, VIDEO_ENCODING_SIZE_LEVEL_240P_2, VIDEO_ENCODING_SIZE_LEVEL_352P_1, VIDEO_ENCODING_SIZE_LEVEL_352P_2, VIDEO_ENCODING_SIZE_LEVEL_360P_1, VIDEO_ENCODING_SIZE_LEVEL_360P_2, VIDEO_ENCODING_SIZE_LEVEL_360P_3, VIDEO_ENCODING_SIZE_LEVEL_480P_1, VIDEO_ENCODING_SIZE_LEVEL_480P_2, VIDEO_ENCODING_SIZE_LEVEL_480P_3, 
          VIDEO_ENCODING_SIZE_LEVEL_544P_1, VIDEO_ENCODING_SIZE_LEVEL_544P_2, VIDEO_ENCODING_SIZE_LEVEL_720P_1, VIDEO_ENCODING_SIZE_LEVEL_720P_2, VIDEO_ENCODING_SIZE_LEVEL_720P_3, VIDEO_ENCODING_SIZE_LEVEL_1088P_1, VIDEO_ENCODING_SIZE_LEVEL_1088P_2 };
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\qiniu\pili\droid\shortvideo\PLVideoEncodeSetting.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */