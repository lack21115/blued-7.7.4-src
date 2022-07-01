package com.google.common.graph;

import com.google.common.base.Preconditions;
import com.google.common.collect.AbstractIterator;
import com.google.common.collect.Iterables;
import com.google.common.collect.UnmodifiableIterator;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Queue;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

public abstract class Traverser<N> {
  static final class GraphTraverser<N> extends Traverser<N> {
    private final SuccessorsFunction<N> a;
    
    final class BreadthFirstIterator extends UnmodifiableIterator<N> {
      private final Queue<N> b = new ArrayDeque<N>();
      
      private final Set<N> c = new HashSet<N>();
      
      BreadthFirstIterator(Traverser.GraphTraverser this$0, Iterable<? extends N> param2Iterable) {
        for (Iterable<? extends N> param2Iterable : param2Iterable) {
          if (this.c.add((N)param2Iterable))
            this.b.add((N)param2Iterable); 
        } 
      }
      
      public boolean hasNext() {
        return this.b.isEmpty() ^ true;
      }
      
      public N next() {
        // Byte code:
        //   0: aload_0
        //   1: getfield b : Ljava/util/Queue;
        //   4: invokeinterface remove : ()Ljava/lang/Object;
        //   9: astore_1
        //   10: aload_0
        //   11: getfield a : Lcom/google/common/graph/Traverser$GraphTraverser;
        //   14: invokestatic a : (Lcom/google/common/graph/Traverser$GraphTraverser;)Lcom/google/common/graph/SuccessorsFunction;
        //   17: aload_1
        //   18: invokeinterface h : (Ljava/lang/Object;)Ljava/lang/Iterable;
        //   23: invokeinterface iterator : ()Ljava/util/Iterator;
        //   28: astore_2
        //   29: aload_2
        //   30: invokeinterface hasNext : ()Z
        //   35: ifeq -> 72
        //   38: aload_2
        //   39: invokeinterface next : ()Ljava/lang/Object;
        //   44: astore_3
        //   45: aload_0
        //   46: getfield c : Ljava/util/Set;
        //   49: aload_3
        //   50: invokeinterface add : (Ljava/lang/Object;)Z
        //   55: ifeq -> 29
        //   58: aload_0
        //   59: getfield b : Ljava/util/Queue;
        //   62: aload_3
        //   63: invokeinterface add : (Ljava/lang/Object;)Z
        //   68: pop
        //   69: goto -> 29
        //   72: aload_1
        //   73: areturn
      }
    }
    
    final class DepthFirstIterator extends AbstractIterator<N> {
      private final Deque<NodeAndSuccessors> b = new ArrayDeque<NodeAndSuccessors>();
      
      private final Set<N> c = new HashSet<N>();
      
      private final Traverser.Order d;
      
      DepthFirstIterator(Traverser.GraphTraverser this$0, Iterable<? extends N> param2Iterable, Traverser.Order param2Order) {
        this.b.push(new NodeAndSuccessors(this, null, param2Iterable));
        this.d = param2Order;
      }
      
      NodeAndSuccessors a(N param2N) {
        return new NodeAndSuccessors(this, param2N, Traverser.GraphTraverser.a(this.a).h(param2N));
      }
      
      public N a() {
        while (true) {
          while (true)
            break; 
          if (SYNTHETIC_LOCAL_VARIABLE_1 != null && ((NodeAndSuccessors)SYNTHETIC_LOCAL_VARIABLE_6).a != null)
            return ((NodeAndSuccessors)SYNTHETIC_LOCAL_VARIABLE_6).a; 
        } 
      }
      
      final class NodeAndSuccessors {
        @NullableDecl
        final N a;
        
        final Iterator<? extends N> b;
        
        NodeAndSuccessors(@NullableDecl Traverser.GraphTraverser.DepthFirstIterator this$0, N param3N, Iterable<? extends N> param3Iterable) {
          this.a = param3N;
          this.b = param3Iterable.iterator();
        }
      }
    }
    
    final class NodeAndSuccessors {
      @NullableDecl
      final N a;
      
      final Iterator<? extends N> b;
      
      NodeAndSuccessors(@NullableDecl Traverser.GraphTraverser this$0, N param2N, Iterable<? extends N> param2Iterable) {
        this.a = param2N;
        this.b = param2Iterable.iterator();
      }
    }
  }
  
  class null implements Iterable<N> {
    public Iterator<N> iterator() {
      return (Iterator<N>)new Traverser.GraphTraverser.BreadthFirstIterator(this.b, this.a);
    }
  }
  
  class null implements Iterable<N> {
    public Iterator<N> iterator() {
      return (Iterator<N>)new Traverser.GraphTraverser.DepthFirstIterator(this.b, this.a, Traverser.Order.a);
    }
  }
  
  class null implements Iterable<N> {
    public Iterator<N> iterator() {
      return (Iterator<N>)new Traverser.GraphTraverser.DepthFirstIterator(this.b, this.a, Traverser.Order.b);
    }
  }
  
  final class BreadthFirstIterator extends UnmodifiableIterator<N> {
    private final Queue<N> b = new ArrayDeque<N>();
    
    private final Set<N> c = new HashSet<N>();
    
    BreadthFirstIterator(Traverser this$0, Iterable<? extends N> param1Iterable) {
      for (Iterable<? extends N> param1Iterable : param1Iterable) {
        if (this.c.add((N)param1Iterable))
          this.b.add((N)param1Iterable); 
      } 
    }
    
    public boolean hasNext() {
      return this.b.isEmpty() ^ true;
    }
    
    public N next() {
      // Byte code:
      //   0: aload_0
      //   1: getfield b : Ljava/util/Queue;
      //   4: invokeinterface remove : ()Ljava/lang/Object;
      //   9: astore_1
      //   10: aload_0
      //   11: getfield a : Lcom/google/common/graph/Traverser$GraphTraverser;
      //   14: invokestatic a : (Lcom/google/common/graph/Traverser$GraphTraverser;)Lcom/google/common/graph/SuccessorsFunction;
      //   17: aload_1
      //   18: invokeinterface h : (Ljava/lang/Object;)Ljava/lang/Iterable;
      //   23: invokeinterface iterator : ()Ljava/util/Iterator;
      //   28: astore_2
      //   29: aload_2
      //   30: invokeinterface hasNext : ()Z
      //   35: ifeq -> 72
      //   38: aload_2
      //   39: invokeinterface next : ()Ljava/lang/Object;
      //   44: astore_3
      //   45: aload_0
      //   46: getfield c : Ljava/util/Set;
      //   49: aload_3
      //   50: invokeinterface add : (Ljava/lang/Object;)Z
      //   55: ifeq -> 29
      //   58: aload_0
      //   59: getfield b : Ljava/util/Queue;
      //   62: aload_3
      //   63: invokeinterface add : (Ljava/lang/Object;)Z
      //   68: pop
      //   69: goto -> 29
      //   72: aload_1
      //   73: areturn
    }
  }
  
  final class DepthFirstIterator extends AbstractIterator<N> {
    private final Deque<NodeAndSuccessors> b = new ArrayDeque<NodeAndSuccessors>();
    
    private final Set<N> c = new HashSet<N>();
    
    private final Traverser.Order d;
    
    DepthFirstIterator(Traverser this$0, Iterable<? extends N> param1Iterable, Traverser.Order param1Order) {
      this.b.push(new NodeAndSuccessors(this, null, param1Iterable));
      this.d = param1Order;
    }
    
    NodeAndSuccessors a(N param1N) {
      return new NodeAndSuccessors(this, param1N, Traverser.GraphTraverser.a(this.a).h(param1N));
    }
    
    public N a() {
      while (true) {
        while (true)
          break; 
        if (SYNTHETIC_LOCAL_VARIABLE_1 != null && ((NodeAndSuccessors)SYNTHETIC_LOCAL_VARIABLE_6).a != null)
          return ((NodeAndSuccessors)SYNTHETIC_LOCAL_VARIABLE_6).a; 
      } 
    }
    
    final class NodeAndSuccessors {
      @NullableDecl
      final N a;
      
      final Iterator<? extends N> b;
      
      NodeAndSuccessors(@NullableDecl Traverser.GraphTraverser.DepthFirstIterator this$0, N param3N, Iterable<? extends N> param3Iterable) {
        this.a = param3N;
        this.b = param3Iterable.iterator();
      }
    }
  }
  
  final class NodeAndSuccessors {
    @NullableDecl
    final N a;
    
    final Iterator<? extends N> b;
    
    NodeAndSuccessors(@NullableDecl Traverser this$0, N param1N, Iterable<? extends N> param1Iterable) {
      this.a = param1N;
      this.b = param1Iterable.iterator();
    }
  }
  
  enum Order {
    a, b;
  }
  
  static final class TreeTraverser<N> extends Traverser<N> {
    private final SuccessorsFunction<N> a;
    
    final class BreadthFirstIterator extends UnmodifiableIterator<N> {
      private final Queue<N> b = new ArrayDeque<N>();
      
      BreadthFirstIterator(Traverser.TreeTraverser this$0, Iterable<? extends N> param2Iterable) {
        for (Iterable<? extends N> param2Iterable : param2Iterable)
          this.b.add((N)param2Iterable); 
      }
      
      public boolean hasNext() {
        return this.b.isEmpty() ^ true;
      }
      
      public N next() {
        N n = this.b.remove();
        Iterables.a(this.b, Traverser.TreeTraverser.a(this.a).h(n));
        return n;
      }
    }
    
    final class DepthFirstPostOrderIterator extends AbstractIterator<N> {
      private final ArrayDeque<NodeAndChildren> b = new ArrayDeque<NodeAndChildren>();
      
      DepthFirstPostOrderIterator(Traverser.TreeTraverser this$0, Iterable<? extends N> param2Iterable) {
        this.b.addLast(new NodeAndChildren(this, null, param2Iterable));
      }
      
      NodeAndChildren a(N param2N) {
        return new NodeAndChildren(this, param2N, Traverser.TreeTraverser.a(this.a).h(param2N));
      }
      
      public N a() {
        while (!this.b.isEmpty()) {
          NodeAndChildren nodeAndChildren = this.b.getLast();
          if (nodeAndChildren.b.hasNext()) {
            nodeAndChildren = (NodeAndChildren)nodeAndChildren.b.next();
            this.b.addLast(a((N)nodeAndChildren));
            continue;
          } 
          this.b.removeLast();
          if (nodeAndChildren.a != null)
            return nodeAndChildren.a; 
        } 
        return (N)b();
      }
      
      final class NodeAndChildren {
        @NullableDecl
        final N a;
        
        final Iterator<? extends N> b;
        
        NodeAndChildren(@NullableDecl Traverser.TreeTraverser.DepthFirstPostOrderIterator this$0, N param3N, Iterable<? extends N> param3Iterable) {
          this.a = param3N;
          this.b = param3Iterable.iterator();
        }
      }
    }
    
    final class NodeAndChildren {
      @NullableDecl
      final N a;
      
      final Iterator<? extends N> b;
      
      NodeAndChildren(@NullableDecl Traverser.TreeTraverser this$0, N param2N, Iterable<? extends N> param2Iterable) {
        this.a = param2N;
        this.b = param2Iterable.iterator();
      }
    }
    
    final class DepthFirstPreOrderIterator extends UnmodifiableIterator<N> {
      private final Deque<Iterator<? extends N>> b = new ArrayDeque<Iterator<? extends N>>();
      
      DepthFirstPreOrderIterator(Traverser.TreeTraverser this$0, Iterable<? extends N> param2Iterable) {
        this.b.addLast(param2Iterable.iterator());
      }
      
      public boolean hasNext() {
        return this.b.isEmpty() ^ true;
      }
      
      public N next() {
        Iterator<? extends N> iterator = this.b.getLast();
        Object object = Preconditions.a(iterator.next());
        if (!iterator.hasNext())
          this.b.removeLast(); 
        iterator = Traverser.TreeTraverser.a(this.a).h(object).iterator();
        if (iterator.hasNext())
          this.b.addLast(iterator); 
        return (N)object;
      }
    }
  }
  
  class null implements Iterable<N> {
    public Iterator<N> iterator() {
      return (Iterator<N>)new Traverser.TreeTraverser.BreadthFirstIterator(this.b, this.a);
    }
  }
  
  class null implements Iterable<N> {
    public Iterator<N> iterator() {
      return (Iterator<N>)new Traverser.TreeTraverser.DepthFirstPreOrderIterator(this.b, this.a);
    }
  }
  
  class null implements Iterable<N> {
    public Iterator<N> iterator() {
      return (Iterator<N>)new Traverser.TreeTraverser.DepthFirstPostOrderIterator(this.b, this.a);
    }
  }
  
  final class BreadthFirstIterator extends UnmodifiableIterator<N> {
    private final Queue<N> b = new ArrayDeque<N>();
    
    BreadthFirstIterator(Traverser this$0, Iterable<? extends N> param1Iterable) {
      for (Iterable<? extends N> param1Iterable : param1Iterable)
        this.b.add((N)param1Iterable); 
    }
    
    public boolean hasNext() {
      return this.b.isEmpty() ^ true;
    }
    
    public N next() {
      N n = this.b.remove();
      Iterables.a(this.b, Traverser.TreeTraverser.a(this.a).h(n));
      return n;
    }
  }
  
  final class DepthFirstPostOrderIterator extends AbstractIterator<N> {
    private final ArrayDeque<NodeAndChildren> b = new ArrayDeque<NodeAndChildren>();
    
    DepthFirstPostOrderIterator(Traverser this$0, Iterable<? extends N> param1Iterable) {
      this.b.addLast(new NodeAndChildren(this, null, param1Iterable));
    }
    
    NodeAndChildren a(N param1N) {
      return new NodeAndChildren(this, param1N, Traverser.TreeTraverser.a(this.a).h(param1N));
    }
    
    public N a() {
      while (!this.b.isEmpty()) {
        NodeAndChildren nodeAndChildren = this.b.getLast();
        if (nodeAndChildren.b.hasNext()) {
          nodeAndChildren = (NodeAndChildren)nodeAndChildren.b.next();
          this.b.addLast(a((N)nodeAndChildren));
          continue;
        } 
        this.b.removeLast();
        if (nodeAndChildren.a != null)
          return nodeAndChildren.a; 
      } 
      return (N)b();
    }
    
    final class NodeAndChildren {
      @NullableDecl
      final N a;
      
      final Iterator<? extends N> b;
      
      NodeAndChildren(@NullableDecl Traverser.TreeTraverser.DepthFirstPostOrderIterator this$0, N param3N, Iterable<? extends N> param3Iterable) {
        this.a = param3N;
        this.b = param3Iterable.iterator();
      }
    }
  }
  
  final class NodeAndChildren {
    @NullableDecl
    final N a;
    
    final Iterator<? extends N> b;
    
    NodeAndChildren(@NullableDecl Traverser this$0, N param1N, Iterable<? extends N> param1Iterable) {
      this.a = param1N;
      this.b = param1Iterable.iterator();
    }
  }
  
  final class DepthFirstPreOrderIterator extends UnmodifiableIterator<N> {
    private final Deque<Iterator<? extends N>> b = new ArrayDeque<Iterator<? extends N>>();
    
    DepthFirstPreOrderIterator(Traverser this$0, Iterable<? extends N> param1Iterable) {
      this.b.addLast(param1Iterable.iterator());
    }
    
    public boolean hasNext() {
      return this.b.isEmpty() ^ true;
    }
    
    public N next() {
      Iterator<? extends N> iterator = this.b.getLast();
      Object object = Preconditions.a(iterator.next());
      if (!iterator.hasNext())
        this.b.removeLast(); 
      iterator = Traverser.TreeTraverser.a(this.a).h(object).iterator();
      if (iterator.hasNext())
        this.b.addLast(iterator); 
      return (N)object;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\common\graph\Traverser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */