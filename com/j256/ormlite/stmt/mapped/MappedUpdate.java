package com.j256.ormlite.stmt.mapped;

import com.j256.ormlite.dao.ObjectCache;
import com.j256.ormlite.db.DatabaseType;
import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.support.DatabaseConnection;
import com.j256.ormlite.table.TableInfo;
import java.sql.SQLException;

public class MappedUpdate<T, ID> extends BaseMappedStatement<T, ID> {
  private final FieldType versionFieldType;
  
  private final int versionFieldTypeIndex;
  
  private MappedUpdate(TableInfo<T, ID> paramTableInfo, String paramString, FieldType[] paramArrayOfFieldType, FieldType paramFieldType, int paramInt) {
    super(paramTableInfo, paramString, paramArrayOfFieldType);
    this.versionFieldType = paramFieldType;
    this.versionFieldTypeIndex = paramInt;
  }
  
  public static <T, ID> MappedUpdate<T, ID> build(DatabaseType paramDatabaseType, TableInfo<T, ID> paramTableInfo) throws SQLException {
    FieldType fieldType = paramTableInfo.getIdField();
    if (fieldType != null) {
      StringBuilder stringBuilder1 = new StringBuilder(64);
      appendTableName(paramDatabaseType, stringBuilder1, "UPDATE ", paramTableInfo.getTableName());
      FieldType[] arrayOfFieldType3 = paramTableInfo.getFieldTypes();
      int i1 = arrayOfFieldType3.length;
      FieldType fieldType1 = null;
      int k = 0;
      int j = 0;
      int i;
      for (i = -1; k < i1; i = i2) {
        FieldType fieldType3 = arrayOfFieldType3[k];
        int i3 = j;
        FieldType fieldType2 = fieldType1;
        int i2 = i;
        if (isFieldUpdatable(fieldType3, fieldType)) {
          if (fieldType3.isVersion()) {
            i = j;
            fieldType1 = fieldType3;
          } 
          i3 = j + 1;
          i2 = i;
          fieldType2 = fieldType1;
        } 
        k++;
        j = i3;
        fieldType1 = fieldType2;
      } 
      k = j + 1;
      j = k;
      if (fieldType1 != null)
        j = k + 1; 
      FieldType[] arrayOfFieldType1 = new FieldType[j];
      FieldType[] arrayOfFieldType2 = paramTableInfo.getFieldTypes();
      int n = arrayOfFieldType2.length;
      k = 0;
      int m = 0;
      j = 1;
      while (k < n) {
        FieldType fieldType2 = arrayOfFieldType2[k];
        if (isFieldUpdatable(fieldType2, fieldType)) {
          if (j != 0) {
            stringBuilder1.append("SET ");
            j = 0;
          } else {
            stringBuilder1.append(", ");
          } 
          appendFieldColumnName(paramDatabaseType, stringBuilder1, fieldType2, null);
          arrayOfFieldType1[m] = fieldType2;
          stringBuilder1.append("= ?");
          m++;
        } 
        k++;
      } 
      stringBuilder1.append(' ');
      appendWhereFieldEq(paramDatabaseType, fieldType, stringBuilder1, null);
      arrayOfFieldType1[m] = fieldType;
      if (fieldType1 != null) {
        stringBuilder1.append(" AND ");
        appendFieldColumnName(paramDatabaseType, stringBuilder1, fieldType1, null);
        stringBuilder1.append("= ?");
        arrayOfFieldType1[m + 1] = fieldType1;
      } 
      return new MappedUpdate<T, ID>(paramTableInfo, stringBuilder1.toString(), arrayOfFieldType1, fieldType1, i);
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Cannot update ");
    stringBuilder.append(paramTableInfo.getDataClass());
    stringBuilder.append(" because it doesn't have an id field");
    throw new SQLException(stringBuilder.toString());
  }
  
  private static boolean isFieldUpdatable(FieldType paramFieldType1, FieldType paramFieldType2) {
    return !(paramFieldType1 == paramFieldType2 || paramFieldType1.isForeignCollection() || paramFieldType1.isReadOnly());
  }
  
  public int update(DatabaseConnection paramDatabaseConnection, T paramT, ObjectCache paramObjectCache) throws SQLException {
    // Byte code:
    //   0: aload_0
    //   1: getfield argFieldTypes : [Lcom/j256/ormlite/field/FieldType;
    //   4: arraylength
    //   5: iconst_1
    //   6: if_icmpgt -> 11
    //   9: iconst_0
    //   10: ireturn
    //   11: aload_0
    //   12: aload_2
    //   13: invokevirtual getFieldObjects : (Ljava/lang/Object;)[Ljava/lang/Object;
    //   16: astore #8
    //   18: aload_0
    //   19: getfield versionFieldType : Lcom/j256/ormlite/field/FieldType;
    //   22: ifnull -> 285
    //   25: aload_0
    //   26: getfield versionFieldType : Lcom/j256/ormlite/field/FieldType;
    //   29: aload_2
    //   30: invokevirtual extractJavaFieldValue : (Ljava/lang/Object;)Ljava/lang/Object;
    //   33: astore #7
    //   35: aload_0
    //   36: getfield versionFieldType : Lcom/j256/ormlite/field/FieldType;
    //   39: aload #7
    //   41: invokevirtual moveToNextValue : (Ljava/lang/Object;)Ljava/lang/Object;
    //   44: astore #7
    //   46: aload #8
    //   48: aload_0
    //   49: getfield versionFieldTypeIndex : I
    //   52: aload_0
    //   53: getfield versionFieldType : Lcom/j256/ormlite/field/FieldType;
    //   56: aload #7
    //   58: invokevirtual convertJavaFieldToSqlArgValue : (Ljava/lang/Object;)Ljava/lang/Object;
    //   61: aastore
    //   62: goto -> 65
    //   65: aload_1
    //   66: aload_0
    //   67: getfield statement : Ljava/lang/String;
    //   70: aload #8
    //   72: aload_0
    //   73: getfield argFieldTypes : [Lcom/j256/ormlite/field/FieldType;
    //   76: invokeinterface update : (Ljava/lang/String;[Ljava/lang/Object;[Lcom/j256/ormlite/field/FieldType;)I
    //   81: istore #5
    //   83: iload #5
    //   85: ifle -> 196
    //   88: aload #7
    //   90: ifnull -> 105
    //   93: aload_0
    //   94: getfield versionFieldType : Lcom/j256/ormlite/field/FieldType;
    //   97: aload_2
    //   98: aload #7
    //   100: iconst_0
    //   101: aconst_null
    //   102: invokevirtual assignField : (Ljava/lang/Object;Ljava/lang/Object;ZLcom/j256/ormlite/dao/ObjectCache;)V
    //   105: aload_3
    //   106: ifnull -> 196
    //   109: aload_0
    //   110: getfield idField : Lcom/j256/ormlite/field/FieldType;
    //   113: aload_2
    //   114: invokevirtual extractJavaFieldValue : (Ljava/lang/Object;)Ljava/lang/Object;
    //   117: astore_1
    //   118: aload_3
    //   119: aload_0
    //   120: getfield clazz : Ljava/lang/Class;
    //   123: aload_1
    //   124: invokeinterface get : (Ljava/lang/Class;Ljava/lang/Object;)Ljava/lang/Object;
    //   129: astore_1
    //   130: aload_1
    //   131: ifnull -> 196
    //   134: aload_1
    //   135: aload_2
    //   136: if_acmpeq -> 196
    //   139: aload_0
    //   140: getfield tableInfo : Lcom/j256/ormlite/table/TableInfo;
    //   143: invokevirtual getFieldTypes : ()[Lcom/j256/ormlite/field/FieldType;
    //   146: astore #7
    //   148: aload #7
    //   150: arraylength
    //   151: istore #6
    //   153: iconst_0
    //   154: istore #4
    //   156: iload #4
    //   158: iload #6
    //   160: if_icmpge -> 196
    //   163: aload #7
    //   165: iload #4
    //   167: aaload
    //   168: astore #9
    //   170: aload #9
    //   172: aload_0
    //   173: getfield idField : Lcom/j256/ormlite/field/FieldType;
    //   176: if_acmpeq -> 291
    //   179: aload #9
    //   181: aload_1
    //   182: aload #9
    //   184: aload_2
    //   185: invokevirtual extractJavaFieldValue : (Ljava/lang/Object;)Ljava/lang/Object;
    //   188: iconst_0
    //   189: aload_3
    //   190: invokevirtual assignField : (Ljava/lang/Object;Ljava/lang/Object;ZLcom/j256/ormlite/dao/ObjectCache;)V
    //   193: goto -> 291
    //   196: getstatic com/j256/ormlite/stmt/mapped/MappedUpdate.logger : Lcom/j256/ormlite/logger/Logger;
    //   199: ldc 'update data with statement '{}' and {} args, changed {} rows'
    //   201: aload_0
    //   202: getfield statement : Ljava/lang/String;
    //   205: aload #8
    //   207: arraylength
    //   208: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   211: iload #5
    //   213: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   216: invokevirtual debug : (Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V
    //   219: aload #8
    //   221: arraylength
    //   222: ifle -> 235
    //   225: getstatic com/j256/ormlite/stmt/mapped/MappedUpdate.logger : Lcom/j256/ormlite/logger/Logger;
    //   228: ldc 'update arguments: {}'
    //   230: aload #8
    //   232: invokevirtual trace : (Ljava/lang/String;Ljava/lang/Object;)V
    //   235: iload #5
    //   237: ireturn
    //   238: astore_1
    //   239: new java/lang/StringBuilder
    //   242: dup
    //   243: invokespecial <init> : ()V
    //   246: astore_3
    //   247: aload_3
    //   248: ldc 'Unable to run update stmt on object '
    //   250: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   253: pop
    //   254: aload_3
    //   255: aload_2
    //   256: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   259: pop
    //   260: aload_3
    //   261: ldc ': '
    //   263: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   266: pop
    //   267: aload_3
    //   268: aload_0
    //   269: getfield statement : Ljava/lang/String;
    //   272: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   275: pop
    //   276: aload_3
    //   277: invokevirtual toString : ()Ljava/lang/String;
    //   280: aload_1
    //   281: invokestatic create : (Ljava/lang/String;Ljava/lang/Throwable;)Ljava/sql/SQLException;
    //   284: athrow
    //   285: aconst_null
    //   286: astore #7
    //   288: goto -> 65
    //   291: iload #4
    //   293: iconst_1
    //   294: iadd
    //   295: istore #4
    //   297: goto -> 156
    // Exception table:
    //   from	to	target	type
    //   0	9	238	java/sql/SQLException
    //   11	62	238	java/sql/SQLException
    //   65	83	238	java/sql/SQLException
    //   93	105	238	java/sql/SQLException
    //   109	130	238	java/sql/SQLException
    //   139	153	238	java/sql/SQLException
    //   170	193	238	java/sql/SQLException
    //   196	235	238	java/sql/SQLException
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\j256\ormlite\stmt\mapped\MappedUpdate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */