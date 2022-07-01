package com.tencent.tbs.sdk.extension.partner.incrupdate.a;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class d extends c {
  public int a = -1;
  
  public String b = "";
  
  public long c = -1L;
  
  public long d = -1L;
  
  public int e = 8;
  
  public int f = -1;
  
  public int g;
  
  public List<b> h = null;
  
  private boolean a() {
    return (this.a != -1 && !this.b.equals("")) ? ((this.f == -1) ? false : (!(this.a == 1 && (this.c == -1L || this.d == -1L)))) : false;
  }
  
  public void a(int paramInt1, String paramString, long paramLong1, long paramLong2, int paramInt2) {
    this.a = paramInt1;
    this.c = paramLong1;
    this.b = paramString;
    this.d = paramLong2;
    this.e = paramInt2;
  }
  
  public void a(OutputStream paramOutputStream) {
    if (!a()) {
      System.out.println("check wrong");
      return;
    } 
    PrintStream printStream = System.out;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(this.a);
    stringBuilder.append(":");
    stringBuilder.append(this.b);
    stringBuilder.append(":");
    stringBuilder.append(this.c);
    stringBuilder.append(":");
    stringBuilder.append(this.d);
    stringBuilder.append(":");
    stringBuilder.append(this.e);
    stringBuilder.append(":");
    stringBuilder.append(this.f);
    printStream.println(stringBuilder.toString());
    a(paramOutputStream, this.a);
    a(paramOutputStream, this.b);
    a(paramOutputStream, this.c);
    a(paramOutputStream, this.d);
    a(paramOutputStream, this.e);
    a(paramOutputStream, this.f);
    if (this.f == 1) {
      this.g = this.h.size();
      a(paramOutputStream, this.g);
      Iterator<b> iterator = this.h.iterator();
      while (iterator.hasNext())
        ((b)iterator.next()).a(paramOutputStream); 
    } 
  }
  
  public void a(OutputStream paramOutputStream, InputStream paramInputStream, byte[] paramArrayOfbyte) {
    while (true) {
      int i = paramInputStream.read(paramArrayOfbyte);
      if (i > 0) {
        paramOutputStream.write(paramArrayOfbyte, 0, i);
        continue;
      } 
      paramInputStream.close();
      return;
    } 
  }
  
  public void a(List<b> paramList) {
    boolean bool;
    this.h = paramList;
    if (paramList == null || paramList.size() == 0) {
      bool = false;
    } else {
      bool = true;
    } 
    this.f = bool;
  }
  
  public d d(InputStream paramInputStream) {
    this.a = a(paramInputStream);
    this.b = c(paramInputStream);
    this.c = b(paramInputStream);
    this.d = b(paramInputStream);
    this.e = a(paramInputStream);
    System.out.println(this.b);
    this.b.replaceAll("\\/", "//");
    this.f = a(paramInputStream);
    if (this.f == 1) {
      this.g = a(paramInputStream);
      this.h = new ArrayList<b>();
      for (int i = 0; i < this.g; i++) {
        String str1 = c(paramInputStream);
        String str2 = c(paramInputStream);
        b b = new b();
        b.a(str1, str2);
        this.h.add(b);
      } 
    } 
    return this;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued209820-dex2jar.jar!\com\tencent\tbs\sdk\extension\partner\incrupdate\a\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */