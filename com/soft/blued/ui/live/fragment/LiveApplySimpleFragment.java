package com.soft.blued.ui.live.fragment;

import android.app.Dialog;
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
import android.widget.TextView;
import butterknife.BindView;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.core.utils.skin.BluedSkinUtils;
import com.blued.android.framework.ui.mvp.MvpFragment;
import com.blued.android.framework.utils.AesCrypto;
import com.blued.android.module.common.utils.DialogUtils;
import com.blued.android.module.live_china.model.BluedLiveState;
import com.blued.das.live.LiveProtos;
import com.soft.blued.customview.CommonTopTitleNoTrans;
import com.soft.blued.log.trackUtils.EventTrackLive;
import com.soft.blued.ui.live.presenter.LiveApplySimplePresenter;
import com.soft.blued.ui.login_register.LinkMobileFragment;
import com.soft.blued.ui.login_register.LoginRegisterTools;
import com.soft.blued.ui.web.WebViewShowInfoFragment;
import com.soft.blued.user.UserInfo;
import com.soft.blued.utils.StringUtils;
import com.soft.blued.utils.UserRelationshipUtils;
import java.io.Serializable;
import java.util.List;

public class LiveApplySimpleFragment extends MvpFragment<LiveApplySimplePresenter> implements View.OnClickListener {
  private Context d;
  
  private boolean e;
  
  private Dialog f;
  
  @BindView(2131297106)
  View fl_error_page;
  
  private BluedLiveState g;
  
  private boolean h = true;
  
  @BindView(2131297362)
  ImageView header_view;
  
  private TextWatcher i = new TextWatcher(this) {
      public void afterTextChanged(Editable param1Editable) {
        this.a.tv_name.removeTextChangedListener(LiveApplySimpleFragment.b(this.a));
        LiveApplySimpleFragment.c(this.a);
        this.a.tv_name.addTextChangedListener(LiveApplySimpleFragment.b(this.a));
      }
      
      public void beforeTextChanged(CharSequence param1CharSequence, int param1Int1, int param1Int2, int param1Int3) {}
      
      public void onTextChanged(CharSequence param1CharSequence, int param1Int1, int param1Int2, int param1Int3) {}
    };
  
  @BindView(2131297575)
  ImageView img_verify;
  
  @BindView(2131297889)
  ImageView iv_phone_binded;
  
  private TextWatcher j = new TextWatcher(this) {
      private int b;
      
      private int c;
      
      public void afterTextChanged(Editable param1Editable) {
        this.b = this.a.tv_id.getSelectionStart();
        this.c = this.a.tv_id.getSelectionEnd();
        this.a.tv_id.removeTextChangedListener(LiveApplySimpleFragment.d(this.a));
        while (param1Editable.length() > 18) {
          param1Editable.delete(this.b - 1, this.c);
          this.b--;
          this.c--;
        } 
        this.a.tv_id.setSelection(this.b);
        LiveApplySimpleFragment.c(this.a);
        this.a.tv_id.addTextChangedListener(LiveApplySimpleFragment.d(this.a));
      }
      
      public void beforeTextChanged(CharSequence param1CharSequence, int param1Int1, int param1Int2, int param1Int3) {}
      
      public void onTextChanged(CharSequence param1CharSequence, int param1Int1, int param1Int2, int param1Int3) {}
    };
  
  @BindView(2131298159)
  TextView live_agree;
  
  @BindView(2131298220)
  ImageView live_clause;
  
  @BindView(2131298932)
  View ll_main;
  
  @BindView(2131300300)
  CommonTopTitleNoTrans top_title;
  
  @BindView(2131300561)
  TextView tv_binding_cellphone;
  
  @BindView(2131300562)
  TextView tv_binding_cellphone_status;
  
  @BindView(2131300908)
  EditText tv_id;
  
  @BindView(2131300910)
  TextView tv_identify;
  
  @BindView(2131301088)
  EditText tv_name;
  
  @BindView(2131301149)
  TextView tv_other;
  
  @BindView(2131301252)
  View tv_reload;
  
  @BindView(2131301400)
  TextView tv_tip_one;
  
  @BindView(2131301401)
  TextView tv_tip_two;
  
  public static void a(Context paramContext, BluedLiveState paramBluedLiveState) {
    Bundle bundle = new Bundle();
    if (paramBluedLiveState != null)
      bundle.putSerializable("applyState", (Serializable)paramBluedLiveState); 
    TerminalActivity.d(paramContext, LiveApplySimpleFragment.class, bundle);
  }
  
  private void b(boolean paramBoolean) {
    BluedLiveState bluedLiveState = this.g;
    byte b = 8;
    if (bluedLiveState == null) {
      this.ll_main.setVisibility(8);
      View view = this.fl_error_page;
      if (!paramBoolean)
        b = 0; 
      view.setVisibility(b);
      this.tv_reload.setOnClickListener(this);
      if (paramBoolean) {
        ((LiveApplySimplePresenter)s()).m();
        return;
      } 
    } else {
      this.ll_main.setVisibility(0);
      this.fl_error_page.setVisibility(8);
      this.tv_name.setFilters(new InputFilter[] { StringUtils.a() });
      this.tv_name.addTextChangedListener(this.i);
      this.tv_id.addTextChangedListener(this.j);
      ImageLoader.a((IRequestHost)w_(), UserInfo.a().i().getAvatar()).a(2131234356).c().a(this.header_view);
      UserRelationshipUtils.a(this.img_verify, UserInfo.a().i().getVBadge(), 3);
      if (this.img_verify.getVisibility() == 8 || this.img_verify.getVisibility() == 4) {
        this.img_verify.setImageResource(2131234373);
        this.img_verify.setVisibility(0);
      } 
      this.tv_other.setOnClickListener(this);
      this.live_clause.setOnClickListener(this);
      this.tv_binding_cellphone.setOnClickListener(this);
      try {
        if (this.g != null) {
          this.tv_name.setText(AesCrypto.e(this.g.name));
          this.tv_id.setText(AesCrypto.e(this.g.number));
        } 
      } catch (Exception exception) {
        exception.printStackTrace();
      } 
      m();
      n();
      k();
    } 
  }
  
  private void l() {
    this.f = DialogUtils.a(this.d);
    this.top_title.e();
    this.top_title.a();
    this.top_title.setLeftImgDrawable(BluedSkinUtils.b(this.d, 2131232743));
    this.top_title.setCenterText(getString(2131755104));
    this.top_title.setLeftClickListener(this);
    b(true);
    EventTrackLive.a(LiveProtos.Event.LIVE_APPLY_ANCHOR_PAGE_SHOW);
  }
  
  private void m() {
    String str1 = this.d.getString(2131755035);
    String str2 = this.d.getString(2131755051);
    String str4 = this.d.getString(2131755036);
    String str3 = this.d.getString(2131757205);
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append(str1);
    stringBuilder1.append(" ");
    stringBuilder1.append(str2);
    stringBuilder1.append(" ");
    stringBuilder1.append(str4);
    stringBuilder1.append(" ");
    stringBuilder1.append(str3);
    str4 = stringBuilder1.toString();
    SpannableString spannableString = new SpannableString(str4);
    this.live_agree.setMovementMethod(LinkMovementMethod.getInstance());
    ClickableSpan clickableSpan = new ClickableSpan(this) {
        public void onClick(View param1View) {
          WebViewShowInfoFragment.show((Context)this.a.getActivity(), "https://www.blued.cn/live/agreement", 7);
        }
        
        public void updateDrawState(TextPaint param1TextPaint) {
          param1TextPaint.setColor(BluedSkinUtils.a(LiveApplySimpleFragment.a(this.a), 2131100716));
          param1TextPaint.setUnderlineText(false);
        }
      };
    int i = str4.indexOf(str2);
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append(str1);
    stringBuilder2.append(" ");
    stringBuilder2.append(str2);
    spannableString.setSpan(clickableSpan, i, stringBuilder2.toString().length(), 33);
    spannableString.setSpan(new ClickableSpan(this) {
          public void onClick(View param1View) {
            WebViewShowInfoFragment.show((Context)this.a.getActivity(), "https://app.blued.cn/livereports/agreement/1", 7);
          }
          
          public void updateDrawState(TextPaint param1TextPaint) {
            param1TextPaint.setColor(LiveApplySimpleFragment.a(this.a).getResources().getColor(2131100527));
            param1TextPaint.setUnderlineText(false);
          }
        }str4.indexOf(str3), str4.length(), 33);
    this.live_agree.setText((CharSequence)spannableString);
  }
  
  private void n() {
    if (!TextUtils.isEmpty(LoginRegisterTools.b()) && !TextUtils.isEmpty((CharSequence)this.tv_id.getText()) && !TextUtils.isEmpty((CharSequence)this.tv_name.getText()) && this.h) {
      this.tv_identify.setOnClickListener(this);
      this.tv_identify.setBackgroundColor(BluedSkinUtils.a(this.d, 2131100716));
      return;
    } 
    this.tv_identify.setOnClickListener(null);
    this.tv_identify.setBackgroundColor(getResources().getColor(2131100876));
  }
  
  public void a(Bundle paramBundle) {
    super.a(paramBundle);
    l();
  }
  
  public void a(String paramString, List paramList) {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: aload_2
    //   3: invokespecial a : (Ljava/lang/String;Ljava/util/List;)V
    //   6: aload_1
    //   7: invokevirtual hashCode : ()I
    //   10: istore_3
    //   11: iload_3
    //   12: ldc_w -1696975301
    //   15: if_icmpeq -> 43
    //   18: iload_3
    //   19: ldc_w 492423017
    //   22: if_icmpeq -> 28
    //   25: goto -> 58
    //   28: aload_1
    //   29: ldc_w 'LIVE_SIMPLE__APPLY'
    //   32: invokevirtual equals : (Ljava/lang/Object;)Z
    //   35: ifeq -> 58
    //   38: iconst_0
    //   39: istore_3
    //   40: goto -> 60
    //   43: aload_1
    //   44: ldc_w 'LIVE_APPLY'
    //   47: invokevirtual equals : (Ljava/lang/Object;)Z
    //   50: ifeq -> 58
    //   53: iconst_1
    //   54: istore_3
    //   55: goto -> 60
    //   58: iconst_m1
    //   59: istore_3
    //   60: iload_3
    //   61: ifeq -> 98
    //   64: iload_3
    //   65: iconst_1
    //   66: if_icmpeq -> 70
    //   69: return
    //   70: aload_2
    //   71: ifnull -> 157
    //   74: aload_2
    //   75: invokeinterface size : ()I
    //   80: ifle -> 157
    //   83: aload_0
    //   84: aload_2
    //   85: iconst_0
    //   86: invokeinterface get : (I)Ljava/lang/Object;
    //   91: checkcast com/blued/android/module/live_china/model/BluedLiveState
    //   94: putfield g : Lcom/blued/android/module/live_china/model/BluedLiveState;
    //   97: return
    //   98: aload_0
    //   99: getfield g : Lcom/blued/android/module/live_china/model/BluedLiveState;
    //   102: astore_1
    //   103: aload_1
    //   104: ifnull -> 141
    //   107: aload_1
    //   108: getfield vbadge : I
    //   111: iconst_4
    //   112: if_icmpne -> 141
    //   115: aload_0
    //   116: getfield g : Lcom/blued/android/module/live_china/model/BluedLiveState;
    //   119: astore_1
    //   120: aload_1
    //   121: iconst_1
    //   122: putfield is_easy_way : I
    //   125: aload_0
    //   126: getfield d : Landroid/content/Context;
    //   129: aload_1
    //   130: invokestatic a : (Landroid/content/Context;Lcom/blued/android/module/live_china/model/BluedLiveState;)V
    //   133: aload_0
    //   134: invokevirtual getActivity : ()Landroidx/fragment/app/FragmentActivity;
    //   137: invokevirtual finish : ()V
    //   140: return
    //   141: invokestatic a : ()Lcom/blued/android/module/live/base/manager/LiveDataManager;
    //   144: iconst_0
    //   145: invokevirtual a : (I)V
    //   148: invokestatic e : ()Lcom/blued/android/module/base/shortvideo/ShortVideoProxy;
    //   151: aload_0
    //   152: iconst_1
    //   153: iconst_1
    //   154: invokevirtual a : (Ljava/lang/Object;II)V
    //   157: return
  }
  
  public void a(String paramString, boolean paramBoolean) {
    super.a(paramString, paramBoolean);
    DialogUtils.b(this.f);
    if (paramString == "LIVE_APPLY")
      b(false); 
  }
  
  public void b(String paramString) {
    super.b(paramString);
    DialogUtils.a(this.f);
  }
  
  public void k() {
    try {
      if (this.g != null && this.g.vbadge == 4) {
        this.tv_identify.setText(getString(2131755054));
        this.tv_tip_one.setText(getString(2131755100));
        this.tv_tip_two.setText(getString(2131755101));
      } else {
        this.tv_identify.setText(getString(2131755092));
        this.tv_tip_one.setText(getString(2131755098));
        this.tv_tip_two.setText(getString(2131755099));
      } 
      if (!TextUtils.isEmpty(LoginRegisterTools.b())) {
        this.e = true;
        this.tv_binding_cellphone_status.setVisibility(0);
        this.tv_binding_cellphone_status.setText(getResources().getString(2131755049));
        this.tv_binding_cellphone.setVisibility(8);
        this.iv_phone_binded.setVisibility(0);
        return;
      } 
      this.e = false;
      this.tv_binding_cellphone_status.setVisibility(8);
      this.tv_binding_cellphone.setVisibility(0);
      this.iv_phone_binded.setVisibility(8);
      return;
    } catch (Exception exception) {
      exception.printStackTrace();
      return;
    } 
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("requestCode:");
    stringBuilder.append(paramInt1);
    stringBuilder.append("  :");
    stringBuilder.append(paramInt2);
    Log.i("LiveApplySimpleFragment", stringBuilder.toString());
    if (paramInt2 == 0)
      return; 
    if (paramInt1 != 1)
      return; 
    if (paramIntent != null) {
      boolean bool = paramIntent.getBooleanExtra("auth_upload_state", false);
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append("success:");
      stringBuilder1.append(bool);
      Log.i("LiveApplySimpleFragment", stringBuilder1.toString());
      if (bool) {
        BluedLiveState bluedLiveState = this.g;
        if (bluedLiveState != null)
          bluedLiveState.is_easy_way = 1; 
        LiveApplyVerifyFragment.a(this.d, this.g);
        getActivity().finish();
      } 
    } 
  }
  
  public void onClick(View paramView) {
    String str;
    switch (paramView.getId()) {
      default:
        return;
      case 2131301252:
        ((LiveApplySimplePresenter)s()).m();
        return;
      case 2131301149:
        TerminalActivity.d(this.d, LiveApplyFragment.class, null);
        return;
      case 2131300910:
        ((LiveApplySimplePresenter)s()).a(this.tv_name.getText().toString(), this.tv_id.getText().toString());
        return;
      case 2131300561:
        str = LoginRegisterTools.b();
        if (!TextUtils.isEmpty(str)) {
          String[] arrayOfString = LoginRegisterTools.h(str);
          LoginRegisterTools.a((Context)getActivity(), arrayOfString[0], arrayOfString[1]);
          return;
        } 
        TerminalActivity.d((Context)getActivity(), LinkMobileFragment.class, null);
        return;
      case 2131298220:
        if (this.h) {
          this.h = false;
          this.live_clause.setImageResource(2131233001);
        } else {
          this.h = true;
          this.live_clause.setImageResource(2131233002);
        } 
        n();
        return;
      case 2131296863:
        break;
    } 
    getActivity().finish();
  }
  
  public void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    this.d = getContext();
    if (getArguments() != null && getArguments().getSerializable("applyState") != null)
      this.g = (BluedLiveState)getArguments().getSerializable("applyState"); 
  }
  
  public void onDestroy() {
    super.onDestroy();
    DialogUtils.b(this.f);
  }
  
  public void onResume() {
    super.onResume();
    k();
  }
  
  public int p() {
    return 2131493170;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\live\fragment\LiveApplySimpleFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */