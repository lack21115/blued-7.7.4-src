package com.tencent.bugly.yaq.proguard;

import java.util.HashMap;

public final class d extends c {
  private static HashMap<String, byte[]> f = null;
  
  private static HashMap<String, HashMap<String, byte[]>> g = null;
  
  private f e;
  
  static {
    throw new VerifyError("bad dex opcode");
  }
  
  public d() {
    new f();
    throw new VerifyError("bad dex opcode");
  }
  
  public final <T> void a(String paramString, T paramT) {
    throw new VerifyError("bad dex opcode");
  }
  
  public final void a(byte[] paramArrayOfbyte) {
    if (paramArrayOfbyte.length < 4)
      throw new IllegalArgumentException("decode package must include size head"); 
    try {
      new i(paramArrayOfbyte, 4);
      throw new VerifyError("bad dex opcode");
    } catch (Exception exception) {
      throw new RuntimeException(exception);
    } 
  }
  
  public final byte[] a() {
    throw new VerifyError("bad dex opcode");
  }
  
  public final void b() {
    super.b();
    throw new VerifyError("bad dex opcode");
  }
  
  public final void b(int paramInt) {
    throw new VerifyError("bad dex opcode");
  }
  
  public final void b(String paramString) {
    throw new VerifyError("bad dex opcode");
  }
  
  public final void c(String paramString) {
    throw new VerifyError("bad dex opcode");
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued555128-dex2jar.jar!\com\tencent\bugly\yaq\proguard\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */