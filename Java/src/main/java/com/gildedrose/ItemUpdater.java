package com.gildedrose;

public class ItemUpdater {
    private final int multiple;

    public ItemUpdater() {
        multiple = 1;
    }

    public ItemUpdater(int multiple) {
        this.multiple = multiple;
    }

    int calculateQuality(Item item) {
        int newQuality = item.quality;
        if (newQuality > 0) {
            newQuality = newQuality + multiple;
        }

        if (item.sellIn < 0) {
            if (newQuality > 0) {
                newQuality = newQuality + multiple;
            }
        }
        return newQuality;
    }

    int calculateSellIn(Item item) {
        return item.sellIn - 1;
    }
}
