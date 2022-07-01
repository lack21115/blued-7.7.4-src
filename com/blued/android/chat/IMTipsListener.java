package com.blued.android.chat;

import android.text.TextUtils;
import com.blued.android.chat.listener.ChatTipsListener;
import com.blued.android.chat.listener.FetchDataListener;
import com.blued.android.chat.model.ChattingModel;
import com.blued.android.chat.model.SessionModel;
import com.blued.android.chat.model.SessionSettingBaseModel;
import com.blued.android.chat.utils.ChatHelper;
import com.blued.android.core.AppInfo;
import com.blued.android.core.AppMethods;
import com.soft.blued.constant.ChatConstants;
import com.soft.blued.db.model.SessionSettingModel;
import com.soft.blued.ui.msg.controller.tools.ChatHelperV4;
import com.soft.blued.ui.msg.customview.GlobalTaskFloatManager;
import com.soft.blued.ui.msg.manager.GiftPlayer;
import com.soft.blued.ui.msg.manager.UserPagerGiftManager;
import com.soft.blued.ui.msg.model.MsgExtraGift;
import com.soft.blued.ui.msg.observer.RecvMsgListenerObserver;
import com.soft.blued.user.UserInfo;
import com.soft.blued.utils.Logger;
import com.soft.blued.utils.UserRelationshipUtils;

public class IMTipsListener implements ChatTipsListener {
  private static final long MIN_NOTIFY_DIFF_MS = 500L;
  
  private static final String TAG = "IMTipsListener";
  
  private long lastNotifyTime = 0L;
  
  public final NotifyMsgRecv recvMsgTask = new NotifyMsgRecv();
  
  private void filterUserPagerGiftMsg(SessionModel paramSessionModel, final ChattingModel msg) {
    boolean bool;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("msgMapExtra===");
    stringBuilder.append(msg.msgMapExtra);
    if (stringBuilder.toString() == null) {
      bool = true;
    } else {
      bool = false;
    } 
    Logger.c("IMTipsListener", new Object[] { Boolean.valueOf(bool) });
    if (msg.msgType != 164)
      return; 
    stringBuilder = new StringBuilder();
    stringBuilder.append("filterUserPagerGiftMsg===");
    stringBuilder.append(UserPagerGiftManager.a().c());
    Logger.c(stringBuilder.toString(), new Object[0]);
    if (UserPagerGiftManager.a().c() != msg.sessionId) {
      paramSessionModel.lastGiftMsgId = msg.msgId;
      MsgExtraGift msgExtraGift = (MsgExtraGift)AppInfo.f().fromJson(msg.getMsgExtra(), MsgExtraGift.class);
      if (msgExtraGift != null && msgExtraGift.gift_like != null) {
        byte b;
        int i;
        byte[] arrayOfByte = UserPagerGiftManager.a(paramSessionModel.unreadGiftCnt);
        byte b1 = arrayOfByte[0];
        byte b2 = arrayOfByte[1];
        if (msgExtraGift.gift_like.giftTye == 3) {
          b = b2;
          i = b1;
          if (b2 < 99) {
            b = b2 + 1;
            i = b1;
          } 
        } else {
          b = b2;
          i = b1;
          if (b1 < 99) {
            i = b1 + 1;
            b = b2;
          } 
        } 
        paramSessionModel.unreadGiftCnt = (b << 8) + i;
      } 
      handleTopGift(paramSessionModel, msgExtraGift);
      ChatManager.getInstance().updateSessionUnreadGiftCnt(paramSessionModel.sessionType, paramSessionModel.sessionId, paramSessionModel.unreadGiftCnt, msg.msgId);
      return;
    } 
    AppInfo.n().post(new Runnable() {
          public void run() {
            GiftPlayer giftPlayer = UserPagerGiftManager.a().b();
            if (giftPlayer != null)
              giftPlayer.b(msg); 
          }
        });
  }
  
  private void handleTopGift(SessionModel paramSessionModel, MsgExtraGift paramMsgExtraGift) {
    if (paramMsgExtraGift != null && paramMsgExtraGift.gift_like.giftTye == 2) {
      if (paramSessionModel.expireTime != 0L && System.currentTimeMillis() > paramSessionModel.expireTime) {
        paramSessionModel.totalMoney = paramMsgExtraGift.gift_like.money;
        paramSessionModel.expireTime = System.currentTimeMillis() + (paramMsgExtraGift.gift_like.topTime * 1000);
        return;
      } 
      paramSessionModel.totalMoney += paramMsgExtraGift.gift_like.money;
      if (paramSessionModel.expireTime < System.currentTimeMillis() + (paramMsgExtraGift.gift_like.topTime * 1000))
        paramSessionModel.expireTime = System.currentTimeMillis() + (paramMsgExtraGift.gift_like.topTime * 1000); 
    } 
  }
  
  private void insertDisturbNotice(long paramLong) {
    ChatManager.getInstance().getSessionModel((short)2, paramLong, new FetchDataListener<SessionModel>() {
          public void onFetchData(SessionModel param1SessionModel) {
            if (param1SessionModel == null || param1SessionModel._msgList == null) {
              StringBuilder stringBuilder = new StringBuilder();
              stringBuilder.append("onFetchData=SessionModel=");
              stringBuilder.append(param1SessionModel);
              Logger.c("IMTipsListener", new Object[] { stringBuilder.toString() });
              return;
            } 
            ChattingModel chattingModel = param1SessionModel._msgList.get(param1SessionModel._msgList.size() - 1);
            String str = AppInfo.d().getResources().getString(2131756204);
            chattingModel = new ChattingModel(chattingModel);
            chattingModel.msgLocalId = ChatHelper.getLocalId();
            chattingModel.msgType = -3;
            chattingModel.msgContent = str;
            ChatHelperV4.a().h(chattingModel);
          }
        });
  }
  
  private void setNoDisturbance(SessionModel paramSessionModel, ChattingModel paramChattingModel) {
    if (paramChattingModel.sessionType == 2 && paramSessionModel != null) {
      SessionSettingModel sessionSettingModel = null;
      if (paramSessionModel.sessionSettingModel != null)
        sessionSettingModel = (SessionSettingModel)paramSessionModel.sessionSettingModel; 
      if (sessionSettingModel == null) {
        if (paramChattingModel.status != ChatConstants.b) {
          SessionSettingModel sessionSettingModel1 = new SessionSettingModel();
          sessionSettingModel1.setLoadName(Long.valueOf(UserInfo.a().i().getUid()).longValue());
          sessionSettingModel1.setSessionId(paramChattingModel.sessionId);
          sessionSettingModel1.setSessionType((short)2);
          sessionSettingModel1.setRemindAudio(paramChattingModel.status);
          ChatManager.getInstance().setSessionSetting(paramChattingModel.sessionType, paramChattingModel.sessionId, (SessionSettingBaseModel)sessionSettingModel1);
          return;
        } 
      } else if (sessionSettingModel.getRemindAudio() != paramChattingModel.status) {
        sessionSettingModel.setRemindAudio(paramChattingModel.status);
        ChatManager.getInstance().setSessionSetting(paramChattingModel.sessionType, paramChattingModel.sessionId, (SessionSettingBaseModel)sessionSettingModel);
      } 
    } 
  }
  
  public void onBusyCalling(long paramLong) {}
  
  public void onConnectException(String paramString) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("onConnectException(), exception:");
    stringBuilder.append(paramString);
    Logger.e("IMTipsListener", new Object[] { stringBuilder.toString() });
  }
  
  public void onDisconnect(int paramInt, String paramString) {
    if (TextUtils.isEmpty(paramString)) {
      paramString = AppInfo.d().getResources().getString(2131755217);
      if (paramInt == 3) {
        paramString = AppInfo.d().getResources().getString(2131755220);
      } else if (paramInt == 4) {
        paramString = AppInfo.d().getResources().getString(2131755219);
      } 
    } 
    UserRelationshipUtils.a(paramString, new int[] { 1 });
  }
  
  public void onRecvNewMsg(SessionModel paramSessionModel, ChattingModel paramChattingModel) {
    StringBuilder stringBuilder;
    if (paramChattingModel.msgType == 208) {
      if (!TextUtils.isEmpty(paramChattingModel.msgContent)) {
        stringBuilder = new StringBuilder();
        stringBuilder.append("MT_TASK_PROGRESS: ");
        stringBuilder.append(paramChattingModel.msgContent);
        Logger.c("IMTipsListener", new Object[] { stringBuilder.toString() });
        try {
          GlobalTaskFloatManager.TaskInfo taskInfo = (GlobalTaskFloatManager.TaskInfo)AppInfo.f().fromJson(paramChattingModel.msgContent, GlobalTaskFloatManager.TaskInfo.class);
          return;
        } finally {
          stringBuilder = null;
        } 
      } 
    } else {
      setNoDisturbance((SessionModel)stringBuilder, paramChattingModel);
      filterUserPagerGiftMsg((SessionModel)stringBuilder, paramChattingModel);
      this.recvMsgTask.setMsgData((SessionModel)stringBuilder, paramChattingModel);
      AppInfo.n().removeCallbacks(this.recvMsgTask);
      long l = System.currentTimeMillis();
      if (l - this.lastNotifyTime < 500L) {
        AppInfo.n().postDelayed(this.recvMsgTask, 500L);
        return;
      } 
      this.lastNotifyTime = l;
      AppInfo.n().post(this.recvMsgTask);
    } 
  }
  
  public void onSendMsgFailed(short paramShort, long paramLong, int paramInt) {
    String str;
    if (paramInt != -2) {
      switch (paramInt) {
        default:
          str = null;
          break;
        case 19:
          str = AppInfo.d().getString(2131756786);
          break;
        case 18:
          insertDisturbNotice(paramLong);
        case 17:
          str = AppInfo.d().getString(2131758095);
          break;
        case 16:
          str = null;
          break;
        case 15:
          str = AppInfo.d().getString(2131756720);
          break;
        case 14:
          str = AppInfo.d().getString(2131757183);
          break;
        case 13:
          str = AppInfo.d().getString(2131757159);
          break;
        case 12:
          str = AppInfo.d().getString(2131758097);
          break;
        case 11:
          str = AppInfo.d().getString(2131758098);
          break;
        case 10:
          str = AppInfo.d().getString(2131758092);
          break;
        case 9:
          str = AppInfo.d().getString(2131758099);
          break;
        case 8:
          str = AppInfo.d().getString(2131758106);
          break;
        case 7:
          str = AppInfo.d().getString(2131758100);
          break;
        case 6:
          str = AppInfo.d().getString(2131758102);
          break;
        case 5:
          if (paramShort == 3) {
            str = AppInfo.d().getString(2131756719);
            break;
          } 
          str = AppInfo.d().getString(2131758101);
          break;
        case 4:
          str = AppInfo.d().getString(2131758094);
          break;
        case 3:
          str = AppInfo.d().getString(2131758093);
          break;
      } 
    } else {
      str = AppInfo.d().getString(2131758103);
    } 
    if (!TextUtils.isEmpty(str))
      AppMethods.a(str); 
  }
  
  public void onVideoCalling(long paramLong, int paramInt) {}
  
  public void onVideoCallingCancel(long paramLong, int paramInt) {
    ChatHelperV4.a().c();
  }
  
  class NotifyMsgRecv implements Runnable {
    ChattingModel _msgData;
    
    SessionModel _sessionModel;
    
    private NotifyMsgRecv() {}
    
    public void run() {
      ChatHelperV4.a().a(AppInfo.d(), this._sessionModel, this._msgData);
      RecvMsgListenerObserver.a().a(this._sessionModel, this._msgData);
    }
    
    public void setMsgData(SessionModel param1SessionModel, ChattingModel param1ChattingModel) {
      this._sessionModel = param1SessionModel;
      this._msgData = param1ChattingModel;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\blued\android\chat\IMTipsListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */