package com.facebook.stetho.inspector.elements.android;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.TextView;
import com.facebook.stetho.common.Util;
import com.facebook.stetho.inspector.elements.AbstractChainedDescriptor;
import com.facebook.stetho.inspector.elements.AttributeAccumulator;
import com.facebook.stetho.inspector.elements.Descriptor;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Map;

final class TextViewDescriptor extends AbstractChainedDescriptor<TextView> {
  private static final String TEXT_ATTRIBUTE_NAME = "text";
  
  private final Map<TextView, ElementContext> mElementToContextMap = Collections.synchronizedMap(new IdentityHashMap<TextView, ElementContext>());
  
  protected void onGetAttributes(TextView paramTextView, AttributeAccumulator paramAttributeAccumulator) {
    CharSequence charSequence = paramTextView.getText();
    if (charSequence != null && charSequence.length() != 0)
      paramAttributeAccumulator.store("text", charSequence.toString()); 
  }
  
  protected void onHook(TextView paramTextView) {
    ElementContext elementContext = new ElementContext();
    elementContext.hook(paramTextView);
    this.mElementToContextMap.put(paramTextView, elementContext);
  }
  
  protected void onUnhook(TextView paramTextView) {
    ((ElementContext)this.mElementToContextMap.remove(paramTextView)).unhook();
  }
  
  final class ElementContext implements TextWatcher {
    private TextView mElement;
    
    private ElementContext() {}
    
    public void afterTextChanged(Editable param1Editable) {
      if (param1Editable.length() == 0) {
        TextViewDescriptor.this.getHost().onAttributeRemoved(this.mElement, "text");
        return;
      } 
      TextViewDescriptor.this.getHost().onAttributeModified(this.mElement, "text", param1Editable.toString());
    }
    
    public void beforeTextChanged(CharSequence param1CharSequence, int param1Int1, int param1Int2, int param1Int3) {}
    
    public void hook(TextView param1TextView) {
      this.mElement = (TextView)Util.throwIfNull(param1TextView);
      this.mElement.addTextChangedListener(this);
    }
    
    public void onTextChanged(CharSequence param1CharSequence, int param1Int1, int param1Int2, int param1Int3) {}
    
    public void unhook() {
      TextView textView = this.mElement;
      if (textView != null) {
        textView.removeTextChangedListener(this);
        this.mElement = null;
      } 
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\facebook\stetho\inspector\elements\android\TextViewDescriptor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */