package com.google.protobuf;

public enum JavaType {
  BOOLEAN,
  BYTE_STRING,
  DOUBLE,
  ENUM,
  FLOAT,
  INT,
  LONG,
  MESSAGE,
  STRING,
  VOID(Void.class, Void.class, null);
  
  private final Class<?> boxedType;
  
  private final Object defaultDefault;
  
  private final Class<?> type;
  
  static {
    INT = new JavaType("INT", 1, int.class, Integer.class, Integer.valueOf(0));
    LONG = new JavaType("LONG", 2, long.class, Long.class, Long.valueOf(0L));
    FLOAT = new JavaType("FLOAT", 3, float.class, Float.class, Float.valueOf(0.0F));
    DOUBLE = new JavaType("DOUBLE", 4, double.class, Double.class, Double.valueOf(0.0D));
    BOOLEAN = new JavaType("BOOLEAN", 5, boolean.class, Boolean.class, Boolean.valueOf(false));
    STRING = new JavaType("STRING", 6, String.class, String.class, "");
    BYTE_STRING = new JavaType("BYTE_STRING", 7, ByteString.class, ByteString.class, ByteString.EMPTY);
    ENUM = new JavaType("ENUM", 8, int.class, Integer.class, null);
    MESSAGE = new JavaType("MESSAGE", 9, Object.class, Object.class, null);
    $VALUES = new JavaType[] { VOID, INT, LONG, FLOAT, DOUBLE, BOOLEAN, STRING, BYTE_STRING, ENUM, MESSAGE };
  }
  
  JavaType(Class<?> paramClass1, Class<?> paramClass2, Object paramObject) {
    this.type = paramClass1;
    this.boxedType = paramClass2;
    this.defaultDefault = paramObject;
  }
  
  public Class<?> getBoxedType() {
    return this.boxedType;
  }
  
  public Object getDefaultDefault() {
    return this.defaultDefault;
  }
  
  public Class<?> getType() {
    return this.type;
  }
  
  public boolean isValidType(Class<?> paramClass) {
    return this.type.isAssignableFrom(paramClass);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\protobuf\JavaType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */