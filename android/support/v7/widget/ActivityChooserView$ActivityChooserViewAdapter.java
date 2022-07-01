package android.support.v7.widget;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

final class ActivityChooserView$ActivityChooserViewAdapter extends BaseAdapter {
  ActivityChooserModel mDataModel;
  
  private boolean mHighlightDefaultActivity;
  
  private int mMaxActivityCount;
  
  boolean mShowDefaultActivity;
  
  private boolean mShowFooterView;
  
  public final int getCount() {
    int j = this.mDataModel.getActivityCount();
    int i = j;
    if (!this.mShowDefaultActivity) {
      i = j;
      if (this.mDataModel.getDefaultActivity() != null)
        i = j - 1; 
    } 
    j = Math.min(i, this.mMaxActivityCount);
    i = j;
    if (this.mShowFooterView)
      i = j + 1; 
    return i;
  }
  
  public final Object getItem(int paramInt) {
    switch (getItemViewType(paramInt)) {
      default:
        throw new IllegalArgumentException();
      case 1:
        return null;
      case 0:
        break;
    } 
    int i = paramInt;
    if (!this.mShowDefaultActivity) {
      i = paramInt;
      if (this.mDataModel.getDefaultActivity() != null)
        i = paramInt + 1; 
    } 
    return this.mDataModel.getActivity(i);
  }
  
  public final long getItemId(int paramInt) {
    return paramInt;
  }
  
  public final int getItemViewType(int paramInt) {
    return (this.mShowFooterView && paramInt == getCount() - 1) ? 1 : 0;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup) {
    // Byte code:
    //   0: aload_0
    //   1: iload_1
    //   2: invokevirtual getItemViewType : (I)I
    //   5: tableswitch default -> 28, 0 -> 107, 1 -> 36
    //   28: new java/lang/IllegalArgumentException
    //   31: dup
    //   32: invokespecial <init> : ()V
    //   35: athrow
    //   36: aload_2
    //   37: ifnull -> 51
    //   40: aload_2
    //   41: astore #4
    //   43: aload_2
    //   44: invokevirtual getId : ()I
    //   47: iconst_1
    //   48: if_icmpeq -> 104
    //   51: aload_0
    //   52: getfield this$0 : Landroid/support/v7/widget/ActivityChooserView;
    //   55: invokevirtual getContext : ()Landroid/content/Context;
    //   58: invokestatic from : (Landroid/content/Context;)Landroid/view/LayoutInflater;
    //   61: getstatic android/support/v7/appcompat/R$layout.abc_activity_chooser_view_list_item : I
    //   64: aload_3
    //   65: iconst_0
    //   66: invokevirtual inflate : (ILandroid/view/ViewGroup;Z)Landroid/view/View;
    //   69: astore #4
    //   71: aload #4
    //   73: iconst_1
    //   74: invokevirtual setId : (I)V
    //   77: aload #4
    //   79: getstatic android/support/v7/appcompat/R$id.title : I
    //   82: invokevirtual findViewById : (I)Landroid/view/View;
    //   85: checkcast android/widget/TextView
    //   88: aload_0
    //   89: getfield this$0 : Landroid/support/v7/widget/ActivityChooserView;
    //   92: invokevirtual getContext : ()Landroid/content/Context;
    //   95: getstatic android/support/v7/appcompat/R$string.abc_activity_chooser_view_see_all : I
    //   98: invokevirtual getString : (I)Ljava/lang/String;
    //   101: invokevirtual setText : (Ljava/lang/CharSequence;)V
    //   104: aload #4
    //   106: areturn
    //   107: aload_2
    //   108: ifnull -> 124
    //   111: aload_2
    //   112: astore #4
    //   114: aload_2
    //   115: invokevirtual getId : ()I
    //   118: getstatic android/support/v7/appcompat/R$id.list_item : I
    //   121: if_icmpeq -> 144
    //   124: aload_0
    //   125: getfield this$0 : Landroid/support/v7/widget/ActivityChooserView;
    //   128: invokevirtual getContext : ()Landroid/content/Context;
    //   131: invokestatic from : (Landroid/content/Context;)Landroid/view/LayoutInflater;
    //   134: getstatic android/support/v7/appcompat/R$layout.abc_activity_chooser_view_list_item : I
    //   137: aload_3
    //   138: iconst_0
    //   139: invokevirtual inflate : (ILandroid/view/ViewGroup;Z)Landroid/view/View;
    //   142: astore #4
    //   144: aload_0
    //   145: getfield this$0 : Landroid/support/v7/widget/ActivityChooserView;
    //   148: invokevirtual getContext : ()Landroid/content/Context;
    //   151: invokevirtual getPackageManager : ()Landroid/content/pm/PackageManager;
    //   154: astore_2
    //   155: aload #4
    //   157: getstatic android/support/v7/appcompat/R$id.icon : I
    //   160: invokevirtual findViewById : (I)Landroid/view/View;
    //   163: checkcast android/widget/ImageView
    //   166: astore_3
    //   167: aload_0
    //   168: iload_1
    //   169: invokevirtual getItem : (I)Ljava/lang/Object;
    //   172: checkcast android/content/pm/ResolveInfo
    //   175: astore #5
    //   177: aload_3
    //   178: aload #5
    //   180: aload_2
    //   181: invokevirtual loadIcon : (Landroid/content/pm/PackageManager;)Landroid/graphics/drawable/Drawable;
    //   184: invokevirtual setImageDrawable : (Landroid/graphics/drawable/Drawable;)V
    //   187: aload #4
    //   189: getstatic android/support/v7/appcompat/R$id.title : I
    //   192: invokevirtual findViewById : (I)Landroid/view/View;
    //   195: checkcast android/widget/TextView
    //   198: aload #5
    //   200: aload_2
    //   201: invokevirtual loadLabel : (Landroid/content/pm/PackageManager;)Ljava/lang/CharSequence;
    //   204: invokevirtual setText : (Ljava/lang/CharSequence;)V
    //   207: aload_0
    //   208: getfield mShowDefaultActivity : Z
    //   211: ifeq -> 234
    //   214: iload_1
    //   215: ifne -> 234
    //   218: aload_0
    //   219: getfield mHighlightDefaultActivity : Z
    //   222: ifeq -> 234
    //   225: aload #4
    //   227: iconst_1
    //   228: invokevirtual setActivated : (Z)V
    //   231: aload #4
    //   233: areturn
    //   234: aload #4
    //   236: iconst_0
    //   237: invokevirtual setActivated : (Z)V
    //   240: aload #4
    //   242: areturn
  }
  
  public final int getViewTypeCount() {
    return 3;
  }
  
  public final int measureContentWidth() {
    int k = this.mMaxActivityCount;
    this.mMaxActivityCount = Integer.MAX_VALUE;
    int i = 0;
    int m = View.MeasureSpec.makeMeasureSpec(0, 0);
    int n = View.MeasureSpec.makeMeasureSpec(0, 0);
    int i1 = getCount();
    View view = null;
    int j = 0;
    while (i < i1) {
      view = getView(i, view, null);
      view.measure(m, n);
      j = Math.max(j, view.getMeasuredWidth());
      i++;
    } 
    this.mMaxActivityCount = k;
    return j;
  }
  
  public final void setMaxActivityCount(int paramInt) {
    if (this.mMaxActivityCount != paramInt) {
      this.mMaxActivityCount = paramInt;
      notifyDataSetChanged();
    } 
  }
  
  public final void setShowDefaultActivity(boolean paramBoolean1, boolean paramBoolean2) {
    if (this.mShowDefaultActivity != paramBoolean1 || this.mHighlightDefaultActivity != paramBoolean2) {
      this.mShowDefaultActivity = paramBoolean1;
      this.mHighlightDefaultActivity = paramBoolean2;
      notifyDataSetChanged();
    } 
  }
  
  public final void setShowFooterView(boolean paramBoolean) {
    if (this.mShowFooterView != paramBoolean) {
      this.mShowFooterView = paramBoolean;
      notifyDataSetChanged();
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\android\support\v7\widget\ActivityChooserView$ActivityChooserViewAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */