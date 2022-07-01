package com.bytedance.sdk.openadsdk;

import com.bytedance.sdk.adnet.face.IHttpStack;

public final class TTAdConfig {
  private String a;
  
  private String b;
  
  private boolean c = false;
  
  private String d;
  
  private String e;
  
  private int f = 0;
  
  private boolean g = true;
  
  private boolean h = false;
  
  private boolean i = false;
  
  private int[] j;
  
  private boolean k = false;
  
  private boolean l = false;
  
  private IHttpStack m;
  
  private TTDownloadEventLogger n;
  
  private TTSecAbs o;
  
  private String[] p;
  
  private boolean q = false;
  
  private TTCustomController r;
  
  private TTAdConfig() {}
  
  public String getAppId() {
    return this.a;
  }
  
  public String getAppName() {
    return this.b;
  }
  
  public TTCustomController getCustomController() {
    return this.r;
  }
  
  public String getData() {
    return this.e;
  }
  
  public int[] getDirectDownloadNetworkType() {
    return this.j;
  }
  
  public IHttpStack getHttpStack() {
    return this.m;
  }
  
  public String getKeywords() {
    return this.d;
  }
  
  public String[] getNeedClearTaskReset() {
    return this.p;
  }
  
  public TTDownloadEventLogger getTTDownloadEventLogger() {
    return this.n;
  }
  
  public TTSecAbs getTTSecAbs() {
    return this.o;
  }
  
  public int getTitleBarTheme() {
    return this.f;
  }
  
  public boolean isAllowShowNotify() {
    return this.g;
  }
  
  public boolean isAllowShowPageWhenScreenLock() {
    return this.i;
  }
  
  public boolean isAsyncInit() {
    return this.q;
  }
  
  public boolean isDebug() {
    return this.h;
  }
  
  public boolean isPaid() {
    return this.c;
  }
  
  public boolean isSupportMultiProcess() {
    return this.l;
  }
  
  public boolean isUseTextureView() {
    return this.k;
  }
  
  public void setAllowShowNotify(boolean paramBoolean) {
    this.g = paramBoolean;
  }
  
  public void setAllowShowPageWhenScreenLock(boolean paramBoolean) {
    this.i = paramBoolean;
  }
  
  public void setAppId(String paramString) {
    this.a = paramString;
  }
  
  public void setAppName(String paramString) {
    this.b = paramString;
  }
  
  public void setAsyncInit(boolean paramBoolean) {
    this.q = paramBoolean;
  }
  
  public void setCustomController(TTCustomController paramTTCustomController) {
    this.r = paramTTCustomController;
  }
  
  public void setData(String paramString) {
    this.e = paramString;
  }
  
  public void setDebug(boolean paramBoolean) {
    this.h = paramBoolean;
  }
  
  public void setDirectDownloadNetworkType(int... paramVarArgs) {
    this.j = paramVarArgs;
  }
  
  public void setHttpStack(IHttpStack paramIHttpStack) {
    this.m = paramIHttpStack;
  }
  
  public void setKeywords(String paramString) {
    this.d = paramString;
  }
  
  public void setNeedClearTaskReset(String... paramVarArgs) {
    this.p = paramVarArgs;
  }
  
  public void setPaid(boolean paramBoolean) {
    this.c = paramBoolean;
  }
  
  public void setSupportMultiProcess(boolean paramBoolean) {
    this.l = paramBoolean;
  }
  
  public void setTTDownloadEventLogger(TTDownloadEventLogger paramTTDownloadEventLogger) {
    this.n = paramTTDownloadEventLogger;
  }
  
  public void setTTSecAbs(TTSecAbs paramTTSecAbs) {
    this.o = paramTTSecAbs;
  }
  
  public void setTitleBarTheme(int paramInt) {
    this.f = paramInt;
  }
  
  public void setUseTextureView(boolean paramBoolean) {
    this.k = paramBoolean;
  }
  
  public static class Builder {
    private String a;
    
    private String b;
    
    private boolean c = false;
    
    private String d;
    
    private String e;
    
    private int f = 0;
    
    private boolean g = true;
    
    private boolean h = false;
    
    private boolean i = false;
    
    private int[] j;
    
    private boolean k = false;
    
    private boolean l = false;
    
    private IHttpStack m;
    
    private TTDownloadEventLogger n;
    
    private TTSecAbs o;
    
    private String[] p;
    
    private boolean q = false;
    
    private TTCustomController r;
    
    public Builder allowShowNotify(boolean param1Boolean) {
      this.g = param1Boolean;
      return this;
    }
    
    public Builder allowShowPageWhenScreenLock(boolean param1Boolean) {
      this.i = param1Boolean;
      return this;
    }
    
    public Builder appId(String param1String) {
      this.a = param1String;
      return this;
    }
    
    public Builder appName(String param1String) {
      this.b = param1String;
      return this;
    }
    
    public Builder asyncInit(boolean param1Boolean) {
      this.q = param1Boolean;
      return this;
    }
    
    public TTAdConfig build() {
      TTAdConfig tTAdConfig = new TTAdConfig();
      tTAdConfig.setAppId(this.a);
      tTAdConfig.setAppName(this.b);
      tTAdConfig.setPaid(this.c);
      tTAdConfig.setKeywords(this.d);
      tTAdConfig.setData(this.e);
      tTAdConfig.setTitleBarTheme(this.f);
      tTAdConfig.setAllowShowNotify(this.g);
      tTAdConfig.setDebug(this.h);
      tTAdConfig.setAllowShowPageWhenScreenLock(this.i);
      tTAdConfig.setDirectDownloadNetworkType(this.j);
      tTAdConfig.setUseTextureView(this.k);
      tTAdConfig.setSupportMultiProcess(this.l);
      tTAdConfig.setHttpStack(this.m);
      tTAdConfig.setTTDownloadEventLogger(this.n);
      tTAdConfig.setTTSecAbs(this.o);
      tTAdConfig.setNeedClearTaskReset(this.p);
      tTAdConfig.setAsyncInit(this.q);
      tTAdConfig.setCustomController(this.r);
      return tTAdConfig;
    }
    
    public Builder customController(TTCustomController param1TTCustomController) {
      this.r = param1TTCustomController;
      return this;
    }
    
    public Builder data(String param1String) {
      this.e = param1String;
      return this;
    }
    
    public Builder debug(boolean param1Boolean) {
      this.h = param1Boolean;
      return this;
    }
    
    public Builder directDownloadNetworkType(int... param1VarArgs) {
      this.j = param1VarArgs;
      return this;
    }
    
    @Deprecated
    public Builder globalDownloadListener(TTGlobalAppDownloadListener param1TTGlobalAppDownloadListener) {
      return this;
    }
    
    public Builder httpStack(IHttpStack param1IHttpStack) {
      this.m = param1IHttpStack;
      return this;
    }
    
    public Builder keywords(String param1String) {
      this.d = param1String;
      return this;
    }
    
    public Builder needClearTaskReset(String... param1VarArgs) {
      this.p = param1VarArgs;
      return this;
    }
    
    public Builder paid(boolean param1Boolean) {
      this.c = param1Boolean;
      return this;
    }
    
    public Builder supportMultiProcess(boolean param1Boolean) {
      this.l = param1Boolean;
      return this;
    }
    
    public Builder titleBarTheme(int param1Int) {
      this.f = param1Int;
      return this;
    }
    
    public Builder ttDownloadEventLogger(TTDownloadEventLogger param1TTDownloadEventLogger) {
      this.n = param1TTDownloadEventLogger;
      return this;
    }
    
    public Builder ttSecAbs(TTSecAbs param1TTSecAbs) {
      this.o = param1TTSecAbs;
      return this;
    }
    
    public Builder useTextureView(boolean param1Boolean) {
      this.k = param1Boolean;
      return this;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\openadsdk\TTAdConfig.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */