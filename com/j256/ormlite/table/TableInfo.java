package com.j256.ormlite.table;

import com.j256.ormlite.dao.BaseDaoImpl;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.db.DatabaseType;
import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.misc.BaseDaoEnabled;
import com.j256.ormlite.misc.SqlExceptionUtil;
import com.j256.ormlite.support.ConnectionSource;
import java.lang.reflect.Constructor;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class TableInfo<T, ID> {
  private static final FieldType[] NO_FOREIGN_COLLECTIONS = new FieldType[0];
  
  private final BaseDaoImpl<T, ID> baseDaoImpl;
  
  private final Constructor<T> constructor;
  
  private final Class<T> dataClass;
  
  private Map<String, FieldType> fieldNameMap;
  
  private final FieldType[] fieldTypes;
  
  private final boolean foreignAutoCreate;
  
  private final FieldType[] foreignCollections;
  
  private final FieldType idField;
  
  private final String tableName;
  
  public TableInfo(DatabaseType paramDatabaseType, BaseDaoImpl<T, ID> paramBaseDaoImpl, DatabaseTableConfig<T> paramDatabaseTableConfig) throws SQLException {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial <init> : ()V
    //   4: aload_0
    //   5: aload_2
    //   6: putfield baseDaoImpl : Lcom/j256/ormlite/dao/BaseDaoImpl;
    //   9: aload_0
    //   10: aload_3
    //   11: invokevirtual getDataClass : ()Ljava/lang/Class;
    //   14: putfield dataClass : Ljava/lang/Class;
    //   17: aload_0
    //   18: aload_3
    //   19: invokevirtual getTableName : ()Ljava/lang/String;
    //   22: putfield tableName : Ljava/lang/String;
    //   25: aload_0
    //   26: aload_3
    //   27: aload_1
    //   28: invokevirtual getFieldTypes : (Lcom/j256/ormlite/db/DatabaseType;)[Lcom/j256/ormlite/field/FieldType;
    //   31: putfield fieldTypes : [Lcom/j256/ormlite/field/FieldType;
    //   34: aload_0
    //   35: getfield fieldTypes : [Lcom/j256/ormlite/field/FieldType;
    //   38: astore #11
    //   40: aload #11
    //   42: arraylength
    //   43: istore #8
    //   45: iconst_0
    //   46: istore #7
    //   48: aconst_null
    //   49: astore_1
    //   50: iconst_0
    //   51: istore #4
    //   53: iconst_0
    //   54: istore #9
    //   56: iconst_0
    //   57: istore #5
    //   59: iload #4
    //   61: iload #8
    //   63: if_icmpge -> 220
    //   66: aload #11
    //   68: iload #4
    //   70: aaload
    //   71: astore #10
    //   73: aload #10
    //   75: invokevirtual isId : ()Z
    //   78: ifne -> 99
    //   81: aload #10
    //   83: invokevirtual isGeneratedId : ()Z
    //   86: ifne -> 99
    //   89: aload_1
    //   90: astore_2
    //   91: aload #10
    //   93: invokevirtual isGeneratedIdSequence : ()Z
    //   96: ifeq -> 106
    //   99: aload_1
    //   100: ifnonnull -> 150
    //   103: aload #10
    //   105: astore_2
    //   106: aload #10
    //   108: invokevirtual isForeignAutoCreate : ()Z
    //   111: ifeq -> 117
    //   114: iconst_1
    //   115: istore #9
    //   117: iload #5
    //   119: istore #6
    //   121: aload #10
    //   123: invokevirtual isForeignCollection : ()Z
    //   126: ifeq -> 135
    //   129: iload #5
    //   131: iconst_1
    //   132: iadd
    //   133: istore #6
    //   135: iload #4
    //   137: iconst_1
    //   138: iadd
    //   139: istore #4
    //   141: aload_2
    //   142: astore_1
    //   143: iload #6
    //   145: istore #5
    //   147: goto -> 59
    //   150: new java/lang/StringBuilder
    //   153: dup
    //   154: invokespecial <init> : ()V
    //   157: astore_2
    //   158: aload_2
    //   159: ldc 'More than 1 idField configured for class '
    //   161: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   164: pop
    //   165: aload_2
    //   166: aload_0
    //   167: getfield dataClass : Ljava/lang/Class;
    //   170: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   173: pop
    //   174: aload_2
    //   175: ldc ' ('
    //   177: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   180: pop
    //   181: aload_2
    //   182: aload_1
    //   183: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   186: pop
    //   187: aload_2
    //   188: ldc ','
    //   190: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   193: pop
    //   194: aload_2
    //   195: aload #10
    //   197: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   200: pop
    //   201: aload_2
    //   202: ldc ')'
    //   204: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   207: pop
    //   208: new java/sql/SQLException
    //   211: dup
    //   212: aload_2
    //   213: invokevirtual toString : ()Ljava/lang/String;
    //   216: invokespecial <init> : (Ljava/lang/String;)V
    //   219: athrow
    //   220: aload_0
    //   221: aload_1
    //   222: putfield idField : Lcom/j256/ormlite/field/FieldType;
    //   225: aload_0
    //   226: aload_3
    //   227: invokevirtual getConstructor : ()Ljava/lang/reflect/Constructor;
    //   230: putfield constructor : Ljava/lang/reflect/Constructor;
    //   233: aload_0
    //   234: iload #9
    //   236: putfield foreignAutoCreate : Z
    //   239: iload #5
    //   241: ifne -> 252
    //   244: aload_0
    //   245: getstatic com/j256/ormlite/table/TableInfo.NO_FOREIGN_COLLECTIONS : [Lcom/j256/ormlite/field/FieldType;
    //   248: putfield foreignCollections : [Lcom/j256/ormlite/field/FieldType;
    //   251: return
    //   252: aload_0
    //   253: iload #5
    //   255: anewarray com/j256/ormlite/field/FieldType
    //   258: putfield foreignCollections : [Lcom/j256/ormlite/field/FieldType;
    //   261: aload_0
    //   262: getfield fieldTypes : [Lcom/j256/ormlite/field/FieldType;
    //   265: astore_1
    //   266: aload_1
    //   267: arraylength
    //   268: istore #8
    //   270: iconst_0
    //   271: istore #5
    //   273: iload #7
    //   275: istore #4
    //   277: iload #4
    //   279: iload #8
    //   281: if_icmpge -> 327
    //   284: aload_1
    //   285: iload #4
    //   287: aaload
    //   288: astore_2
    //   289: iload #5
    //   291: istore #6
    //   293: aload_2
    //   294: invokevirtual isForeignCollection : ()Z
    //   297: ifeq -> 314
    //   300: aload_0
    //   301: getfield foreignCollections : [Lcom/j256/ormlite/field/FieldType;
    //   304: iload #5
    //   306: aload_2
    //   307: aastore
    //   308: iload #5
    //   310: iconst_1
    //   311: iadd
    //   312: istore #6
    //   314: iload #4
    //   316: iconst_1
    //   317: iadd
    //   318: istore #4
    //   320: iload #6
    //   322: istore #5
    //   324: goto -> 277
    //   327: return
  }
  
  public TableInfo(ConnectionSource paramConnectionSource, BaseDaoImpl<T, ID> paramBaseDaoImpl, Class<T> paramClass) throws SQLException {
    this(paramConnectionSource.getDatabaseType(), paramBaseDaoImpl, DatabaseTableConfig.fromClass(paramConnectionSource, paramClass));
  }
  
  private static <T, ID> void wireNewInstance(BaseDaoImpl<T, ID> paramBaseDaoImpl, T paramT) {
    if (paramT instanceof BaseDaoEnabled)
      ((BaseDaoEnabled)paramT).setDao((Dao)paramBaseDaoImpl); 
  }
  
  public T createObject() throws SQLException {
    ObjectFactory<ObjectFactory> objectFactory = null;
    try {
      if (this.baseDaoImpl != null)
        objectFactory = this.baseDaoImpl.getObjectFactory(); 
      if (objectFactory == null) {
        objectFactory = (ObjectFactory<ObjectFactory>)this.constructor.newInstance(new Object[0]);
      } else {
        objectFactory = objectFactory.createObject((Constructor)this.constructor, this.baseDaoImpl.getDataClass());
      } 
      wireNewInstance(this.baseDaoImpl, (T)objectFactory);
      return (T)objectFactory;
    } catch (Exception exception) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Could not create object for ");
      stringBuilder.append(this.constructor.getDeclaringClass());
      throw SqlExceptionUtil.create(stringBuilder.toString(), exception);
    } 
  }
  
  public Constructor<T> getConstructor() {
    return this.constructor;
  }
  
  public Class<T> getDataClass() {
    return this.dataClass;
  }
  
  public FieldType getFieldTypeByColumnName(String paramString) {
    StringBuilder stringBuilder1;
    Map<String, FieldType> map = this.fieldNameMap;
    byte b = 0;
    if (map == null) {
      map = new HashMap<String, FieldType>();
      for (FieldType fieldType1 : this.fieldTypes)
        map.put(fieldType1.getColumnName().toLowerCase(), fieldType1); 
      this.fieldNameMap = map;
    } 
    FieldType fieldType = this.fieldNameMap.get(paramString.toLowerCase());
    if (fieldType != null)
      return fieldType; 
    FieldType[] arrayOfFieldType = this.fieldTypes;
    int j = arrayOfFieldType.length;
    int i = b;
    while (i < j) {
      fieldType = arrayOfFieldType[i];
      if (!fieldType.getFieldName().equals(paramString)) {
        i++;
        continue;
      } 
      stringBuilder1 = new StringBuilder();
      stringBuilder1.append("You should use columnName '");
      stringBuilder1.append(fieldType.getColumnName());
      stringBuilder1.append("' for table ");
      stringBuilder1.append(this.tableName);
      stringBuilder1.append(" instead of fieldName '");
      stringBuilder1.append(fieldType.getFieldName());
      stringBuilder1.append("'");
      throw new IllegalArgumentException(stringBuilder1.toString());
    } 
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append("Unknown column name '");
    stringBuilder2.append((String)stringBuilder1);
    stringBuilder2.append("' in table ");
    stringBuilder2.append(this.tableName);
    throw new IllegalArgumentException(stringBuilder2.toString());
  }
  
  public FieldType[] getFieldTypes() {
    return this.fieldTypes;
  }
  
  public FieldType[] getForeignCollections() {
    return this.foreignCollections;
  }
  
  public FieldType getIdField() {
    return this.idField;
  }
  
  public String getTableName() {
    return this.tableName;
  }
  
  public boolean hasColumnName(String paramString) {
    FieldType[] arrayOfFieldType = this.fieldTypes;
    int j = arrayOfFieldType.length;
    for (int i = 0; i < j; i++) {
      if (arrayOfFieldType[i].getColumnName().equals(paramString))
        return true; 
    } 
    return false;
  }
  
  public boolean isForeignAutoCreate() {
    return this.foreignAutoCreate;
  }
  
  public boolean isUpdatable() {
    return (this.idField != null && this.fieldTypes.length > 1);
  }
  
  public String objectToString(T paramT) {
    StringBuilder stringBuilder = new StringBuilder(64);
    stringBuilder.append(paramT.getClass().getSimpleName());
    FieldType[] arrayOfFieldType = this.fieldTypes;
    int j = arrayOfFieldType.length;
    int i = 0;
    while (i < j) {
      FieldType fieldType = arrayOfFieldType[i];
      stringBuilder.append(' ');
      stringBuilder.append(fieldType.getColumnName());
      stringBuilder.append("=");
      try {
        stringBuilder.append(fieldType.extractJavaFieldValue(paramT));
        i++;
      } catch (Exception exception) {
        stringBuilder = new StringBuilder();
        stringBuilder.append("Could not generate toString of field ");
        stringBuilder.append(fieldType);
        throw new IllegalStateException(stringBuilder.toString(), exception);
      } 
    } 
    return stringBuilder.toString();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\j256\ormlite\table\TableInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */