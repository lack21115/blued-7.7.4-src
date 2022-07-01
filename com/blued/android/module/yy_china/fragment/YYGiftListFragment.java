package com.blued.android.module.yy_china.fragment;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.core.AppInfo;
import com.blued.android.core.AppMethods;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.core.utils.toast.ToastUtils;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.framework.utils.LogUtils;
import com.blued.android.framework.utils.Logger;
import com.blued.android.framework.utils.StringUtils;
import com.blued.android.framework.utils.TypeUtils;
import com.blued.android.framework.view.shape.ShapeHelper;
import com.blued.android.framework.view.shape.ShapeLinearLayout;
import com.blued.android.module.common.adapter.CommonAdapter;
import com.blued.android.module.common.model.BaseGiftModel;
import com.blued.android.module.common.model.CommonGiftPackageModel;
import com.blued.android.module.live.base.fragment.LiveGiftBaseFragment;
import com.blued.android.module.live.base.model.BasePayRemaining;
import com.blued.android.module.live.base.model.CommonLiveGiftModel;
import com.blued.android.module.live.base.model.LiveGiftNumberModel;
import com.blued.android.module.live.base.utils.LiveAlterDialog;
import com.blued.android.module.live.base.utils.LiveBasePreferences;
import com.blued.android.module.yy_china.R;
import com.blued.android.module.yy_china.adapter.SelectUserAdapter;
import com.blued.android.module.yy_china.listener.IPopShowAndDismissListener;
import com.blued.android.module.yy_china.manager.YYGiftManager;
import com.blued.android.module.yy_china.manager.YYImMsgManager;
import com.blued.android.module.yy_china.manager.YYRoomInfoManager;
import com.blued.android.module.yy_china.model.YYGiftModel;
import com.blued.android.module.yy_china.model.YYGiftPackageModel;
import com.blued.android.module.yy_china.model.YYPayGoodsModel;
import com.blued.android.module.yy_china.model.YYPayRemaining;
import com.blued.android.module.yy_china.model.YYRoomModel;
import com.blued.android.module.yy_china.model.YYSeatMemberModel;
import com.blued.android.module.yy_china.utils.PopupwindowFactory;
import com.blued.android.module.yy_china.utils.YYRoomHttpUtils;
import com.blued.android.module.yy_china.utils.YYRouteUtil;
import com.blued.android.module.yy_china.utils.log.EventTrackYY;
import com.blued.das.client.chatroom.ChatRoomProtos;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import com.jeremyliao.liveeventbus.LiveEventBus;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import javax.annotation.Nonnull;

public class YYGiftListFragment extends LiveGiftBaseFragment {
  private YYGiftModel L;
  
  private LinearLayout M;
  
  private LinearLayout N;
  
  private SelectUserAdapter O;
  
  private ImageView P;
  
  private TextView Q;
  
  private TextView R;
  
  private List<YYSeatMemberModel> S;
  
  private int T = 0;
  
  private int U = 0;
  
  private YYRoomModel V;
  
  private String W;
  
  private ShapeLinearLayout X;
  
  private AlertDialog Y;
  
  private ImageView Z;
  
  private HashSet<String> aa;
  
  private String ab;
  
  private PopupWindow ac;
  
  private View ad;
  
  private YYSeatMemberModel ae;
  
  private void K() {
    this.W = getArguments().getString("from");
    this.ab = getArguments().getString("target_uid");
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("init source = ");
    stringBuilder.append(this.W);
    Logger.e("YYGiftListFragment", new Object[] { stringBuilder.toString() });
    this.V = YYRoomInfoManager.d().b();
    if (this.V == null) {
      P().w();
      return;
    } 
    EventTrackYY.c(ChatRoomProtos.Event.CHAT_ROOM_GIFT_POP_SHOW, this.V.room_id, this.V.uid, this.W);
    M();
    YYRoomHttpUtils.a();
  }
  
  private void L() {
    this.ad = LayoutInflater.from(getContext()).inflate(R.layout.view_select_user_to_gift, null);
    RecyclerView recyclerView = (RecyclerView)this.ad.findViewById(R.id.user_list_view);
    LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
    linearLayoutManager.setOrientation(1);
    recyclerView.setLayoutManager((RecyclerView.LayoutManager)linearLayoutManager);
    this.O = new SelectUserAdapter();
    recyclerView.setAdapter((RecyclerView.Adapter)this.O);
    this.O.a(new BaseQuickAdapter.OnItemClickListener(this) {
          public void onItemClick(BaseQuickAdapter param1BaseQuickAdapter, View param1View, int param1Int) {
            YYGiftListFragment.b(this.a).dismiss();
            YYGiftListFragment yYGiftListFragment = this.a;
            YYGiftListFragment.a(yYGiftListFragment, YYGiftListFragment.c(yYGiftListFragment).n().get(param1Int));
            yYGiftListFragment = this.a;
            YYGiftListFragment.b(yYGiftListFragment, YYGiftListFragment.d(yYGiftListFragment));
          }
        });
  }
  
  private void M() {
    R();
    S();
  }
  
  private void N() {
    this.w.setText(String.valueOf(A()));
    if (this.E != null) {
      this.w.setTextColor(Color.parseColor("#ffffff"));
      this.y.setAlpha(1.0F);
      return;
    } 
    this.w.setTextColor(Color.parseColor("#26ffffff"));
    this.y.setAlpha(0.15F);
  }
  
  private void O() {
    if (this.L.goods_number == null || this.L.goods_number.isEmpty()) {
      ShapeHelper.b((ShapeHelper.ShapeView)this.X, R.color.transparent);
      this.x.setVisibility(8);
      if (this.u instanceof com.blued.android.framework.view.shape.ShapeTextView)
        ShapeHelper.a((ShapeHelper.ShapeView)this.u, DensityUtils.a(getContext(), 14.0F)); 
      return;
    } 
    ShapeHelper.b((ShapeHelper.ShapeView)this.X, R.color.syc_00E0AB);
    this.x.setVisibility(0);
    if (this.u instanceof com.blued.android.framework.view.shape.ShapeTextView) {
      ShapeHelper.a((ShapeHelper.ShapeView)this.u, 0.0F, DensityUtils.a(getContext(), 14.0F), 0.0F, DensityUtils.a(getContext(), 14.0F));
      return;
    } 
  }
  
  private BaseYYStudioFragment P() {
    return (BaseYYStudioFragment)getParentFragment();
  }
  
  private void Q() {
    boolean bool;
    String str;
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append("selectedItemIndex: ");
    stringBuilder1.append(this.j);
    LogUtils.c(stringBuilder1.toString());
    if (TextUtils.isEmpty(this.j))
      return; 
    YYGiftModel yYGiftModel = (YYGiftModel)a(this.j);
    if (yYGiftModel == null)
      return; 
    stringBuilder1 = new StringBuilder();
    stringBuilder1.append("selectedModel: ");
    stringBuilder1.append(yYGiftModel.toString());
    LogUtils.c(stringBuilder1.toString());
    if (yYGiftModel.sendGiftStatus == 1)
      return; 
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append("is_combo = ");
    if (yYGiftModel.double_hit == 1) {
      bool = true;
    } else {
      bool = false;
    } 
    stringBuilder2.append(bool);
    stringBuilder2.append(", hit_count = ");
    stringBuilder2.append(yYGiftModel.hit_count);
    stringBuilder2.append(", goods_id = ");
    stringBuilder2.append(yYGiftModel.goods_id);
    stringBuilder2.append(", comboWaitTime = ");
    stringBuilder2.append(yYGiftModel.comboWaitTime);
    stringBuilder2.append(", lastBuyModel.goods_id = ");
    if (this.H != null) {
      str = this.H.goods_id;
    } else {
      str = "null";
    } 
    stringBuilder2.append(str);
    stringBuilder2.append(", hitId = ");
    stringBuilder2.append(this.C);
    LogUtils.c(stringBuilder2.toString());
    if (yYGiftModel.double_hit == 1) {
      if (this.H != null) {
        str = this.H.goods_id;
      } else {
        str = "";
      } 
      if (this.E != null && this.E.count > 1) {
        yYGiftModel.hit_id = 0L;
      } else if (StringUtils.a(str, yYGiftModel.goods_id) && this.C > 0L && yYGiftModel.comboWaitTime > 0) {
        yYGiftModel.hit_id = this.C;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("判定为有效连击 mLastGiftModel.combo_id = ");
        stringBuilder.append(yYGiftModel.hit_id);
        LogUtils.c(stringBuilder.toString());
      } else {
        yYGiftModel.hit_id = System.currentTimeMillis();
        yYGiftModel.hit_count = 0;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("生成一个新的hitId = ");
        stringBuilder.append(yYGiftModel.hit_id);
        LogUtils.c(stringBuilder.toString());
      } 
    } 
    yYGiftModel.sendGiftStatus = 1;
    LiveEventBus.get("gift_item_update").post(yYGiftModel);
    a(ChatRoomProtos.Event.CHAT_ROOM_GIFT_POP_SEND_CLICK, this.L);
    a(yYGiftModel, A(), "", false);
  }
  
  private void R() {
    YYRoomModel yYRoomModel = YYRoomInfoManager.d().b();
    if (yYRoomModel == null)
      return; 
    List list = yYRoomModel.getHasPeopleMics();
    if (list != null) {
      if (list.isEmpty())
        return; 
      this.S = new ArrayList<YYSeatMemberModel>();
      for (YYSeatMemberModel yYSeatMemberModel : list) {
        if (TextUtils.equals(yYSeatMemberModel.getUid(), YYRoomInfoManager.d().e()))
          continue; 
        this.S.add(yYSeatMemberModel);
      } 
      SelectUserAdapter selectUserAdapter = this.O;
      if (selectUserAdapter != null)
        selectUserAdapter.c(this.S); 
    } 
  }
  
  private void S() {
    List<YYSeatMemberModel> list = this.S;
    if (list == null || list.isEmpty()) {
      this.R.setVisibility(0);
      this.N.setVisibility(8);
      this.u.setEnabled(false);
      ShapeHelper.a((ShapeHelper.ShapeView)this.u, R.color.syc_00E0AB, R.color.syc_3883FD);
      this.X.setAlpha(0.5F);
      return;
    } 
    this.ae = this.S.get(0);
    if (!TextUtils.isEmpty(this.ab))
      for (YYSeatMemberModel yYSeatMemberModel : this.S) {
        if (TextUtils.equals(this.ab, yYSeatMemberModel.getUid())) {
          this.ae = yYSeatMemberModel;
          break;
        } 
      }  
    this.R.setVisibility(8);
    this.N.setVisibility(0);
    this.O.notifyDataSetChanged();
    this.u.setEnabled(true);
    ShapeHelper.a((ShapeHelper.ShapeView)this.u, R.color.syc_00E0AB, R.color.syc_3883FD);
    this.X.setAlpha(1.0F);
    a(this.ae);
  }
  
  private void a(YYGiftModel paramYYGiftModel) {
    YYRoomModel yYRoomModel = YYRoomInfoManager.d().b();
    if (yYRoomModel != null)
      EventTrackYY.a(ChatRoomProtos.Event.NO_MONEY_POP_SHOW, yYRoomModel.room_id, yYRoomModel.uid); 
    LiveAlterDialog.a(getContext(), R.layout.dialog_charge_layout, null, new View.OnClickListener(this, yYRoomModel) {
          public void onClick(View param1View) {
            if (this.a != null)
              EventTrackYY.a(ChatRoomProtos.Event.NO_MONEY_POP_RECHARGE_CLICK, this.a.room_id, this.a.uid); 
            YYRoomInfoManager.d().c().c(this.b.getContext());
            YYGiftListFragment.k(this.b).V_();
            YYGiftListFragment.k(this.b).getActivity().finish();
          }
        }true, false);
  }
  
  private void a(YYGiftModel paramYYGiftModel, int paramInt1, int paramInt2, String paramString) {
    Bundle bundle1;
    Bundle bundle2;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("buyGiftFail: ");
    stringBuilder.append(paramYYGiftModel.toString());
    stringBuilder.append(", giftCount:");
    stringBuilder.append(paramInt1);
    stringBuilder.append(", errorCode:");
    stringBuilder.append(paramInt2);
    stringBuilder.append(", errorMessage:");
    stringBuilder.append(paramString);
    LogUtils.c(stringBuilder.toString());
    paramYYGiftModel.sendGiftStatus = 2;
    stringBuilder = new StringBuilder();
    stringBuilder.append("buyGiftFail: ");
    stringBuilder.append(paramInt2);
    stringBuilder.append(", msg: ");
    stringBuilder.append(paramString);
    LogUtils.c(stringBuilder.toString());
    d(paramString);
    switch (paramInt2) {
      default:
        if (!TextUtils.isEmpty(paramString)) {
          AppMethods.a(paramString);
          return;
        } 
        return;
      case 4221004:
      case 4221005:
        bundle2 = new Bundle();
        bundle2.putSerializable("selected_model", (Serializable)paramYYGiftModel);
        bundle2.putInt("gift_count", paramInt1);
        if (paramInt2 == 4221005) {
          bundle2.putString("title", getString(R.string.yy_verify__pay_password));
        } else {
          bundle2.putString("title", paramString);
        } 
        bundle2.putString("content", getString(R.string.yy_verify_6_num));
        YYRouteUtil.a((BaseFragment)this, bundle2, paramInt2);
        return;
      case 4221002:
        bundle1 = new Bundle();
        bundle1.putSerializable("selected_model", (Serializable)paramYYGiftModel);
        bundle1.putInt("gift_count", paramInt1);
        bundle1.putString("title", getString(R.string.yy_reset_pay_password));
        bundle1.putString("content", getString(R.string.yy_set_6_num));
        bundle1.putString("http_host", YYRoomInfoManager.d().c().f());
        YYRouteUtil.a((BaseFragment)this, bundle1, paramInt2);
        return;
      case 4032007:
        break;
    } 
    a(paramYYGiftModel);
  }
  
  private void a(YYGiftModel paramYYGiftModel, int paramInt, String paramString, boolean paramBoolean) {
    String str1;
    if (paramYYGiftModel == null)
      return; 
    if (!z())
      return; 
    BluedUIHttpResponse<BluedEntityA<YYPayGoodsModel>> bluedUIHttpResponse = new BluedUIHttpResponse<BluedEntityA<YYPayGoodsModel>>(this, (IRequestHost)w_(), paramYYGiftModel, paramInt) {
        protected void a(BluedEntityA<YYPayGoodsModel> param1BluedEntityA) {
          if (!YYGiftListFragment.i(this.c))
            return; 
          if (param1BluedEntityA != null && param1BluedEntityA.getSingleData() != null) {
            YYPayGoodsModel yYPayGoodsModel = (YYPayGoodsModel)param1BluedEntityA.getSingleData();
            yYPayGoodsModel.beans = yYPayGoodsModel.users_sums_left;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("buyGift.onUIUpdate: ");
            stringBuilder.append(yYPayGoodsModel.toString());
            Logger.e(stringBuilder.toString(), new Object[0]);
            if (TextUtils.equals(this.a.is_free, "1")) {
              this.a.free_count = yYPayGoodsModel.free_count;
              (YYGiftListFragment.j(this.c)).countdown = 1;
              this.a.hit_count = 1;
              YYRoomInfoManager.d().a(null);
              (YYGiftListFragment.k(this.c)).o.a();
              if (yYPayGoodsModel.free_count > 0) {
                (YYGiftListFragment.k(this.c)).o.b();
              } else {
                YYRoomModel yYRoomModel = YYRoomInfoManager.d().b();
                if (yYRoomModel != null)
                  yYRoomModel.countdown = 0; 
                this.a.setFreeTime("不可送出");
              } 
            } 
            YYGiftListFragment.a(this.c, yYPayGoodsModel, this.a, this.b);
            return;
          } 
          YYGiftListFragment.a(this.c, this.a, this.b, 0, (String)null);
        }
        
        public boolean onUIFailure(int param1Int, String param1String) {
          if (!YYGiftListFragment.l(this.c))
            return false; 
          YYGiftListFragment.a(this.c, this.a, this.b, param1Int, param1String);
          LiveEventBus.get("gift_item_update").post(this.a);
          return true;
        }
      };
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append(paramYYGiftModel.hit_id);
    stringBuilder1.append("");
    String str2 = stringBuilder1.toString();
    String str3 = paramYYGiftModel.goods_id;
    boolean bool = true;
    if (paramInt <= 1)
      bool = false; 
    String str4 = this.V.room_id;
    String str5 = this.ae.getUid();
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append(paramYYGiftModel.beans);
    stringBuilder2.append("");
    String str6 = stringBuilder2.toString();
    if (TextUtils.isEmpty(paramString)) {
      str1 = LiveBasePreferences.a("");
    } else {
      str1 = "";
    } 
    YYRoomHttpUtils.a(str2, str3, paramInt, bool, str4, str5, str6, paramString, str1, paramBoolean, bluedUIHttpResponse, (IRequestHost)w_());
  }
  
  private void a(YYGiftModel paramYYGiftModel, YYPayGoodsModel paramYYPayGoodsModel, int paramInt) {
    paramYYGiftModel.sendGiftStatus = 3;
    paramYYGiftModel.hit_id = paramYYPayGoodsModel.hit_id;
    paramYYGiftModel.beans_count = paramYYPayGoodsModel.beans_count;
    paramYYGiftModel.beans_current_count = paramYYPayGoodsModel.beans_current;
    paramYYGiftModel.free_number = paramYYPayGoodsModel.free_number;
    if (paramYYGiftModel.double_hit == 1)
      paramYYGiftModel.comboWaitTime = this.J; 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("after updateGiftValue: ");
    stringBuilder.append(paramYYGiftModel.toString());
    Logger.e("YYGiftListFragment", new Object[] { stringBuilder.toString() });
  }
  
  private void a(YYPayGoodsModel paramYYPayGoodsModel, YYGiftModel paramYYGiftModel, int paramInt) {
    if (paramYYPayGoodsModel == null)
      return; 
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append("buyGiftSuccess: ");
    stringBuilder2.append(paramYYPayGoodsModel.toString());
    LogUtils.c(stringBuilder2.toString());
    if (!TextUtils.isEmpty(paramYYPayGoodsModel.token))
      LiveBasePreferences.b(paramYYPayGoodsModel.token); 
    a((BasePayRemaining)paramYYPayGoodsModel);
    a(paramYYGiftModel, paramYYPayGoodsModel, paramInt);
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append("buyGiftSuccess after updateGiftValue: ");
    stringBuilder1.append(paramYYGiftModel.toString());
    Logger.e(stringBuilder1.toString(), new Object[0]);
    if (!TextUtils.isEmpty(paramYYGiftModel.contents)) {
      LogUtils.a("弹幕消息，不模拟发消息");
    } else {
      d((CommonLiveGiftModel)paramYYGiftModel, paramInt);
      YYImMsgManager.a().a(paramYYGiftModel, this.ae);
    } 
    this.H = (CommonLiveGiftModel)paramYYGiftModel;
    if (TextUtils.equals(this.ae.getUid(), this.V.uid) && (YYRoomInfoManager.d()).a != null)
      (YYRoomInfoManager.d()).a.isSendGift = true; 
    e((CommonLiveGiftModel)paramYYGiftModel, paramInt);
    LiveEventBus.get("gift_item_update").post(paramYYGiftModel);
    a((CommonLiveGiftModel)paramYYGiftModel);
  }
  
  private void a(YYSeatMemberModel paramYYSeatMemberModel) {
    if (paramYYSeatMemberModel == null)
      return; 
    ImageLoader.a((IRequestHost)w_(), paramYYSeatMemberModel.getAvatar()).a(R.drawable.user_bg_round).a(this.P);
    this.Q.setText(paramYYSeatMemberModel.getName());
  }
  
  private void a(ChatRoomProtos.Event paramEvent, YYGiftModel paramYYGiftModel) {
    if (paramYYGiftModel != null && this.ae != null) {
      YYRoomModel yYRoomModel = this.V;
      if (yYRoomModel == null)
        return; 
      EventTrackYY.a(paramEvent, yYRoomModel.room_id, this.V.uid, this.ae.getUid(), paramYYGiftModel.goods_id, A(), (int)(A() * paramYYGiftModel.beans), this.W, paramYYGiftModel.packageTabIndex, paramYYGiftModel.pageIndex, paramYYGiftModel.positionInPage);
    } 
  }
  
  private void d(String paramString) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("checkSavePayToken: ");
    stringBuilder.append(paramString);
    LogUtils.c(stringBuilder.toString());
    if (TextUtils.isEmpty(paramString))
      return; 
    try {
      BluedEntityA bluedEntityA = (BluedEntityA)AppInfo.f().fromJson(paramString, (new TypeToken<BluedEntityA<YYPayRemaining>>(this) {
          
          }).getType());
      if (bluedEntityA.hasData()) {
        String str = ((YYPayRemaining)bluedEntityA.data.get(0)).token;
        if (!TextUtils.isEmpty(str)) {
          LiveBasePreferences.b(str);
          return;
        } 
      } 
    } catch (JsonSyntaxException jsonSyntaxException) {
      jsonSyntaxException.printStackTrace();
    } 
  }
  
  public void C() {
    P().w();
  }
  
  public int E() {
    return R.drawable.icon_gift_up_img;
  }
  
  public int F() {
    return R.drawable.icon_gift_down_img;
  }
  
  public void G() {
    this.B = new CommonAdapter<LiveGiftNumberModel>(this, R.layout.item_gift_num_layout) {
        public void a(CommonAdapter.ViewHolder param1ViewHolder, LiveGiftNumberModel param1LiveGiftNumberModel, int param1Int) {
          param1ViewHolder.a(R.id.tv_gift_count, String.valueOf(param1LiveGiftNumberModel.count));
          param1ViewHolder.a(R.id.tv_gift_name, param1LiveGiftNumberModel.name);
          param1ViewHolder.a().setOnClickListener(new -$$Lambda$YYGiftListFragment$4$KDCzS2zMWgrcApUp3_elsuTyzZM(this, param1LiveGiftNumberModel));
        }
      };
  }
  
  public void H() {
    super.H();
    N();
  }
  
  public boolean V_() {
    LogUtils.c("");
    if (super.V_())
      return true; 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("YYGiftListFragment: ");
    stringBuilder.append(isHidden());
    LogUtils.c(stringBuilder.toString());
    if (!isHidden()) {
      P().w();
      return true;
    } 
    return false;
  }
  
  public BaseFragment a(CommonGiftPackageModel paramCommonGiftPackageModel, @Nonnull Bundle paramBundle) {
    return (BaseFragment)new YYGiftParentFragment();
  }
  
  public void a(BaseGiftModel paramBaseGiftModel, boolean paramBoolean) {
    super.a(paramBaseGiftModel, paramBoolean);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramBaseGiftModel.index);
    stringBuilder.append(", ");
    stringBuilder.append(paramBoolean);
    LogUtils.c(stringBuilder.toString());
    YYGiftModel yYGiftModel = this.L;
    if (yYGiftModel != null && !StringUtils.a(yYGiftModel.index, paramBaseGiftModel.index)) {
      I();
      yYGiftModel = (YYGiftModel)a(this.L.index);
      if (yYGiftModel != null) {
        yYGiftModel.isSelected = false;
        yYGiftModel.comboWaitTime = 0;
        LiveEventBus.get("gift_item_update").post(yYGiftModel);
      } 
    } 
    this.L = (YYGiftModel)paramBaseGiftModel;
    if (!TypeUtils.a(this.L.goods_number)) {
      this.E = this.L.goods_number.get(0);
    } else {
      this.E = null;
    } 
    N();
    O();
    a(ChatRoomProtos.Event.CHAT_ROOM_GIFT_POP_ONE_GIFT_CLICK, this.L);
  }
  
  public void d(CommonLiveGiftModel paramCommonLiveGiftModel, int paramInt) {
    super.d(paramCommonLiveGiftModel, paramInt);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("giftCount = ");
    stringBuilder.append(paramInt);
    stringBuilder.append(", ");
    stringBuilder.append(paramCommonLiveGiftModel.toString());
    Logger.e(stringBuilder.toString(), new Object[0]);
    if (paramInt > 1) {
      paramCommonLiveGiftModel.hit_batch = 1;
      paramCommonLiveGiftModel.hit_count = paramInt;
    } else {
      paramCommonLiveGiftModel.hit_batch = 0;
      if (paramCommonLiveGiftModel.double_hit == 1)
        paramCommonLiveGiftModel.hit_count++; 
    } 
    this.C = paramCommonLiveGiftModel.hit_id;
    stringBuilder = new StringBuilder();
    stringBuilder.append("after judge, giftCount = ");
    stringBuilder.append(paramInt);
    stringBuilder.append(", ");
    stringBuilder.append(paramCommonLiveGiftModel.toString());
    Logger.e("YYGiftListFragment", new Object[] { stringBuilder.toString() });
  }
  
  public int k() {
    return R.layout.view_yy_gift_list_layout;
  }
  
  public void n() {
    super.n();
    this.v = this.d.findViewById(R.id.live_gift_blank_view);
    this.s = (TextView)this.d.findViewById(R.id.tv_price);
    this.t = (TextView)this.d.findViewById(R.id.tv_recharge);
    this.u = (TextView)this.d.findViewById(R.id.ll_send);
    this.w = (TextView)this.d.findViewById(R.id.tv_select_num);
    this.x = (LinearLayout)this.d.findViewById(R.id.ll_gift_count);
    this.y = (ImageView)this.d.findViewById(R.id.iv_select_num);
    this.z = this.d.findViewById(R.id.yy_gift_number_select_layout);
    this.A = (ListView)this.d.findViewById(R.id.yy_gift_number_select_list);
    this.M = (LinearLayout)this.d.findViewById(R.id.ll_tab_layout);
    this.M.setVisibility(8);
    this.N = (LinearLayout)this.d.findViewById(R.id.ll_give_gift);
    this.P = (ImageView)this.d.findViewById(R.id.iv_user_img);
    this.Q = (TextView)this.d.findViewById(R.id.tv_user_name);
    this.R = (TextView)this.d.findViewById(R.id.tv_no_give);
    this.X = (ShapeLinearLayout)this.d.findViewById(R.id.shape_send);
    this.Z = (ImageView)this.d.findViewById(R.id.gift_target_arrow);
    this.N.setOnClickListener((View.OnClickListener)this);
    this.z.setOnClickListener((View.OnClickListener)this);
    this.T = DensityUtils.a(getContext(), 33.0F);
    this.U = DensityUtils.a(getContext(), 15.0F);
    L();
    K();
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt2 == -1)
      if ((paramInt1 == 4221005 || paramInt1 == 4221004) && paramIntent != null) {
        YYGiftModel yYGiftModel = (YYGiftModel)paramIntent.getSerializableExtra("selected_model");
        String str = paramIntent.getStringExtra("password");
        boolean bool = paramIntent.getBooleanExtra("remember_me", false);
        paramInt1 = paramIntent.getIntExtra("gift_count", 1);
        if (!TextUtils.isEmpty(str) && yYGiftModel != null) {
          a(yYGiftModel, paramInt1, str, bool);
          return;
        } 
      } else if (paramInt1 == 4221002 && paramIntent != null) {
        YYGiftModel yYGiftModel = (YYGiftModel)paramIntent.getSerializableExtra("selected_model");
        paramInt1 = paramIntent.getIntExtra("gift_count", 1);
        boolean bool = paramIntent.getBooleanExtra("remember_me", false);
        a(yYGiftModel, paramInt1, paramIntent.getStringExtra("password"), bool);
      }  
  }
  
  public void onClick(View paramView) {
    ArrayList<LiveGiftNumberModel> arrayList;
    if (paramView.getId() == R.id.ll_gift_count) {
      YYGiftModel yYGiftModel = this.L;
      if (yYGiftModel != null && !TypeUtils.a(yYGiftModel.goods_number)) {
        int i = A();
        arrayList = new ArrayList();
        for (LiveGiftNumberModel liveGiftNumberModel : this.L.goods_number) {
          if (liveGiftNumberModel.count == i) {
            liveGiftNumberModel.selected = true;
          } else {
            liveGiftNumberModel.selected = false;
          } 
          arrayList.add(liveGiftNumberModel);
        } 
        c(arrayList);
        return;
      } 
    } else {
      YYRoomModel yYRoomModel;
      List<YYSeatMemberModel> list;
      if (arrayList.getId() == R.id.ll_send) {
        YYGiftModel yYGiftModel = this.L;
        if (yYGiftModel == null)
          return; 
        if (this.ae == null)
          return; 
        if (!TextUtils.equals(yYGiftModel.is_free, "1")) {
          Q();
          return;
        } 
        if (this.L.free_count <= 0) {
          ToastUtils.a("礼物次数已用完", 0);
          return;
        } 
        yYRoomModel = YYRoomInfoManager.d().b();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("roomModel.countdown: ");
        stringBuilder.append(yYRoomModel.countdown);
        Logger.e("timer", new Object[] { stringBuilder.toString() });
        if (yYRoomModel != null && yYRoomModel.isTimerFinished()) {
          Q();
          return;
        } 
        ToastUtils.a("请耐心等待，礼物还未生成", 0);
        return;
      } 
      if (yYRoomModel.getId() == R.id.ll_give_gift) {
        list = this.S;
        if (list != null) {
          int i;
          if (list.isEmpty())
            return; 
          if (this.S.size() > 4) {
            i = (int)(this.T * 4.5D);
          } else {
            i = this.T * this.S.size();
          } 
          int j = this.U;
          this.ac = (new PopupwindowFactory.Builder(getContext())).a(this.ad).c(i + j).b(DensityUtils.a(getContext(), 147.0F)).d(R.color.syc_dark_b).a(new IPopShowAndDismissListener(this) {
                public void a() {
                  YYGiftListFragment.h(this.a).setImageResource(R.drawable.icon_gift_down_img);
                }
                
                public void b() {
                  YYGiftListFragment.h(this.a).setImageResource(R.drawable.icon_gift_up_img);
                }
              }).a((View)this.Q, 0, 0);
          return;
        } 
        return;
      } 
      if (list.getId() == R.id.tv_recharge) {
        YYRoomModel yYRoomModel1 = YYRoomInfoManager.d().b();
        if (yYRoomModel1 != null)
          EventTrackYY.a(ChatRoomProtos.Event.CHAT_ROOM_RECHARGE_CLICK, yYRoomModel1.room_id, yYRoomModel1.uid); 
        YYRoomInfoManager.d().c().c(getContext());
      } 
    } 
  }
  
  public void onDestroy() {
    super.onDestroy();
    AlertDialog alertDialog = this.Y;
    if (alertDialog != null)
      alertDialog.cancel(); 
    HashSet<String> hashSet = this.aa;
    if (hashSet != null)
      hashSet.clear(); 
  }
  
  public void onHiddenChanged(boolean paramBoolean) {
    super.onHiddenChanged(paramBoolean);
    if (!paramBoolean) {
      this.H = null;
      K();
      y();
      LiveEventBus.get("gift_item_selected").post(t());
      this.h.setToolBtnSelect(0);
      this.n.setCurrentItem(0, false);
      LiveEventBus.get("gift_package_selected").post("0");
      return;
    } 
    BaseGiftModel baseGiftModel = a(this.j);
    if (baseGiftModel != null) {
      baseGiftModel.isSelected = false;
      LiveEventBus.get("gift_item_update").post(baseGiftModel);
    } 
    this.j = null;
    this.E = null;
    this.L = null;
    HashSet<String> hashSet = this.aa;
    if (hashSet != null)
      hashSet.clear(); 
  }
  
  public void p() {
    super.p();
    LiveEventBus.get("show_gift_item", YYGiftModel.class).observe((LifecycleOwner)this, new Observer<YYGiftModel>(this) {
          public void a(YYGiftModel param1YYGiftModel) {
            if (YYGiftListFragment.a(this.a) == null)
              YYGiftListFragment.a(this.a, new HashSet()); 
            if (YYGiftListFragment.a(this.a).contains(param1YYGiftModel.goods_id))
              return; 
            YYGiftListFragment.a(this.a).add(param1YYGiftModel.goods_id);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("event=");
            stringBuilder.append(param1YYGiftModel.index);
            LogUtils.c(stringBuilder.toString());
            YYGiftListFragment.a(this.a, ChatRoomProtos.Event.CHAT_ROOM_GIFT_POP_ONE_GIFT_SHOW, param1YYGiftModel);
          }
        });
  }
  
  public String x() {
    return "yy_gift";
  }
  
  public void y() {
    YYRoomHttpUtils.c(new BluedUIHttpResponse<BluedEntityA<YYGiftModel>>(this, (IRequestHost)w_()) {
          public void a(BluedEntityA<YYGiftModel> param1BluedEntityA) {
            if (param1BluedEntityA == null || param1BluedEntityA.data == null || param1BluedEntityA.data.isEmpty()) {
              Logger.e("YYGiftListFragment", new Object[] { "从网络获取礼物列表失败 无数据" });
              return;
            } 
            Logger.e("YYGiftListFragment", new Object[] { "更新网络礼物列表" });
            ArrayList<YYGiftPackageModel> arrayList1 = new ArrayList();
            ArrayList<YYGiftPackageModel> arrayList2 = new ArrayList();
            YYGiftPackageModel yYGiftPackageModel = new YYGiftPackageModel();
            yYGiftPackageModel.name = "normal_goods";
            yYGiftPackageModel.goods.addAll(param1BluedEntityA.data);
            arrayList1.add(yYGiftPackageModel);
            arrayList2.add(yYGiftPackageModel);
            for (int i = 0; i < arrayList1.size(); i++) {
              for (int j = 0; j < yYGiftPackageModel.goods.size(); j++) {
                YYGiftModel yYGiftModel = yYGiftPackageModel.goods.get(j);
                yYGiftModel.pic = yYGiftModel.images_static;
                yYGiftModel.pic_apng = yYGiftModel.images_apng2;
                yYGiftModel.pic_dynamic = yYGiftModel.images_gif;
                yYGiftModel.sendGiftStatus = 0;
                LogUtils.c(yYGiftModel.toString());
              } 
            } 
            YYGiftManager.a().a(arrayList2);
            YYGiftListFragment.a(this.a, arrayList1);
            this.a.n.requestLayout();
            this.a.n.setOffscreenPageLimit(YYGiftListFragment.e(this.a).size());
            Logger.e("yy_gift", new Object[] { "setOffscreenPageLimit ... " });
          }
        }(IRequestHost)w_());
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\blued\android\module\yy_china\fragment\YYGiftListFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */