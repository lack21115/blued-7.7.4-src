package com.sensetime.stmobile.model;

public class STStickerInputParams {
  float[] cameraQuaternion;
  
  int customEvent;
  
  boolean isFrontCamera;
  
  int quaternionLength;
  
  public STStickerInputParams(float[] paramArrayOffloat, boolean paramBoolean, int paramInt) {
    if (paramArrayOffloat != null) {
      this.cameraQuaternion = paramArrayOffloat;
      this.quaternionLength = paramArrayOffloat.length;
    } else {
      this.cameraQuaternion = null;
      this.quaternionLength = 0;
    } 
    this.isFrontCamera = paramBoolean;
    this.customEvent = paramInt;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\sensetime\stmobile\model\STStickerInputParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */