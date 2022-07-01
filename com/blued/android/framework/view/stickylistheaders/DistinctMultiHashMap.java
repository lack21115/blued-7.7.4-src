package com.blued.android.framework.view.stickylistheaders;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

class DistinctMultiHashMap<TKey, TItemValue> {
  LinkedHashMap<Object, List<TItemValue>> a = new LinkedHashMap<Object, List<TItemValue>>();
  
  LinkedHashMap<Object, TKey> b = new LinkedHashMap<Object, TKey>();
  
  private IDMapper<TKey, TItemValue> c;
  
  DistinctMultiHashMap() {
    this(new IDMapper<TKey, TItemValue>() {
          public Object a(TKey param1TKey) {
            return param1TKey;
          }
          
          public Object b(TItemValue param1TItemValue) {
            return param1TItemValue;
          }
        });
  }
  
  DistinctMultiHashMap(IDMapper<TKey, TItemValue> paramIDMapper) {
    this.c = paramIDMapper;
  }
  
  public TKey a(TItemValue paramTItemValue) {
    return this.b.get(this.c.b(paramTItemValue));
  }
  
  public void a(TKey paramTKey, TItemValue paramTItemValue) {
    Object object = this.c.a(paramTKey);
    if (this.a.get(object) == null)
      this.a.put(object, new ArrayList<TItemValue>()); 
    object = a(paramTItemValue);
    if (object != null)
      ((List)this.a.get(this.c.a((TKey)object))).remove(paramTItemValue); 
    this.b.put(this.c.b(paramTItemValue), paramTKey);
    if (!a(this.a.get(this.c.a(paramTKey)), paramTItemValue))
      ((List<TItemValue>)this.a.get(this.c.a(paramTKey))).add(paramTItemValue); 
  }
  
  protected boolean a(List<TItemValue> paramList, TItemValue paramTItemValue) {
    // Byte code:
    //   0: aload_1
    //   1: invokeinterface iterator : ()Ljava/util/Iterator;
    //   6: astore_1
    //   7: aload_1
    //   8: invokeinterface hasNext : ()Z
    //   13: ifeq -> 51
    //   16: aload_1
    //   17: invokeinterface next : ()Ljava/lang/Object;
    //   22: astore_3
    //   23: aload_0
    //   24: getfield c : Lcom/blued/android/framework/view/stickylistheaders/DistinctMultiHashMap$IDMapper;
    //   27: aload_3
    //   28: invokeinterface b : (Ljava/lang/Object;)Ljava/lang/Object;
    //   33: aload_0
    //   34: getfield c : Lcom/blued/android/framework/view/stickylistheaders/DistinctMultiHashMap$IDMapper;
    //   37: aload_2
    //   38: invokeinterface b : (Ljava/lang/Object;)Ljava/lang/Object;
    //   43: invokevirtual equals : (Ljava/lang/Object;)Z
    //   46: ifeq -> 7
    //   49: iconst_1
    //   50: ireturn
    //   51: iconst_0
    //   52: ireturn
  }
  
  static interface IDMapper<TKey, TItemValue> {
    Object a(TKey param1TKey);
    
    Object b(TItemValue param1TItemValue);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\framework\view\stickylistheaders\DistinctMultiHashMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */