package com.google.common.collect;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Comparator;

final class CompoundOrdering<T> extends Ordering<T> implements Serializable {
  final Comparator<? super T>[] a;
  
  public int compare(T paramT1, T paramT2) {
    int i = 0;
    while (true) {
      Comparator<? super T>[] arrayOfComparator = this.a;
      if (i < arrayOfComparator.length) {
        int j = arrayOfComparator[i].compare(paramT1, paramT2);
        if (j != 0)
          return j; 
        i++;
        continue;
      } 
      return 0;
    } 
  }
  
  public boolean equals(Object paramObject) {
    if (paramObject == this)
      return true; 
    if (paramObject instanceof CompoundOrdering) {
      paramObject = paramObject;
      return Arrays.equals((Object[])this.a, (Object[])((CompoundOrdering)paramObject).a);
    } 
    return false;
  }
  
  public int hashCode() {
    return Arrays.hashCode((Object[])this.a);
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Ordering.compound(");
    stringBuilder.append(Arrays.toString((Object[])this.a));
    stringBuilder.append(")");
    return stringBuilder.toString();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\common\collect\CompoundOrdering.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */