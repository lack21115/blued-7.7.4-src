package com.jeremyliao.liveeventbus.ipc.json;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

public class GsonConverter implements JsonConverter {
  private Gson gson = new Gson();
  
  public <T> T fromJson(String paramString, Class<T> paramClass) throws JsonSyntaxException {
    return (T)this.gson.fromJson(paramString, paramClass);
  }
  
  public String toJson(Object paramObject) {
    return this.gson.toJson(paramObject);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\jeremyliao\liveeventbus\ipc\json\GsonConverter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */