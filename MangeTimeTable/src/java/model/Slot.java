/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author nhatbeo
 */
public class Slot {

    private int id;
    private String slotName;

    public Slot() {
    }

    public Slot(int id, String slotName) {
        this.id = id;
        this.slotName = slotName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSlotName() {
        return slotName;
    }

    public void setSlotName(String slotName) {
        this.slotName = slotName;
    }

    @Override
    public String toString() {
        return "Slot{" + "id=" + id + ", slotName=" + slotName + '}';
    }
    
}
