package com.google.common.collect;

class EmptyImmutableSetMultimap extends ImmutableSetMultimap<Object, Object> {
  static final EmptyImmutableSetMultimap a = new EmptyImmutableSetMultimap();
  
  private EmptyImmutableSetMultimap() {
    super(ImmutableMap.j(), 0, null);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\common\collect\EmptyImmutableSetMultimap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */