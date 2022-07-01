package com.soft.blued.ui.user.fragment;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.core.ui.StatusBarHelper;
import com.blued.android.core.ui.TransparentActivity;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.view.shape.ShapeRelativeLayout;
import com.blued.android.module.common.utils.DialogUtils;
import com.jeremyliao.liveeventbus.LiveEventBus;
import com.soft.blued.http.H5Url;
import com.soft.blued.http.PayHttpUtils;
import com.soft.blued.ui.find.manager.CallHelloManager;
import com.soft.blued.ui.home.HomeActivity;
import com.soft.blued.ui.msg.pop.NormalPayTypeChoosePop;
import com.soft.blued.ui.user.model.PayBeanDetail;
import com.soft.blued.ui.user.model.PayPlatformDiscountModel;
import com.soft.blued.ui.user.model.PrivilegeBuyOptionForJsonParse;
import com.soft.blued.ui.user.observer.VIPBuyResultObserver;
import com.soft.blued.ui.user.views.PrivilegeDialogBuyOptionView;
import com.soft.blued.ui.web.WebViewShowInfoFragment;
import com.soft.blued.utils.BluedPreferences;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PrivilegeBuyDialogFragment extends BaseFragment implements View.OnClickListener, VIPBuyResultObserver.IVIPBuyResultObserver {
  public Context d;
  
  public View e;
  
  public View f;
  
  public LayoutInflater g;
  
  public BluedUIHttpResponse h = new BluedUIHttpResponse<BluedEntityA<PrivilegeBuyOptionForJsonParse>>(this, PrivilegeBuyDialogFragment.class.getName(), (IRequestHost)w_()) {
      protected void a(BluedEntityA<PrivilegeBuyOptionForJsonParse> param1BluedEntityA) {
        super.onUICache((BluedEntity)param1BluedEntityA);
        this.a.a(param1BluedEntityA);
      }
      
      protected void b(BluedEntityA<PrivilegeBuyOptionForJsonParse> param1BluedEntityA) {
        this.a.a(param1BluedEntityA);
        if (3 == PrivilegeBuyDialogFragment.b(this.a))
          this.a.k(); 
      }
      
      public void onSuccess(String param1String) {
        super.onSuccess(param1String);
      }
      
      public void onUIFinish() {
        super.onUIFinish();
        DialogUtils.b(PrivilegeBuyDialogFragment.a(this.a));
      }
      
      public void onUIStart() {
        DialogUtils.a(PrivilegeBuyDialogFragment.a(this.a));
        super.onUIStart();
      }
    };
  
  private ImageView i;
  
  private List<PrivilegeDialogBuyOptionView> j;
  
  private TextView k;
  
  private FrameLayout l;
  
  private List<PrivilegeBuyOptionForJsonParse.ProductBean> m;
  
  private Dialog n;
  
  private LinearLayout o;
  
  private LinearLayout p;
  
  private CheckBox q;
  
  private CheckBox r;
  
  private LinearLayout s;
  
  private ImageView t;
  
  private TextView u;
  
  private ShapeRelativeLayout v;
  
  private TextView w;
  
  private int x = 1;
  
  private int y = -1;
  
  private boolean z = true;
  
  public static void a(Context paramContext, int paramInt) {
    Bundle bundle = new Bundle();
    bundle.putInt("FROM_PAGE", paramInt);
    TransparentActivity.a(bundle);
    TransparentActivity.b(paramContext, PrivilegeBuyDialogFragment.class, bundle);
  }
  
  public static void a(Context paramContext, int paramInt, String paramString) {
    Bundle bundle = new Bundle();
    bundle.putInt("FROM_PAGE", paramInt);
    bundle.putString("detail", paramString);
    TransparentActivity.a(bundle);
    TransparentActivity.b(paramContext, PrivilegeBuyDialogFragment.class, bundle);
  }
  
  private void m() {
    LiveEventBus.get("call_buy_open", Boolean.class).observe((LifecycleOwner)this, new Observer<Boolean>(this) {
          public void a(Boolean param1Boolean) {
            boolean bool;
            Bundle bundle = this.a.getArguments();
            if (bundle != null) {
              bool = bundle.getInt("FROM_PAGE");
            } else {
              bool = false;
            } 
            CallHelloManager.a().a(this.a.getContext(), (IRequestHost)this.a.w_(), bool, true, new CallHelloManager.ToOpenListener(this, bool) {
                  public void a(boolean param2Boolean) {
                    if (param2Boolean && HomeActivity.c != null)
                      CallHelloManager.a().a((Context)HomeActivity.c, null, false, this.a); 
                    this.b.a.getActivity().finish();
                  }
                });
          }
        });
  }
  
  private void n() {
    String str1 = this.d.getString(2131756881);
    String str2 = this.d.getString(2131756907);
    String str4 = this.d.getString(2131756882);
    String str3 = this.d.getString(2131756908);
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append(str1);
    stringBuilder1.append(str2);
    stringBuilder1.append(str4);
    stringBuilder1.append(str3);
    str4 = stringBuilder1.toString();
    SpannableString spannableString = new SpannableString(str4);
    this.u.setMovementMethod(LinkMovementMethod.getInstance());
    ClickableSpan clickableSpan = new ClickableSpan(this) {
        public void onClick(View param1View) {
          WebViewShowInfoFragment.show((Context)this.a.getActivity(), H5Url.a(32), 7);
        }
        
        public void updateDrawState(TextPaint param1TextPaint) {
          param1TextPaint.setColor(this.a.d.getResources().getColor(2131100716));
          param1TextPaint.setUnderlineText(false);
        }
      };
    int i = str4.indexOf(str2);
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append(str1);
    stringBuilder2.append(str2);
    spannableString.setSpan(clickableSpan, i, stringBuilder2.toString().length(), 33);
    spannableString.setSpan(new ClickableSpan(this) {
          public void onClick(View param1View) {
            WebViewShowInfoFragment.show((Context)this.a.getActivity(), H5Url.a(45), 7);
          }
          
          public void updateDrawState(TextPaint param1TextPaint) {
            param1TextPaint.setColor(this.a.d.getResources().getColor(2131100716));
            param1TextPaint.setUnderlineText(false);
          }
        }str4.indexOf(str3), str4.length(), 33);
    this.u.setText((CharSequence)spannableString);
  }
  
  private void o() {
    NormalPayTypeChoosePop.a(getContext(), new NormalPayTypeChoosePop.iChoosePayResultListener(this) {
          public void a() {}
          
          public void a(int param1Int, boolean param1Boolean) {
            PrivilegeBuyDialogFragment.a(this.a, param1Int);
            PrivilegeBuyDialogFragment.c(this.a);
          }
        }this.x, (l()).id, (IRequestHost)w_());
  }
  
  private void p() {
    int j = this.x;
    int i = 0;
    if (j != 1) {
      if (j != 2) {
        if (j != 3) {
          if (j == 4) {
            this.w.setText(getContext().getString(2131758349));
            Iterator<PrivilegeBuyOptionForJsonParse.ProductBean> iterator = this.m.iterator();
            while (iterator.hasNext())
              ((PrivilegeBuyOptionForJsonParse.ProductBean)iterator.next()).showBeans = false; 
            this.k.setText(this.d.getResources().getString(2131756887));
          } 
        } else {
          this.w.setText(getContext().getString(2131758351));
          Iterator<PrivilegeBuyOptionForJsonParse.ProductBean> iterator = this.m.iterator();
          while (iterator.hasNext())
            ((PrivilegeBuyOptionForJsonParse.ProductBean)iterator.next()).showBeans = true; 
          TextView textView = this.k;
          String str = this.d.getResources().getString(2131758347);
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append((l()).total_beans);
          stringBuilder.append("");
          textView.setText(String.format(str, new Object[] { stringBuilder.toString() }));
        } 
      } else {
        this.w.setText(getContext().getString(2131758352));
        Iterator<PrivilegeBuyOptionForJsonParse.ProductBean> iterator = this.m.iterator();
        while (iterator.hasNext())
          ((PrivilegeBuyOptionForJsonParse.ProductBean)iterator.next()).showBeans = false; 
        this.k.setText(this.d.getResources().getString(2131756887));
      } 
    } else {
      this.w.setText(getContext().getString(2131755279));
      Iterator<PrivilegeBuyOptionForJsonParse.ProductBean> iterator = this.m.iterator();
      while (iterator.hasNext())
        ((PrivilegeBuyOptionForJsonParse.ProductBean)iterator.next()).showBeans = false; 
      this.k.setText(this.d.getResources().getString(2131756887));
    } 
    while (i < this.m.size()) {
      if (i < this.j.size())
        ((PrivilegeDialogBuyOptionView)this.j.get(i)).setOptionView(this.m.get(i)); 
      i++;
    } 
  }
  
  private void q() {
    // Byte code:
    //   0: aload_0
    //   1: getfield z : Z
    //   4: ifne -> 14
    //   7: ldc_w 2131756886
    //   10: invokestatic d : (I)V
    //   13: return
    //   14: aload_0
    //   15: getfield y : I
    //   18: iflt -> 469
    //   21: aload_0
    //   22: invokevirtual getArguments : ()Landroid/os/Bundle;
    //   25: astore_3
    //   26: ldc_w 'home_page'
    //   29: astore_2
    //   30: aload_3
    //   31: ifnull -> 438
    //   34: aload_3
    //   35: ldc 'FROM_PAGE'
    //   37: invokevirtual getInt : (Ljava/lang/String;)I
    //   40: istore_1
    //   41: iload_1
    //   42: iconst_1
    //   43: if_icmpeq -> 384
    //   46: iload_1
    //   47: iconst_2
    //   48: if_icmpeq -> 328
    //   51: iload_1
    //   52: iconst_3
    //   53: if_icmpeq -> 274
    //   56: iload_1
    //   57: iconst_4
    //   58: if_icmpeq -> 220
    //   61: iload_1
    //   62: bipush #7
    //   64: if_icmpeq -> 213
    //   67: iload_1
    //   68: bipush #8
    //   70: if_icmpeq -> 206
    //   73: iload_1
    //   74: bipush #9
    //   76: if_icmpeq -> 144
    //   79: iload_1
    //   80: bipush #11
    //   82: if_icmpeq -> 88
    //   85: goto -> 438
    //   88: getstatic com/blued/das/guy/GuyProtos$Event.HOME_GUY_PAGE_VOCATIVE_PAY_BTN_CLICK : Lcom/blued/das/guy/GuyProtos$Event;
    //   91: astore_2
    //   92: getstatic com/blued/das/guy/GuyProtos$VocativeSourcePage.CALL_POP : Lcom/blued/das/guy/GuyProtos$VocativeSourcePage;
    //   95: astore_3
    //   96: new java/lang/StringBuilder
    //   99: dup
    //   100: invokespecial <init> : ()V
    //   103: astore #4
    //   105: aload #4
    //   107: aload_0
    //   108: invokevirtual l : ()Lcom/soft/blued/ui/user/model/PrivilegeBuyOptionForJsonParse$ProductBean;
    //   111: getfield id : I
    //   114: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   117: pop
    //   118: aload #4
    //   120: ldc_w ''
    //   123: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   126: pop
    //   127: aload_2
    //   128: aload_3
    //   129: aload #4
    //   131: invokevirtual toString : ()Ljava/lang/String;
    //   134: invokestatic a : (Lcom/blued/das/guy/GuyProtos$Event;Lcom/blued/das/guy/GuyProtos$VocativeSourcePage;Ljava/lang/String;)V
    //   137: ldc_w 'vocative_nearby_bubble'
    //   140: astore_2
    //   141: goto -> 435
    //   144: aload_3
    //   145: ldc 'detail'
    //   147: invokevirtual getString : (Ljava/lang/String;)Ljava/lang/String;
    //   150: astore_2
    //   151: getstatic com/blued/das/guy/GuyProtos$Event.HOME_GUY_PAGE_VOCATIVE_PAY_BTN_CLICK : Lcom/blued/das/guy/GuyProtos$Event;
    //   154: astore_3
    //   155: aload_2
    //   156: invokestatic b : (Ljava/lang/String;)Lcom/blued/das/guy/GuyProtos$VocativeSourcePage;
    //   159: astore #4
    //   161: new java/lang/StringBuilder
    //   164: dup
    //   165: invokespecial <init> : ()V
    //   168: astore #5
    //   170: aload #5
    //   172: aload_0
    //   173: invokevirtual l : ()Lcom/soft/blued/ui/user/model/PrivilegeBuyOptionForJsonParse$ProductBean;
    //   176: getfield id : I
    //   179: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   182: pop
    //   183: aload #5
    //   185: ldc_w ''
    //   188: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   191: pop
    //   192: aload_3
    //   193: aload #4
    //   195: aload #5
    //   197: invokevirtual toString : ()Ljava/lang/String;
    //   200: invokestatic a : (Lcom/blued/das/guy/GuyProtos$Event;Lcom/blued/das/guy/GuyProtos$VocativeSourcePage;Ljava/lang/String;)V
    //   203: goto -> 435
    //   206: ldc_w 'vocative_second_page'
    //   209: astore_2
    //   210: goto -> 435
    //   213: ldc_w 'visit_page'
    //   216: astore_2
    //   217: goto -> 435
    //   220: getstatic com/blued/das/guy/GuyProtos$Event.HOME_GUY_PAGE_VOCATIVE_PAY_BTN_CLICK : Lcom/blued/das/guy/GuyProtos$Event;
    //   223: astore_3
    //   224: getstatic com/blued/das/guy/GuyProtos$VocativeSourcePage.HOME_KEEP_ON : Lcom/blued/das/guy/GuyProtos$VocativeSourcePage;
    //   227: astore #4
    //   229: new java/lang/StringBuilder
    //   232: dup
    //   233: invokespecial <init> : ()V
    //   236: astore #5
    //   238: aload #5
    //   240: aload_0
    //   241: invokevirtual l : ()Lcom/soft/blued/ui/user/model/PrivilegeBuyOptionForJsonParse$ProductBean;
    //   244: getfield id : I
    //   247: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   250: pop
    //   251: aload #5
    //   253: ldc_w ''
    //   256: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   259: pop
    //   260: aload_3
    //   261: aload #4
    //   263: aload #5
    //   265: invokevirtual toString : ()Ljava/lang/String;
    //   268: invokestatic a : (Lcom/blued/das/guy/GuyProtos$Event;Lcom/blued/das/guy/GuyProtos$VocativeSourcePage;Ljava/lang/String;)V
    //   271: goto -> 435
    //   274: getstatic com/blued/das/guy/GuyProtos$Event.HOME_GUY_PAGE_VOCATIVE_PAY_BTN_CLICK : Lcom/blued/das/guy/GuyProtos$Event;
    //   277: astore_3
    //   278: getstatic com/blued/das/guy/GuyProtos$VocativeSourcePage.HOME_VOCATIVE_BTN : Lcom/blued/das/guy/GuyProtos$VocativeSourcePage;
    //   281: astore #4
    //   283: new java/lang/StringBuilder
    //   286: dup
    //   287: invokespecial <init> : ()V
    //   290: astore #5
    //   292: aload #5
    //   294: aload_0
    //   295: invokevirtual l : ()Lcom/soft/blued/ui/user/model/PrivilegeBuyOptionForJsonParse$ProductBean;
    //   298: getfield id : I
    //   301: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   304: pop
    //   305: aload #5
    //   307: ldc_w ''
    //   310: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   313: pop
    //   314: aload_3
    //   315: aload #4
    //   317: aload #5
    //   319: invokevirtual toString : ()Ljava/lang/String;
    //   322: invokestatic a : (Lcom/blued/das/guy/GuyProtos$Event;Lcom/blued/das/guy/GuyProtos$VocativeSourcePage;Ljava/lang/String;)V
    //   325: goto -> 435
    //   328: getstatic com/blued/das/guy/GuyProtos$Event.HOME_GUY_PAGE_VOCATIVE_PAY_BTN_CLICK : Lcom/blued/das/guy/GuyProtos$Event;
    //   331: astore_2
    //   332: getstatic com/blued/das/guy/GuyProtos$VocativeSourcePage.VOCATIVE_MESSAGE : Lcom/blued/das/guy/GuyProtos$VocativeSourcePage;
    //   335: astore_3
    //   336: new java/lang/StringBuilder
    //   339: dup
    //   340: invokespecial <init> : ()V
    //   343: astore #4
    //   345: aload #4
    //   347: aload_0
    //   348: invokevirtual l : ()Lcom/soft/blued/ui/user/model/PrivilegeBuyOptionForJsonParse$ProductBean;
    //   351: getfield id : I
    //   354: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   357: pop
    //   358: aload #4
    //   360: ldc_w ''
    //   363: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   366: pop
    //   367: aload_2
    //   368: aload_3
    //   369: aload #4
    //   371: invokevirtual toString : ()Ljava/lang/String;
    //   374: invokestatic a : (Lcom/blued/das/guy/GuyProtos$Event;Lcom/blued/das/guy/GuyProtos$VocativeSourcePage;Ljava/lang/String;)V
    //   377: ldc_w 'vocative_msg'
    //   380: astore_2
    //   381: goto -> 435
    //   384: getstatic com/blued/das/guy/GuyProtos$Event.HOME_GUY_PAGE_VOCATIVE_PAY_BTN_CLICK : Lcom/blued/das/guy/GuyProtos$Event;
    //   387: astore_3
    //   388: getstatic com/blued/das/guy/GuyProtos$VocativeSourcePage.VOCATIVE_HOMEPAGE : Lcom/blued/das/guy/GuyProtos$VocativeSourcePage;
    //   391: astore #4
    //   393: new java/lang/StringBuilder
    //   396: dup
    //   397: invokespecial <init> : ()V
    //   400: astore #5
    //   402: aload #5
    //   404: aload_0
    //   405: invokevirtual l : ()Lcom/soft/blued/ui/user/model/PrivilegeBuyOptionForJsonParse$ProductBean;
    //   408: getfield id : I
    //   411: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   414: pop
    //   415: aload #5
    //   417: ldc_w ''
    //   420: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   423: pop
    //   424: aload_3
    //   425: aload #4
    //   427: aload #5
    //   429: invokevirtual toString : ()Ljava/lang/String;
    //   432: invokestatic a : (Lcom/blued/das/guy/GuyProtos$Event;Lcom/blued/das/guy/GuyProtos$VocativeSourcePage;Ljava/lang/String;)V
    //   435: goto -> 442
    //   438: ldc_w ''
    //   441: astore_2
    //   442: aload_0
    //   443: invokevirtual getContext : ()Landroid/content/Context;
    //   446: aload_0
    //   447: invokevirtual l : ()Lcom/soft/blued/ui/user/model/PrivilegeBuyOptionForJsonParse$ProductBean;
    //   450: aconst_null
    //   451: ldc_w ''
    //   454: aconst_null
    //   455: aconst_null
    //   456: aload_2
    //   457: aload_0
    //   458: getfield x : I
    //   461: iconst_0
    //   462: aload_0
    //   463: invokevirtual w_ : ()Lcom/blued/android/core/ui/ActivityFragmentActive;
    //   466: invokestatic a : (Landroid/content/Context;Lcom/soft/blued/ui/user/model/GoodsOptionBasic;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILcom/blued/android/core/net/IRequestHost;)V
    //   469: return
  }
  
  public void a() {
    this.n = DialogUtils.a(this.d);
    this.m = new ArrayList<PrivilegeBuyOptionForJsonParse.ProductBean>();
    this.j = new ArrayList<PrivilegeDialogBuyOptionView>();
    this.i = (ImageView)this.e.findViewById(2131297457);
    this.i.setOnClickListener(this);
    this.l = (FrameLayout)this.e.findViewById(2131297167);
    PrivilegeDialogBuyOptionView privilegeDialogBuyOptionView1 = (PrivilegeDialogBuyOptionView)this.e.findViewById(2131301666);
    privilegeDialogBuyOptionView1.setOnClickListener(this);
    PrivilegeDialogBuyOptionView privilegeDialogBuyOptionView2 = (PrivilegeDialogBuyOptionView)this.e.findViewById(2131301667);
    privilegeDialogBuyOptionView2.setOnClickListener(this);
    PrivilegeDialogBuyOptionView privilegeDialogBuyOptionView3 = (PrivilegeDialogBuyOptionView)this.e.findViewById(2131301668);
    privilegeDialogBuyOptionView3.setOnClickListener(this);
    this.j.add(privilegeDialogBuyOptionView1);
    this.j.add(privilegeDialogBuyOptionView2);
    this.j.add(privilegeDialogBuyOptionView3);
    this.k = (TextView)this.e.findViewById(2131300602);
    this.k.setOnClickListener(this);
    this.o = (LinearLayout)this.e.findViewById(2131299145);
    this.o.setOnClickListener(this);
    this.p = (LinearLayout)this.e.findViewById(2131298697);
    this.p.setOnClickListener(this);
    this.q = (CheckBox)this.e.findViewById(2131296673);
    this.q.setOnClickListener(this);
    this.r = (CheckBox)this.e.findViewById(2131296665);
    this.r.setOnClickListener(this);
    this.s = (LinearLayout)this.e.findViewById(2131296428);
    this.t = (ImageView)this.e.findViewById(2131296427);
    this.u = (TextView)this.e.findViewById(2131296429);
    this.t.setOnClickListener(this);
    this.v = (ShapeRelativeLayout)this.e.findViewById(2131299723);
    this.w = (TextView)this.e.findViewById(2131301165);
    this.v.setOnClickListener(this);
    if (BluedPreferences.bS() != 0)
      this.x = BluedPreferences.bS(); 
    p();
    this.h.refresh();
    n();
    PayHttpUtils.a(this.h, (IRequestHost)w_(), "call");
  }
  
  public void a(int paramInt) {
    byte b = 0;
    int i = b;
    if (paramInt >= 0) {
      i = b;
      if (paramInt < this.m.size()) {
        for (i = 0; i < this.m.size(); i++)
          ((PrivilegeBuyOptionForJsonParse.ProductBean)this.m.get(i)).choosen = false; 
        this.y = paramInt;
        ((PrivilegeBuyOptionForJsonParse.ProductBean)this.m.get(paramInt)).choosen = true;
        i = b;
        if (this.x == 3) {
          TextView textView = this.k;
          String str = this.d.getResources().getString(2131758347);
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append(((PrivilegeBuyOptionForJsonParse.ProductBean)this.m.get(paramInt)).total_beans);
          stringBuilder.append("");
          textView.setText(String.format(str, new Object[] { stringBuilder.toString() }));
          i = b;
        } 
      } 
    } 
    while (i < this.m.size()) {
      if (i < this.j.size())
        ((PrivilegeDialogBuyOptionView)this.j.get(i)).setOptionView(this.m.get(i)); 
      i++;
    } 
  }
  
  public void a(int paramInt, boolean paramBoolean) {
    if (paramBoolean) {
      BluedPreferences.s(this.x);
      View view = this.e;
      if (view != null) {
        this.f = view.findViewById(2131299752);
        this.f.setVisibility(8);
      } 
      Bundle bundle = getArguments();
      if (bundle != null) {
        paramInt = bundle.getInt("FROM_PAGE");
      } else {
        paramInt = 0;
      } 
      CallHelloManager.a().a(getContext(), (IRequestHost)w_(), paramInt, true, new CallHelloManager.ToOpenListener(this, paramInt) {
            public void a(boolean param1Boolean) {
              if (param1Boolean && HomeActivity.c != null)
                CallHelloManager.a().a((Context)HomeActivity.c, null, false, this.a); 
              if (this.b.getActivity() != null)
                this.b.getActivity().finish(); 
            }
          });
    } 
  }
  
  public void a(BluedEntityA<PrivilegeBuyOptionForJsonParse> paramBluedEntityA) {
    if (paramBluedEntityA != null && paramBluedEntityA.data != null && paramBluedEntityA.data.size() > 0) {
      List<PrivilegeBuyOptionForJsonParse.ProductBean> list = paramBluedEntityA.data;
      boolean bool = false;
      if (list.get(0) != null) {
        boolean bool1;
        list = this.m;
        if (list != null) {
          list.clear();
        } else {
          this.m = new ArrayList<PrivilegeBuyOptionForJsonParse.ProductBean>();
        } 
        this.m.addAll(((PrivilegeBuyOptionForJsonParse)paramBluedEntityA.getSingleData()).product);
        p();
        int i = 0;
        while (true) {
          bool1 = bool;
          if (i < this.m.size()) {
            if (((PrivilegeBuyOptionForJsonParse.ProductBean)this.m.get(i)).is_recommend == 1) {
              a(i);
              bool1 = true;
              break;
            } 
            i++;
            continue;
          } 
          break;
        } 
        if (!bool1)
          a(1); 
        PayPlatformDiscountModel._channel _channel = ((PrivilegeBuyOptionForJsonParse)paramBluedEntityA.getSingleData()).channel;
        if (_channel != null) {
          if (_channel.alipay != null && _channel.alipay.is_choose == 1) {
            this.x = 1;
          } else if (_channel.weixin != null && _channel.weixin.is_choose == 1) {
            this.x = 2;
          } else if (_channel.huabei != null && _channel.huabei.is_choose == 1) {
            this.x = 4;
          } 
          p();
        } 
      } 
    } 
  }
  
  public void k() {
    PayHttpUtils.c(new BluedUIHttpResponse<BluedEntityA<PayBeanDetail>>(this, (IRequestHost)w_()) {
          protected void a(BluedEntityA<PayBeanDetail> param1BluedEntityA) {
            if (param1BluedEntityA != null && param1BluedEntityA.data != null && param1BluedEntityA.data.size() > 0) {
              PayBeanDetail payBeanDetail = param1BluedEntityA.data.get(0);
              if (payBeanDetail != null && payBeanDetail.is_support_beans == 1 && payBeanDetail.is_enough == 0) {
                PrivilegeBuyDialogFragment.a(this.a, 1);
                PrivilegeBuyDialogFragment.c(this.a);
              } 
            } 
          }
          
          public boolean onUIFailure(int param1Int, String param1String) {
            return super.onUIFailure(param1Int, param1String);
          }
        }(l()).id);
  }
  
  public PrivilegeBuyOptionForJsonParse.ProductBean l() {
    for (int i = 0; i < this.m.size(); i++) {
      if (((PrivilegeBuyOptionForJsonParse.ProductBean)this.m.get(i)).choosen)
        return this.m.get(i); 
    } 
    return new PrivilegeBuyOptionForJsonParse.ProductBean();
  }
  
  public void onClick(View paramView) {
    List<PrivilegeBuyOptionForJsonParse.ProductBean> list;
    switch (paramView.getId()) {
      default:
        return;
      case 2131301668:
        list = this.m;
        if (list != null && list.size() > 2) {
          a(2);
          return;
        } 
        return;
      case 2131301667:
        list = this.m;
        if (list != null && list.size() > 1) {
          a(1);
          return;
        } 
        return;
      case 2131301666:
        list = this.m;
        if (list != null && list.size() > 0) {
          a(0);
          return;
        } 
        return;
      case 2131300602:
        q();
        return;
      case 2131299723:
        o();
        return;
      case 2131297457:
        getActivity().finish();
        return;
      case 2131296673:
      case 2131299145:
        this.q.setChecked(true);
        this.r.setChecked(false);
        this.x = 2;
        return;
      case 2131296665:
      case 2131298697:
        this.q.setChecked(false);
        this.r.setChecked(true);
        this.x = 1;
        return;
      case 2131296427:
        break;
    } 
    if (this.z) {
      this.t.setImageResource(2131232345);
      this.z = false;
      return;
    } 
    this.t.setImageResource(2131232346);
    this.z = true;
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
    this.d = (Context)getActivity();
    this.g = LayoutInflater.from(this.d);
    if (this.e == null) {
      this.e = paramLayoutInflater.inflate(2131493028, paramViewGroup, false);
      a();
      m();
      StatusBarHelper.a((Activity)getActivity(), false);
      VIPBuyResultObserver.a().a(this, getLifecycle());
    } 
    return this.e;
  }
  
  public void onDestroy() {
    super.onDestroy();
    Dialog dialog = this.n;
    if (dialog != null && dialog.isShowing())
      this.n.dismiss(); 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\u\\user\fragment\PrivilegeBuyDialogFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */