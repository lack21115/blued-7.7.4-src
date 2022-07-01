package com.soft.blued.ui.msg_group.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.blued.android.core.net.IRequestHost;
import com.blued.das.message.MessageProtos;
import com.jeremyliao.liveeventbus.LiveEventBus;
import com.soft.blued.ui.find.adapter.RecommendListAdapter;
import com.soft.blued.ui.find.model.UserBasicModel;
import com.soft.blued.ui.msg.model.MsgSourceEntity;
import com.soft.blued.ui.msg_group.model.GroupMemberModel;
import com.soft.blued.ui.msg_group.utils.GroupUtil;
import com.soft.blued.ui.user.fragment.UserInfoFragmentNew;
import com.soft.blued.user.UserInfo;
import java.util.HashSet;
import java.util.Set;

public class GroupMemberAdapter extends RecommendListAdapter<GroupMemberModel> {
  public boolean b;
  
  public Set<String> c = new HashSet<String>();
  
  public int d = 3;
  
  public GroupMemberAdapter(Context paramContext, int paramInt1, int paramInt2, IRequestHost paramIRequestHost) {
    super(paramContext, paramInt1, paramIRequestHost);
    this.d = paramInt2;
  }
  
  public void a() {
    for (int i = 0; i < this.a.size(); i = j + 1) {
      int j = i;
      if (this.c.contains(((GroupMemberModel)this.a.get(i)).uid)) {
        this.a.remove(i);
        j = i - 1;
      } 
    } 
    this.c.clear();
    this.b = false;
    notifyDataSetChanged();
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup) {
    paramView = super.getView(paramInt, paramView, paramViewGroup);
    RecommendListAdapter.ViewHolder viewHolder = (RecommendListAdapter.ViewHolder)paramView.getTag();
    GroupMemberModel groupMemberModel = this.a.get(paramInt);
    GroupUtil.a(viewHolder.n, groupMemberModel.group_role);
    viewHolder.p.setVisibility(8);
    if (this.b) {
      viewHolder.o.setSelected(this.c.contains(groupMemberModel.uid));
      viewHolder.o.setVisibility(0);
      if ((this.d == 2 && groupMemberModel.group_role == 2) || groupMemberModel.uid.equals((UserInfo.a().i()).uid) || groupMemberModel.group_role == 1) {
        viewHolder.o.setVisibility(4);
      } else {
        viewHolder.o.setVisibility(0);
      } 
      viewHolder.o.setOnClickListener(new View.OnClickListener(this, viewHolder, groupMemberModel) {
            public void onClick(View param1View) {
              if (!this.a.o.isSelected()) {
                this.c.c.add(this.b.uid);
                this.a.o.setSelected(true);
                return;
              } 
              this.c.c.remove(this.b.uid);
              this.a.o.setSelected(false);
            }
          });
      paramView.setOnClickListener(new View.OnClickListener(this, viewHolder) {
            public void onClick(View param1View) {
              this.a.o.performClick();
            }
          });
      viewHolder.a.setOnClickListener(new View.OnClickListener(this, paramView, groupMemberModel, viewHolder) {
            public void onClick(View param1View) {
              UserInfoFragmentNew.a(this.a.getContext(), (UserBasicModel)this.b, "group_chatting", (View)this.c.a, null, new MsgSourceEntity(MessageProtos.StrangerSource.GROUP_CHAT, ""));
            }
          });
    } else {
      viewHolder.o.setSelected(false);
      viewHolder.o.setVisibility(8);
    } 
    paramView.setOnLongClickListener(new View.OnLongClickListener(this, groupMemberModel) {
          public boolean onLongClick(View param1View) {
            LiveEventBus.get("delete_member", GroupMemberModel.class).post(this.a);
            return true;
          }
        });
    return paramView;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\msg_group\adapter\GroupMemberAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */