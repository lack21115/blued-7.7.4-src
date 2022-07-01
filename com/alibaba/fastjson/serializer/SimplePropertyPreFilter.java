package com.alibaba.fastjson.serializer;

import java.util.HashSet;
import java.util.Set;

public class SimplePropertyPreFilter implements PropertyPreFilter {
  private final Class<?> clazz;
  
  private final Set<String> excludes = new HashSet<String>();
  
  private final Set<String> includes = new HashSet<String>();
  
  private int maxLevel;
  
  public SimplePropertyPreFilter(Class<?> paramClass, String... paramVarArgs) {
    int i = 0;
    this.maxLevel = 0;
    this.clazz = paramClass;
    int j = paramVarArgs.length;
    while (i < j) {
      String str = paramVarArgs[i];
      if (str != null)
        this.includes.add(str); 
      i++;
    } 
  }
  
  public SimplePropertyPreFilter(String... paramVarArgs) {
    this(null, paramVarArgs);
  }
  
  public boolean apply(JSONSerializer paramJSONSerializer, Object paramObject, String paramString) {
    if (paramObject == null)
      return true; 
    Class<?> clazz = this.clazz;
    if (clazz != null && !clazz.isInstance(paramObject))
      return true; 
    if (this.excludes.contains(paramString))
      return false; 
    if (this.maxLevel > 0) {
      SerialContext serialContext = paramJSONSerializer.context;
      int i = 0;
      while (serialContext != null) {
        if (++i > this.maxLevel)
          return false; 
        serialContext = serialContext.parent;
      } 
    } 
    return (this.includes.size() != 0) ? (this.includes.contains(paramString)) : true;
  }
  
  public Class<?> getClazz() {
    return this.clazz;
  }
  
  public Set<String> getExcludes() {
    return this.excludes;
  }
  
  public Set<String> getIncludes() {
    return this.includes;
  }
  
  public int getMaxLevel() {
    return this.maxLevel;
  }
  
  public void setMaxLevel(int paramInt) {
    this.maxLevel = paramInt;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\alibaba\fastjson\serializer\SimplePropertyPreFilter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */