package com.bytedance.embedapplog;

import com.bytedance.embedapplog.c.a;

public class InitConfig {
  private ISensitiveInfoProvider A;
  
  private String a;
  
  private String b;
  
  private String c;
  
  private String d;
  
  private String e;
  
  private String f;
  
  private IPicker g;
  
  private boolean h;
  
  private int i = 0;
  
  private String j;
  
  private String k;
  
  private String l;
  
  private String m;
  
  private int n;
  
  private int o;
  
  private int p;
  
  private String q;
  
  private String r;
  
  private String s;
  
  private String t;
  
  private String u;
  
  private String v;
  
  private String w;
  
  private boolean x = true;
  
  private boolean y = true;
  
  private String z;
  
  public InitConfig(String paramString1, String paramString2) {
    this.a = paramString1;
    this.b = paramString2;
  }
  
  public String getAbClient() {
    return this.r;
  }
  
  public String getAbFeature() {
    return this.u;
  }
  
  public String getAbGroup() {
    return this.t;
  }
  
  public String getAbVersion() {
    return this.s;
  }
  
  public String getAid() {
    return this.a;
  }
  
  public String getAliyunUdid() {
    return this.f;
  }
  
  public String getAppImei() {
    return this.z;
  }
  
  public String getAppName() {
    return this.k;
  }
  
  public String getChannel() {
    return this.b;
  }
  
  public String getGoogleAid() {
    return this.c;
  }
  
  public String getLanguage() {
    return this.d;
  }
  
  public String getManifestVersion() {
    return this.q;
  }
  
  public int getManifestVersionCode() {
    return this.p;
  }
  
  public IPicker getPicker() {
    return this.g;
  }
  
  public int getProcess() {
    return this.i;
  }
  
  public String getRegion() {
    return this.e;
  }
  
  public String getReleaseBuild() {
    return this.j;
  }
  
  public ISensitiveInfoProvider getSensitiveInfoProvider() {
    return this.A;
  }
  
  public String getTweakedChannel() {
    return this.m;
  }
  
  public int getUpdateVersionCode() {
    return this.o;
  }
  
  public String getVersion() {
    return this.l;
  }
  
  public int getVersionCode() {
    return this.n;
  }
  
  public String getVersionMinor() {
    return this.v;
  }
  
  public String getZiJieCloudPkg() {
    return this.w;
  }
  
  public boolean isImeiEnable() {
    return this.y;
  }
  
  public boolean isMacEnable() {
    return this.x;
  }
  
  public boolean isPlayEnable() {
    return this.h;
  }
  
  public InitConfig setAbClient(String paramString) {
    this.r = paramString;
    return this;
  }
  
  public InitConfig setAbFeature(String paramString) {
    this.u = paramString;
    return this;
  }
  
  public InitConfig setAbGroup(String paramString) {
    this.t = paramString;
    return this;
  }
  
  public InitConfig setAbVersion(String paramString) {
    this.s = paramString;
    return this;
  }
  
  public InitConfig setAliyunUdid(String paramString) {
    this.f = paramString;
    return this;
  }
  
  public void setAppImei(String paramString) {
    this.z = paramString;
  }
  
  public InitConfig setAppName(String paramString) {
    this.k = paramString;
    return this;
  }
  
  public InitConfig setEnablePlay(boolean paramBoolean) {
    this.h = paramBoolean;
    return this;
  }
  
  public InitConfig setGoogleAid(String paramString) {
    this.c = paramString;
    return this;
  }
  
  public void setImeiEnable(boolean paramBoolean) {
    this.y = paramBoolean;
  }
  
  public InitConfig setLanguage(String paramString) {
    this.d = paramString;
    return this;
  }
  
  public void setMacEnable(boolean paramBoolean) {
    this.x = paramBoolean;
  }
  
  public InitConfig setManifestVersion(String paramString) {
    this.q = paramString;
    return this;
  }
  
  public InitConfig setManifestVersionCode(int paramInt) {
    this.p = paramInt;
    return this;
  }
  
  public InitConfig setPicker(IPicker paramIPicker) {
    this.g = paramIPicker;
    return this;
  }
  
  public InitConfig setProcess(boolean paramBoolean) {
    byte b;
    if (paramBoolean) {
      b = 1;
    } else {
      b = 2;
    } 
    this.i = b;
    return this;
  }
  
  public InitConfig setRegion(String paramString) {
    this.e = paramString;
    return this;
  }
  
  public InitConfig setReleaseBuild(String paramString) {
    this.j = paramString;
    return this;
  }
  
  public void setSensitiveInfoProvider(ISensitiveInfoProvider paramISensitiveInfoProvider) {
    this.A = paramISensitiveInfoProvider;
  }
  
  public InitConfig setTweakedChannel(String paramString) {
    this.m = paramString;
    return this;
  }
  
  public InitConfig setUpdateVersionCode(int paramInt) {
    this.o = paramInt;
    return this;
  }
  
  public InitConfig setUriConfig(int paramInt) {
    a.a(paramInt);
    return this;
  }
  
  public InitConfig setVersion(String paramString) {
    this.l = paramString;
    return this;
  }
  
  public InitConfig setVersionCode(int paramInt) {
    this.n = paramInt;
    return this;
  }
  
  public InitConfig setVersionMinor(String paramString) {
    this.v = paramString;
    return this;
  }
  
  public InitConfig setZiJieCloudPkg(String paramString) {
    this.w = paramString;
    return this;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\embedapplog\InitConfig.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */