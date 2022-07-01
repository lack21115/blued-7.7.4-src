package com.soft.blued.ui.group.model;

import java.util.List;

public class BluedGroupCheck {
  String able;
  
  public GroupFailureReason reason;
  
  public String getAble() {
    return this.able;
  }
  
  public GroupFailureReason getReason() {
    return this.reason;
  }
  
  public void setAble(String paramString) {
    this.able = paramString;
  }
  
  public void setReason(GroupFailureReason paramGroupFailureReason) {
    this.reason = paramGroupFailureReason;
  }
  
  public static class AccountFailure {
    public String able;
    
    public String reason;
    
    public String getAble() {
      return this.able;
    }
    
    public String getReason() {
      return this.reason;
    }
    
    public void setAble(String param1String) {
      this.able = param1String;
    }
    
    public void setReason(String param1String) {
      this.reason = param1String;
    }
  }
  
  public static class GroupFailure {
    public String able;
    
    public List<String> reason;
    
    public String getAble() {
      return this.able;
    }
    
    public List<String> getReason() {
      return this.reason;
    }
    
    public void setAble(String param1String) {
      this.able = param1String;
    }
    
    public void setReason(List<String> param1List) {
      this.reason = param1List;
    }
  }
  
  public static class GroupFailureReason {
    public BluedGroupCheck.AccountFailure days;
    
    public BluedGroupCheck.GroupFailure num;
    
    public BluedGroupCheck.AccountFailure getDays() {
      return this.days;
    }
    
    public BluedGroupCheck.GroupFailure getNum() {
      return this.num;
    }
    
    public void setDays(BluedGroupCheck.AccountFailure param1AccountFailure) {
      this.days = param1AccountFailure;
    }
    
    public void setNum(BluedGroupCheck.GroupFailure param1GroupFailure) {
      this.num = param1GroupFailure;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\group\model\BluedGroupCheck.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */