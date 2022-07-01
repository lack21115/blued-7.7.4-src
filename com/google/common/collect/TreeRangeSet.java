package com.google.common.collect;

import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import java.io.Serializable;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.NavigableMap;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

public class TreeRangeSet<C extends Comparable<?>> extends AbstractRangeSet<C> implements Serializable {
  final NavigableMap<Cut<C>, Range<C>> a;
  
  @NullableDecl
  private transient Set<Range<C>> b;
  
  @NullableDecl
  public Range<C> b(C paramC) {
    Preconditions.a(paramC);
    Map.Entry<Cut<C>, Range<C>> entry = this.a.floorEntry((Cut)Cut.b((Comparable)paramC));
    return (entry != null && ((Range)entry.getValue()).e(paramC)) ? entry.getValue() : null;
  }
  
  public Set<Range<C>> e() {
    Set<Range<C>> set2 = this.b;
    Set<Range<C>> set1 = set2;
    if (set2 == null) {
      set1 = new AsRanges(this, this.a.values());
      this.b = set1;
    } 
    return set1;
  }
  
  final class AsRanges extends ForwardingCollection<Range<C>> implements Set<Range<C>> {
    final Collection<Range<C>> a;
    
    AsRanges(TreeRangeSet this$0, Collection<Range<C>> param1Collection) {
      this.a = param1Collection;
    }
    
    protected Collection<Range<C>> c() {
      return this.a;
    }
    
    public boolean equals(@NullableDecl Object param1Object) {
      return Sets.a(this, param1Object);
    }
    
    public int hashCode() {
      return Sets.a(this);
    }
  }
  
  final class Complement extends TreeRangeSet<C> {
    public boolean a(C param1C) {
      return this.b.a((Comparable)param1C) ^ true;
    }
  }
  
  static final class ComplementRangesByLowerBound<C extends Comparable<?>> extends AbstractNavigableMap<Cut<C>, Range<C>> {
    private final NavigableMap<Cut<C>, Range<C>> a;
    
    private final NavigableMap<Cut<C>, Range<C>> b;
    
    private final Range<Cut<C>> c;
    
    private ComplementRangesByLowerBound(NavigableMap<Cut<C>, Range<C>> param1NavigableMap, Range<Cut<C>> param1Range) {
      this.a = param1NavigableMap;
      this.b = new TreeRangeSet.RangesByUpperBound<C>(param1NavigableMap);
      this.c = param1Range;
    }
    
    private NavigableMap<Cut<C>, Range<C>> a(Range<Cut<C>> param1Range) {
      if (!this.c.b(param1Range))
        return ImmutableSortedMap.d(); 
      param1Range = param1Range.c(this.c);
      return new ComplementRangesByLowerBound(this.a, param1Range);
    }
    
    @NullableDecl
    public Range<C> a(Object param1Object) {
      if (param1Object instanceof Cut)
        try {
          param1Object = param1Object;
          Map.Entry<Cut<C>, Range<C>> entry = b((Cut<C>)param1Object, true).firstEntry();
          return (entry != null && ((Cut)entry.getKey()).equals(param1Object)) ? entry.getValue() : null;
        } catch (ClassCastException classCastException) {
          return null;
        }  
      return null;
    }
    
    Iterator<Map.Entry<Cut<C>, Range<C>>> a() {
      boolean bool;
      Cut<Comparable> cut;
      if (this.c.h()) {
        cut = this.c.i();
      } else {
        cut = Cut.e();
      } 
      if (this.c.h() && this.c.j() == BoundType.b) {
        bool = true;
      } else {
        bool = false;
      } 
      PeekingIterator<?> peekingIterator = Iterators.i(this.b.headMap(cut, bool).descendingMap().values().iterator());
      if (peekingIterator.hasNext()) {
        if (((Range)peekingIterator.a()).b == Cut.e()) {
          cut = ((Range)peekingIterator.next()).a;
        } else {
          cut = (Cut<Comparable>)this.a.higherKey(((Range)peekingIterator.a()).b);
        } 
      } else {
        if (!this.c.e((Cut)Cut.d()) || this.a.containsKey(Cut.d()))
          return Iterators.a(); 
        cut = (Cut<Comparable>)this.a.higherKey(Cut.d());
      } 
      return new AbstractIterator<Map.Entry<Cut<C>, Range<C>>>(this, (Cut)MoreObjects.a(cut, Cut.e()), peekingIterator) {
          Cut<C> a = this.b;
          
          protected Map.Entry<Cut<C>, Range<C>> c() {
            if (this.a == Cut.d())
              return b(); 
            if (this.c.hasNext()) {
              Range range = this.c.next();
              Range<C> range1 = Range.a(range.b, this.a);
              this.a = range.a;
              if ((TreeRangeSet.ComplementRangesByLowerBound.a(this.d)).a.a(range1.a))
                return Maps.a(range1.a, range1); 
            } else if ((TreeRangeSet.ComplementRangesByLowerBound.a(this.d)).a.a(Cut.d())) {
              Range<C> range = Range.a((Cut)Cut.d(), this.a);
              this.a = Cut.d();
              return Maps.a((Cut)Cut.d(), range);
            } 
            return b();
          }
        };
    }
    
    public NavigableMap<Cut<C>, Range<C>> a(Cut<C> param1Cut, boolean param1Boolean) {
      return a(Range.a(param1Cut, BoundType.a(param1Boolean)));
    }
    
    public NavigableMap<Cut<C>, Range<C>> a(Cut<C> param1Cut1, boolean param1Boolean1, Cut<C> param1Cut2, boolean param1Boolean2) {
      return a(Range.a(param1Cut1, BoundType.a(param1Boolean1), param1Cut2, BoundType.a(param1Boolean2)));
    }
    
    Iterator<Map.Entry<Cut<C>, Range<C>>> b() {
      Collection<Range<C>> collection;
      Cut cut;
      if (this.c.e()) {
        boolean bool;
        NavigableMap<Cut<C>, Range<C>> navigableMap = this.b;
        Cut cut1 = (Cut)this.c.f();
        if (this.c.g() == BoundType.b) {
          bool = true;
        } else {
          bool = false;
        } 
        collection = navigableMap.tailMap(cut1, bool).values();
      } else {
        collection = this.b.values();
      } 
      PeekingIterator<?> peekingIterator = Iterators.i(collection.iterator());
      if (this.c.e((Cut)Cut.d()) && (!peekingIterator.hasNext() || ((Range)peekingIterator.a()).a != Cut.d())) {
        cut = Cut.d();
      } else {
        if (peekingIterator.hasNext()) {
          cut = ((Range)peekingIterator.next()).b;
          return new AbstractIterator<Map.Entry<Cut<C>, Range<C>>>(this, cut, peekingIterator) {
              Cut<C> a = this.b;
              
              protected Map.Entry<Cut<C>, Range<C>> c() {
                Range<C> range;
                if ((TreeRangeSet.ComplementRangesByLowerBound.a(this.d)).b.a(this.a) || this.a == Cut.e())
                  return b(); 
                if (this.c.hasNext()) {
                  Range range1 = this.c.next();
                  range = Range.a(this.a, range1.a);
                  this.a = range1.b;
                } else {
                  range = Range.a(this.a, (Cut)Cut.e());
                  this.a = Cut.e();
                } 
                return Maps.a(range.a, range);
              }
            };
        } 
        return Iterators.a();
      } 
      return new AbstractIterator<Map.Entry<Cut<C>, Range<C>>>(this, cut, peekingIterator) {
          Cut<C> a = this.b;
          
          protected Map.Entry<Cut<C>, Range<C>> c() {
            Range<C> range;
            if ((TreeRangeSet.ComplementRangesByLowerBound.a(this.d)).b.a(this.a) || this.a == Cut.e())
              return b(); 
            if (this.c.hasNext()) {
              Range range1 = this.c.next();
              range = Range.a(this.a, range1.a);
              this.a = range1.b;
            } else {
              range = Range.a(this.a, (Cut)Cut.e());
              this.a = Cut.e();
            } 
            return Maps.a(range.a, range);
          }
        };
    }
    
    public NavigableMap<Cut<C>, Range<C>> b(Cut<C> param1Cut, boolean param1Boolean) {
      return a(Range.b(param1Cut, BoundType.a(param1Boolean)));
    }
    
    public Comparator<? super Cut<C>> comparator() {
      return Ordering.d();
    }
    
    public boolean containsKey(Object param1Object) {
      return (a(param1Object) != null);
    }
    
    public int size() {
      return Iterators.b(b());
    }
  }
  
  class null extends AbstractIterator<Map.Entry<Cut<C>, Range<C>>> {
    Cut<C> a = this.b;
    
    null(TreeRangeSet this$0, Cut param1Cut, PeekingIterator param1PeekingIterator) {}
    
    protected Map.Entry<Cut<C>, Range<C>> c() {
      Range<C> range;
      if ((TreeRangeSet.ComplementRangesByLowerBound.a(this.d)).b.a(this.a) || this.a == Cut.e())
        return b(); 
      if (this.c.hasNext()) {
        Range range1 = this.c.next();
        range = Range.a(this.a, range1.a);
        this.a = range1.b;
      } else {
        range = Range.a(this.a, (Cut)Cut.e());
        this.a = Cut.e();
      } 
      return Maps.a(range.a, range);
    }
  }
  
  class null extends AbstractIterator<Map.Entry<Cut<C>, Range<C>>> {
    Cut<C> a = this.b;
    
    null(TreeRangeSet this$0, Cut param1Cut, PeekingIterator param1PeekingIterator) {}
    
    protected Map.Entry<Cut<C>, Range<C>> c() {
      if (this.a == Cut.d())
        return b(); 
      if (this.c.hasNext()) {
        Range range = this.c.next();
        Range<C> range1 = Range.a(range.b, this.a);
        this.a = range.a;
        if ((TreeRangeSet.ComplementRangesByLowerBound.a(this.d)).a.a(range1.a))
          return Maps.a(range1.a, range1); 
      } else if ((TreeRangeSet.ComplementRangesByLowerBound.a(this.d)).a.a(Cut.d())) {
        Range<C> range = Range.a((Cut)Cut.d(), this.a);
        this.a = Cut.d();
        return Maps.a((Cut)Cut.d(), range);
      } 
      return b();
    }
  }
  
  static final class RangesByUpperBound<C extends Comparable<?>> extends AbstractNavigableMap<Cut<C>, Range<C>> {
    private final NavigableMap<Cut<C>, Range<C>> a;
    
    private final Range<Cut<C>> b;
    
    RangesByUpperBound(NavigableMap<Cut<C>, Range<C>> param1NavigableMap) {
      this.a = param1NavigableMap;
      this.b = Range.d();
    }
    
    private RangesByUpperBound(NavigableMap<Cut<C>, Range<C>> param1NavigableMap, Range<Cut<C>> param1Range) {
      this.a = param1NavigableMap;
      this.b = param1Range;
    }
    
    private NavigableMap<Cut<C>, Range<C>> a(Range<Cut<C>> param1Range) {
      return (NavigableMap<Cut<C>, Range<C>>)(param1Range.b(this.b) ? new RangesByUpperBound(this.a, param1Range.c(this.b)) : ImmutableSortedMap.d());
    }
    
    public Range<C> a(@NullableDecl Object param1Object) {
      if (param1Object instanceof Cut)
        try {
          param1Object = param1Object;
          if (!this.b.e(param1Object))
            return null; 
          Map.Entry<Object, Range<C>> entry = this.a.lowerEntry(param1Object);
          return (entry != null && ((Range)entry.getValue()).b.equals(param1Object)) ? entry.getValue() : null;
        } catch (ClassCastException classCastException) {
          return null;
        }  
      return null;
    }
    
    Iterator<Map.Entry<Cut<C>, Range<C>>> a() {
      Collection<?> collection;
      if (this.b.h()) {
        collection = this.a.headMap(this.b.i(), false).descendingMap().values();
      } else {
        collection = this.a.descendingMap().values();
      } 
      PeekingIterator<?> peekingIterator = Iterators.i(collection.iterator());
      if (peekingIterator.hasNext() && this.b.b.a(((Range)peekingIterator.a()).b))
        peekingIterator.next(); 
      return new AbstractIterator<Map.Entry<Cut<C>, Range<C>>>(this, peekingIterator) {
          protected Map.Entry<Cut<C>, Range<C>> c() {
            if (!this.a.hasNext())
              return b(); 
            Range<C> range = this.a.next();
            return (TreeRangeSet.RangesByUpperBound.a(this.b)).a.a(range.b) ? Maps.a(range.b, range) : b();
          }
        };
    }
    
    public NavigableMap<Cut<C>, Range<C>> a(Cut<C> param1Cut, boolean param1Boolean) {
      return a(Range.a(param1Cut, BoundType.a(param1Boolean)));
    }
    
    public NavigableMap<Cut<C>, Range<C>> a(Cut<C> param1Cut1, boolean param1Boolean1, Cut<C> param1Cut2, boolean param1Boolean2) {
      return a(Range.a(param1Cut1, BoundType.a(param1Boolean1), param1Cut2, BoundType.a(param1Boolean2)));
    }
    
    Iterator<Map.Entry<Cut<C>, Range<C>>> b() {
      Iterator iterator;
      if (!this.b.e()) {
        iterator = this.a.values().iterator();
      } else {
        Map.Entry<Cut<C>, Range<C>> entry = this.a.lowerEntry(this.b.f());
        if (entry == null) {
          iterator = this.a.values().iterator();
        } else if (this.b.a.a(((Range)iterator.getValue()).b)) {
          iterator = this.a.tailMap((Cut<C>)iterator.getKey(), true).values().iterator();
        } else {
          iterator = this.a.tailMap(this.b.f(), true).values().iterator();
        } 
      } 
      return new AbstractIterator<Map.Entry<Cut<C>, Range<C>>>(this, iterator) {
          protected Map.Entry<Cut<C>, Range<C>> c() {
            if (!this.a.hasNext())
              return b(); 
            Range<C> range = this.a.next();
            return (TreeRangeSet.RangesByUpperBound.a(this.b)).b.a(range.b) ? b() : Maps.a(range.b, range);
          }
        };
    }
    
    public NavigableMap<Cut<C>, Range<C>> b(Cut<C> param1Cut, boolean param1Boolean) {
      return a(Range.b(param1Cut, BoundType.a(param1Boolean)));
    }
    
    public Comparator<? super Cut<C>> comparator() {
      return Ordering.d();
    }
    
    public boolean containsKey(@NullableDecl Object param1Object) {
      return (a(param1Object) != null);
    }
    
    public boolean isEmpty() {
      return this.b.equals(Range.d()) ? this.a.isEmpty() : (!b().hasNext());
    }
    
    public int size() {
      return this.b.equals(Range.d()) ? this.a.size() : Iterators.b(b());
    }
  }
  
  class null extends AbstractIterator<Map.Entry<Cut<C>, Range<C>>> {
    null(TreeRangeSet this$0, Iterator param1Iterator) {}
    
    protected Map.Entry<Cut<C>, Range<C>> c() {
      if (!this.a.hasNext())
        return b(); 
      Range<C> range = this.a.next();
      return (TreeRangeSet.RangesByUpperBound.a(this.b)).b.a(range.b) ? b() : Maps.a(range.b, range);
    }
  }
  
  class null extends AbstractIterator<Map.Entry<Cut<C>, Range<C>>> {
    null(TreeRangeSet this$0, PeekingIterator param1PeekingIterator) {}
    
    protected Map.Entry<Cut<C>, Range<C>> c() {
      if (!this.a.hasNext())
        return b(); 
      Range<C> range = this.a.next();
      return (TreeRangeSet.RangesByUpperBound.a(this.b)).a.a(range.b) ? Maps.a(range.b, range) : b();
    }
  }
  
  final class SubRangeSet extends TreeRangeSet<C> {
    private final Range<C> c;
    
    public boolean a(C param1C) {
      return (this.c.e(param1C) && this.b.a((Comparable)param1C));
    }
    
    @NullableDecl
    public Range<C> b(C param1C) {
      if (!this.c.e(param1C))
        return null; 
      Range<C> range = this.b.b(param1C);
      return (range == null) ? null : range.c(this.c);
    }
  }
  
  static final class SubRangeSetRangesByLowerBound<C extends Comparable<?>> extends AbstractNavigableMap<Cut<C>, Range<C>> {
    private final Range<Cut<C>> a;
    
    private final Range<C> b;
    
    private final NavigableMap<Cut<C>, Range<C>> c;
    
    private final NavigableMap<Cut<C>, Range<C>> d;
    
    private SubRangeSetRangesByLowerBound(Range<Cut<C>> param1Range, Range<C> param1Range1, NavigableMap<Cut<C>, Range<C>> param1NavigableMap) {
      this.a = (Range<Cut<C>>)Preconditions.a(param1Range);
      this.b = (Range<C>)Preconditions.a(param1Range1);
      this.c = (NavigableMap<Cut<C>, Range<C>>)Preconditions.a(param1NavigableMap);
      this.d = new TreeRangeSet.RangesByUpperBound<C>(param1NavigableMap);
    }
    
    private NavigableMap<Cut<C>, Range<C>> a(Range<Cut<C>> param1Range) {
      return (NavigableMap<Cut<C>, Range<C>>)(!param1Range.b(this.a) ? ImmutableSortedMap.d() : new SubRangeSetRangesByLowerBound(this.a.c(param1Range), this.b, this.c));
    }
    
    @NullableDecl
    public Range<C> a(@NullableDecl Object param1Object) {
      if (param1Object instanceof Cut)
        try {
          param1Object = param1Object;
          if (this.a.e(param1Object) && param1Object.a(this.b.a) >= 0) {
            if (param1Object.a(this.b.b) >= 0)
              return null; 
            if (param1Object.equals(this.b.a)) {
              param1Object = Maps.<Range>c((Map.Entry)this.c.floorEntry(param1Object));
              if (param1Object != null && ((Range)param1Object).b.a(this.b.a) > 0)
                return param1Object.c(this.b); 
            } else {
              param1Object = this.c.get(param1Object);
              if (param1Object != null)
                return param1Object.c(this.b); 
            } 
          } 
          return null;
        } catch (ClassCastException classCastException) {
          return null;
        }  
      return null;
    }
    
    Iterator<Map.Entry<Cut<C>, Range<C>>> a() {
      boolean bool;
      if (this.b.k())
        return Iterators.a(); 
      Cut<Object> cut = (Cut)Ordering.<Comparable>d().a(this.a.b, Cut.b(this.b.b));
      NavigableMap<Cut<C>, Range<C>> navigableMap = this.c;
      Cut cut1 = (Cut)cut.c();
      if (cut.b() == BoundType.b) {
        bool = true;
      } else {
        bool = false;
      } 
      return new AbstractIterator<Map.Entry<Cut<C>, Range<C>>>(this, navigableMap.headMap(cut1, bool).descendingMap().values().iterator()) {
          protected Map.Entry<Cut<C>, Range<C>> c() {
            if (!this.a.hasNext())
              return b(); 
            Range<C> range = this.a.next();
            if ((TreeRangeSet.SubRangeSetRangesByLowerBound.a(this.b)).a.a(range.b) >= 0)
              return b(); 
            range = range.c(TreeRangeSet.SubRangeSetRangesByLowerBound.a(this.b));
            return TreeRangeSet.SubRangeSetRangesByLowerBound.b(this.b).e(range.a) ? Maps.a(range.a, range) : b();
          }
        };
    }
    
    public NavigableMap<Cut<C>, Range<C>> a(Cut<C> param1Cut, boolean param1Boolean) {
      return a(Range.a(param1Cut, BoundType.a(param1Boolean)));
    }
    
    public NavigableMap<Cut<C>, Range<C>> a(Cut<C> param1Cut1, boolean param1Boolean1, Cut<C> param1Cut2, boolean param1Boolean2) {
      return a(Range.a(param1Cut1, BoundType.a(param1Boolean1), param1Cut2, BoundType.a(param1Boolean2)));
    }
    
    Iterator<Map.Entry<Cut<C>, Range<C>>> b() {
      Iterator iterator;
      if (this.b.k())
        return Iterators.a(); 
      if (this.a.b.a(this.b.a))
        return Iterators.a(); 
      boolean bool1 = this.a.a.a(this.b.a);
      boolean bool = false;
      if (bool1) {
        iterator = this.d.tailMap(this.b.a, false).values().iterator();
      } else {
        NavigableMap<Cut<C>, Range<C>> navigableMap = this.c;
        Cut cut = (Cut)this.a.a.c();
        if (this.a.g() == BoundType.b)
          bool = true; 
        iterator = navigableMap.tailMap(cut, bool).values().iterator();
      } 
      return new AbstractIterator<Map.Entry<Cut<C>, Range<C>>>(this, iterator, (Cut)Ordering.<Comparable>d().a(this.a.b, Cut.b(this.b.b))) {
          protected Map.Entry<Cut<C>, Range<C>> c() {
            if (!this.a.hasNext())
              return b(); 
            Range<C> range = this.a.next();
            if (this.b.a(range.a))
              return b(); 
            range = range.c(TreeRangeSet.SubRangeSetRangesByLowerBound.a(this.c));
            return Maps.a(range.a, range);
          }
        };
    }
    
    public NavigableMap<Cut<C>, Range<C>> b(Cut<C> param1Cut, boolean param1Boolean) {
      return a(Range.b(param1Cut, BoundType.a(param1Boolean)));
    }
    
    public Comparator<? super Cut<C>> comparator() {
      return Ordering.d();
    }
    
    public boolean containsKey(@NullableDecl Object param1Object) {
      return (a(param1Object) != null);
    }
    
    public int size() {
      return Iterators.b(b());
    }
  }
  
  class null extends AbstractIterator<Map.Entry<Cut<C>, Range<C>>> {
    null(TreeRangeSet this$0, Iterator param1Iterator, Cut param1Cut) {}
    
    protected Map.Entry<Cut<C>, Range<C>> c() {
      if (!this.a.hasNext())
        return b(); 
      Range<C> range = this.a.next();
      if (this.b.a(range.a))
        return b(); 
      range = range.c(TreeRangeSet.SubRangeSetRangesByLowerBound.a(this.c));
      return Maps.a(range.a, range);
    }
  }
  
  class null extends AbstractIterator<Map.Entry<Cut<C>, Range<C>>> {
    null(TreeRangeSet this$0, Iterator param1Iterator) {}
    
    protected Map.Entry<Cut<C>, Range<C>> c() {
      if (!this.a.hasNext())
        return b(); 
      Range<C> range = this.a.next();
      if ((TreeRangeSet.SubRangeSetRangesByLowerBound.a(this.b)).a.a(range.b) >= 0)
        return b(); 
      range = range.c(TreeRangeSet.SubRangeSetRangesByLowerBound.a(this.b));
      return TreeRangeSet.SubRangeSetRangesByLowerBound.b(this.b).e(range.a) ? Maps.a(range.a, range) : b();
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\common\collect\TreeRangeSet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */