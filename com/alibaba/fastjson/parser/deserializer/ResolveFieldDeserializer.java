package com.alibaba.fastjson.parser.deserializer;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.util.TypeUtils;
import java.lang.reflect.Array;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.List;
import java.util.Map;

public final class ResolveFieldDeserializer extends FieldDeserializer {
  private final Collection collection;
  
  private final int index;
  
  private final Object key;
  
  private final List list;
  
  private final Map map;
  
  private final DefaultJSONParser parser;
  
  public ResolveFieldDeserializer(DefaultJSONParser paramDefaultJSONParser, List paramList, int paramInt) {
    super(null, null);
    this.parser = paramDefaultJSONParser;
    this.index = paramInt;
    this.list = paramList;
    this.key = null;
    this.map = null;
    this.collection = null;
  }
  
  public ResolveFieldDeserializer(Collection paramCollection) {
    super(null, null);
    this.parser = null;
    this.index = -1;
    this.list = null;
    this.key = null;
    this.map = null;
    this.collection = paramCollection;
  }
  
  public ResolveFieldDeserializer(Map paramMap, Object paramObject) {
    super(null, null);
    this.parser = null;
    this.index = -1;
    this.list = null;
    this.key = paramObject;
    this.map = paramMap;
    this.collection = null;
  }
  
  public void parseField(DefaultJSONParser paramDefaultJSONParser, Object paramObject, Type paramType, Map<String, Object> paramMap) {}
  
  public void setValue(Object paramObject1, Object paramObject2) {
    paramObject1 = this.map;
    if (paramObject1 != null) {
      paramObject1.put(this.key, paramObject2);
      return;
    } 
    paramObject1 = this.collection;
    if (paramObject1 != null) {
      paramObject1.add(paramObject2);
      return;
    } 
    this.list.set(this.index, paramObject2);
    paramObject1 = this.list;
    if (paramObject1 instanceof JSONArray) {
      JSONArray jSONArray = (JSONArray)paramObject1;
      Object object = jSONArray.getRelatedArray();
      if (object != null && Array.getLength(object) > this.index) {
        paramObject1 = paramObject2;
        if (jSONArray.getComponentType() != null)
          paramObject1 = TypeUtils.cast(paramObject2, jSONArray.getComponentType(), this.parser.getConfig()); 
        Array.set(object, this.index, paramObject1);
      } 
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\alibaba\fastjson\parser\deserializer\ResolveFieldDeserializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */