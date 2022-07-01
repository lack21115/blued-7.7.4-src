package com.soft.blued.push;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.blued.android.module.live_china.liveForMsg.model.LiveMsgShareEntity;
import com.blued.das.authority.SystemAuthorityProtos;
import com.blued.das.message.MessageProtos;
import com.soft.blued.log.InstantLog;
import com.soft.blued.log.trackUtils.EventTrackMessage;
import com.soft.blued.log.trackUtils.EventTrackSystemAuthority;
import com.soft.blued.ui.home.HomeArgumentHelper;
import com.soft.blued.ui.msg.DialogSkipFragment;
import com.soft.blued.ui.msg.controller.tools.ChatHelperV4;
import com.soft.blued.ui.msg.model.ChannelModel;
import com.soft.blued.ui.web.WebViewShowInfoFragment;
import com.soft.blued.ui.welcome.PushClickActivity;
import com.soft.blued.utils.StringUtils;
import java.net.URLDecoder;

public class PushCommonUtils {
  public static final String a = PushCommonUtils.class.getSimpleName();
  
  public static void a(Context paramContext, PushMsgModel paramPushMsgModel) {
    PushClickActivity.a(paramContext, paramPushMsgModel);
  }
  
  private static void a(PushMsgModel paramPushMsgModel) {
    if (paramPushMsgModel != null && paramPushMsgModel.extra != null) {
      String str;
      if (StringUtils.e(paramPushMsgModel.extra.link)) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(paramPushMsgModel.session_type);
        stringBuilder.append("&");
        stringBuilder.append(paramPushMsgModel.session_id);
        stringBuilder.append("&");
        stringBuilder.append(paramPushMsgModel.extra.push_type);
        str = stringBuilder.toString();
      } else {
        String str1 = ((PushMsgModel)str).extra.link;
        try {
          str = URLDecoder.decode(((PushMsgModel)str).extra.link, "UTF-8");
        } catch (Exception exception) {
          str = str1;
        } 
      } 
      InstantLog.i("push_msg_navigate", str);
      EventTrackSystemAuthority.a(SystemAuthorityProtos.Event.PUSH_CLICK, str);
    } 
  }
  
  public static void b(Context paramContext, PushMsgModel paramPushMsgModel) {
    String str;
    if (paramPushMsgModel != null && paramPushMsgModel.extra != null) {
      LiveMsgShareEntity liveMsgShareEntity = paramPushMsgModel.extra;
      if (!TextUtils.isEmpty(liveMsgShareEntity.link)) {
        HomeArgumentHelper.a(paramContext, "find", ChatHelperV4.a().a(liveMsgShareEntity));
        WebViewShowInfoFragment.show(paramContext, liveMsgShareEntity.link, -1);
      } else {
        StringBuilder stringBuilder;
        if (liveMsgShareEntity.redirect == 1 || liveMsgShareEntity.redirect == 4) {
          HomeArgumentHelper.a(paramContext, "msg", ChatHelperV4.a().a(liveMsgShareEntity));
          str = a;
          stringBuilder = new StringBuilder();
          stringBuilder.append("doRedirectPush");
          stringBuilder.append(paramPushMsgModel);
          Log.e(str, stringBuilder.toString());
        } else if (((LiveMsgShareEntity)stringBuilder).redirect == 2) {
          HomeArgumentHelper.a((Context)str, "mine", ChatHelperV4.a().a((LiveMsgShareEntity)stringBuilder));
        } else if (((LiveMsgShareEntity)stringBuilder).redirect == 3) {
          HomeArgumentHelper.a((Context)str, "feed", ChatHelperV4.a().a((LiveMsgShareEntity)stringBuilder));
          InstantLog.d("msg_push", "feed_followed");
          EventTrackMessage.b(MessageProtos.Event.MSG_PUSH, "feed_followed");
        } else if (((LiveMsgShareEntity)stringBuilder).redirect == 5) {
          HomeArgumentHelper.a((Context)str, "find", ChatHelperV4.a().a((LiveMsgShareEntity)stringBuilder));
        } else if (((LiveMsgShareEntity)stringBuilder).redirect == 6) {
          HomeArgumentHelper.a((Context)str, "live", ChatHelperV4.a().a((LiveMsgShareEntity)stringBuilder));
        } else if (((LiveMsgShareEntity)stringBuilder).redirect == 7) {
          ChannelModel channelModel = new ChannelModel();
          if (((LiveMsgShareEntity)stringBuilder).room_type == 2) {
            channelModel.callType = 2;
          } else if (((LiveMsgShareEntity)stringBuilder).room_type == 1) {
            channelModel.callType = 3;
          } else {
            HomeArgumentHelper.a((Context)str, "msg", null);
          } 
          channelModel.channelId = ((LiveMsgShareEntity)stringBuilder).room_id;
          channelModel.remoteUid = Integer.parseInt(((LiveMsgShareEntity)stringBuilder).uid);
          channelModel.remoteUserHead = ((LiveMsgShareEntity)stringBuilder).avatar;
          channelModel.remoteUserName = ((LiveMsgShareEntity)stringBuilder).name;
          DialogSkipFragment.a((Context)str, channelModel);
        } else if (((LiveMsgShareEntity)stringBuilder).redirect == 9) {
          HomeArgumentHelper.a((Context)str, "feed", ChatHelperV4.a().a((LiveMsgShareEntity)stringBuilder));
        } else {
          HomeArgumentHelper.a((Context)str, "find", null);
        } 
      } 
      a(paramPushMsgModel);
      return;
    } 
    HomeArgumentHelper.a((Context)str, "find", null);
  }
  
  public static interface RedirectType {}
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blued\push\PushCommonUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */