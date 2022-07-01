package android.support.v7.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v7.appcompat.R;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;

public final class ToolbarWidgetWrapper implements DecorToolbar {
  private View mCustomView;
  
  private int mDefaultNavigationContentDescription = 0;
  
  private Drawable mDefaultNavigationIcon;
  
  private int mDisplayOpts;
  
  private CharSequence mHomeDescription;
  
  private Drawable mIcon;
  
  private Drawable mLogo;
  
  boolean mMenuPrepared;
  
  private Drawable mNavIcon;
  
  private CharSequence mSubtitle;
  
  CharSequence mTitle;
  
  Toolbar mToolbar;
  
  Window.Callback mWindowCallback;
  
  public ToolbarWidgetWrapper(Toolbar paramToolbar, boolean paramBoolean) {
    this(paramToolbar, paramBoolean, R.string.abc_action_bar_up_description);
  }
  
  private ToolbarWidgetWrapper(Toolbar paramToolbar, boolean paramBoolean, int paramInt) {
    this.mToolbar = paramToolbar;
    this.mTitle = paramToolbar.mTitleText;
    this.mSubtitle = paramToolbar.mSubtitleText;
    this.mNavIcon = paramToolbar.getNavigationIcon();
    Context context = paramToolbar.getContext();
    int[] arrayOfInt = R.styleable.ActionBar;
    int i = R.attr.actionBarStyle;
    paramToolbar = null;
    TintTypedArray tintTypedArray = TintTypedArray.obtainStyledAttributes(context, null, arrayOfInt, i, 0);
    this.mDefaultNavigationIcon = tintTypedArray.getDrawable(R.styleable.ActionBar_homeAsUpIndicator);
    if (paramBoolean) {
      CharSequence charSequence = tintTypedArray.getText(R.styleable.ActionBar_title);
      if (!TextUtils.isEmpty(charSequence)) {
        this.mTitle = charSequence;
        if ((this.mDisplayOpts & 0x8) != 0)
          this.mToolbar.setTitle(charSequence); 
      } 
      charSequence = tintTypedArray.getText(R.styleable.ActionBar_subtitle);
      if (!TextUtils.isEmpty(charSequence)) {
        this.mSubtitle = charSequence;
        if ((this.mDisplayOpts & 0x8) != 0)
          this.mToolbar.setSubtitle(charSequence); 
      } 
      Drawable drawable = tintTypedArray.getDrawable(R.styleable.ActionBar_logo);
      if (drawable != null) {
        this.mLogo = drawable;
        updateToolbarLogo();
      } 
      drawable = tintTypedArray.getDrawable(R.styleable.ActionBar_icon);
      if (drawable != null) {
        this.mIcon = drawable;
        updateToolbarLogo();
      } 
      if (this.mNavIcon == null && this.mDefaultNavigationIcon != null) {
        this.mNavIcon = this.mDefaultNavigationIcon;
        updateNavigationIcon();
      } 
      setDisplayOptions(tintTypedArray.getInt(R.styleable.ActionBar_displayOptions, 0));
      i = tintTypedArray.getResourceId(R.styleable.ActionBar_customNavigationLayout, 0);
      if (i != 0) {
        View view = LayoutInflater.from(this.mToolbar.getContext()).inflate(i, this.mToolbar, false);
        if (this.mCustomView != null && (this.mDisplayOpts & 0x10) != 0)
          this.mToolbar.removeView(this.mCustomView); 
        this.mCustomView = view;
        if (view != null && (this.mDisplayOpts & 0x10) != 0)
          this.mToolbar.addView(this.mCustomView); 
        setDisplayOptions(this.mDisplayOpts | 0x10);
      } 
      i = tintTypedArray.getLayoutDimension(R.styleable.ActionBar_height, 0);
      if (i > 0) {
        ViewGroup.LayoutParams layoutParams = this.mToolbar.getLayoutParams();
        layoutParams.height = i;
        this.mToolbar.setLayoutParams(layoutParams);
      } 
      int j = tintTypedArray.getDimensionPixelOffset(R.styleable.ActionBar_contentInsetStart, -1);
      i = tintTypedArray.getDimensionPixelOffset(R.styleable.ActionBar_contentInsetEnd, -1);
      if (j >= 0 || i >= 0) {
        Toolbar toolbar = this.mToolbar;
        j = Math.max(j, 0);
        i = Math.max(i, 0);
        toolbar.ensureContentInsets();
        toolbar.mContentInsets.setRelative(j, i);
      } 
      i = tintTypedArray.getResourceId(R.styleable.ActionBar_titleTextStyle, 0);
      if (i != 0) {
        Toolbar toolbar = this.mToolbar;
        Context context1 = this.mToolbar.getContext();
        toolbar.mTitleTextAppearance = i;
        if (toolbar.mTitleTextView != null)
          toolbar.mTitleTextView.setTextAppearance(context1, i); 
      } 
      i = tintTypedArray.getResourceId(R.styleable.ActionBar_subtitleTextStyle, 0);
      if (i != 0) {
        Toolbar toolbar = this.mToolbar;
        Context context1 = this.mToolbar.getContext();
        toolbar.mSubtitleTextAppearance = i;
        if (toolbar.mSubtitleTextView != null)
          toolbar.mSubtitleTextView.setTextAppearance(context1, i); 
      } 
      i = tintTypedArray.getResourceId(R.styleable.ActionBar_popupTheme, 0);
      if (i != 0)
        this.mToolbar.setPopupTheme(i); 
    } else {
      i = 11;
      if (this.mToolbar.getNavigationIcon() != null) {
        i = 15;
        this.mDefaultNavigationIcon = this.mToolbar.getNavigationIcon();
      } 
      this.mDisplayOpts = i;
    } 
    tintTypedArray.mWrapped.recycle();
    if (paramInt != this.mDefaultNavigationContentDescription) {
      this.mDefaultNavigationContentDescription = paramInt;
      if (TextUtils.isEmpty(this.mToolbar.getNavigationContentDescription())) {
        String str;
        paramInt = this.mDefaultNavigationContentDescription;
        if (paramInt != 0)
          str = this.mToolbar.getContext().getString(paramInt); 
        this.mHomeDescription = str;
        updateHomeAccessibility();
      } 
    } 
    this.mHomeDescription = this.mToolbar.getNavigationContentDescription();
    this.mToolbar.setNavigationOnClickListener(new ToolbarWidgetWrapper$1(this));
  }
  
  private void setDisplayOptions(int paramInt) {
    int i = this.mDisplayOpts ^ paramInt;
    this.mDisplayOpts = paramInt;
    if (i != 0) {
      if ((i & 0x4) != 0) {
        if ((paramInt & 0x4) != 0)
          updateHomeAccessibility(); 
        updateNavigationIcon();
      } 
      if ((i & 0x3) != 0)
        updateToolbarLogo(); 
      if ((i & 0x8) != 0)
        if ((paramInt & 0x8) != 0) {
          this.mToolbar.setTitle(this.mTitle);
          this.mToolbar.setSubtitle(this.mSubtitle);
        } else {
          this.mToolbar.setTitle((CharSequence)null);
          this.mToolbar.setSubtitle((CharSequence)null);
        }  
      if ((i & 0x10) != 0 && this.mCustomView != null) {
        if ((paramInt & 0x10) != 0) {
          this.mToolbar.addView(this.mCustomView);
          return;
        } 
        this.mToolbar.removeView(this.mCustomView);
      } 
    } 
  }
  
  private void updateHomeAccessibility() {
    if ((this.mDisplayOpts & 0x4) != 0) {
      if (TextUtils.isEmpty(this.mHomeDescription)) {
        CharSequence charSequence;
        Toolbar toolbar = this.mToolbar;
        int i = this.mDefaultNavigationContentDescription;
        if (i != 0) {
          charSequence = toolbar.getContext().getText(i);
        } else {
          charSequence = null;
        } 
        toolbar.setNavigationContentDescription(charSequence);
        return;
      } 
      this.mToolbar.setNavigationContentDescription(this.mHomeDescription);
    } 
  }
  
  private void updateNavigationIcon() {
    if ((this.mDisplayOpts & 0x4) != 0) {
      Drawable drawable;
      Toolbar toolbar = this.mToolbar;
      if (this.mNavIcon != null) {
        drawable = this.mNavIcon;
      } else {
        drawable = this.mDefaultNavigationIcon;
      } 
      toolbar.setNavigationIcon(drawable);
      return;
    } 
    this.mToolbar.setNavigationIcon((Drawable)null);
  }
  
  private void updateToolbarLogo() {
    Drawable drawable;
    if ((this.mDisplayOpts & 0x2) != 0) {
      if ((this.mDisplayOpts & 0x1) != 0) {
        if (this.mLogo != null) {
          drawable = this.mLogo;
        } else {
          drawable = this.mIcon;
        } 
      } else {
        drawable = this.mIcon;
      } 
    } else {
      drawable = null;
    } 
    this.mToolbar.setLogo(drawable);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\android\support\v7\widget\ToolbarWidgetWrapper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */