package com.qq.e.comm.plugin.v;

import java.lang.ref.WeakReference;
import java.util.HashMap;

class a {
  private static HashMap<Integer, WeakReference<f>> a = new HashMap<Integer, WeakReference<f>>();
  
  static f a(int paramInt) {
    WeakReference<f> weakReference = a.get(Integer.valueOf(paramInt));
    return (weakReference != null) ? weakReference.get() : null;
  }
  
  static void a(int paramInt, f paramf) {
    a.put(Integer.valueOf(paramInt), new WeakReference<f>(paramf));
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\plugin\v\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */