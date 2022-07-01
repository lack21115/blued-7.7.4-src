package com.facebook.stetho.dumpapp.plugins;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.facebook.stetho.dumpapp.DumpUsageException;
import com.facebook.stetho.dumpapp.DumperContext;
import com.facebook.stetho.dumpapp.DumperPlugin;
import java.io.File;
import java.io.PrintStream;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class SharedPreferencesDumperPlugin implements DumperPlugin {
  private static final String NAME = "prefs";
  
  private static final String XML_SUFFIX = ".xml";
  
  private final Context mAppContext;
  
  public SharedPreferencesDumperPlugin(Context paramContext) {
    this.mAppContext = paramContext.getApplicationContext();
  }
  
  private void doPrint(PrintStream paramPrintStream, List<String> paramList) {
    String str1;
    String str2;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append((this.mAppContext.getApplicationInfo()).dataDir);
    stringBuilder.append("/shared_prefs");
    String str3 = stringBuilder.toString();
    if (paramList.isEmpty()) {
      str2 = "";
    } else {
      str2 = paramList.get(0);
    } 
    if (paramList.size() > 1) {
      str1 = paramList.get(1);
    } else {
      str1 = "";
    } 
    printRecursive(paramPrintStream, str3, "", str2, str1);
  }
  
  private void doUsage(PrintStream paramPrintStream) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Usage: dumpapp prefs ");
    stringBuilder.append("<command> [command-options]");
    paramPrintStream.println(stringBuilder.toString());
    stringBuilder = new StringBuilder();
    stringBuilder.append("Usage: dumpapp prefs ");
    stringBuilder.append("print [pathPrefix [keyPrefix]]");
    paramPrintStream.println(stringBuilder.toString());
    stringBuilder = new StringBuilder("       dumpapp prefs ");
    stringBuilder.append("write <path> <key> <");
    stringBuilder = Type.appendNamesList(stringBuilder, "|");
    stringBuilder.append("> <value>");
    paramPrintStream.println(stringBuilder);
    paramPrintStream.println();
    paramPrintStream.println("dumpapp prefs print: Print all matching values from the shared preferences");
    paramPrintStream.println();
    paramPrintStream.println("dumpapp prefs write: Writes a value to the shared preferences");
  }
  
  private void doWrite(List<String> paramList) throws DumpUsageException {
    Iterator<String> iterator = paramList.iterator();
    String str2 = nextArg(iterator, "Expected <path>");
    String str1 = nextArg(iterator, "Expected <key>");
    Type type = Type.of(nextArg(iterator, "Expected <type>"));
    if (type != null) {
      SharedPreferences.Editor editor = getSharedPreferences(str2).edit();
      switch (type) {
        case null:
          putStringSet(editor, str1, iterator);
          break;
        case STRING:
          editor.putString(str1, nextArgValue(iterator));
          break;
        case FLOAT:
          editor.putFloat(str1, Float.valueOf(nextArgValue(iterator)).floatValue());
          break;
        case LONG:
          editor.putLong(str1, Long.valueOf(nextArgValue(iterator)).longValue());
          break;
        case INT:
          editor.putInt(str1, Integer.valueOf(nextArgValue(iterator)).intValue());
          break;
        case BOOLEAN:
          editor.putBoolean(str1, Boolean.valueOf(nextArgValue(iterator)).booleanValue());
          break;
      } 
      editor.commit();
      return;
    } 
    throw new DumpUsageException(Type.appendNamesList(new StringBuilder("Usage: prefs write <path> <key> <type> <value>, where type is one of: "), ", ").toString());
  }
  
  private SharedPreferences getSharedPreferences(String paramString) {
    return this.mAppContext.getSharedPreferences(paramString, 4);
  }
  
  @Nonnull
  private static String nextArg(Iterator<String> paramIterator, String paramString) throws DumpUsageException {
    if (paramIterator.hasNext())
      return paramIterator.next(); 
    throw new DumpUsageException(paramString);
  }
  
  @Nonnull
  private static String nextArgValue(Iterator<String> paramIterator) throws DumpUsageException {
    return nextArg(paramIterator, "Expected <value>");
  }
  
  private void printFile(PrintStream paramPrintStream, String paramString1, String paramString2) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramString1);
    stringBuilder.append(":");
    paramPrintStream.println(stringBuilder.toString());
    for (Map.Entry entry : getSharedPreferences(paramString1).getAll().entrySet()) {
      if (((String)entry.getKey()).startsWith(paramString2)) {
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append("  ");
        stringBuilder1.append((String)entry.getKey());
        stringBuilder1.append(" = ");
        stringBuilder1.append(entry.getValue());
        paramPrintStream.println(stringBuilder1.toString());
      } 
    } 
  }
  
  private void printRecursive(PrintStream paramPrintStream, String paramString1, String paramString2, String paramString3, String paramString4) {
    File file = new File(paramString1, paramString2);
    boolean bool = file.isFile();
    int i = 0;
    if (bool) {
      if (paramString2.endsWith(".xml")) {
        printFile(paramPrintStream, paramString2.substring(0, paramString2.length() - 4), paramString4);
        return;
      } 
    } else if (file.isDirectory()) {
      String[] arrayOfString = file.list();
      if (arrayOfString != null)
        while (i < arrayOfString.length) {
          String str;
          if (TextUtils.isEmpty(paramString2)) {
            str = arrayOfString[i];
          } else {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(paramString2);
            stringBuilder.append(File.separator);
            stringBuilder.append(arrayOfString[i]);
            str = stringBuilder.toString();
          } 
          if (str.startsWith(paramString3))
            printRecursive(paramPrintStream, paramString1, str, paramString3, paramString4); 
          i++;
        }  
    } 
  }
  
  private static void putStringSet(SharedPreferences.Editor paramEditor, String paramString, Iterator<String> paramIterator) {
    HashSet hashSet = new HashSet();
    while (paramIterator.hasNext())
      hashSet.add(paramIterator.next()); 
    paramEditor.putStringSet(paramString, hashSet);
  }
  
  public void dump(DumperContext paramDumperContext) throws DumpUsageException {
    String str;
    PrintStream printStream = paramDumperContext.getStdout();
    List<String> list = paramDumperContext.getArgsAsList();
    if (list.isEmpty()) {
      str = "";
    } else {
      str = list.remove(0);
    } 
    if (str.equals("print")) {
      doPrint(printStream, list);
      return;
    } 
    if (str.equals("write")) {
      doWrite(list);
      return;
    } 
    doUsage(printStream);
  }
  
  public String getName() {
    return "prefs";
  }
  
  enum Type {
    BOOLEAN("boolean"),
    FLOAT("boolean"),
    INT("int"),
    LONG("long"),
    SET("long"),
    STRING("long");
    
    private final String name;
    
    static {
      SET = new Type("SET", 5, "set");
      $VALUES = new Type[] { BOOLEAN, INT, LONG, FLOAT, STRING, SET };
    }
    
    Type(String param1String1) {
      this.name = param1String1;
    }
    
    public static StringBuilder appendNamesList(StringBuilder param1StringBuilder, String param1String) {
      Type[] arrayOfType = values();
      int j = arrayOfType.length;
      int i = 0;
      boolean bool = true;
      while (i < j) {
        Type type = arrayOfType[i];
        if (bool) {
          bool = false;
        } else {
          param1StringBuilder.append(param1String);
        } 
        param1StringBuilder.append(type.name);
        i++;
      } 
      return param1StringBuilder;
    }
    
    @Nullable
    public static Type of(String param1String) {
      for (Type type : values()) {
        if (type.name.equals(param1String))
          return type; 
      } 
      return null;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\facebook\stetho\dumpapp\plugins\SharedPreferencesDumperPlugin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */