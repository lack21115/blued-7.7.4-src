package com.google.common.collect;

class EmptyImmutableListMultimap extends ImmutableListMultimap<Object, Object> {
  static final EmptyImmutableListMultimap a = new EmptyImmutableListMultimap();
  
  private EmptyImmutableListMultimap() {
    super(ImmutableMap.j(), 0);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\common\collect\EmptyImmutableListMultimap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */