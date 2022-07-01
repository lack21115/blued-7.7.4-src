package com.blued.android.module.live_china.utils;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import com.blued.android.core.AppInfo;
import com.blued.android.module.live.base.utils.LiveBasePreferences;
import com.blued.android.module.live_china.live_info.LiveRoomInfo;

public class LiveRoomPreferences {
  public static SharedPreferences a;
  
  public static SharedPreferences b;
  
  public static SharedPreferences c;
  
  public static String d = "recommend_live";
  
  public static String e = "SHOWED_LIVE_TIPS_REMIND";
  
  public static String f = "FIREST_LIVE_CACEL";
  
  public static String g = "select_photo_new";
  
  public static String h = "zan_res";
  
  public static String i = "SHOWED_USER_TAB_DOT1";
  
  public static String j = "SHOWED_MY_GIFT_DOT";
  
  public static String k = "SHOWED_SHARE_HINT";
  
  public static void A(String paramString) {
    c().edit().putString("LIVE_MUSIC_SEARCH_HISTORY", paramString).apply();
  }
  
  public static boolean A() {
    return c().getBoolean("live_switch_clear_cue", false);
  }
  
  public static boolean B() {
    return c().getBoolean("live_recommend_tips1", true);
  }
  
  public static void C() {
    c().edit().putBoolean("live_recommend_tips1", false).commit();
  }
  
  public static boolean D() {
    return c().getBoolean("live_recommend_tips2", true);
  }
  
  public static void E() {
    c().edit().putBoolean("live_recommend_tips2", false).commit();
  }
  
  public static boolean F() {
    return b().getBoolean(k, true);
  }
  
  public static boolean G() {
    return c().getBoolean("LIVE_FANS_REOPEN_GUIDE", false);
  }
  
  public static void H() {
    c().edit().putBoolean("LIVE_FANS_REOPEN_GUIDE", true).apply();
  }
  
  public static boolean I() {
    return c().getBoolean("LIVE_FANS_ENTER_GUIDE", false);
  }
  
  public static void J() {
    c().edit().putBoolean("LIVE_FANS_ENTER_GUIDE", true).apply();
  }
  
  public static boolean K() {
    return c().getBoolean("LIVE_FANS_LEVEL_ENTER_GUIDE", false);
  }
  
  public static void L() {
    c().edit().putBoolean("LIVE_FANS_LEVEL_ENTER_GUIDE", true).apply();
  }
  
  public static boolean M() {
    return c().getBoolean("LIVE_FANS_LEVEL_16_GUIDE", false);
  }
  
  public static void N() {
    c().edit().putBoolean("LIVE_FANS_LEVEL_16_GUIDE", true).apply();
  }
  
  public static boolean O() {
    long l = c().getLong("LIVE_GIFT_TASK_TODAY", 0L);
    return (System.currentTimeMillis() - l > 86400000L);
  }
  
  public static void P() {
    c().edit().putLong("LIVE_GIFT_TASK_TODAY", System.currentTimeMillis()).apply();
  }
  
  public static boolean Q() {
    long l = c().getLong("LIVE_GIFT_TASK_YING_GUANG", 0L);
    return (System.currentTimeMillis() - l > 86400000L);
  }
  
  public static void R() {
    c().edit().putLong("LIVE_GIFT_TASK_YING_GUANG", System.currentTimeMillis()).apply();
  }
  
  public static String S() {
    return c().getString("LIVE_MUSIC_SEARCH_HISTORY", "");
  }
  
  public static boolean T() {
    return c().getBoolean("LIVE_REWARD_TIP", false);
  }
  
  public static void U() {
    c().edit().putBoolean("LIVE_REWARD_TIP", true).apply();
  }
  
  public static SharedPreferences a() {
    if (a == null)
      a = AppInfo.d().getSharedPreferences("blued_sf", 0); 
    return a;
  }
  
  public static void a(int paramInt) {
    c().edit().putInt("live_game_details", paramInt).commit();
  }
  
  public static void a(String paramString) {
    a().edit().putString(h, paramString).commit();
  }
  
  public static void a(String paramString, int paramInt) {
    c().edit().putInt(paramString, paramInt).commit();
  }
  
  public static void a(boolean paramBoolean) {
    c().edit().putBoolean("live_set_nearby", paramBoolean).commit();
  }
  
  public static SharedPreferences b() {
    if (b == null)
      b = AppInfo.d().getSharedPreferences("blued_sf_setting", 0); 
    return b;
  }
  
  public static String b(String paramString) {
    return LiveBasePreferences.a(paramString);
  }
  
  public static void b(int paramInt) {
    c().edit().putInt("live_lover_details", paramInt).commit();
  }
  
  public static void b(String paramString, int paramInt) {
    c().edit().putInt(paramString, paramInt).commit();
  }
  
  public static void b(boolean paramBoolean) {
    c().edit().putBoolean("live_switch_clear_cue", paramBoolean).commit();
  }
  
  public static SharedPreferences c() {
    if (c == null)
      c = PreferenceManager.getDefaultSharedPreferences(AppInfo.d()); 
    return c;
  }
  
  public static void c(int paramInt) {
    c().edit().putInt("live_reward_condition", paramInt).commit();
  }
  
  public static void c(String paramString) {
    LiveBasePreferences.b(paramString);
  }
  
  public static void c(String paramString, int paramInt) {
    c().edit().putInt(paramString, paramInt).commit();
  }
  
  public static void c(boolean paramBoolean) {
    b().edit().putBoolean(k, paramBoolean).commit();
  }
  
  public static String d() {
    return a().getString(h, "");
  }
  
  public static void d(int paramInt) {
    c().edit().putInt("live_beauty_function_record", paramInt).commit();
  }
  
  public static void d(String paramString) {
    c().edit().putString("live_share", paramString).commit();
  }
  
  public static void d(String paramString, int paramInt) {
    c().edit().putInt(paramString, paramInt).commit();
  }
  
  public static void d(boolean paramBoolean) {
    c().edit().putBoolean("LIVE_LIANG_EXPIRE", paramBoolean).apply();
  }
  
  public static int e(String paramString) {
    return c().getInt(paramString, 5);
  }
  
  public static String e() {
    return c().getString("live_share", "");
  }
  
  public static void e(int paramInt) {
    c().edit().putInt("LIVE_PK_TIPS_RECORD", paramInt).commit();
  }
  
  public static void e(String paramString, int paramInt) {
    c().edit().putInt(paramString, paramInt).commit();
  }
  
  public static int f() {
    return c().getInt("live_game_details", 0);
  }
  
  public static int f(String paramString) {
    return c().getInt(paramString, 40);
  }
  
  public static void f(int paramInt) {
    c().edit().putInt("live_pk_tips_play", paramInt).commit();
  }
  
  public static void f(String paramString, int paramInt) {
    c().edit().putInt(paramString, paramInt).commit();
  }
  
  public static int g() {
    return c().getInt("live_lover_details", 0);
  }
  
  public static int g(String paramString) {
    return c().getInt(paramString, 75);
  }
  
  public static void g(int paramInt) {
    c().edit().putInt("live_pk_new_icon", paramInt).commit();
  }
  
  public static void g(String paramString, int paramInt) {
    c().edit().putInt(paramString, paramInt).commit();
  }
  
  public static int h() {
    return c().getInt("live_reward_condition", 0);
  }
  
  public static int h(String paramString) {
    return c().getInt(paramString, 0);
  }
  
  public static void h(int paramInt) {
    c().edit().putInt("live_pk_center_new_icon", paramInt).commit();
  }
  
  public static void h(String paramString, int paramInt) {
    c().edit().putInt(paramString, paramInt).commit();
  }
  
  public static int i() {
    return c().getInt("live_beauty_function_record", 0);
  }
  
  public static int i(String paramString) {
    return c().getInt(paramString, 10);
  }
  
  public static void i(int paramInt) {
    c().edit().putInt("live_center_make_friend_new_icon", paramInt).commit();
  }
  
  public static void i(String paramString, int paramInt) {
    c().edit().putInt(paramString, paramInt).commit();
  }
  
  public static int j() {
    return c().getInt("LIVE_PK_TIPS_RECORD", 0);
  }
  
  public static int j(String paramString) {
    return c().getInt(paramString, 15);
  }
  
  public static void j(int paramInt) {
    c().edit().putInt("live_xiaomi_status", paramInt).commit();
  }
  
  public static void j(String paramString, int paramInt) {
    c().edit().putInt(paramString, paramInt).commit();
  }
  
  public static int k() {
    return c().getInt("live_pk_tips_play", 0);
  }
  
  public static int k(String paramString) {
    return c().getInt(paramString, 10);
  }
  
  public static void k(int paramInt) {
    SharedPreferences.Editor editor = c().edit();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("live_first_charge_");
    stringBuilder.append(LiveRoomInfo.a().f());
    editor.putInt(stringBuilder.toString(), paramInt).commit();
  }
  
  public static void k(String paramString, int paramInt) {
    c().edit().putInt(paramString, paramInt).commit();
  }
  
  public static int l() {
    return c().getInt("live_pk_new_icon", 0);
  }
  
  public static int l(String paramString) {
    return c().getInt(paramString, 0);
  }
  
  public static void l(int paramInt) {
    SharedPreferences.Editor editor = c().edit();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("live_first_charge_time_");
    stringBuilder.append(LiveRoomInfo.a().f());
    editor.putInt(stringBuilder.toString(), paramInt).commit();
  }
  
  public static void l(String paramString, int paramInt) {
    c().edit().putInt(paramString, paramInt).commit();
  }
  
  public static int m() {
    return c().getInt("live_beauty_dreamy", 0);
  }
  
  public static int m(String paramString) {
    return c().getInt(paramString, 0);
  }
  
  public static void m(int paramInt) {
    SharedPreferences.Editor editor = c().edit();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("live_first_charge_room_time_");
    stringBuilder.append(LiveRoomInfo.a().f());
    editor.putInt(stringBuilder.toString(), paramInt).commit();
  }
  
  public static void m(String paramString, int paramInt) {
    c().edit().putInt(paramString, paramInt).commit();
  }
  
  public static int n() {
    return c().getInt("live_beauty_purple", 0);
  }
  
  public static int n(String paramString) {
    return c().getInt(paramString, 0);
  }
  
  public static void n(int paramInt) {
    SharedPreferences.Editor editor = c().edit();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("live_first_charge_icon_time_");
    stringBuilder.append(LiveRoomInfo.a().f());
    editor.putInt(stringBuilder.toString(), paramInt).commit();
  }
  
  public static void n(String paramString, int paramInt) {
    c().edit().putInt(paramString, paramInt).commit();
  }
  
  public static int o() {
    return c().getInt("live_beauty_cold", 0);
  }
  
  public static int o(String paramString) {
    return c().getInt(paramString, 0);
  }
  
  public static void o(String paramString, int paramInt) {
    c().edit().putInt(paramString, paramInt).commit();
  }
  
  public static int p(String paramString) {
    return c().getInt(paramString, 0);
  }
  
  public static String p() {
    return c().getString("live_beauty_code_sense", "");
  }
  
  public static void p(String paramString, int paramInt) {
    c().edit().putInt(paramString, paramInt).commit();
  }
  
  public static int q(String paramString) {
    return c().getInt(paramString, 0);
  }
  
  public static String q() {
    SharedPreferences sharedPreferences = c();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("live_record_level_sticker");
    stringBuilder.append(LiveRoomInfo.a().f());
    return sharedPreferences.getString(stringBuilder.toString(), "");
  }
  
  public static void q(String paramString, int paramInt) {
    c().edit().putInt(paramString, paramInt).commit();
  }
  
  public static int r(String paramString) {
    return c().getInt(paramString, 0);
  }
  
  public static String r() {
    SharedPreferences sharedPreferences = c();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("live_record_level_gesture");
    stringBuilder.append(LiveRoomInfo.a().f());
    return sharedPreferences.getString(stringBuilder.toString(), "");
  }
  
  public static void r(String paramString, int paramInt) {
    c().edit().putInt(paramString, paramInt).commit();
  }
  
  public static int s(String paramString) {
    return c().getInt(paramString, 60);
  }
  
  public static String s() {
    SharedPreferences sharedPreferences = c();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("live_record_level_sticker_location");
    stringBuilder.append(LiveRoomInfo.a().f());
    return sharedPreferences.getString(stringBuilder.toString(), "");
  }
  
  public static void s(String paramString, int paramInt) {
    c().edit().putInt(paramString, paramInt).commit();
  }
  
  public static int t() {
    return c().getInt("live_xiaomi_status", 0);
  }
  
  public static int t(String paramString) {
    return c().getInt(paramString, 60);
  }
  
  public static int u(String paramString) {
    return c().getInt(paramString, 60);
  }
  
  public static boolean u() {
    return c().getBoolean("live_set_nearby", true);
  }
  
  public static int v() {
    return c().getInt("live_is_beauty", 0);
  }
  
  public static int v(String paramString) {
    return c().getInt(paramString, 60);
  }
  
  public static int w() {
    SharedPreferences sharedPreferences = c();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("live_first_charge_");
    stringBuilder.append(LiveRoomInfo.a().f());
    return sharedPreferences.getInt(stringBuilder.toString(), -2);
  }
  
  public static void w(String paramString) {
    c().edit().putString("live_beauty_code_sense", paramString).commit();
  }
  
  public static int x() {
    SharedPreferences sharedPreferences = c();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("live_first_charge_time_");
    stringBuilder.append(LiveRoomInfo.a().f());
    return sharedPreferences.getInt(stringBuilder.toString(), 0);
  }
  
  public static void x(String paramString) {
    SharedPreferences.Editor editor = c().edit();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("live_record_level_sticker");
    stringBuilder.append(LiveRoomInfo.a().f());
    editor.putString(stringBuilder.toString(), paramString).commit();
  }
  
  public static int y() {
    SharedPreferences sharedPreferences = c();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("live_first_charge_room_time_");
    stringBuilder.append(LiveRoomInfo.a().f());
    return sharedPreferences.getInt(stringBuilder.toString(), 0);
  }
  
  public static void y(String paramString) {
    SharedPreferences.Editor editor = c().edit();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("live_record_level_gesture");
    stringBuilder.append(LiveRoomInfo.a().f());
    editor.putString(stringBuilder.toString(), paramString).commit();
  }
  
  public static int z() {
    SharedPreferences sharedPreferences = c();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("live_first_charge_icon_time_");
    stringBuilder.append(LiveRoomInfo.a().f());
    return sharedPreferences.getInt(stringBuilder.toString(), 0);
  }
  
  public static void z(String paramString) {
    SharedPreferences.Editor editor = c().edit();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("live_record_level_sticker_location");
    stringBuilder.append(LiveRoomInfo.a().f());
    editor.putString(stringBuilder.toString(), paramString).commit();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\live_chin\\utils\LiveRoomPreferences.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */