package com.sensetime.stmobile.model;

public class STCondition {
  private int preState;
  
  private int preStateModuleId;
  
  private int triggerCount;
  
  private STTriggerEvent[] triggers;
  
  public int getPreState() {
    return this.preState;
  }
  
  public int getPreStateModuleId() {
    return this.preStateModuleId;
  }
  
  public int getTriggerCount() {
    return this.triggerCount;
  }
  
  public STTriggerEvent[] getTriggers() {
    return this.triggers;
  }
  
  public void setPreState(int paramInt) {
    this.preState = paramInt;
  }
  
  public void setPreStateModuleId(int paramInt) {
    this.preStateModuleId = paramInt;
  }
  
  public void setTriggerCount(int paramInt) {
    this.triggerCount = paramInt;
  }
  
  public void setTriggers(STTriggerEvent[] paramArrayOfSTTriggerEvent) {
    this.triggers = paramArrayOfSTTriggerEvent;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\sensetime\stmobile\model\STCondition.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */