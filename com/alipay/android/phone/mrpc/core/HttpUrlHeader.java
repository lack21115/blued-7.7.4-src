package com.alipay.android.phone.mrpc.core;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class HttpUrlHeader implements Serializable {
  private static final long serialVersionUID = -6098125857367743614L;
  
  private Map<String, String> headers = new HashMap<String, String>();
  
  public String getHead(String paramString) {
    return this.headers.get(paramString);
  }
  
  public Map<String, String> getHeaders() {
    return this.headers;
  }
  
  public void setHead(String paramString1, String paramString2) {
    this.headers.put(paramString1, paramString2);
  }
  
  public void setHeaders(Map<String, String> paramMap) {
    this.headers = paramMap;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\alipay\android\phone\mrpc\core\HttpUrlHeader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */