package com.soft.blued.ui.login_register.presenter;

import android.content.Context;
import android.text.TextUtils;
import com.blued.android.core.AppInfo;
import com.blued.android.core.AppMethods;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.http.BluedHttpTools;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.utils.AesCrypto;
import com.blued.android.framework.utils.LocaleUtils;
import com.blued.das.login.LoginAndRegisterProtos;
import com.google.gson.reflect.TypeToken;
import com.jeremyliao.liveeventbus.LiveEventBus;
import com.soft.blued.app.BluedApplicationLike;
import com.soft.blued.db.UserAccountsVDao;
import com.soft.blued.http.LoginRegisterHttpUtils;
import com.soft.blued.log.trackUtils.EventTrackLoginAndRegister;
import com.soft.blued.ui.login_register.Contract.LoginWithTypeContract;
import com.soft.blued.ui.login_register.model.AVConfigExtra;
import com.soft.blued.ui.login_register.model.BluedLoginResult;
import com.soft.blued.user.AVConfig;
import com.soft.blued.user.UserInfo;
import com.soft.blued.utils.BluedPreferences;
import com.soft.blued.utils.Logger;
import com.soft.blued.utils.UserRelationshipUtils;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Locale;

public class LoginWithTypePresenter implements LoginWithTypeContract.IPresenter {
  private final String a = LoginWithTypePresenter.class.getSimpleName();
  
  private Context b;
  
  private IRequestHost c;
  
  private LoginWithTypeContract.IView d;
  
  private String e;
  
  private String f;
  
  private String g;
  
  private String h;
  
  private String i;
  
  private String j;
  
  private String k;
  
  public LoginWithTypePresenter(Context paramContext, LoginWithTypeContract.IView paramIView, IRequestHost paramIRequestHost) {
    if (paramIView != null && paramContext != null) {
      this.d = paramIView;
      this.c = paramIRequestHost;
      this.b = paramContext;
    } 
  }
  
  public static void e() {
    String str;
    Locale locale = LocaleUtils.c();
    if (locale != null) {
      str = locale.getLanguage();
    } else {
      str = "";
    } 
    if (!TextUtils.isEmpty(str)) {
      if (BluedPreferences.aE()) {
        BluedApplicationLike.previousLanguage = str;
        return;
      } 
      BluedApplicationLike.previousLanguage = null;
    } 
  }
  
  public BluedUIHttpResponse a(String paramString1, String paramString2, boolean paramBoolean, LoginRegisterHttpUtils.PHONE_CODE_LOGIN_STAGE paramPHONE_CODE_LOGIN_STAGE) {
    return new BluedUIHttpResponse<BluedEntity<BluedLoginResult, AVConfigExtra>>(this, this.c, paramPHONE_CODE_LOGIN_STAGE, paramString1, paramString2, paramBoolean) {
        public boolean onUIFailure(int param1Int, String param1String1, String param1String2) {
          // Byte code:
          //   0: iconst_0
          //   1: istore #4
          //   3: iload_1
          //   4: lookupswitch default -> 56, 401 -> 563, 4035009 -> 294, 4036002 -> 206, 4036205 -> 206, 4036501 -> 99
          //   56: aload_0
          //   57: getfield d : Z
          //   60: ifeq -> 617
          //   63: aload_0
          //   64: getfield e : Lcom/soft/blued/ui/login_register/presenter/LoginWithTypePresenter;
          //   67: invokevirtual b : ()Ljava/lang/String;
          //   70: invokestatic e : (Ljava/lang/String;)Z
          //   73: ifne -> 650
          //   76: aload_0
          //   77: getfield e : Lcom/soft/blued/ui/login_register/presenter/LoginWithTypePresenter;
          //   80: invokestatic a : (Lcom/soft/blued/ui/login_register/presenter/LoginWithTypePresenter;)Lcom/soft/blued/ui/login_register/Contract/LoginWithTypeContract$IView;
          //   83: aload_0
          //   84: getfield e : Lcom/soft/blued/ui/login_register/presenter/LoginWithTypePresenter;
          //   87: invokevirtual b : ()Ljava/lang/String;
          //   90: iconst_1
          //   91: invokeinterface a : (Ljava/lang/String;Z)V
          //   96: goto -> 650
          //   99: invokestatic f : ()Lcom/google/gson/Gson;
          //   102: aload_3
          //   103: new com/soft/blued/ui/login_register/presenter/LoginWithTypePresenter$1$1
          //   106: dup
          //   107: aload_0
          //   108: invokespecial <init> : (Lcom/soft/blued/ui/login_register/presenter/LoginWithTypePresenter$1;)V
          //   111: invokevirtual getType : ()Ljava/lang/reflect/Type;
          //   114: invokevirtual fromJson : (Ljava/lang/String;Ljava/lang/reflect/Type;)Ljava/lang/Object;
          //   117: checkcast com/blued/android/framework/http/parser/BluedEntityA
          //   120: astore_3
          //   121: iload #4
          //   123: istore_1
          //   124: aload_3
          //   125: ifnull -> 652
          //   128: iload #4
          //   130: istore_1
          //   131: aload_3
          //   132: getfield data : Ljava/util/List;
          //   135: ifnull -> 652
          //   138: iload #4
          //   140: istore_1
          //   141: aload_3
          //   142: getfield data : Ljava/util/List;
          //   145: invokeinterface size : ()I
          //   150: ifle -> 652
          //   153: aload_3
          //   154: getfield data : Ljava/util/List;
          //   157: iconst_0
          //   158: invokeinterface get : (I)Ljava/lang/Object;
          //   163: checkcast com/soft/blued/ui/login_register/model/BluedLoginResult
          //   166: astore #5
          //   168: aload #5
          //   170: getfield reason : Ljava/lang/String;
          //   173: astore_3
          //   174: aload #5
          //   176: getfield uid : Ljava/lang/String;
          //   179: astore #5
          //   181: aload_0
          //   182: getfield e : Lcom/soft/blued/ui/login_register/presenter/LoginWithTypePresenter;
          //   185: invokestatic e : (Lcom/soft/blued/ui/login_register/presenter/LoginWithTypePresenter;)Landroid/content/Context;
          //   188: aload_3
          //   189: aload #5
          //   191: invokestatic a : (Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V
          //   194: iload #4
          //   196: istore_1
          //   197: goto -> 652
          //   200: iload #4
          //   202: istore_1
          //   203: goto -> 652
          //   206: aload_2
          //   207: invokestatic a : (Ljava/lang/CharSequence;)V
          //   210: aload_0
          //   211: getfield e : Lcom/soft/blued/ui/login_register/presenter/LoginWithTypePresenter;
          //   214: aload_3
          //   215: invokestatic b : (Ljava/lang/String;)[Ljava/lang/String;
          //   218: iconst_0
          //   219: aaload
          //   220: invokevirtual c : (Ljava/lang/String;)V
          //   223: aload_3
          //   224: invokestatic c : (Ljava/lang/String;)Z
          //   227: ifeq -> 248
          //   230: aload_0
          //   231: getfield e : Lcom/soft/blued/ui/login_register/presenter/LoginWithTypePresenter;
          //   234: invokestatic a : (Lcom/soft/blued/ui/login_register/presenter/LoginWithTypePresenter;)Lcom/soft/blued/ui/login_register/Contract/LoginWithTypeContract$IView;
          //   237: aload_0
          //   238: getfield d : Z
          //   241: invokeinterface a : (Z)V
          //   246: iconst_1
          //   247: ireturn
          //   248: aload_0
          //   249: getfield e : Lcom/soft/blued/ui/login_register/presenter/LoginWithTypePresenter;
          //   252: aload_3
          //   253: invokestatic b : (Ljava/lang/String;)[Ljava/lang/String;
          //   256: iconst_1
          //   257: aaload
          //   258: invokestatic b : (Lcom/soft/blued/ui/login_register/presenter/LoginWithTypePresenter;Ljava/lang/String;)Ljava/lang/String;
          //   261: pop
          //   262: aload_0
          //   263: getfield e : Lcom/soft/blued/ui/login_register/presenter/LoginWithTypePresenter;
          //   266: invokestatic a : (Lcom/soft/blued/ui/login_register/presenter/LoginWithTypePresenter;)Lcom/soft/blued/ui/login_register/Contract/LoginWithTypeContract$IView;
          //   269: aload_0
          //   270: getfield e : Lcom/soft/blued/ui/login_register/presenter/LoginWithTypePresenter;
          //   273: invokestatic f : (Lcom/soft/blued/ui/login_register/presenter/LoginWithTypePresenter;)Ljava/lang/String;
          //   276: aload_0
          //   277: getfield d : Z
          //   280: invokeinterface a : (Ljava/lang/String;Z)V
          //   285: iconst_1
          //   286: ireturn
          //   287: astore_2
          //   288: aload_2
          //   289: invokevirtual printStackTrace : ()V
          //   292: iconst_1
          //   293: ireturn
          //   294: new android/os/Bundle
          //   297: dup
          //   298: invokespecial <init> : ()V
          //   301: astore_2
          //   302: aload_3
          //   303: invokestatic d : (Ljava/lang/String;)Lcom/soft/blued/ui/login_register/model/BluedCheckResult;
          //   306: invokevirtual getToken : ()Ljava/lang/String;
          //   309: astore #5
          //   311: aload_3
          //   312: invokestatic d : (Ljava/lang/String;)Lcom/soft/blued/ui/login_register/model/BluedCheckResult;
          //   315: invokevirtual getLogin_mobile : ()Ljava/lang/String;
          //   318: astore #6
          //   320: aload_3
          //   321: invokestatic d : (Ljava/lang/String;)Lcom/soft/blued/ui/login_register/model/BluedCheckResult;
          //   324: invokevirtual getRelation_mobile : ()Ljava/lang/String;
          //   327: astore #7
          //   329: aload_3
          //   330: invokestatic d : (Ljava/lang/String;)Lcom/soft/blued/ui/login_register/model/BluedCheckResult;
          //   333: invokevirtual getLogin_email : ()Ljava/lang/String;
          //   336: astore #8
          //   338: aload_3
          //   339: invokestatic d : (Ljava/lang/String;)Lcom/soft/blued/ui/login_register/model/BluedCheckResult;
          //   342: invokevirtual getSafe_email : ()Ljava/lang/String;
          //   345: astore #9
          //   347: new java/lang/StringBuilder
          //   350: dup
          //   351: invokespecial <init> : ()V
          //   354: astore #10
          //   356: aload #10
          //   358: ldc 'put login_mobile:'
          //   360: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   363: pop
          //   364: aload #10
          //   366: aload #6
          //   368: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   371: pop
          //   372: aload #10
          //   374: ldc ' --  relation_mobile:'
          //   376: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   379: pop
          //   380: aload #10
          //   382: aload #7
          //   384: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   387: pop
          //   388: aload #10
          //   390: ldc ' --  login_email:'
          //   392: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   395: pop
          //   396: aload #10
          //   398: aload #8
          //   400: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   403: pop
          //   404: aload #10
          //   406: ldc ' --  safe_email:'
          //   408: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   411: pop
          //   412: aload #10
          //   414: aload #9
          //   416: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   419: pop
          //   420: ldc 'drb'
          //   422: aload #10
          //   424: invokevirtual toString : ()Ljava/lang/String;
          //   427: invokestatic v : (Ljava/lang/String;Ljava/lang/String;)I
          //   430: pop
          //   431: aload_2
          //   432: ldc 'token'
          //   434: aload #5
          //   436: invokevirtual putString : (Ljava/lang/String;Ljava/lang/String;)V
          //   439: aload_2
          //   440: ldc 'login_mobile'
          //   442: aload #6
          //   444: invokevirtual putString : (Ljava/lang/String;Ljava/lang/String;)V
          //   447: aload_2
          //   448: ldc 'relation_mobile'
          //   450: aload #7
          //   452: invokevirtual putString : (Ljava/lang/String;Ljava/lang/String;)V
          //   455: aload_2
          //   456: ldc 'login_email'
          //   458: aload #8
          //   460: invokevirtual putString : (Ljava/lang/String;Ljava/lang/String;)V
          //   463: aload_2
          //   464: ldc 'safe_email'
          //   466: aload #9
          //   468: invokevirtual putString : (Ljava/lang/String;Ljava/lang/String;)V
          //   471: aload_2
          //   472: ldc 'password'
          //   474: aload_0
          //   475: getfield e : Lcom/soft/blued/ui/login_register/presenter/LoginWithTypePresenter;
          //   478: invokestatic g : (Lcom/soft/blued/ui/login_register/presenter/LoginWithTypePresenter;)Ljava/lang/String;
          //   481: invokevirtual putString : (Ljava/lang/String;Ljava/lang/String;)V
          //   484: aload_2
          //   485: ldc 'login_type'
          //   487: aload_0
          //   488: getfield b : Ljava/lang/String;
          //   491: invokevirtual putString : (Ljava/lang/String;Ljava/lang/String;)V
          //   494: aload_2
          //   495: ldc 'login_account'
          //   497: aload_0
          //   498: getfield c : Ljava/lang/String;
          //   501: invokevirtual putString : (Ljava/lang/String;Ljava/lang/String;)V
          //   504: aload_2
          //   505: ldc 'key_uid'
          //   507: aload_3
          //   508: invokestatic d : (Ljava/lang/String;)Lcom/soft/blued/ui/login_register/model/BluedCheckResult;
          //   511: invokevirtual getUid : ()Ljava/lang/String;
          //   514: invokevirtual putString : (Ljava/lang/String;Ljava/lang/String;)V
          //   517: aload_0
          //   518: getfield e : Lcom/soft/blued/ui/login_register/presenter/LoginWithTypePresenter;
          //   521: invokestatic d : (Lcom/soft/blued/ui/login_register/presenter/LoginWithTypePresenter;)Ljava/lang/String;
          //   524: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
          //   527: ifne -> 543
          //   530: aload_2
          //   531: ldc 'aliasUserId'
          //   533: aload_0
          //   534: getfield e : Lcom/soft/blued/ui/login_register/presenter/LoginWithTypePresenter;
          //   537: invokestatic d : (Lcom/soft/blued/ui/login_register/presenter/LoginWithTypePresenter;)Ljava/lang/String;
          //   540: invokevirtual putString : (Ljava/lang/String;Ljava/lang/String;)V
          //   543: aload_2
          //   544: ldc 'target_type'
          //   546: iconst_0
          //   547: invokevirtual putInt : (Ljava/lang/String;I)V
          //   550: aload_0
          //   551: getfield e : Lcom/soft/blued/ui/login_register/presenter/LoginWithTypePresenter;
          //   554: invokestatic e : (Lcom/soft/blued/ui/login_register/presenter/LoginWithTypePresenter;)Landroid/content/Context;
          //   557: aload_2
          //   558: invokestatic a : (Landroid/content/Context;Landroid/os/Bundle;)V
          //   561: iconst_1
          //   562: ireturn
          //   563: aload_0
          //   564: getfield d : Z
          //   567: ifeq -> 615
          //   570: aload_0
          //   571: getfield e : Lcom/soft/blued/ui/login_register/presenter/LoginWithTypePresenter;
          //   574: invokestatic a : (Lcom/soft/blued/ui/login_register/presenter/LoginWithTypePresenter;)Lcom/soft/blued/ui/login_register/Contract/LoginWithTypeContract$IView;
          //   577: invokeinterface c : ()V
          //   582: aload_0
          //   583: getfield e : Lcom/soft/blued/ui/login_register/presenter/LoginWithTypePresenter;
          //   586: invokevirtual b : ()Ljava/lang/String;
          //   589: invokestatic e : (Ljava/lang/String;)Z
          //   592: ifne -> 615
          //   595: aload_0
          //   596: getfield e : Lcom/soft/blued/ui/login_register/presenter/LoginWithTypePresenter;
          //   599: invokestatic a : (Lcom/soft/blued/ui/login_register/presenter/LoginWithTypePresenter;)Lcom/soft/blued/ui/login_register/Contract/LoginWithTypeContract$IView;
          //   602: aload_0
          //   603: getfield e : Lcom/soft/blued/ui/login_register/presenter/LoginWithTypePresenter;
          //   606: invokevirtual b : ()Ljava/lang/String;
          //   609: iconst_1
          //   610: invokeinterface a : (Ljava/lang/String;Z)V
          //   615: iconst_1
          //   616: ireturn
          //   617: aload_0
          //   618: getfield e : Lcom/soft/blued/ui/login_register/presenter/LoginWithTypePresenter;
          //   621: invokevirtual c : ()Ljava/lang/String;
          //   624: invokestatic e : (Ljava/lang/String;)Z
          //   627: ifne -> 650
          //   630: aload_0
          //   631: getfield e : Lcom/soft/blued/ui/login_register/presenter/LoginWithTypePresenter;
          //   634: invokestatic a : (Lcom/soft/blued/ui/login_register/presenter/LoginWithTypePresenter;)Lcom/soft/blued/ui/login_register/Contract/LoginWithTypeContract$IView;
          //   637: aload_0
          //   638: getfield e : Lcom/soft/blued/ui/login_register/presenter/LoginWithTypePresenter;
          //   641: invokevirtual c : ()Ljava/lang/String;
          //   644: iconst_1
          //   645: invokeinterface a : (Ljava/lang/String;Z)V
          //   650: iconst_1
          //   651: istore_1
          //   652: iload_1
          //   653: ifeq -> 660
          //   656: aload_2
          //   657: invokestatic a : (Ljava/lang/CharSequence;)V
          //   660: iconst_1
          //   661: ireturn
          //   662: astore_3
          //   663: goto -> 200
          // Exception table:
          //   from	to	target	type
          //   99	121	662	java/lang/Exception
          //   131	138	662	java/lang/Exception
          //   141	194	662	java/lang/Exception
          //   206	246	287	java/lang/Exception
          //   248	285	287	java/lang/Exception
        }
        
        public void onUIFinish() {
          LoginWithTypePresenter.a(this.e).a();
        }
        
        public void onUIStart() {
          LoginWithTypePresenter.a(this.e).b();
        }
        
        public void onUIUpdate(BluedEntity<BluedLoginResult, AVConfigExtra> param1BluedEntity) {
          BluedLoginResult bluedLoginResult;
          try {
            if (this.a == LoginRegisterHttpUtils.PHONE_CODE_LOGIN_STAGE.a) {
              LoginWithTypePresenter.a(this.e).d();
              return;
            } 
            if (param1BluedEntity != null && param1BluedEntity.hasData()) {
              List list = param1BluedEntity.data;
              boolean bool1 = false;
              if (list.get(0) != null) {
                if (param1BluedEntity.extra != null)
                  AVConfig.a().a(((AVConfigExtra)param1BluedEntity.extra).is_kids, false); 
                bluedLoginResult = param1BluedEntity.data.get(0);
                if ("mobile".equals(this.b)) {
                  if (LoginWithTypePresenter.a(this.e).e() == 1) {
                    EventTrackLoginAndRegister.a(LoginAndRegisterProtos.Event.LOGIN_SUCCESS, LoginAndRegisterProtos.Source.PHONE_CODE);
                  } else {
                    EventTrackLoginAndRegister.a(LoginAndRegisterProtos.Event.LOGIN_SUCCESS, LoginAndRegisterProtos.Source.PHONE);
                  } 
                } else {
                  EventTrackLoginAndRegister.a(LoginAndRegisterProtos.Event.LOGIN_SUCCESS, LoginAndRegisterProtos.Source.EMAIL);
                  boolean bool2 = false;
                  Logger.b(LoginWithTypePresenter.b(this.e), new Object[] { "===success", "加密：responseJson:", param1BluedEntity });
                  UserInfo.a().a(this.c, bool2, LoginWithTypePresenter.c(this.e), bluedLoginResult, new String[] { LoginWithTypePresenter.d(this.e) });
                } 
              } else {
                return;
              } 
            } else {
              return;
            } 
          } catch (Exception exception) {
            exception.printStackTrace();
            AppMethods.a(LoginWithTypePresenter.e(this.e).getResources().getString(2131756082));
            return;
          } 
          boolean bool = true;
          Logger.b(LoginWithTypePresenter.b(this.e), new Object[] { "===success", "加密：responseJson:", exception });
          UserInfo.a().a(this.c, bool, LoginWithTypePresenter.c(this.e), bluedLoginResult, new String[] { LoginWithTypePresenter.d(this.e) });
        }
        
        public BluedEntity<BluedLoginResult, AVConfigExtra> parseData(String param1String) {
          LoginWithTypePresenter.a(this.e, param1String);
          BluedEntity<BluedLoginResult, AVConfigExtra> bluedEntity = super.parseData(param1String);
          if (bluedEntity != null)
            try {
              if (bluedEntity.data != null && bluedEntity.data.size() > 0) {
                String str = AesCrypto.c(((BluedLoginResult)bluedEntity.data.get(0)).get_());
                Logger.b(LoginWithTypePresenter.b(this.e), new Object[] { "解密：deData===", str });
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
  
  public void a(LoginRegisterHttpUtils.PHONE_CODE_LOGIN_STAGE paramPHONE_CODE_LOGIN_STAGE, String paramString1, String paramString2, String paramString3) {
    LoginRegisterHttpUtils.a(this.c, paramPHONE_CODE_LOGIN_STAGE, paramString1, paramString2, paramString3, this.j, a("mobile", paramString1, false, paramPHONE_CODE_LOGIN_STAGE));
  }
  
  public void a(String paramString) {
    this.i = paramString;
  }
  
  public void a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5) {
    if (!TextUtils.isEmpty(this.i) && UserInfo.a().j()) {
      b(paramString1, paramString2, paramString3, paramString4, paramString5);
      return;
    } 
    try {
      this.h = BluedHttpTools.b(paramString3);
    } catch (NoSuchAlgorithmException noSuchAlgorithmException) {
      noSuchAlgorithmException.printStackTrace();
    } 
    LoginRegisterHttpUtils.a(a(paramString1, paramString2, true, LoginRegisterHttpUtils.PHONE_CODE_LOGIN_STAGE.b), paramString1, paramString2, this.h, this.c, paramString4, paramString5, this.j, false);
  }
  
  public String b() {
    return this.f;
  }
  
  public void b(String paramString) {
    this.j = paramString;
  }
  
  public void b(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5) {
    UserRelationshipUtils.a(new Runnable(this, paramString1, paramString2, paramString3, paramString4, paramString5) {
          public void run() {
            LiveEventBus.get("hide_login_back").post(null);
            UserAccountsVDao.a().h();
            this.f.a(this.a, this.b, this.c, this.d, this.e);
          }
        }"bind_Acc");
  }
  
  public void bb_() {}
  
  public String c() {
    return this.k;
  }
  
  public void c(String paramString) {
    this.g = paramString;
  }
  
  public String d() {
    return this.g;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\login_register\presenter\LoginWithTypePresenter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */