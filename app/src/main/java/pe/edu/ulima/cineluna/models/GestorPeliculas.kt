package pe.edu.ulima.pm.swapp.models

import pe.edu.ulima.pm.swapp.models.beans.Peliculas

class GestorPeliculas {
    fun obtenerListaPeliculas() : List<Peliculas> {
        return listOf(
            Peliculas("Dr. Strange 2", "15:00", "Sam Raimi!"),
            Peliculas("Top Gun 2", "17:00", "Del actor de misión imposible"),
            Peliculas("Detective Pikachu", "11:00", "Pokemon la película life action"),
            Peliculas("MORBIUS", "24:00", "La mejor película en la historia de la humanidad, su existencia prueba de que Martin Scorsese se equivoca sobre el cine de superheroes!!"),
        )
    }
}