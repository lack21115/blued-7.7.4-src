package com.qq.e.ads.nativ.express2;

public class VideoOption2 {
  private AutoPlayPolicy a;
  
  private boolean b;
  
  private boolean c;
  
  private int d;
  
  private int e;
  
  private VideoOption2(Builder paramBuilder) {
    this.a = paramBuilder.a;
    this.b = paramBuilder.b;
    this.c = paramBuilder.c;
    this.d = paramBuilder.d;
    this.e = paramBuilder.e;
  }
  
  public AutoPlayPolicy getAutoPlayPolicy() {
    return this.a;
  }
  
  public int getMaxVideoDuration() {
    return this.d;
  }
  
  public int getMinVideoDuration() {
    return this.e;
  }
  
  public boolean isAutoPlayMuted() {
    return this.b;
  }
  
  public boolean isDetailPageMuted() {
    return this.c;
  }
  
  public enum AutoPlayPolicy {
    ALWAYS,
    NEVER,
    WIFI(0);
    
    private int a;
    
    static {
    
    }
    
    AutoPlayPolicy(int param1Int1) {
      this.a = param1Int1;
    }
    
    public final int getPolicy() {
      return this.a;
    }
  }
  
  public static class Builder {
    VideoOption2.AutoPlayPolicy a = VideoOption2.AutoPlayPolicy.WIFI;
    
    boolean b = true;
    
    boolean c = false;
    
    int d;
    
    int e;
    
    public VideoOption2 build() {
      return new VideoOption2(this, (byte)0);
    }
    
    public Builder setAutoPlayMuted(boolean param1Boolean) {
      this.b = param1Boolean;
      return this;
    }
    
    public Builder setAutoPlayPolicy(VideoOption2.AutoPlayPolicy param1AutoPlayPolicy) {
      if (param1AutoPlayPolicy != null)
        this.a = param1AutoPlayPolicy; 
      return this;
    }
    
    public Builder setDetailPageMuted(boolean param1Boolean) {
      this.c = param1Boolean;
      return this;
    }
    
    public Builder setMaxVideoDuration(int param1Int) {
      this.d = param1Int;
      return this;
    }
    
    public Builder setMinVideoDuration(int param1Int) {
      this.e = param1Int;
      return this;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\ads\nativ\express2\VideoOption2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */