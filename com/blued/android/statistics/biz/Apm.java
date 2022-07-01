package com.blued.android.statistics.biz;

import com.blued.android.statistics.grpc.connect.ApmManager;
import com.blued.android.statistics.util.Utils;
import com.blued.das.apm.ApmProtos;
import com.google.protobuf.Any;
import com.google.protobuf.Message;

public final class Apm {
  private Apm() {}
  
  public static Apm a() {
    return InstanceHolder.a();
  }
  
  private void a(ApmProtos.Request.Builder paramBuilder) {
    paramBuilder.setClientTime(System.currentTimeMillis());
    ApmManager.a().a(paramBuilder.build());
  }
  
  public void a(long paramLong) {
    try {
      a(ApmProtos.Request.newBuilder().setType(ApmProtos.Type.OPEN_TIME).setTakes((int)paramLong).setExtra(Any.pack((Message)ApmProtos.OpenTimeTypeProto.newBuilder().build())));
      return;
    } catch (Exception exception) {
      return;
    } 
  }
  
  public void a(ApmProtos.GrpcConnectTypeProto.BUSINESS paramBUSINESS, int paramInt, long paramLong, Throwable paramThrowable, String paramString1, String paramString2) {
    try {
      a(ApmProtos.Request.newBuilder().setType(ApmProtos.Type.GRPC_CONNECT).setTakes((int)paramLong).setCode(paramInt).setDescription(Utils.a(paramThrowable)).setExtra(Any.pack((Message)ApmProtos.GrpcConnectTypeProto.newBuilder().setBusiness(paramBUSINESS).setHost(Utils.b(paramString1)).setPort(443).setServerIp(Utils.b(paramString2)).build())));
      return;
    } catch (Exception exception) {
      return;
    } 
  }
  
  public void a(ApmProtos.GrpcRequestTypeProto.BUSINESS paramBUSINESS, String paramString1, int paramInt, long paramLong, String paramString2, Throwable paramThrowable, String paramString3, String paramString4) {
    try {
      a(ApmProtos.Request.newBuilder().setType(ApmProtos.Type.GRPC_REQUEST).setCode(paramInt).setTakes((int)paramLong).setServerRequestId(Utils.b(paramString2)).setDescription(Utils.a(paramThrowable)).setExtra(Any.pack((Message)ApmProtos.GrpcRequestTypeProto.newBuilder().setBusiness(paramBUSINESS).setName(Utils.b(paramString1)).setHost(Utils.b(paramString3)).setPort(443).setServerIp(Utils.b(paramString4)).build())));
      return;
    } catch (Exception exception) {
      return;
    } 
  }
  
  public void a(String paramString1, int paramInt, String paramString2, long paramLong) {
    try {
      a(ApmProtos.Request.newBuilder().setType(ApmProtos.Type.SOCKET).setCode(200).setTakes((int)paramLong).setExtra(Any.pack((Message)ApmProtos.SocketTypeProto.newBuilder().setHost(Utils.b(paramString1)).setPort(paramInt).setServerIp(Utils.b(paramString2)).build())));
      return;
    } catch (Exception exception) {
      return;
    } 
  }
  
  public void a(String paramString1, int paramInt, String paramString2, long paramLong1, long paramLong2, String paramString3) {
    try {
      a(ApmProtos.Request.newBuilder().setType(ApmProtos.Type.HTTP).setCode(paramInt).setTakes((int)paramLong2).setExtra(Any.pack((Message)ApmProtos.HttpTypeProto.newBuilder().setUrl(Utils.b(paramString1)).setResponseType(Utils.b(paramString2)).setResponseLength((int)paramLong1).setServerIp(Utils.b(paramString3)).build())));
      return;
    } catch (Exception exception) {
      return;
    } 
  }
  
  public void a(String paramString1, int paramInt, String paramString2, Throwable paramThrowable, long paramLong) {
    try {
      a(ApmProtos.Request.newBuilder().setType(ApmProtos.Type.SOCKET).setTakes((int)paramLong).setCode(100).setDescription(Utils.a(paramThrowable)).setExtra(Any.pack((Message)ApmProtos.SocketTypeProto.newBuilder().setHost(Utils.b(paramString1)).setPort(paramInt).setServerIp(Utils.b(paramString2)).build())));
      return;
    } catch (Exception exception) {
      return;
    } 
  }
  
  public void a(String paramString1, int paramInt, String paramString2, Throwable paramThrowable, long paramLong, String paramString3) {
    try {
      a(ApmProtos.Request.newBuilder().setType(ApmProtos.Type.HTTP).setCode(paramInt).setTakes((int)paramLong).setDescription(Utils.a(paramThrowable)).setExtra(Any.pack((Message)ApmProtos.HttpTypeProto.newBuilder().setUrl(Utils.b(paramString1)).setResponseType(Utils.b(paramString2)).setServerIp(Utils.b(paramString3)).build())));
      return;
    } catch (Exception exception) {
      return;
    } 
  }
  
  public void a(String paramString, long paramLong) {
    try {
      a(ApmProtos.Request.newBuilder().setType(ApmProtos.Type.WEB).setTakes((int)paramLong).setCode(200).setExtra(Any.pack((Message)ApmProtos.WebTypeProto.newBuilder().setUrl(Utils.b(paramString)).build())));
      return;
    } catch (Exception exception) {
      return;
    } 
  }
  
  public void a(String paramString1, long paramLong, int paramInt, String paramString2) {
    try {
      a(ApmProtos.Request.newBuilder().setType(ApmProtos.Type.WEB).setTakes((int)paramLong).setCode(paramInt).setDescription(Utils.b(paramString2)).setExtra(Any.pack((Message)ApmProtos.WebTypeProto.newBuilder().setUrl(Utils.b(paramString1)).build())));
      return;
    } catch (Exception exception) {
      return;
    } 
  }
  
  public void a(String paramString1, long paramLong, String paramString2, int paramInt, String paramString3) {
    try {
      a(ApmProtos.Request.newBuilder().setType(ApmProtos.Type.IM).setCode(200).setTakes((int)paramLong).setExtra(Any.pack((Message)ApmProtos.ImTypeProto.newBuilder().setName(Utils.b(paramString1)).setHost(Utils.b(paramString2)).setPort(paramInt).setServerIp(Utils.b(paramString3)).build())));
      return;
    } catch (Exception exception) {
      return;
    } 
  }
  
  public void a(String paramString1, long paramLong, String paramString2, String paramString3, int paramInt, String paramString4) {
    try {
      a(ApmProtos.Request.newBuilder().setType(ApmProtos.Type.IM).setCode(100).setTakes((int)paramLong).setDescription(Utils.b(paramString2)).setExtra(Any.pack((Message)ApmProtos.ImTypeProto.newBuilder().setName(Utils.b(paramString1)).setHost(Utils.b(paramString3)).setPort(paramInt).setServerIp(Utils.b(paramString4)).build())));
      return;
    } catch (Exception exception) {
      return;
    } 
  }
  
  static class InstanceHolder {
    private static final Apm a = new Apm();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\blued\android\statistics\biz\Apm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */