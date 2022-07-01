package com.soft.blued.ui.setting.fragment;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.blued.android.core.AppMethods;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.core.utils.skin.BluedSkinUtils;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.view.shape.ShapeHelper;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.base.shortvideo.ShortVideoProxy;
import com.blued.android.module.common.utils.AvatarUtils;
import com.blued.android.module.common.utils.DialogUtils;
import com.blued.android.module.live.base.manager.LiveDataManager;
import com.blued.das.settings.SettingsProtos;
import com.soft.blued.customview.CommonTopTitleNoTrans;
import com.soft.blued.http.GroupHttpUtils;
import com.soft.blued.http.ProfileHttpUtils;
import com.soft.blued.log.InstantLog;
import com.soft.blued.log.trackUtils.EventTrackSettings;
import com.soft.blued.ui.find.observer.PersonalVerifyObserver;
import com.soft.blued.ui.user.model.UserHeaderVerifyStatus;
import com.soft.blued.ui.user.model.VerifyStatus;
import com.soft.blued.user.UserInfo;
import com.soft.blued.utils.StringUtils;
import com.soft.blued.utils.TimeAndDateUtils;
import com.soft.blued.view.tip.CommonAlertDialog;
import java.util.List;

public class PersonalVerifyFragment extends BaseFragment implements View.OnClickListener, PersonalVerifyObserver.IPersonalVerifyObserver {
  private Context d;
  
  private View e;
  
  private LinearLayout f;
  
  private ShapeTextView g;
  
  private String h = "";
  
  private TextView i;
  
  private TextView j;
  
  private TextView k;
  
  private TextView l;
  
  private TextView m;
  
  private TextView n;
  
  private TextView o;
  
  private TextView p;
  
  private TextView q;
  
  private TextView r;
  
  private String s = "";
  
  private String t = "";
  
  private Dialog u;
  
  private ImageView v;
  
  private ImageView w;
  
  private boolean x = false;
  
  public static void a(Context paramContext) {
    TerminalActivity.d(paramContext, PersonalVerifyFragment.class, null);
  }
  
  public static void a(Context paramContext, int paramInt) {
    EventTrackSettings.c(SettingsProtos.Event.PERSONAL_VERIFY_SHOW, paramInt);
    InstantLog.a("personal_verify_show", Integer.valueOf(paramInt));
    TerminalActivity.d(paramContext, PersonalVerifyFragment.class, null);
  }
  
  private void l() {
    CommonTopTitleNoTrans commonTopTitleNoTrans = (CommonTopTitleNoTrans)this.e.findViewById(2131300300);
    commonTopTitleNoTrans.a();
    commonTopTitleNoTrans.setCenterText(getString(2131756852));
    commonTopTitleNoTrans.setLeftClickListener(this);
    commonTopTitleNoTrans.setCenterTextColor(2131100838);
  }
  
  private void m() {
    r();
    k();
  }
  
  private void n() {
    this.f = (LinearLayout)this.e.findViewById(2131299130);
    this.g = (ShapeTextView)this.e.findViewById(2131298728);
    ShapeTextView shapeTextView = this.g;
    Boolean bool = Boolean.valueOf(false);
    shapeTextView.setTag(2131296618, bool);
    this.g.setTag(2131296617, bool);
    this.g.setTag(2131299653, bool);
    this.i = (TextView)this.e.findViewById(2131301178);
    this.j = (TextView)this.e.findViewById(2131301179);
    this.k = (TextView)this.e.findViewById(2131301180);
    this.l = (TextView)this.e.findViewById(2131301357);
    this.m = (TextView)this.e.findViewById(2131301358);
    this.n = (TextView)this.e.findViewById(2131301359);
    this.o = (TextView)this.e.findViewById(2131301378);
    this.p = (TextView)this.e.findViewById(2131301379);
    this.r = (TextView)this.e.findViewById(2131301280);
    this.q = (TextView)this.e.findViewById(2131301485);
    this.q.setText(getString(2131758456));
    this.w = (ImageView)this.e.findViewById(2131297575);
    this.w.setImageDrawable(this.d.getResources().getDrawable(2131234373));
    this.v = (ImageView)this.e.findViewById(2131297362);
    ImageLoader.a((IRequestHost)w_(), AvatarUtils.a(0, UserInfo.a().i().getAvatar())).a(2131234356).c().a(this.v);
  }
  
  private void o() {
    if (Build.VERSION.SDK_INT < 16) {
      this.i.setBackgroundDrawable(this.d.getResources().getDrawable(2131232804));
      this.j.setBackgroundDrawable(this.d.getResources().getDrawable(2131232805));
      this.k.setBackgroundDrawable(this.d.getResources().getDrawable(2131232806));
    } else {
      this.i.setBackground(this.d.getResources().getDrawable(2131232804));
      this.j.setBackground(this.d.getResources().getDrawable(2131232805));
      this.k.setBackground(this.d.getResources().getDrawable(2131232806));
    } 
    this.l.setText(this.d.getResources().getString(2131759129));
    this.l.setTextColor(BluedSkinUtils.a(this.d, 2131100716));
    this.m.setText(this.d.getResources().getString(2131759209));
    this.m.setTextColor(BluedSkinUtils.a(this.d, 2131100716));
    this.n.setText(this.d.getResources().getString(2131755353));
    this.n.setTextColor(BluedSkinUtils.a(this.d, 2131100881));
    this.o.setText(this.s);
    this.p.setText(this.d.getResources().getString(2131755212));
    this.p.setTextColor(BluedSkinUtils.a(this.d, 2131100881));
    this.r.setBackgroundColor(BluedSkinUtils.a(this.d, 2131100883));
  }
  
  private void p() {
    if (Build.VERSION.SDK_INT < 16) {
      this.i.setBackgroundDrawable(this.d.getResources().getDrawable(2131232804));
      this.j.setBackgroundDrawable(this.d.getResources().getDrawable(2131232805));
      this.k.setBackgroundDrawable(this.d.getResources().getDrawable(2131232807));
    } else {
      this.i.setBackground(this.d.getResources().getDrawable(2131232804));
      this.j.setBackground(this.d.getResources().getDrawable(2131232805));
      this.k.setBackground(this.d.getResources().getDrawable(2131232807));
    } 
    this.l.setText(this.d.getResources().getString(2131759129));
    this.l.setTextColor(BluedSkinUtils.a(this.d, 2131100716));
    this.m.setText(this.d.getResources().getString(2131759209));
    this.m.setTextColor(BluedSkinUtils.a(this.d, 2131100716));
    this.n.setText(this.d.getResources().getString(2131755353));
    this.n.setTextColor(BluedSkinUtils.a(this.d, 2131100716));
    this.o.setText(this.s);
    this.p.setText(this.d.getResources().getString(2131755212));
    this.p.setTextColor(BluedSkinUtils.a(this.d, 2131100716));
    this.r.setBackgroundColor(BluedSkinUtils.a(this.d, 2131100716));
  }
  
  private void q() {
    if (Build.VERSION.SDK_INT < 16) {
      this.i.setBackgroundDrawable(this.d.getResources().getDrawable(2131232804));
      this.j.setBackgroundDrawable(this.d.getResources().getDrawable(2131232805));
      this.k.setBackgroundDrawable(this.d.getResources().getDrawable(2131232808));
    } else {
      this.i.setBackground(this.d.getResources().getDrawable(2131232804));
      this.j.setBackground(this.d.getResources().getDrawable(2131232805));
      this.k.setBackground(this.d.getResources().getDrawable(2131232808));
    } 
    this.l.setText(this.d.getResources().getString(2131759129));
    this.l.setTextColor(BluedSkinUtils.a(this.d, 2131100716));
    this.m.setText(this.d.getResources().getString(2131756207));
    this.m.setTextColor(BluedSkinUtils.a(this.d, 2131100716));
    this.n.setText(this.d.getResources().getString(2131759096));
    this.n.setTextColor(BluedSkinUtils.a(this.d, 2131100837));
    this.o.setText(this.s);
    this.p.setText(this.t);
    this.p.setTextColor(BluedSkinUtils.a(this.d, 2131100837));
    this.r.setBackgroundColor(this.d.getResources().getColor(2131100716));
  }
  
  private void r() {
    ProfileHttpUtils.c(new BluedUIHttpResponse<BluedEntityA<UserHeaderVerifyStatus>>(this, (IRequestHost)w_()) {
          protected void a(BluedEntityA<UserHeaderVerifyStatus> param1BluedEntityA) {
            ShapeTextView shapeTextView = PersonalVerifyFragment.a(this.a);
            Boolean bool = Boolean.valueOf(true);
            if (shapeTextView != null)
              PersonalVerifyFragment.a(this.a).setTag(2131299653, bool); 
            if (param1BluedEntityA != null && param1BluedEntityA.data != null && param1BluedEntityA.data.size() > 0) {
              List<UserHeaderVerifyStatus> list = param1BluedEntityA.data;
              boolean bool1 = false;
              UserHeaderVerifyStatus userHeaderVerifyStatus = list.get(0);
              if (userHeaderVerifyStatus != null && PersonalVerifyFragment.a(this.a) != null) {
                PersonalVerifyFragment.a(this.a).setTag(2131296618, bool);
                UserInfo.a().i().setHeaderVerifyStatus(userHeaderVerifyStatus);
                if (PersonalVerifyFragment.a(this.a).getTag(2131296617) != null)
                  bool1 = ((Boolean)PersonalVerifyFragment.a(this.a).getTag(2131296617)).booleanValue(); 
                if (bool1)
                  PersonalVerifyFragment.b(this.a); 
              } 
            } 
          }
          
          public boolean onUIFailure(int param1Int, String param1String) {
            if (PersonalVerifyFragment.a(this.a) != null)
              PersonalVerifyFragment.a(this.a).setTag(2131299653, Boolean.valueOf(true)); 
            return super.onUIFailure(param1Int, param1String);
          }
        }UserInfo.a().i().getUid(), (IRequestHost)w_());
  }
  
  private void s() {
    switch ((UserInfo.a().i().getHeaderVerifyStatus()).code) {
      default:
        return;
      case 201:
      case 202:
        t();
        return;
      case 200:
        break;
    } 
    LiveDataManager.a().a(0);
    ShortVideoProxy.e().a(getContext(), 0, 0);
  }
  
  private void t() {
    CommonAlertDialog.a((Context)getActivity(), null, getResources().getString(2131758199), getResources().getString(2131759123), new DialogInterface.OnClickListener(this) {
          public void onClick(DialogInterface param1DialogInterface, int param1Int) {
            ModifyUserInfoFragment.a(PersonalVerifyFragment.h(this.a), 602, true);
          }
        }null, null, null);
  }
  
  public void a() {
    ImageLoader.a((IRequestHost)w_(), AvatarUtils.a(0, UserInfo.a().i().getAvatar())).a(2131234356).c().a(this.v);
  }
  
  public void k() {
    GroupHttpUtils.k((Context)getActivity(), new BluedUIHttpResponse<BluedEntityA<VerifyStatus>>(this, (IRequestHost)w_()) {
          protected void a(BluedEntityA<VerifyStatus> param1BluedEntityA) {
            if (param1BluedEntityA != null) {
              if (param1BluedEntityA.data != null && param1BluedEntityA.data.size() > 0) {
                VerifyStatus verifyStatus = param1BluedEntityA.data.get(0);
                UserInfo.a().i().setVerify(new VerifyStatus[] { verifyStatus });
                PersonalVerifyFragment personalVerifyFragment = this.a;
                PersonalVerifyFragment.a(personalVerifyFragment, TimeAndDateUtils.a((Context)personalVerifyFragment.getActivity(), TimeAndDateUtils.b(((VerifyStatus)param1BluedEntityA.data.get(0)).add_time)));
                personalVerifyFragment = this.a;
                PersonalVerifyFragment.b(personalVerifyFragment, TimeAndDateUtils.a((Context)personalVerifyFragment.getActivity(), TimeAndDateUtils.b(((VerifyStatus)param1BluedEntityA.data.get(0)).verified_time)));
                PersonalVerifyFragment.c(this.a, ((VerifyStatus)param1BluedEntityA.data.get(0)).has_audited);
              } else {
                PersonalVerifyFragment.a(this.a, "");
                PersonalVerifyFragment.b(this.a, "");
                PersonalVerifyFragment.c(this.a, "x");
              } 
            } else {
              AppMethods.d(2131756082);
            } 
            PersonalVerifyFragment.c(this.a).setVisibility(0);
            if ("0".equals(PersonalVerifyFragment.d(this.a))) {
              PersonalVerifyFragment.e(this.a);
            } else if ("2".equals(PersonalVerifyFragment.d(this.a))) {
              PersonalVerifyFragment.f(this.a);
            } else if ("x".equals(PersonalVerifyFragment.d(this.a))) {
              PersonalVerifyFragment.c(this.a).setVisibility(8);
            } else if ("1".equals(PersonalVerifyFragment.d(this.a))) {
              UserInfo.a().i().setVBadge(4);
              PersonalVerifyFragment.c(this.a, "0");
              PersonalVerifyFragment.g(this.a);
            } 
            if ("0".equals(PersonalVerifyFragment.d(this.a))) {
              ShapeHelper.b((ShapeHelper.ShapeView)PersonalVerifyFragment.a(this.a), 2131100881);
              PersonalVerifyFragment.a(this.a).setText(PersonalVerifyFragment.h(this.a).getResources().getString(2131755438));
              PersonalVerifyFragment.a(this.a).setClickable(false);
              return;
            } 
            ShapeHelper.b((ShapeHelper.ShapeView)PersonalVerifyFragment.a(this.a), 2131100716);
            PersonalVerifyFragment.a(this.a).setText(PersonalVerifyFragment.h(this.a).getResources().getString(2131758902));
            PersonalVerifyFragment.a(this.a).setOnClickListener(new View.OnClickListener(this) {
                  public void onClick(View param2View) {
                    boolean bool1;
                    InstantLog.a("start_video_verify_btn_click");
                    Object object = PersonalVerifyFragment.a(this.a.a).getTag(2131299653);
                    boolean bool2 = false;
                    if (object != null) {
                      bool1 = ((Boolean)PersonalVerifyFragment.a(this.a.a).getTag(2131299653)).booleanValue();
                    } else {
                      bool1 = false;
                    } 
                    if (bool1) {
                      bool1 = bool2;
                      if (PersonalVerifyFragment.a(this.a.a).getTag(2131296618) != null)
                        bool1 = ((Boolean)PersonalVerifyFragment.a(this.a.a).getTag(2131296618)).booleanValue(); 
                      if (bool1) {
                        PersonalVerifyFragment.b(this.a.a);
                        return;
                      } 
                      if (StringUtils.e(UserInfo.a().i().getAvatar())) {
                        PersonalVerifyFragment.i(this.a.a);
                        return;
                      } 
                      PersonalVerifyFragment.a(this.a.a).setTag(2131296617, Boolean.valueOf(true));
                      return;
                    } 
                    PersonalVerifyFragment.j(this.a.a);
                  }
                });
          }
          
          public void onUIFinish() {
            super.onUIFinish();
            DialogUtils.b(PersonalVerifyFragment.k(this.a));
          }
        }UserInfo.a().i().getUid(), (IRequestHost)w_());
  }
  
  public void onClick(View paramView) {
    if (paramView.getId() != 2131296863)
      return; 
    getActivity().finish();
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
    this.d = (Context)getActivity();
    View view = this.e;
    if (view == null) {
      this.e = paramLayoutInflater.inflate(2131493262, paramViewGroup, false);
      this.u = DialogUtils.a((Context)getActivity());
      PersonalVerifyObserver.a().a(this);
      l();
      n();
      m();
    } else if (view.getParent() != null) {
      ((ViewGroup)this.e.getParent()).removeView(this.e);
    } 
    return this.e;
  }
  
  public void onDestroy() {
    PersonalVerifyObserver.a().b(this);
    super.onDestroy();
  }
  
  public void onResume() {
    super.onResume();
    if (this.x) {
      m();
      return;
    } 
    this.x = true;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\setting\fragment\PersonalVerifyFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */