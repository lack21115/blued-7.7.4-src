package com.tencent.bugly.yaq.proguard;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import java.util.List;
import java.util.Map;

public final class p {
  private static p a = null;
  
  private static q b = null;
  
  private static boolean c = false;
  
  static {
    throw new VerifyError("bad dex opcode");
  }
  
  private p(Context paramContext, List<com.tencent.bugly.yaq.a> paramList) {
    b = new q(paramContext, paramList);
    throw new VerifyError("bad dex opcode");
  }
  
  private int a(String paramString1, String paramString2, String[] paramArrayOfString, o paramo) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: getstatic com/tencent/bugly/yaq/proguard/p.b : Lcom/tencent/bugly/yaq/proguard/q;
    //   5: astore_1
    //   6: new java/lang/VerifyError
    //   9: dup
    //   10: ldc 'bad dex opcode'
    //   12: invokespecial <init> : (Ljava/lang/String;)V
    //   15: athrow
    //   16: aload_0
    //   17: monitorexit
    //   18: iconst_0
    //   19: ireturn
    //   20: astore_1
    //   21: aload_1
    //   22: invokestatic a : (Ljava/lang/Throwable;)Z
    //   25: ifne -> 38
    //   28: new java/lang/VerifyError
    //   31: dup
    //   32: ldc 'bad dex opcode'
    //   34: invokespecial <init> : (Ljava/lang/String;)V
    //   37: athrow
    //   38: aload #4
    //   40: ifnull -> 16
    //   43: goto -> 16
    //   46: astore_1
    //   47: aload_0
    //   48: monitorexit
    //   49: aload_1
    //   50: athrow
    //   51: astore_1
    //   52: aload #4
    //   54: ifnull -> 57
    //   57: aload_1
    //   58: athrow
    // Exception table:
    //   from	to	target	type
    //   2	16	20	java/lang/Throwable
    //   2	16	51	finally
    //   21	38	51	finally
    //   57	59	46	finally
  }
  
  private long a(String paramString, ContentValues paramContentValues, o paramo) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: getstatic com/tencent/bugly/yaq/proguard/p.b : Lcom/tencent/bugly/yaq/proguard/q;
    //   5: astore_1
    //   6: new java/lang/VerifyError
    //   9: dup
    //   10: ldc 'bad dex opcode'
    //   12: invokespecial <init> : (Ljava/lang/String;)V
    //   15: athrow
    //   16: aload_0
    //   17: monitorexit
    //   18: lconst_0
    //   19: lreturn
    //   20: astore_1
    //   21: aload_1
    //   22: invokestatic a : (Ljava/lang/Throwable;)Z
    //   25: ifne -> 38
    //   28: new java/lang/VerifyError
    //   31: dup
    //   32: ldc 'bad dex opcode'
    //   34: invokespecial <init> : (Ljava/lang/String;)V
    //   37: athrow
    //   38: aload_3
    //   39: ifnull -> 16
    //   42: goto -> 16
    //   45: astore_1
    //   46: aload_0
    //   47: monitorexit
    //   48: aload_1
    //   49: athrow
    //   50: astore_1
    //   51: aload_3
    //   52: ifnull -> 55
    //   55: aload_1
    //   56: athrow
    // Exception table:
    //   from	to	target	type
    //   2	16	20	java/lang/Throwable
    //   2	16	50	finally
    //   21	38	50	finally
    //   55	57	45	finally
  }
  
  private Cursor a(boolean paramBoolean, String paramString1, String[] paramArrayOfString1, String paramString2, String[] paramArrayOfString2, String paramString3, String paramString4, String paramString5, String paramString6, o paramo) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: getstatic com/tencent/bugly/yaq/proguard/p.b : Lcom/tencent/bugly/yaq/proguard/q;
    //   5: astore_2
    //   6: new java/lang/VerifyError
    //   9: dup
    //   10: ldc 'bad dex opcode'
    //   12: invokespecial <init> : (Ljava/lang/String;)V
    //   15: athrow
    //   16: aload_0
    //   17: monitorexit
    //   18: aconst_null
    //   19: areturn
    //   20: astore_2
    //   21: aload_2
    //   22: invokestatic a : (Ljava/lang/Throwable;)Z
    //   25: ifne -> 38
    //   28: new java/lang/VerifyError
    //   31: dup
    //   32: ldc 'bad dex opcode'
    //   34: invokespecial <init> : (Ljava/lang/String;)V
    //   37: athrow
    //   38: aload #10
    //   40: ifnull -> 54
    //   43: goto -> 16
    //   46: astore_2
    //   47: aload_2
    //   48: athrow
    //   49: astore_2
    //   50: aload_0
    //   51: monitorexit
    //   52: aload_2
    //   53: athrow
    //   54: goto -> 16
    // Exception table:
    //   from	to	target	type
    //   2	16	20	java/lang/Throwable
    //   2	16	46	finally
    //   21	38	46	finally
    //   47	49	49	finally
  }
  
  public static p a() {
    // Byte code:
    //   0: ldc com/tencent/bugly/yaq/proguard/p
    //   2: monitorenter
    //   3: getstatic com/tencent/bugly/yaq/proguard/p.a : Lcom/tencent/bugly/yaq/proguard/p;
    //   6: astore_0
    //   7: ldc com/tencent/bugly/yaq/proguard/p
    //   9: monitorexit
    //   10: aload_0
    //   11: areturn
    //   12: astore_0
    //   13: ldc com/tencent/bugly/yaq/proguard/p
    //   15: monitorexit
    //   16: aload_0
    //   17: athrow
    // Exception table:
    //   from	to	target	type
    //   3	7	12	finally
  }
  
  public static p a(Context paramContext, List<com.tencent.bugly.yaq.a> paramList) {
    // Byte code:
    //   0: ldc com/tencent/bugly/yaq/proguard/p
    //   2: monitorenter
    //   3: getstatic com/tencent/bugly/yaq/proguard/p.a : Lcom/tencent/bugly/yaq/proguard/p;
    //   6: ifnonnull -> 21
    //   9: new com/tencent/bugly/yaq/proguard/p
    //   12: dup
    //   13: aload_0
    //   14: aload_1
    //   15: invokespecial <init> : (Landroid/content/Context;Ljava/util/List;)V
    //   18: putstatic com/tencent/bugly/yaq/proguard/p.a : Lcom/tencent/bugly/yaq/proguard/p;
    //   21: getstatic com/tencent/bugly/yaq/proguard/p.a : Lcom/tencent/bugly/yaq/proguard/p;
    //   24: astore_0
    //   25: ldc com/tencent/bugly/yaq/proguard/p
    //   27: monitorexit
    //   28: aload_0
    //   29: areturn
    //   30: astore_0
    //   31: ldc com/tencent/bugly/yaq/proguard/p
    //   33: monitorexit
    //   34: aload_0
    //   35: athrow
    // Exception table:
    //   from	to	target	type
    //   3	21	30	finally
    //   21	25	30	finally
  }
  
  private static r a(Cursor paramCursor) {
    if (paramCursor != null)
      try {
        new r();
        paramCursor.getLong(paramCursor.getColumnIndex("_id"));
        throw new VerifyError("bad dex opcode");
      } catch (Throwable throwable) {} 
    return null;
  }
  
  private Map<String, byte[]> a(int paramInt, o paramo) {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aconst_null
    //   3: astore #4
    //   5: aload_0
    //   6: iload_1
    //   7: invokespecial c : (I)Ljava/util/List;
    //   10: astore #5
    //   12: aload #5
    //   14: ifnull -> 96
    //   17: new java/util/HashMap
    //   20: dup
    //   21: invokespecial <init> : ()V
    //   24: astore_3
    //   25: aload #5
    //   27: invokeinterface iterator : ()Ljava/util/Iterator;
    //   32: astore #4
    //   34: aload #4
    //   36: invokeinterface hasNext : ()Z
    //   41: ifeq -> 96
    //   44: aload #4
    //   46: invokeinterface next : ()Ljava/lang/Object;
    //   51: checkcast com/tencent/bugly/yaq/proguard/r
    //   54: astore #4
    //   56: new java/lang/VerifyError
    //   59: dup
    //   60: ldc 'bad dex opcode'
    //   62: invokespecial <init> : (Ljava/lang/String;)V
    //   65: athrow
    //   66: astore #4
    //   68: aload #4
    //   70: invokestatic a : (Ljava/lang/Throwable;)Z
    //   73: ifne -> 86
    //   76: new java/lang/VerifyError
    //   79: dup
    //   80: ldc 'bad dex opcode'
    //   82: invokespecial <init> : (Ljava/lang/String;)V
    //   85: athrow
    //   86: aload_3
    //   87: astore #4
    //   89: aload_2
    //   90: ifnull -> 93
    //   93: aload #4
    //   95: areturn
    //   96: aload_3
    //   97: astore #4
    //   99: aload_2
    //   100: ifnull -> 93
    //   103: aload_3
    //   104: areturn
    //   105: astore_2
    //   106: aload_2
    //   107: athrow
    //   108: astore #5
    //   110: aload #4
    //   112: astore_3
    //   113: aload #5
    //   115: astore #4
    //   117: goto -> 68
    // Exception table:
    //   from	to	target	type
    //   5	12	108	java/lang/Throwable
    //   5	12	105	finally
    //   17	25	108	java/lang/Throwable
    //   17	25	105	finally
    //   25	66	66	java/lang/Throwable
    //   25	66	105	finally
    //   68	86	105	finally
  }
  
  private boolean a(int paramInt, String paramString, o paramo) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: getstatic com/tencent/bugly/yaq/proguard/p.b : Lcom/tencent/bugly/yaq/proguard/q;
    //   5: astore_2
    //   6: new java/lang/VerifyError
    //   9: dup
    //   10: ldc 'bad dex opcode'
    //   12: invokespecial <init> : (Ljava/lang/String;)V
    //   15: athrow
    //   16: aload_0
    //   17: monitorexit
    //   18: iconst_0
    //   19: ireturn
    //   20: astore_2
    //   21: aload_2
    //   22: invokestatic a : (Ljava/lang/Throwable;)Z
    //   25: ifne -> 38
    //   28: new java/lang/VerifyError
    //   31: dup
    //   32: ldc 'bad dex opcode'
    //   34: invokespecial <init> : (Ljava/lang/String;)V
    //   37: athrow
    //   38: aload_3
    //   39: ifnull -> 16
    //   42: goto -> 16
    //   45: astore_2
    //   46: aload_0
    //   47: monitorexit
    //   48: aload_2
    //   49: athrow
    //   50: astore_2
    //   51: aload_3
    //   52: ifnull -> 55
    //   55: aload_2
    //   56: athrow
    // Exception table:
    //   from	to	target	type
    //   2	16	20	java/lang/Throwable
    //   2	16	50	finally
    //   21	38	50	finally
    //   55	57	45	finally
  }
  
  private boolean a(int paramInt, String paramString, byte[] paramArrayOfbyte, o paramo) {
    try {
      new r();
      long l = paramInt;
      throw new VerifyError("bad dex opcode");
    } catch (Throwable throwable) {
      return (paramo != null) ? false : false;
    } finally {
      if (paramo != null);
    } 
  }
  
  private static r b(Cursor paramCursor) {
    if (paramCursor != null)
      try {
        new r();
        paramCursor.getLong(paramCursor.getColumnIndex("_id"));
        throw new VerifyError("bad dex opcode");
      } catch (Throwable throwable) {} 
    return null;
  }
  
  private boolean b(r paramr) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: ifnonnull -> 10
    //   6: aload_0
    //   7: monitorexit
    //   8: iconst_0
    //   9: ireturn
    //   10: getstatic com/tencent/bugly/yaq/proguard/p.b : Lcom/tencent/bugly/yaq/proguard/q;
    //   13: astore_1
    //   14: new java/lang/VerifyError
    //   17: dup
    //   18: ldc 'bad dex opcode'
    //   20: invokespecial <init> : (Ljava/lang/String;)V
    //   23: athrow
    //   24: astore_1
    //   25: aload_1
    //   26: invokestatic a : (Ljava/lang/Throwable;)Z
    //   29: ifne -> 6
    //   32: new java/lang/VerifyError
    //   35: dup
    //   36: ldc 'bad dex opcode'
    //   38: invokespecial <init> : (Ljava/lang/String;)V
    //   41: athrow
    //   42: astore_1
    //   43: aload_1
    //   44: athrow
    //   45: astore_1
    //   46: aload_0
    //   47: monitorexit
    //   48: aload_1
    //   49: athrow
    // Exception table:
    //   from	to	target	type
    //   10	24	24	java/lang/Throwable
    //   10	24	42	finally
    //   25	42	42	finally
    //   43	45	45	finally
  }
  
  private static ContentValues c(r paramr) {
    if (paramr != null)
      try {
        new ContentValues();
        throw new VerifyError("bad dex opcode");
      } catch (Throwable throwable) {} 
    return null;
  }
  
  private List<r> c(int paramInt) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: getstatic com/tencent/bugly/yaq/proguard/p.b : Lcom/tencent/bugly/yaq/proguard/q;
    //   5: astore_2
    //   6: new java/lang/VerifyError
    //   9: dup
    //   10: ldc 'bad dex opcode'
    //   12: invokespecial <init> : (Ljava/lang/String;)V
    //   15: athrow
    //   16: aload_0
    //   17: monitorexit
    //   18: aconst_null
    //   19: areturn
    //   20: aload_2
    //   21: invokestatic a : (Ljava/lang/Throwable;)Z
    //   24: ifne -> 37
    //   27: new java/lang/VerifyError
    //   30: dup
    //   31: ldc 'bad dex opcode'
    //   33: invokespecial <init> : (Ljava/lang/String;)V
    //   36: athrow
    //   37: iconst_0
    //   38: ifeq -> 49
    //   41: new java/lang/NullPointerException
    //   44: dup
    //   45: invokespecial <init> : ()V
    //   48: athrow
    //   49: goto -> 16
    //   52: iconst_0
    //   53: ifeq -> 64
    //   56: new java/lang/NullPointerException
    //   59: dup
    //   60: invokespecial <init> : ()V
    //   63: athrow
    //   64: aload_2
    //   65: athrow
    //   66: astore_2
    //   67: aload_0
    //   68: monitorexit
    //   69: aload_2
    //   70: athrow
    //   71: astore_2
    //   72: goto -> 52
    //   75: astore_2
    //   76: goto -> 52
    //   79: astore_2
    //   80: goto -> 20
    // Exception table:
    //   from	to	target	type
    //   2	16	79	java/lang/Throwable
    //   2	16	71	finally
    //   20	37	75	finally
    //   41	49	66	finally
    //   56	64	66	finally
    //   64	66	66	finally
  }
  
  private static ContentValues d(r paramr) {
    if (paramr != null)
      throw new VerifyError("bad dex opcode"); 
    return null;
  }
  
  public final int a(String paramString1, String paramString2, String[] paramArrayOfString, o paramo, boolean paramBoolean) {
    return a(paramString1, paramString2, (String[])null, (o)null);
  }
  
  public final long a(String paramString, ContentValues paramContentValues, o paramo, boolean paramBoolean) {
    return a(paramString, paramContentValues, (o)null);
  }
  
  public final Cursor a(String paramString1, String[] paramArrayOfString1, String paramString2, String[] paramArrayOfString2, o paramo, boolean paramBoolean) {
    return a(false, paramString1, paramArrayOfString1, paramString2, null, null, null, null, null, null);
  }
  
  public final List<r> a(int paramInt) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: getstatic com/tencent/bugly/yaq/proguard/p.b : Lcom/tencent/bugly/yaq/proguard/q;
    //   5: astore_2
    //   6: new java/lang/VerifyError
    //   9: dup
    //   10: ldc 'bad dex opcode'
    //   12: invokespecial <init> : (Ljava/lang/String;)V
    //   15: athrow
    //   16: astore_2
    //   17: aload_0
    //   18: monitorexit
    //   19: aload_2
    //   20: athrow
    // Exception table:
    //   from	to	target	type
    //   2	16	16	finally
  }
  
  public final Map<String, byte[]> a(int paramInt, o paramo, boolean paramBoolean) {
    return a(paramInt, (o)null);
  }
  
  public final void a(List<r> paramList) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: ifnull -> 17
    //   6: aload_1
    //   7: invokeinterface size : ()I
    //   12: istore_2
    //   13: iload_2
    //   14: ifne -> 29
    //   17: aload_0
    //   18: monitorexit
    //   19: new java/lang/VerifyError
    //   22: dup
    //   23: ldc 'bad dex opcode'
    //   25: invokespecial <init> : (Ljava/lang/String;)V
    //   28: athrow
    //   29: getstatic com/tencent/bugly/yaq/proguard/p.b : Lcom/tencent/bugly/yaq/proguard/q;
    //   32: astore_1
    //   33: new java/lang/VerifyError
    //   36: dup
    //   37: ldc 'bad dex opcode'
    //   39: invokespecial <init> : (Ljava/lang/String;)V
    //   42: athrow
    //   43: astore_1
    //   44: aload_0
    //   45: monitorexit
    //   46: aload_1
    //   47: athrow
    // Exception table:
    //   from	to	target	type
    //   6	13	43	finally
    //   29	43	43	finally
  }
  
  public final boolean a(int paramInt, String paramString, o paramo, boolean paramBoolean) {
    return a(555, paramString, (o)null);
  }
  
  public final boolean a(int paramInt, String paramString, byte[] paramArrayOfbyte, o paramo, boolean paramBoolean) {
    if (!paramBoolean) {
      new a(this, 4, null);
      throw new VerifyError("bad dex opcode");
    } 
    return a(paramInt, paramString, paramArrayOfbyte, (o)null);
  }
  
  public final boolean a(r paramr) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: ifnonnull -> 10
    //   6: aload_0
    //   7: monitorexit
    //   8: iconst_0
    //   9: ireturn
    //   10: getstatic com/tencent/bugly/yaq/proguard/p.b : Lcom/tencent/bugly/yaq/proguard/q;
    //   13: astore_1
    //   14: new java/lang/VerifyError
    //   17: dup
    //   18: ldc 'bad dex opcode'
    //   20: invokespecial <init> : (Ljava/lang/String;)V
    //   23: athrow
    //   24: astore_1
    //   25: aload_1
    //   26: invokestatic a : (Ljava/lang/Throwable;)Z
    //   29: ifne -> 6
    //   32: new java/lang/VerifyError
    //   35: dup
    //   36: ldc 'bad dex opcode'
    //   38: invokespecial <init> : (Ljava/lang/String;)V
    //   41: athrow
    //   42: astore_1
    //   43: aload_1
    //   44: athrow
    //   45: astore_1
    //   46: aload_0
    //   47: monitorexit
    //   48: aload_1
    //   49: athrow
    // Exception table:
    //   from	to	target	type
    //   10	24	24	java/lang/Throwable
    //   10	24	42	finally
    //   25	42	42	finally
    //   43	45	45	finally
  }
  
  public final void b(int paramInt) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: getstatic com/tencent/bugly/yaq/proguard/p.b : Lcom/tencent/bugly/yaq/proguard/q;
    //   5: astore_2
    //   6: new java/lang/VerifyError
    //   9: dup
    //   10: ldc 'bad dex opcode'
    //   12: invokespecial <init> : (Ljava/lang/String;)V
    //   15: athrow
    //   16: astore_2
    //   17: aload_0
    //   18: monitorexit
    //   19: aload_2
    //   20: athrow
    // Exception table:
    //   from	to	target	type
    //   2	16	16	finally
  }
  
  final class a extends Thread {
    private int a;
    
    private o b;
    
    private String c;
    
    private ContentValues d;
    
    private boolean e;
    
    private String[] f;
    
    private String g;
    
    private String[] h;
    
    private String i;
    
    private String j;
    
    private String k;
    
    private String l;
    
    private String m;
    
    private String[] n;
    
    private int o;
    
    private String p;
    
    private byte[] q;
    
    public a(p this$0, int param1Int, o param1o) {}
    
    public final void a(int param1Int, String param1String, byte[] param1ArrayOfbyte) {
      throw new VerifyError("bad dex opcode");
    }
    
    public final void a(boolean param1Boolean, String param1String1, String[] param1ArrayOfString1, String param1String2, String[] param1ArrayOfString2, String param1String3, String param1String4, String param1String5, String param1String6) {
      throw new VerifyError("bad dex opcode");
    }
    
    public final void run() {
      throw new VerifyError("bad dex opcode");
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued555128-dex2jar.jar!\com\tencent\bugly\yaq\proguard\p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */