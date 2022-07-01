package com.j256.ormlite.field;

public enum SqlType {
  BIG_DECIMAL, BLOB, BOOLEAN, BYTE, BYTE_ARRAY, CHAR, DATE, DOUBLE, FLOAT, INTEGER, LONG, LONG_STRING, OTHER, SERIALIZABLE, SHORT, STRING, UNKNOWN;
  
  static {
    LONG_STRING = new SqlType("LONG_STRING", 1);
    DATE = new SqlType("DATE", 2);
    BOOLEAN = new SqlType("BOOLEAN", 3);
    CHAR = new SqlType("CHAR", 4);
    BYTE = new SqlType("BYTE", 5);
    BYTE_ARRAY = new SqlType("BYTE_ARRAY", 6);
    SHORT = new SqlType("SHORT", 7);
    INTEGER = new SqlType("INTEGER", 8);
    LONG = new SqlType("LONG", 9);
    FLOAT = new SqlType("FLOAT", 10);
    DOUBLE = new SqlType("DOUBLE", 11);
    SERIALIZABLE = new SqlType("SERIALIZABLE", 12);
    BLOB = new SqlType("BLOB", 13);
    BIG_DECIMAL = new SqlType("BIG_DECIMAL", 14);
    OTHER = new SqlType("OTHER", 15);
    UNKNOWN = new SqlType("UNKNOWN", 16);
    $VALUES = new SqlType[] { 
        STRING, LONG_STRING, DATE, BOOLEAN, CHAR, BYTE, BYTE_ARRAY, SHORT, INTEGER, LONG, 
        FLOAT, DOUBLE, SERIALIZABLE, BLOB, BIG_DECIMAL, OTHER, UNKNOWN };
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\j256\ormlite\field\SqlType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */