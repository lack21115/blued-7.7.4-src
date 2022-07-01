package com.google.protobuf;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

abstract class ListFieldSchema {
  private static final ListFieldSchema FULL_INSTANCE = new ListFieldSchemaFull();
  
  private static final ListFieldSchema LITE_INSTANCE = new ListFieldSchemaLite();
  
  private ListFieldSchema() {}
  
  static ListFieldSchema full() {
    return FULL_INSTANCE;
  }
  
  static ListFieldSchema lite() {
    return LITE_INSTANCE;
  }
  
  abstract void makeImmutableListAt(Object paramObject, long paramLong);
  
  abstract <L> void mergeListsAt(Object paramObject1, Object paramObject2, long paramLong);
  
  abstract <L> List<L> mutableListAt(Object paramObject, long paramLong);
  
  static final class ListFieldSchemaFull extends ListFieldSchema {
    private static final Class<?> UNMODIFIABLE_LIST_CLASS = Collections.unmodifiableList(Collections.emptyList()).getClass();
    
    private ListFieldSchemaFull() {}
    
    static <E> List<E> getList(Object param1Object, long param1Long) {
      return (List<E>)UnsafeUtil.getObject(param1Object, param1Long);
    }
    
    private static <L> List<L> mutableListAt(Object<?> param1Object, long param1Long, int param1Int) {
      List<?> list2 = getList(param1Object, param1Long);
      if (list2.isEmpty()) {
        ArrayList<L> arrayList;
        if (list2 instanceof LazyStringList) {
          LazyStringArrayList lazyStringArrayList = new LazyStringArrayList(param1Int);
        } else if (list2 instanceof PrimitiveNonBoxingCollection && list2 instanceof Internal.ProtobufList) {
          Internal.ProtobufList protobufList = ((Internal.ProtobufList)list2).mutableCopyWithCapacity(param1Int);
        } else {
          arrayList = new ArrayList(param1Int);
        } 
        UnsafeUtil.putObject(param1Object, param1Long, arrayList);
        return arrayList;
      } 
      if (UNMODIFIABLE_LIST_CLASS.isAssignableFrom(list2.getClass())) {
        ArrayList<?> arrayList = new ArrayList(list2.size() + param1Int);
        arrayList.addAll(list2);
        UnsafeUtil.putObject(param1Object, param1Long, arrayList);
        return (List)arrayList;
      } 
      if (list2 instanceof UnmodifiableLazyStringList) {
        LazyStringArrayList lazyStringArrayList = new LazyStringArrayList(list2.size() + param1Int);
        lazyStringArrayList.addAll((UnmodifiableLazyStringList)list2);
        UnsafeUtil.putObject(param1Object, param1Long, lazyStringArrayList);
        return lazyStringArrayList;
      } 
      List<?> list1 = list2;
      if (list2 instanceof PrimitiveNonBoxingCollection) {
        list1 = list2;
        if (list2 instanceof Internal.ProtobufList) {
          Internal.ProtobufList<?> protobufList = (Internal.ProtobufList)list2;
          list1 = list2;
          if (!protobufList.isModifiable()) {
            list1 = protobufList.mutableCopyWithCapacity(list2.size() + param1Int);
            UnsafeUtil.putObject(param1Object, param1Long, list1);
          } 
        } 
      } 
      return (List)list1;
    }
    
    void makeImmutableListAt(Object param1Object, long param1Long) {
      List<?> list = (List)UnsafeUtil.getObject(param1Object, param1Long);
      if (list instanceof LazyStringList) {
        list = ((LazyStringList)list).getUnmodifiableView();
      } else {
        if (UNMODIFIABLE_LIST_CLASS.isAssignableFrom(list.getClass()))
          return; 
        if (list instanceof PrimitiveNonBoxingCollection && list instanceof Internal.ProtobufList) {
          param1Object = list;
          if (param1Object.isModifiable())
            param1Object.makeImmutable(); 
          return;
        } 
        list = Collections.unmodifiableList(list);
      } 
      UnsafeUtil.putObject(param1Object, param1Long, list);
    }
    
    <E> void mergeListsAt(Object param1Object1, Object<?> param1Object2, long param1Long) {
      param1Object2 = getList(param1Object2, param1Long);
      List<?> list = mutableListAt(param1Object1, param1Long, param1Object2.size());
      int i = list.size();
      int j = param1Object2.size();
      if (i > 0 && j > 0)
        list.addAll((Collection<?>)param1Object2); 
      if (i > 0)
        param1Object2 = (Object<?>)list; 
      UnsafeUtil.putObject(param1Object1, param1Long, param1Object2);
    }
    
    <L> List<L> mutableListAt(Object param1Object, long param1Long) {
      return mutableListAt(param1Object, param1Long, 10);
    }
  }
  
  static final class ListFieldSchemaLite extends ListFieldSchema {
    private ListFieldSchemaLite() {}
    
    static <E> Internal.ProtobufList<E> getProtobufList(Object param1Object, long param1Long) {
      return (Internal.ProtobufList<E>)UnsafeUtil.getObject(param1Object, param1Long);
    }
    
    void makeImmutableListAt(Object param1Object, long param1Long) {
      getProtobufList(param1Object, param1Long).makeImmutable();
    }
    
    <E> void mergeListsAt(Object param1Object1, Object<?> param1Object2, long param1Long) {
      Object<?> object;
      Internal.ProtobufList<?> protobufList1 = getProtobufList(param1Object1, param1Long);
      Internal.ProtobufList<?> protobufList2 = getProtobufList(param1Object2, param1Long);
      int i = protobufList1.size();
      int j = protobufList2.size();
      param1Object2 = (Object<?>)protobufList1;
      if (i > 0) {
        param1Object2 = (Object<?>)protobufList1;
        if (j > 0) {
          param1Object2 = (Object<?>)protobufList1;
          if (!protobufList1.isModifiable())
            param1Object2 = (Object<?>)protobufList1.mutableCopyWithCapacity(j + i); 
          param1Object2.addAll(protobufList2);
        } 
      } 
      protobufList1 = protobufList2;
      if (i > 0)
        object = param1Object2; 
      UnsafeUtil.putObject(param1Object1, param1Long, object);
    }
    
    <L> List<L> mutableListAt(Object param1Object, long param1Long) {
      Internal.ProtobufList<?> protobufList2 = getProtobufList(param1Object, param1Long);
      Internal.ProtobufList<?> protobufList1 = protobufList2;
      if (!protobufList2.isModifiable()) {
        int i = protobufList2.size();
        if (i == 0) {
          i = 10;
        } else {
          i *= 2;
        } 
        protobufList1 = protobufList2.mutableCopyWithCapacity(i);
        UnsafeUtil.putObject(param1Object, param1Long, protobufList1);
      } 
      return (List)protobufList1;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\protobuf\ListFieldSchema.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */