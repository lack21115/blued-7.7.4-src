package com.blued.android.chat.core.worker.chat;

import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Pair;
import androidx.collection.ArrayMap;
import androidx.collection.LongSparseArray;
import com.blued.android.chat.ChatManager;
import com.blued.android.chat.compatible.GRPC;
import com.blued.android.chat.compatible.IReceiptSender;
import com.blued.android.chat.core.pack.BasePackage;
import com.blued.android.chat.core.pack.DeleteAckPackage;
import com.blued.android.chat.core.pack.DeleteAllPackage;
import com.blued.android.chat.core.pack.DeleteRetractMessagePackage;
import com.blued.android.chat.core.pack.DeleteSessionPackage;
import com.blued.android.chat.core.pack.PackageHandler;
import com.blued.android.chat.core.pack.PushBasePackage;
import com.blued.android.chat.core.pack.PushMsgPackage;
import com.blued.android.chat.core.pack.PushReadedPackage;
import com.blued.android.chat.core.pack.ReqAckPackage;
import com.blued.android.chat.core.pack.ReqBasePackage;
import com.blued.android.chat.core.pack.ReqCreateVideoChatPackage;
import com.blued.android.chat.core.pack.ReqDestroyMsgPackage;
import com.blued.android.chat.core.pack.ReqSessionPackage;
import com.blued.android.chat.core.pack.SendAckPackage;
import com.blued.android.chat.core.pack.SendMsgPackage;
import com.blued.android.chat.core.pack.SyncAckPackage;
import com.blued.android.chat.core.pack.SyncAllSessionsPackage;
import com.blued.android.chat.core.pack.SyncBasePackage;
import com.blued.android.chat.core.pack.SyncIntervalMsgsPackage;
import com.blued.android.chat.core.pack.SyncOfflineMsgPackage;
import com.blued.android.chat.core.utils.Log;
import com.blued.android.chat.core.utils.TimeoutUtils;
import com.blued.android.chat.core.worker.BaseWorker;
import com.blued.android.chat.core.worker.Connector;
import com.blued.android.chat.core.worker.PackSendHelper;
import com.blued.android.chat.data.ConnectState;
import com.blued.android.chat.data.SessionHeader;
import com.blued.android.chat.listener.ChatTipsListener;
import com.blued.android.chat.listener.ConnectListener;
import com.blued.android.chat.listener.DebugTipsListener;
import com.blued.android.chat.listener.FetchDataListener;
import com.blued.android.chat.listener.IMStatusListener;
import com.blued.android.chat.listener.LoadListener;
import com.blued.android.chat.listener.LoadMsgListener;
import com.blued.android.chat.listener.MsgContentListener;
import com.blued.android.chat.listener.MsgPreProcesser;
import com.blued.android.chat.listener.MsgPreProcesserListener;
import com.blued.android.chat.listener.RetractionListener;
import com.blued.android.chat.listener.SessionListener;
import com.blued.android.chat.listener.SingleSessionListener;
import com.blued.android.chat.model.ChattingModel;
import com.blued.android.chat.model.SessionModel;
import com.blued.android.chat.model.SessionProfileModel;
import com.blued.android.chat.model.SessionSettingBaseModel;
import com.blued.android.chat.utils.AtRegExpUtils;
import com.blued.android.chat.utils.ChatHelper;
import com.blued.android.chat.utils.DataUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Chat extends BaseWorker implements PackageHandler, TimeoutUtils.TimeoutListener, ConnectListener, MsgPreProcesserListener {
  private static final int MAX_UNREAD_MSG_COUNT = 100;
  
  private static final String TAG = "Chat_Chat";
  
  protected AudioRoomChat audioRoomChat;
  
  private Connector connector;
  
  private volatile boolean dataSyncing = false;
  
  protected FlashVideo flashVideo;
  
  private final Set<IMStatusListener> imStatusListenerList = new HashSet<IMStatusListener>();
  
  private long initMaxMsgId = 0L;
  
  private volatile long lastSessionListChangedTime = 0L;
  
  protected LiveChat liveChat;
  
  private final Map<String, Set<MsgContentListener>> msgListenerList = (Map<String, Set<MsgContentListener>>)new ArrayMap();
  
  private PackSendHelper packSendHelper;
  
  private ReadedFlagSender readedFlagSender;
  
  private LongSparseArray<String> reqSessionKeyList;
  
  protected RoomChat roomChat;
  
  private final LongSparseArray<SendMsgPackage> sendingPackageList = new LongSparseArray();
  
  public final Map<String, SessionModel> sessionList = (Map<String, SessionModel>)new ArrayMap();
  
  private boolean sessionListInited = false;
  
  private final Set<SessionListener> sessionListenerList = new HashSet<SessionListener>();
  
  private final Map<String, Set<SingleSessionListener>> singleSessionListenerMap = (Map<String, Set<SingleSessionListener>>)new ArrayMap();
  
  public final Map<String, SessionModel> snapSessionList = (Map<String, SessionModel>)new ArrayMap();
  
  private final LongSparseArray<Pair<LoadListener, List<ChattingModel>>> syncLoadListener = new LongSparseArray();
  
  private int syncRetryCount = 0;
  
  protected VideoChat videoChat;
  
  protected WawajiChat wawajiChat;
  
  protected WawajiControllerChat wawajiControllerChat;
  
  public Chat(Connector paramConnector) {
    this.connector = paramConnector;
    this.packSendHelper = paramConnector.getPackageSendHelper();
    this.readedFlagSender = new ReadedFlagSender(paramConnector);
    init();
  }
  
  private void deleteSessions(List<Pair<Short, Long>> paramList, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3) {
    // Byte code:
    //   0: aload_1
    //   1: ifnull -> 573
    //   4: aload_1
    //   5: invokeinterface size : ()I
    //   10: ifgt -> 14
    //   13: return
    //   14: new java/util/ArrayList
    //   17: dup
    //   18: invokespecial <init> : ()V
    //   21: astore #8
    //   23: aload_0
    //   24: getfield sessionList : Ljava/util/Map;
    //   27: astore #6
    //   29: aload #6
    //   31: monitorenter
    //   32: aload_1
    //   33: invokeinterface iterator : ()Ljava/util/Iterator;
    //   38: astore #9
    //   40: iconst_0
    //   41: istore #5
    //   43: aload #9
    //   45: invokeinterface hasNext : ()Z
    //   50: ifeq -> 324
    //   53: aload #9
    //   55: invokeinterface next : ()Ljava/lang/Object;
    //   60: checkcast android/util/Pair
    //   63: astore #10
    //   65: aload #10
    //   67: getfield first : Ljava/lang/Object;
    //   70: checkcast java/lang/Short
    //   73: invokevirtual shortValue : ()S
    //   76: aload #10
    //   78: getfield second : Ljava/lang/Object;
    //   81: checkcast java/lang/Long
    //   84: invokevirtual longValue : ()J
    //   87: invokestatic getSessionKey : (IJ)Ljava/lang/String;
    //   90: astore #11
    //   92: aload_0
    //   93: getfield sessionList : Ljava/util/Map;
    //   96: aload #11
    //   98: invokeinterface remove : (Ljava/lang/Object;)Ljava/lang/Object;
    //   103: checkcast com/blued/android/chat/model/SessionModel
    //   106: astore #12
    //   108: aload_0
    //   109: getfield snapSessionList : Ljava/util/Map;
    //   112: astore #7
    //   114: aload #7
    //   116: monitorenter
    //   117: aload_0
    //   118: getfield snapSessionList : Ljava/util/Map;
    //   121: aload #11
    //   123: invokeinterface remove : (Ljava/lang/Object;)Ljava/lang/Object;
    //   128: pop
    //   129: aload #7
    //   131: monitorexit
    //   132: aload #12
    //   134: ifnull -> 180
    //   137: aload #12
    //   139: getfield sessionType : S
    //   142: iconst_3
    //   143: if_icmpne -> 574
    //   146: aload #8
    //   148: new android/util/Pair
    //   151: dup
    //   152: aload #12
    //   154: getfield sessionType : S
    //   157: invokestatic valueOf : (S)Ljava/lang/Short;
    //   160: aload #12
    //   162: getfield sessionId : J
    //   165: invokestatic valueOf : (J)Ljava/lang/Long;
    //   168: invokespecial <init> : (Ljava/lang/Object;Ljava/lang/Object;)V
    //   171: invokeinterface add : (Ljava/lang/Object;)Z
    //   176: pop
    //   177: goto -> 574
    //   180: iload_2
    //   181: ifeq -> 217
    //   184: getstatic com/blued/android/chat/ChatManager.dbOperImpl : Lcom/blued/android/chat/db/DBOper;
    //   187: aload #10
    //   189: getfield first : Ljava/lang/Object;
    //   192: checkcast java/lang/Short
    //   195: invokevirtual shortValue : ()S
    //   198: aload #10
    //   200: getfield second : Ljava/lang/Object;
    //   203: checkcast java/lang/Long
    //   206: invokevirtual longValue : ()J
    //   209: invokeinterface deleteSessionAndChattingForOne : (IJ)V
    //   214: goto -> 247
    //   217: getstatic com/blued/android/chat/ChatManager.dbOperImpl : Lcom/blued/android/chat/db/DBOper;
    //   220: aload #10
    //   222: getfield first : Ljava/lang/Object;
    //   225: checkcast java/lang/Short
    //   228: invokevirtual shortValue : ()S
    //   231: aload #10
    //   233: getfield second : Ljava/lang/Object;
    //   236: checkcast java/lang/Long
    //   239: invokevirtual longValue : ()J
    //   242: invokeinterface deleteSessionForOne : (IJ)V
    //   247: iload #4
    //   249: ifeq -> 285
    //   252: getstatic com/blued/android/chat/ChatManager.dbOperImpl : Lcom/blued/android/chat/db/DBOper;
    //   255: aload #10
    //   257: getfield first : Ljava/lang/Object;
    //   260: checkcast java/lang/Short
    //   263: invokevirtual shortValue : ()S
    //   266: aload #10
    //   268: getfield second : Ljava/lang/Object;
    //   271: checkcast java/lang/Long
    //   274: invokevirtual longValue : ()J
    //   277: invokeinterface deleteSessionSetting : (SJ)V
    //   282: goto -> 43
    //   285: getstatic com/blued/android/chat/ChatManager.dbOperImpl : Lcom/blued/android/chat/db/DBOper;
    //   288: aload #10
    //   290: getfield first : Ljava/lang/Object;
    //   293: checkcast java/lang/Short
    //   296: invokevirtual shortValue : ()S
    //   299: aload #10
    //   301: getfield second : Ljava/lang/Object;
    //   304: checkcast java/lang/Long
    //   307: invokevirtual longValue : ()J
    //   310: invokeinterface deleteNoGroupSessionSetting : (SJ)V
    //   315: goto -> 43
    //   318: astore_1
    //   319: aload #7
    //   321: monitorexit
    //   322: aload_1
    //   323: athrow
    //   324: aload #6
    //   326: monitorexit
    //   327: iload #5
    //   329: ifeq -> 437
    //   332: aload_1
    //   333: invokeinterface size : ()I
    //   338: iconst_1
    //   339: if_icmpne -> 433
    //   342: iload_2
    //   343: ifeq -> 388
    //   346: aload_0
    //   347: aload_1
    //   348: iconst_0
    //   349: invokeinterface get : (I)Ljava/lang/Object;
    //   354: checkcast android/util/Pair
    //   357: getfield first : Ljava/lang/Object;
    //   360: checkcast java/lang/Short
    //   363: invokevirtual shortValue : ()S
    //   366: aload_1
    //   367: iconst_0
    //   368: invokeinterface get : (I)Ljava/lang/Object;
    //   373: checkcast android/util/Pair
    //   376: getfield second : Ljava/lang/Object;
    //   379: checkcast java/lang/Long
    //   382: invokevirtual longValue : ()J
    //   385: invokespecial notifyMsgListChanged : (IJ)V
    //   388: aload_0
    //   389: aload_1
    //   390: iconst_0
    //   391: invokeinterface get : (I)Ljava/lang/Object;
    //   396: checkcast android/util/Pair
    //   399: getfield first : Ljava/lang/Object;
    //   402: checkcast java/lang/Short
    //   405: invokevirtual shortValue : ()S
    //   408: aload_1
    //   409: iconst_0
    //   410: invokeinterface get : (I)Ljava/lang/Object;
    //   415: checkcast android/util/Pair
    //   418: getfield second : Ljava/lang/Object;
    //   421: checkcast java/lang/Long
    //   424: invokevirtual longValue : ()J
    //   427: invokespecial notifySessionRemoved : (SJ)V
    //   430: goto -> 437
    //   433: aload_0
    //   434: invokespecial notifySessionListChanged : ()V
    //   437: iload_3
    //   438: ifeq -> 566
    //   441: getstatic com/blued/android/chat/ChatManager.clientType : Lcom/blued/android/chat/ChatManager$ClientType;
    //   444: getstatic com/blued/android/chat/ChatManager$ClientType.CHINA : Lcom/blued/android/chat/ChatManager$ClientType;
    //   447: if_acmpne -> 547
    //   450: invokestatic getInstance : ()Lcom/blued/android/chat/compatible/GRPC;
    //   453: invokevirtual getOrderSender : ()Lcom/blued/android/chat/compatible/IOrderSender;
    //   456: ifnull -> 547
    //   459: aload #8
    //   461: invokeinterface size : ()I
    //   466: iconst_1
    //   467: if_icmpne -> 525
    //   470: invokestatic getInstance : ()Lcom/blued/android/chat/compatible/GRPC;
    //   473: invokevirtual getOrderSender : ()Lcom/blued/android/chat/compatible/IOrderSender;
    //   476: aload #8
    //   478: iconst_0
    //   479: invokeinterface get : (I)Ljava/lang/Object;
    //   484: checkcast android/util/Pair
    //   487: getfield first : Ljava/lang/Object;
    //   490: checkcast java/lang/Short
    //   493: invokevirtual shortValue : ()S
    //   496: aload #8
    //   498: iconst_0
    //   499: invokeinterface get : (I)Ljava/lang/Object;
    //   504: checkcast android/util/Pair
    //   507: getfield second : Ljava/lang/Object;
    //   510: checkcast java/lang/Long
    //   513: invokevirtual longValue : ()J
    //   516: iload_2
    //   517: invokeinterface deleteOneSession : (SJZ)V
    //   522: goto -> 547
    //   525: aload #8
    //   527: invokeinterface size : ()I
    //   532: ifle -> 547
    //   535: invokestatic getInstance : ()Lcom/blued/android/chat/compatible/GRPC;
    //   538: invokevirtual getOrderSender : ()Lcom/blued/android/chat/compatible/IOrderSender;
    //   541: iload_2
    //   542: invokeinterface deleteAllSessions : (Z)V
    //   547: aload_0
    //   548: getfield connector : Lcom/blued/android/chat/core/worker/Connector;
    //   551: new com/blued/android/chat/core/pack/DeleteSessionPackage
    //   554: dup
    //   555: aload_1
    //   556: invokestatic getLocalId : ()J
    //   559: iload_2
    //   560: invokespecial <init> : (Ljava/util/List;JZ)V
    //   563: invokevirtual sendPackage : (Lcom/blued/android/chat/core/pack/BasePackage;)V
    //   566: return
    //   567: astore_1
    //   568: aload #6
    //   570: monitorexit
    //   571: aload_1
    //   572: athrow
    //   573: return
    //   574: iconst_1
    //   575: istore #5
    //   577: goto -> 180
    // Exception table:
    //   from	to	target	type
    //   32	40	567	finally
    //   43	117	567	finally
    //   117	132	318	finally
    //   137	177	567	finally
    //   184	214	567	finally
    //   217	247	567	finally
    //   252	282	567	finally
    //   285	315	567	finally
    //   319	322	318	finally
    //   322	324	567	finally
    //   324	327	567	finally
    //   568	571	567	finally
  }
  
  private List<ChattingModel> getOldMsgListFromDB(short paramShort, long paramLong, ChattingModel paramChattingModel, int paramInt, boolean paramBoolean) {
    long l1;
    long l2;
    long l3 = 0L;
    if (paramChattingModel == null) {
      l1 = 0L;
    } else {
      l1 = paramChattingModel.msgId;
    } 
    if (paramChattingModel == null) {
      l2 = 0L;
    } else {
      l2 = paramChattingModel.msgLocalId;
    } 
    if (paramChattingModel != null)
      l3 = paramChattingModel.msgTimestamp; 
    List<ChattingModel> list = ChatManager.dbOperImpl.getMsgList(ChatManager.userInfo.uid, paramShort, paramLong, l1, l2, l3, paramInt, paramBoolean);
    if (list != null && list.size() > 0) {
      MsgComparator.sortAndDistinct(list);
      if (isAllDeleted(list)) {
        List<ChattingModel> list1;
        ChattingModel chattingModel = list.get(0);
        paramChattingModel = null;
        if (chattingModel.msgId != l1 || chattingModel.msgLocalId != l2 || chattingModel.msgTimestamp != l3)
          list1 = getOldMsgListFromDB(paramShort, paramLong, chattingModel, paramInt, paramBoolean); 
        if (list1 != null) {
          list.addAll(list1);
          return list;
        } 
      } 
    } 
    return list;
  }
  
  private void init() {
    this.connector.registerPackageHandler(3, this);
    this.connector.registerPackageHandler(4, this);
    this.connector.registerPackageHandler(5, this);
    this.connector.registerPackageHandler(6, this);
    this.connector.registerPackageHandler(7, this);
  }
  
  private void initSessionList() {
    if (ChatManager.debug)
      Log.v("Chat_Chat", "initSessionList()"); 
    synchronized (this.sessionList) {
      this.sessionList.clear();
      synchronized (this.snapSessionList) {
        long l1;
        StringBuilder stringBuilder;
        this.snapSessionList.clear();
        ChatManager.dbOperImpl.failedAllSendingMsg(ChatManager.userInfo.uid);
        ChatManager.dbOperImpl.changeAllMsgType((short)52, (short)53);
        List list = ChatManager.dbOperImpl.getSessionList();
        null = ChatManager.dbOperImpl.getSessionSettingList();
        null = null;
        if (null == null)
          null = new HashMap<String, SessionModel>(); 
        long l2 = 0L;
        if (list != null) {
          Iterator<SessionModel> iterator = list.iterator();
          long l = 0L;
          while (true) {
            l1 = l;
            if (iterator.hasNext()) {
              SessionModel sessionModel = iterator.next();
              String str = SessionHeader.getSessionKey(sessionModel.sessionType, sessionModel.sessionId);
              SessionSettingBaseModel sessionSettingBaseModel2 = (SessionSettingBaseModel)null.get(str);
              SessionSettingBaseModel sessionSettingBaseModel1 = sessionSettingBaseModel2;
              if (sessionSettingBaseModel2 == null)
                sessionSettingBaseModel1 = ChatManager.dbOperImpl.createSessionSetting(sessionModel.sessionType, sessionModel.sessionId, null); 
              sessionModel.sessionSettingModel = sessionSettingBaseModel1;
              this.sessionList.put(str, sessionModel);
              if (sessionModel.sessionType == 7)
                l = sessionModel.sessionId; 
              continue;
            } 
            break;
          } 
        } else {
          l1 = 0L;
        } 
        synchronized (this.snapSessionList) {
          this.snapSessionList.putAll(this.sessionList);
          Iterator iterator = this.sessionList.values().iterator();
          long l;
          for (l = l2; iterator.hasNext(); l = Math.max(l, ((SessionModel)iterator.next()).maxMsgId));
          notifySessionListInit();
          this.sessionListInited = true;
          RoomChat roomChat = this.roomChat;
          if (roomChat != null)
            roomChat.setupRoomId(l1); 
          this.initMaxMsgId = l;
          if (ChatManager.debug) {
            stringBuilder = new StringBuilder();
            stringBuilder.append("get the maxMsgId:");
            stringBuilder.append(this.initMaxMsgId);
            Log.v("Chat_Chat", stringBuilder.toString());
          } 
          return;
        } 
      } 
    } 
  }
  
  private void insertMemoryAndNotifyUI(SessionModel paramSessionModel, ChattingModel paramChattingModel) {
    synchronized (this.sessionList) {
      boolean bool = insertMemoryMsgList(paramSessionModel, paramChattingModel);
      if (bool)
        notifyMsgListChanged(paramChattingModel.sessionType, paramChattingModel.sessionId); 
      return;
    } 
  }
  
  private boolean insertMemoryMsgList(SessionModel paramSessionModel, ChattingModel paramChattingModel) {
    if (ChatManager.debug) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("insertMemoryMsgList====msgId: ");
      stringBuilder.append(paramChattingModel.msgId);
      stringBuilder.append("  localId: ");
      stringBuilder.append(paramChattingModel.msgLocalId);
      Log.e("Chat_Chat", stringBuilder.toString());
    } 
    if (paramSessionModel._msgList != null) {
      if (paramSessionModel.isFromSearch && !isShowLastMsg(paramSessionModel))
        return false; 
      MsgComparator.mergeSortedList(paramSessionModel._msgList, paramChattingModel);
      return true;
    } 
    return false;
  }
  
  private void insertMsgDataForLocal(ChattingModel paramChattingModel) {
    String str = SessionHeader.getSessionKey(paramChattingModel.sessionType, paramChattingModel.sessionId);
    synchronized (this.sessionList) {
      SessionModel sessionModel = this.sessionList.get(str);
      if (sessionModel != null) {
        if (paramChattingModel.msgLocalId == 0L)
          paramChattingModel.msgLocalId = ChatHelper.getLocalId(); 
        ChatManager.dbOperImpl.insertChattingData(paramChattingModel);
        if (insertMemoryMsgList(sessionModel, paramChattingModel))
          notifyMsgListChanged(paramChattingModel.sessionType, paramChattingModel.sessionId); 
      } 
      return;
    } 
  }
  
  private void insertMsgDataForSending(ChattingModel paramChattingModel, SessionProfileModel paramSessionProfileModel) {
    // Byte code:
    //   0: getstatic com/blued/android/chat/ChatManager.debug : Z
    //   3: ifeq -> 58
    //   6: new java/lang/StringBuilder
    //   9: dup
    //   10: invokespecial <init> : ()V
    //   13: astore #10
    //   15: aload #10
    //   17: ldc_w 'insertMsgData(), msgData:'
    //   20: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: pop
    //   24: aload #10
    //   26: aload_1
    //   27: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   30: pop
    //   31: aload #10
    //   33: ldc_w ', profileM:'
    //   36: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   39: pop
    //   40: aload #10
    //   42: aload_2
    //   43: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   46: pop
    //   47: ldc 'Chat_Chat'
    //   49: aload #10
    //   51: invokevirtual toString : ()Ljava/lang/String;
    //   54: invokestatic v : (Ljava/lang/String;Ljava/lang/String;)I
    //   57: pop
    //   58: aload_1
    //   59: getfield sessionType : S
    //   62: aload_1
    //   63: getfield sessionId : J
    //   66: invokestatic getSessionKey : (IJ)Ljava/lang/String;
    //   69: astore #12
    //   71: aload_0
    //   72: getfield msgListenerList : Ljava/util/Map;
    //   75: astore #10
    //   77: aload #10
    //   79: monitorenter
    //   80: aload_0
    //   81: getfield msgListenerList : Ljava/util/Map;
    //   84: aload #12
    //   86: invokeinterface get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   91: checkcast java/util/Set
    //   94: astore #11
    //   96: iconst_1
    //   97: istore #7
    //   99: iconst_1
    //   100: istore #5
    //   102: iconst_0
    //   103: istore #6
    //   105: aload #11
    //   107: ifnull -> 607
    //   110: aload #11
    //   112: invokeinterface size : ()I
    //   117: ifle -> 607
    //   120: iconst_1
    //   121: istore_3
    //   122: goto -> 125
    //   125: aload #10
    //   127: monitorexit
    //   128: aload_0
    //   129: getfield sessionList : Ljava/util/Map;
    //   132: astore #11
    //   134: aload #11
    //   136: monitorenter
    //   137: aload_0
    //   138: getfield sessionList : Ljava/util/Map;
    //   141: aload #12
    //   143: invokeinterface get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   148: checkcast com/blued/android/chat/model/SessionModel
    //   151: astore #10
    //   153: aload #10
    //   155: ifnonnull -> 297
    //   158: aload_1
    //   159: getfield msgLocalId : J
    //   162: lconst_0
    //   163: lcmp
    //   164: ifne -> 191
    //   167: aload_1
    //   168: lconst_0
    //   169: putfield msgId : J
    //   172: aload_1
    //   173: lconst_0
    //   174: putfield msgPreviousId : J
    //   177: aload_1
    //   178: invokestatic getLocalId : ()J
    //   181: putfield msgLocalId : J
    //   184: aload_1
    //   185: invokestatic currentTimeMillis : ()J
    //   188: putfield msgTimestamp : J
    //   191: aload_1
    //   192: aload_2
    //   193: iconst_1
    //   194: invokestatic createSessionModel : (Lcom/blued/android/chat/model/ChattingModel;Lcom/blued/android/chat/model/SessionProfileModel;Z)Lcom/blued/android/chat/model/SessionModel;
    //   197: astore #10
    //   199: aload_0
    //   200: getfield sessionList : Ljava/util/Map;
    //   203: aload #12
    //   205: aload #10
    //   207: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   212: pop
    //   213: aload_0
    //   214: getfield snapSessionList : Ljava/util/Map;
    //   217: astore_2
    //   218: aload_2
    //   219: monitorenter
    //   220: aload_0
    //   221: getfield snapSessionList : Ljava/util/Map;
    //   224: aload #12
    //   226: aload #10
    //   228: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   233: pop
    //   234: aload_2
    //   235: monitorexit
    //   236: getstatic com/blued/android/chat/ChatManager.debug : Z
    //   239: ifeq -> 251
    //   242: ldc 'Chat_Chat'
    //   244: ldc_w 'session don't exit, create it'
    //   247: invokestatic v : (Ljava/lang/String;Ljava/lang/String;)I
    //   250: pop
    //   251: aload #10
    //   253: astore_2
    //   254: iload #7
    //   256: istore #4
    //   258: iload #6
    //   260: istore #5
    //   262: iload_3
    //   263: ifeq -> 470
    //   266: aload #10
    //   268: new java/util/ArrayList
    //   271: dup
    //   272: invokespecial <init> : ()V
    //   275: putfield _msgList : Ljava/util/List;
    //   278: aload #10
    //   280: astore_2
    //   281: iload #7
    //   283: istore #4
    //   285: iload #6
    //   287: istore #5
    //   289: goto -> 470
    //   292: astore_1
    //   293: aload_2
    //   294: monitorexit
    //   295: aload_1
    //   296: athrow
    //   297: aload #10
    //   299: getfield _secretMsgListing : Z
    //   302: ifeq -> 628
    //   305: aload #10
    //   307: iconst_0
    //   308: putfield _secretMsgListing : Z
    //   311: aload #10
    //   313: iconst_0
    //   314: putfield secretLookStatus : I
    //   317: aload_0
    //   318: aload #10
    //   320: invokespecial sendReadedFlagForSession : (Lcom/blued/android/chat/model/SessionModel;)Z
    //   323: istore #4
    //   325: aload_0
    //   326: aload #10
    //   328: invokespecial removeSessionUnreadMsg : (Lcom/blued/android/chat/model/SessionModel;)Z
    //   331: ifne -> 617
    //   334: iload #4
    //   336: ifeq -> 612
    //   339: goto -> 617
    //   342: aload_0
    //   343: aload #10
    //   345: invokespecial removeSessionAtMsgId : (Lcom/blued/android/chat/model/SessionModel;)Z
    //   348: ifne -> 622
    //   351: iload_3
    //   352: ifeq -> 628
    //   355: goto -> 622
    //   358: aload #10
    //   360: getfield maxMsgId : J
    //   363: lstore #8
    //   365: aload_1
    //   366: getfield msgLocalId : J
    //   369: lconst_0
    //   370: lcmp
    //   371: ifne -> 413
    //   374: aload_1
    //   375: lload #8
    //   377: putfield msgId : J
    //   380: aload_1
    //   381: lload #8
    //   383: putfield msgPreviousId : J
    //   386: aload_1
    //   387: invokestatic getLocalId : ()J
    //   390: putfield msgLocalId : J
    //   393: aload_1
    //   394: invokestatic currentTimeMillis : ()J
    //   397: putfield msgTimestamp : J
    //   400: aload #10
    //   402: aload_1
    //   403: invokestatic setSessionForLastMsg : (Lcom/blued/android/chat/model/SessionModel;Lcom/blued/android/chat/model/ChattingModel;)V
    //   406: iload #5
    //   408: istore #4
    //   410: goto -> 452
    //   413: aload #10
    //   415: getfield lastMsgLocalId : J
    //   418: aload_1
    //   419: getfield msgLocalId : J
    //   422: lcmp
    //   423: ifne -> 634
    //   426: aload #10
    //   428: getfield lastMsgId : J
    //   431: aload_1
    //   432: getfield msgId : J
    //   435: lcmp
    //   436: ifne -> 634
    //   439: aload #10
    //   441: aload_1
    //   442: invokestatic setSessionForLastMsg : (Lcom/blued/android/chat/model/SessionModel;Lcom/blued/android/chat/model/ChattingModel;)V
    //   445: iload #5
    //   447: istore #4
    //   449: goto -> 452
    //   452: iload #4
    //   454: ifeq -> 637
    //   457: getstatic com/blued/android/chat/ChatManager.dbOperImpl : Lcom/blued/android/chat/db/DBOper;
    //   460: aload #10
    //   462: invokeinterface updateSession : (Lcom/blued/android/chat/model/SessionModel;)V
    //   467: goto -> 637
    //   470: aload_2
    //   471: invokestatic needRequestSessionInfo : (Lcom/blued/android/chat/model/SessionModel;)Z
    //   474: ifeq -> 482
    //   477: aload_0
    //   478: aload_2
    //   479: invokespecial requestSessionData : (Lcom/blued/android/chat/model/SessionModel;)V
    //   482: aload #11
    //   484: monitorexit
    //   485: getstatic com/blued/android/chat/ChatManager.dbOperImpl : Lcom/blued/android/chat/db/DBOper;
    //   488: aload_1
    //   489: invokeinterface insertChattingData : (Lcom/blued/android/chat/model/ChattingModel;)V
    //   494: iload #4
    //   496: ifne -> 504
    //   499: iload #5
    //   501: ifeq -> 509
    //   504: aload_0
    //   505: aload_2
    //   506: invokespecial notifySessionChanged : (Lcom/blued/android/chat/model/SessionModel;)V
    //   509: getstatic com/blued/android/chat/ChatManager.debug : Z
    //   512: ifeq -> 588
    //   515: new java/lang/StringBuilder
    //   518: dup
    //   519: invokespecial <init> : ()V
    //   522: astore #10
    //   524: aload #10
    //   526: ldc_w 'insertMsgDataForSending, sessionCreated:'
    //   529: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   532: pop
    //   533: aload #10
    //   535: iload #4
    //   537: invokevirtual append : (Z)Ljava/lang/StringBuilder;
    //   540: pop
    //   541: aload #10
    //   543: ldc_w ', sessionModified:'
    //   546: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   549: pop
    //   550: aload #10
    //   552: iload #5
    //   554: invokevirtual append : (Z)Ljava/lang/StringBuilder;
    //   557: pop
    //   558: aload #10
    //   560: ldc_w ' msgType: '
    //   563: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   566: pop
    //   567: aload #10
    //   569: aload_1
    //   570: getfield msgType : S
    //   573: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   576: pop
    //   577: ldc 'Chat_Chat'
    //   579: aload #10
    //   581: invokevirtual toString : ()Ljava/lang/String;
    //   584: invokestatic v : (Ljava/lang/String;Ljava/lang/String;)I
    //   587: pop
    //   588: aload_0
    //   589: aload_2
    //   590: aload_1
    //   591: invokespecial insertMemoryAndNotifyUI : (Lcom/blued/android/chat/model/SessionModel;Lcom/blued/android/chat/model/ChattingModel;)V
    //   594: return
    //   595: astore_1
    //   596: aload #11
    //   598: monitorexit
    //   599: aload_1
    //   600: athrow
    //   601: astore_1
    //   602: aload #10
    //   604: monitorexit
    //   605: aload_1
    //   606: athrow
    //   607: iconst_0
    //   608: istore_3
    //   609: goto -> 125
    //   612: iconst_0
    //   613: istore_3
    //   614: goto -> 342
    //   617: iconst_1
    //   618: istore_3
    //   619: goto -> 342
    //   622: iconst_1
    //   623: istore #4
    //   625: goto -> 358
    //   628: iconst_0
    //   629: istore #4
    //   631: goto -> 358
    //   634: goto -> 452
    //   637: iload #4
    //   639: istore #5
    //   641: iconst_0
    //   642: istore #4
    //   644: aload #10
    //   646: astore_2
    //   647: goto -> 470
    // Exception table:
    //   from	to	target	type
    //   80	96	601	finally
    //   110	120	601	finally
    //   125	128	601	finally
    //   137	153	595	finally
    //   158	191	595	finally
    //   191	220	595	finally
    //   220	236	292	finally
    //   236	251	595	finally
    //   266	278	595	finally
    //   293	295	292	finally
    //   295	297	595	finally
    //   297	334	595	finally
    //   342	351	595	finally
    //   358	406	595	finally
    //   413	445	595	finally
    //   457	467	595	finally
    //   470	482	595	finally
    //   482	485	595	finally
    //   596	599	595	finally
    //   602	605	601	finally
  }
  
  private void insertMsgListToMemory(List<ChattingModel> paramList) {
    if (paramList != null) {
      if (paramList.size() == 0)
        return; 
      String str = SessionHeader.getSessionKey(((ChattingModel)paramList.get(0)).sessionType, ((ChattingModel)paramList.get(0)).sessionId);
      synchronized (this.sessionList) {
        SessionModel sessionModel = this.sessionList.get(str);
        if (sessionModel == null || sessionModel._msgList == null)
          return; 
        MsgComparator.mergeSortedList(sessionModel._msgList, paramList);
        notifyMsgListChanged(((ChattingModel)paramList.get(0)).sessionType, ((ChattingModel)paramList.get(0)).sessionId);
        return;
      } 
    } 
  }
  
  private void insertRecvMsgList(List<ChattingModel> paramList) {
    // Byte code:
    //   0: getstatic com/blued/android/chat/ChatManager.debug : Z
    //   3: ifeq -> 58
    //   6: new java/lang/StringBuilder
    //   9: dup
    //   10: invokespecial <init> : ()V
    //   13: astore #17
    //   15: aload #17
    //   17: ldc_w 'insertRecvMsgList(), msgPairList size:'
    //   20: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: pop
    //   24: aload_1
    //   25: ifnonnull -> 33
    //   28: iconst_0
    //   29: istore_3
    //   30: goto -> 40
    //   33: aload_1
    //   34: invokeinterface size : ()I
    //   39: istore_3
    //   40: aload #17
    //   42: iload_3
    //   43: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   46: pop
    //   47: ldc 'Chat_Chat'
    //   49: aload #17
    //   51: invokevirtual toString : ()Ljava/lang/String;
    //   54: invokestatic v : (Ljava/lang/String;Ljava/lang/String;)I
    //   57: pop
    //   58: aload_1
    //   59: ifnull -> 2195
    //   62: aload_1
    //   63: invokeinterface size : ()I
    //   68: ifne -> 72
    //   71: return
    //   72: aload_1
    //   73: aload_1
    //   74: invokeinterface size : ()I
    //   79: iconst_1
    //   80: isub
    //   81: invokeinterface get : (I)Ljava/lang/Object;
    //   86: checkcast com/blued/android/chat/model/ChattingModel
    //   89: astore #19
    //   91: getstatic com/blued/android/chat/ChatManager.debug : Z
    //   94: ifeq -> 217
    //   97: new java/lang/StringBuilder
    //   100: dup
    //   101: invokespecial <init> : ()V
    //   104: astore #17
    //   106: aload #17
    //   108: ldc_w 'lastMsg :'
    //   111: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   114: pop
    //   115: aload #17
    //   117: aload #19
    //   119: getfield fromNickName : Ljava/lang/String;
    //   122: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   125: pop
    //   126: aload #17
    //   128: ldc_w ' content: '
    //   131: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   134: pop
    //   135: aload #17
    //   137: aload #19
    //   139: getfield msgContent : Ljava/lang/String;
    //   142: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   145: pop
    //   146: aload #17
    //   148: ldc_w ' extra:'
    //   151: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   154: pop
    //   155: aload #17
    //   157: aload #19
    //   159: invokevirtual getMsgExtra : ()Ljava/lang/String;
    //   162: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   165: pop
    //   166: aload #17
    //   168: ldc_w ' type: '
    //   171: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   174: pop
    //   175: aload #17
    //   177: aload #19
    //   179: getfield msgType : S
    //   182: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   185: pop
    //   186: aload #17
    //   188: ldc_w ' msgId: '
    //   191: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   194: pop
    //   195: aload #17
    //   197: aload #19
    //   199: getfield msgId : J
    //   202: invokevirtual append : (J)Ljava/lang/StringBuilder;
    //   205: pop
    //   206: ldc 'Chat_Chat'
    //   208: aload #17
    //   210: invokevirtual toString : ()Ljava/lang/String;
    //   213: invokestatic v : (Ljava/lang/String;Ljava/lang/String;)I
    //   216: pop
    //   217: aload #19
    //   219: getfield _pushMsgPackage : Lcom/blued/android/chat/core/pack/PushMsgPackage;
    //   222: getfield pushBasePackage : Lcom/blued/android/chat/core/pack/PushBasePackage;
    //   225: getfield msgHeader : Lcom/blued/android/chat/core/pack/MsgHeader;
    //   228: getfield isOrder : Z
    //   231: istore #10
    //   233: aload #19
    //   235: getfield msgType : S
    //   238: bipush #52
    //   240: if_icmpeq -> 283
    //   243: aload #19
    //   245: getfield msgType : S
    //   248: bipush #53
    //   250: if_icmpne -> 256
    //   253: goto -> 283
    //   256: aload #19
    //   258: getfield msgType : S
    //   261: bipush #54
    //   263: if_icmpne -> 306
    //   266: aload_0
    //   267: getfield videoChat : Lcom/blued/android/chat/core/worker/chat/VideoChat;
    //   270: astore_1
    //   271: aload_1
    //   272: ifnull -> 282
    //   275: aload_1
    //   276: aload #19
    //   278: invokevirtual recvPushCallMessageAndNotifyOrNot : (Lcom/blued/android/chat/model/ChattingModel;)Z
    //   281: pop
    //   282: return
    //   283: aload_0
    //   284: getfield videoChat : Lcom/blued/android/chat/core/worker/chat/VideoChat;
    //   287: astore #17
    //   289: aload #17
    //   291: ifnull -> 306
    //   294: aload #17
    //   296: aload #19
    //   298: invokevirtual recvPushCallMessageAndNotifyOrNot : (Lcom/blued/android/chat/model/ChattingModel;)Z
    //   301: istore #8
    //   303: goto -> 309
    //   306: iconst_1
    //   307: istore #8
    //   309: aload #19
    //   311: getfield sessionType : S
    //   314: aload #19
    //   316: getfield sessionId : J
    //   319: invokestatic getSessionKey : (IJ)Ljava/lang/String;
    //   322: astore #21
    //   324: aload_0
    //   325: getfield msgListenerList : Ljava/util/Map;
    //   328: astore #17
    //   330: aload #17
    //   332: monitorenter
    //   333: aload_0
    //   334: getfield msgListenerList : Ljava/util/Map;
    //   337: aload #21
    //   339: invokeinterface get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   344: checkcast java/util/Set
    //   347: astore #18
    //   349: aload #18
    //   351: ifnull -> 2196
    //   354: aload #18
    //   356: invokeinterface size : ()I
    //   361: ifle -> 2196
    //   364: iconst_1
    //   365: istore_3
    //   366: goto -> 369
    //   369: aload #17
    //   371: monitorexit
    //   372: aload_0
    //   373: getfield sessionList : Ljava/util/Map;
    //   376: astore #20
    //   378: aload #20
    //   380: monitorenter
    //   381: aload_0
    //   382: getfield sessionList : Ljava/util/Map;
    //   385: aload #21
    //   387: invokeinterface get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   392: checkcast com/blued/android/chat/model/SessionModel
    //   395: astore #18
    //   397: aload #18
    //   399: ifnonnull -> 724
    //   402: aload_1
    //   403: invokestatic findNotifyMsg : (Ljava/util/List;)Lcom/blued/android/chat/model/ChattingModel;
    //   406: aconst_null
    //   407: iconst_0
    //   408: invokestatic createSessionModel : (Lcom/blued/android/chat/model/ChattingModel;Lcom/blued/android/chat/model/SessionProfileModel;Z)Lcom/blued/android/chat/model/SessionModel;
    //   411: astore #17
    //   413: aload #17
    //   415: aload #19
    //   417: invokestatic setSessionSourceFrom : (Lcom/blued/android/chat/model/SessionModel;Lcom/blued/android/chat/model/ChattingModel;)V
    //   420: aload #17
    //   422: iconst_1
    //   423: putfield onLineState : I
    //   426: aload_0
    //   427: getfield sessionList : Ljava/util/Map;
    //   430: aload #21
    //   432: aload #17
    //   434: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   439: pop
    //   440: aload_0
    //   441: getfield snapSessionList : Ljava/util/Map;
    //   444: astore #18
    //   446: aload #18
    //   448: monitorenter
    //   449: aload_0
    //   450: getfield snapSessionList : Ljava/util/Map;
    //   453: aload #21
    //   455: aload #17
    //   457: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   462: pop
    //   463: aload #18
    //   465: monitorexit
    //   466: getstatic com/blued/android/chat/ChatManager.debug : Z
    //   469: ifeq -> 481
    //   472: ldc 'Chat_Chat'
    //   474: ldc_w 'session don't exit, create it'
    //   477: invokestatic v : (Ljava/lang/String;Ljava/lang/String;)I
    //   480: pop
    //   481: aload #17
    //   483: invokestatic needRequestSessionInfo : (Lcom/blued/android/chat/model/SessionModel;)Z
    //   486: ifeq -> 495
    //   489: aload_0
    //   490: aload #17
    //   492: invokespecial requestSessionData : (Lcom/blued/android/chat/model/SessionModel;)V
    //   495: iload_3
    //   496: ifeq -> 511
    //   499: aload #17
    //   501: new java/util/ArrayList
    //   504: dup
    //   505: invokespecial <init> : ()V
    //   508: putfield _msgList : Ljava/util/List;
    //   511: aload #17
    //   513: getfield _msgList : Ljava/util/List;
    //   516: ifnonnull -> 2201
    //   519: aload_1
    //   520: invokeinterface iterator : ()Ljava/util/Iterator;
    //   525: astore #18
    //   527: iconst_0
    //   528: istore_3
    //   529: iload_3
    //   530: istore #4
    //   532: aload #18
    //   534: invokeinterface hasNext : ()Z
    //   539: ifeq -> 618
    //   542: aload #18
    //   544: invokeinterface next : ()Ljava/lang/Object;
    //   549: checkcast com/blued/android/chat/model/ChattingModel
    //   552: astore #21
    //   554: aload #21
    //   556: getfield msgStateCode : S
    //   559: iconst_4
    //   560: if_icmpne -> 529
    //   563: aload #21
    //   565: getfield _pushMsgPackage : Lcom/blued/android/chat/core/pack/PushMsgPackage;
    //   568: ifnull -> 529
    //   571: aload #21
    //   573: getfield _pushMsgPackage : Lcom/blued/android/chat/core/pack/PushMsgPackage;
    //   576: getfield pushBasePackage : Lcom/blued/android/chat/core/pack/PushBasePackage;
    //   579: getfield msgHeader : Lcom/blued/android/chat/core/pack/MsgHeader;
    //   582: getfield isReaded : Z
    //   585: ifne -> 529
    //   588: aload #21
    //   590: getfield msgIsDelete : Z
    //   593: ifne -> 529
    //   596: aload #21
    //   598: invokestatic isIgnoreNotifyMsgType : (Lcom/blued/android/chat/model/ChattingModel;)Z
    //   601: ifne -> 529
    //   604: iload_3
    //   605: iconst_1
    //   606: iadd
    //   607: istore_3
    //   608: aload #17
    //   610: aload #21
    //   612: invokestatic setLikeStatus : (Lcom/blued/android/chat/model/SessionModel;Lcom/blued/android/chat/model/ChattingModel;)V
    //   615: goto -> 529
    //   618: aload #17
    //   620: iload #4
    //   622: putfield noReadMsgCount : I
    //   625: getstatic com/blued/android/chat/ChatManager.dbOperImpl : Lcom/blued/android/chat/db/DBOper;
    //   628: aload #17
    //   630: invokeinterface updateSession : (Lcom/blued/android/chat/model/SessionModel;)V
    //   635: aload #19
    //   637: getfield msgStateCode : S
    //   640: iconst_4
    //   641: if_icmpne -> 696
    //   644: aload #19
    //   646: getfield _pushMsgPackage : Lcom/blued/android/chat/core/pack/PushMsgPackage;
    //   649: ifnull -> 696
    //   652: aload #19
    //   654: getfield _pushMsgPackage : Lcom/blued/android/chat/core/pack/PushMsgPackage;
    //   657: getfield pushBasePackage : Lcom/blued/android/chat/core/pack/PushBasePackage;
    //   660: getfield msgHeader : Lcom/blued/android/chat/core/pack/MsgHeader;
    //   663: getfield isReaded : Z
    //   666: ifne -> 696
    //   669: aload #19
    //   671: getfield msgIsDelete : Z
    //   674: ifne -> 696
    //   677: aload_1
    //   678: invokestatic findNotifyMsg : (Ljava/util/List;)Lcom/blued/android/chat/model/ChattingModel;
    //   681: invokestatic isIgnoreNotifyMsgType : (Lcom/blued/android/chat/model/ChattingModel;)Z
    //   684: istore #9
    //   686: iload #9
    //   688: ifne -> 696
    //   691: iconst_1
    //   692: istore_3
    //   693: goto -> 698
    //   696: iconst_0
    //   697: istore_3
    //   698: iload_3
    //   699: istore #5
    //   701: lconst_0
    //   702: lstore #11
    //   704: iconst_0
    //   705: istore_3
    //   706: iconst_1
    //   707: istore #4
    //   709: iconst_0
    //   710: istore #6
    //   712: iconst_1
    //   713: istore #9
    //   715: goto -> 1660
    //   718: astore_1
    //   719: aload #18
    //   721: monitorexit
    //   722: aload_1
    //   723: athrow
    //   724: getstatic com/blued/android/chat/ChatManager.debug : Z
    //   727: ifeq -> 830
    //   730: new java/lang/StringBuilder
    //   733: dup
    //   734: invokespecial <init> : ()V
    //   737: astore #17
    //   739: aload #17
    //   741: ldc_w 'session exit, session._msgList:'
    //   744: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   747: pop
    //   748: aload #17
    //   750: aload #18
    //   752: getfield _msgList : Ljava/util/List;
    //   755: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   758: pop
    //   759: aload #17
    //   761: ldc_w ', session._secretMsgListing:'
    //   764: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   767: pop
    //   768: aload #17
    //   770: aload #18
    //   772: getfield _secretMsgListing : Z
    //   775: invokevirtual append : (Z)Ljava/lang/StringBuilder;
    //   778: pop
    //   779: aload #17
    //   781: ldc_w ', session.maxHasReadMsgID:'
    //   784: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   787: pop
    //   788: aload #17
    //   790: aload #18
    //   792: getfield maxHasReadMsgID : J
    //   795: invokevirtual append : (J)Ljava/lang/StringBuilder;
    //   798: pop
    //   799: aload #17
    //   801: ldc_w ', session.maxMsgId:'
    //   804: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   807: pop
    //   808: aload #17
    //   810: aload #18
    //   812: getfield maxMsgId : J
    //   815: invokevirtual append : (J)Ljava/lang/StringBuilder;
    //   818: pop
    //   819: ldc 'Chat_Chat'
    //   821: aload #17
    //   823: invokevirtual toString : ()Ljava/lang/String;
    //   826: invokestatic v : (Ljava/lang/String;Ljava/lang/String;)I
    //   829: pop
    //   830: aload_0
    //   831: aload #18
    //   833: invokespecial isShowLastMsg : (Lcom/blued/android/chat/model/SessionModel;)Z
    //   836: istore #9
    //   838: aload #18
    //   840: iconst_1
    //   841: putfield onLineState : I
    //   844: aload #18
    //   846: aload #19
    //   848: invokestatic setSessionSourceFrom : (Lcom/blued/android/chat/model/SessionModel;Lcom/blued/android/chat/model/ChattingModel;)V
    //   851: aload #19
    //   853: getfield fromId : J
    //   856: getstatic com/blued/android/chat/ChatManager.userInfo : Lcom/blued/android/chat/data/UserInfoForChat;
    //   859: getfield uid : J
    //   862: lcmp
    //   863: ifeq -> 2217
    //   866: aload #18
    //   868: getfield vipAnnual : I
    //   871: aload #19
    //   873: getfield fromVipAnnual : I
    //   876: if_icmpne -> 2212
    //   879: aload #18
    //   881: getfield vipGrade : I
    //   884: aload #19
    //   886: getfield fromVipGrade : I
    //   889: if_icmpne -> 2212
    //   892: aload #18
    //   894: getfield hideVipLook : I
    //   897: aload #19
    //   899: getfield fromHideVipLook : I
    //   902: if_icmpne -> 2212
    //   905: aload #18
    //   907: getfield vipExpLvl : I
    //   910: aload #19
    //   912: getfield fromVipExpLvl : I
    //   915: if_icmpne -> 2212
    //   918: aload #18
    //   920: getfield ovipGrade : I
    //   923: aload #19
    //   925: getfield ofromVipGrade : I
    //   928: if_icmpne -> 2212
    //   931: aload #18
    //   933: getfield ohideVipLook : I
    //   936: aload #19
    //   938: getfield ofromHideVipLook : I
    //   941: if_icmpne -> 2212
    //   944: aload #18
    //   946: getfield oFaceStatus : I
    //   949: aload #19
    //   951: getfield oFromFaceStatus : I
    //   954: if_icmpeq -> 2207
    //   957: goto -> 2212
    //   960: aload #18
    //   962: aload #19
    //   964: getfield fromVipAnnual : I
    //   967: putfield vipAnnual : I
    //   970: aload #18
    //   972: aload #19
    //   974: getfield fromVipGrade : I
    //   977: putfield vipGrade : I
    //   980: aload #18
    //   982: aload #19
    //   984: getfield fromVipExpLvl : I
    //   987: putfield vipExpLvl : I
    //   990: aload #18
    //   992: aload #19
    //   994: getfield fromHideVipLook : I
    //   997: putfield hideVipLook : I
    //   1000: aload #18
    //   1002: aload #19
    //   1004: getfield ofromVipGrade : I
    //   1007: putfield ovipGrade : I
    //   1010: aload #18
    //   1012: aload #19
    //   1014: getfield ofromHideVipLook : I
    //   1017: putfield ohideVipLook : I
    //   1020: aload #18
    //   1022: aload #19
    //   1024: getfield oFromFaceStatus : I
    //   1027: putfield oFaceStatus : I
    //   1030: iload_3
    //   1031: istore #4
    //   1033: goto -> 1036
    //   1036: aload #18
    //   1038: getfield maxMsgId : J
    //   1041: lstore #11
    //   1043: aload #19
    //   1045: getfield msgId : J
    //   1048: lload #11
    //   1050: lcmp
    //   1051: ifle -> 2223
    //   1054: aload #19
    //   1056: getfield msgStateCode : S
    //   1059: iconst_4
    //   1060: if_icmpne -> 2223
    //   1063: aload #19
    //   1065: getfield _pushMsgPackage : Lcom/blued/android/chat/core/pack/PushMsgPackage;
    //   1068: ifnull -> 2223
    //   1071: aload #19
    //   1073: getfield _pushMsgPackage : Lcom/blued/android/chat/core/pack/PushMsgPackage;
    //   1076: getfield pushBasePackage : Lcom/blued/android/chat/core/pack/PushBasePackage;
    //   1079: getfield msgHeader : Lcom/blued/android/chat/core/pack/MsgHeader;
    //   1082: getfield isReaded : Z
    //   1085: ifne -> 2223
    //   1088: aload #19
    //   1090: getfield msgIsDelete : Z
    //   1093: ifne -> 2223
    //   1096: aload_1
    //   1097: invokestatic findNotifyMsg : (Ljava/util/List;)Lcom/blued/android/chat/model/ChattingModel;
    //   1100: invokestatic isIgnoreNotifyMsgType : (Lcom/blued/android/chat/model/ChattingModel;)Z
    //   1103: ifne -> 2223
    //   1106: iconst_1
    //   1107: istore_3
    //   1108: goto -> 1111
    //   1111: aload #18
    //   1113: getfield _unreadedMsgIds : Ljava/util/Set;
    //   1116: ifnonnull -> 1172
    //   1119: aload #18
    //   1121: new java/util/HashSet
    //   1124: dup
    //   1125: invokespecial <init> : ()V
    //   1128: putfield _unreadedMsgIds : Ljava/util/Set;
    //   1131: getstatic com/blued/android/chat/ChatManager.dbOperImpl : Lcom/blued/android/chat/db/DBOper;
    //   1134: aload #18
    //   1136: getfield sessionType : S
    //   1139: aload #18
    //   1141: getfield sessionId : J
    //   1144: ldc2_w 100
    //   1147: invokeinterface getSessionUnreadedIds : (IJJ)Ljava/util/Set;
    //   1152: astore #17
    //   1154: aload #17
    //   1156: ifnull -> 1172
    //   1159: aload #18
    //   1161: getfield _unreadedMsgIds : Ljava/util/Set;
    //   1164: aload #17
    //   1166: invokeinterface addAll : (Ljava/util/Collection;)Z
    //   1171: pop
    //   1172: aload #18
    //   1174: getfield _msgList : Ljava/util/List;
    //   1177: ifnull -> 1230
    //   1180: aload #18
    //   1182: getfield _secretMsgListing : Z
    //   1185: ifeq -> 1191
    //   1188: goto -> 1230
    //   1191: aload #19
    //   1193: getfield msgId : J
    //   1196: aload #18
    //   1198: getfield maxHasReadMsgID : J
    //   1201: lcmp
    //   1202: ifle -> 2228
    //   1205: aload #18
    //   1207: aload #19
    //   1209: getfield msgId : J
    //   1212: putfield maxHasReadMsgID : J
    //   1215: iconst_1
    //   1216: istore #4
    //   1218: iconst_1
    //   1219: istore #6
    //   1221: iload_3
    //   1222: istore #5
    //   1224: iload #6
    //   1226: istore_3
    //   1227: goto -> 1618
    //   1230: aload_1
    //   1231: invokeinterface iterator : ()Ljava/util/Iterator;
    //   1236: astore #17
    //   1238: aload #17
    //   1240: invokeinterface hasNext : ()Z
    //   1245: ifeq -> 2253
    //   1248: aload #17
    //   1250: invokeinterface next : ()Ljava/lang/Object;
    //   1255: checkcast com/blued/android/chat/model/ChattingModel
    //   1258: astore #21
    //   1260: aload #21
    //   1262: getfield msgAt : Ljava/lang/String;
    //   1265: invokestatic isAtSelf : (Ljava/lang/String;)Z
    //   1268: ifeq -> 2234
    //   1271: aload #18
    //   1273: getfield atMessageId : J
    //   1276: aload #21
    //   1278: getfield msgId : J
    //   1281: lcmp
    //   1282: ifge -> 1301
    //   1285: aload #18
    //   1287: aload #21
    //   1289: getfield msgId : J
    //   1292: putfield atMessageId : J
    //   1295: iconst_1
    //   1296: istore #4
    //   1298: goto -> 1301
    //   1301: iload #4
    //   1303: istore #5
    //   1305: aload #21
    //   1307: getfield msgId : J
    //   1310: aload #18
    //   1312: getfield maxHasReadMsgID : J
    //   1315: lcmp
    //   1316: ifle -> 2240
    //   1319: aload #21
    //   1321: getfield msgStateCode : S
    //   1324: iconst_4
    //   1325: if_icmpne -> 1564
    //   1328: aload #21
    //   1330: getfield _pushMsgPackage : Lcom/blued/android/chat/core/pack/PushMsgPackage;
    //   1333: ifnull -> 1381
    //   1336: aload #21
    //   1338: getfield _pushMsgPackage : Lcom/blued/android/chat/core/pack/PushMsgPackage;
    //   1341: getfield pushBasePackage : Lcom/blued/android/chat/core/pack/PushBasePackage;
    //   1344: getfield msgHeader : Lcom/blued/android/chat/core/pack/MsgHeader;
    //   1347: getfield isReaded : Z
    //   1350: ifeq -> 1381
    //   1353: getstatic com/blued/android/chat/ChatManager.debug : Z
    //   1356: ifeq -> 1368
    //   1359: ldc 'Chat_Chat'
    //   1361: ldc_w 'it is readed push'
    //   1364: invokestatic v : (Ljava/lang/String;Ljava/lang/String;)I
    //   1367: pop
    //   1368: aload #18
    //   1370: aload #21
    //   1372: getfield msgId : J
    //   1375: putfield maxHasReadMsgID : J
    //   1378: goto -> 2237
    //   1381: iload #4
    //   1383: istore #5
    //   1385: aload #18
    //   1387: getfield _unreadedMsgIds : Ljava/util/Set;
    //   1390: aload #21
    //   1392: getfield msgId : J
    //   1395: invokestatic valueOf : (J)Ljava/lang/Long;
    //   1398: invokeinterface contains : (Ljava/lang/Object;)Z
    //   1403: ifne -> 2240
    //   1406: iload #4
    //   1408: istore #5
    //   1410: aload #21
    //   1412: getfield msgIsDelete : Z
    //   1415: ifne -> 2240
    //   1418: getstatic com/blued/android/chat/ChatManager.debug : Z
    //   1421: ifeq -> 1464
    //   1424: new java/lang/StringBuilder
    //   1427: dup
    //   1428: invokespecial <init> : ()V
    //   1431: astore #22
    //   1433: aload #22
    //   1435: ldc_w 'it is new msg, noReadMsgCount++:'
    //   1438: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1441: pop
    //   1442: aload #22
    //   1444: aload #18
    //   1446: getfield noReadMsgCount : I
    //   1449: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   1452: pop
    //   1453: ldc 'Chat_Chat'
    //   1455: aload #22
    //   1457: invokevirtual toString : ()Ljava/lang/String;
    //   1460: invokestatic v : (Ljava/lang/String;Ljava/lang/String;)I
    //   1463: pop
    //   1464: aload #18
    //   1466: getfield _secretMsgListing : Z
    //   1469: ifeq -> 1502
    //   1472: aload #18
    //   1474: iconst_0
    //   1475: putfield noReadMsgCount : I
    //   1478: aload #18
    //   1480: invokestatic clearSessionLikeNum : (Lcom/blued/android/chat/model/SessionModel;)V
    //   1483: aload #18
    //   1485: getfield _unreadedMsgIds : Ljava/util/Set;
    //   1488: invokeinterface clear : ()V
    //   1493: aload #18
    //   1495: iconst_1
    //   1496: putfield secretLookStatus : I
    //   1499: goto -> 2237
    //   1502: aload #21
    //   1504: invokestatic isIgnoreNotifyMsgType : (Lcom/blued/android/chat/model/ChattingModel;)Z
    //   1507: ifne -> 1550
    //   1510: aload #18
    //   1512: aload #18
    //   1514: getfield noReadMsgCount : I
    //   1517: iconst_1
    //   1518: iadd
    //   1519: putfield noReadMsgCount : I
    //   1522: aload #18
    //   1524: getfield _unreadedMsgIds : Ljava/util/Set;
    //   1527: aload #21
    //   1529: getfield msgId : J
    //   1532: invokestatic valueOf : (J)Ljava/lang/Long;
    //   1535: invokeinterface add : (Ljava/lang/Object;)Z
    //   1540: pop
    //   1541: aload #18
    //   1543: iconst_0
    //   1544: putfield secretLookStatus : I
    //   1547: iconst_1
    //   1548: istore #4
    //   1550: aload #18
    //   1552: aload #21
    //   1554: invokestatic setLikeStatus : (Lcom/blued/android/chat/model/SessionModel;Lcom/blued/android/chat/model/ChattingModel;)V
    //   1557: iload #4
    //   1559: istore #5
    //   1561: goto -> 2240
    //   1564: iload #4
    //   1566: istore #5
    //   1568: aload #21
    //   1570: invokevirtual isFromSelf : ()Z
    //   1573: ifeq -> 2240
    //   1576: iload #4
    //   1578: istore #5
    //   1580: aload #21
    //   1582: getfield msgId : J
    //   1585: aload #18
    //   1587: getfield maxMsgId : J
    //   1590: lcmp
    //   1591: iflt -> 2240
    //   1594: aload #18
    //   1596: iconst_0
    //   1597: putfield noReadMsgCount : I
    //   1600: aload #18
    //   1602: invokestatic clearSessionLikeNum : (Lcom/blued/android/chat/model/SessionModel;)V
    //   1605: aload #18
    //   1607: getfield _unreadedMsgIds : Ljava/util/Set;
    //   1610: invokeinterface clear : ()V
    //   1615: goto -> 2247
    //   1618: aload #19
    //   1620: getfield msgId : J
    //   1623: aload #18
    //   1625: getfield maxMsgId : J
    //   1628: lcmp
    //   1629: iflt -> 1642
    //   1632: aload #18
    //   1634: aload #19
    //   1636: invokestatic setSessionForLastMsg : (Lcom/blued/android/chat/model/SessionModel;Lcom/blued/android/chat/model/ChattingModel;)V
    //   1639: iconst_1
    //   1640: istore #4
    //   1642: iload #4
    //   1644: ifeq -> 2261
    //   1647: getstatic com/blued/android/chat/ChatManager.dbOperImpl : Lcom/blued/android/chat/db/DBOper;
    //   1650: aload #18
    //   1652: invokeinterface updateSession : (Lcom/blued/android/chat/model/SessionModel;)V
    //   1657: goto -> 2261
    //   1660: aload #17
    //   1662: invokestatic needRequestSessionInfo : (Lcom/blued/android/chat/model/SessionModel;)Z
    //   1665: ifeq -> 1674
    //   1668: aload_0
    //   1669: aload #17
    //   1671: invokespecial requestSessionData : (Lcom/blued/android/chat/model/SessionModel;)V
    //   1674: aload #20
    //   1676: monitorexit
    //   1677: iload_3
    //   1678: ifeq -> 1716
    //   1681: iload #10
    //   1683: ifeq -> 1716
    //   1686: aload_0
    //   1687: getfield readedFlagSender : Lcom/blued/android/chat/core/worker/chat/ReadedFlagSender;
    //   1690: aload #19
    //   1692: getfield sessionType : S
    //   1695: aload #19
    //   1697: getfield sessionId : J
    //   1700: aload #19
    //   1702: getfield msgId : J
    //   1705: getstatic com/blued/android/chat/compatible/IReceiptSender$ReceiptType.RECEIVED : Lcom/blued/android/chat/compatible/IReceiptSender$ReceiptType;
    //   1708: iload #10
    //   1710: invokevirtual sendReceiptImmediateForOrder : (SJJLcom/blued/android/chat/compatible/IReceiptSender$ReceiptType;Z)V
    //   1713: goto -> 1862
    //   1716: iload #10
    //   1718: ifne -> 1862
    //   1721: iload_3
    //   1722: ifne -> 1739
    //   1725: aload #19
    //   1727: getfield msgId : J
    //   1730: lload #11
    //   1732: lcmp
    //   1733: ifge -> 1739
    //   1736: goto -> 1862
    //   1739: aload_1
    //   1740: invokeinterface size : ()I
    //   1745: iconst_1
    //   1746: if_icmple -> 1807
    //   1749: aload_0
    //   1750: getfield readedFlagSender : Lcom/blued/android/chat/core/worker/chat/ReadedFlagSender;
    //   1753: astore #20
    //   1755: aload #19
    //   1757: getfield sessionType : S
    //   1760: istore_2
    //   1761: aload #19
    //   1763: getfield sessionId : J
    //   1766: lstore #13
    //   1768: aload #19
    //   1770: getfield msgId : J
    //   1773: lstore #15
    //   1775: iload_3
    //   1776: ifeq -> 1787
    //   1779: getstatic com/blued/android/chat/compatible/IReceiptSender$ReceiptType.READED : Lcom/blued/android/chat/compatible/IReceiptSender$ReceiptType;
    //   1782: astore #18
    //   1784: goto -> 1792
    //   1787: getstatic com/blued/android/chat/compatible/IReceiptSender$ReceiptType.RECEIVED : Lcom/blued/android/chat/compatible/IReceiptSender$ReceiptType;
    //   1790: astore #18
    //   1792: aload #20
    //   1794: iload_2
    //   1795: lload #13
    //   1797: lload #15
    //   1799: aload #18
    //   1801: invokevirtual sendReceiptImmediate : (SJJLcom/blued/android/chat/compatible/IReceiptSender$ReceiptType;)V
    //   1804: goto -> 1862
    //   1807: aload_0
    //   1808: getfield readedFlagSender : Lcom/blued/android/chat/core/worker/chat/ReadedFlagSender;
    //   1811: astore #20
    //   1813: aload #19
    //   1815: getfield sessionType : S
    //   1818: istore_2
    //   1819: aload #19
    //   1821: getfield sessionId : J
    //   1824: lstore #13
    //   1826: aload #19
    //   1828: getfield msgId : J
    //   1831: lstore #15
    //   1833: iload_3
    //   1834: ifeq -> 1845
    //   1837: getstatic com/blued/android/chat/compatible/IReceiptSender$ReceiptType.READED : Lcom/blued/android/chat/compatible/IReceiptSender$ReceiptType;
    //   1840: astore #18
    //   1842: goto -> 1850
    //   1845: getstatic com/blued/android/chat/compatible/IReceiptSender$ReceiptType.RECEIVED : Lcom/blued/android/chat/compatible/IReceiptSender$ReceiptType;
    //   1848: astore #18
    //   1850: aload #20
    //   1852: iload_2
    //   1853: lload #13
    //   1855: lload #15
    //   1857: aload #18
    //   1859: invokevirtual sendReceipt : (SJJLcom/blued/android/chat/compatible/IReceiptSender$ReceiptType;)V
    //   1862: iconst_0
    //   1863: istore #7
    //   1865: new java/util/ArrayList
    //   1868: dup
    //   1869: invokespecial <init> : ()V
    //   1872: astore #18
    //   1874: aload #18
    //   1876: aload_1
    //   1877: invokeinterface addAll : (Ljava/util/Collection;)Z
    //   1882: pop
    //   1883: getstatic com/blued/android/chat/ChatManager.dbOperImpl : Lcom/blued/android/chat/db/DBOper;
    //   1886: aload #18
    //   1888: invokeinterface insertMsgList : (Ljava/util/List;)V
    //   1893: aload_1
    //   1894: invokeinterface size : ()I
    //   1899: iconst_1
    //   1900: if_icmpne -> 2046
    //   1903: aload #19
    //   1905: getfield msgPreviousId : J
    //   1908: lload #11
    //   1910: lcmp
    //   1911: ifle -> 2046
    //   1914: lload #11
    //   1916: lconst_0
    //   1917: lcmp
    //   1918: ifle -> 2046
    //   1921: aload #19
    //   1923: getfield _pushMsgPackage : Lcom/blued/android/chat/core/pack/PushMsgPackage;
    //   1926: ifnull -> 1957
    //   1929: aload #19
    //   1931: getfield _pushMsgPackage : Lcom/blued/android/chat/core/pack/PushMsgPackage;
    //   1934: getfield pushBasePackage : Lcom/blued/android/chat/core/pack/PushBasePackage;
    //   1937: ifnull -> 1957
    //   1940: aload #19
    //   1942: getfield _pushMsgPackage : Lcom/blued/android/chat/core/pack/PushMsgPackage;
    //   1945: getfield pushBasePackage : Lcom/blued/android/chat/core/pack/PushBasePackage;
    //   1948: getfield sync : Z
    //   1951: ifeq -> 1957
    //   1954: goto -> 2046
    //   1957: getstatic com/blued/android/chat/ChatManager.debug : Z
    //   1960: ifeq -> 2020
    //   1963: new java/lang/StringBuilder
    //   1966: dup
    //   1967: invokespecial <init> : ()V
    //   1970: astore #20
    //   1972: aload #20
    //   1974: ldc_w 'the new msg don't match the last msg, so run task to fill interval, startId:'
    //   1977: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1980: pop
    //   1981: aload #20
    //   1983: lload #11
    //   1985: invokevirtual append : (J)Ljava/lang/StringBuilder;
    //   1988: pop
    //   1989: aload #20
    //   1991: ldc_w ', endId:'
    //   1994: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1997: pop
    //   1998: aload #20
    //   2000: aload #19
    //   2002: getfield msgId : J
    //   2005: invokevirtual append : (J)Ljava/lang/StringBuilder;
    //   2008: pop
    //   2009: ldc 'Chat_Chat'
    //   2011: aload #20
    //   2013: invokevirtual toString : ()Ljava/lang/String;
    //   2016: invokestatic v : (Ljava/lang/String;Ljava/lang/String;)I
    //   2019: pop
    //   2020: aload_0
    //   2021: aload #19
    //   2023: getfield sessionType : S
    //   2026: aload #19
    //   2028: getfield sessionId : J
    //   2031: lload #11
    //   2033: aload #19
    //   2035: getfield msgId : J
    //   2038: aconst_null
    //   2039: aconst_null
    //   2040: invokespecial sendSyncMsgPackage : (SJJJLcom/blued/android/chat/listener/LoadListener;Ljava/util/List;)V
    //   2043: goto -> 2046
    //   2046: iload #4
    //   2048: ifne -> 2062
    //   2051: iload #6
    //   2053: ifeq -> 2059
    //   2056: goto -> 2062
    //   2059: goto -> 2068
    //   2062: aload_0
    //   2063: aload #17
    //   2065: invokespecial notifySessionChanged : (Lcom/blued/android/chat/model/SessionModel;)V
    //   2068: aload_0
    //   2069: getfield sessionList : Ljava/util/Map;
    //   2072: astore #20
    //   2074: aload #20
    //   2076: monitorenter
    //   2077: iload #7
    //   2079: istore_3
    //   2080: aload #17
    //   2082: getfield _msgList : Ljava/util/List;
    //   2085: ifnull -> 2119
    //   2088: aload #17
    //   2090: getfield isFromSearch : Z
    //   2093: ifeq -> 2107
    //   2096: iload #9
    //   2098: ifne -> 2107
    //   2101: iload #7
    //   2103: istore_3
    //   2104: goto -> 2119
    //   2107: aload #17
    //   2109: getfield _msgList : Ljava/util/List;
    //   2112: aload #18
    //   2114: invokestatic mergeSortedList : (Ljava/util/List;Ljava/util/List;)V
    //   2117: iconst_1
    //   2118: istore_3
    //   2119: aload #20
    //   2121: monitorexit
    //   2122: iload_3
    //   2123: ifeq -> 2140
    //   2126: aload_0
    //   2127: aload #19
    //   2129: getfield sessionType : S
    //   2132: aload #19
    //   2134: getfield sessionId : J
    //   2137: invokespecial notifyMsgListChanged : (IJ)V
    //   2140: iload #5
    //   2142: ifeq -> 2176
    //   2145: iload #8
    //   2147: ifeq -> 2176
    //   2150: invokestatic getInstance : ()Lcom/blued/android/chat/ChatManager;
    //   2153: invokevirtual getTipsListener : ()Lcom/blued/android/chat/listener/ChatTipsListener;
    //   2156: astore #18
    //   2158: aload #18
    //   2160: ifnull -> 2176
    //   2163: aload #18
    //   2165: aload #17
    //   2167: aload_1
    //   2168: invokestatic findNotifyMsg : (Ljava/util/List;)Lcom/blued/android/chat/model/ChattingModel;
    //   2171: invokeinterface onRecvNewMsg : (Lcom/blued/android/chat/model/SessionModel;Lcom/blued/android/chat/model/ChattingModel;)V
    //   2176: return
    //   2177: astore_1
    //   2178: aload #20
    //   2180: monitorexit
    //   2181: aload_1
    //   2182: athrow
    //   2183: astore_1
    //   2184: aload #20
    //   2186: monitorexit
    //   2187: aload_1
    //   2188: athrow
    //   2189: astore_1
    //   2190: aload #17
    //   2192: monitorexit
    //   2193: aload_1
    //   2194: athrow
    //   2195: return
    //   2196: iconst_0
    //   2197: istore_3
    //   2198: goto -> 369
    //   2201: iconst_0
    //   2202: istore #4
    //   2204: goto -> 618
    //   2207: iconst_0
    //   2208: istore_3
    //   2209: goto -> 960
    //   2212: iconst_1
    //   2213: istore_3
    //   2214: goto -> 960
    //   2217: iconst_0
    //   2218: istore #4
    //   2220: goto -> 1036
    //   2223: iconst_0
    //   2224: istore_3
    //   2225: goto -> 1111
    //   2228: iload_3
    //   2229: istore #5
    //   2231: goto -> 2256
    //   2234: goto -> 1301
    //   2237: goto -> 2247
    //   2240: iload #5
    //   2242: istore #4
    //   2244: goto -> 2250
    //   2247: iconst_1
    //   2248: istore #4
    //   2250: goto -> 1238
    //   2253: iload_3
    //   2254: istore #5
    //   2256: iconst_0
    //   2257: istore_3
    //   2258: goto -> 1618
    //   2261: iconst_0
    //   2262: istore #7
    //   2264: aload #18
    //   2266: astore #17
    //   2268: iload #4
    //   2270: istore #6
    //   2272: iload #7
    //   2274: istore #4
    //   2276: goto -> 1660
    // Exception table:
    //   from	to	target	type
    //   333	349	2189	finally
    //   354	364	2189	finally
    //   369	372	2189	finally
    //   381	397	2183	finally
    //   402	449	2183	finally
    //   449	466	718	finally
    //   466	481	2183	finally
    //   481	495	2183	finally
    //   499	511	2183	finally
    //   511	527	2183	finally
    //   532	604	2183	finally
    //   608	615	2183	finally
    //   618	686	2183	finally
    //   719	722	718	finally
    //   722	724	2183	finally
    //   724	830	2183	finally
    //   830	957	2183	finally
    //   960	1030	2183	finally
    //   1036	1043	2183	finally
    //   1043	1106	2183	finally
    //   1111	1154	2183	finally
    //   1159	1172	2183	finally
    //   1172	1188	2183	finally
    //   1191	1215	2183	finally
    //   1230	1238	2183	finally
    //   1238	1271	2183	finally
    //   1271	1295	2183	finally
    //   1305	1368	2183	finally
    //   1368	1378	2183	finally
    //   1385	1406	2183	finally
    //   1410	1464	2183	finally
    //   1464	1499	2183	finally
    //   1502	1547	2183	finally
    //   1550	1557	2183	finally
    //   1568	1576	2183	finally
    //   1580	1615	2183	finally
    //   1618	1639	2183	finally
    //   1647	1657	2183	finally
    //   1660	1674	2183	finally
    //   1674	1677	2183	finally
    //   2080	2096	2177	finally
    //   2107	2117	2177	finally
    //   2119	2122	2177	finally
    //   2178	2181	2177	finally
    //   2184	2187	2183	finally
    //   2190	2193	2189	finally
  }
  
  private boolean isAllDeleted(List<ChattingModel> paramList) {
    if (paramList == null)
      return false; 
    Iterator<ChattingModel> iterator = paramList.iterator();
    while (iterator.hasNext()) {
      if (!((ChattingModel)iterator.next()).msgIsDelete)
        return false; 
    } 
    return true;
  }
  
  private boolean isGroupManagerRetract(short paramShort, long paramLong1, long paramLong2) {
    return (ChatManager.clientType == ChatManager.ClientType.CHINA && paramShort == 3 && paramLong1 != paramLong2);
  }
  
  private boolean isShowLastMsg(SessionModel paramSessionModel) {
    if (paramSessionModel._msgList != null && !paramSessionModel._msgList.isEmpty() && paramSessionModel.maxMsgId == ((ChattingModel)paramSessionModel._msgList.get(paramSessionModel._msgList.size() - 1)).msgId) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("session.maxMsgId = ");
      stringBuilder.append(paramSessionModel.maxMsgId);
      stringBuilder.append(" ; session.msgId = ");
      stringBuilder.append(((ChattingModel)paramSessionModel._msgList.get(paramSessionModel._msgList.size() - 1)).msgId);
      Log.v("Chat_Chat", stringBuilder.toString());
      return true;
    } 
    return false;
  }
  
  private void loadUpOrDownSessionMsgList(SessionModel paramSessionModel, ChattingModel paramChattingModel, String paramString, short paramShort, long paramLong, int paramInt, boolean paramBoolean, LoadListener paramLoadListener) {
    // Byte code:
    //   0: aload_2
    //   1: ifnonnull -> 10
    //   4: lconst_0
    //   5: lstore #12
    //   7: goto -> 16
    //   10: aload_2
    //   11: getfield msgId : J
    //   14: lstore #12
    //   16: aload_2
    //   17: ifnonnull -> 26
    //   20: lconst_0
    //   21: lstore #14
    //   23: goto -> 32
    //   26: aload_2
    //   27: getfield msgPreviousId : J
    //   30: lstore #14
    //   32: getstatic com/blued/android/chat/ChatManager.debug : Z
    //   35: ifeq -> 75
    //   38: new java/lang/StringBuilder
    //   41: dup
    //   42: invokespecial <init> : ()V
    //   45: astore #16
    //   47: aload #16
    //   49: ldc_w 'fetch msg from db from msgId:'
    //   52: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   55: pop
    //   56: aload #16
    //   58: lload #14
    //   60: invokevirtual append : (J)Ljava/lang/StringBuilder;
    //   63: pop
    //   64: ldc 'Chat_Chat'
    //   66: aload #16
    //   68: invokevirtual toString : ()Ljava/lang/String;
    //   71: invokestatic v : (Ljava/lang/String;Ljava/lang/String;)I
    //   74: pop
    //   75: aload_0
    //   76: iload #4
    //   78: lload #5
    //   80: aload_2
    //   81: iload #7
    //   83: iload #8
    //   85: invokespecial getOldMsgListFromDB : (SJLcom/blued/android/chat/model/ChattingModel;IZ)Ljava/util/List;
    //   88: astore #17
    //   90: getstatic com/blued/android/chat/ChatManager.debug : Z
    //   93: ifeq -> 158
    //   96: new java/lang/StringBuilder
    //   99: dup
    //   100: invokespecial <init> : ()V
    //   103: astore #18
    //   105: aload #18
    //   107: ldc_w 'get msg list from db size:'
    //   110: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   113: pop
    //   114: aload #17
    //   116: ifnonnull -> 127
    //   119: ldc_w 'null'
    //   122: astore #16
    //   124: goto -> 139
    //   127: aload #17
    //   129: invokeinterface size : ()I
    //   134: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   137: astore #16
    //   139: aload #18
    //   141: aload #16
    //   143: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   146: pop
    //   147: ldc 'Chat_Chat'
    //   149: aload #18
    //   151: invokevirtual toString : ()Ljava/lang/String;
    //   154: invokestatic v : (Ljava/lang/String;Ljava/lang/String;)I
    //   157: pop
    //   158: aload #17
    //   160: ifnull -> 619
    //   163: aload #17
    //   165: invokeinterface size : ()I
    //   170: ifgt -> 176
    //   173: goto -> 619
    //   176: aload #17
    //   178: invokestatic sortAndDistinct : (Ljava/util/List;)V
    //   181: aload_2
    //   182: aload #17
    //   184: invokestatic getFillTaskIntervalBySortedMsg : (Lcom/blued/android/chat/model/ChattingModel;Ljava/util/List;)Lcom/blued/android/chat/core/worker/chat/MsgComparator$FillInterval;
    //   187: astore_2
    //   188: aload_2
    //   189: ifnull -> 271
    //   192: getstatic com/blued/android/chat/ChatManager.debug : Z
    //   195: ifeq -> 250
    //   198: new java/lang/StringBuilder
    //   201: dup
    //   202: invokespecial <init> : ()V
    //   205: astore_1
    //   206: aload_1
    //   207: ldc_w 'db get some msg list, but have black block, interval load it, startId:'
    //   210: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   213: pop
    //   214: aload_1
    //   215: aload_2
    //   216: getfield startId : J
    //   219: invokevirtual append : (J)Ljava/lang/StringBuilder;
    //   222: pop
    //   223: aload_1
    //   224: ldc_w ', endId:'
    //   227: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   230: pop
    //   231: aload_1
    //   232: aload_2
    //   233: getfield endId : J
    //   236: invokevirtual append : (J)Ljava/lang/StringBuilder;
    //   239: pop
    //   240: ldc 'Chat_Chat'
    //   242: aload_1
    //   243: invokevirtual toString : ()Ljava/lang/String;
    //   246: invokestatic v : (Ljava/lang/String;Ljava/lang/String;)I
    //   249: pop
    //   250: aload_0
    //   251: iload #4
    //   253: lload #5
    //   255: aload_2
    //   256: getfield startId : J
    //   259: aload_2
    //   260: getfield endId : J
    //   263: aload #9
    //   265: aload #17
    //   267: invokespecial sendSyncMsgPackage : (SJJJLcom/blued/android/chat/listener/LoadListener;Ljava/util/List;)V
    //   270: return
    //   271: aload_0
    //   272: getfield msgListenerList : Ljava/util/Map;
    //   275: astore_2
    //   276: aload_2
    //   277: monitorenter
    //   278: aload_0
    //   279: getfield msgListenerList : Ljava/util/Map;
    //   282: aload_3
    //   283: invokeinterface get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   288: checkcast java/util/Set
    //   291: astore #16
    //   293: iconst_1
    //   294: istore #11
    //   296: aload #16
    //   298: ifnull -> 760
    //   301: aload #16
    //   303: invokeinterface size : ()I
    //   308: ifle -> 760
    //   311: iconst_1
    //   312: istore #7
    //   314: goto -> 317
    //   317: aload_2
    //   318: monitorexit
    //   319: aload_0
    //   320: getfield sessionList : Ljava/util/Map;
    //   323: astore_2
    //   324: aload_2
    //   325: monitorenter
    //   326: aload_1
    //   327: ifnonnull -> 770
    //   330: aload #17
    //   332: aload #17
    //   334: invokeinterface size : ()I
    //   339: iconst_1
    //   340: isub
    //   341: invokeinterface get : (I)Ljava/lang/Object;
    //   346: checkcast com/blued/android/chat/model/ChattingModel
    //   349: aconst_null
    //   350: iconst_0
    //   351: invokestatic createSessionModel : (Lcom/blued/android/chat/model/ChattingModel;Lcom/blued/android/chat/model/SessionProfileModel;Z)Lcom/blued/android/chat/model/SessionModel;
    //   354: astore_1
    //   355: aload_0
    //   356: getfield sessionList : Ljava/util/Map;
    //   359: aload_3
    //   360: aload_1
    //   361: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   366: pop
    //   367: aload_0
    //   368: getfield snapSessionList : Ljava/util/Map;
    //   371: astore #16
    //   373: aload #16
    //   375: monitorenter
    //   376: aload_0
    //   377: getfield snapSessionList : Ljava/util/Map;
    //   380: aload_3
    //   381: aload_1
    //   382: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   387: pop
    //   388: aload #16
    //   390: monitorexit
    //   391: aload_1
    //   392: iconst_0
    //   393: putfield noReadMsgCount : I
    //   396: aload_1
    //   397: invokestatic clearSessionLikeNum : (Lcom/blued/android/chat/model/SessionModel;)V
    //   400: getstatic com/blued/android/chat/ChatManager.dbOperImpl : Lcom/blued/android/chat/db/DBOper;
    //   403: aload_1
    //   404: invokeinterface updateSession : (Lcom/blued/android/chat/model/SessionModel;)V
    //   409: iload #7
    //   411: ifeq -> 425
    //   414: aload_1
    //   415: new java/util/ArrayList
    //   418: dup
    //   419: invokespecial <init> : ()V
    //   422: putfield _msgList : Ljava/util/List;
    //   425: aload_1
    //   426: invokestatic needRequestSessionInfo : (Lcom/blued/android/chat/model/SessionModel;)Z
    //   429: ifeq -> 437
    //   432: aload_0
    //   433: aload_1
    //   434: invokespecial requestSessionData : (Lcom/blued/android/chat/model/SessionModel;)V
    //   437: iconst_1
    //   438: istore #7
    //   440: goto -> 449
    //   443: astore_1
    //   444: aload #16
    //   446: monitorexit
    //   447: aload_1
    //   448: athrow
    //   449: aload_1
    //   450: ifnull -> 776
    //   453: aload_1
    //   454: getfield _msgList : Ljava/util/List;
    //   457: ifnull -> 776
    //   460: getstatic com/blued/android/chat/ChatManager.debug : Z
    //   463: ifeq -> 506
    //   466: new java/lang/StringBuilder
    //   469: dup
    //   470: invokespecial <init> : ()V
    //   473: astore_3
    //   474: aload_3
    //   475: ldc_w 'before merge, msg size:'
    //   478: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   481: pop
    //   482: aload_3
    //   483: aload_1
    //   484: getfield _msgList : Ljava/util/List;
    //   487: invokeinterface size : ()I
    //   492: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   495: pop
    //   496: ldc 'Chat_Chat'
    //   498: aload_3
    //   499: invokevirtual toString : ()Ljava/lang/String;
    //   502: invokestatic v : (Ljava/lang/String;Ljava/lang/String;)I
    //   505: pop
    //   506: aload_1
    //   507: getfield _msgList : Ljava/util/List;
    //   510: aload #17
    //   512: invokestatic mergeSortedList : (Ljava/util/List;Ljava/util/List;)V
    //   515: iload #11
    //   517: istore #10
    //   519: getstatic com/blued/android/chat/ChatManager.debug : Z
    //   522: ifeq -> 572
    //   525: new java/lang/StringBuilder
    //   528: dup
    //   529: invokespecial <init> : ()V
    //   532: astore_3
    //   533: aload_3
    //   534: ldc_w 'after merge, msg size:'
    //   537: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   540: pop
    //   541: aload_3
    //   542: aload_1
    //   543: getfield _msgList : Ljava/util/List;
    //   546: invokeinterface size : ()I
    //   551: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   554: pop
    //   555: ldc 'Chat_Chat'
    //   557: aload_3
    //   558: invokevirtual toString : ()Ljava/lang/String;
    //   561: invokestatic v : (Ljava/lang/String;Ljava/lang/String;)I
    //   564: pop
    //   565: iload #11
    //   567: istore #10
    //   569: goto -> 572
    //   572: aload_2
    //   573: monitorexit
    //   574: iload #10
    //   576: ifeq -> 587
    //   579: aload_0
    //   580: iload #4
    //   582: lload #5
    //   584: invokespecial notifyMsgListChanged : (IJ)V
    //   587: iload #7
    //   589: ifeq -> 597
    //   592: aload_0
    //   593: aload_1
    //   594: invokespecial notifySessionChanged : (Lcom/blued/android/chat/model/SessionModel;)V
    //   597: aload #9
    //   599: ifnull -> 609
    //   602: aload #9
    //   604: invokeinterface onLoadSuccess : ()V
    //   609: return
    //   610: aload_2
    //   611: monitorexit
    //   612: aload_1
    //   613: athrow
    //   614: astore_1
    //   615: aload_2
    //   616: monitorexit
    //   617: aload_1
    //   618: athrow
    //   619: lload #14
    //   621: lconst_0
    //   622: lcmp
    //   623: ifle -> 695
    //   626: getstatic com/blued/android/chat/ChatManager.debug : Z
    //   629: ifeq -> 680
    //   632: new java/lang/StringBuilder
    //   635: dup
    //   636: invokespecial <init> : ()V
    //   639: astore_1
    //   640: aload_1
    //   641: ldc_w 'db get empty list, so lost some message, fore load it, endId:'
    //   644: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   647: pop
    //   648: aload_1
    //   649: lload #12
    //   651: invokevirtual append : (J)Ljava/lang/StringBuilder;
    //   654: pop
    //   655: aload_1
    //   656: ldc_w ', count:'
    //   659: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   662: pop
    //   663: aload_1
    //   664: iload #7
    //   666: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   669: pop
    //   670: ldc 'Chat_Chat'
    //   672: aload_1
    //   673: invokevirtual toString : ()Ljava/lang/String;
    //   676: invokestatic v : (Ljava/lang/String;Ljava/lang/String;)I
    //   679: pop
    //   680: aload_0
    //   681: iload #4
    //   683: lload #5
    //   685: lconst_0
    //   686: lload #12
    //   688: aload #9
    //   690: aconst_null
    //   691: invokespecial sendSyncMsgPackage : (SJJJLcom/blued/android/chat/listener/LoadListener;Ljava/util/List;)V
    //   694: return
    //   695: getstatic com/blued/android/chat/ChatManager.debug : Z
    //   698: ifeq -> 710
    //   701: ldc 'Chat_Chat'
    //   703: ldc_w 'db get empty list, but really have no msg'
    //   706: invokestatic v : (Ljava/lang/String;Ljava/lang/String;)I
    //   709: pop
    //   710: aload #9
    //   712: invokeinterface onLoadSuccess : ()V
    //   717: aload_2
    //   718: ifnonnull -> 759
    //   721: getstatic com/blued/android/chat/ChatManager.debug : Z
    //   724: ifeq -> 736
    //   727: ldc 'Chat_Chat'
    //   729: ldc_w 'current session hasn't msg, so send sync_last to fetch one.'
    //   732: invokestatic v : (Ljava/lang/String;Ljava/lang/String;)I
    //   735: pop
    //   736: new com/blued/android/chat/core/pack/SyncLaterMsgsPackage
    //   739: dup
    //   740: iload #4
    //   742: lload #5
    //   744: invokestatic getLocalId : ()J
    //   747: invokespecial <init> : (SJJ)V
    //   750: astore_1
    //   751: aload_0
    //   752: getfield connector : Lcom/blued/android/chat/core/worker/Connector;
    //   755: aload_1
    //   756: invokevirtual sendPackage : (Lcom/blued/android/chat/core/pack/BasePackage;)V
    //   759: return
    //   760: iconst_0
    //   761: istore #7
    //   763: goto -> 317
    //   766: astore_1
    //   767: goto -> 610
    //   770: iconst_0
    //   771: istore #7
    //   773: goto -> 449
    //   776: iconst_0
    //   777: istore #10
    //   779: goto -> 572
    // Exception table:
    //   from	to	target	type
    //   278	293	614	finally
    //   301	311	614	finally
    //   317	319	614	finally
    //   330	376	766	finally
    //   376	391	443	finally
    //   391	409	766	finally
    //   414	425	766	finally
    //   425	437	766	finally
    //   444	447	443	finally
    //   447	449	766	finally
    //   453	506	766	finally
    //   506	515	766	finally
    //   519	565	766	finally
    //   572	574	766	finally
    //   610	612	766	finally
    //   615	617	614	finally
  }
  
  private void logMsgList(List<ChattingModel> paramList, String paramString) {
    for (ChattingModel chattingModel : paramList) {
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append("updateSend=");
      stringBuilder1.append(paramString);
      String str = stringBuilder1.toString();
      StringBuilder stringBuilder2 = new StringBuilder();
      stringBuilder2.append("msgId: ");
      stringBuilder2.append(chattingModel.msgId);
      stringBuilder2.append("==localId: ");
      stringBuilder2.append(chattingModel.msgLocalId);
      stringBuilder2.append("===content: ");
      stringBuilder2.append(chattingModel.msgContent);
      Log.e(str, stringBuilder2.toString());
    } 
  }
  
  private void mergeLocalMsgListForSync(List<ChattingModel> paramList1, List<ChattingModel> paramList2) {
    if (paramList1 != null) {
      if (paramList1.size() == 0)
        return; 
      if (paramList2 == null || paramList2.size() == 0) {
        insertMsgListToMemory(paramList1);
        return;
      } 
      ChattingModel chattingModel1 = paramList2.get(0);
      ChattingModel chattingModel2 = paramList2.get(paramList2.size() - 1);
      paramList2 = new ArrayList<ChattingModel>();
      long l2 = chattingModel2.msgId;
      long l1 = chattingModel1.msgPreviousId;
      for (int i = paramList1.size() - 1; i >= 0; i--) {
        chattingModel1 = paramList1.get(i);
        if (chattingModel1.msgId > l2) {
          paramList2.add(0, chattingModel1);
        } else if (chattingModel1.msgId == l1) {
          paramList2.add(0, chattingModel1);
          l1 = chattingModel1.msgPreviousId;
        } else {
          break;
        } 
      } 
      insertMsgListToMemory(paramList2);
      return;
    } 
  }
  
  private void notifyAllMsgListClear() {
    synchronized (this.msgListenerList) {
      Collection<Set<MsgContentListener>> collection = this.msgListenerList.values();
      if (collection != null) {
        Iterator<Set<MsgContentListener>> iterator = collection.iterator();
        while (iterator.hasNext()) {
          Iterator<MsgContentListener> iterator1 = ((Set)iterator.next()).iterator();
          while (iterator1.hasNext())
            ((MsgContentListener)iterator1.next()).onMsgDataChanged(null); 
        } 
      } 
      return;
    } 
  }
  
  private void notifyAllSessionRemoved() {
    synchronized (this.singleSessionListenerMap) {
      if (this.singleSessionListenerMap.size() > 0)
        for (Map.Entry<String, Set<SingleSessionListener>> entry : this.singleSessionListenerMap.entrySet()) {
          String str = (String)entry.getKey();
          Set set = (Set)entry.getValue();
          Pair pair = ChatHelper.getSessionTypeAndId(str);
          if (pair != null) {
            Iterator<SingleSessionListener> iterator = set.iterator();
            while (iterator.hasNext())
              ((SingleSessionListener)iterator.next()).onSessionRemoved(((Short)pair.first).shortValue(), ((Long)pair.second).longValue()); 
          } 
        }  
      notifySessionListChanged();
      return;
    } 
  }
  
  private void notifyIMStatusListener() {
    synchronized (this.imStatusListenerList) {
      ConnectState connectState = this.connector.getConnectStatus();
      for (IMStatusListener iMStatusListener : this.imStatusListenerList) {
        int i = null.$SwitchMap$com$blued$android$chat$data$ConnectState[connectState.ordinal()];
        if (i != 1) {
          if (i != 2) {
            if (i != 3)
              continue; 
            if (this.dataSyncing) {
              iMStatusListener.onReceiving();
              continue;
            } 
            iMStatusListener.onConnected();
            continue;
          } 
          iMStatusListener.onConnecting();
          continue;
        } 
        iMStatusListener.onDisconnected();
      } 
      return;
    } 
  }
  
  private void notifyMsgListChanged(int paramInt, long paramLong) {
    null = new ArrayList();
    String str = SessionHeader.getSessionKey(paramInt, paramLong);
    synchronized (this.sessionList) {
      SessionModel sessionModel = this.sessionList.get(str);
      if (sessionModel != null && sessionModel._msgList != null)
        null.addAll(sessionModel._msgList); 
      Iterator iterator = null.iterator();
      while (iterator.hasNext()) {
        if (((ChattingModel)iterator.next()).msgIsDelete)
          iterator.remove(); 
      } 
      if (ChatManager.debug) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("notifyMsgListChanged(), sessionType:");
        stringBuilder.append(paramInt);
        stringBuilder.append(", sessionId:");
        stringBuilder.append(paramLong);
        stringBuilder.append(", msg size:");
        stringBuilder.append(null.size());
        Log.v("Chat_Chat", stringBuilder.toString());
      } 
      synchronized (this.msgListenerList) {
        Set set = this.msgListenerList.get(str);
        if (set == null)
          return; 
        Iterator<MsgContentListener> iterator1 = set.iterator();
        while (iterator1.hasNext())
          ((MsgContentListener)iterator1.next()).onMsgDataChanged(null); 
        return;
      } 
    } 
  }
  
  private void notifySendPackageStateChanged(SendMsgPackage paramSendMsgPackage, int paramInt) {
    notifySendPackageStateChanged(paramSendMsgPackage, paramInt, null);
  }
  
  private void notifySendPackageStateChanged(SendMsgPackage paramSendMsgPackage, int paramInt, SendAckPackage paramSendAckPackage) {
    // Byte code:
    //   0: aload_1
    //   1: getfield sessionType : S
    //   4: aload_1
    //   5: getfield sessionId : J
    //   8: invokestatic getSessionKey : (IJ)Ljava/lang/String;
    //   11: astore #10
    //   13: aload_0
    //   14: getfield sessionList : Ljava/util/Map;
    //   17: astore #9
    //   19: aload #9
    //   21: monitorenter
    //   22: aload_0
    //   23: getfield sessionList : Ljava/util/Map;
    //   26: aload #10
    //   28: invokeinterface get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   33: checkcast com/blued/android/chat/model/SessionModel
    //   36: astore #10
    //   38: iconst_0
    //   39: istore #5
    //   41: iconst_1
    //   42: istore #6
    //   44: aload #10
    //   46: ifnull -> 637
    //   49: aload #10
    //   51: getfield maxMsgId : J
    //   54: lstore #7
    //   56: iload_2
    //   57: ifne -> 613
    //   60: aload_3
    //   61: getfield msgId : J
    //   64: aload #10
    //   66: getfield maxMsgId : J
    //   69: lcmp
    //   70: ifle -> 613
    //   73: aload #10
    //   75: aload_3
    //   76: getfield msgId : J
    //   79: putfield maxMsgId : J
    //   82: getstatic com/blued/android/chat/ChatManager.debug : Z
    //   85: ifeq -> 607
    //   88: new java/lang/StringBuilder
    //   91: dup
    //   92: invokespecial <init> : ()V
    //   95: astore #11
    //   97: aload #11
    //   99: ldc_w 'notifySend==='
    //   102: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   105: pop
    //   106: aload #11
    //   108: aload_3
    //   109: getfield msgId : J
    //   112: invokevirtual append : (J)Ljava/lang/StringBuilder;
    //   115: pop
    //   116: ldc 'Chat_Chat'
    //   118: aload #11
    //   120: invokevirtual toString : ()Ljava/lang/String;
    //   123: invokestatic e : (Ljava/lang/String;Ljava/lang/String;)I
    //   126: pop
    //   127: goto -> 607
    //   130: aload #10
    //   132: getfield lastMsgLocalId : J
    //   135: aload_1
    //   136: getfield localId : J
    //   139: lcmp
    //   140: ifne -> 625
    //   143: iload_2
    //   144: ifne -> 184
    //   147: aload #10
    //   149: aload_3
    //   150: getfield msgId : J
    //   153: putfield lastMsgId : J
    //   156: aload #10
    //   158: aload_3
    //   159: getfield msgTime : J
    //   162: ldc2_w 1000
    //   165: lmul
    //   166: putfield lastMsgTime : J
    //   169: aload #10
    //   171: iconst_2
    //   172: putfield lastMsgStateCode : S
    //   175: aload #10
    //   177: lconst_0
    //   178: putfield lastMsgLocalId : J
    //   181: goto -> 619
    //   184: aload #10
    //   186: bipush #6
    //   188: putfield lastMsgStateCode : S
    //   191: goto -> 619
    //   194: iload #4
    //   196: ifeq -> 209
    //   199: getstatic com/blued/android/chat/ChatManager.dbOperImpl : Lcom/blued/android/chat/db/DBOper;
    //   202: aload #10
    //   204: invokeinterface updateSession : (Lcom/blued/android/chat/model/SessionModel;)V
    //   209: aload #10
    //   211: getfield _msgList : Ljava/util/List;
    //   214: ifnull -> 634
    //   217: iload_2
    //   218: ifne -> 628
    //   221: aload_0
    //   222: aload #10
    //   224: aload_3
    //   225: getfield msgId : J
    //   228: aload_1
    //   229: getfield localId : J
    //   232: invokespecial updateSendingMsgId : (Lcom/blued/android/chat/model/SessionModel;JJ)V
    //   235: goto -> 238
    //   238: aload #10
    //   240: getfield _msgList : Ljava/util/List;
    //   243: invokeinterface iterator : ()Ljava/util/Iterator;
    //   248: astore #11
    //   250: aload #11
    //   252: invokeinterface hasNext : ()Z
    //   257: ifeq -> 631
    //   260: aload #11
    //   262: invokeinterface next : ()Ljava/lang/Object;
    //   267: checkcast com/blued/android/chat/model/ChattingModel
    //   270: astore #12
    //   272: aload #12
    //   274: getfield msgLocalId : J
    //   277: aload_1
    //   278: getfield localId : J
    //   281: lcmp
    //   282: ifne -> 250
    //   285: iload_2
    //   286: ifne -> 358
    //   289: aload #12
    //   291: iconst_2
    //   292: putfield msgStateCode : S
    //   295: aload #12
    //   297: aload_3
    //   298: getfield msgTime : J
    //   301: ldc2_w 1000
    //   304: lmul
    //   305: putfield msgTimestamp : J
    //   308: aload #12
    //   310: aload_3
    //   311: getfield msgId : J
    //   314: putfield msgId : J
    //   317: aload #12
    //   319: aload_3
    //   320: getfield msgPreviousId : J
    //   323: putfield msgPreviousId : J
    //   326: aload #12
    //   328: lconst_0
    //   329: putfield msgLocalId : J
    //   332: aload #10
    //   334: getfield _msgList : Ljava/util/List;
    //   337: aload #12
    //   339: invokeinterface remove : (Ljava/lang/Object;)Z
    //   344: pop
    //   345: aload #10
    //   347: getfield _msgList : Ljava/util/List;
    //   350: aload #12
    //   352: invokestatic mergeSortedList : (Ljava/util/List;Lcom/blued/android/chat/model/ChattingModel;)V
    //   355: goto -> 365
    //   358: aload #12
    //   360: bipush #6
    //   362: putfield msgStateCode : S
    //   365: getstatic com/blued/android/chat/ChatManager.dbOperImpl : Lcom/blued/android/chat/db/DBOper;
    //   368: aload #12
    //   370: invokeinterface updateChattingModel : (Lcom/blued/android/chat/model/ChattingModel;)V
    //   375: iconst_1
    //   376: istore #5
    //   378: goto -> 381
    //   381: aload #9
    //   383: monitorexit
    //   384: iload #5
    //   386: ifne -> 511
    //   389: getstatic com/blued/android/chat/ChatManager.dbOperImpl : Lcom/blued/android/chat/db/DBOper;
    //   392: aload_1
    //   393: getfield sessionType : S
    //   396: aload_1
    //   397: getfield sessionId : J
    //   400: aload_1
    //   401: getfield localId : J
    //   404: invokeinterface getSendingMsgData : (SJJ)Lcom/blued/android/chat/model/ChattingModel;
    //   409: astore #9
    //   411: aload #9
    //   413: ifnull -> 511
    //   416: iload_2
    //   417: ifne -> 491
    //   420: aload #9
    //   422: iconst_2
    //   423: putfield msgStateCode : S
    //   426: aload #9
    //   428: aload_3
    //   429: getfield msgTime : J
    //   432: ldc2_w 1000
    //   435: lmul
    //   436: putfield msgTimestamp : J
    //   439: aload #9
    //   441: aload_3
    //   442: getfield msgId : J
    //   445: putfield msgId : J
    //   448: aload #9
    //   450: aload_3
    //   451: getfield msgPreviousId : J
    //   454: putfield msgPreviousId : J
    //   457: aload #9
    //   459: lconst_0
    //   460: putfield msgLocalId : J
    //   463: getstatic com/blued/android/chat/ChatManager.dbOperImpl : Lcom/blued/android/chat/db/DBOper;
    //   466: aload_3
    //   467: getfield msgId : J
    //   470: aload_1
    //   471: getfield sessionType : S
    //   474: aload_1
    //   475: getfield sessionId : J
    //   478: aload_1
    //   479: getfield localId : J
    //   482: invokeinterface updateSendingMsgId : (JIJJ)I
    //   487: pop
    //   488: goto -> 498
    //   491: aload #9
    //   493: bipush #6
    //   495: putfield msgStateCode : S
    //   498: getstatic com/blued/android/chat/ChatManager.dbOperImpl : Lcom/blued/android/chat/db/DBOper;
    //   501: aload #9
    //   503: invokeinterface updateChattingModel : (Lcom/blued/android/chat/model/ChattingModel;)V
    //   508: goto -> 511
    //   511: iload #4
    //   513: ifeq -> 522
    //   516: aload_0
    //   517: aload #10
    //   519: invokespecial notifySessionChanged : (Lcom/blued/android/chat/model/SessionModel;)V
    //   522: iload #6
    //   524: ifeq -> 539
    //   527: aload_0
    //   528: aload_1
    //   529: getfield sessionType : S
    //   532: aload_1
    //   533: getfield sessionId : J
    //   536: invokespecial notifyMsgListChanged : (IJ)V
    //   539: iload_2
    //   540: ifne -> 574
    //   543: aload_3
    //   544: getfield msgPreviousId : J
    //   547: lload #7
    //   549: lcmp
    //   550: ifle -> 600
    //   553: aload_0
    //   554: aload_1
    //   555: getfield sessionType : S
    //   558: aload_1
    //   559: getfield sessionId : J
    //   562: lload #7
    //   564: aload_3
    //   565: getfield msgId : J
    //   568: aconst_null
    //   569: aconst_null
    //   570: invokespecial sendSyncMsgPackage : (SJJJLcom/blued/android/chat/listener/LoadListener;Ljava/util/List;)V
    //   573: return
    //   574: invokestatic getInstance : ()Lcom/blued/android/chat/ChatManager;
    //   577: invokevirtual getTipsListener : ()Lcom/blued/android/chat/listener/ChatTipsListener;
    //   580: astore_3
    //   581: aload_3
    //   582: ifnull -> 600
    //   585: aload_3
    //   586: aload_1
    //   587: getfield sessionType : S
    //   590: aload_1
    //   591: getfield sessionId : J
    //   594: iload_2
    //   595: invokeinterface onSendMsgFailed : (SJI)V
    //   600: return
    //   601: astore_1
    //   602: aload #9
    //   604: monitorexit
    //   605: aload_1
    //   606: athrow
    //   607: iconst_1
    //   608: istore #4
    //   610: goto -> 130
    //   613: iconst_0
    //   614: istore #4
    //   616: goto -> 130
    //   619: iconst_1
    //   620: istore #4
    //   622: goto -> 194
    //   625: goto -> 194
    //   628: goto -> 238
    //   631: goto -> 634
    //   634: goto -> 643
    //   637: lconst_0
    //   638: lstore #7
    //   640: iconst_0
    //   641: istore #4
    //   643: iconst_0
    //   644: istore #6
    //   646: goto -> 381
    // Exception table:
    //   from	to	target	type
    //   22	38	601	finally
    //   49	56	601	finally
    //   60	127	601	finally
    //   130	143	601	finally
    //   147	181	601	finally
    //   184	191	601	finally
    //   199	209	601	finally
    //   209	217	601	finally
    //   221	235	601	finally
    //   238	250	601	finally
    //   250	285	601	finally
    //   289	355	601	finally
    //   358	365	601	finally
    //   365	375	601	finally
    //   381	384	601	finally
    //   602	605	601	finally
  }
  
  private void notifySessionChanged(SessionModel paramSessionModel) {
    if (paramSessionModel == null)
      return; 
    String str = SessionHeader.getSessionKey(paramSessionModel.sessionType, paramSessionModel.sessionId);
    synchronized (this.singleSessionListenerMap) {
      Set set = this.singleSessionListenerMap.get(str);
      if (set != null && set.size() > 0) {
        Iterator<SingleSessionListener> iterator = set.iterator();
        while (iterator.hasNext())
          ((SingleSessionListener)iterator.next()).onSessionDataChanged(paramSessionModel); 
      } 
      notifySessionListChanged();
      return;
    } 
  }
  
  private void notifySessionChanged(Set<SessionModel> paramSet) {
    if (paramSet == null)
      return; 
    synchronized (this.singleSessionListenerMap) {
      for (SessionModel sessionModel : paramSet) {
        String str = SessionHeader.getSessionKey(sessionModel.sessionType, sessionModel.sessionId);
        Set set = this.singleSessionListenerMap.get(str);
        if (set != null && set.size() > 0) {
          Iterator<SingleSessionListener> iterator = set.iterator();
          while (iterator.hasNext())
            ((SingleSessionListener)iterator.next()).onSessionDataChanged(sessionModel); 
        } 
      } 
      notifySessionListChanged();
      return;
    } 
  }
  
  private void notifySessionChanged(short paramShort, long paramLong, SingleSessionListener paramSingleSessionListener) {
    String str = SessionHeader.getSessionKey(paramShort, paramLong);
    synchronized (this.sessionList) {
      SessionModel sessionModel = this.sessionList.get(str);
      if (sessionModel == null) {
        paramSingleSessionListener.onSessionRemoved(paramShort, paramLong);
        return;
      } 
      paramSingleSessionListener.onSessionDataChanged(sessionModel);
      return;
    } 
  }
  
  private void notifySessionListChanged() {
    null = new ArrayList();
    synchronized (this.sessionList) {
      null.addAll(this.sessionList.values());
      this.lastSessionListChangedTime = System.currentTimeMillis();
      synchronized (this.sessionListenerList) {
        if (ChatManager.debug) {
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append("notifySessionListChanged(), session size:");
          stringBuilder.append(null.size());
          stringBuilder.append(", listener size:");
          stringBuilder.append(this.sessionListenerList.size());
          Log.v("Chat_Chat", stringBuilder.toString());
        } 
        Iterator<SessionListener> iterator = this.sessionListenerList.iterator();
        while (iterator.hasNext())
          ((SessionListener)iterator.next()).onSessionDataChanged(null, this.lastSessionListChangedTime); 
        return;
      } 
    } 
  }
  
  private void notifySessionListChanged(SessionListener paramSessionListener) {
    Map<String, SessionModel> map;
    StringBuilder stringBuilder;
    if (paramSessionListener == null)
      return; 
    ArrayList arrayList = new ArrayList();
    synchronized (this.sessionList) {
      arrayList.addAll(this.sessionList.values());
      if (ChatManager.debug) {
        stringBuilder = new StringBuilder();
        stringBuilder.append("notifySessionListChanged(), session size:");
        stringBuilder.append(arrayList.size());
        Log.v("Chat_Chat", stringBuilder.toString());
      } 
      paramSessionListener.onSessionDataChanged(arrayList, this.lastSessionListChangedTime);
      return;
    } 
  }
  
  private void notifySessionListInit() {
    null = new ArrayList();
    synchronized (this.sessionList) {
      null.addAll(this.sessionList.values());
      this.lastSessionListChangedTime = System.currentTimeMillis();
      if (ChatManager.debug) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("notifySessionListInited(), session size:");
        stringBuilder.append(null.size());
        Log.v("Chat_Chat", stringBuilder.toString());
      } 
      synchronized (this.singleSessionListenerMap) {
        for (SessionModel sessionModel : null) {
          String str = SessionHeader.getSessionKey(sessionModel.sessionType, sessionModel.sessionId);
          Set set = this.singleSessionListenerMap.get(str);
          if (set != null && set.size() > 0) {
            Iterator<SingleSessionListener> iterator = set.iterator();
            while (iterator.hasNext())
              ((SingleSessionListener)iterator.next()).onSessionDataChanged(sessionModel); 
          } 
        } 
        synchronized (this.sessionListenerList) {
          Iterator<SessionListener> iterator = this.sessionListenerList.iterator();
          while (iterator.hasNext())
            ((SessionListener)iterator.next()).onSessionDataChanged(null, this.lastSessionListChangedTime); 
          return;
        } 
      } 
    } 
  }
  
  private void notifySessionRemoved(short paramShort, long paramLong) {
    null = SessionHeader.getSessionKey(paramShort, paramLong);
    synchronized (this.singleSessionListenerMap) {
      Set set = this.singleSessionListenerMap.get(null);
      if (set != null && set.size() > 0) {
        Iterator<SingleSessionListener> iterator = set.iterator();
        while (iterator.hasNext())
          ((SingleSessionListener)iterator.next()).onSessionRemoved(paramShort, paramLong); 
      } 
      notifySessionListChanged();
      return;
    } 
  }
  
  private void receiveOrderMessage(PushMsgPackage paramPushMsgPackage) {
    // Byte code:
    //   0: getstatic com/blued/android/chat/ChatManager.debug : Z
    //   3: ifeq -> 42
    //   6: new java/lang/StringBuilder
    //   9: dup
    //   10: invokespecial <init> : ()V
    //   13: astore #6
    //   15: aload #6
    //   17: ldc_w 'receiveOrderMessage(), orderMessage:'
    //   20: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: pop
    //   24: aload #6
    //   26: aload_1
    //   27: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   30: pop
    //   31: ldc 'Chat_Chat'
    //   33: aload #6
    //   35: invokevirtual toString : ()Ljava/lang/String;
    //   38: invokestatic v : (Ljava/lang/String;Ljava/lang/String;)I
    //   41: pop
    //   42: aload_1
    //   43: getfield msgType : S
    //   46: istore_2
    //   47: iload_2
    //   48: bipush #55
    //   50: if_icmpeq -> 562
    //   53: iload_2
    //   54: bipush #59
    //   56: if_icmpeq -> 464
    //   59: iload_2
    //   60: bipush #91
    //   62: if_icmpeq -> 431
    //   65: iload_2
    //   66: sipush #176
    //   69: if_icmpeq -> 398
    //   72: iload_2
    //   73: bipush #71
    //   75: if_icmpeq -> 365
    //   78: iload_2
    //   79: bipush #72
    //   81: if_icmpeq -> 332
    //   84: iload_2
    //   85: sipush #136
    //   88: if_icmpeq -> 299
    //   91: iload_2
    //   92: sipush #137
    //   95: if_icmpeq -> 266
    //   98: iload_2
    //   99: tableswitch default -> 124, 95 -> 233, 96 -> 200, 97 -> 167
    //   124: getstatic com/blued/android/chat/ChatManager.debug : Z
    //   127: ifeq -> 930
    //   130: new java/lang/StringBuilder
    //   133: dup
    //   134: invokespecial <init> : ()V
    //   137: astore #6
    //   139: aload #6
    //   141: ldc_w '无法识别的order消息:'
    //   144: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   147: pop
    //   148: aload #6
    //   150: aload_1
    //   151: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   154: pop
    //   155: ldc 'Chat_Chat'
    //   157: aload #6
    //   159: invokevirtual toString : ()Ljava/lang/String;
    //   162: invokestatic e : (Ljava/lang/String;Ljava/lang/String;)I
    //   165: pop
    //   166: return
    //   167: getstatic com/blued/android/chat/ChatManager.debug : Z
    //   170: ifeq -> 182
    //   173: ldc 'Chat_Chat'
    //   175: ldc_w '收到闪聊对方匹配确认消息'
    //   178: invokestatic v : (Ljava/lang/String;Ljava/lang/String;)I
    //   181: pop
    //   182: aload_0
    //   183: getfield flashVideo : Lcom/blued/android/chat/core/worker/chat/FlashVideo;
    //   186: astore #6
    //   188: aload #6
    //   190: ifnull -> 930
    //   193: aload #6
    //   195: aload_1
    //   196: invokevirtual receiveFlashVideoMatchAgree : (Lcom/blued/android/chat/core/pack/PushMsgPackage;)V
    //   199: return
    //   200: getstatic com/blued/android/chat/ChatManager.debug : Z
    //   203: ifeq -> 215
    //   206: ldc 'Chat_Chat'
    //   208: ldc_w '收到闪聊申请加时消息'
    //   211: invokestatic v : (Ljava/lang/String;Ljava/lang/String;)I
    //   214: pop
    //   215: aload_0
    //   216: getfield flashVideo : Lcom/blued/android/chat/core/worker/chat/FlashVideo;
    //   219: astore #6
    //   221: aload #6
    //   223: ifnull -> 930
    //   226: aload #6
    //   228: aload_1
    //   229: invokevirtual receiveFlashVideoApplyExtraTime : (Lcom/blued/android/chat/core/pack/PushMsgPackage;)V
    //   232: return
    //   233: getstatic com/blued/android/chat/ChatManager.debug : Z
    //   236: ifeq -> 248
    //   239: ldc 'Chat_Chat'
    //   241: ldc_w '收到闪聊好友申请成功消息'
    //   244: invokestatic v : (Ljava/lang/String;Ljava/lang/String;)I
    //   247: pop
    //   248: aload_0
    //   249: getfield flashVideo : Lcom/blued/android/chat/core/worker/chat/FlashVideo;
    //   252: astore #6
    //   254: aload #6
    //   256: ifnull -> 930
    //   259: aload #6
    //   261: aload_1
    //   262: invokevirtual receiveFlashVideoFriendApplyAgree : (Lcom/blued/android/chat/core/pack/PushMsgPackage;)V
    //   265: return
    //   266: getstatic com/blued/android/chat/ChatManager.debug : Z
    //   269: ifeq -> 281
    //   272: ldc 'Chat_Chat'
    //   274: ldc_w '收到SayHi消息'
    //   277: invokestatic v : (Ljava/lang/String;Ljava/lang/String;)I
    //   280: pop
    //   281: aload_0
    //   282: getfield flashVideo : Lcom/blued/android/chat/core/worker/chat/FlashVideo;
    //   285: astore #6
    //   287: aload #6
    //   289: ifnull -> 930
    //   292: aload #6
    //   294: aload_1
    //   295: invokevirtual receiveFlashVideoSayHi : (Lcom/blued/android/chat/core/pack/PushMsgPackage;)V
    //   298: return
    //   299: getstatic com/blued/android/chat/ChatManager.debug : Z
    //   302: ifeq -> 314
    //   305: ldc 'Chat_Chat'
    //   307: ldc_w '收到闪聊好友申请消息'
    //   310: invokestatic v : (Ljava/lang/String;Ljava/lang/String;)I
    //   313: pop
    //   314: aload_0
    //   315: getfield flashVideo : Lcom/blued/android/chat/core/worker/chat/FlashVideo;
    //   318: astore #6
    //   320: aload #6
    //   322: ifnull -> 930
    //   325: aload #6
    //   327: aload_1
    //   328: invokevirtual receiveFlashVideoFriendApply : (Lcom/blued/android/chat/core/pack/PushMsgPackage;)V
    //   331: return
    //   332: getstatic com/blued/android/chat/ChatManager.debug : Z
    //   335: ifeq -> 347
    //   338: ldc 'Chat_Chat'
    //   340: ldc_w '对方结束闪聊'
    //   343: invokestatic v : (Ljava/lang/String;Ljava/lang/String;)I
    //   346: pop
    //   347: aload_0
    //   348: getfield flashVideo : Lcom/blued/android/chat/core/worker/chat/FlashVideo;
    //   351: astore #6
    //   353: aload #6
    //   355: ifnull -> 930
    //   358: aload #6
    //   360: aload_1
    //   361: invokevirtual receiveFlashVideoClosePush : (Lcom/blued/android/chat/core/pack/PushMsgPackage;)V
    //   364: return
    //   365: getstatic com/blued/android/chat/ChatManager.debug : Z
    //   368: ifeq -> 380
    //   371: ldc 'Chat_Chat'
    //   373: ldc_w '闪聊匹配成功'
    //   376: invokestatic v : (Ljava/lang/String;Ljava/lang/String;)I
    //   379: pop
    //   380: aload_0
    //   381: getfield flashVideo : Lcom/blued/android/chat/core/worker/chat/FlashVideo;
    //   384: astore #6
    //   386: aload #6
    //   388: ifnull -> 930
    //   391: aload #6
    //   393: aload_1
    //   394: invokevirtual receiveMatchedPush : (Lcom/blued/android/chat/core/pack/PushMsgPackage;)V
    //   397: return
    //   398: getstatic com/blued/android/chat/ChatManager.debug : Z
    //   401: ifeq -> 413
    //   404: ldc 'Chat_Chat'
    //   406: ldc_w '收到国际闪聊发送的表情消息'
    //   409: invokestatic v : (Ljava/lang/String;Ljava/lang/String;)I
    //   412: pop
    //   413: aload_0
    //   414: getfield flashVideo : Lcom/blued/android/chat/core/worker/chat/FlashVideo;
    //   417: astore #6
    //   419: aload #6
    //   421: ifnull -> 930
    //   424: aload #6
    //   426: aload_1
    //   427: invokevirtual receiveFlashVideoEmoji : (Lcom/blued/android/chat/core/pack/PushMsgPackage;)V
    //   430: return
    //   431: getstatic com/blued/android/chat/ChatManager.debug : Z
    //   434: ifeq -> 446
    //   437: ldc 'Chat_Chat'
    //   439: ldc_w '收到闪聊礼物消息'
    //   442: invokestatic v : (Ljava/lang/String;Ljava/lang/String;)I
    //   445: pop
    //   446: aload_0
    //   447: getfield flashVideo : Lcom/blued/android/chat/core/worker/chat/FlashVideo;
    //   450: astore #6
    //   452: aload #6
    //   454: ifnull -> 930
    //   457: aload #6
    //   459: aload_1
    //   460: invokevirtual receiveFlashVideoGift : (Lcom/blued/android/chat/core/pack/PushMsgPackage;)V
    //   463: return
    //   464: getstatic com/blued/android/chat/ChatManager.debug : Z
    //   467: ifeq -> 479
    //   470: ldc 'Chat_Chat'
    //   472: ldc_w '收到用户信息更新消息'
    //   475: invokestatic v : (Ljava/lang/String;Ljava/lang/String;)I
    //   478: pop
    //   479: aload_1
    //   480: getfield sessionType : S
    //   483: aload_1
    //   484: getfield sessionId : J
    //   487: invokestatic getSessionKey : (IJ)Ljava/lang/String;
    //   490: astore #6
    //   492: aload_0
    //   493: getfield sessionList : Ljava/util/Map;
    //   496: aload #6
    //   498: invokeinterface get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   503: checkcast com/blued/android/chat/model/SessionModel
    //   506: astore #6
    //   508: aload_1
    //   509: invokestatic toMsgData : (Lcom/blued/android/chat/core/pack/PushMsgPackage;)Lcom/blued/android/chat/model/ChattingModel;
    //   512: astore #7
    //   514: invokestatic getInstance : ()Lcom/blued/android/chat/ChatManager;
    //   517: invokevirtual getTipsListener : ()Lcom/blued/android/chat/listener/ChatTipsListener;
    //   520: astore #8
    //   522: aload #8
    //   524: ifnull -> 538
    //   527: aload #8
    //   529: aload #6
    //   531: aload #7
    //   533: invokeinterface onRecvNewMsg : (Lcom/blued/android/chat/model/SessionModel;Lcom/blued/android/chat/model/ChattingModel;)V
    //   538: aload_0
    //   539: getfield readedFlagSender : Lcom/blued/android/chat/core/worker/chat/ReadedFlagSender;
    //   542: aload_1
    //   543: getfield sessionType : S
    //   546: aload_1
    //   547: getfield sessionId : J
    //   550: aload_1
    //   551: getfield msgId : J
    //   554: getstatic com/blued/android/chat/compatible/IReceiptSender$ReceiptType.RECEIVED : Lcom/blued/android/chat/compatible/IReceiptSender$ReceiptType;
    //   557: iconst_1
    //   558: invokevirtual sendReceiptImmediateForOrder : (SJJLcom/blued/android/chat/compatible/IReceiptSender$ReceiptType;Z)V
    //   561: return
    //   562: getstatic com/blued/android/chat/ChatManager.debug : Z
    //   565: ifeq -> 577
    //   568: ldc 'Chat_Chat'
    //   570: ldc_w '收到消息撤回消息'
    //   573: invokestatic v : (Ljava/lang/String;Ljava/lang/String;)I
    //   576: pop
    //   577: aload_1
    //   578: getfield sessionType : S
    //   581: aload_1
    //   582: getfield sessionId : J
    //   585: invokestatic getSessionKey : (IJ)Ljava/lang/String;
    //   588: astore #7
    //   590: aload_0
    //   591: getfield sessionList : Ljava/util/Map;
    //   594: astore #6
    //   596: aload #6
    //   598: monitorenter
    //   599: aload_0
    //   600: getfield sessionList : Ljava/util/Map;
    //   603: aload #7
    //   605: invokeinterface get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   610: checkcast com/blued/android/chat/model/SessionModel
    //   613: astore #7
    //   615: iconst_0
    //   616: istore #5
    //   618: aload #7
    //   620: ifnull -> 950
    //   623: aload #7
    //   625: getfield maxMsgId : J
    //   628: aload_1
    //   629: getfield msgId : J
    //   632: lcmp
    //   633: ifne -> 937
    //   636: aload #7
    //   638: bipush #55
    //   640: putfield lastMsgType : S
    //   643: aload_0
    //   644: aload #7
    //   646: getfield sessionType : S
    //   649: aload_1
    //   650: getfield fromId : J
    //   653: aload #7
    //   655: getfield lastMsgFromId : J
    //   658: invokespecial isGroupManagerRetract : (SJJ)Z
    //   661: ifeq -> 671
    //   664: aload #7
    //   666: bipush #10
    //   668: putfield lastMsgStateCode : S
    //   671: getstatic com/blued/android/chat/ChatManager.dbOperImpl : Lcom/blued/android/chat/db/DBOper;
    //   674: aload #7
    //   676: invokeinterface updateSession : (Lcom/blued/android/chat/model/SessionModel;)V
    //   681: iconst_1
    //   682: istore_2
    //   683: goto -> 686
    //   686: aload #7
    //   688: getfield _msgList : Ljava/util/List;
    //   691: ifnull -> 795
    //   694: aload #7
    //   696: getfield _msgList : Ljava/util/List;
    //   699: invokeinterface iterator : ()Ljava/util/Iterator;
    //   704: astore #8
    //   706: iload #5
    //   708: istore_3
    //   709: iload_2
    //   710: istore #4
    //   712: aload #8
    //   714: invokeinterface hasNext : ()Z
    //   719: ifeq -> 877
    //   722: aload #8
    //   724: invokeinterface next : ()Ljava/lang/Object;
    //   729: checkcast com/blued/android/chat/model/ChattingModel
    //   732: astore #9
    //   734: aload #9
    //   736: getfield msgId : J
    //   739: aload_1
    //   740: getfield msgId : J
    //   743: lcmp
    //   744: ifne -> 706
    //   747: aload #9
    //   749: bipush #55
    //   751: putfield msgType : S
    //   754: aload_0
    //   755: aload #9
    //   757: getfield sessionType : S
    //   760: aload_1
    //   761: getfield fromId : J
    //   764: aload #9
    //   766: getfield fromId : J
    //   769: invokespecial isGroupManagerRetract : (SJJ)Z
    //   772: ifeq -> 782
    //   775: aload #9
    //   777: bipush #10
    //   779: putfield msgStateCode : S
    //   782: getstatic com/blued/android/chat/ChatManager.dbOperImpl : Lcom/blued/android/chat/db/DBOper;
    //   785: aload #9
    //   787: invokeinterface updateChattingModel : (Lcom/blued/android/chat/model/ChattingModel;)V
    //   792: goto -> 942
    //   795: getstatic com/blued/android/chat/ChatManager.dbOperImpl : Lcom/blued/android/chat/db/DBOper;
    //   798: aload_1
    //   799: getfield sessionType : S
    //   802: aload_1
    //   803: getfield sessionId : J
    //   806: aload_1
    //   807: getfield msgId : J
    //   810: lconst_0
    //   811: invokeinterface findMsgData : (SJJJ)Lcom/blued/android/chat/model/ChattingModel;
    //   816: astore #8
    //   818: iload #5
    //   820: istore_3
    //   821: iload_2
    //   822: istore #4
    //   824: aload #8
    //   826: ifnull -> 877
    //   829: aload #8
    //   831: bipush #55
    //   833: putfield msgType : S
    //   836: aload_0
    //   837: aload #8
    //   839: getfield sessionType : S
    //   842: aload_1
    //   843: getfield fromId : J
    //   846: aload #8
    //   848: getfield fromId : J
    //   851: invokespecial isGroupManagerRetract : (SJJ)Z
    //   854: ifeq -> 864
    //   857: aload #8
    //   859: bipush #10
    //   861: putfield msgStateCode : S
    //   864: getstatic com/blued/android/chat/ChatManager.dbOperImpl : Lcom/blued/android/chat/db/DBOper;
    //   867: aload #8
    //   869: invokeinterface updateChattingModel : (Lcom/blued/android/chat/model/ChattingModel;)V
    //   874: goto -> 942
    //   877: aload #6
    //   879: monitorexit
    //   880: aload_0
    //   881: getfield readedFlagSender : Lcom/blued/android/chat/core/worker/chat/ReadedFlagSender;
    //   884: aload_1
    //   885: getfield sessionType : S
    //   888: aload_1
    //   889: getfield sessionId : J
    //   892: aload_1
    //   893: getfield msgId : J
    //   896: getstatic com/blued/android/chat/compatible/IReceiptSender$ReceiptType.RECEIVED : Lcom/blued/android/chat/compatible/IReceiptSender$ReceiptType;
    //   899: iconst_1
    //   900: invokevirtual sendReceiptImmediateForOrder : (SJJLcom/blued/android/chat/compatible/IReceiptSender$ReceiptType;Z)V
    //   903: iload_3
    //   904: ifeq -> 919
    //   907: aload_0
    //   908: aload_1
    //   909: getfield sessionType : S
    //   912: aload_1
    //   913: getfield sessionId : J
    //   916: invokespecial notifyMsgListChanged : (IJ)V
    //   919: iload #4
    //   921: ifeq -> 930
    //   924: aload_0
    //   925: aload #7
    //   927: invokespecial notifySessionChanged : (Lcom/blued/android/chat/model/SessionModel;)V
    //   930: return
    //   931: astore_1
    //   932: aload #6
    //   934: monitorexit
    //   935: aload_1
    //   936: athrow
    //   937: iconst_0
    //   938: istore_2
    //   939: goto -> 686
    //   942: iconst_1
    //   943: istore_3
    //   944: iload_2
    //   945: istore #4
    //   947: goto -> 877
    //   950: iconst_0
    //   951: istore #4
    //   953: iload #5
    //   955: istore_3
    //   956: goto -> 877
    // Exception table:
    //   from	to	target	type
    //   599	615	931	finally
    //   623	671	931	finally
    //   671	681	931	finally
    //   686	706	931	finally
    //   712	782	931	finally
    //   782	792	931	finally
    //   795	818	931	finally
    //   829	864	931	finally
    //   864	874	931	finally
    //   877	880	931	finally
    //   932	935	931	finally
  }
  
  private void recvDeletePackage(DeleteAckPackage paramDeleteAckPackage) {}
  
  private void recvDeleteRetractAckPackage(DeleteRetractMessagePackage paramDeleteRetractMessagePackage) {
    // Byte code:
    //   0: aload_1
    //   1: getfield sessionType : S
    //   4: aload_1
    //   5: getfield sessionId : J
    //   8: invokestatic getSessionKey : (IJ)Ljava/lang/String;
    //   11: astore #8
    //   13: aload_0
    //   14: getfield sessionList : Ljava/util/Map;
    //   17: astore #7
    //   19: aload #7
    //   21: monitorenter
    //   22: aload_0
    //   23: getfield sessionList : Ljava/util/Map;
    //   26: aload #8
    //   28: invokeinterface get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   33: checkcast com/blued/android/chat/model/SessionModel
    //   36: astore #8
    //   38: iconst_0
    //   39: istore #6
    //   41: aload #8
    //   43: ifnull -> 251
    //   46: aload #8
    //   48: getfield maxMsgId : J
    //   51: aload_1
    //   52: getfield messageId : J
    //   55: lcmp
    //   56: ifne -> 237
    //   59: aload #8
    //   61: bipush #55
    //   63: putfield lastMsgType : S
    //   66: getstatic com/blued/android/chat/ChatManager.dbOperImpl : Lcom/blued/android/chat/db/DBOper;
    //   69: aload #8
    //   71: invokeinterface updateSession : (Lcom/blued/android/chat/model/SessionModel;)V
    //   76: iconst_1
    //   77: istore_2
    //   78: goto -> 81
    //   81: iload #6
    //   83: istore_3
    //   84: iload_2
    //   85: istore #5
    //   87: aload #8
    //   89: getfield _msgList : Ljava/util/List;
    //   92: ifnull -> 200
    //   95: iconst_0
    //   96: istore #4
    //   98: iload #6
    //   100: istore_3
    //   101: iload_2
    //   102: istore #5
    //   104: iload #4
    //   106: aload #8
    //   108: getfield _msgList : Ljava/util/List;
    //   111: invokeinterface size : ()I
    //   116: if_icmpge -> 200
    //   119: aload #8
    //   121: getfield _msgList : Ljava/util/List;
    //   124: iload #4
    //   126: invokeinterface get : (I)Ljava/lang/Object;
    //   131: checkcast com/blued/android/chat/model/ChattingModel
    //   134: astore #9
    //   136: aload #9
    //   138: getfield msgId : J
    //   141: aload_1
    //   142: getfield messageId : J
    //   145: lcmp
    //   146: ifne -> 242
    //   149: new com/blued/android/chat/model/ChattingModel
    //   152: dup
    //   153: aload #9
    //   155: invokespecial <init> : (Lcom/blued/android/chat/model/ChattingModel;)V
    //   158: astore #9
    //   160: aload #8
    //   162: getfield _msgList : Ljava/util/List;
    //   165: iload #4
    //   167: aload #9
    //   169: invokeinterface set : (ILjava/lang/Object;)Ljava/lang/Object;
    //   174: pop
    //   175: aload #9
    //   177: bipush #55
    //   179: putfield msgType : S
    //   182: getstatic com/blued/android/chat/ChatManager.dbOperImpl : Lcom/blued/android/chat/db/DBOper;
    //   185: aload #9
    //   187: invokeinterface updateChattingModel : (Lcom/blued/android/chat/model/ChattingModel;)V
    //   192: iconst_1
    //   193: istore_3
    //   194: iload_2
    //   195: istore #5
    //   197: goto -> 200
    //   200: aload #7
    //   202: monitorexit
    //   203: iload_3
    //   204: ifeq -> 219
    //   207: aload_0
    //   208: aload_1
    //   209: getfield sessionType : S
    //   212: aload_1
    //   213: getfield sessionId : J
    //   216: invokespecial notifyMsgListChanged : (IJ)V
    //   219: iload #5
    //   221: ifeq -> 230
    //   224: aload_0
    //   225: aload #8
    //   227: invokespecial notifySessionChanged : (Lcom/blued/android/chat/model/SessionModel;)V
    //   230: return
    //   231: astore_1
    //   232: aload #7
    //   234: monitorexit
    //   235: aload_1
    //   236: athrow
    //   237: iconst_0
    //   238: istore_2
    //   239: goto -> 81
    //   242: iload #4
    //   244: iconst_1
    //   245: iadd
    //   246: istore #4
    //   248: goto -> 98
    //   251: iconst_0
    //   252: istore #5
    //   254: iload #6
    //   256: istore_3
    //   257: goto -> 200
    // Exception table:
    //   from	to	target	type
    //   22	38	231	finally
    //   46	76	231	finally
    //   87	95	231	finally
    //   104	192	231	finally
    //   200	203	231	finally
    //   232	235	231	finally
  }
  
  private void recvDeleteRetractAckPackage(DeleteRetractMessagePackage paramDeleteRetractMessagePackage, DeleteAckPackage paramDeleteAckPackage) {
    if (ChatManager.debug) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("recvDeleteRetractAckPackage(), sessionType:");
      stringBuilder.append(paramDeleteRetractMessagePackage.sessionType);
      stringBuilder.append(", sessionId:");
      stringBuilder.append(paramDeleteRetractMessagePackage.sessionId);
      stringBuilder.append(", messageId:");
      stringBuilder.append(paramDeleteRetractMessagePackage.messageId);
      stringBuilder.append("localId:");
      stringBuilder.append(paramDeleteAckPackage.localId);
      Log.v("Chat_Chat", stringBuilder.toString());
    } 
    recvDeleteRetractAckPackage(paramDeleteRetractMessagePackage);
  }
  
  private void recvPushMsgPackage(PushMsgPackage paramPushMsgPackage) {
    ChattingModel chattingModel;
    ChatHelper.checkMsgType(paramPushMsgPackage);
    if (paramPushMsgPackage.fromId == ChatManager.userInfo.uid && paramPushMsgPackage.msgType == 17) {
      ArrayList<Pair> arrayList = new ArrayList();
      arrayList.add(new Pair(Short.valueOf(paramPushMsgPackage.sessionType), Long.valueOf(paramPushMsgPackage.sessionId)));
      deleteSessions((List)arrayList, true, false, true);
      return;
    } 
    if (paramPushMsgPackage.pushBasePackage.msgHeader.isOrder) {
      if (ChatManager.debug)
        Log.e("Chat_Chat", "msgHeader.isOrder"); 
      receiveOrderMessage(paramPushMsgPackage);
      return;
    } 
    if (paramPushMsgPackage.sessionType == 1 && (paramPushMsgPackage.sessionId == 16L || paramPushMsgPackage.sessionId == 25L)) {
      chattingModel = PushMsgPackage.toMsgData(paramPushMsgPackage);
      ChatTipsListener chatTipsListener = ChatManager.getInstance().getTipsListener();
      if (chatTipsListener != null) {
        chatTipsListener.onRecvNewMsg(null, chattingModel);
        return;
      } 
    } else {
      if (((PushMsgPackage)chattingModel).sessionType == 7) {
        RoomChat roomChat = this.roomChat;
        if (roomChat == null || roomChat.handleRoomMessage((PushMsgPackage)chattingModel))
          return; 
      } 
      chattingModel = PushMsgPackage.toMsgData((PushMsgPackage)chattingModel);
      if (ChatManager.debug) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("msgType: ");
        stringBuilder.append(chattingModel.msgType);
        stringBuilder.append("--fromId: ");
        stringBuilder.append(chattingModel.isFromSelf());
        Log.e("Chat_Chat", stringBuilder.toString());
      } 
      ArrayList<ChattingModel> arrayList = new ArrayList();
      arrayList.add(chattingModel);
      insertRecvMsgList(arrayList);
      setMsgAndSessionReadFlag(chattingModel);
    } 
  }
  
  private void recvPushReadedPackage(PushReadedPackage paramPushReadedPackage) {
    if (ChatManager.debug) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("recvPushReadedPackage(), pack:");
      stringBuilder.append(paramPushReadedPackage);
      Log.v("Chat_Chat", stringBuilder.toString());
    } 
    setMsgReadedFlag(paramPushReadedPackage.sessionType, paramPushReadedPackage.sessionId, paramPushReadedPackage.msgId);
  }
  
  private void recvReqAckPackage(ReqAckPackage paramReqAckPackage) {
    int i = paramReqAckPackage.reqType;
    if (i != 1) {
      if (i != 6) {
        if (i != 13) {
          if (i != 17) {
            if (i != 3) {
              if (i != 4) {
                LiveChat liveChat;
                switch (i) {
                  default:
                    if (ChatManager.debug) {
                      StringBuilder stringBuilder = new StringBuilder();
                      stringBuilder.append("unknown package recvReqAckPackage, pack:");
                      stringBuilder.append(paramReqAckPackage);
                      Log.e("Chat_Chat", stringBuilder.toString());
                      return;
                    } 
                    break;
                  case 11:
                    liveChat = this.liveChat;
                    if (liveChat != null) {
                      liveChat.recvReqJoinLivePackage(paramReqAckPackage);
                      return;
                    } 
                    break;
                  case 9:
                    liveChat = this.liveChat;
                    if (liveChat != null) {
                      liveChat.recvReqRecoverLiveChatPackage(paramReqAckPackage);
                      return;
                    } 
                    break;
                  case 8:
                    liveChat = this.liveChat;
                    if (liveChat != null) {
                      liveChat.recvReqGetLiveChatInfoPackage(paramReqAckPackage);
                      return;
                    } 
                    break;
                  case 10:
                    break;
                } 
              } else {
                LiveChat liveChat = this.liveChat;
                if (liveChat != null) {
                  liveChat.recvReqCloseLiveChatPackage(paramReqAckPackage);
                  return;
                } 
              } 
            } else {
              LiveChat liveChat = this.liveChat;
              if (liveChat != null) {
                liveChat.recvReqCreateLiveChatPackage(paramReqAckPackage, null);
                return;
              } 
            } 
          } else {
            VideoChat videoChat = this.videoChat;
            if (videoChat != null) {
              videoChat.recvReqGetLeftTime(paramReqAckPackage);
              return;
            } 
          } 
        } else {
          VideoChat videoChat = this.videoChat;
          if (videoChat != null) {
            videoChat.recvReqCreateVideoChatPackage(paramReqAckPackage);
            return;
          } 
        } 
      } else {
        LiveChat liveChat = this.liveChat;
        if (liveChat != null) {
          liveChat.recvReqEnterLiveChatPackage(paramReqAckPackage, null);
          return;
        } 
      } 
    } else {
      recvReqSessionAckPackage(paramReqAckPackage);
    } 
  }
  
  private void recvReqSessionAckPackage(ReqAckPackage paramReqAckPackage) {
    // Byte code:
    //   0: aload_0
    //   1: getfield sessionList : Ljava/util/Map;
    //   4: astore #8
    //   6: aload #8
    //   8: monitorenter
    //   9: aload_0
    //   10: getfield reqSessionKeyList : Landroidx/collection/LongSparseArray;
    //   13: astore #5
    //   15: iconst_0
    //   16: istore_3
    //   17: iconst_0
    //   18: istore #4
    //   20: aload #5
    //   22: ifnull -> 368
    //   25: aload_0
    //   26: getfield reqSessionKeyList : Landroidx/collection/LongSparseArray;
    //   29: aload_1
    //   30: getfield localId : J
    //   33: invokevirtual get : (J)Ljava/lang/Object;
    //   36: checkcast java/lang/String
    //   39: astore #5
    //   41: aload #5
    //   43: ifnonnull -> 50
    //   46: aload #8
    //   48: monitorexit
    //   49: return
    //   50: aload_0
    //   51: getfield reqSessionKeyList : Landroidx/collection/LongSparseArray;
    //   54: aload_1
    //   55: getfield localId : J
    //   58: invokevirtual remove : (J)V
    //   61: aload_0
    //   62: getfield sessionList : Ljava/util/Map;
    //   65: aload #5
    //   67: invokeinterface get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   72: checkcast com/blued/android/chat/model/SessionModel
    //   75: astore #6
    //   77: aload #6
    //   79: astore #5
    //   81: aload #6
    //   83: ifnull -> 343
    //   86: aload #6
    //   88: iconst_0
    //   89: putfield _isRequestingInfo : Z
    //   92: iload #4
    //   94: istore_2
    //   95: aload_1
    //   96: getfield result : S
    //   99: ifne -> 314
    //   102: iload #4
    //   104: istore_2
    //   105: aload_1
    //   106: getfield reqResponse : Ljava/util/Map;
    //   109: ifnull -> 314
    //   112: aload_1
    //   113: getfield reqResponse : Ljava/util/Map;
    //   116: ldc_w 'name'
    //   119: invokestatic getStringValue : (Ljava/util/Map;Ljava/lang/String;)Ljava/lang/String;
    //   122: astore #7
    //   124: aload_1
    //   125: getfield reqResponse : Ljava/util/Map;
    //   128: ldc_w 'avatar'
    //   131: invokestatic getStringValue : (Ljava/util/Map;Ljava/lang/String;)Ljava/lang/String;
    //   134: astore #9
    //   136: aload_1
    //   137: getfield reqResponse : Ljava/util/Map;
    //   140: ldc_w 'note'
    //   143: invokestatic getStringValue : (Ljava/util/Map;Ljava/lang/String;)Ljava/lang/String;
    //   146: astore #5
    //   148: aload #6
    //   150: aload_1
    //   151: getfield reqResponse : Ljava/util/Map;
    //   154: ldc_w 'vbadge'
    //   157: invokestatic getLongValue : (Ljava/util/Map;Ljava/lang/String;)J
    //   160: l2i
    //   161: putfield vBadge : I
    //   164: aload #6
    //   166: aload_1
    //   167: getfield reqResponse : Ljava/util/Map;
    //   170: ldc_w 'vip_grade'
    //   173: invokestatic getIntValue : (Ljava/util/Map;Ljava/lang/String;)I
    //   176: putfield vipGrade : I
    //   179: aload #6
    //   181: aload_1
    //   182: getfield reqResponse : Ljava/util/Map;
    //   185: ldc_w 'o_vip_grade'
    //   188: invokestatic getIntValue : (Ljava/util/Map;Ljava/lang/String;)I
    //   191: putfield ovipGrade : I
    //   194: aload #6
    //   196: aload_1
    //   197: getfield reqResponse : Ljava/util/Map;
    //   200: ldc_w 'o_is_hide_vip_look'
    //   203: invokestatic getIntValue : (Ljava/util/Map;Ljava/lang/String;)I
    //   206: putfield ohideVipLook : I
    //   209: aload #6
    //   211: aload_1
    //   212: getfield reqResponse : Ljava/util/Map;
    //   215: ldc_w 'o_face_status'
    //   218: invokestatic getIntValue : (Ljava/util/Map;Ljava/lang/String;)I
    //   221: putfield oFaceStatus : I
    //   224: aload #6
    //   226: aload_1
    //   227: getfield reqResponse : Ljava/util/Map;
    //   230: ldc_w 'vip_annual'
    //   233: invokestatic getIntValue : (Ljava/util/Map;Ljava/lang/String;)I
    //   236: putfield vipAnnual : I
    //   239: aload #6
    //   241: aload_1
    //   242: getfield reqResponse : Ljava/util/Map;
    //   245: ldc_w 'vip_exp_lvl'
    //   248: invokestatic getIntValue : (Ljava/util/Map;Ljava/lang/String;)I
    //   251: putfield vipExpLvl : I
    //   254: aload #6
    //   256: aload_1
    //   257: getfield reqResponse : Ljava/util/Map;
    //   260: ldc_w 'is_hide_vip_look'
    //   263: invokestatic getIntValue : (Ljava/util/Map;Ljava/lang/String;)I
    //   266: putfield hideVipLook : I
    //   269: aload #7
    //   271: astore_1
    //   272: aload #5
    //   274: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   277: ifne -> 283
    //   280: aload #5
    //   282: astore_1
    //   283: aload_1
    //   284: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   287: ifne -> 296
    //   290: aload #6
    //   292: aload_1
    //   293: putfield nickName : Ljava/lang/String;
    //   296: aload #9
    //   298: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   301: ifne -> 363
    //   304: aload #6
    //   306: aload #9
    //   308: putfield avatar : Ljava/lang/String;
    //   311: goto -> 363
    //   314: aload #6
    //   316: astore #5
    //   318: iload_2
    //   319: istore_3
    //   320: iload_2
    //   321: ifeq -> 343
    //   324: getstatic com/blued/android/chat/ChatManager.dbOperImpl : Lcom/blued/android/chat/db/DBOper;
    //   327: aload #6
    //   329: invokeinterface updateSession : (Lcom/blued/android/chat/model/SessionModel;)V
    //   334: aload #6
    //   336: astore #5
    //   338: iload_2
    //   339: istore_3
    //   340: goto -> 343
    //   343: aload #8
    //   345: monitorexit
    //   346: iload_3
    //   347: ifeq -> 356
    //   350: aload_0
    //   351: aload #5
    //   353: invokespecial notifySessionChanged : (Lcom/blued/android/chat/model/SessionModel;)V
    //   356: return
    //   357: astore_1
    //   358: aload #8
    //   360: monitorexit
    //   361: aload_1
    //   362: athrow
    //   363: iconst_1
    //   364: istore_2
    //   365: goto -> 314
    //   368: aconst_null
    //   369: astore #5
    //   371: goto -> 343
    // Exception table:
    //   from	to	target	type
    //   9	15	357	finally
    //   25	41	357	finally
    //   46	49	357	finally
    //   50	77	357	finally
    //   86	92	357	finally
    //   95	102	357	finally
    //   105	269	357	finally
    //   272	280	357	finally
    //   283	296	357	finally
    //   296	311	357	finally
    //   324	334	357	finally
    //   343	346	357	finally
    //   358	361	357	finally
  }
  
  private boolean recvSendAckPackage(SendAckPackage paramSendAckPackage) {
    LongSparseArray<SendMsgPackage> longSparseArray;
    StringBuilder stringBuilder;
    synchronized (this.sendingPackageList) {
      SendMsgPackage sendMsgPackage = (SendMsgPackage)this.sendingPackageList.get(paramSendAckPackage.localId);
      if (sendMsgPackage != null)
        this.sendingPackageList.remove(paramSendAckPackage.localId); 
      if (sendMsgPackage == null) {
        if (ChatManager.debug)
          Log.e("Chat_Chat", "the send ack can't find sending package"); 
        return false;
      } 
      if (ChatManager.debug) {
        stringBuilder = new StringBuilder();
        stringBuilder.append("recv send ack for pack:");
        stringBuilder.append(paramSendAckPackage);
        Log.v("Chat_Chat", stringBuilder.toString());
      } 
      DataUtils.imMessageSuccess(BasePackage.typeToString((BasePackage)sendMsgPackage), SystemClock.uptimeMillis() - sendMsgPackage.sendTime);
      notifySendPackageStateChanged(sendMsgPackage, paramSendAckPackage.result, paramSendAckPackage);
      return true;
    } 
  }
  
  private void recvSyncMsgList(List<ChattingModel> paramList) {
    if (ChatManager.debug) {
      int i;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("recvSyncMsgList(), syncMsgList size:");
      if (paramList == null) {
        i = 0;
      } else {
        i = paramList.size();
      } 
      stringBuilder.append(i);
      Log.v("Chat_Chat", stringBuilder.toString());
    } 
    if (paramList != null) {
      if (paramList.size() == 0)
        return; 
      ArrayMap<String, List<ChattingModel>> arrayMap = new ArrayMap();
      for (ChattingModel chattingModel : paramList) {
        String str = SessionHeader.getSessionKey(chattingModel.sessionType, chattingModel.sessionId);
        List<ChattingModel> list = (List)arrayMap.get(str);
        paramList = list;
        if (list == null) {
          paramList = new ArrayList<ChattingModel>();
          arrayMap.put(str, paramList);
        } 
        paramList.add(chattingModel);
      } 
      for (List<ChattingModel> list : arrayMap.values()) {
        MsgComparator.sortPair(list);
        insertRecvMsgList(list);
        setMsgAndSessionReadFlag(list.get(list.size() - 1));
      } 
    } 
  }
  
  private void recvSyncPackage(SyncAckPackage paramSyncAckPackage) {
    LongSparseArray<Pair<LoadListener, List<ChattingModel>>> longSparseArray;
    ArrayList<ChattingModel> arrayList;
    if (ChatManager.debug) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("recv sync pack, syncAckPackage:");
      stringBuilder.append(paramSyncAckPackage);
      Log.v("Chat_Chat", stringBuilder.toString());
    } 
    synchronized (this.syncLoadListener) {
      Pair pair = (Pair)this.syncLoadListener.get(paramSyncAckPackage.localId);
      LoadListener loadListener = null;
      if (pair != null) {
        loadListener = (LoadListener)pair.first;
        List list = (List)pair.second;
      } else {
        pair = null;
      } 
      if (loadListener != null)
        this.syncLoadListener.remove(paramSyncAckPackage.localId); 
      if (paramSyncAckPackage.result == 0) {
        if (paramSyncAckPackage.syncMsgList != null) {
          arrayList = new ArrayList();
          for (PushMsgPackage pushMsgPackage : paramSyncAckPackage.syncMsgList) {
            ChatHelper.checkMsgType(pushMsgPackage);
            arrayList.add(PushMsgPackage.toMsgData(pushMsgPackage));
          } 
          mergeLocalMsgListForSync((List<ChattingModel>)pair, arrayList);
          recvSyncMsgList(arrayList);
        } 
        if (loadListener != null) {
          loadListener.onLoadSuccess();
          return;
        } 
      } else if (pair != null) {
        insertMsgListToMemory((List<ChattingModel>)pair);
        if (loadListener != null) {
          loadListener.onLoadSuccess();
          return;
        } 
      } else if (loadListener != null) {
        loadListener.onLoadFailed("failed");
      } 
      return;
    } 
  }
  
  private boolean removeSessionAtMsgId(SessionModel paramSessionModel) {
    if (paramSessionModel.atMessageId > 0L) {
      paramSessionModel.atMessageId = 0L;
      return true;
    } 
    return false;
  }
  
  private boolean removeSessionUnreadMsg(SessionModel paramSessionModel) {
    boolean bool;
    if (paramSessionModel._unreadedMsgIds != null)
      paramSessionModel._unreadedMsgIds.clear(); 
    if (paramSessionModel.noReadMsgCount != 0) {
      paramSessionModel.noReadMsgCount = 0;
      ChatHelper.clearSessionLikeNum(paramSessionModel);
      bool = true;
    } else {
      bool = false;
    } 
    if (paramSessionModel.maxHasReadMsgID < paramSessionModel.maxMsgId) {
      paramSessionModel.maxHasReadMsgID = paramSessionModel.maxMsgId;
      bool = true;
    } 
    if (paramSessionModel.secretLookStatus == 1) {
      paramSessionModel.secretLookStatus = 0;
      bool = true;
    } 
    return bool;
  }
  
  private void requestSessionData(SessionModel paramSessionModel) {
    if (!paramSessionModel._isRequestingInfo) {
      String str = SessionHeader.getSessionKey(paramSessionModel.sessionType, paramSessionModel.sessionId);
      long l = ChatHelper.getLocalId();
      ReqSessionPackage reqSessionPackage = new ReqSessionPackage(paramSessionModel.sessionType, paramSessionModel.sessionId, l);
      TimeoutUtils.addTimeoutPackage(l, reqSessionPackage, 30000L, this);
      if (this.reqSessionKeyList == null)
        this.reqSessionKeyList = new LongSparseArray(); 
      this.reqSessionKeyList.put(l, str);
      paramSessionModel._isRequestingInfo = true;
      this.connector.sendPackage((BasePackage)reqSessionPackage);
    } 
  }
  
  private void resetSessionNoReadMsgCnt(short paramShort, long paramLong1, long paramLong2) {
    null = SessionHeader.getSessionKey(paramShort, paramLong1);
    synchronized (this.sessionList) {
      SessionModel sessionModel = this.sessionList.get(null);
      boolean bool = false;
      paramShort = bool;
      if (sessionModel != null) {
        paramShort = bool;
        if (paramLong2 >= sessionModel.maxMsgId) {
          paramShort = bool;
          if (sessionModel.noReadMsgCount > 0) {
            sessionModel.noReadMsgCount = 0;
            ChatHelper.clearSessionLikeNum(sessionModel);
            paramShort = 1;
          } 
        } 
      } 
      if (paramShort != 0)
        ChatManager.dbOperImpl.updateSession(sessionModel); 
      return;
    } 
  }
  
  private void sendDestroyMsgReqToServer(short paramShort, long paramLong1, long paramLong2) {
    ReqDestroyMsgPackage reqDestroyMsgPackage = new ReqDestroyMsgPackage(paramShort, paramLong1, paramLong2, ChatHelper.getLocalId());
    this.connector.sendPackage((BasePackage)reqDestroyMsgPackage);
  }
  
  private void sendMsgPackageFailed(SendMsgPackage paramSendMsgPackage, int paramInt) {
    if (ChatManager.debug) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("sendMsgPackageFailed(), msgPackage:");
      stringBuilder.append(paramSendMsgPackage);
      stringBuilder.append(", failedReason:");
      stringBuilder.append(paramInt);
      Log.v("Chat_Chat", stringBuilder.toString());
    } 
    synchronized (this.sendingPackageList) {
      this.sendingPackageList.remove(paramSendMsgPackage.localId);
      notifySendPackageStateChanged(paramSendMsgPackage, paramInt);
      return;
    } 
  }
  
  private void sendMsgToServer(ChattingModel paramChattingModel) {
    null = ChatHelper.getSendMsgPackageFromChattingModel(paramChattingModel);
    synchronized (this.sendingPackageList) {
      this.sendingPackageList.put(null.localId, null);
      TimeoutUtils.addTimeoutPackage(null.localId, null, 30000L, this);
      this.connector.sendPackage((BasePackage)null);
      return;
    } 
  }
  
  private boolean sendReadedFlagForSession(SessionModel paramSessionModel) {
    if (paramSessionModel != null && paramSessionModel.lastMsgFromId != ChatManager.getInstance().getUid() && paramSessionModel.maxHasReadMsgID < paramSessionModel.maxMsgId) {
      this.readedFlagSender.sendReceiptImmediate(paramSessionModel.sessionType, paramSessionModel.sessionId, paramSessionModel.maxMsgId, IReceiptSender.ReceiptType.READED);
      paramSessionModel.maxHasReadMsgID = paramSessionModel.maxMsgId;
      return true;
    } 
    return false;
  }
  
  private void sendReqSessionFailed(ReqSessionPackage paramReqSessionPackage) {
    TimeoutUtils.cancelTimeoutPackage(paramReqSessionPackage.localId);
    null = SessionHeader.getSessionKey(paramReqSessionPackage.sessionType, paramReqSessionPackage.sessionId);
    synchronized (this.sessionList) {
      SessionModel sessionModel = this.sessionList.get(null);
      if (sessionModel != null)
        sessionModel._isRequestingInfo = false; 
      return;
    } 
  }
  
  private void sendSyncAllPackage(long paramLong1, long paramLong2) {
    SyncAllSessionsPackage syncAllSessionsPackage;
    syncStart();
    if (paramLong1 > 0L) {
      if (ChatManager.debug)
        Log.v("Chat_Chat", "syncType: SYNC_NEW"); 
      SyncOfflineMsgPackage syncOfflineMsgPackage = new SyncOfflineMsgPackage(ChatHelper.getLocalId(), paramLong2);
    } else {
      if (ChatManager.debug)
        Log.v("Chat_Chat", "syncType: SYNC_ALL"); 
      syncAllSessionsPackage = new SyncAllSessionsPackage(ChatHelper.getLocalId());
    } 
    this.packSendHelper.sendPackage((BasePackage)syncAllSessionsPackage, 60000, new PackSendHelper.PackCallback() {
          public void onAckTimeout(BasePackage param1BasePackage) {
            if (!Chat.this.retrySyncMsg(true))
              Chat.this.syncFinish(); 
          }
          
          public void onReceiveAck(BasePackage param1BasePackage1, BasePackage param1BasePackage2) {
            if (param1BasePackage2 instanceof SyncAckPackage) {
              if (Chat.this.initMaxMsgId == 0L) {
                SyncAckPackage syncAckPackage1 = (SyncAckPackage)param1BasePackage2;
                if (syncAckPackage1.syncMsgList != null && syncAckPackage1.syncMsgList.size() > 0) {
                  Chat.access$302(Chat.this, ((PushMsgPackage)syncAckPackage1.syncMsgList.get(0)).msgId);
                } else {
                  Chat.access$302(Chat.this, 1L);
                } 
              } 
              Chat chat = Chat.this;
              SyncAckPackage syncAckPackage = (SyncAckPackage)param1BasePackage2;
              chat.recvSyncPackage(syncAckPackage);
              if (syncAckPackage.hasMore) {
                chat = Chat.this;
                chat.sendSyncAllPackage(chat.initMaxMsgId, syncAckPackage.syncLocalId);
                return;
              } 
              Chat.this.syncFinish();
            } 
          }
          
          public void onSendFailed(BasePackage param1BasePackage) {
            if (!Chat.this.retrySyncMsg(true))
              Chat.this.syncFinish(); 
          }
          
          public void onSendFinish(BasePackage param1BasePackage) {}
          
          public void onSendTimeout(BasePackage param1BasePackage) {
            if (!Chat.this.retrySyncMsg(true))
              Chat.this.syncFinish(); 
          }
        });
  }
  
  private void sendSyncMsgPackage(short paramShort, long paramLong1, long paramLong2, long paramLong3, LoadListener paramLoadListener, List<ChattingModel> paramList) {
    long l1 = paramLong2;
    if (ChatManager.debug) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("sendSyncMsgPackage(), sessionType:");
      stringBuilder.append(paramShort);
      stringBuilder.append(", sessionId:");
      stringBuilder.append(paramLong1);
      stringBuilder.append(", startId:");
      stringBuilder.append(l1);
      stringBuilder.append(", endId:");
      stringBuilder.append(paramLong3);
      stringBuilder.append(", loadListener:");
      stringBuilder.append(paramLoadListener);
      Log.v("Chat_Chat", stringBuilder.toString());
    } 
    long l2 = ChatHelper.getLocalId();
    paramLong2 = l1;
    if (l1 > 0L)
      paramLong2 = l1 + 1L; 
    l1 = paramLong3;
    if (paramLong3 > 0L)
      l1 = paramLong3 - 1L; 
    if (paramLong2 > l1) {
      if (paramLoadListener != null)
        paramLoadListener.onLoadSuccess(); 
      return;
    } 
    SyncIntervalMsgsPackage syncIntervalMsgsPackage = new SyncIntervalMsgsPackage(paramShort, paramLong1, paramLong2, l1, l2);
    if (paramLoadListener != null)
      synchronized (this.syncLoadListener) {
        this.syncLoadListener.put(l2, new Pair(paramLoadListener, paramList));
        TimeoutUtils.addTimeoutPackage(l2, syncIntervalMsgsPackage, 30000L, this);
      }  
    if (ChatManager.debug) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("sendedSyncMsgPackage(), sessionType:");
      stringBuilder.append(paramShort);
      stringBuilder.append(", sessionId:");
      stringBuilder.append(paramLong1);
      stringBuilder.append(", startId:");
      stringBuilder.append(paramLong2);
      stringBuilder.append(", endId:");
      stringBuilder.append(l1);
      stringBuilder.append(", loadListener:");
      stringBuilder.append(paramLoadListener);
      Log.v("Chat_Chat", stringBuilder.toString());
    } 
    this.connector.sendPackage((BasePackage)syncIntervalMsgsPackage);
  }
  
  private void sendSyncPackageFailed(SyncBasePackage paramSyncBasePackage) {
    synchronized (this.syncLoadListener) {
      Pair pair = (Pair)this.syncLoadListener.get(paramSyncBasePackage.localId);
      LoadListener loadListener = null;
      if (pair != null) {
        loadListener = (LoadListener)pair.first;
        List list = (List)pair.second;
      } else {
        pair = null;
      } 
      if (loadListener != null)
        this.syncLoadListener.remove(paramSyncBasePackage.localId); 
      if (pair != null) {
        insertMsgListToMemory((List<ChattingModel>)pair);
        if (loadListener != null) {
          loadListener.onLoadSuccess();
          return;
        } 
      } else if (loadListener != null) {
        loadListener.onLoadFailed("failed");
      } 
      return;
    } 
  }
  
  private void setMsgAndSessionReadFlag(ChattingModel paramChattingModel) {
    if (paramChattingModel.isFromSelf()) {
      if (paramChattingModel.msgStateCode != 2)
        return; 
      resetSessionNoReadMsgCnt(paramChattingModel.sessionType, paramChattingModel.sessionId, paramChattingModel.msgId);
      if (paramChattingModel._pushMsgPackage.isReaded()) {
        setMsgReadedFlag(paramChattingModel.sessionType, paramChattingModel.sessionId, paramChattingModel.msgId);
        return;
      } 
    } else {
      setMsgReadedFlag(paramChattingModel.sessionType, paramChattingModel.sessionId, paramChattingModel.msgId);
      if (paramChattingModel._pushMsgPackage.isReaded())
        resetSessionNoReadMsgCnt(paramChattingModel.sessionType, paramChattingModel.sessionId, paramChattingModel.msgId); 
    } 
  }
  
  private void setMsgReadedFlag(short paramShort, long paramLong1, long paramLong2) {
    boolean bool2;
    null = SessionHeader.getSessionKey(paramShort, paramLong1);
    synchronized (this.sessionList) {
      SessionModel sessionModel = this.sessionList.get(null);
      bool2 = false;
      boolean bool = false;
      if (sessionModel != null) {
        if (sessionModel.lastMsgId == paramLong2 && sessionModel.lastMsgStateCode == 2) {
          sessionModel.lastMsgStateCode = 3;
          bool1 = true;
        } else {
          bool1 = false;
        } 
        if (sessionModel._msgList != null) {
          Iterator<ChattingModel> iterator = sessionModel._msgList.iterator();
          while (true) {
            bool2 = bool;
            if (iterator.hasNext()) {
              ChattingModel chattingModel = iterator.next();
              if (chattingModel.msgId <= paramLong2 && chattingModel.msgStateCode == 2) {
                chattingModel.msgStateCode = 3;
                bool = true;
              } 
              continue;
            } 
            break;
          } 
        } 
        if (bool1)
          ChatManager.dbOperImpl.updateSession(sessionModel); 
      } else {
        if (ChatManager.debug)
          Log.v("Chat_Chat", "session is null, it may be deleted"); 
        bool1 = false;
        bool = false;
        ChatManager.dbOperImpl.readedAllMsg(paramShort, paramLong1, paramLong2);
      } 
    } 
    boolean bool3 = bool1;
    boolean bool1 = bool2;
    ChatManager.dbOperImpl.readedAllMsg(paramShort, paramLong1, paramLong2);
    /* monitor exit ClassFileLocalVariableReferenceExpression{type=ObjectType{java/lang/Object}, name=SYNTHETIC_LOCAL_VARIABLE_9} */
  }
  
  private void syncFinish() {
    this.dataSyncing = false;
    notifyIMStatusListener();
  }
  
  private void syncStart() {
    this.dataSyncing = true;
    notifyIMStatusListener();
  }
  
  private void updateSendingMsgId(SessionModel paramSessionModel, long paramLong1, long paramLong2) {
    if (paramSessionModel._msgList != null && paramSessionModel._msgList.size() > 0) {
      int j = 0;
      int i = paramSessionModel._msgList.size() - 1;
      while (i >= 0) {
        int k = j;
        if (((ChattingModel)paramSessionModel._msgList.get(i)).msgLocalId != 0L) {
          k = j;
          if (((ChattingModel)paramSessionModel._msgList.get(i)).msgLocalId > paramLong2) {
            k = j;
            if (((ChattingModel)paramSessionModel._msgList.get(i)).msgStateCode == 1) {
              ((ChattingModel)paramSessionModel._msgList.get(i)).msgId = paramLong1;
              k = j + 1;
            } 
          } 
        } 
        i--;
        j = k;
      } 
      if (j > 1)
        Collections.sort(paramSessionModel._msgList, new MsgComparator()); 
    } 
    ChatManager.dbOperImpl.updateSendingMsgId(paramLong1, paramSessionModel.sessionType, paramSessionModel.sessionId, paramLong2);
  }
  
  public void clearAllSecretLook() {
    synchronized (this.sessionList) {
      Iterator<SessionModel> iterator = this.sessionList.values().iterator();
      boolean bool = false;
      while (true) {
        if (iterator.hasNext()) {
          SessionModel sessionModel = iterator.next();
          if (sessionModel.secretLookStatus == 1) {
            sessionModel.secretLookStatus = 0;
            sessionModel._secretMsgListing = false;
            if (ChatManager.dbOperImpl != null)
              ChatManager.dbOperImpl.updateSession(sessionModel); 
            bool = true;
          } 
          continue;
        } 
        if (bool)
          notifySessionListChanged(); 
        return;
      } 
    } 
  }
  
  public void deleteAllChattings() {
    if (ChatManager.debug)
      Log.v("Chat_Chat", "deleteAllChattings()"); 
    synchronized (this.sessionList) {
      ChatManager.dbOperImpl.deleteChattingForAll();
      for (SessionModel sessionModel : this.sessionList.values()) {
        if (sessionModel._msgList != null)
          sessionModel._msgList.clear(); 
        SessionModel.removeSessionLastMsg(sessionModel);
      } 
      ChatManager.dbOperImpl.updateAllLastMsgContentNull();
      this.connector.sendPackage((BasePackage)new DeleteAllPackage(ChatHelper.getLocalId(), true));
      if (ChatManager.clientType == ChatManager.ClientType.CHINA && GRPC.getInstance().getOrderSender() != null)
        GRPC.getInstance().getOrderSender().deleteAllSessions(true); 
      notifyAllSessionRemoved();
      return;
    } 
  }
  
  public void deleteAllSessions(boolean paramBoolean) {
    // Byte code:
    //   0: getstatic com/blued/android/chat/ChatManager.debug : Z
    //   3: ifeq -> 15
    //   6: ldc 'Chat_Chat'
    //   8: ldc_w 'deleteAllSessions()'
    //   11: invokestatic v : (Ljava/lang/String;Ljava/lang/String;)I
    //   14: pop
    //   15: aload_0
    //   16: getfield sessionList : Ljava/util/Map;
    //   19: astore_2
    //   20: aload_2
    //   21: monitorenter
    //   22: iload_1
    //   23: ifeq -> 37
    //   26: getstatic com/blued/android/chat/ChatManager.dbOperImpl : Lcom/blued/android/chat/db/DBOper;
    //   29: invokeinterface deleteSessionAndChattingForAll : ()V
    //   34: goto -> 45
    //   37: getstatic com/blued/android/chat/ChatManager.dbOperImpl : Lcom/blued/android/chat/db/DBOper;
    //   40: invokeinterface deleteSessionForAll : ()V
    //   45: getstatic com/blued/android/chat/ChatManager.dbOperImpl : Lcom/blued/android/chat/db/DBOper;
    //   48: invokeinterface deleteAllSessionSetting : ()V
    //   53: aload_0
    //   54: getfield sessionList : Ljava/util/Map;
    //   57: invokeinterface clear : ()V
    //   62: aload_0
    //   63: getfield snapSessionList : Ljava/util/Map;
    //   66: astore_3
    //   67: aload_3
    //   68: monitorenter
    //   69: aload_0
    //   70: getfield snapSessionList : Ljava/util/Map;
    //   73: invokeinterface clear : ()V
    //   78: aload_3
    //   79: monitorexit
    //   80: aload_2
    //   81: monitorexit
    //   82: iload_1
    //   83: ifeq -> 90
    //   86: aload_0
    //   87: invokespecial notifyAllMsgListClear : ()V
    //   90: aload_0
    //   91: invokespecial notifyAllSessionRemoved : ()V
    //   94: aload_0
    //   95: getfield connector : Lcom/blued/android/chat/core/worker/Connector;
    //   98: new com/blued/android/chat/core/pack/DeleteAllPackage
    //   101: dup
    //   102: invokestatic getLocalId : ()J
    //   105: iload_1
    //   106: invokespecial <init> : (JZ)V
    //   109: invokevirtual sendPackage : (Lcom/blued/android/chat/core/pack/BasePackage;)V
    //   112: getstatic com/blued/android/chat/ChatManager.clientType : Lcom/blued/android/chat/ChatManager$ClientType;
    //   115: getstatic com/blued/android/chat/ChatManager$ClientType.CHINA : Lcom/blued/android/chat/ChatManager$ClientType;
    //   118: if_acmpne -> 142
    //   121: invokestatic getInstance : ()Lcom/blued/android/chat/compatible/GRPC;
    //   124: invokevirtual getOrderSender : ()Lcom/blued/android/chat/compatible/IOrderSender;
    //   127: ifnull -> 142
    //   130: invokestatic getInstance : ()Lcom/blued/android/chat/compatible/GRPC;
    //   133: invokevirtual getOrderSender : ()Lcom/blued/android/chat/compatible/IOrderSender;
    //   136: iload_1
    //   137: invokeinterface deleteAllSessions : (Z)V
    //   142: return
    //   143: astore #4
    //   145: aload_3
    //   146: monitorexit
    //   147: aload #4
    //   149: athrow
    //   150: astore_3
    //   151: aload_2
    //   152: monitorexit
    //   153: aload_3
    //   154: athrow
    // Exception table:
    //   from	to	target	type
    //   26	34	150	finally
    //   37	45	150	finally
    //   45	69	150	finally
    //   69	80	143	finally
    //   80	82	150	finally
    //   145	147	143	finally
    //   147	150	150	finally
    //   151	153	150	finally
  }
  
  public void deleteChatting(int paramInt, long paramLong) {
    if (ChatManager.debug) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("deleteChatting(), sessionType:");
      stringBuilder.append(paramInt);
      stringBuilder.append(", sessionId:");
      stringBuilder.append(paramLong);
      Log.v("Chat_Chat", stringBuilder.toString());
    } 
    null = SessionHeader.getSessionKey(paramInt, paramLong);
    boolean bool = false;
    synchronized (this.sessionList) {
      SessionModel sessionModel = this.sessionList.get(null);
      if (sessionModel != null) {
        if (sessionModel._msgList != null)
          sessionModel._msgList.clear(); 
        removeSessionUnreadMsg(sessionModel);
        removeSessionAtMsgId(sessionModel);
        ChatManager.dbOperImpl.deleteChattingForOne(paramInt, paramLong);
        bool = true;
      } 
      notifyMsgListChanged(paramInt, paramLong);
      if (bool)
        notifySessionChanged(sessionModel); 
      if (ChatManager.clientType == ChatManager.ClientType.CHINA && sessionModel.sessionType == 3 && GRPC.getInstance().getOrderSender() != null) {
        GRPC.getInstance().getOrderSender().deleteOneSession(sessionModel.sessionType, sessionModel.sessionId, true);
        return;
      } 
      this.connector.sendPackage((BasePackage)new DeleteSessionPackage(sessionModel.sessionType, sessionModel.sessionId, sessionModel.sessionId, true));
      return;
    } 
  }
  
  public void deleteLocalChatting(int paramInt, long paramLong) {
    if (ChatManager.debug) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("deleteLocalChatting(), sessionType:");
      stringBuilder.append(paramInt);
      stringBuilder.append(", sessionId:");
      stringBuilder.append(paramLong);
      Log.v("Chat_Chat", stringBuilder.toString());
    } 
    null = SessionHeader.getSessionKey(paramInt, paramLong);
    synchronized (this.sessionList) {
      SessionModel sessionModel = this.sessionList.get(null);
      if (sessionModel == null)
        return; 
      if (sessionModel._msgList != null)
        sessionModel._msgList.clear(); 
      removeSessionUnreadMsg(sessionModel);
      removeSessionAtMsgId(sessionModel);
      ChatManager.dbOperImpl.deleteChattingForOne(paramInt, paramLong);
      notifyMsgListChanged(paramInt, paramLong);
      notifySessionChanged(sessionModel);
      return;
    } 
  }
  
  public void deleteOneMessage(short paramShort, long paramLong1, long paramLong2, long paramLong3) {
    // Byte code:
    //   0: getstatic com/blued/android/chat/ChatManager.debug : Z
    //   3: ifeq -> 95
    //   6: new java/lang/StringBuilder
    //   9: dup
    //   10: invokespecial <init> : ()V
    //   13: astore #10
    //   15: aload #10
    //   17: ldc_w 'deleteOneMessage(), sessionType:'
    //   20: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: pop
    //   24: aload #10
    //   26: iload_1
    //   27: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   30: pop
    //   31: aload #10
    //   33: ldc_w ', sessionId:'
    //   36: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   39: pop
    //   40: aload #10
    //   42: lload_2
    //   43: invokevirtual append : (J)Ljava/lang/StringBuilder;
    //   46: pop
    //   47: aload #10
    //   49: ldc_w ', messageId:'
    //   52: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   55: pop
    //   56: aload #10
    //   58: lload #4
    //   60: invokevirtual append : (J)Ljava/lang/StringBuilder;
    //   63: pop
    //   64: aload #10
    //   66: ldc_w ', localId:'
    //   69: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   72: pop
    //   73: aload #10
    //   75: lload #6
    //   77: invokevirtual append : (J)Ljava/lang/StringBuilder;
    //   80: pop
    //   81: ldc 'Chat_Chat'
    //   83: aload #10
    //   85: invokevirtual toString : ()Ljava/lang/String;
    //   88: invokestatic v : (Ljava/lang/String;Ljava/lang/String;)I
    //   91: pop
    //   92: goto -> 95
    //   95: iload_1
    //   96: lload_2
    //   97: invokestatic getSessionKey : (IJ)Ljava/lang/String;
    //   100: astore #10
    //   102: aload_0
    //   103: getfield sessionList : Ljava/util/Map;
    //   106: astore #11
    //   108: aload #11
    //   110: monitorenter
    //   111: aload_0
    //   112: getfield sessionList : Ljava/util/Map;
    //   115: aload #10
    //   117: invokeinterface get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   122: checkcast com/blued/android/chat/model/SessionModel
    //   125: astore #12
    //   127: aload #12
    //   129: ifnull -> 467
    //   132: aload #12
    //   134: getfield _msgList : Ljava/util/List;
    //   137: ifnull -> 436
    //   140: aload #12
    //   142: getfield _msgList : Ljava/util/List;
    //   145: invokeinterface iterator : ()Ljava/util/Iterator;
    //   150: astore #10
    //   152: aload #10
    //   154: invokeinterface hasNext : ()Z
    //   159: ifeq -> 436
    //   162: aload #10
    //   164: invokeinterface next : ()Ljava/lang/Object;
    //   169: checkcast com/blued/android/chat/model/ChattingModel
    //   172: astore #13
    //   174: aload #13
    //   176: getfield msgId : J
    //   179: lload #4
    //   181: lcmp
    //   182: ifne -> 152
    //   185: aload #13
    //   187: getfield msgLocalId : J
    //   190: lload #6
    //   192: lcmp
    //   193: ifne -> 152
    //   196: aload #13
    //   198: iconst_1
    //   199: putfield msgIsDelete : Z
    //   202: aload #13
    //   204: ldc_w ''
    //   207: putfield msgContent : Ljava/lang/String;
    //   210: getstatic com/blued/android/chat/ChatManager.dbOperImpl : Lcom/blued/android/chat/db/DBOper;
    //   213: aload #13
    //   215: invokeinterface updateChattingModel : (Lcom/blued/android/chat/model/ChattingModel;)V
    //   220: iconst_1
    //   221: istore #8
    //   223: goto -> 226
    //   226: aload #12
    //   228: getfield lastMsgId : J
    //   231: lload #4
    //   233: lcmp
    //   234: ifne -> 457
    //   237: aload #12
    //   239: getfield lastMsgLocalId : J
    //   242: lload #6
    //   244: lcmp
    //   245: ifne -> 457
    //   248: aload #12
    //   250: getfield _msgList : Ljava/util/List;
    //   253: ifnull -> 451
    //   256: aload #12
    //   258: getfield _msgList : Ljava/util/List;
    //   261: invokeinterface size : ()I
    //   266: iconst_1
    //   267: isub
    //   268: istore #9
    //   270: iload #9
    //   272: iflt -> 451
    //   275: aload #12
    //   277: getfield _msgList : Ljava/util/List;
    //   280: iload #9
    //   282: invokeinterface get : (I)Ljava/lang/Object;
    //   287: checkcast com/blued/android/chat/model/ChattingModel
    //   290: astore #10
    //   292: aload #10
    //   294: getfield msgIsDelete : Z
    //   297: ifne -> 442
    //   300: aload #10
    //   302: invokestatic isIgnoreNotifyMsgType : (Lcom/blued/android/chat/model/ChattingModel;)Z
    //   305: ifne -> 442
    //   308: aload #10
    //   310: getfield msgType : S
    //   313: invokestatic isLocalViewMsg : (S)Z
    //   316: ifne -> 442
    //   319: goto -> 322
    //   322: aload #10
    //   324: ifnull -> 337
    //   327: aload #12
    //   329: aload #10
    //   331: invokestatic setSessionForLastMsg : (Lcom/blued/android/chat/model/SessionModel;Lcom/blued/android/chat/model/ChattingModel;)V
    //   334: goto -> 345
    //   337: aload #12
    //   339: ldc_w ''
    //   342: putfield lastMsgContent : Ljava/lang/String;
    //   345: getstatic com/blued/android/chat/ChatManager.dbOperImpl : Lcom/blued/android/chat/db/DBOper;
    //   348: aload #12
    //   350: invokeinterface updateSession : (Lcom/blued/android/chat/model/SessionModel;)V
    //   355: iload #8
    //   357: istore #9
    //   359: iconst_1
    //   360: istore #8
    //   362: goto -> 365
    //   365: aload #11
    //   367: monitorexit
    //   368: lload #6
    //   370: lconst_0
    //   371: lcmp
    //   372: ifne -> 405
    //   375: aload_0
    //   376: getfield connector : Lcom/blued/android/chat/core/worker/Connector;
    //   379: astore #10
    //   381: aload #10
    //   383: ifnull -> 405
    //   386: aload #10
    //   388: new com/blued/android/chat/core/pack/DeleteMessagePackage
    //   391: dup
    //   392: iload_1
    //   393: lload_2
    //   394: lload #4
    //   396: invokestatic getLocalId : ()J
    //   399: invokespecial <init> : (SJJJ)V
    //   402: invokevirtual sendPackage : (Lcom/blued/android/chat/core/pack/BasePackage;)V
    //   405: iload #9
    //   407: ifeq -> 416
    //   410: aload_0
    //   411: iload_1
    //   412: lload_2
    //   413: invokespecial notifyMsgListChanged : (IJ)V
    //   416: iload #8
    //   418: ifeq -> 427
    //   421: aload_0
    //   422: aload #12
    //   424: invokespecial notifySessionChanged : (Lcom/blued/android/chat/model/SessionModel;)V
    //   427: return
    //   428: astore #10
    //   430: aload #11
    //   432: monitorexit
    //   433: aload #10
    //   435: athrow
    //   436: iconst_0
    //   437: istore #8
    //   439: goto -> 226
    //   442: iload #9
    //   444: iconst_1
    //   445: isub
    //   446: istore #9
    //   448: goto -> 270
    //   451: aconst_null
    //   452: astore #10
    //   454: goto -> 322
    //   457: iload #8
    //   459: istore #9
    //   461: iconst_0
    //   462: istore #8
    //   464: goto -> 365
    //   467: iconst_0
    //   468: istore #8
    //   470: iconst_0
    //   471: istore #9
    //   473: goto -> 365
    // Exception table:
    //   from	to	target	type
    //   111	127	428	finally
    //   132	152	428	finally
    //   152	220	428	finally
    //   226	270	428	finally
    //   275	319	428	finally
    //   327	334	428	finally
    //   337	345	428	finally
    //   345	355	428	finally
    //   365	368	428	finally
    //   430	433	428	finally
  }
  
  public void deleteSessions(List<Pair<Short, Long>> paramList, boolean paramBoolean) {
    deleteSessions(paramList, paramBoolean, true, false);
  }
  
  public void deleteSessionsWithSetting(List<Pair<Short, Long>> paramList, boolean paramBoolean) {
    deleteSessions(paramList, paramBoolean, true, true);
  }
  
  public void destroyMsg(short paramShort, long paramLong, ChattingModel paramChattingModel) {
    if (ChatManager.debug) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("destroyMsg(), msgData:");
      stringBuilder.append(paramChattingModel);
      Log.v("Chat_Chat", stringBuilder.toString());
    } 
    paramChattingModel.msgContent = "";
    updateMsgData(paramChattingModel);
    if (paramChattingModel.fromId != ChatManager.userInfo.uid)
      sendDestroyMsgReqToServer(paramShort, paramLong, paramChattingModel.msgId); 
  }
  
  public ChattingModel findMessage(short paramShort, long paramLong1, long paramLong2, long paramLong3, LoadMsgListener paramLoadMsgListener) {
    // Byte code:
    //   0: iload_1
    //   1: lload_2
    //   2: invokestatic getSessionKey : (IJ)Ljava/lang/String;
    //   5: astore #9
    //   7: aload_0
    //   8: getfield sessionList : Ljava/util/Map;
    //   11: astore #10
    //   13: aload #10
    //   15: monitorenter
    //   16: aload_0
    //   17: getfield sessionList : Ljava/util/Map;
    //   20: aload #9
    //   22: invokeinterface get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   27: checkcast com/blued/android/chat/model/SessionModel
    //   30: astore #9
    //   32: aload #9
    //   34: ifnull -> 179
    //   37: aload #9
    //   39: getfield _msgList : Ljava/util/List;
    //   42: ifnull -> 179
    //   45: aload #9
    //   47: getfield _msgList : Ljava/util/List;
    //   50: invokeinterface iterator : ()Ljava/util/Iterator;
    //   55: astore #11
    //   57: aload #11
    //   59: invokeinterface hasNext : ()Z
    //   64: ifeq -> 179
    //   67: aload #11
    //   69: invokeinterface next : ()Ljava/lang/Object;
    //   74: checkcast com/blued/android/chat/model/ChattingModel
    //   77: astore #9
    //   79: aload #9
    //   81: getfield msgId : J
    //   84: lload #4
    //   86: lcmp
    //   87: ifne -> 57
    //   90: aload #9
    //   92: getfield msgLocalId : J
    //   95: lload #6
    //   97: lcmp
    //   98: ifne -> 57
    //   101: goto -> 104
    //   104: aload #10
    //   106: monitorexit
    //   107: aload #9
    //   109: astore #10
    //   111: aload #9
    //   113: ifnonnull -> 132
    //   116: getstatic com/blued/android/chat/ChatManager.dbOperImpl : Lcom/blued/android/chat/db/DBOper;
    //   119: iload_1
    //   120: lload_2
    //   121: lload #4
    //   123: lload #6
    //   125: invokeinterface findMsgData : (SJJJ)Lcom/blued/android/chat/model/ChattingModel;
    //   130: astore #10
    //   132: aload #8
    //   134: ifnull -> 168
    //   137: aload #10
    //   139: ifnull -> 168
    //   142: new java/util/ArrayList
    //   145: dup
    //   146: invokespecial <init> : ()V
    //   149: astore #9
    //   151: aload #9
    //   153: aload #10
    //   155: invokevirtual add : (Ljava/lang/Object;)Z
    //   158: pop
    //   159: aload #8
    //   161: aload #9
    //   163: invokeinterface onLoadFinish : (Ljava/util/List;)V
    //   168: aload #10
    //   170: areturn
    //   171: astore #8
    //   173: aload #10
    //   175: monitorexit
    //   176: aload #8
    //   178: athrow
    //   179: aconst_null
    //   180: astore #9
    //   182: goto -> 104
    // Exception table:
    //   from	to	target	type
    //   16	32	171	finally
    //   37	57	171	finally
    //   57	101	171	finally
    //   104	107	171	finally
    //   173	176	171	finally
  }
  
  public void getSessionModel(short paramShort, long paramLong, FetchDataListener<SessionModel> paramFetchDataListener) {
    if (ChatManager.debug)
      Log.v("Chat_Chat", "getSessionModel()"); 
    String str = SessionHeader.getSessionKey(paramShort, paramLong);
    synchronized (this.sessionList) {
      SessionModel sessionModel = this.sessionList.get(str);
      if (paramFetchDataListener != null)
        paramFetchDataListener.onFetchData(sessionModel); 
      return;
    } 
  }
  
  public void getSessionModelList(FetchDataListener<List<SessionModel>> paramFetchDataListener) {
    if (ChatManager.debug)
      Log.v("Chat_Chat", "getSessionModelList()"); 
    ArrayList arrayList = new ArrayList();
    synchronized (this.sessionList) {
      arrayList.addAll(this.sessionList.values());
      if (paramFetchDataListener != null)
        paramFetchDataListener.onFetchData(arrayList); 
      return;
    } 
  }
  
  public void getSessionModelMap(FetchDataListener<Map<String, SessionModel>> paramFetchDataListener) {
    if (ChatManager.debug)
      Log.v("Chat_Chat", "getSessionModelMap()"); 
    ArrayMap<String, SessionModel> arrayMap = new ArrayMap();
    synchronized (this.sessionList) {
      arrayMap.putAll(this.sessionList);
      if (paramFetchDataListener != null)
        paramFetchDataListener.onFetchData(arrayMap); 
      return;
    } 
  }
  
  public void getSessionSettingModel(short paramShort, long paramLong, FetchDataListener<SessionSettingBaseModel> paramFetchDataListener) {
    if (ChatManager.debug)
      Log.v("Chat_Chat", "getSessionSettingModel()"); 
    String str = SessionHeader.getSessionKey(paramShort, paramLong);
    synchronized (this.sessionList) {
      SessionSettingBaseModel sessionSettingBaseModel;
      SessionModel sessionModel = this.sessionList.get(str);
      if (sessionModel != null) {
        sessionSettingBaseModel = sessionModel.sessionSettingModel;
      } else {
        sessionSettingBaseModel = ChatManager.dbOperImpl.getSessionSetting(paramShort, paramLong);
      } 
      if (paramFetchDataListener != null)
        paramFetchDataListener.onFetchData(sessionSettingBaseModel); 
      return;
    } 
  }
  
  public SessionModel getSnapSessionModel(short paramShort, long paramLong) {
    if (ChatManager.debug)
      Log.v("Chat_Chat", "getSnapSessionModel()"); 
    null = SessionHeader.getSessionKey(paramShort, paramLong);
    synchronized (this.snapSessionList) {
      return this.snapSessionList.get(null);
    } 
  }
  
  public String getWorkerName() {
    return "Chat";
  }
  
  public void ignoredNoReadNumAll() {
    if (ChatManager.debug)
      Log.v("Chat_Chat", "ignoredNoReadNumAll()"); 
    null = new HashSet();
    synchronized (this.sessionList) {
      for (SessionModel sessionModel : this.sessionList.values()) {
        if (removeSessionUnreadMsg(sessionModel)) {
          ChatManager.dbOperImpl.updateSession(sessionModel);
          null.add(sessionModel);
        } 
      } 
      if (null.size() > 0)
        notifySessionChanged(null); 
      return;
    } 
  }
  
  public void ignoredNoReadNumForSessions(List<Pair<Short, Long>> paramList) {
    if (ChatManager.debug)
      Log.v("Chat_Chat", "ignoredNoReadNumAll()"); 
    if (paramList == null)
      return; 
    HashSet<SessionModel> hashSet = new HashSet();
    synchronized (this.sessionList) {
      for (Pair<Short, Long> pair : paramList) {
        String str = SessionHeader.getSessionKey(((Short)pair.first).shortValue(), ((Long)pair.second).longValue());
        SessionModel sessionModel = this.sessionList.get(str);
        if (sessionModel != null && removeSessionUnreadMsg(sessionModel)) {
          ChatManager.dbOperImpl.updateSession(sessionModel);
          hashSet.add(sessionModel);
        } 
      } 
      if (hashSet.size() > 0)
        notifySessionChanged(hashSet); 
      return;
    } 
  }
  
  protected SessionModel insertEmptySession(short paramShort, long paramLong) {
    if (ChatManager.debug) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("insertEmptySession(), sessionType:");
      stringBuilder.append(paramShort);
      stringBuilder.append(", sessionId:");
      stringBuilder.append(paramLong);
      Log.d("Chat_Chat", stringBuilder.toString());
    } 
    boolean bool = false;
    String str = SessionHeader.getSessionKey(paramShort, paramLong);
    synchronized (this.sessionList) {
      SessionModel sessionModel2 = this.sessionList.get(str);
      SessionModel sessionModel1 = sessionModel2;
      if (sessionModel2 == null) {
        Map<String, SessionModel> map;
        SessionModel sessionModel;
        sessionModel2 = ChatHelper.createEmptySessionModel(paramShort, paramLong);
        boolean bool1 = true;
        this.sessionList.put(str, sessionModel2);
        synchronized (this.snapSessionList) {
          this.snapSessionList.put(str, sessionModel2);
          bool = bool1;
          sessionModel = sessionModel2;
          if (ChatManager.debug) {
            Log.v("Chat_Chat", "session don't exit, create it");
            bool = bool1;
            sessionModel = sessionModel2;
          } 
        } 
      } 
      if (bool)
        notifySessionChanged(sessionModel1); 
      return sessionModel1;
    } 
  }
  
  public int insertMsgListFromBackup(List<ChattingModel> paramList) {
    int i = -1;
    if (paramList != null) {
      if (paramList.size() == 0)
        return -1; 
      synchronized (this.sessionList) {
        if (ChatManager.dbOperImpl != null)
          i = ChatManager.dbOperImpl.insertMsgListFromBackup(paramList); 
        return i;
      } 
    } 
    return -1;
  }
  
  public int insertSessionList(List<SessionModel> paramList) {
    int i = -1;
    if (paramList != null) {
      if (paramList.size() == 0)
        return -1; 
      synchronized (this.sessionList) {
        if (ChatManager.dbOperImpl != null)
          i = ChatManager.dbOperImpl.insertSessionList(paramList); 
        for (SessionModel sessionModel : paramList) {
          this.sessionList.put(SessionHeader.getSessionKey(sessionModel.sessionType, sessionModel.sessionId), sessionModel);
          synchronized (this.snapSessionList) {
            this.snapSessionList.put(SessionHeader.getSessionKey(sessionModel.sessionType, sessionModel.sessionId), sessionModel);
          } 
        } 
        notifySessionListChanged();
        return i;
      } 
    } 
    return -1;
  }
  
  public void loadDownSessionMsgList(short paramShort, long paramLong1, long paramLong2, long paramLong3, int paramInt, LoadListener paramLoadListener) {
    // Byte code:
    //   0: getstatic com/blued/android/chat/ChatManager.debug : Z
    //   3: ifeq -> 95
    //   6: new java/lang/StringBuilder
    //   9: dup
    //   10: invokespecial <init> : ()V
    //   13: astore #10
    //   15: aload #10
    //   17: ldc_w 'loadSessionMsgList(), sessionType:'
    //   20: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: pop
    //   24: aload #10
    //   26: iload_1
    //   27: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   30: pop
    //   31: aload #10
    //   33: ldc_w ', sessionId:'
    //   36: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   39: pop
    //   40: aload #10
    //   42: lload_2
    //   43: invokevirtual append : (J)Ljava/lang/StringBuilder;
    //   46: pop
    //   47: aload #10
    //   49: ldc_w ', count:'
    //   52: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   55: pop
    //   56: aload #10
    //   58: iload #8
    //   60: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   63: pop
    //   64: aload #10
    //   66: ldc_w ', listener:'
    //   69: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   72: pop
    //   73: aload #10
    //   75: aload #9
    //   77: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   80: pop
    //   81: ldc 'Chat_Chat'
    //   83: aload #10
    //   85: invokevirtual toString : ()Ljava/lang/String;
    //   88: invokestatic v : (Ljava/lang/String;Ljava/lang/String;)I
    //   91: pop
    //   92: goto -> 95
    //   95: iload_1
    //   96: lload_2
    //   97: invokestatic getSessionKey : (IJ)Ljava/lang/String;
    //   100: astore #13
    //   102: aconst_null
    //   103: astore #12
    //   105: aload_0
    //   106: getfield sessionList : Ljava/util/Map;
    //   109: astore #11
    //   111: aload #11
    //   113: monitorenter
    //   114: aload_0
    //   115: getfield sessionList : Ljava/util/Map;
    //   118: aload #13
    //   120: invokeinterface get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   125: checkcast com/blued/android/chat/model/SessionModel
    //   128: astore #14
    //   130: aload #14
    //   132: ifnull -> 240
    //   135: lload #4
    //   137: ldc2_w -1
    //   140: lcmp
    //   141: ifne -> 153
    //   144: lload #6
    //   146: ldc2_w -1
    //   149: lcmp
    //   150: ifeq -> 240
    //   153: aload #14
    //   155: iconst_1
    //   156: putfield isFromSearch : Z
    //   159: getstatic com/blued/android/chat/ChatManager.dbOperImpl : Lcom/blued/android/chat/db/DBOper;
    //   162: astore #12
    //   164: aload #11
    //   166: astore #10
    //   168: aload #12
    //   170: iload_1
    //   171: lload_2
    //   172: lload #4
    //   174: lload #6
    //   176: invokeinterface findMsgData : (SJJJ)Lcom/blued/android/chat/model/ChattingModel;
    //   181: astore #12
    //   183: goto -> 186
    //   186: aload #11
    //   188: astore #10
    //   190: aload #11
    //   192: monitorexit
    //   193: aload_0
    //   194: aload #14
    //   196: aload #12
    //   198: aload #13
    //   200: iload_1
    //   201: lload_2
    //   202: iload #8
    //   204: iconst_0
    //   205: aload #9
    //   207: invokespecial loadUpOrDownSessionMsgList : (Lcom/blued/android/chat/model/SessionModel;Lcom/blued/android/chat/model/ChattingModel;Ljava/lang/String;SJIZLcom/blued/android/chat/listener/LoadListener;)V
    //   210: return
    //   211: astore #10
    //   213: aload #11
    //   215: astore #9
    //   217: aload #10
    //   219: astore #11
    //   221: aload #9
    //   223: astore #10
    //   225: aload #9
    //   227: monitorexit
    //   228: aload #11
    //   230: athrow
    //   231: astore #11
    //   233: aload #10
    //   235: astore #9
    //   237: goto -> 221
    //   240: goto -> 186
    // Exception table:
    //   from	to	target	type
    //   114	130	211	finally
    //   153	164	211	finally
    //   168	183	231	finally
    //   190	193	231	finally
    //   225	228	231	finally
  }
  
  public void loadNewMsg(short paramShort, long paramLong, int paramInt, LoadMsgListener paramLoadMsgListener) {
    if (ChatManager.debug) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("loadNewMsg(), sessionType:");
      stringBuilder.append(paramShort);
      stringBuilder.append(", sessionId:");
      stringBuilder.append(paramLong);
      stringBuilder.append(", count:");
      stringBuilder.append(paramInt);
      stringBuilder.append(", listener:");
      stringBuilder.append(paramLoadMsgListener);
      Log.v("Chat_Chat", stringBuilder.toString());
    } 
    List<ChattingModel> list = ChatManager.dbOperImpl.getMsgList(ChatManager.userInfo.uid, paramShort, paramLong, 0L, 0L, 0L, paramInt, true);
    if (ChatManager.debug) {
      Integer integer;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("get msg list from db size:");
      if (list == null) {
        String str = "null";
      } else {
        integer = Integer.valueOf(list.size());
      } 
      stringBuilder.append(integer);
      Log.v("Chat_Chat", stringBuilder.toString());
    } 
    if (list != null && list.size() > 0)
      MsgComparator.sortAndDistinct(list); 
    if (paramLoadMsgListener != null)
      paramLoadMsgListener.onLoadFinish(list); 
  }
  
  public void loadSessionMsgList(short paramShort, long paramLong, int paramInt, LoadListener paramLoadListener) {
    if (ChatManager.debug) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("loadSessionMsgList(), sessionType:");
      stringBuilder.append(paramShort);
      stringBuilder.append(", sessionId:");
      stringBuilder.append(paramLong);
      stringBuilder.append(", count:");
      stringBuilder.append(paramInt);
      stringBuilder.append(", listener:");
      stringBuilder.append(paramLoadListener);
      Log.v("Chat_Chat", stringBuilder.toString());
    } 
    String str = SessionHeader.getSessionKey(paramShort, paramLong);
    ChattingModel chattingModel = null;
    synchronized (this.sessionList) {
      SessionModel sessionModel = this.sessionList.get(str);
      ChattingModel chattingModel1 = chattingModel;
      if (sessionModel != null) {
        chattingModel1 = chattingModel;
        if (sessionModel._msgList != null) {
          chattingModel1 = chattingModel;
          if (sessionModel._msgList.size() > 0)
            chattingModel1 = sessionModel._msgList.get(0); 
        } 
      } 
      loadUpOrDownSessionMsgList(sessionModel, chattingModel1, str, paramShort, paramLong, paramInt, true, paramLoadListener);
      return;
    } 
  }
  
  public void notifySendStateForGRPC(int paramInt, short paramShort, long paramLong1, long paramLong2, long paramLong3, long paramLong4) {
    SendMsgPackage sendMsgPackage = new SendMsgPackage(paramShort, paramLong1, paramLong3, 0L, (short)0, null, null, null, 0L, null);
    if (paramInt == 0) {
      SendAckPackage sendAckPackage = new SendAckPackage();
      sendAckPackage.msgId = paramLong2;
      sendAckPackage.msgTime = paramLong4;
      sendAckPackage.msgPreviousId = paramLong2 - 1L;
      sendAckPackage.result = 0;
      notifySendPackageStateChanged(sendMsgPackage, paramInt, sendAckPackage);
      return;
    } 
    notifySendPackageStateChanged(sendMsgPackage, paramInt);
  }
  
  public void onConnected() {
    if (ChatManager.debug)
      Log.v("Chat_Chat", "onConnected------->"); 
    if (this.sessionListInited)
      retrySyncMsg(false); 
    notifyIMStatusListener();
  }
  
  public void onConnecting() {
    notifyIMStatusListener();
  }
  
  public void onDisconnected() {
    notifyIMStatusListener();
  }
  
  public void onPackageTimeout(long paramLong, Object paramObject) {
    if (ChatManager.debug) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("onPackageTimeout(), keyId:");
      stringBuilder.append(paramLong);
      stringBuilder.append(", package:");
      stringBuilder.append(paramObject);
      Log.v("Chat_Chat", stringBuilder.toString());
    } 
    Connector connector = this.connector;
    BasePackage basePackage = (BasePackage)paramObject;
    connector.cancelPackage(basePackage);
    if (ChatManager.debug && (ChatManager.getInstance()).debugTipsListener != null) {
      DebugTipsListener debugTipsListener = (ChatManager.getInstance()).debugTipsListener;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("超时未收到ack, pack:");
      stringBuilder.append(paramObject);
      debugTipsListener.onTips(stringBuilder.toString());
    } 
    if (paramObject instanceof BasePackage) {
      String str = BasePackage.typeToString(basePackage);
      paramLong = SystemClock.uptimeMillis();
      long l = basePackage.sendTime;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("package timeout, connect state:");
      stringBuilder.append(this.connector.getConnectStatus());
      DataUtils.imMessageFailed(str, paramLong - l, stringBuilder.toString());
    } 
    if (paramObject instanceof SendMsgPackage) {
      sendMsgPackageFailed((SendMsgPackage)paramObject, -2);
      return;
    } 
    if (paramObject instanceof SyncIntervalMsgsPackage) {
      sendSyncPackageFailed((SyncBasePackage)paramObject);
      return;
    } 
    if (paramObject instanceof ReqSessionPackage) {
      sendReqSessionFailed((ReqSessionPackage)paramObject);
      return;
    } 
    if (paramObject instanceof ReqCreateVideoChatPackage) {
      VideoChat videoChat = this.videoChat;
      if (videoChat != null)
        videoChat.callPackageFailed((ReqCreateVideoChatPackage)paramObject); 
    } 
  }
  
  public void onProcessToSave(ChattingModel paramChattingModel) {
    if (paramChattingModel.msgLocalId != 0L) {
      ChattingModel chattingModel = ChatManager.dbOperImpl.getSendingMsgData(paramChattingModel.sessionType, paramChattingModel.sessionId, paramChattingModel.msgLocalId);
      if (chattingModel != null && paramChattingModel.msgId != chattingModel.msgId)
        paramChattingModel.msgId = chattingModel.msgId; 
    } 
    updateMsgData(paramChattingModel);
  }
  
  public void onProcessToSend(ChattingModel paramChattingModel) {
    sendMsgToServer(paramChattingModel);
  }
  
  public void onReceive(BasePackage paramBasePackage) {
    PushBasePackage pushBasePackage;
    if (ChatManager.debug) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("onReceive(), packType:");
      stringBuilder.append(paramBasePackage.type);
      Log.v("Chat_Chat", stringBuilder.toString());
    } 
    if (ChatManager.debug && (ChatManager.getInstance()).debugTipsListener != null) {
      DebugTipsListener debugTipsListener = (ChatManager.getInstance()).debugTipsListener;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("收到服务器包, pack:");
      stringBuilder.append(paramBasePackage);
      debugTipsListener.onTips(stringBuilder.toString());
    } 
    if (!isWorking()) {
      if (ChatManager.debug)
        Log.v("Chat_Chat", "stopped, don't deal any pack"); 
      return;
    } 
    short s = paramBasePackage.type;
    if (s != 3) {
      SyncAckPackage syncAckPackage;
      if (s != 4) {
        ReqAckPackage reqAckPackage;
        if (s != 5) {
          if (s != 6) {
            if (s != 7) {
              if (ChatManager.debug) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("receive unknown package, pack:");
                stringBuilder.append(paramBasePackage);
                Log.e("Chat_Chat", stringBuilder.toString());
                return;
              } 
            } else {
              if (paramBasePackage instanceof ReqAckPackage) {
                reqAckPackage = (ReqAckPackage)paramBasePackage;
                Object object = TimeoutUtils.cancelTimeoutPackage(reqAckPackage.localId);
                if (object != null && object instanceof ReqBasePackage && reqAckPackage.reqType == -1)
                  reqAckPackage.reqType = ((ReqBasePackage)object).reqType; 
                recvReqAckPackage(reqAckPackage);
                return;
              } 
              if (ChatManager.debug) {
                Log.e("Chat_Chat", "can't handle this req pack");
                return;
              } 
            } 
          } else {
            if (((BasePackage)reqAckPackage).ack && reqAckPackage instanceof DeleteAckPackage) {
              recvDeletePackage((DeleteAckPackage)reqAckPackage);
              return;
            } 
            if (ChatManager.debug) {
              Log.e("Chat_Chat", "can't handle this delete pack");
              return;
            } 
          } 
        } else {
          if (((BasePackage)reqAckPackage).ack && reqAckPackage instanceof SyncAckPackage) {
            syncAckPackage = (SyncAckPackage)reqAckPackage;
            TimeoutUtils.cancelTimeoutPackage(syncAckPackage.localId);
            recvSyncPackage(syncAckPackage);
            return;
          } 
          if (ChatManager.debug) {
            Log.e("Chat_Chat", "can't handle this sync pack");
            return;
          } 
        } 
      } else if (syncAckPackage instanceof PushBasePackage) {
        pushBasePackage = (PushBasePackage)syncAckPackage;
        if (pushBasePackage.pushReadedPackage != null) {
          if (ChatManager.debug)
            Log.e("Chat_Chat", "pushReadedPackage != null"); 
          if (pushBasePackage.pushReadedPackage.sessionType != 4) {
            if (pushBasePackage.pushReadedPackage.sessionType == 5)
              return; 
            recvPushReadedPackage(pushBasePackage.pushReadedPackage);
            return;
          } 
          return;
        } 
        if (pushBasePackage.pushMsgPackage != null) {
          if (ChatManager.debug) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("pushMsgPackage != null，sessionType：");
            stringBuilder.append(pushBasePackage.pushMsgPackage.sessionType);
            Log.e("Chat_Chat", stringBuilder.toString());
          } 
          if (pushBasePackage.pushMsgPackage.sessionType == 4 || pushBasePackage.pushMsgPackage.sessionType == 5) {
            LiveChat liveChat = this.liveChat;
            if (liveChat != null) {
              liveChat.recvPushMsgPackage(pushBasePackage.pushMsgPackage);
              return;
            } 
            return;
          } 
          if (pushBasePackage.pushMsgPackage.sessionType == 6) {
            if (!this.wawajiControllerChat.handlePushMessage(pushBasePackage.pushMsgPackage)) {
              this.wawajiChat.handlePushMessage(pushBasePackage.pushMsgPackage);
              return;
            } 
          } else if (pushBasePackage.pushMsgPackage.sessionType == 8) {
            if (!this.wawajiControllerChat.handlePushMessage(pushBasePackage.pushMsgPackage)) {
              this.audioRoomChat.recvPushMsgPackage(pushBasePackage.pushMsgPackage);
              return;
            } 
          } else {
            if (ChatManager.debug)
              Log.e("Chat_Chat", "recvPushMsgPackage ===="); 
            recvPushMsgPackage(pushBasePackage.pushMsgPackage);
            return;
          } 
        } 
      } else if (ChatManager.debug) {
        Log.e("Chat_Chat", "can't handle this push pack");
        return;
      } 
    } else if (((BasePackage)pushBasePackage).ack && pushBasePackage instanceof SendAckPackage) {
      SendAckPackage sendAckPackage = (SendAckPackage)pushBasePackage;
      TimeoutUtils.cancelTimeoutPackage(sendAckPackage.localId);
      if (!recvSendAckPackage(sendAckPackage)) {
        LiveChat liveChat = this.liveChat;
        if (liveChat != null) {
          liveChat.recvSendAckPackage(sendAckPackage);
          return;
        } 
      } 
    } else if (ChatManager.debug) {
      Log.e("Chat_Chat", "can't handle this send pack");
    } 
  }
  
  public void onReceiveMsgFromGRPC(ChattingModel paramChattingModel, boolean paramBoolean1, boolean paramBoolean2) {
    PushBasePackage pushBasePackage = PushBasePackage.getDefaultInstance();
    pushBasePackage.msgHeader.isReaded = paramBoolean1;
    pushBasePackage.msgHeader.isDeleted = paramBoolean2;
    pushBasePackage.pushMsgPackage.msgType = paramChattingModel.msgType;
    if (pushBasePackage.pushMsgPackage.msgType == 55) {
      pushBasePackage.pushMsgPackage.fromId = paramChattingModel.fromId;
      pushBasePackage.pushMsgPackage.msgId = paramChattingModel.msgId;
      pushBasePackage.pushMsgPackage.sessionType = paramChattingModel.sessionType;
      pushBasePackage.pushMsgPackage.sessionId = paramChattingModel.sessionId;
      receiveOrderMessage(pushBasePackage.pushMsgPackage);
      return;
    } 
    ChatHelper.checkMsgType(pushBasePackage.pushMsgPackage);
    paramChattingModel._pushMsgPackage = pushBasePackage.pushMsgPackage;
    ArrayList<ChattingModel> arrayList = new ArrayList();
    arrayList.add(paramChattingModel);
    insertRecvMsgList(arrayList);
    setMsgAndSessionReadFlag(paramChattingModel);
  }
  
  public void onSendFailed(BasePackage paramBasePackage, String paramString) {
    SyncBasePackage syncBasePackage;
    if (ChatManager.debug) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("onSendFailed(), pack:");
      stringBuilder.append(paramBasePackage);
      stringBuilder.append(", failedMessage:");
      stringBuilder.append(paramString);
      Log.v("Chat_Chat", stringBuilder.toString());
    } 
    if (ChatManager.debug && (ChatManager.getInstance()).debugTipsListener != null) {
      DebugTipsListener debugTipsListener = (ChatManager.getInstance()).debugTipsListener;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("发送失败, pack:");
      stringBuilder.append(paramBasePackage);
      debugTipsListener.onTips(stringBuilder.toString());
    } 
    DataUtils.imMessageFailed(BasePackage.typeToString(paramBasePackage), SystemClock.uptimeMillis() - paramBasePackage.sendTime, paramString);
    short s = paramBasePackage.type;
    if (s != 3) {
      VideoChat videoChat;
      if (s != 5) {
        if (s != 7) {
          if (ChatManager.debug) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("unknown package onSendFailed, pack:");
            stringBuilder.append(paramBasePackage);
            Log.e("Chat_Chat", stringBuilder.toString());
            return;
          } 
        } else if (paramBasePackage instanceof ReqBasePackage) {
          LiveChat liveChat;
          ReqBasePackage reqBasePackage = (ReqBasePackage)paramBasePackage;
          TimeoutUtils.cancelTimeoutPackage(reqBasePackage.localId);
          if (paramBasePackage instanceof com.blued.android.chat.core.pack.ReqCreateLiveChatPackage) {
            liveChat = this.liveChat;
            if (liveChat != null) {
              liveChat.sendReqPackageFailed(reqBasePackage);
              return;
            } 
          } else if (liveChat instanceof com.blued.android.chat.core.pack.ReqEnterLiveChatPackage) {
            liveChat = this.liveChat;
            if (liveChat != null) {
              liveChat.sendReqPackageFailed(reqBasePackage);
              return;
            } 
          } else if (liveChat instanceof com.blued.android.chat.core.pack.ReqCloseLiveChatPackage) {
            liveChat = this.liveChat;
            if (liveChat != null) {
              liveChat.sendReqPackageFailed(reqBasePackage);
              return;
            } 
          } else if (liveChat instanceof ReqCreateVideoChatPackage) {
            VideoChat videoChat1 = this.videoChat;
            if (videoChat1 != null) {
              videoChat1.callPackageFailed((ReqCreateVideoChatPackage)liveChat);
              return;
            } 
          } else if (liveChat instanceof com.blued.android.chat.core.pack.ReqVideoChatGetLeftTimePackage) {
            videoChat = this.videoChat;
            if (videoChat != null) {
              videoChat.getLeftTimePackageFailed();
              return;
            } 
          } 
        } 
      } else if (videoChat instanceof SyncBasePackage) {
        syncBasePackage = (SyncBasePackage)videoChat;
        TimeoutUtils.cancelTimeoutPackage(syncBasePackage.localId);
        sendSyncPackageFailed(syncBasePackage);
        return;
      } 
    } else {
      if (syncBasePackage instanceof SendMsgPackage) {
        SendMsgPackage sendMsgPackage = (SendMsgPackage)syncBasePackage;
        TimeoutUtils.cancelTimeoutPackage(sendMsgPackage.localId);
        if (sendMsgPackage.sessionType == 4 || sendMsgPackage.sessionType == 5) {
          LiveChat liveChat = this.liveChat;
          if (liveChat != null) {
            liveChat.sendMsgPackageFailed(sendMsgPackage, -1);
            return;
          } 
          return;
        } 
        sendMsgPackageFailed(sendMsgPackage, -1);
        return;
      } 
      if (ChatManager.debug)
        Log.e("Chat_Chat", "unknown send package, drop it"); 
    } 
  }
  
  public void onSendSuccess(BasePackage paramBasePackage) {
    if (ChatManager.debug) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("onSendSuccess(), pack:");
      stringBuilder.append(paramBasePackage);
      Log.v("Chat_Chat", stringBuilder.toString());
    } 
    if (ChatManager.debug && (ChatManager.getInstance()).debugTipsListener != null) {
      DebugTipsListener debugTipsListener = (ChatManager.getInstance()).debugTipsListener;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("发送成功, pack:");
      stringBuilder.append(paramBasePackage);
      debugTipsListener.onTips(stringBuilder.toString());
    } 
  }
  
  public void onStart() {
    if (ChatManager.debug)
      Log.v("Chat_Chat", "onStart()"); 
    reset();
    this.connector.registerConnectListener(this);
    initSessionList();
  }
  
  public void onStop() {
    if (ChatManager.debug)
      Log.v("Chat_Chat", "onStop()"); 
    reset();
  }
  
  public void registerIMStatusListener(IMStatusListener paramIMStatusListener) {
    if (paramIMStatusListener == null)
      return; 
    synchronized (this.imStatusListenerList) {
      this.imStatusListenerList.add(paramIMStatusListener);
      ConnectState connectState = this.connector.getConnectStatus();
      int i = null.$SwitchMap$com$blued$android$chat$data$ConnectState[connectState.ordinal()];
      if (i != 1) {
        if (i != 2) {
          if (i == 3)
            if (this.dataSyncing) {
              paramIMStatusListener.onReceiving();
            } else {
              paramIMStatusListener.onConnected();
            }  
        } else {
          paramIMStatusListener.onConnecting();
        } 
      } else {
        paramIMStatusListener.onDisconnected();
      } 
      return;
    } 
  }
  
  public void registerMsgContentListener(short paramShort, long paramLong, MsgContentListener paramMsgContentListener, boolean paramBoolean) {
    Map<String, SessionModel> map;
    ArrayList arrayList;
    if (ChatManager.debug) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("registerMsgContentListener(), sessionType:");
      stringBuilder.append(paramShort);
      stringBuilder.append(", sessionId:");
      stringBuilder.append(paramLong);
      stringBuilder.append(", listener:");
      stringBuilder.append(paramMsgContentListener);
      stringBuilder.append(", secret:");
      stringBuilder.append(paramBoolean);
      Log.v("Chat_Chat", stringBuilder.toString());
    } 
    if (paramShort == 4 || paramShort == 5) {
      if (ChatManager.debug)
        Log.e("Chat_Chat", "can't register livechat msglist"); 
      return;
    } 
    String str = SessionHeader.getSessionKey(paramShort, paramLong);
    synchronized (this.sessionList) {
      SessionModel sessionModel = this.sessionList.get(str);
      if (sessionModel != null && sessionModel._msgList == null) {
        if (ChatManager.debug)
          Log.v("Chat_Chat", "init session._msgList"); 
        sessionModel._msgList = new ArrayList();
        sessionModel._secretMsgListing = paramBoolean;
      } 
      boolean bool2 = false;
      boolean bool3 = false;
      boolean bool1 = false;
      if (sessionModel != null && !sessionModel._secretMsgListing) {
        paramBoolean = sendReadedFlagForSession(sessionModel);
        if (removeSessionUnreadMsg(sessionModel) || paramBoolean) {
          paramShort = 1;
        } else {
          paramShort = 0;
        } 
        if (removeSessionAtMsgId(sessionModel) || paramShort != 0)
          bool1 = true; 
        paramShort = bool1;
        if (bool1) {
          ChatManager.dbOperImpl.updateSession(sessionModel);
          paramShort = bool1;
        } 
      } else {
        paramShort = bool3;
        if (sessionModel != null) {
          paramShort = bool3;
          if (sessionModel._secretMsgListing) {
            if (sessionModel._unreadedMsgIds != null)
              sessionModel._unreadedMsgIds.clear(); 
            bool1 = bool2;
            if (sessionModel.noReadMsgCount != 0) {
              sessionModel.noReadMsgCount = 0;
              ChatHelper.clearSessionLikeNum(sessionModel);
              sessionModel.secretLookStatus = 1;
              bool1 = true;
            } 
            paramShort = bool1;
            if (bool1) {
              ChatManager.dbOperImpl.updateSession(sessionModel);
              paramShort = bool1;
            } 
          } 
        } 
      } 
      synchronized (this.msgListenerList) {
        Set<MsgContentListener> set2 = this.msgListenerList.get(str);
        Set<MsgContentListener> set1 = set2;
        if (set2 == null) {
          set1 = new HashSet();
          this.msgListenerList.put(str, set1);
        } 
        if (!set1.contains(paramMsgContentListener)) {
          set1.add(paramMsgContentListener);
          if (sessionModel != null && sessionModel._msgList != null) {
            arrayList = new ArrayList();
            arrayList.addAll(sessionModel._msgList);
            paramMsgContentListener.onMsgDataChanged(arrayList);
          } 
        } 
        if (paramShort != 0)
          notifySessionChanged(sessionModel); 
        return;
      } 
    } 
  }
  
  public void registerSessionListener(SessionListener paramSessionListener) {
    if (ChatManager.debug) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("registerSessionListener(), listener:");
      stringBuilder.append(paramSessionListener);
      Log.v("Chat_Chat", stringBuilder.toString());
    } 
    synchronized (this.sessionListenerList) {
      this.sessionListenerList.add(paramSessionListener);
      notifySessionListChanged(paramSessionListener);
      return;
    } 
  }
  
  public void registerSessionListener(short paramShort, long paramLong, SingleSessionListener paramSingleSessionListener) {
    if (ChatManager.debug) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("registerSessionListener(), sessionType: ");
      stringBuilder.append(paramShort);
      stringBuilder.append(", sessionId: ");
      stringBuilder.append(paramLong);
      stringBuilder.append(", listener:");
      stringBuilder.append(paramSingleSessionListener);
      Log.v("Chat_Chat", stringBuilder.toString());
    } 
    String str = SessionHeader.getSessionKey(paramShort, paramLong);
    synchronized (this.singleSessionListenerMap) {
      Set<SingleSessionListener> set2 = this.singleSessionListenerMap.get(str);
      Set<SingleSessionListener> set1 = set2;
      if (set2 == null) {
        set1 = new HashSet();
        this.singleSessionListenerMap.put(str, set1);
      } 
      set1.add(paramSingleSessionListener);
      notifySessionChanged(paramShort, paramLong, paramSingleSessionListener);
      return;
    } 
  }
  
  public void reset() {
    if (ChatManager.debug)
      Log.v("Chat_Chat", "reset()"); 
    this.sessionListInited = false;
    RoomChat roomChat = this.roomChat;
    if (roomChat != null)
      roomChat.setupRoomId(0L); 
    this.dataSyncing = false;
    this.initMaxMsgId = 0L;
    this.syncRetryCount = 0;
    synchronized (this.sessionList) {
      this.sessionList.clear();
      synchronized (this.snapSessionList) {
        this.snapSessionList.clear();
        if (this.reqSessionKeyList != null)
          this.reqSessionKeyList.clear(); 
        this.reqSessionKeyList = null;
        synchronized (this.sendingPackageList) {
          this.sendingPackageList.clear();
          synchronized (this.syncLoadListener) {
            this.syncLoadListener.clear();
            return;
          } 
        } 
      } 
    } 
  }
  
  public void retractOneMessage(final short sessionType, final long sessionId, final long messageId, final RetractionListener callbackListener) {
    if (ChatManager.debug) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("retractOneMessage(), sessionType:");
      stringBuilder.append(sessionType);
      stringBuilder.append(", sessionId:");
      stringBuilder.append(sessionId);
      stringBuilder.append(", messageId:");
      stringBuilder.append(messageId);
      Log.v("Chat_Chat", stringBuilder.toString());
    } 
    if (ChatManager.clientType == ChatManager.ClientType.CHINA && sessionType == 3 && GRPC.getInstance().getOrderSender() != null) {
      GRPC.getInstance().getOrderSender().retractMsg(sessionType, sessionId, messageId, new RetractionListener() {
            public void onMsgRetractedTimeout() {
              RetractionListener retractionListener = callbackListener;
              if (retractionListener != null)
                retractionListener.onMsgRetractedTimeout(); 
            }
            
            public void onRetractFailed() {
              RetractionListener retractionListener = callbackListener;
              if (retractionListener != null)
                retractionListener.onRetractFailed(); 
            }
            
            public void onRetractSuccess() {
              Chat.this.recvDeleteRetractAckPackage(new DeleteRetractMessagePackage(sessionType, sessionId, messageId, 0L));
              RetractionListener retractionListener = callbackListener;
              if (retractionListener != null)
                retractionListener.onRetractSuccess(); 
            }
          });
      return;
    } 
    this.packSendHelper.sendPackage((BasePackage)new DeleteRetractMessagePackage(sessionType, sessionId, messageId, ChatHelper.getLocalId()), new PackSendHelper.PackCallback() {
          public void onAckTimeout(BasePackage param1BasePackage) {
            RetractionListener retractionListener = callbackListener;
            if (retractionListener != null)
              retractionListener.onRetractFailed(); 
          }
          
          public void onReceiveAck(BasePackage param1BasePackage1, BasePackage param1BasePackage2) {
            if (param1BasePackage1 != null && param1BasePackage2 != null) {
              RetractionListener retractionListener;
              DeleteRetractMessagePackage deleteRetractMessagePackage = (DeleteRetractMessagePackage)param1BasePackage1;
              DeleteAckPackage deleteAckPackage = (DeleteAckPackage)param1BasePackage2;
              if (ChatManager.debug) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("onReceiveAck(), sessionType:");
                stringBuilder.append(sessionType);
                stringBuilder.append(", sessionId:");
                stringBuilder.append(sessionId);
                stringBuilder.append(", messageId:");
                stringBuilder.append(messageId);
                stringBuilder.append("localId:");
                stringBuilder.append(deleteAckPackage.localId);
                Log.v("Chat_Chat", stringBuilder.toString());
              } 
              int i = deleteAckPackage.result;
              if (i != 0) {
                if (i != 4)
                  return; 
                retractionListener = callbackListener;
                if (retractionListener != null) {
                  retractionListener.onMsgRetractedTimeout();
                  return;
                } 
              } else {
                RetractionListener retractionListener1 = callbackListener;
                if (retractionListener1 != null)
                  retractionListener1.onRetractSuccess(); 
                Chat.this.recvDeleteRetractAckPackage((DeleteRetractMessagePackage)retractionListener, deleteAckPackage);
              } 
            } 
          }
          
          public void onSendFailed(BasePackage param1BasePackage) {
            RetractionListener retractionListener = callbackListener;
            if (retractionListener != null)
              retractionListener.onRetractFailed(); 
          }
          
          public void onSendFinish(BasePackage param1BasePackage) {}
          
          public void onSendTimeout(BasePackage param1BasePackage) {
            RetractionListener retractionListener = callbackListener;
            if (retractionListener != null)
              retractionListener.onRetractFailed(); 
          }
        });
  }
  
  public boolean retrySyncMsg(boolean paramBoolean) {
    if (ChatManager.debug) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("checkSyncState(), syncRetryCount:");
      stringBuilder.append(this.syncRetryCount);
      Log.v("Chat_Chat", stringBuilder.toString());
    } 
    if (!paramBoolean) {
      this.syncRetryCount = 0;
      sendSyncAllPackage(this.initMaxMsgId, 0L);
      return true;
    } 
    int i = this.syncRetryCount;
    if (i < 3) {
      this.syncRetryCount = i + 1;
      sendSyncAllPackage(this.initMaxMsgId, 0L);
      return true;
    } 
    return false;
  }
  
  public void sendMsg(ChattingModel paramChattingModel, SessionProfileModel paramSessionProfileModel, boolean paramBoolean, MsgPreProcesser paramMsgPreProcesser) {
    AudioRoomChat audioRoomChat;
    if (ChatManager.debug) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("sendMsg(), msgData:");
      stringBuilder.append(paramChattingModel);
      Log.v("Chat_Chat", stringBuilder.toString());
    } 
    if (paramChattingModel == null)
      return; 
    if (!paramBoolean)
      paramChattingModel.msgAt = AtRegExpUtils.parseMessageAt(paramChattingModel.msgContent); 
    if (paramChattingModel.sessionType == 4 || paramChattingModel.sessionType == 5) {
      LiveChat liveChat = this.liveChat;
      if (liveChat != null)
        liveChat.sendMsg(paramChattingModel, paramSessionProfileModel, paramBoolean, paramMsgPreProcesser); 
      return;
    } 
    if (paramChattingModel.sessionType == 8) {
      audioRoomChat = this.audioRoomChat;
      if (audioRoomChat != null)
        audioRoomChat.sendMsg(paramChattingModel, paramMsgPreProcesser); 
      return;
    } 
    if (ChatHelper.isLocalViewMsg(paramChattingModel.msgType)) {
      insertMsgDataForLocal(paramChattingModel);
      return;
    } 
    paramChattingModel.msgStateCode = 1;
    if (paramBoolean) {
      updateMsgData(paramChattingModel);
    } else {
      insertMsgDataForSending(paramChattingModel, (SessionProfileModel)audioRoomChat);
    } 
    if (paramMsgPreProcesser != null) {
      paramMsgPreProcesser.preProcess(paramChattingModel, this);
      return;
    } 
    sendMsgToServer(paramChattingModel);
  }
  
  public void setSessionSetting(short paramShort, long paramLong, SessionSettingBaseModel paramSessionSettingBaseModel) {
    String str = SessionHeader.getSessionKey(paramShort, paramLong);
    synchronized (this.sessionList) {
      SessionModel sessionModel = this.sessionList.get(str);
      if (sessionModel != null) {
        if (paramSessionSettingBaseModel == null) {
          ChatManager.dbOperImpl.deleteSessionSetting(paramShort, paramLong);
          sessionModel.sessionSettingModel = null;
        } else if (sessionModel.sessionSettingModel == null) {
          ChatManager.dbOperImpl.createSessionSetting(paramShort, paramLong, paramSessionSettingBaseModel);
          sessionModel.sessionSettingModel = paramSessionSettingBaseModel;
        } else {
          sessionModel.sessionSettingModel.copyValue(paramSessionSettingBaseModel);
          ChatManager.dbOperImpl.updateSessionSetting(paramShort, paramLong, sessionModel.sessionSettingModel);
        } 
      } else {
        SessionSettingBaseModel sessionSettingBaseModel = ChatManager.dbOperImpl.getSessionSetting(paramShort, paramLong);
        if (sessionSettingBaseModel != null) {
          sessionSettingBaseModel.copyValue(paramSessionSettingBaseModel);
          ChatManager.dbOperImpl.updateSessionSetting(paramShort, paramLong, sessionSettingBaseModel);
        } else {
          ChatManager.dbOperImpl.createSessionSetting(paramShort, paramLong, paramSessionSettingBaseModel);
        } 
      } 
      return;
    } 
  }
  
  public void triggleSessionListNotify() {
    notifySessionListChanged();
  }
  
  public void unregisterIMStatusListener(IMStatusListener paramIMStatusListener) {
    synchronized (this.imStatusListenerList) {
      this.imStatusListenerList.remove(paramIMStatusListener);
      return;
    } 
  }
  
  public void unregisterMsgContentListener(short paramShort, long paramLong, MsgContentListener paramMsgContentListener) {
    if (ChatManager.debug) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("unregisterMsgContentListener(), sessionType:");
      stringBuilder.append(paramShort);
      stringBuilder.append(", sessionId:");
      stringBuilder.append(paramLong);
      stringBuilder.append(", listener:");
      stringBuilder.append(paramMsgContentListener);
      Log.v("Chat_Chat", stringBuilder.toString());
    } 
    if (paramShort == 4 || paramShort == 5) {
      if (ChatManager.debug)
        Log.e("Chat_Chat", "can't unregister livechat msglist"); 
      return;
    } 
    String str = SessionHeader.getSessionKey(paramShort, paramLong);
    synchronized (this.msgListenerList) {
      Set set = this.msgListenerList.get(str);
      if (set != null)
        set.remove(paramMsgContentListener); 
      if (set == null || set.size() <= 0) {
        if (ChatManager.debug)
          Log.v("Chat_Chat", "don't have the session msg listener, so clear session._msgList"); 
        synchronized (this.sessionList) {
          SessionModel sessionModel = this.sessionList.get(str);
          if (sessionModel != null) {
            if (ChatManager.debug)
              Log.v("Chat_Chat", "dispose _msgList"); 
            sessionModel._msgList = null;
            sessionModel._secretMsgListing = false;
            sessionModel.isFromSearch = false;
          } 
          return;
        } 
      } 
    } 
  }
  
  public void unregisterSessionListener(SessionListener paramSessionListener) {
    if (ChatManager.debug) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("unregisterSessionListener(), listener:");
      stringBuilder.append(paramSessionListener);
      Log.v("Chat_Chat", stringBuilder.toString());
    } 
    synchronized (this.sessionListenerList) {
      this.sessionListenerList.remove(paramSessionListener);
      return;
    } 
  }
  
  public void unregisterSessionListener(short paramShort, long paramLong, SingleSessionListener paramSingleSessionListener) {
    if (ChatManager.debug) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("unregisterSessionListener(), sessionType: ");
      stringBuilder.append(paramShort);
      stringBuilder.append(", sessionId: ");
      stringBuilder.append(paramLong);
      stringBuilder.append(", listener:");
      stringBuilder.append(paramSingleSessionListener);
      Log.v("Chat_Chat", stringBuilder.toString());
    } 
    String str = SessionHeader.getSessionKey(paramShort, paramLong);
    synchronized (this.singleSessionListenerMap) {
      Set set = this.singleSessionListenerMap.get(str);
      if (set != null)
        set.remove(paramSingleSessionListener); 
      return;
    } 
  }
  
  public void updataSessionStatus(short paramShort, long paramLong, int paramInt) {
    null = SessionHeader.getSessionKey(paramShort, paramLong);
    synchronized (this.sessionList) {
      SessionModel sessionModel = this.sessionList.get(null);
      if (sessionModel != null) {
        sessionModel.sessionStatus = paramInt;
        ChatManager.dbOperImpl.updateSession(sessionModel);
      } 
      notifySessionChanged(sessionModel);
      return;
    } 
  }
  
  public int updateAllSessionSetting(Map<String, Object> paramMap) {
    int i = ChatManager.dbOperImpl.updateAllSessionSetting(paramMap);
    synchronized (this.sessionList) {
      Iterator<Map.Entry> iterator = this.sessionList.entrySet().iterator();
      while (iterator.hasNext()) {
        SessionModel sessionModel = (SessionModel)((Map.Entry)iterator.next()).getValue();
        if (sessionModel != null) {
          SessionSettingBaseModel sessionSettingBaseModel = sessionModel.sessionSettingModel;
          if (sessionSettingBaseModel != null)
            sessionSettingBaseModel.updateValues(paramMap); 
        } 
      } 
      return i;
    } 
  }
  
  protected void updateMsgData(ChattingModel paramChattingModel) {
    if (ChatManager.debug) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("updateMsgData(), msgData:");
      stringBuilder.append(paramChattingModel);
      Log.v("Chat_Chat", stringBuilder.toString());
    } 
    ChatManager.dbOperImpl.updateChattingModel(paramChattingModel);
    boolean bool = false;
    String str = SessionHeader.getSessionKey(paramChattingModel.sessionType, paramChattingModel.sessionId);
    synchronized (this.sessionList) {
      SessionModel sessionModel = this.sessionList.get(str);
      if (sessionModel == null)
        return; 
      long l1 = sessionModel.lastMsgId;
      long l2 = sessionModel.lastMsgLocalId;
      boolean bool1 = bool;
      if (l1 == paramChattingModel.msgId) {
        bool1 = bool;
        if (l2 == paramChattingModel.msgLocalId) {
          SessionModel.setSessionForLastMsg(sessionModel, paramChattingModel);
          bool1 = true;
        } 
      } 
      if (bool1)
        ChatManager.dbOperImpl.updateSession(sessionModel); 
      if (bool1)
        notifySessionChanged(sessionModel); 
      insertMemoryAndNotifyUI(sessionModel, paramChattingModel);
      return;
    } 
  }
  
  public void updateMsgForTextTranslateInit(int paramInt, long paramLong) {
    ChatManager.dbOperImpl.updateMsgForTextTranslateInit(paramInt, paramLong);
  }
  
  public void updateMsgOneData(ChattingModel paramChattingModel) {
    if (paramChattingModel == null)
      return; 
    String str = SessionHeader.getSessionKey(paramChattingModel.sessionType, paramChattingModel.sessionId);
    boolean bool = false;
    synchronized (this.sessionList) {
      SessionModel sessionModel = this.sessionList.get(str);
      boolean bool1 = bool;
      if (sessionModel != null) {
        bool1 = bool;
        if (sessionModel._msgList != null) {
          MsgComparator msgComparator = new MsgComparator();
          Iterator<ChattingModel> iterator = sessionModel._msgList.iterator();
          while (true) {
            bool1 = bool;
            if (iterator.hasNext()) {
              ChattingModel chattingModel = iterator.next();
              if (msgComparator.compare(chattingModel, paramChattingModel) == 0) {
                ChatManager.dbOperImpl.updateChattingModel(chattingModel);
                bool1 = true;
                break;
              } 
              continue;
            } 
            break;
          } 
        } 
      } 
      if (bool1)
        notifyMsgListChanged(paramChattingModel.sessionType, paramChattingModel.sessionId); 
      return;
    } 
  }
  
  public void updateMsgState(ChattingModel paramChattingModel, short paramShort) {
    if (paramChattingModel == null)
      return; 
    String str = SessionHeader.getSessionKey(paramChattingModel.sessionType, paramChattingModel.sessionId);
    synchronized (this.sessionList) {
      boolean bool1;
      boolean bool2;
      SessionModel sessionModel = this.sessionList.get(str);
      boolean bool3 = false;
      if (sessionModel != null) {
        boolean bool;
        if (sessionModel.lastMsgId == paramChattingModel.msgId && sessionModel.lastMsgLocalId == paramChattingModel.msgLocalId) {
          sessionModel.lastMsgStateCode = paramShort;
          ChatManager.dbOperImpl.updateSession(sessionModel);
          bool = true;
        } else {
          bool = false;
        } 
        bool1 = bool3;
        bool2 = bool;
        if (sessionModel._msgList != null) {
          MsgComparator msgComparator = new MsgComparator();
          Iterator<ChattingModel> iterator = sessionModel._msgList.iterator();
          while (true) {
            bool1 = bool3;
            bool2 = bool;
            if (iterator.hasNext()) {
              ChattingModel chattingModel = iterator.next();
              if (msgComparator.compare(chattingModel, paramChattingModel) == 0) {
                chattingModel.msgStateCode = paramShort;
                ChatManager.dbOperImpl.updateChattingModel(chattingModel);
                bool1 = true;
                bool2 = bool;
                break;
              } 
              continue;
            } 
            break;
          } 
        } 
      } else {
        bool2 = false;
        bool1 = bool3;
      } 
      if (bool1)
        notifyMsgListChanged(paramChattingModel.sessionType, paramChattingModel.sessionId); 
      if (bool2)
        notifySessionChanged(sessionModel); 
      return;
    } 
  }
  
  public void updateRelationSessionSetting(short paramShort, long paramLong, Map<String, Object> paramMap) {
    String str = SessionHeader.getSessionKey(paramShort, paramLong);
    synchronized (this.sessionList) {
      SessionModel sessionModel = this.sessionList.get(str);
      if (sessionModel != null) {
        SessionSettingBaseModel sessionSettingBaseModel = sessionModel.sessionSettingModel;
        if (sessionSettingBaseModel != null)
          sessionSettingBaseModel.updateValues(paramMap); 
      } 
      return;
    } 
  }
  
  public int updateRelationSessionSettingListDb(List<SessionSettingBaseModel> paramList) {
    if (ChatManager.dbOperImpl != null)
      synchronized (this.sessionList) {
        return ChatManager.dbOperImpl.updateRelationSessionSettingListDb(paramList);
      }  
    return -1;
  }
  
  public void updateSessionDraft(short paramShort, long paramLong, String paramString) {
    String str = SessionHeader.getSessionKey(paramShort, paramLong);
    synchronized (this.sessionList) {
      SessionModel sessionModel = this.sessionList.get(str);
      if (sessionModel != null) {
        sessionModel.lastDraft = paramString;
        ChatManager.dbOperImpl.updateSession(sessionModel);
      } 
      notifySessionChanged(sessionModel);
      return;
    } 
  }
  
  public void updateSessionFriend(short paramShort, long paramLong, int paramInt) {
    null = SessionHeader.getSessionKey(paramShort, paramLong);
    synchronized (this.sessionList) {
      SessionModel sessionModel = this.sessionList.get(null);
      if (sessionModel != null) {
        sessionModel.friend = paramInt;
        ChatManager.dbOperImpl.updateSession(sessionModel);
      } 
      notifySessionChanged(sessionModel);
      return;
    } 
  }
  
  public void updateSessionInfoData(short paramShort, long paramLong, SessionProfileModel paramSessionProfileModel) {
    String str = SessionHeader.getSessionKey(paramShort, paramLong);
    synchronized (this.sessionList) {
      SessionModel sessionModel = this.sessionList.get(str);
      if (sessionModel != null) {
        String str1 = paramSessionProfileModel.nickname;
        if (!TextUtils.isEmpty(str1))
          sessionModel.nickName = str1; 
        sessionModel.avatar = paramSessionProfileModel.avatar;
        sessionModel.vBadge = paramSessionProfileModel.vBadge;
        sessionModel.online = paramSessionProfileModel.online;
        sessionModel.vipGrade = paramSessionProfileModel.vipGrade;
        sessionModel.vipAnnual = paramSessionProfileModel.vipAnnual;
        sessionModel.vipExpLvl = paramSessionProfileModel.vipExpLvl;
        sessionModel.hideVipLook = paramSessionProfileModel.hideVipLook;
        sessionModel.ovipGrade = paramSessionProfileModel.ovipGrade;
        sessionModel.ohideVipLook = paramSessionProfileModel.ohideVipLook;
        sessionModel.oFaceStatus = paramSessionProfileModel.oFaceStatus;
        ChatManager.dbOperImpl.updateSession(sessionModel);
      } 
      notifySessionChanged(sessionModel);
      return;
    } 
  }
  
  public void updateSessionLieTop(short paramShort, long paramLong, int paramInt) {
    null = SessionHeader.getSessionKey(paramShort, paramLong);
    synchronized (this.sessionList) {
      SessionModel sessionModel = this.sessionList.get(null);
      if (sessionModel != null) {
        sessionModel.lieTop = paramInt;
        ChatManager.dbOperImpl.updateSession(sessionModel);
      } 
      notifySessionChanged(sessionModel);
      return;
    } 
  }
  
  public void updateSessionNoReadCount(short paramShort, long paramLong, int paramInt) {
    null = SessionHeader.getSessionKey(paramShort, paramLong);
    synchronized (this.sessionList) {
      SessionModel sessionModel = this.sessionList.get(null);
      if (sessionModel != null && sessionModel.noReadMsgCount != paramInt) {
        sessionModel.noReadMsgCount = paramInt;
        ChatManager.dbOperImpl.updateSession(sessionModel);
        paramShort = 1;
      } else {
        paramShort = 0;
      } 
      if (paramShort != 0)
        notifySessionChanged(sessionModel); 
      return;
    } 
  }
  
  public void updateSessionOnLineState(List<Pair<Long, Integer>> paramList) {
    if (ChatManager.debug)
      Log.v("Chat_Chat", "updataSessionPLine()"); 
    if (paramList == null)
      return; 
    synchronized (this.sessionList) {
      for (Pair<Long, Integer> pair : paramList) {
        String str = SessionHeader.getSessionKey(2, ((Long)pair.first).longValue());
        SessionModel sessionModel = this.sessionList.get(str);
        if (sessionModel != null) {
          sessionModel.onLineState = ((Integer)pair.second).intValue();
          ChatManager.dbOperImpl.updateSession(sessionModel);
        } 
      } 
      notifySessionListChanged();
      return;
    } 
  }
  
  public int updateSessionSetting(short paramShort, long paramLong, Map<String, Object> paramMap) {
    int i = ChatManager.dbOperImpl.updateSessionSetting(paramShort, paramLong, paramMap);
    String str = SessionHeader.getSessionKey(paramShort, paramLong);
    synchronized (this.sessionList) {
      SessionModel sessionModel = this.sessionList.get(str);
      if (sessionModel != null) {
        SessionSettingBaseModel sessionSettingBaseModel = sessionModel.sessionSettingModel;
        if (sessionSettingBaseModel != null)
          sessionSettingBaseModel.updateValues(paramMap); 
      } 
      return i;
    } 
  }
  
  public void updateSessionTopGift(short paramShort, long paramLong1, long paramLong2, float paramFloat) {
    null = SessionHeader.getSessionKey(paramShort, paramLong1);
    synchronized (this.sessionList) {
      SessionModel sessionModel = this.sessionList.get(null);
      if (sessionModel != null) {
        sessionModel.expireTime = paramLong2;
        sessionModel.totalMoney = paramFloat;
        ChatManager.dbOperImpl.updateSession(sessionModel);
      } 
      notifySessionChanged(sessionModel);
      return;
    } 
  }
  
  public void updateSessionUnreadGiftCnt(short paramShort, long paramLong1, int paramInt, long paramLong2) {
    null = SessionHeader.getSessionKey(paramShort, paramLong1);
    synchronized (this.sessionList) {
      SessionModel sessionModel = this.sessionList.get(null);
      if (sessionModel != null) {
        sessionModel.unreadGiftCnt = paramInt;
        sessionModel.lastGiftMsgId = paramLong2;
        ChatManager.dbOperImpl.updateSession(sessionModel);
      } 
      notifySessionChanged(sessionModel);
      return;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\blued\android\chat\core\worker\chat\Chat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */