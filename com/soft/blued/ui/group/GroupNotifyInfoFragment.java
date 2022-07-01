package com.soft.blued.ui.group;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.blued.android.core.AppInfo;
import com.blued.android.core.AppMethods;
import com.blued.android.core.BlueAppLocal;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.imagecache.LoadOptions;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.module.common.utils.DialogUtils;
import com.google.gson.internal.LinkedTreeMap;
import com.google.gson.reflect.TypeToken;
import com.soft.blued.customview.CommonTopTitleNoTrans;
import com.soft.blued.http.BluedHttpUrl;
import com.soft.blued.http.GroupHttpUtils;
import com.soft.blued.ui.find.model.UserBasicModel;
import com.soft.blued.ui.group.fragment.GroupInfoFragment;
import com.soft.blued.ui.group.model.BluedGroupNotifyInfo;
import com.soft.blued.ui.group.model.BluedGroupOpsAlreadyNotify;
import com.soft.blued.ui.user.fragment.UserInfoFragmentNew;
import com.soft.blued.ui.web.WebViewShowInfoFragment;
import com.soft.blued.user.UserInfo;
import com.soft.blued.utils.StringUtils;
import com.soft.blued.utils.TimeAndDateUtils;
import com.soft.blued.utils.UserRelationshipUtils;
import java.util.ArrayList;

public class GroupNotifyInfoFragment extends BaseFragment implements View.OnClickListener {
  private Dialog A;
  
  private String B;
  
  private String C;
  
  private String D;
  
  private String E;
  
  private String F;
  
  private String G;
  
  private String H;
  
  private String I;
  
  private String J;
  
  private String K;
  
  private String L;
  
  private String M;
  
  private String N;
  
  private String O;
  
  private String P;
  
  private String Q;
  
  private int R;
  
  private int S;
  
  private LoadOptions T;
  
  private String U = "/";
  
  private String d = GroupNotifyInfoFragment.class.getSimpleName();
  
  private LinearLayout e;
  
  private LinearLayout f;
  
  private LinearLayout g;
  
  private LinearLayout h;
  
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
  
  private TextView s;
  
  private TextView t;
  
  private Button u;
  
  private Button v;
  
  private ImageView w;
  
  private ImageView x;
  
  private View y;
  
  private Context z;
  
  private void a() {
    this.A = DialogUtils.a(this.z);
    this.e = (LinearLayout)this.y.findViewById(2131298855);
    this.e.setOnClickListener(this);
    this.f = (LinearLayout)this.y.findViewById(2131298857);
    this.g = (LinearLayout)this.y.findViewById(2131298854);
    this.h = (LinearLayout)this.y.findViewById(2131298851);
    this.i = (TextView)this.y.findViewById(2131301475);
    this.j = (TextView)this.y.findViewById(2131301473);
    this.k = (TextView)this.y.findViewById(2131300851);
    this.k.setOnClickListener(this);
    this.l = (TextView)this.y.findViewById(2131300817);
    this.o = (TextView)this.y.findViewById(2131300860);
    this.p = (TextView)this.y.findViewById(2131300856);
    this.q = (TextView)this.y.findViewById(2131300859);
    this.q.setOnClickListener(this);
    this.r = (TextView)this.y.findViewById(2131300857);
    this.s = (TextView)this.y.findViewById(2131300858);
    this.s.setOnClickListener(this);
    this.t = (TextView)this.y.findViewById(2131300862);
    this.n = (TextView)this.y.findViewById(2131297292);
    this.m = (TextView)this.y.findViewById(2131300839);
    this.w = (ImageView)this.y.findViewById(2131297793);
    this.x = (ImageView)this.y.findViewById(2131297788);
    this.u = (Button)this.y.findViewById(2131296596);
    this.u.setOnClickListener(this);
    this.v = (Button)this.y.findViewById(2131296592);
    this.v.setOnClickListener(this);
    if (getArguments() != null) {
      this.B = getArguments().getString("UID");
      this.D = getArguments().getString("avatar");
      this.C = getArguments().getString("nickname");
      this.E = getArguments().getString("age");
      this.F = getArguments().getString("height");
      this.G = getArguments().getString("weight");
      this.H = getArguments().getString("role");
      this.M = getArguments().getString("iid");
      if ("-1".equals(this.H))
        this.H = "~"; 
      this.I = getArguments().getString("groupName");
      this.J = getArguments().getString("groupId");
      this.K = getArguments().getString("group avatar");
      this.L = getArguments().getString("applyDescrible");
      this.N = getArguments().getString("ops");
      this.O = getArguments().getString("time");
      this.P = getArguments().getString("opsuid");
      this.Q = getArguments().getString("opsname");
      this.S = getArguments().getInt("vbadge");
      this.R = getArguments().getInt("type");
    } 
    if (2 != this.R) {
      this.h.setVisibility(8);
      this.g.setVisibility(0);
      ImageLoader.a((IRequestHost)w_(), this.K).c().a(2131234356).a(this.w);
      this.i.setText(this.I);
      if (!TextUtils.isEmpty(this.J)) {
        TextView textView = this.j;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(getResources().getString(2131756669));
        stringBuilder.append(this.J);
        textView.setText(stringBuilder.toString());
      } else {
        this.j.setVisibility(4);
      } 
      if (!TextUtils.isEmpty(this.O)) {
        String str = TimeAndDateUtils.g((Context)getActivity(), TimeAndDateUtils.b(this.O));
        this.o.setVisibility(0);
        this.o.setText(str);
      } else {
        this.o.setVisibility(4);
      } 
      int i = this.R;
      if (1 == i) {
        this.q.setVisibility(8);
        this.p.setVisibility(0);
        this.r.setVisibility(0);
        this.p.setText(getResources().getString(2131756673));
        return;
      } 
      if (i == 0) {
        this.p.setVisibility(0);
        this.r.setVisibility(8);
        this.t.setVisibility(0);
        if (BlueAppLocal.d()) {
          this.q.setText(BluedHttpUrl.e());
          this.q.setVisibility(0);
        } else {
          this.q.setVisibility(8);
        } 
        String str = String.format(getResources().getString(2131756761), new Object[] { this.I });
        this.p.setText(str);
        return;
      } 
      if (3 == i) {
        this.q.setVisibility(8);
        a(this.p, this.C, this.B, this.D);
        return;
      } 
    } else {
      StringBuilder stringBuilder1;
      StringBuilder stringBuilder2;
      this.h.setVisibility(0);
      ImageLoader.a((IRequestHost)w_(), this.D).c().a(2131234356).a(this.w);
      UserRelationshipUtils.a(this.x, this.S, 3);
      this.i.setText(this.C);
      if (BlueAppLocal.c().getLanguage().equals("zh")) {
        stringBuilder1 = new StringBuilder();
        stringBuilder1.append(this.E);
        stringBuilder1.append(this.U);
        stringBuilder1.append(StringUtils.a(this.F, BlueAppLocal.c(), false));
        stringBuilder1.append(this.U);
        stringBuilder1.append(StringUtils.b(this.G, BlueAppLocal.c(), false));
        stringBuilder1.append(this.U);
        stringBuilder1.append(this.H);
        str2 = stringBuilder1.toString();
      } else {
        stringBuilder1 = new StringBuilder();
        stringBuilder1.append(this.E);
        stringBuilder1.append(" yrs");
        stringBuilder1.append(this.U);
        stringBuilder1.append(StringUtils.a(this.F, BlueAppLocal.c(), true));
        stringBuilder1.append(this.U);
        stringBuilder1.append(StringUtils.b(this.G, BlueAppLocal.c(), true));
        stringBuilder1.append(this.U);
        stringBuilder1.append(this.H);
        str2 = stringBuilder1.toString();
      } 
      String str2 = str2.replace("NULL", "").replace("null", "");
      while (true) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.U);
        stringBuilder.append(this.U);
        String str = str2;
        if (str2.contains(stringBuilder.toString())) {
          stringBuilder2 = new StringBuilder();
          stringBuilder2.append(this.U);
          stringBuilder2.append(this.U);
          str2 = str2.replace(stringBuilder2.toString(), this.U);
          continue;
        } 
        break;
      } 
      while (true) {
        stringBuilder1 = stringBuilder2;
        if (stringBuilder2.contains("  ")) {
          String str = stringBuilder2.replace("  ", " ");
          continue;
        } 
        break;
      } 
      while (stringBuilder1.contains(" / / "))
        str1 = stringBuilder1.replace(" / / ", ""); 
      this.j.setText(str1);
      this.k.setText(this.I);
      if (!StringUtils.e(this.L)) {
        this.l.setText(this.L);
      } else {
        this.l.setVisibility(8);
      } 
      String str1 = UserInfo.a().i().getUid();
      if (this.N.equals("allowed")) {
        this.f.setVisibility(8);
        this.n.setVisibility(0);
        if (str1.equals(this.P)) {
          this.n.setText(2131756752);
        } else {
          str1 = this.z.getResources().getString(2131756751);
          this.n.setText(String.format(str1, new Object[] { this.Q }));
        } 
      } else if (this.N.equals("denied")) {
        this.f.setVisibility(8);
        this.n.setVisibility(0);
        if (str1.equals(this.P)) {
          this.n.setText(2131756765);
        } else {
          str1 = this.z.getResources().getString(2131756764);
          this.n.setText(String.format(str1, new Object[] { this.Q }));
        } 
      } else {
        this.f.setVisibility(0);
        this.n.setVisibility(8);
      } 
      this.m.setText(TimeAndDateUtils.g((Context)getActivity(), TimeAndDateUtils.b(this.O)));
      GroupHttpUtils.c(this.z, new BluedUIHttpResponse<BluedEntityA<BluedGroupNotifyInfo>>(this) {
            protected void a(BluedEntityA<BluedGroupNotifyInfo> param1BluedEntityA) {
              try {
                if (param1BluedEntityA.hasData()) {
                  ArrayList arrayList = new ArrayList();
                  arrayList.addAll(param1BluedEntityA.data);
                  String str2 = ((BluedGroupNotifyInfo)arrayList.get(0)).operator.toString();
                  GroupNotifyInfoFragment.a(this.a, ((BluedGroupNotifyInfo)arrayList.get(0)).ops);
                  if ("[]".equals(str2))
                    return; 
                  LinkedTreeMap linkedTreeMap = (LinkedTreeMap)((BluedGroupNotifyInfo)arrayList.get(0)).operator;
                  GroupNotifyInfoFragment.b(this.a, linkedTreeMap.get("name").toString());
                  String str1 = UserInfo.a().i().getName();
                  if (GroupNotifyInfoFragment.b(this.a).equals("allowed")) {
                    GroupNotifyInfoFragment.c(this.a).setVisibility(8);
                    GroupNotifyInfoFragment.d(this.a).setVisibility(0);
                    if (str1.equals(GroupNotifyInfoFragment.e(this.a))) {
                      GroupNotifyInfoFragment.d(this.a).setText(2131756752);
                      return;
                    } 
                    str1 = GroupNotifyInfoFragment.f(this.a).getResources().getString(2131756751);
                    GroupNotifyInfoFragment.d(this.a).setText(String.format(str1, new Object[] { GroupNotifyInfoFragment.e(this.a) }));
                    return;
                  } 
                  if (GroupNotifyInfoFragment.b(this.a).equals("denied")) {
                    GroupNotifyInfoFragment.c(this.a).setVisibility(8);
                    GroupNotifyInfoFragment.d(this.a).setVisibility(0);
                    if (str1.equals(GroupNotifyInfoFragment.e(this.a))) {
                      GroupNotifyInfoFragment.d(this.a).setText(2131756765);
                      return;
                    } 
                    str1 = GroupNotifyInfoFragment.f(this.a).getResources().getString(2131756764);
                    GroupNotifyInfoFragment.d(this.a).setText(String.format(str1, new Object[] { GroupNotifyInfoFragment.e(this.a) }));
                    return;
                  } 
                  GroupNotifyInfoFragment.c(this.a).setVisibility(0);
                  GroupNotifyInfoFragment.d(this.a).setVisibility(8);
                  return;
                } 
              } catch (Exception exception) {
                exception.printStackTrace();
              } 
            }
            
            public void onUIFinish() {
              super.onUIFinish();
              DialogUtils.b(GroupNotifyInfoFragment.a(this.a));
            }
            
            public void onUIStart() {
              super.onUIStart();
              DialogUtils.a(GroupNotifyInfoFragment.a(this.a));
            }
          }UserInfo.a().i().getUid(), this.M, (IRequestHost)w_());
    } 
  }
  
  private void a(TextView paramTextView, String paramString1, String paramString2, String paramString3) {
    SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(String.format(getResources().getString(2131756762), new Object[] { paramString1 }));
    if (!TextUtils.isEmpty(paramString1)) {
      paramTextView.setVisibility(0);
      if (BlueAppLocal.d()) {
        spannableStringBuilder.setSpan(new Clickable(this, (Context)getActivity(), paramString2, paramString1, paramString3), 4, paramString1.length() + 4, 33);
      } else {
        spannableStringBuilder.setSpan(new Clickable(this, (Context)getActivity(), paramString2, paramString1, paramString3), 24, paramString1.length() + 24, 33);
      } 
      paramTextView.setText((CharSequence)spannableStringBuilder);
      paramTextView.setMovementMethod(LinkMovementMethod.getInstance());
      return;
    } 
    paramTextView.setVisibility(4);
  }
  
  private void a(boolean paramBoolean) {
    String str;
    if (!paramBoolean) {
      str = "denied";
    } else {
      str = "allowed";
    } 
    GroupHttpUtils.d((Context)getActivity(), new BluedUIHttpResponse<BluedEntity>(this, paramBoolean) {
          boolean a;
          
          int b;
          
          String c;
          
          public boolean onUIFailure(int param1Int, String param1String1, String param1String2) {
            this.a = true;
            this.b = param1Int;
            this.c = param1String2;
            return super.onUIFailure(param1Int, param1String1, param1String2);
          }
          
          public void onUIFinish() {
            super.onUIFinish();
            DialogUtils.b(GroupNotifyInfoFragment.a(this.e));
            if (this.a && this.b == 403009014) {
              this.a = false;
              if (!StringUtils.e(this.c)) {
                BluedEntity bluedEntity = (BluedEntity)AppInfo.f().fromJson(this.c, (new TypeToken<BluedEntity<Object, BluedGroupOpsAlreadyNotify>>(this) {
                    
                    }).getType());
                String str = UserInfo.a().i().getUid();
                if (((BluedGroupOpsAlreadyNotify)bluedEntity.extra).ops.equals("allowed")) {
                  GroupNotifyInfoFragment.c(this.e).setVisibility(8);
                  GroupNotifyInfoFragment.d(this.e).setVisibility(0);
                  if (str.equals(((BluedGroupOpsAlreadyNotify)bluedEntity.extra).uid)) {
                    GroupNotifyInfoFragment.d(this.e).setText(2131756752);
                  } else {
                    str = GroupNotifyInfoFragment.f(this.e).getResources().getString(2131756751);
                    GroupNotifyInfoFragment.d(this.e).setText(String.format(str, new Object[] { ((BluedGroupOpsAlreadyNotify)bluedEntity.extra).name }));
                  } 
                } else if (((BluedGroupOpsAlreadyNotify)bluedEntity.extra).ops.equals("denied")) {
                  GroupNotifyInfoFragment.c(this.e).setVisibility(8);
                  GroupNotifyInfoFragment.d(this.e).setVisibility(0);
                  if (str.equals(((BluedGroupOpsAlreadyNotify)bluedEntity.extra).uid)) {
                    GroupNotifyInfoFragment.d(this.e).setText(2131756765);
                  } else {
                    str = GroupNotifyInfoFragment.f(this.e).getResources().getString(2131756764);
                    GroupNotifyInfoFragment.d(this.e).setText(String.format(str, new Object[] { ((BluedGroupOpsAlreadyNotify)bluedEntity.extra).name }));
                  } 
                } else {
                  GroupNotifyInfoFragment.c(this.e).setVisibility(0);
                  GroupNotifyInfoFragment.d(this.e).setVisibility(8);
                } 
                AppMethods.a(bluedEntity.message);
              } 
            } 
          }
          
          public void onUIStart() {
            super.onUIStart();
            DialogUtils.a(GroupNotifyInfoFragment.a(this.e));
          }
          
          public void onUIUpdate(BluedEntity param1BluedEntity) {
            try {
              GroupNotifyInfoFragment.c(this.e).setVisibility(8);
              GroupNotifyInfoFragment.d(this.e).setVisibility(0);
              if (this.d) {
                GroupNotifyInfoFragment.d(this.e).setText(2131756752);
                return;
              } 
              GroupNotifyInfoFragment.d(this.e).setText(2131756765);
              return;
            } catch (Exception exception) {
              exception.printStackTrace();
              return;
            } 
          }
        }UserInfo.a().i().getUid(), this.M, str, (IRequestHost)w_());
  }
  
  private void k() {
    CommonTopTitleNoTrans commonTopTitleNoTrans = (CommonTopTitleNoTrans)this.y.findViewById(2131300300);
    commonTopTitleNoTrans.a();
    commonTopTitleNoTrans.setCenterText(getString(2131756749));
    commonTopTitleNoTrans.setLeftClickListener(this);
  }
  
  private void l() {
    Intent intent = new Intent();
    getActivity().setResult(-1, intent);
    getActivity().finish();
  }
  
  public boolean V_() {
    l();
    return false;
  }
  
  public void onClick(View paramView) {
    String str;
    UserBasicModel userBasicModel;
    switch (paramView.getId()) {
      default:
        return;
      case 2131300859:
        str = BluedHttpUrl.e();
        WebViewShowInfoFragment.show(this.z, str, 7);
        return;
      case 2131300858:
        TerminalActivity.d((Context)getActivity(), GroupFragment.class, null);
        return;
      case 2131300851:
        GroupInfoFragment.a(this.z, this.J);
        return;
      case 2131298855:
        System.currentTimeMillis();
        if (this.R != 2) {
          GroupInfoFragment.a(this.z, this.J);
          return;
        } 
        userBasicModel = new UserBasicModel();
        userBasicModel.avatar = this.D;
        userBasicModel.uid = this.B;
        userBasicModel.name = this.C;
        UserInfoFragmentNew.a(this.z, userBasicModel, null, (View)this.w);
        return;
      case 2131296863:
        l();
        return;
      case 2131296596:
        a(false);
        return;
      case 2131296592:
        break;
    } 
    a(true);
  }
  
  public void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
    this.z = (Context)getActivity();
    View view = this.y;
    if (view == null) {
      this.y = paramLayoutInflater.inflate(2131493145, paramViewGroup, false);
      this.T = new LoadOptions();
      LoadOptions loadOptions = this.T;
      loadOptions.d = 2131234356;
      loadOptions.b = 2131234356;
      a();
      k();
    } else if (view.getParent() != null) {
      ((ViewGroup)this.y.getParent()).removeView(this.y);
    } 
    return this.y;
  }
  
  public class Clickable extends ClickableSpan {
    private Context b;
    
    private String c;
    
    private String d;
    
    private String e;
    
    public Clickable(GroupNotifyInfoFragment this$0, Context param1Context, String param1String1, String param1String2, String param1String3) {
      this.b = param1Context;
      this.c = param1String1;
      this.d = param1String2;
      this.e = param1String3;
    }
    
    public void onClick(View param1View) {
      if (!StringUtils.e(this.c)) {
        UserInfoFragmentNew.a(this.b, this.c, "");
        return;
      } 
      UserInfoFragmentNew.c(this.b, this.d, "");
    }
    
    public void updateDrawState(TextPaint param1TextPaint) {
      param1TextPaint.setColor(this.b.getResources().getColor(2131100602));
      param1TextPaint.setUnderlineText(false);
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\group\GroupNotifyInfoFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */