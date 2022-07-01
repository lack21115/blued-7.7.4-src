package com.alibaba.fastjson.parser;

import java.lang.reflect.Type;

public class ParseContext {
  public final Object fieldName;
  
  public Object object;
  
  public final ParseContext parent;
  
  public Type type;
  
  public ParseContext(ParseContext paramParseContext, Object paramObject1, Object paramObject2) {
    this.parent = paramParseContext;
    this.object = paramObject1;
    this.fieldName = paramObject2;
  }
  
  public String toString() {
    if (this.parent == null)
      return "$"; 
    if (this.fieldName instanceof Integer) {
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append(this.parent.toString());
      stringBuilder1.append("[");
      stringBuilder1.append(this.fieldName);
      stringBuilder1.append("]");
      return stringBuilder1.toString();
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(this.parent.toString());
    stringBuilder.append(".");
    stringBuilder.append(this.fieldName);
    return stringBuilder.toString();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\alibaba\fastjson\parser\ParseContext.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */