package com.tencent.connect.dataprovider;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import java.io.File;
import java.lang.ref.WeakReference;

public final class CallbackManager {
  private WeakReference<Context> a;
  
  private Uri b;
  
  private String c;
  
  private String d;
  
  private String e;
  
  private String f;
  
  private boolean g = false;
  
  private int h;
  
  public CallbackManager(Activity paramActivity) {
    this.a = new WeakReference<Context>(paramActivity.getApplicationContext());
    Intent intent = paramActivity.getIntent();
    if (intent != null) {
      this.b = intent.getData();
      this.c = intent.getStringExtra("srcPackageName");
      this.d = intent.getStringExtra("srcClassName");
      this.e = intent.getStringExtra("srcAction");
      this.h = intent.getIntExtra("requestDataTypeFlag", 0);
      this.f = intent.getStringExtra("params_appid");
      if (this.b != null && this.d != null)
        this.g = true; 
    } 
  }
  
  private int a(Bundle paramBundle) {
    if (!this.g)
      return -2; 
    if (this.a == null)
      return -3; 
    Intent intent = new Intent();
    intent.setClassName(this.c, this.d);
    intent.setAction(this.e);
    paramBundle.putString("params_appid", this.f);
    intent.putExtras(paramBundle);
    intent.setFlags(268435456);
    ((Context)this.a.get()).startActivity(intent);
    return 0;
  }
  
  private int a(String paramString) {
    if (paramString == null)
      return -7; 
    String str = paramString.toLowerCase();
    if (str.startsWith("http://"))
      return 0; 
    if (Environment.getExternalStorageState().equals("mounted")) {
      if (!str.startsWith(Environment.getExternalStorageDirectory().toString().toLowerCase()))
        return -5; 
      File file = new File(paramString);
      if (!file.exists() || file.isDirectory())
        return -8; 
      long l = file.length();
      return (l == 0L) ? -9 : ((l > 1073741824L) ? -6 : 0);
    } 
    return -10;
  }
  
  public int getRequestDateTypeFlag() {
    return this.h;
  }
  
  public boolean isCallFromTencentApp() {
    return this.g;
  }
  
  public boolean isSupportType(int paramInt) {
    return ((paramInt & getRequestDateTypeFlag()) != 0);
  }
  
  public int sendTextAndImagePath(String paramString1, String paramString2) {
    if (!isSupportType(1))
      return -1; 
    int i = a(paramString2);
    if (i != 0)
      return i; 
    DataType.TextAndMediaPath textAndMediaPath = new DataType.TextAndMediaPath(paramString1, paramString2);
    Bundle bundle = new Bundle();
    bundle.putInt("contentDataType", 1);
    bundle.putParcelable("contentData", textAndMediaPath);
    return a(bundle);
  }
  
  public int sendTextAndVideoPath(String paramString1, String paramString2) {
    if (!isSupportType(2))
      return -1; 
    int i = a(paramString2);
    if (i != 0)
      return i; 
    DataType.TextAndMediaPath textAndMediaPath = new DataType.TextAndMediaPath(paramString1, paramString2);
    Bundle bundle = new Bundle();
    bundle.putInt("contentDataType", 2);
    bundle.putParcelable("contentData", textAndMediaPath);
    return a(bundle);
  }
  
  public int sendTextOnly(String paramString) {
    if (!isSupportType(4))
      return -1; 
    DataType.TextOnly textOnly = new DataType.TextOnly(paramString);
    Bundle bundle = new Bundle();
    bundle.putInt("contentDataType", 4);
    bundle.putParcelable("contentData", textOnly);
    return a(bundle);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\tencent\connect\dataprovider\CallbackManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */