package com.facebook.stetho.inspector.elements;

import com.facebook.stetho.common.ListUtil;
import com.facebook.stetho.common.Util;
import java.util.List;
import javax.annotation.Nullable;

public final class ElementInfo {
  public final List<Object> children;
  
  public final Object element;
  
  @Nullable
  public final Object parentElement;
  
  ElementInfo(Object paramObject1, @Nullable Object paramObject2, List<Object> paramList) {
    this.element = Util.throwIfNull(paramObject1);
    this.parentElement = paramObject2;
    this.children = ListUtil.copyToImmutableList(paramList);
  }
  
  public boolean equals(Object paramObject) {
    if (paramObject == this)
      return true; 
    if (paramObject instanceof ElementInfo) {
      paramObject = paramObject;
      return (this.element == ((ElementInfo)paramObject).element && this.parentElement == ((ElementInfo)paramObject).parentElement && ListUtil.identityEquals(this.children, ((ElementInfo)paramObject).children));
    } 
    return false;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\facebook\stetho\inspector\elements\ElementInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */