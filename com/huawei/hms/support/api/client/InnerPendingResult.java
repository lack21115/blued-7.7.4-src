package com.huawei.hms.support.api.client;

import java.util.concurrent.TimeUnit;

public abstract class InnerPendingResult<R extends Result> extends PendingResult<R> {
  public abstract R awaitOnAnyThread();
  
  public abstract R awaitOnAnyThread(long paramLong, TimeUnit paramTimeUnit);
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\hms\support\api\client\InnerPendingResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */