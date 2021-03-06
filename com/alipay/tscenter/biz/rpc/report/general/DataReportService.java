package com.alipay.tscenter.biz.rpc.report.general;

import com.alipay.mobile.framework.service.annotation.OperationType;
import com.alipay.tscenter.biz.rpc.report.general.model.DataReportRequest;
import com.alipay.tscenter.biz.rpc.report.general.model.DataReportResult;

public interface DataReportService {
  @OperationType("alipay.security.device.data.report")
  DataReportResult reportData(DataReportRequest paramDataReportRequest);
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\alipay\tscenter\biz\rpc\report\general\DataReportService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */