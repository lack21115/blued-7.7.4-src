package com.soft.blued.ui.group;

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
import android.widget.ListAdapter;
import android.widget.ListView;
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
import com.blued.android.framework.utils.FileCache;
import com.blued.android.framework.view.pulltorefresh.RenrenPullToRefreshPinnedSectionListView;
import com.blued.android.module.common.observer.CommonTitleDoubleClickObserver;
import com.google.gson.reflect.TypeToken;
import com.soft.blued.customview.NoDataAndLoadFailView;
import com.soft.blued.customview.SearchView;
import com.soft.blued.http.GroupHttpUtils;
import com.soft.blued.ui.find.model.FilterInfo;
import com.soft.blued.ui.group.adapter.GroupListsAdapter;
import com.soft.blued.ui.group.fragment.GroupInfoFragment;
import com.soft.blued.ui.group.model.BluedGroupCheck;
import com.soft.blued.ui.group.model.BluedGroupLists;
import com.soft.blued.ui.group.model.BluedGroupTypeTags;
import java.util.ArrayList;
import java.util.List;

public class GroupFragmentRecommend extends BaseFragment implements View.OnClickListener, CommonTitleDoubleClickObserver.ITitleClickObserver {
  private static int B = 0;
  
  public static String f = "ISNEARBY";
  
  private List<FilterInfo> A = new ArrayList<FilterInfo>();
  
  private List<BluedGroupTypeTags> C;
  
  private LinearLayout D;
  
  private List<BluedGroupCheck> E;
  
  private LayoutInflater F;
  
  private Bundle G;
  
  private boolean H;
  
  private NoDataAndLoadFailView I;
  
  List<String> d = new ArrayList<String>();
  
  public BluedGroupCheck.GroupFailureReason e;
  
  int g = 1;
  
  boolean h;
  
  public BluedUIHttpResponse i = new BluedUIHttpResponse<BluedEntityA<BluedGroupLists>>(this) {
      boolean a;
      
      protected void a(BluedEntityA<BluedGroupLists> param1BluedEntityA) {
        if (param1BluedEntityA != null && param1BluedEntityA.hasData()) {
          if (param1BluedEntityA.data.size() >= GroupFragmentRecommend.c(this.b)) {
            GroupFragmentRecommend.a(this.b, true);
            GroupFragmentRecommend.b(this.b).o();
          } else {
            GroupFragmentRecommend.a(this.b, false);
            GroupFragmentRecommend.b(this.b).p();
          } 
          if (GroupFragmentRecommend.d(this.b) == 1) {
            GroupFragmentRecommend.e(this.b).clear();
            GroupFragmentRecommend.f(this.b).clear();
          } 
          GroupFragmentRecommend.e(this.b).addAll(param1BluedEntityA.data);
          GroupFragmentRecommend.g(this.b).notifyDataSetChanged();
          return;
        } 
        if (GroupFragmentRecommend.d(this.b) == 1) {
          GroupFragmentRecommend.e(this.b).clear();
          GroupFragmentRecommend.g(this.b).notifyDataSetChanged();
        } 
        if (GroupFragmentRecommend.d(this.b) != 1)
          GroupFragmentRecommend.h(this.b); 
        GroupFragmentRecommend.b(this.b).p();
      }
      
      public void onSuccess(String param1String) {
        super.onSuccess(param1String);
        FileCache.a("default_group_list", param1String);
      }
      
      public boolean onUIFailure(int param1Int, String param1String) {
        this.a = true;
        if (GroupFragmentRecommend.d(this.b) != 1)
          GroupFragmentRecommend.h(this.b); 
        return super.onUIFailure(param1Int, param1String);
      }
      
      public void onUIFinish() {
        super.onUIFinish();
        GroupFragmentRecommend.b(this.b).j();
        GroupFragmentRecommend.b(this.b).q();
        if (GroupFragmentRecommend.g(this.b).getCount() == 0) {
          if (this.a) {
            this.a = false;
            GroupFragmentRecommend.i(this.b).b();
            return;
          } 
          GroupFragmentRecommend.i(this.b).a();
          return;
        } 
        GroupFragmentRecommend.i(this.b).c();
      }
    };
  
  private String j = GroupFragmentRecommend.class.getSimpleName();
  
  private RenrenPullToRefreshPinnedSectionListView k;
  
  private ListView l;
  
  private List<BluedGroupLists> m;
  
  private List<BluedGroupLists> n;
  
  private int o = 1;
  
  private int p = 20;
  
  private boolean q = true;
  
  private GroupListsAdapter r;
  
  private View s;
  
  private Context t;
  
  private LayoutInflater u;
  
  private View v;
  
  private SearchView w;
  
  private TextView x;
  
  private TextView y;
  
  private List<FilterInfo> z = new ArrayList<FilterInfo>();
  
  private void a(boolean paramBoolean) {
    if (paramBoolean)
      this.o = 1; 
    if (this.o == 1)
      this.q = true; 
    if (!this.q) {
      int i = this.o;
      if (i != 1) {
        this.o = i - 1;
        AppMethods.a(this.t.getResources().getString(2131756083));
        this.k.j();
        return;
      } 
    } 
    if (B == 0) {
      Context context1 = this.t;
      BluedUIHttpResponse bluedUIHttpResponse1 = this.i;
      StringBuilder stringBuilder3 = new StringBuilder();
      stringBuilder3.append(this.o);
      stringBuilder3.append("");
      String str1 = stringBuilder3.toString();
      StringBuilder stringBuilder4 = new StringBuilder();
      stringBuilder4.append(this.p);
      stringBuilder4.append("");
      GroupHttpUtils.e(context1, bluedUIHttpResponse1, str1, stringBuilder4.toString(), (IRequestHost)w_());
      return;
    } 
    Context context = this.t;
    BluedUIHttpResponse bluedUIHttpResponse = this.i;
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append(this.o);
    stringBuilder1.append("");
    String str = stringBuilder1.toString();
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append(this.p);
    stringBuilder2.append("");
    GroupHttpUtils.d(context, bluedUIHttpResponse, "hot", str, stringBuilder2.toString(), "", "", (IRequestHost)w_());
  }
  
  private void k() {
    String str = FileCache.a("default_group_list");
    try {
      BluedEntityA bluedEntityA = (BluedEntityA)AppInfo.f().fromJson(str, (new TypeToken<BluedEntityA<BluedGroupLists>>(this) {
          
          }).getType());
      if (bluedEntityA != null && bluedEntityA.data != null && bluedEntityA.data.size() > 0) {
        this.m.addAll(bluedEntityA.data);
        this.r.notifyDataSetChanged();
        this.g = 1;
        this.h = false;
        return;
      } 
    } catch (Exception exception) {
      exception.printStackTrace();
    } 
  }
  
  private void l() {
    this.G = getArguments();
    Bundle bundle = this.G;
    if (bundle != null)
      this.H = bundle.getBoolean(f); 
    this.u = (LayoutInflater)this.t.getSystemService("layout_inflater");
    B = 1;
    this.v = this.u.inflate(2131493139, null);
    this.x = (TextView)this.v.findViewById(2131301297);
    this.y = (TextView)this.v.findViewById(2131301241);
    this.w = (SearchView)this.v.findViewById(2131297300);
    this.x.setOnClickListener(this);
    this.y.setOnClickListener(this);
    this.w.setMaskLayerOnClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            TerminalActivity.d(GroupFragmentRecommend.a(this.a), GroupSearchFragment.class, null);
          }
        });
    this.D = (LinearLayout)this.v.findViewById(2131298858);
    this.D.setVisibility(8);
  }
  
  private void m() {
    this.I = (NoDataAndLoadFailView)this.s.findViewById(2131299395);
    this.F = LayoutInflater.from(this.t);
    this.E = new ArrayList<BluedGroupCheck>();
    this.e = new BluedGroupCheck.GroupFailureReason();
    this.C = new ArrayList<BluedGroupTypeTags>();
    this.m = new ArrayList<BluedGroupLists>();
    this.n = new ArrayList<BluedGroupLists>();
    this.k = (RenrenPullToRefreshPinnedSectionListView)this.s.findViewById(2131299333);
    this.k.setRefreshEnabled(true);
    this.k.postDelayed(new Runnable(this) {
          public void run() {
            GroupFragmentRecommend.b(this.a).k();
          }
        },  100L);
    this.k.setOnPullDownListener(new MyPullDownListener());
    this.l = (ListView)this.k.getRefreshableView();
    this.l.setDivider(null);
    this.l.setSelector((Drawable)new ColorDrawable(0));
    this.l.setOnItemClickListener(new MyOnItemClickListener());
    this.r = new GroupListsAdapter(this.t, (IRequestHost)w_(), this.m);
    this.l.addHeaderView(this.v);
    this.l.setAdapter((ListAdapter)this.r);
  }
  
  public void a() {
    this.l.smoothScrollToPosition(0);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt1 != 100)
      return; 
    a(false);
  }
  
  public void onClick(View paramView) {
    if (paramView.getId() != 2131296863)
      return; 
    getActivity().finish();
  }
  
  public void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
    this.t = (Context)getActivity();
    View view = this.s;
    if (view == null) {
      this.s = paramLayoutInflater.inflate(2131493148, paramViewGroup, false);
      l();
      m();
      k();
      CommonTitleDoubleClickObserver.a().a(this);
    } else if (view.getParent() != null) {
      ((ViewGroup)this.s.getParent()).removeView(this.s);
    } 
    return this.s;
  }
  
  public void onDestroy() {
    CommonTitleDoubleClickObserver.a().b(this);
    super.onDestroy();
  }
  
  class MyOnItemClickListener implements AdapterView.OnItemClickListener {
    private MyOnItemClickListener(GroupFragmentRecommend this$0) {}
    
    public void onItemClick(AdapterView<?> param1AdapterView, View param1View, int param1Int, long param1Long) {
      if (param1Int > 1) {
        if (param1Int > GroupFragmentRecommend.e(this.a).size() + 1)
          return; 
        BluedGroupLists bluedGroupLists = GroupFragmentRecommend.e(this.a).get(param1Int - 2);
        if (bluedGroupLists != null) {
          if (bluedGroupLists.is_title == 1)
            return; 
          GroupInfoFragment.a((Fragment)this.a, bluedGroupLists.groups_gid, "recommend", 100);
        } 
      } 
    }
  }
  
  class MyPullDownListener implements RenrenPullToRefreshPinnedSectionListView.OnPullDownListener {
    private MyPullDownListener(GroupFragmentRecommend this$0) {}
    
    public void a() {
      GroupFragmentRecommend.a(this.a, 1);
      GroupFragmentRecommend groupFragmentRecommend = this.a;
      groupFragmentRecommend.h = false;
      groupFragmentRecommend.g = 1;
      GroupFragmentRecommend.b(groupFragmentRecommend, false);
    }
    
    public void b() {
      GroupFragmentRecommend.j(this.a);
      GroupFragmentRecommend.b(this.a, false);
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\group\GroupFragmentRecommend.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */