package com.aurya.communs.entities;

public abstract class Entity
{

    private Long id = null;

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        if (this.id != null)
        {
            throw new IllegalStateException("Une entité ne peut pas changer d'identifiant");
        }
        this.id = id;
    }

}
