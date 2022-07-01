package androidx.recyclerview.widget;

import android.os.Handler;
import android.os.Looper;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;

public class AsyncListDiffer<T> {
  private static final Executor e = new MainThreadExecutor();
  
  final AsyncDifferConfig<T> a;
  
  Executor b;
  
  int c;
  
  private final ListUpdateCallback d;
  
  private final List<ListListener<T>> f = new CopyOnWriteArrayList<ListListener<T>>();
  
  private List<T> g;
  
  private List<T> h = Collections.emptyList();
  
  public AsyncListDiffer(ListUpdateCallback paramListUpdateCallback, AsyncDifferConfig<T> paramAsyncDifferConfig) {
    this.d = paramListUpdateCallback;
    this.a = paramAsyncDifferConfig;
    if (paramAsyncDifferConfig.getMainThreadExecutor() != null) {
      this.b = paramAsyncDifferConfig.getMainThreadExecutor();
      return;
    } 
    this.b = e;
  }
  
  public AsyncListDiffer(RecyclerView.Adapter paramAdapter, DiffUtil.ItemCallback<T> paramItemCallback) {
    this(new AdapterListUpdateCallback(paramAdapter), (new AsyncDifferConfig.Builder<T>(paramItemCallback)).build());
  }
  
  private void a(List<T> paramList, Runnable paramRunnable) {
    Iterator<ListListener<T>> iterator = this.f.iterator();
    while (iterator.hasNext())
      ((ListListener<T>)iterator.next()).onCurrentListChanged(paramList, this.h); 
    if (paramRunnable != null)
      paramRunnable.run(); 
  }
  
  void a(List<T> paramList, DiffUtil.DiffResult paramDiffResult, Runnable paramRunnable) {
    List<T> list = this.h;
    this.g = paramList;
    this.h = Collections.unmodifiableList(paramList);
    paramDiffResult.dispatchUpdatesTo(this.d);
    a(list, paramRunnable);
  }
  
  public void addListListener(ListListener<T> paramListListener) {
    this.f.add(paramListListener);
  }
  
  public List<T> getCurrentList() {
    return this.h;
  }
  
  public void removeListListener(ListListener<T> paramListListener) {
    this.f.remove(paramListListener);
  }
  
  public void submitList(List<T> paramList) {
    submitList(paramList, null);
  }
  
  public void submitList(List<T> paramList, Runnable paramRunnable) {
    int i = this.c + 1;
    this.c = i;
    List<T> list1 = this.g;
    if (paramList == list1) {
      if (paramRunnable != null)
        paramRunnable.run(); 
      return;
    } 
    List<T> list2 = this.h;
    if (paramList == null) {
      i = list1.size();
      this.g = null;
      this.h = Collections.emptyList();
      this.d.onRemoved(0, i);
      a(list2, paramRunnable);
      return;
    } 
    if (list1 == null) {
      this.g = paramList;
      this.h = Collections.unmodifiableList(paramList);
      this.d.onInserted(0, paramList.size());
      a(list2, paramRunnable);
      return;
    } 
    this.a.getBackgroundThreadExecutor().execute(new Runnable(this, list1, paramList, i, paramRunnable) {
          public void run() {
            DiffUtil.DiffResult diffResult = DiffUtil.calculateDiff(new DiffUtil.Callback(this) {
                  public boolean areContentsTheSame(int param2Int1, int param2Int2) {
                    Object object1 = this.a.a.get(param2Int1);
                    Object object2 = this.a.b.get(param2Int2);
                    if (object1 != null && object2 != null)
                      return this.a.e.a.getDiffCallback().areContentsTheSame(object1, object2); 
                    if (object1 == null && object2 == null)
                      return true; 
                    throw new AssertionError();
                  }
                  
                  public boolean areItemsTheSame(int param2Int1, int param2Int2) {
                    Object object1 = this.a.a.get(param2Int1);
                    Object object2 = this.a.b.get(param2Int2);
                    return (object1 != null && object2 != null) ? this.a.e.a.getDiffCallback().areItemsTheSame(object1, object2) : ((object1 == null && object2 == null));
                  }
                  
                  public Object getChangePayload(int param2Int1, int param2Int2) {
                    Object object1 = this.a.a.get(param2Int1);
                    Object object2 = this.a.b.get(param2Int2);
                    if (object1 != null && object2 != null)
                      return this.a.e.a.getDiffCallback().getChangePayload(object1, object2); 
                    throw new AssertionError();
                  }
                  
                  public int getNewListSize() {
                    return this.a.b.size();
                  }
                  
                  public int getOldListSize() {
                    return this.a.a.size();
                  }
                });
            this.e.b.execute(new Runnable(this, diffResult) {
                  public void run() {
                    if (this.b.e.c == this.b.c)
                      this.b.e.a(this.b.b, this.a, this.b.d); 
                  }
                });
          }
        });
  }
  
  public static interface ListListener<T> {
    void onCurrentListChanged(List<T> param1List1, List<T> param1List2);
  }
  
  static class MainThreadExecutor implements Executor {
    final Handler a = new Handler(Looper.getMainLooper());
    
    public void execute(Runnable param1Runnable) {
      this.a.post(param1Runnable);
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\androidx\recyclerview\widget\AsyncListDiffer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */