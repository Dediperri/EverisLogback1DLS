package com.everis.EverisLogback1DLS;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
	//Creación del LOGGER
	final static Logger LOGGER = LoggerFactory.getLogger(App.class);
	
	//Creación de la lista de items
	private static List<String> items = new ArrayList<>();
	
	
	//Variables hardcoded
	final static String consumable = "consumable";
	final static String weapon = "weapon";
	final static String ammo = "ammo";
	final static String material = "material";

	
	//Creo una variables scanner
	static Scanner input = new Scanner(System.in);
	
	/** Clase main */
    public static void main( String[] args )
    {
    	//Aqui simplemente introduzco el nombre, descripcion y el index de un objeto
        LOGGER.info("Se inicia el metodo main");
        System.out.println("Introduce el nombre del objeto nuevo: ");
        String itemName = input.nextLine();
        System.out.println("Introduce la descripción del objeto nuevo: ");
        String itemDesc = input.nextLine();
        System.out.println("Introduce el numero del objeto (1-Consumable 2-Weapon 3-Ammo 4-Material)");
        //Con un try catch compruebo si el itemIndex no es nulo y es un numero
        int itemIndex = 0;
        try {
        	itemIndex = Integer.parseInt(input.nextLine());
		} catch (Exception e) {
			LOGGER.error("Item index is not a number or its null");
		}
        
        
        
        //Creo los objetos
        String itemCreated = createItem(itemName, itemDesc, itemIndex);
        LOGGER.trace("New item Created: {}", itemCreated);
        
        String itemCreated2 = createItem("Wood", "Wood from a tree", 4);
        LOGGER.trace("New item Created: {}", itemCreated2);
        
        //Añado los objetos a la lista
        items.add(itemCreated);
        LOGGER.trace("New item Added: {} , into list: items", itemCreated);
        items.add(itemCreated2);
        LOGGER.trace("New item Added: {} , into list: items", itemCreated2);
        
        // For para comprobar el logger
        for (int i = 0; i < 5000; i++) {
			LOGGER.debug("Linea numero: {}", i);
		}
        
        
    }
    
    /** Metodo que mediate un index regresa un string con el tipo de objeto*/
    
    public static String itemIndex(int type) {
    	
    	String index = ""; 
    	
    	switch(type) {
    		case 1: 
    			index = consumable;
    			break;
    		case 2:
    			index = weapon;
    			break;
    		case 3:
    			index = ammo;
    			break;
    		case 4:
    			index = material;
    			break;
    		default: 
    			index = consumable;
    			LOGGER.warn("WARNING - ITEM TYPE NO DEFINED OR ITS VALUE IS NOT CORRECT - DEFAULT INDEX CONSUMABLE");
    	}
    	
    	return index;
    }
    
    /** Metodo que crea una concatenacion del nombre, descripcion y el tipo de objeto que introduzcamos */
    public static String createItem(String itemName, String itemDescription, int itemIndex) {
    	
    	
    	String itemValue = "";
    	
    	try {
    		
        	itemValue = "Item Name: " + itemName + ", Item Description: " + itemDescription + ", Item Index: " + itemIndex(itemIndex);

		} catch (Exception e) {
			
			LOGGER.error("ERROR - ItemValue failed");
		}  	
    	
    	LOGGER.debug("Item created: {}", itemValue);
    	
    	return itemValue;
    	
    }
    
    
}
