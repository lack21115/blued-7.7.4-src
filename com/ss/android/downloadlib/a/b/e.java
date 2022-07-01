package com.ss.android.downloadlib.a.b;

import android.content.SharedPreferences;
import com.ss.android.downloadlib.a.j;
import com.ss.android.downloadlib.d;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

public class e {
  private e() {}
  
  public static e a() {
    return a.a();
  }
  
  private SharedPreferences c() {
    return j.a().getSharedPreferences("sp_ad_download_event", 0);
  }
  
  public void a(com.ss.android.downloadad.a.b.a parama) {
    ArrayList<com.ss.android.downloadad.a.b.a> arrayList = new ArrayList();
    arrayList.add(parama);
    a(arrayList);
  }
  
  public void a(List<com.ss.android.downloadad.a.b.a> paramList) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: ifnull -> 41
    //   6: aload_1
    //   7: invokeinterface isEmpty : ()Z
    //   12: ifeq -> 18
    //   15: goto -> 41
    //   18: invokestatic a : ()Lcom/ss/android/downloadlib/d;
    //   21: new com/ss/android/downloadlib/a/b/e$1
    //   24: dup
    //   25: aload_0
    //   26: aload_1
    //   27: invokespecial <init> : (Lcom/ss/android/downloadlib/a/b/e;Ljava/util/List;)V
    //   30: invokevirtual b : (Ljava/lang/Runnable;)V
    //   33: aload_0
    //   34: monitorexit
    //   35: return
    //   36: astore_1
    //   37: aload_0
    //   38: monitorexit
    //   39: aload_1
    //   40: athrow
    //   41: aload_0
    //   42: monitorexit
    //   43: return
    // Exception table:
    //   from	to	target	type
    //   6	15	36	finally
    //   18	33	36	finally
  }
  
  ConcurrentHashMap<Long, com.ss.android.downloadad.a.b.a> b() {
    ConcurrentHashMap<Object, Object> concurrentHashMap = new ConcurrentHashMap<Object, Object>();
    try {
      for (Map.Entry entry : c().getAll().entrySet()) {
        try {
          long l = Long.valueOf((String)entry.getKey()).longValue();
          com.ss.android.downloadad.a.b.a a = com.ss.android.downloadad.a.b.a.b(new JSONObject((String)entry.getValue()));
          if (l > 0L && a != null)
            concurrentHashMap.put(Long.valueOf(l), a); 
        } catch (Exception exception) {
          exception.printStackTrace();
        } 
      } 
    } catch (Exception exception) {
      exception.printStackTrace();
    } 
    return (ConcurrentHashMap)concurrentHashMap;
  }
  
  public void b(List<String> paramList) {
    if (paramList != null) {
      if (paramList.isEmpty())
        return; 
      d.a().b(new Runnable(this, paramList) {
            public void run() {
              SharedPreferences.Editor editor = e.a(this.b).edit();
              Iterator<String> iterator = this.a.iterator();
              while (iterator.hasNext())
                editor.remove(iterator.next()); 
              editor.apply();
            }
          });
    } 
  }
  
  static class a {
    private static e a = new e();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\ss\android\downloadlib\a\b\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */