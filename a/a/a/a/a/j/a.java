package a.a.a.a.a.j;

import a.a.a.a.a.k.d.e;
import android.content.Context;
import android.content.Intent;

public class a {
  public Context a;
  
  public int b = 0;
  
  public a() {}
  
  public static a a() {
    return b.a;
  }
  
  public void a(int paramInt) {
    this.b = paramInt;
  }
  
  public void a(Context paramContext) {
    if (paramContext != null) {
      this.a = paramContext.getApplicationContext();
      return;
    } 
    this.a = null;
  }
  
  public void a(Intent paramIntent) {
    if (this.a == null)
      return; 
    if ("pldroid-qos-filter".equals(paramIntent.getAction()) && paramIntent.getIntExtra("pldroid-qos-msg-type", -1) == 161)
      paramIntent.putExtra("videoFilterTime", this.b); 
    a.a.a.a.a.k.a.a().a(paramIntent);
  }
  
  public int b() {
    return e.a();
  }
  
  public static class b {
    public static final a a = new a(null);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\a\a\a\a\a\j\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */