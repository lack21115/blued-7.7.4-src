package com.soft.blued.ui.pay;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.module.common.utils.DialogUtils;
import com.blued.android.module.live.base.model.PayOption;
import com.blued.android.module.live_china.model.PayRemaining;
import com.soft.blued.customview.CommonTopTitleNoTrans;
import com.soft.blued.customview.NoDataAndLoadFailView;
import com.soft.blued.http.H5Url;
import com.soft.blued.http.MineHttpUtils;
import com.soft.blued.http.PayHttpUtils;
import com.soft.blued.model.BluedLoginResultVerBinding;
import com.soft.blued.ui.pay.adapter.PayOptionsAdapter;
import com.soft.blued.ui.user.observer.ReportPhotoChooseObserver;
import com.soft.blued.ui.user.observer.VIPBuyResultObserver;
import com.soft.blued.ui.web.WebViewShowInfoFragment;
import com.soft.blued.user.UserInfo;
import com.soft.blued.utils.StringUtils;
import com.soft.blued.utils.TypefaceUtils;
import java.util.ArrayList;
import java.util.List;

public class BeansPrePayFragment extends BaseFragment implements View.OnClickListener, ReportPhotoChooseObserver.IReportPhotoChooseObserver, VIPBuyResultObserver.IVIPBuyResultObserver {
  private Context d;
  
  private View e;
  
  private CommonTopTitleNoTrans f;
  
  private LinearLayout g;
  
  private NoDataAndLoadFailView h;
  
  private PayOptionsAdapter i;
  
  private List<PayOption._pay_list> j = new ArrayList<PayOption._pay_list>();
  
  private GridView k;
  
  private TextView l;
  
  private TextView m;
  
  private TextView n;
  
  private TextView o;
  
  private TextView p;
  
  private ImageView q;
  
  private LinearLayout r;
  
  private Dialog s;
  
  private ProgressBar t;
  
  private TextView u;
  
  private int v = 0;
  
  public static void a(Context paramContext, int paramInt) {
    Bundle bundle = new Bundle();
    bundle.putInt("from", paramInt);
    TerminalActivity.d(paramContext, BeansPrePayFragment.class, bundle);
  }
  
  private void l() {
    a();
    k();
  }
  
  private void m() {
    this.t = (ProgressBar)this.e.findViewById(2131296502);
    this.s = DialogUtils.a((Context)getActivity());
    this.k = (GridView)this.e.findViewById(2131297350);
    this.m = (TextView)this.e.findViewById(2131300480);
    this.l = (TextView)this.e.findViewById(2131301253);
    this.o = (TextView)this.e.findViewById(2131300743);
    this.n = (TextView)this.e.findViewById(2131300890);
    this.p = (TextView)this.e.findViewById(2131300737);
    this.q = (ImageView)this.e.findViewById(2131297492);
    this.r = (LinearLayout)this.e.findViewById(2131298790);
    this.u = (TextView)this.e.findViewById(2131300622);
    TypefaceUtils.a(this.d, this.u, new View.OnClickListener(this) {
          public void onClick(View param1View) {
            WebViewShowInfoFragment.show(BeansPrePayFragment.a(this.a), H5Url.a(12), 0);
          }
        }new TypefaceUtils.SpannIndex(6, 21), new TypefaceUtils.SpannIndex(14, 53));
    BluedLoginResultVerBinding bluedLoginResultVerBinding = UserInfo.a().i().getVerified_bindings();
    if (!TextUtils.isEmpty(UserInfo.a().f())) {
      this.m.setText(UserInfo.a().f());
    } else if (bluedLoginResultVerBinding != null) {
      if (bluedLoginResultVerBinding.mobile != null) {
        this.m.setText(bluedLoginResultVerBinding.mobile);
      } else if (bluedLoginResultVerBinding.email != null) {
        this.m.setText(bluedLoginResultVerBinding.email);
      } else if (!TextUtils.isEmpty(UserInfo.a().i().getName())) {
        this.m.setText(UserInfo.a().i().getName());
      } 
    } else if (!TextUtils.isEmpty(UserInfo.a().i().getName())) {
      this.m.setText(UserInfo.a().i().getName());
    } 
    this.g = (LinearLayout)this.e.findViewById(2131299010);
    this.h = (NoDataAndLoadFailView)this.e.findViewById(2131298985);
    VIPBuyResultObserver.a().a(this);
  }
  
  private void n() {
    this.f = (CommonTopTitleNoTrans)this.e.findViewById(2131300300);
    this.f.setCenterText(getString(2131755024));
    this.f.setRightText(2131755149);
    this.f.setRightTextColor(2131100838);
    this.f.setLeftClickListener(this);
    this.f.setRightClickListener(this);
  }
  
  public void a() {
    PayHttpUtils.a(new BluedUIHttpResponse<BluedEntityA<PayOption>>(this, (IRequestHost)w_()) {
          boolean a;
          
          protected void a(BluedEntityA<PayOption> param1BluedEntityA) {
            // Byte code:
            //   0: aload_1
            //   1: ifnull -> 338
            //   4: aload_1
            //   5: getfield data : Ljava/util/List;
            //   8: ifnull -> 338
            //   11: aload_1
            //   12: getfield data : Ljava/util/List;
            //   15: invokeinterface size : ()I
            //   20: ifle -> 338
            //   23: aload_1
            //   24: getfield data : Ljava/util/List;
            //   27: iconst_0
            //   28: invokeinterface get : (I)Ljava/lang/Object;
            //   33: ifnull -> 338
            //   36: aload_1
            //   37: getfield data : Ljava/util/List;
            //   40: iconst_0
            //   41: invokeinterface get : (I)Ljava/lang/Object;
            //   46: checkcast com/blued/android/module/live/base/model/PayOption
            //   49: getfield pay_list : Ljava/util/List;
            //   52: ifnull -> 338
            //   55: aload_1
            //   56: getfield data : Ljava/util/List;
            //   59: iconst_0
            //   60: invokeinterface get : (I)Ljava/lang/Object;
            //   65: checkcast com/blued/android/module/live/base/model/PayOption
            //   68: getfield pay_list : Ljava/util/List;
            //   71: invokeinterface size : ()I
            //   76: ifle -> 338
            //   79: aload_0
            //   80: getfield b : Lcom/soft/blued/ui/pay/BeansPrePayFragment;
            //   83: invokestatic c : (Lcom/soft/blued/ui/pay/BeansPrePayFragment;)Ljava/util/List;
            //   86: aload_1
            //   87: getfield data : Ljava/util/List;
            //   90: iconst_0
            //   91: invokeinterface get : (I)Ljava/lang/Object;
            //   96: checkcast com/blued/android/module/live/base/model/PayOption
            //   99: getfield pay_list : Ljava/util/List;
            //   102: invokeinterface addAll : (Ljava/util/Collection;)Z
            //   107: pop
            //   108: aload_0
            //   109: getfield b : Lcom/soft/blued/ui/pay/BeansPrePayFragment;
            //   112: iconst_1
            //   113: invokevirtual a : (Z)V
            //   116: aload_0
            //   117: getfield b : Lcom/soft/blued/ui/pay/BeansPrePayFragment;
            //   120: invokestatic d : (Lcom/soft/blued/ui/pay/BeansPrePayFragment;)I
            //   123: istore_2
            //   124: ldc ''
            //   126: astore #4
            //   128: iload_2
            //   129: ifeq -> 225
            //   132: aload_0
            //   133: getfield b : Lcom/soft/blued/ui/pay/BeansPrePayFragment;
            //   136: invokestatic d : (Lcom/soft/blued/ui/pay/BeansPrePayFragment;)I
            //   139: istore_2
            //   140: iload_2
            //   141: iconst_2
            //   142: if_icmpeq -> 218
            //   145: iload_2
            //   146: iconst_3
            //   147: if_icmpeq -> 211
            //   150: iload_2
            //   151: iconst_4
            //   152: if_icmpeq -> 204
            //   155: iload_2
            //   156: iconst_5
            //   157: if_icmpeq -> 197
            //   160: iload_2
            //   161: bipush #7
            //   163: if_icmpeq -> 190
            //   166: iload_2
            //   167: bipush #8
            //   169: if_icmpeq -> 183
            //   172: ldc 'my'
            //   174: astore #4
            //   176: ldc ''
            //   178: astore #5
            //   180: goto -> 229
            //   183: ldc 'live_first_charge'
            //   185: astore #4
            //   187: goto -> 176
            //   190: ldc 'yy_chat'
            //   192: astore #4
            //   194: goto -> 225
            //   197: ldc 'package'
            //   199: astore #4
            //   201: goto -> 176
            //   204: ldc 'live_btn'
            //   206: astore #4
            //   208: goto -> 176
            //   211: ldc 'gift'
            //   213: astore #4
            //   215: goto -> 176
            //   218: ldc 'live'
            //   220: astore #4
            //   222: goto -> 176
            //   225: aload #4
            //   227: astore #5
            //   229: aload_1
            //   230: getfield data : Ljava/util/List;
            //   233: iconst_0
            //   234: invokeinterface get : (I)Ljava/lang/Object;
            //   239: checkcast com/blued/android/module/live/base/model/PayOption
            //   242: astore_1
            //   243: aload_0
            //   244: getfield b : Lcom/soft/blued/ui/pay/BeansPrePayFragment;
            //   247: astore #6
            //   249: aload #6
            //   251: invokestatic a : (Lcom/soft/blued/ui/pay/BeansPrePayFragment;)Landroid/content/Context;
            //   254: astore #7
            //   256: aload_0
            //   257: getfield b : Lcom/soft/blued/ui/pay/BeansPrePayFragment;
            //   260: invokestatic c : (Lcom/soft/blued/ui/pay/BeansPrePayFragment;)Ljava/util/List;
            //   263: astore #8
            //   265: aload_1
            //   266: getfield has_payment_code : I
            //   269: iconst_1
            //   270: if_icmpne -> 278
            //   273: iconst_1
            //   274: istore_3
            //   275: goto -> 280
            //   278: iconst_0
            //   279: istore_3
            //   280: aload #6
            //   282: new com/soft/blued/ui/pay/adapter/PayOptionsAdapter
            //   285: dup
            //   286: aload #7
            //   288: aload #8
            //   290: aload #4
            //   292: aload #5
            //   294: iload_3
            //   295: aload_0
            //   296: getfield b : Lcom/soft/blued/ui/pay/BeansPrePayFragment;
            //   299: invokevirtual w_ : ()Lcom/blued/android/core/ui/ActivityFragmentActive;
            //   302: invokespecial <init> : (Landroid/content/Context;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;ZLcom/blued/android/core/net/IRequestHost;)V
            //   305: invokestatic a : (Lcom/soft/blued/ui/pay/BeansPrePayFragment;Lcom/soft/blued/ui/pay/adapter/PayOptionsAdapter;)Lcom/soft/blued/ui/pay/adapter/PayOptionsAdapter;
            //   308: pop
            //   309: aload_0
            //   310: getfield b : Lcom/soft/blued/ui/pay/BeansPrePayFragment;
            //   313: invokestatic f : (Lcom/soft/blued/ui/pay/BeansPrePayFragment;)Landroid/widget/GridView;
            //   316: aload_0
            //   317: getfield b : Lcom/soft/blued/ui/pay/BeansPrePayFragment;
            //   320: invokestatic e : (Lcom/soft/blued/ui/pay/BeansPrePayFragment;)Lcom/soft/blued/ui/pay/adapter/PayOptionsAdapter;
            //   323: invokevirtual setAdapter : (Landroid/widget/ListAdapter;)V
            //   326: aload_0
            //   327: getfield b : Lcom/soft/blued/ui/pay/BeansPrePayFragment;
            //   330: invokestatic g : (Lcom/soft/blued/ui/pay/BeansPrePayFragment;)Landroid/widget/TextView;
            //   333: iconst_0
            //   334: invokevirtual setVisibility : (I)V
            //   337: return
            //   338: aload_0
            //   339: getfield b : Lcom/soft/blued/ui/pay/BeansPrePayFragment;
            //   342: iconst_0
            //   343: invokevirtual a : (Z)V
            //   346: return
          }
          
          public boolean onUIFailure(int param1Int, String param1String) {
            this.a = true;
            return super.onUIFailure(param1Int, param1String);
          }
          
          public void onUIFinish() {
            super.onUIFinish();
            if (this.a)
              this.b.a(false); 
            DialogUtils.b(BeansPrePayFragment.b(this.b));
            this.a = false;
          }
          
          public void onUIStart() {
            super.onUIStart();
            if (!BeansPrePayFragment.b(this.b).isShowing())
              DialogUtils.a(BeansPrePayFragment.b(this.b)); 
          }
        }(IRequestHost)w_(), "beans");
  }
  
  public void a(int paramInt, boolean paramBoolean) {
    if (this.v == 6 && paramInt == 1 && paramBoolean && getActivity() != null)
      getActivity().finish(); 
  }
  
  public void a(boolean paramBoolean) {
    if (paramBoolean) {
      this.h.c();
      this.g.setVisibility(0);
      return;
    } 
    this.h.b();
    this.g.setVisibility(8);
  }
  
  public void k() {
    MineHttpUtils.b(new BluedUIHttpResponse<BluedEntityA<PayRemaining>>(this, (IRequestHost)w_()) {
          public void a(BluedEntityA<PayRemaining> param1BluedEntityA) {
            if (param1BluedEntityA != null && param1BluedEntityA.data != null && param1BluedEntityA.data.size() > 0) {
              PayRemaining payRemaining = param1BluedEntityA.data.get(0);
              if (payRemaining != null) {
                if (payRemaining.text != null && !StringUtils.e(payRemaining.text.exchange)) {
                  BeansPrePayFragment.j(this.a).setVisibility(0);
                  BeansPrePayFragment.k(this.a).setText(payRemaining.text.exchange);
                } else {
                  BeansPrePayFragment.j(this.a).setVisibility(8);
                } 
                UserInfo.a().a(payRemaining.beans);
                long l1 = payRemaining.beans;
                long l2 = payRemaining.bonus;
                TextView textView = BeansPrePayFragment.i(this.a);
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(StringUtils.a(String.valueOf(l1 + l2)));
                stringBuilder.append(this.a.getResources().getString(2131755033));
                textView.setText(stringBuilder.toString());
                if (payRemaining.bonus > 0L) {
                  BeansPrePayFragment.l(this.a).setVisibility(0);
                  BeansPrePayFragment.l(this.a).setText(String.format(this.a.getResources().getString(2131756123), new Object[] { StringUtils.a(String.valueOf(payRemaining.bonus)) }));
                } else {
                  BeansPrePayFragment.l(this.a).setVisibility(8);
                } 
                if (!StringUtils.e(payRemaining.text.jump_url)) {
                  BeansPrePayFragment.m(this.a).setVisibility(0);
                  BeansPrePayFragment.j(this.a).setOnClickListener(new View.OnClickListener(this, payRemaining) {
                        public void onClick(View param2View) {
                          WebViewShowInfoFragment.show(BeansPrePayFragment.a(this.b.a), this.a.text.jump_url, 7);
                        }
                      });
                  return;
                } 
                BeansPrePayFragment.m(this.a).setVisibility(8);
              } 
            } 
          }
          
          public void onUIFinish() {
            if (BeansPrePayFragment.b(this.a).isShowing())
              DialogUtils.b(BeansPrePayFragment.b(this.a)); 
            BeansPrePayFragment.h(this.a).setVisibility(8);
            BeansPrePayFragment.i(this.a).setVisibility(0);
          }
          
          public void onUIStart() {
            if (!BeansPrePayFragment.b(this.a).isShowing())
              DialogUtils.a(BeansPrePayFragment.b(this.a)); 
            BeansPrePayFragment.h(this.a).setVisibility(0);
            BeansPrePayFragment.i(this.a).setVisibility(8);
          }
        }(IRequestHost)w_());
  }
  
  public void onClick(View paramView) {
    int i = paramView.getId();
    if (i != 2131296863) {
      if (i != 2131296867)
        return; 
      WebViewShowInfoFragment.show((Context)getActivity(), H5Url.a(1), 0);
      return;
    } 
    getActivity().finish();
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
    this.d = (Context)getActivity();
    if (this.e == null) {
      this.e = paramLayoutInflater.inflate(2131493275, paramViewGroup, false);
      if (getArguments() != null)
        this.v = getArguments().getInt("from"); 
      m();
      n();
      l();
    } 
    return this.e;
  }
  
  public void onDestroy() {
    super.onDestroy();
    VIPBuyResultObserver.a().b(this);
  }
  
  public void onResume() {
    super.onResume();
    k();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\pay\BeansPrePayFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */