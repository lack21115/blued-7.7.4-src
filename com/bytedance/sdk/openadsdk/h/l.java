package com.bytedance.sdk.openadsdk.h;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

public class l {
  private static final Set<String> a = new HashSet<String>();
  
  private static final Set<String> b = new HashSet<String>();
  
  private final ArrayList<a> c;
  
  private final int d;
  
  private int e = -1;
  
  private int f;
  
  private final int g;
  
  l(String paramString) {
    this.c = new ArrayList<a>(1);
    this.c.add(new a(this, paramString));
    this.d = 1;
    this.g = 1;
  }
  
  l(List<String> paramList) {
    if (!paramList.isEmpty()) {
      int i;
      this.d = paramList.size();
      this.c = new ArrayList<a>(this.d);
      Iterator<String> iterator = paramList.iterator();
      List<String> list = null;
      paramList = null;
      while (iterator.hasNext()) {
        List<String> list1;
        String str = iterator.next();
        a a = new a(this, str);
        if (a.contains(str)) {
          list1 = paramList;
          if (paramList == null)
            list1 = new ArrayList<String>(); 
          list1.add(a);
          paramList = list1;
          continue;
        } 
        if (b.contains(list1)) {
          list1 = list;
          if (list == null)
            list1 = new ArrayList<String>(); 
          list1.add(a);
          list = list1;
          continue;
        } 
        this.c.add(a);
      } 
      if (list != null)
        this.c.addAll(list); 
      if (paramList != null)
        this.c.addAll(paramList); 
      Integer integer = e.i;
      if (integer == null || integer.intValue() <= 0) {
        if (this.d >= 2) {
          i = 1;
        } else {
          i = 2;
        } 
      } else {
        i = integer.intValue();
      } 
      this.g = i;
      return;
    } 
    throw new IllegalArgumentException("urls can't be empty");
  }
  
  boolean a() {
    return (this.f < this.g);
  }
  
  a b() {
    if (a()) {
      int i = this.e + 1;
      if (i >= this.d - 1) {
        this.e = -1;
        this.f++;
      } else {
        this.e = i;
      } 
      a a = this.c.get(i);
      a.b = this.f * this.d + this.e;
      return a;
    } 
    throw new NoSuchElementException();
  }
  
  public class a {
    final String a;
    
    int b;
    
    a(l this$0, String param1String) {
      this.a = param1String;
    }
    
    void a() {
      l.c().add(this.a);
    }
    
    void b() {
      l.d().add(this.a);
    }
    
    public String toString() {
      return this.a;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\openadsdk\h\l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */