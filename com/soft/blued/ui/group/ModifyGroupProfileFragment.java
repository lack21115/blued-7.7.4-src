package com.soft.blued.ui.group;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import com.blued.android.core.AppMethods;
import com.blued.android.core.ui.BaseFragment;
import com.soft.blued.customview.CommonTopTitleNoTrans;

public class ModifyGroupProfileFragment extends BaseFragment implements View.OnClickListener {
  private String d = ModifyGroupProfileFragment.class.getSimpleName();
  
  private View e;
  
  private EditText f;
  
  private TextView g;
  
  private Context h;
  
  private String i;
  
  private TextWatcher j = new TextWatcher(this) {
      private int b;
      
      private int c;
      
      public void afterTextChanged(Editable param1Editable) {
        try {
          this.b = ModifyGroupProfileFragment.a(this.a).getSelectionStart();
          this.c = ModifyGroupProfileFragment.a(this.a).getSelectionEnd();
          ModifyGroupProfileFragment.a(this.a).removeTextChangedListener(ModifyGroupProfileFragment.b(this.a));
          while (param1Editable.length() > 256) {
            param1Editable.delete(this.b - 1, this.c);
            this.b--;
            this.c--;
          } 
          int i = param1Editable.length();
          TextView textView = ModifyGroupProfileFragment.c(this.a);
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append(i);
          stringBuilder.append(" ");
          textView.setText(stringBuilder.toString());
          ModifyGroupProfileFragment.a(this.a).setSelection(this.b);
          ModifyGroupProfileFragment.a(this.a).addTextChangedListener(ModifyGroupProfileFragment.b(this.a));
          return;
        } catch (Exception exception) {
          exception.printStackTrace();
          ModifyGroupProfileFragment.c(this.a).setText("");
          return;
        } 
      }
      
      public void beforeTextChanged(CharSequence param1CharSequence, int param1Int1, int param1Int2, int param1Int3) {}
      
      public void onTextChanged(CharSequence param1CharSequence, int param1Int1, int param1Int2, int param1Int3) {}
    };
  
  private void a() {
    this.i = getArguments().getString("profile");
    this.f.setText(this.i);
    EditText editText = this.f;
    editText.setSelection(editText.length());
    TextView textView = this.g;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(this.f.length());
    stringBuilder.append(" ");
    textView.setText(stringBuilder.toString());
  }
  
  private void k() {
    this.g = (TextView)this.e.findViewById(2131301533);
    this.f = (EditText)this.e.findViewById(2131297002);
    this.f.addTextChangedListener(this.j);
    EditText editText = this.f;
    editText.setSelection(editText.length());
    getActivity().getWindow().setSoftInputMode(21);
  }
  
  private void l() {
    CommonTopTitleNoTrans commonTopTitleNoTrans = (CommonTopTitleNoTrans)this.e.findViewById(2131300300);
    commonTopTitleNoTrans.setCenterText(getString(2131756677));
    commonTopTitleNoTrans.setRightText(2131758642);
    commonTopTitleNoTrans.setLeftClickListener(this);
    commonTopTitleNoTrans.setRightClickListener(this);
  }
  
  public void onClick(View paramView) {
    int i = paramView.getId();
    if (i != 2131296863) {
      if (i != 2131296867)
        return; 
      if (this.f.length() <= 15) {
        AppMethods.a(getResources().getString(2131757915));
        return;
      } 
      Intent intent = new Intent();
      this.i = this.f.getText().toString();
      intent.putExtra("profile", this.i);
      getActivity().setResult(-1, intent);
      getActivity().finish();
      return;
    } 
    getActivity().finish();
  }
  
  public void onCreate(Bundle paramBundle) {
    this.h = (Context)getActivity();
    super.onCreate(paramBundle);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
    this.e = paramLayoutInflater.inflate(2131493227, paramViewGroup, false);
    k();
    l();
    a();
    return this.e;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\group\ModifyGroupProfileFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */