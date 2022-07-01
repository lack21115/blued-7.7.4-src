package com.qq.e.comm.net.rr;

import android.net.Uri;
import com.qq.e.comm.util.StringUtil;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public abstract class AbstractRequest implements Request {
  private boolean a = true;
  
  private int b;
  
  private int c;
  
  private int d;
  
  private String e;
  
  private Map<String, String> f = new HashMap<String, String>();
  
  private Map<String, String> g = new HashMap<String, String>();
  
  private Map<String, String> h = Collections.unmodifiableMap(this.f);
  
  private Map<String, String> i = Collections.unmodifiableMap(this.g);
  
  private Request.Method j;
  
  private byte[] k;
  
  public AbstractRequest(String paramString, Request.Method paramMethod, byte[] paramArrayOfbyte) {
    this.e = paramString;
    this.j = paramMethod;
    if (paramArrayOfbyte == null) {
      this.k = null;
      return;
    } 
    this.k = (byte[])paramArrayOfbyte.clone();
  }
  
  public AbstractRequest(String paramString, Map<String, String> paramMap, Request.Method paramMethod) {
    this.e = paramString;
    this.j = paramMethod;
    if (Request.Method.POST == paramMethod) {
      StringBuilder stringBuilder = new StringBuilder();
      try {
        Iterator<Map.Entry> iterator = paramMap.entrySet().iterator();
        while (true) {
          boolean bool = iterator.hasNext();
          if (bool) {
            Map.Entry entry = iterator.next();
            String str1 = URLEncoder.encode((String)entry.getKey(), "utf-8");
            String str2 = URLEncoder.encode((String)entry.getValue(), "utf-8");
            if (stringBuilder.length() > 0)
              stringBuilder.append("&"); 
            stringBuilder.append(str1);
            stringBuilder.append("=");
            stringBuilder.append(str2);
            continue;
          } 
          if (stringBuilder.length() > 0) {
            this.k = stringBuilder.toString().getBytes("utf-8");
            addHeader("Content-Type", "application/x-www-form-urlencoded");
            return;
          } 
          break;
        } 
      } catch (UnsupportedEncodingException unsupportedEncodingException) {
        throw new IllegalArgumentException(unsupportedEncodingException);
      } 
    } 
  }
  
  public void addHeader(String paramString1, String paramString2) {
    if (!StringUtil.isEmpty(paramString1)) {
      if (StringUtil.isEmpty(paramString2))
        return; 
      this.f.put(paramString1, paramString2);
    } 
  }
  
  public void addQuery(String paramString1, String paramString2) {
    this.g.put(paramString1, paramString2);
  }
  
  public int getConnectionTimeOut() {
    return this.c;
  }
  
  public Map<String, String> getHeaders() {
    return this.h;
  }
  
  public Request.Method getMethod() {
    return this.j;
  }
  
  public byte[] getPostData() throws Exception {
    return this.k;
  }
  
  public int getPriority() {
    return this.b;
  }
  
  public Map<String, String> getQuerys() {
    return this.i;
  }
  
  public int getSocketTimeOut() {
    return this.d;
  }
  
  public String getUrl() {
    return this.e;
  }
  
  public String getUrlWithParas() {
    if (getQuerys().isEmpty())
      return getUrl(); 
    Uri.Builder builder = Uri.parse(getUrl()).buildUpon();
    for (Map.Entry<String, String> entry : getQuerys().entrySet())
      builder.appendQueryParameter((String)entry.getKey(), (String)entry.getValue()); 
    return builder.build().toString();
  }
  
  public boolean isAutoClose() {
    return this.a;
  }
  
  public void setAutoClose(boolean paramBoolean) {
    this.a = paramBoolean;
  }
  
  public void setConnectionTimeOut(int paramInt) {
    this.c = paramInt;
  }
  
  public void setPriority(int paramInt) {
    this.b = paramInt;
  }
  
  public void setSocketTimeOut(int paramInt) {
    this.d = paramInt;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\net\rr\AbstractRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */