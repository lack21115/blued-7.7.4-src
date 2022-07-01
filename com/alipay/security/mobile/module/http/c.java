package com.alipay.security.mobile.module.http;

import com.alipay.security.mobile.module.a.a;
import com.alipay.tscenter.biz.rpc.report.general.model.DataReportRequest;
import com.alipay.tscenter.biz.rpc.report.general.model.DataReportResult;

class c implements Runnable {
  c(b paramb, DataReportRequest paramDataReportRequest) {}
  
  public void run() {
    try {
      return;
    } finally {
      Exception exception = null;
      b.a(new DataReportResult());
      (b.a()).success = false;
      DataReportResult dataReportResult = b.a();
      StringBuilder stringBuilder = new StringBuilder("static data rpc upload error, ");
      stringBuilder.append(a.a(exception));
      dataReportResult.resultCode = stringBuilder.toString();
      (new StringBuilder("rpc failed:")).append(a.a(exception));
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\alipay\security\mobile\module\http\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */