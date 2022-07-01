package com.blued.android.framework.permission;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.TextView;
import androidx.core.app.ActivityCompat;
import com.blued.android.core.AppInfo;
import com.blued.android.core.ui.BaseFragmentActivity;
import com.blued.android.core.ui.StatusBarHelper;
import com.blued.android.framework.R;
import com.blued.android.framework.ui.dialog.ConfirmDialog;
import com.blued.android.framework.utils.AppUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class PermissionActivity extends BaseFragmentActivity {
  private String[] c;
  
  private ConfirmDialog d;
  
  private void a(ArrayList<String> paramArrayList) {
    SpannableStringBuilder spannableStringBuilder;
    ConfirmDialog confirmDialog = this.d;
    if (confirmDialog != null && confirmDialog.c())
      return; 
    String str1 = PermissionManager.a((Context)this, paramArrayList);
    String str2 = AppUtils.a((Context)this);
    String str3 = getResources().getString(R.string.permission, new Object[] { str2, str1 });
    View view = LayoutInflater.from((Context)this).inflate(R.layout.dialog_permission, null);
    view.setVisibility(8);
    ((TextView)view.findViewById(R.id.tv_title)).setText(R.string.permission_title);
    TextView textView = (TextView)view.findViewById(R.id.tv_cancel);
    textView.setText(R.string.permission_cancel);
    textView.setOnClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            PermissionActivity.a(this.a);
          }
        });
    textView = (TextView)view.findViewById(R.id.tv_ok);
    textView.setText(R.string.permission_setting);
    textView.setOnClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            if (PermissionActivity.b(this.a) != null && PermissionActivity.b(this.a).c())
              PermissionActivity.b(this.a).a(); 
            Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
            intent.setData(Uri.fromParts("package", this.a.getPackageName(), null));
            this.a.startActivityForResult(intent, 2001);
          }
        });
    textView = (TextView)view.findViewById(R.id.tv_des);
    if (!TextUtils.isEmpty(str3) && !TextUtils.isEmpty(str1)) {
      int i = str3.indexOf(str1);
      if (i >= 0) {
        spannableStringBuilder = new SpannableStringBuilder(str3);
        spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#2593f4")), i, str1.length() + i, 33);
        textView.setText((CharSequence)spannableStringBuilder);
      } else {
        textView.setText((CharSequence)spannableStringBuilder);
      } 
    } else {
      textView.setText((CharSequence)spannableStringBuilder);
    } 
    this.d = new ConfirmDialog((Context)this);
    this.d.a(false);
    this.d.a(view);
    this.d.a(new ConfirmDialog.OperationListener(this) {
          public void a(ConfirmDialog.Operation param1Operation) {
            if (param1Operation == ConfirmDialog.Operation.d)
              PermissionActivity.a(this.a); 
          }
        });
    this.d.b();
    view.setVisibility(0);
    AlphaAnimation alphaAnimation = new AlphaAnimation(0.0F, 1.0F);
    alphaAnimation.setFillAfter(false);
    alphaAnimation.setDuration(300L);
    view.setAnimation((Animation)alphaAnimation);
    alphaAnimation.start();
  }
  
  private void h() {
    if (AppInfo.m())
      Log.v("PermissionActivity", "blued permission Granted."); 
    j();
    PermissionManager.a();
  }
  
  private void i() {
    if (AppInfo.m())
      Log.v("PermissionActivity", "blued permission Denied."); 
    j();
    PermissionManager.b(this.c);
  }
  
  private void j() {
    ConfirmDialog confirmDialog = this.d;
    if (confirmDialog != null)
      confirmDialog.a(); 
    overridePendingTransition(0, 0);
    finish();
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {
    if (AppInfo.m()) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("onActivityResult requestCode:");
      stringBuilder.append(paramInt1);
      Log.v("PermissionActivity", stringBuilder.toString());
    } 
    if (paramInt1 == 2001)
      if (PermissionManager.a(this.c)) {
        h();
      } else {
        i();
      }  
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    overridePendingTransition(0, 0);
    if (AppInfo.p())
      StatusBarHelper.a((Activity)this, false); 
    a(false);
    if (getIntent() != null) {
      paramBundle = getIntent().getExtras();
      if (paramBundle != null) {
        this.c = paramBundle.getStringArray("com.blued.android.framework.reqeust_permission_code");
        String[] arrayOfString = this.c;
        if (arrayOfString != null && arrayOfString.length > 0) {
          ActivityCompat.requestPermissions((Activity)this, arrayOfString, 2002);
          return;
        } 
      } 
      finish();
    } 
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfint) {
    if (AppInfo.m()) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("onRequestPermissionsResult:");
      stringBuilder.append(paramInt);
      stringBuilder.append(", ");
      stringBuilder.append(Arrays.toString((Object[])paramArrayOfString));
      stringBuilder.append(", ");
      stringBuilder.append(Arrays.toString(paramArrayOfint));
      Log.i("PermissionActivity", stringBuilder.toString());
    } 
    ArrayList<String> arrayList3 = new ArrayList();
    ArrayList<String> arrayList1 = new ArrayList();
    ArrayList<String> arrayList2 = new ArrayList();
    for (paramInt = 0; paramInt < paramArrayOfString.length; paramInt++) {
      String str = paramArrayOfString[paramInt];
      if (paramArrayOfint[paramInt] == 0) {
        arrayList3.add(str);
        if (AppInfo.m()) {
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append("onRequestPermissionsResul: PERMISSION_GRANTED: ");
          stringBuilder.append(str);
          Log.v("PermissionActivity", stringBuilder.toString());
        } 
      } else {
        arrayList1.add(str);
        if (AppInfo.m()) {
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append("onRequestPermissionsResult: PERMISSION_DENIED: ");
          stringBuilder.append(str);
          Log.v("PermissionActivity", stringBuilder.toString());
        } 
      } 
      if (!PermissionManager.a(new String[] { paramArrayOfString[paramInt] }))
        arrayList2.add(str); 
    } 
    if (!arrayList3.isEmpty() && arrayList1.isEmpty() && arrayList2.isEmpty()) {
      h();
      return;
    } 
    if (!arrayList1.isEmpty() || !arrayList2.isEmpty()) {
      ArrayList<String> arrayList = new ArrayList();
      arrayList.addAll(arrayList1);
      for (String str : arrayList2) {
        Iterator<String> iterator = arrayList1.iterator();
        paramInt = 1;
        while (iterator.hasNext()) {
          if (TextUtils.equals(str, iterator.next()))
            paramInt = 0; 
        } 
        if (paramInt != 0) {
          arrayList.add(str);
          if (AppInfo.m()) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("onRequestPermissionsResul: permissionStillNotGet: ");
            stringBuilder.append(str);
            Log.v("PermissionActivity", stringBuilder.toString());
          } 
        } 
      } 
      this.c = arrayList.<String>toArray(new String[arrayList.size()]);
      a(arrayList);
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\blued\android\framework\permission\PermissionActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */