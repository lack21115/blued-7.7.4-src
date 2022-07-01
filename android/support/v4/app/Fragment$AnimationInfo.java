package android.support.v4.app;

import android.animation.Animator;
import android.view.View;

final class Fragment$AnimationInfo {
  Boolean mAllowEnterTransitionOverlap;
  
  Boolean mAllowReturnTransitionOverlap;
  
  View mAnimatingAway;
  
  Animator mAnimator;
  
  Object mEnterTransition = null;
  
  SharedElementCallback mEnterTransitionCallback = null;
  
  boolean mEnterTransitionPostponed;
  
  Object mExitTransition = null;
  
  SharedElementCallback mExitTransitionCallback = null;
  
  boolean mIsHideReplaced;
  
  int mNextAnim;
  
  int mNextTransition;
  
  int mNextTransitionStyle;
  
  Object mReenterTransition = Fragment.USE_DEFAULT_TRANSITION;
  
  Object mReturnTransition = Fragment.USE_DEFAULT_TRANSITION;
  
  Object mSharedElementEnterTransition = null;
  
  Object mSharedElementReturnTransition = Fragment.USE_DEFAULT_TRANSITION;
  
  Fragment$OnStartEnterTransitionListener mStartEnterTransitionListener;
  
  int mStateAfterAnimating;
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\android\support\v4\app\Fragment$AnimationInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */