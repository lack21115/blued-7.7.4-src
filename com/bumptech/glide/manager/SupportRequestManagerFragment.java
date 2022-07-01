package com.bumptech.glide.manager;

import android.content.Context;
import android.util.Log;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class SupportRequestManagerFragment extends Fragment {
  private final ActivityFragmentLifecycle a;
  
  private final RequestManagerTreeNode b = new SupportFragmentRequestManagerTreeNode(this);
  
  private final Set<SupportRequestManagerFragment> c = new HashSet<SupportRequestManagerFragment>();
  
  private SupportRequestManagerFragment d;
  
  private RequestManager e;
  
  private Fragment f;
  
  public SupportRequestManagerFragment() {
    this(new ActivityFragmentLifecycle());
  }
  
  public SupportRequestManagerFragment(ActivityFragmentLifecycle paramActivityFragmentLifecycle) {
    this.a = paramActivityFragmentLifecycle;
  }
  
  private void a(Context paramContext, FragmentManager paramFragmentManager) {
    f();
    this.d = Glide.a(paramContext).h().a(paramContext, paramFragmentManager);
    if (!equals(this.d))
      this.d.a(this); 
  }
  
  private void a(SupportRequestManagerFragment paramSupportRequestManagerFragment) {
    this.c.add(paramSupportRequestManagerFragment);
  }
  
  private static FragmentManager b(Fragment paramFragment) {
    while (paramFragment.getParentFragment() != null)
      paramFragment = paramFragment.getParentFragment(); 
    return paramFragment.getFragmentManager();
  }
  
  private void b(SupportRequestManagerFragment paramSupportRequestManagerFragment) {
    this.c.remove(paramSupportRequestManagerFragment);
  }
  
  private boolean c(Fragment paramFragment) {
    Fragment fragment = e();
    while (true) {
      Fragment fragment1 = paramFragment.getParentFragment();
      if (fragment1 != null) {
        if (fragment1.equals(fragment))
          return true; 
        paramFragment = paramFragment.getParentFragment();
        continue;
      } 
      return false;
    } 
  }
  
  private Fragment e() {
    Fragment fragment = getParentFragment();
    return (fragment != null) ? fragment : this.f;
  }
  
  private void f() {
    SupportRequestManagerFragment supportRequestManagerFragment = this.d;
    if (supportRequestManagerFragment != null) {
      supportRequestManagerFragment.b(this);
      this.d = null;
    } 
  }
  
  ActivityFragmentLifecycle a() {
    return this.a;
  }
  
  void a(Fragment paramFragment) {
    this.f = paramFragment;
    if (paramFragment != null) {
      if (paramFragment.getContext() == null)
        return; 
      FragmentManager fragmentManager = b(paramFragment);
      if (fragmentManager == null)
        return; 
      a(paramFragment.getContext(), fragmentManager);
    } 
  }
  
  public void a(RequestManager paramRequestManager) {
    this.e = paramRequestManager;
  }
  
  public RequestManager b() {
    return this.e;
  }
  
  public RequestManagerTreeNode c() {
    return this.b;
  }
  
  Set<SupportRequestManagerFragment> d() {
    SupportRequestManagerFragment supportRequestManagerFragment = this.d;
    if (supportRequestManagerFragment == null)
      return Collections.emptySet(); 
    if (equals(supportRequestManagerFragment))
      return Collections.unmodifiableSet(this.c); 
    HashSet<SupportRequestManagerFragment> hashSet = new HashSet();
    for (SupportRequestManagerFragment supportRequestManagerFragment1 : this.d.d()) {
      if (c(supportRequestManagerFragment1.e()))
        hashSet.add(supportRequestManagerFragment1); 
    } 
    return Collections.unmodifiableSet(hashSet);
  }
  
  public void onAttach(Context paramContext) {
    super.onAttach(paramContext);
    FragmentManager fragmentManager = b(this);
    if (fragmentManager == null) {
      if (Log.isLoggable("SupportRMFragment", 5))
        Log.w("SupportRMFragment", "Unable to register fragment with root, ancestor detached"); 
      return;
    } 
    try {
      a(getContext(), fragmentManager);
      return;
    } catch (IllegalStateException illegalStateException) {
      if (Log.isLoggable("SupportRMFragment", 5))
        Log.w("SupportRMFragment", "Unable to register fragment with root", illegalStateException); 
      return;
    } 
  }
  
  public void onDestroy() {
    super.onDestroy();
    this.a.c();
    f();
  }
  
  public void onDetach() {
    super.onDetach();
    this.f = null;
    f();
  }
  
  public void onStart() {
    super.onStart();
    this.a.a();
  }
  
  public void onStop() {
    super.onStop();
    this.a.b();
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(super.toString());
    stringBuilder.append("{parent=");
    stringBuilder.append(e());
    stringBuilder.append("}");
    return stringBuilder.toString();
  }
  
  class SupportFragmentRequestManagerTreeNode implements RequestManagerTreeNode {
    SupportFragmentRequestManagerTreeNode(SupportRequestManagerFragment this$0) {}
    
    public Set<RequestManager> a() {
      Set<SupportRequestManagerFragment> set = this.a.d();
      HashSet<RequestManager> hashSet = new HashSet(set.size());
      for (SupportRequestManagerFragment supportRequestManagerFragment : set) {
        if (supportRequestManagerFragment.b() != null)
          hashSet.add(supportRequestManagerFragment.b()); 
      } 
      return hashSet;
    }
    
    public String toString() {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(super.toString());
      stringBuilder.append("{fragment=");
      stringBuilder.append(this.a);
      stringBuilder.append("}");
      return stringBuilder.toString();
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bumptech\glide\manager\SupportRequestManagerFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */