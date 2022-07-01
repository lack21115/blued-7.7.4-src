package com.j256.ormlite.stmt;

import com.j256.ormlite.dao.BaseDaoImpl;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.GenericRawResults;
import com.j256.ormlite.dao.ObjectCache;
import com.j256.ormlite.dao.RawRowMapper;
import com.j256.ormlite.dao.RawRowObjectMapper;
import com.j256.ormlite.db.DatabaseType;
import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.field.SqlType;
import com.j256.ormlite.logger.Logger;
import com.j256.ormlite.logger.LoggerFactory;
import com.j256.ormlite.misc.TransactionManager;
import com.j256.ormlite.stmt.mapped.MappedCreate;
import com.j256.ormlite.stmt.mapped.MappedDelete;
import com.j256.ormlite.stmt.mapped.MappedDeleteCollection;
import com.j256.ormlite.stmt.mapped.MappedQueryForId;
import com.j256.ormlite.stmt.mapped.MappedRefresh;
import com.j256.ormlite.stmt.mapped.MappedUpdate;
import com.j256.ormlite.stmt.mapped.MappedUpdateId;
import com.j256.ormlite.support.CompiledStatement;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.support.DatabaseConnection;
import com.j256.ormlite.support.DatabaseResults;
import com.j256.ormlite.table.TableInfo;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;

public class StatementExecutor<T, ID> implements GenericRowMapper<String[]> {
  private static Logger logger = LoggerFactory.getLogger(StatementExecutor.class);
  
  private static final FieldType[] noFieldTypes = new FieldType[0];
  
  private String countStarQuery;
  
  private final Dao<T, ID> dao;
  
  private final DatabaseType databaseType;
  
  private FieldType[] ifExistsFieldTypes;
  
  private String ifExistsQuery;
  
  private MappedDelete<T, ID> mappedDelete;
  
  private MappedCreate<T, ID> mappedInsert;
  
  private MappedQueryForId<T, ID> mappedQueryForId;
  
  private MappedRefresh<T, ID> mappedRefresh;
  
  private MappedUpdate<T, ID> mappedUpdate;
  
  private MappedUpdateId<T, ID> mappedUpdateId;
  
  private PreparedQuery<T> preparedQueryForAll;
  
  private RawRowMapper<T> rawRowMapper;
  
  private final TableInfo<T, ID> tableInfo;
  
  public StatementExecutor(DatabaseType paramDatabaseType, TableInfo<T, ID> paramTableInfo, Dao<T, ID> paramDao) {
    this.databaseType = paramDatabaseType;
    this.tableInfo = paramTableInfo;
    this.dao = paramDao;
  }
  
  private void assignStatementArguments(CompiledStatement paramCompiledStatement, String[] paramArrayOfString) throws SQLException {
    for (int i = 0; i < paramArrayOfString.length; i++)
      paramCompiledStatement.setObject(i, paramArrayOfString[i], SqlType.STRING); 
  }
  
  private void prepareQueryForAll() throws SQLException {
    if (this.preparedQueryForAll == null)
      this.preparedQueryForAll = (new QueryBuilder<T, Object>(this.databaseType, this.tableInfo, this.dao)).prepare(); 
  }
  
  public SelectIterator<T, ID> buildIterator(BaseDaoImpl<T, ID> paramBaseDaoImpl, ConnectionSource paramConnectionSource, int paramInt, ObjectCache paramObjectCache) throws SQLException {
    prepareQueryForAll();
    return buildIterator(paramBaseDaoImpl, paramConnectionSource, this.preparedQueryForAll, paramObjectCache, paramInt);
  }
  
  public SelectIterator<T, ID> buildIterator(BaseDaoImpl<T, ID> paramBaseDaoImpl, ConnectionSource paramConnectionSource, PreparedStmt<T> paramPreparedStmt, ObjectCache paramObjectCache, int paramInt) throws SQLException {
    DatabaseConnection databaseConnection = paramConnectionSource.getReadOnlyConnection();
    try {
      CompiledStatement compiledStatement = paramPreparedStmt.compile(databaseConnection, StatementBuilder.StatementType.SELECT, paramInt);
    } finally {
      paramBaseDaoImpl = null;
    } 
    while (true) {
      if (paramPreparedStmt != null)
        paramPreparedStmt.close(); 
      if (databaseConnection != null)
        paramConnectionSource.releaseConnection(databaseConnection); 
      throw paramBaseDaoImpl;
    } 
    if (databaseConnection != null)
      paramConnectionSource.releaseConnection(databaseConnection); 
    throw paramBaseDaoImpl;
  }
  
  public <CT> CT callBatchTasks(DatabaseConnection paramDatabaseConnection, boolean paramBoolean, Callable<CT> paramCallable) throws SQLException {
    if (this.databaseType.isBatchUseTransaction())
      return (CT)TransactionManager.callInTransaction(paramDatabaseConnection, paramBoolean, this.databaseType, paramCallable); 
    boolean bool1 = false;
    boolean bool = false;
    paramBoolean = bool1;
    try {
      if (paramDatabaseConnection.isAutoCommitSupported()) {
        paramBoolean = bool1;
        bool = paramDatabaseConnection.isAutoCommit();
        if (bool)
          try {
            paramDatabaseConnection.setAutoCommit(false);
            logger.debug("disabled auto-commit on table {} before batch tasks", this.tableInfo.getTableName());
          } finally {
            paramCallable = null;
          }  
      } 
      paramBoolean = bool;
    } finally {
      if (paramBoolean) {
        paramDatabaseConnection.setAutoCommit(true);
        logger.debug("re-enabled auto-commit on table {} after batch tasks", this.tableInfo.getTableName());
      } 
    } 
  }
  
  public int create(DatabaseConnection paramDatabaseConnection, T paramT, ObjectCache paramObjectCache) throws SQLException {
    if (this.mappedInsert == null)
      this.mappedInsert = MappedCreate.build(this.databaseType, this.tableInfo); 
    return this.mappedInsert.insert(this.databaseType, paramDatabaseConnection, paramT, paramObjectCache);
  }
  
  public int delete(DatabaseConnection paramDatabaseConnection, PreparedDelete<T> paramPreparedDelete) throws SQLException {
    CompiledStatement compiledStatement = paramPreparedDelete.compile(paramDatabaseConnection, StatementBuilder.StatementType.DELETE);
    try {
      return compiledStatement.runUpdate();
    } finally {
      compiledStatement.close();
    } 
  }
  
  public int delete(DatabaseConnection paramDatabaseConnection, T paramT, ObjectCache paramObjectCache) throws SQLException {
    if (this.mappedDelete == null)
      this.mappedDelete = MappedDelete.build(this.databaseType, this.tableInfo); 
    return this.mappedDelete.delete(paramDatabaseConnection, paramT, paramObjectCache);
  }
  
  public int deleteById(DatabaseConnection paramDatabaseConnection, ID paramID, ObjectCache paramObjectCache) throws SQLException {
    if (this.mappedDelete == null)
      this.mappedDelete = MappedDelete.build(this.databaseType, this.tableInfo); 
    return this.mappedDelete.deleteById(paramDatabaseConnection, paramID, paramObjectCache);
  }
  
  public int deleteIds(DatabaseConnection paramDatabaseConnection, Collection<ID> paramCollection, ObjectCache paramObjectCache) throws SQLException {
    return MappedDeleteCollection.deleteIds(this.databaseType, this.tableInfo, paramDatabaseConnection, paramCollection, paramObjectCache);
  }
  
  public int deleteObjects(DatabaseConnection paramDatabaseConnection, Collection<T> paramCollection, ObjectCache paramObjectCache) throws SQLException {
    return MappedDeleteCollection.deleteObjects(this.databaseType, this.tableInfo, paramDatabaseConnection, paramCollection, paramObjectCache);
  }
  
  public int executeRaw(DatabaseConnection paramDatabaseConnection, String paramString, String[] paramArrayOfString) throws SQLException {
    logger.debug("running raw execute statement: {}", paramString);
    if (paramArrayOfString.length > 0)
      logger.trace("execute arguments: {}", paramArrayOfString); 
    CompiledStatement compiledStatement = paramDatabaseConnection.compileStatement(paramString, StatementBuilder.StatementType.EXECUTE, noFieldTypes, -1);
    try {
      assignStatementArguments(compiledStatement, paramArrayOfString);
      return compiledStatement.runExecute();
    } finally {
      compiledStatement.close();
    } 
  }
  
  public int executeRawNoArgs(DatabaseConnection paramDatabaseConnection, String paramString) throws SQLException {
    logger.debug("running raw execute statement: {}", paramString);
    return paramDatabaseConnection.executeStatement(paramString, -1);
  }
  
  public RawRowMapper<T> getRawRowMapper() {
    if (this.rawRowMapper == null)
      this.rawRowMapper = new RawRowMapperImpl<T, ID>(this.tableInfo); 
    return this.rawRowMapper;
  }
  
  public GenericRowMapper<T> getSelectStarRowMapper() throws SQLException {
    prepareQueryForAll();
    return this.preparedQueryForAll;
  }
  
  public boolean ifExists(DatabaseConnection paramDatabaseConnection, ID paramID) throws SQLException {
    String str = this.ifExistsQuery;
    boolean bool = false;
    if (str == null) {
      QueryBuilder<T, ID> queryBuilder = new QueryBuilder<T, ID>(this.databaseType, this.tableInfo, this.dao);
      queryBuilder.selectRaw(new String[] { "COUNT(*)" });
      queryBuilder.where().eq(this.tableInfo.getIdField().getColumnName(), new SelectArg());
      this.ifExistsQuery = queryBuilder.prepareStatementString();
      this.ifExistsFieldTypes = new FieldType[] { this.tableInfo.getIdField() };
    } 
    str = this.ifExistsQuery;
    FieldType[] arrayOfFieldType = this.ifExistsFieldTypes;
    long l = paramDatabaseConnection.queryForLong(str, new Object[] { paramID }, arrayOfFieldType);
    logger.debug("query of '{}' returned {}", this.ifExistsQuery, Long.valueOf(l));
    if (l != 0L)
      bool = true; 
    return bool;
  }
  
  public String[] mapRow(DatabaseResults paramDatabaseResults) throws SQLException {
    int j = paramDatabaseResults.getColumnCount();
    String[] arrayOfString = new String[j];
    for (int i = 0; i < j; i++)
      arrayOfString[i] = paramDatabaseResults.getString(i); 
    return arrayOfString;
  }
  
  public List<T> query(ConnectionSource paramConnectionSource, PreparedStmt<T> paramPreparedStmt, ObjectCache paramObjectCache) throws SQLException {
    SelectIterator<T, ID> selectIterator = buildIterator(null, paramConnectionSource, paramPreparedStmt, paramObjectCache, -1);
    try {
      ArrayList<T> arrayList = new ArrayList();
      while (selectIterator.hasNextThrow())
        arrayList.add(selectIterator.nextThrow()); 
      logger.debug("query of '{}' returned {} results", paramPreparedStmt.getStatement(), Integer.valueOf(arrayList.size()));
      return arrayList;
    } finally {
      selectIterator.close();
    } 
  }
  
  public List<T> queryForAll(ConnectionSource paramConnectionSource, ObjectCache paramObjectCache) throws SQLException {
    prepareQueryForAll();
    return query(paramConnectionSource, this.preparedQueryForAll, paramObjectCache);
  }
  
  public long queryForCountStar(DatabaseConnection paramDatabaseConnection) throws SQLException {
    if (this.countStarQuery == null) {
      StringBuilder stringBuilder = new StringBuilder(64);
      stringBuilder.append("SELECT COUNT(*) FROM ");
      this.databaseType.appendEscapedEntityName(stringBuilder, this.tableInfo.getTableName());
      this.countStarQuery = stringBuilder.toString();
    } 
    long l = paramDatabaseConnection.queryForLong(this.countStarQuery);
    logger.debug("query of '{}' returned {}", this.countStarQuery, Long.valueOf(l));
    return l;
  }
  
  public T queryForFirst(DatabaseConnection paramDatabaseConnection, PreparedStmt<T> paramPreparedStmt, ObjectCache paramObjectCache) throws SQLException {
    CompiledStatement compiledStatement = paramPreparedStmt.compile(paramDatabaseConnection, StatementBuilder.StatementType.SELECT);
    try {
      DatabaseResults databaseResults = compiledStatement.runQuery(paramObjectCache);
    } finally {
      paramDatabaseConnection = null;
    } 
    if (paramPreparedStmt != null)
      paramPreparedStmt.close(); 
    compiledStatement.close();
    throw paramDatabaseConnection;
  }
  
  public T queryForId(DatabaseConnection paramDatabaseConnection, ID paramID, ObjectCache paramObjectCache) throws SQLException {
    if (this.mappedQueryForId == null)
      this.mappedQueryForId = MappedQueryForId.build(this.databaseType, this.tableInfo, null); 
    return (T)this.mappedQueryForId.execute(paramDatabaseConnection, paramID, paramObjectCache);
  }
  
  public long queryForLong(DatabaseConnection paramDatabaseConnection, PreparedStmt<T> paramPreparedStmt) throws SQLException {
    DatabaseResults databaseResults;
    CompiledStatement compiledStatement = paramPreparedStmt.compile(paramDatabaseConnection, StatementBuilder.StatementType.SELECT_LONG);
    paramDatabaseConnection = null;
    try {
      DatabaseResults databaseResults1 = compiledStatement.runQuery(null);
      databaseResults = databaseResults1;
      if (databaseResults1.first()) {
        databaseResults = databaseResults1;
        return databaseResults1.getLong(0);
      } 
      databaseResults = databaseResults1;
      StringBuilder stringBuilder = new StringBuilder();
      databaseResults = databaseResults1;
      stringBuilder.append("No result found in queryForLong: ");
      databaseResults = databaseResults1;
      stringBuilder.append(paramPreparedStmt.getStatement());
      databaseResults = databaseResults1;
      throw new SQLException(stringBuilder.toString());
    } finally {
      if (databaseResults != null)
        databaseResults.close(); 
      compiledStatement.close();
    } 
  }
  
  public long queryForLong(DatabaseConnection paramDatabaseConnection, String paramString, String[] paramArrayOfString) throws SQLException {
    StringBuilder stringBuilder1;
    logger.debug("executing raw query for long: {}", paramString);
    if (paramArrayOfString.length > 0)
      logger.trace("query arguments: {}", paramArrayOfString); 
    StringBuilder stringBuilder2 = null;
    DatabaseConnection databaseConnection = null;
    try {
      CompiledStatement compiledStatement = paramDatabaseConnection.compileStatement(paramString, StatementBuilder.StatementType.SELECT, noFieldTypes, -1);
    } finally {
      paramArrayOfString = null;
      paramString = null;
    } 
    if (stringBuilder1 != null)
      stringBuilder1.close(); 
    if (paramString != null)
      paramString.close(); 
    throw paramArrayOfString;
  }
  
  public <UO> GenericRawResults<UO> queryRaw(ConnectionSource paramConnectionSource, String paramString, RawRowMapper<UO> paramRawRowMapper, String[] paramArrayOfString, ObjectCache paramObjectCache) throws SQLException {
    logger.debug("executing raw query for: {}", paramString);
    if (paramArrayOfString.length > 0)
      logger.trace("query arguments: {}", paramArrayOfString); 
    DatabaseConnection databaseConnection = paramConnectionSource.getReadOnlyConnection();
    CompiledStatement compiledStatement = null;
    try {
      CompiledStatement compiledStatement1 = databaseConnection.compileStatement(paramString, StatementBuilder.StatementType.SELECT, noFieldTypes, -1);
      compiledStatement = compiledStatement1;
      return new RawResultsImpl(paramConnectionSource, databaseConnection, paramString, String[].class, compiledStatement1, new UserRawRowMapper(paramRawRowMapper, this), paramObjectCache);
    } finally {
      if (compiledStatement != null)
        compiledStatement.close(); 
      if (databaseConnection != null)
        paramConnectionSource.releaseConnection(databaseConnection); 
    } 
  }
  
  public <UO> GenericRawResults<UO> queryRaw(ConnectionSource paramConnectionSource, String paramString, DataType[] paramArrayOfDataType, RawRowObjectMapper<UO> paramRawRowObjectMapper, String[] paramArrayOfString, ObjectCache paramObjectCache) throws SQLException {
    logger.debug("executing raw query for: {}", paramString);
    if (paramArrayOfString.length > 0)
      logger.trace("query arguments: {}", paramArrayOfString); 
    DatabaseConnection databaseConnection = paramConnectionSource.getReadOnlyConnection();
    try {
      CompiledStatement compiledStatement = databaseConnection.compileStatement(paramString, StatementBuilder.StatementType.SELECT, noFieldTypes, -1);
    } finally {
      paramString = null;
    } 
    if (paramArrayOfDataType != null)
      paramArrayOfDataType.close(); 
    if (databaseConnection != null)
      paramConnectionSource.releaseConnection(databaseConnection); 
    throw paramString;
  }
  
  public GenericRawResults<Object[]> queryRaw(ConnectionSource paramConnectionSource, String paramString, DataType[] paramArrayOfDataType, String[] paramArrayOfString, ObjectCache paramObjectCache) throws SQLException {
    logger.debug("executing raw query for: {}", paramString);
    if (paramArrayOfString.length > 0)
      logger.trace("query arguments: {}", paramArrayOfString); 
    DatabaseConnection databaseConnection = paramConnectionSource.getReadOnlyConnection();
    CompiledStatement compiledStatement = null;
    try {
      CompiledStatement compiledStatement1 = databaseConnection.compileStatement(paramString, StatementBuilder.StatementType.SELECT, noFieldTypes, -1);
      compiledStatement = compiledStatement1;
      return new RawResultsImpl(paramConnectionSource, databaseConnection, paramString, Object[].class, compiledStatement1, new ObjectArrayRowMapper(paramArrayOfDataType), paramObjectCache);
    } finally {
      if (compiledStatement != null)
        compiledStatement.close(); 
      if (databaseConnection != null)
        paramConnectionSource.releaseConnection(databaseConnection); 
    } 
  }
  
  public GenericRawResults<String[]> queryRaw(ConnectionSource paramConnectionSource, String paramString, String[] paramArrayOfString, ObjectCache paramObjectCache) throws SQLException {
    logger.debug("executing raw query for: {}", paramString);
    if (paramArrayOfString.length > 0)
      logger.trace("query arguments: {}", paramArrayOfString); 
    DatabaseConnection databaseConnection = paramConnectionSource.getReadOnlyConnection();
    CompiledStatement compiledStatement = null;
    try {
      CompiledStatement compiledStatement1 = databaseConnection.compileStatement(paramString, StatementBuilder.StatementType.SELECT, noFieldTypes, -1);
      compiledStatement = compiledStatement1;
      return new RawResultsImpl(paramConnectionSource, databaseConnection, paramString, String[].class, compiledStatement1, this, paramObjectCache);
    } finally {
      if (compiledStatement != null)
        compiledStatement.close(); 
      if (databaseConnection != null)
        paramConnectionSource.releaseConnection(databaseConnection); 
    } 
  }
  
  public int refresh(DatabaseConnection paramDatabaseConnection, T paramT, ObjectCache paramObjectCache) throws SQLException {
    if (this.mappedRefresh == null)
      this.mappedRefresh = MappedRefresh.build(this.databaseType, this.tableInfo); 
    return this.mappedRefresh.executeRefresh(paramDatabaseConnection, paramT, paramObjectCache);
  }
  
  public int update(DatabaseConnection paramDatabaseConnection, PreparedUpdate<T> paramPreparedUpdate) throws SQLException {
    CompiledStatement compiledStatement = paramPreparedUpdate.compile(paramDatabaseConnection, StatementBuilder.StatementType.UPDATE);
    try {
      return compiledStatement.runUpdate();
    } finally {
      compiledStatement.close();
    } 
  }
  
  public int update(DatabaseConnection paramDatabaseConnection, T paramT, ObjectCache paramObjectCache) throws SQLException {
    if (this.mappedUpdate == null)
      this.mappedUpdate = MappedUpdate.build(this.databaseType, this.tableInfo); 
    return this.mappedUpdate.update(paramDatabaseConnection, paramT, paramObjectCache);
  }
  
  public int updateId(DatabaseConnection paramDatabaseConnection, T paramT, ID paramID, ObjectCache paramObjectCache) throws SQLException {
    if (this.mappedUpdateId == null)
      this.mappedUpdateId = MappedUpdateId.build(this.databaseType, this.tableInfo); 
    return this.mappedUpdateId.execute(paramDatabaseConnection, paramT, paramID, paramObjectCache);
  }
  
  public int updateRaw(DatabaseConnection paramDatabaseConnection, String paramString, String[] paramArrayOfString) throws SQLException {
    logger.debug("running raw update statement: {}", paramString);
    if (paramArrayOfString.length > 0)
      logger.trace("update arguments: {}", paramArrayOfString); 
    CompiledStatement compiledStatement = paramDatabaseConnection.compileStatement(paramString, StatementBuilder.StatementType.UPDATE, noFieldTypes, -1);
    try {
      assignStatementArguments(compiledStatement, paramArrayOfString);
      return compiledStatement.runUpdate();
    } finally {
      compiledStatement.close();
    } 
  }
  
  static class ObjectArrayRowMapper implements GenericRowMapper<Object[]> {
    private final DataType[] columnTypes;
    
    public ObjectArrayRowMapper(DataType[] param1ArrayOfDataType) {
      this.columnTypes = param1ArrayOfDataType;
    }
    
    public Object[] mapRow(DatabaseResults param1DatabaseResults) throws SQLException {
      int j = param1DatabaseResults.getColumnCount();
      Object[] arrayOfObject = new Object[j];
      for (int i = 0; i < j; i++) {
        DataType dataType;
        DataType[] arrayOfDataType = this.columnTypes;
        if (i >= arrayOfDataType.length) {
          dataType = DataType.STRING;
        } else {
          dataType = dataType[i];
        } 
        arrayOfObject[i] = dataType.getDataPersister().resultToJava(null, param1DatabaseResults, i);
      } 
      return arrayOfObject;
    }
  }
  
  static class UserRawRowMapper<UO> implements GenericRowMapper<UO> {
    private String[] columnNames;
    
    private final RawRowMapper<UO> mapper;
    
    private final GenericRowMapper<String[]> stringRowMapper;
    
    public UserRawRowMapper(RawRowMapper<UO> param1RawRowMapper, GenericRowMapper<String[]> param1GenericRowMapper) {
      this.mapper = param1RawRowMapper;
      this.stringRowMapper = param1GenericRowMapper;
    }
    
    private String[] getColumnNames(DatabaseResults param1DatabaseResults) throws SQLException {
      String[] arrayOfString = this.columnNames;
      if (arrayOfString != null)
        return arrayOfString; 
      this.columnNames = param1DatabaseResults.getColumnNames();
      return this.columnNames;
    }
    
    public UO mapRow(DatabaseResults param1DatabaseResults) throws SQLException {
      String[] arrayOfString = this.stringRowMapper.mapRow(param1DatabaseResults);
      return (UO)this.mapper.mapRow(getColumnNames(param1DatabaseResults), arrayOfString);
    }
  }
  
  static class UserRawRowObjectMapper<UO> implements GenericRowMapper<UO> {
    private String[] columnNames;
    
    private final DataType[] columnTypes;
    
    private final RawRowObjectMapper<UO> mapper;
    
    public UserRawRowObjectMapper(RawRowObjectMapper<UO> param1RawRowObjectMapper, DataType[] param1ArrayOfDataType) {
      this.mapper = param1RawRowObjectMapper;
      this.columnTypes = param1ArrayOfDataType;
    }
    
    private String[] getColumnNames(DatabaseResults param1DatabaseResults) throws SQLException {
      String[] arrayOfString = this.columnNames;
      if (arrayOfString != null)
        return arrayOfString; 
      this.columnNames = param1DatabaseResults.getColumnNames();
      return this.columnNames;
    }
    
    public UO mapRow(DatabaseResults param1DatabaseResults) throws SQLException {
      int j = param1DatabaseResults.getColumnCount();
      Object[] arrayOfObject = new Object[j];
      for (int i = 0; i < j; i++) {
        DataType[] arrayOfDataType = this.columnTypes;
        if (i >= arrayOfDataType.length) {
          arrayOfObject[i] = null;
        } else {
          arrayOfObject[i] = arrayOfDataType[i].getDataPersister().resultToJava(null, param1DatabaseResults, i);
        } 
      } 
      return (UO)this.mapper.mapRow(getColumnNames(param1DatabaseResults), this.columnTypes, arrayOfObject);
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\j256\ormlite\stmt\StatementExecutor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */