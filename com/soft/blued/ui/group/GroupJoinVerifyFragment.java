package com.soft.blued.ui.group;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import com.blued.android.core.AppMethods;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.module.common.utils.DialogUtils;
import com.soft.blued.customview.CommonTopTitleNoTrans;
import com.soft.blued.http.GroupHttpUtils;

public class GroupJoinVerifyFragment extends BaseFragment implements View.OnClickListener {
  public BluedUIHttpResponse d = new BluedUIHttpResponse<BluedEntity>(this) {
      public void onUIFinish() {
        super.onUIFinish();
        DialogUtils.b(GroupJoinVerifyFragment.a(this.a));
      }
      
      public void onUIStart() {
        super.onUIStart();
        DialogUtils.a(GroupJoinVerifyFragment.a(this.a));
      }
      
      public void onUIUpdate(BluedEntity param1BluedEntity) {
        try {
          AppMethods.d(2131756634);
          this.a.getActivity().finish();
          return;
        } catch (Exception exception) {
          AppMethods.d(2131756082);
          exception.printStackTrace();
          return;
        } 
      }
    };
  
  private String e = GroupJoinVerifyFragment.class.getSimpleName();
  
  private View f;
  
  private EditText g;
  
  private String h;
  
  private String i;
  
  private Context j;
  
  private Dialog k;
  
  private TextView l;
  
  private TextWatcher m = new TextWatcher(this) {
      private int b;
      
      private int c;
      
      public void afterTextChanged(Editable param1Editable) {
        try {
          this.b = GroupJoinVerifyFragment.b(this.a).getSelectionStart();
          this.c = GroupJoinVerifyFragment.b(this.a).getSelectionEnd();
          GroupJoinVerifyFragment.b(this.a).removeTextChangedListener(GroupJoinVerifyFragment.c(this.a));
          while (param1Editable.length() > 90) {
            param1Editable.delete(this.b - 1, this.c);
            this.b--;
            this.c--;
          } 
          int i = param1Editable.length();
          TextView textView = GroupJoinVerifyFragment.d(this.a);
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append(i);
          stringBuilder.append(" ");
          textView.setText(stringBuilder.toString());
          GroupJoinVerifyFragment.b(this.a).setSelection(this.b);
          GroupJoinVerifyFragment.b(this.a).addTextChangedListener(GroupJoinVerifyFragment.c(this.a));
          return;
        } catch (Exception exception) {
          exception.printStackTrace();
          GroupJoinVerifyFragment.d(this.a).setText("");
          return;
        } 
      }
      
      public void beforeTextChanged(CharSequence param1CharSequence, int param1Int1, int param1Int2, int param1Int3) {}
      
      public void onTextChanged(CharSequence param1CharSequence, int param1Int1, int param1Int2, int param1Int3) {}
    };
  
  private void a() {
    CommonTopTitleNoTrans commonTopTitleNoTrans = (CommonTopTitleNoTrans)this.f.findViewById(2131300300);
    commonTopTitleNoTrans.setCenterText(getString(2131756687));
    commonTopTitleNoTrans.setRightText(getString(2131758680));
    commonTopTitleNoTrans.setLeftClickListener(this);
    commonTopTitleNoTrans.setRightClickListener(this);
  }
  
  private void k() {
    this.i = getArguments().getString("gid");
  }
  
  private void l() {
    this.k = DialogUtils.a(this.j);
    this.g = (EditText)this.f.findViewById(2131297018);
    this.l = (TextView)this.f.findViewById(2131301533);
    TextView textView = this.l;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(getResources().getText(2131756730));
    stringBuilder.append(" ");
    textView.setText(stringBuilder.toString());
    this.g.addTextChangedListener(this.m);
    EditText editText = this.g;
    editText.setSelection(editText.length());
  }
  
  public void onClick(View paramView) {
    int i = paramView.getId();
    if (i != 2131296863) {
      if (i != 2131296867)
        return; 
      this.h = this.g.getText().toString();
      GroupHttpUtils.b(this.j, this.d, this.i, this.h, (IRequestHost)w_());
      return;
    } 
    getActivity().finish();
  }
  
  public void onCreate(Bundle paramBundle) {
    this.j = (Context)getActivity();
    super.onCreate(paramBundle);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
    getActivity().getWindow().setSoftInputMode(21);
    this.f = paramLayoutInflater.inflate(2131493138, paramViewGroup, false);
    l();
    a();
    k();
    return this.f;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\group\GroupJoinVerifyFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */