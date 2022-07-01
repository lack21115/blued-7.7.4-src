package com.qq.e.comm.plugin.a;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.qq.e.comm.plugin.g.a;
import com.qq.e.comm.plugin.y.c;
import com.qq.e.comm.plugin.y.d;
import com.qq.e.comm.plugin.y.u;
import com.qq.e.comm.util.GDTLogger;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

class t extends SQLiteOpenHelper {
  private static volatile t a;
  
  private static SQLiteDatabase c;
  
  private AtomicInteger b = new AtomicInteger();
  
  private t(Context paramContext) {
    super((Context)new a(paramContext), "GDTSDK.db", null, 9);
  }
  
  private c a(int paramInt, String paramString) {
    String str1;
    String str2;
    String str3;
    StringBuilder stringBuilder = null;
    try {
    
    } finally {
      paramString = null;
      paramString = null;
    } 
    try {
      GDTLogger.w("Get getTaskByTargetUrlAStatus Error");
      StringBuilder stringBuilder1 = stringBuilder;
      str2 = str1;
    } finally {
      a((SQLiteDatabase)str1, (Cursor)paramString);
    } 
    a((SQLiteDatabase)str2, (Cursor)str3);
    return (c)SYNTHETIC_LOCAL_VARIABLE_4;
  }
  
  private c a(Cursor paramCursor) {
    throw new RuntimeException("d2j fail translate: java.lang.RuntimeException: fail exe a17 = a14\r\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.exec(BaseAnalyze.java:92)\r\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.exec(BaseAnalyze.java:1)\r\n\tat com.googlecode.dex2jar.ir.ts.Cfg.dfs(Cfg.java:255)\r\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.analyze0(BaseAnalyze.java:75)\r\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.analyze(BaseAnalyze.java:69)\r\n\tat com.googlecode.dex2jar.ir.ts.UnSSATransformer.transform(UnSSATransformer.java:274)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:163)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\nCaused by: java.lang.NullPointerException: Cannot assign field \"used\" because \"aValue\" is null\r\n\tat com.googlecode.dex2jar.ir.ts.UnSSATransformer$LiveA.onUseLocal(UnSSATransformer.java:552)\r\n\tat com.googlecode.dex2jar.ir.ts.UnSSATransformer$LiveA.onUseLocal(UnSSATransformer.java:1)\r\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.onUse(BaseAnalyze.java:166)\r\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.onUse(BaseAnalyze.java:1)\r\n\tat com.googlecode.dex2jar.ir.ts.Cfg.travel(Cfg.java:331)\r\n\tat com.googlecode.dex2jar.ir.ts.Cfg.travel(Cfg.java:387)\r\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.exec(BaseAnalyze.java:90)\r\n\t... 17 more\r\n");
  }
  
  private c a(String paramString1, String paramString2) {
    String str1;
    Exception exception;
    StringBuilder stringBuilder1;
    String str2;
    String str3;
    StringBuilder stringBuilder2 = null;
    try {
    
    } finally {
      exception = null;
      paramString2 = null;
    } 
    try {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Get TaskByColumn ");
      stringBuilder.append(paramString1);
      stringBuilder.append(" Error");
      GDTLogger.w(stringBuilder.toString(), exception);
      stringBuilder1 = stringBuilder2;
      str2 = str1;
    } finally {
      a((SQLiteDatabase)str1, (Cursor)paramString2);
    } 
    a((SQLiteDatabase)str2, (Cursor)str3);
    return (c)stringBuilder1;
  }
  
  static t a(Context paramContext) {
    // Byte code:
    //   0: getstatic com/qq/e/comm/plugin/a/t.a : Lcom/qq/e/comm/plugin/a/t;
    //   3: ifnonnull -> 38
    //   6: ldc 'GDTSDK.db'
    //   8: monitorenter
    //   9: getstatic com/qq/e/comm/plugin/a/t.a : Lcom/qq/e/comm/plugin/a/t;
    //   12: ifnonnull -> 26
    //   15: new com/qq/e/comm/plugin/a/t
    //   18: dup
    //   19: aload_0
    //   20: invokespecial <init> : (Landroid/content/Context;)V
    //   23: putstatic com/qq/e/comm/plugin/a/t.a : Lcom/qq/e/comm/plugin/a/t;
    //   26: ldc 'GDTSDK.db'
    //   28: monitorexit
    //   29: goto -> 38
    //   32: astore_0
    //   33: ldc 'GDTSDK.db'
    //   35: monitorexit
    //   36: aload_0
    //   37: athrow
    //   38: getstatic com/qq/e/comm/plugin/a/t.a : Lcom/qq/e/comm/plugin/a/t;
    //   41: areturn
    // Exception table:
    //   from	to	target	type
    //   9	26	32	finally
    //   26	29	32	finally
    //   33	36	32	finally
  }
  
  private void a(SQLiteDatabase paramSQLiteDatabase, Cursor paramCursor) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_2
    //   3: ifnull -> 15
    //   6: aload_2
    //   7: invokeinterface close : ()V
    //   12: goto -> 15
    //   15: aload_1
    //   16: ifnull -> 40
    //   19: aload_0
    //   20: getfield b : Ljava/util/concurrent/atomic/AtomicInteger;
    //   23: invokevirtual decrementAndGet : ()I
    //   26: ifne -> 40
    //   29: aload_1
    //   30: invokevirtual close : ()V
    //   33: goto -> 40
    //   36: aload_0
    //   37: monitorexit
    //   38: aload_1
    //   39: athrow
    //   40: aload_0
    //   41: monitorexit
    //   42: return
    //   43: astore_1
    //   44: goto -> 36
    // Exception table:
    //   from	to	target	type
    //   6	12	43	finally
    //   19	33	43	finally
  }
  
  private List<c> b(String paramString) {
    Cursor cursor;
    ArrayList<c> arrayList = new ArrayList();
    SQLiteDatabase sQLiteDatabase2 = null;
    SQLiteDatabase sQLiteDatabase1 = null;
    try {
      SQLiteDatabase sQLiteDatabase = getReadableDatabase();
      sQLiteDatabase1 = sQLiteDatabase2;
    } finally {
      paramString = null;
    } 
    try {
      GDTLogger.w("Get getTasksByStatus Error");
      String str = paramString;
      Cursor cursor1 = cursor;
      return arrayList;
    } finally {
      a((SQLiteDatabase)paramString, cursor);
    } 
  }
  
  private boolean b(Cursor paramCursor) {
    return (paramCursor.getCount() > 0 && !paramCursor.isLast());
  }
  
  private List<c> c(String paramString) {
    ArrayList<c> arrayList = new ArrayList();
    Cursor cursor2 = null;
    Cursor cursor1 = null;
    try {
      SQLiteDatabase sQLiteDatabase = getReadableDatabase();
      cursor1 = cursor2;
    } finally {
      paramString = null;
    } 
    try {
      GDTLogger.w("Get getTasksByStatus Error");
      Cursor cursor = cursor1;
      return arrayList;
    } finally {
      a((SQLiteDatabase)paramString, cursor1);
    } 
  }
  
  private ContentValues e(c paramc) {
    throw new RuntimeException("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:659)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public int a(c paramc) {
    c c1 = (new c()).b(paramc.l());
    u.a(60602, 0, c1);
    long l = -1L;
    try {
    
    } finally {
      null = null;
      paramc = null;
    } 
    a((SQLiteDatabase)paramc, (Cursor)null);
    return (int)l;
  }
  
  public c a(int paramInt) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramInt);
    stringBuilder.append("");
    return a("id", stringBuilder.toString());
  }
  
  public c a(String paramString) {
    return a("pkg", paramString);
  }
  
  public List<c> a() {
    Cursor cursor;
    Exception exception;
    ArrayList<c> arrayList = new ArrayList();
    null = null;
    SQLiteDatabase sQLiteDatabase = null;
    try {
      SQLiteDatabase sQLiteDatabase1 = getReadableDatabase();
      sQLiteDatabase = null;
    } finally {
      exception = null;
    } 
    try {
      GDTLogger.w("Get DelayDownload Tasks Error");
      Exception exception1 = exception;
      Cursor cursor1 = cursor;
      return arrayList;
    } finally {
      a((SQLiteDatabase)exception, cursor);
    } 
  }
  
  public int b(c paramc) {
    c c1 = (new c()).b(paramc.l());
    int i = 0;
    u.a(60622, 0, c1);
    int j = paramc.m();
    if (j > 0) {
      try {
        SQLiteDatabase sQLiteDatabase = getWritableDatabase();
      } finally {
        null = null;
      } 
      try {
        GDTLogger.w("Update Task Error");
        d d = new d();
        d.a("ot", null.toString());
        u.a(60632, 0, c1, d);
      } finally {
        a((SQLiteDatabase)paramc, (Cursor)null);
      } 
      return i;
    } 
    return 0;
  }
  
  public c b(int paramInt) {
    return a(paramInt, new String("(4)"));
  }
  
  public List<c> b() {
    return c(new String("(4,32,16)"));
  }
  
  public int c(c paramc) {
    byte b1;
    d d1;
    d d2;
    c c1 = (new c()).b(paramc.l());
    u.a(60642, 0, c1);
    byte b2 = -1;
    Cursor cursor2 = null;
    Cursor cursor1 = null;
    try {
      SQLiteDatabase sQLiteDatabase1;
    } finally {
      null = null;
      cursor1 = null;
      d d = d1;
    } 
    a((SQLiteDatabase)cursor1, (Cursor)d2);
    return b1;
  }
  
  public c c(int paramInt) {
    return a(paramInt, new String("(32,16)"));
  }
  
  public List<c> c() {
    return c(new String("(4)"));
  }
  
  public int d(c paramc) {
    int i = 0;
    try {
      SQLiteDatabase sQLiteDatabase = getWritableDatabase();
    } finally {
      paramc = null;
    } 
    a((SQLiteDatabase)paramc, (Cursor)null);
    return i;
  }
  
  public List<c> d() {
    return b("(8)");
  }
  
  public SQLiteDatabase getReadableDatabase() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield b : Ljava/util/concurrent/atomic/AtomicInteger;
    //   6: invokevirtual incrementAndGet : ()I
    //   9: iconst_1
    //   10: if_icmpne -> 20
    //   13: aload_0
    //   14: invokespecial getReadableDatabase : ()Landroid/database/sqlite/SQLiteDatabase;
    //   17: putstatic com/qq/e/comm/plugin/a/t.c : Landroid/database/sqlite/SQLiteDatabase;
    //   20: getstatic com/qq/e/comm/plugin/a/t.c : Landroid/database/sqlite/SQLiteDatabase;
    //   23: astore_1
    //   24: aload_0
    //   25: monitorexit
    //   26: aload_1
    //   27: areturn
    //   28: astore_1
    //   29: aload_0
    //   30: monitorexit
    //   31: aload_1
    //   32: athrow
    // Exception table:
    //   from	to	target	type
    //   2	20	28	finally
    //   20	24	28	finally
  }
  
  public SQLiteDatabase getWritableDatabase() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield b : Ljava/util/concurrent/atomic/AtomicInteger;
    //   6: invokevirtual incrementAndGet : ()I
    //   9: iconst_1
    //   10: if_icmpne -> 20
    //   13: aload_0
    //   14: invokespecial getWritableDatabase : ()Landroid/database/sqlite/SQLiteDatabase;
    //   17: putstatic com/qq/e/comm/plugin/a/t.c : Landroid/database/sqlite/SQLiteDatabase;
    //   20: getstatic com/qq/e/comm/plugin/a/t.c : Landroid/database/sqlite/SQLiteDatabase;
    //   23: astore_1
    //   24: aload_0
    //   25: monitorexit
    //   26: aload_1
    //   27: areturn
    //   28: astore_1
    //   29: aload_0
    //   30: monitorexit
    //   31: aload_1
    //   32: athrow
    // Exception table:
    //   from	to	target	type
    //   2	20	28	finally
    //   20	24	28	finally
  }
  
  public void onCreate(SQLiteDatabase paramSQLiteDatabase) {
    paramSQLiteDatabase.execSQL("create table tasks   (   id integer primary key autoincrement,   adid text not null,   targetid text not null,   clickid text not null,   url text not null unique,   name text not null,   pkg text not null,   tracer text,   icon text not null,   createtime integer not null,   isreturned integer,   title text,   description text,   network integer not null,   status integer not null,   failreason text,   launchparam text,   delayDownload integer not null,   manualPaused integer not null,   progress integer not null,   totalSize integer not null)");
  }
  
  public void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2) {
    if (paramInt2 == 9) {
      paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS tasks");
      onCreate(paramSQLiteDatabase);
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\plugin\a\t.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */