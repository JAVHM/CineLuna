package pe.edu.ulima.pm.swapp.models

import pe.edu.ulima.pm.swapp.models.beans.Peliculas

class GestorPeliculas {
    fun obtenerListaPlanetas() : List<Peliculas> {
        return listOf(
            Peliculas("Dr. Strange 2", "desert", "Sam Raimi!"),
            Peliculas("Top Gun 2", "grasslands, mountains", "Del actor de misión imposible"),
            Peliculas("Detective Pikachu", "jungle, rainforests", "Pokemon la película life action"),
            Peliculas("MORBIUS", "00:00", "La mejor película en la historia de la humanidad, su existencia prueba de que Martin Scorsese se equivoca sobre el cine de superheroes!!"),
        )
    }
}