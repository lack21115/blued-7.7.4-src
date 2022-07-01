package com.j256.ormlite.android;

import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import com.j256.ormlite.dao.ObjectCache;
import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.field.SqlType;
import com.j256.ormlite.logger.Logger;
import com.j256.ormlite.logger.LoggerFactory;
import com.j256.ormlite.misc.SqlExceptionUtil;
import com.j256.ormlite.misc.VersionUtils;
import com.j256.ormlite.stmt.GenericRowMapper;
import com.j256.ormlite.stmt.StatementBuilder;
import com.j256.ormlite.support.CompiledStatement;
import com.j256.ormlite.support.DatabaseConnection;
import com.j256.ormlite.support.GeneratedKeyHolder;
import java.sql.SQLException;
import java.sql.Savepoint;

public class AndroidDatabaseConnection implements DatabaseConnection {
  private static final String ANDROID_VERSION = "VERSION__4.48__";
  
  private static final String[] NO_STRING_ARGS;
  
  private static Logger logger = LoggerFactory.getLogger(AndroidDatabaseConnection.class);
  
  private final boolean cancelQueriesEnabled;
  
  private final SQLiteDatabase db;
  
  private final boolean readWrite;
  
  static {
    NO_STRING_ARGS = new String[0];
    VersionUtils.checkCoreVersusAndroidVersions("VERSION__4.48__");
  }
  
  public AndroidDatabaseConnection(SQLiteDatabase paramSQLiteDatabase, boolean paramBoolean) {
    this(paramSQLiteDatabase, paramBoolean, false);
  }
  
  public AndroidDatabaseConnection(SQLiteDatabase paramSQLiteDatabase, boolean paramBoolean1, boolean paramBoolean2) {
    this.db = paramSQLiteDatabase;
    this.readWrite = paramBoolean1;
    this.cancelQueriesEnabled = paramBoolean2;
    logger.trace("{}: db {} opened, read-write = {}", this, paramSQLiteDatabase, Boolean.valueOf(paramBoolean1));
  }
  
  private void bindArgs(SQLiteStatement paramSQLiteStatement, Object[] paramArrayOfObject, FieldType[] paramArrayOfFieldType) throws SQLException {
    if (paramArrayOfObject == null)
      return; 
    int i;
    for (i = 0; i < paramArrayOfObject.length; i++) {
      Object object = paramArrayOfObject[i];
      if (object == null) {
        paramSQLiteStatement.bindNull(i + 1);
      } else {
        StringBuilder stringBuilder;
        SqlType sqlType = paramArrayOfFieldType[i].getSqlType();
        switch (sqlType) {
          default:
            stringBuilder = new StringBuilder();
            stringBuilder.append("Unknown sql argument type: ");
            stringBuilder.append(sqlType);
            throw new SQLException(stringBuilder.toString());
          case DATE:
          case BLOB:
          case BIG_DECIMAL:
            stringBuilder = new StringBuilder();
            stringBuilder.append("Invalid Android type: ");
            stringBuilder.append(sqlType);
            throw new SQLException(stringBuilder.toString());
          case BYTE_ARRAY:
          case SERIALIZABLE:
            stringBuilder.bindBlob(i + 1, (byte[])object);
            break;
          case FLOAT:
          case DOUBLE:
            stringBuilder.bindDouble(i + 1, ((Number)object).doubleValue());
            break;
          case BOOLEAN:
          case BYTE:
          case SHORT:
          case INTEGER:
          case LONG:
            stringBuilder.bindLong(i + 1, ((Number)object).longValue());
            break;
          case STRING:
          case LONG_STRING:
          case CHAR:
            stringBuilder.bindString(i + 1, object.toString());
            break;
        } 
      } 
    } 
  }
  
  private String[] toStrings(Object[] paramArrayOfObject) {
    if (paramArrayOfObject != null) {
      if (paramArrayOfObject.length == 0)
        return null; 
      String[] arrayOfString = new String[paramArrayOfObject.length];
      for (int i = 0; i < paramArrayOfObject.length; i++) {
        Object object = paramArrayOfObject[i];
        if (object == null) {
          arrayOfString[i] = null;
        } else {
          arrayOfString[i] = object.toString();
        } 
      } 
      return arrayOfString;
    } 
    return null;
  }
  
  private int update(String paramString1, Object[] paramArrayOfObject, FieldType[] paramArrayOfFieldType, String paramString2) throws SQLException {
    SQLiteStatement sQLiteStatement = null;
    Object[] arrayOfObject2 = null;
    Object[] arrayOfObject3 = null;
    try {
      SQLiteStatement sQLiteStatement1 = this.db.compileStatement(paramString1);
      try {
        SQLiteStatement sQLiteStatement2;
        int i;
        bindArgs(sQLiteStatement1, paramArrayOfObject, paramArrayOfFieldType);
        sQLiteStatement1.execute();
        if (sQLiteStatement1 != null) {
          sQLiteStatement1.close();
          paramArrayOfObject = arrayOfObject3;
        } else {
          sQLiteStatement2 = sQLiteStatement1;
        } 
        sQLiteStatement = sQLiteStatement2;
        try {
          SQLiteStatement sQLiteStatement3 = this.db.compileStatement("SELECT CHANGES()");
          sQLiteStatement = sQLiteStatement3;
          sQLiteStatement2 = sQLiteStatement3;
          long l = sQLiteStatement3.simpleQueryForLong();
          int j = (int)l;
          i = j;
        } catch (SQLException null) {
        
        } finally {
          if (sQLiteStatement != null)
            sQLiteStatement.close(); 
        } 
        sQLiteStatement2.close();
        return i;
      } catch (SQLException null) {
      
      } finally {
        paramString1 = null;
      } 
    } catch (SQLException sQLException) {
      paramArrayOfObject = arrayOfObject2;
    } finally {}
    Object[] arrayOfObject1 = paramArrayOfObject;
    StringBuilder stringBuilder = new StringBuilder();
    arrayOfObject1 = paramArrayOfObject;
    stringBuilder.append("updating database failed: ");
    arrayOfObject1 = paramArrayOfObject;
    stringBuilder.append(paramString1);
    arrayOfObject1 = paramArrayOfObject;
    throw SqlExceptionUtil.create(stringBuilder.toString(), sQLException);
  }
  
  public void close() throws SQLException {
    try {
      this.db.close();
      logger.trace("{}: db {} closed", this, this.db);
      return;
    } catch (SQLException sQLException) {
      throw SqlExceptionUtil.create("problems closing the database connection", sQLException);
    } 
  }
  
  public void closeQuietly() {
    try {
      close();
      return;
    } catch (SQLException sQLException) {
      return;
    } 
  }
  
  public void commit(Savepoint paramSavepoint) throws SQLException {
    try {
      this.db.setTransactionSuccessful();
      this.db.endTransaction();
      if (paramSavepoint == null) {
        logger.trace("{}: transaction is successfuly ended", this);
        return;
      } 
      logger.trace("{}: transaction {} is successfuly ended", this, paramSavepoint.getSavepointName());
      return;
    } catch (SQLException sQLException) {
      if (paramSavepoint == null)
        throw SqlExceptionUtil.create("problems commiting transaction", sQLException); 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("problems commiting transaction ");
      stringBuilder.append(paramSavepoint.getSavepointName());
      throw SqlExceptionUtil.create(stringBuilder.toString(), sQLException);
    } 
  }
  
  public CompiledStatement compileStatement(String paramString, StatementBuilder.StatementType paramStatementType, FieldType[] paramArrayOfFieldType, int paramInt) {
    AndroidCompiledStatement androidCompiledStatement = new AndroidCompiledStatement(paramString, this.db, paramStatementType, this.cancelQueriesEnabled);
    logger.trace("{}: compiled statement got {}: {}", this, androidCompiledStatement, paramString);
    return androidCompiledStatement;
  }
  
  public int delete(String paramString, Object[] paramArrayOfObject, FieldType[] paramArrayOfFieldType) throws SQLException {
    return update(paramString, paramArrayOfObject, paramArrayOfFieldType, "deleted");
  }
  
  public int executeStatement(String paramString, int paramInt) throws SQLException {
    return AndroidCompiledStatement.execSql(this.db, paramString, paramString, (Object[])NO_STRING_ARGS);
  }
  
  public int insert(String paramString, Object[] paramArrayOfObject, FieldType[] paramArrayOfFieldType, GeneratedKeyHolder paramGeneratedKeyHolder) throws SQLException {
    SQLiteStatement sQLiteStatement2 = null;
    SQLiteStatement sQLiteStatement1 = null;
    try {
      SQLiteStatement sQLiteStatement = this.db.compileStatement(paramString);
      sQLiteStatement1 = sQLiteStatement;
      sQLiteStatement2 = sQLiteStatement;
      bindArgs(sQLiteStatement, paramArrayOfObject, paramArrayOfFieldType);
      sQLiteStatement1 = sQLiteStatement;
      sQLiteStatement2 = sQLiteStatement;
      long l = sQLiteStatement.executeInsert();
      if (paramGeneratedKeyHolder != null) {
        sQLiteStatement1 = sQLiteStatement;
        sQLiteStatement2 = sQLiteStatement;
        paramGeneratedKeyHolder.addKey(Long.valueOf(l));
      } 
      sQLiteStatement1 = sQLiteStatement;
      sQLiteStatement2 = sQLiteStatement;
      logger.trace("{}: insert statement is compiled and executed, changed {}: {}", this, Integer.valueOf(1), paramString);
      if (sQLiteStatement != null)
        sQLiteStatement.close(); 
      return 1;
    } catch (SQLException sQLException) {
      sQLiteStatement1 = sQLiteStatement2;
      StringBuilder stringBuilder = new StringBuilder();
      sQLiteStatement1 = sQLiteStatement2;
      stringBuilder.append("inserting to database failed: ");
      sQLiteStatement1 = sQLiteStatement2;
      stringBuilder.append(paramString);
      sQLiteStatement1 = sQLiteStatement2;
      throw SqlExceptionUtil.create(stringBuilder.toString(), sQLException);
    } finally {}
    if (sQLiteStatement1 != null)
      sQLiteStatement1.close(); 
    throw paramString;
  }
  
  public boolean isAutoCommit() throws SQLException {
    try {
      boolean bool = this.db.inTransaction();
      logger.trace("{}: in transaction is {}", this, Boolean.valueOf(bool));
      return bool ^ true;
    } catch (SQLException sQLException) {
      throw SqlExceptionUtil.create("problems getting auto-commit from database", sQLException);
    } 
  }
  
  public boolean isAutoCommitSupported() {
    return true;
  }
  
  public boolean isClosed() throws SQLException {
    try {
      boolean bool = this.db.isOpen();
      logger.trace("{}: db {} isOpen returned {}", this, this.db, Boolean.valueOf(bool));
      return bool ^ true;
    } catch (SQLException sQLException) {
      throw SqlExceptionUtil.create("problems detecting if the database is closed", sQLException);
    } 
  }
  
  public boolean isReadWrite() {
    return this.readWrite;
  }
  
  public boolean isTableExists(String paramString) {
    boolean bool;
    SQLiteDatabase sQLiteDatabase = this.db;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("SELECT DISTINCT tbl_name FROM sqlite_master WHERE tbl_name = '");
    stringBuilder.append(paramString);
    stringBuilder.append("'");
    Cursor cursor = sQLiteDatabase.rawQuery(stringBuilder.toString(), null);
    try {
      if (cursor.getCount() > 0) {
        boolean bool1 = true;
        logger.trace("{}: isTableExists '{}' returned {}", this, paramString, Boolean.valueOf(bool1));
        return bool1;
      } 
    } finally {
      cursor.close();
    } 
    logger.trace("{}: isTableExists '{}' returned {}", this, paramString, Boolean.valueOf(bool));
    cursor.close();
    return bool;
  }
  
  public long queryForLong(String paramString) throws SQLException {
    SQLiteStatement sQLiteStatement2 = null;
    SQLiteStatement sQLiteStatement1 = null;
    try {
      SQLiteStatement sQLiteStatement = this.db.compileStatement(paramString);
      sQLiteStatement1 = sQLiteStatement;
      sQLiteStatement2 = sQLiteStatement;
      long l = sQLiteStatement.simpleQueryForLong();
      sQLiteStatement1 = sQLiteStatement;
      sQLiteStatement2 = sQLiteStatement;
      logger.trace("{}: query for long simple query returned {}: {}", this, Long.valueOf(l), paramString);
      if (sQLiteStatement != null)
        sQLiteStatement.close(); 
      return l;
    } catch (SQLException sQLException) {
      sQLiteStatement1 = sQLiteStatement2;
      StringBuilder stringBuilder = new StringBuilder();
      sQLiteStatement1 = sQLiteStatement2;
      stringBuilder.append("queryForLong from database failed: ");
      sQLiteStatement1 = sQLiteStatement2;
      stringBuilder.append(paramString);
      sQLiteStatement1 = sQLiteStatement2;
      throw SqlExceptionUtil.create(stringBuilder.toString(), sQLException);
    } finally {}
    if (sQLiteStatement1 != null)
      sQLiteStatement1.close(); 
    throw paramString;
  }
  
  public long queryForLong(String paramString, Object[] paramArrayOfObject, FieldType[] paramArrayOfFieldType) throws SQLException {
    // Byte code:
    //   0: aload_0
    //   1: getfield db : Landroid/database/sqlite/SQLiteDatabase;
    //   4: aload_1
    //   5: aload_0
    //   6: aload_2
    //   7: invokespecial toStrings : ([Ljava/lang/Object;)[Ljava/lang/String;
    //   10: invokevirtual rawQuery : (Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   13: astore_3
    //   14: aload_3
    //   15: astore_2
    //   16: new com/j256/ormlite/android/AndroidDatabaseResults
    //   19: dup
    //   20: aload_3
    //   21: aconst_null
    //   22: invokespecial <init> : (Landroid/database/Cursor;Lcom/j256/ormlite/dao/ObjectCache;)V
    //   25: astore #6
    //   27: aload_3
    //   28: astore_2
    //   29: aload #6
    //   31: invokevirtual first : ()Z
    //   34: ifeq -> 153
    //   37: aload_3
    //   38: astore_2
    //   39: aload #6
    //   41: iconst_0
    //   42: invokevirtual getLong : (I)J
    //   45: lstore #4
    //   47: goto -> 50
    //   50: aload_3
    //   51: astore_2
    //   52: getstatic com/j256/ormlite/android/AndroidDatabaseConnection.logger : Lcom/j256/ormlite/logger/Logger;
    //   55: ldc_w '{}: query for long raw query returned {}: {}'
    //   58: aload_0
    //   59: lload #4
    //   61: invokestatic valueOf : (J)Ljava/lang/Long;
    //   64: aload_1
    //   65: invokevirtual trace : (Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V
    //   68: aload_3
    //   69: ifnull -> 78
    //   72: aload_3
    //   73: invokeinterface close : ()V
    //   78: lload #4
    //   80: lreturn
    //   81: astore #6
    //   83: goto -> 96
    //   86: astore_1
    //   87: aconst_null
    //   88: astore_2
    //   89: goto -> 141
    //   92: astore #6
    //   94: aconst_null
    //   95: astore_3
    //   96: aload_3
    //   97: astore_2
    //   98: new java/lang/StringBuilder
    //   101: dup
    //   102: invokespecial <init> : ()V
    //   105: astore #7
    //   107: aload_3
    //   108: astore_2
    //   109: aload #7
    //   111: ldc_w 'queryForLong from database failed: '
    //   114: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   117: pop
    //   118: aload_3
    //   119: astore_2
    //   120: aload #7
    //   122: aload_1
    //   123: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   126: pop
    //   127: aload_3
    //   128: astore_2
    //   129: aload #7
    //   131: invokevirtual toString : ()Ljava/lang/String;
    //   134: aload #6
    //   136: invokestatic create : (Ljava/lang/String;Ljava/lang/Throwable;)Ljava/sql/SQLException;
    //   139: athrow
    //   140: astore_1
    //   141: aload_2
    //   142: ifnull -> 151
    //   145: aload_2
    //   146: invokeinterface close : ()V
    //   151: aload_1
    //   152: athrow
    //   153: lconst_0
    //   154: lstore #4
    //   156: goto -> 50
    // Exception table:
    //   from	to	target	type
    //   0	14	92	android/database/SQLException
    //   0	14	86	finally
    //   16	27	81	android/database/SQLException
    //   16	27	140	finally
    //   29	37	81	android/database/SQLException
    //   29	37	140	finally
    //   39	47	81	android/database/SQLException
    //   39	47	140	finally
    //   52	68	81	android/database/SQLException
    //   52	68	140	finally
    //   98	107	140	finally
    //   109	118	140	finally
    //   120	127	140	finally
    //   129	140	140	finally
  }
  
  public <T> Object queryForOne(String paramString, Object[] paramArrayOfObject, FieldType[] paramArrayOfFieldType, GenericRowMapper<T> paramGenericRowMapper, ObjectCache paramObjectCache) throws SQLException {
    // Byte code:
    //   0: aload_0
    //   1: getfield db : Landroid/database/sqlite/SQLiteDatabase;
    //   4: aload_1
    //   5: aload_0
    //   6: aload_2
    //   7: invokespecial toStrings : ([Ljava/lang/Object;)[Ljava/lang/String;
    //   10: invokevirtual rawQuery : (Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   13: astore_3
    //   14: aload_3
    //   15: astore_2
    //   16: new com/j256/ormlite/android/AndroidDatabaseResults
    //   19: dup
    //   20: aload_3
    //   21: aload #5
    //   23: invokespecial <init> : (Landroid/database/Cursor;Lcom/j256/ormlite/dao/ObjectCache;)V
    //   26: astore #5
    //   28: aload_3
    //   29: astore_2
    //   30: getstatic com/j256/ormlite/android/AndroidDatabaseConnection.logger : Lcom/j256/ormlite/logger/Logger;
    //   33: ldc_w '{}: queried for one result: {}'
    //   36: aload_0
    //   37: aload_1
    //   38: invokevirtual trace : (Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V
    //   41: aload_3
    //   42: astore_2
    //   43: aload #5
    //   45: invokevirtual first : ()Z
    //   48: istore #6
    //   50: iload #6
    //   52: ifne -> 67
    //   55: aload_3
    //   56: ifnull -> 65
    //   59: aload_3
    //   60: invokeinterface close : ()V
    //   65: aconst_null
    //   66: areturn
    //   67: aload_3
    //   68: astore_2
    //   69: aload #4
    //   71: aload #5
    //   73: invokeinterface mapRow : (Lcom/j256/ormlite/support/DatabaseResults;)Ljava/lang/Object;
    //   78: astore #4
    //   80: aload_3
    //   81: astore_2
    //   82: aload #5
    //   84: invokevirtual next : ()Z
    //   87: ifeq -> 110
    //   90: aload_3
    //   91: astore_2
    //   92: getstatic com/j256/ormlite/android/AndroidDatabaseConnection.MORE_THAN_ONE : Ljava/lang/Object;
    //   95: astore #4
    //   97: aload_3
    //   98: ifnull -> 107
    //   101: aload_3
    //   102: invokeinterface close : ()V
    //   107: aload #4
    //   109: areturn
    //   110: aload_3
    //   111: ifnull -> 120
    //   114: aload_3
    //   115: invokeinterface close : ()V
    //   120: aload #4
    //   122: areturn
    //   123: astore #4
    //   125: goto -> 138
    //   128: astore_1
    //   129: aconst_null
    //   130: astore_2
    //   131: goto -> 183
    //   134: astore #4
    //   136: aconst_null
    //   137: astore_3
    //   138: aload_3
    //   139: astore_2
    //   140: new java/lang/StringBuilder
    //   143: dup
    //   144: invokespecial <init> : ()V
    //   147: astore #5
    //   149: aload_3
    //   150: astore_2
    //   151: aload #5
    //   153: ldc_w 'queryForOne from database failed: '
    //   156: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   159: pop
    //   160: aload_3
    //   161: astore_2
    //   162: aload #5
    //   164: aload_1
    //   165: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   168: pop
    //   169: aload_3
    //   170: astore_2
    //   171: aload #5
    //   173: invokevirtual toString : ()Ljava/lang/String;
    //   176: aload #4
    //   178: invokestatic create : (Ljava/lang/String;Ljava/lang/Throwable;)Ljava/sql/SQLException;
    //   181: athrow
    //   182: astore_1
    //   183: aload_2
    //   184: ifnull -> 193
    //   187: aload_2
    //   188: invokeinterface close : ()V
    //   193: aload_1
    //   194: athrow
    // Exception table:
    //   from	to	target	type
    //   0	14	134	android/database/SQLException
    //   0	14	128	finally
    //   16	28	123	android/database/SQLException
    //   16	28	182	finally
    //   30	41	123	android/database/SQLException
    //   30	41	182	finally
    //   43	50	123	android/database/SQLException
    //   43	50	182	finally
    //   69	80	123	android/database/SQLException
    //   69	80	182	finally
    //   82	90	123	android/database/SQLException
    //   82	90	182	finally
    //   92	97	123	android/database/SQLException
    //   92	97	182	finally
    //   140	149	182	finally
    //   151	160	182	finally
    //   162	169	182	finally
    //   171	182	182	finally
  }
  
  public void rollback(Savepoint paramSavepoint) throws SQLException {
    try {
      this.db.endTransaction();
      if (paramSavepoint == null) {
        logger.trace("{}: transaction is ended, unsuccessfuly", this);
        return;
      } 
      logger.trace("{}: transaction {} is ended, unsuccessfuly", this, paramSavepoint.getSavepointName());
      return;
    } catch (SQLException sQLException) {
      if (paramSavepoint == null)
        throw SqlExceptionUtil.create("problems rolling back transaction", sQLException); 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("problems rolling back transaction ");
      stringBuilder.append(paramSavepoint.getSavepointName());
      throw SqlExceptionUtil.create(stringBuilder.toString(), sQLException);
    } 
  }
  
  public void setAutoCommit(boolean paramBoolean) {
    if (paramBoolean) {
      if (this.db.inTransaction()) {
        this.db.setTransactionSuccessful();
        this.db.endTransaction();
        return;
      } 
    } else if (!this.db.inTransaction()) {
      this.db.beginTransaction();
    } 
  }
  
  public Savepoint setSavePoint(String paramString) throws SQLException {
    try {
      this.db.beginTransaction();
      logger.trace("{}: save-point set with name {}", this, paramString);
      return new OurSavePoint(paramString);
    } catch (SQLException sQLException) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("problems beginning transaction ");
      stringBuilder.append(paramString);
      throw SqlExceptionUtil.create(stringBuilder.toString(), sQLException);
    } 
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(getClass().getSimpleName());
    stringBuilder.append("@");
    stringBuilder.append(Integer.toHexString(hashCode()));
    return stringBuilder.toString();
  }
  
  public int update(String paramString, Object[] paramArrayOfObject, FieldType[] paramArrayOfFieldType) throws SQLException {
    return update(paramString, paramArrayOfObject, paramArrayOfFieldType, "updated");
  }
  
  static class OurSavePoint implements Savepoint {
    private String name;
    
    public OurSavePoint(String param1String) {
      this.name = param1String;
    }
    
    public int getSavepointId() {
      return 0;
    }
    
    public String getSavepointName() {
      return this.name;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\j256\ormlite\android\AndroidDatabaseConnection.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */