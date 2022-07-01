package com.heytap.mcssdk;

import android.content.Context;
import android.content.Intent;
import com.heytap.mcssdk.a.c;
import com.heytap.mcssdk.b.c;
import com.heytap.mcssdk.callback.MessageCallback;
import com.heytap.mcssdk.mode.CommandMessage;
import com.heytap.mcssdk.mode.Message;
import com.heytap.mcssdk.utils.LogUtil;
import com.heytap.mcssdk.utils.Utils;

public class PushParseHelper {
  public static void a(Context paramContext, Intent paramIntent, MessageCallback paramMessageCallback) {
    String str;
    if (paramContext == null) {
      str = "context is null , please check param of parseIntent()";
    } else if (paramIntent == null) {
      str = "intent is null , please check param of parseIntent()";
    } else if (paramMessageCallback == null) {
      str = "callback is null , please check param of parseIntent()";
    } else {
      for (Message message : c.a((Context)str, paramIntent)) {
        if (message != null)
          for (c c : PushManager.a().c()) {
            if (c != null)
              c.a((Context)str, message, paramMessageCallback); 
          }  
      } 
      return;
    } 
    LogUtil.b(str);
  }
  
  public static void a(Context paramContext, CommandMessage paramCommandMessage, PushManager paramPushManager) {
    if (paramContext == null) {
      LogUtil.b("context is null , please check param of parseCommandMessage(2)");
      return;
    } 
    if (paramCommandMessage == null) {
      LogUtil.b("message is null , please check param of parseCommandMessage(2)");
      return;
    } 
    if (paramPushManager == null) {
      LogUtil.b("pushManager is null , please check param of parseCommandMessage(2)");
      return;
    } 
    if (paramPushManager.e() == null) {
      LogUtil.b("pushManager.getPushCallback() is null , please check param of parseCommandMessage(2)");
      return;
    } 
    switch (paramCommandMessage.a()) {
      default:
        return;
      case 12309:
        paramPushManager.e().b(paramCommandMessage.d(), Utils.a(paramCommandMessage.c()));
        return;
      case 12306:
        paramPushManager.e().a(paramCommandMessage.d(), Utils.a(paramCommandMessage.c()));
        return;
      case 12303:
        paramPushManager.e().e(paramCommandMessage.d(), CommandMessage.a(paramCommandMessage.c(), "tags", "accountId", "accountName"));
        return;
      case 12302:
        paramPushManager.e().f(paramCommandMessage.d(), CommandMessage.a(paramCommandMessage.c(), "tags", "accountId", "accountName"));
        return;
      case 12301:
        paramPushManager.e().d(paramCommandMessage.d(), CommandMessage.a(paramCommandMessage.c(), "tags", "accountId", "accountName"));
        return;
      case 12298:
        paramPushManager.e().b(paramCommandMessage.d(), paramCommandMessage.c());
        return;
      case 12297:
        paramPushManager.e().h(paramCommandMessage.d(), CommandMessage.a(paramCommandMessage.c(), "tags", "tagId", "tagName"));
        return;
      case 12296:
        paramPushManager.e().i(paramCommandMessage.d(), CommandMessage.a(paramCommandMessage.c(), "tags", "tagId", "tagName"));
        return;
      case 12295:
        paramPushManager.e().g(paramCommandMessage.d(), CommandMessage.a(paramCommandMessage.c(), "tags", "tagId", "tagName"));
        return;
      case 12294:
        paramPushManager.e().c(paramCommandMessage.d(), CommandMessage.a(paramCommandMessage.c(), "alias", "aliasId", "aliasName"));
        return;
      case 12293:
        paramPushManager.e().a(paramCommandMessage.d(), CommandMessage.a(paramCommandMessage.c(), "alias", "aliasId", "aliasName"));
        return;
      case 12292:
        paramPushManager.e().b(paramCommandMessage.d(), CommandMessage.a(paramCommandMessage.c(), "alias", "aliasId", "aliasName"));
        return;
      case 12290:
        paramPushManager.e().a(paramCommandMessage.d());
        return;
      case 12289:
        break;
    } 
    if (paramCommandMessage.d() == 0)
      paramPushManager.a(paramCommandMessage.c()); 
    paramPushManager.e().a(paramCommandMessage.d(), paramCommandMessage.c());
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\heytap\mcssdk\PushParseHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */