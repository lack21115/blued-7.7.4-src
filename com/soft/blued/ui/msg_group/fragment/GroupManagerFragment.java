package com.soft.blued.ui.msg_group.fragment;

import android.os.Bundle;
import android.view.View;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.ui.mvp.MvpFragment;
import com.blued.das.message.MessageProtos;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.jeremyliao.liveeventbus.LiveEventBus;
import com.soft.blued.customview.CommonTopTitleNoTrans;
import com.soft.blued.ui.find.model.UserBasicModel;
import com.soft.blued.ui.msg.customview.TranslationAnimHintView;
import com.soft.blued.ui.msg.model.MsgSourceEntity;
import com.soft.blued.ui.msg_group.adapter.GroupManagerDetailAdapter;
import com.soft.blued.ui.msg_group.model.GroupInfoModel;
import com.soft.blued.ui.msg_group.model.GroupMemberModel;
import com.soft.blued.ui.msg_group.presenter.GroupManagerPresenter;
import com.soft.blued.ui.user.fragment.UserInfoFragmentNew;
import com.soft.blued.utils.RecyclerViewAnimUtil;

public class GroupManagerFragment extends MvpFragment<GroupManagerPresenter> {
  @BindView(2131296424)
  RecyclerView admin_list;
  
  private GroupManagerDetailAdapter d;
  
  @BindView(2131297374)
  TranslationAnimHintView hintView;
  
  @BindView(2131300273)
  CommonTopTitleNoTrans title;
  
  private void k() {
    LiveEventBus.get("set_manager", GroupMemberModel.class).observe((LifecycleOwner)this, new Observer<GroupMemberModel>(this) {
          public void a(GroupMemberModel param1GroupMemberModel) {
            if (((GroupManagerPresenter)this.a.s()).m() != null && GroupManagerFragment.a(this.a) != null && GroupManagerFragment.a(this.a).getItemCount() > 0) {
              if (GroupManagerFragment.a(this.a).n().size() == (((GroupManagerPresenter)this.a.s()).m()).group_max_admin) {
                GroupManagerFragment.a(this.a).n().set(GroupManagerFragment.a(this.a).getItemCount() - 1, param1GroupMemberModel);
              } else {
                GroupManagerFragment.a(this.a).n().add(GroupManagerFragment.a(this.a).getItemCount() - 1, param1GroupMemberModel);
              } 
              GroupManagerFragment.a(this.a).notifyDataSetChanged();
            } 
          }
        });
  }
  
  public void a(Bundle paramBundle) {
    super.a(paramBundle);
    this.title.setCenterText(getString(2131756625));
    this.title.setLeftClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            this.a.C();
          }
        });
    k();
  }
  
  public void a(GroupInfoModel paramGroupInfoModel) {
    if (paramGroupInfoModel != null) {
      TranslationAnimHintView.HintInfo hintInfo = new TranslationAnimHintView.HintInfo();
      hintInfo.a = 11;
      String str = getString(2131756703);
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(paramGroupInfoModel.group_max_admin);
      stringBuilder.append("");
      hintInfo.b = String.format(str, new Object[] { stringBuilder.toString() });
      this.hintView.a(hintInfo);
      RecyclerViewAnimUtil.a(this.admin_list);
      this.d = new GroupManagerDetailAdapter(paramGroupInfoModel.admin, (IRequestHost)w_());
      this.admin_list.setLayoutManager((RecyclerView.LayoutManager)new LinearLayoutManager(getContext()));
      this.admin_list.setAdapter((RecyclerView.Adapter)this.d);
      this.d.a(new BaseQuickAdapter.OnItemClickListener(this) {
            public void onItemClick(BaseQuickAdapter param1BaseQuickAdapter, View param1View, int param1Int) {
              ((GroupManagerPresenter)this.a.s()).a(param1BaseQuickAdapter.n().get(param1Int));
            }
          });
      this.d.a(new BaseQuickAdapter.OnItemChildClickListener(this) {
            public void onItemChildClick(BaseQuickAdapter param1BaseQuickAdapter, View param1View, int param1Int) {
              UserBasicModel userBasicModel = param1BaseQuickAdapter.n().get(param1Int);
              int i = param1View.getId();
              if (i != 2131296638) {
                if (i != 2131297804)
                  return; 
                if (!"0".equals(userBasicModel.uid)) {
                  UserInfoFragmentNew.a(this.a.getContext(), param1BaseQuickAdapter.n().get(param1Int), "group_chatting", param1View, null, new MsgSourceEntity(MessageProtos.StrangerSource.UNKNOWN_STRANGER_SOURCE, ""));
                  return;
                } 
                ((GroupManagerPresenter)this.a.s()).a(param1BaseQuickAdapter.n().get(param1Int));
                return;
              } 
              ((GroupManagerPresenter)this.a.s()).d(userBasicModel.uid);
            }
          });
    } 
  }
  
  public void onDestroy() {
    super.onDestroy();
    ((GroupManagerPresenter)s()).n();
  }
  
  public int p() {
    return 2131493057;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\msg_group\fragment\GroupManagerFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */