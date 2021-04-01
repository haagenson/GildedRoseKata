package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    @Test
    public void update_decreasesQualityForBasicItem() {
        Item[] items = new Item[] {
                new Item("+5 Dexterity Vest", 10, 20) };

        GildedRose gildedRose = new GildedRose(items);
        gildedRose.updateQuality();
        assertEquals(19, gildedRose.items[0].quality);
    }

    @Test
    public void update_decreasesSellInForBasicItem() {
        Item[] items = new Item[] {
                new Item("+5 Dexterity Vest", 10, 20) };

        GildedRose gildedRose = new GildedRose(items);
        gildedRose.updateQuality();
        assertEquals(9, gildedRose.items[0].sellIn);
    }

    @Test
    public void update_doesNotDecreaseZeroQualityItem() {
        Item[] items = new Item[] {
                new Item("+5 Dexterity Vest", 10, 0) };

        GildedRose gildedRose = new GildedRose(items);
        gildedRose.updateQuality();
        assertEquals(0, gildedRose.items[0].quality);
    }

    @Test
    public void update_decreasesQualityTwiceAsFastAfterSellInIsNegativeForBasicItem() {
        Item[] items = new Item[] {
                new Item("+5 Dexterity Vest", 0, 20) };

        GildedRose gildedRose = new GildedRose(items);
        gildedRose.updateQuality();
        assertEquals(18, gildedRose.items[0].quality);
    }

    @Test
    public void update_doesNotDecreaseBelowZeroForItemPastSellIn() {
        Item[] items = new Item[] {
                new Item("+5 Dexterity Vest", -10, 1) };

        GildedRose gildedRose = new GildedRose(items);
        gildedRose.updateQuality();
        assertEquals(0, gildedRose.items[0].quality);
    }

    @Test
    public void update_increasesQualityForAgedBrie() {
        Item[] items = new Item[] {
                new Item("Aged Brie", 2, 0) };

        GildedRose gildedRose = new GildedRose(items);
        gildedRose.updateQuality();
        assertEquals(1, gildedRose.items[0].quality);
    }

    @Test
    public void update_increasesQualityTwiceAsFastAfterSellInIsNegativeForAgedBrie() {
        Item[] items = new Item[] {
                new Item("Aged Brie", -10, 0) };

        GildedRose gildedRose = new GildedRose(items);
        gildedRose.updateQuality();
        assertEquals(2, gildedRose.items[0].quality);
    }

    @Test
    public void update_doesNotIncreaseQualityAbove50() {
        Item[] items = new Item[] {
                new Item("Aged Brie", -10, 49) };

        GildedRose gildedRose = new GildedRose(items);
        gildedRose.updateQuality();
        assertEquals(50, gildedRose.items[0].quality);
    }

    @Test
    public void update_doesNotChangeSellinForSulfuras() {
        Item[] items = new Item[] {
                new Item("Sulfuras, Hand of Ragnaros", 0, 80) };

        GildedRose gildedRose = new GildedRose(items);
        gildedRose.updateQuality();
        assertEquals(0, gildedRose.items[0].sellIn);
    }

    @Test
    public void update_doesNotChangeQualityForSulfuras() {
        Item[] items = new Item[] {
                new Item("Sulfuras, Hand of Ragnaros", 0, 80) };

        GildedRose gildedRose = new GildedRose(items);
        gildedRose.updateQuality();
        assertEquals(80, gildedRose.items[0].quality);
    }

    @Test
    public void update_increasesQualityForBackstagePassesGreaterThan10DaysOut() {
        Item[] items = new Item[] {
                new Item("Backstage passes to a TAFKAL80ETC concert", 11, 20) };

        GildedRose gildedRose = new GildedRose(items);
        gildedRose.updateQuality();
        assertEquals(21, gildedRose.items[0].quality);
    }

    @Test
    public void update_increasesQualityByTwoForBackstagePasses10DaysOut() {
        Item[] items = new Item[] {
                new Item("Backstage passes to a TAFKAL80ETC concert", 10, 20) };

        GildedRose gildedRose = new GildedRose(items);
        gildedRose.updateQuality();
        assertEquals(22, gildedRose.items[0].quality);
    }

    @Test
    public void update_increasesQualityByThreeForBackstagePasses5DaysOut() {
        Item[] items = new Item[] {
                new Item("Backstage passes to a TAFKAL80ETC concert", 5, 20) };

        GildedRose gildedRose = new GildedRose(items);
        gildedRose.updateQuality();
        assertEquals(23, gildedRose.items[0].quality);
    }

    @Test
    public void update_changesQualityToZeroForBackstagePassesAfterTheConcert() {
        Item[] items = new Item[] {
                new Item("Backstage passes to a TAFKAL80ETC concert", 0, 20) };

        GildedRose gildedRose = new GildedRose(items);
        gildedRose.updateQuality();
        assertEquals(0, gildedRose.items[0].quality);
    }

    @Test
    public void update_decreasesQualityByTwoForConjuredItems() {
        Item[] items = new Item[] {
                new Item("Conjured Mana Cake", 3, 6) };

        GildedRose gildedRose = new GildedRose(items);
        gildedRose.updateQuality();
        assertEquals(4, gildedRose.items[0].quality);
    }

    @Test
    public void update_decreasesQualityByFourForConjuredItemsPastTheSellInDate() {
        Item[] items = new Item[] {
                new Item("Conjured Mana Cake", -10, 6) };

        GildedRose gildedRose = new GildedRose(items);
        gildedRose.updateQuality();
        assertEquals(2, gildedRose.items[0].quality);
    }

    @Test
    public void update_decreasesQualityTwiceAsFastAfterSellGoesNegativeForConjuredItems() {
        Item[] items = new Item[] {
                new Item("Conjured Mana Cake", 0, 6) };

        GildedRose gildedRose = new GildedRose(items);
        gildedRose.updateQuality();
        assertEquals(2, gildedRose.items[0].quality);
    }

}
