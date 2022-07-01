package com.j256.ormlite.stmt.query;

import com.j256.ormlite.db.DatabaseType;
import com.j256.ormlite.stmt.ArgumentHolder;
import com.j256.ormlite.stmt.QueryBuilder;
import java.sql.SQLException;
import java.util.List;

public class Exists implements Clause {
  private final QueryBuilder.InternalQueryBuilderWrapper subQueryBuilder;
  
  public Exists(QueryBuilder.InternalQueryBuilderWrapper paramInternalQueryBuilderWrapper) {
    this.subQueryBuilder = paramInternalQueryBuilderWrapper;
  }
  
  public void appendSql(DatabaseType paramDatabaseType, String paramString, StringBuilder paramStringBuilder, List<ArgumentHolder> paramList) throws SQLException {
    paramStringBuilder.append("EXISTS (");
    this.subQueryBuilder.appendStatementString(paramStringBuilder, paramList);
    paramStringBuilder.append(") ");
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\j256\ormlite\stmt\query\Exists.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */