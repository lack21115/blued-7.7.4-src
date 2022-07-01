package com.facebook.stetho.inspector.domstorage;

import android.content.Context;
import android.content.SharedPreferences;
import com.facebook.stetho.common.LogUtil;
import com.facebook.stetho.inspector.helper.ChromePeerManager;
import com.facebook.stetho.inspector.helper.PeerRegistrationListener;
import com.facebook.stetho.inspector.helper.PeersRegisteredListener;
import com.facebook.stetho.inspector.protocol.module.DOMStorage;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class DOMStoragePeerManager extends ChromePeerManager {
  private final Context mContext;
  
  private final PeerRegistrationListener mPeerListener = (PeerRegistrationListener)new PeersRegisteredListener() {
      private final List<DOMStoragePeerManager.DevToolsSharedPreferencesListener> mPrefsListeners = new ArrayList<DOMStoragePeerManager.DevToolsSharedPreferencesListener>();
      
      public void onFirstPeerRegistered() {
        // Byte code:
        //   0: aload_0
        //   1: monitorenter
        //   2: aload_0
        //   3: getfield this$0 : Lcom/facebook/stetho/inspector/domstorage/DOMStoragePeerManager;
        //   6: invokestatic access$000 : (Lcom/facebook/stetho/inspector/domstorage/DOMStoragePeerManager;)Landroid/content/Context;
        //   9: invokestatic getSharedPreferenceTags : (Landroid/content/Context;)Ljava/util/List;
        //   12: invokeinterface iterator : ()Ljava/util/Iterator;
        //   17: astore_1
        //   18: aload_1
        //   19: invokeinterface hasNext : ()Z
        //   24: ifeq -> 85
        //   27: aload_1
        //   28: invokeinterface next : ()Ljava/lang/Object;
        //   33: checkcast java/lang/String
        //   36: astore_3
        //   37: aload_0
        //   38: getfield this$0 : Lcom/facebook/stetho/inspector/domstorage/DOMStoragePeerManager;
        //   41: invokestatic access$000 : (Lcom/facebook/stetho/inspector/domstorage/DOMStoragePeerManager;)Landroid/content/Context;
        //   44: aload_3
        //   45: iconst_0
        //   46: invokevirtual getSharedPreferences : (Ljava/lang/String;I)Landroid/content/SharedPreferences;
        //   49: astore_2
        //   50: new com/facebook/stetho/inspector/domstorage/DOMStoragePeerManager$DevToolsSharedPreferencesListener
        //   53: dup
        //   54: aload_0
        //   55: getfield this$0 : Lcom/facebook/stetho/inspector/domstorage/DOMStoragePeerManager;
        //   58: aload_2
        //   59: aload_3
        //   60: invokespecial <init> : (Lcom/facebook/stetho/inspector/domstorage/DOMStoragePeerManager;Landroid/content/SharedPreferences;Ljava/lang/String;)V
        //   63: astore_3
        //   64: aload_2
        //   65: aload_3
        //   66: invokeinterface registerOnSharedPreferenceChangeListener : (Landroid/content/SharedPreferences$OnSharedPreferenceChangeListener;)V
        //   71: aload_0
        //   72: getfield mPrefsListeners : Ljava/util/List;
        //   75: aload_3
        //   76: invokeinterface add : (Ljava/lang/Object;)Z
        //   81: pop
        //   82: goto -> 18
        //   85: aload_0
        //   86: monitorexit
        //   87: return
        //   88: astore_1
        //   89: aload_0
        //   90: monitorexit
        //   91: aload_1
        //   92: athrow
        // Exception table:
        //   from	to	target	type
        //   2	18	88	finally
        //   18	82	88	finally
      }
      
      public void onLastPeerUnregistered() {
        // Byte code:
        //   0: aload_0
        //   1: monitorenter
        //   2: aload_0
        //   3: getfield mPrefsListeners : Ljava/util/List;
        //   6: invokeinterface iterator : ()Ljava/util/Iterator;
        //   11: astore_1
        //   12: aload_1
        //   13: invokeinterface hasNext : ()Z
        //   18: ifeq -> 36
        //   21: aload_1
        //   22: invokeinterface next : ()Ljava/lang/Object;
        //   27: checkcast com/facebook/stetho/inspector/domstorage/DOMStoragePeerManager$DevToolsSharedPreferencesListener
        //   30: invokevirtual unregister : ()V
        //   33: goto -> 12
        //   36: aload_0
        //   37: getfield mPrefsListeners : Ljava/util/List;
        //   40: invokeinterface clear : ()V
        //   45: aload_0
        //   46: monitorexit
        //   47: return
        //   48: astore_1
        //   49: aload_0
        //   50: monitorexit
        //   51: aload_1
        //   52: athrow
        // Exception table:
        //   from	to	target	type
        //   2	12	48	finally
        //   12	33	48	finally
        //   36	45	48	finally
      }
    };
  
  public DOMStoragePeerManager(Context paramContext) {
    this.mContext = paramContext;
    setListener(this.mPeerListener);
  }
  
  private static Map<String, Object> prefsCopy(Map<String, ?> paramMap) {
    HashMap<Object, Object> hashMap = new HashMap<Object, Object>(paramMap.size());
    for (Map.Entry<String, ?> entry : paramMap.entrySet()) {
      String str = (String)entry.getKey();
      entry = (Map.Entry<String, ?>)entry.getValue();
      if (entry instanceof Set) {
        hashMap.put(str, shallowCopy((Set)entry));
        continue;
      } 
      hashMap.put(str, entry);
    } 
    return (Map)hashMap;
  }
  
  private static <T> Set<T> shallowCopy(Set<T> paramSet) {
    HashSet<T> hashSet = new HashSet();
    Iterator<T> iterator = paramSet.iterator();
    while (iterator.hasNext())
      hashSet.add(iterator.next()); 
    return hashSet;
  }
  
  public void signalItemAdded(DOMStorage.StorageId paramStorageId, String paramString1, String paramString2) {
    DOMStorage.DomStorageItemAddedParams domStorageItemAddedParams = new DOMStorage.DomStorageItemAddedParams();
    domStorageItemAddedParams.storageId = paramStorageId;
    domStorageItemAddedParams.key = paramString1;
    domStorageItemAddedParams.newValue = paramString2;
    sendNotificationToPeers("DOMStorage.domStorageItemAdded", domStorageItemAddedParams);
  }
  
  public void signalItemRemoved(DOMStorage.StorageId paramStorageId, String paramString) {
    DOMStorage.DomStorageItemRemovedParams domStorageItemRemovedParams = new DOMStorage.DomStorageItemRemovedParams();
    domStorageItemRemovedParams.storageId = paramStorageId;
    domStorageItemRemovedParams.key = paramString;
    sendNotificationToPeers("DOMStorage.domStorageItemRemoved", domStorageItemRemovedParams);
  }
  
  public void signalItemUpdated(DOMStorage.StorageId paramStorageId, String paramString1, String paramString2, String paramString3) {
    DOMStorage.DomStorageItemUpdatedParams domStorageItemUpdatedParams = new DOMStorage.DomStorageItemUpdatedParams();
    domStorageItemUpdatedParams.storageId = paramStorageId;
    domStorageItemUpdatedParams.key = paramString1;
    domStorageItemUpdatedParams.oldValue = paramString2;
    domStorageItemUpdatedParams.newValue = paramString3;
    sendNotificationToPeers("DOMStorage.domStorageItemUpdated", domStorageItemUpdatedParams);
  }
  
  class DevToolsSharedPreferencesListener implements SharedPreferences.OnSharedPreferenceChangeListener {
    private final Map<String, Object> mCopy;
    
    private final SharedPreferences mPrefs;
    
    private final DOMStorage.StorageId mStorageId;
    
    public DevToolsSharedPreferencesListener(SharedPreferences param1SharedPreferences, String param1String) {
      this.mPrefs = param1SharedPreferences;
      this.mStorageId = new DOMStorage.StorageId();
      DOMStorage.StorageId storageId = this.mStorageId;
      storageId.securityOrigin = param1String;
      storageId.isLocalStorage = true;
      this.mCopy = DOMStoragePeerManager.prefsCopy(param1SharedPreferences.getAll());
    }
    
    public void onSharedPreferenceChanged(SharedPreferences param1SharedPreferences, String param1String) {
      Map map = param1SharedPreferences.getAll();
      boolean bool1 = this.mCopy.containsKey(param1String);
      boolean bool2 = map.containsKey(param1String);
      if (bool2) {
        map = (Map)map.get(param1String);
      } else {
        map = null;
      } 
      if (bool1 && bool2) {
        DOMStoragePeerManager.this.signalItemUpdated(this.mStorageId, param1String, SharedPreferencesHelper.valueToString(this.mCopy.get(param1String)), SharedPreferencesHelper.valueToString(map));
        this.mCopy.put(param1String, map);
        return;
      } 
      if (bool1) {
        DOMStoragePeerManager.this.signalItemRemoved(this.mStorageId, param1String);
        this.mCopy.remove(param1String);
        return;
      } 
      if (bool2) {
        DOMStoragePeerManager.this.signalItemAdded(this.mStorageId, param1String, SharedPreferencesHelper.valueToString(map));
        this.mCopy.put(param1String, map);
        return;
      } 
      LogUtil.i("Detected rapid put/remove of %s", new Object[] { param1String });
    }
    
    public void unregister() {
      this.mPrefs.unregisterOnSharedPreferenceChangeListener(this);
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\facebook\stetho\inspector\domstorage\DOMStoragePeerManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */