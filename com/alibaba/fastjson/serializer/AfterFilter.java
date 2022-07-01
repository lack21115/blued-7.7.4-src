package com.alibaba.fastjson.serializer;

public abstract class AfterFilter implements SerializeFilter {
  private static final Character COMMA;
  
  private static final ThreadLocal<Character> seperatorLocal;
  
  private static final ThreadLocal<JSONSerializer> serializerLocal = new ThreadLocal<JSONSerializer>();
  
  static {
    seperatorLocal = new ThreadLocal<Character>();
    COMMA = Character.valueOf(',');
  }
  
  final char writeAfter(JSONSerializer paramJSONSerializer, Object paramObject, char paramChar) {
    serializerLocal.set(paramJSONSerializer);
    seperatorLocal.set(Character.valueOf(paramChar));
    writeAfter(paramObject);
    serializerLocal.set(null);
    return ((Character)seperatorLocal.get()).charValue();
  }
  
  public abstract void writeAfter(Object paramObject);
  
  protected final void writeKeyValue(String paramString, Object paramObject) {
    JSONSerializer jSONSerializer = serializerLocal.get();
    char c = ((Character)seperatorLocal.get()).charValue();
    jSONSerializer.writeKeyValue(c, paramString, paramObject);
    if (c != ',')
      seperatorLocal.set(COMMA); 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\alibaba\fastjson\serializer\AfterFilter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */