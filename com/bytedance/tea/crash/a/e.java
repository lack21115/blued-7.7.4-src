package com.bytedance.tea.crash.a;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Looper;
import android.os.Process;
import com.bytedance.tea.crash.g.a;
import com.bytedance.tea.crash.g.m;
import org.json.JSONException;
import org.json.JSONObject;

public class e {
  static String a(Context paramContext, int paramInt) {
    ActivityManager.ProcessErrorStateInfo processErrorStateInfo = a.a(paramContext, paramInt);
    return (processErrorStateInfo != null && Process.myPid() == processErrorStateInfo.pid) ? b.a(processErrorStateInfo) : null;
  }
  
  public static JSONObject a(boolean paramBoolean) throws JSONException {
    StackTraceElement[] arrayOfStackTraceElement = Looper.getMainLooper().getThread().getStackTrace();
    JSONObject jSONObject = new JSONObject();
    jSONObject.put("thread_number", 1);
    jSONObject.put("mainStackFromTrace", m.a(arrayOfStackTraceElement));
    return jSONObject;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\tea\crash\a\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */