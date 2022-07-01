package com.qq.e.comm.plugin.g;

import android.content.Context;
import android.content.ContextWrapper;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import com.qq.e.comm.util.GDTLogger;
import java.io.File;
import java.io.IOException;

public class a extends ContextWrapper {
  private String a;
  
  public a(Context paramContext) {
    this(paramContext, "gdt_database");
  }
  
  public a(Context paramContext, String paramString) {
    super(paramContext);
    this.a = paramString;
  }
  
  public File getDatabasePath(String paramString) {
    StringBuilder stringBuilder1;
    StringBuilder stringBuilder2;
    File file = getFilesDir();
    String str2 = null;
    String str1 = null;
    if (file != null) {
      File file1;
      str2 = this.a;
      if (str2 != null) {
        File file3 = new File(file, str2);
        if (file3.exists() || file3.mkdir())
          file = file3; 
      } 
      File file2 = new File(file, paramString);
      file = file2;
      if (!file2.exists()) {
        GDTLogger.d("create database file");
        file = file2;
        try {
          if (!file2.createNewFile())
            file = super.getDatabasePath(paramString); 
        } catch (IOException iOException) {
          iOException.printStackTrace();
          file1 = super.getDatabasePath(paramString);
        } 
      } 
      stringBuilder2 = new StringBuilder();
      stringBuilder2.append("getDatabasePath(");
      stringBuilder2.append(paramString);
      stringBuilder2.append(") = ");
      paramString = str1;
      if (file1 != null)
        paramString = file1.getPath(); 
      stringBuilder2.append(paramString);
      stringBuilder2.append(", this:");
      stringBuilder2.append(this);
      stringBuilder1 = stringBuilder2;
    } else {
      String str;
      file = super.getDatabasePath((String)stringBuilder1);
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("getDatabasePath(");
      stringBuilder.append((String)stringBuilder1);
      stringBuilder.append(") = ");
      stringBuilder1 = stringBuilder2;
      if (file != null)
        str = file.getPath(); 
      stringBuilder.append(str);
      stringBuilder1 = stringBuilder;
    } 
    GDTLogger.d(stringBuilder1.toString());
    return file;
  }
  
  public SQLiteDatabase openOrCreateDatabase(String paramString, int paramInt, SQLiteDatabase.CursorFactory paramCursorFactory) {
    return openOrCreateDatabase(paramString, paramInt, paramCursorFactory, null);
  }
  
  public SQLiteDatabase openOrCreateDatabase(String paramString, int paramInt, SQLiteDatabase.CursorFactory paramCursorFactory, DatabaseErrorHandler paramDatabaseErrorHandler) {
    SQLiteDatabase sQLiteDatabase;
    if ((paramInt & 0x8) != 0 && Build.VERSION.SDK_INT >= 16) {
      paramInt = 805306368;
    } else {
      paramInt = 268435456;
    } 
    int i = Build.VERSION.SDK_INT;
    String str = null;
    if (i >= 11) {
      File file = getDatabasePath(paramString);
      if (file != null) {
        sQLiteDatabase = SQLiteDatabase.openDatabase(file.getPath(), paramCursorFactory, paramInt, paramDatabaseErrorHandler);
      } else {
        paramCursorFactory = null;
      } 
    } else {
      sQLiteDatabase = SQLiteDatabase.openOrCreateDatabase(getDatabasePath(paramString), paramCursorFactory);
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("openOrCreateDatabase(");
    stringBuilder.append(paramString);
    stringBuilder.append(",,) = ");
    paramString = str;
    if (sQLiteDatabase != null)
      paramString = sQLiteDatabase.getPath(); 
    stringBuilder.append(paramString);
    GDTLogger.d(stringBuilder.toString());
    return sQLiteDatabase;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\plugin\g\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */