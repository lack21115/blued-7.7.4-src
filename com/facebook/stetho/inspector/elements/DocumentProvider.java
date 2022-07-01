package com.facebook.stetho.inspector.elements;

import com.facebook.stetho.common.ThreadBound;
import javax.annotation.Nullable;

public interface DocumentProvider extends ThreadBound {
  void dispose();
  
  @Nullable
  NodeDescriptor getNodeDescriptor(@Nullable Object paramObject);
  
  @Nullable
  Object getRootElement();
  
  void hideHighlight();
  
  void highlightElement(Object paramObject, int paramInt);
  
  void setAttributesAsText(Object paramObject, String paramString);
  
  void setInspectModeEnabled(boolean paramBoolean);
  
  void setListener(DocumentProviderListener paramDocumentProviderListener);
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\facebook\stetho\inspector\elements\DocumentProvider.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */