package com.alipay.sdk.app.statistic;

import android.content.Context;
import com.alipay.sdk.util.j;
import java.util.LinkedHashMap;
import org.json.JSONArray;

public class a {
  public static void a(Context paramContext) {
    // Byte code:
    //   0: ldc com/alipay/sdk/app/statistic/a
    //   2: monitorenter
    //   3: aload_0
    //   4: invokestatic a : (Landroid/content/Context;)V
    //   7: ldc com/alipay/sdk/app/statistic/a
    //   9: monitorexit
    //   10: return
    //   11: astore_0
    //   12: ldc com/alipay/sdk/app/statistic/a
    //   14: monitorexit
    //   15: aload_0
    //   16: athrow
    // Exception table:
    //   from	to	target	type
    //   3	7	11	finally
  }
  
  public static void a(Context paramContext, com.alipay.sdk.sys.a parama, String paramString1, String paramString2) {
    // Byte code:
    //   0: ldc com/alipay/sdk/app/statistic/a
    //   2: monitorenter
    //   3: aload_0
    //   4: ifnull -> 46
    //   7: aload_1
    //   8: ifnonnull -> 14
    //   11: goto -> 46
    //   14: aload_0
    //   15: aload_1
    //   16: getfield s : Lcom/alipay/sdk/app/statistic/c;
    //   19: aload_2
    //   20: invokevirtual a : (Ljava/lang/String;)Ljava/lang/String;
    //   23: aload_3
    //   24: invokestatic a : (Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   27: pop
    //   28: goto -> 36
    //   31: astore_0
    //   32: aload_0
    //   33: invokestatic a : (Ljava/lang/Throwable;)V
    //   36: ldc com/alipay/sdk/app/statistic/a
    //   38: monitorexit
    //   39: return
    //   40: astore_0
    //   41: ldc com/alipay/sdk/app/statistic/a
    //   43: monitorexit
    //   44: aload_0
    //   45: athrow
    //   46: ldc com/alipay/sdk/app/statistic/a
    //   48: monitorexit
    //   49: return
    // Exception table:
    //   from	to	target	type
    //   14	28	31	finally
    //   32	36	40	finally
  }
  
  public static void a(com.alipay.sdk.sys.a parama, String paramString1, String paramString2) {
    if (parama == null)
      return; 
    parama.s.a(paramString1, paramString2);
  }
  
  public static void a(com.alipay.sdk.sys.a parama, String paramString1, String paramString2, String paramString3) {
    if (parama == null)
      return; 
    parama.s.a(paramString1, paramString2, paramString3);
  }
  
  public static void a(com.alipay.sdk.sys.a parama, String paramString1, String paramString2, Throwable paramThrowable) {
    if (parama == null)
      return; 
    parama.s.a(paramString1, paramString2, paramThrowable);
  }
  
  public static void a(com.alipay.sdk.sys.a parama, String paramString1, String paramString2, Throwable paramThrowable, String paramString3) {
    if (parama == null)
      return; 
    parama.s.a(paramString1, paramString2, paramThrowable, paramString3);
  }
  
  public static void a(com.alipay.sdk.sys.a parama, String paramString, Throwable paramThrowable) {
    if (parama != null && paramThrowable != null) {
      if (paramThrowable.getClass() == null)
        return; 
      parama.s.a(paramString, paramThrowable.getClass().getSimpleName(), paramThrowable);
    } 
  }
  
  public static void b(Context paramContext, com.alipay.sdk.sys.a parama, String paramString1, String paramString2) {
    // Byte code:
    //   0: ldc com/alipay/sdk/app/statistic/a
    //   2: monitorenter
    //   3: aload_0
    //   4: ifnull -> 34
    //   7: aload_1
    //   8: ifnonnull -> 14
    //   11: goto -> 34
    //   14: aload_0
    //   15: aload_1
    //   16: getfield s : Lcom/alipay/sdk/app/statistic/c;
    //   19: aload_2
    //   20: aload_3
    //   21: invokestatic a : (Landroid/content/Context;Lcom/alipay/sdk/app/statistic/c;Ljava/lang/String;Ljava/lang/String;)V
    //   24: ldc com/alipay/sdk/app/statistic/a
    //   26: monitorexit
    //   27: return
    //   28: astore_0
    //   29: ldc com/alipay/sdk/app/statistic/a
    //   31: monitorexit
    //   32: aload_0
    //   33: athrow
    //   34: ldc com/alipay/sdk/app/statistic/a
    //   36: monitorexit
    //   37: return
    // Exception table:
    //   from	to	target	type
    //   14	24	28	finally
  }
  
  public static void b(com.alipay.sdk.sys.a parama, String paramString1, String paramString2, String paramString3) {
    if (parama == null)
      return; 
    parama.s.b(paramString1, paramString2, paramString3);
  }
  
  static final class a {
    private static final String a = "RecordPref";
    
    private static final String b = "alipay_cashier_statistic_record";
    
    static int a(Context param1Context, String param1String) {
      // Byte code:
      //   0: ldc com/alipay/sdk/app/statistic/a$a
      //   2: monitorenter
      //   3: new java/lang/StringBuilder
      //   6: dup
      //   7: invokespecial <init> : ()V
      //   10: astore #4
      //   12: aload #4
      //   14: ldc 'stat remove '
      //   16: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   19: pop
      //   20: aload #4
      //   22: aload_1
      //   23: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   26: pop
      //   27: ldc 'RecordPref'
      //   29: aload #4
      //   31: invokevirtual toString : ()Ljava/lang/String;
      //   34: invokestatic a : (Ljava/lang/String;Ljava/lang/String;)V
      //   37: aload_0
      //   38: ifnull -> 238
      //   41: aload_1
      //   42: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
      //   45: ifeq -> 51
      //   48: goto -> 238
      //   51: aload_0
      //   52: invokestatic b : (Landroid/content/Context;)Lcom/alipay/sdk/app/statistic/a$a$a;
      //   55: astore #4
      //   57: aload #4
      //   59: getfield a : Ljava/util/LinkedHashMap;
      //   62: invokevirtual isEmpty : ()Z
      //   65: istore_3
      //   66: iload_3
      //   67: ifeq -> 75
      //   70: ldc com/alipay/sdk/app/statistic/a$a
      //   72: monitorexit
      //   73: iconst_0
      //   74: ireturn
      //   75: new java/util/ArrayList
      //   78: dup
      //   79: invokespecial <init> : ()V
      //   82: astore #5
      //   84: aload #4
      //   86: getfield a : Ljava/util/LinkedHashMap;
      //   89: invokevirtual entrySet : ()Ljava/util/Set;
      //   92: invokeinterface iterator : ()Ljava/util/Iterator;
      //   97: astore #6
      //   99: aload #6
      //   101: invokeinterface hasNext : ()Z
      //   106: ifeq -> 151
      //   109: aload #6
      //   111: invokeinterface next : ()Ljava/lang/Object;
      //   116: checkcast java/util/Map$Entry
      //   119: astore #7
      //   121: aload_1
      //   122: aload #7
      //   124: invokeinterface getValue : ()Ljava/lang/Object;
      //   129: invokevirtual equals : (Ljava/lang/Object;)Z
      //   132: ifeq -> 99
      //   135: aload #5
      //   137: aload #7
      //   139: invokeinterface getKey : ()Ljava/lang/Object;
      //   144: invokevirtual add : (Ljava/lang/Object;)Z
      //   147: pop
      //   148: goto -> 99
      //   151: aload #5
      //   153: invokevirtual iterator : ()Ljava/util/Iterator;
      //   156: astore_1
      //   157: aload_1
      //   158: invokeinterface hasNext : ()Z
      //   163: ifeq -> 191
      //   166: aload_1
      //   167: invokeinterface next : ()Ljava/lang/Object;
      //   172: checkcast java/lang/String
      //   175: astore #6
      //   177: aload #4
      //   179: getfield a : Ljava/util/LinkedHashMap;
      //   182: aload #6
      //   184: invokevirtual remove : (Ljava/lang/Object;)Ljava/lang/Object;
      //   187: pop
      //   188: goto -> 157
      //   191: aload_0
      //   192: aload #4
      //   194: invokestatic a : (Landroid/content/Context;Lcom/alipay/sdk/app/statistic/a$a$a;)V
      //   197: aload #5
      //   199: invokevirtual size : ()I
      //   202: istore_2
      //   203: ldc com/alipay/sdk/app/statistic/a$a
      //   205: monitorexit
      //   206: iload_2
      //   207: ireturn
      //   208: astore_1
      //   209: aload_1
      //   210: invokestatic a : (Ljava/lang/Throwable;)V
      //   213: aload #4
      //   215: getfield a : Ljava/util/LinkedHashMap;
      //   218: invokevirtual size : ()I
      //   221: istore_2
      //   222: aload_0
      //   223: new com/alipay/sdk/app/statistic/a$a$a
      //   226: dup
      //   227: invokespecial <init> : ()V
      //   230: invokestatic a : (Landroid/content/Context;Lcom/alipay/sdk/app/statistic/a$a$a;)V
      //   233: ldc com/alipay/sdk/app/statistic/a$a
      //   235: monitorexit
      //   236: iload_2
      //   237: ireturn
      //   238: ldc com/alipay/sdk/app/statistic/a$a
      //   240: monitorexit
      //   241: iconst_0
      //   242: ireturn
      //   243: astore_0
      //   244: ldc com/alipay/sdk/app/statistic/a$a
      //   246: monitorexit
      //   247: aload_0
      //   248: athrow
      // Exception table:
      //   from	to	target	type
      //   3	37	243	finally
      //   41	48	243	finally
      //   51	66	243	finally
      //   75	99	208	finally
      //   99	148	208	finally
      //   151	157	208	finally
      //   157	188	208	finally
      //   191	203	208	finally
      //   209	233	243	finally
    }
    
    static String a(Context param1Context) {
      // Byte code:
      //   0: ldc com/alipay/sdk/app/statistic/a$a
      //   2: monitorenter
      //   3: ldc 'RecordPref'
      //   5: ldc 'stat peek'
      //   7: invokestatic a : (Ljava/lang/String;Ljava/lang/String;)V
      //   10: aload_0
      //   11: ifnonnull -> 19
      //   14: ldc com/alipay/sdk/app/statistic/a$a
      //   16: monitorexit
      //   17: aconst_null
      //   18: areturn
      //   19: aload_0
      //   20: invokestatic b : (Landroid/content/Context;)Lcom/alipay/sdk/app/statistic/a$a$a;
      //   23: astore_0
      //   24: aload_0
      //   25: getfield a : Ljava/util/LinkedHashMap;
      //   28: invokevirtual isEmpty : ()Z
      //   31: istore_1
      //   32: iload_1
      //   33: ifeq -> 41
      //   36: ldc com/alipay/sdk/app/statistic/a$a
      //   38: monitorexit
      //   39: aconst_null
      //   40: areturn
      //   41: aload_0
      //   42: getfield a : Ljava/util/LinkedHashMap;
      //   45: invokevirtual entrySet : ()Ljava/util/Set;
      //   48: invokeinterface iterator : ()Ljava/util/Iterator;
      //   53: invokeinterface next : ()Ljava/lang/Object;
      //   58: checkcast java/util/Map$Entry
      //   61: invokeinterface getValue : ()Ljava/lang/Object;
      //   66: checkcast java/lang/String
      //   69: astore_0
      //   70: ldc com/alipay/sdk/app/statistic/a$a
      //   72: monitorexit
      //   73: aload_0
      //   74: areturn
      //   75: astore_0
      //   76: aload_0
      //   77: invokestatic a : (Ljava/lang/Throwable;)V
      //   80: ldc com/alipay/sdk/app/statistic/a$a
      //   82: monitorexit
      //   83: aconst_null
      //   84: areturn
      //   85: astore_0
      //   86: ldc com/alipay/sdk/app/statistic/a$a
      //   88: monitorexit
      //   89: aload_0
      //   90: athrow
      // Exception table:
      //   from	to	target	type
      //   3	10	85	finally
      //   19	32	85	finally
      //   41	70	75	finally
      //   76	80	85	finally
    }
    
    static String a(Context param1Context, String param1String1, String param1String2) {
      // Byte code:
      //   0: ldc com/alipay/sdk/app/statistic/a$a
      //   2: monitorenter
      //   3: new java/lang/StringBuilder
      //   6: dup
      //   7: invokespecial <init> : ()V
      //   10: astore_3
      //   11: aload_3
      //   12: ldc 'stat append '
      //   14: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   17: pop
      //   18: aload_3
      //   19: aload_2
      //   20: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   23: pop
      //   24: aload_3
      //   25: ldc ' , '
      //   27: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   30: pop
      //   31: aload_3
      //   32: aload_1
      //   33: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   36: pop
      //   37: ldc 'RecordPref'
      //   39: aload_3
      //   40: invokevirtual toString : ()Ljava/lang/String;
      //   43: invokestatic a : (Ljava/lang/String;Ljava/lang/String;)V
      //   46: aload_0
      //   47: ifnull -> 120
      //   50: aload_1
      //   51: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
      //   54: ifeq -> 60
      //   57: goto -> 120
      //   60: aload_2
      //   61: astore_3
      //   62: aload_2
      //   63: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
      //   66: ifeq -> 76
      //   69: invokestatic randomUUID : ()Ljava/util/UUID;
      //   72: invokevirtual toString : ()Ljava/lang/String;
      //   75: astore_3
      //   76: aload_0
      //   77: invokestatic b : (Landroid/content/Context;)Lcom/alipay/sdk/app/statistic/a$a$a;
      //   80: astore_2
      //   81: aload_2
      //   82: getfield a : Ljava/util/LinkedHashMap;
      //   85: invokevirtual size : ()I
      //   88: bipush #20
      //   90: if_icmple -> 100
      //   93: aload_2
      //   94: getfield a : Ljava/util/LinkedHashMap;
      //   97: invokevirtual clear : ()V
      //   100: aload_2
      //   101: getfield a : Ljava/util/LinkedHashMap;
      //   104: aload_3
      //   105: aload_1
      //   106: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   109: pop
      //   110: aload_0
      //   111: aload_2
      //   112: invokestatic a : (Landroid/content/Context;Lcom/alipay/sdk/app/statistic/a$a$a;)V
      //   115: ldc com/alipay/sdk/app/statistic/a$a
      //   117: monitorexit
      //   118: aload_3
      //   119: areturn
      //   120: ldc com/alipay/sdk/app/statistic/a$a
      //   122: monitorexit
      //   123: aconst_null
      //   124: areturn
      //   125: astore_0
      //   126: ldc com/alipay/sdk/app/statistic/a$a
      //   128: monitorexit
      //   129: aload_0
      //   130: athrow
      // Exception table:
      //   from	to	target	type
      //   3	46	125	finally
      //   50	57	125	finally
      //   62	76	125	finally
      //   76	100	125	finally
      //   100	115	125	finally
    }
    
    private static void a(Context param1Context, a param1a) {
      // Byte code:
      //   0: ldc com/alipay/sdk/app/statistic/a$a
      //   2: monitorenter
      //   3: aload_1
      //   4: astore_2
      //   5: aload_1
      //   6: ifnonnull -> 20
      //   9: new com/alipay/sdk/app/statistic/a$a$a
      //   12: dup
      //   13: invokespecial <init> : ()V
      //   16: astore_2
      //   17: goto -> 20
      //   20: aconst_null
      //   21: aload_0
      //   22: ldc 'alipay_cashier_statistic_record'
      //   24: aload_2
      //   25: invokevirtual a : ()Ljava/lang/String;
      //   28: invokestatic a : (Lcom/alipay/sdk/sys/a;Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V
      //   31: goto -> 38
      //   34: aload_0
      //   35: invokestatic a : (Ljava/lang/Throwable;)V
      //   38: ldc com/alipay/sdk/app/statistic/a$a
      //   40: monitorexit
      //   41: return
      //   42: astore_0
      //   43: ldc com/alipay/sdk/app/statistic/a$a
      //   45: monitorexit
      //   46: aload_0
      //   47: athrow
      //   48: astore_0
      //   49: goto -> 34
      // Exception table:
      //   from	to	target	type
      //   9	17	48	finally
      //   20	31	48	finally
      //   34	38	42	finally
    }
    
    private static a b(Context param1Context) {
      // Byte code:
      //   0: ldc com/alipay/sdk/app/statistic/a$a
      //   2: monitorenter
      //   3: aconst_null
      //   4: aload_0
      //   5: ldc 'alipay_cashier_statistic_record'
      //   7: aconst_null
      //   8: invokestatic b : (Lcom/alipay/sdk/sys/a;Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
      //   11: astore_0
      //   12: aload_0
      //   13: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
      //   16: ifeq -> 32
      //   19: new com/alipay/sdk/app/statistic/a$a$a
      //   22: dup
      //   23: invokespecial <init> : ()V
      //   26: astore_0
      //   27: ldc com/alipay/sdk/app/statistic/a$a
      //   29: monitorexit
      //   30: aload_0
      //   31: areturn
      //   32: new com/alipay/sdk/app/statistic/a$a$a
      //   35: dup
      //   36: aload_0
      //   37: invokespecial <init> : (Ljava/lang/String;)V
      //   40: astore_0
      //   41: ldc com/alipay/sdk/app/statistic/a$a
      //   43: monitorexit
      //   44: aload_0
      //   45: areturn
      //   46: astore_0
      //   47: aload_0
      //   48: invokestatic a : (Ljava/lang/Throwable;)V
      //   51: new com/alipay/sdk/app/statistic/a$a$a
      //   54: dup
      //   55: invokespecial <init> : ()V
      //   58: astore_0
      //   59: ldc com/alipay/sdk/app/statistic/a$a
      //   61: monitorexit
      //   62: aload_0
      //   63: areturn
      //   64: astore_0
      //   65: ldc com/alipay/sdk/app/statistic/a$a
      //   67: monitorexit
      //   68: aload_0
      //   69: athrow
      // Exception table:
      //   from	to	target	type
      //   3	27	46	finally
      //   32	41	46	finally
      //   47	59	64	finally
    }
    
    static final class a {
      final LinkedHashMap<String, String> a = new LinkedHashMap<String, String>();
      
      a() {}
      
      a(String param2String) {
        try {
          int i;
          JSONArray jSONArray = new JSONArray(param2String);
        } finally {
          param2String = null;
        } 
      }
      
      String a() {
        try {
          return jSONArray.toString();
        } finally {
          Exception exception = null;
          com.alipay.sdk.util.c.a(exception);
        } 
      }
    }
  }
  
  static final class a {
    final LinkedHashMap<String, String> a = new LinkedHashMap<String, String>();
    
    a() {}
    
    a(String param1String) {
      try {
        int i;
        JSONArray jSONArray = new JSONArray(param1String);
      } finally {
        param1String = null;
      } 
    }
    
    String a() {
      try {
        return jSONArray.toString();
      } finally {
        Exception exception = null;
        com.alipay.sdk.util.c.a(exception);
      } 
    }
  }
  
  static final class b {
    static void a(Context param1Context) {
      // Byte code:
      //   0: ldc com/alipay/sdk/app/statistic/a$b
      //   2: monitorenter
      //   3: aload_0
      //   4: aconst_null
      //   5: aconst_null
      //   6: invokestatic a : (Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V
      //   9: ldc com/alipay/sdk/app/statistic/a$b
      //   11: monitorexit
      //   12: return
      //   13: astore_0
      //   14: ldc com/alipay/sdk/app/statistic/a$b
      //   16: monitorexit
      //   17: aload_0
      //   18: athrow
      // Exception table:
      //   from	to	target	type
      //   3	9	13	finally
    }
    
    static void a(Context param1Context, c param1c, String param1String1, String param1String2) {
      // Byte code:
      //   0: ldc com/alipay/sdk/app/statistic/a$b
      //   2: monitorenter
      //   3: aload_0
      //   4: ifnull -> 38
      //   7: aload_1
      //   8: ifnull -> 38
      //   11: aload_2
      //   12: ifnonnull -> 18
      //   15: goto -> 38
      //   18: aload_0
      //   19: aload_1
      //   20: aload_2
      //   21: invokevirtual a : (Ljava/lang/String;)Ljava/lang/String;
      //   24: aload_3
      //   25: invokestatic a : (Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V
      //   28: ldc com/alipay/sdk/app/statistic/a$b
      //   30: monitorexit
      //   31: return
      //   32: astore_0
      //   33: ldc com/alipay/sdk/app/statistic/a$b
      //   35: monitorexit
      //   36: aload_0
      //   37: athrow
      //   38: ldc com/alipay/sdk/app/statistic/a$b
      //   40: monitorexit
      //   41: return
      // Exception table:
      //   from	to	target	type
      //   18	28	32	finally
    }
    
    private static void a(Context param1Context, String param1String1, String param1String2) {
      // Byte code:
      //   0: ldc com/alipay/sdk/app/statistic/a$b
      //   2: monitorenter
      //   3: aload_0
      //   4: ifnonnull -> 11
      //   7: ldc com/alipay/sdk/app/statistic/a$b
      //   9: monitorexit
      //   10: return
      //   11: aload_1
      //   12: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
      //   15: ifne -> 25
      //   18: aload_0
      //   19: aload_1
      //   20: aload_2
      //   21: invokestatic a : (Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
      //   24: pop
      //   25: new java/lang/Thread
      //   28: dup
      //   29: new com/alipay/sdk/app/statistic/b
      //   32: dup
      //   33: aload_1
      //   34: aload_0
      //   35: invokespecial <init> : (Ljava/lang/String;Landroid/content/Context;)V
      //   38: invokespecial <init> : (Ljava/lang/Runnable;)V
      //   41: invokevirtual start : ()V
      //   44: ldc com/alipay/sdk/app/statistic/a$b
      //   46: monitorexit
      //   47: return
      //   48: astore_0
      //   49: ldc com/alipay/sdk/app/statistic/a$b
      //   51: monitorexit
      //   52: aload_0
      //   53: athrow
      // Exception table:
      //   from	to	target	type
      //   11	25	48	finally
      //   25	44	48	finally
    }
    
    private static boolean b(Context param1Context, String param1String) {
      // Byte code:
      //   0: ldc com/alipay/sdk/app/statistic/a$b
      //   2: monitorenter
      //   3: new java/lang/StringBuilder
      //   6: dup
      //   7: invokespecial <init> : ()V
      //   10: astore_2
      //   11: aload_2
      //   12: ldc 'stat sub '
      //   14: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   17: pop
      //   18: aload_2
      //   19: aload_1
      //   20: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   23: pop
      //   24: ldc 'mspl'
      //   26: aload_2
      //   27: invokevirtual toString : ()Ljava/lang/String;
      //   30: invokestatic a : (Ljava/lang/String;Ljava/lang/String;)V
      //   33: invokestatic j : ()Lcom/alipay/sdk/data/a;
      //   36: invokevirtual g : ()Z
      //   39: ifeq -> 53
      //   42: new com/alipay/sdk/packet/impl/d
      //   45: dup
      //   46: invokespecial <init> : ()V
      //   49: astore_2
      //   50: goto -> 61
      //   53: new com/alipay/sdk/packet/impl/e
      //   56: dup
      //   57: invokespecial <init> : ()V
      //   60: astore_2
      //   61: aload_2
      //   62: aconst_null
      //   63: aload_0
      //   64: aload_1
      //   65: invokevirtual a : (Lcom/alipay/sdk/sys/a;Landroid/content/Context;Ljava/lang/String;)Lcom/alipay/sdk/packet/b;
      //   68: ifnull -> 82
      //   71: aload_0
      //   72: aload_1
      //   73: invokestatic a : (Landroid/content/Context;Ljava/lang/String;)I
      //   76: pop
      //   77: ldc com/alipay/sdk/app/statistic/a$b
      //   79: monitorexit
      //   80: iconst_1
      //   81: ireturn
      //   82: ldc com/alipay/sdk/app/statistic/a$b
      //   84: monitorexit
      //   85: iconst_0
      //   86: ireturn
      //   87: astore_0
      //   88: aload_0
      //   89: invokestatic a : (Ljava/lang/Throwable;)V
      //   92: ldc com/alipay/sdk/app/statistic/a$b
      //   94: monitorexit
      //   95: iconst_0
      //   96: ireturn
      //   97: astore_0
      //   98: ldc com/alipay/sdk/app/statistic/a$b
      //   100: monitorexit
      //   101: aload_0
      //   102: athrow
      // Exception table:
      //   from	to	target	type
      //   3	50	97	finally
      //   53	61	97	finally
      //   61	77	87	finally
      //   88	92	97	finally
    }
  }
  
  static final class c {
    private static final String a = "alipay_cashier_statistic_v";
    
    static long a(Context param1Context) {
      long l1;
      /* monitor enter TypeReferenceDotClassExpression{InnerObjectType{ObjectType{com/alipay/sdk/app/statistic/a}.Lcom/alipay/sdk/app/statistic/a$c;}} */
      long l2 = 0L;
      try {
        String str = j.b(null, param1Context, "alipay_cashier_statistic_v", null);
        l1 = l2;
      } finally {
        Exception exception = null;
      } 
      l1++;
      try {
        j.a(null, param1Context, "alipay_cashier_statistic_v", Long.toString(l1));
      } finally {}
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\alipay\sdk\app\statistic\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */