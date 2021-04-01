package com.gildedrose;

public class BackstagePassQuantityUpdater extends ItemUpdater {
    @Override
    int calculateQuality(Item item) {
        if (item.sellIn < 0) {
            return 0;
        }

        int newQuality = super.calculateQuality(item);

        if (item.sellIn < 10 && newQuality < 50) {
           newQuality = newQuality + multiple;
        }

        if (item.sellIn < 5 && newQuality < 50) {
            newQuality = newQuality + multiple;
        }

        return newQuality;
    }
}
