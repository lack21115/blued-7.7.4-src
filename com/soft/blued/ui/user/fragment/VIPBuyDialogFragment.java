package com.soft.blued.ui.user.fragment;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.core.ui.StatusBarHelper;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.common.utils.DialogUtils;
import com.blued.das.vip.VipProtos;
import com.soft.blued.customview.AutoScrollViewPager;
import com.soft.blued.customview.CirclePageIndicator;
import com.soft.blued.http.H5Url;
import com.soft.blued.http.PayHttpUtils;
import com.soft.blued.log.trackUtils.EventTrackVIP;
import com.soft.blued.ui.user.model.GoodsOptionBasic;
import com.soft.blued.ui.user.model.VIPBuyOption;
import com.soft.blued.ui.user.model.VIPBuyOptionForJsonParse;
import com.soft.blued.ui.user.model.VIPRightDescForSelling;
import com.soft.blued.ui.user.observer.VIPBuyResultObserver;
import com.soft.blued.ui.user.presenter.PayUtils;
import com.soft.blued.ui.user.views.VIPDiaglogBuyOptionView;
import com.soft.blued.ui.web.WebViewShowInfoFragment;
import com.soft.blued.utils.ActivityChangeAnimationUtils;
import com.soft.blued.utils.StringUtils;
import com.soft.blued.utils.TypefaceUtils;
import java.util.ArrayList;
import java.util.List;

public class VIPBuyDialogFragment extends BaseFragment implements View.OnClickListener, VIPBuyResultObserver.IVIPBuyResultObserver {
  public Context d;
  
  public View e;
  
  public LayoutInflater f;
  
  private Dialog g;
  
  private int h = 1;
  
  private String i;
  
  private int j;
  
  private AutoScrollViewPager k;
  
  private ImageView l;
  
  private TextView m;
  
  private ImageView n;
  
  private CirclePageIndicator o;
  
  private TextView p;
  
  private LinearLayout q;
  
  private ShapeTextView r;
  
  private TextView s;
  
  private List<VIPDiaglogBuyOptionView> t = new ArrayList<VIPDiaglogBuyOptionView>();
  
  private List<VIPBuyOption> u = new ArrayList<VIPBuyOption>();
  
  private VIPBuyOption v;
  
  private MyPagerAdapter w;
  
  private VipProtos.FromType x;
  
  private List<View> y = new ArrayList<View>();
  
  private BluedUIHttpResponse z = new BluedUIHttpResponse<BluedEntityA<VIPBuyOptionForJsonParse>>(this, "vip_dialog_goods", (IRequestHost)w_()) {
      protected void a(BluedEntityA<VIPBuyOptionForJsonParse> param1BluedEntityA) {
        int i = 0;
        if (param1BluedEntityA != null && param1BluedEntityA.data != null && param1BluedEntityA.data.size() > 0 && param1BluedEntityA.data.get(0) != null) {
          if (VIPBuyDialogFragment.a(this.a) == 1) {
            if (((VIPBuyOptionForJsonParse)param1BluedEntityA.data.get(0)).vip_list != null) {
              VIPBuyDialogFragment.a(this.a, ((VIPBuyOptionForJsonParse)param1BluedEntityA.data.get(0)).vip_list.list);
              this.a.a(((VIPBuyOptionForJsonParse)param1BluedEntityA.data.get(0)).vip_list.privilege);
            } 
          } else if (((VIPBuyOptionForJsonParse)param1BluedEntityA.data.get(0)).svip_list != null) {
            VIPBuyDialogFragment.a(this.a, ((VIPBuyOptionForJsonParse)param1BluedEntityA.data.get(0)).svip_list.list);
            this.a.a(((VIPBuyOptionForJsonParse)param1BluedEntityA.data.get(0)).svip_list.privilege);
          } 
          VIPBuyDialogFragment.b(this.a).f();
        } 
        this.a.a(0);
        while (i < VIPBuyDialogFragment.c(this.a).size()) {
          if (((VIPBuyOption)VIPBuyDialogFragment.c(this.a).get(i)).is_hot == 1) {
            this.a.a(i);
            return;
          } 
          i++;
        } 
      }
    };
  
  public void a() {
    PayHttpUtils.a(this.z, (IRequestHost)w_(), "new_vip", this.j);
  }
  
  public void a(int paramInt) {
    List<VIPDiaglogBuyOptionView> list = this.t;
    if (list != null && list.size() > 0) {
      List<VIPBuyOption> list1 = this.u;
      if (list1 != null && list1.size() > 0) {
        for (int i = 0; i < this.u.size(); i++) {
          if (paramInt == i) {
            ((VIPBuyOption)this.u.get(i)).choosen = true;
            this.v = this.u.get(i);
          } else {
            ((VIPBuyOption)this.u.get(i)).choosen = false;
          } 
          if (i < this.t.size())
            ((VIPDiaglogBuyOptionView)this.t.get(i)).setOptionView(this.u.get(i)); 
        } 
        if (!StringUtils.e(this.v.item.button)) {
          this.r.setText(this.v.item.button);
          return;
        } 
        this.r.setText(this.d.getResources().getString(2131756583));
      } 
    } 
  }
  
  public void a(int paramInt, boolean paramBoolean) {
    if (paramBoolean)
      getActivity().finish(); 
  }
  
  public void a(List<VIPRightDescForSelling> paramList) {
    b(paramList);
    this.w.notifyDataSetChanged();
    for (int i = 0; i < paramList.size(); i++) {
      if (((VIPRightDescForSelling)paramList.get(i)).is_hot == 1) {
        this.k.setCurrentItem(i);
        return;
      } 
    } 
  }
  
  public void b(List<VIPRightDescForSelling> paramList) {
    if (paramList != null && paramList.size() > 0) {
      this.y.clear();
      for (int i = 0; i < paramList.size(); i++) {
        VIPRightDescForSelling vIPRightDescForSelling = paramList.get(i);
        View view = this.f.inflate(2131493680, null);
        ImageView imageView = (ImageView)view.findViewById(2131297496);
        TextView textView1 = (TextView)view.findViewById(2131301088);
        TextView textView2 = (TextView)view.findViewById(2131300704);
        ImageLoader.a((IRequestHost)w_(), vIPRightDescForSelling.icon).a(imageView);
        textView1.setText(vIPRightDescForSelling.title);
        textView2.setText(vIPRightDescForSelling.description);
        this.y.add(view);
      } 
    } 
  }
  
  public void k() {
    this.g = DialogUtils.a(this.d);
    this.k = (AutoScrollViewPager)this.e.findViewById(2131301672);
    this.k.setInterval(4000L);
    this.l = (ImageView)this.e.findViewById(2131297557);
    this.m = (TextView)this.e.findViewById(2131301339);
    if (this.h == 1) {
      this.m.setText(2131755821);
    } else {
      this.m.setText(2131755822);
    } 
    this.n = (ImageView)this.e.findViewById(2131297457);
    this.o = (CirclePageIndicator)this.e.findViewById(2131297592);
    this.o.setInterval(DensityUtils.a(this.d, 5.0F));
    this.p = (TextView)this.e.findViewById(2131301498);
    this.q = (LinearLayout)this.e.findViewById(2131299001);
    VIPDiaglogBuyOptionView vIPDiaglogBuyOptionView1 = (VIPDiaglogBuyOptionView)this.e.findViewById(2131299425);
    VIPDiaglogBuyOptionView vIPDiaglogBuyOptionView2 = (VIPDiaglogBuyOptionView)this.e.findViewById(2131299426);
    VIPDiaglogBuyOptionView vIPDiaglogBuyOptionView3 = (VIPDiaglogBuyOptionView)this.e.findViewById(2131299427);
    VIPDiaglogBuyOptionView vIPDiaglogBuyOptionView4 = (VIPDiaglogBuyOptionView)this.e.findViewById(2131299428);
    this.t.add(vIPDiaglogBuyOptionView1);
    this.t.add(vIPDiaglogBuyOptionView2);
    this.t.add(vIPDiaglogBuyOptionView3);
    this.t.add(vIPDiaglogBuyOptionView4);
    this.r = (ShapeTextView)this.e.findViewById(2131300598);
    this.s = (TextView)this.e.findViewById(2131301375);
    this.w = new MyPagerAdapter(this);
    this.k.setAdapter(this.w);
    this.o.setViewPager((ViewPager)this.k);
    this.l.setOnClickListener(this);
    this.m.setOnClickListener(this);
    this.n.setOnClickListener(this);
    vIPDiaglogBuyOptionView1.setOnClickListener(this);
    vIPDiaglogBuyOptionView2.setOnClickListener(this);
    vIPDiaglogBuyOptionView3.setOnClickListener(this);
    vIPDiaglogBuyOptionView4.setOnClickListener(this);
    this.r.setOnClickListener(this);
    if (this.h == 2) {
      this.p.setText(this.d.getResources().getString(2131758976));
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(this.d.getResources().getString(2131759313));
      stringBuilder.append(this.d.getResources().getString(2131759253));
      String str = stringBuilder.toString();
      this.s.setText(str);
      TypefaceUtils.a(this.d, this.s, new View.OnClickListener(this) {
            public void onClick(View param1View) {
              WebViewShowInfoFragment.show(this.a.d, H5Url.a(32), 0);
            }
          }new TypefaceUtils.SpannIndex(51, 64), new TypefaceUtils.SpannIndex(204, 235), true);
      TypefaceUtils.a(this.d, this.s, new View.OnClickListener(this) {
            public void onClick(View param1View) {
              WebViewShowInfoFragment.show(this.a.d, H5Url.a(21), 0);
            }
          }new TypefaceUtils.SpannIndex(65, 69), new TypefaceUtils.SpannIndex(236, 250), true);
      TypefaceUtils.a(this.d, this.s, new View.OnClickListener(this) {
            public void onClick(View param1View) {
              WebViewShowInfoFragment.show(this.a.d, H5Url.a(31), 0);
            }
          }new TypefaceUtils.SpannIndex(70, 83), new TypefaceUtils.SpannIndex(251, 297), true);
      this.k.setBackgroundResource(2131231067);
    } else {
      this.p.setText(this.d.getResources().getString(2131759285));
      String str = this.d.getResources().getString(2131759253);
      this.s.setText(str);
      TypefaceUtils.a(this.d, this.s, new View.OnClickListener(this) {
            public void onClick(View param1View) {
              WebViewShowInfoFragment.show(this.a.d, H5Url.a(32), 0);
            }
          }new TypefaceUtils.SpannIndex(27, 40), new TypefaceUtils.SpannIndex(122, 153), true);
      TypefaceUtils.a(this.d, this.s, new View.OnClickListener(this) {
            public void onClick(View param1View) {
              WebViewShowInfoFragment.show(this.a.d, H5Url.a(21), 0);
            }
          }new TypefaceUtils.SpannIndex(41, 45), new TypefaceUtils.SpannIndex(154, 165), true);
      TypefaceUtils.a(this.d, this.s, new View.OnClickListener(this) {
            public void onClick(View param1View) {
              WebViewShowInfoFragment.show(this.a.d, H5Url.a(31), 0);
            }
          }new TypefaceUtils.SpannIndex(46, 59), new TypefaceUtils.SpannIndex(166, 215), true);
      this.k.setBackgroundResource(2131231065);
    } 
    this.z.refresh();
    a();
  }
  
  public void onClick(View paramView) {
    VipProtos.Name name;
    VipProtos.Event event;
    switch (paramView.getId()) {
      default:
        return;
      case 2131300598:
        event = VipProtos.Event.VIP_BUY_OPEN_BTN_CLICK;
        if (this.h == 1) {
          name = VipProtos.Name.VIP;
        } else {
          name = VipProtos.Name.SVIP;
        } 
        EventTrackVIP.a(event, name, this.x, VipProtos.PageVersion.V_0813);
        PayPreOrderFragment.a(this.d, (GoodsOptionBasic)this.v, "popup", "", "", "", this.i);
        return;
      case 2131299428:
        a(3);
        return;
      case 2131299427:
        a(2);
        return;
      case 2131299426:
        a(1);
        return;
      case 2131299425:
        a(0);
        return;
      case 2131297557:
      case 2131301339:
        event = VipProtos.Event.VIP_BUY_SWITCH_BTN_CLICK;
        if (this.h == 1) {
          name = VipProtos.Name.VIP;
        } else {
          name = VipProtos.Name.SVIP;
        } 
        EventTrackVIP.a(event, name, VipProtos.PageVersion.V_0813);
        if (this.h == 2) {
          PayUtils.a(this.d, 1, this.i, this.j, this.x);
        } else {
          PayUtils.a(this.d, 2, this.i, this.j, this.x);
        } 
        ActivityChangeAnimationUtils.i((Activity)getActivity());
        getActivity().finish();
        return;
      case 2131297457:
        break;
    } 
    EventTrackVIP.a(VipProtos.Event.VIP_BUY_BACK_BTN_CLICK);
    getActivity().finish();
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
    VipProtos.Name name;
    this.d = (Context)getActivity();
    this.f = paramLayoutInflater;
    if (this.e == null) {
      Bundle bundle = getArguments();
      if (bundle != null) {
        this.h = bundle.getInt("KEY_VIP_GRADE");
        this.i = bundle.getString("KEY_DETAIL");
        this.j = bundle.getInt("KEY_RIGHT_ID");
        this.x = (VipProtos.FromType)bundle.getSerializable("KEY_RIGHT_ID");
      } 
      this.e = this.f.inflate(2131493356, paramViewGroup, false);
      k();
      StatusBarHelper.a((Activity)getActivity(), false);
      VIPBuyResultObserver.a().a(this, getLifecycle());
    } 
    VipProtos.Event event = VipProtos.Event.VIP_BUY_SHOW;
    if (this.h == 1) {
      name = VipProtos.Name.VIP;
    } else {
      name = VipProtos.Name.SVIP;
    } 
    EventTrackVIP.a(event, name, this.x, VipProtos.PageVersion.V_0813);
    return this.e;
  }
  
  public void onDestroy() {
    super.onDestroy();
    Dialog dialog = this.g;
    if (dialog != null && dialog.isShowing())
      this.g.dismiss(); 
  }
  
  public class MyPagerAdapter extends PagerAdapter {
    public MyPagerAdapter(VIPBuyDialogFragment this$0) {}
    
    public void destroyItem(ViewGroup param1ViewGroup, int param1Int, Object param1Object) {
      param1ViewGroup.removeView((View)param1Object);
    }
    
    public int getCount() {
      return (VIPBuyDialogFragment.d(this.a) != null) ? VIPBuyDialogFragment.d(this.a).size() : 0;
    }
    
    public int getItemPosition(Object param1Object) {
      return -2;
    }
    
    public Object instantiateItem(ViewGroup param1ViewGroup, int param1Int) {
      param1ViewGroup.addView(VIPBuyDialogFragment.d(this.a).get(param1Int));
      return VIPBuyDialogFragment.d(this.a).get(param1Int);
    }
    
    public boolean isViewFromObject(View param1View, Object param1Object) {
      return (param1View == param1Object);
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\u\\user\fragment\VIPBuyDialogFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */