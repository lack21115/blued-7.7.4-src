package com.facebook.stetho.inspector.elements.android;

import com.facebook.stetho.inspector.elements.Descriptor;
import javax.annotation.Nullable;

interface AndroidDescriptorHost extends Descriptor.Host {
  @Nullable
  HighlightableDescriptor getHighlightableDescriptor(@Nullable Object paramObject);
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\facebook\stetho\inspector\elements\android\AndroidDescriptorHost.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */