package com.blued.android.module.yy_china.adapter;

import com.blued.android.module.yy_china.model.BlindPublishModel;
import com.blued.android.module.yy_china.model.YYImModel;
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.chad.library.adapter.base.entity.MultiItemEntity;
import java.util.List;
import java.util.Set;

public abstract class BaseConnectingAdapter<M extends MultiItemEntity, H extends BaseViewHolder> extends BaseMultiItemQuickAdapter<M, H> {
  public BaseConnectingAdapter(List<M> paramList) {
    super(paramList);
  }
  
  public abstract void a();
  
  public abstract void a(int paramInt1, int paramInt2, boolean paramBoolean);
  
  public abstract void a(int paramInt, String paramString1, String paramString2, YYImModel paramYYImModel);
  
  public abstract void a(String paramString1, String paramString2);
  
  public abstract void a(List<BlindPublishModel> paramList);
  
  public abstract void a(Set<String> paramSet);
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\blued\android\module\yy_china\adapter\BaseConnectingAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */