package com.j256.ormlite.stmt.mapped;

import com.j256.ormlite.dao.ObjectCache;
import com.j256.ormlite.db.DatabaseType;
import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.misc.SqlExceptionUtil;
import com.j256.ormlite.support.DatabaseConnection;
import com.j256.ormlite.table.TableInfo;
import java.sql.SQLException;

public class MappedUpdateId<T, ID> extends BaseMappedStatement<T, ID> {
  private MappedUpdateId(TableInfo<T, ID> paramTableInfo, String paramString, FieldType[] paramArrayOfFieldType) {
    super(paramTableInfo, paramString, paramArrayOfFieldType);
  }
  
  public static <T, ID> MappedUpdateId<T, ID> build(DatabaseType paramDatabaseType, TableInfo<T, ID> paramTableInfo) throws SQLException {
    FieldType fieldType = paramTableInfo.getIdField();
    if (fieldType != null) {
      StringBuilder stringBuilder1 = new StringBuilder(64);
      appendTableName(paramDatabaseType, stringBuilder1, "UPDATE ", paramTableInfo.getTableName());
      stringBuilder1.append("SET ");
      appendFieldColumnName(paramDatabaseType, stringBuilder1, fieldType, null);
      stringBuilder1.append("= ? ");
      appendWhereFieldEq(paramDatabaseType, fieldType, stringBuilder1, null);
      return new MappedUpdateId<T, ID>(paramTableInfo, stringBuilder1.toString(), new FieldType[] { fieldType, fieldType });
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Cannot update-id in ");
    stringBuilder.append(paramTableInfo.getDataClass());
    stringBuilder.append(" because it doesn't have an id field");
    throw new SQLException(stringBuilder.toString());
  }
  
  private Object extractIdToFieldObject(T paramT) throws SQLException {
    return this.idField.extractJavaFieldToSqlArgValue(paramT);
  }
  
  public int execute(DatabaseConnection paramDatabaseConnection, T paramT, ID paramID, ObjectCache paramObjectCache) throws SQLException {
    try {
      Object[] arrayOfObject = new Object[2];
      arrayOfObject[0] = convertIdToFieldObject(paramID);
      arrayOfObject[1] = extractIdToFieldObject(paramT);
      int i = paramDatabaseConnection.update(this.statement, arrayOfObject, this.argFieldTypes);
      if (i > 0) {
        if (paramObjectCache != null) {
          Object object = this.idField.extractJavaFieldValue(paramT);
          object = paramObjectCache.updateId(this.clazz, object, paramID);
          if (object != null && object != paramT)
            this.idField.assignField(object, paramID, false, paramObjectCache); 
        } 
        this.idField.assignField(paramT, paramID, false, paramObjectCache);
      } 
      logger.debug("updating-id with statement '{}' and {} args, changed {} rows", this.statement, Integer.valueOf(arrayOfObject.length), Integer.valueOf(i));
      if (arrayOfObject.length > 0)
        logger.trace("updating-id arguments: {}", arrayOfObject); 
      return i;
    } catch (SQLException sQLException) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Unable to run update-id stmt on object ");
      stringBuilder.append(paramT);
      stringBuilder.append(": ");
      stringBuilder.append(this.statement);
      throw SqlExceptionUtil.create(stringBuilder.toString(), sQLException);
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\j256\ormlite\stmt\mapped\MappedUpdateId.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */