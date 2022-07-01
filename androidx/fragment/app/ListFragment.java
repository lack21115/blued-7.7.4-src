package androidx.fragment.app;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

public class ListFragment extends Fragment {
  ListAdapter a;
  
  ListView b;
  
  View c;
  
  TextView d;
  
  View e;
  
  View f;
  
  CharSequence g;
  
  boolean h;
  
  private final Handler i = new Handler();
  
  private final Runnable j = new Runnable(this) {
      public void run() {
        this.a.b.focusableViewAvailable((View)this.a.b);
      }
    };
  
  private final AdapterView.OnItemClickListener k = new AdapterView.OnItemClickListener(this) {
      public void onItemClick(AdapterView<?> param1AdapterView, View param1View, int param1Int, long param1Long) {
        this.a.onListItemClick((ListView)param1AdapterView, param1View, param1Int, param1Long);
      }
    };
  
  private void a() {
    if (this.b != null)
      return; 
    View view = getView();
    if (view != null) {
      if (view instanceof ListView) {
        this.b = (ListView)view;
      } else {
        this.d = (TextView)view.findViewById(16711681);
        TextView textView = this.d;
        if (textView == null) {
          this.c = view.findViewById(16908292);
        } else {
          textView.setVisibility(8);
        } 
        this.e = view.findViewById(16711682);
        this.f = view.findViewById(16711683);
        view = view.findViewById(16908298);
        if (!(view instanceof ListView)) {
          if (view == null)
            throw new RuntimeException("Your content must have a ListView whose id attribute is 'android.R.id.list'"); 
          throw new RuntimeException("Content has view with id attribute 'android.R.id.list' that is not a ListView class");
        } 
        this.b = (ListView)view;
        view = this.c;
        if (view != null) {
          this.b.setEmptyView(view);
        } else {
          CharSequence charSequence = this.g;
          if (charSequence != null) {
            this.d.setText(charSequence);
            this.b.setEmptyView((View)this.d);
          } 
        } 
      } 
      this.h = true;
      this.b.setOnItemClickListener(this.k);
      ListAdapter listAdapter = this.a;
      if (listAdapter != null) {
        this.a = null;
        setListAdapter(listAdapter);
      } else if (this.e != null) {
        a(false, false);
      } 
      this.i.post(this.j);
      return;
    } 
    throw new IllegalStateException("Content view not yet created");
  }
  
  private void a(boolean paramBoolean1, boolean paramBoolean2) {
    a();
    View view = this.e;
    if (view != null) {
      if (this.h == paramBoolean1)
        return; 
      this.h = paramBoolean1;
      if (paramBoolean1) {
        if (paramBoolean2) {
          view.startAnimation(AnimationUtils.loadAnimation(getContext(), 17432577));
          this.f.startAnimation(AnimationUtils.loadAnimation(getContext(), 17432576));
        } else {
          view.clearAnimation();
          this.f.clearAnimation();
        } 
        this.e.setVisibility(8);
        this.f.setVisibility(0);
        return;
      } 
      if (paramBoolean2) {
        view.startAnimation(AnimationUtils.loadAnimation(getContext(), 17432576));
        this.f.startAnimation(AnimationUtils.loadAnimation(getContext(), 17432577));
      } else {
        view.clearAnimation();
        this.f.clearAnimation();
      } 
      this.e.setVisibility(0);
      this.f.setVisibility(8);
      return;
    } 
    throw new IllegalStateException("Can't be used with a custom content view");
  }
  
  public ListAdapter getListAdapter() {
    return this.a;
  }
  
  public ListView getListView() {
    a();
    return this.b;
  }
  
  public long getSelectedItemId() {
    a();
    return this.b.getSelectedItemId();
  }
  
  public int getSelectedItemPosition() {
    a();
    return this.b.getSelectedItemPosition();
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
    Context context = requireContext();
    FrameLayout frameLayout1 = new FrameLayout(context);
    LinearLayout linearLayout = new LinearLayout(context);
    linearLayout.setId(16711682);
    linearLayout.setOrientation(1);
    linearLayout.setVisibility(8);
    linearLayout.setGravity(17);
    linearLayout.addView((View)new ProgressBar(context, null, 16842874), (ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-2, -2));
    frameLayout1.addView((View)linearLayout, (ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, -1));
    FrameLayout frameLayout2 = new FrameLayout(context);
    frameLayout2.setId(16711683);
    TextView textView = new TextView(context);
    textView.setId(16711681);
    textView.setGravity(17);
    frameLayout2.addView((View)textView, (ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, -1));
    ListView listView = new ListView(context);
    listView.setId(16908298);
    listView.setDrawSelectorOnTop(false);
    frameLayout2.addView((View)listView, (ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, -1));
    frameLayout1.addView((View)frameLayout2, (ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, -1));
    frameLayout1.setLayoutParams((ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, -1));
    return (View)frameLayout1;
  }
  
  public void onDestroyView() {
    this.i.removeCallbacks(this.j);
    this.b = null;
    this.h = false;
    this.f = null;
    this.e = null;
    this.c = null;
    this.d = null;
    super.onDestroyView();
  }
  
  public void onListItemClick(ListView paramListView, View paramView, int paramInt, long paramLong) {}
  
  public void onViewCreated(View paramView, Bundle paramBundle) {
    super.onViewCreated(paramView, paramBundle);
    a();
  }
  
  public final ListAdapter requireListAdapter() {
    ListAdapter listAdapter = getListAdapter();
    if (listAdapter != null)
      return listAdapter; 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("ListFragment ");
    stringBuilder.append(this);
    stringBuilder.append(" does not have a ListAdapter.");
    throw new IllegalStateException(stringBuilder.toString());
  }
  
  public void setEmptyText(CharSequence paramCharSequence) {
    a();
    TextView textView = this.d;
    if (textView != null) {
      textView.setText(paramCharSequence);
      if (this.g == null)
        this.b.setEmptyView((View)this.d); 
      this.g = paramCharSequence;
      return;
    } 
    throw new IllegalStateException("Can't be used with a custom content view");
  }
  
  public void setListAdapter(ListAdapter paramListAdapter) {
    boolean bool1;
    ListAdapter listAdapter = this.a;
    boolean bool2 = false;
    if (listAdapter != null) {
      bool1 = true;
    } else {
      bool1 = false;
    } 
    this.a = paramListAdapter;
    ListView listView = this.b;
    if (listView != null) {
      listView.setAdapter(paramListAdapter);
      if (!this.h && !bool1) {
        if (requireView().getWindowToken() != null)
          bool2 = true; 
        a(true, bool2);
      } 
    } 
  }
  
  public void setListShown(boolean paramBoolean) {
    a(paramBoolean, true);
  }
  
  public void setListShownNoAnimation(boolean paramBoolean) {
    a(paramBoolean, false);
  }
  
  public void setSelection(int paramInt) {
    a();
    this.b.setSelection(paramInt);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\androidx\fragment\app\ListFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */