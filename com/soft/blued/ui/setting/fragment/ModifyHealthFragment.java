package com.soft.blued.ui.setting.fragment;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.module.common.utils.DialogUtils;
import com.blued.das.profile.PersonalProfileProtos;
import com.soft.blued.customview.CommonTopTitleNoTrans;
import com.soft.blued.http.Blued_healthUrl;
import com.soft.blued.log.trackUtils.EventTrackPersonalProfile;
import com.soft.blued.ui.user.model.UserTag;
import com.soft.blued.ui.web.WebViewShowInfoFragment;
import com.soft.blued.utils.TimeAndDateUtils;
import com.soft.blued.view.tip.CommonAlertDialog;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;

public class ModifyHealthFragment extends BaseFragment implements View.OnClickListener {
  private Context d;
  
  private View e;
  
  private Dialog f;
  
  private ArrayList<String> g = new ArrayList<String>();
  
  private List<UserTag> h = new ArrayList<UserTag>();
  
  private LinearLayout i;
  
  private LinearLayout j;
  
  private LinearLayout k;
  
  private LinearLayout l;
  
  private TextView m;
  
  private TextView n;
  
  private TextView o;
  
  private TextView p;
  
  private TextView q;
  
  private List<UserTag> r = new ArrayList<UserTag>();
  
  private List<UserTag> s = new ArrayList<UserTag>();
  
  private List<UserTag> t = new ArrayList<UserTag>();
  
  private String u;
  
  private String v;
  
  private String w;
  
  private void a() {
    Bundle bundle = getArguments();
    if (bundle != null) {
      this.u = bundle.getString("health_result");
      this.v = bundle.getString("health_time");
      this.w = bundle.getString("health_prep");
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("initData healthResult id:");
    stringBuilder.append(this.u);
    Log.v("drb", stringBuilder.toString());
    stringBuilder = new StringBuilder();
    stringBuilder.append("initData healthTime id:");
    stringBuilder.append(this.v);
    Log.v("drb", stringBuilder.toString());
    stringBuilder = new StringBuilder();
    stringBuilder.append("initData healthPrep id:");
    stringBuilder.append(this.w);
    Log.v("drb", stringBuilder.toString());
    m();
    l();
    k();
  }
  
  public static void a(BaseFragment paramBaseFragment, String paramString1, String paramString2, String paramString3, int paramInt) {
    Bundle bundle = new Bundle();
    bundle.putString("health_result", paramString1);
    bundle.putString("health_time", paramString2);
    bundle.putString("health_prep", paramString3);
    TerminalActivity.a((Fragment)paramBaseFragment, ModifyHealthFragment.class, bundle, paramInt);
  }
  
  private void k() {
    this.t.add(new UserTag("-1", getString(2131756965)));
    this.t.add(new UserTag("1", getString(2131756966)));
    this.t.add(new UserTag("2", getString(2131756967)));
    this.t.add(new UserTag("3", getString(2131756968)));
  }
  
  private void l() {
    String[] arrayOfString = n();
    this.s.add(new UserTag("-1", getString(2131756972)));
    for (int i = 0; i < 12; i++)
      this.s.add(new UserTag(TimeAndDateUtils.c(arrayOfString[i]), TimeAndDateUtils.d(TimeAndDateUtils.c(arrayOfString[i])))); 
    this.s.add(new UserTag("1", getString(2131756978)));
    for (UserTag userTag : this.s) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("id:");
      stringBuilder.append(userTag.id);
      stringBuilder.append(" -- name:");
      stringBuilder.append(userTag.name);
      Log.v("drb", stringBuilder.toString());
    } 
  }
  
  private void m() {
    this.r.add(new UserTag("1", getString(2131756970)));
    this.r.add(new UserTag("2", getString(2131756971)));
    this.r.add(new UserTag("-1", getString(2131756972)));
    this.r.add(new UserTag("3", getString(2131756973)));
    this.r.add(new UserTag("4", getString(2131756974)));
    this.r.add(new UserTag("5", getString(2131756975)));
  }
  
  private String[] n() {
    String[] arrayOfString = new String[12];
    Calendar calendar = Calendar.getInstance();
    calendar.set(5, 1);
    for (int i = 0; i < 12; i++) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(calendar.get(1));
      stringBuilder.append("年");
      stringBuilder.append(calendar.get(2) + 1);
      stringBuilder.append("月");
      arrayOfString[i] = stringBuilder.toString();
      calendar.set(2, calendar.get(2) - 1);
    } 
    return arrayOfString;
  }
  
  private void o() {
    CommonTopTitleNoTrans commonTopTitleNoTrans = (CommonTopTitleNoTrans)this.e.findViewById(2131300300);
    commonTopTitleNoTrans.setCenterText(getString(2131756855));
    commonTopTitleNoTrans.setLeftClickListener(this);
    commonTopTitleNoTrans.a();
  }
  
  private void p() {
    this.f = DialogUtils.a((Context)getActivity());
    this.i = (LinearLayout)this.e.findViewById(2131298882);
    this.j = (LinearLayout)this.e.findViewById(2131298883);
    this.k = (LinearLayout)this.e.findViewById(2131298881);
    this.l = (LinearLayout)this.e.findViewById(2131298785);
    this.m = (TextView)this.e.findViewById(2131300898);
    this.o = (TextView)this.e.findViewById(2131300899);
    this.n = (TextView)this.e.findViewById(2131300900);
    this.p = (TextView)this.e.findViewById(2131300897);
    this.q = (TextView)this.e.findViewById(2131300732);
    this.i.setOnClickListener(this);
    this.j.setOnClickListener(this);
    this.k.setOnClickListener(this);
    this.l.setOnClickListener(this);
    if (!TextUtils.isEmpty(this.u)) {
      for (UserTag userTag : this.r) {
        if (TextUtils.equals(userTag.id, this.u)) {
          userTag.select = true;
          this.m.setText(userTag.name);
          break;
        } 
      } 
    } else {
      for (UserTag userTag : this.r) {
        if (TextUtils.equals(userTag.id, "-1")) {
          userTag.select = true;
          break;
        } 
      } 
      this.m.setText(getString(2131756972));
    } 
    if (!TextUtils.isEmpty(this.v)) {
      if (TextUtils.equals(this.v, "-1")) {
        this.o.setText(getString(2131756972));
      } else if (TextUtils.equals(this.v, "1")) {
        this.o.setText(getString(2131756978));
      } else {
        this.o.setText(TimeAndDateUtils.d(this.v));
      } 
    } else {
      this.o.setText(getString(2131756972));
    } 
    if (!TextUtils.isEmpty(this.w)) {
      for (UserTag userTag : this.t) {
        if (TextUtils.equals(userTag.id, this.w)) {
          userTag.select = true;
          this.p.setText(userTag.name);
          break;
        } 
      } 
    } else {
      for (UserTag userTag : this.t) {
        if (TextUtils.equals(userTag.id, "-1")) {
          userTag.select = true;
          break;
        } 
      } 
      this.p.setText(getString(2131756972));
    } 
    q();
    r();
  }
  
  private void q() {
    // Byte code:
    //   0: aload_0
    //   1: getfield r : Ljava/util/List;
    //   4: invokeinterface iterator : ()Ljava/util/Iterator;
    //   9: astore_3
    //   10: aload_3
    //   11: invokeinterface hasNext : ()Z
    //   16: ifeq -> 411
    //   19: aload_3
    //   20: invokeinterface next : ()Ljava/lang/Object;
    //   25: checkcast com/soft/blued/ui/user/model/UserTag
    //   28: astore #4
    //   30: aload #4
    //   32: getfield select : Z
    //   35: ifeq -> 10
    //   38: aload #4
    //   40: getfield id : Ljava/lang/String;
    //   43: ldc '1'
    //   45: invokestatic equals : (Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   48: istore_2
    //   49: iconst_1
    //   50: istore_1
    //   51: iload_2
    //   52: ifeq -> 167
    //   55: aload_0
    //   56: getfield n : Landroid/widget/TextView;
    //   59: aload_0
    //   60: getfield d : Landroid/content/Context;
    //   63: ldc_w 2131100844
    //   66: invokestatic a : (Landroid/content/Context;I)I
    //   69: invokevirtual setTextColor : (I)V
    //   72: aload_0
    //   73: getfield o : Landroid/widget/TextView;
    //   76: aload_0
    //   77: getfield d : Landroid/content/Context;
    //   80: ldc_w 2131100844
    //   83: invokestatic a : (Landroid/content/Context;I)I
    //   86: invokevirtual setTextColor : (I)V
    //   89: aload_0
    //   90: getfield o : Landroid/widget/TextView;
    //   93: ldc_w ''
    //   96: invokevirtual setText : (Ljava/lang/CharSequence;)V
    //   99: aload_0
    //   100: getfield o : Landroid/widget/TextView;
    //   103: ldc_w 2131756963
    //   106: invokevirtual setHint : (I)V
    //   109: aload_0
    //   110: getfield s : Ljava/util/List;
    //   113: invokeinterface iterator : ()Ljava/util/Iterator;
    //   118: astore_3
    //   119: aload_3
    //   120: invokeinterface hasNext : ()Z
    //   125: ifeq -> 411
    //   128: aload_3
    //   129: invokeinterface next : ()Ljava/lang/Object;
    //   134: checkcast com/soft/blued/ui/user/model/UserTag
    //   137: astore #4
    //   139: aload #4
    //   141: iconst_0
    //   142: putfield select : Z
    //   145: aload #4
    //   147: getfield id : Ljava/lang/String;
    //   150: ldc '-1'
    //   152: invokestatic equals : (Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   155: ifeq -> 119
    //   158: aload #4
    //   160: iconst_1
    //   161: putfield select : Z
    //   164: goto -> 119
    //   167: aload_0
    //   168: getfield n : Landroid/widget/TextView;
    //   171: aload_0
    //   172: getfield d : Landroid/content/Context;
    //   175: ldc_w 2131100838
    //   178: invokestatic a : (Landroid/content/Context;I)I
    //   181: invokevirtual setTextColor : (I)V
    //   184: aload_0
    //   185: getfield o : Landroid/widget/TextView;
    //   188: aload_0
    //   189: getfield d : Landroid/content/Context;
    //   192: ldc_w 2131100838
    //   195: invokestatic a : (Landroid/content/Context;I)I
    //   198: invokevirtual setTextColor : (I)V
    //   201: aload_0
    //   202: getfield s : Ljava/util/List;
    //   205: invokeinterface iterator : ()Ljava/util/Iterator;
    //   210: astore_3
    //   211: aload_3
    //   212: invokeinterface hasNext : ()Z
    //   217: ifeq -> 315
    //   220: aload_3
    //   221: invokeinterface next : ()Ljava/lang/Object;
    //   226: checkcast com/soft/blued/ui/user/model/UserTag
    //   229: astore #4
    //   231: aload #4
    //   233: getfield select : Z
    //   236: ifeq -> 211
    //   239: aload #4
    //   241: getfield id : Ljava/lang/String;
    //   244: ldc '-1'
    //   246: invokestatic equals : (Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   249: ifeq -> 268
    //   252: aload_0
    //   253: getfield o : Landroid/widget/TextView;
    //   256: aload_0
    //   257: ldc 2131756972
    //   259: invokevirtual getString : (I)Ljava/lang/String;
    //   262: invokevirtual setText : (Ljava/lang/CharSequence;)V
    //   265: goto -> 317
    //   268: aload #4
    //   270: getfield id : Ljava/lang/String;
    //   273: ldc '1'
    //   275: invokestatic equals : (Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   278: ifeq -> 297
    //   281: aload_0
    //   282: getfield o : Landroid/widget/TextView;
    //   285: aload_0
    //   286: ldc 2131756978
    //   288: invokevirtual getString : (I)Ljava/lang/String;
    //   291: invokevirtual setText : (Ljava/lang/CharSequence;)V
    //   294: goto -> 317
    //   297: aload_0
    //   298: getfield o : Landroid/widget/TextView;
    //   301: aload #4
    //   303: getfield id : Ljava/lang/String;
    //   306: invokestatic d : (Ljava/lang/String;)Ljava/lang/String;
    //   309: invokevirtual setText : (Ljava/lang/CharSequence;)V
    //   312: goto -> 317
    //   315: iconst_0
    //   316: istore_1
    //   317: iload_1
    //   318: ifne -> 411
    //   321: aload_0
    //   322: getfield v : Ljava/lang/String;
    //   325: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   328: ifne -> 398
    //   331: aload_0
    //   332: getfield v : Ljava/lang/String;
    //   335: ldc '1'
    //   337: invokestatic equals : (Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   340: ifeq -> 357
    //   343: aload_0
    //   344: getfield o : Landroid/widget/TextView;
    //   347: aload_0
    //   348: ldc 2131756978
    //   350: invokevirtual getString : (I)Ljava/lang/String;
    //   353: invokevirtual setText : (Ljava/lang/CharSequence;)V
    //   356: return
    //   357: aload_0
    //   358: getfield v : Ljava/lang/String;
    //   361: ldc '-1'
    //   363: invokestatic equals : (Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   366: ifeq -> 383
    //   369: aload_0
    //   370: getfield o : Landroid/widget/TextView;
    //   373: aload_0
    //   374: ldc 2131756972
    //   376: invokevirtual getString : (I)Ljava/lang/String;
    //   379: invokevirtual setText : (Ljava/lang/CharSequence;)V
    //   382: return
    //   383: aload_0
    //   384: getfield o : Landroid/widget/TextView;
    //   387: aload_0
    //   388: getfield v : Ljava/lang/String;
    //   391: invokestatic d : (Ljava/lang/String;)Ljava/lang/String;
    //   394: invokevirtual setText : (Ljava/lang/CharSequence;)V
    //   397: return
    //   398: aload_0
    //   399: getfield o : Landroid/widget/TextView;
    //   402: aload_0
    //   403: ldc 2131756972
    //   405: invokevirtual getString : (I)Ljava/lang/String;
    //   408: invokevirtual setText : (Ljava/lang/CharSequence;)V
    //   411: return
  }
  
  private void r() {
    for (UserTag userTag : this.r) {
      if (userTag.select) {
        if (TextUtils.equals(userTag.id, "4") || TextUtils.equals(userTag.id, "5")) {
          for (UserTag userTag1 : this.t) {
            if (TextUtils.equals(userTag1.id, "3")) {
              userTag1.enable = true;
              break;
            } 
          } 
          for (UserTag userTag1 : this.t) {
            if (userTag1.select) {
              StringBuilder stringBuilder = new StringBuilder();
              stringBuilder.append("PrEP使用情况的选项中是:");
              stringBuilder.append(userTag1.id);
              Log.v("drb", stringBuilder.toString());
              if (TextUtils.equals(userTag1.id, "3")) {
                userTag1.select = false;
                for (UserTag userTag2 : this.t) {
                  StringBuilder stringBuilder1 = new StringBuilder();
                  stringBuilder1.append("更改前的PrEP使用情况选项为:");
                  stringBuilder1.append(userTag2.id);
                  Log.v("drb", stringBuilder1.toString());
                  if (TextUtils.equals(userTag2.id, "2")) {
                    userTag2.select = true;
                    this.p.setText(userTag2.name);
                    stringBuilder1 = new StringBuilder();
                    stringBuilder1.append("setText:");
                    stringBuilder1.append(userTag2.name);
                    Log.v("drb", stringBuilder1.toString());
                  } 
                } 
              } 
            } 
          } 
          continue;
        } 
        Iterator<UserTag> iterator = this.t.iterator();
        while (iterator.hasNext())
          ((UserTag)iterator.next()).enable = false; 
      } 
    } 
  }
  
  private void s() {
    boolean bool1;
    Intent intent = new Intent();
    Iterator<UserTag> iterator = this.r.iterator();
    while (iterator.hasNext()) {
      UserTag userTag = iterator.next();
      if (userTag.select) {
        intent.putExtra("health_result", userTag.id);
        intent.putExtra("health_result_name", userTag.name);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("finish result id:");
        stringBuilder.append(userTag.id);
        stringBuilder.append(" -- name:");
        stringBuilder.append(userTag.name);
        Log.v("drb", stringBuilder.toString());
        break;
      } 
    } 
    boolean bool2 = false;
    iterator = this.s.iterator();
    while (true) {
      bool1 = bool2;
      if (iterator.hasNext()) {
        UserTag userTag = iterator.next();
        if (userTag.select) {
          intent.putExtra("health_time", userTag.id);
          intent.putExtra("health_time_name", userTag.name);
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append("finish time id:");
          stringBuilder.append(userTag.id);
          stringBuilder.append(" -- name:");
          stringBuilder.append(userTag.name);
          Log.v("drb", stringBuilder.toString());
          bool1 = true;
          break;
        } 
        continue;
      } 
      break;
    } 
    if (!bool1)
      if (!TextUtils.isEmpty(this.v)) {
        intent.putExtra("health_time", this.v);
        if (TextUtils.equals(this.v, "1")) {
          intent.putExtra("health_time_name", getString(2131756978));
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append("finish time id:");
          stringBuilder.append(this.v);
          stringBuilder.append(" -- name:");
          stringBuilder.append(getString(2131756978));
          Log.v("drb", stringBuilder.toString());
        } else if (TextUtils.equals(this.v, "-1")) {
          intent.putExtra("health_time", "-1");
          intent.putExtra("health_time_name", getString(2131756972));
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append("finish time id:-1 -- name:");
          stringBuilder.append(getString(2131756972));
          Log.v("drb", stringBuilder.toString());
        } else {
          intent.putExtra("health_time_name", TimeAndDateUtils.d(this.v));
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append("finish time id:");
          stringBuilder.append(this.v);
          stringBuilder.append(" -- name:");
          stringBuilder.append(TimeAndDateUtils.d(this.v));
          Log.v("drb", stringBuilder.toString());
        } 
      } else {
        intent.putExtra("health_time", "-1");
        intent.putExtra("health_time_name", getString(2131756972));
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("finish time id:-1 -- name:");
        stringBuilder.append(getString(2131756972));
        Log.v("drb", stringBuilder.toString());
      }  
    iterator = this.t.iterator();
    while (iterator.hasNext()) {
      UserTag userTag = iterator.next();
      if (userTag.select) {
        intent.putExtra("health_prep", userTag.id);
        intent.putExtra("health_prep_name", userTag.name);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("finish prep id:");
        stringBuilder.append(userTag.id);
        stringBuilder.append(" -- name:");
        stringBuilder.append(userTag.name);
        Log.v("drb", stringBuilder.toString());
        break;
      } 
    } 
    getActivity().setResult(-1, intent);
    getActivity().finish();
  }
  
  public boolean V_() {
    s();
    return true;
  }
  
  public void onClick(View paramView) {
    ArrayList<String> arrayList3;
    String[] arrayOfString3;
    ArrayList<String> arrayList2;
    String[] arrayOfString2;
    ArrayList<String> arrayList1;
    String[] arrayOfString1;
    switch (paramView.getId()) {
      default:
        return;
      case 2131298883:
        for (UserTag userTag : this.r) {
          if (userTag.select && TextUtils.equals(userTag.id, "1"))
            return; 
        } 
        arrayList3 = new ArrayList();
        null = this.s.iterator();
        while (null.hasNext())
          arrayList3.add(((UserTag)null.next()).name); 
        arrayOfString3 = arrayList3.<String>toArray(new String[arrayList3.size()]);
        CommonAlertDialog.a(this.d, getString(2131756976), arrayOfString3, new CommonAlertDialog.TextOnClickListener(this) {
              public void a(String param1String) {
                ModifyHealthFragment.f(this.a).setText(param1String);
                for (UserTag userTag : ModifyHealthFragment.g(this.a)) {
                  userTag.select = false;
                  if (TextUtils.equals(userTag.name, param1String))
                    userTag.select = true; 
                } 
              }
            });
        return;
      case 2131298882:
        arrayList2 = new ArrayList();
        null = this.r.iterator();
        while (null.hasNext())
          arrayList2.add(((UserTag)null.next()).name); 
        arrayOfString2 = arrayList2.<String>toArray(new String[arrayList2.size()]);
        CommonAlertDialog.a(this.d, getString(2131756969), arrayOfString2, new CommonAlertDialog.TextOnClickListener(this) {
              public void a(String param1String) {
                CommonAlertDialog.a(ModifyHealthFragment.a(this.a), ModifyHealthFragment.a(this.a).getString(2131758425), ModifyHealthFragment.a(this.a).getString(2131758427), ModifyHealthFragment.a(this.a).getString(2131758426), new DialogInterface.OnClickListener(this, param1String) {
                      public void onClick(DialogInterface param2DialogInterface, int param2Int) {
                        ModifyHealthFragment.b(this.b.a).setText(this.a);
                        for (UserTag userTag : ModifyHealthFragment.c(this.b.a)) {
                          userTag.select = false;
                          if (TextUtils.equals(userTag.name, this.a))
                            userTag.select = true; 
                        } 
                        ModifyHealthFragment.d(this.b.a);
                        ModifyHealthFragment.e(this.b.a);
                      }
                    }ModifyHealthFragment.a(this.a).getString(2131755577), null, null);
              }
            });
        return;
      case 2131298881:
        arrayList1 = new ArrayList();
        for (UserTag userTag : this.t) {
          if (!userTag.enable)
            arrayList1.add(userTag.name); 
        } 
        arrayOfString1 = arrayList1.<String>toArray(new String[arrayList1.size()]);
        CommonAlertDialog.a(this.d, getString(2131756964), arrayOfString1, new CommonAlertDialog.TextOnClickListener(this) {
              public void a(String param1String) {
                ModifyHealthFragment.h(this.a).setText(param1String);
                for (UserTag userTag : ModifyHealthFragment.i(this.a)) {
                  userTag.select = false;
                  if (TextUtils.equals(userTag.name, param1String))
                    userTag.select = true; 
                } 
              }
            });
        return;
      case 2131298785:
        EventTrackPersonalProfile.a(PersonalProfileProtos.Event.HEALTH_INFO_PAGE_ENCYCLOPEDIA_CLICK);
        WebViewShowInfoFragment.show((Context)getActivity(), Blued_healthUrl.a(1), -1);
        return;
      case 2131296863:
        s();
        break;
      case 2131296867:
        break;
    } 
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
    this.d = (Context)getActivity();
    View view = this.e;
    if (view == null) {
      this.e = paramLayoutInflater.inflate(2131493151, paramViewGroup, false);
      a();
      p();
      o();
    } else if (view.getParent() != null) {
      ((ViewGroup)this.e.getParent()).removeView(this.e);
    } 
    return this.e;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\setting\fragment\ModifyHealthFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */