package com.amap.api.col.s;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Set;

class ae {
  private boolean a = true;
  
  private long b = 86400L;
  
  private int c = 10;
  
  private long d = 0L;
  
  private final LinkedHashMap<ad.b, Object> e = new LinkedHashMap<ad.b, Object>();
  
  private final Object f = new Object();
  
  private final LinkedHashMap<ad.b, Object> g = new LinkedHashMap<ad.b, Object>();
  
  private final Object h = new Object();
  
  private ArrayList<String> i = new ArrayList<String>();
  
  public ae(String... paramVarArgs) {
    a(paramVarArgs);
  }
  
  private void a() {
    long l = System.currentTimeMillis();
    if ((l - this.d) / 1000L > this.b) {
      this.e.clear();
      this.d = l;
    } 
  }
  
  private void a(String... paramVarArgs) {
    this.d = System.currentTimeMillis();
    this.e.clear();
    this.i.clear();
    int j = paramVarArgs.length;
    for (int i = 0; i < j; i++) {
      String str = paramVarArgs[i];
      if (str != null)
        this.i.add(str); 
    } 
  }
  
  public final ad.c a(ad.b paramb) {
    if (this.a) {
      if (paramb == null)
        return null; 
      if (!b(paramb))
        return null; 
      a();
      synchronized (this.f) {
        if (a(this.e, paramb)) {
          null = new ad.c(b(this.e, paramb), true);
          return null;
        } 
        synchronized (this.h) {
          if (a(this.g, (ad.b)null)) {
            while (!a(this.e, (ad.b)null)) {
              boolean bool = a(this.g, (ad.b)null);
              if (bool)
                try {
                  this.h.wait(1000L);
                } catch (InterruptedException interruptedException) {
                  interruptedException.printStackTrace();
                }  
            } 
          } else {
            this.g.put(null, null);
          } 
          return new ad.c(b(this.e, (ad.b)null), false);
        } 
      } 
    } 
    return null;
  }
  
  public void a(ad.a parama) {
    if (parama != null) {
      this.a = parama.a();
      this.b = parama.b();
      this.c = parama.c();
    } 
  }
  
  public final void a(ad.b paramb, Object paramObject) {
    if (this.a) {
      if (paramb == null)
        return; 
      if (!b(paramb))
        return; 
      synchronized (this.f) {
        int i = this.e.size();
        if (i > 0 && i >= this.c) {
          ad.b b1;
          Set<ad.b> set = this.e.keySet();
          Set set1 = null;
          Iterator<ad.b> iterator = set.iterator();
          while (true) {
            set = set1;
            if (iterator.hasNext()) {
              b1 = iterator.next();
              if (b1 != null)
                break; 
              continue;
            } 
            break;
          } 
          c(this.e, b1);
        } 
        a();
        this.e.put(paramb, paramObject);
        synchronized (this.h) {
          c(this.g, paramb);
          this.h.notify();
          return;
        } 
      } 
    } 
  }
  
  protected boolean a(LinkedHashMap<ad.b, Object> paramLinkedHashMap, ad.b paramb) {
    return (paramLinkedHashMap != null && paramb != null) ? paramLinkedHashMap.containsKey(paramb) : false;
  }
  
  protected Object b(LinkedHashMap<ad.b, Object> paramLinkedHashMap, ad.b paramb) {
    return (paramLinkedHashMap != null && paramb != null) ? paramLinkedHashMap.get(paramb) : null;
  }
  
  public final boolean b(ad.b paramb) {
    if (paramb != null) {
      if (paramb.a == null)
        return false; 
      for (String str : this.i) {
        if (str != null && paramb.a.contains(str))
          return true; 
      } 
    } 
    return false;
  }
  
  protected Object c(LinkedHashMap<ad.b, Object> paramLinkedHashMap, ad.b paramb) {
    return (paramLinkedHashMap != null && paramb != null) ? paramLinkedHashMap.remove(paramb) : null;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\col\s\ae.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */