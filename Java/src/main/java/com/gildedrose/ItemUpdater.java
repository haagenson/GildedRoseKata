package com.gildedrose;

public abstract class ItemUpdater {
    abstract int calculateQuality(Item item);
    int calculateSellIn(Item item) {
        return item.sellIn - 1;
    }
}
