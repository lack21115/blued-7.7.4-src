package com.j256.ormlite.stmt.mapped;

import com.j256.ormlite.dao.ObjectCache;
import com.j256.ormlite.db.DatabaseType;
import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.logger.Log;
import com.j256.ormlite.support.DatabaseConnection;
import com.j256.ormlite.support.GeneratedKeyHolder;
import com.j256.ormlite.table.TableInfo;
import java.sql.SQLException;

public class MappedCreate<T, ID> extends BaseMappedStatement<T, ID> {
  private String dataClassName;
  
  private final String queryNextSequenceStmt;
  
  private int versionFieldTypeIndex;
  
  private MappedCreate(TableInfo<T, ID> paramTableInfo, String paramString1, FieldType[] paramArrayOfFieldType, String paramString2, int paramInt) {
    super(paramTableInfo, paramString1, paramArrayOfFieldType);
    this.dataClassName = paramTableInfo.getDataClass().getSimpleName();
    this.queryNextSequenceStmt = paramString2;
    this.versionFieldTypeIndex = paramInt;
  }
  
  private void assignIdValue(T paramT, Number paramNumber, String paramString, ObjectCache paramObjectCache) throws SQLException {
    this.idField.assignIdValue(paramT, paramNumber, paramObjectCache);
    if (logger.isLevelEnabled(Log.Level.DEBUG))
      logger.debug("assigned id '{}' from {} to '{}' in {} object", new Object[] { paramNumber, paramString, this.idField.getFieldName(), this.dataClassName }); 
  }
  
  private void assignSequenceId(DatabaseConnection paramDatabaseConnection, T paramT, ObjectCache paramObjectCache) throws SQLException {
    long l = paramDatabaseConnection.queryForLong(this.queryNextSequenceStmt);
    logger.debug("queried for sequence {} using stmt: {}", Long.valueOf(l), this.queryNextSequenceStmt);
    if (l != 0L) {
      assignIdValue(paramT, Long.valueOf(l), "sequence", paramObjectCache);
      return;
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Should not have returned 0 for stmt: ");
    stringBuilder.append(this.queryNextSequenceStmt);
    throw new SQLException(stringBuilder.toString());
  }
  
  public static <T, ID> MappedCreate<T, ID> build(DatabaseType paramDatabaseType, TableInfo<T, ID> paramTableInfo) {
    StringBuilder stringBuilder = new StringBuilder(128);
    appendTableName(paramDatabaseType, stringBuilder, "INSERT INTO ", paramTableInfo.getTableName());
    FieldType[] arrayOfFieldType = paramTableInfo.getFieldTypes();
    int m = arrayOfFieldType.length;
    int k = 0;
    int j = 0;
    int i;
    for (i = -1; k < m; i = n) {
      FieldType fieldType = arrayOfFieldType[k];
      int i1 = j;
      int n = i;
      if (isFieldCreatable(paramDatabaseType, fieldType)) {
        if (fieldType.isVersion())
          i = j; 
        i1 = j + 1;
        n = i;
      } 
      k++;
      j = i1;
    } 
    arrayOfFieldType = new FieldType[j];
    if (j == 0) {
      paramDatabaseType.appendInsertNoColumns(stringBuilder);
    } else {
      stringBuilder.append('(');
      FieldType[] arrayOfFieldType1 = paramTableInfo.getFieldTypes();
      int i1 = arrayOfFieldType1.length;
      k = 0;
      j = 1;
      int n = 0;
      while (k < i1) {
        FieldType fieldType = arrayOfFieldType1[k];
        if (isFieldCreatable(paramDatabaseType, fieldType)) {
          if (j != 0) {
            j = 0;
          } else {
            stringBuilder.append(",");
          } 
          appendFieldColumnName(paramDatabaseType, stringBuilder, fieldType, null);
          arrayOfFieldType[n] = fieldType;
          n++;
        } 
        k++;
      } 
      stringBuilder.append(") VALUES (");
      arrayOfFieldType1 = paramTableInfo.getFieldTypes();
      n = arrayOfFieldType1.length;
      k = 0;
      j = 1;
      while (k < n) {
        if (isFieldCreatable(paramDatabaseType, arrayOfFieldType1[k])) {
          if (j != 0) {
            j = 0;
          } else {
            stringBuilder.append(",");
          } 
          stringBuilder.append("?");
        } 
        k++;
      } 
      stringBuilder.append(")");
    } 
    String str = buildQueryNextSequence(paramDatabaseType, paramTableInfo.getIdField());
    return new MappedCreate<T, ID>(paramTableInfo, stringBuilder.toString(), arrayOfFieldType, str, i);
  }
  
  private static String buildQueryNextSequence(DatabaseType paramDatabaseType, FieldType paramFieldType) {
    if (paramFieldType == null)
      return null; 
    String str = paramFieldType.getGeneratedIdSequence();
    if (str == null)
      return null; 
    StringBuilder stringBuilder = new StringBuilder(64);
    paramDatabaseType.appendSelectNextValFromSequence(stringBuilder, str);
    return stringBuilder.toString();
  }
  
  private boolean foreignCollectionsAreAssigned(FieldType[] paramArrayOfFieldType, Object paramObject) throws SQLException {
    int j = paramArrayOfFieldType.length;
    for (int i = 0; i < j; i++) {
      if (paramArrayOfFieldType[i].extractJavaFieldValue(paramObject) == null)
        return false; 
    } 
    return true;
  }
  
  private static boolean isFieldCreatable(DatabaseType paramDatabaseType, FieldType paramFieldType) {
    return paramFieldType.isForeignCollection() ? false : (paramFieldType.isReadOnly() ? false : ((paramDatabaseType.isIdSequenceNeeded() && paramDatabaseType.isSelectSequenceBeforeInsert()) ? true : (!(paramFieldType.isGeneratedId() && !paramFieldType.isSelfGeneratedId() && !paramFieldType.isAllowGeneratedIdInsert()))));
  }
  
  public int insert(DatabaseType paramDatabaseType, DatabaseConnection paramDatabaseConnection, T paramT, ObjectCache paramObjectCache) throws SQLException {
    // Byte code:
    //   0: aload_0
    //   1: getfield idField : Lcom/j256/ormlite/field/FieldType;
    //   4: ifnull -> 145
    //   7: aload_0
    //   8: getfield idField : Lcom/j256/ormlite/field/FieldType;
    //   11: invokevirtual isAllowGeneratedIdInsert : ()Z
    //   14: ifeq -> 34
    //   17: aload_0
    //   18: getfield idField : Lcom/j256/ormlite/field/FieldType;
    //   21: aload_3
    //   22: invokevirtual isObjectsFieldValueDefault : (Ljava/lang/Object;)Z
    //   25: ifne -> 34
    //   28: iconst_0
    //   29: istore #5
    //   31: goto -> 37
    //   34: iconst_1
    //   35: istore #5
    //   37: aload_0
    //   38: getfield idField : Lcom/j256/ormlite/field/FieldType;
    //   41: invokevirtual isSelfGeneratedId : ()Z
    //   44: ifeq -> 83
    //   47: aload_0
    //   48: getfield idField : Lcom/j256/ormlite/field/FieldType;
    //   51: invokevirtual isGeneratedId : ()Z
    //   54: ifeq -> 83
    //   57: iload #5
    //   59: ifeq -> 145
    //   62: aload_0
    //   63: getfield idField : Lcom/j256/ormlite/field/FieldType;
    //   66: aload_3
    //   67: aload_0
    //   68: getfield idField : Lcom/j256/ormlite/field/FieldType;
    //   71: invokevirtual generateId : ()Ljava/lang/Object;
    //   74: iconst_0
    //   75: aload #4
    //   77: invokevirtual assignField : (Ljava/lang/Object;Ljava/lang/Object;ZLcom/j256/ormlite/dao/ObjectCache;)V
    //   80: goto -> 145
    //   83: aload_0
    //   84: getfield idField : Lcom/j256/ormlite/field/FieldType;
    //   87: invokevirtual isGeneratedIdSequence : ()Z
    //   90: ifeq -> 118
    //   93: aload_1
    //   94: invokeinterface isSelectSequenceBeforeInsert : ()Z
    //   99: ifeq -> 118
    //   102: iload #5
    //   104: ifeq -> 145
    //   107: aload_0
    //   108: aload_2
    //   109: aload_3
    //   110: aload #4
    //   112: invokespecial assignSequenceId : (Lcom/j256/ormlite/support/DatabaseConnection;Ljava/lang/Object;Lcom/j256/ormlite/dao/ObjectCache;)V
    //   115: goto -> 145
    //   118: aload_0
    //   119: getfield idField : Lcom/j256/ormlite/field/FieldType;
    //   122: invokevirtual isGeneratedId : ()Z
    //   125: ifeq -> 145
    //   128: iload #5
    //   130: ifeq -> 145
    //   133: new com/j256/ormlite/stmt/mapped/MappedCreate$KeyHolder
    //   136: dup
    //   137: aconst_null
    //   138: invokespecial <init> : (Lcom/j256/ormlite/stmt/mapped/MappedCreate$1;)V
    //   141: astore_1
    //   142: goto -> 147
    //   145: aconst_null
    //   146: astore_1
    //   147: aload_0
    //   148: getfield tableInfo : Lcom/j256/ormlite/table/TableInfo;
    //   151: invokevirtual isForeignAutoCreate : ()Z
    //   154: ifeq -> 236
    //   157: aload_0
    //   158: getfield tableInfo : Lcom/j256/ormlite/table/TableInfo;
    //   161: invokevirtual getFieldTypes : ()[Lcom/j256/ormlite/field/FieldType;
    //   164: astore #7
    //   166: aload #7
    //   168: arraylength
    //   169: istore #6
    //   171: iconst_0
    //   172: istore #5
    //   174: iload #5
    //   176: iload #6
    //   178: if_icmpge -> 236
    //   181: aload #7
    //   183: iload #5
    //   185: aaload
    //   186: astore #8
    //   188: aload #8
    //   190: invokevirtual isForeignAutoCreate : ()Z
    //   193: ifne -> 199
    //   196: goto -> 578
    //   199: aload #8
    //   201: aload_3
    //   202: invokevirtual extractRawJavaFieldValue : (Ljava/lang/Object;)Ljava/lang/Object;
    //   205: astore #9
    //   207: aload #9
    //   209: ifnull -> 578
    //   212: aload #8
    //   214: invokevirtual getForeignIdField : ()Lcom/j256/ormlite/field/FieldType;
    //   217: aload #9
    //   219: invokevirtual isObjectsFieldValueDefault : (Ljava/lang/Object;)Z
    //   222: ifeq -> 578
    //   225: aload #8
    //   227: aload #9
    //   229: invokevirtual createWithForeignDao : (Ljava/lang/Object;)I
    //   232: pop
    //   233: goto -> 578
    //   236: aload_0
    //   237: aload_3
    //   238: invokevirtual getFieldObjects : (Ljava/lang/Object;)[Ljava/lang/Object;
    //   241: astore #8
    //   243: aload_0
    //   244: getfield versionFieldTypeIndex : I
    //   247: iflt -> 296
    //   250: aload #8
    //   252: aload_0
    //   253: getfield versionFieldTypeIndex : I
    //   256: aaload
    //   257: ifnonnull -> 296
    //   260: aload_0
    //   261: getfield argFieldTypes : [Lcom/j256/ormlite/field/FieldType;
    //   264: aload_0
    //   265: getfield versionFieldTypeIndex : I
    //   268: aaload
    //   269: astore #9
    //   271: aload #9
    //   273: aconst_null
    //   274: invokevirtual moveToNextValue : (Ljava/lang/Object;)Ljava/lang/Object;
    //   277: astore #7
    //   279: aload #8
    //   281: aload_0
    //   282: getfield versionFieldTypeIndex : I
    //   285: aload #9
    //   287: aload #7
    //   289: invokevirtual convertJavaFieldToSqlArgValue : (Ljava/lang/Object;)Ljava/lang/Object;
    //   292: aastore
    //   293: goto -> 299
    //   296: aconst_null
    //   297: astore #7
    //   299: aload_2
    //   300: aload_0
    //   301: getfield statement : Ljava/lang/String;
    //   304: aload #8
    //   306: aload_0
    //   307: getfield argFieldTypes : [Lcom/j256/ormlite/field/FieldType;
    //   310: aload_1
    //   311: invokeinterface insert : (Ljava/lang/String;[Ljava/lang/Object;[Lcom/j256/ormlite/field/FieldType;Lcom/j256/ormlite/support/GeneratedKeyHolder;)I
    //   316: istore #5
    //   318: getstatic com/j256/ormlite/stmt/mapped/MappedCreate.logger : Lcom/j256/ormlite/logger/Logger;
    //   321: ldc_w 'insert data with statement '{}' and {} args, changed {} rows'
    //   324: aload_0
    //   325: getfield statement : Ljava/lang/String;
    //   328: aload #8
    //   330: arraylength
    //   331: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   334: iload #5
    //   336: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   339: invokevirtual debug : (Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V
    //   342: aload #8
    //   344: arraylength
    //   345: ifle -> 359
    //   348: getstatic com/j256/ormlite/stmt/mapped/MappedCreate.logger : Lcom/j256/ormlite/logger/Logger;
    //   351: ldc_w 'insert arguments: {}'
    //   354: aload #8
    //   356: invokevirtual trace : (Ljava/lang/String;Ljava/lang/Object;)V
    //   359: iload #5
    //   361: ifle -> 587
    //   364: aload #7
    //   366: ifnull -> 386
    //   369: aload_0
    //   370: getfield argFieldTypes : [Lcom/j256/ormlite/field/FieldType;
    //   373: aload_0
    //   374: getfield versionFieldTypeIndex : I
    //   377: aaload
    //   378: aload_3
    //   379: aload #7
    //   381: iconst_0
    //   382: aconst_null
    //   383: invokevirtual assignField : (Ljava/lang/Object;Ljava/lang/Object;ZLcom/j256/ormlite/dao/ObjectCache;)V
    //   386: aload_1
    //   387: ifnull -> 444
    //   390: aload_1
    //   391: invokevirtual getKey : ()Ljava/lang/Number;
    //   394: astore_1
    //   395: aload_1
    //   396: ifnull -> 433
    //   399: aload_1
    //   400: invokevirtual longValue : ()J
    //   403: lconst_0
    //   404: lcmp
    //   405: ifeq -> 422
    //   408: aload_0
    //   409: aload_3
    //   410: aload_1
    //   411: ldc_w 'keyholder'
    //   414: aload #4
    //   416: invokespecial assignIdValue : (Ljava/lang/Object;Ljava/lang/Number;Ljava/lang/String;Lcom/j256/ormlite/dao/ObjectCache;)V
    //   419: goto -> 444
    //   422: new java/sql/SQLException
    //   425: dup
    //   426: ldc_w 'generated-id key must not be 0 value'
    //   429: invokespecial <init> : (Ljava/lang/String;)V
    //   432: athrow
    //   433: new java/sql/SQLException
    //   436: dup
    //   437: ldc_w 'generated-id key was not set by the update call'
    //   440: invokespecial <init> : (Ljava/lang/String;)V
    //   443: athrow
    //   444: aload #4
    //   446: ifnull -> 587
    //   449: aload_0
    //   450: aload_0
    //   451: getfield tableInfo : Lcom/j256/ormlite/table/TableInfo;
    //   454: invokevirtual getForeignCollections : ()[Lcom/j256/ormlite/field/FieldType;
    //   457: aload_3
    //   458: invokespecial foreignCollectionsAreAssigned : ([Lcom/j256/ormlite/field/FieldType;Ljava/lang/Object;)Z
    //   461: ifeq -> 587
    //   464: aload_0
    //   465: getfield idField : Lcom/j256/ormlite/field/FieldType;
    //   468: aload_3
    //   469: invokevirtual extractJavaFieldValue : (Ljava/lang/Object;)Ljava/lang/Object;
    //   472: astore_1
    //   473: aload #4
    //   475: aload_0
    //   476: getfield clazz : Ljava/lang/Class;
    //   479: aload_1
    //   480: aload_3
    //   481: invokeinterface put : (Ljava/lang/Class;Ljava/lang/Object;Ljava/lang/Object;)V
    //   486: iload #5
    //   488: ireturn
    //   489: astore_1
    //   490: getstatic com/j256/ormlite/stmt/mapped/MappedCreate.logger : Lcom/j256/ormlite/logger/Logger;
    //   493: ldc_w 'insert data with statement '{}' and {} args, threw exception: {}'
    //   496: aload_0
    //   497: getfield statement : Ljava/lang/String;
    //   500: aload #8
    //   502: arraylength
    //   503: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   506: aload_1
    //   507: invokevirtual debug : (Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V
    //   510: aload #8
    //   512: arraylength
    //   513: ifle -> 527
    //   516: getstatic com/j256/ormlite/stmt/mapped/MappedCreate.logger : Lcom/j256/ormlite/logger/Logger;
    //   519: ldc_w 'insert arguments: {}'
    //   522: aload #8
    //   524: invokevirtual trace : (Ljava/lang/String;Ljava/lang/Object;)V
    //   527: aload_1
    //   528: athrow
    //   529: astore_1
    //   530: new java/lang/StringBuilder
    //   533: dup
    //   534: invokespecial <init> : ()V
    //   537: astore_2
    //   538: aload_2
    //   539: ldc_w 'Unable to run insert stmt on object '
    //   542: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   545: pop
    //   546: aload_2
    //   547: aload_3
    //   548: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   551: pop
    //   552: aload_2
    //   553: ldc_w ': '
    //   556: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   559: pop
    //   560: aload_2
    //   561: aload_0
    //   562: getfield statement : Ljava/lang/String;
    //   565: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   568: pop
    //   569: aload_2
    //   570: invokevirtual toString : ()Ljava/lang/String;
    //   573: aload_1
    //   574: invokestatic create : (Ljava/lang/String;Ljava/lang/Throwable;)Ljava/sql/SQLException;
    //   577: athrow
    //   578: iload #5
    //   580: iconst_1
    //   581: iadd
    //   582: istore #5
    //   584: goto -> 174
    //   587: iload #5
    //   589: ireturn
    // Exception table:
    //   from	to	target	type
    //   147	171	529	java/sql/SQLException
    //   188	196	529	java/sql/SQLException
    //   199	207	529	java/sql/SQLException
    //   212	233	529	java/sql/SQLException
    //   236	293	529	java/sql/SQLException
    //   299	318	489	java/sql/SQLException
    //   318	359	529	java/sql/SQLException
    //   369	386	529	java/sql/SQLException
    //   390	395	529	java/sql/SQLException
    //   399	419	529	java/sql/SQLException
    //   422	433	529	java/sql/SQLException
    //   433	444	529	java/sql/SQLException
    //   449	486	529	java/sql/SQLException
    //   490	527	529	java/sql/SQLException
    //   527	529	529	java/sql/SQLException
  }
  
  static class KeyHolder implements GeneratedKeyHolder {
    Number key;
    
    private KeyHolder() {}
    
    public void addKey(Number param1Number) throws SQLException {
      if (this.key == null) {
        this.key = param1Number;
        return;
      } 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("generated key has already been set to ");
      stringBuilder.append(this.key);
      stringBuilder.append(", now set to ");
      stringBuilder.append(param1Number);
      throw new SQLException(stringBuilder.toString());
    }
    
    public Number getKey() {
      return this.key;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\j256\ormlite\stmt\mapped\MappedCreate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */