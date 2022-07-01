package com.bytedance.embedapplog.b;

import com.bytedance.embedapplog.a.e;
import com.bytedance.embedapplog.d.a;
import com.bytedance.embedapplog.d.c;
import com.bytedance.embedapplog.d.e;
import com.bytedance.embedapplog.d.i;
import com.bytedance.embedapplog.util.h;
import java.util.LinkedList;

public class b {
  private static final LinkedList<a> a = new LinkedList<a>();
  
  private static final LinkedList<a> b = new LinkedList<a>();
  
  public static void a() {
    LinkedList<a> linkedList1;
    i i;
    LinkedList<a> linkedList2 = new LinkedList();
    null = new LinkedList();
    synchronized (a) {
      linkedList2.addAll(a);
      null.addAll(b);
      a.clear();
      b.clear();
      while (!linkedList2.isEmpty())
        e.a(linkedList2.poll()); 
      while (!null.isEmpty()) {
        a a = null.poll();
        linkedList1 = null;
        if (a instanceof i) {
          i = (i)a;
        } else {
          StringBuilder stringBuilder;
          if (a instanceof c) {
            c c = (c)a;
            stringBuilder = new StringBuilder();
            stringBuilder.append("");
            stringBuilder.append(c.i());
            stringBuilder.append(c.j());
            i = new i(stringBuilder.toString(), "16", 1);
          } else if (stringBuilder instanceof e) {
            i = new i(((e)stringBuilder).j(), "16", 1);
          } 
        } 
        e.a((a)i);
      } 
      return;
    } 
  }
  
  public static void a(a parama) {
    synchronized (a) {
      if (a.size() > 200) {
        a a1 = a.poll();
        h.b("drop event in cache", null);
        b.add(a1);
      } 
      a.add(parama);
      return;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\embedapplog\b\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */