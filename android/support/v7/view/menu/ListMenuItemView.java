package android.support.v7.view.menu;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.view.ViewCompat;
import android.support.v7.appcompat.R;
import android.support.v7.widget.TintTypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;

public class ListMenuItemView extends LinearLayout implements MenuView$ItemView {
  private Drawable mBackground;
  
  private CheckBox mCheckBox;
  
  boolean mForceShowIcon;
  
  private ImageView mIconView;
  
  private LayoutInflater mInflater;
  
  public MenuItemImpl mItemData;
  
  boolean mPreserveIconSpacing;
  
  private RadioButton mRadioButton;
  
  private TextView mShortcutView;
  
  private Drawable mSubMenuArrow;
  
  private ImageView mSubMenuArrowView;
  
  private int mTextAppearance;
  
  private Context mTextAppearanceContext;
  
  private TextView mTitleView;
  
  public ListMenuItemView(Context paramContext, AttributeSet paramAttributeSet) {
    this(paramContext, paramAttributeSet, R.attr.listMenuViewStyle);
  }
  
  public ListMenuItemView(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet);
    TintTypedArray tintTypedArray = TintTypedArray.obtainStyledAttributes(getContext(), paramAttributeSet, R.styleable.MenuView, paramInt, 0);
    this.mBackground = tintTypedArray.getDrawable(R.styleable.MenuView_android_itemBackground);
    this.mTextAppearance = tintTypedArray.getResourceId(R.styleable.MenuView_android_itemTextAppearance, -1);
    this.mPreserveIconSpacing = tintTypedArray.getBoolean(R.styleable.MenuView_preserveIconSpacing, false);
    this.mTextAppearanceContext = paramContext;
    this.mSubMenuArrow = tintTypedArray.getDrawable(R.styleable.MenuView_subMenuArrow);
    tintTypedArray.mWrapped.recycle();
  }
  
  private LayoutInflater getInflater() {
    if (this.mInflater == null)
      this.mInflater = LayoutInflater.from(getContext()); 
    return this.mInflater;
  }
  
  public final MenuItemImpl getItemData() {
    return this.mItemData;
  }
  
  public final void initialize$667f453d(MenuItemImpl paramMenuItemImpl) {
    byte b;
    this.mItemData = paramMenuItemImpl;
    boolean bool1 = paramMenuItemImpl.isVisible();
    boolean bool = false;
    if (bool1) {
      b = 0;
    } else {
      b = 8;
    } 
    setVisibility(b);
    CharSequence charSequence = paramMenuItemImpl.getTitleForItemView(this);
    if (charSequence != null) {
      this.mTitleView.setText(charSequence);
      if (this.mTitleView.getVisibility() != 0)
        this.mTitleView.setVisibility(0); 
    } else if (this.mTitleView.getVisibility() != 8) {
      this.mTitleView.setVisibility(8);
    } 
    bool1 = paramMenuItemImpl.isCheckable();
    if (bool1 || this.mRadioButton != null || this.mCheckBox != null) {
      CheckBox checkBox;
      RadioButton radioButton;
      if (this.mItemData.isExclusiveCheckable()) {
        if (this.mRadioButton == null) {
          this.mRadioButton = (RadioButton)getInflater().inflate(R.layout.abc_list_menu_item_radio, (ViewGroup)this, false);
          addView((View)this.mRadioButton);
        } 
        RadioButton radioButton1 = this.mRadioButton;
        CheckBox checkBox1 = this.mCheckBox;
      } else {
        if (this.mCheckBox == null) {
          this.mCheckBox = (CheckBox)getInflater().inflate(R.layout.abc_list_menu_item_checkbox, (ViewGroup)this, false);
          addView((View)this.mCheckBox);
        } 
        checkBox = this.mCheckBox;
        radioButton = this.mRadioButton;
      } 
      if (bool1) {
        checkBox.setChecked(this.mItemData.isChecked());
        if (bool1) {
          b = 0;
        } else {
          b = 8;
        } 
        if (checkBox.getVisibility() != b)
          checkBox.setVisibility(b); 
        if (radioButton != null && radioButton.getVisibility() != 8)
          radioButton.setVisibility(8); 
      } else {
        if (this.mCheckBox != null)
          this.mCheckBox.setVisibility(8); 
        if (this.mRadioButton != null)
          this.mRadioButton.setVisibility(8); 
      } 
    } 
    bool1 = paramMenuItemImpl.shouldShowShortcut();
    paramMenuItemImpl.getShortcut();
    if (bool1 && this.mItemData.shouldShowShortcut()) {
      b = 0;
    } else {
      b = 8;
    } 
    if (b == 0) {
      TextView textView = this.mShortcutView;
      char c = this.mItemData.getShortcut();
      if (c == '\000') {
        charSequence = "";
      } else {
        charSequence = new StringBuilder(MenuItemImpl.sPrependShortcutLabel);
        if (c != '\b') {
          if (c != '\n') {
            if (c != ' ') {
              charSequence.append(c);
            } else {
              charSequence.append(MenuItemImpl.sSpaceShortcutLabel);
            } 
          } else {
            charSequence.append(MenuItemImpl.sEnterShortcutLabel);
          } 
        } else {
          charSequence.append(MenuItemImpl.sDeleteShortcutLabel);
        } 
        charSequence = charSequence.toString();
      } 
      textView.setText(charSequence);
    } 
    if (this.mShortcutView.getVisibility() != b)
      this.mShortcutView.setVisibility(b); 
    Drawable drawable = paramMenuItemImpl.getIcon();
    if (this.mItemData.mMenu.mOptionalIconsVisible || this.mForceShowIcon) {
      b = 1;
    } else {
      b = 0;
    } 
    if ((b != 0 || this.mPreserveIconSpacing) && (this.mIconView != null || drawable != null || this.mPreserveIconSpacing)) {
      if (this.mIconView == null) {
        this.mIconView = (ImageView)getInflater().inflate(R.layout.abc_list_menu_item_icon, (ViewGroup)this, false);
        addView((View)this.mIconView, 0);
      } 
      if (drawable != null || this.mPreserveIconSpacing) {
        ImageView imageView = this.mIconView;
        if (b == 0)
          drawable = null; 
        imageView.setImageDrawable(drawable);
        if (this.mIconView.getVisibility() != 0)
          this.mIconView.setVisibility(0); 
      } else {
        this.mIconView.setVisibility(8);
      } 
    } 
    setEnabled(paramMenuItemImpl.isEnabled());
    bool1 = paramMenuItemImpl.hasSubMenu();
    if (this.mSubMenuArrowView != null) {
      ImageView imageView = this.mSubMenuArrowView;
      if (bool1) {
        b = bool;
      } else {
        b = 8;
      } 
      imageView.setVisibility(b);
    } 
    setContentDescription(paramMenuItemImpl.getContentDescription());
  }
  
  protected void onFinishInflate() {
    super.onFinishInflate();
    ViewCompat.setBackground((View)this, this.mBackground);
    this.mTitleView = (TextView)findViewById(R.id.title);
    if (this.mTextAppearance != -1)
      this.mTitleView.setTextAppearance(this.mTextAppearanceContext, this.mTextAppearance); 
    this.mShortcutView = (TextView)findViewById(R.id.shortcut);
    this.mSubMenuArrowView = (ImageView)findViewById(R.id.submenuarrow);
    if (this.mSubMenuArrowView != null)
      this.mSubMenuArrowView.setImageDrawable(this.mSubMenuArrow); 
  }
  
  protected void onMeasure(int paramInt1, int paramInt2) {
    if (this.mIconView != null && this.mPreserveIconSpacing) {
      ViewGroup.LayoutParams layoutParams = getLayoutParams();
      LinearLayout.LayoutParams layoutParams1 = (LinearLayout.LayoutParams)this.mIconView.getLayoutParams();
      if (layoutParams.height > 0 && layoutParams1.width <= 0)
        layoutParams1.width = layoutParams.height; 
    } 
    super.onMeasure(paramInt1, paramInt2);
  }
  
  public final boolean prefersCondensedTitle() {
    return false;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\android\support\v7\view\menu\ListMenuItemView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */