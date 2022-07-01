package com.google.gson.stream;

public enum JsonToken {
  BEGIN_ARRAY, BEGIN_OBJECT, BOOLEAN, END_ARRAY, END_DOCUMENT, END_OBJECT, NAME, NULL, NUMBER, STRING;
  
  static {
    BEGIN_OBJECT = new JsonToken("BEGIN_OBJECT", 2);
    END_OBJECT = new JsonToken("END_OBJECT", 3);
    NAME = new JsonToken("NAME", 4);
    STRING = new JsonToken("STRING", 5);
    NUMBER = new JsonToken("NUMBER", 6);
    BOOLEAN = new JsonToken("BOOLEAN", 7);
    NULL = new JsonToken("NULL", 8);
    END_DOCUMENT = new JsonToken("END_DOCUMENT", 9);
    $VALUES = new JsonToken[] { BEGIN_ARRAY, END_ARRAY, BEGIN_OBJECT, END_OBJECT, NAME, STRING, NUMBER, BOOLEAN, NULL, END_DOCUMENT };
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\gson\stream\JsonToken.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */