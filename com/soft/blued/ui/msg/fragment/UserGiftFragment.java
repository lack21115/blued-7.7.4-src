package com.soft.blued.ui.msg.fragment;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.viewpager.widget.ViewPager;
import butterknife.BindView;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.utils.skin.BluedSkinUtils;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.ui.xpop.XPopup;
import com.blued.android.framework.ui.xpop.core.BasePopupView;
import com.blued.android.framework.ui.xpop.interfaces.SimpleCallback;
import com.blued.android.framework.ui.xpop.interfaces.XPopupCallback;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.framework.view.shape.ShapeHelper;
import com.blued.android.framework.view.shape.ShapeRelativeLayout;
import com.blued.android.module.common.utils.ToastUtils;
import com.blued.das.profile.PersonalProfileProtos;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.jeremyliao.liveeventbus.LiveEventBus;
import com.soft.blued.customview.CirclePageIndicator;
import com.soft.blued.http.ChatHttpUtils;
import com.soft.blued.http.UserHttpUtils;
import com.soft.blued.log.trackUtils.EventTrackPersonalProfile;
import com.soft.blued.ui.msg.adapter.UserGiftAdapterNew;
import com.soft.blued.ui.msg.event.GiftHintEvent;
import com.soft.blued.ui.msg.event.UpdateVoucherEvent;
import com.soft.blued.ui.msg.model.GiftVoucherModel;
import com.soft.blued.ui.msg.model.Selectable;
import com.soft.blued.ui.msg.pop.BirthCardPop;
import com.soft.blued.ui.msg.pop.GiftVoucherPop;
import com.soft.blued.ui.msg.pop.NormalPayTypeChoosePop;
import com.soft.blued.ui.msg.pop.UserGiftDialogFragment;
import com.soft.blued.ui.msg.presenter.UserGiftPresenter;
import com.soft.blued.ui.user.fragment.PayPreOrderFragment;
import com.soft.blued.ui.user.model.GiftGivingOptionForJsonParse;
import com.soft.blued.ui.user.model.GoodsOptionBasic;
import com.soft.blued.ui.user.observer.VIPBuyResultObserver;
import com.soft.blued.user.UserInfo;
import com.soft.blued.utils.BluedPreferences;
import com.soft.blued.utils.PopMenuUtils;
import com.soft.blued.view.tip.CommonAlertDialog;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class UserGiftFragment extends BasePagerGridFragment<UserGiftPresenter, UserGiftAdapterNew, GiftGivingOptionForJsonParse> implements View.OnClickListener, VIPBuyResultObserver.IVIPBuyResultObserver {
  public static final String j = UserGiftFragment.class.getSimpleName();
  
  public static String n;
  
  @BindView(2131297592)
  public CirclePageIndicator circlePageIndicator;
  
  @BindView(2131297250)
  public ViewPager gift_pager;
  
  @BindView(2131299087)
  public LinearLayout ll_stock_tip;
  
  private UserGiftDialogFragment o;
  
  private String p = "";
  
  private UserGiftDialogFragment.BuySucceedListener q;
  
  private String r;
  
  @BindView(2131299723)
  public ShapeRelativeLayout rl_pay_type;
  
  @BindView(2131299739)
  public ShapeRelativeLayout rl_voucher;
  
  private String s;
  
  @BindView(2131300055)
  public TextView stv_buy;
  
  private int t = 2;
  
  @BindView(2131301164)
  public TextView tv_pay_title;
  
  @BindView(2131301165)
  public TextView tv_pay_type;
  
  @BindView(2131301514)
  public TextView tv_voucher;
  
  @BindView(2131301515)
  public TextView tv_voucher_title;
  
  private boolean u;
  
  private boolean v;
  
  @BindView(2131301722)
  public View voucher_line;
  
  private List<GiftVoucherModel> w;
  
  private VoucherComparator x = new VoucherComparator();
  
  public UserGiftFragment() {}
  
  public UserGiftFragment(List<GiftGivingOptionForJsonParse> paramList, String paramString1, String paramString2, int paramInt, String paramString3, UserGiftDialogFragment.BuySucceedListener paramBuySucceedListener, UserGiftDialogFragment paramUserGiftDialogFragment) {
    this.d = paramList;
    this.r = paramString1;
    this.s = paramString2;
    this.q = paramBuySucceedListener;
    this.o = paramUserGiftDialogFragment;
    this.t = paramInt;
    this.p = paramString3;
  }
  
  private void E() {
    LiveEventBus.get("update_voucher", UpdateVoucherEvent.class).observe((LifecycleOwner)this, new Observer<UpdateVoucherEvent>(this) {
          public void a(UpdateVoucherEvent param1UpdateVoucherEvent) {
            this.a.a(param1UpdateVoucherEvent.a, param1UpdateVoucherEvent.b);
          }
        });
    LiveEventBus.get("go_on_send_gift", Void.class).observe((LifecycleOwner)this, new Observer<Void>(this) {
          public void a(Void param1Void) {
            if (this.a.i != null && this.a.i.extra_info != null && !TextUtils.isEmpty(this.a.i.extra_info.text))
              UserGiftFragment.a(this.a); 
          }
        });
  }
  
  private void F() {
    ChatHttpUtils.c(new BluedUIHttpResponse<BluedEntityA<GiftVoucherModel>>(this, (IRequestHost)w_()) {
          protected void a(BluedEntityA<GiftVoucherModel> param1BluedEntityA) {
            if (param1BluedEntityA.hasData()) {
              UserGiftFragment.a(this.a, param1BluedEntityA.data);
              for (int i = 0; i < UserGiftFragment.c(this.a).size(); i = SYNTHETIC_LOCAL_VARIABLE_3 + 1) {
                if (((GiftVoucherModel)UserGiftFragment.c(this.a).get(i)).status == 1) {
                  UserGiftFragment.c(this.a).remove(i);
                } else {
                  int k = i;
                  if (((GiftVoucherModel)UserGiftFragment.c(this.a).get(i)).end_timestamp * 1000L < System.currentTimeMillis()) {
                    ((GiftVoucherModel)UserGiftFragment.c(this.a).get(i)).isExpire = true;
                    k = i;
                    if (System.currentTimeMillis() - ((GiftVoucherModel)UserGiftFragment.c(this.a).get(i)).end_timestamp * 1000L > 259200000L) {
                      UserGiftFragment.c(this.a).remove(i);
                    } else {
                      continue;
                    } 
                  } else {
                    continue;
                  } 
                } 
                int j = i - 1;
                continue;
              } 
              if (UserGiftFragment.c(this.a).size() > 0) {
                UserGiftFragment.d(this.a);
                if (BluedPreferences.dx() != 0 && BluedPreferences.dx() != 3) {
                  UserGiftFragment.a(this.a, BluedPreferences.dx());
                } else {
                  UserGiftFragment.a(this.a, 1);
                } 
                UserGiftFragment.a(this.a, true);
              } 
            } 
          }
          
          public void onUIFinish(boolean param1Boolean) {
            super.onUIFinish(param1Boolean);
            if (this.a.d != null && this.a.d.size() > 0) {
              int i = 0;
              while (true) {
                int j = this.a.d.size();
                byte b = 1;
                if (i < j) {
                  if (((GiftGivingOptionForJsonParse)this.a.d.get(i)).is_default == 1) {
                    UserGiftFragment userGiftFragment1 = this.a;
                    userGiftFragment1.a(userGiftFragment1.d.get(i));
                    i = b;
                    break;
                  } 
                  i++;
                  continue;
                } 
                i = 0;
                break;
              } 
              if (i == 0) {
                UserGiftFragment userGiftFragment1 = this.a;
                userGiftFragment1.a(userGiftFragment1.d.get(0));
              } 
              UserGiftFragment.b(this.a);
              UserGiftFragment userGiftFragment = this.a;
              userGiftFragment.a(userGiftFragment.i);
            } 
          }
        }(IRequestHost)w_());
  }
  
  private boolean G() {
    if (this.i != null) {
      List<GiftVoucherModel> list = this.w;
      if (list != null) {
        if (list.size() == 0)
          return false; 
        for (GiftVoucherModel giftVoucherModel : this.w) {
          if (giftVoucherModel.status == 0)
            this.v = true; 
          giftVoucherModel.isChecked = false;
        } 
        return this.v;
      } 
    } 
    return false;
  }
  
  private void H() {
    GiftGivingOptionForJsonParse giftGivingOptionForJsonParse = this.i;
    boolean bool = true;
    int i = 2131758279;
    if (giftGivingOptionForJsonParse != null && this.i.currentVoucher != null) {
      if (!this.u) {
        this.tv_voucher.setText(String.format(getContext().getString(2131759331), new Object[] { this.i.currentVoucher.title }));
        this.tv_voucher.setTextColor(BluedSkinUtils.a(getContext(), 2131100806));
        this.tv_voucher_title.setTextColor(BluedSkinUtils.a(getContext(), 2131100806));
        this.tv_voucher.setCompoundDrawablesWithIntrinsicBounds(null, null, BluedSkinUtils.b(getContext(), 2131232770), null);
        this.stv_buy.setText(getContext().getString(2131756366));
      } else {
        this.tv_voucher.setText(getContext().getString(2131758279));
        this.tv_voucher.setCompoundDrawablesWithIntrinsicBounds(null, null, BluedSkinUtils.b(getContext(), 2131232670), null);
        this.tv_voucher.setTextColor(BluedSkinUtils.a(getContext(), 2131100807));
        this.tv_voucher_title.setTextColor(BluedSkinUtils.a(getContext(), 2131100807));
      } 
      this.tv_pay_type.setCompoundDrawablesWithIntrinsicBounds(null, null, BluedSkinUtils.b(getContext(), 2131232670), null);
      this.tv_pay_title.setTextColor(BluedSkinUtils.a(getContext(), 2131100807));
      this.tv_pay_type.setTextColor(BluedSkinUtils.a(getContext(), 2131100807));
    } else {
      if (this.v && !this.u && this.w.size() > 0) {
        boolean bool1 = bool;
        if (!((GiftVoucherModel)this.w.get(0)).isExpire)
          if (((GiftVoucherModel)this.w.get(0)).money < this.i.money) {
            bool1 = bool;
          } else {
            bool1 = false;
          }  
        TextView textView = this.tv_voucher;
        Context context = getContext();
        if (bool1)
          i = 2131758275; 
        textView.setText(context.getString(i));
        this.tv_voucher.setTextColor(BluedSkinUtils.a(getContext(), 2131100806));
        this.tv_voucher_title.setTextColor(BluedSkinUtils.a(getContext(), 2131100806));
        this.tv_voucher.setCompoundDrawablesWithIntrinsicBounds(null, null, BluedSkinUtils.b(getContext(), 2131232770), null);
      } else {
        this.tv_voucher.setText(getContext().getString(2131758275));
        this.tv_voucher.setCompoundDrawablesWithIntrinsicBounds(null, null, BluedSkinUtils.b(getContext(), 2131232670), null);
        this.tv_voucher.setTextColor(BluedSkinUtils.a(getContext(), 2131100807));
        this.tv_voucher_title.setTextColor(BluedSkinUtils.a(getContext(), 2131100807));
      } 
      this.tv_pay_type.setCompoundDrawablesWithIntrinsicBounds(null, null, BluedSkinUtils.b(getContext(), 2131232770), null);
      this.tv_pay_title.setTextColor(BluedSkinUtils.a(getContext(), 2131100806));
      this.tv_pay_type.setTextColor(BluedSkinUtils.a(getContext(), 2131100806));
      this.stv_buy.setText(getContext().getString(2131756596));
    } 
    this.tv_voucher.setCompoundDrawablePadding(DensityUtils.a(getContext(), 5.0F));
    this.tv_pay_type.setCompoundDrawablePadding(DensityUtils.a(getContext(), 5.0F));
  }
  
  private void I() {
    if (this.d == null)
      return; 
    this.ll_stock_tip.setVisibility(8);
    for (int i = 0; i < this.d.size(); i++) {
      if (((GiftGivingOptionForJsonParse)this.d.get(i)).is_stock == 1) {
        this.ll_stock_tip.setVisibility(0);
        return;
      } 
    } 
  }
  
  private void J() {
    this.rl_voucher.setVisibility(0);
    this.voucher_line.setVisibility(0);
  }
  
  private void K() {
    if (this.i == null)
      return; 
    try {
      this.i.id = Integer.valueOf(this.i.gift_id).intValue();
    } finally {
      Exception exception;
    } 
    NormalPayTypeChoosePop.a(getContext(), new NormalPayTypeChoosePop.iChoosePayResultListener(this) {
          public void a() {}
          
          public void a(int param1Int, boolean param1Boolean) {
            UserGiftFragment.a(this.a, param1Int);
            UserGiftFragment.a(this.a, true);
          }
        }this.t, this.i.id, (IRequestHost)w_());
  }
  
  private void L() {
    if (this.i == null)
      return; 
    try {
      this.i.id = Integer.valueOf(this.i.gift_id).intValue();
    } finally {
      Exception exception;
    } 
    if (this.i.type == 3 && this.i.extra_info != null && TextUtils.isEmpty(this.i.extra_info.text)) {
      this.i.extra_info.to = this.p;
      this.i.extra_info.from = (UserInfo.a().i()).name;
      BirthCardPop birthCardPop = new BirthCardPop(getContext(), this.i, true, false);
      birthCardPop.c = (IRequestHost)w_();
      (new XPopup.Builder(getContext())).e(Boolean.valueOf(false)).a((XPopupCallback)new SimpleCallback(this, birthCardPop) {
            public boolean f(BasePopupView param1BasePopupView) {
              this.a.c();
              return true;
            }
          }).a((BasePopupView)birthCardPop).h();
      return;
    } 
    if (this.i.is_stock == 1) {
      M();
      return;
    } 
    if (this.i.is_free == 2 || this.i.currentVoucher != null) {
      N();
      return;
    } 
    if (this.i.type == -1)
      n = this.i.icon; 
    PayPreOrderFragment.a(getContext(), (GoodsOptionBasic)this.i, null, this.r, null, null, this.s, this.t, 0, (IRequestHost)w_());
  }
  
  private void M() {
    UserHttpUtils.b(new BluedUIHttpResponse(this, (IRequestHost)w_()) {
          public boolean onUIFailure(int param1Int, String param1String) {
            return super.onUIFailure(param1Int, param1String);
          }
          
          public void onUIFinish(boolean param1Boolean) {
            super.onUIFinish(param1Boolean);
            if (param1Boolean) {
              this.a.i.is_stock = 0;
              UserGiftFragment userGiftFragment = this.a;
              userGiftFragment.a(userGiftFragment.i);
              UserGiftFragment.b(this.a);
              if (UserGiftFragment.e(this.a) != null) {
                if (this.a.getContext() != null)
                  ToastUtils.a(this.a.getContext().getString(2131756602)); 
                UserGiftFragment.e(this.a).a(UserGiftFragment.f(this.a), this.a.i);
              } 
            } 
          }
          
          public void onUIUpdate(BluedEntity param1BluedEntity) {}
        }this.r, this.i.gift_id, this.s, null, (IRequestHost)w_());
  }
  
  private void N() {
    GiftVoucherModel giftVoucherModel;
    BluedUIHttpResponse bluedUIHttpResponse = new BluedUIHttpResponse(this, (IRequestHost)w_()) {
        public boolean onUIFailure(int param1Int, String param1String) {
          return super.onUIFailure(param1Int, param1String);
        }
        
        public void onUIFinish(boolean param1Boolean) {
          super.onUIFinish(param1Boolean);
          if (param1Boolean) {
            if (this.a.i.is_free == 2) {
              this.a.i.is_free = 1;
              UserGiftFragment userGiftFragment = this.a;
              userGiftFragment.a(userGiftFragment.i);
            } 
            if (this.a.i.currentVoucher != null) {
              if (UserGiftFragment.c(this.a) != null)
                UserGiftFragment.c(this.a).remove(this.a.i.currentVoucher); 
              this.a.i.currentVoucher = null;
              if (UserGiftFragment.c(this.a) != null && UserGiftFragment.c(this.a).size() > 0)
                UserGiftFragment.g(this.a); 
            } 
            if (UserGiftFragment.e(this.a) != null) {
              if (this.a.getContext() != null)
                ToastUtils.a(this.a.getContext().getString(2131756602)); 
              UserGiftFragment.e(this.a).a(UserGiftFragment.f(this.a), this.a.i);
            } 
          } 
        }
        
        public void onUIUpdate(BluedEntity param1BluedEntity) {}
      };
    String str1 = this.r;
    String str2 = this.i.gift_id;
    String str3 = this.s;
    if (this.i.is_free == 2) {
      giftVoucherModel = null;
    } else {
      giftVoucherModel = this.i.currentVoucher;
    } 
    UserHttpUtils.a(bluedUIHttpResponse, str1, str2, str3, giftVoucherModel, (IRequestHost)w_());
  }
  
  private void b(boolean paramBoolean) {
    if (getContext() == null)
      return; 
    int i = this.t;
    if (i != 1) {
      if (i != 2) {
        if (i != 3) {
          if (i == 4)
            this.tv_pay_type.setText(getContext().getString(2131758349)); 
        } else {
          this.tv_pay_type.setText(getContext().getString(2131758351));
        } 
      } else {
        this.tv_pay_type.setText(getContext().getString(2131758352));
      } 
    } else {
      this.tv_pay_type.setText(getContext().getString(2131755279));
    } 
    for (UserGiftAdapterNew userGiftAdapterNew : this.f) {
      userGiftAdapterNew.a = this.t;
      if (paramBoolean)
        userGiftAdapterNew.notifyDataSetChanged(); 
    } 
    if (paramBoolean)
      BluedPreferences.w(this.t); 
  }
  
  public void a(int paramInt, boolean paramBoolean) {
    if (paramInt == 1 && paramBoolean) {
      a(new Runnable(this) {
            public void run() {
              if (this.a.w_().isActive())
                CommonAlertDialog.a(this.a.getContext(), "", this.a.getContext().getString(2131757992), this.a.getContext().getString(2131759367), new DialogInterface.OnClickListener(this) {
                      public void onClick(DialogInterface param2DialogInterface, int param2Int) {
                        param2DialogInterface.dismiss();
                        UserGiftFragment.a(this.a.a);
                      }
                    },  this.a.getContext().getString(2131756057), null, null); 
            }
          }200L);
      return;
    } 
    if (paramBoolean)
      a(new Runnable(this) {
            public void run() {
              if (UserGiftFragment.e(this.a) != null) {
                if (this.a.getContext() != null)
                  ToastUtils.a(this.a.getContext().getString(2131756602)); 
                UserGiftFragment.e(this.a).a(UserGiftFragment.f(this.a), this.a.i);
              } 
            }
          }300L); 
  }
  
  public void a(Bundle paramBundle) {
    super.a(paramBundle);
    if (this.d != null) {
      this.circlePageIndicator.setInterval(DensityUtils.a(getContext(), 5.0F));
      this.circlePageIndicator.setPageColor(BluedSkinUtils.a(getContext(), 2131100808));
      this.circlePageIndicator.setFillColor(BluedSkinUtils.a(getContext(), 2131100621));
      a(this.gift_pager, this.circlePageIndicator);
      if (this.d.size() <= k())
        this.circlePageIndicator.setVisibility(8); 
      ShapeHelper.b((ShapeHelper.ShapeView)this.rl_pay_type, 2131100792);
      this.rl_pay_type.setOnClickListener(this);
      this.stv_buy.setOnClickListener(this);
      this.rl_voucher.setOnClickListener(this);
      b(false);
      E();
      VIPBuyResultObserver.a().a(this);
      F();
      UserGiftDialogFragment userGiftDialogFragment = this.o;
      if (userGiftDialogFragment != null && userGiftDialogFragment.h() != null)
        this.o.h().a(this.l, 0); 
    } 
  }
  
  public void a(GiftVoucherModel paramGiftVoucherModel, boolean paramBoolean) {
    if (paramBoolean) {
      this.i.currentVoucher = paramGiftVoucherModel;
      H();
      return;
    } 
    if (this.i.currentVoucher == null && paramGiftVoucherModel != null) {
      paramGiftVoucherModel.isChecked = false;
      return;
    } 
    if (this.i.currentVoucher != null && paramGiftVoucherModel == null) {
      this.i.currentVoucher.isChecked = true;
      return;
    } 
    if (this.i.currentVoucher != null && paramGiftVoucherModel != null && !this.i.currentVoucher.equals(paramGiftVoucherModel)) {
      this.i.currentVoucher.isChecked = true;
      paramGiftVoucherModel.isChecked = false;
    } 
  }
  
  protected void a(GiftGivingOptionForJsonParse paramGiftGivingOptionForJsonParse) {
    GiftHintEvent giftHintEvent = new GiftHintEvent();
    if (paramGiftGivingOptionForJsonParse == null) {
      giftHintEvent.d = false;
      LiveEventBus.get("gift_hint").post(giftHintEvent);
      return;
    } 
    super.b(paramGiftGivingOptionForJsonParse);
    giftHintEvent.a = paramGiftGivingOptionForJsonParse.type;
    giftHintEvent.e = paramGiftGivingOptionForJsonParse.icon;
    if (paramGiftGivingOptionForJsonParse.type != 1)
      if (paramGiftGivingOptionForJsonParse.type == 2) {
        giftHintEvent.d = true;
        int i = paramGiftGivingOptionForJsonParse.seconds / 3600;
        String str = getContext().getString(2131759172);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(i);
        stringBuilder.append("");
        giftHintEvent.b = String.format(str, new Object[] { stringBuilder.toString() });
      } else if (paramGiftGivingOptionForJsonParse.type == 3) {
        giftHintEvent.d = true;
        giftHintEvent.b = getString(2131757987);
      } else if (paramGiftGivingOptionForJsonParse.type == -1) {
        giftHintEvent.d = true;
        if (paramGiftGivingOptionForJsonParse.rules != null && paramGiftGivingOptionForJsonParse.rules.size() > 0) {
          StringBuilder stringBuilder = new StringBuilder();
          for (int i = 0; i < paramGiftGivingOptionForJsonParse.rules.size(); i++) {
            StringBuilder stringBuilder1 = new StringBuilder();
            stringBuilder1.append(paramGiftGivingOptionForJsonParse.rules.get(i));
            stringBuilder1.append("\n");
            stringBuilder.append(stringBuilder1.toString());
          } 
          giftHintEvent.b = stringBuilder.toString();
          giftHintEvent.c = paramGiftGivingOptionForJsonParse.rules_title;
        } 
      }  
    UserGiftDialogFragment userGiftDialogFragment = this.o;
    if (userGiftDialogFragment != null && userGiftDialogFragment.j() == 0)
      LiveEventBus.get("gift_hint").post(giftHintEvent); 
    if (paramGiftGivingOptionForJsonParse.is_free == 2 || paramGiftGivingOptionForJsonParse.is_stock == 1) {
      this.u = true;
    } else {
      this.u = false;
    } 
    this.v = false;
    if (paramGiftGivingOptionForJsonParse.type != -1) {
      List<GiftVoucherModel> list = this.w;
      if (list != null && list.size() > 0) {
        VoucherComparator voucherComparator = this.x;
        voucherComparator.a = paramGiftGivingOptionForJsonParse;
        Collections.sort(this.w, voucherComparator);
        if (G() && ((GiftVoucherModel)this.w.get(0)).money >= paramGiftGivingOptionForJsonParse.money) {
          paramGiftGivingOptionForJsonParse.currentVoucher = this.w.get(0);
          if (!paramGiftGivingOptionForJsonParse.currentVoucher.isExpire) {
            paramGiftGivingOptionForJsonParse.currentVoucher.isChecked = true;
          } else {
            paramGiftGivingOptionForJsonParse.currentVoucher = null;
          } 
        } else {
          paramGiftGivingOptionForJsonParse.currentVoucher = null;
        } 
      } 
    } 
    H();
  }
  
  protected UserGiftAdapterNew b(List paramList) {
    return new UserGiftAdapterNew((IRequestHost)w_(), paramList);
  }
  
  public void onClick(View paramView) {
    int i = paramView.getId();
    if (i != 2131299723) {
      if (i != 2131299739) {
        PersonalProfileProtos.GiftFrom giftFrom;
        if (i != 2131300055)
          return; 
        if (this.i == null)
          return; 
        PersonalProfileProtos.Event event = PersonalProfileProtos.Event.GIFT_BUY_PAGE_BUY_BTN_CLICK;
        String str = this.r;
        if (this.s.equals("user_page_gift")) {
          giftFrom = PersonalProfileProtos.GiftFrom.PERSONAL_PAGE;
        } else {
          giftFrom = PersonalProfileProtos.GiftFrom.MESSAGE_PAGE;
        } 
        EventTrackPersonalProfile.a(event, str, giftFrom, this.i.gift_id, false);
        if (PopMenuUtils.a(getContext())) {
          UserGiftDialogFragment userGiftDialogFragment1 = this.o;
          if (userGiftDialogFragment1 != null)
            userGiftDialogFragment1.dismiss(); 
          return;
        } 
        UserGiftDialogFragment userGiftDialogFragment = this.o;
        if (userGiftDialogFragment != null && ("8".equals(userGiftDialogFragment.i()) || "4".equals(this.o.i()) || "12".equals(this.o.i()))) {
          ToastUtils.a(getResources().getString(2131757984));
          return;
        } 
        L();
        return;
      } 
      if (this.i != null && this.v) {
        if (this.u)
          return; 
        GiftVoucherPop giftVoucherPop = new GiftVoucherPop(getContext());
        giftVoucherPop.c = this.w;
        giftVoucherPop.d = this.i.money;
        giftVoucherPop.e = this.i.currentVoucher;
        (new XPopup.Builder(getContext())).a((BasePopupView)giftVoucherPop).h();
        return;
      } 
      return;
    } 
    if (this.i != null && this.i.currentVoucher != null)
      return; 
    K();
  }
  
  public void onDestroy() {
    super.onDestroy();
    VIPBuyResultObserver.a().b(this);
  }
  
  public int p() {
    return 2131493066;
  }
  
  static class VoucherComparator implements Comparator<GiftVoucherModel> {
    public GiftGivingOptionForJsonParse a;
    
    private VoucherComparator() {}
    
    public int a(GiftVoucherModel param1GiftVoucherModel1, GiftVoucherModel param1GiftVoucherModel2) {
      if (param1GiftVoucherModel1 == null && param1GiftVoucherModel2 == null)
        return 0; 
      if (param1GiftVoucherModel1 == null)
        return -1; 
      if (param1GiftVoucherModel2 == null)
        return 1; 
      if (param1GiftVoucherModel1.isExpire && !param1GiftVoucherModel2.isExpire)
        return 1; 
      if (!param1GiftVoucherModel1.isExpire && param1GiftVoucherModel2.isExpire)
        return -1; 
      if (this.a != null) {
        if (param1GiftVoucherModel1.money >= this.a.money && param1GiftVoucherModel2.money < this.a.money)
          return -1; 
        if (param1GiftVoucherModel1.money < this.a.money && param1GiftVoucherModel2.money >= this.a.money)
          return 1; 
      } 
      return (param1GiftVoucherModel1.money > param1GiftVoucherModel2.money) ? 1 : ((param1GiftVoucherModel1.money < param1GiftVoucherModel2.money) ? -1 : ((param1GiftVoucherModel1.start_timestamp > param1GiftVoucherModel2.start_timestamp) ? 1 : ((param1GiftVoucherModel1.start_timestamp < param1GiftVoucherModel2.start_timestamp) ? -1 : 0)));
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\msg\fragment\UserGiftFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */