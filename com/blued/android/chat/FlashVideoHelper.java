package com.blued.android.chat;

import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import com.blued.android.chat.core.worker.chat.FlashVideo;
import com.blued.android.chat.data.RelationProfileData;
import com.blued.android.chat.model.FlashVideoGiftModel;
import java.util.List;
import java.util.Map;

public class FlashVideoHelper implements FlashVideo.IFlashVideoCallback {
  private static final String TAG = "Chat_FlashVideoHelper";
  
  private BothAgreeState addExtraTimeAgreeState = BothAgreeState.IDLE;
  
  private Handler callbackHandler;
  
  private int extraTime = 0;
  
  private FlashVideo flashVideoImpl;
  
  private BothAgreeState matchAgreeState = BothAgreeState.IDLE;
  
  private MatchListener matchListener;
  
  private String matchedRoomId;
  
  private long matchedUid;
  
  private MatchState state = MatchState.IDLE;
  
  public FlashVideoHelper(MatchListener paramMatchListener) {
    this.matchListener = paramMatchListener;
    this.flashVideoImpl = ChatManager.getInstance().registerFlashVideoHelper(this);
  }
  
  private void notifyCallback(Runnable paramRunnable) {
    if (this.matchListener != null) {
      Handler handler = this.callbackHandler;
      if (handler != null) {
        handler.post(paramRunnable);
        return;
      } 
      paramRunnable.run();
    } 
  }
  
  public void SayHi() {
    if (ChatManager.debug) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("SayHi(), state:");
      stringBuilder.append(this.state);
      Log.v("Chat_FlashVideoHelper", stringBuilder.toString());
    } 
    if (this.state == MatchState.DESTROY) {
      if (ChatManager.debug)
        Log.e("Chat_FlashVideoHelper", "当前状态已经是DESTROY了，不允许再执行SayHi操作"); 
      return;
    } 
    this.flashVideoImpl.sayHi(this.matchedUid, this.matchedRoomId);
  }
  
  public void applyExtraTime() {
    if (ChatManager.debug) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("applyExtraTime(), state:");
      stringBuilder.append(this.state);
      stringBuilder.append(", addExtraTimeAgreeState:");
      stringBuilder.append(this.addExtraTimeAgreeState);
      Log.v("Chat_FlashVideoHelper", stringBuilder.toString());
    } 
    if (this.state == MatchState.DESTROY) {
      if (ChatManager.debug)
        Log.e("Chat_FlashVideoHelper", "当前状态已经是DESTROY了，不允许再执行applyExtraTime操作"); 
      return;
    } 
    this.addExtraTimeAgreeState = this.addExtraTimeAgreeState.setAgreeStateSelf();
    if (this.addExtraTimeAgreeState == BothAgreeState.AGREE_BOTH) {
      this.addExtraTimeAgreeState = BothAgreeState.IDLE;
      notifyCallback(new Runnable() {
            public void run() {
              if (FlashVideoHelper.this.matchListener != null)
                FlashVideoHelper.this.matchListener.onApplydExtraTimeAgree(FlashVideoHelper.this.extraTime); 
            }
          });
    } 
    this.flashVideoImpl.applyExtraTime(this.matchedUid, this.matchedRoomId);
  }
  
  public void applyFriend() {
    if (ChatManager.debug) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("applyFriend(), state:");
      stringBuilder.append(this.state);
      Log.v("Chat_FlashVideoHelper", stringBuilder.toString());
    } 
    if (this.state == MatchState.DESTROY) {
      if (ChatManager.debug)
        Log.e("Chat_FlashVideoHelper", "当前状态已经是DESTROY了，不允许再执行applyFriend操作"); 
      return;
    } 
    this.flashVideoImpl.applyFriend(this.matchedUid, this.matchedRoomId);
  }
  
  public void close() {
    if (ChatManager.debug) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("close(), state:");
      stringBuilder.append(this.state);
      stringBuilder.append(", matchAgreeState:");
      stringBuilder.append(this.matchAgreeState);
      Log.v("Chat_FlashVideoHelper", stringBuilder.toString());
    } 
    if (this.state == MatchState.MATCHING) {
      this.flashVideoImpl.cancelMatch();
    } else if (this.state == MatchState.CHATING) {
      int i = null.$SwitchMap$com$blued$android$chat$FlashVideoHelper$BothAgreeState[this.matchAgreeState.ordinal()];
      byte b2 = 1;
      byte b1 = b2;
      switch (i) {
        default:
          b1 = b2;
          break;
        case 6:
          b1 = 5;
          break;
        case 5:
          b1 = 4;
          break;
        case 3:
        case 4:
          b1 = 3;
          break;
        case 2:
          b1 = 2;
          break;
        case 1:
          break;
      } 
      this.flashVideoImpl.closeFlashVideo(this.matchedUid, this.matchedRoomId, b1);
    } 
    this.state = MatchState.IDLE;
    this.matchAgreeState = BothAgreeState.IDLE;
    this.addExtraTimeAgreeState = BothAgreeState.IDLE;
  }
  
  public void destroy() {
    if (ChatManager.debug) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("destroy(), state:");
      stringBuilder.append(this.state);
      Log.v("Chat_FlashVideoHelper", stringBuilder.toString());
    } 
    this.state = MatchState.DESTROY;
    this.matchListener = null;
    ChatManager.getInstance().unregisterFlashVideoHelper(this);
  }
  
  public void match() {
    if (ChatManager.debug) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("match(), state:");
      stringBuilder.append(this.state);
      Log.v("Chat_FlashVideoHelper", stringBuilder.toString());
    } 
    if (this.state == MatchState.DESTROY) {
      if (ChatManager.debug)
        Log.e("Chat_FlashVideoHelper", "当前状态已经是DESTROY了，不允许再执行match操作"); 
      return;
    } 
    this.state = MatchState.MATCHING;
    this.matchAgreeState = BothAgreeState.IDLE;
    this.addExtraTimeAgreeState = BothAgreeState.IDLE;
    this.flashVideoImpl.startMatch();
  }
  
  public void matchAgree() {
    if (ChatManager.debug) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("matchAgree(), state:");
      stringBuilder.append(this.state);
      stringBuilder.append(", matchAgreeState:");
      stringBuilder.append(this.matchAgreeState);
      Log.v("Chat_FlashVideoHelper", stringBuilder.toString());
    } 
    if (this.state == MatchState.DESTROY) {
      if (ChatManager.debug)
        Log.e("Chat_FlashVideoHelper", "当前状态已经是DESTROY了，不允许再执行matchAgree操作"); 
      return;
    } 
    this.matchAgreeState = this.matchAgreeState.setAgreeStateSelf();
    if (this.matchAgreeState == BothAgreeState.AGREE_BOTH)
      notifyCallback(new Runnable() {
            public void run() {
              if (FlashVideoHelper.this.matchListener != null)
                FlashVideoHelper.this.matchListener.onMatchAgreed(); 
            }
          }); 
    this.flashVideoImpl.matchAgree(this.matchedUid, this.matchedRoomId);
  }
  
  public void matchCancel() {
    if (ChatManager.debug) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("matchCancel(), state:");
      stringBuilder.append(this.state);
      stringBuilder.append(", matchAgreeState:");
      stringBuilder.append(this.matchAgreeState);
      stringBuilder.append(", cancel");
      Log.e("Chat_FlashVideoHelper", stringBuilder.toString());
    } 
    if (this.state == MatchState.DESTROY) {
      if (ChatManager.debug)
        Log.e("Chat_FlashVideoHelper", "当前状态已经是DESTROY了，不允许再执行matchCancel操作"); 
      return;
    } 
    if (this.state == MatchState.CHATING) {
      this.flashVideoImpl.cancelMatch();
      matchReject();
      return;
    } 
    this.flashVideoImpl.cancelMatch();
    this.state = MatchState.IDLE;
    this.matchAgreeState = BothAgreeState.IDLE;
    this.addExtraTimeAgreeState = BothAgreeState.IDLE;
  }
  
  public void matchReject() {
    if (ChatManager.debug) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("matchReject(), state:");
      stringBuilder.append(this.state);
      stringBuilder.append("   matchAgreeState:");
      stringBuilder.append(this.matchAgreeState);
      Log.v("Chat_FlashVideoHelper", stringBuilder.toString());
    } 
    if (this.state == MatchState.DESTROY) {
      if (ChatManager.debug)
        Log.e("Chat_FlashVideoHelper", "当前状态已经是DESTROY了，不允许再执行matchReject操作"); 
      return;
    } 
    this.matchAgreeState = this.matchAgreeState.setAgreeStateReject();
    close();
  }
  
  public void onApplyFriends(String paramString) {
    if (ChatManager.debug) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("onApplyFriends(), roomId:");
      stringBuilder.append(paramString);
      stringBuilder.append(", state");
      stringBuilder.append(this.state);
      stringBuilder.append(", matchAgreeState:");
      stringBuilder.append(this.matchAgreeState);
      Log.v("Chat_FlashVideoHelper", stringBuilder.toString());
    } 
    if (this.state == MatchState.CHATING && TextUtils.equals(this.matchedRoomId, paramString))
      notifyCallback(new Runnable() {
            public void run() {
              if (FlashVideoHelper.this.matchListener != null)
                FlashVideoHelper.this.matchListener.onApplyFriends(); 
            }
          }); 
  }
  
  public void onApplyFriends(final Map extraMap) {
    notifyCallback(new Runnable() {
          public void run() {
            if (FlashVideoHelper.this.matchListener != null)
              FlashVideoHelper.this.matchListener.onApplyFriendsReq(extraMap); 
          }
        });
  }
  
  public void onApplyFriendsAgree(String paramString) {
    if (ChatManager.debug) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("onApplyFriendsAgree(), roomId:");
      stringBuilder.append(paramString);
      stringBuilder.append(", state");
      stringBuilder.append(this.state);
      stringBuilder.append(", matchAgreeState:");
      stringBuilder.append(this.matchAgreeState);
      Log.v("Chat_FlashVideoHelper", stringBuilder.toString());
    } 
    if (this.state == MatchState.CHATING && TextUtils.equals(this.matchedRoomId, paramString))
      notifyCallback(new Runnable() {
            public void run() {
              if (FlashVideoHelper.this.matchListener != null)
                FlashVideoHelper.this.matchListener.onApplyFriendsAgree(); 
            }
          }); 
  }
  
  public void onChatClose(String paramString1, final int reason, final String message) {
    if (ChatManager.debug) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("onChatClose(), state:");
      stringBuilder.append(this.state);
      stringBuilder.append(", roomId:");
      stringBuilder.append(paramString1);
      stringBuilder.append(", reason:");
      stringBuilder.append(reason);
      stringBuilder.append(", message:");
      stringBuilder.append(message);
      Log.v("Chat_FlashVideoHelper", stringBuilder.toString());
    } 
    if (this.state == MatchState.CHATING && TextUtils.equals(paramString1, this.matchedRoomId)) {
      this.state = MatchState.IDLE;
      this.matchAgreeState = BothAgreeState.IDLE;
      this.addExtraTimeAgreeState = BothAgreeState.IDLE;
      notifyCallback(new Runnable() {
            public void run() {
              if (FlashVideoHelper.this.matchListener != null)
                FlashVideoHelper.this.matchListener.onChatClose(reason, message); 
            }
          });
    } 
  }
  
  public void onMatchAck(final String contents, final List<String> tips) {
    if (this.state == MatchState.MATCHING)
      notifyCallback(new Runnable() {
            public void run() {
              if (FlashVideoHelper.this.matchListener != null)
                FlashVideoHelper.this.matchListener.onMatchWaiting(contents, tips); 
            }
          }); 
  }
  
  public void onMatchFailed(final MatchFailed failedReason, final String failedMessage, final int remainNum) {
    if (ChatManager.debug) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("onMatchFailed(), state:");
      stringBuilder.append(this.state);
      stringBuilder.append(", failedReason:");
      stringBuilder.append(failedReason);
      stringBuilder.append(", failedMessage:");
      stringBuilder.append(failedMessage);
      stringBuilder.append(", remainNum:");
      stringBuilder.append(remainNum);
      Log.v("Chat_FlashVideoHelper", stringBuilder.toString());
    } 
    if (this.state == MatchState.MATCHING) {
      this.state = MatchState.IDLE;
      this.matchAgreeState = BothAgreeState.IDLE;
      this.addExtraTimeAgreeState = BothAgreeState.IDLE;
      notifyCallback(new Runnable() {
            public void run() {
              if (FlashVideoHelper.this.matchListener != null)
                FlashVideoHelper.this.matchListener.onMatchFailed(failedReason, failedMessage, remainNum); 
            }
          });
    } 
  }
  
  public void onMatched(final String roomId, final RelationProfileData matchedUser, final int otherLikeValue, final int maxTimeSec, final String chatTips, final String streamId, final String rtmpUrl, final int remainNum) {
    if (ChatManager.debug) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("onMatched(), state:");
      stringBuilder.append(this.state);
      stringBuilder.append(", roomId:");
      stringBuilder.append(roomId);
      stringBuilder.append(", maxTimeSec:");
      stringBuilder.append(maxTimeSec);
      stringBuilder.append(", chatTips:");
      stringBuilder.append(chatTips);
      stringBuilder.append(", streamId:");
      stringBuilder.append(streamId);
      stringBuilder.append(", remainNum:");
      stringBuilder.append(remainNum);
      Log.v("Chat_FlashVideoHelper", stringBuilder.toString());
    } 
    MatchState matchState1 = this.state;
    MatchState matchState2 = MatchState.MATCHING;
    long l = 0L;
    if (matchState1 == matchState2) {
      this.state = MatchState.CHATING;
      this.matchedRoomId = roomId;
      if (matchedUser != null)
        l = matchedUser.uid; 
      this.matchedUid = l;
      notifyCallback(new Runnable() {
            public void run() {
              if (FlashVideoHelper.this.matchListener != null)
                FlashVideoHelper.this.matchListener.onMatchSuccess(roomId, matchedUser, otherLikeValue, maxTimeSec, chatTips, streamId, rtmpUrl, remainNum); 
            }
          });
      return;
    } 
    FlashVideo flashVideo = this.flashVideoImpl;
    if (matchedUser != null)
      l = matchedUser.uid; 
    flashVideo.closeFlashVideo(l, roomId, 2);
  }
  
  public void onReceiveApplyExtraTime(String paramString, final int extraTime) {
    if (ChatManager.debug) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("onReceiveApplyExtraTime(), roomId:");
      stringBuilder.append(paramString);
      stringBuilder.append(", extraTime:");
      stringBuilder.append(extraTime);
      stringBuilder.append(", state");
      stringBuilder.append(this.state);
      stringBuilder.append(", matchAgreeState:");
      stringBuilder.append(this.matchAgreeState);
      Log.v("Chat_FlashVideoHelper", stringBuilder.toString());
    } 
    if (this.state == MatchState.CHATING && TextUtils.equals(this.matchedRoomId, paramString)) {
      this.extraTime = extraTime;
      this.addExtraTimeAgreeState = this.addExtraTimeAgreeState.setAgreeStateOpposite();
      if (this.addExtraTimeAgreeState == BothAgreeState.AGREE_BOTH) {
        this.addExtraTimeAgreeState = BothAgreeState.IDLE;
        notifyCallback(new Runnable() {
              public void run() {
                if (FlashVideoHelper.this.matchListener != null)
                  FlashVideoHelper.this.matchListener.onApplydExtraTimeAgree(extraTime); 
              }
            });
        return;
      } 
      notifyCallback(new Runnable() {
            public void run() {
              if (FlashVideoHelper.this.matchListener != null)
                FlashVideoHelper.this.matchListener.onReceiveAddExtraTimeApply(); 
            }
          });
    } 
  }
  
  public void onReceiveEmoji(String paramString1, final String emojiTag) {
    if (ChatManager.debug) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("onReceiveEmoji(), roomId:");
      stringBuilder.append(paramString1);
      stringBuilder.append(", emojiTag");
      stringBuilder.append(emojiTag);
      stringBuilder.append(", state");
      stringBuilder.append(this.state);
      stringBuilder.append(", matchAgreeState:");
      stringBuilder.append(this.matchAgreeState);
      Log.v("Chat_FlashVideoHelper", stringBuilder.toString());
    } 
    if (this.state == MatchState.CHATING && TextUtils.equals(this.matchedRoomId, paramString1))
      notifyCallback(new Runnable() {
            public void run() {
              if (FlashVideoHelper.this.matchListener != null)
                FlashVideoHelper.this.matchListener.onReceiveEmoji(emojiTag); 
            }
          }); 
  }
  
  public void onReceiveGift(final FlashVideoGiftModel model) {
    if (ChatManager.debug) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("onReceiveGift(), model:");
      stringBuilder.append(model);
      Log.v("Chat_FlashVideoHelper", stringBuilder.toString());
    } 
    if (model != null && this.state == MatchState.CHATING && TextUtils.equals(this.matchedRoomId, model.roomId))
      notifyCallback(new Runnable() {
            public void run() {
              if (FlashVideoHelper.this.matchListener != null)
                FlashVideoHelper.this.matchListener.onReceiveGift(model); 
            }
          }); 
  }
  
  public void onReceiveMatchAgree(String paramString) {
    if (ChatManager.debug) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("onReceiveMatchAgree(), roomId:");
      stringBuilder.append(paramString);
      stringBuilder.append(", state");
      stringBuilder.append(this.state);
      stringBuilder.append(", matchAgreeState:");
      stringBuilder.append(this.matchAgreeState);
      Log.v("Chat_FlashVideoHelper", stringBuilder.toString());
    } 
    if (this.state == MatchState.CHATING && TextUtils.equals(this.matchedRoomId, paramString)) {
      this.matchAgreeState = this.matchAgreeState.setAgreeStateOpposite();
      if (this.matchAgreeState == BothAgreeState.AGREE_BOTH)
        notifyCallback(new Runnable() {
              public void run() {
                if (FlashVideoHelper.this.matchListener != null)
                  FlashVideoHelper.this.matchListener.onMatchAgreed(); 
              }
            }); 
    } 
  }
  
  public void onSayHi(String paramString) {
    if (ChatManager.debug) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("onSayHi(), roomId:");
      stringBuilder.append(paramString);
      stringBuilder.append(", state");
      stringBuilder.append(this.state);
      stringBuilder.append(", matchAgreeState:");
      stringBuilder.append(this.matchAgreeState);
      Log.v("Chat_FlashVideoHelper", stringBuilder.toString());
    } 
    if (this.state == MatchState.CHATING && TextUtils.equals(this.matchedRoomId, paramString))
      notifyCallback(new Runnable() {
            public void run() {
              if (FlashVideoHelper.this.matchListener != null)
                FlashVideoHelper.this.matchListener.onSayHi(); 
            }
          }); 
  }
  
  public void sendEmoji(String paramString) {
    if (ChatManager.debug) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("sendEmoji(), state:");
      stringBuilder.append(this.state);
      Log.v("Chat_FlashVideoHelper", stringBuilder.toString());
    } 
    if (this.state == MatchState.DESTROY) {
      if (ChatManager.debug)
        Log.e("Chat_FlashVideoHelper", "当前状态已经是DESTROY了，不允许再执行sendEmoji操作"); 
      return;
    } 
    this.flashVideoImpl.sendEmoji(this.matchedUid, this.matchedRoomId, paramString);
  }
  
  public void setCallbackHandler(Handler paramHandler) {
    this.callbackHandler = paramHandler;
  }
  
  enum BothAgreeState {
    AGREE_BOTH, AGREE_BOTH_BUT_TIME_OUT, AGREE_OPPOSITE, AGREE_SELF, IDLE, REJECT_SELF;
    
    static {
      AGREE_OPPOSITE = new BothAgreeState("AGREE_OPPOSITE", 2);
      AGREE_BOTH = new BothAgreeState("AGREE_BOTH", 3);
      AGREE_BOTH_BUT_TIME_OUT = new BothAgreeState("AGREE_BOTH_BUT_TIME_OUT", 4);
      REJECT_SELF = new BothAgreeState("REJECT_SELF", 5);
      $VALUES = new BothAgreeState[] { IDLE, AGREE_SELF, AGREE_OPPOSITE, AGREE_BOTH, AGREE_BOTH_BUT_TIME_OUT, REJECT_SELF };
    }
    
    BothAgreeState setAgreeStateOpposite() {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: aload_0
      //   3: getstatic com/blued/android/chat/FlashVideoHelper$BothAgreeState.IDLE : Lcom/blued/android/chat/FlashVideoHelper$BothAgreeState;
      //   6: if_acmpne -> 17
      //   9: getstatic com/blued/android/chat/FlashVideoHelper$BothAgreeState.AGREE_OPPOSITE : Lcom/blued/android/chat/FlashVideoHelper$BothAgreeState;
      //   12: astore_1
      //   13: aload_0
      //   14: monitorexit
      //   15: aload_1
      //   16: areturn
      //   17: aload_0
      //   18: getstatic com/blued/android/chat/FlashVideoHelper$BothAgreeState.AGREE_SELF : Lcom/blued/android/chat/FlashVideoHelper$BothAgreeState;
      //   21: if_acmpne -> 32
      //   24: getstatic com/blued/android/chat/FlashVideoHelper$BothAgreeState.AGREE_BOTH : Lcom/blued/android/chat/FlashVideoHelper$BothAgreeState;
      //   27: astore_1
      //   28: aload_0
      //   29: monitorexit
      //   30: aload_1
      //   31: areturn
      //   32: aload_0
      //   33: monitorexit
      //   34: aload_0
      //   35: areturn
      //   36: astore_1
      //   37: aload_0
      //   38: monitorexit
      //   39: aload_1
      //   40: athrow
      // Exception table:
      //   from	to	target	type
      //   2	13	36	finally
      //   17	28	36	finally
    }
    
    BothAgreeState setAgreeStateReject() {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: getstatic com/blued/android/chat/FlashVideoHelper$BothAgreeState.AGREE_SELF : Lcom/blued/android/chat/FlashVideoHelper$BothAgreeState;
      //   5: astore_1
      //   6: aload_0
      //   7: aload_1
      //   8: if_acmpne -> 15
      //   11: aload_0
      //   12: monitorexit
      //   13: aload_0
      //   14: areturn
      //   15: aload_0
      //   16: getstatic com/blued/android/chat/FlashVideoHelper$BothAgreeState.AGREE_BOTH : Lcom/blued/android/chat/FlashVideoHelper$BothAgreeState;
      //   19: if_acmpne -> 30
      //   22: getstatic com/blued/android/chat/FlashVideoHelper$BothAgreeState.AGREE_BOTH_BUT_TIME_OUT : Lcom/blued/android/chat/FlashVideoHelper$BothAgreeState;
      //   25: astore_1
      //   26: aload_0
      //   27: monitorexit
      //   28: aload_1
      //   29: areturn
      //   30: getstatic com/blued/android/chat/FlashVideoHelper$BothAgreeState.REJECT_SELF : Lcom/blued/android/chat/FlashVideoHelper$BothAgreeState;
      //   33: astore_1
      //   34: aload_0
      //   35: monitorexit
      //   36: aload_1
      //   37: areturn
      //   38: astore_1
      //   39: aload_0
      //   40: monitorexit
      //   41: aload_1
      //   42: athrow
      // Exception table:
      //   from	to	target	type
      //   2	6	38	finally
      //   15	26	38	finally
      //   30	34	38	finally
    }
    
    BothAgreeState setAgreeStateSelf() {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: aload_0
      //   3: getstatic com/blued/android/chat/FlashVideoHelper$BothAgreeState.IDLE : Lcom/blued/android/chat/FlashVideoHelper$BothAgreeState;
      //   6: if_acmpne -> 17
      //   9: getstatic com/blued/android/chat/FlashVideoHelper$BothAgreeState.AGREE_SELF : Lcom/blued/android/chat/FlashVideoHelper$BothAgreeState;
      //   12: astore_1
      //   13: aload_0
      //   14: monitorexit
      //   15: aload_1
      //   16: areturn
      //   17: aload_0
      //   18: getstatic com/blued/android/chat/FlashVideoHelper$BothAgreeState.AGREE_OPPOSITE : Lcom/blued/android/chat/FlashVideoHelper$BothAgreeState;
      //   21: if_acmpne -> 32
      //   24: getstatic com/blued/android/chat/FlashVideoHelper$BothAgreeState.AGREE_BOTH : Lcom/blued/android/chat/FlashVideoHelper$BothAgreeState;
      //   27: astore_1
      //   28: aload_0
      //   29: monitorexit
      //   30: aload_1
      //   31: areturn
      //   32: aload_0
      //   33: monitorexit
      //   34: aload_0
      //   35: areturn
      //   36: astore_1
      //   37: aload_0
      //   38: monitorexit
      //   39: aload_1
      //   40: athrow
      // Exception table:
      //   from	to	target	type
      //   2	13	36	finally
      //   17	28	36	finally
    }
  }
  
  public static interface CloseReason {
    public static final int CLOSE_BY_PEER = 0;
    
    public static final int CLOSE_BY_VIOLATION_PEER = 1;
    
    public static final int CLOSE_BY_VIOLATION_SELF = 2;
  }
  
  public enum MatchFailed {
    FUNCTION_LOCK, NETWORK, UNKNOWN, USER_BLOCK;
    
    static {
      UNKNOWN = new MatchFailed("UNKNOWN", 3);
      $VALUES = new MatchFailed[] { NETWORK, FUNCTION_LOCK, USER_BLOCK, UNKNOWN };
    }
  }
  
  public static interface MatchListener {
    void onApplyFriends();
    
    void onApplyFriendsAgree();
    
    void onApplyFriendsReq(Map param1Map);
    
    void onApplydExtraTimeAgree(int param1Int);
    
    void onChatClose(int param1Int, String param1String);
    
    void onMatchAgreed();
    
    void onMatchFailed(FlashVideoHelper.MatchFailed param1MatchFailed, String param1String, int param1Int);
    
    void onMatchSuccess(String param1String1, RelationProfileData param1RelationProfileData, int param1Int1, int param1Int2, String param1String2, String param1String3, String param1String4, int param1Int3);
    
    void onMatchWaiting(String param1String, List<String> param1List);
    
    void onReceiveAddExtraTimeApply();
    
    void onReceiveEmoji(String param1String);
    
    void onReceiveGift(FlashVideoGiftModel param1FlashVideoGiftModel);
    
    void onSayHi();
  }
  
  enum MatchState {
    CHATING, DESTROY, IDLE, MATCHING;
    
    static {
      $VALUES = new MatchState[] { IDLE, MATCHING, CHATING, DESTROY };
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\blued\android\chat\FlashVideoHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */