package com.facebook.stetho.common;

import java.util.ArrayList;

public final class ArrayListAccumulator<E> extends ArrayList<E> implements Accumulator<E> {
  public void store(E paramE) {
    add(paramE);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\facebook\stetho\common\ArrayListAccumulator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */