package com.soft.blued.version.update;

import android.app.DownloadManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.blued.android.core.AppInfo;
import com.blued.android.core.AppMethods;
import com.blued.android.core.ui.BaseDialogFragment;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.core.ui.TransparentActivity;
import com.blued.android.framework.download.model.DownloadBaseInfo;
import com.soft.blued.utils.AppUtils;
import com.soft.blued.utils.BluedPreferences;
import com.soft.blued.utils.DeviceUtils;
import com.soft.blued.utils.FileUtils;
import com.soft.blued.utils.StringUtils;
import com.soft.blued.view.tip.CommonAlertDialog;
import java.io.File;

public class UpdateVersionFragment extends BaseDialogFragment {
  public LayoutInflater a;
  
  private Context b;
  
  private String c;
  
  private String d;
  
  private String e;
  
  private String f;
  
  private String g;
  
  private long h;
  
  private View i;
  
  private TextView j;
  
  private TextView k;
  
  private TextView l;
  
  private TextView m;
  
  private TextView n;
  
  public static void a(Context paramContext, DownloadBaseInfo paramDownloadBaseInfo, String paramString) {
    Bundle bundle = new Bundle();
    if (paramDownloadBaseInfo != null)
      if (!TextUtils.isEmpty(paramDownloadBaseInfo.download_url)) {
        if (!a(paramDownloadBaseInfo.download_url))
          return; 
        bundle.putString("i_s_update_url", paramDownloadBaseInfo.download_url);
        bundle.putString("i_s_update_desc", paramDownloadBaseInfo.description);
        bundle.putString("i_s_update_version", paramDownloadBaseInfo.version);
        bundle.putString("i_s_update_title", paramDownloadBaseInfo.title);
      } else {
        return;
      }  
    bundle.putString("i_s_update_tag", paramString);
    TerminalActivity.a(bundle);
    TransparentActivity.b(paramContext, UpdateVersionFragment.class, bundle);
  }
  
  public static void a(Context paramContext, String paramString) {
    a(paramContext, (DownloadBaseInfo)null, paramString);
  }
  
  private void a(boolean paramBoolean) {
    if (TextUtils.isEmpty(this.f) || !a(this.f)) {
      getActivity().finish();
      return;
    } 
    if (!DeviceUtils.f()) {
      String str = AppMethods.d();
      if (!TextUtils.isEmpty(str)) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Blued_");
        stringBuilder.append(this.g);
        stringBuilder.append(".apk");
        File file = new File(str, stringBuilder.toString());
        UpdateVersionHelper.a(file);
        DownloadManager downloadManager = (DownloadManager)getActivity().getSystemService("download");
        try {
          DownloadManager.Request request = new DownloadManager.Request(Uri.parse(this.f));
          request.setDestinationUri(Uri.fromFile(file));
          request.setTitle(getResources().getString(2131756216));
          request.setNotificationVisibility(1);
          long l = downloadManager.enqueue(request);
          BluedPreferences.e(l);
          BluedPreferences.a(l, file.getAbsolutePath());
        } catch (Exception exception) {
          exception.printStackTrace();
          startActivity(new Intent("android.intent.action.VIEW", Uri.parse(this.f)));
        } 
      } else {
        startActivity(new Intent("android.intent.action.VIEW", Uri.parse(this.f)));
      } 
    } else {
      UpdateVersionHelper.c(this.b);
    } 
    if (!paramBoolean) {
      getActivity().finish();
      return;
    } 
    AppUtils.a(AppInfo.d());
  }
  
  private static boolean a(String paramString) {
    return Patterns.WEB_URL.matcher(paramString).matches();
  }
  
  private void f() {
    this.i.setVisibility(8);
    this.j = (TextView)this.i.findViewById(2131301123);
    this.k = (TextView)this.i.findViewById(2131300647);
    this.l = (TextView)this.i.findViewById(2131300663);
    this.m = (TextView)this.i.findViewById(2131301463);
    this.n = (TextView)this.i.findViewById(2131300611);
  }
  
  private void g() {
    Bundle bundle = getArguments();
    if (bundle == null) {
      getActivity().finish();
      return;
    } 
    this.c = bundle.getString("i_s_update_tag");
    this.d = bundle.getString("i_s_update_title");
    this.e = bundle.getString("i_s_update_desc");
    this.f = bundle.getString("i_s_update_url");
    this.g = bundle.getString("i_s_update_version");
    this.h = BluedPreferences.bD();
    if (!StringUtils.e(this.g)) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("V");
      stringBuilder.append(this.g);
      String str = stringBuilder.toString();
      this.k.setText(str);
    } 
    if (!TextUtils.isEmpty(this.d))
      this.j.setText(this.d); 
    this.l.setText(this.e);
  }
  
  private boolean h() {
    Context context = this.b;
    if (context == null)
      return false; 
    try {
      DownloadManager downloadManager = (DownloadManager)context.getSystemService("download");
      DownloadManager.Query query = new DownloadManager.Query();
      if (this.h != -1L) {
        query.setFilterById(new long[] { this.h });
        Cursor cursor = downloadManager.query(query);
        if (cursor != null) {
          boolean bool = cursor.moveToFirst();
          if (bool)
            try {
              int i = cursor.getInt(cursor.getColumnIndex("status"));
            } finally {
              cursor.close();
            }  
        } 
      } 
      if ("i_s_weak_update".equals(this.c)) {
        j();
        return true;
      } 
      if ("i_s_strong_update".equals(this.c)) {
        k();
        return true;
      } 
      return false;
    } catch (SecurityException securityException) {
      securityException.printStackTrace();
      return false;
    } 
  }
  
  private void i() {
    CommonAlertDialog.a(this.b, null, getResources().getString(2131757065), getResources().getString(2131757064), getResources().getString(2131755726), getResources().getString(2131758968), new DialogInterface.OnClickListener(this) {
          public void onClick(DialogInterface param1DialogInterface, int param1Int) {
            String str = BluedPreferences.f(UpdateVersionFragment.a(this.a));
            if (!TextUtils.isEmpty(str))
              FileUtils.b(new File(str)); 
            BluedPreferences.e(-1L);
            UpdateVersionFragment.b(this.a);
          }
        },  new DialogInterface.OnClickListener(this) {
          public void onClick(DialogInterface param1DialogInterface, int param1Int) {
            UpdateVersionFragment.b(this.a);
          }
        },  new DialogInterface.OnCancelListener(this) {
          public void onCancel(DialogInterface param1DialogInterface) {
            UpdateVersionFragment.b(this.a);
          }
        },  true);
  }
  
  private void j() {
    this.i.setVisibility(0);
    this.m.setOnClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            UpdateVersionFragment.a(this.a, false);
          }
        });
    this.n.setOnClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            UpdateVersionFragment.b(this.a);
          }
        });
    this.i.setOnClickListener(null);
  }
  
  private void k() {
    this.i.setVisibility(0);
    this.m.setOnClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            UpdateVersionFragment.a(this.a, true);
          }
        });
    this.n.setOnClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            AppUtils.a(AppInfo.d());
          }
        });
    this.i.setOnClickListener(null);
  }
  
  private void l() {
    getActivity().finish();
  }
  
  public boolean V_() {
    if ("i_s_strong_update".equals(this.c)) {
      AppUtils.a(AppInfo.d());
      return true;
    } 
    return false;
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
    this.b = (Context)getActivity();
    this.a = LayoutInflater.from(this.b);
    if (this.i == null) {
      this.i = paramLayoutInflater.inflate(2131493034, paramViewGroup, false);
      f();
    } 
    g();
    if (!h())
      l(); 
    return this.i;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blued\versio\\update\UpdateVersionFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */