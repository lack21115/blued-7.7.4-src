package com.blued.android.chat.grpc.utils;

import android.text.TextUtils;
import com.blued.android.chat.ChatManager;
import com.blued.android.chat.data.MsgType;
import com.blued.android.chat.grpc.ClientType;
import com.blued.android.chat.grpc.PrivateChatManager;
import com.blued.android.chat.model.ChattingModel;
import com.blued.im.private_chat.MsgBodyExtraOuterClass;
import com.blued.im.private_chat.MsgBodyOuterClass;
import com.blued.im.private_chat.PrivateChatOuterClass;
import com.blued.im.private_chat.PushBodyOuterClass;
import com.blued.im.private_chat.PushProfileOuterClass;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.protobuf.Any;
import com.google.protobuf.Message;

public class MsgConverter {
  private static final String TAG = "MsgConverter";
  
  public static int convertErrorCode(int paramInt) {
    switch (paramInt) {
      default:
        return -1;
      case 14:
        return 19;
      case 12:
        return 18;
      case 11:
        return 16;
      case 10:
        return 13;
      case 9:
        return 11;
      case 8:
        return 10;
      case 7:
        return 9;
      case 6:
        return 7;
      case 5:
        return 6;
      case 4:
        return 5;
      case 3:
        return 4;
      case 2:
        return 3;
      case 1:
        return 2;
      case 0:
        return 0;
      case -2:
        break;
    } 
    return -2;
  }
  
  public static Any convertGRPCMsgBody(ChattingModel paramChattingModel) {
    try {
      MsgBodyOuterClass.MsgBody.Builder builder = MsgBodyOuterClass.MsgBody.newBuilder();
      if (!TextUtils.isEmpty(paramChattingModel.msgContent))
        return Any.pack((Message)builder.build()); 
      throw new RuntimeException("content is null");
    } finally {
      paramChattingModel = null;
      String str = TAG;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("convertGRPCMsgBody===");
      stringBuilder.append(paramChattingModel);
      ChatLog.d(str, stringBuilder.toString());
    } 
  }
  
  public static ChattingModel convertReceiveMsg(PrivateChatOuterClass.Receive paramReceive) {
    String str = TAG;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("REC---->[ ");
    stringBuilder.append(paramReceive.toString());
    stringBuilder.append(" ]");
    ChatLog.d(str, stringBuilder.toString());
    ChattingModel chattingModel = new ChattingModel();
    chattingModel.sessionType = (short)paramReceive.getSessionType();
    chattingModel.sessionId = paramReceive.getPhoneSessionId();
    chattingModel.msgType = (short)paramReceive.getMsgType().getNumber();
    chattingModel.msgId = paramReceive.getMsgId();
    long l = chattingModel.msgId;
    if (l > 0L)
      chattingModel.msgPreviousId = l - 1L; 
    chattingModel.fromId = paramReceive.getFrom();
    chattingModel.msgTimestamp = paramReceive.getTimestamp() * 1000L;
    try {
      if (!TextUtils.isEmpty(paramReceive.getDistance())) {
        stringBuilder = new StringBuilder();
        stringBuilder.append(Float.parseFloat(paramReceive.getDistance()) / 1000.0F);
        stringBuilder.append("");
        chattingModel.fromDistance = stringBuilder.toString();
      } 
    } finally {}
    chattingModel.status = paramReceive.getSessionStatus();
    if (MsgType.getClassify(chattingModel.msgType) == 1) {
      chattingModel.msgStateCode = 3;
    } else if (chattingModel.msgType == 216) {
      chattingModel.msgStateCode = 4;
    } else if (chattingModel.fromId == ChatManager.userInfo.uid) {
      if (paramReceive.getIsRead()) {
        chattingModel.msgStateCode = 3;
      } else {
        chattingModel.msgStateCode = 2;
      } 
    } else {
      chattingModel.msgStateCode = 4;
    } 
    if (paramReceive.hasBody()) {
      PushBodyOuterClass.PushBody pushBody = paramReceive.getBody();
      chattingModel.msgContent = pushBody.getContents();
      convertToLocalExtra(pushBody, chattingModel);
      fillProfile(pushBody, chattingModel);
    } 
    return chattingModel;
  }
  
  private static void convertToLocalExtra(PushBodyOuterClass.PushBody paramPushBody, ChattingModel paramChattingModel) {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual hasExtra : ()Z
    //   4: ifeq -> 1093
    //   7: aload_1
    //   8: getfield msgType : S
    //   11: lookupswitch default -> 1094, 1 -> 792, 2 -> 767, 3 -> 850, 4 -> 742, 5 -> 717, 9 -> 692, 10 -> 692, 24 -> 767, 25 -> 717, 32 -> 667, 41 -> 642, 52 -> 617, 53 -> 592, 56 -> 567, 57 -> 567, 67 -> 542, 68 -> 517, 73 -> 492, 74 -> 492, 75 -> 642, 87 -> 567, 88 -> 567, 89 -> 567, 90 -> 567, 98 -> 467, 99 -> 467, 105 -> 850, 113 -> 642, 124 -> 442, 164 -> 417, 168 -> 850, 169 -> 392, 203 -> 367, 210 -> 667, 212 -> 342, 216 -> 317
    //   308: aload_0
    //   309: invokevirtual getExtra : ()Lcom/blued/im/private_chat/PushBodyExtraOuterClass$PushBodyExtra;
    //   312: astore #5
    //   314: goto -> 883
    //   317: aload_0
    //   318: invokevirtual getExtra : ()Lcom/blued/im/private_chat/PushBodyExtraOuterClass$PushBodyExtra;
    //   321: invokevirtual hasGroupNotice : ()Z
    //   324: ifeq -> 875
    //   327: aload_0
    //   328: invokevirtual getExtra : ()Lcom/blued/im/private_chat/PushBodyExtraOuterClass$PushBodyExtra;
    //   331: invokevirtual getGroupNotice : ()Lcom/blued/im/private_chat/MsgBodyExtraOuterClass$GroupNotice;
    //   334: invokestatic protoToJson : (Lcom/google/protobuf/Message;)Ljava/lang/String;
    //   337: astore #5
    //   339: goto -> 890
    //   342: aload_0
    //   343: invokevirtual getExtra : ()Lcom/blued/im/private_chat/PushBodyExtraOuterClass$PushBodyExtra;
    //   346: invokevirtual hasDoodleShareExtra : ()Z
    //   349: ifeq -> 875
    //   352: aload_0
    //   353: invokevirtual getExtra : ()Lcom/blued/im/private_chat/PushBodyExtraOuterClass$PushBodyExtra;
    //   356: invokevirtual getDoodleShareExtra : ()Lcom/blued/im/private_chat/MsgBodyExtraOuterClass$DoodleShareExtra;
    //   359: invokestatic protoToJson : (Lcom/google/protobuf/Message;)Ljava/lang/String;
    //   362: astore #5
    //   364: goto -> 890
    //   367: aload_0
    //   368: invokevirtual getExtra : ()Lcom/blued/im/private_chat/PushBodyExtraOuterClass$PushBodyExtra;
    //   371: invokevirtual hasVoiceRoomShareExtra : ()Z
    //   374: ifeq -> 875
    //   377: aload_0
    //   378: invokevirtual getExtra : ()Lcom/blued/im/private_chat/PushBodyExtraOuterClass$PushBodyExtra;
    //   381: invokevirtual getVoiceRoomShareExtra : ()Lcom/blued/im/private_chat/MsgBodyExtraOuterClass$VoiceRoomShareExtra;
    //   384: invokestatic protoToJson : (Lcom/google/protobuf/Message;)Ljava/lang/String;
    //   387: astore #5
    //   389: goto -> 890
    //   392: aload_0
    //   393: invokevirtual getExtra : ()Lcom/blued/im/private_chat/PushBodyExtraOuterClass$PushBodyExtra;
    //   396: invokevirtual hasSysNoticeExtra : ()Z
    //   399: ifeq -> 875
    //   402: aload_0
    //   403: invokevirtual getExtra : ()Lcom/blued/im/private_chat/PushBodyExtraOuterClass$PushBodyExtra;
    //   406: invokevirtual getSysNoticeExtra : ()Lcom/blued/im/private_chat/MsgBodyExtraOuterClass$SysNoticeExtra;
    //   409: invokestatic protoToJson : (Lcom/google/protobuf/Message;)Ljava/lang/String;
    //   412: astore #5
    //   414: goto -> 890
    //   417: aload_0
    //   418: invokevirtual getExtra : ()Lcom/blued/im/private_chat/PushBodyExtraOuterClass$PushBodyExtra;
    //   421: invokevirtual hasGiftExtra : ()Z
    //   424: ifeq -> 875
    //   427: aload_0
    //   428: invokevirtual getExtra : ()Lcom/blued/im/private_chat/PushBodyExtraOuterClass$PushBodyExtra;
    //   431: invokevirtual getGiftExtra : ()Lcom/blued/im/private_chat/MsgBodyExtraOuterClass$GiftExtra;
    //   434: invokestatic protoToJson : (Lcom/google/protobuf/Message;)Ljava/lang/String;
    //   437: astore #5
    //   439: goto -> 890
    //   442: aload_0
    //   443: invokevirtual getExtra : ()Lcom/blued/im/private_chat/PushBodyExtraOuterClass$PushBodyExtra;
    //   446: invokevirtual hasSayHiExtra : ()Z
    //   449: ifeq -> 875
    //   452: aload_0
    //   453: invokevirtual getExtra : ()Lcom/blued/im/private_chat/PushBodyExtraOuterClass$PushBodyExtra;
    //   456: invokevirtual getSayHiExtra : ()Lcom/blued/im/private_chat/MsgBodyExtraOuterClass$SayHiExtra;
    //   459: invokestatic protoToJson : (Lcom/google/protobuf/Message;)Ljava/lang/String;
    //   462: astore #5
    //   464: goto -> 890
    //   467: aload_0
    //   468: invokevirtual getExtra : ()Lcom/blued/im/private_chat/PushBodyExtraOuterClass$PushBodyExtra;
    //   471: invokevirtual hasVipExtra : ()Z
    //   474: ifeq -> 875
    //   477: aload_0
    //   478: invokevirtual getExtra : ()Lcom/blued/im/private_chat/PushBodyExtraOuterClass$PushBodyExtra;
    //   481: invokevirtual getVipExtra : ()Lcom/blued/im/private_chat/MsgBodyExtraOuterClass$VipExtra;
    //   484: invokestatic protoToJson : (Lcom/google/protobuf/Message;)Ljava/lang/String;
    //   487: astore #5
    //   489: goto -> 890
    //   492: aload_0
    //   493: invokevirtual getExtra : ()Lcom/blued/im/private_chat/PushBodyExtraOuterClass$PushBodyExtra;
    //   496: invokevirtual hasHidenAlbumExtra : ()Z
    //   499: ifeq -> 875
    //   502: aload_0
    //   503: invokevirtual getExtra : ()Lcom/blued/im/private_chat/PushBodyExtraOuterClass$PushBodyExtra;
    //   506: invokevirtual getHidenAlbumExtra : ()Lcom/blued/im/private_chat/MsgBodyExtraOuterClass$HidenAlbumExtra;
    //   509: invokestatic protoToJson : (Lcom/google/protobuf/Message;)Ljava/lang/String;
    //   512: astore #5
    //   514: goto -> 890
    //   517: aload_0
    //   518: invokevirtual getExtra : ()Lcom/blued/im/private_chat/PushBodyExtraOuterClass$PushBodyExtra;
    //   521: invokevirtual hasImagetextExtra : ()Z
    //   524: ifeq -> 875
    //   527: aload_0
    //   528: invokevirtual getExtra : ()Lcom/blued/im/private_chat/PushBodyExtraOuterClass$PushBodyExtra;
    //   531: invokevirtual getImagetextExtra : ()Lcom/blued/im/private_chat/MsgBodyExtraOuterClass$ImageTextExtra;
    //   534: invokestatic protoToJson : (Lcom/google/protobuf/Message;)Ljava/lang/String;
    //   537: astore #5
    //   539: goto -> 890
    //   542: aload_0
    //   543: invokevirtual getExtra : ()Lcom/blued/im/private_chat/PushBodyExtraOuterClass$PushBodyExtra;
    //   546: invokevirtual hasFeedShareExtra : ()Z
    //   549: ifeq -> 875
    //   552: aload_0
    //   553: invokevirtual getExtra : ()Lcom/blued/im/private_chat/PushBodyExtraOuterClass$PushBodyExtra;
    //   556: invokevirtual getFeedShareExtra : ()Lcom/blued/im/private_chat/MsgBodyExtraOuterClass$FeedShareExtra;
    //   559: invokestatic protoToJson : (Lcom/google/protobuf/Message;)Ljava/lang/String;
    //   562: astore #5
    //   564: goto -> 890
    //   567: aload_0
    //   568: invokevirtual getExtra : ()Lcom/blued/im/private_chat/PushBodyExtraOuterClass$PushBodyExtra;
    //   571: invokevirtual hasShareExtra : ()Z
    //   574: ifeq -> 875
    //   577: aload_0
    //   578: invokevirtual getExtra : ()Lcom/blued/im/private_chat/PushBodyExtraOuterClass$PushBodyExtra;
    //   581: invokevirtual getShareExtra : ()Lcom/blued/im/private_chat/MsgBodyExtraOuterClass$ShareExtra;
    //   584: invokestatic protoToJson : (Lcom/google/protobuf/Message;)Ljava/lang/String;
    //   587: astore #5
    //   589: goto -> 890
    //   592: aload_0
    //   593: invokevirtual getExtra : ()Lcom/blued/im/private_chat/PushBodyExtraOuterClass$PushBodyExtra;
    //   596: invokevirtual hasVideoEndExtra : ()Z
    //   599: ifeq -> 875
    //   602: aload_0
    //   603: invokevirtual getExtra : ()Lcom/blued/im/private_chat/PushBodyExtraOuterClass$PushBodyExtra;
    //   606: invokevirtual getVideoEndExtra : ()Lcom/blued/im/private_chat/MsgBodyExtraOuterClass$VideoChatEndExtra;
    //   609: invokestatic protoToJson : (Lcom/google/protobuf/Message;)Ljava/lang/String;
    //   612: astore #5
    //   614: goto -> 890
    //   617: aload_0
    //   618: invokevirtual getExtra : ()Lcom/blued/im/private_chat/PushBodyExtraOuterClass$PushBodyExtra;
    //   621: invokevirtual hasVideoCallingExtra : ()Z
    //   624: ifeq -> 875
    //   627: aload_0
    //   628: invokevirtual getExtra : ()Lcom/blued/im/private_chat/PushBodyExtraOuterClass$PushBodyExtra;
    //   631: invokevirtual getVideoCallingExtra : ()Lcom/blued/im/private_chat/MsgBodyExtraOuterClass$VideoChatCallingExtra;
    //   634: invokestatic protoToJson : (Lcom/google/protobuf/Message;)Ljava/lang/String;
    //   637: astore #5
    //   639: goto -> 890
    //   642: aload_0
    //   643: invokevirtual getExtra : ()Lcom/blued/im/private_chat/PushBodyExtraOuterClass$PushBodyExtra;
    //   646: invokevirtual hasLiveShareInternationalExtra : ()Z
    //   649: ifeq -> 875
    //   652: aload_0
    //   653: invokevirtual getExtra : ()Lcom/blued/im/private_chat/PushBodyExtraOuterClass$PushBodyExtra;
    //   656: invokevirtual getLiveShareInternationalExtra : ()Lcom/blued/im/private_chat/MsgBodyExtraOuterClass$LiveShareInternationalExtra;
    //   659: invokestatic protoToJson : (Lcom/google/protobuf/Message;)Ljava/lang/String;
    //   662: astore #5
    //   664: goto -> 890
    //   667: aload_0
    //   668: invokevirtual getExtra : ()Lcom/blued/im/private_chat/PushBodyExtraOuterClass$PushBodyExtra;
    //   671: invokevirtual hasLiveShareExtra : ()Z
    //   674: ifeq -> 875
    //   677: aload_0
    //   678: invokevirtual getExtra : ()Lcom/blued/im/private_chat/PushBodyExtraOuterClass$PushBodyExtra;
    //   681: invokevirtual getLiveShareExtra : ()Lcom/blued/im/private_chat/MsgBodyExtraOuterClass$LiveShareExtra;
    //   684: invokestatic protoToJson : (Lcom/google/protobuf/Message;)Ljava/lang/String;
    //   687: astore #5
    //   689: goto -> 890
    //   692: aload_0
    //   693: invokevirtual getExtra : ()Lcom/blued/im/private_chat/PushBodyExtraOuterClass$PushBodyExtra;
    //   696: invokevirtual hasGroupCardExtra : ()Z
    //   699: ifeq -> 875
    //   702: aload_0
    //   703: invokevirtual getExtra : ()Lcom/blued/im/private_chat/PushBodyExtraOuterClass$PushBodyExtra;
    //   706: invokevirtual getGroupCardExtra : ()Lcom/blued/im/private_chat/MsgBodyExtraOuterClass$GroupCardExtra;
    //   709: invokestatic protoToJson : (Lcom/google/protobuf/Message;)Ljava/lang/String;
    //   712: astore #5
    //   714: goto -> 890
    //   717: aload_0
    //   718: invokevirtual getExtra : ()Lcom/blued/im/private_chat/PushBodyExtraOuterClass$PushBodyExtra;
    //   721: invokevirtual hasVideoExtra : ()Z
    //   724: ifeq -> 875
    //   727: aload_0
    //   728: invokevirtual getExtra : ()Lcom/blued/im/private_chat/PushBodyExtraOuterClass$PushBodyExtra;
    //   731: invokevirtual getVideoExtra : ()Lcom/blued/im/private_chat/MsgBodyExtraOuterClass$VideoExtra;
    //   734: invokestatic protoToJson : (Lcom/google/protobuf/Message;)Ljava/lang/String;
    //   737: astore #5
    //   739: goto -> 890
    //   742: aload_0
    //   743: invokevirtual getExtra : ()Lcom/blued/im/private_chat/PushBodyExtraOuterClass$PushBodyExtra;
    //   746: invokevirtual hasLocationExtra : ()Z
    //   749: ifeq -> 875
    //   752: aload_0
    //   753: invokevirtual getExtra : ()Lcom/blued/im/private_chat/PushBodyExtraOuterClass$PushBodyExtra;
    //   756: invokevirtual getLocationExtra : ()Lcom/blued/im/private_chat/MsgBodyExtraOuterClass$LocationExtra;
    //   759: invokestatic protoToJson : (Lcom/google/protobuf/Message;)Ljava/lang/String;
    //   762: astore #5
    //   764: goto -> 890
    //   767: aload_0
    //   768: invokevirtual getExtra : ()Lcom/blued/im/private_chat/PushBodyExtraOuterClass$PushBodyExtra;
    //   771: invokevirtual hasImgExtra : ()Z
    //   774: ifeq -> 875
    //   777: aload_0
    //   778: invokevirtual getExtra : ()Lcom/blued/im/private_chat/PushBodyExtraOuterClass$PushBodyExtra;
    //   781: invokevirtual getImgExtra : ()Lcom/blued/im/private_chat/MsgBodyExtraOuterClass$ImgExtra;
    //   784: invokestatic protoToJson : (Lcom/google/protobuf/Message;)Ljava/lang/String;
    //   787: astore #5
    //   789: goto -> 890
    //   792: aload_1
    //   793: getfield sessionType : S
    //   796: iconst_3
    //   797: if_icmpne -> 850
    //   800: aload_0
    //   801: invokevirtual getExtra : ()Lcom/blued/im/private_chat/PushBodyExtraOuterClass$PushBodyExtra;
    //   804: invokevirtual hasTextExtra : ()Z
    //   807: ifeq -> 850
    //   810: aload_0
    //   811: invokevirtual getExtra : ()Lcom/blued/im/private_chat/PushBodyExtraOuterClass$PushBodyExtra;
    //   814: invokevirtual getTextExtra : ()Lcom/blued/im/private_chat/MsgBodyExtraOuterClass$TextExtra;
    //   817: ifnull -> 850
    //   820: aload_0
    //   821: invokevirtual getExtra : ()Lcom/blued/im/private_chat/PushBodyExtraOuterClass$PushBodyExtra;
    //   824: invokevirtual getTextExtra : ()Lcom/blued/im/private_chat/MsgBodyExtraOuterClass$TextExtra;
    //   827: invokevirtual getAtUids : ()Ljava/lang/String;
    //   830: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   833: ifne -> 850
    //   836: aload_1
    //   837: aload_0
    //   838: invokevirtual getExtra : ()Lcom/blued/im/private_chat/PushBodyExtraOuterClass$PushBodyExtra;
    //   841: invokevirtual getTextExtra : ()Lcom/blued/im/private_chat/MsgBodyExtraOuterClass$TextExtra;
    //   844: invokevirtual getAtUids : ()Ljava/lang/String;
    //   847: putfield msgAt : Ljava/lang/String;
    //   850: aload_0
    //   851: invokevirtual getExtra : ()Lcom/blued/im/private_chat/PushBodyExtraOuterClass$PushBodyExtra;
    //   854: invokevirtual hasTextExtra : ()Z
    //   857: ifeq -> 875
    //   860: aload_0
    //   861: invokevirtual getExtra : ()Lcom/blued/im/private_chat/PushBodyExtraOuterClass$PushBodyExtra;
    //   864: invokevirtual getTextExtra : ()Lcom/blued/im/private_chat/MsgBodyExtraOuterClass$TextExtra;
    //   867: invokestatic protoToJson : (Lcom/google/protobuf/Message;)Ljava/lang/String;
    //   870: astore #5
    //   872: goto -> 890
    //   875: ldc_w '{}'
    //   878: astore #5
    //   880: goto -> 890
    //   883: aload #5
    //   885: invokestatic protoToJson : (Lcom/google/protobuf/Message;)Ljava/lang/String;
    //   888: astore #5
    //   890: aload #5
    //   892: invokestatic parseString : (Ljava/lang/String;)Lcom/google/gson/JsonElement;
    //   895: invokevirtual getAsJsonObject : ()Lcom/google/gson/JsonObject;
    //   898: astore #5
    //   900: invokestatic getInstance : ()Lcom/blued/android/chat/grpc/PrivateChatManager;
    //   903: invokevirtual getChatAppInfo : ()Lcom/blued/android/chat/grpc/info/ChatAppInfo;
    //   906: getfield clientType : Lcom/blued/android/chat/grpc/ClientType;
    //   909: getstatic com/blued/android/chat/grpc/ClientType.CHINA : Lcom/blued/android/chat/grpc/ClientType;
    //   912: if_acmpne -> 951
    //   915: aload_0
    //   916: invokevirtual getExtra : ()Lcom/blued/im/private_chat/PushBodyExtraOuterClass$PushBodyExtra;
    //   919: invokevirtual hasMsgSource : ()Z
    //   922: istore_2
    //   923: iload_2
    //   924: ifeq -> 983
    //   927: aload #5
    //   929: ldc_w 'msgSource'
    //   932: aload_0
    //   933: invokevirtual getExtra : ()Lcom/blued/im/private_chat/PushBodyExtraOuterClass$PushBodyExtra;
    //   936: invokevirtual getMsgSource : ()Lcom/blued/im/private_chat/MsgBodyExtraOuterClass$MsgSource;
    //   939: invokestatic protoToJson : (Lcom/google/protobuf/Message;)Ljava/lang/String;
    //   942: invokestatic parseString : (Ljava/lang/String;)Lcom/google/gson/JsonElement;
    //   945: invokevirtual add : (Ljava/lang/String;Lcom/google/gson/JsonElement;)V
    //   948: goto -> 983
    //   951: aload_0
    //   952: invokevirtual getExtra : ()Lcom/blued/im/private_chat/PushBodyExtraOuterClass$PushBodyExtra;
    //   955: invokevirtual getMsgReceiveFrom : ()J
    //   958: lstore_3
    //   959: lload_3
    //   960: lconst_0
    //   961: lcmp
    //   962: ifeq -> 983
    //   965: aload #5
    //   967: ldc_w 'msg_receive_from'
    //   970: aload_0
    //   971: invokevirtual getExtra : ()Lcom/blued/im/private_chat/PushBodyExtraOuterClass$PushBodyExtra;
    //   974: invokevirtual getMsgReceiveFrom : ()J
    //   977: invokestatic valueOf : (J)Ljava/lang/Long;
    //   980: invokevirtual addProperty : (Ljava/lang/String;Ljava/lang/Number;)V
    //   983: aload_0
    //   984: invokevirtual getExtra : ()Lcom/blued/im/private_chat/PushBodyExtraOuterClass$PushBodyExtra;
    //   987: invokevirtual hasSecureNotify : ()Z
    //   990: istore_2
    //   991: iload_2
    //   992: ifeq -> 1016
    //   995: aload #5
    //   997: ldc_w 'secureNotify'
    //   1000: aload_0
    //   1001: invokevirtual getExtra : ()Lcom/blued/im/private_chat/PushBodyExtraOuterClass$PushBodyExtra;
    //   1004: invokevirtual getSecureNotify : ()Lcom/blued/im/private_chat/MsgBodyExtraOuterClass$SecureNotify;
    //   1007: invokestatic protoToJson : (Lcom/google/protobuf/Message;)Ljava/lang/String;
    //   1010: invokestatic parseString : (Ljava/lang/String;)Lcom/google/gson/JsonElement;
    //   1013: invokevirtual add : (Ljava/lang/String;Lcom/google/gson/JsonElement;)V
    //   1016: aload #5
    //   1018: invokevirtual toString : ()Ljava/lang/String;
    //   1021: astore_0
    //   1022: getstatic com/blued/android/chat/grpc/utils/MsgConverter.TAG : Ljava/lang/String;
    //   1025: astore #5
    //   1027: new java/lang/StringBuilder
    //   1030: dup
    //   1031: invokespecial <init> : ()V
    //   1034: astore #6
    //   1036: aload #6
    //   1038: ldc_w '转换接收消息：type='
    //   1041: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1044: pop
    //   1045: aload #6
    //   1047: aload_1
    //   1048: getfield msgType : S
    //   1051: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   1054: pop
    //   1055: aload #6
    //   1057: ldc_w ' extra: '
    //   1060: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1063: pop
    //   1064: aload #6
    //   1066: aload_0
    //   1067: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1070: pop
    //   1071: aload #5
    //   1073: aload #6
    //   1075: invokevirtual toString : ()Ljava/lang/String;
    //   1078: invokestatic d : (Ljava/lang/String;Ljava/lang/String;)I
    //   1081: pop
    //   1082: aload_1
    //   1083: aload_0
    //   1084: invokevirtual setMsgExtra : (Ljava/lang/String;)V
    //   1087: return
    //   1088: astore_0
    //   1089: aload_0
    //   1090: invokevirtual printStackTrace : ()V
    //   1093: return
    //   1094: goto -> 308
    // Exception table:
    //   from	to	target	type
    //   0	308	1088	com/google/protobuf/InvalidProtocolBufferException
    //   308	314	1088	com/google/protobuf/InvalidProtocolBufferException
    //   317	339	1088	com/google/protobuf/InvalidProtocolBufferException
    //   342	364	1088	com/google/protobuf/InvalidProtocolBufferException
    //   367	389	1088	com/google/protobuf/InvalidProtocolBufferException
    //   392	414	1088	com/google/protobuf/InvalidProtocolBufferException
    //   417	439	1088	com/google/protobuf/InvalidProtocolBufferException
    //   442	464	1088	com/google/protobuf/InvalidProtocolBufferException
    //   467	489	1088	com/google/protobuf/InvalidProtocolBufferException
    //   492	514	1088	com/google/protobuf/InvalidProtocolBufferException
    //   517	539	1088	com/google/protobuf/InvalidProtocolBufferException
    //   542	564	1088	com/google/protobuf/InvalidProtocolBufferException
    //   567	589	1088	com/google/protobuf/InvalidProtocolBufferException
    //   592	614	1088	com/google/protobuf/InvalidProtocolBufferException
    //   617	639	1088	com/google/protobuf/InvalidProtocolBufferException
    //   642	664	1088	com/google/protobuf/InvalidProtocolBufferException
    //   667	689	1088	com/google/protobuf/InvalidProtocolBufferException
    //   692	714	1088	com/google/protobuf/InvalidProtocolBufferException
    //   717	739	1088	com/google/protobuf/InvalidProtocolBufferException
    //   742	764	1088	com/google/protobuf/InvalidProtocolBufferException
    //   767	789	1088	com/google/protobuf/InvalidProtocolBufferException
    //   792	850	1088	com/google/protobuf/InvalidProtocolBufferException
    //   850	872	1088	com/google/protobuf/InvalidProtocolBufferException
    //   883	890	1088	com/google/protobuf/InvalidProtocolBufferException
    //   890	923	1088	com/google/protobuf/InvalidProtocolBufferException
    //   927	948	1088	com/google/protobuf/InvalidProtocolBufferException
    //   951	959	1088	com/google/protobuf/InvalidProtocolBufferException
    //   965	983	1088	com/google/protobuf/InvalidProtocolBufferException
    //   983	991	1088	com/google/protobuf/InvalidProtocolBufferException
    //   995	1016	1088	com/google/protobuf/InvalidProtocolBufferException
    //   1016	1087	1088	com/google/protobuf/InvalidProtocolBufferException
  }
  
  private static void fillProfile(PushBodyOuterClass.PushBody paramPushBody, ChattingModel paramChattingModel) {
    if (paramPushBody.hasProfile()) {
      PushProfileOuterClass.PushProfile pushProfile = paramPushBody.getProfile();
      paramChattingModel.fromNickName = pushProfile.getName();
      paramChattingModel.fromAvatar = pushProfile.getAvatar();
      paramChattingModel.fromVBadge = pushProfile.getVbadge();
      paramChattingModel.fromOnline = pushProfile.getOnline();
      paramChattingModel.fromFriend = pushProfile.getFriend();
      paramChattingModel.fromRichLevel = pushProfile.getRichLevel();
      paramChattingModel.fromVipGrade = pushProfile.getVipGrade();
      paramChattingModel.ofromVipGrade = pushProfile.getOVipGrade();
      paramChattingModel.fromVipAnnual = pushProfile.getVipAnnual();
      paramChattingModel.fromVipExpLvl = pushProfile.getVipExpLvl();
      paramChattingModel.fromLiveManager = pushProfile.getIsManager();
      paramChattingModel.fromHideVipLook = pushProfile.getIsHideVipLook();
      paramChattingModel.ofromHideVipLook = pushProfile.getOIsHideVipLook();
      paramChattingModel.oFromFaceStatus = pushProfile.getOFaceStatus();
      paramChattingModel.avatarPendant = pushProfile.getAvatarPendant();
    } 
  }
  
  private static void setMsgExtra(ChattingModel paramChattingModel, MsgBodyOuterClass.MsgBody.Builder paramBuilder) {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual getMsgExtra : ()Ljava/lang/String;
    //   4: astore #5
    //   6: aload #5
    //   8: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   11: ifeq -> 25
    //   14: aload_0
    //   15: getfield msgAt : Ljava/lang/String;
    //   18: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   21: ifeq -> 25
    //   24: return
    //   25: invokestatic newBuilder : ()Lcom/blued/im/private_chat/MsgBodyOuterClass$MsgExtra$Builder;
    //   28: astore #4
    //   30: aconst_null
    //   31: astore_3
    //   32: aload_0
    //   33: getfield msgType : S
    //   36: istore_2
    //   37: iload_2
    //   38: iconst_1
    //   39: if_icmpeq -> 568
    //   42: iload_2
    //   43: iconst_2
    //   44: if_icmpeq -> 548
    //   47: iload_2
    //   48: iconst_3
    //   49: if_icmpeq -> 568
    //   52: iload_2
    //   53: iconst_4
    //   54: if_icmpeq -> 528
    //   57: iload_2
    //   58: iconst_5
    //   59: if_icmpeq -> 508
    //   62: iload_2
    //   63: bipush #9
    //   65: if_icmpeq -> 488
    //   68: iload_2
    //   69: bipush #10
    //   71: if_icmpeq -> 488
    //   74: iload_2
    //   75: bipush #24
    //   77: if_icmpeq -> 548
    //   80: iload_2
    //   81: bipush #25
    //   83: if_icmpeq -> 508
    //   86: iload_2
    //   87: bipush #32
    //   89: if_icmpeq -> 468
    //   92: iload_2
    //   93: bipush #41
    //   95: if_icmpeq -> 448
    //   98: iload_2
    //   99: bipush #105
    //   101: if_icmpeq -> 568
    //   104: iload_2
    //   105: bipush #113
    //   107: if_icmpeq -> 448
    //   110: iload_2
    //   111: bipush #124
    //   113: if_icmpeq -> 428
    //   116: iload_2
    //   117: sipush #164
    //   120: if_icmpeq -> 408
    //   123: iload_2
    //   124: sipush #168
    //   127: if_icmpeq -> 568
    //   130: iload_2
    //   131: sipush #203
    //   134: if_icmpeq -> 388
    //   137: iload_2
    //   138: sipush #210
    //   141: if_icmpeq -> 468
    //   144: iload_2
    //   145: sipush #212
    //   148: if_icmpeq -> 368
    //   151: iload_2
    //   152: bipush #52
    //   154: if_icmpeq -> 348
    //   157: iload_2
    //   158: bipush #53
    //   160: if_icmpeq -> 328
    //   163: iload_2
    //   164: bipush #56
    //   166: if_icmpeq -> 308
    //   169: iload_2
    //   170: bipush #57
    //   172: if_icmpeq -> 308
    //   175: iload_2
    //   176: bipush #67
    //   178: if_icmpeq -> 288
    //   181: iload_2
    //   182: bipush #68
    //   184: if_icmpeq -> 268
    //   187: iload_2
    //   188: bipush #98
    //   190: if_icmpeq -> 248
    //   193: iload_2
    //   194: bipush #99
    //   196: if_icmpeq -> 248
    //   199: iload_2
    //   200: tableswitch default -> 677, 73 -> 228, 74 -> 228, 75 -> 448
    //   228: aload #4
    //   230: aload #5
    //   232: invokestatic newBuilder : ()Lcom/blued/im/private_chat/MsgBodyExtraOuterClass$HidenAlbumExtra$Builder;
    //   235: invokestatic json2pb : (Ljava/lang/String;Lcom/google/protobuf/Message$Builder;)Ljava/lang/Object;
    //   238: checkcast com/blued/im/private_chat/MsgBodyExtraOuterClass$HidenAlbumExtra
    //   241: invokevirtual setHidenAlbumExtra : (Lcom/blued/im/private_chat/MsgBodyExtraOuterClass$HidenAlbumExtra;)Lcom/blued/im/private_chat/MsgBodyOuterClass$MsgExtra$Builder;
    //   244: pop
    //   245: goto -> 609
    //   248: aload #4
    //   250: aload #5
    //   252: invokestatic newBuilder : ()Lcom/blued/im/private_chat/MsgBodyExtraOuterClass$VipExtra$Builder;
    //   255: invokestatic json2pb : (Ljava/lang/String;Lcom/google/protobuf/Message$Builder;)Ljava/lang/Object;
    //   258: checkcast com/blued/im/private_chat/MsgBodyExtraOuterClass$VipExtra
    //   261: invokevirtual setVipExtra : (Lcom/blued/im/private_chat/MsgBodyExtraOuterClass$VipExtra;)Lcom/blued/im/private_chat/MsgBodyOuterClass$MsgExtra$Builder;
    //   264: pop
    //   265: goto -> 609
    //   268: aload #4
    //   270: aload #5
    //   272: invokestatic newBuilder : ()Lcom/blued/im/private_chat/MsgBodyExtraOuterClass$ImageTextExtra$Builder;
    //   275: invokestatic json2pb : (Ljava/lang/String;Lcom/google/protobuf/Message$Builder;)Ljava/lang/Object;
    //   278: checkcast com/blued/im/private_chat/MsgBodyExtraOuterClass$ImageTextExtra
    //   281: invokevirtual setImagetextExtra : (Lcom/blued/im/private_chat/MsgBodyExtraOuterClass$ImageTextExtra;)Lcom/blued/im/private_chat/MsgBodyOuterClass$MsgExtra$Builder;
    //   284: pop
    //   285: goto -> 609
    //   288: aload #4
    //   290: aload #5
    //   292: invokestatic newBuilder : ()Lcom/blued/im/private_chat/MsgBodyExtraOuterClass$FeedShareExtra$Builder;
    //   295: invokestatic json2pb : (Ljava/lang/String;Lcom/google/protobuf/Message$Builder;)Ljava/lang/Object;
    //   298: checkcast com/blued/im/private_chat/MsgBodyExtraOuterClass$FeedShareExtra
    //   301: invokevirtual setFeedShareExtra : (Lcom/blued/im/private_chat/MsgBodyExtraOuterClass$FeedShareExtra;)Lcom/blued/im/private_chat/MsgBodyOuterClass$MsgExtra$Builder;
    //   304: pop
    //   305: goto -> 609
    //   308: aload #4
    //   310: aload #5
    //   312: invokestatic newBuilder : ()Lcom/blued/im/private_chat/MsgBodyExtraOuterClass$ShareExtra$Builder;
    //   315: invokestatic json2pb : (Ljava/lang/String;Lcom/google/protobuf/Message$Builder;)Ljava/lang/Object;
    //   318: checkcast com/blued/im/private_chat/MsgBodyExtraOuterClass$ShareExtra
    //   321: invokevirtual setShareExtra : (Lcom/blued/im/private_chat/MsgBodyExtraOuterClass$ShareExtra;)Lcom/blued/im/private_chat/MsgBodyOuterClass$MsgExtra$Builder;
    //   324: pop
    //   325: goto -> 609
    //   328: aload #4
    //   330: aload #5
    //   332: invokestatic newBuilder : ()Lcom/blued/im/private_chat/MsgBodyExtraOuterClass$VideoChatEndExtra$Builder;
    //   335: invokestatic json2pb : (Ljava/lang/String;Lcom/google/protobuf/Message$Builder;)Ljava/lang/Object;
    //   338: checkcast com/blued/im/private_chat/MsgBodyExtraOuterClass$VideoChatEndExtra
    //   341: invokevirtual setVideoEndExtra : (Lcom/blued/im/private_chat/MsgBodyExtraOuterClass$VideoChatEndExtra;)Lcom/blued/im/private_chat/MsgBodyOuterClass$MsgExtra$Builder;
    //   344: pop
    //   345: goto -> 609
    //   348: aload #4
    //   350: aload #5
    //   352: invokestatic newBuilder : ()Lcom/blued/im/private_chat/MsgBodyExtraOuterClass$VideoChatCallingExtra$Builder;
    //   355: invokestatic json2pb : (Ljava/lang/String;Lcom/google/protobuf/Message$Builder;)Ljava/lang/Object;
    //   358: checkcast com/blued/im/private_chat/MsgBodyExtraOuterClass$VideoChatCallingExtra
    //   361: invokevirtual setVideoCallingExtra : (Lcom/blued/im/private_chat/MsgBodyExtraOuterClass$VideoChatCallingExtra;)Lcom/blued/im/private_chat/MsgBodyOuterClass$MsgExtra$Builder;
    //   364: pop
    //   365: goto -> 609
    //   368: aload #4
    //   370: aload #5
    //   372: invokestatic newBuilder : ()Lcom/blued/im/private_chat/MsgBodyExtraOuterClass$DoodleShareExtra$Builder;
    //   375: invokestatic json2pb : (Ljava/lang/String;Lcom/google/protobuf/Message$Builder;)Ljava/lang/Object;
    //   378: checkcast com/blued/im/private_chat/MsgBodyExtraOuterClass$DoodleShareExtra
    //   381: invokevirtual setDoodleShareExtra : (Lcom/blued/im/private_chat/MsgBodyExtraOuterClass$DoodleShareExtra;)Lcom/blued/im/private_chat/MsgBodyOuterClass$MsgExtra$Builder;
    //   384: pop
    //   385: goto -> 609
    //   388: aload #4
    //   390: aload #5
    //   392: invokestatic newBuilder : ()Lcom/blued/im/private_chat/MsgBodyExtraOuterClass$VoiceRoomShareExtra$Builder;
    //   395: invokestatic json2pb : (Ljava/lang/String;Lcom/google/protobuf/Message$Builder;)Ljava/lang/Object;
    //   398: checkcast com/blued/im/private_chat/MsgBodyExtraOuterClass$VoiceRoomShareExtra
    //   401: invokevirtual setVoiceRoomShareExtra : (Lcom/blued/im/private_chat/MsgBodyExtraOuterClass$VoiceRoomShareExtra;)Lcom/blued/im/private_chat/MsgBodyOuterClass$MsgExtra$Builder;
    //   404: pop
    //   405: goto -> 609
    //   408: aload #4
    //   410: aload #5
    //   412: invokestatic newBuilder : ()Lcom/blued/im/private_chat/MsgBodyExtraOuterClass$GiftExtra$Builder;
    //   415: invokestatic json2pb : (Ljava/lang/String;Lcom/google/protobuf/Message$Builder;)Ljava/lang/Object;
    //   418: checkcast com/blued/im/private_chat/MsgBodyExtraOuterClass$GiftExtra
    //   421: invokevirtual setGiftExtra : (Lcom/blued/im/private_chat/MsgBodyExtraOuterClass$GiftExtra;)Lcom/blued/im/private_chat/MsgBodyOuterClass$MsgExtra$Builder;
    //   424: pop
    //   425: goto -> 609
    //   428: aload #4
    //   430: aload #5
    //   432: invokestatic newBuilder : ()Lcom/blued/im/private_chat/MsgBodyExtraOuterClass$SayHiExtra$Builder;
    //   435: invokestatic json2pb : (Ljava/lang/String;Lcom/google/protobuf/Message$Builder;)Ljava/lang/Object;
    //   438: checkcast com/blued/im/private_chat/MsgBodyExtraOuterClass$SayHiExtra
    //   441: invokevirtual setSayHiExtra : (Lcom/blued/im/private_chat/MsgBodyExtraOuterClass$SayHiExtra;)Lcom/blued/im/private_chat/MsgBodyOuterClass$MsgExtra$Builder;
    //   444: pop
    //   445: goto -> 609
    //   448: aload #4
    //   450: aload #5
    //   452: invokestatic newBuilder : ()Lcom/blued/im/private_chat/MsgBodyExtraOuterClass$LiveShareInternationalExtra$Builder;
    //   455: invokestatic json2pb : (Ljava/lang/String;Lcom/google/protobuf/Message$Builder;)Ljava/lang/Object;
    //   458: checkcast com/blued/im/private_chat/MsgBodyExtraOuterClass$LiveShareInternationalExtra
    //   461: invokevirtual setLiveShareInternationalExtra : (Lcom/blued/im/private_chat/MsgBodyExtraOuterClass$LiveShareInternationalExtra;)Lcom/blued/im/private_chat/MsgBodyOuterClass$MsgExtra$Builder;
    //   464: pop
    //   465: goto -> 609
    //   468: aload #4
    //   470: aload #5
    //   472: invokestatic newBuilder : ()Lcom/blued/im/private_chat/MsgBodyExtraOuterClass$LiveShareExtra$Builder;
    //   475: invokestatic json2pb : (Ljava/lang/String;Lcom/google/protobuf/Message$Builder;)Ljava/lang/Object;
    //   478: checkcast com/blued/im/private_chat/MsgBodyExtraOuterClass$LiveShareExtra
    //   481: invokevirtual setLiveShareExtra : (Lcom/blued/im/private_chat/MsgBodyExtraOuterClass$LiveShareExtra;)Lcom/blued/im/private_chat/MsgBodyOuterClass$MsgExtra$Builder;
    //   484: pop
    //   485: goto -> 609
    //   488: aload #4
    //   490: aload #5
    //   492: invokestatic newBuilder : ()Lcom/blued/im/private_chat/MsgBodyExtraOuterClass$GroupCardExtra$Builder;
    //   495: invokestatic json2pb : (Ljava/lang/String;Lcom/google/protobuf/Message$Builder;)Ljava/lang/Object;
    //   498: checkcast com/blued/im/private_chat/MsgBodyExtraOuterClass$GroupCardExtra
    //   501: invokevirtual setGroupCardExtra : (Lcom/blued/im/private_chat/MsgBodyExtraOuterClass$GroupCardExtra;)Lcom/blued/im/private_chat/MsgBodyOuterClass$MsgExtra$Builder;
    //   504: pop
    //   505: goto -> 609
    //   508: aload #4
    //   510: aload #5
    //   512: invokestatic newBuilder : ()Lcom/blued/im/private_chat/MsgBodyExtraOuterClass$VideoExtra$Builder;
    //   515: invokestatic json2pb : (Ljava/lang/String;Lcom/google/protobuf/Message$Builder;)Ljava/lang/Object;
    //   518: checkcast com/blued/im/private_chat/MsgBodyExtraOuterClass$VideoExtra
    //   521: invokevirtual setVideoExtra : (Lcom/blued/im/private_chat/MsgBodyExtraOuterClass$VideoExtra;)Lcom/blued/im/private_chat/MsgBodyOuterClass$MsgExtra$Builder;
    //   524: pop
    //   525: goto -> 609
    //   528: aload #4
    //   530: aload #5
    //   532: invokestatic newBuilder : ()Lcom/blued/im/private_chat/MsgBodyExtraOuterClass$LocationExtra$Builder;
    //   535: invokestatic json2pb : (Ljava/lang/String;Lcom/google/protobuf/Message$Builder;)Ljava/lang/Object;
    //   538: checkcast com/blued/im/private_chat/MsgBodyExtraOuterClass$LocationExtra
    //   541: invokevirtual setLocationExtra : (Lcom/blued/im/private_chat/MsgBodyExtraOuterClass$LocationExtra;)Lcom/blued/im/private_chat/MsgBodyOuterClass$MsgExtra$Builder;
    //   544: pop
    //   545: goto -> 609
    //   548: aload #4
    //   550: aload #5
    //   552: invokestatic newBuilder : ()Lcom/blued/im/private_chat/MsgBodyExtraOuterClass$ImgExtra$Builder;
    //   555: invokestatic json2pb : (Ljava/lang/String;Lcom/google/protobuf/Message$Builder;)Ljava/lang/Object;
    //   558: checkcast com/blued/im/private_chat/MsgBodyExtraOuterClass$ImgExtra
    //   561: invokevirtual setImgExtra : (Lcom/blued/im/private_chat/MsgBodyExtraOuterClass$ImgExtra;)Lcom/blued/im/private_chat/MsgBodyOuterClass$MsgExtra$Builder;
    //   564: pop
    //   565: goto -> 609
    //   568: invokestatic newBuilder : ()Lcom/blued/im/private_chat/MsgBodyExtraOuterClass$TextExtra$Builder;
    //   571: astore #6
    //   573: aload_0
    //   574: getfield msgAt : Ljava/lang/String;
    //   577: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   580: ifne -> 593
    //   583: aload #6
    //   585: aload_0
    //   586: getfield msgAt : Ljava/lang/String;
    //   589: invokevirtual setAtUids : (Ljava/lang/String;)Lcom/blued/im/private_chat/MsgBodyExtraOuterClass$TextExtra$Builder;
    //   592: pop
    //   593: aload #4
    //   595: aload #5
    //   597: aload #6
    //   599: invokestatic json2pb : (Ljava/lang/String;Lcom/google/protobuf/Message$Builder;)Ljava/lang/Object;
    //   602: checkcast com/blued/im/private_chat/MsgBodyExtraOuterClass$TextExtra
    //   605: invokevirtual setTextExtra : (Lcom/blued/im/private_chat/MsgBodyExtraOuterClass$TextExtra;)Lcom/blued/im/private_chat/MsgBodyOuterClass$MsgExtra$Builder;
    //   608: pop
    //   609: aload #4
    //   611: astore_0
    //   612: goto -> 622
    //   615: astore_0
    //   616: aload_0
    //   617: invokevirtual printStackTrace : ()V
    //   620: aload_3
    //   621: astore_0
    //   622: aload_0
    //   623: ifnull -> 676
    //   626: aload_1
    //   627: aload_0
    //   628: invokevirtual build : ()Lcom/blued/im/private_chat/MsgBodyOuterClass$MsgExtra;
    //   631: invokevirtual setExtra : (Lcom/blued/im/private_chat/MsgBodyOuterClass$MsgExtra;)Lcom/blued/im/private_chat/MsgBodyOuterClass$MsgBody$Builder;
    //   634: pop
    //   635: getstatic com/blued/android/chat/grpc/utils/MsgConverter.TAG : Ljava/lang/String;
    //   638: astore_0
    //   639: new java/lang/StringBuilder
    //   642: dup
    //   643: invokespecial <init> : ()V
    //   646: astore_3
    //   647: aload_3
    //   648: ldc_w 'send --> '
    //   651: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   654: pop
    //   655: aload_3
    //   656: aload_1
    //   657: invokevirtual getExtra : ()Lcom/blued/im/private_chat/MsgBodyOuterClass$MsgExtra;
    //   660: invokevirtual toString : ()Ljava/lang/String;
    //   663: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   666: pop
    //   667: aload_0
    //   668: aload_3
    //   669: invokevirtual toString : ()Ljava/lang/String;
    //   672: invokestatic d : (Ljava/lang/String;Ljava/lang/String;)I
    //   675: pop
    //   676: return
    //   677: iload_2
    //   678: tableswitch default -> 708, 87 -> 308, 88 -> 308, 89 -> 308, 90 -> 308
    //   708: aload_3
    //   709: astore_0
    //   710: goto -> 622
    // Exception table:
    //   from	to	target	type
    //   32	37	615	com/google/protobuf/InvalidProtocolBufferException
    //   228	245	615	com/google/protobuf/InvalidProtocolBufferException
    //   248	265	615	com/google/protobuf/InvalidProtocolBufferException
    //   268	285	615	com/google/protobuf/InvalidProtocolBufferException
    //   288	305	615	com/google/protobuf/InvalidProtocolBufferException
    //   308	325	615	com/google/protobuf/InvalidProtocolBufferException
    //   328	345	615	com/google/protobuf/InvalidProtocolBufferException
    //   348	365	615	com/google/protobuf/InvalidProtocolBufferException
    //   368	385	615	com/google/protobuf/InvalidProtocolBufferException
    //   388	405	615	com/google/protobuf/InvalidProtocolBufferException
    //   408	425	615	com/google/protobuf/InvalidProtocolBufferException
    //   428	445	615	com/google/protobuf/InvalidProtocolBufferException
    //   448	465	615	com/google/protobuf/InvalidProtocolBufferException
    //   468	485	615	com/google/protobuf/InvalidProtocolBufferException
    //   488	505	615	com/google/protobuf/InvalidProtocolBufferException
    //   508	525	615	com/google/protobuf/InvalidProtocolBufferException
    //   528	545	615	com/google/protobuf/InvalidProtocolBufferException
    //   548	565	615	com/google/protobuf/InvalidProtocolBufferException
    //   568	593	615	com/google/protobuf/InvalidProtocolBufferException
    //   593	609	615	com/google/protobuf/InvalidProtocolBufferException
  }
  
  public static void setMsgSource(ChattingModel paramChattingModel, MsgBodyOuterClass.MsgBody.Builder paramBuilder) {
    String str = paramChattingModel.getMsgExtra();
    if (!TextUtils.isEmpty(str)) {
      String str1;
      JsonObject jsonObject = JsonParser.parseString(str).getAsJsonObject();
      if (jsonObject.has("msgSource") && (PrivateChatManager.getInstance().getChatAppInfo()).clientType == ClientType.CHINA) {
        JsonElement jsonElement = jsonObject.get("msgSource");
        if (!jsonElement.isJsonNull()) {
          JsonObject jsonObject1 = jsonElement.getAsJsonObject();
          int i = 0;
          JsonElement jsonElement1 = jsonObject1.get("type");
          boolean bool = jsonElement1.isJsonNull();
          String str2 = "";
          str1 = str2;
          if (!bool) {
            int j = jsonElement1.getAsInt();
            JsonElement jsonElement2 = jsonObject1.get("content");
            i = j;
            str1 = str2;
            if (!jsonElement2.isJsonNull()) {
              str1 = jsonElement2.getAsString();
              i = j;
            } 
          } 
          paramBuilder.setMsgSource(MsgBodyExtraOuterClass.MsgSource.newBuilder().setType(i).setContent(str1).build());
          return;
        } 
      } else if (str1.has("msg_receive_from")) {
        paramBuilder.setMsgReceiveFrom(str1.get("msg_receive_from").getAsLong());
      } 
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\blued\android\chat\grp\\utils\MsgConverter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */