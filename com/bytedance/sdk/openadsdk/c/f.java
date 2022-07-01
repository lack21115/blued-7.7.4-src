package com.bytedance.sdk.openadsdk.c;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.d;
import com.bytedance.sdk.openadsdk.core.o;
import java.util.List;

public class f implements e<a> {
  private final Context a;
  
  private final d b;
  
  public f(Context paramContext) {
    this.a = paramContext;
    this.b = d.a(d());
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
    //   8: invokevirtual d : ()Landroid/content/Context;
    //   11: astore #6
    //   13: new java/lang/StringBuilder
    //   16: dup
    //   17: invokespecial <init> : ()V
    //   20: astore #7
    //   22: aload #7
    //   24: lload #4
    //   26: lload_2
    //   27: lsub
    //   28: invokevirtual append : (J)Ljava/lang/StringBuilder;
    //   31: pop
    //   32: aload #7
    //   34: ldc ''
    //   36: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   39: pop
    //   40: aload #7
    //   42: invokevirtual toString : ()Ljava/lang/String;
    //   45: astore #7
    //   47: new java/lang/StringBuilder
    //   50: dup
    //   51: invokespecial <init> : ()V
    //   54: astore #8
    //   56: aload #8
    //   58: iload_1
    //   59: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   62: pop
    //   63: aload #8
    //   65: ldc ''
    //   67: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   70: pop
    //   71: aload #6
    //   73: ldc 'adevent'
    //   75: ldc 'gen_time <? AND retry >?'
    //   77: iconst_2
    //   78: anewarray java/lang/String
    //   81: dup
    //   82: iconst_0
    //   83: aload #7
    //   85: aastore
    //   86: dup
    //   87: iconst_1
    //   88: aload #8
    //   90: invokevirtual toString : ()Ljava/lang/String;
    //   93: aastore
    //   94: invokestatic a : (Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    //   97: pop
    //   98: aload_0
    //   99: monitorexit
    //   100: return
    //   101: astore #6
    //   103: aload_0
    //   104: monitorexit
    //   105: aload #6
    //   107: athrow
    // Exception table:
    //   from	to	target	type
    //   2	98	101	finally
  }
  
  private void b(List<a> paramList) {
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
    //   33: checkcast com/bytedance/sdk/openadsdk/c/a
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
    //   64: ldc 'adevent'
    //   66: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   69: pop
    //   70: aload_1
    //   71: ldc ' SET '
    //   73: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   76: pop
    //   77: aload_1
    //   78: ldc 'retry'
    //   80: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   83: pop
    //   84: aload_1
    //   85: ldc ' = '
    //   87: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   90: pop
    //   91: aload_1
    //   92: ldc 'retry'
    //   94: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   97: pop
    //   98: aload_1
    //   99: ldc '+1'
    //   101: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   104: pop
    //   105: aload_1
    //   106: ldc ' WHERE '
    //   108: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   111: pop
    //   112: aload_1
    //   113: ldc 'id'
    //   115: aload_2
    //   116: sipush #1000
    //   119: iconst_1
    //   120: invokestatic a : (Ljava/lang/String;Ljava/util/List;IZ)Ljava/lang/String;
    //   123: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   126: pop
    //   127: aload_1
    //   128: invokevirtual toString : ()Ljava/lang/String;
    //   131: astore_1
    //   132: aload_0
    //   133: invokevirtual d : ()Landroid/content/Context;
    //   136: aload_1
    //   137: invokestatic a : (Landroid/content/Context;Ljava/lang/String;)V
    //   140: aload_0
    //   141: monitorexit
    //   142: return
    //   143: astore_1
    //   144: aload_0
    //   145: monitorexit
    //   146: aload_1
    //   147: athrow
    // Exception table:
    //   from	to	target	type
    //   2	17	143	finally
    //   17	45	143	finally
    //   48	140	143	finally
  }
  
  public static String e() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("CREATE TABLE IF NOT EXISTS ");
    stringBuilder.append("adevent");
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
  
  public List<a> a() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: new java/util/LinkedList
    //   5: dup
    //   6: invokespecial <init> : ()V
    //   9: astore_2
    //   10: aload_0
    //   11: invokevirtual d : ()Landroid/content/Context;
    //   14: ldc 'adevent'
    //   16: iconst_2
    //   17: anewarray java/lang/String
    //   20: dup
    //   21: iconst_0
    //   22: ldc 'id'
    //   24: aastore
    //   25: dup
    //   26: iconst_1
    //   27: ldc 'value'
    //   29: aastore
    //   30: aconst_null
    //   31: aconst_null
    //   32: aconst_null
    //   33: aconst_null
    //   34: aconst_null
    //   35: invokestatic a : (Landroid/content/Context;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   38: astore_1
    //   39: aload_1
    //   40: ifnull -> 136
    //   43: aload_1
    //   44: invokeinterface moveToNext : ()Z
    //   49: ifeq -> 110
    //   52: aload_1
    //   53: aload_1
    //   54: ldc 'id'
    //   56: invokeinterface getColumnIndex : (Ljava/lang/String;)I
    //   61: invokeinterface getString : (I)Ljava/lang/String;
    //   66: astore_3
    //   67: aload_1
    //   68: aload_1
    //   69: ldc 'value'
    //   71: invokeinterface getColumnIndex : (Ljava/lang/String;)I
    //   76: invokeinterface getString : (I)Ljava/lang/String;
    //   81: astore #4
    //   83: aload_2
    //   84: new com/bytedance/sdk/openadsdk/c/a
    //   87: dup
    //   88: aload_3
    //   89: new org/json/JSONObject
    //   92: dup
    //   93: aload #4
    //   95: invokespecial <init> : (Ljava/lang/String;)V
    //   98: invokespecial <init> : (Ljava/lang/String;Lorg/json/JSONObject;)V
    //   101: invokeinterface add : (Ljava/lang/Object;)Z
    //   106: pop
    //   107: goto -> 43
    //   110: aload_1
    //   111: ifnull -> 136
    //   114: aload_1
    //   115: invokeinterface close : ()V
    //   120: goto -> 136
    //   123: astore_2
    //   124: aload_1
    //   125: ifnull -> 134
    //   128: aload_1
    //   129: invokeinterface close : ()V
    //   134: aload_2
    //   135: athrow
    //   136: aload_0
    //   137: monitorexit
    //   138: aload_2
    //   139: areturn
    //   140: astore_1
    //   141: aload_0
    //   142: monitorexit
    //   143: aload_1
    //   144: athrow
    //   145: astore_3
    //   146: goto -> 43
    // Exception table:
    //   from	to	target	type
    //   2	39	140	finally
    //   43	83	123	finally
    //   83	107	145	org/json/JSONException
    //   83	107	123	finally
    //   114	120	140	finally
    //   128	134	140	finally
    //   134	136	140	finally
  }
  
  public void a(int paramInt) {
    this.b.a("serverbusy_retrycount", paramInt);
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
  
  public void a(a parama) {
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
    //   24: ifnull -> 85
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
    //   68: invokevirtual d : ()Landroid/content/Context;
    //   71: ldc 'adevent'
    //   73: aload_2
    //   74: invokestatic a : (Landroid/content/Context;Ljava/lang/String;Landroid/content/ContentValues;)V
    //   77: aload_0
    //   78: monitorexit
    //   79: return
    //   80: astore_1
    //   81: aload_0
    //   82: monitorexit
    //   83: aload_1
    //   84: athrow
    //   85: ldc ''
    //   87: astore_1
    //   88: goto -> 38
    // Exception table:
    //   from	to	target	type
    //   2	35	80	finally
    //   38	77	80	finally
  }
  
  public void a(List<a> paramList) {
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
    //   45: checkcast com/bytedance/sdk/openadsdk/c/a
    //   48: getfield a : Ljava/lang/String;
    //   51: invokeinterface add : (Ljava/lang/Object;)Z
    //   56: pop
    //   57: goto -> 29
    //   60: new java/lang/StringBuilder
    //   63: dup
    //   64: invokespecial <init> : ()V
    //   67: astore_1
    //   68: aload_1
    //   69: ldc_w 'DELETE FROM adevent WHERE '
    //   72: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   75: pop
    //   76: aload_1
    //   77: ldc 'id'
    //   79: aload_3
    //   80: sipush #1000
    //   83: iconst_1
    //   84: invokestatic a : (Ljava/lang/String;Ljava/util/List;IZ)Ljava/lang/String;
    //   87: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   90: pop
    //   91: aload_1
    //   92: invokevirtual toString : ()Ljava/lang/String;
    //   95: astore_1
    //   96: aload_0
    //   97: invokevirtual d : ()Landroid/content/Context;
    //   100: aload_1
    //   101: invokestatic a : (Landroid/content/Context;Ljava/lang/String;)V
    //   104: aload_0
    //   105: monitorexit
    //   106: return
    //   107: astore_1
    //   108: aload_0
    //   109: monitorexit
    //   110: aload_1
    //   111: athrow
    // Exception table:
    //   from	to	target	type
    //   2	7	107	finally
    //   14	29	107	finally
    //   29	57	107	finally
    //   60	104	107	finally
  }
  
  public void a(List<a> paramList, int paramInt, long paramLong) {
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
    this.b.a("serverbusy_flag", paramBoolean);
  }
  
  public boolean b() {
    return this.b.b("serverbusy_flag", false);
  }
  
  public int c() {
    return this.b.b("serverbusy_retrycount", 0);
  }
  
  public Context d() {
    Context context2 = this.a;
    Context context1 = context2;
    if (context2 == null)
      context1 = o.a(); 
    return context1;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\openadsdk\c\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */