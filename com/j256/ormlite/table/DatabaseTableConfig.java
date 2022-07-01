package com.j256.ormlite.table;

import com.j256.ormlite.db.DatabaseType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.DatabaseFieldConfig;
import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.misc.JavaxPersistence;
import com.j256.ormlite.support.ConnectionSource;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DatabaseTableConfig<T> {
  private Constructor<T> constructor;
  
  private Class<T> dataClass;
  
  private List<DatabaseFieldConfig> fieldConfigs;
  
  private FieldType[] fieldTypes;
  
  private String tableName;
  
  public DatabaseTableConfig() {}
  
  public DatabaseTableConfig(Class<T> paramClass, String paramString, List<DatabaseFieldConfig> paramList) {
    this.dataClass = paramClass;
    this.tableName = paramString;
    this.fieldConfigs = paramList;
  }
  
  private DatabaseTableConfig(Class<T> paramClass, String paramString, FieldType[] paramArrayOfFieldType) {
    this.dataClass = paramClass;
    this.tableName = paramString;
    this.fieldTypes = paramArrayOfFieldType;
  }
  
  public DatabaseTableConfig(Class<T> paramClass, List<DatabaseFieldConfig> paramList) {
    this(paramClass, extractTableName(paramClass), paramList);
  }
  
  private FieldType[] convertFieldConfigs(ConnectionSource paramConnectionSource, String paramString, List<DatabaseFieldConfig> paramList) throws SQLException {
    ArrayList<FieldType> arrayList = new ArrayList();
    Iterator<DatabaseFieldConfig> iterator = paramList.iterator();
    label24: while (true) {
      if (iterator.hasNext()) {
        DatabaseFieldConfig databaseFieldConfig = iterator.next();
        Field field = null;
        for (Class<T> clazz = this.dataClass;; clazz = (Class)clazz.getSuperclass()) {
          Field field1 = field;
          if (clazz != null)
            try {
              FieldType fieldType;
              field1 = clazz.getDeclaredField(databaseFieldConfig.getFieldName());
              if (field1 != null) {
                fieldType = new FieldType(paramConnectionSource, paramString, field1, databaseFieldConfig, this.dataClass);
              } else {
                continue;
              } 
              if (fieldType != null) {
                arrayList.add(fieldType);
                continue label24;
              } 
              StringBuilder stringBuilder2 = new StringBuilder();
              stringBuilder2.append("Could not find declared field with name '");
              stringBuilder2.append(databaseFieldConfig.getFieldName());
              stringBuilder2.append("' for ");
              stringBuilder2.append(this.dataClass);
              throw new SQLException(stringBuilder2.toString());
            } catch (NoSuchFieldException noSuchFieldException) {
              continue;
            }  
          if (noSuchFieldException != null) {
            arrayList.add(noSuchFieldException);
            continue label24;
          } 
          StringBuilder stringBuilder1 = new StringBuilder();
          stringBuilder1.append("Could not find declared field with name '");
          stringBuilder1.append(databaseFieldConfig.getFieldName());
          stringBuilder1.append("' for ");
          stringBuilder1.append(this.dataClass);
          throw new SQLException(stringBuilder1.toString());
        } 
        break;
      } 
      if (!arrayList.isEmpty())
        return arrayList.<FieldType>toArray(new FieldType[arrayList.size()]); 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("No fields were configured for class ");
      stringBuilder.append(this.dataClass);
      throw new SQLException(stringBuilder.toString());
    } 
  }
  
  private static <T> FieldType[] extractFieldTypes(ConnectionSource paramConnectionSource, Class<T> paramClass, String paramString) throws SQLException {
    ArrayList<FieldType> arrayList = new ArrayList();
    for (Class<T> clazz = paramClass; clazz != null; clazz = (Class)clazz.getSuperclass()) {
      Field[] arrayOfField = clazz.getDeclaredFields();
      int j = arrayOfField.length;
      for (int i = 0; i < j; i++) {
        FieldType fieldType = FieldType.createFieldType(paramConnectionSource, paramString, arrayOfField[i], paramClass);
        if (fieldType != null)
          arrayList.add(fieldType); 
      } 
    } 
    if (!arrayList.isEmpty())
      return arrayList.<FieldType>toArray(new FieldType[arrayList.size()]); 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("No fields have a ");
    stringBuilder.append(DatabaseField.class.getSimpleName());
    stringBuilder.append(" annotation in ");
    stringBuilder.append(paramClass);
    throw new IllegalArgumentException(stringBuilder.toString());
  }
  
  public static <T> String extractTableName(Class<T> paramClass) {
    DatabaseTable databaseTable = paramClass.<DatabaseTable>getAnnotation(DatabaseTable.class);
    if (databaseTable != null && databaseTable.tableName() != null && databaseTable.tableName().length() > 0)
      return databaseTable.tableName(); 
    String str = JavaxPersistence.getEntityName(paramClass);
    return (str == null) ? paramClass.getSimpleName().toLowerCase() : str;
  }
  
  public static <T> Constructor<T> findNoArgConstructor(Class<T> paramClass) {
    try {
      for (Constructor<T> constructor : (Constructor[])paramClass.getDeclaredConstructors()) {
        if ((constructor.getParameterTypes()).length == 0) {
          if (!constructor.isAccessible())
            try {
              constructor.setAccessible(true);
              return constructor;
            } catch (SecurityException securityException) {
              StringBuilder stringBuilder1 = new StringBuilder();
              stringBuilder1.append("Could not open access to constructor for ");
              stringBuilder1.append(paramClass);
              throw new IllegalArgumentException(stringBuilder1.toString());
            }  
          return constructor;
        } 
      } 
      if (paramClass.getEnclosingClass() == null) {
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append("Can't find a no-arg constructor for ");
        stringBuilder1.append(paramClass);
        throw new IllegalArgumentException(stringBuilder1.toString());
      } 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Can't find a no-arg constructor for ");
      stringBuilder.append(paramClass);
      stringBuilder.append(".  Missing static on inner class?");
      throw new IllegalArgumentException(stringBuilder.toString());
    } catch (Exception exception) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Can't lookup declared constructors for ");
      stringBuilder.append(paramClass);
      throw new IllegalArgumentException(stringBuilder.toString(), exception);
    } 
  }
  
  public static <T> DatabaseTableConfig<T> fromClass(ConnectionSource paramConnectionSource, Class<T> paramClass) throws SQLException {
    String str2 = extractTableName(paramClass);
    String str1 = str2;
    if (paramConnectionSource.getDatabaseType().isEntityNamesMustBeUpCase())
      str1 = str2.toUpperCase(); 
    return new DatabaseTableConfig<T>(paramClass, str1, extractFieldTypes(paramConnectionSource, paramClass, str1));
  }
  
  public void extractFieldTypes(ConnectionSource paramConnectionSource) throws SQLException {
    if (this.fieldTypes == null) {
      List<DatabaseFieldConfig> list = this.fieldConfigs;
      if (list == null) {
        this.fieldTypes = extractFieldTypes(paramConnectionSource, this.dataClass, this.tableName);
        return;
      } 
      this.fieldTypes = convertFieldConfigs(paramConnectionSource, this.tableName, list);
    } 
  }
  
  public Constructor<T> getConstructor() {
    if (this.constructor == null)
      this.constructor = findNoArgConstructor(this.dataClass); 
    return this.constructor;
  }
  
  public Class<T> getDataClass() {
    return this.dataClass;
  }
  
  public List<DatabaseFieldConfig> getFieldConfigs() {
    return this.fieldConfigs;
  }
  
  public FieldType[] getFieldTypes(DatabaseType paramDatabaseType) throws SQLException {
    FieldType[] arrayOfFieldType = this.fieldTypes;
    if (arrayOfFieldType != null)
      return arrayOfFieldType; 
    throw new SQLException("Field types have not been extracted in table config");
  }
  
  public String getTableName() {
    return this.tableName;
  }
  
  public void initialize() {
    Class<T> clazz = this.dataClass;
    if (clazz != null) {
      if (this.tableName == null)
        this.tableName = extractTableName(clazz); 
      return;
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("dataClass was never set on ");
    stringBuilder.append(getClass().getSimpleName());
    throw new IllegalStateException(stringBuilder.toString());
  }
  
  public void setConstructor(Constructor<T> paramConstructor) {
    this.constructor = paramConstructor;
  }
  
  public void setDataClass(Class<T> paramClass) {
    this.dataClass = paramClass;
  }
  
  public void setFieldConfigs(List<DatabaseFieldConfig> paramList) {
    this.fieldConfigs = paramList;
  }
  
  public void setTableName(String paramString) {
    this.tableName = paramString;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\j256\ormlite\table\DatabaseTableConfig.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */