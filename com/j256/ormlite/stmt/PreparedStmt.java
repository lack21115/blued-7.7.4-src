package com.j256.ormlite.stmt;

import com.j256.ormlite.support.CompiledStatement;
import com.j256.ormlite.support.DatabaseConnection;
import java.sql.SQLException;

public interface PreparedStmt<T> extends GenericRowMapper<T> {
  CompiledStatement compile(DatabaseConnection paramDatabaseConnection, StatementBuilder.StatementType paramStatementType) throws SQLException;
  
  CompiledStatement compile(DatabaseConnection paramDatabaseConnection, StatementBuilder.StatementType paramStatementType, int paramInt) throws SQLException;
  
  String getStatement() throws SQLException;
  
  StatementBuilder.StatementType getType();
  
  void setArgumentHolderValue(int paramInt, Object paramObject) throws SQLException;
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\j256\ormlite\stmt\PreparedStmt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */