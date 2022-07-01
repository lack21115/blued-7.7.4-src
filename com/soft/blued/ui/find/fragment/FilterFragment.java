package com.soft.blued.ui.find.fragment;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.Fragment;
import com.blued.android.core.AppMethods;
import com.blued.android.core.BlueAppLocal;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.core.utils.skin.BluedSkinUtils;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.common.utils.DialogUtils;
import com.blued.android.module.common.utils.ToastUtils;
import com.blued.das.guy.GuyProtos;
import com.soft.blued.customview.CommonTopTitleNoTrans;
import com.soft.blued.customview.PhotoGridView;
import com.soft.blued.http.FindHttpUtils;
import com.soft.blued.http.NearbyHttpUtils;
import com.soft.blued.log.trackUtils.EventTrackGuy;
import com.soft.blued.ui.find.manager.FilterHelper;
import com.soft.blued.ui.find.model.FilterEntity;
import com.soft.blued.ui.find.observer.PeopleDataObserver;
import com.soft.blued.ui.find.view.TwoWaysBar;
import com.soft.blued.ui.user.adapter.UserTagAdapter;
import com.soft.blued.ui.user.model.UserTag;
import com.soft.blued.ui.user.model.UserTagAll;
import com.soft.blued.ui.user.presenter.PayUtils;
import com.soft.blued.ui.video.uitls.ViewUtils;
import com.soft.blued.user.BluedConfig;
import com.soft.blued.user.UserInfo;
import com.soft.blued.utils.BluedPreferences;
import com.soft.blued.utils.Logger;
import com.soft.blued.utils.StringUtils;
import com.soft.blued.utils.UserRelationshipUtils;
import com.soft.blued.view.tip.CommonAlertDialog;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class FilterFragment extends BaseFragment implements View.OnClickListener {
  private String A;
  
  private String B = "";
  
  private String C = "";
  
  private String D = "";
  
  private String E = "";
  
  private String F = "";
  
  private ImageView G;
  
  private ImageView H;
  
  private ImageView I;
  
  private ImageView J;
  
  private ImageView K;
  
  private LinearLayout L;
  
  private LinearLayout M;
  
  private LinearLayout N;
  
  private LinearLayout O;
  
  private LinearLayout P;
  
  private LinearLayout Q;
  
  private LinearLayout R;
  
  private LinearLayout S;
  
  private LinearLayout T;
  
  private LinearLayout U;
  
  private TextView V;
  
  private TextView W;
  
  private TextView X;
  
  private TextView Y;
  
  private TextView Z;
  
  private View aA;
  
  private String[] aB;
  
  private String[] aC;
  
  private String[] aD;
  
  private String[] aE;
  
  private boolean aF;
  
  private boolean aG;
  
  private HashSet<String> aH = new HashSet<String>();
  
  private TextView aI;
  
  private TextView aa;
  
  private TextView ab;
  
  private ImageView ac;
  
  private ImageView ad;
  
  private ImageView ae;
  
  private List<UserTag> af = new ArrayList<UserTag>();
  
  private List<UserTag> ag = new ArrayList<UserTag>();
  
  private List<UserTag> ah = new ArrayList<UserTag>();
  
  private List<UserTag> ai = new ArrayList<UserTag>();
  
  private List<UserTag> aj = new ArrayList<UserTag>();
  
  private List<UserTag> ak = new ArrayList<UserTag>();
  
  private List<UserTag> al = new ArrayList<UserTag>();
  
  private PhotoGridView am;
  
  private PhotoGridView an;
  
  private PhotoGridView ao;
  
  private PhotoGridView ap;
  
  private PhotoGridView aq;
  
  private PhotoGridView ar;
  
  private PhotoGridView as;
  
  private UserTagAdapter at;
  
  private UserTagAdapter au;
  
  private UserTagAdapter av;
  
  private UserTagAdapter aw;
  
  private UserTagAdapter ax;
  
  private UserTagAdapter ay;
  
  private UserTagAdapter az;
  
  public FilterDialogFragment d;
  
  public View e;
  
  public CommonTopTitleNoTrans f;
  
  public NestedScrollView g;
  
  public TextView h;
  
  public TextView i;
  
  public TwoWaysBar j;
  
  public TwoWaysBar k;
  
  public TwoWaysBar l;
  
  public TwoWaysBar m;
  
  public TwoWaysBar n;
  
  public LinearLayout o;
  
  private Dialog p;
  
  private Context q;
  
  private boolean r;
  
  private boolean s;
  
  private boolean t;
  
  private boolean u;
  
  private boolean v = false;
  
  private String w;
  
  private String x;
  
  private String y;
  
  private String z;
  
  private boolean A() {
    return ((TextUtils.isEmpty(this.F) && !TextUtils.isEmpty(BluedPreferences.Y())) || !this.F.equals(BluedPreferences.Y()));
  }
  
  private boolean B() {
    return ((TextUtils.isEmpty(this.E) && !TextUtils.isEmpty(BluedPreferences.X())) || !this.E.equals(BluedPreferences.X()));
  }
  
  private boolean C() {
    return (this.v != BluedPreferences.W());
  }
  
  private boolean D() {
    return (this.u != BluedPreferences.Q());
  }
  
  private boolean E() {
    return (this.t != BluedPreferences.P());
  }
  
  private boolean F() {
    return (this.s != BluedPreferences.O());
  }
  
  private boolean G() {
    String str = m();
    return ((!TextUtils.isEmpty(str) && TextUtils.isEmpty(BluedPreferences.H())) || (TextUtils.isEmpty(str) && !TextUtils.isEmpty(BluedPreferences.H())) || !str.equals(BluedPreferences.H()));
  }
  
  private void H() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("setInitialData===============");
    stringBuilder.append(this.r);
    Logger.e("Filter", new Object[] { stringBuilder.toString() });
    BluedPreferences.h(this.w);
    BluedPreferences.a(this.r);
    BluedPreferences.b(this.s);
    BluedPreferences.c(this.t);
    BluedPreferences.d(this.u);
    BluedPreferences.i(this.x);
    BluedPreferences.l(this.A);
    BluedPreferences.j(this.z);
    BluedPreferences.n(this.y);
    BluedPreferences.p(this.B);
    BluedPreferences.q(this.C);
    BluedPreferences.r(this.D);
    BluedPreferences.e(this.v);
    BluedPreferences.s(this.E);
    BluedPreferences.t(this.F);
  }
  
  private void I() {
    this.f = (CommonTopTitleNoTrans)this.e.findViewById(2131300300);
    RelativeLayout relativeLayout = (RelativeLayout)this.f.findViewById(2131299697);
    if (relativeLayout != null) {
      LinearLayout.LayoutParams layoutParams1 = (LinearLayout.LayoutParams)this.f.findViewById(2131299697).getLayoutParams();
      layoutParams1.height = DensityUtils.a(getContext(), 54.0F);
      relativeLayout.setLayoutParams((ViewGroup.LayoutParams)layoutParams1);
    } 
    this.f.setCenterText(getString(2131756473));
    this.f.setRightText(2131756100);
    this.f.setLeftClickListener(this);
    this.f.setRightClickListener(this);
    this.f.setCenterTextColor(2131100838);
    this.f.getTitleBackground().setBackground((Drawable)new ColorDrawable(0));
    this.f.getRightTextView().setVisibility(8);
    ShapeTextView shapeTextView = this.f.getRightTextView();
    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams)shapeTextView.getLayoutParams();
    layoutParams.rightMargin = DensityUtils.a(getContext(), 10.0F);
    shapeTextView.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
    shapeTextView.setTextColor(BluedSkinUtils.a(this.q, 2131100716));
    ImageView imageView = this.f.getLeftImg();
    layoutParams = (RelativeLayout.LayoutParams)imageView.getLayoutParams();
    layoutParams.leftMargin = DensityUtils.a(getContext(), 10.0F);
    imageView.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
    imageView.setImageDrawable(BluedSkinUtils.b(this.q, 2131232745));
  }
  
  private void J() {
    String str = m();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("rolses==");
    stringBuilder.append(str);
    Logger.e(stringBuilder.toString(), new Object[0]);
    BluedPreferences.h(str);
  }
  
  private void K() {
    if (BluedPreferences.cf())
      return; 
    int j = 0;
    if (!TextUtils.isEmpty(BluedPreferences.R()))
      j = 1; 
    String[] arrayOfString = l();
    int i = j;
    if (!TextUtils.isEmpty(arrayOfString[1]))
      i = j + 1; 
    j = i;
    if (!TextUtils.isEmpty(arrayOfString[2]))
      j = i + 1; 
    i = j;
    if (FilterHelper.d().m())
      i = j + 1; 
    j = i;
    if (FilterHelper.d().l())
      j = i + 1; 
    i = j;
    if (FilterHelper.d().k())
      i = j + 1; 
    j = i;
    if (!TextUtils.isEmpty(m()))
      j = i + 1; 
    i = j;
    if (BluedPreferences.P())
      i = j + 1; 
    j = i;
    if (BluedPreferences.O())
      j = i + 1; 
    i = j;
    if (FilterHelper.d().i())
      i = j + 1; 
    j = i;
    if (FilterHelper.d().j())
      j = i + 1; 
    i = j;
    if (FilterHelper.d().g())
      i = j + 1; 
    j = i;
    if (FilterHelper.d().g())
      j = i + 1; 
    if (j >= 6) {
      BluedPreferences.ce();
      ToastUtils.a(getResources().getString(2131756478));
    } 
  }
  
  private boolean c(String paramString) {
    return (StringUtils.e(paramString) && StringUtils.e(BluedPreferences.L())) ? false : (paramString.equals(BluedPreferences.U()) ^ true);
  }
  
  private boolean d(String paramString) {
    return (StringUtils.e(paramString) && StringUtils.e(BluedPreferences.V())) ? false : (paramString.equals(BluedPreferences.V()) ^ true);
  }
  
  private void e(String paramString) {
    if (!StringUtils.e(paramString)) {
      this.aF = true;
      if (paramString.equals("-1")) {
        BluedPreferences.n(paramString);
      } else {
        String[] arrayOfString1 = paramString.split(",");
        String[] arrayOfString2 = new String[arrayOfString1.length];
        int i = 0;
        paramString = "";
        while (i < arrayOfString1.length) {
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append(Integer.parseInt(arrayOfString1[i]) + 1);
          stringBuilder.append("");
          stringBuilder.append(",");
          stringBuilder.append(paramString);
          paramString = stringBuilder.toString();
          stringBuilder = new StringBuilder();
          stringBuilder.append(Integer.parseInt(arrayOfString1[i]) + 1);
          stringBuilder.append("");
          arrayOfString2[i] = stringBuilder.toString();
          i++;
        } 
        BluedPreferences.n(paramString);
      } 
    } else {
      BluedPreferences.n("");
    } 
    K();
  }
  
  private void o() {
    int i = BluedPreferences.aD();
    if (i != 1) {
      if (i == 2)
        this.aG = true; 
    } else {
      this.aG = false;
    } 
    this.aC = FilterHelper.d().a();
    this.aD = FilterHelper.d().b();
    this.aE = FilterHelper.d().c();
    this.aB = this.q.getResources().getStringArray(2130903098);
  }
  
  private void p() {
    if (this.j != null && this.k != null && this.i != null && this.h != null) {
      if ((BluedConfig.b().j()).is_filter_vip == 1) {
        this.j.setEnabled(true);
        this.j.a(this.E, 100);
        this.h.setText(TwoWaysBar.a(this.q, this.E, 1));
        this.k.setEnabled(true);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("barTimeRange===");
        stringBuilder.append(this.F);
        Logger.e("FilterFragment", new Object[] { stringBuilder.toString() });
        this.k.a(this.F, 30);
        this.i.setText(TwoWaysBar.a(this.q, this.F, 2));
      } else {
        this.h.setText(TwoWaysBar.a(this.q, "", 1));
        this.i.setText(TwoWaysBar.a(this.q, "", 2));
        this.j.setEnabled(false);
        this.k.setEnabled(false);
      } 
      this.j.setTwoWaysBarListner(new TwoWaysBar.TwoWaysBarListner(this) {
            public void a(int param1Int1, int param1Int2) {
              Integer integer;
              FilterFragment.a(this.a, true);
              StringBuilder stringBuilder = new StringBuilder();
              stringBuilder.append(param1Int1);
              stringBuilder.append("-");
              if (param1Int2 >= 100) {
                String str = "max";
              } else {
                integer = Integer.valueOf(param1Int2);
              } 
              stringBuilder.append(integer);
              BluedPreferences.s(stringBuilder.toString());
              this.a.h.setText(TwoWaysBar.a(FilterFragment.d(this.a), param1Int1, param1Int2, 1));
              FilterFragment.b(this.a);
            }
            
            public void a(boolean param1Boolean) {}
            
            public void b(boolean param1Boolean) {}
            
            public void c(boolean param1Boolean) {
              boolean bool;
              GuyProtos.Event event = GuyProtos.Event.SCREEN_DISTANCE_BTN_CLICK;
              if ((UserInfo.a().i()).vip_grade != 0) {
                bool = true;
              } else {
                bool = false;
              } 
              EventTrackGuy.a(event, bool);
              if (!param1Boolean)
                PayUtils.a((Context)this.a.getActivity(), 24, "nearby_filter_distance"); 
            }
          });
      this.k.setTwoWaysBarListner(new TwoWaysBar.TwoWaysBarListner(this) {
            public void a(int param1Int1, int param1Int2) {
              Integer integer;
              FilterFragment.a(this.a, true);
              StringBuilder stringBuilder = new StringBuilder();
              stringBuilder.append(param1Int1);
              stringBuilder.append("-");
              if (param1Int2 >= 30) {
                String str = "max";
              } else {
                integer = Integer.valueOf(param1Int2);
              } 
              stringBuilder.append(integer);
              BluedPreferences.t(stringBuilder.toString());
              this.a.i.setText(TwoWaysBar.a(FilterFragment.d(this.a), param1Int1, param1Int2, 2));
              FilterFragment.b(this.a);
            }
            
            public void a(boolean param1Boolean) {}
            
            public void b(boolean param1Boolean) {}
            
            public void c(boolean param1Boolean) {
              boolean bool;
              GuyProtos.Event event = GuyProtos.Event.SCREEN_ONLINE_TIME_BTN_CLICK;
              if ((UserInfo.a().i()).vip_grade != 0) {
                bool = true;
              } else {
                bool = false;
              } 
              EventTrackGuy.a(event, bool);
              if (!param1Boolean)
                PayUtils.a((Context)this.a.getActivity(), 24, "nearby_filter_time"); 
            }
          });
    } 
  }
  
  private void q() {
    String str2;
    String str1;
    this.o = (LinearLayout)this.e.findViewById(2131298806);
    this.h = (TextView)this.e.findViewById(2131300717);
    this.i = (TextView)this.e.findViewById(2131301390);
    this.j = (TwoWaysBar)this.e.findViewById(2131296500);
    this.k = (TwoWaysBar)this.e.findViewById(2131296504);
    this.k.d = 2;
    this.E = BluedPreferences.X();
    this.F = BluedPreferences.Y();
    p();
    this.ae = (ImageView)this.e.findViewById(2131297483);
    if (BluedPreferences.aG()) {
      this.ae.setVisibility(8);
    } else {
      this.ae.setVisibility(0);
    } 
    this.p = DialogUtils.a((Context)getActivity());
    this.G = (ImageView)this.e.findViewById(2131299818);
    this.H = (ImageView)this.e.findViewById(2131299820);
    this.I = (ImageView)this.e.findViewById(2131299815);
    this.J = (ImageView)this.e.findViewById(2131299822);
    this.K = (ImageView)this.e.findViewById(2131299823);
    this.U = (LinearLayout)this.e.findViewById(2131299135);
    this.L = (LinearLayout)this.e.findViewById(2131298808);
    this.M = (LinearLayout)this.e.findViewById(2131298807);
    this.N = (LinearLayout)this.e.findViewById(2131299016);
    this.T = (LinearLayout)this.e.findViewById(2131298687);
    this.ab = (TextView)this.e.findViewById(2131300505);
    this.T.setVisibility(0);
    this.ab.setVisibility(0);
    this.O = (LinearLayout)this.e.findViewById(2131299129);
    this.P = (LinearLayout)this.e.findViewById(2131298804);
    this.P.setOnClickListener(this);
    this.R = (LinearLayout)this.e.findViewById(2131298876);
    this.Q = (LinearLayout)this.e.findViewById(2131298805);
    this.Q.setOnClickListener(this);
    this.S = (LinearLayout)this.e.findViewById(2131298931);
    this.V = (TextView)this.e.findViewById(2131300773);
    this.W = (TextView)this.e.findViewById(2131300502);
    this.X = (TextView)this.e.findViewById(2131300884);
    this.Y = (TextView)this.e.findViewById(2131301529);
    this.Z = (TextView)this.e.findViewById(2131300767);
    this.aa = (TextView)this.e.findViewById(2131300768);
    this.ac = (ImageView)this.e.findViewById(2131300887);
    this.ad = (ImageView)this.e.findViewById(2131301012);
    this.l = (TwoWaysBar)this.e.findViewById(2131296498);
    this.m = (TwoWaysBar)this.e.findViewById(2131296503);
    this.n = (TwoWaysBar)this.e.findViewById(2131296505);
    this.am = (PhotoGridView)this.e.findViewById(2131297342);
    this.am.setOnItemClickListener(new AdapterView.OnItemClickListener(this) {
          public void onItemClick(AdapterView<?> param1AdapterView, View param1View, int param1Int, long param1Long) {
            FilterFragment filterFragment = this.a;
            filterFragment.a((View)FilterFragment.e(filterFragment), FilterFragment.f(this.a), FilterFragment.g(this.a), param1Int);
          }
        });
    this.an = (PhotoGridView)this.e.findViewById(2131297343);
    this.an.setOnItemClickListener(new AdapterView.OnItemClickListener(this) {
          public void onItemClick(AdapterView<?> param1AdapterView, View param1View, int param1Int, long param1Long) {
            FilterFragment filterFragment = this.a;
            filterFragment.a((View)FilterFragment.h(filterFragment), FilterFragment.i(this.a), FilterFragment.j(this.a), param1Int);
          }
        });
    this.ao = (PhotoGridView)this.e.findViewById(2131297346);
    this.ao.setOnItemClickListener(new AdapterView.OnItemClickListener(this) {
          public void onItemClick(AdapterView<?> param1AdapterView, View param1View, int param1Int, long param1Long) {
            FilterFragment filterFragment = this.a;
            filterFragment.a((View)FilterFragment.k(filterFragment), FilterFragment.l(this.a), FilterFragment.m(this.a), param1Int);
          }
        });
    this.ap = (PhotoGridView)this.e.findViewById(2131297349);
    this.ap.setOnItemClickListener(new AdapterView.OnItemClickListener(this) {
          public void onItemClick(AdapterView<?> param1AdapterView, View param1View, int param1Int, long param1Long) {
            FilterFragment filterFragment = this.a;
            filterFragment.a((View)FilterFragment.n(filterFragment), FilterFragment.o(this.a), FilterFragment.p(this.a), param1Int);
          }
        });
    this.aq = (PhotoGridView)this.e.findViewById(2131297347);
    this.aq.setOnItemClickListener(new AdapterView.OnItemClickListener(this) {
          public void onItemClick(AdapterView<?> param1AdapterView, View param1View, int param1Int, long param1Long) {
            FilterFragment filterFragment = this.a;
            filterFragment.a((View)FilterFragment.q(filterFragment), FilterFragment.r(this.a), FilterFragment.s(this.a), param1Int);
          }
        });
    this.ar = (PhotoGridView)this.e.findViewById(2131297352);
    this.ar.setOnItemClickListener(new AdapterView.OnItemClickListener(this) {
          public void onItemClick(AdapterView<?> param1AdapterView, View param1View, int param1Int, long param1Long) {
            FilterFragment filterFragment = this.a;
            filterFragment.a((View)FilterFragment.t(filterFragment), FilterFragment.u(this.a), FilterFragment.v(this.a), param1Int);
          }
        });
    this.w = BluedPreferences.H();
    b(this.w);
    this.ay = new UserTagAdapter(this.q, this.ak);
    this.ar.setAdapter((ListAdapter)this.ay);
    this.g = (NestedScrollView)this.e.findViewById(2131299836);
    this.g.setOnScrollChangeListener(new NestedScrollView.OnScrollChangeListener(this) {
          public void onScrollChange(NestedScrollView param1NestedScrollView, int param1Int1, int param1Int2, int param1Int3, int param1Int4) {}
        });
    this.aA = this.e.findViewById(2131297058);
    this.aA.setOnTouchListener(new View.OnTouchListener(this) {
          public boolean onTouch(View param1View, MotionEvent param1MotionEvent) {
            return true;
          }
        });
    if (BluedPreferences.G()) {
      this.r = true;
      this.G.setImageResource(2131234234);
      this.aA.setVisibility(8);
    } else {
      this.r = false;
      this.G.setImageResource(2131234233);
      this.aA.setVisibility(0);
    } 
    String str3 = this.q.getResources().getString(2131759104);
    this.x = BluedPreferences.J();
    if (TextUtils.isEmpty(this.x)) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("0-");
      stringBuilder.append(this.aC.length - 1);
      this.x = stringBuilder.toString();
      BluedPreferences.i(this.x);
    } 
    this.l.d = 3;
    this.W.setText(FilterHelper.d().a(this.x));
    this.l.a(this.x, this.aC.length);
    this.l.setTwoWaysBarListner((TwoWaysBar.TwoWaysBarListner)new TwoWaysBar.TowWaysBarListenerAdapter(this) {
          public void a(int param1Int1, int param1Int2) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(param1Int1);
            stringBuilder.append("-");
            stringBuilder.append(param1Int2);
            String str = stringBuilder.toString();
            BluedPreferences.i(str);
            FilterFragment.a(this.a, true);
            FilterFragment.w(this.a).setText(FilterHelper.d().a(str));
            FilterFragment.b(this.a);
          }
        });
    if (this.aG) {
      str2 = BluedPreferences.L();
    } else {
      str2 = BluedPreferences.K();
    } 
    this.z = str2;
    StringBuilder stringBuilder3 = new StringBuilder();
    stringBuilder3.append("fiter_height===");
    stringBuilder3.append(this.z);
    Logger.e(stringBuilder3.toString(), new Object[0]);
    if (TextUtils.isEmpty(this.z)) {
      stringBuilder3 = new StringBuilder();
      stringBuilder3.append("0-");
      stringBuilder3.append(this.aD.length - 1);
      this.z = stringBuilder3.toString();
      if (this.aG) {
        BluedPreferences.k(this.z);
      } else {
        BluedPreferences.j(this.z);
      } 
    } 
    this.X.setText(FilterHelper.d().b(this.z));
    TwoWaysBar twoWaysBar2 = this.m;
    twoWaysBar2.d = 3;
    twoWaysBar2.a(this.z, this.aD.length);
    this.m.setTwoWaysBarListner((TwoWaysBar.TwoWaysBarListner)new TwoWaysBar.TowWaysBarListenerAdapter(this) {
          public void a(int param1Int1, int param1Int2) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(param1Int1);
            stringBuilder.append("-");
            stringBuilder.append(param1Int2);
            String str = stringBuilder.toString();
            if (FilterFragment.x(this.a)) {
              BluedPreferences.k(str);
            } else {
              BluedPreferences.j(str);
            } 
            FilterFragment.y(this.a).setText(FilterHelper.d().b(str));
            FilterFragment.a(this.a, true);
            FilterFragment.b(this.a);
          }
        });
    if (this.aG) {
      str1 = BluedPreferences.N();
    } else {
      str1 = BluedPreferences.M();
    } 
    this.A = str1;
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append("fiter_height===");
    stringBuilder2.append(this.A);
    Logger.e(stringBuilder2.toString(), new Object[0]);
    if (TextUtils.isEmpty(this.A)) {
      stringBuilder2 = new StringBuilder();
      stringBuilder2.append("0-");
      stringBuilder2.append(this.aE.length - 1);
      this.A = stringBuilder2.toString();
      if (this.aG) {
        BluedPreferences.m(this.A);
      } else {
        BluedPreferences.l(this.A);
      } 
    } 
    this.Y.setText(FilterHelper.d().c(this.A));
    TwoWaysBar twoWaysBar1 = this.n;
    twoWaysBar1.d = 3;
    twoWaysBar1.a(this.A, this.aE.length);
    this.n.setTwoWaysBarListner((TwoWaysBar.TwoWaysBarListner)new TwoWaysBar.TowWaysBarListenerAdapter(this) {
          public void a(int param1Int1, int param1Int2) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(param1Int1);
            stringBuilder.append("-");
            stringBuilder.append(param1Int2);
            String str = stringBuilder.toString();
            if (FilterFragment.x(this.a)) {
              BluedPreferences.m(str);
            } else {
              BluedPreferences.l(str);
            } 
            FilterFragment.z(this.a).setText(FilterHelper.d().c(str));
            FilterFragment.a(this.a, true);
            FilterFragment.b(this.a);
          }
        });
    this.y = BluedPreferences.R();
    r();
    this.as = (PhotoGridView)this.e.findViewById(2131297351);
    this.as.setOnItemClickListener(new AdapterView.OnItemClickListener(this, str3) {
          public void onItemClick(AdapterView<?> param1AdapterView, View param1View, int param1Int, long param1Long) {
            if (((UserTag)FilterFragment.A(this.b).get(param1Int)).checked == 1) {
              ((UserTag)FilterFragment.A(this.b).get(param1Int)).checked = 0;
            } else {
              ((UserTag)FilterFragment.A(this.b).get(param1Int)).checked = 1;
            } 
            for (UserTag userTag : FilterFragment.A(this.b)) {
              if (!userTag.id.equals(((UserTag)FilterFragment.A(this.b).get(param1Int)).id))
                userTag.checked = 0; 
            } 
            StringBuffer stringBuffer = new StringBuffer();
            for (UserTag userTag : FilterFragment.A(this.b)) {
              if (userTag.checked == 1) {
                if (userTag.name.equals(this.a)) {
                  stringBuffer.append("-1");
                  break;
                } 
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(userTag.id);
                stringBuilder.append(",");
                stringBuffer.append(stringBuilder.toString());
              } 
            } 
            FilterFragment.a(this.b, stringBuffer.toString());
            FilterFragment.B(this.b).notifyDataSetChanged();
          }
        });
    this.az = new UserTagAdapter(this.q, this.al);
    this.as.setAdapter((ListAdapter)this.az);
    this.B = BluedPreferences.T();
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append("fiter_choosedTagId====");
    stringBuilder1.append(this.B);
    Logger.c(stringBuilder1.toString(), new Object[0]);
    this.C = BluedPreferences.U();
    this.Z.setText(this.C);
    this.D = BluedPreferences.V();
    this.aa.setText(this.D);
    this.s = BluedPreferences.O();
    this.t = BluedPreferences.P();
    this.u = BluedPreferences.Q();
    this.v = BluedPreferences.W();
    if (BluedPreferences.O()) {
      this.H.setImageResource(2131234234);
    } else {
      this.H.setImageResource(2131234233);
    } 
    if (BluedPreferences.P()) {
      this.I.setImageResource(2131234234);
    } else {
      this.I.setImageResource(2131234233);
    } 
    if (BluedPreferences.Q()) {
      this.J.setImageResource(2131234234);
    } else {
      this.J.setImageResource(2131234233);
    } 
    if (BluedPreferences.W()) {
      this.K.setImageResource(2131234234);
    } else {
      this.K.setImageResource(2131234233);
    } 
    this.H.setOnClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            if (BluedPreferences.O()) {
              FilterFragment.C(this.a).setImageResource(2131234233);
            } else {
              FilterFragment.C(this.a).setImageResource(2131234234);
            } 
            BluedPreferences.b(BluedPreferences.O() ^ true);
            FilterFragment.a(this.a, true);
            FilterFragment.b(this.a);
          }
        });
    this.I.setOnClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            if (BluedPreferences.P()) {
              FilterFragment.D(this.a).setImageResource(2131234233);
            } else {
              FilterFragment.D(this.a).setImageResource(2131234234);
            } 
            BluedPreferences.c(BluedPreferences.P() ^ true);
            FilterFragment.a(this.a, true);
            FilterFragment.b(this.a);
          }
        });
    this.G.setOnClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            FilterFragment.E(this.a).setVisibility(8);
            BluedPreferences.aH();
            BluedPreferences.a(BluedPreferences.G() ^ true);
            if (BluedPreferences.G()) {
              FilterFragment.F(this.a).setImageResource(2131234234);
              FilterFragment.G(this.a).setVisibility(8);
            } else {
              FilterFragment.F(this.a).setImageResource(2131234233);
              FilterFragment.G(this.a).setVisibility(0);
            } 
            FilterFragment.a(this.a, true);
          }
        });
    this.L.setOnClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            String str1 = this.a.getString(2131756492);
            String[] arrayOfString = this.a.getResources().getStringArray(2130903098);
            String str2 = BluedPreferences.S();
            MultiSelectFragment.a((Fragment)this.a, 0, str1, arrayOfString, str2, null);
          }
        });
    this.M.setOnClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            FilterFragment.E(this.a).setVisibility(8);
            BluedPreferences.aH();
          }
        });
    this.N.setOnClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {}
        });
    this.O.setOnClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {}
        });
    this.aI = (TextView)this.e.findViewById(2131300655);
    this.aI.setOnClickListener(this);
  }
  
  private void r() {
    String[] arrayOfString = getResources().getStringArray(2130903104);
    String str1 = getResources().getString(2131759104);
    boolean bool = false;
    arrayOfString[0] = str1;
    String str2 = BluedPreferences.R();
    boolean bool1 = TextUtils.isEmpty(str2);
    int[] arrayOfInt = null;
    if (!bool1) {
      String[] arrayOfString1 = str2.split(",");
    } else {
      str1 = null;
    } 
    if (BlueAppLocal.d())
      arrayOfInt = UserRelationshipUtils.l; 
    int i;
    for (i = 0; i < arrayOfString.length; i++) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(i);
      stringBuilder.append("");
      UserTag userTag = new UserTag(stringBuilder.toString(), arrayOfString[i], 0);
      this.al.add(userTag);
    } 
    if (arrayOfInt != null && arrayOfInt.length > 0) {
      ArrayList<Integer> arrayList = new ArrayList();
      int j = arrayOfInt.length;
      for (i = 0; i < j; i++)
        arrayList.add(Integer.valueOf(arrayOfInt[i])); 
      for (i = 0; i < this.al.size(); i = j + 1) {
        j = i;
        if (arrayList.contains(Integer.valueOf(i))) {
          this.al.remove(i);
          j = i - 1;
        } 
      } 
    } 
    if (str2.equals("-1") && this.al.size() > 0) {
      ((UserTag)this.al.get(0)).checked = 1;
      return;
    } 
    if (str1 != null && str1.length > 0) {
      ArrayList<String> arrayList = new ArrayList();
      int j = str1.length;
      for (i = bool; i < j; i++) {
        String str = str1[i];
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(Integer.valueOf(str).intValue() - 1);
        stringBuilder.append("");
        arrayList.add(stringBuilder.toString());
      } 
      for (UserTag userTag : this.al) {
        if (arrayList.contains(userTag.id))
          userTag.checked = 1; 
      } 
    } 
  }
  
  private boolean s() {
    return (this.r != BluedPreferences.G());
  }
  
  private boolean t() {
    boolean bool = true;
    String[] arrayOfString = a(true);
    if (arrayOfString.length > 2) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("lookModify===:");
      stringBuilder.append(arrayOfString[2]);
      stringBuilder.append("===本地:");
      stringBuilder.append(BluedPreferences.V());
      Logger.e("isModified", new Object[] { stringBuilder.toString() });
      if (!c(arrayOfString[1])) {
        if (d(arrayOfString[2]))
          return true; 
        bool = false;
      } 
      return bool;
    } 
    return false;
  }
  
  private boolean u() {
    return (v() || s() || D() || C() || B() || A() || G() || F() || E() || z() || y() || x() || t() || w());
  }
  
  private boolean v() {
    HashSet<String> hashSet = new HashSet();
    for (UserTag userTag : this.ah) {
      if (userTag.checked == 1) {
        hashSet.add(userTag.id);
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append("isMakeFriendModify=id==");
        stringBuilder1.append(userTag.id.hashCode());
        Logger.e("isModified", new Object[] { stringBuilder1.toString() });
      } 
    } 
    if (this.aH.size() != hashSet.size())
      return true; 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("isMakeFriendModify=default==");
    stringBuilder.append(this.aH);
    stringBuilder.append("===curret=:");
    stringBuilder.append(hashSet);
    Logger.e("isModified", new Object[] { stringBuilder.toString() });
    for (String str : this.aH) {
      if (!hashSet.contains(str)) {
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append("isMakeFriendModify=tag==");
        stringBuilder1.append(str.hashCode());
        Logger.e("isModified", new Object[] { stringBuilder1.toString() });
        return true;
      } 
    } 
    Logger.e("isModified", new Object[] { "isMakeFriendModify=tag=fffff=false" });
    return false;
  }
  
  private boolean w() {
    return ((TextUtils.isEmpty(this.y) && !TextUtils.isEmpty(BluedPreferences.R())) || !this.y.equals(BluedPreferences.R()));
  }
  
  private boolean x() {
    String str;
    if (this.aG) {
      str = BluedPreferences.N();
    } else {
      str = BluedPreferences.M();
    } 
    return ((TextUtils.isEmpty(this.A) && !TextUtils.isEmpty(str)) || !this.A.equals(str));
  }
  
  private boolean y() {
    String str;
    if (this.aG) {
      str = BluedPreferences.L();
    } else {
      str = BluedPreferences.K();
    } 
    return ((TextUtils.isEmpty(this.z) && !TextUtils.isEmpty(str)) || !this.z.equals(str));
  }
  
  private boolean z() {
    return ((TextUtils.isEmpty(this.x) && !TextUtils.isEmpty(BluedPreferences.J())) || !this.x.equals(BluedPreferences.J()));
  }
  
  public boolean V_() {
    H();
    return super.V_();
  }
  
  public void a() {
    if (this.R.getVisibility() == 0) {
      this.ac.setImageDrawable(BluedSkinUtils.b(this.q, 2131232373));
    } else {
      this.ac.setImageDrawable(BluedSkinUtils.b(this.q, 2131232373));
    } 
    if (this.S.getVisibility() == 0) {
      this.ad.setImageDrawable(BluedSkinUtils.b(this.q, 2131232373));
      return;
    } 
    this.ad.setImageDrawable(BluedSkinUtils.b(this.q, 2131232373));
  }
  
  public void a(View paramView) {
    ValueAnimator valueAnimator = ValueAnimator.ofInt(new int[] { 0, ViewUtils.b(paramView) });
    valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(this, paramView) {
          public void onAnimationUpdate(ValueAnimator param1ValueAnimator) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams)this.a.getLayoutParams();
            layoutParams.height = ((Integer)param1ValueAnimator.getAnimatedValue()).intValue();
            this.a.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
          }
        });
    valueAnimator.setDuration(300L);
    valueAnimator.addListener(new Animator.AnimatorListener(this, paramView) {
          public void onAnimationCancel(Animator param1Animator) {}
          
          public void onAnimationEnd(Animator param1Animator) {
            this.a.setVisibility(0);
            this.b.a();
          }
          
          public void onAnimationRepeat(Animator param1Animator) {}
          
          public void onAnimationStart(Animator param1Animator) {
            this.a.setVisibility(0);
          }
        });
    valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(this, paramView) {
          public void onAnimationUpdate(ValueAnimator param1ValueAnimator) {
            int i = ((Integer)param1ValueAnimator.getAnimatedValue()).intValue();
            ViewGroup.LayoutParams layoutParams = this.a.getLayoutParams();
            layoutParams.height = i;
            this.a.setLayoutParams(layoutParams);
          }
        });
    valueAnimator.start();
  }
  
  public void a(View paramView, List<UserTag> paramList, UserTagAdapter paramUserTagAdapter, int paramInt) {
    if (((UserTag)paramList.get(paramInt)).checked == 1) {
      ((UserTag)paramList.get(paramInt)).checked = 0;
    } else {
      ((UserTag)paramList.get(paramInt)).checked = 1;
    } 
    paramUserTagAdapter.notifyDataSetChanged();
    if (paramView.getId() != 2131297352 || paramView.getId() != 2131297351) {
      String[] arrayOfString = a(true);
      String str1 = arrayOfString[1];
      String str2 = arrayOfString[2];
      this.Z.setText(str1);
      this.aa.setText(str2);
    } 
    this.aF = true;
  }
  
  public void a(LinearLayout paramLinearLayout) {
    a((View)paramLinearLayout);
  }
  
  public void a(String paramString) {
    if (!StringUtils.e(paramString)) {
      String[] arrayOfString = paramString.split(",");
      for (int i = 0; i < arrayOfString.length; i++) {
        if (this.af != null)
          for (int j = 0; j < this.af.size(); j++) {
            if (arrayOfString[i].equals(((UserTag)this.af.get(j)).id)) {
              ((UserTag)this.af.get(j)).checked = 1;
              break;
            } 
          }  
        if (this.ag != null)
          for (int j = 0; j < this.ag.size(); j++) {
            if (arrayOfString[i].equals(((UserTag)this.ag.get(j)).id)) {
              ((UserTag)this.ag.get(j)).checked = 1;
              break;
            } 
          }  
        if (this.ai != null)
          for (int j = 0; j < this.ai.size(); j++) {
            if (arrayOfString[i].equals(((UserTag)this.ai.get(j)).id)) {
              ((UserTag)this.ai.get(j)).checked = 1;
              break;
            } 
          }  
        if (this.aj != null)
          for (int j = 0; j < this.aj.size(); j++) {
            if (arrayOfString[i].equals(((UserTag)this.aj.get(j)).id)) {
              ((UserTag)this.aj.get(j)).checked = 1;
              break;
            } 
          }  
        if (this.ah != null)
          for (int j = 0; j < this.ah.size(); j++) {
            if (arrayOfString[i].equals(((UserTag)this.ah.get(j)).id)) {
              ((UserTag)this.ah.get(j)).checked = 1;
              this.aH.add(((UserTag)this.ah.get(j)).id);
              break;
            } 
          }  
      } 
    } else {
      for (int i = 0; i < this.af.size(); i++)
        ((UserTag)this.af.get(i)).checked = 0; 
    } 
  }
  
  public String[] a(boolean paramBoolean) {
    StringBuffer stringBuffer1 = new StringBuffer();
    StringBuffer stringBuffer2 = new StringBuffer();
    StringBuffer stringBuffer3 = new StringBuffer();
    if (this.af != null)
      for (int i = 0; i < this.af.size(); i++) {
        if (((UserTag)this.af.get(i)).checked == 1) {
          String str;
          StringBuilder stringBuilder = new StringBuilder();
          if (StringUtils.e(stringBuffer1.toString())) {
            str = "";
          } else {
            str = ",";
          } 
          stringBuilder.append(str);
          stringBuilder.append(((UserTag)this.af.get(i)).id);
          stringBuffer1.append(stringBuilder.toString());
          stringBuilder = new StringBuilder();
          if (StringUtils.e(stringBuffer2.toString())) {
            str = "";
          } else {
            str = ",";
          } 
          stringBuilder.append(str);
          stringBuilder.append(((UserTag)this.af.get(i)).name);
          stringBuffer2.append(stringBuilder.toString());
        } 
      }  
    if (this.ag != null)
      for (int i = 0; i < this.ag.size(); i++) {
        if (((UserTag)this.ag.get(i)).checked == 1) {
          String str;
          StringBuilder stringBuilder = new StringBuilder();
          if (StringUtils.e(stringBuffer1.toString())) {
            str = "";
          } else {
            str = ",";
          } 
          stringBuilder.append(str);
          stringBuilder.append(((UserTag)this.ag.get(i)).id);
          stringBuffer1.append(stringBuilder.toString());
          stringBuilder = new StringBuilder();
          if (StringUtils.e(stringBuffer2.toString())) {
            str = "";
          } else {
            str = ",";
          } 
          stringBuilder.append(str);
          stringBuilder.append(((UserTag)this.ag.get(i)).name);
          stringBuffer2.append(stringBuilder.toString());
        } 
      }  
    if (this.ai != null)
      for (int i = 0; i < this.ai.size(); i++) {
        if (((UserTag)this.ai.get(i)).checked == 1) {
          String str;
          StringBuilder stringBuilder = new StringBuilder();
          if (StringUtils.e(stringBuffer1.toString())) {
            str = "";
          } else {
            str = ",";
          } 
          stringBuilder.append(str);
          stringBuilder.append(((UserTag)this.ai.get(i)).id);
          stringBuffer1.append(stringBuilder.toString());
          stringBuilder = new StringBuilder();
          if (StringUtils.e(stringBuffer3.toString())) {
            str = "";
          } else {
            str = ",";
          } 
          stringBuilder.append(str);
          stringBuilder.append(((UserTag)this.ai.get(i)).name);
          stringBuffer3.append(stringBuilder.toString());
        } 
      }  
    if (this.aj != null)
      for (int i = 0; i < this.aj.size(); i++) {
        if (((UserTag)this.aj.get(i)).checked == 1) {
          String str;
          StringBuilder stringBuilder = new StringBuilder();
          if (StringUtils.e(stringBuffer1.toString())) {
            str = "";
          } else {
            str = ",";
          } 
          stringBuilder.append(str);
          stringBuilder.append(((UserTag)this.aj.get(i)).id);
          stringBuffer1.append(stringBuilder.toString());
          stringBuilder = new StringBuilder();
          if (StringUtils.e(stringBuffer3.toString())) {
            str = "";
          } else {
            str = ",";
          } 
          stringBuilder.append(str);
          stringBuilder.append(((UserTag)this.aj.get(i)).name);
          stringBuffer3.append(stringBuilder.toString());
        } 
      }  
    if (!paramBoolean && this.ah != null)
      for (int i = 0; i < this.ah.size(); i++) {
        if (((UserTag)this.ah.get(i)).checked == 1) {
          String str;
          StringBuilder stringBuilder = new StringBuilder();
          if (StringUtils.e(stringBuffer1.toString())) {
            str = "";
          } else {
            str = ",";
          } 
          stringBuilder.append(str);
          stringBuilder.append(((UserTag)this.ah.get(i)).id);
          stringBuffer1.append(stringBuilder.toString());
          stringBuilder = new StringBuilder();
          if (StringUtils.e(stringBuffer3.toString())) {
            str = "";
          } else {
            str = ",";
          } 
          stringBuilder.append(str);
          stringBuilder.append(((UserTag)this.ah.get(i)).name);
          stringBuffer3.append(stringBuilder.toString());
        } 
      }  
    return new String[] { stringBuffer1.toString(), stringBuffer2.toString(), stringBuffer3.toString() };
  }
  
  public void b(View paramView) {
    ValueAnimator valueAnimator = ValueAnimator.ofInt(new int[] { ViewUtils.b(paramView), 0 });
    valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(this, paramView) {
          public void onAnimationUpdate(ValueAnimator param1ValueAnimator) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams)this.a.getLayoutParams();
            layoutParams.height = ((Integer)param1ValueAnimator.getAnimatedValue()).intValue();
            this.a.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
          }
        });
    valueAnimator.setDuration(300L);
    valueAnimator.addListener(new Animator.AnimatorListener(this, paramView) {
          public void onAnimationCancel(Animator param1Animator) {}
          
          public void onAnimationEnd(Animator param1Animator) {
            this.a.setVisibility(8);
            this.b.a();
          }
          
          public void onAnimationRepeat(Animator param1Animator) {}
          
          public void onAnimationStart(Animator param1Animator) {
            this.a.setVisibility(0);
          }
        });
    valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(this, paramView) {
          public void onAnimationUpdate(ValueAnimator param1ValueAnimator) {
            int i = ((Integer)param1ValueAnimator.getAnimatedValue()).intValue();
            ViewGroup.LayoutParams layoutParams = this.a.getLayoutParams();
            layoutParams.height = i;
            this.a.setLayoutParams(layoutParams);
          }
        });
    valueAnimator.start();
  }
  
  public void b(LinearLayout paramLinearLayout) {
    b((View)paramLinearLayout);
  }
  
  public void b(String paramString) {
    UserTag userTag1 = new UserTag("1", this.q.getResources().getString(2131756489), 0);
    UserTag userTag2 = new UserTag("0.5", this.q.getResources().getString(2131756484), 0);
    UserTag userTag3 = new UserTag("0", this.q.getResources().getString(2131756500), 0);
    UserTag userTag4 = new UserTag("-1", this.q.getResources().getString(2131756491), 0);
    UserTag userTag5 = new UserTag("0.75", this.q.getResources().getString(2131758635), 0);
    UserTag userTag6 = new UserTag("0.25", this.q.getResources().getString(2131758633), 0);
    this.ak.add(userTag1);
    this.ak.add(userTag5);
    this.ak.add(userTag2);
    this.ak.add(userTag6);
    this.ak.add(userTag3);
    this.ak.add(userTag4);
    if (!StringUtils.e(paramString)) {
      String[] arrayOfString = paramString.split(",");
      for (int i = 0; i < arrayOfString.length; i++) {
        String str = arrayOfString[i];
        for (int j = 0; j < this.ak.size(); j++) {
          userTag2 = this.ak.get(j);
          if (userTag2.id.equalsIgnoreCase(str))
            userTag2.checked = 1; 
        } 
      } 
    } 
  }
  
  public void k() {
    FindHttpUtils.a(this.q, new BluedUIHttpResponse<BluedEntityA<UserTagAll>>(this) {
          public void a(BluedEntityA<UserTagAll> param1BluedEntityA) {
            if (param1BluedEntityA != null)
              try {
                if (param1BluedEntityA.data != null && param1BluedEntityA.data.size() > 0) {
                  FilterFragment.a(this.a, ((UserTagAll)param1BluedEntityA.data.get(0)).type);
                  if (FilterFragment.f(this.a) != null)
                    for (int i = 0; i < FilterFragment.f(this.a).size(); i++)
                      ((UserTag)FilterFragment.f(this.a).get(i)).checked = 0;  
                  FilterFragment.b(this.a, ((UserTagAll)param1BluedEntityA.data.get(0)).character);
                  if (FilterFragment.i(this.a) != null)
                    for (int i = 0; i < FilterFragment.i(this.a).size(); i++)
                      ((UserTag)FilterFragment.i(this.a).get(i)).checked = 0;  
                  FilterFragment.c(this.a, ((UserTagAll)param1BluedEntityA.data.get(0)).love_type);
                  if (FilterFragment.l(this.a) != null)
                    for (int i = 0; i < FilterFragment.l(this.a).size(); i++)
                      ((UserTag)FilterFragment.l(this.a).get(i)).checked = 0;  
                  FilterFragment.d(this.a, ((UserTagAll)param1BluedEntityA.data.get(0)).love_character);
                  if (FilterFragment.r(this.a) != null)
                    for (int i = 0; i < FilterFragment.r(this.a).size(); i++)
                      ((UserTag)FilterFragment.r(this.a).get(i)).checked = 0;  
                  FilterFragment.e(this.a, ((UserTagAll)param1BluedEntityA.data.get(0)).i_want);
                  if (FilterFragment.o(this.a) != null)
                    for (int i = 0; i < FilterFragment.o(this.a).size(); i++)
                      ((UserTag)FilterFragment.o(this.a).get(i)).checked = 0;  
                  this.a.a(FilterFragment.J(this.a));
                  FilterFragment.a(this.a, new UserTagAdapter(FilterFragment.d(this.a), FilterFragment.f(this.a)));
                  FilterFragment.b(this.a, new UserTagAdapter(FilterFragment.d(this.a), FilterFragment.i(this.a)));
                  FilterFragment.c(this.a, new UserTagAdapter(FilterFragment.d(this.a), FilterFragment.l(this.a)));
                  FilterFragment.d(this.a, new UserTagAdapter(FilterFragment.d(this.a), FilterFragment.r(this.a)));
                  FilterFragment.e(this.a, new UserTagAdapter(FilterFragment.d(this.a), FilterFragment.o(this.a)));
                  FilterFragment.e(this.a).setAdapter((ListAdapter)FilterFragment.g(this.a));
                  FilterFragment.h(this.a).setAdapter((ListAdapter)FilterFragment.j(this.a));
                  FilterFragment.k(this.a).setAdapter((ListAdapter)FilterFragment.m(this.a));
                  FilterFragment.q(this.a).setAdapter((ListAdapter)FilterFragment.s(this.a));
                  FilterFragment.n(this.a).setAdapter((ListAdapter)FilterFragment.p(this.a));
                  return;
                } 
              } catch (Exception exception) {
                exception.printStackTrace();
                AppMethods.a(FilterFragment.d(this.a).getResources().getString(2131756082));
              }  
          }
          
          public void onUIFinish() {
            DialogUtils.b(FilterFragment.I(this.a));
          }
          
          public void onUIStart() {
            DialogUtils.a(FilterFragment.I(this.a));
          }
        }(IRequestHost)w_());
  }
  
  public String[] l() {
    return a(false);
  }
  
  public String m() {
    List<UserTag> list = this.ak;
    String str = "";
    if (list != null) {
      int i = 0;
      for (str = ""; i < this.ak.size(); str = str1) {
        String str1 = str;
        if (((UserTag)this.ak.get(i)).checked == 1) {
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append(str);
          if (StringUtils.e(str)) {
            str = "";
          } else {
            str = ",";
          } 
          stringBuilder.append(str);
          stringBuilder.append(((UserTag)this.ak.get(i)).id);
          str1 = stringBuilder.toString();
        } 
        i++;
      } 
    } 
    return str;
  }
  
  public void n() {
    CommonTopTitleNoTrans commonTopTitleNoTrans = this.f;
    if (commonTopTitleNoTrans != null && commonTopTitleNoTrans.getLeftImg() != null)
      this.f.getLeftImg().performClick(); 
  }
  
  public void onActivityCreated(Bundle paramBundle) {
    super.onActivityCreated(paramBundle);
    this.M.setFocusable(true);
    this.M.setFocusableInTouchMode(true);
    this.M.requestFocus();
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {
    if (paramInt2 == 0)
      return; 
    String str = this.q.getResources().getString(2131759104);
    if (paramInt1 != 0) {
      if (paramInt1 == 7) {
        this.aF = true;
        e(paramIntent.getStringExtra("SELECTEDID"));
      } 
    } else {
      StringBuffer stringBuffer;
      this.aF = true;
      BluedPreferences.o(paramIntent.getStringExtra("SELETEDPOSITION"));
      String str1 = BluedPreferences.S();
      if (!StringUtils.e(str1)) {
        if ("-1".equals(str1)) {
          this.V.setText(str);
        } else {
          stringBuffer = new StringBuffer();
          String[] arrayOfString = str1.split(",");
          int i;
          for (i = 0; i < arrayOfString.length; i++) {
            String str2 = arrayOfString[i];
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(this.aB[Integer.parseInt(str2)]);
            stringBuilder.append(",");
            stringBuffer.append(stringBuilder.toString());
          } 
          stringBuffer.deleteCharAt(stringBuffer.length() - 1);
          this.V.setText(stringBuffer.toString());
        } 
      } else {
        this.V.setText(stringBuffer);
      } 
    } 
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public void onClick(View paramView) {
    List<UserTag> list;
    switch (paramView.getId()) {
      default:
        return;
      case 2131298805:
        if (this.S.getVisibility() == 8) {
          a(this.S);
          if (this.R.getVisibility() == 0) {
            b(this.R);
            return;
          } 
        } else {
          b(this.S);
          return;
        } 
        return;
      case 2131298804:
        if (this.R.getVisibility() == 8) {
          a(this.R);
          if (this.S.getVisibility() == 0) {
            b(this.S);
            return;
          } 
        } else {
          b(this.R);
          return;
        } 
        return;
      case 2131296867:
      case 2131300655:
        J();
        list = this.af;
        if (list == null || list.size() == 0) {
          BluedPreferences.p(this.B);
          BluedPreferences.q(this.C);
          BluedPreferences.r(this.D);
        } else {
          String[] arrayOfString = l();
          BluedPreferences.p(arrayOfString[0]);
          BluedPreferences.q(arrayOfString[1]);
          BluedPreferences.r(a(true)[2]);
        } 
        filterDialogFragment = this.d;
        if (filterDialogFragment != null)
          filterDialogFragment.dismiss(); 
        if (this.aF)
          PeopleDataObserver.a().b(); 
        EventTrackGuy.b(GuyProtos.Event.NEARBY_FRIEND_FILTER_COMPLETE_BTN_CLICK, NearbyHttpUtils.a(NearbyHttpUtils.a(this.q, new FilterEntity())));
        return;
      case 2131296863:
        break;
    } 
    if (u()) {
      CommonAlertDialog.a(this.q, getString(2131756094), getResources().getString(2131756479), getString(2131756086), new DialogInterface.OnClickListener(this) {
            public void onClick(DialogInterface param1DialogInterface, int param1Int) {
              FilterFragment.H(this.a);
              if (this.a.d != null)
                this.a.d.dismiss(); 
            }
          },  getString(2131756057), null, null);
      return;
    } 
    FilterDialogFragment filterDialogFragment = this.d;
    if (filterDialogFragment != null)
      filterDialogFragment.dismiss(); 
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
    this.q = (Context)getActivity();
    View view = this.e;
    if (view == null) {
      this.e = paramLayoutInflater.inflate(2131494075, paramViewGroup, false);
      o();
      q();
      I();
      k();
    } else if (view.getParent() != null) {
      ((ViewGroup)this.e.getParent()).removeView(this.e);
    } 
    return this.e;
  }
  
  public void onDestroy() {
    super.onDestroy();
    FilterHelper.d().f();
  }
  
  public void onResume() {
    super.onResume();
    if (this.K != null && this.J != null) {
      if ((UserInfo.a().i()).vip_grade == 0 && (BluedConfig.b().j()).is_filter_vip == 0) {
        this.K.setOnClickListener(new View.OnClickListener(this) {
              public void onClick(View param1View) {
                boolean bool;
                GuyProtos.Event event = GuyProtos.Event.SCREEN_VIP_USER_BTN_CLICK;
                if ((UserInfo.a().i()).vip_grade != 0) {
                  bool = true;
                } else {
                  bool = false;
                } 
                EventTrackGuy.a(event, bool);
                PayUtils.a((Context)this.a.getActivity(), 24, "nearby_filter_vip_user");
              }
            });
        this.J.setOnClickListener(new View.OnClickListener(this) {
              public void onClick(View param1View) {
                boolean bool;
                GuyProtos.Event event = GuyProtos.Event.SCREEN_AUTH_USER_BTN_CLICK;
                if ((UserInfo.a().i()).vip_grade != 0) {
                  bool = true;
                } else {
                  bool = false;
                } 
                EventTrackGuy.a(event, bool);
                PayUtils.a((Context)this.a.getActivity(), 24, "nearby_filter_auth_user");
              }
            });
        return;
      } 
      this.K.setOnClickListener(new View.OnClickListener(this) {
            public void onClick(View param1View) {
              boolean bool;
              GuyProtos.Event event = GuyProtos.Event.SCREEN_VIP_USER_BTN_CLICK;
              if ((UserInfo.a().i()).vip_grade != 0) {
                bool = true;
              } else {
                bool = false;
              } 
              EventTrackGuy.a(event, bool);
              FilterFragment.a(this.a, true);
              if (BluedPreferences.W()) {
                FilterFragment.a(this.a).setImageResource(2131234233);
              } else {
                FilterFragment.a(this.a).setImageResource(2131234234);
              } 
              BluedPreferences.e(BluedPreferences.W() ^ true);
              FilterFragment.b(this.a);
            }
          });
      this.J.setOnClickListener(new View.OnClickListener(this) {
            public void onClick(View param1View) {
              boolean bool;
              GuyProtos.Event event = GuyProtos.Event.SCREEN_AUTH_USER_BTN_CLICK;
              if ((UserInfo.a().i()).vip_grade != 0) {
                bool = true;
              } else {
                bool = false;
              } 
              EventTrackGuy.a(event, bool);
              FilterFragment.a(this.a, true);
              if (BluedPreferences.Q()) {
                FilterFragment.c(this.a).setImageResource(2131234233);
              } else {
                FilterFragment.c(this.a).setImageResource(2131234234);
              } 
              BluedPreferences.d(BluedPreferences.Q() ^ true);
              FilterFragment.b(this.a);
            }
          });
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\find\fragment\FilterFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */