package com.sina.weibo.sdk.net;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.sina.weibo.sdk.utils.LogUtil;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Set;

public class WeiboParameters {
  private static final String DEFAULT_CHARSET = "UTF-8";
  
  private String mAppKey;
  
  private LinkedHashMap<String, Object> mParams = new LinkedHashMap<String, Object>();
  
  public WeiboParameters(String paramString) {
    this.mAppKey = paramString;
  }
  
  @Deprecated
  public void add(String paramString, int paramInt) {
    this.mParams.put(paramString, String.valueOf(paramInt));
  }
  
  @Deprecated
  public void add(String paramString, long paramLong) {
    this.mParams.put(paramString, String.valueOf(paramLong));
  }
  
  @Deprecated
  public void add(String paramString, Object paramObject) {
    this.mParams.put(paramString, paramObject.toString());
  }
  
  @Deprecated
  public void add(String paramString1, String paramString2) {
    this.mParams.put(paramString1, paramString2);
  }
  
  public boolean containsKey(String paramString) {
    return this.mParams.containsKey(paramString);
  }
  
  public boolean containsValue(String paramString) {
    return this.mParams.containsValue(paramString);
  }
  
  public String encodeUrl() {
    StringBuilder stringBuilder = new StringBuilder();
    Iterator<String> iterator = this.mParams.keySet().iterator();
    boolean bool = true;
    while (true) {
      boolean bool1;
      if (!iterator.hasNext())
        return stringBuilder.toString(); 
      String str = iterator.next();
      if (bool) {
        bool1 = false;
      } else {
        stringBuilder.append("&");
        bool1 = bool;
      } 
      Object object = this.mParams.get(str);
      bool = bool1;
      if (object instanceof String) {
        object = object;
        if (!TextUtils.isEmpty((CharSequence)object))
          try {
            StringBuilder stringBuilder1 = new StringBuilder(String.valueOf(URLEncoder.encode(str, "UTF-8")));
            stringBuilder1.append("=");
            stringBuilder1.append(URLEncoder.encode((String)object, "UTF-8"));
            stringBuilder.append(stringBuilder1.toString());
          } catch (UnsupportedEncodingException unsupportedEncodingException) {
            unsupportedEncodingException.printStackTrace();
          }  
        LogUtil.i("encodeUrl", stringBuilder.toString());
        bool = bool1;
      } 
    } 
  }
  
  public Object get(String paramString) {
    return this.mParams.get(paramString);
  }
  
  public String getAppKey() {
    return this.mAppKey;
  }
  
  public LinkedHashMap<String, Object> getParams() {
    return this.mParams;
  }
  
  public boolean hasBinaryData() {
    String str;
    Iterator<String> iterator = this.mParams.keySet().iterator();
    do {
      if (!iterator.hasNext())
        return false; 
      str = iterator.next();
      str = (String)this.mParams.get(str);
    } while (!(str instanceof java.io.ByteArrayOutputStream) && !(str instanceof Bitmap));
    return true;
  }
  
  public Set<String> keySet() {
    return this.mParams.keySet();
  }
  
  public void put(String paramString, int paramInt) {
    this.mParams.put(paramString, String.valueOf(paramInt));
  }
  
  public void put(String paramString, long paramLong) {
    this.mParams.put(paramString, String.valueOf(paramLong));
  }
  
  public void put(String paramString, Bitmap paramBitmap) {
    this.mParams.put(paramString, paramBitmap);
  }
  
  public void put(String paramString, Object paramObject) {
    this.mParams.put(paramString, paramObject.toString());
  }
  
  public void put(String paramString1, String paramString2) {
    this.mParams.put(paramString1, paramString2);
  }
  
  public void remove(String paramString) {
    if (this.mParams.containsKey(paramString)) {
      this.mParams.remove(paramString);
      LinkedHashMap<String, Object> linkedHashMap = this.mParams;
      linkedHashMap.remove(linkedHashMap.get(paramString));
    } 
  }
  
  public void setParams(LinkedHashMap<String, Object> paramLinkedHashMap) {
    this.mParams = paramLinkedHashMap;
  }
  
  public int size() {
    return this.mParams.size();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\sina\weibo\sdk\net\WeiboParameters.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */