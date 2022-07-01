package android.support.v4.view;

import android.support.compat.R;
import android.view.View;
import android.view.ViewGroup;

class ViewGroupCompat$ViewGroupCompatBaseImpl {
  public boolean isTransitionGroup(ViewGroup paramViewGroup) {
    Boolean bool = (Boolean)paramViewGroup.getTag(R.id.tag_transition_group);
    return ((bool != null && bool.booleanValue()) || paramViewGroup.getBackground() != null || ViewCompat.getTransitionName((View)paramViewGroup) != null);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\android\support\v4\view\ViewGroupCompat$ViewGroupCompatBaseImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */