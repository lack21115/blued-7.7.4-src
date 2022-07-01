package com.google.common.primitives;

import com.google.common.base.Converter;
import com.google.common.base.Preconditions;
import java.io.Serializable;
import java.util.AbstractList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.RandomAccess;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

public final class Ints extends IntsMethodsForWeb {
  public static int a(byte paramByte1, byte paramByte2, byte paramByte3, byte paramByte4) {
    return paramByte1 << 24 | (paramByte2 & 0xFF) << 16 | (paramByte3 & 0xFF) << 8 | paramByte4 & 0xFF;
  }
  
  public static int a(int paramInt) {
    return paramInt;
  }
  
  public static int a(int paramInt1, int paramInt2) {
    return (paramInt1 < paramInt2) ? -1 : ((paramInt1 > paramInt2) ? 1 : 0);
  }
  
  public static int a(int paramInt1, int paramInt2, int paramInt3) {
    boolean bool;
    if (paramInt2 <= paramInt3) {
      bool = true;
    } else {
      bool = false;
    } 
    Preconditions.a(bool, "min (%s) must be less than or equal to max (%s)", paramInt2, paramInt3);
    return Math.min(Math.max(paramInt1, paramInt2), paramInt3);
  }
  
  public static int a(long paramLong) {
    boolean bool;
    int i = (int)paramLong;
    if (i == paramLong) {
      bool = true;
    } else {
      bool = false;
    } 
    Preconditions.a(bool, "Out of range: %s", paramLong);
    return i;
  }
  
  public static int a(int... paramVarArgs) {
    boolean bool;
    int j = paramVarArgs.length;
    int i = 1;
    if (j > 0) {
      bool = true;
    } else {
      bool = false;
    } 
    Preconditions.a(bool);
    for (j = paramVarArgs[0]; i < paramVarArgs.length; j = k) {
      int k = j;
      if (paramVarArgs[i] < j)
        k = paramVarArgs[i]; 
      i++;
    } 
    return j;
  }
  
  public static int b(long paramLong) {
    return (paramLong > 2147483647L) ? Integer.MAX_VALUE : ((paramLong < -2147483648L) ? Integer.MIN_VALUE : (int)paramLong);
  }
  
  public static List<Integer> b(int... paramVarArgs) {
    return (paramVarArgs.length == 0) ? Collections.emptyList() : new IntArrayAsList(paramVarArgs);
  }
  
  private static int c(int[] paramArrayOfint, int paramInt1, int paramInt2, int paramInt3) {
    while (paramInt2 < paramInt3) {
      if (paramArrayOfint[paramInt2] == paramInt1)
        return paramInt2; 
      paramInt2++;
    } 
    return -1;
  }
  
  private static int d(int[] paramArrayOfint, int paramInt1, int paramInt2, int paramInt3) {
    while (--paramInt3 >= paramInt2) {
      if (paramArrayOfint[paramInt3] == paramInt1)
        return paramInt3; 
      paramInt3--;
    } 
    return -1;
  }
  
  static class IntArrayAsList extends AbstractList<Integer> implements Serializable, RandomAccess {
    final int[] a;
    
    final int b;
    
    final int c;
    
    IntArrayAsList(int[] param1ArrayOfint) {
      this(param1ArrayOfint, 0, param1ArrayOfint.length);
    }
    
    IntArrayAsList(int[] param1ArrayOfint, int param1Int1, int param1Int2) {
      this.a = param1ArrayOfint;
      this.b = param1Int1;
      this.c = param1Int2;
    }
    
    public Integer a(int param1Int) {
      Preconditions.a(param1Int, size());
      return Integer.valueOf(this.a[this.b + param1Int]);
    }
    
    public Integer a(int param1Int, Integer param1Integer) {
      Preconditions.a(param1Int, size());
      int[] arrayOfInt = this.a;
      int i = this.b;
      int j = arrayOfInt[i + param1Int];
      arrayOfInt[i + param1Int] = ((Integer)Preconditions.a(param1Integer)).intValue();
      return Integer.valueOf(j);
    }
    
    public boolean contains(Object param1Object) {
      return (param1Object instanceof Integer && Ints.a(this.a, ((Integer)param1Object).intValue(), this.b, this.c) != -1);
    }
    
    public boolean equals(@NullableDecl Object param1Object) {
      if (param1Object == this)
        return true; 
      if (param1Object instanceof IntArrayAsList) {
        param1Object = param1Object;
        int j = size();
        if (param1Object.size() != j)
          return false; 
        for (int i = 0; i < j; i++) {
          if (this.a[this.b + i] != ((IntArrayAsList)param1Object).a[((IntArrayAsList)param1Object).b + i])
            return false; 
        } 
        return true;
      } 
      return super.equals(param1Object);
    }
    
    public int hashCode() {
      int i = this.b;
      int j = 1;
      while (i < this.c) {
        j = j * 31 + Ints.a(this.a[i]);
        i++;
      } 
      return j;
    }
    
    public int indexOf(Object param1Object) {
      if (param1Object instanceof Integer) {
        int i = Ints.a(this.a, ((Integer)param1Object).intValue(), this.b, this.c);
        if (i >= 0)
          return i - this.b; 
      } 
      return -1;
    }
    
    public boolean isEmpty() {
      return false;
    }
    
    public int lastIndexOf(Object param1Object) {
      if (param1Object instanceof Integer) {
        int i = Ints.b(this.a, ((Integer)param1Object).intValue(), this.b, this.c);
        if (i >= 0)
          return i - this.b; 
      } 
      return -1;
    }
    
    public int size() {
      return this.c - this.b;
    }
    
    public List<Integer> subList(int param1Int1, int param1Int2) {
      Preconditions.a(param1Int1, param1Int2, size());
      if (param1Int1 == param1Int2)
        return Collections.emptyList(); 
      int[] arrayOfInt = this.a;
      int i = this.b;
      return new IntArrayAsList(arrayOfInt, param1Int1 + i, i + param1Int2);
    }
    
    public String toString() {
      StringBuilder stringBuilder = new StringBuilder(size() * 5);
      stringBuilder.append('[');
      stringBuilder.append(this.a[this.b]);
      int i = this.b;
      while (true) {
        if (++i < this.c) {
          stringBuilder.append(", ");
          stringBuilder.append(this.a[i]);
          continue;
        } 
        stringBuilder.append(']');
        return stringBuilder.toString();
      } 
    }
  }
  
  static final class IntConverter extends Converter<String, Integer> implements Serializable {
    static final IntConverter a = new IntConverter();
    
    protected Integer a(String param1String) {
      return Integer.decode(param1String);
    }
    
    protected String a(Integer param1Integer) {
      return param1Integer.toString();
    }
    
    public String toString() {
      return "Ints.stringConverter()";
    }
  }
  
  enum LexicographicalComparator implements Comparator<int[]> {
    a;
    
    public int a(int[] param1ArrayOfint1, int[] param1ArrayOfint2) {
      int j = Math.min(param1ArrayOfint1.length, param1ArrayOfint2.length);
      for (int i = 0; i < j; i++) {
        int k = Ints.a(param1ArrayOfint1[i], param1ArrayOfint2[i]);
        if (k != 0)
          return k; 
      } 
      return param1ArrayOfint1.length - param1ArrayOfint2.length;
    }
    
    public String toString() {
      return "Ints.lexicographicalComparator()";
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\common\primitives\Ints.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */