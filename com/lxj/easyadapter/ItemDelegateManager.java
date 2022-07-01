package com.lxj.easyadapter;

import androidx.collection.SparseArrayCompat;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\000.\n\002\030\002\n\000\n\002\020\000\n\002\b\002\n\002\030\002\n\002\030\002\n\000\n\002\020\b\n\002\b\006\n\002\020\002\n\000\n\002\030\002\n\002\b\013\030\000*\004\b\000\020\0012\0020\002B\005¢\006\002\020\003J\032\020\013\032\b\022\004\022\0028\0000\0002\f\020\f\032\b\022\004\022\0028\0000\006J\"\020\013\032\b\022\004\022\0028\0000\0002\006\020\r\032\0020\b2\f\020\f\032\b\022\004\022\0028\0000\006J#\020\016\032\0020\0172\006\020\020\032\0020\0212\006\020\022\032\0028\0002\006\020\023\032\0020\b¢\006\002\020\024J\016\020\025\032\0020\b2\006\020\r\032\0020\bJ\024\020\026\032\b\022\004\022\0028\0000\0062\006\020\r\032\0020\bJ\033\020\027\032\0020\b2\006\020\022\032\0028\0002\006\020\023\032\0020\b¢\006\002\020\030J\024\020\027\032\0020\b2\f\020\031\032\b\022\004\022\0028\0000\006J\032\020\032\032\b\022\004\022\0028\0000\0002\f\020\f\032\b\022\004\022\0028\0000\006J\024\020\032\032\b\022\004\022\0028\0000\0002\006\020\033\032\0020\bR\032\020\004\032\016\022\n\022\b\022\004\022\0028\0000\0060\005X\016¢\006\002\n\000R\021\020\007\032\0020\b8F¢\006\006\032\004\b\t\020\n¨\006\034"}, d2 = {"Lcom/lxj/easyadapter/ItemDelegateManager;", "T", "", "()V", "delegates", "Landroidx/collection/SparseArrayCompat;", "Lcom/lxj/easyadapter/ItemDelegate;", "itemViewDelegateCount", "", "getItemViewDelegateCount", "()I", "addDelegate", "delegate", "viewType", "convert", "", "holder", "Lcom/lxj/easyadapter/ViewHolder;", "item", "position", "(Lcom/lxj/easyadapter/ViewHolder;Ljava/lang/Object;I)V", "getItemLayoutId", "getItemViewDelegate", "getItemViewType", "(Ljava/lang/Object;I)I", "itemViewDelegate", "removeDelegate", "itemType", "easy-adapter_release"}, k = 1, mv = {1, 1, 13})
public final class ItemDelegateManager<T> {
  private SparseArrayCompat<ItemDelegate<T>> a = new SparseArrayCompat();
  
  public final int a() {
    return this.a.size();
  }
  
  public final int a(T paramT, int paramInt) {
    for (int i = this.a.size() - 1; i >= 0; i--) {
      if (((ItemDelegate<T>)this.a.valueAt(i)).a(paramT, paramInt))
        return this.a.keyAt(i); 
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("No ItemDelegate added that matches position=");
    stringBuilder.append(paramInt);
    stringBuilder.append(" in data source");
    throw (Throwable)new IllegalArgumentException(stringBuilder.toString());
  }
  
  public final ItemDelegate<T> a(int paramInt) {
    Object object = this.a.get(paramInt);
    if (object == null)
      Intrinsics.a(); 
    return (ItemDelegate<T>)object;
  }
  
  public final void a(ViewHolder paramViewHolder, T paramT, int paramInt) {
    Intrinsics.b(paramViewHolder, "holder");
    int j = this.a.size();
    int i;
    for (i = 0; i < j; i++) {
      ItemDelegate<T> itemDelegate = (ItemDelegate)this.a.valueAt(i);
      if (itemDelegate.a(paramT, paramInt)) {
        itemDelegate.a(paramViewHolder, paramT, paramInt);
        return;
      } 
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("No ItemDelegateManager added that matches position=");
    stringBuilder.append(paramInt);
    stringBuilder.append(" in data source");
    throw (Throwable)new IllegalArgumentException(stringBuilder.toString());
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\lxj\easyadapter\ItemDelegateManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */