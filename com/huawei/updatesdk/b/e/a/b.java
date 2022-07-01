package com.huawei.updatesdk.b.e.a;

import android.os.AsyncTask;
import com.huawei.updatesdk.a.a.b.a.a.a;
import com.huawei.updatesdk.a.b.d.c.a;
import com.huawei.updatesdk.a.b.d.c.c;
import com.huawei.updatesdk.b.b.c;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class b {
  private static List<AsyncTask> a = new CopyOnWriteArrayList<AsyncTask>();
  
  public static com.huawei.updatesdk.a.b.d.b a(c paramc, a parama) {
    com.huawei.updatesdk.a.b.d.b b1 = new com.huawei.updatesdk.a.b.d.b((c)paramc, parama);
    a(b1, paramc);
    return b1;
  }
  
  public static List<AsyncTask> a() {
    return a;
  }
  
  public static void a(AsyncTask paramAsyncTask) {
    if (paramAsyncTask == null)
      return; 
    for (AsyncTask asyncTask : a) {
      if (asyncTask != null && (asyncTask.getStatus() == AsyncTask.Status.FINISHED || asyncTask.isCancelled()))
        a.remove(paramAsyncTask); 
    } 
    a.add(paramAsyncTask);
  }
  
  private static void a(com.huawei.updatesdk.a.b.d.b paramb, c paramc) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("executeTask, ActiveCount:");
    stringBuilder.append(c.a.getActiveCount());
    stringBuilder.append(", TaskCount:");
    stringBuilder.append(c.a.getTaskCount());
    a.a("StoreAgent", stringBuilder.toString());
    paramb.a(c.a);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawe\\updatesdk\b\e\a\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */