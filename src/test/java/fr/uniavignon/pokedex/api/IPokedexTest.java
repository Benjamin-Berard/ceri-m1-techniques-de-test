
package fr.uniavignon.pokedex.api;

import fr.univavignon.pokedex.api.IPokedex;
import fr.univavignon.pokedex.api.PokedexException;
import fr.univavignon.pokedex.api.Pokemon;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class IPokedexTest {
    @Mock
    IPokedex pokedex;

    Pokemon pokemon;

    @BeforeEach
    void setup(){
        pokemon = new Pokemon(0,"Bulbizarre",126,126,90,613,64,4000,4,56);
    }
    @Test
    void shouldAddPokemonInListWhenAddPokemon(){
        when(pokedex.addPokemon(pokemon)).thenReturn(0);
        when(pokedex.size()).thenReturn(1);
        assertEquals(0, pokedex.addPokemon(pokemon));
        assertEquals(1, pokedex.size());

        verify(pokedex).addPokemon(pokemon);
        verify(pokedex).size();
    }

    @Test
    void shouldReturnThePokemonWhenGetPokemon() throws PokedexException {
        when(pokedex.getPokemon(0)).thenReturn(pokemon);
        assertEquals(pokemon, pokedex.getPokemon(0));
        verify(pokedex).getPokemon(0);
    }

    @Test
    void shouldThrowPokedexExceptionWhenInvalidId() throws PokedexException{
        doThrow(new PokedexException("Invalid id")).when(pokedex).getPokemon(152);
        assertThrows(PokedexException.class,()-> pokedex.getPokemon(152));
        verify(pokedex).getPokemon(152);
    }

    @Test
    void shouldReturnPokemonListWhenGetPokemons() {

        List<Pokemon> pokemonList = new ArrayList<>();
        pokemonList.add(pokemon);
        pokemonList.add(new Pokemon(133,"Aquali",186,168,260,2729,202,5000,4,100));
        when(pokedex.getPokemons()).thenReturn(pokemonList);
        assertEquals(pokemonList,pokedex.getPokemons());
        assertEquals(2,pokemonList.size());
        verify(pokedex).getPokemons();
    }

}
