package com.qq.e.comm.plugin.util;

import android.app.Activity;
import android.os.Build;
import com.qq.e.comm.util.GDTLogger;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;

public class af {
  private static final Set<Integer> a;
  
  private Map<Activity, Integer> b = new WeakHashMap<Activity, Integer>(1);
  
  static {
    HashSet<? extends Integer> hashSet;
    int i = Build.VERSION.SDK_INT;
    Integer integer1 = Integer.valueOf(10);
    Integer integer2 = Integer.valueOf(-1);
    Integer integer3 = Integer.valueOf(2);
    Integer integer4 = Integer.valueOf(4);
    if (i >= 18) {
      hashSet = new HashSet(Arrays.asList((Object[])new Integer[] { integer2, integer3, integer1, integer4, Integer.valueOf(13) }));
    } else {
      hashSet = new HashSet(Arrays.asList((Object[])new Integer[] { integer2, integer3, (Integer)hashSet, integer4 }));
    } 
    a = Collections.unmodifiableSet(hashSet);
  }
  
  private boolean c() {
    return (Build.VERSION.SDK_INT > 8);
  }
  
  public void a() {
    try {
      b();
      return;
    } catch (IllegalStateException illegalStateException) {
      GDTLogger.e("unLockOrientation exception", illegalStateException);
      return;
    } 
  }
  
  public void a(Activity paramActivity) {
    try {
      b(paramActivity);
      return;
    } catch (IllegalStateException illegalStateException) {
      GDTLogger.e("lockOrientation exception", illegalStateException);
      return;
    } 
  }
  
  public void b() {
    Map<Activity, Integer> map = this.b;
    if (map == null) {
      GDTLogger.report("HoldingActivityOrientationMap null");
      return;
    } 
    if (map.size() > 1)
      GDTLogger.report("HoldingActivityOrientationMap is holding More than one entry"); 
    for (Activity activity : this.b.keySet()) {
      if (activity != null)
        activity.setRequestedOrientation(((Integer)this.b.get(activity)).intValue()); 
    } 
    this.b.clear();
  }
  
  public void b(Activity paramActivity) {
    int i = paramActivity.getRequestedOrientation();
    if (a.contains(Integer.valueOf(i))) {
      String str;
      int j = (paramActivity.getResources().getConfiguration()).orientation;
      int k = paramActivity.getWindowManager().getDefaultDisplay().getRotation();
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("config ORIENTATION=");
      if (j == 2) {
        str = "landscape";
      } else {
        str = "patr";
      } 
      stringBuilder.append(str);
      stringBuilder.append(" \t rotation:");
      stringBuilder.append(k);
      GDTLogger.d(stringBuilder.toString());
      if (j == 2) {
        if (c() && (k == 2 || k == 3)) {
          j = 8;
        } else {
          j = 0;
        } 
      } else if (c() && (k == 2 || k == 1)) {
        j = 9;
      } else {
        paramActivity.setRequestedOrientation(1);
        this.b.put(paramActivity, Integer.valueOf(i));
      } 
      paramActivity.setRequestedOrientation(j);
    } else {
      return;
    } 
    this.b.put(paramActivity, Integer.valueOf(i));
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\plugi\\util\af.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */