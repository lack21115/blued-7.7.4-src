package com.soft.blued.ui.find.view;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.core.AppInfo;
import com.blued.android.core.BlueAppLocal;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.das.guy.GuyProtos;
import com.soft.blued.log.trackUtils.EventTrackGuy;
import com.soft.blued.ui.find.adapter.RecommendMixedInNearbyAdapter;
import com.soft.blued.ui.find.fragment.HelloOpenDialogFragment;
import com.soft.blued.ui.find.fragment.HelloStateDialogFragment;
import com.soft.blued.ui.find.manager.CallHelloManager;
import com.soft.blued.ui.find.model.CallMeStatusData;
import com.soft.blued.ui.find.model.FindRecommendData;
import com.soft.blued.ui.find.model.FindRecommendExtra;
import com.soft.blued.ui.find.observer.NearbyViewModel;
import com.soft.blued.ui.home.HomeActivity;
import com.soft.blued.ui.login_register.model.AppConfigModel;
import com.soft.blued.ui.web.WebViewShowInfoFragment;
import com.soft.blued.user.BluedConfig;
import com.soft.blued.user.UserInfo;
import com.soft.blued.utils.BluedPreferences;
import com.soft.blued.utils.TimeAndDateUtils;
import com.soft.blued.view.tip.CommonAlertDialog;
import com.soft.blued.view.tip.pop.BluedPopupWindow;
import java.util.Date;
import java.util.List;

public class RecommendViewMixedInNearby extends FrameLayout implements View.OnClickListener {
  private static int B;
  
  private static int C;
  
  private BluedPopupWindow A;
  
  private BluedPopupWindow D;
  
  private boolean E;
  
  private Context a;
  
  private TextView b;
  
  private TextView c;
  
  private TextView d;
  
  private RecyclerView e;
  
  private TextView f;
  
  private IRequestHost g;
  
  private ConstraintLayout h;
  
  private ImageView i;
  
  private ImageView j;
  
  private RecommendMixedInNearbyAdapter k;
  
  private boolean l = true;
  
  private int m = 0;
  
  private View n;
  
  private ImageView o;
  
  private TextView p;
  
  private View q;
  
  private ImageView r;
  
  private TextView s;
  
  private View t;
  
  private View u;
  
  private ImageView v;
  
  private NearbyViewModel w;
  
  private boolean x = false;
  
  private View y;
  
  private BluedPopupWindow z;
  
  public RecommendViewMixedInNearby(Context paramContext) {
    super(paramContext, null);
  }
  
  public RecommendViewMixedInNearby(Context paramContext, AttributeSet paramAttributeSet) {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public RecommendViewMixedInNearby(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
    this.a = getContext();
    a(paramContext);
  }
  
  private void a(Context paramContext) {
    View view = View.inflate(paramContext, 2131494240, null);
    this.t = View.inflate(paramContext, 2131493788, null);
    this.b = (TextView)view.findViewById(2131301409);
    this.c = (TextView)view.findViewById(2131301050);
    this.e = (RecyclerView)view.findViewById(2131299606);
    this.i = (ImageView)view.findViewById(2131297945);
    this.u = view.findViewById(2131299701);
    this.v = (ImageView)view.findViewById(2131297754);
    this.d = (TextView)this.t.findViewById(2131300606);
    this.h = (ConstraintLayout)this.t.findViewById(2131296757);
    this.j = (ImageView)this.t.findViewById(2131297713);
    this.f = (TextView)this.t.findViewById(2131300890);
    addView(view, (ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, -2));
    setVisibility(4);
    this.d.setOnClickListener(this);
    if (HomeActivity.c != null)
      this.w = (NearbyViewModel)ViewModelProviders.of((FragmentActivity)HomeActivity.c).get(NearbyViewModel.class); 
  }
  
  private void c(int paramInt) {
    CallMeStatusData callMeStatusData = getCallData();
    if (callMeStatusData != null && callMeStatusData.call_status == 5) {
      HelloStateDialogFragment.a(getContext(), callMeStatusData);
      CallHelloManager.a().a(getContext(), this.g, paramInt, null);
      return;
    } 
    CallHelloManager.a().a(getContext(), this.g, paramInt, new CallHelloManager.ToOpenListener(this, paramInt) {
          public void a(boolean param1Boolean) {
            if (param1Boolean)
              CallHelloManager.a().a(this.b.getContext(), RecommendViewMixedInNearby.e(this.b), false, this.a); 
          }
        });
  }
  
  private void c(CallMeStatusData paramCallMeStatusData) {
    BluedPopupWindow bluedPopupWindow = this.A;
    if (bluedPopupWindow == null || !bluedPopupWindow.isShowing()) {
      bluedPopupWindow = this.z;
      if ((bluedPopupWindow == null || !bluedPopupWindow.isShowing()) && HomeActivity.c != null && "find".equals(HomeActivity.c.h()) && this.q.getGlobalVisibleRect(new Rect())) {
        if (!j())
          return; 
        if (this.D == null && paramCallMeStatusData != null) {
          View view = this.q;
          if (view != null && view.getVisibility() == 0) {
            view = View.inflate(getContext(), 2131494030, null);
            ImageView imageView = (ImageView)view.findViewById(2131297731);
            this.D = BluedPopupWindow.Builder.a((Activity)getContext(), view).a(true).a();
            imageView.setOnClickListener(new View.OnClickListener(this, paramCallMeStatusData) {
                  public void onClick(View param1View) {
                    GuyProtos.VocativeStatus vocativeStatus;
                    RecommendViewMixedInNearby.b(this.b, 3);
                    GuyProtos.Event event = GuyProtos.Event.HOME_GUY_PAGE_VOCATIVE_BTN_CLICK;
                    CallMeStatusData callMeStatusData = this.a;
                    if (callMeStatusData != null && callMeStatusData.call_status == 1) {
                      vocativeStatus = GuyProtos.VocativeStatus.VOCATIVE_OPEN;
                    } else {
                      vocativeStatus = GuyProtos.VocativeStatus.VOCATIVE_CLOSE;
                    } 
                    EventTrackGuy.a(event, vocativeStatus);
                    EventTrackGuy.a(GuyProtos.Event.NEARBY_FRIEND_FILTER_BTN_CLICK);
                    RecommendViewMixedInNearby.o(this.b).dismiss();
                  }
                });
            ImageLoader.a(this.g, paramCallMeStatusData.free_bubble).a(imageView);
            this.D.setOnDismissListener(new PopupWindow.OnDismissListener(this) {
                  public void onDismiss() {
                    AppInfo.n().postDelayed(new Runnable(this) {
                          public void run() {
                            RecommendViewMixedInNearby.c(this.a.a, (BluedPopupWindow)null);
                          }
                        }3000L);
                  }
                });
            BluedPopupWindow bluedPopupWindow1 = this.D;
            view = this.q;
            bluedPopupWindow1.a(view, 2, 1, view.getWidth(), DensityUtils.a(getContext(), 5.0F));
          } 
        } 
      } 
    } 
  }
  
  private void f() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("updateBtnVisible show_call_btn:");
    stringBuilder.append(this.m);
    Log.v("drb", stringBuilder.toString());
    int i = this.m;
    if (i != 0) {
      if (i != 1) {
        if (i != 2)
          return; 
        this.h.setVisibility(8);
        View view2 = this.n;
        if (view2 != null)
          view2.setVisibility(8); 
        view2 = this.q;
        if (view2 != null)
          view2.setVisibility(0); 
        EventTrackGuy.b(GuyProtos.Event.HOME_GUY_PAGE_VOCATIVE_BTN_SHOW);
        return;
      } 
      this.h.setVisibility(0);
      View view1 = this.n;
      if (view1 != null)
        view1.setVisibility(8); 
      view1 = this.q;
      if (view1 != null)
        view1.setVisibility(8); 
      EventTrackGuy.b(GuyProtos.Event.HOME_GUY_PAGE_VOCATIVE_BTN_SHOW);
      return;
    } 
    this.h.setVisibility(8);
    View view = this.n;
    if (view != null)
      view.setVisibility(8); 
    view = this.q;
    if (view != null)
      view.setVisibility(8); 
  }
  
  private void g() {
    if (this.m == 0)
      return; 
    CallHelloManager.a().d();
  }
  
  private CallMeStatusData getCallData() {
    return CallHelloManager.a().b();
  }
  
  private void h() {
    String str;
    if (BlueAppLocal.d()) {
      if ("CN".equals(BlueAppLocal.c().getCountry().toUpperCase())) {
        str = "call_default_ch.png";
      } else {
        str = "call_default_tw.png";
      } 
    } else {
      str = "call_default_en.png";
    } 
    ImageLoader.c(this.g, str).f().e(-1).a(this.r);
  }
  
  private void i() {
    String str;
    if (BlueAppLocal.d()) {
      if ("CN".equals(BlueAppLocal.c().getCountry().toUpperCase())) {
        str = "call_open_ch.png";
      } else {
        str = "call_open_tw.png";
      } 
    } else {
      str = "call_open_en.png";
    } 
    ImageLoader.c(this.g, str).f().e(-1).a(this.r);
  }
  
  private boolean j() {
    View view = this.q;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (view != null) {
      bool1 = bool2;
      if (view.getVisibility() == 0) {
        int[] arrayOfInt = new int[2];
        this.q.getLocationOnScreen(arrayOfInt);
        int i = arrayOfInt[0];
        int j = arrayOfInt[1];
        bool1 = bool2;
        if (i != 0) {
          bool1 = bool2;
          if (j != 0)
            bool1 = true; 
        } 
      } 
    } 
    return bool1;
  }
  
  private void k() {
    int i = this.m;
    if (i == 1) {
      this.d.setBackgroundResource(2131232398);
      this.j.setVisibility(0);
      this.d.setText("");
    } else if (i == 2) {
      this.p.setText("");
      this.o.setVisibility(0);
      this.o.setImageResource(2131232396);
      this.n.setBackgroundResource(2131232402);
      this.q.setVisibility(0);
      this.y.setVisibility(8);
      this.r.setVisibility(0);
      h();
    } 
    CallHelloManager.a().c();
    CallHelloManager.a().e();
  }
  
  public void a() {
    setVisibility(8);
    NearbyViewModel nearbyViewModel = this.w;
    if (nearbyViewModel != null)
      nearbyViewModel.a.postValue(null); 
  }
  
  public void a(int paramInt) {
    Rect rect = new Rect();
    getHitRect(rect);
    rect.top -= paramInt;
    rect.bottom -= paramInt;
    if (rect.top < 0)
      rect.top = 0; 
    if (rect.bottom < 0)
      rect.bottom = 0; 
    NearbyViewModel nearbyViewModel = this.w;
    if (nearbyViewModel != null)
      nearbyViewModel.a.postValue(rect); 
  }
  
  public void a(View paramView1, View paramView2) {
    this.n = paramView1;
    this.q = paramView2;
    this.y = paramView2.findViewById(2131299691);
    this.s = (TextView)paramView2.findViewById(2131300604);
    this.r = (ImageView)paramView2.findViewById(2131297711);
    this.o = (ImageView)paramView1.findViewById(2131297714);
    this.p = (TextView)paramView1.findViewById(2131300608);
    this.n.setOnClickListener(this);
    this.q.setOnClickListener(this);
  }
  
  public void a(IRequestHost paramIRequestHost) {
    this.g = paramIRequestHost;
  }
  
  public void a(CallMeStatusData paramCallMeStatusData) {
    // Byte code:
    //   0: aload_0
    //   1: getfield m : I
    //   4: ifeq -> 969
    //   7: aload_1
    //   8: ifnonnull -> 14
    //   11: goto -> 969
    //   14: invokestatic a : ()Lcom/soft/blued/ui/find/manager/CallHelloManager;
    //   17: aload_1
    //   18: invokevirtual a : (Lcom/soft/blued/ui/find/model/CallMeStatusData;)V
    //   21: aload_0
    //   22: invokespecial k : ()V
    //   25: aload_0
    //   26: getfield m : I
    //   29: iconst_1
    //   30: if_icmpne -> 42
    //   33: aload_0
    //   34: getfield d : Landroid/widget/TextView;
    //   37: astore #4
    //   39: goto -> 48
    //   42: aload_0
    //   43: getfield p : Landroid/widget/TextView;
    //   46: astore #4
    //   48: aload_0
    //   49: getfield m : I
    //   52: iconst_1
    //   53: if_icmpne -> 65
    //   56: aload_0
    //   57: getfield j : Landroid/widget/ImageView;
    //   60: astore #5
    //   62: goto -> 71
    //   65: aload_0
    //   66: getfield o : Landroid/widget/ImageView;
    //   69: astore #5
    //   71: new java/lang/StringBuilder
    //   74: dup
    //   75: invokespecial <init> : ()V
    //   78: astore #6
    //   80: aload #6
    //   82: ldc_w 'notifySetCallDataUpdate data.call_status:'
    //   85: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   88: pop
    //   89: aload #6
    //   91: aload_1
    //   92: getfield call_status : I
    //   95: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   98: pop
    //   99: ldc_w 'drb'
    //   102: aload #6
    //   104: invokevirtual toString : ()Ljava/lang/String;
    //   107: invokestatic v : (Ljava/lang/String;Ljava/lang/String;)I
    //   110: pop
    //   111: aload_1
    //   112: getfield call_status : I
    //   115: istore_3
    //   116: iload_3
    //   117: ifeq -> 525
    //   120: iload_3
    //   121: iconst_1
    //   122: if_icmpeq -> 363
    //   125: iload_3
    //   126: iconst_2
    //   127: if_icmpeq -> 253
    //   130: iload_3
    //   131: iconst_4
    //   132: if_icmpeq -> 363
    //   135: iload_3
    //   136: iconst_5
    //   137: if_icmpeq -> 143
    //   140: goto -> 964
    //   143: ldc_w 'drb'
    //   146: ldc_w 'CALL_STATUS_COMPLETE'
    //   149: invokestatic v : (Ljava/lang/String;Ljava/lang/String;)I
    //   152: pop
    //   153: aload #5
    //   155: bipush #8
    //   157: invokevirtual setVisibility : (I)V
    //   160: aload #4
    //   162: ldc_w ''
    //   165: invokevirtual setText : (Ljava/lang/CharSequence;)V
    //   168: aload_0
    //   169: getfield m : I
    //   172: iconst_1
    //   173: if_icmpne -> 206
    //   176: aload_0
    //   177: getfield d : Landroid/widget/TextView;
    //   180: ldc_w 2131232397
    //   183: invokevirtual setBackgroundResource : (I)V
    //   186: aload_0
    //   187: getfield f : Landroid/widget/TextView;
    //   190: aload_0
    //   191: invokevirtual getResources : ()Landroid/content/res/Resources;
    //   194: ldc_w 2131756508
    //   197: invokevirtual getString : (I)Ljava/lang/String;
    //   200: invokevirtual setText : (Ljava/lang/CharSequence;)V
    //   203: goto -> 216
    //   206: aload_0
    //   207: getfield n : Landroid/view/View;
    //   210: ldc_w 2131232403
    //   213: invokevirtual setBackgroundResource : (I)V
    //   216: aload_0
    //   217: getfield y : Landroid/view/View;
    //   220: iconst_0
    //   221: invokevirtual setVisibility : (I)V
    //   224: aload_0
    //   225: getfield r : Landroid/widget/ImageView;
    //   228: bipush #8
    //   230: invokevirtual setVisibility : (I)V
    //   233: aload_0
    //   234: getfield s : Landroid/widget/TextView;
    //   237: aload_0
    //   238: getfield a : Landroid/content/Context;
    //   241: ldc_w 2131755699
    //   244: invokevirtual getString : (I)Ljava/lang/String;
    //   247: invokevirtual setText : (Ljava/lang/CharSequence;)V
    //   250: goto -> 964
    //   253: ldc_w 'drb'
    //   256: ldc_w 'CALL_STATUS_VERIFY'
    //   259: invokestatic v : (Ljava/lang/String;Ljava/lang/String;)I
    //   262: pop
    //   263: aload #5
    //   265: bipush #8
    //   267: invokevirtual setVisibility : (I)V
    //   270: aload #4
    //   272: ldc_w ''
    //   275: invokevirtual setText : (Ljava/lang/CharSequence;)V
    //   278: aload_0
    //   279: getfield m : I
    //   282: iconst_1
    //   283: if_icmpne -> 316
    //   286: aload_0
    //   287: getfield d : Landroid/widget/TextView;
    //   290: ldc_w 2131232404
    //   293: invokevirtual setBackgroundResource : (I)V
    //   296: aload_0
    //   297: getfield f : Landroid/widget/TextView;
    //   300: aload_0
    //   301: invokevirtual getResources : ()Landroid/content/res/Resources;
    //   304: ldc_w 2131755719
    //   307: invokevirtual getString : (I)Ljava/lang/String;
    //   310: invokevirtual setText : (Ljava/lang/CharSequence;)V
    //   313: goto -> 326
    //   316: aload_0
    //   317: getfield n : Landroid/view/View;
    //   320: ldc_w 2131232404
    //   323: invokevirtual setBackgroundResource : (I)V
    //   326: aload_0
    //   327: getfield y : Landroid/view/View;
    //   330: iconst_0
    //   331: invokevirtual setVisibility : (I)V
    //   334: aload_0
    //   335: getfield r : Landroid/widget/ImageView;
    //   338: bipush #8
    //   340: invokevirtual setVisibility : (I)V
    //   343: aload_0
    //   344: getfield s : Landroid/widget/TextView;
    //   347: aload_0
    //   348: getfield a : Landroid/content/Context;
    //   351: ldc_w 2131755719
    //   354: invokevirtual getString : (I)Ljava/lang/String;
    //   357: invokevirtual setText : (Ljava/lang/CharSequence;)V
    //   360: goto -> 964
    //   363: ldc_w 'drb'
    //   366: ldc_w 'CALL_STATUS_RUNNING'
    //   369: invokestatic v : (Ljava/lang/String;Ljava/lang/String;)I
    //   372: pop
    //   373: aload #5
    //   375: bipush #8
    //   377: invokevirtual setVisibility : (I)V
    //   380: aload_1
    //   381: getfield multiples : F
    //   384: ldc_w 10.0
    //   387: fcmpl
    //   388: iflt -> 402
    //   391: aload #4
    //   393: ldc_w '10x'
    //   396: invokevirtual setText : (Ljava/lang/CharSequence;)V
    //   399: goto -> 454
    //   402: new java/math/BigDecimal
    //   405: dup
    //   406: aload_1
    //   407: getfield multiples : F
    //   410: f2d
    //   411: invokespecial <init> : (D)V
    //   414: iconst_1
    //   415: iconst_1
    //   416: invokevirtual setScale : (II)Ljava/math/BigDecimal;
    //   419: invokevirtual floatValue : ()F
    //   422: fstore_2
    //   423: new java/lang/StringBuilder
    //   426: dup
    //   427: invokespecial <init> : ()V
    //   430: astore_1
    //   431: aload_1
    //   432: fload_2
    //   433: invokevirtual append : (F)Ljava/lang/StringBuilder;
    //   436: pop
    //   437: aload_1
    //   438: ldc_w 'x'
    //   441: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   444: pop
    //   445: aload #4
    //   447: aload_1
    //   448: invokevirtual toString : ()Ljava/lang/String;
    //   451: invokevirtual setText : (Ljava/lang/CharSequence;)V
    //   454: aload_0
    //   455: getfield m : I
    //   458: iconst_1
    //   459: if_icmpne -> 475
    //   462: aload_0
    //   463: getfield d : Landroid/widget/TextView;
    //   466: ldc_w 2131232398
    //   469: invokevirtual setBackgroundResource : (I)V
    //   472: goto -> 504
    //   475: aload #4
    //   477: ldc_w 10.0
    //   480: invokevirtual setTextSize : (F)V
    //   483: aload_0
    //   484: getfield y : Landroid/view/View;
    //   487: bipush #8
    //   489: invokevirtual setVisibility : (I)V
    //   492: aload_0
    //   493: getfield r : Landroid/widget/ImageView;
    //   496: iconst_0
    //   497: invokevirtual setVisibility : (I)V
    //   500: aload_0
    //   501: invokespecial i : ()V
    //   504: invokestatic a : ()Lcom/soft/blued/ui/find/manager/CallHelloManager;
    //   507: aload_0
    //   508: invokevirtual getContext : ()Landroid/content/Context;
    //   511: aload_0
    //   512: getfield g : Lcom/blued/android/core/net/IRequestHost;
    //   515: aload_0
    //   516: invokevirtual getFromPage : ()I
    //   519: invokevirtual a : (Landroid/content/Context;Lcom/blued/android/core/net/IRequestHost;I)V
    //   522: goto -> 964
    //   525: aload_1
    //   526: getfield free_count : I
    //   529: ifeq -> 646
    //   532: aload #5
    //   534: iconst_0
    //   535: invokevirtual setVisibility : (I)V
    //   538: aload #4
    //   540: ldc_w ''
    //   543: invokevirtual setText : (Ljava/lang/CharSequence;)V
    //   546: aload_0
    //   547: getfield m : I
    //   550: iconst_1
    //   551: if_icmpne -> 574
    //   554: aload_0
    //   555: getfield f : Landroid/widget/TextView;
    //   558: aload_0
    //   559: invokevirtual getResources : ()Landroid/content/res/Resources;
    //   562: ldc_w 2131756564
    //   565: invokevirtual getString : (I)Ljava/lang/String;
    //   568: invokevirtual setText : (Ljava/lang/CharSequence;)V
    //   571: goto -> 609
    //   574: aload #5
    //   576: ldc_w 2131232396
    //   579: invokevirtual setImageResource : (I)V
    //   582: aload #4
    //   584: ldc_w 16.0
    //   587: invokevirtual setTextSize : (F)V
    //   590: invokestatic n : ()Landroid/os/Handler;
    //   593: new com/soft/blued/ui/find/view/RecommendViewMixedInNearby$3
    //   596: dup
    //   597: aload_0
    //   598: aload_1
    //   599: invokespecial <init> : (Lcom/soft/blued/ui/find/view/RecommendViewMixedInNearby;Lcom/soft/blued/ui/find/model/CallMeStatusData;)V
    //   602: ldc2_w 1500
    //   605: invokevirtual postDelayed : (Ljava/lang/Runnable;J)Z
    //   608: pop
    //   609: aload_0
    //   610: getfield y : Landroid/view/View;
    //   613: iconst_0
    //   614: invokevirtual setVisibility : (I)V
    //   617: aload_0
    //   618: getfield r : Landroid/widget/ImageView;
    //   621: bipush #8
    //   623: invokevirtual setVisibility : (I)V
    //   626: aload_0
    //   627: getfield s : Landroid/widget/TextView;
    //   630: aload_0
    //   631: getfield a : Landroid/content/Context;
    //   634: ldc_w 2131755700
    //   637: invokevirtual getString : (I)Ljava/lang/String;
    //   640: invokevirtual setText : (Ljava/lang/CharSequence;)V
    //   643: goto -> 964
    //   646: aload_1
    //   647: getfield pay_count : I
    //   650: ifeq -> 939
    //   653: aload #5
    //   655: bipush #8
    //   657: invokevirtual setVisibility : (I)V
    //   660: new java/lang/StringBuilder
    //   663: dup
    //   664: invokespecial <init> : ()V
    //   667: astore #5
    //   669: aload #5
    //   671: aload_1
    //   672: getfield pay_count : I
    //   675: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   678: pop
    //   679: aload #5
    //   681: ldc_w ''
    //   684: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   687: pop
    //   688: aload #4
    //   690: aload #5
    //   692: invokevirtual toString : ()Ljava/lang/String;
    //   695: invokevirtual setText : (Ljava/lang/CharSequence;)V
    //   698: aload_0
    //   699: getfield m : I
    //   702: iconst_1
    //   703: if_icmpne -> 726
    //   706: aload_0
    //   707: getfield f : Landroid/widget/TextView;
    //   710: aload_0
    //   711: invokevirtual getResources : ()Landroid/content/res/Resources;
    //   714: ldc_w 2131758317
    //   717: invokevirtual getString : (I)Ljava/lang/String;
    //   720: invokevirtual setText : (Ljava/lang/CharSequence;)V
    //   723: goto -> 734
    //   726: aload #4
    //   728: ldc_w 16.0
    //   731: invokevirtual setTextSize : (F)V
    //   734: aload_0
    //   735: invokespecial g : ()V
    //   738: aload_0
    //   739: getfield y : Landroid/view/View;
    //   742: iconst_0
    //   743: invokevirtual setVisibility : (I)V
    //   746: aload_0
    //   747: getfield r : Landroid/widget/ImageView;
    //   750: bipush #8
    //   752: invokevirtual setVisibility : (I)V
    //   755: aload_1
    //   756: getfield pay_count : I
    //   759: bipush #99
    //   761: if_icmple -> 815
    //   764: aload_0
    //   765: getfield s : Landroid/widget/TextView;
    //   768: astore_1
    //   769: new java/lang/StringBuilder
    //   772: dup
    //   773: invokespecial <init> : ()V
    //   776: astore #4
    //   778: aload #4
    //   780: ldc_w '99+'
    //   783: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   786: pop
    //   787: aload #4
    //   789: aload_0
    //   790: getfield a : Landroid/content/Context;
    //   793: ldc_w 2131755698
    //   796: invokevirtual getString : (I)Ljava/lang/String;
    //   799: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   802: pop
    //   803: aload_1
    //   804: aload #4
    //   806: invokevirtual toString : ()Ljava/lang/String;
    //   809: invokevirtual setText : (Ljava/lang/CharSequence;)V
    //   812: goto -> 964
    //   815: invokestatic d : ()Z
    //   818: ifne -> 876
    //   821: aload_1
    //   822: getfield pay_count : I
    //   825: iconst_1
    //   826: if_icmpne -> 876
    //   829: aload_0
    //   830: getfield s : Landroid/widget/TextView;
    //   833: astore #4
    //   835: new java/lang/StringBuilder
    //   838: dup
    //   839: invokespecial <init> : ()V
    //   842: astore #5
    //   844: aload #5
    //   846: aload_1
    //   847: getfield pay_count : I
    //   850: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   853: pop
    //   854: aload #5
    //   856: ldc_w ' use'
    //   859: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   862: pop
    //   863: aload #4
    //   865: aload #5
    //   867: invokevirtual toString : ()Ljava/lang/String;
    //   870: invokevirtual setText : (Ljava/lang/CharSequence;)V
    //   873: goto -> 964
    //   876: aload_0
    //   877: getfield s : Landroid/widget/TextView;
    //   880: astore #4
    //   882: new java/lang/StringBuilder
    //   885: dup
    //   886: invokespecial <init> : ()V
    //   889: astore #5
    //   891: aload #5
    //   893: aload_1
    //   894: getfield pay_count : I
    //   897: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   900: pop
    //   901: aload #5
    //   903: ldc_w ' '
    //   906: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   909: pop
    //   910: aload #5
    //   912: aload_0
    //   913: getfield a : Landroid/content/Context;
    //   916: ldc_w 2131755698
    //   919: invokevirtual getString : (I)Ljava/lang/String;
    //   922: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   925: pop
    //   926: aload #4
    //   928: aload #5
    //   930: invokevirtual toString : ()Ljava/lang/String;
    //   933: invokevirtual setText : (Ljava/lang/CharSequence;)V
    //   936: goto -> 964
    //   939: aload_0
    //   940: getfield m : I
    //   943: iconst_1
    //   944: if_icmpne -> 964
    //   947: aload_0
    //   948: getfield f : Landroid/widget/TextView;
    //   951: aload_0
    //   952: invokevirtual getResources : ()Landroid/content/res/Resources;
    //   955: ldc_w 2131758317
    //   958: invokevirtual getString : (I)Ljava/lang/String;
    //   961: invokevirtual setText : (Ljava/lang/CharSequence;)V
    //   964: aload_0
    //   965: invokevirtual b : ()V
    //   968: return
    //   969: aload_0
    //   970: getfield k : Lcom/soft/blued/ui/find/adapter/RecommendMixedInNearbyAdapter;
    //   973: astore_1
    //   974: aload_1
    //   975: ifnull -> 1006
    //   978: aload_1
    //   979: invokevirtual n : ()Ljava/util/List;
    //   982: invokeinterface size : ()I
    //   987: ifne -> 1006
    //   990: ldc_w 'drb'
    //   993: ldc_w '隐藏弹窗'
    //   996: invokestatic v : (Ljava/lang/String;Ljava/lang/String;)I
    //   999: pop
    //   1000: aload_0
    //   1001: bipush #8
    //   1003: invokevirtual setVisibility : (I)V
    //   1006: return
  }
  
  public void a(boolean paramBoolean) {
    BluedPopupWindow bluedPopupWindow = this.D;
    if (bluedPopupWindow == null || !bluedPopupWindow.isShowing()) {
      bluedPopupWindow = this.z;
      if ((bluedPopupWindow == null || !bluedPopupWindow.isShowing()) && HomeActivity.c != null && "find".equals(HomeActivity.c.h())) {
        View view = this.q;
        if (view != null && view.getGlobalVisibleRect(new Rect())) {
          if (!j())
            return; 
          AppConfigModel.CallBubbleTest callBubbleTest = BluedConfig.b().A();
          if (callBubbleTest != null && callBubbleTest.group >= 1 && callBubbleTest.group <= 3) {
            if (TextUtils.isEmpty(callBubbleTest.text))
              return; 
            if (callBubbleTest.group == 3)
              return; 
            boolean bool2 = false;
            boolean bool1 = bool2;
            if (callBubbleTest.group == 1) {
              bool1 = bool2;
              if (B >= 100) {
                bool1 = bool2;
                if (!paramBoolean)
                  bool1 = true; 
              } 
            } 
            bool2 = bool1;
            if (callBubbleTest.group == 2) {
              bool2 = bool1;
              if (C >= 3) {
                bool2 = bool1;
                if (paramBoolean)
                  bool2 = true; 
              } 
            } 
            if (!bool2)
              return; 
            String str1 = (UserInfo.a().i()).uid;
            String str2 = BluedPreferences.cU();
            long l1 = (new Date()).getTime();
            long l2 = BluedPreferences.cT();
            if (str2.equals(str1) && l1 - l2 < 86400000L)
              return; 
            if (this.A == null && CallHelloManager.a().b() != null) {
              View view1 = this.q;
              if (view1 != null && view1.getVisibility() == 0) {
                view1 = View.inflate(getContext(), 2131494031, null);
                this.A = BluedPopupWindow.Builder.a((Activity)getContext(), view1).a(true).a();
                this.A.setOnDismissListener(new PopupWindow.OnDismissListener(this) {
                      public void onDismiss() {
                        RecommendViewMixedInNearby.b(this.a, (BluedPopupWindow)null);
                      }
                    });
                ((TextView)view1.findViewById(2131300646)).setText(callBubbleTest.text);
                view1.setOnClickListener(new View.OnClickListener(this) {
                      public void onClick(View param1View) {
                        EventTrackGuy.b(GuyProtos.Event.NEARBY_FRIEND_VOCATIVE_BUBBLE_CLICK);
                        CallMeStatusData callMeStatusData = CallHelloManager.a().b();
                        if (callMeStatusData != null && (callMeStatusData.free_count != 0 || callMeStatusData.pay_count != 0)) {
                          CommonAlertDialog.a(RecommendViewMixedInNearby.l(this.a), null, RecommendViewMixedInNearby.l(this.a).getResources().getString(2131755709), RecommendViewMixedInNearby.l(this.a).getResources().getString(2131755703), new DialogInterface.OnClickListener(this) {
                                public void onClick(DialogInterface param2DialogInterface, int param2Int) {
                                  EventTrackGuy.b(GuyProtos.Event.NEARBY_FRIEND_VOCATIVE_BUBBLE_OPEN_CLICK);
                                  CallHelloManager.a().a(RecommendViewMixedInNearby.l(this.a.a), RecommendViewMixedInNearby.e(this.a.a), 11, new CallHelloManager.ToOpenListener(this) {
                                        public void a(boolean param3Boolean) {
                                          if (param3Boolean)
                                            CallHelloManager.a().a(this.a.a.a.getContext(), RecommendViewMixedInNearby.e(this.a.a.a), false, 11); 
                                        }
                                      });
                                }
                              }RecommendViewMixedInNearby.l(this.a).getResources().getString(2131755696), null, null);
                        } else {
                          CallHelloManager.a().a(RecommendViewMixedInNearby.l(this.a), RecommendViewMixedInNearby.e(this.a), 11, new CallHelloManager.ToOpenListener(this) {
                                public void a(boolean param2Boolean) {
                                  if (param2Boolean)
                                    CallHelloManager.a().a(this.a.a.getContext(), RecommendViewMixedInNearby.e(this.a.a), false, 11); 
                                }
                              });
                        } 
                        RecommendViewMixedInNearby.n(this.a).dismiss();
                      }
                    });
                BluedPopupWindow bluedPopupWindow1 = this.A;
                View view2 = this.q;
                bluedPopupWindow1.a(view2, 2, 1, view2.getWidth(), DensityUtils.a(getContext(), 5.0F));
                view1.postDelayed(new Runnable(this) {
                      public void run() {
                        if (RecommendViewMixedInNearby.n(this.a) != null && RecommendViewMixedInNearby.n(this.a).isShowing())
                          RecommendViewMixedInNearby.n(this.a).dismiss(); 
                      }
                    },  5000L);
                BluedPreferences.m(l1);
                BluedPreferences.ai(str1);
                EventTrackGuy.b(GuyProtos.Event.NEARBY_FRIEND_VOCATIVE_BUBBLE_SHOW);
              } 
            } 
          } 
        } 
      } 
    } 
  }
  
  public void a(boolean paramBoolean, String paramString) {
    ImageView imageView;
    TextView textView;
    int i = this.m;
    if (i == 0)
      return; 
    if (i == 1) {
      imageView = this.j;
    } else {
      imageView = this.o;
    } 
    if (this.m == 1) {
      textView = this.d;
    } else {
      textView = this.p;
    } 
    if (imageView != null && textView != null)
      if (paramBoolean) {
        imageView.setVisibility(8);
        textView.setText(paramString);
      } else {
        imageView.setVisibility(0);
        imageView.setImageResource(2131232396);
        textView.setText("");
      }  
    if (this.m == 2) {
      this.y.setVisibility(0);
      this.r.setVisibility(8);
      if (paramBoolean) {
        TextView textView1;
        if (Integer.valueOf(paramString).intValue() > 99) {
          textView1 = this.s;
          StringBuilder stringBuilder1 = new StringBuilder();
          stringBuilder1.append("99+");
          stringBuilder1.append(this.a.getString(2131755698));
          textView1.setText(stringBuilder1.toString());
          return;
        } 
        if (!BlueAppLocal.d() && TextUtils.equals((CharSequence)textView1, "1")) {
          TextView textView3 = this.s;
          StringBuilder stringBuilder1 = new StringBuilder();
          stringBuilder1.append((String)textView1);
          stringBuilder1.append(" use");
          textView3.setText(stringBuilder1.toString());
          return;
        } 
        TextView textView2 = this.s;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append((String)textView1);
        stringBuilder.append(" ");
        stringBuilder.append(this.a.getString(2131755698));
        textView2.setText(stringBuilder.toString());
        return;
      } 
      this.s.setText(this.a.getString(2131755702));
    } 
  }
  
  public void b() {
    if (BluedConfig.b().I()) {
      if (BluedPreferences.dy())
        return; 
      BluedPopupWindow bluedPopupWindow = this.A;
      if (bluedPopupWindow == null || !bluedPopupWindow.isShowing()) {
        bluedPopupWindow = this.D;
        if ((bluedPopupWindow == null || !bluedPopupWindow.isShowing()) && HomeActivity.c != null && "find".equals(HomeActivity.c.h())) {
          View view = this.q;
          if (view != null && view.getGlobalVisibleRect(new Rect())) {
            if (!j())
              return; 
            if (this.z == null && CallHelloManager.a().b() != null) {
              view = this.q;
              if (view != null && view.getVisibility() == 0) {
                view = View.inflate(getContext(), 2131494031, null);
                this.z = BluedPopupWindow.Builder.a((Activity)getContext(), view).a(true).a();
                this.z.setOnDismissListener(new PopupWindow.OnDismissListener(this) {
                      public void onDismiss() {
                        RecommendViewMixedInNearby.a(this.a, (BluedPopupWindow)null);
                      }
                    });
                ((TextView)view.findViewById(2131300646)).setText(2131755718);
                view.setOnClickListener(new View.OnClickListener(this) {
                      public void onClick(View param1View) {
                        HelloOpenDialogFragment.a(RecommendViewMixedInNearby.l(this.a), this.a.getFromPage());
                        RecommendViewMixedInNearby.m(this.a).dismiss();
                      }
                    });
                BluedPopupWindow bluedPopupWindow1 = this.z;
                View view1 = this.q;
                bluedPopupWindow1.a(view1, 2, 1, view1.getWidth(), DensityUtils.a(getContext(), 5.0F));
                view.postDelayed(new Runnable(this) {
                      public void run() {
                        if (RecommendViewMixedInNearby.m(this.a) != null && RecommendViewMixedInNearby.m(this.a).isShowing())
                          RecommendViewMixedInNearby.m(this.a).dismiss(); 
                      }
                    },  3000L);
                BluedPreferences.dz();
              } 
            } 
          } 
        } 
      } 
    } 
  }
  
  public void b(int paramInt) {
    this.f.setText(TimeAndDateUtils.a(paramInt, false));
  }
  
  public void b(CallMeStatusData paramCallMeStatusData) {
    a(paramCallMeStatusData);
  }
  
  public void c() {
    B++;
  }
  
  public void d() {
    C++;
  }
  
  public void e() {
    BluedPopupWindow bluedPopupWindow = this.z;
    if (bluedPopupWindow != null)
      bluedPopupWindow.dismiss(); 
    bluedPopupWindow = this.A;
    if (bluedPopupWindow != null)
      bluedPopupWindow.dismiss(); 
    bluedPopupWindow = this.D;
    if (bluedPopupWindow != null)
      bluedPopupWindow.dismiss(); 
  }
  
  public int getFromPage() {
    return (this.m == 2) ? 3 : 1;
  }
  
  public void onClick(View paramView) {
    if (this.E)
      return; 
    CallMeStatusData callMeStatusData = getCallData();
    int i = paramView.getId();
    if (i != 2131299690) {
      if (i != 2131299692) {
        if (i == 2131300606) {
          GuyProtos.VocativeStatus vocativeStatus;
          c(1);
          GuyProtos.Event event = GuyProtos.Event.HOME_GUY_PAGE_VOCATIVE_BTN_CLICK;
          if (callMeStatusData != null && callMeStatusData.call_status == 1) {
            vocativeStatus = GuyProtos.VocativeStatus.VOCATIVE_OPEN;
          } else {
            vocativeStatus = GuyProtos.VocativeStatus.VOCATIVE_CLOSE;
          } 
          EventTrackGuy.a(event, vocativeStatus);
        } 
      } else {
        this.n.performClick();
      } 
    } else {
      GuyProtos.VocativeStatus vocativeStatus;
      c(3);
      GuyProtos.Event event = GuyProtos.Event.HOME_GUY_PAGE_VOCATIVE_BTN_CLICK;
      if (callMeStatusData != null && callMeStatusData.call_status == 1) {
        vocativeStatus = GuyProtos.VocativeStatus.VOCATIVE_OPEN;
      } else {
        vocativeStatus = GuyProtos.VocativeStatus.VOCATIVE_CLOSE;
      } 
      EventTrackGuy.a(event, vocativeStatus);
      EventTrackGuy.a(GuyProtos.Event.NEARBY_FRIEND_FILTER_BTN_CLICK);
    } 
    this.E = true;
    AppInfo.n().postDelayed(new Runnable(this) {
          public void run() {
            RecommendViewMixedInNearby.a(this.a, false);
          }
        }1000L);
  }
  
  public void setEnable(boolean paramBoolean) {
    byte b;
    this.l = paramBoolean;
    if (paramBoolean) {
      b = 0;
    } else {
      b = 8;
    } 
    setVisibility(b);
  }
  
  public void setMakeFriendRecommend(List<FindRecommendData> paramList) {
    setVisibility(0);
    if (paramList.size() < 5) {
      this.c.setVisibility(8);
    } else {
      this.c.setVisibility(0);
    } 
    this.u.setVisibility(8);
    a(0);
    if (this.k == null) {
      LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
      linearLayoutManager.setOrientation(0);
      this.e.setLayoutManager((RecyclerView.LayoutManager)linearLayoutManager);
      this.k = new RecommendMixedInNearbyAdapter(getContext(), this.g, this.e);
      this.k.d(true);
      this.k.a(this.t, -1, 0);
      this.k.a(this.e);
      this.e.setAdapter((RecyclerView.Adapter)this.k);
    } 
    this.k.c(paramList);
  }
  
  public void setMakeFriendRecommendExtra(FindRecommendExtra paramFindRecommendExtra) {
    if (paramFindRecommendExtra != null) {
      this.m = paramFindRecommendExtra.show_call;
      f();
      this.c.setText(paramFindRecommendExtra.more_title);
      this.b.setText(paramFindRecommendExtra.title);
      ImageLoader.a(this.g, paramFindRecommendExtra.icon).a(this.i);
      this.c.setOnClickListener(new View.OnClickListener(this, paramFindRecommendExtra) {
            public void onClick(View param1View) {
              if (!TextUtils.isEmpty(this.a.more_link))
                WebViewShowInfoFragment.show(this.b.getContext(), this.a.more_link, -1); 
            }
          });
    } 
  }
  
  public void setMakeFriendRecommendNoData(FindRecommendExtra paramFindRecommendExtra) {
    setVisibility(8);
    if (paramFindRecommendExtra != null && !TextUtils.isEmpty(paramFindRecommendExtra.default_bg)) {
      ImageLoader.a(this.g, paramFindRecommendExtra.default_bg).a(this.v);
    } else {
      this.v.setImageDrawable((Drawable)new ColorDrawable(0));
    } 
    this.u.setVisibility(0);
    NearbyViewModel nearbyViewModel = this.w;
    if (nearbyViewModel != null)
      nearbyViewModel.a.postValue(null); 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\find\view\RecommendViewMixedInNearby.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */