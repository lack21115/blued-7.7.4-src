package com.j256.ormlite.stmt.mapped;

import com.j256.ormlite.dao.ObjectCache;
import com.j256.ormlite.db.DatabaseType;
import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.support.DatabaseConnection;
import com.j256.ormlite.table.TableInfo;
import java.sql.SQLException;

public class MappedRefresh<T, ID> extends MappedQueryForId<T, ID> {
  private MappedRefresh(TableInfo<T, ID> paramTableInfo, String paramString, FieldType[] paramArrayOfFieldType1, FieldType[] paramArrayOfFieldType2) {
    super(paramTableInfo, paramString, paramArrayOfFieldType1, paramArrayOfFieldType2, "refresh");
  }
  
  public static <T, ID> MappedRefresh<T, ID> build(DatabaseType paramDatabaseType, TableInfo<T, ID> paramTableInfo) throws SQLException {
    FieldType fieldType = paramTableInfo.getIdField();
    if (fieldType != null) {
      String str = buildStatement(paramDatabaseType, paramTableInfo, fieldType);
      fieldType = paramTableInfo.getIdField();
      FieldType[] arrayOfFieldType = paramTableInfo.getFieldTypes();
      return new MappedRefresh<T, ID>(paramTableInfo, str, new FieldType[] { fieldType }, arrayOfFieldType);
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Cannot refresh ");
    stringBuilder.append(paramTableInfo.getDataClass());
    stringBuilder.append(" because it doesn't have an id field");
    throw new SQLException(stringBuilder.toString());
  }
  
  public int executeRefresh(DatabaseConnection paramDatabaseConnection, T paramT, ObjectCache paramObjectCache) throws SQLException {
    paramDatabaseConnection = (DatabaseConnection)execute(paramDatabaseConnection, (ID)this.idField.extractJavaFieldValue(paramT), (ObjectCache)null);
    if (paramDatabaseConnection == null)
      return 0; 
    for (FieldType fieldType : this.resultsFieldTypes) {
      if (fieldType != this.idField)
        fieldType.assignField(paramT, fieldType.extractJavaFieldValue(paramDatabaseConnection), false, paramObjectCache); 
    } 
    return 1;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\j256\ormlite\stmt\mapped\MappedRefresh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */