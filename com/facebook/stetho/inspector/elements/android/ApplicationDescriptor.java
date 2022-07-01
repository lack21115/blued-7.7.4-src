package com.facebook.stetho.inspector.elements.android;

import android.app.Activity;
import android.app.Application;
import com.facebook.stetho.common.Accumulator;
import com.facebook.stetho.inspector.elements.AbstractChainedDescriptor;
import com.facebook.stetho.inspector.elements.NodeType;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Map;

final class ApplicationDescriptor extends AbstractChainedDescriptor<Application> {
  private final ActivityTracker mActivityTracker = ActivityTracker.get();
  
  private final Map<Application, ElementContext> mElementToContextMap = Collections.synchronizedMap(new IdentityHashMap<Application, ElementContext>());
  
  private ElementContext getContext(Application paramApplication) {
    return this.mElementToContextMap.get(paramApplication);
  }
  
  protected void onGetChildren(Application paramApplication, Accumulator<Object> paramAccumulator) {
    List<WeakReference<Activity>> list = getContext(paramApplication).getActivitiesList();
    for (int i = list.size() - 1; i >= 0; i--) {
      Activity activity = ((WeakReference<Activity>)list.get(i)).get();
      if (activity != null)
        paramAccumulator.store(activity); 
    } 
  }
  
  protected NodeType onGetNodeType(Application paramApplication) {
    return NodeType.ELEMENT_NODE;
  }
  
  protected void onHook(Application paramApplication) {
    ElementContext elementContext = new ElementContext();
    elementContext.hook(paramApplication);
    this.mElementToContextMap.put(paramApplication, elementContext);
  }
  
  protected void onUnhook(Application paramApplication) {
    ((ElementContext)this.mElementToContextMap.remove(paramApplication)).unhook();
  }
  
  class ElementContext {
    private Application mElement;
    
    private final ActivityTracker.Listener mListener = new ActivityTracker.Listener() {
        public void onActivityAdded(Activity param2Activity) {}
        
        public void onActivityRemoved(Activity param2Activity) {}
      };
    
    public List<WeakReference<Activity>> getActivitiesList() {
      return ApplicationDescriptor.this.mActivityTracker.getActivitiesView();
    }
    
    public void hook(Application param1Application) {
      this.mElement = param1Application;
      ApplicationDescriptor.this.mActivityTracker.registerListener(this.mListener);
    }
    
    public void unhook() {
      ApplicationDescriptor.this.mActivityTracker.unregisterListener(this.mListener);
      this.mElement = null;
    }
  }
  
  class null implements ActivityTracker.Listener {
    public void onActivityAdded(Activity param1Activity) {}
    
    public void onActivityRemoved(Activity param1Activity) {}
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\facebook\stetho\inspector\elements\android\ApplicationDescriptor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */