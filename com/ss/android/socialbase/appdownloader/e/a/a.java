package com.ss.android.socialbase.appdownloader.e.a;

import java.io.IOException;
import java.io.InputStream;

class a implements i {
  private d b;
  
  private boolean c = false;
  
  private f d;
  
  private int[] e;
  
  private a f = new a();
  
  private boolean g;
  
  private int h;
  
  private int i;
  
  private int j;
  
  private int k;
  
  private int[] l;
  
  private int m;
  
  private int n;
  
  private int o;
  
  public a() {
    g();
  }
  
  private final int e(int paramInt) {
    if (this.h == 2) {
      int j = paramInt * 5;
      if (j < this.l.length)
        return j; 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Invalid attribute index (");
      stringBuilder.append(paramInt);
      stringBuilder.append(").");
      throw new IndexOutOfBoundsException(stringBuilder.toString());
    } 
    throw new IndexOutOfBoundsException("Current event is not START_TAG.");
  }
  
  private final void g() {
    this.h = -1;
    this.i = -1;
    this.j = -1;
    this.k = -1;
    this.l = null;
    this.m = -1;
    this.n = -1;
    this.o = -1;
  }
  
  private final void h() throws IOException {
    if (this.d == null) {
      b.a(this.b, 524291);
      this.b.c();
      this.d = f.a(this.b);
      this.f.e();
      this.c = true;
    } 
    int j = this.h;
    if (j != 1) {
      int k;
      g();
      while (true) {
        if (this.g) {
          this.g = false;
          this.f.f();
        } 
        int m = 3;
        if (j == 3 && this.f.d() == 1 && this.f.b() == 0) {
          this.h = 1;
          return;
        } 
        if (j == 0) {
          k = 1048834;
        } else {
          k = this.b.b();
        } 
        if (k == 524672) {
          k = this.b.b();
          if (k >= 8 && k % 4 == 0) {
            this.e = this.b.b(k / 4 - 2);
            continue;
          } 
          StringBuilder stringBuilder1 = new StringBuilder();
          stringBuilder1.append("Invalid resource ids size (");
          stringBuilder1.append(k);
          stringBuilder1.append(").");
          throw new IOException(stringBuilder1.toString());
        } 
        if (k >= 1048832 && k <= 1048836) {
          if (k == 1048834 && j == -1) {
            this.h = 0;
            return;
          } 
          this.b.c();
          int n = this.b.b();
          this.b.c();
          if (k == 1048832 || k == 1048833) {
            if (k == 1048832) {
              k = this.b.b();
              m = this.b.b();
              this.f.a(k, m);
              continue;
            } 
            this.b.c();
            this.b.c();
            this.f.c();
            continue;
          } 
          this.i = n;
          if (k == 1048834) {
            this.k = this.b.b();
            this.j = this.b.b();
            this.b.c();
            k = this.b.b();
            this.m = (k >>> 16) - 1;
            this.n = this.b.b();
            j = this.n;
            this.o = (j >>> 16) - 1;
            this.n = (0xFFFF & j) - 1;
            this.l = this.b.b((k & 0xFFFF) * 5);
            k = m;
            while (true) {
              int[] arrayOfInt = this.l;
              if (k < arrayOfInt.length) {
                arrayOfInt[k] = arrayOfInt[k] >>> 24;
                k += 5;
                continue;
              } 
              this.f.e();
              this.h = 2;
              return;
            } 
          } 
          if (k == 1048835) {
            this.k = this.b.b();
            this.j = this.b.b();
            this.h = 3;
            this.g = true;
            return;
          } 
          if (k != 1048836)
            continue; 
          this.j = this.b.b();
          this.b.c();
          this.b.c();
          this.h = 4;
          return;
        } 
        break;
      } 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Invalid chunk type (");
      stringBuilder.append(k);
      stringBuilder.append(").");
      throw new IOException(stringBuilder.toString());
    } 
  }
  
  public String a(int paramInt) {
    paramInt = e(paramInt);
    paramInt = this.l[paramInt + 1];
    return (paramInt == -1) ? "" : this.d.a(paramInt);
  }
  
  public void a() {
    if (this.c) {
      this.c = false;
      this.b.a();
      this.b = null;
      this.d = null;
      this.e = null;
      this.f.a();
      g();
    } 
  }
  
  public void a(InputStream paramInputStream) {
    a();
    if (paramInputStream != null)
      this.b = new d(paramInputStream, false); 
  }
  
  public int b() throws h, IOException {
    if (this.b != null)
      try {
        h();
        return this.h;
      } catch (IOException iOException) {
        a();
        throw iOException;
      }  
    throw new h("Parser is not opened.", this, (Throwable)null);
  }
  
  public int b(int paramInt) {
    paramInt = e(paramInt);
    return this.l[paramInt + 3];
  }
  
  public int c() {
    return this.i;
  }
  
  public int c(int paramInt) {
    paramInt = e(paramInt);
    return this.l[paramInt + 4];
  }
  
  public String d() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("XML line #");
    stringBuilder.append(c());
    return stringBuilder.toString();
  }
  
  public String d(int paramInt) {
    paramInt = e(paramInt);
    int[] arrayOfInt = this.l;
    if (arrayOfInt[paramInt + 3] == 3) {
      paramInt = arrayOfInt[paramInt + 2];
      return this.d.a(paramInt);
    } 
    paramInt = arrayOfInt[paramInt + 4];
    return "";
  }
  
  public int e() {
    return (this.h != 2) ? -1 : (this.l.length / 5);
  }
  
  public int f() {
    return -1;
  }
  
  static final class a {
    private int[] a = new int[32];
    
    private int b;
    
    private int c;
    
    private void a(int param1Int) {
      int[] arrayOfInt = this.a;
      int j = arrayOfInt.length;
      int i = this.b;
      j -= i;
      if (j <= param1Int) {
        int[] arrayOfInt1 = new int[(arrayOfInt.length + j) * 2];
        System.arraycopy(arrayOfInt, 0, arrayOfInt1, 0, i);
        this.a = arrayOfInt1;
      } 
    }
    
    public final void a() {
      this.b = 0;
      this.c = 0;
    }
    
    public final void a(int param1Int1, int param1Int2) {
      if (this.c == 0)
        e(); 
      a(2);
      int i = this.b;
      int j = i - 1;
      int[] arrayOfInt = this.a;
      int k = arrayOfInt[j];
      int m = k + 1;
      arrayOfInt[j - 1 - k * 2] = m;
      arrayOfInt[j] = param1Int1;
      arrayOfInt[j + 1] = param1Int2;
      arrayOfInt[j + 2] = m;
      this.b = i + 2;
    }
    
    public final int b() {
      int i = this.b;
      return (i == 0) ? 0 : this.a[i - 1];
    }
    
    public final boolean c() {
      int i = this.b;
      if (i == 0)
        return false; 
      int j = i - 1;
      int[] arrayOfInt = this.a;
      int k = arrayOfInt[j];
      if (k == 0)
        return false; 
      k--;
      j -= 2;
      arrayOfInt[j] = k;
      arrayOfInt[j - k * 2 + 1] = k;
      this.b = i - 2;
      return true;
    }
    
    public final int d() {
      return this.c;
    }
    
    public final void e() {
      a(2);
      int i = this.b;
      int[] arrayOfInt = this.a;
      arrayOfInt[i] = 0;
      arrayOfInt[i + 1] = 0;
      this.b = i + 2;
      this.c++;
    }
    
    public final void f() {
      int i = this.b;
      if (i != 0) {
        int j = i - 1;
        int k = this.a[j] * 2;
        if (j - 1 - k != 0) {
          this.b = i - k + 2;
          this.c--;
        } 
      } 
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\ss\android\socialbase\appdownloader\e\a\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */