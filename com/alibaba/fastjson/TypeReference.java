package com.alibaba.fastjson;

import com.alibaba.fastjson.util.ParameterizedTypeImpl;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

public class TypeReference<T> {
  public static final Type LIST_STRING = (new TypeReference<List<String>>() {
    
    }).getType();
  
  protected final Type type;
  
  protected TypeReference() {
    this.type = ((ParameterizedType)getClass().getGenericSuperclass()).getActualTypeArguments()[0];
  }
  
  protected TypeReference(Type... paramVarArgs) {
    Type[] arrayOfType1 = ((ParameterizedType)getClass().getGenericSuperclass()).getActualTypeArguments();
    int i = 0;
    ParameterizedType parameterizedType = (ParameterizedType)arrayOfType1[0];
    Type type = parameterizedType.getRawType();
    Type[] arrayOfType2 = parameterizedType.getActualTypeArguments();
    for (int j = 0; i < arrayOfType2.length; j = k) {
      int k = j;
      if (arrayOfType2[i] instanceof java.lang.reflect.TypeVariable) {
        k = j + 1;
        arrayOfType2[i] = paramVarArgs[j];
        if (k >= paramVarArgs.length)
          break; 
      } 
      i++;
    } 
    this.type = (Type)new ParameterizedTypeImpl(arrayOfType2, getClass(), type);
  }
  
  public Type getType() {
    return this.type;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\alibaba\fastjson\TypeReference.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */