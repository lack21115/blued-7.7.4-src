package com.alipay.tscenter.biz.rpc.vkeydfp.request;

import java.io.Serializable;
import java.util.Map;

public class DeviceDataReportRequest implements Serializable {
  public String apdid;
  
  public Map<String, String> dataMap;
  
  public String lastTime;
  
  public String os;
  
  public String priApdid;
  
  public String pubApdid;
  
  public String token;
  
  public String umidToken;
  
  public String version;
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\alipay\tscenter\biz\rpc\vkeydfp\request\DeviceDataReportRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */