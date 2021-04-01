package com.gildedrose;

public class ItemUpdater {
    protected final int multiple;

    public ItemUpdater() {
        multiple = 1;
    }

    public ItemUpdater(int multiple) {
        this.multiple = multiple;
    }

    int calculateQuality(Item item) {
        int newQuality = item.quality;
        newQuality = newQuality + multiple;

        if (item.sellIn < 0) {
            newQuality = newQuality + multiple;
        }

        if (newQuality < 0) {
            newQuality = 0;
        } else if (newQuality > 50) {
            newQuality = 50;
        }

        return newQuality;
    }

    int calculateSellIn(Item item) {
        return item.sellIn - 1;
    }
}
