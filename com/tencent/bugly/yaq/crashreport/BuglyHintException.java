package com.tencent.bugly.yaq.crashreport;

public class BuglyHintException extends RuntimeException {
  public BuglyHintException(String paramString) {
    super(paramString);
    throw new VerifyError("bad dex opcode");
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued555128-dex2jar.jar!\com\tencent\bugly\yaq\crashreport\BuglyHintException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */