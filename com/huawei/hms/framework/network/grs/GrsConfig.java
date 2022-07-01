package com.huawei.hms.framework.network.grs;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.framework.common.PackageUtils;
import com.huawei.hms.framework.common.StringUtils;

public class GrsConfig {
  private String appName;
  
  private String countrySource;
  
  private String issueCountry;
  
  private String regCountry;
  
  private String serCountry;
  
  private String userId;
  
  private String versionName;
  
  public boolean equal(GrsConfig paramGrsConfig) {
    return (paramGrsConfig != null && StringUtils.strEquals(this.appName, paramGrsConfig.getAppName()) && StringUtils.strEquals(this.serCountry, paramGrsConfig.getSerCountry()) && StringUtils.strEquals(this.regCountry, paramGrsConfig.getRegCountry()) && StringUtils.strEquals(this.issueCountry, paramGrsConfig.getIssueCountry()) && StringUtils.strEquals(this.userId, paramGrsConfig.getuserId()) && StringUtils.strEquals(this.versionName, paramGrsConfig.getVersionName()) && StringUtils.strEquals(this.countrySource, paramGrsConfig.getCountrySource()));
  }
  
  public String getAppName() {
    return this.appName;
  }
  
  public String getCountrySource() {
    return this.countrySource;
  }
  
  public GrsBaseInfo getGrsBaseInfo(Context paramContext) {
    String str;
    GrsBaseInfo grsBaseInfo = new GrsBaseInfo();
    grsBaseInfo.setSerCountry(this.serCountry);
    if (TextUtils.isEmpty(this.versionName)) {
      str = PackageUtils.getVersionName(paramContext);
    } else {
      str = this.versionName;
    } 
    grsBaseInfo.setVersionName(str);
    grsBaseInfo.setAppName(this.appName);
    grsBaseInfo.setUid(this.userId);
    grsBaseInfo.setRegCountry(this.regCountry);
    grsBaseInfo.setIssueCountry(this.issueCountry);
    grsBaseInfo.setCountrySource(this.countrySource);
    return grsBaseInfo;
  }
  
  public String getIssueCountry() {
    return this.issueCountry;
  }
  
  public String getRegCountry() {
    return this.regCountry;
  }
  
  public String getSerCountry() {
    return this.serCountry;
  }
  
  public String getVersionName() {
    return this.versionName;
  }
  
  public String getuserId() {
    return this.userId;
  }
  
  public void setAppName(String paramString) {
    this.appName = paramString;
  }
  
  public void setCountrySource(String paramString) {
    this.countrySource = paramString;
  }
  
  public void setIssueCountry(String paramString) {
    this.issueCountry = paramString;
  }
  
  public void setRegCountry(String paramString) {
    this.regCountry = paramString;
  }
  
  public void setSerCountry(String paramString) {
    this.serCountry = paramString;
  }
  
  public void setUserId(String paramString) {
    this.userId = paramString;
  }
  
  public void setVersionName(String paramString) {
    this.versionName = paramString;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\hms\framework\network\grs\GrsConfig.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */