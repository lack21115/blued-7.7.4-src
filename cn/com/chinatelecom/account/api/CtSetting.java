package cn.com.chinatelecom.account.api;

public class CtSetting {
  private static final int DEFAULT_CONN_TIMEOUT = 3000;
  
  private static final int DEFAULT_READ_TIMEOUT = 3000;
  
  private static final int DEFAULT_TOTAL_TIMEOUT = 10000;
  
  private int connTimeout = 0;
  
  private int readTimeout = 0;
  
  private int totalTimeout = 0;
  
  public CtSetting() {}
  
  public CtSetting(int paramInt1, int paramInt2, int paramInt3) {
    this.connTimeout = paramInt1;
    this.readTimeout = paramInt2;
    this.totalTimeout = paramInt3;
  }
  
  public static int getConnTimeout(CtSetting paramCtSetting) {
    if (paramCtSetting != null) {
      int i = paramCtSetting.connTimeout;
      if (i > 0)
        return i; 
    } 
    return 3000;
  }
  
  public static int getReadTimeout(CtSetting paramCtSetting) {
    if (paramCtSetting != null) {
      int i = paramCtSetting.readTimeout;
      if (i > 0)
        return i; 
    } 
    return 3000;
  }
  
  public static int getTotalTimeout(CtSetting paramCtSetting) {
    if (paramCtSetting != null) {
      int i = paramCtSetting.totalTimeout;
      if (i > 0)
        return i; 
    } 
    return 10000;
  }
  
  public void setConnTimeout(int paramInt) {
    this.connTimeout = paramInt;
  }
  
  public void setReadTimeout(int paramInt) {
    this.readTimeout = paramInt;
  }
  
  public void setTotalTimeout(int paramInt) {
    this.totalTimeout = paramInt;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\cn\com\chinatelecom\account\api\CtSetting.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */