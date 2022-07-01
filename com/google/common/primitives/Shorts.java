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

public final class Shorts extends ShortsMethodsForWeb {
  public static int a(short paramShort) {
    return paramShort;
  }
  
  public static int a(short paramShort1, short paramShort2) {
    return paramShort1 - paramShort2;
  }
  
  private static int c(short[] paramArrayOfshort, short paramShort, int paramInt1, int paramInt2) {
    while (paramInt1 < paramInt2) {
      if (paramArrayOfshort[paramInt1] == paramShort)
        return paramInt1; 
      paramInt1++;
    } 
    return -1;
  }
  
  private static int d(short[] paramArrayOfshort, short paramShort, int paramInt1, int paramInt2) {
    while (--paramInt2 >= paramInt1) {
      if (paramArrayOfshort[paramInt2] == paramShort)
        return paramInt2; 
      paramInt2--;
    } 
    return -1;
  }
  
  enum LexicographicalComparator implements Comparator<short[]> {
    a;
    
    public int a(short[] param1ArrayOfshort1, short[] param1ArrayOfshort2) {
      int j = Math.min(param1ArrayOfshort1.length, param1ArrayOfshort2.length);
      for (int i = 0; i < j; i++) {
        int k = Shorts.a(param1ArrayOfshort1[i], param1ArrayOfshort2[i]);
        if (k != 0)
          return k; 
      } 
      return param1ArrayOfshort1.length - param1ArrayOfshort2.length;
    }
    
    public String toString() {
      return "Shorts.lexicographicalComparator()";
    }
  }
  
  static class ShortArrayAsList extends AbstractList<Short> implements Serializable, RandomAccess {
    final short[] a;
    
    final int b;
    
    final int c;
    
    ShortArrayAsList(short[] param1ArrayOfshort, int param1Int1, int param1Int2) {
      this.a = param1ArrayOfshort;
      this.b = param1Int1;
      this.c = param1Int2;
    }
    
    public Short a(int param1Int) {
      Preconditions.a(param1Int, size());
      return Short.valueOf(this.a[this.b + param1Int]);
    }
    
    public Short a(int param1Int, Short param1Short) {
      Preconditions.a(param1Int, size());
      short[] arrayOfShort = this.a;
      int i = this.b;
      short s = arrayOfShort[i + param1Int];
      arrayOfShort[i + param1Int] = ((Short)Preconditions.a(param1Short)).shortValue();
      return Short.valueOf(s);
    }
    
    public boolean contains(@NullableDecl Object param1Object) {
      return (param1Object instanceof Short && Shorts.a(this.a, ((Short)param1Object).shortValue(), this.b, this.c) != -1);
    }
    
    public boolean equals(@NullableDecl Object param1Object) {
      if (param1Object == this)
        return true; 
      if (param1Object instanceof ShortArrayAsList) {
        param1Object = param1Object;
        int j = size();
        if (param1Object.size() != j)
          return false; 
        for (int i = 0; i < j; i++) {
          if (this.a[this.b + i] != ((ShortArrayAsList)param1Object).a[((ShortArrayAsList)param1Object).b + i])
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
        j = j * 31 + Shorts.a(this.a[i]);
        i++;
      } 
      return j;
    }
    
    public int indexOf(@NullableDecl Object param1Object) {
      if (param1Object instanceof Short) {
        int i = Shorts.a(this.a, ((Short)param1Object).shortValue(), this.b, this.c);
        if (i >= 0)
          return i - this.b; 
      } 
      return -1;
    }
    
    public boolean isEmpty() {
      return false;
    }
    
    public int lastIndexOf(@NullableDecl Object param1Object) {
      if (param1Object instanceof Short) {
        int i = Shorts.b(this.a, ((Short)param1Object).shortValue(), this.b, this.c);
        if (i >= 0)
          return i - this.b; 
      } 
      return -1;
    }
    
    public int size() {
      return this.c - this.b;
    }
    
    public List<Short> subList(int param1Int1, int param1Int2) {
      Preconditions.a(param1Int1, param1Int2, size());
      if (param1Int1 == param1Int2)
        return Collections.emptyList(); 
      short[] arrayOfShort = this.a;
      int i = this.b;
      return new ShortArrayAsList(arrayOfShort, param1Int1 + i, i + param1Int2);
    }
    
    public String toString() {
      StringBuilder stringBuilder = new StringBuilder(size() * 6);
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
  
  static final class ShortConverter extends Converter<String, Short> implements Serializable {
    static final ShortConverter a = new ShortConverter();
    
    protected Short a(String param1String) {
      return Short.decode(param1String);
    }
    
    protected String a(Short param1Short) {
      return param1Short.toString();
    }
    
    public String toString() {
      return "Shorts.stringConverter()";
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\common\primitives\Shorts.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */