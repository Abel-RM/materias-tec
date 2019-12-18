
acompa�a(alejandro,benito).
acompa�a(juan,andres).

no_acompa�a(carlos,dario).

no_viaja(alejandro,coche).
no_viaja(benito,avion).
no_viaja(carlos,avion).

viaja(andres,avion).

pareja(X,Y):- acompa�a(X,Y); acompa�a(Y,X).


viaja_tren(X):-(   pareja(X,Y),(no_viaja(X,avion);no_viaja(Y,avion)),(no_viaja(X,coche);no_viaja(Y,coche)) ) ;viaja(X,tren);viaja(Y,tren).
viaja_avion(X):-(   pareja(X,Y),(no_viaja(X,tren);no_viaja(Y,tren)),(no_viaja(X,coche);no_viaja(Y,coche)) ) ;viaja(X,avion);viaja(Y,avion).
viaja_coche(X):-(   pareja(X,Y),(no_viaja(X,avion);no_viaja(Y,avion)),(no_viaja(X,tren);no_viaja(Y,tren)) ) ;viaja(X,coche);viaja(Y,coche).
