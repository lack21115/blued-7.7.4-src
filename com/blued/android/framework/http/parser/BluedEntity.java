package com.blued.android.framework.http.parser;

import java.util.List;

public class BluedEntity<T, S extends BluedEntityBaseExtra> {
  public int code;
  
  public List<T> data;
  
  public S extra;
  
  public String message;
  
  public String request_id;
  
  public String request_time;
  
  public String response_time;
  
  public int getAssemblyTotal() {
    S s = this.extra;
    return (s == null || ((BluedEntityBaseExtra)s).total == 0) ? 0 : ((BluedEntityBaseExtra)this.extra).total;
  }
  
  public T getSingleData() {
    List<T> list = this.data;
    return (list != null && list.size() > 0) ? this.data.get(0) : null;
  }
  
  public boolean hasData() {
    List<T> list = this.data;
    return (list != null && list.size() > 0);
  }
  
  public boolean hasMore() {
    S s = this.extra;
    if (s != null) {
      if (((BluedEntityBaseExtra)s).hasmore == -1)
        return false; 
      if (((BluedEntityBaseExtra)this.extra).hasmore == 0)
        return false; 
      if (((BluedEntityBaseExtra)this.extra).hasmore == 1)
        return true; 
    } 
    return false;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\blued\android\framework\http\parser\BluedEntity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */