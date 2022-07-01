package com.bytedance.tea.crash.b;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import com.bytedance.tea.crash.b.a.a;
import com.bytedance.tea.crash.b.b.b;

public class a {
  private static volatile a a;
  
  private b b;
  
  private SQLiteDatabase c;
  
  public static a a() {
    // Byte code:
    //   0: getstatic com/bytedance/tea/crash/b/a.a : Lcom/bytedance/tea/crash/b/a;
    //   3: ifnonnull -> 37
    //   6: ldc com/bytedance/tea/crash/b/a
    //   8: monitorenter
    //   9: getstatic com/bytedance/tea/crash/b/a.a : Lcom/bytedance/tea/crash/b/a;
    //   12: ifnonnull -> 25
    //   15: new com/bytedance/tea/crash/b/a
    //   18: dup
    //   19: invokespecial <init> : ()V
    //   22: putstatic com/bytedance/tea/crash/b/a.a : Lcom/bytedance/tea/crash/b/a;
    //   25: ldc com/bytedance/tea/crash/b/a
    //   27: monitorexit
    //   28: goto -> 37
    //   31: astore_0
    //   32: ldc com/bytedance/tea/crash/b/a
    //   34: monitorexit
    //   35: aload_0
    //   36: athrow
    //   37: getstatic com/bytedance/tea/crash/b/a.a : Lcom/bytedance/tea/crash/b/a;
    //   40: areturn
    // Exception table:
    //   from	to	target	type
    //   9	25	31	finally
    //   25	28	31	finally
    //   32	35	31	finally
  }
  
  public void a(Context paramContext) {
    try {
      this.c = (new b(paramContext)).getWritableDatabase();
    } finally {
      paramContext = null;
    } 
  }
  
  public void a(a parama) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield b : Lcom/bytedance/tea/crash/b/b/b;
    //   6: ifnull -> 21
    //   9: aload_0
    //   10: getfield b : Lcom/bytedance/tea/crash/b/b/b;
    //   13: aload_0
    //   14: getfield c : Landroid/database/sqlite/SQLiteDatabase;
    //   17: aload_1
    //   18: invokevirtual a : (Landroid/database/sqlite/SQLiteDatabase;Lcom/bytedance/tea/crash/b/a/a;)V
    //   21: aload_0
    //   22: monitorexit
    //   23: return
    //   24: astore_1
    //   25: aload_0
    //   26: monitorexit
    //   27: aload_1
    //   28: athrow
    // Exception table:
    //   from	to	target	type
    //   2	21	24	finally
  }
  
  public boolean a(String paramString) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield b : Lcom/bytedance/tea/crash/b/b/b;
    //   6: ifnull -> 26
    //   9: aload_0
    //   10: getfield b : Lcom/bytedance/tea/crash/b/b/b;
    //   13: aload_0
    //   14: getfield c : Landroid/database/sqlite/SQLiteDatabase;
    //   17: aload_1
    //   18: invokevirtual a : (Landroid/database/sqlite/SQLiteDatabase;Ljava/lang/String;)Z
    //   21: istore_2
    //   22: aload_0
    //   23: monitorexit
    //   24: iload_2
    //   25: ireturn
    //   26: aload_0
    //   27: monitorexit
    //   28: iconst_0
    //   29: ireturn
    //   30: astore_1
    //   31: aload_0
    //   32: monitorexit
    //   33: aload_1
    //   34: athrow
    // Exception table:
    //   from	to	target	type
    //   2	22	30	finally
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\tea\crash\b\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */