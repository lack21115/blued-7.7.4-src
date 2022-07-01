package com.soft.blued.ui.group;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.blued.android.core.AppMethods;
import com.blued.android.core.BlueAppLocal;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.view.pulltorefresh.RenrenPullToRefreshListView;
import com.soft.blued.customview.CommonTopTitleNoTrans;
import com.soft.blued.customview.SearchView;
import com.soft.blued.http.GroupHttpUtils;
import com.soft.blued.ui.group.adapter.GroupAdminSelectAdapter;
import com.soft.blued.ui.group.model.BluedGroupAllMembers;
import com.soft.blued.ui.group.model.BluedGroupMemberForJson;
import com.soft.blued.user.UserInfo;
import com.soft.blued.utils.Logger;
import com.soft.blued.utils.StringUtils;
import java.util.ArrayList;
import java.util.List;

public class GroupAdminSelectFragment extends BaseFragment implements View.OnClickListener {
  public static int d;
  
  public BluedUIHttpResponse e = new BluedUIHttpResponse<BluedEntityA<BluedGroupMemberForJson>>(this) {
      protected BluedEntityA<BluedGroupMemberForJson> a(String param1String) {
        Logger.a(GroupAdminSelectFragment.h(this.a), new Object[] { "onSuccess, content:", param1String });
        return (BluedEntityA<BluedGroupMemberForJson>)super.parseData(param1String);
      }
      
      public void a(BluedEntityA<BluedGroupMemberForJson> param1BluedEntityA) {
        if (param1BluedEntityA != null) {
          try {
            if (!GroupAdminSelectFragment.e(this.a)) {
              if (param1BluedEntityA.extra != null) {
                GroupAdminSelectFragment.b(this.a, param1BluedEntityA.extra.hasmore);
                if (GroupAdminSelectFragment.g(this.a) == 1) {
                  GroupAdminSelectFragment.a(this.a).o();
                } else {
                  GroupAdminSelectFragment.a(this.a).p();
                } 
              } 
            } else {
              GroupAdminSelectFragment.a(this.a).p();
            } 
            if (param1BluedEntityA.hasData()) {
              GroupAdminSelectFragment.i(this.a).clear();
              GroupAdminSelectFragment.i(this.a).addAll(param1BluedEntityA.data);
              if (GroupAdminSelectFragment.j(this.a) == 1)
                GroupAdminSelectFragment.c(this.a).clear(); 
              if (((BluedGroupMemberForJson)GroupAdminSelectFragment.i(this.a).get(0)).members != null)
                GroupAdminSelectFragment.c(this.a).addAll(((BluedGroupMemberForJson)GroupAdminSelectFragment.i(this.a).get(0)).members); 
              int j = GroupAdminSelectFragment.c(this.a).size();
              if (GroupAdminSelectFragment.e(this.a) && GroupAdminSelectFragment.c(this.a) != null)
                for (int k = 0; k < j; k++) {
                  if (((BluedGroupAllMembers)GroupAdminSelectFragment.c(this.a).get(k)).is_admin.equals("1") || ((BluedGroupAllMembers)GroupAdminSelectFragment.c(this.a).get(k)).uid.equals(UserInfo.a().i().getUid()))
                    GroupAdminSelectFragment.c(this.a).remove(k); 
                }  
            } else {
              if (GroupAdminSelectFragment.j(this.a) == 1) {
                GroupAdminSelectFragment.c(this.a).clear();
                GroupAdminSelectFragment.d(this.a).a(GroupAdminSelectFragment.c(this.a));
              } else {
                GroupAdminSelectFragment.k(this.a);
              } 
              AppMethods.a(GroupAdminSelectFragment.l(this.a).getResources().getString(2131756083));
              return;
            } 
          } catch (Exception exception) {
            exception.printStackTrace();
            AppMethods.a(GroupAdminSelectFragment.l(this.a).getResources().getString(2131756082));
            if (GroupAdminSelectFragment.j(this.a) != 1)
              GroupAdminSelectFragment.k(this.a); 
            return;
          } 
        } else {
          return;
        } 
        int i;
        for (i = 0; i < GroupAdminSelectFragment.c(this.a).size(); i++) {
          ((BluedGroupAllMembers)GroupAdminSelectFragment.c(this.a).get(i)).height = StringUtils.a(((BluedGroupAllMembers)GroupAdminSelectFragment.c(this.a).get(i)).height, BlueAppLocal.c(), false);
          ((BluedGroupAllMembers)GroupAdminSelectFragment.c(this.a).get(i)).weight = StringUtils.b(((BluedGroupAllMembers)GroupAdminSelectFragment.c(this.a).get(i)).weight, BlueAppLocal.c(), false);
        } 
        if (GroupAdminSelectFragment.e(this.a)) {
          GroupAdminSelectFragment.d(this.a).a();
        } else {
          GroupAdminSelectFragment.d(this.a).a();
        } 
        GroupAdminSelectFragment.d(this.a).a(GroupAdminSelectFragment.c(this.a));
      }
      
      public void onFailure(Throwable param1Throwable, int param1Int, String param1String) {
        if (GroupAdminSelectFragment.j(this.a) != 1)
          GroupAdminSelectFragment.k(this.a); 
        super.onFailure(param1Throwable, param1Int, param1String);
        Logger.a(GroupAdminSelectFragment.h(this.a), new Object[] { "onFailure, error:", param1Throwable });
      }
      
      public void onUIFinish() {
        Logger.a(GroupAdminSelectFragment.h(this.a), new Object[] { "onUIFinish" });
        GroupAdminSelectFragment.a(this.a).j();
        GroupAdminSelectFragment.a(this.a).q();
      }
    };
  
  private String f = GroupAdminSelectFragment.class.getSimpleName();
  
  private View g;
  
  private Context h;
  
  private EditText i;
  
  private LinearLayout j;
  
  private TextView k;
  
  private TextView l;
  
  private List<BluedGroupMemberForJson> m;
  
  private List<BluedGroupAllMembers> n;
  
  private List<BluedGroupAllMembers> o;
  
  private RenrenPullToRefreshListView p;
  
  private ListView q;
  
  private GroupAdminSelectAdapter r;
  
  private String s;
  
  private boolean t;
  
  private LayoutInflater u;
  
  private SearchView v;
  
  private int w = 1;
  
  private int x;
  
  private Runnable y;
  
  private String z;
  
  private void a(String paramString) {
    if (!TextUtils.isEmpty(paramString) && !paramString.equals(this.z)) {
      this.i.removeCallbacks(this.y);
      this.y = new Runnable(this) {
          public void run() {
            this.a.k();
          }
        };
      this.i.postDelayed(this.y, 500L);
    } 
  }
  
  private void l() {
    this.m = new ArrayList<BluedGroupMemberForJson>();
    this.n = new ArrayList<BluedGroupAllMembers>();
    this.p = (RenrenPullToRefreshListView)this.g.findViewById(2131299762);
    this.p.setRefreshEnabled(true);
    this.p.postDelayed(new Runnable(this) {
          public void run() {
            GroupAdminSelectFragment.a(this.a).k();
          }
        },  100L);
    this.p.setOnPullDownListener(new MyPullDownListener());
    this.q = (ListView)this.p.getRefreshableView();
    this.q.setDivider(null);
    this.q.setSelector((Drawable)new ColorDrawable(0));
    this.q.setOnItemClickListener(new MyOnItemClickListener());
    this.j = (LinearLayout)this.g.findViewById(2131298846);
    this.k = (TextView)this.g.findViewById(2131301037);
    this.l = (TextView)this.g.findViewById(2131301036);
    this.l.setOnClickListener(this);
    Bundle bundle = getArguments();
    if (bundle == null)
      return; 
    this.s = bundle.getString("gid");
    this.o = new ArrayList<BluedGroupAllMembers>();
    this.r = new GroupAdminSelectAdapter(this.h, (IRequestHost)w_(), this.o);
    this.q.addHeaderView((View)this.v);
    this.q.setAdapter((ListAdapter)this.r);
  }
  
  private void m() {
    CommonTopTitleNoTrans commonTopTitleNoTrans = (CommonTopTitleNoTrans)this.g.findViewById(2131300300);
    commonTopTitleNoTrans.a();
    commonTopTitleNoTrans.setCenterText(getString(2131756633));
    commonTopTitleNoTrans.setLeftClickListener(this);
    ((TextView)commonTopTitleNoTrans.findViewById(2131296857)).setOnTouchListener(new CommonOnDoubleClick(this));
  }
  
  private void n() {
    this.u = (LayoutInflater)this.h.getSystemService("layout_inflater");
    this.v = (SearchView)this.u.inflate(2131494102, null);
    this.i = (EditText)this.v.getEditView();
    this.i.setHint(2131756711);
    this.v.setDelaymillis(0L);
    this.v.setOnSearchInfoListener(new SearchView.OnSearchInfoListener(this) {
          public void a() {
            GroupAdminSelectFragment.a(this.a, false);
            GroupAdminSelectFragment.c(this.a).clear();
            GroupAdminSelectFragment.d(this.a).notifyDataSetChanged();
          }
          
          public void a(String param1String) {
            if (!StringUtils.e(param1String)) {
              GroupAdminSelectFragment.a(this.a, param1String);
              GroupAdminSelectFragment.a(this.a, true);
              return;
            } 
            this.a.a();
            GroupAdminSelectFragment.a(this.a, false);
          }
          
          public void b() {}
        });
  }
  
  public boolean V_() {
    getActivity().setResult(-1);
    getActivity().finish();
    return false;
  }
  
  public void a() {
    if (!StringUtils.e(this.s)) {
      Context context = this.h;
      BluedUIHttpResponse bluedUIHttpResponse = this.e;
      String str = this.s;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(this.w);
      stringBuilder.append("");
      GroupHttpUtils.c(context, bluedUIHttpResponse, str, "desc", stringBuilder.toString(), "", "", (IRequestHost)w_());
    } 
  }
  
  public void k() {
    if (!StringUtils.e(this.s))
      GroupHttpUtils.b(this.h, this.e, this.s, this.i.getText().toString(), "desc", (IRequestHost)w_()); 
  }
  
  public void onClick(View paramView) {
    if (paramView.getId() != 2131296863)
      return; 
    getActivity().setResult(-1);
    getActivity().finish();
  }
  
  public void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
    this.h = (Context)getActivity();
    View view = this.g;
    if (view == null) {
      this.g = paramLayoutInflater.inflate(2131493141, paramViewGroup, false);
      n();
      l();
      m();
      a();
    } else if (view.getParent() != null) {
      ((ViewGroup)this.g.getParent()).removeView(this.g);
    } 
    return this.g;
  }
  
  class CommonOnDoubleClick implements View.OnTouchListener {
    int a = 0;
    
    int b = 0;
    
    int c = 0;
    
    CommonOnDoubleClick(GroupAdminSelectFragment this$0) {}
    
    public boolean onTouch(View param1View, MotionEvent param1MotionEvent) {
      int i = param1MotionEvent.getAction();
      if (i != 0) {
        if (i != 1)
          return true; 
        param1View.performClick();
        return true;
      } 
      i = ++this.a;
      if (i == 1) {
        this.b = (int)System.currentTimeMillis();
        return true;
      } 
      if (i == 2) {
        this.c = (int)System.currentTimeMillis();
        if (this.c - this.b < 1000)
          GroupAdminSelectFragment.b(this.d).smoothScrollToPosition(0); 
        this.a = 0;
        this.b = 0;
        this.c = 0;
      } 
      return true;
    }
  }
  
  class MyOnItemClickListener implements AdapterView.OnItemClickListener {
    private MyOnItemClickListener(GroupAdminSelectFragment this$0) {}
    
    public void onItemClick(AdapterView<?> param1AdapterView, View param1View, int param1Int, long param1Long) {
      if (param1Int > 1) {
        String str;
        if (param1Int > GroupAdminSelectFragment.c(this.a).size() + 2)
          return; 
        param1AdapterView = null;
        List list = GroupAdminSelectFragment.c(this.a);
        param1Int -= 2;
        if (!StringUtils.e(((BluedGroupAllMembers)list.get(param1Int)).uid))
          str = ((BluedGroupAllMembers)GroupAdminSelectFragment.c(this.a).get(param1Int)).uid; 
        Intent intent = new Intent();
        intent.putExtra("uid", str);
        this.a.getActivity().setResult(-1, intent);
        this.a.getActivity().finish();
      } 
    }
  }
  
  class MyPullDownListener implements RenrenPullToRefreshListView.OnPullDownListener {
    private MyPullDownListener(GroupAdminSelectFragment this$0) {}
    
    public void a() {
      GroupAdminSelectFragment.a(this.a, 1);
      if (GroupAdminSelectFragment.e(this.a)) {
        this.a.k();
        return;
      } 
      this.a.a();
    }
    
    public void b() {
      GroupAdminSelectFragment.f(this.a);
      if (!GroupAdminSelectFragment.e(this.a) && GroupAdminSelectFragment.g(this.a) == 1)
        this.a.a(); 
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\group\GroupAdminSelectFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */