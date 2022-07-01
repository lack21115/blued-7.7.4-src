package com.blued.android.framework.ui.mvp;

import android.util.Pair;
import java.util.ArrayList;
import java.util.List;

public class MemoryDataCache<T> {
  List<Pair<String, List>> a = new ArrayList<Pair<String, List>>();
  
  private Pair<String, List> b(String paramString) {
    for (Pair<String, List> pair : this.a) {
      if (((String)pair.first).equals(paramString))
        return pair; 
    } 
    return null;
  }
  
  public List<Pair<String, List>> a() {
    return new ArrayList<Pair<String, List>>(this.a);
  }
  
  public List<Object> a(String paramString) {
    Pair<String, List> pair = b(paramString);
    return (pair != null) ? (List<Object>)pair.second : null;
  }
  
  public List a(String paramString, List paramList) {
    ArrayList arrayList;
    Pair<String, List> pair = b(paramString);
    if (paramList != null) {
      if (pair != null) {
        ((List)pair.second).clear();
        ((List)pair.second).addAll(paramList);
        return (List)pair.second;
      } 
      arrayList = new ArrayList();
      arrayList.addAll(paramList);
      this.a.add(new Pair(paramString, arrayList));
      return arrayList;
    } 
    return (arrayList != null) ? (List)((Pair)arrayList).second : null;
  }
  
  public List b(String paramString, List paramList) {
    ArrayList arrayList;
    Pair<String, List> pair = b(paramString);
    if (paramList != null) {
      if (pair != null) {
        ((List)pair.second).addAll(paramList);
        return (List)pair.second;
      } 
      arrayList = new ArrayList();
      arrayList.addAll(paramList);
      this.a.add(new Pair(paramString, arrayList));
      return arrayList;
    } 
    return (arrayList != null) ? (List)((Pair)arrayList).second : null;
  }
  
  public boolean b() {
    return this.a.isEmpty();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\framewor\\ui\mvp\MemoryDataCache.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */