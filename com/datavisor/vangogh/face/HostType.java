package com.datavisor.vangogh.face;

public enum HostType {
  a, b, c;
  
  static {
    HostType hostType = new HostType("ONLINE", 2);
    c = hostType;
    d = new HostType[] { a, b, hostType };
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\datavisor\vangogh\face\HostType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */