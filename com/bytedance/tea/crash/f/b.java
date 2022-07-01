package com.bytedance.tea.crash.f;

import android.os.Handler;
import android.text.TextUtils;
import com.bytedance.tea.crash.g.j;
import com.bytedance.tea.crash.h;

public class b extends a {
  b(Handler paramHandler, long paramLong1, long paramLong2) {
    super(paramHandler, paramLong1, paramLong2);
  }
  
  public void run() {
    String str = h.a().e();
    if (TextUtils.isEmpty(str) || "0".equals(str)) {
      a(c());
      j.a("[DeviceIdTask] did is null, continue check.");
      return;
    } 
    h.c().a(str);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("[DeviceIdTask] did is ");
    stringBuilder.append(str);
    j.a(stringBuilder.toString());
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\tea\crash\f\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */