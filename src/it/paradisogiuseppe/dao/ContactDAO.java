package it.paradisogiuseppe.dao;

import java.util.ArrayList;
import java.util.List;
import it.paradisogiuseppe.model.ContactModel;

public class ContactDAO {
	
	private static List<ContactModel> listContacts=new ArrayList<>();;
	private static int ID_MAX=0;
	
	
	public ContactDAO(){
		
		populate();
	}
	
	public static void populate(){
		if(listContacts.size()==0){
			listContacts.add(new ContactModel(1, "Giuseppe1", "Paradiso1", "1111111-1", "giuseppe.paradiso92_1@gmail.com"));
			listContacts.add(new ContactModel(2, "Giuseppe2", "Paradiso2", "1111111-2", "giuseppe.paradiso92_2@gmail.com"));
			listContacts.add(new ContactModel(3, "Giuseppe3", "Paradiso3", "1111111-3", "giuseppe.paradiso92_3@gmail.com"));
			listContacts.add(new ContactModel(4, "Giuseppe4", "Paradiso4", "1111111-4", "giuseppe.paradiso92_4@gmail.com"));
			listContacts.add(new ContactModel(5, "Giuseppe5", "Paradiso5", "1111111-5", "giuseppe.paradiso92_5@gmail.com"));
			listContacts.add(new ContactModel(6, "Giuseppe6", "Paradiso6", "1111111-6", "giuseppe.paradiso92_6@gmail.com"));
			listContacts.add(new ContactModel(7, "Giuseppe7", "Paradiso7", "1111111-7", "giuseppe.paradiso92_7@gmail.com"));
			listContacts.add(new ContactModel(8, "Giuseppe8", "Paradiso8", "1111111-8", "giuseppe.paradiso92_8@gmail.com"));
			listContacts.add(new ContactModel(9, "Giuseppe9", "Paradiso9", "1111111-9", "giuseppe.paradiso92_9@gmail.com"));
			listContacts.add(new ContactModel(10, "Giuseppe10", "Paradiso10", "1111111-10", "giuseppe.paradiso92_10@gmail.com"));
			ID_MAX=11;
		}
	}
	
	public static int getIdMax(){return ID_MAX;}
	
	public static ContactModel getContactById(int id){
		ContactModel contact=new ContactModel();
		boolean fine=false;
		int i=0;
		while(!fine){
			if(listContacts.get(i).getId()==id){
				fine=true;
				contact=listContacts.get(i);
			}
			i++;
		}
		return contact;
	}
	
	public static List<ContactModel> getContacts(){
		return listContacts;
	}
	
	public static ContactModel updateContact(ContactModel contact){
		boolean fine=false;
		int i=0;
		while(!fine){
			if(listContacts.get(i).getId()==contact.getId()){
				fine=true;
//				listContacts.remove(i);
//				listContacts.add(i, contact);
				listContacts.set(i, contact);
			}
			i++;
		}
		return contact;
	}
	
	public static void deleteContact(int id){
		boolean fine=false;
		int i=0;
		while(!fine){
			if(listContacts.get(i).getId()==id){
				fine=true;
			}
			i++;
		}
		listContacts.remove(i-1);
	}
	public static void addContact(ContactModel contact){
		listContacts.add(contact);
		ID_MAX++;
	}
}
