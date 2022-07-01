package com.huawei.hianalytics.ab.bc.cd.ab;

import com.huawei.hianalytics.ab.bc.ef.ab;

public class ef {
  private cd ab;
  
  private cd bc;
  
  private cd cd;
  
  private cd de;
  
  public ef(String paramString) {}
  
  public cd ab() {
    return this.cd;
  }
  
  public cd ab(String paramString) {
    if (paramString.equals("oper"))
      return cd(); 
    if (paramString.equals("maint"))
      return bc(); 
    if (paramString.equals("diffprivacy"))
      return ab(); 
    if (paramString.equals("preins"))
      return de(); 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("HiAnalyticsInstData.getConfig(type): wrong type: ");
    stringBuilder.append(paramString);
    ab.fg("hmsSdk", stringBuilder.toString());
    return null;
  }
  
  public void ab(cd paramcd) {
    this.cd = paramcd;
  }
  
  public cd bc() {
    return this.ab;
  }
  
  public void bc(cd paramcd) {
    this.ab = paramcd;
  }
  
  public cd cd() {
    return this.bc;
  }
  
  public void cd(cd paramcd) {
    this.bc = paramcd;
  }
  
  public cd de() {
    return this.de;
  }
  
  public void de(cd paramcd) {
    this.de = paramcd;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\hianalytics\ab\bc\cd\ab\ef.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */