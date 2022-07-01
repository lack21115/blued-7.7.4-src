package com.ss.android.socialbase.appdownloader.e.a;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;

public class d {
  private InputStream a;
  
  private boolean b;
  
  private int c;
  
  public d() {}
  
  public d(InputStream paramInputStream, boolean paramBoolean) {
    a(paramInputStream, paramBoolean);
  }
  
  public final int a(int paramInt) throws IOException {
    if (paramInt >= 0 && paramInt <= 4) {
      boolean bool = this.b;
      int k = 0;
      int i = 0;
      if (bool) {
        paramInt = (paramInt - 1) * 8;
        while (paramInt >= 0) {
          int m = this.a.read();
          if (m != -1) {
            this.c++;
            i |= m << paramInt;
            paramInt -= 8;
            continue;
          } 
          throw new EOFException();
        } 
        return i;
      } 
      int j = 0;
      i = k;
      while (i != paramInt * 8) {
        k = this.a.read();
        if (k != -1) {
          this.c++;
          j |= k << i;
          i += 8;
          continue;
        } 
        throw new EOFException();
      } 
      return j;
    } 
    throw new IllegalArgumentException();
  }
  
  public final void a() {
    InputStream inputStream = this.a;
    if (inputStream != null) {
      try {
        inputStream.close();
      } catch (IOException iOException) {}
      a((InputStream)null, false);
    } 
  }
  
  public final void a(InputStream paramInputStream, boolean paramBoolean) {
    this.a = paramInputStream;
    this.b = paramBoolean;
    this.c = 0;
  }
  
  public final void a(int[] paramArrayOfint, int paramInt1, int paramInt2) throws IOException {
    while (paramInt2 > 0) {
      paramArrayOfint[paramInt1] = b();
      paramInt2--;
      paramInt1++;
    } 
  }
  
  public final int b() throws IOException {
    return a(4);
  }
  
  public final int[] b(int paramInt) throws IOException {
    int[] arrayOfInt = new int[paramInt];
    a(arrayOfInt, 0, paramInt);
    return arrayOfInt;
  }
  
  public final void c() throws IOException {
    c(4);
  }
  
  public final void c(int paramInt) throws IOException {
    if (paramInt > 0) {
      InputStream inputStream = this.a;
      long l1 = paramInt;
      long l2 = inputStream.skip(l1);
      this.c = (int)(this.c + l2);
      if (l2 == l1)
        return; 
      throw new EOFException();
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\ss\android\socialbase\appdownloader\e\a\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */