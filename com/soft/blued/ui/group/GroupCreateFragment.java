package com.soft.blued.ui.group;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.Selection;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextWatcher;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.blued.android.core.AppMethods;
import com.blued.android.core.BlueAppLocal;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.pool.ThreadExecutor;
import com.blued.android.framework.pool.ThreadManager;
import com.blued.android.module.common.utils.DialogUtils;
import com.blued.das.message.MessageProtos;
import com.soft.blued.customview.CommonTopTitleNoTrans;
import com.soft.blued.customview.NoDataAndLoadFailView;
import com.soft.blued.http.GroupHttpUtils;
import com.soft.blued.http.H5Url;
import com.soft.blued.log.model.LogData;
import com.soft.blued.ui.group.model.BluedCreatedGroupInfo;
import com.soft.blued.ui.group.model.BluedGroupCheck;
import com.soft.blued.ui.msg.controller.tools.ChatHelperV4;
import com.soft.blued.ui.msg.model.MsgSourceEntity;
import com.soft.blued.ui.setting.fragment.PersonalVerifyFragment;
import com.soft.blued.ui.user.fragment.ChooseCountryFragment;
import com.soft.blued.ui.user.model.VerifyStatus;
import com.soft.blued.ui.web.WebViewShowInfoFragment;
import com.soft.blued.user.UserInfo;
import com.soft.blued.utils.BluedPreferences;
import com.soft.blued.utils.Logger;
import com.soft.blued.utils.StringUtils;
import java.util.ArrayList;
import java.util.List;

public class GroupCreateFragment extends BaseFragment implements View.OnClickListener {
  public static int d = 256;
  
  public static String f = "account";
  
  public static String g = "groupNum";
  
  public static String h = "groupNumRest";
  
  public static String i = "accountAble";
  
  public static String j = "groupAble";
  
  private TextView A;
  
  private TextView B;
  
  private TextView C;
  
  private ImageView D;
  
  private ImageView E;
  
  private TextView F;
  
  private String G;
  
  private String H;
  
  private String I;
  
  private String J;
  
  private String K;
  
  private String L;
  
  private BluedUIHttpResponse M = new BluedUIHttpResponse<BluedEntityA<BluedGroupCheck>>(this) {
      public void a(BluedEntityA<BluedGroupCheck> param1BluedEntityA) {
        if (this.a.w_() != null) {
          if (!this.a.w_().isActive())
            return; 
          if (param1BluedEntityA != null) {
            try {
              if (param1BluedEntityA.hasData()) {
                GroupCreateFragment.e(this.a).c();
                if ("1".equals(((BluedGroupCheck)param1BluedEntityA.data.get(0)).getAble())) {
                  GroupCreateFragment.f(this.a).setVisibility(0);
                  GroupCreateFragment.g(this.a).setVisibility(8);
                  this.a.getActivity().getWindow().setSoftInputMode(21);
                  return;
                } 
                GroupCreateFragment.f(this.a).setVisibility(8);
                GroupCreateFragment.g(this.a).setVisibility(0);
                this.a.e = ((BluedGroupCheck)param1BluedEntityA.data.get(0)).getReason();
                GroupCreateFragment.b(this.a, this.a.e.getDays().getAble());
                GroupCreateFragment.c(this.a, this.a.e.getDays().getReason());
                GroupCreateFragment.d(this.a, this.a.e.getNum().getAble());
                GroupCreateFragment.e(this.a, this.a.e.getNum().getReason().get(0));
                GroupCreateFragment.f(this.a, this.a.e.getNum().getReason().get(1));
                GroupCreateFragment.h(this.a);
                return;
              } 
              GroupCreateFragment.e(this.a).b();
              return;
            } catch (Exception exception) {
              exception.printStackTrace();
              AppMethods.a(this.a.getResources().getString(2131756082));
              GroupCreateFragment.e(this.a).b();
            } 
            return;
          } 
        } else {
          return;
        } 
        GroupCreateFragment.e(this.a).b();
      }
      
      public void onFailure(Throwable param1Throwable, int param1Int, String param1String) {
        super.onFailure(param1Throwable, param1Int, param1String);
        this.a.a(new Runnable(this) {
              public void run() {
                GroupCreateFragment.e(this.a.a).b();
              }
            });
      }
      
      public void onUIFinish() {
        Logger.a(GroupCreateFragment.i(this.a), new Object[] { "onFinish" });
        DialogUtils.b(GroupCreateFragment.d(this.a));
      }
      
      public void onUIStart() {
        DialogUtils.a(GroupCreateFragment.d(this.a));
      }
    };
  
  private TextWatcher N = new TextWatcher(this) {
      private int b;
      
      private int c;
      
      public void afterTextChanged(Editable param1Editable) {
        try {
          this.b = GroupCreateFragment.l(this.a).getSelectionStart();
          this.c = GroupCreateFragment.l(this.a).getSelectionEnd();
          GroupCreateFragment.l(this.a).removeTextChangedListener(GroupCreateFragment.o(this.a));
          while (param1Editable.length() > GroupCreateFragment.d) {
            param1Editable.delete(this.b - 1, this.c);
            this.b--;
            this.c--;
          } 
          int i = param1Editable.length();
          TextView textView = GroupCreateFragment.p(this.a);
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append(i);
          stringBuilder.append(" ");
          textView.setText(stringBuilder.toString());
          GroupCreateFragment.l(this.a).setSelection(this.b);
          GroupCreateFragment.l(this.a).addTextChangedListener(GroupCreateFragment.o(this.a));
          return;
        } catch (Exception exception) {
          exception.printStackTrace();
          GroupCreateFragment.p(this.a).setText("");
          return;
        } 
      }
      
      public void beforeTextChanged(CharSequence param1CharSequence, int param1Int1, int param1Int2, int param1Int3) {}
      
      public void onTextChanged(CharSequence param1CharSequence, int param1Int1, int param1Int2, int param1Int3) {}
    };
  
  public BluedGroupCheck.GroupFailureReason e;
  
  public BluedUIHttpResponse k = new BluedUIHttpResponse<BluedEntity>(this) {
      public void onUIUpdate(BluedEntity param1BluedEntity) {
        (new Bundle()).putString("groupName", GroupCreateFragment.j(this.a).getText().toString());
        GroupHttpUtils.d(GroupCreateFragment.k(this.a), this.a.l, GroupCreateFragment.l(this.a).getText().toString(), (IRequestHost)this.a.w_());
      }
    };
  
  public BluedUIHttpResponse l = new BluedUIHttpResponse<BluedEntity>(this) {
      public void onUIUpdate(BluedEntity param1BluedEntity) {
        ChooseCountryFragment.a(this.a, 8000);
      }
    };
  
  public BluedUIHttpResponse m = new BluedUIHttpResponse<BluedEntityA<BluedCreatedGroupInfo>>(this) {
      protected void a(BluedEntityA<BluedCreatedGroupInfo> param1BluedEntityA) {
        if (param1BluedEntityA != null && param1BluedEntityA.hasData()) {
          AppMethods.a(this.a.getResources().getString(2131756652));
          GroupCreateFragment.m(this.a).clear();
          GroupCreateFragment.m(this.a).addAll(param1BluedEntityA.data);
          GroupCreateFragment.n(this.a);
        } 
      }
      
      public void onUIFinish() {
        super.onUIFinish();
        DialogUtils.b(GroupCreateFragment.d(this.a));
      }
      
      public void onUIStart() {
        super.onUIStart();
        DialogUtils.a(GroupCreateFragment.d(this.a));
      }
    };
  
  private String n = GroupCreateFragment.class.getSimpleName();
  
  private View o;
  
  private CommonTopTitleNoTrans p;
  
  private EditText q;
  
  private EditText r;
  
  private TextView s;
  
  private Context t;
  
  private Dialog u;
  
  private List<BluedCreatedGroupInfo> v;
  
  private View w;
  
  private View x;
  
  private NoDataAndLoadFailView y;
  
  private TextView z;
  
  private void a() {
    this.v = new ArrayList<BluedCreatedGroupInfo>();
    this.w = this.o.findViewById(2131298765);
    this.x = this.o.findViewById(2131298764);
    this.y = (NoDataAndLoadFailView)this.o.findViewById(2131299389);
    this.y.setFailBtnListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            GroupCreateFragment.a(this.a);
            GroupCreateFragment.b(this.a);
          }
        });
    this.s = (TextView)this.w.findViewById(2131301533);
    TextView textView = this.s;
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append(getResources().getText(2131756730));
    stringBuilder1.append(" ");
    textView.setText(stringBuilder1.toString());
    this.q = (EditText)this.w.findViewById(2131297001);
    this.r = (EditText)this.w.findViewById(2131297000);
    this.r.addTextChangedListener(this.N);
    EditText editText = this.r;
    editText.setSelection(editText.length());
    this.B = (TextView)this.o.findViewById(2131300821);
    this.C = (TextView)this.o.findViewById(2131300822);
    this.D = (ImageView)this.o.findViewById(2131297668);
    this.E = (ImageView)this.o.findViewById(2131297787);
    this.z = (TextView)this.o.findViewById(2131301486);
    this.A = (TextView)this.o.findViewById(2131300593);
    this.A.setOnClickListener(this);
    this.F = (TextView)this.o.findViewById(2131300867);
    String str1 = this.t.getResources().getString(2131756651);
    String str2 = this.t.getResources().getString(2131756791);
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append(str1);
    stringBuilder2.append(str2);
    SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(stringBuilder2.toString());
    RevoClickSpan revoClickSpan = new RevoClickSpan(this, this.t);
    StringBuilder stringBuilder3 = new StringBuilder();
    stringBuilder3.append(str1);
    stringBuilder3.append(str2);
    int i = stringBuilder3.toString().length();
    int j = str2.length();
    stringBuilder3 = new StringBuilder();
    stringBuilder3.append(str1);
    stringBuilder3.append(str2);
    spannableStringBuilder.setSpan(revoClickSpan, i - j, stringBuilder3.toString().length(), 33);
    this.F.setText((CharSequence)spannableStringBuilder);
    this.F.setOnClickListener(this);
  }
  
  private void k() {
    this.p = (CommonTopTitleNoTrans)this.o.findViewById(2131300300);
    this.p.a();
    this.p.setCenterText(getString(2131756649));
    this.p.setLeftClickListener(this);
    this.p.setRightClickListener(this);
    this.p.setRightText(this.t.getString(2131758218));
    this.u = DialogUtils.a(this.t);
  }
  
  private void l() {
    try {
      this.p.a();
      boolean bool = this.G.equals("0");
      if (bool) {
        TextView textView = this.B;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(getResources().getString(2131756613));
        stringBuilder.append(" ");
        stringBuilder.append(this.I);
        stringBuilder.append(" ");
        stringBuilder.append(getResources().getString(2131756615));
        textView.setText(stringBuilder.toString());
      } else {
        TextView textView = this.B;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(getResources().getString(2131756614));
        stringBuilder.append(" ");
        stringBuilder.append(this.I);
        stringBuilder.append(" ");
        stringBuilder.append(getResources().getString(2131756615));
        textView.setText(stringBuilder.toString());
      } 
      if (BlueAppLocal.d()) {
        TextView textView = this.C;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(getResources().getString(2131756654));
        stringBuilder.append(" ");
        stringBuilder.append(this.J);
        stringBuilder.append(" ");
        stringBuilder.append(getResources().getString(2131756766));
        stringBuilder.append(getResources().getString(2131756768));
        stringBuilder.append(" ");
        stringBuilder.append(this.K);
        stringBuilder.append(" ");
        stringBuilder.append(getResources().getString(2131756767));
        textView.setText(stringBuilder.toString());
      } else {
        int i = StringUtils.a(this.J, 0);
        int j = StringUtils.a(this.K, 0);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(getResources().getString(2131756654));
        stringBuilder.append(" ");
        stringBuilder.append(i);
        stringBuilder.append(" ");
        stringBuilder.append(getResources().getString(2131756768));
        stringBuilder.append(" ");
        stringBuilder.append(j + i);
        String str = stringBuilder.toString();
        this.C.setText(str);
      } 
      String str2 = this.B.getText().toString();
      String str1 = this.C.getText().toString();
      SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(str2);
      SpannableStringBuilder spannableStringBuilder1 = new SpannableStringBuilder(str1);
      if (BlueAppLocal.d()) {
        if (this.G.equals("0")) {
          spannableStringBuilder2.setSpan(new ForegroundColorSpan(this.t.getResources().getColor(2131100538)), 9, 11, 33);
        } else {
          spannableStringBuilder2.setSpan(new ForegroundColorSpan(this.t.getResources().getColor(2131100539)), 9, 11, 33);
        } 
        if (this.H.equals("0")) {
          spannableStringBuilder1.setSpan(new ForegroundColorSpan(this.t.getResources().getColor(2131100538)), 14, 15, 33);
        } else {
          spannableStringBuilder1.setSpan(new ForegroundColorSpan(this.t.getResources().getColor(2131100539)), 14, 15, 33);
        } 
      } else {
        if (this.G.equals("0")) {
          spannableStringBuilder2.setSpan(new ForegroundColorSpan(this.t.getResources().getColor(2131100538)), 13, 15, 33);
        } else {
          spannableStringBuilder2.setSpan(new ForegroundColorSpan(this.t.getResources().getColor(2131100539)), 13, 15, 33);
        } 
        if (this.H.equals("0")) {
          spannableStringBuilder1.setSpan(new ForegroundColorSpan(this.t.getResources().getColor(2131100538)), 15, 16, 33);
        } else {
          spannableStringBuilder1.setSpan(new ForegroundColorSpan(this.t.getResources().getColor(2131100539)), 15, 16, 33);
        } 
      } 
      this.B.setText((CharSequence)spannableStringBuilder2);
      this.C.setText((CharSequence)spannableStringBuilder1);
      if (this.G.equals("0")) {
        this.D.setBackgroundResource(2131232320);
      } else {
        this.D.setBackgroundResource(2131232319);
      } 
      if (this.H.equals("0")) {
        this.E.setBackgroundResource(2131232320);
        return;
      } 
      this.E.setBackgroundResource(2131232319);
      return;
    } catch (Exception exception) {
      exception.printStackTrace();
      return;
    } 
  }
  
  private void m() {
    GroupHttpUtils.b(this.t, this.M, UserInfo.a().i().getUid(), null);
  }
  
  private void n() {
    GroupHttpUtils.k(null, new BluedUIHttpResponse<BluedEntityA<VerifyStatus>>(this) {
          public void a(BluedEntityA<VerifyStatus> param1BluedEntityA) {
            if (param1BluedEntityA != null)
              try {
                if (param1BluedEntityA.hasData()) {
                  VerifyStatus verifyStatus = param1BluedEntityA.data.get(0);
                  UserInfo.a().i().setVerify(new VerifyStatus[] { verifyStatus }, );
                  GroupCreateFragment.a(this.a, (UserInfo.a().i().getVerify()[0]).has_audited);
                  GroupCreateFragment.c(this.a);
                  return;
                } 
              } catch (Exception exception) {
                exception.printStackTrace();
              }  
          }
        }UserInfo.a().i().getUid(), null);
  }
  
  private void o() {
    if ("1".equals(this.L)) {
      this.z.setVisibility(8);
      this.A.setVisibility(8);
      return;
    } 
    this.z.setVisibility(0);
    this.A.setVisibility(0);
  }
  
  private void p() {
    BluedCreatedGroupInfo bluedCreatedGroupInfo = this.v.get(0);
    if (bluedCreatedGroupInfo == null)
      return; 
    DialogUtils.a(this.u);
    ThreadManager.a().a(new ThreadExecutor(this, "toChat", bluedCreatedGroupInfo) {
          public void execute() {
            ChatHelperV4.a().a(GroupCreateFragment.k(this.b), this.a);
            this.b.a(new Runnable(this) {
                  public void run() {
                    LogData logData = new LogData();
                    logData.g = "group_create";
                    ChatHelperV4.a().a(GroupCreateFragment.k(this.a.b), Long.parseLong(this.a.a.groups_gid), this.a.a.groups_name, this.a.a.groups_avatar, this.a.a.vbadge, 0, 0, 0, "", false, 1, 0, logData, new MsgSourceEntity(MessageProtos.StrangerSource.UNKNOWN_STRANGER_SOURCE, ""));
                    DialogUtils.b(GroupCreateFragment.d(this.a.b));
                    this.a.b.getActivity().finish();
                  }
                });
          }
        });
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt1 != 8000)
      return; 
    if (paramIntent != null && !StringUtils.e(paramIntent.getStringExtra("areacode"))) {
      String str = paramIntent.getStringExtra("areacode");
      GroupHttpUtils.a((Context)getActivity(), this.m, this.q.getText().toString(), this.r.getText().toString(), str, BluedPreferences.s(), BluedPreferences.t(), (IRequestHost)w_());
      return;
    } 
    AppMethods.d(2131756701);
  }
  
  public void onClick(View paramView) {
    switch (paramView.getId()) {
      default:
        return;
      case 2131301244:
        m();
        n();
        return;
      case 2131300867:
        WebViewShowInfoFragment.show(this.t, H5Url.a(26), 0);
        return;
      case 2131300593:
        PersonalVerifyFragment.a((Context)getActivity());
        return;
      case 2131296867:
        if (!StringUtils.e(this.q.getText().toString()) && !StringUtils.e(this.r.getText().toString())) {
          GroupHttpUtils.c(this.t, this.k, this.q.getText().toString(), (IRequestHost)w_());
          return;
        } 
        if (!StringUtils.e(this.q.getText().toString()) && StringUtils.e(this.r.getText().toString())) {
          AppMethods.d(2131756656);
          return;
        } 
        AppMethods.d(2131756733);
        return;
      case 2131296863:
        break;
    } 
    getActivity().finish();
  }
  
  public void onCreate(Bundle paramBundle) {
    this.t = (Context)getActivity();
    super.onCreate(paramBundle);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
    this.o = paramLayoutInflater.inflate(2131493301, paramViewGroup, false);
    a();
    k();
    return this.o;
  }
  
  public void onStart() {
    super.onStart();
    m();
    n();
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle) {
    super.onViewCreated(paramView, paramBundle);
  }
  
  public class RevoClickSpan extends ClickableSpan {
    Context a;
    
    public RevoClickSpan(GroupCreateFragment this$0, Context param1Context) {
      this.a = param1Context;
    }
    
    public void onClick(View param1View) {
      Selection.removeSelection((Spannable)((TextView)param1View).getText());
      WebViewShowInfoFragment.show(this.a, H5Url.a(26), 0);
    }
    
    public void updateDrawState(TextPaint param1TextPaint) {
      param1TextPaint.setColor(this.a.getResources().getColor(2131100556));
      param1TextPaint.setUnderlineText(false);
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\group\GroupCreateFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */