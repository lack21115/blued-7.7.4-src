package com.google.common.primitives;

import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.Immutable;
import java.io.Serializable;
import java.util.AbstractList;
import java.util.List;
import java.util.RandomAccess;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

@Immutable
public final class ImmutableIntArray implements Serializable {
  private static final ImmutableIntArray a = new ImmutableIntArray(new int[0]);
  
  private final int[] b;
  
  private final transient int c;
  
  private final int d;
  
  private ImmutableIntArray(int[] paramArrayOfint) {
    this(paramArrayOfint, 0, paramArrayOfint.length);
  }
  
  private ImmutableIntArray(int[] paramArrayOfint, int paramInt1, int paramInt2) {
    this.b = paramArrayOfint;
    this.c = paramInt1;
    this.d = paramInt2;
  }
  
  public int a() {
    return this.d - this.c;
  }
  
  public int a(int paramInt) {
    Preconditions.a(paramInt, a());
    return this.b[this.c + paramInt];
  }
  
  public ImmutableIntArray a(int paramInt1, int paramInt2) {
    Preconditions.a(paramInt1, paramInt2, a());
    if (paramInt1 == paramInt2)
      return a; 
    int[] arrayOfInt = this.b;
    int i = this.c;
    return new ImmutableIntArray(arrayOfInt, paramInt1 + i, i + paramInt2);
  }
  
  public int b(int paramInt) {
    for (int i = this.c; i < this.d; i++) {
      if (this.b[i] == paramInt)
        return i - this.c; 
    } 
    return -1;
  }
  
  public boolean b() {
    return (this.d == this.c);
  }
  
  public int c(int paramInt) {
    int i = this.d - 1;
    while (true) {
      int j = this.c;
      if (i >= j) {
        if (this.b[i] == paramInt)
          return i - j; 
        i--;
        continue;
      } 
      return -1;
    } 
  }
  
  public List<Integer> c() {
    return new AsList(this);
  }
  
  public boolean equals(@NullableDecl Object paramObject) {
    if (paramObject == this)
      return true; 
    if (!(paramObject instanceof ImmutableIntArray))
      return false; 
    paramObject = paramObject;
    if (a() != paramObject.a())
      return false; 
    for (int i = 0; i < a(); i++) {
      if (a(i) != paramObject.a(i))
        return false; 
    } 
    return true;
  }
  
  public int hashCode() {
    int i = this.c;
    int j = 1;
    while (i < this.d) {
      j = j * 31 + Ints.a(this.b[i]);
      i++;
    } 
    return j;
  }
  
  public String toString() {
    if (b())
      return "[]"; 
    StringBuilder stringBuilder = new StringBuilder(a() * 5);
    stringBuilder.append('[');
    stringBuilder.append(this.b[this.c]);
    int i = this.c;
    while (true) {
      if (++i < this.d) {
        stringBuilder.append(", ");
        stringBuilder.append(this.b[i]);
        continue;
      } 
      stringBuilder.append(']');
      return stringBuilder.toString();
    } 
  }
  
  static class AsList extends AbstractList<Integer> implements Serializable, RandomAccess {
    private final ImmutableIntArray a;
    
    private AsList(ImmutableIntArray param1ImmutableIntArray) {
      this.a = param1ImmutableIntArray;
    }
    
    public Integer a(int param1Int) {
      return Integer.valueOf(this.a.a(param1Int));
    }
    
    public boolean contains(Object param1Object) {
      return (indexOf(param1Object) >= 0);
    }
    
    public boolean equals(@NullableDecl Object param1Object) {
      if (param1Object instanceof AsList) {
        param1Object = param1Object;
        return this.a.equals(((AsList)param1Object).a);
      } 
      if (!(param1Object instanceof List))
        return false; 
      param1Object = param1Object;
      if (size() != param1Object.size())
        return false; 
      int i = ImmutableIntArray.b(this.a);
      param1Object = param1Object.iterator();
      while (param1Object.hasNext()) {
        Integer integer = (Integer)param1Object.next();
        if (integer instanceof Integer) {
          if (ImmutableIntArray.a(this.a)[i] != ((Integer)integer).intValue())
            return false; 
          i++;
          continue;
        } 
        return false;
      } 
      return true;
    }
    
    public int hashCode() {
      return this.a.hashCode();
    }
    
    public int indexOf(Object param1Object) {
      return (param1Object instanceof Integer) ? this.a.b(((Integer)param1Object).intValue()) : -1;
    }
    
    public int lastIndexOf(Object param1Object) {
      return (param1Object instanceof Integer) ? this.a.c(((Integer)param1Object).intValue()) : -1;
    }
    
    public int size() {
      return this.a.a();
    }
    
    public List<Integer> subList(int param1Int1, int param1Int2) {
      return this.a.a(param1Int1, param1Int2).c();
    }
    
    public String toString() {
      return this.a.toString();
    }
  }
  
  public static final class Builder {}
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\common\primitives\ImmutableIntArray.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */