package com.soft.blued.ui.feed.adapter;

import android.content.Context;
import com.blued.android.core.utils.skin.BluedSkinUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.soft.blued.ui.msg.model.PositionPOIModel;
import java.util.Iterator;

public class FeedPostLocationAdapter extends BaseQuickAdapter<PositionPOIModel, BaseViewHolder> {
  private Context a;
  
  public FeedPostLocationAdapter(Context paramContext) {
    super(2131493514);
    this.a = paramContext;
  }
  
  protected void a(BaseViewHolder paramBaseViewHolder, PositionPOIModel paramPositionPOIModel) {
    paramBaseViewHolder.a(2131300474, paramPositionPOIModel.name);
    paramBaseViewHolder.a(2131300473, paramPositionPOIModel.address);
    if (paramPositionPOIModel.mark_visible) {
      paramBaseViewHolder.c(2131297665, true);
      paramBaseViewHolder.f(2131300474, BluedSkinUtils.a(this.a, 2131100716));
      paramBaseViewHolder.f(2131300473, BluedSkinUtils.a(this.a, 2131100716));
      return;
    } 
    paramBaseViewHolder.c(2131297665, false);
    paramBaseViewHolder.f(2131300474, BluedSkinUtils.a(this.a, 2131100838));
    paramBaseViewHolder.f(2131300473, BluedSkinUtils.a(this.a, 2131100842));
  }
  
  public boolean a() {
    Iterator iterator = this.n.iterator();
    while (iterator.hasNext()) {
      if (((PositionPOIModel)iterator.next()).mark_visible)
        return true; 
    } 
    return false;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\feed\adapter\FeedPostLocationAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */