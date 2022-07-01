package com.j256.ormlite.stmt.query;

import com.j256.ormlite.db.DatabaseType;
import com.j256.ormlite.stmt.ArgumentHolder;
import java.sql.SQLException;
import java.util.List;

public class Not implements Clause, NeedsFutureClause {
  private Comparison comparison = null;
  
  private Exists exists = null;
  
  public Not() {}
  
  public Not(Clause paramClause) {
    setMissingClause(paramClause);
  }
  
  public void appendSql(DatabaseType paramDatabaseType, String paramString, StringBuilder paramStringBuilder, List<ArgumentHolder> paramList) throws SQLException {
    if (this.comparison != null || this.exists != null) {
      if (this.comparison == null) {
        paramStringBuilder.append("(NOT ");
        this.exists.appendSql(paramDatabaseType, paramString, paramStringBuilder, paramList);
      } else {
        paramStringBuilder.append("(NOT ");
        if (paramString != null) {
          paramDatabaseType.appendEscapedEntityName(paramStringBuilder, paramString);
          paramStringBuilder.append('.');
        } 
        paramDatabaseType.appendEscapedEntityName(paramStringBuilder, this.comparison.getColumnName());
        paramStringBuilder.append(' ');
        this.comparison.appendOperation(paramStringBuilder);
        this.comparison.appendValue(paramDatabaseType, paramStringBuilder, paramList);
      } 
      paramStringBuilder.append(") ");
      return;
    } 
    throw new IllegalStateException("Clause has not been set in NOT operation");
  }
  
  public void setMissingClause(Clause paramClause) {
    if (this.comparison == null) {
      if (paramClause instanceof Comparison) {
        this.comparison = (Comparison)paramClause;
        return;
      } 
      if (paramClause instanceof Exists) {
        this.exists = (Exists)paramClause;
        return;
      } 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("NOT operation can only work with comparison SQL clauses, not ");
      stringBuilder.append(paramClause);
      throw new IllegalArgumentException(stringBuilder.toString());
    } 
    throw new IllegalArgumentException("NOT operation already has a comparison set");
  }
  
  public String toString() {
    if (this.comparison == null)
      return "NOT without comparison"; 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("NOT comparison ");
    stringBuilder.append(this.comparison);
    return stringBuilder.toString();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\j256\ormlite\stmt\query\Not.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */