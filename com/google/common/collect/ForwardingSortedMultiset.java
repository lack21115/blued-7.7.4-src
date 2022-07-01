package com.google.common.collect;

public abstract class ForwardingSortedMultiset<E> extends ForwardingMultiset<E> implements SortedMultiset<E> {
  public abstract class StandardDescendingMultiset extends DescendingMultiset<E> {}
  
  public class StandardElementSet extends SortedMultisets.NavigableElementSet<E> {}
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\common\collect\ForwardingSortedMultiset.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */