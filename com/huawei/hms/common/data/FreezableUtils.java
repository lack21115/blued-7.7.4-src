package com.huawei.hms.common.data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public final class FreezableUtils {
  public static <T, E extends Freezable<T>> ArrayList<T> freeze(ArrayList<E> paramArrayList) {
    return freezeIterable(paramArrayList);
  }
  
  public static <T, E extends Freezable<T>> ArrayList<T> freeze(E[] paramArrayOfE) {
    return freezeIterable(Arrays.asList((Freezable<T>[])paramArrayOfE));
  }
  
  public static <T, E extends Freezable<T>> ArrayList<T> freezeIterable(Iterable<E> paramIterable) {
    ArrayList<T> arrayList = new ArrayList();
    Iterator<E> iterator = paramIterable.iterator();
    while (iterator.hasNext())
      arrayList.add(((Freezable)iterator.next()).freeze()); 
    return arrayList;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\hms\common\data\FreezableUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */