package com.github.mikephil.charting.utils;

public class ObjectPool<T extends ObjectPool.Poolable> {
  private static int a;
  
  private int b;
  
  private int c;
  
  private Object[] d;
  
  private int e;
  
  private T f;
  
  private float g;
  
  private ObjectPool(int paramInt, T paramT) {
    if (paramInt > 0) {
      this.c = paramInt;
      this.d = new Object[this.c];
      this.e = 0;
      this.f = paramT;
      this.g = 1.0F;
      b();
      return;
    } 
    throw new IllegalArgumentException("Object Pool must be instantiated with a capacity greater than 0!");
  }
  
  public static ObjectPool a(int paramInt, Poolable paramPoolable) {
    // Byte code:
    //   0: ldc com/github/mikephil/charting/utils/ObjectPool
    //   2: monitorenter
    //   3: new com/github/mikephil/charting/utils/ObjectPool
    //   6: dup
    //   7: iload_0
    //   8: aload_1
    //   9: invokespecial <init> : (ILcom/github/mikephil/charting/utils/ObjectPool$Poolable;)V
    //   12: astore_1
    //   13: aload_1
    //   14: getstatic com/github/mikephil/charting/utils/ObjectPool.a : I
    //   17: putfield b : I
    //   20: getstatic com/github/mikephil/charting/utils/ObjectPool.a : I
    //   23: iconst_1
    //   24: iadd
    //   25: putstatic com/github/mikephil/charting/utils/ObjectPool.a : I
    //   28: ldc com/github/mikephil/charting/utils/ObjectPool
    //   30: monitorexit
    //   31: aload_1
    //   32: areturn
    //   33: astore_1
    //   34: ldc com/github/mikephil/charting/utils/ObjectPool
    //   36: monitorexit
    //   37: aload_1
    //   38: athrow
    // Exception table:
    //   from	to	target	type
    //   3	28	33	finally
  }
  
  private void b() {
    b(this.g);
  }
  
  private void b(float paramFloat) {
    int i;
    int j = this.c;
    int k = (int)(j * paramFloat);
    if (k < 1) {
      i = 1;
    } else {
      i = k;
      if (k > j)
        i = j; 
    } 
    for (j = 0; j < i; j++)
      this.d[j] = this.f.b(); 
    this.e = i - 1;
  }
  
  private void c() {
    int j = this.c;
    this.c = j * 2;
    Object[] arrayOfObject = new Object[this.c];
    for (int i = 0; i < j; i++)
      arrayOfObject[i] = this.d[i]; 
    this.d = arrayOfObject;
  }
  
  public T a() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield e : I
    //   6: iconst_m1
    //   7: if_icmpne -> 23
    //   10: aload_0
    //   11: getfield g : F
    //   14: fconst_0
    //   15: fcmpl
    //   16: ifle -> 23
    //   19: aload_0
    //   20: invokespecial b : ()V
    //   23: aload_0
    //   24: getfield d : [Ljava/lang/Object;
    //   27: aload_0
    //   28: getfield e : I
    //   31: aaload
    //   32: checkcast com/github/mikephil/charting/utils/ObjectPool$Poolable
    //   35: astore_1
    //   36: aload_1
    //   37: getstatic com/github/mikephil/charting/utils/ObjectPool$Poolable.r : I
    //   40: putfield s : I
    //   43: aload_0
    //   44: aload_0
    //   45: getfield e : I
    //   48: iconst_1
    //   49: isub
    //   50: putfield e : I
    //   53: aload_0
    //   54: monitorexit
    //   55: aload_1
    //   56: areturn
    //   57: astore_1
    //   58: aload_0
    //   59: monitorexit
    //   60: aload_1
    //   61: athrow
    // Exception table:
    //   from	to	target	type
    //   2	23	57	finally
    //   23	53	57	finally
  }
  
  public void a(float paramFloat) {
    float f;
    if (paramFloat > 1.0F) {
      f = 1.0F;
    } else {
      f = paramFloat;
      if (paramFloat < 0.0F)
        f = 0.0F; 
    } 
    this.g = f;
  }
  
  public void a(T paramT) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: getfield s : I
    //   6: getstatic com/github/mikephil/charting/utils/ObjectPool$Poolable.r : I
    //   9: if_icmpeq -> 76
    //   12: aload_1
    //   13: getfield s : I
    //   16: aload_0
    //   17: getfield b : I
    //   20: if_icmpne -> 33
    //   23: new java/lang/IllegalArgumentException
    //   26: dup
    //   27: ldc 'The object passed is already stored in this pool!'
    //   29: invokespecial <init> : (Ljava/lang/String;)V
    //   32: athrow
    //   33: new java/lang/StringBuilder
    //   36: dup
    //   37: invokespecial <init> : ()V
    //   40: astore_2
    //   41: aload_2
    //   42: ldc 'The object to recycle already belongs to poolId '
    //   44: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   47: pop
    //   48: aload_2
    //   49: aload_1
    //   50: getfield s : I
    //   53: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   56: pop
    //   57: aload_2
    //   58: ldc '.  Object cannot belong to two different pool instances simultaneously!'
    //   60: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   63: pop
    //   64: new java/lang/IllegalArgumentException
    //   67: dup
    //   68: aload_2
    //   69: invokevirtual toString : ()Ljava/lang/String;
    //   72: invokespecial <init> : (Ljava/lang/String;)V
    //   75: athrow
    //   76: aload_0
    //   77: aload_0
    //   78: getfield e : I
    //   81: iconst_1
    //   82: iadd
    //   83: putfield e : I
    //   86: aload_0
    //   87: getfield e : I
    //   90: aload_0
    //   91: getfield d : [Ljava/lang/Object;
    //   94: arraylength
    //   95: if_icmplt -> 102
    //   98: aload_0
    //   99: invokespecial c : ()V
    //   102: aload_1
    //   103: aload_0
    //   104: getfield b : I
    //   107: putfield s : I
    //   110: aload_0
    //   111: getfield d : [Ljava/lang/Object;
    //   114: aload_0
    //   115: getfield e : I
    //   118: aload_1
    //   119: aastore
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
    //   2	33	123	finally
    //   33	76	123	finally
    //   76	102	123	finally
    //   102	120	123	finally
  }
  
  public static abstract class Poolable {
    public static int r = -1;
    
    int s = r;
    
    protected abstract Poolable b();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\github\mikephil\chartin\\utils\ObjectPool.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */