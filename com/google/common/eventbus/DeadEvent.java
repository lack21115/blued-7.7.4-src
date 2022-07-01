package com.google.common.eventbus;

import com.google.common.base.MoreObjects;

public class DeadEvent {
  private final Object a;
  
  private final Object b;
  
  public String toString() {
    return MoreObjects.a(this).a("source", this.a).a("event", this.b).toString();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\common\eventbus\DeadEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */