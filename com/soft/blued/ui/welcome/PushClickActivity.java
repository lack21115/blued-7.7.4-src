package com.soft.blued.ui.welcome;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.blued.android.core.ui.BaseActivity;
import com.soft.blued.push.PushMsgModel;
import java.io.Serializable;

public class PushClickActivity extends BaseActivity {
  public static void a(Context paramContext, PushMsgModel paramPushMsgModel) {
    Intent intent = new Intent(paramContext, PushClickActivity.class);
    if (!(paramContext instanceof android.app.Activity))
      intent.setFlags(268435456); 
    intent.putExtra("push_msg_model", (Serializable)paramPushMsgModel);
    paramContext.startActivity(intent);
  }
  
  public void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    try {
      Intent intent = getIntent();
    } finally {
      paramBundle = null;
    } 
    finish();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\welcome\PushClickActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */