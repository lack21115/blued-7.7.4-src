package com.qiniu.pili.droid.shortvideo;

import android.media.audiofx.AcousticEchoCanceler;
import android.media.audiofx.NoiseSuppressor;
import com.qiniu.pili.droid.shortvideo.f.e;
import org.json.JSONException;
import org.json.JSONObject;

public class PLMicrophoneSetting {
  private static final String AUDIO_FORMAT = "audioFormat";
  
  private static final String AUDIO_PTS_OPTIMIZE_ENABLE = "audioPtsOptimizeEnabled";
  
  private static final String AUDIO_SOURCE = "audioSource";
  
  private static final String BLUETOOTH_SCO_ENABLED = "bluetoothSCOEnabled";
  
  private static final String CHANNEL_CONFIG = "channelConfig";
  
  private static final String SAMPLE_RATE = "sampleRate";
  
  public static final String TAG = "PLMicrophoneSetting";
  
  private int mAudioFormat = 2;
  
  private boolean mAudioPtsOptimizeEnable = true;
  
  private int mAudioSource = 1;
  
  private boolean mBluetoothSCOEnabled = false;
  
  private int mChannelConfig = 16;
  
  private boolean mIsAECEnabled = false;
  
  private boolean mIsNSEnabled = false;
  
  private int mSampleRate = 44100;
  
  public static PLMicrophoneSetting fromJSON(JSONObject paramJSONObject) {
    PLMicrophoneSetting pLMicrophoneSetting = new PLMicrophoneSetting();
    pLMicrophoneSetting.setAudioSource(paramJSONObject.optInt("audioSource", 1));
    pLMicrophoneSetting.setSampleRate(paramJSONObject.optInt("sampleRate", 44100));
    pLMicrophoneSetting.setChannelConfig(paramJSONObject.optInt("channelConfig", 16));
    pLMicrophoneSetting.setAudioFormat(paramJSONObject.optInt("audioFormat", 2));
    pLMicrophoneSetting.setBluetoothSCOEnabled(paramJSONObject.optBoolean("bluetoothSCOEnabled", false));
    pLMicrophoneSetting.setPtsOptimizeEnabled(paramJSONObject.optBoolean("audioPtsOptimizeEnabled", true));
    return pLMicrophoneSetting;
  }
  
  public int getAudioFormat() {
    return this.mAudioFormat;
  }
  
  public int getAudioSource() {
    return this.mAudioSource;
  }
  
  public int getChannelConfig() {
    return this.mChannelConfig;
  }
  
  public int getSampleRate() {
    return this.mSampleRate;
  }
  
  public boolean isAECEnabled() {
    return this.mIsAECEnabled;
  }
  
  public boolean isAudioPtsOptimizeEnabled() {
    return this.mAudioPtsOptimizeEnable;
  }
  
  public boolean isBluetoothSCOEnabled() {
    return this.mBluetoothSCOEnabled;
  }
  
  public boolean isNSEnabled() {
    return this.mIsNSEnabled;
  }
  
  public boolean setAECEnabled(boolean paramBoolean) {
    if (AcousticEchoCanceler.isAvailable()) {
      this.mIsAECEnabled = paramBoolean;
      e e = e.f;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("setAECEnabled ");
      stringBuilder.append(paramBoolean);
      e.c("PLMicrophoneSetting", stringBuilder.toString());
      return true;
    } 
    e.f.e("PLMicrophoneSetting", "failed to setAECEnabled, AcousticEchoCanceler not available !");
    return false;
  }
  
  public PLMicrophoneSetting setAudioFormat(int paramInt) {
    this.mAudioFormat = paramInt;
    return this;
  }
  
  public PLMicrophoneSetting setAudioSource(int paramInt) {
    this.mAudioSource = paramInt;
    return this;
  }
  
  public PLMicrophoneSetting setBluetoothSCOEnabled(boolean paramBoolean) {
    this.mBluetoothSCOEnabled = paramBoolean;
    return this;
  }
  
  public PLMicrophoneSetting setChannelConfig(int paramInt) {
    this.mChannelConfig = paramInt;
    return this;
  }
  
  public boolean setNSEnabled(boolean paramBoolean) {
    if (NoiseSuppressor.isAvailable()) {
      this.mIsNSEnabled = paramBoolean;
      e e = e.f;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("setNSEnabled ");
      stringBuilder.append(paramBoolean);
      e.c("PLMicrophoneSetting", stringBuilder.toString());
      return true;
    } 
    e.f.e("PLMicrophoneSetting", "failed to setNSEnabled, NoiseSuppressor not available !");
    return false;
  }
  
  public PLMicrophoneSetting setPtsOptimizeEnabled(boolean paramBoolean) {
    this.mAudioPtsOptimizeEnable = paramBoolean;
    return this;
  }
  
  public PLMicrophoneSetting setSampleRate(int paramInt) {
    this.mSampleRate = paramInt;
    return this;
  }
  
  public JSONObject toJSON() {
    JSONObject jSONObject = new JSONObject();
    try {
      jSONObject.put("audioSource", this.mAudioSource);
      jSONObject.put("sampleRate", this.mSampleRate);
      jSONObject.put("channelConfig", this.mChannelConfig);
      jSONObject.put("audioFormat", this.mAudioFormat);
      jSONObject.put("bluetoothSCOEnabled", this.mBluetoothSCOEnabled);
      jSONObject.put("audioPtsOptimizeEnabled", this.mAudioPtsOptimizeEnable);
      return jSONObject;
    } catch (JSONException jSONException) {
      return null;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\qiniu\pili\droid\shortvideo\PLMicrophoneSetting.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */