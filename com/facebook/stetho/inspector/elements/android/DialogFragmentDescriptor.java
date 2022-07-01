package com.facebook.stetho.inspector.elements.android;

import android.graphics.Rect;
import android.view.View;
import com.facebook.stetho.common.Accumulator;
import com.facebook.stetho.common.LogUtil;
import com.facebook.stetho.common.Util;
import com.facebook.stetho.common.android.DialogFragmentAccessor;
import com.facebook.stetho.common.android.FragmentCompat;
import com.facebook.stetho.inspector.elements.AttributeAccumulator;
import com.facebook.stetho.inspector.elements.ChainedDescriptor;
import com.facebook.stetho.inspector.elements.ComputedStyleAccumulator;
import com.facebook.stetho.inspector.elements.Descriptor;
import com.facebook.stetho.inspector.elements.DescriptorMap;
import com.facebook.stetho.inspector.elements.NodeType;
import com.facebook.stetho.inspector.elements.StyleAccumulator;
import com.facebook.stetho.inspector.elements.StyleRuleNameAccumulator;
import javax.annotation.Nullable;

final class DialogFragmentDescriptor extends Descriptor<Object> implements ChainedDescriptor<Object>, HighlightableDescriptor<Object> {
  private final DialogFragmentAccessor mAccessor;
  
  private Descriptor<? super Object> mSuper;
  
  private DialogFragmentDescriptor(FragmentCompat paramFragmentCompat) {
    this.mAccessor = paramFragmentCompat.forDialogFragment();
  }
  
  private static void maybeRegister(DescriptorMap paramDescriptorMap, @Nullable FragmentCompat paramFragmentCompat) {
    if (paramFragmentCompat != null) {
      Class clazz = paramFragmentCompat.getDialogFragmentClass();
      LogUtil.d("Adding support for %s", new Object[] { clazz });
      paramDescriptorMap.registerDescriptor(clazz, new DialogFragmentDescriptor(paramFragmentCompat));
    } 
  }
  
  public static DescriptorMap register(DescriptorMap paramDescriptorMap) {
    maybeRegister(paramDescriptorMap, FragmentCompat.getSupportLibInstance());
    maybeRegister(paramDescriptorMap, FragmentCompat.getFrameworkInstance());
    return paramDescriptorMap;
  }
  
  public void getAttributes(Object paramObject, AttributeAccumulator paramAttributeAccumulator) {
    this.mSuper.getAttributes(paramObject, paramAttributeAccumulator);
  }
  
  public void getChildren(Object paramObject, Accumulator<Object> paramAccumulator) {
    paramAccumulator.store(this.mAccessor.getDialog(paramObject));
  }
  
  public void getComputedStyles(Object paramObject, ComputedStyleAccumulator paramComputedStyleAccumulator) {}
  
  @Nullable
  public Object getElementToHighlightAtPosition(Object paramObject, int paramInt1, int paramInt2, Rect paramRect) {
    Object object;
    Descriptor.Host host = getHost();
    if (host instanceof AndroidDescriptorHost) {
      object = this.mAccessor.getDialog(paramObject);
      paramObject = ((AndroidDescriptorHost)host).getHighlightableDescriptor(object);
    } else {
      object = null;
      paramObject = object;
    } 
    return (paramObject == null) ? null : paramObject.getElementToHighlightAtPosition(object, paramInt1, paramInt2, paramRect);
  }
  
  public String getLocalName(Object paramObject) {
    return this.mSuper.getLocalName(paramObject);
  }
  
  public String getNodeName(Object paramObject) {
    return this.mSuper.getNodeName(paramObject);
  }
  
  public NodeType getNodeType(Object paramObject) {
    return this.mSuper.getNodeType(paramObject);
  }
  
  @Nullable
  public String getNodeValue(Object paramObject) {
    return this.mSuper.getNodeValue(paramObject);
  }
  
  public void getStyleRuleNames(Object paramObject, StyleRuleNameAccumulator paramStyleRuleNameAccumulator) {}
  
  public void getStyles(Object paramObject, String paramString, StyleAccumulator paramStyleAccumulator) {}
  
  @Nullable
  public View getViewAndBoundsForHighlighting(Object paramObject, Rect paramRect) {
    Object object;
    Descriptor.Host host = getHost();
    if (host instanceof AndroidDescriptorHost) {
      object = this.mAccessor.getDialog(paramObject);
      paramObject = ((AndroidDescriptorHost)host).getHighlightableDescriptor(object);
    } else {
      object = null;
      paramObject = object;
    } 
    return (paramObject == null) ? null : paramObject.getViewAndBoundsForHighlighting(object, paramRect);
  }
  
  public void hook(Object paramObject) {
    this.mSuper.hook(paramObject);
  }
  
  public void setAttributesAsText(Object paramObject, String paramString) {
    this.mSuper.setAttributesAsText(paramObject, paramString);
  }
  
  public void setStyle(Object paramObject, String paramString1, String paramString2, String paramString3) {}
  
  public void setSuper(Descriptor<? super Object> paramDescriptor) {
    Util.throwIfNull(paramDescriptor);
    Descriptor<? super Object> descriptor = this.mSuper;
    if (paramDescriptor != descriptor) {
      if (descriptor == null) {
        this.mSuper = paramDescriptor;
        return;
      } 
      throw new IllegalStateException();
    } 
  }
  
  public void unhook(Object paramObject) {
    this.mSuper.unhook(paramObject);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\facebook\stetho\inspector\elements\android\DialogFragmentDescriptor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */