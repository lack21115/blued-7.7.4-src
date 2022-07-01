package com.soft.blued.ui.msg_group.adapter;

import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.TextView;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.soft.blued.ui.find.model.UserBasicModel;
import com.soft.blued.ui.msg_group.model.GroupMemberModel;
import com.soft.blued.ui.msg_group.utils.GroupUtil;
import com.soft.blued.utils.UserRelationshipUtils;
import java.util.List;

public class SearchMemberAdapter extends BaseQuickAdapter<GroupMemberModel, BaseViewHolder> {
  private IRequestHost a;
  
  private String b = "";
  
  public SearchMemberAdapter(IRequestHost paramIRequestHost) {
    super(2131493644);
    this.a = paramIRequestHost;
  }
  
  protected void a(BaseViewHolder paramBaseViewHolder, GroupMemberModel paramGroupMemberModel) {
    UserRelationshipUtils.a((ImageView)paramBaseViewHolder.d(2131297963), (UserBasicModel)paramGroupMemberModel);
    GroupUtil.a((TextView)paramBaseViewHolder.d(2131301088), (UserBasicModel)paramGroupMemberModel);
    UserRelationshipUtils.a(this.k, paramGroupMemberModel.name, this.b, (TextView)paramBaseViewHolder.d(2131301088));
    UserRelationshipUtils.a((ImageView)paramBaseViewHolder.d(2131297957), paramGroupMemberModel.vbadge, 3);
    GroupUtil.a(this.a, paramGroupMemberModel.avatar, (ImageView)paramBaseViewHolder.d(2131297797));
    GroupUtil.a((ShapeTextView)paramBaseViewHolder.d(2131300911), paramGroupMemberModel.group_role);
  }
  
  public void a(List<GroupMemberModel> paramList, String paramString) {
    this.b = paramString;
    if (TextUtils.isEmpty(paramString))
      this.b = ""; 
    c(paramList);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\msg_group\adapter\SearchMemberAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */