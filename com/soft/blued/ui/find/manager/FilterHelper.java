package com.soft.blued.ui.find.manager;

import android.text.TextUtils;
import com.blued.android.core.AppInfo;
import com.soft.blued.user.BluedConfig;
import com.soft.blued.user.UserInfo;
import com.soft.blued.utils.BluedPreferences;
import com.soft.blued.utils.StringUtils;

public class FilterHelper {
  private static FilterHelper i;
  
  private String[] a;
  
  private String[] b;
  
  private String[] c;
  
  private boolean d;
  
  private String e;
  
  private String f;
  
  private String g;
  
  private String h;
  
  private FilterHelper() {
    o();
  }
  
  public static FilterHelper d() {
    // Byte code:
    //   0: getstatic com/soft/blued/ui/find/manager/FilterHelper.i : Lcom/soft/blued/ui/find/manager/FilterHelper;
    //   3: ifnonnull -> 37
    //   6: ldc com/soft/blued/ui/find/manager/FilterHelper
    //   8: monitorenter
    //   9: getstatic com/soft/blued/ui/find/manager/FilterHelper.i : Lcom/soft/blued/ui/find/manager/FilterHelper;
    //   12: ifnonnull -> 25
    //   15: new com/soft/blued/ui/find/manager/FilterHelper
    //   18: dup
    //   19: invokespecial <init> : ()V
    //   22: putstatic com/soft/blued/ui/find/manager/FilterHelper.i : Lcom/soft/blued/ui/find/manager/FilterHelper;
    //   25: ldc com/soft/blued/ui/find/manager/FilterHelper
    //   27: monitorexit
    //   28: goto -> 37
    //   31: astore_0
    //   32: ldc com/soft/blued/ui/find/manager/FilterHelper
    //   34: monitorexit
    //   35: aload_0
    //   36: athrow
    //   37: getstatic com/soft/blued/ui/find/manager/FilterHelper.i : Lcom/soft/blued/ui/find/manager/FilterHelper;
    //   40: areturn
    // Exception table:
    //   from	to	target	type
    //   9	25	31	finally
    //   25	28	31	finally
    //   32	35	31	finally
  }
  
  private void o() {
    int i = BluedPreferences.aD();
    if (i != 1) {
      if (i == 2)
        this.d = true; 
    } else {
      this.d = false;
    } 
    this.a = AppInfo.d().getResources().getStringArray(2130903040);
    if (this.d) {
      this.b = AppInfo.d().getResources().getStringArray(2130903080);
      this.c = StringUtils.a(AppInfo.d());
    } else {
      this.b = AppInfo.d().getResources().getStringArray(2130903075);
      this.c = AppInfo.d().getResources().getStringArray(2130903115);
    } 
    this.e = AppInfo.d().getResources().getString(2131759104);
    this.f = AppInfo.d().getResources().getString(2131757112);
    this.g = AppInfo.d().getResources().getString(2131756609);
    this.h = AppInfo.d().getResources().getString(2131756610);
  }
  
  public String a(String paramString) {
    String str = AppInfo.d().getResources().getString(2131758299);
    if (!StringUtils.e(paramString) && (paramString.split("-")).length == 2) {
      String str1;
      StringBuilder stringBuilder1;
      String str2;
      String[] arrayOfString2;
      StringBuilder stringBuilder2;
      String[] arrayOfString1 = paramString.split("-");
      int i = Integer.parseInt(arrayOfString1[0]);
      int j = Integer.parseInt(arrayOfString1[1]);
      String[] arrayOfString3 = this.a;
      if (i > arrayOfString3.length - 1 || j > arrayOfString3.length - 1) {
        arrayOfString3 = this.a;
        str1 = arrayOfString3[0];
        str2 = arrayOfString3[arrayOfString3.length - 1];
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("0-");
        stringBuilder.append(this.a.length - 1);
        BluedPreferences.i(stringBuilder.toString());
      } else {
        str1 = str2[i];
        str2 = str2[j];
      } 
      if (str1.equals(this.e) && str2.equals(this.e)) {
        stringBuilder1 = new StringBuilder();
        arrayOfString2 = this.a;
        stringBuilder1.append(arrayOfString2[arrayOfString2.length - 2]);
        stringBuilder1.append(str);
        return stringBuilder1.toString();
      } 
      if (stringBuilder1.equals(this.e)) {
        stringBuilder1 = new StringBuilder();
        stringBuilder1.append(this.f);
        stringBuilder1.append((String)arrayOfString2);
        stringBuilder1.append(str);
        return stringBuilder1.toString();
      } 
      if (arrayOfString2.equals(this.e)) {
        if (i == 0) {
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append(this.h);
          stringBuilder.append((String)stringBuilder1);
          stringBuilder.append(str);
          return stringBuilder.toString();
        } 
        stringBuilder2 = new StringBuilder();
        stringBuilder2.append(this.g);
        stringBuilder2.append((String)stringBuilder1);
        stringBuilder2.append(str);
        return stringBuilder2.toString();
      } 
      if (stringBuilder1.equals(stringBuilder2)) {
        stringBuilder2 = new StringBuilder();
        stringBuilder2.append((String)stringBuilder1);
        stringBuilder2.append(str);
        return stringBuilder2.toString();
      } 
      StringBuilder stringBuilder3 = new StringBuilder();
      stringBuilder3.append((String)stringBuilder1);
      stringBuilder3.append(" ～ ");
      stringBuilder3.append((String)stringBuilder2);
      stringBuilder3.append(str);
      return stringBuilder3.toString();
    } 
    return this.e;
  }
  
  public String[] a() {
    return this.a;
  }
  
  public String b(String paramString) {
    String str;
    if (this.d) {
      str = "";
    } else {
      str = AppInfo.d().getResources().getString(2131756037);
    } 
    if (!StringUtils.e(paramString) && (paramString.split("-")).length == 2) {
      StringBuilder stringBuilder1;
      String str1;
      String[] arrayOfString2;
      StringBuilder stringBuilder2;
      String[] arrayOfString1 = paramString.split("-");
      int i = Integer.parseInt(arrayOfString1[0]);
      int j = Integer.parseInt(arrayOfString1[1]);
      String[] arrayOfString3 = this.b;
      if (i > arrayOfString3.length - 1 || j > arrayOfString3.length - 1) {
        arrayOfString3 = this.b;
        String str2 = arrayOfString3[0];
        str1 = arrayOfString3[arrayOfString3.length - 1];
      } else {
        String str2 = str1[i];
        str1 = str1[j];
      } 
      if (i == 0 && j == 0) {
        stringBuilder1 = new StringBuilder();
        stringBuilder1.append(this.b[1]);
        stringBuilder1.append(str);
        return stringBuilder1.toString();
      } 
      String[] arrayOfString4 = this.b;
      if (i == arrayOfString4.length - 1 && j == arrayOfString4.length - 1) {
        stringBuilder1 = new StringBuilder();
        arrayOfString2 = this.b;
        stringBuilder1.append(arrayOfString2[arrayOfString2.length - 2]);
        stringBuilder1.append(str);
        return stringBuilder1.toString();
      } 
      if (stringBuilder1.equals(this.e) && arrayOfString2.equals(this.e))
        return this.e; 
      if (stringBuilder1.equals(this.e)) {
        stringBuilder1 = new StringBuilder();
        stringBuilder1.append(this.f);
        stringBuilder1.append((String)arrayOfString2);
        stringBuilder1.append(str);
        return stringBuilder1.toString();
      } 
      if (arrayOfString2.equals(this.e)) {
        stringBuilder2 = new StringBuilder();
        stringBuilder2.append(this.g);
        stringBuilder2.append((String)stringBuilder1);
        stringBuilder2.append(str);
        return stringBuilder2.toString();
      } 
      if (stringBuilder1.equals(stringBuilder2)) {
        stringBuilder2 = new StringBuilder();
        stringBuilder2.append((String)stringBuilder1);
        stringBuilder2.append(str);
        return stringBuilder2.toString();
      } 
      StringBuilder stringBuilder3 = new StringBuilder();
      stringBuilder3.append((String)stringBuilder1);
      stringBuilder3.append(" ～ ");
      stringBuilder3.append((String)stringBuilder2);
      stringBuilder3.append(str);
      return stringBuilder3.toString();
    } 
    return this.e;
  }
  
  public String[] b() {
    return this.b;
  }
  
  public String c(String paramString) {
    String str;
    if (this.d) {
      str = AppInfo.d().getResources().getString(2131757109);
    } else {
      str = AppInfo.d().getResources().getString(2131757092);
    } 
    if (!StringUtils.e(paramString) && (paramString.split("-")).length == 2) {
      StringBuilder stringBuilder1;
      String str1;
      String[] arrayOfString2;
      StringBuilder stringBuilder2;
      String[] arrayOfString1 = paramString.split("-");
      int i = Integer.valueOf(arrayOfString1[0]).intValue();
      int j = Integer.valueOf(arrayOfString1[1]).intValue();
      String[] arrayOfString3 = this.c;
      if (i > arrayOfString3.length - 1 || j > arrayOfString3.length - 1) {
        arrayOfString3 = this.c;
        String str2 = arrayOfString3[0];
        str1 = arrayOfString3[arrayOfString3.length - 1];
      } else {
        String str2 = str1[i];
        str1 = str1[j];
      } 
      if (i == 0 && j == 0) {
        stringBuilder1 = new StringBuilder();
        stringBuilder1.append(this.c[1]);
        stringBuilder1.append(str);
        return stringBuilder1.toString();
      } 
      String[] arrayOfString4 = this.c;
      if (i == arrayOfString4.length - 1 && j == arrayOfString4.length - 1) {
        stringBuilder1 = new StringBuilder();
        arrayOfString2 = this.c;
        stringBuilder1.append(arrayOfString2[arrayOfString2.length - 2]);
        stringBuilder1.append(str);
        return stringBuilder1.toString();
      } 
      if (stringBuilder1.equals(this.e) && arrayOfString2.equals(this.e))
        return this.e; 
      if (stringBuilder1.equals(this.e)) {
        stringBuilder1 = new StringBuilder();
        stringBuilder1.append(this.f);
        stringBuilder1.append((String)arrayOfString2);
        stringBuilder1.append(str);
        return stringBuilder1.toString();
      } 
      if (arrayOfString2.equals(this.e)) {
        stringBuilder2 = new StringBuilder();
        stringBuilder2.append(this.g);
        stringBuilder2.append((String)stringBuilder1);
        stringBuilder2.append(str);
        return stringBuilder2.toString();
      } 
      if (stringBuilder1.equals(stringBuilder2)) {
        stringBuilder2 = new StringBuilder();
        stringBuilder2.append((String)stringBuilder1);
        stringBuilder2.append(str);
        return stringBuilder2.toString();
      } 
      StringBuilder stringBuilder3 = new StringBuilder();
      stringBuilder3.append((String)stringBuilder1);
      stringBuilder3.append(" ～ ");
      stringBuilder3.append((String)stringBuilder2);
      stringBuilder3.append(str);
      return stringBuilder3.toString();
    } 
    return this.e;
  }
  
  public String[] c() {
    return this.c;
  }
  
  public void e() {
    i = null;
  }
  
  public void f() {
    i = null;
  }
  
  public boolean g() {
    return ((UserInfo.a().i()).vip_grade != 0 || (BluedConfig.b().j()).is_filter_vip == 1) ? BluedPreferences.Q() : false;
  }
  
  public boolean h() {
    return ((UserInfo.a().i()).vip_grade != 0 || (BluedConfig.b().j()).is_filter_vip == 1) ? BluedPreferences.W() : false;
  }
  
  public boolean i() {
    int i = (UserInfo.a().i()).vip_grade;
    boolean bool = false;
    if (i != 0 || (BluedConfig.b().j()).is_filter_vip == 1) {
      String str = BluedPreferences.Y();
      boolean bool1 = bool;
      if (!TextUtils.isEmpty(str)) {
        bool1 = bool;
        if (!str.equals("0-max"))
          bool1 = true; 
      } 
      return bool1;
    } 
    return false;
  }
  
  public boolean j() {
    int i = (UserInfo.a().i()).vip_grade;
    boolean bool = false;
    if (i != 0 || (BluedConfig.b().j()).is_filter_vip == 1) {
      String str = BluedPreferences.X();
      boolean bool1 = bool;
      if (!TextUtils.isEmpty(str)) {
        bool1 = bool;
        if (!str.equals("0-max"))
          bool1 = true; 
      } 
      return bool1;
    } 
    return false;
  }
  
  public boolean k() {
    String str = BluedPreferences.J();
    if (!TextUtils.isEmpty(str)) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("0-");
      stringBuilder.append(this.a.length - 1);
      if (!str.equals(stringBuilder.toString()))
        return true; 
    } 
    return false;
  }
  
  public boolean l() {
    String str;
    if (this.d) {
      str = BluedPreferences.L();
    } else {
      str = BluedPreferences.K();
    } 
    if (!TextUtils.isEmpty(str)) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("0-");
      stringBuilder.append(this.b.length - 1);
      if (!str.equals(stringBuilder.toString()))
        return true; 
    } 
    return false;
  }
  
  public boolean m() {
    String str;
    if (this.d) {
      str = BluedPreferences.N();
    } else {
      str = BluedPreferences.M();
    } 
    if (!TextUtils.isEmpty(str)) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("0-");
      stringBuilder.append(this.c.length - 1);
      if (!str.equals(stringBuilder.toString()))
        return true; 
    } 
    return false;
  }
  
  public boolean n() {
    return (!TextUtils.isEmpty(BluedPreferences.R()) || !TextUtils.isEmpty(BluedPreferences.V()) || !TextUtils.isEmpty(BluedPreferences.U()) || m() || l() || k() || !TextUtils.isEmpty(BluedPreferences.H()) || BluedPreferences.P() || BluedPreferences.O() || i() || j() || h() || g());
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\find\manager\FilterHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */