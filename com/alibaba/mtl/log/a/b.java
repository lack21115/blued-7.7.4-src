package com.alibaba.mtl.log.a;

import com.alibaba.mtl.log.e.e;
import com.alibaba.mtl.log.e.i;
import com.alibaba.mtl.log.e.l;
import com.alibaba.mtl.log.e.r;
import com.alibaba.mtl.log.e.t;
import java.util.HashMap;

public class b {
  private static String P;
  
  private static b a = new b();
  
  static {
    P = "http://adashx.m.taobao.com/rest/gc2";
  }
  
  public static b a() {
    return a;
  }
  
  public void r() {
    r.a().b(new a(this));
  }
  
  class a implements Runnable {
    a(b this$0) {}
    
    public void run() {
      if (!l.isConnected())
        return; 
      int i = 0;
      while (true) {
        if (i < 8) {
          HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
          String str1 = a.b("b01n15");
          String str2 = a.b("b01na");
          hashMap.put("_b01n15", str1);
          hashMap.put("_b01na", str2);
          try {
            String str = t.b(b.g(), hashMap, null);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("config:");
            stringBuilder.append(str);
            i.a("ConfigMgr", new Object[] { stringBuilder.toString() });
            e.a a1 = e.a(1, str, null, false);
            if (a1.e != null) {
              a.h(new String(a1.e, 0, a1.e.length));
              a.q();
              return;
            } 
          } catch (Exception exception) {
            exception.printStackTrace();
          } 
          try {
            Thread.sleep(10000L);
          } catch (Exception exception) {}
          i++;
          continue;
        } 
        return;
      } 
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\alibaba\mtl\log\a\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */