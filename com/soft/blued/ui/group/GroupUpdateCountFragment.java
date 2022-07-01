package com.soft.blued.ui.group;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
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
import com.soft.blued.ui.group.model.BluedGroupAdminLists;
import com.soft.blued.ui.setting.fragment.PersonalVerifyFragment;
import com.soft.blued.ui.user.model.VerifyStatus;
import com.soft.blued.ui.user.presenter.PayUtils;
import com.soft.blued.user.BluedConfig;
import com.soft.blued.user.UserInfo;
import com.soft.blued.utils.StringUtils;
import com.soft.blued.view.tip.CommonAlertDialog;

public class GroupUpdateCountFragment extends BaseFragment implements View.OnClickListener {
  private static String m;
  
  private static String n;
  
  public BluedUIHttpResponse d = new BluedUIHttpResponse<BluedEntityA<BluedGroupAdminLists>>(this) {
      protected void a(BluedEntityA<BluedGroupAdminLists> param1BluedEntityA) {
        AppMethods.d(2131756206);
        GroupUpdateCountFragment.f(this.a).setVisibility(8);
        GroupUpdateCountFragment.g(this.a).setVisibility(0);
      }
      
      public void onUIFinish() {
        super.onUIFinish();
        DialogUtils.b(GroupUpdateCountFragment.e(this.a));
      }
      
      public void onUIStart() {
        super.onUIStart();
        DialogUtils.a(GroupUpdateCountFragment.e(this.a));
      }
    };
  
  private String e = GroupUpdateCountFragment.class.getSimpleName();
  
  private View f;
  
  private Context g;
  
  private TextView h;
  
  private LinearLayout i;
  
  private LinearLayout j;
  
  private LinearLayout k;
  
  private Dialog l;
  
  private int o;
  
  private TextView p;
  
  private TextView q;
  
  private String r;
  
  private TextView s;
  
  private LinearLayout t;
  
  private ImageView u;
  
  private void l() {
    CommonTopTitleNoTrans commonTopTitleNoTrans = (CommonTopTitleNoTrans)this.f.findViewById(2131300300);
    commonTopTitleNoTrans.a();
    commonTopTitleNoTrans.setCenterText(getString(2131759112));
    commonTopTitleNoTrans.setLeftClickListener(this);
  }
  
  private void m() {
    this.l = DialogUtils.a(this.g);
    this.k = (LinearLayout)this.f.findViewById(2131298703);
    this.p = (TextView)this.f.findViewById(2131301554);
    this.q = (TextView)this.f.findViewById(2131301553);
    this.q.setOnClickListener(this);
    this.h = (TextView)this.f.findViewById(2131299394);
    this.i = (LinearLayout)this.f.findViewById(2131298134);
    this.j = (LinearLayout)this.f.findViewById(2131301555);
    this.s = (TextView)this.f.findViewById(2131301556);
    this.s.setOnClickListener(this);
    this.t = (LinearLayout)this.f.findViewById(2131299134);
    this.u = (ImageView)this.f.findViewById(2131297968);
    if (this.o == 2)
      this.u.setImageResource(2131232812); 
    int i = this.o;
    if (i == 0 || (i == 1 && (UserInfo.a().i()).vip_grade == 2) || (this.o == 3 && (UserInfo.a().i()).vip_grade == 2)) {
      this.s.setVisibility(0);
      this.t.setVisibility(4);
    } else {
      this.s.setVisibility(8);
      this.t.setVisibility(0);
    } 
    if (Integer.parseInt(m) >= 100) {
      this.q.setVisibility(8);
      this.j.setVisibility(8);
      this.k.setVisibility(0);
    } else if (!StringUtils.e(n)) {
      if (n.equals("2")) {
        this.i.setVisibility(8);
        this.h.setVisibility(0);
        if ("zh".equals(BlueAppLocal.c().getLanguage())) {
          SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.g.getResources().getString(2131759106));
          spannableStringBuilder.setSpan(new ForegroundColorSpan(-16776961), 4, 8, 34);
          this.h.setText((CharSequence)spannableStringBuilder);
        } else {
          this.h.setText(2131759106);
        } 
      } else if (n.equals("3")) {
        this.i.setVisibility(8);
        this.h.setVisibility(0);
        if ("zh".equals(BlueAppLocal.c().getLanguage())) {
          SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.g.getResources().getString(2131759107));
          spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.rgb(255, 0, 255)), 4, 8, 34);
          this.h.setText((CharSequence)spannableStringBuilder);
        } else {
          this.h.setText(2131759107);
        } 
      } else {
        this.q.setVisibility(0);
        this.k.setVisibility(8);
        this.p.setText(2131759111);
      } 
    } 
    ((TerminalActivity)getActivity()).a(new TerminalActivity.IRestartListener(this) {
          public void a() {
            GroupUpdateCountFragment.a(this.a);
          }
        });
  }
  
  private void n() {
    GroupHttpUtils.k(null, new BluedUIHttpResponse<BluedEntityA<VerifyStatus>>(this) {
          public void a(BluedEntityA<VerifyStatus> param1BluedEntityA) {
            if (param1BluedEntityA != null)
              try {
                if (param1BluedEntityA.hasData()) {
                  VerifyStatus verifyStatus = param1BluedEntityA.data.get(0);
                  UserInfo.a().i().setVerify(new VerifyStatus[] { verifyStatus }, );
                  if ("1".equals(((VerifyStatus)param1BluedEntityA.data.get(0)).has_audited)) {
                    GroupUpdateCountFragment.b(this.a).setVisibility(8);
                    GroupUpdateCountFragment.c(this.a).setVisibility(8);
                    GroupUpdateCountFragment.d(this.a).setVisibility(0);
                    return;
                  } 
                  GroupUpdateCountFragment.b(this.a).setVisibility(0);
                  GroupUpdateCountFragment.d(this.a).setVisibility(8);
                  GroupUpdateCountFragment.c(this.a).setVisibility(0);
                  return;
                } 
              } catch (Exception exception) {
                exception.printStackTrace();
              }  
          }
        },  UserInfo.a().i().getUid(), null);
  }
  
  private void o() {
    PayUtils.a((Context)getActivity(), 8, "group_member_expand");
  }
  
  private void p() {
    CommonAlertDialog.a(this.g, "", getString(2131759122), getString(2131758950), new DialogInterface.OnClickListener(this) {
          public void onClick(DialogInterface param1DialogInterface, int param1Int) {
            this.a.k();
          }
        },  null, null, null);
  }
  
  public boolean V_() {
    getActivity().setResult(-1);
    getActivity().finish();
    return false;
  }
  
  public void a() {
    Bundle bundle = getArguments();
    if (bundle == null)
      return; 
    this.r = bundle.getString("gid");
    m = bundle.getString("up_group_total");
    this.o = bundle.getInt("groups_member_vip");
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(UserInfo.a().i().getVBadge());
    stringBuilder.append("");
    n = stringBuilder.toString();
  }
  
  public void k() {
    GroupHttpUtils.c(this.g, this.d, this.r, "0", "1", (IRequestHost)w_());
  }
  
  public void onClick(View paramView) {
    int i = paramView.getId();
    if (i != 2131296863) {
      if (i != 2131301553) {
        if (i != 2131301556)
          return; 
        if ((UserInfo.a().i()).vip_grade == 0 && (BluedConfig.b().j()).is_improve_grouplist == 0) {
          o();
          return;
        } 
        p();
        return;
      } 
      PersonalVerifyFragment.a((Context)getActivity());
      return;
    } 
    getActivity().setResult(-1);
    getActivity().finish();
  }
  
  public void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
    this.g = (Context)getActivity();
    View view = this.f;
    if (view == null) {
      this.f = paramLayoutInflater.inflate(2131493147, paramViewGroup, false);
      a();
      l();
      m();
      n();
    } else if (view.getParent() != null) {
      ((ViewGroup)this.f.getParent()).removeView(this.f);
    } 
    return this.f;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\group\GroupUpdateCountFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */