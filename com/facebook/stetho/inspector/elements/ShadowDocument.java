package com.facebook.stetho.inspector.elements;

import com.facebook.stetho.common.Accumulator;
import com.facebook.stetho.common.ListUtil;
import com.facebook.stetho.common.Util;
import java.util.ArrayDeque;
import java.util.Collections;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class ShadowDocument implements DocumentView {
  private final IdentityHashMap<Object, ElementInfo> mElementToInfoMap = new IdentityHashMap<Object, ElementInfo>();
  
  private boolean mIsUpdating;
  
  private final Object mRootElement;
  
  public ShadowDocument(Object paramObject) {
    this.mRootElement = Util.throwIfNull(paramObject);
  }
  
  public UpdateBuilder beginUpdate() {
    if (!this.mIsUpdating) {
      this.mIsUpdating = true;
      return new UpdateBuilder();
    } 
    throw new IllegalStateException();
  }
  
  public ElementInfo getElementInfo(Object paramObject) {
    return this.mElementToInfoMap.get(paramObject);
  }
  
  public Object getRootElement() {
    return this.mRootElement;
  }
  
  public final class Update implements DocumentView {
    private final Map<Object, ElementInfo> mElementToInfoChangesMap;
    
    private final Set<Object> mRootElementChangesSet;
    
    public Update(Map<Object, ElementInfo> param1Map, Set<Object> param1Set) {
      this.mElementToInfoChangesMap = param1Map;
      this.mRootElementChangesSet = param1Set;
    }
    
    private void removeGarbageSubTree(Map<Object, ElementInfo> param1Map, Object param1Object) {
      ElementInfo elementInfo = param1Map.get(param1Object);
      if (elementInfo.parentElement != null && param1Map.containsKey(elementInfo.parentElement))
        return; 
      param1Map.remove(param1Object);
      int i = 0;
      int j = elementInfo.children.size();
      while (i < j) {
        removeGarbageSubTree(param1Map, elementInfo.children.get(i));
        i++;
      } 
    }
    
    private void validateTree(Map<Object, ElementInfo> param1Map) {
      HashSet<Object> hashSet = new HashSet();
      for (Map.Entry<Object, ElementInfo> entry : param1Map.entrySet()) {
        Object object = entry.getKey();
        ElementInfo elementInfo = (ElementInfo)entry.getValue();
        if (object == elementInfo.element) {
          int j = elementInfo.children.size();
          int i = 0;
          while (i < j) {
            ElementInfo elementInfo2 = param1Map.get(elementInfo.children.get(i));
            if (elementInfo2 != null) {
              if (elementInfo2.parentElement == object) {
                i++;
                continue;
              } 
              throw new IllegalStateException("childElementInfo.parentElement != element");
            } 
            throw new IllegalStateException(String.format("elementInfo.get(elementInfo.children.get(%s)) == null", new Object[] { Integer.valueOf(i) }));
          } 
          if (elementInfo.parentElement == null) {
            hashSet.add(object);
            continue;
          } 
          ElementInfo elementInfo1 = param1Map.get(elementInfo.parentElement);
          if (elementInfo1 != null) {
            if (elementInfo.parentElement == elementInfo1.element) {
              if (elementInfo1.children.contains(object))
                continue; 
              throw new IllegalStateException("parentElementInfo.children.contains(element) == FALSE");
            } 
            throw new IllegalStateException("elementInfo.parentElementInfo != parentElementInfo.parent");
          } 
          throw new IllegalStateException("elementToInfoMap.get(elementInfo.parentElementInfo) == NULL");
        } 
        throw new IllegalStateException("element != elementInfo.element");
      } 
      if (hashSet.size() == 1)
        return; 
      throw new IllegalStateException("elementToInfoMap is a forest, not a tree. rootElements.size() != 1");
    }
    
    public void abandon() {
      if (ShadowDocument.this.mIsUpdating) {
        ShadowDocument.access$202(ShadowDocument.this, false);
        return;
      } 
      throw new IllegalStateException();
    }
    
    public void commit() {
      if (ShadowDocument.this.mIsUpdating) {
        ShadowDocument.this.mElementToInfoMap.putAll(this.mElementToInfoChangesMap);
        for (Object object : this.mRootElementChangesSet)
          removeGarbageSubTree(ShadowDocument.this.mElementToInfoMap, object); 
        ShadowDocument.access$202(ShadowDocument.this, false);
        return;
      } 
      throw new IllegalStateException();
    }
    
    public void getChangedElements(Accumulator<Object> param1Accumulator) {
      Iterator iterator = this.mElementToInfoChangesMap.keySet().iterator();
      while (iterator.hasNext())
        param1Accumulator.store(iterator.next()); 
    }
    
    public ElementInfo getElementInfo(Object param1Object) {
      ElementInfo elementInfo = this.mElementToInfoChangesMap.get(param1Object);
      return (elementInfo != null) ? elementInfo : (ElementInfo)ShadowDocument.this.mElementToInfoMap.get(param1Object);
    }
    
    public void getGarbageElements(Accumulator<Object> param1Accumulator) {
      ArrayDeque<Object> arrayDeque = new ArrayDeque();
      for (Object object : this.mRootElementChangesSet) {
        ElementInfo elementInfo = getElementInfo(object);
        if (object != ShadowDocument.this.mRootElement && elementInfo.parentElement == null) {
          arrayDeque.add(object);
          arrayDeque.add(object);
        } 
      } 
      while (!arrayDeque.isEmpty()) {
        Object object = arrayDeque.remove();
        ElementInfo elementInfo2 = (ElementInfo)arrayDeque.remove();
        ElementInfo elementInfo1 = elementInfo2;
        if (object == elementInfo2)
          elementInfo1 = null; 
        if ((getElementInfo(object)).parentElement == elementInfo1) {
          param1Accumulator.store(object);
          elementInfo1 = ShadowDocument.this.getElementInfo(object);
          if (elementInfo1 != null) {
            int i = 0;
            int j = elementInfo1.children.size();
            while (i < j) {
              arrayDeque.add(elementInfo1.children.get(i));
              arrayDeque.add(object);
              i++;
            } 
          } 
        } 
      } 
    }
    
    public Object getRootElement() {
      return ShadowDocument.this.getRootElement();
    }
    
    public boolean isElementChanged(Object param1Object) {
      return this.mElementToInfoChangesMap.containsKey(param1Object);
    }
    
    public boolean isEmpty() {
      return this.mElementToInfoChangesMap.isEmpty();
    }
  }
  
  public final class UpdateBuilder {
    private HashSet<Object> mCachedNotNewChildrenSet;
    
    private final Map<Object, ElementInfo> mElementToInfoChangesMap = new LinkedHashMap<Object, ElementInfo>();
    
    private final HashSet<Object> mRootElementChanges = new HashSet();
    
    private HashSet<Object> acquireNotNewChildrenHashSet() {
      HashSet<Object> hashSet2 = this.mCachedNotNewChildrenSet;
      HashSet<Object> hashSet1 = hashSet2;
      if (hashSet2 == null)
        hashSet1 = new HashSet(); 
      this.mCachedNotNewChildrenSet = null;
      return hashSet1;
    }
    
    private void releaseNotNewChildrenHashSet(HashSet<Object> param1HashSet) {
      param1HashSet.clear();
      if (this.mCachedNotNewChildrenSet == null)
        this.mCachedNotNewChildrenSet = param1HashSet; 
    }
    
    private void setElementParent(Object param1Object1, Object param1Object2) {
      List<?> list;
      ElementInfo elementInfo2 = this.mElementToInfoChangesMap.get(param1Object1);
      if (elementInfo2 != null && param1Object2 == elementInfo2.parentElement)
        return; 
      ElementInfo elementInfo3 = (ElementInfo)ShadowDocument.this.mElementToInfoMap.get(param1Object1);
      if (elementInfo2 == null && elementInfo3 != null && param1Object2 == elementInfo3.parentElement)
        return; 
      if (elementInfo2 != null && elementInfo3 != null && param1Object2 == elementInfo3.parentElement && ListUtil.identityEquals(elementInfo3.children, elementInfo2.children)) {
        this.mElementToInfoChangesMap.remove(param1Object1);
        if (param1Object2 == null)
          this.mRootElementChanges.remove(param1Object1); 
        return;
      } 
      if (elementInfo2 != null) {
        list = elementInfo2.children;
      } else if (elementInfo3 != null) {
        list = elementInfo3.children;
      } else {
        list = Collections.emptyList();
      } 
      ElementInfo elementInfo1 = new ElementInfo(param1Object1, param1Object2, (List)list);
      this.mElementToInfoChangesMap.put(param1Object1, elementInfo1);
      if (param1Object2 == null) {
        this.mRootElementChanges.add(param1Object1);
        return;
      } 
      this.mRootElementChanges.remove(param1Object1);
    }
    
    public ShadowDocument.Update build() {
      return new ShadowDocument.Update(this.mElementToInfoChangesMap, this.mRootElementChanges);
    }
    
    public void setElementChildren(Object param1Object, List<Object> param1List) {
      ElementInfo elementInfo1;
      elementInfo2 = this.mElementToInfoChangesMap.get(param1Object);
      if (elementInfo2 != null && ListUtil.identityEquals(param1List, elementInfo2.children))
        return; 
      ElementInfo elementInfo3 = (ElementInfo)ShadowDocument.this.mElementToInfoMap.get(param1Object);
      if (elementInfo2 == null && elementInfo3 != null && ListUtil.identityEquals(param1List, elementInfo3.children))
        return; 
      if (elementInfo2 != null && elementInfo3 != null && elementInfo3.parentElement == elementInfo2.parentElement && ListUtil.identityEquals(param1List, elementInfo3.children)) {
        elementInfo1 = (ElementInfo)ShadowDocument.this.mElementToInfoMap.get(param1Object);
        this.mElementToInfoChangesMap.remove(param1Object);
      } else {
        Object object;
        if (elementInfo2 != null) {
          object = elementInfo2.parentElement;
        } else if (elementInfo3 != null) {
          object = elementInfo3.parentElement;
        } else {
          object = null;
        } 
        elementInfo1 = new ElementInfo(param1Object, object, (List<Object>)elementInfo1);
        this.mElementToInfoChangesMap.put(param1Object, elementInfo1);
      } 
      HashSet<Object> hashSet = acquireNotNewChildrenHashSet();
      byte b = 0;
      if (elementInfo3 != null && elementInfo3.children != elementInfo1.children) {
        int m = elementInfo3.children.size();
        for (int k = 0; k < m; k++)
          hashSet.add(elementInfo3.children.get(k)); 
      } 
      if (elementInfo2 != null && elementInfo2.children != elementInfo1.children) {
        int m = elementInfo2.children.size();
        for (int k = 0; k < m; k++)
          hashSet.add(elementInfo2.children.get(k)); 
      } 
      int j = elementInfo1.children.size();
      for (int i = b; i < j; i++) {
        elementInfo2 = (ElementInfo)elementInfo1.children.get(i);
        setElementParent(elementInfo2, param1Object);
        hashSet.remove(elementInfo2);
      } 
      for (ElementInfo elementInfo2 : hashSet) {
        elementInfo3 = this.mElementToInfoChangesMap.get(elementInfo2);
        if (elementInfo3 != null && elementInfo3.parentElement != param1Object)
          continue; 
        elementInfo3 = (ElementInfo)ShadowDocument.this.mElementToInfoMap.get(elementInfo2);
        if (elementInfo3 != null && elementInfo3.parentElement == param1Object)
          setElementParent(elementInfo2, null); 
      } 
      releaseNotNewChildrenHashSet(hashSet);
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\facebook\stetho\inspector\elements\ShadowDocument.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */