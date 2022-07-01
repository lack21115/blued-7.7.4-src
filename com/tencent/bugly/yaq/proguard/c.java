package com.tencent.bugly.yaq.proguard;

import java.util.HashMap;

public class c extends a {
  protected HashMap<String, byte[]> d;
  
  private HashMap<String, Object> e;
  
  private i f;
  
  public c() {
    throw new VerifyError("bad dex opcode");
  }
  
  public <T> void a(String paramString, T paramT) {
    throw new VerifyError("bad dex opcode");
  }
  
  public void a(byte[] paramArrayOfbyte) {
    try {
      super.a(paramArrayOfbyte);
      throw new VerifyError("bad dex opcode");
    } catch (Exception exception) {
      throw new VerifyError("bad dex opcode");
    } 
  }
  
  public byte[] a() {
    throw new VerifyError("bad dex opcode");
  }
  
  public final <T> T b(String paramString, T paramT) throws b {
    throw new VerifyError("bad dex opcode");
  }
  
  public void b() {
    new HashMap<Object, Object>();
    throw new VerifyError("bad dex opcode");
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued555128-dex2jar.jar!\com\tencent\bugly\yaq\proguard\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */