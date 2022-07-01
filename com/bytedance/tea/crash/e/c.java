package com.bytedance.tea.crash.e;

import com.bytedance.tea.crash.g.d;

public class c {
  public static long a(int paramInt) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("/proc/self/task/");
    stringBuilder.append(paramInt);
    stringBuilder.append("/stat");
    String[] arrayOfString = d.d(stringBuilder.toString());
    return (arrayOfString == null) ? -1L : (Long.parseLong(arrayOfString[11]) * i.a.a() + Long.parseLong(arrayOfString[12]) * i.a.a());
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\tea\crash\e\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */