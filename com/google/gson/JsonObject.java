package com.google.gson;

import com.google.gson.internal.LinkedTreeMap;
import java.util.Map;
import java.util.Set;

public final class JsonObject extends JsonElement {
  private final LinkedTreeMap<String, JsonElement> members = new LinkedTreeMap();
  
  public void add(String paramString, JsonElement paramJsonElement) {
    LinkedTreeMap<String, JsonElement> linkedTreeMap = this.members;
    JsonElement jsonElement = paramJsonElement;
    if (paramJsonElement == null)
      jsonElement = JsonNull.INSTANCE; 
    linkedTreeMap.put(paramString, jsonElement);
  }
  
  public void addProperty(String paramString, Boolean paramBoolean) {
    JsonNull jsonNull;
    JsonPrimitive jsonPrimitive;
    if (paramBoolean == null) {
      jsonNull = JsonNull.INSTANCE;
    } else {
      jsonPrimitive = new JsonPrimitive((Boolean)jsonNull);
    } 
    add(paramString, jsonPrimitive);
  }
  
  public void addProperty(String paramString, Character paramCharacter) {
    JsonNull jsonNull;
    JsonPrimitive jsonPrimitive;
    if (paramCharacter == null) {
      jsonNull = JsonNull.INSTANCE;
    } else {
      jsonPrimitive = new JsonPrimitive((Character)jsonNull);
    } 
    add(paramString, jsonPrimitive);
  }
  
  public void addProperty(String paramString, Number paramNumber) {
    JsonNull jsonNull;
    JsonPrimitive jsonPrimitive;
    if (paramNumber == null) {
      jsonNull = JsonNull.INSTANCE;
    } else {
      jsonPrimitive = new JsonPrimitive((Number)jsonNull);
    } 
    add(paramString, jsonPrimitive);
  }
  
  public void addProperty(String paramString1, String paramString2) {
    JsonNull jsonNull;
    JsonPrimitive jsonPrimitive;
    if (paramString2 == null) {
      jsonNull = JsonNull.INSTANCE;
    } else {
      jsonPrimitive = new JsonPrimitive((String)jsonNull);
    } 
    add(paramString1, jsonPrimitive);
  }
  
  public JsonObject deepCopy() {
    JsonObject jsonObject = new JsonObject();
    for (Map.Entry entry : this.members.entrySet())
      jsonObject.add((String)entry.getKey(), ((JsonElement)entry.getValue()).deepCopy()); 
    return jsonObject;
  }
  
  public Set<Map.Entry<String, JsonElement>> entrySet() {
    return this.members.entrySet();
  }
  
  public boolean equals(Object paramObject) {
    return (paramObject == this || (paramObject instanceof JsonObject && ((JsonObject)paramObject).members.equals(this.members)));
  }
  
  public JsonElement get(String paramString) {
    return (JsonElement)this.members.get(paramString);
  }
  
  public JsonArray getAsJsonArray(String paramString) {
    return (JsonArray)this.members.get(paramString);
  }
  
  public JsonObject getAsJsonObject(String paramString) {
    return (JsonObject)this.members.get(paramString);
  }
  
  public JsonPrimitive getAsJsonPrimitive(String paramString) {
    return (JsonPrimitive)this.members.get(paramString);
  }
  
  public boolean has(String paramString) {
    return this.members.containsKey(paramString);
  }
  
  public int hashCode() {
    return this.members.hashCode();
  }
  
  public Set<String> keySet() {
    return this.members.keySet();
  }
  
  public JsonElement remove(String paramString) {
    return (JsonElement)this.members.remove(paramString);
  }
  
  public int size() {
    return this.members.size();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\gson\JsonObject.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */