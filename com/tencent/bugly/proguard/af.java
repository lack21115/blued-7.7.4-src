package com.tencent.bugly.proguard;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

public final class af implements ae {
  public final byte[] a(byte[] paramArrayOfbyte) throws Exception {
    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
    GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
    gZIPOutputStream.write(paramArrayOfbyte);
    gZIPOutputStream.finish();
    gZIPOutputStream.close();
    paramArrayOfbyte = byteArrayOutputStream.toByteArray();
    byteArrayOutputStream.close();
    return paramArrayOfbyte;
  }
  
  public final byte[] b(byte[] paramArrayOfbyte) throws Exception {
    ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(paramArrayOfbyte);
    GZIPInputStream gZIPInputStream = new GZIPInputStream(byteArrayInputStream);
    byte[] arrayOfByte = new byte[1024];
    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
    while (true) {
      int i = gZIPInputStream.read(arrayOfByte, 0, arrayOfByte.length);
      if (i != -1) {
        byteArrayOutputStream.write(arrayOfByte, 0, i);
        continue;
      } 
      arrayOfByte = byteArrayOutputStream.toByteArray();
      byteArrayOutputStream.flush();
      byteArrayOutputStream.close();
      gZIPInputStream.close();
      byteArrayInputStream.close();
      return arrayOfByte;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\tencent\bugly\proguard\af.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */