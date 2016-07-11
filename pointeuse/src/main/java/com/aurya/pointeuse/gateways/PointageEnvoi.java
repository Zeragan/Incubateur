package com.aurya.pointeuse.gateways;

import com.aurya.communs.gateways.External;

public interface PointageEnvoi extends External
{

    void envoyer(String destinataire, String sujet, String corps, String nomFichier, byte[] pieceJointe);

}
