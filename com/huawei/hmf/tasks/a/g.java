package com.huawei.hmf.tasks.a;

import android.app.Activity;
import android.app.Fragment;
import com.huawei.hmf.tasks.ExecuteResult;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.WeakHashMap;

public final class g extends Fragment {
  private static final WeakHashMap<Activity, WeakReference<g>> b = new WeakHashMap<Activity, WeakReference<g>>();
  
  private final List<WeakReference<ExecuteResult<?>>> a = new ArrayList<WeakReference<ExecuteResult<?>>>();
  
  public final void onStop() {
    super.onStop();
    synchronized (this.a) {
      Iterator<WeakReference<ExecuteResult<?>>> iterator = this.a.iterator();
      while (iterator.hasNext()) {
        ExecuteResult executeResult = ((WeakReference<ExecuteResult>)iterator.next()).get();
        if (executeResult != null)
          executeResult.a(); 
      } 
      this.a.clear();
      return;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\hmf\tasks\a\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */