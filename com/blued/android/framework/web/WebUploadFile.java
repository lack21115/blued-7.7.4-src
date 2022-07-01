package com.blued.android.framework.web;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Environment;
import android.os.Parcelable;
import android.text.TextUtils;
import android.text.format.DateFormat;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import androidx.fragment.app.Fragment;
import com.blued.android.core.AppMethods;
import com.blued.android.framework.provider.ProviderHolder;
import java.io.File;

public class WebUploadFile {
  public static int a = 1;
  
  private Fragment b;
  
  private ValueCallback<Uri> c;
  
  private String d = "";
  
  private ValueCallback<Uri[]> e;
  
  public WebUploadFile(Fragment paramFragment) {
    this.b = paramFragment;
  }
  
  private Intent a() {
    Intent intent1 = new Intent("android.intent.action.GET_CONTENT");
    intent1.addCategory("android.intent.category.OPENABLE");
    intent1.setType("*/*");
    Intent intent2 = a(new Intent[] { b(), c(), d() });
    intent2.putExtra("android.intent.extra.INTENT", (Parcelable)intent1);
    return intent2;
  }
  
  private Intent a(String paramString) {
    Intent intent = new Intent("android.intent.action.GET_CONTENT");
    intent.addCategory("android.intent.category.OPENABLE");
    intent.setType(paramString);
    return intent;
  }
  
  private Intent a(Intent... paramVarArgs) {
    Intent intent = new Intent("android.intent.action.CHOOSER");
    intent.putExtra("android.intent.extra.INITIAL_INTENTS", (Parcelable[])paramVarArgs);
    intent.putExtra("android.intent.extra.TITLE", ProviderHolder.a().c().a());
    return intent;
  }
  
  private Intent b() {
    String str;
    Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
    File file1 = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM);
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append(file1.getAbsolutePath());
    stringBuilder1.append(File.separator);
    stringBuilder1.append("Camera");
    File file2 = new File(stringBuilder1.toString());
    file2.mkdirs();
    long l = System.currentTimeMillis();
    if (l != 0L) {
      str = DateFormat.format("yyyyMMdd_kkmmss", l).toString();
    } else {
      str = "";
    } 
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append(file2.getAbsolutePath());
    stringBuilder2.append(File.separator);
    stringBuilder2.append("IMG_");
    stringBuilder2.append(str);
    stringBuilder2.append(".jpg");
    this.d = stringBuilder2.toString();
    intent.putExtra("output", (Parcelable)Uri.fromFile(new File(this.d)));
    return intent;
  }
  
  private Intent c() {
    return new Intent("android.media.action.VIDEO_CAPTURE");
  }
  
  private Intent d() {
    return new Intent("android.provider.MediaStore.RECORD_SOUND");
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent) {
    if (this.c == null && this.e == null)
      return; 
    if (paramInt1 == a && paramInt2 == -1) {
      String str;
      if (this.c != null) {
        if (paramIntent != null) {
          Uri uri = paramIntent.getData();
          String[] arrayOfString = new String[1];
          arrayOfString[0] = "_data";
          Cursor cursor = this.b.getActivity().getContentResolver().query(uri, arrayOfString, null, null, null);
          if (cursor != null) {
            cursor.moveToFirst();
            String str1 = cursor.getString(cursor.getColumnIndex(arrayOfString[0]));
            cursor.close();
            if (!TextUtils.isEmpty(str1) && (new File(str1)).exists()) {
              this.c.onReceiveValue(Uri.fromFile(new File(str1)));
            } else {
              Uri uri1;
              if (paramIntent == null || paramInt2 != -1) {
                paramIntent = null;
              } else {
                uri1 = paramIntent.getData();
              } 
              this.c.onReceiveValue(uri1);
            } 
            this.c = null;
          } 
        } else {
          str = this.d;
          if (str != null && !str.isEmpty()) {
            this.c.onReceiveValue(Uri.fromFile(new File(this.d)));
            this.d = "";
            this.c = null;
          } 
        } 
      } else if (this.e != null && AppMethods.c(21)) {
        b(paramInt1, paramInt2, (Intent)str);
      } 
    } 
    ValueCallback<Uri> valueCallback1 = this.c;
    if (valueCallback1 != null) {
      valueCallback1.onReceiveValue(null);
      this.c = null;
      this.d = "";
      return;
    } 
    ValueCallback<Uri[]> valueCallback = this.e;
    if (valueCallback != null) {
      valueCallback.onReceiveValue(null);
      this.e = null;
    } 
  }
  
  public void a(ValueCallback<Uri> paramValueCallback, String paramString1, String paramString2) {
    String str1;
    String str2 = paramString1;
    if (paramString1 == null)
      str2 = ""; 
    paramString1 = paramString2;
    if (paramString2 == null)
      paramString1 = ""; 
    if (this.c != null)
      return; 
    this.c = paramValueCallback;
    String[] arrayOfString = str2.split(";");
    str2 = arrayOfString[0];
    if (paramString1.length() > 0) {
      str1 = paramString1;
    } else {
      str1 = "filesystem";
    } 
    paramString2 = str1;
    if (paramString1.equals("filesystem")) {
      int j = arrayOfString.length;
      int i = 0;
      while (i < j) {
        String[] arrayOfString1 = arrayOfString[i].split("=");
        paramString1 = str1;
        if (arrayOfString1.length == 2) {
          paramString1 = str1;
          if ("capture".equals(arrayOfString1[0]))
            paramString1 = arrayOfString1[1]; 
        } 
        i++;
        str1 = paramString1;
      } 
      paramString2 = str1;
    } 
    this.d = null;
    if (str2.equals("image/*")) {
      if (paramString2.equals("camera")) {
        this.b.startActivityForResult(b(), a);
        return;
      } 
      Intent intent = a(new Intent[] { b() });
      intent.putExtra("android.intent.extra.INTENT", (Parcelable)a("image/*"));
      this.b.startActivityForResult(intent, a);
      return;
    } 
    if (str2.equals("video/*")) {
      if (paramString2.equals("camcorder")) {
        this.b.startActivityForResult(c(), a);
        return;
      } 
      Intent intent = a(new Intent[] { c() });
      intent.putExtra("android.intent.extra.INTENT", (Parcelable)a("video/*"));
      this.b.startActivityForResult(intent, a);
      return;
    } 
    if (str2.equals("audio/*")) {
      if (paramString2.equals("microphone")) {
        this.b.startActivityForResult(d(), a);
        return;
      } 
      Intent intent = a(new Intent[] { d() });
      intent.putExtra("android.intent.extra.INTENT", (Parcelable)a("audio/*"));
      this.b.startActivityForResult(intent, a);
      return;
    } 
    this.b.startActivityForResult(a(), a);
  }
  
  public void a(WebView paramWebView, ValueCallback<Uri[]> paramValueCallback, WebChromeClient.FileChooserParams paramFileChooserParams) {
    if (AppMethods.c(21)) {
      this.e = paramValueCallback;
      Intent intent = paramFileChooserParams.createIntent();
      try {
        this.b.startActivityForResult(intent, a);
        return;
      } catch (ActivityNotFoundException activityNotFoundException) {
        activityNotFoundException.printStackTrace();
      } 
    } 
  }
  
  public void b(int paramInt1, int paramInt2, Intent paramIntent) {
    ValueCallback<Uri[]> valueCallback = this.e;
    if (valueCallback == null)
      return; 
    if (paramInt2 == -1 && valueCallback != null) {
      Uri[] arrayOfUri = WebChromeClient.FileChooserParams.parseResult(paramInt2, paramIntent);
      this.e.onReceiveValue(arrayOfUri);
    } else {
      this.e.onReceiveValue(null);
    } 
    this.e = null;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\framework\web\WebUploadFile.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */