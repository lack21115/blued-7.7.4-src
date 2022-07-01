package com.j256.ormlite.stmt;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.db.DatabaseType;
import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.stmt.query.Clause;
import com.j256.ormlite.stmt.query.SetExpression;
import com.j256.ormlite.stmt.query.SetValue;
import com.j256.ormlite.table.TableInfo;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UpdateBuilder<T, ID> extends StatementBuilder<T, ID> {
  private List<Clause> updateClauseList = null;
  
  public UpdateBuilder(DatabaseType paramDatabaseType, TableInfo<T, ID> paramTableInfo, Dao<T, ID> paramDao) {
    super(paramDatabaseType, paramTableInfo, paramDao, StatementBuilder.StatementType.UPDATE);
  }
  
  private void addUpdateColumnToList(String paramString, Clause paramClause) {
    if (this.updateClauseList == null)
      this.updateClauseList = new ArrayList<Clause>(); 
    this.updateClauseList.add(paramClause);
  }
  
  protected void appendStatementEnd(StringBuilder paramStringBuilder, List<ArgumentHolder> paramList) {}
  
  protected void appendStatementStart(StringBuilder paramStringBuilder, List<ArgumentHolder> paramList) throws SQLException {
    List<Clause> list = this.updateClauseList;
    if (list != null && !list.isEmpty()) {
      paramStringBuilder.append("UPDATE ");
      this.databaseType.appendEscapedEntityName(paramStringBuilder, this.tableInfo.getTableName());
      paramStringBuilder.append(" SET ");
      boolean bool = true;
      for (Clause clause : this.updateClauseList) {
        if (bool) {
          bool = false;
        } else {
          paramStringBuilder.append(',');
        } 
        clause.appendSql(this.databaseType, null, paramStringBuilder, paramList);
      } 
      return;
    } 
    throw new IllegalArgumentException("UPDATE statements must have at least one SET column");
  }
  
  @Deprecated
  public void clear() {
    reset();
  }
  
  public String escapeColumnName(String paramString) {
    StringBuilder stringBuilder = new StringBuilder(paramString.length() + 4);
    this.databaseType.appendEscapedEntityName(stringBuilder, paramString);
    return stringBuilder.toString();
  }
  
  public void escapeColumnName(StringBuilder paramStringBuilder, String paramString) {
    this.databaseType.appendEscapedEntityName(paramStringBuilder, paramString);
  }
  
  public String escapeValue(String paramString) {
    StringBuilder stringBuilder = new StringBuilder(paramString.length() + 4);
    this.databaseType.appendEscapedWord(stringBuilder, paramString);
    return stringBuilder.toString();
  }
  
  public void escapeValue(StringBuilder paramStringBuilder, String paramString) {
    this.databaseType.appendEscapedWord(paramStringBuilder, paramString);
  }
  
  public PreparedUpdate<T> prepare() throws SQLException {
    return (PreparedUpdate)prepareStatement(null);
  }
  
  public void reset() {
    super.reset();
    this.updateClauseList = null;
  }
  
  public int update() throws SQLException {
    return this.dao.update(prepare());
  }
  
  public StatementBuilder<T, ID> updateColumnExpression(String paramString1, String paramString2) throws SQLException {
    FieldType fieldType = verifyColumnName(paramString1);
    if (!fieldType.isForeignCollection()) {
      addUpdateColumnToList(paramString1, (Clause)new SetExpression(paramString1, fieldType, paramString2));
      return this;
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Can't update foreign colletion field: ");
    stringBuilder.append(paramString1);
    throw new SQLException(stringBuilder.toString());
  }
  
  public StatementBuilder<T, ID> updateColumnValue(String paramString, Object paramObject) throws SQLException {
    FieldType fieldType = verifyColumnName(paramString);
    if (!fieldType.isForeignCollection()) {
      addUpdateColumnToList(paramString, (Clause)new SetValue(paramString, fieldType, paramObject));
      return this;
    } 
    paramObject = new StringBuilder();
    paramObject.append("Can't update foreign colletion field: ");
    paramObject.append(paramString);
    throw new SQLException(paramObject.toString());
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\j256\ormlite\stmt\UpdateBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */