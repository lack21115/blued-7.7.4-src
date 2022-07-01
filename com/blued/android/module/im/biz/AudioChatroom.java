package com.blued.android.module.im.biz;

import com.blued.android.module.im.grpc.ChannelManager;
import com.blued.android.module.im.grpc.IMThreadManager;
import com.blued.android.statistics.util.NamedRunnable;
import com.blued.im.audio_chatroom.AudioChatroomOuterClass;

public final class AudioChatroom {
  private ChannelManager a;
  
  private IMThreadManager b;
  
  public AudioChatroom(ChannelManager paramChannelManager, IMThreadManager paramIMThreadManager) {
    this.a = paramChannelManager;
    this.b = paramIMThreadManager;
  }
  
  public void a(AudioChatroomOuterClass.Request.Builder paramBuilder, OnAudioChatroomResponseListener paramOnAudioChatroomResponseListener) {
    if (this.a != null) {
      if (this.b == null)
        return; 
      AudioChatroomOuterClass.Request request = paramBuilder.setCommon(Common.a().b()).build();
      this.b.a((Runnable)new SendMessageRunnable(this, request, paramOnAudioChatroomResponseListener));
    } 
  }
  
  public static interface OnAudioChatroomResponseListener {
    void a(int param1Int, Exception param1Exception);
    
    void a(long param1Long);
  }
  
  class SendMessageRunnable extends NamedRunnable {
    private AudioChatroomOuterClass.Request b;
    
    private AudioChatroom.OnAudioChatroomResponseListener c;
    
    public SendMessageRunnable(AudioChatroom this$0, AudioChatroomOuterClass.Request param1Request, AudioChatroom.OnAudioChatroomResponseListener param1OnAudioChatroomResponseListener) {
      super("audio-chat");
      this.b = param1Request;
      this.c = param1OnAudioChatroomResponseListener;
    }
    
    public void a() {
      // Byte code:
      //   0: invokestatic b : ()Z
      //   3: ifeq -> 58
      //   6: invokestatic a : ()Lcom/blued/android/statistics/util/Logger;
      //   9: astore #6
      //   11: new java/lang/StringBuilder
      //   14: dup
      //   15: invokespecial <init> : ()V
      //   18: astore #7
      //   20: aload #7
      //   22: ldc '>> SendAudioChatroomMessage Request : '
      //   24: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   27: pop
      //   28: aload #7
      //   30: aload_0
      //   31: getfield b : Lcom/blued/im/audio_chatroom/AudioChatroomOuterClass$Request;
      //   34: invokevirtual toString : ()Ljava/lang/String;
      //   37: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   40: pop
      //   41: aload #6
      //   43: iconst_1
      //   44: anewarray java/lang/Object
      //   47: dup
      //   48: iconst_0
      //   49: aload #7
      //   51: invokevirtual toString : ()Ljava/lang/String;
      //   54: aastore
      //   55: invokevirtual b : ([Ljava/lang/Object;)V
      //   58: invokestatic uptimeMillis : ()J
      //   61: lstore #4
      //   63: bipush #100
      //   65: istore_1
      //   66: bipush #-2
      //   68: istore_2
      //   69: aconst_null
      //   70: astore #12
      //   72: aconst_null
      //   73: astore #11
      //   75: aconst_null
      //   76: astore #8
      //   78: aload_0
      //   79: getfield a : Lcom/blued/android/module/im/biz/AudioChatroom;
      //   82: invokestatic a : (Lcom/blued/android/module/im/biz/AudioChatroom;)Lcom/blued/android/module/im/grpc/ChannelManager;
      //   85: invokevirtual d : ()Lio/grpc/Channel;
      //   88: invokestatic newBlockingStub : (Lio/grpc/Channel;)Lcom/blued/im/audio_chatroom/AudioChatroomGrpc$AudioChatroomBlockingStub;
      //   91: astore #6
      //   93: aload_0
      //   94: getfield a : Lcom/blued/android/module/im/biz/AudioChatroom;
      //   97: invokestatic a : (Lcom/blued/android/module/im/biz/AudioChatroom;)Lcom/blued/android/module/im/grpc/ChannelManager;
      //   100: aload #6
      //   102: invokevirtual a : (Lio/grpc/stub/AbstractStub;)Lio/grpc/stub/AbstractStub;
      //   105: checkcast com/blued/im/audio_chatroom/AudioChatroomGrpc$AudioChatroomBlockingStub
      //   108: ldc 'gzip'
      //   110: invokevirtual withCompression : (Ljava/lang/String;)Lio/grpc/stub/AbstractStub;
      //   113: checkcast com/blued/im/audio_chatroom/AudioChatroomGrpc$AudioChatroomBlockingStub
      //   116: ldc2_w 30
      //   119: getstatic java/util/concurrent/TimeUnit.SECONDS : Ljava/util/concurrent/TimeUnit;
      //   122: invokevirtual withDeadlineAfter : (JLjava/util/concurrent/TimeUnit;)Lio/grpc/stub/AbstractStub;
      //   125: checkcast com/blued/im/audio_chatroom/AudioChatroomGrpc$AudioChatroomBlockingStub
      //   128: aload_0
      //   129: getfield b : Lcom/blued/im/audio_chatroom/AudioChatroomOuterClass$Request;
      //   132: invokevirtual send : (Lcom/blued/im/audio_chatroom/AudioChatroomOuterClass$Request;)Lcom/blued/im/audio_chatroom/AudioChatroomOuterClass$Response;
      //   135: astore #6
      //   137: aload #6
      //   139: ifnull -> 146
      //   142: sipush #200
      //   145: istore_1
      //   146: iload_1
      //   147: istore_3
      //   148: aload #6
      //   150: astore #7
      //   152: invokestatic b : ()Z
      //   155: ifeq -> 184
      //   158: iload_1
      //   159: istore_3
      //   160: aload #6
      //   162: astore #7
      //   164: invokestatic a : ()Lcom/blued/android/statistics/util/Logger;
      //   167: iconst_2
      //   168: anewarray java/lang/Object
      //   171: dup
      //   172: iconst_0
      //   173: ldc '>> SendAudioChatroomMessage response : \\n'
      //   175: aastore
      //   176: dup
      //   177: iconst_1
      //   178: aload #6
      //   180: aastore
      //   181: invokevirtual a : ([Ljava/lang/Object;)V
      //   184: aload #6
      //   186: astore #7
      //   188: aload_0
      //   189: getfield c : Lcom/blued/android/module/im/biz/AudioChatroom$OnAudioChatroomResponseListener;
      //   192: ifnull -> 275
      //   195: iload_1
      //   196: getstatic io/grpc/Status$Code.DEADLINE_EXCEEDED : Lio/grpc/Status$Code;
      //   199: invokevirtual value : ()I
      //   202: if_icmpne -> 208
      //   205: goto -> 210
      //   208: iconst_m1
      //   209: istore_2
      //   210: aload #6
      //   212: astore #7
      //   214: aload #6
      //   216: ifnonnull -> 231
      //   219: invokestatic newBuilder : ()Lcom/blued/im/audio_chatroom/AudioChatroomOuterClass$Response$Builder;
      //   222: iload_2
      //   223: invokevirtual setCodeValue : (I)Lcom/blued/im/audio_chatroom/AudioChatroomOuterClass$Response$Builder;
      //   226: invokevirtual build : ()Lcom/blued/im/audio_chatroom/AudioChatroomOuterClass$Response;
      //   229: astore #7
      //   231: aload #7
      //   233: invokevirtual getCodeValue : ()I
      //   236: istore_2
      //   237: iload_2
      //   238: getstatic com/blued/im/audio_chatroom/AudioCode$Code.AUDIO_SEND_SUCCESS : Lcom/blued/im/audio_chatroom/AudioCode$Code;
      //   241: invokevirtual getNumber : ()I
      //   244: if_icmpne -> 264
      //   247: aload_0
      //   248: getfield c : Lcom/blued/android/module/im/biz/AudioChatroom$OnAudioChatroomResponseListener;
      //   251: aload #7
      //   253: invokevirtual getResponseTime : ()J
      //   256: invokeinterface a : (J)V
      //   261: goto -> 275
      //   264: aload_0
      //   265: getfield c : Lcom/blued/android/module/im/biz/AudioChatroom$OnAudioChatroomResponseListener;
      //   268: iload_2
      //   269: aconst_null
      //   270: invokeinterface a : (ILjava/lang/Exception;)V
      //   275: aload_0
      //   276: getfield b : Lcom/blued/im/audio_chatroom/AudioChatroomOuterClass$Request;
      //   279: invokevirtual getMsgType : ()Lcom/blued/im/audio_chatroom/AudioMsgType$MsgType;
      //   282: invokevirtual name : ()Ljava/lang/String;
      //   285: astore #9
      //   287: invokestatic uptimeMillis : ()J
      //   290: lload #4
      //   292: lsub
      //   293: lstore #4
      //   295: aload #7
      //   297: ifnonnull -> 307
      //   300: aload #8
      //   302: astore #6
      //   304: goto -> 314
      //   307: aload #7
      //   309: invokevirtual getRequestId : ()Ljava/lang/String;
      //   312: astore #6
      //   314: invokestatic b : ()Lcom/blued/android/statistics/biz/Apm;
      //   317: getstatic com/blued/das/apm/ApmProtos$GrpcRequestTypeProto$BUSINESS.YY : Lcom/blued/das/apm/ApmProtos$GrpcRequestTypeProto$BUSINESS;
      //   320: aload #9
      //   322: iload_1
      //   323: lload #4
      //   325: aload #6
      //   327: aconst_null
      //   328: aload_0
      //   329: getfield a : Lcom/blued/android/module/im/biz/AudioChatroom;
      //   332: invokestatic a : (Lcom/blued/android/module/im/biz/AudioChatroom;)Lcom/blued/android/module/im/grpc/ChannelManager;
      //   335: invokevirtual a : ()Ljava/lang/String;
      //   338: aload_0
      //   339: getfield a : Lcom/blued/android/module/im/biz/AudioChatroom;
      //   342: invokestatic a : (Lcom/blued/android/module/im/biz/AudioChatroom;)Lcom/blued/android/module/im/grpc/ChannelManager;
      //   345: invokevirtual b : ()Ljava/lang/String;
      //   348: invokevirtual a : (Lcom/blued/das/apm/ApmProtos$GrpcRequestTypeProto$BUSINESS;Ljava/lang/String;IJLjava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
      //   351: invokestatic b : ()Z
      //   354: ifeq -> 718
      //   357: invokestatic a : ()Lcom/blued/android/statistics/util/Logger;
      //   360: iconst_2
      //   361: anewarray java/lang/Object
      //   364: dup
      //   365: iconst_0
      //   366: ldc '>> SendAudioChatroomMessage spendTime='
      //   368: aastore
      //   369: dup
      //   370: iconst_1
      //   371: lload #4
      //   373: invokestatic valueOf : (J)Ljava/lang/Long;
      //   376: aastore
      //   377: invokevirtual a : ([Ljava/lang/Object;)V
      //   380: return
      //   381: astore #8
      //   383: goto -> 406
      //   386: astore #7
      //   388: aconst_null
      //   389: astore #8
      //   391: aload #8
      //   393: astore #6
      //   395: bipush #100
      //   397: istore_1
      //   398: goto -> 745
      //   401: astore #8
      //   403: aconst_null
      //   404: astore #6
      //   406: iload_1
      //   407: istore_3
      //   408: aload #6
      //   410: astore #7
      //   412: aload_0
      //   413: getfield a : Lcom/blued/android/module/im/biz/AudioChatroom;
      //   416: invokestatic a : (Lcom/blued/android/module/im/biz/AudioChatroom;)Lcom/blued/android/module/im/grpc/ChannelManager;
      //   419: aload #8
      //   421: invokevirtual a : (Ljava/lang/Exception;)Lio/grpc/Status;
      //   424: astore #13
      //   426: iload_1
      //   427: istore_3
      //   428: aload #6
      //   430: astore #7
      //   432: aload #13
      //   434: invokevirtual getCode : ()Lio/grpc/Status$Code;
      //   437: getstatic io/grpc/Status$Code.UNKNOWN : Lio/grpc/Status$Code;
      //   440: if_acmpne -> 450
      //   443: aload #8
      //   445: astore #7
      //   447: goto -> 482
      //   450: iload_1
      //   451: istore_3
      //   452: aload #6
      //   454: astore #7
      //   456: aload #13
      //   458: invokevirtual asException : ()Lio/grpc/StatusException;
      //   461: astore #10
      //   463: iload_1
      //   464: istore_3
      //   465: aload #10
      //   467: astore #9
      //   469: aload #13
      //   471: invokevirtual getCode : ()Lio/grpc/Status$Code;
      //   474: invokevirtual value : ()I
      //   477: istore_1
      //   478: aload #10
      //   480: astore #7
      //   482: iload_1
      //   483: istore_3
      //   484: aload #7
      //   486: astore #9
      //   488: invokestatic b : ()Z
      //   491: ifeq -> 520
      //   494: iload_1
      //   495: istore_3
      //   496: aload #7
      //   498: astore #9
      //   500: invokestatic a : ()Lcom/blued/android/statistics/util/Logger;
      //   503: iconst_2
      //   504: anewarray java/lang/Object
      //   507: dup
      //   508: iconst_0
      //   509: ldc '>> SendAudioChatroomMessage Exception : \\n'
      //   511: aastore
      //   512: dup
      //   513: iconst_1
      //   514: aload #8
      //   516: aastore
      //   517: invokevirtual d : ([Ljava/lang/Object;)V
      //   520: aload #6
      //   522: astore #8
      //   524: aload_0
      //   525: getfield c : Lcom/blued/android/module/im/biz/AudioChatroom$OnAudioChatroomResponseListener;
      //   528: ifnull -> 612
      //   531: iload_1
      //   532: getstatic io/grpc/Status$Code.DEADLINE_EXCEEDED : Lio/grpc/Status$Code;
      //   535: invokevirtual value : ()I
      //   538: if_icmpne -> 544
      //   541: goto -> 546
      //   544: iconst_m1
      //   545: istore_2
      //   546: aload #6
      //   548: astore #8
      //   550: aload #6
      //   552: ifnonnull -> 567
      //   555: invokestatic newBuilder : ()Lcom/blued/im/audio_chatroom/AudioChatroomOuterClass$Response$Builder;
      //   558: iload_2
      //   559: invokevirtual setCodeValue : (I)Lcom/blued/im/audio_chatroom/AudioChatroomOuterClass$Response$Builder;
      //   562: invokevirtual build : ()Lcom/blued/im/audio_chatroom/AudioChatroomOuterClass$Response;
      //   565: astore #8
      //   567: aload #8
      //   569: invokevirtual getCodeValue : ()I
      //   572: istore_2
      //   573: iload_2
      //   574: getstatic com/blued/im/audio_chatroom/AudioCode$Code.AUDIO_SEND_SUCCESS : Lcom/blued/im/audio_chatroom/AudioCode$Code;
      //   577: invokevirtual getNumber : ()I
      //   580: if_icmpne -> 600
      //   583: aload_0
      //   584: getfield c : Lcom/blued/android/module/im/biz/AudioChatroom$OnAudioChatroomResponseListener;
      //   587: aload #8
      //   589: invokevirtual getResponseTime : ()J
      //   592: invokeinterface a : (J)V
      //   597: goto -> 612
      //   600: aload_0
      //   601: getfield c : Lcom/blued/android/module/im/biz/AudioChatroom$OnAudioChatroomResponseListener;
      //   604: iload_2
      //   605: aload #7
      //   607: invokeinterface a : (ILjava/lang/Exception;)V
      //   612: aload_0
      //   613: getfield b : Lcom/blued/im/audio_chatroom/AudioChatroomOuterClass$Request;
      //   616: invokevirtual getMsgType : ()Lcom/blued/im/audio_chatroom/AudioMsgType$MsgType;
      //   619: invokevirtual name : ()Ljava/lang/String;
      //   622: astore #9
      //   624: invokestatic uptimeMillis : ()J
      //   627: lload #4
      //   629: lsub
      //   630: lstore #4
      //   632: aload #8
      //   634: ifnonnull -> 644
      //   637: aload #12
      //   639: astore #6
      //   641: goto -> 651
      //   644: aload #8
      //   646: invokevirtual getRequestId : ()Ljava/lang/String;
      //   649: astore #6
      //   651: invokestatic b : ()Lcom/blued/android/statistics/biz/Apm;
      //   654: getstatic com/blued/das/apm/ApmProtos$GrpcRequestTypeProto$BUSINESS.YY : Lcom/blued/das/apm/ApmProtos$GrpcRequestTypeProto$BUSINESS;
      //   657: aload #9
      //   659: iload_1
      //   660: lload #4
      //   662: aload #6
      //   664: aload #7
      //   666: aload_0
      //   667: getfield a : Lcom/blued/android/module/im/biz/AudioChatroom;
      //   670: invokestatic a : (Lcom/blued/android/module/im/biz/AudioChatroom;)Lcom/blued/android/module/im/grpc/ChannelManager;
      //   673: invokevirtual a : ()Ljava/lang/String;
      //   676: aload_0
      //   677: getfield a : Lcom/blued/android/module/im/biz/AudioChatroom;
      //   680: invokestatic a : (Lcom/blued/android/module/im/biz/AudioChatroom;)Lcom/blued/android/module/im/grpc/ChannelManager;
      //   683: invokevirtual b : ()Ljava/lang/String;
      //   686: invokevirtual a : (Lcom/blued/das/apm/ApmProtos$GrpcRequestTypeProto$BUSINESS;Ljava/lang/String;IJLjava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
      //   689: invokestatic b : ()Z
      //   692: ifeq -> 718
      //   695: invokestatic a : ()Lcom/blued/android/statistics/util/Logger;
      //   698: iconst_2
      //   699: anewarray java/lang/Object
      //   702: dup
      //   703: iconst_0
      //   704: ldc '>> SendAudioChatroomMessage spendTime='
      //   706: aastore
      //   707: dup
      //   708: iconst_1
      //   709: lload #4
      //   711: invokestatic valueOf : (J)Ljava/lang/Long;
      //   714: aastore
      //   715: invokevirtual a : ([Ljava/lang/Object;)V
      //   718: return
      //   719: astore #7
      //   721: iload_3
      //   722: istore_1
      //   723: aload #9
      //   725: astore #8
      //   727: goto -> 745
      //   730: astore #9
      //   732: iload_3
      //   733: istore_1
      //   734: aconst_null
      //   735: astore #8
      //   737: aload #7
      //   739: astore #6
      //   741: aload #9
      //   743: astore #7
      //   745: aload #6
      //   747: astore #9
      //   749: aload_0
      //   750: getfield c : Lcom/blued/android/module/im/biz/AudioChatroom$OnAudioChatroomResponseListener;
      //   753: ifnull -> 837
      //   756: iload_1
      //   757: getstatic io/grpc/Status$Code.DEADLINE_EXCEEDED : Lio/grpc/Status$Code;
      //   760: invokevirtual value : ()I
      //   763: if_icmpne -> 769
      //   766: goto -> 771
      //   769: iconst_m1
      //   770: istore_2
      //   771: aload #6
      //   773: astore #9
      //   775: aload #6
      //   777: ifnonnull -> 792
      //   780: invokestatic newBuilder : ()Lcom/blued/im/audio_chatroom/AudioChatroomOuterClass$Response$Builder;
      //   783: iload_2
      //   784: invokevirtual setCodeValue : (I)Lcom/blued/im/audio_chatroom/AudioChatroomOuterClass$Response$Builder;
      //   787: invokevirtual build : ()Lcom/blued/im/audio_chatroom/AudioChatroomOuterClass$Response;
      //   790: astore #9
      //   792: aload #9
      //   794: invokevirtual getCodeValue : ()I
      //   797: istore_2
      //   798: iload_2
      //   799: getstatic com/blued/im/audio_chatroom/AudioCode$Code.AUDIO_SEND_SUCCESS : Lcom/blued/im/audio_chatroom/AudioCode$Code;
      //   802: invokevirtual getNumber : ()I
      //   805: if_icmpne -> 825
      //   808: aload_0
      //   809: getfield c : Lcom/blued/android/module/im/biz/AudioChatroom$OnAudioChatroomResponseListener;
      //   812: aload #9
      //   814: invokevirtual getResponseTime : ()J
      //   817: invokeinterface a : (J)V
      //   822: goto -> 837
      //   825: aload_0
      //   826: getfield c : Lcom/blued/android/module/im/biz/AudioChatroom$OnAudioChatroomResponseListener;
      //   829: iload_2
      //   830: aload #8
      //   832: invokeinterface a : (ILjava/lang/Exception;)V
      //   837: aload_0
      //   838: getfield b : Lcom/blued/im/audio_chatroom/AudioChatroomOuterClass$Request;
      //   841: invokevirtual getMsgType : ()Lcom/blued/im/audio_chatroom/AudioMsgType$MsgType;
      //   844: invokevirtual name : ()Ljava/lang/String;
      //   847: astore #10
      //   849: invokestatic uptimeMillis : ()J
      //   852: lload #4
      //   854: lsub
      //   855: lstore #4
      //   857: aload #9
      //   859: ifnonnull -> 869
      //   862: aload #11
      //   864: astore #6
      //   866: goto -> 876
      //   869: aload #9
      //   871: invokevirtual getRequestId : ()Ljava/lang/String;
      //   874: astore #6
      //   876: invokestatic b : ()Lcom/blued/android/statistics/biz/Apm;
      //   879: getstatic com/blued/das/apm/ApmProtos$GrpcRequestTypeProto$BUSINESS.YY : Lcom/blued/das/apm/ApmProtos$GrpcRequestTypeProto$BUSINESS;
      //   882: aload #10
      //   884: iload_1
      //   885: lload #4
      //   887: aload #6
      //   889: aload #8
      //   891: aload_0
      //   892: getfield a : Lcom/blued/android/module/im/biz/AudioChatroom;
      //   895: invokestatic a : (Lcom/blued/android/module/im/biz/AudioChatroom;)Lcom/blued/android/module/im/grpc/ChannelManager;
      //   898: invokevirtual a : ()Ljava/lang/String;
      //   901: aload_0
      //   902: getfield a : Lcom/blued/android/module/im/biz/AudioChatroom;
      //   905: invokestatic a : (Lcom/blued/android/module/im/biz/AudioChatroom;)Lcom/blued/android/module/im/grpc/ChannelManager;
      //   908: invokevirtual b : ()Ljava/lang/String;
      //   911: invokevirtual a : (Lcom/blued/das/apm/ApmProtos$GrpcRequestTypeProto$BUSINESS;Ljava/lang/String;IJLjava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
      //   914: invokestatic b : ()Z
      //   917: ifeq -> 943
      //   920: invokestatic a : ()Lcom/blued/android/statistics/util/Logger;
      //   923: iconst_2
      //   924: anewarray java/lang/Object
      //   927: dup
      //   928: iconst_0
      //   929: ldc '>> SendAudioChatroomMessage spendTime='
      //   931: aastore
      //   932: dup
      //   933: iconst_1
      //   934: lload #4
      //   936: invokestatic valueOf : (J)Ljava/lang/Long;
      //   939: aastore
      //   940: invokevirtual a : ([Ljava/lang/Object;)V
      //   943: aload #7
      //   945: athrow
      // Exception table:
      //   from	to	target	type
      //   78	137	401	java/lang/Exception
      //   78	137	386	finally
      //   152	158	381	java/lang/Exception
      //   152	158	730	finally
      //   164	184	381	java/lang/Exception
      //   164	184	730	finally
      //   412	426	730	finally
      //   432	443	730	finally
      //   456	463	730	finally
      //   469	478	719	finally
      //   488	494	719	finally
      //   500	520	719	finally
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\im\biz\AudioChatroom.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */