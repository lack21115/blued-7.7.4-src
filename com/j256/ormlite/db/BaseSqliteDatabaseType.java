package com.j256.ormlite.db;

import com.j256.ormlite.field.DataPersister;
import com.j256.ormlite.field.FieldConverter;
import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.field.SqlType;
import com.j256.ormlite.field.types.BigDecimalStringType;
import java.util.List;

public abstract class BaseSqliteDatabaseType extends BaseDatabaseType {
  private static final FieldConverter booleanConverter = (FieldConverter)new BaseDatabaseType.BooleanNumberFieldConverter();
  
  public void appendInsertNoColumns(StringBuilder paramStringBuilder) {
    paramStringBuilder.append("DEFAULT VALUES");
  }
  
  protected void appendLongType(StringBuilder paramStringBuilder, FieldType paramFieldType, int paramInt) {
    if (paramFieldType.getSqlType() == SqlType.LONG && paramFieldType.isGeneratedId()) {
      paramStringBuilder.append("INTEGER");
      return;
    } 
    paramStringBuilder.append("BIGINT");
  }
  
  protected void configureGeneratedId(String paramString, StringBuilder paramStringBuilder, FieldType paramFieldType, List<String> paramList1, List<String> paramList2, List<String> paramList3, List<String> paramList4) {
    if (paramFieldType.getSqlType() == SqlType.INTEGER || paramFieldType.getSqlType() == SqlType.LONG) {
      paramStringBuilder.append("PRIMARY KEY AUTOINCREMENT ");
      return;
    } 
    throw new IllegalArgumentException("Sqlite requires that auto-increment generated-id be integer or long type");
  }
  
  protected boolean generatedIdSqlAtEnd() {
    return false;
  }
  
  public FieldConverter getFieldConverter(DataPersister paramDataPersister) {
    int i = null.$SwitchMap$com$j256$ormlite$field$SqlType[paramDataPersister.getSqlType().ordinal()];
    return (FieldConverter)((i != 1) ? ((i != 2) ? super.getFieldConverter(paramDataPersister) : BigDecimalStringType.getSingleton()) : booleanConverter);
  }
  
  public boolean isCreateIfNotExistsSupported() {
    return true;
  }
  
  public boolean isCreateTableReturnsZero() {
    return false;
  }
  
  public boolean isVarcharFieldWidthSupported() {
    return false;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\j256\ormlite\db\BaseSqliteDatabaseType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */