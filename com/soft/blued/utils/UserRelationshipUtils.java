package com.soft.blued.utils;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.collection.ArrayMap;
import androidx.core.content.ContextCompat;
import androidx.core.util.Pair;
import com.blued.android.core.AppInfo;
import com.blued.android.core.AppMethods;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.ui.ActivityStack;
import com.blued.android.core.utils.skin.BluedSkinUtils;
import com.blued.android.framework.http.BluedHttpUtils;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.http.parser.BluedEntityBaseExtra;
import com.blued.android.framework.utils.AesCrypto;
import com.blued.android.module.common.utils.DialogUtils;
import com.blued.android.module.live_china.model.LiveRoomData;
import com.soft.blued.BluedConstant;
import com.soft.blued.http.LoginRegisterHttpUtils;
import com.soft.blued.http.UserHttpUtils;
import com.soft.blued.push.PushManager;
import com.soft.blued.ui.find.model.UserBasicModel;
import com.soft.blued.ui.live.LiveRoomInfoChannel;
import com.soft.blued.ui.live.model.BluedLiveListData;
import com.soft.blued.ui.login_register.LoginRegisterTools;
import com.soft.blued.ui.login_register.LoginV1ForThreeActivity;
import com.soft.blued.ui.login_register.SignInActivity;
import com.soft.blued.ui.login_register.model.AVConfigExtra;
import com.soft.blued.ui.login_register.model.AppConfigModel;
import com.soft.blued.ui.login_register.model.BluedLoginResult;
import com.soft.blued.ui.mine.model.MineEntryInfo;
import com.soft.blued.ui.setting.activity.SwitchAccountActivity;
import com.soft.blued.user.AVConfig;
import com.soft.blued.user.UserInfo;
import com.soft.blued.view.tip.CommonAlertDialog;
import java.util.List;

public class UserRelationshipUtils {
  public static ArrayMap<String, String> a;
  
  public static ArrayMap<String, String> b;
  
  public static ArrayMap<String, String> c;
  
  public static ArrayMap<String, String> d;
  
  public static ArrayMap<String, String> e;
  
  public static ArrayMap<String, String> f;
  
  public static ArrayMap<String, String> g;
  
  public static ArrayMap<String, String> h;
  
  public static ArrayMap<String, String> i;
  
  public static ArrayMap<String, String> j;
  
  public static ArrayMap<String, String> k;
  
  public static int[] l;
  
  private static final String m = UserRelationshipUtils.class.getSimpleName();
  
  static {
    a = new ArrayMap();
    b = new ArrayMap();
    c = new ArrayMap();
    d = new ArrayMap();
    e = new ArrayMap();
    f = new ArrayMap();
    g = new ArrayMap();
    h = new ArrayMap();
    i = new ArrayMap();
    j = new ArrayMap();
    k = new ArrayMap();
    l = new int[] { 4, 5, 6, 7 };
  }
  
  private static int a(int paramInt1, int paramInt2) {
    return (paramInt1 != 2) ? ((paramInt1 != 3) ? ((paramInt1 != 4) ? ((paramInt1 != 5) ? ((paramInt1 != 7) ? 0 : 2131234382) : 2131234380) : 2131234384) : 2131234381) : 2131234372;
  }
  
  public static int a(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    if (paramInt1 == 1)
      return 1; 
    if (paramInt2 == 0 && paramInt3 != 1) {
      if (paramInt3 == 0) {
        paramInt1 = 2;
      } else {
        paramInt1 = 4;
      } 
    } else {
      paramInt1 = 0;
    } 
    if (paramInt4 == 0)
      paramInt1 = 3; 
    return paramInt1;
  }
  
  public static String a(Context paramContext, TextView paramTextView, String paramString) {
    String str;
    if (!TextUtils.isEmpty(paramString)) {
      if ("0".equals(paramString)) {
        str = paramContext.getString(2131758632);
      } else if ("1".equals(paramString)) {
        str = str.getString(2131758636);
      } else if ("0.5".equals(paramString)) {
        str = str.getString(2131758634);
      } else if ("-1".equals(paramString)) {
        str = str.getString(2131758638);
      } else if ("0.75".equals(paramString)) {
        str = str.getString(2131758635);
      } else if ("0.25".equals(paramString)) {
        str = str.getString(2131758633);
      } else {
        str = str.getString(2131758638);
      } 
    } else {
      str = str.getString(2131758638);
    } 
    if (paramTextView != null)
      paramTextView.setText(str); 
    return str;
  }
  
  public static String a(Short paramShort, long paramLong) {
    int i = Integer.parseInt(String.valueOf(paramLong));
    return (paramShort.shortValue() == 2) ? "MN" : ((paramShort.shortValue() == 3) ? "PN" : ((i != 1) ? ((i != 3) ? ((i != 5) ? "PN" : "FN") : "TN") : "AN"));
  }
  
  public static void a() {
    for (Activity activity : ActivityStack.a().b()) {
      if (activity.getClass() == SwitchAccountActivity.class) {
        activity.finish();
        break;
      } 
    } 
  }
  
  public static void a(Context paramContext, TextView paramTextView, UserBasicModel paramUserBasicModel) {
    a(paramContext, paramTextView, paramUserBasicModel, -1);
  }
  
  public static void a(Context paramContext, TextView paramTextView, UserBasicModel paramUserBasicModel, int paramInt) {
    if (paramTextView != null && paramUserBasicModel != null) {
      int i = paramUserBasicModel.vip_grade;
      if (paramUserBasicModel.is_hide_vip_look == 1)
        i = 0; 
      if (i != 1 && i != 2) {
        if (paramInt == -1) {
          paramTextView.setTextColor(BluedSkinUtils.a(paramContext, 2131100838));
          return;
        } 
        paramTextView.setTextColor(BluedSkinUtils.a(paramContext, paramInt));
        return;
      } 
      paramTextView.setTextColor(BluedSkinUtils.a(paramContext, 2131100837));
    } 
  }
  
  public static void a(Context paramContext, UserBasicModel paramUserBasicModel, long paramLong, String paramString) {
    a(paramContext, paramUserBasicModel, paramLong, paramString, (List<BluedLiveListData>)null);
  }
  
  public static void a(Context paramContext, UserBasicModel paramUserBasicModel, long paramLong, String paramString1, String paramString2, String paramString3, int paramInt) {
    String str1 = paramUserBasicModel.uid;
    String str2 = paramUserBasicModel.avatar;
    LiveRoomData liveRoomData = new LiveRoomData(paramLong, 0, paramString1, str1, paramUserBasicModel.name, str2, paramUserBasicModel.vbadge);
    liveRoomData.liveFrom = paramString2;
    liveRoomData.recommendType = paramString3;
    liveRoomData.livePosition = paramInt;
    LiveRoomInfoChannel.a(paramContext, liveRoomData, -1, LiveRoomInfoChannel.a(null, paramString1));
  }
  
  public static void a(Context paramContext, UserBasicModel paramUserBasicModel, long paramLong, String paramString, List<BluedLiveListData> paramList) {
    String str1 = paramUserBasicModel.uid;
    String str2 = paramUserBasicModel.avatar;
    LiveRoomInfoChannel.a(paramContext, new LiveRoomData(paramLong, 0, paramString, str1, paramUserBasicModel.name, str2, paramUserBasicModel.vbadge), -1, LiveRoomInfoChannel.a(paramList, paramString));
  }
  
  public static void a(Context paramContext, IAddOrRemoveAttentionDone paramIAddOrRemoveAttentionDone, String paramString, IRequestHost paramIRequestHost) {
    UserHttpUtils.a(paramContext, paramIAddOrRemoveAttentionDone, paramString, "", paramIRequestHost);
  }
  
  public static void a(Context paramContext, IAddOrRemoveAttentionDone paramIAddOrRemoveAttentionDone, String paramString1, String paramString2, String paramString3, IRequestHost paramIRequestHost, boolean paramBoolean) {
    if (!"3".equals(paramString2) && !"1".equals(paramString2)) {
      UserHttpUtils.b(paramContext, paramIAddOrRemoveAttentionDone, paramString1, paramString3, paramIRequestHost);
      return;
    } 
    if (paramBoolean) {
      CommonAlertDialog.a(paramContext, paramContext.getResources().getString(2131756094), paramContext.getResources().getString(2131755729), paramContext.getResources().getString(2131756086), new DialogInterface.OnClickListener(paramContext, paramIAddOrRemoveAttentionDone, paramString1, paramIRequestHost) {
            public void onClick(DialogInterface param1DialogInterface, int param1Int) {
              UserRelationshipUtils.a(this.a, this.b, this.c, this.d);
            }
          }null, null, null);
      return;
    } 
    UserHttpUtils.a(paramContext, paramIAddOrRemoveAttentionDone, paramString1, paramString3, paramIRequestHost);
  }
  
  public static void a(Context paramContext, String paramString) {
    LoginRegisterHttpUtils.a(new BluedUIHttpResponse<BluedEntityA<BluedEntityBaseExtra>>(DialogUtils.a(paramContext), paramString) {
          private boolean c = false;
          
          protected void a(BluedEntityA<BluedEntityBaseExtra> param1BluedEntityA) {}
          
          public boolean onUIFailure(int param1Int, String param1String) {
            if (param1Int == 4036501)
              this.c = true; 
            return true;
          }
          
          public void onUIFinish() {
            super.onUIFinish();
            DialogUtils.b(this.a);
            if (this.c)
              UserRelationshipUtils.a(this.b, new int[0]); 
          }
          
          public void onUIStart() {
            super.onUIStart();
            DialogUtils.a(this.a);
          }
        });
  }
  
  public static void a(Context paramContext, String paramString, TextView paramTextView, ImageView paramImageView, boolean paramBoolean) {
    if (!StringUtils.e(paramString)) {
      if (paramTextView != null) {
        if (paramBoolean)
          paramTextView.setTextColor(BluedSkinUtils.a(paramContext, 2131100842)); 
        if ("0".equals(paramString)) {
          paramTextView.setText(2131755359);
          if (paramBoolean)
            paramTextView.setTextColor(BluedSkinUtils.a(paramContext, 2131100716)); 
        } else if ("1".equals(paramString)) {
          paramTextView.setText(2131756545);
        } else if ("2".equals(paramString)) {
          paramTextView.setText(2131755437);
        } else if ("3".equals(paramString)) {
          paramTextView.setText(2131756538);
        } else {
          paramTextView.setText(2131755359);
        } 
      } 
      if (paramImageView != null) {
        if ("0".equals(paramString)) {
          paramImageView.setImageResource(2131232771);
          return;
        } 
        if ("1".equals(paramString)) {
          paramImageView.setImageResource(2131232778);
          return;
        } 
        if ("2".equals(paramString)) {
          paramImageView.setImageResource(2131232771);
          return;
        } 
        if ("3".equals(paramString)) {
          paramImageView.setImageResource(2131232797);
          return;
        } 
        paramImageView.setImageResource(2131232771);
      } 
    } 
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, TextView paramTextView) {
    if (paramTextView == null)
      return; 
    if (TextUtils.isEmpty(paramString1)) {
      paramTextView.setText("");
      return;
    } 
    if (!paramString1.toLowerCase().contains(paramString2.toLowerCase())) {
      paramTextView.setText(paramString1);
      return;
    } 
    SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(paramString1);
    paramString1 = paramString1.toLowerCase();
    paramString2 = paramString2.toLowerCase();
    int i = paramString2.length();
    int j = paramString1.indexOf(paramString2);
    if (j >= 0)
      spannableStringBuilder.setSpan(new ForegroundColorSpan(ContextCompat.getColor(paramContext, 2131100716)), j, i + j, 33); 
    paramTextView.setText((CharSequence)spannableStringBuilder);
  }
  
  public static void a(ImageView paramImageView, int paramInt) {
    if (paramInt != 2) {
      if (paramInt != 3) {
        if (paramInt != 4) {
          if (paramInt != 5) {
            if (paramInt != 7) {
              paramInt = 0;
            } else {
              paramInt = 2131234376;
            } 
          } else {
            paramInt = 2131234377;
          } 
        } else {
          paramInt = 2131234378;
        } 
      } else {
        paramInt = 2131234375;
      } 
    } else {
      paramInt = 2131234374;
    } 
    if (paramInt == 0) {
      paramImageView.setVisibility(8);
      return;
    } 
    paramImageView.setImageResource(paramInt);
    paramImageView.setVisibility(0);
  }
  
  public static void a(ImageView paramImageView, int paramInt1, int paramInt2) {
    a(paramImageView, paramInt1, paramInt2, 8);
  }
  
  public static void a(ImageView paramImageView, int paramInt1, int paramInt2, int paramInt3) {
    if (paramImageView != null) {
      paramInt1 = a(paramInt1, paramInt2);
      if (paramInt1 == 0) {
        paramImageView.setVisibility(paramInt3);
        return;
      } 
      paramImageView.setImageResource(paramInt1);
      paramImageView.setVisibility(0);
    } 
  }
  
  public static void a(ImageView paramImageView, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    a(paramImageView, paramInt1, paramInt2, 4, paramInt3, paramInt4);
  }
  
  public static void a(ImageView paramImageView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5) {
    if (paramImageView != null) {
      paramInt1 = a(paramInt1, paramInt2);
      if (paramInt1 == 0) {
        paramImageView.setVisibility(paramInt3);
        return;
      } 
      ImageLoader.a(null, paramInt1).a(paramInt4, paramInt5).a(paramImageView);
      paramImageView.setVisibility(0);
    } 
  }
  
  public static void a(ImageView paramImageView, UserBasicModel paramUserBasicModel) {
    boolean bool;
    if (paramImageView == null)
      return; 
    if (paramUserBasicModel.vip_exp_lvl <= 0) {
      paramImageView.setVisibility(8);
      return;
    } 
    if (paramUserBasicModel.expire_type > 0) {
      bool = paramUserBasicModel.expire_type;
    } else {
      bool = paramUserBasicModel.vip_grade;
    } 
    if (paramUserBasicModel.is_hide_vip_look == 1)
      bool = false; 
    String str2 = "_small_label_";
    if (bool != true) {
      if (bool != 2) {
        paramImageView.setVisibility(8);
      } else {
        paramImageView.setVisibility(0);
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append("bluedx");
        stringBuilder1.append("_small_label_");
        String str = stringBuilder1.toString();
      } 
    } else {
      paramImageView.setVisibility(0);
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append("vip");
      stringBuilder1.append("_small_label_");
      str2 = stringBuilder1.toString();
    } 
    String str3 = str2;
    if (paramUserBasicModel.is_vip_annual == 1) {
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append(str2);
      stringBuilder1.append("year_");
      str3 = stringBuilder1.toString();
    } 
    paramUserBasicModel.vip_exp_lvl = Math.min(paramUserBasicModel.vip_exp_lvl, 8);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(str3);
    stringBuilder.append(paramUserBasicModel.vip_exp_lvl);
    str3 = stringBuilder.toString();
    String str1 = str3;
    if (paramUserBasicModel.expire_type > 0) {
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append(str3);
      stringBuilder1.append("_expired");
      str1 = stringBuilder1.toString();
    } 
    paramImageView.setImageResource(AppInfo.d().getResources().getIdentifier(str1, "drawable", AppInfo.d().getPackageName()));
    paramImageView.setAdjustViewBounds(true);
  }
  
  public static void a(ImageView paramImageView, MineEntryInfo.VipInfo paramVipInfo) {
    if (paramVipInfo != null) {
      UserBasicModel userBasicModel = new UserBasicModel();
      userBasicModel.expire_type = paramVipInfo.expire_type;
      userBasicModel.vip_grade = paramVipInfo.vip_grade;
      userBasicModel.is_vip_annual = paramVipInfo.is_vip_annual;
      userBasicModel.vip_exp_lvl = paramVipInfo.vip_exp_lvl;
      a(paramImageView, userBasicModel);
    } 
  }
  
  public static void a(Runnable paramRunnable, String paramString) {
    if (!UserInfo.a().j()) {
      paramRunnable.run();
      return;
    } 
    LoginRegisterHttpUtils.a(new BluedUIHttpResponse<BluedEntityA<AppConfigModel>>(paramRunnable, paramString) {
          protected void a(BluedEntityA<AppConfigModel> param1BluedEntityA) {
            if (this.a != null) {
              UserRelationshipUtils.a(this.b, new int[0]);
              this.a.run();
            } 
          }
          
          public void onFailure(Throwable param1Throwable) {
            super.onFailure(param1Throwable);
          }
          
          public void onFailure(Throwable param1Throwable, int param1Int, String param1String) {
            super.onFailure(param1Throwable, param1Int, param1String);
          }
        }null, new int[] { 1 });
  }
  
  public static void a(String paramString, TextView paramTextView, ImageView paramImageView) {
    if (!StringUtils.e(paramString) && paramTextView != null && paramImageView != null) {
      if ("0".equals(paramString)) {
        paramTextView.setText(2131755359);
        paramImageView.setImageResource(2131231199);
        return;
      } 
      if ("1".equals(paramString)) {
        paramTextView.setText(2131756545);
        paramImageView.setImageResource(2131231200);
        return;
      } 
      if ("2".equals(paramString)) {
        paramTextView.setText(2131755437);
        paramImageView.setImageResource(2131231200);
        return;
      } 
      if ("3".equals(paramString)) {
        paramTextView.setText(2131756538);
        paramImageView.setImageResource(2131232777);
      } 
    } 
  }
  
  public static void a(String paramString, int... paramVarArgs) {
    Runnable runnable = new Runnable(paramString, paramVarArgs) {
        public void run() {
          // Byte code:
          //   0: invokestatic b : ()V
          //   3: invokestatic d : ()Landroid/content/Context;
          //   6: invokestatic c : (Landroid/content/Context;)V
          //   9: aload_0
          //   10: getfield a : Ljava/lang/String;
          //   13: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
          //   16: istore_2
          //   17: iconst_0
          //   18: istore_3
          //   19: iload_2
          //   20: ifne -> 60
          //   23: aload_0
          //   24: getfield a : Ljava/lang/String;
          //   27: ldc 'switch_Acc'
          //   29: invokevirtual equals : (Ljava/lang/Object;)Z
          //   32: ifne -> 47
          //   35: aload_0
          //   36: getfield a : Ljava/lang/String;
          //   39: ldc 'bind_Acc'
          //   41: invokevirtual equals : (Ljava/lang/Object;)Z
          //   44: ifeq -> 60
          //   47: invokestatic a : ()Lcom/soft/blued/push/PushManager;
          //   50: invokevirtual c : ()V
          //   53: iconst_0
          //   54: putstatic com/soft/blued/BluedConstant.b : Z
          //   57: goto -> 107
          //   60: invokestatic a : ()Lcom/soft/blued/user/UserInfo;
          //   63: invokevirtual j : ()Z
          //   66: ifeq -> 107
          //   69: new com/soft/blued/utils/UserRelationshipUtils$1$1
          //   72: dup
          //   73: aload_0
          //   74: invokespecial <init> : (Lcom/soft/blued/utils/UserRelationshipUtils$1;)V
          //   77: astore #4
          //   79: aload_0
          //   80: getfield b : [I
          //   83: astore #5
          //   85: aload #5
          //   87: arraylength
          //   88: ifle -> 99
          //   91: aload #5
          //   93: iconst_0
          //   94: iaload
          //   95: istore_1
          //   96: goto -> 101
          //   99: iconst_0
          //   100: istore_1
          //   101: aload #4
          //   103: iload_1
          //   104: invokestatic a : (Ljava/lang/Runnable;I)V
          //   107: invokestatic a : ()Lcom/soft/blued/ui/msg/customview/GlobalTaskFloatManager;
          //   110: iconst_0
          //   111: invokevirtual a : (Z)V
          //   114: invokestatic e : ()Lcom/blued/android/module/yy_china/trtc_audio/manager/AudioChannelManager;
          //   117: ldc ''
          //   119: invokevirtual a : (Ljava/lang/String;)V
          //   122: invokestatic a : ()Lcom/soft/blued/user/UserInfo;
          //   125: astore #4
          //   127: iload_3
          //   128: istore_2
          //   129: aload_0
          //   130: getfield a : Ljava/lang/String;
          //   133: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
          //   136: ifne -> 167
          //   139: aload_0
          //   140: getfield a : Ljava/lang/String;
          //   143: ldc 'switch_Acc'
          //   145: invokevirtual equals : (Ljava/lang/Object;)Z
          //   148: ifne -> 165
          //   151: iload_3
          //   152: istore_2
          //   153: aload_0
          //   154: getfield a : Ljava/lang/String;
          //   157: ldc 'bind_Acc'
          //   159: invokevirtual equals : (Ljava/lang/Object;)Z
          //   162: ifeq -> 167
          //   165: iconst_1
          //   166: istore_2
          //   167: aload #4
          //   169: iload_2
          //   170: invokevirtual a : (Z)V
          //   173: invokestatic getInstance : ()Lcom/blued/android/chat/BluedChat;
          //   176: invokestatic d : ()Landroid/content/Context;
          //   179: invokevirtual stopIMService : (Landroid/content/Context;)V
          //   182: aload_0
          //   183: getfield a : Ljava/lang/String;
          //   186: invokestatic e : (Ljava/lang/String;)Z
          //   189: ifne -> 226
          //   192: aload_0
          //   193: getfield a : Ljava/lang/String;
          //   196: ldc 'switch_Acc'
          //   198: invokevirtual equals : (Ljava/lang/Object;)Z
          //   201: ifne -> 226
          //   204: aload_0
          //   205: getfield a : Ljava/lang/String;
          //   208: ldc 'bind_Acc'
          //   210: invokevirtual equals : (Ljava/lang/Object;)Z
          //   213: ifne -> 226
          //   216: aload_0
          //   217: getfield a : Ljava/lang/String;
          //   220: invokestatic Z : (Ljava/lang/String;)V
          //   223: goto -> 231
          //   226: ldc ''
          //   228: invokestatic Z : (Ljava/lang/String;)V
          //   231: invokestatic d : ()V
          //   234: invokestatic d : ()Landroid/content/Context;
          //   237: invokestatic g : ()Ljava/lang/String;
          //   240: aconst_null
          //   241: invokestatic c : (Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V
          //   244: invokestatic isAppOnForeground : ()Z
          //   247: ifne -> 254
          //   250: iconst_1
          //   251: putstatic com/soft/blued/constant/CommonConstants.c : Z
          //   254: aload_0
          //   255: getfield a : Ljava/lang/String;
          //   258: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
          //   261: ifne -> 282
          //   264: aload_0
          //   265: getfield a : Ljava/lang/String;
          //   268: ldc 'bind_Acc'
          //   270: invokevirtual equals : (Ljava/lang/Object;)Z
          //   273: ifeq -> 282
          //   276: invokestatic h : ()V
          //   279: goto -> 313
          //   282: aload_0
          //   283: getfield a : Ljava/lang/String;
          //   286: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
          //   289: ifne -> 307
          //   292: aload_0
          //   293: getfield a : Ljava/lang/String;
          //   296: ldc 'switch_Acc'
          //   298: invokevirtual equals : (Ljava/lang/Object;)Z
          //   301: ifeq -> 307
          //   304: goto -> 313
          //   307: invokestatic d : ()Landroid/content/Context;
          //   310: invokestatic a : (Landroid/content/Context;)V
          //   313: invokestatic a : ()Lcom/blued/android/module/live_china/manager/LiveFloatManager;
          //   316: invokevirtual m : ()V
          //   319: invokestatic a : ()Lcom/soft/blued/ui/find/manager/FlashZegoApiManager;
          //   322: invokevirtual c : ()V
          //   325: invokestatic as : ()V
          //   328: iconst_1
          //   329: invokestatic J : (Z)V
          //   332: iconst_1
          //   333: invokestatic K : (Z)V
          //   336: invokestatic a : ()Lcom/soft/blued/ui/find/manager/MapFindManager;
          //   339: aconst_null
          //   340: invokevirtual a : (Lcom/soft/blued/ui/find/manager/MapFindManager$MapFindBean;)V
          //   343: invokestatic a : ()Lcom/soft/blued/ui/user/manager/VipBubbleManager;
          //   346: invokevirtual e : ()V
          //   349: invokestatic a : ()Lcom/blued/android/config/FlexDebugSevConfig;
          //   352: invokevirtual f : ()V
          //   355: return
        }
      };
    if (AppMethods.b()) {
      runnable.run();
      return;
    } 
    AppInfo.n().post(runnable);
  }
  
  public static boolean a(String paramString) {
    if ("4".equals(paramString) || "12".equals(paramString)) {
      AppMethods.d(2131759095);
      return true;
    } 
    if ("8".equals(paramString)) {
      AppMethods.d(2131755415);
      return true;
    } 
    return false;
  }
  
  private static int b(int paramInt1, int paramInt2) {
    return (paramInt1 != 4) ? ((paramInt1 != 5) ? ((paramInt1 != 7) ? 0 : 2131234382) : ((paramInt2 == 4) ? 2131234383 : 2131234380)) : 2131234384;
  }
  
  public static int b(Context paramContext, String paramString) {
    int j;
    String[] arrayOfString = paramContext.getResources().getStringArray(2130903104);
    byte b = 0;
    int i = 0;
    while (true) {
      j = b;
      if (i < arrayOfString.length) {
        if (arrayOfString[i].equals(paramString)) {
          j = i;
          break;
        } 
        i++;
        continue;
      } 
      break;
    } 
    return j + 1;
  }
  
  public static int b(String paramString) {
    String[] arrayOfString = AppInfo.d().getResources().getStringArray(2130903100);
    for (int i = 0; i < arrayOfString.length; i++) {
      if (paramString.equals(arrayOfString[i]))
        return i - 1; 
    } 
    return -1;
  }
  
  public static String b(Context paramContext, TextView paramTextView, String paramString) {
    String str;
    if (!TextUtils.isEmpty(paramString)) {
      if ("0".equals(paramString)) {
        str = paramContext.getString(2131758632);
      } else if ("1".equals(paramString)) {
        str = str.getString(2131758636);
      } else if ("0.5".equals(paramString)) {
        str = str.getString(2131758634);
      } else if ("-1".equals(paramString)) {
        str = str.getString(2131758638);
      } else if ("0.75".equals(paramString)) {
        str = str.getString(2131758635);
      } else if ("0.25".equals(paramString)) {
        str = str.getString(2131758633);
      } else {
        str = str.getString(2131758638);
      } 
    } else {
      str = " - ";
    } 
    if (paramTextView != null)
      paramTextView.setText(str); 
    return str;
  }
  
  public static void b() {
    if (UserInfo.a().j()) {
      int i = UserInfo.a().e();
      if (i != 0 && i != 1) {
        if (i != 2)
          return; 
        l();
        return;
      } 
      k();
    } 
  }
  
  public static void b(ImageView paramImageView, int paramInt1, int paramInt2, int paramInt3) {
    if (paramImageView != null) {
      paramInt1 = b(paramInt1, paramInt2);
      if (paramInt1 == 0) {
        paramImageView.setVisibility(paramInt3);
        return;
      } 
      paramImageView.setImageResource(paramInt1);
      paramImageView.setVisibility(0);
    } 
  }
  
  public static void b(ImageView paramImageView, UserBasicModel paramUserBasicModel) {
    a(paramImageView, paramUserBasicModel);
  }
  
  private static void b(Runnable paramRunnable, int paramInt) {
    LoginRegisterHttpUtils.a(new BluedUIHttpResponse<BluedEntityA<AppConfigModel>>(paramRunnable) {
          protected void a(BluedEntityA<AppConfigModel> param1BluedEntityA) {
            Runnable runnable = this.a;
            if (runnable != null)
              runnable.run(); 
          }
          
          public void onFailure(Throwable param1Throwable) {}
          
          public void onFailure(Throwable param1Throwable, int param1Int, String param1String) {
            super.onFailure(param1Throwable, param1Int, param1String);
          }
        }null, new int[] { paramInt });
  }
  
  public static int c(String paramString) {
    boolean bool = StringUtils.e(paramString);
    int i = 0;
    if (!bool) {
      if (paramString.contains("'") && paramString.contains("\"")) {
        String str = paramString.split("'")[0];
        double d = StringUtils.a(paramString.split("'")[1].replace("\"", ""), 0.0D);
        return (int)Math.round((StringUtils.a(str, 0.0D) + d / 12.0D) * 30.48D);
      } 
      i = StringUtils.a(paramString, 0);
    } 
    return i;
  }
  
  public static ArrayMap<String, String> c() {
    String[] arrayOfString1 = AppInfo.d().getResources().getStringArray(2130903048);
    String[] arrayOfString2 = AppInfo.d().getResources().getStringArray(2130903047);
    for (int i = 0; i < arrayOfString1.length; i++)
      e.put(arrayOfString1[i], arrayOfString2[i]); 
    return e;
  }
  
  public static String c(Context paramContext, String paramString) {
    return a(paramContext, (TextView)null, paramString);
  }
  
  public static int d(String paramString) {
    if (!StringUtils.e(paramString)) {
      String str = paramString;
      if (paramString.contains("lbs"))
        str = paramString.replace("lbs", ""); 
      return (int)Math.round(StringUtils.a(str, 0.0D) / 2.2D);
    } 
    return 0;
  }
  
  public static ArrayMap<String, String> d() {
    String[] arrayOfString1 = AppInfo.d().getResources().getStringArray(2130903047);
    String[] arrayOfString2 = AppInfo.d().getResources().getStringArray(2130903048);
    for (int i = 0; i < arrayOfString1.length; i++)
      f.put(arrayOfString1[i], arrayOfString2[i]); 
    return f;
  }
  
  public static String d(Context paramContext, String paramString) {
    return b(paramContext, null, paramString);
  }
  
  public static ArrayMap<String, String> e() {
    String[] arrayOfString1 = AppInfo.d().getResources().getStringArray(2130903061);
    String[] arrayOfString2 = AppInfo.d().getResources().getStringArray(2130903060);
    for (int i = 0; i < arrayOfString1.length; i++)
      i.put(arrayOfString1[i], arrayOfString2[i]); 
    return i;
  }
  
  public static ArrayMap<String, String> f() {
    String[] arrayOfString1 = AppInfo.d().getResources().getStringArray(2130903059);
    String[] arrayOfString2 = AppInfo.d().getResources().getStringArray(2130903058);
    for (int i = 0; i < arrayOfString1.length; i++)
      j.put(arrayOfString1[i], arrayOfString2[i]); 
    return j;
  }
  
  public static ArrayMap<String, String> g() {
    String[] arrayOfString1 = AppInfo.d().getResources().getStringArray(2130903103);
    String[] arrayOfString2 = AppInfo.d().getResources().getStringArray(2130903102);
    for (int i = 0; i < arrayOfString1.length; i++)
      k.put(arrayOfString1[i], arrayOfString2[i]); 
    return k;
  }
  
  private static void j() {
    for (Activity activity : ActivityStack.a().b()) {
      if (activity.getClass() == LoginV1ForThreeActivity.class || activity.getClass() == SignInActivity.class || activity.getClass() == SwitchAccountActivity.class)
        continue; 
      activity.finish();
    } 
  }
  
  private static void k() {
    String str1;
    String str2 = UserInfo.a().b();
    int i = UserInfo.a().e();
    if (i == 0) {
      str1 = "email";
    } else if (i == 1) {
      str1 = "mobile";
    } else {
      str1 = null;
    } 
    Logger.b(m, new Object[] { "==底层=自主登录==for===", str1 });
    LoginRegisterHttpUtils.a(new BluedUIHttpResponse<BluedEntity<BluedLoginResult, AVConfigExtra>>(i, str2) {
          String a = "";
          
          public void onFailure(Throwable param1Throwable, int param1Int, String param1String) {
            super.onFailure(param1Throwable, param1Int, param1String);
            try {
              if (!StringUtils.e(param1String)) {
                Pair pair;
                StringBuilder stringBuilder;
                Logger.b(UserRelationshipUtils.i(), new Object[] { "===error", "responseCode:", Integer.valueOf(param1Int), ",responseJson:", param1String });
                if (param1Int == 403) {
                  pair = BluedHttpUtils.a(param1Throwable, param1Int, param1String);
                  switch (((Integer)pair.first).intValue()) {
                    case 4036501:
                      UserRelationshipUtils.a(AppInfo.d().getResources().getString(2131756317), new int[0]);
                      return;
                    case 403600:
                    case 403800:
                    case 403801:
                      stringBuilder = new StringBuilder();
                      stringBuilder.append(AppInfo.d().getResources().getString(2131755217));
                      stringBuilder.append("-");
                      stringBuilder.append(pair.first);
                      UserRelationshipUtils.a(stringBuilder.toString(), new int[0]);
                      return;
                  } 
                } else {
                  if (param1Int != 500) {
                    BluedHttpUtils.b((Throwable)pair, param1Int, (String)stringBuilder);
                    return;
                  } 
                  return;
                } 
              } else {
                return;
              } 
            } catch (Exception exception) {
              exception.printStackTrace();
              return;
            } 
          }
          
          public void onUIUpdate(BluedEntity<BluedLoginResult, AVConfigExtra> param1BluedEntity) {
            if (param1BluedEntity != null && param1BluedEntity.data != null && param1BluedEntity.data.size() > 0) {
              if (param1BluedEntity.extra != null)
                AVConfig.a().a(((AVConfigExtra)param1BluedEntity.extra).is_kids, false); 
              PushManager.a().d();
              int i = this.b;
              if (i != 0 && i == 1) {
                i = 1;
              } else {
                i = 0;
              } 
              String str = ((BluedLoginResult)param1BluedEntity.data.get(0)).get_();
              try {
                str = AesCrypto.c(str);
                Logger.b(UserRelationshipUtils.i(), new Object[] { "解密：deData===", str });
                BluedLoginResult bluedLoginResult = (BluedLoginResult)AppInfo.f().fromJson(str, BluedLoginResult.class);
                UserInfo.a().a(this.c, i, this.a, bluedLoginResult, new String[0]);
                String str1 = UserRelationshipUtils.i();
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("IM=token==UserRenew=");
                stringBuilder.append(bluedLoginResult.getAccess_token());
                Logger.c(str1, new Object[] { stringBuilder.toString() });
                LoginRegisterTools.a();
                return;
              } catch (Exception exception) {
                return;
              } 
            } 
          }
          
          public BluedEntity<BluedLoginResult, AVConfigExtra> parseData(String param1String) {
            this.a = param1String;
            return super.parseData(param1String);
          }
        }str1, LoginRegisterTools.g(UserInfo.a().d()), (UserInfo.a().i()).uid);
  }
  
  private static void l() {
    String str = UserInfo.a().b();
    if (StringUtils.e(str))
      return; 
    LoginRegisterHttpUtils.a(new BluedUIHttpResponse<BluedEntity<BluedLoginResult, AVConfigExtra>>(str) {
          String a = "";
          
          public void onFailure(Throwable param1Throwable, int param1Int, String param1String) {
            super.onFailure(param1Throwable, param1Int, param1String);
            try {
              if (!StringUtils.e(param1String)) {
                Pair pair;
                StringBuilder stringBuilder;
                Logger.b(UserRelationshipUtils.i(), new Object[] { "===error", "responseCode:", Integer.valueOf(param1Int), ",responseJson:", param1String });
                if (param1Int == 403) {
                  pair = BluedHttpUtils.a(param1Throwable, param1Int, param1String);
                  switch (((Integer)pair.first).intValue()) {
                    case 4036501:
                      UserRelationshipUtils.a(AppInfo.d().getResources().getString(2131756317), new int[0]);
                      return;
                    case 4036301:
                    case 4036302:
                      stringBuilder = new StringBuilder();
                      stringBuilder.append(AppInfo.d().getResources().getString(2131755217));
                      stringBuilder.append(" -Error code: ");
                      stringBuilder.append(pair.first);
                      UserRelationshipUtils.a(stringBuilder.toString(), new int[0]);
                      return;
                    case 403600:
                    case 403800:
                    case 403801:
                    case 4036303:
                      stringBuilder = new StringBuilder();
                      stringBuilder.append(AppInfo.d().getResources().getString(2131755217));
                      stringBuilder.append("-Error code: ");
                      stringBuilder.append(pair.first);
                      UserRelationshipUtils.a(stringBuilder.toString(), new int[0]);
                      return;
                  } 
                } else {
                  if (param1Int != 500) {
                    BluedHttpUtils.b((Throwable)pair, param1Int, (String)stringBuilder);
                    return;
                  } 
                  return;
                } 
              } else {
                return;
              } 
            } catch (Exception exception) {
              exception.printStackTrace();
              return;
            } 
          }
          
          public void onUIUpdate(BluedEntity<BluedLoginResult, AVConfigExtra> param1BluedEntity) {
            if (param1BluedEntity != null && param1BluedEntity.data != null && param1BluedEntity.data.size() > 0) {
              if (param1BluedEntity.extra != null)
                AVConfig.a().a(((AVConfigExtra)param1BluedEntity.extra).is_kids, false); 
              String str = ((BluedLoginResult)param1BluedEntity.data.get(0)).get_();
              try {
                str = AesCrypto.c(str);
                BluedLoginResult bluedLoginResult = (BluedLoginResult)AppInfo.f().fromJson(str, BluedLoginResult.class);
                UserInfo.a().a(this.b, 2, this.a, bluedLoginResult, new String[0]);
                return;
              } catch (Exception exception) {
                return;
              } 
            } 
          }
          
          public BluedEntity<BluedLoginResult, AVConfigExtra> parseData(String param1String) {
            this.a = param1String;
            return super.parseData(param1String);
          }
        }"weixin", LoginRegisterTools.g(UserInfo.a().d()), (UserInfo.a().i()).uid);
  }
  
  public static interface IAddOrRemoveAttentionDone {
    void a();
    
    void a(String param1String);
    
    void b();
    
    void b(String param1String);
    
    void c();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\utils\UserRelationshipUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */