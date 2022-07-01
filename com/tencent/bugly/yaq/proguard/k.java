package com.tencent.bugly.yaq.proguard;

import java.io.Serializable;

public abstract class k implements Serializable {
  public k() {
    throw new VerifyError("bad dex opcode");
  }
  
  public abstract void a(i parami);
  
  public abstract void a(j paramj);
  
  public abstract void a(StringBuilder paramStringBuilder, int paramInt);
  
  public String toString() {
    new StringBuilder();
    throw new VerifyError("bad dex opcode");
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued555128-dex2jar.jar!\com\tencent\bugly\yaq\proguard\k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */