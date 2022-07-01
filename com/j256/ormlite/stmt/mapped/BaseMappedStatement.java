package com.j256.ormlite.stmt.mapped;

import com.j256.ormlite.db.DatabaseType;
import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.logger.Logger;
import com.j256.ormlite.logger.LoggerFactory;
import com.j256.ormlite.table.TableInfo;
import java.sql.SQLException;
import java.util.List;

public abstract class BaseMappedStatement<T, ID> {
  protected static Logger logger = LoggerFactory.getLogger(BaseMappedStatement.class);
  
  protected final FieldType[] argFieldTypes;
  
  protected final Class<T> clazz;
  
  protected final FieldType idField;
  
  protected final String statement;
  
  protected final TableInfo<T, ID> tableInfo;
  
  protected BaseMappedStatement(TableInfo<T, ID> paramTableInfo, String paramString, FieldType[] paramArrayOfFieldType) {
    this.tableInfo = paramTableInfo;
    this.clazz = paramTableInfo.getDataClass();
    this.idField = paramTableInfo.getIdField();
    this.statement = paramString;
    this.argFieldTypes = paramArrayOfFieldType;
  }
  
  static void appendFieldColumnName(DatabaseType paramDatabaseType, StringBuilder paramStringBuilder, FieldType paramFieldType, List<FieldType> paramList) {
    paramDatabaseType.appendEscapedEntityName(paramStringBuilder, paramFieldType.getColumnName());
    if (paramList != null)
      paramList.add(paramFieldType); 
    paramStringBuilder.append(' ');
  }
  
  static void appendTableName(DatabaseType paramDatabaseType, StringBuilder paramStringBuilder, String paramString1, String paramString2) {
    if (paramString1 != null)
      paramStringBuilder.append(paramString1); 
    paramDatabaseType.appendEscapedEntityName(paramStringBuilder, paramString2);
    paramStringBuilder.append(' ');
  }
  
  static void appendWhereFieldEq(DatabaseType paramDatabaseType, FieldType paramFieldType, StringBuilder paramStringBuilder, List<FieldType> paramList) {
    paramStringBuilder.append("WHERE ");
    appendFieldColumnName(paramDatabaseType, paramStringBuilder, paramFieldType, paramList);
    paramStringBuilder.append("= ?");
  }
  
  protected Object convertIdToFieldObject(ID paramID) throws SQLException {
    return this.idField.convertJavaFieldToSqlArgValue(paramID);
  }
  
  protected Object[] getFieldObjects(Object paramObject) throws SQLException {
    Object[] arrayOfObject = new Object[this.argFieldTypes.length];
    int i = 0;
    while (true) {
      FieldType[] arrayOfFieldType = this.argFieldTypes;
      if (i < arrayOfFieldType.length) {
        FieldType fieldType = arrayOfFieldType[i];
        if (fieldType.isAllowGeneratedIdInsert()) {
          arrayOfObject[i] = fieldType.getFieldValueIfNotDefault(paramObject);
        } else {
          arrayOfObject[i] = fieldType.extractJavaFieldToSqlArgValue(paramObject);
        } 
        if (arrayOfObject[i] == null && fieldType.getDefaultValue() != null)
          arrayOfObject[i] = fieldType.getDefaultValue(); 
        i++;
        continue;
      } 
      return arrayOfObject;
    } 
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("MappedStatement: ");
    stringBuilder.append(this.statement);
    return stringBuilder.toString();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\j256\ormlite\stmt\mapped\BaseMappedStatement.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */