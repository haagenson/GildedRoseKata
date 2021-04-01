package com.gildedrose;

public class BackstagePassQuantityUpdater extends IncreaseQuantityUpdater {
    @Override
    int calculateQuality(Item item) {
        if (item.sellIn < 0) {
            return 0;
        }

        int newQuality = super.calculateQuality(item);

        if (item.sellIn < 10) {
            newQuality = increaseQuality(newQuality);
        }

        if (item.sellIn < 5) {
            newQuality = increaseQuality(newQuality);
        }

        return newQuality;
    }
}
