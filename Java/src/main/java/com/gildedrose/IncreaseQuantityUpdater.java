package com.gildedrose;

public class IncreaseQuantityUpdater extends ItemUpdater {
    @Override
    int calculateQuality(Item item) {
        int newQuality = increaseQuality(item.quality);

        if (item.sellIn < 0) {
            newQuality = increaseQuality(newQuality);
        }

        return newQuality;
    }

    protected int increaseQuality(int quality) {
        if (quality < 50) {
            quality = quality + 1;
        }
        return quality;
    }
}
