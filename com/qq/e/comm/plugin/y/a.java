package com.qq.e.comm.plugin.y;

import android.content.Context;
import com.qq.e.comm.plugin.util.ak;
import com.qq.e.comm.util.GDTLogger;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import yaq.gdtadv;

abstract class a<T extends n> {
  Context a;
  
  List<T> b = new LinkedList<T>();
  
  private long c = 0L;
  
  public a(Context paramContext) {
    this.a = paramContext;
  }
  
  private void e(List<T> paramList) {
    gdtadv.getVresult(2, 0, new Object[] { this, paramList });
  }
  
  void a() {
    ArrayList<T> arrayList = new ArrayList<T>(this.b);
    this.b.clear();
    d(arrayList);
  }
  
  void a(T paramT) {
    if (paramT == null)
      return; 
    if (this.b.size() >= 1000) {
      int i = this.b.size() - 1000 + 1;
      Iterator<T> iterator = this.b.iterator();
      while (i > 0 && iterator.hasNext()) {
        iterator.next();
        iterator.remove();
        i--;
      } 
    } 
    this.b.add(paramT);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Add stat data: ");
    stringBuilder.append(paramT);
    stringBuilder.append(", total: ");
    stringBuilder.append(this.b.size());
    GDTLogger.d(stringBuilder.toString());
  }
  
  void a(List<T> paramList) {
    GDTLogger.d("Send stat success");
    this.c = System.currentTimeMillis() / 1000L;
    HashSet<Integer> hashSet = new HashSet();
    for (n n : paramList) {
      if (n != null) {
        if (n.a() >= 0)
          hashSet.add(Integer.valueOf(n.a())); 
        this.b.remove(n);
      } 
    } 
    a(hashSet);
  }
  
  abstract void a(Set<Integer> paramSet);
  
  void b() {
    ak.a("Start commit stat data", new Object[0]);
    ArrayList<T> arrayList = new ArrayList<T>(this.b);
    List<T> list = f();
    if (list != null && list.size() > 0)
      arrayList.addAll(list); 
    if (arrayList.size() > 0)
      e(arrayList); 
  }
  
  void b(List<T> paramList) {
    GDTLogger.d("Send stat failed");
  }
  
  long c() {
    return this.c;
  }
  
  abstract void c(List<T> paramList);
  
  void d() {
    if (e())
      b(); 
  }
  
  abstract void d(List<T> paramList);
  
  abstract boolean e();
  
  abstract List<T> f();
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\plugin\y\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */