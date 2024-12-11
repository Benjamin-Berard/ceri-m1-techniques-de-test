package fr.univavignon.pokedex.api;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Class that implements IPokedex
 */
public class Pokedex implements IPokedex {
    List<Pokemon> pokemons = new ArrayList<>();
    PokemonFactory pokemonFactory;
    PokemonMetadataProvider pokemonMetadataProvider;

    RocketPokemonFactory rocketPokemonFactory;
    /**
     * Constructor for the Pokedex CLASS
     * @param pokemonFactory to initiate pokemonFactory
     * @param pokemonMetadataProvider to initiate pokemonMetadataProvider
     */
    public Pokedex(PokemonFactory pokemonFactory, PokemonMetadataProvider pokemonMetadataProvider) {
        this.pokemonFactory =  pokemonFactory;
        this.pokemonMetadataProvider = pokemonMetadataProvider;
    }

    /**
     * Redefine class to suits RocketPokemonFactory
     * @param pokemonFactory rocketpokemonfactory class
     * @param pokemonMetadataProvider pokemon metadataprovider class
     */
    public Pokedex(RocketPokemonFactory pokemonFactory, PokemonMetadataProvider pokemonMetadataProvider) {
        this.rocketPokemonFactory =  pokemonFactory;
        this.pokemonMetadataProvider = pokemonMetadataProvider;
    }


    @Override
    public int size() {
        return pokemons.size();
    }

    @Override
    public int addPokemon(Pokemon pokemon) {
        pokemons.add(pokemon);
        return pokemons.size() - 1;
    }

    @Override
    public Pokemon getPokemon(int id) throws PokedexException {
        for (Pokemon p : pokemons) {
            if (p.getIndex() == id) return p;
        }
        throw new PokedexException("no pokemon found");
    }

    @Override
    public List<Pokemon> getPokemons() {
        return pokemons;
    }

    @Override
    public List<Pokemon> getPokemons(Comparator<Pokemon> order) {
        List<Pokemon> sortedList = new ArrayList<>(pokemons);
        sortedList.sort(order);
        return sortedList;
    }

    @Override
    public Pokemon createPokemon(int index, int cp, int hp, int dust, int candy) {

        return pokemonFactory.createPokemon(index,cp,hp,dust,candy);
    }

    /**
     * creation of pokemon using rocketpokemonfactory
     * @param index the pokemon index
     * @param cp the pokemon cp
     * @param hp the pokemon hp
     * @param dust the pokemon dust
     * @param candy the pokemon candy
     * @return pokemon
     */
    public Pokemon createPokemon2(int index, int cp, int hp, int dust, int candy) {

        return rocketPokemonFactory.createPokemon(index,cp,hp,dust,candy);
    }


    @Override
    public PokemonMetadata getPokemonMetadata(int index) throws PokedexException {
        return pokemonMetadataProvider.getPokemonMetadata(index);

    }
}
