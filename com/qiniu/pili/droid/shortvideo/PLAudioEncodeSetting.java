package com.qiniu.pili.droid.shortvideo;

import com.qiniu.pili.droid.shortvideo.f.e;
import org.json.JSONException;
import org.json.JSONObject;

public class PLAudioEncodeSetting {
  private static final String BITRATE = "bitrate";
  
  private static final String CHANNELS = "channels";
  
  private static final String IS_HW_CODEC_ENABLED = "isHWCodecEnabled";
  
  private static final String SAMPLE_RATE = "sampleRate";
  
  public static final String TAG = "PLAudioEncodeSetting";
  
  private int mBitrate = 44100;
  
  private int mChannels = 1;
  
  private boolean mIsHWCodecEnabled = true;
  
  private int mSamplerate = 44100;
  
  public static PLAudioEncodeSetting fromJSON(JSONObject paramJSONObject) {
    PLAudioEncodeSetting pLAudioEncodeSetting = new PLAudioEncodeSetting();
    pLAudioEncodeSetting.setSampleRate(paramJSONObject.optInt("sampleRate", 44100));
    pLAudioEncodeSetting.setChannels(paramJSONObject.optInt("channels", 1));
    pLAudioEncodeSetting.setBitrate(paramJSONObject.optInt("bitrate", 44100));
    pLAudioEncodeSetting.setHWCodecEnabled(paramJSONObject.optBoolean("isHWCodecEnabled", true));
    return pLAudioEncodeSetting;
  }
  
  public int getBitrate() {
    return this.mBitrate;
  }
  
  public int getChannels() {
    return this.mChannels;
  }
  
  public int getSamplerate() {
    return this.mSamplerate;
  }
  
  public boolean isHWCodecEnabled() {
    return this.mIsHWCodecEnabled;
  }
  
  public PLAudioEncodeSetting setBitrate(int paramInt) {
    e e = e.h;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("setBitrate: ");
    stringBuilder.append(paramInt);
    e.c("PLAudioEncodeSetting", stringBuilder.toString());
    this.mBitrate = paramInt;
    return this;
  }
  
  public PLAudioEncodeSetting setChannels(int paramInt) {
    e e = e.h;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("setChannels: ");
    stringBuilder.append(paramInt);
    e.c("PLAudioEncodeSetting", stringBuilder.toString());
    this.mChannels = paramInt;
    return this;
  }
  
  public PLAudioEncodeSetting setHWCodecEnabled(boolean paramBoolean) {
    e e = e.h;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("setIFrameInterval: ");
    stringBuilder.append(paramBoolean);
    e.c("PLAudioEncodeSetting", stringBuilder.toString());
    this.mIsHWCodecEnabled = paramBoolean;
    return this;
  }
  
  public PLAudioEncodeSetting setSampleRate(int paramInt) {
    e e = e.h;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("setSampleRate: ");
    stringBuilder.append(paramInt);
    e.c("PLAudioEncodeSetting", stringBuilder.toString());
    this.mSamplerate = paramInt;
    return this;
  }
  
  public JSONObject toJSON() {
    JSONObject jSONObject = new JSONObject();
    try {
      jSONObject.put("sampleRate", this.mSamplerate);
      jSONObject.put("channels", this.mChannels);
      jSONObject.put("bitrate", this.mBitrate);
      jSONObject.put("isHWCodecEnabled", this.mIsHWCodecEnabled);
      return jSONObject;
    } catch (JSONException jSONException) {
      return null;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\qiniu\pili\droid\shortvideo\PLAudioEncodeSetting.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */