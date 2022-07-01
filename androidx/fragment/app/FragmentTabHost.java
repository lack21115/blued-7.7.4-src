package androidx.fragment.app;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TabHost;
import android.widget.TabWidget;
import java.util.ArrayList;

@Deprecated
public class FragmentTabHost extends TabHost implements TabHost.OnTabChangeListener {
  private final ArrayList<TabInfo> a = new ArrayList<TabInfo>();
  
  private FrameLayout b;
  
  private Context c;
  
  private FragmentManager d;
  
  private int e;
  
  private TabHost.OnTabChangeListener f;
  
  private TabInfo g;
  
  private boolean h;
  
  @Deprecated
  public FragmentTabHost(Context paramContext) {
    super(paramContext, null);
    a(paramContext, (AttributeSet)null);
  }
  
  @Deprecated
  public FragmentTabHost(Context paramContext, AttributeSet paramAttributeSet) {
    super(paramContext, paramAttributeSet);
    a(paramContext, paramAttributeSet);
  }
  
  private TabInfo a(String paramString) {
    int j = this.a.size();
    for (int i = 0; i < j; i++) {
      TabInfo tabInfo = this.a.get(i);
      if (tabInfo.a.equals(paramString))
        return tabInfo; 
    } 
    return null;
  }
  
  private FragmentTransaction a(String paramString, FragmentTransaction paramFragmentTransaction) {
    TabInfo tabInfo = a(paramString);
    FragmentTransaction fragmentTransaction = paramFragmentTransaction;
    if (this.g != tabInfo) {
      fragmentTransaction = paramFragmentTransaction;
      if (paramFragmentTransaction == null)
        fragmentTransaction = this.d.beginTransaction(); 
      TabInfo tabInfo1 = this.g;
      if (tabInfo1 != null && tabInfo1.d != null)
        fragmentTransaction.detach(this.g.d); 
      if (tabInfo != null)
        if (tabInfo.d == null) {
          tabInfo.d = this.d.getFragmentFactory().instantiate(this.c.getClassLoader(), tabInfo.b.getName());
          tabInfo.d.setArguments(tabInfo.c);
          fragmentTransaction.add(this.e, tabInfo.d, tabInfo.a);
        } else {
          fragmentTransaction.attach(tabInfo.d);
        }  
      this.g = tabInfo;
    } 
    return fragmentTransaction;
  }
  
  private void a() {
    if (this.b == null) {
      this.b = (FrameLayout)findViewById(this.e);
      if (this.b != null)
        return; 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("No tab content FrameLayout found for id ");
      stringBuilder.append(this.e);
      throw new IllegalStateException(stringBuilder.toString());
    } 
  }
  
  private void a(Context paramContext) {
    if (findViewById(16908307) == null) {
      LinearLayout linearLayout = new LinearLayout(paramContext);
      linearLayout.setOrientation(1);
      addView((View)linearLayout, (ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, -1));
      TabWidget tabWidget = new TabWidget(paramContext);
      tabWidget.setId(16908307);
      tabWidget.setOrientation(0);
      linearLayout.addView((View)tabWidget, (ViewGroup.LayoutParams)new LinearLayout.LayoutParams(-1, -2, 0.0F));
      FrameLayout frameLayout2 = new FrameLayout(paramContext);
      frameLayout2.setId(16908305);
      linearLayout.addView((View)frameLayout2, (ViewGroup.LayoutParams)new LinearLayout.LayoutParams(0, 0, 0.0F));
      FrameLayout frameLayout1 = new FrameLayout(paramContext);
      this.b = frameLayout1;
      this.b.setId(this.e);
      linearLayout.addView((View)frameLayout1, (ViewGroup.LayoutParams)new LinearLayout.LayoutParams(-1, 0, 1.0F));
    } 
  }
  
  private void a(Context paramContext, AttributeSet paramAttributeSet) {
    TypedArray typedArray = paramContext.obtainStyledAttributes(paramAttributeSet, new int[] { 16842995 }, 0, 0);
    this.e = typedArray.getResourceId(0, 0);
    typedArray.recycle();
    super.setOnTabChangedListener(this);
  }
  
  @Deprecated
  public void addTab(TabHost.TabSpec paramTabSpec, Class<?> paramClass, Bundle paramBundle) {
    paramTabSpec.setContent(new DummyTabFactory(this.c));
    String str = paramTabSpec.getTag();
    TabInfo tabInfo = new TabInfo(str, paramClass, paramBundle);
    if (this.h) {
      tabInfo.d = this.d.findFragmentByTag(str);
      if (tabInfo.d != null && !tabInfo.d.isDetached()) {
        FragmentTransaction fragmentTransaction = this.d.beginTransaction();
        fragmentTransaction.detach(tabInfo.d);
        fragmentTransaction.commit();
      } 
    } 
    this.a.add(tabInfo);
    addTab(paramTabSpec);
  }
  
  @Deprecated
  public void onAttachedToWindow() {
    super.onAttachedToWindow();
    String str = getCurrentTabTag();
    int j = this.a.size();
    FragmentTransaction fragmentTransaction = null;
    int i = 0;
    while (i < j) {
      TabInfo tabInfo = this.a.get(i);
      tabInfo.d = this.d.findFragmentByTag(tabInfo.a);
      FragmentTransaction fragmentTransaction1 = fragmentTransaction;
      if (tabInfo.d != null) {
        fragmentTransaction1 = fragmentTransaction;
        if (!tabInfo.d.isDetached())
          if (tabInfo.a.equals(str)) {
            this.g = tabInfo;
            fragmentTransaction1 = fragmentTransaction;
          } else {
            fragmentTransaction1 = fragmentTransaction;
            if (fragmentTransaction == null)
              fragmentTransaction1 = this.d.beginTransaction(); 
            fragmentTransaction1.detach(tabInfo.d);
          }  
      } 
      i++;
      fragmentTransaction = fragmentTransaction1;
    } 
    this.h = true;
    fragmentTransaction = a(str, fragmentTransaction);
    if (fragmentTransaction != null) {
      fragmentTransaction.commit();
      this.d.executePendingTransactions();
    } 
  }
  
  @Deprecated
  protected void onDetachedFromWindow() {
    super.onDetachedFromWindow();
    this.h = false;
  }
  
  @Deprecated
  protected void onRestoreInstanceState(Parcelable paramParcelable) {
    if (!(paramParcelable instanceof SavedState)) {
      super.onRestoreInstanceState(paramParcelable);
      return;
    } 
    SavedState savedState = (SavedState)paramParcelable;
    super.onRestoreInstanceState(savedState.getSuperState());
    setCurrentTabByTag(savedState.a);
  }
  
  @Deprecated
  protected Parcelable onSaveInstanceState() {
    SavedState savedState = new SavedState(super.onSaveInstanceState());
    savedState.a = getCurrentTabTag();
    return (Parcelable)savedState;
  }
  
  @Deprecated
  public void onTabChanged(String paramString) {
    if (this.h) {
      FragmentTransaction fragmentTransaction = a(paramString, (FragmentTransaction)null);
      if (fragmentTransaction != null)
        fragmentTransaction.commit(); 
    } 
    TabHost.OnTabChangeListener onTabChangeListener = this.f;
    if (onTabChangeListener != null)
      onTabChangeListener.onTabChanged(paramString); 
  }
  
  @Deprecated
  public void setOnTabChangedListener(TabHost.OnTabChangeListener paramOnTabChangeListener) {
    this.f = paramOnTabChangeListener;
  }
  
  @Deprecated
  public void setup() {
    throw new IllegalStateException("Must call setup() that takes a Context and FragmentManager");
  }
  
  @Deprecated
  public void setup(Context paramContext, FragmentManager paramFragmentManager) {
    a(paramContext);
    super.setup();
    this.c = paramContext;
    this.d = paramFragmentManager;
    a();
  }
  
  @Deprecated
  public void setup(Context paramContext, FragmentManager paramFragmentManager, int paramInt) {
    a(paramContext);
    super.setup();
    this.c = paramContext;
    this.d = paramFragmentManager;
    this.e = paramInt;
    a();
    this.b.setId(paramInt);
    if (getId() == -1)
      setId(16908306); 
  }
  
  static class DummyTabFactory implements TabHost.TabContentFactory {
    private final Context a;
    
    public DummyTabFactory(Context param1Context) {
      this.a = param1Context;
    }
    
    public View createTabContent(String param1String) {
      View view = new View(this.a);
      view.setMinimumWidth(0);
      view.setMinimumHeight(0);
      return view;
    }
  }
  
  static class SavedState extends View.BaseSavedState {
    public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() {
        public FragmentTabHost.SavedState createFromParcel(Parcel param2Parcel) {
          return new FragmentTabHost.SavedState(param2Parcel);
        }
        
        public FragmentTabHost.SavedState[] newArray(int param2Int) {
          return new FragmentTabHost.SavedState[param2Int];
        }
      };
    
    String a;
    
    SavedState(Parcel param1Parcel) {
      super(param1Parcel);
      this.a = param1Parcel.readString();
    }
    
    SavedState(Parcelable param1Parcelable) {
      super(param1Parcelable);
    }
    
    public String toString() {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("FragmentTabHost.SavedState{");
      stringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
      stringBuilder.append(" curTab=");
      stringBuilder.append(this.a);
      stringBuilder.append("}");
      return stringBuilder.toString();
    }
    
    public void writeToParcel(Parcel param1Parcel, int param1Int) {
      super.writeToParcel(param1Parcel, param1Int);
      param1Parcel.writeString(this.a);
    }
  }
  
  static final class null implements Parcelable.Creator<SavedState> {
    public FragmentTabHost.SavedState createFromParcel(Parcel param1Parcel) {
      return new FragmentTabHost.SavedState(param1Parcel);
    }
    
    public FragmentTabHost.SavedState[] newArray(int param1Int) {
      return new FragmentTabHost.SavedState[param1Int];
    }
  }
  
  static final class TabInfo {
    final String a;
    
    final Class<?> b;
    
    final Bundle c;
    
    Fragment d;
    
    TabInfo(String param1String, Class<?> param1Class, Bundle param1Bundle) {
      this.a = param1String;
      this.b = param1Class;
      this.c = param1Bundle;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\androidx\fragment\app\FragmentTabHost.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */