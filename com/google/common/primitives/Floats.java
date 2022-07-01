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

public final class Floats extends FloatsMethodsForWeb {
  public static int a(float paramFloat) {
    return Float.valueOf(paramFloat).hashCode();
  }
  
  private static int c(float[] paramArrayOffloat, float paramFloat, int paramInt1, int paramInt2) {
    while (paramInt1 < paramInt2) {
      if (paramArrayOffloat[paramInt1] == paramFloat)
        return paramInt1; 
      paramInt1++;
    } 
    return -1;
  }
  
  private static int d(float[] paramArrayOffloat, float paramFloat, int paramInt1, int paramInt2) {
    while (--paramInt2 >= paramInt1) {
      if (paramArrayOffloat[paramInt2] == paramFloat)
        return paramInt2; 
      paramInt2--;
    } 
    return -1;
  }
  
  static class FloatArrayAsList extends AbstractList<Float> implements Serializable, RandomAccess {
    final float[] a;
    
    final int b;
    
    final int c;
    
    FloatArrayAsList(float[] param1ArrayOffloat, int param1Int1, int param1Int2) {
      this.a = param1ArrayOffloat;
      this.b = param1Int1;
      this.c = param1Int2;
    }
    
    public Float a(int param1Int) {
      Preconditions.a(param1Int, size());
      return Float.valueOf(this.a[this.b + param1Int]);
    }
    
    public Float a(int param1Int, Float param1Float) {
      Preconditions.a(param1Int, size());
      float[] arrayOfFloat = this.a;
      int i = this.b;
      float f = arrayOfFloat[i + param1Int];
      arrayOfFloat[i + param1Int] = ((Float)Preconditions.a(param1Float)).floatValue();
      return Float.valueOf(f);
    }
    
    public boolean contains(Object param1Object) {
      return (param1Object instanceof Float && Floats.a(this.a, ((Float)param1Object).floatValue(), this.b, this.c) != -1);
    }
    
    public boolean equals(@NullableDecl Object param1Object) {
      if (param1Object == this)
        return true; 
      if (param1Object instanceof FloatArrayAsList) {
        param1Object = param1Object;
        int j = size();
        if (param1Object.size() != j)
          return false; 
        for (int i = 0; i < j; i++) {
          if (this.a[this.b + i] != ((FloatArrayAsList)param1Object).a[((FloatArrayAsList)param1Object).b + i])
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
        j = j * 31 + Floats.a(this.a[i]);
        i++;
      } 
      return j;
    }
    
    public int indexOf(Object param1Object) {
      if (param1Object instanceof Float) {
        int i = Floats.a(this.a, ((Float)param1Object).floatValue(), this.b, this.c);
        if (i >= 0)
          return i - this.b; 
      } 
      return -1;
    }
    
    public boolean isEmpty() {
      return false;
    }
    
    public int lastIndexOf(Object param1Object) {
      if (param1Object instanceof Float) {
        int i = Floats.b(this.a, ((Float)param1Object).floatValue(), this.b, this.c);
        if (i >= 0)
          return i - this.b; 
      } 
      return -1;
    }
    
    public int size() {
      return this.c - this.b;
    }
    
    public List<Float> subList(int param1Int1, int param1Int2) {
      Preconditions.a(param1Int1, param1Int2, size());
      if (param1Int1 == param1Int2)
        return Collections.emptyList(); 
      float[] arrayOfFloat = this.a;
      int i = this.b;
      return new FloatArrayAsList(arrayOfFloat, param1Int1 + i, i + param1Int2);
    }
    
    public String toString() {
      StringBuilder stringBuilder = new StringBuilder(size() * 12);
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
  
  static final class FloatConverter extends Converter<String, Float> implements Serializable {
    static final FloatConverter a = new FloatConverter();
    
    protected Float a(String param1String) {
      return Float.valueOf(param1String);
    }
    
    protected String a(Float param1Float) {
      return param1Float.toString();
    }
    
    public String toString() {
      return "Floats.stringConverter()";
    }
  }
  
  enum LexicographicalComparator implements Comparator<float[]> {
    a;
    
    public int a(float[] param1ArrayOffloat1, float[] param1ArrayOffloat2) {
      int j = Math.min(param1ArrayOffloat1.length, param1ArrayOffloat2.length);
      for (int i = 0; i < j; i++) {
        int k = Float.compare(param1ArrayOffloat1[i], param1ArrayOffloat2[i]);
        if (k != 0)
          return k; 
      } 
      return param1ArrayOffloat1.length - param1ArrayOffloat2.length;
    }
    
    public String toString() {
      return "Floats.lexicographicalComparator()";
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\common\primitives\Floats.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */