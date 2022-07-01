package com.soft.blued.ui.msg.fragment;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.viewpager.widget.ViewPager;
import butterknife.BindView;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.utils.skin.BluedSkinUtils;
import com.blued.android.framework.ui.xpop.XPopup;
import com.blued.android.framework.ui.xpop.core.BasePopupView;
import com.blued.android.framework.ui.xpop.interfaces.SimpleCallback;
import com.blued.android.framework.ui.xpop.interfaces.XPopupCallback;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.module.common.utils.ToastUtils;
import com.blued.das.profile.PersonalProfileProtos;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.jeremyliao.liveeventbus.LiveEventBus;
import com.soft.blued.customview.CirclePageIndicator;
import com.soft.blued.log.trackUtils.EventTrackPersonalProfile;
import com.soft.blued.ui.msg.adapter.UserGiftPackageAdapter;
import com.soft.blued.ui.msg.event.GiftHintEvent;
import com.soft.blued.ui.msg.model.Selectable;
import com.soft.blued.ui.msg.model.UserGiftPackageModel;
import com.soft.blued.ui.msg.pop.BirthCardPop;
import com.soft.blued.ui.msg.pop.UserGiftDialogFragment;
import com.soft.blued.ui.msg.presenter.UserGiftPresenter;
import com.soft.blued.user.UserInfo;
import com.soft.blued.utils.Logger;
import com.soft.blued.utils.PopMenuUtils;
import java.util.List;

public class UserGiftPackageFragment extends BasePagerGridFragment<UserGiftPresenter, UserGiftPackageAdapter, UserGiftPackageModel> implements View.OnClickListener {
  public static final String j = UserGiftPackageFragment.class.getSimpleName();
  
  @BindView(2131297592)
  public CirclePageIndicator circlePageIndicator;
  
  @BindView(2131297250)
  public ViewPager gift_pager;
  
  private UserGiftDialogFragment n;
  
  private UserGiftDialogFragment.BuySucceedListener o;
  
  private String p;
  
  private String q;
  
  private String r;
  
  @BindView(2131300055)
  public TextView stv_buy;
  
  @BindView(2131300730)
  public TextView tv_empty;
  
  public UserGiftPackageFragment() {}
  
  public UserGiftPackageFragment(String paramString1, String paramString2, String paramString3, UserGiftDialogFragment.BuySucceedListener paramBuySucceedListener, UserGiftDialogFragment paramUserGiftDialogFragment) {
    this.n = paramUserGiftDialogFragment;
    this.o = paramBuySucceedListener;
    this.p = paramString1;
    this.q = paramString2;
    this.r = paramString3;
  }
  
  protected void E() {
    if (getContext() != null)
      ToastUtils.a(getContext().getString(2131757983)); 
    UserGiftDialogFragment.BuySucceedListener buySucceedListener = this.o;
    if (buySucceedListener != null)
      buySucceedListener.a(this.n, this.i.gift_detail); 
  }
  
  public void a(Bundle paramBundle) {
    super.a(paramBundle);
    this.stv_buy.setOnClickListener(this);
    this.circlePageIndicator.setInterval(DensityUtils.a(getContext(), 5.0F));
    this.circlePageIndicator.setPageColor(BluedSkinUtils.a(getContext(), 2131100808));
    this.circlePageIndicator.setFillColor(BluedSkinUtils.a(getContext(), 2131100621));
    UserGiftDialogFragment userGiftDialogFragment = this.n;
    if (userGiftDialogFragment != null && userGiftDialogFragment.h() != null)
      this.n.h().a(this.l, 1); 
    LiveEventBus.get("go_on_send_gift_package", Void.class).observe((LifecycleOwner)this, new Observer<Void>(this) {
          public void a(Void param1Void) {
            this.a.stv_buy.performClick();
          }
        });
  }
  
  protected void a(UserGiftPackageModel paramUserGiftPackageModel) {
    GiftHintEvent giftHintEvent = new GiftHintEvent();
    if (paramUserGiftPackageModel == null || paramUserGiftPackageModel.gift_detail == null) {
      LiveEventBus.get("gift_hint").post(giftHintEvent);
      return;
    } 
    super.b(paramUserGiftPackageModel);
    UserGiftDialogFragment userGiftDialogFragment = this.n;
    if (userGiftDialogFragment != null && userGiftDialogFragment.j() == 1) {
      giftHintEvent.a = paramUserGiftPackageModel.gift_detail.type;
      giftHintEvent.e = paramUserGiftPackageModel.gift_detail.icon;
      if (paramUserGiftPackageModel.gift_detail.type == 1) {
        giftHintEvent.b = getContext().getString(2131756597);
      } else {
        String str;
        if (paramUserGiftPackageModel.gift_detail.type == 2) {
          giftHintEvent.d = true;
          int i = paramUserGiftPackageModel.gift_detail.seconds / 3600;
          str = getContext().getString(2131759172);
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append(i);
          stringBuilder.append("");
          giftHintEvent.b = String.format(str, new Object[] { stringBuilder.toString() });
        } else if (((UserGiftPackageModel)str).gift_detail.type == 3) {
          giftHintEvent.d = true;
          giftHintEvent.b = getString(2131757987);
        } 
      } 
      LiveEventBus.get("gift_hint").post(giftHintEvent);
    } 
  }
  
  public UserGiftPackageAdapter b(List<UserGiftPackageModel> paramList) {
    return new UserGiftPackageAdapter((IRequestHost)w_(), paramList);
  }
  
  protected void c(List<UserGiftPackageModel> paramList) {
    String str = j;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("DATA_PACKAGE===");
    stringBuilder.append(paramList.size());
    Logger.c(str, new Object[] { stringBuilder.toString() });
    this.d = paramList;
    a(this.gift_pager, this.circlePageIndicator);
    if (paramList != null && paramList.size() > 0) {
      if (paramList.size() > k())
        this.circlePageIndicator.setVisibility(0); 
      this.tv_empty.setVisibility(4);
      a(paramList.get(0));
    } 
  }
  
  public void onClick(View paramView) {
    if (paramView.getId() != 2131300055)
      return; 
    if (this.i != null) {
      PersonalProfileProtos.GiftFrom giftFrom;
      if (this.i.gift_detail == null)
        return; 
      PersonalProfileProtos.Event event = PersonalProfileProtos.Event.GIFT_BUY_PAGE_BUY_BTN_CLICK;
      String str2 = this.p;
      if (this.q.equals("user_page_gift")) {
        giftFrom = PersonalProfileProtos.GiftFrom.PERSONAL_PAGE;
      } else {
        giftFrom = PersonalProfileProtos.GiftFrom.MESSAGE_PAGE;
      } 
      EventTrackPersonalProfile.a(event, str2, giftFrom, this.i.gift_detail.gift_id, true);
      if (PopMenuUtils.a(getContext())) {
        UserGiftDialogFragment userGiftDialogFragment1 = this.n;
        if (userGiftDialogFragment1 != null)
          userGiftDialogFragment1.dismiss(); 
        return;
      } 
      UserGiftDialogFragment userGiftDialogFragment = this.n;
      if (userGiftDialogFragment != null && ("8".equals(userGiftDialogFragment.i()) || "4".equals(this.n.i()) || "12".equals(this.n.i()))) {
        ToastUtils.a(getResources().getString(2131757984));
        return;
      } 
      if (this.i.gift_detail.type == 3 && this.i.gift_detail.extra_info != null && TextUtils.isEmpty(this.i.gift_detail.extra_info.text)) {
        this.i.gift_detail.extra_info.to = this.r;
        this.i.gift_detail.extra_info.from = (UserInfo.a().i()).name;
        BirthCardPop birthCardPop = new BirthCardPop(getContext(), this.i.gift_detail, true, true);
        birthCardPop.c = (IRequestHost)w_();
        (new XPopup.Builder(getContext())).e(Boolean.valueOf(false)).a((XPopupCallback)new SimpleCallback(this, birthCardPop) {
              public boolean f(BasePopupView param1BasePopupView) {
                this.a.c();
                return true;
              }
            }).a((BasePopupView)birthCardPop).h();
        return;
      } 
      UserGiftPresenter userGiftPresenter = (UserGiftPresenter)this.k;
      String str1 = this.p;
      str2 = this.q;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(this.i.id);
      stringBuilder.append("");
      userGiftPresenter.a(str1, str2, null, stringBuilder.toString());
    } 
  }
  
  public int p() {
    return 2131493067;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\msg\fragment\UserGiftPackageFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */