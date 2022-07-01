package com.blued.android.framework.view.stickylistheaders;

import java.util.HashMap;

class DualHashMap<TKey, TValue> {
  HashMap<TKey, TValue> a = new HashMap<TKey, TValue>();
  
  HashMap<TValue, TKey> b = new HashMap<TValue, TKey>();
  
  public TKey a(TValue paramTValue) {
    return this.b.get(paramTValue);
  }
  
  public void a(TKey paramTKey, TValue paramTValue) {
    c(paramTKey);
    d(paramTValue);
    this.a.put(paramTKey, paramTValue);
    this.b.put(paramTValue, paramTKey);
  }
  
  public TValue b(TKey paramTKey) {
    return this.a.get(paramTKey);
  }
  
  public void c(TKey paramTKey) {
    if (b(paramTKey) != null)
      this.b.remove(b(paramTKey)); 
    this.a.remove(paramTKey);
  }
  
  public void d(TValue paramTValue) {
    if (a(paramTValue) != null)
      this.a.remove(a(paramTValue)); 
    this.b.remove(paramTValue);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\framework\view\stickylistheaders\DualHashMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */