package com.soft.blued.ui.msg_group.adapter;

import android.widget.ImageView;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.soft.blued.ui.msg_group.model.GroupInfoModel;
import com.soft.blued.ui.msg_group.utils.GroupUtil;

public class MyGroupAdapter extends BaseMultiItemQuickAdapter<GroupInfoModel, BaseViewHolder> {
  private IRequestHost a;
  
  public MyGroupAdapter(IRequestHost paramIRequestHost) {
    super(null);
    b(0, 2131493607);
    b(1, 2131493608);
    b(2, 2131493608);
    this.a = paramIRequestHost;
  }
  
  private void b(BaseViewHolder paramBaseViewHolder, GroupInfoModel paramGroupInfoModel) {
    if (paramGroupInfoModel.itemType == 2) {
      paramBaseViewHolder = paramBaseViewHolder.c(2131301277, true);
      String str = this.k.getResources().getString(2131756704);
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(paramGroupInfoModel.max_join);
      stringBuilder.append("");
      paramBaseViewHolder.a(2131301277, String.format(str, new Object[] { stringBuilder.toString() })).a(2131300947, this.k.getString(2131758167));
      return;
    } 
    paramBaseViewHolder.c(2131301277, false).a(2131300947, this.k.getString(2131758154));
  }
  
  private void c(BaseViewHolder paramBaseViewHolder, GroupInfoModel paramGroupInfoModel) {
    GroupUtil.b(this.a, paramGroupInfoModel.group_cover, (ImageView)paramBaseViewHolder.d(2131297797));
    GroupUtil.a((ShapeTextView)paramBaseViewHolder.d(2131300911), paramGroupInfoModel.group_role);
    paramBaseViewHolder = paramBaseViewHolder.a(2131301088, paramGroupInfoModel.group_title).a(2131300704, paramGroupInfoModel.group_desc);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramGroupInfoModel.group_now_population);
    stringBuilder.append("/");
    stringBuilder.append(paramGroupInfoModel.group_max_population);
    paramBaseViewHolder.a(2131301030, stringBuilder.toString());
  }
  
  protected void a(BaseViewHolder paramBaseViewHolder, GroupInfoModel paramGroupInfoModel) {
    if (paramGroupInfoModel.getItemType() == 0) {
      c(paramBaseViewHolder, paramGroupInfoModel);
      return;
    } 
    b(paramBaseViewHolder, paramGroupInfoModel);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\msg_group\adapter\MyGroupAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */