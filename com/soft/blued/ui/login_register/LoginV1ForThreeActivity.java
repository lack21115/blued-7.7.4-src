package com.soft.blued.ui.login_register;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.blued.android.core.AppInfo;
import com.blued.android.core.AppMethods;
import com.blued.android.core.ui.BaseFragmentActivity;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.utils.AesCrypto;
import com.blued.android.module.common.utils.DialogUtils;
import com.blued.android.module.common.utils.ToastUtils;
import com.blued.android.share.Util;
import com.google.gson.reflect.TypeToken;
import com.jeremyliao.liveeventbus.LiveEventBus;
import com.soft.blued.db.UserAccountsVDao;
import com.soft.blued.http.LoginRegisterHttpUtils;
import com.soft.blued.ui.login_register.model.AVConfigExtra;
import com.soft.blued.ui.login_register.model.BluedCheckResult;
import com.soft.blued.ui.login_register.model.BluedLoginResult;
import com.soft.blued.user.UserInfo;
import com.soft.blued.utils.Logger;
import com.soft.blued.utils.StringUtils;
import com.soft.blued.utils.UserRelationshipUtils;
import com.soft.blued.wxapi.WXLoginBean;
import com.soft.blued.wxapi.WXProvider;

public class LoginV1ForThreeActivity extends BaseFragmentActivity {
  private String c = LoginV1ForThreeActivity.class.getSimpleName();
  
  private String d;
  
  private String e;
  
  private String f;
  
  private String g;
  
  private String h;
  
  private Dialog i;
  
  private String j;
  
  private int k = 0;
  
  private String l;
  
  private Handler m = new Handler(new Handler.Callback(this) {
        public boolean handleMessage(Message param1Message) {
          int i = param1Message.what;
          if (i != 4) {
            if (i != 5) {
              if (i != 6) {
                DialogUtils.b(LoginV1ForThreeActivity.e(this.a));
                this.a.finish();
                return false;
              } 
              Logger.b(LoginV1ForThreeActivity.a(this.a), new Object[] { "==FB_CALLBACK_CANCEL====" });
              ToastUtils.a(this.a.getResources().getString(2131755511));
              DialogUtils.b(LoginV1ForThreeActivity.e(this.a));
              this.a.finish();
              return false;
            } 
            Logger.b(LoginV1ForThreeActivity.a(this.a), new Object[] { "==FB_CALLBACK_ERROR====" });
            ToastUtils.a(this.a.getResources().getString(2131755512));
            DialogUtils.b(LoginV1ForThreeActivity.e(this.a));
            this.a.finish();
            return false;
          } 
          Logger.b(LoginV1ForThreeActivity.a(this.a), new Object[] { "==WX_CALLBACK_OK====" });
          WXLoginBean wXLoginBean = (WXLoginBean)param1Message.obj;
          if (wXLoginBean != null) {
            LoginV1ForThreeActivity.a(this.a, wXLoginBean.code);
            Logger.c("ljx_wx_code", new Object[] { LoginV1ForThreeActivity.b(this.a) });
            if (!StringUtils.e(LoginV1ForThreeActivity.c(this.a)) && UserInfo.a().j()) {
              LoginV1ForThreeActivity.d(this.a);
              return false;
            } 
            LoginV1ForThreeActivity loginV1ForThreeActivity = this.a;
            LoginV1ForThreeActivity.b(loginV1ForThreeActivity, LoginV1ForThreeActivity.b(loginV1ForThreeActivity));
            return false;
          } 
          DialogUtils.b(LoginV1ForThreeActivity.e(this.a));
          this.a.finish();
          return false;
        }
      });
  
  private BluedUIHttpResponse n = new BluedUIHttpResponse<BluedEntity<BluedLoginResult, AVConfigExtra>>(this) {
      public boolean onUIFailure(int param1Int, String param1String1, String param1String2) {
        // Byte code:
        //   0: iload_1
        //   1: lookupswitch default -> 44, 4035009 -> 424, 4036005 -> 327, 4036300 -> 68, 4036501 -> 327
        //   44: aload_0
        //   45: getfield a : Lcom/soft/blued/ui/login_register/LoginV1ForThreeActivity;
        //   48: invokestatic e : (Lcom/soft/blued/ui/login_register/LoginV1ForThreeActivity;)Landroid/app/Dialog;
        //   51: invokestatic b : (Landroid/app/Dialog;)V
        //   54: aload_0
        //   55: getfield a : Lcom/soft/blued/ui/login_register/LoginV1ForThreeActivity;
        //   58: invokevirtual finish : ()V
        //   61: aload_0
        //   62: iload_1
        //   63: aload_2
        //   64: invokespecial onUIFailure : (ILjava/lang/String;)Z
        //   67: ireturn
        //   68: invokestatic f : ()Lcom/google/gson/Gson;
        //   71: astore_2
        //   72: aload_2
        //   73: aload_3
        //   74: new com/soft/blued/ui/login_register/LoginV1ForThreeActivity$3$1
        //   77: dup
        //   78: aload_0
        //   79: invokespecial <init> : (Lcom/soft/blued/ui/login_register/LoginV1ForThreeActivity$3;)V
        //   82: invokevirtual getType : ()Ljava/lang/reflect/Type;
        //   85: invokevirtual fromJson : (Ljava/lang/String;Ljava/lang/reflect/Type;)Ljava/lang/Object;
        //   88: checkcast com/blued/android/framework/http/parser/BluedEntityA
        //   91: astore_3
        //   92: aload_3
        //   93: ifnull -> 325
        //   96: aload_3
        //   97: getfield data : Ljava/util/List;
        //   100: ifnull -> 325
        //   103: aload_3
        //   104: getfield data : Ljava/util/List;
        //   107: invokeinterface size : ()I
        //   112: ifle -> 325
        //   115: aload_3
        //   116: getfield data : Ljava/util/List;
        //   119: iconst_0
        //   120: invokeinterface get : (I)Ljava/lang/Object;
        //   125: checkcast com/soft/blued/ui/login_register/model/BluedCheckResult
        //   128: invokevirtual get_ : ()Ljava/lang/String;
        //   131: invokestatic c : (Ljava/lang/String;)Ljava/lang/String;
        //   134: astore_3
        //   135: aload_0
        //   136: getfield a : Lcom/soft/blued/ui/login_register/LoginV1ForThreeActivity;
        //   139: invokestatic a : (Lcom/soft/blued/ui/login_register/LoginV1ForThreeActivity;)Ljava/lang/String;
        //   142: iconst_2
        //   143: anewarray java/lang/Object
        //   146: dup
        //   147: iconst_0
        //   148: ldc '解密：deData==='
        //   150: aastore
        //   151: dup
        //   152: iconst_1
        //   153: aload_3
        //   154: aastore
        //   155: invokestatic b : (Ljava/lang/String;[Ljava/lang/Object;)V
        //   158: aload_2
        //   159: aload_3
        //   160: ldc com/soft/blued/ui/login_register/model/BluedCheckResult
        //   162: invokevirtual fromJson : (Ljava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;
        //   165: checkcast com/soft/blued/ui/login_register/model/BluedCheckResult
        //   168: astore_2
        //   169: ldc 'plat_weixin'
        //   171: aload_0
        //   172: getfield a : Lcom/soft/blued/ui/login_register/LoginV1ForThreeActivity;
        //   175: invokestatic f : (Lcom/soft/blued/ui/login_register/LoginV1ForThreeActivity;)Ljava/lang/String;
        //   178: invokevirtual endsWith : (Ljava/lang/String;)Z
        //   181: ifeq -> 208
        //   184: aload_0
        //   185: getfield a : Lcom/soft/blued/ui/login_register/LoginV1ForThreeActivity;
        //   188: aload_2
        //   189: invokevirtual getThirdToken : ()Ljava/lang/String;
        //   192: invokestatic d : (Lcom/soft/blued/ui/login_register/LoginV1ForThreeActivity;Ljava/lang/String;)Ljava/lang/String;
        //   195: pop
        //   196: aload_0
        //   197: getfield a : Lcom/soft/blued/ui/login_register/LoginV1ForThreeActivity;
        //   200: aload_2
        //   201: invokevirtual getThirdUid : ()Ljava/lang/String;
        //   204: invokestatic e : (Lcom/soft/blued/ui/login_register/LoginV1ForThreeActivity;Ljava/lang/String;)Ljava/lang/String;
        //   207: pop
        //   208: aload_2
        //   209: ifnull -> 325
        //   212: aload_0
        //   213: getfield a : Lcom/soft/blued/ui/login_register/LoginV1ForThreeActivity;
        //   216: invokestatic c : (Lcom/soft/blued/ui/login_register/LoginV1ForThreeActivity;)Ljava/lang/String;
        //   219: invokestatic e : (Ljava/lang/String;)Z
        //   222: ifne -> 290
        //   225: aload_0
        //   226: getfield a : Lcom/soft/blued/ui/login_register/LoginV1ForThreeActivity;
        //   229: aconst_null
        //   230: aload_0
        //   231: getfield a : Lcom/soft/blued/ui/login_register/LoginV1ForThreeActivity;
        //   234: invokevirtual getResources : ()Landroid/content/res/Resources;
        //   237: ldc 2131755635
        //   239: invokevirtual getString : (I)Ljava/lang/String;
        //   242: aload_0
        //   243: getfield a : Lcom/soft/blued/ui/login_register/LoginV1ForThreeActivity;
        //   246: invokevirtual getResources : ()Landroid/content/res/Resources;
        //   249: ldc 2131756128
        //   251: invokevirtual getString : (I)Ljava/lang/String;
        //   254: new com/soft/blued/ui/login_register/LoginV1ForThreeActivity$3$2
        //   257: dup
        //   258: aload_0
        //   259: aload_2
        //   260: invokespecial <init> : (Lcom/soft/blued/ui/login_register/LoginV1ForThreeActivity$3;Lcom/soft/blued/ui/login_register/model/BluedCheckResult;)V
        //   263: aload_0
        //   264: getfield a : Lcom/soft/blued/ui/login_register/LoginV1ForThreeActivity;
        //   267: invokevirtual getResources : ()Landroid/content/res/Resources;
        //   270: ldc 2131755726
        //   272: invokevirtual getString : (I)Ljava/lang/String;
        //   275: new com/soft/blued/ui/login_register/LoginV1ForThreeActivity$3$3
        //   278: dup
        //   279: aload_0
        //   280: invokespecial <init> : (Lcom/soft/blued/ui/login_register/LoginV1ForThreeActivity$3;)V
        //   283: aconst_null
        //   284: invokestatic a : (Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroid/content/DialogInterface$OnClickListener;Ljava/lang/String;Landroid/content/DialogInterface$OnClickListener;Landroid/content/DialogInterface$OnDismissListener;)Lcom/soft/blued/view/tip/dialog/BluedAlertDialog;
        //   287: pop
        //   288: iconst_1
        //   289: ireturn
        //   290: aload_0
        //   291: getfield a : Lcom/soft/blued/ui/login_register/LoginV1ForThreeActivity;
        //   294: aload_2
        //   295: invokevirtual getToken : ()Ljava/lang/String;
        //   298: invokestatic f : (Lcom/soft/blued/ui/login_register/LoginV1ForThreeActivity;Ljava/lang/String;)V
        //   301: aload_0
        //   302: getfield a : Lcom/soft/blued/ui/login_register/LoginV1ForThreeActivity;
        //   305: invokestatic e : (Lcom/soft/blued/ui/login_register/LoginV1ForThreeActivity;)Landroid/app/Dialog;
        //   308: invokestatic b : (Landroid/app/Dialog;)V
        //   311: aload_0
        //   312: getfield a : Lcom/soft/blued/ui/login_register/LoginV1ForThreeActivity;
        //   315: invokevirtual finish : ()V
        //   318: iconst_1
        //   319: ireturn
        //   320: astore_2
        //   321: aload_2
        //   322: invokevirtual printStackTrace : ()V
        //   325: iconst_1
        //   326: ireturn
        //   327: invokestatic f : ()Lcom/google/gson/Gson;
        //   330: aload_3
        //   331: new com/soft/blued/ui/login_register/LoginV1ForThreeActivity$3$4
        //   334: dup
        //   335: aload_0
        //   336: invokespecial <init> : (Lcom/soft/blued/ui/login_register/LoginV1ForThreeActivity$3;)V
        //   339: invokevirtual getType : ()Ljava/lang/reflect/Type;
        //   342: invokevirtual fromJson : (Ljava/lang/String;Ljava/lang/reflect/Type;)Ljava/lang/Object;
        //   345: checkcast com/blued/android/framework/http/parser/BluedEntityA
        //   348: astore_2
        //   349: aload_2
        //   350: ifnull -> 405
        //   353: aload_2
        //   354: getfield data : Ljava/util/List;
        //   357: ifnull -> 405
        //   360: aload_2
        //   361: getfield data : Ljava/util/List;
        //   364: invokeinterface size : ()I
        //   369: ifle -> 405
        //   372: aload_2
        //   373: getfield data : Ljava/util/List;
        //   376: iconst_0
        //   377: invokeinterface get : (I)Ljava/lang/Object;
        //   382: checkcast com/soft/blued/ui/login_register/model/BluedLoginResult
        //   385: astore_3
        //   386: aload_3
        //   387: getfield reason : Ljava/lang/String;
        //   390: astore_2
        //   391: aload_3
        //   392: getfield uid : Ljava/lang/String;
        //   395: astore_3
        //   396: aload_0
        //   397: getfield a : Lcom/soft/blued/ui/login_register/LoginV1ForThreeActivity;
        //   400: aload_2
        //   401: aload_3
        //   402: invokestatic a : (Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V
        //   405: aload_0
        //   406: getfield a : Lcom/soft/blued/ui/login_register/LoginV1ForThreeActivity;
        //   409: invokestatic e : (Lcom/soft/blued/ui/login_register/LoginV1ForThreeActivity;)Landroid/app/Dialog;
        //   412: invokestatic b : (Landroid/app/Dialog;)V
        //   415: aload_0
        //   416: getfield a : Lcom/soft/blued/ui/login_register/LoginV1ForThreeActivity;
        //   419: invokevirtual finish : ()V
        //   422: iconst_1
        //   423: ireturn
        //   424: aload_0
        //   425: getfield a : Lcom/soft/blued/ui/login_register/LoginV1ForThreeActivity;
        //   428: invokestatic j : (Lcom/soft/blued/ui/login_register/LoginV1ForThreeActivity;)Ljava/lang/String;
        //   431: aload_0
        //   432: getfield a : Lcom/soft/blued/ui/login_register/LoginV1ForThreeActivity;
        //   435: invokestatic k : (Lcom/soft/blued/ui/login_register/LoginV1ForThreeActivity;)Ljava/lang/String;
        //   438: ldc 'weixin'
        //   440: invokestatic a : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
        //   443: astore_2
        //   444: new android/os/Bundle
        //   447: dup
        //   448: invokespecial <init> : ()V
        //   451: astore #4
        //   453: aload_3
        //   454: invokestatic d : (Ljava/lang/String;)Lcom/soft/blued/ui/login_register/model/BluedCheckResult;
        //   457: invokevirtual getToken : ()Ljava/lang/String;
        //   460: astore #5
        //   462: aload_3
        //   463: invokestatic d : (Ljava/lang/String;)Lcom/soft/blued/ui/login_register/model/BluedCheckResult;
        //   466: invokevirtual getLogin_mobile : ()Ljava/lang/String;
        //   469: astore #6
        //   471: aload_3
        //   472: invokestatic d : (Ljava/lang/String;)Lcom/soft/blued/ui/login_register/model/BluedCheckResult;
        //   475: invokevirtual getRelation_mobile : ()Ljava/lang/String;
        //   478: astore #7
        //   480: aload_3
        //   481: invokestatic d : (Ljava/lang/String;)Lcom/soft/blued/ui/login_register/model/BluedCheckResult;
        //   484: invokevirtual getLogin_email : ()Ljava/lang/String;
        //   487: astore #8
        //   489: aload_3
        //   490: invokestatic d : (Ljava/lang/String;)Lcom/soft/blued/ui/login_register/model/BluedCheckResult;
        //   493: invokevirtual getSafe_email : ()Ljava/lang/String;
        //   496: astore #9
        //   498: aload #4
        //   500: ldc 'token'
        //   502: aload #5
        //   504: invokevirtual putString : (Ljava/lang/String;Ljava/lang/String;)V
        //   507: aload #4
        //   509: ldc 'login_mobile'
        //   511: aload #6
        //   513: invokevirtual putString : (Ljava/lang/String;Ljava/lang/String;)V
        //   516: aload #4
        //   518: ldc 'relation_mobile'
        //   520: aload #7
        //   522: invokevirtual putString : (Ljava/lang/String;Ljava/lang/String;)V
        //   525: aload #4
        //   527: ldc 'login_email'
        //   529: aload #8
        //   531: invokevirtual putString : (Ljava/lang/String;Ljava/lang/String;)V
        //   534: aload #4
        //   536: ldc 'safe_email'
        //   538: aload #9
        //   540: invokevirtual putString : (Ljava/lang/String;Ljava/lang/String;)V
        //   543: aload #4
        //   545: ldc 'password'
        //   547: ldc ''
        //   549: invokevirtual putString : (Ljava/lang/String;Ljava/lang/String;)V
        //   552: aload #4
        //   554: ldc 'login_type'
        //   556: ldc 'third'
        //   558: invokevirtual putString : (Ljava/lang/String;Ljava/lang/String;)V
        //   561: aload #4
        //   563: ldc 'login_account'
        //   565: aload_2
        //   566: invokevirtual putString : (Ljava/lang/String;Ljava/lang/String;)V
        //   569: aload #4
        //   571: ldc 'key_uid'
        //   573: aload_3
        //   574: invokestatic d : (Ljava/lang/String;)Lcom/soft/blued/ui/login_register/model/BluedCheckResult;
        //   577: invokevirtual getUid : ()Ljava/lang/String;
        //   580: invokevirtual putString : (Ljava/lang/String;Ljava/lang/String;)V
        //   583: aload #4
        //   585: ldc 'target_type'
        //   587: iconst_0
        //   588: invokevirtual putInt : (Ljava/lang/String;I)V
        //   591: aload_0
        //   592: getfield a : Lcom/soft/blued/ui/login_register/LoginV1ForThreeActivity;
        //   595: invokestatic c : (Lcom/soft/blued/ui/login_register/LoginV1ForThreeActivity;)Ljava/lang/String;
        //   598: invokestatic e : (Ljava/lang/String;)Z
        //   601: ifne -> 618
        //   604: aload #4
        //   606: ldc 'aliasUserId'
        //   608: aload_0
        //   609: getfield a : Lcom/soft/blued/ui/login_register/LoginV1ForThreeActivity;
        //   612: invokestatic c : (Lcom/soft/blued/ui/login_register/LoginV1ForThreeActivity;)Ljava/lang/String;
        //   615: invokevirtual putString : (Ljava/lang/String;Ljava/lang/String;)V
        //   618: aload_0
        //   619: getfield a : Lcom/soft/blued/ui/login_register/LoginV1ForThreeActivity;
        //   622: aload #4
        //   624: invokestatic a : (Landroid/content/Context;Landroid/os/Bundle;)V
        //   627: aload_0
        //   628: getfield a : Lcom/soft/blued/ui/login_register/LoginV1ForThreeActivity;
        //   631: invokestatic e : (Lcom/soft/blued/ui/login_register/LoginV1ForThreeActivity;)Landroid/app/Dialog;
        //   634: invokestatic b : (Landroid/app/Dialog;)V
        //   637: aload_0
        //   638: getfield a : Lcom/soft/blued/ui/login_register/LoginV1ForThreeActivity;
        //   641: invokevirtual finish : ()V
        //   644: iconst_1
        //   645: ireturn
        //   646: astore_2
        //   647: goto -> 405
        // Exception table:
        //   from	to	target	type
        //   68	92	320	java/lang/Exception
        //   96	208	320	java/lang/Exception
        //   212	288	320	java/lang/Exception
        //   290	318	320	java/lang/Exception
        //   327	349	646	java/lang/Exception
        //   353	405	646	java/lang/Exception
      }
      
      public void onUIFinish() {}
      
      public void onUIStart() {
        DialogUtils.a(LoginV1ForThreeActivity.e(this.a));
      }
      
      public void onUIUpdate(BluedEntity<BluedLoginResult, AVConfigExtra> param1BluedEntity) {
        // Byte code:
        //   0: new java/lang/StringBuilder
        //   3: dup
        //   4: invokespecial <init> : ()V
        //   7: astore_3
        //   8: aload_3
        //   9: aload_0
        //   10: getfield a : Lcom/soft/blued/ui/login_register/LoginV1ForThreeActivity;
        //   13: invokestatic a : (Lcom/soft/blued/ui/login_register/LoginV1ForThreeActivity;)Ljava/lang/String;
        //   16: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   19: pop
        //   20: aload_3
        //   21: ldc_w '===success'
        //   24: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   27: pop
        //   28: aload_3
        //   29: invokevirtual toString : ()Ljava/lang/String;
        //   32: astore_3
        //   33: iconst_0
        //   34: istore_2
        //   35: aload_3
        //   36: iconst_2
        //   37: anewarray java/lang/Object
        //   40: dup
        //   41: iconst_0
        //   42: ldc_w '===responseJson:'
        //   45: aastore
        //   46: dup
        //   47: iconst_1
        //   48: aload_1
        //   49: aastore
        //   50: invokestatic b : (Ljava/lang/String;[Ljava/lang/Object;)V
        //   53: aload_1
        //   54: getfield data : Ljava/util/List;
        //   57: invokeinterface size : ()I
        //   62: ifle -> 463
        //   65: aload_1
        //   66: getfield data : Ljava/util/List;
        //   69: iconst_0
        //   70: invokeinterface get : (I)Ljava/lang/Object;
        //   75: ifnull -> 463
        //   78: aload_1
        //   79: getfield extra : Lcom/blued/android/framework/http/parser/BluedEntityBaseExtra;
        //   82: ifnull -> 102
        //   85: invokestatic a : ()Lcom/soft/blued/user/AVConfig;
        //   88: aload_1
        //   89: getfield extra : Lcom/blued/android/framework/http/parser/BluedEntityBaseExtra;
        //   92: checkcast com/soft/blued/ui/login_register/model/AVConfigExtra
        //   95: getfield is_kids : Lcom/soft/blued/ui/login_register/model/AVConfigModel;
        //   98: iconst_0
        //   99: invokevirtual a : (Lcom/soft/blued/ui/login_register/model/AVConfigModel;Z)V
        //   102: aload_1
        //   103: getfield data : Ljava/util/List;
        //   106: iconst_0
        //   107: invokeinterface get : (I)Ljava/lang/Object;
        //   112: checkcast com/soft/blued/ui/login_register/model/BluedLoginResult
        //   115: astore_3
        //   116: ldc ''
        //   118: astore_1
        //   119: ldc 'plat_weixin'
        //   121: aload_0
        //   122: getfield a : Lcom/soft/blued/ui/login_register/LoginV1ForThreeActivity;
        //   125: invokestatic f : (Lcom/soft/blued/ui/login_register/LoginV1ForThreeActivity;)Ljava/lang/String;
        //   128: invokevirtual endsWith : (Ljava/lang/String;)Z
        //   131: ifeq -> 269
        //   134: aload_3
        //   135: invokevirtual getUid : ()Ljava/lang/String;
        //   138: invokestatic h : (Ljava/lang/String;)Z
        //   141: ifeq -> 249
        //   144: aload_0
        //   145: getfield a : Lcom/soft/blued/ui/login_register/LoginV1ForThreeActivity;
        //   148: aload_3
        //   149: invokevirtual getThird_access_token : ()Ljava/lang/String;
        //   152: invokestatic d : (Lcom/soft/blued/ui/login_register/LoginV1ForThreeActivity;Ljava/lang/String;)Ljava/lang/String;
        //   155: pop
        //   156: aload_0
        //   157: getfield a : Lcom/soft/blued/ui/login_register/LoginV1ForThreeActivity;
        //   160: aload_3
        //   161: invokevirtual getThird_user_id : ()Ljava/lang/String;
        //   164: invokestatic e : (Lcom/soft/blued/ui/login_register/LoginV1ForThreeActivity;Ljava/lang/String;)Ljava/lang/String;
        //   167: pop
        //   168: aload_0
        //   169: getfield a : Lcom/soft/blued/ui/login_register/LoginV1ForThreeActivity;
        //   172: invokestatic g : (Lcom/soft/blued/ui/login_register/LoginV1ForThreeActivity;)I
        //   175: pop
        //   176: aload_0
        //   177: getfield a : Lcom/soft/blued/ui/login_register/LoginV1ForThreeActivity;
        //   180: invokestatic a : (Lcom/soft/blued/ui/login_register/LoginV1ForThreeActivity;)Ljava/lang/String;
        //   183: iconst_2
        //   184: anewarray java/lang/Object
        //   187: dup
        //   188: iconst_0
        //   189: ldc_w '===request time:'
        //   192: aastore
        //   193: dup
        //   194: iconst_1
        //   195: aload_0
        //   196: getfield a : Lcom/soft/blued/ui/login_register/LoginV1ForThreeActivity;
        //   199: invokestatic h : (Lcom/soft/blued/ui/login_register/LoginV1ForThreeActivity;)I
        //   202: invokestatic valueOf : (I)Ljava/lang/Integer;
        //   205: aastore
        //   206: invokestatic b : (Ljava/lang/String;[Ljava/lang/Object;)V
        //   209: aload_0
        //   210: getfield a : Lcom/soft/blued/ui/login_register/LoginV1ForThreeActivity;
        //   213: invokestatic h : (Lcom/soft/blued/ui/login_register/LoginV1ForThreeActivity;)I
        //   216: iconst_2
        //   217: if_icmpgt -> 525
        //   220: aload_0
        //   221: getfield a : Lcom/soft/blued/ui/login_register/LoginV1ForThreeActivity;
        //   224: invokestatic i : (Lcom/soft/blued/ui/login_register/LoginV1ForThreeActivity;)Lcom/blued/android/framework/http/BluedUIHttpResponse;
        //   227: aload_0
        //   228: getfield a : Lcom/soft/blued/ui/login_register/LoginV1ForThreeActivity;
        //   231: invokestatic j : (Lcom/soft/blued/ui/login_register/LoginV1ForThreeActivity;)Ljava/lang/String;
        //   234: aload_0
        //   235: getfield a : Lcom/soft/blued/ui/login_register/LoginV1ForThreeActivity;
        //   238: invokestatic k : (Lcom/soft/blued/ui/login_register/LoginV1ForThreeActivity;)Ljava/lang/String;
        //   241: aconst_null
        //   242: ldc 'weixin'
        //   244: iconst_0
        //   245: invokestatic a : (Lcom/blued/android/framework/http/BluedUIHttpResponse;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V
        //   248: return
        //   249: aload_0
        //   250: getfield a : Lcom/soft/blued/ui/login_register/LoginV1ForThreeActivity;
        //   253: invokestatic j : (Lcom/soft/blued/ui/login_register/LoginV1ForThreeActivity;)Ljava/lang/String;
        //   256: aload_0
        //   257: getfield a : Lcom/soft/blued/ui/login_register/LoginV1ForThreeActivity;
        //   260: invokestatic k : (Lcom/soft/blued/ui/login_register/LoginV1ForThreeActivity;)Ljava/lang/String;
        //   263: ldc 'weixin'
        //   265: invokestatic a : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
        //   268: astore_1
        //   269: aload_0
        //   270: getfield a : Lcom/soft/blued/ui/login_register/LoginV1ForThreeActivity;
        //   273: invokestatic a : (Lcom/soft/blued/ui/login_register/LoginV1ForThreeActivity;)Ljava/lang/String;
        //   276: iconst_2
        //   277: anewarray java/lang/Object
        //   280: dup
        //   281: iconst_0
        //   282: ldc_w 'accountJson==='
        //   285: aastore
        //   286: dup
        //   287: iconst_1
        //   288: aload_1
        //   289: aastore
        //   290: invokestatic b : (Ljava/lang/String;[Ljava/lang/Object;)V
        //   293: invokestatic a : ()Lcom/soft/blued/user/UserInfo;
        //   296: aload_1
        //   297: iconst_2
        //   298: aload_0
        //   299: getfield a : Lcom/soft/blued/ui/login_register/LoginV1ForThreeActivity;
        //   302: invokestatic l : (Lcom/soft/blued/ui/login_register/LoginV1ForThreeActivity;)Ljava/lang/String;
        //   305: aload_3
        //   306: iconst_1
        //   307: anewarray java/lang/String
        //   310: dup
        //   311: iconst_0
        //   312: aload_0
        //   313: getfield a : Lcom/soft/blued/ui/login_register/LoginV1ForThreeActivity;
        //   316: invokestatic c : (Lcom/soft/blued/ui/login_register/LoginV1ForThreeActivity;)Ljava/lang/String;
        //   319: aastore
        //   320: invokevirtual a : (Ljava/lang/String;ILjava/lang/String;Lcom/soft/blued/ui/login_register/model/BluedLoginResult;[Ljava/lang/String;)V
        //   323: aload_0
        //   324: getfield a : Lcom/soft/blued/ui/login_register/LoginV1ForThreeActivity;
        //   327: invokestatic c : (Lcom/soft/blued/ui/login_register/LoginV1ForThreeActivity;)Ljava/lang/String;
        //   330: invokestatic e : (Ljava/lang/String;)Z
        //   333: ifne -> 349
        //   336: invokestatic a : ()Lcom/soft/blued/db/UserAccountsVDao;
        //   339: aload_0
        //   340: getfield a : Lcom/soft/blued/ui/login_register/LoginV1ForThreeActivity;
        //   343: invokestatic c : (Lcom/soft/blued/ui/login_register/LoginV1ForThreeActivity;)Ljava/lang/String;
        //   346: invokevirtual c : (Ljava/lang/String;)V
        //   349: aload_0
        //   350: getfield a : Lcom/soft/blued/ui/login_register/LoginV1ForThreeActivity;
        //   353: invokestatic c : (Lcom/soft/blued/ui/login_register/LoginV1ForThreeActivity;)Ljava/lang/String;
        //   356: invokestatic e : (Ljava/lang/String;)Z
        //   359: ifne -> 368
        //   362: invokestatic a : ()Lcom/soft/blued/push/PushManager;
        //   365: invokevirtual d : ()V
        //   368: aload_3
        //   369: invokevirtual getDevice_safe : ()I
        //   372: iconst_1
        //   373: if_icmpne -> 378
        //   376: iconst_1
        //   377: istore_2
        //   378: iload_2
        //   379: invokestatic D : (Z)V
        //   382: getstatic com/blued/das/login/LoginAndRegisterProtos$Event.LOGIN_SUCCESS : Lcom/blued/das/login/LoginAndRegisterProtos$Event;
        //   385: getstatic com/blued/das/login/LoginAndRegisterProtos$Source.WECHAT : Lcom/blued/das/login/LoginAndRegisterProtos$Source;
        //   388: invokestatic a : (Lcom/blued/das/login/LoginAndRegisterProtos$Event;Lcom/blued/das/login/LoginAndRegisterProtos$Source;)V
        //   391: aload_3
        //   392: ifnull -> 413
        //   395: aload_3
        //   396: invokevirtual getNeedAdultVerify : ()I
        //   399: iconst_1
        //   400: if_icmpne -> 413
        //   403: aload_0
        //   404: getfield a : Lcom/soft/blued/ui/login_register/LoginV1ForThreeActivity;
        //   407: invokestatic a : (Landroid/content/Context;)V
        //   410: goto -> 463
        //   413: new android/os/Bundle
        //   416: dup
        //   417: invokespecial <init> : ()V
        //   420: astore_1
        //   421: aload_1
        //   422: ldc_w 'from_tag_page'
        //   425: ldc_w 'from_tag_login'
        //   428: invokevirtual putString : (Ljava/lang/String;Ljava/lang/String;)V
        //   431: aload_0
        //   432: getfield a : Lcom/soft/blued/ui/login_register/LoginV1ForThreeActivity;
        //   435: aconst_null
        //   436: aload_1
        //   437: invokestatic a : (Landroid/content/Context;Ljava/lang/String;Landroid/os/Bundle;)V
        //   440: goto -> 463
        //   443: astore_1
        //   444: aload_1
        //   445: invokevirtual printStackTrace : ()V
        //   448: invokestatic d : ()Landroid/content/Context;
        //   451: invokevirtual getResources : ()Landroid/content/res/Resources;
        //   454: ldc_w 2131756082
        //   457: invokevirtual getString : (I)Ljava/lang/String;
        //   460: invokestatic a : (Ljava/lang/CharSequence;)V
        //   463: ldc 'plat_weixin'
        //   465: aload_0
        //   466: getfield a : Lcom/soft/blued/ui/login_register/LoginV1ForThreeActivity;
        //   469: invokestatic f : (Lcom/soft/blued/ui/login_register/LoginV1ForThreeActivity;)Ljava/lang/String;
        //   472: invokevirtual endsWith : (Ljava/lang/String;)Z
        //   475: ifeq -> 507
        //   478: aload_0
        //   479: getfield a : Lcom/soft/blued/ui/login_register/LoginV1ForThreeActivity;
        //   482: invokestatic h : (Lcom/soft/blued/ui/login_register/LoginV1ForThreeActivity;)I
        //   485: iconst_2
        //   486: if_icmplt -> 524
        //   489: aload_0
        //   490: getfield a : Lcom/soft/blued/ui/login_register/LoginV1ForThreeActivity;
        //   493: invokestatic e : (Lcom/soft/blued/ui/login_register/LoginV1ForThreeActivity;)Landroid/app/Dialog;
        //   496: invokestatic b : (Landroid/app/Dialog;)V
        //   499: aload_0
        //   500: getfield a : Lcom/soft/blued/ui/login_register/LoginV1ForThreeActivity;
        //   503: invokevirtual finish : ()V
        //   506: return
        //   507: aload_0
        //   508: getfield a : Lcom/soft/blued/ui/login_register/LoginV1ForThreeActivity;
        //   511: invokestatic e : (Lcom/soft/blued/ui/login_register/LoginV1ForThreeActivity;)Landroid/app/Dialog;
        //   514: invokestatic b : (Landroid/app/Dialog;)V
        //   517: aload_0
        //   518: getfield a : Lcom/soft/blued/ui/login_register/LoginV1ForThreeActivity;
        //   521: invokevirtual finish : ()V
        //   524: return
        //   525: return
        // Exception table:
        //   from	to	target	type
        //   0	33	443	java/lang/Exception
        //   35	102	443	java/lang/Exception
        //   102	116	443	java/lang/Exception
        //   119	248	443	java/lang/Exception
        //   249	269	443	java/lang/Exception
        //   269	349	443	java/lang/Exception
        //   349	368	443	java/lang/Exception
        //   368	376	443	java/lang/Exception
        //   378	391	443	java/lang/Exception
        //   395	410	443	java/lang/Exception
        //   413	440	443	java/lang/Exception
      }
      
      public BluedEntity<BluedLoginResult, AVConfigExtra> parseData(String param1String) {
        LoginV1ForThreeActivity.c(this.a, param1String);
        BluedEntity<BluedLoginResult, AVConfigExtra> bluedEntity = super.parseData(param1String);
        if (bluedEntity != null)
          try {
            if (bluedEntity.data != null && bluedEntity.data.size() > 0) {
              String str = AesCrypto.c(((BluedLoginResult)bluedEntity.data.get(0)).get_());
              Logger.b(LoginV1ForThreeActivity.a(this.a), new Object[] { "解密：deData===", str });
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
  
  private void a(String paramString) {
    if (!StringUtils.e(paramString)) {
      this.k++;
      LoginRegisterHttpUtils.a(this.n, null, null, paramString, "weixin", false);
      return;
    } 
    ToastUtils.a(getResources().getString(2131755512));
    DialogUtils.b(this.i);
    finish();
  }
  
  private void b(String paramString) {
    RegisterV1FinishInfoFragment.a((Context)this, paramString, this.g, this.d, this.e, this.f);
  }
  
  private void h() {
    UserRelationshipUtils.a(new Runnable(this) {
          public void run() {
            LiveEventBus.get("hide_login_back").post(null);
            UserAccountsVDao.a().h();
            LoginV1ForThreeActivity loginV1ForThreeActivity = this.a;
            LoginV1ForThreeActivity.b(loginV1ForThreeActivity, LoginV1ForThreeActivity.b(loginV1ForThreeActivity));
          }
        }"bind_Acc");
  }
  
  private void i() {
    this.i = DialogUtils.a((Context)this);
  }
  
  private void j() {
    if (getIntent() != null) {
      this.d = getIntent().getStringExtra("from_three_plat");
      if ("plat_weixin".endsWith(this.d)) {
        k();
        Bundle bundle = getIntent().getBundleExtra("fragment_args");
        if (bundle != null)
          this.l = bundle.getString("aliasUserId"); 
        return;
      } 
      finish();
      return;
    } 
    finish();
  }
  
  private void k() {
    if (!Util.isClientAvailable((Context)this, "com.tencent.mm")) {
      AppMethods.d(2131759359);
      finish();
      return;
    } 
    DialogUtils.a(this.i);
    WXProvider.a().a(new WXProvider.ILoginCallback(this) {
          public void a() {
            LoginV1ForThreeActivity.m(this.a).sendEmptyMessage(5);
          }
          
          public void a(WXLoginBean param1WXLoginBean) {
            Message message = new Message();
            message.what = 4;
            message.obj = param1WXLoginBean;
            LoginV1ForThreeActivity.m(this.a).sendMessage(message);
          }
          
          public void b() {
            LoginV1ForThreeActivity.m(this.a).sendEmptyMessage(6);
          }
        });
    WXProvider.a().a((Context)this);
  }
  
  public void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    i();
    j();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\login_register\LoginV1ForThreeActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */