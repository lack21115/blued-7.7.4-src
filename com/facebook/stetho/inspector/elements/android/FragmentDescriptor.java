package com.facebook.stetho.inspector.elements.android;

import android.graphics.Rect;
import android.view.View;
import com.facebook.stetho.common.Accumulator;
import com.facebook.stetho.common.LogUtil;
import com.facebook.stetho.common.android.FragmentAccessor;
import com.facebook.stetho.common.android.FragmentCompat;
import com.facebook.stetho.common.android.ResourcesUtil;
import com.facebook.stetho.inspector.elements.AbstractChainedDescriptor;
import com.facebook.stetho.inspector.elements.AttributeAccumulator;
import com.facebook.stetho.inspector.elements.Descriptor;
import com.facebook.stetho.inspector.elements.DescriptorMap;
import javax.annotation.Nullable;

final class FragmentDescriptor extends AbstractChainedDescriptor<Object> implements HighlightableDescriptor<Object> {
  private static final String ID_ATTRIBUTE_NAME = "id";
  
  private static final String TAG_ATTRIBUTE_NAME = "tag";
  
  private final FragmentAccessor mAccessor;
  
  private FragmentDescriptor(FragmentCompat paramFragmentCompat) {
    this.mAccessor = paramFragmentCompat.forFragment();
  }
  
  private static void maybeRegister(DescriptorMap paramDescriptorMap, @Nullable FragmentCompat paramFragmentCompat) {
    if (paramFragmentCompat != null) {
      Class clazz = paramFragmentCompat.getFragmentClass();
      LogUtil.d("Adding support for %s", new Object[] { clazz.getName() });
      paramDescriptorMap.registerDescriptor(clazz, (Descriptor)new FragmentDescriptor(paramFragmentCompat));
    } 
  }
  
  public static DescriptorMap register(DescriptorMap paramDescriptorMap) {
    maybeRegister(paramDescriptorMap, FragmentCompat.getSupportLibInstance());
    maybeRegister(paramDescriptorMap, FragmentCompat.getFrameworkInstance());
    return paramDescriptorMap;
  }
  
  @Nullable
  public Object getElementToHighlightAtPosition(Object paramObject, int paramInt1, int paramInt2, Rect paramRect) {
    Object object;
    Descriptor.Host host = getHost();
    if (host instanceof AndroidDescriptorHost) {
      object = this.mAccessor.getView(paramObject);
      paramObject = ((AndroidDescriptorHost)host).getHighlightableDescriptor(object);
    } else {
      object = null;
      paramObject = object;
    } 
    return (paramObject == null) ? null : paramObject.getElementToHighlightAtPosition(object, paramInt1, paramInt2, paramRect);
  }
  
  @Nullable
  public View getViewAndBoundsForHighlighting(Object paramObject, Rect paramRect) {
    return this.mAccessor.getView(paramObject);
  }
  
  public void onGetAttributes(Object paramObject, AttributeAccumulator paramAttributeAccumulator) {
    int i = this.mAccessor.getId(paramObject);
    if (i != 0)
      paramAttributeAccumulator.store("id", ResourcesUtil.getIdStringQuietly(paramObject, this.mAccessor.getResources(paramObject), i)); 
    paramObject = this.mAccessor.getTag(paramObject);
    if (paramObject != null && paramObject.length() > 0)
      paramAttributeAccumulator.store("tag", (String)paramObject); 
  }
  
  public void onGetChildren(Object paramObject, Accumulator<Object> paramAccumulator) {
    paramObject = this.mAccessor.getView(paramObject);
    if (paramObject != null)
      paramAccumulator.store(paramObject); 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\facebook\stetho\inspector\elements\android\FragmentDescriptor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */