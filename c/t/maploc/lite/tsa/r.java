package c.t.maploc.lite.tsa;

import android.location.Location;

public final class r {
  public q a;
  
  public String b;
  
  public String c = "network";
  
  private Location d;
  
  public final q a() {
    q q1;
    String str = this.b;
    if (str != null) {
      try {
        q1 = new q(str, (byte)0);
      } finally {
        str = null;
        (new StringBuilder("build: ")).append(str);
      } 
    } else {
      q1 = q.b(this.a);
    } 
    q.a(q.a(q1, this.c), this.d);
    return q1;
  }
  
  public final r a(Location paramLocation) {
    this.d = new Location(paramLocation);
    return this;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\c\t\maploc\lite\tsa\r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */