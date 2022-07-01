package com.j256.ormlite.field;

import com.j256.ormlite.dao.BaseDaoImpl;
import com.j256.ormlite.dao.BaseForeignCollection;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.dao.EagerForeignCollection;
import com.j256.ormlite.dao.ForeignCollection;
import com.j256.ormlite.dao.LazyForeignCollection;
import com.j256.ormlite.dao.ObjectCache;
import com.j256.ormlite.db.DatabaseType;
import com.j256.ormlite.field.types.VoidType;
import com.j256.ormlite.misc.SqlExceptionUtil;
import com.j256.ormlite.stmt.mapped.MappedQueryForId;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.support.DatabaseResults;
import com.j256.ormlite.table.DatabaseTableConfig;
import com.j256.ormlite.table.TableInfo;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Map;

public class FieldType {
  private static boolean DEFAULT_VALUE_BOOLEAN = false;
  
  private static byte DEFAULT_VALUE_BYTE = 0;
  
  private static char DEFAULT_VALUE_CHAR = '\000';
  
  private static double DEFAULT_VALUE_DOUBLE = 0.0D;
  
  private static float DEFAULT_VALUE_FLOAT = 0.0F;
  
  private static int DEFAULT_VALUE_INT = 0;
  
  private static long DEFAULT_VALUE_LONG = 0L;
  
  private static short DEFAULT_VALUE_SHORT = 0;
  
  public static final String FOREIGN_ID_FIELD_SUFFIX = "_id";
  
  private static final ThreadLocal<LevelCounters> threadLevelCounters = new ThreadLocal<LevelCounters>() {
      protected FieldType.LevelCounters initialValue() {
        return new FieldType.LevelCounters();
      }
    };
  
  private final String columnName;
  
  private final ConnectionSource connectionSource;
  
  private DataPersister dataPersister;
  
  private Object dataTypeConfigObj;
  
  private Object defaultValue;
  
  private final Field field;
  
  private final DatabaseFieldConfig fieldConfig;
  
  private FieldConverter fieldConverter;
  
  private final Method fieldGetMethod;
  
  private final Method fieldSetMethod;
  
  private BaseDaoImpl<?, ?> foreignDao;
  
  private FieldType foreignFieldType;
  
  private FieldType foreignIdField;
  
  private TableInfo<?, ?> foreignTableInfo;
  
  private final String generatedIdSequence;
  
  private final boolean isGeneratedId;
  
  private final boolean isId;
  
  private MappedQueryForId<Object, Object> mappedQueryForId;
  
  private final Class<?> parentClass;
  
  private final String tableName;
  
  public FieldType(ConnectionSource paramConnectionSource, String paramString, Field paramField, DatabaseFieldConfig paramDatabaseFieldConfig, Class<?> paramClass) throws SQLException {
    Class<?> clazz1;
    StringBuilder stringBuilder;
    this.connectionSource = paramConnectionSource;
    this.tableName = paramString;
    DatabaseType databaseType = paramConnectionSource.getDatabaseType();
    this.field = paramField;
    this.parentClass = paramClass;
    paramDatabaseFieldConfig.postProcess();
    Class<?> clazz2 = paramField.getType();
    if (paramDatabaseFieldConfig.getDataPersister() == null) {
      paramClass = paramDatabaseFieldConfig.getPersisterClass();
      if (paramClass == null || paramClass == VoidType.class) {
        DataPersister dataPersister = DataPersisterManager.lookupForField(paramField);
      } else {
        try {
          Method method = paramClass.getDeclaredMethod("getSingleton", new Class[0]);
          try {
            object = method.invoke(null, new Object[0]);
            if (object != null) {
              try {
                object = object;
              } catch (Exception exception) {
                StringBuilder stringBuilder1 = new StringBuilder();
                stringBuilder1.append("Could not cast result of static getSingleton method to DataPersister from class ");
                stringBuilder1.append(paramClass);
                throw SqlExceptionUtil.create(stringBuilder1.toString(), exception);
              } 
            } else {
              object = new StringBuilder();
              object.append("Static getSingleton method should not return null on class ");
              object.append(paramClass);
              throw new SQLException(object.toString());
            } 
          } catch (InvocationTargetException null) {
            StringBuilder stringBuilder1 = new StringBuilder();
            stringBuilder1.append("Could not run getSingleton method on class ");
            stringBuilder1.append(paramClass);
            throw SqlExceptionUtil.create(stringBuilder1.toString(), object.getTargetException());
          } catch (Exception null) {
            StringBuilder stringBuilder1 = new StringBuilder();
            stringBuilder1.append("Could not run getSingleton method on class ");
            stringBuilder1.append(paramClass);
            throw SqlExceptionUtil.create(stringBuilder1.toString(), object);
          } 
        } catch (Exception null) {
          StringBuilder stringBuilder1 = new StringBuilder();
          stringBuilder1.append("Could not find getSingleton static method on class ");
          stringBuilder1.append(paramClass);
          throw SqlExceptionUtil.create(stringBuilder1.toString(), object);
        } 
      } 
    } else {
      DataPersister dataPersister = paramDatabaseFieldConfig.getDataPersister();
      object = dataPersister;
      if (!dataPersister.isValidForField(paramField)) {
        object = new StringBuilder();
        object.append("Field class ");
        object.append(clazz2.getName());
        object.append(" for field ");
        object.append(this);
        object.append(" is not valid for type ");
        object.append(dataPersister);
        clazz1 = dataPersister.getPrimaryClass();
        if (clazz1 != null) {
          stringBuilder = new StringBuilder();
          stringBuilder.append(", maybe should be ");
          stringBuilder.append(clazz1);
          object.append(stringBuilder.toString());
        } 
        throw new IllegalArgumentException(object.toString());
      } 
    } 
    String str1 = paramDatabaseFieldConfig.getForeignColumnName();
    String str2 = stringBuilder.getName();
    if (paramDatabaseFieldConfig.isForeign() || paramDatabaseFieldConfig.isForeignAutoRefresh() || str1 != null) {
      if (object == null || !object.isPrimitive()) {
        String str;
        if (str1 == null) {
          StringBuilder stringBuilder1 = new StringBuilder();
          stringBuilder1.append(str2);
          stringBuilder1.append("_id");
          str = stringBuilder1.toString();
        } else {
          StringBuilder stringBuilder1 = new StringBuilder();
          stringBuilder1.append(str2);
          stringBuilder1.append("_");
          stringBuilder1.append(str);
          str = stringBuilder1.toString();
        } 
        if (ForeignCollection.class.isAssignableFrom(clazz2)) {
          object = new StringBuilder();
          object.append("Field '");
          object.append(stringBuilder.getName());
          object.append("' in class ");
          object.append(clazz2);
          object.append("' should use the @");
          object.append(ForeignCollectionField.class.getSimpleName());
          object.append(" annotation not foreign=true");
          throw new SQLException(object.toString());
        } 
      } else {
        object = new StringBuilder();
        object.append("Field ");
        object.append(this);
        object.append(" is a primitive class ");
        object.append(clazz2);
        object.append(" but marked as foreign");
        throw new IllegalArgumentException(object.toString());
      } 
    } else if (paramDatabaseFieldConfig.isForeignCollection()) {
      if (clazz2 == Collection.class || ForeignCollection.class.isAssignableFrom(clazz2)) {
        Type type = stringBuilder.getGenericType();
        if (type instanceof ParameterizedType) {
          if ((((ParameterizedType)type).getActualTypeArguments()).length != 0) {
            String str = str2;
          } else {
            object = new StringBuilder();
            object.append("Field class for '");
            object.append(stringBuilder.getName());
            object.append("' must be a parameterized Collection with at least 1 type.");
            throw new SQLException(object.toString());
          } 
        } else {
          object = new StringBuilder();
          object.append("Field class for '");
          object.append(stringBuilder.getName());
          object.append("' must be a parameterized Collection.");
          throw new SQLException(object.toString());
        } 
      } else {
        object = new StringBuilder();
        object.append("Field class for '");
        object.append(stringBuilder.getName());
        object.append("' must be of class ");
        object.append(ForeignCollection.class.getSimpleName());
        object.append(" or Collection.");
        throw new SQLException(object.toString());
      } 
    } else {
      str1 = str2;
      if (object == null) {
        str1 = str2;
        if (!paramDatabaseFieldConfig.isForeignCollection()) {
          if (!byte[].class.isAssignableFrom(clazz2)) {
            if (Serializable.class.isAssignableFrom(clazz2)) {
              object = new StringBuilder();
              object.append("ORMLite does not know how to store ");
              object.append(clazz2);
              object.append(" for field '");
              object.append(stringBuilder.getName());
              object.append("'.  Use another class, custom persister, or to serialize it use ");
              object.append("dataType=DataType.SERIALIZABLE");
              throw new SQLException(object.toString());
            } 
            object = new StringBuilder();
            object.append("ORMLite does not know how to store ");
            object.append(clazz2);
            object.append(" for field ");
            object.append(stringBuilder.getName());
            object.append(". Use another class or a custom persister.");
            throw new IllegalArgumentException(object.toString());
          } 
          object = new StringBuilder();
          object.append("ORMLite does not know how to store ");
          object.append(clazz2);
          object.append(" for field '");
          object.append(stringBuilder.getName());
          object.append("'. byte[] fields must specify dataType=DataType.BYTE_ARRAY or SERIALIZABLE");
          throw new SQLException(object.toString());
        } 
      } 
    } 
    if (paramDatabaseFieldConfig.getColumnName() == null) {
      this.columnName = str1;
    } else {
      this.columnName = paramDatabaseFieldConfig.getColumnName();
    } 
    this.fieldConfig = paramDatabaseFieldConfig;
    if (paramDatabaseFieldConfig.isId()) {
      if (!paramDatabaseFieldConfig.isGeneratedId() && paramDatabaseFieldConfig.getGeneratedIdSequence() == null) {
        this.isId = true;
        this.isGeneratedId = false;
        this.generatedIdSequence = null;
      } else {
        object = new StringBuilder();
        object.append("Must specify one of id, generatedId, and generatedIdSequence with ");
        object.append(stringBuilder.getName());
        throw new IllegalArgumentException(object.toString());
      } 
    } else if (paramDatabaseFieldConfig.isGeneratedId()) {
      if (paramDatabaseFieldConfig.getGeneratedIdSequence() == null) {
        this.isId = true;
        this.isGeneratedId = true;
        if (databaseType.isIdSequenceNeeded()) {
          this.generatedIdSequence = databaseType.generateIdSequenceName((String)clazz1, this);
        } else {
          this.generatedIdSequence = null;
        } 
      } else {
        object = new StringBuilder();
        object.append("Must specify one of id, generatedId, and generatedIdSequence with ");
        object.append(stringBuilder.getName());
        throw new IllegalArgumentException(object.toString());
      } 
    } else if (paramDatabaseFieldConfig.getGeneratedIdSequence() != null) {
      this.isId = true;
      this.isGeneratedId = true;
      str1 = paramDatabaseFieldConfig.getGeneratedIdSequence();
      String str = str1;
      if (databaseType.isEntityNamesMustBeUpCase())
        str = str1.toUpperCase(); 
      this.generatedIdSequence = str;
    } else {
      this.isId = false;
      this.isGeneratedId = false;
      this.generatedIdSequence = null;
    } 
    if (!this.isId || (!paramDatabaseFieldConfig.isForeign() && !paramDatabaseFieldConfig.isForeignAutoRefresh())) {
      if (paramDatabaseFieldConfig.isUseGetSet()) {
        this.fieldGetMethod = DatabaseFieldConfig.findGetMethod((Field)stringBuilder, true);
        this.fieldSetMethod = DatabaseFieldConfig.findSetMethod((Field)stringBuilder, true);
      } else {
        if (!stringBuilder.isAccessible())
          try {
            this.field.setAccessible(true);
            this.fieldGetMethod = null;
            this.fieldSetMethod = null;
          } catch (SecurityException securityException) {
            stringBuilder1 = new StringBuilder();
            stringBuilder1.append("Could not open access to field ");
            stringBuilder1.append(stringBuilder.getName());
            stringBuilder1.append(".  You may have to set useGetSet=true to fix.");
            throw new IllegalArgumentException(stringBuilder1.toString());
          }  
        this.fieldGetMethod = null;
        this.fieldSetMethod = null;
      } 
      if (!paramDatabaseFieldConfig.isAllowGeneratedIdInsert() || paramDatabaseFieldConfig.isGeneratedId()) {
        if (!paramDatabaseFieldConfig.isForeignAutoRefresh() || paramDatabaseFieldConfig.isForeign()) {
          if (!paramDatabaseFieldConfig.isForeignAutoCreate() || paramDatabaseFieldConfig.isForeign()) {
            if (paramDatabaseFieldConfig.getForeignColumnName() == null || paramDatabaseFieldConfig.isForeign()) {
              if (!paramDatabaseFieldConfig.isVersion() || (stringBuilder1 != null && stringBuilder1.isValidForVersion())) {
                if (paramDatabaseFieldConfig.getMaxForeignAutoRefreshLevel() <= 0 || paramDatabaseFieldConfig.isForeignAutoRefresh()) {
                  assignDataType(databaseType, (DataPersister)stringBuilder1);
                  return;
                } 
                stringBuilder1 = new StringBuilder();
                stringBuilder1.append("Field ");
                stringBuilder1.append(stringBuilder.getName());
                stringBuilder1.append(" has maxForeignAutoRefreshLevel set but not foreignAutoRefresh is false");
                throw new IllegalArgumentException(stringBuilder1.toString());
              } 
              stringBuilder1 = new StringBuilder();
              stringBuilder1.append("Field ");
              stringBuilder1.append(stringBuilder.getName());
              stringBuilder1.append(" is not a valid type to be a version field");
              throw new IllegalArgumentException(stringBuilder1.toString());
            } 
            stringBuilder1 = new StringBuilder();
            stringBuilder1.append("Field ");
            stringBuilder1.append(stringBuilder.getName());
            stringBuilder1.append(" must have foreign = true if foreignColumnName is set");
            throw new IllegalArgumentException(stringBuilder1.toString());
          } 
          stringBuilder1 = new StringBuilder();
          stringBuilder1.append("Field ");
          stringBuilder1.append(stringBuilder.getName());
          stringBuilder1.append(" must have foreign = true if foreignAutoCreate = true");
          throw new IllegalArgumentException(stringBuilder1.toString());
        } 
        stringBuilder1 = new StringBuilder();
        stringBuilder1.append("Field ");
        stringBuilder1.append(stringBuilder.getName());
        stringBuilder1.append(" must have foreign = true if foreignAutoRefresh = true");
        throw new IllegalArgumentException(stringBuilder1.toString());
      } 
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append("Field ");
      stringBuilder1.append(stringBuilder.getName());
      stringBuilder1.append(" must be a generated-id if allowGeneratedIdInsert = true");
      throw new IllegalArgumentException(stringBuilder1.toString());
    } 
    Object object = new StringBuilder();
    object.append("Id field ");
    object.append(stringBuilder.getName());
    object.append(" cannot also be a foreign object");
    throw new IllegalArgumentException(object.toString());
  }
  
  private void assignDataType(DatabaseType paramDatabaseType, DataPersister paramDataPersister) throws SQLException {
    this.dataPersister = paramDataPersister;
    if (paramDataPersister == null) {
      if (!this.fieldConfig.isForeign()) {
        if (this.fieldConfig.isForeignCollection())
          return; 
        stringBuilder = new StringBuilder();
        stringBuilder.append("Data persister for field ");
        stringBuilder.append(this);
        stringBuilder.append(" is null but the field is not a foreign or foreignCollection");
        throw new SQLException(stringBuilder.toString());
      } 
      return;
    } 
    this.fieldConverter = stringBuilder.getFieldConverter(paramDataPersister);
    if (this.isGeneratedId && !paramDataPersister.isValidGeneratedType()) {
      stringBuilder = new StringBuilder();
      stringBuilder.append("Generated-id field '");
      stringBuilder.append(this.field.getName());
      stringBuilder.append("' in ");
      stringBuilder.append(this.field.getDeclaringClass().getSimpleName());
      stringBuilder.append(" can't be type ");
      stringBuilder.append(this.dataPersister.getSqlType());
      stringBuilder.append(".  Must be one of: ");
      for (DataType dataType : DataType.values()) {
        DataPersister dataPersister = dataType.getDataPersister();
        if (dataPersister != null && dataPersister.isValidGeneratedType()) {
          stringBuilder.append(dataType);
          stringBuilder.append(' ');
        } 
      } 
      throw new IllegalArgumentException(stringBuilder.toString());
    } 
    if (!this.fieldConfig.isThrowIfNull() || paramDataPersister.isPrimitive()) {
      StringBuilder stringBuilder1;
      if (!this.isId || paramDataPersister.isAppropriateId()) {
        this.dataTypeConfigObj = paramDataPersister.makeConfigObject(this);
        String str = this.fieldConfig.getDefaultValue();
        if (str == null) {
          this.defaultValue = null;
          return;
        } 
        if (!this.isGeneratedId) {
          this.defaultValue = this.fieldConverter.parseDefaultString(this, str);
          return;
        } 
        stringBuilder1 = new StringBuilder();
        stringBuilder1.append("Field '");
        stringBuilder1.append(this.field.getName());
        stringBuilder1.append("' cannot be a generatedId and have a default value '");
        stringBuilder1.append(str);
        stringBuilder1.append("'");
        throw new SQLException(stringBuilder1.toString());
      } 
      stringBuilder = new StringBuilder();
      stringBuilder.append("Field '");
      stringBuilder.append(this.field.getName());
      stringBuilder.append("' is of data type ");
      stringBuilder.append(stringBuilder1);
      stringBuilder.append(" which cannot be the ID field");
      throw new SQLException(stringBuilder.toString());
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Field ");
    stringBuilder.append(this.field.getName());
    stringBuilder.append(" must be a primitive if set with throwIfNull");
    throw new SQLException(stringBuilder.toString());
  }
  
  public static FieldType createFieldType(ConnectionSource paramConnectionSource, String paramString, Field paramField, Class<?> paramClass) throws SQLException {
    DatabaseFieldConfig databaseFieldConfig = DatabaseFieldConfig.fromField(paramConnectionSource.getDatabaseType(), paramString, paramField);
    return (databaseFieldConfig == null) ? null : new FieldType(paramConnectionSource, paramString, paramField, databaseFieldConfig, paramClass);
  }
  
  private FieldType findForeignFieldType(Class<?> paramClass1, Class<?> paramClass2, BaseDaoImpl<?, ?> paramBaseDaoImpl) throws SQLException {
    String str = this.fieldConfig.getForeignCollectionForeignFieldName();
    for (FieldType fieldType : paramBaseDaoImpl.getTableInfo().getFieldTypes()) {
      if (fieldType.getType() == paramClass2 && (str == null || fieldType.getField().getName().equals(str))) {
        if (!fieldType.fieldConfig.isForeign()) {
          if (fieldType.fieldConfig.isForeignAutoRefresh())
            return fieldType; 
          StringBuilder stringBuilder1 = new StringBuilder();
          stringBuilder1.append("Foreign collection object ");
          stringBuilder1.append(paramClass1);
          stringBuilder1.append(" for field '");
          stringBuilder1.append(this.field.getName());
          stringBuilder1.append("' contains a field of class ");
          stringBuilder1.append(paramClass2);
          stringBuilder1.append(" but it's not foreign");
          throw new SQLException(stringBuilder1.toString());
        } 
        return fieldType;
      } 
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Foreign collection class ");
    stringBuilder.append(paramClass1.getName());
    stringBuilder.append(" for field '");
    stringBuilder.append(this.field.getName());
    stringBuilder.append("' column-name does not contain a foreign field");
    if (str != null) {
      stringBuilder.append(" named '");
      stringBuilder.append(str);
      stringBuilder.append('\'');
    } 
    stringBuilder.append(" of class ");
    stringBuilder.append(paramClass2.getName());
    throw new SQLException(stringBuilder.toString());
  }
  
  private boolean isFieldValueDefault(Object paramObject) {
    return (paramObject == null) ? true : paramObject.equals(getJavaDefaultValueDefault());
  }
  
  public void assignField(Object paramObject1, Object paramObject2, boolean paramBoolean, ObjectCache paramObjectCache) throws SQLException {
    Object object = paramObject2;
    if (this.foreignIdField != null) {
      object = paramObject2;
      if (paramObject2 != null) {
        object = extractJavaFieldValue(paramObject1);
        if (object != null && object.equals(paramObject2))
          return; 
        object = this.foreignDao.getObjectCache();
        if (object == null) {
          object = null;
        } else {
          object = object.get(getType(), paramObject2);
        } 
        if (object == null) {
          object = paramObject2;
          if (!paramBoolean) {
            LevelCounters levelCounters = threadLevelCounters.get();
            if (levelCounters.autoRefreshLevel == 0)
              levelCounters.autoRefreshLevelMax = this.fieldConfig.getMaxForeignAutoRefreshLevel(); 
            if (levelCounters.autoRefreshLevel >= levelCounters.autoRefreshLevelMax) {
              object = this.foreignTableInfo.createObject();
              this.foreignIdField.assignField(object, paramObject2, false, paramObjectCache);
            } else {
              if (this.mappedQueryForId == null)
                this.mappedQueryForId = MappedQueryForId.build(this.connectionSource.getDatabaseType(), this.foreignDao.getTableInfo(), this.foreignIdField); 
              levelCounters.autoRefreshLevel++;
              try {
              
              } finally {
                levelCounters.autoRefreshLevel--;
                if (levelCounters.autoRefreshLevel <= 0)
                  threadLevelCounters.remove(); 
              } 
            } 
          } 
        } 
      } 
    } 
    paramObject2 = this.fieldSetMethod;
    if (paramObject2 == null)
      try {
        this.field.set(paramObject1, object);
        return;
      } catch (IllegalArgumentException illegalArgumentException) {
        paramObject2 = new StringBuilder();
        paramObject2.append("Could not assign object '");
        paramObject2.append(object);
        paramObject2.append("' to field ");
        paramObject2.append(this);
        throw SqlExceptionUtil.create(paramObject2.toString(), illegalArgumentException);
      } catch (IllegalAccessException illegalAccessException) {
        paramObject2 = new StringBuilder();
        paramObject2.append("Could not assign object '");
        paramObject2.append(object);
        paramObject2.append("' to field ");
        paramObject2.append(this);
        throw SqlExceptionUtil.create(paramObject2.toString(), illegalAccessException);
      }  
    try {
      paramObject2.invoke(illegalAccessException, new Object[] { object });
      return;
    } catch (Exception exception) {
      paramObject2 = new StringBuilder();
      paramObject2.append("Could not call ");
      paramObject2.append(this.fieldSetMethod);
      paramObject2.append(" on object with '");
      paramObject2.append(object);
      paramObject2.append("' for ");
      paramObject2.append(this);
      throw SqlExceptionUtil.create(paramObject2.toString(), exception);
    } 
  }
  
  public Object assignIdValue(Object paramObject, Number paramNumber, ObjectCache paramObjectCache) throws SQLException {
    Object object = this.dataPersister.convertIdNumber(paramNumber);
    if (object != null) {
      assignField(paramObject, object, false, paramObjectCache);
      return object;
    } 
    paramObject = new StringBuilder();
    paramObject.append("Invalid class ");
    paramObject.append(this.dataPersister);
    paramObject.append(" for sequence-id ");
    paramObject.append(this);
    throw new SQLException(paramObject.toString());
  }
  
  public <FT, FID> BaseForeignCollection<FT, FID> buildForeignCollection(Object paramObject, FID paramFID) throws SQLException {
    if (this.foreignFieldType == null)
      return null; 
    BaseDaoImpl<?, ?> baseDaoImpl = this.foreignDao;
    if (!this.fieldConfig.isForeignCollectionEager())
      return (BaseForeignCollection<FT, FID>)new LazyForeignCollection((Dao)baseDaoImpl, paramObject, paramFID, this.foreignFieldType, this.fieldConfig.getForeignCollectionOrderColumnName(), this.fieldConfig.isForeignCollectionOrderAscending()); 
    LevelCounters levelCounters = threadLevelCounters.get();
    if (levelCounters.foreignCollectionLevel == 0)
      levelCounters.foreignCollectionLevelMax = this.fieldConfig.getForeignCollectionMaxEagerLevel(); 
    if (levelCounters.foreignCollectionLevel >= levelCounters.foreignCollectionLevelMax)
      return (BaseForeignCollection<FT, FID>)new LazyForeignCollection((Dao)baseDaoImpl, paramObject, paramFID, this.foreignFieldType, this.fieldConfig.getForeignCollectionOrderColumnName(), this.fieldConfig.isForeignCollectionOrderAscending()); 
    levelCounters.foreignCollectionLevel++;
    try {
      paramObject = new EagerForeignCollection((Dao)baseDaoImpl, paramObject, paramFID, this.foreignFieldType, this.fieldConfig.getForeignCollectionOrderColumnName(), this.fieldConfig.isForeignCollectionOrderAscending());
      return (BaseForeignCollection<FT, FID>)paramObject;
    } finally {
      levelCounters.foreignCollectionLevel--;
    } 
  }
  
  public void configDaoInformation(ConnectionSource paramConnectionSource, Class<?> paramClass) throws SQLException {
    StringBuilder stringBuilder;
    Class<?> clazz1;
    Class<?> clazz2;
    Class<?> clazz4;
    Class<?> clazz3 = this.field.getType();
    DatabaseType databaseType = paramConnectionSource.getDatabaseType();
    String str = this.fieldConfig.getForeignColumnName();
    boolean bool = this.fieldConfig.isForeignAutoRefresh();
    MappedQueryForId<Object, Object> mappedQueryForId = null;
    if (bool || str != null) {
      BaseDaoImpl baseDaoImpl;
      FieldType fieldType1;
      TableInfo tableInfo;
      DatabaseTableConfig<?> databaseTableConfig = this.fieldConfig.getForeignTableConfig();
      if (databaseTableConfig == null) {
        baseDaoImpl = (BaseDaoImpl)DaoManager.createDao(paramConnectionSource, clazz3);
        tableInfo = baseDaoImpl.getTableInfo();
      } else {
        databaseTableConfig.extractFieldTypes((ConnectionSource)baseDaoImpl);
        baseDaoImpl = (BaseDaoImpl)DaoManager.createDao((ConnectionSource)baseDaoImpl, databaseTableConfig);
        tableInfo = baseDaoImpl.getTableInfo();
      } 
      if (str == null) {
        fieldType1 = tableInfo.getIdField();
        if (fieldType1 == null) {
          stringBuilder = new StringBuilder();
          stringBuilder.append("Foreign field ");
          stringBuilder.append(clazz3);
          stringBuilder.append(" does not have id field");
          throw new IllegalArgumentException(stringBuilder.toString());
        } 
      } else {
        fieldType1 = tableInfo.getFieldTypeByColumnName(str);
        if (fieldType1 == null) {
          stringBuilder = new StringBuilder();
          stringBuilder.append("Foreign field ");
          stringBuilder.append(clazz3);
          stringBuilder.append(" does not have field named '");
          stringBuilder.append(str);
          stringBuilder.append("'");
          throw new IllegalArgumentException(stringBuilder.toString());
        } 
      } 
      mappedQueryForId = MappedQueryForId.build(databaseType, tableInfo, fieldType1);
      clazz3 = null;
    } else {
      FieldType fieldType1;
      if (this.fieldConfig.isForeign()) {
        DataPersister dataPersister = this.dataPersister;
        if (dataPersister == null || !dataPersister.isPrimitive()) {
          BaseDaoImpl baseDaoImpl;
          DatabaseTableConfig<?> databaseTableConfig = this.fieldConfig.getForeignTableConfig();
          if (databaseTableConfig != null) {
            databaseTableConfig.extractFieldTypes((ConnectionSource)stringBuilder);
            baseDaoImpl = (BaseDaoImpl)DaoManager.createDao((ConnectionSource)stringBuilder, databaseTableConfig);
          } else {
            baseDaoImpl = (BaseDaoImpl)DaoManager.createDao((ConnectionSource)baseDaoImpl, clazz3);
          } 
          TableInfo tableInfo = baseDaoImpl.getTableInfo();
          fieldType1 = tableInfo.getIdField();
          if (fieldType1 != null) {
            if (!isForeignAutoCreate() || fieldType1.isGeneratedId()) {
              clazz3 = null;
            } else {
              StringBuilder stringBuilder1 = new StringBuilder();
              stringBuilder1.append("Field ");
              stringBuilder1.append(this.field.getName());
              stringBuilder1.append(", if foreignAutoCreate = true then class ");
              stringBuilder1.append(clazz3.getSimpleName());
              stringBuilder1.append(" must have id field with generatedId = true");
              throw new IllegalArgumentException(stringBuilder1.toString());
            } 
          } else {
            StringBuilder stringBuilder1 = new StringBuilder();
            stringBuilder1.append("Foreign field ");
            stringBuilder1.append(clazz3);
            stringBuilder1.append(" does not have id field");
            throw new IllegalArgumentException(stringBuilder1.toString());
          } 
        } else {
          stringBuilder = new StringBuilder();
          stringBuilder.append("Field ");
          stringBuilder.append(this);
          stringBuilder.append(" is a primitive class ");
          stringBuilder.append(clazz3);
          stringBuilder.append(" but marked as foreign");
          throw new IllegalArgumentException(stringBuilder.toString());
        } 
      } else if (this.fieldConfig.isForeignCollection()) {
        if (clazz3 == Collection.class || ForeignCollection.class.isAssignableFrom(clazz3)) {
          Type type = this.field.getGenericType();
          if (type instanceof ParameterizedType) {
            Type[] arrayOfType = ((ParameterizedType)type).getActualTypeArguments();
            if (arrayOfType.length != 0) {
              FieldType fieldType2;
              if (arrayOfType[0] instanceof Class) {
                BaseDaoImpl<?, ?> baseDaoImpl;
                Class<?> clazz = (Class)arrayOfType[0];
                DatabaseTableConfig<?> databaseTableConfig2 = this.fieldConfig.getForeignTableConfig();
                if (databaseTableConfig2 == null) {
                  baseDaoImpl = (BaseDaoImpl)DaoManager.createDao((ConnectionSource)stringBuilder, clazz);
                } else {
                  baseDaoImpl = (BaseDaoImpl)DaoManager.createDao((ConnectionSource)baseDaoImpl, databaseTableConfig2);
                } 
                fieldType2 = findForeignFieldType(clazz, (Class<?>)fieldType1, baseDaoImpl);
                databaseTableConfig2 = null;
                DatabaseTableConfig<?> databaseTableConfig1 = databaseTableConfig2;
              } else {
                stringBuilder = new StringBuilder();
                stringBuilder.append("Field class for '");
                stringBuilder.append(this.field.getName());
                stringBuilder.append("' must be a parameterized Collection whose generic argument is an entity class not: ");
                stringBuilder.append(fieldType2[0]);
                throw new SQLException(stringBuilder.toString());
              } 
            } else {
              stringBuilder = new StringBuilder();
              stringBuilder.append("Field class for '");
              stringBuilder.append(this.field.getName());
              stringBuilder.append("' must be a parameterized Collection with at least 1 type.");
              throw new SQLException(stringBuilder.toString());
            } 
          } else {
            stringBuilder = new StringBuilder();
            stringBuilder.append("Field class for '");
            stringBuilder.append(this.field.getName());
            stringBuilder.append("' must be a parameterized Collection.");
            throw new SQLException(stringBuilder.toString());
          } 
        } else {
          stringBuilder = new StringBuilder();
          stringBuilder.append("Field class for '");
          stringBuilder.append(this.field.getName());
          stringBuilder.append("' must be of class ");
          stringBuilder.append(ForeignCollection.class.getSimpleName());
          stringBuilder.append(" or Collection.");
          throw new SQLException(stringBuilder.toString());
        } 
      } else {
        clazz3 = null;
        clazz4 = clazz3;
        clazz1 = clazz4;
        clazz2 = clazz1;
      } 
    } 
    this.mappedQueryForId = mappedQueryForId;
    this.foreignTableInfo = (TableInfo)clazz4;
    this.foreignFieldType = (FieldType)clazz3;
    this.foreignDao = (BaseDaoImpl)clazz1;
    this.foreignIdField = (FieldType)clazz2;
    FieldType fieldType = this.foreignIdField;
    if (fieldType != null)
      assignDataType(databaseType, fieldType.getDataPersister()); 
  }
  
  public Object convertJavaFieldToSqlArgValue(Object paramObject) throws SQLException {
    return (paramObject == null) ? null : this.fieldConverter.javaToSqlArg(this, paramObject);
  }
  
  public Object convertStringToJavaField(String paramString, int paramInt) throws SQLException {
    return (paramString == null) ? null : this.fieldConverter.resultStringToJava(this, paramString, paramInt);
  }
  
  public <T> int createWithForeignDao(T paramT) throws SQLException {
    return this.foreignDao.create(paramT);
  }
  
  public boolean equals(Object<?> paramObject) {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramObject != null) {
      if (paramObject.getClass() != getClass())
        return false; 
      FieldType fieldType = (FieldType)paramObject;
      bool1 = bool2;
      if (this.field.equals(fieldType.field)) {
        paramObject = (Object<?>)this.parentClass;
        Class<?> clazz = fieldType.parentClass;
        if (paramObject == null) {
          bool1 = bool2;
          if (clazz == null)
            return true; 
        } else {
          bool1 = bool2;
          if (paramObject.equals(clazz))
            return true; 
        } 
      } 
    } 
    return bool1;
  }
  
  public Object extractJavaFieldToSqlArgValue(Object paramObject) throws SQLException {
    return convertJavaFieldToSqlArgValue(extractJavaFieldValue(paramObject));
  }
  
  public Object extractJavaFieldValue(Object paramObject) throws SQLException {
    Object object = extractRawJavaFieldValue(paramObject);
    FieldType fieldType = this.foreignIdField;
    paramObject = object;
    if (fieldType != null) {
      paramObject = object;
      if (object != null)
        paramObject = fieldType.extractRawJavaFieldValue(object); 
    } 
    return paramObject;
  }
  
  public <FV> FV extractRawJavaFieldValue(Object paramObject) throws SQLException {
    StringBuilder stringBuilder;
    Method method = this.fieldGetMethod;
    if (method == null)
      try {
        return (FV)this.field.get(paramObject);
      } catch (Exception exception) {
        stringBuilder = new StringBuilder();
        stringBuilder.append("Could not get field value for ");
        stringBuilder.append(this);
        throw SqlExceptionUtil.create(stringBuilder.toString(), exception);
      }  
    try {
      return (FV)stringBuilder.invoke(exception, new Object[0]);
    } catch (Exception exception1) {
      stringBuilder = new StringBuilder();
      stringBuilder.append("Could not call ");
      stringBuilder.append(this.fieldGetMethod);
      stringBuilder.append(" for ");
      stringBuilder.append(this);
      throw SqlExceptionUtil.create(stringBuilder.toString(), exception1);
    } 
  }
  
  public Object generateId() {
    return this.dataPersister.generateId();
  }
  
  public String getColumnDefinition() {
    return this.fieldConfig.getColumnDefinition();
  }
  
  public String getColumnName() {
    return this.columnName;
  }
  
  public DataPersister getDataPersister() {
    return this.dataPersister;
  }
  
  public Object getDataTypeConfigObj() {
    return this.dataTypeConfigObj;
  }
  
  public Object getDefaultValue() {
    return this.defaultValue;
  }
  
  public Field getField() {
    return this.field;
  }
  
  public String getFieldName() {
    return this.field.getName();
  }
  
  public <FV> FV getFieldValueIfNotDefault(Object paramObject) throws SQLException {
    Object object = extractJavaFieldValue(paramObject);
    paramObject = object;
    if (isFieldValueDefault(object))
      paramObject = null; 
    return (FV)paramObject;
  }
  
  public FieldType getForeignIdField() {
    return this.foreignIdField;
  }
  
  public String getFormat() {
    return this.fieldConfig.getFormat();
  }
  
  public String getGeneratedIdSequence() {
    return this.generatedIdSequence;
  }
  
  public String getIndexName() {
    return this.fieldConfig.getIndexName(this.tableName);
  }
  
  public Object getJavaDefaultValueDefault() {
    return (this.field.getType() == boolean.class) ? Boolean.valueOf(DEFAULT_VALUE_BOOLEAN) : ((this.field.getType() == byte.class || this.field.getType() == Byte.class) ? Byte.valueOf(DEFAULT_VALUE_BYTE) : ((this.field.getType() == char.class || this.field.getType() == Character.class) ? Character.valueOf(DEFAULT_VALUE_CHAR) : ((this.field.getType() == short.class || this.field.getType() == Short.class) ? Short.valueOf(DEFAULT_VALUE_SHORT) : ((this.field.getType() == int.class || this.field.getType() == Integer.class) ? Integer.valueOf(DEFAULT_VALUE_INT) : ((this.field.getType() == long.class || this.field.getType() == Long.class) ? Long.valueOf(DEFAULT_VALUE_LONG) : ((this.field.getType() == float.class || this.field.getType() == Float.class) ? Float.valueOf(DEFAULT_VALUE_FLOAT) : ((this.field.getType() == double.class || this.field.getType() == Double.class) ? Double.valueOf(DEFAULT_VALUE_DOUBLE) : null)))))));
  }
  
  public SqlType getSqlType() {
    return this.fieldConverter.getSqlType();
  }
  
  public String getTableName() {
    return this.tableName;
  }
  
  public Class<?> getType() {
    return this.field.getType();
  }
  
  public String getUniqueIndexName() {
    return this.fieldConfig.getUniqueIndexName(this.tableName);
  }
  
  public Enum<?> getUnknownEnumVal() {
    return this.fieldConfig.getUnknownEnumValue();
  }
  
  public int getWidth() {
    return this.fieldConfig.getWidth();
  }
  
  public int hashCode() {
    return this.field.hashCode();
  }
  
  public boolean isAllowGeneratedIdInsert() {
    return this.fieldConfig.isAllowGeneratedIdInsert();
  }
  
  public boolean isArgumentHolderRequired() {
    return this.dataPersister.isArgumentHolderRequired();
  }
  
  public boolean isCanBeNull() {
    return this.fieldConfig.isCanBeNull();
  }
  
  public boolean isComparable() throws SQLException {
    if (this.fieldConfig.isForeignCollection())
      return false; 
    DataPersister dataPersister = this.dataPersister;
    if (dataPersister != null)
      return dataPersister.isComparable(); 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Internal error.  Data-persister is not configured for field.  Please post _full_ exception with associated data objects to mailing list: ");
    stringBuilder.append(this);
    throw new SQLException(stringBuilder.toString());
  }
  
  public boolean isEscapedDefaultValue() {
    return this.dataPersister.isEscapedDefaultValue();
  }
  
  public boolean isEscapedValue() {
    return this.dataPersister.isEscapedValue();
  }
  
  public boolean isForeign() {
    return this.fieldConfig.isForeign();
  }
  
  public boolean isForeignAutoCreate() {
    return this.fieldConfig.isForeignAutoCreate();
  }
  
  public boolean isForeignCollection() {
    return this.fieldConfig.isForeignCollection();
  }
  
  public boolean isGeneratedId() {
    return this.isGeneratedId;
  }
  
  public boolean isGeneratedIdSequence() {
    return (this.generatedIdSequence != null);
  }
  
  public boolean isId() {
    return this.isId;
  }
  
  public boolean isObjectsFieldValueDefault(Object paramObject) throws SQLException {
    return isFieldValueDefault(extractJavaFieldValue(paramObject));
  }
  
  public boolean isReadOnly() {
    return this.fieldConfig.isReadOnly();
  }
  
  public boolean isSelfGeneratedId() {
    return this.dataPersister.isSelfGeneratedId();
  }
  
  public boolean isUnique() {
    return this.fieldConfig.isUnique();
  }
  
  public boolean isUniqueCombo() {
    return this.fieldConfig.isUniqueCombo();
  }
  
  public boolean isVersion() {
    return this.fieldConfig.isVersion();
  }
  
  public Object moveToNextValue(Object paramObject) {
    DataPersister dataPersister = this.dataPersister;
    return (dataPersister == null) ? null : dataPersister.moveToNextValue(paramObject);
  }
  
  public <T> T resultToJava(DatabaseResults paramDatabaseResults, Map<String, Integer> paramMap) throws SQLException {
    Integer integer2 = paramMap.get(this.columnName);
    Integer integer1 = integer2;
    if (integer2 == null) {
      integer1 = Integer.valueOf(paramDatabaseResults.findColumn(this.columnName));
      paramMap.put(this.columnName, integer1);
    } 
    Object object = this.fieldConverter.resultToJava(this, paramDatabaseResults, integer1.intValue());
    if (this.fieldConfig.isForeign()) {
      if (paramDatabaseResults.wasNull(integer1.intValue()))
        return null; 
    } else {
      StringBuilder stringBuilder;
      if (this.dataPersister.isPrimitive()) {
        if (this.fieldConfig.isThrowIfNull()) {
          if (!paramDatabaseResults.wasNull(integer1.intValue()))
            return (T)object; 
          stringBuilder = new StringBuilder();
          stringBuilder.append("Results value for primitive field '");
          stringBuilder.append(this.field.getName());
          stringBuilder.append("' was an invalid null value");
          throw new SQLException(stringBuilder.toString());
        } 
      } else if (!this.fieldConverter.isStreamType() && stringBuilder.wasNull(integer1.intValue())) {
        return null;
      } 
    } 
    return (T)object;
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(getClass().getSimpleName());
    stringBuilder.append(":name=");
    stringBuilder.append(this.field.getName());
    stringBuilder.append(",class=");
    stringBuilder.append(this.field.getDeclaringClass().getSimpleName());
    return stringBuilder.toString();
  }
  
  static class LevelCounters {
    int autoRefreshLevel;
    
    int autoRefreshLevelMax;
    
    int foreignCollectionLevel;
    
    int foreignCollectionLevelMax;
    
    private LevelCounters() {}
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\j256\ormlite\field\FieldType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */