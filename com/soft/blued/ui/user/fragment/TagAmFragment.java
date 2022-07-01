package com.soft.blued.ui.user.fragment;

import android.app.Dialog;
import android.content.Context;
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
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.module.common.utils.DialogUtils;
import com.blued.das.login.LoginAndRegisterProtos;
import com.soft.blued.customview.CommonTopTitleNoTrans;
import com.soft.blued.http.FindHttpUtils;
import com.soft.blued.log.trackUtils.EventTrackLoginAndRegister;
import com.soft.blued.ui.user.adapter.UserTagAdapter;
import com.soft.blued.ui.user.model.UserTag;
import com.soft.blued.ui.user.model.UserTagAll;
import com.soft.blued.user.AVConfig;
import com.soft.blued.utils.StringUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TagAmFragment extends BaseFragment implements View.OnClickListener {
  private Context d;
  
  private View e;
  
  private Dialog f;
  
  private List<UserTag> g = new ArrayList<UserTag>();
  
  private List<UserTag> h = new ArrayList<UserTag>();
  
  private boolean i;
  
  private boolean j;
  
  private GridView k;
  
  private GridView l;
  
  private UserTagAdapter m;
  
  private UserTagAdapter n;
  
  private String o = "";
  
  private ArrayList<String> p = new ArrayList<String>();
  
  private TextView q;
  
  public static void a(Context paramContext) {
    TerminalActivity.d(paramContext, TagAmFragment.class, null);
  }
  
  private boolean a(List<UserTag> paramList) {
    Iterator<UserTag> iterator = paramList.iterator();
    while (iterator.hasNext()) {
      if (((UserTag)iterator.next()).checked == 1)
        return true; 
    } 
    return false;
  }
  
  public boolean V_() {
    return true;
  }
  
  public void a() {
    this.q = (TextView)this.e.findViewById(2131301409);
    k();
    this.f = DialogUtils.a((Context)getActivity());
    this.k = (GridView)this.e.findViewById(2131297340);
    this.k.setOnItemClickListener(new -$$Lambda$TagAmFragment$BnFCxsIAXGcvo-BlIdzVheCpMLc(this));
    this.l = (GridView)this.e.findViewById(2131297341);
    this.l.setOnItemClickListener(new -$$Lambda$TagAmFragment$tyHn9uWEmr_Jph0fOXbH9qEpk50(this));
  }
  
  public void a(UserTag paramUserTag) {
    if (paramUserTag.exclude_id != null) {
      if (paramUserTag.exclude_id.length == 0)
        return; 
      if (paramUserTag.checked == 1) {
        for (int i = 0; i < paramUserTag.exclude_id.length; i++) {
          int j;
          for (j = 0; j < this.g.size(); j++) {
            if (paramUserTag.exclude_id[i].equals(((UserTag)this.g.get(j)).id))
              ((UserTag)this.g.get(j)).chooseable = false; 
          } 
          for (j = 0; j < this.h.size(); j++) {
            if (paramUserTag.exclude_id[i].equals(((UserTag)this.h.get(j)).id))
              ((UserTag)this.h.get(j)).chooseable = false; 
          } 
        } 
      } else {
        for (int i = 0; i < paramUserTag.exclude_id.length; i++) {
          int j;
          for (j = 0; j < this.g.size(); j++) {
            if (paramUserTag.exclude_id[i].equals(((UserTag)this.g.get(j)).id))
              ((UserTag)this.g.get(j)).chooseable = true; 
          } 
          for (j = 0; j < this.h.size(); j++) {
            if (paramUserTag.exclude_id[i].equals(((UserTag)this.h.get(j)).id))
              ((UserTag)this.h.get(j)).chooseable = true; 
          } 
        } 
      } 
    } 
  }
  
  public void k() {}
  
  public int l() {
    int i = 0;
    int j;
    for (j = 0; i < this.h.size(); j = k) {
      int k = j;
      if (((UserTag)this.h.get(i)).checked == 1)
        k = j + 1; 
      i++;
    } 
    return j;
  }
  
  public void m() {
    CommonTopTitleNoTrans commonTopTitleNoTrans = (CommonTopTitleNoTrans)this.e.findViewById(2131300300);
    commonTopTitleNoTrans.c();
    commonTopTitleNoTrans.e();
    commonTopTitleNoTrans.setRightClickListener(this);
    commonTopTitleNoTrans.setCenterText("");
    commonTopTitleNoTrans.setRightText(getResources().getString(2131758217));
    commonTopTitleNoTrans.setRightTextColor(2131100838);
    this.q.setText((AVConfig.a().b()).tags_mine_tips);
  }
  
  public void n() {
    FindHttpUtils.a(this.d, new BluedUIHttpResponse<BluedEntityA<UserTagAll>>(this) {
          protected void a(BluedEntityA<UserTagAll> param1BluedEntityA) {
            if (param1BluedEntityA.data != null && param1BluedEntityA.data.size() > 0) {
              TagAmFragment.a(this.a, ((UserTagAll)param1BluedEntityA.data.get(0)).type);
              TagAmFragment.b(this.a, ((UserTagAll)param1BluedEntityA.data.get(0)).character);
              TagAmFragment tagAmFragment = this.a;
              TagAmFragment.a(tagAmFragment, new UserTagAdapter(TagAmFragment.a(tagAmFragment), TagAmFragment.b(this.a)));
              tagAmFragment = this.a;
              TagAmFragment.b(tagAmFragment, new UserTagAdapter(TagAmFragment.a(tagAmFragment), TagAmFragment.c(this.a)));
              TagAmFragment.e(this.a).setAdapter((ListAdapter)TagAmFragment.d(this.a));
              TagAmFragment.g(this.a).setAdapter((ListAdapter)TagAmFragment.f(this.a));
            } 
          }
          
          public void onUIFinish() {
            DialogUtils.b(TagAmFragment.h(this.a));
            this.a.k();
          }
          
          public void onUIStart() {
            super.onUIStart();
            DialogUtils.a(TagAmFragment.h(this.a));
          }
        }(IRequestHost)w_());
  }
  
  public void o() {
    int j;
    ArrayList<String> arrayList = this.p;
    if (arrayList == null) {
      this.p = new ArrayList<String>();
    } else {
      arrayList.clear();
    } 
    byte b = 0;
    int i = 0;
    while (true) {
      int k = this.g.size();
      String str = ",";
      j = b;
      if (i < k) {
        if (((UserTag)this.g.get(i)).checked == 1) {
          this.p.add(((UserTag)this.g.get(i)).id);
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append(this.o);
          if (StringUtils.e(this.o))
            str = ""; 
          stringBuilder.append(str);
          stringBuilder.append(((UserTag)this.g.get(i)).name);
          this.o = stringBuilder.toString();
        } 
        i++;
        continue;
      } 
      break;
    } 
    while (j < this.h.size()) {
      if (((UserTag)this.h.get(j)).checked == 1) {
        String str;
        this.p.add(((UserTag)this.h.get(j)).id);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.o);
        if (StringUtils.e(this.o)) {
          str = "";
        } else {
          str = ",";
        } 
        stringBuilder.append(str);
        stringBuilder.append(((UserTag)this.h.get(j)).name);
        this.o = stringBuilder.toString();
      } 
      j++;
    } 
    if (this.p.size() == 0)
      this.p.add(""); 
  }
  
  public void onClick(View paramView) {
    int i = paramView.getId();
    if (i != 2131296863) {
      if (i != 2131296867)
        return; 
      o();
      if (this.i) {
        if (a(this.g)) {
          EventTrackLoginAndRegister.a(LoginAndRegisterProtos.Event.PERSONAL_LABEL_NEXT_BTN_CLICK, LoginAndRegisterProtos.LabelType.BODY, LoginAndRegisterProtos.LabelStatus.INITIATIVE_HAVE);
        } else {
          EventTrackLoginAndRegister.a(LoginAndRegisterProtos.Event.PERSONAL_LABEL_NEXT_BTN_CLICK, LoginAndRegisterProtos.LabelType.BODY, LoginAndRegisterProtos.LabelStatus.INITIATIVE_NO);
        } 
      } else {
        EventTrackLoginAndRegister.a(LoginAndRegisterProtos.Event.PERSONAL_LABEL_NEXT_BTN_CLICK, LoginAndRegisterProtos.LabelType.BODY, LoginAndRegisterProtos.LabelStatus.DEFAULT);
      } 
      if (this.j) {
        if (a(this.h)) {
          EventTrackLoginAndRegister.a(LoginAndRegisterProtos.Event.PERSONAL_LABEL_NEXT_BTN_CLICK, LoginAndRegisterProtos.LabelType.FEATURE, LoginAndRegisterProtos.LabelStatus.INITIATIVE_HAVE);
        } else {
          EventTrackLoginAndRegister.a(LoginAndRegisterProtos.Event.PERSONAL_LABEL_NEXT_BTN_CLICK, LoginAndRegisterProtos.LabelType.FEATURE, LoginAndRegisterProtos.LabelStatus.INITIATIVE_NO);
        } 
      } else {
        EventTrackLoginAndRegister.a(LoginAndRegisterProtos.Event.PERSONAL_LABEL_NEXT_BTN_CLICK, LoginAndRegisterProtos.LabelType.FEATURE, LoginAndRegisterProtos.LabelStatus.DEFAULT);
      } 
      TagLookForFragment.a(this.d, true, this.p);
      return;
    } 
    getActivity().finish();
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
    this.d = (Context)getActivity();
    View view = this.e;
    if (view == null) {
      this.e = paramLayoutInflater.inflate(2131493342, paramViewGroup, false);
      a();
      m();
      n();
    } else if (view.getParent() != null) {
      ((ViewGroup)this.e.getParent()).removeView(this.e);
    } 
    return this.e;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\u\\user\fragment\TagAmFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */