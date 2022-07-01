package com.google.common.primitives;

import com.google.common.base.Preconditions;
import java.io.Serializable;
import java.util.AbstractList;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

public final class Bytes {
  public static int a(byte paramByte) {
    return paramByte;
  }
  
  private static int c(byte[] paramArrayOfbyte, byte paramByte, int paramInt1, int paramInt2) {
    while (paramInt1 < paramInt2) {
      if (paramArrayOfbyte[paramInt1] == paramByte)
        return paramInt1; 
      paramInt1++;
    } 
    return -1;
  }
  
  private static int d(byte[] paramArrayOfbyte, byte paramByte, int paramInt1, int paramInt2) {
    while (--paramInt2 >= paramInt1) {
      if (paramArrayOfbyte[paramInt2] == paramByte)
        return paramInt2; 
      paramInt2--;
    } 
    return -1;
  }
  
  static class ByteArrayAsList extends AbstractList<Byte> implements Serializable, RandomAccess {
    final byte[] a;
    
    final int b;
    
    final int c;
    
    ByteArrayAsList(byte[] param1ArrayOfbyte, int param1Int1, int param1Int2) {
      this.a = param1ArrayOfbyte;
      this.b = param1Int1;
      this.c = param1Int2;
    }
    
    public Byte a(int param1Int) {
      Preconditions.a(param1Int, size());
      return Byte.valueOf(this.a[this.b + param1Int]);
    }
    
    public Byte a(int param1Int, Byte param1Byte) {
      Preconditions.a(param1Int, size());
      byte[] arrayOfByte = this.a;
      int i = this.b;
      byte b = arrayOfByte[i + param1Int];
      arrayOfByte[i + param1Int] = ((Byte)Preconditions.a(param1Byte)).byteValue();
      return Byte.valueOf(b);
    }
    
    public boolean contains(Object param1Object) {
      return (param1Object instanceof Byte && Bytes.a(this.a, ((Byte)param1Object).byteValue(), this.b, this.c) != -1);
    }
    
    public boolean equals(@NullableDecl Object param1Object) {
      if (param1Object == this)
        return true; 
      if (param1Object instanceof ByteArrayAsList) {
        param1Object = param1Object;
        int j = size();
        if (param1Object.size() != j)
          return false; 
        for (int i = 0; i < j; i++) {
          if (this.a[this.b + i] != ((ByteArrayAsList)param1Object).a[((ByteArrayAsList)param1Object).b + i])
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
        j = j * 31 + Bytes.a(this.a[i]);
        i++;
      } 
      return j;
    }
    
    public int indexOf(Object param1Object) {
      if (param1Object instanceof Byte) {
        int i = Bytes.a(this.a, ((Byte)param1Object).byteValue(), this.b, this.c);
        if (i >= 0)
          return i - this.b; 
      } 
      return -1;
    }
    
    public boolean isEmpty() {
      return false;
    }
    
    public int lastIndexOf(Object param1Object) {
      if (param1Object instanceof Byte) {
        int i = Bytes.b(this.a, ((Byte)param1Object).byteValue(), this.b, this.c);
        if (i >= 0)
          return i - this.b; 
      } 
      return -1;
    }
    
    public int size() {
      return this.c - this.b;
    }
    
    public List<Byte> subList(int param1Int1, int param1Int2) {
      Preconditions.a(param1Int1, param1Int2, size());
      if (param1Int1 == param1Int2)
        return Collections.emptyList(); 
      byte[] arrayOfByte = this.a;
      int i = this.b;
      return new ByteArrayAsList(arrayOfByte, param1Int1 + i, i + param1Int2);
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
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\common\primitives\Bytes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */