package com.bytedance.sdk.openadsdk.c;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.d;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.f.b.c;
import java.util.List;

public class n implements e<c.a> {
  protected final d a;
  
  private final Context b;
  
  public n(Context paramContext) {
    this.b = paramContext;
    this.a = d.a(f());
  }
  
  private static String a(String paramString1, String paramString2) {
    return !TextUtils.isEmpty(paramString1) ? paramString1 : paramString2;
  }
  
  private static String a(String paramString, List<?> paramList, int paramInt, boolean paramBoolean) {
    String str2;
    String str3;
    if (paramBoolean) {
      str2 = " IN ";
    } else {
      str2 = " NOT IN ";
    } 
    if (paramBoolean) {
      str3 = " OR ";
    } else {
      str3 = " AND ";
    } 
    int j = Math.min(paramInt, 1000);
    int k = paramList.size();
    if (k % j == 0) {
      paramInt = k / j;
    } else {
      paramInt = k / j + 1;
    } 
    StringBuilder stringBuilder2 = new StringBuilder();
    int i;
    for (i = 0; i < paramInt; i++) {
      int m = i * j;
      String str = a(TextUtils.join("','", paramList.subList(m, Math.min(m + j, k))), "");
      if (i != 0)
        stringBuilder2.append(str3); 
      stringBuilder2.append(paramString);
      stringBuilder2.append(str2);
      stringBuilder2.append("('");
      stringBuilder2.append(str);
      stringBuilder2.append("')");
    } 
    String str1 = stringBuilder2.toString();
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append(paramString);
    stringBuilder1.append(str2);
    stringBuilder1.append("('')");
    return a(str1, stringBuilder1.toString());
  }
  
  private void b(int paramInt, long paramLong) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: invokestatic currentTimeMillis : ()J
    //   5: lstore #4
    //   7: aload_0
    //   8: invokevirtual f : ()Landroid/content/Context;
    //   11: astore #6
    //   13: aload_0
    //   14: invokevirtual d : ()Ljava/lang/String;
    //   17: astore #7
    //   19: new java/lang/StringBuilder
    //   22: dup
    //   23: invokespecial <init> : ()V
    //   26: astore #8
    //   28: aload #8
    //   30: lload #4
    //   32: lload_2
    //   33: lsub
    //   34: invokevirtual append : (J)Ljava/lang/StringBuilder;
    //   37: pop
    //   38: aload #8
    //   40: ldc ''
    //   42: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   45: pop
    //   46: aload #8
    //   48: invokevirtual toString : ()Ljava/lang/String;
    //   51: astore #8
    //   53: new java/lang/StringBuilder
    //   56: dup
    //   57: invokespecial <init> : ()V
    //   60: astore #9
    //   62: aload #9
    //   64: iload_1
    //   65: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   68: pop
    //   69: aload #9
    //   71: ldc ''
    //   73: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   76: pop
    //   77: aload #6
    //   79: aload #7
    //   81: ldc 'gen_time <? AND retry >?'
    //   83: iconst_2
    //   84: anewarray java/lang/String
    //   87: dup
    //   88: iconst_0
    //   89: aload #8
    //   91: aastore
    //   92: dup
    //   93: iconst_1
    //   94: aload #9
    //   96: invokevirtual toString : ()Ljava/lang/String;
    //   99: aastore
    //   100: invokestatic a : (Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    //   103: pop
    //   104: aload_0
    //   105: monitorexit
    //   106: return
    //   107: astore #6
    //   109: aload_0
    //   110: monitorexit
    //   111: aload #6
    //   113: athrow
    // Exception table:
    //   from	to	target	type
    //   2	104	107	finally
  }
  
  private void b(List<c.a> paramList) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: new java/util/LinkedList
    //   5: dup
    //   6: invokespecial <init> : ()V
    //   9: astore_2
    //   10: aload_1
    //   11: invokeinterface iterator : ()Ljava/util/Iterator;
    //   16: astore_1
    //   17: aload_1
    //   18: invokeinterface hasNext : ()Z
    //   23: ifeq -> 48
    //   26: aload_2
    //   27: aload_1
    //   28: invokeinterface next : ()Ljava/lang/Object;
    //   33: checkcast com/bytedance/sdk/openadsdk/f/b/c$a
    //   36: getfield a : Ljava/lang/String;
    //   39: invokeinterface add : (Ljava/lang/Object;)Z
    //   44: pop
    //   45: goto -> 17
    //   48: new java/lang/StringBuilder
    //   51: dup
    //   52: invokespecial <init> : ()V
    //   55: astore_1
    //   56: aload_1
    //   57: ldc 'UPDATE '
    //   59: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   62: pop
    //   63: aload_1
    //   64: aload_0
    //   65: invokevirtual d : ()Ljava/lang/String;
    //   68: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   71: pop
    //   72: aload_1
    //   73: ldc ' SET '
    //   75: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   78: pop
    //   79: aload_1
    //   80: ldc 'retry'
    //   82: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   85: pop
    //   86: aload_1
    //   87: ldc ' = '
    //   89: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   92: pop
    //   93: aload_1
    //   94: ldc 'retry'
    //   96: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   99: pop
    //   100: aload_1
    //   101: ldc '+1'
    //   103: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   106: pop
    //   107: aload_1
    //   108: ldc ' WHERE '
    //   110: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   113: pop
    //   114: aload_1
    //   115: ldc 'id'
    //   117: aload_2
    //   118: sipush #1000
    //   121: iconst_1
    //   122: invokestatic a : (Ljava/lang/String;Ljava/util/List;IZ)Ljava/lang/String;
    //   125: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   128: pop
    //   129: aload_1
    //   130: invokevirtual toString : ()Ljava/lang/String;
    //   133: astore_1
    //   134: aload_0
    //   135: invokevirtual f : ()Landroid/content/Context;
    //   138: aload_1
    //   139: invokestatic a : (Landroid/content/Context;Ljava/lang/String;)V
    //   142: aload_0
    //   143: monitorexit
    //   144: return
    //   145: astore_1
    //   146: aload_0
    //   147: monitorexit
    //   148: aload_1
    //   149: athrow
    // Exception table:
    //   from	to	target	type
    //   2	17	145	finally
    //   17	45	145	finally
    //   48	142	145	finally
  }
  
  public static String g() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("CREATE TABLE IF NOT EXISTS ");
    stringBuilder.append("logstats");
    stringBuilder.append(" (_id INTEGER PRIMARY KEY AUTOINCREMENT,");
    stringBuilder.append("id");
    stringBuilder.append(" TEXT UNIQUE,");
    stringBuilder.append("value");
    stringBuilder.append(" TEXT ,");
    stringBuilder.append("gen_time");
    stringBuilder.append(" TEXT , ");
    stringBuilder.append("retry");
    stringBuilder.append(" INTEGER default 0");
    stringBuilder.append(")");
    return stringBuilder.toString();
  }
  
  public List<c.a> a() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: new java/util/LinkedList
    //   5: dup
    //   6: invokespecial <init> : ()V
    //   9: astore_2
    //   10: aload_0
    //   11: invokevirtual f : ()Landroid/content/Context;
    //   14: aload_0
    //   15: invokevirtual d : ()Ljava/lang/String;
    //   18: iconst_2
    //   19: anewarray java/lang/String
    //   22: dup
    //   23: iconst_0
    //   24: ldc 'id'
    //   26: aastore
    //   27: dup
    //   28: iconst_1
    //   29: ldc 'value'
    //   31: aastore
    //   32: aconst_null
    //   33: aconst_null
    //   34: aconst_null
    //   35: aconst_null
    //   36: aconst_null
    //   37: invokestatic a : (Landroid/content/Context;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   40: astore_1
    //   41: aload_1
    //   42: ifnull -> 138
    //   45: aload_1
    //   46: invokeinterface moveToNext : ()Z
    //   51: ifeq -> 112
    //   54: aload_1
    //   55: aload_1
    //   56: ldc 'id'
    //   58: invokeinterface getColumnIndex : (Ljava/lang/String;)I
    //   63: invokeinterface getString : (I)Ljava/lang/String;
    //   68: astore_3
    //   69: aload_1
    //   70: aload_1
    //   71: ldc 'value'
    //   73: invokeinterface getColumnIndex : (Ljava/lang/String;)I
    //   78: invokeinterface getString : (I)Ljava/lang/String;
    //   83: astore #4
    //   85: aload_2
    //   86: new com/bytedance/sdk/openadsdk/f/b/c$a
    //   89: dup
    //   90: aload_3
    //   91: new org/json/JSONObject
    //   94: dup
    //   95: aload #4
    //   97: invokespecial <init> : (Ljava/lang/String;)V
    //   100: invokespecial <init> : (Ljava/lang/String;Lorg/json/JSONObject;)V
    //   103: invokeinterface add : (Ljava/lang/Object;)Z
    //   108: pop
    //   109: goto -> 45
    //   112: aload_1
    //   113: ifnull -> 138
    //   116: aload_1
    //   117: invokeinterface close : ()V
    //   122: goto -> 138
    //   125: astore_2
    //   126: aload_1
    //   127: ifnull -> 136
    //   130: aload_1
    //   131: invokeinterface close : ()V
    //   136: aload_2
    //   137: athrow
    //   138: aload_0
    //   139: monitorexit
    //   140: aload_2
    //   141: areturn
    //   142: astore_1
    //   143: aload_0
    //   144: monitorexit
    //   145: aload_1
    //   146: athrow
    //   147: astore_3
    //   148: goto -> 45
    // Exception table:
    //   from	to	target	type
    //   2	41	142	finally
    //   45	85	125	finally
    //   85	109	147	org/json/JSONException
    //   85	109	125	finally
    //   116	122	142	finally
    //   130	136	142	finally
    //   136	138	142	finally
  }
  
  public void a(int paramInt) {
    this.a.a("stats_serverbusy_retrycount", paramInt);
  }
  
  public void a(int paramInt, long paramLong) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: iload_1
    //   4: lload_2
    //   5: invokespecial b : (IJ)V
    //   8: aload_0
    //   9: monitorexit
    //   10: return
    //   11: astore #4
    //   13: aload_0
    //   14: monitorexit
    //   15: aload #4
    //   17: athrow
    // Exception table:
    //   from	to	target	type
    //   2	8	11	finally
  }
  
  public void a(c.a parama) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: new android/content/ContentValues
    //   5: dup
    //   6: invokespecial <init> : ()V
    //   9: astore_2
    //   10: aload_2
    //   11: ldc 'id'
    //   13: aload_1
    //   14: getfield a : Ljava/lang/String;
    //   17: invokevirtual put : (Ljava/lang/String;Ljava/lang/String;)V
    //   20: aload_1
    //   21: getfield b : Lorg/json/JSONObject;
    //   24: ifnull -> 87
    //   27: aload_1
    //   28: getfield b : Lorg/json/JSONObject;
    //   31: invokevirtual toString : ()Ljava/lang/String;
    //   34: astore_1
    //   35: goto -> 38
    //   38: aload_2
    //   39: ldc 'value'
    //   41: aload_1
    //   42: invokevirtual put : (Ljava/lang/String;Ljava/lang/String;)V
    //   45: aload_2
    //   46: ldc 'gen_time'
    //   48: invokestatic currentTimeMillis : ()J
    //   51: invokestatic valueOf : (J)Ljava/lang/Long;
    //   54: invokevirtual put : (Ljava/lang/String;Ljava/lang/Long;)V
    //   57: aload_2
    //   58: ldc 'retry'
    //   60: iconst_0
    //   61: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   64: invokevirtual put : (Ljava/lang/String;Ljava/lang/Integer;)V
    //   67: aload_0
    //   68: invokevirtual f : ()Landroid/content/Context;
    //   71: aload_0
    //   72: invokevirtual d : ()Ljava/lang/String;
    //   75: aload_2
    //   76: invokestatic a : (Landroid/content/Context;Ljava/lang/String;Landroid/content/ContentValues;)V
    //   79: aload_0
    //   80: monitorexit
    //   81: return
    //   82: astore_1
    //   83: aload_0
    //   84: monitorexit
    //   85: aload_1
    //   86: athrow
    //   87: ldc ''
    //   89: astore_1
    //   90: goto -> 38
    // Exception table:
    //   from	to	target	type
    //   2	35	82	finally
    //   38	79	82	finally
  }
  
  public void a(List<c.a> paramList) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: invokestatic a : (Ljava/util/List;)Z
    //   6: istore_2
    //   7: iload_2
    //   8: ifeq -> 14
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: new java/util/LinkedList
    //   17: dup
    //   18: invokespecial <init> : ()V
    //   21: astore_3
    //   22: aload_1
    //   23: invokeinterface iterator : ()Ljava/util/Iterator;
    //   28: astore_1
    //   29: aload_1
    //   30: invokeinterface hasNext : ()Z
    //   35: ifeq -> 60
    //   38: aload_3
    //   39: aload_1
    //   40: invokeinterface next : ()Ljava/lang/Object;
    //   45: checkcast com/bytedance/sdk/openadsdk/f/b/c$a
    //   48: getfield a : Ljava/lang/String;
    //   51: invokeinterface add : (Ljava/lang/Object;)Z
    //   56: pop
    //   57: goto -> 29
    //   60: new java/lang/StringBuilder
    //   63: dup
    //   64: invokespecial <init> : ()V
    //   67: astore_1
    //   68: aload_1
    //   69: ldc_w 'DELETE FROM '
    //   72: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   75: pop
    //   76: aload_1
    //   77: aload_0
    //   78: invokevirtual d : ()Ljava/lang/String;
    //   81: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   84: pop
    //   85: aload_1
    //   86: ldc ' WHERE '
    //   88: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   91: pop
    //   92: aload_1
    //   93: ldc 'id'
    //   95: aload_3
    //   96: sipush #1000
    //   99: iconst_1
    //   100: invokestatic a : (Ljava/lang/String;Ljava/util/List;IZ)Ljava/lang/String;
    //   103: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   106: pop
    //   107: aload_1
    //   108: invokevirtual toString : ()Ljava/lang/String;
    //   111: astore_1
    //   112: aload_0
    //   113: invokevirtual f : ()Landroid/content/Context;
    //   116: aload_1
    //   117: invokestatic a : (Landroid/content/Context;Ljava/lang/String;)V
    //   120: aload_0
    //   121: monitorexit
    //   122: return
    //   123: astore_1
    //   124: aload_0
    //   125: monitorexit
    //   126: aload_1
    //   127: athrow
    // Exception table:
    //   from	to	target	type
    //   2	7	123	finally
    //   14	29	123	finally
    //   29	57	123	finally
    //   60	120	123	finally
  }
  
  public void a(List<c.a> paramList, int paramInt, long paramLong) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: invokestatic a : (Ljava/util/List;)Z
    //   6: istore #5
    //   8: iload #5
    //   10: ifeq -> 16
    //   13: aload_0
    //   14: monitorexit
    //   15: return
    //   16: aload_0
    //   17: aload_1
    //   18: invokespecial b : (Ljava/util/List;)V
    //   21: aload_0
    //   22: iload_2
    //   23: lload_3
    //   24: invokespecial b : (IJ)V
    //   27: aload_0
    //   28: monitorexit
    //   29: return
    //   30: astore_1
    //   31: aload_0
    //   32: monitorexit
    //   33: aload_1
    //   34: athrow
    //   35: astore_1
    //   36: goto -> 27
    // Exception table:
    //   from	to	target	type
    //   2	8	30	finally
    //   16	27	35	java/lang/Exception
    //   16	27	30	finally
  }
  
  public void a(boolean paramBoolean) {
    this.a.a("stats_serverbusy_flag", paramBoolean);
  }
  
  public boolean b() {
    return this.a.b("stats_serverbusy_flag", false);
  }
  
  public int c() {
    return this.a.b("stats_serverbusy_retrycount", 0);
  }
  
  public String d() {
    return "logstats";
  }
  
  public Context f() {
    Context context2 = this.b;
    Context context1 = context2;
    if (context2 == null)
      context1 = o.a(); 
    return context1;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\openadsdk\c\n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */