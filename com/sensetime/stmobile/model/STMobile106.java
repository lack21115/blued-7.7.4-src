package com.sensetime.stmobile.model;

public class STMobile106 {
  int ID;
  
  float eye_dist;
  
  float pitch;
  
  STPoint[] points_array = new STPoint[106];
  
  STRect rect;
  
  float roll;
  
  float score;
  
  float[] visibility_array = new float[106];
  
  float yaw;
  
  public STMobile106(STRect paramSTRect, float paramFloat1, STPoint[] paramArrayOfSTPoint, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, int paramInt) {
    this.rect = paramSTRect;
    this.score = paramFloat1;
    this.points_array = paramArrayOfSTPoint;
    this.yaw = paramFloat2;
    this.pitch = paramFloat3;
    this.roll = paramFloat4;
    this.eye_dist = paramFloat5;
    this.ID = paramInt;
  }
  
  public float getEye_dist() {
    return this.eye_dist;
  }
  
  public int getID() {
    return this.ID;
  }
  
  public float getPitch() {
    return this.pitch;
  }
  
  public STPoint[] getPoints_array() {
    return this.points_array;
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
  
  public float[] getVisibilityArray() {
    return this.visibility_array;
  }
  
  public float getYaw() {
    return this.yaw;
  }
  
  public void setEye_dist(float paramFloat) {
    this.eye_dist = paramFloat;
  }
  
  public void setID(int paramInt) {
    this.ID = paramInt;
  }
  
  public void setPitch(float paramFloat) {
    this.pitch = paramFloat;
  }
  
  public void setPoints_array(STPoint[] paramArrayOfSTPoint) {
    this.points_array = paramArrayOfSTPoint;
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


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\sensetime\stmobile\model\STMobile106.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */