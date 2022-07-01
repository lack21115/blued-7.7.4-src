package com.lxj.easyadapter;

import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\000*\n\002\030\002\n\000\n\002\020\000\n\000\n\002\020\b\n\002\b\003\n\002\020\002\n\000\n\002\030\002\n\002\b\004\n\002\020\013\n\002\b\003\bf\030\000*\004\b\000\020\0012\0020\002J%\020\007\032\0020\b2\006\020\t\032\0020\n2\006\020\013\032\0028\0002\006\020\f\032\0020\004H&¢\006\002\020\rJ\035\020\016\032\0020\0172\006\020\020\032\0028\0002\006\020\f\032\0020\004H&¢\006\002\020\021R\022\020\003\032\0020\004X¦\004¢\006\006\032\004\b\005\020\006¨\006\022"}, d2 = {"Lcom/lxj/easyadapter/ItemDelegate;", "T", "", "layoutId", "", "getLayoutId", "()I", "bind", "", "holder", "Lcom/lxj/easyadapter/ViewHolder;", "t", "position", "(Lcom/lxj/easyadapter/ViewHolder;Ljava/lang/Object;I)V", "isThisType", "", "item", "(Ljava/lang/Object;I)Z", "easy-adapter_release"}, k = 1, mv = {1, 1, 13})
public interface ItemDelegate<T> {
  int a();
  
  void a(ViewHolder paramViewHolder, T paramT, int paramInt);
  
  boolean a(T paramT, int paramInt);
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\lxj\easyadapter\ItemDelegate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */