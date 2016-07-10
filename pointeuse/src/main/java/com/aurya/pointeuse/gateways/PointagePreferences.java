package com.aurya.pointeuse.gateways;

import com.aurya.communs.gateways.Preferences;

public interface PointagePreferences extends Preferences
{

    public enum Arrondi
    {
        AUCUN, _10_MINUTES, _15_MINUTES, _30_MINUTES, _1HEURE
    }

    public enum DelaiFormat
    {
        JOUR_HEURE_MINUTE, HEURE_MINUTE, DIXIEME_HEURE
    }

    String getDateFormat();

    DelaiFormat getDelaiFormat();

    boolean getPrecision();

    Arrondi getArrondi();

    String getExportSeparateur();

}
