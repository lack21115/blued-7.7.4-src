package com.airbnb.lottie.model;

import androidx.core.util.Pair;

public class MutablePair<T> {
  T a;
  
  T b;
  
  private static boolean b(Object paramObject1, Object paramObject2) {
    return (paramObject1 == paramObject2 || (paramObject1 != null && paramObject1.equals(paramObject2)));
  }
  
  public void a(T paramT1, T paramT2) {
    this.a = paramT1;
    this.b = paramT2;
  }
  
  public boolean equals(Object paramObject) {
    boolean bool = paramObject instanceof Pair;
    boolean bool1 = false;
    if (!bool)
      return false; 
    paramObject = paramObject;
    bool = bool1;
    if (b(((Pair)paramObject).first, this.a)) {
      bool = bool1;
      if (b(((Pair)paramObject).second, this.b))
        bool = true; 
    } 
    return bool;
  }
  
  public int hashCode() {
    int i;
    T t = this.a;
    int j = 0;
    if (t == null) {
      i = 0;
    } else {
      i = t.hashCode();
    } 
    t = this.b;
    if (t != null)
      j = t.hashCode(); 
    return i ^ j;
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Pair{");
    stringBuilder.append(String.valueOf(this.a));
    stringBuilder.append(" ");
    stringBuilder.append(String.valueOf(this.b));
    stringBuilder.append("}");
    return stringBuilder.toString();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\airbnb\lottie\model\MutablePair.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */