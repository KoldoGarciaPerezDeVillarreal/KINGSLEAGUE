SELECT E.NOMBRE "EQUIPO", SUM(PL.GOLES) AS "GOLES FAVOR", SUM(PV.GOLES) AS 
"GOLES CONTRA", SUM(PL.GOLES) - SUM(PV.GOLES) AS "DIFERENCIA DE GOLES",
COUNT(P.ID_EQUIPO_GANADOR) "Nº VICTORIAS"
FROM PARTIDOS P, PARTIDOS_LOCALES PL, PARTIDOS_VISITANTES PV, EQUIPOS E
WHERE E.ID_EQUIPO IN (PL.ID_EQUIPO,PV.ID_EQUIPO)
AND E.ID_EQUIPO = P.ID_EQUIPO_GANADOR AND P.ID_PARTIDO = PL.ID_PARTIDO
AND P.ID_PARTIDO = PV.ID_PARTIDO
GROUP BY E.NOMBRE
ORDER BY COUNT(P.ID_EQUIPO_GANADOR) DESC;
