package com.sensetime.stmobile.model;

public class STMobileBodyInfo {
  public long bodyAction;
  
  public float bodyActionScore;
  
  public STPoint[] contourPoints;
  
  public int contourPointsCount;
  
  public float[] contourPointsScore;
  
  public int id;
  
  public STPoint[] keyPoints;
  
  public int keyPointsCount;
  
  public float[] keyPointsScore;
  
  public STPoint[] getContourPoints() {
    return this.contourPoints;
  }
  
  public float[] getContourPointsScore() {
    return this.contourPointsScore;
  }
  
  public STPoint[] getKeyPoints() {
    return this.keyPoints;
  }
  
  public float[] getKeyPointsScore() {
    return this.keyPointsScore;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\sensetime\stmobile\model\STMobileBodyInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */