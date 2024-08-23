package whapp;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class WhatsAppMngSys {
	static Scanner sc=new Scanner(System.in);
	static EntityManagerFactory emf=Persistence.createEntityManagerFactory("whp");
	static EntityManager em=emf.createEntityManager();
	static EntityTransaction et=em.getTransaction();
	public static void main(String[] args) {
		while(true) {
			System.out.println();
			System.out.println("************************");
			System.out.println("Enter Choice:\n 1. Save new Account..\n 2. Update Account..\n 3. Find Account..\n 4. Delete Account..");
			switch (sc.nextInt()) {
				case 1: saveAccount();
					break;
				case 2: updateAccount();
					break;
				case 3:	findAccount();
					break;
				case 4:	deleteAccount();
					break;
				default:
					System.out.println("Invalid Choice");
			}
		}
	}


	private static void saveAccount() {
		WhatsApp w=new WhatsApp();
		System.out.println("Enter ID");
		w.setId(sc.nextInt());
		System.out.println("Enter UserName");
		w.setUsername(sc.next());
		System.out.println("Enter Email");
		w.setEmail(sc.next());
		System.out.println("Enter Phone Number");
		w.setPhone(sc.nextLong());
		et.begin();
		em.persist(w);
		et.commit();
		System.out.println("Successfully Account Saved............!");
	}
	private static void updateAccount() {
		System.out.println("Enter ID");
		WhatsApp wap=em.find(WhatsApp.class, sc.nextInt());
		System.out.println("Update ?.....\n username\n email\n phone\n");
		switch (sc.next()) {
			case "username":
				System.out.println("Enter User Name to Update");
				wap.setUsername(sc.next());
				break;
			case "email":
				System.out.println("Enter Email to Update");
				wap.setEmail(sc.next());
				break;
			case "phone":
				System.out.println("Enter Phone Number to Update");
				wap.setPhone(sc.nextLong());
				break;
			default:	System.out.println("Invalid Choice or Check Spells");
				break;
		}
		System.out.println(wap);
		et.begin();
		em.merge(wap);
		et.commit();
		System.out.println("Successfully Account Updated............!");
	}
	private static void findAccount() {
		System.out.println("Enter ID");
		WhatsApp wap=em.find(WhatsApp.class, sc.nextInt());
		System.out.println(wap);
	}
	private static void deleteAccount() {
		System.out.println("Enter ID");
		WhatsApp wap=em.find(WhatsApp.class, sc.nextInt());
		et.begin();
		em.remove(wap);
		et.commit();
		System.out.println("Successfully Account Deleted............!");
	}
}
