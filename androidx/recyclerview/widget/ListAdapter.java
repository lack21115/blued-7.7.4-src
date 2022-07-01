package androidx.recyclerview.widget;

import java.util.List;

public abstract class ListAdapter<T, VH extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<VH> {
  final AsyncListDiffer<T> a;
  
  public List<T> getCurrentList() {
    return this.a.getCurrentList();
  }
  
  public int getItemCount() {
    return this.a.getCurrentList().size();
  }
  
  public void onCurrentListChanged(List<T> paramList1, List<T> paramList2) {}
  
  public void submitList(List<T> paramList) {
    this.a.submitList(paramList);
  }
  
  public void submitList(List<T> paramList, Runnable paramRunnable) {
    this.a.submitList(paramList, paramRunnable);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\androidx\recyclerview\widget\ListAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */