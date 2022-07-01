package com.huawei.hms.update.ui;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.ResourceLoaderUtil;
import java.text.NumberFormat;

public class f extends b {
  private ProgressBar a;
  
  private TextView b;
  
  private int c = 0;
  
  private DialogInterface.OnKeyListener d = new a();
  
  public AlertDialog a() {
    AlertDialog.Builder builder = new AlertDialog.Builder((Context)f(), g());
    View view = View.inflate((Context)f(), ResourceLoaderUtil.getLayoutId("hms_download_progress"), null);
    builder.setView(view);
    builder.setCancelable(false);
    builder.setOnKeyListener(this.d);
    this.a = (ProgressBar)view.findViewById(ResourceLoaderUtil.getIdId("download_info_progress"));
    this.b = (TextView)view.findViewById(ResourceLoaderUtil.getIdId("hms_progress_text"));
    b(this.c);
    return builder.create();
  }
  
  public void a(int paramInt) {
    this.c = paramInt;
  }
  
  void b(int paramInt) {
    Activity activity = f();
    if (activity == null || activity.isFinishing()) {
      HMSLog.w("DownloadProgress", "In setDownloading, The activity is null or finishing.");
      return;
    } 
    if (this.b != null) {
      ProgressBar progressBar = this.a;
      if (progressBar == null)
        return; 
      progressBar.setProgress(paramInt);
      String str = NumberFormat.getPercentInstance().format((paramInt / 100.0F));
      this.b.setText(str);
    } 
  }
  
  static class a implements DialogInterface.OnKeyListener {
    private a() {}
    
    public boolean onKey(DialogInterface param1DialogInterface, int param1Int, KeyEvent param1KeyEvent) {
      return (param1Int == 4 && param1KeyEvent.getRepeatCount() == 0);
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\hm\\updat\\ui\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */