package androidx.appcompat.view;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.PorterDuff;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;
import android.view.InflateException;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import androidx.appcompat.R;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.view.menu.MenuItemWrapperICS;
import androidx.core.view.ActionProvider;
import androidx.core.view.MenuItemCompat;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class SupportMenuInflater extends MenuInflater {
  static final Class<?>[] a = new Class[] { Context.class };
  
  static final Class<?>[] b = a;
  
  final Object[] c;
  
  final Object[] d;
  
  Context e;
  
  private Object f;
  
  public SupportMenuInflater(Context paramContext) {
    super(paramContext);
    this.e = paramContext;
    this.c = new Object[] { paramContext };
    this.d = this.c;
  }
  
  private Object a(Object paramObject) {
    if (paramObject instanceof android.app.Activity)
      return paramObject; 
    Object object = paramObject;
    if (paramObject instanceof ContextWrapper)
      object = a(((ContextWrapper)paramObject).getBaseContext()); 
    return object;
  }
  
  private void a(XmlPullParser paramXmlPullParser, AttributeSet paramAttributeSet, Menu paramMenu) throws XmlPullParserException, IOException {
    StringBuilder stringBuilder;
    MenuState menuState = new MenuState(this, paramMenu);
    int i = paramXmlPullParser.getEventType();
    while (true) {
      if (i == 2) {
        String str = paramXmlPullParser.getName();
        if (str.equals("menu")) {
          i = paramXmlPullParser.next();
          break;
        } 
        stringBuilder = new StringBuilder();
        stringBuilder.append("Expecting menu, got ");
        stringBuilder.append(str);
        throw new RuntimeException(stringBuilder.toString());
      } 
      int m = stringBuilder.next();
      i = m;
      if (m == 1) {
        i = m;
        break;
      } 
    } 
    Menu menu = null;
    boolean bool = false;
    int j = 0;
    int k = i;
    while (!bool) {
      if (k != 1) {
        Menu menu1;
        boolean bool1;
        if (k != 2) {
          if (k != 3) {
            i = j;
            paramMenu = menu;
            bool1 = bool;
          } else {
            String str = stringBuilder.getName();
            if (j && str.equals(menu)) {
              paramMenu = null;
              i = 0;
              bool1 = bool;
            } else if (str.equals("group")) {
              menuState.resetGroup();
              i = j;
              paramMenu = menu;
              bool1 = bool;
            } else if (str.equals("item")) {
              i = j;
              paramMenu = menu;
              bool1 = bool;
              if (!menuState.hasAddedItem())
                if (menuState.a != null && menuState.a.hasSubMenu()) {
                  menuState.addSubMenuItem();
                  i = j;
                  paramMenu = menu;
                  bool1 = bool;
                } else {
                  menuState.addItem();
                  i = j;
                  paramMenu = menu;
                  bool1 = bool;
                }  
            } else {
              i = j;
              paramMenu = menu;
              bool1 = bool;
              if (str.equals("menu")) {
                bool1 = true;
                i = j;
                paramMenu = menu;
              } 
            } 
          } 
        } else if (j) {
          i = j;
          paramMenu = menu;
          bool1 = bool;
        } else {
          String str = stringBuilder.getName();
          if (str.equals("group")) {
            menuState.readGroup(paramAttributeSet);
            i = j;
            menu1 = menu;
            bool1 = bool;
          } else if (menu1.equals("item")) {
            menuState.readItem(paramAttributeSet);
            i = j;
            menu1 = menu;
            bool1 = bool;
          } else if (menu1.equals("menu")) {
            a((XmlPullParser)stringBuilder, paramAttributeSet, (Menu)menuState.addSubMenuItem());
            i = j;
            menu1 = menu;
            bool1 = bool;
          } else {
            i = 1;
            bool1 = bool;
          } 
        } 
        k = stringBuilder.next();
        j = i;
        menu = menu1;
        bool = bool1;
        continue;
      } 
      throw new RuntimeException("Unexpected end of document");
    } 
  }
  
  Object a() {
    if (this.f == null)
      this.f = a(this.e); 
    return this.f;
  }
  
  public void inflate(int paramInt, Menu paramMenu) {
    if (!(paramMenu instanceof androidx.core.internal.view.SupportMenu)) {
      super.inflate(paramInt, paramMenu);
      return;
    } 
    XmlResourceParser xmlResourceParser2 = null;
    XmlResourceParser xmlResourceParser3 = null;
    XmlResourceParser xmlResourceParser1 = null;
    try {
      XmlResourceParser xmlResourceParser = this.e.getResources().getLayout(paramInt);
      xmlResourceParser1 = xmlResourceParser;
      xmlResourceParser2 = xmlResourceParser;
      xmlResourceParser3 = xmlResourceParser;
      a((XmlPullParser)xmlResourceParser, Xml.asAttributeSet((XmlPullParser)xmlResourceParser), paramMenu);
      if (xmlResourceParser != null)
        xmlResourceParser.close(); 
      return;
    } catch (XmlPullParserException xmlPullParserException) {
      xmlResourceParser1 = xmlResourceParser3;
      throw new InflateException("Error inflating menu XML", xmlPullParserException);
    } catch (IOException iOException) {
      xmlResourceParser1 = xmlResourceParser2;
      throw new InflateException("Error inflating menu XML", iOException);
    } finally {}
    if (xmlResourceParser1 != null)
      xmlResourceParser1.close(); 
    throw paramMenu;
  }
  
  static class InflatedOnMenuItemClickListener implements MenuItem.OnMenuItemClickListener {
    private static final Class<?>[] a = new Class[] { MenuItem.class };
    
    private Object b;
    
    private Method c;
    
    public InflatedOnMenuItemClickListener(Object param1Object, String param1String) {
      this.b = param1Object;
      Class<?> clazz = param1Object.getClass();
      try {
        this.c = clazz.getMethod(param1String, a);
        return;
      } catch (Exception exception) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Couldn't resolve menu item onClick handler ");
        stringBuilder.append(param1String);
        stringBuilder.append(" in class ");
        stringBuilder.append(clazz.getName());
        InflateException inflateException = new InflateException(stringBuilder.toString());
        inflateException.initCause(exception);
        throw inflateException;
      } 
    }
    
    public boolean onMenuItemClick(MenuItem param1MenuItem) {
      try {
        if (this.c.getReturnType() == boolean.class)
          return ((Boolean)this.c.invoke(this.b, new Object[] { param1MenuItem })).booleanValue(); 
        this.c.invoke(this.b, new Object[] { param1MenuItem });
        return true;
      } catch (Exception exception) {
        throw new RuntimeException(exception);
      } 
    }
  }
  
  class MenuState {
    private String A;
    
    private String B;
    
    private CharSequence C;
    
    private CharSequence D;
    
    private ColorStateList E = null;
    
    private PorterDuff.Mode F = null;
    
    ActionProvider a;
    
    private Menu c;
    
    private int d;
    
    private int e;
    
    private int f;
    
    private int g;
    
    private boolean h;
    
    private boolean i;
    
    private boolean j;
    
    private int k;
    
    private int l;
    
    private CharSequence m;
    
    private CharSequence n;
    
    private int o;
    
    private char p;
    
    private int q;
    
    private char r;
    
    private int s;
    
    private int t;
    
    private boolean u;
    
    private boolean v;
    
    private boolean w;
    
    private int x;
    
    private int y;
    
    private String z;
    
    public MenuState(SupportMenuInflater this$0, Menu param1Menu) {
      this.c = param1Menu;
      resetGroup();
    }
    
    private char a(String param1String) {
      return (param1String == null) ? Character.MIN_VALUE : param1String.charAt(0);
    }
    
    private <T> T a(String param1String, Class<?>[] param1ArrayOfClass, Object[] param1ArrayOfObject) {
      try {
        null = Class.forName(param1String, false, this.b.e.getClassLoader()).getConstructor(param1ArrayOfClass);
        null.setAccessible(true);
        return (T)null.newInstance(param1ArrayOfObject);
      } catch (Exception exception) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Cannot instantiate class: ");
        stringBuilder.append(param1String);
        Log.w("SupportMenuInflater", stringBuilder.toString(), exception);
        return null;
      } 
    }
    
    private void a(MenuItem param1MenuItem) {
      MenuItem menuItem = param1MenuItem.setChecked(this.u).setVisible(this.v).setEnabled(this.w);
      int i = this.t;
      boolean bool = false;
      if (i >= 1) {
        bool1 = true;
      } else {
        bool1 = false;
      } 
      menuItem.setCheckable(bool1).setTitleCondensed(this.n).setIcon(this.o);
      i = this.x;
      if (i >= 0)
        param1MenuItem.setShowAsAction(i); 
      if (this.B != null)
        if (!this.b.e.isRestricted()) {
          param1MenuItem.setOnMenuItemClickListener(new SupportMenuInflater.InflatedOnMenuItemClickListener(this.b.a(), this.B));
        } else {
          throw new IllegalStateException("The android:onClick attribute cannot be used within a restricted context");
        }  
      boolean bool1 = param1MenuItem instanceof MenuItemImpl;
      if (bool1)
        MenuItemImpl menuItemImpl = (MenuItemImpl)param1MenuItem; 
      if (this.t >= 2)
        if (bool1) {
          ((MenuItemImpl)param1MenuItem).setExclusiveCheckable(true);
        } else if (param1MenuItem instanceof MenuItemWrapperICS) {
          ((MenuItemWrapperICS)param1MenuItem).setExclusiveCheckable(true);
        }  
      String str = this.z;
      if (str != null) {
        param1MenuItem.setActionView(a(str, SupportMenuInflater.a, this.b.c));
        bool = true;
      } 
      i = this.y;
      if (i > 0)
        if (!bool) {
          param1MenuItem.setActionView(i);
        } else {
          Log.w("SupportMenuInflater", "Ignoring attribute 'itemActionViewLayout'. Action view already specified.");
        }  
      ActionProvider actionProvider = this.a;
      if (actionProvider != null)
        MenuItemCompat.setActionProvider(param1MenuItem, actionProvider); 
      MenuItemCompat.setContentDescription(param1MenuItem, this.C);
      MenuItemCompat.setTooltipText(param1MenuItem, this.D);
      MenuItemCompat.setAlphabeticShortcut(param1MenuItem, this.p, this.q);
      MenuItemCompat.setNumericShortcut(param1MenuItem, this.r, this.s);
      PorterDuff.Mode mode = this.F;
      if (mode != null)
        MenuItemCompat.setIconTintMode(param1MenuItem, mode); 
      ColorStateList colorStateList = this.E;
      if (colorStateList != null)
        MenuItemCompat.setIconTintList(param1MenuItem, colorStateList); 
    }
    
    public void addItem() {
      this.j = true;
      a(this.c.add(this.d, this.k, this.l, this.m));
    }
    
    public SubMenu addSubMenuItem() {
      this.j = true;
      SubMenu subMenu = this.c.addSubMenu(this.d, this.k, this.l, this.m);
      a(subMenu.getItem());
      return subMenu;
    }
    
    public boolean hasAddedItem() {
      return this.j;
    }
    
    public void readGroup(AttributeSet param1AttributeSet) {
      TypedArray typedArray = this.b.e.obtainStyledAttributes(param1AttributeSet, R.styleable.MenuGroup);
      this.d = typedArray.getResourceId(R.styleable.MenuGroup_android_id, 0);
      this.e = typedArray.getInt(R.styleable.MenuGroup_android_menuCategory, 0);
      this.f = typedArray.getInt(R.styleable.MenuGroup_android_orderInCategory, 0);
      this.g = typedArray.getInt(R.styleable.MenuGroup_android_checkableBehavior, 0);
      this.h = typedArray.getBoolean(R.styleable.MenuGroup_android_visible, true);
      this.i = typedArray.getBoolean(R.styleable.MenuGroup_android_enabled, true);
      typedArray.recycle();
    }
    
    public void readItem(AttributeSet param1AttributeSet) {
      throw new RuntimeException("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }
    
    public void resetGroup() {
      this.d = 0;
      this.e = 0;
      this.f = 0;
      this.g = 0;
      this.h = true;
      this.i = true;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\androidx\appcompat\view\SupportMenuInflater.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */