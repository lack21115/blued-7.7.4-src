package androidx.coordinatorlayout.widget;

import androidx.collection.SimpleArrayMap;
import androidx.core.util.Pools;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public final class DirectedAcyclicGraph<T> {
  private final Pools.Pool<ArrayList<T>> a = (Pools.Pool<ArrayList<T>>)new Pools.SimplePool(10);
  
  private final SimpleArrayMap<T, ArrayList<T>> b = new SimpleArrayMap();
  
  private final ArrayList<T> c = new ArrayList<T>();
  
  private final HashSet<T> d = new HashSet<T>();
  
  private ArrayList<T> a() {
    ArrayList<T> arrayList2 = (ArrayList)this.a.acquire();
    ArrayList<T> arrayList1 = arrayList2;
    if (arrayList2 == null)
      arrayList1 = new ArrayList(); 
    return arrayList1;
  }
  
  private void a(T paramT, ArrayList<T> paramArrayList, HashSet<T> paramHashSet) {
    if (paramArrayList.contains(paramT))
      return; 
    if (!paramHashSet.contains(paramT)) {
      paramHashSet.add(paramT);
      ArrayList<T> arrayList = (ArrayList)this.b.get(paramT);
      if (arrayList != null) {
        int i = 0;
        int j = arrayList.size();
        while (i < j) {
          a(arrayList.get(i), paramArrayList, paramHashSet);
          i++;
        } 
      } 
      paramHashSet.remove(paramT);
      paramArrayList.add(paramT);
      return;
    } 
    throw new RuntimeException("This graph contains cyclic dependencies");
  }
  
  private void a(ArrayList<T> paramArrayList) {
    paramArrayList.clear();
    this.a.release(paramArrayList);
  }
  
  public void addEdge(T paramT1, T paramT2) {
    if (this.b.containsKey(paramT1) && this.b.containsKey(paramT2)) {
      ArrayList<T> arrayList2 = (ArrayList)this.b.get(paramT1);
      ArrayList<T> arrayList1 = arrayList2;
      if (arrayList2 == null) {
        arrayList1 = a();
        this.b.put(paramT1, arrayList1);
      } 
      arrayList1.add(paramT2);
      return;
    } 
    throw new IllegalArgumentException("All nodes must be present in the graph before being added as an edge");
  }
  
  public void addNode(T paramT) {
    if (!this.b.containsKey(paramT))
      this.b.put(paramT, null); 
  }
  
  public void clear() {
    int j = this.b.size();
    for (int i = 0; i < j; i++) {
      ArrayList<T> arrayList = (ArrayList)this.b.valueAt(i);
      if (arrayList != null)
        a(arrayList); 
    } 
    this.b.clear();
  }
  
  public boolean contains(T paramT) {
    return this.b.containsKey(paramT);
  }
  
  public List getIncomingEdges(T paramT) {
    return (List)this.b.get(paramT);
  }
  
  public List<T> getOutgoingEdges(T paramT) {
    int j = this.b.size();
    ArrayList<Object> arrayList = null;
    int i = 0;
    while (i < j) {
      ArrayList arrayList2 = (ArrayList)this.b.valueAt(i);
      ArrayList<Object> arrayList1 = arrayList;
      if (arrayList2 != null) {
        arrayList1 = arrayList;
        if (arrayList2.contains(paramT)) {
          arrayList1 = arrayList;
          if (arrayList == null)
            arrayList1 = new ArrayList(); 
          arrayList1.add(this.b.keyAt(i));
        } 
      } 
      i++;
      arrayList = arrayList1;
    } 
    return arrayList;
  }
  
  public ArrayList<T> getSortedList() {
    this.c.clear();
    this.d.clear();
    int j = this.b.size();
    for (int i = 0; i < j; i++)
      a((T)this.b.keyAt(i), this.c, this.d); 
    return this.c;
  }
  
  public boolean hasOutgoingEdges(T paramT) {
    int j = this.b.size();
    for (int i = 0; i < j; i++) {
      ArrayList arrayList = (ArrayList)this.b.valueAt(i);
      if (arrayList != null && arrayList.contains(paramT))
        return true; 
    } 
    return false;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\androidx\coordinatorlayout\widget\DirectedAcyclicGraph.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */