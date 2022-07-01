package com.ss.android.socialbase.appdownloader.e.a;

import java.io.IOException;

public class f {
  private int[] a;
  
  private int[] b;
  
  private static final int a(int[] paramArrayOfint, int paramInt) {
    int i = paramArrayOfint[paramInt / 4];
    return (paramInt % 4 / 2 == 0) ? (i & 0xFFFF) : (i >>> 16);
  }
  
  public static f a(d paramd) throws IOException {
    b.a(paramd, 1835009);
    int j = paramd.b();
    int i = paramd.b();
    int n = paramd.b();
    paramd.b();
    int m = paramd.b();
    int k = paramd.b();
    f f1 = new f();
    f1.a = paramd.b(i);
    if (n != 0)
      paramd.b(n); 
    if (k == 0) {
      i = j;
    } else {
      i = k;
    } 
    i -= m;
    if (i % 4 == 0) {
      f1.b = paramd.b(i / 4);
      if (k != 0) {
        i = j - k;
        if (i % 4 == 0) {
          paramd.b(i / 4);
          return f1;
        } 
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append("Style data size is not multiple of 4 (");
        stringBuilder1.append(i);
        stringBuilder1.append(").");
        throw new IOException(stringBuilder1.toString());
      } 
      return f1;
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("String data size is not multiple of 4 (");
    stringBuilder.append(i);
    stringBuilder.append(").");
    throw new IOException(stringBuilder.toString());
  }
  
  public String a(int paramInt) {
    if (paramInt >= 0) {
      int[] arrayOfInt = this.a;
      if (arrayOfInt != null && paramInt < arrayOfInt.length) {
        int i = arrayOfInt[paramInt];
        paramInt = a(this.b, i);
        StringBuilder stringBuilder = new StringBuilder(paramInt);
        while (paramInt != 0) {
          i += 2;
          stringBuilder.append((char)a(this.b, i));
          paramInt--;
        } 
        return stringBuilder.toString();
      } 
    } 
    return null;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\ss\android\socialbase\appdownloader\e\a\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */