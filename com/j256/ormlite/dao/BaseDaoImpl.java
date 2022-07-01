package com.j256.ormlite.dao;

import com.j256.ormlite.db.DatabaseType;
import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.misc.BaseDaoEnabled;
import com.j256.ormlite.misc.SqlExceptionUtil;
import com.j256.ormlite.stmt.DeleteBuilder;
import com.j256.ormlite.stmt.GenericRowMapper;
import com.j256.ormlite.stmt.PreparedDelete;
import com.j256.ormlite.stmt.PreparedQuery;
import com.j256.ormlite.stmt.PreparedStmt;
import com.j256.ormlite.stmt.PreparedUpdate;
import com.j256.ormlite.stmt.QueryBuilder;
import com.j256.ormlite.stmt.SelectArg;
import com.j256.ormlite.stmt.StatementBuilder;
import com.j256.ormlite.stmt.StatementExecutor;
import com.j256.ormlite.stmt.UpdateBuilder;
import com.j256.ormlite.stmt.Where;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.support.DatabaseConnection;
import com.j256.ormlite.support.DatabaseResults;
import com.j256.ormlite.table.DatabaseTableConfig;
import com.j256.ormlite.table.ObjectFactory;
import com.j256.ormlite.table.TableInfo;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;

public abstract class BaseDaoImpl<T, ID> implements Dao<T, ID> {
  private static final ThreadLocal<List<BaseDaoImpl<?, ?>>> daoConfigLevelLocal = new ThreadLocal<List<BaseDaoImpl<?, ?>>>() {
      protected List<BaseDaoImpl<?, ?>> initialValue() {
        return new ArrayList<BaseDaoImpl<?, ?>>(10);
      }
    };
  
  private static ReferenceObjectCache defaultObjectCache;
  
  protected ConnectionSource connectionSource;
  
  protected final Class<T> dataClass;
  
  protected DatabaseType databaseType;
  
  private boolean initialized;
  
  protected CloseableIterator<T> lastIterator;
  
  private ObjectCache objectCache;
  
  protected ObjectFactory<T> objectFactory;
  
  protected StatementExecutor<T, ID> statementExecutor;
  
  protected DatabaseTableConfig<T> tableConfig;
  
  protected TableInfo<T, ID> tableInfo;
  
  protected BaseDaoImpl(ConnectionSource paramConnectionSource, DatabaseTableConfig<T> paramDatabaseTableConfig) throws SQLException {
    this(paramConnectionSource, paramDatabaseTableConfig.getDataClass(), paramDatabaseTableConfig);
  }
  
  protected BaseDaoImpl(ConnectionSource paramConnectionSource, Class<T> paramClass) throws SQLException {
    this(paramConnectionSource, paramClass, null);
  }
  
  private BaseDaoImpl(ConnectionSource paramConnectionSource, Class<T> paramClass, DatabaseTableConfig<T> paramDatabaseTableConfig) throws SQLException {
    this.dataClass = paramClass;
    this.tableConfig = paramDatabaseTableConfig;
    if (paramConnectionSource != null) {
      this.connectionSource = paramConnectionSource;
      initialize();
    } 
  }
  
  protected BaseDaoImpl(Class<T> paramClass) throws SQLException {
    this(null, paramClass, null);
  }
  
  public static void clearAllInternalObjectCaches() {
    // Byte code:
    //   0: ldc com/j256/ormlite/dao/BaseDaoImpl
    //   2: monitorenter
    //   3: getstatic com/j256/ormlite/dao/BaseDaoImpl.defaultObjectCache : Lcom/j256/ormlite/dao/ReferenceObjectCache;
    //   6: ifnull -> 19
    //   9: getstatic com/j256/ormlite/dao/BaseDaoImpl.defaultObjectCache : Lcom/j256/ormlite/dao/ReferenceObjectCache;
    //   12: invokevirtual clearAll : ()V
    //   15: aconst_null
    //   16: putstatic com/j256/ormlite/dao/BaseDaoImpl.defaultObjectCache : Lcom/j256/ormlite/dao/ReferenceObjectCache;
    //   19: ldc com/j256/ormlite/dao/BaseDaoImpl
    //   21: monitorexit
    //   22: return
    //   23: astore_0
    //   24: ldc com/j256/ormlite/dao/BaseDaoImpl
    //   26: monitorexit
    //   27: aload_0
    //   28: athrow
    // Exception table:
    //   from	to	target	type
    //   3	19	23	finally
  }
  
  static <T, ID> Dao<T, ID> createDao(ConnectionSource paramConnectionSource, DatabaseTableConfig<T> paramDatabaseTableConfig) throws SQLException {
    return new BaseDaoImpl<T, ID>(paramConnectionSource, paramDatabaseTableConfig) {
      
      };
  }
  
  static <T, ID> Dao<T, ID> createDao(ConnectionSource paramConnectionSource, Class<T> paramClass) throws SQLException {
    return new BaseDaoImpl<T, ID>(paramConnectionSource, paramClass) {
      
      };
  }
  
  private CloseableIterator<T> createIterator(int paramInt) {
    try {
      return (CloseableIterator<T>)this.statementExecutor.buildIterator(this, this.connectionSource, paramInt, this.objectCache);
    } catch (Exception exception) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Could not build iterator for ");
      stringBuilder.append(this.dataClass);
      throw new IllegalStateException(stringBuilder.toString(), exception);
    } 
  }
  
  private CloseableIterator<T> createIterator(PreparedQuery<T> paramPreparedQuery, int paramInt) throws SQLException {
    try {
      return (CloseableIterator<T>)this.statementExecutor.buildIterator(this, this.connectionSource, (PreparedStmt)paramPreparedQuery, this.objectCache, paramInt);
    } catch (SQLException sQLException) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Could not build prepared-query iterator for ");
      stringBuilder.append(this.dataClass);
      throw SqlExceptionUtil.create(stringBuilder.toString(), sQLException);
    } 
  }
  
  private <FT> ForeignCollection<FT> makeEmptyForeignCollection(T paramT, String paramString) throws SQLException {
    BaseForeignCollection<FT> baseForeignCollection;
    ID iD;
    checkForInitialized();
    if (paramT == null) {
      Object object = null;
    } else {
      iD = extractId(paramT);
    } 
    for (FieldType fieldType : this.tableInfo.getFieldTypes()) {
      if (fieldType.getColumnName().equals(paramString)) {
        baseForeignCollection = fieldType.buildForeignCollection(paramT, iD);
        if (paramT != null)
          fieldType.assignField(paramT, baseForeignCollection, true, null); 
        return baseForeignCollection;
      } 
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Could not find a field named ");
    stringBuilder.append((String)baseForeignCollection);
    throw new IllegalArgumentException(stringBuilder.toString());
  }
  
  private List<T> queryForFieldValues(Map<String, Object> paramMap, boolean paramBoolean) throws SQLException {
    checkForInitialized();
    QueryBuilder<T, ID> queryBuilder = queryBuilder();
    Where where = queryBuilder.where();
    for (Map.Entry<String, Object> entry : paramMap.entrySet()) {
      Object object2 = entry.getValue();
      Object object1 = object2;
      if (paramBoolean)
        object1 = new SelectArg(object2); 
      where.eq((String)entry.getKey(), object1);
    } 
    if (paramMap.size() == 0)
      return Collections.emptyList(); 
    where.and(paramMap.size());
    return queryBuilder.query();
  }
  
  private List<T> queryForMatching(T paramT, boolean paramBoolean) throws SQLException {
    checkForInitialized();
    QueryBuilder<T, ID> queryBuilder = queryBuilder();
    Where where = queryBuilder.where();
    FieldType[] arrayOfFieldType = this.tableInfo.getFieldTypes();
    int k = arrayOfFieldType.length;
    int i = 0;
    int j;
    for (j = 0; i < k; j = m) {
      FieldType fieldType = arrayOfFieldType[i];
      Object object = fieldType.getFieldValueIfNotDefault(paramT);
      int m = j;
      if (object != null) {
        Object object1 = object;
        if (paramBoolean)
          object1 = new SelectArg(object); 
        where.eq(fieldType.getColumnName(), object1);
        m = j + 1;
      } 
      i++;
    } 
    if (j == 0)
      return Collections.emptyList(); 
    where.and(j);
    return queryBuilder.query();
  }
  
  public void assignEmptyForeignCollection(T paramT, String paramString) throws SQLException {
    makeEmptyForeignCollection(paramT, paramString);
  }
  
  public <CT> CT callBatchTasks(Callable<CT> paramCallable) throws SQLException {
    checkForInitialized();
    DatabaseConnection databaseConnection = this.connectionSource.getReadWriteConnection();
    try {
      boolean bool = this.connectionSource.saveSpecialConnection(databaseConnection);
      return (CT)this.statementExecutor.callBatchTasks(databaseConnection, bool, paramCallable);
    } finally {
      this.connectionSource.clearSpecialConnection(databaseConnection);
      this.connectionSource.releaseConnection(databaseConnection);
    } 
  }
  
  protected void checkForInitialized() {
    if (this.initialized)
      return; 
    throw new IllegalStateException("you must call initialize() before you can use the dao");
  }
  
  public void clearObjectCache() {
    ObjectCache objectCache = this.objectCache;
    if (objectCache != null)
      objectCache.clear(this.dataClass); 
  }
  
  public void closeLastIterator() throws SQLException {
    CloseableIterator<T> closeableIterator = this.lastIterator;
    if (closeableIterator != null) {
      closeableIterator.close();
      this.lastIterator = null;
    } 
  }
  
  public CloseableIterator<T> closeableIterator() {
    return iterator(-1);
  }
  
  public void commit(DatabaseConnection paramDatabaseConnection) throws SQLException {
    paramDatabaseConnection.commit(null);
  }
  
  public long countOf() throws SQLException {
    checkForInitialized();
    DatabaseConnection databaseConnection = this.connectionSource.getReadOnlyConnection();
    try {
      return this.statementExecutor.queryForCountStar(databaseConnection);
    } finally {
      this.connectionSource.releaseConnection(databaseConnection);
    } 
  }
  
  public long countOf(PreparedQuery<T> paramPreparedQuery) throws SQLException {
    checkForInitialized();
    if (paramPreparedQuery.getType() == StatementBuilder.StatementType.SELECT_LONG) {
      DatabaseConnection databaseConnection = this.connectionSource.getReadOnlyConnection();
      try {
        return this.statementExecutor.queryForLong(databaseConnection, (PreparedStmt)paramPreparedQuery);
      } finally {
        this.connectionSource.releaseConnection(databaseConnection);
      } 
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Prepared query is not of type ");
    stringBuilder.append(StatementBuilder.StatementType.SELECT_LONG);
    stringBuilder.append(", did you call QueryBuilder.setCountOf(true)?");
    throw new IllegalArgumentException(stringBuilder.toString());
  }
  
  public int create(T paramT) throws SQLException {
    checkForInitialized();
    if (paramT == null)
      return 0; 
    if (paramT instanceof BaseDaoEnabled)
      ((BaseDaoEnabled)paramT).setDao(this); 
    DatabaseConnection databaseConnection = this.connectionSource.getReadWriteConnection();
    try {
      return this.statementExecutor.create(databaseConnection, paramT, this.objectCache);
    } finally {
      this.connectionSource.releaseConnection(databaseConnection);
    } 
  }
  
  public T createIfNotExists(T paramT) throws SQLException {
    if (paramT == null)
      return null; 
    T t = queryForSameId(paramT);
    if (t == null) {
      create(paramT);
      return paramT;
    } 
    return t;
  }
  
  public Dao.CreateOrUpdateStatus createOrUpdate(T paramT) throws SQLException {
    if (paramT == null)
      return new Dao.CreateOrUpdateStatus(false, false, 0); 
    ID iD = extractId(paramT);
    return (iD == null || !idExists(iD)) ? new Dao.CreateOrUpdateStatus(true, false, create(paramT)) : new Dao.CreateOrUpdateStatus(false, true, update(paramT));
  }
  
  public int delete(PreparedDelete<T> paramPreparedDelete) throws SQLException {
    checkForInitialized();
    DatabaseConnection databaseConnection = this.connectionSource.getReadWriteConnection();
    try {
      return this.statementExecutor.delete(databaseConnection, paramPreparedDelete);
    } finally {
      this.connectionSource.releaseConnection(databaseConnection);
    } 
  }
  
  public int delete(T paramT) throws SQLException {
    checkForInitialized();
    if (paramT == null)
      return 0; 
    DatabaseConnection databaseConnection = this.connectionSource.getReadWriteConnection();
    try {
      return this.statementExecutor.delete(databaseConnection, paramT, this.objectCache);
    } finally {
      this.connectionSource.releaseConnection(databaseConnection);
    } 
  }
  
  public int delete(Collection<T> paramCollection) throws SQLException {
    checkForInitialized();
    if (paramCollection == null || paramCollection.isEmpty())
      return 0; 
    DatabaseConnection databaseConnection = this.connectionSource.getReadWriteConnection();
    try {
      return this.statementExecutor.deleteObjects(databaseConnection, paramCollection, this.objectCache);
    } finally {
      this.connectionSource.releaseConnection(databaseConnection);
    } 
  }
  
  public DeleteBuilder<T, ID> deleteBuilder() {
    checkForInitialized();
    return new DeleteBuilder(this.databaseType, this.tableInfo, this);
  }
  
  public int deleteById(ID paramID) throws SQLException {
    checkForInitialized();
    if (paramID == null)
      return 0; 
    DatabaseConnection databaseConnection = this.connectionSource.getReadWriteConnection();
    try {
      return this.statementExecutor.deleteById(databaseConnection, paramID, this.objectCache);
    } finally {
      this.connectionSource.releaseConnection(databaseConnection);
    } 
  }
  
  public int deleteIds(Collection<ID> paramCollection) throws SQLException {
    checkForInitialized();
    if (paramCollection == null || paramCollection.isEmpty())
      return 0; 
    DatabaseConnection databaseConnection = this.connectionSource.getReadWriteConnection();
    try {
      return this.statementExecutor.deleteIds(databaseConnection, paramCollection, this.objectCache);
    } finally {
      this.connectionSource.releaseConnection(databaseConnection);
    } 
  }
  
  public void endThreadConnection(DatabaseConnection paramDatabaseConnection) throws SQLException {
    this.connectionSource.clearSpecialConnection(paramDatabaseConnection);
    this.connectionSource.releaseConnection(paramDatabaseConnection);
  }
  
  public int executeRaw(String paramString, String... paramVarArgs) throws SQLException {
    checkForInitialized();
    DatabaseConnection databaseConnection = this.connectionSource.getReadWriteConnection();
    try {
      int i = this.statementExecutor.executeRaw(databaseConnection, paramString, paramVarArgs);
      this.connectionSource.releaseConnection(databaseConnection);
      return i;
    } catch (SQLException sQLException) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Could not run raw execute statement ");
      stringBuilder.append(paramString);
      throw SqlExceptionUtil.create(stringBuilder.toString(), sQLException);
    } finally {}
    this.connectionSource.releaseConnection(databaseConnection);
    throw paramString;
  }
  
  public int executeRawNoArgs(String paramString) throws SQLException {
    checkForInitialized();
    DatabaseConnection databaseConnection = this.connectionSource.getReadWriteConnection();
    try {
      int i = this.statementExecutor.executeRawNoArgs(databaseConnection, paramString);
      this.connectionSource.releaseConnection(databaseConnection);
      return i;
    } catch (SQLException sQLException) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Could not run raw execute statement ");
      stringBuilder.append(paramString);
      throw SqlExceptionUtil.create(stringBuilder.toString(), sQLException);
    } finally {}
    this.connectionSource.releaseConnection(databaseConnection);
    throw paramString;
  }
  
  public ID extractId(T paramT) throws SQLException {
    checkForInitialized();
    FieldType fieldType = this.tableInfo.getIdField();
    if (fieldType != null)
      return (ID)fieldType.extractJavaFieldValue(paramT); 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Class ");
    stringBuilder.append(this.dataClass);
    stringBuilder.append(" does not have an id field");
    throw new SQLException(stringBuilder.toString());
  }
  
  public FieldType findForeignFieldType(Class<?> paramClass) {
    checkForInitialized();
    for (FieldType fieldType : this.tableInfo.getFieldTypes()) {
      if (fieldType.getType() == paramClass)
        return fieldType; 
    } 
    return null;
  }
  
  public ConnectionSource getConnectionSource() {
    return this.connectionSource;
  }
  
  public Class<T> getDataClass() {
    return this.dataClass;
  }
  
  public <FT> ForeignCollection<FT> getEmptyForeignCollection(String paramString) throws SQLException {
    return makeEmptyForeignCollection(null, paramString);
  }
  
  public ObjectCache getObjectCache() {
    return this.objectCache;
  }
  
  public ObjectFactory<T> getObjectFactory() {
    return this.objectFactory;
  }
  
  public RawRowMapper<T> getRawRowMapper() {
    return this.statementExecutor.getRawRowMapper();
  }
  
  public GenericRowMapper<T> getSelectStarRowMapper() throws SQLException {
    return this.statementExecutor.getSelectStarRowMapper();
  }
  
  public DatabaseTableConfig<T> getTableConfig() {
    return this.tableConfig;
  }
  
  public TableInfo<T, ID> getTableInfo() {
    return this.tableInfo;
  }
  
  public CloseableWrappedIterable<T> getWrappedIterable() {
    checkForInitialized();
    return new CloseableWrappedIterableImpl<T>(new CloseableIterable<T>() {
          public CloseableIterator<T> closeableIterator() {
            try {
              return BaseDaoImpl.this.createIterator(-1);
            } catch (Exception exception) {
              StringBuilder stringBuilder = new StringBuilder();
              stringBuilder.append("Could not build iterator for ");
              stringBuilder.append(BaseDaoImpl.this.dataClass);
              throw new IllegalStateException(stringBuilder.toString(), exception);
            } 
          }
          
          public Iterator<T> iterator() {
            return closeableIterator();
          }
        });
  }
  
  public CloseableWrappedIterable<T> getWrappedIterable(final PreparedQuery<T> preparedQuery) {
    checkForInitialized();
    return new CloseableWrappedIterableImpl<T>(new CloseableIterable<T>() {
          public CloseableIterator<T> closeableIterator() {
            try {
              return BaseDaoImpl.this.createIterator(preparedQuery, -1);
            } catch (Exception exception) {
              StringBuilder stringBuilder = new StringBuilder();
              stringBuilder.append("Could not build prepared-query iterator for ");
              stringBuilder.append(BaseDaoImpl.this.dataClass);
              throw new IllegalStateException(stringBuilder.toString(), exception);
            } 
          }
          
          public Iterator<T> iterator() {
            return closeableIterator();
          }
        });
  }
  
  public boolean idExists(ID paramID) throws SQLException {
    DatabaseConnection databaseConnection = this.connectionSource.getReadOnlyConnection();
    try {
      return this.statementExecutor.ifExists(databaseConnection, paramID);
    } finally {
      this.connectionSource.releaseConnection(databaseConnection);
    } 
  }
  
  public void initialize() throws SQLException {
    if (this.initialized)
      return; 
    ConnectionSource connectionSource = this.connectionSource;
    if (connectionSource != null) {
      this.databaseType = connectionSource.getDatabaseType();
      if (this.databaseType != null) {
        DatabaseTableConfig<T> databaseTableConfig = this.tableConfig;
        if (databaseTableConfig == null) {
          this.tableInfo = new TableInfo(this.connectionSource, this, this.dataClass);
        } else {
          databaseTableConfig.extractFieldTypes(this.connectionSource);
          this.tableInfo = new TableInfo(this.databaseType, this, this.tableConfig);
        } 
        this.statementExecutor = new StatementExecutor(this.databaseType, this.tableInfo, this);
        List<BaseDaoImpl> list = (List)daoConfigLevelLocal.get();
        list.add(this);
        if (list.size() > 1)
          return; 
        int i = 0;
        try {
          while (i < list.size()) {
            BaseDaoImpl<?, ?> baseDaoImpl = list.get(i);
            DaoManager.registerDao(this.connectionSource, baseDaoImpl);
            try {
              FieldType[] arrayOfFieldType = baseDaoImpl.getTableInfo().getFieldTypes();
              int k = arrayOfFieldType.length;
              for (int j = 0; j < k; j++)
                arrayOfFieldType[j].configDaoInformation(this.connectionSource, baseDaoImpl.getDataClass()); 
              baseDaoImpl.initialized = true;
              i++;
            } catch (SQLException sQLException) {
              DaoManager.unregisterDao(this.connectionSource, baseDaoImpl);
              throw sQLException;
            } 
          } 
          return;
        } finally {
          list.clear();
          daoConfigLevelLocal.remove();
        } 
      } 
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append("connectionSource is getting a null DatabaseType in ");
      stringBuilder1.append(getClass().getSimpleName());
      throw new IllegalStateException(stringBuilder1.toString());
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("connectionSource was never set on ");
    stringBuilder.append(getClass().getSimpleName());
    throw new IllegalStateException(stringBuilder.toString());
  }
  
  public boolean isAutoCommit() throws SQLException {
    DatabaseConnection databaseConnection = this.connectionSource.getReadWriteConnection();
    try {
      return isAutoCommit(databaseConnection);
    } finally {
      this.connectionSource.releaseConnection(databaseConnection);
    } 
  }
  
  public boolean isAutoCommit(DatabaseConnection paramDatabaseConnection) throws SQLException {
    return paramDatabaseConnection.isAutoCommit();
  }
  
  public boolean isTableExists() throws SQLException {
    checkForInitialized();
    DatabaseConnection databaseConnection = this.connectionSource.getReadOnlyConnection();
    try {
      return databaseConnection.isTableExists(this.tableInfo.getTableName());
    } finally {
      this.connectionSource.releaseConnection(databaseConnection);
    } 
  }
  
  public boolean isUpdatable() {
    return this.tableInfo.isUpdatable();
  }
  
  public CloseableIterator<T> iterator() {
    return iterator(-1);
  }
  
  public CloseableIterator<T> iterator(int paramInt) {
    checkForInitialized();
    this.lastIterator = createIterator(paramInt);
    return this.lastIterator;
  }
  
  public CloseableIterator<T> iterator(PreparedQuery<T> paramPreparedQuery) throws SQLException {
    return iterator(paramPreparedQuery, -1);
  }
  
  public CloseableIterator<T> iterator(PreparedQuery<T> paramPreparedQuery, int paramInt) throws SQLException {
    checkForInitialized();
    this.lastIterator = createIterator(paramPreparedQuery, paramInt);
    return this.lastIterator;
  }
  
  public T mapSelectStarRow(DatabaseResults paramDatabaseResults) throws SQLException {
    return (T)this.statementExecutor.getSelectStarRowMapper().mapRow(paramDatabaseResults);
  }
  
  public String objectToString(T paramT) {
    checkForInitialized();
    return this.tableInfo.objectToString(paramT);
  }
  
  public boolean objectsEqual(T paramT1, T paramT2) throws SQLException {
    checkForInitialized();
    for (FieldType fieldType : this.tableInfo.getFieldTypes()) {
      Object object1 = fieldType.extractJavaFieldValue(paramT1);
      Object object2 = fieldType.extractJavaFieldValue(paramT2);
      if (!fieldType.getDataPersister().dataIsEqual(object1, object2))
        return false; 
    } 
    return true;
  }
  
  public List<T> query(PreparedQuery<T> paramPreparedQuery) throws SQLException {
    checkForInitialized();
    return this.statementExecutor.query(this.connectionSource, (PreparedStmt)paramPreparedQuery, this.objectCache);
  }
  
  public QueryBuilder<T, ID> queryBuilder() {
    checkForInitialized();
    return new QueryBuilder(this.databaseType, this.tableInfo, this);
  }
  
  public List<T> queryForAll() throws SQLException {
    checkForInitialized();
    return this.statementExecutor.queryForAll(this.connectionSource, this.objectCache);
  }
  
  public List<T> queryForEq(String paramString, Object paramObject) throws SQLException {
    return queryBuilder().where().eq(paramString, paramObject).query();
  }
  
  public List<T> queryForFieldValues(Map<String, Object> paramMap) throws SQLException {
    return queryForFieldValues(paramMap, false);
  }
  
  public List<T> queryForFieldValuesArgs(Map<String, Object> paramMap) throws SQLException {
    return queryForFieldValues(paramMap, true);
  }
  
  public T queryForFirst(PreparedQuery<T> paramPreparedQuery) throws SQLException {
    checkForInitialized();
    DatabaseConnection databaseConnection = this.connectionSource.getReadOnlyConnection();
    try {
      return (T)this.statementExecutor.queryForFirst(databaseConnection, (PreparedStmt)paramPreparedQuery, this.objectCache);
    } finally {
      this.connectionSource.releaseConnection(databaseConnection);
    } 
  }
  
  public T queryForId(ID paramID) throws SQLException {
    checkForInitialized();
    DatabaseConnection databaseConnection = this.connectionSource.getReadOnlyConnection();
    try {
      paramID = (ID)this.statementExecutor.queryForId(databaseConnection, paramID, this.objectCache);
      return (T)paramID;
    } finally {
      this.connectionSource.releaseConnection(databaseConnection);
    } 
  }
  
  public List<T> queryForMatching(T paramT) throws SQLException {
    return queryForMatching(paramT, false);
  }
  
  public List<T> queryForMatchingArgs(T paramT) throws SQLException {
    return queryForMatching(paramT, true);
  }
  
  public T queryForSameId(T paramT) throws SQLException {
    checkForInitialized();
    if (paramT == null)
      return null; 
    paramT = (T)extractId(paramT);
    return (paramT == null) ? null : queryForId((ID)paramT);
  }
  
  public <GR> GenericRawResults<GR> queryRaw(String paramString, RawRowMapper<GR> paramRawRowMapper, String... paramVarArgs) throws SQLException {
    checkForInitialized();
    try {
      return this.statementExecutor.queryRaw(this.connectionSource, paramString, paramRawRowMapper, paramVarArgs, this.objectCache);
    } catch (SQLException sQLException) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Could not perform raw query for ");
      stringBuilder.append(paramString);
      throw SqlExceptionUtil.create(stringBuilder.toString(), sQLException);
    } 
  }
  
  public <UO> GenericRawResults<UO> queryRaw(String paramString, DataType[] paramArrayOfDataType, RawRowObjectMapper<UO> paramRawRowObjectMapper, String... paramVarArgs) throws SQLException {
    checkForInitialized();
    try {
      return this.statementExecutor.queryRaw(this.connectionSource, paramString, paramArrayOfDataType, paramRawRowObjectMapper, paramVarArgs, this.objectCache);
    } catch (SQLException sQLException) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Could not perform raw query for ");
      stringBuilder.append(paramString);
      throw SqlExceptionUtil.create(stringBuilder.toString(), sQLException);
    } 
  }
  
  public GenericRawResults<Object[]> queryRaw(String paramString, DataType[] paramArrayOfDataType, String... paramVarArgs) throws SQLException {
    checkForInitialized();
    try {
      return this.statementExecutor.queryRaw(this.connectionSource, paramString, paramArrayOfDataType, paramVarArgs, this.objectCache);
    } catch (SQLException sQLException) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Could not perform raw query for ");
      stringBuilder.append(paramString);
      throw SqlExceptionUtil.create(stringBuilder.toString(), sQLException);
    } 
  }
  
  public GenericRawResults<String[]> queryRaw(String paramString, String... paramVarArgs) throws SQLException {
    checkForInitialized();
    try {
      return this.statementExecutor.queryRaw(this.connectionSource, paramString, paramVarArgs, this.objectCache);
    } catch (SQLException sQLException) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Could not perform raw query for ");
      stringBuilder.append(paramString);
      throw SqlExceptionUtil.create(stringBuilder.toString(), sQLException);
    } 
  }
  
  public long queryRawValue(String paramString, String... paramVarArgs) throws SQLException {
    checkForInitialized();
    DatabaseConnection databaseConnection = this.connectionSource.getReadOnlyConnection();
    try {
      long l = this.statementExecutor.queryForLong(databaseConnection, paramString, paramVarArgs);
      this.connectionSource.releaseConnection(databaseConnection);
      return l;
    } catch (SQLException sQLException) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Could not perform raw value query for ");
      stringBuilder.append(paramString);
      throw SqlExceptionUtil.create(stringBuilder.toString(), sQLException);
    } finally {}
    this.connectionSource.releaseConnection(databaseConnection);
    throw paramString;
  }
  
  public int refresh(T paramT) throws SQLException {
    checkForInitialized();
    if (paramT == null)
      return 0; 
    if (paramT instanceof BaseDaoEnabled)
      ((BaseDaoEnabled)paramT).setDao(this); 
    DatabaseConnection databaseConnection = this.connectionSource.getReadOnlyConnection();
    try {
      return this.statementExecutor.refresh(databaseConnection, paramT, this.objectCache);
    } finally {
      this.connectionSource.releaseConnection(databaseConnection);
    } 
  }
  
  public void rollBack(DatabaseConnection paramDatabaseConnection) throws SQLException {
    paramDatabaseConnection.rollback(null);
  }
  
  public void setAutoCommit(DatabaseConnection paramDatabaseConnection, boolean paramBoolean) throws SQLException {
    paramDatabaseConnection.setAutoCommit(paramBoolean);
  }
  
  public void setAutoCommit(boolean paramBoolean) throws SQLException {
    DatabaseConnection databaseConnection = this.connectionSource.getReadWriteConnection();
    try {
      setAutoCommit(databaseConnection, paramBoolean);
      return;
    } finally {
      this.connectionSource.releaseConnection(databaseConnection);
    } 
  }
  
  public void setConnectionSource(ConnectionSource paramConnectionSource) {
    this.connectionSource = paramConnectionSource;
  }
  
  public void setObjectCache(ObjectCache paramObjectCache) throws SQLException {
    if (paramObjectCache == null) {
      paramObjectCache = this.objectCache;
      if (paramObjectCache != null) {
        paramObjectCache.clear(this.dataClass);
        this.objectCache = null;
        return;
      } 
    } else {
      ObjectCache objectCache = this.objectCache;
      if (objectCache != null && objectCache != paramObjectCache)
        objectCache.clear(this.dataClass); 
      if (this.tableInfo.getIdField() != null) {
        this.objectCache = paramObjectCache;
        this.objectCache.registerClass(this.dataClass);
        return;
      } 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Class ");
      stringBuilder.append(this.dataClass);
      stringBuilder.append(" must have an id field to enable the object cache");
      throw new SQLException(stringBuilder.toString());
    } 
  }
  
  public void setObjectCache(boolean paramBoolean) throws SQLException {
    // Byte code:
    //   0: iload_1
    //   1: ifeq -> 111
    //   4: aload_0
    //   5: getfield objectCache : Lcom/j256/ormlite/dao/ObjectCache;
    //   8: ifnonnull -> 135
    //   11: aload_0
    //   12: getfield tableInfo : Lcom/j256/ormlite/table/TableInfo;
    //   15: invokevirtual getIdField : ()Lcom/j256/ormlite/field/FieldType;
    //   18: ifnull -> 66
    //   21: ldc com/j256/ormlite/dao/BaseDaoImpl
    //   23: monitorenter
    //   24: getstatic com/j256/ormlite/dao/BaseDaoImpl.defaultObjectCache : Lcom/j256/ormlite/dao/ReferenceObjectCache;
    //   27: ifnonnull -> 36
    //   30: invokestatic makeWeakCache : ()Lcom/j256/ormlite/dao/ReferenceObjectCache;
    //   33: putstatic com/j256/ormlite/dao/BaseDaoImpl.defaultObjectCache : Lcom/j256/ormlite/dao/ReferenceObjectCache;
    //   36: aload_0
    //   37: getstatic com/j256/ormlite/dao/BaseDaoImpl.defaultObjectCache : Lcom/j256/ormlite/dao/ReferenceObjectCache;
    //   40: putfield objectCache : Lcom/j256/ormlite/dao/ObjectCache;
    //   43: ldc com/j256/ormlite/dao/BaseDaoImpl
    //   45: monitorexit
    //   46: aload_0
    //   47: getfield objectCache : Lcom/j256/ormlite/dao/ObjectCache;
    //   50: aload_0
    //   51: getfield dataClass : Ljava/lang/Class;
    //   54: invokeinterface registerClass : (Ljava/lang/Class;)V
    //   59: return
    //   60: astore_2
    //   61: ldc com/j256/ormlite/dao/BaseDaoImpl
    //   63: monitorexit
    //   64: aload_2
    //   65: athrow
    //   66: new java/lang/StringBuilder
    //   69: dup
    //   70: invokespecial <init> : ()V
    //   73: astore_2
    //   74: aload_2
    //   75: ldc_w 'Class '
    //   78: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   81: pop
    //   82: aload_2
    //   83: aload_0
    //   84: getfield dataClass : Ljava/lang/Class;
    //   87: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   90: pop
    //   91: aload_2
    //   92: ldc_w ' must have an id field to enable the object cache'
    //   95: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   98: pop
    //   99: new java/sql/SQLException
    //   102: dup
    //   103: aload_2
    //   104: invokevirtual toString : ()Ljava/lang/String;
    //   107: invokespecial <init> : (Ljava/lang/String;)V
    //   110: athrow
    //   111: aload_0
    //   112: getfield objectCache : Lcom/j256/ormlite/dao/ObjectCache;
    //   115: astore_2
    //   116: aload_2
    //   117: ifnull -> 135
    //   120: aload_2
    //   121: aload_0
    //   122: getfield dataClass : Ljava/lang/Class;
    //   125: invokeinterface clear : (Ljava/lang/Class;)V
    //   130: aload_0
    //   131: aconst_null
    //   132: putfield objectCache : Lcom/j256/ormlite/dao/ObjectCache;
    //   135: return
    // Exception table:
    //   from	to	target	type
    //   24	36	60	finally
    //   36	46	60	finally
    //   61	64	60	finally
  }
  
  public void setObjectFactory(ObjectFactory<T> paramObjectFactory) {
    checkForInitialized();
    this.objectFactory = paramObjectFactory;
  }
  
  public void setTableConfig(DatabaseTableConfig<T> paramDatabaseTableConfig) {
    this.tableConfig = paramDatabaseTableConfig;
  }
  
  public DatabaseConnection startThreadConnection() throws SQLException {
    DatabaseConnection databaseConnection = this.connectionSource.getReadWriteConnection();
    this.connectionSource.saveSpecialConnection(databaseConnection);
    return databaseConnection;
  }
  
  public int update(PreparedUpdate<T> paramPreparedUpdate) throws SQLException {
    checkForInitialized();
    DatabaseConnection databaseConnection = this.connectionSource.getReadWriteConnection();
    try {
      return this.statementExecutor.update(databaseConnection, paramPreparedUpdate);
    } finally {
      this.connectionSource.releaseConnection(databaseConnection);
    } 
  }
  
  public int update(T paramT) throws SQLException {
    checkForInitialized();
    if (paramT == null)
      return 0; 
    DatabaseConnection databaseConnection = this.connectionSource.getReadWriteConnection();
    try {
      return this.statementExecutor.update(databaseConnection, paramT, this.objectCache);
    } finally {
      this.connectionSource.releaseConnection(databaseConnection);
    } 
  }
  
  public UpdateBuilder<T, ID> updateBuilder() {
    checkForInitialized();
    return new UpdateBuilder(this.databaseType, this.tableInfo, this);
  }
  
  public int updateId(T paramT, ID paramID) throws SQLException {
    checkForInitialized();
    if (paramT == null)
      return 0; 
    DatabaseConnection databaseConnection = this.connectionSource.getReadWriteConnection();
    try {
      return this.statementExecutor.updateId(databaseConnection, paramT, paramID, this.objectCache);
    } finally {
      this.connectionSource.releaseConnection(databaseConnection);
    } 
  }
  
  public int updateRaw(String paramString, String... paramVarArgs) throws SQLException {
    checkForInitialized();
    DatabaseConnection databaseConnection = this.connectionSource.getReadWriteConnection();
    try {
      int i = this.statementExecutor.updateRaw(databaseConnection, paramString, paramVarArgs);
      this.connectionSource.releaseConnection(databaseConnection);
      return i;
    } catch (SQLException sQLException) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Could not run raw update statement ");
      stringBuilder.append(paramString);
      throw SqlExceptionUtil.create(stringBuilder.toString(), sQLException);
    } finally {}
    this.connectionSource.releaseConnection(databaseConnection);
    throw paramString;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\j256\ormlite\dao\BaseDaoImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */