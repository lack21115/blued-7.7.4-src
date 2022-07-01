package com.blued.android.module.live.im.biz;

import android.os.Build;
import cn.irisgw.live.LiveConnect;
import cn.irisgw.live.LiveConnectorGrpc;
import com.blued.android.module.im.grpc.BaseConnector;
import com.blued.android.module.im.grpc.ChannelManager;
import com.blued.android.module.live.im.LiveIMConfig;
import com.blued.android.statistics.util.DeviceUtils;
import com.blued.android.statistics.util.Utils;
import com.blued.das.apm.ApmProtos;
import com.google.protobuf.Any;
import com.google.protobuf.Message;
import io.grpc.MethodDescriptor;

public final class LiveConnector extends BaseConnector {
  public LiveConnector(ChannelManager paramChannelManager) {
    super(paramChannelManager);
  }
  
  public ApmProtos.GrpcConnectTypeProto.BUSINESS a() {
    return ApmProtos.GrpcConnectTypeProto.BUSINESS.LIVE_CHAT;
  }
  
  public Any a(Any paramAny) throws Exception {
    if (paramAny.is(LiveConnect.LiveBasePackage.class)) {
      LiveConnect.LiveBasePackage liveBasePackage = (LiveConnect.LiveBasePackage)paramAny.unpack(LiveConnect.LiveBasePackage.class);
      if (liveBasePackage.getNeedAck()) {
        LiveConnect.LiveBasePackageAck liveBasePackageAck = LiveConnect.LiveBasePackageAck.newBuilder().setPackageId(liveBasePackage.getPackageId()).build();
        if (LiveIMConfig.b())
          LiveIMConfig.a().b(new Object[] { ">> sendAck : ", liveBasePackageAck }); 
        b(Any.pack((Message)liveBasePackageAck));
      } 
      return liveBasePackage.getBody();
    } 
    return null;
  }
  
  public void a(String paramString1, String paramString2, String paramString3, String paramString4) {
    try {
      LiveConnect.LiveSetting liveSetting = LiveConnect.LiveSetting.newBuilder().setAppVersion(Utils.b(paramString1)).setPlatform(Utils.b(paramString2)).setLanguage(Utils.b(paramString3)).setOsVersion(Utils.b(Build.VERSION.RELEASE)).setDevice(Utils.b(DeviceUtils.a())).setChannel(Utils.b(paramString4)).build();
      if (LiveIMConfig.b())
        LiveIMConfig.a().b(new Object[] { ">> sendSetting : ", liveSetting }); 
      b(Any.pack((Message)liveSetting));
      return;
    } catch (Exception exception) {
      exception.printStackTrace();
      return;
    } 
  }
  
  public boolean b() {
    return LiveIMConfig.b();
  }
  
  public MethodDescriptor c() {
    return LiveConnectorGrpc.getConnectMethod();
  }
  
  public void d() {}
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\live\im\biz\LiveConnector.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */