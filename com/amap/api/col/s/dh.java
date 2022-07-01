package com.amap.api.col.s;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

public final class dh extends dn {
  ByteArrayOutputStream a = new ByteArrayOutputStream();
  
  public dh() {}
  
  public dh(dn paramdn) {
    super(paramdn);
  }
  
  protected final byte[] a(byte[] paramArrayOfbyte) {
    paramArrayOfbyte = this.a.toByteArray();
    try {
      this.a.close();
    } catch (IOException iOException) {
      iOException.printStackTrace();
    } 
    this.a = new ByteArrayOutputStream();
    return paramArrayOfbyte;
  }
  
  public final void b(byte[] paramArrayOfbyte) {
    try {
      return;
    } finally {
      paramArrayOfbyte = null;
      paramArrayOfbyte.printStackTrace();
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\col\s\dh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */