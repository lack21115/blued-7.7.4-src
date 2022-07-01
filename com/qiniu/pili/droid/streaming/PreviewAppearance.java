package com.qiniu.pili.droid.streaming;

import org.json.JSONException;
import org.json.JSONObject;

public class PreviewAppearance {
  public float h;
  
  public ScaleType scaleType;
  
  public float w;
  
  public float x;
  
  public float y;
  
  public PreviewAppearance(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, ScaleType paramScaleType) {
    this.x = paramFloat1;
    this.y = paramFloat2;
    this.w = paramFloat3;
    this.h = paramFloat4;
    this.scaleType = paramScaleType;
  }
  
  public PreviewAppearance(ScaleType paramScaleType) {
    this.x = 0.0F;
    this.y = 0.0F;
    this.w = 1.0F;
    this.h = 1.0F;
    this.scaleType = paramScaleType;
  }
  
  public String toString() {
    JSONObject jSONObject = new JSONObject();
    try {
      jSONObject.put("x", this.x);
      jSONObject.put("y", this.y);
      jSONObject.put("w", this.w);
      jSONObject.put("h", this.h);
      jSONObject.put("scaleType", this.scaleType);
      return jSONObject.toString();
    } catch (JSONException jSONException) {
      jSONException.printStackTrace();
      return jSONException.toString();
    } 
  }
  
  public enum ScaleType {
    FIT, FULL;
    
    static {
      ScaleType scaleType = new ScaleType("FIT", 1);
      FIT = scaleType;
      $VALUES = new ScaleType[] { FULL, scaleType };
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qiniu\pili\droid\streaming\PreviewAppearance.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */