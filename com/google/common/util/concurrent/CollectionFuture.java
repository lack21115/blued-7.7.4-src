package com.google.common.util.concurrent;

import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

abstract class CollectionFuture<V, C> extends AggregateFuture<V, C> {
  private List<Present<V>> a;
  
  abstract C a(List<Present<V>> paramList);
  
  final void a() {
    List<Present<V>> list = this.a;
    if (list != null)
      set(a(list)); 
  }
  
  final void a(int paramInt, @NullableDecl V paramV) {
    List<Present<V>> list = this.a;
    if (list != null)
      list.set(paramInt, new Present<V>(paramV)); 
  }
  
  void a(AggregateFuture.ReleaseResourcesReason paramReleaseResourcesReason) {
    super.a(paramReleaseResourcesReason);
    this.a = null;
  }
  
  static final class ListFuture<V> extends CollectionFuture<V, List<V>> {
    public List<V> b(List<CollectionFuture.Present<V>> param1List) {
      ArrayList<CollectionFuture.Present> arrayList = Lists.b(param1List.size());
      for (CollectionFuture.Present<V> present : param1List) {
        if (present != null) {
          V v = present.a;
        } else {
          present = null;
        } 
        arrayList.add(present);
      } 
      return Collections.unmodifiableList((List)arrayList);
    }
  }
  
  static final class Present<V> {
    V a;
    
    Present(V param1V) {
      this.a = param1V;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\commo\\util\concurrent\CollectionFuture.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */