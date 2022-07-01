package com.alibaba.fastjson.serializer;

public interface PropertyPreFilter extends SerializeFilter {
  boolean apply(JSONSerializer paramJSONSerializer, Object paramObject, String paramString);
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\alibaba\fastjson\serializer\PropertyPreFilter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */