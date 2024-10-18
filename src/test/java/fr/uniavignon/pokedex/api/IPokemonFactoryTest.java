package fr.uniavignon.pokedex.api;

import fr.univavignon.pokedex.api.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class IPokemonFactoryTest {
    @Mock
    private IPokemonFactory pokemonFactory;
    private Pokemon pokedemon;


    @Test
    public void shouldReturnIPokedexWhenCreatePokedex() {
        when(pokemonFactory.createPokemon(1,500,200,2,1)).thenReturn(pokedemon);
        assertEquals(pokedemon,pokemonFactory.createPokemon(1,500,200,2,1));
    }
}
