package com.bytedance.sdk.openadsdk.j;

import android.content.Context;
import java.util.List;

public class g implements f {
  private Context a;
  
  public g(Context paramContext) {
    this.a = paramContext;
  }
  
  public static String b() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("CREATE TABLE IF NOT EXISTS ");
    stringBuilder.append("trackurl");
    stringBuilder.append(" (_id INTEGER PRIMARY KEY AUTOINCREMENT,");
    stringBuilder.append("id");
    stringBuilder.append(" TEXT UNIQUE,");
    stringBuilder.append("url");
    stringBuilder.append(" TEXT ,");
    stringBuilder.append("replaceholder");
    stringBuilder.append(" INTEGER default 0, ");
    stringBuilder.append("retry");
    stringBuilder.append(" INTEGER default 0");
    stringBuilder.append(")");
    return stringBuilder.toString();
  }
  
  public List<e> a() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: new java/util/LinkedList
    //   5: dup
    //   6: invokespecial <init> : ()V
    //   9: astore_3
    //   10: aload_0
    //   11: getfield a : Landroid/content/Context;
    //   14: ldc 'trackurl'
    //   16: aconst_null
    //   17: aconst_null
    //   18: aconst_null
    //   19: aconst_null
    //   20: aconst_null
    //   21: aconst_null
    //   22: invokestatic a : (Landroid/content/Context;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   25: astore_2
    //   26: aload_2
    //   27: ifnull -> 155
    //   30: aload_2
    //   31: invokeinterface moveToNext : ()Z
    //   36: ifeq -> 129
    //   39: aload_2
    //   40: aload_2
    //   41: ldc 'id'
    //   43: invokeinterface getColumnIndex : (Ljava/lang/String;)I
    //   48: invokeinterface getString : (I)Ljava/lang/String;
    //   53: astore #4
    //   55: aload_2
    //   56: aload_2
    //   57: ldc 'url'
    //   59: invokeinterface getColumnIndex : (Ljava/lang/String;)I
    //   64: invokeinterface getString : (I)Ljava/lang/String;
    //   69: astore #5
    //   71: aload_2
    //   72: aload_2
    //   73: ldc 'replaceholder'
    //   75: invokeinterface getColumnIndex : (Ljava/lang/String;)I
    //   80: invokeinterface getInt : (I)I
    //   85: ifle -> 164
    //   88: iconst_1
    //   89: istore_1
    //   90: goto -> 93
    //   93: aload_3
    //   94: new com/bytedance/sdk/openadsdk/j/e
    //   97: dup
    //   98: aload #4
    //   100: aload #5
    //   102: iload_1
    //   103: aload_2
    //   104: aload_2
    //   105: ldc 'retry'
    //   107: invokeinterface getColumnIndex : (Ljava/lang/String;)I
    //   112: invokeinterface getInt : (I)I
    //   117: invokespecial <init> : (Ljava/lang/String;Ljava/lang/String;ZI)V
    //   120: invokeinterface add : (Ljava/lang/Object;)Z
    //   125: pop
    //   126: goto -> 30
    //   129: aload_2
    //   130: ifnull -> 155
    //   133: aload_2
    //   134: invokeinterface close : ()V
    //   139: goto -> 155
    //   142: astore_3
    //   143: aload_2
    //   144: ifnull -> 153
    //   147: aload_2
    //   148: invokeinterface close : ()V
    //   153: aload_3
    //   154: athrow
    //   155: aload_0
    //   156: monitorexit
    //   157: aload_3
    //   158: areturn
    //   159: astore_2
    //   160: aload_0
    //   161: monitorexit
    //   162: aload_2
    //   163: athrow
    //   164: iconst_0
    //   165: istore_1
    //   166: goto -> 93
    // Exception table:
    //   from	to	target	type
    //   2	26	159	finally
    //   30	88	142	finally
    //   93	126	142	finally
    //   133	139	159	finally
    //   147	153	159	finally
    //   153	155	159	finally
  }
  
  public void a(e parame) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: new android/content/ContentValues
    //   5: dup
    //   6: invokespecial <init> : ()V
    //   9: astore_3
    //   10: aload_3
    //   11: ldc 'id'
    //   13: aload_1
    //   14: invokevirtual a : ()Ljava/lang/String;
    //   17: invokevirtual put : (Ljava/lang/String;Ljava/lang/String;)V
    //   20: aload_3
    //   21: ldc 'url'
    //   23: aload_1
    //   24: invokevirtual b : ()Ljava/lang/String;
    //   27: invokevirtual put : (Ljava/lang/String;Ljava/lang/String;)V
    //   30: aload_1
    //   31: invokevirtual c : ()Z
    //   34: ifeq -> 83
    //   37: iconst_1
    //   38: istore_2
    //   39: goto -> 42
    //   42: aload_3
    //   43: ldc 'replaceholder'
    //   45: iload_2
    //   46: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   49: invokevirtual put : (Ljava/lang/String;Ljava/lang/Integer;)V
    //   52: aload_3
    //   53: ldc 'retry'
    //   55: aload_1
    //   56: invokevirtual d : ()I
    //   59: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   62: invokevirtual put : (Ljava/lang/String;Ljava/lang/Integer;)V
    //   65: aload_0
    //   66: getfield a : Landroid/content/Context;
    //   69: ldc 'trackurl'
    //   71: aload_3
    //   72: invokestatic a : (Landroid/content/Context;Ljava/lang/String;Landroid/content/ContentValues;)V
    //   75: aload_0
    //   76: monitorexit
    //   77: return
    //   78: astore_1
    //   79: aload_0
    //   80: monitorexit
    //   81: aload_1
    //   82: athrow
    //   83: iconst_0
    //   84: istore_2
    //   85: goto -> 42
    // Exception table:
    //   from	to	target	type
    //   2	37	78	finally
    //   42	75	78	finally
  }
  
  public void b(e parame) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: new android/content/ContentValues
    //   5: dup
    //   6: invokespecial <init> : ()V
    //   9: astore_3
    //   10: aload_3
    //   11: ldc 'id'
    //   13: aload_1
    //   14: invokevirtual a : ()Ljava/lang/String;
    //   17: invokevirtual put : (Ljava/lang/String;Ljava/lang/String;)V
    //   20: aload_3
    //   21: ldc 'url'
    //   23: aload_1
    //   24: invokevirtual b : ()Ljava/lang/String;
    //   27: invokevirtual put : (Ljava/lang/String;Ljava/lang/String;)V
    //   30: aload_1
    //   31: invokevirtual c : ()Z
    //   34: ifeq -> 97
    //   37: iconst_1
    //   38: istore_2
    //   39: goto -> 42
    //   42: aload_3
    //   43: ldc 'replaceholder'
    //   45: iload_2
    //   46: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   49: invokevirtual put : (Ljava/lang/String;Ljava/lang/Integer;)V
    //   52: aload_3
    //   53: ldc 'retry'
    //   55: aload_1
    //   56: invokevirtual d : ()I
    //   59: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   62: invokevirtual put : (Ljava/lang/String;Ljava/lang/Integer;)V
    //   65: aload_0
    //   66: getfield a : Landroid/content/Context;
    //   69: ldc 'trackurl'
    //   71: aload_3
    //   72: ldc 'id=?'
    //   74: iconst_1
    //   75: anewarray java/lang/String
    //   78: dup
    //   79: iconst_0
    //   80: aload_1
    //   81: invokevirtual a : ()Ljava/lang/String;
    //   84: aastore
    //   85: invokestatic a : (Landroid/content/Context;Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    //   88: pop
    //   89: aload_0
    //   90: monitorexit
    //   91: return
    //   92: astore_1
    //   93: aload_0
    //   94: monitorexit
    //   95: aload_1
    //   96: athrow
    //   97: iconst_0
    //   98: istore_2
    //   99: goto -> 42
    // Exception table:
    //   from	to	target	type
    //   2	37	92	finally
    //   42	89	92	finally
  }
  
  public void c(e parame) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield a : Landroid/content/Context;
    //   6: ldc 'trackurl'
    //   8: ldc 'id=?'
    //   10: iconst_1
    //   11: anewarray java/lang/String
    //   14: dup
    //   15: iconst_0
    //   16: aload_1
    //   17: invokevirtual a : ()Ljava/lang/String;
    //   20: aastore
    //   21: invokestatic a : (Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    //   24: pop
    //   25: aload_0
    //   26: monitorexit
    //   27: return
    //   28: astore_1
    //   29: aload_0
    //   30: monitorexit
    //   31: aload_1
    //   32: athrow
    // Exception table:
    //   from	to	target	type
    //   2	25	28	finally
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\openadsdk\j\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */