package com.soft.blued.ui.user.fragment;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.blued.android.core.AppMethods;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.framework.http.BluedHttpTools;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.module.common.utils.DialogUtils;
import com.blued.das.login.LoginAndRegisterProtos;
import com.soft.blued.customview.CommonTopTitleNoTrans;
import com.soft.blued.db.UserAccountsVDao;
import com.soft.blued.http.FindHttpUtils;
import com.soft.blued.http.UserHttpUtils;
import com.soft.blued.log.trackUtils.EventTrackLoginAndRegister;
import com.soft.blued.ui.find.fragment.RecommendUsersOnRegisterFragment;
import com.soft.blued.ui.find.observer.UserInfoDataObserver;
import com.soft.blued.ui.home.HomeArgumentHelper;
import com.soft.blued.ui.login_register.model.BluedLoginResult;
import com.soft.blued.ui.setting.fragment.ModifyUserInfoFragment;
import com.soft.blued.ui.user.adapter.UserTagAdapter;
import com.soft.blued.ui.user.model.UserTag;
import com.soft.blued.ui.user.model.UserTagAll;
import com.soft.blued.user.AVConfig;
import com.soft.blued.user.UserInfo;
import com.soft.blued.utils.StringUtils;
import com.soft.blued.view.tip.CommonAlertDialog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class TagLookForFragment extends BaseFragment implements View.OnClickListener {
  private Context d;
  
  private View e;
  
  private Dialog f;
  
  private List<UserTag> g = new ArrayList<UserTag>();
  
  private List<UserTag> h = new ArrayList<UserTag>();
  
  private List<UserTag> i = new ArrayList<UserTag>();
  
  private boolean j;
  
  private boolean k;
  
  private boolean l;
  
  private GridView m;
  
  private GridView n;
  
  private GridView o;
  
  private UserTagAdapter p;
  
  private UserTagAdapter q;
  
  private UserTagAdapter r;
  
  private TextView s;
  
  private TextView t;
  
  private String u = "";
  
  private ArrayList<String> v = new ArrayList<String>();
  
  private ArrayList<String> w = new ArrayList<String>();
  
  private int x;
  
  private int y;
  
  private int z;
  
  public static void a(Context paramContext, boolean paramBoolean, ArrayList<String> paramArrayList) {
    Bundle bundle = new Bundle();
    bundle.putBoolean("hidden_back", paramBoolean);
    bundle.putStringArrayList("choosedIAmList", paramArrayList);
    TerminalActivity.d(paramContext, TagLookForFragment.class, bundle);
  }
  
  private void a(Map<String, String> paramMap) {
    UserHttpUtils.a((Context)getActivity(), new BluedUIHttpResponse<BluedEntityA<BluedLoginResult>>(this) {
          String a;
          
          protected void a(BluedEntityA<BluedLoginResult> param1BluedEntityA) {
            if (param1BluedEntityA != null && param1BluedEntityA.data != null && param1BluedEntityA.data.size() > 0) {
              BluedLoginResult bluedLoginResult = param1BluedEntityA.data.get(0);
              UserInfo.a().a(bluedLoginResult);
              UserAccountsVDao.a().b(this.a);
              UserInfoDataObserver.a().b();
              this.b.getActivity().finish();
              Bundle bundle = new Bundle();
              bundle.putString("from_tag_page", "from_tag_register");
              HomeArgumentHelper.a((Context)this.b.getActivity(), null, bundle);
            } 
          }
          
          public void onSuccess(String param1String) {
            super.onSuccess(param1String);
            this.a = param1String;
          }
          
          public boolean onUIFailure(int param1Int, String param1String) {
            this.b.p();
            return super.onUIFailure(param1Int, param1String);
          }
          
          public void onUIFinish() {
            super.onUIFinish();
            DialogUtils.b(TagLookForFragment.k(this.b));
          }
          
          public void onUIStart() {
            super.onUIStart();
            DialogUtils.a(TagLookForFragment.k(this.b));
          }
        }UserInfo.a().i().getUid(), paramMap, (IRequestHost)w_());
  }
  
  private boolean a(List<UserTag> paramList) {
    Iterator<UserTag> iterator = paramList.iterator();
    while (iterator.hasNext()) {
      if (((UserTag)iterator.next()).checked == 1)
        return true; 
    } 
    return false;
  }
  
  public void a() {}
  
  public boolean a(List<UserTag> paramList, UserTagAdapter paramUserTagAdapter, int paramInt) {
    boolean bool = ((UserTag)paramList.get(paramInt)).chooseable;
    boolean bool1 = false;
    boolean bool2 = false;
    if (bool) {
      if (((UserTag)paramList.get(paramInt)).checked == 1) {
        ((UserTag)paramList.get(paramInt)).checked = 0;
      } else {
        int i;
        l();
        if (paramList == this.g) {
          i = this.y;
        } else if (paramList == this.h) {
          i = this.z;
        } else {
          i = this.x;
        } 
        if (i < 5) {
          ((UserTag)paramList.get(paramInt)).checked = 1;
        } else {
          bool1 = bool2;
          if (i == 5) {
            AppMethods.d(2131757866);
            bool1 = bool2;
          } 
          paramUserTagAdapter.notifyDataSetChanged();
        } 
      } 
      bool1 = true;
    } else {
      a();
      return bool1;
    } 
    paramUserTagAdapter.notifyDataSetChanged();
  }
  
  public void k() {
    a();
    this.t = (TextView)this.e.findViewById(2131301409);
    this.s = (TextView)this.e.findViewById(2131300621);
    this.f = DialogUtils.a((Context)getActivity());
    this.m = (GridView)this.e.findViewById(2131297340);
    this.m.setOnItemClickListener(new -$$Lambda$TagLookForFragment$sPzKJNyCRgmgf6x1rk0UK0n4AOA(this));
    this.n = (GridView)this.e.findViewById(2131297341);
    this.n.setOnItemClickListener(new -$$Lambda$TagLookForFragment$vUgPaDqGXK-dTPb0dXxr1W0REps(this));
    this.o = (GridView)this.e.findViewById(2131297353);
    this.o.setOnItemClickListener(new -$$Lambda$TagLookForFragment$_cXuLdxFbxCCjJOc9eWgOaircHM(this));
    this.s.setVisibility(0);
    this.n.setVisibility(0);
  }
  
  public void l() {
    int j;
    byte b = 0;
    this.y = 0;
    this.z = 0;
    this.x = 0;
    int i;
    for (i = 0; i < this.g.size(); i++) {
      if (((UserTag)this.g.get(i)).checked == 1)
        this.y++; 
    } 
    i = 0;
    while (true) {
      j = b;
      if (i < this.h.size()) {
        if (((UserTag)this.h.get(i)).checked == 1)
          this.z++; 
        i++;
        continue;
      } 
      break;
    } 
    while (j < this.i.size()) {
      if (((UserTag)this.i.get(j)).checked == 1)
        this.x++; 
      j++;
    } 
  }
  
  public void m() {
    CommonTopTitleNoTrans commonTopTitleNoTrans = (CommonTopTitleNoTrans)this.e.findViewById(2131300300);
    commonTopTitleNoTrans.setLeftClickListener(this);
    commonTopTitleNoTrans.setRightClickListener(this);
    commonTopTitleNoTrans.setRightText(2131756206);
    commonTopTitleNoTrans.setCenterText("");
    commonTopTitleNoTrans.e();
    commonTopTitleNoTrans.setRightTextColor(2131100838);
    commonTopTitleNoTrans.setTitleBackgroundDrawable(2131100728);
    this.t.setText((AVConfig.a().b()).tags_favorite_tips);
  }
  
  public void n() {
    FindHttpUtils.a(this.d, new BluedUIHttpResponse<BluedEntityA<UserTagAll>>(this) {
          protected void a(BluedEntityA<UserTagAll> param1BluedEntityA) {
            if (param1BluedEntityA != null && param1BluedEntityA.data != null && param1BluedEntityA.data.size() > 0) {
              TagLookForFragment.a(this.a, ((UserTagAll)param1BluedEntityA.data.get(0)).love_type);
              TagLookForFragment.b(this.a, ((UserTagAll)param1BluedEntityA.data.get(0)).love_character);
              TagLookForFragment.c(this.a, ((UserTagAll)param1BluedEntityA.data.get(0)).i_want);
              TagLookForFragment tagLookForFragment = this.a;
              TagLookForFragment.a(tagLookForFragment, new UserTagAdapter(TagLookForFragment.a(tagLookForFragment), TagLookForFragment.b(this.a)));
              tagLookForFragment = this.a;
              TagLookForFragment.b(tagLookForFragment, new UserTagAdapter(TagLookForFragment.a(tagLookForFragment), TagLookForFragment.c(this.a)));
              tagLookForFragment = this.a;
              TagLookForFragment.c(tagLookForFragment, new UserTagAdapter(TagLookForFragment.a(tagLookForFragment), TagLookForFragment.d(this.a)));
              TagLookForFragment.f(this.a).setAdapter((ListAdapter)TagLookForFragment.e(this.a));
              TagLookForFragment.h(this.a).setAdapter((ListAdapter)TagLookForFragment.g(this.a));
              TagLookForFragment.j(this.a).setAdapter((ListAdapter)TagLookForFragment.i(this.a));
            } 
          }
          
          public void onUIFinish() {
            DialogUtils.b(TagLookForFragment.k(this.a));
          }
          
          public void onUIStart() {
            super.onUIStart();
            DialogUtils.a(TagLookForFragment.k(this.a));
          }
        }(IRequestHost)w_());
  }
  
  public void o() {
    ArrayList<String> arrayList = this.v;
    if (arrayList == null) {
      this.v = new ArrayList<String>();
    } else {
      arrayList.clear();
    } 
    arrayList = this.w;
    boolean bool = false;
    if (arrayList != null)
      for (int j = 0; j < this.w.size(); j++)
        this.v.add(this.w.get(j));  
    int i = 0;
    while (true) {
      int j = this.g.size();
      String str = ",";
      if (i < j) {
        if (((UserTag)this.g.get(i)).checked == 1) {
          this.v.add(((UserTag)this.g.get(i)).id);
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append(this.u);
          if (StringUtils.e(this.u))
            str = ""; 
          stringBuilder.append(str);
          stringBuilder.append(((UserTag)this.g.get(i)).name);
          this.u = stringBuilder.toString();
        } 
        i++;
        continue;
      } 
      i = 0;
      while (true) {
        j = bool;
        if (i < this.i.size()) {
          if (((UserTag)this.i.get(i)).checked == 1) {
            this.v.add(((UserTag)this.i.get(i)).id);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(this.u);
            if (StringUtils.e(this.u)) {
              str = "";
            } else {
              str = ",";
            } 
            stringBuilder.append(str);
            stringBuilder.append(((UserTag)this.i.get(i)).name);
            this.u = stringBuilder.toString();
          } 
          i++;
          continue;
        } 
        break;
      } 
      while (j < this.h.size()) {
        if (((UserTag)this.h.get(j)).checked == 1) {
          this.v.add(((UserTag)this.h.get(j)).id);
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append(this.u);
          if (StringUtils.e(this.u)) {
            str = "";
          } else {
            str = ",";
          } 
          stringBuilder.append(str);
          stringBuilder.append(((UserTag)this.h.get(j)).name);
          this.u = stringBuilder.toString();
        } 
        j++;
      } 
      if (this.v.size() == 0)
        this.v.add(""); 
      return;
    } 
  }
  
  public void onClick(View paramView) {
    int i = paramView.getId();
    if (i != 2131296863) {
      if (i != 2131296867)
        return; 
      StringBuffer stringBuffer = new StringBuffer();
      o();
      if (this.v != null)
        for (i = 0; i < this.v.size(); i++) {
          String str;
          StringBuilder stringBuilder = new StringBuilder();
          if (StringUtils.e(stringBuffer.toString())) {
            str = "";
          } else {
            str = ",";
          } 
          stringBuilder.append(str);
          stringBuilder.append(this.v.get(i));
          stringBuffer.append(stringBuilder.toString());
        }  
      if (this.j) {
        if (a(this.g)) {
          EventTrackLoginAndRegister.a(LoginAndRegisterProtos.Event.LIKE_LABEL_NEXT_BTN_CLICK, LoginAndRegisterProtos.LabelType.BODY, LoginAndRegisterProtos.LabelStatus.INITIATIVE_HAVE);
        } else {
          EventTrackLoginAndRegister.a(LoginAndRegisterProtos.Event.LIKE_LABEL_NEXT_BTN_CLICK, LoginAndRegisterProtos.LabelType.BODY, LoginAndRegisterProtos.LabelStatus.INITIATIVE_NO);
        } 
      } else {
        EventTrackLoginAndRegister.a(LoginAndRegisterProtos.Event.LIKE_LABEL_NEXT_BTN_CLICK, LoginAndRegisterProtos.LabelType.BODY, LoginAndRegisterProtos.LabelStatus.DEFAULT);
      } 
      if (this.k) {
        if (a(this.h)) {
          EventTrackLoginAndRegister.a(LoginAndRegisterProtos.Event.LIKE_LABEL_NEXT_BTN_CLICK, LoginAndRegisterProtos.LabelType.FEATURE, LoginAndRegisterProtos.LabelStatus.INITIATIVE_HAVE);
        } else {
          EventTrackLoginAndRegister.a(LoginAndRegisterProtos.Event.LIKE_LABEL_NEXT_BTN_CLICK, LoginAndRegisterProtos.LabelType.FEATURE, LoginAndRegisterProtos.LabelStatus.INITIATIVE_NO);
        } 
      } else {
        EventTrackLoginAndRegister.a(LoginAndRegisterProtos.Event.LIKE_LABEL_NEXT_BTN_CLICK, LoginAndRegisterProtos.LabelType.FEATURE, LoginAndRegisterProtos.LabelStatus.DEFAULT);
      } 
      if (this.l) {
        if (a(this.i)) {
          EventTrackLoginAndRegister.a(LoginAndRegisterProtos.Event.LIKE_LABEL_NEXT_BTN_CLICK, LoginAndRegisterProtos.LabelType.WANT, LoginAndRegisterProtos.LabelStatus.INITIATIVE_HAVE);
        } else {
          EventTrackLoginAndRegister.a(LoginAndRegisterProtos.Event.LIKE_LABEL_NEXT_BTN_CLICK, LoginAndRegisterProtos.LabelType.WANT, LoginAndRegisterProtos.LabelStatus.INITIATIVE_NO);
        } 
      } else {
        EventTrackLoginAndRegister.a(LoginAndRegisterProtos.Event.LIKE_LABEL_NEXT_BTN_CLICK, LoginAndRegisterProtos.LabelType.WANT, LoginAndRegisterProtos.LabelStatus.DEFAULT);
      } 
      if (!StringUtils.e(stringBuffer.toString())) {
        Map<String, String> map = BluedHttpTools.a();
        map.put("tags", stringBuffer.toString());
        a(map);
        return;
      } 
      Bundle bundle = new Bundle();
      bundle.putString("from_tag_page", "from_tag_register");
      HomeArgumentHelper.a((Context)getActivity(), null, bundle);
      return;
    } 
    getActivity().finish();
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
    this.d = (Context)getActivity();
    if (this.e == null) {
      this.e = paramLayoutInflater.inflate(2131493343, paramViewGroup, false);
      if (getArguments() != null) {
        this.v = getArguments().getStringArrayList("CHOOSED_LIST");
        this.w = getArguments().getStringArrayList("choosedIAmList");
      } 
      k();
      m();
      n();
    } 
    return this.e;
  }
  
  public void p() {
    CommonAlertDialog.a((Context)getActivity(), null, getResources().getString(2131758705), getResources().getString(2131758996), new DialogInterface.OnClickListener(this) {
          public void onClick(DialogInterface param1DialogInterface, int param1Int) {
            ModifyUserInfoFragment.a(TagLookForFragment.a(this.a), 601, false);
          }
        }getResources().getString(2131755726), new DialogInterface.OnClickListener(this) {
          public void onClick(DialogInterface param1DialogInterface, int param1Int) {
            this.a.getActivity().finish();
            RecommendUsersOnRegisterFragment.a(TagLookForFragment.a(this.a));
          }
        },  null);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\u\\user\fragment\TagLookForFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */