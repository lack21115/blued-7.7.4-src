package com.google.android.material.bottomnavigation;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.ViewGroup;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.appcompat.view.menu.MenuView;
import androidx.appcompat.view.menu.SubMenuBuilder;
import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.badge.BadgeUtils;
import com.google.android.material.internal.ParcelableSparseArray;

public class BottomNavigationPresenter implements MenuPresenter {
  private MenuBuilder a;
  
  private BottomNavigationMenuView b;
  
  private boolean c = false;
  
  private int d;
  
  public void a(int paramInt) {
    this.d = paramInt;
  }
  
  public void a(BottomNavigationMenuView paramBottomNavigationMenuView) {
    this.b = paramBottomNavigationMenuView;
  }
  
  public void a(boolean paramBoolean) {
    this.c = paramBoolean;
  }
  
  public boolean collapseItemActionView(MenuBuilder paramMenuBuilder, MenuItemImpl paramMenuItemImpl) {
    return false;
  }
  
  public boolean expandItemActionView(MenuBuilder paramMenuBuilder, MenuItemImpl paramMenuItemImpl) {
    return false;
  }
  
  public boolean flagActionItems() {
    return false;
  }
  
  public int getId() {
    return this.d;
  }
  
  public MenuView getMenuView(ViewGroup paramViewGroup) {
    return this.b;
  }
  
  public void initForMenu(Context paramContext, MenuBuilder paramMenuBuilder) {
    this.a = paramMenuBuilder;
    this.b.initialize(this.a);
  }
  
  public void onCloseMenu(MenuBuilder paramMenuBuilder, boolean paramBoolean) {}
  
  public void onRestoreInstanceState(Parcelable paramParcelable) {
    if (paramParcelable instanceof SavedState) {
      BottomNavigationMenuView bottomNavigationMenuView = this.b;
      paramParcelable = paramParcelable;
      bottomNavigationMenuView.b(((SavedState)paramParcelable).a);
      SparseArray<BadgeDrawable> sparseArray = BadgeUtils.a(this.b.getContext(), ((SavedState)paramParcelable).b);
      this.b.setBadgeDrawables(sparseArray);
    } 
  }
  
  public Parcelable onSaveInstanceState() {
    SavedState savedState = new SavedState();
    savedState.a = this.b.getSelectedItemId();
    savedState.b = BadgeUtils.a(this.b.getBadgeDrawables());
    return savedState;
  }
  
  public boolean onSubMenuSelected(SubMenuBuilder paramSubMenuBuilder) {
    return false;
  }
  
  public void setCallback(MenuPresenter.Callback paramCallback) {}
  
  public void updateMenuView(boolean paramBoolean) {
    if (this.c)
      return; 
    if (paramBoolean) {
      this.b.b();
      return;
    } 
    this.b.c();
  }
  
  static class SavedState implements Parcelable {
    public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() {
        public BottomNavigationPresenter.SavedState a(Parcel param2Parcel) {
          return new BottomNavigationPresenter.SavedState(param2Parcel);
        }
        
        public BottomNavigationPresenter.SavedState[] a(int param2Int) {
          return new BottomNavigationPresenter.SavedState[param2Int];
        }
      };
    
    int a;
    
    ParcelableSparseArray b;
    
    SavedState() {}
    
    SavedState(Parcel param1Parcel) {
      this.a = param1Parcel.readInt();
      this.b = (ParcelableSparseArray)param1Parcel.readParcelable(getClass().getClassLoader());
    }
    
    public int describeContents() {
      return 0;
    }
    
    public void writeToParcel(Parcel param1Parcel, int param1Int) {
      param1Parcel.writeInt(this.a);
      param1Parcel.writeParcelable((Parcelable)this.b, 0);
    }
  }
  
  static final class null implements Parcelable.Creator<SavedState> {
    public BottomNavigationPresenter.SavedState a(Parcel param1Parcel) {
      return new BottomNavigationPresenter.SavedState(param1Parcel);
    }
    
    public BottomNavigationPresenter.SavedState[] a(int param1Int) {
      return new BottomNavigationPresenter.SavedState[param1Int];
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\google\android\material\bottomnavigation\BottomNavigationPresenter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */