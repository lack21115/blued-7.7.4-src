package com.facebook.stetho.inspector.elements;

import com.facebook.stetho.common.Accumulator;
import com.facebook.stetho.common.Util;
import javax.annotation.Nullable;

public abstract class AbstractChainedDescriptor<E> extends Descriptor<E> implements ChainedDescriptor<E> {
  private Descriptor<? super E> mSuper;
  
  public final void getAttributes(E paramE, AttributeAccumulator paramAttributeAccumulator) {
    this.mSuper.getAttributes(paramE, paramAttributeAccumulator);
    onGetAttributes(paramE, paramAttributeAccumulator);
  }
  
  public final void getChildren(E paramE, Accumulator<Object> paramAccumulator) {
    this.mSuper.getChildren(paramE, paramAccumulator);
    onGetChildren(paramE, paramAccumulator);
  }
  
  public void getComputedStyles(E paramE, ComputedStyleAccumulator paramComputedStyleAccumulator) {
    this.mSuper.getComputedStyles(paramE, paramComputedStyleAccumulator);
    onGetComputedStyles(paramE, paramComputedStyleAccumulator);
  }
  
  public final String getLocalName(E paramE) {
    return onGetLocalName(paramE);
  }
  
  public final String getNodeName(E paramE) {
    return onGetNodeName(paramE);
  }
  
  public final NodeType getNodeType(E paramE) {
    return onGetNodeType(paramE);
  }
  
  public final String getNodeValue(E paramE) {
    return onGetNodeValue(paramE);
  }
  
  public final void getStyleRuleNames(E paramE, StyleRuleNameAccumulator paramStyleRuleNameAccumulator) {
    this.mSuper.getStyleRuleNames(paramE, paramStyleRuleNameAccumulator);
    onGetStyleRuleNames(paramE, paramStyleRuleNameAccumulator);
  }
  
  public final void getStyles(E paramE, String paramString, StyleAccumulator paramStyleAccumulator) {
    this.mSuper.getStyles(paramE, paramString, paramStyleAccumulator);
    onGetStyles(paramE, paramString, paramStyleAccumulator);
  }
  
  final Descriptor<? super E> getSuper() {
    return this.mSuper;
  }
  
  public final void hook(E paramE) {
    verifyThreadAccess();
    this.mSuper.hook(paramE);
    onHook(paramE);
  }
  
  protected void onGetAttributes(E paramE, AttributeAccumulator paramAttributeAccumulator) {}
  
  protected void onGetChildren(E paramE, Accumulator<Object> paramAccumulator) {}
  
  protected void onGetComputedStyles(E paramE, ComputedStyleAccumulator paramComputedStyleAccumulator) {}
  
  protected String onGetLocalName(E paramE) {
    return this.mSuper.getLocalName(paramE);
  }
  
  protected String onGetNodeName(E paramE) {
    return this.mSuper.getNodeName(paramE);
  }
  
  protected NodeType onGetNodeType(E paramE) {
    return this.mSuper.getNodeType(paramE);
  }
  
  @Nullable
  public String onGetNodeValue(E paramE) {
    return this.mSuper.getNodeValue(paramE);
  }
  
  protected void onGetStyleRuleNames(E paramE, StyleRuleNameAccumulator paramStyleRuleNameAccumulator) {}
  
  protected void onGetStyles(E paramE, String paramString, StyleAccumulator paramStyleAccumulator) {}
  
  protected void onHook(E paramE) {}
  
  protected void onSetAttributesAsText(E paramE, String paramString) {
    this.mSuper.setAttributesAsText(paramE, paramString);
  }
  
  protected void onSetStyle(E paramE, String paramString1, String paramString2, String paramString3) {}
  
  protected void onUnhook(E paramE) {}
  
  public final void setAttributesAsText(E paramE, String paramString) {
    onSetAttributesAsText(paramE, paramString);
  }
  
  public final void setStyle(E paramE, String paramString1, String paramString2, String paramString3) {
    this.mSuper.setStyle(paramE, paramString1, paramString2, paramString3);
    onSetStyle(paramE, paramString1, paramString2, paramString3);
  }
  
  public void setSuper(Descriptor<? super E> paramDescriptor) {
    Util.throwIfNull(paramDescriptor);
    Descriptor<? super E> descriptor = this.mSuper;
    if (paramDescriptor != descriptor) {
      if (descriptor == null) {
        this.mSuper = paramDescriptor;
        return;
      } 
      throw new IllegalStateException();
    } 
  }
  
  public final void unhook(E paramE) {
    verifyThreadAccess();
    onUnhook(paramE);
    this.mSuper.unhook(paramE);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\facebook\stetho\inspector\elements\AbstractChainedDescriptor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */