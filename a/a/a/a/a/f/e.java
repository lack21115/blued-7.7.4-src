package a.a.a.a.a.f;

import com.qiniu.pili.droid.streaming.AVCodecType;

public final class e {
  public boolean a;
  
  public boolean b;
  
  public AVCodecType c;
  
  public boolean d;
  
  public boolean e;
  
  public e() {}
  
  public static e a() {
    return b.a;
  }
  
  public e a(AVCodecType paramAVCodecType) {
    this.c = paramAVCodecType;
    return this;
  }
  
  public e a(boolean paramBoolean) {
    this.e = paramBoolean;
    return this;
  }
  
  public e b(boolean paramBoolean) {
    this.d = paramBoolean;
    return this;
  }
  
  public boolean b() {
    return ((!this.d || this.e) && this.a);
  }
  
  public e c(boolean paramBoolean) {
    this.a = paramBoolean;
    return this;
  }
  
  public boolean c() {
    return (!this.a && this.b && f());
  }
  
  public e d(boolean paramBoolean) {
    this.b = paramBoolean;
    return this;
  }
  
  public boolean d() {
    return (this.d && !this.e && this.a);
  }
  
  public boolean e() {
    return (!c() && !b() && !d());
  }
  
  public final boolean f() {
    AVCodecType aVCodecType = this.c;
    return (aVCodecType == AVCodecType.SW_VIDEO_CODEC || aVCodecType == AVCodecType.SW_VIDEO_WITH_HW_AUDIO_CODEC || aVCodecType == AVCodecType.SW_VIDEO_WITH_SW_AUDIO_CODEC || aVCodecType == AVCodecType.HW_VIDEO_YUV_AS_INPUT_WITH_HW_AUDIO_CODEC);
  }
  
  public static class b {
    public static final e a = new e(null);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\a\a\a\a\a\f\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */