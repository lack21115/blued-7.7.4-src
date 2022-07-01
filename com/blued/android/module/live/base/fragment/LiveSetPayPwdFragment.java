package com.blued.android.module.live.base.fragment;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import cn.blued.blued_third_library.R;
import com.blued.android.core.AppInfo;
import com.blued.android.core.AppMethods;
import com.blued.android.core.net.HttpManager;
import com.blued.android.core.net.HttpResponseHandler;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.http.BluedHttpTools;
import com.blued.android.framework.http.BluedHttpUtils;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.utils.AesCrypto;
import com.blued.android.framework.utils.Logger;
import com.blued.android.module.common.model.DecryptJson;
import com.blued.android.module.live.base.R;
import com.blued.android.module.live.base.model.BasePayRemaining;
import com.blued.android.module.live.base.utils.LiveBasePreferences;
import com.jeremyliao.liveeventbus.LiveEventBus;
import com.jungly.gridpasswordview.GridPasswordView;
import com.jungly.gridpasswordview.imebugfixer.ImeDelBugFixedEditText;
import java.security.NoSuchAlgorithmException;
import java.util.Map;

public class LiveSetPayPwdFragment extends LiveBaseDialogFragment {
  private TextView i;
  
  private GridPasswordView j;
  
  private ImeDelBugFixedEditText k;
  
  private View l;
  
  private CheckBox m;
  
  private TextView n;
  
  private TextView o;
  
  private String p;
  
  private String q;
  
  private String r;
  
  private boolean s;
  
  private boolean t = true;
  
  private int u;
  
  private void a(String paramString) {
    if (getTargetRequestCode() == 4221005 || getTargetRequestCode() == 4221004) {
      b(paramString);
      return;
    } 
    if (getTargetRequestCode() == 4221002) {
      c(paramString);
      return;
    } 
  }
  
  private void b(String paramString) {
    try {
      paramString = BluedHttpTools.b(paramString);
    } catch (NoSuchAlgorithmException noSuchAlgorithmException) {
      noSuchAlgorithmException.printStackTrace();
      noSuchAlgorithmException = null;
    } 
    this.c.putString("password", (String)noSuchAlgorithmException);
    this.c.putBoolean("remember_me", this.m.isChecked());
    Intent intent = new Intent();
    intent.putExtras(this.c);
    if (getTargetFragment() != null)
      getTargetFragment().onActivityResult(getTargetRequestCode(), -1, intent); 
    dismiss();
  }
  
  private void c(String paramString) {
    String str1;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(this.r);
    stringBuilder.append("/paymentcode/");
    stringBuilder.append(1);
    String str2 = stringBuilder.toString();
    Map<String, String> map = BluedHttpTools.a();
    if (this.m.isChecked()) {
      str1 = "1";
    } else {
      str1 = "0";
    } 
    map.put("verify", str1);
    map.put("type", "set");
    try {
      map.put("code", BluedHttpTools.b(paramString));
      str1 = AesCrypto.b(AppInfo.f().toJson(map));
      map = BluedHttpTools.a();
      map.put("_", str1);
      HttpManager.b(str2, (HttpResponseHandler)new BluedUIHttpResponse<BluedEntityA<BasePayRemaining>>(this, (IRequestHost)a(), paramString) {
            protected void a(BluedEntityA<BasePayRemaining> param1BluedEntityA) {
              if (param1BluedEntityA != null && param1BluedEntityA.getSingleData() != null) {
                if (BluedHttpUtils.a(param1BluedEntityA.code, param1BluedEntityA.message)) {
                  BasePayRemaining basePayRemaining = (BasePayRemaining)param1BluedEntityA.getSingleData();
                  try {
                    String str = AesCrypto.c(basePayRemaining._);
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("dataStr = ");
                    stringBuilder.append(str);
                    Logger.c("pwd", new Object[] { stringBuilder.toString() });
                    LiveBasePreferences.b(((DecryptJson)AppInfo.f().fromJson(str, DecryptJson.class)).token);
                    if (this.b.getTargetFragment() != null) {
                      Intent intent = new Intent();
                      this.b.c.putBoolean("remember_me", LiveSetPayPwdFragment.c(this.b).isChecked());
                      try {
                        this.b.c.putString("password", BluedHttpTools.b(this.a));
                      } catch (NoSuchAlgorithmException noSuchAlgorithmException) {
                        noSuchAlgorithmException.printStackTrace();
                      } 
                      intent.putExtras(this.b.c);
                      this.b.getTargetFragment().onActivityResult(this.b.getTargetRequestCode(), -1, intent);
                    } 
                    this.b.dismiss();
                    return;
                  } catch (Exception exception) {
                    return;
                  } 
                } 
                AppMethods.d(R.string.get_user_info_fail);
                return;
              } 
              AppMethods.d(R.string.get_user_info_fail);
            }
          }(IRequestHost)a()).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(map)).i();
      return;
    } catch (Exception exception) {
      exception.printStackTrace();
      return;
    } 
  }
  
  public int f() {
    return R.layout.live_set_pay_pwd;
  }
  
  protected void g() {
    this.i = (TextView)this.b.findViewById(R.id.tv_confirm);
    this.j = (GridPasswordView)this.b.findViewById(R.id.gpv_customUi);
    this.k = (ImeDelBugFixedEditText)this.b.findViewById(R.id.inputView);
    this.k.setImeOptions(33554432);
    this.l = this.b.findViewById(R.id.vg_remember_check);
    this.m = (CheckBox)this.b.findViewById(R.id.cbx_need_next);
    this.n = (TextView)this.b.findViewById(R.id.tv_title);
    View view = this.b.findViewById(R.id.tv_title_cutline);
    this.o = (TextView)this.b.findViewById(R.id.tv_msg);
    if (TextUtils.isEmpty(this.p)) {
      this.n.setVisibility(8);
      view.setVisibility(8);
    } else {
      this.n.setText(this.p);
      if (getTargetRequestCode() == 4221004)
        this.n.setTextColor(getResources().getColor(R.color.biao_live_bug_gift_paycode_error)); 
      this.n.setVisibility(0);
      view.setVisibility(0);
    } 
    if (TextUtils.isEmpty(this.q)) {
      this.o.setVisibility(8);
    } else {
      this.o.setText(this.q);
      this.o.setVisibility(0);
    } 
    if (this.s) {
      this.j.setPasswordVisibility(true);
    } else {
      this.j.setPasswordVisibility(false);
    } 
    if (this.t) {
      this.m.setChecked(true);
      this.m.setVisibility(0);
    } else {
      this.m.setVisibility(8);
    } 
    this.b.findViewById(R.id.live_set_pay_pwd_layout_id).setOnClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            if (this.a.getTargetFragment() != null)
              this.a.getTargetFragment().onActivityResult(this.a.getTargetRequestCode(), 0, new Intent()); 
            this.a.dismiss();
          }
        });
    this.b.findViewById(R.id.live_set_pay_pwd_content_layout_id).setOnClickListener(-$$Lambda$LiveSetPayPwdFragment$iioVrutCDAzBBuHWp2lz7anfM5c.INSTANCE);
    this.j.setOnPasswordChangedListener(new GridPasswordView.OnPasswordChangedListener(this) {
          public void a(String param1String) {
            if (param1String.length() < 6) {
              LiveSetPayPwdFragment.a(this.a).setOnClickListener(null);
              LiveSetPayPwdFragment.a(this.a).setTextColor(Color.parseColor("#c0c0c0"));
            } 
          }
          
          public void b(String param1String) {
            LiveSetPayPwdFragment.a(this.a).setTextColor(Color.parseColor("#3494f4"));
            LiveSetPayPwdFragment.a(this.a).setOnClickListener(new -$$Lambda$LiveSetPayPwdFragment$2$fIzLqDsYgCG3PxOiq_HUc1d20TM(this, param1String));
          }
        });
    this.i.setTextColor(Color.parseColor("#c0c0c0"));
    this.j.postDelayed(new Runnable(this) {
          public void run() {
            LiveSetPayPwdFragment.b(this.a).callOnClick();
          }
        },  200L);
    LiveEventBus.get("live_pwd_fragment_close", String.class).observe((LifecycleOwner)this, new Observer<String>(this) {
          public void a(String param1String) {
            if (this.a.getTargetFragment() != null)
              this.a.getTargetFragment().onActivityResult(this.a.getTargetRequestCode(), 0, new Intent()); 
            this.a.dismiss();
          }
        });
  }
  
  protected void h() {
    this.p = this.c.getString("title");
    this.q = this.c.getString("content");
    this.s = this.c.getBoolean("pwd_visible");
    this.t = this.c.getBoolean("remember_check", true);
    this.u = this.c.getInt("request_code");
    this.r = this.c.getString("http_host");
  }
  
  public Dialog onCreateDialog(Bundle paramBundle) {
    Dialog dialog = super.onCreateDialog(paramBundle);
    dialog.getWindow().setSoftInputMode(18);
    return dialog;
  }
  
  public void onDestroyView() {
    super.onDestroyView();
    LiveEventBus.get("inner_fragment_close").post("");
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\live\base\fragment\LiveSetPayPwdFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */