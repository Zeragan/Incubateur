package com.aurya.pointeuse.interactors.boundaries.in;

import java.util.Date;

import com.aurya.communs.boundaries.in.InBoundary;

public interface PointageIn extends InBoundary
{

    void pointer();

    void listerJour(Date date);

    void listerSemaine(Date date);

    void listerMois(Date date);

    void listerAnnee(Date date);

    void modifier(long id, Date debut, Date fin, String commentaire);

    void modifierPointage(long id, Date debut, Date fin);

    void modifierDebut(long id, Date debut);

    void modifierFin(long id, Date fin);

    void modifierCommentaire(long id, String commentaire);

    void exporter();

}
