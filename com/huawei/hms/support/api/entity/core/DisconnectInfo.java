package com.huawei.hms.support.api.entity.core;

import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.core.aidl.annotation.Packed;
import com.huawei.hms.support.api.entity.auth.Scope;
import java.util.List;

public class DisconnectInfo implements IMessageEntity {
  @Packed
  public List<String> apiNameList;
  
  @Packed
  public List<Scope> scopeList;
  
  public DisconnectInfo() {}
  
  public DisconnectInfo(List<Scope> paramList, List<String> paramList1) {
    this.scopeList = paramList;
    this.apiNameList = paramList1;
  }
  
  public List<String> getApiNameList() {
    return this.apiNameList;
  }
  
  public List<Scope> getScopeList() {
    return this.scopeList;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\hms\support\api\entity\core\DisconnectInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */