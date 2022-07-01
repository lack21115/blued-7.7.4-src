package a.a.a.a.a.d;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.provider.Settings;
import java.util.Map;
import java.util.UUID;

public class f {
  public static f a;
  
  public SharedPreferences b;
  
  public SharedPreferences.Editor c;
  
  public SharedPreferences d;
  
  public SharedPreferences.Editor e;
  
  public SharedPreferences f;
  
  public SharedPreferences.Editor g;
  
  public Context h;
  
  public boolean i;
  
  public static f a() {
    if (a == null)
      a = new f(); 
    return a;
  }
  
  public long a(String paramString) {
    return this.f.getLong(paramString, System.currentTimeMillis());
  }
  
  public void a(Context paramContext) {
    this.h = paramContext;
    e();
    this.i = true;
  }
  
  public Map<String, ?> b() {
    return this.b.getAll();
  }
  
  public void b(String paramString) {
    if (this.i) {
      if (!c.a().b())
        return; 
      int i = this.d.getInt(paramString, 0);
      this.e.putInt(paramString, i + 1);
      this.e.apply();
    } 
  }
  
  public Map<String, ?> c() {
    return this.d.getAll();
  }
  
  public void d() {
    g();
    i();
    h();
  }
  
  public final void e() {
    SharedPreferences sharedPreferences = this.h.getSharedPreferences("StreamingReportData_Base", 0);
    this.b = sharedPreferences;
    this.c = sharedPreferences.edit();
    sharedPreferences = this.h.getSharedPreferences("StreamingReportData_Function", 0);
    this.d = sharedPreferences;
    this.e = sharedPreferences.edit();
    sharedPreferences = this.h.getSharedPreferences("StreamingReportData_Extra", 0);
    this.f = sharedPreferences;
    this.g = sharedPreferences.edit();
    f();
  }
  
  public final void f() {
    if (!this.b.getString("os_platform", "null").equals("null")) {
      h();
      return;
    } 
    String str2 = Settings.System.getString(this.h.getContentResolver(), "android_id");
    String str1 = str2;
    if (str2 == null)
      str1 = UUID.randomUUID().toString().replaceAll("-", ""); 
    this.c.putString("os_platform", "android");
    this.c.putString("bundle_id", this.h.getPackageName());
    this.c.putString("app_name", h.a(this.h));
    this.c.putString("device_id", str1);
    this.c.putString("device_model", h.a());
    this.c.putString("os_version", Build.VERSION.RELEASE);
    this.c.putString("sdk_version", "3.0.0");
    this.c.apply();
    this.g.putLong("method_report_last_time_ms", System.currentTimeMillis());
    this.g.apply();
  }
  
  public final void g() {
    this.e.clear();
    this.e.apply();
  }
  
  public final void h() {
    this.c.putString("os_version", Build.VERSION.RELEASE);
    this.c.putString("sdk_version", "3.0.0");
    this.c.apply();
  }
  
  public final void i() {
    this.g.putLong("method_report_last_time_ms", System.currentTimeMillis());
    this.g.apply();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\a\a\a\a\a\d\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */