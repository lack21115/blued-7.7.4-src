package com.baidu.mobads.openad.b;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.baidu.mobads.utils.XAdSDKFoundationFacade;
import java.util.ArrayList;
import java.util.List;

public class g {
  private i a;
  
  private String b;
  
  public g(Context paramContext) {
    this.a = new i(paramContext);
    this.b = XAdSDKFoundationFacade.getInstance().getSystemUtils().getCurrentProcessName(paramContext);
  }
  
  public void a(List<h> paramList) {
    SQLiteDatabase sQLiteDatabase = this.a.getWritableDatabase();
    for (h h : paramList) {
      int j = h.c();
      String str1 = h.b();
      String str2 = h.f();
      int k = h.d();
      int m = h.e();
      int n = h.a();
      String str3 = this.b;
      try {
        sQLiteDatabase.execSQL("insert into download_info(thread_id,url,local_file,start_pos,end_pos,compelete_size,process_name) values (?,?,?,?,?,?,?)", new Object[] { Integer.valueOf(j), str1, str2, Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(n), str3 });
      } catch (Exception exception) {
        XAdSDKFoundationFacade.getInstance().getAdLogger().e(new Object[] { "OAdSqlLiteAccessObj", exception.getMessage() });
      } 
    } 
  }
  
  public boolean a(String paramString1, String paramString2) {
    Cursor cursor = this.a.getReadableDatabase().rawQuery("select count(*)  from download_info where url=? and local_file=? and process_name=?", new String[] { paramString1, paramString2, this.b });
    cursor.moveToFirst();
    int j = cursor.getInt(0);
    cursor.close();
    return (j > 0);
  }
  
  public List<h> b(String paramString1, String paramString2) {
    ArrayList<h> arrayList = new ArrayList();
    Cursor cursor = this.a.getReadableDatabase().rawQuery("select thread_id, url, local_file, start_pos, end_pos,compelete_size from download_info where url=? and local_file=? and process_name=?", new String[] { paramString1, paramString2, this.b });
    while (cursor.moveToNext())
      arrayList.add(new h(cursor.getInt(0), cursor.getString(1), cursor.getString(2), cursor.getInt(3), cursor.getInt(4), cursor.getInt(5))); 
    cursor.close();
    return arrayList;
  }
  
  public void b(List<h> paramList) {
    SQLiteDatabase sQLiteDatabase = this.a.getReadableDatabase();
    for (h h : paramList) {
      int j = h.a();
      int k = h.c();
      String str1 = h.b();
      String str2 = h.f();
      String str3 = this.b;
      try {
        sQLiteDatabase.execSQL("update download_info set compelete_size=? where thread_id=? and url=? and local_file=? and process_name=?", new Object[] { Integer.valueOf(j), Integer.valueOf(k), str1, str2, str3 });
      } catch (Exception exception) {
        XAdSDKFoundationFacade.getInstance().getAdLogger().e(new Object[] { "OAdSqlLiteAccessObj", exception.getMessage() });
      } 
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\baidu\mobads\openad\b\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */