package com.huawei.hms.api;

import android.app.Activity;
import java.util.ArrayList;
import java.util.List;

class a {
  static final a a = new a();
  
  List<Activity> b = new ArrayList<Activity>(1);
  
  void a(Activity paramActivity) {
    for (Activity activity : this.b) {
      if (activity != null && activity != paramActivity && !activity.isFinishing())
        activity.finish(); 
    } 
    this.b.add(paramActivity);
  }
  
  void b(Activity paramActivity) {
    this.b.remove(paramActivity);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\hms\api\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */