package com.j256.ormlite.stmt;

import com.j256.ormlite.dao.CloseableIterator;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.GenericRawResults;
import com.j256.ormlite.db.DatabaseType;
import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.stmt.query.Between;
import com.j256.ormlite.stmt.query.Clause;
import com.j256.ormlite.stmt.query.Exists;
import com.j256.ormlite.stmt.query.In;
import com.j256.ormlite.stmt.query.InSubQuery;
import com.j256.ormlite.stmt.query.IsNotNull;
import com.j256.ormlite.stmt.query.IsNull;
import com.j256.ormlite.stmt.query.ManyClause;
import com.j256.ormlite.stmt.query.NeedsFutureClause;
import com.j256.ormlite.stmt.query.Not;
import com.j256.ormlite.stmt.query.Raw;
import com.j256.ormlite.stmt.query.SimpleComparison;
import com.j256.ormlite.table.TableInfo;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Where<T, ID> {
  private static final int CLAUSE_STACK_START_SIZE = 4;
  
  private Clause[] clauseStack = new Clause[4];
  
  private int clauseStackLevel;
  
  private final DatabaseType databaseType;
  
  private final String idColumnName;
  
  private final FieldType idFieldType;
  
  private NeedsFutureClause needsFuture = null;
  
  private final StatementBuilder<T, ID> statementBuilder;
  
  private final TableInfo<T, ID> tableInfo;
  
  Where(TableInfo<T, ID> paramTableInfo, StatementBuilder<T, ID> paramStatementBuilder, DatabaseType paramDatabaseType) {
    this.tableInfo = paramTableInfo;
    this.statementBuilder = paramStatementBuilder;
    this.idFieldType = paramTableInfo.getIdField();
    FieldType fieldType = this.idFieldType;
    if (fieldType == null) {
      this.idColumnName = null;
    } else {
      this.idColumnName = fieldType.getColumnName();
    } 
    this.databaseType = paramDatabaseType;
  }
  
  private void addClause(Clause paramClause) {
    NeedsFutureClause needsFutureClause = this.needsFuture;
    if (needsFutureClause == null) {
      push(paramClause);
      return;
    } 
    needsFutureClause.setMissingClause(paramClause);
    this.needsFuture = null;
  }
  
  private void addNeedsFuture(NeedsFutureClause paramNeedsFutureClause) {
    if (this.needsFuture == null) {
      this.needsFuture = paramNeedsFutureClause;
      return;
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(this.needsFuture);
    stringBuilder.append(" is already waiting for a future clause, can't add: ");
    stringBuilder.append(paramNeedsFutureClause);
    throw new IllegalStateException(stringBuilder.toString());
  }
  
  private Clause[] buildClauseArray(Where<T, ID>[] paramArrayOfWhere, String paramString) {
    if (paramArrayOfWhere.length == 0)
      return null; 
    Clause[] arrayOfClause = new Clause[paramArrayOfWhere.length];
    for (int i = paramArrayOfWhere.length - 1; i >= 0; i--)
      arrayOfClause[i] = pop(paramString); 
    return arrayOfClause;
  }
  
  private QueryBuilder<T, ID> checkQueryBuilderMethod(String paramString) throws SQLException {
    StatementBuilder<T, ID> statementBuilder = this.statementBuilder;
    if (statementBuilder instanceof QueryBuilder)
      return (QueryBuilder<T, ID>)statementBuilder; 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Cannot call ");
    stringBuilder.append(paramString);
    stringBuilder.append(" on a statement of type ");
    stringBuilder.append(this.statementBuilder.getType());
    throw new SQLException(stringBuilder.toString());
  }
  
  private FieldType findColumnFieldType(String paramString) {
    return this.tableInfo.getFieldTypeByColumnName(paramString);
  }
  
  private Where<T, ID> in(boolean paramBoolean, String paramString, QueryBuilder<?, ?> paramQueryBuilder) throws SQLException {
    StringBuilder stringBuilder;
    if (paramQueryBuilder.getSelectColumnCount() != 1) {
      if (paramQueryBuilder.getSelectColumnCount() == 0)
        throw new SQLException("Inner query must have only 1 select column specified instead of *"); 
      stringBuilder = new StringBuilder();
      stringBuilder.append("Inner query must have only 1 select column specified instead of ");
      stringBuilder.append(paramQueryBuilder.getSelectColumnCount());
      stringBuilder.append(": ");
      stringBuilder.append(Arrays.toString(paramQueryBuilder.getSelectColumns().toArray((Object[])new String[0])));
      throw new SQLException(stringBuilder.toString());
    } 
    paramQueryBuilder.enableInnerQuery();
    addClause((Clause)new InSubQuery((String)stringBuilder, findColumnFieldType((String)stringBuilder), new QueryBuilder.InternalQueryBuilderWrapper(paramQueryBuilder), paramBoolean));
    return this;
  }
  
  private Where<T, ID> in(boolean paramBoolean, String paramString, Object... paramVarArgs) throws SQLException {
    StringBuilder stringBuilder;
    if (paramVarArgs.length == 1) {
      boolean bool = paramVarArgs[0].getClass().isArray();
      String str = "IN";
      if (bool) {
        stringBuilder = new StringBuilder();
        stringBuilder.append("Object argument to ");
        if (!paramBoolean)
          str = "notId"; 
        stringBuilder.append(str);
        stringBuilder.append(" seems to be an array within an array");
        throw new IllegalArgumentException(stringBuilder.toString());
      } 
      if (paramVarArgs[0] instanceof Where) {
        stringBuilder = new StringBuilder();
        stringBuilder.append("Object argument to ");
        if (!paramBoolean)
          str = "notId"; 
        stringBuilder.append(str);
        stringBuilder.append(" seems to be a Where object, did you mean the QueryBuilder?");
        throw new IllegalArgumentException(stringBuilder.toString());
      } 
      if (paramVarArgs[0] instanceof PreparedStmt) {
        stringBuilder = new StringBuilder();
        stringBuilder.append("Object argument to ");
        if (!paramBoolean)
          str = "notId"; 
        stringBuilder.append(str);
        stringBuilder.append(" seems to be a prepared statement, did you mean the QueryBuilder?");
        throw new IllegalArgumentException(stringBuilder.toString());
      } 
    } 
    addClause((Clause)new In((String)stringBuilder, findColumnFieldType((String)stringBuilder), paramVarArgs, paramBoolean));
    return this;
  }
  
  private Clause peek() {
    return this.clauseStack[this.clauseStackLevel - 1];
  }
  
  private Clause pop(String paramString) {
    Clause[] arrayOfClause;
    int i = this.clauseStackLevel;
    if (i != 0) {
      arrayOfClause = this.clauseStack;
      this.clauseStackLevel = --i;
      Clause clause = arrayOfClause[i];
      arrayOfClause[this.clauseStackLevel] = null;
      return clause;
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Expecting there to be a clause already defined for '");
    stringBuilder.append((String)arrayOfClause);
    stringBuilder.append("' operation");
    throw new IllegalStateException(stringBuilder.toString());
  }
  
  private void push(Clause paramClause) {
    int i = this.clauseStackLevel;
    if (i == this.clauseStack.length) {
      Clause[] arrayOfClause1 = new Clause[i * 2];
      for (i = 0; i < this.clauseStackLevel; i++) {
        Clause[] arrayOfClause2 = this.clauseStack;
        arrayOfClause1[i] = arrayOfClause2[i];
        arrayOfClause2[i] = null;
      } 
      this.clauseStack = arrayOfClause1;
    } 
    Clause[] arrayOfClause = this.clauseStack;
    i = this.clauseStackLevel;
    this.clauseStackLevel = i + 1;
    arrayOfClause[i] = paramClause;
  }
  
  public Where<T, ID> and() {
    ManyClause manyClause = new ManyClause(pop("AND"), "AND");
    push((Clause)manyClause);
    addNeedsFuture((NeedsFutureClause)manyClause);
    return this;
  }
  
  public Where<T, ID> and(int paramInt) {
    if (paramInt != 0) {
      Clause[] arrayOfClause = new Clause[paramInt];
      while (--paramInt >= 0) {
        arrayOfClause[paramInt] = pop("AND");
        paramInt--;
      } 
      addClause((Clause)new ManyClause(arrayOfClause, "AND"));
      return this;
    } 
    throw new IllegalArgumentException("Must have at least one clause in and(numClauses)");
  }
  
  public Where<T, ID> and(Where<T, ID> paramWhere1, Where<T, ID> paramWhere2, Where<T, ID>... paramVarArgs) {
    Clause[] arrayOfClause = buildClauseArray(paramVarArgs, "AND");
    Clause clause = pop("AND");
    addClause((Clause)new ManyClause(pop("AND"), clause, arrayOfClause, "AND"));
    return this;
  }
  
  void appendSql(String paramString, StringBuilder paramStringBuilder, List<ArgumentHolder> paramList) throws SQLException {
    int i = this.clauseStackLevel;
    if (i != 0) {
      if (i == 1) {
        if (this.needsFuture == null) {
          peek().appendSql(this.databaseType, paramString, paramStringBuilder, paramList);
          return;
        } 
        throw new IllegalStateException("The SQL statement has not been finished since there are previous operations still waiting for clauses.");
      } 
      throw new IllegalStateException("Both the \"left-hand\" and \"right-hand\" clauses have been defined.  Did you miss an AND or OR?");
    } 
    throw new IllegalStateException("No where clauses defined.  Did you miss a where operation?");
  }
  
  public Where<T, ID> between(String paramString, Object paramObject1, Object paramObject2) throws SQLException {
    addClause((Clause)new Between(paramString, findColumnFieldType(paramString), paramObject1, paramObject2));
    return this;
  }
  
  @Deprecated
  public Where<T, ID> clear() {
    return reset();
  }
  
  public long countOf() throws SQLException {
    return checkQueryBuilderMethod("countOf()").countOf();
  }
  
  public Where<T, ID> eq(String paramString, Object paramObject) throws SQLException {
    addClause((Clause)new SimpleComparison(paramString, findColumnFieldType(paramString), paramObject, "="));
    return this;
  }
  
  public Where<T, ID> exists(QueryBuilder<?, ?> paramQueryBuilder) {
    paramQueryBuilder.enableInnerQuery();
    addClause((Clause)new Exists(new QueryBuilder.InternalQueryBuilderWrapper(paramQueryBuilder)));
    return this;
  }
  
  public Where<T, ID> ge(String paramString, Object paramObject) throws SQLException {
    addClause((Clause)new SimpleComparison(paramString, findColumnFieldType(paramString), paramObject, ">="));
    return this;
  }
  
  public String getStatement() throws SQLException {
    StringBuilder stringBuilder = new StringBuilder();
    appendSql(null, stringBuilder, new ArrayList<ArgumentHolder>());
    return stringBuilder.toString();
  }
  
  public Where<T, ID> gt(String paramString, Object paramObject) throws SQLException {
    addClause((Clause)new SimpleComparison(paramString, findColumnFieldType(paramString), paramObject, ">"));
    return this;
  }
  
  public <OD> Where<T, ID> idEq(Dao<OD, ?> paramDao, OD paramOD) throws SQLException {
    String str = this.idColumnName;
    if (str != null) {
      addClause((Clause)new SimpleComparison(str, this.idFieldType, paramDao.extractId(paramOD), "="));
      return this;
    } 
    throw new SQLException("Object has no id column specified");
  }
  
  public Where<T, ID> idEq(ID paramID) throws SQLException {
    String str = this.idColumnName;
    if (str != null) {
      addClause((Clause)new SimpleComparison(str, this.idFieldType, paramID, "="));
      return this;
    } 
    throw new SQLException("Object has no id column specified");
  }
  
  public Where<T, ID> in(String paramString, QueryBuilder<?, ?> paramQueryBuilder) throws SQLException {
    return in(true, paramString, paramQueryBuilder);
  }
  
  public Where<T, ID> in(String paramString, Iterable<?> paramIterable) throws SQLException {
    addClause((Clause)new In(paramString, findColumnFieldType(paramString), paramIterable, true));
    return this;
  }
  
  public Where<T, ID> in(String paramString, Object... paramVarArgs) throws SQLException {
    return in(true, paramString, paramVarArgs);
  }
  
  public Where<T, ID> isNotNull(String paramString) throws SQLException {
    addClause((Clause)new IsNotNull(paramString, findColumnFieldType(paramString)));
    return this;
  }
  
  public Where<T, ID> isNull(String paramString) throws SQLException {
    addClause((Clause)new IsNull(paramString, findColumnFieldType(paramString)));
    return this;
  }
  
  public CloseableIterator<T> iterator() throws SQLException {
    return checkQueryBuilderMethod("iterator()").iterator();
  }
  
  public Where<T, ID> le(String paramString, Object paramObject) throws SQLException {
    addClause((Clause)new SimpleComparison(paramString, findColumnFieldType(paramString), paramObject, "<="));
    return this;
  }
  
  public Where<T, ID> like(String paramString, Object paramObject) throws SQLException {
    addClause((Clause)new SimpleComparison(paramString, findColumnFieldType(paramString), paramObject, "LIKE"));
    return this;
  }
  
  public Where<T, ID> lt(String paramString, Object paramObject) throws SQLException {
    addClause((Clause)new SimpleComparison(paramString, findColumnFieldType(paramString), paramObject, "<"));
    return this;
  }
  
  public Where<T, ID> ne(String paramString, Object paramObject) throws SQLException {
    addClause((Clause)new SimpleComparison(paramString, findColumnFieldType(paramString), paramObject, "<>"));
    return this;
  }
  
  public Where<T, ID> not() {
    Not not = new Not();
    addClause((Clause)not);
    addNeedsFuture((NeedsFutureClause)not);
    return this;
  }
  
  public Where<T, ID> not(Where<T, ID> paramWhere) {
    addClause((Clause)new Not(pop("NOT")));
    return this;
  }
  
  public Where<T, ID> notIn(String paramString, QueryBuilder<?, ?> paramQueryBuilder) throws SQLException {
    return in(false, paramString, paramQueryBuilder);
  }
  
  public Where<T, ID> notIn(String paramString, Iterable<?> paramIterable) throws SQLException {
    addClause((Clause)new In(paramString, findColumnFieldType(paramString), paramIterable, false));
    return this;
  }
  
  public Where<T, ID> notIn(String paramString, Object... paramVarArgs) throws SQLException {
    return in(false, paramString, paramVarArgs);
  }
  
  public Where<T, ID> or() {
    ManyClause manyClause = new ManyClause(pop("OR"), "OR");
    push((Clause)manyClause);
    addNeedsFuture((NeedsFutureClause)manyClause);
    return this;
  }
  
  public Where<T, ID> or(int paramInt) {
    if (paramInt != 0) {
      Clause[] arrayOfClause = new Clause[paramInt];
      while (--paramInt >= 0) {
        arrayOfClause[paramInt] = pop("OR");
        paramInt--;
      } 
      addClause((Clause)new ManyClause(arrayOfClause, "OR"));
      return this;
    } 
    throw new IllegalArgumentException("Must have at least one clause in or(numClauses)");
  }
  
  public Where<T, ID> or(Where<T, ID> paramWhere1, Where<T, ID> paramWhere2, Where<T, ID>... paramVarArgs) {
    Clause[] arrayOfClause = buildClauseArray(paramVarArgs, "OR");
    Clause clause = pop("OR");
    addClause((Clause)new ManyClause(pop("OR"), clause, arrayOfClause, "OR"));
    return this;
  }
  
  public PreparedQuery<T> prepare() throws SQLException {
    return (PreparedQuery)this.statementBuilder.prepareStatement(null);
  }
  
  public List<T> query() throws SQLException {
    return checkQueryBuilderMethod("query()").query();
  }
  
  public T queryForFirst() throws SQLException {
    return checkQueryBuilderMethod("queryForFirst()").queryForFirst();
  }
  
  public GenericRawResults<String[]> queryRaw() throws SQLException {
    return checkQueryBuilderMethod("queryRaw()").queryRaw();
  }
  
  public String[] queryRawFirst() throws SQLException {
    return checkQueryBuilderMethod("queryRawFirst()").queryRawFirst();
  }
  
  public Where<T, ID> raw(String paramString, ArgumentHolder... paramVarArgs) {
    int j = paramVarArgs.length;
    for (int i = 0; i < j; i++) {
      ArgumentHolder argumentHolder = paramVarArgs[i];
      String str = argumentHolder.getColumnName();
      if (str == null) {
        if (argumentHolder.getSqlType() == null)
          throw new IllegalArgumentException("Either the column name or SqlType must be set on each argument"); 
      } else {
        argumentHolder.setMetaInfo(findColumnFieldType(str));
      } 
    } 
    addClause((Clause)new Raw(paramString, paramVarArgs));
    return this;
  }
  
  public Where<T, ID> rawComparison(String paramString1, String paramString2, Object paramObject) throws SQLException {
    addClause((Clause)new SimpleComparison(paramString1, findColumnFieldType(paramString1), paramObject, paramString2));
    return this;
  }
  
  public Where<T, ID> reset() {
    for (int i = 0; i < this.clauseStackLevel; i++)
      this.clauseStack[i] = null; 
    this.clauseStackLevel = 0;
    return this;
  }
  
  public String toString() {
    if (this.clauseStackLevel == 0)
      return "empty where clause"; 
    Clause clause = peek();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("where clause: ");
    stringBuilder.append(clause);
    return stringBuilder.toString();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\j256\ormlite\stmt\Where.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */