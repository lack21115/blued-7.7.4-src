package com.blued.android.module.common.adapter;

import android.content.Context;
import android.view.View;
import com.blued.android.module.common.model.BaseGiftModel;
import com.jeremyliao.liveeventbus.LiveEventBus;

public abstract class BaseGiftAdapter<T extends BaseGiftModel> extends CommonRecycleAdapter {
  protected int a;
  
  public BaseGiftAdapter(Context paramContext, int paramInt) {
    super(paramContext);
    this.a = paramInt;
  }
  
  protected abstract void a(BaseGiftModel paramBaseGiftModel, int paramInt, CommonRecycleAdapter.CommonAdapterHolder paramCommonAdapterHolder);
  
  protected void a(Object paramObject, int paramInt, CommonRecycleAdapter.CommonAdapterHolder paramCommonAdapterHolder) {
    paramObject = paramObject;
    a((BaseGiftModel)paramObject, paramInt, paramCommonAdapterHolder);
    paramCommonAdapterHolder.w().setOnClickListener(new -$$Lambda$BaseGiftAdapter$jnb8rtHZgT8vGq4vdLVuTumINJQ(this, paramCommonAdapterHolder, (BaseGiftModel)paramObject, paramInt));
  }
  
  protected boolean a(View paramView, BaseGiftModel paramBaseGiftModel, int paramInt) {
    return true;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\common\adapter\BaseGiftAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */