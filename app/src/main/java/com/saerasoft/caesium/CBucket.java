package com.saerasoft.caesium;


import android.support.annotation.NonNull;

import java.util.ArrayList;
import java.util.Comparator;

class CBucket implements Comparable<CBucket> {
    public enum SortOrder {ITEMS_SIZE, SIZE}

    private Integer id;
    private ArrayList<CImage> imagesList;
    private int size;
    private long itemsSize;
    private String name;
    private SortOrder order = SortOrder.ITEMS_SIZE;
    private boolean checked;


    CBucket(int id, String name) {
        this.id = id;
        this.name = name;

        this.imagesList = new ArrayList<>();
        this.size = getSize();
        this.itemsSize = getItemsSize();
        this.checked = true;
    }

    /* -- Getters and Setters -- */

    public Integer getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ArrayList<CImage> getImagesList() {
        return imagesList;
    }

    public void setImagesList(ArrayList<CImage> imagesList) {
        this.imagesList = imagesList;
    }

    public int getSize() {
        if (imagesList != null) {
            size = imagesList.size();
        } else {
            size = 0;
        }
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public long getItemsSize() {
        if (imagesList != null) {
            long totalSize = 0;
            for (CImage image : imagesList) {
                totalSize += image.getSize();
            }
            itemsSize = totalSize;
        } else {
            itemsSize = 0;
        }
        return itemsSize;
    }

    public void setItemsSize(long itemsSize) {
        this.itemsSize = itemsSize;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public SortOrder getOrder() {
        return order;
    }

    public void setOrder(SortOrder order) {
        this.order = order;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    @Override
    public int compareTo(@NonNull CBucket o) {
        switch (this.getOrder()) {
            case SIZE:
                return (o.getSize() - this.getSize());
            case ITEMS_SIZE:
            default:
                return (int) Math.signum((o.getItemsSize() - this.getItemsSize()));
        }
    }
}