package skyblock;

import com.google.common.collect.ImmutableMap;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.village.TradeOffers;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Trades {
    public static void mergeWanderingTraderOffers(Int2ObjectMap<TradeOffers.Factory[]> custom) {
        List<TradeOffers.Factory> tier1 = new ArrayList<>(Arrays.asList(SkyBlockRegistry.Trades.VANILLA_WANDERING_TRADER_OFFERS.get(1)));
        TradeOffers.Factory[] customTier1 = custom.get(1);
        if (customTier1 != null) tier1.addAll(Arrays.asList(customTier1));
        TradeOffers.WANDERING_TRADER_TRADES.put(1, tier1.toArray(new TradeOffers.Factory[0]));
        List<TradeOffers.Factory> tier2 = new ArrayList<>(Arrays.asList(SkyBlockRegistry.Trades.VANILLA_WANDERING_TRADER_OFFERS.get(2)));
        TradeOffers.Factory[] customTier2 = custom.get(2);
        if (customTier2 != null) tier2.addAll(Arrays.asList(customTier2));
        TradeOffers.WANDERING_TRADER_TRADES.put(2, tier2.toArray(new TradeOffers.Factory[0]));
    }

    //private static final Constructor<?> processItemFactoryConstructor;
    //private static final Constructor<?> sellItemFactoryConstructor;
    
    private static TradeOffers.Factory newProcessItemFactory(Item item, int secondCount, int price, Item sellItem, int sellCount, int maxUses) {
        return new TradeOffers.SellItemFactory(new ItemStack(item), price, 1, maxUses, 1, 0.05f);
    }

    private static TradeOffers.Factory newSellItemFactory(Item item, int price, int count, int maxUses) {
        return new TradeOffers.SellItemFactory(new ItemStack(item), price, 1, maxUses, 1, 0.05f);
    }

    static {
        List<TradeOffers.Factory> tier1Trades = new ArrayList<>(Arrays.asList(TradeOffers.WANDERING_TRADER_TRADES.get(1)));
        List<TradeOffers.Factory> tier2Trades = new ArrayList<>(Arrays.asList(TradeOffers.WANDERING_TRADER_TRADES.get(2)));

        tier1Trades.addAll(
            Arrays.asList(
            // Duplicatable after one trade
                newSellItemFactory(Items.CHORUS_FLOWER, 5, 1, 12),
                newSellItemFactory(Items.NETHER_WART, 5, 1, 12),
                newSellItemFactory(Items.SWEET_BERRIES, 5, 1, 12),
                newSellItemFactory(Items.SUNFLOWER, 5, 1, 12),
                newSellItemFactory(Items.LILAC, 5, 1, 12),
                newSellItemFactory(Items.ROSE_BUSH, 5, 1, 12),
                newSellItemFactory(Items.PEONY, 5, 1, 12),
                newSellItemFactory(Items.COCOA_BEANS, 5, 1, 12)
        ));

        tier2Trades.addAll(
            Arrays.asList(
            // Tier 2 Trades
                newProcessItemFactory(Items.BUCKET, 1, 16, Items.LAVA_BUCKET, 1, 1),
                newSellItemFactory(Items.HEART_OF_THE_SEA, 64, 1, 2)
        ));
    }
}
// Removed Crimson Nylium,  Warped Nylium and Jukebox.
// Now you need a Bucket to buy a Lava Bucket.