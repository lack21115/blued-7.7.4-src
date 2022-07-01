package com.soft.blued.ui.group;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.blued.android.core.AppMethods;
import com.blued.android.core.BlueAppLocal;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.view.pulltorefresh.RenrenPullToRefreshListView;
import com.blued.android.module.common.observer.CommonTitleDoubleClickObserver;
import com.soft.blued.customview.NoDataAndLoadFailView;
import com.soft.blued.http.MineHttpUtils;
import com.soft.blued.ui.find.adapter.PeopleGridQuickAdapter;
import com.soft.blued.ui.find.model.FilterEntity;
import com.soft.blued.ui.group.adapter.GroupUserInviteAdapter;
import com.soft.blued.ui.group.model.BluedUserInviteList;
import com.soft.blued.user.UserInfo;
import com.soft.blued.utils.BluedPreferences;
import com.soft.blued.utils.StringUtils;
import java.util.ArrayList;
import java.util.List;

public class GroupUserInviteFragment extends BaseFragment implements View.OnClickListener, CommonTitleDoubleClickObserver.ITitleClickObserver {
  public GroupUserInviteAdapter d;
  
  public BluedUIHttpResponse e = new BluedUIHttpResponse<BluedEntityA<BluedUserInviteList>>(this) {
      boolean a;
      
      protected void a(BluedEntityA<BluedUserInviteList> param1BluedEntityA) {
        try {
          if (param1BluedEntityA.hasData()) {
            if (param1BluedEntityA.hasMore()) {
              GroupUserInviteFragment.b(this.b, true);
              GroupUserInviteFragment.b(this.b).o();
            } else {
              GroupUserInviteFragment.b(this.b, false);
              GroupUserInviteFragment.b(this.b).p();
            } 
            if (GroupUserInviteFragment.c(this.b) == 1)
              GroupUserInviteFragment.d(this.b).clear(); 
            GroupUserInviteFragment.d(this.b).addAll(param1BluedEntityA.data);
            for (int i = 0; i < GroupUserInviteFragment.d(this.b).size(); i++) {
              ((BluedUserInviteList)GroupUserInviteFragment.d(this.b).get(i)).height = StringUtils.a(((BluedUserInviteList)GroupUserInviteFragment.d(this.b).get(i)).height, BlueAppLocal.c(), false);
              ((BluedUserInviteList)GroupUserInviteFragment.d(this.b).get(i)).weight = StringUtils.b(((BluedUserInviteList)GroupUserInviteFragment.d(this.b).get(i)).weight, BlueAppLocal.c(), false);
            } 
            this.b.d.notifyDataSetChanged();
            return;
          } 
          if (GroupUserInviteFragment.c(this.b) == 1) {
            GroupUserInviteFragment.d(this.b).clear();
            this.b.d.notifyDataSetChanged();
          } 
          if (GroupUserInviteFragment.c(this.b) != 1)
            GroupUserInviteFragment.e(this.b); 
          GroupUserInviteFragment.b(this.b).p();
          return;
        } catch (Exception exception) {
          this.a = true;
          exception.printStackTrace();
          return;
        } 
      }
      
      public boolean onUIFailure(int param1Int, String param1String) {
        this.a = true;
        return super.onUIFailure(param1Int, param1String);
      }
      
      public void onUIFinish() {
        super.onUIFinish();
        GroupUserInviteFragment.b(this.b).j();
        GroupUserInviteFragment.b(this.b).q();
        if (this.b.d.getCount() == 0) {
          if (this.a) {
            this.a = false;
            GroupUserInviteFragment.f(this.b).b();
            return;
          } 
          GroupUserInviteFragment.f(this.b).a();
          return;
        } 
        GroupUserInviteFragment.f(this.b).c();
      }
    };
  
  private RenrenPullToRefreshListView f;
  
  private NoDataAndLoadFailView g;
  
  private ListView h;
  
  private List<BluedUserInviteList> i;
  
  private int j = 1;
  
  private int k = 10;
  
  private boolean l = true;
  
  private View m;
  
  private Context n;
  
  private int o;
  
  public static GroupUserInviteFragment a(int paramInt) {
    GroupUserInviteFragment groupUserInviteFragment = new GroupUserInviteFragment();
    groupUserInviteFragment.b(paramInt);
    return groupUserInviteFragment;
  }
  
  private void a(boolean paramBoolean) {
    if (paramBoolean)
      this.j = 1; 
    if (this.j == 1)
      this.l = true; 
    if (!this.l) {
      int k = this.j;
      if (k != 1) {
        this.j = k - 1;
        AppMethods.a(getResources().getString(2131756083));
        return;
      } 
    } 
    int i = this.o;
    if (i != 0) {
      if (i != 1) {
        if (i != 2)
          return; 
        Context context1 = this.n;
        BluedUIHttpResponse bluedUIHttpResponse1 = this.e;
        String str3 = UserInfo.a().i().getUid();
        StringBuilder stringBuilder3 = new StringBuilder();
        stringBuilder3.append(this.j);
        stringBuilder3.append("");
        String str4 = stringBuilder3.toString();
        StringBuilder stringBuilder4 = new StringBuilder();
        stringBuilder4.append(this.k);
        stringBuilder4.append("");
        MineHttpUtils.e(context1, bluedUIHttpResponse1, str3, str4, stringBuilder4.toString(), (IRequestHost)w_());
        return;
      } 
      Context context = this.n;
      BluedUIHttpResponse bluedUIHttpResponse = this.e;
      String str1 = UserInfo.a().i().getUid();
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append(this.j);
      stringBuilder1.append("");
      String str2 = stringBuilder1.toString();
      StringBuilder stringBuilder2 = new StringBuilder();
      stringBuilder2.append(this.k);
      stringBuilder2.append("");
      MineHttpUtils.c(context, bluedUIHttpResponse, str1, str2, stringBuilder2.toString(), (IRequestHost)w_());
      return;
    } 
    i = this.k;
    int j = this.j;
    FilterEntity filterEntity = new FilterEntity();
    filterEntity.latitude = BluedPreferences.t();
    filterEntity.longitude = BluedPreferences.s();
    filterEntity.sort_by = "index";
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(i * (j - 1));
    stringBuilder.append("");
    filterEntity.start = stringBuilder.toString();
    stringBuilder = new StringBuilder();
    stringBuilder.append(this.k);
    stringBuilder.append("");
    filterEntity.limit = stringBuilder.toString();
    filterEntity.source = "group";
    filterEntity.column = PeopleGridQuickAdapter.a(this.n);
  }
  
  private void k() {
    this.g = (NoDataAndLoadFailView)this.m.findViewById(2131298994);
    this.i = new ArrayList<BluedUserInviteList>();
    this.f = (RenrenPullToRefreshListView)this.m.findViewById(2131297307);
    this.h = (ListView)this.f.getRefreshableView();
    this.h.setDivider(null);
    this.h.setSelector((Drawable)new ColorDrawable(0));
    this.f.setRefreshEnabled(true);
    this.f.k();
    this.f.setOnPullDownListener(new MyPullDownListener());
    this.d = new GroupUserInviteAdapter(this.n, (IRequestHost)w_(), this.i);
    this.h.setAdapter((ListAdapter)this.d);
  }
  
  public void a() {
    this.h.smoothScrollToPosition(0);
  }
  
  public void b(int paramInt) {
    this.o = paramInt;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public void onClick(View paramView) {}
  
  public void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
    this.n = (Context)getActivity();
    View view = this.m;
    if (view == null) {
      this.m = paramLayoutInflater.inflate(2131493160, paramViewGroup, false);
      k();
      a(false);
      CommonTitleDoubleClickObserver.a().a(this);
    } else if (view.getParent() != null) {
      ((ViewGroup)this.m.getParent()).removeView(this.m);
    } 
    return this.m;
  }
  
  public void onDetach() {
    CommonTitleDoubleClickObserver.a().b(this);
    super.onDetach();
  }
  
  static interface DATA_TYPE {}
  
  class MyPullDownListener implements RenrenPullToRefreshListView.OnPullDownListener {
    private MyPullDownListener(GroupUserInviteFragment this$0) {}
    
    public void a() {
      GroupUserInviteFragment.a(this.a, 1);
      GroupUserInviteFragment.a(this.a, false);
    }
    
    public void b() {
      GroupUserInviteFragment.a(this.a);
      GroupUserInviteFragment.a(this.a, false);
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\group\GroupUserInviteFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */