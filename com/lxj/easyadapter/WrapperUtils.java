package com.lxj.easyadapter;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import kotlin.Metadata;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\000<\n\002\030\002\n\002\020\000\n\002\b\002\n\002\020\002\n\000\n\002\030\002\n\000\n\002\030\002\n\002\030\002\n\002\030\002\n\002\b\002\n\002\030\002\n\000\n\002\020\b\n\002\b\003\n\002\030\002\n\000\bÆ\002\030\0002\0020\001B\007\b\002¢\006\002\020\002J[\020\003\032\0020\0042\006\020\005\032\0020\0062K\020\007\032G\022\023\022\0210\t¢\006\f\b\n\022\b\b\013\022\004\b\b(\f\022\023\022\0210\r¢\006\f\b\n\022\b\b\013\022\004\b\b(\016\022\023\022\0210\017¢\006\f\b\n\022\b\b\013\022\004\b\b(\020\022\004\022\0020\0170\bJ\016\020\021\032\0020\0042\006\020\022\032\0020\023¨\006\024"}, d2 = {"Lcom/lxj/easyadapter/WrapperUtils;", "", "()V", "onAttachedToRecyclerView", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "fn", "Lkotlin/Function3;", "Landroidx/recyclerview/widget/GridLayoutManager;", "Lkotlin/ParameterName;", "name", "layoutManager", "Landroidx/recyclerview/widget/GridLayoutManager$SpanSizeLookup;", "oldLookup", "", "position", "setFullSpan", "holder", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "easy-adapter_release"}, k = 1, mv = {1, 1, 13})
public final class WrapperUtils {
  public static final WrapperUtils a = new WrapperUtils();
  
  public final void a(RecyclerView.ViewHolder paramViewHolder) {
    Intrinsics.b(paramViewHolder, "holder");
    View view = paramViewHolder.itemView;
    Intrinsics.a(view, "holder.itemView");
    ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
    if (layoutParams != null && layoutParams instanceof StaggeredGridLayoutManager.LayoutParams)
      ((StaggeredGridLayoutManager.LayoutParams)layoutParams).setFullSpan(true); 
  }
  
  public final void a(RecyclerView paramRecyclerView, Function3<? super GridLayoutManager, ? super GridLayoutManager.SpanSizeLookup, ? super Integer, Integer> paramFunction3) {
    Intrinsics.b(paramRecyclerView, "recyclerView");
    Intrinsics.b(paramFunction3, "fn");
    RecyclerView.LayoutManager layoutManager = paramRecyclerView.getLayoutManager();
    if (layoutManager instanceof GridLayoutManager) {
      GridLayoutManager gridLayoutManager = (GridLayoutManager)layoutManager;
      gridLayoutManager.setSpanSizeLookup(new WrapperUtils$onAttachedToRecyclerView$1(paramFunction3, layoutManager, gridLayoutManager.getSpanSizeLookup()));
      gridLayoutManager.setSpanCount(gridLayoutManager.getSpanCount());
    } 
  }
  
  @Metadata(bv = {1, 0, 3}, d1 = {"\000\023\n\000\n\002\030\002\n\000\n\002\020\b\n\002\b\002*\001\000\b\n\030\0002\0020\001J\020\020\002\032\0020\0032\006\020\004\032\0020\003H\026¨\006\005"}, d2 = {"com/lxj/easyadapter/WrapperUtils$onAttachedToRecyclerView$1", "Landroidx/recyclerview/widget/GridLayoutManager$SpanSizeLookup;", "getSpanSize", "", "position", "easy-adapter_release"}, k = 1, mv = {1, 1, 13})
  public static final class WrapperUtils$onAttachedToRecyclerView$1 extends GridLayoutManager.SpanSizeLookup {
    WrapperUtils$onAttachedToRecyclerView$1(Function3 param1Function3, RecyclerView.LayoutManager param1LayoutManager, GridLayoutManager.SpanSizeLookup param1SpanSizeLookup) {}
    
    public int getSpanSize(int param1Int) {
      Function3 function3 = this.c;
      RecyclerView.LayoutManager layoutManager = this.d;
      GridLayoutManager.SpanSizeLookup spanSizeLookup = this.e;
      Intrinsics.a(spanSizeLookup, "spanSizeLookup");
      return ((Number)function3.a(layoutManager, spanSizeLookup, Integer.valueOf(param1Int))).intValue();
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\lxj\easyadapter\WrapperUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */