package android.support.v4.app;

final class FragmentManagerImpl$2$1 implements Runnable {
  public final void run() {
    container.endViewTransition(viewToAnimate);
    if (fragment.getAnimatingAway() != null) {
      fragment.setAnimatingAway(null);
      this.this$1.this$0.moveToState(fragment, fragment.getStateAfterAnimating(), 0, 0, false);
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\android\support\v4\app\FragmentManagerImpl$2$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */