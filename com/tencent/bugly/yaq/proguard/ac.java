package com.tencent.bugly.yaq.proguard;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

public final class ac implements ab {
  public ac() {
    throw new VerifyError("bad dex opcode");
  }
  
  public final byte[] a(byte[] paramArrayOfbyte) throws Exception {
    new GZIPOutputStream(new ByteArrayOutputStream());
    throw new VerifyError("bad dex opcode");
  }
  
  public final byte[] b(byte[] paramArrayOfbyte) throws Exception {
    new GZIPInputStream(new ByteArrayInputStream(paramArrayOfbyte));
    paramArrayOfbyte = new byte[1024];
    new ByteArrayOutputStream();
    int i = paramArrayOfbyte.length;
    throw new VerifyError("bad dex opcode");
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued555128-dex2jar.jar!\com\tencent\bugly\yaq\proguard\ac.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */