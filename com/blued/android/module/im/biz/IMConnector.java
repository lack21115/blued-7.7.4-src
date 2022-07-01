package com.blued.android.module.im.biz;

import com.blued.android.module.im.IMConfig;
import com.blued.android.module.im.grpc.BaseConnector;
import com.blued.android.module.im.grpc.ChannelManager;
import com.blued.das.apm.ApmProtos;
import com.blued.im.ConnectorGrpc;
import com.blued.im.ConnectorOuterClass;
import com.google.protobuf.Any;
import com.google.protobuf.Message;
import io.grpc.MethodDescriptor;

public final class IMConnector extends BaseConnector {
  public IMConnector(ChannelManager paramChannelManager) {
    super(paramChannelManager);
  }
  
  public ApmProtos.GrpcConnectTypeProto.BUSINESS a() {
    return ApmProtos.GrpcConnectTypeProto.BUSINESS.PRIVATE_CHAT;
  }
  
  public Any a(Any paramAny) {
    IMConnectorDebuger.a("connector receive ok");
    IMConnectorDebuger.b();
    Any any = paramAny;
    if (paramAny.is(ConnectorOuterClass.PingPackage.class)) {
      b(Any.pack((Message)ConnectorOuterClass.PongPackage.newBuilder().build()));
      any = null;
    } 
    return any;
  }
  
  public boolean b() {
    return IMConfig.b();
  }
  
  public MethodDescriptor c() {
    return ConnectorGrpc.getConnectMethod();
  }
  
  public void d() {
    b(Any.pack((Message)ConnectorOuterClass.PingPackage.newBuilder().build()));
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\im\biz\IMConnector.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */