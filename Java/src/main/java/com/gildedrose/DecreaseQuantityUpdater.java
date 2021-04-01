package com.gildedrose;

public class DecreaseQuantityUpdater extends ItemUpdater {
    private final int multiple;

    public DecreaseQuantityUpdater() {
        multiple = 1;
    }

    public DecreaseQuantityUpdater(int multiple) {
        this.multiple = multiple;
    }

    @Override
    int calculateQuality(Item item) {
        int newQuality = item.quality;
        if (newQuality > 0) {
            newQuality = newQuality - multiple;
        }

        if (item.sellIn < 0) {
            if (newQuality > 0) {
                newQuality = newQuality - multiple;
            }
        }
        return newQuality;
    }
}
