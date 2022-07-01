package com.soft.blued.ui.group;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.blued.android.core.AppMethods;
import com.blued.android.core.BlueAppLocal;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.module.common.utils.DialogUtils;
import com.soft.blued.customview.CommonTopTitleNoTrans;
import com.soft.blued.http.GroupHttpUtils;
import com.soft.blued.ui.group.adapter.GroupAdminSetAdapter;
import com.soft.blued.ui.group.model.BluedGroupAdminLists;
import com.soft.blued.utils.StringUtils;
import java.util.ArrayList;
import java.util.List;

public class GroupAdminSetFragment extends BaseFragment implements View.OnClickListener {
  public static String e;
  
  public static String f;
  
  public static String g;
  
  public List<BluedGroupAdminLists> d;
  
  public BluedUIHttpResponse h = new BluedUIHttpResponse<BluedEntityA<BluedGroupAdminLists>>(this) {
      protected void a(BluedEntityA<BluedGroupAdminLists> param1BluedEntityA) {
        if (param1BluedEntityA != null)
          try {
            if (param1BluedEntityA.data != null) {
              GroupAdminSetFragment.b(this.a).setVisibility(0);
              this.a.d.clear();
              this.a.d.addAll(param1BluedEntityA.data);
              for (int i = 0; i < this.a.d.size(); i++) {
                ((BluedGroupAdminLists)this.a.d.get(i)).users_height = StringUtils.a(((BluedGroupAdminLists)this.a.d.get(i)).users_height, BlueAppLocal.c(), false);
                ((BluedGroupAdminLists)this.a.d.get(i)).users_weight = StringUtils.b(((BluedGroupAdminLists)this.a.d.get(i)).users_weight, BlueAppLocal.c(), false);
              } 
              GroupAdminSetFragment.c(this.a).notifyDataSetChanged();
              TextView textView = GroupAdminSetFragment.d(this.a);
              StringBuilder stringBuilder = new StringBuilder();
              stringBuilder.append("(");
              stringBuilder.append(this.a.d.size());
              stringBuilder.append("/");
              stringBuilder.append(GroupAdminSetFragment.f);
              stringBuilder.append(")");
              textView.setText(stringBuilder.toString());
              if (this.a.d.size() == StringUtils.c(GroupAdminSetFragment.f)) {
                GroupAdminSetFragment.e(this.a).setClickable(false);
                GroupAdminSetFragment.f(this.a).setImageResource(2131232520);
                GroupAdminSetFragment.g(this.a).setTextColor(this.a.getResources().getColor(2131100325));
                return;
              } 
            } 
          } catch (Exception exception) {
            exception.printStackTrace();
          }  
      }
      
      public void onUIFinish() {
        super.onUIFinish();
        DialogUtils.b(GroupAdminSetFragment.a(this.a));
      }
      
      public void onUIStart() {
        super.onUIStart();
        DialogUtils.a(GroupAdminSetFragment.a(this.a));
      }
    };
  
  public BluedUIHttpResponse i = new BluedUIHttpResponse<BluedEntity>(this) {
      public void onUIFinish() {
        super.onUIFinish();
        DialogUtils.b(GroupAdminSetFragment.a(this.a));
      }
      
      public void onUIStart() {
        super.onUIStart();
        DialogUtils.a(GroupAdminSetFragment.a(this.a));
      }
      
      public void onUIUpdate(BluedEntity param1BluedEntity) {
        AppMethods.d(2131756623);
        if ((GroupAdminSetFragment.c(this.a)).a) {
          GroupAdminSetFragment.h(this.a).setRightText(this.a.getString(2131756206));
        } else {
          GroupAdminSetFragment.h(this.a).setRightText(this.a.getString(2131756632));
        } 
        this.a.k();
      }
    };
  
  private String j = GroupAdminSetFragment.class.getSimpleName();
  
  private View k;
  
  private Context l;
  
  private ListView m;
  
  private GroupAdminSetAdapter n;
  
  private Dialog o;
  
  private LinearLayout p;
  
  private ImageView q;
  
  private TextView r;
  
  private LinearLayout s;
  
  private TextView t;
  
  private CommonTopTitleNoTrans u;
  
  private void l() {
    this.u = (CommonTopTitleNoTrans)this.k.findViewById(2131300300);
    this.u.a();
    this.u.setCenterText(getString(2131756620));
    if (!StringUtils.e(g))
      if (g.equals("0")) {
        this.u.a();
      } else {
        this.u.setRightText(getString(2131756632));
      }  
    this.u.setRightClickListener(this);
    this.u.setLeftClickListener(this);
  }
  
  private void m() {
    this.o = DialogUtils.a(this.l);
    View view = ((LayoutInflater)this.l.getSystemService("layout_inflater")).inflate(2131493536, null);
    this.p = (LinearLayout)view.findViewById(2131298832);
    this.q = (ImageView)view.findViewById(2131300907);
    this.r = (TextView)view.findViewById(2131300816);
    this.p.setOnClickListener(this);
    this.s = (LinearLayout)this.k.findViewById(2131298831);
    this.t = (TextView)this.k.findViewById(2131300815);
    this.d = new ArrayList<BluedGroupAdminLists>();
    this.m = (ListView)this.k.findViewById(2131299182);
    TextView textView = this.t;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("(");
    stringBuilder.append(g);
    stringBuilder.append("/");
    stringBuilder.append(f);
    stringBuilder.append(")");
    textView.setText(stringBuilder.toString());
    if (!StringUtils.e(f) && g.equals(f)) {
      this.p.setClickable(false);
      this.q.setImageResource(2131232521);
      this.r.setTextColor(getResources().getColor(2131100325));
    } 
    this.n = new GroupAdminSetAdapter(this.l, this.d, this.m, this.t, this.p, this.q, this.r, this.u.findViewById(2131296867), (IRequestHost)w_());
    this.m.addFooterView(view);
    this.m.setAdapter((ListAdapter)this.n);
  }
  
  private void n() {
    getActivity().setResult(-1);
    getActivity().finish();
  }
  
  public boolean V_() {
    n();
    return super.V_();
  }
  
  public void a() {
    Bundle bundle = getArguments();
    if (bundle == null)
      return; 
    e = bundle.getString("gid");
    f = bundle.getString("admin_total");
    g = bundle.getString("admin_amount");
  }
  
  public void k() {
    if (!StringUtils.e(e))
      GroupHttpUtils.h(this.l, this.h, e, (IRequestHost)w_()); 
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {
    if (paramInt2 == -1 && paramInt1 == 100 && paramIntent != null && !StringUtils.e(paramIntent.getStringExtra("uid")))
      GroupHttpUtils.g(this.l, this.i, e, paramIntent.getStringExtra("uid"), (IRequestHost)w_()); 
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public void onClick(View paramView) {
    int i = paramView.getId();
    if (i != 2131296863) {
      if (i != 2131296867) {
        if (i != 2131298832)
          return; 
        if (this.d.size() != StringUtils.a(f, 0)) {
          Bundle bundle = new Bundle();
          bundle.putString("gid", e);
          TerminalActivity.a((Fragment)this, GroupAdminSelectFragment.class, bundle, 100);
          return;
        } 
        this.p.setClickable(false);
        return;
      } 
      String str = ((TextView)this.u.findViewById(2131296867)).getText().toString();
      if (!StringUtils.e(str) && str.equals(getResources().getString(2131756632))) {
        this.n.a = true;
        this.u.setRightText(getString(2131756206));
        this.q.setImageResource(2131232521);
        this.r.setTextColor(getResources().getColor(2131100325));
      } else if (!StringUtils.e(str) && str.equals(getResources().getString(2131756206))) {
        this.n.a = false;
        this.u.setRightText(getString(2131756632));
        this.q.setImageResource(2131232520);
        this.r.setTextColor(getResources().getColor(2131100136));
      } 
      this.n.notifyDataSetChanged();
      return;
    } 
    n();
  }
  
  public void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
    this.l = (Context)getActivity();
    View view = this.k;
    if (view == null) {
      this.k = paramLayoutInflater.inflate(2131493134, paramViewGroup, false);
      a();
      l();
      m();
      k();
    } else if (view.getParent() != null) {
      ((ViewGroup)this.k.getParent()).removeView(this.k);
    } 
    return this.k;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\group\GroupAdminSetFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */