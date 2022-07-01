package com.qiniu.pili.droid.shortvideo;

import org.json.JSONException;
import org.json.JSONObject;

public class PLFaceBeautySetting {
  private static final String BEAUTY_LEVEL = "beautyLevel";
  
  private static final String ENABLED = "enabled";
  
  private static final String REDDEN = "redden";
  
  public static final String TAG = "PLFaceBeautySetting";
  
  private static final String WHITEN = "whiten";
  
  private float mBeautyLevel;
  
  private boolean mEnabled = true;
  
  private float mRedden;
  
  private float mWhiten;
  
  public PLFaceBeautySetting(float paramFloat1, float paramFloat2, float paramFloat3) {
    this.mBeautyLevel = paramFloat1;
    this.mRedden = paramFloat3;
    this.mWhiten = paramFloat2;
  }
  
  public static PLFaceBeautySetting fromJSON(JSONObject paramJSONObject) {
    PLFaceBeautySetting pLFaceBeautySetting = new PLFaceBeautySetting((float)paramJSONObject.optDouble("beautyLevel"), (float)paramJSONObject.optDouble("whiten"), (float)paramJSONObject.optDouble("redden"));
    pLFaceBeautySetting.setEnable(paramJSONObject.optBoolean("enabled", true));
    return pLFaceBeautySetting;
  }
  
  public float getBeautyLevel() {
    return this.mBeautyLevel;
  }
  
  public float getRedden() {
    return this.mRedden;
  }
  
  public float getWhiten() {
    return this.mWhiten;
  }
  
  public boolean isEnabled() {
    return this.mEnabled;
  }
  
  public void setBeautyLevel(float paramFloat) {
    this.mBeautyLevel = paramFloat;
  }
  
  public void setEnable(boolean paramBoolean) {
    this.mEnabled = paramBoolean;
  }
  
  public void setRedden(float paramFloat) {
    this.mRedden = paramFloat;
  }
  
  public void setWhiten(float paramFloat) {
    this.mWhiten = paramFloat;
  }
  
  public JSONObject toJSON() {
    JSONObject jSONObject = new JSONObject();
    try {
      jSONObject.put("enabled", this.mEnabled);
      jSONObject.put("beautyLevel", this.mBeautyLevel);
      jSONObject.put("whiten", this.mWhiten);
      jSONObject.put("redden", this.mRedden);
      return jSONObject;
    } catch (JSONException jSONException) {
      return null;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\qiniu\pili\droid\shortvideo\PLFaceBeautySetting.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */