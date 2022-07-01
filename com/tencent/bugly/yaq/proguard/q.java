package com.tencent.bugly.yaq.proguard;

import android.annotation.TargetApi;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.tencent.bugly.yaq.a;
import java.util.List;

public final class q extends SQLiteOpenHelper {
  public static String a = "bugly_db";
  
  private static int b = 15;
  
  private Context c;
  
  private List<a> d;
  
  static {
    throw new VerifyError("bad dex opcode");
  }
  
  public q(Context paramContext, List<a> paramList) {}
  
  private boolean a(SQLiteDatabase paramSQLiteDatabase) {
    // Byte code:
    //   0: iconst_1
    //   1: istore_2
    //   2: aload_0
    //   3: monitorenter
    //   4: iconst_3
    //   5: anewarray java/lang/String
    //   8: astore_1
    //   9: aload_1
    //   10: iconst_0
    //   11: ldc 't_lr'
    //   13: aastore
    //   14: aload_1
    //   15: iconst_1
    //   16: ldc 't_ui'
    //   18: aastore
    //   19: aload_1
    //   20: iconst_2
    //   21: ldc 't_pf'
    //   23: aastore
    //   24: aload_1
    //   25: arraylength
    //   26: ifge -> 73
    //   29: aload_1
    //   30: iconst_0
    //   31: aaload
    //   32: astore_1
    //   33: new java/lang/StringBuilder
    //   36: dup
    //   37: ldc 'DROP TABLE IF EXISTS '
    //   39: invokespecial <init> : (Ljava/lang/String;)V
    //   42: pop
    //   43: new java/lang/VerifyError
    //   46: dup
    //   47: ldc 'bad dex opcode'
    //   49: invokespecial <init> : (Ljava/lang/String;)V
    //   52: athrow
    //   53: astore_1
    //   54: aload_1
    //   55: invokestatic b : (Ljava/lang/Throwable;)Z
    //   58: ifne -> 71
    //   61: new java/lang/VerifyError
    //   64: dup
    //   65: ldc 'bad dex opcode'
    //   67: invokespecial <init> : (Ljava/lang/String;)V
    //   70: athrow
    //   71: iconst_0
    //   72: istore_2
    //   73: aload_0
    //   74: monitorexit
    //   75: iload_2
    //   76: ireturn
    //   77: astore_1
    //   78: aload_0
    //   79: monitorexit
    //   80: aload_1
    //   81: athrow
    // Exception table:
    //   from	to	target	type
    //   4	9	53	java/lang/Throwable
    //   4	9	77	finally
    //   24	29	53	java/lang/Throwable
    //   24	29	77	finally
    //   33	53	53	java/lang/Throwable
    //   33	53	77	finally
    //   54	71	77	finally
  }
  
  public final SQLiteDatabase getReadableDatabase() {
    // Byte code:
    //   0: iconst_0
    //   1: istore_1
    //   2: aload_0
    //   3: monitorenter
    //   4: aconst_null
    //   5: astore_2
    //   6: aload_2
    //   7: ifnonnull -> 87
    //   10: iload_1
    //   11: iconst_5
    //   12: if_icmpge -> 87
    //   15: iload_1
    //   16: iconst_1
    //   17: iadd
    //   18: istore_1
    //   19: aload_0
    //   20: invokespecial getReadableDatabase : ()Landroid/database/sqlite/SQLiteDatabase;
    //   23: astore_3
    //   24: aload_3
    //   25: astore_2
    //   26: goto -> 6
    //   29: astore_3
    //   30: ldc '[Database] Try to get db(count: %d).'
    //   32: iconst_1
    //   33: anewarray java/lang/Object
    //   36: dup
    //   37: iconst_0
    //   38: iload_1
    //   39: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   42: aastore
    //   43: invokestatic d : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   46: pop
    //   47: iload_1
    //   48: iconst_5
    //   49: if_icmpne -> 62
    //   52: ldc '[Database] Failed to get db.'
    //   54: iconst_0
    //   55: anewarray java/lang/Object
    //   58: invokestatic e : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   61: pop
    //   62: ldc2_w 200
    //   65: invokestatic sleep : (J)V
    //   68: goto -> 6
    //   71: astore_2
    //   72: new java/lang/VerifyError
    //   75: dup
    //   76: ldc 'bad dex opcode'
    //   78: invokespecial <init> : (Ljava/lang/String;)V
    //   81: athrow
    //   82: astore_2
    //   83: aload_0
    //   84: monitorexit
    //   85: aload_2
    //   86: athrow
    //   87: aload_0
    //   88: monitorexit
    //   89: aload_2
    //   90: areturn
    // Exception table:
    //   from	to	target	type
    //   19	24	29	java/lang/Throwable
    //   19	24	82	finally
    //   30	47	82	finally
    //   52	62	82	finally
    //   62	68	71	java/lang/InterruptedException
    //   62	68	82	finally
    //   72	82	82	finally
  }
  
  public final SQLiteDatabase getWritableDatabase() {
    // Byte code:
    //   0: iconst_0
    //   1: istore_1
    //   2: aload_0
    //   3: monitorenter
    //   4: aconst_null
    //   5: astore_2
    //   6: aload_2
    //   7: ifnonnull -> 87
    //   10: iload_1
    //   11: iconst_5
    //   12: if_icmpge -> 87
    //   15: iload_1
    //   16: iconst_1
    //   17: iadd
    //   18: istore_1
    //   19: aload_0
    //   20: invokespecial getWritableDatabase : ()Landroid/database/sqlite/SQLiteDatabase;
    //   23: astore_3
    //   24: aload_3
    //   25: astore_2
    //   26: goto -> 6
    //   29: astore_3
    //   30: ldc '[Database] Try to get db(count: %d).'
    //   32: iconst_1
    //   33: anewarray java/lang/Object
    //   36: dup
    //   37: iconst_0
    //   38: iload_1
    //   39: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   42: aastore
    //   43: invokestatic d : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   46: pop
    //   47: iload_1
    //   48: iconst_5
    //   49: if_icmpne -> 62
    //   52: ldc '[Database] Failed to get db.'
    //   54: iconst_0
    //   55: anewarray java/lang/Object
    //   58: invokestatic e : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   61: pop
    //   62: ldc2_w 200
    //   65: invokestatic sleep : (J)V
    //   68: goto -> 6
    //   71: astore_2
    //   72: new java/lang/VerifyError
    //   75: dup
    //   76: ldc 'bad dex opcode'
    //   78: invokespecial <init> : (Ljava/lang/String;)V
    //   81: athrow
    //   82: astore_2
    //   83: aload_0
    //   84: monitorexit
    //   85: aload_2
    //   86: athrow
    //   87: aload_2
    //   88: ifnonnull -> 101
    //   91: ldc '[Database] db error delay error record 1min.'
    //   93: iconst_0
    //   94: anewarray java/lang/Object
    //   97: invokestatic d : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   100: pop
    //   101: aload_0
    //   102: monitorexit
    //   103: aload_2
    //   104: areturn
    // Exception table:
    //   from	to	target	type
    //   19	24	29	java/lang/Throwable
    //   19	24	82	finally
    //   30	47	82	finally
    //   52	62	82	finally
    //   62	68	71	java/lang/InterruptedException
    //   62	68	82	finally
    //   72	82	82	finally
    //   91	101	82	finally
  }
  
  public final void onCreate(SQLiteDatabase paramSQLiteDatabase) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: new java/lang/StringBuilder
    //   5: dup
    //   6: invokespecial <init> : ()V
    //   9: pop
    //   10: new java/lang/VerifyError
    //   13: dup
    //   14: ldc 'bad dex opcode'
    //   16: invokespecial <init> : (Ljava/lang/String;)V
    //   19: athrow
    //   20: new java/lang/VerifyError
    //   23: dup
    //   24: ldc 'bad dex opcode'
    //   26: invokespecial <init> : (Ljava/lang/String;)V
    //   29: athrow
    //   30: astore_1
    //   31: aload_1
    //   32: invokestatic b : (Ljava/lang/Throwable;)Z
    //   35: ifne -> 20
    //   38: new java/lang/VerifyError
    //   41: dup
    //   42: ldc 'bad dex opcode'
    //   44: invokespecial <init> : (Ljava/lang/String;)V
    //   47: athrow
    //   48: astore_1
    //   49: aload_0
    //   50: monitorexit
    //   51: aload_1
    //   52: athrow
    // Exception table:
    //   from	to	target	type
    //   2	20	30	java/lang/Throwable
    //   2	20	48	finally
    //   20	30	48	finally
    //   31	48	48	finally
  }
  
  @TargetApi(11)
  public final void onDowngrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: invokestatic c : ()I
    //   5: bipush #11
    //   7: if_icmplt -> 49
    //   10: ldc '[Database] Downgrade %d to %d drop tables.'
    //   12: iconst_2
    //   13: anewarray java/lang/Object
    //   16: dup
    //   17: iconst_0
    //   18: iload_2
    //   19: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   22: aastore
    //   23: dup
    //   24: iconst_1
    //   25: iload_3
    //   26: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   29: aastore
    //   30: invokestatic d : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   33: pop
    //   34: new java/lang/VerifyError
    //   37: dup
    //   38: ldc 'bad dex opcode'
    //   40: invokespecial <init> : (Ljava/lang/String;)V
    //   43: athrow
    //   44: astore_1
    //   45: aload_0
    //   46: monitorexit
    //   47: aload_1
    //   48: athrow
    //   49: aload_0
    //   50: monitorexit
    //   51: new java/lang/VerifyError
    //   54: dup
    //   55: ldc 'bad dex opcode'
    //   57: invokespecial <init> : (Ljava/lang/String;)V
    //   60: athrow
    // Exception table:
    //   from	to	target	type
    //   2	44	44	finally
  }
  
  public final void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc '[Database] Upgrade %d to %d , drop tables!'
    //   4: iconst_2
    //   5: anewarray java/lang/Object
    //   8: dup
    //   9: iconst_0
    //   10: iload_2
    //   11: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   14: aastore
    //   15: dup
    //   16: iconst_1
    //   17: iload_3
    //   18: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   21: aastore
    //   22: invokestatic d : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   25: pop
    //   26: new java/lang/VerifyError
    //   29: dup
    //   30: ldc 'bad dex opcode'
    //   32: invokespecial <init> : (Ljava/lang/String;)V
    //   35: athrow
    //   36: astore_1
    //   37: aload_0
    //   38: monitorexit
    //   39: aload_1
    //   40: athrow
    // Exception table:
    //   from	to	target	type
    //   2	36	36	finally
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued555128-dex2jar.jar!\com\tencent\bugly\yaq\proguard\q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */