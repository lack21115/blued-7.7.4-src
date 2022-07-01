package com.bumptech.glide.load.engine.prefill;

import java.util.List;
import java.util.Map;

final class PreFillQueue {
  private final Map<PreFillType, Integer> a;
  
  private final List<PreFillType> b;
  
  private int c;
  
  private int d;
  
  public PreFillType a() {
    int i;
    PreFillType preFillType = this.b.get(this.d);
    Integer integer = this.a.get(preFillType);
    if (integer.intValue() == 1) {
      this.a.remove(preFillType);
      this.b.remove(this.d);
    } else {
      this.a.put(preFillType, Integer.valueOf(integer.intValue() - 1));
    } 
    this.c--;
    if (this.b.isEmpty()) {
      i = 0;
    } else {
      i = (this.d + 1) % this.b.size();
    } 
    this.d = i;
    return preFillType;
  }
  
  public boolean b() {
    return (this.c == 0);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bumptech\glide\load\engine\prefill\PreFillQueue.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */