package android.arch.lifecycle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

final class ReflectiveGenericLifecycleObserver$CallbackInfo {
  final Map mEventToHandlers;
  
  final Map mHandlerToEvent;
  
  ReflectiveGenericLifecycleObserver$CallbackInfo(Map paramMap) {
    this.mHandlerToEvent = paramMap;
    this.mEventToHandlers = new HashMap<Object, Object>();
    for (Map.Entry entry : paramMap.entrySet()) {
      Lifecycle$Event lifecycle$Event = (Lifecycle$Event)entry.getValue();
      List list2 = (List)this.mEventToHandlers.get(lifecycle$Event);
      List list1 = list2;
      if (list2 == null) {
        list1 = new ArrayList();
        this.mEventToHandlers.put(lifecycle$Event, list1);
      } 
      list1.add(entry.getKey());
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\android\arch\lifecycle\ReflectiveGenericLifecycleObserver$CallbackInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */