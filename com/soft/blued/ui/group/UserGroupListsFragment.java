package com.soft.blued.ui.group;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.blued.android.core.AppInfo;
import com.blued.android.core.AppMethods;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.view.stickylistheaders.StickyListHeadersAdapter;
import com.blued.android.framework.view.stickylistheaders.StickyListHeadersListView;
import com.blued.android.module.common.utils.DialogUtils;
import com.soft.blued.customview.CommonTopTitleNoTrans;
import com.soft.blued.customview.NoDataAndLoadFailView;
import com.soft.blued.db.model.MsgExtra;
import com.soft.blued.http.GroupHttpUtils;
import com.soft.blued.ui.group.adapter.MyGroupListsAdapter;
import com.soft.blued.ui.group.fragment.GroupInfoFragment;
import com.soft.blued.ui.group.model.BluedCreatedGroupInfo;
import com.soft.blued.ui.group.model.BluedGroupCheck;
import com.soft.blued.ui.group.model.BluedGroupLists;
import com.soft.blued.ui.group.model.BluedMyGroupLists;
import com.soft.blued.ui.msg.MsgChattingFragment;
import com.soft.blued.user.UserInfo;
import com.soft.blued.utils.CommonDataRefreshObserver;
import com.soft.blued.utils.PopMenuUtils;
import com.soft.blued.utils.StringUtils;
import java.util.ArrayList;
import java.util.List;

public class UserGroupListsFragment extends BaseFragment implements View.OnClickListener, CommonDataRefreshObserver.IDataRefreshObserver {
  public BluedUIHttpResponse d = new BluedUIHttpResponse<BluedEntityA<BluedMyGroupLists>>(this) {
      boolean a;
      
      protected void a(BluedEntityA<BluedMyGroupLists> param1BluedEntityA) {
        if (param1BluedEntityA != null)
          try {
            BluedMyGroupLists bluedMyGroupLists = (BluedMyGroupLists)param1BluedEntityA.getSingleData();
            byte b = 0;
            if (bluedMyGroupLists != null) {
              if (bluedMyGroupLists.created.size() > 0 || bluedMyGroupLists.admin.size() > 0 || bluedMyGroupLists.joined.size() > 0) {
                UserGroupListsFragment.b(this.b).setVisibility(8);
                UserGroupListsFragment.c(this.b).clear();
                UserGroupListsFragment.c(this.b).addAll(param1BluedEntityA.data);
                List list1 = ((BluedMyGroupLists)UserGroupListsFragment.c(this.b).get(0)).created;
                List list2 = ((BluedMyGroupLists)UserGroupListsFragment.c(this.b).get(0)).admin;
                List list3 = ((BluedMyGroupLists)UserGroupListsFragment.c(this.b).get(0)).joined;
                UserGroupListsFragment.d(this.b).clear();
                if (list1 != null)
                  for (int i = 0; i < list1.size(); i++) {
                    ((BluedCreatedGroupInfo)list1.get(i)).type = 0;
                    ((BluedCreatedGroupInfo)list1.get(i)).header_name = this.b.getResources().getString(2131758154);
                    UserGroupListsFragment.d(this.b).add(list1.get(i));
                  }  
                if (list2 != null) {
                  int i;
                  for (i = 0; i < list2.size(); i++) {
                    ((BluedCreatedGroupInfo)list2.get(i)).type = 1;
                    ((BluedCreatedGroupInfo)list2.get(i)).header_name = this.b.getResources().getString(2131758170);
                    UserGroupListsFragment.d(this.b).add(list2.get(i));
                  } 
                } 
                if (list3 != null) {
                  int i;
                  for (i = b; i < list3.size(); i++) {
                    ((BluedCreatedGroupInfo)list3.get(i)).type = 2;
                    ((BluedCreatedGroupInfo)list3.get(i)).header_name = this.b.getResources().getString(2131758167);
                    UserGroupListsFragment.d(this.b).add(list3.get(i));
                  } 
                } 
                UserGroupListsFragment.e(this.b).setRightImg(2131232746);
              } else {
                UserGroupListsFragment.d(this.b).clear();
                UserGroupListsFragment.f(this.b).setVisibility(8);
                UserGroupListsFragment.b(this.b).setVisibility(0);
                UserGroupListsFragment.g(this.b).setVisibility(0);
                UserGroupListsFragment.e(this.b).a();
              } 
            } else {
              UserGroupListsFragment.d(this.b).clear();
              UserGroupListsFragment.f(this.b).setVisibility(8);
              UserGroupListsFragment.b(this.b).setVisibility(0);
              UserGroupListsFragment.g(this.b).setVisibility(0);
              UserGroupListsFragment.e(this.b).a();
            } 
            UserGroupListsFragment.h(this.b).notifyDataSetChanged();
            return;
          } catch (Exception exception) {
            this.a = true;
            exception.printStackTrace();
            AppMethods.a(UserGroupListsFragment.i(this.b).getResources().getString(2131756082));
          }  
      }
      
      public boolean onUIFailure(int param1Int, String param1String) {
        this.a = true;
        return super.onUIFailure(param1Int, param1String);
      }
      
      public void onUIFinish() {
        super.onUIFinish();
        DialogUtils.b(UserGroupListsFragment.a(this.b));
        if (this.a) {
          this.a = false;
          UserGroupListsFragment.d(this.b).clear();
          UserGroupListsFragment.f(this.b).setVisibility(8);
          UserGroupListsFragment.b(this.b).setVisibility(8);
          UserGroupListsFragment.g(this.b).setVisibility(8);
          UserGroupListsFragment.e(this.b).a();
          UserGroupListsFragment.j(this.b).b();
        } 
      }
      
      public void onUIStart() {
        super.onUIStart();
        DialogUtils.a(UserGroupListsFragment.a(this.b));
      }
    };
  
  private CommonTopTitleNoTrans e;
  
  private LinearLayout f;
  
  private NoDataAndLoadFailView g;
  
  private TextView h;
  
  private TextView i;
  
  private StickyListHeadersListView j;
  
  private MyGroupListsAdapter k;
  
  private View l;
  
  private Context m;
  
  private Dialog n;
  
  private List<BluedMyGroupLists> o;
  
  private List<BluedGroupLists> p;
  
  private boolean q;
  
  private BluedGroupCheck.GroupFailureReason r;
  
  private String s;
  
  public static void a(Context paramContext) {
    Bundle bundle = new Bundle();
    bundle.putString("UID", UserInfo.a().i().getUid());
    TerminalActivity.d(paramContext, UserGroupListsFragment.class, bundle);
  }
  
  private void k() {
    this.e = (CommonTopTitleNoTrans)this.l.findViewById(2131300300);
    this.e.setRightClickListener(this);
    if (getArguments() != null && !StringUtils.e(getArguments().getString("UID")) && !getArguments().getString("UID").equalsIgnoreCase(UserInfo.a().i().getUid())) {
      this.e.setCenterText(getString(2131756697));
      this.e.a();
    } else {
      this.e.setCenterText(getString(2131758192));
      this.e.setRightImg(2131232746);
      this.e.setRightClickListener(this);
    } 
    this.e.setLeftClickListener(this);
  }
  
  private void l() {
    this.n = DialogUtils.a(this.m);
    this.r = new BluedGroupCheck.GroupFailureReason();
    this.f = (LinearLayout)this.l.findViewById(2131298992);
    this.g = (NoDataAndLoadFailView)this.l.findViewById(2131299395);
    this.h = (TextView)this.l.findViewById(2131300819);
    this.h.setOnClickListener(this);
    this.i = (TextView)this.l.findViewById(2131300846);
    this.i.setOnClickListener(this);
    this.o = new ArrayList<BluedMyGroupLists>();
    this.p = new ArrayList<BluedGroupLists>();
    this.j = (StickyListHeadersListView)this.l.findViewById(2131299333);
    this.j.setDivider(null);
    this.j.setSelector((Drawable)new ColorDrawable(0));
    this.j.setOnItemClickListener(new MyOnItemClickListener());
    boolean bool = UserInfo.a().i().getUid().equalsIgnoreCase(this.s);
    this.k = new MyGroupListsAdapter(this.m, (IRequestHost)w_(), this.p, bool);
    this.j.setAdapter((StickyListHeadersAdapter)this.k);
  }
  
  private void m() {
    GroupHttpUtils.g(this.m, this.d, this.s, (IRequestHost)w_());
    if (this.q)
      this.l.findViewById(2131300300).setVisibility(8); 
  }
  
  public void a() {
    m();
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt1 != 100) {
      if (!StringUtils.e(this.s)) {
        GroupHttpUtils.g(this.m, this.d, this.s, (IRequestHost)w_());
        return;
      } 
    } else {
      m();
    } 
  }
  
  public void onClick(View paramView) {
    switch (paramView.getId()) {
      default:
        return;
      case 2131300846:
        TerminalActivity.d((Context)getActivity(), GroupFragment.class, null);
        return;
      case 2131300819:
        if (!PopMenuUtils.a(this.m)) {
          TerminalActivity.d((Context)getActivity(), GroupCreateFragment.class, null);
          return;
        } 
        return;
      case 2131296867:
        if (!PopMenuUtils.a(this.m)) {
          TerminalActivity.d((Context)getActivity(), GroupCreateFragment.class, null);
          return;
        } 
        return;
      case 2131296863:
        break;
    } 
    getActivity().finish();
  }
  
  public void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
    this.m = (Context)getActivity();
    View view = this.l;
    if (view == null) {
      this.l = paramLayoutInflater.inflate(2131493243, paramViewGroup, false);
      Bundle bundle = getArguments();
      if (bundle != null) {
        this.s = bundle.getString("UID");
        this.q = bundle.getBoolean("hidetitle", false);
      } else {
        this.s = UserInfo.a().i().getUid();
        this.q = false;
      } 
      l();
      k();
      m();
      if (this.q)
        CommonDataRefreshObserver.a().a(this); 
    } else if (view.getParent() != null) {
      ((ViewGroup)this.l.getParent()).removeView(this.l);
    } 
    return this.l;
  }
  
  public void onDestroy() {
    if (this.q)
      CommonDataRefreshObserver.a().b(this); 
    super.onDestroy();
  }
  
  class MyOnItemClickListener implements AdapterView.OnItemClickListener {
    private MyOnItemClickListener(UserGroupListsFragment this$0) {}
    
    public void onItemClick(AdapterView<?> param1AdapterView, View param1View, int param1Int, long param1Long) {
      if (param1Int >= 0) {
        String str1;
        Intent intent;
        if (param1Int > UserGroupListsFragment.d(this.a).size())
          return; 
        BluedGroupLists bluedGroupLists = UserGroupListsFragment.d(this.a).get(param1Int);
        if (bluedGroupLists == null)
          return; 
        Bundle bundle = this.a.getArguments();
        String str2 = "";
        if (bundle != null) {
          str1 = bundle.getString("fragment_name_key");
        } else {
          str1 = "";
        } 
        if (!StringUtils.e(str1) && str1.equals(MsgChattingFragment.class.getSimpleName())) {
          MsgExtra msgExtra = new MsgExtra();
          msgExtra.setGroups_avatar(bluedGroupLists.groups_avatar);
          msgExtra.setGroups_city(bluedGroupLists.groups_city);
          msgExtra.setGroups_members_count(bluedGroupLists.groups_members_count);
          msgExtra.setGroups_name(bluedGroupLists.groups_name);
          msgExtra.setGroups_gid(bluedGroupLists.groups_gid);
          msgExtra.setGroups_description(bluedGroupLists.groups_description);
          String str3 = bluedGroupLists.groups_gid;
          String str5 = bluedGroupLists.groups_is_created;
          String str4 = bluedGroupLists.groups_is_admins;
          str1 = str2;
          if (!StringUtils.e(str5)) {
            str1 = str2;
            if (!StringUtils.e(str4))
              if (str5.equals("1") || str4.equals("1")) {
                str1 = "1";
              } else {
                str1 = "0";
              }  
          } 
          str2 = AppInfo.f().toJson(msgExtra);
          intent = new Intent(UserGroupListsFragment.i(this.a), MsgChattingFragment.class);
          intent.putExtra("group_extra_json", str2);
          intent.putExtra("gid", str3);
          intent.putExtra("flag", str1);
          this.a.getActivity().setResult(-1, intent);
          this.a.getActivity().finish();
          return;
        } 
        GroupInfoFragment.a((Fragment)this.a, ((BluedGroupLists)intent).groups_gid, 100);
      } 
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\group\UserGroupListsFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */