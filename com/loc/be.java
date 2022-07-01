package com.loc;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

public final class be extends bk {
  ByteArrayOutputStream a = new ByteArrayOutputStream();
  
  public be() {}
  
  public be(bk parambk) {
    super(parambk);
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


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\loc\be.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */