package com.qiniu.android.utils;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

public final class StringMap {
  private Map<String, Object> map;
  
  public StringMap() {
    this(new HashMap<String, Object>());
  }
  
  public StringMap(Map<String, Object> paramMap) {
    this.map = paramMap;
  }
  
  public void forEach(Consumer paramConsumer) {
    for (Map.Entry<String, Object> entry : this.map.entrySet())
      paramConsumer.accept((String)entry.getKey(), entry.getValue()); 
  }
  
  public String formString() {
    final StringBuilder b = new StringBuilder();
    forEach(new Consumer() {
          private boolean notStart = false;
          
          public void accept(String param1String, Object param1Object) {
            if (this.notStart)
              b.append("&"); 
            try {
              StringBuilder stringBuilder = b;
              stringBuilder.append(URLEncoder.encode(param1String, "UTF-8"));
              stringBuilder.append('=');
              stringBuilder.append(URLEncoder.encode(param1Object.toString(), "UTF-8"));
              this.notStart = true;
              return;
            } catch (UnsupportedEncodingException unsupportedEncodingException) {
              throw new AssertionError(unsupportedEncodingException);
            } 
          }
        });
    return stringBuilder.toString();
  }
  
  public Object get(String paramString) {
    return this.map.get(paramString);
  }
  
  public Map<String, Object> map() {
    return this.map;
  }
  
  public StringMap put(String paramString, Object paramObject) {
    this.map.put(paramString, paramObject);
    return this;
  }
  
  public StringMap putAll(StringMap paramStringMap) {
    this.map.putAll(paramStringMap.map);
    return this;
  }
  
  public StringMap putAll(Map<String, Object> paramMap) {
    this.map.putAll(paramMap);
    return this;
  }
  
  public StringMap putFileds(Map<String, String> paramMap) {
    this.map.putAll(paramMap);
    return this;
  }
  
  public StringMap putNotEmpty(String paramString1, String paramString2) {
    if (!StringUtils.isNullOrEmpty(paramString2))
      this.map.put(paramString1, paramString2); 
    return this;
  }
  
  public StringMap putNotNull(String paramString, Object paramObject) {
    if (paramObject != null)
      this.map.put(paramString, paramObject); 
    return this;
  }
  
  public StringMap putWhen(String paramString, Object paramObject, boolean paramBoolean) {
    if (paramBoolean)
      this.map.put(paramString, paramObject); 
    return this;
  }
  
  public int size() {
    return this.map.size();
  }
  
  public static interface Consumer {
    void accept(String param1String, Object param1Object);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\qiniu\androi\\utils\StringMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */