package com.soft.blued.ui.user.fragment;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListAdapter;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.blued.android.core.AppMethods;
import com.blued.android.core.BlueAppLocal;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.framework.http.BluedHttpTools;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.module.common.utils.DialogUtils;
import com.soft.blued.customview.CommonTopTitleNoTrans;
import com.soft.blued.db.UserAccountsVDao;
import com.soft.blued.http.FindHttpUtils;
import com.soft.blued.http.UserHttpUtils;
import com.soft.blued.ui.find.observer.UserInfoDataObserver;
import com.soft.blued.ui.login_register.model.BluedLoginResult;
import com.soft.blued.ui.setting.fragment.ModifyUserInfoFragment;
import com.soft.blued.ui.user.adapter.UserTagAdapter;
import com.soft.blued.ui.user.model.UserTag;
import com.soft.blued.ui.user.model.UserTagAll;
import com.soft.blued.user.UserInfo;
import com.soft.blued.utils.StringUtils;
import com.soft.blued.view.tip.CommonAlertDialog;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class TagForModifyFragment extends BaseFragment implements View.OnClickListener {
  private Context d;
  
  private View e;
  
  private Dialog f;
  
  private List<UserTag> g = new ArrayList<UserTag>();
  
  private List<UserTag> h = new ArrayList<UserTag>();
  
  private List<UserTag> i = new ArrayList<UserTag>();
  
  private List<UserTag> j = new ArrayList<UserTag>();
  
  private List<UserTag> k = new ArrayList<UserTag>();
  
  private ArrayList<String> l = new ArrayList<String>();
  
  private int m;
  
  private GridView n;
  
  private GridView o;
  
  private GridView p;
  
  private GridView q;
  
  private GridView r;
  
  private UserTagAdapter s;
  
  private UserTagAdapter t;
  
  private UserTagAdapter u;
  
  private UserTagAdapter v;
  
  private UserTagAdapter w;
  
  private boolean x;
  
  public static void a(BaseFragment paramBaseFragment, ArrayList<String> paramArrayList, int paramInt) {
    Bundle bundle = new Bundle();
    bundle.putStringArrayList("choosedList", paramArrayList);
    TerminalActivity.a((Fragment)paramBaseFragment, TagForModifyFragment.class, bundle, paramInt);
  }
  
  private void a(Map<String, String> paramMap) {
    UserHttpUtils.a((Context)getActivity(), new BluedUIHttpResponse<BluedEntityA<BluedLoginResult>>(this) {
          String a = "";
          
          protected void a(BluedEntityA<BluedLoginResult> param1BluedEntityA) {
            if (param1BluedEntityA != null && param1BluedEntityA.data != null && param1BluedEntityA.data.size() > 0) {
              BluedLoginResult bluedLoginResult = param1BluedEntityA.data.get(0);
              UserInfo.a().a(bluedLoginResult);
              AppMethods.a(this.b.getResources().getString(2131757921));
              UserAccountsVDao.a().b(this.a);
              UserInfoDataObserver.a().b();
              this.b.getActivity().finish();
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
            DialogUtils.b(TagForModifyFragment.r(this.b));
          }
          
          public void onUIStart() {
            super.onUIStart();
            DialogUtils.a(TagForModifyFragment.r(this.b));
          }
        }UserInfo.a().i().getUid(), paramMap, (IRequestHost)w_());
  }
  
  public boolean V_() {
    getActivity().finish();
    return false;
  }
  
  public void a() {
    this.f = DialogUtils.a((Context)getActivity());
    this.n = (GridView)this.e.findViewById(2131297344);
    this.n.setOnItemClickListener(new AdapterView.OnItemClickListener(this) {
          public void onItemClick(AdapterView<?> param1AdapterView, View param1View, int param1Int, long param1Long) {
            if (((UserTag)TagForModifyFragment.a(this.a).get(param1Int)).chooseable) {
              if (((UserTag)TagForModifyFragment.a(this.a).get(param1Int)).checked == 1) {
                ((UserTag)TagForModifyFragment.a(this.a).get(param1Int)).checked = 0;
              } else if (this.a.k() < 5) {
                ((UserTag)TagForModifyFragment.a(this.a).get(param1Int)).checked = 1;
                int i;
                for (i = 0; i < TagForModifyFragment.a(this.a).size(); i++) {
                  if (i != param1Int)
                    ((UserTag)TagForModifyFragment.a(this.a).get(i)).checked = 0; 
                } 
              } else {
                AppMethods.d(2131757866);
              } 
              TagForModifyFragment tagForModifyFragment = this.a;
              tagForModifyFragment.a(TagForModifyFragment.a(tagForModifyFragment).get(param1Int));
              TagForModifyFragment.b(this.a).notifyDataSetChanged();
            } 
          }
        });
    this.o = (GridView)this.e.findViewById(2131297345);
    this.o.setOnItemClickListener(new AdapterView.OnItemClickListener(this) {
          public void onItemClick(AdapterView<?> param1AdapterView, View param1View, int param1Int, long param1Long) {
            TagForModifyFragment tagForModifyFragment = this.a;
            tagForModifyFragment.a(TagForModifyFragment.c(tagForModifyFragment), TagForModifyFragment.d(this.a), param1Int);
          }
        });
    this.p = (GridView)this.e.findViewById(2131297346);
    this.p.setOnItemClickListener(new AdapterView.OnItemClickListener(this) {
          public void onItemClick(AdapterView<?> param1AdapterView, View param1View, int param1Int, long param1Long) {
            TagForModifyFragment tagForModifyFragment = this.a;
            tagForModifyFragment.b(TagForModifyFragment.e(tagForModifyFragment), TagForModifyFragment.f(this.a), param1Int);
          }
        });
    this.q = (GridView)this.e.findViewById(2131297349);
    this.q.setOnItemClickListener(new AdapterView.OnItemClickListener(this) {
          public void onItemClick(AdapterView<?> param1AdapterView, View param1View, int param1Int, long param1Long) {
            TagForModifyFragment tagForModifyFragment = this.a;
            tagForModifyFragment.b(TagForModifyFragment.g(tagForModifyFragment), TagForModifyFragment.h(this.a), param1Int);
          }
        });
    this.r = (GridView)this.e.findViewById(2131297348);
    this.r.setOnItemClickListener(new AdapterView.OnItemClickListener(this) {
          public void onItemClick(AdapterView<?> param1AdapterView, View param1View, int param1Int, long param1Long) {
            TagForModifyFragment tagForModifyFragment = this.a;
            tagForModifyFragment.b(TagForModifyFragment.i(tagForModifyFragment), TagForModifyFragment.j(this.a), param1Int);
          }
        });
    TextView textView = (TextView)this.e.findViewById(2131300513);
    if ("CN".equals(BlueAppLocal.b())) {
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append(getResources().getString(2131757034));
      stringBuilder1.append("  (");
      stringBuilder1.append(getResources().getString(2131757866));
      stringBuilder1.append(")");
      textView.setText(stringBuilder1.toString());
    } 
    textView = (TextView)this.e.findViewById(2131301007);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(getResources().getString(2131757040));
    stringBuilder.append("  (");
    stringBuilder.append(getResources().getString(2131757866));
    stringBuilder.append(")");
    textView.setText(stringBuilder.toString());
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
  
  public void a(ArrayList<String> paramArrayList, List<UserTag> paramList) {
    if (paramArrayList != null && paramArrayList.size() > 0) {
      int i;
      for (i = 0; i < paramList.size(); i++)
        ((UserTag)paramList.get(i)).checked = 0; 
      for (i = 0; i < paramArrayList.size(); i++) {
        String str = paramArrayList.get(i);
        int j;
        for (j = 0; j < paramList.size(); j++) {
          if (((UserTag)paramList.get(j)).id.equals(str)) {
            ((UserTag)paramList.get(j)).checked = 1;
            a(paramList.get(j));
          } 
        } 
      } 
    } 
  }
  
  public void a(List<UserTag> paramList, UserTagAdapter paramUserTagAdapter, int paramInt) {
    if (((UserTag)paramList.get(paramInt)).chooseable) {
      if (((UserTag)paramList.get(paramInt)).checked == 1) {
        ((UserTag)paramList.get(paramInt)).checked = 0;
      } else {
        int i = k();
        if (i < 5) {
          ((UserTag)paramList.get(paramInt)).checked = 1;
        } else if (i == 5) {
          AppMethods.d(2131757866);
        } 
      } 
      a(paramList.get(paramInt));
      paramUserTagAdapter.notifyDataSetChanged();
    } 
  }
  
  public void b(List<UserTag> paramList, UserTagAdapter paramUserTagAdapter, int paramInt) {
    if (((UserTag)paramList.get(paramInt)).checked == 1) {
      ((UserTag)paramList.get(paramInt)).checked = 0;
    } else {
      int i = l();
      if (i < 5) {
        ((UserTag)paramList.get(paramInt)).checked = 1;
      } else if (i == 5) {
        AppMethods.d(2131757866);
      } 
    } 
    paramUserTagAdapter.notifyDataSetChanged();
  }
  
  public int k() {
    int k;
    int m;
    byte b = 0;
    int j = 0;
    int i = 0;
    while (true) {
      k = b;
      m = i;
      if (j < this.g.size()) {
        k = i;
        if (((UserTag)this.g.get(j)).checked == 1)
          k = i + 1; 
        j++;
        i = k;
        continue;
      } 
      break;
    } 
    while (k < this.h.size()) {
      i = m;
      if (((UserTag)this.h.get(k)).checked == 1)
        i = m + 1; 
      k++;
      m = i;
    } 
    return m;
  }
  
  public int l() {
    int k;
    int m;
    byte b = 0;
    int j = 0;
    int i;
    for (i = 0; j < this.i.size(); i = k) {
      k = i;
      if (((UserTag)this.i.get(j)).checked == 1)
        k = i + 1; 
      j++;
    } 
    j = 0;
    while (true) {
      k = b;
      m = i;
      if (j < this.j.size()) {
        k = i;
        if (((UserTag)this.j.get(j)).checked == 1)
          k = i + 1; 
        j++;
        i = k;
        continue;
      } 
      break;
    } 
    while (k < this.k.size()) {
      i = m;
      if (((UserTag)this.k.get(k)).checked == 1)
        i = m + 1; 
      k++;
      m = i;
    } 
    return m;
  }
  
  public void m() {
    CommonTopTitleNoTrans commonTopTitleNoTrans = (CommonTopTitleNoTrans)this.e.findViewById(2131300300);
    commonTopTitleNoTrans.setCenterText(getString(2131758187));
    commonTopTitleNoTrans.setLeftClickListener(this);
    commonTopTitleNoTrans.setRightClickListener(this);
    commonTopTitleNoTrans.setRightText(2131756206);
    commonTopTitleNoTrans.setRightTextColor(2131100838);
  }
  
  public void n() {
    FindHttpUtils.a(this.d, new BluedUIHttpResponse<BluedEntityA<UserTagAll>>(this, (IRequestHost)w_()) {
          protected void a(BluedEntityA<UserTagAll> param1BluedEntityA) {
            if (param1BluedEntityA != null && param1BluedEntityA.data != null && param1BluedEntityA.data.size() > 0) {
              TagForModifyFragment.a(this.a, ((UserTagAll)param1BluedEntityA.data.get(0)).type);
              TagForModifyFragment.b(this.a, ((UserTagAll)param1BluedEntityA.data.get(0)).character);
              TagForModifyFragment.c(this.a, ((UserTagAll)param1BluedEntityA.data.get(0)).love_type);
              TagForModifyFragment.d(this.a, ((UserTagAll)param1BluedEntityA.data.get(0)).i_want);
              TagForModifyFragment.e(this.a, ((UserTagAll)param1BluedEntityA.data.get(0)).love_character);
              TagForModifyFragment tagForModifyFragment = this.a;
              tagForModifyFragment.a(TagForModifyFragment.k(tagForModifyFragment), TagForModifyFragment.a(this.a));
              tagForModifyFragment = this.a;
              tagForModifyFragment.a(TagForModifyFragment.k(tagForModifyFragment), TagForModifyFragment.c(this.a));
              tagForModifyFragment = this.a;
              tagForModifyFragment.a(TagForModifyFragment.k(tagForModifyFragment), TagForModifyFragment.e(this.a));
              tagForModifyFragment = this.a;
              tagForModifyFragment.a(TagForModifyFragment.k(tagForModifyFragment), TagForModifyFragment.g(this.a));
              tagForModifyFragment = this.a;
              tagForModifyFragment.a(TagForModifyFragment.k(tagForModifyFragment), TagForModifyFragment.i(this.a));
              tagForModifyFragment = this.a;
              TagForModifyFragment.a(tagForModifyFragment, new UserTagAdapter(TagForModifyFragment.l(tagForModifyFragment), TagForModifyFragment.a(this.a)));
              tagForModifyFragment = this.a;
              TagForModifyFragment.b(tagForModifyFragment, new UserTagAdapter(TagForModifyFragment.l(tagForModifyFragment), TagForModifyFragment.c(this.a)));
              tagForModifyFragment = this.a;
              TagForModifyFragment.c(tagForModifyFragment, new UserTagAdapter(TagForModifyFragment.l(tagForModifyFragment), TagForModifyFragment.e(this.a)));
              tagForModifyFragment = this.a;
              TagForModifyFragment.d(tagForModifyFragment, new UserTagAdapter(TagForModifyFragment.l(tagForModifyFragment), TagForModifyFragment.g(this.a)));
              tagForModifyFragment = this.a;
              TagForModifyFragment.e(tagForModifyFragment, new UserTagAdapter(TagForModifyFragment.l(tagForModifyFragment), TagForModifyFragment.i(this.a)));
              TagForModifyFragment.m(this.a).setAdapter((ListAdapter)TagForModifyFragment.b(this.a));
              TagForModifyFragment.n(this.a).setAdapter((ListAdapter)TagForModifyFragment.d(this.a));
              TagForModifyFragment.o(this.a).setAdapter((ListAdapter)TagForModifyFragment.f(this.a));
              TagForModifyFragment.p(this.a).setAdapter((ListAdapter)TagForModifyFragment.h(this.a));
              TagForModifyFragment.q(this.a).setAdapter((ListAdapter)TagForModifyFragment.j(this.a));
            } 
          }
          
          public void onUIFinish() {
            DialogUtils.b(TagForModifyFragment.r(this.a));
          }
          
          public void onUIStart() {
            super.onUIStart();
            DialogUtils.a(TagForModifyFragment.r(this.a));
          }
        }(IRequestHost)w_());
  }
  
  public void o() {
    int j;
    this.l.clear();
    byte b = 0;
    int i;
    for (i = 0; i < this.g.size(); i++) {
      if (((UserTag)this.g.get(i)).checked == 1)
        this.l.add(((UserTag)this.g.get(i)).id); 
    } 
    for (i = 0; i < this.h.size(); i++) {
      if (((UserTag)this.h.get(i)).checked == 1)
        this.l.add(((UserTag)this.h.get(i)).id); 
    } 
    for (i = 0; i < this.i.size(); i++) {
      if (((UserTag)this.i.get(i)).checked == 1)
        this.l.add(((UserTag)this.i.get(i)).id); 
    } 
    i = 0;
    while (true) {
      j = b;
      if (i < this.j.size()) {
        if (((UserTag)this.j.get(i)).checked == 1)
          this.l.add(((UserTag)this.j.get(i)).id); 
        i++;
        continue;
      } 
      break;
    } 
    while (j < this.k.size()) {
      if (((UserTag)this.k.get(j)).checked == 1)
        this.l.add(((UserTag)this.k.get(j)).id); 
      j++;
    } 
  }
  
  public void onClick(View paramView) {
    int i = paramView.getId();
    if (i != 2131296863) {
      if (i != 2131296867)
        return; 
      StringBuffer stringBuffer = new StringBuffer();
      o();
      if (this.l != null)
        for (i = 0; i < this.l.size(); i++) {
          String str;
          StringBuilder stringBuilder = new StringBuilder();
          if (StringUtils.e(stringBuffer.toString())) {
            str = "";
          } else {
            str = ",";
          } 
          stringBuilder.append(str);
          stringBuilder.append(this.l.get(i));
          stringBuffer.append(stringBuilder.toString());
        }  
      if (this.x) {
        Map<String, String> map = BluedHttpTools.a();
        map.put("tags", stringBuffer.toString());
        a(map);
        return;
      } 
      Intent intent = new Intent();
      intent.putExtra("CHOOSED_TAG_LIST", this.l);
      getActivity().setResult(-1, intent);
      getActivity().finish();
      return;
    } 
    getActivity().finish();
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
    this.d = (Context)getActivity();
    View view = this.e;
    if (view == null) {
      this.e = paramLayoutInflater.inflate(2131493341, paramViewGroup, false);
      Bundle bundle = getArguments();
      if (bundle != null) {
        this.x = bundle.getBoolean("ifNeedPostOnRightClick");
        if (bundle.getStringArrayList("choosedList") != null)
          this.l.addAll(bundle.getStringArrayList("choosedList")); 
        this.m = bundle.getInt("from");
      } 
      a();
      m();
      n();
    } else if (view.getParent() != null) {
      ((ViewGroup)this.e.getParent()).removeView(this.e);
    } 
    return this.e;
  }
  
  public void p() {
    CommonAlertDialog.a((Context)getActivity(), null, getResources().getString(2131758705), getResources().getString(2131758996), new DialogInterface.OnClickListener(this) {
          public void onClick(DialogInterface param1DialogInterface, int param1Int) {
            ModifyUserInfoFragment.a(TagForModifyFragment.l(this.a), 601, false);
          }
        }getResources().getString(2131755726), new DialogInterface.OnClickListener(this) {
          public void onClick(DialogInterface param1DialogInterface, int param1Int) {
            this.a.getActivity().finish();
          }
        },  null);
  }
  
  public static interface FROM_PAGE {}
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\u\\user\fragment\TagForModifyFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */