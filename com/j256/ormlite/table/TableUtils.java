package com.j256.ormlite.table;

import com.j256.ormlite.dao.BaseDaoImpl;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.db.DatabaseType;
import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.logger.Logger;
import com.j256.ormlite.logger.LoggerFactory;
import com.j256.ormlite.misc.SqlExceptionUtil;
import com.j256.ormlite.stmt.StatementBuilder;
import com.j256.ormlite.support.CompiledStatement;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.support.DatabaseConnection;
import com.j256.ormlite.support.DatabaseResults;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class TableUtils {
  private static Logger logger = LoggerFactory.getLogger(TableUtils.class);
  
  private static final FieldType[] noFieldTypes = new FieldType[0];
  
  private static <T, ID> void addCreateIndexStatements(DatabaseType paramDatabaseType, TableInfo<T, ID> paramTableInfo, List<String> paramList, boolean paramBoolean1, boolean paramBoolean2) {
    HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
    for (FieldType fieldType : paramTableInfo.getFieldTypes()) {
      String str;
      if (paramBoolean2) {
        str = fieldType.getUniqueIndexName();
      } else {
        str = fieldType.getIndexName();
      } 
      if (str != null) {
        List<String> list2 = (List)hashMap.get(str);
        List<String> list1 = list2;
        if (list2 == null) {
          list1 = new ArrayList();
          hashMap.put(str, list1);
        } 
        list1.add(fieldType.getColumnName());
      } 
    } 
    StringBuilder stringBuilder = new StringBuilder(128);
    for (Map.Entry<Object, Object> entry : hashMap.entrySet()) {
      logger.info("creating index '{}' for table '{}", entry.getKey(), paramTableInfo.getTableName());
      stringBuilder.append("CREATE ");
      if (paramBoolean2)
        stringBuilder.append("UNIQUE "); 
      stringBuilder.append("INDEX ");
      if (paramBoolean1 && paramDatabaseType.isCreateIndexIfNotExistsSupported())
        stringBuilder.append("IF NOT EXISTS "); 
      paramDatabaseType.appendEscapedEntityName(stringBuilder, (String)entry.getKey());
      stringBuilder.append(" ON ");
      paramDatabaseType.appendEscapedEntityName(stringBuilder, paramTableInfo.getTableName());
      stringBuilder.append(" ( ");
      Iterator<String> iterator = ((List)entry.getValue()).iterator();
      boolean bool = true;
      while (iterator.hasNext()) {
        String str = iterator.next();
        if (bool) {
          bool = false;
        } else {
          stringBuilder.append(", ");
        } 
        paramDatabaseType.appendEscapedEntityName(stringBuilder, str);
      } 
      stringBuilder.append(" )");
      paramList.add(stringBuilder.toString());
      stringBuilder.setLength(0);
    } 
  }
  
  private static <T, ID> List<String> addCreateTableStatements(ConnectionSource paramConnectionSource, TableInfo<T, ID> paramTableInfo, boolean paramBoolean) throws SQLException {
    ArrayList<String> arrayList1 = new ArrayList();
    ArrayList<String> arrayList2 = new ArrayList();
    addCreateTableStatements(paramConnectionSource.getDatabaseType(), paramTableInfo, arrayList1, arrayList2, paramBoolean);
    return arrayList1;
  }
  
  private static <T, ID> void addCreateTableStatements(DatabaseType paramDatabaseType, TableInfo<T, ID> paramTableInfo, List<String> paramList1, List<String> paramList2, boolean paramBoolean) throws SQLException {
    StringBuilder stringBuilder = new StringBuilder(256);
    stringBuilder.append("CREATE TABLE ");
    if (paramBoolean && paramDatabaseType.isCreateIfNotExistsSupported())
      stringBuilder.append("IF NOT EXISTS "); 
    paramDatabaseType.appendEscapedEntityName(stringBuilder, paramTableInfo.getTableName());
    stringBuilder.append(" (");
    ArrayList arrayList = new ArrayList();
    ArrayList<? extends String> arrayList1 = new ArrayList();
    ArrayList<? extends String> arrayList2 = new ArrayList();
    FieldType[] arrayOfFieldType = paramTableInfo.getFieldTypes();
    int i = arrayOfFieldType.length;
    boolean bool = true;
    int j;
    for (j = 0; j < i; j++) {
      FieldType fieldType = arrayOfFieldType[j];
      if (!fieldType.isForeignCollection()) {
        if (bool) {
          bool = false;
        } else {
          stringBuilder.append(", ");
        } 
        String str = fieldType.getColumnDefinition();
        if (str == null) {
          paramDatabaseType.appendColumnArg(paramTableInfo.getTableName(), stringBuilder, fieldType, arrayList, arrayList1, arrayList2, paramList2);
        } else {
          paramDatabaseType.appendEscapedEntityName(stringBuilder, fieldType.getColumnName());
          stringBuilder.append(' ');
          stringBuilder.append(str);
          stringBuilder.append(' ');
        } 
      } 
    } 
    paramDatabaseType.addPrimaryKeySql(paramTableInfo.getFieldTypes(), arrayList, arrayList1, arrayList2, paramList2);
    paramDatabaseType.addUniqueComboSql(paramTableInfo.getFieldTypes(), arrayList, arrayList1, arrayList2, paramList2);
    for (String str : arrayList) {
      stringBuilder.append(", ");
      stringBuilder.append(str);
    } 
    stringBuilder.append(") ");
    paramDatabaseType.appendCreateTableSuffix(stringBuilder);
    paramList1.addAll(arrayList1);
    paramList1.add(stringBuilder.toString());
    paramList1.addAll(arrayList2);
    addCreateIndexStatements(paramDatabaseType, paramTableInfo, paramList1, paramBoolean, false);
    addCreateIndexStatements(paramDatabaseType, paramTableInfo, paramList1, paramBoolean, true);
  }
  
  private static <T, ID> void addDropIndexStatements(DatabaseType paramDatabaseType, TableInfo<T, ID> paramTableInfo, List<String> paramList) {
    HashSet<String> hashSet = new HashSet();
    for (FieldType fieldType : paramTableInfo.getFieldTypes()) {
      String str2 = fieldType.getIndexName();
      if (str2 != null)
        hashSet.add(str2); 
      String str1 = fieldType.getUniqueIndexName();
      if (str1 != null)
        hashSet.add(str1); 
    } 
    StringBuilder stringBuilder = new StringBuilder(48);
    for (String str : hashSet) {
      logger.info("dropping index '{}' for table '{}", str, paramTableInfo.getTableName());
      stringBuilder.append("DROP INDEX ");
      paramDatabaseType.appendEscapedEntityName(stringBuilder, str);
      paramList.add(stringBuilder.toString());
      stringBuilder.setLength(0);
    } 
  }
  
  private static <T, ID> void addDropTableStatements(DatabaseType paramDatabaseType, TableInfo<T, ID> paramTableInfo, List<String> paramList) {
    ArrayList<? extends String> arrayList1 = new ArrayList();
    ArrayList<? extends String> arrayList2 = new ArrayList();
    FieldType[] arrayOfFieldType = paramTableInfo.getFieldTypes();
    int j = arrayOfFieldType.length;
    for (int i = 0; i < j; i++)
      paramDatabaseType.dropColumnArg(arrayOfFieldType[i], arrayList1, arrayList2); 
    StringBuilder stringBuilder = new StringBuilder(64);
    stringBuilder.append("DROP TABLE ");
    paramDatabaseType.appendEscapedEntityName(stringBuilder, paramTableInfo.getTableName());
    stringBuilder.append(' ');
    paramList.addAll(arrayList1);
    paramList.add(stringBuilder.toString());
    paramList.addAll(arrayList2);
  }
  
  public static <T> int clearTable(ConnectionSource paramConnectionSource, DatabaseTableConfig<T> paramDatabaseTableConfig) throws SQLException {
    return clearTable(paramConnectionSource, paramDatabaseTableConfig.getTableName());
  }
  
  public static <T> int clearTable(ConnectionSource paramConnectionSource, Class<T> paramClass) throws SQLException {
    String str2 = DatabaseTableConfig.extractTableName(paramClass);
    String str1 = str2;
    if (paramConnectionSource.getDatabaseType().isEntityNamesMustBeUpCase())
      str1 = str2.toUpperCase(); 
    return clearTable(paramConnectionSource, str1);
  }
  
  private static <T> int clearTable(ConnectionSource paramConnectionSource, String paramString) throws SQLException {
    CompiledStatement compiledStatement;
    DatabaseType databaseType = paramConnectionSource.getDatabaseType();
    StringBuilder stringBuilder = new StringBuilder(48);
    if (databaseType.isTruncateSupported()) {
      stringBuilder.append("TRUNCATE TABLE ");
    } else {
      stringBuilder.append("DELETE FROM ");
    } 
    databaseType.appendEscapedEntityName(stringBuilder, paramString);
    null = stringBuilder.toString();
    logger.info("clearing table '{}' with '{}", paramString, null);
    paramString = null;
    DatabaseConnection databaseConnection = paramConnectionSource.getReadWriteConnection();
    try {
      CompiledStatement compiledStatement1 = databaseConnection.compileStatement(null, StatementBuilder.StatementType.EXECUTE, noFieldTypes, -1);
      compiledStatement = compiledStatement1;
      return compiledStatement1.runExecute();
    } finally {
      if (compiledStatement != null)
        compiledStatement.close(); 
      paramConnectionSource.releaseConnection(databaseConnection);
    } 
  }
  
  public static <T> int createTable(ConnectionSource paramConnectionSource, DatabaseTableConfig<T> paramDatabaseTableConfig) throws SQLException {
    return createTable(paramConnectionSource, paramDatabaseTableConfig, false);
  }
  
  private static <T, ID> int createTable(ConnectionSource paramConnectionSource, DatabaseTableConfig<T> paramDatabaseTableConfig, boolean paramBoolean) throws SQLException {
    Dao dao = DaoManager.createDao(paramConnectionSource, paramDatabaseTableConfig);
    if (dao instanceof BaseDaoImpl)
      return doCreateTable(paramConnectionSource, ((BaseDaoImpl)dao).getTableInfo(), paramBoolean); 
    paramDatabaseTableConfig.extractFieldTypes(paramConnectionSource);
    return doCreateTable(paramConnectionSource, new TableInfo<Object, Object>(paramConnectionSource.getDatabaseType(), null, paramDatabaseTableConfig), paramBoolean);
  }
  
  public static <T> int createTable(ConnectionSource paramConnectionSource, Class<T> paramClass) throws SQLException {
    return createTable(paramConnectionSource, paramClass, false);
  }
  
  private static <T, ID> int createTable(ConnectionSource paramConnectionSource, Class<T> paramClass, boolean paramBoolean) throws SQLException {
    Dao dao = DaoManager.createDao(paramConnectionSource, paramClass);
    return (dao instanceof BaseDaoImpl) ? doCreateTable(paramConnectionSource, ((BaseDaoImpl)dao).getTableInfo(), paramBoolean) : doCreateTable(paramConnectionSource, new TableInfo<Object, Object>(paramConnectionSource, null, paramClass), paramBoolean);
  }
  
  public static <T> int createTableIfNotExists(ConnectionSource paramConnectionSource, DatabaseTableConfig<T> paramDatabaseTableConfig) throws SQLException {
    return createTable(paramConnectionSource, paramDatabaseTableConfig, true);
  }
  
  public static <T> int createTableIfNotExists(ConnectionSource paramConnectionSource, Class<T> paramClass) throws SQLException {
    return createTable(paramConnectionSource, paramClass, true);
  }
  
  private static <T, ID> int doCreateTable(ConnectionSource paramConnectionSource, TableInfo<T, ID> paramTableInfo, boolean paramBoolean) throws SQLException {
    null = paramConnectionSource.getDatabaseType();
    logger.info("creating table '{}'", paramTableInfo.getTableName());
    ArrayList<String> arrayList1 = new ArrayList();
    ArrayList<String> arrayList2 = new ArrayList();
    addCreateTableStatements(null, paramTableInfo, arrayList1, arrayList2, paramBoolean);
    DatabaseConnection databaseConnection = paramConnectionSource.getReadWriteConnection();
    try {
      int i = doStatements(databaseConnection, "create", arrayList1, false, null.isCreateTableReturnsNegative(), null.isCreateTableReturnsZero());
      int j = doCreateTestQueries(databaseConnection, null, arrayList2);
      return i + j;
    } finally {
      paramConnectionSource.releaseConnection(databaseConnection);
    } 
  }
  
  private static int doCreateTestQueries(DatabaseConnection paramDatabaseConnection, DatabaseType paramDatabaseType, List<String> paramList) throws SQLException {
    Iterator<String> iterator = paramList.iterator();
    int i = 0;
    while (iterator.hasNext()) {
      String str = iterator.next();
      DatabaseConnection databaseConnection2 = null;
      paramDatabaseType = null;
      try {
        CompiledStatement compiledStatement = paramDatabaseConnection.compileStatement(str, StatementBuilder.StatementType.SELECT, noFieldTypes, -1);
        try {
          DatabaseResults databaseResults = compiledStatement.runQuery(null);
          boolean bool = databaseResults.first();
          int j = 0;
          while (bool) {
            j++;
            bool = databaseResults.next();
          } 
          logger.info("executing create table after-query got {} results: {}", Integer.valueOf(j), str);
          if (compiledStatement != null)
            compiledStatement.close(); 
          continue;
        } catch (SQLException sQLException1) {
          CompiledStatement compiledStatement1 = compiledStatement;
        } finally {
          SQLException sQLException1;
          paramDatabaseConnection = null;
        } 
      } catch (SQLException sQLException) {
        paramDatabaseConnection = databaseConnection2;
      } finally {}
      DatabaseConnection databaseConnection1 = paramDatabaseConnection;
      StringBuilder stringBuilder = new StringBuilder();
      databaseConnection1 = paramDatabaseConnection;
      stringBuilder.append("executing create table after-query failed: ");
      databaseConnection1 = paramDatabaseConnection;
      stringBuilder.append(str);
      databaseConnection1 = paramDatabaseConnection;
      throw SqlExceptionUtil.create(stringBuilder.toString(), sQLException);
    } 
    return i;
  }
  
  private static <T, ID> int doDropTable(DatabaseType paramDatabaseType, ConnectionSource paramConnectionSource, TableInfo<T, ID> paramTableInfo, boolean paramBoolean) throws SQLException {
    logger.info("dropping table '{}'", paramTableInfo.getTableName());
    ArrayList<String> arrayList = new ArrayList();
    addDropIndexStatements(paramDatabaseType, paramTableInfo, arrayList);
    addDropTableStatements(paramDatabaseType, paramTableInfo, arrayList);
    DatabaseConnection databaseConnection = paramConnectionSource.getReadWriteConnection();
    try {
      return doStatements(databaseConnection, "drop", arrayList, paramBoolean, paramDatabaseType.isCreateTableReturnsNegative(), false);
    } finally {
      paramConnectionSource.releaseConnection(databaseConnection);
    } 
  }
  
  private static int doStatements(DatabaseConnection paramDatabaseConnection, String paramString, Collection<String> paramCollection, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3) throws SQLException {
    // Byte code:
    //   0: aload_2
    //   1: invokeinterface iterator : ()Ljava/util/Iterator;
    //   6: astore #13
    //   8: iconst_0
    //   9: istore #8
    //   11: aload #13
    //   13: invokeinterface hasNext : ()Z
    //   18: ifeq -> 361
    //   21: aload #13
    //   23: invokeinterface next : ()Ljava/lang/Object;
    //   28: checkcast java/lang/String
    //   31: astore #12
    //   33: aconst_null
    //   34: astore #10
    //   36: aconst_null
    //   37: astore #9
    //   39: aload_0
    //   40: aload #12
    //   42: getstatic com/j256/ormlite/stmt/StatementBuilder$StatementType.EXECUTE : Lcom/j256/ormlite/stmt/StatementBuilder$StatementType;
    //   45: getstatic com/j256/ormlite/table/TableUtils.noFieldTypes : [Lcom/j256/ormlite/field/FieldType;
    //   48: iconst_m1
    //   49: invokeinterface compileStatement : (Ljava/lang/String;Lcom/j256/ormlite/stmt/StatementBuilder$StatementType;[Lcom/j256/ormlite/field/FieldType;I)Lcom/j256/ormlite/support/CompiledStatement;
    //   54: astore_2
    //   55: aload_2
    //   56: astore #9
    //   58: aload_2
    //   59: astore #10
    //   61: aload_2
    //   62: invokeinterface runExecute : ()I
    //   67: istore #6
    //   69: aload_2
    //   70: astore #9
    //   72: getstatic com/j256/ormlite/table/TableUtils.logger : Lcom/j256/ormlite/logger/Logger;
    //   75: ldc_w 'executed {} table statement changed {} rows: {}'
    //   78: aload_1
    //   79: iload #6
    //   81: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   84: aload #12
    //   86: invokevirtual info : (Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V
    //   89: iload #6
    //   91: istore #7
    //   93: aload_2
    //   94: ifnull -> 159
    //   97: aload_2
    //   98: invokeinterface close : ()V
    //   103: iload #6
    //   105: istore #7
    //   107: goto -> 159
    //   110: astore #11
    //   112: goto -> 127
    //   115: astore_0
    //   116: goto -> 347
    //   119: astore #11
    //   121: iconst_0
    //   122: istore #6
    //   124: aload #10
    //   126: astore_2
    //   127: iload_3
    //   128: ifeq -> 302
    //   131: aload_2
    //   132: astore #9
    //   134: getstatic com/j256/ormlite/table/TableUtils.logger : Lcom/j256/ormlite/logger/Logger;
    //   137: ldc_w 'ignoring {} error '{}' for statement: {}'
    //   140: aload_1
    //   141: aload #11
    //   143: aload #12
    //   145: invokevirtual info : (Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V
    //   148: iload #6
    //   150: istore #7
    //   152: aload_2
    //   153: ifnull -> 159
    //   156: goto -> 97
    //   159: iload #7
    //   161: ifge -> 230
    //   164: iload #4
    //   166: ifeq -> 172
    //   169: goto -> 293
    //   172: new java/lang/StringBuilder
    //   175: dup
    //   176: invokespecial <init> : ()V
    //   179: astore_0
    //   180: aload_0
    //   181: ldc_w 'SQL statement '
    //   184: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   187: pop
    //   188: aload_0
    //   189: aload #12
    //   191: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   194: pop
    //   195: aload_0
    //   196: ldc_w ' updated '
    //   199: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   202: pop
    //   203: aload_0
    //   204: iload #7
    //   206: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   209: pop
    //   210: aload_0
    //   211: ldc_w ' rows, we were expecting >= 0'
    //   214: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   217: pop
    //   218: new java/sql/SQLException
    //   221: dup
    //   222: aload_0
    //   223: invokevirtual toString : ()Ljava/lang/String;
    //   226: invokespecial <init> : (Ljava/lang/String;)V
    //   229: athrow
    //   230: iload #7
    //   232: ifle -> 293
    //   235: iload #5
    //   237: ifne -> 243
    //   240: goto -> 293
    //   243: new java/lang/StringBuilder
    //   246: dup
    //   247: invokespecial <init> : ()V
    //   250: astore_0
    //   251: aload_0
    //   252: ldc_w 'SQL statement updated '
    //   255: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   258: pop
    //   259: aload_0
    //   260: iload #7
    //   262: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   265: pop
    //   266: aload_0
    //   267: ldc_w ' rows, we were expecting == 0: '
    //   270: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   273: pop
    //   274: aload_0
    //   275: aload #12
    //   277: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   280: pop
    //   281: new java/sql/SQLException
    //   284: dup
    //   285: aload_0
    //   286: invokevirtual toString : ()Ljava/lang/String;
    //   289: invokespecial <init> : (Ljava/lang/String;)V
    //   292: athrow
    //   293: iload #8
    //   295: iconst_1
    //   296: iadd
    //   297: istore #8
    //   299: goto -> 11
    //   302: aload_2
    //   303: astore #9
    //   305: new java/lang/StringBuilder
    //   308: dup
    //   309: invokespecial <init> : ()V
    //   312: astore_0
    //   313: aload_2
    //   314: astore #9
    //   316: aload_0
    //   317: ldc_w 'SQL statement failed: '
    //   320: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   323: pop
    //   324: aload_2
    //   325: astore #9
    //   327: aload_0
    //   328: aload #12
    //   330: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   333: pop
    //   334: aload_2
    //   335: astore #9
    //   337: aload_0
    //   338: invokevirtual toString : ()Ljava/lang/String;
    //   341: aload #11
    //   343: invokestatic create : (Ljava/lang/String;Ljava/lang/Throwable;)Ljava/sql/SQLException;
    //   346: athrow
    //   347: aload #9
    //   349: ifnull -> 359
    //   352: aload #9
    //   354: invokeinterface close : ()V
    //   359: aload_0
    //   360: athrow
    //   361: iload #8
    //   363: ireturn
    // Exception table:
    //   from	to	target	type
    //   39	55	119	java/sql/SQLException
    //   39	55	115	finally
    //   61	69	119	java/sql/SQLException
    //   61	69	115	finally
    //   72	89	110	java/sql/SQLException
    //   72	89	115	finally
    //   134	148	115	finally
    //   305	313	115	finally
    //   316	324	115	finally
    //   327	334	115	finally
    //   337	347	115	finally
  }
  
  public static <T, ID> int dropTable(ConnectionSource paramConnectionSource, DatabaseTableConfig<T> paramDatabaseTableConfig, boolean paramBoolean) throws SQLException {
    DatabaseType databaseType = paramConnectionSource.getDatabaseType();
    Dao dao = DaoManager.createDao(paramConnectionSource, paramDatabaseTableConfig);
    if (dao instanceof BaseDaoImpl)
      return doDropTable(databaseType, paramConnectionSource, ((BaseDaoImpl)dao).getTableInfo(), paramBoolean); 
    paramDatabaseTableConfig.extractFieldTypes(paramConnectionSource);
    return doDropTable(databaseType, paramConnectionSource, new TableInfo<Object, Object>(databaseType, null, paramDatabaseTableConfig), paramBoolean);
  }
  
  public static <T, ID> int dropTable(ConnectionSource paramConnectionSource, Class<T> paramClass, boolean paramBoolean) throws SQLException {
    DatabaseType databaseType = paramConnectionSource.getDatabaseType();
    Dao dao = DaoManager.createDao(paramConnectionSource, paramClass);
    return (dao instanceof BaseDaoImpl) ? doDropTable(databaseType, paramConnectionSource, ((BaseDaoImpl)dao).getTableInfo(), paramBoolean) : doDropTable(databaseType, paramConnectionSource, new TableInfo<Object, Object>(paramConnectionSource, null, paramClass), paramBoolean);
  }
  
  public static <T, ID> List<String> getCreateTableStatements(ConnectionSource paramConnectionSource, DatabaseTableConfig<T> paramDatabaseTableConfig) throws SQLException {
    Dao dao = DaoManager.createDao(paramConnectionSource, paramDatabaseTableConfig);
    if (dao instanceof BaseDaoImpl)
      return addCreateTableStatements(paramConnectionSource, ((BaseDaoImpl)dao).getTableInfo(), false); 
    paramDatabaseTableConfig.extractFieldTypes(paramConnectionSource);
    return addCreateTableStatements(paramConnectionSource, new TableInfo<Object, Object>(paramConnectionSource.getDatabaseType(), null, paramDatabaseTableConfig), false);
  }
  
  public static <T, ID> List<String> getCreateTableStatements(ConnectionSource paramConnectionSource, Class<T> paramClass) throws SQLException {
    Dao dao = DaoManager.createDao(paramConnectionSource, paramClass);
    return (dao instanceof BaseDaoImpl) ? addCreateTableStatements(paramConnectionSource, ((BaseDaoImpl)dao).getTableInfo(), false) : addCreateTableStatements(paramConnectionSource, new TableInfo<Object, Object>(paramConnectionSource, null, paramClass), false);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\j256\ormlite\table\TableUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */