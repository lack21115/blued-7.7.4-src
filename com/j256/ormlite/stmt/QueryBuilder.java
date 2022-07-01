package com.j256.ormlite.stmt;

import com.j256.ormlite.dao.CloseableIterator;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.GenericRawResults;
import com.j256.ormlite.db.DatabaseType;
import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.stmt.query.OrderBy;
import com.j256.ormlite.table.TableInfo;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class QueryBuilder<T, ID> extends StatementBuilder<T, ID> {
  private boolean distinct;
  
  private List<String> groupByList;
  
  private String groupByRaw;
  
  private String having;
  
  private final FieldType idField;
  
  private boolean isCountOfQuery;
  
  private boolean isInnerQuery;
  
  private List<JoinInfo> joinList;
  
  private Long limit;
  
  private Long offset;
  
  private ArgumentHolder[] orderByArgs;
  
  private List<OrderBy> orderByList;
  
  private String orderByRaw;
  
  private FieldType[] resultFieldTypes;
  
  private List<String> selectColumnList;
  
  private boolean selectIdColumn = true;
  
  private List<String> selectRawList;
  
  public QueryBuilder(DatabaseType paramDatabaseType, TableInfo<T, ID> paramTableInfo, Dao<T, ID> paramDao) {
    super(paramDatabaseType, paramTableInfo, paramDao, StatementBuilder.StatementType.SELECT);
    this.idField = paramTableInfo.getIdField();
  }
  
  private void addJoinInfo(String paramString, QueryBuilder<?, ?> paramQueryBuilder, StatementBuilder.WhereOperation paramWhereOperation) throws SQLException {
    JoinInfo joinInfo = new JoinInfo(paramString, paramQueryBuilder, paramWhereOperation);
    matchJoinedFields(joinInfo, paramQueryBuilder);
    if (this.joinList == null)
      this.joinList = new ArrayList<JoinInfo>(); 
    this.joinList.add(joinInfo);
  }
  
  private void addSelectColumnToList(String paramString) {
    verifyColumnName(paramString);
    this.selectColumnList.add(paramString);
  }
  
  private void appendColumnName(StringBuilder paramStringBuilder, String paramString) {
    if (this.addTableName) {
      this.databaseType.appendEscapedEntityName(paramStringBuilder, this.tableName);
      paramStringBuilder.append('.');
    } 
    this.databaseType.appendEscapedEntityName(paramStringBuilder, paramString);
  }
  
  private void appendColumns(StringBuilder paramStringBuilder) {
    List<String> list = this.selectColumnList;
    if (list == null) {
      if (this.addTableName) {
        this.databaseType.appendEscapedEntityName(paramStringBuilder, this.tableName);
        paramStringBuilder.append('.');
      } 
      paramStringBuilder.append("* ");
      this.resultFieldTypes = this.tableInfo.getFieldTypes();
      return;
    } 
    boolean bool1 = this.isInnerQuery;
    list = new ArrayList<String>(list.size() + 1);
    Iterator<String> iterator = this.selectColumnList.iterator();
    boolean bool = true;
    while (iterator.hasNext()) {
      boolean bool2;
      String str = iterator.next();
      FieldType fieldType = this.tableInfo.getFieldTypeByColumnName(str);
      if (fieldType.isForeignCollection()) {
        list.add(fieldType);
        continue;
      } 
      if (bool) {
        bool2 = false;
      } else {
        paramStringBuilder.append(',');
        bool2 = bool;
      } 
      appendFieldColumnName(paramStringBuilder, fieldType, (List)list);
      bool = bool2;
      if (fieldType == this.idField) {
        bool1 = true;
        bool = bool2;
      } 
    } 
    if (!bool1 && this.selectIdColumn) {
      if (!bool)
        paramStringBuilder.append(','); 
      appendFieldColumnName(paramStringBuilder, this.idField, (List)list);
    } 
    paramStringBuilder.append(' ');
    this.resultFieldTypes = list.<FieldType>toArray(new FieldType[list.size()]);
  }
  
  private void appendFieldColumnName(StringBuilder paramStringBuilder, FieldType paramFieldType, List<FieldType> paramList) {
    appendColumnName(paramStringBuilder, paramFieldType.getColumnName());
    if (paramList != null)
      paramList.add(paramFieldType); 
  }
  
  private void appendGroupBys(StringBuilder paramStringBuilder) {
    boolean bool1 = hasGroupStuff();
    boolean bool = true;
    if (bool1) {
      appendGroupBys(paramStringBuilder, true);
      bool = false;
    } 
    List<JoinInfo> list = this.joinList;
    if (list != null)
      for (JoinInfo joinInfo : list) {
        if (joinInfo.queryBuilder != null && joinInfo.queryBuilder.hasGroupStuff())
          joinInfo.queryBuilder.appendGroupBys(paramStringBuilder, bool); 
      }  
  }
  
  private void appendGroupBys(StringBuilder paramStringBuilder, boolean paramBoolean) {
    if (paramBoolean)
      paramStringBuilder.append("GROUP BY "); 
    if (this.groupByRaw != null) {
      if (!paramBoolean)
        paramStringBuilder.append(','); 
      paramStringBuilder.append(this.groupByRaw);
    } else {
      for (String str : this.groupByList) {
        if (paramBoolean) {
          paramBoolean = false;
        } else {
          paramStringBuilder.append(',');
        } 
        appendColumnName(paramStringBuilder, str);
      } 
    } 
    paramStringBuilder.append(' ');
  }
  
  private void appendHaving(StringBuilder paramStringBuilder) {
    if (this.having != null) {
      paramStringBuilder.append("HAVING ");
      paramStringBuilder.append(this.having);
      paramStringBuilder.append(' ');
    } 
  }
  
  private void appendJoinSql(StringBuilder paramStringBuilder) {
    for (JoinInfo joinInfo : this.joinList) {
      paramStringBuilder.append(joinInfo.type);
      paramStringBuilder.append(" JOIN ");
      this.databaseType.appendEscapedEntityName(paramStringBuilder, joinInfo.queryBuilder.tableName);
      paramStringBuilder.append(" ON ");
      this.databaseType.appendEscapedEntityName(paramStringBuilder, this.tableName);
      paramStringBuilder.append('.');
      this.databaseType.appendEscapedEntityName(paramStringBuilder, joinInfo.localField.getColumnName());
      paramStringBuilder.append(" = ");
      this.databaseType.appendEscapedEntityName(paramStringBuilder, joinInfo.queryBuilder.tableName);
      paramStringBuilder.append('.');
      this.databaseType.appendEscapedEntityName(paramStringBuilder, joinInfo.remoteField.getColumnName());
      paramStringBuilder.append(' ');
      if (joinInfo.queryBuilder.joinList != null)
        joinInfo.queryBuilder.appendJoinSql(paramStringBuilder); 
    } 
  }
  
  private void appendLimit(StringBuilder paramStringBuilder) {
    if (this.limit != null && this.databaseType.isLimitSqlSupported())
      this.databaseType.appendLimitValue(paramStringBuilder, this.limit.longValue(), this.offset); 
  }
  
  private void appendOffset(StringBuilder paramStringBuilder) throws SQLException {
    if (this.offset == null)
      return; 
    if (this.databaseType.isOffsetLimitArgument()) {
      if (this.limit != null)
        return; 
      throw new SQLException("If the offset is specified, limit must also be specified with this database");
    } 
    this.databaseType.appendOffsetValue(paramStringBuilder, this.offset.longValue());
  }
  
  private void appendOrderBys(StringBuilder paramStringBuilder, List<ArgumentHolder> paramList) {
    boolean bool1 = hasOrderStuff();
    boolean bool = true;
    if (bool1) {
      appendOrderBys(paramStringBuilder, true, paramList);
      bool = false;
    } 
    List<JoinInfo> list = this.joinList;
    if (list != null)
      for (JoinInfo joinInfo : list) {
        if (joinInfo.queryBuilder != null && joinInfo.queryBuilder.hasOrderStuff())
          joinInfo.queryBuilder.appendOrderBys(paramStringBuilder, bool, paramList); 
      }  
  }
  
  private void appendOrderBys(StringBuilder paramStringBuilder, boolean paramBoolean, List<ArgumentHolder> paramList) {
    if (paramBoolean)
      paramStringBuilder.append("ORDER BY "); 
    boolean bool = paramBoolean;
    if (this.orderByRaw != null) {
      if (!paramBoolean)
        paramStringBuilder.append(','); 
      paramStringBuilder.append(this.orderByRaw);
      ArgumentHolder[] arrayOfArgumentHolder = this.orderByArgs;
      if (arrayOfArgumentHolder != null) {
        int j = arrayOfArgumentHolder.length;
        int i;
        for (i = 0; i < j; i++)
          paramList.add(arrayOfArgumentHolder[i]); 
      } 
      bool = false;
    } 
    List<OrderBy> list = this.orderByList;
    if (list != null)
      for (OrderBy orderBy : list) {
        if (bool) {
          bool = false;
        } else {
          paramStringBuilder.append(',');
        } 
        appendColumnName(paramStringBuilder, orderBy.getColumnName());
        if (orderBy.isAscending())
          continue; 
        paramStringBuilder.append(" DESC");
      }  
    paramStringBuilder.append(' ');
  }
  
  private void appendSelectRaw(StringBuilder paramStringBuilder) {
    Iterator<String> iterator = this.selectRawList.iterator();
    boolean bool = true;
    while (iterator.hasNext()) {
      String str = iterator.next();
      if (bool) {
        bool = false;
      } else {
        paramStringBuilder.append(", ");
      } 
      paramStringBuilder.append(str);
    } 
    paramStringBuilder.append(' ');
  }
  
  private boolean hasGroupStuff() {
    List<String> list = this.groupByList;
    return ((list != null && !list.isEmpty()) || this.groupByRaw != null);
  }
  
  private boolean hasOrderStuff() {
    List<OrderBy> list = this.orderByList;
    return ((list != null && !list.isEmpty()) || this.orderByRaw != null);
  }
  
  private void matchJoinedFields(JoinInfo paramJoinInfo, QueryBuilder<?, ?> paramQueryBuilder) throws SQLException {
    FieldType[] arrayOfFieldType = this.tableInfo.getFieldTypes();
    int j = arrayOfFieldType.length;
    boolean bool = false;
    int i;
    for (i = 0; i < j; i++) {
      FieldType fieldType1 = arrayOfFieldType[i];
      FieldType fieldType2 = fieldType1.getForeignIdField();
      if (fieldType1.isForeign() && fieldType2.equals(paramQueryBuilder.tableInfo.getIdField())) {
        paramJoinInfo.localField = fieldType1;
        paramJoinInfo.remoteField = fieldType2;
        return;
      } 
    } 
    arrayOfFieldType = paramQueryBuilder.tableInfo.getFieldTypes();
    j = arrayOfFieldType.length;
    for (i = bool; i < j; i++) {
      FieldType fieldType = arrayOfFieldType[i];
      if (fieldType.isForeign() && fieldType.getForeignIdField().equals(this.idField)) {
        paramJoinInfo.localField = this.idField;
        paramJoinInfo.remoteField = fieldType;
        return;
      } 
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Could not find a foreign ");
    stringBuilder.append(this.tableInfo.getDataClass());
    stringBuilder.append(" field in ");
    stringBuilder.append(paramQueryBuilder.tableInfo.getDataClass());
    stringBuilder.append(" or vice versa");
    throw new SQLException(stringBuilder.toString());
  }
  
  private void setAddTableName(boolean paramBoolean) {
    this.addTableName = paramBoolean;
    List<JoinInfo> list = this.joinList;
    if (list != null) {
      Iterator<JoinInfo> iterator = list.iterator();
      while (iterator.hasNext())
        ((JoinInfo)iterator.next()).queryBuilder.setAddTableName(paramBoolean); 
    } 
  }
  
  protected void appendStatementEnd(StringBuilder paramStringBuilder, List<ArgumentHolder> paramList) throws SQLException {
    appendGroupBys(paramStringBuilder);
    appendHaving(paramStringBuilder);
    appendOrderBys(paramStringBuilder, paramList);
    if (!this.databaseType.isLimitAfterSelect())
      appendLimit(paramStringBuilder); 
    appendOffset(paramStringBuilder);
    setAddTableName(false);
  }
  
  protected void appendStatementStart(StringBuilder paramStringBuilder, List<ArgumentHolder> paramList) {
    if (this.joinList == null) {
      setAddTableName(false);
    } else {
      setAddTableName(true);
    } 
    paramStringBuilder.append("SELECT ");
    if (this.databaseType.isLimitAfterSelect())
      appendLimit(paramStringBuilder); 
    if (this.distinct)
      paramStringBuilder.append("DISTINCT "); 
    if (this.isCountOfQuery) {
      this.type = StatementBuilder.StatementType.SELECT_LONG;
      paramStringBuilder.append("COUNT(*) ");
    } else {
      List<String> list = this.selectRawList;
      if (list != null && !list.isEmpty()) {
        this.type = StatementBuilder.StatementType.SELECT_RAW;
        appendSelectRaw(paramStringBuilder);
      } else {
        this.type = StatementBuilder.StatementType.SELECT;
        appendColumns(paramStringBuilder);
      } 
    } 
    paramStringBuilder.append("FROM ");
    this.databaseType.appendEscapedEntityName(paramStringBuilder, this.tableName);
    paramStringBuilder.append(' ');
    if (this.joinList != null)
      appendJoinSql(paramStringBuilder); 
  }
  
  protected boolean appendWhereStatement(StringBuilder paramStringBuilder, List<ArgumentHolder> paramList, StatementBuilder.WhereOperation paramWhereOperation) throws SQLException {
    boolean bool1;
    if (paramWhereOperation == StatementBuilder.WhereOperation.FIRST) {
      bool1 = true;
    } else {
      bool1 = false;
    } 
    if (this.where != null)
      bool1 = super.appendWhereStatement(paramStringBuilder, paramList, paramWhereOperation); 
    List<JoinInfo> list = this.joinList;
    boolean bool2 = bool1;
    if (list != null) {
      Iterator<JoinInfo> iterator = list.iterator();
      while (true) {
        bool2 = bool1;
        if (iterator.hasNext()) {
          StatementBuilder.WhereOperation whereOperation;
          JoinInfo joinInfo = iterator.next();
          if (bool1) {
            whereOperation = StatementBuilder.WhereOperation.FIRST;
          } else {
            whereOperation = joinInfo.operation;
          } 
          bool1 = joinInfo.queryBuilder.appendWhereStatement(paramStringBuilder, paramList, whereOperation);
          continue;
        } 
        break;
      } 
    } 
    return bool2;
  }
  
  @Deprecated
  public void clear() {
    reset();
  }
  
  public long countOf() throws SQLException {
    setCountOf(true);
    return this.dao.countOf(prepare());
  }
  
  public QueryBuilder<T, ID> distinct() {
    this.distinct = true;
    this.selectIdColumn = false;
    return this;
  }
  
  void enableInnerQuery() {
    this.isInnerQuery = true;
  }
  
  protected FieldType[] getResultFieldTypes() {
    return this.resultFieldTypes;
  }
  
  int getSelectColumnCount() {
    if (this.isCountOfQuery)
      return 1; 
    List<String> list = this.selectRawList;
    if (list != null && !list.isEmpty())
      return this.selectRawList.size(); 
    list = this.selectColumnList;
    return (list == null) ? 0 : list.size();
  }
  
  List<String> getSelectColumns() {
    if (this.isCountOfQuery)
      return Collections.singletonList("COUNT(*)"); 
    List<String> list1 = this.selectRawList;
    if (list1 != null && !list1.isEmpty())
      return this.selectRawList; 
    List<String> list2 = this.selectColumnList;
    list1 = list2;
    if (list2 == null)
      list1 = Collections.emptyList(); 
    return list1;
  }
  
  public QueryBuilder<T, ID> groupBy(String paramString) {
    if (!verifyColumnName(paramString).isForeignCollection()) {
      if (this.groupByList == null)
        this.groupByList = new ArrayList<String>(); 
      this.groupByList.add(paramString);
      this.selectIdColumn = false;
      return this;
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Can't groupBy foreign colletion field: ");
    stringBuilder.append(paramString);
    throw new IllegalArgumentException(stringBuilder.toString());
  }
  
  public QueryBuilder<T, ID> groupByRaw(String paramString) {
    this.groupByRaw = paramString;
    return this;
  }
  
  public QueryBuilder<T, ID> having(String paramString) {
    this.having = paramString;
    return this;
  }
  
  public CloseableIterator<T> iterator() throws SQLException {
    return this.dao.iterator(prepare());
  }
  
  public QueryBuilder<T, ID> join(QueryBuilder<?, ?> paramQueryBuilder) throws SQLException {
    addJoinInfo("INNER", paramQueryBuilder, StatementBuilder.WhereOperation.AND);
    return this;
  }
  
  public QueryBuilder<T, ID> joinOr(QueryBuilder<?, ?> paramQueryBuilder) throws SQLException {
    addJoinInfo("INNER", paramQueryBuilder, StatementBuilder.WhereOperation.OR);
    return this;
  }
  
  public QueryBuilder<T, ID> leftJoin(QueryBuilder<?, ?> paramQueryBuilder) throws SQLException {
    addJoinInfo("LEFT", paramQueryBuilder, StatementBuilder.WhereOperation.AND);
    return this;
  }
  
  public QueryBuilder<T, ID> leftJoinOr(QueryBuilder<?, ?> paramQueryBuilder) throws SQLException {
    addJoinInfo("LEFT", paramQueryBuilder, StatementBuilder.WhereOperation.OR);
    return this;
  }
  
  @Deprecated
  public QueryBuilder<T, ID> limit(int paramInt) {
    return limit(Long.valueOf(paramInt));
  }
  
  public QueryBuilder<T, ID> limit(Long paramLong) {
    this.limit = paramLong;
    return this;
  }
  
  @Deprecated
  public QueryBuilder<T, ID> offset(int paramInt) throws SQLException {
    return offset(Long.valueOf(paramInt));
  }
  
  public QueryBuilder<T, ID> offset(Long paramLong) throws SQLException {
    if (this.databaseType.isOffsetSqlSupported()) {
      this.offset = paramLong;
      return this;
    } 
    throw new SQLException("Offset is not supported by this database");
  }
  
  public QueryBuilder<T, ID> orderBy(String paramString, boolean paramBoolean) {
    if (!verifyColumnName(paramString).isForeignCollection()) {
      if (this.orderByList == null)
        this.orderByList = new ArrayList<OrderBy>(); 
      this.orderByList.add(new OrderBy(paramString, paramBoolean));
      return this;
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Can't orderBy foreign colletion field: ");
    stringBuilder.append(paramString);
    throw new IllegalArgumentException(stringBuilder.toString());
  }
  
  public QueryBuilder<T, ID> orderByRaw(String paramString) {
    return orderByRaw(paramString, (ArgumentHolder[])null);
  }
  
  public QueryBuilder<T, ID> orderByRaw(String paramString, ArgumentHolder... paramVarArgs) {
    this.orderByRaw = paramString;
    this.orderByArgs = paramVarArgs;
    return this;
  }
  
  public PreparedQuery<T> prepare() throws SQLException {
    return (PreparedQuery)prepareStatement(this.limit);
  }
  
  public List<T> query() throws SQLException {
    return this.dao.query(prepare());
  }
  
  public T queryForFirst() throws SQLException {
    return (T)this.dao.queryForFirst(prepare());
  }
  
  public GenericRawResults<String[]> queryRaw() throws SQLException {
    return this.dao.queryRaw(prepareStatementString(), new String[0]);
  }
  
  public String[] queryRawFirst() throws SQLException {
    return (String[])this.dao.queryRaw(prepareStatementString(), new String[0]).getFirstResult();
  }
  
  public void reset() {
    super.reset();
    this.distinct = false;
    this.selectIdColumn = true;
    this.selectColumnList = null;
    this.selectRawList = null;
    this.orderByList = null;
    this.orderByRaw = null;
    this.groupByList = null;
    this.groupByRaw = null;
    this.isInnerQuery = false;
    this.isCountOfQuery = false;
    this.having = null;
    this.limit = null;
    this.offset = null;
    List<JoinInfo> list = this.joinList;
    if (list != null) {
      list.clear();
      this.joinList = null;
    } 
    this.addTableName = false;
  }
  
  public QueryBuilder<T, ID> selectColumns(Iterable<String> paramIterable) {
    if (this.selectColumnList == null)
      this.selectColumnList = new ArrayList<String>(); 
    Iterator<String> iterator = paramIterable.iterator();
    while (iterator.hasNext())
      addSelectColumnToList(iterator.next()); 
    return this;
  }
  
  public QueryBuilder<T, ID> selectColumns(String... paramVarArgs) {
    if (this.selectColumnList == null)
      this.selectColumnList = new ArrayList<String>(); 
    int j = paramVarArgs.length;
    for (int i = 0; i < j; i++)
      addSelectColumnToList(paramVarArgs[i]); 
    return this;
  }
  
  public QueryBuilder<T, ID> selectRaw(String... paramVarArgs) {
    if (this.selectRawList == null)
      this.selectRawList = new ArrayList<String>(); 
    int j = paramVarArgs.length;
    for (int i = 0; i < j; i++) {
      String str = paramVarArgs[i];
      this.selectRawList.add(str);
    } 
    return this;
  }
  
  public QueryBuilder<T, ID> setCountOf(boolean paramBoolean) {
    this.isCountOfQuery = paramBoolean;
    return this;
  }
  
  protected boolean shouldPrependTableNameToColumns() {
    return (this.joinList != null);
  }
  
  public static class InternalQueryBuilderWrapper {
    private final QueryBuilder<?, ?> queryBuilder;
    
    InternalQueryBuilderWrapper(QueryBuilder<?, ?> param1QueryBuilder) {
      this.queryBuilder = param1QueryBuilder;
    }
    
    public void appendStatementString(StringBuilder param1StringBuilder, List<ArgumentHolder> param1List) throws SQLException {
      this.queryBuilder.appendStatementString(param1StringBuilder, param1List);
    }
    
    public FieldType[] getResultFieldTypes() {
      return this.queryBuilder.getResultFieldTypes();
    }
  }
  
  class JoinInfo {
    FieldType localField;
    
    StatementBuilder.WhereOperation operation;
    
    final QueryBuilder<?, ?> queryBuilder;
    
    FieldType remoteField;
    
    final String type;
    
    public JoinInfo(String param1String, QueryBuilder<?, ?> param1QueryBuilder, StatementBuilder.WhereOperation param1WhereOperation) {
      this.type = param1String;
      this.queryBuilder = param1QueryBuilder;
      this.operation = param1WhereOperation;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\j256\ormlite\stmt\QueryBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */