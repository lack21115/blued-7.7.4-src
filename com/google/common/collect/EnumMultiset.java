package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.primitives.Ints;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

public final class EnumMultiset<E extends Enum<E>> extends AbstractMultiset<E> implements Serializable {
  private transient Class<E> a;
  
  private transient E[] b;
  
  private transient int[] c;
  
  private transient int d;
  
  private transient long e;
  
  private boolean c(@NullableDecl Object paramObject) {
    boolean bool = paramObject instanceof Enum;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (bool) {
      paramObject = paramObject;
      int i = paramObject.ordinal();
      E[] arrayOfE = this.b;
      bool1 = bool2;
      if (i < arrayOfE.length) {
        bool1 = bool2;
        if (arrayOfE[i] == paramObject)
          bool1 = true; 
      } 
    } 
    return bool1;
  }
  
  public int a(E paramE, int paramInt) {
    boolean bool;
    b(paramE);
    CollectPreconditions.a(paramInt, "occurrences");
    if (paramInt == 0)
      return a(paramE); 
    int i = paramE.ordinal();
    int j = this.c[i];
    long l2 = j;
    long l1 = paramInt;
    l2 += l1;
    if (l2 <= 2147483647L) {
      bool = true;
    } else {
      bool = false;
    } 
    Preconditions.a(bool, "too many occurrences: %s", l2);
    this.c[i] = (int)l2;
    if (j == 0)
      this.d++; 
    this.e += l1;
    return j;
  }
  
  public int a(@NullableDecl Object paramObject) {
    if (!c(paramObject))
      return 0; 
    paramObject = paramObject;
    return this.c[paramObject.ordinal()];
  }
  
  Iterator<E> a() {
    return new Itr<E>(this) {
        E a(int param1Int) {
          return (E)EnumMultiset.a(this.a)[param1Int];
        }
      };
  }
  
  public int b(E paramE, int paramInt) {
    b(paramE);
    CollectPreconditions.a(paramInt, "count");
    int i = paramE.ordinal();
    int[] arrayOfInt = this.c;
    int j = arrayOfInt[i];
    arrayOfInt[i] = paramInt;
    this.e += (paramInt - j);
    if (j == 0 && paramInt > 0) {
      this.d++;
      return j;
    } 
    if (j > 0 && paramInt == 0)
      this.d--; 
    return j;
  }
  
  public int b(@NullableDecl Object paramObject, int paramInt) {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: invokespecial c : (Ljava/lang/Object;)Z
    //   5: ifne -> 10
    //   8: iconst_0
    //   9: ireturn
    //   10: aload_1
    //   11: checkcast java/lang/Enum
    //   14: astore #5
    //   16: iload_2
    //   17: ldc 'occurrences'
    //   19: invokestatic a : (ILjava/lang/String;)I
    //   22: pop
    //   23: iload_2
    //   24: ifne -> 33
    //   27: aload_0
    //   28: aload_1
    //   29: invokevirtual a : (Ljava/lang/Object;)I
    //   32: ireturn
    //   33: aload #5
    //   35: invokevirtual ordinal : ()I
    //   38: istore_3
    //   39: aload_0
    //   40: getfield c : [I
    //   43: astore_1
    //   44: aload_1
    //   45: iload_3
    //   46: iaload
    //   47: istore #4
    //   49: iload #4
    //   51: ifne -> 56
    //   54: iconst_0
    //   55: ireturn
    //   56: iload #4
    //   58: iload_2
    //   59: if_icmpgt -> 91
    //   62: aload_1
    //   63: iload_3
    //   64: iconst_0
    //   65: iastore
    //   66: aload_0
    //   67: aload_0
    //   68: getfield d : I
    //   71: iconst_1
    //   72: isub
    //   73: putfield d : I
    //   76: aload_0
    //   77: aload_0
    //   78: getfield e : J
    //   81: iload #4
    //   83: i2l
    //   84: lsub
    //   85: putfield e : J
    //   88: iload #4
    //   90: ireturn
    //   91: aload_1
    //   92: iload_3
    //   93: iload #4
    //   95: iload_2
    //   96: isub
    //   97: iastore
    //   98: aload_0
    //   99: aload_0
    //   100: getfield e : J
    //   103: iload_2
    //   104: i2l
    //   105: lsub
    //   106: putfield e : J
    //   109: iload #4
    //   111: ireturn
  }
  
  Iterator<Multiset.Entry<E>> b() {
    return new Itr<Multiset.Entry<E>>(this) {
        Multiset.Entry<E> a(int param1Int) {
          return new Multisets.AbstractEntry<E>(this, param1Int) {
              public E a() {
                return (E)EnumMultiset.a(this.b.a)[this.a];
              }
              
              public int b() {
                return EnumMultiset.b(this.b.a)[this.a];
              }
            };
        }
      };
  }
  
  void b(@NullableDecl Object paramObject) {
    Preconditions.a(paramObject);
    if (c(paramObject))
      return; 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Expected an ");
    stringBuilder.append(this.a);
    stringBuilder.append(" but got ");
    stringBuilder.append(paramObject);
    throw new ClassCastException(stringBuilder.toString());
  }
  
  int c() {
    return this.d;
  }
  
  public void clear() {
    Arrays.fill(this.c, 0);
    this.e = 0L;
    this.d = 0;
  }
  
  public Iterator<E> iterator() {
    return Multisets.a(this);
  }
  
  public int size() {
    return Ints.b(this.e);
  }
  
  abstract class Itr<T> implements Iterator<T> {
    int b = 0;
    
    int c = -1;
    
    Itr(EnumMultiset this$0) {}
    
    abstract T b(int param1Int);
    
    public boolean hasNext() {
      while (this.b < (EnumMultiset.a(this.d)).length) {
        int[] arrayOfInt = EnumMultiset.b(this.d);
        int i = this.b;
        if (arrayOfInt[i] > 0)
          return true; 
        this.b = i + 1;
      } 
      return false;
    }
    
    public T next() {
      if (hasNext()) {
        T t = b(this.b);
        int i = this.b;
        this.c = i;
        this.b = i + 1;
        return t;
      } 
      throw new NoSuchElementException();
    }
    
    public void remove() {
      boolean bool;
      if (this.c >= 0) {
        bool = true;
      } else {
        bool = false;
      } 
      CollectPreconditions.a(bool);
      if (EnumMultiset.b(this.d)[this.c] > 0) {
        EnumMultiset.c(this.d);
        EnumMultiset enumMultiset = this.d;
        EnumMultiset.a(enumMultiset, EnumMultiset.d(enumMultiset) - EnumMultiset.b(this.d)[this.c]);
        EnumMultiset.b(this.d)[this.c] = 0;
      } 
      this.c = -1;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\common\collect\EnumMultiset.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */