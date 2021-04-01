package com.gildedrose;

import java.util.HashMap;
import java.util.Map;

class GildedRose {
    private static final String DEFAULT = "Default";
    Item[] items;
    Map<String, ItemUpdater> itemsMap = new HashMap<>();

    public GildedRose(Item[] items) {
        this.items = items;
        itemsMap.put("Sulfuras, Hand of Ragnaros", new LegendaryUpdater());
        itemsMap.put("Conjured Mana Cake", new DecreaseQuantityUpdater(2));
        itemsMap.put("Aged Brie", new IncreaseQuantityUpdater());
        itemsMap.put("Backstage passes to a TAFKAL80ETC concert", new BackstagePassQuantityUpdater());
        itemsMap.put(DEFAULT, new DecreaseQuantityUpdater());
    }

    public void updateQuality() {
        for (Item item : items) {
            if (itemsMap.containsKey(item.name)) {
                item.sellIn = itemsMap.get(item.name).calculateSellIn(item);
                item.quality = itemsMap.get(item.name).calculateQuality(item);
            } else {
                item.sellIn = itemsMap.get(DEFAULT).calculateSellIn(item);
                item.quality = itemsMap.get(DEFAULT).calculateQuality(item);
            }
        }
    }
}