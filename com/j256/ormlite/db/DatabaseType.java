package com.j256.ormlite.db;

import com.j256.ormlite.field.DataPersister;
import com.j256.ormlite.field.FieldConverter;
import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.DatabaseTableConfig;
import java.sql.Driver;
import java.sql.SQLException;
import java.util.List;

public interface DatabaseType {
  void addPrimaryKeySql(FieldType[] paramArrayOfFieldType, List<String> paramList1, List<String> paramList2, List<String> paramList3, List<String> paramList4) throws SQLException;
  
  void addUniqueComboSql(FieldType[] paramArrayOfFieldType, List<String> paramList1, List<String> paramList2, List<String> paramList3, List<String> paramList4) throws SQLException;
  
  void appendColumnArg(String paramString, StringBuilder paramStringBuilder, FieldType paramFieldType, List<String> paramList1, List<String> paramList2, List<String> paramList3, List<String> paramList4) throws SQLException;
  
  void appendCreateTableSuffix(StringBuilder paramStringBuilder);
  
  void appendEscapedEntityName(StringBuilder paramStringBuilder, String paramString);
  
  void appendEscapedWord(StringBuilder paramStringBuilder, String paramString);
  
  void appendInsertNoColumns(StringBuilder paramStringBuilder);
  
  void appendLimitValue(StringBuilder paramStringBuilder, long paramLong, Long paramLong1);
  
  void appendOffsetValue(StringBuilder paramStringBuilder, long paramLong);
  
  void appendSelectNextValFromSequence(StringBuilder paramStringBuilder, String paramString);
  
  void dropColumnArg(FieldType paramFieldType, List<String> paramList1, List<String> paramList2);
  
  <T> DatabaseTableConfig<T> extractDatabaseTableConfig(ConnectionSource paramConnectionSource, Class<T> paramClass) throws SQLException;
  
  String generateIdSequenceName(String paramString, FieldType paramFieldType);
  
  String getCommentLinePrefix();
  
  String getDatabaseName();
  
  FieldConverter getFieldConverter(DataPersister paramDataPersister);
  
  String getPingStatement();
  
  boolean isAllowGeneratedIdInsertSupported();
  
  boolean isBatchUseTransaction();
  
  boolean isCreateIfNotExistsSupported();
  
  boolean isCreateIndexIfNotExistsSupported();
  
  boolean isCreateTableReturnsNegative();
  
  boolean isCreateTableReturnsZero();
  
  boolean isDatabaseUrlThisType(String paramString1, String paramString2);
  
  boolean isEntityNamesMustBeUpCase();
  
  boolean isIdSequenceNeeded();
  
  boolean isLimitAfterSelect();
  
  boolean isLimitSqlSupported();
  
  boolean isNestedSavePointsSupported();
  
  boolean isOffsetLimitArgument();
  
  boolean isOffsetSqlSupported();
  
  boolean isSelectSequenceBeforeInsert();
  
  boolean isTruncateSupported();
  
  boolean isVarcharFieldWidthSupported();
  
  void loadDriver() throws SQLException;
  
  void setDriver(Driver paramDriver);
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\j256\ormlite\db\DatabaseType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */