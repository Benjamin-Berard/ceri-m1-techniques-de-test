package fr.uniavignon.pokedex.api;

import fr.univavignon.pokedex.api.IPokemonMetadataProvider;
import fr.univavignon.pokedex.api.PokedexException;
import fr.univavignon.pokedex.api.PokemonMetadata;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class IPokemonMetadataProviderTest {

    @Mock
    IPokemonMetadataProvider pokemonMetadataProvider;

    @Mock
    PokemonMetadata pokemonMetadata;

    @Test
    void shouldReturnPokemonMetadataWhenGetPokemonMetadata() throws PokedexException {
        when(pokemonMetadataProvider.getPokemonMetadata(0)).thenReturn(pokemonMetadata);
        assertEquals(pokemonMetadata,pokemonMetadataProvider.getPokemonMetadata(0));
        verify(pokemonMetadataProvider).getPokemonMetadata(0);
    }

    @Test
    void shouldReturnPokedexExceptionWhenGetPoekmonMetadata() throws PokedexException {
        doThrow(new PokedexException("Invalid id")).when(pokemonMetadataProvider).getPokemonMetadata(152);
        assertThrows(PokedexException.class,()-> pokemonMetadataProvider.getPokemonMetadata(152));
        verify(pokemonMetadataProvider).getPokemonMetadata(152);

    }

    @Test
    void shouldReturnIntWhengetIndex() throws PokedexException{

        when(pokemonMetadata.getIndex()).thenReturn(0);
        when(pokemonMetadataProvider.getPokemonMetadata(0)).thenReturn(pokemonMetadata);
        assertEquals(0, pokemonMetadataProvider.getPokemonMetadata(0).getIndex());
        verify(pokemonMetadataProvider).getPokemonMetadata(0);

    }




}
