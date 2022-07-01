package com.amap.api.mapcore2d;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class fi extends fo {
  ByteArrayOutputStream a = new ByteArrayOutputStream();
  
  public fi() {}
  
  public fi(fo paramfo) {
    super(paramfo);
  }
  
  protected byte[] a(byte[] paramArrayOfbyte) {
    paramArrayOfbyte = this.a.toByteArray();
    try {
      this.a.close();
    } catch (IOException iOException) {
      iOException.printStackTrace();
    } 
    this.a = new ByteArrayOutputStream();
    return paramArrayOfbyte;
  }
  
  public void b(byte[] paramArrayOfbyte) {
    try {
      return;
    } finally {
      paramArrayOfbyte = null;
      paramArrayOfbyte.printStackTrace();
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\mapcore2d\fi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */