package com.aurya.communs.entities;

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
            throw new IllegalStateException("Une entité ne peut pas changer d'identifiant");
        }
        this.id = id;
    }

    public abstract String getErrorMessage();

}
