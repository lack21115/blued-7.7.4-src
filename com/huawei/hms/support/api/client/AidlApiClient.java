package com.huawei.hms.support.api.client;

import com.huawei.hms.core.aidl.d;
import java.util.List;

public interface AidlApiClient extends ApiClient {
  List<String> getApiNameList();
  
  d getService();
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\hms\support\api\client\AidlApiClient.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */