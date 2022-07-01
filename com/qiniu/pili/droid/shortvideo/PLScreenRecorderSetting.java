package com.qiniu.pili.droid.shortvideo;

import org.json.JSONException;
import org.json.JSONObject;

public class PLScreenRecorderSetting {
  private int mDpi;
  
  private int mEncodingBitrateInBps = 4096000;
  
  private int mHeight;
  
  private boolean mInputAudioEnabled = false;
  
  private String mRecordFile;
  
  private int mWidth;
  
  public int getDpi() {
    return this.mDpi;
  }
  
  public int getEncodingBitrate() {
    return this.mEncodingBitrateInBps;
  }
  
  public int getHeight() {
    return this.mHeight;
  }
  
  public String getRecordFile() {
    return this.mRecordFile;
  }
  
  public int getWidth() {
    return this.mWidth;
  }
  
  public boolean isInputAudioEnabled() {
    return this.mInputAudioEnabled;
  }
  
  public PLScreenRecorderSetting setDpi(int paramInt) {
    this.mDpi = paramInt;
    return this;
  }
  
  public PLScreenRecorderSetting setEncodingBitrate(int paramInt) {
    this.mEncodingBitrateInBps = paramInt;
    return this;
  }
  
  public PLScreenRecorderSetting setInputAudioEnabled(boolean paramBoolean) {
    this.mInputAudioEnabled = paramBoolean;
    return this;
  }
  
  public PLScreenRecorderSetting setRecordFile(String paramString) {
    this.mRecordFile = paramString;
    return this;
  }
  
  public PLScreenRecorderSetting setSize(int paramInt1, int paramInt2) {
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
      jSONObject.put("recoredFile", this.mRecordFile);
      jSONObject.put("inputAudio", this.mInputAudioEnabled);
      jSONObject.put("bitrate", this.mEncodingBitrateInBps);
      return jSONObject.toString();
    } catch (JSONException jSONException) {
      jSONException.printStackTrace();
      return jSONException.toString();
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\qiniu\pili\droid\shortvideo\PLScreenRecorderSetting.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */