package com.soft.blued.ui.group;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import androidx.fragment.app.FragmentActivity;
import com.blued.android.core.AppMethods;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.framework.activity.PreloadFragment;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.view.pulltorefresh.RenrenPullToRefreshListView;
import com.blued.android.module.common.observer.CommonTitleDoubleClickObserver;
import com.blued.android.module.common.utils.DialogUtils;
import com.soft.blued.http.GroupHttpUtils;
import com.soft.blued.ui.group.adapter.GroupListsAdapter;
import com.soft.blued.ui.group.fragment.GroupInfoFragment;
import com.soft.blued.ui.group.model.BluedGroupCheck;
import com.soft.blued.ui.group.model.BluedGroupLists;
import com.soft.blued.user.UserInfo;
import com.soft.blued.utils.StringUtils;
import java.util.ArrayList;
import java.util.List;

public class GroupSearchResultFragment extends PreloadFragment implements View.OnClickListener, CommonTitleDoubleClickObserver.ITitleClickObserver {
  private GroupListsAdapter A;
  
  private View B;
  
  private Context C;
  
  private int D;
  
  private String E;
  
  private List<BluedGroupCheck> F;
  
  private String G;
  
  private String H;
  
  private String I;
  
  private String J;
  
  private String K;
  
  private Dialog L;
  
  public ListView o;
  
  public BluedGroupCheck.GroupFailureReason p;
  
  public BluedUIHttpResponse q = new BluedUIHttpResponse<BluedEntityA<BluedGroupLists>>(this) {
      protected void a(BluedEntityA<BluedGroupLists> param1BluedEntityA) {
        try {
          if (param1BluedEntityA.hasData()) {
            GroupSearchResultFragment.b(this.a).setVisibility(8);
            if (param1BluedEntityA.data.size() >= GroupSearchResultFragment.c(this.a)) {
              GroupSearchResultFragment.a(this.a, true);
              GroupSearchResultFragment.a(this.a).o();
            } else {
              GroupSearchResultFragment.a(this.a, false);
              GroupSearchResultFragment.a(this.a).p();
            } 
            if (GroupSearchResultFragment.d(this.a) == 1)
              GroupSearchResultFragment.e(this.a).clear(); 
            GroupSearchResultFragment.e(this.a).addAll(param1BluedEntityA.data);
            GroupSearchResultFragment.f(this.a).notifyDataSetChanged();
            return;
          } 
          if (GroupSearchResultFragment.d(this.a) == 1) {
            GroupSearchResultFragment.e(this.a).clear();
            GroupSearchResultFragment.f(this.a).notifyDataSetChanged();
          } 
          if (GroupSearchResultFragment.d(this.a) != 1)
            GroupSearchResultFragment.g(this.a); 
          GroupSearchResultFragment.a(this.a).p();
          return;
        } catch (Exception exception) {
          exception.printStackTrace();
          AppMethods.a(GroupSearchResultFragment.h(this.a).getResources().getString(2131756082));
          if (GroupSearchResultFragment.d(this.a) != 1)
            GroupSearchResultFragment.g(this.a); 
          return;
        } 
      }
      
      public void onUIFinish() {
        super.onUIFinish();
        GroupSearchResultFragment.a(this.a).j();
        GroupSearchResultFragment.a(this.a).q();
        if (GroupSearchResultFragment.e(this.a).size() == 0) {
          GroupSearchResultFragment.a(this.a).setVisibility(8);
          GroupSearchResultFragment.b(this.a).setVisibility(0);
          GroupSearchResultFragment.i(this.a).setVisibility(0);
        } 
      }
    };
  
  public BluedUIHttpResponse r = new BluedUIHttpResponse<BluedEntityA<BluedGroupCheck>>(this) {
      protected void a(BluedEntityA<BluedGroupCheck> param1BluedEntityA) {
        try {
          if (param1BluedEntityA.hasData()) {
            GroupSearchResultFragment.k(this.a).clear();
            GroupSearchResultFragment.k(this.a).addAll(param1BluedEntityA.data);
            if (!StringUtils.e(((BluedGroupCheck)param1BluedEntityA.data.get(0)).toString())) {
              if ("1".equals(((BluedGroupCheck)GroupSearchResultFragment.k(this.a).get(0)).getAble())) {
                TerminalActivity.d((Context)this.a.getActivity(), GroupCreateFragment.class, null);
                return;
              } 
              if ("0".equals(((BluedGroupCheck)GroupSearchResultFragment.k(this.a).get(0)).getAble())) {
                this.a.p = ((BluedGroupCheck)GroupSearchResultFragment.k(this.a).get(0)).getReason();
                GroupSearchResultFragment.a(this.a, this.a.p.getDays().getAble());
                GroupSearchResultFragment.b(this.a, this.a.p.getDays().getReason());
                GroupSearchResultFragment.c(this.a, this.a.p.getNum().getAble());
                GroupSearchResultFragment.d(this.a, this.a.p.getNum().getReason().get(0));
                GroupSearchResultFragment.e(this.a, this.a.p.getNum().getReason().get(1));
                Bundle bundle = new Bundle();
                bundle.putString(GroupCreateFragment.f, GroupSearchResultFragment.l(this.a));
                bundle.putString(GroupCreateFragment.g, GroupSearchResultFragment.m(this.a));
                bundle.putString(GroupCreateFragment.h, GroupSearchResultFragment.n(this.a));
                bundle.putString(GroupCreateFragment.i, GroupSearchResultFragment.o(this.a));
                bundle.putString(GroupCreateFragment.j, GroupSearchResultFragment.p(this.a));
                TerminalActivity.d((Context)this.a.getActivity(), GroupCreateFragment.class, bundle);
                return;
              } 
            } 
          } 
        } catch (Exception exception) {
          exception.printStackTrace();
          AppMethods.a(this.a.getResources().getString(2131756082));
        } 
      }
      
      public void onUIFinish() {
        super.onUIFinish();
        DialogUtils.b(GroupSearchResultFragment.j(this.a));
      }
      
      public void onUIStart() {
        super.onUIStart();
        DialogUtils.a(GroupSearchResultFragment.j(this.a));
      }
    };
  
  private String s = GroupSearchResultFragment.class.getSimpleName();
  
  private RenrenPullToRefreshListView t;
  
  private LinearLayout u;
  
  private Button v;
  
  private List<BluedGroupLists> w = new ArrayList<BluedGroupLists>();
  
  private int x = 1;
  
  private int y = 10;
  
  private boolean z = true;
  
  public static GroupSearchResultFragment a(int paramInt, String paramString) {
    GroupSearchResultFragment groupSearchResultFragment = new GroupSearchResultFragment();
    Bundle bundle = new Bundle();
    bundle.putInt("mFlag", paramInt);
    bundle.putString("mGroupKeywords", paramString);
    groupSearchResultFragment.setArguments(bundle);
    return groupSearchResultFragment;
  }
  
  private void a(boolean paramBoolean) {
    if (paramBoolean)
      this.x = 1; 
    if (this.x == 1)
      this.z = true; 
    if (!this.z) {
      int i = this.x;
      if (i != 1) {
        this.x = i - 1;
        AppMethods.a(getResources().getString(2131756083));
        return;
      } 
    } 
    if (!StringUtils.e(this.E)) {
      if (this.D == 0) {
        FragmentActivity fragmentActivity1 = getActivity();
        BluedUIHttpResponse bluedUIHttpResponse1 = this.q;
        String str3 = this.E;
        StringBuilder stringBuilder3 = new StringBuilder();
        stringBuilder3.append(this.x);
        stringBuilder3.append("");
        String str4 = stringBuilder3.toString();
        StringBuilder stringBuilder4 = new StringBuilder();
        stringBuilder4.append(this.y);
        stringBuilder4.append("");
        GroupHttpUtils.a((Context)fragmentActivity1, bluedUIHttpResponse1, str3, "nearby", str4, stringBuilder4.toString(), (IRequestHost)w_());
        return;
      } 
      FragmentActivity fragmentActivity = getActivity();
      BluedUIHttpResponse bluedUIHttpResponse = this.q;
      String str1 = this.E;
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append(this.x);
      stringBuilder1.append("");
      String str2 = stringBuilder1.toString();
      StringBuilder stringBuilder2 = new StringBuilder();
      stringBuilder2.append(this.y);
      stringBuilder2.append("");
      GroupHttpUtils.a((Context)fragmentActivity, bluedUIHttpResponse, str1, "hot", str2, stringBuilder2.toString(), (IRequestHost)w_());
      return;
    } 
    AppMethods.a(getResources().getString(2131756784));
  }
  
  private void t() {
    Bundle bundle = getArguments();
    if (bundle != null) {
      this.D = bundle.getInt("mFlag");
      this.E = bundle.getString("mGroupKeywords");
    } 
  }
  
  private void u() {
    this.L = DialogUtils.a(this.C);
    this.F = new ArrayList<BluedGroupCheck>();
    this.p = new BluedGroupCheck.GroupFailureReason();
    this.u = (LinearLayout)this.B.findViewById(2131298992);
    this.v = (Button)this.B.findViewById(2131296593);
    this.v.setOnClickListener(this);
    this.t = (RenrenPullToRefreshListView)this.B.findViewById(2131299333);
    this.o = (ListView)this.t.getRefreshableView();
    this.o.setDivider(null);
    this.o.setSelector((Drawable)new ColorDrawable(0));
    this.t.setRefreshEnabled(true);
    this.t.postDelayed(new Runnable(this) {
          public void run() {
            GroupSearchResultFragment.a(this.a).k();
          }
        },  100L);
    this.t.setOnPullDownListener(new MyPullDownListener());
    this.o.setOnItemClickListener(new MyOnItemClickListener());
    this.A = new GroupListsAdapter(this.C, (IRequestHost)w_(), this.w);
    this.o.setAdapter((ListAdapter)this.A);
  }
  
  public void a() {
    this.o.smoothScrollToPosition(0);
  }
  
  public void a(View paramView) {
    this.C = (Context)getActivity();
    this.B = LayoutInflater.from(this.C).inflate(2131493247, (ViewGroup)paramView, true);
    u();
    t();
    a(false);
    CommonTitleDoubleClickObserver.a().a(this);
  }
  
  public void onClick(View paramView) {
    if (paramView.getId() != 2131296593)
      return; 
    GroupHttpUtils.b(this.C, this.r, UserInfo.a().i().getUid(), (IRequestHost)w_());
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
    return super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
  }
  
  public void onDetach() {
    CommonTitleDoubleClickObserver.a().b(this);
    super.onDetach();
  }
  
  class MyOnItemClickListener implements AdapterView.OnItemClickListener {
    private MyOnItemClickListener(GroupSearchResultFragment this$0) {}
    
    public void onItemClick(AdapterView<?> param1AdapterView, View param1View, int param1Int, long param1Long) {
      if (param1Int >= 0) {
        if (param1Int > GroupSearchResultFragment.e(this.a).size())
          return; 
        Bundle bundle = new Bundle();
        List list = GroupSearchResultFragment.e(this.a);
        if (!StringUtils.e(((BluedGroupLists)list.get(--param1Int)).groups_gid))
          bundle.putString("gid", ((BluedGroupLists)GroupSearchResultFragment.e(this.a).get(param1Int)).groups_gid); 
        TerminalActivity.d((Context)this.a.getActivity(), GroupInfoFragment.class, bundle);
      } 
    }
  }
  
  class MyPullDownListener implements RenrenPullToRefreshListView.OnPullDownListener {
    private MyPullDownListener(GroupSearchResultFragment this$0) {}
    
    public void a() {
      GroupSearchResultFragment.a(this.a, 1);
      GroupSearchResultFragment.b(this.a, false);
    }
    
    public void b() {
      GroupSearchResultFragment.q(this.a);
      GroupSearchResultFragment.b(this.a, false);
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\group\GroupSearchResultFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */