package com.qq.e.comm.plugin.y;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.qq.e.comm.plugin.g.a;
import com.qq.e.comm.util.GDTLogger;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

class i extends SQLiteOpenHelper {
  private static volatile i a;
  
  private Map<String, t> b = new HashMap<String, t>(5);
  
  private i(Context paramContext) {
    super((Context)new a(paramContext), "gdt_stat.db", null, 2);
    this.b.put("event", new t<n>("event", (t.a)new t.a<k>(this) {
            public k a(int param1Int, String param1String) {
              return l.a(param1Int, param1String);
            }
          }));
    this.b.put("performance", new t<n>("performance", (t.a)new t.a<o>(this) {
            public o a(int param1Int, String param1String) {
              return p.a(param1Int, param1String);
            }
          }));
  }
  
  public static i a(Context paramContext) {
    // Byte code:
    //   0: getstatic com/qq/e/comm/plugin/y/i.a : Lcom/qq/e/comm/plugin/y/i;
    //   3: ifnonnull -> 38
    //   6: ldc com/qq/e/comm/plugin/y/i
    //   8: monitorenter
    //   9: getstatic com/qq/e/comm/plugin/y/i.a : Lcom/qq/e/comm/plugin/y/i;
    //   12: ifnonnull -> 26
    //   15: new com/qq/e/comm/plugin/y/i
    //   18: dup
    //   19: aload_0
    //   20: invokespecial <init> : (Landroid/content/Context;)V
    //   23: putstatic com/qq/e/comm/plugin/y/i.a : Lcom/qq/e/comm/plugin/y/i;
    //   26: ldc com/qq/e/comm/plugin/y/i
    //   28: monitorexit
    //   29: goto -> 38
    //   32: astore_0
    //   33: ldc com/qq/e/comm/plugin/y/i
    //   35: monitorexit
    //   36: aload_0
    //   37: athrow
    //   38: getstatic com/qq/e/comm/plugin/y/i.a : Lcom/qq/e/comm/plugin/y/i;
    //   41: areturn
    // Exception table:
    //   from	to	target	type
    //   9	26	32	finally
    //   26	29	32	finally
    //   33	36	32	finally
  }
  
  private void a(SQLiteDatabase paramSQLiteDatabase) {
    if (paramSQLiteDatabase == null) {
      GDTLogger.w("No stat db!");
      return;
    } 
    try {
      paramSQLiteDatabase.beginTransaction();
      Iterator<t> iterator = this.b.values().iterator();
      while (iterator.hasNext())
        ((t)iterator.next()).b(paramSQLiteDatabase); 
      paramSQLiteDatabase.setTransactionSuccessful();
    } finally {
      null = null;
    } 
    paramSQLiteDatabase.endTransaction();
  }
  
  private void b(SQLiteDatabase paramSQLiteDatabase) {
    if (paramSQLiteDatabase == null) {
      GDTLogger.w("No stat db!");
      return;
    } 
    try {
      paramSQLiteDatabase.beginTransaction();
      Iterator<t> iterator = this.b.values().iterator();
      while (iterator.hasNext())
        ((t)iterator.next()).a(paramSQLiteDatabase); 
      paramSQLiteDatabase.setTransactionSuccessful();
    } finally {
      null = null;
    } 
    paramSQLiteDatabase.endTransaction();
  }
  
  public void a() {
    Iterator<t> iterator = this.b.values().iterator();
    while (iterator.hasNext())
      ((t)iterator.next()).a(this); 
  }
  
  t b() {
    return this.b.get("event");
  }
  
  t c() {
    return this.b.get("performance");
  }
  
  public void onCreate(SQLiteDatabase paramSQLiteDatabase) {
    b(paramSQLiteDatabase);
  }
  
  public void onDowngrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2) {
    a(paramSQLiteDatabase);
    b(paramSQLiteDatabase);
  }
  
  public void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2) {
    a(paramSQLiteDatabase);
    b(paramSQLiteDatabase);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\plugin\y\i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */