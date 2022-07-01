package com.huawei.hms.framework.common.hianalytics;

import java.util.LinkedHashMap;

public class LinkedHashMapPack {
  private LinkedHashMap<String, String> map = new LinkedHashMap<String, String>();
  
  public LinkedHashMap<String, String> getAll() {
    return this.map;
  }
  
  public LinkedHashMapPack put(String paramString, long paramLong) {
    if (paramString != null) {
      LinkedHashMap<String, String> linkedHashMap = this.map;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("");
      stringBuilder.append(paramLong);
      linkedHashMap.put(paramString, stringBuilder.toString());
    } 
    return this;
  }
  
  public LinkedHashMapPack put(String paramString1, String paramString2) {
    if (paramString1 != null && paramString2 != null)
      this.map.put(paramString1, paramString2); 
    return this;
  }
  
  public LinkedHashMapPack put(String paramString, boolean paramBoolean) {
    if (paramString != null) {
      String str;
      LinkedHashMap<String, String> linkedHashMap;
      if (paramBoolean) {
        linkedHashMap = this.map;
        str = "1";
      } else {
        linkedHashMap = this.map;
        str = "0";
      } 
      linkedHashMap.put(paramString, str);
    } 
    return this;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\hms\framework\common\hianalytics\LinkedHashMapPack.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */