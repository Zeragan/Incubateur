package com.aurya.communs.entities;

import com.aurya.communs.R;

public abstract class Entity<T>
{

    private T id = null;

    public T getId()
    {
        return id;
    }

    public void setId(T id)
    {
        if (this.id != null)
        {
            throw new IllegalStateException(R.get("erreur1"));
        }
        this.id = id;
    }

    public abstract String getErrorMessage();

}
