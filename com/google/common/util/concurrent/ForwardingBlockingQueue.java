package com.google.common.util.concurrent;

import com.google.common.collect.ForwardingQueue;
import java.util.concurrent.BlockingQueue;

public abstract class ForwardingBlockingQueue<E> extends ForwardingQueue<E> implements BlockingQueue<E> {}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\commo\\util\concurrent\ForwardingBlockingQueue.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */