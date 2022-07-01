package com.soft.blued.ui.msg_group.adapter;

import android.widget.ImageView;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.soft.blued.ui.msg_group.model.GroupMemberModel;
import com.soft.blued.ui.msg_group.utils.GroupUtil;
import java.util.List;

public class GroupManagerAdapter extends BaseQuickAdapter<GroupMemberModel, BaseViewHolder> {
  private IRequestHost a;
  
  public GroupManagerAdapter(List<GroupMemberModel> paramList, IRequestHost paramIRequestHost) {
    super(2131493537, paramList);
    this.a = paramIRequestHost;
  }
  
  protected void a(BaseViewHolder paramBaseViewHolder, GroupMemberModel paramGroupMemberModel) {
    ShapeTextView shapeTextView = (ShapeTextView)paramBaseViewHolder.d(2131300911);
    GroupUtil.a(this.a, paramGroupMemberModel.avatar, (ImageView)paramBaseViewHolder.d(2131297804));
    GroupUtil.a(shapeTextView, paramGroupMemberModel.group_role);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\msg_group\adapter\GroupManagerAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */