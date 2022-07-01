package com.blued.android.module.yy_china.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.core.utils.toast.ToastUtils;
import com.blued.android.framework.ui.mvp.MvpFragment;
import com.blued.android.framework.utils.AesCrypto;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.base.shortvideo.ShortVideoProxy;
import com.blued.android.module.live.base.manager.LiveDataManager;
import com.blued.android.module.yy_china.IYYRoomInfoCallback;
import com.blued.android.module.yy_china.R;
import com.blued.android.module.yy_china.listener.ITextWatcher;
import com.blued.android.module.yy_china.manager.YYRoomInfoManager;
import com.blued.android.module.yy_china.model.YYLiveState;
import com.blued.android.module.yy_china.presenter.YYApplyPresenter;
import com.blued.android.module.yy_china.utils.EnglishCharFilter;
import com.blued.android.module.yy_china.utils.log.EventTrackYY;
import com.blued.das.client.chatroom.ChatRoomProtos;

public class YYApplyFragment extends MvpFragment<YYApplyPresenter> implements View.OnClickListener {
  TextView d;
  
  EditText e;
  
  EditText f;
  
  ImageView g;
  
  TextView h;
  
  ShapeTextView i;
  
  ImageView j;
  
  TextView n;
  
  RelativeLayout o;
  
  private boolean p = false;
  
  private boolean q = false;
  
  public static void a(Context paramContext) {
    TerminalActivity.d(paramContext, YYApplyFragment.class, new Bundle());
  }
  
  private void l() {
    String str1 = this.e.getText().toString().trim();
    String str2 = this.f.getText().toString().trim();
    boolean bool = ((Boolean)this.g.getTag()).booleanValue();
    if (TextUtils.isEmpty(str1) || TextUtils.isEmpty(str2) || !bool) {
      this.i.setEnabled(false);
      this.i.setAlpha(0.5F);
      return;
    } 
    this.i.setEnabled(true);
    this.i.setAlpha(1.0F);
  }
  
  private void m() {
    String str1 = ((YYApplyPresenter)s()).b(R.string.blued_apply_host_agree);
    String str2 = ((YYApplyPresenter)s()).b(R.string.blued_apply_host_agreement);
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append(str1);
    stringBuilder1.append(" ");
    stringBuilder1.append(str2);
    String str3 = stringBuilder1.toString();
    SpannableString spannableString = new SpannableString(str3);
    this.h.setMovementMethod(LinkMovementMethod.getInstance());
    ClickableSpan clickableSpan = new ClickableSpan(this) {
        public void onClick(View param1View) {
          IYYRoomInfoCallback iYYRoomInfoCallback = YYRoomInfoManager.d().c();
          iYYRoomInfoCallback.a((Context)this.a.getActivity(), iYYRoomInfoCallback.g(), 7);
        }
        
        public void updateDrawState(TextPaint param1TextPaint) {
          param1TextPaint.setColor(((YYApplyPresenter)this.a.s()).a(R.color.syc_dark_a));
          param1TextPaint.setUnderlineText(false);
        }
      };
    int i = str3.indexOf(str2);
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append(str1);
    stringBuilder2.append(" ");
    stringBuilder2.append(str2);
    spannableString.setSpan(clickableSpan, i, stringBuilder2.toString().length(), 33);
    this.h.setText((CharSequence)spannableString);
  }
  
  public boolean A() {
    return true;
  }
  
  public void a(Bundle paramBundle) {
    super.a(paramBundle);
    this.d = (TextView)this.l.findViewById(R.id.tv_bind_phone);
    this.n = (TextView)this.l.findViewById(R.id.tv_title_text);
    this.j = (ImageView)this.l.findViewById(R.id.iv_back_img);
    this.g = (ImageView)this.l.findViewById(R.id.iv_terms);
    this.i = (ShapeTextView)this.l.findViewById(R.id.go_auth);
    this.e = (EditText)this.l.findViewById(R.id.tv_name);
    this.f = (EditText)this.l.findViewById(R.id.tv_cardnum);
    this.o = (RelativeLayout)this.l.findViewById(R.id.rl_title_layout);
    this.h = (TextView)this.l.findViewById(R.id.live_agree);
    this.n.setText(getResources().getString(R.string.yy_apply_title));
    this.j.setOnClickListener(this);
    this.g.setOnClickListener(this);
    this.i.setOnClickListener(this);
    this.d.setOnClickListener(this);
    this.g.setTag(Boolean.valueOf(true));
    this.g.setImageResource(R.drawable.icon_terms_read);
    this.e.setFilters(new InputFilter[] { (InputFilter)new EnglishCharFilter(40) });
    this.e.addTextChangedListener((TextWatcher)new ITextWatcher(this) {
          public void afterTextChanged(Editable param1Editable) {
            YYApplyFragment.a(this.a);
          }
        });
    this.f.addTextChangedListener((TextWatcher)new ITextWatcher(this) {
          public void afterTextChanged(Editable param1Editable) {
            YYApplyFragment.a(this.a);
          }
        });
    m();
    ((YYApplyPresenter)s()).e();
  }
  
  public void a(YYLiveState paramYYLiveState) {
    try {
      boolean bool;
      if (paramYYLiveState.chatroom_need_video == 0) {
        bool = true;
      } else {
        bool = false;
      } 
      this.p = bool;
      this.e.setText(AesCrypto.e(paramYYLiveState.name));
      this.f.setText(AesCrypto.e(paramYYLiveState.number));
      return;
    } catch (Exception exception) {
      return;
    } 
  }
  
  public void k() {
    if (this.p) {
      YYApplyFinishFragment.a(getContext(), 0);
      getActivity().finish();
      return;
    } 
    LiveDataManager.a().a(1);
    ShortVideoProxy.e().a(this, 1, 100);
  }
  
  public void onActivityCreated(Bundle paramBundle) {
    super.onActivityCreated(paramBundle);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("requestCode:");
    stringBuilder.append(paramInt1);
    stringBuilder.append("  :");
    stringBuilder.append(paramInt2);
    Log.i("YYApplyFragment", stringBuilder.toString());
    if (paramInt2 == 0)
      return; 
    if (paramInt1 != 100)
      return; 
    if (paramIntent != null) {
      boolean bool = paramIntent.getBooleanExtra("auth_upload_state", false);
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append("success:");
      stringBuilder1.append(bool);
      Log.i("YYApplyFragment", stringBuilder1.toString());
      if (bool) {
        YYApplyFinishFragment.a(getContext(), 0);
        getActivity().finish();
      } 
    } 
  }
  
  public void onClick(View paramView) {
    ImageView imageView;
    String str;
    if (paramView.getId() == R.id.iv_terms) {
      int i;
      int j = ((Boolean)this.g.getTag()).booleanValue() ^ true;
      imageView = this.g;
      if (j != 0) {
        i = R.drawable.icon_terms_read;
      } else {
        i = R.drawable.icon_terms_unread;
      } 
      imageView.setImageResource(i);
      this.g.setTag(Boolean.valueOf(j));
      l();
      return;
    } 
    if (imageView.getId() == R.id.go_auth) {
      if (!((Boolean)this.g.getTag()).booleanValue()) {
        ToastUtils.a("请先阅读相关条款及协议", 0);
        return;
      } 
      str = this.e.getText().toString().trim();
      if (TextUtils.isEmpty(str)) {
        ToastUtils.a("真实姓名不符合标准", 0);
        return;
      } 
      String str1 = this.f.getText().toString().trim();
      if (TextUtils.isEmpty(str1) || str1.length() < 18) {
        ToastUtils.a("证件号码不符合标准", 0);
        return;
      } 
      EventTrackYY.a(ChatRoomProtos.Event.CHAT_ROOM_ENTER_APPROVE_CLICK);
      ((YYApplyPresenter)s()).a(YYRoomInfoManager.d().c().c(), str, str1);
      return;
    } 
    if (str.getId() == R.id.tv_bind_phone) {
      if (this.q)
        return; 
      EventTrackYY.a(ChatRoomProtos.Event.CHAT_ROOM_PHONE_BIND_CLICK);
      YYRoomInfoManager.d().c().a(getContext());
      return;
    } 
    if (str.getId() == R.id.iv_back_img)
      C(); 
  }
  
  public void onResume() {
    super.onResume();
    if (TextUtils.isEmpty(YYRoomInfoManager.d().c().i())) {
      this.q = false;
      this.d.setText(getResources().getString(R.string.yy_bind_now));
      return;
    } 
    this.q = true;
    this.d.setText(getResources().getString(R.string.yy_binded));
  }
  
  public int p() {
    return R.layout.fragment_yy_apply_layout;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\blued\android\module\yy_china\fragment\YYApplyFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */