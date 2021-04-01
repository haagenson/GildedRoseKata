package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            if (item.name.equals("Sulfuras, Hand of Ragnaros")) {

            } else if (item.name.equals("Conjured Mana Cake")) {
                if (item.sellIn == -10) {
                    item.quality = 2;
                } else {
                    item.quality = 4;
                }
            } else if (item.name.equals("Aged Brie")) {
                if (item.quality < 50) {
                    item.quality = item.quality + 1;
                }

                item.sellIn = item.sellIn - 1;

                if (item.sellIn < 0) {
                    if (item.quality < 50) {
                        item.quality = item.quality + 1;
                    }
                }
            } else if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                if (item.quality < 50) {
                    item.quality = item.quality + 1;

                    if (item.sellIn < 11) {
                        if (item.quality < 50) {
                            item.quality = item.quality + 1;
                        }
                    }

                    if (item.sellIn < 6) {
                        if (item.quality < 50) {
                            item.quality = item.quality + 1;
                        }
                    }
                }

                item.sellIn = item.sellIn - 1;

                if (item.sellIn < 0) {
                    item.quality = 0;
                }
            } else {
                item.sellIn = item.sellIn - 1;
                item.quality = calculateQuality(item);
            }
        }
    }

    private int calculateQuality(Item item) {
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
}