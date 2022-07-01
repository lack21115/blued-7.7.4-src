package com.facebook.stetho.inspector.elements;

import com.facebook.stetho.common.Accumulator;
import com.facebook.stetho.common.ThreadBound;
import javax.annotation.Nullable;

public interface NodeDescriptor<E> extends ThreadBound {
  void getAttributes(E paramE, AttributeAccumulator paramAttributeAccumulator);
  
  void getChildren(E paramE, Accumulator<Object> paramAccumulator);
  
  void getComputedStyles(E paramE, ComputedStyleAccumulator paramComputedStyleAccumulator);
  
  String getLocalName(E paramE);
  
  String getNodeName(E paramE);
  
  NodeType getNodeType(E paramE);
  
  @Nullable
  String getNodeValue(E paramE);
  
  void getStyleRuleNames(E paramE, StyleRuleNameAccumulator paramStyleRuleNameAccumulator);
  
  void getStyles(E paramE, String paramString, StyleAccumulator paramStyleAccumulator);
  
  void hook(E paramE);
  
  void setAttributesAsText(E paramE, String paramString);
  
  void setStyle(E paramE, String paramString1, String paramString2, String paramString3);
  
  void unhook(E paramE);
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\facebook\stetho\inspector\elements\NodeDescriptor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */