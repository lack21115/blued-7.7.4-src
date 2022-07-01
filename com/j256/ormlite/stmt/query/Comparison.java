package com.j256.ormlite.stmt.query;

import com.j256.ormlite.db.DatabaseType;
import com.j256.ormlite.stmt.ArgumentHolder;
import java.sql.SQLException;
import java.util.List;

interface Comparison extends Clause {
  void appendOperation(StringBuilder paramStringBuilder);
  
  void appendValue(DatabaseType paramDatabaseType, StringBuilder paramStringBuilder, List<ArgumentHolder> paramList) throws SQLException;
  
  String getColumnName();
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\j256\ormlite\stmt\query\Comparison.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */