package com.google.common.primitives;

import com.google.common.base.Preconditions;
import java.io.Serializable;
import java.util.AbstractList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.RandomAccess;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

public final class Chars {
  public static int a(char paramChar) {
    return paramChar;
  }
  
  public static int a(char paramChar1, char paramChar2) {
    return paramChar1 - paramChar2;
  }
  
  private static int c(char[] paramArrayOfchar, char paramChar, int paramInt1, int paramInt2) {
    while (paramInt1 < paramInt2) {
      if (paramArrayOfchar[paramInt1] == paramChar)
        return paramInt1; 
      paramInt1++;
    } 
    return -1;
  }
  
  private static int d(char[] paramArrayOfchar, char paramChar, int paramInt1, int paramInt2) {
    while (--paramInt2 >= paramInt1) {
      if (paramArrayOfchar[paramInt2] == paramChar)
        return paramInt2; 
      paramInt2--;
    } 
    return -1;
  }
  
  static class CharArrayAsList extends AbstractList<Character> implements Serializable, RandomAccess {
    final char[] a;
    
    final int b;
    
    final int c;
    
    CharArrayAsList(char[] param1ArrayOfchar, int param1Int1, int param1Int2) {
      this.a = param1ArrayOfchar;
      this.b = param1Int1;
      this.c = param1Int2;
    }
    
    public Character a(int param1Int) {
      Preconditions.a(param1Int, size());
      return Character.valueOf(this.a[this.b + param1Int]);
    }
    
    public Character a(int param1Int, Character param1Character) {
      Preconditions.a(param1Int, size());
      char[] arrayOfChar = this.a;
      int i = this.b;
      char c = arrayOfChar[i + param1Int];
      arrayOfChar[i + param1Int] = ((Character)Preconditions.a(param1Character)).charValue();
      return Character.valueOf(c);
    }
    
    public boolean contains(Object param1Object) {
      return (param1Object instanceof Character && Chars.a(this.a, ((Character)param1Object).charValue(), this.b, this.c) != -1);
    }
    
    public boolean equals(@NullableDecl Object param1Object) {
      if (param1Object == this)
        return true; 
      if (param1Object instanceof CharArrayAsList) {
        param1Object = param1Object;
        int j = size();
        if (param1Object.size() != j)
          return false; 
        for (int i = 0; i < j; i++) {
          if (this.a[this.b + i] != ((CharArrayAsList)param1Object).a[((CharArrayAsList)param1Object).b + i])
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
        j = j * 31 + Chars.a(this.a[i]);
        i++;
      } 
      return j;
    }
    
    public int indexOf(Object param1Object) {
      if (param1Object instanceof Character) {
        int i = Chars.a(this.a, ((Character)param1Object).charValue(), this.b, this.c);
        if (i >= 0)
          return i - this.b; 
      } 
      return -1;
    }
    
    public boolean isEmpty() {
      return false;
    }
    
    public int lastIndexOf(Object param1Object) {
      if (param1Object instanceof Character) {
        int i = Chars.b(this.a, ((Character)param1Object).charValue(), this.b, this.c);
        if (i >= 0)
          return i - this.b; 
      } 
      return -1;
    }
    
    public int size() {
      return this.c - this.b;
    }
    
    public List<Character> subList(int param1Int1, int param1Int2) {
      Preconditions.a(param1Int1, param1Int2, size());
      if (param1Int1 == param1Int2)
        return Collections.emptyList(); 
      char[] arrayOfChar = this.a;
      int i = this.b;
      return new CharArrayAsList(arrayOfChar, param1Int1 + i, i + param1Int2);
    }
    
    public String toString() {
      StringBuilder stringBuilder = new StringBuilder(size() * 3);
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
  
  enum LexicographicalComparator implements Comparator<char[]> {
    a;
    
    public int a(char[] param1ArrayOfchar1, char[] param1ArrayOfchar2) {
      int j = Math.min(param1ArrayOfchar1.length, param1ArrayOfchar2.length);
      for (int i = 0; i < j; i++) {
        int k = Chars.a(param1ArrayOfchar1[i], param1ArrayOfchar2[i]);
        if (k != 0)
          return k; 
      } 
      return param1ArrayOfchar1.length - param1ArrayOfchar2.length;
    }
    
    public String toString() {
      return "Chars.lexicographicalComparator()";
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\common\primitives\Chars.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */