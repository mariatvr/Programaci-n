package Ejercicio1Tarea1;

import java.util.ArrayList;

public class TelefonoMovil {
    protected String myNumber;
    private ArrayList<Contacto> myContacts;

    public TelefonoMovil(String myNumber){
        this.myNumber=myNumber;
        this.myContacts= new ArrayList<Contacto>();
    }

    private int findContact (Contacto c){
        return this.myContacts.indexOf(c);
    }

    private int findContact (String contactName){
        for (int i=0; i<this.myContacts.size(); i++){
            Contacto contacto = this.myContacts.get(i);
            if (contacto.getName().equals(contactName)) {
                return i;
            }
        }
        return -1;
    }

    public boolean addNewContact (Contacto c){
        if (findContact(c.getName()) >= 0) {
            System.out.println("El contacto ya existe.");
            return false;
        }
        myContacts.add(c);
        return true;
    }

    public boolean updateContact (Contacto oldContact, Contacto newContact){
        int position = findContact(oldContact.getName());
        if (position <0){
            System.out.println("El contacto no existe.");
            return false;
        } else if (findContact(newContact.getName())>=0){
            System.out.println("El contacto que quieres introducir nuevo ya existe.");
            return false;
        } else {
            this.myContacts.set(position, newContact);
            System.out.println("El contacto "+oldContact.getName()+ " ha sido actualizado.");
            return true;
        }
    }

    public boolean removeContact (Contacto c){
        if (findContact(c.getName()) < 0) {
            System.out.println("El contacto no existe.");
            return false;
        }
        this.myContacts.remove(findContact(c.getName()));
        System.out.println("El contacto ha sido eliminado con éxito.");
        return true;
    }

    public Contacto queryContact (String nombre){
        int position = findContact(nombre);
        if (position >= 0) {
            return this.myContacts.get(position);
        }
        return null;
    }

    public void printContacts() {
        System.out.println("Lista de contactos:");
        for (int i = 0; i < this.myContacts.size(); i++) {
            System.out.println((i + 1) + ". " +
                    this.myContacts.get(i).getName() + " -> " +
                    this.myContacts.get(i).getPhoneNumber());
        }
    }
}
