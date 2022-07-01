package com.bumptech.glide.load.engine;

final class CallbackException extends RuntimeException {
  CallbackException(Throwable paramThrowable) {
    super("Unexpected exception thrown by non-Glide code", paramThrowable);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bumptech\glide\load\engine\CallbackException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */