package cn.com.chinatelecom.account.api;

public interface TraceLogger {
  void debug(String paramString1, String paramString2);
  
  void info(String paramString1, String paramString2);
  
  void warn(String paramString1, String paramString2, Throwable paramThrowable);
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\cn\com\chinatelecom\account\api\TraceLogger.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */