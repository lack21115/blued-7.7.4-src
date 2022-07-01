package com.soft.blued.ui.home.help;

import android.content.Context;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.blued.android.module.common.utils.ToastUtils;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FragmentViewHelper {
  private int a;
  
  private AlertDialog b;
  
  private List<FragmentRecord> a(Fragment paramFragment) {
    ArrayList<FragmentRecord> arrayList = new ArrayList();
    List<Fragment> list = b(paramFragment.getChildFragmentManager());
    if (list == null || list.isEmpty())
      return null; 
    Iterator<Fragment> iterator = list.iterator();
    while (iterator.hasNext())
      a(arrayList, iterator.next()); 
    return arrayList;
  }
  
  private void a(FragmentActivity paramFragmentActivity) {
    AlertDialog alertDialog = this.b;
    if (alertDialog != null && alertDialog.isShowing())
      return; 
    FragmentViewContainer fragmentViewContainer = new FragmentViewContainer((Context)paramFragmentActivity);
    fragmentViewContainer.a(b(paramFragmentActivity));
    fragmentViewContainer.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
    this.b = (new AlertDialog.Builder((Context)paramFragmentActivity)).setView((View)fragmentViewContainer).setPositiveButton(17039360, null).setCancelable(true).create();
    this.b.show();
  }
  
  private void a(List<FragmentRecord> paramList, Fragment paramFragment) {
    paramList.add(new FragmentRecord(paramFragment.getClass().getSimpleName(), a(paramFragment)));
  }
  
  private List<FragmentRecord> b(FragmentActivity paramFragmentActivity) {
    ArrayList<FragmentRecord> arrayList = new ArrayList();
    List<Fragment> list = b(paramFragmentActivity.getSupportFragmentManager());
    if (list == null || list.isEmpty())
      return null; 
    Iterator<Fragment> iterator = list.iterator();
    while (iterator.hasNext())
      a(arrayList, iterator.next()); 
    return arrayList;
  }
  
  private List<Fragment> b(FragmentManager paramFragmentManager) {
    ArrayList<Fragment> arrayList = new ArrayList();
    Class<?> clazz = paramFragmentManager.getClass();
    try {
      Field field = clazz.getDeclaredField("mActive");
      field.setAccessible(true);
      try {
        SparseArray sparseArray = (SparseArray)field.get(paramFragmentManager);
        if (sparseArray != null && sparseArray.size() > 0)
          for (int i = 0; i < sparseArray.size(); i++)
            arrayList.add((Fragment)sparseArray.valueAt(i));  
      } catch (IllegalAccessException illegalAccessException) {
        illegalAccessException.printStackTrace();
        return arrayList;
      } 
    } catch (NoSuchFieldException noSuchFieldException) {
      noSuchFieldException.printStackTrace();
    } 
    return arrayList;
  }
  
  public int a(FragmentManager paramFragmentManager) {
    int j;
    boolean bool = false;
    byte b1 = 0;
    byte b2 = 0;
    int k = 0;
    if (paramFragmentManager == null)
      return 0; 
    Class<?> clazz = paramFragmentManager.getClass();
    int i = b1;
    try {
      Field field = clazz.getDeclaredField("mActive");
      i = b1;
      field.setAccessible(true);
      i = b1;
      try {
        SparseArray sparseArray = (SparseArray)field.get(paramFragmentManager);
        j = b2;
        if (sparseArray != null) {
          i = b1;
          j = b2;
          if (sparseArray.size() > 0) {
            i = b1;
            j = sparseArray.size();
            i = j + 0;
            j = k;
            try {
              while (j < sparseArray.size()) {
                k = a(((Fragment)sparseArray.valueAt(j)).getChildFragmentManager());
                i += k;
                j++;
              } 
              return i;
            } catch (IllegalAccessException null) {
              j = i;
            } catch (NoSuchFieldException noSuchFieldException) {}
          } else {
            return j;
          } 
        } else {
          return j;
        } 
      } catch (IllegalAccessException illegalAccessException) {
        j = bool;
      } 
      i = j;
      illegalAccessException.printStackTrace();
      return j;
    } catch (NoSuchFieldException noSuchFieldException) {
      noSuchFieldException.printStackTrace();
      j = i;
    } 
    return j;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\home\help\FragmentViewHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */