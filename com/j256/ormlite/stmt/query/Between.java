package com.j256.ormlite.stmt.query;

import com.j256.ormlite.db.DatabaseType;
import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.stmt.ArgumentHolder;
import java.sql.SQLException;
import java.util.List;

public class Between extends BaseComparison {
  private Object high;
  
  private Object low;
  
  public Between(String paramString, FieldType paramFieldType, Object paramObject1, Object paramObject2) throws SQLException {
    super(paramString, paramFieldType, null, true);
    this.low = paramObject1;
    this.high = paramObject2;
  }
  
  public void appendOperation(StringBuilder paramStringBuilder) {
    paramStringBuilder.append("BETWEEN ");
  }
  
  public void appendValue(DatabaseType paramDatabaseType, StringBuilder paramStringBuilder, List<ArgumentHolder> paramList) throws SQLException {
    if (this.low != null) {
      if (this.high != null) {
        appendArgOrValue(paramDatabaseType, this.fieldType, paramStringBuilder, paramList, this.low);
        paramStringBuilder.append("AND ");
        appendArgOrValue(paramDatabaseType, this.fieldType, paramStringBuilder, paramList, this.high);
        return;
      } 
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append("BETWEEN high value for '");
      stringBuilder1.append(this.columnName);
      stringBuilder1.append("' is null");
      throw new IllegalArgumentException(stringBuilder1.toString());
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("BETWEEN low value for '");
    stringBuilder.append(this.columnName);
    stringBuilder.append("' is null");
    throw new IllegalArgumentException(stringBuilder.toString());
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\j256\ormlite\stmt\query\Between.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */