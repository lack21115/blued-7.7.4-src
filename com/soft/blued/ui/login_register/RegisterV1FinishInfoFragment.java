package com.soft.blued.ui.login_register;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.blued.android.core.AppInfo;
import com.blued.android.core.AppMethods;
import com.blued.android.core.BlueAppLocal;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.core.utils.skin.BluedSkinUtils;
import com.blued.android.framework.activity.keyboardpage.KeyBoardFragment;
import com.blued.android.framework.activity.keyboardpage.KeyboardListenLinearLayout;
import com.blued.android.framework.http.BluedHttpTools;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.permission.PermissionCallbacks;
import com.blued.android.framework.pool.ThreadExecutor;
import com.blued.android.framework.pool.ThreadManager;
import com.blued.android.framework.utils.AesCrypto;
import com.blued.android.framework.utils.KeyboardUtils;
import com.blued.android.framework.utils.upload.QiniuUploadTools;
import com.blued.android.framework.view.shape.ShapeFrameLayout;
import com.blued.android.framework.view.shape.ShapeHelper;
import com.blued.android.module.common.utils.DialogUtils;
import com.blued.android.module.live.base.view.FlowLayout;
import com.blued.das.login.LoginAndRegisterProtos;
import com.soft.blued.app.permission.PermissionHelper;
import com.soft.blued.customview.ClearEditText;
import com.soft.blued.customview.CommonTopTitleNoTrans;
import com.soft.blued.customview.MDatePickerDialog;
import com.soft.blued.customview.PopMenuFromCenter;
import com.soft.blued.http.LoginRegisterHttpUtils;
import com.soft.blued.log.trackUtils.EventTrackLoginAndRegister;
import com.soft.blued.model.BluedAlbum;
import com.soft.blued.ui.feed.fragment.PhotoSelectFragment;
import com.soft.blued.ui.login_register.model.AVConfigExtra;
import com.soft.blued.ui.login_register.model.BluedCheckResult;
import com.soft.blued.ui.login_register.model.BluedLoginResult;
import com.soft.blued.ui.login_register.model.PassportTipsModel;
import com.soft.blued.ui.setting.fragment.ModifyHealthFragment;
import com.soft.blued.ui.user.fragment.TagAmFragment;
import com.soft.blued.ui.user.model.UserTag;
import com.soft.blued.user.UserInfo;
import com.soft.blued.utils.BluedPreferences;
import com.soft.blued.utils.Logger;
import com.soft.blued.utils.StringUtils;
import com.soft.blued.utils.TimeAndDateUtils;
import com.soft.blued.utils.UserRelationshipUtils;
import com.soft.blued.utils.third.QiniuUploadUtils;
import java.io.Serializable;
import java.lang.ref.WeakReference;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import net.simonvt.datepicker.DatePicker;
import net.simonvt.datepicker.DatePickerDialog;
import net.simonvt.numberpicker.NumberPicker;

public class RegisterV1FinishInfoFragment extends KeyBoardFragment implements View.OnClickListener {
  private TextView A;
  
  private TextView B;
  
  private TextView C;
  
  private TextView D;
  
  private TextView E;
  
  private TextView F;
  
  private TextView G;
  
  private TextView H;
  
  private TextView I;
  
  private String J;
  
  private String K = "-1";
  
  private CommonTopTitleNoTrans L;
  
  private int M = 1994;
  
  private int N = 0;
  
  private int O = 1;
  
  private String P = "";
  
  private String Q = "";
  
  private int R = 0;
  
  private int S = 170;
  
  private int T = 60;
  
  private int U = 120;
  
  private int V = 220;
  
  private int W = 30;
  
  private int X = 200;
  
  private String Y = "";
  
  private String Z = "";
  
  private String[] aa;
  
  private String[] ab;
  
  private String ac;
  
  private int ad;
  
  private String ae;
  
  private String af;
  
  private String ag;
  
  private ImageView ah;
  
  private String[] ai;
  
  private int aj;
  
  private String ak;
  
  private TextWatcher al;
  
  private ShapeFrameLayout am;
  
  private FlowLayout an;
  
  private LoginAndRegisterProtos.Source ao = LoginAndRegisterProtos.Source.PHONE;
  
  private View ap;
  
  private DatePickerDialog.OnDateSetListener aq = new DatePickerDialog.OnDateSetListener(this) {
      public void a(DatePicker param1DatePicker, int param1Int1, int param1Int2, int param1Int3) {
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append(param1Int1);
        stringBuilder1.append("-");
        stringBuilder1.append(param1Int2 + 1);
        stringBuilder1.append("-");
        stringBuilder1.append(param1Int3);
        int i = TimeAndDateUtils.a(TimeAndDateUtils.c(stringBuilder1.toString(), "yyyy-MM-dd"));
        if (i < 18) {
          AppMethods.d(2131755266);
          return;
        } 
        if (i > 80) {
          AppMethods.d(2131755265);
          return;
        } 
        RegisterV1FinishInfoFragment.a(this.a, param1Int1);
        RegisterV1FinishInfoFragment.b(this.a, param1Int2);
        RegisterV1FinishInfoFragment.c(this.a, param1Int3);
        TextView textView = RegisterV1FinishInfoFragment.h(this.a);
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append(RegisterV1FinishInfoFragment.e(this.a));
        stringBuilder2.append("/");
        stringBuilder2.append(RegisterV1FinishInfoFragment.f(this.a) + 1);
        stringBuilder2.append("/");
        stringBuilder2.append(RegisterV1FinishInfoFragment.g(this.a));
        textView.setText(stringBuilder2.toString());
        RegisterV1FinishInfoFragment registerV1FinishInfoFragment = this.a;
        stringBuilder2 = new StringBuilder();
        stringBuilder2.append(RegisterV1FinishInfoFragment.e(this.a));
        stringBuilder2.append("/");
        stringBuilder2.append(RegisterV1FinishInfoFragment.f(this.a) + 1);
        stringBuilder2.append("/");
        stringBuilder2.append(RegisterV1FinishInfoFragment.g(this.a));
        RegisterV1FinishInfoFragment.b(registerV1FinishInfoFragment, stringBuilder2.toString());
      }
    };
  
  private String ar;
  
  private String as;
  
  private String at;
  
  public BluedUIHttpResponse e = new BluedUIHttpResponse<BluedEntityA<BluedCheckResult>>(this) {
      protected BluedEntityA<BluedCheckResult> a(String param1String) {
        BluedEntityA<BluedCheckResult> bluedEntityA = (BluedEntityA)super.parseData(param1String);
        if (bluedEntityA != null)
          try {
            if (bluedEntityA.data != null && bluedEntityA.data.size() > 0) {
              String str = AesCrypto.c(((BluedCheckResult)bluedEntityA.data.get(0)).get_());
              Logger.b(RegisterV1FinishInfoFragment.o(this.a), new Object[] { "解密：deData===", str });
              BluedCheckResult bluedCheckResult = (BluedCheckResult)AppInfo.f().fromJson(str, BluedCheckResult.class);
              bluedEntityA.data.set(0, bluedCheckResult);
              if (bluedCheckResult != null) {
                String str1 = bluedCheckResult.getMsg();
                Logger.b(RegisterV1FinishInfoFragment.o(this.a), new Object[] { "ret===", str1 });
                Message message = new Message();
                message.what = 3000;
                message.obj = str1;
                this.a.o.sendMessage(message);
                return bluedEntityA;
              } 
            } 
          } catch (Exception exception) {
            exception.printStackTrace();
          }  
        return bluedEntityA;
      }
      
      public void a(BluedEntityA<BluedCheckResult> param1BluedEntityA) {}
      
      public void onFailure(Throwable param1Throwable, int param1Int, String param1String) {
        Logger.b(RegisterV1FinishInfoFragment.o(this.a), new Object[] { "===error", "responseCode:", Integer.valueOf(param1Int), ",responseJson:", RegisterV1FinishInfoFragment.s(this.a) });
        super.onFailure(param1Throwable, param1Int, param1String);
      }
    };
  
  public BluedUIHttpResponse f = new BluedUIHttpResponse<BluedEntity<BluedLoginResult, AVConfigExtra>>(this) {
      public boolean onUIFailure(int param1Int, String param1String) {
        if (param1Int == 4036001) {
          if (this.a.getActivity() != null)
            this.a.getActivity().finish(); 
          return true;
        } 
        return super.onUIFailure(param1Int, param1String);
      }
      
      public void onUIFinish() {
        DialogUtils.b(RegisterV1FinishInfoFragment.t(this.a));
      }
      
      public void onUIStart() {
        DialogUtils.a(RegisterV1FinishInfoFragment.t(this.a));
      }
      
      public void onUIUpdate(BluedEntity<BluedLoginResult, AVConfigExtra> param1BluedEntity) {
        // Byte code:
        //   0: aload_0
        //   1: getfield a : Lcom/soft/blued/ui/login_register/RegisterV1FinishInfoFragment;
        //   4: invokestatic o : (Lcom/soft/blued/ui/login_register/RegisterV1FinishInfoFragment;)Ljava/lang/String;
        //   7: iconst_3
        //   8: anewarray java/lang/Object
        //   11: dup
        //   12: iconst_0
        //   13: ldc '===success'
        //   15: aastore
        //   16: dup
        //   17: iconst_1
        //   18: ldc '加密：responseJson:'
        //   20: aastore
        //   21: dup
        //   22: iconst_2
        //   23: aload_1
        //   24: aastore
        //   25: invokestatic b : (Ljava/lang/String;[Ljava/lang/Object;)V
        //   28: aload_1
        //   29: getfield data : Ljava/util/List;
        //   32: invokeinterface size : ()I
        //   37: ifle -> 340
        //   40: aload_1
        //   41: getfield data : Ljava/util/List;
        //   44: iconst_0
        //   45: invokeinterface get : (I)Ljava/lang/Object;
        //   50: ifnull -> 340
        //   53: aload_1
        //   54: invokevirtual getSingleData : ()Ljava/lang/Object;
        //   57: checkcast com/soft/blued/ui/login_register/model/BluedLoginResult
        //   60: invokevirtual getUid : ()Ljava/lang/String;
        //   63: invokestatic a : (Ljava/lang/String;)V
        //   66: aload_1
        //   67: getfield extra : Lcom/blued/android/framework/http/parser/BluedEntityBaseExtra;
        //   70: ifnull -> 90
        //   73: invokestatic a : ()Lcom/soft/blued/user/AVConfig;
        //   76: aload_1
        //   77: getfield extra : Lcom/blued/android/framework/http/parser/BluedEntityBaseExtra;
        //   80: checkcast com/soft/blued/ui/login_register/model/AVConfigExtra
        //   83: getfield is_kids : Lcom/soft/blued/ui/login_register/model/AVConfigModel;
        //   86: iconst_1
        //   87: invokevirtual a : (Lcom/soft/blued/ui/login_register/model/AVConfigModel;Z)V
        //   90: getstatic com/blued/das/login/LoginAndRegisterProtos$Event.REGISTER_SUCCESS : Lcom/blued/das/login/LoginAndRegisterProtos$Event;
        //   93: astore #5
        //   95: aload_0
        //   96: getfield a : Lcom/soft/blued/ui/login_register/RegisterV1FinishInfoFragment;
        //   99: invokestatic u : (Lcom/soft/blued/ui/login_register/RegisterV1FinishInfoFragment;)Lcom/blued/das/login/LoginAndRegisterProtos$Source;
        //   102: ifnonnull -> 113
        //   105: getstatic com/blued/das/login/LoginAndRegisterProtos$Source.PHONE : Lcom/blued/das/login/LoginAndRegisterProtos$Source;
        //   108: astore #4
        //   110: goto -> 122
        //   113: aload_0
        //   114: getfield a : Lcom/soft/blued/ui/login_register/RegisterV1FinishInfoFragment;
        //   117: invokestatic u : (Lcom/soft/blued/ui/login_register/RegisterV1FinishInfoFragment;)Lcom/blued/das/login/LoginAndRegisterProtos$Source;
        //   120: astore #4
        //   122: aload #5
        //   124: aload #4
        //   126: invokestatic a : (Lcom/blued/das/login/LoginAndRegisterProtos$Event;Lcom/blued/das/login/LoginAndRegisterProtos$Source;)V
        //   129: getstatic com/blued/android/core/AppInfo.c : Ljava/lang/String;
        //   132: ldc 'a0031a'
        //   134: invokevirtual equalsIgnoreCase : (Ljava/lang/String;)Z
        //   137: ifeq -> 153
        //   140: aload_0
        //   141: getfield a : Lcom/soft/blued/ui/login_register/RegisterV1FinishInfoFragment;
        //   144: invokestatic d : (Lcom/soft/blued/ui/login_register/RegisterV1FinishInfoFragment;)Landroid/content/Context;
        //   147: invokestatic a : (Landroid/content/Context;)Ljava/lang/String;
        //   150: invokestatic a : (Ljava/lang/String;)V
        //   153: aload_0
        //   154: getfield a : Lcom/soft/blued/ui/login_register/RegisterV1FinishInfoFragment;
        //   157: invokestatic v : (Lcom/soft/blued/ui/login_register/RegisterV1FinishInfoFragment;)I
        //   160: ifne -> 166
        //   163: goto -> 341
        //   166: aload_0
        //   167: getfield a : Lcom/soft/blued/ui/login_register/RegisterV1FinishInfoFragment;
        //   170: invokestatic v : (Lcom/soft/blued/ui/login_register/RegisterV1FinishInfoFragment;)I
        //   173: iconst_1
        //   174: if_icmpne -> 182
        //   177: iconst_1
        //   178: istore_2
        //   179: goto -> 213
        //   182: aload_0
        //   183: getfield a : Lcom/soft/blued/ui/login_register/RegisterV1FinishInfoFragment;
        //   186: invokestatic v : (Lcom/soft/blued/ui/login_register/RegisterV1FinishInfoFragment;)I
        //   189: iconst_2
        //   190: if_icmpne -> 341
        //   193: aload_0
        //   194: getfield a : Lcom/soft/blued/ui/login_register/RegisterV1FinishInfoFragment;
        //   197: invokestatic u : (Lcom/soft/blued/ui/login_register/RegisterV1FinishInfoFragment;)Lcom/blued/das/login/LoginAndRegisterProtos$Source;
        //   200: getstatic com/blued/das/login/LoginAndRegisterProtos$Source.ONE_CLICK : Lcom/blued/das/login/LoginAndRegisterProtos$Source;
        //   203: if_acmpeq -> 346
        //   206: iconst_1
        //   207: putstatic com/soft/blued/constant/CommonConstants.e : Z
        //   210: goto -> 346
        //   213: aload_1
        //   214: getfield data : Ljava/util/List;
        //   217: iconst_0
        //   218: invokeinterface get : (I)Ljava/lang/Object;
        //   223: checkcast com/soft/blued/ui/login_register/model/BluedLoginResult
        //   226: astore_1
        //   227: aload_1
        //   228: invokevirtual getDevice_safe : ()I
        //   231: iconst_1
        //   232: if_icmpne -> 351
        //   235: iconst_1
        //   236: istore_3
        //   237: goto -> 240
        //   240: iload_3
        //   241: invokestatic D : (Z)V
        //   244: invokestatic a : ()Lcom/soft/blued/user/UserInfo;
        //   247: aload_0
        //   248: getfield a : Lcom/soft/blued/ui/login_register/RegisterV1FinishInfoFragment;
        //   251: invokestatic w : (Lcom/soft/blued/ui/login_register/RegisterV1FinishInfoFragment;)Ljava/lang/String;
        //   254: iload_2
        //   255: aload_0
        //   256: getfield a : Lcom/soft/blued/ui/login_register/RegisterV1FinishInfoFragment;
        //   259: invokestatic s : (Lcom/soft/blued/ui/login_register/RegisterV1FinishInfoFragment;)Ljava/lang/String;
        //   262: aload_1
        //   263: iconst_0
        //   264: anewarray java/lang/String
        //   267: invokevirtual a : (Ljava/lang/String;ILjava/lang/String;Lcom/soft/blued/ui/login_register/model/BluedLoginResult;[Ljava/lang/String;)V
        //   270: aload_0
        //   271: getfield a : Lcom/soft/blued/ui/login_register/RegisterV1FinishInfoFragment;
        //   274: invokestatic x : (Lcom/soft/blued/ui/login_register/RegisterV1FinishInfoFragment;)V
        //   277: aload_0
        //   278: getfield a : Lcom/soft/blued/ui/login_register/RegisterV1FinishInfoFragment;
        //   281: invokestatic v : (Lcom/soft/blued/ui/login_register/RegisterV1FinishInfoFragment;)I
        //   284: iconst_1
        //   285: if_icmpne -> 293
        //   288: ldc 'mo_suc'
        //   290: invokestatic a : (Ljava/lang/String;)V
        //   293: aload_1
        //   294: ifnull -> 319
        //   297: aload_1
        //   298: invokevirtual getNeedAdultVerify : ()I
        //   301: iconst_1
        //   302: if_icmpne -> 319
        //   305: aload_0
        //   306: getfield a : Lcom/soft/blued/ui/login_register/RegisterV1FinishInfoFragment;
        //   309: invokestatic d : (Lcom/soft/blued/ui/login_register/RegisterV1FinishInfoFragment;)Landroid/content/Context;
        //   312: getstatic com/soft/blued/ui/login_register/AdultVerifyFragment$AV_START_PAGE.a : Lcom/soft/blued/ui/login_register/AdultVerifyFragment$AV_START_PAGE;
        //   315: invokestatic a : (Landroid/content/Context;Lcom/soft/blued/ui/login_register/AdultVerifyFragment$AV_START_PAGE;)V
        //   318: return
        //   319: aload_0
        //   320: getfield a : Lcom/soft/blued/ui/login_register/RegisterV1FinishInfoFragment;
        //   323: invokestatic d : (Lcom/soft/blued/ui/login_register/RegisterV1FinishInfoFragment;)Landroid/content/Context;
        //   326: invokestatic a : (Landroid/content/Context;)V
        //   329: return
        //   330: astore_1
        //   331: aload_1
        //   332: invokevirtual printStackTrace : ()V
        //   335: ldc 2131756082
        //   337: invokestatic d : (I)V
        //   340: return
        //   341: iconst_0
        //   342: istore_2
        //   343: goto -> 213
        //   346: iconst_2
        //   347: istore_2
        //   348: goto -> 213
        //   351: iconst_0
        //   352: istore_3
        //   353: goto -> 240
        // Exception table:
        //   from	to	target	type
        //   0	90	330	java/lang/Exception
        //   90	110	330	java/lang/Exception
        //   113	122	330	java/lang/Exception
        //   122	153	330	java/lang/Exception
        //   153	163	330	java/lang/Exception
        //   166	177	330	java/lang/Exception
        //   182	210	330	java/lang/Exception
        //   213	235	330	java/lang/Exception
        //   240	293	330	java/lang/Exception
        //   297	318	330	java/lang/Exception
        //   319	329	330	java/lang/Exception
      }
      
      public BluedEntity<BluedLoginResult, AVConfigExtra> parseData(String param1String) {
        RegisterV1FinishInfoFragment.d(this.a, param1String);
        BluedEntity<BluedLoginResult, AVConfigExtra> bluedEntity = super.parseData(param1String);
        if (bluedEntity != null)
          try {
            if (bluedEntity.data != null && bluedEntity.data.size() > 0) {
              String str = AesCrypto.c(((BluedLoginResult)bluedEntity.data.get(0)).get_());
              Logger.b(RegisterV1FinishInfoFragment.o(this.a), new Object[] { "解密：deData===", str });
              BluedLoginResult bluedLoginResult = (BluedLoginResult)AppInfo.f().fromJson(str, BluedLoginResult.class);
              bluedEntity.data.set(0, bluedLoginResult);
              return bluedEntity;
            } 
          } catch (Exception exception) {
            exception.printStackTrace();
            AppMethods.d(2131756082);
          }  
        return bluedEntity;
      }
    };
  
  public Handler o = new MsgHandler((Fragment)this);
  
  private String p = RegisterV1FinishInfoFragment.class.getSimpleName();
  
  private View q;
  
  private Context r;
  
  private Dialog s;
  
  private PassportTipsModel t = new PassportTipsModel();
  
  private KeyboardListenLinearLayout u;
  
  private TextView v;
  
  private ClearEditText w;
  
  private TextView x;
  
  private TextView y;
  
  private TextView z;
  
  private void A() {
    LoginRegisterHttpUtils.b(new BluedUIHttpResponse<BluedEntityA<BluedCheckResult>>(this, (IRequestHost)w_()) {
          public void a(BluedEntityA<BluedCheckResult> param1BluedEntityA) {
            if (param1BluedEntityA != null) {
              BluedCheckResult bluedCheckResult = param1BluedEntityA.data.get(0);
              if (bluedCheckResult != null) {
                if (bluedCheckResult.health_test_info_show == 1) {
                  RegisterV1FinishInfoFragment.r(this.a).setVisibility(0);
                  return;
                } 
                RegisterV1FinishInfoFragment.r(this.a).setVisibility(8);
              } 
            } 
          }
        });
  }
  
  private void B() {
    int i = this.w.getText().toString().length();
    if (i >= 1 && i <= 20) {
      if (!StringUtils.e(this.w.getText().toString())) {
        LoginRegisterHttpUtils.b(this.e, this.ac, this.w.getText().toString(), (IRequestHost)w_());
        return;
      } 
    } else {
      AppMethods.d(2131756363);
    } 
  }
  
  private void C() {
    if (!StringUtils.e(this.ag)) {
      String str = this.p;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("mImagePath===");
      stringBuilder.append(this.ag);
      Logger.a(str, new Object[] { stringBuilder.toString() });
      LoginRegisterHttpUtils.a(AppInfo.d(), new BluedUIHttpResponse<BluedEntityA<BluedAlbum>>(this) {
            protected void a(BluedEntityA<BluedAlbum> param1BluedEntityA) {
              if (param1BluedEntityA.data != null && param1BluedEntityA.data.size() > 0) {
                BluedAlbum bluedAlbum = param1BluedEntityA.data.get(0);
                ThreadManager.a().a(new ThreadExecutor(this, "uploadQiNiuForRegHead", bluedAlbum) {
                      public void execute() {
                        RegisterV1FinishInfoFragment.a(this.b.a, RegisterV1FinishInfoFragment.y(this.b.a), this.a);
                      }
                    });
              } 
            }
          });
    } 
  }
  
  private void D() {
    PermissionHelper.e(new PermissionCallbacks(this) {
          public void a(String[] param1ArrayOfString) {}
          
          public void aa_() {
            PhotoSelectFragment.a((BaseFragment)this.a, 1, 22);
          }
        });
  }
  
  private void E() {
    if (!StringUtils.e(this.Q) && this.R != 0) {
      int i = BluedPreferences.aD();
      if (this.aj != i) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.y.getText());
        stringBuilder.append("");
        String str = stringBuilder.toString();
        if (!StringUtils.e(str) && str.contains(" / ")) {
          String str1 = str.split(" / ")[0];
          str = str.split(" / ")[1];
          if (i != 1) {
            if (i == 2) {
              StringBuilder stringBuilder2 = new StringBuilder();
              stringBuilder2.append(str1);
              stringBuilder2.append("");
              str1 = stringBuilder2.toString();
              stringBuilder2 = new StringBuilder();
              stringBuilder2.append(str);
              stringBuilder2.append("");
              str = stringBuilder2.toString();
            } 
          } else {
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append(UserRelationshipUtils.c(str1));
            stringBuilder2.append("");
            str1 = stringBuilder2.toString();
            stringBuilder2 = new StringBuilder();
            stringBuilder2.append(UserRelationshipUtils.d(str));
            stringBuilder2.append("");
            str = stringBuilder2.toString();
          } 
          this.R = Integer.parseInt(str);
          str1 = StringUtils.a(str1, BlueAppLocal.c(), false);
          str = StringUtils.b(str, BlueAppLocal.c(), false).replace(" lbs", "");
          TextView textView = this.y;
          StringBuilder stringBuilder1 = new StringBuilder();
          stringBuilder1.append(str1);
          stringBuilder1.append(" / ");
          stringBuilder1.append(str);
          textView.setText(stringBuilder1.toString());
        } 
      } 
    } 
  }
  
  public static void a(Context paramContext) {
    TagAmFragment.a(paramContext);
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, String paramString3, LoginAndRegisterProtos.Source paramSource) {
    Bundle bundle = new Bundle();
    bundle.putInt(LoginRegisterTools.a, 1);
    bundle.putString(LoginRegisterTools.d, paramString1);
    bundle.putString(LoginRegisterTools.h, paramString2);
    bundle.putString(LoginRegisterTools.j, paramString3);
    bundle.putSerializable("RE_KEY_FROM_SRC", (Serializable)paramSource);
    TerminalActivity.d(paramContext, RegisterV1FinishInfoFragment.class, bundle);
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5) {
    Bundle bundle = new Bundle();
    bundle.putString(LoginRegisterTools.d, paramString1);
    String str = LoginRegisterTools.h;
    paramString1 = "";
    bundle.putString(str, "");
    bundle.putString(LoginRegisterTools.i, paramString2);
    if ("plat_weixin".endsWith(paramString3)) {
      bundle.putSerializable("RE_KEY_FROM_SRC", (Serializable)LoginAndRegisterProtos.Source.WECHAT);
      paramString1 = "weixin";
    } else if ("onclick".equals(paramString3)) {
      bundle.putSerializable("RE_KEY_FROM_SRC", (Serializable)LoginAndRegisterProtos.Source.ONE_CLICK);
      paramString1 = "onclick";
    } 
    paramString2 = LoginRegisterTools.a(paramString4, paramString5, paramString1);
    bundle.putString(LoginRegisterTools.b, paramString1);
    bundle.putString(LoginRegisterTools.j, paramString2);
    bundle.putInt(LoginRegisterTools.a, 2);
    TerminalActivity.d(paramContext, RegisterV1FinishInfoFragment.class, bundle);
  }
  
  private void a(TextWatcher paramTextWatcher) {
    this.w.addTextChangedListener(paramTextWatcher);
    this.x.addTextChangedListener(paramTextWatcher);
    this.y.addTextChangedListener(paramTextWatcher);
  }
  
  private void a(String paramString, BluedAlbum paramBluedAlbum) {
    QiniuUploadUtils.a(paramString, paramBluedAlbum, new QiniuUploadTools.QiNiuListener(this) {
          public void a(String param1String) {}
          
          public void a(String param1String, double param1Double) {}
          
          public void a(String param1String1, String param1String2) {
            ThreadManager.a().a(new ThreadExecutor(this, "synServerForRegHead", param1String1) {
                  public void execute() {
                    RegisterV1FinishInfoFragment.a(this.b.a, this.a, UserInfo.a().i().getUid());
                  }
                });
          }
          
          public boolean a() {
            return false;
          }
        });
  }
  
  private void a(String paramString1, String paramString2) {
    LoginRegisterHttpUtils.a(AppInfo.d(), paramString2, new BluedUIHttpResponse<BluedEntityA<BluedAlbum>>(this, paramString1) {
          protected void a(BluedEntityA<BluedAlbum> param1BluedEntityA) {
            UserInfo.a().i().setAvatar(this.a);
            String str = RegisterV1FinishInfoFragment.o(this.b);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("图片地址：picUrl==");
            stringBuilder.append(this.a);
            Logger.a(str, new Object[] { stringBuilder.toString() });
            EventTrackLoginAndRegister.a(LoginAndRegisterProtos.Event.PROFILE_WRITE_PAGE_UPLOAD_PHOTO_CONFIRM_CLICK);
          }
        }paramString1, "", null);
  }
  
  private void b(TextWatcher paramTextWatcher) {
    this.w.removeTextChangedListener(paramTextWatcher);
    this.x.removeTextChangedListener(paramTextWatcher);
    this.y.removeTextChangedListener(paramTextWatcher);
  }
  
  private void u() {
    this.L = (CommonTopTitleNoTrans)this.q.findViewById(2131300300);
    this.L.a();
    this.L.e();
    this.L.setCenterText("");
    this.L.setLeftClickListener(this);
    this.L.setTitleBackgroundDrawable(2131100528);
  }
  
  private void v() {
    this.s = DialogUtils.a(this.r);
    this.am = (ShapeFrameLayout)this.q.findViewById(2131299913);
    ShapeHelper.b((ShapeHelper.ShapeView)this.am, 2131100881);
    this.u = (KeyboardListenLinearLayout)this.q.findViewById(2131297981);
    this.u.setOnClickListener(this);
    BluedPreferences.c(1);
    this.s = DialogUtils.a(this.r);
    this.w = (ClearEditText)this.q.findViewById(2131297007);
    this.w.setOnFocusChangeListener(new View.OnFocusChangeListener(this) {
          public void onFocusChange(View param1View, boolean param1Boolean) {
            if (!param1Boolean)
              RegisterV1FinishInfoFragment.a(this.a); 
          }
        });
    this.D = (TextView)this.q.findViewById(2131301286);
    this.E = (TextView)this.q.findViewById(2131301288);
    this.F = (TextView)this.q.findViewById(2131301290);
    this.G = (TextView)this.q.findViewById(2131301291);
    this.H = (TextView)this.q.findViewById(2131301289);
    this.I = (TextView)this.q.findViewById(2131301287);
    this.an = (FlowLayout)this.q.findViewById(2131299742);
    this.D.setOnClickListener(this);
    this.E.setOnClickListener(this);
    this.F.setOnClickListener(this);
    this.G.setOnClickListener(this);
    this.H.setOnClickListener(this);
    this.I.setOnClickListener(this);
    this.v = (TextView)this.q.findViewById(2131300656);
    this.v.setOnClickListener(this);
    this.q.findViewById(2131298722).setOnClickListener(this);
    this.q.findViewById(2131298875).setOnClickListener(this);
    this.ap = this.q.findViewById(2131298871);
    this.ap.setOnClickListener(this);
    this.x = (TextView)this.q.findViewById(2131300569);
    this.C = (TextView)this.q.findViewById(2131300878);
    this.y = (TextView)this.q.findViewById(2131300886);
    this.z = (TextView)this.q.findViewById(2131301285);
    this.A = (TextView)this.q.findViewById(2131300645);
    this.A.setText("cm/kg");
    this.A.setOnClickListener(this);
    this.B = (TextView)this.q.findViewById(2131300764);
    this.B.setText("ft/lb");
    this.B.setOnClickListener(this);
    this.ah = (ImageView)this.q.findViewById(2131297362);
    this.ah.setOnClickListener(this);
    this.al = new TextWatcher(this) {
        public void afterTextChanged(Editable param1Editable) {
          RegisterV1FinishInfoFragment.b(this.a);
        }
        
        public void beforeTextChanged(CharSequence param1CharSequence, int param1Int1, int param1Int2, int param1Int3) {}
        
        public void onTextChanged(CharSequence param1CharSequence, int param1Int1, int param1Int2, int param1Int3) {}
      };
  }
  
  private void w() {
    this.aa = this.r.getResources().getStringArray(2130903099);
    this.ab = this.r.getResources().getStringArray(2130903046);
    if (getArguments() != null) {
      this.ao = (LoginAndRegisterProtos.Source)getArguments().getSerializable("RE_KEY_FROM_SRC");
      this.ac = getArguments().getString(LoginRegisterTools.d);
      String str = getArguments().getString(LoginRegisterTools.h);
      try {
        this.Y = BluedHttpTools.b(str);
      } catch (NoSuchAlgorithmException noSuchAlgorithmException) {
        noSuchAlgorithmException.printStackTrace();
      } 
      str = getArguments().getString(LoginRegisterTools.i);
      if (!StringUtils.e(str))
        this.w.setText(str); 
      this.ad = getArguments().getInt(LoginRegisterTools.a);
      this.ae = getArguments().getString(LoginRegisterTools.b);
      this.af = getArguments().getString(LoginRegisterTools.j);
      int i = this.ad;
      if (i != 1) {
        if (i != 2) {
          LoginRegisterHttpUtils.a("mail_info");
          LoginAndRegisterProtos.Event event = LoginAndRegisterProtos.Event.PROFILE_WRITE_PAGE_SHOW;
          LoginAndRegisterProtos.Source source2 = this.ao;
          LoginAndRegisterProtos.Source source1 = source2;
          if (source2 == null)
            source1 = LoginAndRegisterProtos.Source.PHONE; 
          EventTrackLoginAndRegister.a(event, source1);
        } else if (this.ae.equals("onclick")) {
          EventTrackLoginAndRegister.a(LoginAndRegisterProtos.Event.PROFILE_WRITE_PAGE_SHOW, LoginAndRegisterProtos.Source.ONE_CLICK);
        } else {
          EventTrackLoginAndRegister.a(LoginAndRegisterProtos.Event.PROFILE_WRITE_PAGE_SHOW, LoginAndRegisterProtos.Source.WECHAT);
        } 
      } else {
        LoginRegisterHttpUtils.a("mo_info");
        LoginAndRegisterProtos.Event event = LoginAndRegisterProtos.Event.PROFILE_WRITE_PAGE_SHOW;
        LoginAndRegisterProtos.Source source2 = this.ao;
        LoginAndRegisterProtos.Source source1 = source2;
        if (source2 == null)
          source1 = LoginAndRegisterProtos.Source.PHONE; 
        EventTrackLoginAndRegister.a(event, source1);
      } 
    } 
    ArrayList<UserTag> arrayList = new ArrayList();
    arrayList.add(new UserTag("1", this.r.getResources().getString(2131758636)));
    arrayList.add(new UserTag("0.75", this.r.getResources().getString(2131758635)));
    arrayList.add(new UserTag("0.5", this.r.getResources().getString(2131758634)));
    arrayList.add(new UserTag("0.25", this.r.getResources().getString(2131758633)));
    arrayList.add(new UserTag("0", this.r.getResources().getString(2131758632)));
    arrayList.add(new UserTag("-1", this.r.getResources().getString(2131758550)));
    a(arrayList);
  }
  
  private void x() {
    if (!StringUtils.e(this.w.getText().toString()) && !StringUtils.e(this.x.getText().toString())) {
      this.v.setEnabled(true);
      return;
    } 
    this.v.setEnabled(false);
  }
  
  private void y() {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual getActivity : ()Landroidx/fragment/app/FragmentActivity;
    //   4: invokestatic from : (Landroid/content/Context;)Landroid/view/LayoutInflater;
    //   7: ldc_w 2131494098
    //   10: aconst_null
    //   11: invokevirtual inflate : (ILandroid/view/ViewGroup;)Landroid/view/View;
    //   14: astore #6
    //   16: invokestatic aD : ()I
    //   19: istore #4
    //   21: new java/lang/StringBuilder
    //   24: dup
    //   25: invokespecial <init> : ()V
    //   28: astore #5
    //   30: aload #5
    //   32: aload_0
    //   33: getfield y : Landroid/widget/TextView;
    //   36: invokevirtual getText : ()Ljava/lang/CharSequence;
    //   39: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   42: pop
    //   43: aload #5
    //   45: ldc ''
    //   47: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   50: pop
    //   51: aload #5
    //   53: invokevirtual toString : ()Ljava/lang/String;
    //   56: invokestatic e : (Ljava/lang/String;)Z
    //   59: ifne -> 307
    //   62: new java/lang/StringBuilder
    //   65: dup
    //   66: invokespecial <init> : ()V
    //   69: astore #5
    //   71: aload #5
    //   73: aload_0
    //   74: getfield y : Landroid/widget/TextView;
    //   77: invokevirtual getText : ()Ljava/lang/CharSequence;
    //   80: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   83: pop
    //   84: aload #5
    //   86: ldc ''
    //   88: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   91: pop
    //   92: aload #5
    //   94: invokevirtual toString : ()Ljava/lang/String;
    //   97: ldc_w ' / '
    //   100: invokevirtual contains : (Ljava/lang/CharSequence;)Z
    //   103: ifeq -> 307
    //   106: iload #4
    //   108: iconst_1
    //   109: if_icmpeq -> 210
    //   112: iload #4
    //   114: iconst_2
    //   115: if_icmpeq -> 123
    //   118: iconst_0
    //   119: istore_1
    //   120: goto -> 257
    //   123: new java/lang/StringBuilder
    //   126: dup
    //   127: invokespecial <init> : ()V
    //   130: astore #5
    //   132: aload #5
    //   134: aload_0
    //   135: getfield y : Landroid/widget/TextView;
    //   138: invokevirtual getText : ()Ljava/lang/CharSequence;
    //   141: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   144: pop
    //   145: aload #5
    //   147: ldc ''
    //   149: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   152: pop
    //   153: aload #5
    //   155: invokevirtual toString : ()Ljava/lang/String;
    //   158: ldc_w ' / '
    //   161: invokevirtual split : (Ljava/lang/String;)[Ljava/lang/String;
    //   164: iconst_0
    //   165: aaload
    //   166: astore #5
    //   168: iconst_0
    //   169: istore_1
    //   170: aload_0
    //   171: getfield ai : [Ljava/lang/String;
    //   174: astore #7
    //   176: iload_1
    //   177: aload #7
    //   179: arraylength
    //   180: if_icmpge -> 205
    //   183: aload #7
    //   185: iload_1
    //   186: aaload
    //   187: aload #5
    //   189: invokevirtual equals : (Ljava/lang/Object;)Z
    //   192: ifeq -> 198
    //   195: goto -> 207
    //   198: iload_1
    //   199: iconst_1
    //   200: iadd
    //   201: istore_1
    //   202: goto -> 170
    //   205: iconst_0
    //   206: istore_1
    //   207: goto -> 257
    //   210: new java/lang/StringBuilder
    //   213: dup
    //   214: invokespecial <init> : ()V
    //   217: astore #5
    //   219: aload #5
    //   221: aload_0
    //   222: getfield y : Landroid/widget/TextView;
    //   225: invokevirtual getText : ()Ljava/lang/CharSequence;
    //   228: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   231: pop
    //   232: aload #5
    //   234: ldc ''
    //   236: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   239: pop
    //   240: aload #5
    //   242: invokevirtual toString : ()Ljava/lang/String;
    //   245: ldc_w ' / '
    //   248: invokevirtual split : (Ljava/lang/String;)[Ljava/lang/String;
    //   251: iconst_0
    //   252: aaload
    //   253: invokestatic parseInt : (Ljava/lang/String;)I
    //   256: istore_1
    //   257: new java/lang/StringBuilder
    //   260: dup
    //   261: invokespecial <init> : ()V
    //   264: astore #5
    //   266: aload #5
    //   268: aload_0
    //   269: getfield y : Landroid/widget/TextView;
    //   272: invokevirtual getText : ()Ljava/lang/CharSequence;
    //   275: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   278: pop
    //   279: aload #5
    //   281: ldc ''
    //   283: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   286: pop
    //   287: aload #5
    //   289: invokevirtual toString : ()Ljava/lang/String;
    //   292: ldc_w ' / '
    //   295: invokevirtual split : (Ljava/lang/String;)[Ljava/lang/String;
    //   298: iconst_1
    //   299: aaload
    //   300: invokestatic parseInt : (Ljava/lang/String;)I
    //   303: istore_2
    //   304: goto -> 343
    //   307: iload #4
    //   309: iconst_1
    //   310: if_icmpeq -> 336
    //   313: iload #4
    //   315: iconst_2
    //   316: if_icmpeq -> 326
    //   319: iconst_0
    //   320: istore_1
    //   321: iconst_0
    //   322: istore_2
    //   323: goto -> 343
    //   326: bipush #20
    //   328: istore_1
    //   329: sipush #135
    //   332: istore_2
    //   333: goto -> 343
    //   336: sipush #170
    //   339: istore_1
    //   340: bipush #65
    //   342: istore_2
    //   343: aload #6
    //   345: ldc_w 2131299409
    //   348: invokevirtual findViewById : (I)Landroid/view/View;
    //   351: checkcast net/simonvt/numberpicker/NumberPicker
    //   354: astore #5
    //   356: aload #5
    //   358: new com/soft/blued/ui/login_register/RegisterV1FinishInfoFragment$8
    //   361: dup
    //   362: aload_0
    //   363: invokespecial <init> : (Lcom/soft/blued/ui/login_register/RegisterV1FinishInfoFragment;)V
    //   366: invokevirtual setOnValueChangedListener : (Lnet/simonvt/numberpicker/NumberPicker$OnValueChangeListener;)V
    //   369: iload #4
    //   371: iconst_1
    //   372: if_icmpeq -> 495
    //   375: iload #4
    //   377: iconst_2
    //   378: if_icmpeq -> 384
    //   381: goto -> 573
    //   384: iload_1
    //   385: ifge -> 401
    //   388: aload_0
    //   389: aload_0
    //   390: getfield ai : [Ljava/lang/String;
    //   393: iconst_0
    //   394: aaload
    //   395: putfield Q : Ljava/lang/String;
    //   398: goto -> 439
    //   401: aload_0
    //   402: getfield ai : [Ljava/lang/String;
    //   405: astore #7
    //   407: iload_1
    //   408: aload #7
    //   410: arraylength
    //   411: iconst_1
    //   412: isub
    //   413: if_icmple -> 431
    //   416: aload_0
    //   417: aload #7
    //   419: aload #7
    //   421: arraylength
    //   422: iconst_1
    //   423: isub
    //   424: aaload
    //   425: putfield Q : Ljava/lang/String;
    //   428: goto -> 439
    //   431: aload_0
    //   432: aload #7
    //   434: iload_1
    //   435: aaload
    //   436: putfield Q : Ljava/lang/String;
    //   439: aload_0
    //   440: iconst_0
    //   441: putfield U : I
    //   444: aload_0
    //   445: getfield ai : [Ljava/lang/String;
    //   448: astore #7
    //   450: aload_0
    //   451: aload #7
    //   453: arraylength
    //   454: iconst_1
    //   455: isub
    //   456: putfield V : I
    //   459: aload_0
    //   460: bipush #20
    //   462: putfield S : I
    //   465: aload #5
    //   467: aload #7
    //   469: invokevirtual setDisplayedValues : ([Ljava/lang/String;)V
    //   472: aload_0
    //   473: bipush #66
    //   475: putfield W : I
    //   478: aload_0
    //   479: sipush #441
    //   482: putfield X : I
    //   485: aload_0
    //   486: sipush #132
    //   489: putfield T : I
    //   492: goto -> 573
    //   495: new java/lang/StringBuilder
    //   498: dup
    //   499: invokespecial <init> : ()V
    //   502: astore #7
    //   504: aload #7
    //   506: iload_1
    //   507: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   510: pop
    //   511: aload #7
    //   513: ldc ''
    //   515: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   518: pop
    //   519: aload_0
    //   520: aload #7
    //   522: invokevirtual toString : ()Ljava/lang/String;
    //   525: putfield Q : Ljava/lang/String;
    //   528: aload_0
    //   529: bipush #120
    //   531: putfield U : I
    //   534: aload_0
    //   535: sipush #220
    //   538: putfield V : I
    //   541: aload_0
    //   542: sipush #170
    //   545: putfield S : I
    //   548: aload #5
    //   550: aconst_null
    //   551: invokevirtual setDisplayedValues : ([Ljava/lang/String;)V
    //   554: aload_0
    //   555: bipush #30
    //   557: putfield W : I
    //   560: aload_0
    //   561: sipush #200
    //   564: putfield X : I
    //   567: aload_0
    //   568: bipush #60
    //   570: putfield T : I
    //   573: iload_1
    //   574: istore_3
    //   575: iload_1
    //   576: ifne -> 584
    //   579: aload_0
    //   580: getfield S : I
    //   583: istore_3
    //   584: aload #5
    //   586: aload_0
    //   587: getfield U : I
    //   590: invokevirtual setMinValue : (I)V
    //   593: aload #5
    //   595: aload_0
    //   596: getfield V : I
    //   599: invokevirtual setMaxValue : (I)V
    //   602: aload #5
    //   604: iload_3
    //   605: invokevirtual setValue : (I)V
    //   608: aload #5
    //   610: iconst_1
    //   611: invokevirtual setFocusable : (Z)V
    //   614: aload #5
    //   616: iconst_1
    //   617: invokevirtual setFocusableInTouchMode : (Z)V
    //   620: aload #6
    //   622: ldc_w 2131299410
    //   625: invokevirtual findViewById : (I)Landroid/view/View;
    //   628: checkcast net/simonvt/numberpicker/NumberPicker
    //   631: astore #5
    //   633: aload #5
    //   635: new com/soft/blued/ui/login_register/RegisterV1FinishInfoFragment$9
    //   638: dup
    //   639: aload_0
    //   640: invokespecial <init> : (Lcom/soft/blued/ui/login_register/RegisterV1FinishInfoFragment;)V
    //   643: invokevirtual setOnValueChangedListener : (Lnet/simonvt/numberpicker/NumberPicker$OnValueChangeListener;)V
    //   646: aload_0
    //   647: iload_2
    //   648: putfield R : I
    //   651: aload #5
    //   653: aload_0
    //   654: getfield W : I
    //   657: invokevirtual setMinValue : (I)V
    //   660: aload #5
    //   662: aload_0
    //   663: getfield X : I
    //   666: invokevirtual setMaxValue : (I)V
    //   669: aload #5
    //   671: iload_2
    //   672: invokevirtual setValue : (I)V
    //   675: aload #5
    //   677: iconst_1
    //   678: invokevirtual setFocusable : (Z)V
    //   681: aload #5
    //   683: iconst_1
    //   684: invokevirtual setFocusableInTouchMode : (Z)V
    //   687: aload_0
    //   688: invokevirtual getResources : ()Landroid/content/res/Resources;
    //   691: ldc_w 2131755611
    //   694: invokevirtual getString : (I)Ljava/lang/String;
    //   697: astore #5
    //   699: iload #4
    //   701: iconst_1
    //   702: if_icmpeq -> 729
    //   705: iload #4
    //   707: iconst_2
    //   708: if_icmpeq -> 714
    //   711: goto -> 741
    //   714: aload_0
    //   715: invokevirtual getResources : ()Landroid/content/res/Resources;
    //   718: ldc_w 2131756880
    //   721: invokevirtual getString : (I)Ljava/lang/String;
    //   724: astore #5
    //   726: goto -> 741
    //   729: aload_0
    //   730: invokevirtual getResources : ()Landroid/content/res/Resources;
    //   733: ldc_w 2131755611
    //   736: invokevirtual getString : (I)Ljava/lang/String;
    //   739: astore #5
    //   741: aload_0
    //   742: invokevirtual getActivity : ()Landroidx/fragment/app/FragmentActivity;
    //   745: aload #6
    //   747: aload #5
    //   749: ldc ''
    //   751: aload_0
    //   752: invokevirtual getResources : ()Landroid/content/res/Resources;
    //   755: ldc_w 2131755609
    //   758: invokevirtual getString : (I)Ljava/lang/String;
    //   761: new com/soft/blued/ui/login_register/RegisterV1FinishInfoFragment$10
    //   764: dup
    //   765: aload_0
    //   766: invokespecial <init> : (Lcom/soft/blued/ui/login_register/RegisterV1FinishInfoFragment;)V
    //   769: aconst_null
    //   770: iconst_1
    //   771: invokestatic a : (Landroid/content/Context;Landroid/view/View;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroid/content/DialogInterface$OnClickListener;Landroid/content/DialogInterface$OnCancelListener;Z)V
    //   774: return
  }
  
  private boolean z() {
    return (StringUtils.e(this.w.getText().toString()) || StringUtils.e(this.P));
  }
  
  public void a(Message paramMessage) {
    if (paramMessage.what != 3000)
      return; 
    String str = (String)paramMessage.obj;
    if (TextUtils.isEmpty(str)) {
      AppMethods.d(2131755539);
      return;
    } 
    AppMethods.a(str);
  }
  
  public void a(TextView paramTextView) {
    paramTextView.requestFocus();
    this.H.setSelected(false);
    this.E.setSelected(false);
    this.F.setSelected(false);
    this.G.setSelected(false);
    this.I.setSelected(false);
    this.D.setSelected(false);
    this.H.setTextColor(BluedSkinUtils.a(this.r, 2131100838));
    this.D.setTextColor(BluedSkinUtils.a(this.r, 2131100838));
    this.I.setTextColor(BluedSkinUtils.a(this.r, 2131100838));
    this.E.setTextColor(BluedSkinUtils.a(this.r, 2131100838));
    this.F.setTextColor(BluedSkinUtils.a(this.r, 2131100838));
    this.G.setTextColor(BluedSkinUtils.a(this.r, 2131100838));
    paramTextView.setSelected(true);
    paramTextView.setTextColor(getResources().getColor(2131100728));
    x();
  }
  
  public void a(List<UserTag> paramList) {
    if (paramList != null && paramList.size() > 0) {
      this.an.removeAllViews();
      for (int i = 0; i < paramList.size(); i++) {
        View view = LayoutInflater.from(this.r).inflate(2131494099, null);
        TextView textView = (TextView)view.findViewById(2131301371);
        textView.setText(((UserTag)paramList.get(i)).name);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("name:");
        stringBuilder.append(((UserTag)paramList.get(i)).name);
        Log.v("drb", stringBuilder.toString());
        if (((UserTag)paramList.get(i)).checked == 0) {
          textView.setBackground(BluedSkinUtils.b(this.r, 2131234361));
          textView.setTextColor(BluedSkinUtils.a(this.r, 2131100838));
        } else {
          textView.setBackground(BluedSkinUtils.b(this.r, 2131234362));
          textView.setTextColor(BluedSkinUtils.a(this.r, 2131100728));
        } 
        this.an.addView(view);
      } 
      this.an.setOnItemClickListener(new FlowLayout.OnItemClickListener(this, paramList) {
            public void a(View param1View, int param1Int) {
              Logger.a("drb", new Object[] { "mFlowLayout onItemClick" });
              UserTag userTag = this.a.get(param1Int);
              if (userTag.checked == 0) {
                for (param1Int = 0; param1Int < this.a.size(); param1Int++) {
                  ((UserTag)this.a.get(param1Int)).checked = 0;
                  TextView textView1 = (TextView)RegisterV1FinishInfoFragment.c(this.b).getChildAt(param1Int).findViewById(2131301371);
                  textView1.setBackgroundResource(2131234361);
                  textView1.setTextColor(BluedSkinUtils.a(RegisterV1FinishInfoFragment.d(this.b), 2131100838));
                } 
                userTag.checked = 1;
                TextView textView = (TextView)param1View.findViewById(2131301371);
                textView.setBackground(BluedSkinUtils.b(RegisterV1FinishInfoFragment.d(this.b), 2131234362));
                textView.setTextColor(BluedSkinUtils.a(RegisterV1FinishInfoFragment.d(this.b), 2131100728));
                RegisterV1FinishInfoFragment.a(this.b, userTag.id);
              } 
              StringBuilder stringBuilder = new StringBuilder();
              stringBuilder.append("userTag.checked = ");
              stringBuilder.append(userTag.checked);
              Log.v("drb", stringBuilder.toString());
              RegisterV1FinishInfoFragment.b(this.b);
            }
          });
    } 
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {
    if (paramInt2 == -1)
      if (paramInt1 != 22) {
        if (paramInt1 == 513) {
          this.ar = paramIntent.getStringExtra("health_result");
          this.as = paramIntent.getStringExtra("health_time");
          this.at = paramIntent.getStringExtra("health_prep");
          if (TextUtils.equals(this.ar, "-1") && TextUtils.equals(this.as, "-1") && TextUtils.equals(this.at, "-1")) {
            this.C.setText("");
          } else {
            this.C.setText(2131756857);
          } 
        } 
      } else if (paramIntent != null) {
        this.ag = paramIntent.getStringExtra("photo_path");
        ImageLoader.d((IRequestHost)w_(), this.ag).c().a(2131234356).a(this.ah);
      }  
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public void onClick(View paramView) {
    LoginAndRegisterProtos.Source source1;
    LoginAndRegisterProtos.Source source2;
    LoginAndRegisterProtos.Event event;
    int i = paramView.getId();
    switch (i) {
      default:
        switch (i) {
          default:
            return;
          case 2131301291:
            EventTrackLoginAndRegister.a(LoginAndRegisterProtos.Event.PROFILE_WRITE_PAGE_ROLE_BTN_CLICK, LoginAndRegisterProtos.RoleType.OTHER);
            if (this.w.isFocused())
              this.w.clearFocus(); 
            this.K = "-1";
            a(this.G);
            return;
          case 2131301290:
            EventTrackLoginAndRegister.a(LoginAndRegisterProtos.Event.PROFILE_WRITE_PAGE_ROLE_BTN_CLICK, LoginAndRegisterProtos.RoleType.ONE);
            if (this.w.isFocused())
              this.w.clearFocus(); 
            this.K = "1";
            a(this.F);
            return;
          case 2131301289:
            EventTrackLoginAndRegister.a(LoginAndRegisterProtos.Event.PROFILE_WRITE_PAGE_ROLE_BTN_CLICK, LoginAndRegisterProtos.RoleType.UNKNOWN_ROLE_TYPE);
            if (this.w.isFocused())
              this.w.clearFocus(); 
            this.K = "0.75";
            a(this.H);
            return;
          case 2131301288:
            EventTrackLoginAndRegister.a(LoginAndRegisterProtos.Event.PROFILE_WRITE_PAGE_ROLE_BTN_CLICK, LoginAndRegisterProtos.RoleType.HARF);
            if (this.w.isFocused())
              this.w.clearFocus(); 
            this.K = "0.5";
            a(this.E);
            return;
          case 2131301287:
            EventTrackLoginAndRegister.a(LoginAndRegisterProtos.Event.PROFILE_WRITE_PAGE_ROLE_BTN_CLICK, LoginAndRegisterProtos.RoleType.HARF);
            if (this.w.isFocused())
              this.w.clearFocus(); 
            this.K = "0.25";
            a(this.I);
            return;
          case 2131301286:
            break;
        } 
        EventTrackLoginAndRegister.a(LoginAndRegisterProtos.Event.PROFILE_WRITE_PAGE_ROLE_BTN_CLICK, LoginAndRegisterProtos.RoleType.ZERO);
        if (this.w.isFocused())
          this.w.clearFocus(); 
        this.K = "0";
        a(this.D);
        return;
      case 2131300764:
        EventTrackLoginAndRegister.a(LoginAndRegisterProtos.Event.PROFILE_WRITE_PAGE_UNIT_BTN_CLICK, LoginAndRegisterProtos.UnitType.FT_LB);
        if (this.w.isFocused())
          this.w.clearFocus(); 
        this.aj = BluedPreferences.aD();
        BluedPreferences.c(2);
        this.B.setBackground(BluedSkinUtils.b(this.r, 2131234362));
        this.A.setBackground(BluedSkinUtils.b(this.r, 2131234361));
        this.B.setTextColor(BluedSkinUtils.a(this.r, 2131100728));
        this.A.setTextColor(BluedSkinUtils.a(this.r, 2131100838));
        E();
        return;
      case 2131300656:
        event = LoginAndRegisterProtos.Event.PROFILE_WRITE_PAGE_CONFIRM_BTN_CLICK;
        source2 = this.ao;
        source1 = source2;
        if (source2 == null)
          source1 = LoginAndRegisterProtos.Source.PHONE; 
        EventTrackLoginAndRegister.a(event, source1);
        if (this.w.isFocused())
          this.w.clearFocus(); 
        i = this.ad;
        if (i == 0) {
          LoginRegisterHttpUtils.a("mail_fin");
        } else if (i == 1) {
          LoginRegisterHttpUtils.a("mo_fin");
        } 
        if (!z()) {
          t();
          return;
        } 
        AppMethods.d(2131755621);
        return;
      case 2131300645:
        EventTrackLoginAndRegister.a(LoginAndRegisterProtos.Event.PROFILE_WRITE_PAGE_UNIT_BTN_CLICK, LoginAndRegisterProtos.UnitType.CM_KG);
        if (this.w.isFocused())
          this.w.clearFocus(); 
        this.aj = BluedPreferences.aD();
        BluedPreferences.c(1);
        this.A.setBackground(BluedSkinUtils.b(this.r, 2131234362));
        this.B.setBackground(BluedSkinUtils.b(this.r, 2131234361));
        this.A.setTextColor(BluedSkinUtils.a(this.r, 2131100728));
        this.B.setTextColor(BluedSkinUtils.a(this.r, 2131100838));
        E();
        return;
      case 2131298875:
        if (this.w.isFocused())
          this.w.clearFocus(); 
        y();
        return;
      case 2131298871:
        ModifyHealthFragment.a((BaseFragment)this, this.ar, this.as, this.at, 513);
        return;
      case 2131298722:
        if (this.w.isFocused())
          this.w.clearFocus(); 
        (new MDatePickerDialog(this.r, this.aq, this.M, this.N, this.O)).show();
        return;
      case 2131297981:
        KeyboardUtils.a((Activity)getActivity());
        return;
      case 2131297362:
        EventTrackLoginAndRegister.a(LoginAndRegisterProtos.Event.PROFILE_WRITE_PAGE_UPLOAD_PHOTO_CLICK);
        if (this.w.isFocused())
          this.w.clearFocus(); 
        D();
        return;
      case 2131296863:
        break;
    } 
    getActivity().finish();
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
    this.ai = getResources().getStringArray(2130903079);
    this.r = (Context)getActivity();
    Calendar calendar = Calendar.getInstance();
    this.M = calendar.get(1) - 20;
    this.N = calendar.get(2);
    this.O = calendar.get(5);
    View view = this.q;
    if (view == null) {
      this.q = paramLayoutInflater.inflate(2131493296, paramViewGroup, false);
      u();
      v();
      w();
      this.u.setBackgroundColor(BluedSkinUtils.a(this.r, 2131100728));
      a(this.u);
      A();
    } else if (view.getParent() != null) {
      ((ViewGroup)this.q.getParent()).removeView(this.q);
    } 
    return this.q;
  }
  
  public void onResume() {
    super.onResume();
    x();
    a(this.al);
  }
  
  public void onStop() {
    b(this.al);
    super.onStop();
  }
  
  public void t() {
    boolean bool;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(this.y.getText());
    String str2 = "";
    stringBuilder.append("");
    String str1 = stringBuilder.toString();
    int i = BluedPreferences.aD();
    if (StringUtils.e(str1)) {
      if (i == 2) {
        str1 = "5'7\" / 143";
      } else {
        str1 = "170 / 65";
      } 
      bool = true;
    } else {
      bool = false;
    } 
    if (str1.contains(" / ")) {
      String str3;
      String str4;
      String str7 = str1.split(" / ")[0];
      String str6 = str1.split(" / ")[1];
      str1 = str6;
      String str5 = str7;
      if (i != 1)
        if (i != 2) {
          str1 = str6;
          str5 = str7;
        } else {
          StringBuilder stringBuilder3 = new StringBuilder();
          stringBuilder3.append(UserRelationshipUtils.c(str7));
          stringBuilder3.append("");
          str5 = stringBuilder3.toString();
          stringBuilder3 = new StringBuilder();
          StringBuilder stringBuilder4 = new StringBuilder();
          stringBuilder4.append(str6);
          stringBuilder4.append("");
          stringBuilder3.append(UserRelationshipUtils.d(stringBuilder4.toString()));
          stringBuilder3.append("");
          str3 = stringBuilder3.toString();
        }  
      BluedUIHttpResponse bluedUIHttpResponse = this.f;
      str7 = this.ac;
      String str8 = this.w.getText().toString();
      String str9 = this.Y;
      StringBuilder stringBuilder2 = new StringBuilder();
      stringBuilder2.append(str5);
      stringBuilder2.append("");
      String str10 = stringBuilder2.toString();
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append(str3);
      stringBuilder1.append("");
      String str11 = stringBuilder1.toString();
      String str12 = this.K;
      String str13 = TimeAndDateUtils.b(this.x.getText().toString(), "yyyy/MM/dd");
      String str14 = this.J;
      if (TextUtils.equals(this.ar, "-1")) {
        str3 = "";
      } else {
        str3 = this.ar;
      } 
      if (TextUtils.equals(this.as, "-1")) {
        str4 = "";
      } else {
        str4 = this.as;
      } 
      if (!TextUtils.equals(this.at, "-1"))
        str2 = this.at; 
      LoginRegisterHttpUtils.a(bluedUIHttpResponse, str7, str8, str9, str10, str11, str12, str13, str14, bool, str3, str4, str2, (IRequestHost)w_());
    } 
  }
  
  static class MsgHandler extends Handler {
    private WeakReference<Fragment> a;
    
    MsgHandler(Fragment param1Fragment) {
      this.a = new WeakReference<Fragment>(param1Fragment);
    }
    
    public void handleMessage(Message param1Message) {
      RegisterV1FinishInfoFragment registerV1FinishInfoFragment = (RegisterV1FinishInfoFragment)this.a.get();
      if (registerV1FinishInfoFragment != null)
        registerV1FinishInfoFragment.a(param1Message); 
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\login_register\RegisterV1FinishInfoFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */