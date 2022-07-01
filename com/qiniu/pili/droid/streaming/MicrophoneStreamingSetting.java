package com.qiniu.pili.droid.streaming;

import a.a.a.a.a.e.e;
import android.media.audiofx.AcousticEchoCanceler;
import android.os.Build;
import org.json.JSONException;
import org.json.JSONObject;

public class MicrophoneStreamingSetting {
  public boolean a;
  
  public boolean b = true;
  
  public boolean c;
  
  public int d = 44100;
  
  public int e = 16;
  
  public int f = 4;
  
  public boolean g = false;
  
  public int h = 1;
  
  public boolean a() {
    return this.g;
  }
  
  public boolean b() {
    return this.b;
  }
  
  public boolean c() {
    return this.c;
  }
  
  public int getAudioSource() {
    return this.h;
  }
  
  public int getChannelConfig() {
    return this.e;
  }
  
  public int getChannelConfigOut() {
    return this.f;
  }
  
  public int getReqSampleRate() {
    return this.d;
  }
  
  public boolean isBluetoothSCOEnabled() {
    return this.a;
  }
  
  public boolean setAECEnabled(boolean paramBoolean) {
    if (Build.VERSION.SDK_INT >= 16) {
      if (AcousticEchoCanceler.isAvailable()) {
        this.g = paramBoolean;
        e e = e.g;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("setAECEnabled ");
        stringBuilder.append(paramBoolean);
        e.e("MicrophoneSetting", stringBuilder.toString());
        return true;
      } 
      e.g.e("MicrophoneSetting", "failed to setAECEnabled, AcousticEchoCanceler not available !");
    } else {
      e.g.e("MicrophoneSetting", "failed to setAECEnabled, Android version < JELLY_BEAN !");
    } 
    return false;
  }
  
  public MicrophoneStreamingSetting setAudioPtsOptimizeEnabled(boolean paramBoolean) {
    this.b = paramBoolean;
    return this;
  }
  
  public MicrophoneStreamingSetting setAudioSource(int paramInt) {
    this.h = paramInt;
    return this;
  }
  
  public MicrophoneStreamingSetting setBluetoothSCOEnabled(boolean paramBoolean) {
    this.a = paramBoolean;
    return this;
  }
  
  public MicrophoneStreamingSetting setCaptureAudioFrameOnly(boolean paramBoolean) {
    this.c = paramBoolean;
    return this;
  }
  
  public MicrophoneStreamingSetting setChannelConfig(int paramInt) {
    this.e = paramInt;
    if (paramInt == 16) {
      paramInt = 4;
    } else {
      paramInt = 12;
    } 
    this.f = paramInt;
    return this;
  }
  
  public MicrophoneStreamingSetting setSampleRate(int paramInt) {
    this.d = paramInt;
    return this;
  }
  
  public String toString() {
    JSONObject jSONObject = new JSONObject();
    try {
      jSONObject.put("SampleRate", this.d);
      jSONObject.put("Channel", this.e);
      jSONObject.put("BluetoothSCOEnabled", this.a);
      jSONObject.put("AudioPtsOptimizeEnable", this.b);
      jSONObject.put("IsAECEnabled", this.g);
      return jSONObject.toString();
    } catch (JSONException jSONException) {
      jSONException.printStackTrace();
      return jSONException.toString();
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qiniu\pili\droid\streaming\MicrophoneStreamingSetting.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */