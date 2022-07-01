package com.blued.android.module.im.biz.privatechat;

import com.blued.android.module.im.grpc.ChannelManager;
import com.blued.android.module.im.grpc.IMThreadManager;
import com.blued.das.apm.ApmProtos;
import com.blued.im.private_chat.GroupChatGrpc;
import com.blued.im.private_chat.PrivateChatOuterClass;
import io.grpc.stub.AbstractStub;
import java.util.concurrent.TimeUnit;

public final class GroupChat extends PrivateChatBase {
  public GroupChat(ChannelManager paramChannelManager, IMThreadManager paramIMThreadManager) {
    super(paramChannelManager, paramIMThreadManager);
  }
  
  protected ApmProtos.GrpcRequestTypeProto.BUSINESS a() {
    return ApmProtos.GrpcRequestTypeProto.BUSINESS.GROUP_CHAT;
  }
  
  public PrivateChatOuterClass.Response a(PrivateChatOuterClass.Request paramRequest) {
    GroupChatGrpc.GroupChatBlockingStub groupChatBlockingStub = GroupChatGrpc.newBlockingStub(this.a.d());
    return ((GroupChatGrpc.GroupChatBlockingStub)((GroupChatGrpc.GroupChatBlockingStub)((GroupChatGrpc.GroupChatBlockingStub)this.a.a((AbstractStub)groupChatBlockingStub)).withCompression("gzip")).withDeadlineAfter(30L, TimeUnit.SECONDS)).send(paramRequest);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\im\biz\privatechat\GroupChat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */