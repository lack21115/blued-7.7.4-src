package com.qq.e.comm.plugin.h.a;

import android.content.Context;
import android.os.AsyncTask;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;

public class a extends b {
  public String a(Context paramContext) {
    return b(paramContext);
  }
  
  protected String c(Context paramContext) {
    (new a(this, paramContext)).execute((Object[])new Void[0]);
    return null;
  }
  
  class a extends AsyncTask<Void, Integer, String> {
    private Context b;
    
    public a(a this$0, Context param1Context) {
      this.b = param1Context;
    }
    
    protected String a(Void... param1VarArgs) {
      try {
        Class.forName("com.google.android.gms.ads.identifier.AdvertisingIdClient");
        AdvertisingIdClient.Info info = AdvertisingIdClient.getAdvertisingIdInfo(this.b);
        if (!info.isLimitAdTrackingEnabled())
          return info.getId(); 
      } finally {
        param1VarArgs = null;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ExceptionAAID Exception:");
        stringBuilder.append(param1VarArgs.getMessage());
      } 
      return null;
    }
    
    protected void a(String param1String) {
      super.onPostExecute(param1String);
      this.a.a = param1String;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\plugin\h\a\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */