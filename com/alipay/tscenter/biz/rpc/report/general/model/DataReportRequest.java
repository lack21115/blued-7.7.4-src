package com.alipay.tscenter.biz.rpc.report.general.model;

import java.io.Serializable;
import java.util.Map;

public class DataReportRequest implements Serializable {
  public Map<String, String> bizData;
  
  public String bizType;
  
  public Map<String, String> deviceData;
  
  public String os;
  
  public String rpcVersion;
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\alipay\tscenter\biz\rpc\report\general\model\DataReportRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */