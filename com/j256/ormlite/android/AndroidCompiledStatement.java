package com.j256.ormlite.android;

import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import com.j256.ormlite.android.compat.ApiCompatibility;
import com.j256.ormlite.android.compat.ApiCompatibilityUtils;
import com.j256.ormlite.dao.ObjectCache;
import com.j256.ormlite.field.SqlType;
import com.j256.ormlite.logger.Logger;
import com.j256.ormlite.logger.LoggerFactory;
import com.j256.ormlite.misc.SqlExceptionUtil;
import com.j256.ormlite.stmt.StatementBuilder;
import com.j256.ormlite.support.CompiledStatement;
import com.j256.ormlite.support.DatabaseResults;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AndroidCompiledStatement implements CompiledStatement {
  private static final String[] NO_STRING_ARGS;
  
  private static final ApiCompatibility apiCompatibility;
  
  private static Logger logger = LoggerFactory.getLogger(AndroidCompiledStatement.class);
  
  private List<Object> args;
  
  private final boolean cancelQueriesEnabled;
  
  private ApiCompatibility.CancellationHook cancellationHook;
  
  private Cursor cursor;
  
  private final SQLiteDatabase db;
  
  private Integer max;
  
  private final String sql;
  
  private final StatementBuilder.StatementType type;
  
  static {
    NO_STRING_ARGS = new String[0];
    apiCompatibility = ApiCompatibilityUtils.getCompatibility();
  }
  
  public AndroidCompiledStatement(String paramString, SQLiteDatabase paramSQLiteDatabase, StatementBuilder.StatementType paramStatementType, boolean paramBoolean) {
    this.sql = paramString;
    this.db = paramSQLiteDatabase;
    this.type = paramStatementType;
    this.cancelQueriesEnabled = paramBoolean;
  }
  
  static int execSql(SQLiteDatabase paramSQLiteDatabase, String paramString1, String paramString2, Object[] paramArrayOfObject) throws SQLException {
    try {
      int i;
      paramSQLiteDatabase.execSQL(paramString2, paramArrayOfObject);
      paramArrayOfObject = null;
      SQLiteStatement sQLiteStatement = null;
      try {
        SQLiteStatement sQLiteStatement1 = paramSQLiteDatabase.compileStatement("SELECT CHANGES()");
        sQLiteStatement = sQLiteStatement1;
        SQLiteStatement sQLiteStatement2 = sQLiteStatement1;
        long l = sQLiteStatement1.simpleQueryForLong();
        int j = (int)l;
        i = j;
      } catch (SQLException sQLException) {
      
      } finally {
        if (sQLiteStatement != null)
          sQLiteStatement.close(); 
      } 
      paramSQLiteDatabase.close();
      logger.trace("executing statement {} changed {} rows: {}", paramString1, Integer.valueOf(i), paramString2);
      return i;
    } catch (SQLException sQLException) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Problems executing ");
      stringBuilder.append(paramString1);
      stringBuilder.append(" Android statement: ");
      stringBuilder.append(paramString2);
      throw SqlExceptionUtil.create(stringBuilder.toString(), sQLException);
    } 
  }
  
  private Object[] getArgArray() {
    List<Object> list = this.args;
    return (Object[])((list == null) ? NO_STRING_ARGS : list.toArray(new Object[list.size()]));
  }
  
  private String[] getStringArray() {
    List<Object> list = this.args;
    return (list == null) ? NO_STRING_ARGS : list.<String>toArray(new String[list.size()]);
  }
  
  private void isInPrep() throws SQLException {
    if (this.cursor == null)
      return; 
    throw new SQLException("Query already run. Cannot add argument values.");
  }
  
  public void cancel() {
    ApiCompatibility.CancellationHook cancellationHook = this.cancellationHook;
    if (cancellationHook != null)
      cancellationHook.cancel(); 
  }
  
  public void close() throws SQLException {
    Cursor cursor = this.cursor;
    if (cursor != null)
      try {
        cursor.close();
      } catch (SQLException sQLException) {
        throw SqlExceptionUtil.create("Problems closing Android cursor", sQLException);
      }  
    this.cancellationHook = null;
  }
  
  public void closeQuietly() {
    try {
      close();
      return;
    } catch (SQLException sQLException) {
      return;
    } 
  }
  
  public int getColumnCount() throws SQLException {
    return getCursor().getColumnCount();
  }
  
  public String getColumnName(int paramInt) throws SQLException {
    return getCursor().getColumnName(paramInt);
  }
  
  public Cursor getCursor() throws SQLException {
    if (this.cursor == null) {
      String str1 = null;
      String str2 = str1;
      try {
        if (this.max == null) {
          str2 = str1;
          str1 = this.sql;
        } else {
          str2 = str1;
          StringBuilder stringBuilder = new StringBuilder();
          str2 = str1;
          stringBuilder.append(this.sql);
          str2 = str1;
          stringBuilder.append(" ");
          str2 = str1;
          stringBuilder.append(this.max);
          str2 = str1;
          str1 = stringBuilder.toString();
        } 
        str2 = str1;
        if (this.cancelQueriesEnabled) {
          str2 = str1;
          this.cancellationHook = apiCompatibility.createCancellationHook();
        } 
        str2 = str1;
        this.cursor = apiCompatibility.rawQuery(this.db, str1, getStringArray(), this.cancellationHook);
        str2 = str1;
        this.cursor.moveToFirst();
        str2 = str1;
        logger.trace("{}: started rawQuery cursor for: {}", this, str1);
      } catch (SQLException sQLException) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Problems executing Android query: ");
        stringBuilder.append(str2);
        throw SqlExceptionUtil.create(stringBuilder.toString(), sQLException);
      } 
    } 
    return this.cursor;
  }
  
  public int runExecute() throws SQLException {
    if (this.type.isOkForExecute())
      return execSql(this.db, "runExecute", this.sql, getArgArray()); 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Cannot call execute on a ");
    stringBuilder.append(this.type);
    stringBuilder.append(" statement");
    throw new IllegalArgumentException(stringBuilder.toString());
  }
  
  public DatabaseResults runQuery(ObjectCache paramObjectCache) throws SQLException {
    if (this.type.isOkForQuery())
      return new AndroidDatabaseResults(getCursor(), paramObjectCache); 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Cannot call query on a ");
    stringBuilder.append(this.type);
    stringBuilder.append(" statement");
    throw new IllegalArgumentException(stringBuilder.toString());
  }
  
  public int runUpdate() throws SQLException {
    if (this.type.isOkForUpdate()) {
      String str;
      if (this.max == null) {
        str = this.sql;
      } else {
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append(this.sql);
        stringBuilder1.append(" ");
        stringBuilder1.append(this.max);
        str = stringBuilder1.toString();
      } 
      return execSql(this.db, "runUpdate", str, getArgArray());
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Cannot call update on a ");
    stringBuilder.append(this.type);
    stringBuilder.append(" statement");
    throw new IllegalArgumentException(stringBuilder.toString());
  }
  
  public void setMaxRows(int paramInt) throws SQLException {
    isInPrep();
    this.max = Integer.valueOf(paramInt);
  }
  
  public void setObject(int paramInt, Object paramObject, SqlType paramSqlType) throws SQLException {
    isInPrep();
    if (this.args == null)
      this.args = new ArrayList(); 
    if (paramObject == null) {
      this.args.add(paramInt, null);
      return;
    } 
    switch (paramSqlType) {
      default:
        paramObject = new StringBuilder();
        paramObject.append("Unknown sql argument type: ");
        paramObject.append(paramSqlType);
        throw new SQLException(paramObject.toString());
      case BLOB:
      case BIG_DECIMAL:
        paramObject = new StringBuilder();
        paramObject.append("Invalid Android type: ");
        paramObject.append(paramSqlType);
        throw new SQLException(paramObject.toString());
      case BYTE_ARRAY:
      case SERIALIZABLE:
        this.args.add(paramInt, paramObject);
        return;
      case STRING:
      case LONG_STRING:
      case DATE:
      case BOOLEAN:
      case CHAR:
      case BYTE:
      case SHORT:
      case INTEGER:
      case LONG:
      case FLOAT:
      case DOUBLE:
        break;
    } 
    this.args.add(paramInt, paramObject.toString());
  }
  
  public void setQueryTimeout(long paramLong) {}
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(getClass().getSimpleName());
    stringBuilder.append("@");
    stringBuilder.append(Integer.toHexString(hashCode()));
    return stringBuilder.toString();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\j256\ormlite\android\AndroidCompiledStatement.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */