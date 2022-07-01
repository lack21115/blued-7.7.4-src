package androidx.fragment.app;

import android.util.Log;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

class FragmentManagerViewModel extends ViewModel {
  private static final ViewModelProvider.Factory a = new ViewModelProvider.Factory() {
      public <T extends ViewModel> T create(Class<T> param1Class) {
        return (T)new FragmentManagerViewModel(true);
      }
    };
  
  private final HashSet<Fragment> b = new HashSet<Fragment>();
  
  private final HashMap<String, FragmentManagerViewModel> c = new HashMap<String, FragmentManagerViewModel>();
  
  private final HashMap<String, ViewModelStore> d = new HashMap<String, ViewModelStore>();
  
  private final boolean e;
  
  private boolean f = false;
  
  private boolean g = false;
  
  FragmentManagerViewModel(boolean paramBoolean) {
    this.e = paramBoolean;
  }
  
  static FragmentManagerViewModel a(ViewModelStore paramViewModelStore) {
    return (FragmentManagerViewModel)(new ViewModelProvider(paramViewModelStore, a)).get(FragmentManagerViewModel.class);
  }
  
  @Deprecated
  void a(FragmentManagerNonConfig paramFragmentManagerNonConfig) {
    this.b.clear();
    this.c.clear();
    this.d.clear();
    if (paramFragmentManagerNonConfig != null) {
      Collection<Fragment> collection = paramFragmentManagerNonConfig.a();
      if (collection != null)
        this.b.addAll(collection); 
      Map<String, FragmentManagerNonConfig> map1 = paramFragmentManagerNonConfig.b();
      if (map1 != null)
        for (Map.Entry<String, FragmentManagerNonConfig> entry : map1.entrySet()) {
          FragmentManagerViewModel fragmentManagerViewModel = new FragmentManagerViewModel(this.e);
          fragmentManagerViewModel.a((FragmentManagerNonConfig)entry.getValue());
          this.c.put((String)entry.getKey(), fragmentManagerViewModel);
        }  
      Map<String, ViewModelStore> map = paramFragmentManagerNonConfig.c();
      if (map != null)
        this.d.putAll(map); 
    } 
    this.g = false;
  }
  
  boolean a() {
    return this.f;
  }
  
  boolean a(Fragment paramFragment) {
    return this.b.add(paramFragment);
  }
  
  Collection<Fragment> b() {
    return this.b;
  }
  
  boolean b(Fragment paramFragment) {
    return !this.b.contains(paramFragment) ? true : (this.e ? this.f : (this.g ^ true));
  }
  
  @Deprecated
  FragmentManagerNonConfig c() {
    if (this.b.isEmpty() && this.c.isEmpty() && this.d.isEmpty())
      return null; 
    HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
    for (Map.Entry<String, FragmentManagerViewModel> entry : this.c.entrySet()) {
      FragmentManagerNonConfig fragmentManagerNonConfig = ((FragmentManagerViewModel)entry.getValue()).c();
      if (fragmentManagerNonConfig != null)
        hashMap.put(entry.getKey(), fragmentManagerNonConfig); 
    } 
    this.g = true;
    return (this.b.isEmpty() && hashMap.isEmpty() && this.d.isEmpty()) ? null : new FragmentManagerNonConfig(new ArrayList<Fragment>(this.b), (Map)hashMap, new HashMap<String, ViewModelStore>(this.d));
  }
  
  boolean c(Fragment paramFragment) {
    return this.b.remove(paramFragment);
  }
  
  FragmentManagerViewModel d(Fragment paramFragment) {
    FragmentManagerViewModel fragmentManagerViewModel2 = this.c.get(paramFragment.mWho);
    FragmentManagerViewModel fragmentManagerViewModel1 = fragmentManagerViewModel2;
    if (fragmentManagerViewModel2 == null) {
      fragmentManagerViewModel1 = new FragmentManagerViewModel(this.e);
      this.c.put(paramFragment.mWho, fragmentManagerViewModel1);
    } 
    return fragmentManagerViewModel1;
  }
  
  ViewModelStore e(Fragment paramFragment) {
    ViewModelStore viewModelStore2 = this.d.get(paramFragment.mWho);
    ViewModelStore viewModelStore1 = viewModelStore2;
    if (viewModelStore2 == null) {
      viewModelStore1 = new ViewModelStore();
      this.d.put(paramFragment.mWho, viewModelStore1);
    } 
    return viewModelStore1;
  }
  
  public boolean equals(Object paramObject) {
    if (this == paramObject)
      return true; 
    if (paramObject != null) {
      if (getClass() != paramObject.getClass())
        return false; 
      paramObject = paramObject;
      return (this.b.equals(((FragmentManagerViewModel)paramObject).b) && this.c.equals(((FragmentManagerViewModel)paramObject).c) && this.d.equals(((FragmentManagerViewModel)paramObject).d));
    } 
    return false;
  }
  
  void f(Fragment paramFragment) {
    if (FragmentManagerImpl.b) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Clearing non-config state for ");
      stringBuilder.append(paramFragment);
      Log.d("FragmentManager", stringBuilder.toString());
    } 
    FragmentManagerViewModel fragmentManagerViewModel = this.c.get(paramFragment.mWho);
    if (fragmentManagerViewModel != null) {
      fragmentManagerViewModel.onCleared();
      this.c.remove(paramFragment.mWho);
    } 
    ViewModelStore viewModelStore = this.d.get(paramFragment.mWho);
    if (viewModelStore != null) {
      viewModelStore.clear();
      this.d.remove(paramFragment.mWho);
    } 
  }
  
  public int hashCode() {
    return (this.b.hashCode() * 31 + this.c.hashCode()) * 31 + this.d.hashCode();
  }
  
  public void onCleared() {
    if (FragmentManagerImpl.b) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("onCleared called for ");
      stringBuilder.append(this);
      Log.d("FragmentManager", stringBuilder.toString());
    } 
    this.f = true;
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder("FragmentManagerViewModel{");
    stringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
    stringBuilder.append("} Fragments (");
    Iterator<Fragment> iterator = this.b.iterator();
    while (iterator.hasNext()) {
      stringBuilder.append(iterator.next());
      if (iterator.hasNext())
        stringBuilder.append(", "); 
    } 
    stringBuilder.append(") Child Non Config (");
    iterator = this.c.keySet().iterator();
    while (iterator.hasNext()) {
      stringBuilder.append((String)iterator.next());
      if (iterator.hasNext())
        stringBuilder.append(", "); 
    } 
    stringBuilder.append(") ViewModelStores (");
    iterator = this.d.keySet().iterator();
    while (iterator.hasNext()) {
      stringBuilder.append((String)iterator.next());
      if (iterator.hasNext())
        stringBuilder.append(", "); 
    } 
    stringBuilder.append(')');
    return stringBuilder.toString();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\androidx\fragment\app\FragmentManagerViewModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */