package fr.uniavignon.pokedex.api;

import fr.univavignon.pokedex.api.*;
import org.junit.jupiter.api.Test;
import java.util.Comparator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;



public class PokedexTest {

    PokemonMetadataProvider pokemonMetadataProvider = new PokemonMetadataProvider();
    PokemonFactory pokemonFactory = new PokemonFactory();
    Pokedex pokedex = new Pokedex(pokemonFactory,pokemonMetadataProvider);
    Pokemon pokemon = new Pokemon(0,"Bulbizarre",126,126,90,613,64,4000,4,56);
    Pokemon pokemon2 = new Pokemon(133,"Aquali",186,168,260,2729,202,5000,4,100);

@Test
    void shouldReturn1(){
        pokedex.addPokemon(pokemon);
        assertEquals(1,pokedex.size());
}

@Test
    void shouldReturn0(){
    assertEquals(0,pokedex.addPokemon(pokemon));
}
@Test
    void shouldReturnpokemon() throws PokedexException {
    pokedex.addPokemon(pokemon);
    assertEquals(pokemon,pokedex.getPokemon(0));
}
@Test
    void shouldReturnAquali() throws PokedexException {
    pokedex.addPokemon(pokemon);
    pokedex.addPokemon(pokemon2);
    assertEquals(pokemon2.getName(),pokedex.getPokemon(133).getName());
}

@Test
    void shouldReturnPokedexException(){
    assertThrows(PokedexException.class,()-> pokedex.getPokemon(152));
}

@Test
    void shouldReturnListOfPokemon(){
    pokedex.addPokemon(pokemon);
    pokedex.addPokemon(pokemon2);
    assertEquals(2,pokedex.getPokemons().size());
}

@Test
    void shouldReturnSortedList() throws PokedexException {
    pokedex.addPokemon(pokemon);
    pokedex.addPokemon(pokemon2);
    List<Pokemon> l = pokedex.getPokemons(Comparator.comparing(PokemonMetadata::getName));
    assertEquals("Aquali",l.get(0).getName());
}

@Test
    void shouldReturnPokemonInstance(){
    assertEquals("salameche",pokedex.createPokemon(5,500,20,2000,4).getName());
}

@Test
    void shouldReturnBulbizarreInstance() throws PokedexException {
    assertEquals(pokemon.getName(), pokedex.getPokemonMetadata(0).getName());
}
}
