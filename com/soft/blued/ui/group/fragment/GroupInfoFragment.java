package com.soft.blued.ui.group.fragment;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.ToggleButton;
import androidx.fragment.app.Fragment;
import com.blued.android.chat.ChatManager;
import com.blued.android.core.AppInfo;
import com.blued.android.core.AppMethods;
import com.blued.android.core.BlueAppLocal;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.imagecache.LoadOptions;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.das.message.MessageProtos;
import com.soft.blued.BluedConstant;
import com.soft.blued.customview.CommonTopTitleNoTrans;
import com.soft.blued.customview.LabeledTextView;
import com.soft.blued.customview.NoDataAndLoadFailView;
import com.soft.blued.http.BluedHttpUrl;
import com.soft.blued.http.H5Url;
import com.soft.blued.log.InstantLog;
import com.soft.blued.log.model.LogData;
import com.soft.blued.ui.feed.fragment.PhotoSelectFragment;
import com.soft.blued.ui.group.GroupAdminSetFragment;
import com.soft.blued.ui.group.GroupEditNameIconFragment;
import com.soft.blued.ui.group.GroupJoinVerifyFragment;
import com.soft.blued.ui.group.GroupMembersListFragment;
import com.soft.blued.ui.group.GroupUpdateCountFragment;
import com.soft.blued.ui.group.ModifyGroupProfileFragment;
import com.soft.blued.ui.group.contract.IGroupInfoContract;
import com.soft.blued.ui.group.model.BluedCreatedGroupInfo;
import com.soft.blued.ui.group.model.BluedGroupAdminLists;
import com.soft.blued.ui.group.model.BluedGroupAllMembers;
import com.soft.blued.ui.group.presenter.GroupInfoPresenter;
import com.soft.blued.ui.home.HomeArgumentHelper;
import com.soft.blued.ui.msg.MsgChattingFragment;
import com.soft.blued.ui.msg.controller.tools.ChatHelperV4;
import com.soft.blued.ui.msg.model.MsgSourceEntity;
import com.soft.blued.ui.photo.fragment.BasePhotoFragment;
import com.soft.blued.ui.user.fragment.ChooseCountryFragment;
import com.soft.blued.ui.user.fragment.ReportFragmentNew;
import com.soft.blued.ui.web.WebViewShowInfoFragment;
import com.soft.blued.user.UserInfo;
import com.soft.blued.utils.AreaUtils;
import com.soft.blued.utils.BluedPreferences;
import com.soft.blued.utils.CommonDataRefreshObserver;
import com.soft.blued.utils.PopMenuUtils;
import com.soft.blued.utils.StringUtils;
import com.soft.blued.utils.UserRelationshipUtils;
import com.soft.blued.view.tip.CommonAlertDialog;
import java.util.ArrayList;
import java.util.List;

public class GroupInfoFragment extends BaseFragment implements View.OnClickListener, IGroupInfoContract.IView {
  private ImageView A;
  
  private RelativeLayout B;
  
  private ImageView C;
  
  private ImageView D;
  
  private RelativeLayout E;
  
  private ImageView F;
  
  private ImageView G;
  
  private RelativeLayout H;
  
  private ImageView I;
  
  private ImageView J;
  
  private RelativeLayout K;
  
  private ImageView L;
  
  private ImageView M;
  
  private ImageView N;
  
  private ImageView O;
  
  private ImageView P;
  
  private LinearLayout Q;
  
  private LinearLayout R;
  
  private LinearLayout S;
  
  private LinearLayout T;
  
  private LabeledTextView U;
  
  private LinearLayout V;
  
  private LinearLayout W;
  
  private Button X;
  
  private Button Y;
  
  private ToggleButton Z;
  
  private TextView aa;
  
  private TextView ab;
  
  private LinearLayout ac;
  
  private ImageView ad;
  
  private ImageView ae;
  
  private LinearLayout af;
  
  private TextView ag;
  
  private ImageView ah;
  
  private ImageView ai;
  
  private TextView aj;
  
  private LinearLayout ak;
  
  private LinearLayout al;
  
  private LinearLayout am;
  
  private LinearLayout an;
  
  private TextView ao;
  
  private ImageView ap;
  
  private LinearLayout aq;
  
  private TextView ar;
  
  private ScrollView as;
  
  private NoDataAndLoadFailView at;
  
  private LinearLayout au;
  
  private LinearLayout av;
  
  private TextView aw;
  
  private BluedCreatedGroupInfo ax;
  
  private List<BluedGroupAllMembers> ay = new ArrayList<BluedGroupAllMembers>();
  
  private String d = GroupInfoFragment.class.getSimpleName();
  
  private GroupInfoPresenter e;
  
  private Context f;
  
  private View g;
  
  private LoadOptions h;
  
  private String i;
  
  private String j;
  
  private String k;
  
  private CommonTopTitleNoTrans l;
  
  private ImageView m;
  
  private TextView n;
  
  private TextView o;
  
  private TextView p;
  
  private TextView q;
  
  private TextView r;
  
  private TextView s;
  
  private ImageView t;
  
  private ImageView u;
  
  private RelativeLayout v;
  
  private ImageView w;
  
  private ImageView x;
  
  private RelativeLayout y;
  
  private ImageView z;
  
  public static void a(Context paramContext, String paramString) {
    Bundle bundle = new Bundle();
    bundle.putString("gid", paramString);
    TerminalActivity.d(paramContext, GroupInfoFragment.class, bundle);
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2) {
    Bundle bundle = new Bundle();
    bundle.putString("gid", paramString1);
    bundle.putString("from_page", paramString2);
    TerminalActivity.d(paramContext, GroupInfoFragment.class, bundle);
  }
  
  private void a(View paramView) {
    this.m = (ImageView)paramView.findViewById(2131297793);
    this.n = (TextView)paramView.findViewById(2131300851);
    this.o = (TextView)paramView.findViewById(2131300855);
    this.p = (TextView)paramView.findViewById(2131300849);
    this.q = (TextView)paramView.findViewById(2131300833);
    this.r = (TextView)paramView.findViewById(2131300843);
    this.s = (TextView)paramView.findViewById(2131300830);
    this.t = (ImageView)paramView.findViewById(2131297772);
    this.u = (ImageView)paramView.findViewById(2131300772);
    this.v = (RelativeLayout)paramView.findViewById(2131299704);
    this.w = (ImageView)paramView.findViewById(2131297918);
    this.x = (ImageView)paramView.findViewById(2131301309);
    this.y = (RelativeLayout)paramView.findViewById(2131299726);
    this.z = (ImageView)paramView.findViewById(2131297943);
    this.A = (ImageView)paramView.findViewById(2131301383);
    this.B = (RelativeLayout)paramView.findViewById(2131299732);
    this.C = (ImageView)paramView.findViewById(2131297773);
    this.D = (ImageView)paramView.findViewById(2131300784);
    this.E = (RelativeLayout)paramView.findViewById(2131299705);
    this.F = (ImageView)paramView.findViewById(2131297767);
    this.G = (ImageView)paramView.findViewById(2131300765);
    this.H = (RelativeLayout)paramView.findViewById(2131299703);
    this.I = (ImageView)paramView.findViewById(2131297923);
    this.J = (ImageView)paramView.findViewById(2131301346);
    this.K = (RelativeLayout)paramView.findViewById(2131299729);
    this.L = (ImageView)paramView.findViewById(2131297676);
    this.M = (ImageView)paramView.findViewById(2131297678);
    this.N = (ImageView)paramView.findViewById(2131297675);
    this.O = (ImageView)paramView.findViewById(2131297674);
    this.P = (ImageView)paramView.findViewById(2131297677);
    this.Q = (LinearLayout)paramView.findViewById(2131298842);
    this.R = (LinearLayout)paramView.findViewById(2131298844);
    this.S = (LinearLayout)paramView.findViewById(2131298866);
    this.T = (LinearLayout)paramView.findViewById(2131298132);
    this.U = (LabeledTextView)paramView.findViewById(2131296713);
    this.U.a(Boolean.valueOf(BluedPreferences.e(1)));
    this.V = (LinearLayout)paramView.findViewById(2131298862);
    this.W = (LinearLayout)paramView.findViewById(2131300864);
    this.X = (Button)paramView.findViewById(2131296595);
    this.Y = (Button)paramView.findViewById(2131296564);
    this.Z = (ToggleButton)paramView.findViewById(2131299819);
    this.aa = (TextView)paramView.findViewById(2131300832);
    this.ab = (TextView)paramView.findViewById(2131300831);
    this.ac = (LinearLayout)paramView.findViewById(2131298836);
    this.ad = (ImageView)paramView.findViewById(2131300820);
    this.ae = (ImageView)paramView.findViewById(2131300999);
    this.af = (LinearLayout)paramView.findViewById(2131299420);
    this.ag = (TextView)paramView.findViewById(2131300865);
    this.ah = (ImageView)paramView.findViewById(2131300529);
    this.ai = (ImageView)paramView.findViewById(2131297785);
    this.aj = (TextView)paramView.findViewById(2131298848);
    this.ak = (LinearLayout)paramView.findViewById(2131298847);
    this.al = (LinearLayout)paramView.findViewById(2131298837);
    this.am = (LinearLayout)paramView.findViewById(2131298849);
    this.an = (LinearLayout)paramView.findViewById(2131298133);
    this.as = (ScrollView)paramView.findViewById(2131300144);
    this.ao = (TextView)paramView.findViewById(2131300844);
    this.ap = (ImageView)paramView.findViewById(2131301034);
    this.aq = (LinearLayout)paramView.findViewById(2131298130);
    this.ar = (TextView)paramView.findViewById(2131298838);
    this.at = (NoDataAndLoadFailView)paramView.findViewById(2131297786);
    this.at.setNoDataImg(2131232323);
    this.at.setNoDataStr(2131756673);
    this.at.c();
    this.au = (LinearLayout)paramView.findViewById(2131298835);
    this.av = (LinearLayout)paramView.findViewById(2131298839);
    this.aw = (TextView)paramView.findViewById(2131300834);
    this.m.setOnClickListener(this);
    this.Q.setOnClickListener(this);
    this.R.setOnClickListener(this);
    this.S.setOnClickListener(this);
    this.T.setOnClickListener(this);
    this.U.setOnClickListener(this);
    this.V.setOnClickListener(this);
    this.W.setOnClickListener(this);
    this.X.setOnClickListener(this);
    this.Y.setOnClickListener(this);
    this.ac.setOnClickListener(this);
    this.al.setOnClickListener(this);
    this.am.setOnClickListener(this);
    this.an.setOnClickListener(this);
    this.aq.setOnClickListener(this);
  }
  
  public static void a(Fragment paramFragment, String paramString, int paramInt) {
    Bundle bundle = new Bundle();
    bundle.putString("gid", paramString);
    TerminalActivity.a(paramFragment, GroupInfoFragment.class, bundle, paramInt);
  }
  
  public static void a(Fragment paramFragment, String paramString1, String paramString2, int paramInt) {
    Bundle bundle = new Bundle();
    bundle.putString("gid", paramString1);
    bundle.putString("from_page", paramString2);
    TerminalActivity.a(paramFragment, GroupInfoFragment.class, bundle, paramInt);
  }
  
  private void a(List<BluedGroupAllMembers> paramList) {
    ArrayList<RelativeLayout> arrayList = new ArrayList();
    arrayList.add(this.y);
    arrayList.add(this.B);
    arrayList.add(this.E);
    arrayList.add(this.H);
    arrayList.add(this.K);
    ArrayList<ImageView> arrayList1 = new ArrayList();
    arrayList1.add(this.w);
    arrayList1.add(this.z);
    arrayList1.add(this.C);
    arrayList1.add(this.F);
    arrayList1.add(this.I);
    ArrayList<ImageView> arrayList2 = new ArrayList();
    arrayList2.add(this.x);
    arrayList2.add(this.A);
    arrayList2.add(this.D);
    arrayList2.add(this.G);
    arrayList2.add(this.J);
    ArrayList<ImageView> arrayList3 = new ArrayList();
    arrayList3.add(this.L);
    arrayList3.add(this.M);
    arrayList3.add(this.N);
    arrayList3.add(this.O);
    arrayList3.add(this.P);
    int j = 0;
    int i = 0;
    while (j < 5) {
      if (paramList.size() > j) {
        i++;
        ImageLoader.a((IRequestHost)w_(), ((BluedGroupAllMembers)paramList.get(j)).avatar).c().a(2131234356).a(arrayList1.get(j));
        if ("1".equals(((BluedGroupAllMembers)paramList.get(j)).is_admin)) {
          ((ImageView)arrayList2.get(j)).setVisibility(0);
        } else {
          ((ImageView)arrayList2.get(j)).setVisibility(8);
        } 
      } else {
        ((RelativeLayout)arrayList.get(j)).setVisibility(4);
      } 
      j++;
    } 
    if (this.e.c()) {
      j = i;
      if (i == 5)
        j = i - 1; 
      ((ImageView)arrayList1.get(j)).setVisibility(8);
      ((ImageView)arrayList2.get(j)).setVisibility(8);
      ((RelativeLayout)arrayList.get(j)).setVisibility(0);
      ((ImageView)arrayList3.get(j)).setVisibility(0);
      ((ImageView)arrayList3.get(j)).setOnClickListener(new View.OnClickListener(this) {
            public void onClick(View param1View) {
              if (GroupInfoFragment.b(this.a) != null && BluedConstant.a)
                AppMethods.d(2131758077); 
            }
          });
    } 
  }
  
  private void k() {
    this.h = new LoadOptions();
    LoadOptions loadOptions = this.h;
    loadOptions.d = 2131234356;
    loadOptions.b = 2131234356;
    Bundle bundle = getArguments();
    if (bundle == null)
      return; 
    this.i = bundle.getString("gid");
    this.k = bundle.getString("iid");
    this.j = bundle.getString("from_page");
    if (!StringUtils.e(this.j))
      InstantLog.a("group_detail", this.j); 
    this.e.b(this.i);
    this.Z.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(this) {
          public void onCheckedChanged(CompoundButton param1CompoundButton, boolean param1Boolean) {
            if (param1Boolean) {
              GroupInfoFragment.a(this.a).a(1);
            } else {
              GroupInfoFragment.a(this.a).a(0);
            } 
            GroupInfoFragment.a(this.a).b(param1Boolean);
          }
        });
  }
  
  private void l() {
    this.l = (CommonTopTitleNoTrans)this.g.findViewById(2131300300);
    this.l.a();
    this.l.setCenterText(getString(2131756670));
    this.l.setLeftClickListener(this);
    this.l.setRightClickListener(this);
    this.l.setRightImg(2131232758);
  }
  
  private void m() {
    if (this.ax != null) {
      String str = AppInfo.f().toJson(this.ax);
      Bundle bundle = new Bundle();
      bundle.putString("membersCount", this.ax.groups_members_count);
      bundle.putString("gid", this.ax.groups_gid);
      bundle.putString("member", this.ax.groups_in_members);
      bundle.putString("admin", this.ax.groups_is_admins);
      bundle.putString("creator", this.ax.groups_is_created);
      bundle.putString("group_info_json", str);
      TerminalActivity.a((Fragment)this, GroupMembersListFragment.class, bundle, 7000);
    } 
  }
  
  public boolean V_() {
    Intent intent = new Intent();
    intent.putExtra("passby_nick_name", this.n.getText().toString());
    getActivity().setResult(-1, intent);
    getActivity().finish();
    return true;
  }
  
  public Bundle a() {
    return getArguments();
  }
  
  public void a(BluedCreatedGroupInfo paramBluedCreatedGroupInfo) {
    this.ax = paramBluedCreatedGroupInfo;
    if (StringUtils.e(paramBluedCreatedGroupInfo.groups_avatar)) {
      this.m.setImageResource(2131232322);
    } else {
      ImageLoader.a((IRequestHost)w_(), paramBluedCreatedGroupInfo.groups_avatar).c().a(2131234356).a(this.m);
    } 
    if (StringUtils.e(paramBluedCreatedGroupInfo.groups_name)) {
      this.n.setVisibility(8);
    } else {
      this.n.setText(paramBluedCreatedGroupInfo.groups_name);
    } 
    if (StringUtils.e(paramBluedCreatedGroupInfo.groups_gid)) {
      this.o.setVisibility(8);
    } else {
      this.o.setText(paramBluedCreatedGroupInfo.groups_gid);
    } 
    if (StringUtils.e(paramBluedCreatedGroupInfo.groups_members_count) && StringUtils.e(paramBluedCreatedGroupInfo.groups_members_total)) {
      this.p.setVisibility(8);
    } else {
      TextView textView = this.p;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(" ");
      stringBuilder.append(StringUtils.a(paramBluedCreatedGroupInfo.groups_members_count));
      stringBuilder.append("/");
      stringBuilder.append(StringUtils.a(paramBluedCreatedGroupInfo.groups_members_total));
      stringBuilder.append(" ");
      textView.setText(stringBuilder.toString());
    } 
    if (StringUtils.e(paramBluedCreatedGroupInfo.groups_description)) {
      this.s.setVisibility(8);
      this.q.setVisibility(8);
    } else {
      this.s.setText(paramBluedCreatedGroupInfo.groups_description);
      this.q.setText(paramBluedCreatedGroupInfo.groups_description);
    } 
    if (StringUtils.e(paramBluedCreatedGroupInfo.groups_city)) {
      this.r.setVisibility(8);
    } else {
      this.r.setText(AreaUtils.a(paramBluedCreatedGroupInfo.groups_city, BlueAppLocal.c()));
    } 
    ImageLoader.a((IRequestHost)w_(), paramBluedCreatedGroupInfo.created_avatar).c().a(2131234356).a(this.t);
    this.u.setVisibility(0);
    this.ay.clear();
    int i;
    for (i = 0; i < paramBluedCreatedGroupInfo.groups_admins.size(); i++) {
      BluedGroupAllMembers bluedGroupAllMembers = new BluedGroupAllMembers();
      bluedGroupAllMembers.is_admin = "1";
      bluedGroupAllMembers.avatar = ((BluedGroupAdminLists)paramBluedCreatedGroupInfo.groups_admins.get(i)).users_avatar;
      this.ay.add(bluedGroupAllMembers);
    } 
    for (i = 0; i < paramBluedCreatedGroupInfo.groups_members.size(); i++) {
      BluedGroupAllMembers bluedGroupAllMembers = new BluedGroupAllMembers();
      bluedGroupAllMembers.is_admin = "0";
      bluedGroupAllMembers.avatar = ((BluedGroupAdminLists)paramBluedCreatedGroupInfo.groups_members.get(i)).users_avatar;
      this.ay.add(bluedGroupAllMembers);
    } 
    a(this.ay);
    if (this.e.c()) {
      this.U.setVisibility(0);
      this.av.setVisibility(8);
      this.aa.setVisibility(8);
      this.aw.setVisibility(8);
      this.al.setVisibility(0);
      this.ab.setVisibility(0);
      if (!StringUtils.e(this.j) && this.j.equals(MsgChattingFragment.class.getSimpleName())) {
        this.Y.setVisibility(8);
      } else {
        this.Y.setText(2131755811);
        this.Y.setVisibility(0);
      } 
      if ("1".equals(paramBluedCreatedGroupInfo.groups_is_created)) {
        if (paramBluedCreatedGroupInfo.groups_is_locked == 1)
          this.ac.setVisibility(0); 
        this.ae.setVisibility(0);
        this.X.setText(2131755673);
        this.ad.setVisibility(0);
        this.af.setVisibility(0);
        this.W.setVisibility(8);
        this.ag.setVisibility(8);
        this.ai.setVisibility(0);
        this.ah.setVisibility(0);
        if (2 == paramBluedCreatedGroupInfo.vbadge)
          UserRelationshipUtils.a(this.ai, paramBluedCreatedGroupInfo.vbadge, 3); 
      } else {
        this.ac.setVisibility(8);
        if ("1".equals(paramBluedCreatedGroupInfo.groups_is_admins)) {
          this.ae.setVisibility(0);
          this.ad.setVisibility(0);
          this.X.setText(2131755677);
          this.W.setVisibility(0);
          this.ag.setVisibility(0);
          this.aj.setVisibility(0);
          this.ai.setVisibility(0);
          this.ah.setVisibility(0);
          this.S.setEnabled(true);
          this.al.setEnabled(true);
          if (2 == paramBluedCreatedGroupInfo.vbadge)
            UserRelationshipUtils.a(this.ai, paramBluedCreatedGroupInfo.vbadge, 3); 
        } else {
          this.X.setText(2131755677);
          this.S.setEnabled(false);
          this.ae.setVisibility(8);
          this.al.setEnabled(false);
          this.ah.setVisibility(8);
          this.ag.setVisibility(8);
          if (2 == paramBluedCreatedGroupInfo.vbadge) {
            UserRelationshipUtils.a(this.ai, 2, 3);
          } else {
            this.ai.setVisibility(8);
          } 
          if (StringUtils.e(paramBluedCreatedGroupInfo.groups_avatar)) {
            this.m.setEnabled(false);
          } else {
            this.m.setEnabled(true);
          } 
        } 
      } 
    } else {
      this.U.setVisibility(8);
      this.q.setVisibility(0);
      this.aa.setVisibility(0);
      this.av.setVisibility(0);
      this.aw.setVisibility(0);
      this.al.setVisibility(8);
      this.ab.setVisibility(8);
      this.ar.setVisibility(8);
      this.ac.setVisibility(8);
      this.ae.setVisibility(8);
      this.X.setVisibility(8);
      this.Y.setText(2131755676);
      this.ak.setVisibility(8);
      this.S.setEnabled(false);
      if (!StringUtils.e(this.k))
        this.Y.setText(2131756680); 
      if (2 == paramBluedCreatedGroupInfo.vbadge) {
        UserRelationshipUtils.a(this.ai, 2, 3);
      } else {
        this.ai.setVisibility(8);
      } 
      if (StringUtils.e(paramBluedCreatedGroupInfo.groups_avatar)) {
        this.m.setEnabled(false);
      } else {
        this.m.setEnabled(true);
      } 
    } 
    if (paramBluedCreatedGroupInfo.groups_is_locked == 1) {
      this.ao.setVisibility(0);
      this.ak.setVisibility(8);
      this.af.setVisibility(8);
      this.Y.setVisibility(8);
      this.ae.setVisibility(8);
      this.ah.setVisibility(8);
      this.ad.setVisibility(8);
      this.W.setVisibility(8);
      this.ag.setVisibility(8);
      this.ap.setVisibility(8);
      this.l.a();
      this.an.setEnabled(false);
      this.Q.setEnabled(false);
      this.am.setEnabled(false);
      this.al.setEnabled(false);
      this.S.setEnabled(false);
      this.m.setEnabled(false);
      this.p.setEnabled(false);
      this.R.setEnabled(false);
      this.L.setEnabled(false);
      this.M.setEnabled(false);
      this.N.setEnabled(false);
      this.O.setEnabled(false);
      this.P.setEnabled(false);
    } 
    this.as.setVisibility(0);
  }
  
  public void a(String paramString) {
    ImageLoader.d((IRequestHost)w_(), paramString).c().a(2131234356).a(this.m);
  }
  
  public void a(boolean paramBoolean) {
    a(new Runnable(this, paramBoolean) {
          public void run() {
            GroupInfoFragment.c(this.b).setChecked(this.a);
          }
        });
  }
  
  public void a(String[] paramArrayOfString) {
    BasePhotoFragment.a(this.f, paramArrayOfString, 0, 2, this.h);
  }
  
  public void aJ_() {
    BluedCreatedGroupInfo bluedCreatedGroupInfo = this.ax;
    if (bluedCreatedGroupInfo != null) {
      if (bluedCreatedGroupInfo == null)
        return; 
      LogData logData = new LogData();
      logData.g = "none";
      ChatHelperV4.a().a(this.f, Long.parseLong(bluedCreatedGroupInfo.groups_gid), bluedCreatedGroupInfo.groups_name, bluedCreatedGroupInfo.groups_avatar, bluedCreatedGroupInfo.vbadge, 0, 0, 0, "", false, 1, 0, logData, new MsgSourceEntity(MessageProtos.StrangerSource.UNKNOWN_STRANGER_SOURCE, ""));
      getActivity().finish();
    } 
  }
  
  public void aK_() {
    a(new Runnable(this) {
          public void run() {
            GroupInfoFragment.d(this.a).setVisibility(8);
            GroupInfoFragment.e(this.a).setVisibility(8);
            GroupInfoFragment.f(this.a).a();
            GroupInfoFragment.g(this.a).a();
          }
        });
  }
  
  public void b() {
    PhotoSelectFragment.a(this, 3, 22);
  }
  
  public void d() {
    try {
      this.e.g();
      AppMethods.d(2131755674);
      UserInfo.a().i().setGroupsCount(-1);
      CommonDataRefreshObserver.a().b();
      if (MsgChattingFragment.class.getSimpleName().equals(this.j)) {
        HomeArgumentHelper.a((Context)getActivity(), "msg", null);
        return;
      } 
      getActivity().finish();
      return;
    } catch (Exception exception) {
      AppMethods.d(2131756082);
      exception.printStackTrace();
      return;
    } 
  }
  
  public void e() {
    AppMethods.d(2131755678);
    UserInfo.a().i().setGroupsCount(-1);
    CommonDataRefreshObserver.a().b();
    ChatManager.getInstance().deleteSessionAndChatting(Short.valueOf((short)3), Long.parseLong(this.ax.groups_gid));
    if (MsgChattingFragment.class.getSimpleName().equals(this.j)) {
      HomeArgumentHelper.a((Context)getActivity(), "msg", null);
      return;
    } 
    getActivity().finish();
  }
  
  public void h() {
    a(new Runnable(this) {
          public void run() {
            GroupInfoFragment.h(this.a).setText(2131755676);
          }
        });
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {
    if (paramInt2 == -1)
      if (paramInt1 != 22) {
        if (paramInt1 != 1000) {
          if (paramInt1 != 2000) {
            if (paramInt1 != 3000) {
              if (paramInt1 != 4000) {
                if (paramInt1 != 5000) {
                  if (paramInt1 != 6000) {
                    if (paramInt1 != 7000) {
                      if (paramInt1 != 8000) {
                        if (paramInt1 == 9000)
                          V_(); 
                      } else {
                        this.e.a(false);
                      } 
                    } else {
                      this.e.a(false);
                    } 
                  } else {
                    String str;
                    if (paramIntent != null && !StringUtils.e(paramIntent.getStringExtra("string_edit"))) {
                      str = paramIntent.getStringExtra("string_edit");
                    } else {
                      str = "";
                    } 
                    this.e.d(str);
                  } 
                } else {
                  this.e.a(false);
                } 
              } else {
                this.e.a(false);
              } 
            } else if (paramIntent != null && !StringUtils.e(paramIntent.getStringExtra("areacode"))) {
              String str = paramIntent.getStringExtra("areacode");
              this.e.e(str);
            } 
          } else {
            if (paramIntent != null && !StringUtils.e(paramIntent.getStringExtra("profile"))) {
              this.s.setText(paramIntent.getStringExtra("profile"));
              this.q.setText(paramIntent.getStringExtra("profile"));
            } 
            this.e.f(paramIntent.getStringExtra("profile"));
          } 
        } else {
          if (paramIntent != null && !StringUtils.e(paramIntent.getStringExtra("name")))
            this.e.g(paramIntent.getStringExtra("name")); 
          if (paramIntent != null && !StringUtils.e(paramIntent.getStringExtra("icon"))) {
            String str = paramIntent.getStringExtra("icon");
            ImageLoader.d((IRequestHost)w_(), str).c().a(2131234356).a(this.m);
            this.e.h(str);
          } 
        } 
      } else if (paramIntent != null) {
        this.e.a(paramIntent.getStringExtra("photo_path"));
      }  
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public void onClick(View paramView) {
    Bundle bundle2;
    LabeledTextView labeledTextView;
    GroupInfoPresenter groupInfoPresenter;
    String str;
    if (paramView.getId() == 2131296863) {
      V_();
      return;
    } 
    if (this.ax == null)
      return; 
    switch (paramView.getId()) {
      default:
        return;
      case 2131300864:
        if (this.ax == null)
          return; 
        ReportFragmentNew.a((Context)getActivity(), 4, this.ax.groups_gid, this.ax.groups_name);
        return;
      case 2131298866:
        if (!StringUtils.e(this.ax.groups_is_created) && !StringUtils.e(this.ax.groups_is_admins) && ("1".equals(this.ax.groups_is_created) || "1".equals(this.ax.groups_is_admins))) {
          Bundle bundle = new Bundle();
          bundle.putString("currentLoc", this.r.getText().toString());
          bundle.putString("locTitle", this.f.getResources().getString(2131756700));
          ChooseCountryFragment.a(this, 3000);
          return;
        } 
        return;
      case 2131298862:
        WebViewShowInfoFragment.show(this.f, H5Url.a(26), 0);
        return;
      case 2131298849:
        if (!StringUtils.e(this.ax.groups_is_created) && !StringUtils.e(this.ax.groups_is_admins) && ("1".equals(this.ax.groups_is_created) || "1".equals(this.ax.groups_is_admins)) && !PopMenuUtils.a(this.f)) {
          Bundle bundle = new Bundle();
          bundle.putString("icon", this.ax.groups_avatar);
          bundle.putString("name", this.n.getText().toString());
          bundle.putString("gid", this.ax.groups_gid);
          TerminalActivity.a((Fragment)this, GroupEditNameIconFragment.class, bundle, 1000);
          return;
        } 
        return;
      case 2131298844:
        m();
        return;
      case 2131298842:
        m();
        return;
      case 2131298837:
        if (!StringUtils.e(this.ax.groups_is_created) && !StringUtils.e(this.ax.groups_is_admins) && ("1".equals(this.ax.groups_is_created) || "1".equals(this.ax.groups_is_admins)) && !PopMenuUtils.a(this.f)) {
          Bundle bundle = new Bundle();
          bundle.putString("profile", this.s.getText().toString());
          TerminalActivity.a((Fragment)this, ModifyGroupProfileFragment.class, bundle, 2000);
          return;
        } 
        return;
      case 2131298836:
        WebViewShowInfoFragment.a(this.f, BluedHttpUrl.a(0), getResources().getString(2131756120), 16);
        return;
      case 2131298133:
        bundle2 = new Bundle();
        bundle2.putString("gid", this.ax.groups_gid);
        bundle2.putInt("up_group_type", this.ax.vbadge);
        bundle2.putString("up_group_total", this.ax.groups_members_total);
        bundle2.putInt("groups_member_vip", this.ax.groups_member_vip);
        TerminalActivity.a((Fragment)this, GroupUpdateCountFragment.class, bundle2, 8000);
        return;
      case 2131298132:
        CommonAlertDialog.a(this.f, getString(2131756094), getString(2131755584), getString(2131756086), new DialogInterface.OnClickListener(this) {
              public void onClick(DialogInterface param1DialogInterface, int param1Int) {
                GroupInfoFragment.a(this.a).d();
                AppMethods.d(2131756644);
              }
            },  getString(2131756057), null, null);
        return;
      case 2131298130:
        bundle2 = new Bundle();
        bundle2.putString("gid", this.ax.groups_gid);
        if (!StringUtils.e(this.ax.groups_admins_total))
          bundle2.putString("admin_total", this.ax.groups_admins_total); 
        if (!StringUtils.e(this.ax.groups_admins_count))
          bundle2.putString("admin_amount", this.ax.groups_admins_count); 
        TerminalActivity.a((Fragment)this, GroupAdminSetFragment.class, bundle2, 4000);
        return;
      case 2131297793:
        this.e.b();
        return;
      case 2131296867:
        this.e.a(this.n.getText().toString(), this.m);
        return;
      case 2131296713:
        labeledTextView = this.U;
        if (labeledTextView != null)
          labeledTextView.a(Boolean.valueOf(false)); 
        groupInfoPresenter = this.e;
        if (groupInfoPresenter != null) {
          groupInfoPresenter.a(this, 9000);
          return;
        } 
        return;
      case 2131296595:
        str = this.ax.created_uid;
        if (StringUtils.e(str))
          return; 
        if (UserInfo.a().i().getUid().equals(str)) {
          Context context = this.f;
          CommonAlertDialog.a(context, context.getResources().getString(2131756094), this.f.getResources().getString(2131756660), this.f.getResources().getString(2131756086), new DialogInterface.OnClickListener(this) {
                public void onClick(DialogInterface param1DialogInterface, int param1Int) {
                  GroupInfoFragment.a(this.a).e();
                }
              },  this.f.getResources().getString(2131755726), null, null);
          return;
        } 
        if ("1".equals(this.ax.groups_in_members)) {
          Context context = this.f;
          CommonAlertDialog.a(context, context.getResources().getString(2131756094), this.f.getResources().getString(2131756771), this.f.getResources().getString(2131756086), new DialogInterface.OnClickListener(this) {
                public void onClick(DialogInterface param1DialogInterface, int param1Int) {
                  GroupInfoFragment.a(this.a).f();
                }
              },  this.f.getResources().getString(2131756057), new DialogInterface.OnClickListener(this) {
                public void onClick(DialogInterface param1DialogInterface, int param1Int) {}
              },  null);
          return;
        } 
        bundle1 = new Bundle();
        bundle1.putString("gid", this.ax.groups_gid);
        if (!StringUtils.e(this.j))
          InstantLog.a("join_group", this.j); 
        TerminalActivity.d((Context)getActivity(), GroupJoinVerifyFragment.class, bundle1);
        return;
      case 2131296564:
        break;
    } 
    if (this.e.h()) {
      bundle1 = new Bundle();
      bundle1.putString("gid", this.ax.groups_gid);
      if (!StringUtils.e(this.j))
        InstantLog.a("join_group", this.j); 
      TerminalActivity.d((Context)getActivity(), GroupJoinVerifyFragment.class, bundle1);
      return;
    } 
    if (!StringUtils.e(this.k) && "0".equals(this.ax.groups_in_members)) {
      this.e.c(this.k);
      return;
    } 
    if ("1".equals(this.ax.groups_in_members)) {
      aJ_();
      return;
    } 
    Bundle bundle1 = new Bundle();
    bundle1.putString("gid", this.ax.groups_gid);
    if (!StringUtils.e(this.j))
      InstantLog.a("join_group", this.j); 
    TerminalActivity.d((Context)getActivity(), GroupJoinVerifyFragment.class, bundle1);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
    this.f = (Context)getActivity();
    View view = this.g;
    if (view == null) {
      this.g = paramLayoutInflater.inflate(2131493137, null);
      this.e = new GroupInfoPresenter(this.f, this, this.h, (IRequestHost)w_());
      a(this.g);
      l();
      k();
      this.e.a(true);
    } else {
      ((ViewGroup)view.getParent()).removeView(this.g);
    } 
    a(this.g);
    return this.g;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\group\fragment\GroupInfoFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */