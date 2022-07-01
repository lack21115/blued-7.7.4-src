package com.soft.blued.ui.group;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.blued.android.core.AppMethods;
import com.blued.android.core.BlueAppLocal;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.activity.keyboardpage.KeyBoardFragment;
import com.blued.android.framework.activity.keyboardpage.KeyboardListenLinearLayout;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.utils.KeyboardUtils;
import com.blued.android.framework.view.pulltorefresh.RenrenPullToRefreshListView;
import com.blued.android.module.common.utils.DialogUtils;
import com.soft.blued.customview.ActionSheet;
import com.soft.blued.customview.CommonTopTitleNoTrans;
import com.soft.blued.customview.SearchView;
import com.soft.blued.http.GroupHttpUtils;
import com.soft.blued.ui.group.adapter.GroupMemberListAdapter;
import com.soft.blued.ui.group.model.BluedGroupAllMembers;
import com.soft.blued.ui.group.model.BluedGroupMemberForJson;
import com.soft.blued.utils.Logger;
import com.soft.blued.utils.StringUtils;
import com.soft.blued.view.tip.CommonShowBottomWindow;
import java.util.ArrayList;
import java.util.List;

public class GroupMembersListFragment extends KeyBoardFragment implements View.OnClickListener {
  public static List<String> o = new ArrayList<String>();
  
  public static int p = 0;
  
  public static String s;
  
  public static String t;
  
  public static String u;
  
  public static String v;
  
  private Context A;
  
  private EditText B;
  
  private LinearLayout C;
  
  private TextView D;
  
  private TextView E;
  
  private List<BluedGroupMemberForJson> F;
  
  private List<BluedGroupAllMembers> G;
  
  private RenrenPullToRefreshListView H;
  
  private ListView I;
  
  private GroupMemberListAdapter J;
  
  private String[] K;
  
  private String L;
  
  private String[] M = new String[4];
  
  private String[] N = new String[3];
  
  private String[] O = new String[2];
  
  private String P;
  
  private boolean Q;
  
  private LayoutInflater R;
  
  private SearchView S;
  
  private String T = "";
  
  private int U;
  
  private int V = 1;
  
  private final int W = 30;
  
  private String X = "desc";
  
  public Dialog e;
  
  public List<BluedGroupAllMembers> f;
  
  public List<BluedGroupAllMembers> q;
  
  public List<BluedGroupAllMembers> r;
  
  public BluedUIHttpResponse w = new BluedUIHttpResponse<BluedEntityA<BluedGroupMemberForJson>>(this) {
      protected BluedEntityA<BluedGroupMemberForJson> a(String param1String) {
        Logger.a(GroupMembersListFragment.g(this.a), new Object[] { "onSuccess, content:", param1String });
        return (BluedEntityA<BluedGroupMemberForJson>)super.parseData(param1String);
      }
      
      public void a(BluedEntityA<BluedGroupMemberForJson> param1BluedEntityA) {
        if (param1BluedEntityA != null) {
          try {
            if (!GroupMembersListFragment.d(this.a)) {
              if (param1BluedEntityA.extra != null) {
                GroupMembersListFragment.b(this.a, param1BluedEntityA.extra.hasmore);
                if (GroupMembersListFragment.f(this.a) == 1) {
                  GroupMembersListFragment.a(this.a).o();
                } else {
                  GroupMembersListFragment.a(this.a).p();
                } 
              } 
            } else {
              GroupMembersListFragment.a(this.a).p();
            } 
            if (param1BluedEntityA.hasData()) {
              GroupMembersListFragment.h(this.a).clear();
              GroupMembersListFragment.h(this.a).addAll(param1BluedEntityA.data);
              GroupMembersListFragment.i(this.a).clear();
              this.a.f.clear();
              if (((BluedGroupMemberForJson)GroupMembersListFragment.h(this.a).get(0)).members != null)
                GroupMembersListFragment.i(this.a).addAll(((BluedGroupMemberForJson)GroupMembersListFragment.h(this.a).get(0)).members); 
              if (((BluedGroupMemberForJson)GroupMembersListFragment.h(this.a).get(0)).admins != null) {
                this.a.f.addAll(((BluedGroupMemberForJson)GroupMembersListFragment.h(this.a).get(0)).admins);
                GroupMembersListFragment.p = this.a.f.size();
              } 
              this.a.q.clear();
              if (((BluedGroupMemberForJson)GroupMembersListFragment.h(this.a).get(0)).created != null) {
                this.a.q.add(((BluedGroupMemberForJson)GroupMembersListFragment.h(this.a).get(0)).created);
                GroupMembersListFragment.a(this.a, ((BluedGroupMemberForJson)GroupMembersListFragment.h(this.a).get(0)).created.uid);
              } 
              if (((BluedGroupMemberForJson)GroupMembersListFragment.h(this.a).get(0)).admins != null)
                this.a.q.addAll(this.a.f); 
              boolean bool = GroupMembersListFragment.t.equals("1");
              if (bool && GroupMembersListFragment.v.equals("0") && ((BluedGroupMemberForJson)GroupMembersListFragment.h(this.a).get(0)).self != null)
                this.a.q.add(((BluedGroupMemberForJson)GroupMembersListFragment.h(this.a).get(0)).self); 
              this.a.q.addAll(GroupMembersListFragment.i(this.a));
              if (((BluedGroupMemberForJson)GroupMembersListFragment.h(this.a).get(0)).admins != null)
                for (int j = 0; j < ((BluedGroupMemberForJson)GroupMembersListFragment.h(this.a).get(0)).admins.size(); j++) {
                  for (int k = 0; k < this.a.q.size(); k++) {
                    if (((BluedGroupAllMembers)((BluedGroupMemberForJson)GroupMembersListFragment.h(this.a).get(0)).admins.get(j)).uid.equals(((BluedGroupAllMembers)this.a.q.get(k)).uid))
                      ((BluedGroupAllMembers)this.a.q.get(k)).is_admin = "1"; 
                  } 
                }  
            } else {
              if (GroupMembersListFragment.k(this.a) == 1) {
                this.a.q.clear();
                GroupMembersListFragment.c(this.a).a(this.a.q);
                return;
              } 
              GroupMembersListFragment.l(this.a);
              return;
            } 
          } catch (Exception exception) {
            exception.printStackTrace();
            AppMethods.a(GroupMembersListFragment.m(this.a).getResources().getString(2131756082));
            if (GroupMembersListFragment.k(this.a) != 1)
              GroupMembersListFragment.l(this.a); 
            return;
          } 
        } else {
          return;
        } 
        int i;
        for (i = 0; i < this.a.q.size(); i++) {
          if (GroupMembersListFragment.j(this.a).equals(((BluedGroupAllMembers)this.a.q.get(i)).uid)) {
            ((BluedGroupAllMembers)this.a.q.get(i)).is_creator = "1";
          } else {
            ((BluedGroupAllMembers)this.a.q.get(i)).is_creator = "0";
          } 
        } 
        for (i = 0; i < this.a.q.size(); i++) {
          ((BluedGroupAllMembers)this.a.q.get(i)).height = StringUtils.a(((BluedGroupAllMembers)this.a.q.get(i)).height, BlueAppLocal.c(), false);
          ((BluedGroupAllMembers)this.a.q.get(i)).weight = StringUtils.b(((BluedGroupAllMembers)this.a.q.get(i)).weight, BlueAppLocal.c(), false);
        } 
        if (GroupMembersListFragment.d(this.a)) {
          GroupMembersListFragment.c(this.a).a();
        } else if (GroupMembersListFragment.k(this.a) == 1) {
          GroupMembersListFragment.c(this.a).a();
        } 
        GroupMembersListFragment.c(this.a).a(this.a.q);
      }
      
      public void onFailure(Throwable param1Throwable, int param1Int, String param1String) {
        if (GroupMembersListFragment.k(this.a) != 1)
          GroupMembersListFragment.l(this.a); 
        super.onFailure(param1Throwable, param1Int, param1String);
        Logger.a(GroupMembersListFragment.g(this.a), new Object[] { "onFailure, error:", param1Throwable });
      }
      
      public void onUIFinish() {
        Logger.a(GroupMembersListFragment.g(this.a), new Object[] { "onUIFinish" });
        GroupMembersListFragment.a(this.a).j();
        GroupMembersListFragment.a(this.a).q();
      }
    };
  
  public BluedUIHttpResponse x = new BluedUIHttpResponse<BluedEntityA<Object>>(this) {
      protected BluedEntityA<Object> a(String param1String) {
        Logger.a(GroupMembersListFragment.g(this.a), new Object[] { "onSuccess, content:", param1String });
        return (BluedEntityA<Object>)super.parseData(param1String);
      }
      
      public void a(BluedEntityA<Object> param1BluedEntityA) {
        if (param1BluedEntityA != null)
          try {
            if (param1BluedEntityA.data != null) {
              AppMethods.d(2131756775);
              GroupMembersListFragment.s = String.valueOf(StringUtils.c(GroupMembersListFragment.s) - GroupMembersListFragment.o.size());
              for (int i = 0;; i++) {
                if (i < this.a.q.size()) {
                  for (int j = 0; j < (GroupMembersListFragment.n(this.a)).length; j++) {
                    if (((BluedGroupAllMembers)this.a.q.get(i)).uid.equals(GroupMembersListFragment.n(this.a)[j])) {
                      this.a.q.remove(this.a.q.get(i));
                      GroupMembersListFragment.o.clear();
                    } 
                  } 
                } else {
                  if (GroupMembersListFragment.d(this.a)) {
                    this.a.u();
                  } else {
                    this.a.t();
                  } 
                  GroupMembersListFragment.o(this.a).setVisibility(8);
                  (GroupMembersListFragment.c(this.a)).a = false;
                  GroupMembersListFragment.p(this.a).setText(GroupMembersListFragment.m(this.a).getResources().getString(2131755726));
                  GroupMembersListFragment.c(this.a).notifyDataSetChanged();
                  return;
                } 
              } 
            } 
          } catch (Exception exception) {
            exception.printStackTrace();
          }  
      }
      
      public void onFailure(Throwable param1Throwable, int param1Int, String param1String) {
        super.onFailure(param1Throwable, param1Int, param1String);
        Logger.a(GroupMembersListFragment.g(this.a), new Object[] { "onFailure, error:", param1Throwable });
      }
      
      public void onUIFinish() {
        Logger.a(GroupMembersListFragment.g(this.a), new Object[] { "onUIFinish" });
        DialogUtils.b(this.a.e);
      }
      
      public void onUIStart() {
        DialogUtils.a(this.a.e);
      }
    };
  
  private String y = GroupMembersListFragment.class.getSimpleName();
  
  private KeyboardListenLinearLayout z;
  
  private void v() {
    this.M[0] = this.A.getResources().getString(2131756715);
    this.M[1] = this.A.getResources().getString(2131756714);
    this.M[2] = this.A.getResources().getString(2131756712);
    this.M[3] = this.A.getResources().getString(2131756713);
    this.N[0] = this.A.getResources().getString(2131756715);
    this.N[1] = this.A.getResources().getString(2131756714);
    this.N[2] = this.A.getResources().getString(2131756712);
    this.O[0] = this.A.getResources().getString(2131756715);
    this.O[1] = this.A.getResources().getString(2131756714);
  }
  
  private void w() {
    this.e = DialogUtils.a(this.A);
    this.F = new ArrayList<BluedGroupMemberForJson>();
    this.G = new ArrayList<BluedGroupAllMembers>();
    this.f = new ArrayList<BluedGroupAllMembers>();
    this.q = new ArrayList<BluedGroupAllMembers>();
    this.r = new ArrayList<BluedGroupAllMembers>();
    this.H = (RenrenPullToRefreshListView)this.z.findViewById(2131299762);
    this.H.setRefreshEnabled(true);
    this.H.postDelayed(new Runnable(this) {
          public void run() {
            GroupMembersListFragment.a(this.a).k();
          }
        },  100L);
    this.H.setOnPullDownListener(new MyPullDownListener());
    this.I = (ListView)this.H.getRefreshableView();
    this.I.setDivider(null);
    this.I.setSelector((Drawable)new ColorDrawable(0));
    this.C = (LinearLayout)this.z.findViewById(2131298846);
    this.D = (TextView)this.z.findViewById(2131301037);
    this.E = (TextView)this.z.findViewById(2131301036);
    this.E.setOnClickListener(this);
    Bundle bundle = getArguments();
    if (bundle == null)
      return; 
    s = bundle.getString("membersCount");
    this.L = bundle.getString("gid");
    t = bundle.getString("member");
    u = bundle.getString("admin");
    v = bundle.getString("creator");
    this.T = bundle.getString("group_info_json");
    o.clear();
    TextView textView = this.D;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(" (");
    stringBuilder.append(o.size());
    stringBuilder.append("/");
    stringBuilder.append(s);
    stringBuilder.append(") ");
    textView.setText(stringBuilder.toString());
    this.J = new GroupMemberListAdapter(this.A, (IRequestHost)w_(), this.r, this.D, this.E);
  }
  
  private void x() {
    CommonTopTitleNoTrans commonTopTitleNoTrans = (CommonTopTitleNoTrans)this.z.findViewById(2131300300);
    commonTopTitleNoTrans.setCenterText(2131756707);
    commonTopTitleNoTrans.setRightImg(2131232753);
    commonTopTitleNoTrans.setLeftClickListener(this);
    commonTopTitleNoTrans.setRightClickListener(this);
    ((TextView)commonTopTitleNoTrans.findViewById(2131296857)).setOnTouchListener(new CommonOnDoubleClick(this));
  }
  
  private void y() {
    this.R = (LayoutInflater)this.A.getSystemService("layout_inflater");
    this.S = (SearchView)this.R.inflate(2131494102, (ViewGroup)this.I, false);
    this.B = (EditText)this.S.getEditView();
    this.B.setHint(2131756711);
    this.S.setDelaymillis(0L);
    this.S.setOnSearchInfoListener(new SearchView.OnSearchInfoListener(this) {
          public void a() {
            KeyboardUtils.a((Activity)this.a.getActivity());
            GroupMembersListFragment.a(this.a, false);
            this.a.q.clear();
            GroupMembersListFragment.c(this.a).notifyDataSetChanged();
          }
          
          public void a(String param1String) {
            if (!StringUtils.e(param1String)) {
              this.a.u();
              GroupMembersListFragment.a(this.a, true);
              return;
            } 
            this.a.t();
            GroupMembersListFragment.a(this.a, false);
          }
          
          public void b() {}
        });
    this.I.addHeaderView((View)this.S);
    this.I.setAdapter((ListAdapter)this.J);
  }
  
  public boolean V_() {
    getActivity().setResult(-1);
    getActivity().finish();
    return false;
  }
  
  public void e_(int paramInt) {
    if (paramInt != -3) {
      if (paramInt != -2)
        return; 
      SearchView searchView = this.S;
      if (searchView != null) {
        searchView.a(false);
        return;
      } 
    } else {
      SearchView searchView = this.S;
      if (searchView != null)
        searchView.a(true); 
    } 
  }
  
  public void onClick(View paramView) {
    int i = paramView.getId();
    if (i != 2131296863) {
      if (i != 2131296867) {
        if (i != 2131301036)
          return; 
        this.K = new String[o.size()];
        this.K = o.<String>toArray(this.K);
        if (this.K.length != 0) {
          GroupHttpUtils.a((Context)getActivity(), this.x, this.L, this.K, (IRequestHost)w_());
        } else {
          this.C.setVisibility(8);
          this.J.a = false;
        } 
        this.J.notifyDataSetChanged();
        return;
      } 
      if (this.q.size() > 0) {
        if (t.equals("1")) {
          if (v.equals("1") || u.equals("1")) {
            CommonShowBottomWindow.a(getActivity(), this.M, new ActionSheet.ActionSheetListener(this) {
                  public void a(ActionSheet param1ActionSheet, int param1Int) {
                    if (param1Int == 0) {
                      if (!StringUtils.e(GroupMembersListFragment.q(this.a))) {
                        if (GroupMembersListFragment.d(this.a)) {
                          GroupHttpUtils.b(GroupMembersListFragment.m(this.a), this.a.w, GroupMembersListFragment.q(this.a), GroupMembersListFragment.r(this.a).getText().toString(), "desc", (IRequestHost)this.a.w_());
                          return;
                        } 
                        GroupMembersListFragment.a(this.a, 1);
                        GroupMembersListFragment.b(this.a, "desc");
                        GroupMembersListFragment.a(this.a).k();
                        return;
                      } 
                    } else if (param1Int == 1) {
                      if (!StringUtils.e(GroupMembersListFragment.q(this.a))) {
                        if (GroupMembersListFragment.d(this.a)) {
                          GroupHttpUtils.b(GroupMembersListFragment.m(this.a), this.a.w, GroupMembersListFragment.q(this.a), GroupMembersListFragment.r(this.a).getText().toString(), "asc", (IRequestHost)this.a.w_());
                          return;
                        } 
                        GroupMembersListFragment.a(this.a, 1);
                        GroupMembersListFragment.b(this.a, "asc");
                        GroupMembersListFragment.a(this.a).k();
                        return;
                      } 
                    } else {
                      if (param1Int == 2) {
                        GroupMemberInviteFragment.a(GroupMembersListFragment.m(this.a), GroupMembersListFragment.s(this.a));
                        return;
                      } 
                      GroupMembersListFragment.o(this.a).setVisibility(0);
                      TextView textView = GroupMembersListFragment.t(this.a);
                      StringBuilder stringBuilder = new StringBuilder();
                      stringBuilder.append(" (");
                      stringBuilder.append(GroupMembersListFragment.o.size());
                      stringBuilder.append("/");
                      stringBuilder.append(GroupMembersListFragment.s);
                      stringBuilder.append(") ");
                      textView.setText(stringBuilder.toString());
                      (GroupMembersListFragment.c(this.a)).a = true;
                      GroupMembersListFragment.c(this.a).notifyDataSetChanged();
                    } 
                  }
                  
                  public void a(ActionSheet param1ActionSheet, boolean param1Boolean) {}
                });
            return;
          } 
          CommonShowBottomWindow.a(getActivity(), this.O, new ActionSheet.ActionSheetListener(this) {
                public void a(ActionSheet param1ActionSheet, int param1Int) {
                  if (param1Int == 0) {
                    if (!StringUtils.e(GroupMembersListFragment.q(this.a))) {
                      if (GroupMembersListFragment.d(this.a)) {
                        GroupHttpUtils.b(GroupMembersListFragment.m(this.a), this.a.w, GroupMembersListFragment.q(this.a), GroupMembersListFragment.r(this.a).getText().toString(), "desc", (IRequestHost)this.a.w_());
                        return;
                      } 
                      GroupMembersListFragment.a(this.a, 1);
                      GroupMembersListFragment.b(this.a, "desc");
                      GroupMembersListFragment.a(this.a).k();
                      return;
                    } 
                  } else if (param1Int == 1 && !StringUtils.e(GroupMembersListFragment.q(this.a))) {
                    if (GroupMembersListFragment.d(this.a)) {
                      GroupHttpUtils.b(GroupMembersListFragment.m(this.a), this.a.w, GroupMembersListFragment.q(this.a), GroupMembersListFragment.r(this.a).getText().toString(), "asc", (IRequestHost)this.a.w_());
                      return;
                    } 
                    GroupMembersListFragment.a(this.a, 1);
                    GroupMembersListFragment.b(this.a, "asc");
                    GroupMembersListFragment.a(this.a).k();
                  } 
                }
                
                public void a(ActionSheet param1ActionSheet, boolean param1Boolean) {}
              });
          return;
        } 
        CommonShowBottomWindow.a(getActivity(), this.O, new ActionSheet.ActionSheetListener(this) {
              public void a(ActionSheet param1ActionSheet, int param1Int) {
                if (param1Int == 0) {
                  if (!StringUtils.e(GroupMembersListFragment.q(this.a))) {
                    if (GroupMembersListFragment.d(this.a)) {
                      GroupHttpUtils.b(GroupMembersListFragment.m(this.a), this.a.w, GroupMembersListFragment.q(this.a), GroupMembersListFragment.r(this.a).getText().toString(), "desc", (IRequestHost)this.a.w_());
                      return;
                    } 
                    GroupMembersListFragment.a(this.a, 1);
                    GroupMembersListFragment.b(this.a, "desc");
                    GroupMembersListFragment.a(this.a).k();
                    return;
                  } 
                } else if (!StringUtils.e(GroupMembersListFragment.q(this.a))) {
                  if (GroupMembersListFragment.d(this.a)) {
                    GroupHttpUtils.b(GroupMembersListFragment.m(this.a), this.a.w, GroupMembersListFragment.q(this.a), GroupMembersListFragment.r(this.a).getText().toString(), "asc", (IRequestHost)this.a.w_());
                    return;
                  } 
                  GroupMembersListFragment.a(this.a, 1);
                  GroupMembersListFragment.b(this.a, "asc");
                  GroupMembersListFragment.a(this.a).k();
                } 
              }
              
              public void a(ActionSheet param1ActionSheet, boolean param1Boolean) {}
            });
        return;
      } 
    } else {
      getActivity().setResult(-1);
      getActivity().finish();
    } 
  }
  
  public void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
    this.A = (Context)getActivity();
    KeyboardListenLinearLayout keyboardListenLinearLayout = this.z;
    if (keyboardListenLinearLayout == null) {
      this.z = (KeyboardListenLinearLayout)paramLayoutInflater.inflate(2131493141, paramViewGroup, false);
      a(this.z);
      w();
      y();
      x();
      v();
    } else if (keyboardListenLinearLayout.getParent() != null) {
      ((ViewGroup)this.z.getParent()).removeView((View)this.z);
    } 
    return (View)this.z;
  }
  
  public void t() {
    if (!StringUtils.e(this.L)) {
      Context context = this.A;
      BluedUIHttpResponse bluedUIHttpResponse = this.w;
      String str1 = this.L;
      String str2 = this.X;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(this.V);
      stringBuilder.append("");
      GroupHttpUtils.c(context, bluedUIHttpResponse, str1, str2, stringBuilder.toString(), "30", "", (IRequestHost)w_());
    } 
  }
  
  public void u() {
    if (!StringUtils.e(this.L))
      GroupHttpUtils.b(this.A, this.w, this.L, this.B.getText().toString(), "desc", (IRequestHost)w_()); 
  }
  
  class CommonOnDoubleClick implements View.OnTouchListener {
    int a = 0;
    
    int b = 0;
    
    int c = 0;
    
    CommonOnDoubleClick(GroupMembersListFragment this$0) {}
    
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
          GroupMembersListFragment.b(this.d).smoothScrollToPosition(0); 
        this.a = 0;
        this.b = 0;
        this.c = 0;
      } 
      return true;
    }
  }
  
  class MyPullDownListener implements RenrenPullToRefreshListView.OnPullDownListener {
    private MyPullDownListener(GroupMembersListFragment this$0) {}
    
    public void a() {
      GroupMembersListFragment.a(this.a, 1);
      if (GroupMembersListFragment.d(this.a)) {
        this.a.u();
        return;
      } 
      this.a.t();
    }
    
    public void b() {
      GroupMembersListFragment.e(this.a);
      if (!GroupMembersListFragment.d(this.a) && GroupMembersListFragment.f(this.a) == 1)
        this.a.t(); 
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\group\GroupMembersListFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */