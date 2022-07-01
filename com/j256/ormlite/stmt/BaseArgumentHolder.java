package com.j256.ormlite.stmt;

import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.field.SqlType;
import java.sql.SQLException;

public abstract class BaseArgumentHolder implements ArgumentHolder {
  private String columnName = null;
  
  private FieldType fieldType = null;
  
  private SqlType sqlType = null;
  
  public BaseArgumentHolder() {}
  
  public BaseArgumentHolder(SqlType paramSqlType) {
    this.sqlType = paramSqlType;
  }
  
  public BaseArgumentHolder(String paramString) {
    this.columnName = paramString;
  }
  
  public String getColumnName() {
    return this.columnName;
  }
  
  public FieldType getFieldType() {
    return this.fieldType;
  }
  
  public Object getSqlArgValue() throws SQLException {
    if (isValueSet()) {
      Object object = getValue();
      if (object == null)
        return null; 
      FieldType fieldType = this.fieldType;
      return (fieldType == null) ? object : ((fieldType.isForeign() && this.fieldType.getType() == object.getClass()) ? this.fieldType.getForeignIdField().extractJavaFieldValue(object) : this.fieldType.convertJavaFieldToSqlArgValue(object));
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Column value has not been set for ");
    stringBuilder.append(this.columnName);
    throw new SQLException(stringBuilder.toString());
  }
  
  public SqlType getSqlType() {
    return this.sqlType;
  }
  
  protected abstract Object getValue();
  
  protected abstract boolean isValueSet();
  
  public void setMetaInfo(FieldType paramFieldType) {
    FieldType fieldType = this.fieldType;
    if (fieldType == null || fieldType == paramFieldType) {
      this.fieldType = paramFieldType;
      return;
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("FieldType name cannot be set twice from ");
    stringBuilder.append(this.fieldType);
    stringBuilder.append(" to ");
    stringBuilder.append(paramFieldType);
    stringBuilder.append(".  Using a SelectArg twice in query with different columns?");
    throw new IllegalArgumentException(stringBuilder.toString());
  }
  
  public void setMetaInfo(String paramString) {
    String str = this.columnName;
    if (str == null || str.equals(paramString)) {
      this.columnName = paramString;
      return;
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Column name cannot be set twice from ");
    stringBuilder.append(this.columnName);
    stringBuilder.append(" to ");
    stringBuilder.append(paramString);
    stringBuilder.append(".  Using a SelectArg twice in query with different columns?");
    throw new IllegalArgumentException(stringBuilder.toString());
  }
  
  public void setMetaInfo(String paramString, FieldType paramFieldType) {
    setMetaInfo(paramString);
    setMetaInfo(paramFieldType);
  }
  
  public abstract void setValue(Object paramObject);
  
  public String toString() {
    if (!isValueSet())
      return "[unset]"; 
    try {
      null = getSqlArgValue();
      return (null == null) ? "[null]" : null.toString();
    } catch (SQLException sQLException) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("[could not get value: ");
      stringBuilder.append(sQLException);
      stringBuilder.append("]");
      return stringBuilder.toString();
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\j256\ormlite\stmt\BaseArgumentHolder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */