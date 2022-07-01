package com.blued.android.module.yy_china.view;

import android.app.Activity;
import android.content.Context;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.LinearLayout;
import com.blued.android.core.utils.toast.ToastUtils;
import com.blued.android.framework.utils.EncryptTool;
import com.blued.android.framework.utils.KeyboardUtils;
import com.blued.android.framework.utils.Logger;
import com.blued.android.framework.view.shape.ShapeHelper;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.yy_china.R;
import com.blued.android.module.yy_china.fragment.BaseYYStudioFragment;
import com.blued.android.module.yy_china.listener.ISendMsgListener;
import com.blued.android.module.yy_china.listener.ITextWatcher;
import com.blued.android.module.yy_china.manager.YYImMsgManager;
import com.blued.android.module.yy_china.manager.YYRoomInfoManager;
import com.blued.android.module.yy_china.model.YYUserInfo;
import com.blued.android.module.yy_china.utils.EnglishCharFilter;
import java.util.HashMap;

public class YYTypingView extends LinearLayout {
  private EditText a;
  
  private ShapeTextView b;
  
  private BaseYYStudioFragment c;
  
  private String d;
  
  private String e;
  
  private String f;
  
  private ISendMsgListener g;
  
  public YYTypingView(Context paramContext) {
    super(paramContext);
    a();
  }
  
  public YYTypingView(Context paramContext, AttributeSet paramAttributeSet) {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  public YYTypingView(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }
  
  private void a() {
    LayoutInflater.from(getContext()).inflate(R.layout.view_yy_typing_layout, (ViewGroup)this, true);
    this.a = (EditText)findViewById(R.id.et_chat_input);
    this.a.setFilters(new InputFilter[] { (InputFilter)new EnglishCharFilter(280) });
    this.b = (ShapeTextView)findViewById(R.id.tv_send_msg);
    this.b.setEnabled(false);
    this.b.setOnClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            if (YYRoomInfoManager.d().c().a(this.a.getContext(), null))
              return; 
            YYUserInfo yYUserInfo = (YYRoomInfoManager.d()).a;
            if (yYUserInfo != null && TextUtils.equals(yYUserInfo.mute, "1")) {
              ToastUtils.a("你已被禁言，暂不可在此房间发言", 0);
              return;
            } 
            String str = YYTypingView.a(this.a).getText().toString();
            if (!TextUtils.isEmpty(str)) {
              if (TextUtils.isEmpty(str.trim()))
                return; 
              StringBuilder stringBuilder = new StringBuilder();
              stringBuilder.append("原始 msg = ");
              stringBuilder.append(str);
              Logger.e("IM msg", new Object[] { stringBuilder.toString() });
              YYImMsgManager.a().a(EncryptTool.b(YYTypingView.b(this.a)), YYTypingView.c(this.a), str, YYTypingView.d(this.a));
              if (YYTypingView.e(this.a) != null)
                YYTypingView.e(this.a).a(); 
              YYTypingView.f(this.a);
            } 
          }
        });
    this.a.addTextChangedListener((TextWatcher)new ITextWatcher(this) {
          public void afterTextChanged(Editable param1Editable) {
            if (TextUtils.isEmpty((CharSequence)param1Editable)) {
              YYTypingView.g(this.a).setEnabled(false);
              ShapeHelper.a((ShapeHelper.ShapeView)YYTypingView.g(this.a), R.color.syc_dark_j, R.color.syc_dark_j);
              return;
            } 
            YYTypingView.g(this.a).setEnabled(true);
            ShapeHelper.a((ShapeHelper.ShapeView)YYTypingView.g(this.a), R.color.syc_00E0AB, R.color.syc_3883FD);
          }
        });
  }
  
  private void b() {
    BaseYYStudioFragment baseYYStudioFragment = this.c;
    if (baseYYStudioFragment == null)
      return; 
    baseYYStudioFragment.a(new Runnable(this) {
          public void run() {
            YYTypingView.a(this.a).setFocusableInTouchMode(true);
            YYTypingView.a(this.a).setFocusable(true);
            YYTypingView.a(this.a).requestFocus();
            ((InputMethodManager)this.a.getContext().getSystemService("input_method")).showSoftInput((View)YYTypingView.a(this.a), 0);
            YYTypingView.a(this.a).setSelection(YYTypingView.a(this.a).getText().length());
          }
        }200L);
  }
  
  private void c() {
    this.a.setText("");
    KeyboardUtils.a((Activity)this.c.getActivity());
  }
  
  public void a(BaseYYStudioFragment paramBaseYYStudioFragment, String paramString1, String paramString2) {
    this.c = paramBaseYYStudioFragment;
    this.d = paramString1;
    this.e = paramString2;
    if (!TextUtils.isEmpty(this.d) && !TextUtils.isEmpty(this.e)) {
      HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
      hashMap.put(paramString2, paramString1);
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("@");
      stringBuilder.append(paramString2);
      stringBuilder.append(" ");
      this.f = stringBuilder.toString();
      YYRoomInfoManager.d().c().a(getContext(), this.a, 16, getResources().getColor(R.color.syc_00E0AB), this.f, hashMap);
    } 
    b();
  }
  
  public EditText getEtInput() {
    return this.a;
  }
  
  protected void onDetachedFromWindow() {
    super.onDetachedFromWindow();
    this.a.setText("");
  }
  
  public void setListener(ISendMsgListener paramISendMsgListener) {
    this.g = paramISendMsgListener;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\blued\android\module\yy_china\view\YYTypingView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */