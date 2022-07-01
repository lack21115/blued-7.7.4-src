package com.baidu.idl.facesdk;

public class FaceVerifyData {
  public int cols;
  
  public byte[] mRegDigest;
  
  public int[] mRegImg;
  
  public int[] mRegLdmk;
  
  public int nPoints;
  
  public int rows;
  
  FaceVerifyData() {}
  
  FaceVerifyData(int[] paramArrayOfint1, int[] paramArrayOfint2, byte[] paramArrayOfbyte, int paramInt1, int paramInt2, int paramInt3) {
    this.mRegImg = paramArrayOfint1;
    this.mRegLdmk = paramArrayOfint2;
    this.mRegDigest = paramArrayOfbyte;
    this.rows = paramInt1;
    this.cols = paramInt2;
    this.nPoints = paramInt3;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\baidu\idl\facesdk\FaceVerifyData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */