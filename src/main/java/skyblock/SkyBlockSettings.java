package skyblock;

import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;
//import carpet.annotation.BugFix;
import carpet.settings.ParsedRule;
import carpet.settings.Rule;
import carpet.settings.Validator;

import static carpet.settings.RuleCategory.*;

public class SkyBlockSettings {
    /*@Rule(
        category = {EXPERIMENTAL, FEATURE},
        validate = BetterPotionListener.class
    )*/
    public static boolean betterPotions = false;

    /*@Rule(
        category = {EXPERIMENTAL, FEATURE},
        validate = WanderingTraderSkyblockTradesChange.class
    )*/
    public static boolean wanderingTraderSkyblockTrades = false;

    /*private static class WanderingTraderSkyblockTradesChange implements ChangeListener<Boolean> {
        @Override
        public void onChange(ParsedRule<Boolean> rule, Boolean previous) {
            if (wanderingTraderSkyblockTrades) {
                Trades.mergeWanderingTraderOffers(Trades.getSkyblockWanderingTraderOffers());
            } else {
                Trades.mergeWanderingTraderOffers(new Int2ObjectOpenHashMap<>());
            }
        }
    }*/

    /*@Rule(
        desc = "blockLightDetector"
    )*/
    public static boolean blockLightDetector = false;

    /*@Rule(
        bug = @BugFix("MC-93185"),
        category = FIX
    )*/
    public static boolean endPortalFix = true;
}
