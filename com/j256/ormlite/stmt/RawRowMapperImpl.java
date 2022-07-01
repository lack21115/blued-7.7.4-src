package com.j256.ormlite.stmt;

import com.j256.ormlite.dao.RawRowMapper;
import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.table.TableInfo;
import java.sql.SQLException;

public class RawRowMapperImpl<T, ID> implements RawRowMapper<T> {
  private final TableInfo<T, ID> tableInfo;
  
  public RawRowMapperImpl(TableInfo<T, ID> paramTableInfo) {
    this.tableInfo = paramTableInfo;
  }
  
  public T mapRow(String[] paramArrayOfString1, String[] paramArrayOfString2) throws SQLException {
    Object object = this.tableInfo.createObject();
    for (int i = 0; i < paramArrayOfString1.length; i++) {
      if (i < paramArrayOfString2.length) {
        FieldType fieldType = this.tableInfo.getFieldTypeByColumnName(paramArrayOfString1[i]);
        fieldType.assignField(object, fieldType.convertStringToJavaField(paramArrayOfString2[i], i), false, null);
      } 
    } 
    return (T)object;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\j256\ormlite\stmt\RawRowMapperImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */