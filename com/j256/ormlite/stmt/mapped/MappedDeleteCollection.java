package com.j256.ormlite.stmt.mapped;

import com.j256.ormlite.dao.ObjectCache;
import com.j256.ormlite.db.DatabaseType;
import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.misc.SqlExceptionUtil;
import com.j256.ormlite.support.DatabaseConnection;
import com.j256.ormlite.table.TableInfo;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Iterator;

public class MappedDeleteCollection<T, ID> extends BaseMappedStatement<T, ID> {
  private MappedDeleteCollection(TableInfo<T, ID> paramTableInfo, String paramString, FieldType[] paramArrayOfFieldType) {
    super(paramTableInfo, paramString, paramArrayOfFieldType);
  }
  
  private static void appendWhereIds(DatabaseType paramDatabaseType, FieldType paramFieldType, StringBuilder paramStringBuilder, int paramInt, FieldType[] paramArrayOfFieldType) {
    paramStringBuilder.append("WHERE ");
    paramDatabaseType.appendEscapedEntityName(paramStringBuilder, paramFieldType.getColumnName());
    paramStringBuilder.append(" IN (");
    int i = 0;
    boolean bool = true;
    while (i < paramInt) {
      if (bool) {
        bool = false;
      } else {
        paramStringBuilder.append(',');
      } 
      paramStringBuilder.append('?');
      if (paramArrayOfFieldType != null)
        paramArrayOfFieldType[i] = paramFieldType; 
      i++;
    } 
    paramStringBuilder.append(") ");
  }
  
  private static <T, ID> MappedDeleteCollection<T, ID> build(DatabaseType paramDatabaseType, TableInfo<T, ID> paramTableInfo, int paramInt) throws SQLException {
    FieldType fieldType = paramTableInfo.getIdField();
    if (fieldType != null) {
      StringBuilder stringBuilder1 = new StringBuilder(128);
      appendTableName(paramDatabaseType, stringBuilder1, "DELETE FROM ", paramTableInfo.getTableName());
      FieldType[] arrayOfFieldType = new FieldType[paramInt];
      appendWhereIds(paramDatabaseType, fieldType, stringBuilder1, paramInt, arrayOfFieldType);
      return new MappedDeleteCollection<T, ID>(paramTableInfo, stringBuilder1.toString(), arrayOfFieldType);
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Cannot delete ");
    stringBuilder.append(paramTableInfo.getDataClass());
    stringBuilder.append(" because it doesn't have an id field defined");
    throw new SQLException(stringBuilder.toString());
  }
  
  public static <T, ID> int deleteIds(DatabaseType paramDatabaseType, TableInfo<T, ID> paramTableInfo, DatabaseConnection paramDatabaseConnection, Collection<ID> paramCollection, ObjectCache paramObjectCache) throws SQLException {
    MappedDeleteCollection<T, ID> mappedDeleteCollection = build(paramDatabaseType, paramTableInfo, paramCollection.size());
    Object[] arrayOfObject = new Object[paramCollection.size()];
    FieldType fieldType = paramTableInfo.getIdField();
    Iterator<ID> iterator = paramCollection.iterator();
    int i;
    for (i = 0; iterator.hasNext(); i++)
      arrayOfObject[i] = fieldType.convertJavaFieldToSqlArgValue(iterator.next()); 
    return updateRows(paramDatabaseConnection, paramTableInfo.getDataClass(), mappedDeleteCollection, arrayOfObject, paramObjectCache);
  }
  
  public static <T, ID> int deleteObjects(DatabaseType paramDatabaseType, TableInfo<T, ID> paramTableInfo, DatabaseConnection paramDatabaseConnection, Collection<T> paramCollection, ObjectCache paramObjectCache) throws SQLException {
    MappedDeleteCollection<T, ID> mappedDeleteCollection = build(paramDatabaseType, paramTableInfo, paramCollection.size());
    Object[] arrayOfObject = new Object[paramCollection.size()];
    FieldType fieldType = paramTableInfo.getIdField();
    Iterator<T> iterator = paramCollection.iterator();
    int i;
    for (i = 0; iterator.hasNext(); i++)
      arrayOfObject[i] = fieldType.extractJavaFieldToSqlArgValue(iterator.next()); 
    return updateRows(paramDatabaseConnection, paramTableInfo.getDataClass(), mappedDeleteCollection, arrayOfObject, paramObjectCache);
  }
  
  private static <T, ID> int updateRows(DatabaseConnection paramDatabaseConnection, Class<T> paramClass, MappedDeleteCollection<T, ID> paramMappedDeleteCollection, Object[] paramArrayOfObject, ObjectCache paramObjectCache) throws SQLException {
    try {
      int i = paramDatabaseConnection.delete(paramMappedDeleteCollection.statement, paramArrayOfObject, paramMappedDeleteCollection.argFieldTypes);
      if (i > 0 && paramObjectCache != null) {
        int k = paramArrayOfObject.length;
        int j;
        for (j = 0; j < k; j++)
          paramObjectCache.remove(paramClass, paramArrayOfObject[j]); 
      } 
      logger.debug("delete-collection with statement '{}' and {} args, changed {} rows", paramMappedDeleteCollection.statement, Integer.valueOf(paramArrayOfObject.length), Integer.valueOf(i));
      if (paramArrayOfObject.length > 0)
        logger.trace("delete-collection arguments: {}", paramArrayOfObject); 
      return i;
    } catch (SQLException sQLException) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Unable to run delete collection stmt: ");
      stringBuilder.append(paramMappedDeleteCollection.statement);
      throw SqlExceptionUtil.create(stringBuilder.toString(), sQLException);
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\j256\ormlite\stmt\mapped\MappedDeleteCollection.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */