package com.idlefish.flutterboost;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.text.TextUtils;
import com.idlefish.flutterboost.interfaces.IContainerManager;
import com.idlefish.flutterboost.interfaces.IContainerRecord;
import com.idlefish.flutterboost.interfaces.IFlutterViewContainer;
import com.idlefish.flutterboost.interfaces.IOperateSyncer;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

public class FlutterViewContainerManager implements IContainerManager {
  private final Map<IFlutterViewContainer, IContainerRecord> a = new LinkedHashMap<IFlutterViewContainer, IContainerRecord>();
  
  private final Set<ContainerRef> b = new HashSet<ContainerRef>();
  
  private final Stack<IContainerRecord> c = new Stack<IContainerRecord>();
  
  private final Map<String, OnResult> d = new HashMap<String, OnResult>();
  
  public IContainerRecord a() {
    return this.c.isEmpty() ? null : this.c.peek();
  }
  
  IContainerRecord a(String paramString, Map<String, Object> paramMap1, Map<String, Object> paramMap2) {
    // Byte code:
    //   0: aload_0
    //   1: getfield a : Ljava/util/Map;
    //   4: invokeinterface entrySet : ()Ljava/util/Set;
    //   9: invokeinterface iterator : ()Ljava/util/Iterator;
    //   14: astore #4
    //   16: aload #4
    //   18: invokeinterface hasNext : ()Z
    //   23: ifeq -> 75
    //   26: aload #4
    //   28: invokeinterface next : ()Ljava/lang/Object;
    //   33: checkcast java/util/Map$Entry
    //   36: astore #5
    //   38: aload_1
    //   39: aload #5
    //   41: invokeinterface getValue : ()Ljava/lang/Object;
    //   46: checkcast com/idlefish/flutterboost/interfaces/IContainerRecord
    //   49: invokeinterface a : ()Ljava/lang/String;
    //   54: invokestatic equals : (Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   57: ifeq -> 16
    //   60: aload #5
    //   62: invokeinterface getValue : ()Ljava/lang/Object;
    //   67: checkcast com/idlefish/flutterboost/interfaces/IContainerRecord
    //   70: astore #4
    //   72: goto -> 78
    //   75: aconst_null
    //   76: astore #4
    //   78: aload #4
    //   80: ifnonnull -> 115
    //   83: new java/lang/StringBuilder
    //   86: dup
    //   87: invokespecial <init> : ()V
    //   90: astore #5
    //   92: aload #5
    //   94: ldc 'closeContainer can not find uniqueId:'
    //   96: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   99: pop
    //   100: aload #5
    //   102: aload_1
    //   103: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   106: pop
    //   107: aload #5
    //   109: invokevirtual toString : ()Ljava/lang/String;
    //   112: invokestatic b : (Ljava/lang/String;)V
    //   115: invokestatic a : ()Lcom/idlefish/flutterboost/FlutterBoost;
    //   118: invokevirtual d : ()Lcom/idlefish/flutterboost/Platform;
    //   121: aload #4
    //   123: aload_2
    //   124: aload_3
    //   125: invokevirtual a : (Lcom/idlefish/flutterboost/interfaces/IContainerRecord;Ljava/util/Map;Ljava/util/Map;)V
    //   128: aload #4
    //   130: areturn
  }
  
  public IFlutterViewContainer a(String paramString) {
    // Byte code:
    //   0: aload_0
    //   1: getfield a : Ljava/util/Map;
    //   4: invokeinterface entrySet : ()Ljava/util/Set;
    //   9: invokeinterface iterator : ()Ljava/util/Iterator;
    //   14: astore_2
    //   15: aload_2
    //   16: invokeinterface hasNext : ()Z
    //   21: ifeq -> 68
    //   24: aload_2
    //   25: invokeinterface next : ()Ljava/lang/Object;
    //   30: checkcast java/util/Map$Entry
    //   33: astore_3
    //   34: aload_1
    //   35: aload_3
    //   36: invokeinterface getValue : ()Ljava/lang/Object;
    //   41: checkcast com/idlefish/flutterboost/interfaces/IContainerRecord
    //   44: invokeinterface a : ()Ljava/lang/String;
    //   49: invokestatic equals : (Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   52: ifeq -> 15
    //   55: aload_3
    //   56: invokeinterface getKey : ()Ljava/lang/Object;
    //   61: checkcast com/idlefish/flutterboost/interfaces/IFlutterViewContainer
    //   64: astore_2
    //   65: goto -> 70
    //   68: aconst_null
    //   69: astore_2
    //   70: aload_2
    //   71: ifnonnull -> 128
    //   74: aload_0
    //   75: getfield b : Ljava/util/Set;
    //   78: invokeinterface iterator : ()Ljava/util/Iterator;
    //   83: astore_3
    //   84: aload_3
    //   85: invokeinterface hasNext : ()Z
    //   90: ifeq -> 128
    //   93: aload_3
    //   94: invokeinterface next : ()Ljava/lang/Object;
    //   99: checkcast com/idlefish/flutterboost/FlutterViewContainerManager$ContainerRef
    //   102: astore #4
    //   104: aload_1
    //   105: aload #4
    //   107: getfield a : Ljava/lang/String;
    //   110: invokestatic equals : (Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   113: ifeq -> 84
    //   116: aload #4
    //   118: getfield b : Ljava/lang/ref/WeakReference;
    //   121: invokevirtual get : ()Ljava/lang/Object;
    //   124: checkcast com/idlefish/flutterboost/interfaces/IFlutterViewContainer
    //   127: areturn
    //   128: aload_2
    //   129: areturn
  }
  
  public IOperateSyncer a(IFlutterViewContainer paramIFlutterViewContainer) {
    Utils.a();
    ContainerRecord containerRecord = new ContainerRecord(this, paramIFlutterViewContainer);
    if (this.a.put(paramIFlutterViewContainer, containerRecord) != null) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("container:");
      stringBuilder.append(paramIFlutterViewContainer.n());
      stringBuilder.append(" already exists!");
      Debuger.b(stringBuilder.toString());
    } 
    this.b.add(new ContainerRef(containerRecord.a(), paramIFlutterViewContainer));
    return (IOperateSyncer)containerRecord;
  }
  
  void a(IContainerRecord paramIContainerRecord) {
    if (!this.a.containsValue(paramIContainerRecord))
      Debuger.b("invalid record!"); 
    this.c.push(paramIContainerRecord);
  }
  
  void a(IContainerRecord paramIContainerRecord, int paramInt1, int paramInt2, Map<String, Object> paramMap) {
    if (a(paramIContainerRecord.a()) == null) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("setContainerResult error, url=");
      stringBuilder.append(paramIContainerRecord.b().n());
      Debuger.b(stringBuilder.toString());
    } 
    Map<String, Object> map = paramMap;
    if (paramMap == null)
      map = new HashMap<String, Object>(); 
    map.put("_requestCode__", Integer.valueOf(paramInt1));
    map.put("_resultCode__", Integer.valueOf(paramInt2));
    OnResult onResult = this.d.remove(paramIContainerRecord.a());
    if (onResult != null)
      onResult.a(map); 
  }
  
  void a(String paramString1, String paramString2) {
    IFlutterViewContainer iFlutterViewContainer3;
    IFlutterViewContainer iFlutterViewContainer4;
    Utils.a();
    Iterator<Map.Entry> iterator = this.a.entrySet().iterator();
    IFlutterViewContainer iFlutterViewContainer2 = null;
    IFlutterViewContainer iFlutterViewContainer1 = null;
    while (true) {
      iFlutterViewContainer3 = iFlutterViewContainer2;
      iFlutterViewContainer4 = iFlutterViewContainer1;
      if (iterator.hasNext()) {
        Map.Entry entry = iterator.next();
        iFlutterViewContainer3 = iFlutterViewContainer2;
        if (TextUtils.equals(paramString1, ((IContainerRecord)entry.getValue()).a()))
          iFlutterViewContainer3 = (IFlutterViewContainer)entry.getKey(); 
        iFlutterViewContainer4 = iFlutterViewContainer1;
        if (TextUtils.equals(paramString2, ((IContainerRecord)entry.getValue()).a()))
          iFlutterViewContainer4 = (IFlutterViewContainer)entry.getKey(); 
        iFlutterViewContainer2 = iFlutterViewContainer3;
        iFlutterViewContainer1 = iFlutterViewContainer4;
        if (iFlutterViewContainer3 != null) {
          iFlutterViewContainer2 = iFlutterViewContainer3;
          iFlutterViewContainer1 = iFlutterViewContainer4;
          if (iFlutterViewContainer4 != null)
            break; 
        } 
        continue;
      } 
      break;
    } 
    if (iFlutterViewContainer4 != null)
      iFlutterViewContainer4.p(); 
    if (iFlutterViewContainer3 != null)
      iFlutterViewContainer3.q(); 
  }
  
  void a(String paramString, Map<String, Object> paramMap1, Map<String, Object> paramMap2, OnResult paramOnResult) {
    boolean bool;
    Application application;
    Activity activity2 = FlutterBoost.a().f();
    Activity activity1 = activity2;
    if (activity2 == null)
      application = FlutterBoost.a().d().a(); 
    Map<String, Object> map = paramMap1;
    if (paramMap1 == null)
      map = new HashMap<String, Object>(); 
    paramMap1 = (Map<String, Object>)map.remove("requestCode");
    if (paramMap1 != null) {
      bool = Integer.valueOf(String.valueOf(paramMap1)).intValue();
    } else {
      bool = false;
    } 
    map.put("__container_uniqueId_key__", ContainerRecord.a(paramString));
    IContainerRecord iContainerRecord = a();
    if (paramOnResult != null && iContainerRecord != null)
      this.d.put(iContainerRecord.a(), paramOnResult); 
    FlutterBoost.a().d().a((Context)application, paramString, map, bool, paramMap2);
  }
  
  public IContainerRecord b() {
    Collection<IContainerRecord> collection = this.a.values();
    if (!collection.isEmpty()) {
      collection = new ArrayList<IContainerRecord>(collection);
      return collection.get(collection.size() - 1);
    } 
    return null;
  }
  
  void b(IContainerRecord paramIContainerRecord) {
    if (this.c.empty())
      return; 
    if (this.c.peek() == paramIContainerRecord)
      this.c.pop(); 
  }
  
  void c(IContainerRecord paramIContainerRecord) {
    this.c.remove(paramIContainerRecord);
    this.a.remove(paramIContainerRecord.b());
  }
  
  public boolean c() {
    Iterator<Map.Entry> iterator = this.a.entrySet().iterator();
    while (iterator.hasNext()) {
      if (((IContainerRecord)((Map.Entry)iterator.next()).getValue()).c() == 2)
        return true; 
    } 
    return false;
  }
  
  public static class ContainerRef {
    public final String a;
    
    public final WeakReference<IFlutterViewContainer> b;
    
    ContainerRef(String param1String, IFlutterViewContainer param1IFlutterViewContainer) {
      this.a = param1String;
      this.b = new WeakReference<IFlutterViewContainer>(param1IFlutterViewContainer);
    }
  }
  
  static interface OnResult {
    void a(Map<String, Object> param1Map);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\idlefish\flutterboost\FlutterViewContainerManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */