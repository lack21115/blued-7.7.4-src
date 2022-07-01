package com.sensetime.stmobile.model;

public class STAnimalFace {
  int id;
  
  int key_points_count;
  
  STPoint[] p_key_points;
  
  float pitch;
  
  STRect rect;
  
  float roll;
  
  float score;
  
  float yaw;
  
  public int getId() {
    return this.id;
  }
  
  public int getKey_points_count() {
    return this.key_points_count;
  }
  
  public STPoint[] getP_key_points() {
    return this.p_key_points;
  }
  
  public float getPitch() {
    return this.pitch;
  }
  
  public STRect getRect() {
    return this.rect;
  }
  
  public float getRoll() {
    return this.roll;
  }
  
  public float getScore() {
    return this.score;
  }
  
  public float getYaw() {
    return this.yaw;
  }
  
  public void setId(int paramInt) {
    this.id = paramInt;
  }
  
  public void setKey_points_count(int paramInt) {
    this.key_points_count = paramInt;
  }
  
  public void setP_key_points(STPoint[] paramArrayOfSTPoint) {
    this.p_key_points = paramArrayOfSTPoint;
  }
  
  public void setPitch(float paramFloat) {
    this.pitch = paramFloat;
  }
  
  public void setRect(STRect paramSTRect) {
    this.rect = paramSTRect;
  }
  
  public void setRoll(float paramFloat) {
    this.roll = paramFloat;
  }
  
  public void setScore(float paramFloat) {
    this.score = paramFloat;
  }
  
  public void setYaw(float paramFloat) {
    this.yaw = paramFloat;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\sensetime\stmobile\model\STAnimalFace.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */