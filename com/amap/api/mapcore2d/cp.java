package com.amap.api.mapcore2d;

public class cp extends Exception {
  private String a = "未知的错误";
  
  private String b = "";
  
  private String c = "1900";
  
  private String d = "UnknownError";
  
  private int e = -1;
  
  public cp(String paramString) {
    super(paramString);
    this.a = paramString;
    a(paramString);
  }
  
  public cp(String paramString1, String paramString2) {
    this(paramString1);
    this.b = paramString2;
  }
  
  private void a(String paramString) {
    if ("IO 操作异常 - IOException".equals(paramString)) {
      this.e = 21;
      this.c = "1902";
      this.d = "IOException";
      return;
    } 
    if ("socket 连接异常 - SocketException".equals(paramString)) {
      this.e = 22;
      return;
    } 
    if ("socket 连接超时 - SocketTimeoutException".equals(paramString)) {
      this.e = 23;
      this.c = "1802";
      this.d = "SocketTimeoutException";
      return;
    } 
    if ("无效的参数 - IllegalArgumentException".equals(paramString)) {
      this.e = 24;
      this.c = "1901";
      this.d = "IllegalArgumentException";
      return;
    } 
    if ("空指针异常 - NullPointException".equals(paramString)) {
      this.e = 25;
      this.c = "1903";
      this.d = "NullPointException";
      return;
    } 
    if ("url异常 - MalformedURLException".equals(paramString)) {
      this.e = 26;
      this.c = "1803";
      this.d = "MalformedURLException";
      return;
    } 
    if ("未知主机 - UnKnowHostException".equals(paramString)) {
      this.e = 27;
      this.c = "1804";
      this.d = "UnknownHostException";
      return;
    } 
    if ("服务器连接失败 - UnknownServiceException".equals(paramString)) {
      this.e = 28;
      this.c = "1805";
      this.d = "CannotConnectToHostException";
      return;
    } 
    if ("协议解析错误 - ProtocolException".equals(paramString)) {
      this.e = 29;
      this.c = "1801";
      this.d = "ProtocolException";
      return;
    } 
    if ("http连接失败 - ConnectionException".equals(paramString)) {
      this.e = 30;
      this.c = "1806";
      this.d = "ConnectionException";
      return;
    } 
    if ("未知的错误".equals(paramString)) {
      this.e = 31;
      return;
    } 
    if ("key鉴权失败".equals(paramString)) {
      this.e = 32;
      return;
    } 
    if ("requeust is null".equals(paramString)) {
      this.e = 1;
      return;
    } 
    if ("request url is empty".equals(paramString)) {
      this.e = 2;
      return;
    } 
    if ("response is null".equals(paramString)) {
      this.e = 3;
      return;
    } 
    if ("thread pool has exception".equals(paramString)) {
      this.e = 4;
      return;
    } 
    if ("sdk name is invalid".equals(paramString)) {
      this.e = 5;
      return;
    } 
    if ("sdk info is null".equals(paramString)) {
      this.e = 6;
      return;
    } 
    if ("sdk packages is null".equals(paramString)) {
      this.e = 7;
      return;
    } 
    if ("线程池为空".equals(paramString)) {
      this.e = 8;
      return;
    } 
    if ("获取对象错误".equals(paramString)) {
      this.e = 101;
      return;
    } 
    this.e = -1;
  }
  
  public String a() {
    return this.a;
  }
  
  public void a(int paramInt) {
    this.e = paramInt;
  }
  
  public String b() {
    return this.c;
  }
  
  public String c() {
    return this.d;
  }
  
  public String d() {
    return this.b;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\mapcore2d\cp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */