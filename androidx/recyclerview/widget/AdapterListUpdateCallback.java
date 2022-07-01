package androidx.recyclerview.widget;

public final class AdapterListUpdateCallback implements ListUpdateCallback {
  private final RecyclerView.Adapter a;
  
  public AdapterListUpdateCallback(RecyclerView.Adapter paramAdapter) {
    this.a = paramAdapter;
  }
  
  public void onChanged(int paramInt1, int paramInt2, Object paramObject) {
    this.a.notifyItemRangeChanged(paramInt1, paramInt2, paramObject);
  }
  
  public void onInserted(int paramInt1, int paramInt2) {
    this.a.notifyItemRangeInserted(paramInt1, paramInt2);
  }
  
  public void onMoved(int paramInt1, int paramInt2) {
    this.a.notifyItemMoved(paramInt1, paramInt2);
  }
  
  public void onRemoved(int paramInt1, int paramInt2) {
    this.a.notifyItemRangeRemoved(paramInt1, paramInt2);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\androidx\recyclerview\widget\AdapterListUpdateCallback.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */