package com.soft.blued.ui.msg_group.presenter;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import com.blued.android.core.AppInfo;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.ui.mvp.IFetchDataListener;
import com.blued.android.framework.ui.mvp.MvpPresenter;
import com.blued.android.module.common.utils.ToastUtils;
import com.jeremyliao.liveeventbus.LiveEventBus;
import com.soft.blued.http.MsgGroupHttpUtils;
import com.soft.blued.ui.find.model.UserBasicModel;
import com.soft.blued.ui.msg_group.fragment.SearchMemberFragment;
import com.soft.blued.ui.msg_group.model.GroupInfoModel;
import com.soft.blued.ui.msg_group.model.GroupMemberModel;
import java.util.ArrayList;
import java.util.List;

public class GroupManagerPresenter extends MvpPresenter {
  private GroupInfoModel h;
  
  private GroupMemberModel i;
  
  private void o() {
    GroupInfoModel groupInfoModel = this.h;
    if (groupInfoModel != null) {
      List<GroupMemberModel> list1;
      List<GroupMemberModel> list2 = groupInfoModel.admin;
      if (list2 == null) {
        list1 = new ArrayList();
      } else {
        list1 = list2;
        if (list2.size() > 0) {
          list1 = list2;
          if (((GroupMemberModel)list2.get(0)).group_role == 1) {
            this.i = list2.remove(0);
            list1 = list2;
          } 
        } 
      } 
      GroupMemberModel groupMemberModel = new GroupMemberModel();
      groupMemberModel.vbadge = 3;
      groupMemberModel.uid = "0";
      groupMemberModel.name = "添加管理员";
      if (list1.size() < this.h.group_max_admin && !list1.contains(groupMemberModel))
        list1.add(groupMemberModel); 
      a("group_info", this.h);
    } 
  }
  
  public void a(FragmentActivity paramFragmentActivity, Bundle paramBundle1, Bundle paramBundle2) {
    super.a(paramFragmentActivity, paramBundle1, paramBundle2);
    if (paramBundle1 != null) {
      this.h = (GroupInfoModel)paramBundle1.getSerializable("group_info");
      o();
    } 
  }
  
  public void a(IFetchDataListener paramIFetchDataListener) {}
  
  public void a(UserBasicModel paramUserBasicModel) {
    if (this.h != null && paramUserBasicModel != null && "0".equals(paramUserBasicModel.uid)) {
      Activity activity = h();
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(this.h.group_id);
      stringBuilder.append("");
      SearchMemberFragment.a((Context)activity, 0, stringBuilder.toString());
    } 
  }
  
  public void b(IFetchDataListener paramIFetchDataListener) {}
  
  public void d(String paramString) {
    if (this.h == null)
      return; 
    IRequestHost iRequestHost = g();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(this.h.group_id);
    stringBuilder.append("");
    MsgGroupHttpUtils.a(iRequestHost, stringBuilder.toString(), paramString, 3, new BluedUIHttpResponse<BluedEntityA>(this, g(), paramString) {
          protected void a(BluedEntityA param1BluedEntityA) {}
          
          public void onUIFinish(boolean param1Boolean) {
            this.b.b("cancelManager", param1Boolean);
            super.onUIFinish(param1Boolean);
            if (param1Boolean) {
              ToastUtils.a(AppInfo.d().getString(2131756644));
              if ((GroupManagerPresenter.a(this.b)).admin != null) {
                for (int i = 0; i < (GroupManagerPresenter.a(this.b)).admin.size(); i++) {
                  if (((GroupMemberModel)(GroupManagerPresenter.a(this.b)).admin.get(i)).uid.equals(this.a)) {
                    (GroupManagerPresenter.a(this.b)).admin.remove(i);
                    break;
                  } 
                } 
                GroupManagerPresenter.b(this.b);
              } 
            } 
          }
          
          public void onUIStart() {
            super.onUIStart();
            this.b.e_("cancelManager");
          }
        });
  }
  
  public GroupInfoModel m() {
    return this.h;
  }
  
  public void n() {
    GroupInfoModel groupInfoModel = this.h;
    if (groupInfoModel != null) {
      if (groupInfoModel.admin != null && this.h.admin.size() > 0) {
        if (((GroupMemberModel)this.h.admin.get(this.h.admin.size() - 1)).uid.equals("0"))
          this.h.admin.remove(this.h.admin.size() - 1); 
        if (this.i != null)
          this.h.admin.add(0, this.i); 
      } 
      LiveEventBus.get("refresh_manager_list", GroupInfoModel.class).post(this.h);
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\msg_group\presenter\GroupManagerPresenter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */