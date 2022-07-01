package com.soft.blued.ui.user.fragment;

import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import com.blued.android.core.imagecache.LoadOptions;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.core.utils.skin.BluedSkinUtils;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.utils.DelayRepeatTaskUtils;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.das.vip.VipProtos;
import com.soft.blued.customview.LinePageIndicator;
import com.soft.blued.customview.ShowAllListView;
import com.soft.blued.http.PayHttpUtils;
import com.soft.blued.log.trackUtils.EventTrackVIP;
import com.soft.blued.ui.pay.CouponFragment;
import com.soft.blued.ui.pay.model.BluedCoupon;
import com.soft.blued.ui.user.adapter.VIPAgreementAdapter;
import com.soft.blued.ui.user.adapter.VIPBuyAdapter;
import com.soft.blued.ui.user.adapter.VIPItemRoundAdapter;
import com.soft.blued.ui.user.model.GoodsOptionBasic;
import com.soft.blued.ui.user.model.VIPBuyOption;
import com.soft.blued.ui.user.model.VIPBuyOptionForJsonParse;
import com.soft.blued.ui.user.model.VIPPrivilegeModel;
import com.soft.blued.ui.user.observer.VIPBuyOnBackPressedObserver;
import com.soft.blued.ui.user.views.VIPPrivilegePageView;
import com.soft.blued.utils.BluedPreferences;
import com.soft.blued.utils.StringUtils;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class VIPBuyOptionListFragment extends BaseFragment {
  private VIPPrivilegePageView A;
  
  private LinePageIndicator B;
  
  private ImageView C;
  
  private ImageView D;
  
  private ImageView E;
  
  private ImageView F;
  
  private View G;
  
  private TextView H;
  
  private TextView I;
  
  private TextView J;
  
  private TextView K;
  
  private int L;
  
  private View M;
  
  private RecyclerView N;
  
  private VIPItemRoundAdapter O;
  
  private boolean P;
  
  private BluedUIHttpResponse Q = new BluedUIHttpResponse<BluedEntityA<VIPBuyOptionForJsonParse>>(this, (IRequestHost)w_()) {
      protected void a(BluedEntityA<VIPBuyOptionForJsonParse> param1BluedEntityA) {
        if (param1BluedEntityA != null && param1BluedEntityA.data != null && param1BluedEntityA.data.size() > 0 && param1BluedEntityA.data.get(0) != null) {
          List list;
          if (VIPBuyOptionListFragment.a(this.a) == 1) {
            if (((VIPBuyOptionForJsonParse)param1BluedEntityA.data.get(0)).vip_list != null) {
              list = ((VIPBuyOptionForJsonParse)param1BluedEntityA.data.get(0)).vip_list.privilege_list;
              if (list != null && list.size() > 0) {
                VIPBuyOptionListFragment.b(this.a).setVisibility(0);
                VIPBuyOptionListFragment.c(this.a).a((IRequestHost)this.a.w_(), list);
                return;
              } 
              VIPBuyOptionListFragment.b(this.a).setVisibility(8);
              return;
            } 
          } else if (((VIPBuyOptionForJsonParse)((BluedEntityA)list).data.get(0)).svip_list != null) {
            list = ((VIPBuyOptionForJsonParse)((BluedEntityA)list).data.get(0)).svip_list.privilege_list;
            if (list != null && list.size() > 0) {
              VIPBuyOptionListFragment.b(this.a).setVisibility(0);
              VIPBuyOptionListFragment.c(this.a).a((IRequestHost)this.a.w_(), list);
              return;
            } 
            VIPBuyOptionListFragment.b(this.a).setVisibility(8);
          } 
        } 
      }
    };
  
  public Context d;
  
  public View e;
  
  public ListView f;
  
  public VIPBuyAdapter g;
  
  public BluedUIHttpResponse h;
  
  private TextView i;
  
  private int j = 2;
  
  private String k;
  
  private String l;
  
  private TextView m;
  
  private LoadOptions n;
  
  private ShowAllListView o;
  
  private VIPAgreementAdapter p;
  
  private String q;
  
  private VipProtos.FromType r;
  
  private BluedCoupon s;
  
  private int t = 1;
  
  private View u;
  
  private View v;
  
  private boolean w = false;
  
  private View x;
  
  private View y;
  
  private View z;
  
  public VIPBuyOptionListFragment() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(VIPBuyOptionListFragment.class.getName());
    stringBuilder.append(this.j);
    this.h = new BluedUIHttpResponse<BluedEntityA<VIPBuyOptionForJsonParse>>(this, stringBuilder.toString(), (IRequestHost)w_()) {
        protected void a(BluedEntityA<VIPBuyOptionForJsonParse> param1BluedEntityA) {
          super.onUICache((BluedEntity)param1BluedEntityA);
          this.a.a(param1BluedEntityA);
        }
        
        protected void b(BluedEntityA<VIPBuyOptionForJsonParse> param1BluedEntityA) {
          this.a.a(param1BluedEntityA);
        }
        
        public void onUIFinish() {
          super.onUIFinish();
        }
        
        public void onUIStart() {
          super.onUIStart();
        }
      };
  }
  
  private void a(int paramInt) {
    PayHttpUtils.a(new BluedUIHttpResponse<BluedEntityA<BluedCoupon>>(this, (IRequestHost)w_()) {
          protected void a(BluedEntityA<BluedCoupon> param1BluedEntityA) {
            if (param1BluedEntityA != null && param1BluedEntityA.data != null && param1BluedEntityA.data.size() != 0 && param1BluedEntityA.data.get(0) != null) {
              VIPBuyOptionListFragment.a(this.a, param1BluedEntityA.data.get(0));
            } else {
              VIPBuyOptionListFragment.a(this.a, (BluedCoupon)null);
            } 
            this.a.k();
          }
          
          public void onUIFinish(boolean param1Boolean) {
            super.onUIFinish(param1Boolean);
            if (!param1Boolean) {
              VIPBuyOptionListFragment.a(this.a, (BluedCoupon)null);
              this.a.k();
            } 
          }
        }1, 20, paramInt, (IRequestHost)w_());
  }
  
  private void l() {
    this.x = this.e.findViewById(2131299517);
    this.y = this.e.findViewById(2131299515);
    this.C = (ImageView)this.e.findViewById(2131299514);
    this.z = this.e.findViewById(2131299520);
    this.D = (ImageView)this.e.findViewById(2131299519);
    this.A = (VIPPrivilegePageView)this.e.findViewById(2131299523);
    this.B = (LinePageIndicator)this.e.findViewById(2131299522);
    this.E = (ImageView)this.e.findViewById(2131297393);
    this.F = (ImageView)this.e.findViewById(2131297402);
    this.G = this.e.findViewById(2131299518);
    this.H = (TextView)this.e.findViewById(2131299516);
    this.I = (TextView)this.e.findViewById(2131299521);
    if (this.j == 2) {
      this.C.setImageResource(2131232731);
      this.D.setImageResource(2131232731);
      this.H.setText(2131758977);
      this.I.setText(2131758977);
    } else {
      this.C.setImageResource(2131232812);
      this.D.setImageResource(2131232812);
      this.H.setText(2131759290);
      this.I.setText(2131759290);
    } 
    if (BluedPreferences.cZ()) {
      this.E.setImageResource(2131232377);
      this.F.setImageResource(2131232383);
      this.B.setSelectedColor(Color.parseColor("#FFFFFF"));
      this.B.setUnselectedColor(Color.parseColor("#4CFFFFFF"));
    } 
    ArrayList<VIPPrivilegeModel> arrayList = new ArrayList();
    for (int i = 0; i < 20; i++) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("测试");
      stringBuilder.append(i);
      arrayList.add(new VIPPrivilegeModel(stringBuilder.toString(), "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1587463364879&di=0537824a516a799c84013d41576a9020&imgtype=0&src=http%3A%2F%2Fb-ssl.duitang.com%2Fuploads%2Fitem%2F201701%2F30%2F20170130181206_x8ScK.thumb.700_0.jpeg"));
    } 
    this.A.setInterval(4000L);
    this.A.setIViewListener(new -$$Lambda$VIPBuyOptionListFragment$Ok-iLPbsgNlc48B_L7fVuF4eQUQ(this));
    this.y.setOnClickListener(new -$$Lambda$VIPBuyOptionListFragment$wSkPn9fHLKaqOIylmQt55Um3pN0(this));
    this.z.setOnClickListener(new -$$Lambda$VIPBuyOptionListFragment$I1SVdgU_MYuxR4iK6O93hXlb0R4(this));
  }
  
  public boolean V_() {
    Log.v("drb", "child onBackPressed");
    VIPBuyOnBackPressedObserver.a().b();
    return true;
  }
  
  public void a() {
    this.M = this.e.findViewById(2131300585);
    this.v = this.e.findViewById(2131301636);
    if (BluedPreferences.cN()) {
      this.v.setVisibility(8);
    } else {
      this.v.setVisibility(0);
    } 
    this.N = (RecyclerView)this.e.findViewById(2131298143);
    LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.d);
    linearLayoutManager.setOrientation(0);
    this.N.setLayoutManager((RecyclerView.LayoutManager)linearLayoutManager);
    this.J = (TextView)this.e.findViewById(2131301296);
    this.K = (TextView)this.e.findViewById(2131300966);
    this.O = new VIPItemRoundAdapter(this.d, this.j);
    this.O.a(new -$$Lambda$VIPBuyOptionListFragment$1HVv2zon849Xwp-YqzHGCjuihrk(this));
    this.N.setAdapter((RecyclerView.Adapter)this.O);
    this.o = (ShowAllListView)this.e.findViewById(2131298145);
    this.o.setBackgroundColor(BluedSkinUtils.a(this.d, 2131100881));
    this.i = (TextView)this.e.findViewById(2131300704);
    this.f = (ListView)this.e.findViewById(2131298144);
    this.m = (TextView)this.e.findViewById(2131300598);
    this.m.setOnClickListener(new -$$Lambda$VIPBuyOptionListFragment$7gfpTb30PQqj_7HnWGrcHv_O0d4(this));
    this.g = new VIPBuyAdapter(this.d, this.j);
    this.g.a(new -$$Lambda$VIPBuyOptionListFragment$FGVM1lj_cVLqZUhVQPgOHQRaMZk(this));
    this.f.setAdapter((ListAdapter)this.g);
    String str = this.d.getResources().getString(2131759252);
    if (this.j == 2) {
      String str1 = this.d.getResources().getString(2131759313);
      TextView textView = this.i;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(str1);
      stringBuilder.append(str);
      textView.setText(stringBuilder.toString());
      this.m.setBackground(this.d.getResources().getDrawable(2131231096));
      this.m.setTextColor(this.d.getResources().getColor(2131100728));
    } else {
      this.i.setText(str);
      this.m.setBackground(this.d.getResources().getDrawable(2131234090));
      this.m.setTextColor(this.d.getResources().getColor(2131100838));
    } 
    this.h.refresh();
    PayHttpUtils.a(this.h, (IRequestHost)w_(), "vip");
    PayHttpUtils.a(this.Q, this.L);
  }
  
  public void a(BluedEntityA<VIPBuyOptionForJsonParse> paramBluedEntityA) {
    if (paramBluedEntityA != null && paramBluedEntityA.data != null && paramBluedEntityA.data.size() > 0 && paramBluedEntityA.data.get(0) != null) {
      VIPBuyOption vIPBuyOption;
      if (this.j == 1) {
        if (((VIPBuyOptionForJsonParse)paramBluedEntityA.data.get(0)).vip_list != null && ((VIPBuyOptionForJsonParse)paramBluedEntityA.data.get(0)).vip_list.list.size() > 0 && ((VIPBuyOptionForJsonParse)paramBluedEntityA.data.get(0)).vip_list.list.get(0) != null) {
          vIPBuyOption = ((VIPBuyOptionForJsonParse)paramBluedEntityA.data.get(0)).vip_list.list.get(0);
          if (((VIPBuyOptionForJsonParse)paramBluedEntityA.data.get(0)).is_show_hori_items == 1) {
            this.M.setVisibility(8);
            this.O.a(((VIPBuyOptionForJsonParse)paramBluedEntityA.data.get(0)).vip_list.list);
            this.N.setVisibility(0);
            this.f.setVisibility(8);
            this.J.setVisibility(0);
            this.K.setVisibility(8);
            this.O.a(0);
          } else {
            this.M.setVisibility(0);
            this.g.a(((VIPBuyOptionForJsonParse)paramBluedEntityA.data.get(0)).vip_list.list);
            this.g.a(0);
            this.N.setVisibility(8);
            this.f.setVisibility(0);
            this.J.setVisibility(8);
          } 
        } 
      } else if (((VIPBuyOptionForJsonParse)paramBluedEntityA.data.get(0)).svip_list != null && ((VIPBuyOptionForJsonParse)paramBluedEntityA.data.get(0)).svip_list.list.size() > 0 && ((VIPBuyOptionForJsonParse)paramBluedEntityA.data.get(0)).svip_list.list.get(0) != null) {
        vIPBuyOption = ((VIPBuyOptionForJsonParse)paramBluedEntityA.data.get(0)).svip_list.list.get(0);
        if (((VIPBuyOptionForJsonParse)paramBluedEntityA.data.get(0)).is_show_hori_items == 1) {
          this.O.a(((VIPBuyOptionForJsonParse)paramBluedEntityA.data.get(0)).svip_list.list);
          this.N.setVisibility(0);
          this.f.setVisibility(8);
          this.J.setVisibility(0);
          this.K.setVisibility(8);
          this.O.a(0);
        } else {
          this.g.a(((VIPBuyOptionForJsonParse)paramBluedEntityA.data.get(0)).svip_list.list);
          this.g.a(0);
          this.N.setVisibility(8);
          this.f.setVisibility(0);
          this.J.setVisibility(8);
        } 
        this.s = ((VIPBuyOptionForJsonParse)paramBluedEntityA.data.get(0)).svip_list.default_coupon;
      } 
      if (this.N.getVisibility() == 0) {
        vIPBuyOption = this.O.a();
      } else {
        vIPBuyOption = this.g.a();
      } 
      a(vIPBuyOption, true);
      if (((VIPBuyOptionForJsonParse)paramBluedEntityA.data.get(0)).rule_list != null && ((VIPBuyOptionForJsonParse)paramBluedEntityA.data.get(0)).rule_list.size() > 0) {
        this.o.setVisibility(0);
        this.p = new VIPAgreementAdapter(this.d, ((VIPBuyOptionForJsonParse)paramBluedEntityA.data.get(0)).rule_list);
        this.o.setAdapter((ListAdapter)this.p);
        this.p.notifyDataSetChanged();
      } else {
        this.o.setVisibility(8);
      } 
      if (((VIPBuyOptionForJsonParse)paramBluedEntityA.data.get(0)).explain_list != null) {
        if (this.j == 2) {
          this.i.setText(((VIPBuyOptionForJsonParse)paramBluedEntityA.data.get(0)).explain_list.svip);
          return;
        } 
        this.i.setText(((VIPBuyOptionForJsonParse)paramBluedEntityA.data.get(0)).explain_list.vip);
      } 
    } 
  }
  
  public void a(VIPBuyOption paramVIPBuyOption, boolean paramBoolean) {
    if (paramVIPBuyOption != null) {
      if (!this.w)
        return; 
      if (paramBoolean) {
        a(paramVIPBuyOption.id);
        return;
      } 
      DelayRepeatTaskUtils.a("getCouponData", new -$$Lambda$VIPBuyOptionListFragment$Vau4rdO2X7E9BnNV5TyBSibsfQ0(this, paramVIPBuyOption), 500);
    } 
  }
  
  public void k() {
    VIPBuyOption vIPBuyOption;
    if (this.N.getVisibility() == 0) {
      vIPBuyOption = this.O.a();
    } else {
      vIPBuyOption = this.g.a();
    } 
    this.u = this.e.findViewById(2131301635);
    if (this.w) {
      String str;
      this.u.setVisibility(0);
      TextView textView = (TextView)this.e.findViewById(2131300710);
      this.u.setOnClickListener(new -$$Lambda$VIPBuyOptionListFragment$ALFNMzA3pLCvMReJFZXJ2bEbv1Q(this, vIPBuyOption));
      this.u.setVisibility(0);
      if (vIPBuyOption == null)
        return; 
      BluedCoupon bluedCoupon = this.s;
      if (bluedCoupon != null && bluedCoupon.is_available == 1) {
        DecimalFormat decimalFormat = new DecimalFormat("###.##");
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append("-￥");
        stringBuilder1.append(decimalFormat.format(this.s.money));
        String str1 = stringBuilder1.toString();
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append(decimalFormat.format(vIPBuyOption.money - this.s.money));
        stringBuilder2.append("");
        str = stringBuilder2.toString();
        textView.setText(str1);
        this.m.setText(String.format(this.d.getResources().getString(2131757927), new Object[] { str }));
        return;
      } 
      this.s = null;
      int i = this.t;
      if (i == -1 || i == 0) {
        textView.setText("");
      } else {
        textView.setText(this.d.getResources().getString(2131758224));
      } 
      if (str != null && ((VIPBuyOption)str).item != null && !StringUtils.e(((VIPBuyOption)str).item.button))
        this.m.setText(((VIPBuyOption)str).item.button); 
      return;
    } 
    this.u.setVisibility(8);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt1 == 101 && paramIntent != null) {
      BluedCoupon bluedCoupon = (BluedCoupon)paramIntent.getSerializableExtra(CouponFragment.e);
      if (paramInt2 != -1) {
        if (paramInt2 != 0)
          return; 
        this.t = 0;
        if (bluedCoupon == null || (this.s != null && bluedCoupon.id != this.s.id)) {
          this.s = null;
          k();
          return;
        } 
      } else {
        this.t = -1;
        this.s = bluedCoupon;
        k();
      } 
    } 
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
    VipProtos.Name name;
    this.d = (Context)getActivity();
    View view = this.e;
    byte b = 0;
    if (view == null) {
      this.e = paramLayoutInflater.inflate(2131493357, paramViewGroup, false);
      this.n = new LoadOptions();
      LoadOptions loadOptions = this.n;
      loadOptions.d = 2131234356;
      loadOptions.b = 2131234356;
      Bundle bundle = getArguments();
      if (bundle != null) {
        this.j = bundle.getInt("KEY_VIP_GRADE");
        this.L = bundle.getInt("KEY_RIGHT_ID");
        this.k = getArguments().getString("KEY_TARGET_UID");
        this.l = getArguments().getString("KEY_ACTIVITY_ID");
        this.q = getArguments().getString("KEY_VIP_DETAIL", "");
        this.w = getArguments().getBoolean("KEY_IF_SHOW_COUPON");
        this.r = (VipProtos.FromType)getArguments().getSerializable("KEY_VIP_FROM_TYPE");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("vipRightID:");
        stringBuilder.append(this.L);
        stringBuilder.append(" -- mVIPGrade");
        stringBuilder.append(this.j);
        Log.v("drb", stringBuilder.toString());
      } 
      a();
      l();
    } else if (view.getParent() != null) {
      ((ViewGroup)this.e.getParent()).removeView(this.e);
    } 
    String str = this.q;
    switch (str.hashCode()) {
      default:
        b = -1;
        break;
      case 2060763653:
        if (str.equals("vip_center_dynamic_skin")) {
          b = 7;
          break;
        } 
      case 1646624146:
        if (str.equals("vip_center_msg_bubble")) {
          b = 6;
          break;
        } 
      case 1379669829:
        if (str.equals("chat_msg_bubble_owner")) {
          b = 4;
          break;
        } 
      case 1372213866:
        if (str.equals("chat_msg_bubble_guest")) {
          b = 3;
          break;
        } 
      case 674522729:
        if (str.equals("feed_dynamic_skin_setting_main")) {
          b = 9;
          break;
        } 
      case 581471613:
        if (str.equals("dynamic_skin")) {
          b = 8;
          break;
        } 
      case 166111522:
        if (str.equals("chat_setting_bubble")) {
          b = 5;
          break;
        } 
      case -352175194:
        if (str.equals("nearby_visit_bottom_buy")) {
          b = 2;
          break;
        } 
      case -696807456:
        if (str.equals("nearby_visit_history"))
          break; 
      case -1428864377:
        if (str.equals("nearby_visit_fifteen_trend")) {
          b = 1;
          break;
        } 
      case -1727955815:
        if (str.equals("feed_dynamic_skin_look_guest")) {
          b = 10;
          break;
        } 
    } 
    switch (b) {
      case 7:
      case 8:
      case 9:
      case 10:
        this.r = VipProtos.FromType.FEED_DYNAMIC_SKIN;
        break;
      case 3:
      case 4:
      case 5:
      case 6:
        this.r = VipProtos.FromType.MSG_BUBBLE;
        break;
      case 2:
        this.r = VipProtos.FromType.VISIT_NONE;
        break;
      case 1:
        this.r = VipProtos.FromType.FIFTEEN_VISIT_TREND;
        break;
      case 0:
        this.r = VipProtos.FromType.HISTORY;
        break;
    } 
    VipProtos.Event event = VipProtos.Event.VIP_BUY_SHOW;
    if (this.j == 2) {
      name = VipProtos.Name.SVIP;
    } else {
      name = VipProtos.Name.VIP;
    } 
    EventTrackVIP.a(event, name, this.r, VipProtos.PageVersion.V_0730);
    return this.e;
  }
  
  public void onDestroy() {
    super.onDestroy();
  }
  
  public void setUserVisibleHint(boolean paramBoolean) {
    super.setUserVisibleHint(paramBoolean);
    if (paramBoolean && this.v != null)
      if (BluedPreferences.cN()) {
        this.v.setVisibility(8);
      } else {
        this.v.setVisibility(0);
      }  
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("isVisibleToUser:");
    stringBuilder.append(paramBoolean);
    stringBuilder.append(" -- mVIPGrade:");
    stringBuilder.append(this.j);
    Log.v("drb", stringBuilder.toString());
    if (paramBoolean && !this.P) {
      if (this.j == 2) {
        EventTrackVIP.a(VipProtos.Event.VIP_BUY_PAGE_MORE_BTN_SHOW, 2);
        Log.v("drb", "SVIP");
      } else {
        EventTrackVIP.a(VipProtos.Event.VIP_BUY_PAGE_MORE_BTN_SHOW, 1);
        Log.v("drb", "VIP");
      } 
      this.P = true;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\u\\user\fragment\VIPBuyOptionListFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */