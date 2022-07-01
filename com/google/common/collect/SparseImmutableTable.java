package com.google.common.collect;

import com.google.errorprone.annotations.Immutable;
import java.util.LinkedHashMap;
import java.util.Map;

@Immutable(containerOf = {"R", "C", "V"})
final class SparseImmutableTable<R, C, V> extends RegularImmutableTable<R, C, V> {
  static final ImmutableTable<Object, Object, Object> a = new SparseImmutableTable(ImmutableList.d(), ImmutableSet.j(), ImmutableSet.j());
  
  private final ImmutableMap<R, ImmutableMap<C, V>> b;
  
  private final ImmutableMap<C, ImmutableMap<R, V>> c;
  
  private final int[] d;
  
  private final int[] e;
  
  SparseImmutableTable(ImmutableList<Table.Cell<R, C, V>> paramImmutableList, ImmutableSet<R> paramImmutableSet, ImmutableSet<C> paramImmutableSet1) {
    ImmutableMap<R, Integer> immutableMap = Maps.a(paramImmutableSet);
    LinkedHashMap<?, ?> linkedHashMap2 = Maps.d();
    UnmodifiableIterator<R> unmodifiableIterator = paramImmutableSet.av_();
    while (unmodifiableIterator.hasNext())
      linkedHashMap2.put(unmodifiableIterator.next(), new LinkedHashMap<Object, Object>()); 
    LinkedHashMap<?, ?> linkedHashMap1 = Maps.d();
    UnmodifiableIterator<C> unmodifiableIterator1 = paramImmutableSet1.av_();
    while (unmodifiableIterator1.hasNext())
      linkedHashMap1.put(unmodifiableIterator1.next(), new LinkedHashMap<Object, Object>()); 
    int[] arrayOfInt1 = new int[paramImmutableList.size()];
    int[] arrayOfInt2 = new int[paramImmutableList.size()];
    int i;
    for (i = 0; i < paramImmutableList.size(); i++) {
      Table.Cell cell = paramImmutableList.get(i);
      Object object1 = cell.a();
      Object object2 = cell.b();
      cell = (Table.Cell)cell.c();
      arrayOfInt1[i] = ((Integer)immutableMap.get(object1)).intValue();
      Map<Object, V> map = (Map)linkedHashMap2.get(object1);
      arrayOfInt2[i] = map.size();
      a((R)object1, (C)object2, map.put(object2, (V)cell), (V)cell);
      ((Map<Object, Table.Cell>)linkedHashMap1.get(object2)).put(object1, cell);
    } 
    this.d = arrayOfInt1;
    this.e = arrayOfInt2;
    ImmutableMap.Builder<Object, Object> builder = new ImmutableMap.Builder<Object, Object>(linkedHashMap2.size());
    for (Map.Entry<?, ?> entry : linkedHashMap2.entrySet())
      builder.b(entry.getKey(), ImmutableMap.a((Map<?, ?>)entry.getValue())); 
    this.b = (ImmutableMap)builder.b();
    builder = new ImmutableMap.Builder<Object, Object>(linkedHashMap1.size());
    for (Map.Entry<?, ?> entry : linkedHashMap1.entrySet())
      builder.b(entry.getKey(), ImmutableMap.a((Map<?, ?>)entry.getValue())); 
    this.c = (ImmutableMap)builder.b();
  }
  
  Table.Cell<R, C, V> a(int paramInt) {
    int i = this.d[paramInt];
    Map.Entry entry1 = this.b.l().h().get(i);
    ImmutableMap immutableMap = (ImmutableMap)entry1.getValue();
    paramInt = this.e[paramInt];
    Map.Entry entry2 = immutableMap.l().h().get(paramInt);
    return b((R)entry1.getKey(), (C)entry2.getKey(), (V)entry2.getValue());
  }
  
  V b(int paramInt) {
    int i = this.d[paramInt];
    ImmutableMap immutableMap = this.b.i().h().get(i);
    paramInt = this.e[paramInt];
    return immutableMap.i().h().get(paramInt);
  }
  
  public int k() {
    return this.d.length;
  }
  
  public ImmutableMap<C, Map<R, V>> l() {
    return ImmutableMap.a((Map)this.c);
  }
  
  public ImmutableMap<R, Map<C, V>> n() {
    return ImmutableMap.a((Map)this.b);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\common\collect\SparseImmutableTable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */