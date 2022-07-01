package com.j256.ormlite.android.apptools;

import com.j256.ormlite.db.DatabaseType;
import com.j256.ormlite.db.SqliteAndroidDatabaseType;
import com.j256.ormlite.field.DatabaseFieldConfig;
import com.j256.ormlite.table.DatabaseTable;
import com.j256.ormlite.table.DatabaseTableConfig;
import com.j256.ormlite.table.DatabaseTableConfigLoader;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileFilter;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.lang.reflect.Field;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrmLiteConfigUtil {
  protected static final String RAW_DIR_NAME = "raw";
  
  protected static final String RESOURCE_DIR_NAME = "res";
  
  private static final DatabaseType databaseType = (DatabaseType)new SqliteAndroidDatabaseType();
  
  protected static int maxFindSourceLevel = 20;
  
  private static boolean classHasAnnotations(Class<?> paramClass) {
    while (paramClass != null) {
      PrintStream printStream;
      if (paramClass.getAnnotation(DatabaseTable.class) != null)
        return true; 
      try {
        int i;
      } finally {
        Exception exception = null;
        PrintStream printStream1 = System.err;
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append("Could not load get delcared fields from: ");
        stringBuilder2.append(printStream);
        printStream1.println(stringBuilder2.toString());
        printStream = System.err;
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append("     ");
        stringBuilder1.append(exception);
        printStream.println(stringBuilder1.toString());
      } 
    } 
    return false;
  }
  
  private static void findAnnotatedClasses(List<Class<?>> paramList, File paramFile, int paramInt) throws SQLException, IOException {
    for (File file : paramFile.listFiles()) {
      if (file.isDirectory()) {
        if (paramInt < maxFindSourceLevel)
          findAnnotatedClasses(paramList, file, paramInt + 1); 
      } else if (file.getName().endsWith(".java")) {
        PrintStream printStream;
        String str = getPackageOfClass(file);
        if (str == null) {
          printStream = System.err;
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append("Could not find package name for: ");
          stringBuilder.append(file);
          printStream.println(stringBuilder.toString());
        } else {
          String str2 = file.getName();
          str2 = str2.substring(0, str2.length() - 5);
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append((String)printStream);
          stringBuilder.append(".");
          stringBuilder.append(str2);
          String str1 = stringBuilder.toString();
          try {
          
          } finally {
            str1 = null;
            PrintStream printStream2 = System.err;
            stringBuilder = new StringBuilder();
            stringBuilder.append("Could not load class file for: ");
            stringBuilder.append(file);
            printStream2.println(stringBuilder.toString());
            PrintStream printStream1 = System.err;
            StringBuilder stringBuilder1 = new StringBuilder();
            stringBuilder1.append("     ");
            stringBuilder1.append(str1);
          } 
        } 
      } 
    } 
  }
  
  protected static File findRawDir(File paramFile) {
    for (int i = 0; paramFile != null && i < 20; i++) {
      File file = findResRawDir(paramFile);
      if (file != null)
        return file; 
      paramFile = paramFile.getParentFile();
    } 
    return null;
  }
  
  private static File findResRawDir(File paramFile) {
    for (File file : paramFile.listFiles()) {
      if (file.getName().equals("res") && file.isDirectory()) {
        File[] arrayOfFile = file.listFiles(new FileFilter() {
              public boolean accept(File param1File) {
                return (param1File.getName().equals("raw") && param1File.isDirectory());
              }
            });
        if (arrayOfFile.length == 1)
          return arrayOfFile[0]; 
      } 
    } 
    return null;
  }
  
  private static String getPackageOfClass(File paramFile) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new FileReader(paramFile));
    try {
      while (true) {
        String str = bufferedReader.readLine();
        if (str == null)
          return null; 
        if (str.contains("package")) {
          String[] arrayOfString = str.split("[ \t;]");
          if (arrayOfString.length > 1 && arrayOfString[0].equals("package"))
            return arrayOfString[1]; 
        } 
      } 
    } finally {
      bufferedReader.close();
    } 
  }
  
  public static void main(String[] paramArrayOfString) throws Exception {
    if (paramArrayOfString.length == 1) {
      writeConfigFile(paramArrayOfString[0]);
      return;
    } 
    throw new IllegalArgumentException("Main can take a single file-name argument.");
  }
  
  public static void writeConfigFile(File paramFile) throws SQLException, IOException {
    writeConfigFile(paramFile, new File("."));
  }
  
  public static void writeConfigFile(File paramFile1, File paramFile2) throws SQLException, IOException {
    ArrayList<Class<?>> arrayList = new ArrayList();
    findAnnotatedClasses(arrayList, paramFile2, 0);
    writeConfigFile(paramFile1, (Class[])arrayList.<Class<?>[]>toArray((Class<?>[][])new Class[arrayList.size()]));
  }
  
  public static void writeConfigFile(File paramFile, Class<?>[] paramArrayOfClass) throws SQLException, IOException {
    PrintStream printStream = System.out;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Writing configurations to ");
    stringBuilder.append(paramFile.getAbsolutePath());
    printStream.println(stringBuilder.toString());
    writeConfigFile(new FileOutputStream(paramFile), paramArrayOfClass);
  }
  
  public static void writeConfigFile(OutputStream paramOutputStream, File paramFile) throws SQLException, IOException {
    ArrayList<Class<?>> arrayList = new ArrayList();
    findAnnotatedClasses(arrayList, paramFile, 0);
    writeConfigFile(paramOutputStream, (Class[])arrayList.<Class<?>[]>toArray((Class<?>[][])new Class[arrayList.size()]));
  }
  
  public static void writeConfigFile(OutputStream paramOutputStream, Class<?>[] paramArrayOfClass) throws SQLException, IOException {
    BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(paramOutputStream), 4096);
    try {
      writeHeader(bufferedWriter);
      int j = paramArrayOfClass.length;
      for (int i = 0; i < j; i++)
        writeConfigForTable(bufferedWriter, paramArrayOfClass[i]); 
      System.out.println("Done.");
      return;
    } finally {
      bufferedWriter.close();
    } 
  }
  
  public static void writeConfigFile(String paramString) throws SQLException, IOException {
    ArrayList<Class<?>> arrayList = new ArrayList();
    findAnnotatedClasses(arrayList, new File("."), 0);
    writeConfigFile(paramString, (Class[])arrayList.<Class<?>[]>toArray((Class<?>[][])new Class[arrayList.size()]));
  }
  
  public static void writeConfigFile(String paramString, Class<?>[] paramArrayOfClass) throws SQLException, IOException {
    File file = findRawDir(new File("."));
    if (file == null) {
      System.err.println("Could not find raw directory which is typically in the res directory");
      return;
    } 
    writeConfigFile(new File(file, paramString), paramArrayOfClass);
  }
  
  private static void writeConfigForTable(BufferedWriter paramBufferedWriter, Class<?> paramClass) throws SQLException, IOException {
    String str = DatabaseTableConfig.extractTableName(paramClass);
    ArrayList<DatabaseFieldConfig> arrayList = new ArrayList();
    Class<?> clazz = paramClass;
    label24: while (true) {
      StringBuilder stringBuilder2;
      if (clazz != null) {
        try {
          Field[] arrayOfField = clazz.getDeclaredFields();
          int j = arrayOfField.length;
          for (int i = 0;; i++) {
            if (i < j) {
              Field field = arrayOfField[i];
              DatabaseFieldConfig databaseFieldConfig = DatabaseFieldConfig.fromField(databaseType, str, field);
              if (databaseFieldConfig != null)
                arrayList.add(databaseFieldConfig); 
            } else {
              clazz = clazz.getSuperclass();
              continue label24;
            } 
          } 
        } catch (Error error) {
          PrintStream printStream1 = System.err;
          stringBuilder2 = new StringBuilder();
          stringBuilder2.append("Skipping ");
          stringBuilder2.append(paramClass);
          stringBuilder2.append(" because we got an error finding its definition: ");
          stringBuilder2.append(error.getMessage());
          printStream1.println(stringBuilder2.toString());
          return;
        } 
        break;
      } 
      if (arrayList.isEmpty()) {
        printStream = System.out;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Skipping ");
        stringBuilder.append(paramClass);
        stringBuilder.append(" because no annotated fields found");
        printStream.println(stringBuilder.toString());
        return;
      } 
      DatabaseTableConfigLoader.write((BufferedWriter)printStream, new DatabaseTableConfig(paramClass, (String)stringBuilder2, arrayList));
      printStream.append("#################################");
      printStream.newLine();
      PrintStream printStream = System.out;
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append("Wrote config for ");
      stringBuilder1.append(paramClass);
      printStream.println(stringBuilder1.toString());
      return;
    } 
  }
  
  private static void writeHeader(BufferedWriter paramBufferedWriter) throws IOException {
    paramBufferedWriter.append('#');
    paramBufferedWriter.newLine();
    paramBufferedWriter.append("# generated on ").append((new SimpleDateFormat("yyyy/MM/dd hh:mm:ss")).format(new Date()));
    paramBufferedWriter.newLine();
    paramBufferedWriter.append('#');
    paramBufferedWriter.newLine();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\j256\ormlite\android\apptools\OrmLiteConfigUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */