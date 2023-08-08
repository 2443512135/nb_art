package com.gildedrose;

import org.junit.jupiter.api.Test;

import static com.gildedrose.GildedRose.QUALITY_MAX_LIMIT;
import static com.gildedrose.GildedRose.QUALITY_MIN_LIMIT;
import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    @Test
    void foo() {
        Item[] items = new Item[] {
            new Item("Aged Brie", 2, 10),
            new Item("Aged Brie", 3, QUALITY_MAX_LIMIT - 1),
            new Item("Sulfuras", 3, 80),
            new Item("Backstage passes", 5, 10),
            new Item("Conjured", 3, 4),
            new Item("Conjured", 0, 5),
            new Item("Backstage passes", 11, 10),
            new Item("default1", 1, QUALITY_MIN_LIMIT),
            new Item("default2", -1, QUALITY_MIN_LIMIT),
            new Item("default3", -1, 2),
            new Item("Aged Brie", 3, QUALITY_MAX_LIMIT),
            new Item("Backstage passes", 0, 10),
            new Item("Backstage passes", 12, 1)
        };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        System.out.println(app);
        assertEquals(11, items[0].quality);
        assertEquals(1, items[0].sellIn);
        assertEquals(QUALITY_MAX_LIMIT, items[1].quality);
        assertEquals(2, items[1].sellIn);
        assertEquals(80, items[2].quality);
        assertEquals(3, items[2].sellIn);
        assertEquals(13, items[3].quality);
        assertEquals(4, items[3].sellIn);
        assertEquals(2, items[4].sellIn);
        assertEquals(2, items[4].sellIn);
        assertEquals(1, items[5].quality);
        assertEquals(-1, items[5].sellIn);
        assertEquals(12, items[6].quality);
        assertEquals(10, items[6].sellIn);
        assertEquals(0, items[7].quality);
        assertEquals(0, items[8].quality);
        assertEquals(0, items[9].quality);
        assertEquals(50, items[10].quality);
        assertEquals(0, items[11].quality);
        assertEquals(2, items[12].quality);
    }

}
