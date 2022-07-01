package com.blued.android.module.live_china.msg;

import android.os.SystemClock;
import android.text.TextUtils;
import com.blued.android.chat.data.ProfileData;
import com.blued.android.chat.listener.LiveChatInfoListener;
import com.blued.android.chat.model.ChattingModel;
import com.blued.android.core.AppInfo;
import com.blued.android.core.AppMethods;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.utils.LogUtils;
import com.blued.android.module.common.utils.CommonStringUtils;
import com.blued.android.module.common.utils.ReflectionUtils;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.liveForMsg.model.LiveMsgShareEntity;
import com.blued.android.module.live_china.live_info.LiveRoomInfo;
import com.blued.android.module.live_china.model.LiveGiftModel;
import com.blued.android.module.live_china.observer.LiveRefreshUIObserver;
import com.blued.android.module.live_china.utils.LiveRoomHttpUtils;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

public class LiveMsgSendManager {
  private static volatile LiveMsgSendManager a;
  
  private ILiveMsgSender b;
  
  private final AtomicLong c = new AtomicLong(0L);
  
  public static LiveMsgSendManager a() {
    // Byte code:
    //   0: ldc com/blued/android/module/live_china/msg/LiveMsgSendManager
    //   2: monitorenter
    //   3: getstatic com/blued/android/module/live_china/msg/LiveMsgSendManager.a : Lcom/blued/android/module/live_china/msg/LiveMsgSendManager;
    //   6: ifnonnull -> 25
    //   9: new com/blued/android/module/live_china/msg/LiveMsgSendManager
    //   12: dup
    //   13: invokespecial <init> : ()V
    //   16: putstatic com/blued/android/module/live_china/msg/LiveMsgSendManager.a : Lcom/blued/android/module/live_china/msg/LiveMsgSendManager;
    //   19: getstatic com/blued/android/module/live_china/msg/LiveMsgSendManager.a : Lcom/blued/android/module/live_china/msg/LiveMsgSendManager;
    //   22: invokespecial k : ()V
    //   25: ldc com/blued/android/module/live_china/msg/LiveMsgSendManager
    //   27: monitorexit
    //   28: getstatic com/blued/android/module/live_china/msg/LiveMsgSendManager.a : Lcom/blued/android/module/live_china/msg/LiveMsgSendManager;
    //   31: areturn
    //   32: astore_0
    //   33: ldc com/blued/android/module/live_china/msg/LiveMsgSendManager
    //   35: monitorexit
    //   36: aload_0
    //   37: athrow
    // Exception table:
    //   from	to	target	type
    //   3	25	32	finally
    //   25	28	32	finally
    //   33	36	32	finally
  }
  
  private void a(String paramString, long paramLong, short paramShort) {
    ChattingModel chattingModel = this.b.a(paramLong, paramShort, (short)32, AppInfo.d().getResources().getString(R.string.liveVideo_message_label_shareLivePart), paramString);
    LiveRoomInfo.a().a(chattingModel, false);
  }
  
  private void k() {
    if (LiveRoomInfo.a().G()) {
      LogUtils.c("use grpc");
      this.b = new GrpcMsgSender();
      return;
    } 
    this.b = new SocketMsgSender();
    LogUtils.c("use Socket");
  }
  
  public void a(long paramLong) {
    this.b.a(paramLong);
  }
  
  public void a(long paramLong, String[] paramArrayOfString1, String[] paramArrayOfString2, String paramString) {
    LiveRoomHttpUtils.a(new BluedUIHttpResponse<BluedEntityA<LiveMsgShareEntity>>(this, paramString, paramArrayOfString1, paramArrayOfString2) {
          protected void a(BluedEntityA<LiveMsgShareEntity> param1BluedEntityA) {
            if (param1BluedEntityA.data != null && param1BluedEntityA.data.size() > 0) {
              List<LiveMsgShareEntity> list = param1BluedEntityA.data;
              int i = 0;
              LiveMsgShareEntity liveMsgShareEntity = list.get(0);
              if (liveMsgShareEntity != null)
                try {
                  liveMsgShareEntity.copywriting = this.a;
                  String str = AppInfo.f().toJson(liveMsgShareEntity);
                  if (this.b.length == this.c.length && this.b.length > 0)
                    while (i < this.b.length) {
                      LiveMsgSendManager.a(LiveMsgSendManager.a(), str, CommonStringUtils.c(this.b[i]), (short)CommonStringUtils.a(this.c[i]));
                      i++;
                    }  
                } catch (Exception exception) {
                  exception.printStackTrace();
                }  
            } 
          }
        }String.valueOf(paramLong), null);
  }
  
  public void a(ProfileData paramProfileData) {
    this.b.a(paramProfileData);
  }
  
  public void a(LiveGiftModel paramLiveGiftModel) {
    if (paramLiveGiftModel == null)
      return; 
    LiveGiftModel liveGiftModel = new LiveGiftModel();
    ReflectionUtils.a(paramLiveGiftModel, liveGiftModel);
    this.b.a(liveGiftModel);
  }
  
  public void a(String paramString) {
    a(paramString, (SendMsgListener)null);
  }
  
  public void a(String paramString, SendMsgListener paramSendMsgListener) {
    if (TextUtils.isEmpty(paramString)) {
      AppMethods.d(R.string.chat_send_alert);
      if (paramSendMsgListener != null)
        paramSendMsgListener.b(); 
      return;
    } 
    this.b.a(paramString);
    if (paramSendMsgListener != null)
      paramSendMsgListener.a(); 
    LiveRefreshUIObserver.a().h();
    LogUtils.c(paramString);
  }
  
  public void a(short paramShort, long paramLong, LiveChatInfoListener paramLiveChatInfoListener) {
    this.b.a(paramShort, paramLong, paramLiveChatInfoListener);
  }
  
  public void a(short paramShort, String paramString) {
    this.b.b(paramShort, paramString);
  }
  
  public void a(boolean paramBoolean) {
    long l = SystemClock.elapsedRealtime();
    if (this.c.get() != 0L && ((float)(l - this.c.get()) / 1000.0F) < 0.5D && (l - this.c.get()) / 1000L >= 0L)
      return; 
    this.c.set(l);
    this.b.a(paramBoolean);
  }
  
  public void b() {
    this.b.a();
  }
  
  public void b(ProfileData paramProfileData) {
    this.b.b(paramProfileData);
  }
  
  public void b(String paramString) {
    if (AppInfo.m())
      this.b.b(paramString); 
  }
  
  public void b(short paramShort, long paramLong, LiveChatInfoListener paramLiveChatInfoListener) {
    this.b.b(paramShort, paramLong, paramLiveChatInfoListener);
  }
  
  public void c() {
    this.b.b();
  }
  
  public void d() {
    this.b.c();
  }
  
  public void e() {
    this.b.h();
  }
  
  public void f() {
    this.b.i();
  }
  
  public void g() {
    this.b.j();
  }
  
  public void h() {
    this.b.k();
  }
  
  public void i() {
    this.b.l();
  }
  
  public void j() {
    this.b.m();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\live_china\msg\LiveMsgSendManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */