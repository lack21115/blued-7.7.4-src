package com.qiniu.pili.droid.shortvideo.encode;

import android.media.MediaFormat;
import com.qiniu.pili.droid.shortvideo.PLAudioEncodeSetting;

public class c extends d {
  private PLAudioEncodeSetting g;
  
  public c(PLAudioEncodeSetting paramPLAudioEncodeSetting) {
    this.g = paramPLAudioEncodeSetting;
  }
  
  protected MediaFormat g() {
    MediaFormat mediaFormat = MediaFormat.createAudioFormat("audio/mp4a-latm", this.g.getSamplerate(), this.g.getChannels());
    mediaFormat.setInteger("aac-profile", 2);
    mediaFormat.setInteger("sample-rate", this.g.getSamplerate());
    mediaFormat.setInteger("channel-count", this.g.getChannels());
    mediaFormat.setInteger("bitrate", this.g.getBitrate());
    mediaFormat.setInteger("max-input-size", 16384);
    return mediaFormat;
  }
  
  protected String h() {
    return "audio/mp4a-latm";
  }
  
  protected d.a i() {
    return d.a.b;
  }
  
  public String j() {
    return "HWAudioEncoder";
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\qiniu\pili\droid\shortvideo\encode\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */