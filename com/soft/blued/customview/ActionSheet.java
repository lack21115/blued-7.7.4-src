package com.soft.blued.customview;

import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.core.ui.StatusBarHelper;
import com.blued.android.core.utils.skin.BluedSkinUtils;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.framework.view.shape.ShapeHelper;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.soft.blued.R;
import com.soft.blued.utils.BluedPreferences;
import com.soft.blued.utils.Logger;
import org.xmlpull.v1.XmlPullParser;

public class ActionSheet extends BaseFragment implements View.OnClickListener {
  private boolean d = true;
  
  private ActionSheetListener e;
  
  private View f;
  
  private LinearLayout g;
  
  private ViewGroup h;
  
  private View i;
  
  private Attributes j;
  
  private boolean k = true;
  
  private boolean l = false;
  
  private LayoutInflater m;
  
  private View a(String paramString, int paramInt, boolean paramBoolean) {
    View view = this.m.inflate((XmlPullParser)getResources().getLayout(2131493410), null);
    view.setId(paramInt + 100 + 1);
    view.setOnClickListener(this);
    if (paramInt == 0)
      ShapeHelper.a((ShapeHelper.ShapeView)view.findViewById(2131296408), DensityUtils.a(getContext(), 10.0F), DensityUtils.a(getContext(), 10.0F), 0.0F, 0.0F); 
    TextView textView1 = (TextView)view.findViewById(2131301377);
    textView1.setText(paramString);
    ImageView imageView1 = (ImageView)view.findViewById(2131297452);
    ImageView imageView2 = (ImageView)view.findViewById(2131297453);
    ImageView imageView3 = (ImageView)view.findViewById(2131297581);
    TextView textView2 = (TextView)view.findViewById(2131297546);
    ImageView imageView4 = (ImageView)view.findViewById(2131297480);
    if (paramBoolean) {
      LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams)textView1.getLayoutParams();
      layoutParams.setMargins(imageView1.getMeasuredWidth(), 0, 0, 0);
      textView1.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
      imageView1.setVisibility(0);
      imageView2.setVisibility(4);
    } else {
      imageView1.setVisibility(8);
      imageView2.setVisibility(8);
    } 
    if (!TextUtils.isEmpty(x())) {
      textView1.setTextColor(Color.parseColor(x()));
    } else {
      textView1.setTextColor(BluedSkinUtils.a(getContext(), 2131100838));
    } 
    if (getString(2131758909).equalsIgnoreCase(paramString)) {
      imageView3.setVisibility(0);
      return view;
    } 
    if (getString(2131756224).equalsIgnoreCase(paramString)) {
      imageView3.setVisibility(0);
      return view;
    } 
    if (getString(2131756223).equalsIgnoreCase(paramString)) {
      imageView3.setVisibility(0);
      return view;
    } 
    if (getString(2131755731).equalsIgnoreCase(paramString)) {
      imageView3.setVisibility(0);
      return view;
    } 
    if (getString(2131758011).equalsIgnoreCase(paramString)) {
      imageView3.setVisibility(0);
      imageView3.setImageResource(2131232731);
      return view;
    } 
    if (getString(2131756452).equals(paramString)) {
      imageView4.setVisibility(0);
      return view;
    } 
    if (getString(2131758442).equalsIgnoreCase(paramString)) {
      imageView3.setVisibility(0);
      return view;
    } 
    if (getString(2131756150).equalsIgnoreCase(paramString)) {
      if (!BluedPreferences.dt())
        textView2.setVisibility(0); 
      imageView3.setVisibility(0);
      return view;
    } 
    if (getString(2131759217).equalsIgnoreCase(paramString))
      imageView3.setVisibility(0); 
    return view;
  }
  
  public static Builder a(Context paramContext, FragmentManager paramFragmentManager) {
    return new Builder(paramContext, paramFragmentManager);
  }
  
  private Animation k() {
    TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, 1.0F, 1, 0.0F);
    translateAnimation.setDuration(200L);
    return (Animation)translateAnimation;
  }
  
  private Animation l() {
    AlphaAnimation alphaAnimation = new AlphaAnimation(0.0F, 1.0F);
    alphaAnimation.setDuration(300L);
    return (Animation)alphaAnimation;
  }
  
  private Animation m() {
    TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, 0.0F, 1, 1.0F);
    translateAnimation.setDuration(200L);
    translateAnimation.setFillAfter(true);
    return (Animation)translateAnimation;
  }
  
  private Animation n() {
    AlphaAnimation alphaAnimation = new AlphaAnimation(1.0F, 0.0F);
    alphaAnimation.setDuration(300L);
    alphaAnimation.setFillAfter(true);
    return (Animation)alphaAnimation;
  }
  
  private View o() {
    FrameLayout frameLayout = new FrameLayout((Context)getActivity());
    frameLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
    this.i = new View((Context)getActivity());
    this.i.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
    this.i.setBackgroundColor(Color.argb(136, 0, 0, 0));
    this.i.setId(10);
    this.i.setOnClickListener(this);
    this.g = new LinearLayout((Context)getActivity());
    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
    layoutParams.gravity = 80;
    layoutParams.bottomMargin = StatusBarHelper.b((Activity)getActivity());
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("bottomMargin===");
    stringBuilder.append(layoutParams.bottomMargin);
    Logger.e("ActionSheet", new Object[] { stringBuilder.toString() });
    this.g.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
    this.g.setOrientation(1);
    frameLayout.addView(this.i);
    frameLayout.addView((View)this.g);
    return (View)frameLayout;
  }
  
  private void p() {
    q();
    View view = new View(getContext());
    view.setLayoutParams(new ViewGroup.LayoutParams(-1, this.j.k));
    view.setBackgroundColor(BluedSkinUtils.a(getContext(), 2131100881));
    this.g.addView(view);
    ShapeTextView shapeTextView = new ShapeTextView((Context)getActivity());
    shapeTextView.setTextSize(0, this.j.m);
    shapeTextView.setId(100);
    ShapeHelper.b((ShapeHelper.ShapeView)shapeTextView, 2131100728);
    ShapeHelper.c((ShapeHelper.ShapeView)shapeTextView, 2131100733);
    shapeTextView.setText(t());
    shapeTextView.setTextColor(BluedSkinUtils.a(getContext(), 2131100838));
    shapeTextView.setGravity(17);
    shapeTextView.setOnClickListener(this);
    LinearLayout.LayoutParams layoutParams = r();
    layoutParams.height = this.j.l;
    this.g.addView((View)shapeTextView, (ViewGroup.LayoutParams)layoutParams);
  }
  
  private void q() {
    String[] arrayOfString = u();
    int i = w();
    if (arrayOfString != null)
      for (int j = 0; j < arrayOfString.length; j++) {
        boolean bool;
        String str = arrayOfString[j];
        if (i < arrayOfString.length && i >= 0 && j == i) {
          bool = true;
        } else {
          bool = false;
        } 
        View view = a(str, j, bool);
        this.g.addView(view);
      }  
  }
  
  private LinearLayout.LayoutParams r() {
    return new LinearLayout.LayoutParams(-1, -2);
  }
  
  private Attributes s() {
    Attributes attributes = new Attributes((Context)getActivity());
    TypedArray typedArray = getActivity().getTheme().obtainStyledAttributes(null, R.styleable.ActionSheet, 2130968611, 0);
    Drawable drawable = typedArray.getDrawable(0);
    if (drawable != null)
      attributes.a = drawable; 
    drawable = typedArray.getDrawable(3);
    if (drawable != null)
      attributes.b = drawable; 
    drawable = typedArray.getDrawable(11);
    if (drawable != null)
      attributes.c = drawable; 
    drawable = typedArray.getDrawable(7);
    if (drawable != null)
      attributes.d = drawable; 
    drawable = typedArray.getDrawable(6);
    if (drawable != null)
      attributes.e = drawable; 
    drawable = typedArray.getDrawable(8);
    if (drawable != null)
      attributes.f = drawable; 
    attributes.g = typedArray.getColor(5, attributes.g);
    attributes.h = typedArray.getColor(10, attributes.h);
    attributes.i = (int)typedArray.getDimension(1, attributes.i);
    attributes.j = (int)typedArray.getDimension(9, attributes.j);
    attributes.k = (int)typedArray.getDimension(4, attributes.k);
    attributes.m = typedArray.getDimensionPixelSize(2, (int)attributes.m);
    typedArray.recycle();
    return attributes;
  }
  
  private String t() {
    return getArguments().getString("cancel_button_title");
  }
  
  private String[] u() {
    return getArguments().getStringArray("other_button_titles");
  }
  
  private boolean v() {
    return getArguments().getBoolean("cancelable_ontouchoutside");
  }
  
  private int w() {
    return getArguments().getInt("arg_selected_index");
  }
  
  private String x() {
    return getArguments().getString("text_color");
  }
  
  public String a(int paramInt) {
    String[] arrayOfString = u();
    return (paramInt < arrayOfString.length) ? arrayOfString[paramInt] : "";
  }
  
  public void a() {
    if (this.d)
      return; 
    this.d = true;
    try {
      if (getFragmentManager() != null) {
        getFragmentManager().popBackStack();
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.remove((Fragment)this);
        fragmentTransaction.commit();
      } 
    } catch (IllegalStateException illegalStateException) {
      illegalStateException.printStackTrace();
    } 
    this.l = false;
  }
  
  public void a(FragmentManager paramFragmentManager, String paramString) {
    if (!this.d)
      return; 
    this.d = false;
    FragmentTransaction fragmentTransaction = paramFragmentManager.beginTransaction();
    fragmentTransaction.add((Fragment)this, paramString);
    fragmentTransaction.addToBackStack(null);
    fragmentTransaction.commitAllowingStateLoss();
  }
  
  public void a(ActionSheetListener paramActionSheetListener) {
    this.e = paramActionSheetListener;
  }
  
  public void onClick(View paramView) {
    a();
    if (paramView.getId() == 10 && !v())
      return; 
    if (!this.l) {
      this.l = true;
      if (paramView.getId() != 100 && paramView.getId() != 10) {
        ActionSheetListener actionSheetListener = this.e;
        if (actionSheetListener != null)
          actionSheetListener.a(this, paramView.getId() - 100 - 1); 
        this.k = false;
      } 
    } 
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
    this.m = paramLayoutInflater;
    InputMethodManager inputMethodManager = (InputMethodManager)getActivity().getSystemService("input_method");
    if (inputMethodManager.isActive()) {
      View view = getActivity().getCurrentFocus();
      if (view != null)
        inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0); 
    } 
    this.j = s();
    this.f = o();
    ViewGroup viewGroup = (ViewGroup)getActivity().getWindow().getDecorView();
    try {
      this.h = (ViewGroup)((ViewGroup)viewGroup.getChildAt(0)).getChildAt(1);
    } catch (Exception exception) {
      this.h = null;
    } 
    if (this.h == null)
      this.h = viewGroup; 
    p();
    this.h.addView(this.f);
    this.i.startAnimation(l());
    this.g.startAnimation(k());
    return super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
  }
  
  public void onDestroyView() {
    this.g.startAnimation(m());
    this.i.startAnimation(n());
    this.f.postDelayed(new Runnable(this) {
          public void run() {
            ActionSheet.b(this.a).removeView(ActionSheet.a(this.a));
          }
        },  300L);
    ActionSheetListener actionSheetListener = this.e;
    if (actionSheetListener != null)
      actionSheetListener.a(this, this.k); 
    super.onDestroyView();
  }
  
  public static interface ActionSheetListener {
    void a(ActionSheet param1ActionSheet, int param1Int);
    
    void a(ActionSheet param1ActionSheet, boolean param1Boolean);
  }
  
  static class Attributes {
    Drawable a;
    
    Drawable b;
    
    Drawable c;
    
    Drawable d;
    
    Drawable e;
    
    Drawable f;
    
    int g;
    
    int h;
    
    int i;
    
    int j;
    
    int k;
    
    int l;
    
    float m;
    
    private Context n;
    
    public Attributes(Context param1Context) {
      this.n = param1Context;
      this.a = (Drawable)new ColorDrawable(0);
      this.b = (Drawable)new ColorDrawable(-16777216);
      ColorDrawable colorDrawable = new ColorDrawable(-7829368);
      this.c = (Drawable)colorDrawable;
      this.d = (Drawable)colorDrawable;
      this.e = (Drawable)colorDrawable;
      this.f = (Drawable)colorDrawable;
      this.g = -1;
      this.h = -16777216;
      this.i = a(20);
      this.j = a(2);
      this.k = a(6);
      this.l = a(52);
      this.m = a(16);
    }
    
    private int a(int param1Int) {
      return (int)TypedValue.applyDimension(1, param1Int, this.n.getResources().getDisplayMetrics());
    }
  }
  
  public static class Builder {
    private Context a;
    
    private FragmentManager b;
    
    private String c;
    
    private String[] d;
    
    private String e = "actionSheet";
    
    private boolean f;
    
    private ActionSheet.ActionSheetListener g;
    
    private int h = -1;
    
    private String i;
    
    public Builder(Context param1Context, FragmentManager param1FragmentManager) {
      this.a = param1Context;
      this.b = param1FragmentManager;
    }
    
    public Bundle a() {
      Bundle bundle = new Bundle();
      bundle.putString("cancel_button_title", this.c);
      bundle.putStringArray("other_button_titles", this.d);
      bundle.putBoolean("cancelable_ontouchoutside", this.f);
      bundle.putInt("arg_selected_index", this.h);
      bundle.putString("text_color", this.i);
      return bundle;
    }
    
    public Builder a(int param1Int) {
      this.h = param1Int;
      return this;
    }
    
    public Builder a(ActionSheet.ActionSheetListener param1ActionSheetListener) {
      this.g = param1ActionSheetListener;
      return this;
    }
    
    public Builder a(String param1String) {
      this.c = param1String;
      return this;
    }
    
    public Builder a(boolean param1Boolean) {
      this.f = param1Boolean;
      return this;
    }
    
    public Builder a(String... param1VarArgs) {
      this.d = param1VarArgs;
      return this;
    }
    
    public Builder b(String param1String) {
      this.i = param1String;
      return this;
    }
    
    public ActionSheet b() {
      ActionSheet actionSheet = (ActionSheet)Fragment.instantiate(this.a, ActionSheet.class.getName(), a());
      actionSheet.a(this.g);
      actionSheet.a(this.b, this.e);
      return actionSheet;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blued\customview\ActionSheet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */