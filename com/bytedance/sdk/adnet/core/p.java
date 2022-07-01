package com.bytedance.sdk.adnet.core;

import android.util.Log;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class p {
  public static boolean a = Log.isLoggable(b, 2);
  
  private static String b = "VNetLog";
  
  public static void a(String paramString, Object... paramVarArgs) {
    if (a)
      Log.v(b, e(paramString, paramVarArgs)); 
  }
  
  public static void a(Throwable paramThrowable, String paramString, Object... paramVarArgs) {
    Log.e(b, e(paramString, paramVarArgs), paramThrowable);
  }
  
  public static void b(String paramString, Object... paramVarArgs) {
    Log.d(b, e(paramString, paramVarArgs));
  }
  
  public static void c(String paramString, Object... paramVarArgs) {
    Log.e(b, e(paramString, paramVarArgs));
  }
  
  public static void d(String paramString, Object... paramVarArgs) {
    Log.wtf(b, e(paramString, paramVarArgs));
  }
  
  private static String e(String paramString, Object... paramVarArgs) {
    String str;
    if (paramVarArgs != null)
      paramString = String.format(Locale.US, paramString, paramVarArgs); 
    StackTraceElement[] arrayOfStackTraceElement = (new Throwable()).fillInStackTrace().getStackTrace();
    int i = 2;
    while (true) {
      if (i < arrayOfStackTraceElement.length) {
        if (!arrayOfStackTraceElement[i].getClassName().equals("com.bytedance.sdk.adnet.VNetLog")) {
          String str2 = arrayOfStackTraceElement[i].getClassName();
          str2 = str2.substring(str2.lastIndexOf('.') + 1);
          str2 = str2.substring(str2.lastIndexOf('$') + 1);
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append(str2);
          stringBuilder.append(".");
          stringBuilder.append(arrayOfStackTraceElement[i].getMethodName());
          String str1 = stringBuilder.toString();
          break;
        } 
        i++;
        continue;
      } 
      str = "<unknown>";
      break;
    } 
    return String.format(Locale.US, "[%d] %s: %s", new Object[] { Long.valueOf(Thread.currentThread().getId()), str, paramString });
  }
  
  static class a {
    public static final boolean a = p.a;
    
    private final List<a> b = new ArrayList<a>();
    
    private boolean c = false;
    
    private long a() {
      if (this.b.size() == 0)
        return 0L; 
      long l = ((a)this.b.get(0)).c;
      List<a> list = this.b;
      return ((a)list.get(list.size() - 1)).c - l;
    }
    
    public void a(String param1String) {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: aload_0
      //   3: iconst_1
      //   4: putfield c : Z
      //   7: aload_0
      //   8: invokespecial a : ()J
      //   11: lstore #4
      //   13: lload #4
      //   15: lconst_0
      //   16: lcmp
      //   17: ifgt -> 23
      //   20: aload_0
      //   21: monitorexit
      //   22: return
      //   23: aload_0
      //   24: getfield b : Ljava/util/List;
      //   27: iconst_0
      //   28: invokeinterface get : (I)Ljava/lang/Object;
      //   33: checkcast com/bytedance/sdk/adnet/core/p$a$a
      //   36: getfield c : J
      //   39: lstore_2
      //   40: ldc '(%-4d ms) %s'
      //   42: iconst_2
      //   43: anewarray java/lang/Object
      //   46: dup
      //   47: iconst_0
      //   48: lload #4
      //   50: invokestatic valueOf : (J)Ljava/lang/Long;
      //   53: aastore
      //   54: dup
      //   55: iconst_1
      //   56: aload_1
      //   57: aastore
      //   58: invokestatic b : (Ljava/lang/String;[Ljava/lang/Object;)V
      //   61: aload_0
      //   62: getfield b : Ljava/util/List;
      //   65: invokeinterface iterator : ()Ljava/util/Iterator;
      //   70: astore_1
      //   71: aload_1
      //   72: invokeinterface hasNext : ()Z
      //   77: ifeq -> 142
      //   80: aload_1
      //   81: invokeinterface next : ()Ljava/lang/Object;
      //   86: checkcast com/bytedance/sdk/adnet/core/p$a$a
      //   89: astore #6
      //   91: aload #6
      //   93: getfield c : J
      //   96: lstore #4
      //   98: ldc '(+%-4d) [%2d] %s'
      //   100: iconst_3
      //   101: anewarray java/lang/Object
      //   104: dup
      //   105: iconst_0
      //   106: lload #4
      //   108: lload_2
      //   109: lsub
      //   110: invokestatic valueOf : (J)Ljava/lang/Long;
      //   113: aastore
      //   114: dup
      //   115: iconst_1
      //   116: aload #6
      //   118: getfield b : J
      //   121: invokestatic valueOf : (J)Ljava/lang/Long;
      //   124: aastore
      //   125: dup
      //   126: iconst_2
      //   127: aload #6
      //   129: getfield a : Ljava/lang/String;
      //   132: aastore
      //   133: invokestatic b : (Ljava/lang/String;[Ljava/lang/Object;)V
      //   136: lload #4
      //   138: lstore_2
      //   139: goto -> 71
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
      //   2	13	145	finally
      //   23	71	145	finally
      //   71	136	145	finally
    }
    
    public void a(String param1String, long param1Long) {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: aload_0
      //   3: getfield c : Z
      //   6: ifne -> 34
      //   9: aload_0
      //   10: getfield b : Ljava/util/List;
      //   13: new com/bytedance/sdk/adnet/core/p$a$a
      //   16: dup
      //   17: aload_1
      //   18: lload_2
      //   19: invokestatic elapsedRealtime : ()J
      //   22: invokespecial <init> : (Ljava/lang/String;JJ)V
      //   25: invokeinterface add : (Ljava/lang/Object;)Z
      //   30: pop
      //   31: aload_0
      //   32: monitorexit
      //   33: return
      //   34: new java/lang/IllegalStateException
      //   37: dup
      //   38: ldc 'Marker added to finished log'
      //   40: invokespecial <init> : (Ljava/lang/String;)V
      //   43: athrow
      //   44: astore_1
      //   45: aload_0
      //   46: monitorexit
      //   47: aload_1
      //   48: athrow
      // Exception table:
      //   from	to	target	type
      //   2	31	44	finally
      //   34	44	44	finally
    }
    
    protected void finalize() throws Throwable {
      if (!this.c) {
        a("Request on the loose");
        p.c("Marker log finalized without finish() - uncaught exit point for request", new Object[0]);
      } 
    }
    
    static class a {
      public final String a;
      
      public final long b;
      
      public final long c;
      
      public a(String param2String, long param2Long1, long param2Long2) {
        this.a = param2String;
        this.b = param2Long1;
        this.c = param2Long2;
      }
    }
  }
  
  static class a {
    public final String a;
    
    public final long b;
    
    public final long c;
    
    public a(String param1String, long param1Long1, long param1Long2) {
      this.a = param1String;
      this.b = param1Long1;
      this.c = param1Long2;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\adnet\core\p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */