package com.qiniu.pili.droid.streaming;

import org.json.JSONException;
import org.json.JSONObject;

public class ScreenSetting {
  public int mDpi;
  
  public int mHeight;
  
  public int mWidth;
  
  public int getDpi() {
    return this.mDpi;
  }
  
  public int getHeight() {
    return this.mHeight;
  }
  
  public int getWidth() {
    return this.mWidth;
  }
  
  public ScreenSetting setDpi(int paramInt) {
    this.mDpi = paramInt;
    return this;
  }
  
  public ScreenSetting setSize(int paramInt1, int paramInt2) {
    this.mWidth = paramInt1;
    this.mHeight = paramInt2;
    return this;
  }
  
  public String toString() {
    JSONObject jSONObject = new JSONObject();
    try {
      jSONObject.put("Width", this.mWidth);
      jSONObject.put("Height", this.mHeight);
      jSONObject.put("Dpi", this.mDpi);
      return jSONObject.toString();
    } catch (JSONException jSONException) {
      jSONException.printStackTrace();
      return jSONException.toString();
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qiniu\pili\droid\streaming\ScreenSetting.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */