package com.aurya.pointeuse.entities;

import java.util.Date;

import com.aurya.communs.entities.Entity;

public class Pointage extends Entity<Long>
{

    private Date debut;

    private Date fin = null;

    private String commentaire;

    public Pointage(Date debut)
    {
        this.debut = debut;
    }

    public Date getDebut()
    {
        return debut;
    }

    public void setDebut(Date debut)
    {
        this.debut = debut;
    }

    public Date getFin()
    {
        return fin;
    }

    public void setFin(Date fin)
    {
        this.fin = fin;
    }

    public String getCommentaire()
    {
        return commentaire;
    }

    public void setCommentaire(String commentaire)
    {
        this.commentaire = commentaire;
    }

    @Override
    public String getErrorMessage()
    {
        if (debut == null)
        {
            return "La date de début du pointage doit être renseignée";
        }
        if (debut.after(fin))
        {
            return "La date de fin du pointage doit être supérieure à la date de début";
        }
        return null;
    }

}
