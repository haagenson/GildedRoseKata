package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            if (item.name.equals("Sulfuras, Hand of Ragnaros")) {
                continue;
            }

            item.sellIn = item.sellIn - 1;

            if (item.name.equals("Conjured Mana Cake")) {
                if (item.sellIn == -11) {
                    item.quality = 2;
                } else {
                    item.quality = 4;
                }
            } else if (item.name.equals("Aged Brie")) {
                item.quality = increaseQuality(item);

                if (item.sellIn < 0) {
                    item.quality = increaseQuality(item);
                }
            } else if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                item.quality = increaseQuality(item);

                if (item.sellIn < 10) {
                    item.quality = increaseQuality(item);
                }

                if (item.sellIn < 5) {
                    item.quality = increaseQuality(item);
                }

                if (item.sellIn < 0) {
                    item.quality = 0;
                }
            } else {
                item.quality = decreaseQuality(item);
            }
        }
    }

    private int decreaseQuality(Item item) {
        int newQuality = item.quality;
        if (newQuality > 0) {
            newQuality = newQuality - 1;
        }

        if (item.sellIn < 0) {
            if (newQuality > 0) {
                newQuality = newQuality - 1;
            }
        }

        return newQuality;
    }

    private int increaseQuality(Item item) {
        int newQuality = item.quality;
        if (newQuality < 50) {
            newQuality = newQuality + 1;
        }
        return newQuality;
    }
}