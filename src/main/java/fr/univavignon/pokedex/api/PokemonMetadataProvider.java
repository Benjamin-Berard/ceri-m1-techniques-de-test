package fr.univavignon.pokedex.api;

import java.util.ArrayList;
import java.util.List;

public  class PokemonMetadataProvider implements  IPokemonMetadataProvider{
    static List<PokemonMetadata> pokemonMetadata = new ArrayList<>();
    PokemonMetadata pokemondata = new PokemonMetadata(0,"Bulbizarre",126,126,90);
    public PokemonMetadataProvider(){
        pokemonMetadata.add(pokemondata);
    }


    @Override
    public PokemonMetadata getPokemonMetadata(int index) throws PokedexException {

        if(index > pokemonMetadata.size()-1) throw new PokedexException("invalid id");
        return pokemonMetadata.get(index);

    }

    public static void setPokemonMetadata(List<PokemonMetadata> pokemonMetadata) {
        PokemonMetadataProvider.pokemonMetadata = pokemonMetadata;
    }

    public static void addPokemonMetadata(int index){
        //Pour les tests
        pokemonMetadata.add(new PokemonMetadata(index,"salameche",130,130,200));
    }

    public static List<PokemonMetadata> getPokemonMetadata() {
        return pokemonMetadata;
    }
}
