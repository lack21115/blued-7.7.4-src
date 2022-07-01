package com.soft.blued.ui.setting.fragment;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import butterknife.BindView;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.image.ImageOptions;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.utils.skin.BluedSkinUtils;
import com.blued.android.framework.ui.mvp.MvpFragment;
import com.blued.android.framework.ui.mvp.MvpUtils;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.common.utils.ToastUtils;
import com.jeremyliao.liveeventbus.LiveEventBus;
import com.soft.blued.customview.CommonTopTitleNoTrans;
import com.soft.blued.db.model.UserAccountsModel;
import com.soft.blued.ui.setting.Presenter.SwitchAccountPresenter;
import com.soft.blued.user.UserInfo;
import com.soft.blued.utils.BluedPreferences;
import com.soft.blued.view.tip.CommonAlertDialog;
import com.youzan.androidsdk.tool.NetWorkUtil;
import java.util.List;

public class SwitchAccountFragment extends MvpFragment<SwitchAccountPresenter> implements View.OnClickListener {
  private int d = 0;
  
  private boolean e = false;
  
  private ImageOptions f = new ImageOptions();
  
  private ImageOptions g = new ImageOptions();
  
  @BindView(2131297666)
  ImageView iv_account_icon_one;
  
  @BindView(2131297667)
  ImageView iv_account_icon_two;
  
  @BindView(2131297743)
  ImageView iv_delete_one;
  
  @BindView(2131297745)
  ImageView iv_delete_two;
  
  @BindView(2131297884)
  ImageView iv_online_state_one;
  
  @BindView(2131297885)
  ImageView iv_online_state_two;
  
  @BindView(2131300300)
  CommonTopTitleNoTrans top_title;
  
  @BindView(2131300481)
  TextView tv_account_nick_one;
  
  @BindView(2131300482)
  TextView tv_account_nick_two;
  
  @BindView(2131300492)
  TextView tv_add_account;
  
  @BindView(2131300876)
  ShapeTextView tv_has_unread;
  
  @BindView(2131301024)
  TextView tv_management;
  
  @BindView(2131301025)
  TextView tv_management_hint;
  
  @BindView(2131301135)
  TextView tv_online_hint_one;
  
  private void a(List<UserAccountsModel> paramList) {
    if (paramList != null && paramList.size() > 0) {
      if (paramList.size() == 2) {
        this.d = 1;
      } else {
        this.d = 0;
      } 
      UserAccountsModel userAccountsModel = paramList.get(0);
      ImageLoader.a((IRequestHost)w_(), (userAccountsModel.getBluedLoginResult()).avatar).c().a(this.f).a(this.iv_account_icon_one);
      this.tv_account_nick_one.setText((userAccountsModel.getBluedLoginResult()).name);
      if (this.d == 1) {
        UserAccountsModel userAccountsModel1 = paramList.get(1);
        ImageLoader.a((IRequestHost)w_(), (userAccountsModel1.getBluedLoginResult()).avatar).c().a(this.g).a(this.iv_account_icon_two);
        this.iv_online_state_two.setVisibility(0);
        this.tv_account_nick_two.setVisibility(0);
        this.tv_account_nick_two.setText((userAccountsModel1.getBluedLoginResult()).name);
        this.tv_add_account.setVisibility(8);
        this.tv_management.setVisibility(0);
        return;
      } 
      this.iv_account_icon_two.setImageResource(2131232368);
      this.iv_online_state_two.setVisibility(8);
      this.tv_account_nick_two.setVisibility(8);
      this.tv_add_account.setVisibility(0);
      this.tv_management.setVisibility(8);
      this.tv_has_unread.setVisibility(8);
    } 
  }
  
  private void b(boolean paramBoolean) {
    if (!NetWorkUtil.isConnected(getContext())) {
      ToastUtils.a(getResources().getString(2131758201));
      return;
    } 
    ((SwitchAccountPresenter)s()).a(paramBoolean);
  }
  
  private void c(Runnable paramRunnable) {
    CommonAlertDialog.a(getContext(), "", getResources().getString(2131756177), null, new DialogInterface.OnClickListener(this, paramRunnable) {
          public void onClick(DialogInterface param1DialogInterface, int param1Int) {
            this.a.run();
          }
        }null, null, null);
  }
  
  private void k() {
    if (this.e) {
      this.top_title.getLeftImg().setVisibility(8);
      this.top_title.getLeftTextView().setVisibility(0);
      if (this.d == 0) {
        this.iv_delete_one.setVisibility(0);
      } else {
        this.iv_delete_one.setVisibility(0);
        this.iv_delete_two.setVisibility(0);
      } 
      this.tv_has_unread.setAlpha(0.5F);
      this.tv_management_hint.setVisibility(0);
      return;
    } 
    this.top_title.getLeftImg().setVisibility(0);
    this.top_title.getLeftTextView().setVisibility(8);
    this.iv_delete_one.setVisibility(8);
    this.iv_delete_two.setVisibility(8);
    this.tv_has_unread.setAlpha(1.0F);
    this.tv_management_hint.setVisibility(4);
  }
  
  private void l() {
    if (!NetWorkUtil.isConnected(getContext())) {
      ToastUtils.a(getResources().getString(2131758201));
      return;
    } 
    ((SwitchAccountPresenter)s()).m();
  }
  
  public void a(Bundle paramBundle) {
    super.a(paramBundle);
    this.top_title.getRightImg().setVisibility(8);
    this.top_title.setCenterText(getString(2131758982));
    this.top_title.getLeftImg().setOnClickListener(this);
    this.top_title.getLeftTextView().setOnClickListener(this);
    this.top_title.getLeftTextView().setText(getResources().getString(2131755726));
    this.top_title.getLeftTextView().setTextColor(BluedSkinUtils.a(getContext(), 2131100838));
    this.top_title.getLeftTextView().setVisibility(8);
    this.iv_delete_one.setOnClickListener(this);
    this.iv_delete_two.setOnClickListener(this);
    this.iv_account_icon_one.setOnClickListener(this);
    this.iv_account_icon_two.setOnClickListener(this);
    this.tv_management.setOnClickListener(this);
    if ((UserInfo.a().i()).vip_grade == 0) {
      ImageOptions imageOptions1 = this.f;
      imageOptions1.c = 2131234358;
      imageOptions1.a = 2131234358;
    } else {
      ImageOptions imageOptions1 = this.f;
      imageOptions1.c = 2131234357;
      imageOptions1.a = 2131234357;
    } 
    ImageOptions imageOptions = this.g;
    imageOptions.c = 2131234358;
    imageOptions.a = 2131234358;
    LiveEventBus.get("hide_login_back", Void.class).observe((LifecycleOwner)this, new Observer<Void>(this) {
          public void a(Void param1Void) {
            LiveEventBus.get("finish_setting").post(null);
            this.a.top_title.getLeftImg().setVisibility(8);
          }
        });
    if (BluedPreferences.el()) {
      this.tv_has_unread.setVisibility(0);
      int i = BluedPreferences.ej();
      if (i != 1) {
        if (i != 2) {
          if (i != 3)
            return; 
          this.tv_has_unread.setText(2131758985);
          return;
        } 
        this.tv_has_unread.setText(2131758984);
        return;
      } 
      this.tv_has_unread.setText(2131758983);
    } 
  }
  
  public void a(String paramString, List paramList) {
    super.a(paramString, paramList);
    if (paramString.equals("data_account") && paramList != null && paramList.size() > 0)
      MvpUtils.a(paramList, UserAccountsModel.class, new MvpUtils.DataListHandler<UserAccountsModel>(this) {
            public void a() {}
            
            public void a(List<UserAccountsModel> param1List) {
              SwitchAccountFragment.a(this.a, param1List);
              SwitchAccountFragment.a(this.a, false);
              SwitchAccountFragment.a(this.a);
            }
          }); 
  }
  
  public boolean j() {
    return false;
  }
  
  public void onClick(View paramView) {
    switch (paramView.getId()) {
      default:
        return;
      case 2131301024:
        if (this.e)
          return; 
        this.e = true;
        k();
        return;
      case 2131297745:
        c(new Runnable(this) {
              public void run() {
                ((SwitchAccountPresenter)this.a.s()).p();
                ((SwitchAccountPresenter)this.a.s()).o();
                BluedPreferences.U(false);
              }
            });
        return;
      case 2131297743:
        c(new Runnable(this) {
              public void run() {
                SwitchAccountFragment.b(this.a, true);
              }
            });
        return;
      case 2131297667:
        if (this.e)
          return; 
        if (this.d == 0) {
          ((SwitchAccountPresenter)s()).n();
          return;
        } 
        b(false);
        return;
      case 2131297666:
        if (this.e)
          return; 
        if (!UserInfo.a().j()) {
          l();
          return;
        } 
        return;
      case 2131296865:
        getActivity().finish();
        return;
      case 2131296863:
        break;
    } 
    if (!this.e)
      return; 
    this.e = false;
    k();
  }
  
  public int p() {
    return 2131493065;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\setting\fragment\SwitchAccountFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */