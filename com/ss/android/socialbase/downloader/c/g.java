package com.ss.android.socialbase.downloader.c;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;

public class g {
  private final SQLiteDatabase a;
  
  private final String b;
  
  private final String[] c;
  
  private final String[] d;
  
  private SQLiteStatement e;
  
  private SQLiteStatement f;
  
  private SQLiteStatement g;
  
  public g(SQLiteDatabase paramSQLiteDatabase, String paramString, String[] paramArrayOfString1, String[] paramArrayOfString2) {
    this.a = paramSQLiteDatabase;
    this.b = paramString;
    this.c = paramArrayOfString1;
    this.d = paramArrayOfString2;
  }
  
  public SQLiteStatement a() {
    // Byte code:
    //   0: aload_0
    //   1: getfield e : Landroid/database/sqlite/SQLiteStatement;
    //   4: ifnonnull -> 66
    //   7: ldc 'INSERT INTO '
    //   9: aload_0
    //   10: getfield b : Ljava/lang/String;
    //   13: aload_0
    //   14: getfield c : [Ljava/lang/String;
    //   17: invokestatic a : (Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)Ljava/lang/String;
    //   20: astore_1
    //   21: aload_0
    //   22: getfield a : Landroid/database/sqlite/SQLiteDatabase;
    //   25: aload_1
    //   26: invokevirtual compileStatement : (Ljava/lang/String;)Landroid/database/sqlite/SQLiteStatement;
    //   29: astore_1
    //   30: aload_0
    //   31: monitorenter
    //   32: aload_0
    //   33: getfield e : Landroid/database/sqlite/SQLiteStatement;
    //   36: ifnonnull -> 44
    //   39: aload_0
    //   40: aload_1
    //   41: putfield e : Landroid/database/sqlite/SQLiteStatement;
    //   44: aload_0
    //   45: monitorexit
    //   46: aload_0
    //   47: getfield e : Landroid/database/sqlite/SQLiteStatement;
    //   50: aload_1
    //   51: if_acmpeq -> 66
    //   54: aload_1
    //   55: invokevirtual close : ()V
    //   58: goto -> 66
    //   61: astore_1
    //   62: aload_0
    //   63: monitorexit
    //   64: aload_1
    //   65: athrow
    //   66: aload_0
    //   67: getfield e : Landroid/database/sqlite/SQLiteStatement;
    //   70: areturn
    // Exception table:
    //   from	to	target	type
    //   32	44	61	finally
    //   44	46	61	finally
    //   62	64	61	finally
  }
  
  public SQLiteStatement b() {
    // Byte code:
    //   0: aload_0
    //   1: getfield g : Landroid/database/sqlite/SQLiteStatement;
    //   4: ifnonnull -> 64
    //   7: aload_0
    //   8: getfield b : Ljava/lang/String;
    //   11: aload_0
    //   12: getfield d : [Ljava/lang/String;
    //   15: invokestatic a : (Ljava/lang/String;[Ljava/lang/String;)Ljava/lang/String;
    //   18: astore_1
    //   19: aload_0
    //   20: getfield a : Landroid/database/sqlite/SQLiteDatabase;
    //   23: aload_1
    //   24: invokevirtual compileStatement : (Ljava/lang/String;)Landroid/database/sqlite/SQLiteStatement;
    //   27: astore_1
    //   28: aload_0
    //   29: monitorenter
    //   30: aload_0
    //   31: getfield g : Landroid/database/sqlite/SQLiteStatement;
    //   34: ifnonnull -> 42
    //   37: aload_0
    //   38: aload_1
    //   39: putfield g : Landroid/database/sqlite/SQLiteStatement;
    //   42: aload_0
    //   43: monitorexit
    //   44: aload_0
    //   45: getfield g : Landroid/database/sqlite/SQLiteStatement;
    //   48: aload_1
    //   49: if_acmpeq -> 64
    //   52: aload_1
    //   53: invokevirtual close : ()V
    //   56: goto -> 64
    //   59: astore_1
    //   60: aload_0
    //   61: monitorexit
    //   62: aload_1
    //   63: athrow
    //   64: aload_0
    //   65: getfield g : Landroid/database/sqlite/SQLiteStatement;
    //   68: areturn
    // Exception table:
    //   from	to	target	type
    //   30	42	59	finally
    //   42	44	59	finally
    //   60	62	59	finally
  }
  
  public SQLiteStatement c() {
    // Byte code:
    //   0: aload_0
    //   1: getfield f : Landroid/database/sqlite/SQLiteStatement;
    //   4: ifnonnull -> 68
    //   7: aload_0
    //   8: getfield b : Ljava/lang/String;
    //   11: aload_0
    //   12: getfield c : [Ljava/lang/String;
    //   15: aload_0
    //   16: getfield d : [Ljava/lang/String;
    //   19: invokestatic a : (Ljava/lang/String;[Ljava/lang/String;[Ljava/lang/String;)Ljava/lang/String;
    //   22: astore_1
    //   23: aload_0
    //   24: getfield a : Landroid/database/sqlite/SQLiteDatabase;
    //   27: aload_1
    //   28: invokevirtual compileStatement : (Ljava/lang/String;)Landroid/database/sqlite/SQLiteStatement;
    //   31: astore_1
    //   32: aload_0
    //   33: monitorenter
    //   34: aload_0
    //   35: getfield f : Landroid/database/sqlite/SQLiteStatement;
    //   38: ifnonnull -> 46
    //   41: aload_0
    //   42: aload_1
    //   43: putfield f : Landroid/database/sqlite/SQLiteStatement;
    //   46: aload_0
    //   47: monitorexit
    //   48: aload_0
    //   49: getfield f : Landroid/database/sqlite/SQLiteStatement;
    //   52: aload_1
    //   53: if_acmpeq -> 68
    //   56: aload_1
    //   57: invokevirtual close : ()V
    //   60: goto -> 68
    //   63: astore_1
    //   64: aload_0
    //   65: monitorexit
    //   66: aload_1
    //   67: athrow
    //   68: aload_0
    //   69: getfield f : Landroid/database/sqlite/SQLiteStatement;
    //   72: areturn
    // Exception table:
    //   from	to	target	type
    //   34	46	63	finally
    //   46	48	63	finally
    //   64	66	63	finally
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\ss\android\socialbase\downloader\c\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */