package fr.uniavignon.pokedex.api;

import fr.univavignon.pokedex.api.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
@ExtendWith(MockitoExtension.class)
public class IPokedexFactoryTest {

    @Mock
    private IPokedexFactory pokedexFactory;
    private IPokemonMetadataProvider pokemonMetadataProvider;
    private IPokemonFactory pokemonFactory;
    private IPokedex pokedex;


    @Test
    public void shouldReturnIPokedexWhenCreatePokedex() throws Exception {
        when(pokedexFactory.createPokedex(pokemonMetadataProvider,pokemonFactory)).thenReturn(pokedex);
        assertEquals(pokedex,pokedexFactory.createPokedex(pokemonMetadataProvider,pokemonFactory));
    }

}
