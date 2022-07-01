package com.soft.blued.ui.setting.fragment;

import android.content.Context;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ToggleButton;
import androidx.fragment.app.FragmentActivity;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.module.common.base.mvvm.MVVMBaseFragment;
import com.soft.blued.R;
import com.soft.blued.customview.CommonTopTitleNoTrans;
import com.soft.blued.ui.setting.vm.CustomOptionsViewModel;
import com.soft.blued.utils.BluedPreferences;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\000 \n\002\030\002\n\002\030\002\n\002\030\002\n\002\b\002\n\002\020\b\n\002\b\003\n\002\020\002\n\002\b\003\030\000 \0132\b\022\004\022\0020\0020\001:\001\013B\005¢\006\002\020\003J\b\020\b\032\0020\tH\024J\b\020\n\032\0020\tH\024R\024\020\004\032\0020\005XD¢\006\b\n\000\032\004\b\006\020\007¨\006\f"}, d2 = {"Lcom/soft/blued/ui/setting/fragment/CustomOptionsFragment;", "Lcom/blued/android/module/common/base/mvvm/MVVMBaseFragment;", "Lcom/soft/blued/ui/setting/vm/CustomOptionsViewModel;", "()V", "layoutId", "", "getLayoutId", "()I", "init", "", "liveDataObserver", "Companion", "blued_app_a9999aRelease"}, k = 1, mv = {1, 1, 16})
public final class CustomOptionsFragment extends MVVMBaseFragment<CustomOptionsViewModel> {
  public static final Companion e = new Companion(null);
  
  private final int f = 2131493113;
  
  private HashMap g;
  
  public int a() {
    return this.f;
  }
  
  public View a(int paramInt) {
    if (this.g == null)
      this.g = new HashMap<Object, Object>(); 
    View view2 = (View)this.g.get(Integer.valueOf(paramInt));
    View view1 = view2;
    if (view2 == null) {
      view1 = getView();
      if (view1 == null)
        return null; 
      view1 = view1.findViewById(paramInt);
      this.g.put(Integer.valueOf(paramInt), view1);
    } 
    return view1;
  }
  
  public void p() {}
  
  public void q() {
    ((CommonTopTitleNoTrans)a(R.id.title)).setLeftClickListener(new CustomOptionsFragment$init$1(this));
    ToggleButton toggleButton = (ToggleButton)a(R.id.tglbtnCustomRecommend);
    Intrinsics.a(toggleButton, "tglbtnCustomRecommend");
    toggleButton.setChecked(BluedPreferences.aw());
    ((ToggleButton)a(R.id.tglbtnCustomRecommend)).setOnCheckedChangeListener(CustomOptionsFragment$init$2.a);
  }
  
  public void u() {
    HashMap hashMap = this.g;
    if (hashMap != null)
      hashMap.clear(); 
  }
  
  @Metadata(bv = {1, 0, 3}, d1 = {"\000\030\n\002\030\002\n\002\020\000\n\002\b\002\n\002\020\002\n\000\n\002\030\002\n\000\b\003\030\0002\0020\001B\007\b\002¢\006\002\020\002J\016\020\003\032\0020\0042\006\020\005\032\0020\006¨\006\007"}, d2 = {"Lcom/soft/blued/ui/setting/fragment/CustomOptionsFragment$Companion;", "", "()V", "show", "", "context", "Landroid/content/Context;", "blued_app_a9999aRelease"}, k = 1, mv = {1, 1, 16})
  public static final class Companion {
    private Companion() {}
    
    public final void a(Context param1Context) {
      Intrinsics.b(param1Context, "context");
      TerminalActivity.d(param1Context, CustomOptionsFragment.class, null);
    }
  }
  
  @Metadata(bv = {1, 0, 3}, d1 = {"\000\020\n\000\n\002\020\002\n\000\n\002\030\002\n\002\b\002\020\000\032\0020\0012\016\020\002\032\n \004*\004\030\0010\0030\003H\n¢\006\002\b\005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k = 3, mv = {1, 1, 16})
  static final class CustomOptionsFragment$init$1 implements View.OnClickListener {
    CustomOptionsFragment$init$1(CustomOptionsFragment param1CustomOptionsFragment) {}
    
    public final void onClick(View param1View) {
      FragmentActivity fragmentActivity = this.a.getActivity();
      if (fragmentActivity == null)
        Intrinsics.a(); 
      fragmentActivity.finish();
    }
  }
  
  @Metadata(bv = {1, 0, 3}, d1 = {"\000\026\n\000\n\002\020\002\n\000\n\002\030\002\n\002\b\002\n\002\020\013\n\000\020\000\032\0020\0012\016\020\002\032\n \004*\004\030\0010\0030\0032\006\020\005\032\0020\006H\n¢\006\002\b\007"}, d2 = {"<anonymous>", "", "<anonymous parameter 0>", "Landroid/widget/CompoundButton;", "kotlin.jvm.PlatformType", "isChecked", "", "onCheckedChanged"}, k = 3, mv = {1, 1, 16})
  static final class CustomOptionsFragment$init$2 implements CompoundButton.OnCheckedChangeListener {
    public static final CustomOptionsFragment$init$2 a = new CustomOptionsFragment$init$2();
    
    public final void onCheckedChanged(CompoundButton param1CompoundButton, boolean param1Boolean) {
      BluedPreferences.w(param1Boolean);
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\setting\fragment\CustomOptionsFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */