package com.qq.e.comm.plugin.c;

import com.qq.e.comm.plugin.c.a.a;
import com.qq.e.comm.plugin.util.ak;
import com.qq.e.comm.plugin.util.y;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

abstract class a implements l {
  protected final List<Class<? extends k>> a = new ArrayList<Class<? extends k>>();
  
  private k a(Class<? extends k> paramClass) {
    try {
      return paramClass.newInstance();
    } catch (Exception exception) {
      return null;
    } 
  }
  
  public void a(f paramf, a parama) {
    if (this.a.size() <= 0)
      return; 
    g.a(false, 0, paramf);
    Iterator<Class<? extends k>> iterator = this.a.iterator();
    while (iterator.hasNext()) {
      Class<? extends k> clazz = iterator.next();
      k k = a(clazz);
      if (k == null) {
        g.a(true, 1, paramf);
        return;
      } 
      boolean bool = k.a(paramf);
      String str = getClass().getSimpleName();
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(clazz.getSimpleName());
      stringBuilder.append(", canAction = ");
      stringBuilder.append(bool);
      ak.a(str, stringBuilder.toString());
      if (bool) {
        bool = k.a(paramf, parama);
        String str1 = getClass().getSimpleName();
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append(clazz.getSimpleName());
        stringBuilder1.append(", actionFinish = ");
        stringBuilder1.append(bool);
        ak.a(str1, stringBuilder1.toString());
        if (bool) {
          k k1 = a((Class)t.class);
          if (k1 != null && k1.a(paramf)) {
            k1.a(paramf, parama);
            return;
          } 
          return;
        } 
      } 
    } 
    if (parama != null)
      y.a(new Runnable(this, parama) {
            public void run() {
              this.a.a();
            }
          }); 
    g.a(true, 2, paramf);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\plugin\c\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */