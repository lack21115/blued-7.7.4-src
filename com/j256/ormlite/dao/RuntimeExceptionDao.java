package com.j256.ormlite.dao;

import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.logger.Log;
import com.j256.ormlite.logger.Logger;
import com.j256.ormlite.logger.LoggerFactory;
import com.j256.ormlite.stmt.DeleteBuilder;
import com.j256.ormlite.stmt.GenericRowMapper;
import com.j256.ormlite.stmt.PreparedDelete;
import com.j256.ormlite.stmt.PreparedQuery;
import com.j256.ormlite.stmt.PreparedUpdate;
import com.j256.ormlite.stmt.QueryBuilder;
import com.j256.ormlite.stmt.UpdateBuilder;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.support.DatabaseConnection;
import com.j256.ormlite.support.DatabaseResults;
import com.j256.ormlite.table.DatabaseTableConfig;
import com.j256.ormlite.table.ObjectFactory;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;

public class RuntimeExceptionDao<T, ID> implements CloseableIterable<T> {
  private static final Log.Level LOG_LEVEL = Log.Level.DEBUG;
  
  private static final Logger logger = LoggerFactory.getLogger(RuntimeExceptionDao.class);
  
  private Dao<T, ID> dao;
  
  public RuntimeExceptionDao(Dao<T, ID> paramDao) {
    this.dao = paramDao;
  }
  
  public static <T, ID> RuntimeExceptionDao<T, ID> createDao(ConnectionSource paramConnectionSource, DatabaseTableConfig<T> paramDatabaseTableConfig) throws SQLException {
    return new RuntimeExceptionDao<T, ID>(DaoManager.createDao(paramConnectionSource, paramDatabaseTableConfig));
  }
  
  public static <T, ID> RuntimeExceptionDao<T, ID> createDao(ConnectionSource paramConnectionSource, Class<T> paramClass) throws SQLException {
    return new RuntimeExceptionDao<T, ID>(DaoManager.createDao(paramConnectionSource, paramClass));
  }
  
  private void logMessage(Exception paramException, String paramString) {
    logger.log(LOG_LEVEL, paramException, paramString);
  }
  
  public void assignEmptyForeignCollection(T paramT, String paramString) {
    try {
      this.dao.assignEmptyForeignCollection(paramT, paramString);
      return;
    } catch (SQLException sQLException) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("assignEmptyForeignCollection threw exception on ");
      stringBuilder.append(paramString);
      logMessage(sQLException, stringBuilder.toString());
      throw new RuntimeException(sQLException);
    } 
  }
  
  public <CT> CT callBatchTasks(Callable<CT> paramCallable) {
    try {
      return (CT)this.dao.callBatchTasks((Callable)paramCallable);
    } catch (Exception exception) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("callBatchTasks threw exception on: ");
      stringBuilder.append(paramCallable);
      logMessage(exception, stringBuilder.toString());
      throw new RuntimeException(exception);
    } 
  }
  
  public void clearObjectCache() {
    this.dao.clearObjectCache();
  }
  
  public void closeLastIterator() {
    try {
      this.dao.closeLastIterator();
      return;
    } catch (SQLException sQLException) {
      logMessage(sQLException, "closeLastIterator threw exception");
      throw new RuntimeException(sQLException);
    } 
  }
  
  public CloseableIterator<T> closeableIterator() {
    return this.dao.closeableIterator();
  }
  
  public void commit(DatabaseConnection paramDatabaseConnection) {
    try {
      this.dao.commit(paramDatabaseConnection);
      return;
    } catch (SQLException sQLException) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("commit(");
      stringBuilder.append(paramDatabaseConnection);
      stringBuilder.append(") threw exception");
      logMessage(sQLException, stringBuilder.toString());
      throw new RuntimeException(sQLException);
    } 
  }
  
  public long countOf() {
    try {
      return this.dao.countOf();
    } catch (SQLException sQLException) {
      logMessage(sQLException, "countOf threw exception");
      throw new RuntimeException(sQLException);
    } 
  }
  
  public long countOf(PreparedQuery<T> paramPreparedQuery) {
    try {
      return this.dao.countOf(paramPreparedQuery);
    } catch (SQLException sQLException) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("countOf threw exception on ");
      stringBuilder.append(paramPreparedQuery);
      logMessage(sQLException, stringBuilder.toString());
      throw new RuntimeException(sQLException);
    } 
  }
  
  public int create(T paramT) {
    try {
      return this.dao.create(paramT);
    } catch (SQLException sQLException) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("create threw exception on: ");
      stringBuilder.append(paramT);
      logMessage(sQLException, stringBuilder.toString());
      throw new RuntimeException(sQLException);
    } 
  }
  
  public T createIfNotExists(T paramT) {
    try {
      return this.dao.createIfNotExists(paramT);
    } catch (SQLException sQLException) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("createIfNotExists threw exception on: ");
      stringBuilder.append(paramT);
      logMessage(sQLException, stringBuilder.toString());
      throw new RuntimeException(sQLException);
    } 
  }
  
  public Dao.CreateOrUpdateStatus createOrUpdate(T paramT) {
    try {
      return this.dao.createOrUpdate(paramT);
    } catch (SQLException sQLException) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("createOrUpdate threw exception on: ");
      stringBuilder.append(paramT);
      logMessage(sQLException, stringBuilder.toString());
      throw new RuntimeException(sQLException);
    } 
  }
  
  public int delete(PreparedDelete<T> paramPreparedDelete) {
    try {
      return this.dao.delete(paramPreparedDelete);
    } catch (SQLException sQLException) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("delete threw exception on: ");
      stringBuilder.append(paramPreparedDelete);
      logMessage(sQLException, stringBuilder.toString());
      throw new RuntimeException(sQLException);
    } 
  }
  
  public int delete(T paramT) {
    try {
      return this.dao.delete(paramT);
    } catch (SQLException sQLException) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("delete threw exception on: ");
      stringBuilder.append(paramT);
      logMessage(sQLException, stringBuilder.toString());
      throw new RuntimeException(sQLException);
    } 
  }
  
  public int delete(Collection<T> paramCollection) {
    try {
      return this.dao.delete(paramCollection);
    } catch (SQLException sQLException) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("delete threw exception on: ");
      stringBuilder.append(paramCollection);
      logMessage(sQLException, stringBuilder.toString());
      throw new RuntimeException(sQLException);
    } 
  }
  
  public DeleteBuilder<T, ID> deleteBuilder() {
    return this.dao.deleteBuilder();
  }
  
  public int deleteById(ID paramID) {
    try {
      return this.dao.deleteById(paramID);
    } catch (SQLException sQLException) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("deleteById threw exception on: ");
      stringBuilder.append(paramID);
      logMessage(sQLException, stringBuilder.toString());
      throw new RuntimeException(sQLException);
    } 
  }
  
  public int deleteIds(Collection<ID> paramCollection) {
    try {
      return this.dao.deleteIds(paramCollection);
    } catch (SQLException sQLException) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("deleteIds threw exception on: ");
      stringBuilder.append(paramCollection);
      logMessage(sQLException, stringBuilder.toString());
      throw new RuntimeException(sQLException);
    } 
  }
  
  public void endThreadConnection(DatabaseConnection paramDatabaseConnection) {
    try {
      this.dao.endThreadConnection(paramDatabaseConnection);
      return;
    } catch (SQLException sQLException) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("endThreadConnection(");
      stringBuilder.append(paramDatabaseConnection);
      stringBuilder.append(") threw exception");
      logMessage(sQLException, stringBuilder.toString());
      throw new RuntimeException(sQLException);
    } 
  }
  
  public int executeRaw(String paramString, String... paramVarArgs) {
    try {
      return this.dao.executeRaw(paramString, paramVarArgs);
    } catch (SQLException sQLException) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("executeRaw threw exception on: ");
      stringBuilder.append(paramString);
      logMessage(sQLException, stringBuilder.toString());
      throw new RuntimeException(sQLException);
    } 
  }
  
  public int executeRawNoArgs(String paramString) {
    try {
      return this.dao.executeRawNoArgs(paramString);
    } catch (SQLException sQLException) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("executeRawNoArgs threw exception on: ");
      stringBuilder.append(paramString);
      logMessage(sQLException, stringBuilder.toString());
      throw new RuntimeException(sQLException);
    } 
  }
  
  public ID extractId(T paramT) {
    try {
      return this.dao.extractId(paramT);
    } catch (SQLException sQLException) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("extractId threw exception on: ");
      stringBuilder.append(paramT);
      logMessage(sQLException, stringBuilder.toString());
      throw new RuntimeException(sQLException);
    } 
  }
  
  public FieldType findForeignFieldType(Class<?> paramClass) {
    return this.dao.findForeignFieldType(paramClass);
  }
  
  public ConnectionSource getConnectionSource() {
    return this.dao.getConnectionSource();
  }
  
  public Class<T> getDataClass() {
    return this.dao.getDataClass();
  }
  
  public <FT> ForeignCollection<FT> getEmptyForeignCollection(String paramString) {
    try {
      return (ForeignCollection)this.dao.getEmptyForeignCollection(paramString);
    } catch (SQLException sQLException) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("getEmptyForeignCollection threw exception on ");
      stringBuilder.append(paramString);
      logMessage(sQLException, stringBuilder.toString());
      throw new RuntimeException(sQLException);
    } 
  }
  
  public ObjectCache getObjectCache() {
    return this.dao.getObjectCache();
  }
  
  public RawRowMapper<T> getRawRowMapper() {
    return this.dao.getRawRowMapper();
  }
  
  public GenericRowMapper<T> getSelectStarRowMapper() {
    try {
      return this.dao.getSelectStarRowMapper();
    } catch (SQLException sQLException) {
      logMessage(sQLException, "getSelectStarRowMapper threw exception");
      throw new RuntimeException(sQLException);
    } 
  }
  
  public CloseableWrappedIterable<T> getWrappedIterable() {
    return this.dao.getWrappedIterable();
  }
  
  public CloseableWrappedIterable<T> getWrappedIterable(PreparedQuery<T> paramPreparedQuery) {
    return this.dao.getWrappedIterable(paramPreparedQuery);
  }
  
  public boolean idExists(ID paramID) {
    try {
      return this.dao.idExists(paramID);
    } catch (SQLException sQLException) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("idExists threw exception on ");
      stringBuilder.append(paramID);
      logMessage(sQLException, stringBuilder.toString());
      throw new RuntimeException(sQLException);
    } 
  }
  
  @Deprecated
  public boolean isAutoCommit() {
    try {
      return this.dao.isAutoCommit();
    } catch (SQLException sQLException) {
      logMessage(sQLException, "isAutoCommit() threw exception");
      throw new RuntimeException(sQLException);
    } 
  }
  
  public boolean isAutoCommit(DatabaseConnection paramDatabaseConnection) {
    try {
      return this.dao.isAutoCommit(paramDatabaseConnection);
    } catch (SQLException sQLException) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("isAutoCommit(");
      stringBuilder.append(paramDatabaseConnection);
      stringBuilder.append(") threw exception");
      logMessage(sQLException, stringBuilder.toString());
      throw new RuntimeException(sQLException);
    } 
  }
  
  public boolean isTableExists() {
    try {
      return this.dao.isTableExists();
    } catch (SQLException sQLException) {
      logMessage(sQLException, "isTableExists threw exception");
      throw new RuntimeException(sQLException);
    } 
  }
  
  public boolean isUpdatable() {
    return this.dao.isUpdatable();
  }
  
  public CloseableIterator<T> iterator() {
    return this.dao.iterator();
  }
  
  public CloseableIterator<T> iterator(int paramInt) {
    return this.dao.iterator(paramInt);
  }
  
  public CloseableIterator<T> iterator(PreparedQuery<T> paramPreparedQuery) {
    try {
      return this.dao.iterator(paramPreparedQuery);
    } catch (SQLException sQLException) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("iterator threw exception on: ");
      stringBuilder.append(paramPreparedQuery);
      logMessage(sQLException, stringBuilder.toString());
      throw new RuntimeException(sQLException);
    } 
  }
  
  public CloseableIterator<T> iterator(PreparedQuery<T> paramPreparedQuery, int paramInt) {
    try {
      return this.dao.iterator(paramPreparedQuery, paramInt);
    } catch (SQLException sQLException) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("iterator threw exception on: ");
      stringBuilder.append(paramPreparedQuery);
      logMessage(sQLException, stringBuilder.toString());
      throw new RuntimeException(sQLException);
    } 
  }
  
  public T mapSelectStarRow(DatabaseResults paramDatabaseResults) {
    try {
      return this.dao.mapSelectStarRow(paramDatabaseResults);
    } catch (SQLException sQLException) {
      logMessage(sQLException, "mapSelectStarRow threw exception on results");
      throw new RuntimeException(sQLException);
    } 
  }
  
  public String objectToString(T paramT) {
    return this.dao.objectToString(paramT);
  }
  
  public boolean objectsEqual(T paramT1, T paramT2) {
    try {
      return this.dao.objectsEqual(paramT1, paramT2);
    } catch (SQLException sQLException) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("objectsEqual threw exception on: ");
      stringBuilder.append(paramT1);
      stringBuilder.append(" and ");
      stringBuilder.append(paramT2);
      logMessage(sQLException, stringBuilder.toString());
      throw new RuntimeException(sQLException);
    } 
  }
  
  public List<T> query(PreparedQuery<T> paramPreparedQuery) {
    try {
      return this.dao.query(paramPreparedQuery);
    } catch (SQLException sQLException) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("query threw exception on: ");
      stringBuilder.append(paramPreparedQuery);
      logMessage(sQLException, stringBuilder.toString());
      throw new RuntimeException(sQLException);
    } 
  }
  
  public QueryBuilder<T, ID> queryBuilder() {
    return this.dao.queryBuilder();
  }
  
  public List<T> queryForAll() {
    try {
      return this.dao.queryForAll();
    } catch (SQLException sQLException) {
      logMessage(sQLException, "queryForAll threw exception");
      throw new RuntimeException(sQLException);
    } 
  }
  
  public List<T> queryForEq(String paramString, Object<T> paramObject) {
    try {
      return this.dao.queryForEq(paramString, paramObject);
    } catch (SQLException sQLException) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("queryForEq threw exception on: ");
      stringBuilder.append(paramString);
      logMessage(sQLException, stringBuilder.toString());
      throw new RuntimeException(sQLException);
    } 
  }
  
  public List<T> queryForFieldValues(Map<String, Object> paramMap) {
    try {
      return this.dao.queryForFieldValues(paramMap);
    } catch (SQLException sQLException) {
      logMessage(sQLException, "queryForFieldValues threw exception");
      throw new RuntimeException(sQLException);
    } 
  }
  
  public List<T> queryForFieldValuesArgs(Map<String, Object> paramMap) {
    try {
      return this.dao.queryForFieldValuesArgs(paramMap);
    } catch (SQLException sQLException) {
      logMessage(sQLException, "queryForFieldValuesArgs threw exception");
      throw new RuntimeException(sQLException);
    } 
  }
  
  public T queryForFirst(PreparedQuery<T> paramPreparedQuery) {
    try {
      return this.dao.queryForFirst(paramPreparedQuery);
    } catch (SQLException sQLException) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("queryForFirst threw exception on: ");
      stringBuilder.append(paramPreparedQuery);
      logMessage(sQLException, stringBuilder.toString());
      throw new RuntimeException(sQLException);
    } 
  }
  
  public T queryForId(ID paramID) {
    try {
      return this.dao.queryForId(paramID);
    } catch (SQLException sQLException) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("queryForId threw exception on: ");
      stringBuilder.append(paramID);
      logMessage(sQLException, stringBuilder.toString());
      throw new RuntimeException(sQLException);
    } 
  }
  
  public List<T> queryForMatching(T paramT) {
    try {
      return this.dao.queryForMatching(paramT);
    } catch (SQLException sQLException) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("queryForMatching threw exception on: ");
      stringBuilder.append(paramT);
      logMessage(sQLException, stringBuilder.toString());
      throw new RuntimeException(sQLException);
    } 
  }
  
  public List<T> queryForMatchingArgs(T paramT) {
    try {
      return this.dao.queryForMatchingArgs(paramT);
    } catch (SQLException sQLException) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("queryForMatchingArgs threw exception on: ");
      stringBuilder.append(paramT);
      logMessage(sQLException, stringBuilder.toString());
      throw new RuntimeException(sQLException);
    } 
  }
  
  public T queryForSameId(T paramT) {
    try {
      return this.dao.queryForSameId(paramT);
    } catch (SQLException sQLException) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("queryForSameId threw exception on: ");
      stringBuilder.append(paramT);
      logMessage(sQLException, stringBuilder.toString());
      throw new RuntimeException(sQLException);
    } 
  }
  
  public <UO> GenericRawResults<UO> queryRaw(String paramString, RawRowMapper<UO> paramRawRowMapper, String... paramVarArgs) {
    try {
      return this.dao.queryRaw(paramString, paramRawRowMapper, paramVarArgs);
    } catch (SQLException sQLException) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("queryRaw threw exception on: ");
      stringBuilder.append(paramString);
      logMessage(sQLException, stringBuilder.toString());
      throw new RuntimeException(sQLException);
    } 
  }
  
  public <UO> GenericRawResults<UO> queryRaw(String paramString, DataType[] paramArrayOfDataType, RawRowObjectMapper<UO> paramRawRowObjectMapper, String... paramVarArgs) {
    try {
      return this.dao.queryRaw(paramString, paramArrayOfDataType, paramRawRowObjectMapper, paramVarArgs);
    } catch (SQLException sQLException) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("queryRaw threw exception on: ");
      stringBuilder.append(paramString);
      logMessage(sQLException, stringBuilder.toString());
      throw new RuntimeException(sQLException);
    } 
  }
  
  public GenericRawResults<Object[]> queryRaw(String paramString, DataType[] paramArrayOfDataType, String... paramVarArgs) {
    try {
      return this.dao.queryRaw(paramString, paramArrayOfDataType, paramVarArgs);
    } catch (SQLException sQLException) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("queryRaw threw exception on: ");
      stringBuilder.append(paramString);
      logMessage(sQLException, stringBuilder.toString());
      throw new RuntimeException(sQLException);
    } 
  }
  
  public GenericRawResults<String[]> queryRaw(String paramString, String... paramVarArgs) {
    try {
      return this.dao.queryRaw(paramString, paramVarArgs);
    } catch (SQLException sQLException) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("queryRaw threw exception on: ");
      stringBuilder.append(paramString);
      logMessage(sQLException, stringBuilder.toString());
      throw new RuntimeException(sQLException);
    } 
  }
  
  public long queryRawValue(String paramString, String... paramVarArgs) {
    try {
      return this.dao.queryRawValue(paramString, paramVarArgs);
    } catch (SQLException sQLException) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("queryRawValue threw exception on: ");
      stringBuilder.append(paramString);
      logMessage(sQLException, stringBuilder.toString());
      throw new RuntimeException(sQLException);
    } 
  }
  
  public int refresh(T paramT) {
    try {
      return this.dao.refresh(paramT);
    } catch (SQLException sQLException) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("refresh threw exception on: ");
      stringBuilder.append(paramT);
      logMessage(sQLException, stringBuilder.toString());
      throw new RuntimeException(sQLException);
    } 
  }
  
  public void rollBack(DatabaseConnection paramDatabaseConnection) {
    try {
      this.dao.rollBack(paramDatabaseConnection);
      return;
    } catch (SQLException sQLException) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("rollBack(");
      stringBuilder.append(paramDatabaseConnection);
      stringBuilder.append(") threw exception");
      logMessage(sQLException, stringBuilder.toString());
      throw new RuntimeException(sQLException);
    } 
  }
  
  public void setAutoCommit(DatabaseConnection paramDatabaseConnection, boolean paramBoolean) {
    try {
      this.dao.setAutoCommit(paramDatabaseConnection, paramBoolean);
      return;
    } catch (SQLException sQLException) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("setAutoCommit(");
      stringBuilder.append(paramDatabaseConnection);
      stringBuilder.append(",");
      stringBuilder.append(paramBoolean);
      stringBuilder.append(") threw exception");
      logMessage(sQLException, stringBuilder.toString());
      throw new RuntimeException(sQLException);
    } 
  }
  
  @Deprecated
  public void setAutoCommit(boolean paramBoolean) {
    try {
      this.dao.setAutoCommit(paramBoolean);
      return;
    } catch (SQLException sQLException) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("setAutoCommit(");
      stringBuilder.append(paramBoolean);
      stringBuilder.append(") threw exception");
      logMessage(sQLException, stringBuilder.toString());
      throw new RuntimeException(sQLException);
    } 
  }
  
  public void setObjectCache(ObjectCache paramObjectCache) {
    try {
      this.dao.setObjectCache(paramObjectCache);
      return;
    } catch (SQLException sQLException) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("setObjectCache threw exception on ");
      stringBuilder.append(paramObjectCache);
      logMessage(sQLException, stringBuilder.toString());
      throw new RuntimeException(sQLException);
    } 
  }
  
  public void setObjectCache(boolean paramBoolean) {
    try {
      this.dao.setObjectCache(paramBoolean);
      return;
    } catch (SQLException sQLException) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("setObjectCache(");
      stringBuilder.append(paramBoolean);
      stringBuilder.append(") threw exception");
      logMessage(sQLException, stringBuilder.toString());
      throw new RuntimeException(sQLException);
    } 
  }
  
  public void setObjectFactory(ObjectFactory<T> paramObjectFactory) {
    this.dao.setObjectFactory(paramObjectFactory);
  }
  
  public DatabaseConnection startThreadConnection() {
    try {
      return this.dao.startThreadConnection();
    } catch (SQLException sQLException) {
      logMessage(sQLException, "startThreadConnection() threw exception");
      throw new RuntimeException(sQLException);
    } 
  }
  
  public int update(PreparedUpdate<T> paramPreparedUpdate) {
    try {
      return this.dao.update(paramPreparedUpdate);
    } catch (SQLException sQLException) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("update threw exception on: ");
      stringBuilder.append(paramPreparedUpdate);
      logMessage(sQLException, stringBuilder.toString());
      throw new RuntimeException(sQLException);
    } 
  }
  
  public int update(T paramT) {
    try {
      return this.dao.update(paramT);
    } catch (SQLException sQLException) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("update threw exception on: ");
      stringBuilder.append(paramT);
      logMessage(sQLException, stringBuilder.toString());
      throw new RuntimeException(sQLException);
    } 
  }
  
  public UpdateBuilder<T, ID> updateBuilder() {
    return this.dao.updateBuilder();
  }
  
  public int updateId(T paramT, ID paramID) {
    try {
      return this.dao.updateId(paramT, paramID);
    } catch (SQLException sQLException) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("updateId threw exception on: ");
      stringBuilder.append(paramT);
      logMessage(sQLException, stringBuilder.toString());
      throw new RuntimeException(sQLException);
    } 
  }
  
  public int updateRaw(String paramString, String... paramVarArgs) {
    try {
      return this.dao.updateRaw(paramString, paramVarArgs);
    } catch (SQLException sQLException) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("updateRaw threw exception on: ");
      stringBuilder.append(paramString);
      logMessage(sQLException, stringBuilder.toString());
      throw new RuntimeException(sQLException);
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\j256\ormlite\dao\RuntimeExceptionDao.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */