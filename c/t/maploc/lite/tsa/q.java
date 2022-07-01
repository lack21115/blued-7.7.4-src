package c.t.maploc.lite.tsa;

import android.location.Location;
import android.os.Bundle;
import android.os.SystemClock;
import com.tencent.map.geoloclite.tsa.TencentLiteLocation;
import org.json.JSONException;
import org.json.JSONObject;

public final class q implements TencentLiteLocation {
  public static final q a = new q(-1);
  
  private Location b;
  
  private b c;
  
  private final long d;
  
  private long e;
  
  private int f;
  
  private String g;
  
  private String h = "network";
  
  private String i = "";
  
  private final Bundle j = new Bundle();
  
  private q(int paramInt) {
    this.f = paramInt;
    this.d = SystemClock.elapsedRealtime();
    this.e = System.currentTimeMillis();
  }
  
  private q(String paramString) throws JSONException {
    this(0);
    JSONObject jSONObject = new JSONObject(paramString);
    this.c = new b(jSONObject.getJSONObject("location"));
    this.g = jSONObject.optString("bearing");
    this.e = jSONObject.optLong("timestamp", System.currentTimeMillis());
    try {
      return;
    } finally {
      jSONObject = null;
      this.i = "";
    } 
  }
  
  public static q a(q paramq) {
    if (paramq != null)
      try {
        double d;
        b b1;
        if (paramq.g != null && paramq.c != null) {
          String str = paramq.g;
          byte b2 = 0;
          int i = b2;
          if (str != null) {
            i = b2;
            if ((str.split(",")).length > 1)
              i = Integer.parseInt(str.split(",")[1]); 
          } 
          b1 = paramq.c;
          double d1 = paramq.c.d;
          if (i >= 6) {
            d = 40.0D;
          } else if (i == 5) {
            d = 60.0D;
          } else if (i == 4) {
            d = 70.0D;
          } else if (i == 3) {
            d = 90.0D;
          } else if (i == 2) {
            d = 110.0D;
          } else {
            if (i == 0) {
              d = 0.45D;
            } else {
              if (d1 <= 100.0D) {
                d = (d1 - 1.0D) / 10.0D + 1.0D;
              } else {
                if (d1 > 100.0D && d1 <= 800.0D) {
                  d = 0.85D;
                } else {
                  d = 0.8D;
                } 
                d = d1 * d / 10.0D;
              } 
              i = (int)d;
              d = (i * 10);
              b1.d = (float)d;
            } 
            d = d1 * d / 10.0D;
          } 
        } else {
          return paramq;
        } 
      } finally {
        Exception exception = null;
      }  
    return paramq;
  }
  
  public final void a(Location paramLocation) {
    if (paramLocation != null && this.c != null) {
      double d2 = paramLocation.getLatitude();
      double d1 = paramLocation.getLongitude();
      d2 = Math.round(d2 * 1000000.0D) / 1000000.0D;
      d1 = Math.round(d1 * 1000000.0D) / 1000000.0D;
      b b1 = this.c;
      b1.a = d2;
      b1.b = d1;
      b1.c = paramLocation.getAltitude();
      this.c.d = paramLocation.getAccuracy();
    } 
  }
  
  public final boolean a() {
    return (this.i.length() > 0);
  }
  
  public final float getAccuracy() {
    b b1 = this.c;
    return (b1 != null) ? b1.d : 0.0F;
  }
  
  public final double getAltitude() {
    b b1 = this.c;
    return (b1 != null) ? b1.c : 0.0D;
  }
  
  public final long getElapsedRealtime() {
    return this.d;
  }
  
  public final Bundle getExtra() {
    return this.j;
  }
  
  public final double getLatitude() {
    b b1 = this.c;
    return (b1 != null) ? b1.a : 0.0D;
  }
  
  public final double getLongitude() {
    b b1 = this.c;
    return (b1 != null) ? b1.b : 0.0D;
  }
  
  public final String getProvider() {
    return this.h;
  }
  
  public final float getSpeed() {
    Location location = this.b;
    return (location != null) ? location.getSpeed() : 0.0F;
  }
  
  public final long getTime() {
    return this.e;
  }
  
  public final String toString() {
    StringBuilder stringBuilder = new StringBuilder("TxLocation{");
    stringBuilder.append("level=");
    stringBuilder.append(this.f);
    stringBuilder.append(",");
    stringBuilder.append("provider=");
    stringBuilder.append(getProvider());
    stringBuilder.append(",");
    stringBuilder.append("latitude=");
    stringBuilder.append(getLatitude());
    stringBuilder.append(",");
    stringBuilder.append("longitude=");
    stringBuilder.append(getLongitude());
    stringBuilder.append(",");
    stringBuilder.append("altitude=");
    stringBuilder.append(getAltitude());
    stringBuilder.append(",");
    stringBuilder.append("accuracy=");
    stringBuilder.append(getAccuracy());
    stringBuilder.append(",");
    stringBuilder.append("time=");
    stringBuilder.append(getTime());
    stringBuilder.append(",");
    stringBuilder.append("}");
    return stringBuilder.toString();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\c\t\maploc\lite\tsa\q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */