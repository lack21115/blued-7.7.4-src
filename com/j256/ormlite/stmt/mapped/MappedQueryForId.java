package com.j256.ormlite.stmt.mapped;

import com.j256.ormlite.dao.ObjectCache;
import com.j256.ormlite.db.DatabaseType;
import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.support.DatabaseConnection;
import com.j256.ormlite.table.TableInfo;
import java.sql.SQLException;

public class MappedQueryForId<T, ID> extends BaseMappedQuery<T, ID> {
  private final String label;
  
  protected MappedQueryForId(TableInfo<T, ID> paramTableInfo, String paramString1, FieldType[] paramArrayOfFieldType1, FieldType[] paramArrayOfFieldType2, String paramString2) {
    super(paramTableInfo, paramString1, paramArrayOfFieldType1, paramArrayOfFieldType2);
    this.label = paramString2;
  }
  
  public static <T, ID> MappedQueryForId<T, ID> build(DatabaseType paramDatabaseType, TableInfo<T, ID> paramTableInfo, FieldType paramFieldType) throws SQLException {
    StringBuilder stringBuilder;
    FieldType fieldType = paramFieldType;
    if (paramFieldType == null) {
      fieldType = paramTableInfo.getIdField();
      if (fieldType == null) {
        stringBuilder = new StringBuilder();
        stringBuilder.append("Cannot query-for-id with ");
        stringBuilder.append(paramTableInfo.getDataClass());
        stringBuilder.append(" because it doesn't have an id field");
        throw new SQLException(stringBuilder.toString());
      } 
    } 
    String str = buildStatement((DatabaseType)stringBuilder, paramTableInfo, fieldType);
    FieldType[] arrayOfFieldType = paramTableInfo.getFieldTypes();
    return new MappedQueryForId<T, ID>(paramTableInfo, str, new FieldType[] { fieldType }, arrayOfFieldType, "query-for-id");
  }
  
  protected static <T, ID> String buildStatement(DatabaseType paramDatabaseType, TableInfo<T, ID> paramTableInfo, FieldType paramFieldType) {
    StringBuilder stringBuilder = new StringBuilder(64);
    appendTableName(paramDatabaseType, stringBuilder, "SELECT * FROM ", paramTableInfo.getTableName());
    appendWhereFieldEq(paramDatabaseType, paramFieldType, stringBuilder, null);
    return stringBuilder.toString();
  }
  
  private void logArgs(Object[] paramArrayOfObject) {
    if (paramArrayOfObject.length > 0)
      logger.trace("{} arguments: {}", this.label, paramArrayOfObject); 
  }
  
  public T execute(DatabaseConnection paramDatabaseConnection, ID paramID, ObjectCache paramObjectCache) throws SQLException {
    if (paramObjectCache != null) {
      Object object1 = paramObjectCache.get(this.clazz, paramID);
      if (object1 != null)
        return (T)object1; 
    } 
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = convertIdToFieldObject(paramID);
    Object object = paramDatabaseConnection.queryForOne(this.statement, arrayOfObject, this.argFieldTypes, this, paramObjectCache);
    if (object == null) {
      logger.debug("{} using '{}' and {} args, got no results", this.label, this.statement, Integer.valueOf(arrayOfObject.length));
    } else {
      if (object != DatabaseConnection.MORE_THAN_ONE) {
        logger.debug("{} using '{}' and {} args, got 1 result", this.label, this.statement, Integer.valueOf(arrayOfObject.length));
        logArgs(arrayOfObject);
        return (T)object;
      } 
      logger.error("{} using '{}' and {} args, got >1 results", this.label, this.statement, Integer.valueOf(arrayOfObject.length));
      logArgs(arrayOfObject);
      object = new StringBuilder();
      object.append(this.label);
      object.append(" got more than 1 result: ");
      object.append(this.statement);
      throw new SQLException(object.toString());
    } 
    logArgs(arrayOfObject);
    return (T)object;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\j256\ormlite\stmt\mapped\MappedQueryForId.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */