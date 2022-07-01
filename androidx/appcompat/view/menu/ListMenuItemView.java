package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import androidx.appcompat.R;
import androidx.appcompat.widget.TintTypedArray;
import androidx.core.view.ViewCompat;

public class ListMenuItemView extends LinearLayout implements AbsListView.SelectionBoundsAdjuster, MenuView.ItemView {
  private MenuItemImpl a;
  
  private ImageView b;
  
  private RadioButton c;
  
  private TextView d;
  
  private CheckBox e;
  
  private TextView f;
  
  private ImageView g;
  
  private ImageView h;
  
  private LinearLayout i;
  
  private Drawable j;
  
  private int k;
  
  private Context l;
  
  private boolean m;
  
  private Drawable n;
  
  private boolean o;
  
  private int p;
  
  private LayoutInflater q;
  
  private boolean r;
  
  public ListMenuItemView(Context paramContext, AttributeSet paramAttributeSet) {
    this(paramContext, paramAttributeSet, R.attr.listMenuViewStyle);
  }
  
  public ListMenuItemView(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet);
    TintTypedArray tintTypedArray = TintTypedArray.obtainStyledAttributes(getContext(), paramAttributeSet, R.styleable.MenuView, paramInt, 0);
    this.j = tintTypedArray.getDrawable(R.styleable.MenuView_android_itemBackground);
    this.k = tintTypedArray.getResourceId(R.styleable.MenuView_android_itemTextAppearance, -1);
    this.m = tintTypedArray.getBoolean(R.styleable.MenuView_preserveIconSpacing, false);
    this.l = paramContext;
    this.n = tintTypedArray.getDrawable(R.styleable.MenuView_subMenuArrow);
    Resources.Theme theme = paramContext.getTheme();
    paramInt = R.attr.dropDownListViewStyle;
    TypedArray typedArray = theme.obtainStyledAttributes(null, new int[] { 16843049 }, paramInt, 0);
    this.o = typedArray.hasValue(0);
    tintTypedArray.recycle();
    typedArray.recycle();
  }
  
  private void a() {
    this.b = (ImageView)getInflater().inflate(R.layout.abc_list_menu_item_icon, (ViewGroup)this, false);
    a((View)this.b, 0);
  }
  
  private void a(View paramView) {
    a(paramView, -1);
  }
  
  private void a(View paramView, int paramInt) {
    LinearLayout linearLayout = this.i;
    if (linearLayout != null) {
      linearLayout.addView(paramView, paramInt);
      return;
    } 
    addView(paramView, paramInt);
  }
  
  private void b() {
    this.c = (RadioButton)getInflater().inflate(R.layout.abc_list_menu_item_radio, (ViewGroup)this, false);
    a((View)this.c);
  }
  
  private void c() {
    this.e = (CheckBox)getInflater().inflate(R.layout.abc_list_menu_item_checkbox, (ViewGroup)this, false);
    a((View)this.e);
  }
  
  private LayoutInflater getInflater() {
    if (this.q == null)
      this.q = LayoutInflater.from(getContext()); 
    return this.q;
  }
  
  private void setSubMenuArrowVisible(boolean paramBoolean) {
    ImageView imageView = this.g;
    if (imageView != null) {
      byte b;
      if (paramBoolean) {
        b = 0;
      } else {
        b = 8;
      } 
      imageView.setVisibility(b);
    } 
  }
  
  public void adjustListItemSelectionBounds(Rect paramRect) {
    ImageView imageView = this.h;
    if (imageView != null && imageView.getVisibility() == 0) {
      LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams)this.h.getLayoutParams();
      paramRect.top += this.h.getHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
    } 
  }
  
  public MenuItemImpl getItemData() {
    return this.a;
  }
  
  public void initialize(MenuItemImpl paramMenuItemImpl, int paramInt) {
    this.a = paramMenuItemImpl;
    this.p = paramInt;
    if (paramMenuItemImpl.isVisible()) {
      paramInt = 0;
    } else {
      paramInt = 8;
    } 
    setVisibility(paramInt);
    setTitle(paramMenuItemImpl.a(this));
    setCheckable(paramMenuItemImpl.isCheckable());
    setShortcut(paramMenuItemImpl.c(), paramMenuItemImpl.a());
    setIcon(paramMenuItemImpl.getIcon());
    setEnabled(paramMenuItemImpl.isEnabled());
    setSubMenuArrowVisible(paramMenuItemImpl.hasSubMenu());
    setContentDescription(paramMenuItemImpl.getContentDescription());
  }
  
  protected void onFinishInflate() {
    super.onFinishInflate();
    ViewCompat.setBackground((View)this, this.j);
    this.d = (TextView)findViewById(R.id.title);
    int i = this.k;
    if (i != -1)
      this.d.setTextAppearance(this.l, i); 
    this.f = (TextView)findViewById(R.id.shortcut);
    this.g = (ImageView)findViewById(R.id.submenuarrow);
    ImageView imageView = this.g;
    if (imageView != null)
      imageView.setImageDrawable(this.n); 
    this.h = (ImageView)findViewById(R.id.group_divider);
    this.i = (LinearLayout)findViewById(R.id.content);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2) {
    if (this.b != null && this.m) {
      ViewGroup.LayoutParams layoutParams = getLayoutParams();
      LinearLayout.LayoutParams layoutParams1 = (LinearLayout.LayoutParams)this.b.getLayoutParams();
      if (layoutParams.height > 0 && layoutParams1.width <= 0)
        layoutParams1.width = layoutParams.height; 
    } 
    super.onMeasure(paramInt1, paramInt2);
  }
  
  public boolean prefersCondensedTitle() {
    return false;
  }
  
  public void setCheckable(boolean paramBoolean) {
    CheckBox checkBox;
    RadioButton radioButton;
    if (!paramBoolean && this.c == null && this.e == null)
      return; 
    if (this.a.isExclusiveCheckable()) {
      if (this.c == null)
        b(); 
      RadioButton radioButton1 = this.c;
      CheckBox checkBox1 = this.e;
    } else {
      if (this.e == null)
        c(); 
      checkBox = this.e;
      radioButton = this.c;
    } 
    if (paramBoolean) {
      checkBox.setChecked(this.a.isChecked());
      if (checkBox.getVisibility() != 0)
        checkBox.setVisibility(0); 
      if (radioButton != null && radioButton.getVisibility() != 8) {
        radioButton.setVisibility(8);
        return;
      } 
    } else {
      checkBox = this.e;
      if (checkBox != null)
        checkBox.setVisibility(8); 
      RadioButton radioButton1 = this.c;
      if (radioButton1 != null)
        radioButton1.setVisibility(8); 
    } 
  }
  
  public void setChecked(boolean paramBoolean) {
    CheckBox checkBox;
    if (this.a.isExclusiveCheckable()) {
      if (this.c == null)
        b(); 
      RadioButton radioButton = this.c;
    } else {
      if (this.e == null)
        c(); 
      checkBox = this.e;
    } 
    checkBox.setChecked(paramBoolean);
  }
  
  public void setForceShowIcon(boolean paramBoolean) {
    this.r = paramBoolean;
    this.m = paramBoolean;
  }
  
  public void setGroupDividerEnabled(boolean paramBoolean) {
    ImageView imageView = this.h;
    if (imageView != null) {
      byte b;
      if (!this.o && paramBoolean) {
        b = 0;
      } else {
        b = 8;
      } 
      imageView.setVisibility(b);
    } 
  }
  
  public void setIcon(Drawable paramDrawable) {
    boolean bool;
    if (this.a.shouldShowIcon() || this.r) {
      bool = true;
    } else {
      bool = false;
    } 
    if (!bool && !this.m)
      return; 
    if (this.b == null && paramDrawable == null && !this.m)
      return; 
    if (this.b == null)
      a(); 
    if (paramDrawable != null || this.m) {
      ImageView imageView = this.b;
      if (!bool)
        paramDrawable = null; 
      imageView.setImageDrawable(paramDrawable);
      if (this.b.getVisibility() != 0)
        this.b.setVisibility(0); 
      return;
    } 
    this.b.setVisibility(8);
  }
  
  public void setShortcut(boolean paramBoolean, char paramChar) {
    if (paramBoolean && this.a.c()) {
      paramChar = Character.MIN_VALUE;
    } else {
      paramChar = '\b';
    } 
    if (paramChar == '\000')
      this.f.setText(this.a.b()); 
    if (this.f.getVisibility() != paramChar)
      this.f.setVisibility(paramChar); 
  }
  
  public void setTitle(CharSequence paramCharSequence) {
    if (paramCharSequence != null) {
      this.d.setText(paramCharSequence);
      if (this.d.getVisibility() != 0) {
        this.d.setVisibility(0);
        return;
      } 
    } else if (this.d.getVisibility() != 8) {
      this.d.setVisibility(8);
    } 
  }
  
  public boolean showsIcon() {
    return this.r;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\androidx\appcompat\view\menu\ListMenuItemView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */