package androidx.recyclerview.widget;

import androidx.core.os.TraceCompat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.concurrent.TimeUnit;

final class GapWorker implements Runnable {
  static final ThreadLocal<GapWorker> a = new ThreadLocal<GapWorker>();
  
  static Comparator<Task> e = new Comparator<Task>() {
      public int compare(GapWorker.Task param1Task1, GapWorker.Task param1Task2) {
        byte b1;
        RecyclerView recyclerView = param1Task1.view;
        byte b2 = 1;
        if (recyclerView == null) {
          i = 1;
        } else {
          i = 0;
        } 
        if (param1Task2.view == null) {
          b1 = 1;
        } else {
          b1 = 0;
        } 
        if (i != b1)
          return (param1Task1.view == null) ? 1 : -1; 
        if (param1Task1.immediate != param1Task2.immediate) {
          i = b2;
          if (param1Task1.immediate)
            i = -1; 
          return i;
        } 
        int i = param1Task2.viewVelocity - param1Task1.viewVelocity;
        if (i != 0)
          return i; 
        i = param1Task1.distanceToItem - param1Task2.distanceToItem;
        return (i != 0) ? i : 0;
      }
    };
  
  ArrayList<RecyclerView> b = new ArrayList<RecyclerView>();
  
  long c;
  
  long d;
  
  private ArrayList<Task> f = new ArrayList<Task>();
  
  private RecyclerView.ViewHolder a(RecyclerView paramRecyclerView, int paramInt, long paramLong) {
    if (a(paramRecyclerView, paramInt))
      return null; 
    null = paramRecyclerView.e;
    try {
      paramRecyclerView.k();
      RecyclerView.ViewHolder viewHolder = null.a(paramInt, false, paramLong);
      if (viewHolder != null)
        if (viewHolder.l() && !viewHolder.j()) {
          null.recycleView(viewHolder.itemView);
        } else {
          null.a(viewHolder, false);
        }  
      return viewHolder;
    } finally {
      paramRecyclerView.b(false);
    } 
  }
  
  private void a() {
    int k = this.b.size();
    int i = 0;
    int j;
    for (j = 0; i < k; j = m) {
      RecyclerView recyclerView = this.b.get(i);
      int m = j;
      if (recyclerView.getWindowVisibility() == 0) {
        recyclerView.C.a(recyclerView, false);
        m = j + recyclerView.C.d;
      } 
      i++;
    } 
    this.f.ensureCapacity(j);
    j = 0;
    i = 0;
    while (j < k) {
      RecyclerView recyclerView = this.b.get(j);
      if (recyclerView.getWindowVisibility() == 0) {
        LayoutPrefetchRegistryImpl layoutPrefetchRegistryImpl = recyclerView.C;
        int n = Math.abs(layoutPrefetchRegistryImpl.a) + Math.abs(layoutPrefetchRegistryImpl.b);
        for (int m = 0; m < layoutPrefetchRegistryImpl.d * 2; m += 2) {
          boolean bool;
          Task task;
          if (i >= this.f.size()) {
            task = new Task();
            this.f.add(task);
          } else {
            task = this.f.get(i);
          } 
          int i1 = layoutPrefetchRegistryImpl.c[m + 1];
          if (i1 <= n) {
            bool = true;
          } else {
            bool = false;
          } 
          task.immediate = bool;
          task.viewVelocity = n;
          task.distanceToItem = i1;
          task.view = recyclerView;
          task.position = layoutPrefetchRegistryImpl.c[m];
          i++;
        } 
      } 
      j++;
    } 
    Collections.sort(this.f, e);
  }
  
  private void a(Task paramTask, long paramLong) {
    long l;
    if (paramTask.immediate) {
      l = Long.MAX_VALUE;
    } else {
      l = paramLong;
    } 
    RecyclerView.ViewHolder viewHolder = a(paramTask.view, paramTask.position, l);
    if (viewHolder != null && viewHolder.a != null && viewHolder.l() && !viewHolder.j())
      a(viewHolder.a.get(), paramLong); 
  }
  
  private void a(RecyclerView paramRecyclerView, long paramLong) {
    if (paramRecyclerView == null)
      return; 
    if (paramRecyclerView.x && paramRecyclerView.g.c() != 0)
      paramRecyclerView.c(); 
    LayoutPrefetchRegistryImpl layoutPrefetchRegistryImpl = paramRecyclerView.C;
    layoutPrefetchRegistryImpl.a(paramRecyclerView, true);
    if (layoutPrefetchRegistryImpl.d != 0)
      try {
        TraceCompat.beginSection("RV Nested Prefetch");
        paramRecyclerView.D.a(paramRecyclerView.m);
        int i;
        for (i = 0; i < layoutPrefetchRegistryImpl.d * 2; i += 2)
          a(paramRecyclerView, layoutPrefetchRegistryImpl.c[i], paramLong); 
        return;
      } finally {
        TraceCompat.endSection();
      }  
  }
  
  static boolean a(RecyclerView paramRecyclerView, int paramInt) {
    int j = paramRecyclerView.g.c();
    for (int i = 0; i < j; i++) {
      RecyclerView.ViewHolder viewHolder = RecyclerView.b(paramRecyclerView.g.d(i));
      if (viewHolder.b == paramInt && !viewHolder.j())
        return true; 
    } 
    return false;
  }
  
  private void b(long paramLong) {
    for (int i = 0; i < this.f.size(); i++) {
      Task task = this.f.get(i);
      if (task.view == null)
        return; 
      a(task, paramLong);
      task.clear();
    } 
  }
  
  void a(long paramLong) {
    a();
    b(paramLong);
  }
  
  void a(RecyclerView paramRecyclerView, int paramInt1, int paramInt2) {
    if (paramRecyclerView.isAttachedToWindow() && this.c == 0L) {
      this.c = paramRecyclerView.getNanoTime();
      paramRecyclerView.post(this);
    } 
    paramRecyclerView.C.a(paramInt1, paramInt2);
  }
  
  public void add(RecyclerView paramRecyclerView) {
    this.b.add(paramRecyclerView);
  }
  
  public void remove(RecyclerView paramRecyclerView) {
    this.b.remove(paramRecyclerView);
  }
  
  public void run() {
    try {
      TraceCompat.beginSection("RV Prefetch");
      boolean bool = this.b.isEmpty();
      if (!bool) {
        int j = this.b.size();
        int i = 0;
        long l;
        for (l = 0L; i < j; l = l1) {
          RecyclerView recyclerView = this.b.get(i);
          long l1 = l;
          if (recyclerView.getWindowVisibility() == 0)
            l1 = Math.max(recyclerView.getDrawingTime(), l); 
          i++;
        } 
        if (l != 0L) {
          a(TimeUnit.MILLISECONDS.toNanos(l) + this.d);
          return;
        } 
      } 
      return;
    } finally {
      this.c = 0L;
      TraceCompat.endSection();
    } 
  }
  
  static class LayoutPrefetchRegistryImpl implements RecyclerView.LayoutManager.LayoutPrefetchRegistry {
    int a;
    
    int b;
    
    int[] c;
    
    int d;
    
    void a() {
      int[] arrayOfInt = this.c;
      if (arrayOfInt != null)
        Arrays.fill(arrayOfInt, -1); 
      this.d = 0;
    }
    
    void a(int param1Int1, int param1Int2) {
      this.a = param1Int1;
      this.b = param1Int2;
    }
    
    void a(RecyclerView param1RecyclerView, boolean param1Boolean) {
      this.d = 0;
      int[] arrayOfInt = this.c;
      if (arrayOfInt != null)
        Arrays.fill(arrayOfInt, -1); 
      RecyclerView.LayoutManager layoutManager = param1RecyclerView.n;
      if (param1RecyclerView.m != null && layoutManager != null && layoutManager.isItemPrefetchEnabled()) {
        if (param1Boolean) {
          if (!param1RecyclerView.f.d())
            layoutManager.collectInitialPrefetchPositions(param1RecyclerView.m.getItemCount(), this); 
        } else if (!param1RecyclerView.hasPendingAdapterUpdates()) {
          layoutManager.collectAdjacentPrefetchPositions(this.a, this.b, param1RecyclerView.D, this);
        } 
        if (this.d > layoutManager.x) {
          layoutManager.x = this.d;
          layoutManager.y = param1Boolean;
          param1RecyclerView.e.a();
        } 
      } 
    }
    
    boolean a(int param1Int) {
      if (this.c != null) {
        int j = this.d;
        for (int i = 0; i < j * 2; i += 2) {
          if (this.c[i] == param1Int)
            return true; 
        } 
      } 
      return false;
    }
    
    public void addPosition(int param1Int1, int param1Int2) {
      if (param1Int1 >= 0) {
        if (param1Int2 >= 0) {
          int i = this.d * 2;
          int[] arrayOfInt = this.c;
          if (arrayOfInt == null) {
            this.c = new int[4];
            Arrays.fill(this.c, -1);
          } else if (i >= arrayOfInt.length) {
            this.c = new int[i * 2];
            System.arraycopy(arrayOfInt, 0, this.c, 0, arrayOfInt.length);
          } 
          arrayOfInt = this.c;
          arrayOfInt[i] = param1Int1;
          arrayOfInt[i + 1] = param1Int2;
          this.d++;
          return;
        } 
        throw new IllegalArgumentException("Pixel distance must be non-negative");
      } 
      throw new IllegalArgumentException("Layout positions must be non-negative");
    }
  }
  
  static class Task {
    public int distanceToItem;
    
    public boolean immediate;
    
    public int position;
    
    public RecyclerView view;
    
    public int viewVelocity;
    
    public void clear() {
      this.immediate = false;
      this.viewVelocity = 0;
      this.distanceToItem = 0;
      this.view = null;
      this.position = 0;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\androidx\recyclerview\widget\GapWorker.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */