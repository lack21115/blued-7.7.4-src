package com.google.android.cameraview;

import androidx.collection.ArrayMap;
import java.util.Iterator;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

class SizeMap {
  private final ArrayMap<AspectRatio, SortedSet<Size>> a = new ArrayMap();
  
  Set<AspectRatio> a() {
    return this.a.keySet();
  }
  
  public void a(AspectRatio paramAspectRatio) {
    this.a.remove(paramAspectRatio);
  }
  
  public boolean a(Size paramSize) {
    Iterator<AspectRatio> iterator = this.a.keySet().iterator();
    while (iterator.hasNext()) {
      AspectRatio aspectRatio = iterator.next();
      if (aspectRatio.a(paramSize)) {
        SortedSet<Size> sortedSet = (SortedSet)this.a.get(aspectRatio);
        if (sortedSet.contains(paramSize))
          return false; 
        sortedSet.add(paramSize);
        return true;
      } 
    } 
    TreeSet<Size> treeSet = new TreeSet();
    treeSet.add(paramSize);
    this.a.put(AspectRatio.a(paramSize.a(), paramSize.b()), treeSet);
    return true;
  }
  
  SortedSet<Size> b(AspectRatio paramAspectRatio) {
    return (SortedSet<Size>)this.a.get(paramAspectRatio);
  }
  
  void b() {
    this.a.clear();
  }
  
  boolean c() {
    return this.a.isEmpty();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\cameraview\SizeMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */