package com.airbnb.lottie.model.animatable;

import com.airbnb.lottie.value.Keyframe;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

abstract class BaseAnimatableValue<V, O> implements AnimatableValue<V, O> {
  final List<Keyframe<V>> a;
  
  BaseAnimatableValue(V paramV) {
    this(Collections.singletonList(new Keyframe(paramV)));
  }
  
  BaseAnimatableValue(List<Keyframe<V>> paramList) {
    this.a = paramList;
  }
  
  public boolean b() {
    null = this.a.isEmpty();
    boolean bool = false;
    if (!null) {
      null = bool;
      if (this.a.size() == 1) {
        null = bool;
        if (((Keyframe)this.a.get(0)).e())
          return true; 
      } 
      return null;
    } 
    return true;
  }
  
  public List<Keyframe<V>> c() {
    return this.a;
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    if (!this.a.isEmpty()) {
      stringBuilder.append("values=");
      stringBuilder.append(Arrays.toString(this.a.toArray()));
    } 
    return stringBuilder.toString();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\airbnb\lottie\model\animatable\BaseAnimatableValue.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */