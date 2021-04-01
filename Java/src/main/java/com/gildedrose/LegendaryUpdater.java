package com.gildedrose;

public class LegendaryUpdater extends ItemUpdater {
    @Override
    public int calculateQuality(Item item) {
        return item.quality;
    }

    @Override
    public int calculateSellIn(Item item) {
        return item.sellIn;
    }
}
