package a.a.a.a.a.a;

import a.a.a.a.a.a.e.a;
import a.a.a.a.a.a.i.c;
import a.a.a.a.a.e.e;
import a.a.a.a.a.e.f;
import android.content.Context;
import android.graphics.Point;
import com.qiniu.pili.droid.streaming.AVCodecType;
import com.qiniu.pili.droid.streaming.CameraStreamingSetting;
import com.qiniu.pili.droid.streaming.StreamingProfile;
import com.qiniu.pili.droid.streaming.core.PLDroidStreamingCore;

public class b {
  public b a;
  
  public c b = c.a;
  
  public AVCodecType c;
  
  public c.c d;
  
  public a e;
  
  public int f;
  
  public int g;
  
  public StreamingProfile h;
  
  public CameraStreamingSetting.PREVIEW_SIZE_RATIO i;
  
  public f j;
  
  public f k = new f(0, 0);
  
  public Point l = new Point(-1, -1);
  
  public d m;
  
  public b(Context paramContext, b paramb) {
    this.a = paramb;
  }
  
  public static c.c a(String paramString) {
    if (paramString == null) {
      e.i.e("EncodingConfig", "outputString is null");
      return c.c.d;
    } 
    if (paramString.startsWith("rtmp://"))
      return c.c.c; 
    if (paramString.endsWith(".mp4"))
      return c.c.a; 
    if (paramString.endsWith(".m3u8"))
      return c.c.b; 
    e e = e.i;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("INVALID FORMAT:");
    stringBuilder.append(paramString);
    e.e("EncodingConfig", stringBuilder.toString());
    return c.c.d;
  }
  
  public f a() {
    return this.j;
  }
  
  public void a(int paramInt) {
    this.g = paramInt;
  }
  
  public void a(c paramc, Object paramObject) {
    if (this.b == paramc)
      return; 
    this.b = paramc;
    this.a.a(paramc, paramObject);
  }
  
  public void a(a parama) {
    this.e = parama;
  }
  
  public void a(f paramf) {
    if (paramf != null)
      this.k = paramf; 
  }
  
  public void a(Point paramPoint) {
    if (paramPoint != null)
      this.l = paramPoint; 
  }
  
  public void a(AVCodecType paramAVCodecType) {
    this.c = paramAVCodecType;
  }
  
  public void a(CameraStreamingSetting.PREVIEW_SIZE_RATIO paramPREVIEW_SIZE_RATIO) {
    this.i = paramPREVIEW_SIZE_RATIO;
  }
  
  public void a(StreamingProfile.VideoEncodingSize paramVideoEncodingSize) {
    StreamingProfile.VideoEncodingSize videoEncodingSize = paramVideoEncodingSize;
    if (paramVideoEncodingSize == null)
      videoEncodingSize = this.h.getVideoEncodingSize(this.i); 
    int i = videoEncodingSize.width;
    int j = videoEncodingSize.height;
    e e = e.i;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("isEncodingLandscape:");
    stringBuilder.append(this.h.c());
    e.c("EncodingConfig", stringBuilder.toString());
    if (videoEncodingSize.level < 0) {
      this.j = new f(i, j);
    } else if (this.h.c()) {
      if (i < j) {
        this.j = new f(j, i);
      } else {
        this.j = new f(i, j);
      } 
    } else if (j < i) {
      this.j = new f(j, i);
    } else {
      this.j = new f(i, j);
    } 
    a(this.h.getStartPoint());
    a(this.h.getImageSize());
  }
  
  public void a(StreamingProfile paramStreamingProfile) {
    e e = e.i;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("setStreamingProfile profile:");
    stringBuilder.append(paramStreamingProfile);
    stringBuilder.append(",stream:");
    stringBuilder.append(paramStreamingProfile.getStream());
    stringBuilder.append(",mEncodingSizeRatio:");
    stringBuilder.append(this.i);
    e.c("EncodingConfig", stringBuilder.toString());
    this.h = paramStreamingProfile;
    b((paramStreamingProfile.getVideoProfile()).reqFps * 1000);
    a((paramStreamingProfile.getVideoProfile()).reqFps);
    if (this.h.getStream() == null) {
      this.m = new d(null, this.h.getPublishUrl());
    } else {
      this.m = new d(this.h.getStream(), this.h.getPublishHost());
    } 
    CameraStreamingSetting.PREVIEW_SIZE_RATIO pREVIEW_SIZE_RATIO = this.i;
    if (pREVIEW_SIZE_RATIO != null)
      a(this.h.getVideoEncodingSize(pREVIEW_SIZE_RATIO)); 
    String str = this.m.a();
    this.d = a(str);
    e = e.i;
    stringBuilder = new StringBuilder();
    stringBuilder.append("setStreamingProfile mFormat=");
    stringBuilder.append(this.d);
    e.c("EncodingConfig", stringBuilder.toString());
    if (this.d == c.c.d)
      a(c.o, str); 
  }
  
  public f b() {
    return this.k;
  }
  
  public void b(int paramInt) {
    this.f = paramInt;
  }
  
  public Point c() {
    return this.l;
  }
  
  public int d() {
    StreamingProfile streamingProfile = this.h;
    return (streamingProfile != null) ? (streamingProfile.getVideoProfile()).reqBitrate : 1500000;
  }
  
  public boolean e() {
    StreamingProfile streamingProfile = this.h;
    return (streamingProfile != null) ? (streamingProfile.getVideoProfile()).avcc : true;
  }
  
  public StreamingProfile f() {
    return this.h;
  }
  
  public String g() {
    return this.m.a();
  }
  
  public c.c h() {
    return this.d;
  }
  
  public boolean i() {
    return (this.d != c.c.d);
  }
  
  public a j() {
    return this.e;
  }
  
  public boolean k() {
    AVCodecType aVCodecType = this.c;
    return (aVCodecType == AVCodecType.SW_VIDEO_WITH_HW_AUDIO_CODEC || aVCodecType == AVCodecType.SW_VIDEO_WITH_SW_AUDIO_CODEC || aVCodecType == AVCodecType.SW_VIDEO_CODEC);
  }
  
  public boolean l() {
    AVCodecType aVCodecType = this.c;
    return (aVCodecType == AVCodecType.SW_VIDEO_WITH_SW_AUDIO_CODEC || aVCodecType == AVCodecType.SW_AUDIO_CODEC || aVCodecType == AVCodecType.HW_VIDEO_SURFACE_AS_INPUT_WITH_SW_AUDIO_CODEC);
  }
  
  public String m() {
    return k() ? "x264" : "droid264";
  }
  
  public String n() {
    return l() ? "voaac" : "droidaac";
  }
  
  public PLDroidStreamingCore.AVOptions o() {
    PLDroidStreamingCore.AVOptions aVOptions = new PLDroidStreamingCore.AVOptions();
    int i = a.a[this.d.ordinal()];
    if (i != 1) {
      if (i != 2) {
        if (i == 3) {
          aVOptions.outputFormatName = "flv";
        } else {
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append("Unrecognized format! ");
          stringBuilder.append(aVOptions.outputFormatName);
          throw new IllegalArgumentException(stringBuilder.toString());
        } 
      } else {
        aVOptions.outputFormatName = "hls";
      } 
    } else {
      aVOptions.outputFormatName = "mp4";
    } 
    aVOptions.outputUrl = g();
    aVOptions.videoHeight = a().b();
    aVOptions.videoWidth = a().a();
    aVOptions.videoFps = r();
    aVOptions.videoBitRate = d();
    aVOptions.avcc = e();
    aVOptions.audioSampleRate = this.e.b();
    aVOptions.audioNumChannels = this.e.a();
    aVOptions.audioBitRate = this.e.c();
    aVOptions.videoEncodeType = m();
    aVOptions.audioEncodeType = n();
    return aVOptions;
  }
  
  public int p() {
    return (this.h.getVideoProfile()).maxKeyFrameInterval;
  }
  
  public int q() {
    return this.f;
  }
  
  public int r() {
    return this.g;
  }
  
  public c s() {
    return this.b;
  }
  
  public boolean t() {
    return (this.b == c.e);
  }
  
  public static interface b {
    void a(b.c param1c, Object param1Object);
  }
  
  public enum c {
    a, b, c, d, e, f, g, h, i, j, k, l, m, n, o, p, q;
    
    static {
      c c1 = new c("ADJUST_BITRATE", 16);
      q = c1;
      r = new c[] { 
          a, b, c, d, e, f, g, h, i, j, 
          k, l, m, n, o, p, c1 };
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\a\a\a\a\a\a\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */