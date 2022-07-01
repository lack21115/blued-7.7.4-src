package com.huawei.hianalytics.ab.bc.kl;

public class ab {
  private byte[] ab = null;
  
  private int bc = 0;
  
  public ab(int paramInt) {
    this.ab = new byte[paramInt];
  }
  
  public void ab(byte[] paramArrayOfbyte, int paramInt) {
    if (paramInt <= 0)
      return; 
    byte[] arrayOfByte = this.ab;
    int i = arrayOfByte.length;
    int j = this.bc;
    if (i - j >= paramInt) {
      System.arraycopy(paramArrayOfbyte, 0, arrayOfByte, j, paramInt);
    } else {
      byte[] arrayOfByte1 = new byte[arrayOfByte.length + paramInt << 1];
      System.arraycopy(arrayOfByte, 0, arrayOfByte1, 0, j);
      System.arraycopy(paramArrayOfbyte, 0, arrayOfByte1, this.bc, paramInt);
      this.ab = arrayOfByte1;
    } 
    this.bc += paramInt;
  }
  
  public byte[] ab() {
    int i = this.bc;
    if (i <= 0)
      return new byte[0]; 
    byte[] arrayOfByte = new byte[i];
    System.arraycopy(this.ab, 0, arrayOfByte, 0, i);
    return arrayOfByte;
  }
  
  public int bc() {
    return this.bc;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\hianalytics\ab\bc\kl\ab.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */