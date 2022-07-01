package com.lxj.easyadapter;

import android.content.Context;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\000*\n\002\030\002\n\002\030\002\n\000\n\002\030\002\n\002\b\004\n\002\030\002\n\002\b\003\n\002\020\b\n\002\b\005\n\002\020\r\n\002\b\002\030\000 \0232\0020\001:\001\023B\r\022\006\020\002\032\0020\003¢\006\002\020\004J\035\020\t\032\002H\n\"\b\b\000\020\n*\0020\0032\006\020\013\032\0020\f¢\006\002\020\rJ\026\020\016\032\0020\0002\006\020\013\032\0020\f2\006\020\017\032\0020\fJ\026\020\020\032\0020\0002\006\020\013\032\0020\f2\006\020\021\032\0020\022R\021\020\002\032\0020\003¢\006\b\n\000\032\004\b\005\020\006R\024\020\007\032\b\022\004\022\0020\0030\bX\004¢\006\002\n\000¨\006\024"}, d2 = {"Lcom/lxj/easyadapter/ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "convertView", "Landroid/view/View;", "(Landroid/view/View;)V", "getConvertView", "()Landroid/view/View;", "mViews", "Landroid/util/SparseArray;", "getView", "T", "viewId", "", "(I)Landroid/view/View;", "setImageResource", "resId", "setText", "text", "", "Companion", "easy-adapter_release"}, k = 1, mv = {1, 1, 13})
public final class ViewHolder extends RecyclerView.ViewHolder {
  public static final Companion p = new Companion(null);
  
  private final SparseArray<View> q;
  
  private final View r;
  
  public ViewHolder(View paramView) {
    super(paramView);
    this.r = paramView;
    this.q = new SparseArray();
  }
  
  public final View w() {
    return this.r;
  }
  
  @Metadata(bv = {1, 0, 3}, d1 = {"\000*\n\002\030\002\n\002\020\000\n\002\b\002\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\000\n\002\020\b\n\000\n\002\030\002\n\000\b\003\030\0002\0020\001B\007\b\002¢\006\002\020\002J\036\020\003\032\0020\0042\006\020\005\032\0020\0062\006\020\007\032\0020\b2\006\020\t\032\0020\nJ\016\020\003\032\0020\0042\006\020\013\032\0020\f¨\006\r"}, d2 = {"Lcom/lxj/easyadapter/ViewHolder$Companion;", "", "()V", "createViewHolder", "Lcom/lxj/easyadapter/ViewHolder;", "context", "Landroid/content/Context;", "parent", "Landroid/view/ViewGroup;", "layoutId", "", "itemView", "Landroid/view/View;", "easy-adapter_release"}, k = 1, mv = {1, 1, 13})
  public static final class Companion {
    private Companion() {}
    
    public final ViewHolder a(Context param1Context, ViewGroup param1ViewGroup, int param1Int) {
      Intrinsics.b(param1Context, "context");
      Intrinsics.b(param1ViewGroup, "parent");
      View view = LayoutInflater.from(param1Context).inflate(param1Int, param1ViewGroup, false);
      Intrinsics.a(view, "itemView");
      return new ViewHolder(view);
    }
    
    public final ViewHolder a(View param1View) {
      Intrinsics.b(param1View, "itemView");
      return new ViewHolder(param1View);
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\lxj\easyadapter\ViewHolder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */