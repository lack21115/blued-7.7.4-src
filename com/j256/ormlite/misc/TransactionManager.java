package com.j256.ormlite.misc;

import com.j256.ormlite.db.DatabaseType;
import com.j256.ormlite.logger.Logger;
import com.j256.ormlite.logger.LoggerFactory;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.support.DatabaseConnection;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;

public class TransactionManager {
  private static final String SAVE_POINT_PREFIX = "ORMLITE";
  
  private static final Logger logger = LoggerFactory.getLogger(TransactionManager.class);
  
  private static AtomicInteger savePointCounter = new AtomicInteger();
  
  private ConnectionSource connectionSource;
  
  public TransactionManager() {}
  
  public TransactionManager(ConnectionSource paramConnectionSource) {
    this.connectionSource = paramConnectionSource;
    initialize();
  }
  
  public static <T> T callInTransaction(ConnectionSource paramConnectionSource, Callable<T> paramCallable) throws SQLException {
    DatabaseConnection databaseConnection = paramConnectionSource.getReadWriteConnection();
    try {
      paramCallable = callInTransaction(databaseConnection, paramConnectionSource.saveSpecialConnection(databaseConnection), paramConnectionSource.getDatabaseType(), (Callable)paramCallable);
      return (T)paramCallable;
    } finally {
      paramConnectionSource.clearSpecialConnection(databaseConnection);
      paramConnectionSource.releaseConnection(databaseConnection);
    } 
  }
  
  public static <T> T callInTransaction(DatabaseConnection paramDatabaseConnection, DatabaseType paramDatabaseType, Callable<T> paramCallable) throws SQLException {
    return callInTransaction(paramDatabaseConnection, false, paramDatabaseType, paramCallable);
  }
  
  public static <T> T callInTransaction(DatabaseConnection paramDatabaseConnection, boolean paramBoolean, DatabaseType paramDatabaseType, Callable<T> paramCallable) throws SQLException {
    // Byte code:
    //   0: aconst_null
    //   1: astore #8
    //   3: iconst_0
    //   4: istore #4
    //   6: iconst_0
    //   7: istore #6
    //   9: iconst_0
    //   10: istore #7
    //   12: iload_1
    //   13: ifne -> 32
    //   16: iload #6
    //   18: istore #5
    //   20: aload_2
    //   21: invokeinterface isNestedSavePointsSupported : ()Z
    //   26: ifeq -> 334
    //   29: goto -> 32
    //   32: iload #7
    //   34: istore_1
    //   35: iload #6
    //   37: istore #5
    //   39: aload_0
    //   40: invokeinterface isAutoCommitSupported : ()Z
    //   45: ifeq -> 89
    //   48: iload #6
    //   50: istore #5
    //   52: aload_0
    //   53: invokeinterface isAutoCommit : ()Z
    //   58: istore #6
    //   60: iload #6
    //   62: ifeq -> 86
    //   65: iload #6
    //   67: istore_1
    //   68: aload_0
    //   69: iconst_0
    //   70: invokeinterface setAutoCommit : (Z)V
    //   75: iload #6
    //   77: istore_1
    //   78: getstatic com/j256/ormlite/misc/TransactionManager.logger : Lcom/j256/ormlite/logger/Logger;
    //   81: ldc 'had to set auto-commit to false'
    //   83: invokevirtual debug : (Ljava/lang/String;)V
    //   86: iload #6
    //   88: istore_1
    //   89: iload_1
    //   90: istore #5
    //   92: new java/lang/StringBuilder
    //   95: dup
    //   96: invokespecial <init> : ()V
    //   99: astore_2
    //   100: iload_1
    //   101: istore #5
    //   103: aload_2
    //   104: ldc 'ORMLITE'
    //   106: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   109: pop
    //   110: iload_1
    //   111: istore #5
    //   113: aload_2
    //   114: getstatic com/j256/ormlite/misc/TransactionManager.savePointCounter : Ljava/util/concurrent/atomic/AtomicInteger;
    //   117: invokevirtual incrementAndGet : ()I
    //   120: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   123: pop
    //   124: iload_1
    //   125: istore #5
    //   127: aload_0
    //   128: aload_2
    //   129: invokevirtual toString : ()Ljava/lang/String;
    //   132: invokeinterface setSavePoint : (Ljava/lang/String;)Ljava/sql/Savepoint;
    //   137: astore_2
    //   138: aload_2
    //   139: ifnonnull -> 156
    //   142: iload_1
    //   143: istore #5
    //   145: getstatic com/j256/ormlite/misc/TransactionManager.logger : Lcom/j256/ormlite/logger/Logger;
    //   148: ldc 'started savePoint transaction'
    //   150: invokevirtual debug : (Ljava/lang/String;)V
    //   153: goto -> 173
    //   156: iload_1
    //   157: istore #5
    //   159: getstatic com/j256/ormlite/misc/TransactionManager.logger : Lcom/j256/ormlite/logger/Logger;
    //   162: ldc 'started savePoint transaction {}'
    //   164: aload_2
    //   165: invokeinterface getSavepointName : ()Ljava/lang/String;
    //   170: invokevirtual debug : (Ljava/lang/String;Ljava/lang/Object;)V
    //   173: iconst_1
    //   174: istore #4
    //   176: iload_1
    //   177: istore #5
    //   179: iload #5
    //   181: istore_1
    //   182: aload_3
    //   183: invokeinterface call : ()Ljava/lang/Object;
    //   188: astore_3
    //   189: iload #4
    //   191: ifeq -> 202
    //   194: iload #5
    //   196: istore_1
    //   197: aload_0
    //   198: aload_2
    //   199: invokestatic commit : (Lcom/j256/ormlite/support/DatabaseConnection;Ljava/sql/Savepoint;)V
    //   202: iload #5
    //   204: ifeq -> 222
    //   207: aload_0
    //   208: iconst_1
    //   209: invokeinterface setAutoCommit : (Z)V
    //   214: getstatic com/j256/ormlite/misc/TransactionManager.logger : Lcom/j256/ormlite/logger/Logger;
    //   217: ldc 'restored auto-commit to true'
    //   219: invokevirtual debug : (Ljava/lang/String;)V
    //   222: aload_3
    //   223: areturn
    //   224: astore_2
    //   225: goto -> 305
    //   228: astore_3
    //   229: iload #4
    //   231: ifeq -> 257
    //   234: iload #5
    //   236: istore_1
    //   237: aload_0
    //   238: aload_2
    //   239: invokestatic rollBack : (Lcom/j256/ormlite/support/DatabaseConnection;Ljava/sql/Savepoint;)V
    //   242: goto -> 257
    //   245: iload #5
    //   247: istore_1
    //   248: getstatic com/j256/ormlite/misc/TransactionManager.logger : Lcom/j256/ormlite/logger/Logger;
    //   251: aload_3
    //   252: ldc 'after commit exception, rolling back to save-point also threw exception'
    //   254: invokevirtual error : (Ljava/lang/Throwable;Ljava/lang/String;)V
    //   257: iload #5
    //   259: istore_1
    //   260: ldc 'Transaction callable threw non-SQL exception'
    //   262: aload_3
    //   263: invokestatic create : (Ljava/lang/String;Ljava/lang/Throwable;)Ljava/sql/SQLException;
    //   266: athrow
    //   267: astore_3
    //   268: iload #4
    //   270: ifeq -> 296
    //   273: iload #5
    //   275: istore_1
    //   276: aload_0
    //   277: aload_2
    //   278: invokestatic rollBack : (Lcom/j256/ormlite/support/DatabaseConnection;Ljava/sql/Savepoint;)V
    //   281: goto -> 296
    //   284: iload #5
    //   286: istore_1
    //   287: getstatic com/j256/ormlite/misc/TransactionManager.logger : Lcom/j256/ormlite/logger/Logger;
    //   290: aload_3
    //   291: ldc 'after commit exception, rolling back to save-point also threw exception'
    //   293: invokevirtual error : (Ljava/lang/Throwable;Ljava/lang/String;)V
    //   296: iload #5
    //   298: istore_1
    //   299: aload_3
    //   300: athrow
    //   301: astore_2
    //   302: iload #5
    //   304: istore_1
    //   305: iload_1
    //   306: ifeq -> 324
    //   309: aload_0
    //   310: iconst_1
    //   311: invokeinterface setAutoCommit : (Z)V
    //   316: getstatic com/j256/ormlite/misc/TransactionManager.logger : Lcom/j256/ormlite/logger/Logger;
    //   319: ldc 'restored auto-commit to true'
    //   321: invokevirtual debug : (Ljava/lang/String;)V
    //   324: aload_2
    //   325: athrow
    //   326: astore_2
    //   327: goto -> 245
    //   330: astore_2
    //   331: goto -> 284
    //   334: iconst_0
    //   335: istore #5
    //   337: aload #8
    //   339: astore_2
    //   340: goto -> 179
    // Exception table:
    //   from	to	target	type
    //   20	29	301	finally
    //   39	48	301	finally
    //   52	60	301	finally
    //   68	75	224	finally
    //   78	86	224	finally
    //   92	100	301	finally
    //   103	110	301	finally
    //   113	124	301	finally
    //   127	138	301	finally
    //   145	153	301	finally
    //   159	173	301	finally
    //   182	189	267	java/sql/SQLException
    //   182	189	228	java/lang/Exception
    //   182	189	224	finally
    //   197	202	267	java/sql/SQLException
    //   197	202	228	java/lang/Exception
    //   197	202	224	finally
    //   237	242	326	java/sql/SQLException
    //   237	242	224	finally
    //   248	257	224	finally
    //   260	267	224	finally
    //   276	281	330	java/sql/SQLException
    //   276	281	224	finally
    //   287	296	224	finally
    //   299	301	224	finally
  }
  
  private static void commit(DatabaseConnection paramDatabaseConnection, Savepoint paramSavepoint) throws SQLException {
    String str;
    if (paramSavepoint == null) {
      str = null;
    } else {
      str = paramSavepoint.getSavepointName();
    } 
    paramDatabaseConnection.commit(paramSavepoint);
    if (str == null) {
      logger.debug("committed savePoint transaction");
      return;
    } 
    logger.debug("committed savePoint transaction {}", str);
  }
  
  private static void rollBack(DatabaseConnection paramDatabaseConnection, Savepoint paramSavepoint) throws SQLException {
    String str;
    if (paramSavepoint == null) {
      str = null;
    } else {
      str = paramSavepoint.getSavepointName();
    } 
    paramDatabaseConnection.rollback(paramSavepoint);
    if (str == null) {
      logger.debug("rolled back savePoint transaction");
      return;
    } 
    logger.debug("rolled back savePoint transaction {}", str);
  }
  
  public <T> T callInTransaction(Callable<T> paramCallable) throws SQLException {
    return callInTransaction(this.connectionSource, paramCallable);
  }
  
  public void initialize() {
    if (this.connectionSource != null)
      return; 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("dataSource was not set on ");
    stringBuilder.append(getClass().getSimpleName());
    throw new IllegalStateException(stringBuilder.toString());
  }
  
  public void setConnectionSource(ConnectionSource paramConnectionSource) {
    this.connectionSource = paramConnectionSource;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\j256\ormlite\misc\TransactionManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */