package androidx.appcompat.view.menu;

import android.content.Context;
import android.view.MenuItem;
import android.view.SubMenu;
import androidx.collection.ArrayMap;
import androidx.core.internal.view.SupportMenuItem;
import androidx.core.internal.view.SupportSubMenu;
import java.util.Iterator;
import java.util.Map;

abstract class BaseMenuWrapper {
  final Context a;
  
  private Map<SupportMenuItem, MenuItem> b;
  
  private Map<SupportSubMenu, SubMenu> c;
  
  BaseMenuWrapper(Context paramContext) {
    this.a = paramContext;
  }
  
  final MenuItem a(MenuItem paramMenuItem) {
    MenuItem menuItem = paramMenuItem;
    if (paramMenuItem instanceof SupportMenuItem) {
      SupportMenuItem supportMenuItem = (SupportMenuItem)paramMenuItem;
      if (this.b == null)
        this.b = (Map<SupportMenuItem, MenuItem>)new ArrayMap(); 
      paramMenuItem = this.b.get(paramMenuItem);
      menuItem = paramMenuItem;
      if (paramMenuItem == null) {
        menuItem = new MenuItemWrapperICS(this.a, supportMenuItem);
        this.b.put(supportMenuItem, menuItem);
      } 
    } 
    return menuItem;
  }
  
  final SubMenu a(SubMenu paramSubMenu) {
    if (paramSubMenu instanceof SupportSubMenu) {
      SupportSubMenu supportSubMenu = (SupportSubMenu)paramSubMenu;
      if (this.c == null)
        this.c = (Map<SupportSubMenu, SubMenu>)new ArrayMap(); 
      SubMenu subMenu = this.c.get(supportSubMenu);
      paramSubMenu = subMenu;
      if (subMenu == null) {
        paramSubMenu = new SubMenuWrapperICS(this.a, supportSubMenu);
        this.c.put(supportSubMenu, paramSubMenu);
      } 
      return paramSubMenu;
    } 
    return paramSubMenu;
  }
  
  final void a() {
    Map<SupportMenuItem, MenuItem> map1 = this.b;
    if (map1 != null)
      map1.clear(); 
    Map<SupportSubMenu, SubMenu> map = this.c;
    if (map != null)
      map.clear(); 
  }
  
  final void a(int paramInt) {
    Map<SupportMenuItem, MenuItem> map = this.b;
    if (map == null)
      return; 
    Iterator<MenuItem> iterator = map.keySet().iterator();
    while (iterator.hasNext()) {
      if (paramInt == ((MenuItem)iterator.next()).getGroupId())
        iterator.remove(); 
    } 
  }
  
  final void b(int paramInt) {
    Map<SupportMenuItem, MenuItem> map = this.b;
    if (map == null)
      return; 
    Iterator<MenuItem> iterator = map.keySet().iterator();
    while (iterator.hasNext()) {
      if (paramInt == ((MenuItem)iterator.next()).getItemId()) {
        iterator.remove();
        break;
      } 
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\androidx\appcompat\view\menu\BaseMenuWrapper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */