package com.tencent.tbs.sdk.extension.partner.precheck;

import android.util.Log;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.UnknownFormatConversionException;

public class b implements Closeable {
  static final char[] a = new char[] { '', 'E', 'L', 'F', Character.MIN_VALUE };
  
  final char[] b;
  
  boolean c;
  
  j[] d;
  
  l[] e;
  
  byte[] f;
  
  private final a g;
  
  private final a h;
  
  private final k[] i;
  
  private byte[] j;
  
  static {
    throw new VerifyError("bad dex opcode");
  }
  
  public b(File paramFile) {
    a a1;
    this.b = new char[16];
    a a2 = new a(paramFile);
    this.g = a2;
    a2.a(this.b);
    if (a()) {
      b b1;
      a2.a(e());
      boolean bool = d();
      if (bool) {
        f f = new f();
        f.a = a2.a();
        f.b = a2.a();
        f.c = a2.b();
        f.k = a2.c();
        f.l = a2.c();
        f.m = a2.c();
      } else {
        b1 = new b();
        b1.a = a2.a();
        b1.b = a2.a();
        b1.c = a2.b();
        b1.k = a2.b();
        b1.l = a2.b();
        b1.m = a2.b();
      } 
      this.h = b1;
      a1 = this.h;
      a1.d = a2.b();
      a1.e = a2.a();
      a1.f = a2.a();
      a1.g = a2.a();
      a1.h = a2.a();
      a1.i = a2.a();
      a1.j = a2.a();
      this.i = new k[a1.i];
      int i;
      for (i = 0; i < a1.i; i++) {
        a2.a(a1.a() + (a1.h * i));
        if (bool) {
          h h = new h();
          h.g = a2.b();
          h.h = a2.b();
          h.a = a2.c();
          h.b = a2.c();
          h.c = a2.c();
          h.d = a2.c();
          h.i = a2.b();
          h.j = a2.b();
          h.e = a2.c();
          h.f = a2.c();
          this.i[i] = h;
        } else {
          d d = new d();
          d.g = a2.b();
          d.h = a2.b();
          d.a = a2.b();
          d.b = a2.b();
          d.c = a2.b();
          d.d = a2.b();
          d.i = a2.b();
          d.j = a2.b();
          d.e = a2.b();
          d.f = a2.b();
          this.i[i] = d;
        } 
      } 
      if (a1.j > -1) {
        i = a1.j;
        k[] arrayOfK = this.i;
        if (i < arrayOfK.length) {
          k k1 = arrayOfK[a1.j];
          if (k1.h == 3) {
            this.j = new byte[k1.a()];
            a2.a(k1.b());
            a2.a(this.j);
            if (this.c)
              f(); 
            return;
          } 
          StringBuilder stringBuilder2 = new StringBuilder();
          stringBuilder2.append("Wrong string section e_shstrndx=");
          stringBuilder2.append(a1.j);
          throw new UnknownFormatConversionException(stringBuilder2.toString());
        } 
      } 
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append("Invalid e_shstrndx=");
      stringBuilder1.append(a1.j);
      throw new UnknownFormatConversionException(stringBuilder1.toString());
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Invalid elf magic: ");
    stringBuilder.append(a1);
    throw new UnknownFormatConversionException(stringBuilder.toString());
  }
  
  public static boolean a(File paramFile) {
    boolean bool = false;
    File file2 = null;
    Exception exception = null;
    try {
      RandomAccessFile randomAccessFile = new RandomAccessFile(paramFile, "r");
      try {
        int i = randomAccessFile.readInt();
        long l1 = i;
        return bool;
      } catch (Throwable null) {
      
      } finally {
        throwable = null;
        exception = exception1;
      } 
    } catch (Throwable throwable) {
      paramFile = file2;
    } finally {}
    File file1 = paramFile;
    throwable.printStackTrace();
    if (paramFile != null)
      try {
        paramFile.close();
        return false;
      } catch (Exception exception1) {
        return false;
      }  
    return false;
  }
  
  public static boolean b(File paramFile) {
    if (g() && a(paramFile))
      try {
        b b1 = new b(paramFile);
        try {
          b1.close();
        } catch (Throwable throwable) {
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append("extension - checkElfFile: ");
          stringBuilder.append(throwable);
          Log.e("ELF", stringBuilder.toString());
        } 
      } catch (IOException iOException) {
        iOException.printStackTrace();
        return false;
      } catch (UnknownFormatConversionException unknownFormatConversionException) {
        unknownFormatConversionException.printStackTrace();
      } catch (Throwable throwable) {
        throwable.printStackTrace();
      } finally {} 
    return true;
  }
  
  private void f() {
    a a1 = this.h;
    a a2 = this.g;
    boolean bool = d();
    k k1 = a(".dynsym");
    byte b1 = 0;
    if (k1 != null) {
      a2.a(k1.b());
      int n = k1.a();
      if (bool) {
        m = 24;
      } else {
        m = 16;
      } 
      n /= m;
      this.e = new l[n];
      char[] arrayOfChar = new char[1];
      for (int m = 0; m < n; m++) {
        if (bool) {
          i i1 = new i();
          i1.c = a2.b();
          a2.a(arrayOfChar);
          i1.d = arrayOfChar[0];
          a2.a(arrayOfChar);
          i1.e = arrayOfChar[0];
          i1.a = a2.c();
          i1.b = a2.c();
          i1.f = a2.a();
          this.e[m] = i1;
        } else {
          e e = new e();
          e.c = a2.b();
          e.a = a2.b();
          e.b = a2.b();
          a2.a(arrayOfChar);
          e.d = arrayOfChar[0];
          a2.a(arrayOfChar);
          e.e = arrayOfChar[0];
          e.f = a2.a();
          this.e[m] = e;
        } 
      } 
      k1 = this.i[k1.i];
      a2.a(k1.b());
      this.f = new byte[k1.a()];
      a2.a(this.f);
    } 
    this.d = new j[a1.g];
    for (int i = b1; i < a1.g; i++) {
      a2.a(a1.b() + (a1.f * i));
      if (bool) {
        g g = new g();
        g.g = a2.b();
        g.h = a2.b();
        g.a = a2.c();
        g.b = a2.c();
        g.c = a2.c();
        g.d = a2.c();
        g.e = a2.c();
        g.f = a2.c();
        this.d[i] = g;
      } else {
        c c = new c();
        c.g = a2.b();
        c.h = a2.b();
        c.a = a2.b();
        c.b = a2.b();
        c.c = a2.b();
        c.d = a2.b();
        c.e = a2.b();
        c.f = a2.b();
        this.d[i] = c;
      } 
    } 
  }
  
  private static boolean g() {
    String str = System.getProperty("java.vm.version");
    return (str != null && str.startsWith("2"));
  }
  
  public final k a(String paramString) {
    for (k k1 : this.i) {
      if (paramString.equals(a(k1.g)))
        return k1; 
    } 
    return null;
  }
  
  public final String a(int paramInt) {
    if (paramInt == 0)
      return "SHN_UNDEF"; 
    int i = paramInt;
    while (true) {
      byte[] arrayOfByte = this.j;
      if (arrayOfByte[i] != 0) {
        i++;
        continue;
      } 
      return new String(arrayOfByte, paramInt, i - paramInt);
    } 
  }
  
  final boolean a() {
    char[] arrayOfChar = this.b;
    boolean bool = false;
    if (arrayOfChar[0] == a[0])
      bool = true; 
    return bool;
  }
  
  final char b() {
    return this.b[4];
  }
  
  final char c() {
    return this.b[5];
  }
  
  public void close() {
    this.g.close();
  }
  
  public final boolean d() {
    return (b() == '\002');
  }
  
  public final boolean e() {
    return (c() == '\001');
  }
  
  public static abstract class a {
    short a;
    
    short b;
    
    int c;
    
    int d;
    
    short e;
    
    short f;
    
    short g;
    
    short h;
    
    short i;
    
    short j;
    
    abstract long a();
    
    abstract long b();
  }
  
  static class b extends a {
    int k;
    
    int l;
    
    int m;
    
    long a() {
      return this.m;
    }
    
    long b() {
      return this.l;
    }
  }
  
  static class c extends j {
    int a;
    
    int b;
    
    int c;
    
    int d;
    
    int e;
    
    int f;
  }
  
  static class d extends k {
    int a;
    
    int b;
    
    int c;
    
    int d;
    
    int e;
    
    int f;
    
    public int a() {
      return this.d;
    }
    
    public long b() {
      return this.c;
    }
  }
  
  static class e extends l {
    int a;
    
    int b;
  }
  
  static class f extends a {
    long k;
    
    long l;
    
    long m;
    
    long a() {
      return this.m;
    }
    
    long b() {
      return this.l;
    }
  }
  
  static class g extends j {
    long a;
    
    long b;
    
    long c;
    
    long d;
    
    long e;
    
    long f;
  }
  
  static class h extends k {
    long a;
    
    long b;
    
    long c;
    
    long d;
    
    long e;
    
    long f;
    
    public int a() {
      return (int)this.d;
    }
    
    public long b() {
      return this.c;
    }
  }
  
  static class i extends l {
    long a;
    
    long b;
  }
  
  static abstract class j {
    int g;
    
    int h;
  }
  
  public static abstract class k {
    int g;
    
    int h;
    
    int i;
    
    int j;
    
    public abstract int a();
    
    public abstract long b();
  }
  
  static abstract class l {
    int c;
    
    char d;
    
    char e;
    
    short f;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued209820-dex2jar.jar!\com\tencent\tbs\sdk\extension\partner\precheck\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */