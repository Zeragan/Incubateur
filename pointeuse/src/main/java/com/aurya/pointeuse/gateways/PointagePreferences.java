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

    /**
     * Format d'affichage des dates, au format utilisé par la méthode {@link String#format(String, Object...)}.
     *
     * @return Format des dates.
     */
    String getDateFormat();

    /**
     * Format d'affichage des délais.
     *
     * @return Format des délais.
     */
    DelaiFormat getDelaiFormat();

    /**
     * {@code true} pour compter les secondes dans les calculs.
     *
     * @return Mode de précision.
     */
    boolean getPrecision();

    /**
     * Définit comment arrondir les résultats de calculs.
     *
     * @return Type d'arrondi des résultats de calculs.
     */
    Arrondi getArrondi();

    /**
     * Chaîne de caractère à insérer dans le fichier d'export pour séparer les valeurs (ex: ";").
     *
     * @return Séparateur.
     */
    String getExportSeparateur();

    /**
     * Destinataire de l'export de fichier. Suivant l'implémentation choisie, peut être une adresse email, une chaîne de connexion FTP ou autre.
     *
     * @return Le destinataire du fichier export.
     */
    String getExportDestinataire();

    /**
     * Temps minimum à effectuer sur une semaine complète de travail. En dessous, le contrat n'est pas rempli.
     *
     * @return Temps minimum requis par semaine.
     */
    int getTempsTravailMinimumParSemaineEnHeures();

    /**
     * Temps maximum à effectuer sur une semaine complète de travail. Au delà, les heures seront décomptées comme des heures supplémentaires.
     *
     * @return Temps maximum par semaine, hors heures supplémentaires.
     */
    int getTempsTravailMaximumParSemaineEnHeures();

}
