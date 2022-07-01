package com.blued.android.module.live.im.biz;

import android.os.SystemClock;
import cn.irisgw.live.LiveChatGrpc;
import cn.irisgw.live.LiveChatOuterClass;
import com.blued.android.module.im.grpc.ChannelManager;
import com.blued.android.module.im.grpc.IMThreadManager;
import com.blued.android.module.live.im.LiveIM;
import com.blued.android.module.live.im.LiveIMConfig;
import com.blued.android.statistics.BluedStatistics;
import com.blued.android.statistics.util.NamedRunnable;
import com.blued.das.apm.ApmProtos;
import io.grpc.stub.AbstractStub;
import java.util.concurrent.TimeUnit;

public final class LiveChat {
  private ChannelManager a;
  
  private IMThreadManager b;
  
  public LiveChat(ChannelManager paramChannelManager, IMThreadManager paramIMThreadManager) {
    this.a = paramChannelManager;
    this.b = paramIMThreadManager;
  }
  
  private LiveChatGrpc.LiveChatBlockingStub a() {
    LiveChatGrpc.LiveChatBlockingStub liveChatBlockingStub = LiveChatGrpc.newBlockingStub(this.a.d());
    return (LiveChatGrpc.LiveChatBlockingStub)((LiveChatGrpc.LiveChatBlockingStub)((LiveChatGrpc.LiveChatBlockingStub)this.a.a((AbstractStub)liveChatBlockingStub)).withCompression("gzip")).withDeadlineAfter(30L, TimeUnit.SECONDS);
  }
  
  private void a(String paramString, long paramLong1, int paramInt, long paramLong2, Exception paramException) {
    String str;
    paramLong1 = SystemClock.uptimeMillis() - paramLong1;
    if (paramLong2 == 0L) {
      str = "";
    } else {
      str = String.valueOf(paramLong2);
    } 
    BluedStatistics.b().a(ApmProtos.GrpcRequestTypeProto.BUSINESS.LIVE_CHAT, paramString, paramInt, paramLong1, str, paramException, this.a.a(), this.a.b());
    if (LiveIMConfig.b())
      LiveIMConfig.a().a(new Object[] { ">>send spendTime=", Long.valueOf(paramLong1) }); 
  }
  
  public void a(LiveChatOuterClass.LiveLikeRequest paramLiveLikeRequest, LiveIM.OnSendLikeFinishListener paramOnSendLikeFinishListener) {
    if (this.a != null) {
      IMThreadManager iMThreadManager = this.b;
      if (iMThreadManager == null)
        return; 
      if (paramLiveLikeRequest != null)
        iMThreadManager.a((Runnable)new SendLikeRunnable(this, paramLiveLikeRequest, paramOnSendLikeFinishListener)); 
    } 
  }
  
  public void a(LiveChatOuterClass.LiveMsgRequest paramLiveMsgRequest, LiveIM.OnSendMessageFinishListener paramOnSendMessageFinishListener) {
    if (this.a != null) {
      IMThreadManager iMThreadManager = this.b;
      if (iMThreadManager == null)
        return; 
      if (paramLiveMsgRequest != null)
        iMThreadManager.a((Runnable)new SendMessageRunnable(this, paramLiveMsgRequest, paramOnSendMessageFinishListener)); 
    } 
  }
  
  class SendLikeRunnable extends NamedRunnable {
    private LiveChatOuterClass.LiveLikeRequest b;
    
    private LiveIM.OnSendLikeFinishListener c;
    
    public SendLikeRunnable(LiveChat this$0, LiveChatOuterClass.LiveLikeRequest param1LiveLikeRequest, LiveIM.OnSendLikeFinishListener param1OnSendLikeFinishListener) {
      super(LiveIMConfig.a("send-like"));
      this.b = param1LiveLikeRequest;
      this.c = param1OnSendLikeFinishListener;
    }
    
    public void a() {
      // Byte code:
      //   0: invokestatic b : ()Z
      //   3: ifeq -> 58
      //   6: invokestatic a : ()Lcom/blued/android/statistics/util/Logger;
      //   9: astore #5
      //   11: new java/lang/StringBuilder
      //   14: dup
      //   15: invokespecial <init> : ()V
      //   18: astore #6
      //   20: aload #6
      //   22: ldc '>> SendMessageRunnable : '
      //   24: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   27: pop
      //   28: aload #6
      //   30: aload_0
      //   31: getfield b : Lcn/irisgw/live/LiveChatOuterClass$LiveLikeRequest;
      //   34: invokevirtual toString : ()Ljava/lang/String;
      //   37: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   40: pop
      //   41: aload #5
      //   43: iconst_1
      //   44: anewarray java/lang/Object
      //   47: dup
      //   48: iconst_0
      //   49: aload #6
      //   51: invokevirtual toString : ()Ljava/lang/String;
      //   54: aastore
      //   55: invokevirtual b : ([Ljava/lang/Object;)V
      //   58: aconst_null
      //   59: astore #7
      //   61: invokestatic uptimeMillis : ()J
      //   64: lstore_3
      //   65: aconst_null
      //   66: astore #9
      //   68: aconst_null
      //   69: astore #6
      //   71: aconst_null
      //   72: astore #5
      //   74: aload_0
      //   75: getfield a : Lcom/blued/android/module/live/im/biz/LiveChat;
      //   78: invokestatic a : (Lcom/blued/android/module/live/im/biz/LiveChat;)Lcn/irisgw/live/LiveChatGrpc$LiveChatBlockingStub;
      //   81: aload_0
      //   82: getfield b : Lcn/irisgw/live/LiveChatOuterClass$LiveLikeRequest;
      //   85: invokevirtual sendLike : (Lcn/irisgw/live/LiveChatOuterClass$LiveLikeRequest;)Lcn/irisgw/live/LiveChatOuterClass$LiveLikeResponse;
      //   88: astore #8
      //   90: aload #8
      //   92: ifnull -> 102
      //   95: sipush #200
      //   98: istore_1
      //   99: goto -> 105
      //   102: bipush #100
      //   104: istore_1
      //   105: aload_0
      //   106: getfield c : Lcom/blued/android/module/live/im/LiveIM$OnSendLikeFinishListener;
      //   109: astore #7
      //   111: iload_1
      //   112: istore_2
      //   113: aload #9
      //   115: astore #6
      //   117: aload #7
      //   119: ifnull -> 141
      //   122: aload #8
      //   124: astore #6
      //   126: aload #7
      //   128: aload #6
      //   130: invokeinterface onFinish : (Lcn/irisgw/live/LiveChatOuterClass$LiveLikeResponse;)V
      //   135: aload #5
      //   137: astore #6
      //   139: iload_1
      //   140: istore_2
      //   141: aload_0
      //   142: getfield a : Lcom/blued/android/module/live/im/biz/LiveChat;
      //   145: ldc 'send_like'
      //   147: lload_3
      //   148: iload_2
      //   149: lconst_0
      //   150: aload #6
      //   152: invokestatic a : (Lcom/blued/android/module/live/im/biz/LiveChat;Ljava/lang/String;JIJLjava/lang/Exception;)V
      //   155: return
      //   156: astore #7
      //   158: aload #6
      //   160: astore #5
      //   162: aload #7
      //   164: astore #6
      //   166: bipush #100
      //   168: istore_1
      //   169: goto -> 289
      //   172: astore #8
      //   174: aload_0
      //   175: getfield a : Lcom/blued/android/module/live/im/biz/LiveChat;
      //   178: invokestatic b : (Lcom/blued/android/module/live/im/biz/LiveChat;)Lcom/blued/android/module/im/grpc/ChannelManager;
      //   181: aload #8
      //   183: invokevirtual a : (Ljava/lang/Exception;)Lio/grpc/Status;
      //   186: astore #9
      //   188: aload #9
      //   190: invokevirtual getCode : ()Lio/grpc/Status$Code;
      //   193: getstatic io/grpc/Status$Code.UNKNOWN : Lio/grpc/Status$Code;
      //   196: if_acmpne -> 209
      //   199: aload #8
      //   201: astore #5
      //   203: bipush #100
      //   205: istore_1
      //   206: goto -> 225
      //   209: aload #9
      //   211: invokevirtual asException : ()Lio/grpc/StatusException;
      //   214: astore #5
      //   216: aload #9
      //   218: invokevirtual getCode : ()Lio/grpc/Status$Code;
      //   221: invokevirtual value : ()I
      //   224: istore_1
      //   225: invokestatic b : ()Z
      //   228: ifeq -> 251
      //   231: invokestatic a : ()Lcom/blued/android/statistics/util/Logger;
      //   234: iconst_2
      //   235: anewarray java/lang/Object
      //   238: dup
      //   239: iconst_0
      //   240: ldc '>> SendLike Exception : \\n'
      //   242: aastore
      //   243: dup
      //   244: iconst_1
      //   245: aload #8
      //   247: aastore
      //   248: invokevirtual e : ([Ljava/lang/Object;)V
      //   251: aload_0
      //   252: getfield c : Lcom/blued/android/module/live/im/LiveIM$OnSendLikeFinishListener;
      //   255: astore #8
      //   257: iload_1
      //   258: istore_2
      //   259: aload #5
      //   261: astore #6
      //   263: aload #8
      //   265: ifnull -> 141
      //   268: aload #7
      //   270: astore #6
      //   272: aload #8
      //   274: astore #7
      //   276: goto -> 126
      //   279: astore #6
      //   281: goto -> 289
      //   284: astore #6
      //   286: goto -> 166
      //   289: aload_0
      //   290: getfield c : Lcom/blued/android/module/live/im/LiveIM$OnSendLikeFinishListener;
      //   293: astore #7
      //   295: aload #7
      //   297: ifnull -> 308
      //   300: aload #7
      //   302: aconst_null
      //   303: invokeinterface onFinish : (Lcn/irisgw/live/LiveChatOuterClass$LiveLikeResponse;)V
      //   308: aload_0
      //   309: getfield a : Lcom/blued/android/module/live/im/biz/LiveChat;
      //   312: ldc 'send_like'
      //   314: lload_3
      //   315: iload_1
      //   316: lconst_0
      //   317: aload #5
      //   319: invokestatic a : (Lcom/blued/android/module/live/im/biz/LiveChat;Ljava/lang/String;JIJLjava/lang/Exception;)V
      //   322: aload #6
      //   324: athrow
      // Exception table:
      //   from	to	target	type
      //   74	90	172	java/lang/Exception
      //   74	90	156	finally
      //   174	199	156	finally
      //   209	216	156	finally
      //   216	225	284	finally
      //   225	251	279	finally
    }
  }
  
  class SendMessageRunnable extends NamedRunnable {
    private LiveChatOuterClass.LiveMsgRequest b;
    
    private LiveIM.OnSendMessageFinishListener c;
    
    public SendMessageRunnable(LiveChat this$0, LiveChatOuterClass.LiveMsgRequest param1LiveMsgRequest, LiveIM.OnSendMessageFinishListener param1OnSendMessageFinishListener) {
      super(LiveIMConfig.a("send-message"));
      this.b = param1LiveMsgRequest;
      this.c = param1OnSendMessageFinishListener;
    }
    
    public void a() {
      // Byte code:
      //   0: invokestatic b : ()Z
      //   3: ifeq -> 58
      //   6: invokestatic a : ()Lcom/blued/android/statistics/util/Logger;
      //   9: astore #9
      //   11: new java/lang/StringBuilder
      //   14: dup
      //   15: invokespecial <init> : ()V
      //   18: astore #10
      //   20: aload #10
      //   22: ldc '>> SendMessageRunnable : '
      //   24: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   27: pop
      //   28: aload #10
      //   30: aload_0
      //   31: getfield b : Lcn/irisgw/live/LiveChatOuterClass$LiveMsgRequest;
      //   34: invokevirtual toString : ()Ljava/lang/String;
      //   37: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   40: pop
      //   41: aload #9
      //   43: iconst_1
      //   44: anewarray java/lang/Object
      //   47: dup
      //   48: iconst_0
      //   49: aload #10
      //   51: invokevirtual toString : ()Ljava/lang/String;
      //   54: aastore
      //   55: invokevirtual b : ([Ljava/lang/Object;)V
      //   58: aconst_null
      //   59: astore #14
      //   61: aconst_null
      //   62: astore #10
      //   64: bipush #100
      //   66: istore_1
      //   67: invokestatic uptimeMillis : ()J
      //   70: lstore #7
      //   72: aconst_null
      //   73: astore #15
      //   75: aconst_null
      //   76: astore #11
      //   78: aconst_null
      //   79: astore #12
      //   81: aconst_null
      //   82: astore #13
      //   84: lconst_0
      //   85: lstore_3
      //   86: aload_0
      //   87: getfield a : Lcom/blued/android/module/live/im/biz/LiveChat;
      //   90: invokestatic a : (Lcom/blued/android/module/live/im/biz/LiveChat;)Lcn/irisgw/live/LiveChatGrpc$LiveChatBlockingStub;
      //   93: aload_0
      //   94: getfield b : Lcn/irisgw/live/LiveChatOuterClass$LiveMsgRequest;
      //   97: invokevirtual sendMsg : (Lcn/irisgw/live/LiveChatOuterClass$LiveMsgRequest;)Lcn/irisgw/live/LiveChatOuterClass$LiveMsgResponse;
      //   100: astore #9
      //   102: aload #9
      //   104: ifnull -> 149
      //   107: sipush #200
      //   110: istore_1
      //   111: aload #9
      //   113: astore #10
      //   115: aload #9
      //   117: invokevirtual getMsgId : ()J
      //   120: lstore #5
      //   122: lload #5
      //   124: lstore_3
      //   125: sipush #200
      //   128: istore_1
      //   129: goto -> 152
      //   132: astore #11
      //   134: sipush #200
      //   137: istore_1
      //   138: aload #9
      //   140: astore #10
      //   142: aload #12
      //   144: astore #9
      //   146: goto -> 352
      //   149: bipush #100
      //   151: istore_1
      //   152: aload_0
      //   153: getfield c : Lcom/blued/android/module/live/im/LiveIM$OnSendMessageFinishListener;
      //   156: astore #12
      //   158: iload_1
      //   159: istore_2
      //   160: lload_3
      //   161: lstore #5
      //   163: aload #15
      //   165: astore #11
      //   167: aload #12
      //   169: ifnull -> 194
      //   172: aload #13
      //   174: astore #11
      //   176: aload #9
      //   178: astore #10
      //   180: aload #12
      //   182: aload #10
      //   184: invokeinterface onFinish : (Lcn/irisgw/live/LiveChatOuterClass$LiveMsgResponse;)V
      //   189: lload_3
      //   190: lstore #5
      //   192: iload_1
      //   193: istore_2
      //   194: aload_0
      //   195: getfield a : Lcom/blued/android/module/live/im/biz/LiveChat;
      //   198: ldc 'send_message'
      //   200: lload #7
      //   202: iload_2
      //   203: lload #5
      //   205: aload #11
      //   207: invokestatic a : (Lcom/blued/android/module/live/im/biz/LiveChat;Ljava/lang/String;JIJLjava/lang/Exception;)V
      //   210: return
      //   211: astore #11
      //   213: bipush #100
      //   215: istore_1
      //   216: aload #14
      //   218: astore #10
      //   220: aload #12
      //   222: astore #9
      //   224: goto -> 352
      //   227: astore #12
      //   229: aload_0
      //   230: getfield a : Lcom/blued/android/module/live/im/biz/LiveChat;
      //   233: invokestatic b : (Lcom/blued/android/module/live/im/biz/LiveChat;)Lcom/blued/android/module/im/grpc/ChannelManager;
      //   236: aload #12
      //   238: invokevirtual a : (Ljava/lang/Exception;)Lio/grpc/Status;
      //   241: astore #13
      //   243: aload #13
      //   245: invokevirtual getCode : ()Lio/grpc/Status$Code;
      //   248: getstatic io/grpc/Status$Code.UNKNOWN : Lio/grpc/Status$Code;
      //   251: if_acmpne -> 261
      //   254: aload #12
      //   256: astore #9
      //   258: goto -> 279
      //   261: aload #13
      //   263: invokevirtual asException : ()Lio/grpc/StatusException;
      //   266: astore #9
      //   268: aload #13
      //   270: invokevirtual getCode : ()Lio/grpc/Status$Code;
      //   273: invokevirtual value : ()I
      //   276: istore_2
      //   277: iload_2
      //   278: istore_1
      //   279: invokestatic b : ()Z
      //   282: ifeq -> 305
      //   285: invokestatic a : ()Lcom/blued/android/statistics/util/Logger;
      //   288: iconst_2
      //   289: anewarray java/lang/Object
      //   292: dup
      //   293: iconst_0
      //   294: ldc '>> SendMessage Exception : \\n'
      //   296: aastore
      //   297: dup
      //   298: iconst_1
      //   299: aload #12
      //   301: aastore
      //   302: invokevirtual e : ([Ljava/lang/Object;)V
      //   305: aload_0
      //   306: getfield c : Lcom/blued/android/module/live/im/LiveIM$OnSendMessageFinishListener;
      //   309: astore #12
      //   311: iload_1
      //   312: istore_2
      //   313: lload_3
      //   314: lstore #5
      //   316: aload #9
      //   318: astore #11
      //   320: aload #12
      //   322: ifnull -> 194
      //   325: aload #9
      //   327: astore #11
      //   329: goto -> 180
      //   332: astore #11
      //   334: goto -> 352
      //   337: astore #11
      //   339: goto -> 352
      //   342: astore #12
      //   344: aload #11
      //   346: astore #9
      //   348: aload #12
      //   350: astore #11
      //   352: aload_0
      //   353: getfield c : Lcom/blued/android/module/live/im/LiveIM$OnSendMessageFinishListener;
      //   356: astore #12
      //   358: aload #12
      //   360: ifnull -> 372
      //   363: aload #12
      //   365: aload #10
      //   367: invokeinterface onFinish : (Lcn/irisgw/live/LiveChatOuterClass$LiveMsgResponse;)V
      //   372: aload_0
      //   373: getfield a : Lcom/blued/android/module/live/im/biz/LiveChat;
      //   376: ldc 'send_message'
      //   378: lload #7
      //   380: iload_1
      //   381: lconst_0
      //   382: aload #9
      //   384: invokestatic a : (Lcom/blued/android/module/live/im/biz/LiveChat;Ljava/lang/String;JIJLjava/lang/Exception;)V
      //   387: aload #11
      //   389: athrow
      // Exception table:
      //   from	to	target	type
      //   86	102	227	java/lang/Exception
      //   86	102	211	finally
      //   115	122	227	java/lang/Exception
      //   115	122	132	finally
      //   229	254	342	finally
      //   261	268	342	finally
      //   268	277	337	finally
      //   279	305	332	finally
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\live\im\biz\LiveChat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */