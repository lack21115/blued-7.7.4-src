package com.j256.ormlite.stmt;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.db.DatabaseType;
import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.logger.Logger;
import com.j256.ormlite.logger.LoggerFactory;
import com.j256.ormlite.stmt.mapped.MappedPreparedStmt;
import com.j256.ormlite.table.TableInfo;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public abstract class StatementBuilder<T, ID> {
  private static Logger logger = LoggerFactory.getLogger(StatementBuilder.class);
  
  protected boolean addTableName;
  
  protected final Dao<T, ID> dao;
  
  protected final DatabaseType databaseType;
  
  protected final TableInfo<T, ID> tableInfo;
  
  protected final String tableName;
  
  protected StatementType type;
  
  protected Where<T, ID> where = null;
  
  public StatementBuilder(DatabaseType paramDatabaseType, TableInfo<T, ID> paramTableInfo, Dao<T, ID> paramDao, StatementType paramStatementType) {
    this.databaseType = paramDatabaseType;
    this.tableInfo = paramTableInfo;
    this.tableName = paramTableInfo.getTableName();
    this.dao = paramDao;
    this.type = paramStatementType;
    if (paramStatementType.isOkForStatementBuilder())
      return; 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Building a statement from a ");
    stringBuilder.append(paramStatementType);
    stringBuilder.append(" statement is not allowed");
    throw new IllegalStateException(stringBuilder.toString());
  }
  
  protected abstract void appendStatementEnd(StringBuilder paramStringBuilder, List<ArgumentHolder> paramList) throws SQLException;
  
  protected abstract void appendStatementStart(StringBuilder paramStringBuilder, List<ArgumentHolder> paramList) throws SQLException;
  
  protected void appendStatementString(StringBuilder paramStringBuilder, List<ArgumentHolder> paramList) throws SQLException {
    appendStatementStart(paramStringBuilder, paramList);
    appendWhereStatement(paramStringBuilder, paramList, WhereOperation.FIRST);
    appendStatementEnd(paramStringBuilder, paramList);
  }
  
  protected boolean appendWhereStatement(StringBuilder paramStringBuilder, List<ArgumentHolder> paramList, WhereOperation paramWhereOperation) throws SQLException {
    Where<T, ID> where1 = this.where;
    boolean bool = false;
    if (where1 == null) {
      if (paramWhereOperation == WhereOperation.FIRST)
        bool = true; 
      return bool;
    } 
    paramWhereOperation.appendBefore(paramStringBuilder);
    Where<T, ID> where2 = this.where;
    if (this.addTableName) {
      String str = this.tableName;
    } else {
      where1 = null;
    } 
    where2.appendSql((String)where1, paramStringBuilder, paramList);
    paramWhereOperation.appendAfter(paramStringBuilder);
    return false;
  }
  
  protected String buildStatementString(List<ArgumentHolder> paramList) throws SQLException {
    StringBuilder stringBuilder = new StringBuilder(128);
    appendStatementString(stringBuilder, paramList);
    String str = stringBuilder.toString();
    logger.debug("built statement {}", str);
    return str;
  }
  
  @Deprecated
  public void clear() {
    reset();
  }
  
  protected FieldType[] getResultFieldTypes() {
    return null;
  }
  
  StatementType getType() {
    return this.type;
  }
  
  protected MappedPreparedStmt<T, ID> prepareStatement(Long paramLong) throws SQLException {
    ArrayList<ArgumentHolder> arrayList = new ArrayList();
    String str = buildStatementString(arrayList);
    ArgumentHolder[] arrayOfArgumentHolder = arrayList.<ArgumentHolder>toArray(new ArgumentHolder[arrayList.size()]);
    FieldType[] arrayOfFieldType1 = getResultFieldTypes();
    FieldType[] arrayOfFieldType2 = new FieldType[arrayList.size()];
    for (int i = 0; i < arrayOfArgumentHolder.length; i++)
      arrayOfFieldType2[i] = arrayOfArgumentHolder[i].getFieldType(); 
    if (this.type.isOkForStatementBuilder()) {
      TableInfo<T, ID> tableInfo = this.tableInfo;
      if (this.databaseType.isLimitSqlSupported())
        paramLong = null; 
      return new MappedPreparedStmt(tableInfo, str, arrayOfFieldType2, arrayOfFieldType1, arrayOfArgumentHolder, paramLong, this.type);
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Building a statement from a ");
    stringBuilder.append(this.type);
    stringBuilder.append(" statement is not allowed");
    throw new IllegalStateException(stringBuilder.toString());
  }
  
  public StatementInfo prepareStatementInfo() throws SQLException {
    ArrayList<ArgumentHolder> arrayList = new ArrayList();
    return new StatementInfo(buildStatementString(arrayList), arrayList);
  }
  
  public String prepareStatementString() throws SQLException {
    return buildStatementString(new ArrayList<ArgumentHolder>());
  }
  
  public void reset() {
    this.where = null;
  }
  
  public void setWhere(Where<T, ID> paramWhere) {
    this.where = paramWhere;
  }
  
  protected boolean shouldPrependTableNameToColumns() {
    return false;
  }
  
  protected FieldType verifyColumnName(String paramString) {
    return this.tableInfo.getFieldTypeByColumnName(paramString);
  }
  
  public Where<T, ID> where() {
    this.where = new Where<T, ID>(this.tableInfo, this, this.databaseType);
    return this.where;
  }
  
  public static class StatementInfo {
    private final List<ArgumentHolder> argList;
    
    private final String statement;
    
    private StatementInfo(String param1String, List<ArgumentHolder> param1List) {
      this.argList = param1List;
      this.statement = param1String;
    }
    
    public List<ArgumentHolder> getArgList() {
      return this.argList;
    }
    
    public String getStatement() {
      return this.statement;
    }
  }
  
  public enum StatementType {
    DELETE,
    EXECUTE,
    SELECT(true, true, false, false),
    SELECT_LONG(true, true, false, false),
    SELECT_RAW(true, true, false, false),
    UPDATE(true, false, true, false);
    
    private final boolean okForExecute;
    
    private final boolean okForQuery;
    
    private final boolean okForStatementBuilder;
    
    private final boolean okForUpdate;
    
    static {
      $VALUES = new StatementType[] { SELECT, SELECT_LONG, SELECT_RAW, UPDATE, DELETE, EXECUTE };
    }
    
    StatementType(boolean param1Boolean1, boolean param1Boolean2, boolean param1Boolean3, boolean param1Boolean4) {
      this.okForStatementBuilder = param1Boolean1;
      this.okForQuery = param1Boolean2;
      this.okForUpdate = param1Boolean3;
      this.okForExecute = param1Boolean4;
    }
    
    public boolean isOkForExecute() {
      return this.okForExecute;
    }
    
    public boolean isOkForQuery() {
      return this.okForQuery;
    }
    
    public boolean isOkForStatementBuilder() {
      return this.okForStatementBuilder;
    }
    
    public boolean isOkForUpdate() {
      return this.okForUpdate;
    }
  }
  
  public enum WhereOperation {
    FIRST("WHERE ", null),
    OR("WHERE ", null),
    AND(true, false, true, false);
    
    private final String after;
    
    private final String before;
    
    static {
      $VALUES = new WhereOperation[] { FIRST, AND, OR };
    }
    
    WhereOperation(String param1String1, String param1String2) {
      this.before = param1String1;
      this.after = param1String2;
    }
    
    public void appendAfter(StringBuilder param1StringBuilder) {
      String str = this.after;
      if (str != null)
        param1StringBuilder.append(str); 
    }
    
    public void appendBefore(StringBuilder param1StringBuilder) {
      String str = this.before;
      if (str != null)
        param1StringBuilder.append(str); 
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\j256\ormlite\stmt\StatementBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */