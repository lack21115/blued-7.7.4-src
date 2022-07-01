package com.soft.blued.fragment;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import androidx.fragment.app.Fragment;
import com.blued.android.core.AppInfo;
import com.blued.android.core.AppMethods;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.core.utils.skin.BluedSkinUtils;
import com.blued.android.framework.utils.KeyboardUtils;
import com.blued.das.profile.PersonalProfileProtos;
import com.soft.blued.customview.CommonTopTitleNoTrans;
import com.soft.blued.customview.EditInputNumView;
import com.soft.blued.log.trackUtils.EventTrackPersonalProfile;
import com.soft.blued.utils.AtChooseUserHelper;
import com.soft.blued.utils.StringUtils;

public class CommonWriteTextFragment extends BaseFragment implements View.OnClickListener {
  public Context d;
  
  public int e = 256;
  
  protected View f;
  
  public EditText g;
  
  protected EditInputNumView h;
  
  protected String i;
  
  protected String j;
  
  protected String k;
  
  protected int l;
  
  public CommonTopTitleNoTrans m;
  
  private String n;
  
  private String o;
  
  private AtChooseUserHelper p;
  
  private TextWatcher q;
  
  private TextWatcher r;
  
  private boolean s;
  
  public static void a(Fragment paramFragment, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt) {
    Bundle bundle = new Bundle();
    bundle.putString("max_count", paramString1);
    bundle.putString("string_edit", paramString2);
    bundle.putString("string_edit_hint", paramString3);
    bundle.putString("string_center", paramString4);
    bundle.putInt("REQUEST_CODE_KEY", paramInt);
    TerminalActivity.a(paramFragment, CommonWriteTextFragment.class, bundle, paramInt);
  }
  
  private void k() {
    a(new Runnable(this) {
          public void run() {
            if (!this.a.g.isFocusable()) {
              this.a.g.setFocusable(true);
              this.a.g.setFocusableInTouchMode(true);
            } 
            this.a.g.requestFocus();
            this.a.g.setSelection(this.a.g.length());
            KeyboardUtils.c((Activity)this.a.getActivity());
          }
        },  300L);
  }
  
  private void l() {
    this.q = new TextWatcher(this) {
        private int b;
        
        private int c;
        
        private String d;
        
        private String e;
        
        public void afterTextChanged(Editable param1Editable) {
          try {
            this.b = this.a.g.getSelectionStart();
            this.c = this.a.g.getSelectionEnd();
            if (CommonWriteTextFragment.a(this.a)) {
              if (!CommonWriteTextFragment.b(this.a).a(this.a, this.d, this.e, param1Editable, this.c))
                this.a.g.setSelection(this.b); 
            } else {
              this.a.g.setSelection(this.b);
            } 
            if (CommonWriteTextFragment.c(this.a) != null)
              CommonWriteTextFragment.c(this.a).afterTextChanged(param1Editable); 
            if (this.a.h.a()) {
              this.a.m.getRightTextView().setTextColor(BluedSkinUtils.a(this.a.d, 2131100842));
              this.a.m.setRightClickListener(null);
              return;
            } 
            this.a.m.getRightTextView().setTextColor(BluedSkinUtils.a(this.a.d, 2131100838));
            this.a.m.setRightClickListener(this.a);
            return;
          } catch (Exception exception) {
            exception.printStackTrace();
            return;
          } 
        }
        
        public void beforeTextChanged(CharSequence param1CharSequence, int param1Int1, int param1Int2, int param1Int3) {
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append(param1CharSequence);
          stringBuilder.append("");
          this.d = stringBuilder.toString();
          if (CommonWriteTextFragment.c(this.a) != null)
            CommonWriteTextFragment.c(this.a).beforeTextChanged(param1CharSequence, param1Int1, param1Int2, param1Int3); 
        }
        
        public void onTextChanged(CharSequence param1CharSequence, int param1Int1, int param1Int2, int param1Int3) {
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append(param1CharSequence);
          stringBuilder.append("");
          this.e = stringBuilder.toString();
          if (CommonWriteTextFragment.c(this.a) != null)
            CommonWriteTextFragment.c(this.a).onTextChanged(param1CharSequence, param1Int1, param1Int2, param1Int3); 
        }
      };
    AppInfo.n().postDelayed(new Runnable(this) {
          public void run() {
            this.a.g.requestFocus();
            KeyboardUtils.a((View)this.a.g);
          }
        },  300L);
  }
  
  private boolean m() {
    return (this.l == 3);
  }
  
  public boolean V_() {
    a(0);
    return true;
  }
  
  public void a() {
    this.m.setCenterText(getString(2131755213));
    this.m.setLeftClickListener(this);
    this.m.setRightClickListener(this);
    if (StringUtils.e(this.i)) {
      this.m.setCenterText(getResources().getString(2131756095));
    } else {
      this.m.setCenterText(this.i);
    } 
    if (StringUtils.e(this.j)) {
      this.m.setRightText(getResources().getString(2131758950));
      return;
    } 
    this.m.setRightText(this.j);
  }
  
  public void a(int paramInt) {
    String str2 = this.g.getText().toString();
    String str1 = str2;
    if (m())
      str1 = this.p.b(str2); 
    if (a(paramInt, str1)) {
      Intent intent = new Intent();
      intent.putExtra("string_edit", str1);
      intent.putExtra("feed_id", this.k);
      getActivity().setResult(paramInt, intent);
      getActivity().finish();
    } 
  }
  
  public void a(TextWatcher paramTextWatcher) {
    this.r = paramTextWatcher;
  }
  
  protected boolean a(int paramInt, String paramString) {
    return true;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {
    if (paramInt2 == -1 && paramInt1 == 9090)
      this.p.a(this.g, paramIntent, this.q); 
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public void onClick(View paramView) {
    int i = paramView.getId();
    if (i != 2131296863) {
      if (i != 2131296867)
        return; 
      if (this.h.a()) {
        String str = this.d.getResources().getString(2131757864);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.e);
        stringBuilder.append("");
        AppMethods.a(String.format(str, new Object[] { stringBuilder.toString() }));
        return;
      } 
      EventTrackPersonalProfile.a(PersonalProfileProtos.Event.EDIT_SIGNATURE_CONFIRM_CLICK);
      a(-1);
      return;
    } 
    a(0);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
    this.d = (Context)getActivity();
    getActivity().getWindow().setSoftInputMode(18);
    this.p = new AtChooseUserHelper((Context)getActivity());
    View view = this.f;
    if (view == null) {
      this.f = paramLayoutInflater.inflate(2131493110, paramViewGroup, false);
      if (getArguments() != null) {
        this.e = Integer.parseInt(getArguments().getString("max_count"));
        this.n = getArguments().getString("string_edit");
        this.o = getArguments().getString("string_edit_hint");
        this.i = getArguments().getString("string_center");
        this.j = getArguments().getString("string_right");
        this.k = getArguments().getString("feed_id");
        this.l = getArguments().getInt("REQUEST_CODE_KEY");
        this.s = getArguments().getBoolean("im_note");
      } 
      this.m = (CommonTopTitleNoTrans)this.f.findViewById(2131300300);
      a();
      l();
      this.g = (EditText)this.f.findViewById(2131301765);
      this.h = (EditInputNumView)this.f.findViewById(2131297597);
      this.g.addTextChangedListener(this.q);
      this.h.a(this.g, this.e, this.s);
      if (!StringUtils.e(this.o))
        this.g.setHint(this.o); 
      if (!StringUtils.e(this.n))
        this.g.setText(this.n); 
      k();
    } else {
      ((ViewGroup)view.getParent()).removeView(this.f);
    } 
    return this.f;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blued\fragment\CommonWriteTextFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */