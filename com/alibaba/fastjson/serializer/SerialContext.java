package com.alibaba.fastjson.serializer;

public class SerialContext {
  public final int features;
  
  public final Object fieldName;
  
  public final Object object;
  
  public final SerialContext parent;
  
  public SerialContext(SerialContext paramSerialContext, Object paramObject1, Object paramObject2, int paramInt1, int paramInt2) {
    this.parent = paramSerialContext;
    this.object = paramObject1;
    this.fieldName = paramObject2;
    this.features = paramInt1;
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


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\alibaba\fastjson\serializer\SerialContext.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */