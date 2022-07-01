package com.tencent.ams.a.a.b;

import java.util.List;

public class g {
  public f a;
  
  public List<b> b;
  
  private String c;
  
  public String toString() {
    String str = this.c;
    if (str != null)
      return str; 
    StringBuilder stringBuilder = new StringBuilder();
    if (this.a != null) {
      stringBuilder.append("offlineCache[");
      stringBuilder.append("len=");
      stringBuilder.append(this.a.a);
      stringBuilder.append(",");
      stringBuilder.append("timeout=");
      stringBuilder.append(this.a.c);
      stringBuilder.append(",");
      stringBuilder.append("expiration=");
      stringBuilder.append(this.a.b);
      stringBuilder.append("]");
    } 
    List<b> list = this.b;
    if (list != null && list.size() > 0) {
      stringBuilder.append("companies{");
      for (b b : this.b) {
        if (b != null) {
          stringBuilder.append("[");
          stringBuilder.append(b.a);
          if (b.b != null) {
            stringBuilder.append("--");
            stringBuilder.append(b.b.a);
          } 
          stringBuilder.append("]");
        } 
      } 
      stringBuilder.append("}");
    } 
    this.c = stringBuilder.toString();
    return this.c;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\tencent\ams\a\a\b\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */