package com.j256.ormlite.dao;

import com.j256.ormlite.logger.Logger;
import com.j256.ormlite.logger.LoggerFactory;
import com.j256.ormlite.misc.SqlExceptionUtil;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.DatabaseTable;
import com.j256.ormlite.table.DatabaseTableConfig;
import java.lang.reflect.Constructor;
import java.sql.SQLException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class DaoManager {
  private static Map<ClassConnectionSource, Dao<?, ?>> classMap;
  
  private static Map<Class<?>, DatabaseTableConfig<?>> configMap;
  
  private static Logger logger = LoggerFactory.getLogger(DaoManager.class);
  
  private static Map<TableConfigConnectionSource, Dao<?, ?>> tableConfigMap;
  
  public static void addCachedDatabaseConfigs(Collection<DatabaseTableConfig<?>> paramCollection) {
    // Byte code:
    //   0: ldc com/j256/ormlite/dao/DaoManager
    //   2: monitorenter
    //   3: getstatic com/j256/ormlite/dao/DaoManager.configMap : Ljava/util/Map;
    //   6: ifnonnull -> 20
    //   9: new java/util/HashMap
    //   12: dup
    //   13: invokespecial <init> : ()V
    //   16: astore_1
    //   17: goto -> 31
    //   20: new java/util/HashMap
    //   23: dup
    //   24: getstatic com/j256/ormlite/dao/DaoManager.configMap : Ljava/util/Map;
    //   27: invokespecial <init> : (Ljava/util/Map;)V
    //   30: astore_1
    //   31: aload_0
    //   32: invokeinterface iterator : ()Ljava/util/Iterator;
    //   37: astore_0
    //   38: aload_0
    //   39: invokeinterface hasNext : ()Z
    //   44: ifeq -> 84
    //   47: aload_0
    //   48: invokeinterface next : ()Ljava/lang/Object;
    //   53: checkcast com/j256/ormlite/table/DatabaseTableConfig
    //   56: astore_2
    //   57: aload_1
    //   58: aload_2
    //   59: invokevirtual getDataClass : ()Ljava/lang/Class;
    //   62: aload_2
    //   63: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   68: pop
    //   69: getstatic com/j256/ormlite/dao/DaoManager.logger : Lcom/j256/ormlite/logger/Logger;
    //   72: ldc 'Loaded configuration for {}'
    //   74: aload_2
    //   75: invokevirtual getDataClass : ()Ljava/lang/Class;
    //   78: invokevirtual info : (Ljava/lang/String;Ljava/lang/Object;)V
    //   81: goto -> 38
    //   84: aload_1
    //   85: putstatic com/j256/ormlite/dao/DaoManager.configMap : Ljava/util/Map;
    //   88: ldc com/j256/ormlite/dao/DaoManager
    //   90: monitorexit
    //   91: return
    //   92: astore_0
    //   93: ldc com/j256/ormlite/dao/DaoManager
    //   95: monitorexit
    //   96: aload_0
    //   97: athrow
    // Exception table:
    //   from	to	target	type
    //   3	17	92	finally
    //   20	31	92	finally
    //   31	38	92	finally
    //   38	81	92	finally
    //   84	88	92	finally
  }
  
  private static void addDaoToClassMap(ClassConnectionSource paramClassConnectionSource, Dao<?, ?> paramDao) {
    if (classMap == null)
      classMap = new HashMap<ClassConnectionSource, Dao<?, ?>>(); 
    classMap.put(paramClassConnectionSource, paramDao);
  }
  
  private static void addDaoToTableMap(TableConfigConnectionSource paramTableConfigConnectionSource, Dao<?, ?> paramDao) {
    if (tableConfigMap == null)
      tableConfigMap = new HashMap<TableConfigConnectionSource, Dao<?, ?>>(); 
    tableConfigMap.put(paramTableConfigConnectionSource, paramDao);
  }
  
  public static void clearCache() {
    // Byte code:
    //   0: ldc com/j256/ormlite/dao/DaoManager
    //   2: monitorenter
    //   3: getstatic com/j256/ormlite/dao/DaoManager.configMap : Ljava/util/Map;
    //   6: ifnull -> 21
    //   9: getstatic com/j256/ormlite/dao/DaoManager.configMap : Ljava/util/Map;
    //   12: invokeinterface clear : ()V
    //   17: aconst_null
    //   18: putstatic com/j256/ormlite/dao/DaoManager.configMap : Ljava/util/Map;
    //   21: invokestatic clearDaoCache : ()V
    //   24: ldc com/j256/ormlite/dao/DaoManager
    //   26: monitorexit
    //   27: return
    //   28: astore_0
    //   29: ldc com/j256/ormlite/dao/DaoManager
    //   31: monitorexit
    //   32: aload_0
    //   33: athrow
    // Exception table:
    //   from	to	target	type
    //   3	21	28	finally
    //   21	24	28	finally
  }
  
  public static void clearDaoCache() {
    // Byte code:
    //   0: ldc com/j256/ormlite/dao/DaoManager
    //   2: monitorenter
    //   3: getstatic com/j256/ormlite/dao/DaoManager.classMap : Ljava/util/Map;
    //   6: ifnull -> 21
    //   9: getstatic com/j256/ormlite/dao/DaoManager.classMap : Ljava/util/Map;
    //   12: invokeinterface clear : ()V
    //   17: aconst_null
    //   18: putstatic com/j256/ormlite/dao/DaoManager.classMap : Ljava/util/Map;
    //   21: getstatic com/j256/ormlite/dao/DaoManager.tableConfigMap : Ljava/util/Map;
    //   24: ifnull -> 39
    //   27: getstatic com/j256/ormlite/dao/DaoManager.tableConfigMap : Ljava/util/Map;
    //   30: invokeinterface clear : ()V
    //   35: aconst_null
    //   36: putstatic com/j256/ormlite/dao/DaoManager.tableConfigMap : Ljava/util/Map;
    //   39: ldc com/j256/ormlite/dao/DaoManager
    //   41: monitorexit
    //   42: return
    //   43: astore_0
    //   44: ldc com/j256/ormlite/dao/DaoManager
    //   46: monitorexit
    //   47: aload_0
    //   48: athrow
    // Exception table:
    //   from	to	target	type
    //   3	21	43	finally
    //   21	39	43	finally
  }
  
  public static <D extends Dao<T, ?>, T> D createDao(ConnectionSource paramConnectionSource, DatabaseTableConfig<T> paramDatabaseTableConfig) throws SQLException {
    // Byte code:
    //   0: ldc com/j256/ormlite/dao/DaoManager
    //   2: monitorenter
    //   3: aload_0
    //   4: ifnull -> 22
    //   7: aload_0
    //   8: aload_1
    //   9: invokestatic doCreateDao : (Lcom/j256/ormlite/support/ConnectionSource;Lcom/j256/ormlite/table/DatabaseTableConfig;)Lcom/j256/ormlite/dao/Dao;
    //   12: astore_0
    //   13: ldc com/j256/ormlite/dao/DaoManager
    //   15: monitorexit
    //   16: aload_0
    //   17: areturn
    //   18: astore_0
    //   19: goto -> 32
    //   22: new java/lang/IllegalArgumentException
    //   25: dup
    //   26: ldc 'connectionSource argument cannot be null'
    //   28: invokespecial <init> : (Ljava/lang/String;)V
    //   31: athrow
    //   32: ldc com/j256/ormlite/dao/DaoManager
    //   34: monitorexit
    //   35: aload_0
    //   36: athrow
    // Exception table:
    //   from	to	target	type
    //   7	13	18	finally
    //   22	32	18	finally
  }
  
  public static <D extends Dao<T, ?>, T> D createDao(ConnectionSource paramConnectionSource, Class<T> paramClass) throws SQLException {
    // Byte code:
    //   0: ldc com/j256/ormlite/dao/DaoManager
    //   2: monitorenter
    //   3: aload_0
    //   4: ifnull -> 296
    //   7: new com/j256/ormlite/dao/DaoManager$ClassConnectionSource
    //   10: dup
    //   11: aload_0
    //   12: aload_1
    //   13: invokespecial <init> : (Lcom/j256/ormlite/support/ConnectionSource;Ljava/lang/Class;)V
    //   16: invokestatic lookupDao : (Lcom/j256/ormlite/dao/DaoManager$ClassConnectionSource;)Lcom/j256/ormlite/dao/Dao;
    //   19: astore_2
    //   20: aload_2
    //   21: ifnull -> 29
    //   24: ldc com/j256/ormlite/dao/DaoManager
    //   26: monitorexit
    //   27: aload_2
    //   28: areturn
    //   29: aload_0
    //   30: aload_1
    //   31: invokestatic createDaoFromConfig : (Lcom/j256/ormlite/support/ConnectionSource;Ljava/lang/Class;)Ljava/lang/Object;
    //   34: checkcast com/j256/ormlite/dao/Dao
    //   37: astore_2
    //   38: aload_2
    //   39: ifnull -> 47
    //   42: ldc com/j256/ormlite/dao/DaoManager
    //   44: monitorexit
    //   45: aload_2
    //   46: areturn
    //   47: aload_1
    //   48: ldc com/j256/ormlite/table/DatabaseTable
    //   50: invokevirtual getAnnotation : (Ljava/lang/Class;)Ljava/lang/annotation/Annotation;
    //   53: checkcast com/j256/ormlite/table/DatabaseTable
    //   56: astore_2
    //   57: aload_2
    //   58: ifnull -> 240
    //   61: aload_2
    //   62: invokeinterface daoClass : ()Ljava/lang/Class;
    //   67: ldc java/lang/Void
    //   69: if_acmpeq -> 240
    //   72: aload_2
    //   73: invokeinterface daoClass : ()Ljava/lang/Class;
    //   78: ldc com/j256/ormlite/dao/BaseDaoImpl
    //   80: if_acmpne -> 86
    //   83: goto -> 240
    //   86: aload_2
    //   87: invokeinterface daoClass : ()Ljava/lang/Class;
    //   92: astore #5
    //   94: iconst_2
    //   95: anewarray java/lang/Object
    //   98: astore_2
    //   99: aload_2
    //   100: iconst_0
    //   101: aload_0
    //   102: aastore
    //   103: aload_2
    //   104: iconst_1
    //   105: aload_1
    //   106: aastore
    //   107: aload #5
    //   109: aload_2
    //   110: invokestatic findConstructor : (Ljava/lang/Class;[Ljava/lang/Object;)Ljava/lang/reflect/Constructor;
    //   113: astore #4
    //   115: aload #4
    //   117: astore_3
    //   118: aload #4
    //   120: ifnonnull -> 187
    //   123: iconst_1
    //   124: anewarray java/lang/Object
    //   127: astore_2
    //   128: aload_2
    //   129: iconst_0
    //   130: aload_0
    //   131: aastore
    //   132: aload #5
    //   134: aload_2
    //   135: invokestatic findConstructor : (Ljava/lang/Class;[Ljava/lang/Object;)Ljava/lang/reflect/Constructor;
    //   138: astore_3
    //   139: aload_3
    //   140: ifnull -> 146
    //   143: goto -> 187
    //   146: new java/lang/StringBuilder
    //   149: dup
    //   150: invokespecial <init> : ()V
    //   153: astore_0
    //   154: aload_0
    //   155: ldc 'Could not find public constructor with ConnectionSource and optional Class parameters '
    //   157: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   160: pop
    //   161: aload_0
    //   162: aload #5
    //   164: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   167: pop
    //   168: aload_0
    //   169: ldc '.  Missing static on class?'
    //   171: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   174: pop
    //   175: new java/sql/SQLException
    //   178: dup
    //   179: aload_0
    //   180: invokevirtual toString : ()Ljava/lang/String;
    //   183: invokespecial <init> : (Ljava/lang/String;)V
    //   186: athrow
    //   187: aload_3
    //   188: aload_2
    //   189: invokevirtual newInstance : ([Ljava/lang/Object;)Ljava/lang/Object;
    //   192: checkcast com/j256/ormlite/dao/Dao
    //   195: astore_2
    //   196: getstatic com/j256/ormlite/dao/DaoManager.logger : Lcom/j256/ormlite/logger/Logger;
    //   199: ldc 'created dao for class {} from constructor'
    //   201: aload_1
    //   202: invokevirtual debug : (Ljava/lang/String;Ljava/lang/Object;)V
    //   205: goto -> 282
    //   208: astore_0
    //   209: new java/lang/StringBuilder
    //   212: dup
    //   213: invokespecial <init> : ()V
    //   216: astore_1
    //   217: aload_1
    //   218: ldc 'Could not call the constructor in class '
    //   220: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   223: pop
    //   224: aload_1
    //   225: aload #5
    //   227: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   230: pop
    //   231: aload_1
    //   232: invokevirtual toString : ()Ljava/lang/String;
    //   235: aload_0
    //   236: invokestatic create : (Ljava/lang/String;Ljava/lang/Throwable;)Ljava/sql/SQLException;
    //   239: athrow
    //   240: aload_0
    //   241: invokeinterface getDatabaseType : ()Lcom/j256/ormlite/db/DatabaseType;
    //   246: aload_0
    //   247: aload_1
    //   248: invokeinterface extractDatabaseTableConfig : (Lcom/j256/ormlite/support/ConnectionSource;Ljava/lang/Class;)Lcom/j256/ormlite/table/DatabaseTableConfig;
    //   253: astore_2
    //   254: aload_2
    //   255: ifnonnull -> 267
    //   258: aload_0
    //   259: aload_1
    //   260: invokestatic createDao : (Lcom/j256/ormlite/support/ConnectionSource;Ljava/lang/Class;)Lcom/j256/ormlite/dao/Dao;
    //   263: astore_2
    //   264: goto -> 273
    //   267: aload_0
    //   268: aload_2
    //   269: invokestatic createDao : (Lcom/j256/ormlite/support/ConnectionSource;Lcom/j256/ormlite/table/DatabaseTableConfig;)Lcom/j256/ormlite/dao/Dao;
    //   272: astore_2
    //   273: getstatic com/j256/ormlite/dao/DaoManager.logger : Lcom/j256/ormlite/logger/Logger;
    //   276: ldc 'created dao for class {} with reflection'
    //   278: aload_1
    //   279: invokevirtual debug : (Ljava/lang/String;Ljava/lang/Object;)V
    //   282: aload_0
    //   283: aload_2
    //   284: invokestatic registerDao : (Lcom/j256/ormlite/support/ConnectionSource;Lcom/j256/ormlite/dao/Dao;)V
    //   287: ldc com/j256/ormlite/dao/DaoManager
    //   289: monitorexit
    //   290: aload_2
    //   291: areturn
    //   292: astore_0
    //   293: goto -> 306
    //   296: new java/lang/IllegalArgumentException
    //   299: dup
    //   300: ldc 'connectionSource argument cannot be null'
    //   302: invokespecial <init> : (Ljava/lang/String;)V
    //   305: athrow
    //   306: ldc com/j256/ormlite/dao/DaoManager
    //   308: monitorexit
    //   309: aload_0
    //   310: athrow
    // Exception table:
    //   from	to	target	type
    //   7	20	292	finally
    //   29	38	292	finally
    //   47	57	292	finally
    //   61	83	292	finally
    //   86	99	292	finally
    //   107	115	292	finally
    //   123	128	292	finally
    //   132	139	292	finally
    //   146	187	292	finally
    //   187	205	208	java/lang/Exception
    //   187	205	292	finally
    //   209	240	292	finally
    //   240	254	292	finally
    //   258	264	292	finally
    //   267	273	292	finally
    //   273	282	292	finally
    //   282	287	292	finally
    //   296	306	292	finally
  }
  
  private static <D, T> D createDaoFromConfig(ConnectionSource paramConnectionSource, Class<T> paramClass) throws SQLException {
    Map<Class<?>, DatabaseTableConfig<?>> map = configMap;
    if (map == null)
      return null; 
    DatabaseTableConfig<?> databaseTableConfig = map.get(paramClass);
    return (D)((databaseTableConfig == null) ? null : doCreateDao(paramConnectionSource, databaseTableConfig));
  }
  
  private static <D extends Dao<T, ?>, T> D doCreateDao(ConnectionSource paramConnectionSource, DatabaseTableConfig<T> paramDatabaseTableConfig) throws SQLException {
    Dao<T, ?> dao;
    StringBuilder stringBuilder;
    TableConfigConnectionSource tableConfigConnectionSource = new TableConfigConnectionSource(paramConnectionSource, paramDatabaseTableConfig);
    Dao<?, ?> dao1 = lookupDao(tableConfigConnectionSource);
    if (dao1 != null)
      return (D)dao1; 
    Class<?> clazz = paramDatabaseTableConfig.getDataClass();
    ClassConnectionSource classConnectionSource = new ClassConnectionSource(paramConnectionSource, clazz);
    Dao<?, ?> dao2 = lookupDao(classConnectionSource);
    if (dao2 != null) {
      addDaoToTableMap(tableConfigConnectionSource, dao2);
      return (D)dao2;
    } 
    DatabaseTable databaseTable = (DatabaseTable)paramDatabaseTableConfig.getDataClass().getAnnotation(DatabaseTable.class);
    if (databaseTable == null || databaseTable.daoClass() == Void.class || databaseTable.daoClass() == BaseDaoImpl.class) {
      dao = BaseDaoImpl.createDao(paramConnectionSource, paramDatabaseTableConfig);
    } else {
      Class<?> clazz1 = databaseTable.daoClass();
      Object[] arrayOfObject = new Object[2];
      arrayOfObject[0] = dao;
      arrayOfObject[1] = paramDatabaseTableConfig;
      Constructor<?> constructor = findConstructor(clazz1, arrayOfObject);
      if (constructor != null) {
        try {
          Dao dao3 = (Dao)constructor.newInstance(arrayOfObject);
        } catch (Exception exception) {
          StringBuilder stringBuilder1 = new StringBuilder();
          stringBuilder1.append("Could not call the constructor in class ");
          stringBuilder1.append(clazz1);
          throw SqlExceptionUtil.create(stringBuilder1.toString(), exception);
        } 
      } else {
        stringBuilder = new StringBuilder();
        stringBuilder.append("Could not find public constructor with ConnectionSource, DatabaseTableConfig parameters in class ");
        stringBuilder.append(clazz1);
        throw new SQLException(stringBuilder.toString());
      } 
    } 
    addDaoToTableMap(tableConfigConnectionSource, (Dao<?, ?>)stringBuilder);
    logger.debug("created dao for class {} from table config", clazz);
    if (lookupDao(classConnectionSource) == null)
      addDaoToClassMap(classConnectionSource, (Dao<?, ?>)stringBuilder); 
    return (D)stringBuilder;
  }
  
  private static Constructor<?> findConstructor(Class<?> paramClass, Object[] paramArrayOfObject) {
    for (Constructor<?> constructor : paramClass.getConstructors()) {
      Class[] arrayOfClass = constructor.getParameterTypes();
      if (arrayOfClass.length == paramArrayOfObject.length) {
        int i = 0;
        while (true) {
          if (i < arrayOfClass.length) {
            if (!arrayOfClass[i].isAssignableFrom(paramArrayOfObject[i].getClass())) {
              i = 0;
              break;
            } 
            i++;
            continue;
          } 
          i = 1;
          break;
        } 
        if (i != 0)
          return constructor; 
      } 
    } 
    return null;
  }
  
  private static <T> Dao<?, ?> lookupDao(ClassConnectionSource paramClassConnectionSource) {
    if (classMap == null)
      classMap = new HashMap<ClassConnectionSource, Dao<?, ?>>(); 
    Dao<?, ?> dao2 = classMap.get(paramClassConnectionSource);
    Dao<?, ?> dao1 = dao2;
    if (dao2 == null)
      dao1 = null; 
    return dao1;
  }
  
  private static <T> Dao<?, ?> lookupDao(TableConfigConnectionSource paramTableConfigConnectionSource) {
    if (tableConfigMap == null)
      tableConfigMap = new HashMap<TableConfigConnectionSource, Dao<?, ?>>(); 
    Dao<?, ?> dao2 = tableConfigMap.get(paramTableConfigConnectionSource);
    Dao<?, ?> dao1 = dao2;
    if (dao2 == null)
      dao1 = null; 
    return dao1;
  }
  
  public static <D extends Dao<T, ?>, T> D lookupDao(ConnectionSource paramConnectionSource, DatabaseTableConfig<T> paramDatabaseTableConfig) {
    // Byte code:
    //   0: ldc com/j256/ormlite/dao/DaoManager
    //   2: monitorenter
    //   3: aload_0
    //   4: ifnull -> 38
    //   7: new com/j256/ormlite/dao/DaoManager$TableConfigConnectionSource
    //   10: dup
    //   11: aload_0
    //   12: aload_1
    //   13: invokespecial <init> : (Lcom/j256/ormlite/support/ConnectionSource;Lcom/j256/ormlite/table/DatabaseTableConfig;)V
    //   16: invokestatic lookupDao : (Lcom/j256/ormlite/dao/DaoManager$TableConfigConnectionSource;)Lcom/j256/ormlite/dao/Dao;
    //   19: astore_0
    //   20: aload_0
    //   21: ifnonnull -> 29
    //   24: ldc com/j256/ormlite/dao/DaoManager
    //   26: monitorexit
    //   27: aconst_null
    //   28: areturn
    //   29: ldc com/j256/ormlite/dao/DaoManager
    //   31: monitorexit
    //   32: aload_0
    //   33: areturn
    //   34: astore_0
    //   35: goto -> 48
    //   38: new java/lang/IllegalArgumentException
    //   41: dup
    //   42: ldc 'connectionSource argument cannot be null'
    //   44: invokespecial <init> : (Ljava/lang/String;)V
    //   47: athrow
    //   48: ldc com/j256/ormlite/dao/DaoManager
    //   50: monitorexit
    //   51: aload_0
    //   52: athrow
    // Exception table:
    //   from	to	target	type
    //   7	20	34	finally
    //   38	48	34	finally
  }
  
  public static <D extends Dao<T, ?>, T> D lookupDao(ConnectionSource paramConnectionSource, Class<T> paramClass) {
    // Byte code:
    //   0: ldc com/j256/ormlite/dao/DaoManager
    //   2: monitorenter
    //   3: aload_0
    //   4: ifnull -> 29
    //   7: new com/j256/ormlite/dao/DaoManager$ClassConnectionSource
    //   10: dup
    //   11: aload_0
    //   12: aload_1
    //   13: invokespecial <init> : (Lcom/j256/ormlite/support/ConnectionSource;Ljava/lang/Class;)V
    //   16: invokestatic lookupDao : (Lcom/j256/ormlite/dao/DaoManager$ClassConnectionSource;)Lcom/j256/ormlite/dao/Dao;
    //   19: astore_0
    //   20: ldc com/j256/ormlite/dao/DaoManager
    //   22: monitorexit
    //   23: aload_0
    //   24: areturn
    //   25: astore_0
    //   26: goto -> 39
    //   29: new java/lang/IllegalArgumentException
    //   32: dup
    //   33: ldc 'connectionSource argument cannot be null'
    //   35: invokespecial <init> : (Ljava/lang/String;)V
    //   38: athrow
    //   39: ldc com/j256/ormlite/dao/DaoManager
    //   41: monitorexit
    //   42: aload_0
    //   43: athrow
    // Exception table:
    //   from	to	target	type
    //   7	20	25	finally
    //   29	39	25	finally
  }
  
  public static void registerDao(ConnectionSource paramConnectionSource, Dao<?, ?> paramDao) {
    // Byte code:
    //   0: ldc com/j256/ormlite/dao/DaoManager
    //   2: monitorenter
    //   3: aload_0
    //   4: ifnull -> 33
    //   7: new com/j256/ormlite/dao/DaoManager$ClassConnectionSource
    //   10: dup
    //   11: aload_0
    //   12: aload_1
    //   13: invokeinterface getDataClass : ()Ljava/lang/Class;
    //   18: invokespecial <init> : (Lcom/j256/ormlite/support/ConnectionSource;Ljava/lang/Class;)V
    //   21: aload_1
    //   22: invokestatic addDaoToClassMap : (Lcom/j256/ormlite/dao/DaoManager$ClassConnectionSource;Lcom/j256/ormlite/dao/Dao;)V
    //   25: ldc com/j256/ormlite/dao/DaoManager
    //   27: monitorexit
    //   28: return
    //   29: astore_0
    //   30: goto -> 43
    //   33: new java/lang/IllegalArgumentException
    //   36: dup
    //   37: ldc 'connectionSource argument cannot be null'
    //   39: invokespecial <init> : (Ljava/lang/String;)V
    //   42: athrow
    //   43: ldc com/j256/ormlite/dao/DaoManager
    //   45: monitorexit
    //   46: aload_0
    //   47: athrow
    // Exception table:
    //   from	to	target	type
    //   7	25	29	finally
    //   33	43	29	finally
  }
  
  public static void registerDaoWithTableConfig(ConnectionSource paramConnectionSource, Dao<?, ?> paramDao) {
    // Byte code:
    //   0: ldc com/j256/ormlite/dao/DaoManager
    //   2: monitorenter
    //   3: aload_0
    //   4: ifnull -> 69
    //   7: aload_1
    //   8: instanceof com/j256/ormlite/dao/BaseDaoImpl
    //   11: ifeq -> 43
    //   14: aload_1
    //   15: checkcast com/j256/ormlite/dao/BaseDaoImpl
    //   18: invokevirtual getTableConfig : ()Lcom/j256/ormlite/table/DatabaseTableConfig;
    //   21: astore_2
    //   22: aload_2
    //   23: ifnull -> 43
    //   26: new com/j256/ormlite/dao/DaoManager$TableConfigConnectionSource
    //   29: dup
    //   30: aload_0
    //   31: aload_2
    //   32: invokespecial <init> : (Lcom/j256/ormlite/support/ConnectionSource;Lcom/j256/ormlite/table/DatabaseTableConfig;)V
    //   35: aload_1
    //   36: invokestatic addDaoToTableMap : (Lcom/j256/ormlite/dao/DaoManager$TableConfigConnectionSource;Lcom/j256/ormlite/dao/Dao;)V
    //   39: ldc com/j256/ormlite/dao/DaoManager
    //   41: monitorexit
    //   42: return
    //   43: new com/j256/ormlite/dao/DaoManager$ClassConnectionSource
    //   46: dup
    //   47: aload_0
    //   48: aload_1
    //   49: invokeinterface getDataClass : ()Ljava/lang/Class;
    //   54: invokespecial <init> : (Lcom/j256/ormlite/support/ConnectionSource;Ljava/lang/Class;)V
    //   57: aload_1
    //   58: invokestatic addDaoToClassMap : (Lcom/j256/ormlite/dao/DaoManager$ClassConnectionSource;Lcom/j256/ormlite/dao/Dao;)V
    //   61: ldc com/j256/ormlite/dao/DaoManager
    //   63: monitorexit
    //   64: return
    //   65: astore_0
    //   66: goto -> 79
    //   69: new java/lang/IllegalArgumentException
    //   72: dup
    //   73: ldc 'connectionSource argument cannot be null'
    //   75: invokespecial <init> : (Ljava/lang/String;)V
    //   78: athrow
    //   79: ldc com/j256/ormlite/dao/DaoManager
    //   81: monitorexit
    //   82: aload_0
    //   83: athrow
    // Exception table:
    //   from	to	target	type
    //   7	22	65	finally
    //   26	39	65	finally
    //   43	61	65	finally
    //   69	79	65	finally
  }
  
  private static void removeDaoToClassMap(ClassConnectionSource paramClassConnectionSource, Dao<?, ?> paramDao) {
    Map<ClassConnectionSource, Dao<?, ?>> map = classMap;
    if (map != null)
      map.remove(paramClassConnectionSource); 
  }
  
  public static void unregisterDao(ConnectionSource paramConnectionSource, Dao<?, ?> paramDao) {
    // Byte code:
    //   0: ldc com/j256/ormlite/dao/DaoManager
    //   2: monitorenter
    //   3: aload_0
    //   4: ifnull -> 33
    //   7: new com/j256/ormlite/dao/DaoManager$ClassConnectionSource
    //   10: dup
    //   11: aload_0
    //   12: aload_1
    //   13: invokeinterface getDataClass : ()Ljava/lang/Class;
    //   18: invokespecial <init> : (Lcom/j256/ormlite/support/ConnectionSource;Ljava/lang/Class;)V
    //   21: aload_1
    //   22: invokestatic removeDaoToClassMap : (Lcom/j256/ormlite/dao/DaoManager$ClassConnectionSource;Lcom/j256/ormlite/dao/Dao;)V
    //   25: ldc com/j256/ormlite/dao/DaoManager
    //   27: monitorexit
    //   28: return
    //   29: astore_0
    //   30: goto -> 43
    //   33: new java/lang/IllegalArgumentException
    //   36: dup
    //   37: ldc 'connectionSource argument cannot be null'
    //   39: invokespecial <init> : (Ljava/lang/String;)V
    //   42: athrow
    //   43: ldc com/j256/ormlite/dao/DaoManager
    //   45: monitorexit
    //   46: aload_0
    //   47: athrow
    // Exception table:
    //   from	to	target	type
    //   7	25	29	finally
    //   33	43	29	finally
  }
  
  static class ClassConnectionSource {
    Class<?> clazz;
    
    ConnectionSource connectionSource;
    
    public ClassConnectionSource(ConnectionSource param1ConnectionSource, Class<?> param1Class) {
      this.connectionSource = param1ConnectionSource;
      this.clazz = param1Class;
    }
    
    public boolean equals(Object param1Object) {
      if (param1Object != null) {
        if (getClass() != param1Object.getClass())
          return false; 
        param1Object = param1Object;
        return !this.clazz.equals(((ClassConnectionSource)param1Object).clazz) ? false : (!!this.connectionSource.equals(((ClassConnectionSource)param1Object).connectionSource));
      } 
      return false;
    }
    
    public int hashCode() {
      return (this.clazz.hashCode() + 31) * 31 + this.connectionSource.hashCode();
    }
  }
  
  static class TableConfigConnectionSource {
    ConnectionSource connectionSource;
    
    DatabaseTableConfig<?> tableConfig;
    
    public TableConfigConnectionSource(ConnectionSource param1ConnectionSource, DatabaseTableConfig<?> param1DatabaseTableConfig) {
      this.connectionSource = param1ConnectionSource;
      this.tableConfig = param1DatabaseTableConfig;
    }
    
    public boolean equals(Object param1Object) {
      if (param1Object != null) {
        if (getClass() != param1Object.getClass())
          return false; 
        param1Object = param1Object;
        return !this.tableConfig.equals(((TableConfigConnectionSource)param1Object).tableConfig) ? false : (!!this.connectionSource.equals(((TableConfigConnectionSource)param1Object).connectionSource));
      } 
      return false;
    }
    
    public int hashCode() {
      return (this.tableConfig.hashCode() + 31) * 31 + this.connectionSource.hashCode();
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\j256\ormlite\dao\DaoManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */