package com.soft.blued.tinker.app;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Environment;
import android.os.Process;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import com.soft.blued.tinker.util.Utils;
import com.soft.blued.utils.Logger;
import com.tencent.tinker.lib.library.TinkerLoadLibrary;
import com.tencent.tinker.lib.tinker.Tinker;
import com.tencent.tinker.lib.tinker.TinkerInstaller;
import com.tencent.tinker.lib.util.TinkerLog;
import com.tencent.tinker.loader.shareutil.ShareTinkerInternals;

public class TinkerTestActivity extends Activity {
  public boolean a(Context paramContext) {
    StringBuilder stringBuilder = new StringBuilder();
    Tinker tinker = Tinker.with(getApplicationContext());
    if (tinker.isTinkerLoaded()) {
      stringBuilder.append(String.format("[patch is loaded] \n", new Object[0]));
      stringBuilder.append(String.format("[buildConfig TINKER_ID] %s \n", new Object[] { BuildInfo.e }));
      stringBuilder.append(String.format("[buildConfig BASE_TINKER_ID] %s \n", new Object[] { BaseBuildInfo.b }));
      stringBuilder.append(String.format("[buildConfig MESSSAGE] %s \n", new Object[] { BuildInfo.d }));
      stringBuilder.append(String.format("[TINKER_ID] %s \n", new Object[] { tinker.getTinkerLoadResultIfPresent().getPackageConfigByName("TINKER_ID") }));
      stringBuilder.append(String.format("[packageConfig patchMessage] %s \n", new Object[] { tinker.getTinkerLoadResultIfPresent().getPackageConfigByName("patchMessage") }));
      stringBuilder.append(String.format("[packageConfig patchCode] %s \n", new Object[] { tinker.getTinkerLoadResultIfPresent().getPackageConfigByName("patchCode") }));
      stringBuilder.append(String.format("[TINKER_ID Rom Space] %d k \n", new Object[] { Long.valueOf(tinker.getTinkerRomSpace()) }));
    } else {
      stringBuilder.append(String.format("[patch is not loaded] \n", new Object[0]));
      stringBuilder.append(String.format("[buildConfig TINKER_ID] %s \n", new Object[] { BuildInfo.e }));
      stringBuilder.append(String.format("[buildConfig BASE_TINKER_ID] %s \n", new Object[] { BaseBuildInfo.b }));
      stringBuilder.append(String.format("[buildConfig MESSSAGE] %s \n", new Object[] { BuildInfo.d }));
      stringBuilder.append(String.format("[TINKER_ID] %s \n", new Object[] { ShareTinkerInternals.getManifestTinkerID(getApplicationContext()) }));
    } 
    stringBuilder.append(String.format("[BaseBuildInfo Message] %s \n", new Object[] { BaseBuildInfo.a }));
    TextView textView = new TextView(paramContext);
    textView.setText(stringBuilder.toString());
    textView.setGravity(19);
    textView.setTextSize(1, 10.0F);
    textView.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
    textView.setTextColor(-16777216);
    textView.setTypeface(Typeface.MONOSPACE);
    textView.setPadding(16, 16, 16, 16);
    AlertDialog.Builder builder = new AlertDialog.Builder(paramContext);
    builder.setCancelable(true);
    builder.setView((View)textView);
    builder.create().show();
    Logger.b("xpf", new Object[] { stringBuilder.toString() });
    return true;
  }
  
  protected void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    setContentView(2131494156);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("i am on onCreate classloader:");
    stringBuilder.append(TinkerTestActivity.class.getClassLoader().toString());
    TinkerLog.e("Tinker.TinkerTestActivity", stringBuilder.toString(), new Object[0]);
    TinkerLog.e("Tinker.TinkerTestActivity", "i am on patch onCreate", new Object[0]);
    ((Button)findViewById(2131299150)).setOnClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            Context context = this.a.getApplicationContext();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(Environment.getExternalStorageDirectory().getAbsolutePath());
            stringBuilder.append("/patch_signed_7zip.apk");
            TinkerInstaller.onReceiveUpgradePatch(context, stringBuilder.toString());
          }
        });
    ((Button)findViewById(2131299149)).setOnClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            TinkerLoadLibrary.installNavitveLibraryABI(this.a.getApplicationContext(), "armeabi");
            System.loadLibrary("stlport_shared");
          }
        });
    ((Button)findViewById(2131296773)).setOnClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            Tinker.with(this.a.getApplicationContext()).cleanPatch();
          }
        });
    ((Button)findViewById(2131297986)).setOnClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            ShareTinkerInternals.killAllOtherProcess(this.a.getApplicationContext());
            Process.killProcess(Process.myPid());
          }
        });
    ((Button)findViewById(2131299955)).setOnClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            TinkerTestActivity tinkerTestActivity = this.a;
            tinkerTestActivity.a((Context)tinkerTestActivity);
          }
        });
  }
  
  protected void onPause() {
    super.onPause();
    Utils.a(true);
  }
  
  protected void onResume() {
    TinkerLog.e("Tinker.TinkerTestActivity", "i am on onResume", new Object[0]);
    super.onResume();
    Utils.a(false);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blued\tinker\app\TinkerTestActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */