package com.alibaba.fastjson.serializer;

public class PascalNameFilter implements NameFilter {
  public String process(Object paramObject1, String paramString, Object paramObject2) {
    paramObject1 = paramString;
    if (paramString != null) {
      if (paramString.length() == 0)
        return paramString; 
      paramObject1 = paramString.toCharArray();
      paramObject1[0] = Character.toUpperCase(paramObject1[0]);
      paramObject1 = new String((char[])paramObject1);
    } 
    return (String)paramObject1;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\alibaba\fastjson\serializer\PascalNameFilter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */