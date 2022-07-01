package com.tencent.bugly.yaq.proguard;

public class b extends RuntimeException {
  public b(Exception paramException) {
    super(paramException);
    throw new VerifyError("bad dex opcode");
  }
  
  public b(String paramString) {
    super(paramString);
    throw new VerifyError("bad dex opcode");
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued555128-dex2jar.jar!\com\tencent\bugly\yaq\proguard\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */