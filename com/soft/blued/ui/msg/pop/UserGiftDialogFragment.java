package com.soft.blued.ui.msg.pop;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.ui.ActivityFragmentActive;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.das.profile.PersonalProfileProtos;
import com.jeremyliao.liveeventbus.LiveEventBus;
import com.scwang.smartrefresh.layout.util.DensityUtil;
import com.soft.blued.http.UserHttpUtils;
import com.soft.blued.log.trackUtils.EventTrackPersonalProfile;
import com.soft.blued.ui.msg.customview.AutoHeightViewPager;
import com.soft.blued.ui.msg.event.GiftHintEvent;
import com.soft.blued.ui.msg.fragment.UserGiftFragment;
import com.soft.blued.ui.msg.fragment.UserGiftPackageFragment;
import com.soft.blued.ui.msg.model.UserGiftModel;
import com.soft.blued.ui.user.model.GiftGivingOptionForJsonParse;
import com.soft.blued.utils.BluedPreferences;
import com.soft.blued.view.tip.dialog.CommonDialogFragment;
import java.util.List;

public class UserGiftDialogFragment extends CommonDialogFragment implements View.OnClickListener {
  public ActivityFragmentActive a;
  
  public BuySucceedListener b;
  
  private FragmentActivity c;
  
  private String d;
  
  private String e;
  
  private String f;
  
  private int g = 2;
  
  private List<GiftGivingOptionForJsonParse> h;
  
  private UserGiftFmAdapter i;
  
  private AutoHeightViewPager j;
  
  private RelativeLayout k;
  
  private LinearLayout l;
  
  private TextView m;
  
  private TextView n;
  
  private LinearLayout o;
  
  private TextView p;
  
  private TextView q;
  
  private TextView r;
  
  private ImageView s;
  
  private View t;
  
  private FrameLayout u;
  
  private TextView v;
  
  private TextView w;
  
  private int x;
  
  private String y;
  
  public UserGiftDialogFragment() {}
  
  public UserGiftDialogFragment(Context paramContext, ActivityFragmentActive paramActivityFragmentActive, String paramString1, String paramString2, List<GiftGivingOptionForJsonParse> paramList, int paramInt1, int paramInt2, String paramString3, String paramString4) {
    this.c = (FragmentActivity)paramContext;
    this.a = paramActivityFragmentActive;
    this.d = paramString1;
    if (TextUtils.isEmpty(paramString2)) {
      this.e = "";
    } else {
      this.e = paramString2;
    } 
    this.h = paramList;
    this.g = paramInt1;
    this.x = paramInt2;
    this.y = paramString3;
    this.f = paramString4;
  }
  
  public static void a(Context paramContext, ActivityFragmentActive paramActivityFragmentActive, String paramString1, String paramString2, BuySucceedListener paramBuySucceedListener, String paramString3, String paramString4, int... paramVarArgs) {
    UserHttpUtils.a(new BluedUIHttpResponse<BluedEntityA<UserGiftModel>>((IRequestHost)paramActivityFragmentActive, paramVarArgs, paramContext, paramActivityFragmentActive, paramString1, paramString2, paramString3, paramString4, paramBuySucceedListener) {
          protected void a(BluedEntityA<UserGiftModel> param1BluedEntityA) {
            // Byte code:
            //   0: aload_1
            //   1: ifnull -> 549
            //   4: aload_1
            //   5: getfield data : Ljava/util/List;
            //   8: ifnull -> 549
            //   11: aload_1
            //   12: getfield data : Ljava/util/List;
            //   15: invokeinterface size : ()I
            //   20: ifle -> 549
            //   23: aload_1
            //   24: getfield data : Ljava/util/List;
            //   27: iconst_0
            //   28: invokeinterface get : (I)Ljava/lang/Object;
            //   33: checkcast com/soft/blued/ui/msg/model/UserGiftModel
            //   36: getfield users : Lcom/soft/blued/ui/msg/model/UserGiftModel$UserInfo;
            //   39: ifnull -> 549
            //   42: invokestatic dx : ()I
            //   45: istore_3
            //   46: aload_1
            //   47: invokevirtual getSingleData : ()Ljava/lang/Object;
            //   50: checkcast com/soft/blued/ui/msg/model/UserGiftModel
            //   53: getfield channel : Lcom/soft/blued/ui/user/model/PayPlatformDiscountModel$_channel;
            //   56: astore #4
            //   58: iload_3
            //   59: istore_2
            //   60: aload #4
            //   62: ifnull -> 141
            //   65: aload #4
            //   67: getfield alipay : Lcom/soft/blued/ui/user/model/PayPlatformDiscountModel$_discountDesc;
            //   70: ifnull -> 90
            //   73: aload #4
            //   75: getfield alipay : Lcom/soft/blued/ui/user/model/PayPlatformDiscountModel$_discountDesc;
            //   78: getfield is_choose : I
            //   81: iconst_1
            //   82: if_icmpne -> 90
            //   85: iconst_1
            //   86: istore_2
            //   87: goto -> 141
            //   90: aload #4
            //   92: getfield weixin : Lcom/soft/blued/ui/user/model/PayPlatformDiscountModel$_discountDesc;
            //   95: ifnull -> 115
            //   98: aload #4
            //   100: getfield weixin : Lcom/soft/blued/ui/user/model/PayPlatformDiscountModel$_discountDesc;
            //   103: getfield is_choose : I
            //   106: iconst_1
            //   107: if_icmpne -> 115
            //   110: iconst_2
            //   111: istore_2
            //   112: goto -> 141
            //   115: iload_3
            //   116: istore_2
            //   117: aload #4
            //   119: getfield huabei : Lcom/soft/blued/ui/user/model/PayPlatformDiscountModel$_discountDesc;
            //   122: ifnull -> 141
            //   125: iload_3
            //   126: istore_2
            //   127: aload #4
            //   129: getfield huabei : Lcom/soft/blued/ui/user/model/PayPlatformDiscountModel$_discountDesc;
            //   132: getfield is_choose : I
            //   135: iconst_1
            //   136: if_icmpne -> 141
            //   139: iconst_4
            //   140: istore_2
            //   141: iload_2
            //   142: ifeq -> 152
            //   145: iload_2
            //   146: istore_3
            //   147: iload_2
            //   148: iconst_3
            //   149: if_icmpne -> 247
            //   152: aload_1
            //   153: getfield data : Ljava/util/List;
            //   156: iconst_0
            //   157: invokeinterface get : (I)Ljava/lang/Object;
            //   162: checkcast com/soft/blued/ui/msg/model/UserGiftModel
            //   165: getfield list : Ljava/util/List;
            //   168: invokeinterface iterator : ()Ljava/util/Iterator;
            //   173: astore #4
            //   175: iconst_0
            //   176: istore_2
            //   177: aload #4
            //   179: invokeinterface hasNext : ()Z
            //   184: ifeq -> 217
            //   187: aload #4
            //   189: invokeinterface next : ()Ljava/lang/Object;
            //   194: checkcast com/soft/blued/ui/user/model/GiftGivingOptionForJsonParse
            //   197: astore #5
            //   199: aload #5
            //   201: getfield beans : I
            //   204: iload_2
            //   205: if_icmple -> 177
            //   208: aload #5
            //   210: getfield beans : I
            //   213: istore_2
            //   214: goto -> 177
            //   217: aload_1
            //   218: getfield data : Ljava/util/List;
            //   221: iconst_0
            //   222: invokeinterface get : (I)Ljava/lang/Object;
            //   227: checkcast com/soft/blued/ui/msg/model/UserGiftModel
            //   230: getfield users : Lcom/soft/blued/ui/msg/model/UserGiftModel$UserInfo;
            //   233: getfield beans : I
            //   236: iload_2
            //   237: if_icmplt -> 245
            //   240: iconst_3
            //   241: istore_3
            //   242: goto -> 247
            //   245: iconst_1
            //   246: istore_3
            //   247: iload_3
            //   248: ifne -> 256
            //   251: iconst_1
            //   252: istore_2
            //   253: goto -> 258
            //   256: iload_3
            //   257: istore_2
            //   258: aload_1
            //   259: getfield data : Ljava/util/List;
            //   262: iconst_0
            //   263: invokeinterface get : (I)Ljava/lang/Object;
            //   268: checkcast com/soft/blued/ui/msg/model/UserGiftModel
            //   271: getfield lucky_bag : Lcom/soft/blued/ui/user/model/GiftGivingOptionForJsonParse;
            //   274: ifnull -> 441
            //   277: aload_1
            //   278: getfield data : Ljava/util/List;
            //   281: iconst_0
            //   282: invokeinterface get : (I)Ljava/lang/Object;
            //   287: checkcast com/soft/blued/ui/msg/model/UserGiftModel
            //   290: getfield lucky_bag : Lcom/soft/blued/ui/user/model/GiftGivingOptionForJsonParse;
            //   293: getfield state : I
            //   296: iconst_1
            //   297: if_icmpne -> 441
            //   300: aload_1
            //   301: getfield data : Ljava/util/List;
            //   304: iconst_0
            //   305: invokeinterface get : (I)Ljava/lang/Object;
            //   310: checkcast com/soft/blued/ui/msg/model/UserGiftModel
            //   313: getfield lucky_bag : Lcom/soft/blued/ui/user/model/GiftGivingOptionForJsonParse;
            //   316: iconst_m1
            //   317: putfield type : I
            //   320: aload_1
            //   321: getfield data : Ljava/util/List;
            //   324: iconst_0
            //   325: invokeinterface get : (I)Ljava/lang/Object;
            //   330: checkcast com/soft/blued/ui/msg/model/UserGiftModel
            //   333: getfield list : Ljava/util/List;
            //   336: ifnull -> 380
            //   339: aload_1
            //   340: getfield data : Ljava/util/List;
            //   343: iconst_0
            //   344: invokeinterface get : (I)Ljava/lang/Object;
            //   349: checkcast com/soft/blued/ui/msg/model/UserGiftModel
            //   352: getfield list : Ljava/util/List;
            //   355: iconst_0
            //   356: aload_1
            //   357: getfield data : Ljava/util/List;
            //   360: iconst_0
            //   361: invokeinterface get : (I)Ljava/lang/Object;
            //   366: checkcast com/soft/blued/ui/msg/model/UserGiftModel
            //   369: getfield lucky_bag : Lcom/soft/blued/ui/user/model/GiftGivingOptionForJsonParse;
            //   372: invokeinterface add : (ILjava/lang/Object;)V
            //   377: goto -> 441
            //   380: aload_1
            //   381: getfield data : Ljava/util/List;
            //   384: iconst_0
            //   385: invokeinterface get : (I)Ljava/lang/Object;
            //   390: checkcast com/soft/blued/ui/msg/model/UserGiftModel
            //   393: new java/util/ArrayList
            //   396: dup
            //   397: invokespecial <init> : ()V
            //   400: putfield list : Ljava/util/List;
            //   403: aload_1
            //   404: getfield data : Ljava/util/List;
            //   407: iconst_0
            //   408: invokeinterface get : (I)Ljava/lang/Object;
            //   413: checkcast com/soft/blued/ui/msg/model/UserGiftModel
            //   416: getfield list : Ljava/util/List;
            //   419: aload_1
            //   420: getfield data : Ljava/util/List;
            //   423: iconst_0
            //   424: invokeinterface get : (I)Ljava/lang/Object;
            //   429: checkcast com/soft/blued/ui/msg/model/UserGiftModel
            //   432: getfield lucky_bag : Lcom/soft/blued/ui/user/model/GiftGivingOptionForJsonParse;
            //   435: invokeinterface add : (Ljava/lang/Object;)Z
            //   440: pop
            //   441: aload_0
            //   442: getfield a : [I
            //   445: astore #4
            //   447: aload #4
            //   449: ifnull -> 466
            //   452: aload #4
            //   454: arraylength
            //   455: ifle -> 466
            //   458: aload #4
            //   460: iconst_0
            //   461: iaload
            //   462: istore_3
            //   463: goto -> 468
            //   466: iconst_0
            //   467: istore_3
            //   468: aload_0
            //   469: getfield b : Landroid/content/Context;
            //   472: astore #5
            //   474: aload #5
            //   476: checkcast androidx/fragment/app/FragmentActivity
            //   479: astore #4
            //   481: new com/soft/blued/ui/msg/pop/UserGiftDialogFragment
            //   484: dup
            //   485: aload #5
            //   487: aload_0
            //   488: getfield c : Lcom/blued/android/core/ui/ActivityFragmentActive;
            //   491: aload_0
            //   492: getfield d : Ljava/lang/String;
            //   495: aload_0
            //   496: getfield e : Ljava/lang/String;
            //   499: aload_1
            //   500: getfield data : Ljava/util/List;
            //   503: iconst_0
            //   504: invokeinterface get : (I)Ljava/lang/Object;
            //   509: checkcast com/soft/blued/ui/msg/model/UserGiftModel
            //   512: getfield list : Ljava/util/List;
            //   515: iload_2
            //   516: iload_3
            //   517: aload_0
            //   518: getfield f : Ljava/lang/String;
            //   521: aload_0
            //   522: getfield g : Ljava/lang/String;
            //   525: invokespecial <init> : (Landroid/content/Context;Lcom/blued/android/core/ui/ActivityFragmentActive;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;IILjava/lang/String;Ljava/lang/String;)V
            //   528: astore_1
            //   529: aload_1
            //   530: aload_0
            //   531: getfield h : Lcom/soft/blued/ui/msg/pop/UserGiftDialogFragment$BuySucceedListener;
            //   534: putfield b : Lcom/soft/blued/ui/msg/pop/UserGiftDialogFragment$BuySucceedListener;
            //   537: aload_1
            //   538: aload #4
            //   540: invokevirtual getSupportFragmentManager : ()Landroidx/fragment/app/FragmentManager;
            //   543: ldc ''
            //   545: invokevirtual show : (Landroidx/fragment/app/FragmentManager;Ljava/lang/String;)V
            //   548: return
            //   549: invokestatic d : ()Landroid/content/Context;
            //   552: ldc 2131758232
            //   554: invokevirtual getString : (I)Ljava/lang/String;
            //   557: invokestatic a : (Ljava/lang/String;)V
            //   560: return
          }
          
          public boolean onUIFailure(int param1Int, String param1String) {
            return super.onUIFailure(param1Int, param1String);
          }
          
          public void onUIFinish() {
            super.onUIFinish();
          }
        }paramString1, (IRequestHost)paramActivityFragmentActive);
  }
  
  private void l() {
    RelativeLayout relativeLayout = this.k;
    if (relativeLayout != null && this.l != null) {
      relativeLayout.setVisibility(8);
      this.l.setVisibility(8);
      if (getContext() instanceof Activity)
        ((Activity)getContext()).getWindow().setSoftInputMode(19); 
    } 
  }
  
  public boolean V_() {
    l();
    return super.V_();
  }
  
  public void a(View paramView) {
    FragmentActivity fragmentActivity = this.c;
    if (fragmentActivity != null) {
      PersonalProfileProtos.GiftFrom giftFrom;
      fragmentActivity.getWindow().setSoftInputMode(48);
      PersonalProfileProtos.Event event = PersonalProfileProtos.Event.GIFT_BUY_PAGE_SHOW;
      String str = this.d;
      if ("user_page_gift".equals(this.e)) {
        giftFrom = PersonalProfileProtos.GiftFrom.PERSONAL_PAGE;
      } else {
        giftFrom = PersonalProfileProtos.GiftFrom.MESSAGE_PAGE;
      } 
      EventTrackPersonalProfile.a(event, str, giftFrom);
      this.j = (AutoHeightViewPager)paramView.findViewById(2131296486);
      this.i = new UserGiftFmAdapter(getChildFragmentManager(), this.h, this.d, this.e, this.g, this.f, this.b, this);
      this.j.addOnPageChangeListener(new ViewPager.OnPageChangeListener(this) {
            public void onPageScrollStateChanged(int param1Int) {}
            
            public void onPageScrolled(int param1Int1, float param1Float, int param1Int2) {}
            
            public void onPageSelected(int param1Int) {
              UserGiftDialogFragment.a(this.a).c(param1Int);
              UserGiftDialogFragment.a(this.a, param1Int);
              UserGiftDialogFragment.b(this.a).setVisibility(8);
              UserGiftDialogFragment.c(this.a).setVisibility(8);
              TextView textView = UserGiftDialogFragment.d(this.a);
              Context context = this.a.getContext();
              int j = 2131100806;
              if (param1Int == 0) {
                i = 2131100806;
              } else {
                i = 2131100808;
              } 
              textView.setTextColor(ContextCompat.getColor(context, i));
              textView = UserGiftDialogFragment.e(this.a);
              context = this.a.getContext();
              int i = j;
              if (param1Int == 0)
                i = 2131100808; 
              textView.setTextColor(ContextCompat.getColor(context, i));
              if (param1Int == 0) {
                if ((UserGiftDialogFragment.f(this.a)).a != null)
                  (UserGiftDialogFragment.f(this.a)).a.n(); 
              } else if (param1Int == 1 && (UserGiftDialogFragment.f(this.a)).b != null) {
                (UserGiftDialogFragment.f(this.a)).b.n();
              } 
              if (UserGiftDialogFragment.g(this.a).getVisibility() == 0 && param1Int == 1) {
                UserGiftDialogFragment.g(this.a).setVisibility(8);
                BluedPreferences.V(false);
              } 
            }
          });
      this.j.setCurrentItem(2);
      this.j.setAdapter((PagerAdapter)this.i);
      this.k = (RelativeLayout)paramView.findViewById(2131296759);
      this.l = (LinearLayout)paramView.findViewById(2131299117);
      this.o = (LinearLayout)paramView.findViewById(2131298758);
      this.m = (TextView)paramView.findViewById(2131301437);
      this.n = (TextView)paramView.findViewById(2131300788);
      this.p = (TextView)paramView.findViewById(2131301433);
      this.q = (TextView)paramView.findViewById(2131300799);
      this.r = (TextView)paramView.findViewById(2131301158);
      this.t = paramView.findViewById(2131301617);
      this.u = (FrameLayout)paramView.findViewById(2131297196);
      this.w = (TextView)paramView.findViewById(2131299607);
      this.s = (ImageView)paramView.findViewById(2131297774);
      this.v = (TextView)paramView.findViewById(2131300789);
      this.t.setOnClickListener(this);
      this.q.setOnClickListener(this);
      this.r.setOnClickListener(this);
      LiveEventBus.get("gift_hint", GiftHintEvent.class).observe((LifecycleOwner)this.c, new Observer<GiftHintEvent>(this) {
            public void a(GiftHintEvent param1GiftHintEvent) {
              LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams)UserGiftDialogFragment.h(this.a).getLayoutParams();
              UserGiftDialogFragment.b(this.a).setVisibility(8);
              UserGiftDialogFragment.c(this.a).setVisibility(8);
              if (!param1GiftHintEvent.d) {
                layoutParams.topMargin = 0;
              } else {
                layoutParams.topMargin = -DensityUtil.a(16.0F);
                if (param1GiftHintEvent.a == 2 || param1GiftHintEvent.a == 3) {
                  UserGiftDialogFragment.c(this.a).setVisibility(0);
                  UserGiftDialogFragment.i(this.a).setText(param1GiftHintEvent.b);
                  UserGiftDialogFragment.j(this.a).setVisibility(0);
                  if (param1GiftHintEvent.a == 3)
                    UserGiftDialogFragment.j(this.a).setText(this.a.getString(2131757986)); 
                } else if (param1GiftHintEvent.a == 1) {
                  UserGiftDialogFragment.j(this.a).setVisibility(8);
                  UserGiftDialogFragment.c(this.a).setVisibility(0);
                  UserGiftDialogFragment.i(this.a).setText(param1GiftHintEvent.b);
                } else {
                  if (!TextUtils.isEmpty(param1GiftHintEvent.e))
                    ImageLoader.a((IRequestHost)this.a.a, param1GiftHintEvent.e).a(UserGiftDialogFragment.k(this.a)); 
                  UserGiftDialogFragment.b(this.a).setVisibility(0);
                  UserGiftDialogFragment.l(this.a).setText(param1GiftHintEvent.b);
                  UserGiftDialogFragment.m(this.a).setText(param1GiftHintEvent.c);
                } 
              } 
              UserGiftDialogFragment.h(this.a).setLayoutParams((ViewGroup.LayoutParams)layoutParams);
            }
          });
      if (BluedPreferences.ez())
        this.w.setVisibility(0); 
      LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams)this.o.getLayoutParams();
      this.k.setVisibility(8);
      this.l.setVisibility(8);
      this.o.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
      int i = this.x;
      if (i != 0)
        this.j.setCurrentItem(i); 
      return;
    } 
    dismiss();
  }
  
  public int f() {
    return 2131494070;
  }
  
  public int g() {
    return -1;
  }
  
  public AutoHeightViewPager h() {
    return this.j;
  }
  
  public String i() {
    return this.y;
  }
  
  public int j() {
    return this.x;
  }
  
  public int k() {
    return -1;
  }
  
  public void onClick(View paramView) {
    int i = paramView.getId();
    if (i != 2131300799) {
      PersonalProfileProtos.GiftFrom giftFrom;
      if (i != 2131301158) {
        if (i != 2131301617)
          return; 
        dismiss();
        return;
      } 
      PersonalProfileProtos.Event event = PersonalProfileProtos.Event.GIFT_BUY_PAGE_BAG_CLICK;
      String str = this.d;
      if (this.e.equals("user_page_gift")) {
        giftFrom = PersonalProfileProtos.GiftFrom.PERSONAL_PAGE;
      } else {
        giftFrom = PersonalProfileProtos.GiftFrom.MESSAGE_PAGE;
      } 
      EventTrackPersonalProfile.b(event, str, giftFrom);
      this.j.setCurrentItem(1);
      return;
    } 
    this.j.setCurrentItem(0);
  }
  
  public void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    setStyle(0, 16973834);
  }
  
  public void onDismiss(DialogInterface paramDialogInterface) {
    super.onDismiss(paramDialogInterface);
    l();
  }
  
  public static interface BuySucceedListener {
    void a(UserGiftDialogFragment param1UserGiftDialogFragment, GiftGivingOptionForJsonParse param1GiftGivingOptionForJsonParse);
  }
  
  public static class UserGiftFmAdapter extends FragmentPagerAdapter {
    public UserGiftFragment a;
    
    public UserGiftPackageFragment b;
    
    private List<GiftGivingOptionForJsonParse> c;
    
    private String d;
    
    private String e;
    
    private UserGiftDialogFragment.BuySucceedListener f;
    
    private UserGiftDialogFragment g;
    
    private int h;
    
    private String i;
    
    public UserGiftFmAdapter(FragmentManager param1FragmentManager, List<GiftGivingOptionForJsonParse> param1List, String param1String1, String param1String2, int param1Int, String param1String3, UserGiftDialogFragment.BuySucceedListener param1BuySucceedListener, UserGiftDialogFragment param1UserGiftDialogFragment) {
      super(param1FragmentManager, 1);
      this.c = param1List;
      this.d = param1String1;
      this.e = param1String2;
      this.f = param1BuySucceedListener;
      this.g = param1UserGiftDialogFragment;
      this.h = param1Int;
      this.i = param1String3;
    }
    
    public int getCount() {
      return 2;
    }
    
    public Fragment getItem(int param1Int) {
      if (param1Int == 0) {
        this.a = new UserGiftFragment(this.c, this.d, this.e, this.h, this.i, this.f, this.g);
        return (Fragment)this.a;
      } 
      if (param1Int == 1) {
        this.b = new UserGiftPackageFragment(this.d, this.e, this.i, this.f, this.g);
        return (Fragment)this.b;
      } 
      return null;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\msg\pop\UserGiftDialogFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */