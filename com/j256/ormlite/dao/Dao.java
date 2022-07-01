package com.j256.ormlite.dao;

import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.FieldType;
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
import com.j256.ormlite.table.ObjectFactory;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;

public interface Dao<T, ID> extends CloseableIterable<T> {
  void assignEmptyForeignCollection(T paramT, String paramString) throws SQLException;
  
  <CT> CT callBatchTasks(Callable<CT> paramCallable) throws Exception;
  
  void clearObjectCache();
  
  void closeLastIterator() throws SQLException;
  
  void commit(DatabaseConnection paramDatabaseConnection) throws SQLException;
  
  long countOf() throws SQLException;
  
  long countOf(PreparedQuery<T> paramPreparedQuery) throws SQLException;
  
  int create(T paramT) throws SQLException;
  
  T createIfNotExists(T paramT) throws SQLException;
  
  CreateOrUpdateStatus createOrUpdate(T paramT) throws SQLException;
  
  int delete(PreparedDelete<T> paramPreparedDelete) throws SQLException;
  
  int delete(T paramT) throws SQLException;
  
  int delete(Collection<T> paramCollection) throws SQLException;
  
  DeleteBuilder<T, ID> deleteBuilder();
  
  int deleteById(ID paramID) throws SQLException;
  
  int deleteIds(Collection<ID> paramCollection) throws SQLException;
  
  void endThreadConnection(DatabaseConnection paramDatabaseConnection) throws SQLException;
  
  int executeRaw(String paramString, String... paramVarArgs) throws SQLException;
  
  int executeRawNoArgs(String paramString) throws SQLException;
  
  ID extractId(T paramT) throws SQLException;
  
  FieldType findForeignFieldType(Class<?> paramClass);
  
  ConnectionSource getConnectionSource();
  
  Class<T> getDataClass();
  
  <FT> ForeignCollection<FT> getEmptyForeignCollection(String paramString) throws SQLException;
  
  ObjectCache getObjectCache();
  
  RawRowMapper<T> getRawRowMapper();
  
  GenericRowMapper<T> getSelectStarRowMapper() throws SQLException;
  
  CloseableWrappedIterable<T> getWrappedIterable();
  
  CloseableWrappedIterable<T> getWrappedIterable(PreparedQuery<T> paramPreparedQuery);
  
  boolean idExists(ID paramID) throws SQLException;
  
  @Deprecated
  boolean isAutoCommit() throws SQLException;
  
  boolean isAutoCommit(DatabaseConnection paramDatabaseConnection) throws SQLException;
  
  boolean isTableExists() throws SQLException;
  
  boolean isUpdatable();
  
  CloseableIterator<T> iterator();
  
  CloseableIterator<T> iterator(int paramInt);
  
  CloseableIterator<T> iterator(PreparedQuery<T> paramPreparedQuery) throws SQLException;
  
  CloseableIterator<T> iterator(PreparedQuery<T> paramPreparedQuery, int paramInt) throws SQLException;
  
  T mapSelectStarRow(DatabaseResults paramDatabaseResults) throws SQLException;
  
  String objectToString(T paramT);
  
  boolean objectsEqual(T paramT1, T paramT2) throws SQLException;
  
  List<T> query(PreparedQuery<T> paramPreparedQuery) throws SQLException;
  
  QueryBuilder<T, ID> queryBuilder();
  
  List<T> queryForAll() throws SQLException;
  
  List<T> queryForEq(String paramString, Object paramObject) throws SQLException;
  
  List<T> queryForFieldValues(Map<String, Object> paramMap) throws SQLException;
  
  List<T> queryForFieldValuesArgs(Map<String, Object> paramMap) throws SQLException;
  
  T queryForFirst(PreparedQuery<T> paramPreparedQuery) throws SQLException;
  
  T queryForId(ID paramID) throws SQLException;
  
  List<T> queryForMatching(T paramT) throws SQLException;
  
  List<T> queryForMatchingArgs(T paramT) throws SQLException;
  
  T queryForSameId(T paramT) throws SQLException;
  
  <UO> GenericRawResults<UO> queryRaw(String paramString, RawRowMapper<UO> paramRawRowMapper, String... paramVarArgs) throws SQLException;
  
  <UO> GenericRawResults<UO> queryRaw(String paramString, DataType[] paramArrayOfDataType, RawRowObjectMapper<UO> paramRawRowObjectMapper, String... paramVarArgs) throws SQLException;
  
  GenericRawResults<Object[]> queryRaw(String paramString, DataType[] paramArrayOfDataType, String... paramVarArgs) throws SQLException;
  
  GenericRawResults<String[]> queryRaw(String paramString, String... paramVarArgs) throws SQLException;
  
  long queryRawValue(String paramString, String... paramVarArgs) throws SQLException;
  
  int refresh(T paramT) throws SQLException;
  
  void rollBack(DatabaseConnection paramDatabaseConnection) throws SQLException;
  
  void setAutoCommit(DatabaseConnection paramDatabaseConnection, boolean paramBoolean) throws SQLException;
  
  @Deprecated
  void setAutoCommit(boolean paramBoolean) throws SQLException;
  
  void setObjectCache(ObjectCache paramObjectCache) throws SQLException;
  
  void setObjectCache(boolean paramBoolean) throws SQLException;
  
  void setObjectFactory(ObjectFactory<T> paramObjectFactory);
  
  DatabaseConnection startThreadConnection() throws SQLException;
  
  int update(PreparedUpdate<T> paramPreparedUpdate) throws SQLException;
  
  int update(T paramT) throws SQLException;
  
  UpdateBuilder<T, ID> updateBuilder();
  
  int updateId(T paramT, ID paramID) throws SQLException;
  
  int updateRaw(String paramString, String... paramVarArgs) throws SQLException;
  
  public static class CreateOrUpdateStatus {
    private boolean created;
    
    private int numLinesChanged;
    
    private boolean updated;
    
    public CreateOrUpdateStatus(boolean param1Boolean1, boolean param1Boolean2, int param1Int) {
      this.created = param1Boolean1;
      this.updated = param1Boolean2;
      this.numLinesChanged = param1Int;
    }
    
    public int getNumLinesChanged() {
      return this.numLinesChanged;
    }
    
    public boolean isCreated() {
      return this.created;
    }
    
    public boolean isUpdated() {
      return this.updated;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\j256\ormlite\dao\Dao.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */