package com.j256.ormlite.android;

import com.j256.ormlite.db.DatabaseType;
import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.DatabaseFieldConfig;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.DatabaseTableConfig;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.sql.SQLException;
import java.util.ArrayList;

public class DatabaseTableConfigUtil {
  private static final int ALLOW_GENERATED_ID_INSERT = 24;
  
  private static final int CAN_BE_NULL = 5;
  
  private static final int COLUMN_DEFINITON = 25;
  
  private static final int COLUMN_NAME = 1;
  
  private static final int DATA_TYPE = 2;
  
  private static final int DEFAULT_VALUE = 3;
  
  private static final int FOREIGN = 9;
  
  private static final int FOREIGN_AUTO_CREATE = 26;
  
  private static final int FOREIGN_AUTO_REFRESH = 21;
  
  private static final int FOREIGN_COLUMN_NAME = 28;
  
  private static final int FORMAT = 14;
  
  private static final int GENERATED_ID = 7;
  
  private static final int GENERATED_ID_SEQUENCE = 8;
  
  private static final int ID = 6;
  
  private static final int INDEX = 17;
  
  private static final int INDEX_NAME = 19;
  
  private static final int MAX_FOREIGN_AUTO_REFRESH_LEVEL = 22;
  
  private static final int PERSISTED = 13;
  
  private static final int PERSISTER_CLASS = 23;
  
  private static final int READ_ONLY = 29;
  
  private static final int THROW_IF_NULL = 12;
  
  private static final int UNIQUE = 15;
  
  private static final int UNIQUE_COMBO = 16;
  
  private static final int UNIQUE_INDEX = 18;
  
  private static final int UNIQUE_INDEX_NAME = 20;
  
  private static final int UNKNOWN_ENUM_NAME = 11;
  
  private static final int USE_GET_SET = 10;
  
  private static final int VERSION = 27;
  
  private static final int WIDTH = 4;
  
  private static Class<?> annotationFactoryClazz;
  
  private static Class<?> annotationMemberClazz;
  
  private static final int[] configFieldNums = lookupClasses();
  
  private static Field elementsField;
  
  private static Field nameField;
  
  private static Field valueField;
  
  private static int workedC;
  
  private static void assignConfigField(int paramInt, DatabaseFieldConfig paramDatabaseFieldConfig, Field paramField, Object paramObject) {
    StringBuilder stringBuilder;
    String str;
    switch (paramInt) {
      default:
        stringBuilder = new StringBuilder();
        stringBuilder.append("Could not find support for DatabaseField number ");
        stringBuilder.append(paramInt);
        throw new IllegalStateException(stringBuilder.toString());
      case 29:
        stringBuilder.setReadOnly(((Boolean)paramObject).booleanValue());
        return;
      case 28:
        stringBuilder.setForeignColumnName(valueIfNotBlank((String)paramObject));
        return;
      case 27:
        stringBuilder.setVersion(((Boolean)paramObject).booleanValue());
        return;
      case 26:
        stringBuilder.setForeignAutoCreate(((Boolean)paramObject).booleanValue());
        return;
      case 25:
        stringBuilder.setColumnDefinition(valueIfNotBlank((String)paramObject));
        return;
      case 24:
        stringBuilder.setAllowGeneratedIdInsert(((Boolean)paramObject).booleanValue());
        return;
      case 23:
        stringBuilder.setPersisterClass((Class)paramObject);
        return;
      case 22:
        stringBuilder.setMaxForeignAutoRefreshLevel(((Integer)paramObject).intValue());
        return;
      case 21:
        stringBuilder.setForeignAutoRefresh(((Boolean)paramObject).booleanValue());
        return;
      case 20:
        stringBuilder.setUniqueIndexName(valueIfNotBlank((String)paramObject));
        return;
      case 19:
        stringBuilder.setIndexName(valueIfNotBlank((String)paramObject));
        return;
      case 18:
        stringBuilder.setUniqueIndex(((Boolean)paramObject).booleanValue());
        return;
      case 17:
        stringBuilder.setIndex(((Boolean)paramObject).booleanValue());
        return;
      case 16:
        stringBuilder.setUniqueCombo(((Boolean)paramObject).booleanValue());
        return;
      case 15:
        stringBuilder.setUnique(((Boolean)paramObject).booleanValue());
        return;
      case 14:
        stringBuilder.setFormat(valueIfNotBlank((String)paramObject));
        return;
      case 13:
        stringBuilder.setPersisted(((Boolean)paramObject).booleanValue());
        return;
      case 12:
        stringBuilder.setThrowIfNull(((Boolean)paramObject).booleanValue());
        return;
      case 11:
        stringBuilder.setUnknownEnumValue(DatabaseFieldConfig.findMatchingEnumVal(paramField, (String)paramObject));
        return;
      case 10:
        stringBuilder.setUseGetSet(((Boolean)paramObject).booleanValue());
        return;
      case 9:
        stringBuilder.setForeign(((Boolean)paramObject).booleanValue());
        return;
      case 8:
        stringBuilder.setGeneratedIdSequence(valueIfNotBlank((String)paramObject));
        return;
      case 7:
        stringBuilder.setGeneratedId(((Boolean)paramObject).booleanValue());
        return;
      case 6:
        stringBuilder.setId(((Boolean)paramObject).booleanValue());
        return;
      case 5:
        stringBuilder.setCanBeNull(((Boolean)paramObject).booleanValue());
        return;
      case 4:
        stringBuilder.setWidth(((Integer)paramObject).intValue());
        return;
      case 3:
        str = (String)paramObject;
        if (str != null && !str.equals("__ormlite__ no default value string was specified")) {
          stringBuilder.setDefaultValue(str);
          return;
        } 
        return;
      case 2:
        stringBuilder.setDataType((DataType)paramObject);
        return;
      case 1:
        break;
    } 
    stringBuilder.setColumnName(valueIfNotBlank((String)paramObject));
  }
  
  private static DatabaseFieldConfig buildConfig(DatabaseField paramDatabaseField, String paramString, Field paramField) throws Exception {
    InvocationHandler invocationHandler = Proxy.getInvocationHandler(paramDatabaseField);
    if (invocationHandler.getClass() != annotationFactoryClazz)
      return null; 
    Object object = elementsField.get(invocationHandler);
    if (object == null)
      return null; 
    DatabaseFieldConfig databaseFieldConfig = new DatabaseFieldConfig(paramField.getName());
    object = object;
    for (int i = 0; i < configFieldNums.length; i++) {
      Object object1 = valueField.get(object[i]);
      if (object1 != null)
        assignConfigField(configFieldNums[i], databaseFieldConfig, paramField, object1); 
    } 
    return databaseFieldConfig;
  }
  
  private static int configFieldNameToNum(String paramString) {
    if (paramString.equals("columnName"))
      return 1; 
    if (paramString.equals("dataType"))
      return 2; 
    if (paramString.equals("defaultValue"))
      return 3; 
    if (paramString.equals("width"))
      return 4; 
    if (paramString.equals("canBeNull"))
      return 5; 
    if (paramString.equals("id"))
      return 6; 
    if (paramString.equals("generatedId"))
      return 7; 
    if (paramString.equals("generatedIdSequence"))
      return 8; 
    if (paramString.equals("foreign"))
      return 9; 
    if (paramString.equals("useGetSet"))
      return 10; 
    if (paramString.equals("unknownEnumName"))
      return 11; 
    if (paramString.equals("throwIfNull"))
      return 12; 
    if (paramString.equals("persisted"))
      return 13; 
    if (paramString.equals("format"))
      return 14; 
    if (paramString.equals("unique"))
      return 15; 
    if (paramString.equals("uniqueCombo"))
      return 16; 
    if (paramString.equals("index"))
      return 17; 
    if (paramString.equals("uniqueIndex"))
      return 18; 
    if (paramString.equals("indexName"))
      return 19; 
    if (paramString.equals("uniqueIndexName"))
      return 20; 
    if (paramString.equals("foreignAutoRefresh"))
      return 21; 
    if (paramString.equals("maxForeignAutoRefreshLevel"))
      return 22; 
    if (paramString.equals("persisterClass"))
      return 23; 
    if (paramString.equals("allowGeneratedIdInsert"))
      return 24; 
    if (paramString.equals("columnDefinition"))
      return 25; 
    if (paramString.equals("foreignAutoCreate"))
      return 26; 
    if (paramString.equals("version"))
      return 27; 
    if (paramString.equals("foreignColumnName"))
      return 28; 
    if (paramString.equals("readOnly"))
      return 29; 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Could not find support for DatabaseField ");
    stringBuilder.append(paramString);
    throw new IllegalStateException(stringBuilder.toString());
  }
  
  private static DatabaseFieldConfig configFromField(DatabaseType paramDatabaseType, String paramString, Field paramField) throws SQLException {
    if (configFieldNums == null)
      return DatabaseFieldConfig.fromField(paramDatabaseType, paramString, paramField); 
    DatabaseField databaseField = paramField.<DatabaseField>getAnnotation(DatabaseField.class);
    DatabaseFieldConfig databaseFieldConfig2 = null;
    DatabaseFieldConfig databaseFieldConfig1 = databaseFieldConfig2;
    if (databaseField != null)
      try {
        databaseFieldConfig1 = buildConfig(databaseField, paramString, paramField);
      } catch (Exception exception) {
        databaseFieldConfig1 = databaseFieldConfig2;
      }  
    if (databaseFieldConfig1 == null)
      return DatabaseFieldConfig.fromField(paramDatabaseType, paramString, paramField); 
    workedC++;
    return databaseFieldConfig1;
  }
  
  public static <T> DatabaseTableConfig<T> fromClass(ConnectionSource paramConnectionSource, Class<T> paramClass) throws SQLException {
    DatabaseType databaseType = paramConnectionSource.getDatabaseType();
    String str = DatabaseTableConfig.extractTableName(paramClass);
    ArrayList<DatabaseFieldConfig> arrayList = new ArrayList();
    for (Class<T> clazz = paramClass; clazz != null; clazz = (Class)clazz.getSuperclass()) {
      Field[] arrayOfField = clazz.getDeclaredFields();
      int j = arrayOfField.length;
      for (int i = 0; i < j; i++) {
        DatabaseFieldConfig databaseFieldConfig = configFromField(databaseType, str, arrayOfField[i]);
        if (databaseFieldConfig != null && databaseFieldConfig.isPersisted())
          arrayList.add(databaseFieldConfig); 
      } 
    } 
    return (arrayList.size() == 0) ? null : new DatabaseTableConfig(paramClass, str, arrayList);
  }
  
  public static int getWorkedC() {
    return workedC;
  }
  
  private static int[] lookupClasses() {
    // Byte code:
    //   0: ldc_w 'org.apache.harmony.lang.annotation.AnnotationFactory'
    //   3: invokestatic forName : (Ljava/lang/String;)Ljava/lang/Class;
    //   6: putstatic com/j256/ormlite/android/DatabaseTableConfigUtil.annotationFactoryClazz : Ljava/lang/Class;
    //   9: ldc_w 'org.apache.harmony.lang.annotation.AnnotationMember'
    //   12: invokestatic forName : (Ljava/lang/String;)Ljava/lang/Class;
    //   15: putstatic com/j256/ormlite/android/DatabaseTableConfigUtil.annotationMemberClazz : Ljava/lang/Class;
    //   18: ldc_w '[Lorg.apache.harmony.lang.annotation.AnnotationMember;'
    //   21: invokestatic forName : (Ljava/lang/String;)Ljava/lang/Class;
    //   24: astore_1
    //   25: getstatic com/j256/ormlite/android/DatabaseTableConfigUtil.annotationFactoryClazz : Ljava/lang/Class;
    //   28: ldc_w 'elements'
    //   31: invokevirtual getDeclaredField : (Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   34: putstatic com/j256/ormlite/android/DatabaseTableConfigUtil.elementsField : Ljava/lang/reflect/Field;
    //   37: getstatic com/j256/ormlite/android/DatabaseTableConfigUtil.elementsField : Ljava/lang/reflect/Field;
    //   40: iconst_1
    //   41: invokevirtual setAccessible : (Z)V
    //   44: getstatic com/j256/ormlite/android/DatabaseTableConfigUtil.annotationMemberClazz : Ljava/lang/Class;
    //   47: ldc_w 'name'
    //   50: invokevirtual getDeclaredField : (Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   53: putstatic com/j256/ormlite/android/DatabaseTableConfigUtil.nameField : Ljava/lang/reflect/Field;
    //   56: getstatic com/j256/ormlite/android/DatabaseTableConfigUtil.nameField : Ljava/lang/reflect/Field;
    //   59: iconst_1
    //   60: invokevirtual setAccessible : (Z)V
    //   63: getstatic com/j256/ormlite/android/DatabaseTableConfigUtil.annotationMemberClazz : Ljava/lang/Class;
    //   66: ldc_w 'value'
    //   69: invokevirtual getDeclaredField : (Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   72: putstatic com/j256/ormlite/android/DatabaseTableConfigUtil.valueField : Ljava/lang/reflect/Field;
    //   75: getstatic com/j256/ormlite/android/DatabaseTableConfigUtil.valueField : Ljava/lang/reflect/Field;
    //   78: iconst_1
    //   79: invokevirtual setAccessible : (Z)V
    //   82: ldc com/j256/ormlite/android/DatabaseTableConfigUtil$DatabaseFieldSample
    //   84: ldc_w 'field'
    //   87: invokevirtual getDeclaredField : (Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   90: astore_2
    //   91: aload_2
    //   92: ldc_w com/j256/ormlite/field/DatabaseField
    //   95: invokevirtual getAnnotation : (Ljava/lang/Class;)Ljava/lang/annotation/Annotation;
    //   98: checkcast com/j256/ormlite/field/DatabaseField
    //   101: invokestatic getInvocationHandler : (Ljava/lang/Object;)Ljava/lang/reflect/InvocationHandler;
    //   104: astore_2
    //   105: aload_2
    //   106: invokevirtual getClass : ()Ljava/lang/Class;
    //   109: getstatic com/j256/ormlite/android/DatabaseTableConfigUtil.annotationFactoryClazz : Ljava/lang/Class;
    //   112: if_acmpeq -> 117
    //   115: aconst_null
    //   116: areturn
    //   117: getstatic com/j256/ormlite/android/DatabaseTableConfigUtil.elementsField : Ljava/lang/reflect/Field;
    //   120: aload_2
    //   121: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   124: astore_2
    //   125: aload_2
    //   126: ifnull -> 187
    //   129: aload_2
    //   130: invokevirtual getClass : ()Ljava/lang/Class;
    //   133: aload_1
    //   134: if_acmpeq -> 139
    //   137: aconst_null
    //   138: areturn
    //   139: aload_2
    //   140: checkcast [Ljava/lang/Object;
    //   143: checkcast [Ljava/lang/Object;
    //   146: astore_1
    //   147: aload_1
    //   148: arraylength
    //   149: newarray int
    //   151: astore_2
    //   152: iconst_0
    //   153: istore_0
    //   154: iload_0
    //   155: aload_1
    //   156: arraylength
    //   157: if_icmpge -> 185
    //   160: aload_2
    //   161: iload_0
    //   162: getstatic com/j256/ormlite/android/DatabaseTableConfigUtil.nameField : Ljava/lang/reflect/Field;
    //   165: aload_1
    //   166: iload_0
    //   167: aaload
    //   168: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   171: checkcast java/lang/String
    //   174: invokestatic configFieldNameToNum : (Ljava/lang/String;)I
    //   177: iastore
    //   178: iload_0
    //   179: iconst_1
    //   180: iadd
    //   181: istore_0
    //   182: goto -> 154
    //   185: aload_2
    //   186: areturn
    //   187: aconst_null
    //   188: areturn
    //   189: astore_1
    //   190: aconst_null
    //   191: areturn
    // Exception table:
    //   from	to	target	type
    //   0	25	189	java/lang/ClassNotFoundException
    //   25	91	189	java/lang/SecurityException
    //   25	91	189	java/lang/NoSuchFieldException
    //   117	125	189	java/lang/IllegalAccessException
    //   129	137	189	java/lang/IllegalAccessException
    //   139	152	189	java/lang/IllegalAccessException
    //   154	178	189	java/lang/IllegalAccessException
  }
  
  private static String valueIfNotBlank(String paramString) {
    return (paramString == null || paramString.length() == 0) ? null : paramString;
  }
  
  static class DatabaseFieldSample {
    @DatabaseField
    String field;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\j256\ormlite\android\DatabaseTableConfigUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */