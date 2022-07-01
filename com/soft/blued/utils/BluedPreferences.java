package com.soft.blued.utils;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProviders;
import com.blued.android.core.AppInfo;
import com.blued.android.core.BlueAppLocal;
import com.blued.android.core.utils.skin.BluedSkinPreferences;
import com.blued.android.statistics.BluedStatistics;
import com.soft.blued.ui.feed.model.BluedADExtra;
import com.soft.blued.ui.feed.model.PreferenceAD;
import com.soft.blued.ui.find.observer.NearbyViewModel;
import com.soft.blued.ui.home.HomeActivity;
import com.soft.blued.user.BluedConfig;
import com.soft.blued.user.UserInfo;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class BluedPreferences {
  public static String A = "filter722";
  
  public static String B = "invisible";
  
  public static String C = "typechoice";
  
  public static String D = "modelchoice1";
  
  public static String E = "age_choice";
  
  public static String F = "height_choice";
  
  public static String G = "height_choice_in";
  
  public static String H = "weight_choice";
  
  public static String I = "weight_choice_lbs";
  
  public static String J = "avatarchoice";
  
  public static String K = "AIPHOTOCHOICE";
  
  public static String L = "verifychoice";
  
  public static String M = "RELATIONCHOICE";
  
  public static String N = "racechoice";
  
  public static String O = "TAGCHOICE";
  
  public static String P = "TAGCHOICETEXT_HEIS";
  
  public static String Q = "TAGCHOICETEXT_LOOKFOR";
  
  public static String R = "VIP_ONLY_CHOICE";
  
  public static String S = "DISTANCE_RANGE";
  
  public static String T = "TIME_RANGE";
  
  public static String U = "INVISIBLE_DISTANCE_RANGE";
  
  public static String V = "receivemessage";
  
  public static String W = "personalized";
  
  public static String X = "chatDefaultBgUri";
  
  public static String Y = "chatvoice";
  
  public static String Z = "chatshake";
  
  public static SharedPreferences a;
  
  public static String aA = "VERSION_FROM_UPDATE";
  
  public static String aB = "USER_CONSENT_CLAUSE";
  
  public static String aC = "SHOWED_DIALOG_DOWNLOAD_INTERNATIONAL";
  
  public static String aD = "SHOWED_FOLLOW_TO_VIEW_LIVE";
  
  public static String aE = "SHOWED_FILTER_DOT_722";
  
  public static String aF = "SHOWED_LIVE_CAMERA_REMIND";
  
  public static String aG = "SHOWED_LIVE_TIPS_REMIND";
  
  public static String aH = "FIREST_LIVE_CACEL";
  
  public static String aI = "VERIFYED_TIME";
  
  public static String aJ = "GUIDE_PUBLISH_FEED_CODE";
  
  public static String aK = "new_feature_group_notify";
  
  public static String aL = "new_feature_live_list";
  
  public static String aM = "SHOWED_NEWFEATURE_WECHAT_BIND";
  
  public static String aN = "NEW_EMOTION_CODE";
  
  public static String aO = "SHOWED_SETTING_REMIND";
  
  public static String aP = "select_photo_new";
  
  public static String aQ = "zan_res";
  
  public static String aR = "SHOWED_MY_GIFT_DOT";
  
  public static String aS = "LAST_SPLASH_ID";
  
  public static String aT = "SPLASH_NEXT_INTERVAL_FLOAT";
  
  public static String aU = "first_msg_sight";
  
  public static String aV = "mode_listen";
  
  public static String aW = "lock";
  
  public static String aX = "pattern";
  
  public static String aY = "back";
  
  public static String aZ = "app_back";
  
  public static String aa = "groupchatvoice";
  
  public static String ab = "groupchatshake";
  
  public static String ac = "pushmessage";
  
  public static String ad = "remindsystem";
  
  public static String ae = "livepushstate";
  
  public static String af = "REMIND_OTHER_PUSH";
  
  public static String ag = "remindmessage";
  
  public static String ah = "remindfollowed";
  
  public static String ai = "receivegroupmsg";
  
  public static String aj = "remindcomments";
  
  public static String ak = "feed_praise";
  
  public static String al = "FEED_AT";
  
  public static String am = "visited_push";
  
  public static String an = "recommend_live";
  
  public static String ao = "SHOWED_SHARE_HINT";
  
  public static String ap = "ignore";
  
  public static String aq = "secrets_look";
  
  public static String ar = "TIPS_VIDEO_CHAT";
  
  public static String as = "LAST_APPLIST_POSTED_TIME";
  
  public static String at = "OPEN_CUSTOM_RECOMMEND";
  
  public static String au = "screen_wide";
  
  public static String av = "screen_hight";
  
  public static String aw = "deskapp_created";
  
  public static String ax = "guide_version";
  
  public static String ay = "unit_setting";
  
  public static String az = "NEARBY_PEOPLE_DATA_CHOOSE_SORT_BY";
  
  public static SharedPreferences b;
  
  public static String bA = "SP_DEBUG_CONFIG_JSON";
  
  public static String bB = "IS_FIRST_SHOW";
  
  public static String bC = "USER_REGISTER_TIME";
  
  public static String bD = "JOIN_CIRCLE_OUT_OF_CIRCLE_DETAILS";
  
  public static String bE = "SHOW_DIALOG_ONLY_ONCE";
  
  public static String bF = "NEW_GIFT_GUIDE";
  
  public static String bG = "close_check_launch_permission";
  
  public static String bH = "BOX_SESSION_ID";
  
  public static String bI = "EXPOSURE_PAID_ORDER_ID";
  
  public static String bJ = "IS_SHOW_GIFT_PACKAGE_RED";
  
  public static String bK = "setting_join_circle";
  
  public static String bL = "first_send_dynamic";
  
  public static String bM = "IS_SHOW_CIRCLE_MOVE_TIP";
  
  public static String bN = "IS_YY_ROOM_FIRST_SHOW";
  
  public static String bO = "IS_FIRST_VOICE_TURN_TEXT";
  
  public static String bP = "IS_CAN_VOICE_TURN_TEXT";
  
  public static String bQ = "GROUP_TIPS_TIME";
  
  public static String bR = "IS_SHOW_FEED_POST_DRAG_PHOTO_TIP";
  
  public static String bS = "IS_SHOW_MSG_PIC_PIN_GUIDE";
  
  private static String bT = "MAP_SEARCH_HISTORY";
  
  private static String bU = "MAP_SHADOW_SEARCH_HISTORY";
  
  private static String bV = "MAP_SHADOW_SET_HISTORY";
  
  private static String bW = "club_hot_push";
  
  public static String ba = "emotions_pack";
  
  public static String bb = "download_time_";
  
  public static String bc = "default_emotion_packs";
  
  public static String bd = "SHOW_CHAT_BG_RED_DOT";
  
  public static String be = "visitor_record_remind";
  
  public static String bf = "SHOW_MAP_VIP_PRIVILEGE_TIP";
  
  public static String bg = "binding_account";
  
  public static String bh = "binding_account_type";
  
  public static int bi = 200;
  
  public static String bj = "binding_start_num";
  
  public static String bk = "blued_ad_close";
  
  public static String bl = "boot_advert_shown";
  
  public static String bm = "download_id";
  
  public static String bn = "version code";
  
  public static String bo = "new_game_remind";
  
  public static String bp = "login_protection_status";
  
  public static String bq = "new_feature_my";
  
  public static String br = "new_feature_setting";
  
  public static String bs = "SHOW_CHAT_BUBBLE_RED_DOT";
  
  public static String bt = "SWITCH_UNREAD_MSG_TYPE";
  
  public static String bu = "SHOW_TAB_UNREAD_MSG_RED_DOT";
  
  public static String bv = "SHOW_SWITCH_UNREAD_MSG_RED_DOT";
  
  public static String bw = "IS_SHOW_UNREAD_MSG_GUIDE";
  
  public static String bx = "SHOW_CHAT_BUBBLE_RED_DOT_IN_VIP_CENTER";
  
  public static String by = "SHOW_FEED_BG_RED_DOT_IN_VIP_CENTER";
  
  public static String bz = "SHOWED_AVATAR_WIDGET_RED_DOT_IN_VIP_CENTER";
  
  public static SharedPreferences c;
  
  public static SharedPreferences d;
  
  public static SharedPreferences e;
  
  public static SharedPreferences f;
  
  public static SharedPreferences g;
  
  public static SharedPreferences h;
  
  public static SharedPreferences i;
  
  public static SharedPreferences j;
  
  public static SharedPreferences k;
  
  public static String l = "LAUNCHER_ACTIVITY_CLASS_NAME";
  
  public static String m = "LAST_AUTO_LOCATION_CHECK_STAMP";
  
  public static String n = "APP_LAUNCH_COUNT";
  
  public static String o = "AUTO_REFRESH_LOCATION_PEOPLE_CHECKED";
  
  public static String p = "AUTO_REFRESH_LOCATION_FEED_CHECKED";
  
  public static String q = "display_term";
  
  public static String r = "longitude";
  
  public static String s = "latitude";
  
  public static String t = "adress";
  
  public static String u = "adressdetail";
  
  public static String v = "PATTERN_LOCK_STATUS_POSTED";
  
  public static String w = "FIND_RECOMMEND_TYPE";
  
  public static String x = "BLUED_CONFIG";
  
  public static String y = "AV_CONFIG";
  
  public static String z = "PAY_EXPERIMENT_CONFIG";
  
  public static void A(int paramInt) {
    e().edit().putInt(bt, paramInt).apply();
  }
  
  public static void A(boolean paramBoolean) {
    e().edit().putBoolean(be, paramBoolean).commit();
  }
  
  public static boolean A() {
    return b().getBoolean(v, false);
  }
  
  public static boolean A(String paramString) {
    return e().getBoolean(paramString, true);
  }
  
  public static void B() {
    b().edit().putBoolean(v, true).commit();
  }
  
  public static void B(String paramString) {
    e().edit().putBoolean(paramString, false).commit();
  }
  
  public static void B(boolean paramBoolean) {
    e().edit().putBoolean("privacy_photo_onoff", paramBoolean).commit();
  }
  
  public static boolean B(int paramInt) {
    SharedPreferences sharedPreferences = e();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(bF);
    stringBuilder.append(paramInt);
    return sharedPreferences.getBoolean(stringBuilder.toString(), false);
  }
  
  public static int C() {
    return b().getInt(w, 0);
  }
  
  public static void C(int paramInt) {
    SharedPreferences.Editor editor = e().edit();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(bF);
    stringBuilder.append(paramInt);
    editor.putBoolean(stringBuilder.toString(), true).apply();
  }
  
  public static void C(String paramString) {
    b().edit().putString(aP, paramString).commit();
  }
  
  public static void C(boolean paramBoolean) {
    e().edit().putBoolean(bl, paramBoolean).commit();
  }
  
  public static String D() {
    SharedPreferences sharedPreferences = b();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(UserInfo.a().i().getUid());
    stringBuilder.append(x);
    return sharedPreferences.getString(stringBuilder.toString(), "");
  }
  
  public static void D(String paramString) {
    SharedPreferences.Editor editor = a().edit();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(aS);
    stringBuilder.append(AppInfo.g);
    editor.putString(stringBuilder.toString(), paramString).commit();
  }
  
  public static void D(boolean paramBoolean) {
    e().edit().putBoolean(bp, paramBoolean).commit();
  }
  
  public static String E() {
    return b().getString(y, "");
  }
  
  public static void E(String paramString) {
    g().edit().putString(aX, paramString).commit();
  }
  
  public static void E(boolean paramBoolean) {
    e().edit().putBoolean("CHAT_SETTING_ENTER_SEND", paramBoolean).apply();
  }
  
  public static String F() {
    return b().getString(z, "");
  }
  
  public static void F(String paramString) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("pattern_code_");
    stringBuilder.append(UserInfo.a().i().getUid());
    String str = stringBuilder.toString();
    g().edit().putString(str, paramString).commit();
  }
  
  public static void F(boolean paramBoolean) {
    e().edit().putBoolean("blued_skin", paramBoolean).apply();
  }
  
  public static long G(String paramString) {
    SharedPreferences sharedPreferences = i();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(bb);
    stringBuilder.append(paramString);
    return sharedPreferences.getLong(stringBuilder.toString(), 0L);
  }
  
  public static void G(boolean paramBoolean) {
    e().edit().putBoolean("SETTING_TEXT_SIZE_DOT", paramBoolean).apply();
  }
  
  public static boolean G() {
    SharedPreferences sharedPreferences = c();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(UserInfo.a().i().getUid());
    stringBuilder.append(A);
    return sharedPreferences.getBoolean(stringBuilder.toString(), true);
  }
  
  public static String H() {
    SharedPreferences sharedPreferences = c();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(UserInfo.a().i().getUid());
    stringBuilder.append(C);
    return sharedPreferences.getString(stringBuilder.toString(), "");
  }
  
  public static void H(String paramString) {
    SharedPreferences.Editor editor = i().edit();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(bb);
    stringBuilder.append(paramString);
    editor.remove(stringBuilder.toString()).commit();
  }
  
  public static void H(boolean paramBoolean) {
    e().edit().putBoolean("welcome_anim", paramBoolean).apply();
  }
  
  public static int I() {
    SharedPreferences sharedPreferences = c();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(UserInfo.a().i().getUid());
    stringBuilder.append(D);
    return sharedPreferences.getInt(stringBuilder.toString(), 1);
  }
  
  public static void I(String paramString) {
    j().edit().putString(bc, paramString).commit();
  }
  
  public static void I(boolean paramBoolean) {
    e().edit().putBoolean("change_skin", paramBoolean).apply();
  }
  
  public static String J() {
    SharedPreferences sharedPreferences = c();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(UserInfo.a().i().getUid());
    stringBuilder.append(E);
    return sharedPreferences.getString(stringBuilder.toString(), "");
  }
  
  public static void J(String paramString) {
    k().edit().putString(bg, paramString).commit();
  }
  
  public static void J(boolean paramBoolean) {
    e().edit().putBoolean("IS_NEED_SYNC_REMIND_SETTING", paramBoolean).apply();
  }
  
  public static String K() {
    SharedPreferences sharedPreferences = c();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(UserInfo.a().i().getUid());
    stringBuilder.append(F);
    return sharedPreferences.getString(stringBuilder.toString(), "");
  }
  
  public static void K(String paramString) {
    e().edit().putString("blued_http_host", paramString).commit();
  }
  
  public static void K(boolean paramBoolean) {
    e().edit().putBoolean("IS_NEED_SYNC_GROUP_REMIND_SETTING", paramBoolean).apply();
  }
  
  public static String L() {
    SharedPreferences sharedPreferences = c();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(UserInfo.a().i().getUid());
    stringBuilder.append(G);
    return sharedPreferences.getString(stringBuilder.toString(), "");
  }
  
  public static void L(String paramString) {
    e().edit().putString("blued_pay_host", paramString).commit();
  }
  
  public static void L(boolean paramBoolean) {
    e().edit().putBoolean("remind_login_mobile", paramBoolean).apply();
  }
  
  public static String M() {
    SharedPreferences sharedPreferences = c();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(UserInfo.a().i().getUid());
    stringBuilder.append(H);
    return sharedPreferences.getString(stringBuilder.toString(), "");
  }
  
  public static void M(String paramString) {
    e().edit().putString("blued_sdk_host", paramString).commit();
  }
  
  public static void M(boolean paramBoolean) {
    e().edit().putBoolean("remind_common_mobile", paramBoolean).apply();
  }
  
  public static String N() {
    SharedPreferences sharedPreferences = c();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(UserInfo.a().i().getUid());
    stringBuilder.append(I);
    return sharedPreferences.getString(stringBuilder.toString(), "");
  }
  
  public static void N(String paramString) {
    e().edit().putString("blued_http_host_addr", paramString).commit();
  }
  
  public static void N(boolean paramBoolean) {
    SharedPreferences.Editor editor = e().edit();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("has_verify_mobile");
    stringBuilder.append((UserInfo.a().i()).uid);
    editor.putBoolean(stringBuilder.toString(), paramBoolean).apply();
  }
  
  public static void O(String paramString) {
    e().edit().putString("blued_health_host", paramString).commit();
  }
  
  public static void O(boolean paramBoolean) {
    SharedPreferences.Editor editor = e().edit();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("has_used_mobile");
    stringBuilder.append((UserInfo.a().i()).uid);
    editor.putBoolean(stringBuilder.toString(), paramBoolean).apply();
  }
  
  public static boolean O() {
    SharedPreferences sharedPreferences = c();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(UserInfo.a().i().getUid());
    stringBuilder.append(J);
    return sharedPreferences.getBoolean(stringBuilder.toString(), false);
  }
  
  public static void P(String paramString) {
    e().edit().putString("blued_data_host_addr", paramString).commit();
  }
  
  public static void P(boolean paramBoolean) {
    e().edit().putBoolean("MSG_BOX_TG", paramBoolean).apply();
  }
  
  public static boolean P() {
    SharedPreferences sharedPreferences = c();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(UserInfo.a().i().getUid());
    stringBuilder.append(K);
    return sharedPreferences.getBoolean(stringBuilder.toString(), false);
  }
  
  public static void Q(String paramString) {
    e().edit().putString("WEB_BLUED_HOST", paramString).commit();
  }
  
  public static void Q(boolean paramBoolean) {
    BluedSkinPreferences.a(paramBoolean);
    if (!paramBoolean) {
      int i;
      if (cZ()) {
        i = 2131755663;
      } else {
        i = 2131755667;
      } 
      x(i);
      return;
    } 
    x(2131758076);
  }
  
  public static boolean Q() {
    SharedPreferences sharedPreferences = c();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(UserInfo.a().i().getUid());
    stringBuilder.append(L);
    return sharedPreferences.getBoolean(stringBuilder.toString(), false);
  }
  
  public static String R() {
    SharedPreferences sharedPreferences = c();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(UserInfo.a().i().getUid());
    stringBuilder.append(M);
    return sharedPreferences.getString(stringBuilder.toString(), "");
  }
  
  public static void R(String paramString) {
    e().edit().putString("M_BLUED_HOST", paramString).commit();
  }
  
  public static void R(boolean paramBoolean) {
    e().edit().putBoolean("install_and_login", paramBoolean).apply();
  }
  
  public static String S() {
    SharedPreferences sharedPreferences = c();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(UserInfo.a().i().getUid());
    stringBuilder.append(N);
    return sharedPreferences.getString(stringBuilder.toString(), "");
  }
  
  public static void S(String paramString) {
    e().edit().putString("LIVE_IM_HOST", paramString).commit();
  }
  
  public static void S(boolean paramBoolean) {
    e().edit().putBoolean("IS_SHOW_SECRET_HINT", paramBoolean).apply();
  }
  
  public static String T() {
    SharedPreferences sharedPreferences = c();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(UserInfo.a().i().getUid());
    stringBuilder.append(O);
    return sharedPreferences.getString(stringBuilder.toString(), "");
  }
  
  public static void T(String paramString) {
    e().edit().putString("GRPC_IM_HOST", paramString).apply();
  }
  
  public static void T(boolean paramBoolean) {
    SharedPreferences.Editor editor = e().edit();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(bu);
    stringBuilder.append((UserInfo.a().i()).uid);
    editor.putBoolean(stringBuilder.toString(), paramBoolean).apply();
  }
  
  public static String U() {
    SharedPreferences sharedPreferences = c();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(UserInfo.a().i().getUid());
    stringBuilder.append(P);
    return sharedPreferences.getString(stringBuilder.toString(), "");
  }
  
  public static String U(String paramString) {
    return e().getString("pay_token", paramString);
  }
  
  public static void U(boolean paramBoolean) {
    SharedPreferences.Editor editor = e().edit();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(bv);
    stringBuilder.append((UserInfo.a().i()).uid);
    editor.putBoolean(stringBuilder.toString(), paramBoolean).apply();
  }
  
  public static String V() {
    SharedPreferences sharedPreferences = c();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(UserInfo.a().i().getUid());
    stringBuilder.append(Q);
    return sharedPreferences.getString(stringBuilder.toString(), "");
  }
  
  public static void V(String paramString) {
    e().edit().putString("pay_token", paramString).commit();
  }
  
  public static void V(boolean paramBoolean) {
    SharedPreferences.Editor editor = e().edit();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(bJ);
    stringBuilder.append((UserInfo.a().i()).uid);
    editor.putBoolean(stringBuilder.toString(), paramBoolean).apply();
  }
  
  public static void W(String paramString) {
    e().edit().putString("push_token", paramString).commit();
  }
  
  public static void W(boolean paramBoolean) {
    e().edit().putBoolean(bK, paramBoolean).apply();
  }
  
  public static boolean W() {
    SharedPreferences sharedPreferences = c();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(UserInfo.a().i().getUid());
    stringBuilder.append(R);
    return sharedPreferences.getBoolean(stringBuilder.toString(), false);
  }
  
  public static String X() {
    SharedPreferences sharedPreferences = c();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(UserInfo.a().i().getUid());
    stringBuilder.append(S);
    return sharedPreferences.getString(stringBuilder.toString(), "0-max");
  }
  
  public static void X(String paramString) {
    e().edit().putString("nologin_device_token", paramString).commit();
  }
  
  public static String Y() {
    SharedPreferences sharedPreferences = c();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(UserInfo.a().i().getUid());
    stringBuilder.append(T);
    return sharedPreferences.getString(stringBuilder.toString(), "0-max");
  }
  
  public static void Y(String paramString) {
    e().edit().putString(bn, paramString).commit();
  }
  
  public static String Z() {
    SharedPreferences sharedPreferences = c();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(UserInfo.a().i().getUid());
    stringBuilder.append(U);
    return sharedPreferences.getString(stringBuilder.toString(), "0-max");
  }
  
  public static void Z(String paramString) {
    e().edit().putString("login_out_msg", paramString).commit();
  }
  
  public static SharedPreferences a() {
    if (e == null)
      e = AppInfo.d().getSharedPreferences("blued_sf_common", 0); 
    return e;
  }
  
  public static String a(String paramString) {
    return b().getString(l, paramString);
  }
  
  public static void a(double paramDouble) {
    SharedPreferences.Editor editor = b().edit();
    String str = r;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramDouble);
    stringBuilder.append("");
    editor.putString(str, stringBuilder.toString()).commit();
    BluedStatistics.a().d(String.valueOf(paramDouble));
  }
  
  public static void a(float paramFloat) {
    a().edit().putFloat(aT, paramFloat).commit();
  }
  
  public static void a(int paramInt) {
    SharedPreferences.Editor editor = c().edit();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(UserInfo.a().i().getUid());
    stringBuilder.append(D);
    editor.putInt(stringBuilder.toString(), paramInt).commit();
  }
  
  public static void a(long paramLong) {
    e().edit().putLong(as, paramLong).commit();
  }
  
  public static void a(long paramLong1, long paramLong2) {
    SharedPreferences.Editor editor = e().edit();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(bQ);
    stringBuilder.append(paramLong1);
    editor.putLong(stringBuilder.toString(), paramLong2).apply();
  }
  
  public static void a(long paramLong, String paramString) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("download_id_");
    stringBuilder.append(paramLong);
    String str = stringBuilder.toString();
    e().edit().putString(str, paramString).commit();
  }
  
  public static void a(BluedADExtra paramBluedADExtra) {
    ArrayList<BluedADExtra> arrayList1;
    ArrayList<BluedADExtra> arrayList2 = bo();
    if (arrayList2 != null && arrayList2.size() > 0) {
      arrayList2.add(paramBluedADExtra);
      arrayList1 = arrayList2;
    } else {
      arrayList2 = new ArrayList<BluedADExtra>();
      arrayList2.add(arrayList1);
      arrayList1 = arrayList2;
    } 
    b(arrayList1);
  }
  
  public static void a(String paramString, long paramLong) {
    SharedPreferences.Editor editor = i().edit();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(bb);
    stringBuilder.append(paramString);
    editor.putLong(stringBuilder.toString(), paramLong).commit();
  }
  
  public static void a(String paramString1, String paramString2) {
    SharedPreferences.Editor editor = d().edit();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(X);
    stringBuilder.append(paramString1);
    editor.putString(stringBuilder.toString(), paramString2).commit();
  }
  
  public static void a(String paramString, boolean paramBoolean) {
    SharedPreferences.Editor editor = e().edit();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramString);
    stringBuilder.append(bD);
    editor.putBoolean(stringBuilder.toString(), paramBoolean).commit();
  }
  
  public static void a(ArrayList<BluedADExtra> paramArrayList) {
    PreferenceAD preferenceAD = new PreferenceAD();
    preferenceAD.list = paramArrayList;
    String str = AppInfo.f().toJson(preferenceAD);
    a().edit().putString("USER_AD_JSON1", str).commit();
  }
  
  public static void a(boolean paramBoolean) {
    SharedPreferences.Editor editor = c().edit();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(UserInfo.a().i().getUid());
    stringBuilder.append(A);
    editor.putBoolean(stringBuilder.toString(), paramBoolean).commit();
    if (HomeActivity.c != null)
      ((NearbyViewModel)ViewModelProviders.of((FragmentActivity)HomeActivity.c).get(NearbyViewModel.class)).c.postValue(null); 
  }
  
  public static int aA() {
    SharedPreferences sharedPreferences = e();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(aA);
    stringBuilder.append(AppInfo.h);
    return sharedPreferences.getInt(stringBuilder.toString(), -1);
  }
  
  public static boolean aA(String paramString) {
    SharedPreferences sharedPreferences = e();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramString);
    stringBuilder.append(bN);
    return sharedPreferences.getBoolean(stringBuilder.toString(), true);
  }
  
  public static void aB(String paramString) {
    SharedPreferences.Editor editor = e().edit();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramString);
    stringBuilder.append(bN);
    editor.putBoolean(stringBuilder.toString(), false).commit();
  }
  
  public static boolean aB() {
    return e().getBoolean(aB, false);
  }
  
  public static void aC() {
    e().edit().putBoolean(aB, true).commit();
  }
  
  public static int aD() {
    if (ax() != 1) {
      c(ax());
      b(0);
    } 
    return ay();
  }
  
  public static boolean aE() {
    return e().getBoolean(aC, true);
  }
  
  public static void aF() {
    e().edit().putBoolean(aC, false).commit();
  }
  
  public static boolean aG() {
    return e().getBoolean(aE, false);
  }
  
  public static void aH() {
    e().edit().putBoolean(aE, true).commit();
  }
  
  public static void aI() {
    e().edit().putBoolean(aF, false).commit();
  }
  
  public static boolean aJ() {
    return e().getBoolean(aG, true);
  }
  
  public static void aK() {
    e().edit().putBoolean(aG, false).commit();
  }
  
  public static boolean aL() {
    return e().getBoolean(aH, true);
  }
  
  public static void aM() {
    e().edit().putBoolean(aH, false).commit();
  }
  
  public static String aN() {
    SharedPreferences sharedPreferences = e();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(UserInfo.a().i().getUid());
    stringBuilder.append(aI);
    return sharedPreferences.getString(stringBuilder.toString(), "");
  }
  
  public static String aO() {
    return e().getString(aJ, "");
  }
  
  public static boolean aP() {
    return e().getBoolean(aL, true);
  }
  
  public static void aQ() {
    e().edit().putBoolean(aL, false).commit();
  }
  
  public static String aR() {
    return b().getString(aP, "");
  }
  
  public static boolean aS() {
    return e().getBoolean(aR, false);
  }
  
  public static void aT() {
    e().edit().putBoolean(aR, true).commit();
  }
  
  public static String aU() {
    SharedPreferences sharedPreferences = a();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(aS);
    stringBuilder.append(AppInfo.g);
    return sharedPreferences.getString(stringBuilder.toString(), "");
  }
  
  public static float aV() {
    return a().getFloat(aT, 0.0F);
  }
  
  public static boolean aW() {
    return e().getBoolean(aV, false);
  }
  
  public static boolean aX() {
    return f().getBoolean(aW, false);
  }
  
  public static boolean aY() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("lock_onoff_");
    stringBuilder.append(UserInfo.a().i().getUid());
    String str = stringBuilder.toString();
    return f().getBoolean(str, false);
  }
  
  public static boolean aZ() {
    if (aX()) {
      y(false);
      z(true);
    } 
    return aY();
  }
  
  public static void aa(String paramString) {
    e().edit().putString("live_classify_tab", paramString).commit();
  }
  
  public static boolean aa() {
    return d().getBoolean(W, true);
  }
  
  @Deprecated
  public static String ab() {
    return d().getString(X, "");
  }
  
  public static void ab(String paramString) {
    e().edit().putString("live_classify_tab_new", paramString).commit();
  }
  
  public static String ac(String paramString) {
    return e().getString(paramString, "");
  }
  
  public static boolean ac() {
    return d().getBoolean(Y, true);
  }
  
  public static void ad(String paramString) {
    e().edit().putString("UPDATE_TIPS_DATA", paramString).commit();
  }
  
  public static boolean ad() {
    return d().getBoolean(Z, false);
  }
  
  public static void ae(String paramString) {
    e().edit().putString("POSTED_PATCH_CODE", paramString).commit();
  }
  
  public static boolean ae() {
    return d().getBoolean(ac, true);
  }
  
  public static boolean af() {
    return d().getBoolean(ad, true);
  }
  
  public static boolean af(String paramString) {
    if (TextUtils.isEmpty(paramString))
      return false; 
    SharedPreferences sharedPreferences = e();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("IS_SHOW_MINE_ENTRY_DOT_OR_NEW");
    stringBuilder.append(paramString);
    return sharedPreferences.getBoolean(stringBuilder.toString(), true);
  }
  
  public static void ag(String paramString) {
    if (TextUtils.isEmpty(paramString))
      return; 
    SharedPreferences.Editor editor = e().edit();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("IS_SHOW_MINE_ENTRY_DOT_OR_NEW");
    stringBuilder.append(paramString);
    editor.putBoolean(stringBuilder.toString(), false).commit();
  }
  
  public static boolean ag() {
    return d().getBoolean(ae, true);
  }
  
  public static void ah(String paramString) {
    e().edit().putString("IS_SHOW_SELECT_GUIDE_CODE", paramString).apply();
  }
  
  public static boolean ah() {
    return d().getBoolean(af, true);
  }
  
  public static void ai(String paramString) {
    e().edit().putString("CALL_TIP_SHOW_TIME_UID", paramString).apply();
  }
  
  public static boolean ai() {
    return d().getBoolean(ag, true);
  }
  
  public static void aj(String paramString) {
    e().edit().putString("MSG_BOX_SOURCE_STRING", paramString).apply();
  }
  
  public static boolean aj() {
    return d().getBoolean(ah, true);
  }
  
  public static void ak(String paramString) {
    e().edit().putString("MSG_BOX_DISTANCE", paramString).apply();
  }
  
  public static boolean ak() {
    return d().getBoolean(ai, true);
  }
  
  public static void al(String paramString) {
    e().edit().putString("NEARBY_CITY_CODE", paramString).apply();
  }
  
  public static boolean al() {
    return d().getBoolean(aj, true);
  }
  
  public static void am(String paramString) {
    e().edit().putString("dynamic_skin", paramString).apply();
  }
  
  public static boolean am() {
    return d().getBoolean(ak, true);
  }
  
  public static void an(String paramString) {
    e().edit().putString("avatar_widget", paramString).apply();
  }
  
  public static boolean an() {
    return d().getBoolean(al, true);
  }
  
  public static void ao(String paramString) {
    e().edit().putString("blued_version_introduce", paramString).apply();
  }
  
  public static boolean ao() {
    return d().getBoolean(am, true);
  }
  
  public static void ap(String paramString) {
    e().edit().putString("HELLO_RANK_BY", paramString).apply();
  }
  
  public static boolean ap() {
    return d().getBoolean(an, true);
  }
  
  public static void aq(String paramString) {
    e().edit().putString("HELLO_ROLE", paramString).apply();
  }
  
  public static boolean aq() {
    return d().getBoolean(bW, true);
  }
  
  public static void ar(String paramString) {
    e().edit().putString("NEARBY_ACTIVITY_TITLE", paramString).apply();
  }
  
  public static boolean ar() {
    if (UserInfo.a().i() != null && ((UserInfo.a().i()).vip_grade != 2 || (BluedConfig.b().j()).is_view_secretly == 0))
      v(false); 
    return TextUtils.equals(d().getString(aq, ""), "yes");
  }
  
  public static void as() {
    d().edit().putString(aq, "").commit();
  }
  
  public static void as(String paramString) {
    SharedPreferences.Editor editor = e().edit();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(bA);
    stringBuilder.append((UserInfo.a().i()).uid);
    editor.putString(stringBuilder.toString(), paramString).apply();
  }
  
  public static boolean at() {
    return TextUtils.isEmpty(d().getString(aq, ""));
  }
  
  public static boolean at(String paramString) {
    SharedPreferences sharedPreferences = e();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramString);
    stringBuilder.append(bB);
    return sharedPreferences.getBoolean(stringBuilder.toString(), false);
  }
  
  public static void au(String paramString) {
    SharedPreferences.Editor editor = e().edit();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramString);
    stringBuilder.append(bB);
    editor.putBoolean(stringBuilder.toString(), true).commit();
  }
  
  public static boolean au() {
    return e().getBoolean(ar, true);
  }
  
  public static void av() {
    e().edit().putBoolean(ar, false).commit();
  }
  
  public static void av(String paramString) {
    e().edit().putString(bC, paramString).commit();
  }
  
  public static boolean aw() {
    return e().getBoolean(at, false);
  }
  
  public static boolean aw(String paramString) {
    SharedPreferences sharedPreferences = e();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramString);
    stringBuilder.append(bD);
    return sharedPreferences.getBoolean(stringBuilder.toString(), false);
  }
  
  public static int ax() {
    return StringUtils.a(e().getInt(ay, 0), BlueAppLocal.c());
  }
  
  public static boolean ax(String paramString) {
    SharedPreferences sharedPreferences = e();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramString);
    stringBuilder.append(bE);
    return sharedPreferences.getBoolean(stringBuilder.toString(), true);
  }
  
  public static int ay() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("unit_setting_");
    stringBuilder.append(UserInfo.a().i().getUid());
    String str = stringBuilder.toString();
    return StringUtils.a(e().getInt(str, 0), BlueAppLocal.c());
  }
  
  public static String ay(String paramString) {
    SharedPreferences sharedPreferences = e();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(bH);
    stringBuilder.append(paramString);
    return sharedPreferences.getString(stringBuilder.toString(), "");
  }
  
  public static String az() {
    return e().getString(az, null);
  }
  
  public static void az(String paramString) {
    e().edit().putString(bI, paramString).apply();
  }
  
  public static SharedPreferences b() {
    if (a == null)
      a = AppInfo.d().getSharedPreferences("blued_sf", 0); 
    return a;
  }
  
  public static void b(double paramDouble) {
    SharedPreferences.Editor editor = b().edit();
    String str = s;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramDouble);
    stringBuilder.append("");
    editor.putString(str, stringBuilder.toString()).commit();
    BluedStatistics.a().c(String.valueOf(paramDouble));
  }
  
  public static void b(int paramInt) {
    e().edit().putInt(ay, paramInt).commit();
  }
  
  public static void b(long paramLong) {
    h().edit().putLong(aY, paramLong).commit();
  }
  
  public static void b(String paramString) {
    b().edit().putString(l, paramString).commit();
  }
  
  public static void b(String paramString1, String paramString2) {
    SharedPreferences.Editor editor = e().edit();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(bH);
    stringBuilder.append(paramString1);
    editor.putString(stringBuilder.toString(), paramString2).apply();
  }
  
  public static void b(String paramString, boolean paramBoolean) {
    SharedPreferences.Editor editor = e().edit();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramString);
    stringBuilder.append(bE);
    editor.putBoolean(stringBuilder.toString(), paramBoolean).commit();
  }
  
  public static void b(ArrayList<BluedADExtra> paramArrayList) {
    PreferenceAD preferenceAD = new PreferenceAD();
    preferenceAD.list = paramArrayList;
    String str = AppInfo.f().toJson(preferenceAD);
    a().edit().putString("FEED_AD_JSON2", str).commit();
  }
  
  public static void b(boolean paramBoolean) {
    SharedPreferences.Editor editor = c().edit();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(UserInfo.a().i().getUid());
    stringBuilder.append(J);
    editor.putBoolean(stringBuilder.toString(), paramBoolean).commit();
  }
  
  public static void bA() {
    e().edit().putBoolean("app_active", true).commit();
  }
  
  public static boolean bB() {
    return e().getBoolean("privacy_photo_onoff", true);
  }
  
  public static boolean bC() {
    return e().getBoolean(bl, false);
  }
  
  public static long bD() {
    return e().getLong(bm, -1L);
  }
  
  public static String bE() {
    return e().getString(bn, "");
  }
  
  public static boolean bF() {
    return d.getBoolean(bp, false);
  }
  
  public static boolean bG() {
    return d.getBoolean(bq, true);
  }
  
  public static void bH() {
    e().edit().putBoolean(bq, false).commit();
  }
  
  public static int bI() {
    return e().getInt("live_is_soft", 0);
  }
  
  public static int bJ() {
    return e().getInt("live_is_beauty", 0);
  }
  
  public static String bK() {
    return e().getString("login_out_msg", "");
  }
  
  public static String bL() {
    return e().getString("live_classify_tab_new", null);
  }
  
  public static boolean bM() {
    return e().getBoolean("flash_seek_tip", true);
  }
  
  public static void bN() {
    e().edit().putBoolean("flash_seek_tip", false).commit();
  }
  
  public static String bO() {
    return e().getString("UPDATE_TIPS_DATA", "");
  }
  
  public static int bP() {
    return e().getInt("UPDATE_TIPS_TIMES", 0);
  }
  
  public static final long bQ() {
    return e().getLong("FEED_PROMOTION_TIME", 0L);
  }
  
  public static final String bR() {
    return e().getString("POSTED_PATCH_CODE", "");
  }
  
  public static int bS() {
    SharedPreferences sharedPreferences = e();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("PRIVILEGE_BUY_PAY_TYPE");
    stringBuilder.append((UserInfo.a().i()).uid);
    return sharedPreferences.getInt(stringBuilder.toString(), 0);
  }
  
  public static boolean bT() {
    return e().getBoolean("FIRST_SHOW_SAFE_TIPS", true);
  }
  
  public static void bU() {
    e().edit().putBoolean("FIRST_SHOW_SAFE_TIPS", false).commit();
  }
  
  public static boolean bV() {
    return e().getBoolean("SYNC_AVATAR_TIP", true);
  }
  
  public static void bW() {
    e().edit().putBoolean("SYNC_AVATAR_TIP", false).commit();
  }
  
  public static boolean bX() {
    return e().getBoolean("SYNC_AVATAR_DOT_TIP", true);
  }
  
  public static void bY() {
    e().edit().putBoolean("SYNC_AVATAR_DOT_TIP", false).commit();
  }
  
  public static void bZ() {
    e().edit().putBoolean("HAS_SHOW_MSG_MENU_RED_POINT_716", true).commit();
  }
  
  public static String ba() {
    return g().getString(aX, "");
  }
  
  public static String bb() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("pattern_code_");
    stringBuilder.append(UserInfo.a().i().getUid());
    String str = stringBuilder.toString();
    return g().getString(str, "");
  }
  
  public static String bc() {
    if (!"".equals(ba())) {
      F(ba());
      E("");
    } 
    return bb();
  }
  
  public static Long bd() {
    return Long.valueOf(h().getLong(aY, 0L));
  }
  
  public static Long be() {
    return Long.valueOf(h().getLong(aZ, 0L));
  }
  
  public static Long bf() {
    return Long.valueOf(i().getLong(ba, 0L));
  }
  
  public static String bg() {
    return j().getString(bc, "");
  }
  
  public static boolean bh() {
    return e().getBoolean(be, false);
  }
  
  public static boolean bi() {
    return e().getBoolean(bf, true);
  }
  
  public static void bj() {
    e().edit().putBoolean(bf, false).commit();
  }
  
  public static String bk() {
    return k().getString(bg, "");
  }
  
  public static int bl() {
    return k().getInt(bh, 0);
  }
  
  public static int bm() {
    return k().getInt(bj, 0);
  }
  
  public static ArrayList<BluedADExtra> bn() {
    String str = a().getString("USER_AD_JSON1", "");
    ArrayList<BluedADExtra> arrayList = new ArrayList();
    PreferenceAD preferenceAD = (PreferenceAD)AppInfo.f().fromJson(str, PreferenceAD.class);
    if (preferenceAD != null)
      arrayList = preferenceAD.list; 
    return arrayList;
  }
  
  public static ArrayList<BluedADExtra> bo() {
    String str = a().getString("FEED_AD_JSON2", "");
    ArrayList<BluedADExtra> arrayList = new ArrayList();
    PreferenceAD preferenceAD = (PreferenceAD)AppInfo.f().fromJson(str, PreferenceAD.class);
    if (preferenceAD != null)
      arrayList = preferenceAD.list; 
    return arrayList;
  }
  
  public static ArrayList<BluedADExtra> bp() {
    String str = a().getString("FEED_BANNER_AD_JSON3", "");
    ArrayList<BluedADExtra> arrayList = new ArrayList();
    PreferenceAD preferenceAD = (PreferenceAD)AppInfo.f().fromJson(str, PreferenceAD.class);
    if (preferenceAD != null)
      arrayList = preferenceAD.list; 
    return arrayList;
  }
  
  public static String bq() {
    return e().getString("push_token", "");
  }
  
  public static int br() {
    return e().getInt("live_rank_value", 0);
  }
  
  public static boolean bs() {
    return e().getBoolean("new_feature_live_ranking", true);
  }
  
  public static void bt() {
    e().edit().putBoolean("new_feature_live_ranking", false).commit();
  }
  
  public static int bu() {
    return e().getInt("modify_user_info_bg", 0);
  }
  
  public static int bv() {
    return e().getInt("user_info_video_scan", 0);
  }
  
  public static int bw() {
    return e().getInt("image_gesture_guide_53", 0);
  }
  
  public static int bx() {
    return e().getInt("album_gesture_guide_53", 0);
  }
  
  public static int by() {
    return e().getInt("live_xiaomi_status", 0);
  }
  
  public static boolean bz() {
    return e().getBoolean("app_active", false);
  }
  
  public static SharedPreferences c() {
    if (b == null)
      b = AppInfo.d().getSharedPreferences("blued_sf_find_sift", 0); 
    return b;
  }
  
  public static void c(int paramInt) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("unit_setting_");
    stringBuilder.append(UserInfo.a().i().getUid());
    String str = stringBuilder.toString();
    e().edit().putInt(str, paramInt).commit();
  }
  
  public static void c(long paramLong) {
    h().edit().putLong(aZ, paramLong).commit();
  }
  
  public static void c(String paramString) {
    b().edit().putString(bT, paramString).commit();
  }
  
  public static void c(ArrayList<BluedADExtra> paramArrayList) {
    PreferenceAD preferenceAD = new PreferenceAD();
    preferenceAD.list = paramArrayList;
    String str = AppInfo.f().toJson(preferenceAD);
    a().edit().putString("FEED_BANNER_AD_JSON3", str).commit();
  }
  
  public static void c(boolean paramBoolean) {
    SharedPreferences.Editor editor = c().edit();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(UserInfo.a().i().getUid());
    stringBuilder.append(K);
    editor.putBoolean(stringBuilder.toString(), paramBoolean).commit();
  }
  
  public static boolean cA() {
    return e().getBoolean("SETTING_SWITCH_ACCOUNT_REMIND", false);
  }
  
  public static void cB() {
    e().edit().putBoolean("SETTING_SWITCH_ACCOUNT_REMIND", true).apply();
  }
  
  public static boolean cC() {
    return e().getBoolean("MINE_FEED_NEW_SHOW", true);
  }
  
  public static void cD() {
    e().edit().putBoolean("MINE_FEED_NEW_SHOW", false).apply();
  }
  
  public static boolean cE() {
    return e().getBoolean("svip_dot_show", true);
  }
  
  public static void cF() {
    e().edit().putBoolean("svip_dot_show", false).apply();
  }
  
  public static boolean cG() {
    return e().getBoolean("welcome_anim", false);
  }
  
  public static boolean cH() {
    return e().getBoolean("shadow_set_tips", true);
  }
  
  public static void cI() {
    e().edit().putBoolean("shadow_set_tips", false).apply();
  }
  
  public static long cJ() {
    return e().getLong("PUSH_CHECK_TIME", 0L);
  }
  
  public static long cK() {
    return e().getLong("PERMANENT_PUSH_CHECK_TIME", 0L);
  }
  
  public static long cL() {
    return e().getLong("LIVE_ATTENTION_CHECK_TIME", 0L);
  }
  
  public static long cM() {
    return e().getLong("MSG_CHECK_TIME", 0L);
  }
  
  public static boolean cN() {
    return e().getBoolean("VIP_COUPON_DOT_SHOWED1", false);
  }
  
  public static void cO() {
    e().edit().putBoolean("VIP_COUPON_DOT_SHOWED1", true).apply();
  }
  
  public static boolean cP() {
    return e().getBoolean("IS_CLOSE_IM_PROFILE_REMIND", false);
  }
  
  public static void cQ() {
    e().edit().putBoolean("IS_CLOSE_IM_PROFILE_REMIND", true).apply();
  }
  
  public static int cR() {
    return e().getInt("VISITOR_EDIT_TIP_SHOW_TIMES", 0);
  }
  
  public static long cS() {
    return e().getLong("VISITOR_EDIT_TIP_SHOW_TIME", 0L);
  }
  
  public static long cT() {
    return e().getLong("CALL_TIP_SHOW_TIME", 0L);
  }
  
  public static String cU() {
    return e().getString("CALL_TIP_SHOW_TIME_UID", "");
  }
  
  public static String cV() {
    return e().getString("MSG_BOX_SOURCE_STRING", "");
  }
  
  public static String cW() {
    return e().getString("MSG_BOX_DISTANCE", "");
  }
  
  public static boolean cX() {
    return e().getBoolean("IS_REQUEST_OPPO_MSG_PERMISSION", false);
  }
  
  public static void cY() {
    e().edit().putBoolean("IS_REQUEST_OPPO_MSG_PERMISSION", true).apply();
  }
  
  public static final boolean cZ() {
    return e().getBoolean("change_skin", false);
  }
  
  public static boolean ca() {
    return e().getBoolean("HAS_SHOW_MSG_MENU_RED_POINT_716", false);
  }
  
  public static void cb() {
    e().edit().putBoolean("HAS_SHOW_MSG_BOX_TV_HINT", true).commit();
  }
  
  public static final boolean cc() {
    return e().getBoolean("HAS_SHOW_MSG_BOX_TV_HINT", false);
  }
  
  public static int cd() {
    return e().getInt("CALL_HELLO_BTN_STATUS", 0);
  }
  
  public static void ce() {
    e().edit().putBoolean("IS_SHOW_FILTER_GREATER_SIX", true).apply();
  }
  
  public static boolean cf() {
    return e().getBoolean("IS_SHOW_FILTER_GREATER_SIX", false);
  }
  
  public static void cg() {
    e().edit().putBoolean("IS_SHOW_HOME_GUIDE_768", true).apply();
  }
  
  public static void ch() {
    e().edit().putBoolean("IS_CLEAR_FILTER_H_W_A", true).apply();
  }
  
  public static boolean ci() {
    return e().getBoolean("IS_CLEAR_FILTER_H_W_A", false);
  }
  
  public static String cj() {
    return e().getString("IS_SHOW_SELECT_GUIDE_CODE", "");
  }
  
  public static boolean ck() {
    return e().getBoolean("NEARBY_SORT_BY_FIRST_OPEN", true);
  }
  
  public static void cl() {
    e().edit().putBoolean("NEARBY_SORT_BY_FIRST_OPEN", false).commit();
  }
  
  public static boolean cm() {
    return e().getBoolean("CHAT_LIE_TOP_REMIND", false);
  }
  
  public static void cn() {
    e().edit().putBoolean("CHAT_LIE_TOP_REMIND", true).apply();
  }
  
  public static boolean co() {
    return e().getBoolean("CHAT_SETTING_LIE_TOP_REMIND", false);
  }
  
  public static void cp() {
    e().edit().putBoolean("CHAT_SETTING_LIE_TOP_REMIND", true).apply();
  }
  
  public static boolean cq() {
    return e().getBoolean("CHAT_SETTING_ENTER_SEND", false);
  }
  
  public static boolean cr() {
    return e().getBoolean("CHAT_SETTING_LISTEN_MODEL_REMIND", false);
  }
  
  public static void cs() {
    e().edit().putBoolean("CHAT_SETTING_LISTEN_MODEL_REMIND", true).apply();
  }
  
  public static boolean ct() {
    return e().getBoolean("blued_skin", false);
  }
  
  public static boolean cu() {
    return e().getBoolean("SETTING_TEXT_SIZE_DOT", false);
  }
  
  public static int cv() {
    return e().getInt("SETTING_TEXT_SIZE", 1);
  }
  
  public static boolean cw() {
    return e().getBoolean("SETTING_COMMON_NEW_706_REMIND", false);
  }
  
  public static void cx() {
    e().edit().putBoolean("SETTING_COMMON_NEW_706_REMIND", true).apply();
  }
  
  public static boolean cy() {
    return e().getBoolean("SETTING_COMMON_RETURN_SEND_REMIND", false);
  }
  
  public static void cz() {
    e().edit().putBoolean("SETTING_COMMON_RETURN_SEND_REMIND", true).apply();
  }
  
  public static SharedPreferences d() {
    if (c == null)
      c = AppInfo.d().getSharedPreferences("blued_sf_setting", 0); 
    return c;
  }
  
  public static void d(int paramInt) {
    SharedPreferences.Editor editor = e().edit();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(aA);
    stringBuilder.append(AppInfo.h);
    editor.putInt(stringBuilder.toString(), paramInt).commit();
  }
  
  public static void d(long paramLong) {
    i().edit().putLong(ba, paramLong).commit();
  }
  
  public static void d(String paramString) {
    SharedPreferences.Editor editor = b().edit();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(bV);
    stringBuilder.append((UserInfo.a().i()).uid);
    editor.putString(stringBuilder.toString(), paramString).commit();
  }
  
  public static void d(boolean paramBoolean) {
    SharedPreferences.Editor editor = c().edit();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(UserInfo.a().i().getUid());
    stringBuilder.append(L);
    editor.putBoolean(stringBuilder.toString(), paramBoolean).commit();
  }
  
  public static String dA() {
    return e().getString("NEARBY_CITY_CODE", "");
  }
  
  public static boolean dB() {
    SharedPreferences sharedPreferences = e();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("has_verify_mobile");
    stringBuilder.append((UserInfo.a().i()).uid);
    return sharedPreferences.getBoolean(stringBuilder.toString(), false);
  }
  
  public static boolean dC() {
    SharedPreferences sharedPreferences = e();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("has_used_mobile");
    stringBuilder.append((UserInfo.a().i()).uid);
    return sharedPreferences.getBoolean(stringBuilder.toString(), false);
  }
  
  public static void dD() {
    e().edit().putBoolean("NEARBY_HOME_TIP_NEED_SHOW", false).apply();
  }
  
  public static String dE() {
    return e().getString("dynamic_skin", "");
  }
  
  public static String dF() {
    return e().getString("avatar_widget", "");
  }
  
  public static boolean dG() {
    return e().getBoolean("NEARBY_HOME_DOT_NEED_SHOW", true);
  }
  
  public static void dH() {
    e().edit().putBoolean("NEARBY_HOME_DOT_NEED_SHOW", false).apply();
  }
  
  public static boolean dI() {
    return e().getBoolean("IS_SHOWED_FILTER_DOT", false);
  }
  
  public static void dJ() {
    e().edit().putBoolean("IS_SHOWED_FILTER_DOT", true).apply();
  }
  
  public static String dK() {
    return e().getString("blued_version_introduce", "");
  }
  
  public static boolean dL() {
    return e().getBoolean("MSG_BOX_TG", false);
  }
  
  public static long dM() {
    return e().getLong("MSG_BOX_OPEN_TIME", 0L);
  }
  
  public static int dN() {
    return e().getInt("blued_skin_name", 2131755667);
  }
  
  public static boolean dO() {
    return BluedSkinPreferences.a();
  }
  
  public static String dP() {
    return e().getString("HELLO_RANK_BY", "intelligent");
  }
  
  public static String dQ() {
    return e().getString("HELLO_ROLE", "");
  }
  
  public static long dR() {
    SharedPreferences sharedPreferences = e();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("IM_GIFT_GUIDE_TIME");
    stringBuilder.append((UserInfo.a().i()).uid);
    return sharedPreferences.getLong(stringBuilder.toString(), 0L);
  }
  
  public static String dS() {
    return e().getString("NEARBY_ACTIVITY_TITLE", "");
  }
  
  public static int dT() {
    return e().getInt("NEARBY_ACTIVITY_STAY_TIME", 0);
  }
  
  public static int dU() {
    return e().getInt("NEARBY_ACTIVITY_FREQUENCY_TYPE", 0);
  }
  
  public static Long dV() {
    return Long.valueOf(e().getLong("NEARBY_ACTIVITY_FREQUENCY_TIME", 0L));
  }
  
  public static Long dW() {
    return Long.valueOf(e().getLong("NEARBY_ACTIVITY_CURRENT_TIME", 0L));
  }
  
  public static boolean dX() {
    return e().getBoolean("IS_SHOW_SECRET_HINT", true);
  }
  
  public static void dY() {
    e().edit().putBoolean("IS_SHOW_IM_PIC_HINT", true).apply();
  }
  
  public static boolean dZ() {
    return e().getBoolean("IS_SHOWED_CUSTOMIZED_BUBBLE", false);
  }
  
  public static boolean da() {
    return e().getBoolean("IS_NEED_SYNC_REMIND_SETTING", true);
  }
  
  public static boolean db() {
    return e().getBoolean("IS_NEED_SYNC_GROUP_REMIND_SETTING", true);
  }
  
  public static void dc() {
    e().edit().putBoolean("IS_SHOW_MSG_BOX_FULL_GUIDE", true).apply();
  }
  
  public static boolean dd() {
    return e().getBoolean("IS_SHOW_CIRCLE_DETAIL_INPUT_GUIDE", false);
  }
  
  public static void de() {
    e().edit().putBoolean("IS_SHOW_CIRCLE_DETAIL_INPUT_GUIDE", true).apply();
  }
  
  public static boolean df() {
    String str = (new SimpleDateFormat("yyyy-MM-dd")).format(new Date(System.currentTimeMillis()));
    SharedPreferences sharedPreferences = e();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("AD_CLOSE_POP");
    stringBuilder.append(str);
    return sharedPreferences.getBoolean(stringBuilder.toString(), false);
  }
  
  public static void dg() {
    String str = (new SimpleDateFormat("yyyy-MM-dd")).format(new Date(System.currentTimeMillis()));
    SharedPreferences.Editor editor = e().edit();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("AD_CLOSE_POP");
    stringBuilder.append(str);
    editor.putBoolean(stringBuilder.toString(), true).apply();
  }
  
  public static boolean dh() {
    return e().getBoolean("remind_login_mobile", true);
  }
  
  public static boolean di() {
    return e().getBoolean("remind_common_mobile", true);
  }
  
  public static boolean dj() {
    return e().getBoolean("LIVE_TWO_LEVEL_GUIDE", false);
  }
  
  public static void dk() {
    e().edit().putBoolean("LIVE_TWO_LEVEL_GUIDE", true).apply();
  }
  
  public static boolean dl() {
    return e().getBoolean("health_tips", false);
  }
  
  public static void dm() {
    e().edit().putBoolean("health_tips", true).apply();
  }
  
  public static boolean dn() {
    return e().getBoolean("set_avatar_widget", false);
  }
  
  public static void do() {
    e().edit().putBoolean("set_avatar_widget", true).apply();
  }
  
  public static boolean dp() {
    return e().getBoolean("set_avatar_widget_click", false);
  }
  
  public static void dq() {
    e().edit().putBoolean("set_avatar_widget_click", true).apply();
  }
  
  public static boolean dr() {
    return e().getBoolean("set_avatar_widget_long", false);
  }
  
  public static void ds() {
    e().edit().putBoolean("set_avatar_widget_long", true).apply();
  }
  
  public static boolean dt() {
    return e().getBoolean("set_avatar_widget_long_click", false);
  }
  
  public static void du() {
    e().edit().putBoolean("set_avatar_widget_long_click", true).apply();
  }
  
  public static boolean dv() {
    return e().getBoolean("fans_list_dot", false);
  }
  
  public static void dw() {
    e().edit().putBoolean("fans_list_dot", true).apply();
  }
  
  public static int dx() {
    SharedPreferences sharedPreferences = e();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("USER_GIFT_PAY_TYPE");
    stringBuilder.append((UserInfo.a().i()).uid);
    return sharedPreferences.getInt(stringBuilder.toString(), 0);
  }
  
  public static boolean dy() {
    return e().getBoolean("IS_REQUEST_OPPO_MSG_PERMISSION", false);
  }
  
  public static void dz() {
    e().edit().putBoolean("IS_REQUEST_OPPO_MSG_PERMISSION", true).apply();
  }
  
  public static SharedPreferences e() {
    if (d == null)
      d = PreferenceManager.getDefaultSharedPreferences(AppInfo.d()); 
    return d;
  }
  
  public static void e(long paramLong) {
    e().edit().putLong(bm, paramLong).commit();
  }
  
  public static void e(String paramString) {
    SharedPreferences.Editor editor = b().edit();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(UserInfo.a().i().getUid());
    stringBuilder.append(x);
    editor.putString(stringBuilder.toString(), paramString).commit();
  }
  
  public static void e(boolean paramBoolean) {
    SharedPreferences.Editor editor = c().edit();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(UserInfo.a().i().getUid());
    stringBuilder.append(R);
    editor.putBoolean(stringBuilder.toString(), paramBoolean).commit();
  }
  
  public static boolean e(int paramInt) {
    SharedPreferences sharedPreferences = e();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(bd);
    stringBuilder.append(paramInt);
    return sharedPreferences.getBoolean(stringBuilder.toString(), true);
  }
  
  public static boolean eA() {
    return e().getBoolean(bK, true);
  }
  
  public static boolean eB() {
    return e().getBoolean(bL, true);
  }
  
  public static void eC() {
    e().edit().putBoolean(bL, false).apply();
  }
  
  public static void eD() {
    e().edit().putBoolean(bM, false).commit();
  }
  
  public static boolean eE() {
    return e().getBoolean(bM, true);
  }
  
  public static boolean eF() {
    return e().getBoolean(bO, true);
  }
  
  public static void eG() {
    e().edit().putBoolean(bO, false).commit();
  }
  
  public static boolean eH() {
    return (aA() == 1 && e().getBoolean(bP, true));
  }
  
  public static void eI() {
    e().edit().putBoolean(bP, false).commit();
  }
  
  public static void eJ() {
    e().edit().putBoolean(bR, false).commit();
  }
  
  public static boolean eK() {
    return e().getBoolean(bR, true);
  }
  
  public static void eL() {
    e().edit().putBoolean(bS, true).apply();
  }
  
  public static boolean eM() {
    return e().getBoolean(bS, false);
  }
  
  public static void ea() {
    e().edit().putBoolean("IS_SHOWED_CUSTOMIZED_BUBBLE", true).apply();
  }
  
  public static boolean eb() {
    return e().getBoolean("IS_SHOWED_AVATAR_WIDGET", false);
  }
  
  public static void ec() {
    e().edit().putBoolean("IS_SHOWED_AVATAR_WIDGET", true).apply();
  }
  
  public static boolean ed() {
    SharedPreferences sharedPreferences = e();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("IS_SHOWED_CALL_OPEN");
    stringBuilder.append((UserInfo.a().i()).uid);
    return sharedPreferences.getBoolean(stringBuilder.toString(), false);
  }
  
  public static void ee() {
    SharedPreferences.Editor editor = e().edit();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("IS_SHOWED_CALL_OPEN");
    stringBuilder.append((UserInfo.a().i()).uid);
    editor.putBoolean(stringBuilder.toString(), true).apply();
  }
  
  public static boolean ef() {
    return e().getBoolean("IS_SHOWED_CUSTOMIZED_FEED_BG", false);
  }
  
  public static void eg() {
    e().edit().putBoolean("IS_SHOWED_CUSTOMIZED_FEED_BG", true).apply();
  }
  
  public static boolean eh() {
    return e().getBoolean(bs, true);
  }
  
  public static void ei() {
    e().edit().putBoolean(bs, false).apply();
  }
  
  public static int ej() {
    return e().getInt(bt, 0);
  }
  
  public static boolean ek() {
    SharedPreferences sharedPreferences = e();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(bu);
    stringBuilder.append((UserInfo.a().i()).uid);
    return sharedPreferences.getBoolean(stringBuilder.toString(), false);
  }
  
  public static boolean el() {
    SharedPreferences sharedPreferences = e();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(bv);
    stringBuilder.append((UserInfo.a().i()).uid);
    return sharedPreferences.getBoolean(stringBuilder.toString(), false);
  }
  
  public static boolean em() {
    return e().getBoolean(bw, false);
  }
  
  public static void en() {
    e().edit().putBoolean(bw, true).apply();
  }
  
  public static boolean eo() {
    return e().getBoolean(bx, false);
  }
  
  public static void ep() {
    e().edit().putBoolean(bx, true).commit();
  }
  
  public static boolean eq() {
    return e().getBoolean(by, false);
  }
  
  public static void er() {
    e().edit().putBoolean(by, true).commit();
  }
  
  public static boolean es() {
    return e().getBoolean(bz, false);
  }
  
  public static void et() {
    e().edit().putBoolean(bz, true).commit();
  }
  
  public static String eu() {
    SharedPreferences sharedPreferences = e();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(bA);
    stringBuilder.append((UserInfo.a().i()).uid);
    return sharedPreferences.getString(stringBuilder.toString(), "");
  }
  
  public static String ev() {
    return e().getString(bC, "");
  }
  
  public static boolean ew() {
    return a().getBoolean(bG, false);
  }
  
  public static void ex() {
    a().edit().putBoolean(bG, true).apply();
  }
  
  public static String ey() {
    return e().getString(bI, "");
  }
  
  public static boolean ez() {
    SharedPreferences sharedPreferences = e();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(bJ);
    stringBuilder.append((UserInfo.a().i()).uid);
    return sharedPreferences.getBoolean(stringBuilder.toString(), false);
  }
  
  public static SharedPreferences f() {
    if (f == null)
      f = AppInfo.d().getSharedPreferences("blued_sf_pattern_lock", 0); 
    return f;
  }
  
  public static String f(long paramLong) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("download_id_");
    stringBuilder.append(paramLong);
    String str = stringBuilder.toString();
    return e().getString(str, "");
  }
  
  public static void f(int paramInt) {
    SharedPreferences.Editor editor = e().edit();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(bd);
    stringBuilder.append(paramInt);
    editor.putBoolean(stringBuilder.toString(), false).commit();
  }
  
  public static void f(String paramString) {
    b().edit().putString(y, paramString).commit();
  }
  
  public static void f(boolean paramBoolean) {
    d().edit().putBoolean(W, paramBoolean).commit();
  }
  
  public static SharedPreferences g() {
    if (g == null)
      g = AppInfo.d().getSharedPreferences("blued_sf_gesture_pattern", 0); 
    return g;
  }
  
  public static void g(int paramInt) {
    k().edit().putInt(bh, paramInt).commit();
  }
  
  public static void g(long paramLong) {
    e().edit().putLong("FEED_PROMOTION_TIME", paramLong).commit();
  }
  
  public static void g(String paramString) {
    b().edit().putString(z, paramString).commit();
  }
  
  public static void g(boolean paramBoolean) {
    d().edit().putBoolean(Y, paramBoolean).commit();
  }
  
  public static SharedPreferences h() {
    if (h == null)
      h = AppInfo.d().getSharedPreferences("blued_sf_exit", 0); 
    return h;
  }
  
  public static void h(int paramInt) {
    k().edit().putInt(bj, paramInt).commit();
  }
  
  public static void h(long paramLong) {
    e().edit().putLong("PUSH_CHECK_TIME", paramLong).apply();
  }
  
  public static void h(String paramString) {
    SharedPreferences.Editor editor = c().edit();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(UserInfo.a().i().getUid());
    stringBuilder.append(C);
    editor.putString(stringBuilder.toString(), paramString).commit();
  }
  
  public static void h(boolean paramBoolean) {
    d().edit().putBoolean(Z, paramBoolean).commit();
  }
  
  public static SharedPreferences i() {
    if (i == null)
      i = AppInfo.d().getSharedPreferences("blued_sf_emotions_pack", 0); 
    return i;
  }
  
  public static void i(int paramInt) {
    e().edit().putInt("blued_chat_host_port", paramInt).commit();
  }
  
  public static void i(long paramLong) {
    e().edit().putLong("PERMANENT_PUSH_CHECK_TIME", paramLong).apply();
  }
  
  public static void i(String paramString) {
    SharedPreferences.Editor editor = c().edit();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(UserInfo.a().i().getUid());
    stringBuilder.append(E);
    editor.putString(stringBuilder.toString(), paramString).commit();
  }
  
  public static void i(boolean paramBoolean) {
    d().edit().putBoolean(ac, paramBoolean).commit();
  }
  
  public static SharedPreferences j() {
    if (j == null)
      j = AppInfo.d().getSharedPreferences("removed_def_emotion_packs", 0); 
    return j;
  }
  
  public static void j(int paramInt) {
    e().edit().putInt("blued_chat_backup_port", paramInt).commit();
  }
  
  public static void j(long paramLong) {
    e().edit().putLong("LIVE_ATTENTION_CHECK_TIME", paramLong).apply();
  }
  
  public static void j(String paramString) {
    SharedPreferences.Editor editor = c().edit();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(UserInfo.a().i().getUid());
    stringBuilder.append(F);
    editor.putString(stringBuilder.toString(), paramString).commit();
  }
  
  public static void j(boolean paramBoolean) {
    d().edit().putBoolean(ad, paramBoolean).commit();
  }
  
  public static SharedPreferences k() {
    if (k == null)
      k = AppInfo.d().getSharedPreferences("blued_sf_general_set", 0); 
    return k;
  }
  
  public static void k(int paramInt) {
    e().edit().putInt("live_rank_value", paramInt).commit();
  }
  
  public static void k(long paramLong) {
    e().edit().putLong("MSG_CHECK_TIME", paramLong).apply();
  }
  
  public static void k(String paramString) {
    SharedPreferences.Editor editor = c().edit();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(UserInfo.a().i().getUid());
    stringBuilder.append(G);
    editor.putString(stringBuilder.toString(), paramString).commit();
  }
  
  public static void k(boolean paramBoolean) {
    d().edit().putBoolean(ae, paramBoolean).commit();
  }
  
  public static void l(int paramInt) {
    e().edit().putInt("modify_user_info_bg", paramInt).commit();
  }
  
  public static void l(long paramLong) {
    e().edit().putLong("VISITOR_EDIT_TIP_SHOW_TIME", paramLong).apply();
  }
  
  public static void l(String paramString) {
    SharedPreferences.Editor editor = c().edit();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(UserInfo.a().i().getUid());
    stringBuilder.append(H);
    editor.putString(stringBuilder.toString(), paramString).commit();
  }
  
  public static void l(boolean paramBoolean) {
    d().edit().putBoolean(af, paramBoolean).commit();
  }
  
  public static boolean l() {
    long l1;
    long l2 = e().getLong(m, 0L) / 1000L;
    long l3 = System.currentTimeMillis() / 1000L;
    if (AppInfo.m()) {
      l1 = 60L;
    } else {
      l1 = 86400L;
    } 
    return (l3 - l2 >= l1);
  }
  
  public static void m() {
    int i = b().getInt(n, 0);
    b().edit().putInt(n, i + 1).commit();
  }
  
  public static void m(int paramInt) {
    e().edit().putInt("image_gesture_guide_53", paramInt).commit();
  }
  
  public static void m(long paramLong) {
    e().edit().putLong("CALL_TIP_SHOW_TIME", paramLong).apply();
  }
  
  public static void m(String paramString) {
    SharedPreferences.Editor editor = c().edit();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(UserInfo.a().i().getUid());
    stringBuilder.append(I);
    editor.putString(stringBuilder.toString(), paramString).commit();
  }
  
  public static void m(boolean paramBoolean) {
    d().edit().putBoolean(ag, paramBoolean).commit();
  }
  
  public static int n() {
    return b().getInt(n, 0);
  }
  
  public static void n(int paramInt) {
    e().edit().putInt("album_gesture_guide_53", paramInt).commit();
  }
  
  public static void n(long paramLong) {
    e().edit().putLong("MSG_BOX_GUIDE_TIME", paramLong).apply();
  }
  
  public static void n(String paramString) {
    SharedPreferences.Editor editor = c().edit();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(UserInfo.a().i().getUid());
    stringBuilder.append(M);
    editor.putString(stringBuilder.toString(), paramString).commit();
  }
  
  public static void n(boolean paramBoolean) {
    d().edit().putBoolean(ah, paramBoolean).commit();
  }
  
  public static void o() {
    e().edit().putLong(m, System.currentTimeMillis()).apply();
    SharedPreferences.Editor editor = b().edit();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(o);
    stringBuilder.append(n());
    editor.putBoolean(stringBuilder.toString(), true).commit();
  }
  
  public static void o(int paramInt) {
    e().edit().putInt("live_xiaomi_status", paramInt).commit();
  }
  
  public static void o(long paramLong) {
    e().edit().putLong("MSG_BOX_OPEN_TIME", paramLong).apply();
  }
  
  public static void o(String paramString) {
    SharedPreferences.Editor editor = c().edit();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(UserInfo.a().i().getUid());
    stringBuilder.append(N);
    editor.putString(stringBuilder.toString(), paramString).commit();
  }
  
  public static void o(boolean paramBoolean) {
    d().edit().putBoolean(ai, paramBoolean).commit();
  }
  
  public static void p(int paramInt) {
    e().edit().putInt("live_is_soft", paramInt).commit();
  }
  
  public static void p(long paramLong) {
    SharedPreferences.Editor editor = e().edit();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("IM_GIFT_GUIDE_TIME");
    stringBuilder.append((UserInfo.a().i()).uid);
    editor.putLong(stringBuilder.toString(), paramLong).apply();
  }
  
  public static void p(String paramString) {
    Logger.a("save_tag", paramString);
    SharedPreferences.Editor editor = c().edit();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(UserInfo.a().i().getUid());
    stringBuilder.append(O);
    editor.putString(stringBuilder.toString(), paramString).commit();
  }
  
  public static void p(boolean paramBoolean) {
    d().edit().putBoolean(aj, paramBoolean).commit();
  }
  
  public static boolean p() {
    SharedPreferences sharedPreferences = b();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(o);
    stringBuilder.append(n());
    return sharedPreferences.getBoolean(stringBuilder.toString(), false);
  }
  
  public static void q() {
    e().edit().putLong(m, System.currentTimeMillis()).apply();
    SharedPreferences.Editor editor = b().edit();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(p);
    stringBuilder.append(n());
    editor.putBoolean(stringBuilder.toString(), true).commit();
  }
  
  public static void q(int paramInt) {
    e().edit().putInt("live_is_beauty", paramInt).commit();
  }
  
  public static void q(long paramLong) {
    e().edit().putLong("NEARBY_ACTIVITY_FREQUENCY_TIME", paramLong).apply();
  }
  
  public static void q(String paramString) {
    SharedPreferences.Editor editor = c().edit();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(UserInfo.a().i().getUid());
    stringBuilder.append(P);
    editor.putString(stringBuilder.toString(), paramString).commit();
  }
  
  public static void q(boolean paramBoolean) {
    d().edit().putBoolean(ak, paramBoolean).apply();
  }
  
  public static void r(int paramInt) {
    e().edit().putInt("UPDATE_TIPS_TIMES", paramInt).commit();
  }
  
  public static void r(long paramLong) {
    e().edit().putLong("NEARBY_ACTIVITY_CURRENT_TIME", paramLong).apply();
  }
  
  public static void r(String paramString) {
    SharedPreferences.Editor editor = c().edit();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(UserInfo.a().i().getUid());
    stringBuilder.append(Q);
    editor.putString(stringBuilder.toString(), paramString).commit();
  }
  
  public static void r(boolean paramBoolean) {
    d().edit().putBoolean(al, paramBoolean).apply();
  }
  
  public static boolean r() {
    SharedPreferences sharedPreferences = b();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(p);
    stringBuilder.append(n());
    return sharedPreferences.getBoolean(stringBuilder.toString(), false);
  }
  
  public static long s(long paramLong) {
    SharedPreferences sharedPreferences = e();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(bQ);
    stringBuilder.append(paramLong);
    return sharedPreferences.getLong(stringBuilder.toString(), 0L);
  }
  
  public static String s() {
    return b().getString(r, "0");
  }
  
  public static void s(int paramInt) {
    SharedPreferences.Editor editor = e().edit();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("PRIVILEGE_BUY_PAY_TYPE");
    stringBuilder.append((UserInfo.a().i()).uid);
    editor.putInt(stringBuilder.toString(), paramInt).commit();
  }
  
  public static void s(String paramString) {
    SharedPreferences.Editor editor = c().edit();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(UserInfo.a().i().getUid());
    stringBuilder.append(S);
    editor.putString(stringBuilder.toString(), paramString).commit();
  }
  
  public static void s(boolean paramBoolean) {
    d().edit().putBoolean(am, paramBoolean).apply();
  }
  
  public static String t() {
    return b().getString(s, "0");
  }
  
  public static void t(int paramInt) {
    e().edit().putInt("CALL_HELLO_BTN_STATUS", paramInt).apply();
  }
  
  public static void t(long paramLong) {
    SharedPreferences.Editor editor = e().edit();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(bQ);
    stringBuilder.append(paramLong);
    editor.remove(stringBuilder.toString()).apply();
  }
  
  public static void t(String paramString) {
    SharedPreferences.Editor editor = c().edit();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(UserInfo.a().i().getUid());
    stringBuilder.append(T);
    editor.putString(stringBuilder.toString(), paramString).commit();
  }
  
  public static void t(boolean paramBoolean) {
    d().edit().putBoolean(an, paramBoolean).apply();
  }
  
  public static String u() {
    return b().getString(t, "");
  }
  
  public static void u(int paramInt) {
    e().edit().putInt("SETTING_TEXT_SIZE", paramInt).apply();
  }
  
  public static void u(String paramString) {
    SharedPreferences.Editor editor = c().edit();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(UserInfo.a().i().getUid());
    stringBuilder.append(U);
    editor.putString(stringBuilder.toString(), paramString).commit();
  }
  
  public static void u(boolean paramBoolean) {
    d().edit().putBoolean(bW, paramBoolean).apply();
  }
  
  public static String v() {
    return b().getString(bT, "");
  }
  
  public static void v(int paramInt) {
    e().edit().putInt("VISITOR_EDIT_TIP_SHOW_TIMES", paramInt).apply();
  }
  
  @Deprecated
  public static void v(String paramString) {
    d().edit().putString(X, paramString).commit();
  }
  
  public static void v(boolean paramBoolean) {
    String str1;
    SharedPreferences.Editor editor = d().edit();
    String str2 = aq;
    if (paramBoolean) {
      str1 = "yes";
    } else {
      str1 = "no";
    } 
    editor.putString(str2, str1).commit();
  }
  
  public static String w(String paramString) {
    SharedPreferences sharedPreferences = d();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(X);
    stringBuilder.append(paramString);
    return sharedPreferences.getString(stringBuilder.toString(), "");
  }
  
  public static void w() {
    b().edit().remove(bT).commit();
  }
  
  public static void w(int paramInt) {
    SharedPreferences.Editor editor = e().edit();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("USER_GIFT_PAY_TYPE");
    stringBuilder.append((UserInfo.a().i()).uid);
    editor.putInt(stringBuilder.toString(), paramInt).apply();
  }
  
  public static void w(boolean paramBoolean) {
    e().edit().putBoolean(at, paramBoolean).commit();
  }
  
  public static String x() {
    SharedPreferences sharedPreferences = b();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(bU);
    stringBuilder.append((UserInfo.a().i()).uid);
    return sharedPreferences.getString(stringBuilder.toString(), "");
  }
  
  public static void x(int paramInt) {
    e().edit().putInt("blued_skin_name", paramInt).apply();
  }
  
  public static void x(String paramString) {
    e().edit().putString(az, paramString).commit();
  }
  
  public static void x(boolean paramBoolean) {
    e().edit().putBoolean(aV, paramBoolean).commit();
  }
  
  public static String y() {
    SharedPreferences sharedPreferences = b();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(bV);
    stringBuilder.append((UserInfo.a().i()).uid);
    return sharedPreferences.getString(stringBuilder.toString(), "");
  }
  
  public static void y(int paramInt) {
    e().edit().putInt("NEARBY_ACTIVITY_STAY_TIME", paramInt).apply();
  }
  
  public static void y(String paramString) {
    SharedPreferences.Editor editor = e().edit();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(UserInfo.a().i().getUid());
    stringBuilder.append(aI);
    editor.putString(stringBuilder.toString(), paramString).commit();
  }
  
  public static void y(boolean paramBoolean) {
    f().edit().putBoolean(aW, paramBoolean).commit();
  }
  
  public static void z() {
    SharedPreferences.Editor editor = b().edit();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(bV);
    stringBuilder.append((UserInfo.a().i()).uid);
    editor.remove(stringBuilder.toString()).commit();
  }
  
  public static void z(int paramInt) {
    e().edit().putInt("NEARBY_ACTIVITY_FREQUENCY_TYPE", paramInt).apply();
  }
  
  public static void z(String paramString) {
    e().edit().putString(aJ, paramString).commit();
  }
  
  public static void z(boolean paramBoolean) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("lock_onoff_");
    stringBuilder.append(UserInfo.a().i().getUid());
    String str = stringBuilder.toString();
    f().edit().putBoolean(str, paramBoolean).commit();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\utils\BluedPreferences.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */