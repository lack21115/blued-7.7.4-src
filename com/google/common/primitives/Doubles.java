package com.google.common.primitives;

import com.google.common.base.Converter;
import com.google.common.base.Preconditions;
import java.io.Serializable;
import java.util.AbstractList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.RandomAccess;
import java.util.regex.Pattern;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

public final class Doubles extends DoublesMethodsForWeb {
  static final Pattern a = a();
  
  public static int a(double paramDouble) {
    return Double.valueOf(paramDouble).hashCode();
  }
  
  private static Pattern a() {
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append("(?:\\d+#(?:\\.\\d*#)?|\\.\\d+#)");
    stringBuilder1.append("(?:[eE][+-]?\\d+#)?[fFdD]?");
    String str1 = stringBuilder1.toString();
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append("0[xX]");
    stringBuilder2.append("(?:[0-9a-fA-F]+#(?:\\.[0-9a-fA-F]*#)?|\\.[0-9a-fA-F]+#)");
    stringBuilder2.append("[pP][+-]?\\d+#[fFdD]?");
    String str2 = stringBuilder2.toString();
    StringBuilder stringBuilder3 = new StringBuilder();
    stringBuilder3.append("[+-]?(?:NaN|Infinity|");
    stringBuilder3.append(str1);
    stringBuilder3.append("|");
    stringBuilder3.append(str2);
    stringBuilder3.append(")");
    return Pattern.compile(stringBuilder3.toString().replace("#", "+"));
  }
  
  private static int c(double[] paramArrayOfdouble, double paramDouble, int paramInt1, int paramInt2) {
    while (paramInt1 < paramInt2) {
      if (paramArrayOfdouble[paramInt1] == paramDouble)
        return paramInt1; 
      paramInt1++;
    } 
    return -1;
  }
  
  private static int d(double[] paramArrayOfdouble, double paramDouble, int paramInt1, int paramInt2) {
    while (--paramInt2 >= paramInt1) {
      if (paramArrayOfdouble[paramInt2] == paramDouble)
        return paramInt2; 
      paramInt2--;
    } 
    return -1;
  }
  
  static class DoubleArrayAsList extends AbstractList<Double> implements Serializable, RandomAccess {
    final double[] a;
    
    final int b;
    
    final int c;
    
    DoubleArrayAsList(double[] param1ArrayOfdouble, int param1Int1, int param1Int2) {
      this.a = param1ArrayOfdouble;
      this.b = param1Int1;
      this.c = param1Int2;
    }
    
    public Double a(int param1Int) {
      Preconditions.a(param1Int, size());
      return Double.valueOf(this.a[this.b + param1Int]);
    }
    
    public Double a(int param1Int, Double param1Double) {
      Preconditions.a(param1Int, size());
      double[] arrayOfDouble = this.a;
      int i = this.b;
      double d = arrayOfDouble[i + param1Int];
      arrayOfDouble[i + param1Int] = ((Double)Preconditions.a(param1Double)).doubleValue();
      return Double.valueOf(d);
    }
    
    public boolean contains(Object param1Object) {
      return (param1Object instanceof Double && Doubles.a(this.a, ((Double)param1Object).doubleValue(), this.b, this.c) != -1);
    }
    
    public boolean equals(@NullableDecl Object param1Object) {
      if (param1Object == this)
        return true; 
      if (param1Object instanceof DoubleArrayAsList) {
        param1Object = param1Object;
        int j = size();
        if (param1Object.size() != j)
          return false; 
        for (int i = 0; i < j; i++) {
          if (this.a[this.b + i] != ((DoubleArrayAsList)param1Object).a[((DoubleArrayAsList)param1Object).b + i])
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
        j = j * 31 + Doubles.a(this.a[i]);
        i++;
      } 
      return j;
    }
    
    public int indexOf(Object param1Object) {
      if (param1Object instanceof Double) {
        int i = Doubles.a(this.a, ((Double)param1Object).doubleValue(), this.b, this.c);
        if (i >= 0)
          return i - this.b; 
      } 
      return -1;
    }
    
    public boolean isEmpty() {
      return false;
    }
    
    public int lastIndexOf(Object param1Object) {
      if (param1Object instanceof Double) {
        int i = Doubles.b(this.a, ((Double)param1Object).doubleValue(), this.b, this.c);
        if (i >= 0)
          return i - this.b; 
      } 
      return -1;
    }
    
    public int size() {
      return this.c - this.b;
    }
    
    public List<Double> subList(int param1Int1, int param1Int2) {
      Preconditions.a(param1Int1, param1Int2, size());
      if (param1Int1 == param1Int2)
        return Collections.emptyList(); 
      double[] arrayOfDouble = this.a;
      int i = this.b;
      return new DoubleArrayAsList(arrayOfDouble, param1Int1 + i, i + param1Int2);
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
  
  static final class DoubleConverter extends Converter<String, Double> implements Serializable {
    static final DoubleConverter a = new DoubleConverter();
    
    protected Double a(String param1String) {
      return Double.valueOf(param1String);
    }
    
    protected String a(Double param1Double) {
      return param1Double.toString();
    }
    
    public String toString() {
      return "Doubles.stringConverter()";
    }
  }
  
  enum LexicographicalComparator implements Comparator<double[]> {
    a;
    
    public int a(double[] param1ArrayOfdouble1, double[] param1ArrayOfdouble2) {
      int j = Math.min(param1ArrayOfdouble1.length, param1ArrayOfdouble2.length);
      for (int i = 0; i < j; i++) {
        int k = Double.compare(param1ArrayOfdouble1[i], param1ArrayOfdouble2[i]);
        if (k != 0)
          return k; 
      } 
      return param1ArrayOfdouble1.length - param1ArrayOfdouble2.length;
    }
    
    public String toString() {
      return "Doubles.lexicographicalComparator()";
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\common\primitives\Doubles.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */