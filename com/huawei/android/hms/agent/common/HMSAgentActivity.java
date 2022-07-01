package com.huawei.android.hms.agent.common;

import android.content.Intent;
import android.os.Bundle;
import com.huawei.hms.api.HuaweiApiAvailability;

public class HMSAgentActivity extends BaseAgentActivity {
  public static final String CONN_ERR_CODE_TAG = "HMSConnectionErrorCode";
  
  public static final String EXTRA_RESULT = "intent.extra.RESULT";
  
  private static final int REQUEST_HMS_RESOLVE_ERROR = 1000;
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt1 == 1000) {
      if (paramInt2 == -1) {
        paramInt1 = paramIntent.getIntExtra("intent.extra.RESULT", -1);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("dispose result:");
        stringBuilder.append(paramInt1);
        HMSAgentLog.d(stringBuilder.toString());
        ApiClientMgr.INST.onResolveErrorRst(paramInt1);
      } else {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("dispose error:");
        stringBuilder.append(paramInt2);
        HMSAgentLog.e(stringBuilder.toString());
        ApiClientMgr.INST.onResolveErrorRst(-1005);
      } 
      finish();
    } 
  }
  
  protected void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    ApiClientMgr.INST.onActivityLunched();
    Intent intent = getIntent();
    if (intent != null) {
      int i = intent.getIntExtra("HMSConnectionErrorCode", 0);
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("dispose code:");
      stringBuilder.append(i);
      HMSAgentLog.d(stringBuilder.toString());
      HuaweiApiAvailability.getInstance().resolveError(this, i, 1000);
      return;
    } 
    HMSAgentLog.e("intent is null");
    finish();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\android\hms\agent\common\HMSAgentActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */