package com.alipay.security.mobile.module.http.model;

import com.alipay.security.mobile.module.a.a;
import com.alipay.tscenter.biz.rpc.report.general.model.DataReportRequest;
import com.alipay.tscenter.biz.rpc.report.general.model.DataReportResult;
import java.util.HashMap;
import java.util.Map;

public class b {
  public static c a(DataReportResult paramDataReportResult) {
    c c = new c();
    if (paramDataReportResult == null)
      return null; 
    c.a = paramDataReportResult.success;
    c.b = paramDataReportResult.resultCode;
    Map map = paramDataReportResult.resultData;
    if (map != null) {
      c.h = (String)map.get("apdid");
      c.i = (String)map.get("apdidToken");
      c.l = (String)map.get("dynamicKey");
      c.m = (String)map.get("timeInterval");
      c.n = (String)map.get("webrtcUrl");
      c.o = "";
      String str = (String)map.get("drmSwitch");
      if (a.b(str)) {
        if (str.length() > 0) {
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append(str.charAt(0));
          c.j = stringBuilder.toString();
        } 
        if (str.length() >= 3) {
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append(str.charAt(2));
          c.k = stringBuilder.toString();
        } 
      } 
      if (map.containsKey("apse_degrade"))
        c.p = (String)map.get("apse_degrade"); 
    } 
    return c;
  }
  
  public static DataReportRequest a(d paramd) {
    DataReportRequest dataReportRequest = new DataReportRequest();
    if (paramd == null)
      return null; 
    dataReportRequest.os = paramd.a;
    dataReportRequest.rpcVersion = paramd.j;
    dataReportRequest.bizType = "1";
    dataReportRequest.bizData = new HashMap<Object, Object>();
    dataReportRequest.bizData.put("apdid", paramd.b);
    dataReportRequest.bizData.put("apdidToken", paramd.c);
    dataReportRequest.bizData.put("umidToken", paramd.d);
    dataReportRequest.bizData.put("dynamicKey", paramd.e);
    dataReportRequest.deviceData = paramd.f;
    return dataReportRequest;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\alipay\security\mobile\module\http\model\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */