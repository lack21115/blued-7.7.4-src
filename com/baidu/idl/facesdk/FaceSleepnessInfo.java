package com.baidu.idl.facesdk;

public class FaceSleepnessInfo {
  public float bluriness;
  
  public float[] headPose;
  
  public float illum;
  
  public int[] landmarks;
  
  public float left_eye_close_prob;
  
  public float left_eye_open_prob;
  
  public float mouth_close_prob;
  
  public float mouth_open_prob;
  
  public float[] occlusions;
  
  public float right_eye_close_prob;
  
  public float right_eye_open_prob;
  
  public FaceSleepnessInfo(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7, float paramFloat8, int[] paramArrayOfint, float[] paramArrayOffloat1, float[] paramArrayOffloat2) {
    this.left_eye_open_prob = paramFloat1;
    this.left_eye_close_prob = paramFloat2;
    this.right_eye_open_prob = paramFloat3;
    this.right_eye_close_prob = paramFloat4;
    this.mouth_open_prob = paramFloat5;
    this.mouth_close_prob = paramFloat6;
    this.bluriness = paramFloat7;
    this.illum = paramFloat8;
    this.landmarks = paramArrayOfint;
    this.headPose = paramArrayOffloat1;
    this.occlusions = paramArrayOffloat2;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\baidu\idl\facesdk\FaceSleepnessInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */