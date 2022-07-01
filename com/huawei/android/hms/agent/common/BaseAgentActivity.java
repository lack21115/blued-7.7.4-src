package com.huawei.android.hms.agent.common;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;

public class BaseAgentActivity extends Activity {
  public static final String EXTRA_IS_FULLSCREEN = "should_be_fullscreen";
  
  private void requestActivityTransparent() {
    try {
      Intent intent = getIntent();
      if (intent != null && intent.getBooleanExtra("should_be_fullscreen", false))
        getWindow().setFlags(1024, 1024); 
      requestWindowFeature(1);
      Window window = getWindow();
      if (window != null) {
        window.addFlags(67108864);
        return;
      } 
    } catch (Exception exception) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("requestActivityTransparent exception:");
      stringBuilder.append(exception.getMessage());
      HMSAgentLog.w(stringBuilder.toString());
    } 
  }
  
  protected void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    requestActivityTransparent();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\android\hms\agent\common\BaseAgentActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */