package com.sensetime.stmobile.model;

public class STTriggerEvent {
  private boolean isAppear;
  
  private int moduleId;
  
  private long trigger;
  
  private int triggerType;
  
  public int getModuleId() {
    return this.moduleId;
  }
  
  public long getTrigger() {
    return this.trigger;
  }
  
  public int getTriggerType() {
    return this.triggerType;
  }
  
  public boolean isAppear() {
    return this.isAppear;
  }
  
  public void setAppear(boolean paramBoolean) {
    this.isAppear = paramBoolean;
  }
  
  public void setModuleId(int paramInt) {
    this.moduleId = paramInt;
  }
  
  public void setTrigger(long paramLong) {
    this.trigger = paramLong;
  }
  
  public void setTriggerType(int paramInt) {
    this.triggerType = paramInt;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\sensetime\stmobile\model\STTriggerEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */