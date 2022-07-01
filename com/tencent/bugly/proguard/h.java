package com.tencent.bugly.proguard;

import java.util.List;
import java.util.Map;

public final class h {
  private StringBuilder a;
  
  private int b = 0;
  
  public h(StringBuilder paramStringBuilder, int paramInt) {
    this.a = paramStringBuilder;
    this.b = paramInt;
  }
  
  private <T> h a(T paramT, String paramString) {
    StringBuilder stringBuilder2;
    List list;
    StringBuilder stringBuilder1;
    h h1;
    if (paramT == null) {
      this.a.append("null\n");
      return this;
    } 
    if (paramT instanceof Byte) {
      byte b = ((Byte)paramT).byteValue();
      a(paramString);
      stringBuilder2 = this.a;
      stringBuilder2.append(b);
      stringBuilder2.append('\n');
      return this;
    } 
    if (stringBuilder2 instanceof Boolean) {
      byte b;
      boolean bool3 = ((Boolean)stringBuilder2).booleanValue();
      a(paramString);
      stringBuilder2 = this.a;
      if (bool3) {
        b = 84;
      } else {
        b = 70;
      } 
      stringBuilder2.append(b);
      stringBuilder2.append('\n');
      return this;
    } 
    if (stringBuilder2 instanceof Short) {
      short s = ((Short)stringBuilder2).shortValue();
      a(paramString);
      stringBuilder2 = this.a;
      stringBuilder2.append(s);
      stringBuilder2.append('\n');
      return this;
    } 
    if (stringBuilder2 instanceof Integer) {
      int m = ((Integer)stringBuilder2).intValue();
      a(paramString);
      stringBuilder2 = this.a;
      stringBuilder2.append(m);
      stringBuilder2.append('\n');
      return this;
    } 
    if (stringBuilder2 instanceof Long) {
      long l = ((Long)stringBuilder2).longValue();
      a(paramString);
      stringBuilder2 = this.a;
      stringBuilder2.append(l);
      stringBuilder2.append('\n');
      return this;
    } 
    if (stringBuilder2 instanceof Float) {
      float f = ((Float)stringBuilder2).floatValue();
      a(paramString);
      stringBuilder2 = this.a;
      stringBuilder2.append(f);
      stringBuilder2.append('\n');
      return this;
    } 
    if (stringBuilder2 instanceof Double) {
      double d = ((Double)stringBuilder2).doubleValue();
      a(paramString);
      stringBuilder2 = this.a;
      stringBuilder2.append(d);
      stringBuilder2.append('\n');
      return this;
    } 
    if (stringBuilder2 instanceof String) {
      a((String)stringBuilder2, paramString);
      return this;
    } 
    if (stringBuilder2 instanceof Map) {
      a((Map<?, ?>)stringBuilder2, paramString);
      return this;
    } 
    if (stringBuilder2 instanceof List) {
      list = (List)stringBuilder2;
      if (list == null) {
        a(paramString);
        this.a.append("null\t");
        return this;
      } 
      a(list.toArray(), paramString);
      return this;
    } 
    if (list instanceof k) {
      a((k)list, paramString);
      return this;
    } 
    if (list instanceof byte[]) {
      a((byte[])list, paramString);
      return this;
    } 
    if (list instanceof boolean[]) {
      a((boolean[])list, paramString);
      return this;
    } 
    boolean bool = list instanceof short[];
    int j = 0;
    int k = 0;
    boolean bool1 = false;
    boolean bool2 = false;
    int i = 0;
    if (bool) {
      short[] arrayOfShort = (short[])list;
      a(paramString);
      if (arrayOfShort == null) {
        this.a.append("null\n");
        return this;
      } 
      if (arrayOfShort.length == 0) {
        StringBuilder stringBuilder3 = this.a;
        stringBuilder3.append(arrayOfShort.length);
        stringBuilder3.append(", []\n");
        return this;
      } 
      StringBuilder stringBuilder = this.a;
      stringBuilder.append(arrayOfShort.length);
      stringBuilder.append(", [\n");
      h1 = new h(this.a, this.b + 1);
      j = arrayOfShort.length;
      while (i < j) {
        k = arrayOfShort[i];
        h1.a(null);
        StringBuilder stringBuilder3 = h1.a;
        stringBuilder3.append(k);
        stringBuilder3.append('\n');
        i++;
      } 
      a(null);
      stringBuilder1 = this.a;
      stringBuilder1.append(']');
      stringBuilder1.append('\n');
      return this;
    } 
    if (stringBuilder1 instanceof int[]) {
      int[] arrayOfInt = (int[])stringBuilder1;
      a((String)h1);
      if (arrayOfInt == null) {
        this.a.append("null\n");
        return this;
      } 
      if (arrayOfInt.length == 0) {
        StringBuilder stringBuilder3 = this.a;
        stringBuilder3.append(arrayOfInt.length);
        stringBuilder3.append(", []\n");
        return this;
      } 
      StringBuilder stringBuilder = this.a;
      stringBuilder.append(arrayOfInt.length);
      stringBuilder.append(", [\n");
      h1 = new h(this.a, this.b + 1);
      k = arrayOfInt.length;
      for (i = j; i < k; i++) {
        j = arrayOfInt[i];
        h1.a(null);
        StringBuilder stringBuilder3 = h1.a;
        stringBuilder3.append(j);
        stringBuilder3.append('\n');
      } 
      a(null);
      stringBuilder1 = this.a;
      stringBuilder1.append(']');
      stringBuilder1.append('\n');
      return this;
    } 
    if (stringBuilder1 instanceof long[]) {
      long[] arrayOfLong = (long[])stringBuilder1;
      a((String)h1);
      if (arrayOfLong == null) {
        this.a.append("null\n");
        return this;
      } 
      if (arrayOfLong.length == 0) {
        StringBuilder stringBuilder3 = this.a;
        stringBuilder3.append(arrayOfLong.length);
        stringBuilder3.append(", []\n");
        return this;
      } 
      StringBuilder stringBuilder = this.a;
      stringBuilder.append(arrayOfLong.length);
      stringBuilder.append(", [\n");
      h1 = new h(this.a, this.b + 1);
      j = arrayOfLong.length;
      for (i = k; i < j; i++) {
        long l = arrayOfLong[i];
        h1.a(null);
        StringBuilder stringBuilder3 = h1.a;
        stringBuilder3.append(l);
        stringBuilder3.append('\n');
      } 
      a(null);
      stringBuilder1 = this.a;
      stringBuilder1.append(']');
      stringBuilder1.append('\n');
      return this;
    } 
    if (stringBuilder1 instanceof float[]) {
      float[] arrayOfFloat = (float[])stringBuilder1;
      a((String)h1);
      if (arrayOfFloat == null) {
        this.a.append("null\n");
        return this;
      } 
      if (arrayOfFloat.length == 0) {
        StringBuilder stringBuilder3 = this.a;
        stringBuilder3.append(arrayOfFloat.length);
        stringBuilder3.append(", []\n");
        return this;
      } 
      StringBuilder stringBuilder = this.a;
      stringBuilder.append(arrayOfFloat.length);
      stringBuilder.append(", [\n");
      h1 = new h(this.a, this.b + 1);
      j = arrayOfFloat.length;
      for (i = bool1; i < j; i++) {
        float f = arrayOfFloat[i];
        h1.a(null);
        StringBuilder stringBuilder3 = h1.a;
        stringBuilder3.append(f);
        stringBuilder3.append('\n');
      } 
      a(null);
      stringBuilder1 = this.a;
      stringBuilder1.append(']');
      stringBuilder1.append('\n');
      return this;
    } 
    if (stringBuilder1 instanceof double[]) {
      double[] arrayOfDouble = (double[])stringBuilder1;
      a((String)h1);
      if (arrayOfDouble == null) {
        this.a.append("null\n");
        return this;
      } 
      if (arrayOfDouble.length == 0) {
        StringBuilder stringBuilder3 = this.a;
        stringBuilder3.append(arrayOfDouble.length);
        stringBuilder3.append(", []\n");
        return this;
      } 
      StringBuilder stringBuilder = this.a;
      stringBuilder.append(arrayOfDouble.length);
      stringBuilder.append(", [\n");
      h1 = new h(this.a, this.b + 1);
      j = arrayOfDouble.length;
      for (i = bool2; i < j; i++) {
        double d = arrayOfDouble[i];
        h1.a(null);
        StringBuilder stringBuilder3 = h1.a;
        stringBuilder3.append(d);
        stringBuilder3.append('\n');
      } 
      a(null);
      stringBuilder1 = this.a;
      stringBuilder1.append(']');
      stringBuilder1.append('\n');
      return this;
    } 
    if (stringBuilder1.getClass().isArray()) {
      a((Object[])stringBuilder1, (String)h1);
      return this;
    } 
    throw new b("write object error: unsupport type.");
  }
  
  private <T> h a(T[] paramArrayOfT, String paramString) {
    a(paramString);
    if (paramArrayOfT == null) {
      this.a.append("null\n");
      return this;
    } 
    if (paramArrayOfT.length == 0) {
      StringBuilder stringBuilder = this.a;
      stringBuilder.append(paramArrayOfT.length);
      stringBuilder.append(", []\n");
      return this;
    } 
    StringBuilder stringBuilder2 = this.a;
    stringBuilder2.append(paramArrayOfT.length);
    stringBuilder2.append(", [\n");
    h h1 = new h(this.a, this.b + 1);
    int j = paramArrayOfT.length;
    for (int i = 0; i < j; i++)
      h1.a(paramArrayOfT[i], (String)null); 
    a(null);
    StringBuilder stringBuilder1 = this.a;
    stringBuilder1.append(']');
    stringBuilder1.append('\n');
    return this;
  }
  
  private void a(String paramString) {
    for (int i = 0; i < this.b; i++)
      this.a.append('\t'); 
    if (paramString != null) {
      StringBuilder stringBuilder = this.a;
      stringBuilder.append(paramString);
      stringBuilder.append(": ");
    } 
  }
  
  public final h a(byte paramByte, String paramString) {
    a(paramString);
    StringBuilder stringBuilder = this.a;
    stringBuilder.append(paramByte);
    stringBuilder.append('\n');
    return this;
  }
  
  public final h a(int paramInt, String paramString) {
    a(paramString);
    StringBuilder stringBuilder = this.a;
    stringBuilder.append(paramInt);
    stringBuilder.append('\n');
    return this;
  }
  
  public final h a(long paramLong, String paramString) {
    a(paramString);
    StringBuilder stringBuilder = this.a;
    stringBuilder.append(paramLong);
    stringBuilder.append('\n');
    return this;
  }
  
  public final h a(k paramk, String paramString) {
    a(paramString);
    StringBuilder stringBuilder2 = this.a;
    stringBuilder2.append('{');
    stringBuilder2.append('\n');
    if (paramk == null) {
      stringBuilder1 = this.a;
      stringBuilder1.append('\t');
      stringBuilder1.append("null");
    } else {
      stringBuilder1.a(this.a, this.b + 1);
    } 
    a(null);
    StringBuilder stringBuilder1 = this.a;
    stringBuilder1.append('}');
    stringBuilder1.append('\n');
    return this;
  }
  
  public final h a(String paramString1, String paramString2) {
    a(paramString2);
    if (paramString1 == null) {
      this.a.append("null\n");
      return this;
    } 
    StringBuilder stringBuilder = this.a;
    stringBuilder.append(paramString1);
    stringBuilder.append('\n');
    return this;
  }
  
  public final <K, V> h a(Map<K, V> paramMap, String paramString) {
    a(paramString);
    if (paramMap == null) {
      this.a.append("null\n");
      return this;
    } 
    if (paramMap.isEmpty()) {
      StringBuilder stringBuilder = this.a;
      stringBuilder.append(paramMap.size());
      stringBuilder.append(", {}\n");
      return this;
    } 
    StringBuilder stringBuilder2 = this.a;
    stringBuilder2.append(paramMap.size());
    stringBuilder2.append(", {\n");
    h h1 = new h(this.a, this.b + 1);
    h h2 = new h(this.a, this.b + 2);
    for (Map.Entry<K, V> entry : paramMap.entrySet()) {
      h1.a(null);
      StringBuilder stringBuilder4 = h1.a;
      stringBuilder4.append('(');
      stringBuilder4.append('\n');
      h2.a(entry.getKey(), (String)null);
      h2.a(entry.getValue(), (String)null);
      h1.a(null);
      StringBuilder stringBuilder3 = h1.a;
      stringBuilder3.append(')');
      stringBuilder3.append('\n');
    } 
    a(null);
    StringBuilder stringBuilder1 = this.a;
    stringBuilder1.append('}');
    stringBuilder1.append('\n');
    return this;
  }
  
  public final h a(short paramShort, String paramString) {
    a(paramString);
    StringBuilder stringBuilder = this.a;
    stringBuilder.append(paramShort);
    stringBuilder.append('\n');
    return this;
  }
  
  public final h a(boolean paramBoolean, String paramString) {
    byte b;
    a(paramString);
    StringBuilder stringBuilder = this.a;
    if (paramBoolean) {
      b = 84;
    } else {
      b = 70;
    } 
    stringBuilder.append(b);
    stringBuilder.append('\n');
    return this;
  }
  
  public final h a(byte[] paramArrayOfbyte, String paramString) {
    a(paramString);
    if (paramArrayOfbyte == null) {
      this.a.append("null\n");
      return this;
    } 
    if (paramArrayOfbyte.length == 0) {
      StringBuilder stringBuilder = this.a;
      stringBuilder.append(paramArrayOfbyte.length);
      stringBuilder.append(", []\n");
      return this;
    } 
    StringBuilder stringBuilder2 = this.a;
    stringBuilder2.append(paramArrayOfbyte.length);
    stringBuilder2.append(", [\n");
    h h1 = new h(this.a, this.b + 1);
    int j = paramArrayOfbyte.length;
    for (int i = 0; i < j; i++) {
      byte b = paramArrayOfbyte[i];
      h1.a(null);
      StringBuilder stringBuilder = h1.a;
      stringBuilder.append(b);
      stringBuilder.append('\n');
    } 
    a(null);
    StringBuilder stringBuilder1 = this.a;
    stringBuilder1.append(']');
    stringBuilder1.append('\n');
    return this;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\tencent\bugly\proguard\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */