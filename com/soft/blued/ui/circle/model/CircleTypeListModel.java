package com.soft.blued.ui.circle.model;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\000(\n\002\030\002\n\002\020\000\n\002\b\002\n\002\020 \n\002\030\002\n\002\b\005\n\002\020\013\n\002\b\005\n\002\020\b\n\002\b\b\030\0002\0020\001B\005¢\006\002\020\002R \020\003\032\b\022\004\022\0020\0050\004X\016¢\006\016\n\000\032\004\b\006\020\007\"\004\b\b\020\tR\032\020\n\032\0020\013X\016¢\006\016\n\000\032\004\b\f\020\r\"\004\b\016\020\017R\032\020\020\032\0020\021X\016¢\006\016\n\000\032\004\b\022\020\023\"\004\b\024\020\025R\032\020\026\032\0020\013X\016¢\006\016\n\000\032\004\b\027\020\r\"\004\b\030\020\017¨\006\031"}, d2 = {"Lcom/soft/blued/ui/circle/model/CircleTypeListModel;", "", "()V", "circleList", "", "Lcom/soft/blued/ui/circle/model/MyCircleModel;", "getCircleList", "()Ljava/util/List;", "setCircleList", "(Ljava/util/List;)V", "hasMore", "", "getHasMore", "()Z", "setHasMore", "(Z)V", "page", "", "getPage", "()I", "setPage", "(I)V", "success", "getSuccess", "setSuccess", "blued_app_a9999aRelease"}, k = 1, mv = {1, 1, 16})
public final class CircleTypeListModel {
  private List<? extends MyCircleModel> circleList = new ArrayList<MyCircleModel>();
  
  private boolean hasMore = true;
  
  private int page = 1;
  
  private boolean success;
  
  public final List<MyCircleModel> getCircleList() {
    return (List)this.circleList;
  }
  
  public final boolean getHasMore() {
    return this.hasMore;
  }
  
  public final int getPage() {
    return this.page;
  }
  
  public final boolean getSuccess() {
    return this.success;
  }
  
  public final void setCircleList(List<? extends MyCircleModel> paramList) {
    Intrinsics.b(paramList, "<set-?>");
    this.circleList = paramList;
  }
  
  public final void setHasMore(boolean paramBoolean) {
    this.hasMore = paramBoolean;
  }
  
  public final void setPage(int paramInt) {
    this.page = paramInt;
  }
  
  public final void setSuccess(boolean paramBoolean) {
    this.success = paramBoolean;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\circle\model\CircleTypeListModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */