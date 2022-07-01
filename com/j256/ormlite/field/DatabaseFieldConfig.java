package com.j256.ormlite.field;

import com.j256.ormlite.db.DatabaseType;
import com.j256.ormlite.field.types.VoidType;
import com.j256.ormlite.misc.JavaxPersistence;
import com.j256.ormlite.table.DatabaseTableConfig;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.sql.SQLException;

public class DatabaseFieldConfig {
  public static final boolean DEFAULT_CAN_BE_NULL = true;
  
  public static final DataType DEFAULT_DATA_TYPE;
  
  public static final boolean DEFAULT_FOREIGN_COLLECTION_ORDER_ASCENDING = true;
  
  private static final int DEFAULT_MAX_EAGER_FOREIGN_COLLECTION_LEVEL = 1;
  
  public static final Class<? extends DataPersister> DEFAULT_PERSISTER_CLASS = (Class)VoidType.class;
  
  private boolean allowGeneratedIdInsert;
  
  private boolean canBeNull = true;
  
  private String columnDefinition;
  
  private String columnName;
  
  private DataPersister dataPersister;
  
  private DataType dataType = DEFAULT_DATA_TYPE;
  
  private String defaultValue;
  
  private String fieldName;
  
  private boolean foreign;
  
  private boolean foreignAutoCreate;
  
  private boolean foreignAutoRefresh;
  
  private boolean foreignCollection;
  
  private String foreignCollectionColumnName;
  
  private boolean foreignCollectionEager;
  
  private String foreignCollectionForeignFieldName;
  
  private int foreignCollectionMaxEagerLevel = 1;
  
  private boolean foreignCollectionOrderAscending = true;
  
  private String foreignCollectionOrderColumnName;
  
  private String foreignColumnName;
  
  private DatabaseTableConfig<?> foreignTableConfig;
  
  private String format;
  
  private boolean generatedId;
  
  private String generatedIdSequence;
  
  private boolean id;
  
  private boolean index;
  
  private String indexName;
  
  private int maxForeignAutoRefreshLevel = -1;
  
  private boolean persisted = true;
  
  private Class<? extends DataPersister> persisterClass = DEFAULT_PERSISTER_CLASS;
  
  private boolean readOnly;
  
  private boolean throwIfNull;
  
  private boolean unique;
  
  private boolean uniqueCombo;
  
  private boolean uniqueIndex;
  
  private String uniqueIndexName;
  
  private Enum<?> unknownEnumValue;
  
  private boolean useGetSet;
  
  private boolean version;
  
  private int width;
  
  static {
    DEFAULT_DATA_TYPE = DataType.UNKNOWN;
  }
  
  public DatabaseFieldConfig() {}
  
  public DatabaseFieldConfig(String paramString) {
    this.fieldName = paramString;
  }
  
  public DatabaseFieldConfig(String paramString1, String paramString2, DataType paramDataType, String paramString3, int paramInt1, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, String paramString4, boolean paramBoolean4, DatabaseTableConfig<?> paramDatabaseTableConfig, boolean paramBoolean5, Enum<?> paramEnum, boolean paramBoolean6, String paramString5, boolean paramBoolean7, String paramString6, String paramString7, boolean paramBoolean8, int paramInt2, int paramInt3) {
    this.fieldName = paramString1;
    this.columnName = paramString2;
    this.dataType = DataType.UNKNOWN;
    this.defaultValue = paramString3;
    this.width = paramInt1;
    this.canBeNull = paramBoolean1;
    this.id = paramBoolean2;
    this.generatedId = paramBoolean3;
    this.generatedIdSequence = paramString4;
    this.foreign = paramBoolean4;
    this.foreignTableConfig = paramDatabaseTableConfig;
    this.useGetSet = paramBoolean5;
    this.unknownEnumValue = paramEnum;
    this.throwIfNull = paramBoolean6;
    this.format = paramString5;
    this.unique = paramBoolean7;
    this.indexName = paramString6;
    this.uniqueIndexName = paramString7;
    this.foreignAutoRefresh = paramBoolean8;
    this.maxForeignAutoRefreshLevel = paramInt2;
    this.foreignCollectionMaxEagerLevel = paramInt3;
  }
  
  public static Method findGetMethod(Field paramField, boolean paramBoolean) {
    String str = methodFromField(paramField, "get");
    try {
      StringBuilder stringBuilder;
      Method method = paramField.getDeclaringClass().getMethod(str, new Class[0]);
      if (method.getReturnType() != paramField.getType()) {
        if (!paramBoolean)
          return null; 
        stringBuilder = new StringBuilder();
        stringBuilder.append("Return type of get method ");
        stringBuilder.append(str);
        stringBuilder.append(" does not return ");
        stringBuilder.append(paramField.getType());
        throw new IllegalArgumentException(stringBuilder.toString());
      } 
      return (Method)stringBuilder;
    } catch (Exception exception) {
      if (!paramBoolean)
        return null; 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Could not find appropriate get method for ");
      stringBuilder.append(paramField);
      throw new IllegalArgumentException(stringBuilder.toString());
    } 
  }
  
  private String findIndexName(String paramString) {
    if (this.columnName == null) {
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append(paramString);
      stringBuilder1.append("_");
      stringBuilder1.append(this.fieldName);
      stringBuilder1.append("_idx");
      return stringBuilder1.toString();
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramString);
    stringBuilder.append("_");
    stringBuilder.append(this.columnName);
    stringBuilder.append("_idx");
    return stringBuilder.toString();
  }
  
  public static Enum<?> findMatchingEnumVal(Field paramField, String paramString) {
    if (paramString == null || paramString.length() == 0)
      return null; 
    for (Enum<?> enum_ : (Enum[])paramField.getType().getEnumConstants()) {
      if (enum_.name().equals(paramString))
        return enum_; 
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Unknwown enum unknown name ");
    stringBuilder.append(paramString);
    stringBuilder.append(" for field ");
    stringBuilder.append(paramField);
    throw new IllegalArgumentException(stringBuilder.toString());
  }
  
  public static Method findSetMethod(Field paramField, boolean paramBoolean) {
    StringBuilder stringBuilder;
    String str = methodFromField(paramField, "set");
    try {
      Method method = paramField.getDeclaringClass().getMethod(str, new Class[] { paramField.getType() });
      if (method.getReturnType() != void.class) {
        if (!paramBoolean)
          return null; 
        stringBuilder = new StringBuilder();
        stringBuilder.append("Return type of set method ");
        stringBuilder.append(str);
        stringBuilder.append(" returns ");
        stringBuilder.append(method.getReturnType());
        stringBuilder.append(" instead of void");
        throw new IllegalArgumentException(stringBuilder.toString());
      } 
      return method;
    } catch (Exception exception) {
      if (!paramBoolean)
        return null; 
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append("Could not find appropriate set method for ");
      stringBuilder1.append(stringBuilder);
      throw new IllegalArgumentException(stringBuilder1.toString());
    } 
  }
  
  public static DatabaseFieldConfig fromDatabaseField(DatabaseType paramDatabaseType, String paramString, Field paramField, DatabaseField paramDatabaseField) {
    DatabaseFieldConfig databaseFieldConfig = new DatabaseFieldConfig();
    databaseFieldConfig.fieldName = paramField.getName();
    if (paramDatabaseType.isEntityNamesMustBeUpCase())
      databaseFieldConfig.fieldName = databaseFieldConfig.fieldName.toUpperCase(); 
    databaseFieldConfig.columnName = valueIfNotBlank(paramDatabaseField.columnName());
    databaseFieldConfig.dataType = paramDatabaseField.dataType();
    String str = paramDatabaseField.defaultValue();
    if (!str.equals("__ormlite__ no default value string was specified"))
      databaseFieldConfig.defaultValue = str; 
    databaseFieldConfig.width = paramDatabaseField.width();
    databaseFieldConfig.canBeNull = paramDatabaseField.canBeNull();
    databaseFieldConfig.id = paramDatabaseField.id();
    databaseFieldConfig.generatedId = paramDatabaseField.generatedId();
    databaseFieldConfig.generatedIdSequence = valueIfNotBlank(paramDatabaseField.generatedIdSequence());
    databaseFieldConfig.foreign = paramDatabaseField.foreign();
    databaseFieldConfig.useGetSet = paramDatabaseField.useGetSet();
    databaseFieldConfig.unknownEnumValue = findMatchingEnumVal(paramField, paramDatabaseField.unknownEnumName());
    databaseFieldConfig.throwIfNull = paramDatabaseField.throwIfNull();
    databaseFieldConfig.format = valueIfNotBlank(paramDatabaseField.format());
    databaseFieldConfig.unique = paramDatabaseField.unique();
    databaseFieldConfig.uniqueCombo = paramDatabaseField.uniqueCombo();
    databaseFieldConfig.index = paramDatabaseField.index();
    databaseFieldConfig.indexName = valueIfNotBlank(paramDatabaseField.indexName());
    databaseFieldConfig.uniqueIndex = paramDatabaseField.uniqueIndex();
    databaseFieldConfig.uniqueIndexName = valueIfNotBlank(paramDatabaseField.uniqueIndexName());
    databaseFieldConfig.foreignAutoRefresh = paramDatabaseField.foreignAutoRefresh();
    databaseFieldConfig.maxForeignAutoRefreshLevel = paramDatabaseField.maxForeignAutoRefreshLevel();
    databaseFieldConfig.persisterClass = paramDatabaseField.persisterClass();
    databaseFieldConfig.allowGeneratedIdInsert = paramDatabaseField.allowGeneratedIdInsert();
    databaseFieldConfig.columnDefinition = valueIfNotBlank(paramDatabaseField.columnDefinition());
    databaseFieldConfig.foreignAutoCreate = paramDatabaseField.foreignAutoCreate();
    databaseFieldConfig.version = paramDatabaseField.version();
    databaseFieldConfig.foreignColumnName = valueIfNotBlank(paramDatabaseField.foreignColumnName());
    databaseFieldConfig.readOnly = paramDatabaseField.readOnly();
    return databaseFieldConfig;
  }
  
  public static DatabaseFieldConfig fromField(DatabaseType paramDatabaseType, String paramString, Field paramField) throws SQLException {
    DatabaseField databaseField = paramField.<DatabaseField>getAnnotation(DatabaseField.class);
    if (databaseField != null)
      return databaseField.persisted() ? fromDatabaseField(paramDatabaseType, paramString, paramField, databaseField) : null; 
    ForeignCollectionField foreignCollectionField = paramField.<ForeignCollectionField>getAnnotation(ForeignCollectionField.class);
    return (foreignCollectionField != null) ? fromForeignCollection(paramDatabaseType, paramField, foreignCollectionField) : JavaxPersistence.createFieldConfig(paramDatabaseType, paramField);
  }
  
  private static DatabaseFieldConfig fromForeignCollection(DatabaseType paramDatabaseType, Field paramField, ForeignCollectionField paramForeignCollectionField) {
    DatabaseFieldConfig databaseFieldConfig = new DatabaseFieldConfig();
    databaseFieldConfig.fieldName = paramField.getName();
    if (paramForeignCollectionField.columnName().length() > 0)
      databaseFieldConfig.columnName = paramForeignCollectionField.columnName(); 
    databaseFieldConfig.foreignCollection = true;
    databaseFieldConfig.foreignCollectionEager = paramForeignCollectionField.eager();
    int i = paramForeignCollectionField.maxEagerForeignCollectionLevel();
    if (i != 1) {
      databaseFieldConfig.foreignCollectionMaxEagerLevel = i;
    } else {
      databaseFieldConfig.foreignCollectionMaxEagerLevel = paramForeignCollectionField.maxEagerLevel();
    } 
    databaseFieldConfig.foreignCollectionOrderColumnName = valueIfNotBlank(paramForeignCollectionField.orderColumnName());
    databaseFieldConfig.foreignCollectionOrderAscending = paramForeignCollectionField.orderAscending();
    databaseFieldConfig.foreignCollectionColumnName = valueIfNotBlank(paramForeignCollectionField.columnName());
    String str = valueIfNotBlank(paramForeignCollectionField.foreignFieldName());
    if (str == null) {
      databaseFieldConfig.foreignCollectionForeignFieldName = valueIfNotBlank(valueIfNotBlank(paramForeignCollectionField.foreignColumnName()));
      return databaseFieldConfig;
    } 
    databaseFieldConfig.foreignCollectionForeignFieldName = str;
    return databaseFieldConfig;
  }
  
  private static String methodFromField(Field paramField, String paramString) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramString);
    stringBuilder.append(paramField.getName().substring(0, 1).toUpperCase());
    stringBuilder.append(paramField.getName().substring(1));
    return stringBuilder.toString();
  }
  
  private static String valueIfNotBlank(String paramString) {
    return (paramString == null || paramString.length() == 0) ? null : paramString;
  }
  
  public String getColumnDefinition() {
    return this.columnDefinition;
  }
  
  public String getColumnName() {
    return this.columnName;
  }
  
  public DataPersister getDataPersister() {
    DataPersister dataPersister2 = this.dataPersister;
    DataPersister dataPersister1 = dataPersister2;
    if (dataPersister2 == null)
      dataPersister1 = this.dataType.getDataPersister(); 
    return dataPersister1;
  }
  
  public DataType getDataType() {
    return this.dataType;
  }
  
  public String getDefaultValue() {
    return this.defaultValue;
  }
  
  public String getFieldName() {
    return this.fieldName;
  }
  
  public String getForeignCollectionColumnName() {
    return this.foreignCollectionColumnName;
  }
  
  public String getForeignCollectionForeignFieldName() {
    return this.foreignCollectionForeignFieldName;
  }
  
  public int getForeignCollectionMaxEagerLevel() {
    return this.foreignCollectionMaxEagerLevel;
  }
  
  public String getForeignCollectionOrderColumnName() {
    return this.foreignCollectionOrderColumnName;
  }
  
  public String getForeignColumnName() {
    return this.foreignColumnName;
  }
  
  public DatabaseTableConfig<?> getForeignTableConfig() {
    return this.foreignTableConfig;
  }
  
  public String getFormat() {
    return this.format;
  }
  
  public String getGeneratedIdSequence() {
    return this.generatedIdSequence;
  }
  
  public String getIndexName(String paramString) {
    if (this.index && this.indexName == null)
      this.indexName = findIndexName(paramString); 
    return this.indexName;
  }
  
  public int getMaxForeignAutoRefreshLevel() {
    return this.maxForeignAutoRefreshLevel;
  }
  
  public Class<? extends DataPersister> getPersisterClass() {
    return this.persisterClass;
  }
  
  public String getUniqueIndexName(String paramString) {
    if (this.uniqueIndex && this.uniqueIndexName == null)
      this.uniqueIndexName = findIndexName(paramString); 
    return this.uniqueIndexName;
  }
  
  public Enum<?> getUnknownEnumValue() {
    return this.unknownEnumValue;
  }
  
  public int getWidth() {
    return this.width;
  }
  
  public boolean isAllowGeneratedIdInsert() {
    return this.allowGeneratedIdInsert;
  }
  
  public boolean isCanBeNull() {
    return this.canBeNull;
  }
  
  public boolean isForeign() {
    return this.foreign;
  }
  
  public boolean isForeignAutoCreate() {
    return this.foreignAutoCreate;
  }
  
  public boolean isForeignAutoRefresh() {
    return this.foreignAutoRefresh;
  }
  
  public boolean isForeignCollection() {
    return this.foreignCollection;
  }
  
  public boolean isForeignCollectionEager() {
    return this.foreignCollectionEager;
  }
  
  public boolean isForeignCollectionOrderAscending() {
    return this.foreignCollectionOrderAscending;
  }
  
  public boolean isGeneratedId() {
    return this.generatedId;
  }
  
  public boolean isId() {
    return this.id;
  }
  
  public boolean isIndex() {
    return this.index;
  }
  
  public boolean isPersisted() {
    return this.persisted;
  }
  
  public boolean isReadOnly() {
    return this.readOnly;
  }
  
  public boolean isThrowIfNull() {
    return this.throwIfNull;
  }
  
  public boolean isUnique() {
    return this.unique;
  }
  
  public boolean isUniqueCombo() {
    return this.uniqueCombo;
  }
  
  public boolean isUniqueIndex() {
    return this.uniqueIndex;
  }
  
  public boolean isUseGetSet() {
    return this.useGetSet;
  }
  
  public boolean isVersion() {
    return this.version;
  }
  
  public void postProcess() {
    if (this.foreignColumnName != null)
      this.foreignAutoRefresh = true; 
    if (this.foreignAutoRefresh && this.maxForeignAutoRefreshLevel == -1)
      this.maxForeignAutoRefreshLevel = 2; 
  }
  
  public void setAllowGeneratedIdInsert(boolean paramBoolean) {
    this.allowGeneratedIdInsert = paramBoolean;
  }
  
  public void setCanBeNull(boolean paramBoolean) {
    this.canBeNull = paramBoolean;
  }
  
  public void setColumnDefinition(String paramString) {
    this.columnDefinition = paramString;
  }
  
  public void setColumnName(String paramString) {
    this.columnName = paramString;
  }
  
  public void setDataPersister(DataPersister paramDataPersister) {
    this.dataPersister = paramDataPersister;
  }
  
  public void setDataType(DataType paramDataType) {
    this.dataType = paramDataType;
  }
  
  public void setDefaultValue(String paramString) {
    this.defaultValue = paramString;
  }
  
  public void setFieldName(String paramString) {
    this.fieldName = paramString;
  }
  
  public void setForeign(boolean paramBoolean) {
    this.foreign = paramBoolean;
  }
  
  public void setForeignAutoCreate(boolean paramBoolean) {
    this.foreignAutoCreate = paramBoolean;
  }
  
  public void setForeignAutoRefresh(boolean paramBoolean) {
    this.foreignAutoRefresh = paramBoolean;
  }
  
  public void setForeignCollection(boolean paramBoolean) {
    this.foreignCollection = paramBoolean;
  }
  
  public void setForeignCollectionColumnName(String paramString) {
    this.foreignCollectionColumnName = paramString;
  }
  
  public void setForeignCollectionEager(boolean paramBoolean) {
    this.foreignCollectionEager = paramBoolean;
  }
  
  @Deprecated
  public void setForeignCollectionForeignColumnName(String paramString) {
    this.foreignCollectionForeignFieldName = paramString;
  }
  
  public void setForeignCollectionForeignFieldName(String paramString) {
    this.foreignCollectionForeignFieldName = paramString;
  }
  
  @Deprecated
  public void setForeignCollectionMaxEagerForeignCollectionLevel(int paramInt) {
    this.foreignCollectionMaxEagerLevel = paramInt;
  }
  
  public void setForeignCollectionMaxEagerLevel(int paramInt) {
    this.foreignCollectionMaxEagerLevel = paramInt;
  }
  
  public void setForeignCollectionOrderAscending(boolean paramBoolean) {
    this.foreignCollectionOrderAscending = paramBoolean;
  }
  
  @Deprecated
  public void setForeignCollectionOrderColumn(String paramString) {
    this.foreignCollectionOrderColumnName = paramString;
  }
  
  public void setForeignCollectionOrderColumnName(String paramString) {
    this.foreignCollectionOrderColumnName = paramString;
  }
  
  public void setForeignColumnName(String paramString) {
    this.foreignColumnName = paramString;
  }
  
  public void setForeignTableConfig(DatabaseTableConfig<?> paramDatabaseTableConfig) {
    this.foreignTableConfig = paramDatabaseTableConfig;
  }
  
  public void setFormat(String paramString) {
    this.format = paramString;
  }
  
  public void setGeneratedId(boolean paramBoolean) {
    this.generatedId = paramBoolean;
  }
  
  public void setGeneratedIdSequence(String paramString) {
    this.generatedIdSequence = paramString;
  }
  
  public void setId(boolean paramBoolean) {
    this.id = paramBoolean;
  }
  
  public void setIndex(boolean paramBoolean) {
    this.index = paramBoolean;
  }
  
  public void setIndexName(String paramString) {
    this.indexName = paramString;
  }
  
  @Deprecated
  public void setMaxEagerForeignCollectionLevel(int paramInt) {
    this.foreignCollectionMaxEagerLevel = paramInt;
  }
  
  public void setMaxForeignAutoRefreshLevel(int paramInt) {
    this.maxForeignAutoRefreshLevel = paramInt;
  }
  
  public void setPersisted(boolean paramBoolean) {
    this.persisted = paramBoolean;
  }
  
  public void setPersisterClass(Class<? extends DataPersister> paramClass) {
    this.persisterClass = paramClass;
  }
  
  public void setReadOnly(boolean paramBoolean) {
    this.readOnly = paramBoolean;
  }
  
  public void setThrowIfNull(boolean paramBoolean) {
    this.throwIfNull = paramBoolean;
  }
  
  public void setUnique(boolean paramBoolean) {
    this.unique = paramBoolean;
  }
  
  public void setUniqueCombo(boolean paramBoolean) {
    this.uniqueCombo = paramBoolean;
  }
  
  public void setUniqueIndex(boolean paramBoolean) {
    this.uniqueIndex = paramBoolean;
  }
  
  public void setUniqueIndexName(String paramString) {
    this.uniqueIndexName = paramString;
  }
  
  public void setUnknownEnumValue(Enum<?> paramEnum) {
    this.unknownEnumValue = paramEnum;
  }
  
  public void setUseGetSet(boolean paramBoolean) {
    this.useGetSet = paramBoolean;
  }
  
  public void setVersion(boolean paramBoolean) {
    this.version = paramBoolean;
  }
  
  public void setWidth(int paramInt) {
    this.width = paramInt;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\j256\ormlite\field\DatabaseFieldConfig.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */