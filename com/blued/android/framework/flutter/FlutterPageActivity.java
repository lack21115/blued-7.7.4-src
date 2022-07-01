package com.blued.android.framework.flutter;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.fragment.app.Fragment;
import com.blued.android.core.ui.BaseFragmentActivity;
import com.blued.android.core.ui.StatusBarHelper;
import com.blued.android.framework.utils.LogUtils;
import io.flutter.embedding.android.FlutterFragment;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.embedding.engine.FlutterEngineCache;
import io.flutter.embedding.engine.dart.DartExecutor;

public class FlutterPageActivity extends BaseFragmentActivity {
  FlutterEngine c;
  
  String d = "blued_engine";
  
  private void h() {}
  
  public void onBackPressed() {
    if (this.c != null) {
      LogUtils.c("flutterEngine.popRoute()");
      this.c.getNavigationChannel().popRoute();
      return;
    } 
    super.onBackPressed();
  }
  
  public void onCreate(Bundle paramBundle) {
    try {
      String str1;
      super.onCreate(paramBundle);
      setContentView(2131492903);
      StatusBarHelper.a((Activity)this);
      Intent intent = getIntent();
      if (intent != null) {
        str1 = getIntent().getStringExtra("route_arg");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("strArg: ");
        stringBuilder.append(str1);
        LogUtils.c(stringBuilder.toString());
      } else {
        str1 = "/";
      } 
      String str2 = str1;
      if (TextUtils.isEmpty(str1))
        str2 = "/"; 
      this.d = String.valueOf(SystemClock.elapsedRealtime());
      this.c = FlutterEngineCache.getInstance().get(this.d);
      if (this.c == null) {
        LogUtils.c("flutterEngine == null, create new one");
        this.c = new FlutterEngine(getApplicationContext());
        FlutterEngineCache.getInstance().put(this.d, this.c);
      } 
      this.c.getNavigationChannel().setInitialRoute(str2);
      this.c.getDartExecutor().executeDartEntrypoint(DartExecutor.DartEntrypoint.createDefault());
      FlutterFragment flutterFragment = FlutterFragment.withCachedEngine(this.d).destroyEngineWithFragment(true).shouldAttachEngineToActivity(true).build();
      h();
      getSupportFragmentManager().beginTransaction().add(2131297190, (Fragment)flutterFragment).commit();
      return;
    } catch (Exception exception) {
      exception.printStackTrace();
      finish();
      return;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\blued\android\framework\flutter\FlutterPageActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */