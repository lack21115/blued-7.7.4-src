package com.j256.ormlite.stmt.mapped;

import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.field.SqlType;
import com.j256.ormlite.stmt.ArgumentHolder;
import com.j256.ormlite.stmt.PreparedDelete;
import com.j256.ormlite.stmt.PreparedQuery;
import com.j256.ormlite.stmt.PreparedUpdate;
import com.j256.ormlite.stmt.StatementBuilder;
import com.j256.ormlite.support.CompiledStatement;
import com.j256.ormlite.support.DatabaseConnection;
import com.j256.ormlite.table.TableInfo;
import java.sql.SQLException;

public class MappedPreparedStmt<T, ID> extends BaseMappedQuery<T, ID> implements PreparedDelete<T>, PreparedQuery<T>, PreparedUpdate<T> {
  private final ArgumentHolder[] argHolders;
  
  private final Long limit;
  
  private final StatementBuilder.StatementType type;
  
  public MappedPreparedStmt(TableInfo<T, ID> paramTableInfo, String paramString, FieldType[] paramArrayOfFieldType1, FieldType[] paramArrayOfFieldType2, ArgumentHolder[] paramArrayOfArgumentHolder, Long paramLong, StatementBuilder.StatementType paramStatementType) {
    super(paramTableInfo, paramString, paramArrayOfFieldType1, paramArrayOfFieldType2);
    this.argHolders = paramArrayOfArgumentHolder;
    this.limit = paramLong;
    this.type = paramStatementType;
  }
  
  private CompiledStatement assignStatementArguments(CompiledStatement paramCompiledStatement) throws SQLException {
    try {
      if (this.limit != null)
        paramCompiledStatement.setMaxRows(this.limit.intValue()); 
      Object[] arrayOfObject2 = null;
      Object[] arrayOfObject1 = arrayOfObject2;
    } finally {
      paramCompiledStatement.close();
    } 
    for (int i = 0;; i++) {
      if (i < this.argHolders.length) {
        SqlType sqlType;
        Object object = this.argHolders[i].getSqlArgValue();
        FieldType fieldType = this.argFieldTypes[i];
        if (fieldType == null) {
          sqlType = this.argHolders[i].getSqlType();
        } else {
          sqlType = sqlType.getSqlType();
        } 
        paramCompiledStatement.setObject(i, object, sqlType);
        if (SYNTHETIC_LOCAL_VARIABLE_3 != null)
          SYNTHETIC_LOCAL_VARIABLE_3[i] = object; 
      } else {
        logger.debug("prepared statement '{}' with {} args", this.statement, Integer.valueOf(this.argHolders.length));
        if (SYNTHETIC_LOCAL_VARIABLE_3 != null)
          logger.trace("prepared statement arguments: {}", SYNTHETIC_LOCAL_VARIABLE_3); 
        return paramCompiledStatement;
      } 
    } 
  }
  
  public CompiledStatement compile(DatabaseConnection paramDatabaseConnection, StatementBuilder.StatementType paramStatementType) throws SQLException {
    return compile(paramDatabaseConnection, paramStatementType, -1);
  }
  
  public CompiledStatement compile(DatabaseConnection paramDatabaseConnection, StatementBuilder.StatementType paramStatementType, int paramInt) throws SQLException {
    if (this.type == paramStatementType)
      return assignStatementArguments(paramDatabaseConnection.compileStatement(this.statement, paramStatementType, this.argFieldTypes, paramInt)); 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Could not compile this ");
    stringBuilder.append(this.type);
    stringBuilder.append(" statement since the caller is expecting a ");
    stringBuilder.append(paramStatementType);
    stringBuilder.append(" statement.  Check your QueryBuilder methods.");
    throw new SQLException(stringBuilder.toString());
  }
  
  public String getStatement() {
    return this.statement;
  }
  
  public StatementBuilder.StatementType getType() {
    return this.type;
  }
  
  public void setArgumentHolderValue(int paramInt, Object paramObject) throws SQLException {
    if (paramInt >= 0) {
      ArgumentHolder[] arrayOfArgumentHolder = this.argHolders;
      if (arrayOfArgumentHolder.length > paramInt) {
        arrayOfArgumentHolder[paramInt].setValue(paramObject);
        return;
      } 
      paramObject = new StringBuilder();
      paramObject.append("argument holder index ");
      paramObject.append(paramInt);
      paramObject.append(" is not valid, only ");
      paramObject.append(this.argHolders.length);
      paramObject.append(" in statement (index starts at 0)");
      throw new SQLException(paramObject.toString());
    } 
    paramObject = new StringBuilder();
    paramObject.append("argument holder index ");
    paramObject.append(paramInt);
    paramObject.append(" must be >= 0");
    throw new SQLException(paramObject.toString());
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\j256\ormlite\stmt\mapped\MappedPreparedStmt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */