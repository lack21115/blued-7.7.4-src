package com.j256.ormlite.stmt.mapped;

import com.j256.ormlite.dao.ObjectCache;
import com.j256.ormlite.db.DatabaseType;
import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.misc.SqlExceptionUtil;
import com.j256.ormlite.support.DatabaseConnection;
import com.j256.ormlite.table.TableInfo;
import java.sql.SQLException;

public class MappedDelete<T, ID> extends BaseMappedStatement<T, ID> {
  private MappedDelete(TableInfo<T, ID> paramTableInfo, String paramString, FieldType[] paramArrayOfFieldType) {
    super(paramTableInfo, paramString, paramArrayOfFieldType);
  }
  
  public static <T, ID> MappedDelete<T, ID> build(DatabaseType paramDatabaseType, TableInfo<T, ID> paramTableInfo) throws SQLException {
    FieldType fieldType = paramTableInfo.getIdField();
    if (fieldType != null) {
      StringBuilder stringBuilder1 = new StringBuilder(64);
      appendTableName(paramDatabaseType, stringBuilder1, "DELETE FROM ", paramTableInfo.getTableName());
      appendWhereFieldEq(paramDatabaseType, fieldType, stringBuilder1, null);
      return new MappedDelete<T, ID>(paramTableInfo, stringBuilder1.toString(), new FieldType[] { fieldType });
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Cannot delete from ");
    stringBuilder.append(paramTableInfo.getDataClass());
    stringBuilder.append(" because it doesn't have an id field");
    throw new SQLException(stringBuilder.toString());
  }
  
  public int delete(DatabaseConnection paramDatabaseConnection, T paramT, ObjectCache paramObjectCache) throws SQLException {
    try {
      Object[] arrayOfObject = getFieldObjects(paramT);
      int i = paramDatabaseConnection.delete(this.statement, arrayOfObject, this.argFieldTypes);
      logger.debug("delete data with statement '{}' and {} args, changed {} rows", this.statement, Integer.valueOf(arrayOfObject.length), Integer.valueOf(i));
      if (arrayOfObject.length > 0)
        logger.trace("delete arguments: {}", arrayOfObject); 
      if (i > 0 && paramObjectCache != null) {
        Object object = this.idField.extractJavaFieldToSqlArgValue(paramT);
        paramObjectCache.remove(this.clazz, object);
      } 
      return i;
    } catch (SQLException sQLException) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Unable to run delete stmt on object ");
      stringBuilder.append(paramT);
      stringBuilder.append(": ");
      stringBuilder.append(this.statement);
      throw SqlExceptionUtil.create(stringBuilder.toString(), sQLException);
    } 
  }
  
  public int deleteById(DatabaseConnection paramDatabaseConnection, ID paramID, ObjectCache paramObjectCache) throws SQLException {
    try {
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = convertIdToFieldObject(paramID);
      int i = paramDatabaseConnection.delete(this.statement, arrayOfObject, this.argFieldTypes);
      logger.debug("delete data with statement '{}' and {} args, changed {} rows", this.statement, Integer.valueOf(arrayOfObject.length), Integer.valueOf(i));
      if (arrayOfObject.length > 0)
        logger.trace("delete arguments: {}", arrayOfObject); 
      if (i > 0 && paramObjectCache != null)
        paramObjectCache.remove(this.clazz, paramID); 
      return i;
    } catch (SQLException sQLException) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Unable to run deleteById stmt on id ");
      stringBuilder.append(paramID);
      stringBuilder.append(": ");
      stringBuilder.append(this.statement);
      throw SqlExceptionUtil.create(stringBuilder.toString(), sQLException);
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\j256\ormlite\stmt\mapped\MappedDelete.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */