package com.soft.blued.ui.user.utils;

import android.content.Context;
import android.view.View;
import android.widget.PopupWindow;
import com.blued.das.vip.VipProtos;
import com.soft.blued.constant.ADConstants;
import com.soft.blued.http.FindHttpUtils;
import com.soft.blued.log.trackUtils.EventTrackVIP;
import com.soft.blued.ui.feed.model.BluedADExtra;
import com.soft.blued.ui.user.presenter.PayUtils;

public class ADClosePopOptionsUtils {
  public static String a(ADConstants.AD_POSITION paramAD_POSITION) {
    switch (null.a[paramAD_POSITION.ordinal()]) {
      default:
        return "";
      case 8:
        return "no_ad_home_page_layer";
      case 7:
        return "no_ad_home_page_banner1";
      case 6:
        return "no_ad_visit_page_banner";
      case 5:
        return "no_ad_visit_page";
      case 4:
        return "no_ad_personal_page";
      case 3:
        return "no_ad_home_page";
      case 1:
      case 2:
        break;
    } 
    return "no_ad_home_page_banner2";
  }
  
  public static void a(Context paramContext, BluedADExtra paramBluedADExtra, View paramView, ADConstants.AD_POSITION paramAD_POSITION, ADRemovedListner paramADRemovedListner) {
    // Byte code:
    //   0: aload_1
    //   1: ifnull -> 386
    //   4: aload_1
    //   5: getfield is_show_adm_icon : I
    //   8: iconst_1
    //   9: if_icmpne -> 386
    //   12: invokestatic a : ()Lcom/soft/blued/user/UserInfo;
    //   15: invokevirtual i : ()Lcom/soft/blued/ui/login_register/model/BluedLoginResult;
    //   18: getfield vip_grade : I
    //   21: iconst_2
    //   22: if_icmpne -> 28
    //   25: goto -> 386
    //   28: invokestatic b : ()Lcom/soft/blued/user/BluedConfig;
    //   31: invokevirtual E : ()I
    //   34: istore #5
    //   36: iload #5
    //   38: iconst_1
    //   39: if_icmpeq -> 51
    //   42: iload #5
    //   44: iconst_2
    //   45: if_icmpeq -> 60
    //   48: goto -> 366
    //   51: invokestatic df : ()Z
    //   54: ifne -> 366
    //   57: invokestatic dg : ()V
    //   60: aload_0
    //   61: invokestatic from : (Landroid/content/Context;)Landroid/view/LayoutInflater;
    //   64: ldc 2131493732
    //   66: aconst_null
    //   67: invokevirtual inflate : (ILandroid/view/ViewGroup;)Landroid/view/View;
    //   70: astore #8
    //   72: aload #8
    //   74: ldc 2131298999
    //   76: invokevirtual findViewById : (I)Landroid/view/View;
    //   79: checkcast android/widget/LinearLayout
    //   82: astore #9
    //   84: aload #8
    //   86: ldc 2131301145
    //   88: invokevirtual findViewById : (I)Landroid/view/View;
    //   91: checkcast android/widget/TextView
    //   94: astore #10
    //   96: aload #8
    //   98: ldc 2131300559
    //   100: invokevirtual findViewById : (I)Landroid/view/View;
    //   103: checkcast com/blued/android/framework/view/shape/ShapeTextView
    //   106: ldc 2131100881
    //   108: invokestatic b : (Lcom/blued/android/framework/view/shape/ShapeHelper$ShapeView;I)V
    //   111: new android/widget/PopupWindow
    //   114: dup
    //   115: aload #8
    //   117: bipush #-2
    //   119: bipush #-2
    //   121: iconst_1
    //   122: invokespecial <init> : (Landroid/view/View;IIZ)V
    //   125: astore #8
    //   127: aload #8
    //   129: iconst_1
    //   130: invokevirtual setTouchable : (Z)V
    //   133: aload #8
    //   135: aload_0
    //   136: invokevirtual getResources : ()Landroid/content/res/Resources;
    //   139: ldc 17170445
    //   141: invokevirtual getDrawable : (I)Landroid/graphics/drawable/Drawable;
    //   144: invokevirtual setBackgroundDrawable : (Landroid/graphics/drawable/Drawable;)V
    //   147: aload #10
    //   149: new com/soft/blued/ui/user/utils/-$$Lambda$ADClosePopOptionsUtils$_T-qxabnzkpujs-Z1-Lh4mhnpiM
    //   152: dup
    //   153: aload_3
    //   154: aload_1
    //   155: aload #4
    //   157: aload #8
    //   159: invokespecial <init> : (Lcom/soft/blued/constant/ADConstants$AD_POSITION;Lcom/soft/blued/ui/feed/model/BluedADExtra;Lcom/soft/blued/ui/user/utils/ADClosePopOptionsUtils$ADRemovedListner;Landroid/widget/PopupWindow;)V
    //   162: invokevirtual setOnClickListener : (Landroid/view/View$OnClickListener;)V
    //   165: aload #9
    //   167: new com/soft/blued/ui/user/utils/-$$Lambda$ADClosePopOptionsUtils$AeXzQOMSAEim9T8CsWxPPJmppIc
    //   170: dup
    //   171: aload_3
    //   172: aload_1
    //   173: aload_0
    //   174: aload #4
    //   176: aload #8
    //   178: invokespecial <init> : (Lcom/soft/blued/constant/ADConstants$AD_POSITION;Lcom/soft/blued/ui/feed/model/BluedADExtra;Landroid/content/Context;Lcom/soft/blued/ui/user/utils/ADClosePopOptionsUtils$ADRemovedListner;Landroid/widget/PopupWindow;)V
    //   181: invokevirtual setOnClickListener : (Landroid/view/View$OnClickListener;)V
    //   184: iconst_2
    //   185: newarray int
    //   187: astore #4
    //   189: aload_2
    //   190: aload #4
    //   192: invokevirtual getLocationOnScreen : ([I)V
    //   195: aload_0
    //   196: ldc 100.0
    //   198: invokestatic a : (Landroid/content/Context;F)I
    //   201: istore #5
    //   203: getstatic com/soft/blued/ui/user/utils/ADClosePopOptionsUtils$1.a : [I
    //   206: aload_3
    //   207: invokevirtual ordinal : ()I
    //   210: iaload
    //   211: istore #6
    //   213: iload #6
    //   215: iconst_1
    //   216: if_icmpeq -> 234
    //   219: iload #6
    //   221: iconst_2
    //   222: if_icmpeq -> 234
    //   225: iload #6
    //   227: iconst_3
    //   228: if_icmpeq -> 234
    //   231: goto -> 245
    //   234: iload #5
    //   236: aload_0
    //   237: ldc 70.0
    //   239: invokestatic a : (Landroid/content/Context;F)I
    //   242: iadd
    //   243: istore #5
    //   245: getstatic com/blued/android/core/AppInfo.m : I
    //   248: istore #7
    //   250: getstatic com/blued/android/core/AppInfo.l : I
    //   253: aload #4
    //   255: iconst_0
    //   256: iaload
    //   257: isub
    //   258: aload_2
    //   259: invokevirtual getWidth : ()I
    //   262: isub
    //   263: istore #6
    //   265: new java/lang/StringBuilder
    //   268: dup
    //   269: invokespecial <init> : ()V
    //   272: astore #9
    //   274: aload #9
    //   276: ldc 'viewOffX:'
    //   278: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   281: pop
    //   282: aload #9
    //   284: iload #6
    //   286: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   289: pop
    //   290: ldc 'showADOptions'
    //   292: aload #9
    //   294: invokevirtual toString : ()Ljava/lang/String;
    //   297: invokestatic a : (Ljava/lang/String;Ljava/lang/Object;)V
    //   300: aload #4
    //   302: iconst_1
    //   303: iaload
    //   304: iload #7
    //   306: iload #5
    //   308: isub
    //   309: if_icmpgt -> 326
    //   312: aload #4
    //   314: iconst_1
    //   315: iaload
    //   316: aload_2
    //   317: invokevirtual getHeight : ()I
    //   320: iadd
    //   321: istore #5
    //   323: goto -> 339
    //   326: aload #4
    //   328: iconst_1
    //   329: iaload
    //   330: aload_0
    //   331: ldc 80.0
    //   333: invokestatic a : (Landroid/content/Context;F)I
    //   336: isub
    //   337: istore #5
    //   339: aload #8
    //   341: aload_2
    //   342: bipush #53
    //   344: iload #6
    //   346: iload #5
    //   348: invokevirtual showAtLocation : (Landroid/view/View;III)V
    //   351: getstatic com/blued/das/vip/VipProtos$Event.NO_AD_PROPAGATE_SHOW : Lcom/blued/das/vip/VipProtos$Event;
    //   354: aload_3
    //   355: invokestatic b : (Lcom/soft/blued/constant/ADConstants$AD_POSITION;)Lcom/blued/das/vip/VipProtos$AdPage;
    //   358: aload_1
    //   359: getfield adms_type : Ljava/lang/String;
    //   362: invokestatic a : (Lcom/blued/das/vip/VipProtos$Event;Lcom/blued/das/vip/VipProtos$AdPage;Ljava/lang/String;)V
    //   365: return
    //   366: aload #4
    //   368: ifnull -> 385
    //   371: aload #4
    //   373: invokeinterface onRemoved : ()V
    //   378: aload_1
    //   379: getfield hidden_url : [Ljava/lang/String;
    //   382: invokestatic a : ([Ljava/lang/String;)V
    //   385: return
    //   386: aload #4
    //   388: ifnull -> 405
    //   391: aload #4
    //   393: invokeinterface onRemoved : ()V
    //   398: aload_1
    //   399: getfield hidden_url : [Ljava/lang/String;
    //   402: invokestatic a : ([Ljava/lang/String;)V
    //   405: return
  }
  
  public static VipProtos.AdPage b(ADConstants.AD_POSITION paramAD_POSITION) {
    VipProtos.AdPage adPage = VipProtos.AdPage.UNKNOWN_AD_PAGE;
    switch (null.a[paramAD_POSITION.ordinal()]) {
      default:
        return adPage;
      case 8:
        return VipProtos.AdPage.AD_HOME_POP;
      case 7:
        return VipProtos.AdPage.AD_HOME_BANNER1;
      case 6:
        return VipProtos.AdPage.AD_BANNER;
      case 5:
        return VipProtos.AdPage.AD_VISIT;
      case 4:
        return VipProtos.AdPage.AD_PERSONAL;
      case 3:
        return VipProtos.AdPage.AD_HOME;
      case 1:
      case 2:
        break;
    } 
    return VipProtos.AdPage.AD_HOME_BANNER2;
  }
  
  public static interface ADRemovedListner {
    void onRemoved();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\u\\use\\utils\ADClosePopOptionsUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */