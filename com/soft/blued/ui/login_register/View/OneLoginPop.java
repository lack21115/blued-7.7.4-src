package com.soft.blued.ui.login_register.View;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.blued.android.chat.ChatManager;
import com.blued.android.core.AppInfo;
import com.blued.android.core.AppMethods;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.ui.xpop.XPopup;
import com.blued.android.framework.ui.xpop.core.BasePopupView;
import com.blued.android.framework.ui.xpop.core.CenterPopupView;
import com.blued.android.framework.utils.AesCrypto;
import com.blued.android.framework.view.shape.ShapeHelper;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.das.login.LoginAndRegisterProtos;
import com.geetest.onelogin.OneLoginHelper;
import com.google.gson.reflect.TypeToken;
import com.soft.blued.constant.LoginConstants;
import com.soft.blued.http.H5Url;
import com.soft.blued.http.LoginRegisterHttpUtils;
import com.soft.blued.log.trackUtils.EventTrackLoginAndRegister;
import com.soft.blued.push.PushManager;
import com.soft.blued.ui.home.HomeArgumentHelper;
import com.soft.blued.ui.login_register.AdultVerifyFragment;
import com.soft.blued.ui.login_register.model.AVConfigExtra;
import com.soft.blued.ui.login_register.model.BluedLoginResult;
import com.soft.blued.ui.login_register.presenter.LoginWithTypePresenter;
import com.soft.blued.ui.web.WebViewShowInfoFragment;
import com.soft.blued.user.AVConfig;
import com.soft.blued.user.UserInfo;
import com.soft.blued.utils.BluedPreferences;
import com.soft.blued.utils.Logger;
import com.soft.blued.utils.TypefaceUtils;
import com.soft.blued.utils.third.GeeTestUtils;
import com.soft.blued.utils.third.model.OneLoginResult;

public class OneLoginPop extends CenterPopupView {
  public CheckBox A;
  
  public TextView B;
  
  public String C;
  
  public TextView c;
  
  public ImageView d;
  
  public LinearLayout e;
  
  public ShapeTextView f;
  
  public ShapeTextView g;
  
  public ShapeTextView h;
  
  public LinearLayout i;
  
  public CheckBox j;
  
  public TextView k;
  
  public Context t;
  
  public View u;
  
  public IRequestHost v;
  
  public final String w = "OneLoginPop";
  
  public String x;
  
  public String y;
  
  public View z;
  
  public OneLoginPop(Context paramContext, String paramString, IRequestHost paramIRequestHost) {
    super(paramContext);
    this.t = paramContext;
    this.v = paramIRequestHost;
    this.y = paramString;
  }
  
  public static void a(Context paramContext, String paramString, IRequestHost paramIRequestHost) {
    OneLoginPop oneLoginPop = new OneLoginPop(paramContext, paramString, paramIRequestHost);
    (new XPopup.Builder(paramContext)).a((BasePopupView)oneLoginPop).h();
    EventTrackLoginAndRegister.a(LoginAndRegisterProtos.Event.ONE_CLICK_POP_SHOW);
  }
  
  private void c() {
    this.u = findViewById(2131299451);
    this.u.setVisibility(8);
    this.c = (TextView)findViewById(2131301409);
    this.d = (ImageView)findViewById(2131297457);
    this.d.setOnClickListener(new -$$Lambda$OneLoginPop$Eos_5uo_TKqsLSukGkQCVUTRPuE(this));
    this.e = (LinearLayout)findViewById(2131299014);
    this.f = (ShapeTextView)findViewById(2131301169);
    this.g = (ShapeTextView)findViewById(2131301170);
    this.g.setText(this.y);
    this.z = findViewById(2131298998);
    this.A = (CheckBox)findViewById(2131296671);
    this.B = (TextView)findViewById(2131301142);
    String str = OneLoginHelper.with().getSimOperator(this.t);
    if (str.equals("CU")) {
      str = this.t.getResources().getString(2131756141);
      this.C = "https://opencloud.wostore.cn/authz/resource/html/disclaimer.html?fromsdk=true";
    } else if (str.equals("CM")) {
      str = this.t.getResources().getString(2131756038);
      this.C = "https://wap.cmpassport.com/resources/html/contract.html";
    } else {
      str = this.t.getResources().getString(2131756140);
      this.C = "https://e.189.cn/sdk/agreement/detail.do?hidetop=true";
    } 
    this.B.setText(String.format(this.t.getResources().getString(2131758332), new Object[] { str }));
    this.h = (ShapeTextView)findViewById(2131300656);
    this.h.setOnClickListener(new -$$Lambda$OneLoginPop$gqy3uRaYwzLhkbhkmAdu4aqJcxc(this));
    this.i = (LinearLayout)findViewById(2131299097);
    this.j = (CheckBox)findViewById(2131296672);
    this.j.setOnCheckedChangeListener(new -$$Lambda$OneLoginPop$jtV-JDAPUIoyiIXUzkz3JI4ZgrM(this));
    this.A.setOnCheckedChangeListener(new -$$Lambda$OneLoginPop$GobNGuHcbE196OJE2Mxh80lEy4Q(this));
    e();
    this.k = (TextView)findViewById(2131301375);
    TypefaceUtils.a(this.t, this.k, new -$$Lambda$OneLoginPop$fg5QOtMshWCzHopTER7PYjjy7sk(this), new TypefaceUtils.SpannIndex(12, 26), new TypefaceUtils.SpannIndex(77, 96));
    TypefaceUtils.a(this.t, this.k, new -$$Lambda$OneLoginPop$2bWfshI9uohgveMN22o-iEFgYlg(this), new TypefaceUtils.SpannIndex(27, 37), new TypefaceUtils.SpannIndex(99, 114));
    TypefaceUtils.a(this.t, this.B, new -$$Lambda$OneLoginPop$MHYaoTnWNPaGMV7_UHgCbdWAkRw(this), new TypefaceUtils.SpannIndex(8, str.length() + 8), new TypefaceUtils.SpannIndex(56, str.length() + 56));
  }
  
  private BluedUIHttpResponse d() {
    return new BluedUIHttpResponse<BluedEntity<BluedLoginResult, AVConfigExtra>>(this, this.v) {
        public boolean onUIFailure(int param1Int, String param1String1, String param1String2) {
          // Byte code:
          //   0: aload_0
          //   1: getfield a : Lcom/soft/blued/ui/login_register/View/OneLoginPop;
          //   4: getfield u : Landroid/view/View;
          //   7: bipush #8
          //   9: invokevirtual setVisibility : (I)V
          //   12: new java/lang/StringBuilder
          //   15: dup
          //   16: invokespecial <init> : ()V
          //   19: astore #7
          //   21: aload #7
          //   23: ldc 'login fail:'
          //   25: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   28: pop
          //   29: aload #7
          //   31: aload_3
          //   32: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   35: pop
          //   36: ldc 'OneLoginPop'
          //   38: aload #7
          //   40: invokevirtual toString : ()Ljava/lang/String;
          //   43: invokestatic a : (Ljava/lang/String;Ljava/lang/Object;)V
          //   46: iconst_0
          //   47: istore #5
          //   49: iload_1
          //   50: ldc 4036220
          //   52: if_icmpeq -> 343
          //   55: iload_1
          //   56: ldc 4036300
          //   58: if_icmpeq -> 185
          //   61: iload_1
          //   62: ldc 4036501
          //   64: if_icmpeq -> 73
          //   67: iconst_1
          //   68: istore #4
          //   70: goto -> 353
          //   73: invokestatic f : ()Lcom/google/gson/Gson;
          //   76: aload_3
          //   77: new com/soft/blued/ui/login_register/View/OneLoginPop$2$1
          //   80: dup
          //   81: aload_0
          //   82: invokespecial <init> : (Lcom/soft/blued/ui/login_register/View/OneLoginPop$2;)V
          //   85: invokevirtual getType : ()Ljava/lang/reflect/Type;
          //   88: invokevirtual fromJson : (Ljava/lang/String;Ljava/lang/reflect/Type;)Ljava/lang/Object;
          //   91: checkcast com/blued/android/framework/http/parser/BluedEntityA
          //   94: astore_3
          //   95: iload #5
          //   97: istore #4
          //   99: aload_3
          //   100: ifnull -> 353
          //   103: iload #5
          //   105: istore #4
          //   107: aload_3
          //   108: getfield data : Ljava/util/List;
          //   111: ifnull -> 353
          //   114: iload #5
          //   116: istore #4
          //   118: aload_3
          //   119: getfield data : Ljava/util/List;
          //   122: invokeinterface size : ()I
          //   127: ifle -> 353
          //   130: aload_3
          //   131: getfield data : Ljava/util/List;
          //   134: iconst_0
          //   135: invokeinterface get : (I)Ljava/lang/Object;
          //   140: checkcast com/soft/blued/ui/login_register/model/BluedLoginResult
          //   143: astore #7
          //   145: aload #7
          //   147: getfield reason : Ljava/lang/String;
          //   150: astore_3
          //   151: aload #7
          //   153: getfield uid : Ljava/lang/String;
          //   156: astore #7
          //   158: aload_0
          //   159: getfield a : Lcom/soft/blued/ui/login_register/View/OneLoginPop;
          //   162: getfield t : Landroid/content/Context;
          //   165: aload_3
          //   166: aload #7
          //   168: invokestatic a : (Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V
          //   171: iload #5
          //   173: istore #4
          //   175: goto -> 353
          //   178: iload #5
          //   180: istore #4
          //   182: goto -> 353
          //   185: invokestatic f : ()Lcom/google/gson/Gson;
          //   188: astore #7
          //   190: aload #7
          //   192: aload_3
          //   193: new com/soft/blued/ui/login_register/View/OneLoginPop$2$2
          //   196: dup
          //   197: aload_0
          //   198: invokespecial <init> : (Lcom/soft/blued/ui/login_register/View/OneLoginPop$2;)V
          //   201: invokevirtual getType : ()Ljava/lang/reflect/Type;
          //   204: invokevirtual fromJson : (Ljava/lang/String;Ljava/lang/reflect/Type;)Ljava/lang/Object;
          //   207: checkcast com/blued/android/framework/http/parser/BluedEntityA
          //   210: astore_3
          //   211: aload_3
          //   212: ifnull -> 67
          //   215: aload_3
          //   216: getfield data : Ljava/util/List;
          //   219: ifnull -> 67
          //   222: aload_3
          //   223: getfield data : Ljava/util/List;
          //   226: invokeinterface size : ()I
          //   231: ifle -> 67
          //   234: aload_3
          //   235: invokevirtual getSingleData : ()Ljava/lang/Object;
          //   238: checkcast com/soft/blued/ui/login_register/model/BluedLoginResult
          //   241: invokevirtual get_ : ()Ljava/lang/String;
          //   244: invokestatic c : (Ljava/lang/String;)Ljava/lang/String;
          //   247: astore_3
          //   248: new java/lang/StringBuilder
          //   251: dup
          //   252: invokespecial <init> : ()V
          //   255: astore #8
          //   257: aload #8
          //   259: ldc '未注册手机返回：'
          //   261: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   264: pop
          //   265: aload #8
          //   267: aload_3
          //   268: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   271: pop
          //   272: ldc 'OneLoginPop'
          //   274: aload #8
          //   276: invokevirtual toString : ()Ljava/lang/String;
          //   279: invokestatic a : (Ljava/lang/String;Ljava/lang/Object;)V
          //   282: aload #7
          //   284: aload_3
          //   285: ldc com/soft/blued/model/BluedAlbum
          //   287: invokevirtual fromJson : (Ljava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;
          //   290: checkcast com/soft/blued/model/BluedAlbum
          //   293: astore_3
          //   294: aload_3
          //   295: ifnull -> 67
          //   298: aload_3
          //   299: getfield token : Ljava/lang/String;
          //   302: invokestatic e : (Ljava/lang/String;)Z
          //   305: istore #6
          //   307: iload #6
          //   309: ifne -> 67
          //   312: aload_0
          //   313: getfield a : Lcom/soft/blued/ui/login_register/View/OneLoginPop;
          //   316: getfield t : Landroid/content/Context;
          //   319: aload_3
          //   320: getfield token : Ljava/lang/String;
          //   323: ldc ''
          //   325: ldc 'onclick'
          //   327: aload_3
          //   328: getfield token : Ljava/lang/String;
          //   331: ldc ''
          //   333: invokestatic a : (Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
          //   336: iload #5
          //   338: istore #4
          //   340: goto -> 353
          //   343: aload_0
          //   344: getfield a : Lcom/soft/blued/ui/login_register/View/OneLoginPop;
          //   347: invokevirtual p : ()V
          //   350: goto -> 67
          //   353: iload #4
          //   355: ifeq -> 365
          //   358: aload_0
          //   359: iload_1
          //   360: aload_2
          //   361: invokespecial onUIFailure : (ILjava/lang/String;)Z
          //   364: ireturn
          //   365: iconst_1
          //   366: ireturn
          //   367: astore_3
          //   368: goto -> 178
          //   371: astore_3
          //   372: goto -> 67
          // Exception table:
          //   from	to	target	type
          //   73	95	367	java/lang/Exception
          //   107	114	367	java/lang/Exception
          //   118	171	367	java/lang/Exception
          //   185	211	371	java/lang/Exception
          //   215	294	371	java/lang/Exception
          //   298	307	371	java/lang/Exception
          //   312	336	367	java/lang/Exception
        }
        
        public void onUIFinish() {}
        
        public void onUIUpdate(BluedEntity<BluedLoginResult, AVConfigExtra> param1BluedEntity) {
          if (param1BluedEntity != null)
            try {
              if (param1BluedEntity.hasData() && param1BluedEntity.data.get(0) != null) {
                EventTrackLoginAndRegister.a(LoginAndRegisterProtos.Event.LOGIN_SUCCESS, LoginAndRegisterProtos.Source.ONE_CLICK);
                boolean bool = true;
                Logger.b("OneLoginPop", new Object[] { param1BluedEntity });
                if (param1BluedEntity.extra != null)
                  AVConfig.a().a(((AVConfigExtra)param1BluedEntity.extra).is_kids, false); 
                BluedLoginResult bluedLoginResult = param1BluedEntity.data.get(0);
                Logger.b("OneLoginPop", new Object[] { "===success", "加密：responseJson:", param1BluedEntity });
                String str = bluedLoginResult.uid;
                UserInfo.a().a(str, 2, this.a.x, bluedLoginResult, new String[] { "" });
                PushManager.a().d();
                if (bluedLoginResult != null && bluedLoginResult.getNeedAdultVerify() == 1) {
                  AdultVerifyFragment.a(this.a.t);
                  return;
                } 
                Bundle bundle = new Bundle();
                bundle.putString("from_tag_page", "from_tag_login");
                HomeArgumentHelper.a(this.a.t, null, bundle);
                LoginConstants.a = "";
                LoginWithTypePresenter.e();
                ChatManager.getInstance().initLanguage();
                if (bluedLoginResult.getDevice_safe() != 1)
                  bool = false; 
                BluedPreferences.D(bool);
                return;
              } 
            } catch (Exception exception) {
              exception.printStackTrace();
              AppMethods.a(this.a.t.getResources().getString(2131756082));
            }  
        }
        
        public BluedEntity<BluedLoginResult, AVConfigExtra> parseData(String param1String) {
          this.a.x = param1String;
          BluedEntity<BluedLoginResult, AVConfigExtra> bluedEntity = super.parseData(param1String);
          if (bluedEntity != null)
            try {
              if (bluedEntity.data != null && bluedEntity.data.size() > 0) {
                String str = AesCrypto.c(((BluedLoginResult)bluedEntity.data.get(0)).get_());
                Logger.b("OneLoginPop", new Object[] { "解密：deData===", str });
                BluedLoginResult bluedLoginResult = (BluedLoginResult)AppInfo.f().fromJson(str, BluedLoginResult.class);
                bluedEntity.data.set(0, bluedLoginResult);
                return bluedEntity;
              } 
            } catch (Exception exception) {
              exception.printStackTrace();
              AppMethods.a(AppInfo.d().getResources().getString(2131756082));
            }  
          return bluedEntity;
        }
      };
  }
  
  private void e() {
    if (this.j.isChecked() && this.A.isChecked()) {
      this.h.setEnabled(true);
      ShapeHelper.b((ShapeHelper.ShapeView)this.h, 2131100716);
      return;
    } 
    this.h.setEnabled(false);
    ShapeHelper.b((ShapeHelper.ShapeView)this.h, 2131100719);
  }
  
  public void b() {
    super.b();
    c();
  }
  
  public int getImplLayoutId() {
    return 2131493257;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\login_register\View\OneLoginPop.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */