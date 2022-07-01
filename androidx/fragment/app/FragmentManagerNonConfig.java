package androidx.fragment.app;

import androidx.lifecycle.ViewModelStore;
import java.util.Collection;
import java.util.Map;

@Deprecated
public class FragmentManagerNonConfig {
  private final Collection<Fragment> a;
  
  private final Map<String, FragmentManagerNonConfig> b;
  
  private final Map<String, ViewModelStore> c;
  
  FragmentManagerNonConfig(Collection<Fragment> paramCollection, Map<String, FragmentManagerNonConfig> paramMap, Map<String, ViewModelStore> paramMap1) {
    this.a = paramCollection;
    this.b = paramMap;
    this.c = paramMap1;
  }
  
  Collection<Fragment> a() {
    return this.a;
  }
  
  Map<String, FragmentManagerNonConfig> b() {
    return this.b;
  }
  
  Map<String, ViewModelStore> c() {
    return this.c;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\androidx\fragment\app\FragmentManagerNonConfig.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */