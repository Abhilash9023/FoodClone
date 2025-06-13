package com.food.daoimpl;

import java.util.*;
import com.food.model.Cartitem;

public class cart {
    Map<Integer, Cartitem> menus;

    public cart() {
        menus = new HashMap<>();
    }

    public void addItem(Cartitem menu) {
        if (menus.containsKey(menu.getMenuid())) {
            Cartitem cartitem = menus.get(menu.getMenuid());
            int newQuantity = cartitem.getQuantity() + menu.getQuantity();
            cartitem.setQuantity(newQuantity);
        } else {
            menus.put(menu.getMenuid(), menu);
        }
    }

    public void updateItem(int menuid, int newQuantity) {
        if (menus.containsKey(menuid)) {
            Cartitem item = menus.get(menuid);
            item.setQuantity(newQuantity);
        }
    }

    public void removeItem(int menuid) {
        menus.remove(menuid);
    }

    public void clearAllItems() {
        menus.clear();
    }

    public Collection<Cartitem> getCartItems() {
        return menus.values();
    }

}
