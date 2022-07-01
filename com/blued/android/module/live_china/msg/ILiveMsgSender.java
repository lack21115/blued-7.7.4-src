package com.blued.android.module.live_china.msg;

import androidx.collection.ArrayMap;
import com.blued.android.chat.data.ProfileData;
import com.blued.android.chat.listener.LiveChatInfoListener;
import com.blued.android.chat.model.ChattingModel;
import com.blued.android.chat.model.SessionProfileModel;
import com.blued.android.chat.utils.ChatHelper;
import com.blued.android.chat.utils.MsgPackHelper;
import com.blued.android.core.AppInfo;
import com.blued.android.framework.utils.LogUtils;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.live_info.LiveRoomInfo;
import com.blued.android.module.live_china.manager.LiveFloatManager;
import com.blued.android.module.live_china.manager.LiveRoomManager;
import com.blued.android.module.live_china.model.LiveGiftModel;
import com.blued.android.module.live_china.observer.LiveSetDataObserver;
import java.util.HashMap;
import java.util.Map;

public abstract class ILiveMsgSender {
  public static SessionProfileModel e() {
    SessionProfileModel sessionProfileModel = new SessionProfileModel();
    sessionProfileModel.nickname = LiveRoomInfo.a().c();
    sessionProfileModel.avatar = LiveRoomInfo.a().d();
    sessionProfileModel.vBadge = LiveRoomInfo.a().r();
    return sessionProfileModel;
  }
  
  public ChattingModel a(long paramLong, short paramShort1, short paramShort2, String paramString1, String paramString2) {
    return ChatHelper.getChattingModelForSendmsg(paramLong, paramShort2, paramString1, e(), paramString2, paramShort1);
  }
  
  public ChattingModel a(short paramShort) {
    return a(paramShort, "");
  }
  
  public ChattingModel a(short paramShort, String paramString) {
    return a(paramShort, paramString, "");
  }
  
  public ChattingModel a(short paramShort, String paramString1, String paramString2) {
    return a(LiveRoomManager.a().b(), LiveRoomManager.a().f(), paramShort, paramString1, paramString2);
  }
  
  public abstract void a();
  
  public abstract void a(long paramLong);
  
  public void a(ProfileData paramProfileData) {
    if (paramProfileData == null)
      return; 
    ChattingModel chattingModel = a((short)109, "解禁");
    ArrayMap arrayMap1 = new ArrayMap();
    MsgPackHelper.putMapValue((Map)arrayMap1, "uid", paramProfileData.uid);
    MsgPackHelper.putMapValue((Map)arrayMap1, "name", paramProfileData.name);
    ArrayMap<String, ArrayMap> arrayMap = new ArrayMap();
    arrayMap.put("mute_profile", arrayMap1);
    chattingModel.fromRichLevel = LiveRoomInfo.a().q();
    if (LiveFloatManager.a().w())
      chattingModel.fromLiveManager = 1; 
    chattingModel.msgMapExtra = (Map)arrayMap;
    a(chattingModel);
    LogUtils.a("聊天场控解禁");
  }
  
  public void a(ChattingModel paramChattingModel) {
    if (paramChattingModel == null)
      return; 
    LiveEventBusUtil.a(paramChattingModel);
  }
  
  public void a(LiveGiftModel paramLiveGiftModel) {
    ChattingModel chattingModel = a((short)33, "LiveGift");
    chattingModel.msgMapExtra = new HashMap<Object, Object>();
    chattingModel.msgMapExtra.put("gift_model", paramLiveGiftModel);
    chattingModel.fromRichLevel = LiveRoomInfo.a().q();
    a(chattingModel);
    LiveSetDataObserver.a().a(chattingModel);
  }
  
  public abstract void a(String paramString);
  
  public abstract void a(short paramShort, long paramLong, LiveChatInfoListener paramLiveChatInfoListener);
  
  public abstract void a(boolean paramBoolean);
  
  public abstract void b();
  
  public void b(ProfileData paramProfileData) {
    if (paramProfileData == null)
      return; 
    ChattingModel chattingModel = a((short)104, "禁言");
    ArrayMap arrayMap1 = new ArrayMap();
    MsgPackHelper.putMapValue((Map)arrayMap1, "uid", paramProfileData.uid);
    MsgPackHelper.putMapValue((Map)arrayMap1, "name", paramProfileData.name);
    ArrayMap<String, ArrayMap> arrayMap = new ArrayMap();
    arrayMap.put("mute_profile", arrayMap1);
    chattingModel.fromRichLevel = LiveRoomInfo.a().q();
    if (LiveFloatManager.a().w())
      chattingModel.fromLiveManager = 1; 
    chattingModel.msgMapExtra = (Map)arrayMap;
    a(chattingModel);
    LogUtils.a("聊天场控禁言");
  }
  
  protected void b(ChattingModel paramChattingModel) {
    if (paramChattingModel != null && LiveRoomManager.a().j() != null) {
      paramChattingModel.msgMapExtra = new HashMap<Object, Object>();
      paramChattingModel.msgMapExtra.put("liang_id", (LiveRoomManager.a().j()).liang_id);
      paramChattingModel.msgMapExtra.put("liang_type", Integer.valueOf((LiveRoomManager.a().j()).liang_type));
    } 
  }
  
  public void b(String paramString) {
    ChattingModel chattingModel = a((short)1, paramString);
    chattingModel.fromNickName = "测试";
    a(chattingModel);
  }
  
  public abstract void b(short paramShort, long paramLong, LiveChatInfoListener paramLiveChatInfoListener);
  
  public void b(short paramShort, String paramString) {
    a(a(paramShort, paramString));
  }
  
  public abstract void c();
  
  protected ChattingModel f() {
    ChattingModel chattingModel = a((short)31, "LiveLike");
    b(chattingModel);
    return chattingModel;
  }
  
  protected ChattingModel g() {
    ChattingModel chattingModel = a((short)51, "LiveLike");
    b(chattingModel);
    return chattingModel;
  }
  
  public void h() {
    ChattingModel chattingModel = a((short)50, AppInfo.d().getString(R.string.live_shared));
    b(chattingModel);
    a(chattingModel);
    LogUtils.a("分享了主播");
  }
  
  public void i() {
    a(a((short)-10001));
  }
  
  public void j() {
    a(a((short)-10000));
  }
  
  public void k() {
    a(a((short)103, AppInfo.d().getString(R.string.live_attention_remind)));
  }
  
  public void l() {
    a(a((short)104, AppInfo.d().getString(R.string.live_chat_remind)));
  }
  
  public void m() {
    ChattingModel chattingModel = a((short)49, AppInfo.d().getString(R.string.live_following));
    b(chattingModel);
    a(chattingModel);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\live_china\msg\ILiveMsgSender.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */