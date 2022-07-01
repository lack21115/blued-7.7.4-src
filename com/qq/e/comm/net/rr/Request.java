package com.qq.e.comm.net.rr;

import java.net.HttpURLConnection;
import java.util.Map;

public interface Request {
  void addHeader(String paramString1, String paramString2);
  
  void addQuery(String paramString1, String paramString2);
  
  int getConnectionTimeOut();
  
  Map<String, String> getHeaders();
  
  Method getMethod();
  
  byte[] getPostData() throws Exception;
  
  int getPriority();
  
  Map<String, String> getQuerys();
  
  int getSocketTimeOut();
  
  String getUrl();
  
  String getUrlWithParas();
  
  Response initResponse(HttpURLConnection paramHttpURLConnection);
  
  boolean isAutoClose();
  
  void setConnectionTimeOut(int paramInt);
  
  void setSocketTimeOut(int paramInt);
  
  public enum Method {
    GET, POST;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\net\rr\Request.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */