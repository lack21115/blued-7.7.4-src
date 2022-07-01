package com.google.common.primitives;

import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.Immutable;
import java.io.Serializable;
import java.util.AbstractList;
import java.util.List;
import java.util.RandomAccess;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

@Immutable
public final class ImmutableLongArray implements Serializable {
  private static final ImmutableLongArray a = new ImmutableLongArray(new long[0]);
  
  private final long[] b;
  
  private final transient int c;
  
  private final int d;
  
  private ImmutableLongArray(long[] paramArrayOflong) {
    this(paramArrayOflong, 0, paramArrayOflong.length);
  }
  
  private ImmutableLongArray(long[] paramArrayOflong, int paramInt1, int paramInt2) {
    this.b = paramArrayOflong;
    this.c = paramInt1;
    this.d = paramInt2;
  }
  
  public int a() {
    return this.d - this.c;
  }
  
  public int a(long paramLong) {
    for (int i = this.c; i < this.d; i++) {
      if (this.b[i] == paramLong)
        return i - this.c; 
    } 
    return -1;
  }
  
  public long a(int paramInt) {
    Preconditions.a(paramInt, a());
    return this.b[this.c + paramInt];
  }
  
  public ImmutableLongArray a(int paramInt1, int paramInt2) {
    Preconditions.a(paramInt1, paramInt2, a());
    if (paramInt1 == paramInt2)
      return a; 
    long[] arrayOfLong = this.b;
    int i = this.c;
    return new ImmutableLongArray(arrayOfLong, paramInt1 + i, i + paramInt2);
  }
  
  public int b(long paramLong) {
    int i = this.d - 1;
    while (true) {
      int j = this.c;
      if (i >= j) {
        if (this.b[i] == paramLong)
          return i - j; 
        i--;
        continue;
      } 
      return -1;
    } 
  }
  
  public boolean b() {
    return (this.d == this.c);
  }
  
  public List<Long> c() {
    return new AsList(this);
  }
  
  public boolean equals(@NullableDecl Object paramObject) {
    if (paramObject == this)
      return true; 
    if (!(paramObject instanceof ImmutableLongArray))
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
      j = j * 31 + Longs.a(this.b[i]);
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
  
  static class AsList extends AbstractList<Long> implements Serializable, RandomAccess {
    private final ImmutableLongArray a;
    
    private AsList(ImmutableLongArray param1ImmutableLongArray) {
      this.a = param1ImmutableLongArray;
    }
    
    public Long a(int param1Int) {
      return Long.valueOf(this.a.a(param1Int));
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
      int i = ImmutableLongArray.b(this.a);
      param1Object = param1Object.iterator();
      while (param1Object.hasNext()) {
        Long long_ = (Long)param1Object.next();
        if (long_ instanceof Long) {
          if (ImmutableLongArray.a(this.a)[i] != ((Long)long_).longValue())
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
      return (param1Object instanceof Long) ? this.a.a(((Long)param1Object).longValue()) : -1;
    }
    
    public int lastIndexOf(Object param1Object) {
      return (param1Object instanceof Long) ? this.a.b(((Long)param1Object).longValue()) : -1;
    }
    
    public int size() {
      return this.a.a();
    }
    
    public List<Long> subList(int param1Int1, int param1Int2) {
      return this.a.a(param1Int1, param1Int2).c();
    }
    
    public String toString() {
      return this.a.toString();
    }
  }
  
  public static final class Builder {}
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\common\primitives\ImmutableLongArray.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */