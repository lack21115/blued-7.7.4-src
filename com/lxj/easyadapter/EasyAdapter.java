package com.lxj.easyadapter;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\000(\n\002\030\002\n\000\n\002\030\002\n\000\n\002\020 \n\000\n\002\020\b\n\002\b\006\n\002\020\002\n\000\n\002\030\002\n\002\b\004\b&\030\000*\004\b\000\020\0012\b\022\004\022\002H\0010\002B\033\022\f\020\003\032\b\022\004\022\0028\0000\004\022\006\020\005\032\0020\006¢\006\002\020\007J%\020\f\032\0020\r2\006\020\016\032\0020\0172\006\020\020\032\0028\0002\006\020\021\032\0020\006H$¢\006\002\020\022R\032\020\005\032\0020\006X\016¢\006\016\n\000\032\004\b\b\020\t\"\004\b\n\020\013¨\006\023"}, d2 = {"Lcom/lxj/easyadapter/EasyAdapter;", "T", "Lcom/lxj/easyadapter/MultiItemTypeAdapter;", "data", "", "mLayoutId", "", "(Ljava/util/List;I)V", "getMLayoutId", "()I", "setMLayoutId", "(I)V", "bind", "", "holder", "Lcom/lxj/easyadapter/ViewHolder;", "t", "position", "(Lcom/lxj/easyadapter/ViewHolder;Ljava/lang/Object;I)V", "easy-adapter_release"}, k = 1, mv = {1, 1, 13})
public abstract class EasyAdapter<T> extends MultiItemTypeAdapter<T> {
  private int b;
  
  protected final int a() {
    return this.b;
  }
  
  protected abstract void a(ViewHolder paramViewHolder, T paramT, int paramInt);
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\lxj\easyadapter\EasyAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */