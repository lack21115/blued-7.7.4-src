package com.blued.android.chat;

import android.os.Handler;
import com.blued.android.chat.core.utils.Log;
import com.blued.android.chat.core.worker.chat.WawajiControllerChat;
import com.blued.android.chat.utils.MsgPackHelper;
import java.util.List;
import java.util.Map;

public class WawajiControllerHelper implements WawajiControllerChat.IWawajiControllerCallback {
  private static final String TAG = "Chat_WawajiController";
  
  private final Handler callBackHandler;
  
  private final long controllerVersionCode;
  
  private DeviceState deviceState = DeviceState.IDLE;
  
  private final GameDataOper gameDataOper;
  
  private boolean playingCheck = false;
  
  private WawajiGamePlaying playingData;
  
  private long sessionId;
  
  private final WawajiCallback wawajiCallback;
  
  private WawajiControllerChat wawajiControllerChat;
  
  public WawajiControllerHelper(GameDataOper paramGameDataOper, long paramLong, WawajiCallback paramWawajiCallback, Handler paramHandler) {
    this.gameDataOper = paramGameDataOper;
    this.wawajiCallback = paramWawajiCallback;
    this.callBackHandler = paramHandler;
    this.controllerVersionCode = paramLong;
    this.wawajiControllerChat = ChatManager.getInstance().registerWawajiControllerHelper(this);
    int i = uploadGameRecord();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(i);
    stringBuilder.append("条记录需要上报");
    notifyDebugTips(stringBuilder.toString());
    initController();
    stringBuilder = new StringBuilder();
    stringBuilder.append("初始化设备，当前控制器版本号: ");
    stringBuilder.append(paramLong);
    notifyDebugTips(stringBuilder.toString());
    setState(DeviceState.INIT);
  }
  
  private void checkGamePlaying() {
    if (this.deviceState == DeviceState.WAIT && !this.playingCheck) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("当前状态为 ");
      stringBuilder.append(this.deviceState);
      stringBuilder.append(", 进行服务器查询操作");
      notifyDebugTips(stringBuilder.toString());
      this.playingCheck = true;
      this.wawajiControllerChat.checkPlayingState(this.sessionId);
    } 
  }
  
  private void initController() {
    this.wawajiControllerChat.initController();
  }
  
  private void notifyCallback(Runnable paramRunnable) {
    Handler handler = this.callBackHandler;
    if (handler != null) {
      handler.post(paramRunnable);
      return;
    } 
    paramRunnable.run();
  }
  
  private void notifyDebugTips(String paramString) {
    Log.v("Chat_WawajiController", paramString);
    if (ChatManager.debug && (ChatManager.getInstance()).debugTipsListener != null)
      (ChatManager.getInstance()).debugTipsListener.onTips(paramString); 
  }
  
  private void setState(DeviceState paramDeviceState) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("控制器初状态由 ");
    stringBuilder.append(this.deviceState);
    stringBuilder.append(" 切换到 ");
    stringBuilder.append(paramDeviceState);
    notifyDebugTips(stringBuilder.toString());
    this.deviceState = paramDeviceState;
  }
  
  private int uploadGameRecord() {
    GameDataOper gameDataOper = this.gameDataOper;
    if (gameDataOper != null) {
      List<WawajiGameResult> list = gameDataOper.getGameDataRecords();
      if (list != null) {
        if (list.size() <= 0)
          return 0; 
        for (WawajiGameResult wawajiGameResult : list)
          this.wawajiControllerChat.uploadGameResult(wawajiGameResult); 
        return list.size();
      } 
    } 
    return 0;
  }
  
  public boolean checkPlayerOperation(long paramLong) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: getstatic com/blued/android/chat/ChatManager.debug : Z
    //   5: ifeq -> 43
    //   8: new java/lang/StringBuilder
    //   11: dup
    //   12: invokespecial <init> : ()V
    //   15: astore #5
    //   17: aload #5
    //   19: ldc 'checkPlayerOperation(), operationUid:'
    //   21: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   24: pop
    //   25: aload #5
    //   27: lload_1
    //   28: invokevirtual append : (J)Ljava/lang/StringBuilder;
    //   31: pop
    //   32: ldc 'Chat_WawajiController'
    //   34: aload #5
    //   36: invokevirtual toString : ()Ljava/lang/String;
    //   39: invokestatic v : (Ljava/lang/String;Ljava/lang/String;)I
    //   42: pop
    //   43: aload_0
    //   44: getfield deviceState : Lcom/blued/android/chat/WawajiControllerHelper$DeviceState;
    //   47: getstatic com/blued/android/chat/WawajiControllerHelper$DeviceState.PLAY : Lcom/blued/android/chat/WawajiControllerHelper$DeviceState;
    //   50: if_acmpne -> 78
    //   53: aload_0
    //   54: getfield playingData : Lcom/blued/android/chat/WawajiControllerHelper$WawajiGamePlaying;
    //   57: ifnull -> 78
    //   60: aload_0
    //   61: getfield playingData : Lcom/blued/android/chat/WawajiControllerHelper$WawajiGamePlaying;
    //   64: getfield playerUid : J
    //   67: lstore_3
    //   68: lload_3
    //   69: lload_1
    //   70: lcmp
    //   71: ifne -> 78
    //   74: aload_0
    //   75: monitorexit
    //   76: iconst_1
    //   77: ireturn
    //   78: new java/lang/StringBuilder
    //   81: dup
    //   82: invokespecial <init> : ()V
    //   85: astore #6
    //   87: aload #6
    //   89: ldc '用户操作检查失败, 当前状态:'
    //   91: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   94: pop
    //   95: aload #6
    //   97: aload_0
    //   98: getfield deviceState : Lcom/blued/android/chat/WawajiControllerHelper$DeviceState;
    //   101: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   104: pop
    //   105: aload #6
    //   107: ldc ', operationUid:'
    //   109: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   112: pop
    //   113: aload #6
    //   115: lload_1
    //   116: invokevirtual append : (J)Ljava/lang/StringBuilder;
    //   119: pop
    //   120: aload #6
    //   122: ldc ', need_playingUid:'
    //   124: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   127: pop
    //   128: aload_0
    //   129: getfield playingData : Lcom/blued/android/chat/WawajiControllerHelper$WawajiGamePlaying;
    //   132: ifnonnull -> 142
    //   135: ldc 'null'
    //   137: astore #5
    //   139: goto -> 154
    //   142: aload_0
    //   143: getfield playingData : Lcom/blued/android/chat/WawajiControllerHelper$WawajiGamePlaying;
    //   146: getfield playerUid : J
    //   149: invokestatic valueOf : (J)Ljava/lang/Long;
    //   152: astore #5
    //   154: aload #6
    //   156: aload #5
    //   158: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   161: pop
    //   162: aload_0
    //   163: aload #6
    //   165: invokevirtual toString : ()Ljava/lang/String;
    //   168: invokespecial notifyDebugTips : (Ljava/lang/String;)V
    //   171: aload_0
    //   172: invokespecial checkGamePlaying : ()V
    //   175: aload_0
    //   176: monitorexit
    //   177: iconst_0
    //   178: ireturn
    //   179: astore #5
    //   181: aload_0
    //   182: monitorexit
    //   183: aload #5
    //   185: athrow
    // Exception table:
    //   from	to	target	type
    //   2	43	179	finally
    //   43	68	179	finally
    //   78	135	179	finally
    //   142	154	179	finally
    //   154	175	179	finally
  }
  
  public void destroy() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: getstatic com/blued/android/chat/ChatManager.debug : Z
    //   5: ifeq -> 16
    //   8: ldc 'Chat_WawajiController'
    //   10: ldc 'destroy()'
    //   12: invokestatic v : (Ljava/lang/String;Ljava/lang/String;)I
    //   15: pop
    //   16: aload_0
    //   17: getstatic com/blued/android/chat/WawajiControllerHelper$DeviceState.DEAD : Lcom/blued/android/chat/WawajiControllerHelper$DeviceState;
    //   20: invokespecial setState : (Lcom/blued/android/chat/WawajiControllerHelper$DeviceState;)V
    //   23: aload_0
    //   24: aconst_null
    //   25: putfield wawajiControllerChat : Lcom/blued/android/chat/core/worker/chat/WawajiControllerChat;
    //   28: invokestatic getInstance : ()Lcom/blued/android/chat/ChatManager;
    //   31: aload_0
    //   32: invokevirtual unregisterWawajiControllerHelper : (Lcom/blued/android/chat/WawajiControllerHelper;)V
    //   35: aload_0
    //   36: monitorexit
    //   37: return
    //   38: astore_1
    //   39: aload_0
    //   40: monitorexit
    //   41: aload_1
    //   42: athrow
    // Exception table:
    //   from	to	target	type
    //   2	16	38	finally
    //   16	35	38	finally
  }
  
  public void deviceReady() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getstatic com/blued/android/chat/WawajiControllerHelper$DeviceState.WAIT : Lcom/blued/android/chat/WawajiControllerHelper$DeviceState;
    //   6: invokespecial setState : (Lcom/blued/android/chat/WawajiControllerHelper$DeviceState;)V
    //   9: aload_0
    //   10: ldc '当前设备初始化完成, 等待玩家...'
    //   12: invokespecial notifyDebugTips : (Ljava/lang/String;)V
    //   15: aload_0
    //   16: getfield wawajiControllerChat : Lcom/blued/android/chat/core/worker/chat/WawajiControllerChat;
    //   19: aload_0
    //   20: getfield sessionId : J
    //   23: invokevirtual readyController : (J)V
    //   26: aload_0
    //   27: monitorexit
    //   28: return
    //   29: astore_1
    //   30: aload_0
    //   31: monitorexit
    //   32: aload_1
    //   33: athrow
    // Exception table:
    //   from	to	target	type
    //   2	26	29	finally
  }
  
  public void gameOver(int paramInt) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: new java/lang/StringBuilder
    //   5: dup
    //   6: invokespecial <init> : ()V
    //   9: astore_2
    //   10: aload_2
    //   11: ldc '游戏完成, result:'
    //   13: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16: pop
    //   17: aload_2
    //   18: iload_1
    //   19: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   22: pop
    //   23: aload_2
    //   24: ldc_w ', playingData:'
    //   27: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   30: pop
    //   31: aload_2
    //   32: aload_0
    //   33: getfield playingData : Lcom/blued/android/chat/WawajiControllerHelper$WawajiGamePlaying;
    //   36: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   39: pop
    //   40: aload_0
    //   41: aload_2
    //   42: invokevirtual toString : ()Ljava/lang/String;
    //   45: invokespecial notifyDebugTips : (Ljava/lang/String;)V
    //   48: aload_0
    //   49: getfield deviceState : Lcom/blued/android/chat/WawajiControllerHelper$DeviceState;
    //   52: getstatic com/blued/android/chat/WawajiControllerHelper$DeviceState.PLAY : Lcom/blued/android/chat/WawajiControllerHelper$DeviceState;
    //   55: if_acmpne -> 68
    //   58: aload_0
    //   59: getstatic com/blued/android/chat/WawajiControllerHelper$DeviceState.WAIT : Lcom/blued/android/chat/WawajiControllerHelper$DeviceState;
    //   62: invokespecial setState : (Lcom/blued/android/chat/WawajiControllerHelper$DeviceState;)V
    //   65: goto -> 117
    //   68: new java/lang/StringBuilder
    //   71: dup
    //   72: invokespecial <init> : ()V
    //   75: astore_2
    //   76: aload_2
    //   77: ldc_w '控制器状态异常, 当前状态:'
    //   80: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   83: pop
    //   84: aload_2
    //   85: aload_0
    //   86: getfield deviceState : Lcom/blued/android/chat/WawajiControllerHelper$DeviceState;
    //   89: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   92: pop
    //   93: aload_2
    //   94: ldc_w ', 期望:'
    //   97: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   100: pop
    //   101: aload_2
    //   102: getstatic com/blued/android/chat/WawajiControllerHelper$DeviceState.PLAY : Lcom/blued/android/chat/WawajiControllerHelper$DeviceState;
    //   105: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   108: pop
    //   109: aload_0
    //   110: aload_2
    //   111: invokevirtual toString : ()Ljava/lang/String;
    //   114: invokespecial notifyDebugTips : (Ljava/lang/String;)V
    //   117: aload_0
    //   118: getfield playingData : Lcom/blued/android/chat/WawajiControllerHelper$WawajiGamePlaying;
    //   121: ifnull -> 236
    //   124: aload_0
    //   125: getfield playingData : Lcom/blued/android/chat/WawajiControllerHelper$WawajiGamePlaying;
    //   128: iload_1
    //   129: invokevirtual createGameResult : (I)Lcom/blued/android/chat/WawajiControllerHelper$WawajiGameResult;
    //   132: astore_2
    //   133: aload_0
    //   134: getfield gameDataOper : Lcom/blued/android/chat/WawajiControllerHelper$GameDataOper;
    //   137: ifnull -> 223
    //   140: aload_0
    //   141: getfield gameDataOper : Lcom/blued/android/chat/WawajiControllerHelper$GameDataOper;
    //   144: aload_2
    //   145: invokeinterface saveGameDataRecord : (Lcom/blued/android/chat/WawajiControllerHelper$WawajiGameResult;)I
    //   150: istore_1
    //   151: iload_1
    //   152: ifgt -> 188
    //   155: new java/lang/StringBuilder
    //   158: dup
    //   159: invokespecial <init> : ()V
    //   162: astore_3
    //   163: aload_3
    //   164: ldc_w '游戏结果保存失败, saveId:'
    //   167: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   170: pop
    //   171: aload_3
    //   172: iload_1
    //   173: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   176: pop
    //   177: aload_0
    //   178: aload_3
    //   179: invokevirtual toString : ()Ljava/lang/String;
    //   182: invokespecial notifyDebugTips : (Ljava/lang/String;)V
    //   185: goto -> 218
    //   188: new java/lang/StringBuilder
    //   191: dup
    //   192: invokespecial <init> : ()V
    //   195: astore_3
    //   196: aload_3
    //   197: ldc_w '游戏结果已保存, saveId:'
    //   200: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   203: pop
    //   204: aload_3
    //   205: iload_1
    //   206: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   209: pop
    //   210: aload_0
    //   211: aload_3
    //   212: invokevirtual toString : ()Ljava/lang/String;
    //   215: invokespecial notifyDebugTips : (Ljava/lang/String;)V
    //   218: aload_2
    //   219: iload_1
    //   220: putfield id : I
    //   223: aload_0
    //   224: getfield wawajiControllerChat : Lcom/blued/android/chat/core/worker/chat/WawajiControllerChat;
    //   227: aload_2
    //   228: invokevirtual uploadGameResult : (Lcom/blued/android/chat/WawajiControllerHelper$WawajiGameResult;)V
    //   231: aload_0
    //   232: aconst_null
    //   233: putfield playingData : Lcom/blued/android/chat/WawajiControllerHelper$WawajiGamePlaying;
    //   236: aload_0
    //   237: monitorexit
    //   238: return
    //   239: astore_2
    //   240: aload_0
    //   241: monitorexit
    //   242: aload_2
    //   243: athrow
    // Exception table:
    //   from	to	target	type
    //   2	65	239	finally
    //   68	117	239	finally
    //   117	151	239	finally
    //   155	185	239	finally
    //   188	218	239	finally
    //   218	223	239	finally
    //   223	236	239	finally
  }
  
  public void onControllerUpdate(long paramLong, String paramString) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: new java/lang/StringBuilder
    //   5: dup
    //   6: invokespecial <init> : ()V
    //   9: astore #4
    //   11: aload #4
    //   13: ldc_w '接收到升级通知, 控制器版本:'
    //   16: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   19: pop
    //   20: aload #4
    //   22: aload_0
    //   23: getfield controllerVersionCode : J
    //   26: invokevirtual append : (J)Ljava/lang/StringBuilder;
    //   29: pop
    //   30: aload #4
    //   32: ldc_w ', 升级版本:'
    //   35: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   38: pop
    //   39: aload #4
    //   41: lload_1
    //   42: invokevirtual append : (J)Ljava/lang/StringBuilder;
    //   45: pop
    //   46: aload_0
    //   47: aload #4
    //   49: invokevirtual toString : ()Ljava/lang/String;
    //   52: invokespecial notifyDebugTips : (Ljava/lang/String;)V
    //   55: lload_1
    //   56: aload_0
    //   57: getfield controllerVersionCode : J
    //   60: lcmp
    //   61: ifle -> 78
    //   64: aload_0
    //   65: new com/blued/android/chat/WawajiControllerHelper$3
    //   68: dup
    //   69: aload_0
    //   70: lload_1
    //   71: aload_3
    //   72: invokespecial <init> : (Lcom/blued/android/chat/WawajiControllerHelper;JLjava/lang/String;)V
    //   75: invokespecial notifyCallback : (Ljava/lang/Runnable;)V
    //   78: aload_0
    //   79: monitorexit
    //   80: return
    //   81: astore_3
    //   82: aload_0
    //   83: monitorexit
    //   84: aload_3
    //   85: athrow
    // Exception table:
    //   from	to	target	type
    //   2	78	81	finally
  }
  
  public void onInitControllerFailed(String paramString) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: new java/lang/StringBuilder
    //   5: dup
    //   6: invokespecial <init> : ()V
    //   9: astore_2
    //   10: aload_2
    //   11: ldc_w '控制器初始化失败, errorMsg:'
    //   14: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   17: pop
    //   18: aload_2
    //   19: aload_1
    //   20: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: pop
    //   24: aload_0
    //   25: aload_2
    //   26: invokevirtual toString : ()Ljava/lang/String;
    //   29: invokespecial notifyDebugTips : (Ljava/lang/String;)V
    //   32: aload_0
    //   33: monitorexit
    //   34: return
    //   35: astore_1
    //   36: aload_0
    //   37: monitorexit
    //   38: aload_1
    //   39: athrow
    // Exception table:
    //   from	to	target	type
    //   2	32	35	finally
  }
  
  public void onInitControllerSuccess(long paramLong, String paramString1, String paramString2, String paramString3) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: new java/lang/StringBuilder
    //   5: dup
    //   6: invokespecial <init> : ()V
    //   9: astore #6
    //   11: aload #6
    //   13: ldc_w '控制器初始化成功, sessionId:'
    //   16: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   19: pop
    //   20: aload #6
    //   22: lload_1
    //   23: invokevirtual append : (J)Ljava/lang/StringBuilder;
    //   26: pop
    //   27: aload #6
    //   29: ldc_w ', roomId:'
    //   32: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   35: pop
    //   36: aload #6
    //   38: aload_3
    //   39: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   42: pop
    //   43: aload #6
    //   45: ldc_w ', streamId1:'
    //   48: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   51: pop
    //   52: aload #6
    //   54: aload #4
    //   56: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   59: pop
    //   60: aload #6
    //   62: ldc_w ', streamId2:'
    //   65: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   68: pop
    //   69: aload #6
    //   71: aload #5
    //   73: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   76: pop
    //   77: aload_0
    //   78: aload #6
    //   80: invokevirtual toString : ()Ljava/lang/String;
    //   83: invokespecial notifyDebugTips : (Ljava/lang/String;)V
    //   86: aload_0
    //   87: lload_1
    //   88: putfield sessionId : J
    //   91: aload_0
    //   92: getfield deviceState : Lcom/blued/android/chat/WawajiControllerHelper$DeviceState;
    //   95: getstatic com/blued/android/chat/WawajiControllerHelper$DeviceState.INIT : Lcom/blued/android/chat/WawajiControllerHelper$DeviceState;
    //   98: if_acmpeq -> 153
    //   101: new java/lang/StringBuilder
    //   104: dup
    //   105: invokespecial <init> : ()V
    //   108: astore_3
    //   109: aload_3
    //   110: ldc_w '控制器状态异常, 当前状态:'
    //   113: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   116: pop
    //   117: aload_3
    //   118: aload_0
    //   119: getfield deviceState : Lcom/blued/android/chat/WawajiControllerHelper$DeviceState;
    //   122: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   125: pop
    //   126: aload_3
    //   127: ldc_w ', 需要:'
    //   130: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   133: pop
    //   134: aload_3
    //   135: getstatic com/blued/android/chat/WawajiControllerHelper$DeviceState.INIT : Lcom/blued/android/chat/WawajiControllerHelper$DeviceState;
    //   138: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   141: pop
    //   142: aload_0
    //   143: aload_3
    //   144: invokevirtual toString : ()Ljava/lang/String;
    //   147: invokespecial notifyDebugTips : (Ljava/lang/String;)V
    //   150: aload_0
    //   151: monitorexit
    //   152: return
    //   153: aload_0
    //   154: getstatic com/blued/android/chat/WawajiControllerHelper$DeviceState.STREAM : Lcom/blued/android/chat/WawajiControllerHelper$DeviceState;
    //   157: invokespecial setState : (Lcom/blued/android/chat/WawajiControllerHelper$DeviceState;)V
    //   160: aload_0
    //   161: new com/blued/android/chat/WawajiControllerHelper$1
    //   164: dup
    //   165: aload_0
    //   166: aload_3
    //   167: aload #4
    //   169: aload #5
    //   171: invokespecial <init> : (Lcom/blued/android/chat/WawajiControllerHelper;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   174: invokespecial notifyCallback : (Ljava/lang/Runnable;)V
    //   177: aload_0
    //   178: monitorexit
    //   179: return
    //   180: astore_3
    //   181: aload_0
    //   182: monitorexit
    //   183: aload_3
    //   184: athrow
    // Exception table:
    //   from	to	target	type
    //   2	150	180	finally
    //   153	177	180	finally
  }
  
  public void onPlayCheckFailed(String paramString) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: iconst_0
    //   4: putfield playingCheck : Z
    //   7: new java/lang/StringBuilder
    //   10: dup
    //   11: invokespecial <init> : ()V
    //   14: astore_2
    //   15: aload_2
    //   16: ldc_w '控制器play确认失败, errorMsg:'
    //   19: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   22: pop
    //   23: aload_2
    //   24: aload_1
    //   25: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   28: pop
    //   29: aload_0
    //   30: aload_2
    //   31: invokevirtual toString : ()Ljava/lang/String;
    //   34: invokespecial notifyDebugTips : (Ljava/lang/String;)V
    //   37: aload_0
    //   38: monitorexit
    //   39: return
    //   40: astore_1
    //   41: aload_0
    //   42: monitorexit
    //   43: aload_1
    //   44: athrow
    // Exception table:
    //   from	to	target	type
    //   2	37	40	finally
  }
  
  public void onPlayCheckSuccess() {
    this.playingCheck = false;
    notifyDebugTips("控制器play确认成功");
  }
  
  public void onPlayConfig(long paramLong, String paramString, WawajiControllerConfig paramWawajiControllerConfig) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield deviceState : Lcom/blued/android/chat/WawajiControllerHelper$DeviceState;
    //   6: getstatic com/blued/android/chat/WawajiControllerHelper$DeviceState.WAIT : Lcom/blued/android/chat/WawajiControllerHelper$DeviceState;
    //   9: if_acmpne -> 108
    //   12: aload_0
    //   13: ldc_w '收到游戏配置，开始进入游戏状态'
    //   16: invokespecial notifyDebugTips : (Ljava/lang/String;)V
    //   19: aload_0
    //   20: new com/blued/android/chat/WawajiControllerHelper$WawajiGamePlaying
    //   23: dup
    //   24: aconst_null
    //   25: invokespecial <init> : (Lcom/blued/android/chat/WawajiControllerHelper$1;)V
    //   28: putfield playingData : Lcom/blued/android/chat/WawajiControllerHelper$WawajiGamePlaying;
    //   31: aload_0
    //   32: getfield playingData : Lcom/blued/android/chat/WawajiControllerHelper$WawajiGamePlaying;
    //   35: lload_1
    //   36: putfield playerUid : J
    //   39: aload_0
    //   40: getfield playingData : Lcom/blued/android/chat/WawajiControllerHelper$WawajiGamePlaying;
    //   43: aload_3
    //   44: putfield orderId : Ljava/lang/String;
    //   47: aload_0
    //   48: getfield playingData : Lcom/blued/android/chat/WawajiControllerHelper$WawajiGamePlaying;
    //   51: aload_0
    //   52: getfield sessionId : J
    //   55: putfield sessionId : J
    //   58: aload_0
    //   59: getfield playingData : Lcom/blued/android/chat/WawajiControllerHelper$WawajiGamePlaying;
    //   62: aload #4
    //   64: getfield play_maxtime : I
    //   67: putfield maxTimeSec : I
    //   70: aload_0
    //   71: getfield playingData : Lcom/blued/android/chat/WawajiControllerHelper$WawajiGamePlaying;
    //   74: invokestatic currentTimeMillis : ()J
    //   77: ldc2_w 1000
    //   80: ldiv
    //   81: putfield startTimeSec : J
    //   84: aload_0
    //   85: getstatic com/blued/android/chat/WawajiControllerHelper$DeviceState.PLAY : Lcom/blued/android/chat/WawajiControllerHelper$DeviceState;
    //   88: invokespecial setState : (Lcom/blued/android/chat/WawajiControllerHelper$DeviceState;)V
    //   91: aload_0
    //   92: new com/blued/android/chat/WawajiControllerHelper$2
    //   95: dup
    //   96: aload_0
    //   97: aload #4
    //   99: invokespecial <init> : (Lcom/blued/android/chat/WawajiControllerHelper;Lcom/blued/android/chat/WawajiControllerHelper$WawajiControllerConfig;)V
    //   102: invokespecial notifyCallback : (Ljava/lang/Runnable;)V
    //   105: goto -> 157
    //   108: new java/lang/StringBuilder
    //   111: dup
    //   112: invokespecial <init> : ()V
    //   115: astore_3
    //   116: aload_3
    //   117: ldc_w '当前控制器状态异常，当前状态:'
    //   120: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   123: pop
    //   124: aload_3
    //   125: aload_0
    //   126: getfield deviceState : Lcom/blued/android/chat/WawajiControllerHelper$DeviceState;
    //   129: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   132: pop
    //   133: aload_3
    //   134: ldc_w ', 期望:'
    //   137: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   140: pop
    //   141: aload_3
    //   142: getstatic com/blued/android/chat/WawajiControllerHelper$DeviceState.WAIT : Lcom/blued/android/chat/WawajiControllerHelper$DeviceState;
    //   145: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   148: pop
    //   149: aload_0
    //   150: aload_3
    //   151: invokevirtual toString : ()Ljava/lang/String;
    //   154: invokespecial notifyDebugTips : (Ljava/lang/String;)V
    //   157: aload_0
    //   158: monitorexit
    //   159: return
    //   160: astore_3
    //   161: aload_0
    //   162: monitorexit
    //   163: aload_3
    //   164: athrow
    // Exception table:
    //   from	to	target	type
    //   2	105	160	finally
    //   108	157	160	finally
  }
  
  public void onReadyControllerFailed(String paramString) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: new java/lang/StringBuilder
    //   5: dup
    //   6: invokespecial <init> : ()V
    //   9: astore_2
    //   10: aload_2
    //   11: ldc_w '控制器ready通知失败, errorMsg:'
    //   14: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   17: pop
    //   18: aload_2
    //   19: aload_1
    //   20: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: pop
    //   24: aload_0
    //   25: aload_2
    //   26: invokevirtual toString : ()Ljava/lang/String;
    //   29: invokespecial notifyDebugTips : (Ljava/lang/String;)V
    //   32: aload_0
    //   33: monitorexit
    //   34: return
    //   35: astore_1
    //   36: aload_0
    //   37: monitorexit
    //   38: aload_1
    //   39: athrow
    // Exception table:
    //   from	to	target	type
    //   2	32	35	finally
  }
  
  public void onReadyControllerSuccess() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: ldc_w '控制器ready通知成功'
    //   6: invokespecial notifyDebugTips : (Ljava/lang/String;)V
    //   9: aload_0
    //   10: monitorexit
    //   11: return
    //   12: astore_1
    //   13: aload_0
    //   14: monitorexit
    //   15: aload_1
    //   16: athrow
    // Exception table:
    //   from	to	target	type
    //   2	9	12	finally
  }
  
  public void onUploadGameResultFailed(WawajiGameResult paramWawajiGameResult, String paramString) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: new java/lang/StringBuilder
    //   5: dup
    //   6: invokespecial <init> : ()V
    //   9: astore_3
    //   10: aload_3
    //   11: ldc_w '游戏记录 '
    //   14: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   17: pop
    //   18: aload_3
    //   19: aload_1
    //   20: getfield id : I
    //   23: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   26: pop
    //   27: aload_3
    //   28: ldc_w ' 上传失败, errorMsg:'
    //   31: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   34: pop
    //   35: aload_3
    //   36: aload_2
    //   37: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   40: pop
    //   41: aload_0
    //   42: aload_3
    //   43: invokevirtual toString : ()Ljava/lang/String;
    //   46: invokespecial notifyDebugTips : (Ljava/lang/String;)V
    //   49: aload_0
    //   50: monitorexit
    //   51: return
    //   52: astore_1
    //   53: aload_0
    //   54: monitorexit
    //   55: aload_1
    //   56: athrow
    // Exception table:
    //   from	to	target	type
    //   2	49	52	finally
  }
  
  public void onUploadGameResultSuccess(WawajiGameResult paramWawajiGameResult) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: new java/lang/StringBuilder
    //   5: dup
    //   6: invokespecial <init> : ()V
    //   9: astore_2
    //   10: aload_2
    //   11: ldc_w '游戏记录 '
    //   14: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   17: pop
    //   18: aload_2
    //   19: aload_1
    //   20: getfield id : I
    //   23: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   26: pop
    //   27: aload_2
    //   28: ldc_w ' 上传成功'
    //   31: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   34: pop
    //   35: aload_0
    //   36: aload_2
    //   37: invokevirtual toString : ()Ljava/lang/String;
    //   40: invokespecial notifyDebugTips : (Ljava/lang/String;)V
    //   43: aload_0
    //   44: getfield gameDataOper : Lcom/blued/android/chat/WawajiControllerHelper$GameDataOper;
    //   47: ifnull -> 64
    //   50: aload_0
    //   51: getfield gameDataOper : Lcom/blued/android/chat/WawajiControllerHelper$GameDataOper;
    //   54: aload_1
    //   55: getfield id : I
    //   58: invokeinterface deleteGameDataRecord : (I)I
    //   63: pop
    //   64: aload_0
    //   65: monitorexit
    //   66: return
    //   67: astore_1
    //   68: aload_0
    //   69: monitorexit
    //   70: aload_1
    //   71: athrow
    // Exception table:
    //   from	to	target	type
    //   2	64	67	finally
  }
  
  enum DeviceState {
    DEAD, IDLE, INIT, PLAY, STREAM, WAIT;
    
    static {
      DEAD = new DeviceState("DEAD", 5);
      $VALUES = new DeviceState[] { IDLE, INIT, STREAM, WAIT, PLAY, DEAD };
    }
  }
  
  public static interface GameDataOper {
    int deleteGameDataRecord(int param1Int);
    
    List<WawajiControllerHelper.WawajiGameResult> getGameDataRecords();
    
    int saveGameDataRecord(WawajiControllerHelper.WawajiGameResult param1WawajiGameResult);
  }
  
  public static interface WawajiCallback {
    void onInit(String param1String1, String param1String2, String param1String3);
    
    void onPlayGame(WawajiControllerHelper.WawajiControllerConfig param1WawajiControllerConfig);
    
    void onUpdate(long param1Long, String param1String);
  }
  
  public static class WawajiControllerConfig {
    public int at_talon;
    
    public int b_talon;
    
    public int heigh;
    
    public int m_talon;
    
    public int play_maxtime;
    
    public int success;
    
    public int u_talon;
    
    public static WawajiControllerConfig parseData(Map<String, Object> param1Map) {
      WawajiControllerConfig wawajiControllerConfig = new WawajiControllerConfig();
      wawajiControllerConfig.play_maxtime = MsgPackHelper.getIntValue(param1Map, "play_maxtime");
      wawajiControllerConfig.success = MsgPackHelper.getIntValue(param1Map, "success");
      wawajiControllerConfig.u_talon = MsgPackHelper.getIntValue(param1Map, "u_talon");
      wawajiControllerConfig.at_talon = MsgPackHelper.getIntValue(param1Map, "at_talon");
      wawajiControllerConfig.m_talon = MsgPackHelper.getIntValue(param1Map, "m_talon");
      wawajiControllerConfig.b_talon = MsgPackHelper.getIntValue(param1Map, "b_talon");
      wawajiControllerConfig.heigh = MsgPackHelper.getIntValue(param1Map, "heigh");
      return wawajiControllerConfig;
    }
  }
  
  static class WawajiGamePlaying {
    public int maxTimeSec;
    
    public String orderId;
    
    public long playerUid;
    
    public long sessionId;
    
    public long startTimeSec;
    
    private WawajiGamePlaying() {}
    
    public WawajiControllerHelper.WawajiGameResult createGameResult(int param1Int) {
      WawajiControllerHelper.WawajiGameResult wawajiGameResult = new WawajiControllerHelper.WawajiGameResult();
      wawajiGameResult.sessionId = this.sessionId;
      wawajiGameResult.playerUid = this.playerUid;
      wawajiGameResult.orderId = this.orderId;
      wawajiGameResult.result = param1Int;
      return wawajiGameResult;
    }
  }
  
  public static class WawajiGameResult {
    public int id;
    
    public String orderId;
    
    public long playerUid;
    
    public int result = -1;
    
    public long sessionId;
    
    public String toString() {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("[id:");
      stringBuilder.append(this.id);
      stringBuilder.append(", sessionId:");
      stringBuilder.append(this.sessionId);
      stringBuilder.append(", playerUid:");
      stringBuilder.append(this.playerUid);
      stringBuilder.append(", orderId:");
      stringBuilder.append(this.orderId);
      stringBuilder.append(", result:");
      stringBuilder.append(this.result);
      stringBuilder.append("]");
      return stringBuilder.toString();
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\blued\android\chat\WawajiControllerHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */