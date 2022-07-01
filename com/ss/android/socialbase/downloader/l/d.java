package com.ss.android.socialbase.downloader.l;

import android.util.SparseArray;
import com.ss.android.socialbase.downloader.downloader.b;
import com.ss.android.socialbase.downloader.k.a;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;

public class d {
  private volatile SparseArray<c> a = new SparseArray();
  
  private int b = 0;
  
  private void b() {
    try {
      int i;
      ArrayList<Integer> arrayList = new ArrayList();
      byte b = 0;
    } finally {
      Exception exception = null;
    } 
  }
  
  private void c(c paramc) {
    try {
      ExecutorService executorService = b.j();
      if (executorService != null && executorService instanceof ThreadPoolExecutor) {
        ((ThreadPoolExecutor)executorService).remove(paramc);
        if (paramc != null && a.a(paramc.e()).b("pause_with_interrupt", false)) {
          Future future = paramc.g();
          if (future != null) {
            future.cancel(true);
            return;
          } 
        } 
      } 
    } catch (Exception exception) {
      exception.printStackTrace();
    } 
  }
  
  public List<Integer> a() {
    // Byte code:
    //   0: ldc com/ss/android/socialbase/downloader/l/d
    //   2: monitorenter
    //   3: aload_0
    //   4: invokespecial b : ()V
    //   7: new java/util/ArrayList
    //   10: dup
    //   11: invokespecial <init> : ()V
    //   14: astore_2
    //   15: iconst_0
    //   16: istore_1
    //   17: iload_1
    //   18: aload_0
    //   19: getfield a : Landroid/util/SparseArray;
    //   22: invokevirtual size : ()I
    //   25: if_icmpge -> 68
    //   28: aload_0
    //   29: getfield a : Landroid/util/SparseArray;
    //   32: aload_0
    //   33: getfield a : Landroid/util/SparseArray;
    //   36: iload_1
    //   37: invokevirtual keyAt : (I)I
    //   40: invokevirtual get : (I)Ljava/lang/Object;
    //   43: checkcast com/ss/android/socialbase/downloader/l/c
    //   46: astore_3
    //   47: aload_3
    //   48: ifnull -> 79
    //   51: aload_2
    //   52: aload_3
    //   53: invokevirtual e : ()I
    //   56: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   59: invokeinterface add : (Ljava/lang/Object;)Z
    //   64: pop
    //   65: goto -> 79
    //   68: ldc com/ss/android/socialbase/downloader/l/d
    //   70: monitorexit
    //   71: aload_2
    //   72: areturn
    //   73: astore_2
    //   74: ldc com/ss/android/socialbase/downloader/l/d
    //   76: monitorexit
    //   77: aload_2
    //   78: athrow
    //   79: iload_1
    //   80: iconst_1
    //   81: iadd
    //   82: istore_1
    //   83: goto -> 17
    // Exception table:
    //   from	to	target	type
    //   3	15	73	finally
    //   17	47	73	finally
    //   51	65	73	finally
    //   68	71	73	finally
    //   74	77	73	finally
  }
  
  public void a(c paramc) {
    // Byte code:
    //   0: aload_1
    //   1: invokevirtual f : ()V
    //   4: ldc com/ss/android/socialbase/downloader/l/d
    //   6: monitorenter
    //   7: aload_0
    //   8: getfield b : I
    //   11: istore_2
    //   12: iconst_0
    //   13: istore #4
    //   15: iconst_0
    //   16: istore_3
    //   17: iload_2
    //   18: sipush #500
    //   21: if_icmplt -> 36
    //   24: aload_0
    //   25: invokespecial b : ()V
    //   28: aload_0
    //   29: iconst_0
    //   30: putfield b : I
    //   33: goto -> 46
    //   36: aload_0
    //   37: aload_0
    //   38: getfield b : I
    //   41: iconst_1
    //   42: iadd
    //   43: putfield b : I
    //   46: aload_0
    //   47: getfield a : Landroid/util/SparseArray;
    //   50: aload_1
    //   51: invokevirtual e : ()I
    //   54: aload_1
    //   55: invokevirtual put : (ILjava/lang/Object;)V
    //   58: ldc com/ss/android/socialbase/downloader/l/d
    //   60: monitorexit
    //   61: aload_1
    //   62: invokevirtual c : ()Lcom/ss/android/socialbase/downloader/g/d;
    //   65: astore #5
    //   67: invokestatic j : ()Ljava/util/concurrent/ExecutorService;
    //   70: astore #6
    //   72: aload #6
    //   74: ifnull -> 115
    //   77: aload_1
    //   78: invokevirtual e : ()I
    //   81: invokestatic a : (I)Lcom/ss/android/socialbase/downloader/k/a;
    //   84: ldc 'pause_with_interrupt'
    //   86: iconst_0
    //   87: invokevirtual b : (Ljava/lang/String;Z)Z
    //   90: ifeq -> 106
    //   93: aload_1
    //   94: aload #6
    //   96: aload_1
    //   97: invokeinterface submit : (Ljava/lang/Runnable;)Ljava/util/concurrent/Future;
    //   102: invokevirtual a : (Ljava/util/concurrent/Future;)V
    //   105: return
    //   106: aload #6
    //   108: aload_1
    //   109: invokeinterface execute : (Ljava/lang/Runnable;)V
    //   114: return
    //   115: aload #5
    //   117: invokevirtual e : ()Lcom/ss/android/socialbase/downloader/d/x;
    //   120: astore_1
    //   121: aload #5
    //   123: invokevirtual a : ()Lcom/ss/android/socialbase/downloader/g/c;
    //   126: astore #6
    //   128: new com/ss/android/socialbase/downloader/e/a
    //   131: dup
    //   132: sipush #1003
    //   135: ldc 'execute failed cpu thread executor service is null'
    //   137: invokespecial <init> : (ILjava/lang/String;)V
    //   140: astore #7
    //   142: aload #5
    //   144: invokevirtual a : ()Lcom/ss/android/socialbase/downloader/g/c;
    //   147: ifnull -> 319
    //   150: aload #5
    //   152: invokevirtual a : ()Lcom/ss/android/socialbase/downloader/g/c;
    //   155: invokevirtual q : ()I
    //   158: istore_2
    //   159: goto -> 162
    //   162: aload_1
    //   163: aload #6
    //   165: aload #7
    //   167: iload_2
    //   168: invokestatic a : (Lcom/ss/android/socialbase/downloader/d/x;Lcom/ss/android/socialbase/downloader/g/c;Lcom/ss/android/socialbase/downloader/e/a;I)V
    //   171: return
    //   172: astore_1
    //   173: aload #5
    //   175: ifnull -> 235
    //   178: aload #5
    //   180: invokevirtual e : ()Lcom/ss/android/socialbase/downloader/d/x;
    //   183: astore #6
    //   185: aload #5
    //   187: invokevirtual a : ()Lcom/ss/android/socialbase/downloader/g/c;
    //   190: astore #7
    //   192: new com/ss/android/socialbase/downloader/e/a
    //   195: dup
    //   196: sipush #1003
    //   199: ldc 'execute OOM'
    //   201: invokespecial <init> : (ILjava/lang/String;)V
    //   204: astore #8
    //   206: iload_3
    //   207: istore_2
    //   208: aload #5
    //   210: invokevirtual a : ()Lcom/ss/android/socialbase/downloader/g/c;
    //   213: ifnull -> 225
    //   216: aload #5
    //   218: invokevirtual a : ()Lcom/ss/android/socialbase/downloader/g/c;
    //   221: invokevirtual q : ()I
    //   224: istore_2
    //   225: aload #6
    //   227: aload #7
    //   229: aload #8
    //   231: iload_2
    //   232: invokestatic a : (Lcom/ss/android/socialbase/downloader/d/x;Lcom/ss/android/socialbase/downloader/g/c;Lcom/ss/android/socialbase/downloader/e/a;I)V
    //   235: aload_1
    //   236: invokevirtual printStackTrace : ()V
    //   239: return
    //   240: astore_1
    //   241: aload #5
    //   243: ifnull -> 308
    //   246: aload #5
    //   248: invokevirtual e : ()Lcom/ss/android/socialbase/downloader/d/x;
    //   251: astore #6
    //   253: aload #5
    //   255: invokevirtual a : ()Lcom/ss/android/socialbase/downloader/g/c;
    //   258: astore #7
    //   260: new com/ss/android/socialbase/downloader/e/a
    //   263: dup
    //   264: sipush #1003
    //   267: aload_1
    //   268: ldc 'DownloadThreadPoolExecute'
    //   270: invokestatic b : (Ljava/lang/Throwable;Ljava/lang/String;)Ljava/lang/String;
    //   273: invokespecial <init> : (ILjava/lang/String;)V
    //   276: astore #8
    //   278: iload #4
    //   280: istore_2
    //   281: aload #5
    //   283: invokevirtual a : ()Lcom/ss/android/socialbase/downloader/g/c;
    //   286: ifnull -> 298
    //   289: aload #5
    //   291: invokevirtual a : ()Lcom/ss/android/socialbase/downloader/g/c;
    //   294: invokevirtual q : ()I
    //   297: istore_2
    //   298: aload #6
    //   300: aload #7
    //   302: aload #8
    //   304: iload_2
    //   305: invokestatic a : (Lcom/ss/android/socialbase/downloader/d/x;Lcom/ss/android/socialbase/downloader/g/c;Lcom/ss/android/socialbase/downloader/e/a;I)V
    //   308: aload_1
    //   309: invokevirtual printStackTrace : ()V
    //   312: return
    //   313: astore_1
    //   314: ldc com/ss/android/socialbase/downloader/l/d
    //   316: monitorexit
    //   317: aload_1
    //   318: athrow
    //   319: iconst_0
    //   320: istore_2
    //   321: goto -> 162
    // Exception table:
    //   from	to	target	type
    //   7	12	313	finally
    //   24	33	313	finally
    //   36	46	313	finally
    //   46	61	313	finally
    //   67	72	240	java/lang/Exception
    //   67	72	172	java/lang/OutOfMemoryError
    //   77	105	240	java/lang/Exception
    //   77	105	172	java/lang/OutOfMemoryError
    //   106	114	240	java/lang/Exception
    //   106	114	172	java/lang/OutOfMemoryError
    //   115	159	240	java/lang/Exception
    //   115	159	172	java/lang/OutOfMemoryError
    //   162	171	240	java/lang/Exception
    //   162	171	172	java/lang/OutOfMemoryError
    //   314	317	313	finally
  }
  
  public boolean a(int paramInt) {
    // Byte code:
    //   0: ldc com/ss/android/socialbase/downloader/l/d
    //   2: monitorenter
    //   3: aload_0
    //   4: getfield a : Landroid/util/SparseArray;
    //   7: astore #4
    //   9: iconst_0
    //   10: istore_3
    //   11: aload #4
    //   13: ifnull -> 66
    //   16: aload_0
    //   17: getfield a : Landroid/util/SparseArray;
    //   20: invokevirtual size : ()I
    //   23: ifgt -> 29
    //   26: goto -> 66
    //   29: aload_0
    //   30: getfield a : Landroid/util/SparseArray;
    //   33: iload_1
    //   34: invokevirtual get : (I)Ljava/lang/Object;
    //   37: checkcast com/ss/android/socialbase/downloader/l/c
    //   40: astore #4
    //   42: iload_3
    //   43: istore_2
    //   44: aload #4
    //   46: ifnull -> 61
    //   49: iload_3
    //   50: istore_2
    //   51: aload #4
    //   53: invokevirtual d : ()Z
    //   56: ifeq -> 61
    //   59: iconst_1
    //   60: istore_2
    //   61: ldc com/ss/android/socialbase/downloader/l/d
    //   63: monitorexit
    //   64: iload_2
    //   65: ireturn
    //   66: ldc com/ss/android/socialbase/downloader/l/d
    //   68: monitorexit
    //   69: iconst_0
    //   70: ireturn
    //   71: astore #4
    //   73: ldc com/ss/android/socialbase/downloader/l/d
    //   75: monitorexit
    //   76: aload #4
    //   78: athrow
    // Exception table:
    //   from	to	target	type
    //   3	9	71	finally
    //   16	26	71	finally
    //   29	42	71	finally
    //   51	59	71	finally
    //   61	64	71	finally
    //   66	69	71	finally
    //   73	76	71	finally
  }
  
  public c b(int paramInt) {
    // Byte code:
    //   0: ldc com/ss/android/socialbase/downloader/l/d
    //   2: monitorenter
    //   3: aload_0
    //   4: invokespecial b : ()V
    //   7: aload_0
    //   8: getfield a : Landroid/util/SparseArray;
    //   11: iload_1
    //   12: invokevirtual get : (I)Ljava/lang/Object;
    //   15: checkcast com/ss/android/socialbase/downloader/l/c
    //   18: astore_2
    //   19: aload_2
    //   20: ifnull -> 45
    //   23: aload_2
    //   24: invokevirtual b : ()V
    //   27: aload_0
    //   28: aload_2
    //   29: invokespecial c : (Lcom/ss/android/socialbase/downloader/l/c;)V
    //   32: aload_0
    //   33: getfield a : Landroid/util/SparseArray;
    //   36: iload_1
    //   37: invokevirtual remove : (I)V
    //   40: ldc com/ss/android/socialbase/downloader/l/d
    //   42: monitorexit
    //   43: aload_2
    //   44: areturn
    //   45: ldc com/ss/android/socialbase/downloader/l/d
    //   47: monitorexit
    //   48: aconst_null
    //   49: areturn
    //   50: astore_2
    //   51: ldc com/ss/android/socialbase/downloader/l/d
    //   53: monitorexit
    //   54: aload_2
    //   55: athrow
    // Exception table:
    //   from	to	target	type
    //   3	19	50	finally
    //   23	43	50	finally
    //   45	48	50	finally
    //   51	54	50	finally
  }
  
  public void b(c paramc) {
    // Byte code:
    //   0: aload_1
    //   1: ifnonnull -> 5
    //   4: return
    //   5: ldc com/ss/android/socialbase/downloader/l/d
    //   7: monitorenter
    //   8: ldc 524288
    //   10: invokestatic a : (I)Z
    //   13: ifeq -> 40
    //   16: aload_0
    //   17: getfield a : Landroid/util/SparseArray;
    //   20: aload_1
    //   21: invokevirtual indexOfValue : (Ljava/lang/Object;)I
    //   24: istore_2
    //   25: iload_2
    //   26: iflt -> 59
    //   29: aload_0
    //   30: getfield a : Landroid/util/SparseArray;
    //   33: iload_2
    //   34: invokevirtual removeAt : (I)V
    //   37: goto -> 59
    //   40: aload_0
    //   41: getfield a : Landroid/util/SparseArray;
    //   44: aload_1
    //   45: invokevirtual e : ()I
    //   48: invokevirtual remove : (I)V
    //   51: goto -> 59
    //   54: astore_1
    //   55: aload_1
    //   56: invokevirtual printStackTrace : ()V
    //   59: ldc com/ss/android/socialbase/downloader/l/d
    //   61: monitorexit
    //   62: return
    //   63: astore_1
    //   64: ldc com/ss/android/socialbase/downloader/l/d
    //   66: monitorexit
    //   67: aload_1
    //   68: athrow
    // Exception table:
    //   from	to	target	type
    //   8	25	54	finally
    //   29	37	54	finally
    //   40	51	54	finally
    //   55	59	63	finally
    //   59	62	63	finally
    //   64	67	63	finally
  }
  
  public void c(int paramInt) {
    // Byte code:
    //   0: ldc com/ss/android/socialbase/downloader/l/d
    //   2: monitorenter
    //   3: aload_0
    //   4: invokespecial b : ()V
    //   7: aload_0
    //   8: getfield a : Landroid/util/SparseArray;
    //   11: iload_1
    //   12: invokevirtual get : (I)Ljava/lang/Object;
    //   15: checkcast com/ss/android/socialbase/downloader/l/c
    //   18: astore_2
    //   19: aload_2
    //   20: ifnull -> 40
    //   23: aload_2
    //   24: invokevirtual a : ()V
    //   27: aload_0
    //   28: aload_2
    //   29: invokespecial c : (Lcom/ss/android/socialbase/downloader/l/c;)V
    //   32: aload_0
    //   33: getfield a : Landroid/util/SparseArray;
    //   36: iload_1
    //   37: invokevirtual remove : (I)V
    //   40: ldc com/ss/android/socialbase/downloader/l/d
    //   42: monitorexit
    //   43: return
    //   44: astore_2
    //   45: ldc com/ss/android/socialbase/downloader/l/d
    //   47: monitorexit
    //   48: aload_2
    //   49: athrow
    // Exception table:
    //   from	to	target	type
    //   3	19	44	finally
    //   23	40	44	finally
    //   40	43	44	finally
    //   45	48	44	finally
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\ss\android\socialbase\downloader\l\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */