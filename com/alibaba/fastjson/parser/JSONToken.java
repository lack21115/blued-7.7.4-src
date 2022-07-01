package com.alibaba.fastjson.parser;

public class JSONToken {
  public static final int COLON = 17;
  
  public static final int COMMA = 16;
  
  public static final int EOF = 20;
  
  public static final int ERROR = 1;
  
  public static final int FALSE = 7;
  
  public static final int FIELD_NAME = 19;
  
  public static final int IDENTIFIER = 18;
  
  public static final int LBRACE = 12;
  
  public static final int LBRACKET = 14;
  
  public static final int LITERAL_FLOAT = 3;
  
  public static final int LITERAL_INT = 2;
  
  public static final int LITERAL_ISO8601_DATE = 5;
  
  public static final int LITERAL_STRING = 4;
  
  public static final int LPAREN = 10;
  
  public static final int NEW = 9;
  
  public static final int NULL = 8;
  
  public static final int RBRACE = 13;
  
  public static final int RBRACKET = 15;
  
  public static final int RPAREN = 11;
  
  public static final int SET = 21;
  
  public static final int TREE_SET = 22;
  
  public static final int TRUE = 6;
  
  public static final int UNDEFINED = 23;
  
  public static String name(int paramInt) {
    switch (paramInt) {
      default:
        return "Unknown";
      case 23:
        return "undefined";
      case 22:
        return "TreeSet";
      case 21:
        return "Set";
      case 20:
        return "EOF";
      case 19:
        return "fieldName";
      case 18:
        return "ident";
      case 17:
        return ":";
      case 16:
        return ",";
      case 15:
        return "]";
      case 14:
        return "[";
      case 13:
        return "}";
      case 12:
        return "{";
      case 11:
        return ")";
      case 10:
        return "(";
      case 9:
        return "new";
      case 8:
        return "null";
      case 7:
        return "false";
      case 6:
        return "true";
      case 5:
        return "iso8601";
      case 4:
        return "string";
      case 3:
        return "float";
      case 2:
        return "int";
      case 1:
        break;
    } 
    return "error";
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\alibaba\fastjson\parser\JSONToken.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */