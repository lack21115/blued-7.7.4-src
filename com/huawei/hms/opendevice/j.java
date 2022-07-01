package com.huawei.hms.opendevice;

import android.content.Context;
import com.huawei.hms.aaid.constant.ErrorEnum;
import com.huawei.hms.aaid.entity.AAIDResult;
import java.util.concurrent.Callable;

public class j implements Callable<AAIDResult> {
  public Context a;
  
  public j(Context paramContext) {
    this.a = paramContext;
  }
  
  public AAIDResult call() throws Exception {
    Context context = this.a;
    if (context != null) {
      String str = o.c(context);
      AAIDResult aAIDResult = new AAIDResult();
      aAIDResult.setId(str);
      return aAIDResult;
    } 
    throw ErrorEnum.ERROR_ARGUMENTS_INVALID.toApiException();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\hms\opendevice\j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */