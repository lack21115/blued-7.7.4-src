package com.bytedance.embed_device_register;

final class c {
  private static int a;
  
  private static DrLogWriter b;
  
  static {
    a(2);
    a(new DrLogWriter.a());
  }
  
  public static void a(int paramInt) {
    a = paramInt;
  }
  
  public static void a(DrLogWriter paramDrLogWriter) {
    b = paramDrLogWriter;
  }
  
  public static void a(String paramString1, String paramString2) {
    a(paramString1, paramString2, null);
  }
  
  public static void a(String paramString1, String paramString2, Throwable paramThrowable) {
    DrLogWriter drLogWriter = b;
    if (drLogWriter != null && a <= 3)
      drLogWriter.logD(paramString1, paramString2, paramThrowable); 
  }
  
  public static void b(String paramString1, String paramString2, Throwable paramThrowable) {
    DrLogWriter drLogWriter = b;
    if (drLogWriter != null && a <= 6)
      drLogWriter.logE(paramString1, paramString2, paramThrowable); 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\embed_device_register\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */