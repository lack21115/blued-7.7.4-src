package com.alipay.tscenter.biz.rpc.deviceFp;

import com.alipay.mobile.framework.service.annotation.OperationType;

public interface BugTrackMessageService {
  @OperationType("alipay.security.errorLog.collect")
  String logCollect(String paramString);
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\alipay\tscenter\biz\rpc\deviceFp\BugTrackMessageService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */