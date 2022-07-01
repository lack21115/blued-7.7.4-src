package com.baidu.mobads.openad.c;

import com.baidu.mobads.openad.interfaces.event.IOAdEvent;
import com.baidu.mobads.openad.interfaces.event.IOAdEventDispatcher;
import com.baidu.mobads.openad.interfaces.event.IOAdEventListener;
import com.baidu.mobads.utils.q;
import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class c implements IOAdEventDispatcher {
  protected Map<String, ArrayList<IOAdEventListener>> c;
  
  public c() {
    removeAllListeners();
  }
  
  public void addEventListener(String paramString, IOAdEventListener paramIOAdEventListener) {
    if (paramString != null) {
      if (paramIOAdEventListener == null)
        return; 
      removeEventListener(paramString, paramIOAdEventListener);
      ArrayList<IOAdEventListener> arrayList2 = this.c.get(paramString);
      ArrayList<IOAdEventListener> arrayList1 = arrayList2;
      if (arrayList2 == null) {
        arrayList1 = new ArrayList();
        this.c.put(paramString, arrayList1);
      } 
      arrayList1.add(paramIOAdEventListener);
    } 
  }
  
  public void dispatchEvent(IOAdEvent paramIOAdEvent) {
    if (paramIOAdEvent == null)
      return; 
    try {
      paramIOAdEvent.setTarget(this);
      ArrayList arrayList = this.c.get(paramIOAdEvent.getType());
      if (arrayList != null) {
        IOAdEventListener[] arrayOfIOAdEventListener = new IOAdEventListener[arrayList.size()];
        arrayList.toArray((Object[])arrayOfIOAdEventListener);
        int j = arrayOfIOAdEventListener.length;
        for (int i = 0; i < j; i++) {
          IOAdEventListener iOAdEventListener = arrayOfIOAdEventListener[i];
          if (iOAdEventListener != null)
            iOAdEventListener.run(paramIOAdEvent); 
        } 
      } 
    } catch (Exception exception) {
      q.a().e(exception);
    } 
  }
  
  public void dispose() {
    removeAllListeners();
  }
  
  public boolean hasEventListener(String paramString) {
    ArrayList arrayList = this.c.get(paramString);
    return (arrayList != null && !arrayList.isEmpty());
  }
  
  public void removeAllListeners() {
    this.c = new ConcurrentHashMap<String, ArrayList<IOAdEventListener>>();
  }
  
  public void removeEventListener(String paramString, IOAdEventListener paramIOAdEventListener) {
    if (paramString != null) {
      if (paramIOAdEventListener == null)
        return; 
      try {
        ArrayList arrayList = this.c.get(paramString);
        if (arrayList != null && arrayList.size() > 0) {
          arrayList.remove(paramIOAdEventListener);
          if (arrayList.isEmpty()) {
            this.c.remove(paramString);
            return;
          } 
        } 
      } catch (Exception exception) {
        q.a().e(exception);
      } 
    } 
  }
  
  public void removeEventListeners(String paramString) {
    this.c.remove(paramString);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\baidu\mobads\openad\c\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */