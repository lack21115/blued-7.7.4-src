package com.blued.android.module.im.biz.privatechat;

import com.blued.android.module.im.biz.Common;
import com.blued.android.module.im.grpc.ChannelManager;
import com.blued.android.module.im.grpc.IMThreadManager;
import com.blued.android.statistics.util.NamedRunnable;
import com.blued.das.apm.ApmProtos;
import com.blued.im.private_chat.MsgTypeOuterClass;
import com.blued.im.private_chat.PrivateChatOuterClass;
import com.google.protobuf.Any;

public abstract class PrivateChatBase {
  protected ChannelManager a;
  
  protected IMThreadManager b;
  
  public PrivateChatBase(ChannelManager paramChannelManager, IMThreadManager paramIMThreadManager) {
    this.a = paramChannelManager;
    this.b = paramIMThreadManager;
  }
  
  protected abstract ApmProtos.GrpcRequestTypeProto.BUSINESS a();
  
  protected abstract PrivateChatOuterClass.Response a(PrivateChatOuterClass.Request paramRequest);
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, Any paramAny, OnPrivateChatResponseListener paramOnPrivateChatResponseListener) {
    if (this.a != null) {
      if (this.b == null)
        return; 
      try {
        PrivateChatOuterClass.Request request = PrivateChatOuterClass.Request.newBuilder().setCommon(Common.a().b()).setTo(paramInt3).setFrom(paramInt4).setMsgType(MsgTypeOuterClass.MsgType.forNumber(paramInt1)).setLocalId(paramInt2).setBody(paramAny).build();
        this.b.a((Runnable)new SendMessageRunnable(this, request, paramOnPrivateChatResponseListener));
        return;
      } catch (Exception exception) {
        exception.printStackTrace();
      } 
    } 
  }
  
  class SendMessageRunnable extends NamedRunnable {
    private PrivateChatOuterClass.Request b;
    
    private OnPrivateChatResponseListener c;
    
    public SendMessageRunnable(PrivateChatBase this$0, PrivateChatOuterClass.Request param1Request, OnPrivateChatResponseListener param1OnPrivateChatResponseListener) {
      super("private-chat");
      this.b = param1Request;
      this.c = param1OnPrivateChatResponseListener;
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
      //   22: ldc '>> SendPrivateChatMessage Request : '
      //   24: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   27: pop
      //   28: aload #7
      //   30: aload_0
      //   31: getfield b : Lcom/blued/im/private_chat/PrivateChatOuterClass$Request;
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
      //   79: getfield a : Lcom/blued/android/module/im/biz/privatechat/PrivateChatBase;
      //   82: aload_0
      //   83: getfield b : Lcom/blued/im/private_chat/PrivateChatOuterClass$Request;
      //   86: invokevirtual a : (Lcom/blued/im/private_chat/PrivateChatOuterClass$Request;)Lcom/blued/im/private_chat/PrivateChatOuterClass$Response;
      //   89: astore #6
      //   91: aload #6
      //   93: ifnull -> 100
      //   96: sipush #200
      //   99: istore_1
      //   100: iload_1
      //   101: istore_3
      //   102: aload #6
      //   104: astore #7
      //   106: invokestatic b : ()Z
      //   109: ifeq -> 138
      //   112: iload_1
      //   113: istore_3
      //   114: aload #6
      //   116: astore #7
      //   118: invokestatic a : ()Lcom/blued/android/statistics/util/Logger;
      //   121: iconst_2
      //   122: anewarray java/lang/Object
      //   125: dup
      //   126: iconst_0
      //   127: ldc '>> SendPrivateChatMessage response : \\n'
      //   129: aastore
      //   130: dup
      //   131: iconst_1
      //   132: aload #6
      //   134: aastore
      //   135: invokevirtual a : ([Ljava/lang/Object;)V
      //   138: aload #6
      //   140: astore #7
      //   142: aload_0
      //   143: getfield c : Lcom/blued/android/module/im/biz/privatechat/OnPrivateChatResponseListener;
      //   146: ifnull -> 254
      //   149: iload_1
      //   150: getstatic io/grpc/Status$Code.DEADLINE_EXCEEDED : Lio/grpc/Status$Code;
      //   153: invokevirtual value : ()I
      //   156: if_icmpne -> 162
      //   159: goto -> 164
      //   162: iconst_m1
      //   163: istore_2
      //   164: aload #6
      //   166: astore #7
      //   168: aload #6
      //   170: ifnonnull -> 195
      //   173: invokestatic newBuilder : ()Lcom/blued/im/private_chat/PrivateChatOuterClass$Response$Builder;
      //   176: iload_2
      //   177: invokevirtual setCodeValue : (I)Lcom/blued/im/private_chat/PrivateChatOuterClass$Response$Builder;
      //   180: aload_0
      //   181: getfield b : Lcom/blued/im/private_chat/PrivateChatOuterClass$Request;
      //   184: invokevirtual getLocalId : ()I
      //   187: invokevirtual setLocalId : (I)Lcom/blued/im/private_chat/PrivateChatOuterClass$Response$Builder;
      //   190: invokevirtual build : ()Lcom/blued/im/private_chat/PrivateChatOuterClass$Response;
      //   193: astore #7
      //   195: aload #7
      //   197: invokevirtual getCodeValue : ()I
      //   200: istore_2
      //   201: iload_2
      //   202: getstatic com/blued/im/private_chat/CodeOuterClass$Code.PRIVATE_SUCCESS : Lcom/blued/im/private_chat/CodeOuterClass$Code;
      //   205: invokevirtual getNumber : ()I
      //   208: if_icmpne -> 238
      //   211: aload_0
      //   212: getfield c : Lcom/blued/android/module/im/biz/privatechat/OnPrivateChatResponseListener;
      //   215: aload #7
      //   217: invokevirtual getLocalId : ()I
      //   220: aload #7
      //   222: invokevirtual getMsgId : ()J
      //   225: aload #7
      //   227: invokevirtual getResponseTime : ()J
      //   230: invokeinterface onSuccess : (IJJ)V
      //   235: goto -> 254
      //   238: aload_0
      //   239: getfield c : Lcom/blued/android/module/im/biz/privatechat/OnPrivateChatResponseListener;
      //   242: aload #7
      //   244: invokevirtual getLocalId : ()I
      //   247: iload_2
      //   248: aconst_null
      //   249: invokeinterface onFailure : (IILjava/lang/Exception;)V
      //   254: aload_0
      //   255: getfield b : Lcom/blued/im/private_chat/PrivateChatOuterClass$Request;
      //   258: invokevirtual getMsgType : ()Lcom/blued/im/private_chat/MsgTypeOuterClass$MsgType;
      //   261: invokevirtual name : ()Ljava/lang/String;
      //   264: astore #9
      //   266: invokestatic uptimeMillis : ()J
      //   269: lload #4
      //   271: lsub
      //   272: lstore #4
      //   274: aload #7
      //   276: ifnonnull -> 286
      //   279: aload #8
      //   281: astore #6
      //   283: goto -> 293
      //   286: aload #7
      //   288: invokevirtual getRequestId : ()Ljava/lang/String;
      //   291: astore #6
      //   293: invokestatic b : ()Lcom/blued/android/statistics/biz/Apm;
      //   296: aload_0
      //   297: getfield a : Lcom/blued/android/module/im/biz/privatechat/PrivateChatBase;
      //   300: invokevirtual a : ()Lcom/blued/das/apm/ApmProtos$GrpcRequestTypeProto$BUSINESS;
      //   303: aload #9
      //   305: iload_1
      //   306: lload #4
      //   308: aload #6
      //   310: aconst_null
      //   311: aload_0
      //   312: getfield a : Lcom/blued/android/module/im/biz/privatechat/PrivateChatBase;
      //   315: getfield a : Lcom/blued/android/module/im/grpc/ChannelManager;
      //   318: invokevirtual a : ()Ljava/lang/String;
      //   321: aload_0
      //   322: getfield a : Lcom/blued/android/module/im/biz/privatechat/PrivateChatBase;
      //   325: getfield a : Lcom/blued/android/module/im/grpc/ChannelManager;
      //   328: invokevirtual b : ()Ljava/lang/String;
      //   331: invokevirtual a : (Lcom/blued/das/apm/ApmProtos$GrpcRequestTypeProto$BUSINESS;Ljava/lang/String;IJLjava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
      //   334: invokestatic b : ()Z
      //   337: ifeq -> 730
      //   340: invokestatic a : ()Lcom/blued/android/statistics/util/Logger;
      //   343: iconst_2
      //   344: anewarray java/lang/Object
      //   347: dup
      //   348: iconst_0
      //   349: ldc '>> SendPrivateChatMessage spendTime='
      //   351: aastore
      //   352: dup
      //   353: iconst_1
      //   354: lload #4
      //   356: invokestatic valueOf : (J)Ljava/lang/Long;
      //   359: aastore
      //   360: invokevirtual a : ([Ljava/lang/Object;)V
      //   363: return
      //   364: astore #8
      //   366: goto -> 389
      //   369: astore #7
      //   371: aconst_null
      //   372: astore #8
      //   374: aload #8
      //   376: astore #6
      //   378: bipush #100
      //   380: istore_1
      //   381: goto -> 757
      //   384: astore #8
      //   386: aconst_null
      //   387: astore #6
      //   389: iload_1
      //   390: istore_3
      //   391: aload #6
      //   393: astore #7
      //   395: aload_0
      //   396: getfield a : Lcom/blued/android/module/im/biz/privatechat/PrivateChatBase;
      //   399: getfield a : Lcom/blued/android/module/im/grpc/ChannelManager;
      //   402: aload #8
      //   404: invokevirtual a : (Ljava/lang/Exception;)Lio/grpc/Status;
      //   407: astore #13
      //   409: iload_1
      //   410: istore_3
      //   411: aload #6
      //   413: astore #7
      //   415: aload #13
      //   417: invokevirtual getCode : ()Lio/grpc/Status$Code;
      //   420: getstatic io/grpc/Status$Code.UNKNOWN : Lio/grpc/Status$Code;
      //   423: if_acmpne -> 433
      //   426: aload #8
      //   428: astore #7
      //   430: goto -> 465
      //   433: iload_1
      //   434: istore_3
      //   435: aload #6
      //   437: astore #7
      //   439: aload #13
      //   441: invokevirtual asException : ()Lio/grpc/StatusException;
      //   444: astore #10
      //   446: iload_1
      //   447: istore_3
      //   448: aload #10
      //   450: astore #9
      //   452: aload #13
      //   454: invokevirtual getCode : ()Lio/grpc/Status$Code;
      //   457: invokevirtual value : ()I
      //   460: istore_1
      //   461: aload #10
      //   463: astore #7
      //   465: iload_1
      //   466: istore_3
      //   467: aload #7
      //   469: astore #9
      //   471: invokestatic b : ()Z
      //   474: ifeq -> 503
      //   477: iload_1
      //   478: istore_3
      //   479: aload #7
      //   481: astore #9
      //   483: invokestatic a : ()Lcom/blued/android/statistics/util/Logger;
      //   486: iconst_2
      //   487: anewarray java/lang/Object
      //   490: dup
      //   491: iconst_0
      //   492: ldc '>> SendPrivateChatMessage Exception : \\n'
      //   494: aastore
      //   495: dup
      //   496: iconst_1
      //   497: aload #8
      //   499: aastore
      //   500: invokevirtual d : ([Ljava/lang/Object;)V
      //   503: aload #6
      //   505: astore #8
      //   507: aload_0
      //   508: getfield c : Lcom/blued/android/module/im/biz/privatechat/OnPrivateChatResponseListener;
      //   511: ifnull -> 620
      //   514: iload_1
      //   515: getstatic io/grpc/Status$Code.DEADLINE_EXCEEDED : Lio/grpc/Status$Code;
      //   518: invokevirtual value : ()I
      //   521: if_icmpne -> 527
      //   524: goto -> 529
      //   527: iconst_m1
      //   528: istore_2
      //   529: aload #6
      //   531: astore #8
      //   533: aload #6
      //   535: ifnonnull -> 560
      //   538: invokestatic newBuilder : ()Lcom/blued/im/private_chat/PrivateChatOuterClass$Response$Builder;
      //   541: iload_2
      //   542: invokevirtual setCodeValue : (I)Lcom/blued/im/private_chat/PrivateChatOuterClass$Response$Builder;
      //   545: aload_0
      //   546: getfield b : Lcom/blued/im/private_chat/PrivateChatOuterClass$Request;
      //   549: invokevirtual getLocalId : ()I
      //   552: invokevirtual setLocalId : (I)Lcom/blued/im/private_chat/PrivateChatOuterClass$Response$Builder;
      //   555: invokevirtual build : ()Lcom/blued/im/private_chat/PrivateChatOuterClass$Response;
      //   558: astore #8
      //   560: aload #8
      //   562: invokevirtual getCodeValue : ()I
      //   565: istore_2
      //   566: iload_2
      //   567: getstatic com/blued/im/private_chat/CodeOuterClass$Code.PRIVATE_SUCCESS : Lcom/blued/im/private_chat/CodeOuterClass$Code;
      //   570: invokevirtual getNumber : ()I
      //   573: if_icmpne -> 603
      //   576: aload_0
      //   577: getfield c : Lcom/blued/android/module/im/biz/privatechat/OnPrivateChatResponseListener;
      //   580: aload #8
      //   582: invokevirtual getLocalId : ()I
      //   585: aload #8
      //   587: invokevirtual getMsgId : ()J
      //   590: aload #8
      //   592: invokevirtual getResponseTime : ()J
      //   595: invokeinterface onSuccess : (IJJ)V
      //   600: goto -> 620
      //   603: aload_0
      //   604: getfield c : Lcom/blued/android/module/im/biz/privatechat/OnPrivateChatResponseListener;
      //   607: aload #8
      //   609: invokevirtual getLocalId : ()I
      //   612: iload_2
      //   613: aload #7
      //   615: invokeinterface onFailure : (IILjava/lang/Exception;)V
      //   620: aload_0
      //   621: getfield b : Lcom/blued/im/private_chat/PrivateChatOuterClass$Request;
      //   624: invokevirtual getMsgType : ()Lcom/blued/im/private_chat/MsgTypeOuterClass$MsgType;
      //   627: invokevirtual name : ()Ljava/lang/String;
      //   630: astore #9
      //   632: invokestatic uptimeMillis : ()J
      //   635: lload #4
      //   637: lsub
      //   638: lstore #4
      //   640: aload #8
      //   642: ifnonnull -> 652
      //   645: aload #12
      //   647: astore #6
      //   649: goto -> 659
      //   652: aload #8
      //   654: invokevirtual getRequestId : ()Ljava/lang/String;
      //   657: astore #6
      //   659: invokestatic b : ()Lcom/blued/android/statistics/biz/Apm;
      //   662: aload_0
      //   663: getfield a : Lcom/blued/android/module/im/biz/privatechat/PrivateChatBase;
      //   666: invokevirtual a : ()Lcom/blued/das/apm/ApmProtos$GrpcRequestTypeProto$BUSINESS;
      //   669: aload #9
      //   671: iload_1
      //   672: lload #4
      //   674: aload #6
      //   676: aload #7
      //   678: aload_0
      //   679: getfield a : Lcom/blued/android/module/im/biz/privatechat/PrivateChatBase;
      //   682: getfield a : Lcom/blued/android/module/im/grpc/ChannelManager;
      //   685: invokevirtual a : ()Ljava/lang/String;
      //   688: aload_0
      //   689: getfield a : Lcom/blued/android/module/im/biz/privatechat/PrivateChatBase;
      //   692: getfield a : Lcom/blued/android/module/im/grpc/ChannelManager;
      //   695: invokevirtual b : ()Ljava/lang/String;
      //   698: invokevirtual a : (Lcom/blued/das/apm/ApmProtos$GrpcRequestTypeProto$BUSINESS;Ljava/lang/String;IJLjava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
      //   701: invokestatic b : ()Z
      //   704: ifeq -> 730
      //   707: invokestatic a : ()Lcom/blued/android/statistics/util/Logger;
      //   710: iconst_2
      //   711: anewarray java/lang/Object
      //   714: dup
      //   715: iconst_0
      //   716: ldc '>> SendPrivateChatMessage spendTime='
      //   718: aastore
      //   719: dup
      //   720: iconst_1
      //   721: lload #4
      //   723: invokestatic valueOf : (J)Ljava/lang/Long;
      //   726: aastore
      //   727: invokevirtual a : ([Ljava/lang/Object;)V
      //   730: return
      //   731: astore #7
      //   733: iload_3
      //   734: istore_1
      //   735: aload #9
      //   737: astore #8
      //   739: goto -> 757
      //   742: astore #9
      //   744: iload_3
      //   745: istore_1
      //   746: aconst_null
      //   747: astore #8
      //   749: aload #7
      //   751: astore #6
      //   753: aload #9
      //   755: astore #7
      //   757: aload #6
      //   759: astore #9
      //   761: aload_0
      //   762: getfield c : Lcom/blued/android/module/im/biz/privatechat/OnPrivateChatResponseListener;
      //   765: ifnull -> 874
      //   768: iload_1
      //   769: getstatic io/grpc/Status$Code.DEADLINE_EXCEEDED : Lio/grpc/Status$Code;
      //   772: invokevirtual value : ()I
      //   775: if_icmpne -> 781
      //   778: goto -> 783
      //   781: iconst_m1
      //   782: istore_2
      //   783: aload #6
      //   785: astore #9
      //   787: aload #6
      //   789: ifnonnull -> 814
      //   792: invokestatic newBuilder : ()Lcom/blued/im/private_chat/PrivateChatOuterClass$Response$Builder;
      //   795: iload_2
      //   796: invokevirtual setCodeValue : (I)Lcom/blued/im/private_chat/PrivateChatOuterClass$Response$Builder;
      //   799: aload_0
      //   800: getfield b : Lcom/blued/im/private_chat/PrivateChatOuterClass$Request;
      //   803: invokevirtual getLocalId : ()I
      //   806: invokevirtual setLocalId : (I)Lcom/blued/im/private_chat/PrivateChatOuterClass$Response$Builder;
      //   809: invokevirtual build : ()Lcom/blued/im/private_chat/PrivateChatOuterClass$Response;
      //   812: astore #9
      //   814: aload #9
      //   816: invokevirtual getCodeValue : ()I
      //   819: istore_2
      //   820: iload_2
      //   821: getstatic com/blued/im/private_chat/CodeOuterClass$Code.PRIVATE_SUCCESS : Lcom/blued/im/private_chat/CodeOuterClass$Code;
      //   824: invokevirtual getNumber : ()I
      //   827: if_icmpne -> 857
      //   830: aload_0
      //   831: getfield c : Lcom/blued/android/module/im/biz/privatechat/OnPrivateChatResponseListener;
      //   834: aload #9
      //   836: invokevirtual getLocalId : ()I
      //   839: aload #9
      //   841: invokevirtual getMsgId : ()J
      //   844: aload #9
      //   846: invokevirtual getResponseTime : ()J
      //   849: invokeinterface onSuccess : (IJJ)V
      //   854: goto -> 874
      //   857: aload_0
      //   858: getfield c : Lcom/blued/android/module/im/biz/privatechat/OnPrivateChatResponseListener;
      //   861: aload #9
      //   863: invokevirtual getLocalId : ()I
      //   866: iload_2
      //   867: aload #8
      //   869: invokeinterface onFailure : (IILjava/lang/Exception;)V
      //   874: aload_0
      //   875: getfield b : Lcom/blued/im/private_chat/PrivateChatOuterClass$Request;
      //   878: invokevirtual getMsgType : ()Lcom/blued/im/private_chat/MsgTypeOuterClass$MsgType;
      //   881: invokevirtual name : ()Ljava/lang/String;
      //   884: astore #10
      //   886: invokestatic uptimeMillis : ()J
      //   889: lload #4
      //   891: lsub
      //   892: lstore #4
      //   894: aload #9
      //   896: ifnonnull -> 906
      //   899: aload #11
      //   901: astore #6
      //   903: goto -> 913
      //   906: aload #9
      //   908: invokevirtual getRequestId : ()Ljava/lang/String;
      //   911: astore #6
      //   913: invokestatic b : ()Lcom/blued/android/statistics/biz/Apm;
      //   916: aload_0
      //   917: getfield a : Lcom/blued/android/module/im/biz/privatechat/PrivateChatBase;
      //   920: invokevirtual a : ()Lcom/blued/das/apm/ApmProtos$GrpcRequestTypeProto$BUSINESS;
      //   923: aload #10
      //   925: iload_1
      //   926: lload #4
      //   928: aload #6
      //   930: aload #8
      //   932: aload_0
      //   933: getfield a : Lcom/blued/android/module/im/biz/privatechat/PrivateChatBase;
      //   936: getfield a : Lcom/blued/android/module/im/grpc/ChannelManager;
      //   939: invokevirtual a : ()Ljava/lang/String;
      //   942: aload_0
      //   943: getfield a : Lcom/blued/android/module/im/biz/privatechat/PrivateChatBase;
      //   946: getfield a : Lcom/blued/android/module/im/grpc/ChannelManager;
      //   949: invokevirtual b : ()Ljava/lang/String;
      //   952: invokevirtual a : (Lcom/blued/das/apm/ApmProtos$GrpcRequestTypeProto$BUSINESS;Ljava/lang/String;IJLjava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
      //   955: invokestatic b : ()Z
      //   958: ifeq -> 984
      //   961: invokestatic a : ()Lcom/blued/android/statistics/util/Logger;
      //   964: iconst_2
      //   965: anewarray java/lang/Object
      //   968: dup
      //   969: iconst_0
      //   970: ldc '>> SendPrivateChatMessage spendTime='
      //   972: aastore
      //   973: dup
      //   974: iconst_1
      //   975: lload #4
      //   977: invokestatic valueOf : (J)Ljava/lang/Long;
      //   980: aastore
      //   981: invokevirtual a : ([Ljava/lang/Object;)V
      //   984: aload #7
      //   986: athrow
      // Exception table:
      //   from	to	target	type
      //   78	91	384	java/lang/Exception
      //   78	91	369	finally
      //   106	112	364	java/lang/Exception
      //   106	112	742	finally
      //   118	138	364	java/lang/Exception
      //   118	138	742	finally
      //   395	409	742	finally
      //   415	426	742	finally
      //   439	446	742	finally
      //   452	461	731	finally
      //   471	477	731	finally
      //   483	503	731	finally
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\im\biz\privatechat\PrivateChatBase.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */