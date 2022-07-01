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

public class GroupFragmentNear extends BaseFragment implements View.OnClickListener, CommonTitleDoubleClickObserver.ITitleClickObserver {
  public static String d = "NEARBYGROUP1";
  
  public static String e = "NEARBYGROUP2";
  
  public static int f = 0;
  
  public static String i = "ISNEARBY";
  
  private TextView A;
  
  private List<FilterInfo> B = new ArrayList<FilterInfo>();
  
  private List<FilterInfo> C = new ArrayList<FilterInfo>();
  
  private List<BluedGroupTypeTags> D;
  
  private LinearLayout E;
  
  private SearchView F;
  
  private List<BluedGroupCheck> G;
  
  private LayoutInflater H;
  
  private Bundle I;
  
  private BluedGroupLists J;
  
  private BluedGroupLists K;
  
  private NoDataAndLoadFailView L;
  
  List<String> g = new ArrayList<String>();
  
  public BluedGroupCheck.GroupFailureReason h;
  
  int j = 1;
  
  boolean k;
  
  public BluedUIHttpResponse l = new BluedUIHttpResponse<BluedEntityA<BluedGroupLists>>(this) {
      boolean a;
      
      protected void a(BluedEntityA<BluedGroupLists> param1BluedEntityA) {
        if (param1BluedEntityA != null && param1BluedEntityA.hasData()) {
          if (param1BluedEntityA.data.size() >= GroupFragmentNear.d(this.b)) {
            GroupFragmentNear.a(this.b, true);
            GroupFragmentNear.b(this.b).o();
          } else {
            GroupFragmentNear.a(this.b, false);
            GroupFragmentNear.b(this.b).p();
          } 
          if (GroupFragmentNear.c(this.b) == 1) {
            GroupFragmentNear.e(this.b).clear();
            GroupFragmentNear.f(this.b).clear();
            if (GroupFragment.d == 0) {
              ArrayList<BluedGroupLists> arrayList = new ArrayList();
              arrayList.add(GroupFragmentNear.g(this.b));
              arrayList.add(GroupFragmentNear.h(this.b));
              arrayList.addAll(param1BluedEntityA.data);
              GroupFragmentNear.e(this.b).addAll(arrayList);
            } else {
              GroupFragmentNear.e(this.b).addAll(param1BluedEntityA.data);
            } 
          } else {
            GroupFragmentNear.e(this.b).addAll(param1BluedEntityA.data);
          } 
          GroupFragmentNear.i(this.b).notifyDataSetChanged();
          return;
        } 
        if (GroupFragmentNear.c(this.b) == 1) {
          GroupFragmentNear.e(this.b).clear();
          GroupFragmentNear.i(this.b).notifyDataSetChanged();
        } 
        if (GroupFragmentNear.c(this.b) != 1)
          GroupFragmentNear.j(this.b); 
        GroupFragmentNear.b(this.b).p();
      }
      
      public void onSuccess(String param1String) {
        super.onSuccess(param1String);
        if (GroupFragmentNear.c(this.b) == 1)
          FileCache.a("default_group_list", param1String); 
      }
      
      public boolean onUIFailure(int param1Int, String param1String) {
        this.a = true;
        if (GroupFragmentNear.c(this.b) != 1)
          GroupFragmentNear.j(this.b); 
        return super.onUIFailure(param1Int, param1String);
      }
      
      public void onUIFinish() {
        super.onUIFinish();
        GroupFragmentNear.b(this.b).j();
        GroupFragmentNear.b(this.b).q();
        if (GroupFragmentNear.i(this.b).getCount() == 0) {
          if (this.a) {
            this.a = false;
            GroupFragmentNear.k(this.b).b();
            return;
          } 
          GroupFragmentNear.k(this.b).a();
          return;
        } 
        GroupFragmentNear.k(this.b).c();
      }
    };
  
  private String m = GroupFragmentNear.class.getSimpleName();
  
  private RenrenPullToRefreshPinnedSectionListView n;
  
  private ListView o;
  
  private List<BluedGroupLists> p;
  
  private List<BluedGroupLists> q;
  
  private int r = 1;
  
  private int s = 20;
  
  private boolean t = true;
  
  private GroupListsAdapter u;
  
  private View v;
  
  private Context w;
  
  private LayoutInflater x;
  
  private View y;
  
  private TextView z;
  
  private void a(boolean paramBoolean) {
    if (paramBoolean)
      this.r = 1; 
    if (this.r == 1)
      this.t = true; 
    if (!this.t) {
      int i = this.r;
      if (i != 1) {
        this.r = i - 1;
        AppMethods.a(this.w.getResources().getString(2131756083));
        this.n.j();
        return;
      } 
    } 
    if (f == 0) {
      Context context1 = this.w;
      BluedUIHttpResponse bluedUIHttpResponse1 = this.l;
      StringBuilder stringBuilder3 = new StringBuilder();
      stringBuilder3.append(this.r);
      stringBuilder3.append("");
      String str1 = stringBuilder3.toString();
      StringBuilder stringBuilder4 = new StringBuilder();
      stringBuilder4.append(this.s);
      stringBuilder4.append("");
      GroupHttpUtils.e(context1, bluedUIHttpResponse1, str1, stringBuilder4.toString(), (IRequestHost)w_());
      return;
    } 
    Context context = this.w;
    BluedUIHttpResponse bluedUIHttpResponse = this.l;
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append(this.r);
    stringBuilder1.append("");
    String str = stringBuilder1.toString();
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append(this.s);
    stringBuilder2.append("");
    GroupHttpUtils.d(context, bluedUIHttpResponse, "hot", str, stringBuilder2.toString(), "", "", (IRequestHost)w_());
  }
  
  private void k() {
    this.I = getArguments();
    Bundle bundle = this.I;
    if (bundle != null) {
      this.J = (BluedGroupLists)bundle.getSerializable(d);
      this.J.is_title = 2;
      this.K = (BluedGroupLists)this.I.getSerializable(e);
      this.K.is_title = 2;
    } 
    String str = FileCache.a("default_group_list");
    try {
      BluedEntityA bluedEntityA = (BluedEntityA)AppInfo.f().fromJson(str, (new TypeToken<BluedEntityA<BluedGroupLists>>(this) {
          
          }).getType());
      if (bluedEntityA != null && bluedEntityA.data != null && bluedEntityA.data.size() > 0) {
        if (GroupFragment.d == 0) {
          ArrayList<BluedGroupLists> arrayList = new ArrayList();
          arrayList.add(this.J);
          arrayList.add(this.K);
          arrayList.addAll(bluedEntityA.data);
          this.p.addAll(arrayList);
        } else {
          this.p.addAll(bluedEntityA.data);
        } 
        this.u.notifyDataSetChanged();
        this.j = 1;
        this.k = false;
        return;
      } 
    } catch (Exception exception) {
      exception.printStackTrace();
    } 
  }
  
  private void l() {
    this.x = (LayoutInflater)this.w.getSystemService("layout_inflater");
    f = 0;
    this.y = this.x.inflate(2131493139, null);
    this.z = (TextView)this.y.findViewById(2131301297);
    this.A = (TextView)this.y.findViewById(2131301241);
    this.F = (SearchView)this.y.findViewById(2131297300);
    this.F.setMaskLayerOnClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            TerminalActivity.d(GroupFragmentNear.a(this.a), GroupSearchFragment.class, null);
          }
        });
    this.z.setOnClickListener(this);
    this.A.setOnClickListener(this);
    this.E = (LinearLayout)this.y.findViewById(2131298858);
    this.E.setVisibility(8);
  }
  
  private void m() {
    this.H = LayoutInflater.from(this.w);
    this.L = (NoDataAndLoadFailView)this.v.findViewById(2131299395);
    this.G = new ArrayList<BluedGroupCheck>();
    this.h = new BluedGroupCheck.GroupFailureReason();
    this.D = new ArrayList<BluedGroupTypeTags>();
    this.p = new ArrayList<BluedGroupLists>();
    this.q = new ArrayList<BluedGroupLists>();
    this.n = (RenrenPullToRefreshPinnedSectionListView)this.v.findViewById(2131299333);
    this.n.setRefreshEnabled(true);
    this.n.postDelayed(new Runnable(this) {
          public void run() {
            GroupFragmentNear.b(this.a).k();
          }
        },  100L);
    this.n.setOnPullDownListener(new MyPullDownListener());
    this.o = (ListView)this.n.getRefreshableView();
    this.o.setDivider(null);
    this.o.setSelector((Drawable)new ColorDrawable(0));
    this.o.setOnItemClickListener(new MyOnItemClickListener());
    this.u = new GroupListsAdapter(this.w, (IRequestHost)w_(), this.p);
    this.o.addHeaderView(this.y);
    this.o.setAdapter((ListAdapter)this.u);
  }
  
  public void a() {
    this.o.smoothScrollToPosition(0);
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
    this.w = (Context)getActivity();
    View view = this.v;
    if (view == null) {
      this.v = paramLayoutInflater.inflate(2131493148, paramViewGroup, false);
      l();
      m();
      k();
      CommonTitleDoubleClickObserver.a().a(this);
    } else if (view.getParent() != null) {
      ((ViewGroup)this.v.getParent()).removeView(this.v);
    } 
    return this.v;
  }
  
  public void onDestroy() {
    CommonTitleDoubleClickObserver.a().b(this);
    super.onDestroy();
  }
  
  class MyOnItemClickListener implements AdapterView.OnItemClickListener {
    private MyOnItemClickListener(GroupFragmentNear this$0) {}
    
    public void onItemClick(AdapterView<?> param1AdapterView, View param1View, int param1Int, long param1Long) {
      if (param1Int > 1) {
        if (param1Int > GroupFragmentNear.e(this.a).size() + 1)
          return; 
        BluedGroupLists bluedGroupLists = GroupFragmentNear.e(this.a).get(param1Int - 2);
        if (bluedGroupLists != null) {
          if (bluedGroupLists.is_title == 1)
            return; 
          GroupInfoFragment.a((Fragment)this.a, bluedGroupLists.groups_gid, "nearby", 100);
        } 
      } 
    }
  }
  
  class MyPullDownListener implements RenrenPullToRefreshPinnedSectionListView.OnPullDownListener {
    private MyPullDownListener(GroupFragmentNear this$0) {}
    
    public void a() {
      GroupFragmentNear.a(this.a, 1);
      GroupFragmentNear groupFragmentNear = this.a;
      groupFragmentNear.k = false;
      groupFragmentNear.j = 1;
      GroupFragmentNear.b(groupFragmentNear, false);
    }
    
    public void b() {
      GroupFragmentNear.l(this.a);
      GroupFragmentNear.b(this.a, false);
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\group\GroupFragmentNear.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */