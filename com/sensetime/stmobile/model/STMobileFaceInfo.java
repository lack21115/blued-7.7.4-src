package com.sensetime.stmobile.model;

public class STMobileFaceInfo {
  public byte[] avatarHelpInfo;
  
  public int avatarHelpInfoLength;
  
  public STPoint[] extraFacePoints;
  
  public int extraFacePointsCount;
  
  public STPoint[] eyeballCenter;
  
  public int eyeballCenterPointsCount;
  
  public STPoint[] eyeballContour;
  
  public int eyeballContourPointsCount;
  
  public STMobile106 face106;
  
  public long faceAction;
  
  public float[] faceActionScore;
  
  public int faceActionScoreCount;
  
  public float leftEyeballScore;
  
  public float rightEyeballScore;
  
  public STPoint[] tonguePoints;
  
  public int tonguePointsCount;
  
  public float[] tonguePointsScore;
  
  public STPoint[] getExtraFacePoints() {
    return this.extraFacePoints;
  }
  
  public int getExtraFacePointsCount() {
    return this.extraFacePointsCount;
  }
  
  public STPoint[] getEyeballCenter() {
    return this.eyeballCenter;
  }
  
  public int getEyeballCenterPointsCount() {
    return this.eyeballCenterPointsCount;
  }
  
  public STPoint[] getEyeballContour() {
    return this.eyeballContour;
  }
  
  public int getEyeballContourPointsCount() {
    return this.eyeballContourPointsCount;
  }
  
  public STMobile106 getFace() {
    return this.face106;
  }
  
  public long getFaceAction() {
    return this.faceAction;
  }
  
  public void setFace(STMobile106 paramSTMobile106) {
    this.face106 = paramSTMobile106;
  }
  
  public void setFaceAction(long paramLong) {
    this.faceAction = paramLong;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\sensetime\stmobile\model\STMobileFaceInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */