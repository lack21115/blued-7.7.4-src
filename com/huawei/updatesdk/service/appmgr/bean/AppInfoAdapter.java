package com.huawei.updatesdk.service.appmgr.bean;

import java.util.List;

public class AppInfoAdapter {
  private String appId;
  
  private String appStorePkgName;
  
  private String business;
  
  private String carrierId;
  
  private boolean isShowImmediate = false;
  
  private int minIntervalDay = 0;
  
  private boolean mustBtnOne = false;
  
  private List<String> packageList;
  
  private String serviceZone;
  
  private String targetPkgName;
  
  public String getAppId() {
    return this.appId;
  }
  
  public String getAppStorePkgName() {
    return this.appStorePkgName;
  }
  
  public String getBusiness() {
    return this.business;
  }
  
  public String getCarrierId() {
    return this.carrierId;
  }
  
  public int getMinIntervalDay() {
    return this.minIntervalDay;
  }
  
  public List<String> getPackageList() {
    return this.packageList;
  }
  
  public String getServiceZone() {
    return this.serviceZone;
  }
  
  public String getTargetPkgName() {
    return this.targetPkgName;
  }
  
  public boolean isMustBtnOne() {
    return this.mustBtnOne;
  }
  
  public boolean isShowImmediate() {
    return this.isShowImmediate;
  }
  
  public void setAppId(String paramString) {
    this.appId = paramString;
  }
  
  public void setAppStorePkgName(String paramString) {
    this.appStorePkgName = paramString;
  }
  
  public void setBusiness(String paramString) {
    this.business = paramString;
  }
  
  public void setCarrierId(String paramString) {
    this.carrierId = paramString;
  }
  
  public void setMinIntervalDay(int paramInt) {
    this.minIntervalDay = paramInt;
  }
  
  public void setMustBtnOne(boolean paramBoolean) {
    this.mustBtnOne = paramBoolean;
  }
  
  public void setPackageList(List<String> paramList) {
    this.packageList = paramList;
  }
  
  public void setServiceZone(String paramString) {
    this.serviceZone = paramString;
  }
  
  public void setShowImmediate(boolean paramBoolean) {
    this.isShowImmediate = paramBoolean;
  }
  
  public void setTargetPkgName(String paramString) {
    this.targetPkgName = paramString;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawe\\updatesdk\service\appmgr\bean\AppInfoAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */