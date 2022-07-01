package com.j256.ormlite.table;

import com.j256.ormlite.field.DatabaseFieldConfig;
import com.j256.ormlite.field.DatabaseFieldConfigLoader;
import com.j256.ormlite.misc.SqlExceptionUtil;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DatabaseTableConfigLoader {
  private static final String CONFIG_FILE_END_MARKER = "# --table-end--";
  
  private static final String CONFIG_FILE_FIELDS_END = "# --table-fields-end--";
  
  private static final String CONFIG_FILE_FIELDS_START = "# --table-fields-start--";
  
  private static final String CONFIG_FILE_START_MARKER = "# --table-start--";
  
  private static final String FIELD_NAME_DATA_CLASS = "dataClass";
  
  private static final String FIELD_NAME_TABLE_NAME = "tableName";
  
  public static <T> DatabaseTableConfig<T> fromReader(BufferedReader paramBufferedReader) throws SQLException {
    DatabaseTableConfig<T> databaseTableConfig = new DatabaseTableConfig();
    boolean bool = false;
    try {
      while (true) {
        String str = paramBufferedReader.readLine();
        if (str == null || str.equals("# --table-end--"))
          return bool ? databaseTableConfig : null; 
        if (str.equals("# --table-fields-start--")) {
          readFields(paramBufferedReader, databaseTableConfig);
          continue;
        } 
        if (str.length() == 0 || str.startsWith("#") || str.equals("# --table-start--"))
          continue; 
        String[] arrayOfString = str.split("=", -2);
        if (arrayOfString.length == 2) {
          readTableField(databaseTableConfig, arrayOfString[0], arrayOfString[1]);
          bool = true;
          continue;
        } 
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("DatabaseTableConfig reading from stream cannot parse line: ");
        stringBuilder.append(str);
        throw new SQLException(stringBuilder.toString());
      } 
    } catch (IOException iOException) {
      throw SqlExceptionUtil.create("Could not read DatabaseTableConfig from stream", iOException);
    } 
  }
  
  public static List<DatabaseTableConfig<?>> loadDatabaseConfigFromReader(BufferedReader paramBufferedReader) throws SQLException {
    ArrayList<DatabaseTableConfig<?>> arrayList = new ArrayList();
    while (true) {
      DatabaseTableConfig<?> databaseTableConfig = fromReader(paramBufferedReader);
      if (databaseTableConfig == null)
        return arrayList; 
      arrayList.add(databaseTableConfig);
    } 
  }
  
  private static <T> void readFields(BufferedReader paramBufferedReader, DatabaseTableConfig<T> paramDatabaseTableConfig) throws SQLException {
    ArrayList<DatabaseFieldConfig> arrayList = new ArrayList();
    try {
      while (true) {
        String str = paramBufferedReader.readLine();
        if (str == null || str.equals("# --table-fields-end--"))
          break; 
        DatabaseFieldConfig databaseFieldConfig = DatabaseFieldConfigLoader.fromReader(paramBufferedReader);
        if (databaseFieldConfig == null)
          break; 
        arrayList.add(databaseFieldConfig);
      } 
      paramDatabaseTableConfig.setFieldConfigs(arrayList);
      return;
    } catch (IOException iOException) {
      throw SqlExceptionUtil.create("Could not read next field from config file", iOException);
    } 
  }
  
  private static <T> void readTableField(DatabaseTableConfig<T> paramDatabaseTableConfig, String paramString1, String paramString2) {
    StringBuilder stringBuilder;
    if (paramString1.equals("dataClass"))
      try {
        paramDatabaseTableConfig.setDataClass((Class)Class.forName(paramString2));
        return;
      } catch (ClassNotFoundException classNotFoundException) {
        stringBuilder = new StringBuilder();
        stringBuilder.append("Unknown class specified for dataClass: ");
        stringBuilder.append(paramString2);
        throw new IllegalArgumentException(stringBuilder.toString());
      }  
    if (paramString1.equals("tableName"))
      stringBuilder.setTableName(paramString2); 
  }
  
  public static <T> void write(BufferedWriter paramBufferedWriter, DatabaseTableConfig<T> paramDatabaseTableConfig) throws SQLException {
    try {
      writeConfig(paramBufferedWriter, paramDatabaseTableConfig);
      return;
    } catch (IOException iOException) {
      throw SqlExceptionUtil.create("Could not write config to writer", iOException);
    } 
  }
  
  private static <T> void writeConfig(BufferedWriter paramBufferedWriter, DatabaseTableConfig<T> paramDatabaseTableConfig) throws IOException, SQLException {
    paramBufferedWriter.append("# --table-start--");
    paramBufferedWriter.newLine();
    if (paramDatabaseTableConfig.getDataClass() != null) {
      paramBufferedWriter.append("dataClass").append('=').append(paramDatabaseTableConfig.getDataClass().getName());
      paramBufferedWriter.newLine();
    } 
    if (paramDatabaseTableConfig.getTableName() != null) {
      paramBufferedWriter.append("tableName").append('=').append(paramDatabaseTableConfig.getTableName());
      paramBufferedWriter.newLine();
    } 
    paramBufferedWriter.append("# --table-fields-start--");
    paramBufferedWriter.newLine();
    if (paramDatabaseTableConfig.getFieldConfigs() != null) {
      Iterator<DatabaseFieldConfig> iterator = paramDatabaseTableConfig.getFieldConfigs().iterator();
      while (iterator.hasNext())
        DatabaseFieldConfigLoader.write(paramBufferedWriter, iterator.next(), paramDatabaseTableConfig.getTableName()); 
    } 
    paramBufferedWriter.append("# --table-fields-end--");
    paramBufferedWriter.newLine();
    paramBufferedWriter.append("# --table-end--");
    paramBufferedWriter.newLine();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\j256\ormlite\table\DatabaseTableConfigLoader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */