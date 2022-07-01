package com.bytedance.tea.crash.b.b;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.bytedance.tea.crash.b.a.a;
import com.bytedance.tea.crash.g.j;
import java.util.HashMap;

public class b extends a<a> {
  public b() {
    super("duplicatelog");
  }
  
  protected ContentValues a(a parama) {
    ContentValues contentValues = new ContentValues();
    contentValues.put("path", parama.a);
    contentValues.put("insert_time", Long.valueOf(parama.b));
    return contentValues;
  }
  
  protected HashMap<String, String> a() {
    HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
    hashMap.put("path", "TEXT");
    hashMap.put("insert_time", "INTEGER");
    hashMap.put("ext1", "TEXT");
    hashMap.put("ext2", "TEXT");
    return (HashMap)hashMap;
  }
  
  public void a(SQLiteDatabase paramSQLiteDatabase, a parama) {
    if (parama != null) {
      if (a(paramSQLiteDatabase, parama.a))
        return; 
      super.a(paramSQLiteDatabase, parama);
      try {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("delete from ");
        stringBuilder.append(this.b);
        stringBuilder.append(" where ");
        stringBuilder.append("_id");
        stringBuilder.append(" in (select ");
        stringBuilder.append("_id");
        stringBuilder.append(" from ");
        stringBuilder.append(this.b);
        stringBuilder.append(" order by ");
        stringBuilder.append("insert_time");
        stringBuilder.append(" desc limit 1000 offset ");
        stringBuilder.append(500);
        stringBuilder.append(")");
        paramSQLiteDatabase.execSQL(stringBuilder.toString());
        return;
      } catch (Exception exception) {
        j.b(exception);
      } 
    } 
  }
  
  public boolean a(SQLiteDatabase paramSQLiteDatabase, String paramString) {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramSQLiteDatabase != null) {
      if (TextUtils.isEmpty(paramString))
        return false; 
      try {
        Cursor cursor = paramSQLiteDatabase.query(this.b, null, "path=?", new String[] { paramString }, null, null, null);
        int i = cursor.getCount();
        try {
          cursor.close();
        } catch (Exception null) {}
      } catch (Exception exception) {
        boolean bool = false;
      } 
      j.b(exception);
    } 
    return bool1;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\tea\crash\b\b\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */