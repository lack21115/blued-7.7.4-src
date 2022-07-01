package com.huawei.hms.common.internal;

public class ResolveClientBean {
  private final int clientKey;
  
  private final AnyClient mClient;
  
  private int minSdkVersion;
  
  public ResolveClientBean(AnyClient paramAnyClient, int paramInt) {
    this.mClient = paramAnyClient;
    this.clientKey = Objects.hashCode(new Object[] { paramAnyClient });
    this.minSdkVersion = paramInt;
  }
  
  public void clientReconnect() {
    this.mClient.connect(this.minSdkVersion, true);
  }
  
  public boolean equals(Object paramObject) {
    if (this == paramObject)
      return true; 
    if (paramObject == null || !(paramObject instanceof ResolveClientBean))
      return false; 
    paramObject = paramObject;
    return this.mClient.equals(((ResolveClientBean)paramObject).mClient);
  }
  
  public AnyClient getClient() {
    return this.mClient;
  }
  
  public int hashCode() {
    return this.clientKey;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\hms\common\internal\ResolveClientBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */