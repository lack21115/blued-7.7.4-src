package com.alibaba.fastjson.parser;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.Locale;
import java.util.TimeZone;

public interface JSONLexer {
  public static final int ARRAY = 2;
  
  public static final int END = 4;
  
  public static final byte EOI = 26;
  
  public static final int NOT_MATCH = -1;
  
  public static final int NOT_MATCH_NAME = -2;
  
  public static final int OBJECT = 1;
  
  public static final int UNKNOWN = 0;
  
  public static final int VALUE = 3;
  
  byte[] bytesValue();
  
  void close();
  
  void config(Feature paramFeature, boolean paramBoolean);
  
  Number decimalValue(boolean paramBoolean);
  
  BigDecimal decimalValue();
  
  float floatValue();
  
  int getBufferPosition();
  
  char getCurrent();
  
  Locale getLocale();
  
  TimeZone getTimeZone();
  
  String info();
  
  int intValue();
  
  Number integerValue();
  
  boolean isBlankInput();
  
  boolean isEnabled(Feature paramFeature);
  
  boolean isRef();
  
  long longValue();
  
  char next();
  
  void nextToken();
  
  void nextToken(int paramInt);
  
  void nextTokenWithColon();
  
  void nextTokenWithColon(int paramInt);
  
  String numberString();
  
  int pos();
  
  void resetStringPosition();
  
  Enum<?> scanEnum(Class<?> paramClass, SymbolTable paramSymbolTable, char paramChar);
  
  int scanInt(char paramChar);
  
  long scanLong(char paramChar);
  
  void scanNumber();
  
  String scanString(char paramChar);
  
  void scanString();
  
  Collection<String> scanStringArray(Class<?> paramClass, char paramChar);
  
  String scanSymbol(SymbolTable paramSymbolTable);
  
  String scanSymbol(SymbolTable paramSymbolTable, char paramChar);
  
  String scanSymbolUnQuoted(SymbolTable paramSymbolTable);
  
  String scanSymbolWithSeperator(SymbolTable paramSymbolTable, char paramChar);
  
  void setLocale(Locale paramLocale);
  
  void setTimeZone(TimeZone paramTimeZone);
  
  void skipWhitespace();
  
  String stringVal();
  
  int token();
  
  String tokenName();
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\alibaba\fastjson\parser\JSONLexer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */