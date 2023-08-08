package com.gildedrose;

class GildedRose {
    Item[] items;

    public static final int QUALITY_MAX_LIMIT = 50;

    public static final int QUALITY_MIN_LIMIT = 0;

    public static final int QUALITY_CHANGE_SPEED = 1;

    public static final int QUALITY_EXPIRE_CHANGE_SPEED = QUALITY_CHANGE_SPEED * 2;

    public static final int EXPIRE_SELLIN = 0;


    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for(Item item : items){
            updateItemQuality(item);
        }
    }

    private void updateItemQuality(Item item){
        if("Aged Brie".equals(item.name)){
            updateAgedBrie(item);
        } else if("Sulfuras".equals(item.name)){
            updateSulfuras(item);
        } else if("Backstage passes".equals(item.name)){
            updateBackstagePasses(item);
        } else if("Conjured".equals(item.name)){
            updateConjured(item);
        } else{
            updateDefaultItem(item);
        }
    }

    private void updateDefaultItem(Item item){
        item.sellIn --;
        if(item.sellIn < EXPIRE_SELLIN){
            item.quality = item.quality - QUALITY_EXPIRE_CHANGE_SPEED;
        } else {
            item.quality = item.quality - QUALITY_CHANGE_SPEED;
        }
        item.quality = Math.max(item.quality, QUALITY_MIN_LIMIT);
    }

    private void updateAgedBrie(Item item){
        item.sellIn --;
        item.quality = Math.min(item.quality + QUALITY_CHANGE_SPEED, QUALITY_MAX_LIMIT);
    }

    private void updateSulfuras(Item item){

    }

    private void updateBackstagePasses(Item item){
        item.sellIn --;
        if(item.sellIn < EXPIRE_SELLIN){
            item.quality = QUALITY_MIN_LIMIT;
        } else {
            int backstagePasses1th = 5;
            int backstagePasses2th = 10;
            if(item.sellIn <= backstagePasses1th){
                item.quality = item.quality + 3;
            } else if(item.sellIn <= backstagePasses2th){
                item.quality = item.quality + 2;
            } else{
                item.quality = item.quality + QUALITY_CHANGE_SPEED;
            }
            item.quality = Math.min(item.quality, QUALITY_MAX_LIMIT);
        }
    }

    private void updateConjured(Item item){
        item.sellIn --;
        if(item.sellIn < EXPIRE_SELLIN){
            item.quality = item.quality - QUALITY_EXPIRE_CHANGE_SPEED * 2;
        } else {
            item.quality = item.quality - QUALITY_CHANGE_SPEED * 2;
        }
        item.quality = Math.max(item.quality, QUALITY_MIN_LIMIT);
    }
}
