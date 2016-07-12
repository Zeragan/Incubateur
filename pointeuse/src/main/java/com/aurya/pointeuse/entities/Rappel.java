package com.aurya.pointeuse.entities;

import com.aurya.communs.entities.Entity;

public class Rappel extends Entity<String>
{

    private String message;

    public Rappel(String message)
    {
        this.setMessage(message);
    }

    public String getMessage()
    {
        return message;
    }

    public void setMessage(String message)
    {
        this.message = message;
    }

    @Override
    public String getErrorMessage()
    {
        return null;
    }

}
