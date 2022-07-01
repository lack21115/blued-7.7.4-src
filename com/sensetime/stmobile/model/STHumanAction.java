package com.sensetime.stmobile.model;

public class STHumanAction {
  public float backGroundScore;
  
  public int bodyCount;
  
  public STMobileBodyInfo[] bodys;
  
  public int bufIndex;
  
  public int faceCount;
  
  public STMobileFaceInfo[] faces;
  
  public STImage hair;
  
  public float hairScore;
  
  public int handCount;
  
  public STMobileHandInfo[] hands;
  
  public STImage image;
  
  public STImage multiSegment;
  
  public float multiSegmentScore;
  
  public static native STHumanAction humanActionMirror(int paramInt, STHumanAction paramSTHumanAction);
  
  public static native STHumanAction humanActionResize(float paramFloat, STHumanAction paramSTHumanAction);
  
  public static native STHumanAction humanActionRotate(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean, STHumanAction paramSTHumanAction);
  
  public static STHumanAction humanActionRotateAndMirror(STHumanAction paramSTHumanAction, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    if (paramSTHumanAction == null)
      return null; 
    if (paramInt3 != 1 && paramInt3 != 0)
      return paramSTHumanAction; 
    if (paramInt4 != 0) {
      if (paramInt4 != 90) {
        if (paramInt4 != 180) {
          if (paramInt4 != 270)
            return paramSTHumanAction; 
          paramSTHumanAction = humanActionRotate(paramInt2, paramInt1, 3, false, paramSTHumanAction);
        } else {
          paramSTHumanAction = humanActionRotate(paramInt2, paramInt1, 3, false, paramSTHumanAction);
        } 
      } else {
        paramSTHumanAction = humanActionRotate(paramInt2, paramInt1, 1, false, paramSTHumanAction);
      } 
    } else {
      paramSTHumanAction = humanActionRotate(paramInt2, paramInt1, 3, false, paramSTHumanAction);
    } 
    STHumanAction sTHumanAction = paramSTHumanAction;
    if (paramInt3 == 1)
      sTHumanAction = humanActionMirror(paramInt1, paramSTHumanAction); 
    return sTHumanAction;
  }
  
  public STMobileFaceInfo[] getFaceInfos() {
    return (this.faceCount == 0) ? null : this.faces;
  }
  
  public STImage getHair() {
    return this.hair;
  }
  
  public STMobileHandInfo[] getHandInfos() {
    return (this.handCount == 0) ? null : this.hands;
  }
  
  public STImage getImage() {
    return this.image;
  }
  
  public STMobile106[] getMobileFaces() {
    int i = this.faceCount;
    if (i == 0)
      return null; 
    STMobile106[] arrayOfSTMobile106 = new STMobile106[i];
    for (i = 0; i < this.faceCount; i++)
      arrayOfSTMobile106[i] = (this.faces[i]).face106; 
    return arrayOfSTMobile106;
  }
  
  public boolean replaceMobile106(STMobile106[] paramArrayOfSTMobile106) {
    int i = 0;
    if (paramArrayOfSTMobile106 != null && paramArrayOfSTMobile106.length != 0 && this.faces != null) {
      if (this.faceCount != paramArrayOfSTMobile106.length)
        return false; 
      while (i < paramArrayOfSTMobile106.length) {
        (this.faces[i]).face106 = paramArrayOfSTMobile106[i];
        i++;
      } 
      return true;
    } 
    return false;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\sensetime\stmobile\model\STHumanAction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */