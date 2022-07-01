package com.google.common.primitives;

import com.google.common.base.Preconditions;
import java.io.Serializable;
import java.util.AbstractList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.RandomAccess;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

public final class Booleans {
  public static int a(boolean paramBoolean) {
    return paramBoolean ? 1231 : 1237;
  }
  
  public static int a(boolean paramBoolean1, boolean paramBoolean2) {
    return (paramBoolean1 == paramBoolean2) ? 0 : (paramBoolean1 ? 1 : -1);
  }
  
  private static int c(boolean[] paramArrayOfboolean, boolean paramBoolean, int paramInt1, int paramInt2) {
    while (paramInt1 < paramInt2) {
      if (paramArrayOfboolean[paramInt1] == paramBoolean)
        return paramInt1; 
      paramInt1++;
    } 
    return -1;
  }
  
  private static int d(boolean[] paramArrayOfboolean, boolean paramBoolean, int paramInt1, int paramInt2) {
    while (--paramInt2 >= paramInt1) {
      if (paramArrayOfboolean[paramInt2] == paramBoolean)
        return paramInt2; 
      paramInt2--;
    } 
    return -1;
  }
  
  static class BooleanArrayAsList extends AbstractList<Boolean> implements Serializable, RandomAccess {
    final boolean[] a;
    
    final int b;
    
    final int c;
    
    BooleanArrayAsList(boolean[] param1ArrayOfboolean, int param1Int1, int param1Int2) {
      this.a = param1ArrayOfboolean;
      this.b = param1Int1;
      this.c = param1Int2;
    }
    
    public Boolean a(int param1Int) {
      Preconditions.a(param1Int, size());
      return Boolean.valueOf(this.a[this.b + param1Int]);
    }
    
    public Boolean a(int param1Int, Boolean param1Boolean) {
      Preconditions.a(param1Int, size());
      boolean[] arrayOfBoolean = this.a;
      int i = this.b;
      boolean bool = arrayOfBoolean[i + param1Int];
      arrayOfBoolean[i + param1Int] = ((Boolean)Preconditions.a(param1Boolean)).booleanValue();
      return Boolean.valueOf(bool);
    }
    
    public boolean contains(Object param1Object) {
      return (param1Object instanceof Boolean && Booleans.a(this.a, ((Boolean)param1Object).booleanValue(), this.b, this.c) != -1);
    }
    
    public boolean equals(@NullableDecl Object param1Object) {
      if (param1Object == this)
        return true; 
      if (param1Object instanceof BooleanArrayAsList) {
        param1Object = param1Object;
        int j = size();
        if (param1Object.size() != j)
          return false; 
        for (int i = 0; i < j; i++) {
          if (this.a[this.b + i] != ((BooleanArrayAsList)param1Object).a[((BooleanArrayAsList)param1Object).b + i])
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
        j = j * 31 + Booleans.a(this.a[i]);
        i++;
      } 
      return j;
    }
    
    public int indexOf(Object param1Object) {
      if (param1Object instanceof Boolean) {
        int i = Booleans.a(this.a, ((Boolean)param1Object).booleanValue(), this.b, this.c);
        if (i >= 0)
          return i - this.b; 
      } 
      return -1;
    }
    
    public boolean isEmpty() {
      return false;
    }
    
    public int lastIndexOf(Object param1Object) {
      if (param1Object instanceof Boolean) {
        int i = Booleans.b(this.a, ((Boolean)param1Object).booleanValue(), this.b, this.c);
        if (i >= 0)
          return i - this.b; 
      } 
      return -1;
    }
    
    public int size() {
      return this.c - this.b;
    }
    
    public List<Boolean> subList(int param1Int1, int param1Int2) {
      Preconditions.a(param1Int1, param1Int2, size());
      if (param1Int1 == param1Int2)
        return Collections.emptyList(); 
      boolean[] arrayOfBoolean = this.a;
      int i = this.b;
      return new BooleanArrayAsList(arrayOfBoolean, param1Int1 + i, i + param1Int2);
    }
    
    public String toString() {
      String str;
      StringBuilder stringBuilder = new StringBuilder(size() * 7);
      if (this.a[this.b]) {
        str = "[true";
      } else {
        str = "[false";
      } 
      stringBuilder.append(str);
      int i = this.b;
      while (true) {
        if (++i < this.c) {
          if (this.a[i]) {
            str = ", true";
          } else {
            str = ", false";
          } 
          stringBuilder.append(str);
          continue;
        } 
        stringBuilder.append(']');
        return stringBuilder.toString();
      } 
    }
  }
  
  enum BooleanComparator implements Comparator<Boolean> {
    a(1, "Booleans.trueFirst()"),
    b(-1, "Booleans.falseFirst()");
    
    private final int c;
    
    private final String d;
    
    BooleanComparator(int param1Int1, String param1String1) {
      this.c = param1Int1;
      this.d = param1String1;
    }
    
    public int a(Boolean param1Boolean1, Boolean param1Boolean2) {
      byte b;
      boolean bool = param1Boolean1.booleanValue();
      int i = 0;
      if (bool) {
        b = this.c;
      } else {
        b = 0;
      } 
      if (param1Boolean2.booleanValue())
        i = this.c; 
      return i - b;
    }
    
    public String toString() {
      return this.d;
    }
  }
  
  enum LexicographicalComparator implements Comparator<boolean[]> {
    a;
    
    public int a(boolean[] param1ArrayOfboolean1, boolean[] param1ArrayOfboolean2) {
      int j = Math.min(param1ArrayOfboolean1.length, param1ArrayOfboolean2.length);
      for (int i = 0; i < j; i++) {
        int k = Booleans.a(param1ArrayOfboolean1[i], param1ArrayOfboolean2[i]);
        if (k != 0)
          return k; 
      } 
      return param1ArrayOfboolean1.length - param1ArrayOfboolean2.length;
    }
    
    public String toString() {
      return "Booleans.lexicographicalComparator()";
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\common\primitives\Booleans.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */