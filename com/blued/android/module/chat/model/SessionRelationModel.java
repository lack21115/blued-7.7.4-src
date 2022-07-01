package com.blued.android.module.chat.model;

public class SessionRelationModel extends SessionBaseModel {
  private int delete;
  
  private int follower;
  
  private int initiator;
  
  private int is_hide_last_operate;
  
  private int nearby;
  
  private int online;
  
  private long uid;
  
  public void copySessionRelation(SessionRelationModel paramSessionRelationModel) {
    if (paramSessionRelationModel == null)
      return; 
    setNearby(paramSessionRelationModel.getNearby());
    setOnline(paramSessionRelationModel.getOnline());
    setFollower(paramSessionRelationModel.getFollower());
    setInitiator(paramSessionRelationModel.getInitiator());
    setDelete(paramSessionRelationModel.getDelete());
    setIs_hide_last_operate(paramSessionRelationModel.getIs_hide_last_operate());
  }
  
  public int getDelete() {
    return this.delete;
  }
  
  public int getFollower() {
    return this.follower;
  }
  
  public int getInitiator() {
    return this.initiator;
  }
  
  public int getIs_hide_last_operate() {
    return this.is_hide_last_operate;
  }
  
  public int getNearby() {
    return this.nearby;
  }
  
  public int getOnline() {
    return this.online;
  }
  
  public long getUid() {
    return this.uid;
  }
  
  public void setDelete(int paramInt) {
    this.delete = paramInt;
  }
  
  public void setFollower(int paramInt) {
    this.follower = paramInt;
  }
  
  public void setInitiator(int paramInt) {
    this.initiator = paramInt;
  }
  
  public void setIs_hide_last_operate(int paramInt) {
    this.is_hide_last_operate = paramInt;
  }
  
  public void setNearby(int paramInt) {
    this.nearby = paramInt;
  }
  
  public void setOnline(int paramInt) {
    this.online = paramInt;
  }
  
  public void setUid(long paramLong) {
    this.uid = paramLong;
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("SessionRelationModel{uid=");
    stringBuilder.append(this.uid);
    stringBuilder.append(", nearby=");
    stringBuilder.append(this.nearby);
    stringBuilder.append(", online=");
    stringBuilder.append(this.online);
    stringBuilder.append(", follower=");
    stringBuilder.append(this.follower);
    stringBuilder.append(", initiator=");
    stringBuilder.append(this.initiator);
    stringBuilder.append(", delete=");
    stringBuilder.append(this.delete);
    stringBuilder.append(", is_hide_last_operate=");
    stringBuilder.append(this.is_hide_last_operate);
    stringBuilder.append("} ");
    stringBuilder.append(super.toString());
    return stringBuilder.toString();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\chat\model\SessionRelationModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */