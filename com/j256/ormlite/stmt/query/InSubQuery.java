package com.j256.ormlite.stmt.query;

import com.j256.ormlite.db.DatabaseType;
import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.stmt.ArgumentHolder;
import com.j256.ormlite.stmt.QueryBuilder;
import java.sql.SQLException;
import java.util.List;

public class InSubQuery extends BaseComparison {
  private final boolean in;
  
  private final QueryBuilder.InternalQueryBuilderWrapper subQueryBuilder;
  
  public InSubQuery(String paramString, FieldType paramFieldType, QueryBuilder.InternalQueryBuilderWrapper paramInternalQueryBuilderWrapper, boolean paramBoolean) throws SQLException {
    super(paramString, paramFieldType, null, true);
    this.subQueryBuilder = paramInternalQueryBuilderWrapper;
    this.in = paramBoolean;
  }
  
  public void appendOperation(StringBuilder paramStringBuilder) {
    if (this.in) {
      paramStringBuilder.append("IN ");
      return;
    } 
    paramStringBuilder.append("NOT IN ");
  }
  
  public void appendValue(DatabaseType paramDatabaseType, StringBuilder paramStringBuilder, List<ArgumentHolder> paramList) throws SQLException {
    paramStringBuilder.append('(');
    this.subQueryBuilder.appendStatementString(paramStringBuilder, paramList);
    FieldType[] arrayOfFieldType = this.subQueryBuilder.getResultFieldTypes();
    if (arrayOfFieldType != null)
      if (arrayOfFieldType.length == 1) {
        if (this.fieldType.getSqlType() != arrayOfFieldType[0].getSqlType()) {
          paramStringBuilder = new StringBuilder();
          paramStringBuilder.append("Outer column ");
          paramStringBuilder.append(this.fieldType);
          paramStringBuilder.append(" is not the same type as inner column ");
          paramStringBuilder.append(arrayOfFieldType[0]);
          throw new SQLException(paramStringBuilder.toString());
        } 
      } else {
        paramStringBuilder = new StringBuilder();
        paramStringBuilder.append("There must be only 1 result column in sub-query but we found ");
        paramStringBuilder.append(arrayOfFieldType.length);
        throw new SQLException(paramStringBuilder.toString());
      }  
    paramStringBuilder.append(") ");
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\j256\ormlite\stmt\query\InSubQuery.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */