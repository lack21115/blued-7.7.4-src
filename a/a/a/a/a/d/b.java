package a.a.a.a.a.d;

import com.qiniu.pili.droid.streaming.AVCodecType;
import com.qiniu.pili.droid.streaming.CameraStreamingSetting;
import com.qiniu.pili.droid.streaming.StreamingProfile;
import com.qiniu.pili.droid.streaming.WatermarkSetting;

public class b {
  public static void a() {
    a("streamInit");
  }
  
  public static void a(AVCodecType paramAVCodecType) {
    switch (a.a[paramAVCodecType.ordinal()]) {
      default:
        return;
      case 10:
        a("videoHardEncode");
        a("audioSoftEncode");
        return;
      case 9:
        a("videoHardEncode");
        return;
      case 8:
        a("videoSoftEncode");
        return;
      case 7:
        a("audioHardEncode");
        return;
      case 6:
        a("audioSoftEncode");
        return;
      case 5:
        a("videoSoftEncode");
        a("audioSoftEncode");
        return;
      case 3:
      case 4:
        a("videoSoftEncode");
        a("audioHardEncode");
        return;
      case 1:
      case 2:
        break;
    } 
    a("videoHardEncode");
    a("audioHardEncode");
  }
  
  public static void a(CameraStreamingSetting.VIDEO_FILTER_TYPE paramVIDEO_FILTER_TYPE) {
    if (paramVIDEO_FILTER_TYPE.equals(CameraStreamingSetting.VIDEO_FILTER_TYPE.VIDEO_FILTER_BEAUTY))
      a("beautify"); 
  }
  
  public static void a(StreamingProfile paramStreamingProfile) {
    if (paramStreamingProfile.f())
      a("quic"); 
    a("encodeConfig");
  }
  
  public static void a(WatermarkSetting paramWatermarkSetting) {
    if (paramWatermarkSetting != null) {
      a("waterMark");
      return;
    } 
    a("clearWaterMark");
  }
  
  public static void a(String paramString) {
    f.a().b(paramString);
  }
  
  public static void a(boolean paramBoolean) {
    if (paramBoolean)
      a("muted"); 
  }
  
  public static void b() {
    a("cameraConfig");
  }
  
  public static void c() {
    a("microphoneConfig");
  }
  
  public static void d() {
    a("mediaStreamingStart");
  }
  
  public static void e() {
    a("mediaStreamingStop");
  }
  
  public static void f() {
    a("mediaStreamingDestroy");
  }
  
  public static void g() {
    a("inputStreamingStart");
  }
  
  public static void h() {
    a("inputStreamingStop");
  }
  
  public static void i() {
    a("inputStreamingDestroy");
  }
  
  public static void j() {
    a("toggleCamera");
  }
  
  public static void k() {
    a("startCapture");
  }
  
  public static void l() {
    a("stopCapture");
  }
  
  public static void m() {
    a("captureFrame");
  }
  
  public static void n() {
    a("pushImage");
  }
  
  public static void o() {
    a("playback");
  }
  
  public static void p() {
    a("audioFile");
  }
  
  public static void q() {
    a("closeAudioFile");
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\a\a\a\a\a\d\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */