package com.idlefish.flutterboost.log;

public interface ILog {
  void a(String paramString1, String paramString2);
  
  void a(String paramString1, String paramString2, Throwable paramThrowable);
  
  public enum LogLevelEnum {
    a(0, "V"),
    b(1, "D"),
    c(2, "I"),
    d(3, "W"),
    e(4, "E");
    
    private String f;
    
    private int g;
    
    LogLevelEnum(int param1Int1, String param1String1) {
      this.g = param1Int1;
      this.f = param1String1;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\idlefish\flutterboost\log\ILog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */