package com.tencent.tbs.sdk.extension.partner.incrupdate.a;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class f extends c {
  public final int a = 1233211;
  
  private int b;
  
  private int c;
  
  private int d;
  
  private int e;
  
  private List<b> f = null;
  
  public void a(int paramInt) {
    this.b = paramInt;
  }
  
  public void a(OutputStream paramOutputStream) {
    a(paramOutputStream, 1233211);
    a(paramOutputStream, this.b);
    a(paramOutputStream, this.c);
    if (this.c == 1) {
      this.d = this.f.size();
      a(paramOutputStream, this.d);
      Iterator<b> iterator = this.f.iterator();
      while (iterator.hasNext())
        ((b)iterator.next()).a(paramOutputStream); 
    } 
  }
  
  public void a(List<b> paramList) {
    boolean bool;
    this.f = paramList;
    if (paramList == null || paramList.size() == 0) {
      bool = false;
    } else {
      bool = true;
    } 
    this.c = bool;
  }
  
  public f d(InputStream paramInputStream) {
    this.e = a(paramInputStream);
    this.b = a(paramInputStream);
    this.c = a(paramInputStream);
    if (this.c == 1) {
      this.d = a(paramInputStream);
      this.f = new ArrayList<b>();
      for (int i = 0; i < this.d; i++) {
        String str1 = c(paramInputStream);
        String str2 = c(paramInputStream);
        b b = new b();
        b.a(str1, str2);
        this.f.add(b);
      } 
    } 
    return this;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued209820-dex2jar.jar!\com\tencent\tbs\sdk\extension\partner\incrupdate\a\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */