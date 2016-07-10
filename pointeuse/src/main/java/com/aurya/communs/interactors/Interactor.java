package com.aurya.communs.interactors;

import com.aurya.communs.boundaries.in.InBoundary;
import com.aurya.communs.boundaries.out.OutBoundary;

public abstract class Interactor<T extends OutBoundary> implements InBoundary
{

    protected final T out;

    public Interactor(T out)
    {
        this.out = out;
    }

}
