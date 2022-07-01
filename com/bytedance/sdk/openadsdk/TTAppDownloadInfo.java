package com.bytedance.sdk.openadsdk;

public class TTAppDownloadInfo {
  private long a;
  
  private int b;
  
  private long c;
  
  private long d;
  
  private String e;
  
  private String f;
  
  public String getAppName() {
    return this.f;
  }
  
  public long getCurrBytes() {
    return this.d;
  }
  
  public String getFileName() {
    return this.e;
  }
  
  public long getId() {
    return this.a;
  }
  
  public int getInternalStatusKey() {
    return this.b;
  }
  
  public long getTotalBytes() {
    return this.c;
  }
  
  public void setAppName(String paramString) {
    this.f = paramString;
  }
  
  public void setCurrBytes(long paramLong) {
    this.d = paramLong;
  }
  
  public void setFileName(String paramString) {
    this.e = paramString;
  }
  
  public void setId(long paramLong) {
    this.a = paramLong;
  }
  
  public void setInternalStatusKey(int paramInt) {
    this.b = paramInt;
  }
  
  public void setTotalBytes(long paramLong) {
    this.c = paramLong;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\openadsdk\TTAppDownloadInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */