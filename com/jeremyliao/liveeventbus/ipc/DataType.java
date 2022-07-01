package com.jeremyliao.liveeventbus.ipc;

public enum DataType {
  BOOLEAN, BUNDLE, DOUBLE, FLOAT, INTEGER, JSON, LONG, PARCELABLE, SERIALIZABLE, STRING, UNKNOWN;
  
  static {
    INTEGER = new DataType("INTEGER", 1);
    BOOLEAN = new DataType("BOOLEAN", 2);
    LONG = new DataType("LONG", 3);
    FLOAT = new DataType("FLOAT", 4);
    DOUBLE = new DataType("DOUBLE", 5);
    PARCELABLE = new DataType("PARCELABLE", 6);
    SERIALIZABLE = new DataType("SERIALIZABLE", 7);
    BUNDLE = new DataType("BUNDLE", 8);
    JSON = new DataType("JSON", 9);
    UNKNOWN = new DataType("UNKNOWN", 10);
    $VALUES = new DataType[] { 
        STRING, INTEGER, BOOLEAN, LONG, FLOAT, DOUBLE, PARCELABLE, SERIALIZABLE, BUNDLE, JSON, 
        UNKNOWN };
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\jeremyliao\liveeventbus\ipc\DataType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */