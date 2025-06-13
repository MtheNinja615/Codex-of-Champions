package net.mtheninja615.codex_of_champions.Registries;

import net.mtheninja615.codex_of_champions.CodexOfChampions;
import net.mtheninja615.codex_of_champions.spells.eldritch.PersonaBondSpell;
import net.mtheninja615.codex_of_champions.spells.ender.MissileSalvo;
import net.mtheninja615.codex_of_champions.spells.fire.FireCluster;
import net.mtheninja615.codex_of_champions.spells.nature.PetalStep;
import net.mtheninja615.codex_of_champions.spells.nature.SummonBogged;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import io.redspace.ironsspellbooks.api.spells.AbstractSpell;

import java.util.function.Supplier;

import static io.redspace.ironsspellbooks.api.registry.SpellRegistry.SPELL_REGISTRY_KEY;


public class SpellRegistries {
    public static final DeferredRegister<AbstractSpell> SPELLS = DeferredRegister.create(SPELL_REGISTRY_KEY, CodexOfChampions.MODID);

    public static Supplier<AbstractSpell> registerSpell(AbstractSpell spell) {
        return SPELLS.register(spell.getSpellName(), () -> spell);
    }
/***
 * * Archon (WIP NAME, Planned School All Currently Eldritch)
 */

//Persona Bond
public static final Supplier<AbstractSpell> PERSONA_BOND = registerSpell(new PersonaBondSpell());

/***
 * * Ender
 */

    //Missile Salvo
    public static final Supplier<AbstractSpell> MISSILE_SALVO = registerSpell(new MissileSalvo());

    /***
     * * Nature
     */

    //Petal Step
    public static final Supplier<AbstractSpell> PETAL_STEP = registerSpell(new PetalStep());
    //Summon Bogged
    public static final Supplier<AbstractSpell> SUMMON_BOGGED = registerSpell(new SummonBogged());
    /***
     * * Fire
     */
    //Petal Step
    public static final Supplier<AbstractSpell> FIRE_CLUSTER = registerSpell(new FireCluster());

    public static void register(IEventBus eventBus)
    {
        SPELLS.register(eventBus);
    }
}
