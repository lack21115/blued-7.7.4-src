package com.blued.android.module.media.selector.view;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
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
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.blued.android.core.ui.StatusBarHelper;
import com.blued.android.module.media.selector.R;
import org.xmlpull.v1.XmlPullParser;

public class ActionSheet extends Fragment implements View.OnClickListener {
  private boolean a = true;
  
  private ActionSheetListener b;
  
  private View c;
  
  private LinearLayout d;
  
  private ViewGroup e;
  
  private View f;
  
  private Attributes g;
  
  private boolean h = true;
  
  private boolean i = false;
  
  private LayoutInflater j;
  
  public static Builder a(Context paramContext, FragmentManager paramFragmentManager) {
    return new Builder(paramContext, paramFragmentManager);
  }
  
  private Animation d() {
    TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, 1.0F, 1, 0.0F);
    translateAnimation.setDuration(200L);
    return (Animation)translateAnimation;
  }
  
  private Animation e() {
    AlphaAnimation alphaAnimation = new AlphaAnimation(0.0F, 1.0F);
    alphaAnimation.setDuration(300L);
    return (Animation)alphaAnimation;
  }
  
  private Animation f() {
    TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, 0.0F, 1, 1.0F);
    translateAnimation.setDuration(200L);
    translateAnimation.setFillAfter(true);
    return (Animation)translateAnimation;
  }
  
  private Animation g() {
    AlphaAnimation alphaAnimation = new AlphaAnimation(1.0F, 0.0F);
    alphaAnimation.setDuration(300L);
    alphaAnimation.setFillAfter(true);
    return (Animation)alphaAnimation;
  }
  
  private View h() {
    FrameLayout frameLayout = new FrameLayout((Context)getActivity());
    frameLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
    this.f = new View((Context)getActivity());
    this.f.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
    this.f.setBackgroundColor(Color.argb(136, 0, 0, 0));
    this.f.setId(10);
    this.f.setOnClickListener(this);
    this.d = new LinearLayout((Context)getActivity());
    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
    layoutParams.gravity = 80;
    layoutParams.bottomMargin = StatusBarHelper.b(getActivity());
    this.d.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
    this.d.setOrientation(1);
    frameLayout.addView(this.f);
    frameLayout.addView((View)this.d);
    return (View)frameLayout;
  }
  
  private void i() {
    b();
    Button button = new Button((Context)getActivity());
    button.setTextSize(0, this.g.l);
    button.setId(100);
    button.setBackgroundDrawable(this.g.b);
    button.setText(k());
    button.setTextColor(getResources().getColor(R.color.pl_popitems_font_gray));
    button.setOnClickListener(this);
    LinearLayout.LayoutParams layoutParams = c();
    layoutParams.topMargin = this.g.k;
    this.d.addView((View)button, (ViewGroup.LayoutParams)layoutParams);
  }
  
  private Attributes j() {
    Attributes attributes = new Attributes((Context)getActivity());
    TypedArray typedArray = getActivity().getTheme().obtainStyledAttributes(null, R.styleable.ActionSheet, R.attr.actionSheetStyle, 0);
    Drawable drawable = typedArray.getDrawable(R.styleable.ActionSheet_actionSheetBackground);
    if (drawable != null)
      attributes.a = drawable; 
    drawable = typedArray.getDrawable(R.styleable.ActionSheet_cancelButtonBackground);
    if (drawable != null)
      attributes.b = drawable; 
    drawable = typedArray.getDrawable(R.styleable.ActionSheet_otherButtonTopBackground);
    if (drawable != null)
      attributes.c = drawable; 
    drawable = typedArray.getDrawable(R.styleable.ActionSheet_otherButtonMiddleBackground);
    if (drawable != null)
      attributes.d = drawable; 
    drawable = typedArray.getDrawable(R.styleable.ActionSheet_otherButtonBottomBackground);
    if (drawable != null)
      attributes.e = drawable; 
    drawable = typedArray.getDrawable(R.styleable.ActionSheet_otherButtonSingleBackground);
    if (drawable != null)
      attributes.f = drawable; 
    attributes.g = typedArray.getColor(R.styleable.ActionSheet_cancelButtonTextColor, attributes.g);
    attributes.h = typedArray.getColor(R.styleable.ActionSheet_otherButtonTextColor, attributes.h);
    attributes.i = (int)typedArray.getDimension(R.styleable.ActionSheet_actionSheetPadding, attributes.i);
    attributes.j = (int)typedArray.getDimension(R.styleable.ActionSheet_otherButtonSpacing, attributes.j);
    attributes.k = (int)typedArray.getDimension(R.styleable.ActionSheet_cancelButtonMarginTop, attributes.k);
    attributes.l = typedArray.getDimensionPixelSize(R.styleable.ActionSheet_actionSheetTextSize, (int)attributes.l);
    typedArray.recycle();
    return attributes;
  }
  
  private String k() {
    return getArguments().getString("cancel_button_title");
  }
  
  private String[] l() {
    return getArguments().getStringArray("other_button_titles");
  }
  
  private boolean m() {
    return getArguments().getBoolean("cancelable_ontouchoutside");
  }
  
  private int n() {
    return getArguments().getInt("arg_selected_index");
  }
  
  private String o() {
    return getArguments().getString("text_color");
  }
  
  public View a(String paramString, int paramInt, boolean paramBoolean) {
    View view = this.j.inflate((XmlPullParser)getResources().getLayout(R.layout.pl_item_actionsheet), null);
    view.setId(paramInt + 100 + 1);
    view.setOnClickListener(this);
    TextView textView = (TextView)view.findViewById(R.id.tv_text);
    textView.setText(paramString);
    ImageView imageView1 = (ImageView)view.findViewById(R.id.img_checked);
    ImageView imageView2 = (ImageView)view.findViewById(R.id.img_checked_invisible);
    ImageView imageView3 = (ImageView)view.findViewById(R.id.img_vip_icon);
    imageView3 = (ImageView)view.findViewById(R.id.img_feed);
    if (paramBoolean) {
      LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams)textView.getLayoutParams();
      layoutParams.setMargins(imageView1.getMeasuredWidth(), 0, 0, 0);
      textView.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
      imageView1.setVisibility(0);
      imageView2.setVisibility(4);
    } else {
      imageView1.setVisibility(8);
      imageView2.setVisibility(8);
    } 
    if (!TextUtils.isEmpty(o())) {
      textView.setTextColor(Color.parseColor(o()));
      return view;
    } 
    textView.setTextColor(getResources().getColor(R.color.pl_sara_c));
    return view;
  }
  
  public void a() {
    if (this.a)
      return; 
    this.a = true;
    try {
      if (getFragmentManager() != null) {
        getFragmentManager().popBackStack();
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.remove(this);
        fragmentTransaction.commit();
      } 
    } catch (IllegalStateException illegalStateException) {
      illegalStateException.printStackTrace();
    } 
    this.i = false;
  }
  
  public void a(FragmentManager paramFragmentManager, String paramString) {
    if (!this.a)
      return; 
    this.a = false;
    FragmentTransaction fragmentTransaction = paramFragmentManager.beginTransaction();
    fragmentTransaction.add(this, paramString);
    fragmentTransaction.addToBackStack(null);
    fragmentTransaction.commitAllowingStateLoss();
  }
  
  public void a(ActionSheetListener paramActionSheetListener) {
    this.b = paramActionSheetListener;
  }
  
  public void b() {
    String[] arrayOfString = l();
    int i = n();
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
        this.d.addView(view);
      }  
  }
  
  public LinearLayout.LayoutParams c() {
    return new LinearLayout.LayoutParams(-1, -2);
  }
  
  public void onClick(View paramView) {
    a();
    if (paramView.getId() == 10 && !m())
      return; 
    if (!this.i) {
      this.i = true;
      if (paramView.getId() != 100 && paramView.getId() != 10) {
        ActionSheetListener actionSheetListener = this.b;
        if (actionSheetListener != null)
          actionSheetListener.a(this, paramView.getId() - 100 - 1); 
        this.h = false;
      } 
    } 
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
    this.j = paramLayoutInflater;
    InputMethodManager inputMethodManager = (InputMethodManager)getActivity().getSystemService("input_method");
    if (inputMethodManager.isActive()) {
      View view = getActivity().getCurrentFocus();
      if (view != null)
        inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0); 
    } 
    this.g = j();
    this.c = h();
    ViewGroup viewGroup = (ViewGroup)getActivity().getWindow().getDecorView();
    try {
      this.e = (ViewGroup)((ViewGroup)viewGroup.getChildAt(0)).getChildAt(1);
    } catch (NullPointerException nullPointerException) {
      this.e = null;
    } 
    if (this.e == null)
      this.e = viewGroup; 
    i();
    this.e.addView(this.c);
    this.f.startAnimation(e());
    this.d.startAnimation(d());
    return super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
  }
  
  public void onDestroyView() {
    this.d.startAnimation(f());
    this.f.startAnimation(g());
    this.c.postDelayed(new Runnable(this) {
          public void run() {
            ActionSheet.b(this.a).removeView(ActionSheet.a(this.a));
          }
        },  300L);
    ActionSheetListener actionSheetListener = this.b;
    if (actionSheetListener != null)
      actionSheetListener.a(this, this.h); 
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
    
    float l;
    
    private Context m;
    
    public Attributes(Context param1Context) {
      this.m = param1Context;
      this.a = (Drawable)new ColorDrawable(0);
      this.b = (Drawable)new ColorDrawable(-16777216);
      ColorDrawable colorDrawable = new ColorDrawable(-7829368);
      this.b = (Drawable)colorDrawable;
      this.c = (Drawable)colorDrawable;
      this.d = (Drawable)colorDrawable;
      this.e = (Drawable)colorDrawable;
      this.f = (Drawable)colorDrawable;
      this.g = -1;
      this.h = -16777216;
      this.i = a(20);
      this.j = a(2);
      this.k = a(1);
      this.l = a(15);
    }
    
    private int a(int param1Int) {
      return (int)TypedValue.applyDimension(1, param1Int, this.m.getResources().getDisplayMetrics());
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


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\media\selector\view\ActionSheet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */