package com.datavisor.vangogh.b;

import android.content.Context;
import com.datavisor.vangogh.f.f;

public class a {
  private static a a = new a();
  
  public static a a() {
    return a;
  }
  
  public boolean a(Context paramContext) {
    /* monitor enter ThisExpression{ObjectType{com/datavisor/vangogh/b/a}} */
    try {
      String str2 = d(paramContext);
      String str1 = e(paramContext);
      if (f.b(str1)) {
        boolean bool1 = str1.equals("exception");
        if (bool1)
          return false; 
      } 
      if (f.a(str2) || str2.equals("empty") || str2.equals("exception") || f.a(str1) || str1.equals("empty"))
        return true; 
      return bool;
    } finally {
      paramContext = null;
      /* monitor exit ThisExpression{ObjectType{com/datavisor/vangogh/b/a}} */
    } 
  }
  
  public String b() {
    /* monitor enter ThisExpression{ObjectType{com/datavisor/vangogh/b/a}} */
    /* monitor exit ThisExpression{ObjectType{com/datavisor/vangogh/b/a}} */
    return "2.1.1.20200509_Android";
  }
  
  public String b(Context paramContext) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: invokevirtual getPackageManager : ()Landroid/content/pm/PackageManager;
    //   6: aload_1
    //   7: invokevirtual getPackageName : ()Ljava/lang/String;
    //   10: iconst_0
    //   11: invokevirtual getPackageInfo : (Ljava/lang/String;I)Landroid/content/pm/PackageInfo;
    //   14: getfield versionName : Ljava/lang/String;
    //   17: astore_1
    //   18: aload_0
    //   19: monitorexit
    //   20: aload_1
    //   21: areturn
    //   22: astore_1
    //   23: aload_1
    //   24: invokestatic a : (Ljava/lang/Throwable;)V
    //   27: aload_0
    //   28: monitorexit
    //   29: ldc 'exception'
    //   31: areturn
    //   32: astore_1
    //   33: aload_0
    //   34: monitorexit
    //   35: aload_1
    //   36: athrow
    // Exception table:
    //   from	to	target	type
    //   2	18	22	finally
    //   23	27	32	finally
  }
  
  public String c(Context paramContext) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: invokevirtual getPackageManager : ()Landroid/content/pm/PackageManager;
    //   6: astore_2
    //   7: aload_2
    //   8: aload_2
    //   9: aload_1
    //   10: invokevirtual getPackageName : ()Ljava/lang/String;
    //   13: iconst_0
    //   14: invokevirtual getApplicationInfo : (Ljava/lang/String;I)Landroid/content/pm/ApplicationInfo;
    //   17: invokevirtual getApplicationLabel : (Landroid/content/pm/ApplicationInfo;)Ljava/lang/CharSequence;
    //   20: invokeinterface toString : ()Ljava/lang/String;
    //   25: astore_1
    //   26: aload_0
    //   27: monitorexit
    //   28: aload_1
    //   29: areturn
    //   30: astore_1
    //   31: aload_1
    //   32: invokestatic a : (Ljava/lang/Throwable;)V
    //   35: aload_0
    //   36: monitorexit
    //   37: ldc 'exception'
    //   39: areturn
    //   40: astore_1
    //   41: aload_0
    //   42: monitorexit
    //   43: aload_1
    //   44: athrow
    // Exception table:
    //   from	to	target	type
    //   2	26	30	finally
    //   31	35	40	finally
  }
  
  public String d(Context paramContext) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: invokevirtual getPackageManager : ()Landroid/content/pm/PackageManager;
    //   6: aload_1
    //   7: invokevirtual getPackageName : ()Ljava/lang/String;
    //   10: iconst_0
    //   11: invokevirtual getPackageInfo : (Ljava/lang/String;I)Landroid/content/pm/PackageInfo;
    //   14: astore_1
    //   15: aload_1
    //   16: getfield packageName : Ljava/lang/String;
    //   19: invokestatic a : (Ljava/lang/String;)Z
    //   22: istore_2
    //   23: iload_2
    //   24: ifeq -> 32
    //   27: aload_0
    //   28: monitorexit
    //   29: ldc 'empty'
    //   31: areturn
    //   32: aload_1
    //   33: getfield packageName : Ljava/lang/String;
    //   36: astore_1
    //   37: aload_0
    //   38: monitorexit
    //   39: aload_1
    //   40: areturn
    //   41: astore_1
    //   42: aload_1
    //   43: invokestatic a : (Ljava/lang/Throwable;)V
    //   46: aload_0
    //   47: monitorexit
    //   48: ldc 'exception'
    //   50: areturn
    //   51: astore_1
    //   52: aload_0
    //   53: monitorexit
    //   54: aload_1
    //   55: athrow
    // Exception table:
    //   from	to	target	type
    //   2	23	41	finally
    //   32	37	41	finally
    //   42	46	51	finally
  }
  
  public String e(Context paramContext) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: invokestatic myPid : ()I
    //   5: istore_2
    //   6: aload_1
    //   7: ldc 'activity'
    //   9: invokevirtual getSystemService : (Ljava/lang/String;)Ljava/lang/Object;
    //   12: checkcast android/app/ActivityManager
    //   15: invokevirtual getRunningAppProcesses : ()Ljava/util/List;
    //   18: astore_1
    //   19: aload_1
    //   20: ifnull -> 87
    //   23: aload_1
    //   24: invokeinterface iterator : ()Ljava/util/Iterator;
    //   29: astore_1
    //   30: aload_1
    //   31: invokeinterface hasNext : ()Z
    //   36: ifeq -> 87
    //   39: aload_1
    //   40: invokeinterface next : ()Ljava/lang/Object;
    //   45: checkcast android/app/ActivityManager$RunningAppProcessInfo
    //   48: astore #4
    //   50: aload #4
    //   52: getfield pid : I
    //   55: iload_2
    //   56: if_icmpne -> 30
    //   59: aload #4
    //   61: getfield processName : Ljava/lang/String;
    //   64: invokestatic a : (Ljava/lang/String;)Z
    //   67: istore_3
    //   68: iload_3
    //   69: ifeq -> 77
    //   72: aload_0
    //   73: monitorexit
    //   74: ldc 'empty'
    //   76: areturn
    //   77: aload #4
    //   79: getfield processName : Ljava/lang/String;
    //   82: astore_1
    //   83: aload_0
    //   84: monitorexit
    //   85: aload_1
    //   86: areturn
    //   87: aload_0
    //   88: monitorexit
    //   89: ldc 'empty'
    //   91: areturn
    //   92: astore_1
    //   93: aload_1
    //   94: invokestatic a : (Ljava/lang/Throwable;)V
    //   97: aload_0
    //   98: monitorexit
    //   99: ldc 'exception'
    //   101: areturn
    //   102: astore_1
    //   103: aload_0
    //   104: monitorexit
    //   105: aload_1
    //   106: athrow
    // Exception table:
    //   from	to	target	type
    //   2	19	92	finally
    //   23	30	92	finally
    //   30	68	92	finally
    //   77	83	92	finally
    //   93	97	102	finally
  }
  
  public String f(Context paramContext) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: invokevirtual getPackageManager : ()Landroid/content/pm/PackageManager;
    //   6: aload_1
    //   7: invokevirtual getPackageName : ()Ljava/lang/String;
    //   10: iconst_0
    //   11: invokevirtual getPackageInfo : (Ljava/lang/String;I)Landroid/content/pm/PackageInfo;
    //   14: astore_1
    //   15: new java/lang/StringBuilder
    //   18: dup
    //   19: invokespecial <init> : ()V
    //   22: astore_2
    //   23: aload_2
    //   24: aload_1
    //   25: getfield firstInstallTime : J
    //   28: invokevirtual append : (J)Ljava/lang/StringBuilder;
    //   31: pop
    //   32: aload_2
    //   33: ldc ''
    //   35: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   38: pop
    //   39: aload_2
    //   40: invokevirtual toString : ()Ljava/lang/String;
    //   43: astore_1
    //   44: aload_0
    //   45: monitorexit
    //   46: aload_1
    //   47: areturn
    //   48: astore_1
    //   49: aload_1
    //   50: invokestatic a : (Ljava/lang/Throwable;)V
    //   53: aload_0
    //   54: monitorexit
    //   55: ldc 'exception'
    //   57: areturn
    //   58: astore_1
    //   59: aload_0
    //   60: monitorexit
    //   61: aload_1
    //   62: athrow
    // Exception table:
    //   from	to	target	type
    //   2	44	48	finally
    //   49	53	58	finally
  }
  
  public String g(Context paramContext) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: invokevirtual getPackageManager : ()Landroid/content/pm/PackageManager;
    //   6: aload_1
    //   7: invokevirtual getPackageName : ()Ljava/lang/String;
    //   10: iconst_0
    //   11: invokevirtual getPackageInfo : (Ljava/lang/String;I)Landroid/content/pm/PackageInfo;
    //   14: astore_1
    //   15: new java/lang/StringBuilder
    //   18: dup
    //   19: invokespecial <init> : ()V
    //   22: astore_2
    //   23: aload_2
    //   24: aload_1
    //   25: getfield lastUpdateTime : J
    //   28: invokevirtual append : (J)Ljava/lang/StringBuilder;
    //   31: pop
    //   32: aload_2
    //   33: ldc ''
    //   35: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   38: pop
    //   39: aload_2
    //   40: invokevirtual toString : ()Ljava/lang/String;
    //   43: astore_1
    //   44: aload_0
    //   45: monitorexit
    //   46: aload_1
    //   47: areturn
    //   48: astore_1
    //   49: aload_1
    //   50: invokestatic a : (Ljava/lang/Throwable;)V
    //   53: aload_0
    //   54: monitorexit
    //   55: ldc 'exception'
    //   57: areturn
    //   58: astore_1
    //   59: aload_0
    //   60: monitorexit
    //   61: aload_1
    //   62: athrow
    // Exception table:
    //   from	to	target	type
    //   2	44	48	finally
    //   49	53	58	finally
  }
  
  public String h(Context paramContext) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: invokevirtual getFilesDir : ()Ljava/io/File;
    //   6: invokevirtual getAbsolutePath : ()Ljava/lang/String;
    //   9: astore_1
    //   10: aload_1
    //   11: invokestatic a : (Ljava/lang/String;)Z
    //   14: istore_2
    //   15: iload_2
    //   16: ifeq -> 22
    //   19: ldc 'empty'
    //   21: astore_1
    //   22: aload_0
    //   23: monitorexit
    //   24: aload_1
    //   25: areturn
    //   26: astore_1
    //   27: aload_1
    //   28: invokestatic a : (Ljava/lang/Throwable;)V
    //   31: aload_0
    //   32: monitorexit
    //   33: ldc 'exception'
    //   35: areturn
    //   36: astore_1
    //   37: aload_0
    //   38: monitorexit
    //   39: aload_1
    //   40: athrow
    // Exception table:
    //   from	to	target	type
    //   2	15	26	finally
    //   27	31	36	finally
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\datavisor\vangogh\b\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */