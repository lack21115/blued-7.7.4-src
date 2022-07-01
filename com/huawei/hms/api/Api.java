package com.huawei.hms.api;

import com.huawei.hms.common.api.ConnectionPostProcessor;
import com.huawei.hms.support.api.entity.auth.PermissionInfo;
import com.huawei.hms.support.api.entity.auth.Scope;
import java.util.Collections;
import java.util.List;

public class Api<O extends Api.ApiOptions> {
  private final String a;
  
  private final Options<O> b;
  
  public List<ConnectionPostProcessor> mConnetctPostList;
  
  public Api(String paramString) {
    this.a = paramString;
    this.b = null;
  }
  
  public Api(String paramString, Options<O> paramOptions) {
    this.a = paramString;
    this.b = paramOptions;
  }
  
  public String getApiName() {
    return this.a;
  }
  
  public Options<O> getOptions() {
    return this.b;
  }
  
  public List<ConnectionPostProcessor> getmConnetctPostList() {
    return this.mConnetctPostList;
  }
  
  public void setmConnetctPostList(List<ConnectionPostProcessor> paramList) {
    this.mConnetctPostList = paramList;
  }
  
  public static interface ApiOptions {
    public static interface HasOptions extends ApiOptions {}
    
    public static final class NoOptions implements NotRequiredOptions {}
    
    public static interface NotRequiredOptions extends ApiOptions {}
    
    public static interface Optional extends HasOptions, NotRequiredOptions {}
  }
  
  public static interface HasOptions extends ApiOptions {}
  
  public static final class NoOptions implements ApiOptions.NotRequiredOptions {}
  
  public static interface NotRequiredOptions extends ApiOptions {}
  
  public static interface Optional extends ApiOptions.HasOptions, ApiOptions.NotRequiredOptions {}
  
  public static abstract class Options<O> {
    public List<PermissionInfo> getPermissionInfoList(O param1O) {
      return Collections.emptyList();
    }
    
    public List<Scope> getScopeList(O param1O) {
      return Collections.emptyList();
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\hms\api\Api.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */