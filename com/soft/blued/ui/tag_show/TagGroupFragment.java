package com.soft.blued.ui.tag_show;

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
import androidx.fragment.app.FragmentActivity;
import com.blued.android.core.AppMethods;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.view.pulltorefresh.RenrenPullToRefreshPinnedSectionListView;
import com.blued.android.module.common.observer.CommonTitleDoubleClickObserver;
import com.soft.blued.customview.SearchView;
import com.soft.blued.http.GroupHttpUtils;
import com.soft.blued.ui.find.model.FilterInfo;
import com.soft.blued.ui.group.GroupSearchFragment;
import com.soft.blued.ui.group.adapter.GroupListsAdapter;
import com.soft.blued.ui.group.fragment.GroupInfoFragment;
import com.soft.blued.ui.group.model.BluedGroupCheck;
import com.soft.blued.ui.group.model.BluedGroupLists;
import com.soft.blued.ui.group.model.BluedGroupTypeTags;
import com.soft.blued.utils.StringUtils;
import java.util.ArrayList;
import java.util.List;

public class TagGroupFragment extends BaseFragment implements View.OnClickListener, CommonTitleDoubleClickObserver.ITitleClickObserver {
  public static int d;
  
  public static String g;
  
  public static String j;
  
  private static final String l = TagGroupFragment.class.getSimpleName();
  
  private List<FilterInfo> A = new ArrayList<FilterInfo>();
  
  private List<FilterInfo> B = new ArrayList<FilterInfo>();
  
  private List<BluedGroupTypeTags> C;
  
  private LinearLayout D;
  
  private SearchView E;
  
  private List<BluedGroupCheck> F;
  
  private LayoutInflater G;
  
  private Bundle H;
  
  private boolean I;
  
  private String J;
  
  List<String> e = new ArrayList<String>();
  
  public BluedGroupCheck.GroupFailureReason f;
  
  int h = 1;
  
  boolean i;
  
  public BluedUIHttpResponse k = new BluedUIHttpResponse<BluedEntityA<BluedGroupLists>>(this) {
      protected void a(BluedEntityA<BluedGroupLists> param1BluedEntityA) {
        if (param1BluedEntityA.data != null && param1BluedEntityA.data.size() > 0) {
          if (param1BluedEntityA.data.size() >= TagGroupFragment.c(this.a)) {
            TagGroupFragment.a(this.a, true);
            TagGroupFragment.b(this.a).o();
          } else {
            TagGroupFragment.a(this.a, false);
            TagGroupFragment.b(this.a).p();
          } 
          if (TagGroupFragment.d(this.a) == 1) {
            TagGroupFragment.e(this.a).clear();
            TagGroupFragment.f(this.a).clear();
          } 
          TagGroupFragment.e(this.a).addAll(param1BluedEntityA.data);
          TagGroupFragment.g(this.a).notifyDataSetChanged();
          return;
        } 
        if (TagGroupFragment.d(this.a) == 1) {
          TagGroupFragment.e(this.a).clear();
          TagGroupFragment.g(this.a).notifyDataSetChanged();
        } 
        if (TagGroupFragment.d(this.a) != 1)
          TagGroupFragment.h(this.a); 
        TagGroupFragment.b(this.a).p();
      }
      
      public void onUIFinish() {
        TagGroupFragment.b(this.a).j();
        TagGroupFragment.b(this.a).q();
      }
    };
  
  private RenrenPullToRefreshPinnedSectionListView m;
  
  private ListView n;
  
  private List<BluedGroupLists> o;
  
  private List<BluedGroupLists> p;
  
  private int q = 1;
  
  private int r = 20;
  
  private boolean s = true;
  
  private GroupListsAdapter t;
  
  private View u;
  
  private Context v;
  
  private LayoutInflater w;
  
  private View x;
  
  private TextView y;
  
  private TextView z;
  
  static {
    d = 0;
    g = "ISNEARBY";
    j = "TAG";
  }
  
  private void a(boolean paramBoolean) {
    if (paramBoolean)
      this.q = 1; 
    if (this.q == 1)
      this.s = true; 
    if (!this.s) {
      int i = this.q;
      if (i != 1) {
        this.q = i - 1;
        AppMethods.a(this.v.getResources().getString(2131756083));
        this.m.j();
        return;
      } 
    } 
    if (!StringUtils.e(this.J)) {
      FragmentActivity fragmentActivity = getActivity();
      BluedUIHttpResponse bluedUIHttpResponse = this.k;
      String str1 = this.J;
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append(this.q);
      stringBuilder1.append("");
      String str2 = stringBuilder1.toString();
      StringBuilder stringBuilder2 = new StringBuilder();
      stringBuilder2.append(this.r);
      stringBuilder2.append("");
      GroupHttpUtils.a((Context)fragmentActivity, bluedUIHttpResponse, str1, "nearby", str2, stringBuilder2.toString(), (IRequestHost)w_());
      return;
    } 
    AppMethods.a(getResources().getString(2131756784));
  }
  
  private void k() {
    this.H = getArguments();
    Bundle bundle = this.H;
    if (bundle != null) {
      this.I = bundle.getBoolean(g);
      this.J = this.H.getString(j);
    } 
    this.w = (LayoutInflater)this.v.getSystemService("layout_inflater");
    d = 0;
    this.x = this.w.inflate(2131493139, null);
    this.y = (TextView)this.x.findViewById(2131301297);
    this.z = (TextView)this.x.findViewById(2131301241);
    this.E = (SearchView)this.x.findViewById(2131297300);
    this.E.setMaskLayerOnClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            TerminalActivity.d(TagGroupFragment.a(this.a), GroupSearchFragment.class, null);
          }
        });
    this.y.setOnClickListener(this);
    this.z.setOnClickListener(this);
    this.D = (LinearLayout)this.x.findViewById(2131298858);
    this.D.setVisibility(8);
  }
  
  private void l() {
    this.G = LayoutInflater.from(this.v);
    this.F = new ArrayList<BluedGroupCheck>();
    this.f = new BluedGroupCheck.GroupFailureReason();
    this.C = new ArrayList<BluedGroupTypeTags>();
    this.o = new ArrayList<BluedGroupLists>();
    this.p = new ArrayList<BluedGroupLists>();
    this.m = (RenrenPullToRefreshPinnedSectionListView)this.u.findViewById(2131299333);
    this.m.setRefreshEnabled(true);
    this.m.postDelayed(new Runnable(this) {
          public void run() {
            TagGroupFragment.b(this.a).k();
          }
        },  100L);
    this.m.setOnPullDownListener(new MyPullDownListener());
    this.n = (ListView)this.m.getRefreshableView();
    this.n.setDivider(null);
    this.n.setSelector((Drawable)new ColorDrawable(0));
    this.n.setOnItemClickListener(new MyOnItemClickListener());
    this.t = new GroupListsAdapter(this.v, (IRequestHost)w_(), this.o);
    this.n.setAdapter((ListAdapter)this.t);
  }
  
  public void a() {
    this.n.smoothScrollToPosition(0);
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
    this.v = (Context)getActivity();
    View view = this.u;
    if (view == null) {
      this.u = paramLayoutInflater.inflate(2131493148, paramViewGroup, false);
      k();
      l();
      CommonTitleDoubleClickObserver.a().a(this);
    } else if (view.getParent() != null) {
      ((ViewGroup)this.u.getParent()).removeView(this.u);
    } 
    return this.u;
  }
  
  public void onDestroy() {
    CommonTitleDoubleClickObserver.a().b(this);
    super.onDestroy();
  }
  
  class MyOnItemClickListener implements AdapterView.OnItemClickListener {
    private MyOnItemClickListener(TagGroupFragment this$0) {}
    
    public void onItemClick(AdapterView<?> param1AdapterView, View param1View, int param1Int, long param1Long) {
      BluedGroupLists bluedGroupLists = TagGroupFragment.e(this.a).get(param1Int - 1);
      if (bluedGroupLists != null) {
        if (bluedGroupLists.is_title == 1)
          return; 
        GroupInfoFragment.a((Fragment)this.a, bluedGroupLists.groups_gid, 100);
      } 
    }
  }
  
  class MyPullDownListener implements RenrenPullToRefreshPinnedSectionListView.OnPullDownListener {
    private MyPullDownListener(TagGroupFragment this$0) {}
    
    public void a() {
      TagGroupFragment.a(this.a, 1);
      TagGroupFragment tagGroupFragment = this.a;
      tagGroupFragment.i = false;
      tagGroupFragment.h = 1;
      TagGroupFragment.b(tagGroupFragment, false);
    }
    
    public void b() {
      TagGroupFragment.i(this.a);
      TagGroupFragment.b(this.a, false);
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\tag_show\TagGroupFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */