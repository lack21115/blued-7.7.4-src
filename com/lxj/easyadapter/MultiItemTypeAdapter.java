package com.lxj.easyadapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.collection.SparseArrayCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\000d\n\002\030\002\n\000\n\002\030\002\n\002\030\002\n\000\n\002\020 \n\002\b\005\n\002\020\b\n\002\b\005\n\002\030\002\n\002\030\002\n\002\b\002\n\002\030\002\n\002\b\005\n\002\030\002\n\002\b\007\n\002\020\002\n\002\b\004\n\002\030\002\n\002\b\t\n\002\020\013\n\002\b\004\n\002\030\002\n\002\b\003\n\002\030\002\n\002\b\f\b\026\030\000 D*\004\b\000\020\0012\b\022\004\022\0020\0030\002:\003DEFB\023\022\f\020\004\032\b\022\004\022\0028\0000\005¢\006\002\020\006J\016\020\"\032\0020#2\006\020$\032\0020\022J\016\020%\032\0020#2\006\020$\032\0020\022J\032\020&\032\b\022\004\022\0028\0000\0002\f\020'\032\b\022\004\022\0028\0000(J\"\020&\032\b\022\004\022\0028\0000\0002\006\020)\032\0020\0132\f\020'\032\b\022\004\022\0028\0000(J\033\020*\032\0020#2\006\020+\032\0020\0032\006\020,\032\0028\000¢\006\002\020-J\b\020.\032\0020\013H\026J\020\020/\032\0020\0132\006\0200\032\0020\013H\026J\020\0201\032\002022\006\020)\032\0020\013H\004J\020\0203\032\002022\006\0200\032\0020\013H\002J\020\0204\032\002022\006\0200\032\0020\013H\002J\020\0205\032\0020#2\006\0206\032\00207H\026J\030\0208\032\0020#2\006\020+\032\0020\0032\006\0200\032\0020\013H\026J\030\0209\032\0020\0032\006\020:\032\0020;2\006\020)\032\0020\013H\026J\020\020<\032\0020#2\006\020+\032\0020\003H\026J\026\020=\032\0020#2\006\020+\032\0020\0032\006\020>\032\0020\022J \020?\032\0020#2\006\020:\032\0020;2\006\020@\032\0020\0032\006\020)\032\0020\013H\004J\016\020A\032\0020#2\006\020B\032\0020\033J\b\020C\032\00202H\004R \020\004\032\b\022\004\022\0028\0000\005X\016¢\006\016\n\000\032\004\b\007\020\b\"\004\b\t\020\006R\021\020\n\032\0020\0138F¢\006\006\032\004\b\f\020\rR\021\020\016\032\0020\0138F¢\006\006\032\004\b\017\020\rR\024\020\020\032\b\022\004\022\0020\0220\021X\004¢\006\002\n\000R\024\020\023\032\b\022\004\022\0020\0220\021X\004¢\006\002\n\000R \020\024\032\b\022\004\022\0028\0000\025X\016¢\006\016\n\000\032\004\b\026\020\027\"\004\b\030\020\031R\034\020\032\032\004\030\0010\033X\016¢\006\016\n\000\032\004\b\034\020\035\"\004\b\036\020\037R\024\020 \032\0020\0138BX\004¢\006\006\032\004\b!\020\r¨\006G"}, d2 = {"Lcom/lxj/easyadapter/MultiItemTypeAdapter;", "T", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/lxj/easyadapter/ViewHolder;", "data", "", "(Ljava/util/List;)V", "getData", "()Ljava/util/List;", "setData", "footersCount", "", "getFootersCount", "()I", "headersCount", "getHeadersCount", "mFootViews", "Landroidx/collection/SparseArrayCompat;", "Landroid/view/View;", "mHeaderViews", "mItemDelegateManager", "Lcom/lxj/easyadapter/ItemDelegateManager;", "getMItemDelegateManager", "()Lcom/lxj/easyadapter/ItemDelegateManager;", "setMItemDelegateManager", "(Lcom/lxj/easyadapter/ItemDelegateManager;)V", "mOnItemClickListener", "Lcom/lxj/easyadapter/MultiItemTypeAdapter$OnItemClickListener;", "getMOnItemClickListener", "()Lcom/lxj/easyadapter/MultiItemTypeAdapter$OnItemClickListener;", "setMOnItemClickListener", "(Lcom/lxj/easyadapter/MultiItemTypeAdapter$OnItemClickListener;)V", "realItemCount", "getRealItemCount", "addFootView", "", "view", "addHeaderView", "addItemDelegate", "itemViewDelegate", "Lcom/lxj/easyadapter/ItemDelegate;", "viewType", "convert", "holder", "t", "(Lcom/lxj/easyadapter/ViewHolder;Ljava/lang/Object;)V", "getItemCount", "getItemViewType", "position", "isEnabled", "", "isFooterViewPos", "isHeaderViewPos", "onAttachedToRecyclerView", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "onBindViewHolder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "onViewAttachedToWindow", "onViewHolderCreated", "itemView", "setListener", "viewHolder", "setOnItemClickListener", "onItemClickListener", "useItemDelegateManager", "Companion", "OnItemClickListener", "SimpleOnItemClickListener", "easy-adapter_release"}, k = 1, mv = {1, 1, 13})
public class MultiItemTypeAdapter<T> extends RecyclerView.Adapter<ViewHolder> {
  public static final Companion a = new Companion(null);
  
  private final SparseArrayCompat<View> b;
  
  private final SparseArrayCompat<View> c;
  
  private ItemDelegateManager<T> d;
  
  private OnItemClickListener e;
  
  private List<? extends T> f;
  
  private final int a() {
    return getItemCount() - c() - d();
  }
  
  private final boolean b(int paramInt) {
    return (paramInt < c());
  }
  
  private final boolean c(int paramInt) {
    return (paramInt >= c() + a());
  }
  
  public ViewHolder a(ViewGroup paramViewGroup, int paramInt) {
    ViewHolder.Companion companion1;
    Intrinsics.b(paramViewGroup, "parent");
    if (this.b.get(paramInt) != null) {
      companion1 = ViewHolder.p;
      Object object = this.b.get(paramInt);
      if (object == null)
        Intrinsics.a(); 
      return companion1.a((View)object);
    } 
    if (this.c.get(paramInt) != null) {
      companion1 = ViewHolder.p;
      Object object = this.c.get(paramInt);
      if (object == null)
        Intrinsics.a(); 
      return companion1.a((View)object);
    } 
    int i = this.d.a(paramInt).a();
    ViewHolder.Companion companion2 = ViewHolder.p;
    Context context = companion1.getContext();
    Intrinsics.a(context, "parent.context");
    ViewHolder viewHolder = companion2.a(context, (ViewGroup)companion1, i);
    a(viewHolder, viewHolder.w());
    a((ViewGroup)companion1, viewHolder, paramInt);
    return viewHolder;
  }
  
  protected final void a(ViewGroup paramViewGroup, ViewHolder paramViewHolder, int paramInt) {
    Intrinsics.b(paramViewGroup, "parent");
    Intrinsics.b(paramViewHolder, "viewHolder");
    if (!a(paramInt))
      return; 
    paramViewHolder.w().setOnClickListener(new MultiItemTypeAdapter$setListener$1(this, paramViewHolder));
    paramViewHolder.w().setOnLongClickListener(new MultiItemTypeAdapter$setListener$2(this, paramViewHolder));
  }
  
  public void a(ViewHolder paramViewHolder) {
    Intrinsics.b(paramViewHolder, "holder");
    ViewHolder viewHolder = paramViewHolder;
    super.onViewAttachedToWindow(viewHolder);
    int i = paramViewHolder.getLayoutPosition();
    if (b(i) || c(i))
      WrapperUtils.a.a(viewHolder); 
  }
  
  public void a(ViewHolder paramViewHolder, int paramInt) {
    Intrinsics.b(paramViewHolder, "holder");
    if (b(paramInt))
      return; 
    if (c(paramInt))
      return; 
    a(paramViewHolder, this.f.get(paramInt - c()));
  }
  
  public final void a(ViewHolder paramViewHolder, View paramView) {
    Intrinsics.b(paramViewHolder, "holder");
    Intrinsics.b(paramView, "itemView");
  }
  
  public final void a(ViewHolder paramViewHolder, T paramT) {
    Intrinsics.b(paramViewHolder, "holder");
    this.d.a(paramViewHolder, paramT, paramViewHolder.getAdapterPosition() - c());
  }
  
  protected final boolean a(int paramInt) {
    return true;
  }
  
  protected final OnItemClickListener b() {
    return this.e;
  }
  
  public final int c() {
    return this.b.size();
  }
  
  public final int d() {
    return this.c.size();
  }
  
  protected final boolean e() {
    return (this.d.a() > 0);
  }
  
  public int getItemCount() {
    int i = this.f.size();
    return c() + d() + i;
  }
  
  public int getItemViewType(int paramInt) {
    return b(paramInt) ? this.b.keyAt(paramInt) : (c(paramInt) ? this.c.keyAt(paramInt - c() - a()) : (!e() ? super.getItemViewType(paramInt) : this.d.a(this.f.get(paramInt - c()), paramInt - c())));
  }
  
  public void onAttachedToRecyclerView(RecyclerView paramRecyclerView) {
    Intrinsics.b(paramRecyclerView, "recyclerView");
    super.onAttachedToRecyclerView(paramRecyclerView);
    WrapperUtils.a.a(paramRecyclerView, new MultiItemTypeAdapter$onAttachedToRecyclerView$1(this));
  }
  
  @Metadata(bv = {1, 0, 3}, d1 = {"\000\024\n\002\030\002\n\002\020\000\n\002\b\002\n\002\020\b\n\002\b\002\b\003\030\0002\0020\001B\007\b\002¢\006\002\020\002R\016\020\003\032\0020\004XT¢\006\002\n\000R\016\020\005\032\0020\004XT¢\006\002\n\000¨\006\006"}, d2 = {"Lcom/lxj/easyadapter/MultiItemTypeAdapter$Companion;", "", "()V", "BASE_ITEM_TYPE_FOOTER", "", "BASE_ITEM_TYPE_HEADER", "easy-adapter_release"}, k = 1, mv = {1, 1, 13})
  public static final class Companion {
    private Companion() {}
  }
  
  @Metadata(bv = {1, 0, 3}, d1 = {"\000(\n\002\030\002\n\002\020\000\n\000\n\002\020\002\n\000\n\002\030\002\n\000\n\002\030\002\n\000\n\002\020\b\n\000\n\002\020\013\n\000\bf\030\0002\0020\001J \020\002\032\0020\0032\006\020\004\032\0020\0052\006\020\006\032\0020\0072\006\020\b\032\0020\tH&J \020\n\032\0020\0132\006\020\004\032\0020\0052\006\020\006\032\0020\0072\006\020\b\032\0020\tH&¨\006\f"}, d2 = {"Lcom/lxj/easyadapter/MultiItemTypeAdapter$OnItemClickListener;", "", "onItemClick", "", "view", "Landroid/view/View;", "holder", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "position", "", "onItemLongClick", "", "easy-adapter_release"}, k = 1, mv = {1, 1, 13})
  public static interface OnItemClickListener {
    void a(View param1View, RecyclerView.ViewHolder param1ViewHolder, int param1Int);
    
    boolean b(View param1View, RecyclerView.ViewHolder param1ViewHolder, int param1Int);
  }
  
  @Metadata(bv = {1, 0, 3}, d1 = {"\000*\n\002\030\002\n\002\030\002\n\002\b\002\n\002\020\002\n\000\n\002\030\002\n\000\n\002\030\002\n\000\n\002\020\b\n\000\n\002\020\013\n\000\b\026\030\0002\0020\001B\005¢\006\002\020\002J \020\003\032\0020\0042\006\020\005\032\0020\0062\006\020\007\032\0020\b2\006\020\t\032\0020\nH\026J \020\013\032\0020\f2\006\020\005\032\0020\0062\006\020\007\032\0020\b2\006\020\t\032\0020\nH\026¨\006\r"}, d2 = {"Lcom/lxj/easyadapter/MultiItemTypeAdapter$SimpleOnItemClickListener;", "Lcom/lxj/easyadapter/MultiItemTypeAdapter$OnItemClickListener;", "()V", "onItemClick", "", "view", "Landroid/view/View;", "holder", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "position", "", "onItemLongClick", "", "easy-adapter_release"}, k = 1, mv = {1, 1, 13})
  public static class SimpleOnItemClickListener implements OnItemClickListener {
    public void a(View param1View, RecyclerView.ViewHolder param1ViewHolder, int param1Int) {
      Intrinsics.b(param1View, "view");
      Intrinsics.b(param1ViewHolder, "holder");
    }
    
    public boolean b(View param1View, RecyclerView.ViewHolder param1ViewHolder, int param1Int) {
      Intrinsics.b(param1View, "view");
      Intrinsics.b(param1ViewHolder, "holder");
      return false;
    }
  }
  
  @Metadata(bv = {1, 0, 3}, d1 = {"\000\030\n\000\n\002\020\b\n\002\b\002\n\002\030\002\n\000\n\002\030\002\n\002\b\002\020\000\032\0020\001\"\004\b\000\020\0022\006\020\003\032\0020\0042\006\020\005\032\0020\0062\006\020\007\032\0020\001H\n¢\006\002\b\b"}, d2 = {"<anonymous>", "", "T", "layoutManager", "Landroidx/recyclerview/widget/GridLayoutManager;", "oldLookup", "Landroidx/recyclerview/widget/GridLayoutManager$SpanSizeLookup;", "position", "invoke"}, k = 3, mv = {1, 1, 13})
  static final class MultiItemTypeAdapter$onAttachedToRecyclerView$1 extends Lambda implements Function3<GridLayoutManager, GridLayoutManager.SpanSizeLookup, Integer, Integer> {
    MultiItemTypeAdapter$onAttachedToRecyclerView$1(MultiItemTypeAdapter param1MultiItemTypeAdapter) {
      super(3);
    }
    
    public final int a(GridLayoutManager param1GridLayoutManager, GridLayoutManager.SpanSizeLookup param1SpanSizeLookup, int param1Int) {
      Intrinsics.b(param1GridLayoutManager, "layoutManager");
      Intrinsics.b(param1SpanSizeLookup, "oldLookup");
      int i = this.a.getItemViewType(param1Int);
      return (MultiItemTypeAdapter.a(this.a).get(i) != null) ? param1GridLayoutManager.getSpanCount() : ((MultiItemTypeAdapter.b(this.a).get(i) != null) ? param1GridLayoutManager.getSpanCount() : param1SpanSizeLookup.getSpanSize(param1Int));
    }
  }
  
  @Metadata(bv = {1, 0, 3}, d1 = {"\000\022\n\000\n\002\020\002\n\002\b\002\n\002\030\002\n\002\b\002\020\000\032\0020\001\"\004\b\000\020\0022\016\020\003\032\n \005*\004\030\0010\0040\004H\n¢\006\002\b\006"}, d2 = {"<anonymous>", "", "T", "v", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k = 3, mv = {1, 1, 13})
  static final class MultiItemTypeAdapter$setListener$1 implements View.OnClickListener {
    MultiItemTypeAdapter$setListener$1(MultiItemTypeAdapter param1MultiItemTypeAdapter, ViewHolder param1ViewHolder) {}
    
    public final void onClick(View param1View) {
      if (this.a.b() != null) {
        int i = this.b.getAdapterPosition();
        int j = this.a.c();
        MultiItemTypeAdapter.OnItemClickListener onItemClickListener = this.a.b();
        if (onItemClickListener == null)
          Intrinsics.a(); 
        Intrinsics.a(param1View, "v");
        onItemClickListener.a(param1View, this.b, i - j);
      } 
    }
  }
  
  @Metadata(bv = {1, 0, 3}, d1 = {"\000\022\n\000\n\002\020\013\n\002\b\002\n\002\030\002\n\002\b\002\020\000\032\0020\001\"\004\b\000\020\0022\016\020\003\032\n \005*\004\030\0010\0040\004H\n¢\006\002\b\006"}, d2 = {"<anonymous>", "", "T", "v", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onLongClick"}, k = 3, mv = {1, 1, 13})
  static final class MultiItemTypeAdapter$setListener$2 implements View.OnLongClickListener {
    MultiItemTypeAdapter$setListener$2(MultiItemTypeAdapter param1MultiItemTypeAdapter, ViewHolder param1ViewHolder) {}
    
    public final boolean onLongClick(View param1View) {
      if (this.a.b() != null) {
        int i = this.b.getAdapterPosition();
        int j = this.a.c();
        MultiItemTypeAdapter.OnItemClickListener onItemClickListener = this.a.b();
        if (onItemClickListener == null)
          Intrinsics.a(); 
        Intrinsics.a(param1View, "v");
        return onItemClickListener.b(param1View, this.b, i - j);
      } 
      return false;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\lxj\easyadapter\MultiItemTypeAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */