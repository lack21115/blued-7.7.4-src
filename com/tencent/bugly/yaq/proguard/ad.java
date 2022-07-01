package com.tencent.bugly.yaq.proguard;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

public final class ad implements ab {
  public ad() {
    throw new VerifyError("bad dex opcode");
  }
  
  public final byte[] a(byte[] paramArrayOfbyte) throws Exception {
    new ZipOutputStream(new ByteArrayOutputStream());
    new ZipEntry("zip");
    long l = paramArrayOfbyte.length;
    throw new VerifyError("bad dex opcode");
  }
  
  public final byte[] b(byte[] paramArrayOfbyte) throws Exception {
    new ZipInputStream(new ByteArrayInputStream(paramArrayOfbyte));
    throw new VerifyError("bad dex opcode");
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued555128-dex2jar.jar!\com\tencent\bugly\yaq\proguard\ad.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */