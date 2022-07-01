package com.jeremyliao.liveeventbus.ipc.json;

public interface JsonConverter {
  <T> T fromJson(String paramString, Class<T> paramClass);
  
  String toJson(Object paramObject);
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\jeremyliao\liveeventbus\ipc\json\JsonConverter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */