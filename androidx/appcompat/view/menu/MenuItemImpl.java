package androidx.appcompat.view.menu;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.Log;
import android.view.ActionProvider;
import android.view.ContextMenu;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewDebug.CapturedViewProperty;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.appcompat.R;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.internal.view.SupportMenuItem;
import androidx.core.view.ActionProvider;

public final class MenuItemImpl implements SupportMenuItem {
  private View A;
  
  private ActionProvider B;
  
  private MenuItem.OnActionExpandListener C;
  
  private boolean D = false;
  
  private ContextMenu.ContextMenuInfo E;
  
  MenuBuilder a;
  
  private final int b;
  
  private final int c;
  
  private final int d;
  
  private final int e;
  
  private CharSequence f;
  
  private CharSequence g;
  
  private Intent h;
  
  private char i;
  
  private int j = 4096;
  
  private char k;
  
  private int l = 4096;
  
  private Drawable m;
  
  private int n = 0;
  
  private SubMenuBuilder o;
  
  private Runnable p;
  
  private MenuItem.OnMenuItemClickListener q;
  
  private CharSequence r;
  
  private CharSequence s;
  
  private ColorStateList t = null;
  
  private PorterDuff.Mode u = null;
  
  private boolean v = false;
  
  private boolean w = false;
  
  private boolean x = false;
  
  private int y = 16;
  
  private int z = 0;
  
  MenuItemImpl(MenuBuilder paramMenuBuilder, int paramInt1, int paramInt2, int paramInt3, int paramInt4, CharSequence paramCharSequence, int paramInt5) {
    this.a = paramMenuBuilder;
    this.b = paramInt2;
    this.c = paramInt1;
    this.d = paramInt3;
    this.e = paramInt4;
    this.f = paramCharSequence;
    this.z = paramInt5;
  }
  
  private Drawable a(Drawable paramDrawable) {
    // Byte code:
    //   0: aload_1
    //   1: astore_2
    //   2: aload_1
    //   3: ifnull -> 74
    //   6: aload_1
    //   7: astore_2
    //   8: aload_0
    //   9: getfield x : Z
    //   12: ifeq -> 74
    //   15: aload_0
    //   16: getfield v : Z
    //   19: ifne -> 31
    //   22: aload_1
    //   23: astore_2
    //   24: aload_0
    //   25: getfield w : Z
    //   28: ifeq -> 74
    //   31: aload_1
    //   32: invokestatic wrap : (Landroid/graphics/drawable/Drawable;)Landroid/graphics/drawable/Drawable;
    //   35: invokevirtual mutate : ()Landroid/graphics/drawable/Drawable;
    //   38: astore_2
    //   39: aload_0
    //   40: getfield v : Z
    //   43: ifeq -> 54
    //   46: aload_2
    //   47: aload_0
    //   48: getfield t : Landroid/content/res/ColorStateList;
    //   51: invokestatic setTintList : (Landroid/graphics/drawable/Drawable;Landroid/content/res/ColorStateList;)V
    //   54: aload_0
    //   55: getfield w : Z
    //   58: ifeq -> 69
    //   61: aload_2
    //   62: aload_0
    //   63: getfield u : Landroid/graphics/PorterDuff$Mode;
    //   66: invokestatic setTintMode : (Landroid/graphics/drawable/Drawable;Landroid/graphics/PorterDuff$Mode;)V
    //   69: aload_0
    //   70: iconst_0
    //   71: putfield x : Z
    //   74: aload_2
    //   75: areturn
  }
  
  private static void a(StringBuilder paramStringBuilder, int paramInt1, int paramInt2, String paramString) {
    if ((paramInt1 & paramInt2) == paramInt2)
      paramStringBuilder.append(paramString); 
  }
  
  char a() {
    return this.a.isQwertyMode() ? this.k : this.i;
  }
  
  CharSequence a(MenuView.ItemView paramItemView) {
    return (paramItemView != null && paramItemView.prefersCondensedTitle()) ? getTitleCondensed() : getTitle();
  }
  
  void a(ContextMenu.ContextMenuInfo paramContextMenuInfo) {
    this.E = paramContextMenuInfo;
  }
  
  void a(boolean paramBoolean) {
    boolean bool;
    int i = this.y;
    if (paramBoolean) {
      bool = true;
    } else {
      bool = false;
    } 
    this.y = bool | i & 0xFFFFFFFD;
    if (i != this.y)
      this.a.onItemsChanged(false); 
  }
  
  public void actionFormatChanged() {
    this.a.b(this);
  }
  
  String b() {
    int i;
    char c = a();
    if (c == '\000')
      return ""; 
    Resources resources = this.a.getContext().getResources();
    StringBuilder stringBuilder = new StringBuilder();
    if (ViewConfiguration.get(this.a.getContext()).hasPermanentMenuKey())
      stringBuilder.append(resources.getString(R.string.abc_prepend_shortcut_label)); 
    if (this.a.isQwertyMode()) {
      i = this.l;
    } else {
      i = this.j;
    } 
    a(stringBuilder, i, 65536, resources.getString(R.string.abc_menu_meta_shortcut_label));
    a(stringBuilder, i, 4096, resources.getString(R.string.abc_menu_ctrl_shortcut_label));
    a(stringBuilder, i, 2, resources.getString(R.string.abc_menu_alt_shortcut_label));
    a(stringBuilder, i, 1, resources.getString(R.string.abc_menu_shift_shortcut_label));
    a(stringBuilder, i, 4, resources.getString(R.string.abc_menu_sym_shortcut_label));
    a(stringBuilder, i, 8, resources.getString(R.string.abc_menu_function_shortcut_label));
    if (c != '\b') {
      if (c != '\n') {
        if (c != ' ') {
          stringBuilder.append(c);
        } else {
          stringBuilder.append(resources.getString(R.string.abc_menu_space_shortcut_label));
        } 
      } else {
        stringBuilder.append(resources.getString(R.string.abc_menu_enter_shortcut_label));
      } 
    } else {
      stringBuilder.append(resources.getString(R.string.abc_menu_delete_shortcut_label));
    } 
    return stringBuilder.toString();
  }
  
  boolean b(boolean paramBoolean) {
    byte b;
    int i = this.y;
    boolean bool = false;
    if (paramBoolean) {
      b = 0;
    } else {
      b = 8;
    } 
    this.y = b | i & 0xFFFFFFF7;
    paramBoolean = bool;
    if (i != this.y)
      paramBoolean = true; 
    return paramBoolean;
  }
  
  boolean c() {
    return (this.a.isShortcutsVisible() && a() != '\000');
  }
  
  public boolean collapseActionView() {
    if ((this.z & 0x8) == 0)
      return false; 
    if (this.A == null)
      return true; 
    MenuItem.OnActionExpandListener onActionExpandListener = this.C;
    return (onActionExpandListener == null || onActionExpandListener.onMenuItemActionCollapse((MenuItem)this)) ? this.a.collapseItemActionView(this) : false;
  }
  
  public boolean expandActionView() {
    if (!hasCollapsibleActionView())
      return false; 
    MenuItem.OnActionExpandListener onActionExpandListener = this.C;
    return (onActionExpandListener == null || onActionExpandListener.onMenuItemActionExpand((MenuItem)this)) ? this.a.expandItemActionView(this) : false;
  }
  
  public ActionProvider getActionProvider() {
    throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.getActionProvider()");
  }
  
  public View getActionView() {
    View view = this.A;
    if (view != null)
      return view; 
    ActionProvider actionProvider = this.B;
    if (actionProvider != null) {
      this.A = actionProvider.onCreateActionView((MenuItem)this);
      return this.A;
    } 
    return null;
  }
  
  public int getAlphabeticModifiers() {
    return this.l;
  }
  
  public char getAlphabeticShortcut() {
    return this.k;
  }
  
  public CharSequence getContentDescription() {
    return this.r;
  }
  
  public int getGroupId() {
    return this.c;
  }
  
  public Drawable getIcon() {
    Drawable drawable = this.m;
    if (drawable != null)
      return a(drawable); 
    if (this.n != 0) {
      drawable = AppCompatResources.getDrawable(this.a.getContext(), this.n);
      this.n = 0;
      this.m = drawable;
      return a(drawable);
    } 
    return null;
  }
  
  public ColorStateList getIconTintList() {
    return this.t;
  }
  
  public PorterDuff.Mode getIconTintMode() {
    return this.u;
  }
  
  public Intent getIntent() {
    return this.h;
  }
  
  @CapturedViewProperty
  public int getItemId() {
    return this.b;
  }
  
  public ContextMenu.ContextMenuInfo getMenuInfo() {
    return this.E;
  }
  
  public int getNumericModifiers() {
    return this.j;
  }
  
  public char getNumericShortcut() {
    return this.i;
  }
  
  public int getOrder() {
    return this.d;
  }
  
  public int getOrdering() {
    return this.e;
  }
  
  public SubMenu getSubMenu() {
    return this.o;
  }
  
  public ActionProvider getSupportActionProvider() {
    return this.B;
  }
  
  @CapturedViewProperty
  public CharSequence getTitle() {
    return this.f;
  }
  
  public CharSequence getTitleCondensed() {
    CharSequence charSequence1 = this.g;
    if (charSequence1 == null)
      charSequence1 = this.f; 
    CharSequence charSequence2 = charSequence1;
    if (Build.VERSION.SDK_INT < 18) {
      charSequence2 = charSequence1;
      if (charSequence1 != null) {
        charSequence2 = charSequence1;
        if (!(charSequence1 instanceof String))
          charSequence2 = charSequence1.toString(); 
      } 
    } 
    return charSequence2;
  }
  
  public CharSequence getTooltipText() {
    return this.s;
  }
  
  public boolean hasCollapsibleActionView() {
    int i = this.z;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if ((i & 0x8) != 0) {
      if (this.A == null) {
        ActionProvider actionProvider = this.B;
        if (actionProvider != null)
          this.A = actionProvider.onCreateActionView((MenuItem)this); 
      } 
      bool1 = bool2;
      if (this.A != null)
        bool1 = true; 
    } 
    return bool1;
  }
  
  public boolean hasSubMenu() {
    return (this.o != null);
  }
  
  public boolean invoke() {
    MenuItem.OnMenuItemClickListener onMenuItemClickListener = this.q;
    if (onMenuItemClickListener != null && onMenuItemClickListener.onMenuItemClick((MenuItem)this))
      return true; 
    MenuBuilder menuBuilder = this.a;
    if (menuBuilder.a(menuBuilder, (MenuItem)this))
      return true; 
    Runnable runnable = this.p;
    if (runnable != null) {
      runnable.run();
      return true;
    } 
    if (this.h != null)
      try {
        this.a.getContext().startActivity(this.h);
        return true;
      } catch (ActivityNotFoundException activityNotFoundException) {
        Log.e("MenuItemImpl", "Can't find activity to handle intent; ignoring", (Throwable)activityNotFoundException);
      }  
    ActionProvider actionProvider = this.B;
    return (actionProvider != null && actionProvider.onPerformDefaultAction());
  }
  
  public boolean isActionButton() {
    return ((this.y & 0x20) == 32);
  }
  
  public boolean isActionViewExpanded() {
    return this.D;
  }
  
  public boolean isCheckable() {
    return ((this.y & 0x1) == 1);
  }
  
  public boolean isChecked() {
    return ((this.y & 0x2) == 2);
  }
  
  public boolean isEnabled() {
    return ((this.y & 0x10) != 0);
  }
  
  public boolean isExclusiveCheckable() {
    return ((this.y & 0x4) != 0);
  }
  
  public boolean isVisible() {
    ActionProvider actionProvider = this.B;
    return (actionProvider != null && actionProvider.overridesItemVisibility()) ? (((this.y & 0x8) == 0 && this.B.isVisible())) : (((this.y & 0x8) == 0));
  }
  
  public boolean requestsActionButton() {
    return ((this.z & 0x1) == 1);
  }
  
  public boolean requiresActionButton() {
    return ((this.z & 0x2) == 2);
  }
  
  public boolean requiresOverflow() {
    return (!requiresActionButton() && !requestsActionButton());
  }
  
  public MenuItem setActionProvider(ActionProvider paramActionProvider) {
    throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.setActionProvider()");
  }
  
  public SupportMenuItem setActionView(int paramInt) {
    Context context = this.a.getContext();
    setActionView(LayoutInflater.from(context).inflate(paramInt, (ViewGroup)new LinearLayout(context), false));
    return this;
  }
  
  public SupportMenuItem setActionView(View paramView) {
    this.A = paramView;
    this.B = null;
    if (paramView != null && paramView.getId() == -1) {
      int i = this.b;
      if (i > 0)
        paramView.setId(i); 
    } 
    this.a.b(this);
    return this;
  }
  
  public void setActionViewExpanded(boolean paramBoolean) {
    this.D = paramBoolean;
    this.a.onItemsChanged(false);
  }
  
  public MenuItem setAlphabeticShortcut(char paramChar) {
    if (this.k == paramChar)
      return (MenuItem)this; 
    this.k = Character.toLowerCase(paramChar);
    this.a.onItemsChanged(false);
    return (MenuItem)this;
  }
  
  public MenuItem setAlphabeticShortcut(char paramChar, int paramInt) {
    if (this.k == paramChar && this.l == paramInt)
      return (MenuItem)this; 
    this.k = Character.toLowerCase(paramChar);
    this.l = KeyEvent.normalizeMetaState(paramInt);
    this.a.onItemsChanged(false);
    return (MenuItem)this;
  }
  
  public MenuItem setCallback(Runnable paramRunnable) {
    this.p = paramRunnable;
    return (MenuItem)this;
  }
  
  public MenuItem setCheckable(boolean paramBoolean) {
    int i = this.y;
    this.y = paramBoolean | i & 0xFFFFFFFE;
    if (i != this.y)
      this.a.onItemsChanged(false); 
    return (MenuItem)this;
  }
  
  public MenuItem setChecked(boolean paramBoolean) {
    if ((this.y & 0x4) != 0) {
      this.a.a((MenuItem)this);
      return (MenuItem)this;
    } 
    a(paramBoolean);
    return (MenuItem)this;
  }
  
  public SupportMenuItem setContentDescription(CharSequence paramCharSequence) {
    this.r = paramCharSequence;
    this.a.onItemsChanged(false);
    return this;
  }
  
  public MenuItem setEnabled(boolean paramBoolean) {
    if (paramBoolean) {
      this.y |= 0x10;
    } else {
      this.y &= 0xFFFFFFEF;
    } 
    this.a.onItemsChanged(false);
    return (MenuItem)this;
  }
  
  public void setExclusiveCheckable(boolean paramBoolean) {
    boolean bool;
    int i = this.y;
    if (paramBoolean) {
      bool = true;
    } else {
      bool = false;
    } 
    this.y = bool | i & 0xFFFFFFFB;
  }
  
  public MenuItem setIcon(int paramInt) {
    this.m = null;
    this.n = paramInt;
    this.x = true;
    this.a.onItemsChanged(false);
    return (MenuItem)this;
  }
  
  public MenuItem setIcon(Drawable paramDrawable) {
    this.n = 0;
    this.m = paramDrawable;
    this.x = true;
    this.a.onItemsChanged(false);
    return (MenuItem)this;
  }
  
  public MenuItem setIconTintList(ColorStateList paramColorStateList) {
    this.t = paramColorStateList;
    this.v = true;
    this.x = true;
    this.a.onItemsChanged(false);
    return (MenuItem)this;
  }
  
  public MenuItem setIconTintMode(PorterDuff.Mode paramMode) {
    this.u = paramMode;
    this.w = true;
    this.x = true;
    this.a.onItemsChanged(false);
    return (MenuItem)this;
  }
  
  public MenuItem setIntent(Intent paramIntent) {
    this.h = paramIntent;
    return (MenuItem)this;
  }
  
  public void setIsActionButton(boolean paramBoolean) {
    if (paramBoolean) {
      this.y |= 0x20;
      return;
    } 
    this.y &= 0xFFFFFFDF;
  }
  
  public MenuItem setNumericShortcut(char paramChar) {
    if (this.i == paramChar)
      return (MenuItem)this; 
    this.i = paramChar;
    this.a.onItemsChanged(false);
    return (MenuItem)this;
  }
  
  public MenuItem setNumericShortcut(char paramChar, int paramInt) {
    if (this.i == paramChar && this.j == paramInt)
      return (MenuItem)this; 
    this.i = paramChar;
    this.j = KeyEvent.normalizeMetaState(paramInt);
    this.a.onItemsChanged(false);
    return (MenuItem)this;
  }
  
  public MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener paramOnActionExpandListener) {
    this.C = paramOnActionExpandListener;
    return (MenuItem)this;
  }
  
  public MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener) {
    this.q = paramOnMenuItemClickListener;
    return (MenuItem)this;
  }
  
  public MenuItem setShortcut(char paramChar1, char paramChar2) {
    this.i = paramChar1;
    this.k = Character.toLowerCase(paramChar2);
    this.a.onItemsChanged(false);
    return (MenuItem)this;
  }
  
  public MenuItem setShortcut(char paramChar1, char paramChar2, int paramInt1, int paramInt2) {
    this.i = paramChar1;
    this.j = KeyEvent.normalizeMetaState(paramInt1);
    this.k = Character.toLowerCase(paramChar2);
    this.l = KeyEvent.normalizeMetaState(paramInt2);
    this.a.onItemsChanged(false);
    return (MenuItem)this;
  }
  
  public void setShowAsAction(int paramInt) {
    int i = paramInt & 0x3;
    if (i == 0 || i == 1 || i == 2) {
      this.z = paramInt;
      this.a.b(this);
      return;
    } 
    throw new IllegalArgumentException("SHOW_AS_ACTION_ALWAYS, SHOW_AS_ACTION_IF_ROOM, and SHOW_AS_ACTION_NEVER are mutually exclusive.");
  }
  
  public SupportMenuItem setShowAsActionFlags(int paramInt) {
    setShowAsAction(paramInt);
    return this;
  }
  
  public void setSubMenu(SubMenuBuilder paramSubMenuBuilder) {
    this.o = paramSubMenuBuilder;
    paramSubMenuBuilder.setHeaderTitle(getTitle());
  }
  
  public SupportMenuItem setSupportActionProvider(ActionProvider paramActionProvider) {
    ActionProvider actionProvider = this.B;
    if (actionProvider != null)
      actionProvider.reset(); 
    this.A = null;
    this.B = paramActionProvider;
    this.a.onItemsChanged(true);
    paramActionProvider = this.B;
    if (paramActionProvider != null)
      paramActionProvider.setVisibilityListener(new ActionProvider.VisibilityListener(this) {
            public void onActionProviderVisibilityChanged(boolean param1Boolean) {
              this.a.a.a(this.a);
            }
          }); 
    return this;
  }
  
  public MenuItem setTitle(int paramInt) {
    return setTitle(this.a.getContext().getString(paramInt));
  }
  
  public MenuItem setTitle(CharSequence paramCharSequence) {
    this.f = paramCharSequence;
    this.a.onItemsChanged(false);
    SubMenuBuilder subMenuBuilder = this.o;
    if (subMenuBuilder != null)
      subMenuBuilder.setHeaderTitle(paramCharSequence); 
    return (MenuItem)this;
  }
  
  public MenuItem setTitleCondensed(CharSequence paramCharSequence) {
    this.g = paramCharSequence;
    if (paramCharSequence == null)
      paramCharSequence = this.f; 
    this.a.onItemsChanged(false);
    return (MenuItem)this;
  }
  
  public SupportMenuItem setTooltipText(CharSequence paramCharSequence) {
    this.s = paramCharSequence;
    this.a.onItemsChanged(false);
    return this;
  }
  
  public MenuItem setVisible(boolean paramBoolean) {
    if (b(paramBoolean))
      this.a.a(this); 
    return (MenuItem)this;
  }
  
  public boolean shouldShowIcon() {
    return this.a.b();
  }
  
  public boolean showsTextAsAction() {
    return ((this.z & 0x4) == 4);
  }
  
  public String toString() {
    CharSequence charSequence = this.f;
    return (charSequence != null) ? charSequence.toString() : null;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\androidx\appcompat\view\menu\MenuItemImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */