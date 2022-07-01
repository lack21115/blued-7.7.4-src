package a.a.a.a.a.a.e;

import a.a.a.a.a.e.e;
import com.qiniu.pili.droid.streaming.StreamingProfile;

public class a {
  public final int a;
  
  public final int b;
  
  public final int c;
  
  public a(int paramInt1, int paramInt2, int paramInt3) {
    this.a = paramInt1;
    this.c = paramInt3;
    this.b = paramInt2;
  }
  
  public static a a(StreamingProfile.AudioProfile paramAudioProfile) {
    e e = e.f;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("sample:");
    stringBuilder.append(paramAudioProfile.sampleRate);
    stringBuilder.append(", bitrate:");
    stringBuilder.append(paramAudioProfile.reqBitrate);
    e.c("AudioEncoderConfig", stringBuilder.toString());
    return new a(paramAudioProfile.channelNumber, paramAudioProfile.sampleRate, paramAudioProfile.reqBitrate);
  }
  
  public int a() {
    return this.a;
  }
  
  public int b() {
    return this.b;
  }
  
  public int c() {
    return this.c;
  }
  
  public int d() {
    int i = this.a;
    if (i != 1) {
      if (i == 2) {
        e.f.b("AudioEncoderConfig", "SETTING CHANNEL STEREO");
        return 12;
      } 
      throw new IllegalArgumentException("Invalid channel count. Must be 1 or 2");
    } 
    e.f.b("AudioEncoderConfig", "SETTING CHANNEL MONO");
    return 16;
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("AudioEncoderConfig: ");
    stringBuilder.append(this.a);
    stringBuilder.append(" channels totaling ");
    stringBuilder.append(this.c);
    stringBuilder.append(" bps @");
    stringBuilder.append(this.b);
    stringBuilder.append(" Hz");
    return stringBuilder.toString();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\a\a\a\a\a\a\e\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */