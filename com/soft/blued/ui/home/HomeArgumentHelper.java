package com.soft.blued.ui.home;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.module.live_china.model.LiveRoomData;
import com.soft.blued.log.InstantLog;
import com.soft.blued.ui.find.fragment.VisitHistoryFragment;
import com.soft.blued.ui.live.LiveRoomInfoChannel;
import com.soft.blued.ui.msg.controller.tools.ChatHelperV4;
import com.soft.blued.ui.msg_group.fragment.GroupNoticeFragment;
import com.soft.blued.ui.notify.fragment.MsgAttentionNotifyFragment;
import com.soft.blued.ui.setting.fragment.SettingFragment;

public class HomeArgumentHelper {
  public static Bundle a(Intent paramIntent) {
    return (paramIntent == null) ? null : paramIntent.getBundleExtra("arg_subfragment_args");
  }
  
  public static String a(Intent paramIntent, String paramString) {
    if (paramIntent == null)
      return null; 
    Bundle bundle = paramIntent.getBundleExtra("arg_subfragment_args");
    return (bundle != null) ? bundle.getString(paramString) : null;
  }
  
  public static void a(Context paramContext) {
    a(paramContext, (Bundle)null, (Bundle)null);
  }
  
  public static void a(Context paramContext, Intent paramIntent) {
    Bundle bundle = a(paramIntent);
    if (bundle != null) {
      String str = bundle.getString("arg_open_homeactivity_ope");
      if ("ope_liveplay".equals(str)) {
        LiveRoomInfoChannel.a(paramContext, (LiveRoomData)bundle.getSerializable("live_anchor_model"));
        ChatHelperV4.a().a(6L);
        ChatHelperV4.a().a(7L);
        return;
      } 
      if ("ope_livelist".equals(str))
        return; 
      if ("ope_setting".equals(str)) {
        TerminalActivity.d(paramContext, SettingFragment.class, null);
        return;
      } 
      if ("ope_notifications".equals(str)) {
        TerminalActivity.d(paramContext, MsgAttentionNotifyFragment.class, bundle);
        return;
      } 
      if ("ope_visitors".equals(str)) {
        TerminalActivity.d(paramContext, VisitHistoryFragment.class, null);
        return;
      } 
      if ("ope_group_notification".equals(str))
        TerminalActivity.d(paramContext, GroupNoticeFragment.class, null); 
    } 
  }
  
  public static void a(Context paramContext, Bundle paramBundle1, Bundle paramBundle2) {
    paramContext.startActivity(b(paramContext, paramBundle1, paramBundle2));
  }
  
  public static void a(Context paramContext, String paramString, Bundle paramBundle) {
    Bundle bundle = new Bundle();
    if (!TextUtils.isEmpty(paramString))
      bundle.putString("arg_select_tab_tag", paramString); 
    a(paramContext, bundle, paramBundle);
  }
  
  public static Intent b(Context paramContext, Bundle paramBundle1, Bundle paramBundle2) {
    Intent intent = new Intent(paramContext, HomeActivity.class);
    if (paramBundle1 != null)
      intent.putExtra("arg_activity_args", paramBundle1); 
    if (paramBundle2 != null)
      intent.putExtra("arg_subfragment_args", paramBundle2); 
    if (paramContext instanceof android.app.Activity) {
      intent.setFlags(67108864);
      return intent;
    } 
    intent.setFlags(268435456);
    return intent;
  }
  
  public static Intent b(Context paramContext, String paramString, Bundle paramBundle) {
    Bundle bundle = new Bundle();
    if (!TextUtils.isEmpty(paramString))
      bundle.putString("arg_select_tab_tag", paramString); 
    return b(paramContext, bundle, paramBundle);
  }
  
  public static String b(Intent paramIntent, String paramString) {
    if (paramIntent == null)
      return null; 
    Bundle bundle = paramIntent.getBundleExtra("arg_activity_args");
    return (bundle != null) ? bundle.getString(paramString) : null;
  }
  
  public static void b(Context paramContext, Intent paramIntent) {
    String str = a(paramIntent, "from_tag_page");
    if (TextUtils.equals("from_notification_attention", str)) {
      InstantLog.a("inner_push_click_follow_attention");
      return;
    } 
    if (TextUtils.equals("from_notification_feed", str))
      InstantLog.a("inner_push_click_feed_notice"); 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\home\HomeArgumentHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */