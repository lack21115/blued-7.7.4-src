package com.qq.e.comm.plugin.v;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.plugin.util.am;
import com.qq.e.comm.plugin.util.p;
import com.qq.e.comm.util.GDTLogger;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class b {
  private Set<String> a = new HashSet<String>();
  
  private b() {
    this.a.add("V1818A");
    String str = GDTADManager.getInstance().getSM().getString("express_reward_video_adapt_height_devices");
    if (!TextUtils.isEmpty(str)) {
      String[] arrayOfString = str.split(",");
      this.a.addAll(Arrays.asList(arrayOfString));
    } 
  }
  
  static b a() {
    return a.a();
  }
  
  private boolean b() {
    String str = Build.MODEL;
    Iterator<String> iterator = this.a.iterator();
    while (iterator.hasNext()) {
      if (TextUtils.equals(iterator.next(), str))
        return true; 
    } 
    return false;
  }
  
  int a(Context paramContext, int paramInt) {
    int i;
    if (b()) {
      i = paramInt - am.b(paramContext, p.c(paramContext));
    } else {
      i = paramInt;
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("CompatUtil.adaptWebViewHeight: origin = ");
    stringBuilder.append(paramInt);
    stringBuilder.append(", result = ");
    stringBuilder.append(i);
    GDTLogger.d(stringBuilder.toString());
    return i;
  }
  
  static class a {
    private static final b a = new b();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\plugin\v\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */