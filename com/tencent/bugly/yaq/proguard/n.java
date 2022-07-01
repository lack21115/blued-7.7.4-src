package com.tencent.bugly.yaq.proguard;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.List;
import java.util.Map;

public final class n {
  public static final long a;
  
  private static n b = null;
  
  private Context c;
  
  private String d;
  
  private Map<Integer, Map<String, m>> e;
  
  private SharedPreferences f;
  
  static {
    a = System.currentTimeMillis();
    throw new VerifyError("bad dex opcode");
  }
  
  private n(Context paramContext) {
    throw new VerifyError("bad dex opcode");
  }
  
  public static n a() {
    // Byte code:
    //   0: ldc com/tencent/bugly/yaq/proguard/n
    //   2: monitorenter
    //   3: getstatic com/tencent/bugly/yaq/proguard/n.b : Lcom/tencent/bugly/yaq/proguard/n;
    //   6: astore_0
    //   7: ldc com/tencent/bugly/yaq/proguard/n
    //   9: monitorexit
    //   10: aload_0
    //   11: areturn
    //   12: astore_0
    //   13: ldc com/tencent/bugly/yaq/proguard/n
    //   15: monitorexit
    //   16: aload_0
    //   17: athrow
    // Exception table:
    //   from	to	target	type
    //   3	7	12	finally
  }
  
  public static n a(Context paramContext) {
    // Byte code:
    //   0: ldc com/tencent/bugly/yaq/proguard/n
    //   2: monitorenter
    //   3: getstatic com/tencent/bugly/yaq/proguard/n.b : Lcom/tencent/bugly/yaq/proguard/n;
    //   6: ifnonnull -> 20
    //   9: new com/tencent/bugly/yaq/proguard/n
    //   12: dup
    //   13: aload_0
    //   14: invokespecial <init> : (Landroid/content/Context;)V
    //   17: putstatic com/tencent/bugly/yaq/proguard/n.b : Lcom/tencent/bugly/yaq/proguard/n;
    //   20: getstatic com/tencent/bugly/yaq/proguard/n.b : Lcom/tencent/bugly/yaq/proguard/n;
    //   23: astore_0
    //   24: ldc com/tencent/bugly/yaq/proguard/n
    //   26: monitorexit
    //   27: aload_0
    //   28: areturn
    //   29: astore_0
    //   30: ldc com/tencent/bugly/yaq/proguard/n
    //   32: monitorexit
    //   33: aload_0
    //   34: athrow
    // Exception table:
    //   from	to	target	type
    //   3	20	29	finally
    //   20	24	29	finally
  }
  
  private <T extends List<?>> void a(int paramInt, T paramT) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_2
    //   3: ifnonnull -> 18
    //   6: aload_0
    //   7: monitorexit
    //   8: new java/lang/VerifyError
    //   11: dup
    //   12: ldc 'bad dex opcode'
    //   14: invokespecial <init> : (Ljava/lang/String;)V
    //   17: athrow
    //   18: new java/lang/VerifyError
    //   21: dup
    //   22: ldc 'bad dex opcode'
    //   24: invokespecial <init> : (Ljava/lang/String;)V
    //   27: athrow
    //   28: astore_2
    //   29: ldc 'writeCrashRecord error'
    //   31: iconst_0
    //   32: anewarray java/lang/Object
    //   35: invokestatic e : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   38: pop
    //   39: goto -> 6
    //   42: astore_2
    //   43: aload_0
    //   44: monitorexit
    //   45: aload_2
    //   46: athrow
    // Exception table:
    //   from	to	target	type
    //   18	28	28	java/lang/Exception
    //   18	28	42	finally
    //   29	39	42	finally
  }
  
  private boolean b(int paramInt) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: iload_1
    //   4: invokespecial c : (I)Ljava/util/List;
    //   7: astore_3
    //   8: aload_3
    //   9: ifnonnull -> 18
    //   12: iconst_0
    //   13: istore_2
    //   14: aload_0
    //   15: monitorexit
    //   16: iload_2
    //   17: ireturn
    //   18: invokestatic currentTimeMillis : ()J
    //   21: pop2
    //   22: new java/util/ArrayList
    //   25: dup
    //   26: invokespecial <init> : ()V
    //   29: astore #4
    //   31: new java/util/ArrayList
    //   34: dup
    //   35: invokespecial <init> : ()V
    //   38: astore #5
    //   40: aload_3
    //   41: invokeinterface iterator : ()Ljava/util/Iterator;
    //   46: astore #6
    //   48: aload #6
    //   50: invokeinterface hasNext : ()Z
    //   55: ifeq -> 95
    //   58: aload #6
    //   60: invokeinterface next : ()Ljava/lang/Object;
    //   65: checkcast com/tencent/bugly/yaq/proguard/m
    //   68: astore_3
    //   69: new java/lang/VerifyError
    //   72: dup
    //   73: ldc 'bad dex opcode'
    //   75: invokespecial <init> : (Ljava/lang/String;)V
    //   78: athrow
    //   79: astore_3
    //   80: ldc 'isFrequentCrash failed'
    //   82: iconst_0
    //   83: anewarray java/lang/Object
    //   86: invokestatic e : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   89: pop
    //   90: iconst_0
    //   91: istore_2
    //   92: goto -> 14
    //   95: aload #4
    //   97: invokestatic sort : (Ljava/util/List;)V
    //   100: aload #4
    //   102: invokeinterface size : ()I
    //   107: iconst_2
    //   108: if_icmplt -> 151
    //   111: aload #4
    //   113: invokeinterface size : ()I
    //   118: ifle -> 176
    //   121: aload #4
    //   123: aload #4
    //   125: invokeinterface size : ()I
    //   130: iconst_1
    //   131: isub
    //   132: invokeinterface get : (I)Ljava/lang/Object;
    //   137: checkcast com/tencent/bugly/yaq/proguard/m
    //   140: astore_3
    //   141: new java/lang/VerifyError
    //   144: dup
    //   145: ldc 'bad dex opcode'
    //   147: invokespecial <init> : (Ljava/lang/String;)V
    //   150: athrow
    //   151: aload_3
    //   152: aload #5
    //   154: invokeinterface removeAll : (Ljava/util/Collection;)Z
    //   159: pop
    //   160: aload_0
    //   161: iload_1
    //   162: aload_3
    //   163: invokespecial a : (ILjava/util/List;)V
    //   166: iconst_0
    //   167: istore_2
    //   168: goto -> 14
    //   171: astore_3
    //   172: aload_0
    //   173: monitorexit
    //   174: aload_3
    //   175: athrow
    //   176: iconst_1
    //   177: istore_2
    //   178: goto -> 14
    // Exception table:
    //   from	to	target	type
    //   2	8	79	java/lang/Exception
    //   2	8	171	finally
    //   18	79	79	java/lang/Exception
    //   18	79	171	finally
    //   80	90	171	finally
    //   95	151	79	java/lang/Exception
    //   95	151	171	finally
    //   151	166	79	java/lang/Exception
    //   151	166	171	finally
  }
  
  private <T extends List<?>> T c(int paramInt) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: new java/lang/VerifyError
    //   5: dup
    //   6: ldc 'bad dex opcode'
    //   8: invokespecial <init> : (Ljava/lang/String;)V
    //   11: athrow
    //   12: aload_0
    //   13: monitorexit
    //   14: aconst_null
    //   15: areturn
    //   16: astore_2
    //   17: ldc 'readCrashRecord error'
    //   19: iconst_0
    //   20: anewarray java/lang/Object
    //   23: invokestatic e : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   26: pop
    //   27: goto -> 12
    //   30: astore_2
    //   31: aload_0
    //   32: monitorexit
    //   33: aload_2
    //   34: athrow
    // Exception table:
    //   from	to	target	type
    //   2	12	16	java/lang/Exception
    //   2	12	30	finally
    //   17	27	30	finally
  }
  
  public final void a(int paramInt1, int paramInt2) {
    w.a();
    new Runnable(this, 1004, paramInt2) {
        public final void run() {
          try {
            throw new VerifyError("bad dex opcode");
          } catch (Exception exception) {
            x.e("saveCrashRecord failed", new Object[0]);
            throw new VerifyError("bad dex opcode");
          } 
        }
      };
    throw new VerifyError("bad dex opcode");
  }
  
  public final boolean a(int paramInt) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: new java/lang/VerifyError
    //   5: dup
    //   6: ldc 'bad dex opcode'
    //   8: invokespecial <init> : (Ljava/lang/String;)V
    //   11: athrow
    //   12: aload_0
    //   13: monitorexit
    //   14: iconst_1
    //   15: ireturn
    //   16: astore_2
    //   17: ldc 'canInit error'
    //   19: iconst_0
    //   20: anewarray java/lang/Object
    //   23: invokestatic e : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   26: pop
    //   27: goto -> 12
    //   30: astore_2
    //   31: aload_0
    //   32: monitorexit
    //   33: aload_2
    //   34: athrow
    // Exception table:
    //   from	to	target	type
    //   2	12	16	java/lang/Exception
    //   2	12	30	finally
    //   17	27	30	finally
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued555128-dex2jar.jar!\com\tencent\bugly\yaq\proguard\n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */