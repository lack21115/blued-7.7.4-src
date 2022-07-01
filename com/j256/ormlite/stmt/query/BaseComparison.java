package com.j256.ormlite.stmt.query;

import com.j256.ormlite.db.DatabaseType;
import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.stmt.ArgumentHolder;
import com.j256.ormlite.stmt.ColumnArg;
import com.j256.ormlite.stmt.SelectArg;
import java.sql.SQLException;
import java.util.List;

abstract class BaseComparison implements Comparison {
  private static final String NUMBER_CHARACTERS = "0123456789.-+";
  
  protected final String columnName;
  
  protected final FieldType fieldType;
  
  private final Object value;
  
  protected BaseComparison(String paramString, FieldType paramFieldType, Object paramObject, boolean paramBoolean) throws SQLException {
    if (!paramBoolean || paramFieldType == null || paramFieldType.isComparable()) {
      this.columnName = paramString;
      this.fieldType = paramFieldType;
      this.value = paramObject;
      return;
    } 
    paramObject = new StringBuilder();
    paramObject.append("Field '");
    paramObject.append(paramString);
    paramObject.append("' is of data type ");
    paramObject.append(paramFieldType.getDataPersister());
    paramObject.append(" which can not be compared");
    throw new SQLException(paramObject.toString());
  }
  
  protected void appendArgOrValue(DatabaseType paramDatabaseType, FieldType paramFieldType, StringBuilder paramStringBuilder, List<ArgumentHolder> paramList, Object paramObject) throws SQLException {
    FieldType fieldType;
    if (paramObject != null) {
      ArgumentHolder argumentHolder;
      boolean bool2 = paramObject instanceof ArgumentHolder;
      boolean bool1 = false;
      if (bool2) {
        paramStringBuilder.append('?');
        argumentHolder = (ArgumentHolder)paramObject;
        argumentHolder.setMetaInfo(this.columnName, paramFieldType);
        paramList.add(argumentHolder);
      } else {
        ColumnArg columnArg;
        String str;
        if (paramObject instanceof ColumnArg) {
          columnArg = (ColumnArg)paramObject;
          str = columnArg.getTableName();
          if (str != null) {
            argumentHolder.appendEscapedEntityName(paramStringBuilder, str);
            paramStringBuilder.append('.');
          } 
          argumentHolder.appendEscapedEntityName(paramStringBuilder, columnArg.getColumnName());
        } else {
          SelectArg selectArg;
          if (columnArg.isArgumentHolderRequired()) {
            paramStringBuilder.append('?');
            selectArg = new SelectArg();
            selectArg.setMetaInfo(this.columnName, (FieldType)columnArg);
            selectArg.setValue(paramObject);
            str.add(selectArg);
          } else {
            if (columnArg.isForeign() && columnArg.getType().isAssignableFrom(paramObject.getClass())) {
              fieldType = columnArg.getForeignIdField();
              appendArgOrValue((DatabaseType)selectArg, fieldType, paramStringBuilder, (List<ArgumentHolder>)str, fieldType.extractJavaFieldValue(paramObject));
            } else {
              if (fieldType.isEscapedValue()) {
                selectArg.appendEscapedWord(paramStringBuilder, fieldType.convertJavaFieldToSqlArgValue(paramObject).toString());
              } else if (fieldType.isForeign()) {
                String str1 = fieldType.convertJavaFieldToSqlArgValue(paramObject).toString();
                if (str1.length() <= 0 || "0123456789.-+".indexOf(str1.charAt(0)) >= 0) {
                  paramStringBuilder.append(str1);
                } else {
                  paramStringBuilder = new StringBuilder();
                  paramStringBuilder.append("Foreign field ");
                  paramStringBuilder.append(fieldType);
                  paramStringBuilder.append(" does not seem to be producing a numerical value '");
                  paramStringBuilder.append(str1);
                  paramStringBuilder.append("'. Maybe you are passing the wrong object to comparison: ");
                  paramStringBuilder.append(this);
                  throw new SQLException(paramStringBuilder.toString());
                } 
              } else {
                paramStringBuilder.append(fieldType.convertJavaFieldToSqlArgValue(paramObject));
              } 
              bool1 = true;
            } 
            if (bool1)
              paramStringBuilder.append(' '); 
            return;
          } 
        } 
      } 
    } else {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("argument for '");
      stringBuilder.append(fieldType.getFieldName());
      stringBuilder.append("' is null");
      throw new SQLException(stringBuilder.toString());
    } 
    boolean bool = true;
  }
  
  public abstract void appendOperation(StringBuilder paramStringBuilder);
  
  public void appendSql(DatabaseType paramDatabaseType, String paramString, StringBuilder paramStringBuilder, List<ArgumentHolder> paramList) throws SQLException {
    if (paramString != null) {
      paramDatabaseType.appendEscapedEntityName(paramStringBuilder, paramString);
      paramStringBuilder.append('.');
    } 
    paramDatabaseType.appendEscapedEntityName(paramStringBuilder, this.columnName);
    paramStringBuilder.append(' ');
    appendOperation(paramStringBuilder);
    appendValue(paramDatabaseType, paramStringBuilder, paramList);
  }
  
  public void appendValue(DatabaseType paramDatabaseType, StringBuilder paramStringBuilder, List<ArgumentHolder> paramList) throws SQLException {
    appendArgOrValue(paramDatabaseType, this.fieldType, paramStringBuilder, paramList, this.value);
  }
  
  public String getColumnName() {
    return this.columnName;
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(this.columnName);
    stringBuilder.append(' ');
    appendOperation(stringBuilder);
    stringBuilder.append(' ');
    stringBuilder.append(this.value);
    return stringBuilder.toString();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\j256\ormlite\stmt\query\BaseComparison.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */