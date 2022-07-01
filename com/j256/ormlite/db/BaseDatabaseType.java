package com.j256.ormlite.db;

import com.j256.ormlite.field.BaseFieldConverter;
import com.j256.ormlite.field.DataPersister;
import com.j256.ormlite.field.FieldConverter;
import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.field.SqlType;
import com.j256.ormlite.misc.SqlExceptionUtil;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.support.DatabaseResults;
import com.j256.ormlite.table.DatabaseTableConfig;
import java.sql.Driver;
import java.sql.SQLException;
import java.util.List;

public abstract class BaseDatabaseType implements DatabaseType {
  protected static String DEFAULT_SEQUENCE_SUFFIX = "_id_seq";
  
  protected Driver driver;
  
  private void addSingleUnique(StringBuilder paramStringBuilder, FieldType paramFieldType, List<String> paramList1, List<String> paramList2) {
    paramStringBuilder = new StringBuilder();
    paramStringBuilder.append(" UNIQUE (");
    appendEscapedEntityName(paramStringBuilder, paramFieldType.getColumnName());
    paramStringBuilder.append(")");
    paramList1.add(paramStringBuilder.toString());
  }
  
  private void appendCanBeNull(StringBuilder paramStringBuilder, FieldType paramFieldType) {}
  
  private void appendDefaultValue(StringBuilder paramStringBuilder, FieldType paramFieldType, Object paramObject) {
    if (paramFieldType.isEscapedDefaultValue()) {
      appendEscapedWord(paramStringBuilder, paramObject.toString());
      return;
    } 
    paramStringBuilder.append(paramObject);
  }
  
  private void appendDoubleType(StringBuilder paramStringBuilder, FieldType paramFieldType, int paramInt) {
    paramStringBuilder.append("DOUBLE PRECISION");
  }
  
  private void appendFloatType(StringBuilder paramStringBuilder, FieldType paramFieldType, int paramInt) {
    paramStringBuilder.append("FLOAT");
  }
  
  private void appendIntegerType(StringBuilder paramStringBuilder, FieldType paramFieldType, int paramInt) {
    paramStringBuilder.append("INTEGER");
  }
  
  public void addPrimaryKeySql(FieldType[] paramArrayOfFieldType, List<String> paramList1, List<String> paramList2, List<String> paramList3, List<String> paramList4) {
    StringBuilder stringBuilder;
    int j = paramArrayOfFieldType.length;
    paramList2 = null;
    int i = 0;
    while (i < j) {
      StringBuilder stringBuilder1;
      FieldType fieldType = paramArrayOfFieldType[i];
      if (fieldType.isGeneratedId() && !generatedIdSqlAtEnd() && !fieldType.isSelfGeneratedId()) {
        paramList3 = paramList2;
      } else {
        paramList3 = paramList2;
        if (fieldType.isId()) {
          StringBuilder stringBuilder2;
          if (paramList2 == null) {
            stringBuilder2 = new StringBuilder(48);
            stringBuilder2.append("PRIMARY KEY (");
          } else {
            stringBuilder2.append(',');
          } 
          appendEscapedEntityName(stringBuilder2, fieldType.getColumnName());
          stringBuilder1 = stringBuilder2;
        } 
      } 
      i++;
      stringBuilder = stringBuilder1;
    } 
    if (stringBuilder != null) {
      stringBuilder.append(") ");
      paramList1.add(stringBuilder.toString());
    } 
  }
  
  public void addUniqueComboSql(FieldType[] paramArrayOfFieldType, List<String> paramList1, List<String> paramList2, List<String> paramList3, List<String> paramList4) {
    StringBuilder stringBuilder;
    int j = paramArrayOfFieldType.length;
    paramList2 = null;
    int i = 0;
    while (i < j) {
      StringBuilder stringBuilder1;
      FieldType fieldType = paramArrayOfFieldType[i];
      paramList3 = paramList2;
      if (fieldType.isUniqueCombo()) {
        StringBuilder stringBuilder2;
        if (paramList2 == null) {
          stringBuilder2 = new StringBuilder(48);
          stringBuilder2.append("UNIQUE (");
        } else {
          stringBuilder2.append(',');
        } 
        appendEscapedEntityName(stringBuilder2, fieldType.getColumnName());
        stringBuilder1 = stringBuilder2;
      } 
      i++;
      stringBuilder = stringBuilder1;
    } 
    if (stringBuilder != null) {
      stringBuilder.append(") ");
      paramList1.add(stringBuilder.toString());
    } 
  }
  
  protected void appendBigDecimalNumericType(StringBuilder paramStringBuilder, FieldType paramFieldType, int paramInt) {
    paramStringBuilder.append("NUMERIC");
  }
  
  protected void appendBooleanType(StringBuilder paramStringBuilder, FieldType paramFieldType, int paramInt) {
    paramStringBuilder.append("BOOLEAN");
  }
  
  protected void appendByteArrayType(StringBuilder paramStringBuilder, FieldType paramFieldType, int paramInt) {
    paramStringBuilder.append("BLOB");
  }
  
  protected void appendByteType(StringBuilder paramStringBuilder, FieldType paramFieldType, int paramInt) {
    paramStringBuilder.append("TINYINT");
  }
  
  protected void appendCharType(StringBuilder paramStringBuilder, FieldType paramFieldType, int paramInt) {
    paramStringBuilder.append("CHAR");
  }
  
  public void appendColumnArg(String paramString, StringBuilder paramStringBuilder, FieldType paramFieldType, List<String> paramList1, List<String> paramList2, List<String> paramList3, List<String> paramList4) throws SQLException {
    StringBuilder stringBuilder;
    appendEscapedEntityName(paramStringBuilder, paramFieldType.getColumnName());
    paramStringBuilder.append(' ');
    DataPersister dataPersister = paramFieldType.getDataPersister();
    int j = paramFieldType.getWidth();
    int i = j;
    if (j == 0)
      i = dataPersister.getDefaultWidth(); 
    switch (dataPersister.getSqlType()) {
      default:
        stringBuilder = new StringBuilder();
        stringBuilder.append("Unknown SQL-type ");
        stringBuilder.append(dataPersister.getSqlType());
        throw new IllegalArgumentException(stringBuilder.toString());
      case BIG_DECIMAL:
        appendBigDecimalNumericType(paramStringBuilder, paramFieldType, i);
        break;
      case SERIALIZABLE:
        appendSerializableType(paramStringBuilder, paramFieldType, i);
        break;
      case DOUBLE:
        appendDoubleType(paramStringBuilder, paramFieldType, i);
        break;
      case FLOAT:
        appendFloatType(paramStringBuilder, paramFieldType, i);
        break;
      case LONG:
        appendLongType(paramStringBuilder, paramFieldType, i);
        break;
      case INTEGER:
        appendIntegerType(paramStringBuilder, paramFieldType, i);
        break;
      case SHORT:
        appendShortType(paramStringBuilder, paramFieldType, i);
        break;
      case BYTE_ARRAY:
        appendByteArrayType(paramStringBuilder, paramFieldType, i);
        break;
      case BYTE:
        appendByteType(paramStringBuilder, paramFieldType, i);
        break;
      case CHAR:
        appendCharType(paramStringBuilder, paramFieldType, i);
        break;
      case DATE:
        appendDateType(paramStringBuilder, paramFieldType, i);
        break;
      case BOOLEAN:
        appendBooleanType(paramStringBuilder, paramFieldType, i);
        break;
      case LONG_STRING:
        appendLongStringType(paramStringBuilder, paramFieldType, i);
        break;
      case STRING:
        appendStringType(paramStringBuilder, paramFieldType, i);
        break;
    } 
    paramStringBuilder.append(' ');
    if (paramFieldType.isGeneratedIdSequence() && !paramFieldType.isSelfGeneratedId()) {
      configureGeneratedIdSequence(paramStringBuilder, paramFieldType, paramList2, paramList1, paramList4);
    } else if (paramFieldType.isGeneratedId() && !paramFieldType.isSelfGeneratedId()) {
      configureGeneratedId((String)stringBuilder, paramStringBuilder, paramFieldType, paramList2, paramList3, paramList1, paramList4);
    } else if (paramFieldType.isId()) {
      configureId(paramStringBuilder, paramFieldType, paramList2, paramList1, paramList4);
    } 
    if (!paramFieldType.isGeneratedId()) {
      Object object = paramFieldType.getDefaultValue();
      if (object != null) {
        paramStringBuilder.append("DEFAULT ");
        appendDefaultValue(paramStringBuilder, paramFieldType, object);
        paramStringBuilder.append(' ');
      } 
      if (paramFieldType.isCanBeNull()) {
        appendCanBeNull(paramStringBuilder, paramFieldType);
      } else {
        paramStringBuilder.append("NOT NULL ");
      } 
      if (paramFieldType.isUnique())
        addSingleUnique(paramStringBuilder, paramFieldType, paramList1, paramList3); 
    } 
  }
  
  public void appendCreateTableSuffix(StringBuilder paramStringBuilder) {}
  
  protected void appendDateType(StringBuilder paramStringBuilder, FieldType paramFieldType, int paramInt) {
    paramStringBuilder.append("TIMESTAMP");
  }
  
  public void appendEscapedEntityName(StringBuilder paramStringBuilder, String paramString) {
    paramStringBuilder.append('`');
    paramStringBuilder.append(paramString);
    paramStringBuilder.append('`');
  }
  
  public void appendEscapedWord(StringBuilder paramStringBuilder, String paramString) {
    paramStringBuilder.append('\'');
    paramStringBuilder.append(paramString);
    paramStringBuilder.append('\'');
  }
  
  public void appendInsertNoColumns(StringBuilder paramStringBuilder) {
    paramStringBuilder.append("() VALUES ()");
  }
  
  public void appendLimitValue(StringBuilder paramStringBuilder, long paramLong, Long paramLong1) {
    paramStringBuilder.append("LIMIT ");
    paramStringBuilder.append(paramLong);
    paramStringBuilder.append(' ');
  }
  
  protected void appendLongStringType(StringBuilder paramStringBuilder, FieldType paramFieldType, int paramInt) {
    paramStringBuilder.append("TEXT");
  }
  
  protected void appendLongType(StringBuilder paramStringBuilder, FieldType paramFieldType, int paramInt) {
    paramStringBuilder.append("BIGINT");
  }
  
  public void appendOffsetValue(StringBuilder paramStringBuilder, long paramLong) {
    paramStringBuilder.append("OFFSET ");
    paramStringBuilder.append(paramLong);
    paramStringBuilder.append(' ');
  }
  
  public void appendSelectNextValFromSequence(StringBuilder paramStringBuilder, String paramString) {}
  
  protected void appendSerializableType(StringBuilder paramStringBuilder, FieldType paramFieldType, int paramInt) {
    paramStringBuilder.append("BLOB");
  }
  
  protected void appendShortType(StringBuilder paramStringBuilder, FieldType paramFieldType, int paramInt) {
    paramStringBuilder.append("SMALLINT");
  }
  
  protected void appendStringType(StringBuilder paramStringBuilder, FieldType paramFieldType, int paramInt) {
    if (isVarcharFieldWidthSupported()) {
      paramStringBuilder.append("VARCHAR(");
      paramStringBuilder.append(paramInt);
      paramStringBuilder.append(")");
      return;
    } 
    paramStringBuilder.append("VARCHAR");
  }
  
  protected void configureGeneratedId(String paramString, StringBuilder paramStringBuilder, FieldType paramFieldType, List<String> paramList1, List<String> paramList2, List<String> paramList3, List<String> paramList4) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("GeneratedId is not supported by database ");
    stringBuilder.append(getDatabaseName());
    stringBuilder.append(" for field ");
    stringBuilder.append(paramFieldType);
    throw new IllegalStateException(stringBuilder.toString());
  }
  
  protected void configureGeneratedIdSequence(StringBuilder paramStringBuilder, FieldType paramFieldType, List<String> paramList1, List<String> paramList2, List<String> paramList3) throws SQLException {
    paramStringBuilder = new StringBuilder();
    paramStringBuilder.append("GeneratedIdSequence is not supported by database ");
    paramStringBuilder.append(getDatabaseName());
    paramStringBuilder.append(" for field ");
    paramStringBuilder.append(paramFieldType);
    throw new SQLException(paramStringBuilder.toString());
  }
  
  protected void configureId(StringBuilder paramStringBuilder, FieldType paramFieldType, List<String> paramList1, List<String> paramList2, List<String> paramList3) {}
  
  public void dropColumnArg(FieldType paramFieldType, List<String> paramList1, List<String> paramList2) {}
  
  public <T> DatabaseTableConfig<T> extractDatabaseTableConfig(ConnectionSource paramConnectionSource, Class<T> paramClass) throws SQLException {
    return null;
  }
  
  public String generateIdSequenceName(String paramString, FieldType paramFieldType) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramString);
    stringBuilder.append(DEFAULT_SEQUENCE_SUFFIX);
    String str = stringBuilder.toString();
    paramString = str;
    if (isEntityNamesMustBeUpCase())
      paramString = str.toUpperCase(); 
    return paramString;
  }
  
  protected boolean generatedIdSqlAtEnd() {
    return true;
  }
  
  public String getCommentLinePrefix() {
    return "-- ";
  }
  
  protected abstract String getDriverClassName();
  
  public FieldConverter getFieldConverter(DataPersister paramDataPersister) {
    return (FieldConverter)paramDataPersister;
  }
  
  public String getPingStatement() {
    return "SELECT 1";
  }
  
  public boolean isAllowGeneratedIdInsertSupported() {
    return true;
  }
  
  public boolean isBatchUseTransaction() {
    return false;
  }
  
  public boolean isCreateIfNotExistsSupported() {
    return false;
  }
  
  public boolean isCreateIndexIfNotExistsSupported() {
    return isCreateIfNotExistsSupported();
  }
  
  public boolean isCreateTableReturnsNegative() {
    return false;
  }
  
  public boolean isCreateTableReturnsZero() {
    return true;
  }
  
  public boolean isEntityNamesMustBeUpCase() {
    return false;
  }
  
  public boolean isIdSequenceNeeded() {
    return false;
  }
  
  public boolean isLimitAfterSelect() {
    return false;
  }
  
  public boolean isLimitSqlSupported() {
    return true;
  }
  
  public boolean isNestedSavePointsSupported() {
    return true;
  }
  
  public boolean isOffsetLimitArgument() {
    return false;
  }
  
  public boolean isOffsetSqlSupported() {
    return true;
  }
  
  public boolean isSelectSequenceBeforeInsert() {
    return false;
  }
  
  public boolean isTruncateSupported() {
    return false;
  }
  
  public boolean isVarcharFieldWidthSupported() {
    return true;
  }
  
  public void loadDriver() throws SQLException {
    String str = getDriverClassName();
    if (str != null)
      try {
        Class.forName(str);
        return;
      } catch (ClassNotFoundException classNotFoundException) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Driver class was not found for ");
        stringBuilder.append(getDatabaseName());
        stringBuilder.append(" database.  Missing jar with class ");
        stringBuilder.append(str);
        stringBuilder.append(".");
        throw SqlExceptionUtil.create(stringBuilder.toString(), classNotFoundException);
      }  
  }
  
  public void setDriver(Driver paramDriver) {
    this.driver = paramDriver;
  }
  
  public static class BooleanNumberFieldConverter extends BaseFieldConverter {
    public SqlType getSqlType() {
      return SqlType.BOOLEAN;
    }
    
    public Object javaToSqlArg(FieldType param1FieldType, Object param1Object) {
      boolean bool;
      if (((Boolean)param1Object).booleanValue()) {
        bool = true;
      } else {
        bool = false;
      } 
      return Byte.valueOf(bool);
    }
    
    public Object parseDefaultString(FieldType param1FieldType, String param1String) {
      boolean bool;
      if (Boolean.parseBoolean(param1String)) {
        bool = true;
      } else {
        bool = false;
      } 
      return Byte.valueOf(bool);
    }
    
    public Object resultStringToJava(FieldType param1FieldType, String param1String, int param1Int) {
      return sqlArgToJava(param1FieldType, Byte.valueOf(Byte.parseByte(param1String)), param1Int);
    }
    
    public Object resultToSqlArg(FieldType param1FieldType, DatabaseResults param1DatabaseResults, int param1Int) throws SQLException {
      return Byte.valueOf(param1DatabaseResults.getByte(param1Int));
    }
    
    public Object sqlArgToJava(FieldType param1FieldType, Object param1Object, int param1Int) {
      return (((Byte)param1Object).byteValue() == 1) ? Boolean.valueOf(true) : Boolean.valueOf(false);
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\j256\ormlite\db\BaseDatabaseType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */