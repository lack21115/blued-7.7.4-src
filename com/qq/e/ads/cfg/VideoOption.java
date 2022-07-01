package com.qq.e.ads.cfg;

import com.qq.e.comm.util.GDTLogger;
import org.json.JSONObject;

public class VideoOption {
  private final boolean a;
  
  private final int b;
  
  private final boolean c;
  
  private final boolean d;
  
  private final boolean e;
  
  private final boolean f;
  
  private final boolean g;
  
  private VideoOption(Builder paramBuilder) {
    this.a = Builder.a(paramBuilder);
    this.b = Builder.b(paramBuilder);
    this.c = Builder.c(paramBuilder);
    this.d = Builder.d(paramBuilder);
    this.e = Builder.e(paramBuilder);
    this.f = Builder.f(paramBuilder);
    this.g = Builder.g(paramBuilder);
  }
  
  public boolean getAutoPlayMuted() {
    return this.a;
  }
  
  public int getAutoPlayPolicy() {
    return this.b;
  }
  
  public JSONObject getOptions() {
    JSONObject jSONObject = new JSONObject();
    try {
      jSONObject.putOpt("autoPlayMuted", Boolean.valueOf(this.a));
      jSONObject.putOpt("autoPlayPolicy", Integer.valueOf(this.b));
      jSONObject.putOpt("detailPageMuted", Boolean.valueOf(this.g));
      return jSONObject;
    } catch (Exception exception) {
      StringBuilder stringBuilder = new StringBuilder("Get video options error: ");
      stringBuilder.append(exception.getMessage());
      GDTLogger.e(stringBuilder.toString());
      return jSONObject;
    } 
  }
  
  public boolean isDetailPageMuted() {
    return this.g;
  }
  
  public boolean isEnableDetailPage() {
    return this.e;
  }
  
  public boolean isEnableUserControl() {
    return this.f;
  }
  
  public boolean isNeedCoverImage() {
    return this.d;
  }
  
  public boolean isNeedProgressBar() {
    return this.c;
  }
  
  public static final class AutoPlayPolicy {
    public static final int ALWAYS = 1;
    
    public static final int NEVER = 2;
    
    public static final int WIFI = 0;
  }
  
  public static final class Builder {
    private boolean a = true;
    
    private int b = 1;
    
    private boolean c = true;
    
    private boolean d = true;
    
    private boolean e = true;
    
    private boolean f = false;
    
    private boolean g = false;
    
    public final VideoOption build() {
      return new VideoOption(this, (byte)0);
    }
    
    public final Builder setAutoPlayMuted(boolean param1Boolean) {
      this.a = param1Boolean;
      return this;
    }
    
    public final Builder setAutoPlayPolicy(int param1Int) {
      if (param1Int >= 0) {
        int i = param1Int;
        if (param1Int > 2) {
          StringBuilder stringBuilder1 = new StringBuilder("invalid value of autoPlayPolicy, can only be [0, 2], reset to : ");
          stringBuilder1.append(1);
          GDTLogger.e(stringBuilder1.toString());
          i = 1;
          this.b = i;
          return this;
        } 
        this.b = i;
        return this;
      } 
      StringBuilder stringBuilder = new StringBuilder("invalid value of autoPlayPolicy, can only be [0, 2], reset to : ");
      stringBuilder.append(1);
      GDTLogger.e(stringBuilder.toString());
      boolean bool = true;
      this.b = bool;
      return this;
    }
    
    public final Builder setDetailPageMuted(boolean param1Boolean) {
      this.g = param1Boolean;
      return this;
    }
    
    public final Builder setEnableDetailPage(boolean param1Boolean) {
      this.e = param1Boolean;
      return this;
    }
    
    public final Builder setEnableUserControl(boolean param1Boolean) {
      this.f = param1Boolean;
      return this;
    }
    
    public final Builder setNeedCoverImage(boolean param1Boolean) {
      this.d = param1Boolean;
      return this;
    }
    
    public final Builder setNeedProgressBar(boolean param1Boolean) {
      this.c = param1Boolean;
      return this;
    }
  }
  
  public static final class VideoADContainerRender {
    public static final int DEV = 2;
    
    public static final int SDK = 1;
    
    public static final int UNKNOWN = 0;
  }
  
  public static final class VideoPlayPolicy {
    public static final int AUTO = 1;
    
    public static final int MANUAL = 2;
    
    public static final int UNKNOWN = 0;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\ads\cfg\VideoOption.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */