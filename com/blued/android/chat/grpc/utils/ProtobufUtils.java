package com.blued.android.chat.grpc.utils;

import android.text.TextUtils;
import com.blued.android.chat.grpc.PrivateChatManager;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Message;
import com.google.protobuf.MessageOrBuilder;
import com.google.protobuf.util.JsonFormat;

public class ProtobufUtils {
  public static <T> T json2pb(String paramString, Message.Builder paramBuilder) throws InvalidProtocolBufferException {
    if (paramBuilder == null)
      return null; 
    String str = paramString;
    if (TextUtils.isEmpty(paramString))
      str = "{}"; 
    JsonFormat.parser().ignoringUnknownFields().merge(str, paramBuilder);
    return (T)paramBuilder.build();
  }
  
  public static <T> T object2pb(Object paramObject, Message.Builder paramBuilder) throws InvalidProtocolBufferException {
    return (paramBuilder == null || paramObject == null) ? null : json2pb(PrivateChatManager.getInstance().getGson().toJson(paramObject), paramBuilder);
  }
  
  public static String protoToJson(Message paramMessage) throws InvalidProtocolBufferException {
    return JsonFormat.printer().preservingProtoFieldNames().print((MessageOrBuilder)paramMessage);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\blued\android\chat\grp\\utils\ProtobufUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */