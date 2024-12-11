package fr.univavignon.pokedex.api;

import java.util.Random;

/**
 * Class that implements IPokemonFactory
 */
public class PokemonFactory implements IPokemonFactory {
    /**
     * Add constructor to not use de default one
     */
    public PokemonFactory () {
    }
    PokemonMetadataProvider pokemonMetadataProvider = new PokemonMetadataProvider();

    /**
     * Create a new pokemon
     * @param index Pokemon index.
     * @param cp Pokemon CP.
     * @param hp Pokemon HP.
     * @param dust Required dust for upgrading pokemon.
     * @param candy Required candy for upgrading pokemon.
     * @return new Pokemon
     */
    @Override
    public Pokemon createPokemon(int index, int cp, int hp, int dust, int candy) {
        //PokemonMetadataProvider.addPokemonMetadata(5);
        PokemonMetadata p = PokemonMetadataProvider.pokemonMetadata.get(5);
        Random random = new Random();
        double att = random.nextInt(15);
        System.out.println(att);
        double def = random.nextInt(15);
        System.out.println(def);
        double stam = random.nextInt(15);
        System.out.println(stam);
        double iv = ((att+def+stam)/45)*100;

        return new Pokemon(index,p.getName(),p.getAttack()+(int) att,p.getDefense()+ (int) def,p.getStamina()+(int) stam,cp,hp,dust,candy,iv);
    }


}
