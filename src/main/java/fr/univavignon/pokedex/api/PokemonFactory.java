package fr.univavignon.pokedex.api;

import java.util.Random;

public class PokemonFactory implements IPokemonFactory{
    PokemonMetadataProvider pokemonMetadataProvider= new PokemonMetadataProvider();

    @Override
    public Pokemon createPokemon(int index, int cp, int hp, int dust, int candy) {
        PokemonMetadata p = PokemonMetadataProvider.pokemonMetadata.get(index);
        Random random = new Random();
        int iv = random.nextInt(101);
        return new Pokemon(index,p.getName(),p.getAttack(),p.getDefense(),p.getStamina(),cp,hp,dust,candy,iv);
    }
}
