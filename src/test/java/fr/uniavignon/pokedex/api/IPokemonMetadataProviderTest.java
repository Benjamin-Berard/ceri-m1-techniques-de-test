package fr.uniavignon.pokedex.api;
import fr.univavignon.pokedex.api.IPokemonMetadataProvider;
import fr.univavignon.pokedex.api.PokedexException;
import fr.univavignon.pokedex.api.PokemonMetadata;
import fr.univavignon.pokedex.api.PokemonMetadataProvider;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class IPokemonMetadataProviderTest {

    @Mock
    IPokemonMetadataProvider pokemonMetadataProvider;

    PokemonMetadataProvider pokemonMetadataProvider1 = new PokemonMetadataProvider();


    PokemonMetadata pokemonMetadata;
    PokemonMetadata pokemonMetadata1;
    List<PokemonMetadata> pokemonMetadataList = new ArrayList<>();
    @BeforeEach
    void setUp() {
        pokemonMetadata1 = new PokemonMetadata(1, "Aquali", 186, 168, 300);

        pokemonMetadata = new PokemonMetadata(0, "Bulbizarre", 126, 126, 90);
        pokemonMetadataList.add(pokemonMetadata);
        pokemonMetadataList.add(pokemonMetadata1);
    }
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
    void shouldReturnCorrectIndex() {
        assertEquals(0, pokemonMetadata.getIndex());
    }

    @Test
    void shouldReturnCorrectName() {
        assertEquals("Bulbizarre", pokemonMetadata.getName());
    }

    @Test
    void shouldReturnCorrectAttack() {
        assertEquals(126, pokemonMetadata.getAttack());
    }

    @Test
    void shouldReturnCorrectDefense() {
        assertEquals(126, pokemonMetadata.getDefense());
    }

    @Test
    void shouldReturnCorrectStamina() {
        assertEquals(90, pokemonMetadata.getStamina());
    }

    @Test
    void shouldReturnPokemonMetadataList(){
        assertEquals(1,PokemonMetadataProvider.getPokemonMetadata().size());
    }

    @Test
    void shouldReturn2(){
       PokemonMetadataProvider.setPokemonMetadata(pokemonMetadataList);
       assertEquals(2,PokemonMetadataProvider.getPokemonMetadata().size());
    }

}
