package c.t.maploc.lite.tsa;

import android.location.Location;

public final class n extends p {
  public static final Location a = new Location("EMPTY");
  
  public final Location b;
  
  public final long c;
  
  public n(Location paramLocation, long paramLong) {
    this.b = paramLocation;
    this.c = paramLong;
  }
  
  static String a(double paramDouble, int paramInt) {
    try {
      if (Double.isNaN(paramDouble))
        return "0"; 
      StringBuilder stringBuilder = new StringBuilder("%.");
      stringBuilder.append(paramInt);
      return String.format(stringBuilder.toString(), new Object[] { Double.valueOf(paramDouble) });
    } finally {
      Exception exception = null;
    } 
  }
  
  public final String toString() {
    StringBuilder stringBuilder = new StringBuilder("TxGpsInfo [location=");
    stringBuilder.append(this.b);
    stringBuilder.append(", gpsTime=");
    stringBuilder.append(this.c);
    stringBuilder.append("]");
    return stringBuilder.toString();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\c\t\maploc\lite\tsa\n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */