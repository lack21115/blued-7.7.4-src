package com.j256.ormlite.stmt;

import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.field.SqlType;
import java.sql.SQLException;

public interface ArgumentHolder {
  String getColumnName();
  
  FieldType getFieldType();
  
  Object getSqlArgValue() throws SQLException;
  
  SqlType getSqlType();
  
  void setMetaInfo(FieldType paramFieldType);
  
  void setMetaInfo(String paramString);
  
  void setMetaInfo(String paramString, FieldType paramFieldType);
  
  void setValue(Object paramObject);
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\j256\ormlite\stmt\ArgumentHolder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */