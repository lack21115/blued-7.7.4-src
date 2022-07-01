package com.bytedance.tea.crash.b.b;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import com.bytedance.tea.crash.g.j;
import java.util.HashMap;

public abstract class a<T> {
  protected final String a = "_id";
  
  protected final String b;
  
  protected a(String paramString) {
    this.b = paramString;
  }
  
  protected abstract ContentValues a(T paramT);
  
  protected abstract HashMap<String, String> a();
  
  public void a(SQLiteDatabase paramSQLiteDatabase) {
    try {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("CREATE TABLE ");
      stringBuilder.append(this.b);
      stringBuilder.append(" (_id INTEGER PRIMARY KEY AUTOINCREMENT, ");
      HashMap<String, String> hashMap = a();
      if (hashMap != null) {
        for (String str : hashMap.keySet()) {
          stringBuilder.append(str);
          stringBuilder.append(" ");
          stringBuilder.append(hashMap.get(str));
          stringBuilder.append(",");
        } 
        stringBuilder.delete(stringBuilder.length() - 1, stringBuilder.length());
        stringBuilder.append(")");
        paramSQLiteDatabase.execSQL(stringBuilder.toString());
        return;
      } 
    } catch (Exception exception) {
      exception.printStackTrace();
    } 
  }
  
  public void a(SQLiteDatabase paramSQLiteDatabase, T paramT) {
    if (paramSQLiteDatabase != null && paramT != null)
      try {
        paramSQLiteDatabase.insert(this.b, null, a(paramT));
        return;
      } catch (Exception exception) {
        j.b(exception);
      }  
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\tea\crash\b\b\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */