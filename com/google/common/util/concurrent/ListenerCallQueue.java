package com.google.common.util.concurrent;

import com.google.common.base.Preconditions;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.Executor;
import java.util.logging.Logger;

final class ListenerCallQueue<L> {
  private static final Logger a = Logger.getLogger(ListenerCallQueue.class.getName());
  
  private final List<PerListenerQueue<L>> b = Collections.synchronizedList(new ArrayList<PerListenerQueue<L>>());
  
  private void a(Event<L> paramEvent, Object paramObject) {
    Preconditions.a(paramEvent, "event");
    Preconditions.a(paramObject, "label");
    synchronized (this.b) {
      Iterator<PerListenerQueue<L>> iterator = this.b.iterator();
      while (iterator.hasNext())
        ((PerListenerQueue<L>)iterator.next()).a(paramEvent, paramObject); 
      return;
    } 
  }
  
  public void a() {
    for (int i = 0; i < this.b.size(); i++)
      ((PerListenerQueue)this.b.get(i)).a(); 
  }
  
  public void a(Event<L> paramEvent) {
    a(paramEvent, paramEvent);
  }
  
  static interface Event<L> {
    void a(L param1L);
  }
  
  static final class PerListenerQueue<L> implements Runnable {
    final L a;
    
    final Executor b;
    
    final Queue<ListenerCallQueue.Event<L>> c;
    
    final Queue<Object> d;
    
    boolean e;
    
    void a() {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: aload_0
      //   3: getfield e : Z
      //   6: istore_2
      //   7: iconst_1
      //   8: istore_1
      //   9: iload_2
      //   10: ifne -> 129
      //   13: aload_0
      //   14: iconst_1
      //   15: putfield e : Z
      //   18: goto -> 21
      //   21: aload_0
      //   22: monitorexit
      //   23: iload_1
      //   24: ifeq -> 123
      //   27: aload_0
      //   28: getfield b : Ljava/util/concurrent/Executor;
      //   31: aload_0
      //   32: invokeinterface execute : (Ljava/lang/Runnable;)V
      //   37: return
      //   38: astore_3
      //   39: aload_0
      //   40: monitorenter
      //   41: aload_0
      //   42: iconst_0
      //   43: putfield e : Z
      //   46: aload_0
      //   47: monitorexit
      //   48: invokestatic b : ()Ljava/util/logging/Logger;
      //   51: astore #4
      //   53: getstatic java/util/logging/Level.SEVERE : Ljava/util/logging/Level;
      //   56: astore #5
      //   58: new java/lang/StringBuilder
      //   61: dup
      //   62: invokespecial <init> : ()V
      //   65: astore #6
      //   67: aload #6
      //   69: ldc 'Exception while running callbacks for '
      //   71: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   74: pop
      //   75: aload #6
      //   77: aload_0
      //   78: getfield a : Ljava/lang/Object;
      //   81: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
      //   84: pop
      //   85: aload #6
      //   87: ldc ' on '
      //   89: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   92: pop
      //   93: aload #6
      //   95: aload_0
      //   96: getfield b : Ljava/util/concurrent/Executor;
      //   99: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
      //   102: pop
      //   103: aload #4
      //   105: aload #5
      //   107: aload #6
      //   109: invokevirtual toString : ()Ljava/lang/String;
      //   112: aload_3
      //   113: invokevirtual log : (Ljava/util/logging/Level;Ljava/lang/String;Ljava/lang/Throwable;)V
      //   116: aload_3
      //   117: athrow
      //   118: astore_3
      //   119: aload_0
      //   120: monitorexit
      //   121: aload_3
      //   122: athrow
      //   123: return
      //   124: astore_3
      //   125: aload_0
      //   126: monitorexit
      //   127: aload_3
      //   128: athrow
      //   129: iconst_0
      //   130: istore_1
      //   131: goto -> 21
      // Exception table:
      //   from	to	target	type
      //   2	7	124	finally
      //   13	18	124	finally
      //   21	23	124	finally
      //   27	37	38	java/lang/RuntimeException
      //   41	48	118	finally
      //   119	121	118	finally
      //   125	127	124	finally
    }
    
    void a(ListenerCallQueue.Event<L> param1Event, Object param1Object) {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: aload_0
      //   3: getfield c : Ljava/util/Queue;
      //   6: aload_1
      //   7: invokeinterface add : (Ljava/lang/Object;)Z
      //   12: pop
      //   13: aload_0
      //   14: getfield d : Ljava/util/Queue;
      //   17: aload_2
      //   18: invokeinterface add : (Ljava/lang/Object;)Z
      //   23: pop
      //   24: aload_0
      //   25: monitorexit
      //   26: return
      //   27: astore_1
      //   28: aload_0
      //   29: monitorexit
      //   30: aload_1
      //   31: athrow
      // Exception table:
      //   from	to	target	type
      //   2	24	27	finally
    }
    
    public void run() {
      // Byte code:
      //   0: iconst_1
      //   1: istore #4
      //   3: iconst_1
      //   4: istore_3
      //   5: iload #4
      //   7: istore_1
      //   8: aload_0
      //   9: monitorenter
      //   10: iload_3
      //   11: istore_2
      //   12: aload_0
      //   13: getfield e : Z
      //   16: invokestatic b : (Z)V
      //   19: iload_3
      //   20: istore_2
      //   21: aload_0
      //   22: getfield c : Ljava/util/Queue;
      //   25: invokeinterface poll : ()Ljava/lang/Object;
      //   30: checkcast com/google/common/util/concurrent/ListenerCallQueue$Event
      //   33: astore #6
      //   35: iload_3
      //   36: istore_2
      //   37: aload_0
      //   38: getfield d : Ljava/util/Queue;
      //   41: invokeinterface poll : ()Ljava/lang/Object;
      //   46: astore #5
      //   48: aload #6
      //   50: ifnonnull -> 70
      //   53: iload_3
      //   54: istore_2
      //   55: aload_0
      //   56: iconst_0
      //   57: putfield e : Z
      //   60: aload_0
      //   61: monitorexit
      //   62: return
      //   63: astore #5
      //   65: iconst_0
      //   66: istore_1
      //   67: goto -> 191
      //   70: iload_3
      //   71: istore_2
      //   72: aload_0
      //   73: monitorexit
      //   74: iload #4
      //   76: istore_1
      //   77: aload #6
      //   79: aload_0
      //   80: getfield a : Ljava/lang/Object;
      //   83: invokeinterface a : (Ljava/lang/Object;)V
      //   88: goto -> 0
      //   91: astore #6
      //   93: iload #4
      //   95: istore_1
      //   96: invokestatic b : ()Ljava/util/logging/Logger;
      //   99: astore #7
      //   101: iload #4
      //   103: istore_1
      //   104: getstatic java/util/logging/Level.SEVERE : Ljava/util/logging/Level;
      //   107: astore #8
      //   109: iload #4
      //   111: istore_1
      //   112: new java/lang/StringBuilder
      //   115: dup
      //   116: invokespecial <init> : ()V
      //   119: astore #9
      //   121: iload #4
      //   123: istore_1
      //   124: aload #9
      //   126: ldc 'Exception while executing callback: '
      //   128: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   131: pop
      //   132: iload #4
      //   134: istore_1
      //   135: aload #9
      //   137: aload_0
      //   138: getfield a : Ljava/lang/Object;
      //   141: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
      //   144: pop
      //   145: iload #4
      //   147: istore_1
      //   148: aload #9
      //   150: ldc ' '
      //   152: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   155: pop
      //   156: iload #4
      //   158: istore_1
      //   159: aload #9
      //   161: aload #5
      //   163: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
      //   166: pop
      //   167: iload #4
      //   169: istore_1
      //   170: aload #7
      //   172: aload #8
      //   174: aload #9
      //   176: invokevirtual toString : ()Ljava/lang/String;
      //   179: aload #6
      //   181: invokevirtual log : (Ljava/util/logging/Level;Ljava/lang/String;Ljava/lang/Throwable;)V
      //   184: goto -> 0
      //   187: astore #5
      //   189: iload_2
      //   190: istore_1
      //   191: iload_1
      //   192: istore_2
      //   193: aload_0
      //   194: monitorexit
      //   195: aload #5
      //   197: athrow
      //   198: astore #5
      //   200: iload_1
      //   201: ifeq -> 223
      //   204: aload_0
      //   205: monitorenter
      //   206: aload_0
      //   207: iconst_0
      //   208: putfield e : Z
      //   211: aload_0
      //   212: monitorexit
      //   213: goto -> 223
      //   216: astore #5
      //   218: aload_0
      //   219: monitorexit
      //   220: aload #5
      //   222: athrow
      //   223: aload #5
      //   225: athrow
      // Exception table:
      //   from	to	target	type
      //   8	10	198	finally
      //   12	19	187	finally
      //   21	35	187	finally
      //   37	48	187	finally
      //   55	60	187	finally
      //   60	62	63	finally
      //   72	74	187	finally
      //   77	88	91	java/lang/RuntimeException
      //   77	88	198	finally
      //   96	101	198	finally
      //   104	109	198	finally
      //   112	121	198	finally
      //   124	132	198	finally
      //   135	145	198	finally
      //   148	156	198	finally
      //   159	167	198	finally
      //   170	184	198	finally
      //   193	195	187	finally
      //   195	198	198	finally
      //   206	213	216	finally
      //   218	220	216	finally
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\commo\\util\concurrent\ListenerCallQueue.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */