package android.support.v7.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v7.appcompat.R;
import android.util.AttributeSet;
import android.view.View;

final class ActionMenuPresenter$OverflowMenuButton extends AppCompatImageView implements ActionMenuView$ActionMenuChildView {
  public ActionMenuPresenter$OverflowMenuButton(Context paramContext) {
    super(paramContext, (AttributeSet)null, R.attr.actionOverflowButtonStyle);
    setClickable(true);
    setFocusable(true);
    setVisibility(0);
    setEnabled(true);
    TooltipCompat.setTooltipText((View)this, getContentDescription());
    setOnTouchListener(new ActionMenuPresenter$OverflowMenuButton$1(this, (View)this));
  }
  
  public final boolean needsDividerAfter() {
    return false;
  }
  
  public final boolean needsDividerBefore() {
    return false;
  }
  
  public final boolean performClick() {
    if (super.performClick())
      return true; 
    playSoundEffect(0);
    ActionMenuPresenter.this.showOverflowMenu();
    return true;
  }
  
  protected final boolean setFrame(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    boolean bool = super.setFrame(paramInt1, paramInt2, paramInt3, paramInt4);
    Drawable drawable1 = getDrawable();
    Drawable drawable2 = getBackground();
    if (drawable1 != null && drawable2 != null) {
      int i = getWidth();
      paramInt2 = getHeight();
      paramInt1 = Math.max(i, paramInt2) / 2;
      int j = getPaddingLeft();
      int k = getPaddingRight();
      paramInt3 = getPaddingTop();
      paramInt4 = getPaddingBottom();
      i = (i + j - k) / 2;
      paramInt2 = (paramInt2 + paramInt3 - paramInt4) / 2;
      DrawableCompat.setHotspotBounds(drawable2, i - paramInt1, paramInt2 - paramInt1, i + paramInt1, paramInt2 + paramInt1);
    } 
    return bool;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\android\support\v7\widget\ActionMenuPresenter$OverflowMenuButton.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */