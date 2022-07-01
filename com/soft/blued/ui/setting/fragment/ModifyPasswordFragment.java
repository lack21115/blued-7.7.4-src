package com.soft.blued.ui.setting.fragment;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import com.blued.android.core.AppMethods;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.framework.http.BluedHttpTools;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.module.common.utils.DialogUtils;
import com.soft.blued.customview.CommonEdittextView;
import com.soft.blued.customview.CommonTopTitleNoTrans;
import com.soft.blued.http.MineHttpUtils;
import com.soft.blued.user.UserInfo;
import com.soft.blued.utils.Logger;
import com.soft.blued.utils.StringUtils;
import com.soft.blued.utils.password.PasswordCheckUtils;
import com.soft.blued.utils.password.PasswordStatusView;

public class ModifyPasswordFragment extends BaseFragment implements View.OnClickListener {
  public BluedUIHttpResponse d = new BluedUIHttpResponse(this) {
      public void onUIFinish() {
        super.onUIFinish();
        DialogUtils.b(ModifyPasswordFragment.a(this.a));
      }
      
      public void onUIStart() {
        super.onUIStart();
        DialogUtils.a(ModifyPasswordFragment.a(this.a));
      }
      
      public void onUIUpdate(BluedEntity param1BluedEntity) {
        try {
          DialogUtils.b(ModifyPasswordFragment.a(this.a));
          AppMethods.d(2131757920);
          BluedHttpTools.b(ModifyPasswordFragment.b(this.a).getText().toString());
          this.a.getActivity().finish();
          return;
        } catch (Exception exception) {
          return;
        } 
      }
    };
  
  private String e;
  
  private Dialog f;
  
  private View g;
  
  private CommonEdittextView h;
  
  private CommonEdittextView i;
  
  private CommonEdittextView j;
  
  private TextView k;
  
  private PasswordStatusView l;
  
  public void a() {
    CommonTopTitleNoTrans commonTopTitleNoTrans = (CommonTopTitleNoTrans)this.g.findViewById(2131300300);
    commonTopTitleNoTrans.a();
    commonTopTitleNoTrans.setLeftClickListener(this);
    commonTopTitleNoTrans.setRightClickListener(this);
    commonTopTitleNoTrans.e();
    this.h = (CommonEdittextView)this.g.findViewById(2131297008);
    this.h.getEditText().setInputType(128);
    this.i = (CommonEdittextView)this.g.findViewById(2131297005);
    this.i.getEditText().setInputType(128);
    this.j = (CommonEdittextView)this.g.findViewById(2131297006);
    this.j.getEditText().setInputType(128);
    this.k = (TextView)this.g.findViewById(2131300590);
    this.k.setOnClickListener(this);
    this.f = DialogUtils.a((Context)getActivity());
    this.l = (PasswordStatusView)this.g.findViewById(2131299547);
    Logger.a(this.e, UserInfo.a().b());
    this.l.a((EditText)this.i.getEditText(), (EditText)this.j.getEditText(), UserInfo.a().b(), (UserInfo.a().i()).name, PasswordCheckUtils.PWD_CHECK_PAGE.b, (IRequestHost)w_(), new -$$Lambda$ModifyPasswordFragment$nIcibWCFRoocUgzJDiOntm982o8(this));
  }
  
  public void a(String paramString1, String paramString2) {
    MineHttpUtils.i((Context)getActivity(), this.d, UserInfo.a().i().getUid(), paramString1, paramString2, (IRequestHost)w_());
  }
  
  public void onClick(View paramView) {
    int i = paramView.getId();
    if (i != 2131296863) {
      if (i != 2131300590)
        return; 
      if (StringUtils.e(this.h.getText().toString()) || StringUtils.e(this.i.getText().toString()) || StringUtils.e(this.j.getText().toString())) {
        AppMethods.d(2131758486);
        return;
      } 
      if (this.i.getText().toString().length() >= 6) {
        if (!this.i.getText().toString().equals(this.j.getText().toString())) {
          AppMethods.d(2131758487);
          return;
        } 
        a(this.h.getText().toString(), this.j.getText().toString());
        return;
      } 
      AppMethods.d(2131755572);
      return;
    } 
    getActivity().finish();
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
    View view = this.g;
    if (view == null) {
      this.g = paramLayoutInflater.inflate(2131493228, paramViewGroup, false);
      this.e = ModifyPasswordFragment.class.getSimpleName();
      a();
    } else if (view.getParent() != null) {
      ((ViewGroup)this.g.getParent()).removeView(this.g);
    } 
    return this.g;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\setting\fragment\ModifyPasswordFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */