package com.google.common.collect;

import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.Queue;

@Deprecated
public abstract class TreeTraverser<T> {
  public abstract Iterable<T> a(T paramT);
  
  UnmodifiableIterator<T> b(T paramT) {
    return new PreOrderIterator(this, paramT);
  }
  
  UnmodifiableIterator<T> c(T paramT) {
    return new PostOrderIterator(this, paramT);
  }
  
  final class BreadthFirstIterator extends UnmodifiableIterator<T> implements PeekingIterator<T> {
    private final Queue<T> b = new ArrayDeque<T>();
    
    BreadthFirstIterator(TreeTraverser this$0, T param1T) {
      this.b.add(param1T);
    }
    
    public T a() {
      return this.b.element();
    }
    
    public boolean hasNext() {
      return this.b.isEmpty() ^ true;
    }
    
    public T next() {
      T t = this.b.remove();
      Iterables.a(this.b, this.a.a(t));
      return t;
    }
  }
  
  final class PostOrderIterator extends AbstractIterator<T> {
    private final ArrayDeque<TreeTraverser.PostOrderNode<T>> b = new ArrayDeque<TreeTraverser.PostOrderNode<T>>();
    
    PostOrderIterator(TreeTraverser this$0, T param1T) {
      this.b.addLast(a(param1T));
    }
    
    private TreeTraverser.PostOrderNode<T> a(T param1T) {
      return new TreeTraverser.PostOrderNode<T>(param1T, this.a.a(param1T).iterator());
    }
    
    protected T a() {
      while (!this.b.isEmpty()) {
        TreeTraverser.PostOrderNode postOrderNode = this.b.getLast();
        if (postOrderNode.b.hasNext()) {
          postOrderNode = postOrderNode.b.next();
          this.b.addLast(a((T)postOrderNode));
          continue;
        } 
        this.b.removeLast();
        return postOrderNode.a;
      } 
      return b();
    }
  }
  
  static final class PostOrderNode<T> {
    final T a;
    
    final Iterator<T> b;
    
    PostOrderNode(T param1T, Iterator<T> param1Iterator) {
      this.a = (T)Preconditions.a(param1T);
      this.b = (Iterator<T>)Preconditions.a(param1Iterator);
    }
  }
  
  final class PreOrderIterator extends UnmodifiableIterator<T> {
    private final Deque<Iterator<T>> b = new ArrayDeque<Iterator<T>>();
    
    PreOrderIterator(TreeTraverser this$0, T param1T) {
      this.b.addLast(Iterators.a((T)Preconditions.a(param1T)));
    }
    
    public boolean hasNext() {
      return this.b.isEmpty() ^ true;
    }
    
    public T next() {
      Iterator<T> iterator = this.b.getLast();
      Object object = Preconditions.a(iterator.next());
      if (!iterator.hasNext())
        this.b.removeLast(); 
      iterator = this.a.a(object).iterator();
      if (iterator.hasNext())
        this.b.addLast(iterator); 
      return (T)object;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\common\collect\TreeTraverser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */