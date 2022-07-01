package com.huawei.updatesdk.b.c;

import com.huawei.updatesdk.a.b.c.b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class c {
  private static c a = new c();
  
  private static a b = new a();
  
  public static a a() {
    return b;
  }
  
  public static c b() {
    return a;
  }
  
  public void a(b paramb) {
    b.a(1, paramb);
  }
  
  public void b(b paramb) {
    b.a(0, paramb);
  }
  
  public void c(b paramb) {
    b.a(2, paramb);
  }
  
  static final class a implements a {
    private final List<b> a = new ArrayList<b>();
    
    public void a(int param1Int, b param1b) {
      synchronized (this.a) {
        Iterator<b> iterator = this.a.iterator();
        while (iterator.hasNext())
          ((b)iterator.next()).a(param1Int, param1b); 
        return;
      } 
    }
    
    public void a(b param1b) {
      // Byte code:
      //   0: aload_0
      //   1: getfield a : Ljava/util/List;
      //   4: astore_3
      //   5: aload_3
      //   6: monitorenter
      //   7: aload_1
      //   8: ifnonnull -> 14
      //   11: aload_3
      //   12: monitorexit
      //   13: return
      //   14: aload_0
      //   15: getfield a : Ljava/util/List;
      //   18: aload_1
      //   19: invokeinterface contains : (Ljava/lang/Object;)Z
      //   24: istore_2
      //   25: iload_2
      //   26: ifne -> 55
      //   29: aload_0
      //   30: getfield a : Ljava/util/List;
      //   33: aload_1
      //   34: invokeinterface add : (Ljava/lang/Object;)Z
      //   39: pop
      //   40: goto -> 55
      //   43: ldc 'registerObserver IllegalArgumentException'
      //   45: astore_1
      //   46: ldc 'InstallObserverManager'
      //   48: aload_1
      //   49: invokestatic b : (Ljava/lang/String;Ljava/lang/String;)V
      //   52: goto -> 55
      //   55: aload_3
      //   56: monitorexit
      //   57: return
      //   58: astore_1
      //   59: aload_3
      //   60: monitorexit
      //   61: aload_1
      //   62: athrow
      //   63: astore_1
      //   64: goto -> 81
      //   67: astore_1
      //   68: goto -> 75
      //   71: astore_1
      //   72: goto -> 43
      //   75: ldc 'registerObserver ClassCastException'
      //   77: astore_1
      //   78: goto -> 46
      //   81: ldc 'registerObserver UnsupportedOperationException'
      //   83: astore_1
      //   84: goto -> 46
      // Exception table:
      //   from	to	target	type
      //   11	13	58	finally
      //   14	25	58	finally
      //   29	40	63	java/lang/UnsupportedOperationException
      //   29	40	67	java/lang/ClassCastException
      //   29	40	71	java/lang/IllegalArgumentException
      //   29	40	58	finally
      //   46	52	58	finally
      //   55	57	58	finally
      //   59	61	58	finally
    }
    
    public void b(b param1b) {
      synchronized (this.a) {
        this.a.remove(param1b);
      } 
      /* monitor exit ClassFileLocalVariableReferenceExpression{type=ObjectType{java/lang/Object}, name=SYNTHETIC_LOCAL_VARIABLE_2} */
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawe\\updatesdk\b\c\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */