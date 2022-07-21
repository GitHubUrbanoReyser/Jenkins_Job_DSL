#!/bin/bash
nombre=”Jenkins”
#Empezar el loop
for a in 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15
do
    # if a es igual a 8 que el loop descanse
    if [ $a == 8 ]
    then
      sleep 15
      echo “A descansar de clase $nombre”
    fi
    echo "Clase Nº $a"
done
sleep 5
echo "Bien $nombre, terminamos las clases de $curso en $idioma.."
