package com.blued.android.framework.permission;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.content.ContextCompat;
import androidx.core.content.PermissionChecker;
import com.blued.android.core.AppInfo;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;

public class PermissionManager {
  private static PermissionCallbacks a;
  
  private static HashMap<String, Integer> b;
  
  private static boolean c = false;
  
  protected static String a(Context paramContext, ArrayList<String> paramArrayList) {
    if (paramArrayList == null || paramArrayList.size() == 0)
      return ""; 
    StringBuilder stringBuilder = new StringBuilder(" ");
    if (b != null) {
      ArrayList<Integer> arrayList = new ArrayList();
      for (String str : paramArrayList) {
        if (!TextUtils.isEmpty(str)) {
          Integer integer = b.get(str);
          if (integer != null && !arrayList.contains(integer))
            arrayList.add(integer); 
        } 
      } 
      Iterator<Integer> iterator = arrayList.iterator();
      while (iterator.hasNext()) {
        stringBuilder.append(paramContext.getString(((Integer)iterator.next()).intValue()));
        stringBuilder.append(" ");
      } 
    } 
    return stringBuilder.toString();
  }
  
  protected static void a() {
    c = false;
    if (a != null) {
      if (AppInfo.m())
        Log.v("PermissionManager", "permission Granted."); 
      a.aa_();
      a = null;
    } 
  }
  
  public static void a(PermissionCallbacks paramPermissionCallbacks, String... paramVarArgs) {
    paramVarArgs = c(paramVarArgs);
    if (paramVarArgs == null || paramVarArgs.length == 0) {
      if (paramPermissionCallbacks != null)
        paramPermissionCallbacks.aa_(); 
      return;
    } 
    if (paramPermissionCallbacks != null)
      a = paramPermissionCallbacks; 
    c = true;
    Bundle bundle = new Bundle();
    bundle.putStringArray("com.blued.android.framework.reqeust_permission_code", paramVarArgs);
    Intent intent = new Intent(AppInfo.d(), PermissionActivity.class);
    intent.addFlags(268435456);
    intent.putExtras(bundle);
    AppInfo.d().startActivity(intent);
  }
  
  public static void a(HashMap<String, Integer> paramHashMap) {
    b = paramHashMap;
  }
  
  public static boolean a(String... paramVarArgs) {
    if (Build.VERSION.SDK_INT < 23)
      return true; 
    int j = paramVarArgs.length;
    for (int i = 0; i < j; i++) {
      boolean bool1;
      String str = paramVarArgs[i];
      if (ContextCompat.checkSelfPermission(AppInfo.d(), str) == 0) {
        bool1 = true;
      } else {
        bool1 = false;
      } 
      boolean bool2 = bool1;
      if (bool1) {
        bool2 = bool1;
        if (b())
          if (PermissionChecker.checkPermission(AppInfo.d(), str, Process.myPid(), Process.myUid(), AppInfo.d().getPackageName()) == 0) {
            bool2 = true;
          } else {
            bool2 = false;
          }  
      } 
      if (AppInfo.m()) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append(": ");
        stringBuilder.append(bool2);
        Log.i("PermissionManager", stringBuilder.toString());
      } 
      if (!bool2)
        return false; 
    } 
    return true;
  }
  
  protected static void b(String... paramVarArgs) {
    c = false;
    if (a != null) {
      if (AppInfo.m()) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("permission Denied or Cancel, ");
        stringBuilder.append(Arrays.toString((Object[])paramVarArgs));
        Log.v("PermissionManager", stringBuilder.toString());
      } 
      a.a(c(paramVarArgs));
      a = null;
    } 
  }
  
  private static boolean b() {
    return "xiaomi".equalsIgnoreCase(Build.MANUFACTURER);
  }
  
  private static String[] c(String... paramVarArgs) {
    ArrayList<String> arrayList = new ArrayList();
    int j = paramVarArgs.length;
    for (int i = 0; i < j; i++) {
      boolean bool1;
      String str = paramVarArgs[i];
      if (ContextCompat.checkSelfPermission(AppInfo.d(), str) == 0) {
        bool1 = true;
      } else {
        bool1 = false;
      } 
      boolean bool2 = bool1;
      if (bool1) {
        bool2 = bool1;
        if (b())
          if (PermissionChecker.checkPermission(AppInfo.d(), str, Process.myPid(), Process.myUid(), AppInfo.d().getPackageName()) == 0) {
            bool2 = true;
          } else {
            bool2 = false;
          }  
      } 
      if (!bool2)
        arrayList.add(str); 
    } 
    return arrayList.<String>toArray(new String[arrayList.size()]);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\blued\android\framework\permission\PermissionManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */