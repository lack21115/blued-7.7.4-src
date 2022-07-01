package com.bytedance.tea.crash.f;

import android.content.Context;
import android.os.Handler;
import com.bytedance.tea.crash.g.j;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class c {
  private List<a> a = new ArrayList<a>(3);
  
  private c(Handler paramHandler, Context paramContext) {
    this.a.add(new b(paramHandler, 0L, 15000L));
  }
  
  public static c a(Handler paramHandler, Context paramContext) {
    return new c(paramHandler, paramContext);
  }
  
  public void a() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("[ScheduleTaskManager] execute, task size=");
    stringBuilder.append(this.a.size());
    j.a(stringBuilder.toString());
    Iterator<a> iterator = this.a.iterator();
    while (true) {
      if (iterator.hasNext()) {
        a a = iterator.next();
        try {
          a.a();
        } finally {}
        continue;
      } 
      return;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\tea\crash\f\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */