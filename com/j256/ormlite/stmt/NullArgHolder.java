package com.j256.ormlite.stmt;

import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.field.SqlType;

public class NullArgHolder implements ArgumentHolder {
  public String getColumnName() {
    return "null-holder";
  }
  
  public FieldType getFieldType() {
    return null;
  }
  
  public Object getSqlArgValue() {
    return null;
  }
  
  public SqlType getSqlType() {
    return SqlType.STRING;
  }
  
  public void setMetaInfo(FieldType paramFieldType) {}
  
  public void setMetaInfo(String paramString) {}
  
  public void setMetaInfo(String paramString, FieldType paramFieldType) {}
  
  public void setValue(Object paramObject) {
    paramObject = new StringBuilder();
    paramObject.append("Cannot set null on ");
    paramObject.append(getClass());
    throw new UnsupportedOperationException(paramObject.toString());
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\j256\ormlite\stmt\NullArgHolder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */