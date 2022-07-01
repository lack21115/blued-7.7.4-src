package com.soft.blued.ui.group;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import com.blued.android.chat.ChatManager;
import com.blued.android.chat.StableSessionListListener;
import com.blued.android.chat.listener.SessionListener;
import com.blued.android.chat.model.SessionModel;
import com.blued.android.core.AppMethods;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.framework.view.pulltorefresh.RenrenPullToRefreshListView;
import com.blued.android.module.common.observer.CommonTitleDoubleClickObserver;
import com.soft.blued.customview.NoDataAndLoadFailView;
import com.soft.blued.ui.group.adapter.BluedMyChatFriendListAdapter;
import com.soft.blued.ui.group.fragment.GroupInfoFragment;
import com.soft.blued.ui.msg.controller.tools.ChatHelperV4;
import com.soft.blued.ui.user.fragment.UserInfoFragmentNew;
import java.util.ArrayList;
import java.util.List;

public class GroupInviteFromChatListFragment extends BaseFragment implements View.OnClickListener, CommonTitleDoubleClickObserver.ITitleClickObserver {
  public static String f;
  
  public BluedMyChatFriendListAdapter d;
  
  public List<SessionModel> e = new ArrayList<SessionModel>();
  
  private RenrenPullToRefreshListView g;
  
  private ListView h;
  
  private int i = 1;
  
  private boolean j = true;
  
  private View k;
  
  private Context l;
  
  private NoDataAndLoadFailView m;
  
  private GroupInviteSessionListener n = new GroupInviteSessionListener();
  
  private void a(boolean paramBoolean) {
    if (paramBoolean)
      this.i = 1; 
    if (this.i == 1)
      this.j = true; 
    if (!this.j) {
      int i = this.i;
      if (i != 1) {
        this.i = i - 1;
        AppMethods.a(getResources().getString(2131756083));
      } 
    } 
  }
  
  private void l() {
    RenrenPullToRefreshListView renrenPullToRefreshListView = this.g;
    if (renrenPullToRefreshListView != null)
      renrenPullToRefreshListView.j(); 
  }
  
  public void a() {
    this.h.smoothScrollToPosition(0);
  }
  
  public void a(String paramString) {
    f = paramString;
  }
  
  public void k() {}
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public void onClick(View paramView) {}
  
  public void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
    this.l = (Context)getActivity();
    return this.k;
  }
  
  public void onDetach() {
    CommonTitleDoubleClickObserver.a().b(this);
    super.onDetach();
  }
  
  public void onStart() {
    super.onStart();
    ChatManager.getInstance().registerSessionListener((SessionListener)this.n);
    k();
  }
  
  public void onStop() {
    super.onStop();
    ChatManager.getInstance().unregisterSessionListener((SessionListener)this.n);
  }
  
  class GroupInviteSessionListener extends StableSessionListListener {
    private GroupInviteSessionListener(GroupInviteFromChatListFragment this$0) {}
    
    public void onUISessionDataChanged(List<SessionModel> param1List) {
      if (param1List == null) {
        param1List = new ArrayList<SessionModel>();
      } else {
        ChatHelperV4.b(param1List);
      } 
      GroupInviteFromChatListFragment groupInviteFromChatListFragment = this.a;
      groupInviteFromChatListFragment.e = param1List;
      groupInviteFromChatListFragment.d.notifyDataSetChanged();
      if (this.a.e.size() > 0) {
        if (GroupInviteFromChatListFragment.c(this.a) != null)
          GroupInviteFromChatListFragment.c(this.a).c(); 
      } else if (GroupInviteFromChatListFragment.c(this.a) != null) {
        GroupInviteFromChatListFragment.c(this.a).a();
      } 
      GroupInviteFromChatListFragment.d(this.a);
    }
  }
  
  class MyOnItemClickListener implements AdapterView.OnItemClickListener {
    public void onItemClick(AdapterView<?> param1AdapterView, View param1View, int param1Int, long param1Long) {
      if (param1Int >= 0) {
        if (param1Int > this.a.e.size())
          return; 
        List<SessionModel> list = this.a.e;
        if (((SessionModel)list.get(--param1Int)).sessionType == 2) {
          param1Long = ((SessionModel)this.a.e.get(param1Int)).sessionId;
          UserInfoFragmentNew.a(GroupInviteFromChatListFragment.b(this.a), String.valueOf(param1Long), "");
          return;
        } 
        if (((SessionModel)this.a.e.get(param1Int)).sessionType == 3)
          GroupInfoFragment.a(GroupInviteFromChatListFragment.b(this.a), String.valueOf(((SessionModel)this.a.e.get(param1Int)).sessionId)); 
      } 
    }
  }
  
  class MyPullDownListener implements RenrenPullToRefreshListView.OnPullDownListener {
    public void a() {
      GroupInviteFromChatListFragment.a(this.a, 1);
      GroupInviteFromChatListFragment.a(this.a, false);
    }
    
    public void b() {
      GroupInviteFromChatListFragment.a(this.a);
      GroupInviteFromChatListFragment.a(this.a, false);
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\group\GroupInviteFromChatListFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */