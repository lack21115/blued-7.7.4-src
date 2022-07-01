package com.google.common.util.concurrent;

import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.LockSupport;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

abstract class InterruptibleTask<T> extends AtomicReference<Runnable> implements Runnable {
  private static final Runnable a = new DoNothingRunnable();
  
  private static final Runnable b = new DoNothingRunnable();
  
  private static final Runnable c = new DoNothingRunnable();
  
  abstract void a(@NullableDecl T paramT, @NullableDecl Throwable paramThrowable);
  
  abstract String b();
  
  abstract T c() throws Exception;
  
  abstract boolean d();
  
  final void f() {
    Runnable runnable = get();
    if (runnable instanceof Thread && compareAndSet(runnable, b))
      try {
        ((Thread)runnable).interrupt();
      } finally {
        if (getAndSet(a) == c)
          LockSupport.unpark((Thread)runnable); 
      }  
  }
  
  public final void run() {
    // Byte code:
    //   0: invokestatic currentThread : ()Ljava/lang/Thread;
    //   3: astore #7
    //   5: aload_0
    //   6: aconst_null
    //   7: aload #7
    //   9: invokevirtual compareAndSet : (Ljava/lang/Object;Ljava/lang/Object;)Z
    //   12: ifne -> 16
    //   15: return
    //   16: aload_0
    //   17: invokevirtual d : ()Z
    //   20: iconst_1
    //   21: ixor
    //   22: istore #4
    //   24: iload #4
    //   26: ifeq -> 196
    //   29: aload_0
    //   30: invokevirtual c : ()Ljava/lang/Object;
    //   33: astore #5
    //   35: goto -> 199
    //   38: astore #6
    //   40: aload_0
    //   41: aload #7
    //   43: getstatic com/google/common/util/concurrent/InterruptibleTask.a : Ljava/lang/Runnable;
    //   46: invokevirtual compareAndSet : (Ljava/lang/Object;Ljava/lang/Object;)Z
    //   49: ifne -> 183
    //   52: aload_0
    //   53: invokevirtual get : ()Ljava/lang/Object;
    //   56: checkcast java/lang/Runnable
    //   59: astore #5
    //   61: iconst_0
    //   62: istore_1
    //   63: iconst_0
    //   64: istore_2
    //   65: aload #5
    //   67: getstatic com/google/common/util/concurrent/InterruptibleTask.b : Ljava/lang/Runnable;
    //   70: if_acmpeq -> 96
    //   73: aload #5
    //   75: getstatic com/google/common/util/concurrent/InterruptibleTask.c : Ljava/lang/Runnable;
    //   78: if_acmpne -> 84
    //   81: goto -> 96
    //   84: iload_1
    //   85: ifeq -> 183
    //   88: aload #7
    //   90: invokevirtual interrupt : ()V
    //   93: goto -> 183
    //   96: iload_2
    //   97: iconst_1
    //   98: iadd
    //   99: istore_3
    //   100: iload_3
    //   101: sipush #1000
    //   104: if_icmple -> 162
    //   107: getstatic com/google/common/util/concurrent/InterruptibleTask.c : Ljava/lang/Runnable;
    //   110: astore #8
    //   112: aload #5
    //   114: aload #8
    //   116: if_acmpeq -> 133
    //   119: iload_1
    //   120: istore_2
    //   121: aload_0
    //   122: getstatic com/google/common/util/concurrent/InterruptibleTask.b : Ljava/lang/Runnable;
    //   125: aload #8
    //   127: invokevirtual compareAndSet : (Ljava/lang/Object;Ljava/lang/Object;)Z
    //   130: ifeq -> 167
    //   133: invokestatic interrupted : ()Z
    //   136: ifne -> 151
    //   139: iload_1
    //   140: ifeq -> 146
    //   143: goto -> 151
    //   146: iconst_0
    //   147: istore_1
    //   148: goto -> 153
    //   151: iconst_1
    //   152: istore_1
    //   153: aload_0
    //   154: invokestatic park : (Ljava/lang/Object;)V
    //   157: iload_1
    //   158: istore_2
    //   159: goto -> 167
    //   162: invokestatic yield : ()V
    //   165: iload_1
    //   166: istore_2
    //   167: aload_0
    //   168: invokevirtual get : ()Ljava/lang/Object;
    //   171: checkcast java/lang/Runnable
    //   174: astore #5
    //   176: iload_2
    //   177: istore_1
    //   178: iload_3
    //   179: istore_2
    //   180: goto -> 65
    //   183: iload #4
    //   185: ifeq -> 354
    //   188: aload_0
    //   189: aconst_null
    //   190: aload #6
    //   192: invokevirtual a : (Ljava/lang/Object;Ljava/lang/Throwable;)V
    //   195: return
    //   196: aconst_null
    //   197: astore #5
    //   199: aload_0
    //   200: aload #7
    //   202: getstatic com/google/common/util/concurrent/InterruptibleTask.a : Ljava/lang/Runnable;
    //   205: invokevirtual compareAndSet : (Ljava/lang/Object;Ljava/lang/Object;)Z
    //   208: ifne -> 342
    //   211: aload_0
    //   212: invokevirtual get : ()Ljava/lang/Object;
    //   215: checkcast java/lang/Runnable
    //   218: astore #6
    //   220: iconst_0
    //   221: istore_1
    //   222: iconst_0
    //   223: istore_2
    //   224: aload #6
    //   226: getstatic com/google/common/util/concurrent/InterruptibleTask.b : Ljava/lang/Runnable;
    //   229: if_acmpeq -> 255
    //   232: aload #6
    //   234: getstatic com/google/common/util/concurrent/InterruptibleTask.c : Ljava/lang/Runnable;
    //   237: if_acmpne -> 243
    //   240: goto -> 255
    //   243: iload_1
    //   244: ifeq -> 342
    //   247: aload #7
    //   249: invokevirtual interrupt : ()V
    //   252: goto -> 342
    //   255: iload_2
    //   256: iconst_1
    //   257: iadd
    //   258: istore_3
    //   259: iload_3
    //   260: sipush #1000
    //   263: if_icmple -> 321
    //   266: getstatic com/google/common/util/concurrent/InterruptibleTask.c : Ljava/lang/Runnable;
    //   269: astore #8
    //   271: aload #6
    //   273: aload #8
    //   275: if_acmpeq -> 292
    //   278: iload_1
    //   279: istore_2
    //   280: aload_0
    //   281: getstatic com/google/common/util/concurrent/InterruptibleTask.b : Ljava/lang/Runnable;
    //   284: aload #8
    //   286: invokevirtual compareAndSet : (Ljava/lang/Object;Ljava/lang/Object;)Z
    //   289: ifeq -> 326
    //   292: invokestatic interrupted : ()Z
    //   295: ifne -> 310
    //   298: iload_1
    //   299: ifeq -> 305
    //   302: goto -> 310
    //   305: iconst_0
    //   306: istore_1
    //   307: goto -> 312
    //   310: iconst_1
    //   311: istore_1
    //   312: aload_0
    //   313: invokestatic park : (Ljava/lang/Object;)V
    //   316: iload_1
    //   317: istore_2
    //   318: goto -> 326
    //   321: invokestatic yield : ()V
    //   324: iload_1
    //   325: istore_2
    //   326: aload_0
    //   327: invokevirtual get : ()Ljava/lang/Object;
    //   330: checkcast java/lang/Runnable
    //   333: astore #6
    //   335: iload_2
    //   336: istore_1
    //   337: iload_3
    //   338: istore_2
    //   339: goto -> 224
    //   342: iload #4
    //   344: ifeq -> 354
    //   347: aload_0
    //   348: aload #5
    //   350: aconst_null
    //   351: invokevirtual a : (Ljava/lang/Object;Ljava/lang/Throwable;)V
    //   354: return
    // Exception table:
    //   from	to	target	type
    //   29	35	38	finally
  }
  
  public final String toString() {
    String str;
    Runnable runnable = get();
    if (runnable == a) {
      str = "running=[DONE]";
    } else if (str == b) {
      str = "running=[INTERRUPTED]";
    } else if (str instanceof Thread) {
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append("running=[RUNNING ON ");
      stringBuilder1.append(((Thread)str).getName());
      stringBuilder1.append("]");
      str = stringBuilder1.toString();
    } else {
      str = "running=[NOT STARTED YET]";
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(str);
    stringBuilder.append(", ");
    stringBuilder.append(b());
    return stringBuilder.toString();
  }
  
  static final class DoNothingRunnable implements Runnable {
    private DoNothingRunnable() {}
    
    public void run() {}
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\commo\\util\concurrent\InterruptibleTask.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */