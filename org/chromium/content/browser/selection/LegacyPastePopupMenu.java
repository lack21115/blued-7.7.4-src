package org.chromium.content.browser.selection;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import org.chromium.build.BuildHooksAndroid;

public final class LegacyPastePopupMenu implements View.OnClickListener, PastePopupMenu {
  private final PopupWindow mContainer;
  
  private final Context mContext;
  
  private final PastePopupMenu$PastePopupMenuDelegate mDelegate;
  
  private final int mLineOffsetY;
  
  private final View mParent;
  
  private View mPasteView;
  
  private final int mPasteViewLayout;
  
  private int mRawPositionX;
  
  private int mRawPositionY;
  
  private int mStatusBarHeight;
  
  private final int mWidthOffsetX;
  
  public LegacyPastePopupMenu(Context paramContext, View paramView, PastePopupMenu$PastePopupMenuDelegate paramPastePopupMenu$PastePopupMenuDelegate) {
    this.mParent = paramView;
    this.mDelegate = paramPastePopupMenu$PastePopupMenuDelegate;
    this.mContext = paramContext;
    this.mContainer = new PopupWindow(this.mContext, null, 16843464);
    this.mContainer.setSplitTouchEnabled(true);
    this.mContainer.setClippingEnabled(false);
    this.mContainer.setAnimationStyle(0);
    this.mContainer.setWidth(-2);
    this.mContainer.setHeight(-2);
    TypedArray typedArray = this.mContext.getTheme().obtainStyledAttributes(new int[] { 16843540 });
    this.mPasteViewLayout = typedArray.getResourceId(typedArray.getIndex(0), 0);
    typedArray.recycle();
    this.mLineOffsetY = (int)TypedValue.applyDimension(1, 5.0F, this.mContext.getResources().getDisplayMetrics());
    this.mWidthOffsetX = (int)TypedValue.applyDimension(1, 30.0F, this.mContext.getResources().getDisplayMetrics());
    int i = BuildHooksAndroid.getIdentifier(this.mContext.getResources(), "status_bar_height", "dimen", "android");
    if (i > 0)
      this.mStatusBarHeight = this.mContext.getResources().getDimensionPixelSize(i); 
  }
  
  public final void hide() {
    this.mContainer.dismiss();
  }
  
  public final void onClick(View paramView) {
    this.mDelegate.paste();
    this.mContainer.dismiss();
  }
  
  public final void show(Rect paramRect) {
    this.mContainer.dismiss();
    if (this.mPasteView == null) {
      LayoutInflater layoutInflater = (LayoutInflater)this.mContext.getSystemService("layout_inflater");
      if (layoutInflater != null)
        this.mPasteView = layoutInflater.inflate(this.mPasteViewLayout, null); 
      if (this.mPasteView != null) {
        int k = View.MeasureSpec.makeMeasureSpec(0, 0);
        this.mPasteView.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        this.mPasteView.measure(k, k);
        this.mPasteView.setOnClickListener(this);
      } else {
        throw new IllegalArgumentException("Unable to inflate TextEdit paste window");
      } 
    } 
    this.mContainer.setContentView(this.mPasteView);
    int j = paramRect.left;
    int i = paramRect.bottom;
    if (this.mRawPositionX != j || this.mRawPositionY != i) {
      this.mRawPositionX = j;
      this.mRawPositionY = i;
      View view = this.mContainer.getContentView();
      int m = view.getMeasuredWidth();
      int i1 = view.getMeasuredHeight();
      int n = (int)(j - m / 2.0F);
      int k = i - i1 - this.mLineOffsetY;
      if (this.mParent.getSystemUiVisibility() == 0) {
        i = this.mStatusBarHeight;
      } else {
        i = 0;
      } 
      int i2 = (this.mContext.getResources().getDisplayMetrics()).widthPixels;
      if (k < i) {
        k = k + i1 + this.mLineOffsetY;
        i = this.mWidthOffsetX / 2;
        if (j + m < i2) {
          i = n + i + m / 2;
        } else {
          i = n - i + m / 2;
        } 
      } else {
        i = Math.min(i2 - m, Math.max(0, n));
      } 
      int[] arrayOfInt = new int[2];
      this.mParent.getLocationInWindow(arrayOfInt);
      j = arrayOfInt[0];
      m = arrayOfInt[1];
      this.mContainer.showAtLocation(this.mParent, 0, i + j, k + m);
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\content\browser\selection\LegacyPastePopupMenu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */