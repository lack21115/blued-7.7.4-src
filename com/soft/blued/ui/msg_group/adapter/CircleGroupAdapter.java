package com.soft.blued.ui.msg_group.adapter;

import android.widget.ImageView;
import com.blued.android.core.net.IRequestHost;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.soft.blued.ui.msg_group.model.GroupInfoModel;
import com.soft.blued.ui.msg_group.utils.GroupUtil;
import java.util.List;

public class CircleGroupAdapter extends BaseQuickAdapter<GroupInfoModel, BaseViewHolder> {
  private IRequestHost a;
  
  public CircleGroupAdapter(List<GroupInfoModel> paramList, IRequestHost paramIRequestHost) {
    super(2131493482, paramList);
    this.a = paramIRequestHost;
  }
  
  protected void a(BaseViewHolder paramBaseViewHolder, GroupInfoModel paramGroupInfoModel) {
    boolean bool1;
    GroupUtil.b(this.a, paramGroupInfoModel.group_cover, (ImageView)paramBaseViewHolder.d(2131297797));
    int i = paramGroupInfoModel.group_role;
    boolean bool2 = true;
    if (i != 0) {
      bool1 = true;
    } else {
      bool1 = false;
    } 
    paramBaseViewHolder.b(2131296441, bool1);
    paramBaseViewHolder.a(2131300851, paramGroupInfoModel.group_title);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramGroupInfoModel.group_now_population);
    stringBuilder.append("/");
    stringBuilder.append(paramGroupInfoModel.group_max_population);
    BaseViewHolder baseViewHolder = paramBaseViewHolder.a(2131301032, stringBuilder.toString());
    if (paramGroupInfoModel.group_now_population == paramGroupInfoModel.group_max_population) {
      bool1 = bool2;
    } else {
      bool1 = false;
    } 
    baseViewHolder.b(2131300790, bool1);
    paramBaseViewHolder.c(2131301494);
    paramBaseViewHolder.c(2131297797);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\msg_group\adapter\CircleGroupAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */