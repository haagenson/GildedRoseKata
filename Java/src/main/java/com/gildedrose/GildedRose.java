package com.gildedrose;

import java.util.HashMap;
import java.util.Map;

class GildedRose {
    private static final String DEFAULT = "Default";
    ItemUpdater defaultUpdater = new ItemUpdater(-1);
    Item[] items;
    Map<String, ItemUpdater> itemsMap = new HashMap<>();

    public GildedRose(Item[] items) {
        this.items = items;
        itemsMap.put("Sulfuras, Hand of Ragnaros", new LegendaryUpdater());
        itemsMap.put("Conjured Mana Cake", new ItemUpdater(-2));
        itemsMap.put("Aged Brie", new IncreaseQuantityUpdater());
        itemsMap.put("Backstage passes to a TAFKAL80ETC concert", new BackstagePassQuantityUpdater());
    }

    public void updateQuality() {
        for (Item item : items) {
            item.sellIn = itemsMap.getOrDefault(item.name, defaultUpdater).calculateSellIn(item);
            item.quality = itemsMap.getOrDefault(item.name, defaultUpdater).calculateQuality(item);
        }
    }
}