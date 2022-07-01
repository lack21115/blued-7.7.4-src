package com.amap.api.mapcore2d;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.wifi.WifiManager;
import android.text.TextUtils;
import com.autonavi.amap.mapcore2d.Inner_3dMap_location;
import com.autonavi.amap.mapcore2d.Inner_3dMap_locationOption;

public final class gi {
  Context a = null;
  
  boolean b = false;
  
  String c = null;
  
  long d = 0L;
  
  private go e = null;
  
  private gn f = null;
  
  private a g = null;
  
  private gq h = null;
  
  private ConnectivityManager i = null;
  
  private gs j = null;
  
  private StringBuilder k = new StringBuilder();
  
  private Inner_3dMap_locationOption l = null;
  
  private gg m = null;
  
  private final String n = "\"status\":\"0\"";
  
  private final String o = "</body></html>";
  
  public gi(Context paramContext) {
    try {
      this.a = paramContext.getApplicationContext();
      gy.b(this.a);
      a(this.a);
      this.l = new Inner_3dMap_locationOption();
      if (this.e == null) {
        WifiManager wifiManager = (WifiManager)gy.a(this.a, "wifi");
        this.e = new go(this.a, wifiManager);
        this.e.a(this.b);
      } 
      if (this.f == null)
        this.f = new gn(this.a); 
      if (this.h == null)
        this.h = gq.a(this.a); 
      if (this.i == null)
        this.i = (ConnectivityManager)gy.a(this.a, "connectivity"); 
      return;
    } finally {
      paramContext = null;
      gu.a((Throwable)paramContext, "MapNetLocation", "<init>");
    } 
  }
  
  private static gg a(gg paramgg, String... paramVarArgs) {
    if (paramVarArgs == null || paramVarArgs.length == 0)
      return gc.a().a(paramgg); 
    if (paramVarArgs[0].equals("shake"))
      return gc.a().a(paramgg); 
    gg gg1 = paramgg;
    if (paramVarArgs[0].equals("fusion")) {
      gc.a();
      gg1 = gc.b(paramgg);
    } 
    return gg1;
  }
  
  private void a(Context paramContext) {
    try {
      return;
    } finally {
      paramContext = null;
    } 
  }
  
  private boolean a(long paramLong) {
    if (gy.b() - paramLong < 800L) {
      paramLong = 0L;
      if (gk.a(this.m))
        paramLong = gy.a() - this.m.getTime(); 
      if (paramLong <= 10000L)
        return true; 
    } 
    return false;
  }
  
  private void c() {
    try {
      if (this.g == null)
        this.g = new a((byte)0); 
      IntentFilter intentFilter = new IntentFilter();
      intentFilter.addAction("android.net.wifi.WIFI_STATE_CHANGED");
      intentFilter.addAction("android.net.wifi.SCAN_RESULTS");
      this.a.registerReceiver(this.g, intentFilter);
      return;
    } finally {
      Exception exception = null;
      gu.a(exception, "MapNetLocation", "initBroadcastListener");
    } 
  }
  
  private gg d() throws Exception {
    StringBuilder stringBuilder;
    gg gg1 = new gg("");
    go go1 = this.e;
    if (go1 != null && go1.g()) {
      gg1.setErrorCode(15);
      return gg1;
    } 
    try {
    
    } finally {
      go1 = null;
      gu.a((Throwable)go1, "MapNetLocation", "getApsLoc");
      StringBuilder stringBuilder1 = this.k;
      StringBuilder stringBuilder2 = new StringBuilder("get parames error:");
      stringBuilder2.append(go1.getMessage());
      stringBuilder1.append(stringBuilder2.toString());
      stringBuilder.setErrorCode(3);
      stringBuilder.setLocationDetail(this.k.toString());
    } 
  }
  
  public final Inner_3dMap_location a() {
    if (this.k.length() > 0) {
      StringBuilder stringBuilder = this.k;
      stringBuilder.delete(0, stringBuilder.length());
    } 
    if (a(this.d) && gk.a(this.m))
      return this.m; 
    this.d = gy.b();
    if (this.a == null) {
      this.k.append("context is null");
      Inner_3dMap_location inner_3dMap_location = new Inner_3dMap_location("");
      inner_3dMap_location.setErrorCode(1);
      inner_3dMap_location.setLocationDetail(this.k.toString());
      return inner_3dMap_location;
    } 
    try {
      this.f.f();
    } finally {
      Exception exception = null;
    } 
  }
  
  public final void a(Inner_3dMap_locationOption paramInner_3dMap_locationOption) {
    this.l = paramInner_3dMap_locationOption;
    if (this.l == null)
      this.l = new Inner_3dMap_locationOption(); 
    try {
      go go1 = this.e;
      this.l.isWifiActiveScan();
    } finally {}
  }
  
  public final void b() {
    this.b = false;
    this.c = null;
    try {
      if (this.a != null && this.g != null)
        this.a.unregisterReceiver(this.g); 
      if (this.f != null)
        this.f.g(); 
      return;
    } finally {
      Exception exception = null;
      this.g = null;
    } 
  }
  
  final class a extends BroadcastReceiver {
    private a(gi this$0) {}
    
    public final void onReceive(Context param1Context, Intent param1Intent) {
      if (param1Context != null) {
        if (param1Intent == null)
          return; 
        try {
          String str = param1Intent.getAction();
          if (TextUtils.isEmpty(str))
            return; 
          return;
        } finally {
          param1Context = null;
        } 
      } 
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\mapcore2d\gi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */