package com.soft.blued.ui.live.fragment;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.imagecache.LoadOptions;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.framework.ui.mvp.MvpFragment;
import com.blued.android.module.common.utils.DialogUtils;
import com.blued.android.module.live_china.model.BluedLiveState;
import com.blued.das.settings.SettingsProtos;
import com.soft.blued.customview.CommonTopTitleNoTrans;
import com.soft.blued.log.InstantLog;
import com.soft.blued.log.trackUtils.EventTrackSettings;
import com.soft.blued.ui.feed.fragment.ClipPhotoFragment;
import com.soft.blued.ui.feed.fragment.PhotoSelectFragment;
import com.soft.blued.ui.live.model.LiveIDCardUploadResult;
import com.soft.blued.ui.live.presenter.LiveBaseImprovePresenter;
import com.soft.blued.ui.photo.fragment.BasePhotoFragment;
import com.soft.blued.utils.CameraUtils;
import java.util.List;

public abstract class LiveBaseImproveFragment<P extends LiveBaseImprovePresenter> extends MvpFragment<P> implements View.OnClickListener {
  @BindView(2131296846)
  ImageView cover_del_btn1;
  
  @BindView(2131296847)
  ImageView cover_del_btn2;
  
  public final int d = 0;
  
  public final int e = 1;
  
  public Context f;
  
  @BindView(2131297106)
  View fl_error_page;
  
  public BluedLiveState g;
  
  public boolean h;
  
  private String i;
  
  @BindView(2131297717)
  ImageView iv_card_binded;
  
  private String j;
  
  @BindView(2131298156)
  View live_add_card_layout1;
  
  @BindView(2131298157)
  View live_add_card_layout2;
  
  @BindView(2131298183)
  ImageView live_card1;
  
  @BindView(2131298184)
  ImageView live_card2;
  
  @BindView(2131298313)
  View live_id_card_error;
  
  @BindView(2131298728)
  View ll_bottom_button;
  
  @BindView(2131298932)
  View ll_main;
  
  private String n;
  
  private String o;
  
  private String p;
  
  private boolean q;
  
  private boolean r;
  
  private boolean s;
  
  private int t;
  
  @BindView(2131300300)
  CommonTopTitleNoTrans top_title;
  
  @BindView(2131300563)
  TextView tv_binding_credit_card;
  
  @BindView(2131300564)
  TextView tv_binding_credit_card_status;
  
  @BindView(2131301252)
  View tv_reload;
  
  @BindView(2131301354)
  TextView tv_start_verify;
  
  private Dialog u;
  
  private Dialog v;
  
  private void a(int paramInt) {
    View view = getActivity().getLayoutInflater().inflate(2131494017, null);
    DialogViewHolder dialogViewHolder = new DialogViewHolder(this);
    ButterKnife.a(dialogViewHolder, view);
    if (paramInt != 0) {
      if (paramInt == 1)
        dialogViewHolder.viewer_card.setImageResource(2131233092); 
    } else {
      dialogViewHolder.viewer_card.setImageResource(2131233094);
    } 
    this.u = new Dialog((Context)getActivity(), 2131821496);
    this.u.requestWindowFeature(1);
    this.u.setContentView(view, new ViewGroup.LayoutParams(-1, -1));
    Window window = this.u.getWindow();
    window.setWindowAnimations(2131821418);
    WindowManager.LayoutParams layoutParams = window.getAttributes();
    layoutParams.x = 0;
    layoutParams.y = getActivity().getWindowManager().getDefaultDisplay().getHeight();
    layoutParams.width = -1;
    layoutParams.height = -1;
    this.u.onWindowAttributesChanged(layoutParams);
    String[] arrayOfString = getResources().getStringArray(2130903110);
    dialogViewHolder.openPhones.setText(arrayOfString[1]);
    dialogViewHolder.openPhones.setOnClickListener(this);
    dialogViewHolder.openCamera.setText(arrayOfString[0]);
    dialogViewHolder.openCamera.setOnClickListener(this);
    dialogViewHolder.openClose.setOnClickListener(this);
    this.u.setCanceledOnTouchOutside(true);
    this.u.show();
  }
  
  private void b(int paramInt, String paramString) {
    this.t = paramInt;
    LoadOptions loadOptions = new LoadOptions();
    BasePhotoFragment.a(this.f, new String[] { paramString }, 0, 8, loadOptions);
  }
  
  private void c(boolean paramBoolean) {
    BluedLiveState bluedLiveState = this.g;
    byte b = 8;
    if (bluedLiveState == null) {
      this.ll_main.setVisibility(8);
      View view = this.fl_error_page;
      if (!paramBoolean)
        b = 0; 
      view.setVisibility(b);
      if (paramBoolean)
        b(false); 
    } else {
      this.ll_main.setVisibility(0);
      this.fl_error_page.setVisibility(8);
      if (this.g.has_bankcard == 1) {
        this.s = true;
        this.tv_binding_credit_card_status.setVisibility(0);
        this.tv_binding_credit_card.setVisibility(8);
        this.iv_card_binded.setVisibility(0);
      } else {
        this.s = false;
        this.tv_binding_credit_card_status.setVisibility(8);
        this.tv_binding_credit_card.setVisibility(0);
        this.iv_card_binded.setVisibility(8);
      } 
      this.o = this.g.idcard_front;
      this.p = this.g.idcard_after;
      if (!TextUtils.isEmpty(this.o)) {
        this.live_card1.setVisibility(0);
        ImageLoader.a((IRequestHost)w_(), this.o).a(2131233093).a(this.live_card1);
        this.q = true;
        this.cover_del_btn1.setVisibility(0);
      } else {
        this.cover_del_btn1.setVisibility(8);
      } 
      if (!TextUtils.isEmpty(this.p)) {
        this.live_card2.setVisibility(0);
        ImageLoader.a((IRequestHost)w_(), this.p).a(2131233093).a(this.live_card2);
        this.r = true;
        this.cover_del_btn2.setVisibility(0);
      } else {
        this.cover_del_btn2.setVisibility(8);
      } 
    } 
    m();
  }
  
  private void l() {
    this.v = DialogUtils.a((Context)getActivity());
    this.top_title.a();
    this.top_title.setCenterText(getString(2131757219));
    this.top_title.setLeftClickListener(this);
    this.top_title.setCenterTextColor(2131100838);
    c(true);
    this.tv_binding_credit_card.setOnClickListener(this);
    this.tv_binding_credit_card_status.setOnClickListener(this);
    this.live_add_card_layout1.setOnClickListener(this);
    this.live_add_card_layout2.setOnClickListener(this);
    this.live_card1.setOnClickListener(this);
    this.live_card2.setOnClickListener(this);
    this.cover_del_btn1.setOnClickListener(this);
    this.cover_del_btn2.setOnClickListener(this);
    this.tv_reload.setOnClickListener(this);
  }
  
  private void m() {
    if (this.q && this.r && this.s) {
      this.ll_bottom_button.setBackgroundColor(-16738064);
      this.ll_bottom_button.setOnClickListener(this);
      return;
    } 
    this.ll_bottom_button.setBackgroundColor(-4144960);
    this.ll_bottom_button.setOnClickListener(null);
  }
  
  private void n() {
    this.i = CameraUtils.a((Fragment)this);
  }
  
  public abstract void a(int paramInt, String paramString);
  
  public abstract void a(Context paramContext, String paramString, int paramInt);
  
  public void a(Bundle paramBundle) {
    super.a(paramBundle);
    l();
  }
  
  public void a(String paramString, List<BluedLiveState> paramList) {
    byte b;
    super.a(paramString, paramList);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("type:");
    stringBuilder.append(paramString);
    Log.i("xpp", stringBuilder.toString());
    switch (paramString.hashCode()) {
      default:
        b = -1;
        break;
      case 307423389:
        if (paramString.equals("LIVE_CARD_BACK_UPLOAD")) {
          b = 1;
          break;
        } 
      case 223350067:
        if (paramString.equals("LIVE_CARD_FRONT_UPLOAD")) {
          b = 0;
          break;
        } 
      case -189439929:
        if (paramString.equals("LIVE_CARD_BACK_DELETE")) {
          b = 3;
          break;
        } 
      case -273513251:
        if (paramString.equals("LIVE_CARD_FRONT_DELETE")) {
          b = 2;
          break;
        } 
      case -694052169:
        if (paramString.equals("LIVE_IMPROVE_STATE")) {
          b = 4;
          break;
        } 
    } 
    if (b != 0) {
      if (b != 1) {
        if (b != 2) {
          if (b != 3) {
            if (b != 4) {
              b(paramString, paramList);
            } else if (paramList != null && paramList.size() > 0) {
              this.g = paramList.get(0);
            } 
          } else {
            this.r = false;
            this.live_card2.setVisibility(8);
            this.cover_del_btn2.setVisibility(8);
            this.p = "";
          } 
        } else {
          this.q = false;
          this.live_card1.setVisibility(8);
          this.cover_del_btn1.setVisibility(8);
          this.o = "";
        } 
      } else if (paramList != null && paramList.size() > 0) {
        LiveIDCardUploadResult liveIDCardUploadResult = (LiveIDCardUploadResult)paramList.get(0);
        this.r = true;
        this.p = liveIDCardUploadResult.pic;
        this.live_card2.setVisibility(0);
        ImageLoader.d((IRequestHost)w_(), this.n).a(2131233093).a(this.live_card2);
        this.cover_del_btn2.setVisibility(0);
        InstantLog.b("verify_photo_uploaded", 1);
        EventTrackSettings.b(SettingsProtos.Event.VERIFY_PHOTO_UPLOADED, 1);
      } 
    } else if (paramList != null && paramList.size() > 0) {
      LiveIDCardUploadResult liveIDCardUploadResult = (LiveIDCardUploadResult)paramList.get(0);
      this.q = true;
      this.o = liveIDCardUploadResult.pic;
      this.live_card1.setVisibility(0);
      ImageLoader.d((IRequestHost)w_(), this.j).a(2131233093).a(this.live_card1);
      this.cover_del_btn1.setVisibility(0);
      InstantLog.b("verify_photo_uploaded", 0);
      EventTrackSettings.b(SettingsProtos.Event.VERIFY_PHOTO_UPLOADED, 0);
    } 
    m();
  }
  
  public void a(String paramString, boolean paramBoolean) {
    super.a(paramString, paramBoolean);
    DialogUtils.b(this.v);
    if (paramString == "LIVE_IMPROVE_STATE")
      c(false); 
  }
  
  public void aL_() {
    super.aL_();
  }
  
  public void b(String paramString) {
    super.b(paramString);
    DialogUtils.a(this.v);
  }
  
  public abstract void b(String paramString, List paramList);
  
  public abstract void b(boolean paramBoolean);
  
  public abstract void k();
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {
    if (paramInt2 == -1)
      if (paramInt1 != 0) {
        if (paramInt1 == 22 && paramIntent != null) {
          this.i = paramIntent.getStringExtra("photo_path");
          int i = this.t;
          if (i != 0) {
            if (i == 1) {
              String str = this.i;
              this.n = str;
              a(this.f, str, 1);
            } 
          } else {
            String str = this.i;
            this.j = str;
            a(this.f, str, 0);
          } 
        } 
      } else {
        ClipPhotoFragment.a((BaseFragment)this, 9, this.i, 22);
      }  
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public void onClick(View paramView) {
    switch (paramView.getId()) {
      default:
        return;
      case 2131301252:
        b(false);
        return;
      case 2131300563:
      case 2131300564:
        this.h = true;
        k();
        return;
      case 2131299424:
        this.u.cancel();
        PhotoSelectFragment.a((BaseFragment)this, 9, 22);
        return;
      case 2131299422:
        this.u.cancel();
        return;
      case 2131299421:
        this.u.cancel();
        n();
        return;
      case 2131298728:
        b(true);
        return;
      case 2131298184:
        b(1, this.p);
        return;
      case 2131298183:
        b(0, this.o);
        return;
      case 2131298157:
        this.t = 1;
        a(1);
        return;
      case 2131298156:
        this.t = 0;
        a(0);
        return;
      case 2131296863:
        getActivity().finish();
        return;
      case 2131296847:
        a(1, this.p);
        return;
      case 2131296846:
        break;
    } 
    a(0, this.o);
  }
  
  public void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    this.f = getContext();
  }
  
  public int p() {
    return 2131493169;
  }
  
  class DialogViewHolder {
    @BindView(2131299421)
    Button openCamera;
    
    @BindView(2131299422)
    ImageView openClose;
    
    @BindView(2131299424)
    Button openPhones;
    
    @BindView(2131301696)
    ImageView viewer_card;
    
    DialogViewHolder(LiveBaseImproveFragment this$0) {}
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\live\fragment\LiveBaseImproveFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */