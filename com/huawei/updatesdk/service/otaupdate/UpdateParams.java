package com.huawei.updatesdk.service.otaupdate;

import com.huawei.updatesdk.service.appmgr.bean.Param;
import java.util.List;

public class UpdateParams {
  private boolean isShowImmediate = false;
  
  private int minIntervalDay = 0;
  
  private boolean mustBtnOne = false;
  
  private List<String> packageList;
  
  private List<Param> paramList;
  
  private String serviceZone;
  
  private String targetPkgName;
  
  private UpdateParams(Builder paramBuilder) {
    this.serviceZone = paramBuilder.serviceZone;
    this.targetPkgName = paramBuilder.targetPkgName;
    this.isShowImmediate = paramBuilder.isShowImmediate;
    this.minIntervalDay = paramBuilder.minIntervalDay;
    this.mustBtnOne = paramBuilder.mustBtnOne;
    this.packageList = paramBuilder.packageList;
    this.paramList = paramBuilder.paramList;
  }
  
  public int getMinIntervalDay() {
    return this.minIntervalDay;
  }
  
  public List<String> getPackageList() {
    return this.packageList;
  }
  
  public List<Param> getParamList() {
    return this.paramList;
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
  
  public void resetParamList() {
    this.paramList = null;
  }
  
  public static final class Builder {
    private boolean isShowImmediate;
    
    private int minIntervalDay;
    
    private boolean mustBtnOne;
    
    private List<String> packageList;
    
    private List<Param> paramList;
    
    private String serviceZone = h.g().b();
    
    private String targetPkgName;
    
    public UpdateParams build() {
      return new UpdateParams(this, null);
    }
    
    public Builder setIsShowImmediate(boolean param1Boolean) {
      this.isShowImmediate = param1Boolean;
      return this;
    }
    
    public Builder setMinIntervalDay(int param1Int) {
      this.minIntervalDay = param1Int;
      return this;
    }
    
    public Builder setMustBtnOne(boolean param1Boolean) {
      this.mustBtnOne = param1Boolean;
      return this;
    }
    
    public Builder setPackageList(List<String> param1List) {
      this.packageList = param1List;
      return this;
    }
    
    public Builder setParamList(List<Param> param1List) {
      this.paramList = param1List;
      return this;
    }
    
    public Builder setServiceZone(String param1String) {
      this.serviceZone = param1String;
      return this;
    }
    
    public Builder setTargetPkgName(String param1String) {
      this.targetPkgName = param1String;
      return this;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawe\\updatesdk\service\otaupdate\UpdateParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */