package com.google.gson;

public enum LongSerializationPolicy {
  DEFAULT {
    public JsonElement serialize(Long param1Long) {
      return new JsonPrimitive(param1Long);
    }
  },
  STRING {
    public JsonElement serialize(Long param1Long) {
      return new JsonPrimitive(String.valueOf(param1Long));
    }
  };
  
  static {
    $VALUES = new LongSerializationPolicy[] { DEFAULT, STRING };
  }
  
  public abstract JsonElement serialize(Long paramLong);
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\gson\LongSerializationPolicy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */